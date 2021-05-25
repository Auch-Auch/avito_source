package com.avito.android.scroll_tracker;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.scroll_tracker.SnippetScrollDepthRecyclerViewScrollHandler;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u0012\u0006\u0010\u0010\u001a\u00020\r¢\u0006\u0004\b\u0015\u0010\u0016J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/avito/android/scroll_tracker/SnippetScrollDepthRecyclerViewScrollHandlerImpl;", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Lcom/avito/android/scroll_tracker/SnippetScrollDepthRecyclerViewScrollHandler;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "dx", "dy", "", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", "onInitialDataSourceSet", "()V", "Landroidx/recyclerview/widget/LinearLayoutManager;", AuthSource.BOOKING_ORDER, "Landroidx/recyclerview/widget/LinearLayoutManager;", "layoutManager", "Lcom/avito/android/scroll_tracker/SnippetScrollDepthRecyclerViewScrollHandler$Listener;", AuthSource.SEND_ABUSE, "Lcom/avito/android/scroll_tracker/SnippetScrollDepthRecyclerViewScrollHandler$Listener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "<init>", "(Lcom/avito/android/scroll_tracker/SnippetScrollDepthRecyclerViewScrollHandler$Listener;Landroidx/recyclerview/widget/LinearLayoutManager;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class SnippetScrollDepthRecyclerViewScrollHandlerImpl extends RecyclerView.OnScrollListener implements SnippetScrollDepthRecyclerViewScrollHandler {
    public final SnippetScrollDepthRecyclerViewScrollHandler.Listener a;
    public final LinearLayoutManager b;

    public SnippetScrollDepthRecyclerViewScrollHandlerImpl(@NotNull SnippetScrollDepthRecyclerViewScrollHandler.Listener listener, @NotNull LinearLayoutManager linearLayoutManager) {
        Intrinsics.checkNotNullParameter(listener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        Intrinsics.checkNotNullParameter(linearLayoutManager, "layoutManager");
        this.a = listener;
        this.b = linearLayoutManager;
    }

    @Override // com.avito.android.scroll_tracker.SnippetScrollDepthRecyclerViewScrollHandler
    public void onInitialDataSourceSet() {
        this.a.onVisibleItemChanged(this.b.findLastVisibleItemPosition());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrolled(@NotNull RecyclerView recyclerView, int i, int i2) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        this.a.onVisibleItemChanged(this.b.findLastVisibleItemPosition());
    }
}
