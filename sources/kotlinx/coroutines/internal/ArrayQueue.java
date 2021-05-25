package kotlinx.coroutines.internal;

import com.avito.android.remote.auth.AuthSource;
import com.facebook.share.internal.MessengerShareContentUtility;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0010\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0001B\u0007¢\u0006\u0004\b\u0018\u0010\nJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0000¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0010\u001a\u00020\u000b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\rR\u0013\u0010\u0012\u001a\u00020\u00118F@\u0006¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00148\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lkotlinx/coroutines/internal/ArrayQueue;", "", "T", "element", "", "addLast", "(Ljava/lang/Object;)V", "removeFirstOrNull", "()Ljava/lang/Object;", "clear", "()V", "", "c", "I", "tail", AuthSource.BOOKING_ORDER, "head", "", "isEmpty", "()Z", "", AuthSource.SEND_ABUSE, "[Ljava/lang/Object;", MessengerShareContentUtility.ELEMENTS, "<init>", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
public class ArrayQueue<T> {
    public Object[] a = new Object[16];
    public int b;
    public int c;

    public final void addLast(@NotNull T t) {
        Object[] objArr = this.a;
        int i = this.c;
        objArr[i] = t;
        int length = (objArr.length - 1) & (i + 1);
        this.c = length;
        int i2 = this.b;
        if (length == i2) {
            int length2 = objArr.length;
            Object[] objArr2 = new Object[(length2 << 1)];
            ArraysKt___ArraysJvmKt.copyInto$default(objArr, objArr2, 0, i2, 0, 10, (Object) null);
            Object[] objArr3 = this.a;
            int length3 = objArr3.length;
            int i3 = this.b;
            ArraysKt___ArraysJvmKt.copyInto$default(objArr3, objArr2, length3 - i3, 0, i3, 4, (Object) null);
            this.a = objArr2;
            this.b = 0;
            this.c = length2;
        }
    }

    public final void clear() {
        this.b = 0;
        this.c = 0;
        this.a = new Object[this.a.length];
    }

    public final boolean isEmpty() {
        return this.b == this.c;
    }

    @Nullable
    public final T removeFirstOrNull() {
        int i = this.b;
        if (i == this.c) {
            return null;
        }
        Object[] objArr = this.a;
        T t = (T) objArr[i];
        objArr[i] = null;
        this.b = (i + 1) & (objArr.length - 1);
        Objects.requireNonNull(t, "null cannot be cast to non-null type T");
        return t;
    }
}
