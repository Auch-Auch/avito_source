package com.google.zxing.client.result;

import a2.j.k.b.a.a;
import com.google.zxing.Result;
import java.util.ArrayList;
public final class BizcardResultParser extends a {
    @Override // com.google.zxing.client.result.ResultParser
    public AddressBookParsedResult parse(Result result) {
        String massagedText = ResultParser.getMassagedText(result);
        String[] strArr = null;
        if (!massagedText.startsWith("BIZCARD:")) {
            return null;
        }
        String b = ResultParser.b("N:", massagedText, ';', true);
        String b2 = ResultParser.b("X:", massagedText, ';', true);
        if (b == null) {
            b = b2;
        } else if (b2 != null) {
            b = a2.b.a.a.a.L2(b, ' ', b2);
        }
        String b3 = ResultParser.b("T:", massagedText, ';', true);
        String b4 = ResultParser.b("C:", massagedText, ';', true);
        String[] a = ResultParser.a("A:", massagedText, ';', true);
        String b5 = ResultParser.b("B:", massagedText, ';', true);
        String b6 = ResultParser.b("M:", massagedText, ';', true);
        String b8 = ResultParser.b("F:", massagedText, ';', true);
        String b9 = ResultParser.b("E:", massagedText, ';', true);
        String[] maybeWrap = ResultParser.maybeWrap(b);
        ArrayList arrayList = new ArrayList(3);
        if (b5 != null) {
            arrayList.add(b5);
        }
        if (b6 != null) {
            arrayList.add(b6);
        }
        if (b8 != null) {
            arrayList.add(b8);
        }
        int size = arrayList.size();
        if (size != 0) {
            strArr = (String[]) arrayList.toArray(new String[size]);
        }
        return new AddressBookParsedResult(maybeWrap, null, null, strArr, null, ResultParser.maybeWrap(b9), null, null, null, a, null, b4, null, b3, null, null);
    }
}
