package com.avito.android.user_advert.advert.switcher_block;

import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0002\n\u0000¨\u0006\u0000"}, d2 = {"user-advert_release"}, k = 2, mv = {1, 4, 2})
public final class SwitcherBlockViewModelKt {
    public static final String access$errorMessageByDesiredSwitcherValue(SwitcherBlockResourceProvider switcherBlockResourceProvider, boolean z) {
        if (z) {
            return switcherBlockResourceProvider.getSwitcherEnableErrorText();
        }
        return switcherBlockResourceProvider.getSwitcherDisableErrorText();
    }
}
