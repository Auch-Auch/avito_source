package com.avito.android.advert.item.price;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.StrikethroughSpan;
import android.view.View;
import android.widget.TextView;
import com.avito.android.advert_details.R;
import com.avito.android.util.AvitoTextUtils;
import com.avito.android.util.Contexts;
import com.avito.android.util.TextViews;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u001b\u001a\u00020\u0010¢\u0006\u0004\b\u001c\u0010\u001dJ#\u0010\u0007\u001a\u00020\u00062\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000b\u0010\nR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u001e\u0010\u0014\u001a\n \u0011*\u0004\u0018\u00010\u00100\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u000e¨\u0006\u001e"}, d2 = {"Lcom/avito/android/advert/item/price/AdvertDetailsPriceViewImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/advert/item/price/AdvertDetailsPriceView;", "", "price", "oldPrice", "", "showPrice", "(Ljava/lang/String;Ljava/lang/String;)V", "hidePrice", "()V", "applyClosedAdvert", "Landroid/widget/TextView;", "t", "Landroid/widget/TextView;", "priceView", "Landroid/view/View;", "kotlin.jvm.PlatformType", "s", "Landroid/view/View;", "priceContainer", "", VKApiConst.VERSION, "I", "closedAdvertPriceColor", "u", "oldPriceView", "view", "<init>", "(Landroid/view/View;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertDetailsPriceViewImpl extends BaseViewHolder implements AdvertDetailsPriceView {
    public final View s;
    public final TextView t;
    public final TextView u;
    public final int v;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AdvertDetailsPriceViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        View findViewById = view.findViewById(R.id.item_price);
        this.s = findViewById;
        TextView textView = null;
        this.t = findViewById != null ? (TextView) findViewById.findViewById(R.id.current_price) : null;
        this.u = findViewById != null ? (TextView) findViewById.findViewById(R.id.old_price) : textView;
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        this.v = Contexts.getColorByAttr(context, com.avito.android.lib.design.R.attr.gray48);
    }

    @Override // com.avito.android.advert.item.price.AdvertDetailsPriceView
    public void applyClosedAdvert() {
        TextView textView = this.t;
        if (textView != null) {
            textView.setTextColor(this.v);
        }
    }

    @Override // com.avito.android.advert.item.price.AdvertDetailsPriceView
    public void hidePrice() {
        View view = this.s;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    @Override // com.avito.android.advert.item.price.AdvertDetailsPriceView
    public void showPrice(@Nullable String str, @Nullable String str2) {
        TextView textView = this.t;
        if (textView != null) {
            TextViews.bindText$default(textView, str, false, 2, null);
        }
        if (AvitoTextUtils.isNullOrEmpty(str2)) {
            TextView textView2 = this.u;
            if (textView2 != null) {
                textView2.setVisibility(8);
                return;
            }
            return;
        }
        SpannableString spannableString = new SpannableString(str2);
        spannableString.setSpan(new StrikethroughSpan(), 0, spannableString.length(), 33);
        TextView textView3 = this.u;
        if (textView3 != null) {
            textView3.setText(spannableString);
        }
        TextView textView4 = this.u;
        if (textView4 != null) {
            textView4.setVisibility(0);
        }
    }
}
