package ru.sravni.android.bankproduct.utils.filter.adapter;

import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.databinding.FilterPanelItemSravniBinding;
import ru.sravni.android.bankproduct.utils.filter.entity.FilterItem;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\t¢\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u000e\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lru/sravni/android/bankproduct/utils/filter/adapter/FilterPanelItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lru/sravni/android/bankproduct/utils/filter/entity/FilterItem;", "filterItem", "Lru/sravni/android/bankproduct/utils/filter/adapter/ISelectFilter;", "filterSelector", "", "bind", "(Lru/sravni/android/bankproduct/utils/filter/entity/FilterItem;Lru/sravni/android/bankproduct/utils/filter/adapter/ISelectFilter;)V", "Lru/sravni/android/bankproduct/databinding/FilterPanelItemSravniBinding;", "s", "Lru/sravni/android/bankproduct/databinding/FilterPanelItemSravniBinding;", "getBinding", "()Lru/sravni/android/bankproduct/databinding/FilterPanelItemSravniBinding;", "binding", "<init>", "(Lru/sravni/android/bankproduct/databinding/FilterPanelItemSravniBinding;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class FilterPanelItemViewHolder extends RecyclerView.ViewHolder {
    @NotNull
    public final FilterPanelItemSravniBinding s;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FilterPanelItemViewHolder(@NotNull FilterPanelItemSravniBinding filterPanelItemSravniBinding) {
        super(filterPanelItemSravniBinding.getRoot());
        Intrinsics.checkParameterIsNotNull(filterPanelItemSravniBinding, "binding");
        this.s = filterPanelItemSravniBinding;
    }

    public final void bind(@NotNull FilterItem filterItem, @NotNull ISelectFilter iSelectFilter) {
        Intrinsics.checkParameterIsNotNull(filterItem, "filterItem");
        Intrinsics.checkParameterIsNotNull(iSelectFilter, "filterSelector");
        this.s.setFilterItem(filterItem);
        this.s.setFilterSelector(iSelectFilter);
    }

    @NotNull
    public final FilterPanelItemSravniBinding getBinding() {
        return this.s;
    }
}
