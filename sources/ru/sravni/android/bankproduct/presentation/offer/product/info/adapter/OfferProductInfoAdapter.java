package ru.sravni.android.bankproduct.presentation.offer.product.info.adapter;

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
import ru.sravni.android.bankproduct.databinding.EmptyItemSravniBinding;
import ru.sravni.android.bankproduct.databinding.OfferProductInfoHeaderItemSravniBinding;
import ru.sravni.android.bankproduct.databinding.OfferProductInfoPrimaryItemSravniBinding;
import ru.sravni.android.bankproduct.databinding.OfferProductInfoStandartItemSravniBinding;
import ru.sravni.android.bankproduct.databinding.OfferProductInfoTitleItemSravniBinding;
import ru.sravni.android.bankproduct.domain.offer.product.entity.detail.TypeProductInfoEnum;
import ru.sravni.android.bankproduct.presentation.offer.product.entity.OfferProductDetailItemDomainWithLogoInfo;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\n\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lru/sravni/android/bankproduct/presentation/offer/product/info/adapter/OfferProductInfoAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", VKApiConst.POSITION, "getItemViewType", "(I)I", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "getItemCount", "()I", "holder", "", "onBindViewHolder", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;I)V", "", "Lru/sravni/android/bankproduct/presentation/offer/product/entity/OfferProductDetailItemDomainWithLogoInfo;", "c", "Ljava/util/List;", "offersDetailDomain", "<init>", "(Ljava/util/List;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class OfferProductInfoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public final List<OfferProductDetailItemDomainWithLogoInfo> c;

    public OfferProductInfoAdapter(@NotNull List<OfferProductDetailItemDomainWithLogoInfo> list) {
        Intrinsics.checkParameterIsNotNull(list, "offersDetailDomain");
        this.c = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.c.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        return this.c.get(i).getOfferProductDetailInfoDomain().getTypeProductInfo().ordinal();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder viewHolder, int i) {
        Intrinsics.checkParameterIsNotNull(viewHolder, "holder");
        OfferProductInfoHeaderViewHolder offerProductInfoHeaderViewHolder = (OfferProductInfoHeaderViewHolder) (!(viewHolder instanceof OfferProductInfoHeaderViewHolder) ? null : viewHolder);
        if (offerProductInfoHeaderViewHolder != null) {
            offerProductInfoHeaderViewHolder.bind(this.c.get(i).getOfferProductDetailInfoDomain(), this.c.get(i).getLogoInfo());
        }
        OfferProductInfoPrimaryViewHolder offerProductInfoPrimaryViewHolder = (OfferProductInfoPrimaryViewHolder) (!(viewHolder instanceof OfferProductInfoPrimaryViewHolder) ? null : viewHolder);
        if (offerProductInfoPrimaryViewHolder != null) {
            offerProductInfoPrimaryViewHolder.bind(this.c.get(i).getOfferProductDetailInfoDomain());
        }
        OfferProductInfoTitleViewHolder offerProductInfoTitleViewHolder = (OfferProductInfoTitleViewHolder) (!(viewHolder instanceof OfferProductInfoTitleViewHolder) ? null : viewHolder);
        if (offerProductInfoTitleViewHolder != null) {
            offerProductInfoTitleViewHolder.bind(this.c.get(i).getOfferProductDetailInfoDomain());
        }
        if (!(viewHolder instanceof OfferProductInfoStandartViewHolder)) {
            viewHolder = null;
        }
        OfferProductInfoStandartViewHolder offerProductInfoStandartViewHolder = (OfferProductInfoStandartViewHolder) viewHolder;
        if (offerProductInfoStandartViewHolder != null) {
            offerProductInfoStandartViewHolder.bind(this.c.get(i).getOfferProductDetailInfoDomain());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
        TypeProductInfoEnum typeProductInfoEnum = TypeProductInfoEnum.HEADER;
        if (i == 0) {
            ViewDataBinding inflate = DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), R.layout.offer_product_info_header_item_sravni, viewGroup, false);
            Intrinsics.checkExpressionValueIsNotNull(inflate, "DataBindingUtil.inflate(…  false\n                )");
            return new OfferProductInfoHeaderViewHolder((OfferProductInfoHeaderItemSravniBinding) inflate);
        }
        TypeProductInfoEnum typeProductInfoEnum2 = TypeProductInfoEnum.MAIN_INFO;
        if (i == 2) {
            ViewDataBinding inflate2 = DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), R.layout.offer_product_info_primary_item_sravni, viewGroup, false);
            Intrinsics.checkExpressionValueIsNotNull(inflate2, "DataBindingUtil.inflate(…  false\n                )");
            return new OfferProductInfoPrimaryViewHolder((OfferProductInfoPrimaryItemSravniBinding) inflate2);
        }
        TypeProductInfoEnum typeProductInfoEnum3 = TypeProductInfoEnum.TITLE;
        if (i == 1) {
            ViewDataBinding inflate3 = DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), R.layout.offer_product_info_title_item_sravni, viewGroup, false);
            Intrinsics.checkExpressionValueIsNotNull(inflate3, "DataBindingUtil.inflate(…  false\n                )");
            return new OfferProductInfoTitleViewHolder((OfferProductInfoTitleItemSravniBinding) inflate3);
        }
        TypeProductInfoEnum typeProductInfoEnum4 = TypeProductInfoEnum.INFO;
        if (i == 3) {
            ViewDataBinding inflate4 = DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), R.layout.offer_product_info_standart_item_sravni, viewGroup, false);
            Intrinsics.checkExpressionValueIsNotNull(inflate4, "DataBindingUtil.inflate(…  false\n                )");
            return new OfferProductInfoStandartViewHolder((OfferProductInfoStandartItemSravniBinding) inflate4);
        }
        ViewDataBinding inflate5 = DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), R.layout.empty_item_sravni, viewGroup, false);
        Intrinsics.checkExpressionValueIsNotNull(inflate5, "DataBindingUtil.inflate(…  false\n                )");
        return new EmptyViewHolder((EmptyItemSravniBinding) inflate5);
    }
}
