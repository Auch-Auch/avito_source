package com.avito.android.remote.model.delivery;

import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.model.text.AttributedText;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \"2\u00020\u0001:\u0001\"B5\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\u000e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001a\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b \u0010!J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nR\u001e\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R$\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001a8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f¨\u0006#"}, d2 = {"Lcom/avito/android/remote/model/delivery/DeliveryTypes;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "dest", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/model/delivery/DeliveryTypeError;", "error", "Lcom/avito/android/remote/model/delivery/DeliveryTypeError;", "getError", "()Lcom/avito/android/remote/model/delivery/DeliveryTypeError;", "Lcom/avito/android/remote/model/text/AttributedText;", "disclaimer", "Lcom/avito/android/remote/model/text/AttributedText;", "getDisclaimer", "()Lcom/avito/android/remote/model/text/AttributedText;", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "", "Lcom/avito/android/remote/model/delivery/DeliveryType;", "types", "Ljava/util/List;", "getTypes", "()Ljava/util/List;", "<init>", "(Ljava/lang/String;Ljava/util/List;Lcom/avito/android/remote/model/delivery/DeliveryTypeError;Lcom/avito/android/remote/model/text/AttributedText;)V", "Companion", "delivery_release"}, k = 1, mv = {1, 4, 2})
public final class DeliveryTypes implements Parcelable {
    @JvmField
    @NotNull
    public static final Parcelable.Creator<DeliveryTypes> CREATOR = Parcels.creator(DeliveryTypes$Companion$CREATOR$1.INSTANCE);
    @NotNull
    public static final Companion Companion = new Companion(null);
    @SerializedName("disclaimer")
    @Nullable
    private final AttributedText disclaimer;
    @SerializedName("error")
    @Nullable
    private final DeliveryTypeError error;
    @SerializedName("title")
    @Nullable
    private final String title;
    @SerializedName("types")
    @Nullable
    private final List<DeliveryType> types;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/remote/model/delivery/DeliveryTypes$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/remote/model/delivery/DeliveryTypes;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "delivery_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(j jVar) {
            this();
        }
    }

    public DeliveryTypes(@Nullable String str, @Nullable List<DeliveryType> list, @Nullable DeliveryTypeError deliveryTypeError, @Nullable AttributedText attributedText) {
        this.title = str;
        this.types = list;
        this.error = deliveryTypeError;
        this.disclaimer = attributedText;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final AttributedText getDisclaimer() {
        return this.disclaimer;
    }

    @Nullable
    public final DeliveryTypeError getError() {
        return this.error;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    public final List<DeliveryType> getTypes() {
        return this.types;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        parcel.writeString(this.title);
        ParcelsKt.writeOptimizedParcelableList$default(parcel, this.types, 0, 2, null);
        parcel.writeParcelable(this.error, i);
        parcel.writeParcelable(this.disclaimer, i);
    }
}
