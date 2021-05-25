package com.avito.android.advert_stats.item;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.drawable.PaintDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.view.View;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import androidx.exifinterface.media.ExifInterface;
import com.avito.android.advert_stats.item.BarItemView;
import com.avito.android.lib.design.avito.R;
import com.avito.android.lib.design.shadow_layout.ShadowLayout;
import com.avito.android.util.Contexts;
import com.avito.android.util.Views;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u00107\u001a\u00020\u001e¢\u0006\u0004\bB\u0010CJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\u000b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u001d\u0010\u0012\u001a\u00020\u00052\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J'\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001d\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010#\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010\u001cR\u001e\u0010(\u001a\n %*\u0004\u0018\u00010$0$8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010/\u001a\u00020\r8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00101\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b0\u0010\u001cR\u0016\u00103\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b2\u0010\u001cR\u0019\u00107\u001a\u00020\u001e8\u0006@\u0006¢\u0006\f\n\u0004\b4\u0010 \u001a\u0004\b5\u00106R\u0016\u00109\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b8\u0010\u001cR\u0016\u0010;\u001a\u00020\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b:\u0010 R\u0016\u0010=\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b<\u0010\u001cR\u0016\u0010A\u001a\u00020>8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b?\u0010@¨\u0006D"}, d2 = {"Lcom/avito/android/advert_stats/item/BarItemViewImpl;", "Lcom/avito/android/advert_stats/item/BarItemView;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "", "value", "", "setStatValue", "(Ljava/lang/String;)V", "", ViewHierarchyConstants.DIMENSION_WIDTH_KEY, ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, "setWidthHeightPx", "(II)V", "", "isSelected", "()Z", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnClickListener", "(Lkotlin/jvm/functions/Function0;)V", "Lcom/avito/android/advert_stats/item/BarState;", "barState", "isEmpty", "", "predictPercent", "setState", "(Lcom/avito/android/advert_stats/item/BarState;ZF)V", "y", "I", "greenAccentColor", "Landroid/view/View;", "t", "Landroid/view/View;", "bar", "D", "gradientBlurBottom", "Landroid/content/res/Resources;", "kotlin.jvm.PlatformType", "s", "Landroid/content/res/Resources;", "resources", "Landroid/widget/TextView;", "u", "Landroid/widget/TextView;", "textValue", "x", "Z", "selected", "z", "greenUnselectedColor", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "blueAccentColor", ExifInterface.LONGITUDE_EAST, "getView", "()Landroid/view/View;", "view", "C", "gradientBlurTop", VKApiConst.VERSION, "barContentView", "B", "blueUnselectedColor", "Lcom/avito/android/lib/design/shadow_layout/ShadowLayout;", "w", "Lcom/avito/android/lib/design/shadow_layout/ShadowLayout;", "shadowLayout", "<init>", "(Landroid/view/View;)V", "advert-stats_release"}, k = 1, mv = {1, 4, 2})
public final class BarItemViewImpl extends BaseViewHolder implements BarItemView {
    public final int A = R.color.expected_stats_base_views_accented;
    public final int B = R.color.expected_stats_base_views_unaccented;
    public final int C;
    public final int D;
    @NotNull
    public final View E;
    public final Resources s;
    public final View t;
    public final TextView u;
    public final View v;
    public final ShadowLayout w;
    public boolean x;
    public final int y = R.color.expected_stats_vas_views_accented;
    public final int z = R.color.expected_stats_vas_views_unaccented;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ Function0 a;

        public a(Function0 function0) {
            this.a = function0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.invoke();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BarItemViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        this.E = view;
        Resources resources = view.getResources();
        this.s = resources;
        View findViewById = view.findViewById(com.avito.android.advert_stats.R.id.bar);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.bar)");
        this.t = findViewById;
        View findViewById2 = view.findViewById(com.avito.android.advert_stats.R.id.value);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.value)");
        this.u = (TextView) findViewById2;
        View findViewById3 = view.findViewById(com.avito.android.advert_stats.R.id.bar_content);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.bar_content)");
        this.v = findViewById3;
        View findViewById4 = view.findViewById(com.avito.android.advert_stats.R.id.shadow_layout);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById(R.id.shadow_layout)");
        this.w = (ShadowLayout) findViewById4;
        this.C = resources.getDimensionPixelSize(com.avito.android.advert_stats.R.dimen.gradient_diffusion_top);
        this.D = resources.getDimensionPixelSize(com.avito.android.advert_stats.R.dimen.gradient_diffusion_bottom);
    }

    public static final Pair access$getGradientBounds(BarItemViewImpl barItemViewImpl, int i, float f) {
        Objects.requireNonNull(barItemViewImpl);
        Float valueOf = Float.valueOf(0.0f);
        if (f == 1.0f) {
            return new Pair(valueOf, valueOf);
        }
        float f2 = (float) i;
        float f3 = f * f2;
        return new Pair(Float.valueOf(Math.max(f3 - ((float) barItemViewImpl.C), 0.0f)), Float.valueOf(Math.min(f3 + ((float) barItemViewImpl.D), f2)));
    }

    @NotNull
    public final View getView() {
        return this.E;
    }

    @Override // com.avito.android.advert_stats.item.BarItemView
    public boolean isSelected() {
        return this.x;
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        BarItemView.DefaultImpls.onUnbind(this);
    }

    @Override // com.avito.android.advert_stats.item.BarItemView
    public void setOnClickListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.E.setOnClickListener(new a(function0));
    }

    @Override // com.avito.android.advert_stats.item.BarItemView
    public void setStatValue(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "value");
        this.u.setText(str);
    }

    @Override // com.avito.android.advert_stats.item.BarItemView
    public void setState(@NotNull BarState barState, boolean z2, float f) {
        PaintDrawable paintDrawable;
        Intrinsics.checkNotNullParameter(barState, "barState");
        boolean z3 = true;
        boolean z4 = barState == BarState.SELECTED;
        this.x = z4;
        if (barState == BarState.UNSELECTED) {
            z3 = false;
        }
        if (z4) {
            int dimensionPixelSize = this.E.getResources().getDimensionPixelSize(com.avito.android.advert_stats.R.dimen.shadow_padding);
            Views.changePadding$default(this.v, dimensionPixelSize, 0, dimensionPixelSize, 0, 10, null);
            Views.show(this.w);
            int dimensionPixelSize2 = this.s.getDimensionPixelSize(com.avito.android.advert_stats.R.dimen.card_view_padding);
            Views.changePadding$default(this.E, dimensionPixelSize2, 0, dimensionPixelSize2, 0, 10, null);
        } else {
            Views.changePadding$default(this.v, 0, 0, 0, 0, 10, null);
            Views.changePadding$default(this.E, 0, 0, 0, 0, 10, null);
            Views.hide(this.w);
        }
        int i = this.x ? com.avito.android.lib.design.R.attr.black : com.avito.android.lib.design.R.attr.gray48;
        TextView textView = this.u;
        Context context = this.E.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        textView.setTextColor(Contexts.getColorByAttr(context, i));
        if (z2) {
            Context context2 = this.E.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "view.context");
            paintDrawable = Contexts.getTintedDrawable(context2, com.avito.android.advert_stats.R.drawable.bg_bar, z3 ? R.color.avito_gray_12 : R.color.avito_gray_4);
        } else if (f == 1.0f) {
            Context context3 = this.E.getContext();
            Intrinsics.checkNotNullExpressionValue(context3, "view.context");
            paintDrawable = Contexts.getTintedDrawable(context3, com.avito.android.advert_stats.R.drawable.bg_bar, z3 ? this.y : this.z);
        } else if (f > ((float) 0)) {
            PaintDrawable paintDrawable2 = new PaintDrawable();
            float[] fArr = new float[8];
            for (int i2 = 0; i2 < 8; i2++) {
                fArr[i2] = this.s.getDimension(com.avito.android.advert_stats.R.dimen.corner_radius);
            }
            paintDrawable2.setShape(new RoundRectShape(fArr, null, null));
            paintDrawable2.setShaderFactory(new ShapeDrawable.ShaderFactory(f, z3) { // from class: com.avito.android.advert_stats.item.BarItemViewImpl$createGradientView$2
                public final /* synthetic */ float b;
                public final /* synthetic */ boolean c;

                {
                    this.b = r2;
                    this.c = r3;
                }

                @Override // android.graphics.drawable.ShapeDrawable.ShaderFactory
                @NotNull
                public Shader resize(int i3, int i4) {
                    Pair access$getGradientBounds = BarItemViewImpl.access$getGradientBounds(BarItemViewImpl.this, i4, this.b);
                    float floatValue = ((Number) access$getGradientBounds.component1()).floatValue();
                    float floatValue2 = ((Number) access$getGradientBounds.component2()).floatValue();
                    int i5 = this.c ? BarItemViewImpl.this.y : BarItemViewImpl.this.z;
                    int i6 = this.c ? BarItemViewImpl.this.A : BarItemViewImpl.this.B;
                    Resources resources = BarItemViewImpl.this.s;
                    Intrinsics.checkNotNullExpressionValue(resources, "resources");
                    int color = ResourcesCompat.getColor(resources, i5, null);
                    Resources resources2 = BarItemViewImpl.this.s;
                    Intrinsics.checkNotNullExpressionValue(resources2, "resources");
                    return new LinearGradient(0.0f, floatValue, 0.0f, floatValue2, color, ResourcesCompat.getColor(resources2, i6, null), Shader.TileMode.CLAMP);
                }
            });
            paintDrawable = paintDrawable2;
        } else {
            Context context4 = this.E.getContext();
            Intrinsics.checkNotNullExpressionValue(context4, "view.context");
            paintDrawable = Contexts.getTintedDrawable(context4, com.avito.android.advert_stats.R.drawable.bg_bar, z3 ? this.A : this.B);
        }
        Views.setBackgroundCompat(this.t, paintDrawable);
    }

    @Override // com.avito.android.advert_stats.item.BarItemView
    public void setWidthHeightPx(int i, int i2) {
        this.t.getLayoutParams().width = i;
        this.t.getLayoutParams().height = i2;
        this.t.requestLayout();
    }
}
