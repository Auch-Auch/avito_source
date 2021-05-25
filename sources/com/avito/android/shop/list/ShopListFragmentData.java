package com.avito.android.shop.list;

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
import com.avito.android.remote.shop.filter.ShopsSearchParameters;
import com.avito.android.util.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\t\b\b\u0018\u00002\u00020\u00012\u00020\u0002B!\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\bA\u0010BJ\u0017\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\u000b\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ0\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\u00072\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u0011\u0010\fJ\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u0014J \u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u001f\u0010 R\u0019\u0010\r\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010%R$\u0010-\u001a\u0004\u0018\u00010&8\u0016@\u0016X\u0004¢\u0006\u0012\n\u0004\b'\u0010(\u0012\u0004\b+\u0010,\u001a\u0004\b)\u0010*R\"\u00103\u001a\u00020\u00178\u0016@\u0016XD¢\u0006\u0012\n\u0004\b.\u0010/\u0012\u0004\b2\u0010,\u001a\u0004\b0\u00101R\u001b\u0010\u000e\u001a\u0004\u0018\u00010\n8\u0006@\u0006¢\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u0010\fR\"\u00107\u001a\u00020\u00178\u0016@\u0016XD¢\u0006\u0012\n\u0004\b7\u0010/\u0012\u0004\b9\u0010,\u001a\u0004\b8\u00101R$\u0010@\u001a\u0004\u0018\u00010:8\u0016@\u0016X\u0004¢\u0006\u0012\n\u0004\b;\u0010<\u0012\u0004\b?\u0010,\u001a\u0004\b=\u0010>¨\u0006C"}, d2 = {"Lcom/avito/android/shop/list/ShopListFragmentData;", "Lcom/avito/android/bottom_navigation/ui/fragment/factory/TabFragmentFactory$Data;", "Lcom/avito/android/bottom_navigation/ui/fragment/ShouldRetainCurrentTab;", "Lcom/avito/android/bottom_navigation/NavigationTabSetItem;", "tab", "copyWithTabIfRequired", "(Lcom/avito/android/bottom_navigation/NavigationTabSetItem;)Lcom/avito/android/shop/list/ShopListFragmentData;", "Lcom/avito/android/remote/shop/filter/ShopsSearchParameters;", "component1", "()Lcom/avito/android/remote/shop/filter/ShopsSearchParameters;", "", "component2", "()Ljava/lang/String;", "params", Constants.LOCATION_NAME, "copy", "(Lcom/avito/android/remote/shop/filter/ShopsSearchParameters;Ljava/lang/String;Lcom/avito/android/bottom_navigation/NavigationTabSetItem;)Lcom/avito/android/shop/list/ShopListFragmentData;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "d", "Lcom/avito/android/remote/shop/filter/ShopsSearchParameters;", "getParams", "f", "Lcom/avito/android/bottom_navigation/NavigationTabSetItem;", "Lcom/avito/android/bottom_navigation/NavigationTabControlSetItem;", AuthSource.SEND_ABUSE, "Lcom/avito/android/bottom_navigation/NavigationTabControlSetItem;", "getTabInControl", "()Lcom/avito/android/bottom_navigation/NavigationTabControlSetItem;", "getTabInControl$annotations", "()V", "tabInControl", "c", "Z", "getShowNavigation", "()Z", "getShowNavigation$annotations", "showNavigation", "e", "Ljava/lang/String;", "getLocationName", "needAuthorization", "getNeedAuthorization", "getNeedAuthorization$annotations", "Lcom/avito/android/bottom_navigation/NavigationTabProfileRedesignTestSetItem;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/bottom_navigation/NavigationTabProfileRedesignTestSetItem;", "getTabInProfileTest", "()Lcom/avito/android/bottom_navigation/NavigationTabProfileRedesignTestSetItem;", "getTabInProfileTest$annotations", "tabInProfileTest", "<init>", "(Lcom/avito/android/remote/shop/filter/ShopsSearchParameters;Ljava/lang/String;Lcom/avito/android/bottom_navigation/NavigationTabSetItem;)V", "shop_release"}, k = 1, mv = {1, 4, 2})
public final class ShopListFragmentData implements TabFragmentFactory.Data, ShouldRetainCurrentTab {
    public static final Parcelable.Creator<ShopListFragmentData> CREATOR = new Creator();
    @Nullable
    public final NavigationTabControlSetItem a;
    @Nullable
    public final NavigationTabProfileRedesignTestSetItem b;
    public final boolean c;
    @NotNull
    public final ShopsSearchParameters d;
    @Nullable
    public final String e;
    public final NavigationTabSetItem f;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<ShopListFragmentData> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ShopListFragmentData createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new ShopListFragmentData((ShopsSearchParameters) parcel.readParcelable(ShopListFragmentData.class.getClassLoader()), parcel.readString(), (NavigationTabSetItem) parcel.readParcelable(ShopListFragmentData.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ShopListFragmentData[] newArray(int i) {
            return new ShopListFragmentData[i];
        }
    }

    public ShopListFragmentData(@NotNull ShopsSearchParameters shopsSearchParameters, @Nullable String str, @NotNull NavigationTabSetItem navigationTabSetItem) {
        Intrinsics.checkNotNullParameter(shopsSearchParameters, "params");
        Intrinsics.checkNotNullParameter(navigationTabSetItem, "tab");
        this.d = shopsSearchParameters;
        this.e = str;
        this.f = navigationTabSetItem;
        this.a = (NavigationTabControlSetItem) (!(navigationTabSetItem instanceof NavigationTabControlSetItem) ? null : navigationTabSetItem);
        this.b = (NavigationTabProfileRedesignTestSetItem) (!(navigationTabSetItem instanceof NavigationTabProfileRedesignTestSetItem) ? null : navigationTabSetItem);
        this.c = true;
    }

    public static /* synthetic */ ShopListFragmentData copy$default(ShopListFragmentData shopListFragmentData, ShopsSearchParameters shopsSearchParameters, String str, NavigationTabSetItem navigationTabSetItem, int i, Object obj) {
        if ((i & 1) != 0) {
            shopsSearchParameters = shopListFragmentData.d;
        }
        if ((i & 2) != 0) {
            str = shopListFragmentData.e;
        }
        if ((i & 4) != 0) {
            navigationTabSetItem = shopListFragmentData.f;
        }
        return shopListFragmentData.copy(shopsSearchParameters, str, navigationTabSetItem);
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
    public final ShopsSearchParameters component1() {
        return this.d;
    }

    @Nullable
    public final String component2() {
        return this.e;
    }

    @NotNull
    public final ShopListFragmentData copy(@NotNull ShopsSearchParameters shopsSearchParameters, @Nullable String str, @NotNull NavigationTabSetItem navigationTabSetItem) {
        Intrinsics.checkNotNullParameter(shopsSearchParameters, "params");
        Intrinsics.checkNotNullParameter(navigationTabSetItem, "tab");
        return new ShopListFragmentData(shopsSearchParameters, str, navigationTabSetItem);
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
        if (!(obj instanceof ShopListFragmentData)) {
            return false;
        }
        ShopListFragmentData shopListFragmentData = (ShopListFragmentData) obj;
        return Intrinsics.areEqual(this.d, shopListFragmentData.d) && Intrinsics.areEqual(this.e, shopListFragmentData.e) && Intrinsics.areEqual(this.f, shopListFragmentData.f);
    }

    @Nullable
    public final String getLocationName() {
        return this.e;
    }

    @Override // com.avito.android.bottom_navigation.ui.fragment.factory.TabFragmentFactory.Data
    public boolean getNeedAuthorization() {
        return false;
    }

    @NotNull
    public final ShopsSearchParameters getParams() {
        return this.d;
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
        ShopsSearchParameters shopsSearchParameters = this.d;
        int i = 0;
        int hashCode = (shopsSearchParameters != null ? shopsSearchParameters.hashCode() : 0) * 31;
        String str = this.e;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        NavigationTabSetItem navigationTabSetItem = this.f;
        if (navigationTabSetItem != null) {
            i = navigationTabSetItem.hashCode();
        }
        return hashCode2 + i;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("ShopListFragmentData(params=");
        L.append(this.d);
        L.append(", locationName=");
        L.append(this.e);
        L.append(", tab=");
        L.append(this.f);
        L.append(")");
        return L.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeParcelable(this.d, i);
        parcel.writeString(this.e);
        parcel.writeParcelable(this.f, i);
    }

    @Override // com.avito.android.bottom_navigation.ui.fragment.ShouldRetainCurrentTab
    @NotNull
    public ShopListFragmentData copyWithTabIfRequired(@NotNull NavigationTabSetItem navigationTabSetItem) {
        Intrinsics.checkNotNullParameter(navigationTabSetItem, "tab");
        return (Intrinsics.areEqual(navigationTabSetItem, NavigationTab.FAVORITES.INSTANCE) || Intrinsics.areEqual(navigationTabSetItem, NavigationTab.SEARCH.INSTANCE)) ? copy$default(this, null, null, navigationTabSetItem, 3, null) : this;
    }
}
