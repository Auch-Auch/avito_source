package com.avito.android.delivery.map.point_info.konveyor.attribute;

import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fJ'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/avito/android/delivery/map/point_info/konveyor/attribute/AttributeItemPresenterImpl;", "Lcom/avito/android/delivery/map/point_info/konveyor/attribute/AttributeItemPresenter;", "Lcom/avito/android/delivery/map/point_info/konveyor/attribute/AttributeItemView;", "view", "Lcom/avito/android/delivery/map/point_info/konveyor/attribute/AttributeItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/delivery/map/point_info/konveyor/attribute/AttributeItemView;Lcom/avito/android/delivery/map/point_info/konveyor/attribute/AttributeItem;I)V", "<init>", "()V", "delivery_release"}, k = 1, mv = {1, 4, 2})
public final class AttributeItemPresenterImpl implements AttributeItemPresenter {
    public void bindView(@NotNull AttributeItemView attributeItemView, @NotNull AttributeItem attributeItem, int i) {
        Intrinsics.checkNotNullParameter(attributeItemView, "view");
        Intrinsics.checkNotNullParameter(attributeItem, "item");
        attributeItemView.setTitle(attributeItem.getTitle());
        attributeItemView.setDescription(attributeItem.getDescription());
    }
}
