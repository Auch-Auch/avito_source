package org.spongycastle.asn1.x509;

import a2.b.a.a.a;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.appevents.UserDataStore;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Encoding;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1Set;
import org.spongycastle.asn1.ASN1String;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERSet;
import org.spongycastle.asn1.DERUniversalString;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.asn1.x500.X500Name;
import org.spongycastle.util.Strings;
import org.spongycastle.util.encoders.Hex;
public class X509Name extends ASN1Object {
    public static final ASN1ObjectIdentifier BUSINESS_CATEGORY;
    public static final ASN1ObjectIdentifier C;
    public static final ASN1ObjectIdentifier CN;
    public static final ASN1ObjectIdentifier COUNTRY_OF_CITIZENSHIP;
    public static final ASN1ObjectIdentifier COUNTRY_OF_RESIDENCE;
    public static final ASN1ObjectIdentifier DATE_OF_BIRTH;
    public static final ASN1ObjectIdentifier DC;
    public static final ASN1ObjectIdentifier DMD_NAME = new ASN1ObjectIdentifier("2.5.4.54");
    public static final ASN1ObjectIdentifier DN_QUALIFIER;
    public static final Hashtable DefaultLookUp;
    public static boolean DefaultReverse = false;
    public static final Hashtable DefaultSymbols;
    public static final ASN1ObjectIdentifier E;
    public static final ASN1ObjectIdentifier EmailAddress;
    public static final ASN1ObjectIdentifier GENDER;
    public static final ASN1ObjectIdentifier GENERATION;
    public static final ASN1ObjectIdentifier GIVENNAME;
    public static final ASN1ObjectIdentifier INITIALS;
    public static final ASN1ObjectIdentifier L;
    public static final ASN1ObjectIdentifier NAME;
    public static final ASN1ObjectIdentifier NAME_AT_BIRTH;
    public static final ASN1ObjectIdentifier O;
    public static final Hashtable OIDLookUp;
    public static final ASN1ObjectIdentifier OU;
    public static final ASN1ObjectIdentifier PLACE_OF_BIRTH;
    public static final ASN1ObjectIdentifier POSTAL_ADDRESS;
    public static final ASN1ObjectIdentifier POSTAL_CODE;
    public static final ASN1ObjectIdentifier PSEUDONYM;
    public static final Hashtable RFC1779Symbols;
    public static final Hashtable RFC2253Symbols;
    public static final ASN1ObjectIdentifier SERIALNUMBER;
    public static final ASN1ObjectIdentifier SN;
    public static final ASN1ObjectIdentifier ST;
    public static final ASN1ObjectIdentifier STREET;
    public static final ASN1ObjectIdentifier SURNAME;
    public static final Hashtable SymbolLookUp;
    public static final ASN1ObjectIdentifier T;
    public static final ASN1ObjectIdentifier TELEPHONE_NUMBER;
    public static final ASN1ObjectIdentifier UID;
    public static final ASN1ObjectIdentifier UNIQUE_IDENTIFIER;
    public static final ASN1ObjectIdentifier UnstructuredAddress;
    public static final ASN1ObjectIdentifier UnstructuredName;
    public static final Boolean h = new Boolean(true);
    public static final Boolean i = new Boolean(false);
    public X509NameEntryConverter a;
    public Vector b;
    public Vector c;
    public Vector d;
    public ASN1Sequence e;
    public boolean f;
    public int g;

    static {
        ASN1ObjectIdentifier aSN1ObjectIdentifier = new ASN1ObjectIdentifier("2.5.4.6");
        C = aSN1ObjectIdentifier;
        ASN1ObjectIdentifier aSN1ObjectIdentifier2 = new ASN1ObjectIdentifier("2.5.4.10");
        O = aSN1ObjectIdentifier2;
        ASN1ObjectIdentifier aSN1ObjectIdentifier3 = new ASN1ObjectIdentifier("2.5.4.11");
        OU = aSN1ObjectIdentifier3;
        ASN1ObjectIdentifier aSN1ObjectIdentifier4 = new ASN1ObjectIdentifier("2.5.4.12");
        T = aSN1ObjectIdentifier4;
        ASN1ObjectIdentifier aSN1ObjectIdentifier5 = new ASN1ObjectIdentifier("2.5.4.3");
        CN = aSN1ObjectIdentifier5;
        ASN1ObjectIdentifier aSN1ObjectIdentifier6 = new ASN1ObjectIdentifier("2.5.4.5");
        SN = aSN1ObjectIdentifier6;
        ASN1ObjectIdentifier aSN1ObjectIdentifier7 = new ASN1ObjectIdentifier("2.5.4.9");
        STREET = aSN1ObjectIdentifier7;
        SERIALNUMBER = aSN1ObjectIdentifier6;
        ASN1ObjectIdentifier aSN1ObjectIdentifier8 = new ASN1ObjectIdentifier("2.5.4.7");
        L = aSN1ObjectIdentifier8;
        ASN1ObjectIdentifier aSN1ObjectIdentifier9 = new ASN1ObjectIdentifier("2.5.4.8");
        ST = aSN1ObjectIdentifier9;
        ASN1ObjectIdentifier aSN1ObjectIdentifier10 = new ASN1ObjectIdentifier("2.5.4.4");
        SURNAME = aSN1ObjectIdentifier10;
        ASN1ObjectIdentifier aSN1ObjectIdentifier11 = new ASN1ObjectIdentifier("2.5.4.42");
        GIVENNAME = aSN1ObjectIdentifier11;
        ASN1ObjectIdentifier aSN1ObjectIdentifier12 = new ASN1ObjectIdentifier("2.5.4.43");
        INITIALS = aSN1ObjectIdentifier12;
        ASN1ObjectIdentifier aSN1ObjectIdentifier13 = new ASN1ObjectIdentifier("2.5.4.44");
        GENERATION = aSN1ObjectIdentifier13;
        ASN1ObjectIdentifier aSN1ObjectIdentifier14 = new ASN1ObjectIdentifier("2.5.4.45");
        UNIQUE_IDENTIFIER = aSN1ObjectIdentifier14;
        ASN1ObjectIdentifier aSN1ObjectIdentifier15 = new ASN1ObjectIdentifier("2.5.4.15");
        BUSINESS_CATEGORY = aSN1ObjectIdentifier15;
        ASN1ObjectIdentifier aSN1ObjectIdentifier16 = new ASN1ObjectIdentifier("2.5.4.17");
        POSTAL_CODE = aSN1ObjectIdentifier16;
        ASN1ObjectIdentifier aSN1ObjectIdentifier17 = new ASN1ObjectIdentifier("2.5.4.46");
        DN_QUALIFIER = aSN1ObjectIdentifier17;
        ASN1ObjectIdentifier aSN1ObjectIdentifier18 = new ASN1ObjectIdentifier("2.5.4.65");
        PSEUDONYM = aSN1ObjectIdentifier18;
        ASN1ObjectIdentifier aSN1ObjectIdentifier19 = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.9.1");
        DATE_OF_BIRTH = aSN1ObjectIdentifier19;
        ASN1ObjectIdentifier aSN1ObjectIdentifier20 = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.9.2");
        PLACE_OF_BIRTH = aSN1ObjectIdentifier20;
        ASN1ObjectIdentifier aSN1ObjectIdentifier21 = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.9.3");
        GENDER = aSN1ObjectIdentifier21;
        ASN1ObjectIdentifier aSN1ObjectIdentifier22 = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.9.4");
        COUNTRY_OF_CITIZENSHIP = aSN1ObjectIdentifier22;
        ASN1ObjectIdentifier aSN1ObjectIdentifier23 = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.9.5");
        COUNTRY_OF_RESIDENCE = aSN1ObjectIdentifier23;
        ASN1ObjectIdentifier aSN1ObjectIdentifier24 = new ASN1ObjectIdentifier("1.3.36.8.3.14");
        NAME_AT_BIRTH = aSN1ObjectIdentifier24;
        ASN1ObjectIdentifier aSN1ObjectIdentifier25 = new ASN1ObjectIdentifier("2.5.4.16");
        POSTAL_ADDRESS = aSN1ObjectIdentifier25;
        ASN1ObjectIdentifier aSN1ObjectIdentifier26 = X509ObjectIdentifiers.id_at_telephoneNumber;
        TELEPHONE_NUMBER = aSN1ObjectIdentifier26;
        ASN1ObjectIdentifier aSN1ObjectIdentifier27 = X509ObjectIdentifiers.id_at_name;
        NAME = aSN1ObjectIdentifier27;
        ASN1ObjectIdentifier aSN1ObjectIdentifier28 = PKCSObjectIdentifiers.pkcs_9_at_emailAddress;
        EmailAddress = aSN1ObjectIdentifier28;
        ASN1ObjectIdentifier aSN1ObjectIdentifier29 = PKCSObjectIdentifiers.pkcs_9_at_unstructuredName;
        UnstructuredName = aSN1ObjectIdentifier29;
        ASN1ObjectIdentifier aSN1ObjectIdentifier30 = PKCSObjectIdentifiers.pkcs_9_at_unstructuredAddress;
        UnstructuredAddress = aSN1ObjectIdentifier30;
        E = aSN1ObjectIdentifier28;
        ASN1ObjectIdentifier aSN1ObjectIdentifier31 = new ASN1ObjectIdentifier("0.9.2342.19200300.100.1.25");
        DC = aSN1ObjectIdentifier31;
        ASN1ObjectIdentifier aSN1ObjectIdentifier32 = new ASN1ObjectIdentifier("0.9.2342.19200300.100.1.1");
        UID = aSN1ObjectIdentifier32;
        Hashtable hashtable = new Hashtable();
        DefaultSymbols = hashtable;
        Hashtable hashtable2 = new Hashtable();
        RFC2253Symbols = hashtable2;
        Hashtable hashtable3 = new Hashtable();
        RFC1779Symbols = hashtable3;
        Hashtable hashtable4 = new Hashtable();
        DefaultLookUp = hashtable4;
        OIDLookUp = hashtable;
        SymbolLookUp = hashtable4;
        hashtable.put(aSN1ObjectIdentifier, "C");
        hashtable.put(aSN1ObjectIdentifier2, "O");
        hashtable.put(aSN1ObjectIdentifier4, "T");
        hashtable.put(aSN1ObjectIdentifier3, "OU");
        hashtable.put(aSN1ObjectIdentifier5, "CN");
        hashtable.put(aSN1ObjectIdentifier8, "L");
        hashtable.put(aSN1ObjectIdentifier9, "ST");
        hashtable.put(aSN1ObjectIdentifier6, "SERIALNUMBER");
        hashtable.put(aSN1ObjectIdentifier28, ExifInterface.LONGITUDE_EAST);
        hashtable.put(aSN1ObjectIdentifier31, "DC");
        hashtable.put(aSN1ObjectIdentifier32, "UID");
        hashtable.put(aSN1ObjectIdentifier7, "STREET");
        hashtable.put(aSN1ObjectIdentifier10, "SURNAME");
        hashtable.put(aSN1ObjectIdentifier11, "GIVENNAME");
        hashtable.put(aSN1ObjectIdentifier12, "INITIALS");
        hashtable.put(aSN1ObjectIdentifier13, "GENERATION");
        hashtable.put(aSN1ObjectIdentifier30, "unstructuredAddress");
        hashtable.put(aSN1ObjectIdentifier29, "unstructuredName");
        hashtable.put(aSN1ObjectIdentifier14, "UniqueIdentifier");
        hashtable.put(aSN1ObjectIdentifier17, "DN");
        hashtable.put(aSN1ObjectIdentifier18, "Pseudonym");
        hashtable.put(aSN1ObjectIdentifier25, "PostalAddress");
        hashtable.put(aSN1ObjectIdentifier24, "NameAtBirth");
        hashtable.put(aSN1ObjectIdentifier22, "CountryOfCitizenship");
        hashtable.put(aSN1ObjectIdentifier23, "CountryOfResidence");
        hashtable.put(aSN1ObjectIdentifier21, "Gender");
        hashtable.put(aSN1ObjectIdentifier20, "PlaceOfBirth");
        hashtable.put(aSN1ObjectIdentifier19, "DateOfBirth");
        hashtable.put(aSN1ObjectIdentifier16, "PostalCode");
        hashtable.put(aSN1ObjectIdentifier15, "BusinessCategory");
        hashtable.put(aSN1ObjectIdentifier26, "TelephoneNumber");
        hashtable.put(aSN1ObjectIdentifier27, "Name");
        hashtable2.put(aSN1ObjectIdentifier, "C");
        hashtable2.put(aSN1ObjectIdentifier2, "O");
        hashtable2.put(aSN1ObjectIdentifier3, "OU");
        hashtable2.put(aSN1ObjectIdentifier5, "CN");
        hashtable2.put(aSN1ObjectIdentifier8, "L");
        hashtable2.put(aSN1ObjectIdentifier9, "ST");
        hashtable2.put(aSN1ObjectIdentifier7, "STREET");
        hashtable2.put(aSN1ObjectIdentifier31, "DC");
        hashtable2.put(aSN1ObjectIdentifier32, "UID");
        hashtable3.put(aSN1ObjectIdentifier, "C");
        hashtable3.put(aSN1ObjectIdentifier2, "O");
        hashtable3.put(aSN1ObjectIdentifier3, "OU");
        hashtable3.put(aSN1ObjectIdentifier5, "CN");
        hashtable3.put(aSN1ObjectIdentifier8, "L");
        hashtable3.put(aSN1ObjectIdentifier9, "ST");
        hashtable3.put(aSN1ObjectIdentifier7, "STREET");
        hashtable4.put("c", aSN1ObjectIdentifier);
        hashtable4.put("o", aSN1ObjectIdentifier2);
        hashtable4.put("t", aSN1ObjectIdentifier4);
        hashtable4.put("ou", aSN1ObjectIdentifier3);
        hashtable4.put("cn", aSN1ObjectIdentifier5);
        hashtable4.put("l", aSN1ObjectIdentifier8);
        hashtable4.put(UserDataStore.STATE, aSN1ObjectIdentifier9);
        hashtable4.put("sn", aSN1ObjectIdentifier6);
        hashtable4.put("serialnumber", aSN1ObjectIdentifier6);
        hashtable4.put("street", aSN1ObjectIdentifier7);
        hashtable4.put("emailaddress", aSN1ObjectIdentifier28);
        hashtable4.put("dc", aSN1ObjectIdentifier31);
        hashtable4.put("e", aSN1ObjectIdentifier28);
        hashtable4.put("uid", aSN1ObjectIdentifier32);
        hashtable4.put("surname", aSN1ObjectIdentifier10);
        hashtable4.put("givenname", aSN1ObjectIdentifier11);
        hashtable4.put("initials", aSN1ObjectIdentifier12);
        hashtable4.put("generation", aSN1ObjectIdentifier13);
        hashtable4.put("unstructuredaddress", aSN1ObjectIdentifier30);
        hashtable4.put("unstructuredname", aSN1ObjectIdentifier29);
        hashtable4.put("uniqueidentifier", aSN1ObjectIdentifier14);
        hashtable4.put("dn", aSN1ObjectIdentifier17);
        hashtable4.put("pseudonym", aSN1ObjectIdentifier18);
        hashtable4.put("postaladdress", aSN1ObjectIdentifier25);
        hashtable4.put("nameofbirth", aSN1ObjectIdentifier24);
        hashtable4.put("countryofcitizenship", aSN1ObjectIdentifier22);
        hashtable4.put("countryofresidence", aSN1ObjectIdentifier23);
        hashtable4.put("gender", aSN1ObjectIdentifier21);
        hashtable4.put("placeofbirth", aSN1ObjectIdentifier20);
        hashtable4.put("dateofbirth", aSN1ObjectIdentifier19);
        hashtable4.put("postalcode", aSN1ObjectIdentifier16);
        hashtable4.put("businesscategory", aSN1ObjectIdentifier15);
        hashtable4.put("telephonenumber", aSN1ObjectIdentifier26);
        hashtable4.put("name", aSN1ObjectIdentifier27);
    }

    public X509Name() {
        this.a = null;
        this.b = new Vector();
        this.c = new Vector();
        this.d = new Vector();
    }

    public static X509Name getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }

    public final void a(Hashtable hashtable, String str, Boolean bool) {
        ASN1ObjectIdentifier aSN1ObjectIdentifier;
        String str2;
        int i2;
        X509NameTokenizer x509NameTokenizer = new X509NameTokenizer(str, '=');
        String nextToken = x509NameTokenizer.nextToken();
        if (x509NameTokenizer.hasMoreTokens()) {
            String nextToken2 = x509NameTokenizer.nextToken();
            String trim = nextToken.trim();
            if (Strings.toUpperCase(trim).startsWith("OID.")) {
                aSN1ObjectIdentifier = new ASN1ObjectIdentifier(trim.substring(4));
            } else if (trim.charAt(0) < '0' || trim.charAt(0) > '9') {
                aSN1ObjectIdentifier = (ASN1ObjectIdentifier) hashtable.get(Strings.toLowerCase(trim));
                if (aSN1ObjectIdentifier == null) {
                    throw new IllegalArgumentException(a.e3("Unknown object id - ", trim, " - passed to distinguished name"));
                }
            } else {
                aSN1ObjectIdentifier = new ASN1ObjectIdentifier(trim);
            }
            this.b.addElement(aSN1ObjectIdentifier);
            Vector vector = this.c;
            if (nextToken2.length() == 0 || (nextToken2.indexOf(92) < 0 && nextToken2.indexOf(34) < 0)) {
                str2 = nextToken2.trim();
            } else {
                char[] charArray = nextToken2.toCharArray();
                StringBuffer stringBuffer = new StringBuffer(nextToken2.length());
                if (charArray[0] == '\\' && charArray[1] == '#') {
                    i2 = 2;
                    stringBuffer.append("\\#");
                } else {
                    i2 = 0;
                }
                boolean z = false;
                int i3 = 0;
                boolean z2 = false;
                boolean z3 = false;
                while (i2 != charArray.length) {
                    char c2 = charArray[i2];
                    if (c2 != ' ') {
                        z3 = true;
                    }
                    if (c2 == '\"') {
                        if (!z) {
                            z2 = !z2;
                        } else {
                            stringBuffer.append(c2);
                        }
                    } else if (c2 == '\\' && !z && !z2) {
                        i3 = stringBuffer.length();
                        z = true;
                        i2++;
                    } else if (c2 != ' ' || z || z3) {
                        stringBuffer.append(c2);
                    } else {
                        i2++;
                    }
                    z = false;
                    i2++;
                }
                if (stringBuffer.length() > 0) {
                    while (stringBuffer.charAt(stringBuffer.length() - 1) == ' ' && i3 != stringBuffer.length() - 1) {
                        stringBuffer.setLength(stringBuffer.length() - 1);
                    }
                }
                str2 = stringBuffer.toString();
            }
            vector.addElement(str2);
            this.d.addElement(bool);
            return;
        }
        throw new IllegalArgumentException("badly formatted directory string");
    }

    public final void b(StringBuffer stringBuffer, Hashtable hashtable, ASN1ObjectIdentifier aSN1ObjectIdentifier, String str) {
        String str2 = (String) hashtable.get(aSN1ObjectIdentifier);
        if (str2 != null) {
            stringBuffer.append(str2);
        } else {
            stringBuffer.append(aSN1ObjectIdentifier.getId());
        }
        stringBuffer.append('=');
        int length = stringBuffer.length();
        stringBuffer.append(str);
        int length2 = stringBuffer.length();
        if (str.length() >= 2 && str.charAt(0) == '\\' && str.charAt(1) == '#') {
            length += 2;
        }
        while (length < length2 && stringBuffer.charAt(length) == ' ') {
            stringBuffer.insert(length, "\\");
            length += 2;
            length2++;
        }
        while (true) {
            length2--;
            if (length2 <= length || stringBuffer.charAt(length2) != ' ') {
                break;
            }
            stringBuffer.insert(length2, '\\');
        }
        while (length <= length2) {
            char charAt = stringBuffer.charAt(length);
            if (!(charAt == '\"' || charAt == '\\' || charAt == '+' || charAt == ',')) {
                switch (charAt) {
                    case ';':
                    case '<':
                    case '=':
                    case '>':
                        break;
                    default:
                        length++;
                        continue;
                }
            }
            stringBuffer.insert(length, "\\");
            length += 2;
            length2++;
        }
    }

    public final String c(String str) {
        String lowerCase = Strings.toLowerCase(str.trim());
        if (lowerCase.length() <= 0 || lowerCase.charAt(0) != '#') {
            return lowerCase;
        }
        try {
            ASN1Primitive fromByteArray = ASN1Primitive.fromByteArray(Hex.decode(lowerCase.substring(1)));
            if (fromByteArray instanceof ASN1String) {
                return Strings.toLowerCase(((ASN1String) fromByteArray).getString().trim());
            }
            return lowerCase;
        } catch (IOException e2) {
            throw new IllegalStateException(a.Z2("unknown encoding in name: ", e2));
        }
    }

    public final boolean d(String str, String str2) {
        String c2 = c(str);
        String c3 = c(str2);
        return c2.equals(c3) || e(c2).equals(e(c3));
    }

    public final String e(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        if (str.length() != 0) {
            char charAt = str.charAt(0);
            stringBuffer.append(charAt);
            int i2 = 1;
            while (i2 < str.length()) {
                char charAt2 = str.charAt(i2);
                if (charAt != ' ' || charAt2 != ' ') {
                    stringBuffer.append(charAt2);
                }
                i2++;
                charAt = charAt2;
            }
        }
        return stringBuffer.toString();
    }

    public boolean equals(Object obj, boolean z) {
        if (!z) {
            return equals(obj);
        }
        if (obj == this) {
            return true;
        }
        if (!((obj instanceof X509Name) || (obj instanceof ASN1Sequence))) {
            return false;
        }
        if (toASN1Primitive().equals(((ASN1Encodable) obj).toASN1Primitive())) {
            return true;
        }
        try {
            X509Name instance = getInstance(obj);
            int size = this.b.size();
            if (size != instance.b.size()) {
                return false;
            }
            for (int i2 = 0; i2 < size; i2++) {
                if (!((ASN1ObjectIdentifier) this.b.elementAt(i2)).equals((ASN1ObjectIdentifier) instance.b.elementAt(i2)) || !d((String) this.c.elementAt(i2), (String) instance.c.elementAt(i2))) {
                    return false;
                }
            }
            return true;
        } catch (IllegalArgumentException unused) {
            return false;
        }
    }

    public Vector getOIDs() {
        Vector vector = new Vector();
        for (int i2 = 0; i2 != this.b.size(); i2++) {
            vector.addElement(this.b.elementAt(i2));
        }
        return vector;
    }

    public Vector getValues() {
        Vector vector = new Vector();
        for (int i2 = 0; i2 != this.c.size(); i2++) {
            vector.addElement(this.c.elementAt(i2));
        }
        return vector;
    }

    @Override // org.spongycastle.asn1.ASN1Object
    public int hashCode() {
        if (this.f) {
            return this.g;
        }
        this.f = true;
        for (int i2 = 0; i2 != this.b.size(); i2++) {
            String e2 = e(c((String) this.c.elementAt(i2)));
            int hashCode = this.g ^ this.b.elementAt(i2).hashCode();
            this.g = hashCode;
            this.g = e2.hashCode() ^ hashCode;
        }
        return this.g;
    }

    @Override // org.spongycastle.asn1.ASN1Object, org.spongycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        if (this.e == null) {
            ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
            ASN1EncodableVector aSN1EncodableVector2 = new ASN1EncodableVector();
            ASN1ObjectIdentifier aSN1ObjectIdentifier = null;
            int i2 = 0;
            while (i2 != this.b.size()) {
                ASN1EncodableVector aSN1EncodableVector3 = new ASN1EncodableVector();
                ASN1ObjectIdentifier aSN1ObjectIdentifier2 = (ASN1ObjectIdentifier) this.b.elementAt(i2);
                aSN1EncodableVector3.add(aSN1ObjectIdentifier2);
                aSN1EncodableVector3.add(this.a.getConvertedValue(aSN1ObjectIdentifier2, (String) this.c.elementAt(i2)));
                if (aSN1ObjectIdentifier == null || ((Boolean) this.d.elementAt(i2)).booleanValue()) {
                    aSN1EncodableVector2.add(new DERSequence(aSN1EncodableVector3));
                } else {
                    aSN1EncodableVector.add(new DERSet(aSN1EncodableVector2));
                    aSN1EncodableVector2 = new ASN1EncodableVector();
                    aSN1EncodableVector2.add(new DERSequence(aSN1EncodableVector3));
                }
                i2++;
                aSN1ObjectIdentifier = aSN1ObjectIdentifier2;
            }
            aSN1EncodableVector.add(new DERSet(aSN1EncodableVector2));
            this.e = new DERSequence(aSN1EncodableVector);
        }
        return this.e;
    }

    public String toString(boolean z, Hashtable hashtable) {
        StringBuffer stringBuffer = new StringBuffer();
        Vector vector = new Vector();
        StringBuffer stringBuffer2 = null;
        for (int i2 = 0; i2 < this.b.size(); i2++) {
            if (((Boolean) this.d.elementAt(i2)).booleanValue()) {
                stringBuffer2.append('+');
                b(stringBuffer2, hashtable, (ASN1ObjectIdentifier) this.b.elementAt(i2), (String) this.c.elementAt(i2));
            } else {
                stringBuffer2 = new StringBuffer();
                b(stringBuffer2, hashtable, (ASN1ObjectIdentifier) this.b.elementAt(i2), (String) this.c.elementAt(i2));
                vector.addElement(stringBuffer2);
            }
        }
        boolean z2 = true;
        if (z) {
            for (int size = vector.size() - 1; size >= 0; size--) {
                if (z2) {
                    z2 = false;
                } else {
                    stringBuffer.append(',');
                }
                stringBuffer.append(vector.elementAt(size).toString());
            }
        } else {
            for (int i3 = 0; i3 < vector.size(); i3++) {
                if (z2) {
                    z2 = false;
                } else {
                    stringBuffer.append(',');
                }
                stringBuffer.append(vector.elementAt(i3).toString());
            }
        }
        return stringBuffer.toString();
    }

    public static X509Name getInstance(Object obj) {
        if (obj == null || (obj instanceof X509Name)) {
            return (X509Name) obj;
        }
        if (obj instanceof X500Name) {
            return new X509Name(ASN1Sequence.getInstance(((X500Name) obj).toASN1Primitive()));
        }
        return new X509Name(ASN1Sequence.getInstance(obj));
    }

    public Vector getValues(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        Vector vector = new Vector();
        for (int i2 = 0; i2 != this.c.size(); i2++) {
            if (this.b.elementAt(i2).equals(aSN1ObjectIdentifier)) {
                String str = (String) this.c.elementAt(i2);
                if (str.length() > 2 && str.charAt(0) == '\\' && str.charAt(1) == '#') {
                    vector.addElement(str.substring(1));
                } else {
                    vector.addElement(str);
                }
            }
        }
        return vector;
    }

    public X509Name(ASN1Sequence aSN1Sequence) {
        this.a = null;
        this.b = new Vector();
        this.c = new Vector();
        this.d = new Vector();
        this.e = aSN1Sequence;
        Enumeration objects = aSN1Sequence.getObjects();
        while (objects.hasMoreElements()) {
            ASN1Set instance = ASN1Set.getInstance(((ASN1Encodable) objects.nextElement()).toASN1Primitive());
            int i2 = 0;
            while (true) {
                if (i2 < instance.size()) {
                    ASN1Sequence instance2 = ASN1Sequence.getInstance(instance.getObjectAt(i2).toASN1Primitive());
                    if (instance2.size() == 2) {
                        this.b.addElement(ASN1ObjectIdentifier.getInstance(instance2.getObjectAt(0)));
                        ASN1Encodable objectAt = instance2.getObjectAt(1);
                        if (!(objectAt instanceof ASN1String) || (objectAt instanceof DERUniversalString)) {
                            try {
                                Vector vector = this.c;
                                StringBuilder sb = new StringBuilder();
                                sb.append("#");
                                byte[] encode = Hex.encode(objectAt.toASN1Primitive().getEncoded(ASN1Encoding.DER));
                                int length = encode.length;
                                char[] cArr = new char[length];
                                for (int i3 = 0; i3 != length; i3++) {
                                    cArr[i3] = (char) (encode[i3] & 255);
                                }
                                sb.append(new String(cArr));
                                vector.addElement(sb.toString());
                            } catch (IOException unused) {
                                throw new IllegalArgumentException("cannot encode value");
                            }
                        } else {
                            String string = ((ASN1String) objectAt).getString();
                            if (string.length() <= 0 || string.charAt(0) != '#') {
                                this.c.addElement(string);
                            } else {
                                Vector vector2 = this.c;
                                vector2.addElement("\\" + string);
                            }
                        }
                        this.d.addElement(i2 != 0 ? h : i);
                        i2++;
                    } else {
                        throw new IllegalArgumentException("badly sized pair");
                    }
                }
            }
        }
    }

    @Override // org.spongycastle.asn1.ASN1Object
    public boolean equals(Object obj) {
        int i2;
        int i3;
        boolean z;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof X509Name) && !(obj instanceof ASN1Sequence)) {
            return false;
        }
        if (toASN1Primitive().equals(((ASN1Encodable) obj).toASN1Primitive())) {
            return true;
        }
        try {
            X509Name instance = getInstance(obj);
            int size = this.b.size();
            if (size != instance.b.size()) {
                return false;
            }
            boolean[] zArr = new boolean[size];
            int i4 = -1;
            if (this.b.elementAt(0).equals(instance.b.elementAt(0))) {
                i4 = size;
                i3 = 0;
                i2 = 1;
            } else {
                i3 = size - 1;
                i2 = -1;
            }
            while (i3 != i4) {
                ASN1ObjectIdentifier aSN1ObjectIdentifier = (ASN1ObjectIdentifier) this.b.elementAt(i3);
                String str = (String) this.c.elementAt(i3);
                int i5 = 0;
                while (true) {
                    if (i5 >= size) {
                        z = false;
                        break;
                    } else if (!zArr[i5] && aSN1ObjectIdentifier.equals((ASN1ObjectIdentifier) instance.b.elementAt(i5)) && d(str, (String) instance.c.elementAt(i5))) {
                        zArr[i5] = true;
                        z = true;
                        break;
                    } else {
                        i5++;
                    }
                }
                if (!z) {
                    return false;
                }
                i3 += i2;
            }
            return true;
        } catch (IllegalArgumentException unused) {
            return false;
        }
    }

    public String toString() {
        return toString(DefaultReverse, DefaultSymbols);
    }

    public X509Name(Hashtable hashtable) {
        this((Vector) null, hashtable);
    }

    public X509Name(Vector vector, Hashtable hashtable) {
        this(vector, hashtable, new X509DefaultEntryConverter());
    }

    public X509Name(Vector vector, Hashtable hashtable, X509NameEntryConverter x509NameEntryConverter) {
        this.a = null;
        this.b = new Vector();
        this.c = new Vector();
        this.d = new Vector();
        this.a = x509NameEntryConverter;
        if (vector != null) {
            for (int i2 = 0; i2 != vector.size(); i2++) {
                this.b.addElement(vector.elementAt(i2));
                this.d.addElement(i);
            }
        } else {
            Enumeration keys = hashtable.keys();
            while (keys.hasMoreElements()) {
                this.b.addElement(keys.nextElement());
                this.d.addElement(i);
            }
        }
        for (int i3 = 0; i3 != this.b.size(); i3++) {
            ASN1ObjectIdentifier aSN1ObjectIdentifier = (ASN1ObjectIdentifier) this.b.elementAt(i3);
            if (hashtable.get(aSN1ObjectIdentifier) != null) {
                this.c.addElement(hashtable.get(aSN1ObjectIdentifier));
            } else {
                StringBuilder L2 = a.L("No attribute for object id - ");
                L2.append(aSN1ObjectIdentifier.getId());
                L2.append(" - passed to distinguished name");
                throw new IllegalArgumentException(L2.toString());
            }
        }
    }

    public X509Name(Vector vector, Vector vector2) {
        this(vector, vector2, new X509DefaultEntryConverter());
    }

    public X509Name(Vector vector, Vector vector2, X509NameEntryConverter x509NameEntryConverter) {
        this.a = null;
        this.b = new Vector();
        this.c = new Vector();
        this.d = new Vector();
        this.a = x509NameEntryConverter;
        if (vector.size() == vector2.size()) {
            for (int i2 = 0; i2 < vector.size(); i2++) {
                this.b.addElement(vector.elementAt(i2));
                this.c.addElement(vector2.elementAt(i2));
                this.d.addElement(i);
            }
            return;
        }
        throw new IllegalArgumentException("oids vector must be same length as values.");
    }

    public X509Name(String str) {
        this(DefaultReverse, DefaultLookUp, str);
    }

    public X509Name(String str, X509NameEntryConverter x509NameEntryConverter) {
        this(DefaultReverse, DefaultLookUp, str, x509NameEntryConverter);
    }

    public X509Name(boolean z, String str) {
        this(z, DefaultLookUp, str);
    }

    public X509Name(boolean z, String str, X509NameEntryConverter x509NameEntryConverter) {
        this(z, DefaultLookUp, str, x509NameEntryConverter);
    }

    public X509Name(boolean z, Hashtable hashtable, String str) {
        this(z, hashtable, str, new X509DefaultEntryConverter());
    }

    public X509Name(boolean z, Hashtable hashtable, String str, X509NameEntryConverter x509NameEntryConverter) {
        this.a = null;
        this.b = new Vector();
        this.c = new Vector();
        this.d = new Vector();
        this.a = x509NameEntryConverter;
        X509NameTokenizer x509NameTokenizer = new X509NameTokenizer(str);
        while (x509NameTokenizer.hasMoreTokens()) {
            String nextToken = x509NameTokenizer.nextToken();
            if (nextToken.indexOf(43) > 0) {
                X509NameTokenizer x509NameTokenizer2 = new X509NameTokenizer(nextToken, '+');
                a(hashtable, x509NameTokenizer2.nextToken(), i);
                while (x509NameTokenizer2.hasMoreTokens()) {
                    a(hashtable, x509NameTokenizer2.nextToken(), h);
                }
            } else {
                a(hashtable, nextToken, i);
            }
        }
        if (z) {
            Vector vector = new Vector();
            Vector vector2 = new Vector();
            Vector vector3 = new Vector();
            int i2 = 1;
            for (int i3 = 0; i3 < this.b.size(); i3++) {
                if (((Boolean) this.d.elementAt(i3)).booleanValue()) {
                    vector.insertElementAt(this.b.elementAt(i3), i2);
                    vector2.insertElementAt(this.c.elementAt(i3), i2);
                    vector3.insertElementAt(this.d.elementAt(i3), i2);
                    i2++;
                } else {
                    vector.insertElementAt(this.b.elementAt(i3), 0);
                    vector2.insertElementAt(this.c.elementAt(i3), 0);
                    vector3.insertElementAt(this.d.elementAt(i3), 0);
                    i2 = 1;
                }
            }
            this.b = vector;
            this.c = vector2;
            this.d = vector3;
        }
    }
}
