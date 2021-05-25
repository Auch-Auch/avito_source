package a2.a.a.i.h.a;

import arrow.core.Option;
import com.avito.android.analytics.provider.clickstream.ClickStreamEvent;
import io.reactivex.functions.Predicate;
import kotlin.jvm.internal.Intrinsics;
public final class b<T> implements Predicate<Option<? extends ClickStreamEvent>> {
    public static final b a = new b();

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Predicate
    public boolean test(Option<? extends ClickStreamEvent> option) {
        Option<? extends ClickStreamEvent> option2 = option;
        Intrinsics.checkNotNullParameter(option2, "it");
        return option2.nonEmpty();
    }
}
