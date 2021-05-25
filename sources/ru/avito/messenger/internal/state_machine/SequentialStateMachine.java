package ru.avito.messenger.internal.state_machine;

import a2.g.r.g;
import a7.a.b.a.o.d;
import androidx.exifinterface.media.ExifInterface;
import com.avito.android.remote.auth.AuthSource;
import com.jakewharton.rxrelay2.BehaviorRelay;
import com.jakewharton.rxrelay2.Relay;
import com.yandex.mobile.ads.video.tracking.Tracker;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.SingleSource;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiPredicate;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.rxkotlin.DisposableKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.avito.messenger.internal.log.Logger;
import ru.avito.messenger.internal.state_machine.StateMachine;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B%\b\u0016\u0012\u0006\u0010\u001e\u001a\u00020\u001b\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u000f¢\u0006\u0004\b)\u0010*B-\b\u0016\u0012\u0006\u0010+\u001a\u00028\u0000\u0012\u0006\u0010\u001e\u001a\u00020\u001b\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u000f¢\u0006\u0004\b)\u0010,J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\t\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\u0006R\u0016\u0010\u000e\u001a\u00020\u00018\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u001c\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00000\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\"\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00070\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010\u0019R\u001c\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00000!8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010'¨\u0006-"}, d2 = {"Lru/avito/messenger/internal/state_machine/SequentialStateMachine;", "", ExifInterface.LATITUDE_SOUTH, "Lru/avito/messenger/internal/state_machine/StateMachine;", "", Tracker.Events.CREATIVE_START, "()V", "Lru/avito/messenger/internal/state_machine/StateMachine$Mutator;", "mutator", "enqueue", "(Lru/avito/messenger/internal/state_machine/StateMachine$Mutator;)V", "shutdown", AuthSource.SEND_ABUSE, "Ljava/lang/Object;", "lock", "", "f", "Ljava/lang/String;", "tag", "Lio/reactivex/Scheduler;", AuthSource.BOOKING_ORDER, "Lio/reactivex/Scheduler;", "scheduler", "Lcom/jakewharton/rxrelay2/Relay;", "d", "Lcom/jakewharton/rxrelay2/Relay;", "stateRelay", "Lru/avito/messenger/internal/log/Logger;", "c", "Lru/avito/messenger/internal/log/Logger;", "logger", "e", "mutatorsRelay", "Lio/reactivex/Observable;", "getStateObservable", "()Lio/reactivex/Observable;", "stateObservable", "Lio/reactivex/disposables/CompositeDisposable;", g.a, "Lio/reactivex/disposables/CompositeDisposable;", "disposable", "<init>", "(Lru/avito/messenger/internal/log/Logger;Lio/reactivex/Scheduler;Ljava/lang/String;)V", "initialState", "(Ljava/lang/Object;Lru/avito/messenger/internal/log/Logger;Lio/reactivex/Scheduler;Ljava/lang/String;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class SequentialStateMachine<S> implements StateMachine<S> {
    public final Object a;
    public final Scheduler b;
    public final Logger c;
    public final Relay<S> d;
    public final Relay<StateMachine.Mutator<S>> e;
    public final String f;
    public final CompositeDisposable g;

    public static final class a<T, R> implements Function<StateMachine.Mutator<S>, SingleSource<? extends S>> {
        public final /* synthetic */ SequentialStateMachine a;

        public a(SequentialStateMachine sequentialStateMachine) {
            this.a = sequentialStateMachine;
        }

        @Override // io.reactivex.functions.Function
        public Object apply(Object obj) {
            StateMachine.Mutator mutator = (StateMachine.Mutator) obj;
            Intrinsics.checkNotNullParameter(mutator, "mutator");
            return this.a.d.firstOrError().flatMap(new a7.a.b.a.o.b(this, mutator)).doOnSuccess(new SequentialStateMachine$sam$i$io_reactivex_functions_Consumer$0(new a7.a.b.a.o.c(this.a.d))).doOnSuccess(new d(this));
        }
    }

    public static final class b<T> implements Consumer<Throwable> {
        public final /* synthetic */ SequentialStateMachine a;

        public b(SequentialStateMachine sequentialStateMachine) {
            this.a = sequentialStateMachine;
        }

        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            this.a.c.e(this.a.f, "Mutator handling terminated with error", th);
        }
    }

    public static final class c<T1, T2> implements BiPredicate<S, S> {
        public static final c a = new c();

        @Override // io.reactivex.functions.BiPredicate
        public final boolean test(@NotNull S s, @NotNull S s2) {
            Intrinsics.checkNotNullParameter(s, "oldState");
            Intrinsics.checkNotNullParameter(s2, "newState");
            return s == s2;
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ SequentialStateMachine(ru.avito.messenger.internal.log.Logger r1, io.reactivex.Scheduler r2, java.lang.String r3, int r4, t6.r.a.j r5) {
        /*
            r0 = this;
            r5 = r4 & 2
            if (r5 == 0) goto L_0x0013
            io.reactivex.Scheduler r2 = io.reactivex.schedulers.Schedulers.io()
            java.lang.String r5 = "Schedulers.io()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r5)
            hu.akarnokd.rxjava2.schedulers.SharedScheduler r5 = new hu.akarnokd.rxjava2.schedulers.SharedScheduler
            r5.<init>(r2)
            r2 = r5
        L_0x0013:
            r4 = r4 & 4
            if (r4 == 0) goto L_0x0019
            java.lang.String r3 = "StateMachine"
        L_0x0019:
            r0.<init>(r1, r2, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.avito.messenger.internal.state_machine.SequentialStateMachine.<init>(ru.avito.messenger.internal.log.Logger, io.reactivex.Scheduler, java.lang.String, int, t6.r.a.j):void");
    }

    @Override // ru.avito.messenger.internal.state_machine.StateMachine
    public void enqueue(@NotNull StateMachine.Mutator<S> mutator) {
        Intrinsics.checkNotNullParameter(mutator, "mutator");
        synchronized (this.a) {
            if (this.g.isDisposed()) {
                Logger.DefaultImpls.d$default(this.c, this.f, "Already shut down, command won't be processed.", null, 4, null);
            } else if (this.g.size() < 1) {
                throw new IllegalStateException("State machine has not been started");
            }
        }
        this.e.accept(mutator);
    }

    @Override // ru.avito.messenger.internal.state_machine.StateMachine
    @NotNull
    public Observable<S> getStateObservable() {
        Observable<S> distinctUntilChanged = this.d.distinctUntilChanged(c.a);
        Intrinsics.checkNotNullExpressionValue(distinctUntilChanged, "stateRelay.distinctUntil…> oldState === newState }");
        return distinctUntilChanged;
    }

    @Override // ru.avito.messenger.internal.state_machine.StateMachine
    public void shutdown() {
        synchronized (this.a) {
            Logger.DefaultImpls.d$default(this.c, this.f, "Shut down", null, 4, null);
            this.g.dispose();
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // ru.avito.messenger.internal.state_machine.StateMachine
    public void start() {
        synchronized (this.a) {
            if (!this.g.isDisposed()) {
                this.g.clear();
                Disposable subscribe = this.e.subscribeOn(this.b).observeOn(this.b).toFlowable(BackpressureStrategy.BUFFER).concatMapSingle(new a(this)).doOnError(new b(this)).subscribe();
                Intrinsics.checkNotNullExpressionValue(subscribe, "mutatorsRelay\n          …             .subscribe()");
                DisposableKt.addTo(subscribe, this.g);
                Logger.DefaultImpls.d$default(this.c, this.f, "Started", null, 4, null);
                Unit unit = Unit.INSTANCE;
            } else {
                throw new IllegalStateException("State machine has already been shut down");
            }
        }
    }

    public SequentialStateMachine(@NotNull Logger logger, @NotNull Scheduler scheduler, @NotNull String str) {
        Intrinsics.checkNotNullParameter(logger, "logger");
        Intrinsics.checkNotNullParameter(scheduler, "scheduler");
        Intrinsics.checkNotNullParameter(str, "tag");
        this.a = new Object();
        this.e = a2.b.a.a.a.J1("PublishRelay.create<T>().toSerialized()");
        this.g = new CompositeDisposable();
        this.b = scheduler;
        this.c = logger;
        this.f = str;
        Relay<S> serialized = BehaviorRelay.create().toSerialized();
        Intrinsics.checkNotNullExpressionValue(serialized, "BehaviorRelay.create<T>().toSerialized()");
        this.d = serialized;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ SequentialStateMachine(java.lang.Object r1, ru.avito.messenger.internal.log.Logger r2, io.reactivex.Scheduler r3, java.lang.String r4, int r5, t6.r.a.j r6) {
        /*
            r0 = this;
            r6 = r5 & 4
            if (r6 == 0) goto L_0x0013
            io.reactivex.Scheduler r3 = io.reactivex.schedulers.Schedulers.io()
            java.lang.String r6 = "Schedulers.io()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r6)
            hu.akarnokd.rxjava2.schedulers.SharedScheduler r6 = new hu.akarnokd.rxjava2.schedulers.SharedScheduler
            r6.<init>(r3)
            r3 = r6
        L_0x0013:
            r5 = r5 & 8
            if (r5 == 0) goto L_0x0019
            java.lang.String r4 = "StateMachine"
        L_0x0019:
            r0.<init>(r1, r2, r3, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.avito.messenger.internal.state_machine.SequentialStateMachine.<init>(java.lang.Object, ru.avito.messenger.internal.log.Logger, io.reactivex.Scheduler, java.lang.String, int, t6.r.a.j):void");
    }

    public SequentialStateMachine(@NotNull S s, @NotNull Logger logger, @NotNull Scheduler scheduler, @NotNull String str) {
        Intrinsics.checkNotNullParameter(s, "initialState");
        Intrinsics.checkNotNullParameter(logger, "logger");
        Intrinsics.checkNotNullParameter(scheduler, "scheduler");
        Intrinsics.checkNotNullParameter(str, "tag");
        this.a = new Object();
        this.e = a2.b.a.a.a.J1("PublishRelay.create<T>().toSerialized()");
        this.g = new CompositeDisposable();
        this.b = scheduler;
        this.c = logger;
        this.f = str;
        Relay<S> serialized = BehaviorRelay.createDefault(s).toSerialized();
        Intrinsics.checkNotNullExpressionValue(serialized, "BehaviorRelay.createDefa…aultValue).toSerialized()");
        this.d = serialized;
    }
}
