package com.avito.android.events.notifications_settings;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J$\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004R\u0019\u0010\u0006\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0013\u001a\u0004\b\u0016\u0010\u0004¨\u0006\u0019"}, d2 = {"Lcom/avito/android/events/notifications_settings/NotificationSettingsChangeEvent;", "", "", "component1", "()Ljava/lang/String;", "component2", "section", "channel", "copy", "(Ljava/lang/String;Ljava/lang/String;)Lcom/avito/android/events/notifications_settings/NotificationSettingsChangeEvent;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getChannel", AuthSource.SEND_ABUSE, "getSection", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "core_release"}, k = 1, mv = {1, 4, 2})
public final class NotificationSettingsChangeEvent {
    @NotNull
    public final String a;
    @NotNull
    public final String b;

    public NotificationSettingsChangeEvent(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "section");
        Intrinsics.checkNotNullParameter(str2, "channel");
        this.a = str;
        this.b = str2;
    }

    public static /* synthetic */ NotificationSettingsChangeEvent copy$default(NotificationSettingsChangeEvent notificationSettingsChangeEvent, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = notificationSettingsChangeEvent.a;
        }
        if ((i & 2) != 0) {
            str2 = notificationSettingsChangeEvent.b;
        }
        return notificationSettingsChangeEvent.copy(str, str2);
    }

    @NotNull
    public final String component1() {
        return this.a;
    }

    @NotNull
    public final String component2() {
        return this.b;
    }

    @NotNull
    public final NotificationSettingsChangeEvent copy(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "section");
        Intrinsics.checkNotNullParameter(str2, "channel");
        return new NotificationSettingsChangeEvent(str, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NotificationSettingsChangeEvent)) {
            return false;
        }
        NotificationSettingsChangeEvent notificationSettingsChangeEvent = (NotificationSettingsChangeEvent) obj;
        return Intrinsics.areEqual(this.a, notificationSettingsChangeEvent.a) && Intrinsics.areEqual(this.b, notificationSettingsChangeEvent.b);
    }

    @NotNull
    public final String getChannel() {
        return this.b;
    }

    @NotNull
    public final String getSection() {
        return this.a;
    }

    public int hashCode() {
        String str = this.a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.b;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("NotificationSettingsChangeEvent(section=");
        L.append(this.a);
        L.append(", channel=");
        return a.t(L, this.b, ")");
    }
}
