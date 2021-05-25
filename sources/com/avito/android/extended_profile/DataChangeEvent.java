package com.avito.android.extended_profile;

import com.avito.android.extended_profile.adapter.ExtendedProfileListItem;
import com.avito.android.extended_profile.tracker.ExtendedProfileTracker;
import com.avito.android.remote.auth.AuthSource;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/avito/android/extended_profile/DataChangeEvent;", "", "Lcom/avito/android/extended_profile/tracker/ExtendedProfileTracker$TrackFlow;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/extended_profile/tracker/ExtendedProfileTracker$TrackFlow;", "getTrackFlow", "()Lcom/avito/android/extended_profile/tracker/ExtendedProfileTracker$TrackFlow;", "trackFlow", "", "Lcom/avito/android/extended_profile/adapter/ExtendedProfileListItem;", AuthSource.SEND_ABUSE, "Ljava/util/List;", "getData", "()Ljava/util/List;", "data", "<init>", "(Ljava/util/List;Lcom/avito/android/extended_profile/tracker/ExtendedProfileTracker$TrackFlow;)V", "extended-profile_release"}, k = 1, mv = {1, 4, 2})
public final class DataChangeEvent {
    @NotNull
    public final List<ExtendedProfileListItem> a;
    @NotNull
    public final ExtendedProfileTracker.TrackFlow b;

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.util.List<? extends com.avito.android.extended_profile.adapter.ExtendedProfileListItem> */
    /* JADX WARN: Multi-variable type inference failed */
    public DataChangeEvent(@NotNull List<? extends ExtendedProfileListItem> list, @NotNull ExtendedProfileTracker.TrackFlow trackFlow) {
        Intrinsics.checkNotNullParameter(list, "data");
        Intrinsics.checkNotNullParameter(trackFlow, "trackFlow");
        this.a = list;
        this.b = trackFlow;
    }

    @NotNull
    public final List<ExtendedProfileListItem> getData() {
        return this.a;
    }

    @NotNull
    public final ExtendedProfileTracker.TrackFlow getTrackFlow() {
        return this.b;
    }
}
