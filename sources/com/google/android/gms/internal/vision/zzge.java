package com.google.android.gms.internal.vision;

import a2.b.a.a.a;
import com.google.android.gms.internal.vision.zzge;
import com.google.android.gms.internal.vision.zzgh;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
public abstract class zzge<MessageType extends zzge<MessageType, BuilderType>, BuilderType extends zzgh<MessageType, BuilderType>> implements zzjn {
    public int zzte = 0;

    public static <T> void zza(Iterable<T> iterable, List<? super T> list) {
        zzie.checkNotNull(iterable);
        if (iterable instanceof zziu) {
            List<?> zzhs = ((zziu) iterable).zzhs();
            zziu zziu = (zziu) list;
            int size = list.size();
            for (Object obj : zzhs) {
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
                } else if (obj instanceof zzgs) {
                    zziu.zzc((zzgs) obj);
                } else {
                    zziu.add((String) obj);
                }
            }
        } else if (iterable instanceof zzjz) {
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

    public final byte[] toByteArray() {
        try {
            byte[] bArr = new byte[zzgz()];
            zzhl zze = zzhl.zze(bArr);
            zzb(zze);
            zze.zzgb();
            return bArr;
        } catch (IOException e) {
            String name = getClass().getName();
            StringBuilder K = a.K("byte array".length() + name.length() + 62, "Serializing ", name, " to a ", "byte array");
            K.append(" threw an IOException (should never happen).");
            throw new RuntimeException(K.toString(), e);
        }
    }

    public void zzak(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.internal.vision.zzjn
    public final zzgs zzee() {
        try {
            zzha zzaw = zzgs.zzaw(zzgz());
            zzb(zzaw.zzfq());
            return zzaw.zzfp();
        } catch (IOException e) {
            String name = getClass().getName();
            StringBuilder K = a.K("ByteString".length() + name.length() + 62, "Serializing ", name, " to a ", "ByteString");
            K.append(" threw an IOException (should never happen).");
            throw new RuntimeException(K.toString(), e);
        }
    }

    public int zzef() {
        throw new UnsupportedOperationException();
    }
}
