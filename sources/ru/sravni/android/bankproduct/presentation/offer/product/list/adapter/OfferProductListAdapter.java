package ru.sravni.android.bankproduct.presentation.offer.product.list.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.vk.sdk.api.VKApiConst;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.R;
import ru.sravni.android.bankproduct.databinding.OfferProductListEmptySravniBinding;
import ru.sravni.android.bankproduct.databinding.OfferProductListHeaderSravniBinding;
import ru.sravni.android.bankproduct.databinding.OfferProductListItemSravniBinding;
import ru.sravni.android.bankproduct.domain.offer.product.entity.OfferProductItemEnum;
import ru.sravni.android.bankproduct.presentation.offer.product.entity.OfferProductDetailDomainWithLogoInfo;
import ru.sravni.android.bankproduct.presentation.offer.product.list.viewmodel.ISelectOfferProduct;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001d\u0012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012\u0012\u0006\u0010\u001a\u001a\u00020\u0017¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\n\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001d"}, d2 = {"Lru/sravni/android/bankproduct/presentation/offer/product/list/adapter/OfferProductListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", VKApiConst.POSITION, "getItemViewType", "(I)I", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "getItemCount", "()I", "holder", "", "onBindViewHolder", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;I)V", "", "Lru/sravni/android/bankproduct/presentation/offer/product/entity/OfferProductDetailDomainWithLogoInfo;", "c", "Ljava/util/List;", "listOfferProduct", "Lru/sravni/android/bankproduct/presentation/offer/product/list/viewmodel/ISelectOfferProduct;", "d", "Lru/sravni/android/bankproduct/presentation/offer/product/list/viewmodel/ISelectOfferProduct;", "selectOfferProduct", "<init>", "(Ljava/util/List;Lru/sravni/android/bankproduct/presentation/offer/product/list/viewmodel/ISelectOfferProduct;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class OfferProductListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public final List<OfferProductDetailDomainWithLogoInfo> c;
    public final ISelectOfferProduct d;

    public OfferProductListAdapter(@NotNull List<OfferProductDetailDomainWithLogoInfo> list, @NotNull ISelectOfferProduct iSelectOfferProduct) {
        Intrinsics.checkParameterIsNotNull(list, "listOfferProduct");
        Intrinsics.checkParameterIsNotNull(iSelectOfferProduct, "selectOfferProduct");
        this.c = list;
        this.d = iSelectOfferProduct;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.c.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        return this.c.get(i).getOfferProductItemDomain().getOfferProductItemEnum().ordinal();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder viewHolder, int i) {
        Intrinsics.checkParameterIsNotNull(viewHolder, "holder");
        OfferProductListHeaderViewHolder offerProductListHeaderViewHolder = (OfferProductListHeaderViewHolder) (!(viewHolder instanceof OfferProductListHeaderViewHolder) ? null : viewHolder);
        if (offerProductListHeaderViewHolder != null) {
            offerProductListHeaderViewHolder.bind(this.c.get(i).getOfferProductItemDomain());
        }
        if (!(viewHolder instanceof OfferProductListViewItemHolder)) {
            viewHolder = null;
        }
        OfferProductListViewItemHolder offerProductListViewItemHolder = (OfferProductListViewItemHolder) viewHolder;
        if (offerProductListViewItemHolder != null) {
            offerProductListViewItemHolder.bind(this.c.get(i).getOfferProductItemDomain(), this.d, this.c.get(i).getLogoInfo());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
        OfferProductItemEnum offerProductItemEnum = OfferProductItemEnum.EMPTY;
        if (i == 0) {
            ViewDataBinding inflate = DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), R.layout.offer_product_list_empty_sravni, viewGroup, false);
            Intrinsics.checkExpressionValueIsNotNull(inflate, "DataBindingUtil.inflate(…  false\n                )");
            return new OfferProductListEmptyViewHolder((OfferProductListEmptySravniBinding) inflate);
        }
        OfferProductItemEnum offerProductItemEnum2 = OfferProductItemEnum.HEADER;
        if (i == 1) {
            ViewDataBinding inflate2 = DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), R.layout.offer_product_list_header_sravni, viewGroup, false);
            Intrinsics.checkExpressionValueIsNotNull(inflate2, "DataBindingUtil.inflate(…  false\n                )");
            return new OfferProductListHeaderViewHolder((OfferProductListHeaderSravniBinding) inflate2);
        }
        OfferProductItemEnum offerProductItemEnum3 = OfferProductItemEnum.ELEMENT;
        if (i == 2) {
            ViewDataBinding inflate3 = DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), R.layout.offer_product_list_item_sravni, viewGroup, false);
            Intrinsics.checkExpressionValueIsNotNull(inflate3, "DataBindingUtil.inflate(…  false\n                )");
            return new OfferProductListViewItemHolder((OfferProductListItemSravniBinding) inflate3);
        }
        ViewDataBinding inflate4 = DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), R.layout.offer_product_list_item_sravni, viewGroup, false);
        Intrinsics.checkExpressionValueIsNotNull(inflate4, "DataBindingUtil.inflate(…  false\n                )");
        return new OfferProductListViewItemHolder((OfferProductListItemSravniBinding) inflate4);
    }
}
