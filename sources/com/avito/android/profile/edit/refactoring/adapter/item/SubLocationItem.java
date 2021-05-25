package com.avito.android.profile.edit.refactoring.adapter.item;

import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.profile.edit.refactoring.adapter.EditProfileItem;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.NameIdEntity;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u000e\u0018\u0000 -2\u00020\u00012\u00020\u0002:\u0001-B3\u0012\u0006\u0010%\u001a\u00020 \u0012\u0006\u0010\u001f\u001a\u00020\u001a\u0012\u0006\u0010*\u001a\u00020\u0005\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b+\u0010,J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rR$\u0010\u0015\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u000b\u001a\u00020\n8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0019\u0010\u001f\u001a\u00020\u001a8\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001c\u0010%\u001a\u00020 8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u0019\u0010*\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)¨\u0006."}, d2 = {"Lcom/avito/android/profile/edit/refactoring/adapter/item/SubLocationItem;", "Lcom/avito/android/profile/edit/refactoring/adapter/EditProfileItem;", "Lcom/avito/android/profile/edit/refactoring/adapter/item/ErrorDisplay;", "Landroid/os/Parcel;", "dest", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "hasError", "changeHasError", "(Z)Lcom/avito/android/profile/edit/refactoring/adapter/EditProfileItem;", "Lcom/avito/android/remote/model/NameIdEntity;", "d", "Lcom/avito/android/remote/model/NameIdEntity;", "getSubLocation", "()Lcom/avito/android/remote/model/NameIdEntity;", "setSubLocation", "(Lcom/avito/android/remote/model/NameIdEntity;)V", "subLocation", "e", "Z", "getHasError", "()Z", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "title", "", AuthSource.SEND_ABUSE, "J", "getId", "()J", "id", "c", "I", "getSubLocationType", "()I", "subLocationType", "<init>", "(JLjava/lang/String;ILcom/avito/android/remote/model/NameIdEntity;Z)V", "Companion", "profile_release"}, k = 1, mv = {1, 4, 2})
public final class SubLocationItem implements EditProfileItem, ErrorDisplay {
    @JvmField
    @NotNull
    public static final Parcelable.Creator<SubLocationItem> CREATOR = Parcels.creator(a.a);
    @NotNull
    public static final Companion Companion = new Companion(null);
    public final long a;
    @NotNull
    public final String b;
    public final int c;
    @Nullable
    public NameIdEntity d;
    public final boolean e;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/profile/edit/refactoring/adapter/item/SubLocationItem$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/profile/edit/refactoring/adapter/item/SubLocationItem;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "profile_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    public static final class a extends Lambda implements Function1<Parcel, SubLocationItem> {
        public static final a a = new a();

        public a() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public SubLocationItem invoke(Parcel parcel) {
            Parcel parcel2 = parcel;
            Intrinsics.checkNotNullParameter(parcel2, "$receiver");
            long readLong = parcel2.readLong();
            String u2 = a2.b.a.a.a.u2(parcel2, "readString()!!");
            int readInt = parcel2.readInt();
            Object readValue = parcel2.readValue(NameIdEntity.class.getClassLoader());
            if (!(readValue instanceof NameIdEntity)) {
                readValue = null;
            }
            return new SubLocationItem(readLong, u2, readInt, (NameIdEntity) readValue, ParcelsKt.readBool(parcel2));
        }
    }

    public SubLocationItem(long j, @NotNull String str, int i, @Nullable NameIdEntity nameIdEntity, boolean z) {
        Intrinsics.checkNotNullParameter(str, "title");
        this.a = j;
        this.b = str;
        this.c = i;
        this.d = nameIdEntity;
        this.e = z;
    }

    @Override // com.avito.android.profile.edit.refactoring.adapter.item.ErrorDisplay
    @NotNull
    public EditProfileItem changeHasError(boolean z) {
        return new SubLocationItem(getId(), this.b, this.c, this.d, z);
    }

    @Override // com.avito.android.profile.edit.refactoring.adapter.EditProfileItem, android.os.Parcelable
    public int describeContents() {
        return EditProfileItem.DefaultImpls.describeContents(this);
    }

    @Override // com.avito.android.profile.edit.refactoring.adapter.item.ErrorDisplay
    public boolean getHasError() {
        return this.e;
    }

    @Override // com.avito.konveyor.blueprint.Item
    public long getId() {
        return this.a;
    }

    @Nullable
    public final NameIdEntity getSubLocation() {
        return this.d;
    }

    public final int getSubLocationType() {
        return this.c;
    }

    @NotNull
    public final String getTitle() {
        return this.b;
    }

    @Override // com.avito.android.profile.edit.refactoring.adapter.EditProfileItem
    public boolean hasBottomDivider() {
        return EditProfileItem.DefaultImpls.hasBottomDivider(this);
    }

    @Override // com.avito.android.profile.edit.refactoring.adapter.EditProfileItem
    public boolean hasTopDivider() {
        return EditProfileItem.DefaultImpls.hasTopDivider(this);
    }

    public final void setSubLocation(@Nullable NameIdEntity nameIdEntity) {
        this.d = nameIdEntity;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        parcel.writeLong(getId());
        parcel.writeString(this.b);
        parcel.writeInt(this.c);
        ParcelsKt.writeNullableValue(parcel, this.d);
        ParcelsKt.writeBool(parcel, getHasError());
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SubLocationItem(long j, String str, int i, NameIdEntity nameIdEntity, boolean z, int i2, j jVar) {
        this(j, str, i, nameIdEntity, (i2 & 16) != 0 ? false : z);
    }
}
