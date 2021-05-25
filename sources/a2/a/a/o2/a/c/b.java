package a2.a.a.o2.a.c;

import com.avito.android.service.short_task.metrics.Metric;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
public final class b<T, R> implements Function<List<? extends Metric>, ObservableSource<? extends Metric>> {
    public static final b a = new b();

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public ObservableSource<? extends Metric> apply(List<? extends Metric> list) {
        List<? extends Metric> list2 = list;
        Intrinsics.checkNotNullParameter(list2, "metricsList");
        return Observable.fromIterable(list2);
    }
}
