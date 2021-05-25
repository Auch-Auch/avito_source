package com.avito.android.advert.item.disclaimer;

import android.view.View;
import android.widget.TextView;
import com.avito.android.advert_details.R;
import com.avito.android.tariff.tariff_package_info.viewmodel.TariffPackageInfoConverterKt;
import com.avito.android.util.TextViews;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0012\u001a\u00020\f¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/avito/android/advert/item/disclaimer/AdvertDetailsDisclaimerViewImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/advert/item/disclaimer/AdvertDetailsDisclaimerView;", "Lcom/avito/android/advert/item/disclaimer/DisclaimerData;", "disclaimerData", "", "showDisclaimer", "(Lcom/avito/android/advert/item/disclaimer/DisclaimerData;)V", "Landroid/widget/TextView;", "u", "Landroid/widget/TextView;", SDKConstants.PARAM_A2U_BODY, "Landroid/view/View;", "s", "Landroid/view/View;", "viewDisclaimer", "t", TariffPackageInfoConverterKt.HEADER_STRING_ID, "view", "<init>", "(Landroid/view/View;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertDetailsDisclaimerViewImpl extends BaseViewHolder implements AdvertDetailsDisclaimerView {
    public View s;
    public TextView t;
    public TextView u;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AdvertDetailsDisclaimerViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        View findViewById = view.findViewById(R.id.advert_disclaimer_container);
        this.s = findViewById;
        TextView textView = null;
        this.t = findViewById != null ? (TextView) findViewById.findViewById(R.id.disclaimer_header) : null;
        View view2 = this.s;
        this.u = view2 != null ? (TextView) view2.findViewById(R.id.disclaimer_body) : textView;
    }

    @Override // com.avito.android.advert.item.disclaimer.AdvertDetailsDisclaimerView
    public void showDisclaimer(@NotNull DisclaimerData disclaimerData) {
        Intrinsics.checkNotNullParameter(disclaimerData, "disclaimerData");
        TextView textView = this.t;
        if (textView != null) {
            TextViews.bindText$default(textView, disclaimerData.getHeader(), false, 2, null);
        }
        TextView textView2 = this.u;
        if (textView2 != null) {
            TextViews.bindText$default(textView2, disclaimerData.getBody(), false, 2, null);
        }
    }
}
