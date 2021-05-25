package com.avito.android.advert.item.marketplace_specs;

import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.widget.TextView;
import com.avito.android.advert.item.marketplace_specs.MarketplaceSpecsPresenter;
import com.avito.android.advert_core.advert.AdvertDetailsFlatView;
import com.avito.android.advert_core.advert.AdvertDetailsFlatViewImpl;
import com.avito.android.advert_details.R;
import com.avito.android.remote.model.AdvertParameters;
import com.avito.android.remote.model.ModelSpecifications;
import com.avito.android.util.TextViews;
import com.avito.android.util.Views;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u000e¢\u0006\u0004\b\u001f\u0010 J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\f\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001e\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u0014¨\u0006!"}, d2 = {"Lcom/avito/android/advert/item/marketplace_specs/MarketplaceSpecsViewImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/advert/item/marketplace_specs/MarketplaceSpecsView;", "Lcom/avito/android/advert/item/marketplace_specs/MarketplaceSpecsItem;", "item", "Lcom/avito/android/advert/item/marketplace_specs/MarketplaceSpecsPresenter$Listener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "", "showSpecs", "(Lcom/avito/android/advert/item/marketplace_specs/MarketplaceSpecsItem;Lcom/avito/android/advert/item/marketplace_specs/MarketplaceSpecsPresenter$Listener;)V", "onUnbind", "()V", "t", "(Lcom/avito/android/advert/item/marketplace_specs/MarketplaceSpecsItem;)V", "Landroid/view/View;", "w", "Landroid/view/View;", "view", "Landroid/widget/TextView;", "s", "Landroid/widget/TextView;", "specsTitle", "Lcom/avito/android/advert_core/advert/AdvertDetailsFlatView;", "u", "Lcom/avito/android/advert_core/advert/AdvertDetailsFlatView;", "flatsView", "Lcom/avito/android/advert/item/marketplace_specs/MarketplaceSpecsDialog;", VKApiConst.VERSION, "Lcom/avito/android/advert/item/marketplace_specs/MarketplaceSpecsDialog;", "dialog", "specsButton", "<init>", "(Landroid/view/View;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class MarketplaceSpecsViewImpl extends BaseViewHolder implements MarketplaceSpecsView {
    public final TextView s;
    public final TextView t;
    public final AdvertDetailsFlatView u;
    public MarketplaceSpecsDialog v;
    public final View w;

    public static final class a implements DialogInterface.OnDismissListener {
        public final /* synthetic */ MarketplaceSpecsItem a;

        public a(MarketplaceSpecsItem marketplaceSpecsItem) {
            this.a = marketplaceSpecsItem;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public final void onDismiss(DialogInterface dialogInterface) {
            this.a.setDialogShown(false);
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ MarketplaceSpecsViewImpl a;
        public final /* synthetic */ MarketplaceSpecsItem b;
        public final /* synthetic */ MarketplaceSpecsPresenter.Listener c;

        public b(MarketplaceSpecsViewImpl marketplaceSpecsViewImpl, MarketplaceSpecsItem marketplaceSpecsItem, MarketplaceSpecsPresenter.Listener listener) {
            this.a = marketplaceSpecsViewImpl;
            this.b = marketplaceSpecsItem;
            this.c = listener;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.t(this.b);
            this.c.onMarketplaceSpecsClick();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MarketplaceSpecsViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        this.w = view;
        View findViewById = view.findViewById(R.id.marketplace_specs_title);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.marketplace_specs_title)");
        this.s = (TextView) findViewById;
        View findViewById2 = view.findViewById(R.id.marketplace_specs_button);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.marketplace_specs_button)");
        this.t = (TextView) findViewById2;
        this.u = new AdvertDetailsFlatViewImpl(view, null, null, true, false, 16, null);
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        MarketplaceSpecsDialog marketplaceSpecsDialog = this.v;
        if (marketplaceSpecsDialog != null) {
            marketplaceSpecsDialog.dismiss();
        }
    }

    @Override // com.avito.android.advert.item.marketplace_specs.MarketplaceSpecsView
    public void showSpecs(@NotNull MarketplaceSpecsItem marketplaceSpecsItem, @NotNull MarketplaceSpecsPresenter.Listener listener) {
        Intrinsics.checkNotNullParameter(marketplaceSpecsItem, "item");
        Intrinsics.checkNotNullParameter(listener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        TextViews.bindText$default(this.s, marketplaceSpecsItem.getTitle(), false, 2, null);
        AdvertDetailsFlatView advertDetailsFlatView = this.u;
        List<ModelSpecifications.Parameter> previewSpecs = marketplaceSpecsItem.getPreviewSpecs();
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(previewSpecs, 10));
        for (T t2 : previewSpecs) {
            arrayList.add(new AdvertParameters.Parameter(t2.getName(), CollectionsKt__CollectionsKt.emptyList(), t2.getValue(), null));
        }
        advertDetailsFlatView.bind(arrayList);
        if (marketplaceSpecsItem.getShowMore()) {
            this.t.setText(marketplaceSpecsItem.getButtonTitle());
            this.t.setOnClickListener(new b(this, marketplaceSpecsItem, listener));
        }
        Views.setVisible(this.t, marketplaceSpecsItem.getShowMore());
        if (marketplaceSpecsItem.isDialogShown()) {
            t(marketplaceSpecsItem);
        }
    }

    public final void t(MarketplaceSpecsItem marketplaceSpecsItem) {
        Context context = this.w.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        MarketplaceSpecsDialog marketplaceSpecsDialog = new MarketplaceSpecsDialog(context, marketplaceSpecsItem.getSpecs());
        this.v = marketplaceSpecsDialog;
        if (marketplaceSpecsDialog != null) {
            marketplaceSpecsDialog.show();
        }
        marketplaceSpecsItem.setDialogShown(true);
        MarketplaceSpecsDialog marketplaceSpecsDialog2 = this.v;
        if (marketplaceSpecsDialog2 != null) {
            marketplaceSpecsDialog2.setOnDismissListener(new a(marketplaceSpecsItem));
        }
    }
}
