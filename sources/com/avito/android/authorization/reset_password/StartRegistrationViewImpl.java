package com.avito.android.authorization.reset_password;

import android.view.View;
import com.avito.android.authorization.R;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.messenger.context_actions.PlatformActions;
import com.avito.android.util.ButtonsKt;
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
import org.jetbrains.annotations.NotNull;
import ru.avito.component.appbar.AppBarImpl;
import ru.avito.component.button.ButtonImpl;
import ru.avito.component.info_label.InfoLabel;
import ru.avito.component.info_label.InfoLevel;
import ru.avito.component.text_input.EditTextPhoneImpl;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u00101\u001a\u00020'¢\u0006\u0004\b2\u00103J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0005J3\u0010\t\u001a&\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00060\u0006 \b*\u0012\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00060\u0006\u0018\u00010\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\u0005J\u0017\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0010\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0011\u0010\u000fJ\u0017\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0015\u0010\u000fJ\u0017\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0017\u0010\u0014J\u0017\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0018\u0010\u0014J\u000f\u0010\u0019\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0019\u0010\u000fJ\u000f\u0010\u001a\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001a\u0010\u000fR\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010,\u001a\u00020'8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b+\u0010)R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b.\u0010/¨\u00064"}, d2 = {"Lcom/avito/android/authorization/reset_password/StartRegistrationViewImpl;", "Lcom/avito/android/authorization/reset_password/StartRegistrationView;", "Lio/reactivex/Observable;", "", "loginChanges", "()Lio/reactivex/Observable;", "", "navigationClicks", "kotlin.jvm.PlatformType", "continueClicks", "", "enabled", "setContinueButtonEnabled", "(Z)V", PlatformActions.HIDE_KEYBOARD, "()V", "showProgress", "hideProgress", "message", "showError", "(Ljava/lang/String;)V", "showUnknownError", "login", "setLogin", "showLoginError", "hideLoginError", "requestFieldFocus", "Lru/avito/component/button/ButtonImpl;", "e", "Lru/avito/component/button/ButtonImpl;", "continueButton", "Lru/avito/component/text_input/EditTextPhoneImpl;", "c", "Lru/avito/component/text_input/EditTextPhoneImpl;", "loginView", "Lru/avito/component/info_label/InfoLabel;", "d", "Lru/avito/component/info_label/InfoLabel;", "loginLabel", "Landroid/view/View;", AuthSource.SEND_ABUSE, "Landroid/view/View;", "contentView", "f", "progressView", "Lru/avito/component/appbar/AppBarImpl;", AuthSource.BOOKING_ORDER, "Lru/avito/component/appbar/AppBarImpl;", "appBar", "view", "<init>", "(Landroid/view/View;)V", "authorization_release"}, k = 1, mv = {1, 4, 2})
public final class StartRegistrationViewImpl implements StartRegistrationView {
    public final View a;
    public final AppBarImpl b;
    public final EditTextPhoneImpl c;
    public final InfoLabel d;
    public final ButtonImpl e;
    public final View f;

    public static final class a<T> implements Predicate<Unit> {
        public final /* synthetic */ StartRegistrationViewImpl a;

        public a(StartRegistrationViewImpl startRegistrationViewImpl) {
            this.a = startRegistrationViewImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Predicate
        public boolean test(Unit unit) {
            Intrinsics.checkNotNullParameter(unit, "it");
            return this.a.e.isEnabled();
        }
    }

    public StartRegistrationViewImpl(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        View findViewById = view.findViewById(R.id.content_container);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.view.View");
        this.a = findViewById;
        AppBarImpl appBarImpl = new AppBarImpl(view, null, false, 4, null);
        appBarImpl.setTitle(R.string.registration_title);
        Unit unit = Unit.INSTANCE;
        this.b = appBarImpl;
        View findViewById2 = view.findViewById(R.id.login_view);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.view.View");
        EditTextPhoneImpl editTextPhoneImpl = new EditTextPhoneImpl(findViewById2, null, 0, 6, null);
        editTextPhoneImpl.setHint(R.string.registration_phone);
        editTextPhoneImpl.setImeOptions(268435462);
        editTextPhoneImpl.setAutofillHints("phone");
        this.c = editTextPhoneImpl;
        View findViewById3 = view.findViewById(R.id.login_label);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type android.view.View");
        this.d = new InfoLabel(findViewById3);
        View findViewById4 = view.findViewById(R.id.continue_button);
        Objects.requireNonNull(findViewById4, "null cannot be cast to non-null type android.view.View");
        ButtonImpl buttonImpl = new ButtonImpl(findViewById4);
        buttonImpl.setText(R.string.registration_continue);
        this.e = buttonImpl;
        View findViewById5 = view.findViewById(R.id.progress_view);
        Objects.requireNonNull(findViewById5, "null cannot be cast to non-null type android.view.View");
        this.f = findViewById5;
    }

    @Override // com.avito.android.authorization.reset_password.StartRegistrationView
    public Observable<Unit> continueClicks() {
        return Observable.merge(InteropKt.toV2(ButtonsKt.clicks(this.e)), InteropKt.toV2(this.c.doneCallbacks())).filter(new a(this));
    }

    @Override // com.avito.android.authorization.reset_password.StartRegistrationView
    public void hideKeyboard() {
        Keyboards.hideKeyboard$default(this.a, false, 1, null);
    }

    @Override // com.avito.android.authorization.reset_password.StartRegistrationView
    public void hideLoginError() {
        this.d.setVisible(false);
    }

    @Override // com.avito.android.authorization.reset_password.StartRegistrationView
    public void hideProgress() {
        Views.hide(this.f);
    }

    @Override // com.avito.android.authorization.reset_password.StartRegistrationView
    @NotNull
    public Observable<String> loginChanges() {
        return InteropKt.toV2(this.c.formattedCallbacks());
    }

    @Override // com.avito.android.authorization.reset_password.StartRegistrationView
    @NotNull
    public Observable<Unit> navigationClicks() {
        return InteropKt.toV2(this.b.navigationCallbacks());
    }

    @Override // com.avito.android.authorization.reset_password.StartRegistrationView
    public void requestFieldFocus() {
        this.c.showKeyboard();
        this.c.moveCursorToEnd();
    }

    @Override // com.avito.android.authorization.reset_password.StartRegistrationView
    public void setContinueButtonEnabled(boolean z) {
        this.e.setEnabled(z);
    }

    @Override // com.avito.android.authorization.reset_password.StartRegistrationView
    public void setLogin(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "login");
        this.c.setText(str);
    }

    @Override // com.avito.android.authorization.reset_password.StartRegistrationView
    public void showError(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        Views.showSnackBar$default(this.a, str, 0, (String) null, 0, (Function0) null, (Function0) null, 0, 126, (Object) null);
    }

    @Override // com.avito.android.authorization.reset_password.StartRegistrationView
    public void showLoginError(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        this.d.setValues(str, InfoLevel.ERROR);
        this.d.setVisible(true);
    }

    @Override // com.avito.android.authorization.reset_password.StartRegistrationView
    public void showProgress() {
        Views.show(this.f);
    }

    @Override // com.avito.android.authorization.reset_password.StartRegistrationView
    public void showUnknownError() {
        Views.showSnackBar$default(this.a, com.avito.android.remote.R.string.unknown_server_error, 0, (Integer) null, 0, (Function0) null, (Function0) null, 0, 126, (Object) null);
    }
}
