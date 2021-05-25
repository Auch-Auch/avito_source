package com.avito.android.job.interview.pickers;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\b\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u0001\u0002\n\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/job/interview/pickers/TimePickerResult;", "", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "title", "Interval", "Specific", "Lcom/avito/android/job/interview/pickers/TimePickerResult$Specific;", "Lcom/avito/android/job/interview/pickers/TimePickerResult$Interval;", "interview_release"}, k = 1, mv = {1, 4, 2})
public abstract class TimePickerResult {
    @NotNull
    public final String a;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0002¢\u0006\u0004\b\f\u0010\rR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\n\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006¨\u0006\u000e"}, d2 = {"Lcom/avito/android/job/interview/pickers/TimePickerResult$Interval;", "Lcom/avito/android/job/interview/pickers/TimePickerResult;", "", "c", "Ljava/lang/String;", "getTo", "()Ljava/lang/String;", "to", AuthSource.BOOKING_ORDER, "getFrom", "from", "title", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "interview_release"}, k = 1, mv = {1, 4, 2})
    public static final class Interval extends TimePickerResult {
        @NotNull
        public final String b;
        @NotNull
        public final String c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Interval(@NotNull String str, @NotNull String str2, @NotNull String str3) {
            super(str3, null);
            a.Z0(str, "from", str2, "to", str3, "title");
            this.b = str;
            this.c = str2;
        }

        @NotNull
        public final String getFrom() {
            return this.b;
        }

        @NotNull
        public final String getTo() {
            return this.c;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/avito/android/job/interview/pickers/TimePickerResult$Specific;", "Lcom/avito/android/job/interview/pickers/TimePickerResult;", "", "title", "<init>", "(Ljava/lang/String;)V", "interview_release"}, k = 1, mv = {1, 4, 2})
    public static final class Specific extends TimePickerResult {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Specific(@NotNull String str) {
            super(str, null);
            Intrinsics.checkNotNullParameter(str, "title");
        }
    }

    public TimePickerResult(String str, j jVar) {
        this.a = str;
    }

    @NotNull
    public final String getTitle() {
        return this.a;
    }
}
