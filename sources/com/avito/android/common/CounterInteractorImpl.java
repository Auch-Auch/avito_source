package com.avito.android.common;

import com.avito.android.account.AccountStateProvider;
import com.avito.android.common.CounterInteractor;
import com.avito.android.notification_manager_provider.NotificationManagerProvider;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Logs;
import com.avito.android.util.SchedulersFactory3;
import com.jakewharton.rxrelay3.BehaviorRelay;
import com.jakewharton.rxrelay3.PublishRelay;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Predicate;
import io.reactivex.rxjava3.kotlin.DisposableKt;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B)\b\u0007\u0012\u0006\u00101\u001a\u00020.\u0012\u0006\u0010\u001d\u001a\u00020\u001a\u0012\u0006\u0010)\u001a\u00020&\u0012\u0006\u0010!\u001a\u00020\u001e¢\u0006\u0004\b2\u00103J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0010\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u000bH\u0004¢\u0006\u0004\b\u0011\u0010\rR\u001c\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00060\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u001c\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00030\"8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b/\u00100¨\u00064"}, d2 = {"Lcom/avito/android/common/CounterInteractorImpl;", "Lcom/avito/android/common/CounterInteractor;", "Lio/reactivex/rxjava3/core/Observable;", "", "changes", "()Lio/reactivex/rxjava3/core/Observable;", "", "force", "", "requestUpdate", "(Z)V", "Lio/reactivex/rxjava3/core/Completable;", "executeUpdate", "()Lio/reactivex/rxjava3/core/Completable;", "reset", "()V", "onStateChanged", "loadCounter", "Lcom/jakewharton/rxrelay3/PublishRelay;", AuthSource.BOOKING_ORDER, "Lcom/jakewharton/rxrelay3/PublishRelay;", "updateRequestsRelay", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "c", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "disposables", "Lcom/avito/android/common/CounterLoader;", "f", "Lcom/avito/android/common/CounterLoader;", "counterLoader", "Lcom/avito/android/notification_manager_provider/NotificationManagerProvider;", "h", "Lcom/avito/android/notification_manager_provider/NotificationManagerProvider;", "notificationManagerProvider", "Lcom/jakewharton/rxrelay3/BehaviorRelay;", AuthSource.SEND_ABUSE, "Lcom/jakewharton/rxrelay3/BehaviorRelay;", "counterRelay", "Lcom/avito/android/account/AccountStateProvider;", a2.g.r.g.a, "Lcom/avito/android/account/AccountStateProvider;", "accountStateProvider", "", "d", "J", "lastTryUpdateTimestamp", "Lcom/avito/android/util/SchedulersFactory3;", "e", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "<init>", "(Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/common/CounterLoader;Lcom/avito/android/account/AccountStateProvider;Lcom/avito/android/notification_manager_provider/NotificationManagerProvider;)V", "favorite-core_release"}, k = 1, mv = {1, 4, 2})
public final class CounterInteractorImpl implements CounterInteractor {
    public final BehaviorRelay<Integer> a;
    public final PublishRelay<Boolean> b;
    public final CompositeDisposable c;
    public long d;
    public final SchedulersFactory3 e;
    public final CounterLoader f;
    public final AccountStateProvider g;
    public final NotificationManagerProvider h;

    public static final class a<T> implements Predicate<Boolean> {
        public final /* synthetic */ CounterInteractorImpl a;

        public a(CounterInteractorImpl counterInteractorImpl) {
            this.a = counterInteractorImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Predicate
        public boolean test(Boolean bool) {
            Boolean bool2 = bool;
            CounterInteractorImpl counterInteractorImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(bool2, "it");
            return CounterInteractorImpl.access$shouldUpdate(counterInteractorImpl, bool2.booleanValue());
        }
    }

    public static final class b<T, R> implements Function<Boolean, ObservableSource<? extends Unit>> {
        public final /* synthetic */ CounterInteractorImpl a;

        public b(CounterInteractorImpl counterInteractorImpl) {
            this.a = counterInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public ObservableSource<? extends Unit> apply(Boolean bool) {
            return this.a.loadCounter().andThen(Observable.just(Unit.INSTANCE));
        }
    }

    public static final class c<T> implements Consumer<Unit> {
        public static final c a = new c();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Unit unit) {
        }
    }

    public static final class d<T> implements Consumer<Throwable> {
        public static final d a = new d();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            Logs.error(th);
        }
    }

    public static final class e<T, R> implements Function<Boolean, ObservableSource<? extends Integer>> {
        public final /* synthetic */ CounterInteractorImpl a;

        public e(CounterInteractorImpl counterInteractorImpl) {
            this.a = counterInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public ObservableSource<? extends Integer> apply(Boolean bool) {
            Boolean bool2 = bool;
            Intrinsics.checkNotNullExpressionValue(bool2, "isAuthorized");
            if (!bool2.booleanValue() || !CounterInteractorImpl.access$isUpdateEnabled(this.a)) {
                return Observable.just(0);
            }
            return this.a.f.load().subscribeOn(this.a.e.io());
        }
    }

    public static final class f<T> implements Consumer<Throwable> {
        public static final f a = new f();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            Logs.error(th);
        }
    }

    public static final class g<T, R> implements Function<Throwable, ObservableSource<? extends Integer>> {
        public static final g a = new g();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public ObservableSource<? extends Integer> apply(Throwable th) {
            return Observable.just(0);
        }
    }

    public static final class h<T> implements Consumer<Disposable> {
        public final /* synthetic */ CounterInteractorImpl a;

        public h(CounterInteractorImpl counterInteractorImpl) {
            this.a = counterInteractorImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Disposable disposable) {
            this.a.d = System.currentTimeMillis();
        }
    }

    public static final class i<T> implements Consumer<Integer> {
        public final /* synthetic */ CounterInteractorImpl a;

        public i(CounterInteractorImpl counterInteractorImpl) {
            this.a = counterInteractorImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: com.jakewharton.rxrelay3.BehaviorRelay */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Integer num) {
            this.a.a.accept(num);
        }
    }

    @Inject
    public CounterInteractorImpl(@NotNull SchedulersFactory3 schedulersFactory3, @NotNull CounterLoader counterLoader, @NotNull AccountStateProvider accountStateProvider, @NotNull NotificationManagerProvider notificationManagerProvider) {
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(counterLoader, "counterLoader");
        Intrinsics.checkNotNullParameter(accountStateProvider, "accountStateProvider");
        Intrinsics.checkNotNullParameter(notificationManagerProvider, "notificationManagerProvider");
        this.e = schedulersFactory3;
        this.f = counterLoader;
        this.g = accountStateProvider;
        this.h = notificationManagerProvider;
        BehaviorRelay<Integer> create = BehaviorRelay.create();
        Intrinsics.checkNotNullExpressionValue(create, "BehaviorRelay.create()");
        this.a = create;
        PublishRelay<Boolean> create2 = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create2, "PublishRelay.create()");
        this.b = create2;
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        this.c = compositeDisposable;
        Disposable subscribe = create2.filter(new a(this)).concatMap(new b(this)).subscribe(c.a, d.a);
        Intrinsics.checkNotNullExpressionValue(subscribe, "updateRequestsRelay\n    …be({}) { Logs.error(it) }");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    public static final boolean access$isUpdateEnabled(CounterInteractorImpl counterInteractorImpl) {
        return counterInteractorImpl.h.getAreNotificationsEnabled();
    }

    public static final boolean access$shouldUpdate(CounterInteractorImpl counterInteractorImpl, boolean z) {
        Objects.requireNonNull(counterInteractorImpl);
        if (z || !counterInteractorImpl.a.hasValue()) {
            return true;
        }
        if (CounterInteractorKt.a < System.currentTimeMillis() - counterInteractorImpl.d) {
            return true;
        }
        return false;
    }

    @Override // com.avito.android.common.CounterInteractor
    @NotNull
    public Observable<Integer> changes() {
        return this.a;
    }

    @Override // com.avito.android.common.CounterInteractor
    @NotNull
    public Completable executeUpdate() {
        return loadCounter();
    }

    @NotNull
    public final Completable loadCounter() {
        Completable ignoreElements = this.g.currentAuthorized().flatMapObservable(new e(this)).doOnError(f.a).onErrorResumeNext(g.a).doOnSubscribe(new h(this)).doOnNext(new i(this)).ignoreElements();
        Intrinsics.checkNotNullExpressionValue(ignoreElements, "accountStateProvider.cur…        .ignoreElements()");
        return ignoreElements;
    }

    @Override // com.avito.android.account.plugin.AuthorizationPlugin
    public void onLogin() {
        CounterInteractor.DefaultImpls.onLogin(this);
    }

    @Override // com.avito.android.account.plugin.AuthorizationPlugin
    public void onLogout() {
        CounterInteractor.DefaultImpls.onLogout(this);
    }

    @Override // com.avito.android.account.plugin.AuthorizationPlugin
    public void onStateChanged() {
        requestUpdate(true);
    }

    @Override // com.avito.android.common.CounterInteractor
    public void requestUpdate(boolean z) {
        this.b.accept(Boolean.valueOf(z));
    }

    @Override // com.avito.android.common.CounterInteractor
    public void reset() {
        this.a.accept(0);
    }
}
