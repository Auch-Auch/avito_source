package kotlin.jvm.internal;

import com.avito.android.publish.residential_complex_search.di.ResidentialComplexModuleKt;
import com.avito.android.remote.auth.AuthSource;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0010\u0011\n\u0002\b\b\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0003¢\u0006\u0004\b\u001d\u0010\u0014J\u0013\u0010\u0004\u001a\u00020\u0003*\u00028\u0000H$¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00028\u0000¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0003H\u0004¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u000e\u001a\u00028\u00002\u0006\u0010\f\u001a\u00028\u00002\u0006\u0010\r\u001a\u00028\u0000H\u0004¢\u0006\u0004\b\u000e\u0010\u000fR\"\u0010\u0015\u001a\u00020\u00038\u0004@\u0004X\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0013\u0010\u0014R$\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u00168\u0002@\u0002X\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u0012\u0004\b\u0019\u0010\u001aR\u0016\u0010\n\u001a\u00020\u00038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u0011¨\u0006\u001e"}, d2 = {"Lkotlin/jvm/internal/PrimitiveSpreadBuilder;", "", "T", "", "getSize", "(Ljava/lang/Object;)I", "spreadArgument", "", "addSpread", "(Ljava/lang/Object;)V", "size", "()I", ResidentialComplexModuleKt.VALUES, "result", "toArray", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", AuthSource.SEND_ABUSE, "I", "getPosition", "setPosition", "(I)V", VKApiConst.POSITION, "", AuthSource.BOOKING_ORDER, "[Ljava/lang/Object;", "getSpreads$annotations", "()V", "spreads", "c", "<init>", "kotlin-stdlib"}, k = 1, mv = {1, 4, 1})
public abstract class PrimitiveSpreadBuilder<T> {
    public int a;
    public final T[] b;
    public final int c;

    public PrimitiveSpreadBuilder(int i) {
        this.c = i;
        this.b = (T[]) new Object[i];
    }

    public final void addSpread(@NotNull T t) {
        Intrinsics.checkNotNullParameter(t, "spreadArgument");
        T[] tArr = this.b;
        int i = this.a;
        this.a = i + 1;
        tArr[i] = t;
    }

    public final int getPosition() {
        return this.a;
    }

    public abstract int getSize(@NotNull T t);

    public final void setPosition(int i) {
        this.a = i;
    }

    public final int size() {
        int i = this.c - 1;
        int i2 = 0;
        if (i >= 0) {
            int i3 = 0;
            while (true) {
                T t = this.b[i3];
                i2 += t != null ? getSize(t) : 1;
                if (i3 == i) {
                    break;
                }
                i3++;
            }
        }
        return i2;
    }

    @NotNull
    public final T toArray(@NotNull T t, @NotNull T t2) {
        int i;
        Intrinsics.checkNotNullParameter(t, ResidentialComplexModuleKt.VALUES);
        Intrinsics.checkNotNullParameter(t2, "result");
        int i2 = this.c - 1;
        int i3 = 0;
        if (i2 >= 0) {
            int i4 = 0;
            int i5 = 0;
            i = 0;
            while (true) {
                T t3 = this.b[i4];
                if (t3 != null) {
                    if (i5 < i4) {
                        int i6 = i4 - i5;
                        System.arraycopy(t, i5, t2, i, i6);
                        i += i6;
                    }
                    int size = getSize(t3);
                    System.arraycopy(t3, 0, t2, i, size);
                    i += size;
                    i5 = i4 + 1;
                }
                if (i4 == i2) {
                    break;
                }
                i4++;
            }
            i3 = i5;
        } else {
            i = 0;
        }
        int i7 = this.c;
        if (i3 < i7) {
            System.arraycopy(t, i3, t2, i, i7 - i3);
        }
        return t2;
    }
}
