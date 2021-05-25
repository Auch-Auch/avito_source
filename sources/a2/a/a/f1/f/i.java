package a2.a.a.f1.f;

import com.avito.android.in_app_calls.service.CallManagerServiceDelegate;
import io.reactivex.Completable;
import io.reactivex.CompletableSource;
import io.reactivex.functions.Function;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;
public final class i<T, R> implements Function<Boolean, CompletableSource> {
    public final /* synthetic */ CallManagerServiceDelegate.h a;

    public i(CallManagerServiceDelegate.h hVar) {
        this.a = hVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public CompletableSource apply(Boolean bool) {
        Boolean bool2 = bool;
        Intrinsics.checkNotNullParameter(bool2, "wasHangup");
        if (bool2.booleanValue()) {
            return Completable.timer(5, TimeUnit.SECONDS, this.a.b.computation()).doOnComplete(new h(this));
        }
        return Completable.complete();
    }
}
