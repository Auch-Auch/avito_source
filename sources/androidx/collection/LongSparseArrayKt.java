package androidx.collection;

import com.google.android.gms.analytics.ecommerce.ProductAction;
import java.util.Iterator;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.LongIterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u001a(\u0010\u0005\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006\u001a0\u0010\t\u001a\u00020\b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00028\u0000H\n¢\u0006\u0004\b\t\u0010\n\u001a4\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0002¢\u0006\u0004\b\f\u0010\r\u001a0\u0010\u000f\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00028\u0000H\b¢\u0006\u0004\b\u000f\u0010\u0010\u001a6\u0010\u0012\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011H\b¢\u0006\u0004\b\u0012\u0010\u0013\u001a \u0010\u0014\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\b¢\u0006\u0004\b\u0014\u0010\u0015\u001a/\u0010\u0016\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00028\u0000H\u0007¢\u0006\u0004\b\u0016\u0010\u0017\u001aX\u0010\u001c\u001a\u00020\b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u000126\u0010\u001b\u001a2\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u0003\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0018H\b¢\u0006\u0004\b\u001c\u0010\u001d\u001a\u001d\u0010\u001f\u001a\u00020\u001e\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b\u001f\u0010 \u001a#\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000!\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b\"\u0010#\"$\u0010'\u001a\u00020$\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00018Æ\u0002@\u0006¢\u0006\u0006\u001a\u0004\b%\u0010&¨\u0006("}, d2 = {"T", "Landroidx/collection/LongSparseArray;", "", "key", "", "contains", "(Landroidx/collection/LongSparseArray;J)Z", "value", "", "set", "(Landroidx/collection/LongSparseArray;JLjava/lang/Object;)V", "other", "plus", "(Landroidx/collection/LongSparseArray;Landroidx/collection/LongSparseArray;)Landroidx/collection/LongSparseArray;", "defaultValue", "getOrDefault", "(Landroidx/collection/LongSparseArray;JLjava/lang/Object;)Ljava/lang/Object;", "Lkotlin/Function0;", "getOrElse", "(Landroidx/collection/LongSparseArray;JLkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "isNotEmpty", "(Landroidx/collection/LongSparseArray;)Z", ProductAction.ACTION_REMOVE, "(Landroidx/collection/LongSparseArray;JLjava/lang/Object;)Z", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "action", "forEach", "(Landroidx/collection/LongSparseArray;Lkotlin/jvm/functions/Function2;)V", "Lkotlin/collections/LongIterator;", "keyIterator", "(Landroidx/collection/LongSparseArray;)Lkotlin/collections/LongIterator;", "", "valueIterator", "(Landroidx/collection/LongSparseArray;)Ljava/util/Iterator;", "", "getSize", "(Landroidx/collection/LongSparseArray;)I", "size", "collection-ktx"}, k = 2, mv = {1, 4, 0})
public final class LongSparseArrayKt {
    public static final <T> boolean contains(@NotNull LongSparseArray<T> longSparseArray, long j) {
        Intrinsics.checkParameterIsNotNull(longSparseArray, "receiver$0");
        return longSparseArray.containsKey(j);
    }

    public static final <T> void forEach(@NotNull LongSparseArray<T> longSparseArray, @NotNull Function2<? super Long, ? super T, Unit> function2) {
        Intrinsics.checkParameterIsNotNull(longSparseArray, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function2, "action");
        int size = longSparseArray.size();
        for (int i = 0; i < size; i++) {
            function2.invoke(Long.valueOf(longSparseArray.keyAt(i)), longSparseArray.valueAt(i));
        }
    }

    public static final <T> T getOrDefault(@NotNull LongSparseArray<T> longSparseArray, long j, T t) {
        Intrinsics.checkParameterIsNotNull(longSparseArray, "receiver$0");
        return longSparseArray.get(j, t);
    }

    public static final <T> T getOrElse(@NotNull LongSparseArray<T> longSparseArray, long j, @NotNull Function0<? extends T> function0) {
        Intrinsics.checkParameterIsNotNull(longSparseArray, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function0, "defaultValue");
        T t = longSparseArray.get(j);
        return t != null ? t : (T) function0.invoke();
    }

    public static final <T> int getSize(@NotNull LongSparseArray<T> longSparseArray) {
        Intrinsics.checkParameterIsNotNull(longSparseArray, "receiver$0");
        return longSparseArray.size();
    }

    public static final <T> boolean isNotEmpty(@NotNull LongSparseArray<T> longSparseArray) {
        Intrinsics.checkParameterIsNotNull(longSparseArray, "receiver$0");
        return !longSparseArray.isEmpty();
    }

    @NotNull
    public static final <T> LongIterator keyIterator(@NotNull LongSparseArray<T> longSparseArray) {
        Intrinsics.checkParameterIsNotNull(longSparseArray, "receiver$0");
        return new LongIterator(longSparseArray) { // from class: androidx.collection.LongSparseArrayKt$keyIterator$1
            public int a;
            public final /* synthetic */ LongSparseArray b;

            {
                this.b = r1;
            }

            public final int getIndex() {
                return this.a;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.a < this.b.size();
            }

            @Override // kotlin.collections.LongIterator
            public long nextLong() {
                LongSparseArray longSparseArray2 = this.b;
                int i = this.a;
                this.a = i + 1;
                return longSparseArray2.keyAt(i);
            }

            public final void setIndex(int i) {
                this.a = i;
            }
        };
    }

    @NotNull
    public static final <T> LongSparseArray<T> plus(@NotNull LongSparseArray<T> longSparseArray, @NotNull LongSparseArray<T> longSparseArray2) {
        Intrinsics.checkParameterIsNotNull(longSparseArray, "receiver$0");
        Intrinsics.checkParameterIsNotNull(longSparseArray2, "other");
        LongSparseArray<T> longSparseArray3 = new LongSparseArray<>(longSparseArray2.size() + longSparseArray.size());
        longSparseArray3.putAll(longSparseArray);
        longSparseArray3.putAll(longSparseArray2);
        return longSparseArray3;
    }

    @Deprecated(message = "Replaced with member function. Remove extension import!")
    public static final <T> boolean remove(@NotNull LongSparseArray<T> longSparseArray, long j, T t) {
        Intrinsics.checkParameterIsNotNull(longSparseArray, "receiver$0");
        return longSparseArray.remove(j, t);
    }

    public static final <T> void set(@NotNull LongSparseArray<T> longSparseArray, long j, T t) {
        Intrinsics.checkParameterIsNotNull(longSparseArray, "receiver$0");
        longSparseArray.put(j, t);
    }

    @NotNull
    public static final <T> Iterator<T> valueIterator(@NotNull LongSparseArray<T> longSparseArray) {
        Intrinsics.checkParameterIsNotNull(longSparseArray, "receiver$0");
        return new Object(longSparseArray) { // from class: androidx.collection.LongSparseArrayKt$valueIterator$1
            public int a;
            public final /* synthetic */ LongSparseArray b;

            {
                this.b = r1;
            }

            public final int getIndex() {
                return this.a;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.a < this.b.size();
            }

            @Override // java.util.Iterator
            public T next() {
                LongSparseArray longSparseArray2 = this.b;
                int i = this.a;
                this.a = i + 1;
                return (T) longSparseArray2.valueAt(i);
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            }

            public final void setIndex(int i) {
                this.a = i;
            }
        };
    }
}
