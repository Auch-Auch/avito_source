package defpackage;

import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: java-style lambda group */
/* renamed from: i  reason: default package */
public final class i<T, R> implements Function<Throwable, Boolean> {
    public static final i b = new i(0);
    public static final i c = new i(1);
    public static final i d = new i(2);
    public final /* synthetic */ int a;

    public i(int i) {
        this.a = i;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public final Boolean apply(Throwable th) {
        int i = this.a;
        if (i == 0) {
            Intrinsics.checkNotNullParameter(th, "it");
            return Boolean.TRUE;
        } else if (i == 1) {
            Intrinsics.checkNotNullParameter(th, "it");
            return Boolean.TRUE;
        } else if (i == 2) {
            Intrinsics.checkNotNullParameter(th, "it");
            return Boolean.TRUE;
        } else {
            throw null;
        }
    }
}
