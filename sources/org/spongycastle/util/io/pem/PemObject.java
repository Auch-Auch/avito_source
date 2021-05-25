package org.spongycastle.util.io.pem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class PemObject implements PemObjectGenerator {
    public static final List d = Collections.unmodifiableList(new ArrayList());
    public String a;
    public List b;
    public byte[] c;

    public PemObject(String str, byte[] bArr) {
        this(str, d, bArr);
    }

    @Override // org.spongycastle.util.io.pem.PemObjectGenerator
    public PemObject generate() throws PemGenerationException {
        return this;
    }

    public byte[] getContent() {
        return this.c;
    }

    public List getHeaders() {
        return this.b;
    }

    public String getType() {
        return this.a;
    }

    public PemObject(String str, List list, byte[] bArr) {
        this.a = str;
        this.b = Collections.unmodifiableList(list);
        this.c = bArr;
    }
}
