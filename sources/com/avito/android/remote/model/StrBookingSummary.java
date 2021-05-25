package com.avito.android.remote.model;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B1\u0012\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000b\u0012\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR$\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R$\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u000e\u001a\u0004\b\u0013\u0010\u0010R\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001b"}, d2 = {"Lcom/avito/android/remote/model/StrBookingSummary;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "Lcom/avito/android/remote/model/StrBookingCalculation;", "calculations", "Ljava/util/List;", "getCalculations", "()Ljava/util/List;", "Lcom/avito/android/remote/model/text/AttributedText;", ErrorBundle.DETAIL_ENTRY, "getDetails", "Lcom/avito/android/remote/model/StrBookingDisclaimer;", "disclaimer", "Lcom/avito/android/remote/model/StrBookingDisclaimer;", "getDisclaimer", "()Lcom/avito/android/remote/model/StrBookingDisclaimer;", "<init>", "(Ljava/util/List;Ljava/util/List;Lcom/avito/android/remote/model/StrBookingDisclaimer;)V", "short-term-rent_release"}, k = 1, mv = {1, 4, 2})
public final class StrBookingSummary implements Parcelable {
    public static final Parcelable.Creator<StrBookingSummary> CREATOR = new Creator();
    @SerializedName("calculations")
    @Nullable
    private final List<StrBookingCalculation> calculations;
    @SerializedName(ErrorBundle.DETAIL_ENTRY)
    @Nullable
    private final List<AttributedText> details;
    @SerializedName("disclaimer")
    @Nullable
    private final StrBookingDisclaimer disclaimer;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<StrBookingSummary> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final StrBookingSummary createFromParcel(@NotNull Parcel parcel) {
            ArrayList arrayList;
            ArrayList arrayList2;
            Intrinsics.checkNotNullParameter(parcel, "in");
            StrBookingDisclaimer strBookingDisclaimer = null;
            if (parcel.readInt() != 0) {
                int readInt = parcel.readInt();
                arrayList = new ArrayList(readInt);
                while (readInt != 0) {
                    arrayList.add((AttributedText) parcel.readParcelable(StrBookingSummary.class.getClassLoader()));
                    readInt--;
                }
            } else {
                arrayList = null;
            }
            if (parcel.readInt() != 0) {
                int readInt2 = parcel.readInt();
                arrayList2 = new ArrayList(readInt2);
                while (readInt2 != 0) {
                    arrayList2.add(StrBookingCalculation.CREATOR.createFromParcel(parcel));
                    readInt2--;
                }
            } else {
                arrayList2 = null;
            }
            if (parcel.readInt() != 0) {
                strBookingDisclaimer = StrBookingDisclaimer.CREATOR.createFromParcel(parcel);
            }
            return new StrBookingSummary(arrayList, arrayList2, strBookingDisclaimer);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final StrBookingSummary[] newArray(int i) {
            return new StrBookingSummary[i];
        }
    }

    public StrBookingSummary(@Nullable List<AttributedText> list, @Nullable List<StrBookingCalculation> list2, @Nullable StrBookingDisclaimer strBookingDisclaimer) {
        this.details = list;
        this.calculations = list2;
        this.disclaimer = strBookingDisclaimer;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final List<StrBookingCalculation> getCalculations() {
        return this.calculations;
    }

    @Nullable
    public final List<AttributedText> getDetails() {
        return this.details;
    }

    @Nullable
    public final StrBookingDisclaimer getDisclaimer() {
        return this.disclaimer;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        List<AttributedText> list = this.details;
        if (list != null) {
            Iterator l0 = a.l0(parcel, 1, list);
            while (l0.hasNext()) {
                parcel.writeParcelable((AttributedText) l0.next(), i);
            }
        } else {
            parcel.writeInt(0);
        }
        List<StrBookingCalculation> list2 = this.calculations;
        if (list2 != null) {
            Iterator l02 = a.l0(parcel, 1, list2);
            while (l02.hasNext()) {
                ((StrBookingCalculation) l02.next()).writeToParcel(parcel, 0);
            }
        } else {
            parcel.writeInt(0);
        }
        StrBookingDisclaimer strBookingDisclaimer = this.disclaimer;
        if (strBookingDisclaimer != null) {
            parcel.writeInt(1);
            strBookingDisclaimer.writeToParcel(parcel, 0);
            return;
        }
        parcel.writeInt(0);
    }
}
