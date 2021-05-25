package a2.a.a.i.h.a;

import arrow.core.Option;
import com.avito.android.analytics.ErrorEvent;
import com.avito.android.analytics.provider.clickstream.ClickStreamEvent;
import com.avito.android.analytics.provider.clickstream.ClickStreamEventObserver;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
public final class a<T, R> implements Function<ErrorEvent, Option<? extends ClickStreamEvent>> {
    public final /* synthetic */ ClickStreamEventObserver a;

    public a(ClickStreamEventObserver clickStreamEventObserver) {
        this.a = clickStreamEventObserver;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public Option<? extends ClickStreamEvent> apply(ErrorEvent errorEvent) {
        ErrorEvent errorEvent2 = errorEvent;
        Intrinsics.checkNotNullParameter(errorEvent2, "it");
        return Option.Companion.fromNullable(ClickStreamEventObserver.access$convertErrorEvent(this.a, errorEvent2));
    }
}
