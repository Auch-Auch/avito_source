package kotlin;

import com.avito.android.remote.auth.AuthSource;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Arrays;
import java.util.Collection;
import java.util.NoSuchElementException;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.UShortIterator;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;
@SinceKotlin(version = "1.3")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u0017\n\u0002\b\t\b@\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001,B\u0014\b\u0001\u0012\u0006\u00100\u001a\u00020+ø\u0001\u0000¢\u0006\u0004\b1\u00102B\u0014\b\u0016\u0012\u0006\u0010*\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b1\u00103J\u001e\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0005\u0010\u0006J#\u0010\f\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0002H\u0002ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0010\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001b\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0002H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014J \u0010\u0019\u001a\u00020\u00122\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u001c\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010 \u001a\u00020\u001dHÖ\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010#\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b!\u0010\"J\u001a\u0010(\u001a\u00020\u00122\b\u0010%\u001a\u0004\u0018\u00010$HÖ\u0003¢\u0006\u0004\b&\u0010'R\u0016\u0010*\u001a\u00020\u00038V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b)\u0010\"R\u001c\u00100\u001a\u00020+8\u0000@\u0001X\u0004¢\u0006\f\n\u0004\b,\u0010-\u0012\u0004\b.\u0010/ø\u0001\u0000\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u00064"}, d2 = {"Lkotlin/UShortArray;", "", "Lkotlin/UShort;", "", FirebaseAnalytics.Param.INDEX, "get-Mh2AYeg", "([SI)S", "get", "value", "", "set-01HTLdE", "([SIS)V", "set", "Lkotlin/collections/UShortIterator;", "iterator-impl", "([S)Lkotlin/collections/UShortIterator;", "iterator", "element", "", "contains-xj2QHRw", "([SS)Z", "contains", MessengerShareContentUtility.ELEMENTS, "containsAll-impl", "([SLjava/util/Collection;)Z", "containsAll", "isEmpty-impl", "([S)Z", "isEmpty", "", "toString-impl", "([S)Ljava/lang/String;", "toString", "hashCode-impl", "([S)I", "hashCode", "", "other", "equals-impl", "([SLjava/lang/Object;)Z", "equals", "getSize-impl", "size", "", AuthSource.SEND_ABUSE, "[S", "getStorage$annotations", "()V", "storage", "constructor-impl", "([S)[S", "(I)[S", "kotlin-stdlib"}, k = 1, mv = {1, 4, 1})
@ExperimentalUnsignedTypes
public final class UShortArray implements Collection<UShort>, KMappedMarker {
    @NotNull
    public final short[] a;

    public static final class a extends UShortIterator {
        public int a;
        public final short[] b;

        public a(@NotNull short[] sArr) {
            Intrinsics.checkNotNullParameter(sArr, "array");
            this.b = sArr;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.a < this.b.length;
        }

        @Override // kotlin.collections.UShortIterator
        /* renamed from: nextUShort-Mh2AYeg  reason: not valid java name */
        public short mo350nextUShortMh2AYeg() {
            int i = this.a;
            short[] sArr = this.b;
            if (i < sArr.length) {
                this.a = i + 1;
                return UShort.m327constructorimpl(sArr[i]);
            }
            throw new NoSuchElementException(String.valueOf(this.a));
        }
    }

    @PublishedApi
    public /* synthetic */ UShortArray(short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "storage");
        this.a = sArr;
    }

    @NotNull
    /* renamed from: constructor-impl  reason: not valid java name */
    public static short[] m334constructorimpl(int i) {
        return m335constructorimpl(new short[i]);
    }

    @PublishedApi
    @NotNull
    /* renamed from: constructor-impl  reason: not valid java name */
    public static short[] m335constructorimpl(@NotNull short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "storage");
        return sArr;
    }

    /* renamed from: containsAll-impl  reason: not valid java name */
    public static boolean m337containsAllimpl(short[] sArr, @NotNull Collection<UShort> collection) {
        boolean z;
        Intrinsics.checkNotNullParameter(collection, MessengerShareContentUtility.ELEMENTS);
        if (!collection.isEmpty()) {
            for (T t : collection) {
                if (!(t instanceof UShort) || !ArraysKt___ArraysKt.contains(sArr, t.m332unboximpl())) {
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
    public static boolean m338equalsimpl(short[] sArr, Object obj) {
        return (obj instanceof UShortArray) && Intrinsics.areEqual(sArr, ((UShortArray) obj).m349unboximpl());
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m339equalsimpl0(short[] sArr, short[] sArr2) {
        return Intrinsics.areEqual(sArr, sArr2);
    }

    /* renamed from: get-Mh2AYeg  reason: not valid java name */
    public static final short m340getMh2AYeg(short[] sArr, int i) {
        return UShort.m327constructorimpl(sArr[i]);
    }

    /* renamed from: getSize-impl  reason: not valid java name */
    public static int m341getSizeimpl(short[] sArr) {
        return sArr.length;
    }

    @PublishedApi
    public static /* synthetic */ void getStorage$annotations() {
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m342hashCodeimpl(short[] sArr) {
        if (sArr != null) {
            return Arrays.hashCode(sArr);
        }
        return 0;
    }

    /* renamed from: isEmpty-impl  reason: not valid java name */
    public static boolean m343isEmptyimpl(short[] sArr) {
        return sArr.length == 0;
    }

    @NotNull
    /* renamed from: iterator-impl  reason: not valid java name */
    public static UShortIterator m344iteratorimpl(short[] sArr) {
        return new a(sArr);
    }

    /* renamed from: set-01HTLdE  reason: not valid java name */
    public static final void m345set01HTLdE(short[] sArr, int i, short s) {
        sArr[i] = s;
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m346toStringimpl(short[] sArr) {
        StringBuilder L = a2.b.a.a.a.L("UShortArray(storage=");
        L.append(Arrays.toString(sArr));
        L.append(")");
        return L.toString();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.util.Collection
    public /* synthetic */ boolean add(UShort uShort) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* renamed from: add-xj2QHRw  reason: not valid java name */
    public boolean m347addxj2QHRw(short s) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends UShort> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof UShort) {
            return m348containsxj2QHRw(((UShort) obj).m332unboximpl());
        }
        return false;
    }

    /* renamed from: contains-xj2QHRw  reason: not valid java name */
    public boolean m348containsxj2QHRw(short s) {
        return m336containsxj2QHRw(this.a, s);
    }

    @Override // java.util.Collection
    public boolean containsAll(@NotNull Collection<? extends Object> collection) {
        return m337containsAllimpl(this.a, collection);
    }

    @Override // java.util.Collection, java.lang.Object
    public boolean equals(Object obj) {
        return m338equalsimpl(this.a, obj);
    }

    public int getSize() {
        return m341getSizeimpl(this.a);
    }

    @Override // java.util.Collection, java.lang.Object
    public int hashCode() {
        return m342hashCodeimpl(this.a);
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return m343isEmptyimpl(this.a);
    }

    @Override // java.util.Collection, java.lang.Iterable
    @NotNull
    public UShortIterator iterator() {
        return m344iteratorimpl(this.a);
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
        return m346toStringimpl(this.a);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ short[] m349unboximpl() {
        return this.a;
    }

    /* renamed from: contains-xj2QHRw  reason: not valid java name */
    public static boolean m336containsxj2QHRw(short[] sArr, short s) {
        return ArraysKt___ArraysKt.contains(sArr, s);
    }
}
