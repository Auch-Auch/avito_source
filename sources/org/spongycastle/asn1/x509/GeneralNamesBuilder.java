package org.spongycastle.asn1.x509;

import java.util.Vector;
public class GeneralNamesBuilder {
    public Vector a = new Vector();

    public GeneralNamesBuilder addName(GeneralName generalName) {
        this.a.addElement(generalName);
        return this;
    }

    public GeneralNamesBuilder addNames(GeneralNames generalNames) {
        GeneralName[] names = generalNames.getNames();
        for (int i = 0; i != names.length; i++) {
            this.a.addElement(names[i]);
        }
        return this;
    }

    public GeneralNames build() {
        int size = this.a.size();
        GeneralName[] generalNameArr = new GeneralName[size];
        for (int i = 0; i != size; i++) {
            generalNameArr[i] = (GeneralName) this.a.elementAt(i);
        }
        return new GeneralNames(generalNameArr);
    }
}
