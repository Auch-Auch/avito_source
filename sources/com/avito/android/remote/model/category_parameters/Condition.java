package com.avito.android.remote.model.category_parameters;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\u0004B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0001\u0005¨\u0006\u0006"}, d2 = {"Lcom/avito/android/remote/model/category_parameters/Condition;", "Landroid/os/Parcelable;", "<init>", "()V", "SelectParameterValue", "Lcom/avito/android/remote/model/category_parameters/Condition$SelectParameterValue;", "models_release"}, k = 1, mv = {1, 4, 2})
public abstract class Condition implements Parcelable {

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0010¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\f\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\"\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2 = {"Lcom/avito/android/remote/model/category_parameters/Condition$SelectParameterValue;", "Lcom/avito/android/remote/model/category_parameters/Condition;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "paramId", "Ljava/lang/String;", "getParamId", "()Ljava/lang/String;", "", "valueIds", "Ljava/util/List;", "getValueIds", "()Ljava/util/List;", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class SelectParameterValue extends Condition {
        public static final Parcelable.Creator<SelectParameterValue> CREATOR = new Creator();
        @SerializedName("paramId")
        @NotNull
        private final String paramId;
        @SerializedName("valueIds")
        @NotNull
        private final List<String> valueIds;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<SelectParameterValue> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final SelectParameterValue createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new SelectParameterValue(parcel.readString(), parcel.createStringArrayList());
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final SelectParameterValue[] newArray(int i) {
                return new SelectParameterValue[i];
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SelectParameterValue(@NotNull String str, @NotNull List<String> list) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "paramId");
            Intrinsics.checkNotNullParameter(list, "valueIds");
            this.paramId = str;
            this.valueIds = list;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @NotNull
        public final String getParamId() {
            return this.paramId;
        }

        @NotNull
        public final List<String> getValueIds() {
            return this.valueIds;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.paramId);
            parcel.writeStringList(this.valueIds);
        }
    }

    private Condition() {
    }

    public /* synthetic */ Condition(j jVar) {
        this();
    }
}
