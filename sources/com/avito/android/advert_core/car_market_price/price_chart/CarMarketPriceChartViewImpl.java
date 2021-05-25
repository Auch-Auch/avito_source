package com.avito.android.advert_core.car_market_price.price_chart;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.method.LinkMovementMethod;
import android.view.MotionEvent;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.avito.android.advert_core.R;
import com.avito.android.remote.model.UniversalColor;
import com.avito.android.util.TextViews;
import com.avito.android.util.color.ContextsKt;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.spongycastle.i18n.ErrorBundle;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u00107\u001a\u000202¢\u0006\u0004\b8\u00109J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\t\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\t\u0010\u0007J\u0019\u0010\f\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJG\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u001f\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u001e\u0010\u001fR\u0016\u0010#\u001a\u00020 8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u001e\u0010(\u001a\n %*\u0004\u0018\u00010$0$8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u001e\u0010\u0004\u001a\n %*\u0004\u0018\u00010)0)8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u001e\u0010\u000b\u001a\n %*\u0004\u0018\u00010)0)8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b,\u0010+R\u001e\u0010\b\u001a\n %*\u0004\u0018\u00010)0)8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b-\u0010+R\u001e\u00101\u001a\n %*\u0004\u0018\u00010.0.8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u0019\u00107\u001a\u0002028\u0006@\u0006¢\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u00106¨\u0006:"}, d2 = {"Lcom/avito/android/advert_core/car_market_price/price_chart/CarMarketPriceChartViewImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/advert_core/car_market_price/price_chart/CarMarketPriceChartView;", "", "title", "", "setTitle", "(Ljava/lang/String;)V", MessengerShareContentUtility.SUBTITLE, "setSubtitle", "", ErrorBundle.DETAIL_ENTRY, "setDetails", "(Ljava/lang/CharSequence;)V", "clearChartSections", "()V", "Lcom/avito/android/remote/model/UniversalColor;", "titleColor", "lineColor", "", "lineCornersRadii", "", "isAccented", "", ViewHierarchyConstants.DIMENSION_WIDTH_KEY, "marginEnd", "addChartSection", "(Ljava/lang/String;Lcom/avito/android/remote/model/UniversalColor;Lcom/avito/android/remote/model/UniversalColor;[FZII)V", VKApiConst.POSITION, "leftOffset", "moveChartToPosition", "(II)V", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType", "w", "Landroid/widget/LinearLayout;", "sectionContainer", "Landroid/widget/TextView;", "s", "Landroid/widget/TextView;", "u", "t", "Landroid/widget/HorizontalScrollView;", VKApiConst.VERSION, "Landroid/widget/HorizontalScrollView;", "scrollView", "Landroid/view/View;", "x", "Landroid/view/View;", "getView", "()Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "advert-core_release"}, k = 1, mv = {1, 4, 2})
@SuppressLint({"ClickableViewAccessibility"})
public final class CarMarketPriceChartViewImpl extends BaseViewHolder implements CarMarketPriceChartView {
    public final TextView s;
    public final TextView t;
    public final TextView u;
    public final HorizontalScrollView v;
    public final LinearLayout w;
    @NotNull
    public final View x;

    public static final class a implements View.OnTouchListener {
        public static final a a = new a();

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ CarMarketPriceChartViewImpl a;
        public final /* synthetic */ int b;
        public final /* synthetic */ int c;

        public b(CarMarketPriceChartViewImpl carMarketPriceChartViewImpl, int i, int i2) {
            this.a = carMarketPriceChartViewImpl;
            this.b = i;
            this.c = i2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            View childAt = this.a.w.getChildAt(this.b);
            if (childAt != null) {
                this.a.v.scrollTo(childAt.getLeft() - this.c, 0);
            }
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CarMarketPriceChartViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        this.x = view;
        this.s = (TextView) view.findViewById(R.id.title);
        this.t = (TextView) view.findViewById(R.id.subtitle);
        TextView textView = (TextView) view.findViewById(R.id.details);
        this.u = textView;
        HorizontalScrollView horizontalScrollView = (HorizontalScrollView) view.findViewById(R.id.scroll_view);
        this.v = horizontalScrollView;
        this.w = (LinearLayout) view.findViewById(R.id.section_container);
        horizontalScrollView.setOnTouchListener(a.a);
        Intrinsics.checkNotNullExpressionValue(textView, ErrorBundle.DETAIL_ENTRY);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
    }

    @Override // com.avito.android.advert_core.car_market_price.price_chart.CarMarketPriceChartView
    public void addChartSection(@NotNull String str, @NotNull UniversalColor universalColor, @NotNull UniversalColor universalColor2, @NotNull float[] fArr, boolean z, int i, int i2) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(universalColor, "titleColor");
        Intrinsics.checkNotNullParameter(universalColor2, "lineColor");
        Intrinsics.checkNotNullParameter(fArr, "lineCornersRadii");
        CarMarketPriceChartSectionImpl carMarketPriceChartSectionImpl = new CarMarketPriceChartSectionImpl(getContext(), null, 0, 0, 14, null);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i, -2);
        layoutParams.setMarginEnd(i2);
        carMarketPriceChartSectionImpl.setLayoutParams(layoutParams);
        carMarketPriceChartSectionImpl.setTitle(str);
        carMarketPriceChartSectionImpl.setTitleColor(ContextsKt.getColorFrom(getContext(), universalColor), z);
        carMarketPriceChartSectionImpl.setLineDrawableParams(ContextsKt.getColorFrom(getContext(), universalColor2), z, fArr);
        carMarketPriceChartSectionImpl.setDotVisible(z);
        this.w.addView(carMarketPriceChartSectionImpl);
    }

    @Override // com.avito.android.advert_core.car_market_price.price_chart.CarMarketPriceChartView
    public void clearChartSections() {
        this.w.removeAllViews();
    }

    @Override // com.avito.android.advert_core.car_market_price.price_chart.CarMarketPriceChartView
    @NotNull
    public Context getContext() {
        Context context = this.x.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        return context;
    }

    @NotNull
    public final View getView() {
        return this.x;
    }

    @Override // com.avito.android.advert_core.car_market_price.price_chart.CarMarketPriceChartView
    public void moveChartToPosition(int i, int i2) {
        this.v.post(new b(this, i, i2));
    }

    @Override // com.avito.android.advert_core.car_market_price.price_chart.CarMarketPriceChartView
    public void setDetails(@Nullable CharSequence charSequence) {
        TextView textView = this.u;
        Intrinsics.checkNotNullExpressionValue(textView, "this.details");
        TextViews.bindText$default(textView, charSequence, false, 2, null);
    }

    @Override // com.avito.android.advert_core.car_market_price.price_chart.CarMarketPriceChartView
    public void setSubtitle(@Nullable String str) {
        TextView textView = this.t;
        Intrinsics.checkNotNullExpressionValue(textView, "this.subtitle");
        TextViews.bindText$default(textView, str, false, 2, null);
    }

    @Override // com.avito.android.advert_core.car_market_price.price_chart.CarMarketPriceChartView
    public void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        TextView textView = this.s;
        Intrinsics.checkNotNullExpressionValue(textView, "this.title");
        textView.setText(str);
    }
}
