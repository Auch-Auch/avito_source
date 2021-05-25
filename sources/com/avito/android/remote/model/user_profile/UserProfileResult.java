package com.avito.android.remote.model.user_profile;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.model.Action;
import com.avito.android.remote.model.Sharing;
import com.avito.android.remote.model.user_profile.items.UserProfileItem;
import com.avito.android.util.Parcels;
import com.avito.android.util.ParcelsKt;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\b\b\u0018\u0000 /2\u00020\u0001:\u0001/BG\u0012\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b\u0012\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000b\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0011\u0012\u0014\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014¢\u0006\u0004\b-\u0010.J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u000eJ\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u001e\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0017JX\u0010\u001c\u001a\u00020\u00002\u0010\b\u0002\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\u0010\b\u0002\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000b2\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00112\u0016\b\u0002\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014HÆ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010 \u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b \u0010\nJ\u001a\u0010$\u001a\u00020#2\b\u0010\"\u001a\u0004\u0018\u00010!HÖ\u0003¢\u0006\u0004\b$\u0010%R\u001e\u0010\u001a\u001a\u0004\u0018\u00010\u00118\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001a\u0010&\u001a\u0004\b'\u0010\u0013R*\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00148\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001b\u0010(\u001a\u0004\b)\u0010\u0017R$\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0018\u0010*\u001a\u0004\b+\u0010\u000eR$\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0019\u0010*\u001a\u0004\b,\u0010\u000e¨\u00060"}, d2 = {"Lcom/avito/android/remote/model/user_profile/UserProfileResult;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "dest", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "", "Lcom/avito/android/remote/model/user_profile/items/UserProfileItem;", "component1", "()Ljava/util/List;", "Lcom/avito/android/remote/model/Action;", "component2", "Lcom/avito/android/remote/model/Sharing;", "component3", "()Lcom/avito/android/remote/model/Sharing;", "", "", "component4", "()Ljava/util/Map;", "items", "actions", "sharing", "analytics", "copy", "(Ljava/util/List;Ljava/util/List;Lcom/avito/android/remote/model/Sharing;Ljava/util/Map;)Lcom/avito/android/remote/model/user_profile/UserProfileResult;", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/avito/android/remote/model/Sharing;", "getSharing", "Ljava/util/Map;", "getAnalytics", "Ljava/util/List;", "getItems", "getActions", "<init>", "(Ljava/util/List;Ljava/util/List;Lcom/avito/android/remote/model/Sharing;Ljava/util/Map;)V", "Companion", "profile_release"}, k = 1, mv = {1, 4, 2})
public final class UserProfileResult implements Parcelable {
    @JvmField
    @NotNull
    public static final Parcelable.Creator<UserProfileResult> CREATOR = Parcels.creator(UserProfileResult$Companion$CREATOR$1.INSTANCE);
    @NotNull
    public static final Companion Companion = new Companion(null);
    @SerializedName("actions")
    @Nullable
    private final List<Action> actions;
    @SerializedName("analytics")
    @Nullable
    private final Map<String, String> analytics;
    @SerializedName(MessengerShareContentUtility.ELEMENTS)
    @Nullable
    private final List<UserProfileItem> items;
    @SerializedName("sharing")
    @Nullable
    private final Sharing sharing;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/remote/model/user_profile/UserProfileResult$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/remote/model/user_profile/UserProfileResult;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "profile_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(j jVar) {
            this();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.util.List<? extends com.avito.android.remote.model.user_profile.items.UserProfileItem> */
    /* JADX WARN: Multi-variable type inference failed */
    public UserProfileResult(@Nullable List<? extends UserProfileItem> list, @Nullable List<Action> list2, @Nullable Sharing sharing2, @Nullable Map<String, String> map) {
        this.items = list;
        this.actions = list2;
        this.sharing = sharing2;
        this.analytics = map;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.remote.model.user_profile.UserProfileResult */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ UserProfileResult copy$default(UserProfileResult userProfileResult, List list, List list2, Sharing sharing2, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            list = userProfileResult.items;
        }
        if ((i & 2) != 0) {
            list2 = userProfileResult.actions;
        }
        if ((i & 4) != 0) {
            sharing2 = userProfileResult.sharing;
        }
        if ((i & 8) != 0) {
            map = userProfileResult.analytics;
        }
        return userProfileResult.copy(list, list2, sharing2, map);
    }

    @Nullable
    public final List<UserProfileItem> component1() {
        return this.items;
    }

    @Nullable
    public final List<Action> component2() {
        return this.actions;
    }

    @Nullable
    public final Sharing component3() {
        return this.sharing;
    }

    @Nullable
    public final Map<String, String> component4() {
        return this.analytics;
    }

    @NotNull
    public final UserProfileResult copy(@Nullable List<? extends UserProfileItem> list, @Nullable List<Action> list2, @Nullable Sharing sharing2, @Nullable Map<String, String> map) {
        return new UserProfileResult(list, list2, sharing2, map);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.lang.Object
    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UserProfileResult)) {
            return false;
        }
        UserProfileResult userProfileResult = (UserProfileResult) obj;
        return Intrinsics.areEqual(this.items, userProfileResult.items) && Intrinsics.areEqual(this.actions, userProfileResult.actions) && Intrinsics.areEqual(this.sharing, userProfileResult.sharing) && Intrinsics.areEqual(this.analytics, userProfileResult.analytics);
    }

    @Nullable
    public final List<Action> getActions() {
        return this.actions;
    }

    @Nullable
    public final Map<String, String> getAnalytics() {
        return this.analytics;
    }

    @Nullable
    public final List<UserProfileItem> getItems() {
        return this.items;
    }

    @Nullable
    public final Sharing getSharing() {
        return this.sharing;
    }

    @Override // java.lang.Object
    public int hashCode() {
        List<UserProfileItem> list = this.items;
        int i = 0;
        int hashCode = (list != null ? list.hashCode() : 0) * 31;
        List<Action> list2 = this.actions;
        int hashCode2 = (hashCode + (list2 != null ? list2.hashCode() : 0)) * 31;
        Sharing sharing2 = this.sharing;
        int hashCode3 = (hashCode2 + (sharing2 != null ? sharing2.hashCode() : 0)) * 31;
        Map<String, String> map = this.analytics;
        if (map != null) {
            i = map.hashCode();
        }
        return hashCode3 + i;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("UserProfileResult(items=");
        L.append(this.items);
        L.append(", actions=");
        L.append(this.actions);
        L.append(", sharing=");
        L.append(this.sharing);
        L.append(", analytics=");
        return a.x(L, this.analytics, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        ParcelsKt.writeOptimizedParcelableList(parcel, this.items, i);
        ParcelsKt.writeOptimizedParcelableList$default(parcel, this.actions, 0, 2, null);
        parcel.writeParcelable(this.sharing, i);
        parcel.writeMap(this.analytics);
    }
}
