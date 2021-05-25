package com.avito.android.date_time_formatter;

import android.content.res.Resources;
import com.avito.android.remote.auth.AuthSource;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u000e¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\b\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\u0007J\u001f\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\r\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\u000bR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/avito/android/date_time_formatter/DateTimeFormatterResourceProviderImpl;", "Lcom/avito/android/date_time_formatter/DateTimeFormatterResourceProvider;", "", "time", "", "case", "todayAtTime", "(Ljava/lang/String;I)Ljava/lang/String;", "yesterdayAtTime", "day", "dateAtTime", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "year", "dateAtYear", "Landroid/content/res/Resources;", AuthSource.SEND_ABUSE, "Landroid/content/res/Resources;", "resources", "<init>", "(Landroid/content/res/Resources;)V", "date-time-formatter_release"}, k = 1, mv = {1, 4, 2})
public final class DateTimeFormatterResourceProviderImpl implements DateTimeFormatterResourceProvider {
    public final Resources a;

    @Inject
    public DateTimeFormatterResourceProviderImpl(@NotNull Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        this.a = resources;
    }

    @Override // com.avito.android.date_time_formatter.DateTimeFormatterResourceProvider
    @NotNull
    public String dateAtTime(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "day");
        Intrinsics.checkNotNullParameter(str2, "time");
        String string = this.a.getString(R.string.date_at_time, str, str2);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st….date_at_time, day, time)");
        return string;
    }

    @Override // com.avito.android.date_time_formatter.DateTimeFormatterResourceProvider
    @NotNull
    public String dateAtYear(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "day");
        Intrinsics.checkNotNullParameter(str2, "year");
        String string = this.a.getString(R.string.date_at_year, str, str2);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st….date_at_year, day, year)");
        return string;
    }

    @Override // com.avito.android.date_time_formatter.DateTimeFormatterResourceProvider
    @NotNull
    public String todayAtTime(@NotNull String str, int i) {
        Intrinsics.checkNotNullParameter(str, "time");
        if (i == 1) {
            String string = this.a.getString(R.string.today_at_time_cap, str);
            Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st….today_at_time_cap, time)");
            return string;
        }
        String string2 = this.a.getString(R.string.today_at_time, str);
        Intrinsics.checkNotNullExpressionValue(string2, "resources.getString(R.string.today_at_time, time)");
        return string2;
    }

    @Override // com.avito.android.date_time_formatter.DateTimeFormatterResourceProvider
    @NotNull
    public String yesterdayAtTime(@NotNull String str, int i) {
        Intrinsics.checkNotNullParameter(str, "time");
        if (i == 1) {
            String string = this.a.getString(R.string.yesterday_at_time_cap, str);
            Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st…terday_at_time_cap, time)");
            return string;
        }
        String string2 = this.a.getString(R.string.yesterday_at_time, str);
        Intrinsics.checkNotNullExpressionValue(string2, "resources.getString(R.st….yesterday_at_time, time)");
        return string2;
    }
}
