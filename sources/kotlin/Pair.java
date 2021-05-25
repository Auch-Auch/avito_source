package kotlin;

import a2.b.a.a.a;
import androidx.exifinterface.media.ExifInterface;
import com.avito.android.analytics.screens.InternalConstsKt;
import com.avito.android.remote.auth.AuthSource;
import java.io.Serializable;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\b\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u0001*\u0006\b\u0001\u0010\u0002 \u00012\u00060\u0003j\u0002`\u0004B\u0017\u0012\u0006\u0010\u000b\u001a\u00028\u0000\u0012\u0006\u0010\f\u001a\u00028\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00028\u0000HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00028\u0001HÆ\u0003¢\u0006\u0004\b\n\u0010\tJ0\u0010\r\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\b\b\u0002\u0010\u000b\u001a\u00028\u00002\b\b\u0002\u0010\f\u001a\u00028\u0001HÆ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u0019\u0010\u000b\u001a\u00028\u00008\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\tR\u0019\u0010\f\u001a\u00028\u00018\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u0018\u001a\u0004\b\u001b\u0010\t¨\u0006\u001e"}, d2 = {"Lkotlin/Pair;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "", "toString", "()Ljava/lang/String;", "component1", "()Ljava/lang/Object;", "component2", InternalConstsKt.FIRST_IMAGE, "second", "copy", "(Ljava/lang/Object;Ljava/lang/Object;)Lkotlin/Pair;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Ljava/lang/Object;", "getFirst", AuthSource.BOOKING_ORDER, "getSecond", "<init>", "(Ljava/lang/Object;Ljava/lang/Object;)V", "kotlin-stdlib"}, k = 1, mv = {1, 4, 1})
public final class Pair<A, B> implements Serializable {
    public final A a;
    public final B b;

    public Pair(A a3, B b2) {
        this.a = a3;
        this.b = b2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: kotlin.Pair */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Pair copy$default(Pair pair, Object obj, Object obj2, int i, Object obj3) {
        if ((i & 1) != 0) {
            obj = pair.a;
        }
        if ((i & 2) != 0) {
            obj2 = pair.b;
        }
        return pair.copy(obj, obj2);
    }

    public final A component1() {
        return this.a;
    }

    public final B component2() {
        return this.b;
    }

    @NotNull
    public final Pair<A, B> copy(A a3, B b2) {
        return new Pair<>(a3, b2);
    }

    @Override // java.lang.Object
    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Pair)) {
            return false;
        }
        Pair pair = (Pair) obj;
        return Intrinsics.areEqual(this.a, pair.a) && Intrinsics.areEqual(this.b, pair.b);
    }

    public final A getFirst() {
        return this.a;
    }

    public final B getSecond() {
        return this.b;
    }

    @Override // java.lang.Object
    public int hashCode() {
        A a3 = this.a;
        int i = 0;
        int hashCode = (a3 != null ? a3.hashCode() : 0) * 31;
        B b2 = this.b;
        if (b2 != null) {
            i = b2.hashCode();
        }
        return hashCode + i;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder I = a.I('(');
        I.append((Object) this.a);
        I.append(", ");
        return a.q(I, this.b, ')');
    }
}
