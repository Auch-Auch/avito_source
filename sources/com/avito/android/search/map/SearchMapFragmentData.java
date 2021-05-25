package com.avito.android.search.map;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.bottom_navigation.NavigationTab;
import com.avito.android.bottom_navigation.NavigationTabControlSetItem;
import com.avito.android.bottom_navigation.NavigationTabProfileRedesignTestSetItem;
import com.avito.android.bottom_navigation.NavigationTabSetItem;
import com.avito.android.bottom_navigation.ui.fragment.ShouldRetainCurrentTab;
import com.avito.android.bottom_navigation.ui.fragment.factory.TabFragmentFactory;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.search.map.SearchMapFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0012\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b<\u0010=J\u0017\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ$\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\u00072\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0012J \u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u001d\u0010\u001eR$\u0010&\u001a\u0004\u0018\u00010\u001f8\u0016@\u0016X\u0004¢\u0006\u0012\n\u0004\b \u0010!\u0012\u0004\b$\u0010%\u001a\u0004\b\"\u0010#R\"\u0010'\u001a\u00020\u00158\u0016@\u0016XD¢\u0006\u0012\n\u0004\b'\u0010(\u0012\u0004\b+\u0010%\u001a\u0004\b)\u0010*R$\u00102\u001a\u0004\u0018\u00010,8\u0016@\u0016X\u0004¢\u0006\u0012\n\u0004\b-\u0010.\u0012\u0004\b1\u0010%\u001a\u0004\b/\u00100R\u0019\u0010\n\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u0010\tR\"\u00109\u001a\u00020\u00158\u0016@\u0016XD¢\u0006\u0012\n\u0004\b6\u0010(\u0012\u0004\b8\u0010%\u001a\u0004\b7\u0010*R\u0016\u0010\u0004\u001a\u00020\u00038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b:\u0010;¨\u0006>"}, d2 = {"Lcom/avito/android/search/map/SearchMapFragmentData;", "Lcom/avito/android/bottom_navigation/ui/fragment/factory/TabFragmentFactory$Data;", "Lcom/avito/android/bottom_navigation/ui/fragment/ShouldRetainCurrentTab;", "Lcom/avito/android/bottom_navigation/NavigationTabSetItem;", "tab", "copyWithTabIfRequired", "(Lcom/avito/android/bottom_navigation/NavigationTabSetItem;)Lcom/avito/android/search/map/SearchMapFragmentData;", "Lcom/avito/android/search/map/SearchMapFragment$Factory$Arguments;", "component1", "()Lcom/avito/android/search/map/SearchMapFragment$Factory$Arguments;", "arguments", "copy", "(Lcom/avito/android/search/map/SearchMapFragment$Factory$Arguments;Lcom/avito/android/bottom_navigation/NavigationTabSetItem;)Lcom/avito/android/search/map/SearchMapFragmentData;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/bottom_navigation/NavigationTabControlSetItem;", AuthSource.SEND_ABUSE, "Lcom/avito/android/bottom_navigation/NavigationTabControlSetItem;", "getTabInControl", "()Lcom/avito/android/bottom_navigation/NavigationTabControlSetItem;", "getTabInControl$annotations", "()V", "tabInControl", "needAuthorization", "Z", "getNeedAuthorization", "()Z", "getNeedAuthorization$annotations", "Lcom/avito/android/bottom_navigation/NavigationTabProfileRedesignTestSetItem;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/bottom_navigation/NavigationTabProfileRedesignTestSetItem;", "getTabInProfileTest", "()Lcom/avito/android/bottom_navigation/NavigationTabProfileRedesignTestSetItem;", "getTabInProfileTest$annotations", "tabInProfileTest", "d", "Lcom/avito/android/search/map/SearchMapFragment$Factory$Arguments;", "getArguments", "c", "getShowNavigation", "getShowNavigation$annotations", "showNavigation", "e", "Lcom/avito/android/bottom_navigation/NavigationTabSetItem;", "<init>", "(Lcom/avito/android/search/map/SearchMapFragment$Factory$Arguments;Lcom/avito/android/bottom_navigation/NavigationTabSetItem;)V", "map_release"}, k = 1, mv = {1, 4, 2})
public final class SearchMapFragmentData implements TabFragmentFactory.Data, ShouldRetainCurrentTab {
    public static final Parcelable.Creator<SearchMapFragmentData> CREATOR = new Creator();
    @Nullable
    public final NavigationTabControlSetItem a;
    @Nullable
    public final NavigationTabProfileRedesignTestSetItem b;
    public final boolean c;
    @NotNull
    public final SearchMapFragment.Factory.Arguments d;
    public final NavigationTabSetItem e;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<SearchMapFragmentData> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final SearchMapFragmentData createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new SearchMapFragmentData((SearchMapFragment.Factory.Arguments) parcel.readParcelable(SearchMapFragmentData.class.getClassLoader()), (NavigationTabSetItem) parcel.readParcelable(SearchMapFragmentData.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final SearchMapFragmentData[] newArray(int i) {
            return new SearchMapFragmentData[i];
        }
    }

    public SearchMapFragmentData(@NotNull SearchMapFragment.Factory.Arguments arguments, @NotNull NavigationTabSetItem navigationTabSetItem) {
        Intrinsics.checkNotNullParameter(arguments, "arguments");
        Intrinsics.checkNotNullParameter(navigationTabSetItem, "tab");
        this.d = arguments;
        this.e = navigationTabSetItem;
        this.a = (NavigationTabControlSetItem) (!(navigationTabSetItem instanceof NavigationTabControlSetItem) ? null : navigationTabSetItem);
        this.b = (NavigationTabProfileRedesignTestSetItem) (!(navigationTabSetItem instanceof NavigationTabProfileRedesignTestSetItem) ? null : navigationTabSetItem);
        this.c = true;
    }

    public static /* synthetic */ SearchMapFragmentData copy$default(SearchMapFragmentData searchMapFragmentData, SearchMapFragment.Factory.Arguments arguments, NavigationTabSetItem navigationTabSetItem, int i, Object obj) {
        if ((i & 1) != 0) {
            arguments = searchMapFragmentData.d;
        }
        if ((i & 2) != 0) {
            navigationTabSetItem = searchMapFragmentData.e;
        }
        return searchMapFragmentData.copy(arguments, navigationTabSetItem);
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
    public final SearchMapFragment.Factory.Arguments component1() {
        return this.d;
    }

    @NotNull
    public final SearchMapFragmentData copy(@NotNull SearchMapFragment.Factory.Arguments arguments, @NotNull NavigationTabSetItem navigationTabSetItem) {
        Intrinsics.checkNotNullParameter(arguments, "arguments");
        Intrinsics.checkNotNullParameter(navigationTabSetItem, "tab");
        return new SearchMapFragmentData(arguments, navigationTabSetItem);
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
        if (!(obj instanceof SearchMapFragmentData)) {
            return false;
        }
        SearchMapFragmentData searchMapFragmentData = (SearchMapFragmentData) obj;
        return Intrinsics.areEqual(this.d, searchMapFragmentData.d) && Intrinsics.areEqual(this.e, searchMapFragmentData.e);
    }

    @NotNull
    public final SearchMapFragment.Factory.Arguments getArguments() {
        return this.d;
    }

    @Override // com.avito.android.bottom_navigation.ui.fragment.factory.TabFragmentFactory.Data
    public boolean getNeedAuthorization() {
        return false;
    }

    @Override // com.avito.android.bottom_navigation.ui.fragment.factory.TabFragmentFactory.Data
    public boolean getShowNavigation() {
        return this.c;
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
        SearchMapFragment.Factory.Arguments arguments = this.d;
        int i = 0;
        int hashCode = (arguments != null ? arguments.hashCode() : 0) * 31;
        NavigationTabSetItem navigationTabSetItem = this.e;
        if (navigationTabSetItem != null) {
            i = navigationTabSetItem.hashCode();
        }
        return hashCode + i;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("SearchMapFragmentData(arguments=");
        L.append(this.d);
        L.append(", tab=");
        L.append(this.e);
        L.append(")");
        return L.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeParcelable(this.d, i);
        parcel.writeParcelable(this.e, i);
    }

    @Override // com.avito.android.bottom_navigation.ui.fragment.ShouldRetainCurrentTab
    @NotNull
    public SearchMapFragmentData copyWithTabIfRequired(@NotNull NavigationTabSetItem navigationTabSetItem) {
        Intrinsics.checkNotNullParameter(navigationTabSetItem, "tab");
        return (Intrinsics.areEqual(navigationTabSetItem, NavigationTab.FAVORITES.INSTANCE) || Intrinsics.areEqual(navigationTabSetItem, NavigationTab.SEARCH.INSTANCE)) ? copy$default(this, null, navigationTabSetItem, 1, null) : this;
    }
}
