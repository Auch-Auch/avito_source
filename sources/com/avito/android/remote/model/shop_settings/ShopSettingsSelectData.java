package com.avito.android.remote.model.shop_settings;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0019\u001a\u00020\u000b\u0012\u0006\u0010\u0010\u001a\u00020\u000b\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0012\u0012\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0012\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001b\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0010\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u000fR\u001f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00128\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00128\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0014\u001a\u0004\b\u0018\u0010\u0016R\u0019\u0010\u0019\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\r\u001a\u0004\b\u001a\u0010\u000f¨\u0006\u001d"}, d2 = {"Lcom/avito/android/remote/model/shop_settings/ShopSettingsSelectData;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "selectedId", "Ljava/lang/String;", "getSelectedId", "()Ljava/lang/String;", "selectContext", "getSelectContext", "", "checkedIds", "Ljava/util/List;", "getCheckedIds", "()Ljava/util/List;", "selectedParentIds", "getSelectedParentIds", "inputId", "getInputId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;)V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class ShopSettingsSelectData implements Parcelable {
    public static final Parcelable.Creator<ShopSettingsSelectData> CREATOR = new Creator();
    @NotNull
    private final List<String> checkedIds;
    @NotNull
    private final String inputId;
    @NotNull
    private final String selectContext;
    @Nullable
    private final String selectedId;
    @NotNull
    private final List<String> selectedParentIds;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<ShopSettingsSelectData> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ShopSettingsSelectData createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new ShopSettingsSelectData(parcel.readString(), parcel.readString(), parcel.createStringArrayList(), parcel.createStringArrayList(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ShopSettingsSelectData[] newArray(int i) {
            return new ShopSettingsSelectData[i];
        }
    }

    public ShopSettingsSelectData(@NotNull String str, @NotNull String str2, @NotNull List<String> list, @NotNull List<String> list2, @Nullable String str3) {
        Intrinsics.checkNotNullParameter(str, "inputId");
        Intrinsics.checkNotNullParameter(str2, "selectContext");
        Intrinsics.checkNotNullParameter(list, "checkedIds");
        Intrinsics.checkNotNullParameter(list2, "selectedParentIds");
        this.inputId = str;
        this.selectContext = str2;
        this.checkedIds = list;
        this.selectedParentIds = list2;
        this.selectedId = str3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NotNull
    public final List<String> getCheckedIds() {
        return this.checkedIds;
    }

    @NotNull
    public final String getInputId() {
        return this.inputId;
    }

    @NotNull
    public final String getSelectContext() {
        return this.selectContext;
    }

    @Nullable
    public final String getSelectedId() {
        return this.selectedId;
    }

    @NotNull
    public final List<String> getSelectedParentIds() {
        return this.selectedParentIds;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.inputId);
        parcel.writeString(this.selectContext);
        parcel.writeStringList(this.checkedIds);
        parcel.writeStringList(this.selectedParentIds);
        parcel.writeString(this.selectedId);
    }
}
