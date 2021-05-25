package ru.avito.component.text;

import androidx.annotation.StringRes;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\u0005\u0010\tJ\u000f\u0010\n\u001a\u00020\u0004H&¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0004H&¢\u0006\u0004\b\f\u0010\u000b¨\u0006\r"}, d2 = {"Lru/avito/component/text/Text;", "", "", "text", "", "setText", "(Ljava/lang/CharSequence;)V", "", "textId", "(I)V", "show", "()V", "hide", "deprecated-components_release"}, k = 1, mv = {1, 4, 2})
public interface Text {
    void hide();

    void setText(@StringRes int i);

    void setText(@Nullable CharSequence charSequence);

    void show();
}
