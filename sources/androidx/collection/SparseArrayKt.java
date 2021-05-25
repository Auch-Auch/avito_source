package androidx.collection;

import com.google.android.gms.analytics.ecommerce.ProductAction;
import java.util.Iterator;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010(\n\u0002\b\u0006\u001a(\u0010\u0005\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006\u001a0\u0010\t\u001a\u00020\b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00028\u0000H\n¢\u0006\u0004\b\t\u0010\n\u001a4\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0002¢\u0006\u0004\b\f\u0010\r\u001a0\u0010\u000f\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00028\u0000H\b¢\u0006\u0004\b\u000f\u0010\u0010\u001a6\u0010\u0012\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011H\b¢\u0006\u0004\b\u0012\u0010\u0013\u001a \u0010\u0014\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\b¢\u0006\u0004\b\u0014\u0010\u0015\u001a/\u0010\u0016\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00028\u0000H\u0007¢\u0006\u0004\b\u0016\u0010\u0017\u001aX\u0010\u001c\u001a\u00020\b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u000126\u0010\u001b\u001a2\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u0003\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0018H\b¢\u0006\u0004\b\u001c\u0010\u001d\u001a\u001d\u0010\u001f\u001a\u00020\u001e\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b\u001f\u0010 \u001a#\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000!\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b\"\u0010#\"$\u0010&\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00018Æ\u0002@\u0006¢\u0006\u0006\u001a\u0004\b$\u0010%¨\u0006'"}, d2 = {"T", "Landroidx/collection/SparseArrayCompat;", "", "key", "", "contains", "(Landroidx/collection/SparseArrayCompat;I)Z", "value", "", "set", "(Landroidx/collection/SparseArrayCompat;ILjava/lang/Object;)V", "other", "plus", "(Landroidx/collection/SparseArrayCompat;Landroidx/collection/SparseArrayCompat;)Landroidx/collection/SparseArrayCompat;", "defaultValue", "getOrDefault", "(Landroidx/collection/SparseArrayCompat;ILjava/lang/Object;)Ljava/lang/Object;", "Lkotlin/Function0;", "getOrElse", "(Landroidx/collection/SparseArrayCompat;ILkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "isNotEmpty", "(Landroidx/collection/SparseArrayCompat;)Z", ProductAction.ACTION_REMOVE, "(Landroidx/collection/SparseArrayCompat;ILjava/lang/Object;)Z", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "action", "forEach", "(Landroidx/collection/SparseArrayCompat;Lkotlin/jvm/functions/Function2;)V", "Lkotlin/collections/IntIterator;", "keyIterator", "(Landroidx/collection/SparseArrayCompat;)Lkotlin/collections/IntIterator;", "", "valueIterator", "(Landroidx/collection/SparseArrayCompat;)Ljava/util/Iterator;", "getSize", "(Landroidx/collection/SparseArrayCompat;)I", "size", "collection-ktx"}, k = 2, mv = {1, 4, 0})
public final class SparseArrayKt {
    public static final <T> boolean contains(@NotNull SparseArrayCompat<T> sparseArrayCompat, int i) {
        Intrinsics.checkParameterIsNotNull(sparseArrayCompat, "receiver$0");
        return sparseArrayCompat.containsKey(i);
    }

    public static final <T> void forEach(@NotNull SparseArrayCompat<T> sparseArrayCompat, @NotNull Function2<? super Integer, ? super T, Unit> function2) {
        Intrinsics.checkParameterIsNotNull(sparseArrayCompat, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function2, "action");
        int size = sparseArrayCompat.size();
        for (int i = 0; i < size; i++) {
            function2.invoke(Integer.valueOf(sparseArrayCompat.keyAt(i)), sparseArrayCompat.valueAt(i));
        }
    }

    public static final <T> T getOrDefault(@NotNull SparseArrayCompat<T> sparseArrayCompat, int i, T t) {
        Intrinsics.checkParameterIsNotNull(sparseArrayCompat, "receiver$0");
        return sparseArrayCompat.get(i, t);
    }

    public static final <T> T getOrElse(@NotNull SparseArrayCompat<T> sparseArrayCompat, int i, @NotNull Function0<? extends T> function0) {
        Intrinsics.checkParameterIsNotNull(sparseArrayCompat, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function0, "defaultValue");
        T t = sparseArrayCompat.get(i);
        return t != null ? t : (T) function0.invoke();
    }

    public static final <T> int getSize(@NotNull SparseArrayCompat<T> sparseArrayCompat) {
        Intrinsics.checkParameterIsNotNull(sparseArrayCompat, "receiver$0");
        return sparseArrayCompat.size();
    }

    public static final <T> boolean isNotEmpty(@NotNull SparseArrayCompat<T> sparseArrayCompat) {
        Intrinsics.checkParameterIsNotNull(sparseArrayCompat, "receiver$0");
        return !sparseArrayCompat.isEmpty();
    }

    @NotNull
    public static final <T> IntIterator keyIterator(@NotNull SparseArrayCompat<T> sparseArrayCompat) {
        Intrinsics.checkParameterIsNotNull(sparseArrayCompat, "receiver$0");
        return new IntIterator(sparseArrayCompat) { // from class: androidx.collection.SparseArrayKt$keyIterator$1
            public int a;
            public final /* synthetic */ SparseArrayCompat b;

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

            @Override // kotlin.collections.IntIterator
            public int nextInt() {
                SparseArrayCompat sparseArrayCompat2 = this.b;
                int i = this.a;
                this.a = i + 1;
                return sparseArrayCompat2.keyAt(i);
            }

            public final void setIndex(int i) {
                this.a = i;
            }
        };
    }

    @NotNull
    public static final <T> SparseArrayCompat<T> plus(@NotNull SparseArrayCompat<T> sparseArrayCompat, @NotNull SparseArrayCompat<T> sparseArrayCompat2) {
        Intrinsics.checkParameterIsNotNull(sparseArrayCompat, "receiver$0");
        Intrinsics.checkParameterIsNotNull(sparseArrayCompat2, "other");
        SparseArrayCompat<T> sparseArrayCompat3 = new SparseArrayCompat<>(sparseArrayCompat2.size() + sparseArrayCompat.size());
        sparseArrayCompat3.putAll(sparseArrayCompat);
        sparseArrayCompat3.putAll(sparseArrayCompat2);
        return sparseArrayCompat3;
    }

    @Deprecated(message = "Replaced with member function. Remove extension import!")
    public static final <T> boolean remove(@NotNull SparseArrayCompat<T> sparseArrayCompat, int i, T t) {
        Intrinsics.checkParameterIsNotNull(sparseArrayCompat, "receiver$0");
        return sparseArrayCompat.remove(i, t);
    }

    public static final <T> void set(@NotNull SparseArrayCompat<T> sparseArrayCompat, int i, T t) {
        Intrinsics.checkParameterIsNotNull(sparseArrayCompat, "receiver$0");
        sparseArrayCompat.put(i, t);
    }

    @NotNull
    public static final <T> Iterator<T> valueIterator(@NotNull SparseArrayCompat<T> sparseArrayCompat) {
        Intrinsics.checkParameterIsNotNull(sparseArrayCompat, "receiver$0");
        return new Object(sparseArrayCompat) { // from class: androidx.collection.SparseArrayKt$valueIterator$1
            public int a;
            public final /* synthetic */ SparseArrayCompat b;

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
                SparseArrayCompat sparseArrayCompat2 = this.b;
                int i = this.a;
                this.a = i + 1;
                return (T) sparseArrayCompat2.valueAt(i);
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
