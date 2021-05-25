package com.avito.android.lib.design.tooltip;

import android.view.View;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a*\u0010\u0006\u001a\u00020\u0000*\u00020\u00002\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/avito/android/lib/design/tooltip/Tooltip;", "Lkotlin/Function1;", "Lcom/avito/android/lib/design/tooltip/TooltipContent;", "", "Lkotlin/ExtensionFunctionType;", "func", "content", "(Lcom/avito/android/lib/design/tooltip/Tooltip;Lkotlin/jvm/functions/Function1;)Lcom/avito/android/lib/design/tooltip/Tooltip;", "components_release"}, k = 2, mv = {1, 4, 2})
public final class TooltipContentKt {
    @NotNull
    public static final Tooltip content(@NotNull Tooltip tooltip, @NotNull Function1<? super TooltipContent, Unit> function1) {
        Intrinsics.checkNotNullParameter(tooltip, "$this$content");
        Intrinsics.checkNotNullParameter(function1, "func");
        View contentView = tooltip.getContentView();
        if (contentView != null) {
            function1.invoke(new TooltipContent(contentView));
        }
        return tooltip;
    }
}
