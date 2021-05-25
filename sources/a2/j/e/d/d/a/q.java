package a2.j.e.d.d.a;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Set;
public class q implements FilenameFilter {
    public final /* synthetic */ Set a;

    public q(u uVar, Set set) {
        this.a = set;
    }

    @Override // java.io.FilenameFilter
    public boolean accept(File file, String str) {
        if (str.length() < 35) {
            return false;
        }
        return this.a.contains(str.substring(0, 35));
    }
}
