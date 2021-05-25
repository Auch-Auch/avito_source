package com.avito.android.basket.checkout.item.disclaimer;

import com.avito.android.component.disclaimer.DisclaimerItem;
import com.avito.android.component.disclaimer.DisclaimerViewHolder;
import com.avito.android.deep_linking.DeeplinkClickStreamProvider;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.OnDeepLinkClickListener;
import com.avito.android.di.PerFragment;
import com.avito.android.remote.auth.AuthSource;
import com.avito.konveyor.blueprint.ItemPresenter;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@PerFragment
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004B\t\b\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ'\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bR$\u0010\u0011\u001a\u0010\u0012\f\u0012\n \u000e*\u0004\u0018\u00010\r0\r0\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\"\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\r0\u00168\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001e"}, d2 = {"Lcom/avito/android/basket/checkout/item/disclaimer/CheckoutDisclaimerItemPresenter;", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lcom/avito/android/component/disclaimer/DisclaimerViewHolder;", "Lcom/avito/android/component/disclaimer/DisclaimerItem;", "Lcom/avito/android/deep_linking/DeeplinkClickStreamProvider;", "view", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/component/disclaimer/DisclaimerViewHolder;Lcom/avito/android/component/disclaimer/DisclaimerItem;I)V", "Lio/reactivex/subjects/PublishSubject;", "Lcom/avito/android/deep_linking/links/DeepLink;", "kotlin.jvm.PlatformType", AuthSource.SEND_ABUSE, "Lio/reactivex/subjects/PublishSubject;", "deeplinkSubject", "Lcom/avito/android/deep_linking/links/OnDeepLinkClickListener;", "c", "Lcom/avito/android/deep_linking/links/OnDeepLinkClickListener;", "deepLinkClickListener", "Lio/reactivex/Observable;", AuthSource.BOOKING_ORDER, "Lio/reactivex/Observable;", "getDeeplinkClicks", "()Lio/reactivex/Observable;", "deeplinkClicks", "<init>", "()V", "basket_release"}, k = 1, mv = {1, 4, 2})
public final class CheckoutDisclaimerItemPresenter implements ItemPresenter<DisclaimerViewHolder, DisclaimerItem>, DeeplinkClickStreamProvider {
    public final PublishSubject<DeepLink> a;
    @NotNull
    public final Observable<DeepLink> b;
    public final OnDeepLinkClickListener c = new OnDeepLinkClickListener(this) { // from class: com.avito.android.basket.checkout.item.disclaimer.CheckoutDisclaimerItemPresenter$deepLinkClickListener$1
        public final /* synthetic */ CheckoutDisclaimerItemPresenter a;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        {
            this.a = r1;
        }

        @Override // com.avito.android.deep_linking.links.OnDeepLinkClickListener
        public void onDeepLinkClick(@NotNull DeepLink deepLink) {
            Intrinsics.checkNotNullParameter(deepLink, "deepLink");
            this.a.a.onNext(deepLink);
        }
    };

    @Inject
    public CheckoutDisclaimerItemPresenter() {
        PublishSubject<DeepLink> create = PublishSubject.create();
        Intrinsics.checkNotNullExpressionValue(create, "PublishSubject.create<DeepLink>()");
        this.a = create;
        this.b = create;
    }

    @Override // com.avito.android.deep_linking.DeeplinkClickStreamProvider
    @NotNull
    public Observable<DeepLink> getDeeplinkClicks() {
        return this.b;
    }

    public void bindView(@NotNull DisclaimerViewHolder disclaimerViewHolder, @NotNull DisclaimerItem disclaimerItem, int i) {
        Intrinsics.checkNotNullParameter(disclaimerViewHolder, "view");
        Intrinsics.checkNotNullParameter(disclaimerItem, "item");
        disclaimerViewHolder.setText(disclaimerItem.getText());
        disclaimerItem.getText().setOnDeepLinkClickListener(this.c);
    }
}
