package com.google.zxing.client.result;

import a2.j.k.b.a.a;
import com.google.zxing.Result;
public final class BookmarkDoCoMoResultParser extends a {
    @Override // com.google.zxing.client.result.ResultParser
    public URIParsedResult parse(Result result) {
        String text = result.getText();
        if (!text.startsWith("MEBKM:")) {
            return null;
        }
        String b = ResultParser.b("TITLE:", text, ';', true);
        String[] a = ResultParser.a("URL:", text, ';', true);
        if (a == null) {
            return null;
        }
        String str = a[0];
        if (URIResultParser.d(str)) {
            return new URIParsedResult(str, b);
        }
        return null;
    }
}
