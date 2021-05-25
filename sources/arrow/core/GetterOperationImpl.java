package arrow.core;

import androidx.exifinterface.media.ExifInterface;
import arrow.core.GetterOperation;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u0000*\u0006\b\u0001\u0010\u0002 \u00012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003B\u001b\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004¢\u0006\u0004\b\n\u0010\u000bR(\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00048\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Larrow/core/GetterOperationImpl;", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Larrow/core/GetterOperation;", "Lkotlin/Function1;", AuthSource.SEND_ABUSE, "Lkotlin/jvm/functions/Function1;", "getGetter", "()Lkotlin/jvm/functions/Function1;", "getter", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "arrow-core"}, k = 1, mv = {1, 4, 0})
public final class GetterOperationImpl<K, V> implements GetterOperation<K, V> {
    @NotNull
    public final Function1<K, V> a;

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.jvm.functions.Function1<? super K, ? extends V> */
    /* JADX WARN: Multi-variable type inference failed */
    public GetterOperationImpl(@NotNull Function1<? super K, ? extends V> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "getter");
        this.a = function1;
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
}
