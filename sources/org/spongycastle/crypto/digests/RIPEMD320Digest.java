package org.spongycastle.crypto.digests;

import a2.b.a.a.a;
import org.spongycastle.util.Memoable;
public class RIPEMD320Digest extends GeneralDigest {
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public int j;
    public int k;
    public int l;
    public int m;
    public int[] n;
    public int o;

    public RIPEMD320Digest() {
        this.n = new int[16];
        reset();
    }

    public final int a(int i2, int i3) {
        return (i2 >>> (32 - i3)) | (i2 << i3);
    }

    public final void b(RIPEMD320Digest rIPEMD320Digest) {
        super.copyIn(rIPEMD320Digest);
        this.d = rIPEMD320Digest.d;
        this.e = rIPEMD320Digest.e;
        this.f = rIPEMD320Digest.f;
        this.g = rIPEMD320Digest.g;
        this.h = rIPEMD320Digest.h;
        this.i = rIPEMD320Digest.i;
        this.j = rIPEMD320Digest.j;
        this.k = rIPEMD320Digest.k;
        this.l = rIPEMD320Digest.l;
        this.m = rIPEMD320Digest.m;
        int[] iArr = rIPEMD320Digest.n;
        System.arraycopy(iArr, 0, this.n, 0, iArr.length);
        this.o = rIPEMD320Digest.o;
    }

    public final int c(int i2, int i3, int i4) {
        return (i2 ^ i3) ^ i4;
    }

    @Override // org.spongycastle.util.Memoable
    public Memoable copy() {
        return new RIPEMD320Digest(this);
    }

    public final int d(int i2, int i3, int i4) {
        return ((~i2) & i4) | (i3 & i2);
    }

    @Override // org.spongycastle.crypto.Digest
    public int doFinal(byte[] bArr, int i2) {
        finish();
        h(this.d, bArr, i2);
        h(this.e, bArr, i2 + 4);
        h(this.f, bArr, i2 + 8);
        h(this.g, bArr, i2 + 12);
        h(this.h, bArr, i2 + 16);
        h(this.i, bArr, i2 + 20);
        h(this.j, bArr, i2 + 24);
        h(this.k, bArr, i2 + 28);
        h(this.l, bArr, i2 + 32);
        h(this.m, bArr, i2 + 36);
        reset();
        return 40;
    }

    public final int e(int i2, int i3, int i4) {
        return (i2 | (~i3)) ^ i4;
    }

    public final int f(int i2, int i3, int i4) {
        return (i2 & i4) | (i3 & (~i4));
    }

    public final int g(int i2, int i3, int i4) {
        return i2 ^ (i3 | (~i4));
    }

    @Override // org.spongycastle.crypto.Digest
    public String getAlgorithmName() {
        return "RIPEMD320";
    }

    @Override // org.spongycastle.crypto.Digest
    public int getDigestSize() {
        return 40;
    }

    public final void h(int i2, byte[] bArr, int i3) {
        bArr[i3] = (byte) i2;
        bArr[i3 + 1] = (byte) (i2 >>> 8);
        bArr[i3 + 2] = (byte) (i2 >>> 16);
        bArr[i3 + 3] = (byte) (i2 >>> 24);
    }

    @Override // org.spongycastle.crypto.digests.GeneralDigest
    public void processBlock() {
        int i2 = this.d;
        int i3 = this.e;
        int i4 = this.f;
        int i5 = this.g;
        int i6 = this.h;
        int i7 = this.i;
        int i8 = this.j;
        int i9 = this.k;
        int i10 = this.l;
        int i11 = this.m;
        int J = a.J(c(i3, i4, i5) + i2, this.n[0], this, 11, i6);
        int a = a(i4, 10);
        int J2 = a.J(c(J, i3, a) + i6, this.n[1], this, 14, i5);
        int a3 = a(i3, 10);
        int J3 = a.J(c(J2, J, a3) + i5, this.n[2], this, 15, a);
        int a4 = a(J, 10);
        int J4 = a.J(c(J3, J2, a4) + a, this.n[3], this, 12, a3);
        int a5 = a(J2, 10);
        int J5 = a.J(c(J4, J3, a5) + a3, this.n[4], this, 5, a4);
        int a6 = a(J3, 10);
        int J6 = a.J(c(J5, J4, a6) + a4, this.n[5], this, 8, a5);
        int a8 = a(J4, 10);
        int J7 = a.J(c(J6, J5, a8) + a5, this.n[6], this, 7, a6);
        int a9 = a(J5, 10);
        int J8 = a.J(c(J7, J6, a9) + a6, this.n[7], this, 9, a8);
        int a10 = a(J6, 10);
        int J9 = a.J(c(J8, J7, a10) + a8, this.n[8], this, 11, a9);
        int a11 = a(J7, 10);
        int J10 = a.J(c(J9, J8, a11) + a9, this.n[9], this, 13, a10);
        int a12 = a(J8, 10);
        int J11 = a.J(c(J10, J9, a12) + a10, this.n[10], this, 14, a11);
        int a13 = a(J9, 10);
        int J12 = a.J(c(J11, J10, a13) + a11, this.n[11], this, 15, a12);
        int a14 = a(J10, 10);
        int J13 = a.J(c(J12, J11, a14) + a12, this.n[12], this, 6, a13);
        int a15 = a(J11, 10);
        int J14 = a.J(c(J13, J12, a15) + a13, this.n[13], this, 7, a14);
        int a16 = a(J12, 10);
        int J15 = a.J(c(J14, J13, a16) + a14, this.n[14], this, 9, a15);
        int a17 = a(J13, 10);
        int J16 = a.J(c(J15, J14, a17) + a15, this.n[15], this, 8, a16);
        int a18 = a(J14, 10);
        int n2 = a.n(g(i8, i9, i10) + i7, this.n[5], 1352829926, this, 8, i11);
        int a19 = a(i9, 10);
        int n3 = a.n(g(n2, i8, a19) + i11, this.n[14], 1352829926, this, 9, i10);
        int a20 = a(i8, 10);
        int n4 = a.n(g(n3, n2, a20) + i10, this.n[7], 1352829926, this, 9, a19);
        int a21 = a(n2, 10);
        int n5 = a.n(g(n4, n3, a21) + a19, this.n[0], 1352829926, this, 11, a20);
        int a22 = a(n3, 10);
        int n7 = a.n(g(n5, n4, a22) + a20, this.n[9], 1352829926, this, 13, a21);
        int a23 = a(n4, 10);
        int n8 = a.n(g(n7, n5, a23) + a21, this.n[2], 1352829926, this, 15, a22);
        int a24 = a(n5, 10);
        int n9 = a.n(g(n8, n7, a24) + a22, this.n[11], 1352829926, this, 15, a23);
        int a25 = a(n7, 10);
        int n10 = a.n(g(n9, n8, a25) + a23, this.n[4], 1352829926, this, 5, a24);
        int a26 = a(n8, 10);
        int n11 = a.n(g(n10, n9, a26) + a24, this.n[13], 1352829926, this, 7, a25);
        int a27 = a(n9, 10);
        int n12 = a.n(g(n11, n10, a27) + a25, this.n[6], 1352829926, this, 7, a26);
        int a28 = a(n10, 10);
        int n13 = a.n(g(n12, n11, a28) + a26, this.n[15], 1352829926, this, 8, a27);
        int a29 = a(n11, 10);
        int n14 = a.n(g(n13, n12, a29) + a27, this.n[8], 1352829926, this, 11, a28);
        int a30 = a(n12, 10);
        int n15 = a.n(g(n14, n13, a30) + a28, this.n[1], 1352829926, this, 14, a29);
        int a31 = a(n13, 10);
        int n16 = a.n(g(n15, n14, a31) + a29, this.n[10], 1352829926, this, 14, a30);
        int a32 = a(n14, 10);
        int n17 = a.n(g(n16, n15, a32) + a30, this.n[3], 1352829926, this, 12, a31);
        int a33 = a(n15, 10);
        int n18 = a.n(g(n17, n16, a33) + a31, this.n[12], 1352829926, this, 6, a32);
        int a34 = a(n16, 10);
        int n19 = a.n(d(n18, J15, a18) + a16, this.n[7], 1518500249, this, 7, a17);
        int a35 = a(J15, 10);
        int n20 = a.n(d(n19, n18, a35) + a17, this.n[4], 1518500249, this, 6, a18);
        int a36 = a(n18, 10);
        int n21 = a.n(d(n20, n19, a36) + a18, this.n[13], 1518500249, this, 8, a35);
        int a37 = a(n19, 10);
        int n22 = a.n(d(n21, n20, a37) + a35, this.n[1], 1518500249, this, 13, a36);
        int a38 = a(n20, 10);
        int n23 = a.n(d(n22, n21, a38) + a36, this.n[10], 1518500249, this, 11, a37);
        int a39 = a(n21, 10);
        int n24 = a.n(d(n23, n22, a39) + a37, this.n[6], 1518500249, this, 9, a38);
        int a40 = a(n22, 10);
        int n25 = a.n(d(n24, n23, a40) + a38, this.n[15], 1518500249, this, 7, a39);
        int a41 = a(n23, 10);
        int n26 = a.n(d(n25, n24, a41) + a39, this.n[3], 1518500249, this, 15, a40);
        int a42 = a(n24, 10);
        int n27 = a.n(d(n26, n25, a42) + a40, this.n[12], 1518500249, this, 7, a41);
        int a43 = a(n25, 10);
        int n28 = a.n(d(n27, n26, a43) + a41, this.n[0], 1518500249, this, 12, a42);
        int a44 = a(n26, 10);
        int n29 = a.n(d(n28, n27, a44) + a42, this.n[9], 1518500249, this, 15, a43);
        int a45 = a(n27, 10);
        int n30 = a.n(d(n29, n28, a45) + a43, this.n[5], 1518500249, this, 9, a44);
        int a46 = a(n28, 10);
        int n31 = a.n(d(n30, n29, a46) + a44, this.n[2], 1518500249, this, 11, a45);
        int a47 = a(n29, 10);
        int n32 = a.n(d(n31, n30, a47) + a45, this.n[14], 1518500249, this, 7, a46);
        int a48 = a(n30, 10);
        int n33 = a.n(d(n32, n31, a48) + a46, this.n[11], 1518500249, this, 13, a47);
        int a49 = a(n31, 10);
        int n34 = a.n(d(n33, n32, a49) + a47, this.n[8], 1518500249, this, 12, a48);
        int a50 = a(n32, 10);
        int n35 = a.n(f(J16, n17, a34) + a32, this.n[6], 1548603684, this, 9, a33);
        int a51 = a(n17, 10);
        int n36 = a.n(f(n35, J16, a51) + a33, this.n[11], 1548603684, this, 13, a34);
        int a52 = a(J16, 10);
        int n37 = a.n(f(n36, n35, a52) + a34, this.n[3], 1548603684, this, 15, a51);
        int a53 = a(n35, 10);
        int n38 = a.n(f(n37, n36, a53) + a51, this.n[7], 1548603684, this, 7, a52);
        int a54 = a(n36, 10);
        int n39 = a.n(f(n38, n37, a54) + a52, this.n[0], 1548603684, this, 12, a53);
        int a55 = a(n37, 10);
        int n40 = a.n(f(n39, n38, a55) + a53, this.n[13], 1548603684, this, 8, a54);
        int a56 = a(n38, 10);
        int n41 = a.n(f(n40, n39, a56) + a54, this.n[5], 1548603684, this, 9, a55);
        int a57 = a(n39, 10);
        int n42 = a.n(f(n41, n40, a57) + a55, this.n[10], 1548603684, this, 11, a56);
        int a58 = a(n40, 10);
        int n43 = a.n(f(n42, n41, a58) + a56, this.n[14], 1548603684, this, 7, a57);
        int a59 = a(n41, 10);
        int n44 = a.n(f(n43, n42, a59) + a57, this.n[15], 1548603684, this, 7, a58);
        int a60 = a(n42, 10);
        int n45 = a.n(f(n44, n43, a60) + a58, this.n[8], 1548603684, this, 12, a59);
        int a61 = a(n43, 10);
        int n46 = a.n(f(n45, n44, a61) + a59, this.n[12], 1548603684, this, 7, a60);
        int a62 = a(n44, 10);
        int n47 = a.n(f(n46, n45, a62) + a60, this.n[4], 1548603684, this, 6, a61);
        int a63 = a(n45, 10);
        int n48 = a.n(f(n47, n46, a63) + a61, this.n[9], 1548603684, this, 15, a62);
        int a64 = a(n46, 10);
        int n49 = a.n(f(n48, n47, a64) + a62, this.n[1], 1548603684, this, 13, a63);
        int a65 = a(n47, 10);
        int n50 = a.n(f(n49, n48, a65) + a63, this.n[2], 1548603684, this, 11, a64);
        int a66 = a(n48, 10);
        int n51 = a.n(e(n34, n33, a66) + a48, this.n[3], 1859775393, this, 11, a49);
        int a67 = a(n33, 10);
        int n52 = a.n(e(n51, n34, a67) + a49, this.n[10], 1859775393, this, 13, a66);
        int a68 = a(n34, 10);
        int n53 = a.n(e(n52, n51, a68) + a66, this.n[14], 1859775393, this, 6, a67);
        int a69 = a(n51, 10);
        int n54 = a.n(e(n53, n52, a69) + a67, this.n[4], 1859775393, this, 7, a68);
        int a70 = a(n52, 10);
        int n55 = a.n(e(n54, n53, a70) + a68, this.n[9], 1859775393, this, 14, a69);
        int a71 = a(n53, 10);
        int n56 = a.n(e(n55, n54, a71) + a69, this.n[15], 1859775393, this, 9, a70);
        int a72 = a(n54, 10);
        int n57 = a.n(e(n56, n55, a72) + a70, this.n[8], 1859775393, this, 13, a71);
        int a73 = a(n55, 10);
        int n58 = a.n(e(n57, n56, a73) + a71, this.n[1], 1859775393, this, 15, a72);
        int a74 = a(n56, 10);
        int n59 = a.n(e(n58, n57, a74) + a72, this.n[2], 1859775393, this, 14, a73);
        int a75 = a(n57, 10);
        int n60 = a.n(e(n59, n58, a75) + a73, this.n[7], 1859775393, this, 8, a74);
        int a76 = a(n58, 10);
        int n61 = a.n(e(n60, n59, a76) + a74, this.n[0], 1859775393, this, 13, a75);
        int a77 = a(n59, 10);
        int n62 = a.n(e(n61, n60, a77) + a75, this.n[6], 1859775393, this, 6, a76);
        int a78 = a(n60, 10);
        int n63 = a.n(e(n62, n61, a78) + a76, this.n[13], 1859775393, this, 5, a77);
        int a79 = a(n61, 10);
        int n64 = a.n(e(n63, n62, a79) + a77, this.n[11], 1859775393, this, 12, a78);
        int a80 = a(n62, 10);
        int n65 = a.n(e(n64, n63, a80) + a78, this.n[5], 1859775393, this, 7, a79);
        int a81 = a(n63, 10);
        int n66 = a.n(e(n65, n64, a81) + a79, this.n[12], 1859775393, this, 5, a80);
        int a82 = a(n64, 10);
        int n67 = a.n(e(n50, n49, a50) + a64, this.n[15], 1836072691, this, 9, a65);
        int a83 = a(n49, 10);
        int n68 = a.n(e(n67, n50, a83) + a65, this.n[5], 1836072691, this, 7, a50);
        int a84 = a(n50, 10);
        int n69 = a.n(e(n68, n67, a84) + a50, this.n[1], 1836072691, this, 15, a83);
        int a85 = a(n67, 10);
        int n70 = a.n(e(n69, n68, a85) + a83, this.n[3], 1836072691, this, 11, a84);
        int a86 = a(n68, 10);
        int n71 = a.n(e(n70, n69, a86) + a84, this.n[7], 1836072691, this, 8, a85);
        int a87 = a(n69, 10);
        int n72 = a.n(e(n71, n70, a87) + a85, this.n[14], 1836072691, this, 6, a86);
        int a88 = a(n70, 10);
        int n73 = a.n(e(n72, n71, a88) + a86, this.n[6], 1836072691, this, 6, a87);
        int a89 = a(n71, 10);
        int n74 = a.n(e(n73, n72, a89) + a87, this.n[9], 1836072691, this, 14, a88);
        int a90 = a(n72, 10);
        int n75 = a.n(e(n74, n73, a90) + a88, this.n[11], 1836072691, this, 12, a89);
        int a91 = a(n73, 10);
        int n76 = a.n(e(n75, n74, a91) + a89, this.n[8], 1836072691, this, 13, a90);
        int a92 = a(n74, 10);
        int n77 = a.n(e(n76, n75, a92) + a90, this.n[12], 1836072691, this, 5, a91);
        int a93 = a(n75, 10);
        int n78 = a.n(e(n77, n76, a93) + a91, this.n[2], 1836072691, this, 14, a92);
        int a94 = a(n76, 10);
        int n79 = a.n(e(n78, n77, a94) + a92, this.n[10], 1836072691, this, 13, a93);
        int a95 = a(n77, 10);
        int n80 = a.n(e(n79, n78, a95) + a93, this.n[0], 1836072691, this, 13, a94);
        int a96 = a(n78, 10);
        int n81 = a.n(e(n80, n79, a96) + a94, this.n[4], 1836072691, this, 7, a95);
        int a97 = a(n79, 10);
        int n82 = a.n(e(n81, n80, a97) + a95, this.n[13], 1836072691, this, 5, a96);
        int a98 = a(n80, 10);
        int n83 = a.n(f(n66, n65, a82) + a96, this.n[1], -1894007588, this, 11, a81);
        int a99 = a(n65, 10);
        int n84 = a.n(f(n83, n66, a99) + a81, this.n[9], -1894007588, this, 12, a82);
        int a100 = a(n66, 10);
        int n85 = a.n(f(n84, n83, a100) + a82, this.n[11], -1894007588, this, 14, a99);
        int a101 = a(n83, 10);
        int n86 = a.n(f(n85, n84, a101) + a99, this.n[10], -1894007588, this, 15, a100);
        int a102 = a(n84, 10);
        int n87 = a.n(f(n86, n85, a102) + a100, this.n[0], -1894007588, this, 14, a101);
        int a103 = a(n85, 10);
        int n88 = a.n(f(n87, n86, a103) + a101, this.n[8], -1894007588, this, 15, a102);
        int a104 = a(n86, 10);
        int n89 = a.n(f(n88, n87, a104) + a102, this.n[12], -1894007588, this, 9, a103);
        int a105 = a(n87, 10);
        int n90 = a.n(f(n89, n88, a105) + a103, this.n[4], -1894007588, this, 8, a104);
        int a106 = a(n88, 10);
        int n91 = a.n(f(n90, n89, a106) + a104, this.n[13], -1894007588, this, 9, a105);
        int a107 = a(n89, 10);
        int n92 = a.n(f(n91, n90, a107) + a105, this.n[3], -1894007588, this, 14, a106);
        int a108 = a(n90, 10);
        int n93 = a.n(f(n92, n91, a108) + a106, this.n[7], -1894007588, this, 5, a107);
        int a109 = a(n91, 10);
        int n94 = a.n(f(n93, n92, a109) + a107, this.n[15], -1894007588, this, 6, a108);
        int a110 = a(n92, 10);
        int n95 = a.n(f(n94, n93, a110) + a108, this.n[14], -1894007588, this, 8, a109);
        int a111 = a(n93, 10);
        int n96 = a.n(f(n95, n94, a111) + a109, this.n[5], -1894007588, this, 6, a110);
        int a112 = a(n94, 10);
        int n97 = a.n(f(n96, n95, a112) + a110, this.n[6], -1894007588, this, 5, a111);
        int a113 = a(n95, 10);
        int n98 = a.n(f(n97, n96, a113) + a111, this.n[2], -1894007588, this, 12, a112);
        int a114 = a(n96, 10);
        int n99 = a.n(d(n82, n81, a98) + a80, this.n[8], 2053994217, this, 15, a97);
        int a115 = a(n81, 10);
        int n100 = a.n(d(n99, n82, a115) + a97, this.n[6], 2053994217, this, 5, a98);
        int a116 = a(n82, 10);
        int n101 = a.n(d(n100, n99, a116) + a98, this.n[4], 2053994217, this, 8, a115);
        int a117 = a(n99, 10);
        int n102 = a.n(d(n101, n100, a117) + a115, this.n[1], 2053994217, this, 11, a116);
        int a118 = a(n100, 10);
        int n103 = a.n(d(n102, n101, a118) + a116, this.n[3], 2053994217, this, 14, a117);
        int a119 = a(n101, 10);
        int n104 = a.n(d(n103, n102, a119) + a117, this.n[11], 2053994217, this, 14, a118);
        int a120 = a(n102, 10);
        int n105 = a.n(d(n104, n103, a120) + a118, this.n[15], 2053994217, this, 6, a119);
        int a121 = a(n103, 10);
        int n106 = a.n(d(n105, n104, a121) + a119, this.n[0], 2053994217, this, 14, a120);
        int a122 = a(n104, 10);
        int n107 = a.n(d(n106, n105, a122) + a120, this.n[5], 2053994217, this, 6, a121);
        int a123 = a(n105, 10);
        int n108 = a.n(d(n107, n106, a123) + a121, this.n[12], 2053994217, this, 9, a122);
        int a124 = a(n106, 10);
        int n109 = a.n(d(n108, n107, a124) + a122, this.n[2], 2053994217, this, 12, a123);
        int a125 = a(n107, 10);
        int n110 = a.n(d(n109, n108, a125) + a123, this.n[13], 2053994217, this, 9, a124);
        int a126 = a(n108, 10);
        int n111 = a.n(d(n110, n109, a126) + a124, this.n[9], 2053994217, this, 12, a125);
        int a127 = a(n109, 10);
        int n112 = a.n(d(n111, n110, a127) + a125, this.n[7], 2053994217, this, 5, a126);
        int a128 = a(n110, 10);
        int n113 = a.n(d(n112, n111, a128) + a126, this.n[10], 2053994217, this, 15, a127);
        int a129 = a(n111, 10);
        int n114 = a.n(d(n113, n112, a129) + a127, this.n[14], 2053994217, this, 8, a128);
        int a130 = a(n112, 10);
        int n115 = a.n(g(n98, n113, a114) + a112, this.n[4], -1454113458, this, 9, a113);
        int a131 = a(n113, 10);
        int n116 = a.n(g(n115, n98, a131) + a113, this.n[0], -1454113458, this, 15, a114);
        int a132 = a(n98, 10);
        int n117 = a.n(g(n116, n115, a132) + a114, this.n[5], -1454113458, this, 5, a131);
        int a133 = a(n115, 10);
        int n118 = a.n(g(n117, n116, a133) + a131, this.n[9], -1454113458, this, 11, a132);
        int a134 = a(n116, 10);
        int n119 = a.n(g(n118, n117, a134) + a132, this.n[7], -1454113458, this, 6, a133);
        int a135 = a(n117, 10);
        int n120 = a.n(g(n119, n118, a135) + a133, this.n[12], -1454113458, this, 8, a134);
        int a136 = a(n118, 10);
        int n121 = a.n(g(n120, n119, a136) + a134, this.n[2], -1454113458, this, 13, a135);
        int a137 = a(n119, 10);
        int n122 = a.n(g(n121, n120, a137) + a135, this.n[10], -1454113458, this, 12, a136);
        int a138 = a(n120, 10);
        int n123 = a.n(g(n122, n121, a138) + a136, this.n[14], -1454113458, this, 5, a137);
        int a139 = a(n121, 10);
        int n124 = a.n(g(n123, n122, a139) + a137, this.n[1], -1454113458, this, 12, a138);
        int a140 = a(n122, 10);
        int n125 = a.n(g(n124, n123, a140) + a138, this.n[3], -1454113458, this, 13, a139);
        int a141 = a(n123, 10);
        int n126 = a.n(g(n125, n124, a141) + a139, this.n[8], -1454113458, this, 14, a140);
        int a142 = a(n124, 10);
        int n127 = a.n(g(n126, n125, a142) + a140, this.n[11], -1454113458, this, 11, a141);
        int a143 = a(n125, 10);
        int n128 = a.n(g(n127, n126, a143) + a141, this.n[6], -1454113458, this, 8, a142);
        int a144 = a(n126, 10);
        int n129 = a.n(g(n128, n127, a144) + a142, this.n[15], -1454113458, this, 5, a143);
        int a145 = a(n127, 10);
        int n130 = a.n(g(n129, n128, a145) + a143, this.n[13], -1454113458, this, 6, a144);
        int a146 = a(n128, 10);
        int J17 = a.J(c(n114, n97, a130) + a128, this.n[12], this, 8, a129);
        int a147 = a(n97, 10);
        int J18 = a.J(c(J17, n114, a147) + a129, this.n[15], this, 5, a130);
        int a148 = a(n114, 10);
        int J19 = a.J(c(J18, J17, a148) + a130, this.n[10], this, 12, a147);
        int a149 = a(J17, 10);
        int J20 = a.J(c(J19, J18, a149) + a147, this.n[4], this, 9, a148);
        int a150 = a(J18, 10);
        int J21 = a.J(c(J20, J19, a150) + a148, this.n[1], this, 12, a149);
        int a151 = a(J19, 10);
        int J22 = a.J(c(J21, J20, a151) + a149, this.n[5], this, 5, a150);
        int a152 = a(J20, 10);
        int J23 = a.J(c(J22, J21, a152) + a150, this.n[8], this, 14, a151);
        int a153 = a(J21, 10);
        int J24 = a.J(c(J23, J22, a153) + a151, this.n[7], this, 6, a152);
        int a154 = a(J22, 10);
        int J25 = a.J(c(J24, J23, a154) + a152, this.n[6], this, 8, a153);
        int a155 = a(J23, 10);
        int J26 = a.J(c(J25, J24, a155) + a153, this.n[2], this, 13, a154);
        int a156 = a(J24, 10);
        int J27 = a.J(c(J26, J25, a156) + a154, this.n[13], this, 6, a155);
        int a157 = a(J25, 10);
        int J28 = a.J(c(J27, J26, a157) + a155, this.n[14], this, 5, a156);
        int a158 = a(J26, 10);
        int J29 = a.J(c(J28, J27, a158) + a156, this.n[0], this, 15, a157);
        int a159 = a(J27, 10);
        int J30 = a.J(c(J29, J28, a159) + a157, this.n[3], this, 13, a158);
        int a160 = a(J28, 10);
        int J31 = a.J(c(J30, J29, a160) + a158, this.n[9], this, 11, a159);
        int a161 = a(J29, 10);
        int J32 = a.J(c(J31, J30, a161) + a159, this.n[11], this, 11, a160);
        int a162 = a(J30, 10);
        this.d += a144;
        this.e += n130;
        this.f += n129;
        this.g += a146;
        this.h += a161;
        this.i += a160;
        this.j += J32;
        this.k += J31;
        this.l += a162;
        this.m += a145;
        this.o = 0;
        int i12 = 0;
        while (true) {
            int[] iArr = this.n;
            if (i12 != iArr.length) {
                iArr[i12] = 0;
                i12++;
            } else {
                return;
            }
        }
    }

    @Override // org.spongycastle.crypto.digests.GeneralDigest
    public void processLength(long j2) {
        if (this.o > 14) {
            processBlock();
        }
        int[] iArr = this.n;
        iArr[14] = (int) (-1 & j2);
        iArr[15] = (int) (j2 >>> 32);
    }

    @Override // org.spongycastle.crypto.digests.GeneralDigest
    public void processWord(byte[] bArr, int i2) {
        int[] iArr = this.n;
        int i3 = this.o;
        int i4 = i3 + 1;
        this.o = i4;
        iArr[i3] = ((bArr[i2 + 3] & 255) << 24) | (bArr[i2] & 255) | ((bArr[i2 + 1] & 255) << 8) | ((bArr[i2 + 2] & 255) << 16);
        if (i4 == 16) {
            processBlock();
        }
    }

    @Override // org.spongycastle.crypto.digests.GeneralDigest, org.spongycastle.crypto.Digest
    public void reset() {
        super.reset();
        this.d = 1732584193;
        this.e = -271733879;
        this.f = -1732584194;
        this.g = 271733878;
        this.h = -1009589776;
        this.i = 1985229328;
        this.j = -19088744;
        this.k = -1985229329;
        this.l = 19088743;
        this.m = 1009589775;
        this.o = 0;
        int i2 = 0;
        while (true) {
            int[] iArr = this.n;
            if (i2 != iArr.length) {
                iArr[i2] = 0;
                i2++;
            } else {
                return;
            }
        }
    }

    public RIPEMD320Digest(RIPEMD320Digest rIPEMD320Digest) {
        super(rIPEMD320Digest);
        this.n = new int[16];
        b(rIPEMD320Digest);
    }

    @Override // org.spongycastle.util.Memoable
    public void reset(Memoable memoable) {
        b((RIPEMD320Digest) memoable);
    }
}
