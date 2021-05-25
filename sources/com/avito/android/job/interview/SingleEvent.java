package com.avito.android.job.interview;

import com.avito.android.job.interview.domain.DateEntry;
import com.avito.android.remote.auth.AuthSource;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/avito/android/job/interview/SingleEvent;", "", "<init>", "()V", "Navigation", "UiChange", "Lcom/avito/android/job/interview/SingleEvent$Navigation;", "Lcom/avito/android/job/interview/SingleEvent$UiChange;", "interview_release"}, k = 1, mv = {1, 4, 2})
public abstract class SingleEvent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0004\b\t\n\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/job/interview/SingleEvent$Navigation;", "Lcom/avito/android/job/interview/SingleEvent;", "<init>", "()V", "DatePicker", "Exit", "LocationPicker", "TimePicker", "Lcom/avito/android/job/interview/SingleEvent$Navigation$LocationPicker;", "Lcom/avito/android/job/interview/SingleEvent$Navigation$DatePicker;", "Lcom/avito/android/job/interview/SingleEvent$Navigation$TimePicker;", "Lcom/avito/android/job/interview/SingleEvent$Navigation$Exit;", "interview_release"}, k = 1, mv = {1, 4, 2})
    public static abstract class Navigation extends SingleEvent {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\b¢\u0006\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/job/interview/SingleEvent$Navigation$DatePicker;", "Lcom/avito/android/job/interview/SingleEvent$Navigation;", "", AuthSource.SEND_ABUSE, "I", "getPos", "()I", "pos", "Lcom/avito/android/job/interview/domain/DateEntry;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/job/interview/domain/DateEntry;", "getDateEntry", "()Lcom/avito/android/job/interview/domain/DateEntry;", "dateEntry", "<init>", "(ILcom/avito/android/job/interview/domain/DateEntry;)V", "interview_release"}, k = 1, mv = {1, 4, 2})
        public static final class DatePicker extends Navigation {
            public final int a;
            @NotNull
            public final DateEntry b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public DatePicker(int i, @NotNull DateEntry dateEntry) {
                super(null);
                Intrinsics.checkNotNullParameter(dateEntry, "dateEntry");
                this.a = i;
                this.b = dateEntry;
            }

            @NotNull
            public final DateEntry getDateEntry() {
                return this.b;
            }

            public final int getPos() {
                return this.a;
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/job/interview/SingleEvent$Navigation$Exit;", "Lcom/avito/android/job/interview/SingleEvent$Navigation;", "<init>", "()V", "interview_release"}, k = 1, mv = {1, 4, 2})
        public static final class Exit extends Navigation {
            @NotNull
            public static final Exit INSTANCE = new Exit();

            public Exit() {
                super(null);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\b\u0010\tR\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/job/interview/SingleEvent$Navigation$LocationPicker;", "Lcom/avito/android/job/interview/SingleEvent$Navigation;", "Lcom/avito/android/job/interview/Location;", AuthSource.SEND_ABUSE, "Lcom/avito/android/job/interview/Location;", "getLocation", "()Lcom/avito/android/job/interview/Location;", "location", "<init>", "(Lcom/avito/android/job/interview/Location;)V", "interview_release"}, k = 1, mv = {1, 4, 2})
        public static final class LocationPicker extends Navigation {
            @Nullable
            public final Location a;

            public LocationPicker(@Nullable Location location) {
                super(null);
                this.a = location;
            }

            @Nullable
            public final Location getLocation() {
                return this.a;
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\r\u001a\u00020\b\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/job/interview/SingleEvent$Navigation$TimePicker;", "Lcom/avito/android/job/interview/SingleEvent$Navigation;", "Lcom/avito/android/job/interview/domain/DateEntry;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/job/interview/domain/DateEntry;", "getDateEntry", "()Lcom/avito/android/job/interview/domain/DateEntry;", "dateEntry", "", AuthSource.SEND_ABUSE, "I", "getPos", "()I", "pos", "<init>", "(ILcom/avito/android/job/interview/domain/DateEntry;)V", "interview_release"}, k = 1, mv = {1, 4, 2})
        public static final class TimePicker extends Navigation {
            public final int a;
            @NotNull
            public final DateEntry b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public TimePicker(int i, @NotNull DateEntry dateEntry) {
                super(null);
                Intrinsics.checkNotNullParameter(dateEntry, "dateEntry");
                this.a = i;
                this.b = dateEntry;
            }

            @NotNull
            public final DateEntry getDateEntry() {
                return this.b;
            }

            public final int getPos() {
                return this.a;
            }
        }

        public Navigation() {
            super(null);
        }

        public Navigation(j jVar) {
            super(null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0005\u0004\u0005\u0006\u0007\bB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0005\t\n\u000b\f\r¨\u0006\u000e"}, d2 = {"Lcom/avito/android/job/interview/SingleEvent$UiChange;", "Lcom/avito/android/job/interview/SingleEvent;", "<init>", "()V", "DateUpdate", "InvalidResult", "InviteError", "LocationUpdate", "TimeUpdate", "Lcom/avito/android/job/interview/SingleEvent$UiChange$LocationUpdate;", "Lcom/avito/android/job/interview/SingleEvent$UiChange$TimeUpdate;", "Lcom/avito/android/job/interview/SingleEvent$UiChange$DateUpdate;", "Lcom/avito/android/job/interview/SingleEvent$UiChange$InvalidResult;", "Lcom/avito/android/job/interview/SingleEvent$UiChange$InviteError;", "interview_release"}, k = 1, mv = {1, 4, 2})
    public static abstract class UiChange extends SingleEvent {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\r\u001a\u00020\b\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/job/interview/SingleEvent$UiChange$DateUpdate;", "Lcom/avito/android/job/interview/SingleEvent$UiChange;", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "title", "", AuthSource.SEND_ABUSE, "I", "getPos", "()I", "pos", "<init>", "(ILjava/lang/String;)V", "interview_release"}, k = 1, mv = {1, 4, 2})
        public static final class DateUpdate extends UiChange {
            public final int a;
            @NotNull
            public final String b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public DateUpdate(int i, @NotNull String str) {
                super(null);
                Intrinsics.checkNotNullParameter(str, "title");
                this.a = i;
                this.b = str;
            }

            public final int getPos() {
                return this.a;
            }

            @NotNull
            public final String getTitle() {
                return this.b;
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0010\f\u001a\u00020\t¢\u0006\u0004\b\u000e\u0010\u000fR\u001f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0019\u0010\f\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/avito/android/job/interview/SingleEvent$UiChange$InvalidResult;", "Lcom/avito/android/job/interview/SingleEvent$UiChange;", "", "", AuthSource.SEND_ABUSE, "Ljava/util/List;", "getDates", "()Ljava/util/List;", "dates", "", AuthSource.BOOKING_ORDER, "Z", "isLocationInvalid", "()Z", "<init>", "(Ljava/util/List;Z)V", "interview_release"}, k = 1, mv = {1, 4, 2})
        public static final class InvalidResult extends UiChange {
            @NotNull
            public final List<Integer> a;
            public final boolean b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public InvalidResult(@NotNull List<Integer> list, boolean z) {
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

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/job/interview/SingleEvent$UiChange$InviteError;", "Lcom/avito/android/job/interview/SingleEvent$UiChange;", "<init>", "()V", "interview_release"}, k = 1, mv = {1, 4, 2})
        public static final class InviteError extends UiChange {
            @NotNull
            public static final InviteError INSTANCE = new InviteError();

            public InviteError() {
                super(null);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/job/interview/SingleEvent$UiChange$LocationUpdate;", "Lcom/avito/android/job/interview/SingleEvent$UiChange;", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "title", "<init>", "(Ljava/lang/String;)V", "interview_release"}, k = 1, mv = {1, 4, 2})
        public static final class LocationUpdate extends UiChange {
            @NotNull
            public final String a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public LocationUpdate(@NotNull String str) {
                super(null);
                Intrinsics.checkNotNullParameter(str, "title");
                this.a = str;
            }

            @NotNull
            public final String getTitle() {
                return this.a;
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\b¢\u0006\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/job/interview/SingleEvent$UiChange$TimeUpdate;", "Lcom/avito/android/job/interview/SingleEvent$UiChange;", "", AuthSource.SEND_ABUSE, "I", "getPos", "()I", "pos", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "title", "<init>", "(ILjava/lang/String;)V", "interview_release"}, k = 1, mv = {1, 4, 2})
        public static final class TimeUpdate extends UiChange {
            public final int a;
            @NotNull
            public final String b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public TimeUpdate(int i, @NotNull String str) {
                super(null);
                Intrinsics.checkNotNullParameter(str, "title");
                this.a = i;
                this.b = str;
            }

            public final int getPos() {
                return this.a;
            }

            @NotNull
            public final String getTitle() {
                return this.b;
            }
        }

        public UiChange() {
            super(null);
        }

        public UiChange(j jVar) {
            super(null);
        }
    }

    public SingleEvent() {
    }

    public SingleEvent(j jVar) {
    }
}
