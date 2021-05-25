package org.spongycastle.asn1.x509;

import a2.b.a.a.a;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Vector;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1Encoding;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.DEROctetString;
public class ExtensionsGenerator {
    public Hashtable a = new Hashtable();
    public Vector b = new Vector();

    public void addExtension(ASN1ObjectIdentifier aSN1ObjectIdentifier, boolean z, ASN1Encodable aSN1Encodable) throws IOException {
        addExtension(aSN1ObjectIdentifier, z, aSN1Encodable.toASN1Primitive().getEncoded(ASN1Encoding.DER));
    }

    public Extensions generate() {
        Extension[] extensionArr = new Extension[this.b.size()];
        for (int i = 0; i != this.b.size(); i++) {
            extensionArr[i] = (Extension) this.a.get(this.b.elementAt(i));
        }
        return new Extensions(extensionArr);
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
            this.a.put(aSN1ObjectIdentifier, new Extension(aSN1ObjectIdentifier, z, new DEROctetString(bArr)));
            return;
        }
        throw new IllegalArgumentException(a.h("extension ", aSN1ObjectIdentifier, " already added"));
    }

    public void addExtension(Extension extension) {
        if (!this.a.containsKey(extension.getExtnId())) {
            this.b.addElement(extension.getExtnId());
            this.a.put(extension.getExtnId(), extension);
            return;
        }
        StringBuilder L = a.L("extension ");
        L.append(extension.getExtnId());
        L.append(" already added");
        throw new IllegalArgumentException(L.toString());
    }
}
