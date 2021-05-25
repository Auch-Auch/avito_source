package com.avito.android.job.interview.domain;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0013\b\b\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b(\u0010)J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0012\u0010\n\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0004JR\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0004J\u0010\u0010\u0015\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0007J\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\u001b\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u0004R\u001b\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001b\u001a\u0004\b\u001e\u0010\u0004R\u0019\u0010\f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010\u001b\u001a\u0004\b \u0010\u0004R\u0019\u0010\u000e\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010\u0007R\u001b\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010\u001b\u001a\u0004\b%\u0010\u0004R\u0019\u0010\r\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b&\u0010\"\u001a\u0004\b'\u0010\u0007¨\u0006*"}, d2 = {"Lcom/avito/android/job/interview/domain/DateEntry;", "", "", "component1", "()Ljava/lang/String;", "", "component2", "()I", "component3", "component4", "component5", "component6", "dateTitle", "month", "day", "timeTitle", "fromTime", "toTime", "copy", "(Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/avito/android/job/interview/domain/DateEntry;", "toString", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "e", "Ljava/lang/String;", "getFromTime", "d", "getTimeTitle", AuthSource.SEND_ABUSE, "getDateTitle", "c", "I", "getDay", "f", "getToTime", AuthSource.BOOKING_ORDER, "getMonth", "<init>", "(Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "interview_release"}, k = 1, mv = {1, 4, 2})
public final class DateEntry {
    @NotNull
    public final String a;
    public final int b;
    public final int c;
    @Nullable
    public final String d;
    @Nullable
    public final String e;
    @Nullable
    public final String f;

    public DateEntry(@NotNull String str, int i, int i2, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
        Intrinsics.checkNotNullParameter(str, "dateTitle");
        this.a = str;
        this.b = i;
        this.c = i2;
        this.d = str2;
        this.e = str3;
        this.f = str4;
    }

    public static /* synthetic */ DateEntry copy$default(DateEntry dateEntry, String str, int i, int i2, String str2, String str3, String str4, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = dateEntry.a;
        }
        if ((i3 & 2) != 0) {
            i = dateEntry.b;
        }
        if ((i3 & 4) != 0) {
            i2 = dateEntry.c;
        }
        if ((i3 & 8) != 0) {
            str2 = dateEntry.d;
        }
        if ((i3 & 16) != 0) {
            str3 = dateEntry.e;
        }
        if ((i3 & 32) != 0) {
            str4 = dateEntry.f;
        }
        return dateEntry.copy(str, i, i2, str2, str3, str4);
    }

    @NotNull
    public final String component1() {
        return this.a;
    }

    public final int component2() {
        return this.b;
    }

    public final int component3() {
        return this.c;
    }

    @Nullable
    public final String component4() {
        return this.d;
    }

    @Nullable
    public final String component5() {
        return this.e;
    }

    @Nullable
    public final String component6() {
        return this.f;
    }

    @NotNull
    public final DateEntry copy(@NotNull String str, int i, int i2, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
        Intrinsics.checkNotNullParameter(str, "dateTitle");
        return new DateEntry(str, i, i2, str2, str3, str4);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DateEntry)) {
            return false;
        }
        DateEntry dateEntry = (DateEntry) obj;
        return Intrinsics.areEqual(this.a, dateEntry.a) && this.b == dateEntry.b && this.c == dateEntry.c && Intrinsics.areEqual(this.d, dateEntry.d) && Intrinsics.areEqual(this.e, dateEntry.e) && Intrinsics.areEqual(this.f, dateEntry.f);
    }

    @NotNull
    public final String getDateTitle() {
        return this.a;
    }

    public final int getDay() {
        return this.c;
    }

    @Nullable
    public final String getFromTime() {
        return this.e;
    }

    public final int getMonth() {
        return this.b;
    }

    @Nullable
    public final String getTimeTitle() {
        return this.d;
    }

    @Nullable
    public final String getToTime() {
        return this.f;
    }

    public int hashCode() {
        String str = this.a;
        int i = 0;
        int hashCode = (((((str != null ? str.hashCode() : 0) * 31) + this.b) * 31) + this.c) * 31;
        String str2 = this.d;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.e;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.f;
        if (str4 != null) {
            i = str4.hashCode();
        }
        return hashCode3 + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("DateEntry(dateTitle=");
        L.append(this.a);
        L.append(", month=");
        L.append(this.b);
        L.append(", day=");
        L.append(this.c);
        L.append(", timeTitle=");
        L.append(this.d);
        L.append(", fromTime=");
        L.append(this.e);
        L.append(", toTime=");
        return a.t(L, this.f, ")");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DateEntry(String str, int i, int i2, String str2, String str3, String str4, int i3, j jVar) {
        this(str, i, i2, (i3 & 8) != 0 ? null : str2, (i3 & 16) != 0 ? null : str3, (i3 & 32) != 0 ? null : str4);
    }
}
