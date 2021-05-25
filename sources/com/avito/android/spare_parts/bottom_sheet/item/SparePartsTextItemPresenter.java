package com.avito.android.spare_parts.bottom_sheet.item;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.spare_parts.SparePartsResourceProvider;
import com.avito.konveyor.blueprint.ItemPresenter;
import com.vk.sdk.api.VKApiConst;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0011\b\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u000f\u0010\u0010J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/avito/android/spare_parts/bottom_sheet/item/SparePartsTextItemPresenter;", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lcom/avito/android/spare_parts/bottom_sheet/item/SparePartsTextItemView;", "Lcom/avito/android/spare_parts/bottom_sheet/item/SparePartsTextItem;", "view", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/spare_parts/bottom_sheet/item/SparePartsTextItemView;Lcom/avito/android/spare_parts/bottom_sheet/item/SparePartsTextItem;I)V", "Lcom/avito/android/spare_parts/SparePartsResourceProvider;", AuthSource.SEND_ABUSE, "Lcom/avito/android/spare_parts/SparePartsResourceProvider;", "resourceProvider", "<init>", "(Lcom/avito/android/spare_parts/SparePartsResourceProvider;)V", "spare-parts_release"}, k = 1, mv = {1, 4, 2})
public final class SparePartsTextItemPresenter implements ItemPresenter<SparePartsTextItemView, SparePartsTextItem> {
    public final SparePartsResourceProvider a;

    @Inject
    public SparePartsTextItemPresenter(@NotNull SparePartsResourceProvider sparePartsResourceProvider) {
        Intrinsics.checkNotNullParameter(sparePartsResourceProvider, "resourceProvider");
        this.a = sparePartsResourceProvider;
    }

    public void bindView(@NotNull SparePartsTextItemView sparePartsTextItemView, @NotNull SparePartsTextItem sparePartsTextItem, int i) {
        Intrinsics.checkNotNullParameter(sparePartsTextItemView, "view");
        Intrinsics.checkNotNullParameter(sparePartsTextItem, "item");
        sparePartsTextItemView.setText(sparePartsTextItem.getText());
        if (sparePartsTextItem.getHasChildNodes()) {
            sparePartsTextItemView.setRightIconRes(this.a.getTextItemIconRightResId());
        } else {
            sparePartsTextItemView.hideIcon();
        }
    }
}
