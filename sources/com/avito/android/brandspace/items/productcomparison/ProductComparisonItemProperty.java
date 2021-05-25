package com.avito.android.brandspace.items.productcomparison;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.brandspace.items.textmeasurement.TextMeasurableItem;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0015\b\b\u0018\u00002\u00020\u00012\u00020\u0002B7\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0007¢\u0006\u0004\b1\u00102J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0005J\u0010\u0010\b\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\n\u0010\tJ\u0010\u0010\u000b\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\u000b\u0010\tJD\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00072\b\b\u0002\u0010\u000f\u001a\u00020\u00072\b\b\u0002\u0010\u0010\u001a\u00020\u0007HÆ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0005J\u0010\u0010\u0014\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\u0014\u0010\tJ\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\u001a\u0010\tJ \u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\u001f\u0010 R\"\u0010\u0010\u001a\u00020\u00078\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010\t\"\u0004\b$\u0010%R\"\u0010\u000f\u001a\u00020\u00078\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b&\u0010\"\u001a\u0004\b'\u0010\t\"\u0004\b(\u0010%R\u001b\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006@\u0006¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010\u0005R\u0019\u0010\r\u001a\u00020\u00038\u0006@\u0006¢\u0006\f\n\u0004\b,\u0010*\u001a\u0004\b-\u0010\u0005R\"\u0010\u000e\u001a\u00020\u00078\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b.\u0010\"\u001a\u0004\b/\u0010\t\"\u0004\b0\u0010%¨\u00063"}, d2 = {"Lcom/avito/android/brandspace/items/productcomparison/ProductComparisonItemProperty;", "Landroid/os/Parcelable;", "Lcom/avito/android/brandspace/items/textmeasurement/TextMeasurableItem;", "", "component1", "()Ljava/lang/String;", "component2", "", "component3", "()I", "component4", "component5", "name", "value", "topPadding", "precalculatedTextHeight", "precalculatedMetricsHash", "copy", "(Ljava/lang/String;Ljava/lang/String;III)Lcom/avito/android/brandspace/items/productcomparison/ProductComparisonItemProperty;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "e", "I", "getPrecalculatedMetricsHash", "setPrecalculatedMetricsHash", "(I)V", "d", "getPrecalculatedTextHeight", "setPrecalculatedTextHeight", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getName", AuthSource.BOOKING_ORDER, "getValue", "c", "getTopPadding", "setTopPadding", "<init>", "(Ljava/lang/String;Ljava/lang/String;III)V", "brandspace_release"}, k = 1, mv = {1, 4, 2})
public final class ProductComparisonItemProperty implements Parcelable, TextMeasurableItem {
    public static final Parcelable.Creator<ProductComparisonItemProperty> CREATOR = new Creator();
    @Nullable
    public final String a;
    @NotNull
    public final String b;
    public int c;
    public int d;
    public int e;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<ProductComparisonItemProperty> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ProductComparisonItemProperty createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new ProductComparisonItemProperty(parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final ProductComparisonItemProperty[] newArray(int i) {
            return new ProductComparisonItemProperty[i];
        }
    }

    public ProductComparisonItemProperty(@Nullable String str, @NotNull String str2, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(str2, "value");
        this.a = str;
        this.b = str2;
        this.c = i;
        this.d = i2;
        this.e = i3;
    }

    public static /* synthetic */ ProductComparisonItemProperty copy$default(ProductComparisonItemProperty productComparisonItemProperty, String str, String str2, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            str = productComparisonItemProperty.a;
        }
        if ((i4 & 2) != 0) {
            str2 = productComparisonItemProperty.b;
        }
        if ((i4 & 4) != 0) {
            i = productComparisonItemProperty.c;
        }
        if ((i4 & 8) != 0) {
            i2 = productComparisonItemProperty.getPrecalculatedTextHeight();
        }
        if ((i4 & 16) != 0) {
            i3 = productComparisonItemProperty.getPrecalculatedMetricsHash();
        }
        return productComparisonItemProperty.copy(str, str2, i, i2, i3);
    }

    @Nullable
    public final String component1() {
        return this.a;
    }

    @NotNull
    public final String component2() {
        return this.b;
    }

    public final int component3() {
        return this.c;
    }

    public final int component4() {
        return getPrecalculatedTextHeight();
    }

    public final int component5() {
        return getPrecalculatedMetricsHash();
    }

    @NotNull
    public final ProductComparisonItemProperty copy(@Nullable String str, @NotNull String str2, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(str2, "value");
        return new ProductComparisonItemProperty(str, str2, i, i2, i3);
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
        if (!(obj instanceof ProductComparisonItemProperty)) {
            return false;
        }
        ProductComparisonItemProperty productComparisonItemProperty = (ProductComparisonItemProperty) obj;
        return Intrinsics.areEqual(this.a, productComparisonItemProperty.a) && Intrinsics.areEqual(this.b, productComparisonItemProperty.b) && this.c == productComparisonItemProperty.c && getPrecalculatedTextHeight() == productComparisonItemProperty.getPrecalculatedTextHeight() && getPrecalculatedMetricsHash() == productComparisonItemProperty.getPrecalculatedMetricsHash();
    }

    @Nullable
    public final String getName() {
        return this.a;
    }

    @Override // com.avito.android.brandspace.items.textmeasurement.TextMeasurableItem
    public int getPrecalculatedMetricsHash() {
        return this.e;
    }

    @Override // com.avito.android.brandspace.items.textmeasurement.TextMeasurableItem
    public int getPrecalculatedTextHeight() {
        return this.d;
    }

    public final int getTopPadding() {
        return this.c;
    }

    @NotNull
    public final String getValue() {
        return this.b;
    }

    @Override // java.lang.Object
    public int hashCode() {
        String str = this.a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.b;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return getPrecalculatedMetricsHash() + ((getPrecalculatedTextHeight() + ((((hashCode + i) * 31) + this.c) * 31)) * 31);
    }

    @Override // com.avito.android.brandspace.items.textmeasurement.TextMeasurableItem
    public void setPrecalculatedMetricsHash(int i) {
        this.e = i;
    }

    @Override // com.avito.android.brandspace.items.textmeasurement.TextMeasurableItem
    public void setPrecalculatedTextHeight(int i) {
        this.d = i;
    }

    public final void setTopPadding(int i) {
        this.c = i;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("ProductComparisonItemProperty(name=");
        L.append(this.a);
        L.append(", value=");
        L.append(this.b);
        L.append(", topPadding=");
        L.append(this.c);
        L.append(", precalculatedTextHeight=");
        L.append(getPrecalculatedTextHeight());
        L.append(", precalculatedMetricsHash=");
        L.append(getPrecalculatedMetricsHash());
        L.append(")");
        return L.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeInt(this.c);
        parcel.writeInt(this.d);
        parcel.writeInt(this.e);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ProductComparisonItemProperty(String str, String str2, int i, int i2, int i3, int i4, j jVar) {
        this(str, str2, (i4 & 4) != 0 ? 0 : i, (i4 & 8) != 0 ? 0 : i2, (i4 & 16) != 0 ? 0 : i3);
    }
}
