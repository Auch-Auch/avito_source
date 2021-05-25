package a2.j.b.e.a.b;

import java.io.File;
import java.util.ArrayList;
public final /* synthetic */ class i2 implements Runnable {
    public final k2 a;

    public i2(k2 k2Var) {
        this.a = k2Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        k2 k2Var = this.a;
        ArrayList arrayList = (ArrayList) k2Var.a.u();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            File file = (File) arrayList.get(i);
            if (file.listFiles() != null) {
                File[] listFiles = file.listFiles();
                for (File file2 : listFiles) {
                    File file3 = new File(file2, "stale.tmp");
                    if (file3.exists() && System.currentTimeMillis() - file3.lastModified() > a0.e) {
                        a0.n(file2);
                    }
                }
            }
        }
        k2Var.a.m();
        a0 a0Var = k2Var.a;
        if (a0Var.v().exists()) {
            File[] listFiles2 = a0Var.v().listFiles();
            for (File file4 : listFiles2) {
                if (System.currentTimeMillis() - file4.lastModified() > a0.d) {
                    a0.n(file4);
                } else {
                    a0.d(file4);
                }
            }
        }
    }
}
