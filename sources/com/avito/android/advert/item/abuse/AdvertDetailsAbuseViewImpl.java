package com.avito.android.advert.item.abuse;

import android.view.View;
import android.widget.TextView;
import com.avito.android.advert_details.R;
import com.avito.konveyor.adapter.BaseViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\u0010"}, d2 = {"Lcom/avito/android/advert/item/abuse/AdvertDetailsAbuseViewImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/advert/item/abuse/AdvertDetailsAbuseView;", "Landroid/view/View$OnClickListener;", "clickListener", "", "setListener", "(Landroid/view/View$OnClickListener;)V", "Landroid/widget/TextView;", "s", "Landroid/widget/TextView;", "abuseButton", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertDetailsAbuseViewImpl extends BaseViewHolder implements AdvertDetailsAbuseView {
    public final TextView s;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AdvertDetailsAbuseViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        View findViewById = view.findViewById(R.id.btn_abuse);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.btn_abuse)");
        this.s = (TextView) findViewById;
    }

    @Override // com.avito.android.advert.item.abuse.AdvertDetailsAbuseView
    public void setListener(@NotNull View.OnClickListener onClickListener) {
        Intrinsics.checkNotNullParameter(onClickListener, "clickListener");
        this.s.setOnClickListener(onClickListener);
    }
}
