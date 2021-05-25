package com.avito.android.component.unselectable_single_line;

import androidx.annotation.StringRes;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\t\u001a\u00020\u00042\b\b\u0001\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\t\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0004H&¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0004H&¢\u0006\u0004\b\u0010\u0010\u000f¨\u0006\u0011"}, d2 = {"Lcom/avito/android/component/unselectable_single_line/UnselectableSingleLine;", "", "", "value", "", "setValue", "(Ljava/lang/String;)V", "", "hint", "setHint", "(Ljava/lang/CharSequence;)V", "", "hintRes", "(I)V", "show", "()V", "hide", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public interface UnselectableSingleLine {
    void hide();

    void setHint(@StringRes int i);

    void setHint(@NotNull CharSequence charSequence);

    void setValue(@NotNull String str);

    void show();
}
