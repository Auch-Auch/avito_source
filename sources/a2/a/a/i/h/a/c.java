package a2.a.a.i.h.a;

import arrow.core.Option;
import com.avito.android.analytics.provider.clickstream.ClickStreamEvent;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
public final class c<T, R> implements Function<Option<? extends ClickStreamEvent>, ClickStreamEvent> {
    public static final c a = new c();

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public ClickStreamEvent apply(Option<? extends ClickStreamEvent> option) {
        Option<? extends ClickStreamEvent> option2 = option;
        Intrinsics.checkNotNullParameter(option2, "it");
        return (ClickStreamEvent) option2.get();
    }
}
