package com.avito.android.util;

import android.text.TextWatcher;
import android.text.method.KeyListener;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/avito/android/util/FormattableInputView;", "", "Landroid/text/TextWatcher;", "textWatcher", "", "setTextWatcher", "(Landroid/text/TextWatcher;)V", "removeTextWatcher", "()V", "Landroid/text/method/KeyListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setKeyListener", "(Landroid/text/method/KeyListener;)V", "item-temporary_release"}, k = 1, mv = {1, 4, 2})
public interface FormattableInputView {
    @Override // com.avito.android.blueprints.publish.html_editor.HtmlEditorItemView
    void removeTextWatcher();

    void setKeyListener(@NotNull KeyListener keyListener);

    @Override // com.avito.android.blueprints.publish.html_editor.HtmlEditorItemView
    void setTextWatcher(@NotNull TextWatcher textWatcher);
}
