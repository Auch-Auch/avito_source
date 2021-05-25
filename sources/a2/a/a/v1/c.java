package a2.a.a.v1;

import com.avito.android.phone_confirmation.PhoneConfirmationBinderKt;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
public final class c<T, R> implements Function<Long, Long> {
    public final /* synthetic */ PhoneConfirmationBinderKt.j a;
    public final /* synthetic */ Long b;

    public c(PhoneConfirmationBinderKt.j jVar, Long l) {
        this.a = jVar;
        this.b = l;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public Long apply(Long l) {
        Intrinsics.checkNotNullParameter(l, "it");
        return Long.valueOf(this.b.longValue() - this.a.b.getTimeSource().now());
    }
}
