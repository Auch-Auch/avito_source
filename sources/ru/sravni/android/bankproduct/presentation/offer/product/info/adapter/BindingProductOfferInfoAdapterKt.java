package ru.sravni.android.bankproduct.presentation.offer.product.info.adapter;

import android.widget.TextView;
import androidx.core.widget.TextViewCompat;
import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.internal.AnalyticsEvents;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.R;
import ru.sravni.android.bankproduct.presentation.offer.product.entity.OfferProductDetailItemDomainWithLogoInfo;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u001a'\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u00002\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0007¢\u0006\u0004\b\u0006\u0010\u0007\u001a!\u0010\f\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0007¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Landroidx/recyclerview/widget/RecyclerView;", "view", "", "Lru/sravni/android/bankproduct/presentation/offer/product/entity/OfferProductDetailItemDomainWithLogoInfo;", "listOfferProductItemDomain", "", "bindListToRecycler", "(Landroidx/recyclerview/widget/RecyclerView;Ljava/util/List;)V", "Landroid/widget/TextView;", "textView", "", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "bindPrimaryTextStyleToTextView", "(Landroid/widget/TextView;Ljava/lang/String;)V", "sravnichat_release"}, k = 2, mv = {1, 4, 0})
public final class BindingProductOfferInfoAdapterKt {
    @BindingAdapter({"listOfferProductInfoItem"})
    public static final void bindListToRecycler(@NotNull RecyclerView recyclerView, @Nullable List<OfferProductDetailItemDomainWithLogoInfo> list) {
        Intrinsics.checkParameterIsNotNull(recyclerView, "view");
        if (list != null) {
            recyclerView.setAdapter(new OfferProductInfoAdapter(list));
        }
    }

    @BindingAdapter({"primaryTextStyle"})
    public static final void bindPrimaryTextStyleToTextView(@NotNull TextView textView, @Nullable String str) {
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
                i = R.style.Body1Medium;
                TextViewCompat.setTextAppearance(textView, i);
            }
            i = R.style.Body1Medium;
            TextViewCompat.setTextAppearance(textView, i);
        }
    }
}
