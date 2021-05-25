package com.avito.android.public_profile.remote.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.favorite_sellers.interactor.SubscribersReadInteractor;
import com.avito.android.util.Parcels;
import com.avito.android.util.ParcelsKt;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u000e\b\b\u0018\u0000 *2\u00020\u0001:\u0001*B/\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b(\u0010)J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\u000e\u0010\rJ\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0011J@\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u000fHÆ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u001a\u001a\u00020\u0019HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u001c\u0010\nJ\u001a\u0010\u001f\u001a\u00020\u000b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dHÖ\u0003¢\u0006\u0004\b\u001f\u0010 R$\u0010\u0014\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010!\u001a\u0004\b\u0014\u0010\r\"\u0004\b\"\u0010#R\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u000f8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0016\u0010$\u001a\u0004\b%\u0010\u0011R\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u000f8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0015\u0010$\u001a\u0004\b&\u0010\u0011R$\u0010\u0013\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010!\u001a\u0004\b\u0013\u0010\r\"\u0004\b'\u0010#¨\u0006+"}, d2 = {"Lcom/avito/android/public_profile/remote/model/SubscribeInfo;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "dest", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "", "component1", "()Ljava/lang/Boolean;", "component2", "Lcom/avito/android/public_profile/remote/model/ProfileCounter;", "component3", "()Lcom/avito/android/public_profile/remote/model/ProfileCounter;", "component4", "isSubscribed", "isNotificationsActivated", SubscribersReadInteractor.TYPE, "subscriptions", "copy", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Lcom/avito/android/public_profile/remote/model/ProfileCounter;Lcom/avito/android/public_profile/remote/model/ProfileCounter;)Lcom/avito/android/public_profile/remote/model/SubscribeInfo;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Boolean;", "setNotificationsActivated", "(Ljava/lang/Boolean;)V", "Lcom/avito/android/public_profile/remote/model/ProfileCounter;", "getSubscriptions", "getSubscribers", "setSubscribed", "<init>", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Lcom/avito/android/public_profile/remote/model/ProfileCounter;Lcom/avito/android/public_profile/remote/model/ProfileCounter;)V", "Companion", "public-profile_release"}, k = 1, mv = {1, 4, 2})
public final class SubscribeInfo implements Parcelable {
    @JvmField
    @NotNull
    public static final Parcelable.Creator<SubscribeInfo> CREATOR = Parcels.creator(a.a);
    @NotNull
    public static final Companion Companion = new Companion(null);
    @SerializedName("isNotificationsActivated")
    @Nullable
    private Boolean isNotificationsActivated;
    @SerializedName("isSubscribed")
    @Nullable
    private Boolean isSubscribed;
    @SerializedName(SubscribersReadInteractor.TYPE)
    @Nullable
    private final ProfileCounter subscribers;
    @SerializedName("subscriptions")
    @Nullable
    private final ProfileCounter subscriptions;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/public_profile/remote/model/SubscribeInfo$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/public_profile/remote/model/SubscribeInfo;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "public-profile_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    public static final class a extends Lambda implements Function1<Parcel, SubscribeInfo> {
        public static final a a = new a();

        public a() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public SubscribeInfo invoke(Parcel parcel) {
            Parcel parcel2 = parcel;
            Intrinsics.checkNotNullParameter(parcel2, "$receiver");
            Object readValue = parcel2.readValue(Boolean.class.getClassLoader());
            Boolean bool = null;
            if (!(readValue instanceof Boolean)) {
                readValue = null;
            }
            Boolean bool2 = (Boolean) readValue;
            Object readValue2 = parcel2.readValue(Boolean.class.getClassLoader());
            if (readValue2 instanceof Boolean) {
                bool = readValue2;
            }
            return new SubscribeInfo(bool2, bool, (ProfileCounter) parcel2.readParcelable(ProfileCounter.class.getClassLoader()), (ProfileCounter) parcel2.readParcelable(ProfileCounter.class.getClassLoader()));
        }
    }

    public SubscribeInfo(@Nullable Boolean bool, @Nullable Boolean bool2, @Nullable ProfileCounter profileCounter, @Nullable ProfileCounter profileCounter2) {
        this.isSubscribed = bool;
        this.isNotificationsActivated = bool2;
        this.subscribers = profileCounter;
        this.subscriptions = profileCounter2;
    }

    public static /* synthetic */ SubscribeInfo copy$default(SubscribeInfo subscribeInfo, Boolean bool, Boolean bool2, ProfileCounter profileCounter, ProfileCounter profileCounter2, int i, Object obj) {
        if ((i & 1) != 0) {
            bool = subscribeInfo.isSubscribed;
        }
        if ((i & 2) != 0) {
            bool2 = subscribeInfo.isNotificationsActivated;
        }
        if ((i & 4) != 0) {
            profileCounter = subscribeInfo.subscribers;
        }
        if ((i & 8) != 0) {
            profileCounter2 = subscribeInfo.subscriptions;
        }
        return subscribeInfo.copy(bool, bool2, profileCounter, profileCounter2);
    }

    @Nullable
    public final Boolean component1() {
        return this.isSubscribed;
    }

    @Nullable
    public final Boolean component2() {
        return this.isNotificationsActivated;
    }

    @Nullable
    public final ProfileCounter component3() {
        return this.subscribers;
    }

    @Nullable
    public final ProfileCounter component4() {
        return this.subscriptions;
    }

    @NotNull
    public final SubscribeInfo copy(@Nullable Boolean bool, @Nullable Boolean bool2, @Nullable ProfileCounter profileCounter, @Nullable ProfileCounter profileCounter2) {
        return new SubscribeInfo(bool, bool2, profileCounter, profileCounter2);
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
        if (!(obj instanceof SubscribeInfo)) {
            return false;
        }
        SubscribeInfo subscribeInfo = (SubscribeInfo) obj;
        return Intrinsics.areEqual(this.isSubscribed, subscribeInfo.isSubscribed) && Intrinsics.areEqual(this.isNotificationsActivated, subscribeInfo.isNotificationsActivated) && Intrinsics.areEqual(this.subscribers, subscribeInfo.subscribers) && Intrinsics.areEqual(this.subscriptions, subscribeInfo.subscriptions);
    }

    @Nullable
    public final ProfileCounter getSubscribers() {
        return this.subscribers;
    }

    @Nullable
    public final ProfileCounter getSubscriptions() {
        return this.subscriptions;
    }

    @Override // java.lang.Object
    public int hashCode() {
        Boolean bool = this.isSubscribed;
        int i = 0;
        int hashCode = (bool != null ? bool.hashCode() : 0) * 31;
        Boolean bool2 = this.isNotificationsActivated;
        int hashCode2 = (hashCode + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        ProfileCounter profileCounter = this.subscribers;
        int hashCode3 = (hashCode2 + (profileCounter != null ? profileCounter.hashCode() : 0)) * 31;
        ProfileCounter profileCounter2 = this.subscriptions;
        if (profileCounter2 != null) {
            i = profileCounter2.hashCode();
        }
        return hashCode3 + i;
    }

    @Nullable
    public final Boolean isNotificationsActivated() {
        return this.isNotificationsActivated;
    }

    @Nullable
    public final Boolean isSubscribed() {
        return this.isSubscribed;
    }

    public final void setNotificationsActivated(@Nullable Boolean bool) {
        this.isNotificationsActivated = bool;
    }

    public final void setSubscribed(@Nullable Boolean bool) {
        this.isSubscribed = bool;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a2.b.a.a.a.L("SubscribeInfo(isSubscribed=");
        L.append(this.isSubscribed);
        L.append(", isNotificationsActivated=");
        L.append(this.isNotificationsActivated);
        L.append(", subscribers=");
        L.append(this.subscribers);
        L.append(", subscriptions=");
        L.append(this.subscriptions);
        L.append(")");
        return L.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        ParcelsKt.writeNullableValue(parcel, this.isSubscribed);
        ParcelsKt.writeNullableValue(parcel, this.isNotificationsActivated);
        parcel.writeParcelable(this.subscribers, i);
        parcel.writeParcelable(this.subscriptions, i);
    }
}
