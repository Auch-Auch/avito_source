package com.avito.android.job.interview;

import com.avito.android.job.interview.pickers.TimePickerResult;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.category_parameters.AddressParameter;
import com.google.common.net.HttpHeaders;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\n\u0004\u0005\u0006\u0007\b\t\n\u000b\f\rB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\n\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017¨\u0006\u0018"}, d2 = {"Lcom/avito/android/job/interview/Action;", "", "<init>", "()V", "ChangeDate", "ChangeTime", "DateChanged", "Invite", "LocationChanged", "MessageChanged", "PhoneChanged", "PickLocation", HttpHeaders.REFRESH, "TimeChanged", "Lcom/avito/android/job/interview/Action$ChangeDate;", "Lcom/avito/android/job/interview/Action$ChangeTime;", "Lcom/avito/android/job/interview/Action$PickLocation;", "Lcom/avito/android/job/interview/Action$Refresh;", "Lcom/avito/android/job/interview/Action$Invite;", "Lcom/avito/android/job/interview/Action$TimeChanged;", "Lcom/avito/android/job/interview/Action$DateChanged;", "Lcom/avito/android/job/interview/Action$LocationChanged;", "Lcom/avito/android/job/interview/Action$PhoneChanged;", "Lcom/avito/android/job/interview/Action$MessageChanged;", "interview_release"}, k = 1, mv = {1, 4, 2})
public abstract class Action {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/job/interview/Action$ChangeDate;", "Lcom/avito/android/job/interview/Action;", "", AuthSource.SEND_ABUSE, "I", "getPos", "()I", "pos", "<init>", "(I)V", "interview_release"}, k = 1, mv = {1, 4, 2})
    public static final class ChangeDate extends Action {
        public final int a;

        public ChangeDate(int i) {
            super(null);
            this.a = i;
        }

        public final int getPos() {
            return this.a;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/job/interview/Action$ChangeTime;", "Lcom/avito/android/job/interview/Action;", "", AuthSource.SEND_ABUSE, "I", "getPos", "()I", "pos", "<init>", "(I)V", "interview_release"}, k = 1, mv = {1, 4, 2})
    public static final class ChangeTime extends Action {
        public final int a;

        public ChangeTime(int i) {
            super(null);
            this.a = i;
        }

        public final int getPos() {
            return this.a;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000e\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\b\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u0015R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0010\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R\u0019\u0010\u0013\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006¨\u0006\u0016"}, d2 = {"Lcom/avito/android/job/interview/Action$DateChanged;", "Lcom/avito/android/job/interview/Action;", "", "d", "I", "getMonth", "()I", "month", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "title", "c", "getDay", "day", AuthSource.SEND_ABUSE, "getPos", "pos", "<init>", "(ILjava/lang/String;II)V", "interview_release"}, k = 1, mv = {1, 4, 2})
    public static final class DateChanged extends Action {
        public final int a;
        @NotNull
        public final String b;
        public final int c;
        public final int d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public DateChanged(int i, @NotNull String str, int i2, int i3) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "title");
            this.a = i;
            this.b = str;
            this.c = i2;
            this.d = i3;
        }

        public final int getDay() {
            return this.c;
        }

        public final int getMonth() {
            return this.d;
        }

        public final int getPos() {
            return this.a;
        }

        @NotNull
        public final String getTitle() {
            return this.b;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/job/interview/Action$Invite;", "Lcom/avito/android/job/interview/Action;", "<init>", "()V", "interview_release"}, k = 1, mv = {1, 4, 2})
    public static final class Invite extends Action {
        @NotNull
        public static final Invite INSTANCE = new Invite();

        public Invite() {
            super(null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/job/interview/Action$LocationChanged;", "Lcom/avito/android/job/interview/Action;", "Lcom/avito/android/remote/model/category_parameters/AddressParameter$Value;", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/model/category_parameters/AddressParameter$Value;", "getResult", "()Lcom/avito/android/remote/model/category_parameters/AddressParameter$Value;", "result", "<init>", "(Lcom/avito/android/remote/model/category_parameters/AddressParameter$Value;)V", "interview_release"}, k = 1, mv = {1, 4, 2})
    public static final class LocationChanged extends Action {
        @NotNull
        public final AddressParameter.Value a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public LocationChanged(@NotNull AddressParameter.Value value) {
            super(null);
            Intrinsics.checkNotNullParameter(value, "result");
            this.a = value;
        }

        @NotNull
        public final AddressParameter.Value getResult() {
            return this.a;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/job/interview/Action$MessageChanged;", "Lcom/avito/android/job/interview/Action;", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "message", "<init>", "(Ljava/lang/String;)V", "interview_release"}, k = 1, mv = {1, 4, 2})
    public static final class MessageChanged extends Action {
        @NotNull
        public final String a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public MessageChanged(@NotNull String str) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "message");
            this.a = str;
        }

        @NotNull
        public final String getMessage() {
            return this.a;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/job/interview/Action$PhoneChanged;", "Lcom/avito/android/job/interview/Action;", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getPhone", "()Ljava/lang/String;", "phone", "<init>", "(Ljava/lang/String;)V", "interview_release"}, k = 1, mv = {1, 4, 2})
    public static final class PhoneChanged extends Action {
        @NotNull
        public final String a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public PhoneChanged(@NotNull String str) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "phone");
            this.a = str;
        }

        @NotNull
        public final String getPhone() {
            return this.a;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\b\u0010\tR\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/job/interview/Action$PickLocation;", "Lcom/avito/android/job/interview/Action;", "Lcom/avito/android/job/interview/Location;", AuthSource.SEND_ABUSE, "Lcom/avito/android/job/interview/Location;", "getLocation", "()Lcom/avito/android/job/interview/Location;", "location", "<init>", "(Lcom/avito/android/job/interview/Location;)V", "interview_release"}, k = 1, mv = {1, 4, 2})
    public static final class PickLocation extends Action {
        @Nullable
        public final Location a;

        public PickLocation(@Nullable Location location) {
            super(null);
            this.a = location;
        }

        @Nullable
        public final Location getLocation() {
            return this.a;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/job/interview/Action$Refresh;", "Lcom/avito/android/job/interview/Action;", "<init>", "()V", "interview_release"}, k = 1, mv = {1, 4, 2})
    public static final class Refresh extends Action {
        @NotNull
        public static final Refresh INSTANCE = new Refresh();

        public Refresh() {
            super(null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\b¢\u0006\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/job/interview/Action$TimeChanged;", "Lcom/avito/android/job/interview/Action;", "", AuthSource.SEND_ABUSE, "I", "getPos", "()I", "pos", "Lcom/avito/android/job/interview/pickers/TimePickerResult;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/job/interview/pickers/TimePickerResult;", "getResult", "()Lcom/avito/android/job/interview/pickers/TimePickerResult;", "result", "<init>", "(ILcom/avito/android/job/interview/pickers/TimePickerResult;)V", "interview_release"}, k = 1, mv = {1, 4, 2})
    public static final class TimeChanged extends Action {
        public final int a;
        @NotNull
        public final TimePickerResult b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public TimeChanged(int i, @NotNull TimePickerResult timePickerResult) {
            super(null);
            Intrinsics.checkNotNullParameter(timePickerResult, "result");
            this.a = i;
            this.b = timePickerResult;
        }

        public final int getPos() {
            return this.a;
        }

        @NotNull
        public final TimePickerResult getResult() {
            return this.b;
        }
    }

    public Action() {
    }

    public Action(j jVar) {
    }
}
