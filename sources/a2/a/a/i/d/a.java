package a2.a.a.i.d;

import com.avito.android.analytics.clickstream.ClickStreamSenderImpl;
import java.util.List;
import java.util.concurrent.Callable;
import proto.events.apps.EventOuterClass;
public final class a<V> implements Callable<List<? extends EventOuterClass.Event>> {
    public final /* synthetic */ ClickStreamSenderImpl a;

    public a(ClickStreamSenderImpl clickStreamSenderImpl) {
        this.a = clickStreamSenderImpl;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.concurrent.Callable
    public List<? extends EventOuterClass.Event> call() {
        return this.a.f.extractAll();
    }
}
