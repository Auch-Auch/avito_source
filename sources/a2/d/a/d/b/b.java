package a2.d.a.d.b;

import a2.d.a.d.b.a;
public class b implements Runnable {
    public final /* synthetic */ a a;

    public b(a aVar) {
        this.a = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        a aVar = this.a;
        while (!aVar.f) {
            try {
                aVar.b((a.b) aVar.d.remove());
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
