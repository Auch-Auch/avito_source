package com.avito.android.remote.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import androidx.annotation.NonNull;
import com.avito.android.util.ParcelUtils;
import com.avito.android.util.SparseArraysKt;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
public class CaseText implements Parcelable, Externalizable {
    public static final Parcelable.Creator<CaseText> CREATOR = new Parcelable.Creator<CaseText>() { // from class: com.avito.android.remote.model.CaseText.1
        @Override // android.os.Parcelable.Creator
        public CaseText createFromParcel(Parcel parcel) {
            return new CaseText(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public CaseText[] newArray(int i) {
            return new CaseText[i];
        }
    };
    private static final long serialVersionUID = 1;
    @NonNull
    private transient SparseArray<String> mNames;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return SparseArraysKt.equals(this.mNames, ((CaseText) obj).mNames);
    }

    public String getName() {
        return this.mNames.get(1);
    }

    public SparseArray<String> getNames() {
        return this.mNames.clone();
    }

    public boolean hasNames() {
        return this.mNames.size() > 0;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return SparseArraysKt.hashCode(this.mNames);
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {
        SparseArraysKt.read(this.mNames, objectInput);
    }

    public void setName(int i, String str) {
        this.mNames.put(i, str);
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        SparseArraysKt.write(this.mNames, objectOutput);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        ParcelUtils.writeSparseArray(parcel, this.mNames);
    }

    public CaseText() {
        this.mNames = new SparseArray<>(0);
    }

    public String getName(int i) {
        return this.mNames.get(i);
    }

    public CaseText(@NonNull SparseArray<String> sparseArray) {
        this.mNames = new SparseArray<>(0);
        this.mNames = sparseArray;
    }

    private CaseText(Parcel parcel) {
        this.mNames = new SparseArray<>(0);
        this.mNames = ParcelUtils.readSparseArray(parcel, getClass());
    }
}
