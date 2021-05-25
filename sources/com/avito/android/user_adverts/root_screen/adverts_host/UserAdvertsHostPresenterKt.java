package com.avito.android.user_adverts.root_screen.adverts_host;

import com.avito.android.ui.adapter.tab.TabsDataProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0004\"\u0016\u0010\u0001\u001a\u00020\u00008\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0001\u0010\u0002\"\u0016\u0010\u0003\u001a\u00020\u00008\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0002¨\u0006\u0004"}, d2 = {"", "KEY_ACTIVE_SHORTCUT", "Ljava/lang/String;", "PAGETYPE_SOLD_ITEMS_LANDING", "user-adverts_release"}, k = 2, mv = {1, 4, 2})
public final class UserAdvertsHostPresenterKt {
    @NotNull
    public static final String KEY_ACTIVE_SHORTCUT = "key_active_shortcut";
    @NotNull
    public static final String PAGETYPE_SOLD_ITEMS_LANDING = "sold_items_statistics";

    public static final int access$findTabByShortcut(TabsDataProvider tabsDataProvider, String str) {
        int count = tabsDataProvider.getCount();
        for (int i = 0; i < count; i++) {
            if (Intrinsics.areEqual(((TabItem) tabsDataProvider.getItem(i)).getShortcut(), str)) {
                return i;
            }
        }
        return -1;
    }
}
