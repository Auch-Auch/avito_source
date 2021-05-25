package a2.a.a.t0;

import io.reactivex.rxjava3.functions.Function;
import kotlin.jvm.internal.Intrinsics;
public final class n0<T, R> implements Function<Integer, Integer> {
    public final /* synthetic */ Integer a;

    public n0(Integer num) {
        this.a = num;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public Integer apply(Integer num) {
        int intValue = num.intValue();
        Integer num2 = this.a;
        Intrinsics.checkNotNullExpressionValue(num2, "added");
        return Integer.valueOf(num2.intValue() + intValue);
    }
}
