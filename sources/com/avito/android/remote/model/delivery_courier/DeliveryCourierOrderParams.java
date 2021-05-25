package com.avito.android.remote.model.delivery_courier;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.model.category_parameters.base.ParameterSlot;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001:\u0002*+B]\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\b\u0010&\u001a\u0004\u0018\u00010\u000b\u0012\u000e\u0010\"\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010 \u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b(\u0010)J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001e\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u000fR\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0017\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0017\u0010\r\u001a\u0004\b\u0018\u0010\u000fR\u001e\u0010\u0019\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0019\u0010\r\u001a\u0004\b\u001a\u0010\u000fR\u001e\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR$\u0010\"\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010 8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u001e\u0010&\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b&\u0010\r\u001a\u0004\b'\u0010\u000f¨\u0006,"}, d2 = {"Lcom/avito/android/remote/model/delivery_courier/DeliveryCourierOrderParams;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "cancelButtonText", "Ljava/lang/String;", "getCancelButtonText", "()Ljava/lang/String;", "submitButtonText", "getSubmitButtonText", "Lcom/avito/android/remote/model/delivery_courier/DeliveryCourierOrderParams$ArrivalTime;", "arrivalTime", "Lcom/avito/android/remote/model/delivery_courier/DeliveryCourierOrderParams$ArrivalTime;", "getArrivalTime", "()Lcom/avito/android/remote/model/delivery_courier/DeliveryCourierOrderParams$ArrivalTime;", MessengerShareContentUtility.SUBTITLE, "getSubtitle", "toolbarTitle", "getToolbarTitle", "Lcom/avito/android/remote/model/delivery_courier/TimeInterval;", "selectedTimeInterval", "Lcom/avito/android/remote/model/delivery_courier/TimeInterval;", "getSelectedTimeInterval", "()Lcom/avito/android/remote/model/delivery_courier/TimeInterval;", "", "Lcom/avito/android/remote/model/delivery_courier/DeliveryCourierOrderParams$FormGroup;", "groups", "Ljava/util/List;", "getGroups", "()Ljava/util/List;", "itemID", "getItemID", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/delivery_courier/TimeInterval;Lcom/avito/android/remote/model/delivery_courier/DeliveryCourierOrderParams$ArrivalTime;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "ArrivalTime", "FormGroup", "delivery_release"}, k = 1, mv = {1, 4, 2})
public final class DeliveryCourierOrderParams implements Parcelable {
    public static final Parcelable.Creator<DeliveryCourierOrderParams> CREATOR = new Creator();
    @SerializedName("arrivalTime")
    @Nullable
    private final ArrivalTime arrivalTime;
    @SerializedName("cancelButtonText")
    @Nullable
    private final String cancelButtonText;
    @SerializedName("groups")
    @Nullable
    private final List<FormGroup> groups;
    @SerializedName("itemID")
    @Nullable
    private final String itemID;
    @SerializedName("selectedTimeInterval")
    @Nullable
    private final TimeInterval selectedTimeInterval;
    @SerializedName("submitButtonText")
    @Nullable
    private final String submitButtonText;
    @SerializedName(MessengerShareContentUtility.SUBTITLE)
    @Nullable
    private final String subtitle;
    @SerializedName("title")
    @Nullable
    private final String toolbarTitle;

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\u0010\u001a\u00020\u000b¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\f\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u000f¨\u0006\u0014"}, d2 = {"Lcom/avito/android/remote/model/delivery_courier/DeliveryCourierOrderParams$ArrivalTime;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "day", "Ljava/lang/String;", "getDay", "()Ljava/lang/String;", "time", "getTime", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "delivery_release"}, k = 1, mv = {1, 4, 2})
    public static final class ArrivalTime implements Parcelable {
        public static final Parcelable.Creator<ArrivalTime> CREATOR = new Creator();
        @SerializedName("day")
        @NotNull
        private final String day;
        @SerializedName("time")
        @NotNull
        private final String time;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<ArrivalTime> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final ArrivalTime createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new ArrivalTime(parcel.readString(), parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final ArrivalTime[] newArray(int i) {
                return new ArrivalTime[i];
            }
        }

        public ArrivalTime(@NotNull String str, @NotNull String str2) {
            Intrinsics.checkNotNullParameter(str, "day");
            Intrinsics.checkNotNullParameter(str2, "time");
            this.day = str;
            this.time = str2;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @NotNull
        public final String getDay() {
            return this.day;
        }

        @NotNull
        public final String getTime() {
            return this.time;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.day);
            parcel.writeString(this.time);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<DeliveryCourierOrderParams> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final DeliveryCourierOrderParams createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            ArrayList arrayList = null;
            TimeInterval createFromParcel = parcel.readInt() != 0 ? TimeInterval.CREATOR.createFromParcel(parcel) : null;
            ArrivalTime createFromParcel2 = parcel.readInt() != 0 ? ArrivalTime.CREATOR.createFromParcel(parcel) : null;
            String readString3 = parcel.readString();
            if (parcel.readInt() != 0) {
                int readInt = parcel.readInt();
                arrayList = new ArrayList(readInt);
                while (readInt != 0) {
                    arrayList.add(FormGroup.CREATOR.createFromParcel(parcel));
                    readInt--;
                }
            }
            return new DeliveryCourierOrderParams(readString, readString2, createFromParcel, createFromParcel2, readString3, arrayList, parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final DeliveryCourierOrderParams[] newArray(int i) {
            return new DeliveryCourierOrderParams[i];
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR$\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/avito/android/remote/model/delivery_courier/DeliveryCourierOrderParams$FormGroup;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "Lcom/avito/android/remote/model/category_parameters/base/ParameterSlot;", "formSections", "Ljava/util/List;", "getFormSections", "()Ljava/util/List;", "<init>", "(Ljava/util/List;)V", "delivery_release"}, k = 1, mv = {1, 4, 2})
    public static final class FormGroup implements Parcelable {
        public static final Parcelable.Creator<FormGroup> CREATOR = new Creator();
        @SerializedName("formSections")
        @Nullable
        private final List<ParameterSlot> formSections;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<FormGroup> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final FormGroup createFromParcel(@NotNull Parcel parcel) {
                ArrayList arrayList;
                Intrinsics.checkNotNullParameter(parcel, "in");
                if (parcel.readInt() != 0) {
                    int readInt = parcel.readInt();
                    arrayList = new ArrayList(readInt);
                    while (readInt != 0) {
                        arrayList.add((ParameterSlot) parcel.readParcelable(FormGroup.class.getClassLoader()));
                        readInt--;
                    }
                } else {
                    arrayList = null;
                }
                return new FormGroup(arrayList);
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final FormGroup[] newArray(int i) {
                return new FormGroup[i];
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.util.List<? extends com.avito.android.remote.model.category_parameters.base.ParameterSlot> */
        /* JADX WARN: Multi-variable type inference failed */
        public FormGroup(@Nullable List<? extends ParameterSlot> list) {
            this.formSections = list;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Nullable
        public final List<ParameterSlot> getFormSections() {
            return this.formSections;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            List<ParameterSlot> list = this.formSections;
            if (list != null) {
                Iterator l0 = a.l0(parcel, 1, list);
                while (l0.hasNext()) {
                    parcel.writeParcelable((ParameterSlot) l0.next(), i);
                }
                return;
            }
            parcel.writeInt(0);
        }
    }

    public DeliveryCourierOrderParams(@Nullable String str, @Nullable String str2, @Nullable TimeInterval timeInterval, @Nullable ArrivalTime arrivalTime2, @Nullable String str3, @Nullable List<FormGroup> list, @Nullable String str4, @Nullable String str5) {
        this.toolbarTitle = str;
        this.subtitle = str2;
        this.selectedTimeInterval = timeInterval;
        this.arrivalTime = arrivalTime2;
        this.itemID = str3;
        this.groups = list;
        this.submitButtonText = str4;
        this.cancelButtonText = str5;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final ArrivalTime getArrivalTime() {
        return this.arrivalTime;
    }

    @Nullable
    public final String getCancelButtonText() {
        return this.cancelButtonText;
    }

    @Nullable
    public final List<FormGroup> getGroups() {
        return this.groups;
    }

    @Nullable
    public final String getItemID() {
        return this.itemID;
    }

    @Nullable
    public final TimeInterval getSelectedTimeInterval() {
        return this.selectedTimeInterval;
    }

    @Nullable
    public final String getSubmitButtonText() {
        return this.submitButtonText;
    }

    @Nullable
    public final String getSubtitle() {
        return this.subtitle;
    }

    @Nullable
    public final String getToolbarTitle() {
        return this.toolbarTitle;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.toolbarTitle);
        parcel.writeString(this.subtitle);
        TimeInterval timeInterval = this.selectedTimeInterval;
        if (timeInterval != null) {
            parcel.writeInt(1);
            timeInterval.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        ArrivalTime arrivalTime2 = this.arrivalTime;
        if (arrivalTime2 != null) {
            parcel.writeInt(1);
            arrivalTime2.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        parcel.writeString(this.itemID);
        List<FormGroup> list = this.groups;
        if (list != null) {
            Iterator l0 = a.l0(parcel, 1, list);
            while (l0.hasNext()) {
                ((FormGroup) l0.next()).writeToParcel(parcel, 0);
            }
        } else {
            parcel.writeInt(0);
        }
        parcel.writeString(this.submitButtonText);
        parcel.writeString(this.cancelButtonText);
    }
}
