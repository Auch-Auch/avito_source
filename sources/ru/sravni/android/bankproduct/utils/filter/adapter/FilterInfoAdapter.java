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
import ru.sravni.android.bankproduct.databinding.FilterListInfoItemSravniBinding;
import ru.sravni.android.bankproduct.utils.filter.entity.FilterInfo;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0018\u0010\bJ\u001b\u0010\u0007\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\r\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lru/sravni/android/bankproduct/utils/filter/adapter/FilterInfoAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lru/sravni/android/bankproduct/utils/filter/adapter/FilterInfoViewHolder;", "", "Lru/sravni/android/bankproduct/utils/filter/entity/FilterInfo;", "listFilter", "", "updateListInfoFilter", "(Ljava/util/List;)V", "Landroid/view/ViewGroup;", "parent", "", "viewType", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Lru/sravni/android/bankproduct/utils/filter/adapter/FilterInfoViewHolder;", "getItemCount", "()I", "holder", VKApiConst.POSITION, "onBindViewHolder", "(Lru/sravni/android/bankproduct/utils/filter/adapter/FilterInfoViewHolder;I)V", "c", "Ljava/util/List;", "listInfo", "<init>", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class FilterInfoAdapter extends RecyclerView.Adapter<FilterInfoViewHolder> {
    public List<FilterInfo> c;

    public FilterInfoAdapter(@NotNull List<FilterInfo> list) {
        Intrinsics.checkParameterIsNotNull(list, "listInfo");
        this.c = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.c.size();
    }

    public final void updateListInfoFilter(@NotNull List<FilterInfo> list) {
        Intrinsics.checkParameterIsNotNull(list, "listFilter");
        this.c = list;
        notifyDataSetChanged();
    }

    public void onBindViewHolder(@NotNull FilterInfoViewHolder filterInfoViewHolder, int i) {
        Intrinsics.checkParameterIsNotNull(filterInfoViewHolder, "holder");
        filterInfoViewHolder.getBinding().setFilterInfo(this.c.get(i));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public FilterInfoViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
        ViewDataBinding inflate = DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), R.layout.filter_list_info_item_sravni, viewGroup, false);
        Intrinsics.checkExpressionValueIsNotNull(inflate, "DataBindingUtil.inflate(…      false\n            )");
        return new FilterInfoViewHolder((FilterListInfoItemSravniBinding) inflate);
    }
}
