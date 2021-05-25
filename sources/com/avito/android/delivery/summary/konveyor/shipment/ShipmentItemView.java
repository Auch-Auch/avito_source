package com.avito.android.delivery.summary.konveyor.shipment;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.avito.android.delivery.R;
import com.avito.android.lib.expected.badge_bar.BadgeView;
import com.avito.android.remote.model.delivery.DeliverySummaryRds;
import com.avito.android.remote.model.text.AttributedText;
import com.avito.android.util.Contexts;
import com.avito.android.util.Images;
import com.avito.android.util.SimpleDraweeView;
import com.avito.android.util.SimpleDraweeViewsKt;
import com.avito.android.util.TextViews;
import com.avito.android.util.text.AttributedTextFormatter;
import com.avito.android.util.text.TextViewsKt;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.android.flexbox.FlexboxLayout;
import com.vk.sdk.api.VKApiConst;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010'\u001a\u00020&\u0012\u0006\u0010#\u001a\u00020 ¢\u0006\u0004\b(\u0010)J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\u001b\u0010\u000e\u001a\u00020\u00042\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u001e\u0010\u001c\u001a\n \u0019*\u0004\u0018\u00010\u00180\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010%\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010\u0012¨\u0006*"}, d2 = {"Lcom/avito/android/delivery/summary/konveyor/shipment/ShipmentItemView;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "", "title", "", "setTitle", "(Ljava/lang/String;)V", "Lcom/avito/android/remote/model/text/AttributedText;", MessengerShareContentUtility.SUBTITLE, "setSubtitle", "(Lcom/avito/android/remote/model/text/AttributedText;)V", "", "Lcom/avito/android/remote/model/delivery/DeliverySummaryRds$ShipmentsGroup$Shipment$Item;", "items", "setItems", "(Ljava/util/List;)V", "Landroid/widget/TextView;", "u", "Landroid/widget/TextView;", "subtitleView", "Lcom/google/android/flexbox/FlexboxLayout;", VKApiConst.VERSION, "Lcom/google/android/flexbox/FlexboxLayout;", "itemsLayout", "Landroid/view/LayoutInflater;", "kotlin.jvm.PlatformType", "s", "Landroid/view/LayoutInflater;", "inflater", "w", "Ljava/util/List;", "inflatedShipmentItems", "Lcom/avito/android/util/text/AttributedTextFormatter;", "x", "Lcom/avito/android/util/text/AttributedTextFormatter;", "attributedTextFormatter", "t", "titleView", "Landroid/view/ViewGroup;", "view", "<init>", "(Landroid/view/ViewGroup;Lcom/avito/android/util/text/AttributedTextFormatter;)V", "delivery_release"}, k = 1, mv = {1, 4, 2})
public final class ShipmentItemView extends BaseViewHolder {
    public final LayoutInflater s;
    public final TextView t;
    public final TextView u;
    public final FlexboxLayout v;
    public List<DeliverySummaryRds.ShipmentsGroup.Shipment.Item> w = CollectionsKt__CollectionsKt.emptyList();
    public final AttributedTextFormatter x;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ShipmentItemView(@NotNull ViewGroup viewGroup, @NotNull AttributedTextFormatter attributedTextFormatter) {
        super(viewGroup);
        Intrinsics.checkNotNullParameter(viewGroup, "view");
        Intrinsics.checkNotNullParameter(attributedTextFormatter, "attributedTextFormatter");
        this.x = attributedTextFormatter;
        this.s = LayoutInflater.from(viewGroup.getContext());
        View findViewById = viewGroup.findViewById(R.id.title);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
        this.t = (TextView) findViewById;
        View findViewById2 = viewGroup.findViewById(R.id.subtitle);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
        this.u = (TextView) findViewById2;
        View findViewById3 = viewGroup.findViewById(R.id.items_list);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type com.google.android.flexbox.FlexboxLayout");
        this.v = (FlexboxLayout) findViewById3;
    }

    public final void setItems(@NotNull List<DeliverySummaryRds.ShipmentsGroup.Shipment.Item> list) {
        Intrinsics.checkNotNullParameter(list, "items");
        if (!Intrinsics.areEqual(list, this.w)) {
            this.v.removeAllViews();
            for (T t2 : list) {
                FlexboxLayout flexboxLayout = this.v;
                View inflate = this.s.inflate(R.layout.delivery_badged_image, (ViewGroup) flexboxLayout, false);
                Intrinsics.checkNotNullExpressionValue(inflate, "view");
                View findViewById = inflate.findViewById(R.id.image);
                Objects.requireNonNull(findViewById, "null cannot be cast to non-null type com.avito.android.util.SimpleDraweeView");
                SimpleDraweeView simpleDraweeView = (SimpleDraweeView) findViewById;
                Uri height = Images.fit$default(t2.getImage(), simpleDraweeView, 0.0f, 0.0f, 2, 6, null).height();
                if (height == null) {
                    SimpleDraweeViewsKt.getRequestBuilder(simpleDraweeView).clear();
                } else {
                    SimpleDraweeViewsKt.getRequestBuilder(simpleDraweeView).uri(height).load();
                }
                View findViewById2 = inflate.findViewById(R.id.badge);
                Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type com.avito.android.lib.expected.badge_bar.BadgeView");
                BadgeView badgeView = (BadgeView) findViewById2;
                Context context = badgeView.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "badge.context");
                badgeView.setBackgroundColor(Contexts.getColorByAttr(context, com.avito.android.lib.design.R.attr.white));
                TextViews.bindText$default(badgeView, t2.getBadge(), false, 2, null);
                flexboxLayout.addView(inflate);
            }
            this.w = list;
        }
    }

    public final void setSubtitle(@Nullable AttributedText attributedText) {
        TextViewsKt.bindAttributedText(this.u, attributedText, this.x);
    }

    public final void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        this.t.setText(str);
    }
}
