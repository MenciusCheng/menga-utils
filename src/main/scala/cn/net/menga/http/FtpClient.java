package cn.net.menga.http;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Marvel on 18/10/29.
 */
public class FtpClient {

    private String server;
    private int port;
    private String user;
    private String password;
    private FTPClient ftp;

    public FtpClient(String server, int port, String user, String password) {
        this.server = server;
        this.port = port;
        this.user = user;
        this.password = password;
    }

    public void open() throws IOException {
        ftp = new FTPClient();
        //
        ftp.enterLocalPassiveMode();

        ftp.connect(server, port);
        int reply = ftp.getReplyCode();
        if (!FTPReply.isPositiveCompletion(reply)) {
            ftp.disconnect();
            throw new IOException("Exception in connecting to FTP Server");
        }
        ftp.login(user, password);
    }

    public void close() throws IOException {
        ftp.disconnect();
    }

    /**
     * 创建多级文件夹，并且会进入最后一个文件夹
     */
    public void mkDirs(String path) throws IOException {
        String[] dirs = path.split("/");
        if (path.charAt(0) == '/') {
            ftp.changeWorkingDirectory("/");
        }
        for (String dir : dirs) {
            String folder = dir.trim();
            if (folder.length() > 0) {
                ftp.makeDirectory(dir);
                ftp.changeWorkingDirectory(dir);
            }
        }
    }

    /**
     * 上传文件
     * @param folderPath 文件夹路径
     * @param fileName 文件名
     * @param file 文件
     */
    public boolean uploadFile(String folderPath, String fileName, File file) throws IOException {
        mkDirs(folderPath);
        System.out.println("创建文件成功，正在上传文件");
        return ftp.storeFile(folderPath + fileName, new FileInputStream(file));
    }

    Collection<String> listFiles(String path) throws IOException {
        FTPFile[] files = ftp.listFiles(path);
        return Arrays.stream(files)
                .map(FTPFile::getName)
                .collect(Collectors.toList());
    }

    public void mkDirsIfNotExist(String path) throws IOException {
        String[] dirs = path.split("/");

        ftp.changeToParentDirectory();
        for (String dir: dirs) {
            if (dir != null && dir.length() > 0) {
                FTPFile[] ftpDirs = ftp.listDirectories();
                List<String> collect = Arrays.stream(ftpDirs).map(FTPFile::getName).collect(Collectors.toList());
                if (collect.contains(dir)) {
                    System.out.println("dir is existed: " + dir);
                } else {
                    System.out.println("mk " + dir);
                    ftp.makeDirectory(dir);
                }
                System.out.println("cd " + dir);
                ftp.changeWorkingDirectory(dir);
            }
        }
        ftp.changeToParentDirectory();
    }

    void downloadFile(String source, String destination) throws IOException {
        FileOutputStream out = new FileOutputStream(destination);
        ftp.retrieveFile(source, out);
    }

}
