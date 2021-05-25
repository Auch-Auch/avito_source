package com.google.zxing.client.result;

import com.google.zxing.Result;
public final class WifiResultParser extends ResultParser {
    @Override // com.google.zxing.client.result.ResultParser
    public WifiParsedResult parse(Result result) {
        String substring;
        String b;
        String massagedText = ResultParser.getMassagedText(result);
        if (!massagedText.startsWith("WIFI:") || (b = ResultParser.b("S:", (substring = massagedText.substring(5)), ';', false)) == null || b.isEmpty()) {
            return null;
        }
        String b2 = ResultParser.b("P:", substring, ';', false);
        String b3 = ResultParser.b("T:", substring, ';', false);
        if (b3 == null) {
            b3 = "nopass";
        }
        return new WifiParsedResult(b3, b, b2, Boolean.parseBoolean(ResultParser.b("H:", substring, ';', false)), ResultParser.b("I:", substring, ';', false), ResultParser.b("A:", substring, ';', false), ResultParser.b("E:", substring, ';', false), ResultParser.b("H:", substring, ';', false));
    }
}
