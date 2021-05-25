package com.avito.android.util;

import a2.b.a.a.a;
import android.content.res.Resources;
import com.avito.android.item_temporary.R;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.category_parameters.DateTimeParameter;
import com.avito.android.remote.model.category_parameters.SelectionType;
import com.avito.android.str_calendar.calendar.view.data.CalendarDataConverterKt;
import java.text.SimpleDateFormat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/avito/android/util/DateTimeParameterFormatter;", "", "Lcom/avito/android/remote/model/category_parameters/DateTimeParameter;", "parameter", "", "format", "(Lcom/avito/android/remote/model/category_parameters/DateTimeParameter;)Ljava/lang/String;", "Landroid/content/res/Resources;", AuthSource.SEND_ABUSE, "Landroid/content/res/Resources;", "resources", "<init>", "(Landroid/content/res/Resources;)V", "item-temporary_release"}, k = 1, mv = {1, 4, 2})
public final class DateTimeParameterFormatter {
    public final Resources a;

    public DateTimeParameterFormatter(@NotNull Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        this.a = resources;
    }

    @Nullable
    public final String format(@NotNull DateTimeParameter dateTimeParameter) {
        Intrinsics.checkNotNullParameter(dateTimeParameter, "parameter");
        if (dateTimeParameter.isPresentTime()) {
            return this.a.getString(R.string.date_present_time);
        }
        Long timestamp = dateTimeParameter.getTimestamp();
        if (timestamp == null) {
            return null;
        }
        long longValue = timestamp.longValue();
        String str = "";
        SelectionType selectionType = dateTimeParameter.getSelectionType();
        if (selectionType != null) {
            if (!selectionType.hasMinute() || !selectionType.hasHour()) {
                if (selectionType.hasHour()) {
                    str = "HH";
                }
                if (selectionType.hasMinute()) {
                    if (str.length() > 0) {
                        str = a.e3(str, " ", "mm");
                    } else {
                        str = "mm";
                    }
                }
            } else {
                str = "HH:mm";
            }
            if (selectionType.hasDay()) {
                if (str.length() > 0) {
                    str = a.e3(str, " ", "d");
                } else {
                    str = "d";
                }
            }
            if (selectionType.hasMonth()) {
                if (str.length() > 0) {
                    str = a.e3(str, " ", "MMMM");
                } else {
                    str = "MMMM";
                }
            }
            if (selectionType.hasYear()) {
                String str2 = CalendarDataConverterKt.YEAR_PATTERN;
                if (str.length() > 0) {
                    str2 = a.e3(str, " ", str2);
                }
                str = str2;
            }
        }
        return new SimpleDateFormat(str, LocaleUtils.INSTANCE.getDATE_FORMAT_SYMBOLS()).format(Long.valueOf(longValue));
    }
}
