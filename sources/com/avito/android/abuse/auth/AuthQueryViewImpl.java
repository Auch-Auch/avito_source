package com.avito.android.abuse.auth;

import a2.g.r.g;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.AttrRes;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.MenuRes;
import androidx.annotation.StringRes;
import androidx.appcompat.widget.Toolbar;
import com.avito.android.deprecated_design.R;
import com.avito.android.image_loader.Picture;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.ActionMenu;
import com.avito.android.util.ButtonsKt;
import com.avito.android.util.Views;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.component.appbar.AppBar;
import ru.avito.component.appbar.AppBarImpl;
import ru.avito.component.button.Button;
import ru.avito.component.button.ButtonImpl;
import ru.avito.component.text.Text;
import ru.avito.component.text.TextImpl;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u00107\u001a\u000204¢\u0006\u0004\bK\u0010LJ\u0015\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0016¢\u0006\u0004\b\u0007\u0010\u0006J\u0015\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0016¢\u0006\u0004\b\b\u0010\u0006J\u0010\u0010\t\u001a\u00020\u0004H\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bH\u0001¢\u0006\u0004\b\f\u0010\rJ\u0016\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0003H\u0001¢\u0006\u0004\b\u000f\u0010\u0006J\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0001¢\u0006\u0004\b\u0010\u0010\u0006J.\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u000e2\b\b\u0001\u0010\u0012\u001a\u00020\u000e2\n\b\u0001\u0010\u0013\u001a\u0004\u0018\u00010\u000eH\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0018\u001a\u00020\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u001b\u001a\u00020\u00042\b\b\u0001\u0010\u001a\u001a\u00020\u000eH\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u001a\u0010\u001e\u001a\u00020\u00042\b\b\u0001\u0010\u001d\u001a\u00020\u000eH\u0001¢\u0006\u0004\b\u001e\u0010\u001cJ\u001a\u0010 \u001a\u00020\u00042\b\b\u0001\u0010\u001f\u001a\u00020\u000eH\u0001¢\u0006\u0004\b \u0010\u001cJ&\u0010#\u001a\u00020\u00042\b\b\u0001\u0010!\u001a\u00020\u000e2\n\b\u0003\u0010\"\u001a\u0004\u0018\u00010\u000eH\u0001¢\u0006\u0004\b#\u0010$J\u0018\u0010&\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\u000bH\u0001¢\u0006\u0004\b&\u0010'J\u0018\u0010*\u001a\u00020\u00042\u0006\u0010)\u001a\u00020(H\u0001¢\u0006\u0004\b*\u0010+J\u001a\u0010*\u001a\u00020\u00042\b\b\u0001\u0010,\u001a\u00020\u000eH\u0001¢\u0006\u0004\b*\u0010\u001cJ\u0018\u0010-\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\u000bH\u0001¢\u0006\u0004\b-\u0010'J\u001e\u00101\u001a\u00020\u00042\f\u00100\u001a\b\u0012\u0004\u0012\u00020/0.H\u0001¢\u0006\u0004\b1\u00102J\u0010\u00103\u001a\u00020\u0004H\u0001¢\u0006\u0004\b3\u0010\nR\u0016\u00107\u001a\u0002048\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b5\u00106R\u0016\u0010;\u001a\u0002088\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010)\u001a\u00020<8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010B\u001a\u00020?8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010F\u001a\u00020C8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bD\u0010ER\u0016\u0010H\u001a\u00020<8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bG\u0010>R\u0016\u0010J\u001a\u00020?8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bI\u0010A¨\u0006M"}, d2 = {"Lcom/avito/android/abuse/auth/AuthQueryViewImpl;", "Lcom/avito/android/abuse/auth/AuthQueryView;", "Lru/avito/component/appbar/AppBar;", "Lio/reactivex/rxjava3/core/Observable;", "", "backClicks", "()Lio/reactivex/rxjava3/core/Observable;", "authClicks", "sendClicks", "hideActionsMenu", "()V", "", "isVisible", "()Z", "", "menuCallbacks", "navigationCallbacks", "itemPosition", "icon", "tintColorAttr", "setActionMenuItemIcon", "(IILjava/lang/Integer;)V", "Lcom/avito/android/image_loader/Picture;", "picture", "setIcon", "(Lcom/avito/android/image_loader/Picture;)V", "menuId", "setMenu", "(I)V", "menuTintColor", "setMenuTintColor", "menuTintColorAttr", "setMenuTintColorAttr", "drawableRes", "tintColorAttrId", "setNavigationIcon", "(ILjava/lang/Integer;)V", "visible", "setShadowVisible", "(Z)V", "", "title", "setTitle", "(Ljava/lang/CharSequence;)V", "stringRes", "setVisible", "", "Lcom/avito/android/util/ActionMenu;", "actions", "showActionsMenu", "(Ljava/util/List;)V", "showToolbar", "Landroid/view/ViewGroup;", g.a, "Landroid/view/ViewGroup;", "rootView", "Landroid/view/View;", AuthSource.BOOKING_ORDER, "Landroid/view/View;", "toolbarShadow", "Lru/avito/component/text/Text;", "c", "Lru/avito/component/text/Text;", "Lru/avito/component/button/Button;", "f", "Lru/avito/component/button/Button;", "sendButton", "Landroidx/appcompat/widget/Toolbar;", AuthSource.SEND_ABUSE, "Landroidx/appcompat/widget/Toolbar;", "toolbar", "d", "description", "e", "authButton", "<init>", "(Landroid/view/ViewGroup;)V", "abuse_release"}, k = 1, mv = {1, 4, 2})
public final class AuthQueryViewImpl implements AuthQueryView, AppBar {
    public final Toolbar a;
    public final View b;
    public final Text c;
    public final Text d;
    public final Button e;
    public final Button f;
    public final ViewGroup g;
    public final /* synthetic */ AppBarImpl h;

    public static final class a<T> implements ObservableOnSubscribe<Unit> {
        public final /* synthetic */ AuthQueryViewImpl a;

        /* renamed from: com.avito.android.abuse.auth.AuthQueryViewImpl$a$a  reason: collision with other inner class name */
        public static final class View$OnClickListenerC0126a implements View.OnClickListener {
            public final /* synthetic */ ObservableEmitter a;

            public View$OnClickListenerC0126a(ObservableEmitter observableEmitter) {
                this.a = observableEmitter;
            }

            /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: io.reactivex.rxjava3.core.ObservableEmitter */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.onNext(Unit.INSTANCE);
            }
        }

        public a(AuthQueryViewImpl authQueryViewImpl) {
            this.a = authQueryViewImpl;
        }

        @Override // io.reactivex.rxjava3.core.ObservableOnSubscribe
        public final void subscribe(ObservableEmitter<Unit> observableEmitter) {
            this.a.a.setNavigationOnClickListener(new View$OnClickListenerC0126a(observableEmitter));
        }
    }

    public AuthQueryViewImpl(@NotNull ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "rootView");
        this.h = new AppBarImpl(viewGroup, null, false, 4, null);
        this.g = viewGroup;
        View findViewById = viewGroup.findViewById(R.id.toolbar);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type androidx.appcompat.widget.Toolbar");
        Toolbar toolbar = (Toolbar) findViewById;
        this.a = toolbar;
        View findViewById2 = viewGroup.findViewById(com.avito.android.ui_components.R.id.shadow);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.view.View");
        this.b = findViewById2;
        View findViewById3 = viewGroup.findViewById(com.avito.android.abuse.R.id.title);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type android.view.View");
        TextImpl textImpl = new TextImpl(findViewById3);
        this.c = textImpl;
        View findViewById4 = viewGroup.findViewById(com.avito.android.abuse.R.id.description);
        Objects.requireNonNull(findViewById4, "null cannot be cast to non-null type android.view.View");
        TextImpl textImpl2 = new TextImpl(findViewById4);
        this.d = textImpl2;
        View findViewById5 = viewGroup.findViewById(com.avito.android.abuse.R.id.auth_button);
        Objects.requireNonNull(findViewById5, "null cannot be cast to non-null type android.view.View");
        ButtonImpl buttonImpl = new ButtonImpl(findViewById5);
        this.e = buttonImpl;
        View findViewById6 = viewGroup.findViewById(com.avito.android.abuse.R.id.send_button);
        Objects.requireNonNull(findViewById6, "null cannot be cast to non-null type android.view.View");
        ButtonImpl buttonImpl2 = new ButtonImpl(findViewById6);
        this.f = buttonImpl2;
        textImpl.setText(com.avito.android.abuse.R.string.abuse_ready_to_be_sent);
        textImpl2.setText(com.avito.android.abuse.R.string.auth_to_handle_notification);
        buttonImpl.setText(com.avito.android.ui_components.R.string.login);
        buttonImpl2.setText(com.avito.android.ui_components.R.string.send);
        toolbar.setTitle(com.avito.android.abuse.R.string.abuse_details_title);
        Views.show(findViewById2);
    }

    @Override // com.avito.android.abuse.auth.AuthQueryView
    @NotNull
    public Observable<Unit> authClicks() {
        return ButtonsKt.clicks(this.e);
    }

    @Override // com.avito.android.abuse.auth.AuthQueryView
    @NotNull
    public Observable<Unit> backClicks() {
        Observable<Unit> create = Observable.create(new a(this));
        Intrinsics.checkNotNullExpressionValue(create, "Observable.create { emit…ext(Unit)\n        }\n    }");
        return create;
    }

    @Override // ru.avito.component.appbar.AppBar
    public void hideActionsMenu() {
        this.h.hideActionsMenu();
    }

    @Override // ru.avito.component.appbar.AppBar
    public boolean isVisible() {
        return this.h.isVisible();
    }

    @Override // ru.avito.component.appbar.AppBar
    @NotNull
    public Observable<Integer> menuCallbacks() {
        return this.h.menuCallbacks();
    }

    @Override // ru.avito.component.appbar.AppBar
    @NotNull
    public Observable<Unit> navigationCallbacks() {
        return this.h.navigationCallbacks();
    }

    @Override // com.avito.android.abuse.auth.AuthQueryView
    @NotNull
    public Observable<Unit> sendClicks() {
        return ButtonsKt.clicks(this.f);
    }

    @Override // ru.avito.component.appbar.AppBar
    public void setActionMenuItemIcon(int i, @DrawableRes int i2, @AttrRes @Nullable Integer num) {
        this.h.setActionMenuItemIcon(i, i2, num);
    }

    @Override // ru.avito.component.appbar.AppBar
    public void setIcon(@Nullable Picture picture) {
        this.h.setIcon(picture);
    }

    @Override // ru.avito.component.appbar.AppBar
    public void setMenu(@MenuRes int i) {
        this.h.setMenu(i);
    }

    @Override // ru.avito.component.appbar.AppBar
    public void setMenuTintColor(@ColorRes int i) {
        this.h.setMenuTintColor(i);
    }

    @Override // ru.avito.component.appbar.AppBar
    public void setMenuTintColorAttr(@AttrRes int i) {
        this.h.setMenuTintColorAttr(i);
    }

    @Override // ru.avito.component.appbar.AppBar
    public void setNavigationIcon(@DrawableRes int i, @AttrRes @Nullable Integer num) {
        this.h.setNavigationIcon(i, num);
    }

    @Override // ru.avito.component.appbar.AppBar
    public void setShadowVisible(boolean z) {
        this.h.setShadowVisible(z);
    }

    @Override // ru.avito.component.appbar.AppBar
    public void setTitle(@StringRes int i) {
        this.h.setTitle(i);
    }

    @Override // ru.avito.component.appbar.AppBar
    public void setTitle(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "title");
        this.h.setTitle(charSequence);
    }

    @Override // ru.avito.component.appbar.AppBar
    public void setVisible(boolean z) {
        this.h.setVisible(z);
    }

    @Override // ru.avito.component.appbar.AppBar
    public void showActionsMenu(@NotNull List<ActionMenu> list) {
        Intrinsics.checkNotNullParameter(list, "actions");
        this.h.showActionsMenu(list);
    }

    @Override // ru.avito.component.appbar.AppBar
    public void showToolbar() {
        this.h.showToolbar();
    }
}
