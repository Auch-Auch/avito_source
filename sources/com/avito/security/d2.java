package com.avito.security;

import com.google.android.exoplayer2.C;
import java.nio.charset.Charset;
public final class d2 {
    public static final Charset a;

    static {
        Charset forName = Charset.forName("UTF-8");
        j1.a((Object) forName, "Charset.forName(\"UTF-8\")");
        a = forName;
        j1.a((Object) Charset.forName(C.UTF16_NAME), "Charset.forName(\"UTF-16\")");
        j1.a((Object) Charset.forName("UTF-16BE"), "Charset.forName(\"UTF-16BE\")");
        j1.a((Object) Charset.forName(C.UTF16LE_NAME), "Charset.forName(\"UTF-16LE\")");
        j1.a((Object) Charset.forName(C.ASCII_NAME), "Charset.forName(\"US-ASCII\")");
        j1.a((Object) Charset.forName("ISO-8859-1"), "Charset.forName(\"ISO-8859-1\")");
    }
}
