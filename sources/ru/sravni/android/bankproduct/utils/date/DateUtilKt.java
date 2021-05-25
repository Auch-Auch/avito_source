package ru.sravni.android.bankproduct.utils.date;

import com.avito.android.remote.model.Sort;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\u001a\r\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0001\u0010\u0002\u001a\u0011\u0010\u0005\u001a\u00020\u0004*\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u001f\u0010\t\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\t\u0010\n\u001a\u0017\u0010\u000b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\b\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\f\u001a\u001d\u0010\r\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0000¢\u0006\u0004\b\r\u0010\u000e\u001a\u0015\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\u0010\u0010\u0011\u001a%\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0015\u0010\u0016\"\u0016\u0010\u0017\u001a\u00020\u00048\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018\"\u0016\u0010\u0019\u001a\u00020\u00048\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0019\u0010\u0018\"\u0016\u0010\u001a\u001a\u00020\u00048\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u001a\u0010\u0018\"\u0016\u0010\u001b\u001a\u00020\u00048\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u001b\u0010\u0018¨\u0006\u001c"}, d2 = {"", "getOneDayToMillis", "()J", "Ljava/util/Date;", "", "toChatCreatedTime", "(Ljava/util/Date;)Ljava/lang/String;", "format", Sort.DATE, "getParseDate", "(Ljava/lang/String;Ljava/lang/String;)Ljava/util/Date;", "getParseDateWithTimeZone", "(Ljava/lang/String;)Ljava/util/Date;", "getFormatDate", "(Ljava/lang/String;J)Ljava/lang/String;", "Ljava/util/Calendar;", "setDateToCalendar", "(Ljava/util/Date;)Ljava/util/Calendar;", "", "numberDays", "", "isInvalidDate", "(Ljava/lang/String;Ljava/lang/String;I)Z", "serverFormatUTC", "Ljava/lang/String;", "viewFormat", "serverFormatWithTimeZone", "serverFormat", "sravnichat_release"}, k = 2, mv = {1, 4, 0})
public final class DateUtilKt {
    @NotNull
    public static final String serverFormat = "dd.MM.yyyy";
    @NotNull
    public static final String serverFormatUTC = "yyyy-MM-dd'T'HH:mm:ss.SSSz";
    @NotNull
    public static final String serverFormatWithTimeZone = "EEE MMM dd yyyy HH:mm:ss z";
    @NotNull
    public static final String viewFormat = "dd MMMM yyyy";

    @NotNull
    public static final String getFormatDate(@NotNull String str, long j) {
        Intrinsics.checkParameterIsNotNull(str, "format");
        String format = new SimpleDateFormat(str, new Locale("Ru")).format(Long.valueOf(j));
        Intrinsics.checkExpressionValueIsNotNull(format, "output.format(date)");
        return format;
    }

    public static final long getOneDayToMillis() {
        return TimeUnit.DAYS.toMillis(1);
    }

    @NotNull
    public static final Date getParseDate(@NotNull String str, @Nullable String str2) {
        Intrinsics.checkParameterIsNotNull(str, "format");
        Date parse = new SimpleDateFormat(str, new Locale("Ru")).parse(str2);
        Intrinsics.checkExpressionValueIsNotNull(parse, "input.parse(date)");
        return parse;
    }

    @Nullable
    public static final Date getParseDateWithTimeZone(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, Sort.DATE);
        return new SimpleDateFormat(serverFormatWithTimeZone, Locale.ENGLISH).parse(str);
    }

    public static final boolean isInvalidDate(@NotNull String str, @NotNull String str2, int i) {
        Intrinsics.checkParameterIsNotNull(str, "format");
        Intrinsics.checkParameterIsNotNull(str2, Sort.DATE);
        try {
            Date parseDate = getParseDate(str, str2);
            Calendar instance = Calendar.getInstance();
            long time = parseDate.getTime();
            Intrinsics.checkExpressionValueIsNotNull(instance, "currentDate");
            if ((time - instance.getTimeInMillis()) / ((long) 86400000) < ((long) i)) {
                return true;
            }
            return false;
        } catch (ParseException unused) {
            return true;
        }
    }

    @NotNull
    public static final Calendar setDateToCalendar(@NotNull Date date) {
        Intrinsics.checkParameterIsNotNull(date, Sort.DATE);
        Calendar instance = Calendar.getInstance();
        Intrinsics.checkExpressionValueIsNotNull(instance, "currentDate");
        instance.setTime(date);
        return instance;
    }

    @NotNull
    public static final String toChatCreatedTime(@NotNull Date date) {
        Intrinsics.checkParameterIsNotNull(date, "$this$toChatCreatedTime");
        String format = new SimpleDateFormat("HH:mm", Locale.getDefault()).format(date);
        Intrinsics.checkExpressionValueIsNotNull(format, "formatter.format(this)");
        return format;
    }
}
