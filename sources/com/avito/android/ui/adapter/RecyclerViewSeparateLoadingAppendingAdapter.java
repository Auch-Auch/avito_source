package com.avito.android.ui.adapter;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.avito.android.remote.auth.AuthSource;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00020\u00010\u00032\u00020\u0004:\u0001@B'\u0012\f\u00104\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0006\u00108\u001a\u000205\u0012\b\b\u0002\u0010=\u001a\u00020#¢\u0006\u0004\b>\u0010?J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000e\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001c\u0010\u001bJ\u000f\u0010\u001d\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001d\u0010\u0011J\u0017\u0010 \u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b \u0010!J\u0017\u0010$\u001a\u00020#2\u0006\u0010\"\u001a\u00020\u0001H\u0016¢\u0006\u0004\b$\u0010%J\u0017\u0010&\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b&\u0010!J\u0017\u0010'\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\u0001H\u0016¢\u0006\u0004\b'\u0010(J\u0017\u0010)\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\u0001H\u0016¢\u0006\u0004\b)\u0010(J\u0017\u0010*\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\u0001H\u0016¢\u0006\u0004\b*\u0010(J\u0017\u0010,\u001a\u00020\b2\u0006\u0010+\u001a\u00020#H\u0016¢\u0006\u0004\b,\u0010-R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u001c\u00104\u001a\b\u0012\u0004\u0012\u00028\u00000\u00038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u00108\u001a\u0002058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010<\u001a\u0002098\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b:\u0010;¨\u0006A"}, d2 = {"Lcom/avito/android/ui/adapter/RecyclerViewSeparateLoadingAppendingAdapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "T", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/avito/android/ui/adapter/AppendingAdapter;", "viewHolder", "", VKApiConst.POSITION, "", "onBindViewHolder", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;I)V", "Landroid/view/ViewGroup;", "viewGroup", "viewType", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "getItemCount", "()I", "getItemViewType", "(I)I", "", "getItemId", "(I)J", "loadingRange", "setLoadingRange", "(I)V", "setAppendingFromTop", "()V", "setAppendingFromBottom", "getCount", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "onAttachedToRecyclerView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "holder", "", "onFailedToRecycleView", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;)Z", "onDetachedFromRecyclerView", "onViewAttachedToWindow", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;)V", "onViewRecycled", "onViewDetachedFromWindow", "hasStableIds", "setHasStableIds", "(Z)V", "Lcom/avito/android/ui/adapter/DelegatingDataObserver;", "d", "Lcom/avito/android/ui/adapter/DelegatingDataObserver;", "dataObserver", "e", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "delegate", "Lcom/avito/android/ui/adapter/AppendingListener;", "f", "Lcom/avito/android/ui/adapter/AppendingListener;", "appendingListener", "Lcom/avito/android/ui/adapter/AppendingAdapterHandler;", "c", "Lcom/avito/android/ui/adapter/AppendingAdapterHandler;", "appendingHandler", "reversed", "<init>", "(Landroidx/recyclerview/widget/RecyclerView$Adapter;Lcom/avito/android/ui/adapter/AppendingListener;Z)V", AuthSource.SEND_ABUSE, "appending-list_release"}, k = 1, mv = {1, 4, 2})
public final class RecyclerViewSeparateLoadingAppendingAdapter<T extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements AppendingAdapter {
    public final AppendingAdapterHandler c;
    public final DelegatingDataObserver d;
    public final RecyclerView.Adapter<T> e;
    public final AppendingListener f;

    public static final class a extends RecyclerView.ViewHolder {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(@NotNull View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "itemView");
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RecyclerViewSeparateLoadingAppendingAdapter(RecyclerView.Adapter adapter, AppendingListener appendingListener, boolean z, int i, j jVar) {
        this(adapter, appendingListener, (i & 4) != 0 ? false : z);
    }

    @Override // com.avito.android.ui.adapter.AppendingAdapter
    public int getCount() {
        return getItemCount();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.f.canAppend()) {
            return this.e.getItemCount() + 1;
        }
        return this.e.getItemCount();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i) {
        if (this.c.isAppendingViewPosition(i)) {
            return (long) AppendingAdapterKt.getAPPENDING_POSITION_ID();
        }
        return this.e.getItemId(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        if (this.c.isAppendingViewPosition(i)) {
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
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        this.c.appendIfNeeded(i);
        if (!(viewHolder instanceof a)) {
            this.e.onBindViewHolder(viewHolder, i);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
        if (i == -1) {
            return new a(this.c.getAppendingView(viewGroup));
        }
        T onCreateViewHolder = this.e.onCreateViewHolder(viewGroup, i);
        Intrinsics.checkNotNullExpressionValue(onCreateViewHolder, "delegate.onCreateViewHolder(viewGroup, viewType)");
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
        if (viewHolder instanceof a) {
            return false;
        }
        return this.e.onFailedToRecycleView(viewHolder);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(@NotNull RecyclerView.ViewHolder viewHolder) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        super.onViewAttachedToWindow(viewHolder);
        if (!(viewHolder instanceof a)) {
            this.e.onViewAttachedToWindow(viewHolder);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewDetachedFromWindow(@NotNull RecyclerView.ViewHolder viewHolder) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        super.onViewDetachedFromWindow(viewHolder);
        if (!(viewHolder instanceof a)) {
            this.e.onViewDetachedFromWindow(viewHolder);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewRecycled(@NotNull RecyclerView.ViewHolder viewHolder) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        super.onViewRecycled(viewHolder);
        if (!(viewHolder instanceof a)) {
            this.e.onViewRecycled(viewHolder);
        }
    }

    @Override // com.avito.android.ui.adapter.AppendingAdapter
    public void setAppendingFromBottom() {
        this.c.setAppendingFromBottom();
    }

    @Override // com.avito.android.ui.adapter.AppendingAdapter
    public void setAppendingFromTop() {
        this.c.setAppendingFromTop();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void setHasStableIds(boolean z) {
        super.setHasStableIds(z);
        this.e.unregisterAdapterDataObserver(this.d);
        this.e.setHasStableIds(z);
    }

    @Override // com.avito.android.ui.adapter.AppendingAdapter
    public void setLoadingRange(int i) {
        this.c.setLoadingRange(i);
    }

    public RecyclerViewSeparateLoadingAppendingAdapter(@NotNull RecyclerView.Adapter<T> adapter, @NotNull AppendingListener appendingListener, boolean z) {
        Intrinsics.checkNotNullParameter(adapter, "delegate");
        Intrinsics.checkNotNullParameter(appendingListener, "appendingListener");
        this.e = adapter;
        this.f = appendingListener;
        this.c = new AppendingAdapterHandler(this, appendingListener, z, 0, 8, null);
        DelegatingDataObserver delegatingDataObserver = new DelegatingDataObserver(this);
        this.d = delegatingDataObserver;
        adapter.registerAdapterDataObserver(delegatingDataObserver);
    }
}
