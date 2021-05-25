package com.avito.android.search.map.view.adapter;

import a2.g.r.g;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.avito.android.search.map.R;
import com.avito.android.ui.adapter.DelegatingDataObserver;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00020\u00010\u0003B%\u0012\f\u00107\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0006\u0010,\u001a\u00020)\u0012\u0006\u00104\u001a\u000201¢\u0006\u0004\b8\u00109J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\r\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0004\u001a\u00020\u0001H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u001d\u0010\u0019J\u0017\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0001H\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010 \u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0001H\u0016¢\u0006\u0004\b \u0010\u001fJ\u0017\u0010!\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0001H\u0016¢\u0006\u0004\b!\u0010\u001fJ\u0017\u0010#\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u001aH\u0016¢\u0006\u0004\b#\u0010$R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0018\u00100\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b2\u00103R\u001c\u00107\u001a\b\u0012\u0004\u0012\u00028\u00000\u00038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b5\u00106¨\u0006:"}, d2 = {"Lcom/avito/android/search/map/view/adapter/GridAppendingRetryAdapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "T", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "holder", "", VKApiConst.POSITION, "", "onBindViewHolder", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;I)V", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "getItemViewType", "(I)I", "", "getItemId", "(I)J", "getItemCount", "()I", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "onAttachedToRecyclerView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "", "onFailedToRecycleView", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;)Z", "onDetachedFromRecyclerView", "onViewAttachedToWindow", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;)V", "onViewRecycled", "onViewDetachedFromWindow", "hasStableIds", "setHasStableIds", "(Z)V", "Lcom/avito/android/ui/adapter/DelegatingDataObserver;", "c", "Lcom/avito/android/ui/adapter/DelegatingDataObserver;", "dataObserver", "Lcom/avito/android/search/map/view/adapter/GridAppendingRetryHandler;", "f", "Lcom/avito/android/search/map/view/adapter/GridAppendingRetryHandler;", "adapterHandler", "Landroid/view/View;", "d", "Landroid/view/View;", "appendingView", "Lcom/avito/android/search/map/view/adapter/AppendingRetryListener;", g.a, "Lcom/avito/android/search/map/view/adapter/AppendingRetryListener;", "appendingRetryListener", "e", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "delegate", "<init>", "(Landroidx/recyclerview/widget/RecyclerView$Adapter;Lcom/avito/android/search/map/view/adapter/GridAppendingRetryHandler;Lcom/avito/android/search/map/view/adapter/AppendingRetryListener;)V", "map_release"}, k = 1, mv = {1, 4, 2})
public final class GridAppendingRetryAdapter<T extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public final DelegatingDataObserver c;
    public View d;
    public final RecyclerView.Adapter<T> e;
    public final GridAppendingRetryHandler f;
    public final AppendingRetryListener g;

    public GridAppendingRetryAdapter(@NotNull RecyclerView.Adapter<T> adapter, @NotNull GridAppendingRetryHandler gridAppendingRetryHandler, @NotNull AppendingRetryListener appendingRetryListener) {
        Intrinsics.checkNotNullParameter(adapter, "delegate");
        Intrinsics.checkNotNullParameter(gridAppendingRetryHandler, "adapterHandler");
        Intrinsics.checkNotNullParameter(appendingRetryListener, "appendingRetryListener");
        this.e = adapter;
        this.f = gridAppendingRetryHandler;
        this.g = appendingRetryListener;
        DelegatingDataObserver delegatingDataObserver = new DelegatingDataObserver(this);
        this.c = delegatingDataObserver;
        adapter.registerAdapterDataObserver(delegatingDataObserver);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f.getCount(this.e.getItemCount());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i) {
        if (this.f.isAppendingViewPosition(i, this.e.getItemCount())) {
            return Long.MIN_VALUE;
        }
        return this.e.getItemId(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        if (this.f.isAppendingViewPosition(i, this.e.getItemCount())) {
            return -1;
        }
        return this.e.getItemViewType(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(@NotNull RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onAttachedToRecyclerView(recyclerView);
        this.e.onAttachedToRecyclerView(recyclerView);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder viewHolder, int i) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        this.f.appendIfNeeded(i);
        if (viewHolder instanceof AppendingRetryViewHolder) {
            ((AppendingRetryViewHolder) viewHolder).bindItem(this.g.getAppendingState());
        } else {
            this.e.onBindViewHolder(viewHolder, i);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        if (i == -1) {
            View view = this.d;
            if (view == null || view.getParent() != null) {
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.appending_loading_retry, viewGroup, false);
                this.d = view;
                Intrinsics.checkNotNullExpressionValue(view, "LayoutInflater.from(pare…View = this\n            }");
            }
            return new AppendingRetryViewHolder(view, this.g);
        }
        T onCreateViewHolder = this.e.onCreateViewHolder(viewGroup, i);
        Intrinsics.checkNotNullExpressionValue(onCreateViewHolder, "delegate.onCreateViewHolder(parent, viewType)");
        return onCreateViewHolder;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(@NotNull RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onDetachedFromRecyclerView(recyclerView);
        this.e.onDetachedFromRecyclerView(recyclerView);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public boolean onFailedToRecycleView(@NotNull RecyclerView.ViewHolder viewHolder) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        if (viewHolder instanceof AppendingRetryViewHolder) {
            return false;
        }
        return this.e.onFailedToRecycleView(viewHolder);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(@NotNull RecyclerView.ViewHolder viewHolder) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        super.onViewAttachedToWindow(viewHolder);
        if (!(viewHolder instanceof AppendingRetryViewHolder)) {
            this.e.onViewAttachedToWindow(viewHolder);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewDetachedFromWindow(@NotNull RecyclerView.ViewHolder viewHolder) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        super.onViewDetachedFromWindow(viewHolder);
        if (!(viewHolder instanceof AppendingRetryViewHolder)) {
            this.e.onViewDetachedFromWindow(viewHolder);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewRecycled(@NotNull RecyclerView.ViewHolder viewHolder) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        super.onViewRecycled(viewHolder);
        if (!(viewHolder instanceof AppendingRetryViewHolder)) {
            this.e.onViewRecycled(viewHolder);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void setHasStableIds(boolean z) {
        super.setHasStableIds(z);
        this.e.unregisterAdapterDataObserver(this.c);
        this.e.setHasStableIds(z);
    }
}
