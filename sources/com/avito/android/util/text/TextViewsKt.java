package com.avito.android.util.text;

import a2.b.a.a.a;
import android.content.Context;
import android.widget.TextView;
import com.avito.android.remote.model.text.AttributedText;
import com.avito.android.remote.model.text.FontAttribute;
import com.avito.android.remote.model.text.FontParameter;
import com.avito.android.util.TextViews;
import com.avito.android.util.text_style.TextStyleData;
import com.avito.android.util.text_style.TextStyleDataProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.d;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\u001a#\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007\u001a%\u0010\b\u001a\u00020\u0005*\u00020\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\u0007\u001a\u001f\u0010\f\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\t¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Landroid/widget/TextView;", "Lcom/avito/android/remote/model/text/AttributedText;", "attributedText", "Lcom/avito/android/util/text/AttributedTextFormatter;", "attributedTextFormatter", "", "setAttributedText", "(Landroid/widget/TextView;Lcom/avito/android/remote/model/text/AttributedText;Lcom/avito/android/util/text/AttributedTextFormatter;)V", "bindAttributedText", "", "text", "attributeNamePlaceholder", "withParagraphing", "(Ljava/lang/String;Ljava/lang/String;)Lcom/avito/android/remote/model/text/AttributedText;", "text-formatters_release"}, k = 2, mv = {1, 4, 2})
public final class TextViewsKt {
    public static final void bindAttributedText(@NotNull TextView textView, @Nullable AttributedText attributedText, @NotNull AttributedTextFormatter attributedTextFormatter) {
        Intrinsics.checkNotNullParameter(textView, "$this$bindAttributedText");
        Intrinsics.checkNotNullParameter(attributedTextFormatter, "attributedTextFormatter");
        TextStyleDataProvider textStyleDataProvider = (TextStyleDataProvider) (!(textView instanceof TextStyleDataProvider) ? null : textView);
        TextStyleData textStyleData = textStyleDataProvider != null ? textStyleDataProvider.getTextStyleData() : null;
        Context context = textView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        TextViews.bindText$default(textView, attributedTextFormatter.format(context, textStyleData, attributedText), false, 2, null);
    }

    public static /* synthetic */ void bindAttributedText$default(TextView textView, AttributedText attributedText, AttributedTextFormatter attributedTextFormatter, int i, Object obj) {
        if ((i & 2) != 0) {
            attributedTextFormatter = new AttributedTextFormatterImpl();
        }
        bindAttributedText(textView, attributedText, attributedTextFormatter);
    }

    public static final void setAttributedText(@NotNull TextView textView, @NotNull AttributedText attributedText, @NotNull AttributedTextFormatter attributedTextFormatter) {
        Intrinsics.checkNotNullParameter(textView, "$this$setAttributedText");
        Intrinsics.checkNotNullParameter(attributedText, "attributedText");
        Intrinsics.checkNotNullParameter(attributedTextFormatter, "attributedTextFormatter");
        TextStyleData textStyleData = null;
        TextStyleDataProvider textStyleDataProvider = (TextStyleDataProvider) (!(textView instanceof TextStyleDataProvider) ? null : textView);
        if (textStyleDataProvider != null) {
            textStyleData = textStyleDataProvider.getTextStyleData();
        }
        Context context = textView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        CharSequence format = attributedTextFormatter.format(context, textStyleData, attributedText);
        if (format == null) {
            format = "";
        }
        textView.setText(format);
    }

    public static /* synthetic */ void setAttributedText$default(TextView textView, AttributedText attributedText, AttributedTextFormatter attributedTextFormatter, int i, Object obj) {
        if ((i & 2) != 0) {
            attributedTextFormatter = new AttributedTextFormatterImpl();
        }
        setAttributedText(textView, attributedText, attributedTextFormatter);
    }

    @NotNull
    public static final AttributedText withParagraphing(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "text");
        Intrinsics.checkNotNullParameter(str2, "attributeNamePlaceholder");
        return new AttributedText(a.e3("{{", str2, "}}"), d.listOf(new FontAttribute(str2, str, d.listOf(new FontParameter.UseParagraphingParameter()))));
    }

    public static /* synthetic */ AttributedText withParagraphing$default(String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = "title";
        }
        return withParagraphing(str, str2);
    }
}
