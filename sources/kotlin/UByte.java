package kotlin;

import com.avito.android.remote.auth.AuthSource;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@SinceKotlin(version = "1.3")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0002\b\t\b@\u0018\u0000 \u00182\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0018B\u0014\b\u0001\u0012\u0006\u0010\u0015\u001a\u00020\u0010ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\t\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\u000f\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nHÖ\u0003¢\u0006\u0004\b\r\u0010\u000eR\u001c\u0010\u0015\u001a\u00020\u00108\u0000@\u0001X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u0012\u0004\b\u0013\u0010\u0014ø\u0001\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0019"}, d2 = {"Lkotlin/UByte;", "", "", "toString-impl", "(B)Ljava/lang/String;", "toString", "", "hashCode-impl", "(B)I", "hashCode", "", "other", "", "equals-impl", "(BLjava/lang/Object;)Z", "equals", "", AuthSource.SEND_ABUSE, "B", "getData$annotations", "()V", "data", "constructor-impl", "(B)B", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 4, 1})
@ExperimentalUnsignedTypes
public final class UByte implements Comparable<UByte> {
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final byte MAX_VALUE = -1;
    public static final byte MIN_VALUE = 0;
    public static final int SIZE_BITS = 8;
    public static final int SIZE_BYTES = 1;
    public final byte a;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bR\u001c\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XTø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u001c\u0010\u0005\u001a\u00020\u00028\u0006@\u0006XTø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0007\u001a\u00020\u00068\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0016\u0010\t\u001a\u00020\u00068\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\t\u0010\b\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006\f"}, d2 = {"Lkotlin/UByte$Companion;", "", "Lkotlin/UByte;", "MAX_VALUE", "B", "MIN_VALUE", "", "SIZE_BITS", "I", "SIZE_BYTES", "<init>", "()V", "kotlin-stdlib"}, k = 1, mv = {1, 4, 1})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    @PublishedApi
    public /* synthetic */ UByte(byte b) {
        this.a = b;
    }

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ UByte m251boximpl(byte b) {
        return new UByte(b);
    }

    @PublishedApi
    /* renamed from: constructor-impl  reason: not valid java name */
    public static byte m252constructorimpl(byte b) {
        return b;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m253equalsimpl(byte b, Object obj) {
        return (obj instanceof UByte) && b == ((UByte) obj).m257unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m254equalsimpl0(byte b, byte b2) {
        return b == b2;
    }

    @PublishedApi
    public static /* synthetic */ void getData$annotations() {
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m255hashCodeimpl(byte b) {
        return b;
    }

    @NotNull
    /* renamed from: toString-impl  reason: not valid java name */
    public static String m256toStringimpl(byte b) {
        return String.valueOf(b & 255);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.lang.Comparable
    public int compareTo(UByte uByte) {
        return Intrinsics.compare(this.a & 255, uByte.m257unboximpl() & 255);
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        return m253equalsimpl(this.a, obj);
    }

    @Override // java.lang.Object
    public int hashCode() {
        return m255hashCodeimpl(this.a);
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        return m256toStringimpl(this.a);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ byte m257unboximpl() {
        return this.a;
    }
}
