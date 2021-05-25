package hu.akarnokd.rxjava3.bridge;

import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import io.reactivex.rxjava3.core.CompletableConverter;
import io.reactivex.rxjava3.core.FlowableConverter;
import io.reactivex.rxjava3.core.MaybeConverter;
import io.reactivex.rxjava3.core.ObservableConverter;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.core.SingleConverter;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;
import java.util.Objects;
import r6.a.b.c.i;
import r6.a.b.c.j;
import r6.a.b.c.k;
import r6.a.b.c.l;
import r6.a.b.c.m;
import r6.a.b.c.n;
import r6.a.b.c.o;
public final class RxJavaBridge {

    public class a implements Function<Scheduler, Scheduler> {
        public final /* synthetic */ Scheduler a;

        public a(Scheduler scheduler) {
            this.a = scheduler;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public Scheduler apply(Scheduler scheduler) throws Throwable {
            return this.a;
        }
    }

    public class b implements Function<Scheduler, Scheduler> {
        public final /* synthetic */ Scheduler a;

        public b(Scheduler scheduler) {
            this.a = scheduler;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public Scheduler apply(Scheduler scheduler) throws Throwable {
            return this.a;
        }
    }

    public class c implements Function<Scheduler, Scheduler> {
        public final /* synthetic */ Scheduler a;

        public c(Scheduler scheduler) {
            this.a = scheduler;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public Scheduler apply(Scheduler scheduler) throws Throwable {
            return this.a;
        }
    }

    public class d implements Function<Scheduler, Scheduler> {
        public final /* synthetic */ Scheduler a;

        public d(Scheduler scheduler) {
            this.a = scheduler;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public Scheduler apply(Scheduler scheduler) throws Throwable {
            return this.a;
        }
    }

    public class e implements io.reactivex.functions.Function<io.reactivex.Scheduler, io.reactivex.Scheduler> {
        public final /* synthetic */ io.reactivex.Scheduler a;

        public e(io.reactivex.Scheduler scheduler) {
            this.a = scheduler;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public io.reactivex.Scheduler apply(io.reactivex.Scheduler scheduler) throws Exception {
            return this.a;
        }
    }

    public class f implements io.reactivex.functions.Function<io.reactivex.Scheduler, io.reactivex.Scheduler> {
        public final /* synthetic */ io.reactivex.Scheduler a;

        public f(io.reactivex.Scheduler scheduler) {
            this.a = scheduler;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public io.reactivex.Scheduler apply(io.reactivex.Scheduler scheduler) throws Exception {
            return this.a;
        }
    }

    public class g implements io.reactivex.functions.Function<io.reactivex.Scheduler, io.reactivex.Scheduler> {
        public final /* synthetic */ io.reactivex.Scheduler a;

        public g(io.reactivex.Scheduler scheduler) {
            this.a = scheduler;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public io.reactivex.Scheduler apply(io.reactivex.Scheduler scheduler) throws Exception {
            return this.a;
        }
    }

    public class h implements io.reactivex.functions.Function<io.reactivex.Scheduler, io.reactivex.Scheduler> {
        public final /* synthetic */ io.reactivex.Scheduler a;

        public h(io.reactivex.Scheduler scheduler) {
            this.a = scheduler;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public io.reactivex.Scheduler apply(io.reactivex.Scheduler scheduler) throws Exception {
            return this.a;
        }
    }

    public RxJavaBridge() {
        throw new IllegalStateException("No instances!");
    }

    public static void startUsingV2Schedulers() {
        Scheduler v3Scheduler = toV3Scheduler(Schedulers.computation());
        Scheduler v3Scheduler2 = toV3Scheduler(Schedulers.io());
        Scheduler v3Scheduler3 = toV3Scheduler(Schedulers.single());
        Scheduler v3Scheduler4 = toV3Scheduler(Schedulers.newThread());
        RxJavaPlugins.setComputationSchedulerHandler(new a(v3Scheduler));
        RxJavaPlugins.setIoSchedulerHandler(new b(v3Scheduler2));
        RxJavaPlugins.setSingleSchedulerHandler(new c(v3Scheduler3));
        RxJavaPlugins.setNewThreadSchedulerHandler(new d(v3Scheduler4));
    }

    public static void startUsingV3Schedulers() {
        io.reactivex.Scheduler v2Scheduler = toV2Scheduler(io.reactivex.rxjava3.schedulers.Schedulers.computation());
        io.reactivex.Scheduler v2Scheduler2 = toV2Scheduler(io.reactivex.rxjava3.schedulers.Schedulers.io());
        io.reactivex.Scheduler v2Scheduler3 = toV2Scheduler(io.reactivex.rxjava3.schedulers.Schedulers.single());
        io.reactivex.Scheduler v2Scheduler4 = toV2Scheduler(io.reactivex.rxjava3.schedulers.Schedulers.newThread());
        io.reactivex.plugins.RxJavaPlugins.setComputationSchedulerHandler(new e(v2Scheduler));
        io.reactivex.plugins.RxJavaPlugins.setIoSchedulerHandler(new f(v2Scheduler2));
        io.reactivex.plugins.RxJavaPlugins.setSingleSchedulerHandler(new g(v2Scheduler3));
        io.reactivex.plugins.RxJavaPlugins.setNewThreadSchedulerHandler(new h(v2Scheduler4));
    }

    public static void stopUsingV2Schedulers() {
        RxJavaPlugins.setComputationSchedulerHandler(null);
        RxJavaPlugins.setIoSchedulerHandler(null);
        RxJavaPlugins.setSingleSchedulerHandler(null);
        RxJavaPlugins.setNewThreadSchedulerHandler(null);
    }

    public static void stopUsingV3Schedulers() {
        io.reactivex.plugins.RxJavaPlugins.setComputationSchedulerHandler(null);
        io.reactivex.plugins.RxJavaPlugins.setIoSchedulerHandler(null);
        io.reactivex.plugins.RxJavaPlugins.setSingleSchedulerHandler(null);
        io.reactivex.plugins.RxJavaPlugins.setNewThreadSchedulerHandler(null);
    }

    public static Completable toV2Completable(io.reactivex.rxjava3.core.Completable completable) {
        Objects.requireNonNull(completable, "source is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new r6.a.b.c.b(completable));
    }

    public static Disposable toV2Disposable(io.reactivex.rxjava3.disposables.Disposable disposable) {
        Objects.requireNonNull(disposable, "disposable is null");
        return r6.a.b.c.d.a(disposable);
    }

    public static <T> Flowable<T> toV2Flowable(io.reactivex.rxjava3.core.Flowable<T> flowable) {
        Objects.requireNonNull(flowable, "source is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new r6.a.b.c.g(flowable));
    }

    public static <T> Maybe<T> toV2Maybe(io.reactivex.rxjava3.core.Maybe<T> maybe) {
        Objects.requireNonNull(maybe, "source is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new i(maybe));
    }

    public static <T> Observable<T> toV2Observable(io.reactivex.rxjava3.core.Observable<T> observable) {
        Objects.requireNonNull(observable, "source is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new k(observable));
    }

    public static io.reactivex.Scheduler toV2Scheduler(Scheduler scheduler) {
        Objects.requireNonNull(scheduler, "scheduler is null");
        return new m(scheduler);
    }

    public static <T> Single<T> toV2Single(io.reactivex.rxjava3.core.Single<T> single) {
        Objects.requireNonNull(single, "source is null");
        return io.reactivex.plugins.RxJavaPlugins.onAssembly(new o(single));
    }

    public static io.reactivex.rxjava3.core.Completable toV3Completable(Completable completable) {
        Objects.requireNonNull(completable, "source is null");
        return RxJavaPlugins.onAssembly(new r6.a.b.c.a(completable));
    }

    public static io.reactivex.rxjava3.disposables.Disposable toV3Disposable(Disposable disposable) {
        Objects.requireNonNull(disposable, "disposable is null");
        return r6.a.b.c.c.a(disposable);
    }

    public static <T> io.reactivex.rxjava3.core.Flowable<T> toV3Flowable(Flowable<T> flowable) {
        Objects.requireNonNull(flowable, "source is null");
        return RxJavaPlugins.onAssembly(new r6.a.b.c.f(flowable));
    }

    public static <T> io.reactivex.rxjava3.core.Maybe<T> toV3Maybe(Maybe<T> maybe) {
        Objects.requireNonNull(maybe, "source is null");
        return RxJavaPlugins.onAssembly(new r6.a.b.c.h(maybe));
    }

    public static <T> io.reactivex.rxjava3.core.Observable<T> toV3Observable(Observable<T> observable) {
        Objects.requireNonNull(observable, "source is null");
        return RxJavaPlugins.onAssembly(new j(observable));
    }

    public static Scheduler toV3Scheduler(io.reactivex.Scheduler scheduler) {
        Objects.requireNonNull(scheduler, "scheduler is null");
        return new l(scheduler);
    }

    public static <T> io.reactivex.rxjava3.core.Single<T> toV3Single(Single<T> single) {
        Objects.requireNonNull(single, "source is null");
        return RxJavaPlugins.onAssembly(new n(single));
    }

    public static CompletableConverter<Completable> toV2Completable() {
        return r6.a.b.c.b.b;
    }

    public static <T> FlowableConverter<T, Flowable<T>> toV2Flowable() {
        return r6.a.b.c.g.c;
    }

    public static <T> MaybeConverter<T, Maybe<T>> toV2Maybe() {
        return i.b;
    }

    public static <T> ObservableConverter<T, Observable<T>> toV2Observable() {
        return k.b;
    }

    public static <T> SingleConverter<T, Single<T>> toV2Single() {
        return o.b;
    }

    public static io.reactivex.CompletableConverter<io.reactivex.rxjava3.core.Completable> toV3Completable() {
        return r6.a.b.c.a.b;
    }

    public static <T> io.reactivex.FlowableConverter<T, io.reactivex.rxjava3.core.Flowable<T>> toV3Flowable() {
        return r6.a.b.c.f.c;
    }

    public static <T> io.reactivex.MaybeConverter<T, io.reactivex.rxjava3.core.Maybe<T>> toV3Maybe() {
        return r6.a.b.c.h.b;
    }

    public static <T> io.reactivex.ObservableConverter<T, io.reactivex.rxjava3.core.Observable<T>> toV3Observable() {
        return j.b;
    }

    public static <T> io.reactivex.SingleConverter<T, io.reactivex.rxjava3.core.Single<T>> toV3Single() {
        return n.b;
    }
}
