package a2.a.a.i.j;

import com.avito.android.analytics.statsd.StatsdRecord;
import com.avito.android.analytics.statsd.StatsdSenderImpl;
import java.util.List;
import java.util.concurrent.Callable;
public final class a<V> implements Callable<List<? extends StatsdRecord>> {
    public final /* synthetic */ StatsdSenderImpl a;

    public a(StatsdSenderImpl statsdSenderImpl) {
        this.a = statsdSenderImpl;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.concurrent.Callable
    public List<? extends StatsdRecord> call() {
        return this.a.b.extractAll();
    }
}
