package x6.e.f.a.d;

import androidx.appcompat.app.AppCompatDelegateImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.spongycastle.pqc.crypto.xmss.HashTreeAddress;
import org.spongycastle.pqc.crypto.xmss.LTreeAddress;
import org.spongycastle.pqc.crypto.xmss.OTSHashAddress;
import org.spongycastle.pqc.crypto.xmss.XMSSNode;
import org.spongycastle.pqc.crypto.xmss.XMSSReducedSignature;
import org.spongycastle.pqc.crypto.xmss.XMSSUtil;
public class h {
    public static XMSSNode a(c cVar, int i, byte[] bArr, XMSSReducedSignature xMSSReducedSignature, OTSHashAddress oTSHashAddress, int i2) {
        e eVar;
        e eVar2;
        HashTreeAddress hashTreeAddress;
        if (bArr.length == cVar.a.c) {
            Objects.requireNonNull(xMSSReducedSignature, "signature == null");
            Objects.requireNonNull(oTSHashAddress, "otsHashAddress == null");
            LTreeAddress lTreeAddress = (LTreeAddress) ((LTreeAddress.Builder) ((LTreeAddress.Builder) new LTreeAddress.Builder().withLayerAddress(oTSHashAddress.getLayerAddress())).withTreeAddress(oTSHashAddress.getTreeAddress())).withLTreeAddress(oTSHashAddress.e).build();
            HashTreeAddress hashTreeAddress2 = (HashTreeAddress) ((HashTreeAddress.Builder) ((HashTreeAddress.Builder) new HashTreeAddress.Builder().withLayerAddress(oTSHashAddress.getLayerAddress())).withTreeAddress(oTSHashAddress.getTreeAddress())).withTreeIndex(oTSHashAddress.e).build();
            g wOTSPlusSignature = xMSSReducedSignature.getWOTSPlusSignature();
            int length = bArr.length;
            e eVar3 = cVar.a;
            if (length == eVar3.c) {
                Objects.requireNonNull(wOTSPlusSignature, "signature == null");
                List<Integer> b = cVar.b(bArr, eVar3.d, eVar3.f);
                int i3 = 0;
                int i4 = 0;
                while (true) {
                    eVar = cVar.a;
                    if (i3 >= eVar.f) {
                        break;
                    }
                    i4 += (eVar.d - 1) - ((Integer) ((ArrayList) b).get(i3)).intValue();
                    i3++;
                }
                int log2 = i4 << (8 - ((XMSSUtil.log2(eVar.d) * eVar.g) % 8));
                e eVar4 = cVar.a;
                long j = (long) log2;
                byte[] bytesBigEndian = XMSSUtil.toBytesBigEndian(j, (int) Math.ceil(((double) (XMSSUtil.log2(eVar4.d) * eVar4.g)) / 8.0d));
                e eVar5 = cVar.a;
                ArrayList arrayList = (ArrayList) b;
                arrayList.addAll(cVar.b(bytesBigEndian, eVar5.d, eVar5.g));
                byte[][] bArr2 = new byte[cVar.a.e][];
                int i5 = 0;
                while (true) {
                    eVar2 = cVar.a;
                    if (i5 >= eVar2.e) {
                        break;
                    }
                    oTSHashAddress = (OTSHashAddress) ((OTSHashAddress.Builder) ((OTSHashAddress.Builder) ((OTSHashAddress.Builder) new OTSHashAddress.Builder().withLayerAddress(oTSHashAddress.getLayerAddress())).withTreeAddress(oTSHashAddress.getTreeAddress())).withOTSAddress(oTSHashAddress.e).withChainAddress(i5).withHashAddress(oTSHashAddress.g).withKeyAndMask(oTSHashAddress.getKeyAndMask())).build();
                    bArr2[i5] = cVar.a(wOTSPlusSignature.a()[i5], ((Integer) arrayList.get(i5)).intValue(), (cVar.a.d - 1) - ((Integer) arrayList.get(i5)).intValue(), oTSHashAddress);
                    i5++;
                }
                f fVar = new f(eVar2, bArr2);
                XMSSNode[] xMSSNodeArr = new XMSSNode[2];
                xMSSNodeArr[0] = AppCompatDelegateImpl.i.d1(cVar, fVar, lTreeAddress);
                int i6 = 0;
                while (i6 < i) {
                    HashTreeAddress hashTreeAddress3 = (HashTreeAddress) ((HashTreeAddress.Builder) ((HashTreeAddress.Builder) ((HashTreeAddress.Builder) new HashTreeAddress.Builder().withLayerAddress(hashTreeAddress2.getLayerAddress())).withTreeAddress(hashTreeAddress2.getTreeAddress())).withTreeHeight(i6).withTreeIndex(hashTreeAddress2.f).withKeyAndMask(hashTreeAddress2.getKeyAndMask())).build();
                    if (Math.floor((double) (i2 / (1 << i6))) % 2.0d == 0.0d) {
                        hashTreeAddress = (HashTreeAddress) ((HashTreeAddress.Builder) ((HashTreeAddress.Builder) ((HashTreeAddress.Builder) new HashTreeAddress.Builder().withLayerAddress(hashTreeAddress3.getLayerAddress())).withTreeAddress(hashTreeAddress3.getTreeAddress())).withTreeHeight(hashTreeAddress3.e).withTreeIndex(hashTreeAddress3.f / 2).withKeyAndMask(hashTreeAddress3.getKeyAndMask())).build();
                        xMSSNodeArr[1] = AppCompatDelegateImpl.i.H1(cVar, xMSSNodeArr[0], xMSSReducedSignature.getAuthPath().get(i6), hashTreeAddress);
                        xMSSNodeArr[1] = new XMSSNode(xMSSNodeArr[1].getHeight() + 1, xMSSNodeArr[1].getValue());
                    } else {
                        hashTreeAddress = (HashTreeAddress) ((HashTreeAddress.Builder) ((HashTreeAddress.Builder) ((HashTreeAddress.Builder) new HashTreeAddress.Builder().withLayerAddress(hashTreeAddress3.getLayerAddress())).withTreeAddress(hashTreeAddress3.getTreeAddress())).withTreeHeight(hashTreeAddress3.e).withTreeIndex((hashTreeAddress3.f - 1) / 2).withKeyAndMask(hashTreeAddress3.getKeyAndMask())).build();
                        xMSSNodeArr[1] = AppCompatDelegateImpl.i.H1(cVar, xMSSReducedSignature.getAuthPath().get(i6), xMSSNodeArr[0], hashTreeAddress);
                        xMSSNodeArr[1] = new XMSSNode(xMSSNodeArr[1].getHeight() + 1, xMSSNodeArr[1].getValue());
                    }
                    xMSSNodeArr[0] = xMSSNodeArr[1];
                    i6++;
                    hashTreeAddress2 = hashTreeAddress;
                }
                return xMSSNodeArr[0];
            }
            throw new IllegalArgumentException("size of messageDigest needs to be equal to size of digest");
        }
        throw new IllegalArgumentException("size of messageDigest needs to be equal to size of digest");
    }
}
