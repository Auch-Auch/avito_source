package com.avito.android.remote.model.user_profile.items;

import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.util.Parcels;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u00102\u00020\u0001:\u0003\u0010\u0011\u0012B\u000f\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\n\u001a\u00020\t8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u0013"}, d2 = {"Lcom/avito/android/remote/model/user_profile/items/AdvertsItem;", "Lcom/avito/android/remote/model/user_profile/items/UserProfileItem;", "Landroid/os/Parcel;", "dest", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/model/user_profile/items/AdvertsItem$Status;", "status", "Lcom/avito/android/remote/model/user_profile/items/AdvertsItem$Status;", "getStatus", "()Lcom/avito/android/remote/model/user_profile/items/AdvertsItem$Status;", "<init>", "(Lcom/avito/android/remote/model/user_profile/items/AdvertsItem$Status;)V", "Companion", "Status", "StatusItem", "profile_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertsItem extends UserProfileItem {
    @JvmField
    @NotNull
    public static final Parcelable.Creator<AdvertsItem> CREATOR = Parcels.creator(AdvertsItem$Companion$CREATOR$1.INSTANCE);
    @NotNull
    public static final Companion Companion = new Companion(null);
    @SerializedName("status")
    @NotNull
    private final Status status;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/remote/model/user_profile/items/AdvertsItem$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/remote/model/user_profile/items/AdvertsItem;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "profile_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(j jVar) {
            this();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B#\u0012\u0006\u0010\u0012\u001a\u00020\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nR\u001e\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u000fR\u001c\u0010\u0012\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0013\u0010\u000f¨\u0006\u0017"}, d2 = {"Lcom/avito/android/remote/model/user_profile/items/AdvertsItem$Status;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "dest", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "Lcom/avito/android/remote/model/user_profile/items/AdvertsItem$StatusItem;", "inactive", "Lcom/avito/android/remote/model/user_profile/items/AdvertsItem$StatusItem;", "getInactive", "()Lcom/avito/android/remote/model/user_profile/items/AdvertsItem$StatusItem;", "rejected", "getRejected", "active", "getActive", "<init>", "(Lcom/avito/android/remote/model/user_profile/items/AdvertsItem$StatusItem;Lcom/avito/android/remote/model/user_profile/items/AdvertsItem$StatusItem;Lcom/avito/android/remote/model/user_profile/items/AdvertsItem$StatusItem;)V", "Companion", "profile_release"}, k = 1, mv = {1, 4, 2})
    public static final class Status implements Parcelable {
        @JvmField
        @NotNull
        public static final Parcelable.Creator<Status> CREATOR = Parcels.creator(AdvertsItem$Status$Companion$CREATOR$1.INSTANCE);
        @NotNull
        public static final Companion Companion = new Companion(null);
        @SerializedName("active")
        @NotNull
        private final StatusItem active;
        @SerializedName("inactive")
        @Nullable
        private final StatusItem inactive;
        @SerializedName("rejected")
        @Nullable
        private final StatusItem rejected;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/remote/model/user_profile/items/AdvertsItem$Status$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/remote/model/user_profile/items/AdvertsItem$Status;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "profile_release"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(j jVar) {
                this();
            }
        }

        public Status(@NotNull StatusItem statusItem, @Nullable StatusItem statusItem2, @Nullable StatusItem statusItem3) {
            Intrinsics.checkNotNullParameter(statusItem, "active");
            this.active = statusItem;
            this.inactive = statusItem2;
            this.rejected = statusItem3;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @NotNull
        public final StatusItem getActive() {
            return this.active;
        }

        @Nullable
        public final StatusItem getInactive() {
            return this.inactive;
        }

        @Nullable
        public final StatusItem getRejected() {
            return this.rejected;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "dest");
            parcel.writeParcelable(this.active, i);
            parcel.writeParcelable(this.inactive, i);
            parcel.writeParcelable(this.rejected, i);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u000f\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\f\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/avito/android/remote/model/user_profile/items/AdvertsItem$StatusItem;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "dest", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V", "Companion", "profile_release"}, k = 1, mv = {1, 4, 2})
    public static final class StatusItem implements Parcelable {
        @JvmField
        @NotNull
        public static final Parcelable.Creator<StatusItem> CREATOR = Parcels.creator(AdvertsItem$StatusItem$Companion$CREATOR$1.INSTANCE);
        @NotNull
        public static final Companion Companion = new Companion(null);
        @SerializedName("title")
        @NotNull
        private final String title;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/remote/model/user_profile/items/AdvertsItem$StatusItem$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/remote/model/user_profile/items/AdvertsItem$StatusItem;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "profile_release"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(j jVar) {
                this();
            }
        }

        public StatusItem(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "title");
            this.title = str;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @NotNull
        public final String getTitle() {
            return this.title;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "dest");
            parcel.writeString(this.title);
        }
    }

    public AdvertsItem(@NotNull Status status2) {
        Intrinsics.checkNotNullParameter(status2, "status");
        this.status = status2;
    }

    @NotNull
    public final Status getStatus() {
        return this.status;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        parcel.writeParcelable(this.status, i);
    }
}
