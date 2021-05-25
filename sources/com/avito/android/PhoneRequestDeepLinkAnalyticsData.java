package com.avito.android;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.remote.auth.AuthSource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/avito/android/PhoneRequestDeepLinkAnalyticsData;", "Landroid/os/Parcelable;", "<init>", "()V", "Advert", "ResidentialComplex", "ShopDetails", "Lcom/avito/android/PhoneRequestDeepLinkAnalyticsData$ResidentialComplex;", "Lcom/avito/android/PhoneRequestDeepLinkAnalyticsData$ShopDetails;", "Lcom/avito/android/PhoneRequestDeepLinkAnalyticsData$Advert;", "core_release"}, k = 1, mv = {1, 4, 2})
public abstract class PhoneRequestDeepLinkAnalyticsData implements Parcelable {

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000b¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u0019\u0010\u0010\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/avito/android/PhoneRequestDeepLinkAnalyticsData$Advert;", "Lcom/avito/android/PhoneRequestDeepLinkAnalyticsData;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getAdvertId", "()Ljava/lang/String;", BookingInfoActivity.EXTRA_ITEM_ID, "<init>", "(Ljava/lang/String;)V", "core_release"}, k = 1, mv = {1, 4, 2})
    public static final class Advert extends PhoneRequestDeepLinkAnalyticsData {
        public static final Parcelable.Creator<Advert> CREATOR = new Creator();
        @NotNull
        public final String a;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<Advert> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Advert createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new Advert(parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Advert[] newArray(int i) {
                return new Advert[i];
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Advert(@NotNull String str) {
            super(null);
            Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
            this.a = str;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @NotNull
        public final String getAdvertId() {
            return this.a;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.a);
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0007\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0016\u001a\u00020\u0011\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0016\u001a\u00020\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001b\u0010\u0019\u001a\u0004\u0018\u00010\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0013\u001a\u0004\b\u0018\u0010\u0015R\u001b\u0010\u001c\u001a\u0004\u0018\u00010\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u0013\u001a\u0004\b\u001b\u0010\u0015¨\u0006\u001f"}, d2 = {"Lcom/avito/android/PhoneRequestDeepLinkAnalyticsData$ResidentialComplex;", "Lcom/avito/android/PhoneRequestDeepLinkAnalyticsData;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", AuthSource.BOOKING_ORDER, "Ljava/util/List;", "getMetroIds", "()Ljava/util/List;", "metroIds", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getDevelopmentId", "()Ljava/lang/String;", "developmentId", "c", "getSearchContext", "searchContext", "d", "getLocationId", "locationId", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "core_release"}, k = 1, mv = {1, 4, 2})
    public static final class ResidentialComplex extends PhoneRequestDeepLinkAnalyticsData {
        public static final Parcelable.Creator<ResidentialComplex> CREATOR = new Creator();
        @NotNull
        public final String a;
        @NotNull
        public final List<Integer> b;
        @Nullable
        public final String c;
        @Nullable
        public final String d;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<ResidentialComplex> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final ResidentialComplex createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                String readString = parcel.readString();
                int readInt = parcel.readInt();
                ArrayList arrayList = new ArrayList(readInt);
                while (readInt != 0) {
                    arrayList.add(Integer.valueOf(parcel.readInt()));
                    readInt--;
                }
                return new ResidentialComplex(readString, arrayList, parcel.readString(), parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final ResidentialComplex[] newArray(int i) {
                return new ResidentialComplex[i];
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ResidentialComplex(@NotNull String str, @NotNull List<Integer> list, @Nullable String str2, @Nullable String str3) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "developmentId");
            Intrinsics.checkNotNullParameter(list, "metroIds");
            this.a = str;
            this.b = list;
            this.c = str2;
            this.d = str3;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @NotNull
        public final String getDevelopmentId() {
            return this.a;
        }

        @Nullable
        public final String getLocationId() {
            return this.d;
        }

        @NotNull
        public final List<Integer> getMetroIds() {
            return this.b;
        }

        @Nullable
        public final String getSearchContext() {
            return this.c;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.a);
            Iterator n0 = a.n0(this.b, parcel);
            while (n0.hasNext()) {
                parcel.writeInt(((Integer) n0.next()).intValue());
            }
            parcel.writeString(this.c);
            parcel.writeString(this.d);
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0010\u001a\u00020\u000b\u0012\u0006\u0010\u0013\u001a\u00020\u000b¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u0019\u0010\u0010\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0013\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\r\u001a\u0004\b\u0012\u0010\u000f¨\u0006\u0016"}, d2 = {"Lcom/avito/android/PhoneRequestDeepLinkAnalyticsData$ShopDetails;", "Lcom/avito/android/PhoneRequestDeepLinkAnalyticsData;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getUserKey", "()Ljava/lang/String;", "userKey", AuthSource.BOOKING_ORDER, "getSource", "source", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "core_release"}, k = 1, mv = {1, 4, 2})
    public static final class ShopDetails extends PhoneRequestDeepLinkAnalyticsData {
        public static final Parcelable.Creator<ShopDetails> CREATOR = new Creator();
        @NotNull
        public final String a;
        @NotNull
        public final String b;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<ShopDetails> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final ShopDetails createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new ShopDetails(parcel.readString(), parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final ShopDetails[] newArray(int i) {
                return new ShopDetails[i];
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ShopDetails(@NotNull String str, @NotNull String str2) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "userKey");
            Intrinsics.checkNotNullParameter(str2, "source");
            this.a = str;
            this.b = str2;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @NotNull
        public final String getSource() {
            return this.b;
        }

        @NotNull
        public final String getUserKey() {
            return this.a;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.a);
            parcel.writeString(this.b);
        }
    }

    public PhoneRequestDeepLinkAnalyticsData() {
    }

    public PhoneRequestDeepLinkAnalyticsData(j jVar) {
    }
}
