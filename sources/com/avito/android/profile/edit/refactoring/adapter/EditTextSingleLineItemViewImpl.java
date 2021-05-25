package com.avito.android.profile.edit.refactoring.adapter;

import android.view.View;
import androidx.annotation.StringRes;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.avito.component.text_input.EditTextSingleLine;
import ru.avito.component.text_input.EditTextSingleLineImpl;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\r\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u000f\u0012\u0006\u0010?\u001a\u00020>¢\u0006\u0004\b@\u0010AJ\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0004H\u0001¢\u0006\u0004\b\t\u0010\u0007J\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u0004H\u0001¢\u0006\u0004\b\u000b\u0010\u0007J\u0010\u0010\f\u001a\u00020\bH\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\nH\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\bH\u0001¢\u0006\u0004\b\u0010\u0010\rJ3\u0010\u0016\u001a\u00020\b2!\u0010\u0015\u001a\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\b0\u0011H\u0001¢\u0006\u0004\b\u0016\u0010\u0017J$\u0010\u001b\u001a\u00020\b2\u0012\u0010\u001a\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00190\u0018\"\u00020\u0019H\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ3\u0010\u001e\u001a\u00020\b2!\u0010\u0015\u001a\u001d\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\b0\u0011H\u0001¢\u0006\u0004\b\u001e\u0010\u0017J\u001a\u0010 \u001a\u00020\b2\b\b\u0001\u0010\u001f\u001a\u00020\u0005H\u0001¢\u0006\u0004\b \u0010!J3\u0010#\u001a\u00020\b2!\u0010\u0015\u001a\u001d\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\b0\u0011H\u0001¢\u0006\u0004\b#\u0010\u0017J\u0010\u0010$\u001a\u00020\bH\u0001¢\u0006\u0004\b$\u0010\rJ\u0010\u0010%\u001a\u00020\bH\u0001¢\u0006\u0004\b%\u0010\rJ\u0016\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00190\u0004H\u0001¢\u0006\u0004\b&\u0010\u0007R\u001c\u0010*\u001a\u00020\n8\u0016@\u0016X\u000f¢\u0006\f\u001a\u0004\b'\u0010\u000f\"\u0004\b(\u0010)R\u001c\u0010\"\u001a\u00020+8\u0016@\u0016X\u000f¢\u0006\f\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001c\u00103\u001a\u00020\u00058\u0016@\u0016X\u000f¢\u0006\f\u001a\u0004\b0\u00101\"\u0004\b2\u0010!R\u001c\u00106\u001a\u00020\u00058\u0016@\u0016X\u000f¢\u0006\f\u001a\u0004\b4\u00101\"\u0004\b5\u0010!R\u001c\u0010\u001a\u001a\u00020+8\u0016@\u0016X\u000f¢\u0006\f\u001a\u0004\b7\u0010-\"\u0004\b \u0010/R\u001c\u0010:\u001a\u00020\u00058\u0016@\u0016X\u000f¢\u0006\f\u001a\u0004\b8\u00101\"\u0004\b9\u0010!R\u001c\u0010=\u001a\u00020\n8\u0016@\u0016X\u000f¢\u0006\f\u001a\u0004\b;\u0010\u000f\"\u0004\b<\u0010)¨\u0006B"}, d2 = {"Lcom/avito/android/profile/edit/refactoring/adapter/EditTextSingleLineItemViewImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/profile/edit/refactoring/adapter/EditTextSingleLineItemView;", "Lru/avito/component/text_input/EditTextSingleLine;", "Lio/reactivex/rxjava3/core/Observable;", "", "actionCallbacks", "()Lio/reactivex/rxjava3/core/Observable;", "", "doneCallbacks", "", "focusChangeCallbacks", "hide", "()V", "isShown", "()Z", "moveCursorToEnd", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "actionId", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setActionListener", "(Lkotlin/jvm/functions/Function1;)V", "", "", "hint", "setAutofillHints", "([Ljava/lang/String;)V", "hasFocus", "setFocusChangeListener", "hintId", "setHint", "(I)V", "text", "setTextChangeListener", "show", "showKeyboard", "textChangeCallbacks", "getEnable", "setEnable", "(Z)V", "enable", "", "getText", "()Ljava/lang/CharSequence;", "setText", "(Ljava/lang/CharSequence;)V", "getTextLength", "()I", "setTextLength", "textLength", "getImeOptions", "setImeOptions", "imeOptions", "getHint", "getInputType", "setInputType", "inputType", "getHasError", "setHasError", "hasError", "Landroid/view/View;", "rootView", "<init>", "(Landroid/view/View;)V", "profile_release"}, k = 1, mv = {1, 4, 2})
public final class EditTextSingleLineItemViewImpl extends BaseViewHolder implements EditTextSingleLineItemView, EditTextSingleLine {
    public final /* synthetic */ EditTextSingleLineImpl s;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public EditTextSingleLineItemViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "rootView");
        this.s = new EditTextSingleLineImpl(view);
    }

    @Override // ru.avito.component.text_input.EditTextSingleLine
    @NotNull
    public Observable<Integer> actionCallbacks() {
        return this.s.actionCallbacks();
    }

    @Override // ru.avito.component.text_input.EditTextSingleLine
    @NotNull
    public Observable<Unit> doneCallbacks() {
        return this.s.doneCallbacks();
    }

    @Override // ru.avito.component.text_input.EditTextSingleLine
    @NotNull
    public Observable<Boolean> focusChangeCallbacks() {
        return this.s.focusChangeCallbacks();
    }

    @Override // ru.avito.component.text_input.EditTextSingleLine
    public boolean getEnable() {
        return this.s.getEnable();
    }

    @Override // ru.avito.component.text_input.EditTextSingleLine
    public boolean getHasError() {
        return this.s.getHasError();
    }

    @Override // ru.avito.component.text_input.EditTextSingleLine
    @NotNull
    public CharSequence getHint() {
        return this.s.getHint();
    }

    @Override // ru.avito.component.text_input.EditTextSingleLine
    public int getImeOptions() {
        return this.s.getImeOptions();
    }

    @Override // ru.avito.component.text_input.EditTextSingleLine
    public int getInputType() {
        return this.s.getInputType();
    }

    @Override // ru.avito.component.text_input.EditTextSingleLine
    @NotNull
    public CharSequence getText() {
        return this.s.getText();
    }

    @Override // ru.avito.component.text_input.EditTextSingleLine
    public int getTextLength() {
        return this.s.getTextLength();
    }

    @Override // ru.avito.component.text_input.EditTextSingleLine
    public void hide() {
        this.s.hide();
    }

    @Override // ru.avito.component.text_input.EditTextSingleLine
    public boolean isShown() {
        return this.s.isShown();
    }

    @Override // ru.avito.component.text_input.EditTextSingleLine
    public void moveCursorToEnd() {
        this.s.moveCursorToEnd();
    }

    @Override // ru.avito.component.text_input.EditTextSingleLine
    public void setActionListener(@NotNull Function1<? super Integer, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.s.setActionListener(function1);
    }

    @Override // ru.avito.component.text_input.EditTextSingleLine
    public void setAutofillHints(@NotNull String... strArr) {
        Intrinsics.checkNotNullParameter(strArr, "hint");
        this.s.setAutofillHints(strArr);
    }

    @Override // ru.avito.component.text_input.EditTextSingleLine
    public void setEnable(boolean z) {
        this.s.setEnable(z);
    }

    @Override // ru.avito.component.text_input.EditTextSingleLine
    public void setFocusChangeListener(@NotNull Function1<? super Boolean, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.s.setFocusChangeListener(function1);
    }

    @Override // ru.avito.component.text_input.EditTextSingleLine
    public void setHasError(boolean z) {
        this.s.setHasError(z);
    }

    @Override // ru.avito.component.text_input.EditTextSingleLine
    public void setHint(@StringRes int i) {
        this.s.setHint(i);
    }

    @Override // ru.avito.component.text_input.EditTextSingleLine
    public void setHint(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "<set-?>");
        this.s.setHint(charSequence);
    }

    @Override // ru.avito.component.text_input.EditTextSingleLine
    public void setImeOptions(int i) {
        this.s.setImeOptions(i);
    }

    @Override // ru.avito.component.text_input.EditTextSingleLine
    public void setInputType(int i) {
        this.s.setInputType(i);
    }

    @Override // ru.avito.component.text_input.EditTextSingleLine
    public void setText(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "<set-?>");
        this.s.setText(charSequence);
    }

    @Override // ru.avito.component.text_input.EditTextSingleLine
    public void setTextChangeListener(@NotNull Function1<? super String, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.s.setTextChangeListener(function1);
    }

    @Override // ru.avito.component.text_input.EditTextSingleLine
    public void setTextLength(int i) {
        this.s.setTextLength(i);
    }

    @Override // ru.avito.component.text_input.EditTextSingleLine
    public void show() {
        this.s.show();
    }

    @Override // ru.avito.component.text_input.EditTextSingleLine
    public void showKeyboard() {
        this.s.showKeyboard();
    }

    @Override // ru.avito.component.text_input.EditTextSingleLine
    @NotNull
    public Observable<String> textChangeCallbacks() {
        return this.s.textChangeCallbacks();
    }
}
