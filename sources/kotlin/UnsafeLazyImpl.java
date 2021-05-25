package kotlin;

import com.avito.android.remote.auth.AuthSource;
import java.io.Serializable;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\u00060\u0003j\u0002`\u0004B\u0015\u0012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u000f\u001a\u00028\u00008V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0007R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00138\b@\bX\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lkotlin/UnsafeLazyImpl;", "T", "Lkotlin/Lazy;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "", "writeReplace", "()Ljava/lang/Object;", "", "isInitialized", "()Z", "", "toString", "()Ljava/lang/String;", "getValue", "value", AuthSource.BOOKING_ORDER, "Ljava/lang/Object;", "_value", "Lkotlin/Function0;", AuthSource.SEND_ABUSE, "Lkotlin/jvm/functions/Function0;", "initializer", "<init>", "(Lkotlin/jvm/functions/Function0;)V", "kotlin-stdlib"}, k = 1, mv = {1, 4, 1})
public final class UnsafeLazyImpl<T> implements Lazy<T>, Serializable {
    public Function0<? extends T> a;
    public Object b = UNINITIALIZED_VALUE.INSTANCE;

    public UnsafeLazyImpl(@NotNull Function0<? extends T> function0) {
        Intrinsics.checkNotNullParameter(function0, "initializer");
        this.a = function0;
    }

    private final Object writeReplace() {
        return new InitializedLazyImpl(getValue());
    }

    @Override // kotlin.Lazy
    public T getValue() {
        if (this.b == UNINITIALIZED_VALUE.INSTANCE) {
            Function0<? extends T> function0 = this.a;
            Intrinsics.checkNotNull(function0);
            this.b = function0.invoke();
            this.a = null;
        }
        return (T) this.b;
    }

    @Override // kotlin.Lazy
    public boolean isInitialized() {
        return this.b != UNINITIALIZED_VALUE.INSTANCE;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        return isInitialized() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }
}
