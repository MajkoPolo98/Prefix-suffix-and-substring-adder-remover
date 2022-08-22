package files;

import java.io.File;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FilesCommander {

    public static Set<File> getFilesFromDirectory(String path) {
        return Stream.of(new File(path).listFiles())
                .filter(file -> !file.isDirectory())
                .collect(Collectors.toSet());
    }

    public static void addSubstringToIndex(File file, String substring, int index) {
            StringBuilder fname = new StringBuilder(file.getName());
        fname.insert(index, substring);
        file.renameTo(new File(file.getParent() + "\\" + fname));
    }


    public static void replaceSubstring(String path, String existingSubstring, String finalSubstring) {
        getFilesFromDirectory(path).forEach(file -> {
            StringBuilder fname = new StringBuilder(file.getName());
            StringBuilder fpath = new StringBuilder(path);
            int index = fname.indexOf(existingSubstring);
            if(index != -1) {
                fname.replace(index, index + existingSubstring.length(), finalSubstring);
                fpath.append("\\" + fname);
                file.renameTo(new File(fpath.toString()));
            }
        });
    }

    public static void addPrefix(String path, String prefix) {
        getFilesFromDirectory(path).forEach(file -> addSubstringToIndex(file, prefix, 0));
    }

    public static void addSuffix(String path, String prefix) {
        getFilesFromDirectory(path).forEach(file -> addSubstringToIndex(file, prefix, file.getName().lastIndexOf(".")));
    }
}
