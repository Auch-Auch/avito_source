package ru.avito.messenger.api.entity;

import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.model.SimpleAction;
import com.avito.android.util.Parcels;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u001b\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nR\u001e\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0018"}, d2 = {"Lru/avito/messenger/api/entity/PublicProfile;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "dest", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/model/SimpleAction;", "action", "Lcom/avito/android/remote/model/SimpleAction;", "getAction", "()Lcom/avito/android/remote/model/SimpleAction;", "Lru/avito/messenger/api/entity/Avatar;", "avatar", "Lru/avito/messenger/api/entity/Avatar;", "getAvatar", "()Lru/avito/messenger/api/entity/Avatar;", "<init>", "(Lru/avito/messenger/api/entity/Avatar;Lcom/avito/android/remote/model/SimpleAction;)V", "Companion", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class PublicProfile implements Parcelable {
    @JvmField
    @NotNull
    public static final Parcelable.Creator<PublicProfile> CREATOR = Parcels.creator(PublicProfile$Companion$CREATOR$1.INSTANCE);
    @NotNull
    public static final Companion Companion = new Companion(null);
    @SerializedName("deepLink")
    @Nullable
    private final SimpleAction action;
    @SerializedName("avatar")
    @Nullable
    private final Avatar avatar;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lru/avito/messenger/api/entity/PublicProfile$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lru/avito/messenger/api/entity/PublicProfile;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    public PublicProfile(@Nullable Avatar avatar2, @Nullable SimpleAction simpleAction) {
        this.avatar = avatar2;
        this.action = simpleAction;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final SimpleAction getAction() {
        return this.action;
    }

    @Nullable
    public final Avatar getAvatar() {
        return this.avatar;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        parcel.writeParcelable(this.avatar, i);
        parcel.writeParcelable(this.action, i);
    }
}
