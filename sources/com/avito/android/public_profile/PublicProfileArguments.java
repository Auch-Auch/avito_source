package com.avito.android.public_profile;

import a2.b.a.a.a;
import a2.g.r.g;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.analytics.provider.clickstream.TreeClickStreamParent;
import com.avito.android.analytics.screens.InternalConstsKt;
import com.avito.android.analytics.screens.Screen;
import com.avito.android.analytics.screens.tracker.ScreenTransfer;
import com.avito.android.public_profile.remote.model.DefaultPublicUserProfile;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0018\b\b\u0018\u00002\u00020\u0001BG\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0016\u001a\u00020\u0005\u0012\u0006\u0010\u0017\u001a\u00020\b\u0012\u0006\u0010\u0018\u001a\u00020\u000b\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b@\u0010AJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u0007J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J^\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0016\u001a\u00020\u00052\b\b\u0002\u0010\u0017\u001a\u00020\b2\b\b\u0002\u0010\u0018\u001a\u00020\u000b2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0012HÆ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u001e\u0010\u0007J\u0010\u0010 \u001a\u00020\u001fHÖ\u0001¢\u0006\u0004\b \u0010!J\u001a\u0010$\u001a\u00020\u000b2\b\u0010#\u001a\u0004\u0018\u00010\"HÖ\u0003¢\u0006\u0004\b$\u0010%J\u0010\u0010&\u001a\u00020\u001fHÖ\u0001¢\u0006\u0004\b&\u0010!J \u0010+\u001a\u00020*2\u0006\u0010(\u001a\u00020'2\u0006\u0010)\u001a\u00020\u001fHÖ\u0001¢\u0006\u0004\b+\u0010,R\u001b\u0010\u001a\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u0010\u0011R\u001b\u0010\u001b\u001a\u0004\u0018\u00010\u00128\u0006@\u0006¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u0010\u0014R\u001b\u0010\u0019\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u0010\u0007R\u0019\u0010\u0017\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b6\u00107\u001a\u0004\b8\u0010\nR\u0019\u0010\u0016\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b9\u00104\u001a\u0004\b:\u0010\u0007R\u001b\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b;\u0010<\u001a\u0004\b=\u0010\u0004R\u0019\u0010\u0018\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b>\u0010?\u001a\u0004\b\u0018\u0010\r¨\u0006B"}, d2 = {"Lcom/avito/android/public_profile/PublicProfileArguments;", "Landroid/os/Parcelable;", "Lcom/avito/android/public_profile/remote/model/DefaultPublicUserProfile;", "component1", "()Lcom/avito/android/public_profile/remote/model/DefaultPublicUserProfile;", "", "component2", "()Ljava/lang/String;", "Lcom/avito/android/analytics/screens/Screen;", "component3", "()Lcom/avito/android/analytics/screens/Screen;", "", "component4", "()Z", "component5", "Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;", "component6", "()Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;", "Lcom/avito/android/analytics/screens/tracker/ScreenTransfer;", "component7", "()Lcom/avito/android/analytics/screens/tracker/ScreenTransfer;", "userProfile", "userKey", InternalConstsKt.SCREEN, "isSubComponent", "contextId", "treeParent", "screenTransfer", "copy", "(Lcom/avito/android/public_profile/remote/model/DefaultPublicUserProfile;Ljava/lang/String;Lcom/avito/android/analytics/screens/Screen;ZLjava/lang/String;Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;Lcom/avito/android/analytics/screens/tracker/ScreenTransfer;)Lcom/avito/android/public_profile/PublicProfileArguments;", "toString", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "f", "Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;", "getTreeParent", g.a, "Lcom/avito/android/analytics/screens/tracker/ScreenTransfer;", "getScreenTransfer", "e", "Ljava/lang/String;", "getContextId", "c", "Lcom/avito/android/analytics/screens/Screen;", "getScreen", AuthSource.BOOKING_ORDER, "getUserKey", AuthSource.SEND_ABUSE, "Lcom/avito/android/public_profile/remote/model/DefaultPublicUserProfile;", "getUserProfile", "d", "Z", "<init>", "(Lcom/avito/android/public_profile/remote/model/DefaultPublicUserProfile;Ljava/lang/String;Lcom/avito/android/analytics/screens/Screen;ZLjava/lang/String;Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;Lcom/avito/android/analytics/screens/tracker/ScreenTransfer;)V", "public-profile_release"}, k = 1, mv = {1, 4, 2})
public final class PublicProfileArguments implements Parcelable {
    public static final Parcelable.Creator<PublicProfileArguments> CREATOR = new Creator();
    @Nullable
    public final DefaultPublicUserProfile a;
    @NotNull
    public final String b;
    @NotNull
    public final Screen c;
    public final boolean d;
    @Nullable
    public final String e;
    @Nullable
    public final TreeClickStreamParent f;
    @Nullable
    public final ScreenTransfer g;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<PublicProfileArguments> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final PublicProfileArguments createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new PublicProfileArguments((DefaultPublicUserProfile) parcel.readParcelable(PublicProfileArguments.class.getClassLoader()), parcel.readString(), (Screen) parcel.readParcelable(PublicProfileArguments.class.getClassLoader()), parcel.readInt() != 0, parcel.readString(), (TreeClickStreamParent) parcel.readParcelable(PublicProfileArguments.class.getClassLoader()), (ScreenTransfer) parcel.readParcelable(PublicProfileArguments.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final PublicProfileArguments[] newArray(int i) {
            return new PublicProfileArguments[i];
        }
    }

    public PublicProfileArguments(@Nullable DefaultPublicUserProfile defaultPublicUserProfile, @NotNull String str, @NotNull Screen screen, boolean z, @Nullable String str2, @Nullable TreeClickStreamParent treeClickStreamParent, @Nullable ScreenTransfer screenTransfer) {
        Intrinsics.checkNotNullParameter(str, "userKey");
        Intrinsics.checkNotNullParameter(screen, InternalConstsKt.SCREEN);
        this.a = defaultPublicUserProfile;
        this.b = str;
        this.c = screen;
        this.d = z;
        this.e = str2;
        this.f = treeClickStreamParent;
        this.g = screenTransfer;
    }

    public static /* synthetic */ PublicProfileArguments copy$default(PublicProfileArguments publicProfileArguments, DefaultPublicUserProfile defaultPublicUserProfile, String str, Screen screen, boolean z, String str2, TreeClickStreamParent treeClickStreamParent, ScreenTransfer screenTransfer, int i, Object obj) {
        if ((i & 1) != 0) {
            defaultPublicUserProfile = publicProfileArguments.a;
        }
        if ((i & 2) != 0) {
            str = publicProfileArguments.b;
        }
        if ((i & 4) != 0) {
            screen = publicProfileArguments.c;
        }
        if ((i & 8) != 0) {
            z = publicProfileArguments.d;
        }
        if ((i & 16) != 0) {
            str2 = publicProfileArguments.e;
        }
        if ((i & 32) != 0) {
            treeClickStreamParent = publicProfileArguments.f;
        }
        if ((i & 64) != 0) {
            screenTransfer = publicProfileArguments.g;
        }
        return publicProfileArguments.copy(defaultPublicUserProfile, str, screen, z, str2, treeClickStreamParent, screenTransfer);
    }

    @Nullable
    public final DefaultPublicUserProfile component1() {
        return this.a;
    }

    @NotNull
    public final String component2() {
        return this.b;
    }

    @NotNull
    public final Screen component3() {
        return this.c;
    }

    public final boolean component4() {
        return this.d;
    }

    @Nullable
    public final String component5() {
        return this.e;
    }

    @Nullable
    public final TreeClickStreamParent component6() {
        return this.f;
    }

    @Nullable
    public final ScreenTransfer component7() {
        return this.g;
    }

    @NotNull
    public final PublicProfileArguments copy(@Nullable DefaultPublicUserProfile defaultPublicUserProfile, @NotNull String str, @NotNull Screen screen, boolean z, @Nullable String str2, @Nullable TreeClickStreamParent treeClickStreamParent, @Nullable ScreenTransfer screenTransfer) {
        Intrinsics.checkNotNullParameter(str, "userKey");
        Intrinsics.checkNotNullParameter(screen, InternalConstsKt.SCREEN);
        return new PublicProfileArguments(defaultPublicUserProfile, str, screen, z, str2, treeClickStreamParent, screenTransfer);
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
        if (!(obj instanceof PublicProfileArguments)) {
            return false;
        }
        PublicProfileArguments publicProfileArguments = (PublicProfileArguments) obj;
        return Intrinsics.areEqual(this.a, publicProfileArguments.a) && Intrinsics.areEqual(this.b, publicProfileArguments.b) && Intrinsics.areEqual(this.c, publicProfileArguments.c) && this.d == publicProfileArguments.d && Intrinsics.areEqual(this.e, publicProfileArguments.e) && Intrinsics.areEqual(this.f, publicProfileArguments.f) && Intrinsics.areEqual(this.g, publicProfileArguments.g);
    }

    @Nullable
    public final String getContextId() {
        return this.e;
    }

    @NotNull
    public final Screen getScreen() {
        return this.c;
    }

    @Nullable
    public final ScreenTransfer getScreenTransfer() {
        return this.g;
    }

    @Nullable
    public final TreeClickStreamParent getTreeParent() {
        return this.f;
    }

    @NotNull
    public final String getUserKey() {
        return this.b;
    }

    @Nullable
    public final DefaultPublicUserProfile getUserProfile() {
        return this.a;
    }

    @Override // java.lang.Object
    public int hashCode() {
        DefaultPublicUserProfile defaultPublicUserProfile = this.a;
        int i = 0;
        int hashCode = (defaultPublicUserProfile != null ? defaultPublicUserProfile.hashCode() : 0) * 31;
        String str = this.b;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        Screen screen = this.c;
        int hashCode3 = (hashCode2 + (screen != null ? screen.hashCode() : 0)) * 31;
        boolean z = this.d;
        if (z) {
            z = true;
        }
        int i2 = z ? 1 : 0;
        int i3 = z ? 1 : 0;
        int i4 = z ? 1 : 0;
        int i5 = (hashCode3 + i2) * 31;
        String str2 = this.e;
        int hashCode4 = (i5 + (str2 != null ? str2.hashCode() : 0)) * 31;
        TreeClickStreamParent treeClickStreamParent = this.f;
        int hashCode5 = (hashCode4 + (treeClickStreamParent != null ? treeClickStreamParent.hashCode() : 0)) * 31;
        ScreenTransfer screenTransfer = this.g;
        if (screenTransfer != null) {
            i = screenTransfer.hashCode();
        }
        return hashCode5 + i;
    }

    public final boolean isSubComponent() {
        return this.d;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("PublicProfileArguments(userProfile=");
        L.append(this.a);
        L.append(", userKey=");
        L.append(this.b);
        L.append(", screen=");
        L.append(this.c);
        L.append(", isSubComponent=");
        L.append(this.d);
        L.append(", contextId=");
        L.append(this.e);
        L.append(", treeParent=");
        L.append(this.f);
        L.append(", screenTransfer=");
        L.append(this.g);
        L.append(")");
        return L.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeParcelable(this.a, i);
        parcel.writeString(this.b);
        parcel.writeParcelable(this.c, i);
        parcel.writeInt(this.d ? 1 : 0);
        parcel.writeString(this.e);
        parcel.writeParcelable(this.f, i);
        parcel.writeParcelable(this.g, i);
    }
}
