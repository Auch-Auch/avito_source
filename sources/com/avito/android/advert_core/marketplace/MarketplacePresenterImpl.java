package com.avito.android.advert_core.marketplace;

import a2.g.r.g;
import android.os.Bundle;
import com.avito.android.advert_core.advert.CartInteractor;
import com.avito.android.advert_core.analytics.AdvertDetailsAnalyticsInteractor;
import com.avito.android.advert_core.contactbar.AdvertContactsPresenter;
import com.avito.android.advert_core.contactbar.AdvertContactsView;
import com.avito.android.advert_core.utils.AdvertDetailsUtilsKt;
import com.avito.android.analytics.event.cart.OpenCartEvent;
import com.avito.android.cart_fab.CartFabView;
import com.avito.android.cart_fab.CartFabViewModel;
import com.avito.android.component.contact_bar.ContactBar;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.AdvertAction;
import com.avito.android.remote.model.AdvertActions;
import com.avito.android.remote.model.AdvertDetails;
import com.avito.android.remote.model.ParametrizedEvent;
import com.avito.android.remote.model.advert_details.ContactBarData;
import com.avito.android.util.Logs;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.TypedResultException;
import dagger.Lazy;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.kotlin.DisposableKt;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B?\b\u0007\u0012\f\u00104\u001a\b\u0012\u0004\u0012\u00020100\u0012\u0006\u0010/\u001a\u00020,\u0012\u0006\u00108\u001a\u000205\u0012\u0006\u0010F\u001a\u00020C\u0012\u0006\u0010&\u001a\u00020#\u0012\u0006\u0010B\u001a\u00020?¢\u0006\u0004\bK\u0010LJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0005\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u000f\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0019\u0010\u0017\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0019\u0010\u001b\u001a\u00020\u00042\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u001e\u0010\u0018J\u0019\u0010!\u001a\u00020\u00042\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0016¢\u0006\u0004\b!\u0010\"R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010)\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u001c\u00104\u001a\b\u0012\u0004\u0012\u000201008\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u00108\u001a\u0002058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b6\u00107R\u0018\u0010;\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b9\u0010:R\u0018\u0010>\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010B\u001a\u00020?8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010F\u001a\u00020C8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bD\u0010ER\u0016\u0010J\u001a\u00020G8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bH\u0010I¨\u0006M"}, d2 = {"Lcom/avito/android/advert_core/marketplace/MarketplacePresenterImpl;", "Lcom/avito/android/advert_core/marketplace/MarketplacePresenter;", "Lcom/avito/android/advert_core/contactbar/AdvertContactsView;", "view", "", "attachView", "(Lcom/avito/android/advert_core/contactbar/AdvertContactsView;)V", "Lcom/avito/android/cart_fab/CartFabView;", "(Lcom/avito/android/cart_fab/CartFabView;)V", "detachViews", "()V", "Landroid/os/Bundle;", "saveState", "()Landroid/os/Bundle;", "state", "restoreState", "(Landroid/os/Bundle;)V", "Lcom/avito/android/remote/model/AdvertDetails;", "advert", "bindAdvert", "(Lcom/avito/android/remote/model/AdvertDetails;)V", "", "context", "setSearchContext", "(Ljava/lang/String;)V", "Lcom/avito/android/remote/model/ParametrizedEvent;", "event", "setContactEvent", "(Lcom/avito/android/remote/model/ParametrizedEvent;)V", "itemId", "addItemToCart", "Lcom/avito/android/analytics/event/cart/OpenCartEvent$Source;", "source", "trackGoToCartClicked", "(Lcom/avito/android/analytics/event/cart/OpenCartEvent$Source;)V", "Lcom/avito/android/cart_fab/CartFabViewModel;", "j", "Lcom/avito/android/cart_fab/CartFabViewModel;", "cartFabViewModel", "c", "Ljava/lang/String;", "searchContext", AuthSource.BOOKING_ORDER, "Lcom/avito/android/remote/model/AdvertDetails;", "Lcom/avito/android/advert_core/advert/CartInteractor;", g.a, "Lcom/avito/android/advert_core/advert/CartInteractor;", "cartInteractor", "Ldagger/Lazy;", "Lcom/avito/android/advert_core/contactbar/AdvertContactsPresenter;", "f", "Ldagger/Lazy;", "contactsPresenter", "Lcom/avito/android/util/SchedulersFactory3;", "h", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", AuthSource.SEND_ABUSE, "Lcom/avito/android/advert_core/contactbar/AdvertContactsView;", "contactsView", "d", "Lcom/avito/android/remote/model/ParametrizedEvent;", MarketplacePresenterKt.KEY_CONTACT_EVENT, "Lcom/avito/android/advert_core/analytics/AdvertDetailsAnalyticsInteractor;", "k", "Lcom/avito/android/advert_core/analytics/AdvertDetailsAnalyticsInteractor;", "analyticsInteractor", "Lcom/avito/android/advert_core/marketplace/MarketplaceResourceProvider;", "i", "Lcom/avito/android/advert_core/marketplace/MarketplaceResourceProvider;", "resourceProvider", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "e", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "subscriptions", "<init>", "(Ldagger/Lazy;Lcom/avito/android/advert_core/advert/CartInteractor;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/advert_core/marketplace/MarketplaceResourceProvider;Lcom/avito/android/cart_fab/CartFabViewModel;Lcom/avito/android/advert_core/analytics/AdvertDetailsAnalyticsInteractor;)V", "advert-core_release"}, k = 1, mv = {1, 4, 2})
public final class MarketplacePresenterImpl implements MarketplacePresenter {
    public AdvertContactsView a;
    public AdvertDetails b;
    public String c;
    public ParametrizedEvent d;
    public final CompositeDisposable e = new CompositeDisposable();
    public final Lazy<AdvertContactsPresenter> f;
    public final CartInteractor g;
    public final SchedulersFactory3 h;
    public final MarketplaceResourceProvider i;
    public final CartFabViewModel j;
    public final AdvertDetailsAnalyticsInteractor k;

    public static final class a<T, R> implements Function<AdvertAction.Cart, List<? extends ContactBar.Action>> {
        public final /* synthetic */ MarketplacePresenterImpl a;

        public a(MarketplacePresenterImpl marketplacePresenterImpl) {
            this.a = marketplacePresenterImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public List<? extends ContactBar.Action> apply(AdvertAction.Cart cart) {
            return ((AdvertContactsPresenter) this.a.f.get()).contactBarActions(new AdvertActions(t6.n.d.listOf(cart)));
        }
    }

    public static final class b implements Action {
        public final /* synthetic */ MarketplacePresenterImpl a;

        public b(MarketplacePresenterImpl marketplacePresenterImpl) {
            this.a = marketplacePresenterImpl;
        }

        @Override // io.reactivex.rxjava3.functions.Action
        public final void run() {
            ParametrizedEvent parametrizedEvent = this.a.d;
            if (parametrizedEvent != null) {
                this.a.k.sendParametrizedEvent(parametrizedEvent);
            }
        }
    }

    public static final class c<T> implements Consumer<List<? extends ContactBar.Action>> {
        public final /* synthetic */ MarketplacePresenterImpl a;

        public c(MarketplacePresenterImpl marketplacePresenterImpl) {
            this.a = marketplacePresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r0v3, resolved type: com.avito.android.advert_core.contactbar.AdvertContactsPresenter */
        /* JADX DEBUG: Multi-variable search result rejected for r0v7, resolved type: com.avito.android.advert_core.contactbar.AdvertContactsPresenter */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(List<? extends ContactBar.Action> list) {
            List<? extends ContactBar.Action> list2 = list;
            AdvertContactsPresenter advertContactsPresenter = (AdvertContactsPresenter) this.a.f.get();
            Intrinsics.checkNotNullExpressionValue(list2, "actions");
            AdvertDetails advertDetails = this.a.b;
            ContactBarData contactBarData = null;
            advertContactsPresenter.bindStickyData(list2, advertDetails != null ? AdvertDetailsUtilsKt.toContactBarData$default(advertDetails, null, 1, null) : null);
            AdvertContactsPresenter advertContactsPresenter2 = (AdvertContactsPresenter) this.a.f.get();
            AdvertDetails advertDetails2 = this.a.b;
            if (advertDetails2 != null) {
                contactBarData = AdvertDetailsUtilsKt.toContactBarData$default(advertDetails2, null, 1, null);
            }
            advertContactsPresenter2.bindEmbeddedData(list2, contactBarData);
            MarketplacePresenterImpl.access$incrementCartQuantity(this.a);
        }
    }

    public static final class d<T> implements Consumer<Throwable> {
        public final /* synthetic */ MarketplacePresenterImpl a;

        public d(MarketplacePresenterImpl marketplacePresenterImpl) {
            this.a = marketplacePresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            Throwable th2 = th;
            Logs.error(th2);
            String message = th2 instanceof TypedResultException ? ((TypedResultException) th2).getMessage() : "";
            AdvertContactsView advertContactsView = this.a.a;
            if (advertContactsView != null) {
                MarketplaceResourceProvider marketplaceResourceProvider = this.a.i;
                if (message.length() == 0) {
                    message = marketplaceResourceProvider.getAddToCartError();
                }
                advertContactsView.showSnackbarAbove(message);
            }
        }
    }

    public static final class e<T> implements Consumer<Integer> {
        public final /* synthetic */ MarketplacePresenterImpl a;
        public final /* synthetic */ OpenCartEvent.Source b;

        public e(MarketplacePresenterImpl marketplacePresenterImpl, OpenCartEvent.Source source) {
            this.a = marketplacePresenterImpl;
            this.b = source;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Integer num) {
            Integer num2 = num;
            AdvertDetails advertDetails = this.a.b;
            if (advertDetails != null) {
                this.a.k.sendOpenCartEvent(advertDetails.getId(), this.b, num2, this.a.c);
            }
        }
    }

    @Inject
    public MarketplacePresenterImpl(@NotNull Lazy<AdvertContactsPresenter> lazy, @NotNull CartInteractor cartInteractor, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull MarketplaceResourceProvider marketplaceResourceProvider, @NotNull CartFabViewModel cartFabViewModel, @NotNull AdvertDetailsAnalyticsInteractor advertDetailsAnalyticsInteractor) {
        Intrinsics.checkNotNullParameter(lazy, "contactsPresenter");
        Intrinsics.checkNotNullParameter(cartInteractor, "cartInteractor");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(marketplaceResourceProvider, "resourceProvider");
        Intrinsics.checkNotNullParameter(cartFabViewModel, "cartFabViewModel");
        Intrinsics.checkNotNullParameter(advertDetailsAnalyticsInteractor, "analyticsInteractor");
        this.f = lazy;
        this.g = cartInteractor;
        this.h = schedulersFactory3;
        this.i = marketplaceResourceProvider;
        this.j = cartFabViewModel;
        this.k = advertDetailsAnalyticsInteractor;
    }

    public static final void access$incrementCartQuantity(MarketplacePresenterImpl marketplacePresenterImpl) {
        Disposable subscribe = marketplacePresenterImpl.j.getCurrentQuantity().subscribe(new a2.a.a.g.h.a(marketplacePresenterImpl), new a2.a.a.g.h.c(new Function1<Throwable, Unit>(Logs.INSTANCE) { // from class: a2.a.a.g.h.b
            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public Unit invoke(Throwable th) {
                Logs logs = (Logs) this.receiver;
                Logs.error(th);
                return Unit.INSTANCE;
            }
        }));
        Intrinsics.checkNotNullExpressionValue(subscribe, "cartFabViewModel.current…    Logs::error\n        )");
        DisposableKt.addTo(subscribe, marketplacePresenterImpl.e);
    }

    @Override // com.avito.android.advert_core.marketplace.MarketplacePresenter
    public void addItemToCart(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "itemId");
        Single<R> flatMap = this.g.addToCart(str, this.c).flatMap(MarketplacePresenterImpl$addItemToCart$$inlined$toTyped$1.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(flatMap, "flatMap { it.toTypedSingle() }");
        Disposable subscribe = flatMap.map(new a(this)).doOnTerminate(new b(this)).observeOn(this.h.mainThread()).subscribe(new c(this), new d(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "cartInteractor.addToCart…          }\n            )");
        DisposableKt.addTo(subscribe, this.e);
    }

    @Override // com.avito.android.advert_core.marketplace.MarketplacePresenter
    public void attachView(@NotNull AdvertContactsView advertContactsView) {
        Intrinsics.checkNotNullParameter(advertContactsView, "view");
        this.a = advertContactsView;
    }

    @Override // com.avito.android.advert_core.marketplace.MarketplacePresenter
    public void attachView(@NotNull CartFabView cartFabView) {
        Intrinsics.checkNotNullParameter(cartFabView, "view");
    }

    @Override // com.avito.android.advert_core.marketplace.MarketplacePresenter
    public void bindAdvert(@NotNull AdvertDetails advertDetails) {
        Intrinsics.checkNotNullParameter(advertDetails, "advert");
        this.b = advertDetails;
    }

    @Override // com.avito.android.advert_core.marketplace.MarketplacePresenter
    public void detachViews() {
        this.e.clear();
        this.a = null;
    }

    @Override // com.avito.android.advert_core.marketplace.MarketplacePresenter
    public void restoreState(@Nullable Bundle bundle) {
        if (bundle != null) {
            this.d = (ParametrizedEvent) bundle.getParcelable(MarketplacePresenterKt.KEY_CONTACT_EVENT);
        }
    }

    @Override // com.avito.android.advert_core.marketplace.MarketplacePresenter
    @NotNull
    public Bundle saveState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable(MarketplacePresenterKt.KEY_CONTACT_EVENT, this.d);
        return bundle;
    }

    @Override // com.avito.android.advert_core.marketplace.MarketplacePresenter
    public void setContactEvent(@Nullable ParametrizedEvent parametrizedEvent) {
        this.d = parametrizedEvent;
    }

    @Override // com.avito.android.advert_core.marketplace.MarketplacePresenter
    public void setSearchContext(@Nullable String str) {
        this.c = str;
    }

    @Override // com.avito.android.advert_core.marketplace.MarketplacePresenter
    public void trackGoToCartClicked(@Nullable OpenCartEvent.Source source) {
        Disposable subscribe = this.j.getCurrentQuantity().subscribe(new e(this, source), new a2.a.a.g.h.c(new Function1<Throwable, Unit>(Logs.INSTANCE) { // from class: com.avito.android.advert_core.marketplace.MarketplacePresenterImpl.f
            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public Unit invoke(Throwable th) {
                Logs logs = (Logs) this.receiver;
                Logs.error(th);
                return Unit.INSTANCE;
            }
        }));
        Intrinsics.checkNotNullExpressionValue(subscribe, "cartFabViewModel.current…Logs::error\n            )");
        DisposableKt.addTo(subscribe, this.e);
    }
}
