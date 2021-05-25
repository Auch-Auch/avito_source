package org.kodein.di;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\u0010\u0005\u001a\u00028\u0001\"\u0004\b\u0000\u0010\u0000\"\b\b\u0001\u0010\u0002*\u00020\u0001H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "", "T", "invoke", "()Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 0})
public final class CurryKt$toProvider$1 extends Lambda implements Function0<T> {
    public final /* synthetic */ Function1 a;
    public final /* synthetic */ Function0 b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CurryKt$toProvider$1(Function1 function1, Function0 function0) {
        super(0);
        this.a = function1;
        this.b = function0;
    }

    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final T invoke() {
        return (T) this.a.invoke(this.b.invoke());
    }
}
