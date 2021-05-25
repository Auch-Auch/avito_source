package ru.avito.component.text_input;

import android.view.View;
import com.avito.android.design.widget.TextInputAreaView;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.SimpleTextWatcher;
import com.avito.android.util.Views;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.jakewharton.rxrelay3.PublishRelay;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Deprecated(message = "Используй com.avito.android.lib.design.input.Input", replaceWith = @ReplaceWith(expression = "Input", imports = {"com.avito.android.lib.design.input.Input"}))
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\r\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010>\u001a\u00020=¢\u0006\u0004\b?\u0010@J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000f\u0010\tJ\u0017\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000f\u0010\rJ#\u0010\u0014\u001a\u00020\u00022\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00020\u0011H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\n0\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0019\u0010\u0004RD\u0010\u001f\u001a0\u0012\f\u0012\n \u001b*\u0004\u0018\u00010\n0\n \u001b*\u0017\u0012\f\u0012\n \u001b*\u0004\u0018\u00010\n0\n\u0018\u00010\u001a¢\u0006\u0002\b\u001c0\u001a¢\u0006\u0002\b\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR$\u0010$\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u00068V@VX\u000e¢\u0006\f\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010\tR$\u0010)\u001a\u00020\u00122\u0006\u0010 \u001a\u00020\u00128V@VX\u000e¢\u0006\f\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R$\u0010\u0010\u001a\u00020*2\u0006\u0010 \u001a\u00020*8V@VX\u000e¢\u0006\f\u001a\u0004\b+\u0010,\"\u0004\b\u000f\u0010-R$\u00100\u001a\u00020\u00122\u0006\u0010 \u001a\u00020\u00128V@VX\u000e¢\u0006\f\u001a\u0004\b.\u0010&\"\u0004\b/\u0010(R$\u00103\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u00068V@VX\u000e¢\u0006\f\u001a\u0004\b1\u0010\"\"\u0004\b2\u0010\tR$\u0010\u000b\u001a\u00020*2\u0006\u0010 \u001a\u00020*8V@VX\u000e¢\u0006\f\u001a\u0004\b4\u0010,\"\u0004\b5\u0010-R$\u00108\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u00068V@VX\u000e¢\u0006\f\u001a\u0004\b6\u0010\"\"\u0004\b7\u0010\tR\u0016\u0010<\u001a\u0002098\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b:\u0010;¨\u0006A"}, d2 = {"Lru/avito/component/text_input/EditTextAreaImpl;", "Lru/avito/component/text_input/EditTextArea;", "", "show", "()V", "hide", "", FirebaseAnalytics.Param.INDEX, "setSelection", "(I)V", "", "text", "insertInCursorPosition", "(Ljava/lang/String;)V", "hintId", "setHint", "hint", "Lkotlin/Function1;", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnFocusChangeListener", "(Lkotlin/jvm/functions/Function1;)V", "Lio/reactivex/rxjava3/core/Observable;", "textChangeCallbacks", "()Lio/reactivex/rxjava3/core/Observable;", "requestFocus", "Lcom/jakewharton/rxrelay3/PublishRelay;", "kotlin.jvm.PlatformType", "Lio/reactivex/rxjava3/annotations/NonNull;", AuthSource.BOOKING_ORDER, "Lcom/jakewharton/rxrelay3/PublishRelay;", "textChangeCallbacksRelay", "value", "getInputType", "()I", "setInputType", "inputType", "getEnable", "()Z", "setEnable", "(Z)V", "enable", "", "getHint", "()Ljava/lang/CharSequence;", "(Ljava/lang/CharSequence;)V", "getHasError", "setHasError", "hasError", "getTextLength", "setTextLength", "textLength", "getText", "setText", "getImeOptions", "setImeOptions", "imeOptions", "Lcom/avito/android/design/widget/TextInputAreaView;", AuthSource.SEND_ABUSE, "Lcom/avito/android/design/widget/TextInputAreaView;", "textInputView", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class EditTextAreaImpl implements EditTextArea {
    public final TextInputAreaView a;
    public final PublishRelay<String> b = PublishRelay.create();

    public static final class a implements View.OnFocusChangeListener {
        public final /* synthetic */ Function1 a;

        public a(Function1 function1) {
            this.a = function1;
        }

        @Override // android.view.View.OnFocusChangeListener
        public final void onFocusChange(View view, boolean z) {
            this.a.invoke(Boolean.valueOf(z));
        }
    }

    public EditTextAreaImpl(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.a = (TextInputAreaView) view;
    }

    @Override // ru.avito.component.text_input.EditTextArea
    public boolean getEnable() {
        return this.a.getEnable();
    }

    @Override // ru.avito.component.text_input.EditTextArea
    public boolean getHasError() {
        return this.a.getHasError();
    }

    @Override // ru.avito.component.text_input.EditTextArea
    @NotNull
    public CharSequence getHint() {
        return this.a.getHint();
    }

    @Override // ru.avito.component.text_input.EditTextArea
    public int getImeOptions() {
        return this.a.getImeOptions();
    }

    @Override // ru.avito.component.text_input.EditTextArea
    public int getInputType() {
        return this.a.getInputType();
    }

    @Override // ru.avito.component.text_input.EditTextArea
    @NotNull
    public CharSequence getText() {
        return this.a.getText();
    }

    @Override // ru.avito.component.text_input.EditTextArea
    public int getTextLength() {
        return this.a.getTextLength();
    }

    @Override // ru.avito.component.text_input.EditTextArea
    public void hide() {
        Views.hide(this.a);
    }

    @Override // ru.avito.component.text_input.EditTextArea
    public void insertInCursorPosition(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        this.a.insertInCursorPosition(str);
    }

    @Override // ru.avito.component.text_input.EditTextArea
    public void requestFocus() {
        this.a.requestFocus();
    }

    @Override // ru.avito.component.text_input.EditTextArea
    public void setEnable(boolean z) {
        this.a.setEnable(z);
    }

    @Override // ru.avito.component.text_input.EditTextArea
    public void setHasError(boolean z) {
        this.a.setHasError(z);
    }

    @Override // ru.avito.component.text_input.EditTextArea
    public void setHint(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "value");
        this.a.setHint(charSequence);
    }

    @Override // ru.avito.component.text_input.EditTextArea
    public void setImeOptions(int i) {
        this.a.setImeOptions(i);
    }

    @Override // ru.avito.component.text_input.EditTextArea
    public void setInputType(int i) {
        this.a.setInputType(i);
    }

    @Override // ru.avito.component.text_input.EditTextArea
    public void setOnFocusChangeListener(@NotNull Function1<? super Boolean, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.a.setFocusChangeListener(new a(function1));
    }

    @Override // ru.avito.component.text_input.EditTextArea
    public void setSelection(int i) {
        this.a.setSelection(i);
    }

    @Override // ru.avito.component.text_input.EditTextArea
    public void setText(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "value");
        this.a.setText(charSequence);
    }

    @Override // ru.avito.component.text_input.EditTextArea
    public void setTextLength(int i) {
        this.a.setTextLength(i);
    }

    @Override // ru.avito.component.text_input.EditTextArea
    public void show() {
        Views.show(this.a);
    }

    @Override // ru.avito.component.text_input.EditTextArea
    @NotNull
    public Observable<String> textChangeCallbacks() {
        this.a.setTextChangeListener(new SimpleTextWatcher(this) { // from class: ru.avito.component.text_input.EditTextAreaImpl$textChangeCallbacks$1
            public final /* synthetic */ EditTextAreaImpl a;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.a = r1;
            }

            @Override // com.avito.android.util.SimpleTextWatcher, android.text.TextWatcher
            public void onTextChanged(@NotNull CharSequence charSequence, int i, int i2, int i3) {
                Intrinsics.checkNotNullParameter(charSequence, "s");
                this.a.b.accept(charSequence.toString());
            }
        });
        PublishRelay<String> publishRelay = this.b;
        Intrinsics.checkNotNullExpressionValue(publishRelay, "textChangeCallbacksRelay");
        return publishRelay;
    }

    @Override // ru.avito.component.text_input.EditTextArea
    public void setHint(int i) {
        this.a.setHintResId(i);
    }

    @Override // ru.avito.component.text_input.EditTextArea
    public void setHint(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "hint");
        this.a.setHint(str);
    }
}
