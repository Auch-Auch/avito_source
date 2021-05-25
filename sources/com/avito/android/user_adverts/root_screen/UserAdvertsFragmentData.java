package com.avito.android.user_adverts.root_screen;

import a2.b.a.a.a;
import a2.g.r.g;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.bottom_navigation.NavigationTab;
import com.avito.android.bottom_navigation.NavigationTabControlSetItem;
import com.avito.android.bottom_navigation.NavigationTabProfileRedesignTestSetItem;
import com.avito.android.bottom_navigation.ui.fragment.factory.TabFragmentFactory;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.user_advert.AdvertActionTransferData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\r\b\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u000f\u001a\u00020\t¢\u0006\u0004\bC\u0010DJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ>\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u000f\u001a\u00020\tHÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0004J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0018\u001a\u00020\t2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u0015J \u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u001f\u0010 R\u001b\u0010\u000e\u001a\u0004\u0018\u00010\u00068\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010\bR\"\u0010)\u001a\u00020\t8\u0016@\u0016XD¢\u0006\u0012\n\u0004\b$\u0010%\u0012\u0004\b'\u0010(\u001a\u0004\b&\u0010\u000bR\u001b\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010\u0004R\u001b\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b-\u0010+\u001a\u0004\b.\u0010\u0004R\"\u00105\u001a\u00020/8\u0016@\u0016X\u0004¢\u0006\u0012\n\u0004\b0\u00101\u0012\u0004\b4\u0010(\u001a\u0004\b2\u00103R\u0019\u0010\u000f\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b6\u0010%\u001a\u0004\b7\u0010\u000bR\"\u0010>\u001a\u0002088\u0016@\u0016X\u0004¢\u0006\u0012\n\u0004\b9\u0010:\u0012\u0004\b=\u0010(\u001a\u0004\b;\u0010<R\"\u0010B\u001a\u00020\t8\u0016@\u0016XD¢\u0006\u0012\n\u0004\b?\u0010%\u0012\u0004\bA\u0010(\u001a\u0004\b@\u0010\u000b¨\u0006E"}, d2 = {"Lcom/avito/android/user_adverts/root_screen/UserAdvertsFragmentData;", "Lcom/avito/android/bottom_navigation/ui/fragment/factory/TabFragmentFactory$Data;", "", "component1", "()Ljava/lang/String;", "component2", "Lcom/avito/android/user_advert/AdvertActionTransferData;", "component3", "()Lcom/avito/android/user_advert/AdvertActionTransferData;", "", "component4", "()Z", "shortcut", "message", "advertAction", "openPublish", "copy", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/user_advert/AdvertActionTransferData;Z)Lcom/avito/android/user_adverts/root_screen/UserAdvertsFragmentData;", "toString", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", g.a, "Lcom/avito/android/user_advert/AdvertActionTransferData;", "getAdvertAction", AuthSource.SEND_ABUSE, "Z", "getShowNavigation", "getShowNavigation$annotations", "()V", "showNavigation", "e", "Ljava/lang/String;", "getShortcut", "f", "getMessage", "Lcom/avito/android/bottom_navigation/NavigationTabControlSetItem;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/bottom_navigation/NavigationTabControlSetItem;", "getTabInControl", "()Lcom/avito/android/bottom_navigation/NavigationTabControlSetItem;", "getTabInControl$annotations", "tabInControl", "h", "getOpenPublish", "Lcom/avito/android/bottom_navigation/NavigationTabProfileRedesignTestSetItem;", "c", "Lcom/avito/android/bottom_navigation/NavigationTabProfileRedesignTestSetItem;", "getTabInProfileTest", "()Lcom/avito/android/bottom_navigation/NavigationTabProfileRedesignTestSetItem;", "getTabInProfileTest$annotations", "tabInProfileTest", "d", "getNeedAuthorization", "getNeedAuthorization$annotations", "needAuthorization", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/user_advert/AdvertActionTransferData;Z)V", "user-adverts_release"}, k = 1, mv = {1, 4, 2})
public final class UserAdvertsFragmentData implements TabFragmentFactory.Data {
    public static final Parcelable.Creator<UserAdvertsFragmentData> CREATOR = new Creator();
    public final boolean a;
    @NotNull
    public final NavigationTabControlSetItem b;
    @NotNull
    public final NavigationTabProfileRedesignTestSetItem c;
    public final boolean d;
    @Nullable
    public final String e;
    @Nullable
    public final String f;
    @Nullable
    public final AdvertActionTransferData g;
    public final boolean h;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<UserAdvertsFragmentData> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final UserAdvertsFragmentData createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new UserAdvertsFragmentData(parcel.readString(), parcel.readString(), (AdvertActionTransferData) parcel.readParcelable(UserAdvertsFragmentData.class.getClassLoader()), parcel.readInt() != 0);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final UserAdvertsFragmentData[] newArray(int i) {
            return new UserAdvertsFragmentData[i];
        }
    }

    public UserAdvertsFragmentData() {
        this(null, null, null, false, 15, null);
    }

    public UserAdvertsFragmentData(@Nullable String str, @Nullable String str2, @Nullable AdvertActionTransferData advertActionTransferData, boolean z) {
        this.e = str;
        this.f = str2;
        this.g = advertActionTransferData;
        this.h = z;
        this.a = true;
        this.b = NavigationTab.PROFILE.INSTANCE;
        this.c = NavigationTab.USER_ADVERTS.INSTANCE;
        this.d = true;
    }

    public static /* synthetic */ UserAdvertsFragmentData copy$default(UserAdvertsFragmentData userAdvertsFragmentData, String str, String str2, AdvertActionTransferData advertActionTransferData, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = userAdvertsFragmentData.e;
        }
        if ((i & 2) != 0) {
            str2 = userAdvertsFragmentData.f;
        }
        if ((i & 4) != 0) {
            advertActionTransferData = userAdvertsFragmentData.g;
        }
        if ((i & 8) != 0) {
            z = userAdvertsFragmentData.h;
        }
        return userAdvertsFragmentData.copy(str, str2, advertActionTransferData, z);
    }

    public static /* synthetic */ void getNeedAuthorization$annotations() {
    }

    public static /* synthetic */ void getShowNavigation$annotations() {
    }

    public static /* synthetic */ void getTabInControl$annotations() {
    }

    public static /* synthetic */ void getTabInProfileTest$annotations() {
    }

    @Nullable
    public final String component1() {
        return this.e;
    }

    @Nullable
    public final String component2() {
        return this.f;
    }

    @Nullable
    public final AdvertActionTransferData component3() {
        return this.g;
    }

    public final boolean component4() {
        return this.h;
    }

    @NotNull
    public final UserAdvertsFragmentData copy(@Nullable String str, @Nullable String str2, @Nullable AdvertActionTransferData advertActionTransferData, boolean z) {
        return new UserAdvertsFragmentData(str, str2, advertActionTransferData, z);
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
        if (!(obj instanceof UserAdvertsFragmentData)) {
            return false;
        }
        UserAdvertsFragmentData userAdvertsFragmentData = (UserAdvertsFragmentData) obj;
        return Intrinsics.areEqual(this.e, userAdvertsFragmentData.e) && Intrinsics.areEqual(this.f, userAdvertsFragmentData.f) && Intrinsics.areEqual(this.g, userAdvertsFragmentData.g) && this.h == userAdvertsFragmentData.h;
    }

    @Nullable
    public final AdvertActionTransferData getAdvertAction() {
        return this.g;
    }

    @Nullable
    public final String getMessage() {
        return this.f;
    }

    @Override // com.avito.android.bottom_navigation.ui.fragment.factory.TabFragmentFactory.Data
    public boolean getNeedAuthorization() {
        return this.d;
    }

    public final boolean getOpenPublish() {
        return this.h;
    }

    @Nullable
    public final String getShortcut() {
        return this.e;
    }

    @Override // com.avito.android.bottom_navigation.ui.fragment.factory.TabFragmentFactory.Data
    public boolean getShowNavigation() {
        return this.a;
    }

    @Override // com.avito.android.bottom_navigation.ui.fragment.factory.TabFragmentFactory.Data
    @NotNull
    public NavigationTabControlSetItem getTabInControl() {
        return this.b;
    }

    @Override // com.avito.android.bottom_navigation.ui.fragment.factory.TabFragmentFactory.Data
    @NotNull
    public NavigationTabProfileRedesignTestSetItem getTabInProfileTest() {
        return this.c;
    }

    @Override // java.lang.Object
    public int hashCode() {
        String str = this.e;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        AdvertActionTransferData advertActionTransferData = this.g;
        if (advertActionTransferData != null) {
            i = advertActionTransferData.hashCode();
        }
        int i2 = (hashCode2 + i) * 31;
        boolean z = this.h;
        if (z) {
            z = true;
        }
        int i3 = z ? 1 : 0;
        int i4 = z ? 1 : 0;
        int i5 = z ? 1 : 0;
        return i2 + i3;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("UserAdvertsFragmentData(shortcut=");
        L.append(this.e);
        L.append(", message=");
        L.append(this.f);
        L.append(", advertAction=");
        L.append(this.g);
        L.append(", openPublish=");
        return a.B(L, this.h, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.e);
        parcel.writeString(this.f);
        parcel.writeParcelable(this.g, i);
        parcel.writeInt(this.h ? 1 : 0);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ UserAdvertsFragmentData(String str, String str2, AdvertActionTransferData advertActionTransferData, boolean z, int i, j jVar) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : advertActionTransferData, (i & 8) != 0 ? false : z);
    }
}
