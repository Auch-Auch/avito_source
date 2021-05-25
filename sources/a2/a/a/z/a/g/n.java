package a2.a.a.z.a.g;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
public final class n extends Lambda implements Function1<Throwable, Boolean> {
    public static final n a = new n();

    public n() {
        super(1);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Boolean invoke(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        return Boolean.TRUE;
    }
}
