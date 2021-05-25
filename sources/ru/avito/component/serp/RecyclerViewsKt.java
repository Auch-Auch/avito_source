package ru.avito.component.serp;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\t\u001a\u001b\u0010\u0003\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001b\u0010\u0006\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0006\u0010\u0004\u001a\u001b\u0010\u0007\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0007\u0010\u0004\u001a\u0013\u0010\b\u001a\u00020\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Landroidx/recyclerview/widget/RecyclerView;", "", "viewType", "findLastVisiblePositionWithViewType", "(Landroidx/recyclerview/widget/RecyclerView;I)I", VKApiConst.POSITION, "getViewTypeSafe", "nextViewType", "getLastVisiblePositionViewType", "(Landroidx/recyclerview/widget/RecyclerView;)I", "ui-components_release"}, k = 2, mv = {1, 4, 2})
public final class RecyclerViewsKt {
    public static final int findLastVisiblePositionWithViewType(@NotNull RecyclerView recyclerView, int i) {
        Intrinsics.checkNotNullParameter(recyclerView, "$this$findLastVisiblePositionWithViewType");
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (!(layoutManager instanceof LinearLayoutManager)) {
            layoutManager = null;
        }
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
        if (linearLayoutManager == null) {
            return -1;
        }
        int findLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
        int viewTypeSafe = getViewTypeSafe(recyclerView, findLastVisibleItemPosition);
        while (findLastVisibleItemPosition > -1 && viewTypeSafe != i) {
            findLastVisibleItemPosition--;
            viewTypeSafe = getViewTypeSafe(recyclerView, findLastVisibleItemPosition);
        }
        return findLastVisibleItemPosition;
    }

    public static final int getLastVisiblePositionViewType(@NotNull RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "$this$getLastVisiblePositionViewType");
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (!(layoutManager instanceof LinearLayoutManager)) {
            layoutManager = null;
        }
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
        if (linearLayoutManager != null) {
            return getViewTypeSafe(recyclerView, linearLayoutManager.findLastVisibleItemPosition());
        }
        return -1;
    }

    public static final int getViewTypeSafe(@NotNull RecyclerView recyclerView, int i) {
        Intrinsics.checkNotNullParameter(recyclerView, "$this$getViewTypeSafe");
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        if (adapter == null) {
            return -1;
        }
        Intrinsics.checkNotNullExpressionValue(adapter, "adapter ?: return RecyclerView.INVALID_TYPE");
        if (i != -1) {
            return adapter.getItemViewType(i);
        }
        return -1;
    }

    public static final int nextViewType(@NotNull RecyclerView recyclerView, int i) {
        Intrinsics.checkNotNullParameter(recyclerView, "$this$nextViewType");
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        if (adapter == null) {
            return -1;
        }
        Intrinsics.checkNotNullExpressionValue(adapter, "adapter ?: return RecyclerView.INVALID_TYPE");
        if (i == adapter.getItemCount() - 1) {
            return -1;
        }
        return adapter.getItemViewType(i + 1);
    }
}
