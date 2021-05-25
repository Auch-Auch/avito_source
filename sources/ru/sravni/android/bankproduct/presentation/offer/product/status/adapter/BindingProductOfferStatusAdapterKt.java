package ru.sravni.android.bankproduct.presentation.offer.product.status.adapter;

import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.presentation.offer.product.entity.OfferProductStatusDomainWithLogoInfo;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a!\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Landroidx/recyclerview/widget/RecyclerView;", "view", "Lru/sravni/android/bankproduct/presentation/offer/product/entity/OfferProductStatusDomainWithLogoInfo;", "offerProductStatus", "", "bindListToRecycler", "(Landroidx/recyclerview/widget/RecyclerView;Lru/sravni/android/bankproduct/presentation/offer/product/entity/OfferProductStatusDomainWithLogoInfo;)V", "sravnichat_release"}, k = 2, mv = {1, 4, 0})
public final class BindingProductOfferStatusAdapterKt {
    @BindingAdapter({"offerProductStatus"})
    public static final void bindListToRecycler(@NotNull RecyclerView recyclerView, @Nullable OfferProductStatusDomainWithLogoInfo offerProductStatusDomainWithLogoInfo) {
        Intrinsics.checkParameterIsNotNull(recyclerView, "view");
        if (offerProductStatusDomainWithLogoInfo != null) {
            recyclerView.setAdapter(new OfferProductStatusAdapter(offerProductStatusDomainWithLogoInfo));
        }
    }
}
