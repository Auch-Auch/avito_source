package com.avito.android.publish.slots.market_price_v2.item;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.avito.android.publish.R;
import com.avito.android.util.TextViews;
import com.avito.android.util.Views;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.vk.sdk.api.VKApiConst;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.spongycastle.i18n.ErrorBundle;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010(\u001a\u00020'¢\u0006\u0004\b)\u0010*J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\t\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\t\u0010\u0007J\u000f\u0010\n\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\n\u0010\u000bJ!\u0010\u0010\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0013\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0019\u001a\n \u0016*\u0004\u0018\u00010\u00150\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u001e\u0010\u001d\u001a\n \u0016*\u0004\u0018\u00010\u001a0\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u001c\u0010#\u001a\u00020\u001e8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u001e\u0010%\u001a\n \u0016*\u0004\u0018\u00010\u00150\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010\u0018R\u001e\u0010\u0012\u001a\n \u0016*\u0004\u0018\u00010\u00150\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010\u0018¨\u0006+"}, d2 = {"Lcom/avito/android/publish/slots/market_price_v2/item/MarketPriceV2ViewImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/publish/slots/market_price_v2/item/MarketPriceV2View;", "", "description", "", "setMarketPriceDescription", "(Ljava/lang/CharSequence;)V", ErrorBundle.DETAIL_ENTRY, "setMarketPriceDetails", "clearNotices", "()V", "", "notice", "", "markColor", "addNotice", "(Ljava/lang/String;Ljava/lang/Integer;)V", "callout", "setCallout", "(Ljava/lang/String;)V", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "s", "Landroid/widget/TextView;", "marketPriceDescription", "Landroid/widget/LinearLayout;", "u", "Landroid/widget/LinearLayout;", "noticesContainer", "Landroid/content/Context;", "w", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "t", "marketPriceDetails", VKApiConst.VERSION, "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class MarketPriceV2ViewImpl extends BaseViewHolder implements MarketPriceV2View {
    public final TextView s;
    public final TextView t;
    public final LinearLayout u;
    public final TextView v;
    @NotNull
    public final Context w;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MarketPriceV2ViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        this.s = (TextView) view.findViewById(R.id.market_price_description);
        TextView textView = (TextView) view.findViewById(R.id.market_price_details);
        this.t = textView;
        this.u = (LinearLayout) view.findViewById(R.id.notices_container);
        this.v = (TextView) view.findViewById(R.id.callout);
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        this.w = context;
        Intrinsics.checkNotNullExpressionValue(textView, "marketPriceDetails");
        textView.setMovementMethod(LinkMovementMethod.getInstance());
    }

    @Override // com.avito.android.publish.slots.market_price_v2.item.MarketPriceV2View
    public void addNotice(@NotNull String str, @Nullable Integer num) {
        Intrinsics.checkNotNullParameter(str, "notice");
        LinearLayout linearLayout = this.u;
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.market_price_notice, (ViewGroup) this.u, false);
        Objects.requireNonNull(inflate, "null cannot be cast to non-null type android.widget.LinearLayout");
        LinearLayout linearLayout2 = (LinearLayout) inflate;
        TextView textView = (TextView) linearLayout2.findViewById(R.id.notice);
        Intrinsics.checkNotNullExpressionValue(textView, "noticeView");
        textView.setText(str);
        if (num != null) {
            View findViewById = linearLayout2.findViewById(R.id.mark);
            ShapeDrawable shapeDrawable = new ShapeDrawable(new OvalShape());
            Paint paint = shapeDrawable.getPaint();
            Intrinsics.checkNotNullExpressionValue(paint, "shape.paint");
            paint.setColor(num.intValue());
            Intrinsics.checkNotNullExpressionValue(findViewById, "mark");
            findViewById.setBackground(shapeDrawable);
            Views.show(findViewById);
        }
        linearLayout.addView(linearLayout2);
    }

    @Override // com.avito.android.publish.slots.market_price_v2.item.MarketPriceV2View
    public void clearNotices() {
        this.u.removeAllViews();
    }

    @Override // com.avito.android.publish.slots.market_price_v2.item.MarketPriceV2View
    @NotNull
    public Context getContext() {
        return this.w;
    }

    @Override // com.avito.android.publish.slots.market_price_v2.item.MarketPriceV2View
    public void setCallout(@Nullable String str) {
        TextView textView = this.v;
        Intrinsics.checkNotNullExpressionValue(textView, "this.callout");
        TextViews.bindText$default(textView, str, false, 2, null);
    }

    @Override // com.avito.android.publish.slots.market_price_v2.item.MarketPriceV2View
    public void setMarketPriceDescription(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "description");
        TextView textView = this.s;
        Intrinsics.checkNotNullExpressionValue(textView, "marketPriceDescription");
        textView.setText(charSequence);
    }

    @Override // com.avito.android.publish.slots.market_price_v2.item.MarketPriceV2View
    public void setMarketPriceDetails(@Nullable CharSequence charSequence) {
        TextView textView = this.t;
        Intrinsics.checkNotNullExpressionValue(textView, "marketPriceDetails");
        TextViews.bindText$default(textView, charSequence, false, 2, null);
    }
}
