package defpackage;

import io.reactivex.rxjava3.functions.Predicate;
import kotlin.jvm.internal.Intrinsics;
import t6.y.m;
/* compiled from: java-style lambda group */
/* renamed from: f  reason: default package */
public final class f<T> implements Predicate<String> {
    public static final f b = new f(0);
    public static final f c = new f(1);
    public final /* synthetic */ int a;

    public f(int i) {
        this.a = i;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Predicate
    public final boolean test(String str) {
        int i = this.a;
        boolean z = false;
        if (i == 0) {
            String str2 = str;
            Intrinsics.checkNotNullExpressionValue(str2, "it");
            if ((str2.length() == 0) || !(!m.isBlank(str2))) {
                return false;
            }
            return true;
        } else if (i == 1) {
            String str3 = str;
            Intrinsics.checkNotNullExpressionValue(str3, "it");
            if (str3.length() == 0) {
                z = true;
            }
            return !z;
        } else {
            throw null;
        }
    }
}
