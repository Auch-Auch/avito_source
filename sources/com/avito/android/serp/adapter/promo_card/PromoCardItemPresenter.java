package com.avito.android.serp.adapter.promo_card;

import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.event.BannerEvent;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.serp.analytics.ReportBannerClicked;
import com.avito.android.serp.analytics.ReportBannerShown;
import com.avito.android.serp_core.R;
import com.avito.konveyor.blueprint.ItemPresenter;
import com.vk.sdk.api.VKApiConst;
import dagger.Lazy;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u001bB!\b\u0007\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0016\u0012\u0006\u0010\u0015\u001a\u00020\u0012¢\u0006\u0004\b\u0019\u0010\u001aJ\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ'\u0010\r\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u001c"}, d2 = {"Lcom/avito/android/serp/adapter/promo_card/PromoCardItemPresenter;", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lcom/avito/android/serp/adapter/promo_card/PromoCardItemView;", "Lcom/avito/android/serp/adapter/promo_card/PromoCardItem;", "Lcom/avito/android/serp/adapter/promo_card/PromoCardItemPresenter$Router;", "router", "", "bindRouter", "(Lcom/avito/android/serp/adapter/promo_card/PromoCardItemPresenter$Router;)V", "view", "item", "", VKApiConst.POSITION, "bindView", "(Lcom/avito/android/serp/adapter/promo_card/PromoCardItemView;Lcom/avito/android/serp/adapter/promo_card/PromoCardItem;I)V", AuthSource.SEND_ABUSE, "Lcom/avito/android/serp/adapter/promo_card/PromoCardItemPresenter$Router;", "boundRouter", "Lcom/avito/android/analytics/Analytics;", "c", "Lcom/avito/android/analytics/Analytics;", "analytics", "Ldagger/Lazy;", AuthSource.BOOKING_ORDER, "Ldagger/Lazy;", "<init>", "(Ldagger/Lazy;Lcom/avito/android/analytics/Analytics;)V", "Router", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class PromoCardItemPresenter implements ItemPresenter<PromoCardItemView, PromoCardItem> {
    public Router a;
    public final Lazy<Router> b;
    public final Analytics c;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/avito/android/serp/adapter/promo_card/PromoCardItemPresenter$Router;", "", "Lcom/avito/android/serp/adapter/promo_card/PromoCardItem;", "item", "", "onBannerClicked", "(Lcom/avito/android/serp/adapter/promo_card/PromoCardItem;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
    public interface Router {
        void onBannerClicked(@NotNull PromoCardItem promoCardItem);
    }

    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ PromoCardItemPresenter a;
        public final /* synthetic */ PromoCardItem b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(PromoCardItemPresenter promoCardItemPresenter, PromoCardItem promoCardItem) {
            super(0);
            this.a = promoCardItemPresenter;
            this.b = promoCardItem;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            Router router;
            PromoCardItemPresenter.access$sendClickEvent(this.a, this.b);
            Lazy lazy = this.a.b;
            if (!(lazy == null || (router = (Router) lazy.get()) == null)) {
                router.onBannerClicked(this.b);
            }
            Router router2 = this.a.a;
            if (router2 != null) {
                router2.onBannerClicked(this.b);
            }
            return Unit.INSTANCE;
        }
    }

    @Inject
    public PromoCardItemPresenter(@Nullable Lazy<Router> lazy, @NotNull Analytics analytics) {
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        this.b = lazy;
        this.c = analytics;
    }

    public static final void access$sendClickEvent(PromoCardItemPresenter promoCardItemPresenter, PromoCardItem promoCardItem) {
        Objects.requireNonNull(promoCardItemPresenter);
        if (!Intrinsics.areEqual(promoCardItem.getStringId(), "ShortTimeRentHotels")) {
            promoCardItemPresenter.c.track(new ReportBannerClicked(0, 0, promoCardItem.getAdvertId(), 3, null));
        }
    }

    public final void bindRouter(@NotNull Router router) {
        Intrinsics.checkNotNullParameter(router, "router");
        this.a = router;
    }

    public void bindView(@NotNull PromoCardItemView promoCardItemView, @NotNull PromoCardItem promoCardItem, int i) {
        Integer num;
        Intrinsics.checkNotNullParameter(promoCardItemView, "view");
        Intrinsics.checkNotNullParameter(promoCardItem, "item");
        if (!promoCardItem.getShowedEventSent()) {
            if (Intrinsics.areEqual(promoCardItem.getStringId(), "ShortTimeRentHotels")) {
                this.c.track(new BannerEvent.Shown("hotels_banner", "str_serp", ""));
            } else {
                this.c.track(new ReportBannerShown(0, 0, promoCardItem.getAdvertId(), 3, null));
            }
            promoCardItem.setShowedEventSent(true);
        }
        promoCardItemView.setTitle(promoCardItem.getTitle());
        promoCardItemView.setSubtitle(promoCardItem.getSubtitle());
        String image = promoCardItem.getImage();
        if (image != null) {
            int hashCode = image.hashCode();
            if (hashCode != -1019789636) {
                if (hashCode == 99467700 && image.equals("hotel")) {
                    num = Integer.valueOf(R.drawable.ic_hotel);
                    promoCardItemView.setImage(num);
                    promoCardItemView.setBackgroundColor(promoCardItem.getBackgroundColor(), promoCardItem.getHighlightedBackgroundColor());
                    promoCardItemView.setOnClickListener(new a(this, promoCardItem));
                    promoCardItemView.setButtonText(promoCardItem.getActionText());
                }
            } else if (image.equals("office")) {
                num = Integer.valueOf(R.drawable.ic_chat_bot);
                promoCardItemView.setImage(num);
                promoCardItemView.setBackgroundColor(promoCardItem.getBackgroundColor(), promoCardItem.getHighlightedBackgroundColor());
                promoCardItemView.setOnClickListener(new a(this, promoCardItem));
                promoCardItemView.setButtonText(promoCardItem.getActionText());
            }
        }
        num = null;
        promoCardItemView.setImage(num);
        promoCardItemView.setBackgroundColor(promoCardItem.getBackgroundColor(), promoCardItem.getHighlightedBackgroundColor());
        promoCardItemView.setOnClickListener(new a(this, promoCardItem));
        promoCardItemView.setButtonText(promoCardItem.getActionText());
    }
}
