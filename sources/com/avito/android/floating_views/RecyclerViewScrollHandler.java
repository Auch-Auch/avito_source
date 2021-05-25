package com.avito.android.floating_views;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.floating_views.ScrollHandler;
import com.avito.android.remote.auth.AuthSource;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u0016\u0010\u0017J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0015\u001a\u00020\u00058\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0018"}, d2 = {"Lcom/avito/android/floating_views/RecyclerViewScrollHandler;", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Lcom/avito/android/floating_views/ScrollHandler;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "dx", "dy", "", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", "Landroidx/recyclerview/widget/LinearLayoutManager;", "c", "Landroidx/recyclerview/widget/LinearLayoutManager;", "layoutManager", "Lcom/avito/android/floating_views/ScrollHandler$Listener;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/floating_views/ScrollHandler$Listener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, AuthSource.SEND_ABUSE, "I", "firstVisibleItem", "<init>", "(Lcom/avito/android/floating_views/ScrollHandler$Listener;Landroidx/recyclerview/widget/LinearLayoutManager;)V", "floating-views_release"}, k = 1, mv = {1, 4, 2})
public final class RecyclerViewScrollHandler extends RecyclerView.OnScrollListener implements ScrollHandler {
    public int a = -1;
    public final ScrollHandler.Listener b;
    public final LinearLayoutManager c;

    public RecyclerViewScrollHandler(@NotNull ScrollHandler.Listener listener, @NotNull LinearLayoutManager linearLayoutManager) {
        Intrinsics.checkNotNullParameter(listener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        Intrinsics.checkNotNullParameter(linearLayoutManager, "layoutManager");
        this.b = listener;
        this.c = linearLayoutManager;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrolled(@NotNull RecyclerView recyclerView, int i, int i2) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        if (i != 0 || i2 != 0) {
            int i3 = this.a;
            this.a = this.c.findFirstVisibleItemPosition();
            if (i3 != -1) {
                this.b.onVisibleItemChanged(this.a, i3, this.c.getChildCount(), this.c.getItemCount());
            }
        }
    }
}
