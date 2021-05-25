package com.avito.android.advert.item.features_teaser.items;

import com.avito.android.advert_core.analytics.AdvertDetailsAnalyticsInteractor;
import com.avito.android.advert_core.feature_teasers.common.AdvertDetailsFeatureTeaserItem;
import com.avito.android.advert_core.feature_teasers.common.CommonFeatureTeaserPresenter;
import com.avito.android.advert_core.feature_teasers.common.FeatureTeaserResourceProvider;
import com.avito.android.advert_core.feature_teasers.common.FeatureTeaserView;
import com.avito.android.advert_core.feature_teasers.common.dialog.AdvertDetailsFeatureTeaserDialogInfo;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.di.module.AdvertId;
import com.avito.android.remote.auth.AuthSource;
import com.avito.konveyor.blueprint.ItemPresenter;
import com.vk.sdk.api.VKApiConst;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002B#\b\u0007\u0012\b\b\u0001\u0010\u0016\u001a\u00020\u0013\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0019\u0010\u001aJ'\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\r\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\r\u0010\u000eR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u001b"}, d2 = {"Lcom/avito/android/advert/item/features_teaser/items/AdvertDetailsFeatureTeaserPresenter;", "Lcom/avito/android/advert_core/feature_teasers/common/CommonFeatureTeaserPresenter;", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lcom/avito/android/advert/item/features_teaser/items/AdvertDetailsFeatureTeaserView;", "Lcom/avito/android/advert_core/feature_teasers/common/AdvertDetailsFeatureTeaserItem;", "view", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/advert/item/features_teaser/items/AdvertDetailsFeatureTeaserView;Lcom/avito/android/advert_core/feature_teasers/common/AdvertDetailsFeatureTeaserItem;I)V", "Lcom/avito/android/advert_core/feature_teasers/common/FeatureTeaserView;", "onAction", "(Lcom/avito/android/advert_core/feature_teasers/common/FeatureTeaserView;Lcom/avito/android/advert_core/feature_teasers/common/AdvertDetailsFeatureTeaserItem;)V", "Lcom/avito/android/advert_core/analytics/AdvertDetailsAnalyticsInteractor;", "c", "Lcom/avito/android/advert_core/analytics/AdvertDetailsAnalyticsInteractor;", "analytics", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", BookingInfoActivity.EXTRA_ITEM_ID, "Lcom/avito/android/advert_core/feature_teasers/common/FeatureTeaserResourceProvider;", "resourceProvider", "<init>", "(Ljava/lang/String;Lcom/avito/android/advert_core/analytics/AdvertDetailsAnalyticsInteractor;Lcom/avito/android/advert_core/feature_teasers/common/FeatureTeaserResourceProvider;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertDetailsFeatureTeaserPresenter extends CommonFeatureTeaserPresenter implements ItemPresenter<AdvertDetailsFeatureTeaserView, AdvertDetailsFeatureTeaserItem> {
    public final String b;
    public final AdvertDetailsAnalyticsInteractor c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @Inject
    public AdvertDetailsFeatureTeaserPresenter(@AdvertId @NotNull String str, @NotNull AdvertDetailsAnalyticsInteractor advertDetailsAnalyticsInteractor, @NotNull FeatureTeaserResourceProvider featureTeaserResourceProvider) {
        super(featureTeaserResourceProvider);
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        Intrinsics.checkNotNullParameter(advertDetailsAnalyticsInteractor, "analytics");
        Intrinsics.checkNotNullParameter(featureTeaserResourceProvider, "resourceProvider");
        this.b = str;
        this.c = advertDetailsAnalyticsInteractor;
    }

    @Override // com.avito.android.advert_core.feature_teasers.common.CommonFeatureTeaserPresenter, com.avito.android.advert_core.feature_teasers.common.FeatureTeaserPresenter
    public void onAction(@NotNull FeatureTeaserView featureTeaserView, @NotNull AdvertDetailsFeatureTeaserItem advertDetailsFeatureTeaserItem) {
        Intrinsics.checkNotNullParameter(featureTeaserView, "view");
        Intrinsics.checkNotNullParameter(advertDetailsFeatureTeaserItem, "item");
        super.onAction(featureTeaserView, advertDetailsFeatureTeaserItem);
        AdvertDetailsFeatureTeaserDialogInfo dialogInfo = advertDetailsFeatureTeaserItem.getDialogInfo();
        if (dialogInfo == null) {
            return;
        }
        if (dialogInfo instanceof AdvertDetailsFeatureTeaserDialogInfo.CheckedByAvito) {
            this.c.sendClickAdditionalInfoFromCheckedByAvito(this.b);
        } else if ((dialogInfo instanceof AdvertDetailsFeatureTeaserDialogInfo.FeaturesList) && Intrinsics.areEqual(advertDetailsFeatureTeaserItem.getFeatureSlug(), AdvertDetailsFeatureTeaserPresenterKt.COMFORT_BLOCK_SLUG)) {
            this.c.sendClickAdditionalInfoFromApartmentFeature(this.b);
        }
    }

    public void bindView(@NotNull AdvertDetailsFeatureTeaserView advertDetailsFeatureTeaserView, @NotNull AdvertDetailsFeatureTeaserItem advertDetailsFeatureTeaserItem, int i) {
        Intrinsics.checkNotNullParameter(advertDetailsFeatureTeaserView, "view");
        Intrinsics.checkNotNullParameter(advertDetailsFeatureTeaserItem, "item");
        super.bindView(advertDetailsFeatureTeaserView, advertDetailsFeatureTeaserItem);
    }
}
