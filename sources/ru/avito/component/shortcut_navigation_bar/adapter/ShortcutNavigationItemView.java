package ru.avito.component.shortcut_navigation_bar.adapter;

import com.avito.konveyor.blueprint.ItemView;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import ru.avito.component.shortcut_navigation.ShortcutNavigationButton;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lru/avito/component/shortcut_navigation_bar/adapter/ShortcutNavigationItemView;", "Lru/avito/component/shortcut_navigation/ShortcutNavigationButton;", "Lcom/avito/konveyor/blueprint/ItemView;", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public interface ShortcutNavigationItemView extends ShortcutNavigationButton, ItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull ShortcutNavigationItemView shortcutNavigationItemView) {
            ItemView.DefaultImpls.onUnbind(shortcutNavigationItemView);
        }
    }
}
