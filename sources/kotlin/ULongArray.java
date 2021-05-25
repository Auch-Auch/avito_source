package kotlin;

import com.avito.android.remote.auth.AuthSource;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Arrays;
import java.util.Collection;
import java.util.NoSuchElementException;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.ULongIterator;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;
@SinceKotlin(version = "1.3")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u0016\n\u0002\b\u000b\b@\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001*B\u0014\b\u0001\u0012\u0006\u0010.\u001a\u00020)ø\u0001\u0000¢\u0006\u0004\b1\u00102B\u0014\b\u0016\u0012\u0006\u00100\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b1\u00103J\u001e\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0005\u0010\u0006J#\u0010\f\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0002H\u0002ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0010\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001b\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0002H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014J \u0010\u0019\u001a\u00020\u00122\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u001c\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010 \u001a\u00020\u001dHÖ\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010#\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b!\u0010\"J\u001a\u0010(\u001a\u00020\u00122\b\u0010%\u001a\u0004\u0018\u00010$HÖ\u0003¢\u0006\u0004\b&\u0010'R\u001c\u0010.\u001a\u00020)8\u0000@\u0001X\u0004¢\u0006\f\n\u0004\b*\u0010+\u0012\u0004\b,\u0010-R\u0016\u00100\u001a\u00020\u00038V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b/\u0010\"ø\u0001\u0000\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u00064"}, d2 = {"Lkotlin/ULongArray;", "", "Lkotlin/ULong;", "", FirebaseAnalytics.Param.INDEX, "get-s-VKNKU", "([JI)J", "get", "value", "", "set-k8EXiF4", "([JIJ)V", "set", "Lkotlin/collections/ULongIterator;", "iterator-impl", "([J)Lkotlin/collections/ULongIterator;", "iterator", "element", "", "contains-VKZWuLQ", "([JJ)Z", "contains", MessengerShareContentUtility.ELEMENTS, "containsAll-impl", "([JLjava/util/Collection;)Z", "containsAll", "isEmpty-impl", "([J)Z", "isEmpty", "", "toString-impl", "([J)Ljava/lang/String;", "toString", "hashCode-impl", "([J)I", "hashCode", "", "other", "equals-impl", "([JLjava/lang/Object;)Z", "equals", "", AuthSource.SEND_ABUSE, "[J", "getStorage$annotations", "()V", "storage", "getSize-impl", "size", "constructor-impl", "([J)[J", "(I)[J", "kotlin-stdlib"}, k = 1, mv = {1, 4, 1})
@ExperimentalUnsignedTypes
public final class ULongArray implements Collection<ULong>, KMappedMarker {
    @NotNull
    public final long[] a;

    public static final class a extends ULongIterator {
        public int a;
        public final long[] b;

        public a(@NotNull long[] jArr) {
            Intrinsics.checkNotNullParameter(jArr, "array");
            this.b = jArr;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.a < this.b.length;
        }

        @Override // kotlin.collections.ULongIterator
        /* renamed from: nextULong-s-VKNKU  reason: not valid java name */
        public long mo325nextULongsVKNKU() {
            int i = this.a;
            long[] jArr = this.b;
            if (i < jArr.length) {
                this.a = i + 1;
                return ULong.m302constructorimpl(jArr[i]);
            }
            throw new NoSuchElementException(String.valueOf(this.a));
        }
    }

    @PublishedApi
    public /* synthetic */ ULongArray(long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "storage");
        this.a = jArr;
    }

    @NotNull
    /* renamed from: constructor-impl  reason: not valid java name */
    public static long[] m309constructorimpl(int i) {
        return m310constructorimpl(new long[i]);
    }

    @PublishedApi
    @NotNull
    /* renamed from: constructor-impl  reason: not valid java name */
    public static long[] m310constructorimpl(@NotNull long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "storage");
        return jArr;
    }

    /* renamed from: containsAll-impl  reason: not valid java name */
    public static boolean m312containsAllimpl(long[] jArr, @NotNull Collection<ULong> collection) {
        boolean z;
        Intrinsics.checkNotNullParameter(collection, MessengerShareContentUtility.ELEMENTS);
        if (!collection.isEmpty()) {
            for (T t : collection) {
                if (!(t instanceof ULong) || !ArraysKt___ArraysKt.contains(jArr, t.m307unboximpl())) {
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
    public static boolean m313equalsimpl(long[] jArr, Object obj) {
        return (obj instanceof ULongArray) && Intrinsics.areEqual(jArr, ((ULongArray) obj).m324unboximpl());
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m314equalsimpl0(long[] jArr, long[] jArr2) {
        return Intrinsics.areEqual(jArr, jArr2);
    }

    /* renamed from: get-s-VKNKU  reason: not valid java name */
    public static final long m315getsVKNKU(long[] jArr, int i) {
        return ULong.m302constructorimpl(jArr[i]);
    }

    /* renamed from: getSize-impl  reason: not valid java name */
    public static int m316getSizeimpl(long[] jArr) {
        return jArr.length;
    }

    @PublishedApi
    public static /* synthetic */ void getStorage$annotations() {
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m317hashCodeimpl(long[] jArr) {
        if (jArr != null) {
            return Arrays.hashCode(jArr);
        }
        return 0;
    }

    /* renamed from: isEmpty-impl  reason: not valid java name */
    public static boolean m318isEmptyimpl(long[] jArr) {
        return jArr.length == 0;
    }

    @NotNull
    /* renamed from: iterator-impl  reason: not valid java name */
    public static ULongIterator m319iteratorimpl(long[] jArr) {
        return new a(jArr);
    }

    /* renamed from: set-k8EXiF4  reason: not valid java name */
    public static final void m320setk8EXiF4(long[] jArr, int i, long j) {
        jArr[i] = j;
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m321toStringimpl(long[] jArr) {
        StringBuilder L = a2.b.a.a.a.L("ULongArray(storage=");
        L.append(Arrays.toString(jArr));
        L.append(")");
        return L.toString();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.util.Collection
    public /* synthetic */ boolean add(ULong uLong) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* renamed from: add-VKZWuLQ  reason: not valid java name */
    public boolean m322addVKZWuLQ(long j) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends ULong> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof ULong) {
            return m323containsVKZWuLQ(((ULong) obj).m307unboximpl());
        }
        return false;
    }

    /* renamed from: contains-VKZWuLQ  reason: not valid java name */
    public boolean m323containsVKZWuLQ(long j) {
        return m311containsVKZWuLQ(this.a, j);
    }

    @Override // java.util.Collection
    public boolean containsAll(@NotNull Collection<? extends Object> collection) {
        return m312containsAllimpl(this.a, collection);
    }

    @Override // java.util.Collection, java.lang.Object
    public boolean equals(Object obj) {
        return m313equalsimpl(this.a, obj);
    }

    public int getSize() {
        return m316getSizeimpl(this.a);
    }

    @Override // java.util.Collection, java.lang.Object
    public int hashCode() {
        return m317hashCodeimpl(this.a);
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return m318isEmptyimpl(this.a);
    }

    @Override // java.util.Collection, java.lang.Iterable
    @NotNull
    public ULongIterator iterator() {
        return m319iteratorimpl(this.a);
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
        return m321toStringimpl(this.a);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ long[] m324unboximpl() {
        return this.a;
    }

    /* renamed from: contains-VKZWuLQ  reason: not valid java name */
    public static boolean m311containsVKZWuLQ(long[] jArr, long j) {
        return ArraysKt___ArraysKt.contains(jArr, j);
    }
}
