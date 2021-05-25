package com.avito.android.short_term_rent.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0011\u0010\u0004\u001a\u00020\u0000*\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0011\u0010\u0006\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0006\u0010\u0003\u001a\u0011\u0010\u0007\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0007\u0010\u0003¨\u0006\b"}, d2 = {"Ljava/util/Date;", "", "convertToStrDate", "(Ljava/util/Date;)Ljava/lang/String;", "convertStrDateToDate", "(Ljava/lang/String;)Ljava/util/Date;", "convertStrDateToDMMMM", "convertStrDateToDMMM", "short-term-rent_release"}, k = 2, mv = {1, 4, 2})
public final class StrDateUtilsKt {
    @NotNull
    public static final String convertStrDateToDMMM(@NotNull Date date) {
        Intrinsics.checkNotNullParameter(date, "$this$convertStrDateToDMMM");
        String format = new SimpleDateFormat("d MMM", Locale.getDefault()).format(date);
        Intrinsics.checkNotNullExpressionValue(format, "formatter.format(this)");
        return format;
    }

    @NotNull
    public static final String convertStrDateToDMMMM(@NotNull Date date) {
        Intrinsics.checkNotNullParameter(date, "$this$convertStrDateToDMMMM");
        String format = new SimpleDateFormat("d MMMM", Locale.getDefault()).format(date);
        Intrinsics.checkNotNullExpressionValue(format, "formatter.format(this)");
        return format;
    }

    @NotNull
    public static final Date convertStrDateToDate(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "$this$convertStrDateToDate");
        Date parse = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).parse(str);
        Intrinsics.checkNotNullExpressionValue(parse, "formatter.parse(this)");
        return parse;
    }

    @NotNull
    public static final String convertToStrDate(@NotNull Date date) {
        Intrinsics.checkNotNullParameter(date, "$this$convertToStrDate");
        String format = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(date);
        Intrinsics.checkNotNullExpressionValue(format, "formatter.format(this)");
        return format;
    }
}
