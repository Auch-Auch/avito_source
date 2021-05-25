package com.avito.android.authorization.reset_password;

import a2.g.r.g;
import android.app.Dialog;
import android.view.View;
import com.avito.android.authorization.R;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.messenger.context_actions.PlatformActions;
import com.avito.android.util.ButtonsKt;
import com.avito.android.util.DialogRouter;
import com.avito.android.util.Keyboards;
import com.avito.android.util.Views;
import com.avito.android.util.rx3.InteropKt;
import io.reactivex.Observable;
import io.reactivex.functions.Predicate;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import ru.avito.component.appbar.AppBarImpl;
import ru.avito.component.button.ButtonImpl;
import ru.avito.component.info_label.InfoLabel;
import ru.avito.component.info_label.InfoLevel;
import ru.avito.component.text_input.EditTextSingleLineImpl;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010>\u001a\u000208\u0012\u0006\u00107\u001a\u000204¢\u0006\u0004\b?\u0010@J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0005J3\u0010\t\u001a&\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00060\u0006 \b*\u0012\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00060\u0006\u0018\u00010\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\u0005J\u0017\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0010\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0011\u0010\u000fJ\u0017\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0015\u0010\u000fJ\u0017\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0017\u0010\u0014J\u0017\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0018\u0010\u0014J\u000f\u0010\u0019\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0019\u0010\u000fJ%\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00032\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00060\u001aH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001e\u0010\u000fJ\u000f\u0010\u001f\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001f\u0010\u000fR\u0018\u0010#\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u0016\u00107\u001a\u0002048\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b5\u00106R\u0016\u0010;\u001a\u0002088\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010=\u001a\u0002088\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b<\u0010:¨\u0006A"}, d2 = {"Lcom/avito/android/authorization/reset_password/ResetPasswordViewImpl;", "Lcom/avito/android/authorization/reset_password/ResetPasswordView;", "Lio/reactivex/Observable;", "", "loginChanges", "()Lio/reactivex/Observable;", "", "navigationClicks", "kotlin.jvm.PlatformType", "resetPasswordClicks", "", "enabled", "setResetPasswordButtonEnabled", "(Z)V", PlatformActions.HIDE_KEYBOARD, "()V", "showProgress", "hideProgress", "message", "showError", "(Ljava/lang/String;)V", "showUnknownError", "login", "setLogin", "showLoginError", "hideLoginError", "Lkotlin/Function0;", "onOk", "showUserDialog", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "closeUserDialog", "requestFieldFocus", "Landroid/app/Dialog;", g.a, "Landroid/app/Dialog;", "userDialog", "Lru/avito/component/appbar/AppBarImpl;", AuthSource.BOOKING_ORDER, "Lru/avito/component/appbar/AppBarImpl;", "appBar", "Lru/avito/component/button/ButtonImpl;", "e", "Lru/avito/component/button/ButtonImpl;", "resetPasswordButton", "Lru/avito/component/text_input/EditTextSingleLineImpl;", "c", "Lru/avito/component/text_input/EditTextSingleLineImpl;", "loginView", "Lru/avito/component/info_label/InfoLabel;", "d", "Lru/avito/component/info_label/InfoLabel;", "loginLabel", "Lcom/avito/android/util/DialogRouter;", "h", "Lcom/avito/android/util/DialogRouter;", "dialogRouter", "Landroid/view/View;", AuthSource.SEND_ABUSE, "Landroid/view/View;", "contentView", "f", "progressView", "view", "<init>", "(Landroid/view/View;Lcom/avito/android/util/DialogRouter;)V", "authorization_release"}, k = 1, mv = {1, 4, 2})
public final class ResetPasswordViewImpl implements ResetPasswordView {
    public final View a;
    public final AppBarImpl b;
    public final EditTextSingleLineImpl c;
    public final InfoLabel d;
    public final ButtonImpl e;
    public final View f;
    public Dialog g;
    public final DialogRouter h;

    public static final class a<T> implements Predicate<Unit> {
        public final /* synthetic */ ResetPasswordViewImpl a;

        public a(ResetPasswordViewImpl resetPasswordViewImpl) {
            this.a = resetPasswordViewImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Predicate
        public boolean test(Unit unit) {
            Intrinsics.checkNotNullParameter(unit, "it");
            return this.a.e.isEnabled();
        }
    }

    public static final class b extends Lambda implements Function0<Unit> {
        public static final b a = new b();

        public b() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            return Unit.INSTANCE;
        }
    }

    public ResetPasswordViewImpl(@NotNull View view, @NotNull DialogRouter dialogRouter) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(dialogRouter, "dialogRouter");
        this.h = dialogRouter;
        View findViewById = view.findViewById(R.id.content_container);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.view.View");
        this.a = findViewById;
        AppBarImpl appBarImpl = new AppBarImpl(view, null, false, 4, null);
        appBarImpl.setTitle(R.string.reset_password_title);
        Unit unit = Unit.INSTANCE;
        this.b = appBarImpl;
        View findViewById2 = view.findViewById(R.id.login_view);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.view.View");
        EditTextSingleLineImpl editTextSingleLineImpl = new EditTextSingleLineImpl(findViewById2);
        editTextSingleLineImpl.setHint(R.string.phone_or_email);
        editTextSingleLineImpl.setInputType(33);
        editTextSingleLineImpl.setImeOptions(268435462);
        editTextSingleLineImpl.setAutofillHints("emailAddress", "phone");
        this.c = editTextSingleLineImpl;
        View findViewById3 = view.findViewById(R.id.login_label);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type android.view.View");
        this.d = new InfoLabel(findViewById3);
        View findViewById4 = view.findViewById(R.id.reset_password_button);
        Objects.requireNonNull(findViewById4, "null cannot be cast to non-null type android.view.View");
        ButtonImpl buttonImpl = new ButtonImpl(findViewById4);
        buttonImpl.setText(R.string.reset_password);
        this.e = buttonImpl;
        View findViewById5 = view.findViewById(R.id.progress_view);
        Objects.requireNonNull(findViewById5, "null cannot be cast to non-null type android.view.View");
        this.f = findViewById5;
    }

    @Override // com.avito.android.authorization.reset_password.ResetPasswordView
    public void closeUserDialog() {
        Dialog dialog = this.g;
        if (dialog != null) {
            dialog.hide();
        }
    }

    @Override // com.avito.android.authorization.reset_password.ResetPasswordView
    public void hideKeyboard() {
        Keyboards.hideKeyboard$default(this.a, false, 1, null);
    }

    @Override // com.avito.android.authorization.reset_password.ResetPasswordView
    public void hideLoginError() {
        this.d.setVisible(false);
    }

    @Override // com.avito.android.authorization.reset_password.ResetPasswordView
    public void hideProgress() {
        Views.hide(this.f);
    }

    @Override // com.avito.android.authorization.reset_password.ResetPasswordView
    @NotNull
    public Observable<String> loginChanges() {
        return InteropKt.toV2(this.c.textChangeCallbacks());
    }

    @Override // com.avito.android.authorization.reset_password.ResetPasswordView
    @NotNull
    public Observable<Unit> navigationClicks() {
        return InteropKt.toV2(this.b.navigationCallbacks());
    }

    @Override // com.avito.android.authorization.reset_password.ResetPasswordView
    public void requestFieldFocus() {
        this.c.showKeyboard();
        this.c.moveCursorToEnd();
    }

    @Override // com.avito.android.authorization.reset_password.ResetPasswordView
    public Observable<Unit> resetPasswordClicks() {
        return Observable.merge(InteropKt.toV2(ButtonsKt.clicks(this.e)), InteropKt.toV2(this.c.doneCallbacks())).filter(new a(this));
    }

    @Override // com.avito.android.authorization.reset_password.ResetPasswordView
    public void setLogin(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "login");
        this.c.setText(str);
    }

    @Override // com.avito.android.authorization.reset_password.ResetPasswordView
    public void setResetPasswordButtonEnabled(boolean z) {
        this.e.setEnabled(z);
    }

    @Override // com.avito.android.authorization.reset_password.ResetPasswordView
    public void showError(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        Views.showSnackBar$default(this.a, str, 0, (String) null, 0, (Function0) null, (Function0) null, 0, 126, (Object) null);
    }

    @Override // com.avito.android.authorization.reset_password.ResetPasswordView
    public void showLoginError(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        this.d.setValues(str, InfoLevel.ERROR);
        this.d.setVisible(true);
    }

    @Override // com.avito.android.authorization.reset_password.ResetPasswordView
    public void showProgress() {
        Views.show(this.f);
    }

    @Override // com.avito.android.authorization.reset_password.ResetPasswordView
    public void showUnknownError() {
        Views.showSnackBar$default(this.a, com.avito.android.remote.R.string.unknown_server_error, 0, (Integer) null, 0, (Function0) null, (Function0) null, 0, 126, (Object) null);
    }

    @Override // com.avito.android.authorization.reset_password.ResetPasswordView
    public void showUserDialog(@NotNull String str, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(str, "message");
        Intrinsics.checkNotNullParameter(function0, "onOk");
        this.g = this.h.showSimpleNotifyingDialog(str, function0, b.a);
    }
}
