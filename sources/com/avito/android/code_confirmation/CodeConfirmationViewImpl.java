package com.avito.android.code_confirmation;

import a2.g.r.g;
import android.app.Dialog;
import android.content.Context;
import android.text.SpannableString;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.ViewAnimator;
import androidx.appcompat.widget.Toolbar;
import com.avito.android.deprecated_design.R;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.messenger.context_actions.PlatformActions;
import com.avito.android.util.ButtonsKt;
import com.avito.android.util.DialogRouter;
import com.avito.android.util.Keyboards;
import com.avito.android.util.ToastsKt;
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
import ru.avito.component.button.Button;
import ru.avito.component.button.ButtonImpl;
import ru.avito.component.info_label.InfoLabel;
import ru.avito.component.info_label.InfoLevel;
import ru.avito.component.text.Text;
import ru.avito.component.text.TextImpl;
import ru.avito.component.text_input.EditTextSingleLine;
import ru.avito.component.text_input.EditTextSingleLineImpl;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010_\u001a\u00020=\u0012\u0006\u0010<\u001a\u000209¢\u0006\u0004\b`\u0010aJ\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0005J\u0015\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0005J\u0015\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0002H\u0016¢\u0006\u0004\b\t\u0010\u0005J\u000f\u0010\n\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0017\u0010\u0012J\u000f\u0010\u0018\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001b\u0010\u0012J\u0017\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001d\u0010\u0012J\u0017\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001e\u0010\u0012J\u000f\u0010\u001f\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u001f\u0010\u0019J\u000f\u0010 \u001a\u00020\u0003H\u0016¢\u0006\u0004\b \u0010\u0019J\u000f\u0010!\u001a\u00020\u0003H\u0016¢\u0006\u0004\b!\u0010\u0019J\u000f\u0010\"\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\"\u0010\u0019J\u0017\u0010%\u001a\u00020\u00032\u0006\u0010$\u001a\u00020#H\u0016¢\u0006\u0004\b%\u0010&J\u000f\u0010'\u001a\u00020\u0003H\u0016¢\u0006\u0004\b'\u0010\u0019JC\u0010-\u001a\u00020\u00032\u0006\u0010(\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\b2\u0006\u0010)\u001a\u00020\b2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00030*2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00030*H\u0016¢\u0006\u0004\b-\u0010.J\u000f\u0010/\u001a\u00020\u0003H\u0016¢\u0006\u0004\b/\u0010\u0019R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u001e\u00108\u001a\n 5*\u0004\u0018\u000104048\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010<\u001a\u0002098\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010@\u001a\u00020=8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010D\u001a\u00020A8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bB\u0010CR\u0016\u0010F\u001a\u00020=8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bE\u0010?R\u0016\u0010J\u001a\u00020G8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bH\u0010IR\u0016\u0010N\u001a\u00020K8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bL\u0010MR\u0016\u0010R\u001a\u00020O8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bP\u0010QR\u0016\u0010T\u001a\u00020O8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bS\u0010QR\u0016\u0010X\u001a\u00020U8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bV\u0010WR\u0016\u0010Z\u001a\u00020G8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bY\u0010IR\u0018\u0010^\u001a\u0004\u0018\u00010[8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\\\u0010]¨\u0006b"}, d2 = {"Lcom/avito/android/code_confirmation/CodeConfirmationViewImpl;", "Lcom/avito/android/code_confirmation/CodeConfirmationView;", "Lio/reactivex/Observable;", "", "sendClicks", "()Lio/reactivex/Observable;", "requestClicks", "navigationClicks", "", "codeChanged", "getCode", "()Ljava/lang/String;", "", "length", "setCodeLength", "(I)V", "code", "showCode", "(Ljava/lang/String;)V", "text", "highlightText", "showText", "(Ljava/lang/String;Ljava/lang/String;)V", "showTimer", "showRequestButton", "()V", "error", "showError", "message", "showMessage", "showCodeError", "hideCodeError", "showProgress", "hideProgress", PlatformActions.HIDE_KEYBOARD, "", "enabled", "setSendButtonEnabled", "(Z)V", "requestFieldFocus", "title", "agreeButtonTitle", "Lkotlin/Function0;", "onAgree", "onCancel", "showUserDialog", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "closeUserDialog", "Landroidx/appcompat/widget/Toolbar;", "d", "Landroidx/appcompat/widget/Toolbar;", "toolbar", "Landroid/content/Context;", "kotlin.jvm.PlatformType", AuthSource.SEND_ABUSE, "Landroid/content/Context;", "context", "Lcom/avito/android/util/DialogRouter;", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/android/util/DialogRouter;", "dialogRouter", "Landroid/view/View;", AuthSource.BOOKING_ORDER, "Landroid/view/View;", "progressView", "Landroid/widget/ViewAnimator;", "f", "Landroid/widget/ViewAnimator;", "request", "c", "contentView", "Lru/avito/component/button/Button;", "e", "Lru/avito/component/button/Button;", "sendButton", "Lru/avito/component/text_input/EditTextSingleLine;", "i", "Lru/avito/component/text_input/EditTextSingleLine;", "codeInput", "Lru/avito/component/text/Text;", "k", "Lru/avito/component/text/Text;", "textView", "h", "requestText", "Lru/avito/component/info_label/InfoLabel;", "j", "Lru/avito/component/info_label/InfoLabel;", "codeLabel", g.a, "requestButton", "Landroid/app/Dialog;", "l", "Landroid/app/Dialog;", "userDialog", "view", "<init>", "(Landroid/view/View;Lcom/avito/android/util/DialogRouter;)V", "code-confirmation_release"}, k = 1, mv = {1, 4, 2})
public final class CodeConfirmationViewImpl implements CodeConfirmationView {
    public final Context a;
    public final View b;
    public final View c;
    public final Toolbar d;
    public final Button e;
    public final ViewAnimator f;
    public final Button g;
    public final Text h;
    public final EditTextSingleLine i;
    public final InfoLabel j;
    public final Text k;
    public Dialog l;
    public final DialogRouter m;

    public static final class a<T> implements Predicate<Unit> {
        public final /* synthetic */ CodeConfirmationViewImpl a;

        public a(CodeConfirmationViewImpl codeConfirmationViewImpl) {
            this.a = codeConfirmationViewImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Predicate
        public boolean test(Unit unit) {
            Intrinsics.checkNotNullParameter(unit, "it");
            return this.a.e.isEnabled();
        }
    }

    public CodeConfirmationViewImpl(@NotNull View view, @NotNull DialogRouter dialogRouter) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(dialogRouter, "dialogRouter");
        this.m = dialogRouter;
        Context context = view.getContext();
        this.a = context;
        View findViewById = view.findViewById(R.id.progress_view);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.view.View");
        this.b = findViewById;
        View findViewById2 = view.findViewById(R.id.content_container);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.view.View");
        this.c = findViewById2;
        View findViewById3 = view.findViewById(R.id.toolbar);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type androidx.appcompat.widget.Toolbar");
        Toolbar toolbar = (Toolbar) findViewById3;
        this.d = toolbar;
        View findViewById4 = view.findViewById(R.id.send_button);
        Objects.requireNonNull(findViewById4, "null cannot be cast to non-null type android.view.View");
        ButtonImpl buttonImpl = new ButtonImpl(findViewById4);
        buttonImpl.setText(R.string.code_send_button_text);
        Unit unit = Unit.INSTANCE;
        this.e = buttonImpl;
        View findViewById5 = view.findViewById(R.id.request);
        Objects.requireNonNull(findViewById5, "null cannot be cast to non-null type android.widget.ViewAnimator");
        this.f = (ViewAnimator) findViewById5;
        View findViewById6 = view.findViewById(R.id.request_button);
        Objects.requireNonNull(findViewById6, "null cannot be cast to non-null type android.view.View");
        ButtonImpl buttonImpl2 = new ButtonImpl(findViewById6);
        buttonImpl2.setText(R.string.code_request_button_text);
        this.g = buttonImpl2;
        View findViewById7 = view.findViewById(R.id.request_text);
        Objects.requireNonNull(findViewById7, "null cannot be cast to non-null type android.view.View");
        this.h = new TextImpl(findViewById7);
        View findViewById8 = view.findViewById(R.id.code_view);
        Objects.requireNonNull(findViewById8, "null cannot be cast to non-null type android.view.View");
        EditTextSingleLineImpl editTextSingleLineImpl = new EditTextSingleLineImpl(findViewById8);
        String string = context.getString(R.string.code_input_hint);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.string.code_input_hint)");
        editTextSingleLineImpl.setHint(string);
        editTextSingleLineImpl.setInputType(2);
        editTextSingleLineImpl.setImeOptions(268435462);
        this.i = editTextSingleLineImpl;
        View findViewById9 = view.findViewById(R.id.code_label);
        Objects.requireNonNull(findViewById9, "null cannot be cast to non-null type android.view.View");
        this.j = new InfoLabel(findViewById9);
        View findViewById10 = view.findViewById(R.id.text_view);
        Objects.requireNonNull(findViewById10, "null cannot be cast to non-null type android.view.View");
        this.k = new TextImpl(findViewById10);
        toolbar.setTitle(R.string.code_confirmation_title);
    }

    @Override // com.avito.android.code_confirmation.CodeConfirmationView
    public void closeUserDialog() {
        Dialog dialog = this.l;
        if (dialog != null) {
            dialog.hide();
        }
    }

    @Override // com.avito.android.code_confirmation.CodeConfirmationView
    @NotNull
    public Observable<String> codeChanged() {
        return InteropKt.toV2(this.i.textChangeCallbacks());
    }

    @Override // com.avito.android.code_confirmation.CodeConfirmationView
    @NotNull
    public String getCode() {
        return this.i.getText().toString();
    }

    @Override // com.avito.android.code_confirmation.CodeConfirmationView
    public void hideCodeError() {
        this.j.hide();
    }

    @Override // com.avito.android.code_confirmation.CodeConfirmationView
    public void hideKeyboard() {
        Keyboards.hideKeyboard$default(this.c, false, 1, null);
    }

    @Override // com.avito.android.code_confirmation.CodeConfirmationView
    public void hideProgress() {
        Views.hide(this.b);
    }

    @Override // com.avito.android.code_confirmation.CodeConfirmationView
    @NotNull
    public Observable<Unit> navigationClicks() {
        return RxToolbar.navigationClicks(this.d);
    }

    @Override // com.avito.android.code_confirmation.CodeConfirmationView
    @NotNull
    public Observable<Unit> requestClicks() {
        return InteropKt.toV2(ButtonsKt.clicks(this.g));
    }

    @Override // com.avito.android.code_confirmation.CodeConfirmationView
    public void requestFieldFocus() {
        this.i.showKeyboard();
        this.i.moveCursorToEnd();
    }

    @Override // com.avito.android.code_confirmation.CodeConfirmationView
    @NotNull
    public Observable<Unit> sendClicks() {
        Observable<Unit> filter = Observable.merge(InteropKt.toV2(ButtonsKt.clicks(this.e)), InteropKt.toV2(this.i.doneCallbacks())).filter(new a(this));
        Intrinsics.checkNotNullExpressionValue(filter, "Observable.merge(sendBut… sendButton.isEnabled() }");
        return filter;
    }

    @Override // com.avito.android.code_confirmation.CodeConfirmationView
    public void setCodeLength(int i2) {
        this.i.setTextLength(i2);
    }

    @Override // com.avito.android.code_confirmation.CodeConfirmationView
    public void setSendButtonEnabled(boolean z) {
        this.e.setEnabled(z);
    }

    @Override // com.avito.android.code_confirmation.CodeConfirmationView
    public void showCode(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "code");
        this.i.setText(str);
    }

    @Override // com.avito.android.code_confirmation.CodeConfirmationView
    public void showCodeError(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "error");
        this.j.setValues(str, InfoLevel.ERROR);
        this.j.show();
    }

    @Override // com.avito.android.code_confirmation.CodeConfirmationView
    public void showError(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "error");
        Views.showSnackBar$default(this.c, str, 0, (String) null, 0, (Function0) null, (Function0) null, 0, 126, (Object) null);
    }

    @Override // com.avito.android.code_confirmation.CodeConfirmationView
    public void showMessage(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        Context context = this.a;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        ToastsKt.showToast$default(context, str, 0, 2, (Object) null);
    }

    @Override // com.avito.android.code_confirmation.CodeConfirmationView
    public void showProgress() {
        Views.show(this.b);
    }

    @Override // com.avito.android.code_confirmation.CodeConfirmationView
    public void showRequestButton() {
        this.f.setDisplayedChild(1);
        this.h.setText("");
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: android.text.SpannableString */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.avito.android.code_confirmation.CodeConfirmationView
    public void showText(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "text");
        Intrinsics.checkNotNullParameter(str2, "highlightText");
        int indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) str, str2, 0, false, 6, (Object) null);
        Text text = this.k;
        if (indexOf$default >= 0) {
            SpannableString spannableString = new SpannableString(str);
            spannableString.setSpan(new StyleSpan(1), indexOf$default, str2.length() + indexOf$default, 33);
            Unit unit = Unit.INSTANCE;
            str = spannableString;
        }
        text.setText(str);
    }

    @Override // com.avito.android.code_confirmation.CodeConfirmationView
    public void showTimer(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        this.h.setText(str);
        this.f.setDisplayedChild(0);
    }

    @Override // com.avito.android.code_confirmation.CodeConfirmationView
    public void showUserDialog(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull Function0<Unit> function0, @NotNull Function0<Unit> function02) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "message");
        Intrinsics.checkNotNullParameter(str3, "agreeButtonTitle");
        Intrinsics.checkNotNullParameter(function0, "onAgree");
        Intrinsics.checkNotNullParameter(function02, "onCancel");
        DialogRouter dialogRouter = this.m;
        String string = this.c.getContext().getString(com.avito.android.ui_components.R.string.cancel);
        Intrinsics.checkNotNullExpressionValue(string, "contentView.context.getString(ui_R.string.cancel)");
        this.l = dialogRouter.showCancelableNotifyingDialog(str, true, str2, string, function02, str3, function0);
    }
}
