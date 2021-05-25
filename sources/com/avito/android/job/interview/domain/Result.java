package com.avito.android.job.interview.domain;

import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/avito/android/job/interview/domain/Result;", "", "<init>", "()V", "Failure", "Success", "Lcom/avito/android/job/interview/domain/Result$Success;", "Lcom/avito/android/job/interview/domain/Result$Failure;", "interview_release"}, k = 1, mv = {1, 4, 2})
public abstract class Result {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/job/interview/domain/Result$Failure;", "Lcom/avito/android/job/interview/domain/Result;", "<init>", "()V", "interview_release"}, k = 1, mv = {1, 4, 2})
    public static final class Failure extends Result {
        @NotNull
        public static final Failure INSTANCE = new Failure();

        public Failure() {
            super(null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/job/interview/domain/Result$Success;", "Lcom/avito/android/job/interview/domain/Result;", "Lcom/avito/android/job/interview/domain/InvitationDraft;", AuthSource.SEND_ABUSE, "Lcom/avito/android/job/interview/domain/InvitationDraft;", "getInvitationDraft", "()Lcom/avito/android/job/interview/domain/InvitationDraft;", "invitationDraft", "<init>", "(Lcom/avito/android/job/interview/domain/InvitationDraft;)V", "interview_release"}, k = 1, mv = {1, 4, 2})
    public static final class Success extends Result {
        @NotNull
        public final InvitationDraft a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Success(@NotNull InvitationDraft invitationDraft) {
            super(null);
            Intrinsics.checkNotNullParameter(invitationDraft, "invitationDraft");
            this.a = invitationDraft;
        }

        @NotNull
        public final InvitationDraft getInvitationDraft() {
            return this.a;
        }
    }

    public Result() {
    }

    public Result(j jVar) {
    }
}
