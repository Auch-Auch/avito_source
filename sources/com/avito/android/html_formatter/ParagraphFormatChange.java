package com.avito.android.html_formatter;

import com.avito.android.html_formatter.FormatChange;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/avito/android/html_formatter/ParagraphFormatChange;", "Lcom/avito/android/html_formatter/FormatChange;", "", "value", "Lcom/avito/android/html_formatter/FormatChange$Type;", "type", "<init>", "(ILcom/avito/android/html_formatter/FormatChange$Type;)V", "html-formatter_release"}, k = 1, mv = {1, 4, 2})
public final class ParagraphFormatChange extends FormatChange {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ParagraphFormatChange(int i, @NotNull FormatChange.Type type) {
        super(i, type, null);
        Intrinsics.checkNotNullParameter(type, "type");
    }
}
