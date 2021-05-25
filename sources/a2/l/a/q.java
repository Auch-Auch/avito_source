package a2.l.a;

import com.my.target.ia;
public class q implements Runnable {
    public final /* synthetic */ ia a;

    public q(ia iaVar) {
        this.a = iaVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        ia.a aVar = this.a.b;
        if (aVar != null) {
            aVar.i(true);
            this.a.b = null;
        }
    }
}
