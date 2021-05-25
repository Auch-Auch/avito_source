package com.google.zxing.client.result;

import a2.j.k.b.a.a;
import com.google.zxing.Result;
public final class AddressBookDoCoMoResultParser extends a {
    @Override // com.google.zxing.client.result.ResultParser
    public AddressBookParsedResult parse(Result result) {
        String[] a;
        String massagedText = ResultParser.getMassagedText(result);
        if (!massagedText.startsWith("MECARD:") || (a = ResultParser.a("N:", massagedText, ';', true)) == null) {
            return null;
        }
        String str = a[0];
        int indexOf = str.indexOf(44);
        if (indexOf >= 0) {
            str = str.substring(indexOf + 1) + ' ' + str.substring(0, indexOf);
        }
        String b = ResultParser.b("SOUND:", massagedText, ';', true);
        String[] a3 = ResultParser.a("TEL:", massagedText, ';', true);
        String[] a4 = ResultParser.a("EMAIL:", massagedText, ';', true);
        String b2 = ResultParser.b("NOTE:", massagedText, ';', false);
        String[] a5 = ResultParser.a("ADR:", massagedText, ';', true);
        String b3 = ResultParser.b("BDAY:", massagedText, ';', true);
        return new AddressBookParsedResult(ResultParser.maybeWrap(str), null, b, a3, null, a4, null, null, b2, a5, null, ResultParser.b("ORG:", massagedText, ';', true), !ResultParser.isStringOfDigits(b3, 8) ? null : b3, null, ResultParser.a("URL:", massagedText, ';', true), null);
    }
}
