package com.avito.android.remote.model.delivery;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.category_parameters.base.ParameterSlot;
import com.avito.android.remote.model.text.AttributedText;
import com.avito.android.tariff.tariff_package_info.viewmodel.TariffPackageInfoConverterKt;
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
import org.spongycastle.i18n.ErrorBundle;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0017\b\b\u0018\u00002\u00020\u0001:\u0006<=>?@AB=\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u0005\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\u0017\u001a\u00020\u000b\u0012\u0006\u0010\u0018\u001a\u00020\u000e\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b:\u0010;J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013JR\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0015\u001a\u00020\u00052\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u0017\u001a\u00020\u000b2\b\b\u0002\u0010\u0018\u001a\u00020\u000e2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0011HÆ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001d\u001a\u00020\u001cHÖ\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010 \u001a\u00020\u001fHÖ\u0001¢\u0006\u0004\b \u0010!J\u001a\u0010%\u001a\u00020$2\b\u0010#\u001a\u0004\u0018\u00010\"HÖ\u0003¢\u0006\u0004\b%\u0010&J\u0010\u0010'\u001a\u00020\u001fHÖ\u0001¢\u0006\u0004\b'\u0010!J \u0010,\u001a\u00020+2\u0006\u0010)\u001a\u00020(2\u0006\u0010*\u001a\u00020\u001fHÖ\u0001¢\u0006\u0004\b,\u0010-R\u001c\u0010\u0015\u001a\u00020\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0015\u0010.\u001a\u0004\b/\u0010\u0007R\u001e\u0010\u0016\u001a\u0004\u0018\u00010\b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0016\u00100\u001a\u0004\b1\u0010\nR\u001c\u0010\u0018\u001a\u00020\u000e8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0018\u00102\u001a\u0004\b3\u0010\u0010R\u001e\u0010\u0019\u001a\u0004\u0018\u00010\u00118\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0019\u00104\u001a\u0004\b5\u0010\u0013R\u001c\u0010\u0017\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0017\u00106\u001a\u0004\b7\u0010\rR\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0014\u00108\u001a\u0004\b9\u0010\u0004¨\u0006B"}, d2 = {"Lcom/avito/android/remote/model/delivery/DeliverySummaryRds;", "Landroid/os/Parcelable;", "Lcom/avito/android/remote/model/delivery/DeliverySummaryRds$Header;", "component1", "()Lcom/avito/android/remote/model/delivery/DeliverySummaryRds$Header;", "Lcom/avito/android/remote/model/delivery/DeliverySummaryRds$DeliveryGroup;", "component2", "()Lcom/avito/android/remote/model/delivery/DeliverySummaryRds$DeliveryGroup;", "Lcom/avito/android/remote/model/delivery/DeliverySummaryRds$ShipmentsGroup;", "component3", "()Lcom/avito/android/remote/model/delivery/DeliverySummaryRds$ShipmentsGroup;", "Lcom/avito/android/remote/model/delivery/DeliverySummaryRds$ContactsGroup;", "component4", "()Lcom/avito/android/remote/model/delivery/DeliverySummaryRds$ContactsGroup;", "Lcom/avito/android/remote/model/delivery/DeliverySummaryRds$CalculationsGroup;", "component5", "()Lcom/avito/android/remote/model/delivery/DeliverySummaryRds$CalculationsGroup;", "Lcom/avito/android/remote/model/text/AttributedText;", "component6", "()Lcom/avito/android/remote/model/text/AttributedText;", TariffPackageInfoConverterKt.HEADER_STRING_ID, "deliveryGroup", "shipmentsGroup", "contactsGroup", "calculationsGroup", "disclaimer", "copy", "(Lcom/avito/android/remote/model/delivery/DeliverySummaryRds$Header;Lcom/avito/android/remote/model/delivery/DeliverySummaryRds$DeliveryGroup;Lcom/avito/android/remote/model/delivery/DeliverySummaryRds$ShipmentsGroup;Lcom/avito/android/remote/model/delivery/DeliverySummaryRds$ContactsGroup;Lcom/avito/android/remote/model/delivery/DeliverySummaryRds$CalculationsGroup;Lcom/avito/android/remote/model/text/AttributedText;)Lcom/avito/android/remote/model/delivery/DeliverySummaryRds;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/model/delivery/DeliverySummaryRds$DeliveryGroup;", "getDeliveryGroup", "Lcom/avito/android/remote/model/delivery/DeliverySummaryRds$ShipmentsGroup;", "getShipmentsGroup", "Lcom/avito/android/remote/model/delivery/DeliverySummaryRds$CalculationsGroup;", "getCalculationsGroup", "Lcom/avito/android/remote/model/text/AttributedText;", "getDisclaimer", "Lcom/avito/android/remote/model/delivery/DeliverySummaryRds$ContactsGroup;", "getContactsGroup", "Lcom/avito/android/remote/model/delivery/DeliverySummaryRds$Header;", "getHeader", "<init>", "(Lcom/avito/android/remote/model/delivery/DeliverySummaryRds$Header;Lcom/avito/android/remote/model/delivery/DeliverySummaryRds$DeliveryGroup;Lcom/avito/android/remote/model/delivery/DeliverySummaryRds$ShipmentsGroup;Lcom/avito/android/remote/model/delivery/DeliverySummaryRds$ContactsGroup;Lcom/avito/android/remote/model/delivery/DeliverySummaryRds$CalculationsGroup;Lcom/avito/android/remote/model/text/AttributedText;)V", "Calculation", "CalculationsGroup", "ContactsGroup", "DeliveryGroup", "Header", "ShipmentsGroup", "delivery_release"}, k = 1, mv = {1, 4, 2})
public final class DeliverySummaryRds implements Parcelable {
    public static final Parcelable.Creator<DeliverySummaryRds> CREATOR = new Creator();
    @SerializedName("calculationsGroup")
    @NotNull
    private final CalculationsGroup calculationsGroup;
    @SerializedName("contactsGroup")
    @NotNull
    private final ContactsGroup contactsGroup;
    @SerializedName("delivery")
    @NotNull
    private final DeliveryGroup deliveryGroup;
    @SerializedName("disclaimer")
    @Nullable
    private final AttributedText disclaimer;
    @SerializedName(TariffPackageInfoConverterKt.HEADER_STRING_ID)
    @Nullable
    private final Header header;
    @SerializedName("shipmentsGroup")
    @Nullable
    private final ShipmentsGroup shipmentsGroup;

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\u0010\u001a\u00020\u000b¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\f\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u000f¨\u0006\u0014"}, d2 = {"Lcom/avito/android/remote/model/delivery/DeliverySummaryRds$Calculation;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/model/text/AttributedText;", "title", "Lcom/avito/android/remote/model/text/AttributedText;", "getTitle", "()Lcom/avito/android/remote/model/text/AttributedText;", "description", "getDescription", "<init>", "(Lcom/avito/android/remote/model/text/AttributedText;Lcom/avito/android/remote/model/text/AttributedText;)V", "delivery_release"}, k = 1, mv = {1, 4, 2})
    public static final class Calculation implements Parcelable {
        public static final Parcelable.Creator<Calculation> CREATOR = new Creator();
        @SerializedName("description")
        @NotNull
        private final AttributedText description;
        @SerializedName("title")
        @NotNull
        private final AttributedText title;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<Calculation> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Calculation createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new Calculation((AttributedText) parcel.readParcelable(Calculation.class.getClassLoader()), (AttributedText) parcel.readParcelable(Calculation.class.getClassLoader()));
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Calculation[] newArray(int i) {
                return new Calculation[i];
            }
        }

        public Calculation(@NotNull AttributedText attributedText, @NotNull AttributedText attributedText2) {
            Intrinsics.checkNotNullParameter(attributedText, "title");
            Intrinsics.checkNotNullParameter(attributedText2, "description");
            this.title = attributedText;
            this.description = attributedText2;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @NotNull
        public final AttributedText getDescription() {
            return this.description;
        }

        @NotNull
        public final AttributedText getTitle() {
            return this.title;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeParcelable(this.title, i);
            parcel.writeParcelable(this.description, i);
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\f\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\"\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/avito/android/remote/model/delivery/DeliverySummaryRds$CalculationsGroup;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "", "Lcom/avito/android/remote/model/delivery/DeliverySummaryRds$Calculation;", ErrorBundle.DETAIL_ENTRY, "Ljava/util/List;", "getDetails", "()Ljava/util/List;", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "delivery_release"}, k = 1, mv = {1, 4, 2})
    public static final class CalculationsGroup implements Parcelable {
        public static final Parcelable.Creator<CalculationsGroup> CREATOR = new Creator();
        @SerializedName(ErrorBundle.DETAIL_ENTRY)
        @NotNull
        private final List<Calculation> details;
        @SerializedName("title")
        @NotNull
        private final String title;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<CalculationsGroup> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final CalculationsGroup createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                String readString = parcel.readString();
                int readInt = parcel.readInt();
                ArrayList arrayList = new ArrayList(readInt);
                while (readInt != 0) {
                    arrayList.add(Calculation.CREATOR.createFromParcel(parcel));
                    readInt--;
                }
                return new CalculationsGroup(readString, arrayList);
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final CalculationsGroup[] newArray(int i) {
                return new CalculationsGroup[i];
            }
        }

        public CalculationsGroup(@NotNull String str, @NotNull List<Calculation> list) {
            Intrinsics.checkNotNullParameter(str, "title");
            Intrinsics.checkNotNullParameter(list, ErrorBundle.DETAIL_ENTRY);
            this.title = str;
            this.details = list;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @NotNull
        public final List<Calculation> getDetails() {
            return this.details;
        }

        @NotNull
        public final String getTitle() {
            return this.title;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.title);
            Iterator n0 = a.n0(this.details, parcel);
            while (n0.hasNext()) {
                ((Calculation) n0.next()).writeToParcel(parcel, 0);
            }
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000e\b\b\u0018\u00002\u00020\u0001:\u00010BG\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0005\u0012\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u0012\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\b\u0012\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\b¢\u0006\u0004\b.\u0010/J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\r\u0010\u000bJ\u0018\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u000bJZ\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u00052\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\b2\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\bHÆ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0004J\u0010\u0010\u0019\u001a\u00020\u0018HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u001a\u0010\u001d\u001a\u00020\u00052\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bHÖ\u0003¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020\u0018HÖ\u0001¢\u0006\u0004\b\u001f\u0010\u001aJ \u0010$\u001a\u00020#2\u0006\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020\u0018HÖ\u0001¢\u0006\u0004\b$\u0010%R$\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0013\u0010&\u001a\u0004\b'\u0010\u000bR$\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0012\u0010&\u001a\u0004\b(\u0010\u000bR\u001c\u0010\u0011\u001a\u00020\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010)\u001a\u0004\b*\u0010\u0007R$\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0014\u0010&\u001a\u0004\b+\u0010\u000bR\u001c\u0010\u0010\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0010\u0010,\u001a\u0004\b-\u0010\u0004¨\u00061"}, d2 = {"Lcom/avito/android/remote/model/delivery/DeliverySummaryRds$ContactsGroup;", "Landroid/os/Parcelable;", "", "component1", "()Ljava/lang/String;", "", "component2", "()Z", "", "Lcom/avito/android/remote/model/category_parameters/base/ParameterSlot;", "component3", "()Ljava/util/List;", "Lcom/avito/android/remote/model/text/AttributedText;", "component4", "Lcom/avito/android/remote/model/delivery/DeliverySummaryRds$ContactsGroup$PrefilledContact;", "component5", "title", "editable", "formSections", "contacts", "prefilledContactsGroup", "copy", "(Ljava/lang/String;ZLjava/util/List;Ljava/util/List;Ljava/util/List;)Lcom/avito/android/remote/model/delivery/DeliverySummaryRds$ContactsGroup;", "toString", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/util/List;", "getContacts", "getFormSections", "Z", "getEditable", "getPrefilledContactsGroup", "Ljava/lang/String;", "getTitle", "<init>", "(Ljava/lang/String;ZLjava/util/List;Ljava/util/List;Ljava/util/List;)V", "PrefilledContact", "delivery_release"}, k = 1, mv = {1, 4, 2})
    public static final class ContactsGroup implements Parcelable {
        public static final Parcelable.Creator<ContactsGroup> CREATOR = new Creator();
        @SerializedName("contacts")
        @Nullable
        private final List<AttributedText> contacts;
        @SerializedName("editable")
        private final boolean editable;
        @SerializedName("formSections")
        @Nullable
        private final List<ParameterSlot> formSections;
        @SerializedName("prefilledContacts")
        @Nullable
        private final List<PrefilledContact> prefilledContactsGroup;
        @SerializedName("title")
        @NotNull
        private final String title;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<ContactsGroup> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final ContactsGroup createFromParcel(@NotNull Parcel parcel) {
                ArrayList arrayList;
                ArrayList arrayList2;
                Intrinsics.checkNotNullParameter(parcel, "in");
                String readString = parcel.readString();
                boolean z = parcel.readInt() != 0;
                ArrayList arrayList3 = null;
                if (parcel.readInt() != 0) {
                    int readInt = parcel.readInt();
                    arrayList = new ArrayList(readInt);
                    while (readInt != 0) {
                        arrayList.add((ParameterSlot) parcel.readParcelable(ContactsGroup.class.getClassLoader()));
                        readInt--;
                    }
                } else {
                    arrayList = null;
                }
                if (parcel.readInt() != 0) {
                    int readInt2 = parcel.readInt();
                    arrayList2 = new ArrayList(readInt2);
                    while (readInt2 != 0) {
                        arrayList2.add((AttributedText) parcel.readParcelable(ContactsGroup.class.getClassLoader()));
                        readInt2--;
                    }
                } else {
                    arrayList2 = null;
                }
                if (parcel.readInt() != 0) {
                    int readInt3 = parcel.readInt();
                    arrayList3 = new ArrayList(readInt3);
                    while (readInt3 != 0) {
                        arrayList3.add(PrefilledContact.CREATOR.createFromParcel(parcel));
                        readInt3--;
                    }
                }
                return new ContactsGroup(readString, z, arrayList, arrayList2, arrayList3);
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final ContactsGroup[] newArray(int i) {
                return new ContactsGroup[i];
            }
        }

        @Parcelize
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b \u0010!J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\u0004J\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u0015\u0010\u000fJ \u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bR\u001c\u0010\t\u001a\u00020\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\t\u0010\u001c\u001a\u0004\b\u001d\u0010\u0007R\u001c\u0010\b\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\b\u0010\u001e\u001a\u0004\b\u001f\u0010\u0004¨\u0006\""}, d2 = {"Lcom/avito/android/remote/model/delivery/DeliverySummaryRds$ContactsGroup$PrefilledContact;", "Landroid/os/Parcelable;", "", "component1", "()Ljava/lang/String;", "Lcom/avito/android/remote/model/text/AttributedText;", "component2", "()Lcom/avito/android/remote/model/text/AttributedText;", "id", "text", "copy", "(Ljava/lang/String;Lcom/avito/android/remote/model/text/AttributedText;)Lcom/avito/android/remote/model/delivery/DeliverySummaryRds$ContactsGroup$PrefilledContact;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/model/text/AttributedText;", "getText", "Ljava/lang/String;", "getId", "<init>", "(Ljava/lang/String;Lcom/avito/android/remote/model/text/AttributedText;)V", "delivery_release"}, k = 1, mv = {1, 4, 2})
        public static final class PrefilledContact implements Parcelable {
            public static final Parcelable.Creator<PrefilledContact> CREATOR = new Creator();
            @SerializedName("id")
            @NotNull
            private final String id;
            @SerializedName("value")
            @NotNull
            private final AttributedText text;

            @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
            public static class Creator implements Parcelable.Creator<PrefilledContact> {
                @Override // android.os.Parcelable.Creator
                @NotNull
                public final PrefilledContact createFromParcel(@NotNull Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "in");
                    return new PrefilledContact(parcel.readString(), (AttributedText) parcel.readParcelable(PrefilledContact.class.getClassLoader()));
                }

                @Override // android.os.Parcelable.Creator
                @NotNull
                public final PrefilledContact[] newArray(int i) {
                    return new PrefilledContact[i];
                }
            }

            public PrefilledContact(@NotNull String str, @NotNull AttributedText attributedText) {
                Intrinsics.checkNotNullParameter(str, "id");
                Intrinsics.checkNotNullParameter(attributedText, "text");
                this.id = str;
                this.text = attributedText;
            }

            public static /* synthetic */ PrefilledContact copy$default(PrefilledContact prefilledContact, String str, AttributedText attributedText, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = prefilledContact.id;
                }
                if ((i & 2) != 0) {
                    attributedText = prefilledContact.text;
                }
                return prefilledContact.copy(str, attributedText);
            }

            @NotNull
            public final String component1() {
                return this.id;
            }

            @NotNull
            public final AttributedText component2() {
                return this.text;
            }

            @NotNull
            public final PrefilledContact copy(@NotNull String str, @NotNull AttributedText attributedText) {
                Intrinsics.checkNotNullParameter(str, "id");
                Intrinsics.checkNotNullParameter(attributedText, "text");
                return new PrefilledContact(str, attributedText);
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
                if (!(obj instanceof PrefilledContact)) {
                    return false;
                }
                PrefilledContact prefilledContact = (PrefilledContact) obj;
                return Intrinsics.areEqual(this.id, prefilledContact.id) && Intrinsics.areEqual(this.text, prefilledContact.text);
            }

            @NotNull
            public final String getId() {
                return this.id;
            }

            @NotNull
            public final AttributedText getText() {
                return this.text;
            }

            @Override // java.lang.Object
            public int hashCode() {
                String str = this.id;
                int i = 0;
                int hashCode = (str != null ? str.hashCode() : 0) * 31;
                AttributedText attributedText = this.text;
                if (attributedText != null) {
                    i = attributedText.hashCode();
                }
                return hashCode + i;
            }

            @Override // java.lang.Object
            @NotNull
            public String toString() {
                StringBuilder L = a.L("PrefilledContact(id=");
                L.append(this.id);
                L.append(", text=");
                L.append(this.text);
                L.append(")");
                return L.toString();
            }

            @Override // android.os.Parcelable
            public void writeToParcel(@NotNull Parcel parcel, int i) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                parcel.writeString(this.id);
                parcel.writeParcelable(this.text, i);
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.util.List<? extends com.avito.android.remote.model.category_parameters.base.ParameterSlot> */
        /* JADX WARN: Multi-variable type inference failed */
        public ContactsGroup(@NotNull String str, boolean z, @Nullable List<? extends ParameterSlot> list, @Nullable List<AttributedText> list2, @Nullable List<PrefilledContact> list3) {
            Intrinsics.checkNotNullParameter(str, "title");
            this.title = str;
            this.editable = z;
            this.formSections = list;
            this.contacts = list2;
            this.prefilledContactsGroup = list3;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.avito.android.remote.model.delivery.DeliverySummaryRds$ContactsGroup */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ContactsGroup copy$default(ContactsGroup contactsGroup, String str, boolean z, List list, List list2, List list3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = contactsGroup.title;
            }
            if ((i & 2) != 0) {
                z = contactsGroup.editable;
            }
            if ((i & 4) != 0) {
                list = contactsGroup.formSections;
            }
            if ((i & 8) != 0) {
                list2 = contactsGroup.contacts;
            }
            if ((i & 16) != 0) {
                list3 = contactsGroup.prefilledContactsGroup;
            }
            return contactsGroup.copy(str, z, list, list2, list3);
        }

        @NotNull
        public final String component1() {
            return this.title;
        }

        public final boolean component2() {
            return this.editable;
        }

        @Nullable
        public final List<ParameterSlot> component3() {
            return this.formSections;
        }

        @Nullable
        public final List<AttributedText> component4() {
            return this.contacts;
        }

        @Nullable
        public final List<PrefilledContact> component5() {
            return this.prefilledContactsGroup;
        }

        @NotNull
        public final ContactsGroup copy(@NotNull String str, boolean z, @Nullable List<? extends ParameterSlot> list, @Nullable List<AttributedText> list2, @Nullable List<PrefilledContact> list3) {
            Intrinsics.checkNotNullParameter(str, "title");
            return new ContactsGroup(str, z, list, list2, list3);
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
            if (!(obj instanceof ContactsGroup)) {
                return false;
            }
            ContactsGroup contactsGroup = (ContactsGroup) obj;
            return Intrinsics.areEqual(this.title, contactsGroup.title) && this.editable == contactsGroup.editable && Intrinsics.areEqual(this.formSections, contactsGroup.formSections) && Intrinsics.areEqual(this.contacts, contactsGroup.contacts) && Intrinsics.areEqual(this.prefilledContactsGroup, contactsGroup.prefilledContactsGroup);
        }

        @Nullable
        public final List<AttributedText> getContacts() {
            return this.contacts;
        }

        public final boolean getEditable() {
            return this.editable;
        }

        @Nullable
        public final List<ParameterSlot> getFormSections() {
            return this.formSections;
        }

        @Nullable
        public final List<PrefilledContact> getPrefilledContactsGroup() {
            return this.prefilledContactsGroup;
        }

        @NotNull
        public final String getTitle() {
            return this.title;
        }

        @Override // java.lang.Object
        public int hashCode() {
            String str = this.title;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            boolean z = this.editable;
            if (z) {
                z = true;
            }
            int i2 = z ? 1 : 0;
            int i3 = z ? 1 : 0;
            int i4 = z ? 1 : 0;
            int i5 = (hashCode + i2) * 31;
            List<ParameterSlot> list = this.formSections;
            int hashCode2 = (i5 + (list != null ? list.hashCode() : 0)) * 31;
            List<AttributedText> list2 = this.contacts;
            int hashCode3 = (hashCode2 + (list2 != null ? list2.hashCode() : 0)) * 31;
            List<PrefilledContact> list3 = this.prefilledContactsGroup;
            if (list3 != null) {
                i = list3.hashCode();
            }
            return hashCode3 + i;
        }

        @Override // java.lang.Object
        @NotNull
        public String toString() {
            StringBuilder L = a.L("ContactsGroup(title=");
            L.append(this.title);
            L.append(", editable=");
            L.append(this.editable);
            L.append(", formSections=");
            L.append(this.formSections);
            L.append(", contacts=");
            L.append(this.contacts);
            L.append(", prefilledContactsGroup=");
            return a.w(L, this.prefilledContactsGroup, ")");
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.title);
            parcel.writeInt(this.editable ? 1 : 0);
            List<ParameterSlot> list = this.formSections;
            if (list != null) {
                Iterator l0 = a.l0(parcel, 1, list);
                while (l0.hasNext()) {
                    parcel.writeParcelable((ParameterSlot) l0.next(), i);
                }
            } else {
                parcel.writeInt(0);
            }
            List<AttributedText> list2 = this.contacts;
            if (list2 != null) {
                Iterator l02 = a.l0(parcel, 1, list2);
                while (l02.hasNext()) {
                    parcel.writeParcelable((AttributedText) l02.next(), i);
                }
            } else {
                parcel.writeInt(0);
            }
            List<PrefilledContact> list3 = this.prefilledContactsGroup;
            if (list3 != null) {
                Iterator l03 = a.l0(parcel, 1, list3);
                while (l03.hasNext()) {
                    ((PrefilledContact) l03.next()).writeToParcel(parcel, 0);
                }
                return;
            }
            parcel.writeInt(0);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<DeliverySummaryRds> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final DeliverySummaryRds createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new DeliverySummaryRds(parcel.readInt() != 0 ? Header.CREATOR.createFromParcel(parcel) : null, DeliveryGroup.CREATOR.createFromParcel(parcel), parcel.readInt() != 0 ? ShipmentsGroup.CREATOR.createFromParcel(parcel) : null, ContactsGroup.CREATOR.createFromParcel(parcel), CalculationsGroup.CREATOR.createFromParcel(parcel), (AttributedText) parcel.readParcelable(DeliverySummaryRds.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final DeliverySummaryRds[] newArray(int i) {
            return new DeliverySummaryRds[i];
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\f\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0011\u001a\u00020\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0016\u001a\u00020\u00158\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001c"}, d2 = {"Lcom/avito/android/remote/model/delivery/DeliverySummaryRds$DeliveryGroup;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "", "editable", "Z", "getEditable", "()Z", "Lcom/avito/android/remote/model/text/AttributedText;", "info", "Lcom/avito/android/remote/model/text/AttributedText;", "getInfo", "()Lcom/avito/android/remote/model/text/AttributedText;", "<init>", "(Ljava/lang/String;ZLcom/avito/android/remote/model/text/AttributedText;)V", "delivery_release"}, k = 1, mv = {1, 4, 2})
    public static final class DeliveryGroup implements Parcelable {
        public static final Parcelable.Creator<DeliveryGroup> CREATOR = new Creator();
        @SerializedName("editable")
        private final boolean editable;
        @SerializedName("info")
        @NotNull
        private final AttributedText info;
        @SerializedName("title")
        @NotNull
        private final String title;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<DeliveryGroup> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final DeliveryGroup createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new DeliveryGroup(parcel.readString(), parcel.readInt() != 0, (AttributedText) parcel.readParcelable(DeliveryGroup.class.getClassLoader()));
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final DeliveryGroup[] newArray(int i) {
                return new DeliveryGroup[i];
            }
        }

        public DeliveryGroup(@NotNull String str, boolean z, @NotNull AttributedText attributedText) {
            Intrinsics.checkNotNullParameter(str, "title");
            Intrinsics.checkNotNullParameter(attributedText, "info");
            this.title = str;
            this.editable = z;
            this.info = attributedText;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public final boolean getEditable() {
            return this.editable;
        }

        @NotNull
        public final AttributedText getInfo() {
            return this.info;
        }

        @NotNull
        public final String getTitle() {
            return this.title;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.title);
            parcel.writeInt(this.editable ? 1 : 0);
            parcel.writeParcelable(this.info, i);
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000e\b\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0005\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b.\u0010/J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0012\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\r\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJH\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u000f\u001a\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\fHÆ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\u0016\u0010\u000eJ\u0010\u0010\u0017\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u001a\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019HÖ\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u001e\u0010\u0018J \u0010#\u001a\u00020\"2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b#\u0010$R\u001c\u0010\u0010\u001a\u00020\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0010\u0010%\u001a\u0004\b&\u0010\u0007R\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010%\u001a\u0004\b'\u0010\u0007R\u001c\u0010\u000f\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000f\u0010(\u001a\u0004\b)\u0010\u0004R\u001e\u0010\u0012\u001a\u0004\u0018\u00010\t8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0012\u0010*\u001a\u0004\b+\u0010\u000bR\u001e\u0010\u0013\u001a\u0004\u0018\u00010\f8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0013\u0010,\u001a\u0004\b-\u0010\u000e¨\u00060"}, d2 = {"Lcom/avito/android/remote/model/delivery/DeliverySummaryRds$Header;", "Landroid/os/Parcelable;", "Lcom/avito/android/remote/model/Image;", "component1", "()Lcom/avito/android/remote/model/Image;", "Lcom/avito/android/remote/model/text/AttributedText;", "component2", "()Lcom/avito/android/remote/model/text/AttributedText;", "component3", "", "component4", "()Ljava/lang/Integer;", "", "component5", "()Ljava/lang/String;", "image", "text", "pricePerPiece", "availableQuantity", "tooltip", "copy", "(Lcom/avito/android/remote/model/Image;Lcom/avito/android/remote/model/text/AttributedText;Lcom/avito/android/remote/model/text/AttributedText;Ljava/lang/Integer;Ljava/lang/String;)Lcom/avito/android/remote/model/delivery/DeliverySummaryRds$Header;", "toString", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/model/text/AttributedText;", "getText", "getPricePerPiece", "Lcom/avito/android/remote/model/Image;", "getImage", "Ljava/lang/Integer;", "getAvailableQuantity", "Ljava/lang/String;", "getTooltip", "<init>", "(Lcom/avito/android/remote/model/Image;Lcom/avito/android/remote/model/text/AttributedText;Lcom/avito/android/remote/model/text/AttributedText;Ljava/lang/Integer;Ljava/lang/String;)V", "delivery_release"}, k = 1, mv = {1, 4, 2})
    public static final class Header implements Parcelable {
        public static final Parcelable.Creator<Header> CREATOR = new Creator();
        @SerializedName("availableQuantity")
        @Nullable
        private final Integer availableQuantity;
        @SerializedName("image")
        @NotNull
        private final Image image;
        @SerializedName("pricePerPiece")
        @Nullable
        private final AttributedText pricePerPiece;
        @SerializedName("text")
        @NotNull
        private final AttributedText text;
        @SerializedName("tooltip")
        @Nullable
        private final String tooltip;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<Header> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Header createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new Header((Image) parcel.readParcelable(Header.class.getClassLoader()), (AttributedText) parcel.readParcelable(Header.class.getClassLoader()), (AttributedText) parcel.readParcelable(Header.class.getClassLoader()), parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null, parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Header[] newArray(int i) {
                return new Header[i];
            }
        }

        public Header(@NotNull Image image2, @NotNull AttributedText attributedText, @Nullable AttributedText attributedText2, @Nullable Integer num, @Nullable String str) {
            Intrinsics.checkNotNullParameter(image2, "image");
            Intrinsics.checkNotNullParameter(attributedText, "text");
            this.image = image2;
            this.text = attributedText;
            this.pricePerPiece = attributedText2;
            this.availableQuantity = num;
            this.tooltip = str;
        }

        public static /* synthetic */ Header copy$default(Header header, Image image2, AttributedText attributedText, AttributedText attributedText2, Integer num, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                image2 = header.image;
            }
            if ((i & 2) != 0) {
                attributedText = header.text;
            }
            if ((i & 4) != 0) {
                attributedText2 = header.pricePerPiece;
            }
            if ((i & 8) != 0) {
                num = header.availableQuantity;
            }
            if ((i & 16) != 0) {
                str = header.tooltip;
            }
            return header.copy(image2, attributedText, attributedText2, num, str);
        }

        @NotNull
        public final Image component1() {
            return this.image;
        }

        @NotNull
        public final AttributedText component2() {
            return this.text;
        }

        @Nullable
        public final AttributedText component3() {
            return this.pricePerPiece;
        }

        @Nullable
        public final Integer component4() {
            return this.availableQuantity;
        }

        @Nullable
        public final String component5() {
            return this.tooltip;
        }

        @NotNull
        public final Header copy(@NotNull Image image2, @NotNull AttributedText attributedText, @Nullable AttributedText attributedText2, @Nullable Integer num, @Nullable String str) {
            Intrinsics.checkNotNullParameter(image2, "image");
            Intrinsics.checkNotNullParameter(attributedText, "text");
            return new Header(image2, attributedText, attributedText2, num, str);
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
            if (!(obj instanceof Header)) {
                return false;
            }
            Header header = (Header) obj;
            return Intrinsics.areEqual(this.image, header.image) && Intrinsics.areEqual(this.text, header.text) && Intrinsics.areEqual(this.pricePerPiece, header.pricePerPiece) && Intrinsics.areEqual(this.availableQuantity, header.availableQuantity) && Intrinsics.areEqual(this.tooltip, header.tooltip);
        }

        @Nullable
        public final Integer getAvailableQuantity() {
            return this.availableQuantity;
        }

        @NotNull
        public final Image getImage() {
            return this.image;
        }

        @Nullable
        public final AttributedText getPricePerPiece() {
            return this.pricePerPiece;
        }

        @NotNull
        public final AttributedText getText() {
            return this.text;
        }

        @Nullable
        public final String getTooltip() {
            return this.tooltip;
        }

        @Override // java.lang.Object
        public int hashCode() {
            Image image2 = this.image;
            int i = 0;
            int hashCode = (image2 != null ? image2.hashCode() : 0) * 31;
            AttributedText attributedText = this.text;
            int hashCode2 = (hashCode + (attributedText != null ? attributedText.hashCode() : 0)) * 31;
            AttributedText attributedText2 = this.pricePerPiece;
            int hashCode3 = (hashCode2 + (attributedText2 != null ? attributedText2.hashCode() : 0)) * 31;
            Integer num = this.availableQuantity;
            int hashCode4 = (hashCode3 + (num != null ? num.hashCode() : 0)) * 31;
            String str = this.tooltip;
            if (str != null) {
                i = str.hashCode();
            }
            return hashCode4 + i;
        }

        @Override // java.lang.Object
        @NotNull
        public String toString() {
            StringBuilder L = a.L("Header(image=");
            L.append(this.image);
            L.append(", text=");
            L.append(this.text);
            L.append(", pricePerPiece=");
            L.append(this.pricePerPiece);
            L.append(", availableQuantity=");
            L.append(this.availableQuantity);
            L.append(", tooltip=");
            return a.t(L, this.tooltip, ")");
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            int i2;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeParcelable(this.image, i);
            parcel.writeParcelable(this.text, i);
            parcel.writeParcelable(this.pricePerPiece, i);
            Integer num = this.availableQuantity;
            if (num != null) {
                parcel.writeInt(1);
                i2 = num.intValue();
            } else {
                i2 = 0;
            }
            parcel.writeInt(i2);
            parcel.writeString(this.tooltip);
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0018B\u001d\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\f\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\"\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/avito/android/remote/model/delivery/DeliverySummaryRds$ShipmentsGroup;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "", "Lcom/avito/android/remote/model/delivery/DeliverySummaryRds$ShipmentsGroup$Shipment;", "shipments", "Ljava/util/List;", "getShipments", "()Ljava/util/List;", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "Shipment", "delivery_release"}, k = 1, mv = {1, 4, 2})
    public static final class ShipmentsGroup implements Parcelable {
        public static final Parcelable.Creator<ShipmentsGroup> CREATOR = new Creator();
        @SerializedName("shipments")
        @NotNull
        private final List<Shipment> shipments;
        @SerializedName("title")
        @NotNull
        private final String title;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<ShipmentsGroup> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final ShipmentsGroup createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                String readString = parcel.readString();
                int readInt = parcel.readInt();
                ArrayList arrayList = new ArrayList(readInt);
                while (readInt != 0) {
                    arrayList.add(Shipment.CREATOR.createFromParcel(parcel));
                    readInt--;
                }
                return new ShipmentsGroup(readString, arrayList);
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final ShipmentsGroup[] newArray(int i) {
                return new ShipmentsGroup[i];
            }
        }

        @Parcelize
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001:\u0001\u001dB'\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\"\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0012\u001a\u00020\u00118\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001e"}, d2 = {"Lcom/avito/android/remote/model/delivery/DeliverySummaryRds$ShipmentsGroup$Shipment;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "Lcom/avito/android/remote/model/delivery/DeliverySummaryRds$ShipmentsGroup$Shipment$Item;", "items", "Ljava/util/List;", "getItems", "()Ljava/util/List;", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "Lcom/avito/android/remote/model/text/AttributedText;", MessengerShareContentUtility.SUBTITLE, "Lcom/avito/android/remote/model/text/AttributedText;", "getSubtitle", "()Lcom/avito/android/remote/model/text/AttributedText;", "<init>", "(Ljava/lang/String;Lcom/avito/android/remote/model/text/AttributedText;Ljava/util/List;)V", "Item", "delivery_release"}, k = 1, mv = {1, 4, 2})
        public static final class Shipment implements Parcelable {
            public static final Parcelable.Creator<Shipment> CREATOR = new Creator();
            @SerializedName("items")
            @NotNull
            private final List<Item> items;
            @SerializedName(MessengerShareContentUtility.SUBTITLE)
            @Nullable
            private final AttributedText subtitle;
            @SerializedName("title")
            @NotNull
            private final String title;

            @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
            public static class Creator implements Parcelable.Creator<Shipment> {
                @Override // android.os.Parcelable.Creator
                @NotNull
                public final Shipment createFromParcel(@NotNull Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "in");
                    String readString = parcel.readString();
                    AttributedText attributedText = (AttributedText) parcel.readParcelable(Shipment.class.getClassLoader());
                    int readInt = parcel.readInt();
                    ArrayList arrayList = new ArrayList(readInt);
                    while (readInt != 0) {
                        arrayList.add(Item.CREATOR.createFromParcel(parcel));
                        readInt--;
                    }
                    return new Shipment(readString, attributedText, arrayList);
                }

                @Override // android.os.Parcelable.Creator
                @NotNull
                public final Shipment[] newArray(int i) {
                    return new Shipment[i];
                }
            }

            @Parcelize
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\b\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b#\u0010$J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J0\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u0004J\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0011J \u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u001c\u0010\u001dR\u001e\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u001e\u001a\u0004\b\u001f\u0010\u0004R\u001c\u0010\t\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\t\u0010\u001e\u001a\u0004\b \u0010\u0004R\u001c\u0010\n\u001a\u00020\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\n\u0010!\u001a\u0004\b\"\u0010\u0007¨\u0006%"}, d2 = {"Lcom/avito/android/remote/model/delivery/DeliverySummaryRds$ShipmentsGroup$Shipment$Item;", "Landroid/os/Parcelable;", "", "component1", "()Ljava/lang/String;", "Lcom/avito/android/remote/model/Image;", "component2", "()Lcom/avito/android/remote/model/Image;", "component3", "id", "image", "badge", "copy", "(Ljava/lang/String;Lcom/avito/android/remote/model/Image;Ljava/lang/String;)Lcom/avito/android/remote/model/delivery/DeliverySummaryRds$ShipmentsGroup$Shipment$Item;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getBadge", "getId", "Lcom/avito/android/remote/model/Image;", "getImage", "<init>", "(Ljava/lang/String;Lcom/avito/android/remote/model/Image;Ljava/lang/String;)V", "delivery_release"}, k = 1, mv = {1, 4, 2})
            public static final class Item implements Parcelable {
                public static final Parcelable.Creator<Item> CREATOR = new Creator();
                @SerializedName("badge")
                @Nullable
                private final String badge;
                @SerializedName("id")
                @NotNull
                private final String id;
                @SerializedName("image")
                @NotNull
                private final Image image;

                @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
                public static class Creator implements Parcelable.Creator<Item> {
                    @Override // android.os.Parcelable.Creator
                    @NotNull
                    public final Item createFromParcel(@NotNull Parcel parcel) {
                        Intrinsics.checkNotNullParameter(parcel, "in");
                        return new Item(parcel.readString(), (Image) parcel.readParcelable(Item.class.getClassLoader()), parcel.readString());
                    }

                    @Override // android.os.Parcelable.Creator
                    @NotNull
                    public final Item[] newArray(int i) {
                        return new Item[i];
                    }
                }

                public Item(@NotNull String str, @NotNull Image image2, @Nullable String str2) {
                    Intrinsics.checkNotNullParameter(str, "id");
                    Intrinsics.checkNotNullParameter(image2, "image");
                    this.id = str;
                    this.image = image2;
                    this.badge = str2;
                }

                public static /* synthetic */ Item copy$default(Item item, String str, Image image2, String str2, int i, Object obj) {
                    if ((i & 1) != 0) {
                        str = item.id;
                    }
                    if ((i & 2) != 0) {
                        image2 = item.image;
                    }
                    if ((i & 4) != 0) {
                        str2 = item.badge;
                    }
                    return item.copy(str, image2, str2);
                }

                @NotNull
                public final String component1() {
                    return this.id;
                }

                @NotNull
                public final Image component2() {
                    return this.image;
                }

                @Nullable
                public final String component3() {
                    return this.badge;
                }

                @NotNull
                public final Item copy(@NotNull String str, @NotNull Image image2, @Nullable String str2) {
                    Intrinsics.checkNotNullParameter(str, "id");
                    Intrinsics.checkNotNullParameter(image2, "image");
                    return new Item(str, image2, str2);
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
                    if (!(obj instanceof Item)) {
                        return false;
                    }
                    Item item = (Item) obj;
                    return Intrinsics.areEqual(this.id, item.id) && Intrinsics.areEqual(this.image, item.image) && Intrinsics.areEqual(this.badge, item.badge);
                }

                @Nullable
                public final String getBadge() {
                    return this.badge;
                }

                @NotNull
                public final String getId() {
                    return this.id;
                }

                @NotNull
                public final Image getImage() {
                    return this.image;
                }

                @Override // java.lang.Object
                public int hashCode() {
                    String str = this.id;
                    int i = 0;
                    int hashCode = (str != null ? str.hashCode() : 0) * 31;
                    Image image2 = this.image;
                    int hashCode2 = (hashCode + (image2 != null ? image2.hashCode() : 0)) * 31;
                    String str2 = this.badge;
                    if (str2 != null) {
                        i = str2.hashCode();
                    }
                    return hashCode2 + i;
                }

                @Override // java.lang.Object
                @NotNull
                public String toString() {
                    StringBuilder L = a.L("Item(id=");
                    L.append(this.id);
                    L.append(", image=");
                    L.append(this.image);
                    L.append(", badge=");
                    return a.t(L, this.badge, ")");
                }

                @Override // android.os.Parcelable
                public void writeToParcel(@NotNull Parcel parcel, int i) {
                    Intrinsics.checkNotNullParameter(parcel, "parcel");
                    parcel.writeString(this.id);
                    parcel.writeParcelable(this.image, i);
                    parcel.writeString(this.badge);
                }
            }

            public Shipment(@NotNull String str, @Nullable AttributedText attributedText, @NotNull List<Item> list) {
                Intrinsics.checkNotNullParameter(str, "title");
                Intrinsics.checkNotNullParameter(list, "items");
                this.title = str;
                this.subtitle = attributedText;
                this.items = list;
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            @NotNull
            public final List<Item> getItems() {
                return this.items;
            }

            @Nullable
            public final AttributedText getSubtitle() {
                return this.subtitle;
            }

            @NotNull
            public final String getTitle() {
                return this.title;
            }

            @Override // android.os.Parcelable
            public void writeToParcel(@NotNull Parcel parcel, int i) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                parcel.writeString(this.title);
                parcel.writeParcelable(this.subtitle, i);
                Iterator n0 = a.n0(this.items, parcel);
                while (n0.hasNext()) {
                    ((Item) n0.next()).writeToParcel(parcel, 0);
                }
            }
        }

        public ShipmentsGroup(@NotNull String str, @NotNull List<Shipment> list) {
            Intrinsics.checkNotNullParameter(str, "title");
            Intrinsics.checkNotNullParameter(list, "shipments");
            this.title = str;
            this.shipments = list;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @NotNull
        public final List<Shipment> getShipments() {
            return this.shipments;
        }

        @NotNull
        public final String getTitle() {
            return this.title;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.title);
            Iterator n0 = a.n0(this.shipments, parcel);
            while (n0.hasNext()) {
                ((Shipment) n0.next()).writeToParcel(parcel, 0);
            }
        }
    }

    public DeliverySummaryRds(@Nullable Header header2, @NotNull DeliveryGroup deliveryGroup2, @Nullable ShipmentsGroup shipmentsGroup2, @NotNull ContactsGroup contactsGroup2, @NotNull CalculationsGroup calculationsGroup2, @Nullable AttributedText attributedText) {
        Intrinsics.checkNotNullParameter(deliveryGroup2, "deliveryGroup");
        Intrinsics.checkNotNullParameter(contactsGroup2, "contactsGroup");
        Intrinsics.checkNotNullParameter(calculationsGroup2, "calculationsGroup");
        this.header = header2;
        this.deliveryGroup = deliveryGroup2;
        this.shipmentsGroup = shipmentsGroup2;
        this.contactsGroup = contactsGroup2;
        this.calculationsGroup = calculationsGroup2;
        this.disclaimer = attributedText;
    }

    public static /* synthetic */ DeliverySummaryRds copy$default(DeliverySummaryRds deliverySummaryRds, Header header2, DeliveryGroup deliveryGroup2, ShipmentsGroup shipmentsGroup2, ContactsGroup contactsGroup2, CalculationsGroup calculationsGroup2, AttributedText attributedText, int i, Object obj) {
        if ((i & 1) != 0) {
            header2 = deliverySummaryRds.header;
        }
        if ((i & 2) != 0) {
            deliveryGroup2 = deliverySummaryRds.deliveryGroup;
        }
        if ((i & 4) != 0) {
            shipmentsGroup2 = deliverySummaryRds.shipmentsGroup;
        }
        if ((i & 8) != 0) {
            contactsGroup2 = deliverySummaryRds.contactsGroup;
        }
        if ((i & 16) != 0) {
            calculationsGroup2 = deliverySummaryRds.calculationsGroup;
        }
        if ((i & 32) != 0) {
            attributedText = deliverySummaryRds.disclaimer;
        }
        return deliverySummaryRds.copy(header2, deliveryGroup2, shipmentsGroup2, contactsGroup2, calculationsGroup2, attributedText);
    }

    @Nullable
    public final Header component1() {
        return this.header;
    }

    @NotNull
    public final DeliveryGroup component2() {
        return this.deliveryGroup;
    }

    @Nullable
    public final ShipmentsGroup component3() {
        return this.shipmentsGroup;
    }

    @NotNull
    public final ContactsGroup component4() {
        return this.contactsGroup;
    }

    @NotNull
    public final CalculationsGroup component5() {
        return this.calculationsGroup;
    }

    @Nullable
    public final AttributedText component6() {
        return this.disclaimer;
    }

    @NotNull
    public final DeliverySummaryRds copy(@Nullable Header header2, @NotNull DeliveryGroup deliveryGroup2, @Nullable ShipmentsGroup shipmentsGroup2, @NotNull ContactsGroup contactsGroup2, @NotNull CalculationsGroup calculationsGroup2, @Nullable AttributedText attributedText) {
        Intrinsics.checkNotNullParameter(deliveryGroup2, "deliveryGroup");
        Intrinsics.checkNotNullParameter(contactsGroup2, "contactsGroup");
        Intrinsics.checkNotNullParameter(calculationsGroup2, "calculationsGroup");
        return new DeliverySummaryRds(header2, deliveryGroup2, shipmentsGroup2, contactsGroup2, calculationsGroup2, attributedText);
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
        if (!(obj instanceof DeliverySummaryRds)) {
            return false;
        }
        DeliverySummaryRds deliverySummaryRds = (DeliverySummaryRds) obj;
        return Intrinsics.areEqual(this.header, deliverySummaryRds.header) && Intrinsics.areEqual(this.deliveryGroup, deliverySummaryRds.deliveryGroup) && Intrinsics.areEqual(this.shipmentsGroup, deliverySummaryRds.shipmentsGroup) && Intrinsics.areEqual(this.contactsGroup, deliverySummaryRds.contactsGroup) && Intrinsics.areEqual(this.calculationsGroup, deliverySummaryRds.calculationsGroup) && Intrinsics.areEqual(this.disclaimer, deliverySummaryRds.disclaimer);
    }

    @NotNull
    public final CalculationsGroup getCalculationsGroup() {
        return this.calculationsGroup;
    }

    @NotNull
    public final ContactsGroup getContactsGroup() {
        return this.contactsGroup;
    }

    @NotNull
    public final DeliveryGroup getDeliveryGroup() {
        return this.deliveryGroup;
    }

    @Nullable
    public final AttributedText getDisclaimer() {
        return this.disclaimer;
    }

    @Nullable
    public final Header getHeader() {
        return this.header;
    }

    @Nullable
    public final ShipmentsGroup getShipmentsGroup() {
        return this.shipmentsGroup;
    }

    @Override // java.lang.Object
    public int hashCode() {
        Header header2 = this.header;
        int i = 0;
        int hashCode = (header2 != null ? header2.hashCode() : 0) * 31;
        DeliveryGroup deliveryGroup2 = this.deliveryGroup;
        int hashCode2 = (hashCode + (deliveryGroup2 != null ? deliveryGroup2.hashCode() : 0)) * 31;
        ShipmentsGroup shipmentsGroup2 = this.shipmentsGroup;
        int hashCode3 = (hashCode2 + (shipmentsGroup2 != null ? shipmentsGroup2.hashCode() : 0)) * 31;
        ContactsGroup contactsGroup2 = this.contactsGroup;
        int hashCode4 = (hashCode3 + (contactsGroup2 != null ? contactsGroup2.hashCode() : 0)) * 31;
        CalculationsGroup calculationsGroup2 = this.calculationsGroup;
        int hashCode5 = (hashCode4 + (calculationsGroup2 != null ? calculationsGroup2.hashCode() : 0)) * 31;
        AttributedText attributedText = this.disclaimer;
        if (attributedText != null) {
            i = attributedText.hashCode();
        }
        return hashCode5 + i;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("DeliverySummaryRds(header=");
        L.append(this.header);
        L.append(", deliveryGroup=");
        L.append(this.deliveryGroup);
        L.append(", shipmentsGroup=");
        L.append(this.shipmentsGroup);
        L.append(", contactsGroup=");
        L.append(this.contactsGroup);
        L.append(", calculationsGroup=");
        L.append(this.calculationsGroup);
        L.append(", disclaimer=");
        L.append(this.disclaimer);
        L.append(")");
        return L.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        Header header2 = this.header;
        if (header2 != null) {
            parcel.writeInt(1);
            header2.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        this.deliveryGroup.writeToParcel(parcel, 0);
        ShipmentsGroup shipmentsGroup2 = this.shipmentsGroup;
        if (shipmentsGroup2 != null) {
            parcel.writeInt(1);
            shipmentsGroup2.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        this.contactsGroup.writeToParcel(parcel, 0);
        this.calculationsGroup.writeToParcel(parcel, 0);
        parcel.writeParcelable(this.disclaimer, i);
    }
}
