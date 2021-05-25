package org.spongycastle.asn1;

import a2.b.a.a.a;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Objects;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.Strings;
import org.spongycastle.util.encoders.Hex;
public abstract class ASN1OctetString extends ASN1Primitive implements ASN1OctetStringParser {
    public byte[] a;

    public ASN1OctetString(byte[] bArr) {
        Objects.requireNonNull(bArr, "string cannot be null");
        this.a = bArr;
    }

    public static ASN1OctetString getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        ASN1Primitive object = aSN1TaggedObject.getObject();
        if (z || (object instanceof ASN1OctetString)) {
            return getInstance(object);
        }
        ASN1Sequence instance = ASN1Sequence.getInstance(object);
        ASN1OctetString[] aSN1OctetStringArr = new ASN1OctetString[instance.size()];
        Enumeration objects = instance.getObjects();
        int i = 0;
        while (objects.hasMoreElements()) {
            aSN1OctetStringArr[i] = (ASN1OctetString) objects.nextElement();
            i++;
        }
        return new BEROctetString(aSN1OctetStringArr);
    }

    @Override // org.spongycastle.asn1.ASN1Primitive
    public boolean asn1Equals(ASN1Primitive aSN1Primitive) {
        if (!(aSN1Primitive instanceof ASN1OctetString)) {
            return false;
        }
        return Arrays.areEqual(this.a, ((ASN1OctetString) aSN1Primitive).a);
    }

    @Override // org.spongycastle.asn1.ASN1Primitive
    public ASN1Primitive b() {
        return new DEROctetString(this.a);
    }

    @Override // org.spongycastle.asn1.ASN1Primitive
    public ASN1Primitive c() {
        return new DEROctetString(this.a);
    }

    @Override // org.spongycastle.asn1.InMemoryRepresentable
    public ASN1Primitive getLoadedObject() {
        return toASN1Primitive();
    }

    @Override // org.spongycastle.asn1.ASN1OctetStringParser
    public InputStream getOctetStream() {
        return new ByteArrayInputStream(this.a);
    }

    public byte[] getOctets() {
        return this.a;
    }

    @Override // org.spongycastle.asn1.ASN1Primitive, org.spongycastle.asn1.ASN1Object
    public int hashCode() {
        return Arrays.hashCode(getOctets());
    }

    public ASN1OctetStringParser parser() {
        return this;
    }

    public String toString() {
        StringBuilder L = a.L("#");
        L.append(Strings.fromByteArray(Hex.encode(this.a)));
        return L.toString();
    }

    public static ASN1OctetString getInstance(Object obj) {
        if (obj == null || (obj instanceof ASN1OctetString)) {
            return (ASN1OctetString) obj;
        }
        if (obj instanceof byte[]) {
            try {
                return getInstance(ASN1Primitive.fromByteArray((byte[]) obj));
            } catch (IOException e) {
                throw new IllegalArgumentException(a.A2(e, a.L("failed to construct OCTET STRING from byte[]: ")));
            }
        } else {
            if (obj instanceof ASN1Encodable) {
                ASN1Primitive aSN1Primitive = ((ASN1Encodable) obj).toASN1Primitive();
                if (aSN1Primitive instanceof ASN1OctetString) {
                    return (ASN1OctetString) aSN1Primitive;
                }
            }
            throw new IllegalArgumentException(a.H2(obj, a.L("illegal object in getInstance: ")));
        }
    }
}
