package com.avito.android.shop_settings_select;

import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.auth.AuthSource;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0013\b\u0007\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u001c\u001a\u00020\f\u0012\u0006\u0010\u0016\u001a\u00020\f\u0012\u0006\u0010\u0019\u001a\u00020\f\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0016\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0019\u0010\u0019\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0013\u001a\u0004\b\u0018\u0010\u0015R\u0019\u0010\u001c\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u0013\u001a\u0004\b\u001b\u0010\u0015¨\u0006\u001f"}, d2 = {"Lcom/avito/android/shop_settings_select/ShopSettingsSelectResult;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "", "d", "Ljava/util/List;", "getSelectedParentIds", "()Ljava/util/List;", "selectedParentIds", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getSelectedId", "()Ljava/lang/String;", "selectedId", "c", "getSelectedText", "selectedText", AuthSource.SEND_ABUSE, "getInputId", "inputId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "service-subscription_release"}, k = 1, mv = {1, 4, 2})
public final class ShopSettingsSelectResult implements Parcelable {
    public static final Parcelable.Creator<ShopSettingsSelectResult> CREATOR = new Creator();
    @NotNull
    public final String a;
    @NotNull
    public final String b;
    @NotNull
    public final String c;
    @NotNull
    public final List<String> d;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<ShopSettingsSelectResult> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ShopSettingsSelectResult createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new ShopSettingsSelectResult(parcel.readString(), parcel.readString(), parcel.readString(), parcel.createStringArrayList());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ShopSettingsSelectResult[] newArray(int i) {
            return new ShopSettingsSelectResult[i];
        }
    }

    public ShopSettingsSelectResult(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull List<String> list) {
        Intrinsics.checkNotNullParameter(str, "inputId");
        Intrinsics.checkNotNullParameter(str2, "selectedId");
        Intrinsics.checkNotNullParameter(str3, "selectedText");
        Intrinsics.checkNotNullParameter(list, "selectedParentIds");
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = list;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NotNull
    public final String getInputId() {
        return this.a;
    }

    @NotNull
    public final String getSelectedId() {
        return this.b;
    }

    @NotNull
    public final List<String> getSelectedParentIds() {
        return this.d;
    }

    @NotNull
    public final String getSelectedText() {
        return this.c;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeStringList(this.d);
    }
}
