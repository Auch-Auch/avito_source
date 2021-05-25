package com.avito.android.component.navigation_drawer;

import android.content.res.ColorStateList;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import androidx.annotation.StringRes;
import com.avito.android.deprecated_design.R;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.TextViews;
import com.avito.android.util.Views;
import com.jakewharton.rxbinding3.view.RxView;
import io.reactivex.Observable;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u001e\u001a\u00020\u001b¢\u0006\u0004\b%\u0010&J\u0019\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0007\u0010\nJ\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0010\u0010\u0006J\u0017\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001a\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010$\u001a\u00020\u001f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010!¨\u0006'"}, d2 = {"Lcom/avito/android/component/navigation_drawer/NavigationDrawerItemImpl;", "Lcom/avito/android/component/navigation_drawer/NavigationDrawerItem;", "", "id", "", "setIcon", "(I)V", "setText", "", "text", "(Ljava/lang/String;)V", "Landroid/content/res/ColorStateList;", "color", "setTextColor", "(Landroid/content/res/ColorStateList;)V", "count", "setCount", "", "isSelected", "setSelected", "(Z)V", "Lio/reactivex/Observable;", "clicks", "()Lio/reactivex/Observable;", "show", "()V", "hide", "Landroid/view/View;", "c", "Landroid/view/View;", "rootView", "Landroid/widget/TextView;", AuthSource.SEND_ABUSE, "Landroid/widget/TextView;", "textView", AuthSource.BOOKING_ORDER, "counterView", "<init>", "(Landroid/view/View;)V", "deprecated-components_release"}, k = 1, mv = {1, 4, 2})
public final class NavigationDrawerItemImpl implements NavigationDrawerItem {
    public final TextView a;
    public final TextView b;
    public final View c;

    public NavigationDrawerItemImpl(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "rootView");
        this.c = view;
        View findViewById = view.findViewById(R.id.text);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
        this.a = (TextView) findViewById;
        View findViewById2 = view.findViewById(R.id.counter);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
        this.b = (TextView) findViewById2;
    }

    @Override // com.avito.android.component.navigation_drawer.NavigationDrawerItem
    @NotNull
    public Observable<Unit> clicks() {
        return RxView.clicks(this.c);
    }

    @Override // com.avito.android.component.navigation_drawer.NavigationDrawerItem
    public void hide() {
        Views.hide(this.c);
    }

    @Override // com.avito.android.component.navigation_drawer.NavigationDrawerItem
    public void setCount(int i) {
        if (i <= 0) {
            this.b.setText((CharSequence) null);
            Views.hide(this.b);
        } else if (i >= 99) {
            this.b.setText(R.string.more_than_ninety_nine);
            Views.show(this.b);
        } else {
            this.b.setText(String.valueOf(i));
            Views.show(this.b);
        }
    }

    @Override // com.avito.android.component.navigation_drawer.NavigationDrawerItem
    public void setIcon(@DrawableRes int i) {
        TextViews.setCompoundDrawables$default(this.a, i, 0, 0, 0, 14, (Object) null);
    }

    @Override // com.avito.android.component.navigation_drawer.NavigationDrawerItem
    public void setSelected(boolean z) {
        this.c.setSelected(z);
        this.a.setSelected(z);
    }

    @Override // com.avito.android.component.navigation_drawer.NavigationDrawerItem
    public void setText(@StringRes int i) {
        this.a.setText(i);
    }

    @Override // com.avito.android.component.navigation_drawer.NavigationDrawerItem
    public void setTextColor(@NotNull ColorStateList colorStateList) {
        Intrinsics.checkNotNullParameter(colorStateList, "color");
        this.a.setTextColor(colorStateList);
    }

    @Override // com.avito.android.component.navigation_drawer.NavigationDrawerItem
    public void show() {
        Views.show(this.c);
    }

    @Override // com.avito.android.component.navigation_drawer.NavigationDrawerItem
    public void setText(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        this.a.setText(str);
    }
}
