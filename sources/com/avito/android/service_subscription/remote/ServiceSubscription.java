package com.avito.android.service_subscription.remote;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.model.Action;
import com.avito.android.remote.model.profile.DescriptionAttribute;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001BS\u0012\b\u0010%\u001a\u0004\u0018\u00010 \u0012\b\u0010!\u001a\u0004\u0018\u00010 \u0012\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016\u0012\b\u0010(\u001a\u0004\u0018\u00010'\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b¢\u0006\u0004\b,\u0010-J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR$\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001e\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001e\u0010!\u001a\u0004\u0018\u00010 8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u001e\u0010%\u001a\u0004\u0018\u00010 8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b%\u0010\"\u001a\u0004\b&\u0010$R\u001e\u0010(\u001a\u0004\u0018\u00010'8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+¨\u0006."}, d2 = {"Lcom/avito/android/service_subscription/remote/ServiceSubscription;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "Lcom/avito/android/remote/model/profile/DescriptionAttribute;", "params", "Ljava/util/List;", "getParams", "()Ljava/util/List;", "Lcom/avito/android/remote/model/Action;", "action", "Lcom/avito/android/remote/model/Action;", "getAction", "()Lcom/avito/android/remote/model/Action;", "Lcom/avito/android/service_subscription/remote/ServiceSubscriptionPackages;", "packages", "Lcom/avito/android/service_subscription/remote/ServiceSubscriptionPackages;", "getPackages", "()Lcom/avito/android/service_subscription/remote/ServiceSubscriptionPackages;", "Lcom/avito/android/service_subscription/remote/Footer;", "footer", "Lcom/avito/android/service_subscription/remote/Footer;", "getFooter", "()Lcom/avito/android/service_subscription/remote/Footer;", "", MessengerShareContentUtility.SUBTITLE, "Ljava/lang/String;", "getSubtitle", "()Ljava/lang/String;", "title", "getTitle", "Lcom/avito/android/service_subscription/remote/Banner;", "banner", "Lcom/avito/android/service_subscription/remote/Banner;", "getBanner", "()Lcom/avito/android/service_subscription/remote/Banner;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/avito/android/remote/model/Action;Lcom/avito/android/service_subscription/remote/ServiceSubscriptionPackages;Lcom/avito/android/service_subscription/remote/Banner;Lcom/avito/android/service_subscription/remote/Footer;)V", "service-subscription_release"}, k = 1, mv = {1, 4, 2})
public final class ServiceSubscription implements Parcelable {
    public static final Parcelable.Creator<ServiceSubscription> CREATOR = new Creator();
    @SerializedName("action")
    @Nullable
    private final Action action;
    @SerializedName("banner")
    @Nullable
    private final Banner banner;
    @SerializedName("footer")
    @Nullable
    private final Footer footer;
    @SerializedName("packages")
    @Nullable
    private final ServiceSubscriptionPackages packages;
    @SerializedName("params")
    @Nullable
    private final List<DescriptionAttribute> params;
    @SerializedName(MessengerShareContentUtility.SUBTITLE)
    @Nullable
    private final String subtitle;
    @SerializedName("title")
    @Nullable
    private final String title;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<ServiceSubscription> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ServiceSubscription createFromParcel(@NotNull Parcel parcel) {
            ArrayList arrayList;
            Intrinsics.checkNotNullParameter(parcel, "in");
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            if (parcel.readInt() != 0) {
                int readInt = parcel.readInt();
                arrayList = new ArrayList(readInt);
                while (readInt != 0) {
                    arrayList.add((DescriptionAttribute) parcel.readParcelable(ServiceSubscription.class.getClassLoader()));
                    readInt--;
                }
            } else {
                arrayList = null;
            }
            return new ServiceSubscription(readString, readString2, arrayList, (Action) parcel.readParcelable(ServiceSubscription.class.getClassLoader()), parcel.readInt() != 0 ? ServiceSubscriptionPackages.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? Banner.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? Footer.CREATOR.createFromParcel(parcel) : null);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ServiceSubscription[] newArray(int i) {
            return new ServiceSubscription[i];
        }
    }

    public ServiceSubscription(@Nullable String str, @Nullable String str2, @Nullable List<DescriptionAttribute> list, @Nullable Action action2, @Nullable ServiceSubscriptionPackages serviceSubscriptionPackages, @Nullable Banner banner2, @Nullable Footer footer2) {
        this.title = str;
        this.subtitle = str2;
        this.params = list;
        this.action = action2;
        this.packages = serviceSubscriptionPackages;
        this.banner = banner2;
        this.footer = footer2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final Action getAction() {
        return this.action;
    }

    @Nullable
    public final Banner getBanner() {
        return this.banner;
    }

    @Nullable
    public final Footer getFooter() {
        return this.footer;
    }

    @Nullable
    public final ServiceSubscriptionPackages getPackages() {
        return this.packages;
    }

    @Nullable
    public final List<DescriptionAttribute> getParams() {
        return this.params;
    }

    @Nullable
    public final String getSubtitle() {
        return this.subtitle;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.title);
        parcel.writeString(this.subtitle);
        List<DescriptionAttribute> list = this.params;
        if (list != null) {
            Iterator l0 = a.l0(parcel, 1, list);
            while (l0.hasNext()) {
                parcel.writeParcelable((DescriptionAttribute) l0.next(), i);
            }
        } else {
            parcel.writeInt(0);
        }
        parcel.writeParcelable(this.action, i);
        ServiceSubscriptionPackages serviceSubscriptionPackages = this.packages;
        if (serviceSubscriptionPackages != null) {
            parcel.writeInt(1);
            serviceSubscriptionPackages.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        Banner banner2 = this.banner;
        if (banner2 != null) {
            parcel.writeInt(1);
            banner2.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        Footer footer2 = this.footer;
        if (footer2 != null) {
            parcel.writeInt(1);
            footer2.writeToParcel(parcel, 0);
            return;
        }
        parcel.writeInt(0);
    }
}
