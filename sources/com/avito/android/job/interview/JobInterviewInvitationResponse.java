package com.avito.android.job.interview;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B1\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\"\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u0010\u001a\u00020\u000f8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0016"}, d2 = {"Lcom/avito/android/job/interview/JobInterviewInvitationResponse;", "", "", "phone", "Ljava/lang/String;", "getPhone", "()Ljava/lang/String;", "message", "getMessage", "", "Lcom/avito/android/job/interview/Range;", "dates", "Ljava/util/List;", "getDates", "()Ljava/util/List;", "Lcom/avito/android/job/interview/Location;", "location", "Lcom/avito/android/job/interview/Location;", "getLocation", "()Lcom/avito/android/job/interview/Location;", "<init>", "(Ljava/util/List;Lcom/avito/android/job/interview/Location;Ljava/lang/String;Ljava/lang/String;)V", "job_release"}, k = 1, mv = {1, 4, 2})
public final class JobInterviewInvitationResponse {
    @SerializedName("dates")
    @NotNull
    private final List<Range> dates;
    @SerializedName("location")
    @NotNull
    private final Location location;
    @SerializedName("message")
    @Nullable
    private final String message;
    @SerializedName("phone")
    @Nullable
    private final String phone;

    public JobInterviewInvitationResponse(@NotNull List<Range> list, @NotNull Location location2, @Nullable String str, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(list, "dates");
        Intrinsics.checkNotNullParameter(location2, "location");
        this.dates = list;
        this.location = location2;
        this.phone = str;
        this.message = str2;
    }

    @NotNull
    public final List<Range> getDates() {
        return this.dates;
    }

    @NotNull
    public final Location getLocation() {
        return this.location;
    }

    @Nullable
    public final String getMessage() {
        return this.message;
    }

    @Nullable
    public final String getPhone() {
        return this.phone;
    }
}
