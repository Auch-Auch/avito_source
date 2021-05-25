package com.avito.android.html_formatter;

import com.avito.android.html_formatter.MutableHtmlNode;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J)\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0002H&¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/html_formatter/SupportsFormatHtmlNode;", "", "", "from", "to", "Lcom/avito/android/html_formatter/FormatChange;", "format", "Lcom/avito/android/html_formatter/MutableHtmlNode$OperationResult;", "applyFormat", "(IILcom/avito/android/html_formatter/FormatChange;)Lcom/avito/android/html_formatter/MutableHtmlNode$OperationResult;", "getFormat", "()I", "html-formatter_release"}, k = 1, mv = {1, 4, 2})
public interface SupportsFormatHtmlNode {
    @Nullable
    MutableHtmlNode.OperationResult applyFormat(int i, int i2, @NotNull FormatChange formatChange);

    int getFormat();
}
