package a2.g.k;

import com.facebook.appevents.internal.AppEventUtility;
public final class g implements Runnable {
    @Override // java.lang.Runnable
    public void run() {
        t tVar;
        e eVar = f.b;
        int i = l.a;
        synchronized (l.class) {
            AppEventUtility.assertIsNotMainThread();
            s a = l.a();
            for (a aVar : eVar.b()) {
                synchronized (eVar) {
                    tVar = eVar.a.get(aVar);
                }
                a.a(aVar, tVar.b());
            }
            l.b(a);
        }
        f.b = new e();
    }
}
