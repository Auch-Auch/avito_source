package com.avito.android.developments_catalog.items.consultation;

import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.developments_catalog.DevelopmentsCatalogItem;
import com.avito.android.developments_catalog.remote.model.DevelopmentsAdviceView;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.ConsultationFormData;
import com.avito.conveyor_item.ParcelableItem;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B)\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000b\u0012\u0006\u0010\u0019\u001a\u00020\u000b\u0012\u0006\u0010\u001f\u001a\u00020\u001a\u0012\u0006\u0010\u0016\u001a\u00020\u0011¢\u0006\u0004\b \u0010!J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0010\u001a\u00020\u000b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0016\u001a\u00020\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0019\u0010\u0019\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\r\u001a\u0004\b\u0018\u0010\u000fR\u0019\u0010\u001f\u001a\u00020\u001a8\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e¨\u0006\""}, d2 = {"Lcom/avito/android/developments_catalog/items/consultation/ConsultationItem;", "Lcom/avito/conveyor_item/ParcelableItem;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getStringId", "()Ljava/lang/String;", "stringId", "Lcom/avito/android/remote/model/ConsultationFormData;", "d", "Lcom/avito/android/remote/model/ConsultationFormData;", "getFormData", "()Lcom/avito/android/remote/model/ConsultationFormData;", "formData", AuthSource.BOOKING_ORDER, "getDevelopmentId", "developmentId", "Lcom/avito/android/developments_catalog/remote/model/DevelopmentsAdviceView;", "c", "Lcom/avito/android/developments_catalog/remote/model/DevelopmentsAdviceView;", "getViewData", "()Lcom/avito/android/developments_catalog/remote/model/DevelopmentsAdviceView;", "viewData", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/developments_catalog/remote/model/DevelopmentsAdviceView;Lcom/avito/android/remote/model/ConsultationFormData;)V", "developments-catalog_release"}, k = 1, mv = {1, 4, 2})
public final class ConsultationItem implements ParcelableItem {
    public static final Parcelable.Creator<ConsultationItem> CREATOR = new Creator();
    @NotNull
    public final String a;
    @NotNull
    public final String b;
    @NotNull
    public final DevelopmentsAdviceView c;
    @NotNull
    public final ConsultationFormData d;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<ConsultationItem> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ConsultationItem createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new ConsultationItem(parcel.readString(), parcel.readString(), (DevelopmentsAdviceView) parcel.readParcelable(ConsultationItem.class.getClassLoader()), (ConsultationFormData) parcel.readParcelable(ConsultationItem.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ConsultationItem[] newArray(int i) {
            return new ConsultationItem[i];
        }
    }

    public ConsultationItem(@NotNull String str, @NotNull String str2, @NotNull DevelopmentsAdviceView developmentsAdviceView, @NotNull ConsultationFormData consultationFormData) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(str2, "developmentId");
        Intrinsics.checkNotNullParameter(developmentsAdviceView, "viewData");
        Intrinsics.checkNotNullParameter(consultationFormData, "formData");
        this.a = str;
        this.b = str2;
        this.c = developmentsAdviceView;
        this.d = consultationFormData;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NotNull
    public final String getDevelopmentId() {
        return this.b;
    }

    @NotNull
    public final ConsultationFormData getFormData() {
        return this.d;
    }

    @Override // com.avito.conveyor_item.Item, com.avito.konveyor.blueprint.Item
    public long getId() {
        return ParcelableItem.DefaultImpls.getId(this);
    }

    @Override // com.avito.conveyor_item.Item
    @NotNull
    public String getStringId() {
        return this.a;
    }

    @NotNull
    public final DevelopmentsAdviceView getViewData() {
        return this.c;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeParcelable(this.c, i);
        parcel.writeParcelable(this.d, i);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ConsultationItem(String str, String str2, DevelopmentsAdviceView developmentsAdviceView, ConsultationFormData consultationFormData, int i, j jVar) {
        this((i & 1) != 0 ? DevelopmentsCatalogItem.ITEM_CONSULTATION.toString() : str, str2, developmentsAdviceView, consultationFormData);
    }
}
