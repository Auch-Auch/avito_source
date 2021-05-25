package com.avito.android.authorization.login;

import a2.g.r.g;
import android.app.Dialog;
import android.content.Context;
import android.text.SpannableString;
import android.text.style.StyleSpan;
import android.view.View;
import com.avito.android.authorization.R;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.messenger.context_actions.PlatformActions;
import com.avito.android.util.ButtonsKt;
import com.avito.android.util.DialogRouter;
import com.avito.android.util.Keyboards;
import com.avito.android.util.ToastsKt;
import com.avito.android.util.Views;
import com.avito.android.util.preferences.Preference;
import com.avito.android.util.rx3.InteropKt;
import io.reactivex.Observable;
import io.reactivex.functions.Predicate;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import ru.avito.component.appbar.AppBarImpl;
import ru.avito.component.button.ButtonImpl;
import ru.avito.component.info_label.InfoLabel;
import ru.avito.component.info_label.InfoLevel;
import ru.avito.component.text.Text;
import ru.avito.component.text.TextImpl;
import ru.avito.component.text_input.EditTextSingleLine;
import ru.avito.component.text_input.EditTextSingleLineImpl;
import ru.avito.component.text_input.password.EditTextPasswordImpl;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010f\u001a\u00020:\u0012\u0006\u0010U\u001a\u00020R¢\u0006\u0004\bg\u0010hJ\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0005J\u0015\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0005J3\u0010\n\u001a&\u0012\f\u0012\n \t*\u0004\u0018\u00010\u00070\u0007 \t*\u0012\u0012\f\u0012\n \t*\u0004\u0018\u00010\u00070\u0007\u0018\u00010\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u0005J\u0015\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\u0005J\u0017\u0010\u000e\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0012\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0013\u0010\u0011J\u0017\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0017\u0010\u0011J\u0017\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0019\u0010\u0016J\u0017\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u001b\u0010\u0016J\u000f\u0010\u001c\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u001c\u0010\u0011J\u000f\u0010\u001d\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u001d\u0010\u0011J\u000f\u0010\u001e\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u001e\u0010\u0011J\u0017\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u001f\u0010\u0016J\u000f\u0010 \u001a\u00020\u0007H\u0016¢\u0006\u0004\b \u0010\u0011J\u0017\u0010!\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0003H\u0016¢\u0006\u0004\b!\u0010\u0016J\u000f\u0010\"\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\"\u0010\u0011J\u001f\u0010%\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\u0003H\u0016¢\u0006\u0004\b%\u0010&J\u000f\u0010'\u001a\u00020\u0007H\u0016¢\u0006\u0004\b'\u0010\u0011JC\u0010-\u001a\u00020\u00072\u0006\u0010(\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010)\u001a\u00020\u00032\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00070*2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00070*H\u0016¢\u0006\u0004\b-\u0010.JK\u0010-\u001a\u00020\u00072\u0006\u0010(\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010/\u001a\u00020\u00032\f\u00100\u001a\b\u0012\u0004\u0012\u00020\u00070*2\u0006\u00101\u001a\u00020\u00032\f\u00102\u001a\b\u0012\u0004\u0012\u00020\u00070*H\u0016¢\u0006\u0004\b-\u00103J'\u0010-\u001a\u00020\u00072\u0006\u0010(\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u00105\u001a\u000204H\u0016¢\u0006\u0004\b-\u00106J\u001f\u0010-\u001a\u00020\u00072\u0006\u0010(\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0003H\u0016¢\u0006\u0004\b-\u0010&J\u0017\u0010-\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0003H\u0016¢\u0006\u0004\b-\u0010\u0016J\u000f\u00107\u001a\u00020\u0007H\u0016¢\u0006\u0004\b7\u0010\u0011J\u000f\u00108\u001a\u00020\u0007H\u0016¢\u0006\u0004\b8\u0010\u0011J\u0017\u00109\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0003H\u0016¢\u0006\u0004\b9\u0010\u0016R\u0016\u0010=\u001a\u00020:8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010?\u001a\u00020:8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b>\u0010<R\u0016\u0010C\u001a\u00020@8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010G\u001a\u00020D8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bE\u0010FR\u0016\u0010K\u001a\u00020H8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bI\u0010JR\u0016\u0010M\u001a\u00020D8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bL\u0010FR\u0016\u0010Q\u001a\u00020N8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bO\u0010PR\u0016\u0010U\u001a\u00020R8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bS\u0010TR\u0016\u0010Y\u001a\u00020V8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bW\u0010XR\u0016\u0010[\u001a\u00020V8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bZ\u0010XR\u0018\u0010_\u001a\u0004\u0018\u00010\\8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b]\u0010^R\u0016\u0010c\u001a\u00020`8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\ba\u0010bR\u0016\u0010e\u001a\u00020:8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bd\u0010<¨\u0006i"}, d2 = {"Lcom/avito/android/authorization/login/LoginViewImpl;", "Lcom/avito/android/authorization/login/LoginView;", "Lio/reactivex/Observable;", "", "loginChanges", "()Lio/reactivex/Observable;", "passwordChanges", "", "navigationClicks", "kotlin.jvm.PlatformType", "loginClicks", "forgotPasswordClicks", "", "enabled", "setLoginButtonEnabled", "(Z)V", PlatformActions.HIDE_KEYBOARD, "()V", "showProgress", "hideProgress", "message", "showError", "(Ljava/lang/String;)V", "showUnknownError", "login", "setLogin", Preference.PASSWORD, "setPassword", "showLogin", "hideLogin", "setFocusOnPasswordField", "showLoginError", "hideLoginError", "showPasswordError", "hidePasswordError", "text", "highlightText", "showText", "(Ljava/lang/String;Ljava/lang/String;)V", "hideText", "title", "agreeButtonTitle", "Lkotlin/Function0;", "onAgree", "onCancel", "showUserDialog", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "firstActionButtonTitle", "onFirstAction", "secondActionButtonTitle", "onSecondAction", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "", "action", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/CharSequence;)V", "closeUserDialog", "requestFieldFocus", "showToast", "Landroid/view/View;", "c", "Landroid/view/View;", "loginInputContainer", AuthSource.SEND_ABUSE, "contentView", "Lru/avito/component/text_input/EditTextSingleLineImpl;", "d", "Lru/avito/component/text_input/EditTextSingleLineImpl;", "loginView", "Lru/avito/component/info_label/InfoLabel;", g.a, "Lru/avito/component/info_label/InfoLabel;", "passwordLabel", "Lru/avito/component/text_input/password/EditTextPasswordImpl;", "f", "Lru/avito/component/text_input/password/EditTextPasswordImpl;", "passwordView", "e", "loginLabel", "Lru/avito/component/appbar/AppBarImpl;", AuthSource.BOOKING_ORDER, "Lru/avito/component/appbar/AppBarImpl;", "appBar", "Lcom/avito/android/util/DialogRouter;", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/android/util/DialogRouter;", "dialogRouter", "Lru/avito/component/button/ButtonImpl;", "i", "Lru/avito/component/button/ButtonImpl;", "loginButton", "j", "forgotPasswordButton", "Landroid/app/Dialog;", "l", "Landroid/app/Dialog;", "userDialog", "Lru/avito/component/text/Text;", "h", "Lru/avito/component/text/Text;", "textView", "k", "progressView", "view", "<init>", "(Landroid/view/View;Lcom/avito/android/util/DialogRouter;)V", "authorization_release"}, k = 1, mv = {1, 4, 2})
public final class LoginViewImpl implements LoginView {
    public final View a;
    public final AppBarImpl b;
    public final View c;
    public final EditTextSingleLineImpl d;
    public final InfoLabel e;
    public final EditTextPasswordImpl f;
    public final InfoLabel g;
    public final Text h;
    public final ButtonImpl i;
    public final ButtonImpl j;
    public final View k;
    public Dialog l;
    public final DialogRouter m;

    /* compiled from: kotlin-style lambda group */
    public static final class a extends Lambda implements Function0<Unit> {
        public static final a b = new a(0);
        public static final a c = new a(1);
        public final /* synthetic */ int a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(int i) {
            super(0);
            this.a = i;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            int i = this.a;
            if (i == 0) {
                return Unit.INSTANCE;
            }
            if (i == 1) {
                return Unit.INSTANCE;
            }
            throw null;
        }
    }

    public static final class b<T> implements Predicate<Unit> {
        public final /* synthetic */ LoginViewImpl a;

        public b(LoginViewImpl loginViewImpl) {
            this.a = loginViewImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Predicate
        public boolean test(Unit unit) {
            Intrinsics.checkNotNullParameter(unit, "it");
            return this.a.i.isEnabled();
        }
    }

    public LoginViewImpl(@NotNull View view, @NotNull DialogRouter dialogRouter) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(dialogRouter, "dialogRouter");
        this.m = dialogRouter;
        View findViewById = view.findViewById(R.id.content_container);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.view.View");
        this.a = findViewById;
        AppBarImpl appBarImpl = new AppBarImpl(view, null, false, 4, null);
        appBarImpl.setTitle(R.string.login_title);
        Unit unit = Unit.INSTANCE;
        this.b = appBarImpl;
        View findViewById2 = view.findViewById(R.id.login_input_container);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.view.View");
        this.c = findViewById2;
        View findViewById3 = view.findViewById(R.id.login_view);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type android.view.View");
        EditTextSingleLineImpl editTextSingleLineImpl = new EditTextSingleLineImpl(findViewById3);
        editTextSingleLineImpl.setHint(R.string.phone_or_email);
        editTextSingleLineImpl.setInputType(33);
        editTextSingleLineImpl.setAutofillHints("emailAddress", "phone");
        this.d = editTextSingleLineImpl;
        View findViewById4 = view.findViewById(R.id.login_label);
        Objects.requireNonNull(findViewById4, "null cannot be cast to non-null type android.view.View");
        this.e = new InfoLabel(findViewById4);
        View findViewById5 = view.findViewById(R.id.password_view);
        Objects.requireNonNull(findViewById5, "null cannot be cast to non-null type android.view.View");
        EditTextPasswordImpl editTextPasswordImpl = new EditTextPasswordImpl(findViewById5);
        editTextPasswordImpl.setHint(R.string.password);
        editTextPasswordImpl.setImeOptions(268435462);
        editTextPasswordImpl.setAutofillHints(Preference.PASSWORD);
        this.f = editTextPasswordImpl;
        View findViewById6 = view.findViewById(R.id.password_label);
        Objects.requireNonNull(findViewById6, "null cannot be cast to non-null type android.view.View");
        this.g = new InfoLabel(findViewById6);
        View findViewById7 = view.findViewById(R.id.text_view);
        Objects.requireNonNull(findViewById7, "null cannot be cast to non-null type android.view.View");
        this.h = new TextImpl(findViewById7);
        View findViewById8 = view.findViewById(R.id.login_button);
        Objects.requireNonNull(findViewById8, "null cannot be cast to non-null type android.view.View");
        ButtonImpl buttonImpl = new ButtonImpl(findViewById8);
        buttonImpl.setText(R.string.login_action);
        this.i = buttonImpl;
        View findViewById9 = view.findViewById(R.id.forgot_password_button);
        Objects.requireNonNull(findViewById9, "null cannot be cast to non-null type android.view.View");
        ButtonImpl buttonImpl2 = new ButtonImpl(findViewById9);
        buttonImpl2.setText(R.string.forgot_password);
        this.j = buttonImpl2;
        View findViewById10 = view.findViewById(R.id.progress_view);
        Objects.requireNonNull(findViewById10, "null cannot be cast to non-null type android.view.View");
        this.k = findViewById10;
    }

    @Override // com.avito.android.authorization.login.LoginView
    public void closeUserDialog() {
        Dialog dialog = this.l;
        if (dialog != null) {
            dialog.hide();
        }
    }

    @Override // com.avito.android.authorization.login.LoginView
    @NotNull
    public Observable<Unit> forgotPasswordClicks() {
        return InteropKt.toV2(ButtonsKt.clicks(this.j));
    }

    @Override // com.avito.android.authorization.login.LoginView
    public void hideKeyboard() {
        Keyboards.hideKeyboard$default(this.a, false, 1, null);
    }

    @Override // com.avito.android.authorization.login.LoginView
    public void hideLogin() {
        Views.hide(this.c);
    }

    @Override // com.avito.android.authorization.login.LoginView
    public void hideLoginError() {
        this.e.setVisible(false);
    }

    @Override // com.avito.android.authorization.login.LoginView
    public void hidePasswordError() {
        this.g.setVisible(false);
    }

    @Override // com.avito.android.authorization.login.LoginView
    public void hideProgress() {
        Views.hide(this.k);
    }

    @Override // com.avito.android.authorization.login.LoginView
    public void hideText() {
        this.h.hide();
    }

    @Override // com.avito.android.authorization.login.LoginView
    @NotNull
    public Observable<String> loginChanges() {
        return InteropKt.toV2(this.d.textChangeCallbacks());
    }

    @Override // com.avito.android.authorization.login.LoginView
    public Observable<Unit> loginClicks() {
        return Observable.merge(InteropKt.toV2(ButtonsKt.clicks(this.i)), InteropKt.toV2(this.f.doneCallbacks())).filter(new b(this));
    }

    @Override // com.avito.android.authorization.login.LoginView
    @NotNull
    public Observable<Unit> navigationClicks() {
        return InteropKt.toV2(this.b.navigationCallbacks());
    }

    @Override // com.avito.android.authorization.login.LoginView
    @NotNull
    public Observable<String> passwordChanges() {
        return InteropKt.toV2(this.f.textChangeCallbacks());
    }

    @Override // com.avito.android.authorization.login.LoginView
    public void requestFieldFocus() {
        EditTextSingleLine editTextSingleLine;
        if (Views.isVisible(this.c)) {
            editTextSingleLine = this.d;
        } else {
            editTextSingleLine = this.f;
        }
        editTextSingleLine.showKeyboard();
        editTextSingleLine.moveCursorToEnd();
    }

    @Override // com.avito.android.authorization.login.LoginView
    public void setFocusOnPasswordField() {
        this.f.showKeyboard();
    }

    @Override // com.avito.android.authorization.login.LoginView
    public void setLogin(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "login");
        this.d.setText(str);
    }

    @Override // com.avito.android.authorization.login.LoginView
    public void setLoginButtonEnabled(boolean z) {
        this.i.setEnabled(z);
    }

    @Override // com.avito.android.authorization.login.LoginView
    public void setPassword(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, Preference.PASSWORD);
        this.f.setText(str);
    }

    @Override // com.avito.android.authorization.login.LoginView
    public void showError(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        Views.showSnackBar$default(this.a, str, 0, (String) null, 0, (Function0) null, (Function0) null, 0, 126, (Object) null);
    }

    @Override // com.avito.android.authorization.login.LoginView
    public void showLogin() {
        Views.show(this.c);
    }

    @Override // com.avito.android.authorization.login.LoginView
    public void showLoginError(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        this.e.setValues(str, InfoLevel.ERROR);
        this.e.setVisible(true);
    }

    @Override // com.avito.android.authorization.login.LoginView
    public void showPasswordError(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        this.g.setValues(str, InfoLevel.ERROR);
        this.g.setVisible(true);
    }

    @Override // com.avito.android.authorization.login.LoginView
    public void showProgress() {
        Views.show(this.k);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: android.text.SpannableString */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.avito.android.authorization.login.LoginView
    public void showText(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "text");
        Intrinsics.checkNotNullParameter(str2, "highlightText");
        int indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) str, str2, 0, false, 6, (Object) null);
        Text text = this.h;
        if (indexOf$default >= 0) {
            SpannableString spannableString = new SpannableString(str);
            spannableString.setSpan(new StyleSpan(1), indexOf$default, str2.length() + indexOf$default, 33);
            Unit unit = Unit.INSTANCE;
            str = spannableString;
        }
        text.setText(str);
        this.h.show();
    }

    @Override // com.avito.android.authorization.login.LoginView
    public void showToast(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        Context context = this.a.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "contentView.context");
        ToastsKt.showToast(context, str, 1);
    }

    @Override // com.avito.android.authorization.login.LoginView
    public void showUnknownError() {
        Views.showSnackBar$default(this.a, com.avito.android.remote.R.string.unknown_server_error, 0, (Integer) null, 0, (Function0) null, (Function0) null, 0, 126, (Object) null);
    }

    @Override // com.avito.android.authorization.login.LoginView
    public void showUserDialog(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull Function0<Unit> function0, @NotNull Function0<Unit> function02) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "message");
        Intrinsics.checkNotNullParameter(str3, "agreeButtonTitle");
        Intrinsics.checkNotNullParameter(function0, "onAgree");
        Intrinsics.checkNotNullParameter(function02, "onCancel");
        DialogRouter dialogRouter = this.m;
        String string = this.a.getContext().getString(com.avito.android.ui_components.R.string.cancel);
        Intrinsics.checkNotNullExpressionValue(string, "contentView.context.getString(ui_R.string.cancel)");
        this.l = dialogRouter.showCancelableNotifyingDialog(str, true, str2, string, function02, str3, function0);
    }

    @Override // com.avito.android.authorization.login.LoginView
    public void showUserDialog(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull Function0<Unit> function0, @NotNull String str4, @NotNull Function0<Unit> function02) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "message");
        Intrinsics.checkNotNullParameter(str3, "firstActionButtonTitle");
        Intrinsics.checkNotNullParameter(function0, "onFirstAction");
        Intrinsics.checkNotNullParameter(str4, "secondActionButtonTitle");
        Intrinsics.checkNotNullParameter(function02, "onSecondAction");
        this.l = this.m.showNotifyingDialog(str, true, str2, str3, function0, str4, function02);
    }

    @Override // com.avito.android.authorization.login.LoginView
    public void showUserDialog(@NotNull String str, @NotNull String str2, @NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "message");
        Intrinsics.checkNotNullParameter(charSequence, "action");
        this.l = this.m.showNotifyingDialogWithEmbeddedLink(str, str2, charSequence);
    }

    @Override // com.avito.android.authorization.login.LoginView
    public void showUserDialog(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "message");
        this.l = this.m.showSimpleNotifyingDialog(str, str2);
    }

    @Override // com.avito.android.authorization.login.LoginView
    public void showUserDialog(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        this.l = this.m.showSimpleNotifyingDialog(str, a.b, a.c);
    }
}
