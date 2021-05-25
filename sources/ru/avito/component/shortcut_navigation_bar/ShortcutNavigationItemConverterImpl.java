package ru.avito.component.shortcut_navigation_bar;

import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.NoMatchLink;
import com.avito.android.remote.model.Action;
import com.avito.android.remote.model.Shortcuts;
import com.avito.android.remote.model.search.Filter;
import com.avito.android.remote.model.search.InlineFilterValue;
import com.avito.android.remote.model.search.InlineFilters;
import com.avito.android.remote.model.search.Result;
import com.avito.android.remote.model.search.WidgetType;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.component.shortcut_navigation_bar.adapter.InlineFilterNavigationItem;
import ru.avito.component.shortcut_navigation_bar.adapter.ShortcutNavigationItem;
import ru.avito.component.shortcut_navigation_bar.adapter.ShortcutNavigationItemImpl;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u0006\u0010\n¨\u0006\r"}, d2 = {"Lru/avito/component/shortcut_navigation_bar/ShortcutNavigationItemConverterImpl;", "Lru/avito/component/shortcut_navigation_bar/ShortcutNavigationItemConverter;", "Lcom/avito/android/remote/model/Shortcuts;", ScreenPublicConstsKt.CONTENT_TYPE_SHORTCUTS, "", "Lru/avito/component/shortcut_navigation_bar/adapter/ShortcutNavigationItem;", "convert", "(Lcom/avito/android/remote/model/Shortcuts;)Ljava/util/List;", "Lcom/avito/android/remote/model/search/InlineFilters;", "inlineFilters", "(Lcom/avito/android/remote/model/search/InlineFilters;)Ljava/util/List;", "<init>", "()V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class ShortcutNavigationItemConverterImpl implements ShortcutNavigationItemConverter {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            WidgetType.values();
            int[] iArr = new int[7];
            $EnumSwitchMapping$0 = iArr;
            WidgetType widgetType = WidgetType.Shortcut;
            iArr[0] = 1;
            WidgetType widgetType2 = WidgetType.Select;
            iArr[1] = 2;
            WidgetType widgetType3 = WidgetType.Multiselect;
            iArr[2] = 3;
            WidgetType widgetType4 = WidgetType.Calendar;
            iArr[4] = 4;
            WidgetType widgetType5 = WidgetType.NumericRange;
            iArr[3] = 5;
            WidgetType widgetType6 = WidgetType.Checkbox;
            iArr[5] = 6;
        }
    }

    @Override // ru.avito.component.shortcut_navigation_bar.ShortcutNavigationItemConverter
    @NotNull
    public List<ShortcutNavigationItem> convert(@Nullable Shortcuts shortcuts) {
        List<Action> list;
        if (shortcuts == null || (list = shortcuts.getList()) == null) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(list, 10));
        int i = 0;
        for (T t : list) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            T t2 = t;
            arrayList.add(new ShortcutNavigationItemImpl(String.valueOf(i), t2.getTitle(), t2.getDeepLink(), false));
            i = i2;
        }
        return arrayList;
    }

    @Override // ru.avito.component.shortcut_navigation_bar.ShortcutNavigationItemConverter
    @NotNull
    public List<ShortcutNavigationItem> convert(@Nullable InlineFilters inlineFilters) {
        DeepLink deepLink;
        Result result;
        List<Filter> filters;
        Object obj;
        String id;
        DeepLink deepLink2;
        Filter.Widget widget;
        Result result2;
        if (inlineFilters == null || (result2 = inlineFilters.getResult()) == null || (deepLink = result2.getUri()) == null) {
            deepLink = new NoMatchLink();
        }
        if (inlineFilters == null || (result = inlineFilters.getResult()) == null || (filters = result.getFilters()) == null) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(filters, 10));
        int i = 0;
        for (T t : filters) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            T t2 = t;
            InlineFilterValue inlineFilterValue = null;
            WidgetType type = (t2 == null || (widget = t2.getWidget()) == null) ? null : widget.getType();
            String str = "";
            if (type != null) {
                int ordinal = type.ordinal();
                if (ordinal == 0) {
                    String valueOf = String.valueOf(i);
                    String title = t2.getTitle();
                    if (title != null) {
                        str = title;
                    }
                    InlineFilterValue value = t2.getValue();
                    if (value instanceof InlineFilterValue.InlineFilterShortcutValue) {
                        inlineFilterValue = value;
                    }
                    InlineFilterValue.InlineFilterShortcutValue inlineFilterShortcutValue = (InlineFilterValue.InlineFilterShortcutValue) inlineFilterValue;
                    if (inlineFilterShortcutValue == null || (deepLink2 = inlineFilterShortcutValue.getDeepLink()) == null) {
                        deepLink2 = new NoMatchLink();
                    }
                    obj = new ShortcutNavigationItemImpl(valueOf, str, deepLink2, false);
                    arrayList.add(obj);
                    i = i2;
                } else if (ordinal == 1 || ordinal == 2 || ordinal == 3 || ordinal == 4 || ordinal == 5) {
                    inlineFilterValue = t2.getValue();
                }
            }
            String valueOf2 = String.valueOf(i);
            String str2 = (t2 == null || (id = t2.getId()) == null) ? str : id;
            String displayTitle = t2.getDisplayTitle();
            if (displayTitle == null) {
                displayTitle = t2.getTitle();
            }
            obj = new InlineFilterNavigationItem(valueOf2, str2, inlineFilterValue, displayTitle != null ? displayTitle : str, deepLink, t2, t2.getDisplayTitle(), false, 128, null);
            arrayList.add(obj);
            i = i2;
        }
        return arrayList;
    }
}
