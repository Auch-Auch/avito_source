package org.spongycastle.pqc.crypto.xmss;

import java.io.Serializable;
import java.util.Map;
import java.util.TreeMap;
import org.spongycastle.pqc.crypto.xmss.OTSHashAddress;
import org.spongycastle.util.Integers;
public class BDSStateMap implements Serializable {
    public final Map<Integer, BDS> a = new TreeMap();

    public BDSStateMap() {
    }

    public final void a(XMSSMTParameters xMSSMTParameters, long j, byte[] bArr, byte[] bArr2) {
        XMSSParameters xMSSParameters = xMSSMTParameters.getXMSSParameters();
        int height = xMSSParameters.getHeight();
        long treeIndex = XMSSUtil.getTreeIndex(j, height);
        int leafIndex = XMSSUtil.getLeafIndex(j, height);
        OTSHashAddress oTSHashAddress = (OTSHashAddress) ((OTSHashAddress.Builder) new OTSHashAddress.Builder().withTreeAddress(treeIndex)).withOTSAddress(leafIndex).build();
        int i = (1 << height) - 1;
        if (leafIndex < i) {
            if (get(0) == null || leafIndex == 0) {
                BDS bds = new BDS(xMSSParameters.a, xMSSParameters.getHeight(), xMSSParameters.c);
                bds.a(bArr, bArr2, oTSHashAddress);
                put(0, bds);
            }
            update(0, bArr, bArr2, oTSHashAddress);
        }
        for (int i2 = 1; i2 < xMSSMTParameters.getLayers(); i2++) {
            int leafIndex2 = XMSSUtil.getLeafIndex(treeIndex, height);
            treeIndex = XMSSUtil.getTreeIndex(treeIndex, height);
            OTSHashAddress oTSHashAddress2 = (OTSHashAddress) ((OTSHashAddress.Builder) ((OTSHashAddress.Builder) new OTSHashAddress.Builder().withLayerAddress(i2)).withTreeAddress(treeIndex)).withOTSAddress(leafIndex2).build();
            if (leafIndex2 < i && XMSSUtil.isNewAuthenticationPathNeeded(j, height, i2)) {
                if (get(i2) == null) {
                    XMSSParameters xMSSParameters2 = xMSSMTParameters.getXMSSParameters();
                    BDS bds2 = new BDS(xMSSParameters2.a, xMSSParameters2.getHeight(), xMSSParameters2.c);
                    bds2.a(bArr, bArr2, oTSHashAddress2);
                    put(i2, bds2);
                }
                update(i2, bArr, bArr2, oTSHashAddress2);
            }
        }
    }

    public BDS get(int i) {
        return this.a.get(Integers.valueOf(i));
    }

    public boolean isEmpty() {
        return this.a.isEmpty();
    }

    public void put(int i, BDS bds) {
        this.a.put(Integers.valueOf(i), bds);
    }

    public BDS update(int i, byte[] bArr, byte[] bArr2, OTSHashAddress oTSHashAddress) {
        return this.a.put(Integers.valueOf(i), this.a.get(Integers.valueOf(i)).getNextState(bArr, bArr2, oTSHashAddress));
    }

    public BDSStateMap(XMSSMTParameters xMSSMTParameters, long j, byte[] bArr, byte[] bArr2) {
        for (long j2 = 0; j2 < j; j2++) {
            a(xMSSMTParameters, j2, bArr, bArr2);
        }
    }

    public BDSStateMap(BDSStateMap bDSStateMap, XMSSMTParameters xMSSMTParameters, long j, byte[] bArr, byte[] bArr2) {
        for (Integer num : bDSStateMap.a.keySet()) {
            this.a.put(num, bDSStateMap.a.get(num));
        }
        a(xMSSMTParameters, j, bArr, bArr2);
    }
}
