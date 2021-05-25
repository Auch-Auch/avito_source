package com.avito.android.advert_core.contactbar;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.InAppCallLink;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b$\u0010%J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J(\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0011J \u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u001c\u0010\u001dR\u001b\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010\u0004R\u001b\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010\u0007¨\u0006&"}, d2 = {"Lcom/avito/android/advert_core/contactbar/AdvertCallContacts;", "Landroid/os/Parcelable;", "Lcom/avito/android/deep_linking/links/DeepLink;", "component1", "()Lcom/avito/android/deep_linking/links/DeepLink;", "Lcom/avito/android/deep_linking/links/InAppCallLink;", "component2", "()Lcom/avito/android/deep_linking/links/InAppCallLink;", "phoneLink", "inAppLink", "copy", "(Lcom/avito/android/deep_linking/links/DeepLink;Lcom/avito/android/deep_linking/links/InAppCallLink;)Lcom/avito/android/advert_core/contactbar/AdvertCallContacts;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", AuthSource.SEND_ABUSE, "Lcom/avito/android/deep_linking/links/DeepLink;", "getPhoneLink", AuthSource.BOOKING_ORDER, "Lcom/avito/android/deep_linking/links/InAppCallLink;", "getInAppLink", "<init>", "(Lcom/avito/android/deep_linking/links/DeepLink;Lcom/avito/android/deep_linking/links/InAppCallLink;)V", "advert-core_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertCallContacts implements Parcelable {
    public static final Parcelable.Creator<AdvertCallContacts> CREATOR = new Creator();
    @Nullable
    public final DeepLink a;
    @Nullable
    public final InAppCallLink b;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<AdvertCallContacts> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final AdvertCallContacts createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new AdvertCallContacts((DeepLink) parcel.readParcelable(AdvertCallContacts.class.getClassLoader()), (InAppCallLink) parcel.readParcelable(AdvertCallContacts.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final AdvertCallContacts[] newArray(int i) {
            return new AdvertCallContacts[i];
        }
    }

    public AdvertCallContacts(@Nullable DeepLink deepLink, @Nullable InAppCallLink inAppCallLink) {
        this.a = deepLink;
        this.b = inAppCallLink;
    }

    public static /* synthetic */ AdvertCallContacts copy$default(AdvertCallContacts advertCallContacts, DeepLink deepLink, InAppCallLink inAppCallLink, int i, Object obj) {
        if ((i & 1) != 0) {
            deepLink = advertCallContacts.a;
        }
        if ((i & 2) != 0) {
            inAppCallLink = advertCallContacts.b;
        }
        return advertCallContacts.copy(deepLink, inAppCallLink);
    }

    @Nullable
    public final DeepLink component1() {
        return this.a;
    }

    @Nullable
    public final InAppCallLink component2() {
        return this.b;
    }

    @NotNull
    public final AdvertCallContacts copy(@Nullable DeepLink deepLink, @Nullable InAppCallLink inAppCallLink) {
        return new AdvertCallContacts(deepLink, inAppCallLink);
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
        if (!(obj instanceof AdvertCallContacts)) {
            return false;
        }
        AdvertCallContacts advertCallContacts = (AdvertCallContacts) obj;
        return Intrinsics.areEqual(this.a, advertCallContacts.a) && Intrinsics.areEqual(this.b, advertCallContacts.b);
    }

    @Nullable
    public final InAppCallLink getInAppLink() {
        return this.b;
    }

    @Nullable
    public final DeepLink getPhoneLink() {
        return this.a;
    }

    @Override // java.lang.Object
    public int hashCode() {
        DeepLink deepLink = this.a;
        int i = 0;
        int hashCode = (deepLink != null ? deepLink.hashCode() : 0) * 31;
        InAppCallLink inAppCallLink = this.b;
        if (inAppCallLink != null) {
            i = inAppCallLink.hashCode();
        }
        return hashCode + i;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("AdvertCallContacts(phoneLink=");
        L.append(this.a);
        L.append(", inAppLink=");
        L.append(this.b);
        L.append(")");
        return L.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeParcelable(this.a, i);
        parcel.writeParcelable(this.b, i);
    }
}
