package a2.a.a.e0;

import io.reactivex.functions.Predicate;
import kotlin.jvm.internal.Intrinsics;
public final class j<T> implements Predicate<String> {
    public static final j a = new j();

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Predicate
    public boolean test(String str) {
        String str2 = str;
        Intrinsics.checkNotNullParameter(str2, "it");
        return str2.length() > 0;
    }
}
