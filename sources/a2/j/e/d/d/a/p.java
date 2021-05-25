package a2.j.e.d.d.a;

import a2.j.e.d.d.a.u;
import com.google.firebase.crashlytics.internal.Logger;
import java.io.File;
import java.util.HashSet;
import java.util.Objects;
public class p implements Runnable {
    public final /* synthetic */ u a;

    public p(u uVar) {
        this.a = uVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        u uVar = this.a;
        File[] p = uVar.p(new u.i());
        Objects.requireNonNull(uVar);
        HashSet hashSet = new HashSet();
        for (File file : p) {
            Logger.getLogger().d("Found invalid session part file: " + file);
            hashSet.add(u.m(file));
        }
        if (!hashSet.isEmpty()) {
            File[] p2 = uVar.p(new q(uVar, hashSet));
            for (File file2 : p2) {
                Logger.getLogger().d("Deleting invalid session file: " + file2);
                file2.delete();
            }
        }
    }
}
