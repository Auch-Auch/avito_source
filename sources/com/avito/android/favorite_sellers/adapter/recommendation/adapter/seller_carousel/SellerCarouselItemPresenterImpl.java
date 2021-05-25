package com.avito.android.favorite_sellers.adapter.recommendation.adapter.seller_carousel;

import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.favorite_sellers.SellerCarouselItem;
import com.avito.android.favorite_sellers.action.DeepLinkAction;
import com.avito.android.favorite_sellers.action.FavoriteSellersItemAction;
import com.avito.android.favorite_sellers.action.RecommendationAction;
import com.avito.android.image_loader.AvitoPictureKt;
import com.avito.android.image_loader.Picture;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Image;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.kotlin.DisposableKt;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\u0010\u0010\u0011J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/avito/android/favorite_sellers/adapter/recommendation/adapter/seller_carousel/SellerCarouselItemPresenterImpl;", "Lcom/avito/android/favorite_sellers/adapter/recommendation/adapter/seller_carousel/SellerCarouselItemPresenter;", "Lcom/avito/android/favorite_sellers/adapter/recommendation/adapter/seller_carousel/SellerCarouselItemView;", "view", "Lcom/avito/android/favorite_sellers/SellerCarouselItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/favorite_sellers/adapter/recommendation/adapter/seller_carousel/SellerCarouselItemView;Lcom/avito/android/favorite_sellers/SellerCarouselItem;I)V", "Lio/reactivex/rxjava3/functions/Consumer;", "Lcom/avito/android/favorite_sellers/action/FavoriteSellersItemAction;", AuthSource.SEND_ABUSE, "Lio/reactivex/rxjava3/functions/Consumer;", "clicksConsumer", "<init>", "(Lio/reactivex/rxjava3/functions/Consumer;)V", "favorite-sellers-items_release"}, k = 1, mv = {1, 4, 2})
public final class SellerCarouselItemPresenterImpl implements SellerCarouselItemPresenter {
    public final Consumer<FavoriteSellersItemAction> a;

    /* compiled from: java-style lambda group */
    public static final class a<T> implements Consumer<Unit> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;
        public final /* synthetic */ Object c;

        public a(int i, Object obj, Object obj2) {
            this.a = i;
            this.b = obj;
            this.c = obj2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r3v4, resolved type: io.reactivex.rxjava3.functions.Consumer */
        /* JADX DEBUG: Multi-variable search result rejected for r3v9, resolved type: io.reactivex.rxjava3.functions.Consumer */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public final void accept(Unit unit) {
            int i = this.a;
            if (i == 0) {
                ((SellerCarouselItemPresenterImpl) this.b).a.accept(new RecommendationAction.Subscribe((SellerCarouselItem) this.c));
            } else if (i == 1) {
                ((SellerCarouselItemPresenterImpl) this.b).a.accept(new RecommendationAction.OpenSubscriptionSettings((SellerCarouselItem) this.c));
            } else {
                throw null;
            }
        }
    }

    public static final class b<T> implements Consumer<Unit> {
        public final /* synthetic */ DeepLink a;
        public final /* synthetic */ SellerCarouselItemView b;
        public final /* synthetic */ SellerCarouselItemPresenterImpl c;

        public b(DeepLink deepLink, SellerCarouselItemView sellerCarouselItemView, CompositeDisposable compositeDisposable, SellerCarouselItemPresenterImpl sellerCarouselItemPresenterImpl, SellerCarouselItem sellerCarouselItem) {
            this.a = deepLink;
            this.b = sellerCarouselItemView;
            this.c = sellerCarouselItemPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r3v3, resolved type: io.reactivex.rxjava3.functions.Consumer */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Unit unit) {
            this.c.a.accept(new DeepLinkAction(this.a));
        }
    }

    public static final class c extends Lambda implements Function0<Unit> {
        public final /* synthetic */ SellerCarouselItemView a;
        public final /* synthetic */ CompositeDisposable b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(SellerCarouselItemView sellerCarouselItemView, CompositeDisposable compositeDisposable) {
            super(0);
            this.a = sellerCarouselItemView;
            this.b = compositeDisposable;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.setUnbindListener(null);
            this.b.clear();
            return Unit.INSTANCE;
        }
    }

    @Inject
    public SellerCarouselItemPresenterImpl(@NotNull Consumer<FavoriteSellersItemAction> consumer) {
        Intrinsics.checkNotNullParameter(consumer, "clicksConsumer");
        this.a = consumer;
    }

    public void bindView(@NotNull SellerCarouselItemView sellerCarouselItemView, @NotNull SellerCarouselItem sellerCarouselItem, int i) {
        Intrinsics.checkNotNullParameter(sellerCarouselItemView, "view");
        Intrinsics.checkNotNullParameter(sellerCarouselItem, "item");
        Image avatar = sellerCarouselItem.getAvatar();
        Picture pictureOf$default = avatar != null ? AvitoPictureKt.pictureOf$default(avatar, true, 0.0f, 0.0f, null, 28, null) : null;
        if (sellerCarouselItem.isShop()) {
            sellerCarouselItemView.setShopAvatar(pictureOf$default);
        } else {
            sellerCarouselItemView.setUserAvatar(pictureOf$default);
        }
        sellerCarouselItemView.setName(sellerCarouselItem.getName());
        sellerCarouselItemView.setDescription(sellerCarouselItem.getDescription());
        if (sellerCarouselItem.isSubscribed()) {
            sellerCarouselItemView.showSettingsButton();
        } else {
            sellerCarouselItemView.showSubscribeButton();
            sellerCarouselItemView.setSubscriptionButtonLoading(sellerCarouselItem.isSubscribeLoading());
        }
        List<SellerCarouselItem.Advert> adverts = sellerCarouselItem.getAdverts();
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(adverts, 10));
        for (T t : adverts) {
            Image image = t.getImage();
            arrayList.add(new AdvertWithOverlay(image != null ? AvitoPictureKt.pictureOf$default(image, true, 0.0f, 0.0f, null, 28, null) : null, t.getTitle(), t.getSubtitle()));
        }
        sellerCarouselItemView.setAdverts(arrayList);
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        sellerCarouselItemView.setUnbindListener(new c(sellerCarouselItemView, compositeDisposable));
        DeepLink deepLink = sellerCarouselItem.getDeepLink();
        if (deepLink != null) {
            Disposable subscribe = sellerCarouselItemView.clicks().subscribe(new b<>(deepLink, sellerCarouselItemView, compositeDisposable, this, sellerCarouselItem));
            Intrinsics.checkNotNullExpressionValue(subscribe, "clicks().subscribe {\n   …pLink))\n                }");
            DisposableKt.plusAssign(compositeDisposable, subscribe);
        }
        Disposable subscribe2 = sellerCarouselItemView.subscribeClicks().subscribe(new a<>(0, this, sellerCarouselItem));
        Intrinsics.checkNotNullExpressionValue(subscribe2, "subscribeClicks().subscr…ribe(item))\n            }");
        DisposableKt.plusAssign(compositeDisposable, subscribe2);
        Disposable subscribe3 = sellerCarouselItemView.settingsClicks().subscribe(new a<>(1, this, sellerCarouselItem));
        Intrinsics.checkNotNullExpressionValue(subscribe3, "settingsClicks().subscri…ings(item))\n            }");
        DisposableKt.plusAssign(compositeDisposable, subscribe3);
    }
}
