package com.avito.android.advert.item.marketplace_info;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.avito.android.advert_details.R;
import com.avito.android.lib.design.button.Button;
import com.avito.android.util.TextViews;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.vk.sdk.api.VKApiConst;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\"\u001a\u00020\u001f¢\u0006\u0004\b&\u0010'J!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\f\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\f\u0010\rR\u001e\u0010\u0012\u001a\n \u000f*\u0004\u0018\u00010\u000e0\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010%\u001a\u00020#8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010$¨\u0006("}, d2 = {"Lcom/avito/android/advert/item/marketplace_info/MarketplaceInfoViewImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/advert/item/marketplace_info/MarketplaceInfoView;", "Lcom/avito/android/advert/item/marketplace_info/MarketplaceInfoItem;", "item", "Landroid/view/View$OnClickListener;", "clickListener", "", "showInfo", "(Lcom/avito/android/advert/item/marketplace_info/MarketplaceInfoItem;Landroid/view/View$OnClickListener;)V", "onUnbind", "()V", "t", "(Lcom/avito/android/advert/item/marketplace_info/MarketplaceInfoItem;)V", "Landroid/view/LayoutInflater;", "kotlin.jvm.PlatformType", "s", "Landroid/view/LayoutInflater;", "inflater", "Lcom/avito/android/advert/item/marketplace_info/MarketplaceInfoDialog;", "w", "Lcom/avito/android/advert/item/marketplace_info/MarketplaceInfoDialog;", "dialog", "Lcom/avito/android/lib/design/button/Button;", "u", "Lcom/avito/android/lib/design/button/Button;", "infoButton", "Landroid/widget/LinearLayout;", VKApiConst.VERSION, "Landroid/widget/LinearLayout;", "infoContainer", "Landroid/view/View;", "x", "Landroid/view/View;", "view", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "infoTitle", "<init>", "(Landroid/view/View;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class MarketplaceInfoViewImpl extends BaseViewHolder implements MarketplaceInfoView {
    public final LayoutInflater s;
    public final TextView t;
    public final Button u;
    public final LinearLayout v;
    public MarketplaceInfoDialog w;
    public final View x;

    public static final class a implements DialogInterface.OnDismissListener {
        public final /* synthetic */ MarketplaceInfoItem a;

        public a(MarketplaceInfoItem marketplaceInfoItem) {
            this.a = marketplaceInfoItem;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public final void onDismiss(DialogInterface dialogInterface) {
            this.a.setDialogShown(false);
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ MarketplaceInfoViewImpl a;
        public final /* synthetic */ View.OnClickListener b;
        public final /* synthetic */ MarketplaceInfoItem c;

        public b(MarketplaceInfoViewImpl marketplaceInfoViewImpl, View.OnClickListener onClickListener, MarketplaceInfoItem marketplaceInfoItem) {
            this.a = marketplaceInfoViewImpl;
            this.b = onClickListener;
            this.c = marketplaceInfoItem;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.b.onClick(view);
            this.a.t(this.c);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MarketplaceInfoViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        this.x = view;
        this.s = LayoutInflater.from(view.getContext());
        View findViewById = view.findViewById(R.id.marketplace_info_title);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.marketplace_info_title)");
        this.t = (TextView) findViewById;
        View findViewById2 = view.findViewById(R.id.marketplace_info_button);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.marketplace_info_button)");
        this.u = (Button) findViewById2;
        View findViewById3 = view.findViewById(R.id.marketplace_info_container);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.marketplace_info_container)");
        this.v = (LinearLayout) findViewById3;
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        MarketplaceInfoDialog marketplaceInfoDialog = this.w;
        if (marketplaceInfoDialog != null) {
            marketplaceInfoDialog.dismiss();
        }
    }

    @Override // com.avito.android.advert.item.marketplace_info.MarketplaceInfoView
    public void showInfo(@NotNull MarketplaceInfoItem marketplaceInfoItem, @Nullable View.OnClickListener onClickListener) {
        Intrinsics.checkNotNullParameter(marketplaceInfoItem, "item");
        TextViews.bindText$default(this.t, marketplaceInfoItem.getInfoBanner().getTitle(), false, 2, null);
        if (this.v.getChildCount() == 0) {
            Iterator<T> it = marketplaceInfoItem.getInfoBanner().getItems().iterator();
            while (it.hasNext()) {
                View inflate = this.s.inflate(R.layout.marketplace_info_item, (ViewGroup) this.v, false);
                TextView textView = (TextView) inflate.findViewById(R.id.marketplace_info_item_text);
                Intrinsics.checkNotNullExpressionValue(textView, "textView");
                textView.setText(it.next().getTitle());
                this.v.addView(inflate);
            }
        }
        this.u.setText(marketplaceInfoItem.getInfoBanner().getAction().getTitle());
        if (onClickListener != null) {
            this.u.setOnClickListener(new b(this, onClickListener, marketplaceInfoItem));
        }
        if (marketplaceInfoItem.isDialogShown()) {
            t(marketplaceInfoItem);
        }
    }

    public final void t(MarketplaceInfoItem marketplaceInfoItem) {
        Context context = this.x.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        MarketplaceInfoDialog marketplaceInfoDialog = new MarketplaceInfoDialog(context, marketplaceInfoItem.getInfoBanner().getPopup());
        this.w = marketplaceInfoDialog;
        if (marketplaceInfoDialog != null) {
            marketplaceInfoDialog.show();
        }
        marketplaceInfoItem.setDialogShown(true);
        MarketplaceInfoDialog marketplaceInfoDialog2 = this.w;
        if (marketplaceInfoDialog2 != null) {
            marketplaceInfoDialog2.setOnDismissListener(new a(marketplaceInfoItem));
        }
    }
}
