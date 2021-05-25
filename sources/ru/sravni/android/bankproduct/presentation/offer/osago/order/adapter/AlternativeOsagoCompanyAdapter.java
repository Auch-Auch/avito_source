package ru.sravni.android.bankproduct.presentation.offer.osago.order.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.vk.sdk.api.VKApiConst;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.R;
import ru.sravni.android.bankproduct.databinding.OfferOsagoOrderAlternativeItemSravniBinding;
import ru.sravni.android.bankproduct.domain.offer.osago.entity.order.OsagoCompanyOrderInfoDomain;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010!\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u001b\u001a\u00020\u000b\u0012\u0006\u0010\u001f\u001a\u00020\u001c¢\u0006\u0004\b \u0010!J\u001b\u0010\u0007\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\r\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00040\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001b\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e¨\u0006\""}, d2 = {"Lru/sravni/android/bankproduct/presentation/offer/osago/order/adapter/AlternativeOsagoCompanyAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lru/sravni/android/bankproduct/presentation/offer/osago/order/adapter/OsagoCompanyAlternativeViewHolder;", "", "Lru/sravni/android/bankproduct/domain/offer/osago/entity/order/OsagoCompanyOrderInfoDomain$CompanyDomain;", "newCompanyList", "", "setCalculationInfoList", "(Ljava/util/List;)V", "Landroid/view/ViewGroup;", "parent", "", "viewType", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Lru/sravni/android/bankproduct/presentation/offer/osago/order/adapter/OsagoCompanyAlternativeViewHolder;", "getItemCount", "()I", "holder", VKApiConst.POSITION, "onBindViewHolder", "(Lru/sravni/android/bankproduct/presentation/offer/osago/order/adapter/OsagoCompanyAlternativeViewHolder;I)V", "", "c", "Ljava/util/List;", "companyList", "d", "I", "cardWidthInPixel", "Lru/sravni/android/bankproduct/presentation/offer/osago/order/adapter/IAlternativeCompany;", "e", "Lru/sravni/android/bankproduct/presentation/offer/osago/order/adapter/IAlternativeCompany;", "alternativeCompany", "<init>", "(ILru/sravni/android/bankproduct/presentation/offer/osago/order/adapter/IAlternativeCompany;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class AlternativeOsagoCompanyAdapter extends RecyclerView.Adapter<OsagoCompanyAlternativeViewHolder> {
    public final List<OsagoCompanyOrderInfoDomain.CompanyDomain> c = new ArrayList();
    public final int d;
    public final IAlternativeCompany e;

    public AlternativeOsagoCompanyAdapter(int i, @NotNull IAlternativeCompany iAlternativeCompany) {
        Intrinsics.checkParameterIsNotNull(iAlternativeCompany, "alternativeCompany");
        this.d = i;
        this.e = iAlternativeCompany;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.c.size();
    }

    public final void setCalculationInfoList(@NotNull List<OsagoCompanyOrderInfoDomain.CompanyDomain> list) {
        Intrinsics.checkParameterIsNotNull(list, "newCompanyList");
        this.c.clear();
        this.c.addAll(list);
        notifyDataSetChanged();
    }

    public void onBindViewHolder(@NotNull OsagoCompanyAlternativeViewHolder osagoCompanyAlternativeViewHolder, int i) {
        Intrinsics.checkParameterIsNotNull(osagoCompanyAlternativeViewHolder, "holder");
        osagoCompanyAlternativeViewHolder.getItemBinding().setCompany(this.c.get(i));
        osagoCompanyAlternativeViewHolder.getItemBinding().setAlternativeCompany(this.e);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public OsagoCompanyAlternativeViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
        OfferOsagoOrderAlternativeItemSravniBinding offerOsagoOrderAlternativeItemSravniBinding = (OfferOsagoOrderAlternativeItemSravniBinding) DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), R.layout.offer_osago_order_alternative_item_sravni, viewGroup, false);
        Intrinsics.checkExpressionValueIsNotNull(offerOsagoOrderAlternativeItemSravniBinding, "viewBinding");
        View root = offerOsagoOrderAlternativeItemSravniBinding.getRoot();
        Intrinsics.checkExpressionValueIsNotNull(root, "viewBinding.root");
        ViewGroup.LayoutParams layoutParams = root.getLayoutParams();
        layoutParams.width = this.d;
        View root2 = offerOsagoOrderAlternativeItemSravniBinding.getRoot();
        Intrinsics.checkExpressionValueIsNotNull(root2, "viewBinding.root");
        root2.setLayoutParams(layoutParams);
        return new OsagoCompanyAlternativeViewHolder(offerOsagoOrderAlternativeItemSravniBinding);
    }
}
