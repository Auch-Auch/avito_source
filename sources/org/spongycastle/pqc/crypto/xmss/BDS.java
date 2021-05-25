package org.spongycastle.pqc.crypto.xmss;

import androidx.appcompat.app.AppCompatDelegateImpl;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Stack;
import java.util.TreeMap;
import org.spongycastle.pqc.crypto.xmss.HashTreeAddress;
import org.spongycastle.pqc.crypto.xmss.LTreeAddress;
import org.spongycastle.pqc.crypto.xmss.OTSHashAddress;
import x6.e.f.a.d.a;
import x6.e.f.a.d.c;
import x6.e.f.a.d.f;
public final class BDS implements Serializable {
    private static final long serialVersionUID = 1;
    public transient c a;
    public final int b;
    public final List<a> c;
    public int d;
    public XMSSNode e;
    public List<XMSSNode> f;
    public Map<Integer, LinkedList<XMSSNode>> g;
    public Stack<XMSSNode> h;
    public Map<Integer, XMSSNode> i;
    public int j;
    public boolean k;

    public BDS(c cVar, int i2, int i3) {
        this.a = cVar;
        this.b = i2;
        this.d = i3;
        if (i3 <= i2 && i3 >= 2) {
            int i4 = i2 - i3;
            if (i4 % 2 == 0) {
                this.f = new ArrayList();
                this.g = new TreeMap();
                this.h = new Stack<>();
                this.c = new ArrayList();
                for (int i5 = 0; i5 < i4; i5++) {
                    this.c.add(new a(i5));
                }
                this.i = new TreeMap();
                this.j = 0;
                this.k = false;
                return;
            }
        }
        throw new IllegalArgumentException("illegal value for BDS parameter k");
    }

    public final void a(byte[] bArr, byte[] bArr2, OTSHashAddress oTSHashAddress) {
        Objects.requireNonNull(oTSHashAddress, "otsHashAddress == null");
        LTreeAddress lTreeAddress = (LTreeAddress) ((LTreeAddress.Builder) ((LTreeAddress.Builder) new LTreeAddress.Builder().withLayerAddress(oTSHashAddress.getLayerAddress())).withTreeAddress(oTSHashAddress.getTreeAddress())).build();
        HashTreeAddress hashTreeAddress = (HashTreeAddress) ((HashTreeAddress.Builder) ((HashTreeAddress.Builder) new HashTreeAddress.Builder().withLayerAddress(oTSHashAddress.getLayerAddress())).withTreeAddress(oTSHashAddress.getTreeAddress())).build();
        for (int i2 = 0; i2 < (1 << this.b); i2++) {
            oTSHashAddress = (OTSHashAddress) ((OTSHashAddress.Builder) ((OTSHashAddress.Builder) ((OTSHashAddress.Builder) new OTSHashAddress.Builder().withLayerAddress(oTSHashAddress.getLayerAddress())).withTreeAddress(oTSHashAddress.getTreeAddress())).withOTSAddress(i2).withChainAddress(oTSHashAddress.f).withHashAddress(oTSHashAddress.g).withKeyAndMask(oTSHashAddress.getKeyAndMask())).build();
            c cVar = this.a;
            cVar.f(cVar.e(bArr2, oTSHashAddress), bArr);
            f d2 = this.a.d(oTSHashAddress);
            lTreeAddress = (LTreeAddress) ((LTreeAddress.Builder) ((LTreeAddress.Builder) ((LTreeAddress.Builder) new LTreeAddress.Builder().withLayerAddress(lTreeAddress.getLayerAddress())).withTreeAddress(lTreeAddress.getTreeAddress())).withLTreeAddress(i2).withTreeHeight(lTreeAddress.f).withTreeIndex(lTreeAddress.g).withKeyAndMask(lTreeAddress.getKeyAndMask())).build();
            XMSSNode d1 = AppCompatDelegateImpl.i.d1(this.a, d2, lTreeAddress);
            hashTreeAddress = (HashTreeAddress) ((HashTreeAddress.Builder) ((HashTreeAddress.Builder) ((HashTreeAddress.Builder) new HashTreeAddress.Builder().withLayerAddress(hashTreeAddress.getLayerAddress())).withTreeAddress(hashTreeAddress.getTreeAddress())).withTreeIndex(i2).withKeyAndMask(hashTreeAddress.getKeyAndMask())).build();
            while (!this.h.isEmpty() && this.h.peek().getHeight() == d1.getHeight()) {
                int floor = (int) Math.floor((double) (i2 / (1 << d1.getHeight())));
                if (floor == 1) {
                    this.f.add(d1.clone());
                }
                if (floor == 3 && d1.getHeight() < this.b - this.d) {
                    a aVar = this.c.get(d1.getHeight());
                    XMSSNode clone = d1.clone();
                    aVar.a = clone;
                    int height = clone.getHeight();
                    aVar.c = height;
                    if (height == aVar.b) {
                        aVar.f = true;
                    }
                }
                if (floor >= 3 && (floor & 1) == 1 && d1.getHeight() >= this.b - this.d && d1.getHeight() <= this.b - 2) {
                    if (this.g.get(Integer.valueOf(d1.getHeight())) == null) {
                        LinkedList<XMSSNode> linkedList = new LinkedList<>();
                        linkedList.add(d1.clone());
                        this.g.put(Integer.valueOf(d1.getHeight()), linkedList);
                    } else {
                        this.g.get(Integer.valueOf(d1.getHeight())).add(d1.clone());
                    }
                }
                HashTreeAddress hashTreeAddress2 = (HashTreeAddress) ((HashTreeAddress.Builder) ((HashTreeAddress.Builder) ((HashTreeAddress.Builder) new HashTreeAddress.Builder().withLayerAddress(hashTreeAddress.getLayerAddress())).withTreeAddress(hashTreeAddress.getTreeAddress())).withTreeHeight(hashTreeAddress.e).withTreeIndex((hashTreeAddress.f - 1) / 2).withKeyAndMask(hashTreeAddress.getKeyAndMask())).build();
                XMSSNode H1 = AppCompatDelegateImpl.i.H1(this.a, this.h.pop(), d1, hashTreeAddress2);
                XMSSNode xMSSNode = new XMSSNode(H1.getHeight() + 1, H1.getValue());
                hashTreeAddress = (HashTreeAddress) ((HashTreeAddress.Builder) ((HashTreeAddress.Builder) ((HashTreeAddress.Builder) new HashTreeAddress.Builder().withLayerAddress(hashTreeAddress2.getLayerAddress())).withTreeAddress(hashTreeAddress2.getTreeAddress())).withTreeHeight(hashTreeAddress2.e + 1).withTreeIndex(hashTreeAddress2.f).withKeyAndMask(hashTreeAddress2.getKeyAndMask())).build();
                d1 = xMSSNode;
            }
            this.h.push(d1);
        }
        this.e = this.h.pop();
    }

    public final void b(byte[] bArr, byte[] bArr2, OTSHashAddress oTSHashAddress) {
        Objects.requireNonNull(oTSHashAddress, "otsHashAddress == null");
        if (this.k) {
            throw new IllegalStateException("index already used");
        } else if (this.j <= (1 << this.b) - 2) {
            LTreeAddress lTreeAddress = (LTreeAddress) ((LTreeAddress.Builder) ((LTreeAddress.Builder) new LTreeAddress.Builder().withLayerAddress(oTSHashAddress.getLayerAddress())).withTreeAddress(oTSHashAddress.getTreeAddress())).build();
            HashTreeAddress hashTreeAddress = (HashTreeAddress) ((HashTreeAddress.Builder) ((HashTreeAddress.Builder) new HashTreeAddress.Builder().withLayerAddress(oTSHashAddress.getLayerAddress())).withTreeAddress(oTSHashAddress.getTreeAddress())).build();
            int calculateTau = XMSSUtil.calculateTau(this.j, this.b);
            if (((this.j >> (calculateTau + 1)) & 1) == 0 && calculateTau < this.b - 1) {
                this.i.put(Integer.valueOf(calculateTau), this.f.get(calculateTau).clone());
            }
            if (calculateTau == 0) {
                oTSHashAddress = (OTSHashAddress) ((OTSHashAddress.Builder) ((OTSHashAddress.Builder) ((OTSHashAddress.Builder) new OTSHashAddress.Builder().withLayerAddress(oTSHashAddress.getLayerAddress())).withTreeAddress(oTSHashAddress.getTreeAddress())).withOTSAddress(this.j).withChainAddress(oTSHashAddress.f).withHashAddress(oTSHashAddress.g).withKeyAndMask(oTSHashAddress.getKeyAndMask())).build();
                c cVar = this.a;
                cVar.f(cVar.e(bArr2, oTSHashAddress), bArr);
                this.f.set(0, AppCompatDelegateImpl.i.d1(this.a, this.a.d(oTSHashAddress), (LTreeAddress) ((LTreeAddress.Builder) ((LTreeAddress.Builder) ((LTreeAddress.Builder) new LTreeAddress.Builder().withLayerAddress(lTreeAddress.getLayerAddress())).withTreeAddress(lTreeAddress.getTreeAddress())).withLTreeAddress(this.j).withTreeHeight(lTreeAddress.f).withTreeIndex(lTreeAddress.g).withKeyAndMask(lTreeAddress.getKeyAndMask())).build()));
            } else {
                int i2 = calculateTau - 1;
                XMSSNode H1 = AppCompatDelegateImpl.i.H1(this.a, this.f.get(i2), this.i.get(Integer.valueOf(i2)), (HashTreeAddress) ((HashTreeAddress.Builder) ((HashTreeAddress.Builder) ((HashTreeAddress.Builder) new HashTreeAddress.Builder().withLayerAddress(hashTreeAddress.getLayerAddress())).withTreeAddress(hashTreeAddress.getTreeAddress())).withTreeHeight(i2).withTreeIndex(this.j >> calculateTau).withKeyAndMask(hashTreeAddress.getKeyAndMask())).build());
                this.f.set(calculateTau, new XMSSNode(H1.getHeight() + 1, H1.getValue()));
                this.i.remove(Integer.valueOf(i2));
                for (int i3 = 0; i3 < calculateTau; i3++) {
                    if (i3 < this.b - this.d) {
                        this.f.set(i3, this.c.get(i3).a.clone());
                    } else {
                        this.f.set(i3, this.g.get(Integer.valueOf(i3)).removeFirst());
                    }
                }
                int min = Math.min(calculateTau, this.b - this.d);
                for (int i4 = 0; i4 < min; i4++) {
                    int i5 = ((1 << i4) * 3) + this.j + 1;
                    if (i5 < (1 << this.b)) {
                        a aVar = this.c.get(i4);
                        aVar.a = null;
                        aVar.c = aVar.b;
                        aVar.d = i5;
                        aVar.e = true;
                        aVar.f = false;
                    }
                }
            }
            for (int i6 = 0; i6 < ((this.b - this.d) >> 1); i6++) {
                a aVar2 = null;
                for (a aVar3 : this.c) {
                    if (!aVar3.f && aVar3.e) {
                        if (aVar2 == null || aVar3.a() < aVar2.a() || (aVar3.a() == aVar2.a() && aVar3.d < aVar2.d)) {
                            aVar2 = aVar3;
                        }
                    }
                }
                if (aVar2 != null) {
                    Stack<XMSSNode> stack = this.h;
                    c cVar2 = this.a;
                    if (aVar2.f || !aVar2.e) {
                        throw new IllegalStateException("finished or not initialized");
                    }
                    OTSHashAddress oTSHashAddress2 = (OTSHashAddress) ((OTSHashAddress.Builder) ((OTSHashAddress.Builder) ((OTSHashAddress.Builder) new OTSHashAddress.Builder().withLayerAddress(oTSHashAddress.getLayerAddress())).withTreeAddress(oTSHashAddress.getTreeAddress())).withOTSAddress(aVar2.d).withChainAddress(oTSHashAddress.f).withHashAddress(oTSHashAddress.g).withKeyAndMask(oTSHashAddress.getKeyAndMask())).build();
                    HashTreeAddress hashTreeAddress2 = (HashTreeAddress) ((HashTreeAddress.Builder) ((HashTreeAddress.Builder) new HashTreeAddress.Builder().withLayerAddress(oTSHashAddress2.getLayerAddress())).withTreeAddress(oTSHashAddress2.getTreeAddress())).withTreeIndex(aVar2.d).build();
                    cVar2.f(cVar2.e(bArr2, oTSHashAddress2), bArr);
                    XMSSNode d1 = AppCompatDelegateImpl.i.d1(cVar2, cVar2.d(oTSHashAddress2), (LTreeAddress) ((LTreeAddress.Builder) ((LTreeAddress.Builder) new LTreeAddress.Builder().withLayerAddress(oTSHashAddress2.getLayerAddress())).withTreeAddress(oTSHashAddress2.getTreeAddress())).withLTreeAddress(aVar2.d).build());
                    while (!stack.isEmpty() && stack.peek().getHeight() == d1.getHeight() && stack.peek().getHeight() != aVar2.b) {
                        HashTreeAddress hashTreeAddress3 = (HashTreeAddress) ((HashTreeAddress.Builder) ((HashTreeAddress.Builder) ((HashTreeAddress.Builder) new HashTreeAddress.Builder().withLayerAddress(hashTreeAddress2.getLayerAddress())).withTreeAddress(hashTreeAddress2.getTreeAddress())).withTreeHeight(hashTreeAddress2.e).withTreeIndex((hashTreeAddress2.f - 1) / 2).withKeyAndMask(hashTreeAddress2.getKeyAndMask())).build();
                        XMSSNode H12 = AppCompatDelegateImpl.i.H1(cVar2, stack.pop(), d1, hashTreeAddress3);
                        XMSSNode xMSSNode = new XMSSNode(H12.getHeight() + 1, H12.getValue());
                        hashTreeAddress2 = (HashTreeAddress) ((HashTreeAddress.Builder) ((HashTreeAddress.Builder) ((HashTreeAddress.Builder) new HashTreeAddress.Builder().withLayerAddress(hashTreeAddress3.getLayerAddress())).withTreeAddress(hashTreeAddress3.getTreeAddress())).withTreeHeight(hashTreeAddress3.e + 1).withTreeIndex(hashTreeAddress3.f).withKeyAndMask(hashTreeAddress3.getKeyAndMask())).build();
                        d1 = xMSSNode;
                    }
                    XMSSNode xMSSNode2 = aVar2.a;
                    if (xMSSNode2 == null) {
                        aVar2.a = d1;
                    } else if (xMSSNode2.getHeight() == d1.getHeight()) {
                        HashTreeAddress hashTreeAddress4 = (HashTreeAddress) ((HashTreeAddress.Builder) ((HashTreeAddress.Builder) ((HashTreeAddress.Builder) new HashTreeAddress.Builder().withLayerAddress(hashTreeAddress2.getLayerAddress())).withTreeAddress(hashTreeAddress2.getTreeAddress())).withTreeHeight(hashTreeAddress2.e).withTreeIndex((hashTreeAddress2.f - 1) / 2).withKeyAndMask(hashTreeAddress2.getKeyAndMask())).build();
                        d1 = new XMSSNode(aVar2.a.getHeight() + 1, AppCompatDelegateImpl.i.H1(cVar2, aVar2.a, d1, hashTreeAddress4).getValue());
                        aVar2.a = d1;
                        HashTreeAddress hashTreeAddress5 = (HashTreeAddress) ((HashTreeAddress.Builder) ((HashTreeAddress.Builder) ((HashTreeAddress.Builder) new HashTreeAddress.Builder().withLayerAddress(hashTreeAddress4.getLayerAddress())).withTreeAddress(hashTreeAddress4.getTreeAddress())).withTreeHeight(hashTreeAddress4.e + 1).withTreeIndex(hashTreeAddress4.f).withKeyAndMask(hashTreeAddress4.getKeyAndMask())).build();
                    } else {
                        stack.push(d1);
                    }
                    if (aVar2.a.getHeight() == aVar2.b) {
                        aVar2.f = true;
                    } else {
                        aVar2.c = d1.getHeight();
                        aVar2.d++;
                    }
                }
            }
            this.j++;
        } else {
            throw new IllegalStateException("index out of bounds");
        }
    }

    public List<XMSSNode> getAuthenticationPath() {
        ArrayList arrayList = new ArrayList();
        for (XMSSNode xMSSNode : this.f) {
            arrayList.add(xMSSNode.clone());
        }
        return arrayList;
    }

    public int getIndex() {
        return this.j;
    }

    public BDS getNextState(byte[] bArr, byte[] bArr2, OTSHashAddress oTSHashAddress) {
        return new BDS(this, bArr, bArr2, oTSHashAddress);
    }

    public XMSSNode getRoot() {
        return this.e.clone();
    }

    public int getTreeHeight() {
        return this.b;
    }

    public void setXMSS(XMSSParameters xMSSParameters) {
        if (this.b == xMSSParameters.getHeight()) {
            this.a = xMSSParameters.a;
            return;
        }
        throw new IllegalStateException("wrong height");
    }

    public void validate() {
        if (this.f == null) {
            throw new IllegalStateException("authenticationPath == null");
        } else if (this.g == null) {
            throw new IllegalStateException("retain == null");
        } else if (this.h == null) {
            throw new IllegalStateException("stack == null");
        } else if (this.c == null) {
            throw new IllegalStateException("treeHashInstances == null");
        } else if (this.i == null) {
            throw new IllegalStateException("keep == null");
        } else if (!XMSSUtil.isIndexValid(this.b, (long) this.j)) {
            throw new IllegalStateException("index in BDS state out of bounds");
        }
    }

    public BDS(XMSSParameters xMSSParameters, byte[] bArr, byte[] bArr2, OTSHashAddress oTSHashAddress) {
        this(xMSSParameters.a, xMSSParameters.getHeight(), xMSSParameters.c);
        a(bArr, bArr2, oTSHashAddress);
    }

    public BDS(BDS bds, byte[] bArr, byte[] bArr2, OTSHashAddress oTSHashAddress) {
        this.a = bds.a;
        this.b = bds.b;
        this.d = bds.d;
        this.e = bds.e;
        this.f = new ArrayList(bds.f);
        this.g = bds.g;
        this.h = (Stack) bds.h.clone();
        this.c = bds.c;
        this.i = new TreeMap(bds.i);
        this.j = bds.j;
        b(bArr, bArr2, oTSHashAddress);
        bds.k = true;
    }
}
