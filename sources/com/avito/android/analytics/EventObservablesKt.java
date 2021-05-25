package com.avito.android.analytics;

import com.avito.android.util.Initializable;
import com.avito.android.util.InitializeOperator;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u001a/\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/avito/android/analytics/Event;", "T", "Lio/reactivex/Observable;", "", "parameter", "initialize", "(Lio/reactivex/Observable;Ljava/lang/Object;)Lio/reactivex/Observable;", "analytics-core_release"}, k = 2, mv = {1, 4, 2})
public final class EventObservablesKt {
    /* JADX DEBUG: Type inference failed for r1v1. Raw type applied. Possible types: io.reactivex.Observable<R>, java.lang.Object, io.reactivex.Observable<T extends com.avito.android.analytics.Event> */
    @NotNull
    public static final <T extends Event> Observable<T> initialize(@NotNull Observable<T> observable, @NotNull Object obj) {
        Intrinsics.checkNotNullParameter(observable, "$this$initialize");
        Intrinsics.checkNotNullParameter(obj, "parameter");
        if (!(obj instanceof Initializable)) {
            obj = null;
        }
        Initializable initializable = (Initializable) obj;
        if (initializable == null) {
            return observable;
        }
        Observable observable2 = (Observable<R>) observable.lift(new InitializeOperator(initializable));
        Intrinsics.checkNotNullExpressionValue(observable2, "lift<T>(com.avito.androi…eOperator(initializable))");
        return observable2;
    }
}
