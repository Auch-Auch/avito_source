package com.avito.android.remote.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
public class DictionaryEntity implements Parcelable, Entity<Long> {
    public static final Parcelable.Creator<DictionaryEntity> CREATOR = new Parcelable.Creator<DictionaryEntity>() { // from class: com.avito.android.remote.model.DictionaryEntity.1
        @Override // android.os.Parcelable.Creator
        public DictionaryEntity createFromParcel(Parcel parcel) {
            return new DictionaryEntity(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public DictionaryEntity[] newArray(int i) {
            return new DictionaryEntity[i];
        }
    };
    public final long id;
    public String name;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.avito.android.remote.model.Entity
    public String getName() {
        return this.name;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.id);
        parcel.writeString(this.name);
    }

    public DictionaryEntity(long j) {
        this.id = j;
    }

    @Override // com.avito.android.remote.model.Entity
    @NonNull
    public Long getId() {
        return Long.valueOf(this.id);
    }

    private DictionaryEntity(Parcel parcel) {
        this.id = parcel.readLong();
        this.name = parcel.readString();
    }
}
