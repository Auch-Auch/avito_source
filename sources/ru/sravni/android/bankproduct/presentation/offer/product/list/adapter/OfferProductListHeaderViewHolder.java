package ru.sravni.android.bankproduct.presentation.offer.product.list.adapter;

import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.databinding.OfferProductListHeaderSravniBinding;
import ru.sravni.android.bankproduct.domain.offer.product.entity.OfferProductItemDomain;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lru/sravni/android/bankproduct/presentation/offer/product/list/adapter/OfferProductListHeaderViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lru/sravni/android/bankproduct/domain/offer/product/entity/OfferProductItemDomain;", "offerProductItem", "", "bind", "(Lru/sravni/android/bankproduct/domain/offer/product/entity/OfferProductItemDomain;)V", "Lru/sravni/android/bankproduct/databinding/OfferProductListHeaderSravniBinding;", "s", "Lru/sravni/android/bankproduct/databinding/OfferProductListHeaderSravniBinding;", "itemBinding", "<init>", "(Lru/sravni/android/bankproduct/databinding/OfferProductListHeaderSravniBinding;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class OfferProductListHeaderViewHolder extends RecyclerView.ViewHolder {
    public final OfferProductListHeaderSravniBinding s;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OfferProductListHeaderViewHolder(@NotNull OfferProductListHeaderSravniBinding offerProductListHeaderSravniBinding) {
        super(offerProductListHeaderSravniBinding.getRoot());
        Intrinsics.checkParameterIsNotNull(offerProductListHeaderSravniBinding, "itemBinding");
        this.s = offerProductListHeaderSravniBinding;
    }

    public final void bind(@NotNull OfferProductItemDomain offerProductItemDomain) {
        Intrinsics.checkParameterIsNotNull(offerProductItemDomain, "offerProductItem");
        this.s.setTitleGroup(offerProductItemDomain.getTitleGroup());
        this.s.setDescription(offerProductItemDomain.getDescription());
    }
}
