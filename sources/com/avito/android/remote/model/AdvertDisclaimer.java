package com.avito.android.remote.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.model.text.AttributedText;
import com.avito.android.tariff.tariff_package_info.viewmodel.TariffPackageInfoConverterKt;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001e\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u000f¨\u0006\u0014"}, d2 = {"Lcom/avito/android/remote/model/AdvertDisclaimer;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/model/text/AttributedText;", TariffPackageInfoConverterKt.HEADER_STRING_ID, "Lcom/avito/android/remote/model/text/AttributedText;", "getHeader", "()Lcom/avito/android/remote/model/text/AttributedText;", SDKConstants.PARAM_A2U_BODY, "getBody", "<init>", "(Lcom/avito/android/remote/model/text/AttributedText;Lcom/avito/android/remote/model/text/AttributedText;)V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertDisclaimer implements Parcelable {
    public static final Parcelable.Creator<AdvertDisclaimer> CREATOR = new Creator();
    @SerializedName(SDKConstants.PARAM_A2U_BODY)
    @Nullable
    private final AttributedText body;
    @SerializedName(TariffPackageInfoConverterKt.HEADER_STRING_ID)
    @Nullable
    private final AttributedText header;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<AdvertDisclaimer> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final AdvertDisclaimer createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new AdvertDisclaimer((AttributedText) parcel.readParcelable(AdvertDisclaimer.class.getClassLoader()), (AttributedText) parcel.readParcelable(AdvertDisclaimer.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final AdvertDisclaimer[] newArray(int i) {
            return new AdvertDisclaimer[i];
        }
    }

    public AdvertDisclaimer(@Nullable AttributedText attributedText, @Nullable AttributedText attributedText2) {
        this.header = attributedText;
        this.body = attributedText2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final AttributedText getBody() {
        return this.body;
    }

    @Nullable
    public final AttributedText getHeader() {
        return this.header;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeParcelable(this.header, i);
        parcel.writeParcelable(this.body, i);
    }
}
