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
import ru.sravni.android.bankproduct.databinding.FilterSwitcherListItemSravniBinding;
import ru.sravni.android.bankproduct.utils.filter.entity.FilterSwitcherInfo;
import ru.sravni.android.bankproduct.utils.filter.viewmodel.IFilterSwitcherListViewModel;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001d\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u001a\u001a\u00020\u0017¢\u0006\u0004\b\u001b\u0010\u001cJ\u001b\u0010\u0007\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\r\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001d"}, d2 = {"Lru/sravni/android/bankproduct/utils/filter/adapter/FilterSwitcherAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lru/sravni/android/bankproduct/utils/filter/adapter/FilterSwitcherListItemViewHolder;", "", "Lru/sravni/android/bankproduct/utils/filter/entity/FilterSwitcherInfo;", "listSwitcher", "", "updateSwitcherListFilter", "(Ljava/util/List;)V", "Landroid/view/ViewGroup;", "parent", "", "viewType", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Lru/sravni/android/bankproduct/utils/filter/adapter/FilterSwitcherListItemViewHolder;", "getItemCount", "()I", "holder", VKApiConst.POSITION, "onBindViewHolder", "(Lru/sravni/android/bankproduct/utils/filter/adapter/FilterSwitcherListItemViewHolder;I)V", "c", "Ljava/util/List;", "Lru/sravni/android/bankproduct/utils/filter/viewmodel/IFilterSwitcherListViewModel;", "d", "Lru/sravni/android/bankproduct/utils/filter/viewmodel/IFilterSwitcherListViewModel;", "switcherChanged", "<init>", "(Ljava/util/List;Lru/sravni/android/bankproduct/utils/filter/viewmodel/IFilterSwitcherListViewModel;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class FilterSwitcherAdapter extends RecyclerView.Adapter<FilterSwitcherListItemViewHolder> {
    public List<FilterSwitcherInfo> c;
    public final IFilterSwitcherListViewModel d;

    public FilterSwitcherAdapter(@NotNull List<FilterSwitcherInfo> list, @NotNull IFilterSwitcherListViewModel iFilterSwitcherListViewModel) {
        Intrinsics.checkParameterIsNotNull(list, "listSwitcher");
        Intrinsics.checkParameterIsNotNull(iFilterSwitcherListViewModel, "switcherChanged");
        this.c = list;
        this.d = iFilterSwitcherListViewModel;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.c.size();
    }

    public final void updateSwitcherListFilter(@NotNull List<FilterSwitcherInfo> list) {
        Intrinsics.checkParameterIsNotNull(list, "listSwitcher");
        this.c = list;
        notifyDataSetChanged();
    }

    public void onBindViewHolder(@NotNull FilterSwitcherListItemViewHolder filterSwitcherListItemViewHolder, int i) {
        Intrinsics.checkParameterIsNotNull(filterSwitcherListItemViewHolder, "holder");
        filterSwitcherListItemViewHolder.getItemBinding().setSwitcherInfo(this.c.get(i));
        filterSwitcherListItemViewHolder.getItemBinding().setSwitcherChanged(this.d);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public FilterSwitcherListItemViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
        ViewDataBinding inflate = DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), R.layout.filter_switcher_list_item_sravni, viewGroup, false);
        Intrinsics.checkExpressionValueIsNotNull(inflate, "DataBindingUtil.inflate(…      false\n            )");
        return new FilterSwitcherListItemViewHolder((FilterSwitcherListItemSravniBinding) inflate);
    }
}
