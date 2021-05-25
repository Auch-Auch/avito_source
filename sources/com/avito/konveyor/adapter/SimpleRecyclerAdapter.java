package com.avito.konveyor.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.ListUpdateCallback;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.blueprint.ViewHolderBuilder;
import com.vk.sdk.api.VKApiConst;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u001d\u0012\u0006\u0010-\u001a\u00020*\u0012\f\u00101\u001a\b\u0012\u0004\u0012\u00020\u00020.¢\u0006\u0004\b2\u00103J\u001f\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\r\u0010\u000eJ-\u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00062\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0016¢\u0006\u0004\b\r\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u000b\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001a\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u001f\u0010\u001d\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u001f\u0010\u001f\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001f\u0010\u001eJ\u001f\u0010\"\u001a\u00020\f2\u0006\u0010 \u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\"\u0010\u001eJ)\u0010$\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u00062\b\u0010#\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b$\u0010%R\u0018\u0010)\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u001c\u00101\u001a\b\u0012\u0004\u0012\u00020\u00020.8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b/\u00100¨\u00064"}, d2 = {"Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Landroidx/recyclerview/widget/ListUpdateCallback;", "Landroid/view/ViewGroup;", "parent", "", "viewType", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Lcom/avito/konveyor/adapter/BaseViewHolder;", "holder", VKApiConst.POSITION, "", "onBindViewHolder", "(Lcom/avito/konveyor/adapter/BaseViewHolder;I)V", "", "", "payloads", "(Lcom/avito/konveyor/adapter/BaseViewHolder;ILjava/util/List;)V", "getItemCount", "()I", "getItemViewType", "(I)I", "", "getItemId", "(I)J", "onViewRecycled", "(Lcom/avito/konveyor/adapter/BaseViewHolder;)V", "count", "onInserted", "(II)V", "onRemoved", "fromPosition", "toPosition", "onMoved", "payload", "onChanged", "(IILjava/lang/Object;)V", "Landroid/view/LayoutInflater;", "c", "Landroid/view/LayoutInflater;", "layoutInflater", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "d", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "presenter", "Lcom/avito/konveyor/blueprint/ViewHolderBuilder;", "e", "Lcom/avito/konveyor/blueprint/ViewHolderBuilder;", "holderProvider", "<init>", "(Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/konveyor/blueprint/ViewHolderBuilder;)V", "konveyor_release"}, k = 1, mv = {1, 4, 2})
public class SimpleRecyclerAdapter extends RecyclerView.Adapter<BaseViewHolder> implements ListUpdateCallback {
    public LayoutInflater c;
    public final AdapterPresenter d;
    public final ViewHolderBuilder<BaseViewHolder> e;

    public static final class a extends Lambda implements Function1<Integer, View> {
        public final /* synthetic */ SimpleRecyclerAdapter a;
        public final /* synthetic */ ViewGroup b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(SimpleRecyclerAdapter simpleRecyclerAdapter, ViewGroup viewGroup) {
            super(1);
            this.a = simpleRecyclerAdapter;
            this.b = viewGroup;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public View invoke(Integer num) {
            return SimpleRecyclerAdapter.access$inflateView(this.a, num.intValue(), this.b);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.avito.konveyor.blueprint.ViewHolderBuilder<? extends com.avito.konveyor.adapter.BaseViewHolder> */
    /* JADX WARN: Multi-variable type inference failed */
    public SimpleRecyclerAdapter(@NotNull AdapterPresenter adapterPresenter, @NotNull ViewHolderBuilder<? extends BaseViewHolder> viewHolderBuilder) {
        Intrinsics.checkNotNullParameter(adapterPresenter, "presenter");
        Intrinsics.checkNotNullParameter(viewHolderBuilder, "holderProvider");
        this.d = adapterPresenter;
        this.e = viewHolderBuilder;
    }

    public static final View access$inflateView(SimpleRecyclerAdapter simpleRecyclerAdapter, int i, ViewGroup viewGroup) {
        View inflate;
        if (simpleRecyclerAdapter.c == null) {
            simpleRecyclerAdapter.c = LayoutInflater.from(viewGroup.getContext());
        }
        LayoutInflater layoutInflater = simpleRecyclerAdapter.c;
        if (layoutInflater != null && (inflate = layoutInflater.inflate(i, viewGroup, false)) != null) {
            return inflate;
        }
        throw new IllegalStateException();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.d.getCount();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i) {
        return this.d.getItemId(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        return this.d.getViewType(i);
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public void onChanged(int i, int i2, @Nullable Object obj) {
        notifyItemRangeChanged(i, i2, obj);
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public void onInserted(int i, int i2) {
        notifyItemRangeInserted(i, i2);
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public void onMoved(int i, int i2) {
        notifyItemMoved(i, i2);
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public void onRemoved(int i, int i2) {
        notifyItemRangeRemoved(i, i2);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [androidx.recyclerview.widget.RecyclerView$ViewHolder, int, java.util.List] */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(BaseViewHolder baseViewHolder, int i, List list) {
        onBindViewHolder(baseViewHolder, i, (List<Object>) list);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public BaseViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        BaseViewHolder buildViewHolder = this.e.buildViewHolder(viewGroup, i, new a(this, viewGroup));
        return buildViewHolder != null ? buildViewHolder : new EmptyViewHolder(viewGroup);
    }

    public void onViewRecycled(@NotNull BaseViewHolder baseViewHolder) {
        Intrinsics.checkNotNullParameter(baseViewHolder, "holder");
        baseViewHolder.onUnbind();
    }

    public void onBindViewHolder(@NotNull BaseViewHolder baseViewHolder, int i) {
        Intrinsics.checkNotNullParameter(baseViewHolder, "holder");
        AdapterPresenter.DefaultImpls.bindView$default(this.d, baseViewHolder, i, null, 4, null);
    }

    public void onBindViewHolder(@NotNull BaseViewHolder baseViewHolder, int i, @NotNull List<Object> list) {
        Intrinsics.checkNotNullParameter(baseViewHolder, "holder");
        Intrinsics.checkNotNullParameter(list, "payloads");
        this.d.bindView(baseViewHolder, i, list);
    }
}
