package com.avito.android.advert.item.sellersubscription;

import com.avito.android.advert.item.sellersubscription.AdvertDetailsSellerSubscriptionView;
import com.avito.android.advert.item.sellersubscription.action.SellerSubscriptionAction;
import com.avito.android.remote.auth.AuthSource;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.kotlin.DisposableKt;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\u0010\u0010\u0011J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/avito/android/advert/item/sellersubscription/AdvertDetailsSellerSubscriptionPresenterImpl;", "Lcom/avito/android/advert/item/sellersubscription/AdvertDetailsSellerSubscriptionPresenter;", "Lcom/avito/android/advert/item/sellersubscription/AdvertDetailsSellerSubscriptionView;", "view", "Lcom/avito/android/advert/item/sellersubscription/AdvertDetailsSellerSubscriptionItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/advert/item/sellersubscription/AdvertDetailsSellerSubscriptionView;Lcom/avito/android/advert/item/sellersubscription/AdvertDetailsSellerSubscriptionItem;I)V", "Lio/reactivex/rxjava3/functions/Consumer;", "Lcom/avito/android/advert/item/sellersubscription/action/SellerSubscriptionAction;", AuthSource.SEND_ABUSE, "Lio/reactivex/rxjava3/functions/Consumer;", "actionConsumer", "<init>", "(Lio/reactivex/rxjava3/functions/Consumer;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertDetailsSellerSubscriptionPresenterImpl implements AdvertDetailsSellerSubscriptionPresenter {
    public final Consumer<SellerSubscriptionAction> a;

    public static final class a<T> implements Consumer<Unit> {
        public final /* synthetic */ AdvertDetailsSellerSubscriptionPresenterImpl a;
        public final /* synthetic */ AdvertDetailsSellerSubscriptionItem b;

        public a(AdvertDetailsSellerSubscriptionPresenterImpl advertDetailsSellerSubscriptionPresenterImpl, AdvertDetailsSellerSubscriptionItem advertDetailsSellerSubscriptionItem) {
            this.a = advertDetailsSellerSubscriptionPresenterImpl;
            this.b = advertDetailsSellerSubscriptionItem;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r3v5, resolved type: io.reactivex.rxjava3.functions.Consumer */
        /* JADX DEBUG: Multi-variable search result rejected for r3v7, resolved type: io.reactivex.rxjava3.functions.Consumer */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Unit unit) {
            if (this.b.getSubscriptionState() == SellerSubscriptionState.SUBSCRIBED) {
                this.a.a.accept(new SellerSubscriptionAction.OpenSubscriptionSettings(this.b));
            } else {
                this.a.a.accept(new SellerSubscriptionAction.Subscribe(this.b));
            }
        }
    }

    @Inject
    public AdvertDetailsSellerSubscriptionPresenterImpl(@NotNull Consumer<SellerSubscriptionAction> consumer) {
        Intrinsics.checkNotNullParameter(consumer, "actionConsumer");
        this.a = consumer;
    }

    public void bindView(@NotNull AdvertDetailsSellerSubscriptionView advertDetailsSellerSubscriptionView, @NotNull AdvertDetailsSellerSubscriptionItem advertDetailsSellerSubscriptionItem, int i) {
        Intrinsics.checkNotNullParameter(advertDetailsSellerSubscriptionView, "view");
        Intrinsics.checkNotNullParameter(advertDetailsSellerSubscriptionItem, "item");
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        advertDetailsSellerSubscriptionView.setUnbindListener(new AdvertDetailsSellerSubscriptionView.UnbindListener(advertDetailsSellerSubscriptionView, compositeDisposable) { // from class: com.avito.android.advert.item.sellersubscription.AdvertDetailsSellerSubscriptionPresenterImpl$bindView$1
            public final /* synthetic */ AdvertDetailsSellerSubscriptionView a;
            public final /* synthetic */ CompositeDisposable b;

            {
                this.a = r1;
                this.b = r2;
            }

            @Override // com.avito.android.advert.item.sellersubscription.AdvertDetailsSellerSubscriptionView.UnbindListener
            public void onUnbind() {
                this.a.setUnbindListener(null);
                this.b.clear();
            }
        });
        Disposable subscribe = advertDetailsSellerSubscriptionView.subscribeClicks().subscribe(new a(this, advertDetailsSellerSubscriptionItem));
        Intrinsics.checkNotNullExpressionValue(subscribe, "view.subscribeClicks().s…)\n            }\n        }");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
        advertDetailsSellerSubscriptionView.setSubscribeState(advertDetailsSellerSubscriptionItem.getSubscriptionState());
    }
}
