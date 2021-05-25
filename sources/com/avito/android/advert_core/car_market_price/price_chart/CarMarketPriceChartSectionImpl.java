package com.avito.android.advert_core.car_market_price.price_chart;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.avito.android.advert_core.R;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Views;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B1\b\u0007\u0012\u0006\u0010$\u001a\u00020#\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010%\u0012\b\b\u0002\u0010'\u001a\u00020\b\u0012\b\b\u0002\u0010(\u001a\u00020\b¢\u0006\u0004\b)\u0010*J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\f\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ'\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R*\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\n8\u0016@VX\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0016\u0010\u0004\u001a\u00020\u001e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010\"\u001a\u00020\u00138\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b!\u0010\u0015¨\u0006+"}, d2 = {"Lcom/avito/android/advert_core/car_market_price/price_chart/CarMarketPriceChartSectionImpl;", "Landroid/widget/FrameLayout;", "Lcom/avito/android/advert_core/car_market_price/price_chart/CarMarketPriceChartSection;", "", "title", "", "setTitle", "(Ljava/lang/String;)V", "", "color", "", "isAccented", "setTitleColor", "(IZ)V", "lineColor", "", "lineCornersRadii", "setLineDrawableParams", "(IZ[F)V", "Landroid/view/View;", AuthSource.SEND_ABUSE, "Landroid/view/View;", "line", "value", "d", "Z", "isDotVisible", "()Z", "setDotVisible", "(Z)V", "Landroid/widget/TextView;", "c", "Landroid/widget/TextView;", AuthSource.BOOKING_ORDER, "dot", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "advert-core_release"}, k = 1, mv = {1, 4, 2})
public final class CarMarketPriceChartSectionImpl extends FrameLayout implements CarMarketPriceChartSection {
    public View a;
    public View b;
    public TextView c;
    public boolean d;

    @JvmOverloads
    public CarMarketPriceChartSectionImpl(@NotNull Context context) {
        this(context, null, 0, 0, 14, null);
    }

    @JvmOverloads
    public CarMarketPriceChartSectionImpl(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
    }

    @JvmOverloads
    public CarMarketPriceChartSectionImpl(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0, 8, null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CarMarketPriceChartSectionImpl(Context context, AttributeSet attributeSet, int i, int i2, int i3, j jVar) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i, (i3 & 8) != 0 ? 0 : i2);
    }

    @Override // com.avito.android.advert_core.car_market_price.price_chart.CarMarketPriceChartSection
    public boolean isDotVisible() {
        return this.d;
    }

    @Override // com.avito.android.advert_core.car_market_price.price_chart.CarMarketPriceChartSection
    public void setDotVisible(boolean z) {
        this.d = z;
        Views.setVisible(this.b, z);
    }

    @Override // com.avito.android.advert_core.car_market_price.price_chart.CarMarketPriceChartSection
    public void setLineDrawableParams(int i, boolean z, @NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "lineCornersRadii");
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadii(fArr);
        gradientDrawable.setColor(i);
        this.a.setBackground(gradientDrawable);
        this.a.setAlpha(z ? 1.0f : 0.3f);
    }

    @Override // com.avito.android.advert_core.car_market_price.price_chart.CarMarketPriceChartSection
    public void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        this.c.setText(str);
    }

    @Override // com.avito.android.advert_core.car_market_price.price_chart.CarMarketPriceChartSection
    public void setTitleColor(int i, boolean z) {
        this.c.setTextColor(i);
        this.c.setAlpha(z ? 1.0f : 0.5f);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public CarMarketPriceChartSectionImpl(@NotNull Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "context");
        LayoutInflater.from(context).inflate(R.layout.market_price_chart_section, (ViewGroup) this, true);
        View findViewById = findViewById(R.id.section_line);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.section_line)");
        this.a = findViewById;
        View findViewById2 = findViewById(R.id.section_dot);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.section_dot)");
        this.b = findViewById2;
        View findViewById3 = findViewById(R.id.section_title);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.section_title)");
        this.c = (TextView) findViewById3;
    }
}
