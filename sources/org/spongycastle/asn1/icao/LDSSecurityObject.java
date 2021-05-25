package org.spongycastle.asn1.icao;

import java.util.Enumeration;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
public class LDSSecurityObject extends ASN1Object implements ICAOObjectIdentifiers {
    public static final int ub_DataGroups = 16;
    public ASN1Integer a;
    public AlgorithmIdentifier b;
    public DataGroupHash[] c;
    public LDSVersionInfo d;

    public LDSSecurityObject(ASN1Sequence aSN1Sequence) {
        this.a = new ASN1Integer(0);
        if (aSN1Sequence == null || aSN1Sequence.size() == 0) {
            throw new IllegalArgumentException("null or empty sequence passed.");
        }
        Enumeration objects = aSN1Sequence.getObjects();
        this.a = ASN1Integer.getInstance(objects.nextElement());
        this.b = AlgorithmIdentifier.getInstance(objects.nextElement());
        ASN1Sequence instance = ASN1Sequence.getInstance(objects.nextElement());
        if (this.a.getValue().intValue() == 1) {
            this.d = LDSVersionInfo.getInstance(objects.nextElement());
        }
        a(instance.size());
        this.c = new DataGroupHash[instance.size()];
        for (int i = 0; i < instance.size(); i++) {
            this.c[i] = DataGroupHash.getInstance(instance.getObjectAt(i));
        }
    }

    public static LDSSecurityObject getInstance(Object obj) {
        if (obj instanceof LDSSecurityObject) {
            return (LDSSecurityObject) obj;
        }
        if (obj != null) {
            return new LDSSecurityObject(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public final void a(int i) {
        if (i < 2 || i > 16) {
            throw new IllegalArgumentException("wrong size in DataGroupHashValues : not in (2..16)");
        }
    }

    public DataGroupHash[] getDatagroupHash() {
        return this.c;
    }

    public AlgorithmIdentifier getDigestAlgorithmIdentifier() {
        return this.b;
    }

    public int getVersion() {
        return this.a.getValue().intValue();
    }

    public LDSVersionInfo getVersionInfo() {
        return this.d;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.a);
        aSN1EncodableVector.add(this.b);
        ASN1EncodableVector aSN1EncodableVector2 = new ASN1EncodableVector();
        int i = 0;
        while (true) {
            DataGroupHash[] dataGroupHashArr = this.c;
            if (i >= dataGroupHashArr.length) {
                break;
            }
            aSN1EncodableVector2.add(dataGroupHashArr[i]);
            i++;
        }
        aSN1EncodableVector.add(new DERSequence(aSN1EncodableVector2));
        LDSVersionInfo lDSVersionInfo = this.d;
        if (lDSVersionInfo != null) {
            aSN1EncodableVector.add(lDSVersionInfo);
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public LDSSecurityObject(AlgorithmIdentifier algorithmIdentifier, DataGroupHash[] dataGroupHashArr) {
        this.a = new ASN1Integer(0);
        this.a = new ASN1Integer(0);
        this.b = algorithmIdentifier;
        this.c = dataGroupHashArr;
        a(dataGroupHashArr.length);
    }

    public LDSSecurityObject(AlgorithmIdentifier algorithmIdentifier, DataGroupHash[] dataGroupHashArr, LDSVersionInfo lDSVersionInfo) {
        this.a = new ASN1Integer(0);
        this.a = new ASN1Integer(1);
        this.b = algorithmIdentifier;
        this.c = dataGroupHashArr;
        this.d = lDSVersionInfo;
        a(dataGroupHashArr.length);
    }
}
