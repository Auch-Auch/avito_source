package com.avito.android.remote.model.user_profile.items;

import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.model.Action;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0013\u0010\u0014J \u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bR\u001e\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000f\u001a\u00020\u000e8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Lcom/avito/android/remote/model/user_profile/items/ShopSettingsItem;", "Lcom/avito/android/remote/model/user_profile/items/UserProfileItem;", "Landroid/os/Parcel;", "parcel", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/model/Action;", "action", "Lcom/avito/android/remote/model/Action;", "getAction", "()Lcom/avito/android/remote/model/Action;", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;Lcom/avito/android/remote/model/Action;)V", "profile_release"}, k = 1, mv = {1, 4, 2})
public final class ShopSettingsItem extends UserProfileItem {
    public static final Parcelable.Creator<ShopSettingsItem> CREATOR = new Creator();
    @SerializedName("action")
    @Nullable
    private final Action action;
    @SerializedName("title")
    @NotNull
    private final String title;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<ShopSettingsItem> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ShopSettingsItem createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new ShopSettingsItem(parcel.readString(), (Action) parcel.readParcelable(ShopSettingsItem.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ShopSettingsItem[] newArray(int i) {
            return new ShopSettingsItem[i];
        }
    }

    public ShopSettingsItem(@NotNull String str, @Nullable Action action2) {
        Intrinsics.checkNotNullParameter(str, "title");
        this.title = str;
        this.action = action2;
    }

    @Nullable
    public final Action getAction() {
        return this.action;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.title);
        parcel.writeParcelable(this.action, i);
    }
}
