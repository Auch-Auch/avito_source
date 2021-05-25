package kotlin;

import com.avito.android.remote.auth.AuthSource;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Arrays;
import java.util.Collection;
import java.util.NoSuchElementException;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.UByteIterator;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;
@SinceKotlin(version = "1.3")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u000b\b@\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001*B\u0014\b\u0001\u0012\u0006\u0010.\u001a\u00020)ø\u0001\u0000¢\u0006\u0004\b1\u00102B\u0014\b\u0016\u0012\u0006\u00100\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b1\u00103J\u001e\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0005\u0010\u0006J#\u0010\f\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0002H\u0002ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0010\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001b\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0002H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014J \u0010\u0019\u001a\u00020\u00122\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u001c\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010 \u001a\u00020\u001dHÖ\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010#\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b!\u0010\"J\u001a\u0010(\u001a\u00020\u00122\b\u0010%\u001a\u0004\u0018\u00010$HÖ\u0003¢\u0006\u0004\b&\u0010'R\u001c\u0010.\u001a\u00020)8\u0000@\u0001X\u0004¢\u0006\f\n\u0004\b*\u0010+\u0012\u0004\b,\u0010-R\u0016\u00100\u001a\u00020\u00038V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b/\u0010\"ø\u0001\u0000\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u00064"}, d2 = {"Lkotlin/UByteArray;", "", "Lkotlin/UByte;", "", FirebaseAnalytics.Param.INDEX, "get-w2LRezQ", "([BI)B", "get", "value", "", "set-VurrAj0", "([BIB)V", "set", "Lkotlin/collections/UByteIterator;", "iterator-impl", "([B)Lkotlin/collections/UByteIterator;", "iterator", "element", "", "contains-7apg3OU", "([BB)Z", "contains", MessengerShareContentUtility.ELEMENTS, "containsAll-impl", "([BLjava/util/Collection;)Z", "containsAll", "isEmpty-impl", "([B)Z", "isEmpty", "", "toString-impl", "([B)Ljava/lang/String;", "toString", "hashCode-impl", "([B)I", "hashCode", "", "other", "equals-impl", "([BLjava/lang/Object;)Z", "equals", "", AuthSource.SEND_ABUSE, "[B", "getStorage$annotations", "()V", "storage", "getSize-impl", "size", "constructor-impl", "([B)[B", "(I)[B", "kotlin-stdlib"}, k = 1, mv = {1, 4, 1})
@ExperimentalUnsignedTypes
public final class UByteArray implements Collection<UByte>, KMappedMarker {
    @NotNull
    public final byte[] a;

    public static final class a extends UByteIterator {
        public int a;
        public final byte[] b;

        public a(@NotNull byte[] bArr) {
            Intrinsics.checkNotNullParameter(bArr, "array");
            this.b = bArr;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.a < this.b.length;
        }

        @Override // kotlin.collections.UByteIterator
        /* renamed from: nextUByte-w2LRezQ */
        public byte mo275nextUBytew2LRezQ() {
            int i = this.a;
            byte[] bArr = this.b;
            if (i < bArr.length) {
                this.a = i + 1;
                return UByte.m252constructorimpl(bArr[i]);
            }
            throw new NoSuchElementException(String.valueOf(this.a));
        }
    }

    @PublishedApi
    public /* synthetic */ UByteArray(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "storage");
        this.a = bArr;
    }

    @NotNull
    /* renamed from: constructor-impl */
    public static byte[] m259constructorimpl(int i) {
        return m260constructorimpl(new byte[i]);
    }

    @PublishedApi
    @NotNull
    /* renamed from: constructor-impl */
    public static byte[] m260constructorimpl(@NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "storage");
        return bArr;
    }

    /* renamed from: containsAll-impl */
    public static boolean m262containsAllimpl(byte[] bArr, @NotNull Collection<UByte> collection) {
        boolean z;
        Intrinsics.checkNotNullParameter(collection, MessengerShareContentUtility.ELEMENTS);
        if (!collection.isEmpty()) {
            for (T t : collection) {
                if (!(t instanceof UByte) || !ArraysKt___ArraysKt.contains(bArr, t.m257unboximpl())) {
                    z = false;
                    continue;
                } else {
                    z = true;
                    continue;
                }
                if (!z) {
                    return false;
                }
            }
        }
        return true;
    }

    /* renamed from: equals-impl */
    public static boolean m263equalsimpl(byte[] bArr, Object obj) {
        return (obj instanceof UByteArray) && Intrinsics.areEqual(bArr, ((UByteArray) obj).m274unboximpl());
    }

    /* renamed from: equals-impl0 */
    public static final boolean m264equalsimpl0(byte[] bArr, byte[] bArr2) {
        return Intrinsics.areEqual(bArr, bArr2);
    }

    /* renamed from: get-w2LRezQ */
    public static final byte m265getw2LRezQ(byte[] bArr, int i) {
        return UByte.m252constructorimpl(bArr[i]);
    }

    /* renamed from: getSize-impl */
    public static int m266getSizeimpl(byte[] bArr) {
        return bArr.length;
    }

    @PublishedApi
    public static /* synthetic */ void getStorage$annotations() {
    }

    /* renamed from: hashCode-impl */
    public static int m267hashCodeimpl(byte[] bArr) {
        if (bArr != null) {
            return Arrays.hashCode(bArr);
        }
        return 0;
    }

    /* renamed from: isEmpty-impl */
    public static boolean m268isEmptyimpl(byte[] bArr) {
        return bArr.length == 0;
    }

    @NotNull
    /* renamed from: iterator-impl */
    public static UByteIterator m269iteratorimpl(byte[] bArr) {
        return new a(bArr);
    }

    /* renamed from: set-VurrAj0 */
    public static final void m270setVurrAj0(byte[] bArr, int i, byte b) {
        bArr[i] = b;
    }

    /* renamed from: toString-impl */
    public static String m271toStringimpl(byte[] bArr) {
        StringBuilder L = a2.b.a.a.a.L("UByteArray(storage=");
        L.append(Arrays.toString(bArr));
        L.append(")");
        return L.toString();
    }

    @Override // java.util.Collection
    public /* synthetic */ boolean add(UByte uByte) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* renamed from: add-7apg3OU */
    public boolean m272add7apg3OU(byte b) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends UByte> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof UByte) {
            return m273contains7apg3OU(((UByte) obj).m257unboximpl());
        }
        return false;
    }

    /* renamed from: contains-7apg3OU */
    public boolean m273contains7apg3OU(byte b) {
        return m261contains7apg3OU(this.a, b);
    }

    @Override // java.util.Collection
    public boolean containsAll(@NotNull Collection<? extends Object> collection) {
        return m262containsAllimpl(this.a, collection);
    }

    @Override // java.util.Collection, java.lang.Object
    public boolean equals(Object obj) {
        return m263equalsimpl(this.a, obj);
    }

    public int getSize() {
        return m266getSizeimpl(this.a);
    }

    @Override // java.util.Collection, java.lang.Object
    public int hashCode() {
        return m267hashCodeimpl(this.a);
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return m268isEmptyimpl(this.a);
    }

    @Override // java.util.Collection, java.lang.Iterable
    @NotNull
    public UByteIterator iterator() {
        return m269iteratorimpl(this.a);
    }

    @Override // java.util.Collection
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean removeAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean retainAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.Collection
    public Object[] toArray() {
        return CollectionToArray.toArray(this);
    }

    @Override // java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        return (T[]) CollectionToArray.toArray(this, tArr);
    }

    @Override // java.lang.Object
    public String toString() {
        return m271toStringimpl(this.a);
    }

    /* renamed from: unbox-impl */
    public final /* synthetic */ byte[] m274unboximpl() {
        return this.a;
    }

    /* renamed from: contains-7apg3OU */
    public static boolean m261contains7apg3OU(byte[] bArr, byte b) {
        return ArraysKt___ArraysKt.contains(bArr, b);
    }
}
