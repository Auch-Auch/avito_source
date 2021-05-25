package t6.n;

import com.facebook.share.internal.MessengerShareContentUtility;
import java.util.Collections;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;
import kotlin.ExperimentalStdlibApi;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.builders.SetBuilder;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
public class x {
    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @NotNull
    @PublishedApi
    public static final <E> Set<E> build(@NotNull Set<E> set) {
        Intrinsics.checkNotNullParameter(set, "builder");
        return ((SetBuilder) set).build();
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @NotNull
    @PublishedApi
    public static final <E> Set<E> createSetBuilder() {
        return new SetBuilder();
    }

    @NotNull
    public static final <T> Set<T> setOf(T t) {
        Set<T> singleton = Collections.singleton(t);
        Intrinsics.checkNotNullExpressionValue(singleton, "java.util.Collections.singleton(element)");
        return singleton;
    }

    @NotNull
    public static final <T> TreeSet<T> sortedSetOf(@NotNull T... tArr) {
        Intrinsics.checkNotNullParameter(tArr, MessengerShareContentUtility.ELEMENTS);
        return (TreeSet) ArraysKt___ArraysKt.toCollection(tArr, new TreeSet());
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @NotNull
    @PublishedApi
    public static final <E> Set<E> createSetBuilder(int i) {
        return new SetBuilder(i);
    }

    @NotNull
    public static final <T> TreeSet<T> sortedSetOf(@NotNull Comparator<? super T> comparator, @NotNull T... tArr) {
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Intrinsics.checkNotNullParameter(tArr, MessengerShareContentUtility.ELEMENTS);
        return (TreeSet) ArraysKt___ArraysKt.toCollection(tArr, new TreeSet(comparator));
    }
}
