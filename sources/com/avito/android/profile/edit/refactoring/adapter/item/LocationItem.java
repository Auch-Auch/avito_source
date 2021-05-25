package com.avito.android.profile.edit.refactoring.adapter.item;

import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.profile.edit.refactoring.adapter.EditProfileItem;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Location;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 \"2\u00020\u00012\u00020\u0002:\u0001\"B#\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0014\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b \u0010!J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rR\u001c\u0010\u0013\u001a\u00020\u000e8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R$\u0010\u001b\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\u000b\u001a\u00020\n8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f¨\u0006#"}, d2 = {"Lcom/avito/android/profile/edit/refactoring/adapter/item/LocationItem;", "Lcom/avito/android/profile/edit/refactoring/adapter/EditProfileItem;", "Lcom/avito/android/profile/edit/refactoring/adapter/item/ErrorDisplay;", "Landroid/os/Parcel;", "dest", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "hasError", "changeHasError", "(Z)Lcom/avito/android/profile/edit/refactoring/adapter/EditProfileItem;", "", AuthSource.SEND_ABUSE, "J", "getId", "()J", "id", "Lcom/avito/android/remote/model/Location;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/remote/model/Location;", "getLocation", "()Lcom/avito/android/remote/model/Location;", "setLocation", "(Lcom/avito/android/remote/model/Location;)V", "location", "c", "Z", "getHasError", "()Z", "<init>", "(JLcom/avito/android/remote/model/Location;Z)V", "Companion", "profile_release"}, k = 1, mv = {1, 4, 2})
public final class LocationItem implements EditProfileItem, ErrorDisplay {
    @JvmField
    @NotNull
    public static final Parcelable.Creator<LocationItem> CREATOR = Parcels.creator(a.a);
    @NotNull
    public static final Companion Companion = new Companion(null);
    public final long a;
    @Nullable
    public Location b;
    public final boolean c;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/profile/edit/refactoring/adapter/item/LocationItem$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/profile/edit/refactoring/adapter/item/LocationItem;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "profile_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    public static final class a extends Lambda implements Function1<Parcel, LocationItem> {
        public static final a a = new a();

        public a() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public LocationItem invoke(Parcel parcel) {
            Parcel parcel2 = parcel;
            Intrinsics.checkNotNullParameter(parcel2, "$receiver");
            long readLong = parcel2.readLong();
            Object readValue = parcel2.readValue(Location.class.getClassLoader());
            if (!(readValue instanceof Location)) {
                readValue = null;
            }
            return new LocationItem(readLong, (Location) readValue, ParcelsKt.readBool(parcel2));
        }
    }

    public LocationItem(long j, @Nullable Location location, boolean z) {
        this.a = j;
        this.b = location;
        this.c = z;
    }

    @Override // com.avito.android.profile.edit.refactoring.adapter.item.ErrorDisplay
    @NotNull
    public EditProfileItem changeHasError(boolean z) {
        return new LocationItem(getId(), this.b, z);
    }

    @Override // com.avito.android.profile.edit.refactoring.adapter.EditProfileItem, android.os.Parcelable
    public int describeContents() {
        return EditProfileItem.DefaultImpls.describeContents(this);
    }

    @Override // com.avito.android.profile.edit.refactoring.adapter.item.ErrorDisplay
    public boolean getHasError() {
        return this.c;
    }

    @Override // com.avito.konveyor.blueprint.Item
    public long getId() {
        return this.a;
    }

    @Nullable
    public final Location getLocation() {
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

    public final void setLocation(@Nullable Location location) {
        this.b = location;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        parcel.writeLong(getId());
        ParcelsKt.writeNullableValue(parcel, this.b);
        ParcelsKt.writeBool(parcel, getHasError());
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LocationItem(long j, Location location, boolean z, int i, j jVar) {
        this(j, location, (i & 4) != 0 ? false : z);
    }
}
