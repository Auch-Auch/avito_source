package com.avito.android.suggest_locations;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.bottom_navigation.NavigationTabControlSetItem;
import com.avito.android.bottom_navigation.NavigationTabProfileRedesignTestSetItem;
import com.avito.android.bottom_navigation.NavigationTabSetItem;
import com.avito.android.bottom_navigation.ui.fragment.factory.TabFragmentFactory;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\f\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b8\u00109J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J$\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u0015\u0010\u000fJ \u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bR\u0016\u0010\u0007\u001a\u00020\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\"\u0010\u001e\u001a\u00020\u00128\u0016@\u0016XD¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u0012\u0004\b\"\u0010#\u001a\u0004\b \u0010!R$\u0010*\u001a\u0004\u0018\u00010$8\u0016@\u0016X\u0004¢\u0006\u0012\n\u0004\b%\u0010&\u0012\u0004\b)\u0010#\u001a\u0004\b'\u0010(R\"\u0010+\u001a\u00020\u00128\u0016@\u0016XD¢\u0006\u0012\n\u0004\b+\u0010\u001f\u0012\u0004\b-\u0010#\u001a\u0004\b,\u0010!R$\u00104\u001a\u0004\u0018\u00010.8\u0016@\u0016X\u0004¢\u0006\u0012\n\u0004\b/\u00100\u0012\u0004\b3\u0010#\u001a\u0004\b1\u00102R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b5\u00106\u001a\u0004\b7\u0010\u0004¨\u0006:"}, d2 = {"Lcom/avito/android/suggest_locations/SuggestLocationsFragmentData;", "Lcom/avito/android/bottom_navigation/ui/fragment/factory/TabFragmentFactory$Data;", "Lcom/avito/android/suggest_locations/SuggestLocationsArguments;", "component1", "()Lcom/avito/android/suggest_locations/SuggestLocationsArguments;", "arguments", "Lcom/avito/android/bottom_navigation/NavigationTabSetItem;", "tab", "copy", "(Lcom/avito/android/suggest_locations/SuggestLocationsArguments;Lcom/avito/android/bottom_navigation/NavigationTabSetItem;)Lcom/avito/android/suggest_locations/SuggestLocationsFragmentData;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "d", "Lcom/avito/android/bottom_navigation/NavigationTabSetItem;", "showNavigation", "Z", "getShowNavigation", "()Z", "getShowNavigation$annotations", "()V", "Lcom/avito/android/bottom_navigation/NavigationTabControlSetItem;", AuthSource.SEND_ABUSE, "Lcom/avito/android/bottom_navigation/NavigationTabControlSetItem;", "getTabInControl", "()Lcom/avito/android/bottom_navigation/NavigationTabControlSetItem;", "getTabInControl$annotations", "tabInControl", "needAuthorization", "getNeedAuthorization", "getNeedAuthorization$annotations", "Lcom/avito/android/bottom_navigation/NavigationTabProfileRedesignTestSetItem;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/bottom_navigation/NavigationTabProfileRedesignTestSetItem;", "getTabInProfileTest", "()Lcom/avito/android/bottom_navigation/NavigationTabProfileRedesignTestSetItem;", "getTabInProfileTest$annotations", "tabInProfileTest", "c", "Lcom/avito/android/suggest_locations/SuggestLocationsArguments;", "getArguments", "<init>", "(Lcom/avito/android/suggest_locations/SuggestLocationsArguments;Lcom/avito/android/bottom_navigation/NavigationTabSetItem;)V", "suggest-locations_release"}, k = 1, mv = {1, 4, 2})
public final class SuggestLocationsFragmentData implements TabFragmentFactory.Data {
    public static final Parcelable.Creator<SuggestLocationsFragmentData> CREATOR = new Creator();
    @Nullable
    public final NavigationTabControlSetItem a;
    @Nullable
    public final NavigationTabProfileRedesignTestSetItem b;
    @NotNull
    public final SuggestLocationsArguments c;
    public final NavigationTabSetItem d;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<SuggestLocationsFragmentData> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final SuggestLocationsFragmentData createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new SuggestLocationsFragmentData(SuggestLocationsArguments.CREATOR.createFromParcel(parcel), (NavigationTabSetItem) parcel.readParcelable(SuggestLocationsFragmentData.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final SuggestLocationsFragmentData[] newArray(int i) {
            return new SuggestLocationsFragmentData[i];
        }
    }

    public SuggestLocationsFragmentData(@NotNull SuggestLocationsArguments suggestLocationsArguments, @NotNull NavigationTabSetItem navigationTabSetItem) {
        Intrinsics.checkNotNullParameter(suggestLocationsArguments, "arguments");
        Intrinsics.checkNotNullParameter(navigationTabSetItem, "tab");
        this.c = suggestLocationsArguments;
        this.d = navigationTabSetItem;
        this.a = (NavigationTabControlSetItem) (!(navigationTabSetItem instanceof NavigationTabControlSetItem) ? null : navigationTabSetItem);
        this.b = (NavigationTabProfileRedesignTestSetItem) (!(navigationTabSetItem instanceof NavigationTabProfileRedesignTestSetItem) ? null : navigationTabSetItem);
    }

    public static /* synthetic */ SuggestLocationsFragmentData copy$default(SuggestLocationsFragmentData suggestLocationsFragmentData, SuggestLocationsArguments suggestLocationsArguments, NavigationTabSetItem navigationTabSetItem, int i, Object obj) {
        if ((i & 1) != 0) {
            suggestLocationsArguments = suggestLocationsFragmentData.c;
        }
        if ((i & 2) != 0) {
            navigationTabSetItem = suggestLocationsFragmentData.d;
        }
        return suggestLocationsFragmentData.copy(suggestLocationsArguments, navigationTabSetItem);
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
    public final SuggestLocationsArguments component1() {
        return this.c;
    }

    @NotNull
    public final SuggestLocationsFragmentData copy(@NotNull SuggestLocationsArguments suggestLocationsArguments, @NotNull NavigationTabSetItem navigationTabSetItem) {
        Intrinsics.checkNotNullParameter(suggestLocationsArguments, "arguments");
        Intrinsics.checkNotNullParameter(navigationTabSetItem, "tab");
        return new SuggestLocationsFragmentData(suggestLocationsArguments, navigationTabSetItem);
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
        if (!(obj instanceof SuggestLocationsFragmentData)) {
            return false;
        }
        SuggestLocationsFragmentData suggestLocationsFragmentData = (SuggestLocationsFragmentData) obj;
        return Intrinsics.areEqual(this.c, suggestLocationsFragmentData.c) && Intrinsics.areEqual(this.d, suggestLocationsFragmentData.d);
    }

    @NotNull
    public final SuggestLocationsArguments getArguments() {
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
        SuggestLocationsArguments suggestLocationsArguments = this.c;
        int i = 0;
        int hashCode = (suggestLocationsArguments != null ? suggestLocationsArguments.hashCode() : 0) * 31;
        NavigationTabSetItem navigationTabSetItem = this.d;
        if (navigationTabSetItem != null) {
            i = navigationTabSetItem.hashCode();
        }
        return hashCode + i;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("SuggestLocationsFragmentData(arguments=");
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
}
