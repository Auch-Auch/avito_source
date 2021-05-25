package l6.h.a;

import l6.h.a.d;
public class a implements Runnable {
    public final /* synthetic */ d.a a;
    public final /* synthetic */ Object b;

    public a(d.a aVar, Object obj) {
        this.a = aVar;
        this.b = obj;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.a = this.b;
    }
}
