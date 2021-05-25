package com.avito.android.profile.edit.refactoring.adapter.item;

import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.profile.edit.refactoring.adapter.EditProfileItem;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Parcels;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0017\u0012\u0006\u0010\u0011\u001a\u00020\f\u0012\u0006\u0010\u0017\u001a\u00020\u0012¢\u0006\u0004\b\u0018\u0010\u0019J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bR\u001c\u0010\u0011\u001a\u00020\f8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0017\u001a\u00020\u00128\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001b"}, d2 = {"Lcom/avito/android/profile/edit/refactoring/adapter/item/ErrorLabelItem;", "Lcom/avito/android/profile/edit/refactoring/adapter/EditProfileItem;", "Landroid/os/Parcel;", "dest", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "hasTopDivider", "()Z", "", AuthSource.SEND_ABUSE, "J", "getId", "()J", "id", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getError", "()Ljava/lang/String;", "error", "<init>", "(JLjava/lang/String;)V", "Companion", "profile_release"}, k = 1, mv = {1, 4, 2})
public final class ErrorLabelItem implements EditProfileItem {
    @JvmField
    @NotNull
    public static final Parcelable.Creator<ErrorLabelItem> CREATOR = Parcels.creator(a.a);
    @NotNull
    public static final Companion Companion = new Companion(null);
    public final long a;
    @NotNull
    public final String b;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/profile/edit/refactoring/adapter/item/ErrorLabelItem$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/profile/edit/refactoring/adapter/item/ErrorLabelItem;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "profile_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    public static final class a extends Lambda implements Function1<Parcel, ErrorLabelItem> {
        public static final a a = new a();

        public a() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public ErrorLabelItem invoke(Parcel parcel) {
            Parcel parcel2 = parcel;
            Intrinsics.checkNotNullParameter(parcel2, "$receiver");
            return new ErrorLabelItem(parcel2.readLong(), a2.b.a.a.a.u2(parcel2, "readString()!!"));
        }
    }

    public ErrorLabelItem(long j, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "error");
        this.a = j;
        this.b = str;
    }

    @Override // com.avito.android.profile.edit.refactoring.adapter.EditProfileItem, android.os.Parcelable
    public int describeContents() {
        return EditProfileItem.DefaultImpls.describeContents(this);
    }

    @NotNull
    public final String getError() {
        return this.b;
    }

    @Override // com.avito.konveyor.blueprint.Item
    public long getId() {
        return this.a;
    }

    @Override // com.avito.android.profile.edit.refactoring.adapter.EditProfileItem
    public boolean hasBottomDivider() {
        return EditProfileItem.DefaultImpls.hasBottomDivider(this);
    }

    @Override // com.avito.android.profile.edit.refactoring.adapter.EditProfileItem
    public boolean hasTopDivider() {
        return false;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        parcel.writeLong(getId());
        parcel.writeString(this.b);
    }
}
