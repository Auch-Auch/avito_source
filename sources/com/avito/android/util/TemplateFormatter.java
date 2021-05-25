package com.avito.android.util;

import android.text.Editable;
import com.yandex.mobile.ads.video.tracking.Tracker;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u000bB\u0007¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/avito/android/util/TemplateFormatter;", "", "", "input", "Lcom/avito/android/util/TemplateFormatter$Visitor;", "visitor", "", "format", "(Ljava/lang/String;Lcom/avito/android/util/TemplateFormatter$Visitor;)Ljava/lang/CharSequence;", "<init>", "()V", "Visitor", "text-formatters_release"}, k = 1, mv = {1, 4, 2})
public final class TemplateFormatter {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J/\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H&¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/util/TemplateFormatter$Visitor;", "", "Landroid/text/Editable;", "editable", "", "template", "", Tracker.Events.CREATIVE_START, "end", "", "visit", "(Landroid/text/Editable;Ljava/lang/String;II)V", "text-formatters_release"}, k = 1, mv = {1, 4, 2})
    public interface Visitor {
        void visit(@NotNull Editable editable, @NotNull String str, int i, int i2);
    }

    @NotNull
    public final CharSequence format(@NotNull String str, @NotNull Visitor visitor) {
        Intrinsics.checkNotNullParameter(str, "input");
        Intrinsics.checkNotNullParameter(visitor, "visitor");
        Editable newEditable = Editable.Factory.getInstance().newEditable(str);
        Intrinsics.checkNotNullExpressionValue(newEditable, "editable");
        int i = 0;
        if (newEditable.length() == 0) {
            return newEditable;
        }
        char c = 55296;
        char charAt = newEditable.charAt(0);
        int i2 = -1;
        while (i < newEditable.length()) {
            if (c == '{' && charAt == '{') {
                i2 = i - 1;
            } else if (c == '}' && charAt == '}' && i2 != -1) {
                int length = newEditable.length();
                visitor.visit(newEditable, newEditable.subSequence(i2 + 2, i - 1).toString(), i2, i + 1);
                i += newEditable.length() - length;
                i2 = -1;
            }
            i++;
            charAt = i < newEditable.length() ? newEditable.charAt(i) : charAt;
            c = charAt;
        }
        return newEditable;
    }
}
