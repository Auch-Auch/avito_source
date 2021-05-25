package com.avito.android.design.widget.dfp_debug;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0006H&¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/avito/android/design/widget/dfp_debug/DfpDebugPresenter;", "", "", "adUnitId", "Lcom/avito/android/design/widget/dfp_debug/DfpDebuggableView;", "debuggableView", "", "setupDebugMenu", "(Ljava/lang/String;Lcom/avito/android/design/widget/dfp_debug/DfpDebuggableView;)V", "Lcom/avito/android/design/widget/dfp_debug/DfpDebugRouter;", "router", "attachRouter", "(Lcom/avito/android/design/widget/dfp_debug/DfpDebugRouter;)V", "detachRouter", "()V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public interface DfpDebugPresenter {
    void attachRouter(@NotNull DfpDebugRouter dfpDebugRouter);

    void detachRouter();

    void setupDebugMenu(@NotNull String str, @NotNull DfpDebuggableView dfpDebuggableView);
}
