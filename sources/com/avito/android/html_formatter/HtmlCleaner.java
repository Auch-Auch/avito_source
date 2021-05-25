package com.avito.android.html_formatter;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/avito/android/html_formatter/HtmlCleaner;", "", "", "html", "cleanHtml", "(Ljava/lang/String;)Ljava/lang/String;", "html-formatter_release"}, k = 1, mv = {1, 4, 2})
public interface HtmlCleaner {
    @NotNull
    String cleanHtml(@NotNull String str);
}
