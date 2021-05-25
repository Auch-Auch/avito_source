package com.avito.konveyor.adapter;

import a2.g.r.g;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.blueprint.Item;
import com.avito.konveyor.blueprint.ViewHolderBuilder;
import com.vk.sdk.api.VKApiConst;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 72\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u00017B-\u0012\u0006\u0010.\u001a\u00020+\u0012\f\u00102\u001a\b\u0012\u0004\u0012\u00020\u00030/\u0012\u000e\b\u0002\u00104\u001a\b\u0012\u0004\u0012\u00020\u000203¢\u0006\u0004\b5\u00106J\u001f\u0010\b\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\r\u0010\u000eJ-\u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00062\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0016¢\u0006\u0004\b\r\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u000b\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001a\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u001f\u0010\u001e\u001a\u00020\f2\u000e\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001cH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ)\u0010\u001e\u001a\u00020\f2\u000e\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001c2\b\u0010!\u001a\u0004\u0018\u00010 H\u0016¢\u0006\u0004\b\u001e\u0010\"J+\u0010%\u001a\u00020\f2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00020\u000f2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00020\u000fH\u0016¢\u0006\u0004\b%\u0010&R\u0018\u0010*\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u001c\u00102\u001a\b\u0012\u0004\u0012\u00020\u00030/8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b0\u00101¨\u00068"}, d2 = {"Lcom/avito/konveyor/adapter/ListRecyclerAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/avito/konveyor/blueprint/Item;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Landroid/view/ViewGroup;", "parent", "", "viewType", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Lcom/avito/konveyor/adapter/BaseViewHolder;", "holder", VKApiConst.POSITION, "", "onBindViewHolder", "(Lcom/avito/konveyor/adapter/BaseViewHolder;I)V", "", "", "payloads", "(Lcom/avito/konveyor/adapter/BaseViewHolder;ILjava/util/List;)V", "getItemCount", "()I", "getItemViewType", "(I)I", "", "getItemId", "(I)J", "onViewRecycled", "(Lcom/avito/konveyor/adapter/BaseViewHolder;)V", "", "list", "submitList", "(Ljava/util/List;)V", "Ljava/lang/Runnable;", "commitCallback", "(Ljava/util/List;Ljava/lang/Runnable;)V", "previousList", "currentList", "onCurrentListChanged", "(Ljava/util/List;Ljava/util/List;)V", "Landroid/view/LayoutInflater;", "e", "Landroid/view/LayoutInflater;", "layoutInflater", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "f", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "presenter", "Lcom/avito/konveyor/blueprint/ViewHolderBuilder;", g.a, "Lcom/avito/konveyor/blueprint/ViewHolderBuilder;", "holderProvider", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "callback", "<init>", "(Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/konveyor/blueprint/ViewHolderBuilder;Landroidx/recyclerview/widget/DiffUtil$ItemCallback;)V", "Companion", "konveyor_release"}, k = 1, mv = {1, 4, 2})
public final class ListRecyclerAdapter extends ListAdapter<Item, BaseViewHolder> {
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final ListRecyclerAdapter$Companion$CALLBACK$1 h = new ListRecyclerAdapter$Companion$CALLBACK$1();
    public LayoutInflater e;
    public final AdapterPresenter f;
    public final ViewHolderBuilder<BaseViewHolder> g;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006*\u0001\u0002\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/avito/konveyor/adapter/ListRecyclerAdapter$Companion;", "", "com/avito/konveyor/adapter/ListRecyclerAdapter$Companion$CALLBACK$1", "CALLBACK", "Lcom/avito/konveyor/adapter/ListRecyclerAdapter$Companion$CALLBACK$1;", "<init>", "()V", "konveyor_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    public static final class a extends Lambda implements Function1<Integer, View> {
        public final /* synthetic */ ListRecyclerAdapter a;
        public final /* synthetic */ ViewGroup b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(ListRecyclerAdapter listRecyclerAdapter, ViewGroup viewGroup) {
            super(1);
            this.a = listRecyclerAdapter;
            this.b = viewGroup;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public View invoke(Integer num) {
            return ListRecyclerAdapter.access$inflateView(this.a, num.intValue(), this.b);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ListRecyclerAdapter(AdapterPresenter adapterPresenter, ViewHolderBuilder viewHolderBuilder, DiffUtil.ItemCallback itemCallback, int i, j jVar) {
        this(adapterPresenter, viewHolderBuilder, (i & 4) != 0 ? h : itemCallback);
    }

    public static final View access$inflateView(ListRecyclerAdapter listRecyclerAdapter, int i, ViewGroup viewGroup) {
        View inflate;
        if (listRecyclerAdapter.e == null) {
            listRecyclerAdapter.e = LayoutInflater.from(viewGroup.getContext());
        }
        LayoutInflater layoutInflater = listRecyclerAdapter.e;
        if (layoutInflater != null && (inflate = layoutInflater.inflate(i, viewGroup, false)) != null) {
            return inflate;
        }
        throw new IllegalStateException();
    }

    @Override // androidx.recyclerview.widget.ListAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f.getCount();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i) {
        return this.f.getItemId(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        return this.f.getViewType(i);
    }

    @Override // androidx.recyclerview.widget.ListAdapter
    public void onCurrentListChanged(@NotNull List<Item> list, @NotNull List<Item> list2) {
        Intrinsics.checkNotNullParameter(list, "previousList");
        Intrinsics.checkNotNullParameter(list2, "currentList");
        super.onCurrentListChanged(list, list2);
        a2.b.a.a.a.s1(list2, this.f);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.util.List<? extends com.avito.konveyor.blueprint.Item>] */
    @Override // androidx.recyclerview.widget.ListAdapter
    public void submitList(@Nullable List<Item> list) {
        submitList(list, null);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.avito.konveyor.blueprint.ViewHolderBuilder<? extends com.avito.konveyor.adapter.BaseViewHolder> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ListRecyclerAdapter(@NotNull AdapterPresenter adapterPresenter, @NotNull ViewHolderBuilder<? extends BaseViewHolder> viewHolderBuilder, @NotNull DiffUtil.ItemCallback<Item> itemCallback) {
        super(itemCallback);
        Intrinsics.checkNotNullParameter(adapterPresenter, "presenter");
        Intrinsics.checkNotNullParameter(viewHolderBuilder, "holderProvider");
        Intrinsics.checkNotNullParameter(itemCallback, "callback");
        this.f = adapterPresenter;
        this.g = viewHolderBuilder;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i, List list) {
        onBindViewHolder((BaseViewHolder) viewHolder, i, (List<Object>) list);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public BaseViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        BaseViewHolder buildViewHolder = this.g.buildViewHolder(viewGroup, i, new a(this, viewGroup));
        return buildViewHolder != null ? buildViewHolder : new EmptyViewHolder(viewGroup);
    }

    public void onViewRecycled(@NotNull BaseViewHolder baseViewHolder) {
        Intrinsics.checkNotNullParameter(baseViewHolder, "holder");
        super.onViewRecycled((ListRecyclerAdapter) baseViewHolder);
        baseViewHolder.onUnbind();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.util.List<? extends com.avito.konveyor.blueprint.Item>, java.lang.Runnable] */
    @Override // androidx.recyclerview.widget.ListAdapter
    public void submitList(@Nullable List<Item> list, @Nullable Runnable runnable) {
        super.submitList(list != null ? CollectionsKt___CollectionsKt.toList(list) : null, runnable);
    }

    public void onBindViewHolder(@NotNull BaseViewHolder baseViewHolder, int i) {
        Intrinsics.checkNotNullParameter(baseViewHolder, "holder");
        AdapterPresenter.DefaultImpls.bindView$default(this.f, baseViewHolder, i, null, 4, null);
    }

    public void onBindViewHolder(@NotNull BaseViewHolder baseViewHolder, int i, @NotNull List<Object> list) {
        Intrinsics.checkNotNullParameter(baseViewHolder, "holder");
        Intrinsics.checkNotNullParameter(list, "payloads");
        this.f.bindView(baseViewHolder, i, list);
    }
}
