package org.spongycastle.util.io.pem;

import a2.b.a.a.a;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Writer;
import org.spongycastle.util.Strings;
import org.spongycastle.util.encoders.Base64;
public class PemWriter extends BufferedWriter {
    public final int a;
    public char[] b = new char[64];

    public PemWriter(Writer writer) {
        super(writer);
        String lineSeparator = Strings.lineSeparator();
        if (lineSeparator != null) {
            this.a = lineSeparator.length();
        } else {
            this.a = 2;
        }
    }

    public int getOutputSize(PemObject pemObject) {
        int length = ((pemObject.getType().length() + 10 + this.a) * 2) + 6 + 4;
        if (!pemObject.getHeaders().isEmpty()) {
            for (PemHeader pemHeader : pemObject.getHeaders()) {
                length += pemHeader.getValue().length() + pemHeader.getName().length() + 2 + this.a;
            }
            length += this.a;
        }
        int length2 = ((pemObject.getContent().length + 2) / 3) * 4;
        return a.c2(((length2 + 64) - 1) / 64, this.a, length2, length);
    }

    public void writeObject(PemObjectGenerator pemObjectGenerator) throws IOException {
        char[] cArr;
        int i;
        PemObject generate = pemObjectGenerator.generate();
        String type = generate.getType();
        write("-----BEGIN " + type + "-----");
        newLine();
        if (!generate.getHeaders().isEmpty()) {
            for (PemHeader pemHeader : generate.getHeaders()) {
                write(pemHeader.getName());
                write(": ");
                write(pemHeader.getValue());
                newLine();
            }
            newLine();
        }
        byte[] encode = Base64.encode(generate.getContent());
        int i2 = 0;
        while (i2 < encode.length) {
            int i3 = 0;
            while (true) {
                cArr = this.b;
                if (i3 == cArr.length || (i = i2 + i3) >= encode.length) {
                    break;
                }
                cArr[i3] = (char) encode[i];
                i3++;
            }
            write(cArr, 0, i3);
            newLine();
            i2 += this.b.length;
        }
        String type2 = generate.getType();
        write("-----END " + type2 + "-----");
        newLine();
    }
}
