package com.avito.android.advert.item.price_marketplace;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.StrikethroughSpan;
import android.view.View;
import android.widget.TextView;
import com.avito.android.advert_details.R;
import com.avito.android.util.Contexts;
import com.avito.android.util.TextViews;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u001f\u001a\u00020\u0012¢\u0006\u0004\b \u0010!J5\u0010\n\u001a\u00020\t2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0016\u001a\n \u0013*\u0004\u0018\u00010\u00120\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0010R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u0010R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d¨\u0006\""}, d2 = {"Lcom/avito/android/advert/item/price_marketplace/AdvertDetailsPriceMarketplaceViewImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/advert/item/price_marketplace/AdvertDetailsPriceMarketplaceView;", "", "price", "oldPrice", "discountPercentage", "", "hideDiscountPercent", "", "showPrice", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "applyClosedAdvert", "()V", "Landroid/widget/TextView;", "t", "Landroid/widget/TextView;", "priceView", "Landroid/view/View;", "kotlin.jvm.PlatformType", "s", "Landroid/view/View;", "priceContainer", VKApiConst.VERSION, "discountPercentageView", "u", "oldPriceView", "", "w", "I", "closedAdvertPriceColor", "view", "<init>", "(Landroid/view/View;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertDetailsPriceMarketplaceViewImpl extends BaseViewHolder implements AdvertDetailsPriceMarketplaceView {
    public final View s;
    public final TextView t;
    public final TextView u;
    public final TextView v;
    public final int w;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AdvertDetailsPriceMarketplaceViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        View findViewById = view.findViewById(R.id.item_price_marketplace);
        this.s = findViewById;
        TextView textView = null;
        this.t = findViewById != null ? (TextView) findViewById.findViewById(R.id.current_price) : null;
        this.u = findViewById != null ? (TextView) findViewById.findViewById(R.id.old_price) : null;
        this.v = findViewById != null ? (TextView) findViewById.findViewById(R.id.discount_percentage) : textView;
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        this.w = Contexts.getColorByAttr(context, com.avito.android.lib.design.R.attr.gray48);
    }

    @Override // com.avito.android.advert.item.price_marketplace.AdvertDetailsPriceMarketplaceView
    public void applyClosedAdvert() {
        TextView textView = this.t;
        if (textView != null) {
            textView.setTextColor(this.w);
        }
        TextView textView2 = this.u;
        if (textView2 != null) {
            textView2.setVisibility(8);
        }
        TextView textView3 = this.v;
        if (textView3 != null) {
            textView3.setVisibility(8);
        }
    }

    @Override // com.avito.android.advert.item.price_marketplace.AdvertDetailsPriceMarketplaceView
    public void showPrice(@Nullable String str, @Nullable String str2, @Nullable String str3, boolean z) {
        TextView textView = this.t;
        int i = 0;
        if (textView != null) {
            TextViews.bindText$default(textView, str, false, 2, null);
        }
        boolean z2 = true;
        if (!(str2 == null || str2.length() == 0)) {
            if (!(str3 == null || str3.length() == 0)) {
                z2 = false;
            }
            if (!z2) {
                SpannableString spannableString = new SpannableString(str2);
                spannableString.setSpan(new StrikethroughSpan(), 0, spannableString.length(), 33);
                TextView textView2 = this.u;
                if (textView2 != null) {
                    textView2.setText(spannableString);
                    textView2.setVisibility(0);
                }
                TextView textView3 = this.v;
                if (textView3 != null) {
                    textView3.setText(str3);
                    if (z) {
                        i = 8;
                    }
                    textView3.setVisibility(i);
                    return;
                }
                return;
            }
        }
        TextView textView4 = this.u;
        if (textView4 != null) {
            textView4.setVisibility(8);
        }
        TextView textView5 = this.v;
        if (textView5 != null) {
            textView5.setVisibility(8);
        }
    }
}
