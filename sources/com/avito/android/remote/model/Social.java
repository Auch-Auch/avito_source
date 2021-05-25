package com.avito.android.remote.model;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.model.social.SocialNetwork;
import com.avito.android.remote.model.social.SocialNotification;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u000b\u0012\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR$\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\"\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u000e\u001a\u0004\b\u0013\u0010\u0010R\u001c\u0010\u0015\u001a\u00020\u00148\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0015\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcom/avito/android/remote/model/Social;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "Lcom/avito/android/remote/model/social/SocialNotification;", "notifications", "Ljava/util/List;", "getNotifications", "()Ljava/util/List;", "Lcom/avito/android/remote/model/social/SocialNetwork;", "socialNetworks", "getSocialNetworks", "", "isIncomplete", "Z", "()Z", "<init>", "(ZLjava/util/List;Ljava/util/List;)V", "api_release"}, k = 1, mv = {1, 4, 2})
public final class Social implements Parcelable {
    public static final Parcelable.Creator<Social> CREATOR = new Creator();
    @SerializedName("isIncomplete")
    private final boolean isIncomplete;
    @SerializedName("notifications")
    @Nullable
    private final List<SocialNotification> notifications;
    @SerializedName("list")
    @NotNull
    private final List<SocialNetwork> socialNetworks;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<Social> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final Social createFromParcel(@NotNull Parcel parcel) {
            ArrayList arrayList;
            Intrinsics.checkNotNullParameter(parcel, "in");
            boolean z = parcel.readInt() != 0;
            int readInt = parcel.readInt();
            ArrayList arrayList2 = new ArrayList(readInt);
            while (readInt != 0) {
                arrayList2.add((SocialNetwork) parcel.readParcelable(Social.class.getClassLoader()));
                readInt--;
            }
            if (parcel.readInt() != 0) {
                int readInt2 = parcel.readInt();
                arrayList = new ArrayList(readInt2);
                while (readInt2 != 0) {
                    arrayList.add(SocialNotification.CREATOR.createFromParcel(parcel));
                    readInt2--;
                }
            } else {
                arrayList = null;
            }
            return new Social(z, arrayList2, arrayList);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final Social[] newArray(int i) {
            return new Social[i];
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.util.List<? extends com.avito.android.remote.model.social.SocialNetwork> */
    /* JADX WARN: Multi-variable type inference failed */
    public Social(boolean z, @NotNull List<? extends SocialNetwork> list, @Nullable List<SocialNotification> list2) {
        Intrinsics.checkNotNullParameter(list, "socialNetworks");
        this.isIncomplete = z;
        this.socialNetworks = list;
        this.notifications = list2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final List<SocialNotification> getNotifications() {
        return this.notifications;
    }

    @NotNull
    public final List<SocialNetwork> getSocialNetworks() {
        return this.socialNetworks;
    }

    public final boolean isIncomplete() {
        return this.isIncomplete;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeInt(this.isIncomplete ? 1 : 0);
        Iterator n0 = a.n0(this.socialNetworks, parcel);
        while (n0.hasNext()) {
            parcel.writeParcelable((SocialNetwork) n0.next(), i);
        }
        List<SocialNotification> list = this.notifications;
        if (list != null) {
            Iterator l0 = a.l0(parcel, 1, list);
            while (l0.hasNext()) {
                ((SocialNotification) l0.next()).writeToParcel(parcel, 0);
            }
            return;
        }
        parcel.writeInt(0);
    }
}
