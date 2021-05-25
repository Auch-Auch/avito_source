package org.spongycastle.asn1.dvcs;

import java.math.BigInteger;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;
import org.spongycastle.asn1.x509.Extensions;
import org.spongycastle.asn1.x509.GeneralName;
import org.spongycastle.asn1.x509.GeneralNames;
import org.spongycastle.asn1.x509.PolicyInformation;
import org.spongycastle.util.BigIntegers;
public class DVCSRequestInformationBuilder {
    public int a = 1;
    public final ServiceType b;
    public DVCSRequestInformation c;
    public BigInteger d;
    public DVCSTime e;
    public GeneralNames f;
    public PolicyInformation g;
    public GeneralNames h;
    public GeneralNames i;
    public Extensions j;

    public DVCSRequestInformationBuilder(ServiceType serviceType) {
        this.b = serviceType;
    }

    public DVCSRequestInformation build() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        int i2 = this.a;
        if (i2 != 1) {
            aSN1EncodableVector.add(new ASN1Integer((long) i2));
        }
        aSN1EncodableVector.add(this.b);
        BigInteger bigInteger = this.d;
        if (bigInteger != null) {
            aSN1EncodableVector.add(new ASN1Integer(bigInteger));
        }
        DVCSTime dVCSTime = this.e;
        if (dVCSTime != null) {
            aSN1EncodableVector.add(dVCSTime);
        }
        int[] iArr = {0, 1, 2, 3, 4};
        ASN1Encodable[] aSN1EncodableArr = {this.f, this.g, this.h, this.i, this.j};
        for (int i3 = 0; i3 < 5; i3++) {
            int i4 = iArr[i3];
            ASN1Encodable aSN1Encodable = aSN1EncodableArr[i3];
            if (aSN1Encodable != null) {
                aSN1EncodableVector.add(new DERTaggedObject(false, i4, aSN1Encodable));
            }
        }
        return DVCSRequestInformation.getInstance(new DERSequence(aSN1EncodableVector));
    }

    public void setDVCS(GeneralName generalName) {
        setDVCS(new GeneralNames(generalName));
    }

    public void setDataLocations(GeneralName generalName) {
        setDataLocations(new GeneralNames(generalName));
    }

    public void setExtensions(Extensions extensions) {
        if (this.c == null) {
            this.j = extensions;
            return;
        }
        throw new IllegalStateException("cannot change extensions in existing DVCSRequestInformation");
    }

    public void setNonce(BigInteger bigInteger) {
        DVCSRequestInformation dVCSRequestInformation = this.c;
        if (dVCSRequestInformation != null) {
            if (dVCSRequestInformation.getNonce() == null) {
                this.d = bigInteger;
            } else {
                byte[] byteArray = this.c.getNonce().toByteArray();
                byte[] asUnsignedByteArray = BigIntegers.asUnsignedByteArray(bigInteger);
                byte[] bArr = new byte[(byteArray.length + asUnsignedByteArray.length)];
                System.arraycopy(byteArray, 0, bArr, 0, byteArray.length);
                System.arraycopy(asUnsignedByteArray, 0, bArr, byteArray.length, asUnsignedByteArray.length);
                this.d = new BigInteger(bArr);
            }
        }
        this.d = bigInteger;
    }

    public void setRequestPolicy(PolicyInformation policyInformation) {
        if (this.c == null) {
            this.g = policyInformation;
            return;
        }
        throw new IllegalStateException("cannot change request policy in existing DVCSRequestInformation");
    }

    public void setRequestTime(DVCSTime dVCSTime) {
        if (this.c == null) {
            this.e = dVCSTime;
            return;
        }
        throw new IllegalStateException("cannot change request time in existing DVCSRequestInformation");
    }

    public void setRequester(GeneralName generalName) {
        setRequester(new GeneralNames(generalName));
    }

    public void setVersion(int i2) {
        if (this.c == null) {
            this.a = i2;
            return;
        }
        throw new IllegalStateException("cannot change version in existing DVCSRequestInformation");
    }

    public void setDVCS(GeneralNames generalNames) {
        this.h = generalNames;
    }

    public void setDataLocations(GeneralNames generalNames) {
        this.i = generalNames;
    }

    public void setRequester(GeneralNames generalNames) {
        this.f = generalNames;
    }

    public DVCSRequestInformationBuilder(DVCSRequestInformation dVCSRequestInformation) {
        this.c = dVCSRequestInformation;
        this.b = dVCSRequestInformation.getService();
        this.a = dVCSRequestInformation.getVersion();
        this.d = dVCSRequestInformation.getNonce();
        this.e = dVCSRequestInformation.getRequestTime();
        this.g = dVCSRequestInformation.getRequestPolicy();
        this.h = dVCSRequestInformation.getDVCS();
        this.i = dVCSRequestInformation.getDataLocations();
    }
}
