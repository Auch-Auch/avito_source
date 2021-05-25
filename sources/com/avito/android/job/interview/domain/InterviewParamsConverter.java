package com.avito.android.job.interview.domain;

import com.avito.android.job.interview.Location;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.category_parameters.FormattedDateDisplayingType;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.analytic.v2.AnalyticFieldsName;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\t\b\u0007¢\u0006\u0004\b\u0011\u0010\u0012J!\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u001e\u0010\u0010\u001a\n \r*\u0004\u0018\u00010\f0\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0014"}, d2 = {"Lcom/avito/android/job/interview/domain/InterviewParamsConverter;", "", "Lcom/avito/android/job/interview/domain/InvitationDraft;", AnalyticFieldsName.draft, "", "", "convert", "(Lcom/avito/android/job/interview/domain/InvitationDraft;)Ljava/util/Map;", "Ljava/text/SimpleDateFormat;", AuthSource.BOOKING_ORDER, "Ljava/text/SimpleDateFormat;", "sdf", "Ljava/util/Calendar;", "kotlin.jvm.PlatformType", AuthSource.SEND_ABUSE, "Ljava/util/Calendar;", FormattedDateDisplayingType.TYPE_CALENDAR, "<init>", "()V", "Companion", "interview_release"}, k = 1, mv = {1, 4, 2})
public final class InterviewParamsConverter {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final String DATE_PATTERN = "yyyy-MM-dd'T'HH:mm:ss'Z'";
    public final Calendar a = Calendar.getInstance();
    public final SimpleDateFormat b = new SimpleDateFormat(DATE_PATTERN, Locale.ENGLISH);

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/avito/android/job/interview/domain/InterviewParamsConverter$Companion;", "", "", "DATE_PATTERN", "Ljava/lang/String;", "<init>", "()V", "interview_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    @NotNull
    public final Map<String, String> convert(@NotNull InvitationDraft invitationDraft) {
        Intrinsics.checkNotNullParameter(invitationDraft, AnalyticFieldsName.draft);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int i = 0;
        for (T t : invitationDraft.getDates()) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            T t2 = t;
            this.a.set(2, t2.getMonth());
            this.a.set(5, t2.getDay());
            String fromTime = t2.getFromTime();
            Intrinsics.checkNotNull(fromTime);
            List split$default = StringsKt__StringsKt.split$default((CharSequence) fromTime, new String[]{":"}, false, 0, 6, (Object) null);
            this.a.set(11, Integer.parseInt((String) split$default.get(0)));
            this.a.set(12, Integer.parseInt((String) split$default.get(1)));
            SimpleDateFormat simpleDateFormat = this.b;
            Calendar calendar = this.a;
            Intrinsics.checkNotNullExpressionValue(calendar, FormattedDateDisplayingType.TYPE_CALENDAR);
            String format = simpleDateFormat.format(calendar.getTime());
            Intrinsics.checkNotNullExpressionValue(format, "sdf.format(calendar.time)");
            linkedHashMap.put("dates[" + i + "][from]", format);
            if (t2.getToTime() != null) {
                List split$default2 = StringsKt__StringsKt.split$default((CharSequence) t2.getToTime(), new String[]{":"}, false, 0, 6, (Object) null);
                this.a.set(11, Integer.parseInt((String) split$default2.get(0)));
                this.a.set(12, Integer.parseInt((String) split$default2.get(1)));
                SimpleDateFormat simpleDateFormat2 = this.b;
                Calendar calendar2 = this.a;
                Intrinsics.checkNotNullExpressionValue(calendar2, FormattedDateDisplayingType.TYPE_CALENDAR);
                String format2 = simpleDateFormat2.format(calendar2.getTime());
                Intrinsics.checkNotNullExpressionValue(format2, "sdf.format(calendar.time)");
                linkedHashMap.put("dates[" + i + "][to]", format2);
            }
            i = i2;
        }
        Location location = invitationDraft.getLocation();
        Intrinsics.checkNotNull(location);
        linkedHashMap.put("location[lat]", String.valueOf(location.getLat()));
        linkedHashMap.put("location[lng]", String.valueOf(location.getLng()));
        linkedHashMap.put("location[text]", location.getText());
        if (invitationDraft.getPhone() != null) {
            linkedHashMap.put("phone", invitationDraft.getPhone());
        }
        if (invitationDraft.getMessage() != null) {
            linkedHashMap.put("message", String.valueOf(invitationDraft.getMessage()));
        }
        return linkedHashMap;
    }
}
