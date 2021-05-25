package a2.j.e.b;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeoutException;
public final class b implements Callable<String> {
    public final /* synthetic */ FirebaseAnalytics a;

    public b(FirebaseAnalytics firebaseAnalytics) {
        this.a = firebaseAnalytics;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.concurrent.Callable
    public final /* synthetic */ String call() throws Exception {
        String b = this.a.b();
        if (b != null) {
            return b;
        }
        String zzh = this.a.a.zzh();
        if (zzh != null) {
            this.a.a(zzh);
            return zzh;
        }
        throw new TimeoutException();
    }
}
