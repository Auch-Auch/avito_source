package ru.sravni.android.bankproduct.presentation.offer.product.status.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.R;
import ru.sravni.android.bankproduct.databinding.OfferProductItemStatusTextSravniBinding;
import ru.sravni.android.bankproduct.databinding.OfferProductStatusItemSravniBinding;
import ru.sravni.android.bankproduct.databinding.OfferProductTitleSravniBinding;
import ru.sravni.android.bankproduct.presentation.offer.product.entity.OfferProductStatusDomainWithLogoInfo;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0015\u001a\u00020\u0012¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\n\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0018\u001a\u00020\u00038\u0002@\u0002XD¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001a\u001a\u00020\u00038\u0002@\u0002XD¢\u0006\u0006\n\u0004\b\u0019\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00038\u0002@\u0002XD¢\u0006\u0006\n\u0004\b\u001b\u0010\u0017¨\u0006\u001f"}, d2 = {"Lru/sravni/android/bankproduct/presentation/offer/product/status/adapter/OfferProductStatusAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", VKApiConst.POSITION, "getItemViewType", "(I)I", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "getItemCount", "()I", "holder", "", "onBindViewHolder", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;I)V", "Lru/sravni/android/bankproduct/presentation/offer/product/entity/OfferProductStatusDomainWithLogoInfo;", "f", "Lru/sravni/android/bankproduct/presentation/offer/product/entity/OfferProductStatusDomainWithLogoInfo;", "statusInfo", "d", "I", "statusElement", "c", "titleElement", "e", "textElement", "<init>", "(Lru/sravni/android/bankproduct/presentation/offer/product/entity/OfferProductStatusDomainWithLogoInfo;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class OfferProductStatusAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public final int c = 1;
    public final int d = 2;
    public final int e = 3;
    public final OfferProductStatusDomainWithLogoInfo f;

    public OfferProductStatusAdapter(@NotNull OfferProductStatusDomainWithLogoInfo offerProductStatusDomainWithLogoInfo) {
        Intrinsics.checkParameterIsNotNull(offerProductStatusDomainWithLogoInfo, "statusInfo");
        this.f = offerProductStatusDomainWithLogoInfo;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f.getOfferProductStatusDomain().getOfferStatusElementDomainList().size() + 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        if (i == 0) {
            return this.c;
        }
        if (this.f.getOfferProductStatusDomain().getOfferStatusElementDomainList().get(i - 1).getStatus() != null) {
            return this.d;
        }
        return this.e;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder viewHolder, int i) {
        Intrinsics.checkParameterIsNotNull(viewHolder, "holder");
        OfferProductTitleViewHolder offerProductTitleViewHolder = (OfferProductTitleViewHolder) (!(viewHolder instanceof OfferProductTitleViewHolder) ? null : viewHolder);
        if (offerProductTitleViewHolder != null) {
            offerProductTitleViewHolder.bind(this.f.getOfferProductStatusDomain().getDisplaySettings(), this.f.getLogoInfo());
        }
        OfferProductStatusViewHolder offerProductStatusViewHolder = (OfferProductStatusViewHolder) (!(viewHolder instanceof OfferProductStatusViewHolder) ? null : viewHolder);
        if (offerProductStatusViewHolder != null) {
            offerProductStatusViewHolder.bind(this.f.getOfferProductStatusDomain().getOfferStatusElementDomainList().get(i - 1));
        }
        if (!(viewHolder instanceof OfferProductStatusTextViewHolder)) {
            viewHolder = null;
        }
        OfferProductStatusTextViewHolder offerProductStatusTextViewHolder = (OfferProductStatusTextViewHolder) viewHolder;
        if (offerProductStatusTextViewHolder != null) {
            offerProductStatusTextViewHolder.bind(this.f.getOfferProductStatusDomain().getOfferStatusElementDomainList().get(i - 1).getText());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
        if (i == this.c) {
            ViewDataBinding inflate = DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), R.layout.offer_product_title_sravni, viewGroup, false);
            Intrinsics.checkExpressionValueIsNotNull(inflate, "DataBindingUtil.inflate(…  false\n                )");
            return new OfferProductTitleViewHolder((OfferProductTitleSravniBinding) inflate);
        } else if (i == this.d) {
            ViewDataBinding inflate2 = DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), R.layout.offer_product_status_item_sravni, viewGroup, false);
            Intrinsics.checkExpressionValueIsNotNull(inflate2, "DataBindingUtil.inflate(…  false\n                )");
            return new OfferProductStatusViewHolder((OfferProductStatusItemSravniBinding) inflate2);
        } else if (i == this.e) {
            ViewDataBinding inflate3 = DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), R.layout.offer_product_item_status_text_sravni, viewGroup, false);
            Intrinsics.checkExpressionValueIsNotNull(inflate3, "DataBindingUtil.inflate(…  false\n                )");
            return new OfferProductStatusTextViewHolder((OfferProductItemStatusTextSravniBinding) inflate3);
        } else {
            View inflate4 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.offer_product_status_stub_sravni, viewGroup, false);
            Intrinsics.checkExpressionValueIsNotNull(inflate4, "LayoutInflater.from(pare…  false\n                )");
            return new StubViewHolder(inflate4);
        }
    }
}
