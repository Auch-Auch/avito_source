package com.avito.android.payment.lib;

import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.category_parameters.ParametersTree;
import com.avito.android.remote.model.payment.service.OrderItem;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/avito/android/payment/lib/PaymentSessionType;", "Landroid/os/Parcelable;", "<init>", "()V", "LegacyServices", "Services", "Wallet", "Lcom/avito/android/payment/lib/PaymentSessionType$Wallet;", "Lcom/avito/android/payment/lib/PaymentSessionType$LegacyServices;", "Lcom/avito/android/payment/lib/PaymentSessionType$Services;", "payment-lib_release"}, k = 1, mv = {1, 4, 2})
public abstract class PaymentSessionType implements Parcelable {

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0007\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0019\u001a\u00020\f\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0016\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0019\u0010\u0019\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0013\u001a\u0004\b\u0018\u0010\u0015¨\u0006\u001c"}, d2 = {"Lcom/avito/android/payment/lib/PaymentSessionType$LegacyServices;", "Lcom/avito/android/payment/lib/PaymentSessionType;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "", AuthSource.BOOKING_ORDER, "Ljava/util/Set;", "getServiceIds", "()Ljava/util/Set;", "serviceIds", "c", "Ljava/lang/String;", "getContext", "()Ljava/lang/String;", "context", AuthSource.SEND_ABUSE, "getItemId", "itemId", "<init>", "(Ljava/lang/String;Ljava/util/Set;Ljava/lang/String;)V", "payment-lib_release"}, k = 1, mv = {1, 4, 2})
    public static final class LegacyServices extends PaymentSessionType {
        public static final Parcelable.Creator<LegacyServices> CREATOR = new Creator();
        @NotNull
        public final String a;
        @NotNull
        public final Set<String> b;
        @Nullable
        public final String c;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<LegacyServices> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final LegacyServices createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                String readString = parcel.readString();
                int readInt = parcel.readInt();
                LinkedHashSet linkedHashSet = new LinkedHashSet(readInt);
                while (readInt != 0) {
                    linkedHashSet.add(parcel.readString());
                    readInt--;
                }
                return new LegacyServices(readString, linkedHashSet, parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final LegacyServices[] newArray(int i) {
                return new LegacyServices[i];
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public LegacyServices(@NotNull String str, @NotNull Set<String> set, @Nullable String str2) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "itemId");
            Intrinsics.checkNotNullParameter(set, "serviceIds");
            this.a = str;
            this.b = set;
            this.c = str2;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Nullable
        public final String getContext() {
            return this.c;
        }

        @NotNull
        public final String getItemId() {
            return this.a;
        }

        @NotNull
        public final Set<String> getServiceIds() {
            return this.b;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.a);
            Set<String> set = this.b;
            parcel.writeInt(set.size());
            for (String str : set) {
                parcel.writeString(str);
            }
            parcel.writeString(this.c);
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0017\u001a\u0004\u0018\u00010\u00128\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001a"}, d2 = {"Lcom/avito/android/payment/lib/PaymentSessionType$Services;", "Lcom/avito/android/payment/lib/PaymentSessionType;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "Lcom/avito/android/remote/model/payment/service/OrderItem;", AuthSource.SEND_ABUSE, "Ljava/util/Set;", "getOrderItems", "()Ljava/util/Set;", "orderItems", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getContext", "()Ljava/lang/String;", "context", "<init>", "(Ljava/util/Set;Ljava/lang/String;)V", "payment-lib_release"}, k = 1, mv = {1, 4, 2})
    public static final class Services extends PaymentSessionType {
        public static final Parcelable.Creator<Services> CREATOR = new Creator();
        @NotNull
        public final Set<OrderItem> a;
        @Nullable
        public final String b;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<Services> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Services createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                int readInt = parcel.readInt();
                LinkedHashSet linkedHashSet = new LinkedHashSet(readInt);
                while (readInt != 0) {
                    linkedHashSet.add((OrderItem) parcel.readParcelable(Services.class.getClassLoader()));
                    readInt--;
                }
                return new Services(linkedHashSet, parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Services[] newArray(int i) {
                return new Services[i];
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Services(@NotNull Set<OrderItem> set, @Nullable String str) {
            super(null);
            Intrinsics.checkNotNullParameter(set, "orderItems");
            this.a = set;
            this.b = str;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Nullable
        public final String getContext() {
            return this.b;
        }

        @NotNull
        public final Set<OrderItem> getOrderItems() {
            return this.a;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            Set<OrderItem> set = this.a;
            parcel.writeInt(set.size());
            for (OrderItem orderItem : set) {
                parcel.writeParcelable(orderItem, i);
            }
            parcel.writeString(this.b);
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000b¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u0019\u0010\u0010\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/avito/android/payment/lib/PaymentSessionType$Wallet;", "Lcom/avito/android/payment/lib/PaymentSessionType;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/model/category_parameters/ParametersTree;", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/model/category_parameters/ParametersTree;", "getParams", "()Lcom/avito/android/remote/model/category_parameters/ParametersTree;", "params", "<init>", "(Lcom/avito/android/remote/model/category_parameters/ParametersTree;)V", "payment-lib_release"}, k = 1, mv = {1, 4, 2})
    public static final class Wallet extends PaymentSessionType {
        public static final Parcelable.Creator<Wallet> CREATOR = new Creator();
        @NotNull
        public final ParametersTree a;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<Wallet> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Wallet createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new Wallet((ParametersTree) parcel.readParcelable(Wallet.class.getClassLoader()));
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Wallet[] newArray(int i) {
                return new Wallet[i];
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Wallet(@NotNull ParametersTree parametersTree) {
            super(null);
            Intrinsics.checkNotNullParameter(parametersTree, "params");
            this.a = parametersTree;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @NotNull
        public final ParametersTree getParams() {
            return this.a;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeParcelable(this.a, i);
        }
    }

    public PaymentSessionType() {
    }

    public PaymentSessionType(j jVar) {
    }
}
