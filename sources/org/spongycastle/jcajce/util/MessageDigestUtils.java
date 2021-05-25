package org.spongycastle.jcajce.util;

import com.adjust.sdk.Constants;
import java.util.HashMap;
import java.util.Map;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import org.spongycastle.asn1.gm.GMObjectIdentifiers;
import org.spongycastle.asn1.gnu.GNUObjectIdentifiers;
import org.spongycastle.asn1.iso.ISOIECObjectIdentifiers;
import org.spongycastle.asn1.nist.NISTObjectIdentifiers;
import org.spongycastle.asn1.oiw.OIWObjectIdentifiers;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.asn1.teletrust.TeleTrusTObjectIdentifiers;
import org.spongycastle.pqc.jcajce.spec.McElieceCCA2KeyGenParameterSpec;
import org.spongycastle.pqc.jcajce.spec.SPHINCS256KeyGenParameterSpec;
public class MessageDigestUtils {
    public static Map<ASN1ObjectIdentifier, String> a;

    static {
        HashMap hashMap = new HashMap();
        a = hashMap;
        hashMap.put(PKCSObjectIdentifiers.md2, "MD2");
        a.put(PKCSObjectIdentifiers.md4, "MD4");
        a.put(PKCSObjectIdentifiers.md5, Constants.MD5);
        a.put(OIWObjectIdentifiers.idSHA1, "SHA-1");
        a.put(NISTObjectIdentifiers.id_sha224, McElieceCCA2KeyGenParameterSpec.SHA224);
        a.put(NISTObjectIdentifiers.id_sha256, "SHA-256");
        a.put(NISTObjectIdentifiers.id_sha384, McElieceCCA2KeyGenParameterSpec.SHA384);
        a.put(NISTObjectIdentifiers.id_sha512, McElieceCCA2KeyGenParameterSpec.SHA512);
        a.put(TeleTrusTObjectIdentifiers.ripemd128, "RIPEMD-128");
        a.put(TeleTrusTObjectIdentifiers.ripemd160, "RIPEMD-160");
        a.put(TeleTrusTObjectIdentifiers.ripemd256, "RIPEMD-128");
        a.put(ISOIECObjectIdentifiers.ripemd128, "RIPEMD-128");
        a.put(ISOIECObjectIdentifiers.ripemd160, "RIPEMD-160");
        a.put(CryptoProObjectIdentifiers.gostR3411, "GOST3411");
        a.put(GNUObjectIdentifiers.Tiger_192, "Tiger");
        a.put(ISOIECObjectIdentifiers.whirlpool, "Whirlpool");
        a.put(NISTObjectIdentifiers.id_sha3_224, "SHA3-224");
        a.put(NISTObjectIdentifiers.id_sha3_256, SPHINCS256KeyGenParameterSpec.SHA3_256);
        a.put(NISTObjectIdentifiers.id_sha3_384, "SHA3-384");
        a.put(NISTObjectIdentifiers.id_sha3_512, "SHA3-512");
        a.put(GMObjectIdentifiers.sm3, "SM3");
    }

    public static String getDigestName(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        String str = a.get(aSN1ObjectIdentifier);
        if (str != null) {
            return str;
        }
        return aSN1ObjectIdentifier.getId();
    }
}
