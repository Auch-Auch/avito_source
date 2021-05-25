package com.avito.android.safedeal.delivery_type;

import a2.g.r.g;
import android.os.Bundle;
import com.avito.android.Features;
import com.avito.android.IdProvider;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.ParametrizedEventsKt;
import com.avito.android.analytics.provider.clickstream.ParametrizedClickStreamEvent;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.AlertBannerModel;
import com.avito.android.remote.model.ParametrizedEvent;
import com.avito.android.remote.model.text.AttributedText;
import com.avito.android.safedeal.delivery_type.analytics.SelectDeliveryOrderTypeEvent;
import com.avito.android.safedeal.delivery_type.items.button.ButtonItem;
import com.avito.android.safedeal.delivery_type.items.skeleton.SkeletonItem;
import com.avito.android.safedeal.delivery_type.items.subtitle.SubTitleItem;
import com.avito.android.safedeal.delivery_type.items.title.TitleItem;
import com.avito.android.safedeal.remote.model.DeliveryTypeResponse;
import com.avito.android.safedeal.remote.model.OrderType;
import com.avito.android.safedeal.remote.model.OrderTypesGroup;
import com.avito.android.util.Bundles;
import com.avito.android.util.LoadingState;
import com.avito.android.util.Logs;
import com.avito.android.util.SchedulersFactory3;
import com.avito.conveyor_item.ParcelableItem;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.kotlin.DisposableKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001BA\b\u0007\u0012\u0006\u0010+\u001a\u00020(\u0012\u0006\u0010#\u001a\u00020 \u0012\u0006\u00104\u001a\u000201\u0012\u0006\u00108\u001a\u000205\u0012\u0006\u0010\u001f\u001a\u00020\u001c\u0012\u0006\u0010F\u001a\u00020C\u0012\u0006\u0010>\u001a\u00020;¢\u0006\u0004\bP\u0010QJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\u0007\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\u0004J\u0017\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u0004J\u000f\u0010\u000f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000f\u0010\u0004J\u000f\u0010\u0010\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0010\u0010\u0004J\u000f\u0010\u0011\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0011\u0010\u0004J\u000f\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0019\u0010\u0016\u001a\u00020\u00022\b\u0010\u0015\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010'\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0018\u0010/\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0003\u00100R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u00108\u001a\u0002058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b6\u00107R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010>\u001a\u00020;8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010B\u001a\u00020?8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010F\u001a\u00020C8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bD\u0010ER\u001c\u0010K\u001a\b\u0012\u0004\u0012\u00020H0G8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bI\u0010JR\u0018\u0010O\u001a\u0004\u0018\u00010L8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bM\u0010N¨\u0006R"}, d2 = {"Lcom/avito/android/safedeal/delivery_type/DeliveryTypePresenterImpl;", "Lcom/avito/android/safedeal/delivery_type/DeliveryTypePresenter;", "", AuthSource.SEND_ABUSE, "()V", "Lcom/avito/android/safedeal/delivery_type/DeliveryTypeRouter;", "router", "attachRouter", "(Lcom/avito/android/safedeal/delivery_type/DeliveryTypeRouter;)V", "detachRouter", "Lcom/avito/android/safedeal/delivery_type/DeliveryTypeView;", "view", "attachView", "(Lcom/avito/android/safedeal/delivery_type/DeliveryTypeView;)V", "detachView", "onStart", "onStop", "onRetry", "Landroid/os/Bundle;", "saveState", "()Landroid/os/Bundle;", "state", "restoreState", "(Landroid/os/Bundle;)V", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "onButtonClick", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "Lcom/avito/android/safedeal/delivery_type/DeliveryTypeData;", "l", "Lcom/avito/android/safedeal/delivery_type/DeliveryTypeData;", "deliveryTypeData", "Lcom/avito/android/IdProvider;", "i", "Lcom/avito/android/IdProvider;", "idProvider", "Lio/reactivex/rxjava3/disposables/Disposable;", g.a, "Lio/reactivex/rxjava3/disposables/Disposable;", "authorizedDisposable", "Lcom/avito/android/safedeal/delivery_type/DeliveryTypeInteractor;", "h", "Lcom/avito/android/safedeal/delivery_type/DeliveryTypeInteractor;", "interactor", "", "f", "Ljava/lang/Boolean;", "authorized", "Lcom/avito/android/safedeal/delivery_type/DeliveryTypeView;", "Lcom/avito/android/util/SchedulersFactory3;", "j", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/avito/android/account/AccountStateProvider;", "k", "Lcom/avito/android/account/AccountStateProvider;", "accountStateProvider", AuthSource.BOOKING_ORDER, "Lcom/avito/android/safedeal/delivery_type/DeliveryTypeRouter;", "Lcom/avito/android/Features;", "n", "Lcom/avito/android/Features;", "features", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "c", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "commonDisposables", "Lcom/avito/android/analytics/Analytics;", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/android/analytics/Analytics;", "analytics", "", "Lcom/avito/conveyor_item/ParcelableItem;", "d", "Ljava/util/List;", "items", "Lcom/avito/android/safedeal/remote/model/DeliveryTypeResponse;", "e", "Lcom/avito/android/safedeal/remote/model/DeliveryTypeResponse;", "displayTypeResponse", "<init>", "(Lcom/avito/android/safedeal/delivery_type/DeliveryTypeInteractor;Lcom/avito/android/IdProvider;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/account/AccountStateProvider;Lcom/avito/android/safedeal/delivery_type/DeliveryTypeData;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/Features;)V", "safedeal_release"}, k = 1, mv = {1, 4, 2})
public final class DeliveryTypePresenterImpl implements DeliveryTypePresenter {
    public DeliveryTypeView a;
    public DeliveryTypeRouter b;
    public final CompositeDisposable c = new CompositeDisposable();
    public List<? extends ParcelableItem> d = CollectionsKt__CollectionsKt.emptyList();
    public DeliveryTypeResponse e;
    public Boolean f;
    public Disposable g;
    public final DeliveryTypeInteractor h;
    public final IdProvider i;
    public final SchedulersFactory3 j;
    public final AccountStateProvider k;
    public final DeliveryTypeData l;
    public final Analytics m;
    public final Features n;

    public static final class a<T> implements Consumer<Boolean> {
        public final /* synthetic */ DeliveryTypePresenterImpl a;

        public a(DeliveryTypePresenterImpl deliveryTypePresenterImpl) {
            this.a = deliveryTypePresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Boolean bool) {
            Boolean bool2 = bool;
            this.a.f = bool2;
            Intrinsics.checkNotNullExpressionValue(bool2, "authorized");
            if (bool2.booleanValue()) {
                this.a.a();
            } else {
                DeliveryTypePresenterImpl.access$authenticate(this.a);
            }
        }
    }

    public static final class b<T> implements Consumer<Throwable> {
        public static final b a = new b();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            Logs.error(th);
        }
    }

    public static final class c<T> implements Consumer<LoadingState<? super DeliveryTypeResponse>> {
        public final /* synthetic */ DeliveryTypePresenterImpl a;

        public c(DeliveryTypePresenterImpl deliveryTypePresenterImpl) {
            this.a = deliveryTypePresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(LoadingState<? super DeliveryTypeResponse> loadingState) {
            DeliveryTypeView deliveryTypeView;
            LoadingState<? super DeliveryTypeResponse> loadingState2 = loadingState;
            if (loadingState2 instanceof LoadingState.Loaded) {
                LoadingState.Loaded loaded = (LoadingState.Loaded) loadingState2;
                DeliveryTypeResponse deliveryTypeResponse = (DeliveryTypeResponse) loaded.getData();
                AlertBannerModel banner = ((DeliveryTypeResponse) loaded.getData()).getBanner();
                if (banner == null || !this.a.n.getBannerOnDeliveryType().invoke().booleanValue()) {
                    banner = null;
                }
                DeliveryTypeResponse copy$default = DeliveryTypeResponse.copy$default(deliveryTypeResponse, banner, null, 2, null);
                this.a.e = copy$default;
                DeliveryTypePresenterImpl deliveryTypePresenterImpl = this.a;
                deliveryTypePresenterImpl.d = DeliveryTypePresenterImpl.access$prepareContentScreen(deliveryTypePresenterImpl, copy$default);
                DeliveryTypePresenterImpl deliveryTypePresenterImpl2 = this.a;
                DeliveryTypePresenterImpl.access$showContent(deliveryTypePresenterImpl2, deliveryTypePresenterImpl2.d);
                DeliveryTypeView deliveryTypeView2 = this.a.a;
                if (deliveryTypeView2 != null) {
                    deliveryTypeView2.showAlertBanner(copy$default.getBanner());
                }
            } else if ((loadingState2 instanceof LoadingState.Error) && (deliveryTypeView = this.a.a) != null) {
                deliveryTypeView.showError();
            }
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

    @Inject
    public DeliveryTypePresenterImpl(@NotNull DeliveryTypeInteractor deliveryTypeInteractor, @NotNull IdProvider idProvider, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull AccountStateProvider accountStateProvider, @NotNull DeliveryTypeData deliveryTypeData, @NotNull Analytics analytics, @NotNull Features features) {
        Intrinsics.checkNotNullParameter(deliveryTypeInteractor, "interactor");
        Intrinsics.checkNotNullParameter(idProvider, "idProvider");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(accountStateProvider, "accountStateProvider");
        Intrinsics.checkNotNullParameter(deliveryTypeData, "deliveryTypeData");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(features, "features");
        this.h = deliveryTypeInteractor;
        this.i = idProvider;
        this.j = schedulersFactory3;
        this.k = accountStateProvider;
        this.l = deliveryTypeData;
        this.m = analytics;
        this.n = features;
    }

    public static final void access$authenticate(DeliveryTypePresenterImpl deliveryTypePresenterImpl) {
        DeliveryTypeRouter deliveryTypeRouter = deliveryTypePresenterImpl.b;
        if (deliveryTypeRouter != null) {
            deliveryTypeRouter.showAuthScreen();
        }
    }

    public static final List access$prepareContentScreen(DeliveryTypePresenterImpl deliveryTypePresenterImpl, DeliveryTypeResponse deliveryTypeResponse) {
        AttributedText disclaimer;
        List<OrderType> orderTypes;
        Objects.requireNonNull(deliveryTypePresenterImpl);
        ArrayList arrayList = new ArrayList();
        OrderTypesGroup orderTypesGroup = deliveryTypeResponse.getOrderTypesGroup();
        AttributedText attributedText = null;
        if ((orderTypesGroup != null ? orderTypesGroup.getTitle() : null) != null) {
            OrderTypesGroup orderTypesGroup2 = deliveryTypeResponse.getOrderTypesGroup();
            arrayList.add(new TitleItem(orderTypesGroup2 != null ? orderTypesGroup2.getTitle() : null, String.valueOf(deliveryTypePresenterImpl.i.generateId())));
        }
        OrderTypesGroup orderTypesGroup3 = deliveryTypeResponse.getOrderTypesGroup();
        if ((orderTypesGroup3 != null ? orderTypesGroup3.getSubtitle() : null) != null) {
            OrderTypesGroup orderTypesGroup4 = deliveryTypeResponse.getOrderTypesGroup();
            arrayList.add(new SubTitleItem(orderTypesGroup4 != null ? orderTypesGroup4.getSubtitle() : null, String.valueOf(deliveryTypePresenterImpl.i.generateId())));
        }
        OrderTypesGroup orderTypesGroup5 = deliveryTypeResponse.getOrderTypesGroup();
        if (!(orderTypesGroup5 == null || (orderTypes = orderTypesGroup5.getOrderTypes()) == null)) {
            Iterator<T> it = orderTypes.iterator();
            while (it.hasNext()) {
                arrayList.add(new ButtonItem(it.next(), String.valueOf(deliveryTypePresenterImpl.i.generateId())));
            }
        }
        OrderTypesGroup orderTypesGroup6 = deliveryTypeResponse.getOrderTypesGroup();
        if ((orderTypesGroup6 != null ? orderTypesGroup6.getDisclaimer() : null) != null) {
            OrderTypesGroup orderTypesGroup7 = deliveryTypeResponse.getOrderTypesGroup();
            String text = (orderTypesGroup7 == null || (disclaimer = orderTypesGroup7.getDisclaimer()) == null) ? null : disclaimer.getText();
            boolean z = false;
            if (text != null) {
                if (text.length() > 0) {
                    z = true;
                }
            }
            if (z) {
                OrderTypesGroup orderTypesGroup8 = deliveryTypeResponse.getOrderTypesGroup();
                if (orderTypesGroup8 != null) {
                    attributedText = orderTypesGroup8.getDisclaimer();
                }
                arrayList.add(new SubTitleItem(attributedText, String.valueOf(deliveryTypePresenterImpl.i.generateId())));
            }
        }
        return CollectionsKt___CollectionsKt.toList(arrayList);
    }

    public static final void access$showContent(DeliveryTypePresenterImpl deliveryTypePresenterImpl, List list) {
        DeliveryTypeView deliveryTypeView = deliveryTypePresenterImpl.a;
        if (deliveryTypeView != null) {
            deliveryTypeView.bindItems(list);
        }
    }

    public final void a() {
        ParametrizedClickStreamEvent clickStreamEvent;
        DeliveryTypeResponse deliveryTypeResponse = this.e;
        if (deliveryTypeResponse != null) {
            List<? extends ParcelableItem> list = this.d;
            DeliveryTypeView deliveryTypeView = this.a;
            if (deliveryTypeView != null) {
                deliveryTypeView.bindItems(list);
            }
            DeliveryTypeView deliveryTypeView2 = this.a;
            if (deliveryTypeView2 != null) {
                deliveryTypeView2.showAlertBanner(deliveryTypeResponse.getBanner());
                return;
            }
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new SkeletonItem(null, 1, null));
        List<? extends ParcelableItem> list2 = CollectionsKt___CollectionsKt.toList(arrayList);
        this.d = list2;
        DeliveryTypeView deliveryTypeView3 = this.a;
        if (deliveryTypeView3 != null) {
            deliveryTypeView3.bindItems(list2);
        }
        CompositeDisposable compositeDisposable = this.c;
        Disposable subscribe = this.h.loadDeliveryTypes().observeOn(this.j.mainThread()).subscribe(new c(this), d.a);
        Intrinsics.checkNotNullExpressionValue(subscribe, "interactor.loadDeliveryT…or(it)\n                })");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
        this.m.track(new SelectDeliveryOrderTypeEvent(this.k.getCurrentUserId(), this.l.getItemId(), null, null, 12, null));
        ParametrizedEvent contactEvent = this.l.getContactEvent();
        if (contactEvent != null && (clickStreamEvent = ParametrizedEventsKt.toClickStreamEvent(contactEvent)) != null) {
            this.m.track(clickStreamEvent);
        }
    }

    @Override // com.avito.android.safedeal.delivery_type.DeliveryTypePresenter
    public void attachRouter(@Nullable DeliveryTypeRouter deliveryTypeRouter) {
        this.b = deliveryTypeRouter;
    }

    @Override // com.avito.android.safedeal.delivery_type.DeliveryTypePresenter
    public void attachView(@NotNull DeliveryTypeView deliveryTypeView) {
        Intrinsics.checkNotNullParameter(deliveryTypeView, "view");
        this.a = deliveryTypeView;
        if (deliveryTypeView != null) {
            CompositeDisposable compositeDisposable = this.c;
            Disposable subscribe = deliveryTypeView.upButtonClicks().observeOn(this.j.mainThread()).subscribe(new a2.a.a.i2.b.a(this), a2.a.a.i2.b.b.a);
            Intrinsics.checkNotNullExpressionValue(subscribe, "view.upButtonClicks()\n  …   }, { Logs.error(it) })");
            DisposableKt.plusAssign(compositeDisposable, subscribe);
        }
    }

    @Override // com.avito.android.safedeal.delivery_type.DeliveryTypePresenter
    public void detachRouter() {
        this.b = null;
    }

    @Override // com.avito.android.safedeal.delivery_type.DeliveryTypePresenter
    public void detachView() {
        this.a = null;
        this.c.clear();
    }

    @Override // com.avito.android.safedeal.delivery_type.ButtonClickListener
    public void onButtonClick(@NotNull DeepLink deepLink) {
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        DeliveryTypeRouter deliveryTypeRouter = this.b;
        if (deliveryTypeRouter != null) {
            deliveryTypeRouter.followDeepLink(deepLink);
        }
    }

    @Override // com.avito.android.safedeal.delivery_type.RetryListener
    public void onRetry() {
        a();
    }

    @Override // com.avito.android.safedeal.delivery_type.DeliveryTypePresenter
    public void onStart() {
        this.g = this.k.currentAuthorized().subscribeOn(this.j.io()).observeOn(this.j.mainThread()).subscribe(new a(this), b.a);
    }

    @Override // com.avito.android.safedeal.delivery_type.DeliveryTypePresenter
    public void onStop() {
        this.c.clear();
    }

    @Override // com.avito.android.safedeal.delivery_type.DeliveryTypePresenter
    public void restoreState(@Nullable Bundle bundle) {
        List<? extends ParcelableItem> parcelableList;
        this.e = bundle != null ? (DeliveryTypeResponse) bundle.getParcelable("deliveryType") : null;
        if (bundle != null && (parcelableList = Bundles.getParcelableList(bundle, "deliveryTypeItems")) != null) {
            this.d = parcelableList;
        }
    }

    @Override // com.avito.android.safedeal.delivery_type.DeliveryTypePresenter
    @NotNull
    public Bundle saveState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("deliveryType", this.e);
        Bundles.putParcelableList(bundle, "deliveryTypeItems", this.d);
        return bundle;
    }
}
