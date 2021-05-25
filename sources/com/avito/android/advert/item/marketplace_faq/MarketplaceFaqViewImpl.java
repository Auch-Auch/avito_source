package com.avito.android.advert.item.marketplace_faq;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.avito.android.advert.item.marketplace_faq.MarketplaceFaqPresenter;
import com.avito.android.advert_details.R;
import com.avito.android.lib.design.button.Button;
import com.avito.android.remote.model.AdvertParameters;
import com.avito.android.util.TextViews;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u000e¢\u0006\u0004\b$\u0010%J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\f\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0013\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0010R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u001e\u0010\u001c\u001a\n \u0019*\u0004\u0018\u00010\u00180\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001f\u001a\u00020\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"¨\u0006&"}, d2 = {"Lcom/avito/android/advert/item/marketplace_faq/MarketplaceFaqViewImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/advert/item/marketplace_faq/MarketplaceFaqView;", "Lcom/avito/android/advert/item/marketplace_faq/MarketplaceFaqItem;", "item", "Lcom/avito/android/advert/item/marketplace_faq/MarketplaceFaqPresenter$Listener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "", "showFaq", "(Lcom/avito/android/advert/item/marketplace_faq/MarketplaceFaqItem;Lcom/avito/android/advert/item/marketplace_faq/MarketplaceFaqPresenter$Listener;)V", "onUnbind", "()V", "t", "(Lcom/avito/android/advert/item/marketplace_faq/MarketplaceFaqItem;)V", "Landroid/view/View;", VKApiConst.VERSION, "Landroid/view/View;", "actionButton", "x", "view", "Lcom/avito/android/advert/item/marketplace_faq/MarketplaceFaqDialog;", "w", "Lcom/avito/android/advert/item/marketplace_faq/MarketplaceFaqDialog;", "dialog", "Landroid/view/LayoutInflater;", "kotlin.jvm.PlatformType", "s", "Landroid/view/LayoutInflater;", "inflater", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "titleTextView", "Landroid/widget/LinearLayout;", "u", "Landroid/widget/LinearLayout;", "faqContainer", "<init>", "(Landroid/view/View;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class MarketplaceFaqViewImpl extends BaseViewHolder implements MarketplaceFaqView {
    public final LayoutInflater s;
    public final TextView t;
    public final LinearLayout u;
    public final View v;
    public MarketplaceFaqDialog w;
    public final View x;

    public static final class a implements DialogInterface.OnDismissListener {
        public final /* synthetic */ MarketplaceFaqItem a;

        public a(MarketplaceFaqItem marketplaceFaqItem) {
            this.a = marketplaceFaqItem;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public final void onDismiss(DialogInterface dialogInterface) {
            this.a.setDialogShown(false);
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ MarketplaceFaqViewImpl a;
        public final /* synthetic */ MarketplaceFaqItem b;
        public final /* synthetic */ MarketplaceFaqPresenter.Listener c;

        public b(MarketplaceFaqViewImpl marketplaceFaqViewImpl, MarketplaceFaqItem marketplaceFaqItem, MarketplaceFaqPresenter.Listener listener) {
            this.a = marketplaceFaqViewImpl;
            this.b = marketplaceFaqItem;
            this.c = listener;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.t(this.b);
            this.c.onMarketplaceFaqClick();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MarketplaceFaqViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        this.x = view;
        this.s = LayoutInflater.from(view.getContext());
        View findViewById = view.findViewById(R.id.marketplace_faq_title);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.marketplace_faq_title)");
        this.t = (TextView) findViewById;
        View findViewById2 = view.findViewById(R.id.marketplace_faq_container);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.marketplace_faq_container)");
        this.u = (LinearLayout) findViewById2;
        View findViewById3 = view.findViewById(R.id.marketplace_faq_action);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.marketplace_faq_action)");
        this.v = findViewById3;
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        MarketplaceFaqDialog marketplaceFaqDialog = this.w;
        if (marketplaceFaqDialog != null) {
            marketplaceFaqDialog.dismiss();
        }
    }

    @Override // com.avito.android.advert.item.marketplace_faq.MarketplaceFaqView
    public void showFaq(@NotNull MarketplaceFaqItem marketplaceFaqItem, @NotNull MarketplaceFaqPresenter.Listener listener) {
        Intrinsics.checkNotNullParameter(marketplaceFaqItem, "item");
        Intrinsics.checkNotNullParameter(listener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        TextViews.bindText$default(this.t, marketplaceFaqItem.getFaq().getTitle(), false, 2, null);
        if (this.u.getChildCount() == 0) {
            for (AdvertParameters.Parameter parameter : CollectionsKt___CollectionsKt.take(marketplaceFaqItem.getFaq().getItems(), marketplaceFaqItem.getFaq().getDisplayCount())) {
                View inflate = this.s.inflate(R.layout.marketplace_faq_item, (ViewGroup) this.u, false);
                TextView textView = (TextView) inflate.findViewById(R.id.marketplace_faq_item_title);
                textView.setMaxLines(2);
                textView.setEllipsize(TextUtils.TruncateAt.END);
                textView.setText(parameter.getTitle());
                TextView textView2 = (TextView) inflate.findViewById(R.id.marketplace_faq_item_description);
                textView2.setMaxLines(3);
                textView2.setEllipsize(TextUtils.TruncateAt.END);
                textView2.setText(parameter.getDescription());
                this.u.addView(inflate);
            }
        }
        String title = marketplaceFaqItem.getFaq().getAction().getTitle();
        View view = this.v;
        if (view instanceof Button) {
            ((Button) view).setText(title);
        } else if (view instanceof TextView) {
            ((TextView) view).setText(title);
        }
        this.v.setOnClickListener(new b(this, marketplaceFaqItem, listener));
        if (marketplaceFaqItem.isDialogShown()) {
            t(marketplaceFaqItem);
        }
    }

    public final void t(MarketplaceFaqItem marketplaceFaqItem) {
        Context context = this.x.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        MarketplaceFaqDialog marketplaceFaqDialog = new MarketplaceFaqDialog(context, marketplaceFaqItem.getFaq().getTitle(), marketplaceFaqItem.getFaq().getItems());
        this.w = marketplaceFaqDialog;
        if (marketplaceFaqDialog != null) {
            marketplaceFaqDialog.show();
        }
        marketplaceFaqItem.setDialogShown(true);
        MarketplaceFaqDialog marketplaceFaqDialog2 = this.w;
        if (marketplaceFaqDialog2 != null) {
            marketplaceFaqDialog2.setOnDismissListener(new a(marketplaceFaqItem));
        }
    }
}
