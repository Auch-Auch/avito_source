package com.avito.android.util;

import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0010\f\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"", "", "isNonAscii", "(C)Z", "okhttp_release"}, k = 2, mv = {1, 4, 2})
public final class MimeEncoderKt {
    public static final boolean isNonAscii(char c) {
        return c >= 127 || !(c >= ' ' || c == '\r' || c == '\n' || c == '\t');
    }
}
