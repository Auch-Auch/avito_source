package com.avito.android.profile.edit.refactoring.adapter.item;

import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.profile.edit.refactoring.adapter.EditProfileItem;
import com.avito.android.profile.edit.refactoring.avatar.ProfileAvatar;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Parcels;
import com.avito.android.util.ParcelsKt;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0012\u0018\u0000 \"2\u00020\u0001:\u0001\"B#\u0012\u0006\u0010\u0016\u001a\u00020\u0011\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\u0019\u001a\u00020\r¢\u0006\u0004\b \u0010!J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0010\u0010\u000fR\u001c\u0010\u0016\u001a\u00020\u00118\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\"\u0010\u0019\u001a\u00020\r8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u000f\"\u0004\b\u001a\u0010\u001bR\u001b\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f¨\u0006#"}, d2 = {"Lcom/avito/android/profile/edit/refactoring/adapter/item/AvatarItem;", "Lcom/avito/android/profile/edit/refactoring/adapter/EditProfileItem;", "Landroid/os/Parcel;", "dest", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/profile/edit/refactoring/avatar/ProfileAvatar;", "avatar", "changeAvatar", "(Lcom/avito/android/profile/edit/refactoring/avatar/ProfileAvatar;)Lcom/avito/android/profile/edit/refactoring/adapter/item/AvatarItem;", "", "hasBottomDivider", "()Z", "hasTopDivider", "", AuthSource.SEND_ABUSE, "J", "getId", "()J", "id", "c", "Z", "isChanged", "setChanged", "(Z)V", AuthSource.BOOKING_ORDER, "Lcom/avito/android/profile/edit/refactoring/avatar/ProfileAvatar;", "getAvatar", "()Lcom/avito/android/profile/edit/refactoring/avatar/ProfileAvatar;", "<init>", "(JLcom/avito/android/profile/edit/refactoring/avatar/ProfileAvatar;Z)V", "Companion", "profile_release"}, k = 1, mv = {1, 4, 2})
public final class AvatarItem implements EditProfileItem {
    @JvmField
    @NotNull
    public static final Parcelable.Creator<AvatarItem> CREATOR = Parcels.creator(a.a);
    @NotNull
    public static final Companion Companion = new Companion(null);
    public final long a;
    @Nullable
    public final ProfileAvatar b;
    public boolean c;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/profile/edit/refactoring/adapter/item/AvatarItem$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/profile/edit/refactoring/adapter/item/AvatarItem;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "profile_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    public static final class a extends Lambda implements Function1<Parcel, AvatarItem> {
        public static final a a = new a();

        public a() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public AvatarItem invoke(Parcel parcel) {
            Parcel parcel2 = parcel;
            Intrinsics.checkNotNullParameter(parcel2, "$receiver");
            long readLong = parcel2.readLong();
            Object readValue = parcel2.readValue(ProfileAvatar.class.getClassLoader());
            if (!(readValue instanceof ProfileAvatar)) {
                readValue = null;
            }
            return new AvatarItem(readLong, (ProfileAvatar) readValue, ParcelsKt.readBool(parcel2));
        }
    }

    public AvatarItem(long j, @Nullable ProfileAvatar profileAvatar, boolean z) {
        this.a = j;
        this.b = profileAvatar;
        this.c = z;
    }

    @NotNull
    public final AvatarItem changeAvatar(@Nullable ProfileAvatar profileAvatar) {
        return new AvatarItem(getId(), profileAvatar, this.c);
    }

    @Override // com.avito.android.profile.edit.refactoring.adapter.EditProfileItem, android.os.Parcelable
    public int describeContents() {
        return EditProfileItem.DefaultImpls.describeContents(this);
    }

    @Nullable
    public final ProfileAvatar getAvatar() {
        return this.b;
    }

    @Override // com.avito.konveyor.blueprint.Item
    public long getId() {
        return this.a;
    }

    @Override // com.avito.android.profile.edit.refactoring.adapter.EditProfileItem
    public boolean hasBottomDivider() {
        return false;
    }

    @Override // com.avito.android.profile.edit.refactoring.adapter.EditProfileItem
    public boolean hasTopDivider() {
        return false;
    }

    public final boolean isChanged() {
        return this.c;
    }

    public final void setChanged(boolean z) {
        this.c = z;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        parcel.writeLong(getId());
        parcel.writeValue(this.b);
        ParcelsKt.writeBool(parcel, this.c);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AvatarItem(long j, ProfileAvatar profileAvatar, boolean z, int i, j jVar) {
        this(j, profileAvatar, (i & 4) != 0 ? false : z);
    }
}
