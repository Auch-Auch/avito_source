package ru.sravni.android.bankproduct.presentation.offer.product.info.adapter;

import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.databinding.OfferProductInfoHeaderItemSravniBinding;
import ru.sravni.android.bankproduct.domain.offer.product.entity.detail.OfferProductDetailItemDomain;
import ru.sravni.android.bankproduct.utils.svg.entity.LogoInfo;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\f\u001a\u00020\t¢\u0006\u0004\b\r\u0010\u000eJ\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lru/sravni/android/bankproduct/presentation/offer/product/info/adapter/OfferProductInfoHeaderViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lru/sravni/android/bankproduct/domain/offer/product/entity/detail/OfferProductDetailItemDomain;", "offerDetailDomain", "Lru/sravni/android/bankproduct/utils/svg/entity/LogoInfo;", "logoInfo", "", "bind", "(Lru/sravni/android/bankproduct/domain/offer/product/entity/detail/OfferProductDetailItemDomain;Lru/sravni/android/bankproduct/utils/svg/entity/LogoInfo;)V", "Lru/sravni/android/bankproduct/databinding/OfferProductInfoHeaderItemSravniBinding;", "s", "Lru/sravni/android/bankproduct/databinding/OfferProductInfoHeaderItemSravniBinding;", "itemBinding", "<init>", "(Lru/sravni/android/bankproduct/databinding/OfferProductInfoHeaderItemSravniBinding;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class OfferProductInfoHeaderViewHolder extends RecyclerView.ViewHolder {
    public final OfferProductInfoHeaderItemSravniBinding s;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OfferProductInfoHeaderViewHolder(@NotNull OfferProductInfoHeaderItemSravniBinding offerProductInfoHeaderItemSravniBinding) {
        super(offerProductInfoHeaderItemSravniBinding.getRoot());
        Intrinsics.checkParameterIsNotNull(offerProductInfoHeaderItemSravniBinding, "itemBinding");
        this.s = offerProductInfoHeaderItemSravniBinding;
    }

    public final void bind(@NotNull OfferProductDetailItemDomain offerProductDetailItemDomain, @NotNull LogoInfo logoInfo) {
        Intrinsics.checkParameterIsNotNull(offerProductDetailItemDomain, "offerDetailDomain");
        Intrinsics.checkParameterIsNotNull(logoInfo, "logoInfo");
        this.s.setDetailInfo(offerProductDetailItemDomain.getDetailInfo());
        this.s.setLogoInfo(logoInfo);
    }
}
