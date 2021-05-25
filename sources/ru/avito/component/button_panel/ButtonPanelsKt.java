package ru.avito.component.button_panel;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0011\u0010\u0004\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0004\u0010\u0003\u001a\u0011\u0010\u0005\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0005\u0010\u0003\u001a\u0011\u0010\u0006\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0006\u0010\u0003\u001a\u0011\u0010\u0007\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0007\u0010\u0003\u001a\u0011\u0010\b\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\b\u0010\u0003¨\u0006\t"}, d2 = {"Lru/avito/component/button_panel/ButtonPanel;", "", "enablePrimaryButton", "(Lru/avito/component/button_panel/ButtonPanel;)V", "disablePrimaryButton", "enableSecondaryButton", "disableSecondaryButton", "showSecondaryButton", "hideSecondaryButton", "deprecated-components_release"}, k = 2, mv = {1, 4, 2})
public final class ButtonPanelsKt {
    public static final void disablePrimaryButton(@NotNull ButtonPanel buttonPanel) {
        Intrinsics.checkNotNullParameter(buttonPanel, "$this$disablePrimaryButton");
        buttonPanel.setPrimaryButtonEnabled(false);
    }

    public static final void disableSecondaryButton(@NotNull ButtonPanel buttonPanel) {
        Intrinsics.checkNotNullParameter(buttonPanel, "$this$disableSecondaryButton");
        buttonPanel.setSecondaryButtonEnabled(false);
    }

    public static final void enablePrimaryButton(@NotNull ButtonPanel buttonPanel) {
        Intrinsics.checkNotNullParameter(buttonPanel, "$this$enablePrimaryButton");
        buttonPanel.setPrimaryButtonEnabled(true);
    }

    public static final void enableSecondaryButton(@NotNull ButtonPanel buttonPanel) {
        Intrinsics.checkNotNullParameter(buttonPanel, "$this$enableSecondaryButton");
        buttonPanel.setSecondaryButtonEnabled(true);
    }

    public static final void hideSecondaryButton(@NotNull ButtonPanel buttonPanel) {
        Intrinsics.checkNotNullParameter(buttonPanel, "$this$hideSecondaryButton");
        buttonPanel.setSecondaryButtonVisible(false);
    }

    public static final void showSecondaryButton(@NotNull ButtonPanel buttonPanel) {
        Intrinsics.checkNotNullParameter(buttonPanel, "$this$showSecondaryButton");
        buttonPanel.setSecondaryButtonVisible(true);
    }
}
