package com.avito.android.design.widget.search_view;

import androidx.annotation.AttrRes;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.IdRes;
import androidx.annotation.MenuRes;
import androidx.annotation.StringRes;
import androidx.recyclerview.widget.RecyclerView;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\n\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\bH&¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\u000e\u001a\u00020\u00052\b\b\u0001\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0010H&¢\u0006\u0004\b\u000e\u0010\u0011J\u0017\u0010\u0012\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0010H&¢\u0006\u0004\b\u0012\u0010\u0011J\u0011\u0010\u0013\u001a\u0004\u0018\u00010\u0010H&¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0005H&¢\u0006\u0004\b\u0015\u0010\u0007J\u0017\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0010H&¢\u0006\u0004\b\u0017\u0010\u0011J\u0017\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0002H&¢\u0006\u0004\b\u0019\u0010\u001aJ\u0019\u0010\u001c\u001a\u00020\u00052\b\b\u0001\u0010\u001b\u001a\u00020\fH&¢\u0006\u0004\b\u001c\u0010\u000fJ\u0019\u0010\u001e\u001a\u00020\u00052\b\b\u0001\u0010\u001d\u001a\u00020\fH&¢\u0006\u0004\b\u001e\u0010\u000fJ\u0019\u0010 \u001a\u00020\u00052\b\b\u0001\u0010\u001f\u001a\u00020\fH&¢\u0006\u0004\b \u0010\u000fJ\u0019\u0010\"\u001a\u00020\u00052\b\b\u0001\u0010!\u001a\u00020\fH&¢\u0006\u0004\b\"\u0010\u000fJ!\u0010%\u001a\u00020\u00052\b\b\u0001\u0010#\u001a\u00020\f2\u0006\u0010$\u001a\u00020\u0002H&¢\u0006\u0004\b%\u0010&J\u000f\u0010'\u001a\u00020\u0005H&¢\u0006\u0004\b'\u0010\u0007J7\u0010+\u001a\u00020\u00052\b\b\u0001\u0010#\u001a\u00020\f2\b\b\u0001\u0010(\u001a\u00020\f2\b\b\u0002\u0010)\u001a\u00020\u00022\b\b\u0002\u0010*\u001a\u00020\u0002H&¢\u0006\u0004\b+\u0010,J#\u0010.\u001a\u00020\u00052\b\b\u0001\u0010#\u001a\u00020\f2\b\b\u0001\u0010-\u001a\u00020\fH&¢\u0006\u0004\b.\u0010/J\u0015\u00101\u001a\b\u0012\u0004\u0012\u00020\u000500H&¢\u0006\u0004\b1\u00102J\u001f\u00103\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0010H&¢\u0006\u0004\b3\u00104J\u0015\u00105\u001a\b\u0012\u0004\u0012\u00020\f00H&¢\u0006\u0004\b5\u00102J\u0015\u00106\u001a\b\u0012\u0004\u0012\u00020\u001000H&¢\u0006\u0004\b6\u00102J\u0015\u00107\u001a\b\u0012\u0004\u0012\u00020\u001000H&¢\u0006\u0004\b7\u00102J\u0015\u00108\u001a\b\u0012\u0004\u0012\u00020\u000200H&¢\u0006\u0004\b8\u00102J/\u0010<\u001a\u00020\u00052\b\b\u0001\u00109\u001a\u00020\f2\b\b\u0001\u0010:\u001a\u00020\f2\n\b\u0001\u0010;\u001a\u0004\u0018\u00010\fH&¢\u0006\u0004\b<\u0010=J\u000f\u0010>\u001a\u00020\u0005H&¢\u0006\u0004\b>\u0010\u0007J\u0017\u0010@\u001a\u00020\u00052\u0006\u0010?\u001a\u00020\fH&¢\u0006\u0004\b@\u0010\u000fJ\u0017\u0010C\u001a\u00020\u00052\u0006\u0010B\u001a\u00020AH&¢\u0006\u0004\bC\u0010DJ\u000f\u0010E\u001a\u00020\u0005H&¢\u0006\u0004\bE\u0010\u0007R\"\u0010K\u001a\b\u0012\u0002\b\u0003\u0018\u00010F8&@&X¦\u000e¢\u0006\f\u001a\u0004\bG\u0010H\"\u0004\bI\u0010J¨\u0006L"}, d2 = {"Lcom/avito/android/design/widget/search_view/ToolbarSearchView;", "", "", "isSearchOpen", "()Z", "", "close", "()V", "Lkotlin/Function0;", "onCloseAction", "closeDelayed", "(Lkotlin/jvm/functions/Function0;)V", "", "text", "setQuery", "(I)V", "", "(Ljava/lang/String;)V", "updateActiveQuery", "getQuery", "()Ljava/lang/String;", "notifyDataSetChanged", "hint", "setHint", "enabled", "setSearchEnabled", "(Z)V", "drawableRes", "setNavigationIcon", "menuId", "setMenu", "menuTintColor", "setMenuTintColor", "menuTintColorAttr", "setMenuTintColorAttr", "itemId", "visible", "setMenuItemVisible", "(IZ)V", "removeHint", "drawableId", "needToTint", "favoritesIconRedesignNeedToTint", "replaceMenuItemIcon", "(IIZZ)V", "stringRes", "replaceMenuItemTitle", "(II)V", "Lio/reactivex/rxjava3/core/Observable;", "navigationCallbacks", "()Lio/reactivex/rxjava3/core/Observable;", "showTooltipToMenuItem", "(ILjava/lang/String;)V", "menuCallbacks", "submitCallbacks", "textChangeCallbacks", "openCallbacks", "targetIdRes", "titleRes", "descriptionRes", "showTapTarget", "(IILjava/lang/Integer;)V", "showActionProgress", "count", "showSelectedFiltersCount", "Lcom/avito/android/design/widget/search_view/SubscriptionButtonState;", "subscriptionButtonState", "toggleSubscriptionButton", "(Lcom/avito/android/design/widget/search_view/SubscriptionButtonState;)V", "hideNavigationIcon", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "getAdapter", "()Landroidx/recyclerview/widget/RecyclerView$Adapter;", "setAdapter", "(Landroidx/recyclerview/widget/RecyclerView$Adapter;)V", "adapter", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public interface ToolbarSearchView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ void replaceMenuItemIcon$default(ToolbarSearchView toolbarSearchView, int i, int i2, boolean z, boolean z2, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 4) != 0) {
                    z = true;
                }
                if ((i3 & 8) != 0) {
                    z2 = false;
                }
                toolbarSearchView.replaceMenuItemIcon(i, i2, z, z2);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: replaceMenuItemIcon");
        }
    }

    void close();

    void closeDelayed(@NotNull Function0<Unit> function0);

    @Nullable
    RecyclerView.Adapter<?> getAdapter();

    @Nullable
    String getQuery();

    void hideNavigationIcon();

    boolean isSearchOpen();

    @NotNull
    Observable<Integer> menuCallbacks();

    @NotNull
    Observable<Unit> navigationCallbacks();

    void notifyDataSetChanged();

    @NotNull
    Observable<Boolean> openCallbacks();

    void removeHint();

    void replaceMenuItemIcon(@IdRes int i, @DrawableRes int i2, boolean z, boolean z2);

    void replaceMenuItemTitle(@IdRes int i, @StringRes int i2);

    void setAdapter(@Nullable RecyclerView.Adapter<?> adapter);

    void setHint(@NotNull String str);

    void setMenu(@MenuRes int i);

    void setMenuItemVisible(@IdRes int i, boolean z);

    void setMenuTintColor(@ColorRes int i);

    void setMenuTintColorAttr(@AttrRes int i);

    void setNavigationIcon(@DrawableRes int i);

    void setQuery(@StringRes int i);

    void setQuery(@NotNull String str);

    void setSearchEnabled(boolean z);

    void showActionProgress();

    void showSelectedFiltersCount(int i);

    void showTapTarget(@IdRes int i, @StringRes int i2, @StringRes @Nullable Integer num);

    void showTooltipToMenuItem(int i, @NotNull String str);

    @NotNull
    Observable<String> submitCallbacks();

    @NotNull
    Observable<String> textChangeCallbacks();

    void toggleSubscriptionButton(@NotNull SubscriptionButtonState subscriptionButtonState);

    void updateActiveQuery(@NotNull String str);
}
