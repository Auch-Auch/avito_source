package com.avito.android.publish_limits_info.item;

import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.OnDeepLinkClickListener;
import com.avito.android.publish_limits_info.analytics.PublishLimitsEventTracker;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.text.AttributedText;
import com.jakewharton.rxrelay2.PublishRelay;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u001b\u0010\u001cJ'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR:\u0010\u0014\u001a&\u0012\f\u0012\n \u0011*\u0004\u0018\u00010\u00100\u0010 \u0011*\u0012\u0012\f\u0012\n \u0011*\u0004\u0018\u00010\u00100\u0010\u0018\u00010\u000f0\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\"\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00100\u00158\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001d"}, d2 = {"Lcom/avito/android/publish_limits_info/item/LimitsInfoItemPresenterImpl;", "Lcom/avito/android/publish_limits_info/item/LimitsInfoItemPresenter;", "Lcom/avito/android/publish_limits_info/item/LimitsInfoItemView;", "view", "Lcom/avito/android/publish_limits_info/item/LimitsInfoItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/publish_limits_info/item/LimitsInfoItemView;Lcom/avito/android/publish_limits_info/item/LimitsInfoItem;I)V", "Lcom/avito/android/publish_limits_info/analytics/PublishLimitsEventTracker;", "c", "Lcom/avito/android/publish_limits_info/analytics/PublishLimitsEventTracker;", "limitsEventTracker", "Lcom/jakewharton/rxrelay2/PublishRelay;", "Lcom/avito/android/deep_linking/links/DeepLink;", "kotlin.jvm.PlatformType", AuthSource.SEND_ABUSE, "Lcom/jakewharton/rxrelay2/PublishRelay;", "deepLinkClickRelay", "Lio/reactivex/Observable;", AuthSource.BOOKING_ORDER, "Lio/reactivex/Observable;", "getDeeplinkClicks", "()Lio/reactivex/Observable;", "deeplinkClicks", "<init>", "(Lcom/avito/android/publish_limits_info/analytics/PublishLimitsEventTracker;)V", "publish-limits-info_release"}, k = 1, mv = {1, 4, 2})
public final class LimitsInfoItemPresenterImpl implements LimitsInfoItemPresenter {
    public final PublishRelay<DeepLink> a;
    @NotNull
    public final Observable<DeepLink> b;
    public final PublishLimitsEventTracker c;

    public static final class a implements OnDeepLinkClickListener {
        public final /* synthetic */ LimitsInfoItemPresenterImpl a;
        public final /* synthetic */ LimitsInfoItem b;

        public a(LimitsInfoItemPresenterImpl limitsInfoItemPresenterImpl, LimitsInfoItem limitsInfoItem) {
            this.a = limitsInfoItemPresenterImpl;
            this.b = limitsInfoItem;
        }

        @Override // com.avito.android.deep_linking.links.OnDeepLinkClickListener
        public final void onDeepLinkClick(@NotNull DeepLink deepLink) {
            Intrinsics.checkNotNullParameter(deepLink, "deepLink");
            this.a.c.trackLimitsInfoExtraClicked(this.b.getItemId(), this.b.getInfo());
            this.a.a.accept(deepLink);
        }
    }

    @Inject
    public LimitsInfoItemPresenterImpl(@NotNull PublishLimitsEventTracker publishLimitsEventTracker) {
        Intrinsics.checkNotNullParameter(publishLimitsEventTracker, "limitsEventTracker");
        this.c = publishLimitsEventTracker;
        PublishRelay<DeepLink> create = PublishRelay.create();
        this.a = create;
        Observable<DeepLink> hide = create.hide();
        Intrinsics.checkNotNullExpressionValue(hide, "deepLinkClickRelay.hide()");
        this.b = hide;
    }

    @Override // com.avito.android.deep_linking.DeeplinkClickStreamProvider
    @NotNull
    public Observable<DeepLink> getDeeplinkClicks() {
        return this.b;
    }

    public void bindView(@NotNull LimitsInfoItemView limitsInfoItemView, @NotNull LimitsInfoItem limitsInfoItem, int i) {
        Intrinsics.checkNotNullParameter(limitsInfoItemView, "view");
        Intrinsics.checkNotNullParameter(limitsInfoItem, "item");
        AttributedText extraInfo = limitsInfoItem.getInfo().getExtraInfo();
        if (extraInfo != null) {
            extraInfo.setOnDeepLinkClickListener(new a(this, limitsInfoItem));
        }
        limitsInfoItemView.setLimitsInfo(limitsInfoItem.getInfo(), limitsInfoItem.getShowTitle());
    }
}
