package com.avito.android.util.text;

import android.content.Context;
import com.avito.android.remote.model.text.AttributedText;
import com.avito.android.util.text_style.TextStyleData;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0007\u0010\u0006J#\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0005\u0010\nJ-\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0005\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/avito/android/util/text/AttributedTextFormatter;", "", "Lcom/avito/android/remote/model/text/AttributedText;", "attributedText", "", "format", "(Lcom/avito/android/remote/model/text/AttributedText;)Ljava/lang/CharSequence;", "formatIgnoreColors", "Landroid/content/Context;", "context", "(Landroid/content/Context;Lcom/avito/android/remote/model/text/AttributedText;)Ljava/lang/CharSequence;", "Lcom/avito/android/util/text_style/TextStyleData;", "textStyleData", "(Landroid/content/Context;Lcom/avito/android/util/text_style/TextStyleData;Lcom/avito/android/remote/model/text/AttributedText;)Ljava/lang/CharSequence;", "text-formatters_release"}, k = 1, mv = {1, 4, 2})
public interface AttributedTextFormatter {
    @Nullable
    CharSequence format(@NotNull Context context, @Nullable AttributedText attributedText);

    @Nullable
    CharSequence format(@NotNull Context context, @Nullable TextStyleData textStyleData, @Nullable AttributedText attributedText);

    @Deprecated(message = "Не умеет работать с новым форматом цветов из-за отсутствия Context-а, использовать на свой страх и риск", replaceWith = @ReplaceWith(expression = "format(attributedText, context)", imports = {}))
    @Nullable
    CharSequence format(@Nullable AttributedText attributedText);

    @Nullable
    CharSequence formatIgnoreColors(@Nullable AttributedText attributedText);
}
