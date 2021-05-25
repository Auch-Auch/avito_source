package ru.avito.component.text_input.password;

import android.view.View;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Keyboards;
import com.avito.android.util.SimpleTextWatcher;
import com.avito.android.util.Views;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.jakewharton.rxrelay3.PublishRelay;
import io.reactivex.rxjava3.core.Observable;
import java.util.Arrays;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import ru.avito.component.text_input.password.EditTextPassword;
@Deprecated(message = "Используй com.avito.android.lib.design.input.Input", replaceWith = @ReplaceWith(expression = "Input", imports = {"com.avito.android.lib.design.input.Input"}))
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010J\u001a\u00020I¢\u0006\u0004\bK\u0010LJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016¢\u0006\u0004\b\f\u0010\rJ2\u0010\u0013\u001a\u00020\u00022!\u0010\u0012\u001a\u001d\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00020\u000eH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\nH\u0016¢\u0006\u0004\b\u0016\u0010\rJ2\u0010\u0018\u001a\u00020\u00022!\u0010\u0012\u001a\u001d\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u00020\u000eH\u0016¢\u0006\u0004\b\u0018\u0010\u0014J2\u0010\u001a\u001a\u00020\u00022!\u0010\u0012\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u00020\u000eH\u0016¢\u0006\u0004\b\u001a\u0010\u0014J\u000f\u0010\u001b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001b\u0010\u0004J\u000f\u0010\u001c\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001c\u0010\u0004J#\u0010\u001f\u001a\u00020\u00022\u0012\u0010\u001e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000b0\u001d\"\u00020\u000bH\u0016¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\u0015H\u0016¢\u0006\u0004\b!\u0010\"RD\u0010(\u001a0\u0012\f\u0012\n $*\u0004\u0018\u00010\u000b0\u000b $*\u0017\u0012\f\u0012\n $*\u0004\u0018\u00010\u000b0\u000b\u0018\u00010#¢\u0006\u0002\b%0#¢\u0006\u0002\b%8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010'R$\u0010-\u001a\u00020\u00062\u0006\u0010)\u001a\u00020\u00068V@VX\u000e¢\u0006\f\u001a\u0004\b*\u0010+\"\u0004\b,\u0010\tR$\u0010.\u001a\u00020\u00152\u0006\u0010)\u001a\u00020\u00158V@VX\u000e¢\u0006\f\u001a\u0004\b.\u0010\"\"\u0004\b/\u00100R$\u0010\u001e\u001a\u0002012\u0006\u0010)\u001a\u0002018V@VX\u000e¢\u0006\f\u001a\u0004\b2\u00103\"\u0004\b\b\u00104R\u0016\u00108\u001a\u0002058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b6\u00107R$\u0010;\u001a\u00020\u00152\u0006\u0010)\u001a\u00020\u00158V@VX\u000e¢\u0006\f\u001a\u0004\b9\u0010\"\"\u0004\b:\u00100R$\u0010>\u001a\u00020\u00062\u0006\u0010)\u001a\u00020\u00068V@VX\u000e¢\u0006\f\u001a\u0004\b<\u0010+\"\u0004\b=\u0010\tRD\u0010@\u001a0\u0012\f\u0012\n $*\u0004\u0018\u00010\u00150\u0015 $*\u0017\u0012\f\u0012\n $*\u0004\u0018\u00010\u00150\u0015\u0018\u00010#¢\u0006\u0002\b%0#¢\u0006\u0002\b%8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b?\u0010'R$\u0010C\u001a\u00020\u00062\u0006\u0010)\u001a\u00020\u00068V@VX\u000e¢\u0006\f\u001a\u0004\bA\u0010+\"\u0004\bB\u0010\tR$\u0010\u0011\u001a\u0002012\u0006\u0010)\u001a\u0002018V@VX\u000e¢\u0006\f\u001a\u0004\bD\u00103\"\u0004\bE\u00104R$\u0010H\u001a\u00020\u00152\u0006\u0010)\u001a\u00020\u00158V@VX\u000e¢\u0006\f\u001a\u0004\bF\u0010\"\"\u0004\bG\u00100¨\u0006M"}, d2 = {"Lru/avito/component/text_input/password/EditTextPasswordImpl;", "Lru/avito/component/text_input/password/EditTextPassword;", "", "show", "()V", "hide", "", "hintId", "setHint", "(I)V", "Lio/reactivex/rxjava3/core/Observable;", "", "textChangeCallbacks", "()Lio/reactivex/rxjava3/core/Observable;", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "text", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setTextChangeListener", "(Lkotlin/jvm/functions/Function1;)V", "", "focusChangeCallbacks", "hasFocus", "setFocusChangeListener", "actionId", "setActionListener", "showKeyboard", "moveCursorToEnd", "", "hint", "setAutofillHints", "([Ljava/lang/String;)V", "isShown", "()Z", "Lcom/jakewharton/rxrelay3/PublishRelay;", "kotlin.jvm.PlatformType", "Lio/reactivex/rxjava3/annotations/NonNull;", AuthSource.BOOKING_ORDER, "Lcom/jakewharton/rxrelay3/PublishRelay;", "textChangeRelay", "value", "getImeOptions", "()I", "setImeOptions", "imeOptions", "isSecure", "setSecure", "(Z)V", "", "getHint", "()Ljava/lang/CharSequence;", "(Ljava/lang/CharSequence;)V", "Lru/avito/component/text_input/password/PasswordInputView;", AuthSource.SEND_ABUSE, "Lru/avito/component/text_input/password/PasswordInputView;", "input", "getEnable", "setEnable", "enable", "getTextLength", "setTextLength", "textLength", "c", "focusChangeRelay", "getInputType", "setInputType", "inputType", "getText", "setText", "getHasError", "setHasError", "hasError", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class EditTextPasswordImpl implements EditTextPassword {
    public final PasswordInputView a;
    public final PublishRelay<String> b = PublishRelay.create();
    public final PublishRelay<Boolean> c = PublishRelay.create();

    public static final class a extends Lambda implements Function1<Boolean, Unit> {
        public final /* synthetic */ EditTextPasswordImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(EditTextPasswordImpl editTextPasswordImpl) {
            super(1);
            this.a = editTextPasswordImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Boolean bool) {
            this.a.c.accept(Boolean.valueOf(bool.booleanValue()));
            return Unit.INSTANCE;
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ EditTextPasswordImpl a;

        public b(EditTextPasswordImpl editTextPasswordImpl) {
            this.a = editTextPasswordImpl;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Keyboards.showKeyboard$default(this.a.a, 0, 1, null);
        }
    }

    public static final class c extends Lambda implements Function1<String, Unit> {
        public final /* synthetic */ EditTextPasswordImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(EditTextPasswordImpl editTextPasswordImpl) {
            super(1);
            this.a = editTextPasswordImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(String str) {
            String str2 = str;
            Intrinsics.checkNotNullParameter(str2, "it");
            this.a.b.accept(str2);
            return Unit.INSTANCE;
        }
    }

    public EditTextPasswordImpl(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        PasswordInputView passwordInputView = (PasswordInputView) view;
        this.a = passwordInputView;
        passwordInputView.setMaxLines(1);
        passwordInputView.setInputType(128);
        passwordInputView.setSecure(true);
    }

    @Override // ru.avito.component.text_input.EditTextSingleLine
    @NotNull
    public Observable<Integer> actionCallbacks() {
        return EditTextPassword.DefaultImpls.actionCallbacks(this);
    }

    @Override // ru.avito.component.text_input.EditTextSingleLine
    @NotNull
    public Observable<Unit> doneCallbacks() {
        return EditTextPassword.DefaultImpls.doneCallbacks(this);
    }

    @Override // ru.avito.component.text_input.EditTextSingleLine
    @NotNull
    public Observable<Boolean> focusChangeCallbacks() {
        setFocusChangeListener(new a(this));
        PublishRelay<Boolean> publishRelay = this.c;
        Intrinsics.checkNotNullExpressionValue(publishRelay, "focusChangeRelay");
        return publishRelay;
    }

    @Override // ru.avito.component.text_input.EditTextSingleLine
    public boolean getEnable() {
        return this.a.getEnable();
    }

    @Override // ru.avito.component.text_input.EditTextSingleLine
    public boolean getHasError() {
        return this.a.getHasError();
    }

    @Override // ru.avito.component.text_input.EditTextSingleLine
    @NotNull
    public CharSequence getHint() {
        return this.a.getHint();
    }

    @Override // ru.avito.component.text_input.EditTextSingleLine
    public int getImeOptions() {
        return this.a.getImeOptions();
    }

    @Override // ru.avito.component.text_input.EditTextSingleLine
    public int getInputType() {
        return this.a.getInputType();
    }

    @Override // ru.avito.component.text_input.EditTextSingleLine
    @NotNull
    public CharSequence getText() {
        return this.a.getText();
    }

    @Override // ru.avito.component.text_input.EditTextSingleLine
    public int getTextLength() {
        return this.a.getTextLength();
    }

    @Override // ru.avito.component.text_input.EditTextSingleLine
    public void hide() {
        Views.hide(this.a);
    }

    @Override // ru.avito.component.text_input.password.EditTextPassword
    public boolean isSecure() {
        return this.a.isSecure();
    }

    @Override // ru.avito.component.text_input.EditTextSingleLine
    public boolean isShown() {
        return Views.isVisible(this.a);
    }

    @Override // ru.avito.component.text_input.EditTextSingleLine
    public void moveCursorToEnd() {
        this.a.moveCursorToEnd();
    }

    @Override // ru.avito.component.text_input.EditTextSingleLine
    public void setActionListener(@NotNull Function1<? super Integer, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.a.setActionListener(function1);
    }

    @Override // ru.avito.component.text_input.EditTextSingleLine
    public void setAutofillHints(@NotNull String... strArr) {
        Intrinsics.checkNotNullParameter(strArr, "hint");
        this.a.setAutofillHints((String[]) Arrays.copyOf(strArr, strArr.length));
    }

    @Override // ru.avito.component.text_input.EditTextSingleLine
    public void setEnable(boolean z) {
        this.a.setEnable(z);
    }

    @Override // ru.avito.component.text_input.EditTextSingleLine
    public void setFocusChangeListener(@NotNull Function1<? super Boolean, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.a.setFocusChangeListener(function1);
    }

    @Override // ru.avito.component.text_input.EditTextSingleLine
    public void setHasError(boolean z) {
        this.a.setHasError(z);
    }

    @Override // ru.avito.component.text_input.EditTextSingleLine
    public void setHint(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "value");
        this.a.setHint(charSequence);
    }

    @Override // ru.avito.component.text_input.EditTextSingleLine
    public void setImeOptions(int i) {
        this.a.setImeOptions(i);
    }

    @Override // ru.avito.component.text_input.EditTextSingleLine
    public void setInputType(int i) {
        this.a.setInputType(i);
    }

    @Override // ru.avito.component.text_input.password.EditTextPassword
    public void setSecure(boolean z) {
        this.a.setSecure(z);
    }

    @Override // ru.avito.component.text_input.EditTextSingleLine
    public void setText(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "value");
        this.a.setText(charSequence);
    }

    @Override // ru.avito.component.text_input.EditTextSingleLine
    public void setTextChangeListener(@NotNull Function1<? super String, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.a.setTextChangeListener(new SimpleTextWatcher(function1) { // from class: ru.avito.component.text_input.password.EditTextPasswordImpl$setTextChangeListener$1
            public final /* synthetic */ Function1 a;

            {
                this.a = r1;
            }

            @Override // com.avito.android.util.SimpleTextWatcher, android.text.TextWatcher
            public void onTextChanged(@NotNull CharSequence charSequence, int i, int i2, int i3) {
                Intrinsics.checkNotNullParameter(charSequence, "s");
                this.a.invoke(charSequence.toString());
            }
        });
    }

    @Override // ru.avito.component.text_input.EditTextSingleLine
    public void setTextLength(int i) {
        this.a.setTextLength(i);
    }

    @Override // ru.avito.component.text_input.EditTextSingleLine
    public void show() {
        Views.show(this.a);
    }

    @Override // ru.avito.component.text_input.EditTextSingleLine
    public void showKeyboard() {
        this.a.post(new b(this));
    }

    @Override // ru.avito.component.text_input.EditTextSingleLine
    @NotNull
    public Observable<String> textChangeCallbacks() {
        setTextChangeListener(new c(this));
        PublishRelay<String> publishRelay = this.b;
        Intrinsics.checkNotNullExpressionValue(publishRelay, "textChangeRelay");
        return publishRelay;
    }

    @Override // ru.avito.component.text_input.EditTextSingleLine
    public void setHint(int i) {
        this.a.setHintResId(i);
    }
}
