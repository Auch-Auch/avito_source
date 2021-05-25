package com.avito.android.brandspace.view.decorators;

import a2.b.a.a.a;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.brandspace.R;
import com.avito.android.brandspace.items.marketplace.snippet.MarketplaceSnippetItemView;
import com.avito.android.brandspace.presenter.BrandspaceResourcesProvider;
import com.avito.android.util.DeviceMetrics;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B-\u0012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J/\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u001d"}, d2 = {"Lcom/avito/android/brandspace/view/decorators/BrandspaceMarketplaceSinppetItemDecoration;", "Lcom/avito/android/brandspace/view/decorators/BrandspaceItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "", "shouldApply", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;)Z", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", "parent", "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "(Landroid/graphics/Rect;Landroid/view/View;Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/RecyclerView$State;)V", "", "", "headersPositions", "Lcom/avito/android/brandspace/presenter/BrandspaceResourcesProvider;", "brandspaceResources", "Landroid/content/res/Resources;", "resources", "Lcom/avito/android/util/DeviceMetrics;", "deviceMetrics", "<init>", "(Ljava/util/List;Lcom/avito/android/brandspace/presenter/BrandspaceResourcesProvider;Landroid/content/res/Resources;Lcom/avito/android/util/DeviceMetrics;)V", "brandspace_release"}, k = 1, mv = {1, 4, 2})
public final class BrandspaceMarketplaceSinppetItemDecoration extends BrandspaceItemDecoration {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BrandspaceMarketplaceSinppetItemDecoration(@NotNull List<Integer> list, @NotNull BrandspaceResourcesProvider brandspaceResourcesProvider, @NotNull Resources resources, @NotNull DeviceMetrics deviceMetrics) {
        super(list, brandspaceResourcesProvider.getBrandspaceColumnCount() / brandspaceResourcesProvider.getAdvertSpan(), resources.getDimensionPixelSize(R.dimen.brandspace_advert_rowspacing) / 2, resources, deviceMetrics);
        Intrinsics.checkNotNullParameter(list, "headersPositions");
        Intrinsics.checkNotNullParameter(brandspaceResourcesProvider, "brandspaceResources");
        Intrinsics.checkNotNullParameter(resources, "resources");
        Intrinsics.checkNotNullParameter(deviceMetrics, "deviceMetrics");
    }

    @Override // com.avito.android.brandspace.view.decorators.BrandspaceItemDecoration, androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(@NotNull Rect rect, @NotNull View view, @NotNull RecyclerView recyclerView, @NotNull RecyclerView.State state) {
        a.F0(rect, "outRect", view, "view", recyclerView, "parent", state, "state");
        super.getItemOffsets(rect, view, recyclerView, state);
        rect.top = 0;
        rect.bottom *= 2;
    }

    @Override // com.avito.android.brandspace.view.decorators.BrandspaceItemDecoration
    public boolean shouldApply(@NotNull RecyclerView.ViewHolder viewHolder) {
        Intrinsics.checkNotNullParameter(viewHolder, "itemView");
        return viewHolder instanceof MarketplaceSnippetItemView;
    }
}
