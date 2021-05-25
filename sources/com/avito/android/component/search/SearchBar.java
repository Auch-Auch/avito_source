package com.avito.android.component.search;

import androidx.annotation.AttrRes;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.IdRes;
import androidx.annotation.MenuRes;
import androidx.annotation.StringRes;
import com.avito.android.design.widget.search_view.SubscriptionButtonState;
import com.avito.android.remote.model.search.suggest.SuggestAction;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0007\u0010\bJ\u0011\u0010\t\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0005H&¢\u0006\u0004\b\f\u0010\bJ\u0017\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH&¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0013\u001a\u00020\u00022\b\b\u0001\u0010\u0012\u001a\u00020\u0011H&¢\u0006\u0004\b\u0013\u0010\u0014J\u0019\u0010\u0016\u001a\u00020\u00022\b\b\u0001\u0010\u0015\u001a\u00020\u0011H&¢\u0006\u0004\b\u0016\u0010\u0014J\u0019\u0010\u0018\u001a\u00020\u00022\b\b\u0001\u0010\u0017\u001a\u00020\u0011H&¢\u0006\u0004\b\u0018\u0010\u0014J\u0019\u0010\u001a\u001a\u00020\u00022\b\b\u0001\u0010\u0019\u001a\u00020\u0011H&¢\u0006\u0004\b\u001a\u0010\u0014J!\u0010\u001d\u001a\u00020\u00022\b\b\u0001\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\rH&¢\u0006\u0004\b\u001d\u0010\u001eJ7\u0010\"\u001a\u00020\u00022\b\b\u0001\u0010\u001b\u001a\u00020\u00112\b\b\u0001\u0010\u001f\u001a\u00020\u00112\b\b\u0002\u0010 \u001a\u00020\r2\b\b\u0002\u0010!\u001a\u00020\rH&¢\u0006\u0004\b\"\u0010#J#\u0010%\u001a\u00020\u00022\b\b\u0001\u0010\u001b\u001a\u00020\u00112\b\b\u0001\u0010$\u001a\u00020\u0011H&¢\u0006\u0004\b%\u0010&J\u0015\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00020'H&¢\u0006\u0004\b(\u0010)J\u0015\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00110'H&¢\u0006\u0004\b*\u0010)J\u0015\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00050'H&¢\u0006\u0004\b+\u0010)J\u0015\u0010,\u001a\b\u0012\u0004\u0012\u00020\r0'H&¢\u0006\u0004\b,\u0010)J\u0015\u0010.\u001a\b\u0012\u0004\u0012\u00020-0'H&¢\u0006\u0004\b.\u0010)J\u0017\u0010/\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\rH&¢\u0006\u0004\b/\u0010\u0010J\u000f\u00100\u001a\u00020\u0002H&¢\u0006\u0004\b0\u0010\u0004J\u000f\u00101\u001a\u00020\rH&¢\u0006\u0004\b1\u00102J/\u00106\u001a\u00020\u00022\b\b\u0001\u00103\u001a\u00020\u00112\b\b\u0001\u00104\u001a\u00020\u00112\n\b\u0001\u00105\u001a\u0004\u0018\u00010\u0011H&¢\u0006\u0004\b6\u00107J\u000f\u00108\u001a\u00020\u0002H&¢\u0006\u0004\b8\u0010\u0004J\u0017\u0010:\u001a\u00020\u00022\u0006\u00109\u001a\u00020\u0011H&¢\u0006\u0004\b:\u0010\u0014J\u000f\u0010;\u001a\u00020\u0002H&¢\u0006\u0004\b;\u0010\u0004J\u000f\u0010<\u001a\u00020\u0002H&¢\u0006\u0004\b<\u0010\u0004J\u0017\u0010?\u001a\u00020\u00022\u0006\u0010>\u001a\u00020=H&¢\u0006\u0004\b?\u0010@¨\u0006A"}, d2 = {"Lcom/avito/android/component/search/SearchBar;", "", "", "close", "()V", "", "text", "setQuery", "(Ljava/lang/String;)V", "getQuery", "()Ljava/lang/String;", "hint", "setHint", "", "enabled", "setSearchEnabled", "(Z)V", "", "drawableRes", "setNavigationIcon", "(I)V", "menuId", "setMenu", "menuTintColor", "setMenuTintColor", "menuTintColorAttr", "setMenuTintColorAttr", "itemId", "visible", "setMenuItemVisible", "(IZ)V", "drawableId", "needToTint", "favoritesIconRedesignNeedToTint", "replaceMenuItemIcon", "(IIZZ)V", "stringRes", "replaceMenuItemTitle", "(II)V", "Lio/reactivex/rxjava3/core/Observable;", "navigationCallbacks", "()Lio/reactivex/rxjava3/core/Observable;", "menuCallbacks", "submitCallbacks", "openCallbacks", "Lcom/avito/android/remote/model/search/suggest/SuggestAction;", "searchSuggestsCallbacks", "setVisible", "setInvisibleSearch", "isVisible", "()Z", "targetIdRes", "titleRes", "descriptionRes", "showTapTarget", "(IILjava/lang/Integer;)V", "showActionProgress", "count", "showSelectedFiltersCount", "hideNavigationIcon", "showSavedSearchesTooltipIfNeeded", "Lcom/avito/android/design/widget/search_view/SubscriptionButtonState;", "subscriptionButtonState", "toggleSubscriptionButton", "(Lcom/avito/android/design/widget/search_view/SubscriptionButtonState;)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public interface SearchBar {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ void replaceMenuItemIcon$default(SearchBar searchBar, int i, int i2, boolean z, boolean z2, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 4) != 0) {
                    z = true;
                }
                if ((i3 & 8) != 0) {
                    z2 = false;
                }
                searchBar.replaceMenuItemIcon(i, i2, z, z2);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: replaceMenuItemIcon");
        }
    }

    void close();

    @Nullable
    String getQuery();

    void hideNavigationIcon();

    boolean isVisible();

    @NotNull
    Observable<Integer> menuCallbacks();

    @NotNull
    Observable<Unit> navigationCallbacks();

    @NotNull
    Observable<Boolean> openCallbacks();

    void replaceMenuItemIcon(@IdRes int i, @DrawableRes int i2, boolean z, boolean z2);

    void replaceMenuItemTitle(@IdRes int i, @StringRes int i2);

    @NotNull
    Observable<SuggestAction> searchSuggestsCallbacks();

    void setHint(@NotNull String str);

    void setInvisibleSearch();

    void setMenu(@MenuRes int i);

    void setMenuItemVisible(@IdRes int i, boolean z);

    void setMenuTintColor(@ColorRes int i);

    void setMenuTintColorAttr(@AttrRes int i);

    void setNavigationIcon(@DrawableRes int i);

    void setQuery(@NotNull String str);

    void setSearchEnabled(boolean z);

    void setVisible(boolean z);

    void showActionProgress();

    void showSavedSearchesTooltipIfNeeded();

    void showSelectedFiltersCount(int i);

    void showTapTarget(@IdRes int i, @StringRes int i2, @StringRes @Nullable Integer num);

    @NotNull
    Observable<String> submitCallbacks();

    void toggleSubscriptionButton(@NotNull SubscriptionButtonState subscriptionButtonState);
}
