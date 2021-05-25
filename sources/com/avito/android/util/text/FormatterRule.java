package com.avito.android.util.text;

import android.content.Context;
import android.text.Editable;
import com.avito.android.remote.model.text.Attribute;
import com.avito.android.remote.model.text.AttributedText;
import com.avito.android.util.text_style.TextStyleData;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001JS\u0010\u0013\u001a\u00020\u00122\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H&¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/avito/android/util/text/FormatterRule;", "", "Landroid/content/Context;", "context", "Lcom/avito/android/util/text_style/TextStyleData;", "textStyleData", "", "ignoreColors", "Landroid/text/Editable;", "editable", "", FirebaseAnalytics.Param.INDEX, "", "key", "Lcom/avito/android/remote/model/text/Attribute;", "attribute", "Lcom/avito/android/remote/model/text/AttributedText;", "attributedText", "", "apply", "(Landroid/content/Context;Lcom/avito/android/util/text_style/TextStyleData;ZLandroid/text/Editable;ILjava/lang/String;Lcom/avito/android/remote/model/text/Attribute;Lcom/avito/android/remote/model/text/AttributedText;)V", "text-formatters_release"}, k = 1, mv = {1, 4, 2})
public interface FormatterRule {
    void apply(@Nullable Context context, @Nullable TextStyleData textStyleData, boolean z, @NotNull Editable editable, int i, @NotNull String str, @NotNull Attribute attribute, @NotNull AttributedText attributedText);
}
