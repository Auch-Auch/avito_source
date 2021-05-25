package com.avito.android.orders.navigation;

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
import t6.r.a.j;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b)\u0010*J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0010\u001a\u00020\u000b8\u0016@\u0016XD¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0016\u001a\u0004\u0018\u00010\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001b\u0010\u0019\u001a\u0004\u0018\u00010\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0013\u001a\u0004\b\u0018\u0010\u0015R\u001c\u0010\u001f\u001a\u00020\u001a8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001c\u0010\"\u001a\u00020\u000b8\u0016@\u0016XD¢\u0006\f\n\u0004\b \u0010\r\u001a\u0004\b!\u0010\u000fR\u001c\u0010(\u001a\u00020#8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'¨\u0006+"}, d2 = {"Lcom/avito/android/orders/navigation/OrdersFragmentData;", "Lcom/avito/android/bottom_navigation/ui/fragment/factory/TabFragmentFactory$Data;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "d", "Z", "getShowNavigation", "()Z", "showNavigation", "", "f", "Ljava/lang/String;", "getOrdersToPrefetch", "()Ljava/lang/String;", "ordersToPrefetch", "e", "getTabToOpen", "tabToOpen", "Lcom/avito/android/bottom_navigation/NavigationTabProfileRedesignTestSetItem;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/bottom_navigation/NavigationTabProfileRedesignTestSetItem;", "getTabInProfileTest", "()Lcom/avito/android/bottom_navigation/NavigationTabProfileRedesignTestSetItem;", "tabInProfileTest", "c", "getNeedAuthorization", "needAuthorization", "Lcom/avito/android/bottom_navigation/NavigationTabControlSetItem;", AuthSource.SEND_ABUSE, "Lcom/avito/android/bottom_navigation/NavigationTabControlSetItem;", "getTabInControl", "()Lcom/avito/android/bottom_navigation/NavigationTabControlSetItem;", "tabInControl", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "orders_release"}, k = 1, mv = {1, 4, 2})
public final class OrdersFragmentData implements TabFragmentFactory.Data {
    public static final Parcelable.Creator<OrdersFragmentData> CREATOR = new Creator();
    @NotNull
    public final NavigationTabControlSetItem a;
    @NotNull
    public final NavigationTabProfileRedesignTestSetItem b;
    public final boolean c;
    public final boolean d;
    @Nullable
    public final String e;
    @Nullable
    public final String f;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<OrdersFragmentData> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final OrdersFragmentData createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new OrdersFragmentData(parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final OrdersFragmentData[] newArray(int i) {
            return new OrdersFragmentData[i];
        }
    }

    public OrdersFragmentData() {
        this(null, null, 3, null);
    }

    public OrdersFragmentData(@Nullable String str, @Nullable String str2) {
        this.e = str;
        this.f = str2;
        this.a = NavigationTab.PROFILE.INSTANCE;
        this.b = NavigationTab.PROFILE_SETTINGS.INSTANCE;
        this.c = true;
        this.d = true;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.avito.android.bottom_navigation.ui.fragment.factory.TabFragmentFactory.Data
    public boolean getNeedAuthorization() {
        return this.c;
    }

    @Nullable
    public final String getOrdersToPrefetch() {
        return this.f;
    }

    @Override // com.avito.android.bottom_navigation.ui.fragment.factory.TabFragmentFactory.Data
    public boolean getShowNavigation() {
        return this.d;
    }

    @Override // com.avito.android.bottom_navigation.ui.fragment.factory.TabFragmentFactory.Data
    @NotNull
    public NavigationTabControlSetItem getTabInControl() {
        return this.a;
    }

    @Override // com.avito.android.bottom_navigation.ui.fragment.factory.TabFragmentFactory.Data
    @NotNull
    public NavigationTabProfileRedesignTestSetItem getTabInProfileTest() {
        return this.b;
    }

    @Nullable
    public final String getTabToOpen() {
        return this.e;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.e);
        parcel.writeString(this.f);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ OrdersFragmentData(String str, String str2, int i, j jVar) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2);
    }
}
