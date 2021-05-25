package a2.g.k;

import com.facebook.appevents.internal.AppEventUtility;
public final class k implements Runnable {
    public final /* synthetic */ a a;
    public final /* synthetic */ t b;

    public k(a aVar, t tVar) {
        this.a = aVar;
        this.b = tVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        a aVar = this.a;
        t tVar = this.b;
        int i = l.a;
        synchronized (l.class) {
            AppEventUtility.assertIsNotMainThread();
            s a3 = l.a();
            if (a3.a.containsKey(aVar)) {
                a3.a.get(aVar).addAll(tVar.b());
            } else {
                a3.a(aVar, tVar.b());
            }
            l.b(a3);
        }
    }
}
