package ru.avito.component.shortcut_navigation_bar.adapter;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import ru.avito.component.shortcut_navigation_bar.adapter.ShortcutNavigationItemView;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lru/avito/component/shortcut_navigation_bar/adapter/InlineFiltersNavigationItemView;", "Lru/avito/component/shortcut_navigation_bar/adapter/ShortcutNavigationItemView;", "", "resId", "", "setBackgroundResId", "(I)V", "", "set", "setDrawableEndArrow", "(Z)V", "", "text", "showTooltip", "(Ljava/lang/String;)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public interface InlineFiltersNavigationItemView extends ShortcutNavigationItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull InlineFiltersNavigationItemView inlineFiltersNavigationItemView) {
            ShortcutNavigationItemView.DefaultImpls.onUnbind(inlineFiltersNavigationItemView);
        }
    }

    void setBackgroundResId(int i);

    void setDrawableEndArrow(boolean z);

    void showTooltip(@NotNull String str);
}
