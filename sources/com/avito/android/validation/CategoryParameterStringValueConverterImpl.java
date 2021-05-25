package com.avito.android.validation;

import android.content.res.Resources;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.category_parameters.base.EditableParameter;
import com.avito.android.util.Formatter;
import java.text.NumberFormat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0014\u001a\u00020\u0012\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u000e\u0012\u0006\u0010\r\u001a\u00020\n¢\u0006\u0004\b\u0015\u0010\u0016J\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\b\u001a\u0004\u0018\u00010\u0004*\u0006\u0012\u0002\b\u00030\u0007H\u0002¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u001c\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0014\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/avito/android/validation/CategoryParameterStringValueConverterImpl;", "Lcom/avito/android/validation/CategoryParameterStringValueConverter;", "Lcom/avito/android/remote/model/category_parameters/base/CategoryParameter;", "parameter", "", "getValue", "(Lcom/avito/android/remote/model/category_parameters/base/CategoryParameter;)Ljava/lang/String;", "Lcom/avito/android/remote/model/category_parameters/base/EditableParameter;", AuthSource.SEND_ABUSE, "(Lcom/avito/android/remote/model/category_parameters/base/EditableParameter;)Ljava/lang/String;", "Landroid/content/res/Resources;", "c", "Landroid/content/res/Resources;", "resources", "Lcom/avito/android/util/Formatter;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/Formatter;", "phoneFormatter", "Ljava/text/NumberFormat;", "Ljava/text/NumberFormat;", "decimalFormat", "<init>", "(Ljava/text/NumberFormat;Lcom/avito/android/util/Formatter;Landroid/content/res/Resources;)V", "item-temporary_release"}, k = 1, mv = {1, 4, 2})
public final class CategoryParameterStringValueConverterImpl implements CategoryParameterStringValueConverter {
    public final NumberFormat a;
    public final Formatter<String> b;
    public final Resources c;

    public CategoryParameterStringValueConverterImpl(@NotNull NumberFormat numberFormat, @NotNull Formatter<String> formatter, @NotNull Resources resources) {
        Intrinsics.checkNotNullParameter(numberFormat, "decimalFormat");
        Intrinsics.checkNotNullParameter(formatter, "phoneFormatter");
        Intrinsics.checkNotNullParameter(resources, "resources");
        this.a = numberFormat;
        this.b = formatter;
        this.c = resources;
    }

    public final String a(EditableParameter<?> editableParameter) {
        Object value;
        if (!editableParameter.hasValue() || (value = editableParameter.getValue()) == null) {
            return null;
        }
        return value.toString();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00ba, code lost:
        if (r3 == false) goto L_0x00bc;
     */
    @Override // com.avito.android.validation.CategoryParameterStringValueConverter
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String getValue(@org.jetbrains.annotations.NotNull com.avito.android.remote.model.category_parameters.base.CategoryParameter r15) {
        /*
        // Method dump skipped, instructions count: 488
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.validation.CategoryParameterStringValueConverterImpl.getValue(com.avito.android.remote.model.category_parameters.base.CategoryParameter):java.lang.String");
    }
}
