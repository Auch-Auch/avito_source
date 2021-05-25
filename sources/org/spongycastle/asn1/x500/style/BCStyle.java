package org.spongycastle.asn1.x500.style;

import a2.b.a.a.a;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.appevents.UserDataStore;
import java.util.Hashtable;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1GeneralizedTime;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.DERIA5String;
import org.spongycastle.asn1.DERPrintableString;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.asn1.x500.RDN;
import org.spongycastle.asn1.x500.X500Name;
import org.spongycastle.asn1.x500.X500NameStyle;
import org.spongycastle.asn1.x509.X509ObjectIdentifiers;
public class BCStyle extends AbstractX500NameStyle {
    public static final ASN1ObjectIdentifier BUSINESS_CATEGORY;
    public static final ASN1ObjectIdentifier C;
    public static final ASN1ObjectIdentifier CN;
    public static final ASN1ObjectIdentifier COUNTRY_OF_CITIZENSHIP;
    public static final ASN1ObjectIdentifier COUNTRY_OF_RESIDENCE;
    public static final ASN1ObjectIdentifier DATE_OF_BIRTH;
    public static final ASN1ObjectIdentifier DC;
    public static final ASN1ObjectIdentifier DMD_NAME = a.y0("2.5.4.54");
    public static final ASN1ObjectIdentifier DN_QUALIFIER;
    public static final ASN1ObjectIdentifier E;
    public static final ASN1ObjectIdentifier EmailAddress;
    public static final ASN1ObjectIdentifier GENDER;
    public static final ASN1ObjectIdentifier GENERATION;
    public static final ASN1ObjectIdentifier GIVENNAME;
    public static final ASN1ObjectIdentifier INITIALS;
    public static final X500NameStyle INSTANCE = new BCStyle();
    public static final ASN1ObjectIdentifier L;
    public static final ASN1ObjectIdentifier NAME;
    public static final ASN1ObjectIdentifier NAME_AT_BIRTH;
    public static final ASN1ObjectIdentifier O;
    public static final ASN1ObjectIdentifier ORGANIZATION_IDENTIFIER;
    public static final ASN1ObjectIdentifier OU;
    public static final ASN1ObjectIdentifier PLACE_OF_BIRTH;
    public static final ASN1ObjectIdentifier POSTAL_ADDRESS;
    public static final ASN1ObjectIdentifier POSTAL_CODE;
    public static final ASN1ObjectIdentifier PSEUDONYM;
    public static final ASN1ObjectIdentifier SERIALNUMBER;
    public static final ASN1ObjectIdentifier SN;
    public static final ASN1ObjectIdentifier ST;
    public static final ASN1ObjectIdentifier STREET;
    public static final ASN1ObjectIdentifier SURNAME;
    public static final ASN1ObjectIdentifier T;
    public static final ASN1ObjectIdentifier TELEPHONE_NUMBER;
    public static final ASN1ObjectIdentifier UID;
    public static final ASN1ObjectIdentifier UNIQUE_IDENTIFIER;
    public static final ASN1ObjectIdentifier UnstructuredAddress;
    public static final ASN1ObjectIdentifier UnstructuredName;
    public static final Hashtable a;
    public static final Hashtable b;
    public final Hashtable defaultLookUp = AbstractX500NameStyle.copyHashTable(b);
    public final Hashtable defaultSymbols = AbstractX500NameStyle.copyHashTable(a);

    static {
        ASN1ObjectIdentifier y0 = a.y0("2.5.4.6");
        C = y0;
        ASN1ObjectIdentifier y02 = a.y0("2.5.4.10");
        O = y02;
        ASN1ObjectIdentifier y03 = a.y0("2.5.4.11");
        OU = y03;
        ASN1ObjectIdentifier y04 = a.y0("2.5.4.12");
        T = y04;
        ASN1ObjectIdentifier y05 = a.y0("2.5.4.3");
        CN = y05;
        ASN1ObjectIdentifier y06 = a.y0("2.5.4.5");
        SN = y06;
        ASN1ObjectIdentifier y07 = a.y0("2.5.4.9");
        STREET = y07;
        SERIALNUMBER = y06;
        ASN1ObjectIdentifier y08 = a.y0("2.5.4.7");
        L = y08;
        ASN1ObjectIdentifier y09 = a.y0("2.5.4.8");
        ST = y09;
        ASN1ObjectIdentifier y010 = a.y0("2.5.4.4");
        SURNAME = y010;
        ASN1ObjectIdentifier y011 = a.y0("2.5.4.42");
        GIVENNAME = y011;
        ASN1ObjectIdentifier y012 = a.y0("2.5.4.43");
        INITIALS = y012;
        ASN1ObjectIdentifier y013 = a.y0("2.5.4.44");
        GENERATION = y013;
        ASN1ObjectIdentifier y014 = a.y0("2.5.4.45");
        UNIQUE_IDENTIFIER = y014;
        ASN1ObjectIdentifier y015 = a.y0("2.5.4.15");
        BUSINESS_CATEGORY = y015;
        ASN1ObjectIdentifier y016 = a.y0("2.5.4.17");
        POSTAL_CODE = y016;
        ASN1ObjectIdentifier y017 = a.y0("2.5.4.46");
        DN_QUALIFIER = y017;
        ASN1ObjectIdentifier y018 = a.y0("2.5.4.65");
        PSEUDONYM = y018;
        ASN1ObjectIdentifier y019 = a.y0("1.3.6.1.5.5.7.9.1");
        DATE_OF_BIRTH = y019;
        ASN1ObjectIdentifier y020 = a.y0("1.3.6.1.5.5.7.9.2");
        PLACE_OF_BIRTH = y020;
        ASN1ObjectIdentifier y021 = a.y0("1.3.6.1.5.5.7.9.3");
        GENDER = y021;
        ASN1ObjectIdentifier y022 = a.y0("1.3.6.1.5.5.7.9.4");
        COUNTRY_OF_CITIZENSHIP = y022;
        ASN1ObjectIdentifier y023 = a.y0("1.3.6.1.5.5.7.9.5");
        COUNTRY_OF_RESIDENCE = y023;
        ASN1ObjectIdentifier y024 = a.y0("1.3.36.8.3.14");
        NAME_AT_BIRTH = y024;
        ASN1ObjectIdentifier y025 = a.y0("2.5.4.16");
        POSTAL_ADDRESS = y025;
        ASN1ObjectIdentifier aSN1ObjectIdentifier = X509ObjectIdentifiers.id_at_telephoneNumber;
        TELEPHONE_NUMBER = aSN1ObjectIdentifier;
        ASN1ObjectIdentifier aSN1ObjectIdentifier2 = X509ObjectIdentifiers.id_at_name;
        NAME = aSN1ObjectIdentifier2;
        ASN1ObjectIdentifier aSN1ObjectIdentifier3 = X509ObjectIdentifiers.id_at_organizationIdentifier;
        ORGANIZATION_IDENTIFIER = aSN1ObjectIdentifier3;
        ASN1ObjectIdentifier aSN1ObjectIdentifier4 = PKCSObjectIdentifiers.pkcs_9_at_emailAddress;
        EmailAddress = aSN1ObjectIdentifier4;
        ASN1ObjectIdentifier aSN1ObjectIdentifier5 = PKCSObjectIdentifiers.pkcs_9_at_unstructuredName;
        UnstructuredName = aSN1ObjectIdentifier5;
        ASN1ObjectIdentifier aSN1ObjectIdentifier6 = PKCSObjectIdentifiers.pkcs_9_at_unstructuredAddress;
        UnstructuredAddress = aSN1ObjectIdentifier6;
        E = aSN1ObjectIdentifier4;
        ASN1ObjectIdentifier aSN1ObjectIdentifier7 = new ASN1ObjectIdentifier("0.9.2342.19200300.100.1.25");
        DC = aSN1ObjectIdentifier7;
        ASN1ObjectIdentifier aSN1ObjectIdentifier8 = new ASN1ObjectIdentifier("0.9.2342.19200300.100.1.1");
        UID = aSN1ObjectIdentifier8;
        Hashtable hashtable = new Hashtable();
        a = hashtable;
        Hashtable hashtable2 = new Hashtable();
        b = hashtable2;
        hashtable.put(y0, "C");
        hashtable.put(y02, "O");
        hashtable.put(y04, "T");
        hashtable.put(y03, "OU");
        hashtable.put(y05, "CN");
        hashtable.put(y08, "L");
        hashtable.put(y09, "ST");
        hashtable.put(y06, "SERIALNUMBER");
        hashtable.put(aSN1ObjectIdentifier4, ExifInterface.LONGITUDE_EAST);
        hashtable.put(aSN1ObjectIdentifier7, "DC");
        hashtable.put(aSN1ObjectIdentifier8, "UID");
        hashtable.put(y07, "STREET");
        hashtable.put(y010, "SURNAME");
        hashtable.put(y011, "GIVENNAME");
        hashtable.put(y012, "INITIALS");
        hashtable.put(y013, "GENERATION");
        hashtable.put(aSN1ObjectIdentifier6, "unstructuredAddress");
        hashtable.put(aSN1ObjectIdentifier5, "unstructuredName");
        hashtable.put(y014, "UniqueIdentifier");
        hashtable.put(y017, "DN");
        hashtable.put(y018, "Pseudonym");
        hashtable.put(y025, "PostalAddress");
        hashtable.put(y024, "NameAtBirth");
        hashtable.put(y022, "CountryOfCitizenship");
        hashtable.put(y023, "CountryOfResidence");
        hashtable.put(y021, "Gender");
        hashtable.put(y020, "PlaceOfBirth");
        hashtable.put(y019, "DateOfBirth");
        hashtable.put(y016, "PostalCode");
        hashtable.put(y015, "BusinessCategory");
        hashtable.put(aSN1ObjectIdentifier, "TelephoneNumber");
        hashtable.put(aSN1ObjectIdentifier2, "Name");
        hashtable.put(aSN1ObjectIdentifier3, "organizationIdentifier");
        hashtable2.put("c", y0);
        hashtable2.put("o", y02);
        hashtable2.put("t", y04);
        hashtable2.put("ou", y03);
        hashtable2.put("cn", y05);
        hashtable2.put("l", y08);
        hashtable2.put(UserDataStore.STATE, y09);
        hashtable2.put("sn", y06);
        hashtable2.put("serialnumber", y06);
        hashtable2.put("street", y07);
        hashtable2.put("emailaddress", aSN1ObjectIdentifier4);
        hashtable2.put("dc", aSN1ObjectIdentifier7);
        hashtable2.put("e", aSN1ObjectIdentifier4);
        hashtable2.put("uid", aSN1ObjectIdentifier8);
        hashtable2.put("surname", y010);
        hashtable2.put("givenname", y011);
        hashtable2.put("initials", y012);
        hashtable2.put("generation", y013);
        hashtable2.put("unstructuredaddress", aSN1ObjectIdentifier6);
        hashtable2.put("unstructuredname", aSN1ObjectIdentifier5);
        hashtable2.put("uniqueidentifier", y014);
        hashtable2.put("dn", y017);
        hashtable2.put("pseudonym", y018);
        hashtable2.put("postaladdress", y025);
        hashtable2.put("nameofbirth", y024);
        hashtable2.put("countryofcitizenship", y022);
        hashtable2.put("countryofresidence", y023);
        hashtable2.put("gender", y021);
        hashtable2.put("placeofbirth", y020);
        hashtable2.put("dateofbirth", y019);
        hashtable2.put("postalcode", y016);
        hashtable2.put("businesscategory", y015);
        hashtable2.put("telephonenumber", aSN1ObjectIdentifier);
        hashtable2.put("name", aSN1ObjectIdentifier2);
        hashtable2.put("organizationidentifier", aSN1ObjectIdentifier3);
    }

    @Override // org.spongycastle.asn1.x500.X500NameStyle
    public ASN1ObjectIdentifier attrNameToOID(String str) {
        return IETFUtils.decodeAttrName(str, this.defaultLookUp);
    }

    @Override // org.spongycastle.asn1.x500.style.AbstractX500NameStyle
    public ASN1Encodable encodeStringValue(ASN1ObjectIdentifier aSN1ObjectIdentifier, String str) {
        if (aSN1ObjectIdentifier.equals(EmailAddress) || aSN1ObjectIdentifier.equals(DC)) {
            return new DERIA5String(str);
        }
        if (aSN1ObjectIdentifier.equals(DATE_OF_BIRTH)) {
            return new ASN1GeneralizedTime(str);
        }
        if (aSN1ObjectIdentifier.equals(C) || aSN1ObjectIdentifier.equals(SN) || aSN1ObjectIdentifier.equals(DN_QUALIFIER) || aSN1ObjectIdentifier.equals(TELEPHONE_NUMBER)) {
            return new DERPrintableString(str);
        }
        return super.encodeStringValue(aSN1ObjectIdentifier, str);
    }

    @Override // org.spongycastle.asn1.x500.X500NameStyle
    public RDN[] fromString(String str) {
        return IETFUtils.rDNsFromString(str, this);
    }

    @Override // org.spongycastle.asn1.x500.X500NameStyle
    public String[] oidToAttrNames(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return IETFUtils.findAttrNamesForOID(aSN1ObjectIdentifier, this.defaultLookUp);
    }

    @Override // org.spongycastle.asn1.x500.X500NameStyle
    public String oidToDisplayName(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return (String) a.get(aSN1ObjectIdentifier);
    }

    @Override // org.spongycastle.asn1.x500.X500NameStyle
    public String toString(X500Name x500Name) {
        RDN[] rDNs;
        StringBuffer stringBuffer = new StringBuffer();
        boolean z = true;
        for (RDN rdn : x500Name.getRDNs()) {
            if (z) {
                z = false;
            } else {
                stringBuffer.append(',');
            }
            IETFUtils.appendRDN(stringBuffer, rdn, this.defaultSymbols);
        }
        return stringBuffer.toString();
    }
}
