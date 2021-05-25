package ru.sravni.android.bankproduct.presentation.offer.osago.list.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.vk.sdk.api.VKApiConst;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.R;
import ru.sravni.android.bankproduct.databinding.OfferOsagoListHeaderSravniBinding;
import ru.sravni.android.bankproduct.databinding.OfferOsagoListItemSravniBinding;
import ru.sravni.android.bankproduct.databinding.OfferOsagoListProlongationItemSravniBinding;
import ru.sravni.android.bankproduct.domain.offer.osago.entity.list.OfferOsagoDetailDomain;
import ru.sravni.android.bankproduct.domain.offer.osago.entity.list.OfferOsagoItemDomain;
import ru.sravni.android.bankproduct.domain.offer.osago.entity.list.OfferOsagoItemEnum;
import ru.sravni.android.bankproduct.presentation.offer.osago.list.viewmodel.ISelectOfferOsago;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001d\u0012\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u001e\u001a\u00020\u001b¢\u0006\u0004\b \u0010!J\u001b\u0010\u0007\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0015\u0010\u0016R\u001c\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00040\u00178\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d¨\u0006\""}, d2 = {"Lru/sravni/android/bankproduct/presentation/offer/osago/list/adapter/OfferOsagoListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", "Lru/sravni/android/bankproduct/domain/offer/osago/entity/list/OfferOsagoItemDomain;", "updateListOsagoItem", "", "updateListOsagoDetail", "(Ljava/util/List;)V", "", VKApiConst.POSITION, "getItemViewType", "(I)I", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "getItemCount", "()I", "holder", "onBindViewHolder", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;I)V", "", "c", "Ljava/util/List;", "listOsagoItem", "Lru/sravni/android/bankproduct/presentation/offer/osago/list/viewmodel/ISelectOfferOsago;", "d", "Lru/sravni/android/bankproduct/presentation/offer/osago/list/viewmodel/ISelectOfferOsago;", "selectOfferOsago", "listOsago", "<init>", "(Ljava/util/List;Lru/sravni/android/bankproduct/presentation/offer/osago/list/viewmodel/ISelectOfferOsago;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class OfferOsagoListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public List<OfferOsagoItemDomain> c;
    public final ISelectOfferOsago d;

    public OfferOsagoListAdapter(@NotNull List<OfferOsagoItemDomain> list, @NotNull ISelectOfferOsago iSelectOfferOsago) {
        Intrinsics.checkParameterIsNotNull(list, "listOsago");
        Intrinsics.checkParameterIsNotNull(iSelectOfferOsago, "selectOfferOsago");
        this.d = iSelectOfferOsago;
        this.c = CollectionsKt___CollectionsKt.toMutableList((Collection) list);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.c.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        return this.c.get(i).getOfferOsagoItemEnum().ordinal();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder viewHolder, int i) {
        Intrinsics.checkParameterIsNotNull(viewHolder, "holder");
        OfferOsagoOsagoListHeaderViewHolder offerOsagoOsagoListHeaderViewHolder = (OfferOsagoOsagoListHeaderViewHolder) (!(viewHolder instanceof OfferOsagoOsagoListHeaderViewHolder) ? null : viewHolder);
        if (offerOsagoOsagoListHeaderViewHolder != null) {
            offerOsagoOsagoListHeaderViewHolder.bind(this.c.get(i));
        }
        OfferOsagoListViewProlongationItemHolder offerOsagoListViewProlongationItemHolder = (OfferOsagoListViewProlongationItemHolder) (!(viewHolder instanceof OfferOsagoListViewProlongationItemHolder) ? null : viewHolder);
        if (offerOsagoListViewProlongationItemHolder != null) {
            offerOsagoListViewProlongationItemHolder.bind(this.c.get(i), this.d);
        }
        if (!(viewHolder instanceof OfferOsagoListViewItemHolder)) {
            viewHolder = null;
        }
        OfferOsagoListViewItemHolder offerOsagoListViewItemHolder = (OfferOsagoListViewItemHolder) viewHolder;
        if (offerOsagoListViewItemHolder != null) {
            offerOsagoListViewItemHolder.bind(this.c.get(i), this.d);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
        OfferOsagoItemEnum offerOsagoItemEnum = OfferOsagoItemEnum.HEADER;
        if (i == 1) {
            ViewDataBinding inflate = DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), R.layout.offer_osago_list_header_sravni, viewGroup, false);
            Intrinsics.checkExpressionValueIsNotNull(inflate, "DataBindingUtil.inflate(…  false\n                )");
            return new OfferOsagoOsagoListHeaderViewHolder((OfferOsagoListHeaderSravniBinding) inflate);
        }
        OfferOsagoItemEnum offerOsagoItemEnum2 = OfferOsagoItemEnum.PROLONGATION;
        if (i == 3) {
            ViewDataBinding inflate2 = DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), R.layout.offer_osago_list_prolongation_item_sravni, viewGroup, false);
            Intrinsics.checkExpressionValueIsNotNull(inflate2, "DataBindingUtil.inflate(…  false\n                )");
            return new OfferOsagoListViewProlongationItemHolder((OfferOsagoListProlongationItemSravniBinding) inflate2);
        }
        OfferOsagoItemEnum offerOsagoItemEnum3 = OfferOsagoItemEnum.ELEMENT;
        if (i == 2) {
            ViewDataBinding inflate3 = DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), R.layout.offer_osago_list_item_sravni, viewGroup, false);
            Intrinsics.checkExpressionValueIsNotNull(inflate3, "DataBindingUtil.inflate(…  false\n                )");
            return new OfferOsagoListViewItemHolder((OfferOsagoListItemSravniBinding) inflate3);
        }
        ViewDataBinding inflate4 = DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), R.layout.offer_osago_list_item_sravni, viewGroup, false);
        Intrinsics.checkExpressionValueIsNotNull(inflate4, "DataBindingUtil.inflate(…  false\n                )");
        return new OfferOsagoListViewItemHolder((OfferOsagoListItemSravniBinding) inflate4);
    }

    public final void updateListOsagoDetail(@NotNull List<OfferOsagoItemDomain> list) {
        Intrinsics.checkParameterIsNotNull(list, "updateListOsagoItem");
        int i = 0;
        for (T t : list) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            T t2 = t;
            if (t2.getOfferOsagoItemEnum() != OfferOsagoItemEnum.HEADER) {
                Iterator<OfferOsagoItemDomain> it = this.c.iterator();
                int i3 = 0;
                while (true) {
                    if (!it.hasNext()) {
                        i3 = -1;
                        break;
                    }
                    OfferOsagoItemDomain next = it.next();
                    OfferOsagoDetailDomain offerDomain = t2.getOfferDomain();
                    String str = null;
                    String productID = offerDomain != null ? offerDomain.getProductID() : null;
                    OfferOsagoDetailDomain offerDomain2 = next.getOfferDomain();
                    if (offerDomain2 != null) {
                        str = offerDomain2.getProductID();
                    }
                    if (Intrinsics.areEqual(productID, str)) {
                        break;
                    }
                    i3++;
                }
                if (!Intrinsics.areEqual(this.c.get(i3), t2)) {
                    List<OfferOsagoItemDomain> list2 = this.c;
                    list2.set(i3, OfferOsagoItemDomain.copy$default(list2.get(i3), null, null, t2.getOfferDomain(), 3, null));
                    notifyItemChanged(i3);
                }
                if (i3 != i) {
                    OfferOsagoItemDomain offerOsagoItemDomain = this.c.get(i3);
                    this.c.remove(offerOsagoItemDomain);
                    this.c.add(i, offerOsagoItemDomain);
                    notifyItemMoved(i3, i);
                }
            }
            i = i2;
        }
    }
}
