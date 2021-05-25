package a2.a.a.n3.z;

import com.avito.android.util.rx3.ErrorAndDuration;
import com.avito.android.util.rx3.RetryWhenKt;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.functions.Function;
import java.util.concurrent.TimeUnit;
public final class j<T, R> implements Function<ErrorAndDuration, Flowable<ErrorAndDuration>> {
    public final /* synthetic */ Scheduler a;

    public j(Scheduler scheduler) {
        this.a = scheduler;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public Flowable<ErrorAndDuration> apply(ErrorAndDuration errorAndDuration) {
        ErrorAndDuration errorAndDuration2 = errorAndDuration;
        if (errorAndDuration2.getDurationMs() == RetryWhenKt.access$getNO_MORE_DELAYS$p()) {
            return Flowable.error(errorAndDuration2.getThrowable());
        }
        return Flowable.timer(errorAndDuration2.getDurationMs(), TimeUnit.MILLISECONDS, this.a).map(new i(errorAndDuration2));
    }
}
