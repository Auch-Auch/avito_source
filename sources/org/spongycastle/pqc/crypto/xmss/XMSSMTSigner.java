package org.spongycastle.pqc.crypto.xmss;

import java.util.Objects;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.params.AsymmetricKeyParameter;
import org.spongycastle.pqc.crypto.StateAwareMessageSigner;
import org.spongycastle.pqc.crypto.xmss.OTSHashAddress;
import org.spongycastle.pqc.crypto.xmss.XMSSMTSignature;
import org.spongycastle.pqc.crypto.xmss.XMSSReducedSignature;
import org.spongycastle.util.Arrays;
import x6.e.f.a.d.c;
import x6.e.f.a.d.e;
import x6.e.f.a.d.g;
import x6.e.f.a.d.h;
public class XMSSMTSigner implements StateAwareMessageSigner {
    public XMSSMTPrivateKeyParameters a;
    public XMSSMTPrivateKeyParameters b;
    public XMSSMTPublicKeyParameters c;
    public XMSSMTParameters d;
    public XMSSParameters e;
    public c f;
    public boolean g;
    public boolean h;

    public final g a(byte[] bArr, OTSHashAddress oTSHashAddress) {
        if (bArr.length == this.d.getDigestSize()) {
            Objects.requireNonNull(oTSHashAddress, "otsHashAddress == null");
            c cVar = this.f;
            cVar.f(cVar.e(this.a.getSecretKeySeed(), oTSHashAddress), this.a.getPublicSeed());
            return this.f.g(bArr, oTSHashAddress);
        }
        throw new IllegalArgumentException("size of messageDigest needs to be equal to size of digest");
    }

    @Override // org.spongycastle.pqc.crypto.MessageSigner
    public byte[] generateSignature(byte[] bArr) {
        Objects.requireNonNull(bArr, "message == null");
        if (this.h) {
            XMSSMTPrivateKeyParameters xMSSMTPrivateKeyParameters = this.a;
            if (xMSSMTPrivateKeyParameters == null) {
                throw new IllegalStateException("signing key no longer usable");
            } else if (!xMSSMTPrivateKeyParameters.i.isEmpty()) {
                XMSSMTPrivateKeyParameters xMSSMTPrivateKeyParameters2 = this.a;
                BDSStateMap bDSStateMap = xMSSMTPrivateKeyParameters2.i;
                long index = xMSSMTPrivateKeyParameters2.getIndex();
                int height = this.d.getHeight();
                int height2 = this.e.getHeight();
                if (XMSSUtil.isIndexValid(height, index)) {
                    byte[] b2 = this.f.b.b(this.a.getSecretKeyPRF(), XMSSUtil.toBytesBigEndian(index, 32));
                    byte[] a3 = this.f.b.a(Arrays.concatenate(b2, this.a.getRoot(), XMSSUtil.toBytesBigEndian(index, this.d.getDigestSize())), bArr);
                    XMSSMTSignature build = new XMSSMTSignature.Builder(this.d).withIndex(index).withRandom(b2).build();
                    long treeIndex = XMSSUtil.getTreeIndex(index, height2);
                    int leafIndex = XMSSUtil.getLeafIndex(index, height2);
                    this.f.f(new byte[this.d.getDigestSize()], this.a.getPublicSeed());
                    OTSHashAddress oTSHashAddress = (OTSHashAddress) ((OTSHashAddress.Builder) new OTSHashAddress.Builder().withTreeAddress(treeIndex)).withOTSAddress(leafIndex).build();
                    if (bDSStateMap.get(0) == null || leafIndex == 0) {
                        bDSStateMap.put(0, new BDS(this.e, this.a.getPublicSeed(), this.a.getSecretKeySeed(), oTSHashAddress));
                    }
                    build.getReducedSignatures().add(new XMSSReducedSignature.Builder(this.e).withWOTSPlusSignature(a(a3, oTSHashAddress)).withAuthPath(bDSStateMap.get(0).getAuthenticationPath()).build());
                    for (int i = 1; i < this.d.getLayers(); i++) {
                        XMSSNode root = bDSStateMap.get(i - 1).getRoot();
                        int leafIndex2 = XMSSUtil.getLeafIndex(treeIndex, height2);
                        treeIndex = XMSSUtil.getTreeIndex(treeIndex, height2);
                        OTSHashAddress oTSHashAddress2 = (OTSHashAddress) ((OTSHashAddress.Builder) ((OTSHashAddress.Builder) new OTSHashAddress.Builder().withLayerAddress(i)).withTreeAddress(treeIndex)).withOTSAddress(leafIndex2).build();
                        g a4 = a(root.getValue(), oTSHashAddress2);
                        if (bDSStateMap.get(i) == null || XMSSUtil.isNewBDSInitNeeded(index, height2, i)) {
                            bDSStateMap.put(i, new BDS(this.e, this.a.getPublicSeed(), this.a.getSecretKeySeed(), oTSHashAddress2));
                        }
                        build.getReducedSignatures().add(new XMSSReducedSignature.Builder(this.e).withWOTSPlusSignature(a4).withAuthPath(bDSStateMap.get(i).getAuthenticationPath()).build());
                    }
                    this.g = true;
                    XMSSMTPrivateKeyParameters xMSSMTPrivateKeyParameters3 = this.b;
                    if (xMSSMTPrivateKeyParameters3 != null) {
                        XMSSMTPrivateKeyParameters nextKey = xMSSMTPrivateKeyParameters3.getNextKey();
                        this.a = nextKey;
                        this.b = nextKey;
                    } else {
                        this.a = null;
                    }
                    return build.toByteArray();
                }
                throw new IllegalStateException("index out of bounds");
            } else {
                throw new IllegalStateException("not initialized");
            }
        } else {
            throw new IllegalStateException("signer not initialized for signature generation");
        }
    }

    @Override // org.spongycastle.pqc.crypto.StateAwareMessageSigner
    public AsymmetricKeyParameter getUpdatedPrivateKey() {
        if (this.g) {
            XMSSMTPrivateKeyParameters xMSSMTPrivateKeyParameters = this.a;
            this.a = null;
            this.b = null;
            return xMSSMTPrivateKeyParameters;
        }
        XMSSMTPrivateKeyParameters nextKey = this.b.getNextKey();
        this.b = null;
        return nextKey;
    }

    @Override // org.spongycastle.pqc.crypto.MessageSigner
    public void init(boolean z, CipherParameters cipherParameters) {
        if (z) {
            this.h = true;
            this.g = false;
            XMSSMTPrivateKeyParameters xMSSMTPrivateKeyParameters = (XMSSMTPrivateKeyParameters) cipherParameters;
            this.a = xMSSMTPrivateKeyParameters;
            this.b = xMSSMTPrivateKeyParameters;
            XMSSMTParameters parameters = xMSSMTPrivateKeyParameters.getParameters();
            this.d = parameters;
            this.e = parameters.getXMSSParameters();
        } else {
            this.h = false;
            XMSSMTPublicKeyParameters xMSSMTPublicKeyParameters = (XMSSMTPublicKeyParameters) cipherParameters;
            this.c = xMSSMTPublicKeyParameters;
            XMSSMTParameters parameters2 = xMSSMTPublicKeyParameters.getParameters();
            this.d = parameters2;
            this.e = parameters2.getXMSSParameters();
        }
        this.f = new c(new e(this.d.getDigest()));
    }

    @Override // org.spongycastle.pqc.crypto.MessageSigner
    public boolean verifySignature(byte[] bArr, byte[] bArr2) {
        Objects.requireNonNull(bArr, "message == null");
        Objects.requireNonNull(bArr2, "signature == null");
        Objects.requireNonNull(this.c, "publicKey == null");
        XMSSMTSignature build = new XMSSMTSignature.Builder(this.d).withSignature(bArr2).build();
        byte[] a3 = this.f.b.a(Arrays.concatenate(build.getRandom(), this.c.getRoot(), XMSSUtil.toBytesBigEndian(build.getIndex(), this.d.getDigestSize())), bArr);
        long index = build.getIndex();
        int height = this.e.getHeight();
        long treeIndex = XMSSUtil.getTreeIndex(index, height);
        int leafIndex = XMSSUtil.getLeafIndex(index, height);
        this.f.f(new byte[this.d.getDigestSize()], this.c.getPublicSeed());
        OTSHashAddress oTSHashAddress = (OTSHashAddress) ((OTSHashAddress.Builder) new OTSHashAddress.Builder().withTreeAddress(treeIndex)).withOTSAddress(leafIndex).build();
        XMSSNode a4 = h.a(this.f, height, a3, build.getReducedSignatures().get(0), oTSHashAddress, leafIndex);
        int i = 1;
        while (i < this.d.getLayers()) {
            int leafIndex2 = XMSSUtil.getLeafIndex(treeIndex, height);
            long treeIndex2 = XMSSUtil.getTreeIndex(treeIndex, height);
            OTSHashAddress oTSHashAddress2 = (OTSHashAddress) ((OTSHashAddress.Builder) ((OTSHashAddress.Builder) new OTSHashAddress.Builder().withLayerAddress(i)).withTreeAddress(treeIndex2)).withOTSAddress(leafIndex2).build();
            a4 = h.a(this.f, height, a4.getValue(), build.getReducedSignatures().get(i), oTSHashAddress2, leafIndex2);
            i++;
            treeIndex = treeIndex2;
        }
        return Arrays.constantTimeAreEqual(a4.getValue(), this.c.getRoot());
    }
}
