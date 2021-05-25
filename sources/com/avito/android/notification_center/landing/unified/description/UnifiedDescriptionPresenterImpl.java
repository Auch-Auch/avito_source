package com.avito.android.notification_center.landing.unified.description;

import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u000b\u0010\fJ'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/avito/android/notification_center/landing/unified/description/UnifiedDescriptionPresenterImpl;", "Lcom/avito/android/notification_center/landing/unified/description/UnifiedDescriptionPresenter;", "Lcom/avito/android/notification_center/landing/unified/description/UnifiedDescriptionView;", "view", "Lcom/avito/android/notification_center/landing/unified/description/UnifiedDescriptionItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/notification_center/landing/unified/description/UnifiedDescriptionView;Lcom/avito/android/notification_center/landing/unified/description/UnifiedDescriptionItem;I)V", "<init>", "()V", "notification-center_release"}, k = 1, mv = {1, 4, 2})
public final class UnifiedDescriptionPresenterImpl implements UnifiedDescriptionPresenter {
    public void bindView(@NotNull UnifiedDescriptionView unifiedDescriptionView, @NotNull UnifiedDescriptionItem unifiedDescriptionItem, int i) {
        Intrinsics.checkNotNullParameter(unifiedDescriptionView, "view");
        Intrinsics.checkNotNullParameter(unifiedDescriptionItem, "item");
        unifiedDescriptionView.setDescription(unifiedDescriptionItem.getDescription());
    }
}
