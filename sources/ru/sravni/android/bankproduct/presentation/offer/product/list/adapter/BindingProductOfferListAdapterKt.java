package ru.sravni.android.bankproduct.presentation.offer.product.list.adapter;

import android.widget.TextView;
import androidx.core.widget.TextViewCompat;
import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.internal.AnalyticsEvents;
import com.google.android.material.textfield.TextInputEditText;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.R;
import ru.sravni.android.bankproduct.domain.offer.product.entity.detail.OfferProductDetailDomain;
import ru.sravni.android.bankproduct.presentation.offer.entity.StatusInfo;
import ru.sravni.android.bankproduct.presentation.offer.product.entity.OfferProductDetailDomainWithLogoInfo;
import ru.sravni.android.bankproduct.presentation.offer.product.list.viewmodel.ISelectOfferProduct;
import ru.sravni.android.bankproduct.utils.components.recyclerview.UntouchableRecyclerView;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a/\u0010\b\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00002\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\b\u0010\t\u001a%\u0010\r\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\n2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0002H\u0007¢\u0006\u0004\b\r\u0010\u000e\u001a!\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0007¢\u0006\u0004\b\u0013\u0010\u0014\u001a\u001f\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u0015H\u0007¢\u0006\u0004\b\u0017\u0010\u0018\u001a!\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0011H\u0007¢\u0006\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"Landroidx/recyclerview/widget/RecyclerView;", "view", "", "Lru/sravni/android/bankproduct/presentation/offer/product/entity/OfferProductDetailDomainWithLogoInfo;", "listOfferProductItem", "Lru/sravni/android/bankproduct/presentation/offer/product/list/viewmodel/ISelectOfferProduct;", "clickItemOffer", "", "bindListToRecycler", "(Landroidx/recyclerview/widget/RecyclerView;Ljava/util/List;Lru/sravni/android/bankproduct/presentation/offer/product/list/viewmodel/ISelectOfferProduct;)V", "Lru/sravni/android/bankproduct/utils/components/recyclerview/UntouchableRecyclerView;", "Lru/sravni/android/bankproduct/domain/offer/product/entity/detail/OfferProductDetailDomain$MainParam;", "listMainParams", "bindListParamToRecycler", "(Lru/sravni/android/bankproduct/utils/components/recyclerview/UntouchableRecyclerView;Ljava/util/List;)V", "Landroid/widget/TextView;", "textView", "", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "bindTextAppearanceStyleToTextView", "(Landroid/widget/TextView;Ljava/lang/String;)V", "Lru/sravni/android/bankproduct/presentation/offer/entity/StatusInfo;", "statusInfo", "bindDrawableToTextView", "(Landroid/widget/TextView;Lru/sravni/android/bankproduct/presentation/offer/entity/StatusInfo;)V", "Lcom/google/android/material/textfield/TextInputEditText;", "amountValue", "bindSelectionPositionToTextInputEditText", "(Lcom/google/android/material/textfield/TextInputEditText;Ljava/lang/String;)V", "sravnichat_release"}, k = 2, mv = {1, 4, 0})
public final class BindingProductOfferListAdapterKt {
    @BindingAdapter({"statusInfo"})
    public static final void bindDrawableToTextView(@NotNull TextView textView, @NotNull StatusInfo statusInfo) {
        Intrinsics.checkParameterIsNotNull(textView, "view");
        Intrinsics.checkParameterIsNotNull(statusInfo, "statusInfo");
        textView.setCompoundDrawablesWithIntrinsicBounds(statusInfo.getStatusIcon(), 0, 0, 0);
        textView.setTextColor(statusInfo.getStatusColor());
    }

    @BindingAdapter({"listMainParams"})
    public static final void bindListParamToRecycler(@NotNull UntouchableRecyclerView untouchableRecyclerView, @NotNull List<OfferProductDetailDomain.MainParam> list) {
        Intrinsics.checkParameterIsNotNull(untouchableRecyclerView, "view");
        Intrinsics.checkParameterIsNotNull(list, "listMainParams");
        if (untouchableRecyclerView.getAdapter() == null) {
            untouchableRecyclerView.setLayoutManager(new GridLayoutManager(untouchableRecyclerView.getContext(), 2));
            untouchableRecyclerView.setAdapter(new OfferProductListInfoAdapter());
        }
        RecyclerView.Adapter adapter = untouchableRecyclerView.getAdapter();
        if (adapter != null) {
            ((OfferProductListInfoAdapter) adapter).setNewListOffer(list);
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type ru.sravni.android.bankproduct.presentation.offer.product.list.adapter.OfferProductListInfoAdapter");
    }

    @BindingAdapter({"listOfferProductItem", "clickItemOffer"})
    public static final void bindListToRecycler(@NotNull RecyclerView recyclerView, @Nullable List<OfferProductDetailDomainWithLogoInfo> list, @NotNull ISelectOfferProduct iSelectOfferProduct) {
        Intrinsics.checkParameterIsNotNull(recyclerView, "view");
        Intrinsics.checkParameterIsNotNull(iSelectOfferProduct, "clickItemOffer");
        if (list != null) {
            recyclerView.setAdapter(new OfferProductListAdapter(list, iSelectOfferProduct));
        }
    }

    @BindingAdapter({"amountValue"})
    public static final void bindSelectionPositionToTextInputEditText(@NotNull TextInputEditText textInputEditText, @Nullable String str) {
        Intrinsics.checkParameterIsNotNull(textInputEditText, "view");
        if (str != null) {
            textInputEditText.setText(str);
            textInputEditText.setSelection(str.length());
        }
    }

    @BindingAdapter({"textAppearanceStyle"})
    public static final void bindTextAppearanceStyleToTextView(@NotNull TextView textView, @Nullable String str) {
        int i;
        Intrinsics.checkParameterIsNotNull(textView, "textView");
        if (str != null) {
            int hashCode = str.hashCode();
            if (hashCode != -1039745817) {
                if (hashCode == 3029637 && str.equals("bold")) {
                    i = R.style.Headline1Medium;
                    TextViewCompat.setTextAppearance(textView, i);
                }
            } else if (str.equals("normal")) {
                i = R.style.Subtitle1Regular;
                TextViewCompat.setTextAppearance(textView, i);
            }
            i = R.style.Subtitle1Regular;
            TextViewCompat.setTextAppearance(textView, i);
        }
    }
}
