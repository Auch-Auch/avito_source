package com.avito.android.remote.model.delivery;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.model.text.AttributedText;
import com.google.gson.annotations.SerializedName;
import com.vk.sdk.api.VKApiConst;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0018B\u001d\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\"\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0012\u001a\u00020\u00118\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/avito/android/remote/model/delivery/DeliveryMultiPointDetailInfo;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "Lcom/avito/android/remote/model/delivery/DeliveryMultiPointDetailInfo$Service;", VKApiConst.SERVICES, "Ljava/util/List;", "getServices", "()Ljava/util/List;", "Lcom/avito/android/remote/model/text/AttributedText;", "title", "Lcom/avito/android/remote/model/text/AttributedText;", "getTitle", "()Lcom/avito/android/remote/model/text/AttributedText;", "<init>", "(Lcom/avito/android/remote/model/text/AttributedText;Ljava/util/List;)V", "Service", "delivery_release"}, k = 1, mv = {1, 4, 2})
public final class DeliveryMultiPointDetailInfo implements Parcelable {
    public static final Parcelable.Creator<DeliveryMultiPointDetailInfo> CREATOR = new Creator();
    @SerializedName(VKApiConst.SERVICES)
    @NotNull
    private final List<Service> services;
    @SerializedName("title")
    @NotNull
    private final AttributedText title;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<DeliveryMultiPointDetailInfo> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final DeliveryMultiPointDetailInfo createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            AttributedText attributedText = (AttributedText) parcel.readParcelable(DeliveryMultiPointDetailInfo.class.getClassLoader());
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            while (readInt != 0) {
                arrayList.add(Service.CREATOR.createFromParcel(parcel));
                readInt--;
            }
            return new DeliveryMultiPointDetailInfo(attributedText, arrayList);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final DeliveryMultiPointDetailInfo[] newArray(int i) {
            return new DeliveryMultiPointDetailInfo[i];
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001a¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\f\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0016\u001a\u00020\u00158\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\"\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001a8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e¨\u0006!"}, d2 = {"Lcom/avito/android/remote/model/delivery/DeliveryMultiPointDetailInfo$Service;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/model/text/AttributedText;", "title", "Lcom/avito/android/remote/model/text/AttributedText;", "getTitle", "()Lcom/avito/android/remote/model/text/AttributedText;", "Lcom/avito/android/remote/model/delivery/DeliveryLabel;", "label", "Lcom/avito/android/remote/model/delivery/DeliveryLabel;", "getLabel", "()Lcom/avito/android/remote/model/delivery/DeliveryLabel;", "", "id", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "", "subtitles", "Ljava/util/List;", "getSubtitles", "()Ljava/util/List;", "<init>", "(Ljava/lang/String;Lcom/avito/android/remote/model/text/AttributedText;Lcom/avito/android/remote/model/delivery/DeliveryLabel;Ljava/util/List;)V", "delivery_release"}, k = 1, mv = {1, 4, 2})
    public static final class Service implements Parcelable {
        public static final Parcelable.Creator<Service> CREATOR = new Creator();
        @SerializedName("id")
        @NotNull
        private final String id;
        @SerializedName("label")
        @Nullable
        private final DeliveryLabel label;
        @SerializedName("subtitles")
        @NotNull
        private final List<AttributedText> subtitles;
        @SerializedName("title")
        @NotNull
        private final AttributedText title;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<Service> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Service createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                String readString = parcel.readString();
                AttributedText attributedText = (AttributedText) parcel.readParcelable(Service.class.getClassLoader());
                DeliveryLabel deliveryLabel = (DeliveryLabel) parcel.readParcelable(Service.class.getClassLoader());
                int readInt = parcel.readInt();
                ArrayList arrayList = new ArrayList(readInt);
                while (readInt != 0) {
                    arrayList.add((AttributedText) parcel.readParcelable(Service.class.getClassLoader()));
                    readInt--;
                }
                return new Service(readString, attributedText, deliveryLabel, arrayList);
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Service[] newArray(int i) {
                return new Service[i];
            }
        }

        public Service(@NotNull String str, @NotNull AttributedText attributedText, @Nullable DeliveryLabel deliveryLabel, @NotNull List<AttributedText> list) {
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(attributedText, "title");
            Intrinsics.checkNotNullParameter(list, "subtitles");
            this.id = str;
            this.title = attributedText;
            this.label = deliveryLabel;
            this.subtitles = list;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @NotNull
        public final String getId() {
            return this.id;
        }

        @Nullable
        public final DeliveryLabel getLabel() {
            return this.label;
        }

        @NotNull
        public final List<AttributedText> getSubtitles() {
            return this.subtitles;
        }

        @NotNull
        public final AttributedText getTitle() {
            return this.title;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.id);
            parcel.writeParcelable(this.title, i);
            parcel.writeParcelable(this.label, i);
            Iterator n0 = a.n0(this.subtitles, parcel);
            while (n0.hasNext()) {
                parcel.writeParcelable((AttributedText) n0.next(), i);
            }
        }
    }

    public DeliveryMultiPointDetailInfo(@NotNull AttributedText attributedText, @NotNull List<Service> list) {
        Intrinsics.checkNotNullParameter(attributedText, "title");
        Intrinsics.checkNotNullParameter(list, VKApiConst.SERVICES);
        this.title = attributedText;
        this.services = list;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NotNull
    public final List<Service> getServices() {
        return this.services;
    }

    @NotNull
    public final AttributedText getTitle() {
        return this.title;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeParcelable(this.title, i);
        Iterator n0 = a.n0(this.services, parcel);
        while (n0.hasNext()) {
            ((Service) n0.next()).writeToParcel(parcel, 0);
        }
    }
}
