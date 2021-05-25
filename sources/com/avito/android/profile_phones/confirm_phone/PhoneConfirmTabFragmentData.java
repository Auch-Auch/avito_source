package com.avito.android.profile_phones.confirm_phone;

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
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u0013¢\u0006\u0004\b*\u0010+J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\"\u0010\u0012\u001a\u00020\u000b8\u0016@\u0016X\u0004¢\u0006\u0012\n\u0004\b\f\u0010\r\u0012\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0018\u001a\u00020\u00138\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\"\u0010\u001f\u001a\u00020\u00198\u0016@\u0016X\u0004¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u0012\u0004\b\u001e\u0010\u0011\u001a\u0004\b\u001c\u0010\u001dR\"\u0010!\u001a\u00020 8\u0016@\u0016XD¢\u0006\u0012\n\u0004\b!\u0010\"\u0012\u0004\b%\u0010\u0011\u001a\u0004\b#\u0010$R\"\u0010)\u001a\u00020 8\u0016@\u0016XD¢\u0006\u0012\n\u0004\b&\u0010\"\u0012\u0004\b(\u0010\u0011\u001a\u0004\b'\u0010$¨\u0006,"}, d2 = {"Lcom/avito/android/profile_phones/confirm_phone/PhoneConfirmTabFragmentData;", "Lcom/avito/android/bottom_navigation/ui/fragment/factory/TabFragmentFactory$Data;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/bottom_navigation/NavigationTabProfileRedesignTestSetItem;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/bottom_navigation/NavigationTabProfileRedesignTestSetItem;", "getTabInProfileTest", "()Lcom/avito/android/bottom_navigation/NavigationTabProfileRedesignTestSetItem;", "getTabInProfileTest$annotations", "()V", "tabInProfileTest", "Lcom/avito/android/profile_phones/confirm_phone/PhoneConfirmationArguments;", "d", "Lcom/avito/android/profile_phones/confirm_phone/PhoneConfirmationArguments;", "getArgs", "()Lcom/avito/android/profile_phones/confirm_phone/PhoneConfirmationArguments;", "args", "Lcom/avito/android/bottom_navigation/NavigationTabControlSetItem;", AuthSource.SEND_ABUSE, "Lcom/avito/android/bottom_navigation/NavigationTabControlSetItem;", "getTabInControl", "()Lcom/avito/android/bottom_navigation/NavigationTabControlSetItem;", "getTabInControl$annotations", "tabInControl", "", "showNavigation", "Z", "getShowNavigation", "()Z", "getShowNavigation$annotations", "c", "getNeedAuthorization", "getNeedAuthorization$annotations", "needAuthorization", "<init>", "(Lcom/avito/android/profile_phones/confirm_phone/PhoneConfirmationArguments;)V", "profile-phones_release"}, k = 1, mv = {1, 4, 2})
public final class PhoneConfirmTabFragmentData implements TabFragmentFactory.Data {
    public static final Parcelable.Creator<PhoneConfirmTabFragmentData> CREATOR = new Creator();
    @NotNull
    public final NavigationTabControlSetItem a = NavigationTab.PROFILE.INSTANCE;
    @NotNull
    public final NavigationTabProfileRedesignTestSetItem b = NavigationTab.PROFILE_SETTINGS.INSTANCE;
    public final boolean c = true;
    @NotNull
    public final PhoneConfirmationArguments d;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<PhoneConfirmTabFragmentData> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final PhoneConfirmTabFragmentData createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new PhoneConfirmTabFragmentData(PhoneConfirmationArguments.CREATOR.createFromParcel(parcel));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final PhoneConfirmTabFragmentData[] newArray(int i) {
            return new PhoneConfirmTabFragmentData[i];
        }
    }

    public PhoneConfirmTabFragmentData(@NotNull PhoneConfirmationArguments phoneConfirmationArguments) {
        Intrinsics.checkNotNullParameter(phoneConfirmationArguments, "args");
        this.d = phoneConfirmationArguments;
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

    @NotNull
    public final PhoneConfirmationArguments getArgs() {
        return this.d;
    }

    @Override // com.avito.android.bottom_navigation.ui.fragment.factory.TabFragmentFactory.Data
    public boolean getNeedAuthorization() {
        return this.c;
    }

    @Override // com.avito.android.bottom_navigation.ui.fragment.factory.TabFragmentFactory.Data
    public boolean getShowNavigation() {
        return false;
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

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        this.d.writeToParcel(parcel, 0);
    }
}
