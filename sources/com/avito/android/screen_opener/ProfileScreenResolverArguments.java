package com.avito.android.screen_opener;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.analytics.provider.clickstream.TreeClickStreamParent;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\r\b\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b&\u0010'J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ2\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u0004J\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0011J \u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u001c\u0010\u001dR\u001b\u0010\u000b\u001a\u0004\u0018\u00010\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010\bR\u001b\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010\u0004R\u0019\u0010\t\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010\"\u001a\u0004\b%\u0010\u0004¨\u0006("}, d2 = {"Lcom/avito/android/screen_opener/ProfileScreenResolverArguments;", "Landroid/os/Parcelable;", "", "component1", "()Ljava/lang/String;", "component2", "Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;", "component3", "()Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;", "userKey", "contextId", "treeParent", "copy", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;)Lcom/avito/android/screen_opener/ProfileScreenResolverArguments;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "c", "Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;", "getTreeParent", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getContextId", AuthSource.SEND_ABUSE, "getUserKey", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;)V", "public-profile_release"}, k = 1, mv = {1, 4, 2})
public final class ProfileScreenResolverArguments implements Parcelable {
    public static final Parcelable.Creator<ProfileScreenResolverArguments> CREATOR = new Creator();
    @NotNull
    public final String a;
    @Nullable
    public final String b;
    @Nullable
    public final TreeClickStreamParent c;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<ProfileScreenResolverArguments> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ProfileScreenResolverArguments createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new ProfileScreenResolverArguments(parcel.readString(), parcel.readString(), (TreeClickStreamParent) parcel.readParcelable(ProfileScreenResolverArguments.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ProfileScreenResolverArguments[] newArray(int i) {
            return new ProfileScreenResolverArguments[i];
        }
    }

    public ProfileScreenResolverArguments(@NotNull String str, @Nullable String str2, @Nullable TreeClickStreamParent treeClickStreamParent) {
        Intrinsics.checkNotNullParameter(str, "userKey");
        this.a = str;
        this.b = str2;
        this.c = treeClickStreamParent;
    }

    public static /* synthetic */ ProfileScreenResolverArguments copy$default(ProfileScreenResolverArguments profileScreenResolverArguments, String str, String str2, TreeClickStreamParent treeClickStreamParent, int i, Object obj) {
        if ((i & 1) != 0) {
            str = profileScreenResolverArguments.a;
        }
        if ((i & 2) != 0) {
            str2 = profileScreenResolverArguments.b;
        }
        if ((i & 4) != 0) {
            treeClickStreamParent = profileScreenResolverArguments.c;
        }
        return profileScreenResolverArguments.copy(str, str2, treeClickStreamParent);
    }

    @NotNull
    public final String component1() {
        return this.a;
    }

    @Nullable
    public final String component2() {
        return this.b;
    }

    @Nullable
    public final TreeClickStreamParent component3() {
        return this.c;
    }

    @NotNull
    public final ProfileScreenResolverArguments copy(@NotNull String str, @Nullable String str2, @Nullable TreeClickStreamParent treeClickStreamParent) {
        Intrinsics.checkNotNullParameter(str, "userKey");
        return new ProfileScreenResolverArguments(str, str2, treeClickStreamParent);
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
        if (!(obj instanceof ProfileScreenResolverArguments)) {
            return false;
        }
        ProfileScreenResolverArguments profileScreenResolverArguments = (ProfileScreenResolverArguments) obj;
        return Intrinsics.areEqual(this.a, profileScreenResolverArguments.a) && Intrinsics.areEqual(this.b, profileScreenResolverArguments.b) && Intrinsics.areEqual(this.c, profileScreenResolverArguments.c);
    }

    @Nullable
    public final String getContextId() {
        return this.b;
    }

    @Nullable
    public final TreeClickStreamParent getTreeParent() {
        return this.c;
    }

    @NotNull
    public final String getUserKey() {
        return this.a;
    }

    @Override // java.lang.Object
    public int hashCode() {
        String str = this.a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.b;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        TreeClickStreamParent treeClickStreamParent = this.c;
        if (treeClickStreamParent != null) {
            i = treeClickStreamParent.hashCode();
        }
        return hashCode2 + i;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("ProfileScreenResolverArguments(userKey=");
        L.append(this.a);
        L.append(", contextId=");
        L.append(this.b);
        L.append(", treeParent=");
        L.append(this.c);
        L.append(")");
        return L.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeParcelable(this.c, i);
    }
}
