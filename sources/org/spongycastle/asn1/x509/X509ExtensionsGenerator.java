package org.spongycastle.asn1.x509;

import a2.b.a.a.a;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Vector;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1Encoding;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.DEROctetString;
public class X509ExtensionsGenerator {
    public Hashtable a = new Hashtable();
    public Vector b = new Vector();

    public void addExtension(ASN1ObjectIdentifier aSN1ObjectIdentifier, boolean z, ASN1Encodable aSN1Encodable) {
        try {
            addExtension(aSN1ObjectIdentifier, z, aSN1Encodable.toASN1Primitive().getEncoded(ASN1Encoding.DER));
        } catch (IOException e) {
            throw new IllegalArgumentException(a.Z2("error encoding value: ", e));
        }
    }

    public X509Extensions generate() {
        return new X509Extensions(this.b, this.a);
    }

    public boolean isEmpty() {
        return this.b.isEmpty();
    }

    public void reset() {
        this.a = new Hashtable();
        this.b = new Vector();
    }

    public void addExtension(ASN1ObjectIdentifier aSN1ObjectIdentifier, boolean z, byte[] bArr) {
        if (!this.a.containsKey(aSN1ObjectIdentifier)) {
            this.b.addElement(aSN1ObjectIdentifier);
            this.a.put(aSN1ObjectIdentifier, new X509Extension(z, new DEROctetString(bArr)));
            return;
        }
        throw new IllegalArgumentException(a.h("extension ", aSN1ObjectIdentifier, " already added"));
    }
}
