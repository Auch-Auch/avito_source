package ru.sravni.android.bankproduct.presentation.offer.product.status.adapter;

import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.databinding.OfferProductTitleSravniBinding;
import ru.sravni.android.bankproduct.domain.offer.product.entity.OfferProductDisplaySettingsDomain;
import ru.sravni.android.bankproduct.utils.svg.entity.LogoInfo;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\f\u001a\u00020\t¢\u0006\u0004\b\r\u0010\u000eJ\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lru/sravni/android/bankproduct/presentation/offer/product/status/adapter/OfferProductTitleViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lru/sravni/android/bankproduct/domain/offer/product/entity/OfferProductDisplaySettingsDomain;", "displaySettings", "Lru/sravni/android/bankproduct/utils/svg/entity/LogoInfo;", "logoInfo", "", "bind", "(Lru/sravni/android/bankproduct/domain/offer/product/entity/OfferProductDisplaySettingsDomain;Lru/sravni/android/bankproduct/utils/svg/entity/LogoInfo;)V", "Lru/sravni/android/bankproduct/databinding/OfferProductTitleSravniBinding;", "s", "Lru/sravni/android/bankproduct/databinding/OfferProductTitleSravniBinding;", "itemBinding", "<init>", "(Lru/sravni/android/bankproduct/databinding/OfferProductTitleSravniBinding;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class OfferProductTitleViewHolder extends RecyclerView.ViewHolder {
    public final OfferProductTitleSravniBinding s;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OfferProductTitleViewHolder(@NotNull OfferProductTitleSravniBinding offerProductTitleSravniBinding) {
        super(offerProductTitleSravniBinding.getRoot());
        Intrinsics.checkParameterIsNotNull(offerProductTitleSravniBinding, "itemBinding");
        this.s = offerProductTitleSravniBinding;
    }

    public final void bind(@NotNull OfferProductDisplaySettingsDomain offerProductDisplaySettingsDomain, @NotNull LogoInfo logoInfo) {
        Intrinsics.checkParameterIsNotNull(offerProductDisplaySettingsDomain, "displaySettings");
        Intrinsics.checkParameterIsNotNull(logoInfo, "logoInfo");
        this.s.setOfferTitleInfo(offerProductDisplaySettingsDomain);
        this.s.setLogoInfo(logoInfo);
    }
}
