package com.avito.android.settings.ui;

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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0011\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b1\u00102J\u001a\u0010\u0004\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0011\u0010\u000bJ \u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R$\u0010!\u001a\u0004\u0018\u00010\u001a8\u0016@\u0016X\u0004¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u0012\u0004\b\u001f\u0010 \u001a\u0004\b\u001d\u0010\u001eR$\u0010(\u001a\u0004\u0018\u00010\"8\u0016@\u0016X\u0004¢\u0006\u0012\n\u0004\b#\u0010$\u0012\u0004\b'\u0010 \u001a\u0004\b%\u0010&R\"\u0010)\u001a\u00020\u000e8\u0016@\u0016XD¢\u0006\u0012\n\u0004\b)\u0010*\u0012\u0004\b-\u0010 \u001a\u0004\b+\u0010,R\"\u0010.\u001a\u00020\u000e8\u0016@\u0016XD¢\u0006\u0012\n\u0004\b.\u0010*\u0012\u0004\b0\u0010 \u001a\u0004\b/\u0010,¨\u00063"}, d2 = {"Lcom/avito/android/settings/ui/SettingsFragmentData;", "Lcom/avito/android/bottom_navigation/ui/fragment/factory/TabFragmentFactory$Data;", "Lcom/avito/android/bottom_navigation/NavigationTabSetItem;", "tab", "copy", "(Lcom/avito/android/bottom_navigation/NavigationTabSetItem;)Lcom/avito/android/settings/ui/SettingsFragmentData;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "c", "Lcom/avito/android/bottom_navigation/NavigationTabSetItem;", "Lcom/avito/android/bottom_navigation/NavigationTabProfileRedesignTestSetItem;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/bottom_navigation/NavigationTabProfileRedesignTestSetItem;", "getTabInProfileTest", "()Lcom/avito/android/bottom_navigation/NavigationTabProfileRedesignTestSetItem;", "getTabInProfileTest$annotations", "()V", "tabInProfileTest", "Lcom/avito/android/bottom_navigation/NavigationTabControlSetItem;", AuthSource.SEND_ABUSE, "Lcom/avito/android/bottom_navigation/NavigationTabControlSetItem;", "getTabInControl", "()Lcom/avito/android/bottom_navigation/NavigationTabControlSetItem;", "getTabInControl$annotations", "tabInControl", "needAuthorization", "Z", "getNeedAuthorization", "()Z", "getNeedAuthorization$annotations", "showNavigation", "getShowNavigation", "getShowNavigation$annotations", "<init>", "(Lcom/avito/android/bottom_navigation/NavigationTabSetItem;)V", "settings_release"}, k = 1, mv = {1, 4, 2})
public final class SettingsFragmentData implements TabFragmentFactory.Data {
    public static final Parcelable.Creator<SettingsFragmentData> CREATOR = new Creator();
    @Nullable
    public final NavigationTabControlSetItem a;
    @Nullable
    public final NavigationTabProfileRedesignTestSetItem b;
    public final NavigationTabSetItem c;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<SettingsFragmentData> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final SettingsFragmentData createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new SettingsFragmentData((NavigationTabSetItem) parcel.readParcelable(SettingsFragmentData.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final SettingsFragmentData[] newArray(int i) {
            return new SettingsFragmentData[i];
        }
    }

    public SettingsFragmentData(@NotNull NavigationTabSetItem navigationTabSetItem) {
        Intrinsics.checkNotNullParameter(navigationTabSetItem, "tab");
        this.c = navigationTabSetItem;
        this.a = (NavigationTabControlSetItem) (!(navigationTabSetItem instanceof NavigationTabControlSetItem) ? null : navigationTabSetItem);
        this.b = (NavigationTabProfileRedesignTestSetItem) (!(navigationTabSetItem instanceof NavigationTabProfileRedesignTestSetItem) ? null : navigationTabSetItem);
    }

    public static /* synthetic */ SettingsFragmentData copy$default(SettingsFragmentData settingsFragmentData, NavigationTabSetItem navigationTabSetItem, int i, Object obj) {
        if ((i & 1) != 0) {
            navigationTabSetItem = settingsFragmentData.c;
        }
        return settingsFragmentData.copy(navigationTabSetItem);
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
    public final SettingsFragmentData copy(@NotNull NavigationTabSetItem navigationTabSetItem) {
        Intrinsics.checkNotNullParameter(navigationTabSetItem, "tab");
        return new SettingsFragmentData(navigationTabSetItem);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.lang.Object
    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            return (obj instanceof SettingsFragmentData) && Intrinsics.areEqual(this.c, ((SettingsFragmentData) obj).c);
        }
        return true;
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
        NavigationTabSetItem navigationTabSetItem = this.c;
        if (navigationTabSetItem != null) {
            return navigationTabSetItem.hashCode();
        }
        return 0;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("SettingsFragmentData(tab=");
        L.append(this.c);
        L.append(")");
        return L.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeParcelable(this.c, i);
    }
}
