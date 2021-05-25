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
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\n\u001a\u00020\t\u0012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013¢\u0006\u0004\b\u0019\u0010\u001aJ \u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\n\u001a\u00020\t8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000f\u001a\u00020\u000e8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\"\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001b"}, d2 = {"Lcom/avito/android/remote/model/user_profile/items/VerificationPlatformItem;", "Lcom/avito/android/remote/model/user_profile/items/UserProfileItem;", "Landroid/os/Parcel;", "parcel", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/model/user_profile/items/VerificationPlatformAction;", "action", "Lcom/avito/android/remote/model/user_profile/items/VerificationPlatformAction;", "getAction", "()Lcom/avito/android/remote/model/user_profile/items/VerificationPlatformAction;", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "", "Lcom/avito/android/remote/model/user_profile/items/VerificationPlatformStatus;", "statuses", "Ljava/util/List;", "getStatuses", "()Ljava/util/List;", "<init>", "(Ljava/lang/String;Lcom/avito/android/remote/model/user_profile/items/VerificationPlatformAction;Ljava/util/List;)V", "profile_release"}, k = 1, mv = {1, 4, 2})
public final class VerificationPlatformItem extends UserProfileItem {
    public static final Parcelable.Creator<VerificationPlatformItem> CREATOR = new Creator();
    @SerializedName("action")
    @NotNull
    private final VerificationPlatformAction action;
    @SerializedName("statuses")
    @NotNull
    private final List<VerificationPlatformStatus> statuses;
    @SerializedName("title")
    @NotNull
    private final String title;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<VerificationPlatformItem> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final VerificationPlatformItem createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            String readString = parcel.readString();
            VerificationPlatformAction createFromParcel = VerificationPlatformAction.CREATOR.createFromParcel(parcel);
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            while (readInt != 0) {
                arrayList.add((VerificationPlatformStatus) parcel.readParcelable(VerificationPlatformItem.class.getClassLoader()));
                readInt--;
            }
            return new VerificationPlatformItem(readString, createFromParcel, arrayList);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final VerificationPlatformItem[] newArray(int i) {
            return new VerificationPlatformItem[i];
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.util.List<? extends com.avito.android.remote.model.user_profile.items.VerificationPlatformStatus> */
    /* JADX WARN: Multi-variable type inference failed */
    public VerificationPlatformItem(@NotNull String str, @NotNull VerificationPlatformAction verificationPlatformAction, @NotNull List<? extends VerificationPlatformStatus> list) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(verificationPlatformAction, "action");
        Intrinsics.checkNotNullParameter(list, "statuses");
        this.title = str;
        this.action = verificationPlatformAction;
        this.statuses = list;
    }

    @NotNull
    public final VerificationPlatformAction getAction() {
        return this.action;
    }

    @NotNull
    public final List<VerificationPlatformStatus> getStatuses() {
        return this.statuses;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.title);
        this.action.writeToParcel(parcel, 0);
        Iterator n0 = a.n0(this.statuses, parcel);
        while (n0.hasNext()) {
            parcel.writeParcelable((VerificationPlatformStatus) n0.next(), i);
        }
    }
}
