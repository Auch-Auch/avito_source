package a2.a.a.h2.a;

import com.avito.android.analytics.event.SavedSearchesCounter;
import io.reactivex.rxjava3.functions.Function;
import kotlin.jvm.internal.Intrinsics;
public final class d<T, R> implements Function<Integer, SavedSearchesCounter> {
    public static final d a = new d();

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public SavedSearchesCounter apply(Integer num) {
        Integer num2 = num;
        Intrinsics.checkNotNullExpressionValue(num2, "it");
        return new SavedSearchesCounter(num2.intValue());
    }
}
