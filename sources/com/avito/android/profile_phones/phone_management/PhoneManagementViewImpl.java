package com.avito.android.profile_phones.phone_management;

import a2.g.r.g;
import android.app.Dialog;
import android.text.SpannableString;
import android.text.style.StyleSpan;
import android.view.View;
import androidx.appcompat.widget.Toolbar;
import com.avito.android.advert_core.analytics.contactbar.PhonePageSourceKt;
import com.avito.android.profile_phones.R;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.messenger.context_actions.PlatformActions;
import com.avito.android.util.ButtonsKt;
import com.avito.android.util.DialogRouter;
import com.avito.android.util.Keyboards;
import com.avito.android.util.Views;
import com.avito.android.util.rx3.InteropKt;
import com.jakewharton.rxbinding3.appcompat.RxToolbar;
import io.reactivex.Observable;
import io.reactivex.functions.Predicate;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.component.button.Button;
import ru.avito.component.button.ButtonImpl;
import ru.avito.component.info_label.InfoLabel;
import ru.avito.component.info_label.InfoLevel;
import ru.avito.component.text.Text;
import ru.avito.component.text.TextImpl;
import ru.avito.component.text_input.EditTextPhone;
import ru.avito.component.text_input.EditTextPhoneImpl;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010M\u001a\u00020/\u0012\u0006\u0010<\u001a\u000209¢\u0006\u0004\bN\u0010OJ\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0005J\u0015\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0005J\u0017\u0010\n\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\r\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\r\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000f\u0010\u000bJ!\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0014\u0010\u000bJ\u000f\u0010\u0015\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0018\u0010\u000bJ\u0017\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0019\u0010\u000bJ\u000f\u0010\u001a\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u001a\u0010\u0016J\u000f\u0010\u001b\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u001b\u0010\u0016J\u000f\u0010\u001c\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u001c\u0010\u0016J\u000f\u0010\u001d\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u001d\u0010\u0016J\u0017\u0010 \u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b \u0010!JC\u0010'\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u00072\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00030$2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00030$H\u0016¢\u0006\u0004\b'\u0010(J\u001f\u0010'\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u0007H\u0016¢\u0006\u0004\b'\u0010\u0013J\u000f\u0010)\u001a\u00020\u0003H\u0016¢\u0006\u0004\b)\u0010\u0016J\u000f\u0010*\u001a\u00020\u0003H\u0016¢\u0006\u0004\b*\u0010\u0016R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00102\u001a\u00020/8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b0\u00101R\u0016\u00106\u001a\u0002038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b4\u00105R\u0016\u00108\u001a\u00020/8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b7\u00101R\u0016\u0010<\u001a\u0002098\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b:\u0010;R\u0018\u0010@\u001a\u0004\u0018\u00010=8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010D\u001a\u00020A8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bB\u0010CR\u0016\u0010H\u001a\u00020E8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bF\u0010GR\u0016\u0010L\u001a\u00020I8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bJ\u0010K¨\u0006P"}, d2 = {"Lcom/avito/android/profile_phones/phone_management/PhoneManagementViewImpl;", "Lcom/avito/android/profile_phones/phone_management/PhoneManagementView;", "Lio/reactivex/Observable;", "", "buttonClicks", "()Lio/reactivex/Observable;", "navigationClicks", "", "phoneChanges", "title", "setTitle", "(Ljava/lang/String;)V", "phone", "setPhone", "hint", "setPhoneHint", "text", "highlightedText", "showText", "(Ljava/lang/String;Ljava/lang/String;)V", "setButtonText", "showUnknownError", "()V", "error", "showError", "showPhoneError", "hidePhoneError", "showProgress", "hideProgress", PlatformActions.HIDE_KEYBOARD, "", "enabled", "setButtonEnabled", "(Z)V", "message", "agreeButtonTitle", "Lkotlin/Function0;", "onAgree", "onCancel", "showUserDialog", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "closeUserDialog", "requestFieldFocus", "Landroidx/appcompat/widget/Toolbar;", "c", "Landroidx/appcompat/widget/Toolbar;", "toolbar", "Landroid/view/View;", AuthSource.SEND_ABUSE, "Landroid/view/View;", "progressView", "Lru/avito/component/button/Button;", "d", "Lru/avito/component/button/Button;", PhonePageSourceKt.PHONE_SOURCE_BUTTON, AuthSource.BOOKING_ORDER, "contentView", "Lcom/avito/android/util/DialogRouter;", "i", "Lcom/avito/android/util/DialogRouter;", "dialogRouter", "Landroid/app/Dialog;", "h", "Landroid/app/Dialog;", "userDialog", "Lru/avito/component/info_label/InfoLabel;", "f", "Lru/avito/component/info_label/InfoLabel;", "phoneLabel", "Lru/avito/component/text/Text;", g.a, "Lru/avito/component/text/Text;", "textView", "Lru/avito/component/text_input/EditTextPhone;", "e", "Lru/avito/component/text_input/EditTextPhone;", "phoneInput", "view", "<init>", "(Landroid/view/View;Lcom/avito/android/util/DialogRouter;)V", "profile-phones_release"}, k = 1, mv = {1, 4, 2})
public final class PhoneManagementViewImpl implements PhoneManagementView {
    public final View a;
    public final View b;
    public final Toolbar c;
    public final Button d;
    public final EditTextPhone e;
    public final InfoLabel f;
    public final Text g;
    public Dialog h;
    public final DialogRouter i;

    public static final class a<T> implements Predicate<Unit> {
        public final /* synthetic */ PhoneManagementViewImpl a;

        public a(PhoneManagementViewImpl phoneManagementViewImpl) {
            this.a = phoneManagementViewImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Predicate
        public boolean test(Unit unit) {
            Intrinsics.checkNotNullParameter(unit, "it");
            return this.a.d.isEnabled();
        }
    }

    public PhoneManagementViewImpl(@NotNull View view, @NotNull DialogRouter dialogRouter) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(dialogRouter, "dialogRouter");
        this.i = dialogRouter;
        View findViewById = view.findViewById(R.id.progress_view);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.view.View");
        this.a = findViewById;
        View findViewById2 = view.findViewById(R.id.content_container);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.view.View");
        this.b = findViewById2;
        View findViewById3 = view.findViewById(com.avito.android.deprecated_design.R.id.toolbar);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type androidx.appcompat.widget.Toolbar");
        this.c = (Toolbar) findViewById3;
        View findViewById4 = view.findViewById(R.id.action_button);
        Objects.requireNonNull(findViewById4, "null cannot be cast to non-null type android.view.View");
        this.d = new ButtonImpl(findViewById4);
        View findViewById5 = view.findViewById(R.id.phone_view);
        Objects.requireNonNull(findViewById5, "null cannot be cast to non-null type android.view.View");
        EditTextPhoneImpl editTextPhoneImpl = new EditTextPhoneImpl(findViewById5, null, 0, 6, null);
        editTextPhoneImpl.setImeOptions(268435462);
        Unit unit = Unit.INSTANCE;
        this.e = editTextPhoneImpl;
        View findViewById6 = view.findViewById(R.id.phone_label);
        Objects.requireNonNull(findViewById6, "null cannot be cast to non-null type android.view.View");
        this.f = new InfoLabel(findViewById6);
        View findViewById7 = view.findViewById(R.id.text_view);
        Objects.requireNonNull(findViewById7, "null cannot be cast to non-null type android.view.View");
        this.g = new TextImpl(findViewById7);
    }

    @Override // com.avito.android.profile_phones.phone_management.PhoneManagementView
    @NotNull
    public Observable<Unit> buttonClicks() {
        Observable<Unit> filter = Observable.merge(InteropKt.toV2(ButtonsKt.clicks(this.d)), InteropKt.toV2(this.e.doneCallbacks())).filter(new a(this));
        Intrinsics.checkNotNullExpressionValue(filter, "Observable.merge(button.…er { button.isEnabled() }");
        return filter;
    }

    @Override // com.avito.android.profile_phones.phone_management.PhoneManagementView
    public void closeUserDialog() {
        Dialog dialog = this.h;
        if (dialog != null) {
            dialog.hide();
        }
    }

    @Override // com.avito.android.profile_phones.phone_management.PhoneManagementView
    public void hideKeyboard() {
        Keyboards.hideKeyboard$default(this.b, false, 1, null);
    }

    @Override // com.avito.android.profile_phones.phone_management.PhoneManagementView
    public void hidePhoneError() {
        this.f.hide();
    }

    @Override // com.avito.android.profile_phones.phone_management.PhoneManagementView
    public void hideProgress() {
        Views.hide(this.a);
    }

    @Override // com.avito.android.profile_phones.phone_management.PhoneManagementView
    @NotNull
    public Observable<Unit> navigationClicks() {
        return RxToolbar.navigationClicks(this.c);
    }

    @Override // com.avito.android.profile_phones.phone_management.PhoneManagementView
    @NotNull
    public Observable<String> phoneChanges() {
        return InteropKt.toV2(this.e.formattedCallbacks());
    }

    @Override // com.avito.android.profile_phones.phone_management.PhoneManagementView
    public void requestFieldFocus() {
        this.e.showKeyboard();
        this.e.moveCursorToEnd();
    }

    @Override // com.avito.android.profile_phones.phone_management.PhoneManagementView
    public void setButtonEnabled(boolean z) {
        this.d.setEnabled(z);
    }

    @Override // com.avito.android.profile_phones.phone_management.PhoneManagementView
    public void setButtonText(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        this.d.setText(str);
    }

    @Override // com.avito.android.profile_phones.phone_management.PhoneManagementView
    public void setPhone(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "phone");
        this.e.setText(str);
    }

    @Override // com.avito.android.profile_phones.phone_management.PhoneManagementView
    public void setPhoneHint(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "hint");
        this.e.setHint(str);
    }

    @Override // com.avito.android.profile_phones.phone_management.PhoneManagementView
    public void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        this.c.setTitle(str);
    }

    @Override // com.avito.android.profile_phones.phone_management.PhoneManagementView
    public void showError(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "error");
        Views.showSnackBar$default(this.b, str, 0, (String) null, 0, (Function0) null, (Function0) null, 0, 126, (Object) null);
    }

    @Override // com.avito.android.profile_phones.phone_management.PhoneManagementView
    public void showPhoneError(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "error");
        this.f.setValues(str, InfoLevel.ERROR);
        this.f.show();
    }

    @Override // com.avito.android.profile_phones.phone_management.PhoneManagementView
    public void showProgress() {
        Views.show(this.a);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: android.text.SpannableString */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.avito.android.profile_phones.phone_management.PhoneManagementView
    public void showText(@NotNull String str, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(str, "text");
        int indexOf$default = str2 != null ? StringsKt__StringsKt.indexOf$default((CharSequence) str, str2, 0, false, 6, (Object) null) : -1;
        if (indexOf$default >= 0) {
            int length = str2 != null ? str2.length() : 0;
            SpannableString spannableString = new SpannableString(str);
            spannableString.setSpan(new StyleSpan(1), indexOf$default, length + indexOf$default, 33);
            str = spannableString;
        }
        this.g.setText(str);
    }

    @Override // com.avito.android.profile_phones.phone_management.PhoneManagementView
    public void showUnknownError() {
        Views.showSnackBar$default(this.b, com.avito.android.remote.R.string.unknown_server_error, 0, (Integer) null, 0, (Function0) null, (Function0) null, 0, 126, (Object) null);
    }

    @Override // com.avito.android.profile_phones.phone_management.PhoneManagementView
    public void showUserDialog(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull Function0<Unit> function0, @NotNull Function0<Unit> function02) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "message");
        Intrinsics.checkNotNullParameter(str3, "agreeButtonTitle");
        Intrinsics.checkNotNullParameter(function0, "onAgree");
        Intrinsics.checkNotNullParameter(function02, "onCancel");
        DialogRouter dialogRouter = this.i;
        String string = this.b.getContext().getString(com.avito.android.ui_components.R.string.cancel);
        Intrinsics.checkNotNullExpressionValue(string, "contentView.context.getString(ui_R.string.cancel)");
        this.h = dialogRouter.showCancelableNotifyingDialog(str, true, str2, string, function02, str3, function0);
    }

    @Override // com.avito.android.profile_phones.phone_management.PhoneManagementView
    public void showUserDialog(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "message");
        this.h = this.i.showSimpleNotifyingDialog(str, str2);
    }
}
