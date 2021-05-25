package org.kodein.di;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0010\u0006\u001a\u00028\u0001\"\u0004\b\u0000\u0010\u0000\"\b\b\u0001\u0010\u0002*\u00020\u0001H\n¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "L;", "T", "invoke", "()Ljava/lang/Object;", "org/kodein/di/CurryKt$toProvider$1", "<anonymous>"}, k = 3, mv = {1, 4, 0})
public final class KodeinContainer$provider$$inlined$toProvider$1 extends Lambda implements Function0<T> {
    public final /* synthetic */ Function1 a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public KodeinContainer$provider$$inlined$toProvider$1(Function1 function1) {
        super(0);
        this.a = function1;
    }

    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final T invoke() {
        return (T) this.a.invoke(Unit.INSTANCE);
    }
}
