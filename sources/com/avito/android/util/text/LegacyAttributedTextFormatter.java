package com.avito.android.util.text;

import android.text.Editable;
import android.text.style.CharacterStyle;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.text.AttributedText;
import com.avito.android.util.TemplateFormatter;
import java.util.Objects;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Deprecated(message = "Consider using AttributedTextFormatter along with DI")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/avito/android/util/text/LegacyAttributedTextFormatter;", "", "Lcom/avito/android/remote/model/text/AttributedText;", "attributedText", "", "format", "(Lcom/avito/android/remote/model/text/AttributedText;)Ljava/lang/CharSequence;", "Lcom/avito/android/util/TemplateFormatter;", AuthSource.SEND_ABUSE, "Lcom/avito/android/util/TemplateFormatter;", "templateFormatter", "<init>", "()V", "text-formatters_release"}, k = 1, mv = {1, 4, 2})
public final class LegacyAttributedTextFormatter {
    public final TemplateFormatter a = new TemplateFormatter();

    public static final void access$setSpan(LegacyAttributedTextFormatter legacyAttributedTextFormatter, Editable editable, int i, String str, String str2, CharacterStyle characterStyle) {
        Objects.requireNonNull(legacyAttributedTextFormatter);
        editable.replace(i, str.length() + i, str2);
        editable.setSpan(characterStyle, i, str2.length() + i, 0);
    }

    @Nullable
    public final CharSequence format(@NotNull AttributedText attributedText) {
        Intrinsics.checkNotNullParameter(attributedText, "attributedText");
        CharSequence format = this.a.format(attributedText.getText(), new LegacyAttributedTextFormatter$format$charSequence$1(this, attributedText));
        if (StringsKt__StringsKt.contains$default(format, (CharSequence) "{{", false, 2, (Object) null) || StringsKt__StringsKt.contains$default(format, (CharSequence) "}}", false, 2, (Object) null)) {
            return null;
        }
        return format;
    }
}
