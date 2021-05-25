package com.avito.android.conveyor_shared_item.phone_item;

import android.view.View;
import androidx.annotation.StringRes;
import com.avito.android.analytics.screens.InternalConstsKt;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.Disposable;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.component.text_input.EditTextPhone;
import ru.avito.component.text_input.EditTextPhoneImpl;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\r\n\u0002\b\u0016\n\u0002\u0010\f\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u000f\u0012\u0006\u0010Z\u001a\u00020Y¢\u0006\u0004\b[\u0010\\J\u001f\u0010\u0007\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0016\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u000bH\u0001¢\u0006\u0004\b\u000f\u0010\u000eJ\u0016\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000bH\u0001¢\u0006\u0004\b\u0011\u0010\u000eJ\u0010\u0010\u0012\u001a\u00020\u0005H\u0001¢\u0006\u0004\b\u0012\u0010\nJ\u0010\u0010\u0013\u001a\u00020\u0005H\u0001¢\u0006\u0004\b\u0013\u0010\nJ\u0010\u0010\u0014\u001a\u00020\u0005H\u0001¢\u0006\u0004\b\u0014\u0010\nJ3\u0010\u0019\u001a\u00020\u00052!\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\f¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u00050\u0015H\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ$\u0010\u001d\u001a\u00020\u00052\u0012\u0010\u001c\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00100\u001b\"\u00020\u0010H\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ3\u0010\"\u001a\u00020!2!\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\u001f¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\u00050\u0015H\u0001¢\u0006\u0004\b\"\u0010#J3\u0010%\u001a\u00020!2!\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u00050\u0015H\u0001¢\u0006\u0004\b%\u0010#J\u001a\u0010'\u001a\u00020\u00052\b\b\u0001\u0010&\u001a\u00020\fH\u0001¢\u0006\u0004\b'\u0010(J\u0018\u0010'\u001a\u00020\u00052\u0006\u0010)\u001a\u00020\u0010H\u0001¢\u0006\u0004\b'\u0010*J3\u0010,\u001a\u00020!2!\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(+\u0012\u0004\u0012\u00020\u00050\u0015H\u0001¢\u0006\u0004\b,\u0010#J\u0010\u0010-\u001a\u00020\u0005H\u0001¢\u0006\u0004\b-\u0010\nJ\u0010\u0010.\u001a\u00020\u0005H\u0001¢\u0006\u0004\b.\u0010\nR\u001c\u0010)\u001a\u00020/8\u0016@\u0016X\u000f¢\u0006\f\u001a\u0004\b0\u00101\"\u0004\b'\u00102R\u001c\u00107\u001a\u00020\u001f8\u0016@\u0016X\u000f¢\u0006\f\u001a\u0004\b3\u00104\"\u0004\b5\u00106R9\u0010;\u001a\u001f\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(+\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00158\u0016@\u0016X\u000f¢\u0006\f\u001a\u0004\b8\u00109\"\u0004\b:\u0010\u001aR\u001c\u0010?\u001a\u00020\u00108\u0016@\u0016X\u000f¢\u0006\f\u001a\u0004\b<\u0010=\"\u0004\b>\u0010*R9\u0010B\u001a\u001f\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00158\u0016@\u0016X\u000f¢\u0006\f\u001a\u0004\b@\u00109\"\u0004\bA\u0010\u001aR\u001c\u0010E\u001a\u00020/8\u0016@\u0016X\u000f¢\u0006\f\u001a\u0004\bC\u00101\"\u0004\bD\u00102R\u001c\u0010K\u001a\u00020F8\u0016@\u0016X\u000f¢\u0006\f\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\u001e\u0010N\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bL\u0010MR9\u0010Q\u001a\u001f\u0012\u0013\u0012\u00110\u001f¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00158\u0016@\u0016X\u000f¢\u0006\f\u001a\u0004\bO\u00109\"\u0004\bP\u0010\u001aR\u001c\u0010T\u001a\u00020\u001f8\u0016@\u0016X\u000f¢\u0006\f\u001a\u0004\bR\u00104\"\u0004\bS\u00106R\u001c\u0010X\u001a\u00020\f8\u0016@\u0016X\u000f¢\u0006\f\u001a\u0004\bU\u0010V\"\u0004\bW\u0010(¨\u0006]"}, d2 = {"Lcom/avito/android/conveyor_shared_item/phone_item/EditTextPhoneItemViewImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/conveyor_shared_item/phone_item/EditTextPhoneItemView;", "Lru/avito/component/text_input/EditTextPhone;", "Lkotlin/Function0;", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setUnbindListener", "(Lkotlin/jvm/functions/Function0;)V", "onUnbind", "()V", "Lio/reactivex/rxjava3/core/Observable;", "", "actionCallbacks", "()Lio/reactivex/rxjava3/core/Observable;", "doneCallbacks", "", "formattedCallbacks", "hide", "moveCursorToEnd", "requestFocus", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "actionId", "setActionListener", "(Lkotlin/jvm/functions/Function1;)V", "", "hints", "setAutofillHints", "([Ljava/lang/String;)V", "", "hasFocus", "Lio/reactivex/rxjava3/disposables/Disposable;", "setFocusChangeListener", "(Lkotlin/jvm/functions/Function1;)Lio/reactivex/rxjava3/disposables/Disposable;", "formattedText", "setFormattedInputListener", "hintId", "setHint", "(I)V", "hint", "(Ljava/lang/String;)V", "rawText", "setRawInputListener", "show", "showKeyboard", "", "getHint", "()Ljava/lang/CharSequence;", "(Ljava/lang/CharSequence;)V", "getEnable", "()Z", "setEnable", "(Z)V", "enable", "getRawListener", "()Lkotlin/jvm/functions/Function1;", "setRawListener", "rawListener", "getMask", "()Ljava/lang/String;", "setMask", "mask", "getFormattedListener", "setFormattedListener", "formattedListener", "getText", "setText", "text", "", "getPlaceholder", "()C", "setPlaceholder", "(C)V", InternalConstsKt.PLACEHOLDER, "s", "Lkotlin/jvm/functions/Function0;", "unbindListener", "getFocusListener", "setFocusListener", "focusListener", "getHasError", "setHasError", "hasError", "getImeOptions", "()I", "setImeOptions", "imeOptions", "Landroid/view/View;", "rootView", "<init>", "(Landroid/view/View;)V", "conveyor-shared-item_release"}, k = 1, mv = {1, 4, 2})
public final class EditTextPhoneItemViewImpl extends BaseViewHolder implements EditTextPhoneItemView, EditTextPhone {
    public Function0<Unit> s;
    public final /* synthetic */ EditTextPhoneImpl t;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public EditTextPhoneItemViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "rootView");
        this.t = new EditTextPhoneImpl(view, null, 0, 6, null);
    }

    @Override // ru.avito.component.text_input.EditTextPhone
    @NotNull
    public Observable<Integer> actionCallbacks() {
        return this.t.actionCallbacks();
    }

    @Override // ru.avito.component.text_input.EditTextPhone
    @NotNull
    public Observable<Unit> doneCallbacks() {
        return this.t.doneCallbacks();
    }

    @Override // ru.avito.component.text_input.EditTextPhone
    @NotNull
    public Observable<String> formattedCallbacks() {
        return this.t.formattedCallbacks();
    }

    @Override // ru.avito.component.text_input.EditTextPhone
    public boolean getEnable() {
        return this.t.getEnable();
    }

    @Override // ru.avito.component.text_input.EditTextPhone
    @Nullable
    public Function1<Boolean, Unit> getFocusListener() {
        return this.t.getFocusListener();
    }

    @Override // ru.avito.component.text_input.EditTextPhone
    @Nullable
    public Function1<String, Unit> getFormattedListener() {
        return this.t.getFormattedListener();
    }

    @Override // ru.avito.component.text_input.EditTextPhone
    public boolean getHasError() {
        return this.t.getHasError();
    }

    @Override // ru.avito.component.text_input.EditTextPhone
    @NotNull
    public CharSequence getHint() {
        return this.t.getHint();
    }

    @Override // ru.avito.component.text_input.EditTextPhone
    public int getImeOptions() {
        return this.t.getImeOptions();
    }

    @Override // ru.avito.component.text_input.EditTextPhone
    @NotNull
    public String getMask() {
        return this.t.getMask();
    }

    @Override // ru.avito.component.text_input.EditTextPhone
    public char getPlaceholder() {
        return this.t.getPlaceholder();
    }

    @Override // ru.avito.component.text_input.EditTextPhone
    @Nullable
    public Function1<String, Unit> getRawListener() {
        return this.t.getRawListener();
    }

    @Override // ru.avito.component.text_input.EditTextPhone
    @NotNull
    public CharSequence getText() {
        return this.t.getText();
    }

    @Override // ru.avito.component.text_input.EditTextPhone
    public void hide() {
        this.t.hide();
    }

    @Override // ru.avito.component.text_input.EditTextPhone
    public void moveCursorToEnd() {
        this.t.moveCursorToEnd();
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        Function0<Unit> function0 = this.s;
        if (function0 != null) {
            function0.invoke();
        }
    }

    @Override // ru.avito.component.text_input.EditTextPhone
    public void requestFocus() {
        this.t.requestFocus();
    }

    @Override // ru.avito.component.text_input.EditTextPhone
    public void setActionListener(@NotNull Function1<? super Integer, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.t.setActionListener(function1);
    }

    @Override // ru.avito.component.text_input.EditTextPhone
    public void setAutofillHints(@NotNull String... strArr) {
        Intrinsics.checkNotNullParameter(strArr, "hints");
        this.t.setAutofillHints(strArr);
    }

    @Override // ru.avito.component.text_input.EditTextPhone
    public void setEnable(boolean z) {
        this.t.setEnable(z);
    }

    @Override // ru.avito.component.text_input.EditTextPhone
    @Deprecated(message = "Disposables are useless with RecyclerView rebinding")
    @NotNull
    public Disposable setFocusChangeListener(@NotNull Function1<? super Boolean, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        return this.t.setFocusChangeListener(function1);
    }

    @Override // ru.avito.component.text_input.EditTextPhone
    public void setFocusListener(@Nullable Function1<? super Boolean, Unit> function1) {
        this.t.setFocusListener(function1);
    }

    @Override // ru.avito.component.text_input.EditTextPhone
    @Deprecated(message = "Disposables are useless with RecyclerView rebinding")
    @NotNull
    public Disposable setFormattedInputListener(@NotNull Function1<? super String, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        return this.t.setFormattedInputListener(function1);
    }

    @Override // ru.avito.component.text_input.EditTextPhone
    public void setFormattedListener(@Nullable Function1<? super String, Unit> function1) {
        this.t.setFormattedListener(function1);
    }

    @Override // ru.avito.component.text_input.EditTextPhone
    public void setHasError(boolean z) {
        this.t.setHasError(z);
    }

    @Override // ru.avito.component.text_input.EditTextPhone
    public void setHint(@StringRes int i) {
        this.t.setHint(i);
    }

    @Override // ru.avito.component.text_input.EditTextPhone
    public void setHint(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "<set-?>");
        this.t.setHint(charSequence);
    }

    @Override // ru.avito.component.text_input.EditTextPhone
    public void setHint(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "hint");
        this.t.setHint(str);
    }

    @Override // ru.avito.component.text_input.EditTextPhone
    public void setImeOptions(int i) {
        this.t.setImeOptions(i);
    }

    @Override // ru.avito.component.text_input.EditTextPhone
    public void setMask(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.t.setMask(str);
    }

    @Override // ru.avito.component.text_input.EditTextPhone
    public void setPlaceholder(char c) {
        this.t.setPlaceholder(c);
    }

    @Override // ru.avito.component.text_input.EditTextPhone
    @Deprecated(message = "Disposables are useless with RecyclerView rebinding")
    @NotNull
    public Disposable setRawInputListener(@NotNull Function1<? super String, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        return this.t.setRawInputListener(function1);
    }

    @Override // ru.avito.component.text_input.EditTextPhone
    public void setRawListener(@Nullable Function1<? super String, Unit> function1) {
        this.t.setRawListener(function1);
    }

    @Override // ru.avito.component.text_input.EditTextPhone
    public void setText(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "<set-?>");
        this.t.setText(charSequence);
    }

    @Override // com.avito.android.conveyor_shared_item.phone_item.EditTextPhoneItemView
    public void setUnbindListener(@Nullable Function0<Unit> function0) {
        this.s = function0;
    }

    @Override // ru.avito.component.text_input.EditTextPhone
    public void show() {
        this.t.show();
    }

    @Override // ru.avito.component.text_input.EditTextPhone
    public void showKeyboard() {
        this.t.showKeyboard();
    }
}
