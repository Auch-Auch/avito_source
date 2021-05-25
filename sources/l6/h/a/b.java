package l6.h.a;

import android.app.Application;
import l6.h.a.d;
public class b implements Runnable {
    public final /* synthetic */ Application a;
    public final /* synthetic */ d.a b;

    public b(Application application, d.a aVar) {
        this.a = application;
        this.b = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.unregisterActivityLifecycleCallbacks(this.b);
    }
}
