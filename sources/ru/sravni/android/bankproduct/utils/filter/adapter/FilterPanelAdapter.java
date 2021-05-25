package ru.sravni.android.bankproduct.utils.filter.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.vk.sdk.api.VKApiConst;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.R;
import ru.sravni.android.bankproduct.databinding.FilterPanelItemSravniBinding;
import ru.sravni.android.bankproduct.utils.filter.entity.FilterItem;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001d\u0012\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010\u0012\u0006\u0010\u0018\u001a\u00020\u0015¢\u0006\u0004\b\u001c\u0010\u001dJ\u001f\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u001b\u0010\u0013\u001a\u00020\r2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001c\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001e"}, d2 = {"Lru/sravni/android/bankproduct/utils/filter/adapter/FilterPanelAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lru/sravni/android/bankproduct/utils/filter/adapter/FilterPanelItemViewHolder;", "Landroid/view/ViewGroup;", "parent", "", "viewType", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Lru/sravni/android/bankproduct/utils/filter/adapter/FilterPanelItemViewHolder;", "getItemCount", "()I", "holder", VKApiConst.POSITION, "", "onBindViewHolder", "(Lru/sravni/android/bankproduct/utils/filter/adapter/FilterPanelItemViewHolder;I)V", "", "Lru/sravni/android/bankproduct/utils/filter/entity/FilterItem;", "listFilter", "updateListFilter", "(Ljava/util/List;)V", "Lru/sravni/android/bankproduct/utils/filter/adapter/ISelectFilter;", "d", "Lru/sravni/android/bankproduct/utils/filter/adapter/ISelectFilter;", "filterSelector", "c", "Ljava/util/List;", "filterList", "<init>", "(Ljava/util/List;Lru/sravni/android/bankproduct/utils/filter/adapter/ISelectFilter;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class FilterPanelAdapter extends RecyclerView.Adapter<FilterPanelItemViewHolder> {
    public List<? extends FilterItem> c;
    public final ISelectFilter d;

    public FilterPanelAdapter(@NotNull List<? extends FilterItem> list, @NotNull ISelectFilter iSelectFilter) {
        Intrinsics.checkParameterIsNotNull(list, "filterList");
        Intrinsics.checkParameterIsNotNull(iSelectFilter, "filterSelector");
        this.c = list;
        this.d = iSelectFilter;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.c.size();
    }

    public final void updateListFilter(@NotNull List<? extends FilterItem> list) {
        Intrinsics.checkParameterIsNotNull(list, "listFilter");
        this.c = list;
        notifyDataSetChanged();
    }

    public void onBindViewHolder(@NotNull FilterPanelItemViewHolder filterPanelItemViewHolder, int i) {
        Intrinsics.checkParameterIsNotNull(filterPanelItemViewHolder, "holder");
        filterPanelItemViewHolder.bind((FilterItem) this.c.get(i), this.d);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public FilterPanelItemViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
        ViewDataBinding inflate = DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), R.layout.filter_panel_item_sravni, viewGroup, false);
        Intrinsics.checkExpressionValueIsNotNull(inflate, "DataBindingUtil.inflate(…      false\n            )");
        return new FilterPanelItemViewHolder((FilterPanelItemSravniBinding) inflate);
    }
}
