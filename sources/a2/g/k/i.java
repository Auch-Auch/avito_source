package a2.g.k;

import com.facebook.appevents.AppEvent;
import com.facebook.appevents.AppEventsLogger;
import java.util.concurrent.TimeUnit;
public final class i implements Runnable {
    public final /* synthetic */ a a;
    public final /* synthetic */ AppEvent b;

    public i(a aVar, AppEvent appEvent) {
        this.a = aVar;
        this.b = appEvent;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        int size;
        e eVar = f.b;
        a aVar = this.a;
        AppEvent appEvent = this.b;
        synchronized (eVar) {
            eVar.a(aVar).a(appEvent);
        }
        if (AppEventsLogger.getFlushBehavior() != AppEventsLogger.FlushBehavior.EXPLICIT_ONLY) {
            e eVar2 = f.b;
            synchronized (eVar2) {
                i = 0;
                for (t tVar : eVar2.a.values()) {
                    synchronized (tVar) {
                        size = tVar.a.size();
                    }
                    i += size;
                }
            }
            if (i > 100) {
                f.a(q.EVENT_THRESHOLD);
                return;
            }
        }
        if (f.d == null) {
            f.d = f.c.schedule(f.e, 15, TimeUnit.SECONDS);
        }
    }
}
