package com.google.android.gms.common.internal.safeparcel;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import android.util.SparseLongArray;
import androidx.annotation.RecentlyNonNull;
import androidx.core.internal.view.SupportMenu;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
public class SafeParcelWriter {
    private SafeParcelWriter() {
    }

    @RecentlyNonNull
    public static int beginObjectHeader(@RecentlyNonNull Parcel parcel) {
        return zza(parcel, 20293);
    }

    public static void finishObjectHeader(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i) {
        zzb(parcel, i);
    }

    public static void writeBigDecimal(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i, @RecentlyNonNull BigDecimal bigDecimal, @RecentlyNonNull boolean z) {
        if (bigDecimal != null) {
            int zza = zza(parcel, i);
            parcel.writeByteArray(bigDecimal.unscaledValue().toByteArray());
            parcel.writeInt(bigDecimal.scale());
            zzb(parcel, zza);
        } else if (z) {
            zza(parcel, i, 0);
        }
    }

    public static void writeBigDecimalArray(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i, @RecentlyNonNull BigDecimal[] bigDecimalArr, @RecentlyNonNull boolean z) {
        if (bigDecimalArr != null) {
            int zza = zza(parcel, i);
            int length = bigDecimalArr.length;
            parcel.writeInt(length);
            for (int i2 = 0; i2 < length; i2++) {
                parcel.writeByteArray(bigDecimalArr[i2].unscaledValue().toByteArray());
                parcel.writeInt(bigDecimalArr[i2].scale());
            }
            zzb(parcel, zza);
        } else if (z) {
            zza(parcel, i, 0);
        }
    }

    public static void writeBigInteger(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i, @RecentlyNonNull BigInteger bigInteger, @RecentlyNonNull boolean z) {
        if (bigInteger != null) {
            int zza = zza(parcel, i);
            parcel.writeByteArray(bigInteger.toByteArray());
            zzb(parcel, zza);
        } else if (z) {
            zza(parcel, i, 0);
        }
    }

    public static void writeBigIntegerArray(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i, @RecentlyNonNull BigInteger[] bigIntegerArr, @RecentlyNonNull boolean z) {
        if (bigIntegerArr != null) {
            int zza = zza(parcel, i);
            int length = bigIntegerArr.length;
            parcel.writeInt(length);
            for (BigInteger bigInteger : bigIntegerArr) {
                parcel.writeByteArray(bigInteger.toByteArray());
            }
            zzb(parcel, zza);
        } else if (z) {
            zza(parcel, i, 0);
        }
    }

    public static void writeBoolean(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i, @RecentlyNonNull boolean z) {
        zza(parcel, i, 4);
        parcel.writeInt(z ? 1 : 0);
    }

    public static void writeBooleanArray(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i, @RecentlyNonNull boolean[] zArr, @RecentlyNonNull boolean z) {
        if (zArr != null) {
            int zza = zza(parcel, i);
            parcel.writeBooleanArray(zArr);
            zzb(parcel, zza);
        } else if (z) {
            zza(parcel, i, 0);
        }
    }

    public static void writeBooleanList(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i, @RecentlyNonNull List<Boolean> list, @RecentlyNonNull boolean z) {
        if (list != null) {
            int zza = zza(parcel, i);
            int size = list.size();
            parcel.writeInt(size);
            for (int i2 = 0; i2 < size; i2++) {
                parcel.writeInt(list.get(i2).booleanValue() ? 1 : 0);
            }
            zzb(parcel, zza);
        } else if (z) {
            zza(parcel, i, 0);
        }
    }

    public static void writeBooleanObject(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i, @RecentlyNonNull Boolean bool, @RecentlyNonNull boolean z) {
        if (bool != null) {
            zza(parcel, i, 4);
            parcel.writeInt(bool.booleanValue() ? 1 : 0);
        } else if (z) {
            zza(parcel, i, 0);
        }
    }

    public static void writeBundle(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i, @RecentlyNonNull Bundle bundle, @RecentlyNonNull boolean z) {
        if (bundle != null) {
            int zza = zza(parcel, i);
            parcel.writeBundle(bundle);
            zzb(parcel, zza);
        } else if (z) {
            zza(parcel, i, 0);
        }
    }

    public static void writeByte(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i, @RecentlyNonNull byte b) {
        zza(parcel, i, 4);
        parcel.writeInt(b);
    }

    public static void writeByteArray(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i, @RecentlyNonNull byte[] bArr, @RecentlyNonNull boolean z) {
        if (bArr != null) {
            int zza = zza(parcel, i);
            parcel.writeByteArray(bArr);
            zzb(parcel, zza);
        } else if (z) {
            zza(parcel, i, 0);
        }
    }

    public static void writeByteArrayArray(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i, @RecentlyNonNull byte[][] bArr, @RecentlyNonNull boolean z) {
        if (bArr != null) {
            int zza = zza(parcel, i);
            int length = bArr.length;
            parcel.writeInt(length);
            for (byte[] bArr2 : bArr) {
                parcel.writeByteArray(bArr2);
            }
            zzb(parcel, zza);
        } else if (z) {
            zza(parcel, i, 0);
        }
    }

    public static void writeByteArraySparseArray(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i, @RecentlyNonNull SparseArray<byte[]> sparseArray, @RecentlyNonNull boolean z) {
        if (sparseArray != null) {
            int zza = zza(parcel, i);
            int size = sparseArray.size();
            parcel.writeInt(size);
            for (int i2 = 0; i2 < size; i2++) {
                parcel.writeInt(sparseArray.keyAt(i2));
                parcel.writeByteArray(sparseArray.valueAt(i2));
            }
            zzb(parcel, zza);
        } else if (z) {
            zza(parcel, i, 0);
        }
    }

    public static void writeChar(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i, @RecentlyNonNull char c) {
        zza(parcel, i, 4);
        parcel.writeInt(c);
    }

    public static void writeCharArray(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i, @RecentlyNonNull char[] cArr, @RecentlyNonNull boolean z) {
        if (cArr != null) {
            int zza = zza(parcel, i);
            parcel.writeCharArray(cArr);
            zzb(parcel, zza);
        } else if (z) {
            zza(parcel, i, 0);
        }
    }

    public static void writeDouble(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i, @RecentlyNonNull double d) {
        zza(parcel, i, 8);
        parcel.writeDouble(d);
    }

    public static void writeDoubleArray(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i, @RecentlyNonNull double[] dArr, @RecentlyNonNull boolean z) {
        if (dArr != null) {
            int zza = zza(parcel, i);
            parcel.writeDoubleArray(dArr);
            zzb(parcel, zza);
        } else if (z) {
            zza(parcel, i, 0);
        }
    }

    public static void writeDoubleList(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i, @RecentlyNonNull List<Double> list, @RecentlyNonNull boolean z) {
        if (list != null) {
            int zza = zza(parcel, i);
            int size = list.size();
            parcel.writeInt(size);
            for (int i2 = 0; i2 < size; i2++) {
                parcel.writeDouble(list.get(i2).doubleValue());
            }
            zzb(parcel, zza);
        } else if (z) {
            zza(parcel, i, 0);
        }
    }

    public static void writeDoubleObject(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i, @RecentlyNonNull Double d, @RecentlyNonNull boolean z) {
        if (d != null) {
            zza(parcel, i, 8);
            parcel.writeDouble(d.doubleValue());
        } else if (z) {
            zza(parcel, i, 0);
        }
    }

    public static void writeDoubleSparseArray(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i, @RecentlyNonNull SparseArray<Double> sparseArray, @RecentlyNonNull boolean z) {
        if (sparseArray != null) {
            int zza = zza(parcel, i);
            int size = sparseArray.size();
            parcel.writeInt(size);
            for (int i2 = 0; i2 < size; i2++) {
                parcel.writeInt(sparseArray.keyAt(i2));
                parcel.writeDouble(sparseArray.valueAt(i2).doubleValue());
            }
            zzb(parcel, zza);
        } else if (z) {
            zza(parcel, i, 0);
        }
    }

    public static void writeFloat(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i, @RecentlyNonNull float f) {
        zza(parcel, i, 4);
        parcel.writeFloat(f);
    }

    public static void writeFloatArray(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i, @RecentlyNonNull float[] fArr, @RecentlyNonNull boolean z) {
        if (fArr != null) {
            int zza = zza(parcel, i);
            parcel.writeFloatArray(fArr);
            zzb(parcel, zza);
        } else if (z) {
            zza(parcel, i, 0);
        }
    }

    public static void writeFloatList(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i, @RecentlyNonNull List<Float> list, @RecentlyNonNull boolean z) {
        if (list != null) {
            int zza = zza(parcel, i);
            int size = list.size();
            parcel.writeInt(size);
            for (int i2 = 0; i2 < size; i2++) {
                parcel.writeFloat(list.get(i2).floatValue());
            }
            zzb(parcel, zza);
        } else if (z) {
            zza(parcel, i, 0);
        }
    }

    public static void writeFloatObject(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i, @RecentlyNonNull Float f, @RecentlyNonNull boolean z) {
        if (f != null) {
            zza(parcel, i, 4);
            parcel.writeFloat(f.floatValue());
        } else if (z) {
            zza(parcel, i, 0);
        }
    }

    public static void writeFloatSparseArray(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i, @RecentlyNonNull SparseArray<Float> sparseArray, @RecentlyNonNull boolean z) {
        if (sparseArray != null) {
            int zza = zza(parcel, i);
            int size = sparseArray.size();
            parcel.writeInt(size);
            for (int i2 = 0; i2 < size; i2++) {
                parcel.writeInt(sparseArray.keyAt(i2));
                parcel.writeFloat(sparseArray.valueAt(i2).floatValue());
            }
            zzb(parcel, zza);
        } else if (z) {
            zza(parcel, i, 0);
        }
    }

    public static void writeIBinder(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i, @RecentlyNonNull IBinder iBinder, @RecentlyNonNull boolean z) {
        if (iBinder != null) {
            int zza = zza(parcel, i);
            parcel.writeStrongBinder(iBinder);
            zzb(parcel, zza);
        } else if (z) {
            zza(parcel, i, 0);
        }
    }

    public static void writeIBinderArray(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i, @RecentlyNonNull IBinder[] iBinderArr, @RecentlyNonNull boolean z) {
        if (iBinderArr != null) {
            int zza = zza(parcel, i);
            parcel.writeBinderArray(iBinderArr);
            zzb(parcel, zza);
        } else if (z) {
            zza(parcel, i, 0);
        }
    }

    public static void writeIBinderList(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i, @RecentlyNonNull List<IBinder> list, @RecentlyNonNull boolean z) {
        if (list != null) {
            int zza = zza(parcel, i);
            parcel.writeBinderList(list);
            zzb(parcel, zza);
        } else if (z) {
            zza(parcel, i, 0);
        }
    }

    public static void writeIBinderSparseArray(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i, @RecentlyNonNull SparseArray<IBinder> sparseArray, @RecentlyNonNull boolean z) {
        if (sparseArray != null) {
            int zza = zza(parcel, i);
            int size = sparseArray.size();
            parcel.writeInt(size);
            for (int i2 = 0; i2 < size; i2++) {
                parcel.writeInt(sparseArray.keyAt(i2));
                parcel.writeStrongBinder(sparseArray.valueAt(i2));
            }
            zzb(parcel, zza);
        } else if (z) {
            zza(parcel, i, 0);
        }
    }

    public static void writeInt(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i, @RecentlyNonNull int i2) {
        zza(parcel, i, 4);
        parcel.writeInt(i2);
    }

    public static void writeIntArray(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i, @RecentlyNonNull int[] iArr, @RecentlyNonNull boolean z) {
        if (iArr != null) {
            int zza = zza(parcel, i);
            parcel.writeIntArray(iArr);
            zzb(parcel, zza);
        } else if (z) {
            zza(parcel, i, 0);
        }
    }

    public static void writeIntegerList(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i, @RecentlyNonNull List<Integer> list, @RecentlyNonNull boolean z) {
        if (list != null) {
            int zza = zza(parcel, i);
            int size = list.size();
            parcel.writeInt(size);
            for (int i2 = 0; i2 < size; i2++) {
                parcel.writeInt(list.get(i2).intValue());
            }
            zzb(parcel, zza);
        } else if (z) {
            zza(parcel, i, 0);
        }
    }

    public static void writeIntegerObject(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i, @RecentlyNonNull Integer num, @RecentlyNonNull boolean z) {
        if (num != null) {
            zza(parcel, i, 4);
            parcel.writeInt(num.intValue());
        } else if (z) {
            zza(parcel, i, 0);
        }
    }

    public static void writeList(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i, @RecentlyNonNull List list, @RecentlyNonNull boolean z) {
        if (list != null) {
            int zza = zza(parcel, i);
            parcel.writeList(list);
            zzb(parcel, zza);
        } else if (z) {
            zza(parcel, i, 0);
        }
    }

    public static void writeLong(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i, @RecentlyNonNull long j) {
        zza(parcel, i, 8);
        parcel.writeLong(j);
    }

    public static void writeLongArray(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i, @RecentlyNonNull long[] jArr, @RecentlyNonNull boolean z) {
        if (jArr != null) {
            int zza = zza(parcel, i);
            parcel.writeLongArray(jArr);
            zzb(parcel, zza);
        } else if (z) {
            zza(parcel, i, 0);
        }
    }

    public static void writeLongList(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i, @RecentlyNonNull List<Long> list, @RecentlyNonNull boolean z) {
        if (list != null) {
            int zza = zza(parcel, i);
            int size = list.size();
            parcel.writeInt(size);
            for (int i2 = 0; i2 < size; i2++) {
                parcel.writeLong(list.get(i2).longValue());
            }
            zzb(parcel, zza);
        } else if (z) {
            zza(parcel, i, 0);
        }
    }

    public static void writeLongObject(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i, @RecentlyNonNull Long l, @RecentlyNonNull boolean z) {
        if (l != null) {
            zza(parcel, i, 8);
            parcel.writeLong(l.longValue());
        } else if (z) {
            zza(parcel, i, 0);
        }
    }

    public static void writeParcel(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i, @RecentlyNonNull Parcel parcel2, @RecentlyNonNull boolean z) {
        if (parcel2 != null) {
            int zza = zza(parcel, i);
            parcel.appendFrom(parcel2, 0, parcel2.dataSize());
            zzb(parcel, zza);
        } else if (z) {
            zza(parcel, i, 0);
        }
    }

    public static void writeParcelArray(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i, @RecentlyNonNull Parcel[] parcelArr, @RecentlyNonNull boolean z) {
        if (parcelArr != null) {
            int zza = zza(parcel, i);
            int length = parcelArr.length;
            parcel.writeInt(length);
            for (Parcel parcel2 : parcelArr) {
                if (parcel2 != null) {
                    parcel.writeInt(parcel2.dataSize());
                    parcel.appendFrom(parcel2, 0, parcel2.dataSize());
                } else {
                    parcel.writeInt(0);
                }
            }
            zzb(parcel, zza);
        } else if (z) {
            zza(parcel, i, 0);
        }
    }

    public static void writeParcelList(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i, @RecentlyNonNull List<Parcel> list, @RecentlyNonNull boolean z) {
        if (list != null) {
            int zza = zza(parcel, i);
            int size = list.size();
            parcel.writeInt(size);
            for (int i2 = 0; i2 < size; i2++) {
                Parcel parcel2 = list.get(i2);
                if (parcel2 != null) {
                    parcel.writeInt(parcel2.dataSize());
                    parcel.appendFrom(parcel2, 0, parcel2.dataSize());
                } else {
                    parcel.writeInt(0);
                }
            }
            zzb(parcel, zza);
        } else if (z) {
            zza(parcel, i, 0);
        }
    }

    public static void writeParcelSparseArray(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i, @RecentlyNonNull SparseArray<Parcel> sparseArray, @RecentlyNonNull boolean z) {
        if (sparseArray != null) {
            int zza = zza(parcel, i);
            int size = sparseArray.size();
            parcel.writeInt(size);
            for (int i2 = 0; i2 < size; i2++) {
                parcel.writeInt(sparseArray.keyAt(i2));
                Parcel valueAt = sparseArray.valueAt(i2);
                if (valueAt != null) {
                    parcel.writeInt(valueAt.dataSize());
                    parcel.appendFrom(valueAt, 0, valueAt.dataSize());
                } else {
                    parcel.writeInt(0);
                }
            }
            zzb(parcel, zza);
        } else if (z) {
            zza(parcel, i, 0);
        }
    }

    public static void writeParcelable(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i, @RecentlyNonNull Parcelable parcelable, @RecentlyNonNull int i2, @RecentlyNonNull boolean z) {
        if (parcelable != null) {
            int zza = zza(parcel, i);
            parcelable.writeToParcel(parcel, i2);
            zzb(parcel, zza);
        } else if (z) {
            zza(parcel, i, 0);
        }
    }

    public static void writeShort(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i, @RecentlyNonNull short s) {
        zza(parcel, i, 4);
        parcel.writeInt(s);
    }

    public static void writeSparseBooleanArray(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i, @RecentlyNonNull SparseBooleanArray sparseBooleanArray, @RecentlyNonNull boolean z) {
        if (sparseBooleanArray != null) {
            int zza = zza(parcel, i);
            parcel.writeSparseBooleanArray(sparseBooleanArray);
            zzb(parcel, zza);
        } else if (z) {
            zza(parcel, i, 0);
        }
    }

    public static void writeSparseIntArray(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i, @RecentlyNonNull SparseIntArray sparseIntArray, @RecentlyNonNull boolean z) {
        if (sparseIntArray != null) {
            int zza = zza(parcel, i);
            int size = sparseIntArray.size();
            parcel.writeInt(size);
            for (int i2 = 0; i2 < size; i2++) {
                parcel.writeInt(sparseIntArray.keyAt(i2));
                parcel.writeInt(sparseIntArray.valueAt(i2));
            }
            zzb(parcel, zza);
        } else if (z) {
            zza(parcel, i, 0);
        }
    }

    public static void writeSparseLongArray(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i, @RecentlyNonNull SparseLongArray sparseLongArray, @RecentlyNonNull boolean z) {
        if (sparseLongArray != null) {
            int zza = zza(parcel, i);
            int size = sparseLongArray.size();
            parcel.writeInt(size);
            for (int i2 = 0; i2 < size; i2++) {
                parcel.writeInt(sparseLongArray.keyAt(i2));
                parcel.writeLong(sparseLongArray.valueAt(i2));
            }
            zzb(parcel, zza);
        } else if (z) {
            zza(parcel, i, 0);
        }
    }

    public static void writeString(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i, @RecentlyNonNull String str, @RecentlyNonNull boolean z) {
        if (str != null) {
            int zza = zza(parcel, i);
            parcel.writeString(str);
            zzb(parcel, zza);
        } else if (z) {
            zza(parcel, i, 0);
        }
    }

    public static void writeStringArray(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i, @RecentlyNonNull String[] strArr, @RecentlyNonNull boolean z) {
        if (strArr != null) {
            int zza = zza(parcel, i);
            parcel.writeStringArray(strArr);
            zzb(parcel, zza);
        } else if (z) {
            zza(parcel, i, 0);
        }
    }

    public static void writeStringList(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i, @RecentlyNonNull List<String> list, @RecentlyNonNull boolean z) {
        if (list != null) {
            int zza = zza(parcel, i);
            parcel.writeStringList(list);
            zzb(parcel, zza);
        } else if (z) {
            zza(parcel, i, 0);
        }
    }

    public static void writeStringSparseArray(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i, @RecentlyNonNull SparseArray<String> sparseArray, @RecentlyNonNull boolean z) {
        if (sparseArray != null) {
            int zza = zza(parcel, i);
            int size = sparseArray.size();
            parcel.writeInt(size);
            for (int i2 = 0; i2 < size; i2++) {
                parcel.writeInt(sparseArray.keyAt(i2));
                parcel.writeString(sparseArray.valueAt(i2));
            }
            zzb(parcel, zza);
        } else if (z) {
            zza(parcel, i, 0);
        }
    }

    public static <T extends Parcelable> void writeTypedArray(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i, @RecentlyNonNull T[] tArr, @RecentlyNonNull int i2, @RecentlyNonNull boolean z) {
        if (tArr != null) {
            int zza = zza(parcel, i);
            int length = tArr.length;
            parcel.writeInt(length);
            for (T t : tArr) {
                if (t == null) {
                    parcel.writeInt(0);
                } else {
                    zza(parcel, t, i2);
                }
            }
            zzb(parcel, zza);
        } else if (z) {
            zza(parcel, i, 0);
        }
    }

    public static <T extends Parcelable> void writeTypedList(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i, @RecentlyNonNull List<T> list, @RecentlyNonNull boolean z) {
        if (list != null) {
            int zza = zza(parcel, i);
            int size = list.size();
            parcel.writeInt(size);
            for (int i2 = 0; i2 < size; i2++) {
                T t = list.get(i2);
                if (t == null) {
                    parcel.writeInt(0);
                } else {
                    zza(parcel, t, 0);
                }
            }
            zzb(parcel, zza);
        } else if (z) {
            zza(parcel, i, 0);
        }
    }

    public static <T extends Parcelable> void writeTypedSparseArray(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i, @RecentlyNonNull SparseArray<T> sparseArray, @RecentlyNonNull boolean z) {
        if (sparseArray != null) {
            int zza = zza(parcel, i);
            int size = sparseArray.size();
            parcel.writeInt(size);
            for (int i2 = 0; i2 < size; i2++) {
                parcel.writeInt(sparseArray.keyAt(i2));
                T valueAt = sparseArray.valueAt(i2);
                if (valueAt == null) {
                    parcel.writeInt(0);
                } else {
                    zza(parcel, valueAt, 0);
                }
            }
            zzb(parcel, zza);
        } else if (z) {
            zza(parcel, i, 0);
        }
    }

    private static void zza(Parcel parcel, int i, int i2) {
        if (i2 >= 65535) {
            parcel.writeInt(i | SupportMenu.CATEGORY_MASK);
            parcel.writeInt(i2);
            return;
        }
        parcel.writeInt(i | (i2 << 16));
    }

    private static void zzb(Parcel parcel, int i) {
        int dataPosition = parcel.dataPosition();
        parcel.setDataPosition(i - 4);
        parcel.writeInt(dataPosition - i);
        parcel.setDataPosition(dataPosition);
    }

    private static int zza(Parcel parcel, int i) {
        parcel.writeInt(i | SupportMenu.CATEGORY_MASK);
        parcel.writeInt(0);
        return parcel.dataPosition();
    }

    private static <T extends Parcelable> void zza(Parcel parcel, T t, int i) {
        int dataPosition = parcel.dataPosition();
        parcel.writeInt(1);
        int dataPosition2 = parcel.dataPosition();
        t.writeToParcel(parcel, i);
        int dataPosition3 = parcel.dataPosition();
        parcel.setDataPosition(dataPosition);
        parcel.writeInt(dataPosition3 - dataPosition2);
        parcel.setDataPosition(dataPosition3);
    }
}
