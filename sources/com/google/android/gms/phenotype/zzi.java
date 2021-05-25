package com.google.android.gms.phenotype;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;
import com.avito.android.BuildConfig;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Arrays;
import java.util.Comparator;
@SafeParcelable.Class(creator = "FlagCreator")
@SafeParcelable.Reserved({1})
public final class zzi extends AbstractSafeParcelable implements Comparable<zzi> {
    public static final Parcelable.Creator<zzi> CREATOR = new zzk();
    private static final Comparator<zzi> zzai = new zzj();
    @SafeParcelable.Field(id = 2)
    public final String name;
    @SafeParcelable.Field(id = 3)
    private final long zzab;
    @SafeParcelable.Field(id = 4)
    private final boolean zzac;
    @SafeParcelable.Field(id = 5)
    private final double zzad;
    @SafeParcelable.Field(id = 6)
    private final String zzae;
    @SafeParcelable.Field(id = 7)
    private final byte[] zzaf;
    @SafeParcelable.Field(id = 8)
    private final int zzag;
    @SafeParcelable.Field(id = 9)
    public final int zzah;

    @SafeParcelable.Constructor
    public zzi(@SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) long j, @SafeParcelable.Param(id = 4) boolean z, @SafeParcelable.Param(id = 5) double d, @SafeParcelable.Param(id = 6) String str2, @SafeParcelable.Param(id = 7) byte[] bArr, @SafeParcelable.Param(id = 8) int i, @SafeParcelable.Param(id = 9) int i2) {
        this.name = str;
        this.zzab = j;
        this.zzac = z;
        this.zzad = d;
        this.zzae = str2;
        this.zzaf = bArr;
        this.zzag = i;
        this.zzah = i2;
    }

    private static int compare(int i, int i2) {
        if (i < i2) {
            return -1;
        }
        return i == i2 ? 0 : 1;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(zzi zzi) {
        zzi zzi2 = zzi;
        int compareTo = this.name.compareTo(zzi2.name);
        if (compareTo != 0) {
            return compareTo;
        }
        int compare = compare(this.zzag, zzi2.zzag);
        if (compare != 0) {
            return compare;
        }
        int i = this.zzag;
        if (i == 1) {
            int i2 = (this.zzab > zzi2.zzab ? 1 : (this.zzab == zzi2.zzab ? 0 : -1));
            if (i2 < 0) {
                return -1;
            }
            return i2 == 0 ? 0 : 1;
        } else if (i == 2) {
            boolean z = this.zzac;
            if (z == zzi2.zzac) {
                return 0;
            }
            return z ? 1 : -1;
        } else if (i == 3) {
            return Double.compare(this.zzad, zzi2.zzad);
        } else {
            if (i == 4) {
                String str = this.zzae;
                String str2 = zzi2.zzae;
                if (str == str2) {
                    return 0;
                }
                if (str == null) {
                    return -1;
                }
                if (str2 == null) {
                    return 1;
                }
                return str.compareTo(str2);
            } else if (i == 5) {
                byte[] bArr = this.zzaf;
                byte[] bArr2 = zzi2.zzaf;
                if (bArr == bArr2) {
                    return 0;
                }
                if (bArr == null) {
                    return -1;
                }
                if (bArr2 == null) {
                    return 1;
                }
                for (int i3 = 0; i3 < Math.min(this.zzaf.length, zzi2.zzaf.length); i3++) {
                    int i4 = this.zzaf[i3] - zzi2.zzaf[i3];
                    if (i4 != 0) {
                        return i4;
                    }
                }
                return compare(this.zzaf.length, zzi2.zzaf.length);
            } else {
                throw new AssertionError(a.m2(31, "Invalid enum value: ", this.zzag));
            }
        }
    }

    @Override // java.lang.Object
    public final boolean equals(Object obj) {
        int i;
        if (obj instanceof zzi) {
            zzi zzi = (zzi) obj;
            if (zzn.equals(this.name, zzi.name) && (i = this.zzag) == zzi.zzag && this.zzah == zzi.zzah) {
                if (i != 1) {
                    if (i == 2) {
                        return this.zzac == zzi.zzac;
                    }
                    if (i == 3) {
                        return this.zzad == zzi.zzad;
                    }
                    if (i == 4) {
                        return zzn.equals(this.zzae, zzi.zzae);
                    }
                    if (i == 5) {
                        return Arrays.equals(this.zzaf, zzi.zzaf);
                    }
                    throw new AssertionError(a.m2(31, "Invalid enum value: ", this.zzag));
                } else if (this.zzab == zzi.zzab) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // java.lang.Object
    public final String toString() {
        String str;
        StringBuilder L = a.L("Flag(");
        L.append(this.name);
        L.append(", ");
        int i = this.zzag;
        if (i == 1) {
            L.append(this.zzab);
        } else if (i == 2) {
            L.append(this.zzac);
        } else if (i != 3) {
            if (i == 4) {
                L.append("'");
                str = this.zzae;
            } else if (i != 5) {
                String str2 = this.name;
                int i2 = this.zzag;
                StringBuilder sb = new StringBuilder(a.q0(str2, 27));
                sb.append("Invalid type: ");
                sb.append(str2);
                sb.append(", ");
                sb.append(i2);
                throw new AssertionError(sb.toString());
            } else if (this.zzaf == null) {
                L.append(BuildConfig.ADJUST_DEFAULT_TRACKER);
            } else {
                L.append("'");
                str = Base64.encodeToString(this.zzaf, 3);
            }
            L.append(str);
            L.append("'");
        } else {
            L.append(this.zzad);
        }
        L.append(", ");
        L.append(this.zzag);
        L.append(", ");
        return a.j(L, this.zzah, ")");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.name, false);
        SafeParcelWriter.writeLong(parcel, 3, this.zzab);
        SafeParcelWriter.writeBoolean(parcel, 4, this.zzac);
        SafeParcelWriter.writeDouble(parcel, 5, this.zzad);
        SafeParcelWriter.writeString(parcel, 6, this.zzae, false);
        SafeParcelWriter.writeByteArray(parcel, 7, this.zzaf, false);
        SafeParcelWriter.writeInt(parcel, 8, this.zzag);
        SafeParcelWriter.writeInt(parcel, 9, this.zzah);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
