package com.google.android.gms.internal.ads;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;
public final class zzjn implements Parcelable, Comparator<zza> {
    public static final Parcelable.Creator<zzjn> CREATOR = new zzjm();
    private int zzahr;
    private final zza[] zzaog;
    public final int zzaoh;

    public static final class zza implements Parcelable {
        public static final Parcelable.Creator<zza> CREATOR = new zzjo();
        private final byte[] data;
        private final String mimeType;
        private final UUID uuid;
        private int zzahr;
        public final boolean zzaoi;

        public zza(UUID uuid2, String str, byte[] bArr) {
            this(uuid2, str, bArr, false);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override // java.lang.Object
        public final boolean equals(Object obj) {
            if (!(obj instanceof zza)) {
                return false;
            }
            if (obj == this) {
                return true;
            }
            zza zza = (zza) obj;
            return this.mimeType.equals(zza.mimeType) && zzpq.zza(this.uuid, zza.uuid) && Arrays.equals(this.data, zza.data);
        }

        @Override // java.lang.Object
        public final int hashCode() {
            if (this.zzahr == 0) {
                this.zzahr = Arrays.hashCode(this.data) + a.B0(this.mimeType, this.uuid.hashCode() * 31, 31);
            }
            return this.zzahr;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            parcel.writeLong(this.uuid.getMostSignificantBits());
            parcel.writeLong(this.uuid.getLeastSignificantBits());
            parcel.writeString(this.mimeType);
            parcel.writeByteArray(this.data);
            parcel.writeByte(this.zzaoi ? (byte) 1 : 0);
        }

        private zza(UUID uuid2, String str, byte[] bArr, boolean z) {
            this.uuid = (UUID) zzoz.checkNotNull(uuid2);
            this.mimeType = (String) zzoz.checkNotNull(str);
            this.data = (byte[]) zzoz.checkNotNull(bArr);
            this.zzaoi = false;
        }

        public zza(Parcel parcel) {
            this.uuid = new UUID(parcel.readLong(), parcel.readLong());
            this.mimeType = parcel.readString();
            this.data = parcel.createByteArray();
            this.zzaoi = parcel.readByte() != 0;
        }
    }

    public zzjn(List<zza> list) {
        this(false, (zza[]) list.toArray(new zza[list.size()]));
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // java.util.Comparator
    public final /* synthetic */ int compare(zza zza2, zza zza3) {
        zza zza4 = zza2;
        zza zza5 = zza3;
        UUID uuid = zzha.UUID_NIL;
        if (uuid.equals(zza4.uuid)) {
            return uuid.equals(zza5.uuid) ? 0 : 1;
        }
        return zza4.uuid.compareTo(zza5.uuid);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // java.lang.Object, java.util.Comparator
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || zzjn.class != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.zzaog, ((zzjn) obj).zzaog);
    }

    @Override // java.lang.Object
    public final int hashCode() {
        if (this.zzahr == 0) {
            this.zzahr = Arrays.hashCode(this.zzaog);
        }
        return this.zzahr;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedArray(this.zzaog, 0);
    }

    public final zza zzag(int i) {
        return this.zzaog[i];
    }

    public zzjn(zza... zzaArr) {
        this(true, zzaArr);
    }

    private zzjn(boolean z, zza... zzaArr) {
        zzaArr = z ? (zza[]) zzaArr.clone() : zzaArr;
        Arrays.sort(zzaArr, this);
        for (int i = 1; i < zzaArr.length; i++) {
            if (zzaArr[i - 1].uuid.equals(zzaArr[i].uuid)) {
                String valueOf = String.valueOf(zzaArr[i].uuid);
                throw new IllegalArgumentException(a.r2(valueOf.length() + 25, "Duplicate data for uuid: ", valueOf));
            }
        }
        this.zzaog = zzaArr;
        this.zzaoh = zzaArr.length;
    }

    public zzjn(Parcel parcel) {
        zza[] zzaArr = (zza[]) parcel.createTypedArray(zza.CREATOR);
        this.zzaog = zzaArr;
        this.zzaoh = zzaArr.length;
    }
}
