package ru.avito.component.shortcut_navigation_bar;

import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import com.avito.android.remote.model.Shortcuts;
import com.avito.android.remote.model.search.InlineFilters;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.component.shortcut_navigation_bar.adapter.ShortcutNavigationItem;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bH&¢\u0006\u0004\b\u0006\u0010\n¨\u0006\u000b"}, d2 = {"Lru/avito/component/shortcut_navigation_bar/ShortcutNavigationItemConverter;", "", "Lcom/avito/android/remote/model/Shortcuts;", ScreenPublicConstsKt.CONTENT_TYPE_SHORTCUTS, "", "Lru/avito/component/shortcut_navigation_bar/adapter/ShortcutNavigationItem;", "convert", "(Lcom/avito/android/remote/model/Shortcuts;)Ljava/util/List;", "Lcom/avito/android/remote/model/search/InlineFilters;", "inlineFilters", "(Lcom/avito/android/remote/model/search/InlineFilters;)Ljava/util/List;", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public interface ShortcutNavigationItemConverter {
    @NotNull
    List<ShortcutNavigationItem> convert(@Nullable Shortcuts shortcuts);

    @NotNull
    List<ShortcutNavigationItem> convert(@Nullable InlineFilters inlineFilters);
}
