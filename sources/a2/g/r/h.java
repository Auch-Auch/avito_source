package a2.g.r;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;
public final class h implements FilenameFilter {
    @Override // java.io.FilenameFilter
    public boolean accept(File file, String str) {
        return Pattern.matches("cpu[0-9]+", str);
    }
}
