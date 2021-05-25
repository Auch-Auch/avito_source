package com.google.android.gms.internal.ads;

import a2.b.a.a.a;
import com.google.android.gms.internal.ads.zzeeu;
import com.google.android.gms.internal.ads.zzeev;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
public abstract class zzeev<MessageType extends zzeev<MessageType, BuilderType>, BuilderType extends zzeeu<MessageType, BuilderType>> implements zzehz {
    public int zziaq = 0;

    public static <T> void zza(Iterable<T> iterable, List<? super T> list) {
        zzegr.checkNotNull(iterable);
        if (iterable instanceof zzehk) {
            List<?> zzbgn = ((zzehk) iterable).zzbgn();
            zzehk zzehk = (zzehk) list;
            int size = list.size();
            for (Object obj : zzbgn) {
                if (obj == null) {
                    String o2 = a.o2(37, "Element at index ", zzehk.size() - size, " is null.");
                    int size2 = zzehk.size();
                    while (true) {
                        size2--;
                        if (size2 >= size) {
                            zzehk.remove(size2);
                        } else {
                            throw new NullPointerException(o2);
                        }
                    }
                } else if (obj instanceof zzeff) {
                    zzehk.zzaj((zzeff) obj);
                } else {
                    zzehk.add((String) obj);
                }
            }
        } else if (iterable instanceof zzeil) {
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

    @Override // com.google.android.gms.internal.ads.zzehz
    public final byte[] toByteArray() {
        try {
            byte[] bArr = new byte[zzbfl()];
            zzefz zzw = zzefz.zzw(bArr);
            zzb(zzw);
            zzw.zzbeu();
            return bArr;
        } catch (IOException e) {
            String name = getClass().getName();
            StringBuilder K = a.K("byte array".length() + name.length() + 62, "Serializing ", name, " to a ", "byte array");
            K.append(" threw an IOException (should never happen).");
            throw new RuntimeException(K.toString(), e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzehz
    public final zzeff zzbda() {
        try {
            zzefn zzfw = zzeff.zzfw(zzbfl());
            zzb(zzfw.zzbds());
            return zzfw.zzbdr();
        } catch (IOException e) {
            String name = getClass().getName();
            StringBuilder K = a.K("ByteString".length() + name.length() + 62, "Serializing ", name, " to a ", "ByteString");
            K.append(" threw an IOException (should never happen).");
            throw new RuntimeException(K.toString(), e);
        }
    }

    public int zzbdb() {
        throw new UnsupportedOperationException();
    }

    public void zzfq(int i) {
        throw new UnsupportedOperationException();
    }
}
