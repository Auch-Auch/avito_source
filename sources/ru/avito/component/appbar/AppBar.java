package ru.avito.component.appbar;

import androidx.annotation.AttrRes;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.MenuRes;
import androidx.annotation.StringRes;
import com.avito.android.image_loader.Picture;
import com.avito.android.util.ActionMenu;
import io.reactivex.rxjava3.core.Observable;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\bf\u0018\u00002\u00020\u0001J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0002H&¢\u0006\u0004\b\u0007\u0010\u0005J%\u0010\n\u001a\u00020\u00032\b\b\u0001\u0010\b\u001a\u00020\u00062\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0006H&¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0003H&¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u0011\u001a\u00020\u00032\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH&¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0014\u001a\u00020\u00032\b\b\u0001\u0010\u0013\u001a\u00020\u0006H&¢\u0006\u0004\b\u0014\u0010\u0015J\u0019\u0010\u0017\u001a\u00020\u00032\b\b\u0001\u0010\u0016\u001a\u00020\u0006H&¢\u0006\u0004\b\u0017\u0010\u0015J\u0019\u0010\u0019\u001a\u00020\u00032\b\b\u0001\u0010\u0018\u001a\u00020\u0006H&¢\u0006\u0004\b\u0019\u0010\u0015J\u000f\u0010\u001a\u001a\u00020\u0003H&¢\u0006\u0004\b\u001a\u0010\rJ\u0017\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u001bH&¢\u0006\u0004\b\u001d\u0010\u001eJ\u0019\u0010\u001d\u001a\u00020\u00032\b\b\u0001\u0010\u001f\u001a\u00020\u0006H&¢\u0006\u0004\b\u001d\u0010\u0015J\u0019\u0010\"\u001a\u00020\u00032\b\u0010!\u001a\u0004\u0018\u00010 H&¢\u0006\u0004\b\"\u0010#J\u0017\u0010&\u001a\u00020\u00032\u0006\u0010%\u001a\u00020$H&¢\u0006\u0004\b&\u0010'J\u000f\u0010(\u001a\u00020$H&¢\u0006\u0004\b(\u0010)J\u0017\u0010*\u001a\u00020\u00032\u0006\u0010%\u001a\u00020$H&¢\u0006\u0004\b*\u0010'J-\u0010.\u001a\u00020\u00032\u0006\u0010+\u001a\u00020\u00062\b\b\u0001\u0010,\u001a\u00020\u00062\n\b\u0001\u0010-\u001a\u0004\u0018\u00010\u0006H&¢\u0006\u0004\b.\u0010/¨\u00060"}, d2 = {"Lru/avito/component/appbar/AppBar;", "", "Lio/reactivex/rxjava3/core/Observable;", "", "navigationCallbacks", "()Lio/reactivex/rxjava3/core/Observable;", "", "menuCallbacks", "drawableRes", "tintColorAttrId", "setNavigationIcon", "(ILjava/lang/Integer;)V", "showToolbar", "()V", "", "Lcom/avito/android/util/ActionMenu;", "actions", "showActionsMenu", "(Ljava/util/List;)V", "menuId", "setMenu", "(I)V", "menuTintColor", "setMenuTintColor", "menuTintColorAttr", "setMenuTintColorAttr", "hideActionsMenu", "", "title", "setTitle", "(Ljava/lang/CharSequence;)V", "stringRes", "Lcom/avito/android/image_loader/Picture;", "picture", "setIcon", "(Lcom/avito/android/image_loader/Picture;)V", "", "visible", "setVisible", "(Z)V", "isVisible", "()Z", "setShadowVisible", "itemPosition", "icon", "tintColorAttr", "setActionMenuItemIcon", "(IILjava/lang/Integer;)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public interface AppBar {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ void setNavigationIcon$default(AppBar appBar, int i, Integer num, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 2) != 0) {
                    num = null;
                }
                appBar.setNavigationIcon(i, num);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setNavigationIcon");
        }
    }

    void hideActionsMenu();

    boolean isVisible();

    @NotNull
    Observable<Integer> menuCallbacks();

    @NotNull
    Observable<Unit> navigationCallbacks();

    void setActionMenuItemIcon(int i, @DrawableRes int i2, @AttrRes @Nullable Integer num);

    void setIcon(@Nullable Picture picture);

    void setMenu(@MenuRes int i);

    void setMenuTintColor(@ColorRes int i);

    void setMenuTintColorAttr(@AttrRes int i);

    void setNavigationIcon(@DrawableRes int i, @AttrRes @Nullable Integer num);

    void setShadowVisible(boolean z);

    void setTitle(@StringRes int i);

    void setTitle(@NotNull CharSequence charSequence);

    void setVisible(boolean z);

    void showActionsMenu(@NotNull List<ActionMenu> list);

    void showToolbar();
}
