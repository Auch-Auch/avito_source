package a2.j.e.d.d.a;

import android.os.Bundle;
import java.util.concurrent.Callable;
public class x implements Callable<Void> {
    public final /* synthetic */ long a;
    public final /* synthetic */ u b;

    public x(u uVar, long j) {
        this.b = uVar;
        this.a = j;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.concurrent.Callable
    public Void call() throws Exception {
        Bundle bundle = new Bundle();
        bundle.putInt("fatal", 1);
        bundle.putLong("timestamp", this.a);
        this.b.s.logEvent("_ae", bundle);
        return null;
    }
}
