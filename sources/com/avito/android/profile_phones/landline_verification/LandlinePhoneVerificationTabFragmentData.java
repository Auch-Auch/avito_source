package com.avito.android.profile_phones.landline_verification;

import a2.g.r.g;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.bottom_navigation.NavigationTab;
import com.avito.android.bottom_navigation.NavigationTabControlSetItem;
import com.avito.android.bottom_navigation.NavigationTabProfileRedesignTestSetItem;
import com.avito.android.bottom_navigation.ui.fragment.factory.TabFragmentFactory;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.text.AttributedText;
import com.facebook.share.internal.MessengerShareContentUtility;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u001b\u001a\u00020\u0002\u0012\u0006\u0010\u001e\u001a\u00020\u0012\u0012\u0006\u0010(\u001a\u00020\u0012\u0012\u0006\u0010.\u001a\u00020)\u0012\u0006\u0010\u0017\u001a\u00020\u0012\u0012\u0006\u0010;\u001a\u00020\u000b¢\u0006\u0004\b<\u0010=J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\"\u0010\f\u001a\u00020\u000b8\u0016@\u0016XD¢\u0006\u0012\n\u0004\b\f\u0010\r\u0012\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0017\u001a\u00020\u00128\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0019\u0010\u001b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u0004R\u0019\u0010\u001e\u001a\u00020\u00128\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u0014\u001a\u0004\b\u001d\u0010\u0016R\"\u0010%\u001a\u00020\u001f8\u0016@\u0016X\u0004¢\u0006\u0012\n\u0004\b \u0010!\u0012\u0004\b$\u0010\u0011\u001a\u0004\b\"\u0010#R\u0019\u0010(\u001a\u00020\u00128\u0006@\u0006¢\u0006\f\n\u0004\b&\u0010\u0014\u001a\u0004\b'\u0010\u0016R\u0019\u0010.\u001a\u00020)8\u0006@\u0006¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R\"\u00102\u001a\u00020\u000b8\u0016@\u0016XD¢\u0006\u0012\n\u0004\b/\u0010\r\u0012\u0004\b1\u0010\u0011\u001a\u0004\b0\u0010\u000fR\"\u00109\u001a\u0002038\u0016@\u0016X\u0004¢\u0006\u0012\n\u0004\b4\u00105\u0012\u0004\b8\u0010\u0011\u001a\u0004\b6\u00107R\u0019\u0010;\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b:\u0010\r\u001a\u0004\b;\u0010\u000f¨\u0006>"}, d2 = {"Lcom/avito/android/profile_phones/landline_verification/LandlinePhoneVerificationTabFragmentData;", "Lcom/avito/android/bottom_navigation/ui/fragment/factory/TabFragmentFactory$Data;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "showNavigation", "Z", "getShowNavigation", "()Z", "getShowNavigation$annotations", "()V", "", "h", "Ljava/lang/String;", "getPhone", "()Ljava/lang/String;", "phone", "d", "I", "getCallId", "callId", "e", "getTitle", "title", "Lcom/avito/android/bottom_navigation/NavigationTabControlSetItem;", AuthSource.SEND_ABUSE, "Lcom/avito/android/bottom_navigation/NavigationTabControlSetItem;", "getTabInControl", "()Lcom/avito/android/bottom_navigation/NavigationTabControlSetItem;", "getTabInControl$annotations", "tabInControl", "f", "getSubtitle", MessengerShareContentUtility.SUBTITLE, "Lcom/avito/android/remote/model/text/AttributedText;", g.a, "Lcom/avito/android/remote/model/text/AttributedText;", "getDescription", "()Lcom/avito/android/remote/model/text/AttributedText;", "description", "c", "getNeedAuthorization", "getNeedAuthorization$annotations", "needAuthorization", "Lcom/avito/android/bottom_navigation/NavigationTabProfileRedesignTestSetItem;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/bottom_navigation/NavigationTabProfileRedesignTestSetItem;", "getTabInProfileTest", "()Lcom/avito/android/bottom_navigation/NavigationTabProfileRedesignTestSetItem;", "getTabInProfileTest$annotations", "tabInProfileTest", "i", "isManual", "<init>", "(ILjava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/text/AttributedText;Ljava/lang/String;Z)V", "profile-phones_release"}, k = 1, mv = {1, 4, 2})
public final class LandlinePhoneVerificationTabFragmentData implements TabFragmentFactory.Data {
    public static final Parcelable.Creator<LandlinePhoneVerificationTabFragmentData> CREATOR = new Creator();
    @NotNull
    public final NavigationTabControlSetItem a = NavigationTab.PROFILE.INSTANCE;
    @NotNull
    public final NavigationTabProfileRedesignTestSetItem b = NavigationTab.PROFILE_SETTINGS.INSTANCE;
    public final boolean c = true;
    public final int d;
    @NotNull
    public final String e;
    @NotNull
    public final String f;
    @NotNull
    public final AttributedText g;
    @NotNull
    public final String h;
    public final boolean i;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<LandlinePhoneVerificationTabFragmentData> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final LandlinePhoneVerificationTabFragmentData createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new LandlinePhoneVerificationTabFragmentData(parcel.readInt(), parcel.readString(), parcel.readString(), (AttributedText) parcel.readParcelable(LandlinePhoneVerificationTabFragmentData.class.getClassLoader()), parcel.readString(), parcel.readInt() != 0);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final LandlinePhoneVerificationTabFragmentData[] newArray(int i) {
            return new LandlinePhoneVerificationTabFragmentData[i];
        }
    }

    public LandlinePhoneVerificationTabFragmentData(int i2, @NotNull String str, @NotNull String str2, @NotNull AttributedText attributedText, @NotNull String str3, boolean z) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, MessengerShareContentUtility.SUBTITLE);
        Intrinsics.checkNotNullParameter(attributedText, "description");
        Intrinsics.checkNotNullParameter(str3, "phone");
        this.d = i2;
        this.e = str;
        this.f = str2;
        this.g = attributedText;
        this.h = str3;
        this.i = z;
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

    public final int getCallId() {
        return this.d;
    }

    @NotNull
    public final AttributedText getDescription() {
        return this.g;
    }

    @Override // com.avito.android.bottom_navigation.ui.fragment.factory.TabFragmentFactory.Data
    public boolean getNeedAuthorization() {
        return this.c;
    }

    @NotNull
    public final String getPhone() {
        return this.h;
    }

    @Override // com.avito.android.bottom_navigation.ui.fragment.factory.TabFragmentFactory.Data
    public boolean getShowNavigation() {
        return false;
    }

    @NotNull
    public final String getSubtitle() {
        return this.f;
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

    @NotNull
    public final String getTitle() {
        return this.e;
    }

    public final boolean isManual() {
        return this.i;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i2) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeInt(this.d);
        parcel.writeString(this.e);
        parcel.writeString(this.f);
        parcel.writeParcelable(this.g, i2);
        parcel.writeString(this.h);
        parcel.writeInt(this.i ? 1 : 0);
    }
}
