package ru.sravni.android.bankproduct.utils.filter.adapter;

import android.widget.CompoundButton;
import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.switchmaterial.SwitchMaterial;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.utils.filter.entity.FilterInfo;
import ru.sravni.android.bankproduct.utils.filter.entity.FilterItem;
import ru.sravni.android.bankproduct.utils.filter.entity.FilterSwitcherInfo;
import ru.sravni.android.bankproduct.utils.filter.viewmodel.IFilterSwitcherListViewModel;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a/\u0010\b\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00002\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\b\u0010\t\u001a'\u0010\f\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00002\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0002H\u0007¢\u0006\u0004\b\f\u0010\r\u001a/\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00002\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u00022\u0006\u0010\u0011\u001a\u00020\u0010H\u0007¢\u0006\u0004\b\u0012\u0010\u0013\u001a'\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0007¢\u0006\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Landroidx/recyclerview/widget/RecyclerView;", "view", "", "Lru/sravni/android/bankproduct/utils/filter/entity/FilterItem;", "listFilterItem", "Lru/sravni/android/bankproduct/utils/filter/adapter/ISelectFilter;", "filterSelector", "", "bindListFilterItemToRecycler", "(Landroidx/recyclerview/widget/RecyclerView;Ljava/util/List;Lru/sravni/android/bankproduct/utils/filter/adapter/ISelectFilter;)V", "Lru/sravni/android/bankproduct/utils/filter/entity/FilterInfo;", "listInfo", "bindListInfoToRecycler", "(Landroidx/recyclerview/widget/RecyclerView;Ljava/util/List;)V", "Lru/sravni/android/bankproduct/utils/filter/entity/FilterSwitcherInfo;", "switcherList", "Lru/sravni/android/bankproduct/utils/filter/viewmodel/IFilterSwitcherListViewModel;", "switcherChanged", "bindListSwitcherToRecycler", "(Landroidx/recyclerview/widget/RecyclerView;Ljava/util/List;Lru/sravni/android/bankproduct/utils/filter/viewmodel/IFilterSwitcherListViewModel;)V", "Lcom/google/android/material/switchmaterial/SwitchMaterial;", "switcherInfo", "bindCheckedToSwitch", "(Lcom/google/android/material/switchmaterial/SwitchMaterial;Lru/sravni/android/bankproduct/utils/filter/entity/FilterSwitcherInfo;Lru/sravni/android/bankproduct/utils/filter/viewmodel/IFilterSwitcherListViewModel;)V", "sravnichat_release"}, k = 2, mv = {1, 4, 0})
public final class BindingFilterAdapterKt {

    public static final class a implements CompoundButton.OnCheckedChangeListener {
        public final /* synthetic */ IFilterSwitcherListViewModel a;
        public final /* synthetic */ FilterSwitcherInfo b;

        public a(IFilterSwitcherListViewModel iFilterSwitcherListViewModel, FilterSwitcherInfo filterSwitcherInfo) {
            this.a = iFilterSwitcherListViewModel;
            this.b = filterSwitcherInfo;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            this.a.onSwitcherChanged(this.b, z);
        }
    }

    @BindingAdapter({"switcherInfo", "switcherChanged"})
    public static final void bindCheckedToSwitch(@NotNull SwitchMaterial switchMaterial, @NotNull FilterSwitcherInfo filterSwitcherInfo, @NotNull IFilterSwitcherListViewModel iFilterSwitcherListViewModel) {
        Intrinsics.checkParameterIsNotNull(switchMaterial, "view");
        Intrinsics.checkParameterIsNotNull(filterSwitcherInfo, "switcherInfo");
        Intrinsics.checkParameterIsNotNull(iFilterSwitcherListViewModel, "switcherChanged");
        switchMaterial.setOnCheckedChangeListener(null);
        switchMaterial.setChecked(filterSwitcherInfo.getActive());
        switchMaterial.setOnCheckedChangeListener(new a(iFilterSwitcherListViewModel, filterSwitcherInfo));
    }

    @BindingAdapter({"listFilterItem", "filterSelector"})
    public static final void bindListFilterItemToRecycler(@NotNull RecyclerView recyclerView, @Nullable List<? extends FilterItem> list, @NotNull ISelectFilter iSelectFilter) {
        Intrinsics.checkParameterIsNotNull(recyclerView, "view");
        Intrinsics.checkParameterIsNotNull(iSelectFilter, "filterSelector");
        if (list == null) {
            return;
        }
        if (recyclerView.getAdapter() == null) {
            recyclerView.setAdapter(new FilterPanelAdapter(list, iSelectFilter));
            return;
        }
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        if (adapter != null) {
            ((FilterPanelAdapter) adapter).updateListFilter(list);
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type ru.sravni.android.bankproduct.utils.filter.adapter.FilterPanelAdapter");
    }

    @BindingAdapter({"listInfo"})
    public static final void bindListInfoToRecycler(@NotNull RecyclerView recyclerView, @Nullable List<FilterInfo> list) {
        Intrinsics.checkParameterIsNotNull(recyclerView, "view");
        if (list == null) {
            return;
        }
        if (recyclerView.getAdapter() == null) {
            recyclerView.setAdapter(new FilterInfoAdapter(list));
            return;
        }
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        if (adapter != null) {
            ((FilterInfoAdapter) adapter).updateListInfoFilter(list);
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type ru.sravni.android.bankproduct.utils.filter.adapter.FilterInfoAdapter");
    }

    @BindingAdapter({"switcherList", "switcherChanged"})
    public static final void bindListSwitcherToRecycler(@NotNull RecyclerView recyclerView, @Nullable List<FilterSwitcherInfo> list, @NotNull IFilterSwitcherListViewModel iFilterSwitcherListViewModel) {
        Intrinsics.checkParameterIsNotNull(recyclerView, "view");
        Intrinsics.checkParameterIsNotNull(iFilterSwitcherListViewModel, "switcherChanged");
        if (list == null) {
            return;
        }
        if (recyclerView.getAdapter() == null) {
            recyclerView.setAdapter(new FilterSwitcherAdapter(list, iFilterSwitcherListViewModel));
            return;
        }
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        if (adapter != null) {
            ((FilterSwitcherAdapter) adapter).updateSwitcherListFilter(list);
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type ru.sravni.android.bankproduct.utils.filter.adapter.FilterSwitcherAdapter");
    }
}
