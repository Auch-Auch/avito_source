package com.avito.android.component.navigation_drawer;

import android.content.res.ColorStateList;
import androidx.annotation.DrawableRes;
import androidx.annotation.StringRes;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\u0007\u0010\nJ\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0002H&¢\u0006\u0004\b\u0010\u0010\u0006J\u0017\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011H&¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\u0015H&¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0004H&¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0004H&¢\u0006\u0004\b\u001a\u0010\u0019¨\u0006\u001b"}, d2 = {"Lcom/avito/android/component/navigation_drawer/NavigationDrawerItem;", "", "", "id", "", "setIcon", "(I)V", "setText", "", "text", "(Ljava/lang/String;)V", "Landroid/content/res/ColorStateList;", "color", "setTextColor", "(Landroid/content/res/ColorStateList;)V", "count", "setCount", "", "isSelected", "setSelected", "(Z)V", "Lio/reactivex/Observable;", "clicks", "()Lio/reactivex/Observable;", "show", "()V", "hide", "deprecated-components_release"}, k = 1, mv = {1, 4, 2})
public interface NavigationDrawerItem {
    @NotNull
    Observable<Unit> clicks();

    void hide();

    void setCount(int i);

    void setIcon(@DrawableRes int i);

    void setSelected(boolean z);

    void setText(@StringRes int i);

    void setText(@NotNull String str);

    void setTextColor(@NotNull ColorStateList colorStateList);

    void show();
}
