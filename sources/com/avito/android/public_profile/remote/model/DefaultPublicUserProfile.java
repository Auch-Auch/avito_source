package com.avito.android.public_profile.remote.model;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import com.avito.android.remote.model.AdvertShortcut;
import com.avito.android.remote.model.Sharing;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\r\b\b\u0018\u00002\u00020\u00012\u00020\u0002B=\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\n\u0012\u0014\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r¢\u0006\u0004\b0\u00101J\u0010\u0010\u0004\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\u000b\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u001e\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010JN\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0011\u001a\u00020\u00032\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\n2\u0016\b\u0002\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rHÆ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u001a\u001a\u00020\u0019HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u001a\u0010\u001f\u001a\u00020\u001e2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cHÖ\u0003¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010!\u001a\u00020\u0019HÖ\u0001¢\u0006\u0004\b!\u0010\u001bJ \u0010&\u001a\u00020%2\u0006\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020\u0019HÖ\u0001¢\u0006\u0004\b&\u0010'R*\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0014\u0010(\u001a\u0004\b)\u0010\u0010R\u001c\u0010\u0011\u001a\u00020\u00038\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010*\u001a\u0004\b+\u0010\u0005R\"\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0012\u0010,\u001a\u0004\b-\u0010\tR\u001e\u0010\u0013\u001a\u0004\u0018\u00010\n8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0013\u0010.\u001a\u0004\b/\u0010\f¨\u00062"}, d2 = {"Lcom/avito/android/public_profile/remote/model/DefaultPublicUserProfile;", "Lcom/avito/android/public_profile/remote/model/PublicUserProfile;", "Landroid/os/Parcelable;", "Lcom/avito/android/public_profile/remote/model/UserProfileLegacy;", "component1", "()Lcom/avito/android/public_profile/remote/model/UserProfileLegacy;", "", "Lcom/avito/android/remote/model/AdvertShortcut;", "component2", "()Ljava/util/List;", "Lcom/avito/android/remote/model/Sharing;", "component3", "()Lcom/avito/android/remote/model/Sharing;", "", "", "component4", "()Ljava/util/Map;", "user", ScreenPublicConstsKt.CONTENT_TYPE_SHORTCUTS, "sharing", "analytics", "copy", "(Lcom/avito/android/public_profile/remote/model/UserProfileLegacy;Ljava/util/List;Lcom/avito/android/remote/model/Sharing;Ljava/util/Map;)Lcom/avito/android/public_profile/remote/model/DefaultPublicUserProfile;", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/util/Map;", "getAnalytics", "Lcom/avito/android/public_profile/remote/model/UserProfileLegacy;", "getUser", "Ljava/util/List;", "getShortcuts", "Lcom/avito/android/remote/model/Sharing;", "getSharing", "<init>", "(Lcom/avito/android/public_profile/remote/model/UserProfileLegacy;Ljava/util/List;Lcom/avito/android/remote/model/Sharing;Ljava/util/Map;)V", "public-profile_release"}, k = 1, mv = {1, 4, 2})
public final class DefaultPublicUserProfile implements PublicUserProfile, Parcelable {
    public static final Parcelable.Creator<DefaultPublicUserProfile> CREATOR = new Creator();
    @SerializedName("analytics")
    @Nullable
    private final Map<String, String> analytics;
    @SerializedName("sharing")
    @Nullable
    private final Sharing sharing;
    @SerializedName(ScreenPublicConstsKt.CONTENT_TYPE_SHORTCUTS)
    @NotNull
    private final List<AdvertShortcut> shortcuts;
    @SerializedName("user")
    @NotNull
    private final UserProfileLegacy user;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<DefaultPublicUserProfile> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final DefaultPublicUserProfile createFromParcel(@NotNull Parcel parcel) {
            LinkedHashMap linkedHashMap;
            Intrinsics.checkNotNullParameter(parcel, "in");
            UserProfileLegacy createFromParcel = UserProfileLegacy.CREATOR.createFromParcel(parcel);
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            while (readInt != 0) {
                arrayList.add((AdvertShortcut) parcel.readParcelable(DefaultPublicUserProfile.class.getClassLoader()));
                readInt--;
            }
            Sharing sharing = (Sharing) parcel.readParcelable(DefaultPublicUserProfile.class.getClassLoader());
            if (parcel.readInt() != 0) {
                int readInt2 = parcel.readInt();
                linkedHashMap = new LinkedHashMap(readInt2);
                while (readInt2 != 0) {
                    readInt2 = a.U(parcel, linkedHashMap, parcel.readString(), readInt2, -1);
                }
            } else {
                linkedHashMap = null;
            }
            return new DefaultPublicUserProfile(createFromParcel, arrayList, sharing, linkedHashMap);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final DefaultPublicUserProfile[] newArray(int i) {
            return new DefaultPublicUserProfile[i];
        }
    }

    public DefaultPublicUserProfile(@NotNull UserProfileLegacy userProfileLegacy, @NotNull List<AdvertShortcut> list, @Nullable Sharing sharing2, @Nullable Map<String, String> map) {
        Intrinsics.checkNotNullParameter(userProfileLegacy, "user");
        Intrinsics.checkNotNullParameter(list, ScreenPublicConstsKt.CONTENT_TYPE_SHORTCUTS);
        this.user = userProfileLegacy;
        this.shortcuts = list;
        this.sharing = sharing2;
        this.analytics = map;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.public_profile.remote.model.DefaultPublicUserProfile */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DefaultPublicUserProfile copy$default(DefaultPublicUserProfile defaultPublicUserProfile, UserProfileLegacy userProfileLegacy, List list, Sharing sharing2, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            userProfileLegacy = defaultPublicUserProfile.user;
        }
        if ((i & 2) != 0) {
            list = defaultPublicUserProfile.shortcuts;
        }
        if ((i & 4) != 0) {
            sharing2 = defaultPublicUserProfile.sharing;
        }
        if ((i & 8) != 0) {
            map = defaultPublicUserProfile.analytics;
        }
        return defaultPublicUserProfile.copy(userProfileLegacy, list, sharing2, map);
    }

    @NotNull
    public final UserProfileLegacy component1() {
        return this.user;
    }

    @NotNull
    public final List<AdvertShortcut> component2() {
        return this.shortcuts;
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
    public final DefaultPublicUserProfile copy(@NotNull UserProfileLegacy userProfileLegacy, @NotNull List<AdvertShortcut> list, @Nullable Sharing sharing2, @Nullable Map<String, String> map) {
        Intrinsics.checkNotNullParameter(userProfileLegacy, "user");
        Intrinsics.checkNotNullParameter(list, ScreenPublicConstsKt.CONTENT_TYPE_SHORTCUTS);
        return new DefaultPublicUserProfile(userProfileLegacy, list, sharing2, map);
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
        if (!(obj instanceof DefaultPublicUserProfile)) {
            return false;
        }
        DefaultPublicUserProfile defaultPublicUserProfile = (DefaultPublicUserProfile) obj;
        return Intrinsics.areEqual(this.user, defaultPublicUserProfile.user) && Intrinsics.areEqual(this.shortcuts, defaultPublicUserProfile.shortcuts) && Intrinsics.areEqual(this.sharing, defaultPublicUserProfile.sharing) && Intrinsics.areEqual(this.analytics, defaultPublicUserProfile.analytics);
    }

    @Nullable
    public final Map<String, String> getAnalytics() {
        return this.analytics;
    }

    @Nullable
    public final Sharing getSharing() {
        return this.sharing;
    }

    @NotNull
    public final List<AdvertShortcut> getShortcuts() {
        return this.shortcuts;
    }

    @NotNull
    public final UserProfileLegacy getUser() {
        return this.user;
    }

    @Override // java.lang.Object
    public int hashCode() {
        UserProfileLegacy userProfileLegacy = this.user;
        int i = 0;
        int hashCode = (userProfileLegacy != null ? userProfileLegacy.hashCode() : 0) * 31;
        List<AdvertShortcut> list = this.shortcuts;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 0)) * 31;
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
        StringBuilder L = a.L("DefaultPublicUserProfile(user=");
        L.append(this.user);
        L.append(", shortcuts=");
        L.append(this.shortcuts);
        L.append(", sharing=");
        L.append(this.sharing);
        L.append(", analytics=");
        return a.x(L, this.analytics, ")");
    }

    /* JADX WARN: Type inference failed for: r0v7, types: [java.util.Map$Entry, java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // android.os.Parcelable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void writeToParcel(@org.jetbrains.annotations.NotNull android.os.Parcel r4, int r5) {
        /*
            r3 = this;
            java.lang.String r0 = "parcel"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            com.avito.android.public_profile.remote.model.UserProfileLegacy r0 = r3.user
            r1 = 0
            r0.writeToParcel(r4, r1)
            java.util.List<com.avito.android.remote.model.AdvertShortcut> r0 = r3.shortcuts
            java.util.Iterator r0 = a2.b.a.a.a.n0(r0, r4)
        L_0x0011:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x0021
            java.lang.Object r2 = r0.next()
            com.avito.android.remote.model.AdvertShortcut r2 = (com.avito.android.remote.model.AdvertShortcut) r2
            r4.writeParcelable(r2, r5)
            goto L_0x0011
        L_0x0021:
            com.avito.android.remote.model.Sharing r0 = r3.sharing
            r4.writeParcelable(r0, r5)
            java.util.Map<java.lang.String, java.lang.String> r5 = r3.analytics
            if (r5 == 0) goto L_0x004c
            r0 = 1
            java.util.Iterator r5 = a2.b.a.a.a.m0(r4, r0, r5)
        L_0x002f:
            boolean r0 = r5.hasNext()
            if (r0 == 0) goto L_0x004f
            java.lang.Object r0 = r5.next()
            java.lang.Object r1 = r0.getKey()
            java.lang.String r1 = (java.lang.String) r1
            r4.writeString(r1)
            java.lang.Object r0 = r0.getValue()
            java.lang.String r0 = (java.lang.String) r0
            r4.writeString(r0)
            goto L_0x002f
        L_0x004c:
            r4.writeInt(r1)
        L_0x004f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.public_profile.remote.model.DefaultPublicUserProfile.writeToParcel(android.os.Parcel, int):void");
    }
}
