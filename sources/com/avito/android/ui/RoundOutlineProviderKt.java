package com.avito.android.ui;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a\u0019\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Landroid/view/View;", "", "cornerRadius", "", "setCornerRadius", "(Landroid/view/View;F)V", "ui-components_release"}, k = 2, mv = {1, 4, 2})
public final class RoundOutlineProviderKt {
    public static final void setCornerRadius(@NotNull View view, float f) {
        Intrinsics.checkNotNullParameter(view, "$this$setCornerRadius");
        boolean z = f != 0.0f;
        view.setOutlineProvider(z ? new RoundOutlineProvider(f) : null);
        view.setClipToOutline(z);
    }
}
