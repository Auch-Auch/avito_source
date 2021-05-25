package com.avito.android.advert.item.marketplace_brief_specs;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.avito.android.advert.item.marketplace_brief_specs.MarketplaceBriefSpecsPresenter;
import com.avito.android.advert_core.advert.AdvertDetailsFlatView;
import com.avito.android.advert_core.advert.AdvertDetailsFlatViewImpl;
import com.avito.android.advert_details.R;
import com.avito.android.lib.design.tooltip.AnchorPositions;
import com.avito.android.lib.design.tooltip.TailPositions;
import com.avito.android.lib.design.tooltip.Tooltip;
import com.avito.android.lib.design.tooltip.TooltipContentKt;
import com.avito.android.lib.design.tooltip.TooltipPositions;
import com.avito.android.remote.marketplace.InStock;
import com.avito.android.remote.marketplace.SpecificationItem;
import com.avito.android.util.TextViews;
import com.avito.android.util.Views;
import com.avito.android.util.text.AttributedTextFormatter;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010 \u001a\u00020\u001d\u0012\u0006\u0010\u0010\u001a\u00020\r¢\u0006\u0004\b!\u0010\"J/\u0010\u000b\u001a\u00020\n2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f¨\u0006#"}, d2 = {"Lcom/avito/android/advert/item/marketplace_brief_specs/MarketplaceBriefSpecsViewImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/advert/item/marketplace_brief_specs/MarketplaceBriefSpecsView;", "", "Lcom/avito/android/remote/marketplace/SpecificationItem;", "params", "Lcom/avito/android/remote/marketplace/InStock;", "inStock", "Lcom/avito/android/advert/item/marketplace_brief_specs/MarketplaceBriefSpecsPresenter$Listener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "", "showSpecs", "(Ljava/util/List;Lcom/avito/android/remote/marketplace/InStock;Lcom/avito/android/advert/item/marketplace_brief_specs/MarketplaceBriefSpecsPresenter$Listener;)V", "Lcom/avito/android/util/text/AttributedTextFormatter;", "w", "Lcom/avito/android/util/text/AttributedTextFormatter;", "textFormatter", "Landroid/widget/ImageView;", "t", "Landroid/widget/ImageView;", "availableIcon", "Landroid/widget/TextView;", "s", "Landroid/widget/TextView;", "availableTextView", "Lcom/avito/android/advert_core/advert/AdvertDetailsFlatView;", "u", "Lcom/avito/android/advert_core/advert/AdvertDetailsFlatView;", "flatsView", "Landroid/view/View;", VKApiConst.VERSION, "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;Lcom/avito/android/util/text/AttributedTextFormatter;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class MarketplaceBriefSpecsViewImpl extends BaseViewHolder implements MarketplaceBriefSpecsView {
    public final TextView s;
    public final ImageView t;
    public final AdvertDetailsFlatView u;
    public final View v;
    public final AttributedTextFormatter w;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ InStock a;
        public final /* synthetic */ MarketplaceBriefSpecsViewImpl b;
        public final /* synthetic */ MarketplaceBriefSpecsPresenter.Listener c;

        public a(InStock inStock, MarketplaceBriefSpecsViewImpl marketplaceBriefSpecsViewImpl, InStock inStock2, MarketplaceBriefSpecsPresenter.Listener listener) {
            this.a = inStock;
            this.b = marketplaceBriefSpecsViewImpl;
            this.c = listener;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            String popup = this.a.getPopup();
            if (popup == null) {
                popup = "";
            }
            if (popup.length() > 0) {
                MarketplaceBriefSpecsViewImpl marketplaceBriefSpecsViewImpl = this.b;
                Intrinsics.checkNotNullExpressionValue(view, "it");
                MarketplaceBriefSpecsViewImpl.access$showTooltip(marketplaceBriefSpecsViewImpl, view, popup);
            }
            this.c.onInfoClick();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MarketplaceBriefSpecsViewImpl(@NotNull View view, @NotNull AttributedTextFormatter attributedTextFormatter) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(attributedTextFormatter, "textFormatter");
        this.v = view;
        this.w = attributedTextFormatter;
        View findViewById = view.findViewById(R.id.marketplace_brief_available_text);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.m…ace_brief_available_text)");
        this.s = (TextView) findViewById;
        View findViewById2 = view.findViewById(R.id.marketplace_brief_info_icon);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.m…ketplace_brief_info_icon)");
        this.t = (ImageView) findViewById2;
        this.u = new AdvertDetailsFlatViewImpl(view, attributedTextFormatter, null, true, false, 16, null);
    }

    public static final void access$showTooltip(MarketplaceBriefSpecsViewImpl marketplaceBriefSpecsViewImpl, View view, String str) {
        Objects.requireNonNull(marketplaceBriefSpecsViewImpl);
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        TooltipContentKt.content(new Tooltip(context, 0, 0, 6, null).setTooltipPosition(new TooltipPositions.Top(new TailPositions.Start(new AnchorPositions.Center()))), new a2.a.a.f.x.w.a(str)).show(view);
    }

    @Override // com.avito.android.advert.item.marketplace_brief_specs.MarketplaceBriefSpecsView
    public void showSpecs(@NotNull List<SpecificationItem> list, @Nullable InStock inStock, @NotNull MarketplaceBriefSpecsPresenter.Listener listener) {
        Intrinsics.checkNotNullParameter(list, "params");
        Intrinsics.checkNotNullParameter(listener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.u.bindOneColumn(list);
        if (inStock != null) {
            TextView textView = this.s;
            AttributedTextFormatter attributedTextFormatter = this.w;
            Context context = this.v.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "view.context");
            boolean z = false;
            TextViews.bindText$default(textView, attributedTextFormatter.format(context, inStock.getTitle()), false, 2, null);
            String popup = inStock.getPopup();
            if (popup != null) {
                if (popup.length() > 0) {
                    z = true;
                }
            }
            if (z) {
                Views.show(this.t);
                this.t.setOnClickListener(new a(inStock, this, inStock, listener));
                return;
            }
            Views.hide(this.t);
            this.t.setOnClickListener(null);
        }
    }
}
