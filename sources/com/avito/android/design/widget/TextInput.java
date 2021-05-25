package com.avito.android.design.widget;

import android.text.TextWatcher;
import androidx.annotation.StringRes;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\r\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\u0007\u001a\u00020\u00022\b\b\u0001\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0007\u0010\bR\u001e\u0010\u000e\u001a\u0004\u0018\u00010\t8&@&X¦\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u0014\u001a\u00020\u000f8&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0018\u001a\u00020\u00058&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\bR\u001c\u0010\u001b\u001a\u00020\u000f8&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0019\u0010\u0011\"\u0004\b\u001a\u0010\u0013R\u001c\u0010\u001e\u001a\u00020\u00058&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u001c\u0010\u0016\"\u0004\b\u001d\u0010\bR\u001c\u0010$\u001a\u00020\u001f8&@&X¦\u000e¢\u0006\f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001c\u0010'\u001a\u00020\u00058&@&X¦\u000e¢\u0006\f\u001a\u0004\b%\u0010\u0016\"\u0004\b&\u0010\bR\u001c\u0010*\u001a\u00020\u001f8&@&X¦\u000e¢\u0006\f\u001a\u0004\b(\u0010!\"\u0004\b)\u0010#R9\u00103\u001a\u001f\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(.\u0012\u0004\u0012\u00020\u0002\u0018\u00010+8&@&X¦\u000e¢\u0006\f\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001c\u00106\u001a\u00020\u00058&@&X¦\u000e¢\u0006\f\u001a\u0004\b4\u0010\u0016\"\u0004\b5\u0010\bR9\u0010:\u001a\u001f\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(7\u0012\u0004\u0012\u00020\u0002\u0018\u00010+8&@&X¦\u000e¢\u0006\f\u001a\u0004\b8\u00100\"\u0004\b9\u00102¨\u0006;"}, d2 = {"Lcom/avito/android/design/widget/TextInput;", "", "", "moveCursorToEnd", "()V", "", "stringId", "setHintResId", "(I)V", "Landroid/text/TextWatcher;", "getTextChangeListener", "()Landroid/text/TextWatcher;", "setTextChangeListener", "(Landroid/text/TextWatcher;)V", "textChangeListener", "", "getHasError", "()Z", "setHasError", "(Z)V", "hasError", "getMaxLines", "()I", "setMaxLines", "maxLines", "getEnable", "setEnable", "enable", "getImeOptions", "setImeOptions", "imeOptions", "", "getText", "()Ljava/lang/CharSequence;", "setText", "(Ljava/lang/CharSequence;)V", "text", "getInputType", "setInputType", "inputType", "getHint", "setHint", "hint", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "hasFocus", "getFocusChangeListener", "()Lkotlin/jvm/functions/Function1;", "setFocusChangeListener", "(Lkotlin/jvm/functions/Function1;)V", "focusChangeListener", "getTextLength", "setTextLength", "textLength", "actionId", "getActionListener", "setActionListener", "actionListener", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public interface TextInput {
    @Nullable
    Function1<Integer, Unit> getActionListener();

    boolean getEnable();

    @Nullable
    Function1<Boolean, Unit> getFocusChangeListener();

    boolean getHasError();

    @NotNull
    CharSequence getHint();

    int getImeOptions();

    int getInputType();

    int getMaxLines();

    @NotNull
    CharSequence getText();

    @Nullable
    TextWatcher getTextChangeListener();

    int getTextLength();

    void moveCursorToEnd();

    void setActionListener(@Nullable Function1<? super Integer, Unit> function1);

    void setEnable(boolean z);

    void setFocusChangeListener(@Nullable Function1<? super Boolean, Unit> function1);

    void setHasError(boolean z);

    void setHint(@NotNull CharSequence charSequence);

    void setHintResId(@StringRes int i);

    void setImeOptions(int i);

    void setInputType(int i);

    void setMaxLines(int i);

    void setText(@NotNull CharSequence charSequence);

    void setTextChangeListener(@Nullable TextWatcher textWatcher);

    void setTextLength(int i);
}
