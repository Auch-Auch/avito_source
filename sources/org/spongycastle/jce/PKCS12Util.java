package org.spongycastle.jce;

import a2.b.a.a.a;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import org.spongycastle.asn1.ASN1InputStream;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.DERNull;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.DEROutputStream;
import org.spongycastle.asn1.pkcs.ContentInfo;
import org.spongycastle.asn1.pkcs.MacData;
import org.spongycastle.asn1.pkcs.Pfx;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.asn1.x509.DigestInfo;
public class PKCS12Util {
    public static byte[] convertToDefiniteLength(byte[] bArr) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DEROutputStream dEROutputStream = new DEROutputStream(byteArrayOutputStream);
        Pfx instance = Pfx.getInstance(bArr);
        byteArrayOutputStream.reset();
        dEROutputStream.writeObject(instance);
        return byteArrayOutputStream.toByteArray();
    }

    public static byte[] convertToDefiniteLength(byte[] bArr, char[] cArr, String str) throws IOException {
        Pfx instance = Pfx.getInstance(bArr);
        ContentInfo authSafe = instance.getAuthSafe();
        ASN1OctetString instance2 = ASN1OctetString.getInstance(authSafe.getContent());
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DEROutputStream dEROutputStream = new DEROutputStream(byteArrayOutputStream);
        dEROutputStream.writeObject(new ASN1InputStream(instance2.getOctets()).readObject());
        ContentInfo contentInfo = new ContentInfo(authSafe.getContentType(), new DEROctetString(byteArrayOutputStream.toByteArray()));
        MacData macData = instance.getMacData();
        try {
            int intValue = macData.getIterationCount().intValue();
            byte[] octets = ASN1OctetString.getInstance(contentInfo.getContent()).getOctets();
            ASN1ObjectIdentifier algorithm = macData.getMac().getAlgorithmId().getAlgorithm();
            byte[] salt = macData.getSalt();
            SecretKeyFactory instance3 = SecretKeyFactory.getInstance(algorithm.getId(), str);
            PBEParameterSpec pBEParameterSpec = new PBEParameterSpec(salt, intValue);
            SecretKey generateSecret = instance3.generateSecret(new PBEKeySpec(cArr));
            Mac instance4 = Mac.getInstance(algorithm.getId(), str);
            instance4.init(generateSecret, pBEParameterSpec);
            instance4.update(octets);
            Pfx pfx = new Pfx(contentInfo, new MacData(new DigestInfo(new AlgorithmIdentifier(macData.getMac().getAlgorithmId().getAlgorithm(), DERNull.INSTANCE), instance4.doFinal()), macData.getSalt(), intValue));
            byteArrayOutputStream.reset();
            dEROutputStream.writeObject(pfx);
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e) {
            throw new IOException(a.G2(e, a.L("error constructing MAC: ")));
        }
    }
}
