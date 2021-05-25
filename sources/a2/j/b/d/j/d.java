package a2.j.b.d.j;

import androidx.appcompat.app.AppCompatDelegateImpl;
public class d implements Runnable {
    public final /* synthetic */ long a;
    public final /* synthetic */ c b;

    public d(c cVar, long j) {
        this.b = cVar;
        this.a = j;
    }

    @Override // java.lang.Runnable
    public void run() {
        c cVar = this.b;
        cVar.a.setError(String.format(cVar.d, AppCompatDelegateImpl.i.s0(this.a)));
        this.b.a();
    }
}
