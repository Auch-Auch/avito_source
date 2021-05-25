package ru.sravni.android.bankproduct.utils.filter.adapter;

import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.databinding.FilterListInfoItemSravniBinding;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lru/sravni/android/bankproduct/utils/filter/adapter/FilterInfoViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lru/sravni/android/bankproduct/databinding/FilterListInfoItemSravniBinding;", "s", "Lru/sravni/android/bankproduct/databinding/FilterListInfoItemSravniBinding;", "getBinding", "()Lru/sravni/android/bankproduct/databinding/FilterListInfoItemSravniBinding;", "binding", "<init>", "(Lru/sravni/android/bankproduct/databinding/FilterListInfoItemSravniBinding;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class FilterInfoViewHolder extends RecyclerView.ViewHolder {
    @NotNull
    public final FilterListInfoItemSravniBinding s;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FilterInfoViewHolder(@NotNull FilterListInfoItemSravniBinding filterListInfoItemSravniBinding) {
        super(filterListInfoItemSravniBinding.getRoot());
        Intrinsics.checkParameterIsNotNull(filterListInfoItemSravniBinding, "binding");
        this.s = filterListInfoItemSravniBinding;
    }

    @NotNull
    public final FilterListInfoItemSravniBinding getBinding() {
        return this.s;
    }
}
