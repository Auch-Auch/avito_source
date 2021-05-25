package com.avito.android.remote.model.messenger;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.model.Action;
import com.avito.android.util.Parcels;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\b\u0018\u0000 $2\u00020\u0001:\u0001$B\u001b\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\"\u0010#J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J(\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000eHÆ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0004J\u001a\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019HÖ\u0003¢\u0006\u0004\b\u001c\u0010\u001dR\u001b\u0010\u0011\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u001e\u001a\u0004\b\u001f\u0010\rR\u001b\u0010\u0012\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010 \u001a\u0004\b!\u0010\u0010¨\u0006%"}, d2 = {"Lcom/avito/android/remote/model/messenger/PublicProfile;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "dest", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/model/messenger/ChatAvatar;", "component1", "()Lcom/avito/android/remote/model/messenger/ChatAvatar;", "Lcom/avito/android/remote/model/Action;", "component2", "()Lcom/avito/android/remote/model/Action;", "avatar", "action", "copy", "(Lcom/avito/android/remote/model/messenger/ChatAvatar;Lcom/avito/android/remote/model/Action;)Lcom/avito/android/remote/model/messenger/PublicProfile;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/avito/android/remote/model/messenger/ChatAvatar;", "getAvatar", "Lcom/avito/android/remote/model/Action;", "getAction", "<init>", "(Lcom/avito/android/remote/model/messenger/ChatAvatar;Lcom/avito/android/remote/model/Action;)V", "Companion", "models_release"}, k = 1, mv = {1, 4, 2})
public final class PublicProfile implements Parcelable {
    @JvmField
    @NotNull
    public static final Parcelable.Creator<PublicProfile> CREATOR = Parcels.creator(PublicProfile$Companion$CREATOR$1.INSTANCE);
    @NotNull
    public static final Companion Companion = new Companion(null);
    @Nullable
    private final Action action;
    @Nullable
    private final ChatAvatar avatar;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/remote/model/messenger/PublicProfile$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/remote/model/messenger/PublicProfile;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(j jVar) {
            this();
        }
    }

    public PublicProfile(@Nullable ChatAvatar chatAvatar, @Nullable Action action2) {
        this.avatar = chatAvatar;
        this.action = action2;
    }

    public static /* synthetic */ PublicProfile copy$default(PublicProfile publicProfile, ChatAvatar chatAvatar, Action action2, int i, Object obj) {
        if ((i & 1) != 0) {
            chatAvatar = publicProfile.avatar;
        }
        if ((i & 2) != 0) {
            action2 = publicProfile.action;
        }
        return publicProfile.copy(chatAvatar, action2);
    }

    @Nullable
    public final ChatAvatar component1() {
        return this.avatar;
    }

    @Nullable
    public final Action component2() {
        return this.action;
    }

    @NotNull
    public final PublicProfile copy(@Nullable ChatAvatar chatAvatar, @Nullable Action action2) {
        return new PublicProfile(chatAvatar, action2);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.lang.Object
    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PublicProfile)) {
            return false;
        }
        PublicProfile publicProfile = (PublicProfile) obj;
        return Intrinsics.areEqual(this.avatar, publicProfile.avatar) && Intrinsics.areEqual(this.action, publicProfile.action);
    }

    @Nullable
    public final Action getAction() {
        return this.action;
    }

    @Nullable
    public final ChatAvatar getAvatar() {
        return this.avatar;
    }

    @Override // java.lang.Object
    public int hashCode() {
        ChatAvatar chatAvatar = this.avatar;
        int i = 0;
        int hashCode = (chatAvatar != null ? chatAvatar.hashCode() : 0) * 31;
        Action action2 = this.action;
        if (action2 != null) {
            i = action2.hashCode();
        }
        return hashCode + i;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("PublicProfile(avatar=");
        L.append(this.avatar);
        L.append(", action=");
        L.append(this.action);
        L.append(")");
        return L.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        parcel.writeParcelable(this.avatar, i);
        parcel.writeParcelable(this.action, i);
    }
}
