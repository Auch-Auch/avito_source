package com.avito.android.authorization.change_password;

import a2.g.r.g;
import android.content.Context;
import android.view.View;
import androidx.appcompat.widget.Toolbar;
import com.avito.android.authorization.R;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.messenger.context_actions.PlatformActions;
import com.avito.android.util.ButtonsKt;
import com.avito.android.util.Keyboards;
import com.avito.android.util.ToastsKt;
import com.avito.android.util.Views;
import com.avito.android.util.preferences.Preference;
import com.avito.android.util.rx3.InteropKt;
import com.jakewharton.rxbinding3.appcompat.RxToolbar;
import io.reactivex.Observable;
import io.reactivex.functions.Predicate;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.avito.component.button.Button;
import ru.avito.component.button.ButtonImpl;
import ru.avito.component.info_label.InfoLabel;
import ru.avito.component.info_label.InfoLevel;
import ru.avito.component.text_input.EditTextSingleLine;
import ru.avito.component.text_input.password.EditTextPasswordImpl;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u00106\u001a\u00020$¢\u0006\u0004\b7\u00108J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0005J\u0015\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0005J\u0017\u0010\n\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\r\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\r\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000f\u0010\u000bJ\u0017\u0010\u0010\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0010\u0010\u000bJ\u000f\u0010\u0011\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0013\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0014\u0010\u0012J\u000f\u0010\u0015\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0015\u0010\u0012J\u0017\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u001a\u0010\u0012R\u001e\u0010\u001f\u001a\n \u001c*\u0004\u0018\u00010\u001b0\u001b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u0016\u00105\u001a\u00020$8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b4\u0010&¨\u00069"}, d2 = {"Lcom/avito/android/authorization/change_password/ChangePasswordViewImpl;", "Lcom/avito/android/authorization/change_password/ChangePasswordView;", "Lio/reactivex/Observable;", "", "saveClicks", "()Lio/reactivex/Observable;", "navigationClicks", "", "passwordChanged", Preference.PASSWORD, "setPassword", "(Ljava/lang/String;)V", "error", "showError", "message", "showMessage", "showPasswordError", "hidePasswordError", "()V", "showProgress", "hideProgress", PlatformActions.HIDE_KEYBOARD, "", "enabled", "setSaveButtonEnabled", "(Z)V", "requestFieldFocus", "Landroid/content/Context;", "kotlin.jvm.PlatformType", AuthSource.SEND_ABUSE, "Landroid/content/Context;", "context", "Landroidx/appcompat/widget/Toolbar;", "d", "Landroidx/appcompat/widget/Toolbar;", "toolbar", "Landroid/view/View;", AuthSource.BOOKING_ORDER, "Landroid/view/View;", "progressView", "Lru/avito/component/text_input/EditTextSingleLine;", "f", "Lru/avito/component/text_input/EditTextSingleLine;", "passwordInput", "Lru/avito/component/button/Button;", "e", "Lru/avito/component/button/Button;", "saveButton", "Lru/avito/component/info_label/InfoLabel;", g.a, "Lru/avito/component/info_label/InfoLabel;", "passwordLabel", "c", "contentView", "view", "<init>", "(Landroid/view/View;)V", "authorization_release"}, k = 1, mv = {1, 4, 2})
public final class ChangePasswordViewImpl implements ChangePasswordView {
    public final Context a;
    public final View b;
    public final View c;
    public final Toolbar d;
    public final Button e;
    public final EditTextSingleLine f;
    public final InfoLabel g;

    public static final class a<T> implements Predicate<Unit> {
        public final /* synthetic */ ChangePasswordViewImpl a;

        public a(ChangePasswordViewImpl changePasswordViewImpl) {
            this.a = changePasswordViewImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Predicate
        public boolean test(Unit unit) {
            Intrinsics.checkNotNullParameter(unit, "it");
            return this.a.e.isEnabled();
        }
    }

    public ChangePasswordViewImpl(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.a = view.getContext();
        View findViewById = view.findViewById(R.id.progress_view);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.view.View");
        this.b = findViewById;
        View findViewById2 = view.findViewById(R.id.content_container);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.view.View");
        this.c = findViewById2;
        View findViewById3 = view.findViewById(com.avito.android.deprecated_design.R.id.toolbar);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type androidx.appcompat.widget.Toolbar");
        Toolbar toolbar = (Toolbar) findViewById3;
        toolbar.setTitle(R.string.change_password_title);
        Unit unit = Unit.INSTANCE;
        this.d = toolbar;
        View findViewById4 = view.findViewById(R.id.save_button);
        Objects.requireNonNull(findViewById4, "null cannot be cast to non-null type android.view.View");
        ButtonImpl buttonImpl = new ButtonImpl(findViewById4);
        buttonImpl.setText(R.string.password_save_button_text);
        this.e = buttonImpl;
        View findViewById5 = view.findViewById(R.id.password_view);
        Objects.requireNonNull(findViewById5, "null cannot be cast to non-null type android.view.View");
        EditTextPasswordImpl editTextPasswordImpl = new EditTextPasswordImpl(findViewById5);
        editTextPasswordImpl.setHint(R.string.change_password_hint);
        editTextPasswordImpl.setImeOptions(268435462);
        editTextPasswordImpl.setAutofillHints(Preference.PASSWORD);
        this.f = editTextPasswordImpl;
        View findViewById6 = view.findViewById(R.id.password_label);
        Objects.requireNonNull(findViewById6, "null cannot be cast to non-null type android.view.View");
        this.g = new InfoLabel(findViewById6);
    }

    @Override // com.avito.android.authorization.change_password.ChangePasswordView
    public void hideKeyboard() {
        Keyboards.hideKeyboard$default(this.c, false, 1, null);
    }

    @Override // com.avito.android.authorization.change_password.ChangePasswordView
    public void hidePasswordError() {
        this.g.hide();
    }

    @Override // com.avito.android.authorization.change_password.ChangePasswordView
    public void hideProgress() {
        Views.hide(this.b);
    }

    @Override // com.avito.android.authorization.change_password.ChangePasswordView
    @NotNull
    public Observable<Unit> navigationClicks() {
        return RxToolbar.navigationClicks(this.d);
    }

    @Override // com.avito.android.authorization.change_password.ChangePasswordView
    @NotNull
    public Observable<String> passwordChanged() {
        return InteropKt.toV2(this.f.textChangeCallbacks());
    }

    @Override // com.avito.android.authorization.change_password.ChangePasswordView
    public void requestFieldFocus() {
        this.f.showKeyboard();
        this.f.moveCursorToEnd();
    }

    @Override // com.avito.android.authorization.change_password.ChangePasswordView
    @NotNull
    public Observable<Unit> saveClicks() {
        Observable<Unit> filter = Observable.merge(InteropKt.toV2(ButtonsKt.clicks(this.e)), InteropKt.toV2(this.f.doneCallbacks())).filter(new a(this));
        Intrinsics.checkNotNullExpressionValue(filter, "Observable.merge(saveBut… saveButton.isEnabled() }");
        return filter;
    }

    @Override // com.avito.android.authorization.change_password.ChangePasswordView
    public void setPassword(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, Preference.PASSWORD);
        this.f.setText(str);
    }

    @Override // com.avito.android.authorization.change_password.ChangePasswordView
    public void setSaveButtonEnabled(boolean z) {
        this.e.setEnabled(z);
    }

    @Override // com.avito.android.authorization.change_password.ChangePasswordView
    public void showError(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "error");
        Views.showSnackBar$default(this.c, str, 0, (String) null, 0, (Function0) null, (Function0) null, 0, 126, (Object) null);
    }

    @Override // com.avito.android.authorization.change_password.ChangePasswordView
    public void showMessage(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        Context context = this.a;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        ToastsKt.showToast$default(context, str, 0, 2, (Object) null);
    }

    @Override // com.avito.android.authorization.change_password.ChangePasswordView
    public void showPasswordError(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "error");
        this.g.setValues(str, InfoLevel.ERROR);
        this.g.show();
    }

    @Override // com.avito.android.authorization.change_password.ChangePasswordView
    public void showProgress() {
        Views.show(this.b);
    }
}
