package ru.sravni.android.bankproduct.presentation.offer.product.list.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.vk.sdk.api.VKApiConst;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.R;
import ru.sravni.android.bankproduct.databinding.OfferProductListInfoItemSravniBinding;
import ru.sravni.android.bankproduct.domain.offer.product.entity.detail.OfferProductDetailDomain;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010!\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0018\u0010\u0019J\u001b\u0010\u0007\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\r\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u001a"}, d2 = {"Lru/sravni/android/bankproduct/presentation/offer/product/list/adapter/OfferProductListInfoAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lru/sravni/android/bankproduct/presentation/offer/product/list/adapter/OfferProductListInfoItemViewHolder;", "", "Lru/sravni/android/bankproduct/domain/offer/product/entity/detail/OfferProductDetailDomain$MainParam;", "listInfo", "", "setNewListOffer", "(Ljava/util/List;)V", "Landroid/view/ViewGroup;", "parent", "", "viewType", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Lru/sravni/android/bankproduct/presentation/offer/product/list/adapter/OfferProductListInfoItemViewHolder;", "getItemCount", "()I", "holder", VKApiConst.POSITION, "onBindViewHolder", "(Lru/sravni/android/bankproduct/presentation/offer/product/list/adapter/OfferProductListInfoItemViewHolder;I)V", "", "c", "Ljava/util/List;", "<init>", "()V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class OfferProductListInfoAdapter extends RecyclerView.Adapter<OfferProductListInfoItemViewHolder> {
    public final List<OfferProductDetailDomain.MainParam> c = new ArrayList();

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.c.size();
    }

    public final void setNewListOffer(@NotNull List<OfferProductDetailDomain.MainParam> list) {
        Intrinsics.checkParameterIsNotNull(list, "listInfo");
        this.c.clear();
        this.c.addAll(list);
        notifyDataSetChanged();
    }

    public void onBindViewHolder(@NotNull OfferProductListInfoItemViewHolder offerProductListInfoItemViewHolder, int i) {
        Intrinsics.checkParameterIsNotNull(offerProductListInfoItemViewHolder, "holder");
        offerProductListInfoItemViewHolder.getItemBinding().setMainParam(this.c.get(i));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public OfferProductListInfoItemViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
        ViewDataBinding inflate = DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), R.layout.offer_product_list_info_item_sravni, viewGroup, false);
        Intrinsics.checkExpressionValueIsNotNull(inflate, "DataBindingUtil.inflate(…      false\n            )");
        return new OfferProductListInfoItemViewHolder((OfferProductListInfoItemSravniBinding) inflate);
    }
}
