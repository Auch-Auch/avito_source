package org.spongycastle.asn1.misc;

import a2.b.a.a.a;
import org.spongycastle.asn1.DERIA5String;
public class VerisignCzagExtension extends DERIA5String {
    public VerisignCzagExtension(DERIA5String dERIA5String) {
        super(dERIA5String.getString());
    }

    @Override // org.spongycastle.asn1.DERIA5String
    public String toString() {
        StringBuilder L = a.L("VerisignCzagExtension: ");
        L.append(getString());
        return L.toString();
    }
}
