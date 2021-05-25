package com.avito.android.profile.sessions.adapter.header;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.profile.sessions.adapter.SessionsListItem;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000b¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u0019\u0010\u0010\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\"\u0010\u0015\u001a\u00020\u000b8\u0016@\u0016X\u0004¢\u0006\u0012\n\u0004\b\u0011\u0010\r\u0012\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0012\u0010\u000f¨\u0006\u0018"}, d2 = {"Lcom/avito/android/profile/sessions/adapter/header/SessionsHeaderItem;", "Lcom/avito/android/profile/sessions/adapter/SessionsListItem;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "title", AuthSource.SEND_ABUSE, "getStringId", "getStringId$annotations", "()V", "stringId", "<init>", "(Ljava/lang/String;)V", "profile_release"}, k = 1, mv = {1, 4, 2})
public final class SessionsHeaderItem implements SessionsListItem {
    public static final Parcelable.Creator<SessionsHeaderItem> CREATOR = new Creator();
    @NotNull
    public final String a = a.I2("java.util.UUID.randomUUID().toString()");
    @NotNull
    public final String b;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<SessionsHeaderItem> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final SessionsHeaderItem createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new SessionsHeaderItem(parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final SessionsHeaderItem[] newArray(int i) {
            return new SessionsHeaderItem[i];
        }
    }

    public SessionsHeaderItem(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        this.b = str;
    }

    public static /* synthetic */ void getStringId$annotations() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.avito.conveyor_item.Item, com.avito.konveyor.blueprint.Item
    public long getId() {
        return SessionsListItem.DefaultImpls.getId(this);
    }

    @Override // com.avito.conveyor_item.Item
    @NotNull
    public String getStringId() {
        return this.a;
    }

    @NotNull
    public final String getTitle() {
        return this.b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.b);
    }
}
