package org.spongycastle.crypto.util;

import androidx.appcompat.app.AppCompatDelegateImpl;
import java.io.IOException;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
public class DEROtherInfo {
    public final DERSequence a;

    public static final class Builder {
        public final AlgorithmIdentifier a;
        public final ASN1OctetString b;
        public final ASN1OctetString c;
        public ASN1TaggedObject d;
        public ASN1TaggedObject e;

        public Builder(AlgorithmIdentifier algorithmIdentifier, byte[] bArr, byte[] bArr2) {
            this.a = algorithmIdentifier;
            this.b = AppCompatDelegateImpl.i.G0(bArr);
            this.c = AppCompatDelegateImpl.i.G0(bArr2);
        }

        public DEROtherInfo build() {
            ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
            aSN1EncodableVector.add(this.a);
            aSN1EncodableVector.add(this.b);
            aSN1EncodableVector.add(this.c);
            ASN1TaggedObject aSN1TaggedObject = this.d;
            if (aSN1TaggedObject != null) {
                aSN1EncodableVector.add(aSN1TaggedObject);
            }
            ASN1TaggedObject aSN1TaggedObject2 = this.e;
            if (aSN1TaggedObject2 != null) {
                aSN1EncodableVector.add(aSN1TaggedObject2);
            }
            return new DEROtherInfo(new DERSequence(aSN1EncodableVector), null);
        }

        public Builder withSuppPrivInfo(byte[] bArr) {
            this.e = new DERTaggedObject(false, 1, AppCompatDelegateImpl.i.G0(bArr));
            return this;
        }

        public Builder withSuppPubInfo(byte[] bArr) {
            this.d = new DERTaggedObject(false, 0, AppCompatDelegateImpl.i.G0(bArr));
            return this;
        }
    }

    public DEROtherInfo(DERSequence dERSequence, a aVar) {
        this.a = dERSequence;
    }

    public byte[] getEncoded() throws IOException {
        return this.a.getEncoded();
    }
}
