package com.getkeepsafe.taptargetview;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0019\u0010\u0003\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/getkeepsafe/taptargetview/TapTarget;", "Lcom/getkeepsafe/taptargetview/TapTargetStyle;", "tapTargetStyle", "applyStyle", "(Lcom/getkeepsafe/taptargetview/TapTarget;Lcom/getkeepsafe/taptargetview/TapTargetStyle;)Lcom/getkeepsafe/taptargetview/TapTarget;", "ui-components_release"}, k = 2, mv = {1, 4, 2})
public final class TapTargetsKt {
    @NotNull
    public static final TapTarget applyStyle(@NotNull TapTarget tapTarget, @NotNull TapTargetStyle tapTargetStyle) {
        Intrinsics.checkNotNullParameter(tapTarget, "$this$applyStyle");
        Intrinsics.checkNotNullParameter(tapTargetStyle, "tapTargetStyle");
        TapTarget descriptionTextAlpha = tapTarget.transparentTarget(tapTargetStyle.getTransparentTarget()).targetRadius(tapTargetStyle.targetRadius()).targetCircleColorInt(tapTargetStyle.targetCircleColor()).outerCircleColorInt(tapTargetStyle.outerCircleColor()).outerCircleAlpha(tapTargetStyle.getOuterCircleAlpha()).titleTextDimen(tapTargetStyle.titleTextSize()).titleTypeface(tapTargetStyle.getTitleTypeface()).dimColorInt(tapTargetStyle.dimColor()).titleTextColorInt(tapTargetStyle.titleTextColor()).descriptionTextDimen(tapTargetStyle.descriptionTextSize()).descriptionTypeface(tapTargetStyle.getDescriptionTypeface()).descriptionTextColorInt(tapTargetStyle.descriptionTextColor()).descriptionTextAlpha(tapTargetStyle.getDescriptionTextAlpha());
        Intrinsics.checkNotNullExpressionValue(descriptionTextAlpha, "this\n            .transp…yle.descriptionTextAlpha)");
        return descriptionTextAlpha;
    }
}
