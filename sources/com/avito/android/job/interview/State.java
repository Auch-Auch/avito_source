package com.avito.android.job.interview;

import com.avito.android.job.interview.domain.InvitationDraft;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.analytic.v2.AnalyticFieldsName;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/avito/android/job/interview/State;", "", "<init>", "()V", "Content", "Error", "Loading", "Lcom/avito/android/job/interview/State$Loading;", "Lcom/avito/android/job/interview/State$Content;", "Lcom/avito/android/job/interview/State$Error;", "interview_release"}, k = 1, mv = {1, 4, 2})
public abstract class State {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/job/interview/State$Content;", "Lcom/avito/android/job/interview/State;", "Lcom/avito/android/job/interview/domain/InvitationDraft;", AuthSource.SEND_ABUSE, "Lcom/avito/android/job/interview/domain/InvitationDraft;", "getDraft", "()Lcom/avito/android/job/interview/domain/InvitationDraft;", AnalyticFieldsName.draft, "<init>", "(Lcom/avito/android/job/interview/domain/InvitationDraft;)V", "interview_release"}, k = 1, mv = {1, 4, 2})
    public static final class Content extends State {
        @NotNull
        public final InvitationDraft a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Content(@NotNull InvitationDraft invitationDraft) {
            super(null);
            Intrinsics.checkNotNullParameter(invitationDraft, AnalyticFieldsName.draft);
            this.a = invitationDraft;
        }

        @NotNull
        public final InvitationDraft getDraft() {
            return this.a;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/job/interview/State$Error;", "Lcom/avito/android/job/interview/State;", "<init>", "()V", "interview_release"}, k = 1, mv = {1, 4, 2})
    public static final class Error extends State {
        @NotNull
        public static final Error INSTANCE = new Error();

        public Error() {
            super(null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/job/interview/State$Loading;", "Lcom/avito/android/job/interview/State;", "<init>", "()V", "interview_release"}, k = 1, mv = {1, 4, 2})
    public static final class Loading extends State {
        @NotNull
        public static final Loading INSTANCE = new Loading();

        public Loading() {
            super(null);
        }
    }

    public State() {
    }

    public State(j jVar) {
    }
}
