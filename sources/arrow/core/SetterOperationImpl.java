package arrow.core;

import androidx.exifinterface.media.ExifInterface;
import arrow.core.SetterOperation;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Deprecated(message = UtilsKt.DeprecatedUnsafeAccess)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\b\u0007\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u0000*\u0006\b\u0001\u0010\u0002 \u00002\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003B!\u0012\u0018\u0010\n\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u000b\u0010\fR.\u0010\n\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u00050\u00048\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Larrow/core/SetterOperationImpl;", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Larrow/core/SetterOperation;", "Lkotlin/Function2;", "", AuthSource.SEND_ABUSE, "Lkotlin/jvm/functions/Function2;", "getSetter", "()Lkotlin/jvm/functions/Function2;", "setter", "<init>", "(Lkotlin/jvm/functions/Function2;)V", "arrow-core"}, k = 1, mv = {1, 4, 0})
public final class SetterOperationImpl<K, V> implements SetterOperation<K, V> {
    @NotNull
    public final Function2<K, V, Unit> a;

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.jvm.functions.Function2<? super K, ? super V, kotlin.Unit> */
    /* JADX WARN: Multi-variable type inference failed */
    public SetterOperationImpl(@NotNull Function2<? super K, ? super V, Unit> function2) {
        Intrinsics.checkParameterIsNotNull(function2, "setter");
        this.a = function2;
    }

    @Override // arrow.core.SetterOperation
    @NotNull
    public Function2<K, V, Unit> getSetter() {
        return this.a;
    }

    @Override // arrow.core.SetterOperation
    public void set(K k, V v) {
        SetterOperation.DefaultImpls.set(this, k, v);
    }
}
