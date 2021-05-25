package com.avito.android.delivery.summary.konveyor;

import android.content.res.Resources;
import com.avito.android.Features;
import com.avito.android.category_parameters.CategoryParametersElementConverter;
import com.avito.android.html_formatter.HtmlCleaner;
import com.avito.android.html_formatter.HtmlNodeFactory;
import com.avito.android.remote.model.category_parameters.EditCategoryParameter;
import com.avito.android.remote.model.category_parameters.base.CategoryParameter;
import com.avito.android.remote.model.category_parameters.base.EditableParameter;
import com.avito.android.server_time.TimeSource;
import com.avito.android.util.Formatter;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001BY\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\r\u001a\u00020\f\u0012\b\b\u0002\u0010\u000e\u001a\u00020\f\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003*\u00020\u0002H\u0014¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0019"}, d2 = {"Lcom/avito/android/delivery/summary/konveyor/DeliveryRdsSummaryParametersElementConverter;", "Lcom/avito/android/category_parameters/CategoryParametersElementConverter;", "Lcom/avito/android/remote/model/category_parameters/base/CategoryParameter;", "", "getError", "(Lcom/avito/android/remote/model/category_parameters/base/CategoryParameter;)Ljava/lang/String;", "Lcom/avito/android/util/Formatter;", "phoneFormatter", "Landroid/content/res/Resources;", "resources", "Lcom/avito/android/server_time/TimeSource;", "timeSource", "", "filterImmutable", "strDatesSearch", "Ljava/util/Locale;", "locale", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/html_formatter/HtmlCleaner;", "htmlCleaner", "Lcom/avito/android/html_formatter/HtmlNodeFactory;", "htmlNodeFactory", "<init>", "(Lcom/avito/android/util/Formatter;Landroid/content/res/Resources;Lcom/avito/android/server_time/TimeSource;ZZLjava/util/Locale;Lcom/avito/android/Features;Lcom/avito/android/html_formatter/HtmlCleaner;Lcom/avito/android/html_formatter/HtmlNodeFactory;)V", "delivery_release"}, k = 1, mv = {1, 4, 2})
public final class DeliveryRdsSummaryParametersElementConverter extends CategoryParametersElementConverter {
    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DeliveryRdsSummaryParametersElementConverter(Formatter formatter, Resources resources, TimeSource timeSource, boolean z, boolean z2, Locale locale, Features features, HtmlCleaner htmlCleaner, HtmlNodeFactory htmlNodeFactory, int i, j jVar) {
        this(formatter, resources, timeSource, (i & 8) != 0 ? false : z, (i & 16) != 0 ? false : z2, locale, features, htmlCleaner, htmlNodeFactory);
    }

    @Override // com.avito.android.category_parameters.CategoryParametersElementConverter
    @Nullable
    public String getError(@NotNull CategoryParameter categoryParameter) {
        Intrinsics.checkNotNullParameter(categoryParameter, "$this$getError");
        if (categoryParameter instanceof EditableParameter) {
            EditableParameter editableParameter = (EditableParameter) categoryParameter;
            if (editableParameter.hasError()) {
                return editableParameter.getError();
            }
        }
        if (categoryParameter instanceof EditCategoryParameter) {
            EditCategoryParameter editCategoryParameter = (EditCategoryParameter) categoryParameter;
            if (editCategoryParameter.hasError()) {
                return editCategoryParameter.getError();
            }
        }
        return null;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DeliveryRdsSummaryParametersElementConverter(@NotNull Formatter<String> formatter, @NotNull Resources resources, @NotNull TimeSource timeSource, boolean z, boolean z2, @NotNull Locale locale, @NotNull Features features, @NotNull HtmlCleaner htmlCleaner, @NotNull HtmlNodeFactory htmlNodeFactory) {
        super(formatter, resources, timeSource, z, z2, locale, false, false, false, false, htmlNodeFactory, htmlCleaner, features, 960, null);
        Intrinsics.checkNotNullParameter(formatter, "phoneFormatter");
        Intrinsics.checkNotNullParameter(resources, "resources");
        Intrinsics.checkNotNullParameter(timeSource, "timeSource");
        Intrinsics.checkNotNullParameter(locale, "locale");
        Intrinsics.checkNotNullParameter(features, "features");
        Intrinsics.checkNotNullParameter(htmlCleaner, "htmlCleaner");
        Intrinsics.checkNotNullParameter(htmlNodeFactory, "htmlNodeFactory");
    }
}
