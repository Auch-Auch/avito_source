package org.spongycastle.crypto.digests;

import a2.b.a.a.a;
import org.spongycastle.util.Memoable;
public class RIPEMD160Digest extends GeneralDigest {
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int[] i;
    public int j;

    public RIPEMD160Digest() {
        this.i = new int[16];
        reset();
    }

    public final int a(int i2, int i3) {
        return (i2 >>> (32 - i3)) | (i2 << i3);
    }

    public final void b(RIPEMD160Digest rIPEMD160Digest) {
        super.copyIn(rIPEMD160Digest);
        this.d = rIPEMD160Digest.d;
        this.e = rIPEMD160Digest.e;
        this.f = rIPEMD160Digest.f;
        this.g = rIPEMD160Digest.g;
        this.h = rIPEMD160Digest.h;
        int[] iArr = rIPEMD160Digest.i;
        System.arraycopy(iArr, 0, this.i, 0, iArr.length);
        this.j = rIPEMD160Digest.j;
    }

    public final int c(int i2, int i3, int i4) {
        return (i2 ^ i3) ^ i4;
    }

    @Override // org.spongycastle.util.Memoable
    public Memoable copy() {
        return new RIPEMD160Digest(this);
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
        reset();
        return 20;
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
        return "RIPEMD160";
    }

    @Override // org.spongycastle.crypto.Digest
    public int getDigestSize() {
        return 20;
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
        int y = a.y(c(i3, i4, i5) + i2, this.i[0], this, 11, i6);
        int a = a(i4, 10);
        int y2 = a.y(c(y, i3, a) + i6, this.i[1], this, 14, i5);
        int a3 = a(i3, 10);
        int y3 = a.y(c(y2, y, a3) + i5, this.i[2], this, 15, a);
        int a4 = a(y, 10);
        int y4 = a.y(c(y3, y2, a4) + a, this.i[3], this, 12, a3);
        int a5 = a(y2, 10);
        int y5 = a.y(c(y4, y3, a5) + a3, this.i[4], this, 5, a4);
        int a6 = a(y3, 10);
        int y7 = a.y(c(y5, y4, a6) + a4, this.i[5], this, 8, a5);
        int a8 = a(y4, 10);
        int y8 = a.y(c(y7, y5, a8) + a5, this.i[6], this, 7, a6);
        int a9 = a(y5, 10);
        int y9 = a.y(c(y8, y7, a9) + a6, this.i[7], this, 9, a8);
        int a10 = a(y7, 10);
        int y10 = a.y(c(y9, y8, a10) + a8, this.i[8], this, 11, a9);
        int a11 = a(y8, 10);
        int y11 = a.y(c(y10, y9, a11) + a9, this.i[9], this, 13, a10);
        int a12 = a(y9, 10);
        int y12 = a.y(c(y11, y10, a12) + a10, this.i[10], this, 14, a11);
        int a13 = a(y10, 10);
        int y13 = a.y(c(y12, y11, a13) + a11, this.i[11], this, 15, a12);
        int a14 = a(y11, 10);
        int y14 = a.y(c(y13, y12, a14) + a12, this.i[12], this, 6, a13);
        int a15 = a(y12, 10);
        int y15 = a.y(c(y14, y13, a15) + a13, this.i[13], this, 7, a14);
        int a16 = a(y13, 10);
        int y16 = a.y(c(y15, y14, a16) + a14, this.i[14], this, 9, a15);
        int a17 = a(y14, 10);
        int y17 = a.y(c(y16, y15, a17) + a15, this.i[15], this, 8, a16);
        int a18 = a(y15, 10);
        int c = a.c(i2 + g(i3, i4, i5), this.i[5], 1352829926, this, 8, i6);
        int a19 = a(i4, 10);
        int c2 = a.c(g(c, i3, a19) + i6, this.i[14], 1352829926, this, 9, i5);
        int a20 = a(i3, 10);
        int c3 = a.c(g(c2, c, a20) + i5, this.i[7], 1352829926, this, 9, a19);
        int a21 = a(c, 10);
        int c4 = a.c(g(c3, c2, a21) + a19, this.i[0], 1352829926, this, 11, a20);
        int a22 = a(c2, 10);
        int c5 = a.c(g(c4, c3, a22) + a20, this.i[9], 1352829926, this, 13, a21);
        int a23 = a(c3, 10);
        int c6 = a.c(g(c5, c4, a23) + a21, this.i[2], 1352829926, this, 15, a22);
        int a24 = a(c4, 10);
        int c7 = a.c(g(c6, c5, a24) + a22, this.i[11], 1352829926, this, 15, a23);
        int a25 = a(c5, 10);
        int c8 = a.c(g(c7, c6, a25) + a23, this.i[4], 1352829926, this, 5, a24);
        int a26 = a(c6, 10);
        int c9 = a.c(g(c8, c7, a26) + a24, this.i[13], 1352829926, this, 7, a25);
        int a27 = a(c7, 10);
        int c10 = a.c(g(c9, c8, a27) + a25, this.i[6], 1352829926, this, 7, a26);
        int a28 = a(c8, 10);
        int c11 = a.c(g(c10, c9, a28) + a26, this.i[15], 1352829926, this, 8, a27);
        int a29 = a(c9, 10);
        int c12 = a.c(g(c11, c10, a29) + a27, this.i[8], 1352829926, this, 11, a28);
        int a30 = a(c10, 10);
        int c13 = a.c(g(c12, c11, a30) + a28, this.i[1], 1352829926, this, 14, a29);
        int a31 = a(c11, 10);
        int c14 = a.c(g(c13, c12, a31) + a29, this.i[10], 1352829926, this, 14, a30);
        int a32 = a(c12, 10);
        int c15 = a.c(g(c14, c13, a32) + a30, this.i[3], 1352829926, this, 12, a31);
        int a33 = a(c13, 10);
        int c16 = a.c(g(c15, c14, a33) + a31, this.i[12], 1352829926, this, 6, a32);
        int a34 = a(c14, 10);
        int c17 = a.c(d(y17, y16, a18) + a16, this.i[7], 1518500249, this, 7, a17);
        int a35 = a(y16, 10);
        int c18 = a.c(d(c17, y17, a35) + a17, this.i[4], 1518500249, this, 6, a18);
        int a36 = a(y17, 10);
        int c19 = a.c(d(c18, c17, a36) + a18, this.i[13], 1518500249, this, 8, a35);
        int a37 = a(c17, 10);
        int c20 = a.c(d(c19, c18, a37) + a35, this.i[1], 1518500249, this, 13, a36);
        int a38 = a(c18, 10);
        int c21 = a.c(d(c20, c19, a38) + a36, this.i[10], 1518500249, this, 11, a37);
        int a39 = a(c19, 10);
        int c22 = a.c(d(c21, c20, a39) + a37, this.i[6], 1518500249, this, 9, a38);
        int a40 = a(c20, 10);
        int c23 = a.c(d(c22, c21, a40) + a38, this.i[15], 1518500249, this, 7, a39);
        int a41 = a(c21, 10);
        int c24 = a.c(d(c23, c22, a41) + a39, this.i[3], 1518500249, this, 15, a40);
        int a42 = a(c22, 10);
        int c25 = a.c(d(c24, c23, a42) + a40, this.i[12], 1518500249, this, 7, a41);
        int a43 = a(c23, 10);
        int c26 = a.c(d(c25, c24, a43) + a41, this.i[0], 1518500249, this, 12, a42);
        int a44 = a(c24, 10);
        int c27 = a.c(d(c26, c25, a44) + a42, this.i[9], 1518500249, this, 15, a43);
        int a45 = a(c25, 10);
        int c28 = a.c(d(c27, c26, a45) + a43, this.i[5], 1518500249, this, 9, a44);
        int a46 = a(c26, 10);
        int c29 = a.c(d(c28, c27, a46) + a44, this.i[2], 1518500249, this, 11, a45);
        int a47 = a(c27, 10);
        int c30 = a.c(d(c29, c28, a47) + a45, this.i[14], 1518500249, this, 7, a46);
        int a48 = a(c28, 10);
        int c31 = a.c(d(c30, c29, a48) + a46, this.i[11], 1518500249, this, 13, a47);
        int a49 = a(c29, 10);
        int c32 = a.c(d(c31, c30, a49) + a47, this.i[8], 1518500249, this, 12, a48);
        int a50 = a(c30, 10);
        int c33 = a.c(f(c16, c15, a34) + a32, this.i[6], 1548603684, this, 9, a33);
        int a51 = a(c15, 10);
        int c34 = a.c(f(c33, c16, a51) + a33, this.i[11], 1548603684, this, 13, a34);
        int a52 = a(c16, 10);
        int c35 = a.c(f(c34, c33, a52) + a34, this.i[3], 1548603684, this, 15, a51);
        int a53 = a(c33, 10);
        int c36 = a.c(f(c35, c34, a53) + a51, this.i[7], 1548603684, this, 7, a52);
        int a54 = a(c34, 10);
        int c37 = a.c(f(c36, c35, a54) + a52, this.i[0], 1548603684, this, 12, a53);
        int a55 = a(c35, 10);
        int c38 = a.c(f(c37, c36, a55) + a53, this.i[13], 1548603684, this, 8, a54);
        int a56 = a(c36, 10);
        int c39 = a.c(f(c38, c37, a56) + a54, this.i[5], 1548603684, this, 9, a55);
        int a57 = a(c37, 10);
        int c40 = a.c(f(c39, c38, a57) + a55, this.i[10], 1548603684, this, 11, a56);
        int a58 = a(c38, 10);
        int c41 = a.c(f(c40, c39, a58) + a56, this.i[14], 1548603684, this, 7, a57);
        int a59 = a(c39, 10);
        int c42 = a.c(f(c41, c40, a59) + a57, this.i[15], 1548603684, this, 7, a58);
        int a60 = a(c40, 10);
        int c43 = a.c(f(c42, c41, a60) + a58, this.i[8], 1548603684, this, 12, a59);
        int a61 = a(c41, 10);
        int c44 = a.c(f(c43, c42, a61) + a59, this.i[12], 1548603684, this, 7, a60);
        int a62 = a(c42, 10);
        int c45 = a.c(f(c44, c43, a62) + a60, this.i[4], 1548603684, this, 6, a61);
        int a63 = a(c43, 10);
        int c46 = a.c(f(c45, c44, a63) + a61, this.i[9], 1548603684, this, 15, a62);
        int a64 = a(c44, 10);
        int c47 = a.c(f(c46, c45, a64) + a62, this.i[1], 1548603684, this, 13, a63);
        int a65 = a(c45, 10);
        int c48 = a.c(f(c47, c46, a65) + a63, this.i[2], 1548603684, this, 11, a64);
        int a66 = a(c46, 10);
        int c49 = a.c(e(c32, c31, a50) + a48, this.i[3], 1859775393, this, 11, a49);
        int a67 = a(c31, 10);
        int c50 = a.c(e(c49, c32, a67) + a49, this.i[10], 1859775393, this, 13, a50);
        int a68 = a(c32, 10);
        int c51 = a.c(e(c50, c49, a68) + a50, this.i[14], 1859775393, this, 6, a67);
        int a69 = a(c49, 10);
        int c52 = a.c(e(c51, c50, a69) + a67, this.i[4], 1859775393, this, 7, a68);
        int a70 = a(c50, 10);
        int c53 = a.c(e(c52, c51, a70) + a68, this.i[9], 1859775393, this, 14, a69);
        int a71 = a(c51, 10);
        int c54 = a.c(e(c53, c52, a71) + a69, this.i[15], 1859775393, this, 9, a70);
        int a72 = a(c52, 10);
        int c55 = a.c(e(c54, c53, a72) + a70, this.i[8], 1859775393, this, 13, a71);
        int a73 = a(c53, 10);
        int c56 = a.c(e(c55, c54, a73) + a71, this.i[1], 1859775393, this, 15, a72);
        int a74 = a(c54, 10);
        int c57 = a.c(e(c56, c55, a74) + a72, this.i[2], 1859775393, this, 14, a73);
        int a75 = a(c55, 10);
        int c58 = a.c(e(c57, c56, a75) + a73, this.i[7], 1859775393, this, 8, a74);
        int a76 = a(c56, 10);
        int c59 = a.c(e(c58, c57, a76) + a74, this.i[0], 1859775393, this, 13, a75);
        int a77 = a(c57, 10);
        int c60 = a.c(e(c59, c58, a77) + a75, this.i[6], 1859775393, this, 6, a76);
        int a78 = a(c58, 10);
        int c61 = a.c(e(c60, c59, a78) + a76, this.i[13], 1859775393, this, 5, a77);
        int a79 = a(c59, 10);
        int c62 = a.c(e(c61, c60, a79) + a77, this.i[11], 1859775393, this, 12, a78);
        int a80 = a(c60, 10);
        int c63 = a.c(e(c62, c61, a80) + a78, this.i[5], 1859775393, this, 7, a79);
        int a81 = a(c61, 10);
        int c64 = a.c(e(c63, c62, a81) + a79, this.i[12], 1859775393, this, 5, a80);
        int a82 = a(c62, 10);
        int c65 = a.c(e(c48, c47, a66) + a64, this.i[15], 1836072691, this, 9, a65);
        int a83 = a(c47, 10);
        int c66 = a.c(e(c65, c48, a83) + a65, this.i[5], 1836072691, this, 7, a66);
        int a84 = a(c48, 10);
        int c67 = a.c(e(c66, c65, a84) + a66, this.i[1], 1836072691, this, 15, a83);
        int a85 = a(c65, 10);
        int c68 = a.c(e(c67, c66, a85) + a83, this.i[3], 1836072691, this, 11, a84);
        int a86 = a(c66, 10);
        int c69 = a.c(e(c68, c67, a86) + a84, this.i[7], 1836072691, this, 8, a85);
        int a87 = a(c67, 10);
        int c70 = a.c(e(c69, c68, a87) + a85, this.i[14], 1836072691, this, 6, a86);
        int a88 = a(c68, 10);
        int c71 = a.c(e(c70, c69, a88) + a86, this.i[6], 1836072691, this, 6, a87);
        int a89 = a(c69, 10);
        int c72 = a.c(e(c71, c70, a89) + a87, this.i[9], 1836072691, this, 14, a88);
        int a90 = a(c70, 10);
        int c73 = a.c(e(c72, c71, a90) + a88, this.i[11], 1836072691, this, 12, a89);
        int a91 = a(c71, 10);
        int c74 = a.c(e(c73, c72, a91) + a89, this.i[8], 1836072691, this, 13, a90);
        int a92 = a(c72, 10);
        int c75 = a.c(e(c74, c73, a92) + a90, this.i[12], 1836072691, this, 5, a91);
        int a93 = a(c73, 10);
        int c76 = a.c(e(c75, c74, a93) + a91, this.i[2], 1836072691, this, 14, a92);
        int a94 = a(c74, 10);
        int c77 = a.c(e(c76, c75, a94) + a92, this.i[10], 1836072691, this, 13, a93);
        int a95 = a(c75, 10);
        int c78 = a.c(e(c77, c76, a95) + a93, this.i[0], 1836072691, this, 13, a94);
        int a96 = a(c76, 10);
        int c79 = a.c(e(c78, c77, a96) + a94, this.i[4], 1836072691, this, 7, a95);
        int a97 = a(c77, 10);
        int c80 = a.c(e(c79, c78, a97) + a95, this.i[13], 1836072691, this, 5, a96);
        int a98 = a(c78, 10);
        int c81 = a.c(f(c64, c63, a82) + a80, this.i[1], -1894007588, this, 11, a81);
        int a99 = a(c63, 10);
        int c82 = a.c(f(c81, c64, a99) + a81, this.i[9], -1894007588, this, 12, a82);
        int a100 = a(c64, 10);
        int c83 = a.c(f(c82, c81, a100) + a82, this.i[11], -1894007588, this, 14, a99);
        int a101 = a(c81, 10);
        int c84 = a.c(f(c83, c82, a101) + a99, this.i[10], -1894007588, this, 15, a100);
        int a102 = a(c82, 10);
        int c85 = a.c(f(c84, c83, a102) + a100, this.i[0], -1894007588, this, 14, a101);
        int a103 = a(c83, 10);
        int c86 = a.c(f(c85, c84, a103) + a101, this.i[8], -1894007588, this, 15, a102);
        int a104 = a(c84, 10);
        int c87 = a.c(f(c86, c85, a104) + a102, this.i[12], -1894007588, this, 9, a103);
        int a105 = a(c85, 10);
        int c88 = a.c(f(c87, c86, a105) + a103, this.i[4], -1894007588, this, 8, a104);
        int a106 = a(c86, 10);
        int c89 = a.c(f(c88, c87, a106) + a104, this.i[13], -1894007588, this, 9, a105);
        int a107 = a(c87, 10);
        int c90 = a.c(f(c89, c88, a107) + a105, this.i[3], -1894007588, this, 14, a106);
        int a108 = a(c88, 10);
        int c91 = a.c(f(c90, c89, a108) + a106, this.i[7], -1894007588, this, 5, a107);
        int a109 = a(c89, 10);
        int c92 = a.c(f(c91, c90, a109) + a107, this.i[15], -1894007588, this, 6, a108);
        int a110 = a(c90, 10);
        int c93 = a.c(f(c92, c91, a110) + a108, this.i[14], -1894007588, this, 8, a109);
        int a111 = a(c91, 10);
        int c94 = a.c(f(c93, c92, a111) + a109, this.i[5], -1894007588, this, 6, a110);
        int a112 = a(c92, 10);
        int c95 = a.c(f(c94, c93, a112) + a110, this.i[6], -1894007588, this, 5, a111);
        int a113 = a(c93, 10);
        int c96 = a.c(f(c95, c94, a113) + a111, this.i[2], -1894007588, this, 12, a112);
        int a114 = a(c94, 10);
        int c97 = a.c(d(c80, c79, a98) + a96, this.i[8], 2053994217, this, 15, a97);
        int a115 = a(c79, 10);
        int c98 = a.c(d(c97, c80, a115) + a97, this.i[6], 2053994217, this, 5, a98);
        int a116 = a(c80, 10);
        int c99 = a.c(d(c98, c97, a116) + a98, this.i[4], 2053994217, this, 8, a115);
        int a117 = a(c97, 10);
        int c100 = a.c(d(c99, c98, a117) + a115, this.i[1], 2053994217, this, 11, a116);
        int a118 = a(c98, 10);
        int c101 = a.c(d(c100, c99, a118) + a116, this.i[3], 2053994217, this, 14, a117);
        int a119 = a(c99, 10);
        int c102 = a.c(d(c101, c100, a119) + a117, this.i[11], 2053994217, this, 14, a118);
        int a120 = a(c100, 10);
        int c103 = a.c(d(c102, c101, a120) + a118, this.i[15], 2053994217, this, 6, a119);
        int a121 = a(c101, 10);
        int c104 = a.c(d(c103, c102, a121) + a119, this.i[0], 2053994217, this, 14, a120);
        int a122 = a(c102, 10);
        int c105 = a.c(d(c104, c103, a122) + a120, this.i[5], 2053994217, this, 6, a121);
        int a123 = a(c103, 10);
        int c106 = a.c(d(c105, c104, a123) + a121, this.i[12], 2053994217, this, 9, a122);
        int a124 = a(c104, 10);
        int c107 = a.c(d(c106, c105, a124) + a122, this.i[2], 2053994217, this, 12, a123);
        int a125 = a(c105, 10);
        int c108 = a.c(d(c107, c106, a125) + a123, this.i[13], 2053994217, this, 9, a124);
        int a126 = a(c106, 10);
        int c109 = a.c(d(c108, c107, a126) + a124, this.i[9], 2053994217, this, 12, a125);
        int a127 = a(c107, 10);
        int c110 = a.c(d(c109, c108, a127) + a125, this.i[7], 2053994217, this, 5, a126);
        int a128 = a(c108, 10);
        int c111 = a.c(d(c110, c109, a128) + a126, this.i[10], 2053994217, this, 15, a127);
        int a129 = a(c109, 10);
        int c112 = a.c(d(c111, c110, a129) + a127, this.i[14], 2053994217, this, 8, a128);
        int a130 = a(c110, 10);
        int c113 = a.c(g(c96, c95, a114) + a112, this.i[4], -1454113458, this, 9, a113);
        int a131 = a(c95, 10);
        int c114 = a.c(g(c113, c96, a131) + a113, this.i[0], -1454113458, this, 15, a114);
        int a132 = a(c96, 10);
        int c115 = a.c(g(c114, c113, a132) + a114, this.i[5], -1454113458, this, 5, a131);
        int a133 = a(c113, 10);
        int c116 = a.c(g(c115, c114, a133) + a131, this.i[9], -1454113458, this, 11, a132);
        int a134 = a(c114, 10);
        int c117 = a.c(g(c116, c115, a134) + a132, this.i[7], -1454113458, this, 6, a133);
        int a135 = a(c115, 10);
        int c118 = a.c(g(c117, c116, a135) + a133, this.i[12], -1454113458, this, 8, a134);
        int a136 = a(c116, 10);
        int c119 = a.c(g(c118, c117, a136) + a134, this.i[2], -1454113458, this, 13, a135);
        int a137 = a(c117, 10);
        int c120 = a.c(g(c119, c118, a137) + a135, this.i[10], -1454113458, this, 12, a136);
        int a138 = a(c118, 10);
        int c121 = a.c(g(c120, c119, a138) + a136, this.i[14], -1454113458, this, 5, a137);
        int a139 = a(c119, 10);
        int c122 = a.c(g(c121, c120, a139) + a137, this.i[1], -1454113458, this, 12, a138);
        int a140 = a(c120, 10);
        int c123 = a.c(g(c122, c121, a140) + a138, this.i[3], -1454113458, this, 13, a139);
        int a141 = a(c121, 10);
        int c124 = a.c(g(c123, c122, a141) + a139, this.i[8], -1454113458, this, 14, a140);
        int a142 = a(c122, 10);
        int c125 = a.c(g(c124, c123, a142) + a140, this.i[11], -1454113458, this, 11, a141);
        int a143 = a(c123, 10);
        int c126 = a.c(g(c125, c124, a143) + a141, this.i[6], -1454113458, this, 8, a142);
        int a144 = a(c124, 10);
        int c127 = a.c(g(c126, c125, a144) + a142, this.i[15], -1454113458, this, 5, a143);
        int a145 = a(c125, 10);
        int c128 = a.c(g(c127, c126, a145) + a143, this.i[13], -1454113458, this, 6, a144);
        int a146 = a(c126, 10);
        int y18 = a.y(c(c112, c111, a130) + a128, this.i[12], this, 8, a129);
        int a147 = a(c111, 10);
        int y19 = a.y(c(y18, c112, a147) + a129, this.i[15], this, 5, a130);
        int a148 = a(c112, 10);
        int y20 = a.y(c(y19, y18, a148) + a130, this.i[10], this, 12, a147);
        int a149 = a(y18, 10);
        int y21 = a.y(c(y20, y19, a149) + a147, this.i[4], this, 9, a148);
        int a150 = a(y19, 10);
        int y22 = a.y(c(y21, y20, a150) + a148, this.i[1], this, 12, a149);
        int a151 = a(y20, 10);
        int y23 = a.y(c(y22, y21, a151) + a149, this.i[5], this, 5, a150);
        int a152 = a(y21, 10);
        int y24 = a.y(c(y23, y22, a152) + a150, this.i[8], this, 14, a151);
        int a153 = a(y22, 10);
        int y25 = a.y(c(y24, y23, a153) + a151, this.i[7], this, 6, a152);
        int a154 = a(y23, 10);
        int y26 = a.y(c(y25, y24, a154) + a152, this.i[6], this, 8, a153);
        int a155 = a(y24, 10);
        int y27 = a.y(c(y26, y25, a155) + a153, this.i[2], this, 13, a154);
        int a156 = a(y25, 10);
        int y28 = a.y(c(y27, y26, a156) + a154, this.i[13], this, 6, a155);
        int a157 = a(y26, 10);
        int y29 = a.y(c(y28, y27, a157) + a155, this.i[14], this, 5, a156);
        int a158 = a(y27, 10);
        int y30 = a.y(c(y29, y28, a158) + a156, this.i[0], this, 15, a157);
        int a159 = a(y28, 10);
        int y31 = a.y(c(y30, y29, a159) + a157, this.i[3], this, 13, a158);
        int a160 = a(y29, 10);
        int y32 = a.y(c(y31, y30, a160) + a158, this.i[9], this, 11, a159);
        int a161 = a(y30, 10);
        int y33 = a.y(c(y32, y31, a161) + a159, this.i[11], this, 11, a160);
        int a162 = this.e + c127 + a(y31, 10);
        this.e = this.f + a146 + a161;
        this.f = this.g + a145 + a160;
        this.g = this.h + a144 + y33;
        this.h = this.d + c128 + y32;
        this.d = a162;
        this.j = 0;
        int i7 = 0;
        while (true) {
            int[] iArr = this.i;
            if (i7 != iArr.length) {
                iArr[i7] = 0;
                i7++;
            } else {
                return;
            }
        }
    }

    @Override // org.spongycastle.crypto.digests.GeneralDigest
    public void processLength(long j2) {
        if (this.j > 14) {
            processBlock();
        }
        int[] iArr = this.i;
        iArr[14] = (int) (-1 & j2);
        iArr[15] = (int) (j2 >>> 32);
    }

    @Override // org.spongycastle.crypto.digests.GeneralDigest
    public void processWord(byte[] bArr, int i2) {
        int[] iArr = this.i;
        int i3 = this.j;
        int i4 = i3 + 1;
        this.j = i4;
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
        this.j = 0;
        int i2 = 0;
        while (true) {
            int[] iArr = this.i;
            if (i2 != iArr.length) {
                iArr[i2] = 0;
                i2++;
            } else {
                return;
            }
        }
    }

    public RIPEMD160Digest(RIPEMD160Digest rIPEMD160Digest) {
        super(rIPEMD160Digest);
        this.i = new int[16];
        b(rIPEMD160Digest);
    }

    @Override // org.spongycastle.util.Memoable
    public void reset(Memoable memoable) {
        b((RIPEMD160Digest) memoable);
    }
}
