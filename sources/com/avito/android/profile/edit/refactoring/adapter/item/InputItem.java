package com.avito.android.profile.edit.refactoring.adapter.item;

import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.profile.edit.refactoring.adapter.EditProfileItem;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Parcels;
import com.avito.android.util.ParcelsKt;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u000e\u0018\u0000 '2\u00020\u00012\u00020\u0002:\u0001'B)\u0012\u0006\u0010\u001f\u001a\u00020\u001a\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u0012\u0006\u0010$\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b%\u0010&J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rR\u0019\u0010\u0013\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\"\u0010\u000b\u001a\u00020\n8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001f\u001a\u00020\u001a8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\"\u0010$\u001a\u00020\u000e8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b \u0010\u0010\u001a\u0004\b!\u0010\u0012\"\u0004\b\"\u0010#¨\u0006("}, d2 = {"Lcom/avito/android/profile/edit/refactoring/adapter/item/InputItem;", "Lcom/avito/android/profile/edit/refactoring/adapter/EditProfileItem;", "Lcom/avito/android/profile/edit/refactoring/adapter/item/ErrorDisplay;", "Landroid/os/Parcel;", "dest", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "hasError", "changeHasError", "(Z)Lcom/avito/android/profile/edit/refactoring/adapter/EditProfileItem;", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "title", "d", "Z", "getHasError", "()Z", "setHasError", "(Z)V", "", AuthSource.SEND_ABUSE, "J", "getId", "()J", "id", "c", "getValue", "setValue", "(Ljava/lang/String;)V", "value", "<init>", "(JLjava/lang/String;Ljava/lang/String;Z)V", "Companion", "profile_release"}, k = 1, mv = {1, 4, 2})
public final class InputItem implements EditProfileItem, ErrorDisplay {
    @JvmField
    @NotNull
    public static final Parcelable.Creator<InputItem> CREATOR = Parcels.creator(a.a);
    @NotNull
    public static final Companion Companion = new Companion(null);
    public final long a;
    @NotNull
    public final String b;
    @NotNull
    public String c;
    public boolean d;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/profile/edit/refactoring/adapter/item/InputItem$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/profile/edit/refactoring/adapter/item/InputItem;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "profile_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    public static final class a extends Lambda implements Function1<Parcel, InputItem> {
        public static final a a = new a();

        public a() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public InputItem invoke(Parcel parcel) {
            Parcel parcel2 = parcel;
            Intrinsics.checkNotNullParameter(parcel2, "$receiver");
            return new InputItem(parcel2.readLong(), a2.b.a.a.a.u2(parcel2, "readString()!!"), a2.b.a.a.a.u2(parcel2, "readString()!!"), ParcelsKt.readBool(parcel2));
        }
    }

    public InputItem(long j, @NotNull String str, @NotNull String str2, boolean z) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "value");
        this.a = j;
        this.b = str;
        this.c = str2;
        this.d = z;
    }

    @Override // com.avito.android.profile.edit.refactoring.adapter.item.ErrorDisplay
    @NotNull
    public EditProfileItem changeHasError(boolean z) {
        return new InputItem(getId(), this.b, this.c, z);
    }

    @Override // com.avito.android.profile.edit.refactoring.adapter.EditProfileItem, android.os.Parcelable
    public int describeContents() {
        return EditProfileItem.DefaultImpls.describeContents(this);
    }

    @Override // com.avito.android.profile.edit.refactoring.adapter.item.ErrorDisplay
    public boolean getHasError() {
        return this.d;
    }

    @Override // com.avito.konveyor.blueprint.Item
    public long getId() {
        return this.a;
    }

    @NotNull
    public final String getTitle() {
        return this.b;
    }

    @NotNull
    public final String getValue() {
        return this.c;
    }

    @Override // com.avito.android.profile.edit.refactoring.adapter.EditProfileItem
    public boolean hasBottomDivider() {
        return EditProfileItem.DefaultImpls.hasBottomDivider(this);
    }

    @Override // com.avito.android.profile.edit.refactoring.adapter.EditProfileItem
    public boolean hasTopDivider() {
        return EditProfileItem.DefaultImpls.hasTopDivider(this);
    }

    public void setHasError(boolean z) {
        this.d = z;
    }

    public final void setValue(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.c = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        parcel.writeLong(getId());
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        ParcelsKt.writeBool(parcel, getHasError());
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ InputItem(long j, String str, String str2, boolean z, int i, j jVar) {
        this(j, str, str2, (i & 8) != 0 ? false : z);
    }
}
