package com.avito.android.blueprints.publish.html_editor;

import android.text.TextWatcher;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ`\u0010\u0012\u001a\u00020\u00042O\u0010\u0011\u001aK\u0012\u0015\u0012\u0013\u0018\u00010\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u0004\u0018\u00010\tH&¢\u0006\u0004\b\u0012\u0010\u0013J%\u0010\u0016\u001a\u00020\u00042\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0014H&¢\u0006\u0004\b\u0016\u0010\u0017J\u0011\u0010\u0018\u001a\u0004\u0018\u00010\nH&¢\u0006\u0004\b\u0018\u0010\u0019J\u0019\u0010\u001b\u001a\u00020\u00042\b\u0010\u001a\u001a\u0004\u0018\u00010\nH&¢\u0006\u0004\b\u001b\u0010\u001cJ%\u0010\u001e\u001a\u00020\u00042\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0014H&¢\u0006\u0004\b\u001e\u0010\u0017J\u001f\u0010 \u001a\u00020\u00042\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u001fH&¢\u0006\u0004\b \u0010!R$\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u001f8&@&X¦\u000e¢\u0006\f\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010!R$\u0010(\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u001f8&@&X¦\u000e¢\u0006\f\u001a\u0004\b&\u0010#\"\u0004\b'\u0010!¨\u0006)"}, d2 = {"Lcom/avito/android/blueprints/publish/html_editor/HtmlEditorItemView;", "", "Landroid/text/TextWatcher;", "textWatcher", "", "setTextWatcher", "(Landroid/text/TextWatcher;)V", "removeTextWatcher", "()V", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "text", "", "selStart", "selEnd", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnSelectionChangedListener", "(Lkotlin/jvm/functions/Function3;)V", "Lkotlin/Function1;", "", "setFocusChangeListener", "(Lkotlin/jvm/functions/Function1;)V", "getText", "()Ljava/lang/CharSequence;", "value", "setValue", "(Ljava/lang/CharSequence;)V", "", "setOnValueChangeListener", "Lkotlin/Function0;", "setOnViewTouchedListener", "(Lkotlin/jvm/functions/Function0;)V", "getDetachListener", "()Lkotlin/jvm/functions/Function0;", "setDetachListener", "detachListener", "getAttachListener", "setAttachListener", "attachListener", "item-temporary_release"}, k = 1, mv = {1, 4, 2})
public interface HtmlEditorItemView {
    @Nullable
    Function0<Unit> getAttachListener();

    @Nullable
    Function0<Unit> getDetachListener();

    @Nullable
    CharSequence getText();

    void removeTextWatcher();

    void setAttachListener(@Nullable Function0<Unit> function0);

    void setDetachListener(@Nullable Function0<Unit> function0);

    void setFocusChangeListener(@Nullable Function1<? super Boolean, Unit> function1);

    void setOnSelectionChangedListener(@Nullable Function3<? super CharSequence, ? super Integer, ? super Integer, Unit> function3);

    void setOnValueChangeListener(@Nullable Function1<? super String, Unit> function1);

    void setOnViewTouchedListener(@Nullable Function0<Unit> function0);

    void setTextWatcher(@NotNull TextWatcher textWatcher);

    void setValue(@Nullable CharSequence charSequence);
}
