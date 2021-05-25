package com.avito.android.extended_profile;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.bottom_navigation.NavigationTabControlSetItem;
import com.avito.android.bottom_navigation.NavigationTabProfileRedesignTestSetItem;
import com.avito.android.bottom_navigation.NavigationTabSetItem;
import com.avito.android.bottom_navigation.ui.fragment.ShouldRetainCurrentTab;
import com.avito.android.bottom_navigation.ui.fragment.factory.TabFragmentFactory;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u000e\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b;\u0010<J\u0017\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ$\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\u00072\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0012J \u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u001d\u0010\u001eR$\u0010&\u001a\u0004\u0018\u00010\u001f8\u0016@\u0016X\u0004¢\u0006\u0012\n\u0004\b \u0010!\u0012\u0004\b$\u0010%\u001a\u0004\b\"\u0010#R\"\u0010'\u001a\u00020\u00158\u0016@\u0016XD¢\u0006\u0012\n\u0004\b'\u0010(\u0012\u0004\b+\u0010%\u001a\u0004\b)\u0010*R\"\u0010,\u001a\u00020\u00158\u0016@\u0016XD¢\u0006\u0012\n\u0004\b,\u0010(\u0012\u0004\b.\u0010%\u001a\u0004\b-\u0010*R$\u00105\u001a\u0004\u0018\u00010/8\u0016@\u0016X\u0004¢\u0006\u0012\n\u0004\b0\u00101\u0012\u0004\b4\u0010%\u001a\u0004\b2\u00103R\u0019\u0010\n\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b6\u00107\u001a\u0004\b8\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b9\u0010:¨\u0006="}, d2 = {"Lcom/avito/android/extended_profile/ExtendedProfileFragmentData;", "Lcom/avito/android/bottom_navigation/ui/fragment/factory/TabFragmentFactory$Data;", "Lcom/avito/android/bottom_navigation/ui/fragment/ShouldRetainCurrentTab;", "Lcom/avito/android/bottom_navigation/NavigationTabSetItem;", "tab", "copyWithTabIfRequired", "(Lcom/avito/android/bottom_navigation/NavigationTabSetItem;)Lcom/avito/android/extended_profile/ExtendedProfileFragmentData;", "Lcom/avito/android/extended_profile/ExtendedProfileArguments;", "component1", "()Lcom/avito/android/extended_profile/ExtendedProfileArguments;", "arguments", "copy", "(Lcom/avito/android/extended_profile/ExtendedProfileArguments;Lcom/avito/android/bottom_navigation/NavigationTabSetItem;)Lcom/avito/android/extended_profile/ExtendedProfileFragmentData;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/bottom_navigation/NavigationTabControlSetItem;", AuthSource.SEND_ABUSE, "Lcom/avito/android/bottom_navigation/NavigationTabControlSetItem;", "getTabInControl", "()Lcom/avito/android/bottom_navigation/NavigationTabControlSetItem;", "getTabInControl$annotations", "()V", "tabInControl", "needAuthorization", "Z", "getNeedAuthorization", "()Z", "getNeedAuthorization$annotations", "showNavigation", "getShowNavigation", "getShowNavigation$annotations", "Lcom/avito/android/bottom_navigation/NavigationTabProfileRedesignTestSetItem;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/bottom_navigation/NavigationTabProfileRedesignTestSetItem;", "getTabInProfileTest", "()Lcom/avito/android/bottom_navigation/NavigationTabProfileRedesignTestSetItem;", "getTabInProfileTest$annotations", "tabInProfileTest", "c", "Lcom/avito/android/extended_profile/ExtendedProfileArguments;", "getArguments", "d", "Lcom/avito/android/bottom_navigation/NavigationTabSetItem;", "<init>", "(Lcom/avito/android/extended_profile/ExtendedProfileArguments;Lcom/avito/android/bottom_navigation/NavigationTabSetItem;)V", "extended-profile_release"}, k = 1, mv = {1, 4, 2})
public final class ExtendedProfileFragmentData implements TabFragmentFactory.Data, ShouldRetainCurrentTab {
    public static final Parcelable.Creator<ExtendedProfileFragmentData> CREATOR = new Creator();
    @Nullable
    public final NavigationTabControlSetItem a;
    @Nullable
    public final NavigationTabProfileRedesignTestSetItem b;
    @NotNull
    public final ExtendedProfileArguments c;
    public final NavigationTabSetItem d;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<ExtendedProfileFragmentData> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ExtendedProfileFragmentData createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new ExtendedProfileFragmentData(ExtendedProfileArguments.CREATOR.createFromParcel(parcel), (NavigationTabSetItem) parcel.readParcelable(ExtendedProfileFragmentData.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ExtendedProfileFragmentData[] newArray(int i) {
            return new ExtendedProfileFragmentData[i];
        }
    }

    public ExtendedProfileFragmentData(@NotNull ExtendedProfileArguments extendedProfileArguments, @NotNull NavigationTabSetItem navigationTabSetItem) {
        Intrinsics.checkNotNullParameter(extendedProfileArguments, "arguments");
        Intrinsics.checkNotNullParameter(navigationTabSetItem, "tab");
        this.c = extendedProfileArguments;
        this.d = navigationTabSetItem;
        this.a = (NavigationTabControlSetItem) (!(navigationTabSetItem instanceof NavigationTabControlSetItem) ? null : navigationTabSetItem);
        this.b = (NavigationTabProfileRedesignTestSetItem) (!(navigationTabSetItem instanceof NavigationTabProfileRedesignTestSetItem) ? null : navigationTabSetItem);
    }

    public static /* synthetic */ ExtendedProfileFragmentData copy$default(ExtendedProfileFragmentData extendedProfileFragmentData, ExtendedProfileArguments extendedProfileArguments, NavigationTabSetItem navigationTabSetItem, int i, Object obj) {
        if ((i & 1) != 0) {
            extendedProfileArguments = extendedProfileFragmentData.c;
        }
        if ((i & 2) != 0) {
            navigationTabSetItem = extendedProfileFragmentData.d;
        }
        return extendedProfileFragmentData.copy(extendedProfileArguments, navigationTabSetItem);
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
    public final ExtendedProfileArguments component1() {
        return this.c;
    }

    @NotNull
    public final ExtendedProfileFragmentData copy(@NotNull ExtendedProfileArguments extendedProfileArguments, @NotNull NavigationTabSetItem navigationTabSetItem) {
        Intrinsics.checkNotNullParameter(extendedProfileArguments, "arguments");
        Intrinsics.checkNotNullParameter(navigationTabSetItem, "tab");
        return new ExtendedProfileFragmentData(extendedProfileArguments, navigationTabSetItem);
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
        if (!(obj instanceof ExtendedProfileFragmentData)) {
            return false;
        }
        ExtendedProfileFragmentData extendedProfileFragmentData = (ExtendedProfileFragmentData) obj;
        return Intrinsics.areEqual(this.c, extendedProfileFragmentData.c) && Intrinsics.areEqual(this.d, extendedProfileFragmentData.d);
    }

    @NotNull
    public final ExtendedProfileArguments getArguments() {
        return this.c;
    }

    @Override // com.avito.android.bottom_navigation.ui.fragment.factory.TabFragmentFactory.Data
    public boolean getNeedAuthorization() {
        return false;
    }

    @Override // com.avito.android.bottom_navigation.ui.fragment.factory.TabFragmentFactory.Data
    public boolean getShowNavigation() {
        return false;
    }

    @Override // com.avito.android.bottom_navigation.ui.fragment.factory.TabFragmentFactory.Data
    @Nullable
    public NavigationTabControlSetItem getTabInControl() {
        return this.a;
    }

    @Override // com.avito.android.bottom_navigation.ui.fragment.factory.TabFragmentFactory.Data
    @Nullable
    public NavigationTabProfileRedesignTestSetItem getTabInProfileTest() {
        return this.b;
    }

    @Override // java.lang.Object
    public int hashCode() {
        ExtendedProfileArguments extendedProfileArguments = this.c;
        int i = 0;
        int hashCode = (extendedProfileArguments != null ? extendedProfileArguments.hashCode() : 0) * 31;
        NavigationTabSetItem navigationTabSetItem = this.d;
        if (navigationTabSetItem != null) {
            i = navigationTabSetItem.hashCode();
        }
        return hashCode + i;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("ExtendedProfileFragmentData(arguments=");
        L.append(this.c);
        L.append(", tab=");
        L.append(this.d);
        L.append(")");
        return L.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        this.c.writeToParcel(parcel, 0);
        parcel.writeParcelable(this.d, i);
    }

    @Override // com.avito.android.bottom_navigation.ui.fragment.ShouldRetainCurrentTab
    @NotNull
    public ExtendedProfileFragmentData copyWithTabIfRequired(@NotNull NavigationTabSetItem navigationTabSetItem) {
        Intrinsics.checkNotNullParameter(navigationTabSetItem, "tab");
        return copy$default(this, null, navigationTabSetItem, 1, null);
    }
}
