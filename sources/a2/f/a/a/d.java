package a2.f.a.a;

import java.util.HashSet;
import java.util.Iterator;
public class d extends Thread {
    public final /* synthetic */ e a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(e eVar, String str) {
        super(str);
        this.a = eVar;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        HashSet hashSet;
        int i;
        synchronized (this.a.d) {
            hashSet = new HashSet(this.a.d);
        }
        Iterator it = hashSet.iterator();
        while (true) {
            i = 0;
            if (!it.hasNext()) {
                break;
            }
            try {
                int parseInt = Integer.parseInt((String) it.next());
                if (this.a.g(null, parseInt)) {
                    it.remove();
                    e.g.i("Deleted job %d which failed to delete earlier", Integer.valueOf(parseInt));
                } else {
                    e.g.e("Couldn't delete job %d which failed to delete earlier", Integer.valueOf(parseInt));
                }
            } catch (NumberFormatException unused) {
                it.remove();
            }
        }
        synchronized (this.a.d) {
            this.a.d.clear();
            if (hashSet.size() > 50) {
                Iterator it2 = hashSet.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    String str = (String) it2.next();
                    int i2 = i + 1;
                    if (i > 50) {
                        break;
                    }
                    this.a.d.add(str);
                    i = i2;
                }
            } else {
                this.a.d.addAll(hashSet);
            }
        }
    }
}
