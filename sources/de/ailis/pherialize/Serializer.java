package de.ailis.pherialize;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
public class Serializer {
    public final Charset a;
    public final List<Object> b;

    public Serializer() {
        this(Charset.forName("UTF-8"));
    }

    public final void a(int i, StringBuffer stringBuffer) {
        stringBuffer.append("i:");
        stringBuffer.append(i);
        stringBuffer.append(';');
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0043 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b(java.lang.Object r11, java.lang.StringBuffer r12, boolean r13) {
        /*
        // Method dump skipped, instructions count: 637
        */
        throw new UnsupportedOperationException("Method not decompiled: de.ailis.pherialize.Serializer.b(java.lang.Object, java.lang.StringBuffer, boolean):void");
    }

    public String serialize(Object obj) {
        StringBuffer stringBuffer = new StringBuffer();
        b(obj, stringBuffer, true);
        return stringBuffer.toString();
    }

    public Serializer(Charset charset) {
        this.a = charset;
        this.b = new ArrayList();
    }
}
