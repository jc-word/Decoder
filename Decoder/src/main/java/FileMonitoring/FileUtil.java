package FileMonitoring;


import Bean.FileDTO;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;


public class FileUtil {

    /**
     * 获取文件夹大小
     */
    public static Long getDirectorySize(String filePath) {
        return FileUtils.sizeOfDirectory(new File(filePath));
    }

    /**
     * 读取某个文件夹下的所有文件(支持多级文件夹)
     */
    public static List<FileDTO> getFile(String filepath, List<FileDTO> fileList) {
        File file = new File(filepath);
        String newpath = filepath.replaceFirst("breakData", "breakData_temp");
        if (!(new File(newpath).exists())) {
            new File(newpath).mkdir();
        }
        if (!file.isDirectory() && !(file.getName()).contains("tmp")) {
            if (!(file.getName()).contains("YXSOE")) {
                FileDTO fileDTO = new FileDTO();
                try {
                    fileDTO.setFile(copyFile(filepath, newpath));
                    fileList.add(fileDTO);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else if (file.isDirectory()) {
            String[] filelist = file.list();
            for (int i = 0; i < filelist.length; i++) {
                file = new File(filepath + "\\" + filelist[i]);
                if (!file.isDirectory() && !(file.getName()).contains("tmp")) {
                    if (!(file.getName()).contains("YXSOE")) {
                        FileDTO fileDTO = new FileDTO();
                        try {
                            fileDTO.setFile(copyFile(filepath + "\\" + filelist[i], newpath + "\\" + filelist[i]));
                            fileList.add(fileDTO);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                } else if (file.isDirectory()) {
                    try {
                        copyDir(filepath + "\\" + filelist[i], newpath + "\\" + filelist[i]);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    getFile(filepath + "\\" + filelist[i], fileList);
                }
                deleteFile(file);
            }
        }
        return fileList;
    }

    /**
     * 先根遍历序递归删除文件夹
     *
     * @param dirFile 要被删除的文件或者目录
     * @return 删除成功返回true, 否则返回false
     */
    public static boolean deleteFile(File dirFile) {
        // 如果dir对应的文件不存在，则退出
        if (!dirFile.exists()) {
            return false;
        }

        if (dirFile.isFile()) {
            if (!dirFile.getName().contains("tmp") && !dirFile.getName().contains("YXSOE")) {
                return dirFile.delete();
            } else {
                return false;
            }
        } else {
            for (File file : dirFile.listFiles()) {
                deleteFile(file);
            }
        }
        return dirFile.delete();
    }

    public static void copyDir(String sourcePath, String newPath) throws IOException {
        File file = new File(sourcePath);
        String[] filePath = file.list();

        if (!(new File(newPath)).exists()) {
            (new File(newPath)).mkdir();
        }

        for (int i = 0; i < filePath.length; i++) {
            if ((new File(sourcePath + file.separator + filePath[i])).isDirectory()) {
                copyDir(sourcePath + file.separator + filePath[i], newPath + file.separator + filePath[i]);
            }

            if (new File(sourcePath + file.separator + filePath[i]).isFile()) {
                copyFile(sourcePath + file.separator + filePath[i], newPath + file.separator + filePath[i]);
            }

        }
    }

    public static File copyFile(String oldPath, String newPath) throws IOException {
        File oldFile = new File(oldPath);
        File file = new File(newPath);
        FileInputStream in = new FileInputStream(oldFile);
        FileOutputStream out = new FileOutputStream(file);

        byte[] buffer = new byte[2097152];
        int readByte = 0;
        while ((readByte = in.read(buffer)) != -1) {
            out.write(buffer, 0, readByte);
        }
        in.close();
        out.close();
        return file;
    }
}
