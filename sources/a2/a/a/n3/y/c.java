package a2.a.a.n3.y;

import com.avito.android.util.rx.ErrorAndDuration;
import io.reactivex.Flowable;
import io.reactivex.Scheduler;
import io.reactivex.functions.Function;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;
public final class c<T, R> implements Function<ErrorAndDuration, Flowable<ErrorAndDuration>> {
    public final /* synthetic */ Scheduler a;

    public c(Scheduler scheduler) {
        this.a = scheduler;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public Flowable<ErrorAndDuration> apply(ErrorAndDuration errorAndDuration) {
        ErrorAndDuration errorAndDuration2 = errorAndDuration;
        Intrinsics.checkNotNullParameter(errorAndDuration2, "e");
        if (errorAndDuration2.getDurationMs() == -1) {
            return Flowable.error(errorAndDuration2.getThrowable());
        }
        return Flowable.timer(errorAndDuration2.getDurationMs(), TimeUnit.MILLISECONDS, this.a).map(new b(errorAndDuration2));
    }
}
