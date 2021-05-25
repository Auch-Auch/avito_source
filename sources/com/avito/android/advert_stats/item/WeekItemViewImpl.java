package com.avito.android.advert_stats.item;

import android.content.res.Resources;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.advert_stats.item.WeekItemView;
import com.avito.android.advert_stats.recycler.BarDecoration;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import com.avito.konveyor.data_source.ListDataSource;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u001f\u0012\u0006\u0010\u0018\u001a\u00020\u0013\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\u0006\u0010\u000e\u001a\u00020\t¢\u0006\u0004\b\u001b\u0010\u001cJ\u001d\u0010\u0007\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u000e\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0018\u001a\u00020\u00138\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001d"}, d2 = {"Lcom/avito/android/advert_stats/item/WeekItemViewImpl;", "Lcom/avito/android/advert_stats/item/WeekItemView;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "", "Lcom/avito/android/advert_stats/item/BarItem;", "items", "", "setItems", "(Ljava/util/List;)V", "Lcom/avito/konveyor/ItemBinder;", "u", "Lcom/avito/konveyor/ItemBinder;", "getItemBinder", "()Lcom/avito/konveyor/ItemBinder;", "itemBinder", "Landroidx/recyclerview/widget/RecyclerView;", "s", "Landroidx/recyclerview/widget/RecyclerView;", "recycler", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "t", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "getAdapterPresenter", "()Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Landroid/view/View;", "view", "<init>", "(Lcom/avito/konveyor/adapter/AdapterPresenter;Landroid/view/View;Lcom/avito/konveyor/ItemBinder;)V", "advert-stats_release"}, k = 1, mv = {1, 4, 2})
public final class WeekItemViewImpl extends BaseViewHolder implements WeekItemView {
    public final RecyclerView s;
    @NotNull
    public final AdapterPresenter t;
    @NotNull
    public final ItemBinder u;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WeekItemViewImpl(@NotNull AdapterPresenter adapterPresenter, @NotNull View view, @NotNull ItemBinder itemBinder) {
        super(view);
        Intrinsics.checkNotNullParameter(adapterPresenter, "adapterPresenter");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(itemBinder, "itemBinder");
        this.t = adapterPresenter;
        this.u = itemBinder;
        RecyclerView recyclerView = (RecyclerView) view;
        this.s = recyclerView;
        Resources resources = view.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "view.resources");
        recyclerView.addItemDecoration(new BarDecoration(resources));
        recyclerView.setAdapter(new SimpleRecyclerAdapter(adapterPresenter, itemBinder));
    }

    @NotNull
    public final AdapterPresenter getAdapterPresenter() {
        return this.t;
    }

    @NotNull
    public final ItemBinder getItemBinder() {
        return this.u;
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        WeekItemView.DefaultImpls.onUnbind(this);
    }

    @Override // com.avito.android.advert_stats.item.WeekItemView
    public void setItems(@NotNull List<BarItem> list) {
        Intrinsics.checkNotNullParameter(list, "items");
        this.t.onDataSourceChanged(new ListDataSource(list));
        RecyclerView.Adapter adapter = this.s.getAdapter();
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
    }
}
