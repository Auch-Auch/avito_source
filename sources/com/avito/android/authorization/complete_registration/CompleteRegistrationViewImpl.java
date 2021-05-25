package com.avito.android.authorization.complete_registration;

import a2.g.r.g;
import android.view.View;
import com.avito.android.authorization.R;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.messenger.context_actions.PlatformActions;
import com.avito.android.util.ButtonsKt;
import com.avito.android.util.Keyboards;
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
import org.jetbrains.annotations.NotNull;
import ru.avito.component.appbar.AppBarImpl;
import ru.avito.component.button.ButtonImpl;
import ru.avito.component.info_label.InfoLabel;
import ru.avito.component.info_label.InfoLevel;
import ru.avito.component.text_input.EditTextSingleLineImpl;
import ru.avito.component.text_input.password.EditTextPasswordImpl;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010;\u001a\u00020/¢\u0006\u0004\b<\u0010=J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0005J\u0015\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0005J\u0015\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u0002H\u0016¢\u0006\u0004\b\t\u0010\u0005J\u0017\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0010\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0011\u0010\u000fJ\u0017\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0015\u0010\u000fJ\u0017\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0017\u0010\u0014J\u0017\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0019\u0010\u0014J\u0017\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u001a\u0010\u0014J\u000f\u0010\u001b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u001b\u0010\u000fJ\u0017\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u001c\u0010\u0014J\u000f\u0010\u001d\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u001d\u0010\u000fJ\u000f\u0010\u001e\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u001e\u0010\u000fR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00102\u001a\u00020/8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b0\u00101R\u0016\u00106\u001a\u0002038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b4\u00105R\u0016\u00108\u001a\u0002038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b7\u00105R\u0016\u0010:\u001a\u00020/8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b9\u00101¨\u0006>"}, d2 = {"Lcom/avito/android/authorization/complete_registration/CompleteRegistrationViewImpl;", "Lcom/avito/android/authorization/complete_registration/CompleteRegistrationView;", "Lio/reactivex/Observable;", "", "nameChanges", "()Lio/reactivex/Observable;", "passwordChanges", "", "navigationClicks", "registerClicks", "", "enabled", "setRegisterButtonEnabled", "(Z)V", PlatformActions.HIDE_KEYBOARD, "()V", "showProgress", "hideProgress", "message", "showError", "(Ljava/lang/String;)V", "showUnknownError", "name", "setName", Preference.PASSWORD, "setPassword", "showNameError", "hideNameError", "showPasswordError", "hidePasswordError", "requestFieldFocus", "Lru/avito/component/appbar/AppBarImpl;", AuthSource.BOOKING_ORDER, "Lru/avito/component/appbar/AppBarImpl;", "appBar", "Lru/avito/component/text_input/password/EditTextPasswordImpl;", "e", "Lru/avito/component/text_input/password/EditTextPasswordImpl;", "passwordView", "Lru/avito/component/text_input/EditTextSingleLineImpl;", "c", "Lru/avito/component/text_input/EditTextSingleLineImpl;", "nameView", "Lru/avito/component/button/ButtonImpl;", g.a, "Lru/avito/component/button/ButtonImpl;", "registerButton", "Landroid/view/View;", AuthSource.SEND_ABUSE, "Landroid/view/View;", "contentView", "Lru/avito/component/info_label/InfoLabel;", "f", "Lru/avito/component/info_label/InfoLabel;", "passwordLabel", "d", "nameLabel", "h", "progressView", "view", "<init>", "(Landroid/view/View;)V", "authorization_release"}, k = 1, mv = {1, 4, 2})
public final class CompleteRegistrationViewImpl implements CompleteRegistrationView {
    public final View a;
    public final AppBarImpl b;
    public final EditTextSingleLineImpl c;
    public final InfoLabel d;
    public final EditTextPasswordImpl e;
    public final InfoLabel f;
    public final ButtonImpl g;
    public final View h;

    public static final class a<T> implements Predicate<Unit> {
        public final /* synthetic */ CompleteRegistrationViewImpl a;

        public a(CompleteRegistrationViewImpl completeRegistrationViewImpl) {
            this.a = completeRegistrationViewImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Predicate
        public boolean test(Unit unit) {
            Intrinsics.checkNotNullParameter(unit, "it");
            return this.a.g.isEnabled();
        }
    }

    public CompleteRegistrationViewImpl(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        View findViewById = view.findViewById(R.id.content_container);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.view.View");
        this.a = findViewById;
        AppBarImpl appBarImpl = new AppBarImpl(view, null, false, 4, null);
        appBarImpl.setTitle(R.string.registration_title);
        Unit unit = Unit.INSTANCE;
        this.b = appBarImpl;
        View findViewById2 = view.findViewById(R.id.name_view);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.view.View");
        EditTextSingleLineImpl editTextSingleLineImpl = new EditTextSingleLineImpl(findViewById2);
        editTextSingleLineImpl.setHint(R.string.first_or_last_name);
        editTextSingleLineImpl.setInputType(8193);
        editTextSingleLineImpl.setAutofillHints("name");
        this.c = editTextSingleLineImpl;
        View findViewById3 = view.findViewById(R.id.name_label);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type android.view.View");
        this.d = new InfoLabel(findViewById3);
        View findViewById4 = view.findViewById(R.id.password_view);
        Objects.requireNonNull(findViewById4, "null cannot be cast to non-null type android.view.View");
        EditTextPasswordImpl editTextPasswordImpl = new EditTextPasswordImpl(findViewById4);
        editTextPasswordImpl.setHint(R.string.password);
        editTextPasswordImpl.setImeOptions(268435462);
        editTextPasswordImpl.setAutofillHints(Preference.PASSWORD);
        this.e = editTextPasswordImpl;
        View findViewById5 = view.findViewById(R.id.password_label);
        Objects.requireNonNull(findViewById5, "null cannot be cast to non-null type android.view.View");
        this.f = new InfoLabel(findViewById5);
        View findViewById6 = view.findViewById(R.id.register_button);
        Objects.requireNonNull(findViewById6, "null cannot be cast to non-null type android.view.View");
        ButtonImpl buttonImpl = new ButtonImpl(findViewById6);
        buttonImpl.setText(R.string.register_action);
        this.g = buttonImpl;
        View findViewById7 = view.findViewById(R.id.progress_view);
        Objects.requireNonNull(findViewById7, "null cannot be cast to non-null type android.view.View");
        this.h = findViewById7;
    }

    @Override // com.avito.android.authorization.complete_registration.CompleteRegistrationView
    public void hideKeyboard() {
        Keyboards.hideKeyboard$default(this.a, false, 1, null);
    }

    @Override // com.avito.android.authorization.complete_registration.CompleteRegistrationView
    public void hideNameError() {
        this.d.setVisible(false);
    }

    @Override // com.avito.android.authorization.complete_registration.CompleteRegistrationView
    public void hidePasswordError() {
        this.f.setVisible(false);
    }

    @Override // com.avito.android.authorization.complete_registration.CompleteRegistrationView
    public void hideProgress() {
        Views.hide(this.h);
    }

    @Override // com.avito.android.authorization.complete_registration.CompleteRegistrationView
    @NotNull
    public Observable<String> nameChanges() {
        return InteropKt.toV2(this.c.textChangeCallbacks());
    }

    @Override // com.avito.android.authorization.complete_registration.CompleteRegistrationView
    @NotNull
    public Observable<Unit> navigationClicks() {
        return InteropKt.toV2(this.b.navigationCallbacks());
    }

    @Override // com.avito.android.authorization.complete_registration.CompleteRegistrationView
    @NotNull
    public Observable<String> passwordChanges() {
        return InteropKt.toV2(this.e.textChangeCallbacks());
    }

    @Override // com.avito.android.authorization.complete_registration.CompleteRegistrationView
    @NotNull
    public Observable<Unit> registerClicks() {
        Observable<Unit> filter = Observable.merge(InteropKt.toV2(ButtonsKt.clicks(this.g)), InteropKt.toV2(this.e.doneCallbacks())).filter(new a(this));
        Intrinsics.checkNotNullExpressionValue(filter, "Observable.merge(registe…isterButton.isEnabled() }");
        return filter;
    }

    @Override // com.avito.android.authorization.complete_registration.CompleteRegistrationView
    public void requestFieldFocus() {
        this.c.showKeyboard();
        this.c.moveCursorToEnd();
    }

    @Override // com.avito.android.authorization.complete_registration.CompleteRegistrationView
    public void setName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        this.c.setText(str);
    }

    @Override // com.avito.android.authorization.complete_registration.CompleteRegistrationView
    public void setPassword(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, Preference.PASSWORD);
        this.e.setText(str);
    }

    @Override // com.avito.android.authorization.complete_registration.CompleteRegistrationView
    public void setRegisterButtonEnabled(boolean z) {
        this.g.setEnabled(z);
    }

    @Override // com.avito.android.authorization.complete_registration.CompleteRegistrationView
    public void showError(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        Views.showSnackBar$default(this.a, str, 0, (String) null, 0, (Function0) null, (Function0) null, 0, 126, (Object) null);
    }

    @Override // com.avito.android.authorization.complete_registration.CompleteRegistrationView
    public void showNameError(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        this.d.setValues(str, InfoLevel.ERROR);
        this.d.setVisible(true);
    }

    @Override // com.avito.android.authorization.complete_registration.CompleteRegistrationView
    public void showPasswordError(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        this.f.setValues(str, InfoLevel.ERROR);
        this.f.setVisible(true);
    }

    @Override // com.avito.android.authorization.complete_registration.CompleteRegistrationView
    public void showProgress() {
        Views.show(this.h);
    }

    @Override // com.avito.android.authorization.complete_registration.CompleteRegistrationView
    public void showUnknownError() {
        Views.showSnackBar$default(this.a, com.avito.android.remote.R.string.unknown_server_error, 0, (Integer) null, 0, (Function0) null, (Function0) null, 0, 126, (Object) null);
    }
}
