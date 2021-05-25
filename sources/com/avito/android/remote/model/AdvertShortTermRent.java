package com.avito.android.remote.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0017B\u001b\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001e\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0018"}, d2 = {"Lcom/avito/android/remote/model/AdvertShortTermRent;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "tag", "Ljava/lang/String;", "getTag", "()Ljava/lang/String;", "Lcom/avito/android/remote/model/AdvertShortTermRent$Actions;", "actions", "Lcom/avito/android/remote/model/AdvertShortTermRent$Actions;", "getActions", "()Lcom/avito/android/remote/model/AdvertShortTermRent$Actions;", "<init>", "(Lcom/avito/android/remote/model/AdvertShortTermRent$Actions;Ljava/lang/String;)V", "Actions", "models_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertShortTermRent implements Parcelable {
    public static final Parcelable.Creator<AdvertShortTermRent> CREATOR = new Creator();
    @SerializedName("actions")
    @Nullable
    private final Actions actions;
    @SerializedName("tag")
    @Nullable
    private final String tag;

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001e\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/avito/android/remote/model/AdvertShortTermRent$Actions;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/model/SimpleAction;", "requestBooking", "Lcom/avito/android/remote/model/SimpleAction;", "getRequestBooking", "()Lcom/avito/android/remote/model/SimpleAction;", "<init>", "(Lcom/avito/android/remote/model/SimpleAction;)V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Actions implements Parcelable {
        public static final Parcelable.Creator<Actions> CREATOR = new Creator();
        @SerializedName("requestBooking")
        @Nullable
        private final SimpleAction requestBooking;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<Actions> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Actions createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new Actions((SimpleAction) parcel.readParcelable(Actions.class.getClassLoader()));
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Actions[] newArray(int i) {
                return new Actions[i];
            }
        }

        public Actions(@Nullable SimpleAction simpleAction) {
            this.requestBooking = simpleAction;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Nullable
        public final SimpleAction getRequestBooking() {
            return this.requestBooking;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeParcelable(this.requestBooking, i);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<AdvertShortTermRent> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final AdvertShortTermRent createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new AdvertShortTermRent(parcel.readInt() != 0 ? Actions.CREATOR.createFromParcel(parcel) : null, parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final AdvertShortTermRent[] newArray(int i) {
            return new AdvertShortTermRent[i];
        }
    }

    public AdvertShortTermRent(@Nullable Actions actions2, @Nullable String str) {
        this.actions = actions2;
        this.tag = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final Actions getActions() {
        return this.actions;
    }

    @Nullable
    public final String getTag() {
        return this.tag;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        Actions actions2 = this.actions;
        if (actions2 != null) {
            parcel.writeInt(1);
            actions2.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        parcel.writeString(this.tag);
    }
}
