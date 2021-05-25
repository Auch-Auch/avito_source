package com.getkeepsafe.taptargetview;

import android.graphics.Typeface;
import androidx.annotation.ColorInt;
import androidx.annotation.DimenRes;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H'¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0002H'¢\u0006\u0004\b\u0007\u0010\u0004J\u000f\u0010\b\u001a\u00020\u0002H'¢\u0006\u0004\b\b\u0010\u0004J\u000f\u0010\t\u001a\u00020\u0002H'¢\u0006\u0004\b\t\u0010\u0004J\u000f\u0010\n\u001a\u00020\u0002H'¢\u0006\u0004\b\n\u0010\u0004J\u000f\u0010\u000b\u001a\u00020\u0002H'¢\u0006\u0004\b\u000b\u0010\u0004R\u0016\u0010\u000f\u001a\u00020\f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0019\u001a\u00020\u00108&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0012R\u0016\u0010\u001b\u001a\u00020\u00148&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0016¨\u0006\u001c"}, d2 = {"Lcom/getkeepsafe/taptargetview/TapTargetStyle;", "", "", "targetRadius", "()I", "targetCircleColor", "outerCircleColor", "titleTextSize", "dimColor", "titleTextColor", "descriptionTextSize", "descriptionTextColor", "", "getTransparentTarget", "()Z", "transparentTarget", "Landroid/graphics/Typeface;", "getTitleTypeface", "()Landroid/graphics/Typeface;", "titleTypeface", "", "getOuterCircleAlpha", "()F", "outerCircleAlpha", "getDescriptionTypeface", "descriptionTypeface", "getDescriptionTextAlpha", "descriptionTextAlpha", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public interface TapTargetStyle {
    @ColorInt
    int descriptionTextColor();

    @DimenRes
    int descriptionTextSize();

    @ColorInt
    int dimColor();

    float getDescriptionTextAlpha();

    @NotNull
    Typeface getDescriptionTypeface();

    float getOuterCircleAlpha();

    @NotNull
    Typeface getTitleTypeface();

    boolean getTransparentTarget();

    @ColorInt
    int outerCircleColor();

    @ColorInt
    int targetCircleColor();

    @DimenRes
    int targetRadius();

    @ColorInt
    int titleTextColor();

    @DimenRes
    int titleTextSize();
}
