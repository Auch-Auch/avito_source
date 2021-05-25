package com.avito.android.tariff.change.page;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.tariff.R;
import com.avito.android.tariff.change.ui.TariffChangePaddingDecoration;
import com.avito.android.ui.adapter.tab.TabsDataProvider;
import com.avito.android.util.Views;
import com.avito.conveyor_item.Item;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.SimpleAdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import com.avito.konveyor.data_source.ListDataSource;
import com.vk.sdk.api.VKApiConst;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001!B\u001d\u0012\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013\u0012\u0006\u0010\u001b\u001a\u00020\u0018¢\u0006\u0004\b\u001f\u0010 J\u001f\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0005¢\u0006\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001e\u001a\u00020\u00058\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d¨\u0006\""}, d2 = {"Lcom/avito/android/tariff/change/page/TariffPagerAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/avito/android/tariff/change/page/TariffPagerAdapter$ViewHolder;", "Landroid/view/ViewGroup;", "parent", "", "viewType", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Lcom/avito/android/tariff/change/page/TariffPagerAdapter$ViewHolder;", "getItemCount", "()I", "holder", VKApiConst.POSITION, "", "onBindViewHolder", "(Lcom/avito/android/tariff/change/page/TariffPagerAdapter$ViewHolder;I)V", "padding", "updateButtonOffset", "(I)V", "Lcom/avito/android/ui/adapter/tab/TabsDataProvider;", "Lcom/avito/android/tariff/change/page/TariffTab;", "d", "Lcom/avito/android/ui/adapter/tab/TabsDataProvider;", "tabs", "Lcom/avito/konveyor/ItemBinder;", "e", "Lcom/avito/konveyor/ItemBinder;", "itemBinder", "c", "I", "buttonOffset", "<init>", "(Lcom/avito/android/ui/adapter/tab/TabsDataProvider;Lcom/avito/konveyor/ItemBinder;)V", "ViewHolder", "tariff_release"}, k = 1, mv = {1, 4, 2})
public final class TariffPagerAdapter extends RecyclerView.Adapter<ViewHolder> {
    public int c;
    public final TabsDataProvider<TariffTab> d;
    public final ItemBinder e;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u001b\u001a\u00020\u0016\u0012\u0006\u0010\u0011\u001a\u00020\f¢\u0006\u0004\b\u001c\u0010\u001dJ\u001b\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0019\u0010\u0011\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0019\u0010\u001b\u001a\u00020\u00168\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001e"}, d2 = {"Lcom/avito/android/tariff/change/page/TariffPagerAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", "Lcom/avito/conveyor_item/Item;", "items", "", "setItems", "(Ljava/util/List;)V", "Lcom/avito/konveyor/adapter/SimpleAdapterPresenter;", "t", "Lcom/avito/konveyor/adapter/SimpleAdapterPresenter;", "adapterPresenter", "Lcom/avito/konveyor/ItemBinder;", VKApiConst.VERSION, "Lcom/avito/konveyor/ItemBinder;", "getItemBinder", "()Lcom/avito/konveyor/ItemBinder;", "itemBinder", "Landroidx/recyclerview/widget/RecyclerView;", "s", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Landroid/view/View;", "u", "Landroid/view/View;", "getView", "()Landroid/view/View;", "view", "<init>", "(Landroid/view/View;Lcom/avito/konveyor/ItemBinder;)V", "tariff_release"}, k = 1, mv = {1, 4, 2})
    public static final class ViewHolder extends RecyclerView.ViewHolder {
        public final RecyclerView s;
        public final SimpleAdapterPresenter t;
        @NotNull
        public final View u;
        @NotNull
        public final ItemBinder v;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ViewHolder(@NotNull View view, @NotNull ItemBinder itemBinder) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(itemBinder, "itemBinder");
            this.u = view;
            this.v = itemBinder;
            Objects.requireNonNull(view, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
            RecyclerView recyclerView = (RecyclerView) view;
            this.s = recyclerView;
            SimpleAdapterPresenter simpleAdapterPresenter = new SimpleAdapterPresenter(itemBinder, itemBinder);
            this.t = simpleAdapterPresenter;
            recyclerView.setAdapter(new SimpleRecyclerAdapter(simpleAdapterPresenter, itemBinder));
            recyclerView.addItemDecoration(new TariffChangePaddingDecoration());
        }

        @NotNull
        public final ItemBinder getItemBinder() {
            return this.v;
        }

        @NotNull
        public final View getView() {
            return this.u;
        }

        public final void setItems(@NotNull List<? extends Item> list) {
            Intrinsics.checkNotNullParameter(list, "items");
            this.t.onDataSourceChanged(new ListDataSource(list));
            RecyclerView.Adapter adapter = this.s.getAdapter();
            if (adapter != null) {
                adapter.notifyDataSetChanged();
            }
        }
    }

    public TariffPagerAdapter(@NotNull TabsDataProvider<TariffTab> tabsDataProvider, @NotNull ItemBinder itemBinder) {
        Intrinsics.checkNotNullParameter(tabsDataProvider, "tabs");
        Intrinsics.checkNotNullParameter(itemBinder, "itemBinder");
        this.d = tabsDataProvider;
        this.e = itemBinder;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.d.getCount();
    }

    public final void updateButtonOffset(int i) {
        this.c = i;
    }

    public void onBindViewHolder(@NotNull ViewHolder viewHolder, int i) {
        int i2;
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        viewHolder.setItems(this.d.getItem(i).getItems());
        if (this.d.getItem(i).getAction() == null) {
            i2 = 0;
        } else {
            i2 = this.c;
        }
        Views.changePadding$default(viewHolder.getView(), 0, 0, 0, i2, 7, null);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.tariff_change_page, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "view");
        return new ViewHolder(inflate, this.e);
    }
}
