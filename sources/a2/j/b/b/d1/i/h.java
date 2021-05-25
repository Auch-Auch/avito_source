package a2.j.b.b.d1.i;

import android.os.ConditionVariable;
import com.google.android.exoplayer2.upstream.cache.SimpleCache;
public class h extends Thread {
    public final /* synthetic */ ConditionVariable a;
    public final /* synthetic */ SimpleCache b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public h(SimpleCache simpleCache, String str, ConditionVariable conditionVariable) {
        super(str);
        this.b = simpleCache;
        this.a = conditionVariable;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        synchronized (this.b) {
            this.a.open();
            SimpleCache.a(this.b);
            this.b.b.onCacheInitialized();
        }
    }
}
