package defpackage;

import io.reactivex.rxjava3.functions.Predicate;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: java-style lambda group */
/* renamed from: j  reason: default package */
public final class j<T> implements Predicate<Boolean> {
    public static final j b = new j(0);
    public static final j c = new j(1);
    public static final j d = new j(2);
    public final /* synthetic */ int a;

    public j(int i) {
        this.a = i;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Predicate
    public final boolean test(Boolean bool) {
        int i = this.a;
        if (i == 0) {
            Boolean bool2 = bool;
            Intrinsics.checkNotNullExpressionValue(bool2, "it");
            return bool2.booleanValue();
        } else if (i == 1) {
            Boolean bool3 = bool;
            Intrinsics.checkNotNullExpressionValue(bool3, "it");
            return bool3.booleanValue();
        } else if (i == 2) {
            return !bool.booleanValue();
        } else {
            throw null;
        }
    }
}
