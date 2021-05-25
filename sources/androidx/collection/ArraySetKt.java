package androidx.collection;

import com.avito.android.publish.residential_complex_search.di.ResidentialComplexModuleKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\u001a\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000H\b¢\u0006\u0004\b\u0002\u0010\u0003\u001a-\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u00002\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0004\"\u00028\u0000¢\u0006\u0004\b\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"T", "Landroidx/collection/ArraySet;", "arraySetOf", "()Landroidx/collection/ArraySet;", "", ResidentialComplexModuleKt.VALUES, "([Ljava/lang/Object;)Landroidx/collection/ArraySet;", "collection-ktx"}, k = 2, mv = {1, 4, 0})
public final class ArraySetKt {
    @NotNull
    public static final <T> ArraySet<T> arraySetOf() {
        return new ArraySet<>();
    }

    @NotNull
    public static final <T> ArraySet<T> arraySetOf(@NotNull T... tArr) {
        Intrinsics.checkParameterIsNotNull(tArr, ResidentialComplexModuleKt.VALUES);
        ArraySet<T> arraySet = new ArraySet<>(tArr.length);
        for (T t : tArr) {
            arraySet.add(t);
        }
        return arraySet;
    }
}
