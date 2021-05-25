package x6.e.f.a.d;

import a2.b.a.a.a;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.spongycastle.pqc.crypto.xmss.OTSHashAddress;
import org.spongycastle.pqc.crypto.xmss.XMSSUtil;
public final class c {
    public final e a;
    public final b b;
    public byte[] c;
    public byte[] d;

    public c(e eVar) {
        this.a = eVar;
        int i = eVar.c;
        this.b = new b(eVar.b, i);
        this.c = new byte[i];
        this.d = new byte[i];
    }

    public final byte[] a(byte[] bArr, int i, int i2, OTSHashAddress oTSHashAddress) {
        int i3 = this.a.c;
        Objects.requireNonNull(bArr, "startHash == null");
        if (bArr.length == i3) {
            Objects.requireNonNull(oTSHashAddress, "otsHashAddress == null");
            Objects.requireNonNull(oTSHashAddress.toByteArray(), "otsHashAddress byte array == null");
            int i4 = i + i2;
            if (i4 > this.a.d - 1) {
                throw new IllegalArgumentException("max chain length must not be greater than w");
            } else if (i2 == 0) {
                return bArr;
            } else {
                byte[] a3 = a(bArr, i, i2 - 1, oTSHashAddress);
                OTSHashAddress oTSHashAddress2 = (OTSHashAddress) ((OTSHashAddress.Builder) ((OTSHashAddress.Builder) ((OTSHashAddress.Builder) new OTSHashAddress.Builder().withLayerAddress(oTSHashAddress.getLayerAddress())).withTreeAddress(oTSHashAddress.getTreeAddress())).withOTSAddress(oTSHashAddress.e).withChainAddress(oTSHashAddress.f).withHashAddress(i4 - 1).withKeyAndMask(0)).build();
                byte[] b2 = this.b.b(this.d, oTSHashAddress2.toByteArray());
                byte[] b3 = this.b.b(this.d, ((OTSHashAddress) ((OTSHashAddress.Builder) ((OTSHashAddress.Builder) ((OTSHashAddress.Builder) new OTSHashAddress.Builder().withLayerAddress(oTSHashAddress2.getLayerAddress())).withTreeAddress(oTSHashAddress2.getTreeAddress())).withOTSAddress(oTSHashAddress2.e).withChainAddress(oTSHashAddress2.f).withHashAddress(oTSHashAddress2.g).withKeyAndMask(1)).build()).toByteArray());
                byte[] bArr2 = new byte[i3];
                for (int i5 = 0; i5 < i3; i5++) {
                    bArr2[i5] = (byte) (a3[i5] ^ b3[i5]);
                }
                b bVar = this.b;
                Objects.requireNonNull(bVar);
                int length = b2.length;
                int i6 = bVar.b;
                if (length != i6) {
                    throw new IllegalArgumentException("wrong key length");
                } else if (i3 == i6) {
                    return bVar.c(0, b2, bArr2);
                } else {
                    throw new IllegalArgumentException("wrong in length");
                }
            }
        } else {
            throw new IllegalArgumentException(a.Q2("startHash needs to be ", i3, "bytes"));
        }
    }

    public final List<Integer> b(byte[] bArr, int i, int i2) {
        Objects.requireNonNull(bArr, "msg == null");
        if (i == 4 || i == 16) {
            int log2 = XMSSUtil.log2(i);
            if (i2 <= (bArr.length * 8) / log2) {
                ArrayList arrayList = new ArrayList();
                for (int i3 = 0; i3 < bArr.length; i3++) {
                    for (int i4 = 8 - log2; i4 >= 0; i4 -= log2) {
                        arrayList.add(Integer.valueOf((bArr[i3] >> i4) & (i - 1)));
                        if (arrayList.size() == i2) {
                            return arrayList;
                        }
                    }
                }
                return arrayList;
            }
            throw new IllegalArgumentException("outLength too big");
        }
        throw new IllegalArgumentException("w needs to be 4 or 16");
    }

    public final byte[] c(int i) {
        if (i >= 0 && i < this.a.e) {
            return this.b.b(this.c, XMSSUtil.toBytesBigEndian((long) i, 32));
        }
        throw new IllegalArgumentException("index out of bounds");
    }

    public f d(OTSHashAddress oTSHashAddress) {
        byte[][] bArr = new byte[this.a.e][];
        int i = 0;
        while (true) {
            e eVar = this.a;
            if (i >= eVar.e) {
                return new f(eVar, bArr);
            }
            oTSHashAddress = (OTSHashAddress) ((OTSHashAddress.Builder) ((OTSHashAddress.Builder) ((OTSHashAddress.Builder) new OTSHashAddress.Builder().withLayerAddress(oTSHashAddress.getLayerAddress())).withTreeAddress(oTSHashAddress.getTreeAddress())).withOTSAddress(oTSHashAddress.e).withChainAddress(i).withHashAddress(oTSHashAddress.g).withKeyAndMask(oTSHashAddress.getKeyAndMask())).build();
            bArr[i] = a(c(i), 0, this.a.d - 1, oTSHashAddress);
            i++;
        }
    }

    public byte[] e(byte[] bArr, OTSHashAddress oTSHashAddress) {
        return this.b.b(bArr, ((OTSHashAddress) ((OTSHashAddress.Builder) ((OTSHashAddress.Builder) new OTSHashAddress.Builder().withLayerAddress(oTSHashAddress.getLayerAddress())).withTreeAddress(oTSHashAddress.getTreeAddress())).withOTSAddress(oTSHashAddress.e).build()).toByteArray());
    }

    public void f(byte[] bArr, byte[] bArr2) {
        int length = bArr.length;
        int i = this.a.c;
        if (length == i) {
            Objects.requireNonNull(bArr2, "publicSeed == null");
            if (bArr2.length == i) {
                this.c = bArr;
                this.d = bArr2;
                return;
            }
            throw new IllegalArgumentException("size of publicSeed needs to be equal to size of digest");
        }
        throw new IllegalArgumentException("size of secretKeySeed needs to be equal to size of digest");
    }

    public g g(byte[] bArr, OTSHashAddress oTSHashAddress) {
        e eVar;
        int length = bArr.length;
        e eVar2 = this.a;
        if (length == eVar2.c) {
            List<Integer> b2 = b(bArr, eVar2.d, eVar2.f);
            int i = 0;
            int i2 = 0;
            while (true) {
                eVar = this.a;
                if (i >= eVar.f) {
                    break;
                }
                i2 += (eVar.d - 1) - ((Integer) ((ArrayList) b2).get(i)).intValue();
                i++;
            }
            int log2 = i2 << (8 - ((XMSSUtil.log2(eVar.d) * eVar.g) % 8));
            e eVar3 = this.a;
            long j = (long) log2;
            byte[] bytesBigEndian = XMSSUtil.toBytesBigEndian(j, (int) Math.ceil(((double) (XMSSUtil.log2(eVar3.d) * eVar3.g)) / 8.0d));
            e eVar4 = this.a;
            ArrayList arrayList = (ArrayList) b2;
            arrayList.addAll(b(bytesBigEndian, eVar4.d, eVar4.g));
            byte[][] bArr2 = new byte[this.a.e][];
            int i3 = 0;
            while (true) {
                e eVar5 = this.a;
                if (i3 >= eVar5.e) {
                    return new g(eVar5, bArr2);
                }
                oTSHashAddress = (OTSHashAddress) ((OTSHashAddress.Builder) ((OTSHashAddress.Builder) ((OTSHashAddress.Builder) new OTSHashAddress.Builder().withLayerAddress(oTSHashAddress.getLayerAddress())).withTreeAddress(oTSHashAddress.getTreeAddress())).withOTSAddress(oTSHashAddress.e).withChainAddress(i3).withHashAddress(oTSHashAddress.g).withKeyAndMask(oTSHashAddress.getKeyAndMask())).build();
                bArr2[i3] = a(c(i3), 0, ((Integer) arrayList.get(i3)).intValue(), oTSHashAddress);
                i3++;
            }
        } else {
            throw new IllegalArgumentException("size of messageDigest needs to be equal to size of digest");
        }
    }
}
