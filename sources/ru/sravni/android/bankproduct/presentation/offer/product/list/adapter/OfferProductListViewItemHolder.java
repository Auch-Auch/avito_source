package ru.sravni.android.bankproduct.presentation.offer.product.list.adapter;

import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.databinding.OfferProductListItemSravniBinding;
import ru.sravni.android.bankproduct.domain.offer.product.entity.OfferProductItemDomain;
import ru.sravni.android.bankproduct.domain.offer.product.entity.detail.OfferProductDetailDomain;
import ru.sravni.android.bankproduct.presentation.offer.product.entity.OfferProductActionInfoKt;
import ru.sravni.android.bankproduct.presentation.offer.product.list.viewmodel.ISelectOfferProduct;
import ru.sravni.android.bankproduct.utils.svg.entity.LogoInfo;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u000f\u0010\u0010J%\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lru/sravni/android/bankproduct/presentation/offer/product/list/adapter/OfferProductListViewItemHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lru/sravni/android/bankproduct/domain/offer/product/entity/OfferProductItemDomain;", "offerProductItem", "Lru/sravni/android/bankproduct/presentation/offer/product/list/viewmodel/ISelectOfferProduct;", "selectOfferProduct", "Lru/sravni/android/bankproduct/utils/svg/entity/LogoInfo;", "logoInfo", "", "bind", "(Lru/sravni/android/bankproduct/domain/offer/product/entity/OfferProductItemDomain;Lru/sravni/android/bankproduct/presentation/offer/product/list/viewmodel/ISelectOfferProduct;Lru/sravni/android/bankproduct/utils/svg/entity/LogoInfo;)V", "Lru/sravni/android/bankproduct/databinding/OfferProductListItemSravniBinding;", "s", "Lru/sravni/android/bankproduct/databinding/OfferProductListItemSravniBinding;", "itemBinding", "<init>", "(Lru/sravni/android/bankproduct/databinding/OfferProductListItemSravniBinding;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class OfferProductListViewItemHolder extends RecyclerView.ViewHolder {
    public final OfferProductListItemSravniBinding s;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OfferProductListViewItemHolder(@NotNull OfferProductListItemSravniBinding offerProductListItemSravniBinding) {
        super(offerProductListItemSravniBinding.getRoot());
        Intrinsics.checkParameterIsNotNull(offerProductListItemSravniBinding, "itemBinding");
        this.s = offerProductListItemSravniBinding;
    }

    public final void bind(@NotNull OfferProductItemDomain offerProductItemDomain, @NotNull ISelectOfferProduct iSelectOfferProduct, @NotNull LogoInfo logoInfo) {
        Intrinsics.checkParameterIsNotNull(offerProductItemDomain, "offerProductItem");
        Intrinsics.checkParameterIsNotNull(iSelectOfferProduct, "selectOfferProduct");
        Intrinsics.checkParameterIsNotNull(logoInfo, "logoInfo");
        this.s.setSelectOfferProduct(iSelectOfferProduct);
        this.s.setOffer(offerProductItemDomain.getOfferDomain());
        this.s.setLogoInfo(logoInfo);
        OfferProductListItemSravniBinding offerProductListItemSravniBinding = this.s;
        OfferProductDetailDomain offerDomain = offerProductItemDomain.getOfferDomain();
        offerProductListItemSravniBinding.setOfferProductStatusInfo(offerDomain != null ? OfferProductActionInfoKt.createOfferProductStatusInfo(offerDomain) : null);
    }
}
