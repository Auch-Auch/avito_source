package com.avito.android.messenger.conversation.formatter;

import android.content.res.Resources;
import com.avito.android.messenger.R;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.server_time.TimeSource;
import com.avito.android.util.Formatter;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.messenger.api.entity.UserLastActivity;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B'\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u0006\u0010\u0018\u001a\u00020\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u0012\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0015\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0014R\u0016\u0010\u0018\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u001d"}, d2 = {"Lcom/avito/android/messenger/conversation/formatter/UserOnlineStatusFormatter;", "Lcom/avito/android/util/Formatter;", "Lru/avito/messenger/api/entity/UserLastActivity;", "value", "", "format", "(Lru/avito/messenger/api/entity/UserLastActivity;)Ljava/lang/String;", "", "lastActionTime", AuthSource.SEND_ABUSE, "(J)Ljava/lang/String;", "Landroid/content/res/Resources;", AuthSource.BOOKING_ORDER, "Landroid/content/res/Resources;", "resources", "Lcom/avito/android/server_time/TimeSource;", "d", "Lcom/avito/android/server_time/TimeSource;", "timeSource", "Ljava/text/SimpleDateFormat;", "Ljava/text/SimpleDateFormat;", "simpleDateFormatter", "c", "J", "onlineStatusTimeoutSeconds", "Ljava/util/Locale;", "locale", "<init>", "(Landroid/content/res/Resources;JLcom/avito/android/server_time/TimeSource;Ljava/util/Locale;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class UserOnlineStatusFormatter implements Formatter<UserLastActivity> {
    public final SimpleDateFormat a;
    public final Resources b;
    public final long c;
    public final TimeSource d;

    public UserOnlineStatusFormatter(@NotNull Resources resources, long j, @NotNull TimeSource timeSource, @NotNull Locale locale) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        Intrinsics.checkNotNullParameter(timeSource, "timeSource");
        Intrinsics.checkNotNullParameter(locale, "locale");
        this.b = resources;
        this.c = j;
        this.d = timeSource;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(resources.getString(R.string.messenger_online_status_last_activity_date_format), locale);
        this.a = simpleDateFormat;
        simpleDateFormat.setTimeZone(timeSource.getTimeZone());
    }

    public final String a(long j) {
        if (j <= 0) {
            return "";
        }
        String string = this.b.getString(R.string.messenger_online_status_last_activity_date, this.a.format(Long.valueOf(TimeUnit.SECONDS.toMillis(j))));
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(\n   …ctionTime))\n            )");
        return string;
    }

    @NotNull
    public String format(@Nullable UserLastActivity userLastActivity) {
        if (userLastActivity == null) {
            return "";
        }
        Long lastActionTime = userLastActivity.getLastActionTime();
        long convert = lastActionTime != null ? TimeUnit.SECONDS.convert(this.d.now(), TimeUnit.MILLISECONDS) - lastActionTime.longValue() : Long.MAX_VALUE;
        long j = 0;
        if (convert < 0) {
            Long lastActionTime2 = userLastActivity.getLastActionTime();
            if (lastActionTime2 != null) {
                j = lastActionTime2.longValue();
            }
            return a(j);
        } else if (convert <= this.c) {
            String string = this.b.getString(R.string.messenger_online_status_online);
            Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st…ger_online_status_online)");
            return string;
        } else if (convert < TimeUnit.MINUTES.toSeconds(60)) {
            String string2 = this.b.getString(R.string.messenger_online_status_minutes_ago, Long.valueOf(TimeUnit.SECONDS.toMinutes(convert)));
            Intrinsics.checkNotNullExpressionValue(string2, "resources.getString(\n   …ndsAgo)\n                )");
            return string2;
        } else if (convert < TimeUnit.HOURS.toSeconds(24)) {
            String string3 = this.b.getString(R.string.messenger_online_status_hours_ago, Long.valueOf(TimeUnit.SECONDS.toHours(convert)));
            Intrinsics.checkNotNullExpressionValue(string3, "resources.getString(R.st…ONDS.toHours(secondsAgo))");
            return string3;
        } else {
            TimeUnit timeUnit = TimeUnit.DAYS;
            if (convert < timeUnit.toSeconds(2)) {
                String string4 = this.b.getString(R.string.messenger_online_status_one_day_ago);
                Intrinsics.checkNotNullExpressionValue(string4, "resources.getString(R.st…nline_status_one_day_ago)");
                return string4;
            } else if (convert < timeUnit.toSeconds(5)) {
                String string5 = this.b.getString(R.string.messenger_online_status_few_days_ago, Long.valueOf(TimeUnit.SECONDS.toDays(convert)));
                Intrinsics.checkNotNullExpressionValue(string5, "resources.getString(R.st…CONDS.toDays(secondsAgo))");
                return string5;
            } else if (convert < timeUnit.toSeconds(8)) {
                String string6 = this.b.getString(R.string.messenger_online_status_many_days_ago, Long.valueOf(TimeUnit.SECONDS.toDays(convert)));
                Intrinsics.checkNotNullExpressionValue(string6, "resources.getString(R.st…CONDS.toDays(secondsAgo))");
                return string6;
            } else {
                Long lastActionTime3 = userLastActivity.getLastActionTime();
                if (lastActionTime3 != null) {
                    j = lastActionTime3.longValue();
                }
                return a(j);
            }
        }
    }
}
