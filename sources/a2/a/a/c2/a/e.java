package a2.a.a.c2.a;

import io.reactivex.rxjava3.functions.Predicate;
import kotlin.jvm.internal.Intrinsics;
public final class e<T> implements Predicate<String> {
    public static final e a = new e();

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Predicate
    public boolean test(String str) {
        String str2 = str;
        Intrinsics.checkNotNullExpressionValue(str2, "it");
        return str2.length() > 0;
    }
}
