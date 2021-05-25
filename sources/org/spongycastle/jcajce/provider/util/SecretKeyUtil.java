package org.spongycastle.jcajce.provider.util;

import java.util.HashMap;
import java.util.Map;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.nist.NISTObjectIdentifiers;
import org.spongycastle.asn1.ntt.NTTObjectIdentifiers;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.util.Integers;
public class SecretKeyUtil {
    public static Map a;

    static {
        HashMap hashMap = new HashMap();
        a = hashMap;
        hashMap.put(PKCSObjectIdentifiers.des_EDE3_CBC.getId(), Integers.valueOf(192));
        a.put(NISTObjectIdentifiers.id_aes128_CBC, Integers.valueOf(128));
        a.put(NISTObjectIdentifiers.id_aes192_CBC, Integers.valueOf(192));
        a.put(NISTObjectIdentifiers.id_aes256_CBC, Integers.valueOf(256));
        a.put(NTTObjectIdentifiers.id_camellia128_cbc, Integers.valueOf(128));
        a.put(NTTObjectIdentifiers.id_camellia192_cbc, Integers.valueOf(192));
        a.put(NTTObjectIdentifiers.id_camellia256_cbc, Integers.valueOf(256));
    }

    public static int getKeySize(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        Integer num = (Integer) a.get(aSN1ObjectIdentifier);
        if (num != null) {
            return num.intValue();
        }
        return -1;
    }
}
