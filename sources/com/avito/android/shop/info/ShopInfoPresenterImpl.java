package com.avito.android.shop.info;

import a2.g.r.g;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.ErrorResult;
import com.avito.android.remote.error.ErrorWithMessage;
import com.avito.android.remote.error.TypedError;
import com.avito.android.remote.model.SellerVerification;
import com.avito.android.remote.shop.ShopNotFoundError;
import com.avito.android.remote.shop.info.ShopInfo;
import com.avito.android.util.Kundle;
import com.avito.android.util.LoadingState;
import com.avito.android.util.SchedulersFactory3;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010'\u001a\u00020$\u0012\u0006\u00101\u001a\u00020.\u0012\u0006\u0010\u001d\u001a\u00020\u001a\u0012\u0006\u0010#\u001a\u00020 \u0012\b\u00102\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b3\u00104J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0010\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0011\u0010\u000fJ\u000f\u0010\u0012\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0012\u0010\u000fJ\u0017\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010(\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0018R\u0018\u0010+\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b)\u0010*R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b/\u00100¨\u00065"}, d2 = {"Lcom/avito/android/shop/info/ShopInfoPresenterImpl;", "Lcom/avito/android/shop/info/ShopInfoPresenter;", "Lcom/avito/android/util/Kundle;", "onSaveState", "()Lcom/avito/android/util/Kundle;", "Lcom/avito/android/shop/info/ShopInfoView;", "view", "", "attachView", "(Lcom/avito/android/shop/info/ShopInfoView;)V", "Lcom/avito/android/shop/info/ShopInfoRouter;", "router", "attachRouter", "(Lcom/avito/android/shop/info/ShopInfoRouter;)V", "detachRouter", "()V", "onRefresh", "detachView", AuthSource.BOOKING_ORDER, "Lcom/avito/android/remote/shop/info/ShopInfo;", "data", AuthSource.SEND_ABUSE, "(Lcom/avito/android/remote/shop/info/ShopInfo;)V", "Lio/reactivex/rxjava3/disposables/Disposable;", "Lio/reactivex/rxjava3/disposables/Disposable;", "disposable", "Lcom/avito/android/util/SchedulersFactory3;", "h", "Lcom/avito/android/util/SchedulersFactory3;", "schedulersFactory", "d", "Lcom/avito/android/shop/info/ShopInfoRouter;", "Lcom/avito/android/shop/info/ShopInfoResourceProvider;", "i", "Lcom/avito/android/shop/info/ShopInfoResourceProvider;", "shopInfoResourceProvider", "", "f", "Ljava/lang/String;", "shopId", "clickDisposable", "e", "Lcom/avito/android/remote/shop/info/ShopInfo;", "shopInfo", "c", "Lcom/avito/android/shop/info/ShopInfoView;", "Lcom/avito/android/shop/info/ShopInfoInteractor;", g.a, "Lcom/avito/android/shop/info/ShopInfoInteractor;", "interactor", "savedState", "<init>", "(Ljava/lang/String;Lcom/avito/android/shop/info/ShopInfoInteractor;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/shop/info/ShopInfoResourceProvider;Lcom/avito/android/util/Kundle;)V", "shop_release"}, k = 1, mv = {1, 4, 2})
public final class ShopInfoPresenterImpl implements ShopInfoPresenter {
    public Disposable a;
    public Disposable b;
    public ShopInfoView c;
    public ShopInfoRouter d;
    public ShopInfo e;
    public final String f;
    public final ShopInfoInteractor g;
    public final SchedulersFactory3 h;
    public final ShopInfoResourceProvider i;

    public static final class a<T> implements Consumer<Unit> {
        public final /* synthetic */ ShopInfoPresenterImpl a;

        public a(ShopInfoPresenterImpl shopInfoPresenterImpl) {
            this.a = shopInfoPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Unit unit) {
            ShopInfoRouter shopInfoRouter = this.a.d;
            if (shopInfoRouter != null) {
                shopInfoRouter.closeShopInfo();
            }
        }
    }

    public static final class b extends Lambda implements Function0<Unit> {
        public final /* synthetic */ SellerVerification.AwardsItem a;
        public final /* synthetic */ ShopInfoPresenterImpl b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(SellerVerification.AwardsItem awardsItem, ShopInfoPresenterImpl shopInfoPresenterImpl, ShopInfo shopInfo) {
            super(0);
            this.a = awardsItem;
            this.b = shopInfoPresenterImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            ShopInfoRouter shopInfoRouter = this.b.d;
            if (shopInfoRouter != null) {
                shopInfoRouter.openAwards(this.a);
            }
            return Unit.INSTANCE;
        }
    }

    public static final class c<T> implements Consumer<LoadingState<? super ShopInfo>> {
        public final /* synthetic */ ShopInfoPresenterImpl a;

        public c(ShopInfoPresenterImpl shopInfoPresenterImpl) {
            this.a = shopInfoPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(LoadingState<? super ShopInfo> loadingState) {
            LoadingState<? super ShopInfo> loadingState2 = loadingState;
            if (loadingState2 instanceof LoadingState.Loaded) {
                LoadingState.Loaded loaded = (LoadingState.Loaded) loadingState2;
                this.a.e = (ShopInfo) loaded.getData();
                this.a.a((ShopInfo) loaded.getData());
            } else if (loadingState2 instanceof LoadingState.Loading) {
                ShopInfoView shopInfoView = this.a.c;
                if (shopInfoView != null) {
                    shopInfoView.showLoading();
                }
            } else if (loadingState2 instanceof LoadingState.Error) {
                ShopInfoPresenterImpl.access$handleError(this.a, ((LoadingState.Error) loadingState2).getError());
            }
        }
    }

    public ShopInfoPresenterImpl(@NotNull String str, @NotNull ShopInfoInteractor shopInfoInteractor, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull ShopInfoResourceProvider shopInfoResourceProvider, @Nullable Kundle kundle) {
        Intrinsics.checkNotNullParameter(str, "shopId");
        Intrinsics.checkNotNullParameter(shopInfoInteractor, "interactor");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulersFactory");
        Intrinsics.checkNotNullParameter(shopInfoResourceProvider, "shopInfoResourceProvider");
        this.f = str;
        this.g = shopInfoInteractor;
        this.h = schedulersFactory3;
        this.i = shopInfoResourceProvider;
        this.e = kundle != null ? (ShopInfo) kundle.getParcelable("shop_info") : null;
    }

    public static final void access$handleError(ShopInfoPresenterImpl shopInfoPresenterImpl, TypedError typedError) {
        Objects.requireNonNull(shopInfoPresenterImpl);
        if (typedError instanceof ErrorResult.NetworkIOError) {
            ShopInfoView shopInfoView = shopInfoPresenterImpl.c;
            if (shopInfoView != null) {
                shopInfoView.showRetryOverlay();
            }
        } else if (typedError instanceof ShopNotFoundError) {
            ShopInfoView shopInfoView2 = shopInfoPresenterImpl.c;
            if (shopInfoView2 != null) {
                shopInfoView2.hideLoading();
            }
            ShopInfoView shopInfoView3 = shopInfoPresenterImpl.c;
            if (shopInfoView3 != null) {
                shopInfoView3.showShopNotFoundError(((ShopNotFoundError) typedError).getMessage());
            }
        } else if (typedError instanceof ErrorWithMessage) {
            ShopInfoView shopInfoView4 = shopInfoPresenterImpl.c;
            if (shopInfoView4 != null) {
                shopInfoView4.hideLoading();
            }
            ShopInfoView shopInfoView5 = shopInfoPresenterImpl.c;
            if (shopInfoView5 != null) {
                shopInfoView5.showError(((ErrorWithMessage) typedError).getMessage());
            }
        } else {
            ShopInfoView shopInfoView6 = shopInfoPresenterImpl.c;
            if (shopInfoView6 != null) {
                shopInfoView6.hideLoading();
            }
            ShopInfoView shopInfoView7 = shopInfoPresenterImpl.c;
            if (shopInfoView7 != null) {
                shopInfoView7.showError(shopInfoPresenterImpl.i.getUnknownError());
            }
        }
    }

    public final void a(ShopInfo shopInfo) {
        ShopInfoView shopInfoView = this.c;
        if (shopInfoView != null) {
            shopInfoView.showTitle(shopInfo.getTitle());
            shopInfoView.showSubtitle(shopInfo.getSubtitle());
            shopInfoView.showDescription(shopInfo.getDescription());
            SellerVerification sellerVerification = shopInfo.getSellerVerification();
            SellerVerification.AwardsItem awards = sellerVerification != null ? sellerVerification.getAwards() : null;
            if (awards != null) {
                shopInfoView.setAwards(awards.getTitle());
                shopInfoView.setAwardsOnClickListener(new b(awards, this, shopInfo));
            }
            shopInfoView.hideLoading();
        }
    }

    @Override // com.avito.android.shop.info.ShopInfoPresenter
    public void attachRouter(@NotNull ShopInfoRouter shopInfoRouter) {
        Intrinsics.checkNotNullParameter(shopInfoRouter, "router");
        this.d = shopInfoRouter;
    }

    @Override // com.avito.android.shop.info.ShopInfoPresenter
    public void attachView(@NotNull ShopInfoView shopInfoView) {
        Intrinsics.checkNotNullParameter(shopInfoView, "view");
        this.c = shopInfoView;
        this.a = shopInfoView.navigationCallbacks().subscribe(new a(this));
        ShopInfo shopInfo = this.e;
        if (shopInfo == null) {
            b();
        } else {
            a(shopInfo);
        }
    }

    public final void b() {
        Disposable disposable = this.b;
        if (disposable != null) {
            disposable.dispose();
        }
        this.b = this.g.getInfo(this.f).observeOn(this.h.mainThread()).subscribe(new c(this));
    }

    @Override // com.avito.android.shop.info.ShopInfoPresenter
    public void detachRouter() {
        this.d = null;
    }

    @Override // com.avito.android.shop.info.ShopInfoPresenter
    public void detachView() {
        Disposable disposable = this.b;
        if (disposable != null) {
            disposable.dispose();
        }
        this.b = null;
        Disposable disposable2 = this.a;
        if (disposable2 != null) {
            disposable2.dispose();
        }
        this.a = null;
        this.c = null;
    }

    @Override // com.avito.android.shop.info.ShopInfoViewPresenter
    public void onRefresh() {
        b();
    }

    @Override // com.avito.android.shop.info.ShopInfoPresenter
    @NotNull
    public Kundle onSaveState() {
        Kundle kundle = new Kundle();
        kundle.putParcelable("shop_info", this.e);
        return kundle;
    }
}
