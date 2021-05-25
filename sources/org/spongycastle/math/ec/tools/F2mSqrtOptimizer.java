package org.spongycastle.math.ec.tools;

import java.io.PrintStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.TreeSet;
import org.spongycastle.asn1.x9.ECNamedCurveTable;
import org.spongycastle.asn1.x9.X9ECParameters;
import org.spongycastle.crypto.ec.CustomNamedCurves;
import org.spongycastle.math.ec.ECAlgorithms;
import org.spongycastle.math.ec.ECFieldElement;
public class F2mSqrtOptimizer {
    public static void a(X9ECParameters x9ECParameters) {
        ECFieldElement fromBigInteger = x9ECParameters.getCurve().fromBigInteger(BigInteger.valueOf(2));
        ECFieldElement sqrt = fromBigInteger.sqrt();
        System.out.println(sqrt.toBigInteger().toString(16).toUpperCase());
        if (!sqrt.square().equals(fromBigInteger)) {
            throw new IllegalStateException("Optimized-sqrt sanity check failed");
        }
    }

    public static void main(String[] strArr) {
        Enumeration names = ECNamedCurveTable.getNames();
        ArrayList arrayList = new ArrayList();
        while (names.hasMoreElements()) {
            arrayList.add(names.nextElement());
        }
        TreeSet treeSet = new TreeSet(arrayList);
        Enumeration names2 = CustomNamedCurves.getNames();
        ArrayList arrayList2 = new ArrayList();
        while (names2.hasMoreElements()) {
            arrayList2.add(names2.nextElement());
        }
        treeSet.addAll(arrayList2);
        Iterator it = treeSet.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            X9ECParameters byName = CustomNamedCurves.getByName(str);
            if (byName == null) {
                byName = ECNamedCurveTable.getByName(str);
            }
            if (byName != null && ECAlgorithms.isF2mCurve(byName.getCurve())) {
                PrintStream printStream = System.out;
                printStream.print(str + ":");
                a(byName);
            }
        }
    }

    public static void printRootZ(X9ECParameters x9ECParameters) {
        if (ECAlgorithms.isF2mCurve(x9ECParameters.getCurve())) {
            a(x9ECParameters);
            return;
        }
        throw new IllegalArgumentException("Sqrt optimization only defined over characteristic-2 fields");
    }
}
