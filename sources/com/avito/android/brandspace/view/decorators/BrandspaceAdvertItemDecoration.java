package com.avito.android.brandspace.view.decorators;

import android.content.res.Resources;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.brandspace.R;
import com.avito.android.brandspace.presenter.BrandspaceResourcesProvider;
import com.avito.android.serp.adapter.RdsAdvertItemView;
import com.avito.android.util.DeviceMetrics;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B-\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/avito/android/brandspace/view/decorators/BrandspaceAdvertItemDecoration;", "Lcom/avito/android/brandspace/view/decorators/BrandspaceItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "", "shouldApply", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;)Z", "", "", "headersPositions", "Lcom/avito/android/brandspace/presenter/BrandspaceResourcesProvider;", "brandspaceResources", "Landroid/content/res/Resources;", "resources", "Lcom/avito/android/util/DeviceMetrics;", "deviceMetrics", "<init>", "(Ljava/util/List;Lcom/avito/android/brandspace/presenter/BrandspaceResourcesProvider;Landroid/content/res/Resources;Lcom/avito/android/util/DeviceMetrics;)V", "brandspace_release"}, k = 1, mv = {1, 4, 2})
public final class BrandspaceAdvertItemDecoration extends BrandspaceItemDecoration {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BrandspaceAdvertItemDecoration(@NotNull List<Integer> list, @NotNull BrandspaceResourcesProvider brandspaceResourcesProvider, @NotNull Resources resources, @NotNull DeviceMetrics deviceMetrics) {
        super(list, brandspaceResourcesProvider.getBrandspaceColumnCount() / brandspaceResourcesProvider.getAdvertSpan(), resources.getDimensionPixelSize(R.dimen.brandspace_advert_rowspacing) / 2, resources, deviceMetrics);
        Intrinsics.checkNotNullParameter(list, "headersPositions");
        Intrinsics.checkNotNullParameter(brandspaceResourcesProvider, "brandspaceResources");
        Intrinsics.checkNotNullParameter(resources, "resources");
        Intrinsics.checkNotNullParameter(deviceMetrics, "deviceMetrics");
    }

    @Override // com.avito.android.brandspace.view.decorators.BrandspaceItemDecoration
    public boolean shouldApply(@NotNull RecyclerView.ViewHolder viewHolder) {
        Intrinsics.checkNotNullParameter(viewHolder, "itemView");
        return viewHolder instanceof RdsAdvertItemView;
    }
}
