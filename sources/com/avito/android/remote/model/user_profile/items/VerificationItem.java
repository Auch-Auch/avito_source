package com.avito.android.remote.model.user_profile.items;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B1\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\u0006\u0010\u0013\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015¢\u0006\u0004\b\u001b\u0010\u001cJ \u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bR\u001e\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u00020\t8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0014\u0010\rR\"\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00158\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001d"}, d2 = {"Lcom/avito/android/remote/model/user_profile/items/VerificationItem;", "Lcom/avito/android/remote/model/user_profile/items/UserProfileItem;", "Landroid/os/Parcel;", "parcel", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "description", "Ljava/lang/String;", "getDescription", "()Ljava/lang/String;", "Lcom/avito/android/remote/model/user_profile/items/VerificationBanner;", "banner", "Lcom/avito/android/remote/model/user_profile/items/VerificationBanner;", "getBanner", "()Lcom/avito/android/remote/model/user_profile/items/VerificationBanner;", "title", "getTitle", "", "Lcom/avito/android/remote/model/user_profile/items/VerificationWay;", "list", "Ljava/util/List;", "getList", "()Ljava/util/List;", "<init>", "(Lcom/avito/android/remote/model/user_profile/items/VerificationBanner;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "profile_release"}, k = 1, mv = {1, 4, 2})
public final class VerificationItem extends UserProfileItem {
    public static final Parcelable.Creator<VerificationItem> CREATOR = new Creator();
    @SerializedName("banner")
    @Nullable
    private final VerificationBanner banner;
    @SerializedName("description")
    @Nullable
    private final String description;
    @SerializedName("list")
    @NotNull
    private final List<VerificationWay> list;
    @SerializedName("title")
    @NotNull
    private final String title;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<VerificationItem> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final VerificationItem createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            VerificationBanner createFromParcel = parcel.readInt() != 0 ? VerificationBanner.CREATOR.createFromParcel(parcel) : null;
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            while (readInt != 0) {
                arrayList.add(VerificationWay.CREATOR.createFromParcel(parcel));
                readInt--;
            }
            return new VerificationItem(createFromParcel, readString, readString2, arrayList);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final VerificationItem[] newArray(int i) {
            return new VerificationItem[i];
        }
    }

    public VerificationItem(@Nullable VerificationBanner verificationBanner, @NotNull String str, @Nullable String str2, @NotNull List<VerificationWay> list2) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(list2, "list");
        this.banner = verificationBanner;
        this.title = str;
        this.description = str2;
        this.list = list2;
    }

    @Nullable
    public final VerificationBanner getBanner() {
        return this.banner;
    }

    @Nullable
    public final String getDescription() {
        return this.description;
    }

    @NotNull
    public final List<VerificationWay> getList() {
        return this.list;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        VerificationBanner verificationBanner = this.banner;
        if (verificationBanner != null) {
            parcel.writeInt(1);
            verificationBanner.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        parcel.writeString(this.title);
        parcel.writeString(this.description);
        Iterator n0 = a.n0(this.list, parcel);
        while (n0.hasNext()) {
            ((VerificationWay) n0.next()).writeToParcel(parcel, 0);
        }
    }
}
