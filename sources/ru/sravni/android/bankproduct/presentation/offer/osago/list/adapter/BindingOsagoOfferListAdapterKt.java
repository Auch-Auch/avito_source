package ru.sravni.android.bankproduct.presentation.offer.osago.list.adapter;

import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.domain.offer.osago.entity.list.OfferOsagoItemDomain;
import ru.sravni.android.bankproduct.presentation.offer.osago.list.viewmodel.ISelectOfferOsago;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a/\u0010\b\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00002\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Landroidx/recyclerview/widget/RecyclerView;", "view", "", "Lru/sravni/android/bankproduct/domain/offer/osago/entity/list/OfferOsagoItemDomain;", "listOsagoDetail", "Lru/sravni/android/bankproduct/presentation/offer/osago/list/viewmodel/ISelectOfferOsago;", "selectOfferOsago", "", "bindNewListToRecycler", "(Landroidx/recyclerview/widget/RecyclerView;Ljava/util/List;Lru/sravni/android/bankproduct/presentation/offer/osago/list/viewmodel/ISelectOfferOsago;)V", "sravnichat_release"}, k = 2, mv = {1, 4, 0})
public final class BindingOsagoOfferListAdapterKt {
    @BindingAdapter({"listOsagoDetail", "selectOfferOsago"})
    public static final void bindNewListToRecycler(@NotNull RecyclerView recyclerView, @Nullable List<OfferOsagoItemDomain> list, @NotNull ISelectOfferOsago iSelectOfferOsago) {
        Intrinsics.checkParameterIsNotNull(recyclerView, "view");
        Intrinsics.checkParameterIsNotNull(iSelectOfferOsago, "selectOfferOsago");
        if (list == null) {
            return;
        }
        if (recyclerView.getAdapter() == null) {
            recyclerView.setAdapter(new OfferOsagoListAdapter(list, iSelectOfferOsago));
            return;
        }
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        if (adapter != null) {
            ((OfferOsagoListAdapter) adapter).updateListOsagoDetail(list);
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type ru.sravni.android.bankproduct.presentation.offer.osago.list.adapter.OfferOsagoListAdapter");
    }
}
