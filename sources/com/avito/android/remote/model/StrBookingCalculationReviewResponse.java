package com.avito.android.remote.model;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.model.category_parameters.base.ParameterSlot;
import com.avito.android.remote.model.text.AttributedText;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\f\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR$\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001d"}, d2 = {"Lcom/avito/android/remote/model/StrBookingCalculationReviewResponse;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/model/StrBookingSummary;", ErrorBundle.SUMMARY_ENTRY, "Lcom/avito/android/remote/model/StrBookingSummary;", "getSummary", "()Lcom/avito/android/remote/model/StrBookingSummary;", "", "Lcom/avito/android/remote/model/category_parameters/base/ParameterSlot;", "contactFields", "Ljava/util/List;", "getContactFields", "()Ljava/util/List;", "Lcom/avito/android/remote/model/text/AttributedText;", "disclaimer", "Lcom/avito/android/remote/model/text/AttributedText;", "getDisclaimer", "()Lcom/avito/android/remote/model/text/AttributedText;", "<init>", "(Lcom/avito/android/remote/model/StrBookingSummary;Ljava/util/List;Lcom/avito/android/remote/model/text/AttributedText;)V", "short-term-rent_release"}, k = 1, mv = {1, 4, 2})
public final class StrBookingCalculationReviewResponse implements Parcelable {
    public static final Parcelable.Creator<StrBookingCalculationReviewResponse> CREATOR = new Creator();
    @SerializedName("contactFields")
    @Nullable
    private final List<ParameterSlot> contactFields;
    @SerializedName("disclaimer")
    @Nullable
    private final AttributedText disclaimer;
    @SerializedName(ErrorBundle.SUMMARY_ENTRY)
    @NotNull
    private final StrBookingSummary summary;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<StrBookingCalculationReviewResponse> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final StrBookingCalculationReviewResponse createFromParcel(@NotNull Parcel parcel) {
            ArrayList arrayList;
            Intrinsics.checkNotNullParameter(parcel, "in");
            StrBookingSummary createFromParcel = StrBookingSummary.CREATOR.createFromParcel(parcel);
            if (parcel.readInt() != 0) {
                int readInt = parcel.readInt();
                arrayList = new ArrayList(readInt);
                while (readInt != 0) {
                    arrayList.add((ParameterSlot) parcel.readParcelable(StrBookingCalculationReviewResponse.class.getClassLoader()));
                    readInt--;
                }
            } else {
                arrayList = null;
            }
            return new StrBookingCalculationReviewResponse(createFromParcel, arrayList, (AttributedText) parcel.readParcelable(StrBookingCalculationReviewResponse.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final StrBookingCalculationReviewResponse[] newArray(int i) {
            return new StrBookingCalculationReviewResponse[i];
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.util.List<? extends com.avito.android.remote.model.category_parameters.base.ParameterSlot> */
    /* JADX WARN: Multi-variable type inference failed */
    public StrBookingCalculationReviewResponse(@NotNull StrBookingSummary strBookingSummary, @Nullable List<? extends ParameterSlot> list, @Nullable AttributedText attributedText) {
        Intrinsics.checkNotNullParameter(strBookingSummary, ErrorBundle.SUMMARY_ENTRY);
        this.summary = strBookingSummary;
        this.contactFields = list;
        this.disclaimer = attributedText;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final List<ParameterSlot> getContactFields() {
        return this.contactFields;
    }

    @Nullable
    public final AttributedText getDisclaimer() {
        return this.disclaimer;
    }

    @NotNull
    public final StrBookingSummary getSummary() {
        return this.summary;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        this.summary.writeToParcel(parcel, 0);
        List<ParameterSlot> list = this.contactFields;
        if (list != null) {
            Iterator l0 = a.l0(parcel, 1, list);
            while (l0.hasNext()) {
                parcel.writeParcelable((ParameterSlot) l0.next(), i);
            }
        } else {
            parcel.writeInt(0);
        }
        parcel.writeParcelable(this.disclaimer, i);
    }
}
