package com.avito.android.job.interview;

import com.avito.android.remote.auth.AuthSource;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/avito/android/job/interview/ValidationResult;", "", "<init>", "()V", "Invalid", "Valid", "Lcom/avito/android/job/interview/ValidationResult$Invalid;", "Lcom/avito/android/job/interview/ValidationResult$Valid;", "interview_release"}, k = 1, mv = {1, 4, 2})
public abstract class ValidationResult {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/job/interview/ValidationResult$Invalid;", "Lcom/avito/android/job/interview/ValidationResult;", "", AuthSource.BOOKING_ORDER, "Z", "isLocationInvalid", "()Z", "", "", AuthSource.SEND_ABUSE, "Ljava/util/List;", "getDates", "()Ljava/util/List;", "dates", "<init>", "(Ljava/util/List;Z)V", "interview_release"}, k = 1, mv = {1, 4, 2})
    public static final class Invalid extends ValidationResult {
        @NotNull
        public final List<Integer> a;
        public final boolean b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Invalid(@NotNull List<Integer> list, boolean z) {
            super(null);
            Intrinsics.checkNotNullParameter(list, "dates");
            this.a = list;
            this.b = z;
        }

        @NotNull
        public final List<Integer> getDates() {
            return this.a;
        }

        public final boolean isLocationInvalid() {
            return this.b;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/job/interview/ValidationResult$Valid;", "Lcom/avito/android/job/interview/ValidationResult;", "<init>", "()V", "interview_release"}, k = 1, mv = {1, 4, 2})
    public static final class Valid extends ValidationResult {
        @NotNull
        public static final Valid INSTANCE = new Valid();

        public Valid() {
            super(null);
        }
    }

    public ValidationResult() {
    }

    public ValidationResult(j jVar) {
    }
}
