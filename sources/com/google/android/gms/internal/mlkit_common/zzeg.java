package com.google.android.gms.internal.mlkit_common;

import a2.b.a.a.a;
import com.google.android.gms.internal.mlkit_common.zzeg;
import com.google.android.gms.internal.mlkit_common.zzej;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
public abstract class zzeg<MessageType extends zzeg<MessageType, BuilderType>, BuilderType extends zzej<MessageType, BuilderType>> implements zzhb {
    public int zza = 0;

    public void zza(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzhb
    public final zzep zze() {
        try {
            zzex zzc = zzep.zzc(zzj());
            zza(zzc.zzb());
            return zzc.zza();
        } catch (IOException e) {
            String name = getClass().getName();
            StringBuilder K = a.K("ByteString".length() + name.length() + 62, "Serializing ", name, " to a ", "ByteString");
            K.append(" threw an IOException (should never happen).");
            throw new RuntimeException(K.toString(), e);
        }
    }

    public final byte[] zzf() {
        try {
            byte[] bArr = new byte[zzj()];
            zzfc zza2 = zzfc.zza(bArr);
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

    public int zzg() {
        throw new UnsupportedOperationException();
    }

    public static <T> void zza(Iterable<T> iterable, List<? super T> list) {
        zzfs.zza(iterable);
        if (iterable instanceof zzgi) {
            List<?> zzb = ((zzgi) iterable).zzb();
            zzgi zzgi = (zzgi) list;
            int size = list.size();
            for (Object obj : zzb) {
                if (obj == null) {
                    String o2 = a.o2(37, "Element at index ", zzgi.size() - size, " is null.");
                    int size2 = zzgi.size();
                    while (true) {
                        size2--;
                        if (size2 >= size) {
                            zzgi.remove(size2);
                        } else {
                            throw new NullPointerException(o2);
                        }
                    }
                } else if (obj instanceof zzep) {
                    zzgi.zza((zzep) obj);
                } else {
                    zzgi.add((String) obj);
                }
            }
        } else if (iterable instanceof zzhk) {
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
}
