package com.avito.android.cart_fab;

import androidx.lifecycle.MutableLiveData;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.analytics.Analytics;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.NoMatchLink;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.cart.model.CartQuantity;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.util.Logs;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.SearchContextWrapper;
import com.avito.android.util.architecture_components.SingleLiveEvent;
import com.avito.android.util.rx3.Singles;
import com.google.common.base.Optional;
import com.jakewharton.rxrelay3.PublishRelay;
import com.jakewharton.rxrelay3.Relay;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Predicate;
import io.reactivex.rxjava3.kotlin.DisposableKt;
import io.reactivex.rxjava3.schedulers.Schedulers;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B=\u0012\u0006\u00102\u001a\u00020/\u0012\u0006\u0010+\u001a\u00020(\u0012\u0006\u0010\u001c\u001a\u00020\u0019\u0012\u0006\u0010>\u001a\u00020;\u0012\u0006\u0010 \u001a\u00020\u001d\u0012\f\u00107\u001a\b\u0012\u0004\u0012\u00020403¢\u0006\u0004\b?\u0010@J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0007\u0010\u0004R\u001e\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\b8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR$\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\r8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\"\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\t0\u00138\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\"\u0010'\u001a\b\u0012\u0004\u0012\u00020\"0!8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010.\u001a\u00020,8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010-R\u0016\u00102\u001a\u00020/8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b0\u00101R\u001c\u00107\u001a\b\u0012\u0004\u0012\u000204038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b5\u00106R\u0018\u0010:\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010>\u001a\u00020;8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b<\u0010=¨\u0006A"}, d2 = {"Lcom/avito/android/cart_fab/CartFabViewModelImpl;", "Lcom/avito/android/cart_fab/CartFabViewModel;", "", "onFabClicked", "()V", "loadCartSize", "onCleared", "c", "Lio/reactivex/rxjava3/core/Single;", "", "getCurrentQuantity", "()Lio/reactivex/rxjava3/core/Single;", "currentQuantity", "Landroidx/lifecycle/MutableLiveData;", "d", "Landroidx/lifecycle/MutableLiveData;", "getQuantityChanges", "()Landroidx/lifecycle/MutableLiveData;", "quantityChanges", "Lcom/jakewharton/rxrelay3/Relay;", "f", "Lcom/jakewharton/rxrelay3/Relay;", "getQuantityConsumer", "()Lcom/jakewharton/rxrelay3/Relay;", "quantityConsumer", "Lcom/avito/android/account/AccountStateProvider;", "j", "Lcom/avito/android/account/AccountStateProvider;", "accountStatus", "Lcom/avito/android/analytics/Analytics;", "l", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "Lcom/avito/android/deep_linking/links/DeepLink;", "e", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "getOpenDeepLinkChanges", "()Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "openDeepLinkChanges", "Lcom/avito/android/cart_fab/CartFabPreferences;", "i", "Lcom/avito/android/cart_fab/CartFabPreferences;", "cartFabPrefs", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "subscriptions", "Lcom/avito/android/cart_fab/CartFabRepository;", "h", "Lcom/avito/android/cart_fab/CartFabRepository;", "repository", "Lcom/google/common/base/Optional;", "Lcom/avito/android/util/SearchContextWrapper;", AuthSource.OPEN_CHANNEL_LIST, "Lcom/google/common/base/Optional;", "searchContextWrapper", a2.g.r.g.a, "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "Lcom/avito/android/util/SchedulersFactory3;", "k", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "<init>", "(Lcom/avito/android/cart_fab/CartFabRepository;Lcom/avito/android/cart_fab/CartFabPreferences;Lcom/avito/android/account/AccountStateProvider;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/analytics/Analytics;Lcom/google/common/base/Optional;)V", "cart-fab_release"}, k = 1, mv = {1, 4, 2})
public final class CartFabViewModelImpl extends CartFabViewModel {
    public final CompositeDisposable c = new CompositeDisposable();
    @NotNull
    public final MutableLiveData<Integer> d = new MutableLiveData<>();
    @NotNull
    public final SingleLiveEvent<DeepLink> e = new SingleLiveEvent<>();
    @NotNull
    public final Relay<Integer> f;
    public DeepLink g;
    public final CartFabRepository h;
    public final CartFabPreferences i;
    public final AccountStateProvider j;
    public final SchedulersFactory3 k;
    public final Analytics l;
    public final Optional<SearchContextWrapper> m;

    public static final class a<V> implements Callable<Integer> {
        public final /* synthetic */ CartFabViewModelImpl a;

        public a(CartFabViewModelImpl cartFabViewModelImpl) {
            this.a = cartFabViewModelImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.concurrent.Callable
        public Integer call() {
            return this.a.i.getQuantity();
        }
    }

    public static final class b<T> implements Predicate<Boolean> {
        public static final b a = new b();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Predicate
        public boolean test(Boolean bool) {
            Boolean bool2 = bool;
            Intrinsics.checkNotNullExpressionValue(bool2, "authorized");
            return bool2.booleanValue();
        }
    }

    public static final class c<T, R> implements Function<Boolean, SingleSource<? extends CartQuantity>> {
        public final /* synthetic */ CartFabViewModelImpl a;

        public c(CartFabViewModelImpl cartFabViewModelImpl) {
            this.a = cartFabViewModelImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public SingleSource<? extends CartQuantity> apply(Boolean bool) {
            Single<TypedResult<CartQuantity>> cartSizeUpdates = this.a.h.cartSizeUpdates();
            Scheduler io2 = Schedulers.io();
            Intrinsics.checkNotNullExpressionValue(io2, "Schedulers.io()");
            Single<R> onErrorResumeNext = cartSizeUpdates.map(new CartFabViewModelImpl$loadCartSize$2$$special$$inlined$retryOnNetworkError$1()).retryWhen(new CartFabViewModelImpl$loadCartSize$2$$special$$inlined$retryOnNetworkError$2(1, 5000, null, 2.0d, io2)).onErrorResumeNext(CartFabViewModelImpl$loadCartSize$2$$special$$inlined$retryOnNetworkError$3.INSTANCE);
            Intrinsics.checkNotNullExpressionValue(onErrorResumeNext, "this.map {\n        if (p…)\n            }\n        }");
            Single<R> flatMap = onErrorResumeNext.flatMap(CartFabViewModelImpl$loadCartSize$2$$special$$inlined$toTyped$1.INSTANCE);
            Intrinsics.checkNotNullExpressionValue(flatMap, "flatMap { it.toTypedSingle() }");
            return flatMap;
        }
    }

    public static final class d<T> implements ObservableSource<CartQuantity> {
        public static final d a = new d();

        @Override // io.reactivex.rxjava3.core.ObservableSource
        public final void subscribe(Observer<? super CartQuantity> observer) {
            Singles.toSingle(new CartQuantity(0, new NoMatchLink()));
        }
    }

    public static final class e<T> implements Consumer<CartQuantity> {
        public final /* synthetic */ CartFabViewModelImpl a;

        public e(CartFabViewModelImpl cartFabViewModelImpl) {
            this.a = cartFabViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(CartQuantity cartQuantity) {
            CartQuantity cartQuantity2 = cartQuantity;
            Integer component1 = cartQuantity2.component1();
            DeepLink component2 = cartQuantity2.component2();
            CartFabViewModelImpl.access$updateQuantity(this.a, component1);
            this.a.g = component2;
        }
    }

    public static final class f<T> implements Consumer<Throwable> {
        public static final f a = new f();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            Logs.error("Failed to fetch cart quantity", th);
        }
    }

    public static final class h<T> implements Consumer<Throwable> {
        public final /* synthetic */ CartFabViewModelImpl a;

        public h(CartFabViewModelImpl cartFabViewModelImpl) {
            this.a = cartFabViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            Logs.error(th);
            this.a.c();
        }
    }

    public CartFabViewModelImpl(@NotNull CartFabRepository cartFabRepository, @NotNull CartFabPreferences cartFabPreferences, @NotNull AccountStateProvider accountStateProvider, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull Analytics analytics, @NotNull Optional<SearchContextWrapper> optional) {
        Intrinsics.checkNotNullParameter(cartFabRepository, "repository");
        Intrinsics.checkNotNullParameter(cartFabPreferences, "cartFabPrefs");
        Intrinsics.checkNotNullParameter(accountStateProvider, "accountStatus");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(optional, "searchContextWrapper");
        this.h = cartFabRepository;
        this.i = cartFabPreferences;
        this.j = accountStateProvider;
        this.k = schedulersFactory3;
        this.l = analytics;
        this.m = optional;
        PublishRelay create = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create, "PublishRelay.create()");
        this.f = create;
        c();
    }

    public static final void access$updateQuantity(CartFabViewModelImpl cartFabViewModelImpl, Integer num) {
        cartFabViewModelImpl.getQuantityChanges().postValue(num);
        cartFabViewModelImpl.i.setQuantity(num);
    }

    public final void c() {
        Disposable subscribe = getQuantityConsumer().subscribeOn(this.k.io()).subscribe(new a2.a.a.b0.c(new Function1<Integer, Unit>(this) { // from class: com.avito.android.cart_fab.CartFabViewModelImpl.g
            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public Unit invoke(Integer num) {
                CartFabViewModelImpl.access$updateQuantity((CartFabViewModelImpl) this.receiver, num);
                return Unit.INSTANCE;
            }
        }), new h(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "quantityConsumer\n       …yConsumer()\n            }");
        DisposableKt.addTo(subscribe, this.c);
    }

    @Override // com.avito.android.cart_fab.CartFabViewModel
    @NotNull
    public Single<Integer> getCurrentQuantity() {
        return a2.b.a.a.a.e2(this.k, Single.fromCallable(new a(this)), "Single.fromCallable { ca…scribeOn(schedulers.io())");
    }

    @Override // com.avito.android.cart_fab.CartFabViewModel
    public void loadCartSize() {
        Disposable subscribe = this.j.currentAuthorized().toObservable().subscribeOn(this.k.io()).filter(b.a).switchMapSingle(new c(this)).switchIfEmpty(d.a).subscribe(new e(this), f.a);
        Intrinsics.checkNotNullExpressionValue(subscribe, "accountStatus.currentAut…ity\", it) }\n            )");
        DisposableKt.addTo(subscribe, this.c);
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        this.c.clear();
    }

    @Override // com.avito.android.cart_fab.CartFabViewModel
    public void onFabClicked() {
        DeepLink deepLink = this.g;
        if (deepLink != null) {
            getOpenDeepLinkChanges().setValue(deepLink);
        } else {
            Logs.error$default("CartFloatingActionButton was clicked before deepLink initialization", null, 2, null);
        }
        Disposable subscribe = getCurrentQuantity().subscribe(new a2.a.a.b0.d(this), new a2.a.a.b0.c(new Function1<Throwable, Unit>(Logs.INSTANCE) { // from class: a2.a.a.b0.e
            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public Unit invoke(Throwable th) {
                Logs logs = (Logs) this.receiver;
                Logs.error(th);
                return Unit.INSTANCE;
            }
        }));
        Intrinsics.checkNotNullExpressionValue(subscribe, "currentQuantity.subscrib…    Logs::error\n        )");
        DisposableKt.addTo(subscribe, this.c);
    }

    @Override // com.avito.android.cart_fab.CartFabViewModel
    @NotNull
    public SingleLiveEvent<DeepLink> getOpenDeepLinkChanges() {
        return this.e;
    }

    @Override // com.avito.android.cart_fab.CartFabViewModel
    @NotNull
    public MutableLiveData<Integer> getQuantityChanges() {
        return this.d;
    }

    @Override // com.avito.android.cart_fab.CartFabViewModel
    @NotNull
    public Relay<Integer> getQuantityConsumer() {
        return this.f;
    }
}
