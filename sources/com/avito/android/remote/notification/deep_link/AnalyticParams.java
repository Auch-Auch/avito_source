package com.avito.android.remote.notification.deep_link;

import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.ParcelUtils;
import com.avito.android.util.ParcelsKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.r;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\t\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B'\u0012\u0014\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0011\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nR\u001b\u0010\u0010\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR'\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u001a"}, d2 = {"Lcom/avito/android/remote/notification/deep_link/AnalyticParams;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "dest", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getButtonName", "()Ljava/lang/String;", "buttonName", "", AuthSource.SEND_ABUSE, "Ljava/util/Map;", "getAnalytics", "()Ljava/util/Map;", "analytics", "<init>", "(Ljava/util/Map;Ljava/lang/String;)V", "CREATOR", "notification-deeplink_release"}, k = 1, mv = {1, 4, 2})
public final class AnalyticParams implements Parcelable {
    @NotNull
    public static final CREATOR CREATOR = new CREATOR(null);
    @Nullable
    public final Map<String, String> a;
    @Nullable
    public final String b;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/avito/android/remote/notification/deep_link/AnalyticParams$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/remote/notification/deep_link/AnalyticParams;", "Landroid/os/Parcel;", "source", "createFromParcel", "(Landroid/os/Parcel;)Lcom/avito/android/remote/notification/deep_link/AnalyticParams;", "", "size", "", "newArray", "(I)[Lcom/avito/android/remote/notification/deep_link/AnalyticParams;", "<init>", "()V", "notification-deeplink_release"}, k = 1, mv = {1, 4, 2})
    public static final class CREATOR implements Parcelable.Creator<AnalyticParams> {
        public CREATOR() {
        }

        public CREATOR(j jVar) {
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public AnalyticParams createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "source");
            Map createValueMap = ParcelUtils.createValueMap(parcel, String.class, String.class);
            if (createValueMap == null) {
                createValueMap = r.emptyMap();
            }
            return new AnalyticParams(createValueMap, parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public AnalyticParams[] newArray(int i) {
            return new AnalyticParams[i];
        }
    }

    public AnalyticParams(@Nullable Map<String, String> map, @Nullable String str) {
        this.a = map;
        this.b = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final Map<String, String> getAnalytics() {
        return this.a;
    }

    @Nullable
    public final String getButtonName() {
        return this.b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        ParcelsKt.writeValueMap(parcel, this.a);
        parcel.writeString(this.b);
    }
}
