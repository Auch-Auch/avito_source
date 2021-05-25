package org.kodein.di.generic;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.kodein.di.Typed;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\u0010\u0005\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000\"\n\b\u0001\u0010\u0002\u0018\u0001*\u00020\u0001H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "", "T", "invoke", "()Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 0})
public final class GKodeinAwareKt$instance$2 extends Lambda implements Function0<A> {
    public final /* synthetic */ Typed a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GKodeinAwareKt$instance$2(Typed typed) {
        super(0);
        this.a = typed;
    }

    @Override // kotlin.jvm.functions.Function0
    public final A invoke() {
        return (A) this.a.getValue();
    }
}
