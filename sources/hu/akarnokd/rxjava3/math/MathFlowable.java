package hu.akarnokd.rxjava3.math;

import hu.akarnokd.rxjava3.util.SelfComparator;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Comparator;
import org.reactivestreams.Publisher;
import r6.a.b.h.a;
import r6.a.b.h.b;
import r6.a.b.h.c;
import r6.a.b.h.e;
import r6.a.b.h.f;
import r6.a.b.h.g;
import r6.a.b.h.h;
public final class MathFlowable {
    public MathFlowable() {
        throw new IllegalStateException("No instances!");
    }

    public static Flowable<Double> averageDouble(Publisher<? extends Number> publisher) {
        return RxJavaPlugins.onAssembly(new a(publisher));
    }

    public static Flowable<Float> averageFloat(Publisher<? extends Number> publisher) {
        return RxJavaPlugins.onAssembly(new b(publisher));
    }

    public static <T extends Comparable<? super T>> Flowable<T> max(Publisher<T> publisher) {
        return max(publisher, SelfComparator.instance());
    }

    public static <T extends Comparable<? super T>> Flowable<T> min(Publisher<T> publisher) {
        return min(publisher, SelfComparator.instance());
    }

    public static Flowable<Double> sumDouble(Publisher<Double> publisher) {
        return RxJavaPlugins.onAssembly(new e(publisher));
    }

    public static Flowable<Float> sumFloat(Publisher<Float> publisher) {
        return RxJavaPlugins.onAssembly(new f(publisher));
    }

    public static Flowable<Integer> sumInt(Publisher<Integer> publisher) {
        return RxJavaPlugins.onAssembly(new g(publisher));
    }

    public static Flowable<Long> sumLong(Publisher<Long> publisher) {
        return RxJavaPlugins.onAssembly(new h(publisher));
    }

    public static <T> Flowable<T> max(Publisher<T> publisher, Comparator<? super T> comparator) {
        return RxJavaPlugins.onAssembly(new c(publisher, comparator, -1));
    }

    public static <T> Flowable<T> min(Publisher<T> publisher, Comparator<? super T> comparator) {
        return RxJavaPlugins.onAssembly(new c(publisher, comparator, 1));
    }
}
