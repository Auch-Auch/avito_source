package a2.j.b.e.a.b;

import a2.b.a.a.a;
import com.google.android.play.core.internal.aa;
import java.io.File;
import java.io.IOException;
public final class t1 {
    public static final aa b = new aa("MergeSliceTaskHandler");
    public final a0 a;

    public t1(a0 a0Var) {
        this.a = a0Var;
    }

    public static void b(File file, File file2) {
        if (file.isDirectory()) {
            file2.mkdirs();
            File[] listFiles = file.listFiles();
            for (File file3 : listFiles) {
                b(file3, new File(file2, file3.getName()));
            }
            if (!file.delete()) {
                String valueOf = String.valueOf(file);
                throw new q0(a.t(new StringBuilder(valueOf.length() + 28), "Unable to delete directory: ", valueOf));
            }
        } else if (file2.exists()) {
            String valueOf2 = String.valueOf(file2);
            throw new q0(a.t(new StringBuilder(valueOf2.length() + 51), "File clashing with existing file from other slice: ", valueOf2));
        } else if (!file.renameTo(file2)) {
            String valueOf3 = String.valueOf(file);
            throw new q0(a.t(new StringBuilder(valueOf3.length() + 21), "Unable to move file: ", valueOf3));
        }
    }

    public final void a(s1 s1Var) {
        File i = this.a.i(s1Var.b, s1Var.c, s1Var.d, s1Var.e);
        if (i.exists()) {
            File j = this.a.j(s1Var.b, s1Var.c, s1Var.d);
            if (!j.exists()) {
                j.mkdirs();
            }
            b(i, j);
            try {
                this.a.e(s1Var.b, s1Var.c, s1Var.d, this.a.o(s1Var.b, s1Var.c, s1Var.d) + 1);
            } catch (IOException e) {
                b.b("Writing merge checkpoint failed with %s.", e.getMessage());
                throw new q0("Writing merge checkpoint failed.", e, s1Var.a);
            }
        } else {
            throw new q0(String.format("Cannot find verified files for slice %s.", s1Var.e), s1Var.a);
        }
    }
}
