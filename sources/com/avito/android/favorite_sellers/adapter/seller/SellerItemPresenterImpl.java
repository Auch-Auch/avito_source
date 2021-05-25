package com.avito.android.favorite_sellers.adapter.seller;

import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.NoMatchLink;
import com.avito.android.favorite_sellers.action.DeepLinkAction;
import com.avito.android.favorite_sellers.action.FavoriteSellersItemAction;
import com.avito.android.favorite_sellers.action.OpenSubscriptionSettings;
import com.avito.android.favorite_sellers.adapter.seller.SellerItemViewImpl;
import com.avito.android.image_loader.AvitoPictureKt;
import com.avito.android.image_loader.Picture;
import com.avito.android.notification_manager_provider.NotificationManagerProvider;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Image;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.kotlin.DisposableKt;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u0014\u0010\u0015J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/avito/android/favorite_sellers/adapter/seller/SellerItemPresenterImpl;", "Lcom/avito/android/favorite_sellers/adapter/seller/SellerItemPresenter;", "Lcom/avito/android/favorite_sellers/adapter/seller/SellerItemView;", "view", "Lcom/avito/android/favorite_sellers/adapter/seller/SellerItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/favorite_sellers/adapter/seller/SellerItemView;Lcom/avito/android/favorite_sellers/adapter/seller/SellerItem;I)V", "Lcom/avito/android/notification_manager_provider/NotificationManagerProvider;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/notification_manager_provider/NotificationManagerProvider;", "notificationManagerProvider", "Lio/reactivex/rxjava3/functions/Consumer;", "Lcom/avito/android/favorite_sellers/action/FavoriteSellersItemAction;", AuthSource.SEND_ABUSE, "Lio/reactivex/rxjava3/functions/Consumer;", "clicksConsumer", "<init>", "(Lio/reactivex/rxjava3/functions/Consumer;Lcom/avito/android/notification_manager_provider/NotificationManagerProvider;)V", "favorite-sellers-items_release"}, k = 1, mv = {1, 4, 2})
public final class SellerItemPresenterImpl implements SellerItemPresenter {
    public final Consumer<FavoriteSellersItemAction> a;
    public final NotificationManagerProvider b;

    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ DeepLinkAction a;
        public final /* synthetic */ SellerItemPresenterImpl b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(DeepLinkAction deepLinkAction, SellerItemPresenterImpl sellerItemPresenterImpl, SellerItem sellerItem, boolean z) {
            super(0);
            this.a = deepLinkAction;
            this.b = sellerItemPresenterImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.b.a.accept(this.a);
            return Unit.INSTANCE;
        }
    }

    public static final class b<T> implements Consumer<Unit> {
        public final /* synthetic */ SellerItemPresenterImpl a;
        public final /* synthetic */ SellerItem b;

        public b(SellerItemPresenterImpl sellerItemPresenterImpl, SellerItem sellerItem, boolean z) {
            this.a = sellerItemPresenterImpl;
            this.b = sellerItem;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r3v3, resolved type: io.reactivex.rxjava3.functions.Consumer */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Unit unit) {
            this.a.a.accept(new OpenSubscriptionSettings(this.b));
        }
    }

    public static final class c extends Lambda implements Function0<Unit> {
        public final /* synthetic */ SellerItemView a;
        public final /* synthetic */ CompositeDisposable b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(SellerItemView sellerItemView, CompositeDisposable compositeDisposable) {
            super(0);
            this.a = sellerItemView;
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
    public SellerItemPresenterImpl(@NotNull Consumer<FavoriteSellersItemAction> consumer, @NotNull NotificationManagerProvider notificationManagerProvider) {
        Intrinsics.checkNotNullParameter(consumer, "clicksConsumer");
        Intrinsics.checkNotNullParameter(notificationManagerProvider, "notificationManagerProvider");
        this.a = consumer;
        this.b = notificationManagerProvider;
    }

    public void bindView(@NotNull SellerItemView sellerItemView, @NotNull SellerItem sellerItem, int i) {
        SellerItemViewImpl.NewItemsIndicatorState newItemsIndicatorState;
        Intrinsics.checkNotNullParameter(sellerItemView, "view");
        Intrinsics.checkNotNullParameter(sellerItem, "item");
        boolean areNotificationsEnabled = this.b.getAreNotificationsEnabled();
        Image avatar = sellerItem.getAvatar();
        boolean z = false;
        a aVar = null;
        Image image = avatar != null ? avatar : null;
        Picture pictureOf$default = image != null ? AvitoPictureKt.pictureOf$default(image, true, 0.0f, 0.0f, null, 28, null) : null;
        if (sellerItem.isShop()) {
            sellerItemView.setShopAvatar(pictureOf$default);
        } else {
            sellerItemView.setUserAvatar(pictureOf$default);
        }
        sellerItemView.setTitle(sellerItem.getName());
        sellerItemView.setSubtitle(sellerItem.getDescription(), sellerItem.isDisabled() ? 2 : 1);
        sellerItemView.setDisabled(sellerItem.isDisabled() || !sellerItem.isSubscribed());
        Boolean isNotificationsActivated = sellerItem.isNotificationsActivated();
        Boolean bool = Boolean.TRUE;
        if (!Intrinsics.areEqual(isNotificationsActivated, bool) || !areNotificationsEnabled || !Intrinsics.areEqual(sellerItem.getHasNewItems(), bool)) {
            Boolean isNotificationsActivated2 = sellerItem.isNotificationsActivated();
            if (isNotificationsActivated2 != null) {
                z = isNotificationsActivated2.booleanValue();
            }
            if ((!z || !areNotificationsEnabled) && Intrinsics.areEqual(sellerItem.getHasNewItems(), bool)) {
                newItemsIndicatorState = SellerItemViewImpl.NewItemsIndicatorState.GRAY;
            } else {
                newItemsIndicatorState = SellerItemViewImpl.NewItemsIndicatorState.HIDDEN;
            }
        } else {
            newItemsIndicatorState = SellerItemViewImpl.NewItemsIndicatorState.RED;
        }
        sellerItemView.setNewItemsIndicatorState(newItemsIndicatorState);
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        sellerItemView.setUnbindListener(new c(sellerItemView, compositeDisposable));
        DeepLink deepLink = sellerItem.getDeepLink();
        if (!(true ^ (deepLink instanceof NoMatchLink))) {
            deepLink = null;
        }
        if (deepLink != null) {
            aVar = new a(new DeepLinkAction(deepLink), this, sellerItem, areNotificationsEnabled);
        }
        sellerItemView.setOnClickListener(aVar);
        Disposable subscribe = sellerItemView.moreButtonClicks().subscribe(new b(this, sellerItem, areNotificationsEnabled));
        Intrinsics.checkNotNullExpressionValue(subscribe, "moreButtonClicks().subsc…ings(item))\n            }");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }
}
