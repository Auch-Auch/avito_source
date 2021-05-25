package org.spongycastle.asn1.x500.style;

import a2.b.a.a.a;
import com.avito.android.util.UrlParams;
import com.facebook.appevents.UserDataStore;
import java.util.Hashtable;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.DERIA5String;
import org.spongycastle.asn1.DERPrintableString;
import org.spongycastle.asn1.x500.RDN;
import org.spongycastle.asn1.x500.X500Name;
import org.spongycastle.asn1.x500.X500NameStyle;
public class RFC4519Style extends AbstractX500NameStyle {
    public static final X500NameStyle INSTANCE = new RFC4519Style();
    public static final Hashtable a;
    public static final Hashtable b;
    public static final ASN1ObjectIdentifier businessCategory;
    public static final ASN1ObjectIdentifier c;
    public static final ASN1ObjectIdentifier cn;
    public static final ASN1ObjectIdentifier dc;
    public static final ASN1ObjectIdentifier description;
    public static final ASN1ObjectIdentifier destinationIndicator;
    public static final ASN1ObjectIdentifier distinguishedName;
    public static final ASN1ObjectIdentifier dnQualifier;
    public static final ASN1ObjectIdentifier enhancedSearchGuide;
    public static final ASN1ObjectIdentifier facsimileTelephoneNumber;
    public static final ASN1ObjectIdentifier generationQualifier;
    public static final ASN1ObjectIdentifier givenName;
    public static final ASN1ObjectIdentifier houseIdentifier;
    public static final ASN1ObjectIdentifier initials;
    public static final ASN1ObjectIdentifier internationalISDNNumber;
    public static final ASN1ObjectIdentifier l;
    public static final ASN1ObjectIdentifier member;
    public static final ASN1ObjectIdentifier name;
    public static final ASN1ObjectIdentifier o;
    public static final ASN1ObjectIdentifier ou;
    public static final ASN1ObjectIdentifier owner;
    public static final ASN1ObjectIdentifier physicalDeliveryOfficeName;
    public static final ASN1ObjectIdentifier postOfficeBox;
    public static final ASN1ObjectIdentifier postalAddress;
    public static final ASN1ObjectIdentifier postalCode;
    public static final ASN1ObjectIdentifier preferredDeliveryMethod;
    public static final ASN1ObjectIdentifier registeredAddress;
    public static final ASN1ObjectIdentifier roleOccupant;
    public static final ASN1ObjectIdentifier searchGuide;
    public static final ASN1ObjectIdentifier seeAlso;
    public static final ASN1ObjectIdentifier serialNumber;
    public static final ASN1ObjectIdentifier sn;
    public static final ASN1ObjectIdentifier st;
    public static final ASN1ObjectIdentifier street;
    public static final ASN1ObjectIdentifier telephoneNumber;
    public static final ASN1ObjectIdentifier teletexTerminalIdentifier;
    public static final ASN1ObjectIdentifier telexNumber;
    public static final ASN1ObjectIdentifier title;
    public static final ASN1ObjectIdentifier uid;
    public static final ASN1ObjectIdentifier uniqueMember;
    public static final ASN1ObjectIdentifier userPassword;
    public static final ASN1ObjectIdentifier x121Address;
    public static final ASN1ObjectIdentifier x500UniqueIdentifier;
    public final Hashtable defaultLookUp = AbstractX500NameStyle.copyHashTable(b);
    public final Hashtable defaultSymbols = AbstractX500NameStyle.copyHashTable(a);

    static {
        ASN1ObjectIdentifier y0 = a.y0("2.5.4.15");
        businessCategory = y0;
        ASN1ObjectIdentifier y02 = a.y0("2.5.4.6");
        c = y02;
        ASN1ObjectIdentifier y03 = a.y0("2.5.4.3");
        cn = y03;
        ASN1ObjectIdentifier y04 = a.y0("0.9.2342.19200300.100.1.25");
        dc = y04;
        ASN1ObjectIdentifier y05 = a.y0("2.5.4.13");
        description = y05;
        ASN1ObjectIdentifier y06 = a.y0("2.5.4.27");
        destinationIndicator = y06;
        ASN1ObjectIdentifier y07 = a.y0("2.5.4.49");
        distinguishedName = y07;
        ASN1ObjectIdentifier y08 = a.y0("2.5.4.46");
        dnQualifier = y08;
        ASN1ObjectIdentifier y09 = a.y0("2.5.4.47");
        enhancedSearchGuide = y09;
        ASN1ObjectIdentifier y010 = a.y0("2.5.4.23");
        facsimileTelephoneNumber = y010;
        ASN1ObjectIdentifier y011 = a.y0("2.5.4.44");
        generationQualifier = y011;
        ASN1ObjectIdentifier y012 = a.y0("2.5.4.42");
        givenName = y012;
        ASN1ObjectIdentifier y013 = a.y0("2.5.4.51");
        houseIdentifier = y013;
        ASN1ObjectIdentifier y014 = a.y0("2.5.4.43");
        initials = y014;
        ASN1ObjectIdentifier y015 = a.y0("2.5.4.25");
        internationalISDNNumber = y015;
        ASN1ObjectIdentifier y016 = a.y0("2.5.4.7");
        l = y016;
        ASN1ObjectIdentifier y017 = a.y0("2.5.4.31");
        member = y017;
        ASN1ObjectIdentifier y018 = a.y0("2.5.4.41");
        name = y018;
        ASN1ObjectIdentifier y019 = a.y0("2.5.4.10");
        o = y019;
        ASN1ObjectIdentifier y020 = a.y0("2.5.4.11");
        ou = y020;
        ASN1ObjectIdentifier y021 = a.y0("2.5.4.32");
        owner = y021;
        ASN1ObjectIdentifier y022 = a.y0("2.5.4.19");
        physicalDeliveryOfficeName = y022;
        ASN1ObjectIdentifier y023 = a.y0("2.5.4.16");
        postalAddress = y023;
        ASN1ObjectIdentifier y024 = a.y0("2.5.4.17");
        postalCode = y024;
        ASN1ObjectIdentifier y025 = a.y0("2.5.4.18");
        postOfficeBox = y025;
        ASN1ObjectIdentifier y026 = a.y0("2.5.4.28");
        preferredDeliveryMethod = y026;
        ASN1ObjectIdentifier y027 = a.y0("2.5.4.26");
        registeredAddress = y027;
        ASN1ObjectIdentifier y028 = a.y0("2.5.4.33");
        roleOccupant = y028;
        ASN1ObjectIdentifier y029 = a.y0("2.5.4.14");
        searchGuide = y029;
        ASN1ObjectIdentifier y030 = a.y0("2.5.4.34");
        seeAlso = y030;
        ASN1ObjectIdentifier y031 = a.y0("2.5.4.5");
        serialNumber = y031;
        ASN1ObjectIdentifier y032 = a.y0("2.5.4.4");
        sn = y032;
        ASN1ObjectIdentifier y033 = a.y0("2.5.4.8");
        st = y033;
        ASN1ObjectIdentifier y034 = a.y0("2.5.4.9");
        street = y034;
        ASN1ObjectIdentifier y035 = a.y0("2.5.4.20");
        telephoneNumber = y035;
        ASN1ObjectIdentifier y036 = a.y0("2.5.4.22");
        teletexTerminalIdentifier = y036;
        ASN1ObjectIdentifier y037 = a.y0("2.5.4.21");
        telexNumber = y037;
        ASN1ObjectIdentifier y038 = a.y0("2.5.4.12");
        title = y038;
        ASN1ObjectIdentifier y039 = a.y0("0.9.2342.19200300.100.1.1");
        uid = y039;
        ASN1ObjectIdentifier y040 = a.y0("2.5.4.50");
        uniqueMember = y040;
        ASN1ObjectIdentifier y041 = a.y0("2.5.4.35");
        userPassword = y041;
        ASN1ObjectIdentifier y042 = a.y0("2.5.4.24");
        x121Address = y042;
        ASN1ObjectIdentifier y043 = a.y0("2.5.4.45");
        x500UniqueIdentifier = y043;
        Hashtable hashtable = new Hashtable();
        a = hashtable;
        Hashtable hashtable2 = new Hashtable();
        b = hashtable2;
        hashtable.put(y0, "businessCategory");
        hashtable.put(y02, "c");
        hashtable.put(y03, "cn");
        hashtable.put(y04, "dc");
        hashtable.put(y05, "description");
        hashtable.put(y06, "destinationIndicator");
        hashtable.put(y07, "distinguishedName");
        hashtable.put(y08, "dnQualifier");
        hashtable.put(y09, "enhancedSearchGuide");
        hashtable.put(y010, "facsimileTelephoneNumber");
        hashtable.put(y011, "generationQualifier");
        hashtable.put(y012, "givenName");
        hashtable.put(y013, "houseIdentifier");
        hashtable.put(y014, "initials");
        hashtable.put(y015, "internationalISDNNumber");
        hashtable.put(y016, "l");
        hashtable.put(y017, "member");
        hashtable.put(y018, "name");
        hashtable.put(y019, "o");
        hashtable.put(y020, "ou");
        hashtable.put(y021, UrlParams.OWNER);
        hashtable.put(y022, "physicalDeliveryOfficeName");
        hashtable.put(y023, "postalAddress");
        hashtable.put(y024, "postalCode");
        hashtable.put(y025, "postOfficeBox");
        hashtable.put(y026, "preferredDeliveryMethod");
        hashtable.put(y027, "registeredAddress");
        hashtable.put(y028, "roleOccupant");
        hashtable.put(y029, "searchGuide");
        hashtable.put(y030, "seeAlso");
        hashtable.put(y031, "serialNumber");
        hashtable.put(y032, "sn");
        hashtable.put(y033, UserDataStore.STATE);
        hashtable.put(y034, "street");
        hashtable.put(y035, "telephoneNumber");
        hashtable.put(y036, "teletexTerminalIdentifier");
        hashtable.put(y037, "telexNumber");
        hashtable.put(y038, "title");
        hashtable.put(y039, "uid");
        hashtable.put(y040, "uniqueMember");
        hashtable.put(y041, "userPassword");
        hashtable.put(y042, "x121Address");
        hashtable.put(y043, "x500UniqueIdentifier");
        hashtable2.put("businesscategory", y0);
        hashtable2.put("c", y02);
        hashtable2.put("cn", y03);
        hashtable2.put("dc", y04);
        hashtable2.put("description", y05);
        hashtable2.put("destinationindicator", y06);
        hashtable2.put("distinguishedname", y07);
        hashtable2.put("dnqualifier", y08);
        hashtable2.put("enhancedsearchguide", y09);
        hashtable2.put("facsimiletelephonenumber", y010);
        hashtable2.put("generationqualifier", y011);
        hashtable2.put("givenname", y012);
        hashtable2.put("houseidentifier", y013);
        hashtable2.put("initials", y014);
        hashtable2.put("internationalisdnnumber", y015);
        hashtable2.put("l", y016);
        hashtable2.put("member", y017);
        hashtable2.put("name", y018);
        hashtable2.put("o", y019);
        hashtable2.put("ou", y020);
        hashtable2.put(UrlParams.OWNER, y021);
        hashtable2.put("physicaldeliveryofficename", y022);
        hashtable2.put("postaladdress", y023);
        hashtable2.put("postalcode", y024);
        hashtable2.put("postofficebox", y025);
        hashtable2.put("preferreddeliverymethod", y026);
        hashtable2.put("registeredaddress", y027);
        hashtable2.put("roleoccupant", y028);
        hashtable2.put("searchguide", y029);
        hashtable2.put("seealso", y030);
        hashtable2.put("serialnumber", y031);
        hashtable2.put("sn", y032);
        hashtable2.put(UserDataStore.STATE, y033);
        hashtable2.put("street", y034);
        hashtable2.put("telephonenumber", y035);
        hashtable2.put("teletexterminalidentifier", y036);
        hashtable2.put("telexnumber", y037);
        hashtable2.put("title", y038);
        hashtable2.put("uid", y039);
        hashtable2.put("uniquemember", y040);
        hashtable2.put("userpassword", y041);
        hashtable2.put("x121address", y042);
        hashtable2.put("x500uniqueidentifier", y043);
    }

    @Override // org.spongycastle.asn1.x500.X500NameStyle
    public ASN1ObjectIdentifier attrNameToOID(String str) {
        return IETFUtils.decodeAttrName(str, this.defaultLookUp);
    }

    @Override // org.spongycastle.asn1.x500.style.AbstractX500NameStyle
    public ASN1Encodable encodeStringValue(ASN1ObjectIdentifier aSN1ObjectIdentifier, String str) {
        if (aSN1ObjectIdentifier.equals(dc)) {
            return new DERIA5String(str);
        }
        if (aSN1ObjectIdentifier.equals(c) || aSN1ObjectIdentifier.equals(serialNumber) || aSN1ObjectIdentifier.equals(dnQualifier) || aSN1ObjectIdentifier.equals(telephoneNumber)) {
            return new DERPrintableString(str);
        }
        return super.encodeStringValue(aSN1ObjectIdentifier, str);
    }

    @Override // org.spongycastle.asn1.x500.X500NameStyle
    public RDN[] fromString(String str) {
        RDN[] rDNsFromString = IETFUtils.rDNsFromString(str, this);
        int length = rDNsFromString.length;
        RDN[] rdnArr = new RDN[length];
        for (int i = 0; i != rDNsFromString.length; i++) {
            rdnArr[(length - i) - 1] = rDNsFromString[i];
        }
        return rdnArr;
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
        StringBuffer stringBuffer = new StringBuffer();
        RDN[] rDNs = x500Name.getRDNs();
        boolean z = true;
        for (int length = rDNs.length - 1; length >= 0; length--) {
            if (z) {
                z = false;
            } else {
                stringBuffer.append(',');
            }
            IETFUtils.appendRDN(stringBuffer, rDNs[length], this.defaultSymbols);
        }
        return stringBuffer.toString();
    }
}
