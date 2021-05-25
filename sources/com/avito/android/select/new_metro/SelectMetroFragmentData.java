package com.avito.android.select.new_metro;

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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0013\u0012\u0006\u0010\u001c\u001a\u00020\u0019¢\u0006\u0004\b-\u0010.J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR$\u0010\u0012\u001a\u0004\u0018\u00010\u000b8\u0016@\u0016X\u0004¢\u0006\u0012\n\u0004\b\f\u0010\r\u0012\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0018\u001a\u00020\u00138\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR$\u0010#\u001a\u0004\u0018\u00010\u001d8\u0016@\u0016X\u0004¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u0012\u0004\b\"\u0010\u0011\u001a\u0004\b \u0010!R\"\u0010%\u001a\u00020$8\u0016@\u0016XD¢\u0006\u0012\n\u0004\b%\u0010&\u0012\u0004\b)\u0010\u0011\u001a\u0004\b'\u0010(R\"\u0010*\u001a\u00020$8\u0016@\u0016XD¢\u0006\u0012\n\u0004\b*\u0010&\u0012\u0004\b,\u0010\u0011\u001a\u0004\b+\u0010(¨\u0006/"}, d2 = {"Lcom/avito/android/select/new_metro/SelectMetroFragmentData;", "Lcom/avito/android/bottom_navigation/ui/fragment/factory/TabFragmentFactory$Data;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/bottom_navigation/NavigationTabProfileRedesignTestSetItem;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/bottom_navigation/NavigationTabProfileRedesignTestSetItem;", "getTabInProfileTest", "()Lcom/avito/android/bottom_navigation/NavigationTabProfileRedesignTestSetItem;", "getTabInProfileTest$annotations", "()V", "tabInProfileTest", "Lcom/avito/android/select/new_metro/SelectMetroParams;", "c", "Lcom/avito/android/select/new_metro/SelectMetroParams;", "getParams", "()Lcom/avito/android/select/new_metro/SelectMetroParams;", "params", "Lcom/avito/android/bottom_navigation/NavigationTabSetItem;", "d", "Lcom/avito/android/bottom_navigation/NavigationTabSetItem;", "tab", "Lcom/avito/android/bottom_navigation/NavigationTabControlSetItem;", AuthSource.SEND_ABUSE, "Lcom/avito/android/bottom_navigation/NavigationTabControlSetItem;", "getTabInControl", "()Lcom/avito/android/bottom_navigation/NavigationTabControlSetItem;", "getTabInControl$annotations", "tabInControl", "", "showNavigation", "Z", "getShowNavigation", "()Z", "getShowNavigation$annotations", "needAuthorization", "getNeedAuthorization", "getNeedAuthorization$annotations", "<init>", "(Lcom/avito/android/select/new_metro/SelectMetroParams;Lcom/avito/android/bottom_navigation/NavigationTabSetItem;)V", "select_release"}, k = 1, mv = {1, 4, 2})
public final class SelectMetroFragmentData implements TabFragmentFactory.Data {
    public static final Parcelable.Creator<SelectMetroFragmentData> CREATOR = new Creator();
    @Nullable
    public final NavigationTabControlSetItem a;
    @Nullable
    public final NavigationTabProfileRedesignTestSetItem b;
    @NotNull
    public final SelectMetroParams c;
    public final NavigationTabSetItem d;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<SelectMetroFragmentData> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final SelectMetroFragmentData createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new SelectMetroFragmentData(SelectMetroParams.CREATOR.createFromParcel(parcel), (NavigationTabSetItem) parcel.readParcelable(SelectMetroFragmentData.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final SelectMetroFragmentData[] newArray(int i) {
            return new SelectMetroFragmentData[i];
        }
    }

    public SelectMetroFragmentData(@NotNull SelectMetroParams selectMetroParams, @NotNull NavigationTabSetItem navigationTabSetItem) {
        Intrinsics.checkNotNullParameter(selectMetroParams, "params");
        Intrinsics.checkNotNullParameter(navigationTabSetItem, "tab");
        this.c = selectMetroParams;
        this.d = navigationTabSetItem;
        this.a = (NavigationTabControlSetItem) (!(navigationTabSetItem instanceof NavigationTabControlSetItem) ? null : navigationTabSetItem);
        this.b = (NavigationTabProfileRedesignTestSetItem) (!(navigationTabSetItem instanceof NavigationTabProfileRedesignTestSetItem) ? null : navigationTabSetItem);
    }

    public static /* synthetic */ void getNeedAuthorization$annotations() {
    }

    public static /* synthetic */ void getShowNavigation$annotations() {
    }

    public static /* synthetic */ void getTabInControl$annotations() {
    }

    public static /* synthetic */ void getTabInProfileTest$annotations() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.avito.android.bottom_navigation.ui.fragment.factory.TabFragmentFactory.Data
    public boolean getNeedAuthorization() {
        return false;
    }

    @NotNull
    public final SelectMetroParams getParams() {
        return this.c;
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

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        this.c.writeToParcel(parcel, 0);
        parcel.writeParcelable(this.d, i);
    }
}
