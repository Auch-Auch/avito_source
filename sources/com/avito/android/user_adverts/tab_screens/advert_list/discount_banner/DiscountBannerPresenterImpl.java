package com.avito.android.user_adverts.tab_screens.advert_list.discount_banner;

import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.auth.AuthSource;
import com.jakewharton.rxrelay2.PublishRelay;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0017\u0010\u0018J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\"\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R:\u0010\u0016\u001a&\u0012\f\u0012\n \u0013*\u0004\u0018\u00010\f0\f \u0013*\u0012\u0012\f\u0012\n \u0013*\u0004\u0018\u00010\f0\f\u0018\u00010\u00120\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/avito/android/user_adverts/tab_screens/advert_list/discount_banner/DiscountBannerPresenterImpl;", "Lcom/avito/android/user_adverts/tab_screens/advert_list/discount_banner/DiscountBannerPresenter;", "Lcom/avito/android/user_adverts/tab_screens/advert_list/discount_banner/DiscountBannerItemView;", "view", "Lcom/avito/android/user_adverts/tab_screens/advert_list/discount_banner/DiscountBannerItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/user_adverts/tab_screens/advert_list/discount_banner/DiscountBannerItemView;Lcom/avito/android/user_adverts/tab_screens/advert_list/discount_banner/DiscountBannerItem;I)V", "Lio/reactivex/Observable;", "Lcom/avito/android/deep_linking/links/DeepLink;", AuthSource.BOOKING_ORDER, "Lio/reactivex/Observable;", "getDeeplinkClicks", "()Lio/reactivex/Observable;", "deeplinkClicks", "Lcom/jakewharton/rxrelay2/PublishRelay;", "kotlin.jvm.PlatformType", AuthSource.SEND_ABUSE, "Lcom/jakewharton/rxrelay2/PublishRelay;", "deeplinkRelay", "<init>", "()V", "user-adverts_release"}, k = 1, mv = {1, 4, 2})
public final class DiscountBannerPresenterImpl implements DiscountBannerPresenter {
    public final PublishRelay<DeepLink> a;
    @NotNull
    public final Observable<DeepLink> b;

    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ DiscountBannerPresenterImpl a;
        public final /* synthetic */ DiscountBannerItem b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(DiscountBannerPresenterImpl discountBannerPresenterImpl, DiscountBannerItem discountBannerItem) {
            super(0);
            this.a = discountBannerPresenterImpl;
            this.b = discountBannerItem;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.a.accept(this.b.getDeepLink());
            return Unit.INSTANCE;
        }
    }

    @Inject
    public DiscountBannerPresenterImpl() {
        PublishRelay<DeepLink> create = PublishRelay.create();
        this.a = create;
        Intrinsics.checkNotNullExpressionValue(create, "deeplinkRelay");
        this.b = create;
    }

    @Override // com.avito.android.deep_linking.DeeplinkClickStreamProvider
    @NotNull
    public Observable<DeepLink> getDeeplinkClicks() {
        return this.b;
    }

    public void bindView(@NotNull DiscountBannerItemView discountBannerItemView, @NotNull DiscountBannerItem discountBannerItem, int i) {
        Intrinsics.checkNotNullParameter(discountBannerItemView, "view");
        Intrinsics.checkNotNullParameter(discountBannerItem, "item");
        discountBannerItemView.setTitle(discountBannerItem.getTitle());
        discountBannerItemView.setDiscountAmount(discountBannerItem.getDiscountAmount());
        discountBannerItemView.setLimitDescription(discountBannerItem.getLimitDescription());
        Long dueDate = discountBannerItem.getDueDate();
        if (dueDate != null) {
            discountBannerItemView.showDiscountTimer(dueDate.longValue());
        } else {
            discountBannerItemView.hideDiscountTimer();
        }
        discountBannerItemView.setClickListener(new a(this, discountBannerItem));
    }
}
