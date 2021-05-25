package ru.avito.component.shortcut_navigation_bar;

import androidx.annotation.ColorInt;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.model.Shortcuts;
import com.avito.android.tariff.tariff_package_info.viewmodel.TariffPackageInfoConverterKt;
import io.reactivex.rxjava3.core.Observable;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.component.shortcut_navigation_bar.adapter.ShortcutNavigationItem;
import ru.avito.component.shortcut_navigation_bar.adapter.SkeletonItem;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\bf\u0018\u00002\u00020\u0001J;\u0010\f\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH&¢\u0006\u0004\b\f\u0010\rJ'\u0010\u0010\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH&¢\u0006\u0004\b\u0010\u0010\u0011J'\u0010\u0015\u001a\u00020\u000b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00120\b2\b\b\u0002\u0010\u0014\u001a\u00020\u0013H&¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u000bH&¢\u0006\u0004\b\u0017\u0010\u0018J\u0015\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0019H&¢\u0006\u0004\b\u001a\u0010\u001bJ\u0015\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\t0\u0019H&¢\u0006\u0004\b\u001c\u0010\u001bJ\u0015\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00040\u0019H&¢\u0006\u0004\b\u001d\u0010\u001bJ\u001f\u0010 \u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020\u0013H&¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\u000bH&¢\u0006\u0004\b\"\u0010\u0018J\u000f\u0010#\u001a\u00020\u000bH&¢\u0006\u0004\b#\u0010\u0018J\u000f\u0010$\u001a\u00020\u000bH&¢\u0006\u0004\b$\u0010\u0018J\u0019\u0010&\u001a\u00020\u000b2\b\b\u0001\u0010%\u001a\u00020\u0006H&¢\u0006\u0004\b&\u0010'¨\u0006("}, d2 = {"Lru/avito/component/shortcut_navigation_bar/ShortcutNavigationBar;", "", "", "headerTitle", "Lcom/avito/android/deep_linking/links/DeepLink;", "resetAction", "", "searchResultCount", "", "Lru/avito/component/shortcut_navigation_bar/adapter/ShortcutNavigationItem;", "items", "", "setShortcutNavigationBarItems", "(Ljava/lang/String;Lcom/avito/android/deep_linking/links/DeepLink;Ljava/lang/Integer;Ljava/util/List;)V", "Lcom/avito/android/remote/model/Shortcuts$Header;", TariffPackageInfoConverterKt.HEADER_STRING_ID, "setShortcutItems", "(Lcom/avito/android/remote/model/Shortcuts$Header;Ljava/util/List;)V", "Lru/avito/component/shortcut_navigation_bar/adapter/SkeletonItem;", "", "withText", "setSkeleton", "(Ljava/util/List;Z)V", "hideSkeleton", "()V", "Lio/reactivex/rxjava3/core/Observable;", "allCategoriesClicks", "()Lio/reactivex/rxjava3/core/Observable;", "shortcutClicks", "resetActionClicks", "show", "animate", "animateShortcutBar", "(ZZ)V", "resetShortcutBarPosition", "hideShortcutBar", "showShortcutBar", "color", "overrideVisibleBackground", "(I)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public interface ShortcutNavigationBar {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ void setSkeleton$default(ShortcutNavigationBar shortcutNavigationBar, List list, boolean z, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    z = true;
                }
                shortcutNavigationBar.setSkeleton(list, z);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setSkeleton");
        }
    }

    @NotNull
    Observable<Unit> allCategoriesClicks();

    void animateShortcutBar(boolean z, boolean z2);

    void hideShortcutBar();

    void hideSkeleton();

    void overrideVisibleBackground(@ColorInt int i);

    @NotNull
    Observable<DeepLink> resetActionClicks();

    void resetShortcutBarPosition();

    void setShortcutItems(@Nullable Shortcuts.Header header, @NotNull List<? extends ShortcutNavigationItem> list);

    void setShortcutNavigationBarItems(@Nullable String str, @Nullable DeepLink deepLink, @Nullable Integer num, @NotNull List<? extends ShortcutNavigationItem> list);

    void setSkeleton(@NotNull List<SkeletonItem> list, boolean z);

    @NotNull
    Observable<ShortcutNavigationItem> shortcutClicks();

    void showShortcutBar();
}
