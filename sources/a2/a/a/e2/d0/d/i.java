package a2.a.a.e2.d0.d;

import io.reactivex.rxjava3.functions.BiPredicate;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
public final class i<T1, T2> implements BiPredicate<Pair<? extends String, ? extends String>, Pair<? extends String, ? extends String>> {
    public static final i a = new i();

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.BiPredicate
    public boolean test(Pair<? extends String, ? extends String> pair, Pair<? extends String, ? extends String> pair2) {
        Pair<? extends String, ? extends String> pair3 = pair;
        Pair<? extends String, ? extends String> pair4 = pair2;
        return Intrinsics.areEqual((String) pair3.getFirst(), (String) pair4.getFirst()) && Intrinsics.areEqual((String) pair3.getSecond(), (String) pair4.getSecond());
    }
}
