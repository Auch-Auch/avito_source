package com.google.android.gms.internal.measurement;

import a2.b.a.a.a;
import com.google.android.gms.internal.measurement.zzgi;
import com.google.android.gms.internal.measurement.zzgj;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
public abstract class zzgj<MessageType extends zzgj<MessageType, BuilderType>, BuilderType extends zzgi<MessageType, BuilderType>> implements zzjj {
    public int zza = 0;

    public static <T> void zza(Iterable<T> iterable, List<? super T> list) {
        zzie.zza(iterable);
        if (iterable instanceof zziu) {
            List<?> zzd = ((zziu) iterable).zzd();
            zziu zziu = (zziu) list;
            int size = list.size();
            for (Object obj : zzd) {
                if (obj == null) {
                    String o2 = a.o2(37, "Element at index ", zziu.size() - size, " is null.");
                    int size2 = zziu.size();
                    while (true) {
                        size2--;
                        if (size2 >= size) {
                            zziu.remove(size2);
                        } else {
                            throw new NullPointerException(o2);
                        }
                    }
                } else if (obj instanceof zzgt) {
                    zziu.zza((zzgt) obj);
                } else {
                    zziu.add((String) obj);
                }
            }
        } else if (iterable instanceof zzjv) {
            list.addAll((Collection) iterable);
        } else {
            if ((list instanceof ArrayList) && (iterable instanceof Collection)) {
                ((ArrayList) list).ensureCapacity(((Collection) iterable).size() + list.size());
            }
            int size3 = list.size();
            for (T t : iterable) {
                if (t == null) {
                    String o22 = a.o2(37, "Element at index ", list.size() - size3, " is null.");
                    int size4 = list.size();
                    while (true) {
                        size4--;
                        if (size4 >= size3) {
                            list.remove(size4);
                        } else {
                            throw new NullPointerException(o22);
                        }
                    }
                } else {
                    list.add(t);
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzjj
    public final zzgt zzbh() {
        try {
            zzhb zzc = zzgt.zzc(zzbm());
            zza(zzc.zzb());
            return zzc.zza();
        } catch (IOException e) {
            String name = getClass().getName();
            StringBuilder K = a.K("ByteString".length() + name.length() + 62, "Serializing ", name, " to a ", "ByteString");
            K.append(" threw an IOException (should never happen).");
            throw new RuntimeException(K.toString(), e);
        }
    }

    public final byte[] zzbi() {
        try {
            byte[] bArr = new byte[zzbm()];
            zzhi zza2 = zzhi.zza(bArr);
            zza(zza2);
            zza2.zzb();
            return bArr;
        } catch (IOException e) {
            String name = getClass().getName();
            StringBuilder K = a.K("byte array".length() + name.length() + 62, "Serializing ", name, " to a ", "byte array");
            K.append(" threw an IOException (should never happen).");
            throw new RuntimeException(K.toString(), e);
        }
    }

    public int zzbj() {
        throw new UnsupportedOperationException();
    }

    public void zzc(int i) {
        throw new UnsupportedOperationException();
    }
}
