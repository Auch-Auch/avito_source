package ru.avito.component.text_input;

import androidx.annotation.StringRes;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.analytics.FirebaseAnalytics;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
@Deprecated(message = "Используй com.avito.android.lib.design.input.Input", replaceWith = @ReplaceWith(expression = "Input", imports = {"com.avito.android.lib.design.input.Input"}))
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u0018\bg\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004J\u0019\u0010\b\u001a\u00020\u00022\b\b\u0001\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH&¢\u0006\u0004\b\b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0006H&¢\u0006\u0004\b\u000e\u0010\tJ\u0017\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\nH&¢\u0006\u0004\b\u0010\u0010\fJ\u0015\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\n0\u0011H&¢\u0006\u0004\b\u0012\u0010\u0013J#\u0010\u0017\u001a\u00020\u00022\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00020\u0014H&¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0002H&¢\u0006\u0004\b\u0019\u0010\u0004R\u001c\u0010\u000f\u001a\u00020\u001a8&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001c\u0010\"\u001a\u00020\u00068&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\tR\u001c\u0010'\u001a\u00020\u00158&@&X¦\u000e¢\u0006\f\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001c\u0010*\u001a\u00020\u00158&@&X¦\u000e¢\u0006\f\u001a\u0004\b(\u0010$\"\u0004\b)\u0010&R\u001c\u0010\u000b\u001a\u00020\u001a8&@&X¦\u000e¢\u0006\f\u001a\u0004\b+\u0010\u001c\"\u0004\b\b\u0010\u001eR\u001c\u0010.\u001a\u00020\u00068&@&X¦\u000e¢\u0006\f\u001a\u0004\b,\u0010 \"\u0004\b-\u0010\tR\u001c\u00101\u001a\u00020\u00068&@&X¦\u000e¢\u0006\f\u001a\u0004\b/\u0010 \"\u0004\b0\u0010\t¨\u00062"}, d2 = {"Lru/avito/component/text_input/EditTextArea;", "", "", "show", "()V", "hide", "", "hintId", "setHint", "(I)V", "", "hint", "(Ljava/lang/String;)V", FirebaseAnalytics.Param.INDEX, "setSelection", "text", "insertInCursorPosition", "Lio/reactivex/rxjava3/core/Observable;", "textChangeCallbacks", "()Lio/reactivex/rxjava3/core/Observable;", "Lkotlin/Function1;", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnFocusChangeListener", "(Lkotlin/jvm/functions/Function1;)V", "requestFocus", "", "getText", "()Ljava/lang/CharSequence;", "setText", "(Ljava/lang/CharSequence;)V", "getTextLength", "()I", "setTextLength", "textLength", "getEnable", "()Z", "setEnable", "(Z)V", "enable", "getHasError", "setHasError", "hasError", "getHint", "getImeOptions", "setImeOptions", "imeOptions", "getInputType", "setInputType", "inputType", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public interface EditTextArea {
    boolean getEnable();

    boolean getHasError();

    @NotNull
    CharSequence getHint();

    int getImeOptions();

    int getInputType();

    @NotNull
    CharSequence getText();

    int getTextLength();

    void hide();

    void insertInCursorPosition(@NotNull String str);

    void requestFocus();

    void setEnable(boolean z);

    void setHasError(boolean z);

    void setHint(@StringRes int i);

    void setHint(@NotNull CharSequence charSequence);

    void setHint(@NotNull String str);

    void setImeOptions(int i);

    void setInputType(int i);

    void setOnFocusChangeListener(@NotNull Function1<? super Boolean, Unit> function1);

    void setSelection(int i);

    void setText(@NotNull CharSequence charSequence);

    void setTextLength(int i);

    void show();

    @NotNull
    Observable<String> textChangeCallbacks();
}
