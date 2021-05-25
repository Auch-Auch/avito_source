package ru.sravni.android.bankproduct.presentation.offer.osago.list.adapter;

import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.databinding.OfferOsagoListProlongationItemSravniBinding;
import ru.sravni.android.bankproduct.domain.offer.osago.entity.list.OfferOsagoItemDomain;
import ru.sravni.android.bankproduct.presentation.offer.osago.list.viewmodel.ISelectOfferOsago;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\f\u001a\u00020\t¢\u0006\u0004\b\r\u0010\u000eJ\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lru/sravni/android/bankproduct/presentation/offer/osago/list/adapter/OfferOsagoListViewProlongationItemHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lru/sravni/android/bankproduct/domain/offer/osago/entity/list/OfferOsagoItemDomain;", "osagoItem", "Lru/sravni/android/bankproduct/presentation/offer/osago/list/viewmodel/ISelectOfferOsago;", "selectOfferOsago", "", "bind", "(Lru/sravni/android/bankproduct/domain/offer/osago/entity/list/OfferOsagoItemDomain;Lru/sravni/android/bankproduct/presentation/offer/osago/list/viewmodel/ISelectOfferOsago;)V", "Lru/sravni/android/bankproduct/databinding/OfferOsagoListProlongationItemSravniBinding;", "s", "Lru/sravni/android/bankproduct/databinding/OfferOsagoListProlongationItemSravniBinding;", "itemBinding", "<init>", "(Lru/sravni/android/bankproduct/databinding/OfferOsagoListProlongationItemSravniBinding;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class OfferOsagoListViewProlongationItemHolder extends RecyclerView.ViewHolder {
    public final OfferOsagoListProlongationItemSravniBinding s;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OfferOsagoListViewProlongationItemHolder(@NotNull OfferOsagoListProlongationItemSravniBinding offerOsagoListProlongationItemSravniBinding) {
        super(offerOsagoListProlongationItemSravniBinding.getRoot());
        Intrinsics.checkParameterIsNotNull(offerOsagoListProlongationItemSravniBinding, "itemBinding");
        this.s = offerOsagoListProlongationItemSravniBinding;
    }

    public final void bind(@NotNull OfferOsagoItemDomain offerOsagoItemDomain, @NotNull ISelectOfferOsago iSelectOfferOsago) {
        Intrinsics.checkParameterIsNotNull(offerOsagoItemDomain, "osagoItem");
        Intrinsics.checkParameterIsNotNull(iSelectOfferOsago, "selectOfferOsago");
        this.s.setOsagoDetail(offerOsagoItemDomain.getOfferDomain());
        this.s.setSelectOfferOsago(iSelectOfferOsago);
    }
}
