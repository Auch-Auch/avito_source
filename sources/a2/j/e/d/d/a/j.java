package a2.j.e.d.d.a;

import java.io.File;
import java.io.FilenameFilter;
public final /* synthetic */ class j implements FilenameFilter {
    public static final j a = new j();

    @Override // java.io.FilenameFilter
    public boolean accept(File file, String str) {
        FilenameFilter filenameFilter = u.z;
        return str.startsWith(".ae");
    }
}
