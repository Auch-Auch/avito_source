package kotlin;

import com.avito.android.remote.auth.AuthSource;
import org.jetbrains.annotations.NotNull;
import org.spongycastle.asn1.cmc.BodyPartID;
import t6.r.a.j;
@SinceKotlin(version = "1.3")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b@\u0018\u0000 \u00162\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0016B\u0014\b\u0001\u0012\u0006\u0010\u0014\u001a\u00020\u0006ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\bJ\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\t\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\u000f\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nHÖ\u0003¢\u0006\u0004\b\r\u0010\u000eR\u001c\u0010\u0014\u001a\u00020\u00068\u0000@\u0001X\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u0012\u0004\b\u0012\u0010\u0013ø\u0001\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0017"}, d2 = {"Lkotlin/UInt;", "", "", "toString-impl", "(I)Ljava/lang/String;", "toString", "", "hashCode-impl", "(I)I", "hashCode", "", "other", "", "equals-impl", "(ILjava/lang/Object;)Z", "equals", AuthSource.SEND_ABUSE, "I", "getData$annotations", "()V", "data", "constructor-impl", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 4, 1})
@ExperimentalUnsignedTypes
public final class UInt implements Comparable<UInt> {
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int MAX_VALUE = -1;
    public static final int MIN_VALUE = 0;
    public static final int SIZE_BITS = 32;
    public static final int SIZE_BYTES = 4;
    public final int a;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XTø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u001c\u0010\u0005\u001a\u00020\u00028\u0006@\u0006XTø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0007\u001a\u00020\u00068\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00068\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\b\u0010\u0004\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006\u000b"}, d2 = {"Lkotlin/UInt$Companion;", "", "Lkotlin/UInt;", "MAX_VALUE", "I", "MIN_VALUE", "", "SIZE_BITS", "SIZE_BYTES", "<init>", "()V", "kotlin-stdlib"}, k = 1, mv = {1, 4, 1})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    @PublishedApi
    public /* synthetic */ UInt(int i) {
        this.a = i;
    }

    /* renamed from: box-impl */
    public static final /* synthetic */ UInt m276boximpl(int i) {
        return new UInt(i);
    }

    @PublishedApi
    /* renamed from: constructor-impl */
    public static int m277constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl */
    public static boolean m278equalsimpl(int i, Object obj) {
        return (obj instanceof UInt) && i == ((UInt) obj).m282unboximpl();
    }

    /* renamed from: equals-impl0 */
    public static final boolean m279equalsimpl0(int i, int i2) {
        return i == i2;
    }

    @PublishedApi
    public static /* synthetic */ void getData$annotations() {
    }

    /* renamed from: hashCode-impl */
    public static int m280hashCodeimpl(int i) {
        return i;
    }

    @NotNull
    /* renamed from: toString-impl */
    public static String m281toStringimpl(int i) {
        return String.valueOf(((long) i) & BodyPartID.bodyIdMax);
    }

    @Override // java.lang.Comparable
    public int compareTo(UInt uInt) {
        return UnsignedKt.uintCompare(this.a, uInt.m282unboximpl());
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        return m278equalsimpl(this.a, obj);
    }

    @Override // java.lang.Object
    public int hashCode() {
        return m280hashCodeimpl(this.a);
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        return m281toStringimpl(this.a);
    }

    /* renamed from: unbox-impl */
    public final /* synthetic */ int m282unboximpl() {
        return this.a;
    }
}
