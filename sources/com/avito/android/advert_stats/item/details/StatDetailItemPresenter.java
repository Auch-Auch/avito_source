package com.avito.android.advert_stats.item.details;

import com.avito.android.image_loader.AvitoPictureKt;
import com.avito.konveyor.blueprint.ItemPresenter;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\t\b\u0007¢\u0006\u0004\b\u000b\u0010\fJ'\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/avito/android/advert_stats/item/details/StatDetailItemPresenter;", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lcom/avito/android/advert_stats/item/details/StatDetailItemView;", "Lcom/avito/android/advert_stats/item/details/StatDetailItem;", "view", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/advert_stats/item/details/StatDetailItemView;Lcom/avito/android/advert_stats/item/details/StatDetailItem;I)V", "<init>", "()V", "advert-stats_release"}, k = 1, mv = {1, 4, 2})
public final class StatDetailItemPresenter implements ItemPresenter<StatDetailItemView, StatDetailItem> {
    public void bindView(@NotNull StatDetailItemView statDetailItemView, @NotNull StatDetailItem statDetailItem, int i) {
        Intrinsics.checkNotNullParameter(statDetailItemView, "view");
        Intrinsics.checkNotNullParameter(statDetailItem, "item");
        statDetailItemView.setText(statDetailItem.getText());
        statDetailItemView.setStatusView(statDetailItem.isStatusItem());
        if (statDetailItem.getIcon() != null) {
            statDetailItemView.setPicture(AvitoPictureKt.pictureOf$default(statDetailItem.getIcon(), true, 0.0f, 0.0f, null, 28, null));
        } else if (statDetailItem.getDrawableId() != null) {
            statDetailItemView.setImageDrawable(statDetailItem.getDrawableId().intValue());
        } else {
            statDetailItemView.hidePicture();
        }
        statDetailItemView.setHidden(statDetailItem.isHidden(), (statDetailItem.getIcon() == null && statDetailItem.getDrawableId() == null) ? false : true);
    }
}
