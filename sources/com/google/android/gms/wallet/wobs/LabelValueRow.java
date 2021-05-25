package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.ArrayUtils;
import java.util.ArrayList;
import java.util.Collection;
@SafeParcelable.Class(creator = "LabelValueRowCreator")
@SafeParcelable.Reserved({1})
public final class LabelValueRow extends AbstractSafeParcelable {
    public static final Parcelable.Creator<LabelValueRow> CREATOR = new zze();
    @SafeParcelable.Field(id = 2)
    @Deprecated
    public String zzeu;
    @SafeParcelable.Field(id = 3)
    @Deprecated
    public String zzev;
    @SafeParcelable.Field(defaultValueUnchecked = "com.google.android.gms.common.util.ArrayUtils.newArrayList()", id = 4)
    public ArrayList<LabelValue> zzew;

    public final class Builder {
        private Builder() {
        }

        public final Builder addColumn(LabelValue labelValue) {
            LabelValueRow.this.zzew.add(labelValue);
            return this;
        }

        public final Builder addColumns(Collection<LabelValue> collection) {
            LabelValueRow.this.zzew.addAll(collection);
            return this;
        }

        public final LabelValueRow build() {
            return LabelValueRow.this;
        }

        @Deprecated
        public final Builder setHexBackgroundColor(String str) {
            LabelValueRow.this.zzev = str;
            return this;
        }

        @Deprecated
        public final Builder setHexFontColor(String str) {
            LabelValueRow.this.zzeu = str;
            return this;
        }
    }

    @SafeParcelable.Constructor
    public LabelValueRow(@SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) String str2, @SafeParcelable.Param(id = 4) ArrayList<LabelValue> arrayList) {
        this.zzeu = str;
        this.zzev = str2;
        this.zzew = arrayList;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public final ArrayList<LabelValue> getColumns() {
        return this.zzew;
    }

    @Deprecated
    public final String getHexBackgroundColor() {
        return this.zzev;
    }

    @Deprecated
    public final String getHexFontColor() {
        return this.zzeu;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.zzeu, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzev, false);
        SafeParcelWriter.writeTypedList(parcel, 4, this.zzew, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public LabelValueRow() {
        this.zzew = ArrayUtils.newArrayList();
    }
}
