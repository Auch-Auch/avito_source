package com.avito.android.remote.model.service_subscription_legacy;

import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.model.Action;
import com.avito.android.remote.model.profile.DescriptionAttribute;
import com.avito.android.util.Parcels;
import com.avito.android.util.ParcelsKt;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 )2\u00020\u0001:\u0001)BI\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\b\u0010#\u001a\u0004\u0018\u00010\"\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d¢\u0006\u0004\b'\u0010(J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nR\u001e\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u000fR\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R$\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00178\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001e\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u001e\u0010#\u001a\u0004\u0018\u00010\"8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&¨\u0006*"}, d2 = {"Lcom/avito/android/remote/model/service_subscription_legacy/ServiceSubscriptionLegacy;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "dest", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "status", "getStatus", "Lcom/avito/android/remote/model/Action;", "action", "Lcom/avito/android/remote/model/Action;", "getAction", "()Lcom/avito/android/remote/model/Action;", "", "Lcom/avito/android/remote/model/profile/DescriptionAttribute;", "params", "Ljava/util/List;", "getParams", "()Ljava/util/List;", "Lcom/avito/android/remote/model/service_subscription_legacy/SubscriptionBanner;", "banner", "Lcom/avito/android/remote/model/service_subscription_legacy/SubscriptionBanner;", "getBanner", "()Lcom/avito/android/remote/model/service_subscription_legacy/SubscriptionBanner;", "Lcom/avito/android/remote/model/service_subscription_legacy/ServiceSubscriptionPackages;", "packages", "Lcom/avito/android/remote/model/service_subscription_legacy/ServiceSubscriptionPackages;", "getPackages", "()Lcom/avito/android/remote/model/service_subscription_legacy/ServiceSubscriptionPackages;", "<init>", "(Ljava/lang/String;Ljava/util/List;Lcom/avito/android/remote/model/Action;Lcom/avito/android/remote/model/service_subscription_legacy/ServiceSubscriptionPackages;Ljava/lang/String;Lcom/avito/android/remote/model/service_subscription_legacy/SubscriptionBanner;)V", "Companion", "models_release"}, k = 1, mv = {1, 4, 2})
public final class ServiceSubscriptionLegacy implements Parcelable {
    @JvmField
    @NotNull
    public static final Parcelable.Creator<ServiceSubscriptionLegacy> CREATOR = Parcels.creator(ServiceSubscriptionLegacy$Companion$CREATOR$1.INSTANCE);
    @NotNull
    public static final Companion Companion = new Companion(null);
    @SerializedName("action")
    @Nullable
    private final Action action;
    @SerializedName("banner")
    @Nullable
    private final SubscriptionBanner banner;
    @SerializedName("packages")
    @Nullable
    private final ServiceSubscriptionPackages packages;
    @SerializedName("params")
    @Nullable
    private final List<DescriptionAttribute> params;
    @SerializedName("status")
    @Nullable
    private final String status;
    @SerializedName("title")
    @Nullable
    private final String title;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/remote/model/service_subscription_legacy/ServiceSubscriptionLegacy$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/remote/model/service_subscription_legacy/ServiceSubscriptionLegacy;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(j jVar) {
            this();
        }
    }

    public ServiceSubscriptionLegacy(@Nullable String str, @Nullable List<DescriptionAttribute> list, @Nullable Action action2, @Nullable ServiceSubscriptionPackages serviceSubscriptionPackages, @Nullable String str2, @Nullable SubscriptionBanner subscriptionBanner) {
        this.title = str;
        this.params = list;
        this.action = action2;
        this.packages = serviceSubscriptionPackages;
        this.status = str2;
        this.banner = subscriptionBanner;
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
    public final SubscriptionBanner getBanner() {
        return this.banner;
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
    public final String getStatus() {
        return this.status;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        parcel.writeString(this.title);
        ParcelsKt.writeOptimizedParcelableList$default(parcel, this.params, 0, 2, null);
        parcel.writeParcelable(this.action, i);
        parcel.writeParcelable(this.packages, i);
        parcel.writeString(this.status);
        parcel.writeParcelable(this.banner, i);
    }
}
