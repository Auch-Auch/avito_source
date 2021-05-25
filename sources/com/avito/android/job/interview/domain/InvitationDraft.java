package com.avito.android.job.interview.domain;

import a2.b.a.a.a;
import com.avito.android.job.interview.Location;
import com.avito.android.remote.auth.AuthSource;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0010\b\b\u0018\u00002\u00020\u0001B9\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b&\u0010'J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\f\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\f\u0010\u000bJD\u0010\u0011\u001a\u00020\u00002\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0013\u0010\u000bJ\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0019\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001aR\u001b\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u000bR\u001b\u0010\u000f\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001c\u001a\u0004\b\u001f\u0010\u000bR\u001f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010\u0005R\u001b\u0010\u000e\u001a\u0004\u0018\u00010\u00068\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010\b¨\u0006("}, d2 = {"Lcom/avito/android/job/interview/domain/InvitationDraft;", "", "", "Lcom/avito/android/job/interview/domain/DateEntry;", "component1", "()Ljava/util/List;", "Lcom/avito/android/job/interview/Location;", "component2", "()Lcom/avito/android/job/interview/Location;", "", "component3", "()Ljava/lang/String;", "component4", "dates", "location", "phone", "message", "copy", "(Ljava/util/List;Lcom/avito/android/job/interview/Location;Ljava/lang/String;Ljava/lang/String;)Lcom/avito/android/job/interview/domain/InvitationDraft;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "d", "Ljava/lang/String;", "getMessage", "c", "getPhone", AuthSource.SEND_ABUSE, "Ljava/util/List;", "getDates", AuthSource.BOOKING_ORDER, "Lcom/avito/android/job/interview/Location;", "getLocation", "<init>", "(Ljava/util/List;Lcom/avito/android/job/interview/Location;Ljava/lang/String;Ljava/lang/String;)V", "interview_release"}, k = 1, mv = {1, 4, 2})
public final class InvitationDraft {
    @NotNull
    public final List<DateEntry> a;
    @Nullable
    public final Location b;
    @Nullable
    public final String c;
    @Nullable
    public final String d;

    public InvitationDraft(@NotNull List<DateEntry> list, @Nullable Location location, @Nullable String str, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(list, "dates");
        this.a = list;
        this.b = location;
        this.c = str;
        this.d = str2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.job.interview.domain.InvitationDraft */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ InvitationDraft copy$default(InvitationDraft invitationDraft, List list, Location location, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = invitationDraft.a;
        }
        if ((i & 2) != 0) {
            location = invitationDraft.b;
        }
        if ((i & 4) != 0) {
            str = invitationDraft.c;
        }
        if ((i & 8) != 0) {
            str2 = invitationDraft.d;
        }
        return invitationDraft.copy(list, location, str, str2);
    }

    @NotNull
    public final List<DateEntry> component1() {
        return this.a;
    }

    @Nullable
    public final Location component2() {
        return this.b;
    }

    @Nullable
    public final String component3() {
        return this.c;
    }

    @Nullable
    public final String component4() {
        return this.d;
    }

    @NotNull
    public final InvitationDraft copy(@NotNull List<DateEntry> list, @Nullable Location location, @Nullable String str, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(list, "dates");
        return new InvitationDraft(list, location, str, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof InvitationDraft)) {
            return false;
        }
        InvitationDraft invitationDraft = (InvitationDraft) obj;
        return Intrinsics.areEqual(this.a, invitationDraft.a) && Intrinsics.areEqual(this.b, invitationDraft.b) && Intrinsics.areEqual(this.c, invitationDraft.c) && Intrinsics.areEqual(this.d, invitationDraft.d);
    }

    @NotNull
    public final List<DateEntry> getDates() {
        return this.a;
    }

    @Nullable
    public final Location getLocation() {
        return this.b;
    }

    @Nullable
    public final String getMessage() {
        return this.d;
    }

    @Nullable
    public final String getPhone() {
        return this.c;
    }

    public int hashCode() {
        List<DateEntry> list = this.a;
        int i = 0;
        int hashCode = (list != null ? list.hashCode() : 0) * 31;
        Location location = this.b;
        int hashCode2 = (hashCode + (location != null ? location.hashCode() : 0)) * 31;
        String str = this.c;
        int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.d;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode3 + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("InvitationDraft(dates=");
        L.append(this.a);
        L.append(", location=");
        L.append(this.b);
        L.append(", phone=");
        L.append(this.c);
        L.append(", message=");
        return a.t(L, this.d, ")");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ InvitationDraft(List list, Location location, String str, String str2, int i, j jVar) {
        this(list, (i & 2) != 0 ? null : location, (i & 4) != 0 ? null : str, (i & 8) != 0 ? null : str2);
    }
}
