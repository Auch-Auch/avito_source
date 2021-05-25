package com.avito.android.ui.adapter;

import a2.g.r.g;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.serp.EventsAwareAdapter;
import com.avito.android.ui_components.R;
import com.vk.sdk.api.VKApiConst;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003:\u0001>B\u001d\u0012\f\u00103\u001a\b\u0012\u0004\u0012\u00028\u000000\u0012\u0006\u00107\u001a\u000204¢\u0006\u0004\b<\u0010=J-\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000b\u0010\rJ\u001f\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0004\u001a\u00020\u0001H\u0016¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010!\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b!\u0010\u001dJ\u0017\u0010\"\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u0001H\u0016¢\u0006\u0004\b\"\u0010#J\u0017\u0010$\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u0001H\u0016¢\u0006\u0004\b$\u0010#J\u0017\u0010%\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u0001H\u0016¢\u0006\u0004\b%\u0010#J\u0017\u0010'\u001a\u00020\n2\u0006\u0010&\u001a\u00020\u001eH\u0016¢\u0006\u0004\b'\u0010(J\u000f\u0010*\u001a\u00020)H\u0016¢\u0006\u0004\b*\u0010+R\u0018\u0010/\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\u001c\u00103\u001a\b\u0012\u0004\u0012\u00028\u0000008\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u0016\u00107\u001a\u0002048\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b5\u00106R\u0016\u0010;\u001a\u0002088\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b9\u0010:¨\u0006?"}, d2 = {"Lcom/avito/android/ui/adapter/GridLayoutAppendingAdapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "T", "Lcom/avito/android/serp/EventsAwareAdapter;", "holder", "", VKApiConst.POSITION, "", "", "payloads", "", "onBindViewHolder", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;ILjava/util/List;)V", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;I)V", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "getItemViewType", "(I)I", "", "getItemId", "(I)J", "getItemCount", "()I", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "onAttachedToRecyclerView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "", "onFailedToRecycleView", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;)Z", "onDetachedFromRecyclerView", "onViewAttachedToWindow", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;)V", "onViewRecycled", "onViewDetachedFromWindow", "hasStableIds", "setHasStableIds", "(Z)V", "", "toString", "()Ljava/lang/String;", "Landroid/view/View;", "f", "Landroid/view/View;", "appendingView", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", g.a, "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "delegate", "Lcom/avito/android/ui/adapter/AppendingHandler;", "h", "Lcom/avito/android/ui/adapter/AppendingHandler;", "adapterHandler", "Lcom/avito/android/ui/adapter/DelegatingDataObserver;", "e", "Lcom/avito/android/ui/adapter/DelegatingDataObserver;", "dataObserver", "<init>", "(Landroidx/recyclerview/widget/RecyclerView$Adapter;Lcom/avito/android/ui/adapter/AppendingHandler;)V", AuthSource.SEND_ABUSE, "appending-list_release"}, k = 1, mv = {1, 4, 2})
public final class GridLayoutAppendingAdapter<T extends RecyclerView.ViewHolder> extends EventsAwareAdapter {
    public final DelegatingDataObserver e;
    public View f;
    public final RecyclerView.Adapter<T> g;
    public final AppendingHandler h;

    public static final class a extends RecyclerView.ViewHolder {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(@NotNull View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "itemView");
        }
    }

    public GridLayoutAppendingAdapter(@NotNull RecyclerView.Adapter<T> adapter, @NotNull AppendingHandler appendingHandler) {
        Intrinsics.checkNotNullParameter(adapter, "delegate");
        Intrinsics.checkNotNullParameter(appendingHandler, "adapterHandler");
        this.g = adapter;
        this.h = appendingHandler;
        DelegatingDataObserver delegatingDataObserver = new DelegatingDataObserver(this);
        this.e = delegatingDataObserver;
        adapter.registerAdapterDataObserver(delegatingDataObserver);
        appendingHandler.setAdapterDelegate(adapter);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.h.getCount();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i) {
        if (this.h.isAppendingViewPosition(i)) {
            return Long.MIN_VALUE;
        }
        return this.g.getItemId(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        if (this.h.isAppendingViewPosition(i)) {
            return -1;
        }
        return this.g.getItemViewType(i);
    }

    @Override // com.avito.android.serp.EventsAwareAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(@NotNull RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onAttachedToRecyclerView(recyclerView);
        this.g.onAttachedToRecyclerView(recyclerView);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder viewHolder, int i, @NotNull List<Object> list) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        Intrinsics.checkNotNullParameter(list, "payloads");
        this.h.appendIfNeeded(i);
        if (!(viewHolder instanceof a)) {
            this.g.onBindViewHolder(viewHolder, i, list);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        if (i == -1) {
            View view = this.f;
            if (view == null || view.getParent() != null) {
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pending_view, viewGroup, false);
                this.f = view;
                Intrinsics.checkNotNullExpressionValue(view, "LayoutInflater.from(pare…View = this\n            }");
            }
            return new a(view);
        }
        T onCreateViewHolder = this.g.onCreateViewHolder(viewGroup, i);
        Intrinsics.checkNotNullExpressionValue(onCreateViewHolder, "delegate.onCreateViewHolder(parent, viewType)");
        return onCreateViewHolder;
    }

    @Override // com.avito.android.serp.EventsAwareAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(@NotNull RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onDetachedFromRecyclerView(recyclerView);
        this.g.onDetachedFromRecyclerView(recyclerView);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public boolean onFailedToRecycleView(@NotNull RecyclerView.ViewHolder viewHolder) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        if (viewHolder instanceof a) {
            return false;
        }
        return this.g.onFailedToRecycleView(viewHolder);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(@NotNull RecyclerView.ViewHolder viewHolder) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        super.onViewAttachedToWindow(viewHolder);
        if (!(viewHolder instanceof a)) {
            this.g.onViewAttachedToWindow(viewHolder);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewDetachedFromWindow(@NotNull RecyclerView.ViewHolder viewHolder) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        super.onViewDetachedFromWindow(viewHolder);
        if (!(viewHolder instanceof a)) {
            this.g.onViewDetachedFromWindow(viewHolder);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewRecycled(@NotNull RecyclerView.ViewHolder viewHolder) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        super.onViewRecycled(viewHolder);
        if (!(viewHolder instanceof a)) {
            this.g.onViewRecycled(viewHolder);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void setHasStableIds(boolean z) {
        super.setHasStableIds(z);
        this.g.unregisterAdapterDataObserver(this.e);
        this.g.setHasStableIds(z);
    }

    @Override // com.avito.android.serp.EventsAwareAdapter
    @NotNull
    public String toString() {
        return super.toString() + ", with explicit append:" + (this.h instanceof GridLayoutNoLoaderAppendingHandler);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder viewHolder, int i) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        this.h.appendIfNeeded(i);
        if (!(viewHolder instanceof a)) {
            this.g.onBindViewHolder(viewHolder, i);
        }
    }
}
