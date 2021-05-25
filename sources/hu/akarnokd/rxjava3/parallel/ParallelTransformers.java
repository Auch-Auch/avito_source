package hu.akarnokd.rxjava3.parallel;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.internal.functions.ObjectHelper;
import io.reactivex.rxjava3.parallel.ParallelFlowable;
import io.reactivex.rxjava3.parallel.ParallelTransformer;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Comparator;
import java.util.Objects;
import r6.a.b.j.a;
import r6.a.b.j.b;
import r6.a.b.j.c;
import r6.a.b.j.d;
public final class ParallelTransformers {
    public ParallelTransformers() {
        throw new IllegalStateException("No instances!");
    }

    public static <T extends Comparable<? super T>> Flowable<T> orderedMerge(ParallelFlowable<T> parallelFlowable) {
        return orderedMerge(parallelFlowable, Comparator.naturalOrder(), false, Flowable.bufferSize());
    }

    public static <T extends Number> ParallelTransformer<T, Double> sumDouble() {
        return new b(null);
    }

    public static <T extends Number> ParallelTransformer<T, Integer> sumInteger() {
        return new c(null);
    }

    public static <T extends Number> ParallelTransformer<T, Long> sumLong() {
        return new d(null);
    }

    public static <T extends Comparable<? super T>> Flowable<T> orderedMerge(ParallelFlowable<T> parallelFlowable, boolean z) {
        return orderedMerge(parallelFlowable, Comparator.naturalOrder(), z, Flowable.bufferSize());
    }

    public static <T extends Comparable<? super T>> Flowable<T> orderedMerge(ParallelFlowable<T> parallelFlowable, boolean z, int i) {
        return orderedMerge(parallelFlowable, Comparator.naturalOrder(), z, i);
    }

    public static <T> Flowable<T> orderedMerge(ParallelFlowable<T> parallelFlowable, Comparator<? super T> comparator) {
        return orderedMerge(parallelFlowable, comparator, false, Flowable.bufferSize());
    }

    public static <T> Flowable<T> orderedMerge(ParallelFlowable<T> parallelFlowable, Comparator<? super T> comparator, boolean z) {
        return orderedMerge(parallelFlowable, comparator, z, Flowable.bufferSize());
    }

    public static <T> Flowable<T> orderedMerge(ParallelFlowable<T> parallelFlowable, Comparator<? super T> comparator, boolean z, int i) {
        Objects.requireNonNull(comparator, "comparator is null");
        Objects.requireNonNull(parallelFlowable, "sources is null");
        ObjectHelper.verifyPositive(i, "prefetch");
        return RxJavaPlugins.onAssembly(new a(parallelFlowable, comparator, z, i));
    }
}
