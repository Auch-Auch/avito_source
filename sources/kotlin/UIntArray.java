package kotlin;

import com.avito.android.remote.auth.AuthSource;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Arrays;
import java.util.Collection;
import java.util.NoSuchElementException;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.UIntIterator;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;
@SinceKotlin(version = "1.3")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u0015\n\u0002\b\t\b@\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001,B\u0014\b\u0001\u0012\u0006\u00100\u001a\u00020+ø\u0001\u0000¢\u0006\u0004\b1\u00102B\u0014\b\u0016\u0012\u0006\u0010*\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b1\u00103J\u001e\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0005\u0010\u0006J#\u0010\f\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0002H\u0002ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0010\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001b\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0002H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014J \u0010\u0019\u001a\u00020\u00122\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u001c\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010 \u001a\u00020\u001dHÖ\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010#\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b!\u0010\"J\u001a\u0010(\u001a\u00020\u00122\b\u0010%\u001a\u0004\u0018\u00010$HÖ\u0003¢\u0006\u0004\b&\u0010'R\u0016\u0010*\u001a\u00020\u00038V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b)\u0010\"R\u001c\u00100\u001a\u00020+8\u0000@\u0001X\u0004¢\u0006\f\n\u0004\b,\u0010-\u0012\u0004\b.\u0010/ø\u0001\u0000\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u00064"}, d2 = {"Lkotlin/UIntArray;", "", "Lkotlin/UInt;", "", FirebaseAnalytics.Param.INDEX, "get-pVg5ArA", "([II)I", "get", "value", "", "set-VXSXFK8", "([III)V", "set", "Lkotlin/collections/UIntIterator;", "iterator-impl", "([I)Lkotlin/collections/UIntIterator;", "iterator", "element", "", "contains-WZ4Q5Ns", "([II)Z", "contains", MessengerShareContentUtility.ELEMENTS, "containsAll-impl", "([ILjava/util/Collection;)Z", "containsAll", "isEmpty-impl", "([I)Z", "isEmpty", "", "toString-impl", "([I)Ljava/lang/String;", "toString", "hashCode-impl", "([I)I", "hashCode", "", "other", "equals-impl", "([ILjava/lang/Object;)Z", "equals", "getSize-impl", "size", "", AuthSource.SEND_ABUSE, "[I", "getStorage$annotations", "()V", "storage", "constructor-impl", "([I)[I", "(I)[I", "kotlin-stdlib"}, k = 1, mv = {1, 4, 1})
@ExperimentalUnsignedTypes
public final class UIntArray implements Collection<UInt>, KMappedMarker {
    @NotNull
    public final int[] a;

    public static final class a extends UIntIterator {
        public int a;
        public final int[] b;

        public a(@NotNull int[] iArr) {
            Intrinsics.checkNotNullParameter(iArr, "array");
            this.b = iArr;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.a < this.b.length;
        }

        @Override // kotlin.collections.UIntIterator
        /* renamed from: nextUInt-pVg5ArA  reason: not valid java name */
        public int mo300nextUIntpVg5ArA() {
            int i = this.a;
            int[] iArr = this.b;
            if (i < iArr.length) {
                this.a = i + 1;
                return UInt.m277constructorimpl(iArr[i]);
            }
            throw new NoSuchElementException(String.valueOf(this.a));
        }
    }

    @PublishedApi
    public /* synthetic */ UIntArray(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "storage");
        this.a = iArr;
    }

    @NotNull
    /* renamed from: constructor-impl  reason: not valid java name */
    public static int[] m284constructorimpl(int i) {
        return m285constructorimpl(new int[i]);
    }

    @PublishedApi
    @NotNull
    /* renamed from: constructor-impl  reason: not valid java name */
    public static int[] m285constructorimpl(@NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "storage");
        return iArr;
    }

    /* renamed from: containsAll-impl  reason: not valid java name */
    public static boolean m287containsAllimpl(int[] iArr, @NotNull Collection<UInt> collection) {
        boolean z;
        Intrinsics.checkNotNullParameter(collection, MessengerShareContentUtility.ELEMENTS);
        if (!collection.isEmpty()) {
            for (T t : collection) {
                if (!(t instanceof UInt) || !ArraysKt___ArraysKt.contains(iArr, t.m282unboximpl())) {
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

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m288equalsimpl(int[] iArr, Object obj) {
        return (obj instanceof UIntArray) && Intrinsics.areEqual(iArr, ((UIntArray) obj).m299unboximpl());
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m289equalsimpl0(int[] iArr, int[] iArr2) {
        return Intrinsics.areEqual(iArr, iArr2);
    }

    /* renamed from: get-pVg5ArA  reason: not valid java name */
    public static final int m290getpVg5ArA(int[] iArr, int i) {
        return UInt.m277constructorimpl(iArr[i]);
    }

    /* renamed from: getSize-impl  reason: not valid java name */
    public static int m291getSizeimpl(int[] iArr) {
        return iArr.length;
    }

    @PublishedApi
    public static /* synthetic */ void getStorage$annotations() {
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m292hashCodeimpl(int[] iArr) {
        if (iArr != null) {
            return Arrays.hashCode(iArr);
        }
        return 0;
    }

    /* renamed from: isEmpty-impl  reason: not valid java name */
    public static boolean m293isEmptyimpl(int[] iArr) {
        return iArr.length == 0;
    }

    @NotNull
    /* renamed from: iterator-impl  reason: not valid java name */
    public static UIntIterator m294iteratorimpl(int[] iArr) {
        return new a(iArr);
    }

    /* renamed from: set-VXSXFK8  reason: not valid java name */
    public static final void m295setVXSXFK8(int[] iArr, int i, int i2) {
        iArr[i] = i2;
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m296toStringimpl(int[] iArr) {
        StringBuilder L = a2.b.a.a.a.L("UIntArray(storage=");
        L.append(Arrays.toString(iArr));
        L.append(")");
        return L.toString();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.util.Collection
    public /* synthetic */ boolean add(UInt uInt) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* renamed from: add-WZ4Q5Ns  reason: not valid java name */
    public boolean m297addWZ4Q5Ns(int i) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends UInt> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof UInt) {
            return m298containsWZ4Q5Ns(((UInt) obj).m282unboximpl());
        }
        return false;
    }

    /* renamed from: contains-WZ4Q5Ns  reason: not valid java name */
    public boolean m298containsWZ4Q5Ns(int i) {
        return m286containsWZ4Q5Ns(this.a, i);
    }

    @Override // java.util.Collection
    public boolean containsAll(@NotNull Collection<? extends Object> collection) {
        return m287containsAllimpl(this.a, collection);
    }

    @Override // java.util.Collection, java.lang.Object
    public boolean equals(Object obj) {
        return m288equalsimpl(this.a, obj);
    }

    public int getSize() {
        return m291getSizeimpl(this.a);
    }

    @Override // java.util.Collection, java.lang.Object
    public int hashCode() {
        return m292hashCodeimpl(this.a);
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return m293isEmptyimpl(this.a);
    }

    @Override // java.util.Collection, java.lang.Iterable
    @NotNull
    public UIntIterator iterator() {
        return m294iteratorimpl(this.a);
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
        return m296toStringimpl(this.a);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ int[] m299unboximpl() {
        return this.a;
    }

    /* renamed from: contains-WZ4Q5Ns  reason: not valid java name */
    public static boolean m286containsWZ4Q5Ns(int[] iArr, int i) {
        return ArraysKt___ArraysKt.contains(iArr, i);
    }
}
