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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\r\b\b\u0018\u00002\u00020\u00012\u00020\u0002B?\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\n\u0012\u0014\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r¢\u0006\u0004\b0\u00101J\u0010\u0010\u0004\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\u000b\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u001e\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010JP\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0011\u001a\u00020\u00032\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\n2\u0016\b\u0002\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rHÆ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u001a\u001a\u00020\u0019HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u001a\u0010\u001f\u001a\u00020\u001e2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cHÖ\u0003¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010!\u001a\u00020\u0019HÖ\u0001¢\u0006\u0004\b!\u0010\u001bJ \u0010&\u001a\u00020%2\u0006\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020\u0019HÖ\u0001¢\u0006\u0004\b&\u0010'R*\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0014\u0010(\u001a\u0004\b)\u0010\u0010R\u001c\u0010\u0011\u001a\u00020\u00038\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010*\u001a\u0004\b+\u0010\u0005R$\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00068\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0012\u0010,\u001a\u0004\b-\u0010\tR\u001e\u0010\u0013\u001a\u0004\u0018\u00010\n8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0013\u0010.\u001a\u0004\b/\u0010\f¨\u00062"}, d2 = {"Lcom/avito/android/public_profile/remote/model/ExtendedPublicUserProfile;", "Lcom/avito/android/public_profile/remote/model/PublicUserProfile;", "Landroid/os/Parcelable;", "Lcom/avito/android/public_profile/remote/model/UserProfile;", "component1", "()Lcom/avito/android/public_profile/remote/model/UserProfile;", "", "Lcom/avito/android/remote/model/AdvertShortcut;", "component2", "()Ljava/util/List;", "Lcom/avito/android/remote/model/Sharing;", "component3", "()Lcom/avito/android/remote/model/Sharing;", "", "", "component4", "()Ljava/util/Map;", "user", ScreenPublicConstsKt.CONTENT_TYPE_SHORTCUTS, "sharing", "analytics", "copy", "(Lcom/avito/android/public_profile/remote/model/UserProfile;Ljava/util/List;Lcom/avito/android/remote/model/Sharing;Ljava/util/Map;)Lcom/avito/android/public_profile/remote/model/ExtendedPublicUserProfile;", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/util/Map;", "getAnalytics", "Lcom/avito/android/public_profile/remote/model/UserProfile;", "getUser", "Ljava/util/List;", "getShortcuts", "Lcom/avito/android/remote/model/Sharing;", "getSharing", "<init>", "(Lcom/avito/android/public_profile/remote/model/UserProfile;Ljava/util/List;Lcom/avito/android/remote/model/Sharing;Ljava/util/Map;)V", "public-profile_release"}, k = 1, mv = {1, 4, 2})
public final class ExtendedPublicUserProfile implements PublicUserProfile, Parcelable {
    public static final Parcelable.Creator<ExtendedPublicUserProfile> CREATOR = new Creator();
    @SerializedName("analytics")
    @Nullable
    private final Map<String, String> analytics;
    @SerializedName("sharing")
    @Nullable
    private final Sharing sharing;
    @SerializedName(ScreenPublicConstsKt.CONTENT_TYPE_SHORTCUTS)
    @Nullable
    private final List<AdvertShortcut> shortcuts;
    @SerializedName("user")
    @NotNull
    private final UserProfile user;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<ExtendedPublicUserProfile> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ExtendedPublicUserProfile createFromParcel(@NotNull Parcel parcel) {
            ArrayList arrayList;
            Intrinsics.checkNotNullParameter(parcel, "in");
            UserProfile createFromParcel = UserProfile.CREATOR.createFromParcel(parcel);
            LinkedHashMap linkedHashMap = null;
            if (parcel.readInt() != 0) {
                int readInt = parcel.readInt();
                arrayList = new ArrayList(readInt);
                while (readInt != 0) {
                    arrayList.add((AdvertShortcut) parcel.readParcelable(ExtendedPublicUserProfile.class.getClassLoader()));
                    readInt--;
                }
            } else {
                arrayList = null;
            }
            Sharing sharing = (Sharing) parcel.readParcelable(ExtendedPublicUserProfile.class.getClassLoader());
            if (parcel.readInt() != 0) {
                int readInt2 = parcel.readInt();
                LinkedHashMap linkedHashMap2 = new LinkedHashMap(readInt2);
                while (readInt2 != 0) {
                    readInt2 = a.U(parcel, linkedHashMap2, parcel.readString(), readInt2, -1);
                }
                linkedHashMap = linkedHashMap2;
            }
            return new ExtendedPublicUserProfile(createFromParcel, arrayList, sharing, linkedHashMap);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ExtendedPublicUserProfile[] newArray(int i) {
            return new ExtendedPublicUserProfile[i];
        }
    }

    public ExtendedPublicUserProfile(@NotNull UserProfile userProfile, @Nullable List<AdvertShortcut> list, @Nullable Sharing sharing2, @Nullable Map<String, String> map) {
        Intrinsics.checkNotNullParameter(userProfile, "user");
        this.user = userProfile;
        this.shortcuts = list;
        this.sharing = sharing2;
        this.analytics = map;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.public_profile.remote.model.ExtendedPublicUserProfile */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ExtendedPublicUserProfile copy$default(ExtendedPublicUserProfile extendedPublicUserProfile, UserProfile userProfile, List list, Sharing sharing2, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            userProfile = extendedPublicUserProfile.user;
        }
        if ((i & 2) != 0) {
            list = extendedPublicUserProfile.shortcuts;
        }
        if ((i & 4) != 0) {
            sharing2 = extendedPublicUserProfile.sharing;
        }
        if ((i & 8) != 0) {
            map = extendedPublicUserProfile.analytics;
        }
        return extendedPublicUserProfile.copy(userProfile, list, sharing2, map);
    }

    @NotNull
    public final UserProfile component1() {
        return this.user;
    }

    @Nullable
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
    public final ExtendedPublicUserProfile copy(@NotNull UserProfile userProfile, @Nullable List<AdvertShortcut> list, @Nullable Sharing sharing2, @Nullable Map<String, String> map) {
        Intrinsics.checkNotNullParameter(userProfile, "user");
        return new ExtendedPublicUserProfile(userProfile, list, sharing2, map);
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
        if (!(obj instanceof ExtendedPublicUserProfile)) {
            return false;
        }
        ExtendedPublicUserProfile extendedPublicUserProfile = (ExtendedPublicUserProfile) obj;
        return Intrinsics.areEqual(this.user, extendedPublicUserProfile.user) && Intrinsics.areEqual(this.shortcuts, extendedPublicUserProfile.shortcuts) && Intrinsics.areEqual(this.sharing, extendedPublicUserProfile.sharing) && Intrinsics.areEqual(this.analytics, extendedPublicUserProfile.analytics);
    }

    @Nullable
    public final Map<String, String> getAnalytics() {
        return this.analytics;
    }

    @Nullable
    public final Sharing getSharing() {
        return this.sharing;
    }

    @Nullable
    public final List<AdvertShortcut> getShortcuts() {
        return this.shortcuts;
    }

    @NotNull
    public final UserProfile getUser() {
        return this.user;
    }

    @Override // java.lang.Object
    public int hashCode() {
        UserProfile userProfile = this.user;
        int i = 0;
        int hashCode = (userProfile != null ? userProfile.hashCode() : 0) * 31;
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
        StringBuilder L = a.L("ExtendedPublicUserProfile(user=");
        L.append(this.user);
        L.append(", shortcuts=");
        L.append(this.shortcuts);
        L.append(", sharing=");
        L.append(this.sharing);
        L.append(", analytics=");
        return a.x(L, this.analytics, ")");
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [java.util.Map$Entry, java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // android.os.Parcelable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void writeToParcel(@org.jetbrains.annotations.NotNull android.os.Parcel r5, int r6) {
        /*
            r4 = this;
            java.lang.String r0 = "parcel"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            com.avito.android.public_profile.remote.model.UserProfile r0 = r4.user
            r1 = 0
            r0.writeToParcel(r5, r1)
            java.util.List<com.avito.android.remote.model.AdvertShortcut> r0 = r4.shortcuts
            r2 = 1
            if (r0 == 0) goto L_0x0024
            java.util.Iterator r0 = a2.b.a.a.a.l0(r5, r2, r0)
        L_0x0014:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L_0x0027
            java.lang.Object r3 = r0.next()
            com.avito.android.remote.model.AdvertShortcut r3 = (com.avito.android.remote.model.AdvertShortcut) r3
            r5.writeParcelable(r3, r6)
            goto L_0x0014
        L_0x0024:
            r5.writeInt(r1)
        L_0x0027:
            com.avito.android.remote.model.Sharing r0 = r4.sharing
            r5.writeParcelable(r0, r6)
            java.util.Map<java.lang.String, java.lang.String> r6 = r4.analytics
            if (r6 == 0) goto L_0x0051
            java.util.Iterator r6 = a2.b.a.a.a.m0(r5, r2, r6)
        L_0x0034:
            boolean r0 = r6.hasNext()
            if (r0 == 0) goto L_0x0054
            java.lang.Object r0 = r6.next()
            java.lang.Object r1 = r0.getKey()
            java.lang.String r1 = (java.lang.String) r1
            r5.writeString(r1)
            java.lang.Object r0 = r0.getValue()
            java.lang.String r0 = (java.lang.String) r0
            r5.writeString(r0)
            goto L_0x0034
        L_0x0051:
            r5.writeInt(r1)
        L_0x0054:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.public_profile.remote.model.ExtendedPublicUserProfile.writeToParcel(android.os.Parcel, int):void");
    }
}
