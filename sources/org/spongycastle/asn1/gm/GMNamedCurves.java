package org.spongycastle.asn1.gm;

import java.math.BigInteger;
import java.util.Enumeration;
import java.util.Hashtable;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.x9.X9ECParameters;
import org.spongycastle.asn1.x9.X9ECParametersHolder;
import org.spongycastle.asn1.x9.X9ECPoint;
import org.spongycastle.math.ec.ECCurve;
import org.spongycastle.util.Strings;
import org.spongycastle.util.encoders.Hex;
public class GMNamedCurves {
    public static X9ECParametersHolder a = new a();
    public static X9ECParametersHolder b = new b();
    public static final Hashtable c;
    public static final Hashtable d;
    public static final Hashtable e;

    public static class a extends X9ECParametersHolder {
        @Override // org.spongycastle.asn1.x9.X9ECParametersHolder
        public X9ECParameters createParameters() {
            BigInteger a = GMNamedCurves.a("FFFFFFFEFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF00000000FFFFFFFFFFFFFFFF");
            BigInteger a3 = GMNamedCurves.a("FFFFFFFEFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF00000000FFFFFFFFFFFFFFFC");
            BigInteger a4 = GMNamedCurves.a("28E9FA9E9D9F5E344D5A9E4BCF6509A7F39789F515AB8F92DDBCBD414D940E93");
            BigInteger a5 = GMNamedCurves.a("FFFFFFFEFFFFFFFFFFFFFFFFFFFFFFFF7203DF6B21C6052B53BBF40939D54123");
            BigInteger valueOf = BigInteger.valueOf(1);
            ECCurve.Fp fp = new ECCurve.Fp(a, a3, a4, a5, valueOf);
            return new X9ECParameters(fp, new X9ECPoint(fp, Hex.decode("0432C4AE2C1F1981195F9904466A39C9948FE30BBFF2660BE1715A4589334C74C7BC3736A2F4F6779C59BDCEE36B692153D0A9877CC62A474002DF32E52139F0A0")), a5, valueOf, (byte[]) null);
        }
    }

    public static class b extends X9ECParametersHolder {
        @Override // org.spongycastle.asn1.x9.X9ECParametersHolder
        public X9ECParameters createParameters() {
            BigInteger a = GMNamedCurves.a("BDB6F4FE3E8B1D9E0DA8C0D46F4C318CEFE4AFE3B6B8551F");
            BigInteger a3 = GMNamedCurves.a("BB8E5E8FBC115E139FE6A814FE48AAA6F0ADA1AA5DF91985");
            BigInteger a4 = GMNamedCurves.a("1854BEBDC31B21B7AEFC80AB0ECD10D5B1B3308E6DBF11C1");
            BigInteger a5 = GMNamedCurves.a("BDB6F4FE3E8B1D9E0DA8C0D40FC962195DFAE76F56564677");
            BigInteger valueOf = BigInteger.valueOf(1);
            ECCurve.Fp fp = new ECCurve.Fp(a, a3, a4, a5, valueOf);
            return new X9ECParameters(fp, new X9ECPoint(fp, Hex.decode("044AD5F7048DE709AD51236DE65E4D4B482C836DC6E410664002BB3A02D4AAADACAE24817A4CA3A1B014B5270432DB27D2")), a5, valueOf, (byte[]) null);
        }
    }

    static {
        Hashtable hashtable = new Hashtable();
        c = hashtable;
        Hashtable hashtable2 = new Hashtable();
        d = hashtable2;
        Hashtable hashtable3 = new Hashtable();
        e = hashtable3;
        ASN1ObjectIdentifier aSN1ObjectIdentifier = GMObjectIdentifiers.wapip192v1;
        X9ECParametersHolder x9ECParametersHolder = b;
        hashtable.put(Strings.toLowerCase("wapip192v1"), aSN1ObjectIdentifier);
        hashtable3.put(aSN1ObjectIdentifier, "wapip192v1");
        hashtable2.put(aSN1ObjectIdentifier, x9ECParametersHolder);
        ASN1ObjectIdentifier aSN1ObjectIdentifier2 = GMObjectIdentifiers.sm2p256v1;
        X9ECParametersHolder x9ECParametersHolder2 = a;
        hashtable.put(Strings.toLowerCase("sm2p256v1"), aSN1ObjectIdentifier2);
        hashtable3.put(aSN1ObjectIdentifier2, "sm2p256v1");
        hashtable2.put(aSN1ObjectIdentifier2, x9ECParametersHolder2);
    }

    public static BigInteger a(String str) {
        return new BigInteger(1, Hex.decode(str));
    }

    public static X9ECParameters getByName(String str) {
        ASN1ObjectIdentifier oid = getOID(str);
        if (oid == null) {
            return null;
        }
        return getByOID(oid);
    }

    public static X9ECParameters getByOID(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        X9ECParametersHolder x9ECParametersHolder = (X9ECParametersHolder) d.get(aSN1ObjectIdentifier);
        if (x9ECParametersHolder == null) {
            return null;
        }
        return x9ECParametersHolder.getParameters();
    }

    public static String getName(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return (String) e.get(aSN1ObjectIdentifier);
    }

    public static Enumeration getNames() {
        return e.elements();
    }

    public static ASN1ObjectIdentifier getOID(String str) {
        return (ASN1ObjectIdentifier) c.get(Strings.toLowerCase(str));
    }
}
