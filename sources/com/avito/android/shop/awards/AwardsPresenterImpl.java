package com.avito.android.shop.awards;

import a2.g.r.g;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.ErrorResult;
import com.avito.android.remote.error.ErrorWithMessage;
import com.avito.android.remote.error.TypedError;
import com.avito.android.remote.model.SellerVerification;
import com.avito.android.remote.shop.ShopNotFoundError;
import com.avito.android.util.Kundle;
import com.avito.android.util.LoadingState;
import com.avito.android.util.SchedulersFactory3;
import com.avito.konveyor.adapter.AdapterPresenter;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001BG\u0012\u0006\u00100\u001a\u00020-\u0012\u0006\u0010\u001a\u001a\u00020\u0017\u0012\u0006\u00108\u001a\u000205\u0012\u0006\u0010<\u001a\u000209\u0012\u0006\u00104\u001a\u000201\u0012\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b\u0012\b\u0010=\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b>\u0010?J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0010\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0011\u0010\u000fJ\u000f\u0010\u0012\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0012\u0010\u000fJ\u0017\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010$\u001a\u00020\"8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010#R\u0018\u0010'\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010&R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010,\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u00108\u001a\u0002058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010<\u001a\u0002098\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b:\u0010;¨\u0006@"}, d2 = {"Lcom/avito/android/shop/awards/AwardsPresenterImpl;", "Lcom/avito/android/shop/awards/AwardsPresenter;", "Lcom/avito/android/util/Kundle;", "onSaveState", "()Lcom/avito/android/util/Kundle;", "Lcom/avito/android/shop/awards/AwardsView;", "view", "", "attachView", "(Lcom/avito/android/shop/awards/AwardsView;)V", "Lcom/avito/android/shop/awards/AwardsRouter;", "router", "attachRouter", "(Lcom/avito/android/shop/awards/AwardsRouter;)V", "detachRouter", "()V", "onRefresh", "detachView", AuthSource.BOOKING_ORDER, "Lcom/avito/android/remote/model/SellerVerification$AwardsItem;", "data", AuthSource.SEND_ABUSE, "(Lcom/avito/android/remote/model/SellerVerification$AwardsItem;)V", "Lcom/avito/android/util/SchedulersFactory3;", g.a, "Lcom/avito/android/util/SchedulersFactory3;", "schedulersFactory", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/deep_linking/links/DeepLink;", "k", "Lio/reactivex/rxjava3/core/Observable;", "actionClickObservable", "d", "Lcom/avito/android/shop/awards/AwardsRouter;", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "clickDisposable", "Lio/reactivex/rxjava3/disposables/Disposable;", "Lio/reactivex/rxjava3/disposables/Disposable;", "disposable", "c", "Lcom/avito/android/shop/awards/AwardsView;", "e", "Lcom/avito/android/remote/model/SellerVerification$AwardsItem;", "shopAwards", "Lcom/avito/android/shop/awards/AwardsInteractor;", "f", "Lcom/avito/android/shop/awards/AwardsInteractor;", "interactor", "Lcom/avito/android/shop/awards/ShopAwardsItemsConverter;", "j", "Lcom/avito/android/shop/awards/ShopAwardsItemsConverter;", "shopAwardsItemsConverter", "Lcom/avito/android/shop/awards/AwardsResourceProvider;", "h", "Lcom/avito/android/shop/awards/AwardsResourceProvider;", "resourceProvider", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "i", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "savedState", "<init>", "(Lcom/avito/android/shop/awards/AwardsInteractor;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/shop/awards/AwardsResourceProvider;Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/android/shop/awards/ShopAwardsItemsConverter;Lio/reactivex/rxjava3/core/Observable;Lcom/avito/android/util/Kundle;)V", "shop_release"}, k = 1, mv = {1, 4, 2})
public final class AwardsPresenterImpl implements AwardsPresenter {
    public final CompositeDisposable a = new CompositeDisposable();
    public Disposable b;
    public AwardsView c;
    public AwardsRouter d;
    public SellerVerification.AwardsItem e;
    public final AwardsInteractor f;
    public final SchedulersFactory3 g;
    public final AwardsResourceProvider h;
    public final AdapterPresenter i;
    public final ShopAwardsItemsConverter j;
    public final Observable<DeepLink> k;

    public static final class a<T> implements Consumer<DeepLink> {
        public final /* synthetic */ AwardsPresenterImpl a;

        public a(AwardsPresenterImpl awardsPresenterImpl) {
            this.a = awardsPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(DeepLink deepLink) {
            DeepLink deepLink2 = deepLink;
            AwardsRouter awardsRouter = this.a.d;
            if (awardsRouter != null) {
                Intrinsics.checkNotNullExpressionValue(deepLink2, "it");
                awardsRouter.followDeepLink(deepLink2);
            }
        }
    }

    public static final class b<T> implements Consumer<Unit> {
        public final /* synthetic */ AwardsPresenterImpl a;

        public b(AwardsPresenterImpl awardsPresenterImpl) {
            this.a = awardsPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Unit unit) {
            AwardsRouter awardsRouter = this.a.d;
            if (awardsRouter != null) {
                awardsRouter.closeAwards();
            }
        }
    }

    public static final class c<T> implements Consumer<LoadingState<? super SellerVerification.AwardsItem>> {
        public final /* synthetic */ AwardsPresenterImpl a;

        public c(AwardsPresenterImpl awardsPresenterImpl) {
            this.a = awardsPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(LoadingState<? super SellerVerification.AwardsItem> loadingState) {
            LoadingState<? super SellerVerification.AwardsItem> loadingState2 = loadingState;
            if (loadingState2 instanceof LoadingState.Loaded) {
                LoadingState.Loaded loaded = (LoadingState.Loaded) loadingState2;
                this.a.e = (SellerVerification.AwardsItem) loaded.getData();
                this.a.a((SellerVerification.AwardsItem) loaded.getData());
            } else if (loadingState2 instanceof LoadingState.Loading) {
                AwardsView awardsView = this.a.c;
                if (awardsView != null) {
                    awardsView.showLoading();
                }
            } else if (loadingState2 instanceof LoadingState.Error) {
                AwardsPresenterImpl.access$handleError(this.a, ((LoadingState.Error) loadingState2).getError());
            }
        }
    }

    public AwardsPresenterImpl(@NotNull AwardsInteractor awardsInteractor, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull AwardsResourceProvider awardsResourceProvider, @NotNull AdapterPresenter adapterPresenter, @NotNull ShopAwardsItemsConverter shopAwardsItemsConverter, @NotNull Observable<DeepLink> observable, @Nullable Kundle kundle) {
        Intrinsics.checkNotNullParameter(awardsInteractor, "interactor");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulersFactory");
        Intrinsics.checkNotNullParameter(awardsResourceProvider, "resourceProvider");
        Intrinsics.checkNotNullParameter(adapterPresenter, "adapterPresenter");
        Intrinsics.checkNotNullParameter(shopAwardsItemsConverter, "shopAwardsItemsConverter");
        Intrinsics.checkNotNullParameter(observable, "actionClickObservable");
        this.f = awardsInteractor;
        this.g = schedulersFactory3;
        this.h = awardsResourceProvider;
        this.i = adapterPresenter;
        this.j = shopAwardsItemsConverter;
        this.k = observable;
        this.e = kundle != null ? (SellerVerification.AwardsItem) kundle.getParcelable("shop_awards") : null;
    }

    public static final void access$handleError(AwardsPresenterImpl awardsPresenterImpl, TypedError typedError) {
        Objects.requireNonNull(awardsPresenterImpl);
        if (typedError instanceof ErrorResult.NetworkIOError) {
            AwardsView awardsView = awardsPresenterImpl.c;
            if (awardsView != null) {
                awardsView.showRetryOverlay();
            }
        } else if (typedError instanceof ShopNotFoundError) {
            AwardsView awardsView2 = awardsPresenterImpl.c;
            if (awardsView2 != null) {
                awardsView2.hideLoading();
            }
            AwardsView awardsView3 = awardsPresenterImpl.c;
            if (awardsView3 != null) {
                awardsView3.showShopNotFoundError(((ShopNotFoundError) typedError).getMessage());
            }
        } else if (typedError instanceof ErrorWithMessage) {
            AwardsView awardsView4 = awardsPresenterImpl.c;
            if (awardsView4 != null) {
                awardsView4.hideLoading();
            }
            AwardsView awardsView5 = awardsPresenterImpl.c;
            if (awardsView5 != null) {
                awardsView5.showError(((ErrorWithMessage) typedError).getMessage());
            }
        } else {
            AwardsView awardsView6 = awardsPresenterImpl.c;
            if (awardsView6 != null) {
                awardsView6.hideLoading();
            }
            AwardsView awardsView7 = awardsPresenterImpl.c;
            if (awardsView7 != null) {
                awardsView7.showError(awardsPresenterImpl.h.getUnknownError());
            }
        }
    }

    public final void a(SellerVerification.AwardsItem awardsItem) {
        a2.b.a.a.a.s1(this.j.convert(awardsItem), this.i);
        AwardsView awardsView = this.c;
        if (awardsView != null) {
            awardsView.showContent();
        }
        AwardsView awardsView2 = this.c;
        if (awardsView2 != null) {
            awardsView2.hideLoading();
        }
    }

    @Override // com.avito.android.shop.awards.AwardsPresenter
    public void attachRouter(@NotNull AwardsRouter awardsRouter) {
        Intrinsics.checkNotNullParameter(awardsRouter, "router");
        this.d = awardsRouter;
    }

    @Override // com.avito.android.shop.awards.AwardsPresenter
    public void attachView(@NotNull AwardsView awardsView) {
        Intrinsics.checkNotNullParameter(awardsView, "view");
        this.c = awardsView;
        this.a.add(this.k.subscribe(new a(this)));
        this.a.add(awardsView.navigationCallbacks().subscribe(new b(this)));
        SellerVerification.AwardsItem awardsItem = this.e;
        if (awardsItem == null) {
            b();
        } else {
            a(awardsItem);
        }
    }

    public final void b() {
        Disposable disposable = this.b;
        if (disposable != null) {
            disposable.dispose();
        }
        this.b = this.f.getShopAwards().observeOn(this.g.mainThread()).subscribe(new c(this));
    }

    @Override // com.avito.android.shop.awards.AwardsPresenter
    public void detachRouter() {
        this.d = null;
    }

    @Override // com.avito.android.shop.awards.AwardsPresenter
    public void detachView() {
        Disposable disposable = this.b;
        if (disposable != null) {
            disposable.dispose();
        }
        this.b = null;
        this.a.clear();
        this.c = null;
    }

    @Override // com.avito.android.shop.awards.AwardsViewPresenter
    public void onRefresh() {
        b();
    }

    @Override // com.avito.android.shop.awards.AwardsPresenter
    @NotNull
    public Kundle onSaveState() {
        Kundle kundle = new Kundle();
        kundle.putParcelable("shop_awards", this.e);
        return kundle;
    }
}
