package a2.j.e.d.d.a;

import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.common.CrashlyticsCore;
import java.util.concurrent.Callable;
public class g0 implements Callable<Boolean> {
    public final /* synthetic */ CrashlyticsCore a;

    public g0(CrashlyticsCore crashlyticsCore) {
        this.a = crashlyticsCore;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.concurrent.Callable
    public Boolean call() throws Exception {
        u uVar = this.a.h;
        boolean z = true;
        if (!uVar.d.b().exists()) {
            String g = uVar.g();
            if (g == null || !uVar.p.hasCrashDataForSession(g)) {
                z = false;
            }
        } else {
            Logger.getLogger().d("Found previous crash marker.");
            uVar.d.b().delete();
        }
        return Boolean.valueOf(z);
    }
}
