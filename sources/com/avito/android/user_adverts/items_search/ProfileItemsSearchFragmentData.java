package com.avito.android.user_adverts.items_search;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.bottom_navigation.NavigationTab;
import com.avito.android.bottom_navigation.NavigationTabControlSetItem;
import com.avito.android.bottom_navigation.NavigationTabProfileRedesignTestSetItem;
import com.avito.android.bottom_navigation.ui.fragment.factory.TabFragmentFactory;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0010\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b4\u00105J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0011\u0010\u000bJ \u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017R\"\u0010\u001e\u001a\u00020\u000e8\u0016@\u0016XD¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u0012\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001a\u0010\u001bR\"\u0010%\u001a\u00020\u001f8\u0016@\u0016X\u0004¢\u0006\u0012\n\u0004\b \u0010!\u0012\u0004\b$\u0010\u001d\u001a\u0004\b\"\u0010#R\"\u0010,\u001a\u00020&8\u0016@\u0016X\u0004¢\u0006\u0012\n\u0004\b'\u0010(\u0012\u0004\b+\u0010\u001d\u001a\u0004\b)\u0010*R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u0010\u0004R\"\u00103\u001a\u00020\u000e8\u0016@\u0016XD¢\u0006\u0012\n\u0004\b0\u0010\u0019\u0012\u0004\b2\u0010\u001d\u001a\u0004\b1\u0010\u001b¨\u00066"}, d2 = {"Lcom/avito/android/user_adverts/items_search/ProfileItemsSearchFragmentData;", "Lcom/avito/android/bottom_navigation/ui/fragment/factory/TabFragmentFactory$Data;", "", "component1", "()Ljava/lang/String;", "shortcut", "copy", "(Ljava/lang/String;)Lcom/avito/android/user_adverts/items_search/ProfileItemsSearchFragmentData;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "d", "Z", "getNeedAuthorization", "()Z", "getNeedAuthorization$annotations", "()V", "needAuthorization", "Lcom/avito/android/bottom_navigation/NavigationTabProfileRedesignTestSetItem;", "c", "Lcom/avito/android/bottom_navigation/NavigationTabProfileRedesignTestSetItem;", "getTabInProfileTest", "()Lcom/avito/android/bottom_navigation/NavigationTabProfileRedesignTestSetItem;", "getTabInProfileTest$annotations", "tabInProfileTest", "Lcom/avito/android/bottom_navigation/NavigationTabControlSetItem;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/bottom_navigation/NavigationTabControlSetItem;", "getTabInControl", "()Lcom/avito/android/bottom_navigation/NavigationTabControlSetItem;", "getTabInControl$annotations", "tabInControl", "e", "Ljava/lang/String;", "getShortcut", AuthSource.SEND_ABUSE, "getShowNavigation", "getShowNavigation$annotations", "showNavigation", "<init>", "(Ljava/lang/String;)V", "user-adverts_release"}, k = 1, mv = {1, 4, 2})
public final class ProfileItemsSearchFragmentData implements TabFragmentFactory.Data {
    public static final Parcelable.Creator<ProfileItemsSearchFragmentData> CREATOR = new Creator();
    public final boolean a = true;
    @NotNull
    public final NavigationTabControlSetItem b = NavigationTab.PROFILE.INSTANCE;
    @NotNull
    public final NavigationTabProfileRedesignTestSetItem c = NavigationTab.USER_ADVERTS.INSTANCE;
    public final boolean d = true;
    @NotNull
    public final String e;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<ProfileItemsSearchFragmentData> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ProfileItemsSearchFragmentData createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new ProfileItemsSearchFragmentData(parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ProfileItemsSearchFragmentData[] newArray(int i) {
            return new ProfileItemsSearchFragmentData[i];
        }
    }

    public ProfileItemsSearchFragmentData(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "shortcut");
        this.e = str;
    }

    public static /* synthetic */ ProfileItemsSearchFragmentData copy$default(ProfileItemsSearchFragmentData profileItemsSearchFragmentData, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = profileItemsSearchFragmentData.e;
        }
        return profileItemsSearchFragmentData.copy(str);
    }

    public static /* synthetic */ void getNeedAuthorization$annotations() {
    }

    public static /* synthetic */ void getShowNavigation$annotations() {
    }

    public static /* synthetic */ void getTabInControl$annotations() {
    }

    public static /* synthetic */ void getTabInProfileTest$annotations() {
    }

    @NotNull
    public final String component1() {
        return this.e;
    }

    @NotNull
    public final ProfileItemsSearchFragmentData copy(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "shortcut");
        return new ProfileItemsSearchFragmentData(str);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.lang.Object
    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            return (obj instanceof ProfileItemsSearchFragmentData) && Intrinsics.areEqual(this.e, ((ProfileItemsSearchFragmentData) obj).e);
        }
        return true;
    }

    @Override // com.avito.android.bottom_navigation.ui.fragment.factory.TabFragmentFactory.Data
    public boolean getNeedAuthorization() {
        return this.d;
    }

    @NotNull
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
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        return a.t(a.L("ProfileItemsSearchFragmentData(shortcut="), this.e, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.e);
    }
}
