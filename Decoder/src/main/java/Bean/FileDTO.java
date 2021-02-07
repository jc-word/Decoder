package Bean;

import java.io.File;

public class FileDTO {
    private File file;

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    @Override
    public String toString() {
        return "FileDTO{" +
                "file=" + file +
                '}';
    }
}
