package ru.sravni.android.bankproduct.presentation.offer.osago.order.adapter;

import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.yarolegovich.discretescrollview.DiscreteScrollView;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.domain.offer.osago.entity.order.OsagoCompanyOrderInfoDomain;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a'\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u00002\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0007¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/yarolegovich/discretescrollview/DiscreteScrollView;", "view", "", "Lru/sravni/android/bankproduct/domain/offer/osago/entity/order/OsagoCompanyOrderInfoDomain$CompanyDomain;", "companyList", "", "bindCompanyList", "(Lcom/yarolegovich/discretescrollview/DiscreteScrollView;Ljava/util/List;)V", "sravnichat_release"}, k = 2, mv = {1, 4, 0})
public final class BindingOfferOsagoOrderAdapterKt {
    @BindingAdapter({"companyList"})
    public static final void bindCompanyList(@NotNull DiscreteScrollView discreteScrollView, @Nullable List<OsagoCompanyOrderInfoDomain.CompanyDomain> list) {
        Intrinsics.checkParameterIsNotNull(discreteScrollView, "view");
        if (list != null) {
            RecyclerView.Adapter adapter = discreteScrollView.getAdapter();
            if (!(adapter instanceof AlternativeOsagoCompanyAdapter)) {
                adapter = null;
            }
            AlternativeOsagoCompanyAdapter alternativeOsagoCompanyAdapter = (AlternativeOsagoCompanyAdapter) adapter;
            if (alternativeOsagoCompanyAdapter != null) {
                alternativeOsagoCompanyAdapter.setCalculationInfoList(list);
            }
        }
    }
}
