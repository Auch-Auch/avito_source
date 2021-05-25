package com.getkeepsafe.taptargetview;

import android.content.Context;
import android.graphics.Typeface;
import android.util.TypedValue;
import com.avito.android.lib.design.R;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Contexts;
import com.avito.android.util.TypefaceType;
import com.avito.android.util.Typefaces;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010 \u001a\u00020\u001d¢\u0006\u0004\b'\u0010(J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0004J\u000f\u0010\b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0004J\u000f\u0010\t\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\u0004J\u000f\u0010\n\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u0004J\u000f\u0010\u000b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\u0004R\u001c\u0010\u0011\u001a\u00020\f8\u0016@\u0016XD¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0017\u001a\u00020\u00128\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0019\u001a\u00020\u00188\u0016@\u0016XD¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u001c\u0010#\u001a\u00020\u00128\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b!\u0010\u0014\u001a\u0004\b\"\u0010\u0016R\u001c\u0010&\u001a\u00020\f8\u0016@\u0016XD¢\u0006\f\n\u0004\b$\u0010\u000e\u001a\u0004\b%\u0010\u0010¨\u0006)"}, d2 = {"Lcom/getkeepsafe/taptargetview/AvitoBrandTapTargetStyle;", "Lcom/getkeepsafe/taptargetview/TapTargetStyle;", "", "targetRadius", "()I", "targetCircleColor", "outerCircleColor", "titleTextSize", "dimColor", "titleTextColor", "descriptionTextSize", "descriptionTextColor", "", AuthSource.SEND_ABUSE, "F", "getOuterCircleAlpha", "()F", "outerCircleAlpha", "Landroid/graphics/Typeface;", AuthSource.BOOKING_ORDER, "Landroid/graphics/Typeface;", "getTitleTypeface", "()Landroid/graphics/Typeface;", "titleTypeface", "", "transparentTarget", "Z", "getTransparentTarget", "()Z", "Landroid/content/Context;", "e", "Landroid/content/Context;", "context", "c", "getDescriptionTypeface", "descriptionTypeface", "d", "getDescriptionTextAlpha", "descriptionTextAlpha", "<init>", "(Landroid/content/Context;)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class AvitoBrandTapTargetStyle implements TapTargetStyle {
    public final float a = 1.0f;
    @NotNull
    public final Typeface b;
    @NotNull
    public final Typeface c;
    public final float d;
    public final Context e;

    public AvitoBrandTapTargetStyle(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.e = context;
        Typeface typeface = Typefaces.getTypeface(context, TypefaceType.Medium);
        if (typeface != null) {
            this.b = typeface;
            Typeface typeface2 = Typefaces.getTypeface(context, TypefaceType.Regular);
            if (typeface2 != null) {
                this.c = typeface2;
                this.d = 1.0f;
                return;
            }
            throw new Exception("DescriptionTypeface is null");
        }
        throw new Exception("TitleTypeface is null");
    }

    @Override // com.getkeepsafe.taptargetview.TapTargetStyle
    public int descriptionTextColor() {
        return Contexts.getColorByAttr(this.e, R.attr.white);
    }

    @Override // com.getkeepsafe.taptargetview.TapTargetStyle
    public int descriptionTextSize() {
        return com.avito.android.ui_components.R.dimen.text_input_text_size;
    }

    @Override // com.getkeepsafe.taptargetview.TapTargetStyle
    public int dimColor() {
        return Contexts.getColorByAttr(this.e, R.attr.white);
    }

    @Override // com.getkeepsafe.taptargetview.TapTargetStyle
    public float getDescriptionTextAlpha() {
        return this.d;
    }

    @Override // com.getkeepsafe.taptargetview.TapTargetStyle
    @NotNull
    public Typeface getDescriptionTypeface() {
        return this.c;
    }

    @Override // com.getkeepsafe.taptargetview.TapTargetStyle
    public float getOuterCircleAlpha() {
        return this.a;
    }

    @Override // com.getkeepsafe.taptargetview.TapTargetStyle
    @NotNull
    public Typeface getTitleTypeface() {
        return this.b;
    }

    @Override // com.getkeepsafe.taptargetview.TapTargetStyle
    public boolean getTransparentTarget() {
        return false;
    }

    @Override // com.getkeepsafe.taptargetview.TapTargetStyle
    public int outerCircleColor() {
        return Contexts.getColorByAttr(this.e, R.attr.blue);
    }

    @Override // com.getkeepsafe.taptargetview.TapTargetStyle
    public int targetCircleColor() {
        return Contexts.getColorByAttr(this.e, R.attr.white);
    }

    @Override // com.getkeepsafe.taptargetview.TapTargetStyle
    public int targetRadius() {
        TypedValue typedValue = new TypedValue();
        this.e.getResources().getValue(com.avito.android.ui_components.R.dimen.tap_target_radius, typedValue, true);
        return (int) typedValue.getFraction(1.0f, 1.0f);
    }

    @Override // com.getkeepsafe.taptargetview.TapTargetStyle
    public int titleTextColor() {
        return Contexts.getColorByAttr(this.e, R.attr.white);
    }

    @Override // com.getkeepsafe.taptargetview.TapTargetStyle
    public int titleTextSize() {
        return com.avito.android.ui_components.R.dimen.appbar_expanded_title_size;
    }
}
