package com.avito.android.advert.item.marketplace_delivery;

import a2.b.a.a.a;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.view.View;
import android.widget.TextView;
import com.avito.android.advert.item.marketplace_delivery.MarketplaceDeliveryPresenter;
import com.avito.android.advert_details.R;
import com.avito.android.lib.util.VerticalCenteredImageSpan;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Location;
import com.avito.android.util.TextViews;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a#\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Landroid/view/View;", "Landroid/widget/TextView;", "selectCityView", "", "text", "", AuthSource.SEND_ABUSE, "(Landroid/view/View;Landroid/widget/TextView;Ljava/lang/String;)V", "advert-details_release"}, k = 2, mv = {1, 4, 2})
public final class MarketplaceDeliveryViewKt {
    public static final void a(View view, TextView textView, String str) {
        SpannableString spannableString = new SpannableString(a.c3(str, " >"));
        Drawable drawable = view.getContext().getDrawable(R.drawable.ic_marketplace_arrow_down);
        Intrinsics.checkNotNull(drawable);
        Intrinsics.checkNotNullExpressionValue(drawable, "context.getDrawable(R.dr…marketplace_arrow_down)!!");
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        spannableString.setSpan(new VerticalCenteredImageSpan(drawable), spannableString.length() - 1, spannableString.length(), 33);
        TextViews.bindText$default(textView, spannableString, false, 2, null);
    }

    public static final void access$bindSelectCity(TextView textView, View view, MarketplaceDeliveryItem marketplaceDeliveryItem, MarketplaceDeliveryPresenter.Listener listener) {
        Location locationTo = marketplaceDeliveryItem.getLocationTo();
        String str = "";
        if (locationTo != null) {
            String selectCityPrefix = marketplaceDeliveryItem.getDeliveryStatic().getSelectCityPrefix();
            StringBuilder sb = new StringBuilder();
            if (selectCityPrefix != null) {
                str = selectCityPrefix;
            }
            sb.append(str);
            sb.append(Typography.nbsp);
            sb.append(locationTo.getName(3));
            a(view, textView, sb.toString());
        } else {
            String selectCity = marketplaceDeliveryItem.getDeliveryStatic().getSelectCity();
            if (selectCity != null) {
                str = selectCity;
            }
            a(view, textView, str);
        }
        textView.setOnClickListener(new a2.a.a.f.x.x.a(listener));
    }
}
