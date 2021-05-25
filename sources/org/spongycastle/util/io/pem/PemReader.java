package org.spongycastle.util.io.pem;

import a2.b.a.a.a;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import org.spongycastle.util.encoders.Base64;
public class PemReader extends BufferedReader {
    public PemReader(Reader reader) {
        super(reader);
    }

    public PemObject readPemObject() throws IOException {
        String readLine;
        String readLine2 = readLine();
        while (readLine2 != null && !readLine2.startsWith("-----BEGIN ")) {
            readLine2 = readLine();
        }
        if (readLine2 == null) {
            return null;
        }
        String substring = readLine2.substring(11);
        int indexOf = substring.indexOf(45);
        String substring2 = substring.substring(0, indexOf);
        if (indexOf <= 0) {
            return null;
        }
        String c3 = a.c3("-----END ", substring2);
        StringBuffer stringBuffer = new StringBuffer();
        ArrayList arrayList = new ArrayList();
        while (true) {
            readLine = readLine();
            if (readLine == null) {
                break;
            } else if (readLine.indexOf(":") >= 0) {
                int indexOf2 = readLine.indexOf(58);
                arrayList.add(new PemHeader(readLine.substring(0, indexOf2), readLine.substring(indexOf2 + 1).trim()));
            } else if (readLine.indexOf(c3) != -1) {
                break;
            } else {
                stringBuffer.append(readLine.trim());
            }
        }
        if (readLine != null) {
            return new PemObject(substring2, arrayList, Base64.decode(stringBuffer.toString()));
        }
        throw new IOException(a.c3(c3, " not found"));
    }
}
