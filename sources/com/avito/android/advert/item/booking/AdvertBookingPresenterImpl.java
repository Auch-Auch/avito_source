package com.avito.android.advert.item.booking;

import com.avito.android.advert.item.booking.AdvertBookingPresenter;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.OnDeepLinkClickListener;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Booking;
import com.avito.android.remote.model.text.AttributedText;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0013\u0010\u0014J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR$\u0010\u0012\u001a\u0004\u0018\u00010\u000b8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/avito/android/advert/item/booking/AdvertBookingPresenterImpl;", "Lcom/avito/android/advert/item/booking/AdvertBookingPresenter;", "Lcom/avito/android/advert/item/booking/AdvertBookingView;", "view", "Lcom/avito/android/advert/item/booking/AdvertBookingItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/advert/item/booking/AdvertBookingView;Lcom/avito/android/advert/item/booking/AdvertBookingItem;I)V", "Lcom/avito/android/advert/item/booking/AdvertBookingPresenter$Router;", AuthSource.SEND_ABUSE, "Lcom/avito/android/advert/item/booking/AdvertBookingPresenter$Router;", "getRouter", "()Lcom/avito/android/advert/item/booking/AdvertBookingPresenter$Router;", "setRouter", "(Lcom/avito/android/advert/item/booking/AdvertBookingPresenter$Router;)V", "router", "<init>", "()V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertBookingPresenterImpl implements AdvertBookingPresenter {
    @Nullable
    public AdvertBookingPresenter.Router a;

    /* compiled from: kotlin-style lambda group */
    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;
        public final /* synthetic */ Object c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(int i, Object obj, Object obj2) {
            super(0);
            this.a = i;
            this.b = obj;
            this.c = obj2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            int i = this.a;
            if (i == 0) {
                AdvertBookingPresenter.Router router = ((AdvertBookingPresenterImpl) this.b).getRouter();
                if (router != null) {
                    DeepLink deepLink = ((Booking) this.c).getButton().getDeepLink();
                    Intrinsics.checkNotNull(deepLink);
                    router.followDeepLink(deepLink);
                }
                return Unit.INSTANCE;
            } else if (i == 1) {
                AttributedText text = ((Booking) this.b).getText();
                if (text != null) {
                    text.setOnDeepLinkClickListener(null);
                }
                ((AdvertBookingView) this.c).setUnbindListener(null);
                return Unit.INSTANCE;
            } else {
                throw null;
            }
        }
    }

    @Override // com.avito.android.advert.item.booking.AdvertBookingPresenter
    @Nullable
    public AdvertBookingPresenter.Router getRouter() {
        return this.a;
    }

    @Override // com.avito.android.advert.item.booking.AdvertBookingPresenter
    public void setRouter(@Nullable AdvertBookingPresenter.Router router) {
        this.a = router;
    }

    public void bindView(@NotNull AdvertBookingView advertBookingView, @NotNull AdvertBookingItem advertBookingItem, int i) {
        Intrinsics.checkNotNullParameter(advertBookingView, "view");
        Intrinsics.checkNotNullParameter(advertBookingItem, "item");
        Booking booking = advertBookingItem.getBooking();
        String title = booking.getButton().getTitle();
        if (booking.getButton().getDeepLink() != null) {
            advertBookingView.setButtonParams(title, true);
            advertBookingView.setButtonClickListener(new a(0, this, booking));
        } else {
            advertBookingView.setButtonParams(title, false);
            advertBookingView.setButtonClickListener(null);
        }
        AttributedText text = booking.getText();
        if (text != null) {
            text.setOnDeepLinkClickListener(new OnDeepLinkClickListener(this) { // from class: com.avito.android.advert.item.booking.AdvertBookingPresenterImpl$bindView$2
                public final /* synthetic */ AdvertBookingPresenterImpl a;

                /* JADX WARN: Incorrect args count in method signature: ()V */
                {
                    this.a = r1;
                }

                @Override // com.avito.android.deep_linking.links.OnDeepLinkClickListener
                public void onDeepLinkClick(@NotNull DeepLink deepLink) {
                    Intrinsics.checkNotNullParameter(deepLink, "deepLink");
                    AdvertBookingPresenter.Router router = this.a.getRouter();
                    if (router != null) {
                        router.followDeepLink(deepLink);
                    }
                }
            });
        }
        advertBookingView.setText(booking.getText());
        advertBookingView.setUnbindListener(new a(1, booking, advertBookingView));
    }
}
