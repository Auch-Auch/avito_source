package hu.akarnokd.rxjava2.parallel;

import io.reactivex.Flowable;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.parallel.ParallelFlowable;
import io.reactivex.parallel.ParallelTransformer;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Comparator;
import r6.a.a.i.a;
import r6.a.a.i.b;
import r6.a.a.i.c;
import r6.a.a.i.d;
public final class ParallelTransformers {
    public ParallelTransformers() {
        throw new IllegalStateException("No instances!");
    }

    public static <T extends Comparable<? super T>> Flowable<T> orderedMerge(ParallelFlowable<T> parallelFlowable) {
        return orderedMerge(parallelFlowable, Functions.naturalOrder(), false, Flowable.bufferSize());
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
        return orderedMerge(parallelFlowable, Functions.naturalOrder(), z, Flowable.bufferSize());
    }

    public static <T extends Comparable<? super T>> Flowable<T> orderedMerge(ParallelFlowable<T> parallelFlowable, boolean z, int i) {
        return orderedMerge(parallelFlowable, Functions.naturalOrder(), z, i);
    }

    public static <T> Flowable<T> orderedMerge(ParallelFlowable<T> parallelFlowable, Comparator<? super T> comparator) {
        return orderedMerge(parallelFlowable, comparator, false, Flowable.bufferSize());
    }

    public static <T> Flowable<T> orderedMerge(ParallelFlowable<T> parallelFlowable, Comparator<? super T> comparator, boolean z) {
        return orderedMerge(parallelFlowable, comparator, z, Flowable.bufferSize());
    }

    public static <T> Flowable<T> orderedMerge(ParallelFlowable<T> parallelFlowable, Comparator<? super T> comparator, boolean z, int i) {
        ObjectHelper.requireNonNull(comparator, "comparator is null");
        ObjectHelper.requireNonNull(parallelFlowable, "sources is null");
        ObjectHelper.verifyPositive(i, "prefetch");
        return RxJavaPlugins.onAssembly(new a(parallelFlowable, comparator, z, i));
    }
}
