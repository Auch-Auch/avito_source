package com.avito.android.ui.adapter.tab;

import com.avito.android.ui.adapter.tab.TabItemView;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/avito/android/ui/adapter/tab/ShortcutTabView;", "Lcom/avito/android/ui/adapter/tab/TabItemView;", "", "text", "", "count", "", "bind", "(Ljava/lang/String;Ljava/lang/Integer;)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public interface ShortcutTabView extends TabItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void setSelected(@NotNull ShortcutTabView shortcutTabView, int i, int i2, boolean z) {
            TabItemView.DefaultImpls.setSelected(shortcutTabView, i, i2, z);
        }

        public static void setSelected(@NotNull ShortcutTabView shortcutTabView, boolean z) {
            TabItemView.DefaultImpls.setSelected(shortcutTabView, z);
        }
    }

    void bind(@NotNull String str, @Nullable Integer num);
}
