package com.avito.android.authorization.login_protection.adapter.phone;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.authorization.login_protection.adapter.LoginProtectionListItem;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0014\b\u0007\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0010\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u0019\u0010\u0010\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0014\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004R\"\u0010\u0019\u001a\u00020\u000b8\u0016@\u0016X\u0004¢\u0006\u0012\n\u0004\b\u0015\u0010\r\u0012\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0016\u0010\u000fR\u0019\u0010\u001c\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u0012\u001a\u0004\b\u001b\u0010\u0004¨\u0006\u001f"}, d2 = {"Lcom/avito/android/authorization/login_protection/adapter/phone/PhoneItem;", "Lcom/avito/android/authorization/login_protection/adapter/LoginProtectionListItem;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getFormattedValue", "()Ljava/lang/String;", "formattedValue", "d", "I", "getHighlightEnd", "highlightEnd", AuthSource.SEND_ABUSE, "getStringId", "getStringId$annotations", "()V", "stringId", "c", "getHighlightStart", "highlightStart", "<init>", "(Ljava/lang/String;II)V", "authorization_release"}, k = 1, mv = {1, 4, 2})
public final class PhoneItem implements LoginProtectionListItem {
    public static final Parcelable.Creator<PhoneItem> CREATOR = new Creator();
    @NotNull
    public final String a;
    @NotNull
    public final String b;
    public final int c;
    public final int d;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<PhoneItem> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final PhoneItem createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new PhoneItem(parcel.readString(), parcel.readInt(), parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final PhoneItem[] newArray(int i) {
            return new PhoneItem[i];
        }
    }

    public PhoneItem(@NotNull String str, int i, int i2) {
        Intrinsics.checkNotNullParameter(str, "formattedValue");
        this.b = str;
        this.c = i;
        this.d = i2;
        this.a = a.I2("UUID.randomUUID().toString()");
    }

    public static /* synthetic */ void getStringId$annotations() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NotNull
    public final String getFormattedValue() {
        return this.b;
    }

    public final int getHighlightEnd() {
        return this.d;
    }

    public final int getHighlightStart() {
        return this.c;
    }

    @Override // com.avito.conveyor_item.Item, com.avito.konveyor.blueprint.Item
    public long getId() {
        return LoginProtectionListItem.DefaultImpls.getId(this);
    }

    @Override // com.avito.conveyor_item.Item
    @NotNull
    public String getStringId() {
        return this.a;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.b);
        parcel.writeInt(this.c);
        parcel.writeInt(this.d);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PhoneItem(String str, int i, int i2, int i3, j jVar) {
        this(str, (i3 & 2) != 0 ? -1 : i, (i3 & 4) != 0 ? -1 : i2);
    }
}
