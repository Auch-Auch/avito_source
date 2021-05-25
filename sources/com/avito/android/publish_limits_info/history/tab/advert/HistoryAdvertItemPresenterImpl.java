package com.avito.android.publish_limits_info.history.tab.advert;

import com.avito.android.image_loader.AvitoPictureKt;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u000b\u0010\fJ'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/avito/android/publish_limits_info/history/tab/advert/HistoryAdvertItemPresenterImpl;", "Lcom/avito/android/publish_limits_info/history/tab/advert/HistoryAdvertItemPresenter;", "Lcom/avito/android/publish_limits_info/history/tab/advert/HistoryAdvertItemView;", "view", "Lcom/avito/android/publish_limits_info/history/tab/advert/HistoryAdvertItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/publish_limits_info/history/tab/advert/HistoryAdvertItemView;Lcom/avito/android/publish_limits_info/history/tab/advert/HistoryAdvertItem;I)V", "<init>", "()V", "publish-limits-info_release"}, k = 1, mv = {1, 4, 2})
public final class HistoryAdvertItemPresenterImpl implements HistoryAdvertItemPresenter {
    public void bindView(@NotNull HistoryAdvertItemView historyAdvertItemView, @NotNull HistoryAdvertItem historyAdvertItem, int i) {
        Intrinsics.checkNotNullParameter(historyAdvertItemView, "view");
        Intrinsics.checkNotNullParameter(historyAdvertItem, "item");
        historyAdvertItemView.setImage(AvitoPictureKt.pictureOf$default(historyAdvertItem.getImage(), false, 0.0f, 0.0f, null, 28, null));
        historyAdvertItemView.setTitle(historyAdvertItem.getTitle());
        historyAdvertItemView.setPrice(historyAdvertItem.getPrice());
        historyAdvertItemView.setHint(historyAdvertItem.getHint());
        Boolean isAutoPublish = historyAdvertItem.isAutoPublish();
        historyAdvertItemView.setAutoPublish(isAutoPublish != null ? isAutoPublish.booleanValue() : false);
    }
}
