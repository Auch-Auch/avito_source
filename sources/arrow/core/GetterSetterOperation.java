package arrow.core;

import androidx.exifinterface.media.ExifInterface;
import arrow.core.GetterOperation;
import arrow.core.SetterOperation;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Deprecated(message = UtilsKt.DeprecatedUnsafeAccess)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\b\u0007\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u0000*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00032\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004B5\u0012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005\u0012\u0018\u0010\u0011\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\u0012\u0010\u0013R(\u0010\n\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00058\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR.\u0010\u0011\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\f0\u000b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Larrow/core/GetterSetterOperation;", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Larrow/core/GetterOperation;", "Larrow/core/SetterOperation;", "Lkotlin/Function1;", AuthSource.SEND_ABUSE, "Lkotlin/jvm/functions/Function1;", "getGetter", "()Lkotlin/jvm/functions/Function1;", "getter", "Lkotlin/Function2;", "", AuthSource.BOOKING_ORDER, "Lkotlin/jvm/functions/Function2;", "getSetter", "()Lkotlin/jvm/functions/Function2;", "setter", "<init>", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)V", "arrow-core"}, k = 1, mv = {1, 4, 0})
public final class GetterSetterOperation<K, V> implements GetterOperation<K, V>, SetterOperation<K, V> {
    @NotNull
    public final Function1<K, V> a;
    @NotNull
    public final Function2<K, V, Unit> b;

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.jvm.functions.Function1<? super K, ? extends V> */
    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlin.jvm.functions.Function2<? super K, ? super V, kotlin.Unit> */
    /* JADX WARN: Multi-variable type inference failed */
    public GetterSetterOperation(@NotNull Function1<? super K, ? extends V> function1, @NotNull Function2<? super K, ? super V, Unit> function2) {
        Intrinsics.checkParameterIsNotNull(function1, "getter");
        Intrinsics.checkParameterIsNotNull(function2, "setter");
        this.a = function1;
        this.b = function2;
    }

    @Override // arrow.core.GetterOperation
    public V get(K k) {
        return (V) GetterOperation.DefaultImpls.get(this, k);
    }

    @Override // arrow.core.GetterOperation
    @NotNull
    public Function1<K, V> getGetter() {
        return this.a;
    }

    @Override // arrow.core.SetterOperation
    @NotNull
    public Function2<K, V, Unit> getSetter() {
        return this.b;
    }

    @Override // arrow.core.SetterOperation
    public void set(K k, V v) {
        SetterOperation.DefaultImpls.set(this, k, v);
    }
}
