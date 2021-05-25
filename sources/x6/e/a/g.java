package x6.e.a;

import java.io.IOException;
import java.util.Enumeration;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1OutputStream;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
public class g extends ASN1Sequence {
    public byte[] a;

    public g(byte[] bArr) throws IOException {
        this.a = bArr;
    }

    @Override // org.spongycastle.asn1.ASN1Primitive
    public int a() throws IOException {
        byte[] bArr = this.a;
        if (bArr != null) {
            return i.a(bArr.length) + 1 + this.a.length;
        }
        return super.c().a();
    }

    @Override // org.spongycastle.asn1.ASN1Sequence, org.spongycastle.asn1.ASN1Primitive
    public ASN1Primitive b() {
        if (this.a != null) {
            e();
        }
        return super.b();
    }

    @Override // org.spongycastle.asn1.ASN1Sequence, org.spongycastle.asn1.ASN1Primitive
    public ASN1Primitive c() {
        if (this.a != null) {
            e();
        }
        return super.c();
    }

    public final void e() {
        f fVar = new f(this.a);
        while (fVar.hasMoreElements()) {
            this.seq.addElement(fVar.nextElement());
        }
        this.a = null;
    }

    @Override // org.spongycastle.asn1.ASN1Primitive
    public void encode(ASN1OutputStream aSN1OutputStream) throws IOException {
        byte[] bArr = this.a;
        if (bArr != null) {
            aSN1OutputStream.e(48, bArr);
        } else {
            super.c().encode(aSN1OutputStream);
        }
    }

    @Override // org.spongycastle.asn1.ASN1Sequence
    public synchronized ASN1Encodable getObjectAt(int i) {
        if (this.a != null) {
            e();
        }
        return super.getObjectAt(i);
    }

    @Override // org.spongycastle.asn1.ASN1Sequence
    public synchronized Enumeration getObjects() {
        byte[] bArr = this.a;
        if (bArr == null) {
            return super.getObjects();
        }
        return new f(bArr);
    }

    @Override // org.spongycastle.asn1.ASN1Sequence
    public synchronized int size() {
        if (this.a != null) {
            e();
        }
        return super.size();
    }
}
