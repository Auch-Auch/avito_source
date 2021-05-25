package com.avito.android.job.interview.domain;

import a2.g.r.g;
import com.avito.android.job.JobApi;
import com.avito.android.job.interview.JobInterviewInvitationResponse;
import com.avito.android.job.interview.Range;
import com.avito.android.job.interview.domain.Result;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.remote.model.category_parameters.FormattedDateDisplayingType;
import io.reactivex.rxjava3.core.Observable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.analytic.v2.AnalyticFieldsName;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u001b\u001a\u00020\u0018\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\u0006\u0010\u000f\u001a\u00020\f¢\u0006\u0004\b$\u0010%J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005J!\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00022\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001d\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u0016R\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010#\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010\u0016¨\u0006&"}, d2 = {"Lcom/avito/android/job/interview/domain/InterviewInvitationInteractor;", "", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/job/interview/domain/Result;", "loadInterviewInvitation", "()Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/job/interview/domain/InvitationDraft;", AnalyticFieldsName.draft, "Lcom/avito/android/remote/model/TypedResult;", "", "invite", "(Lcom/avito/android/job/interview/domain/InvitationDraft;)Lio/reactivex/rxjava3/core/Observable;", "", g.a, "Ljava/lang/String;", "jobApplyId", "Lcom/avito/android/job/JobApi;", "f", "Lcom/avito/android/job/JobApi;", "jobInterviewInvitationApi", "Ljava/text/SimpleDateFormat;", "c", "Ljava/text/SimpleDateFormat;", "dateFormat", "Lcom/avito/android/job/interview/domain/InterviewParamsConverter;", "e", "Lcom/avito/android/job/interview/domain/InterviewParamsConverter;", "interviewParamsConverter", "d", "timeFormat", "Ljava/util/Locale;", AuthSource.SEND_ABUSE, "Ljava/util/Locale;", "locale", AuthSource.BOOKING_ORDER, "responseDateFormat", "<init>", "(Lcom/avito/android/job/interview/domain/InterviewParamsConverter;Lcom/avito/android/job/JobApi;Ljava/lang/String;)V", "interview_release"}, k = 1, mv = {1, 4, 2})
public final class InterviewInvitationInteractor {
    public final Locale a;
    public final SimpleDateFormat b;
    public final SimpleDateFormat c;
    public final SimpleDateFormat d;
    public final InterviewParamsConverter e;
    public final JobApi f;
    public final String g;

    @Inject
    public InterviewInvitationInteractor(@NotNull InterviewParamsConverter interviewParamsConverter, @NotNull JobApi jobApi, @NotNull String str) {
        Intrinsics.checkNotNullParameter(interviewParamsConverter, "interviewParamsConverter");
        Intrinsics.checkNotNullParameter(jobApi, "jobInterviewInvitationApi");
        Intrinsics.checkNotNullParameter(str, "jobApplyId");
        this.e = interviewParamsConverter;
        this.f = jobApi;
        this.g = str;
        Locale locale = new Locale("ru");
        this.a = locale;
        this.b = new SimpleDateFormat(InterviewParamsConverter.DATE_PATTERN, locale);
        this.c = new SimpleDateFormat("d MMMM yyyy", locale);
        this.d = new SimpleDateFormat("HH:mm", locale);
    }

    public static final Result access$mapToResult(InterviewInvitationInteractor interviewInvitationInteractor, TypedResult typedResult) {
        InvitationDraft invitationDraft;
        String str;
        Date parse;
        Objects.requireNonNull(interviewInvitationInteractor);
        if (typedResult instanceof TypedResult.OfError) {
            return Result.Failure.INSTANCE;
        }
        if (typedResult instanceof TypedResult.OfResult) {
            JobInterviewInvitationResponse jobInterviewInvitationResponse = (JobInterviewInvitationResponse) ((TypedResult.OfResult) typedResult).getResult();
            Calendar instance = Calendar.getInstance();
            int i = 5;
            if (jobInterviewInvitationResponse != null) {
                List<Range> dates = jobInterviewInvitationResponse.getDates();
                Calendar instance2 = Calendar.getInstance();
                ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(dates, 10));
                for (T t : dates) {
                    Date parse2 = interviewInvitationInteractor.b.parse(t.getFrom());
                    Intrinsics.checkNotNull(parse2);
                    Intrinsics.checkNotNullExpressionValue(instance2, FormattedDateDisplayingType.TYPE_CALENDAR);
                    instance2.setTime(parse2);
                    String format = interviewInvitationInteractor.d.format(parse2);
                    String to = t.getTo();
                    String format2 = (to == null || (parse = interviewInvitationInteractor.b.parse(to)) == null) ? null : interviewInvitationInteractor.d.format(parse);
                    String format3 = interviewInvitationInteractor.c.format(instance2.getTime());
                    Intrinsics.checkNotNullExpressionValue(format3, "dateFormat.format(calendar.time)");
                    int i2 = instance2.get(2);
                    int i3 = instance2.get(i);
                    if (format2 == null) {
                        str = format;
                    } else {
                        str = a2.b.a.a.a.L2(format, '-', format2);
                    }
                    arrayList.add(new DateEntry(format3, i2, i3, str, format, format2));
                    i = 5;
                }
                invitationDraft = new InvitationDraft(arrayList, jobInterviewInvitationResponse.getLocation(), jobInterviewInvitationResponse.getPhone(), jobInterviewInvitationResponse.getMessage());
            } else {
                SimpleDateFormat simpleDateFormat = interviewInvitationInteractor.c;
                Intrinsics.checkNotNullExpressionValue(instance, FormattedDateDisplayingType.TYPE_CALENDAR);
                String format4 = simpleDateFormat.format(instance.getTime());
                Intrinsics.checkNotNullExpressionValue(format4, "dateFormat.format(calendar.time)");
                instance.add(5, 1);
                String format5 = interviewInvitationInteractor.c.format(instance.getTime());
                Intrinsics.checkNotNullExpressionValue(format5, "calendar.let {\n         …at(it.time)\n            }");
                invitationDraft = new InvitationDraft(CollectionsKt__CollectionsKt.listOf((Object[]) new DateEntry[]{new DateEntry(format4, instance.get(2), instance.get(5), null, null, null, 56, null), new DateEntry(format5, instance.get(2), instance.get(5), null, null, null, 56, null)}), null, null, null, 14, null);
            }
            return new Result.Success(invitationDraft);
        }
        throw new NoWhenBranchMatchedException();
    }

    @NotNull
    public final Observable<TypedResult<Unit>> invite(@NotNull InvitationDraft invitationDraft) {
        Intrinsics.checkNotNullParameter(invitationDraft, AnalyticFieldsName.draft);
        return this.f.invite(this.g, this.e.convert(invitationDraft));
    }

    @NotNull
    public final Observable<Result> loadInterviewInvitation() {
        Observable<R> map = this.f.requestInvitationForm(this.g).map(new a2.a.a.j1.b.i.a(new Function1<TypedResult<JobInterviewInvitationResponse>, Result>(this) { // from class: com.avito.android.job.interview.domain.InterviewInvitationInteractor.a
            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public Result invoke(TypedResult<JobInterviewInvitationResponse> typedResult) {
                TypedResult<JobInterviewInvitationResponse> typedResult2 = typedResult;
                Intrinsics.checkNotNullParameter(typedResult2, "p1");
                return InterviewInvitationInteractor.access$mapToResult((InterviewInvitationInteractor) this.receiver, typedResult2);
            }
        }));
        Intrinsics.checkNotNullExpressionValue(map, "jobInterviewInvitationAp…      .map(::mapToResult)");
        return map;
    }
}
