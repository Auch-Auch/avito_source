package defpackage;

import io.reactivex.functions.Predicate;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: java-style lambda group */
/* renamed from: z  reason: default package */
public final class z<T> implements Predicate<Boolean> {
    public static final z b = new z(0);
    public static final z c = new z(1);
    public final /* synthetic */ int a;

    public z(int i) {
        this.a = i;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Predicate
    public final boolean test(Boolean bool) {
        int i = this.a;
        if (i == 0) {
            Boolean bool2 = bool;
            Intrinsics.checkNotNullParameter(bool2, "it");
            return Intrinsics.areEqual(bool2, Boolean.TRUE);
        } else if (i == 1) {
            Boolean bool3 = bool;
            Intrinsics.checkNotNullParameter(bool3, "it");
            return Intrinsics.areEqual(bool3, Boolean.TRUE);
        } else {
            throw null;
        }
    }
}
