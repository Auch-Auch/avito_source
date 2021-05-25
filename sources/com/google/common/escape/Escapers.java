package com.google.common.escape;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.CharCompanionObject;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
@Beta
@GwtCompatible
public final class Escapers {
    public static final Escaper a = new a();

    public static class a extends CharEscaper {
        @Override // com.google.common.escape.CharEscaper, com.google.common.escape.Escaper
        public String escape(String str) {
            return (String) Preconditions.checkNotNull(str);
        }

        @Override // com.google.common.escape.CharEscaper
        public char[] escape(char c) {
            return null;
        }
    }

    public static Builder builder() {
        return new Builder(null);
    }

    public static String computeReplacement(CharEscaper charEscaper, char c) {
        char[] escape = charEscaper.escape(c);
        if (escape == null) {
            return null;
        }
        return new String(escape);
    }

    public static Escaper nullEscaper() {
        return a;
    }

    public static String computeReplacement(UnicodeEscaper unicodeEscaper, int i) {
        char[] escape = unicodeEscaper.escape(i);
        if (escape == null) {
            return null;
        }
        return new String(escape);
    }

    @Beta
    public static final class Builder {
        public final Map<Character, String> a = new HashMap();
        public char b = 0;
        public char c = CharCompanionObject.MAX_VALUE;
        public String d = null;

        public class a extends ArrayBasedCharEscaper {
            public final char[] f;

            public a(Map map, char c, char c2) {
                super(map, c, c2);
                String str = Builder.this.d;
                this.f = str != null ? str.toCharArray() : null;
            }

            @Override // com.google.common.escape.ArrayBasedCharEscaper
            public char[] escapeUnsafe(char c) {
                return this.f;
            }
        }

        public Builder() {
        }

        @CanIgnoreReturnValue
        public Builder addEscape(char c2, String str) {
            Preconditions.checkNotNull(str);
            this.a.put(Character.valueOf(c2), str);
            return this;
        }

        public Escaper build() {
            return new a(this.a, this.b, this.c);
        }

        @CanIgnoreReturnValue
        public Builder setSafeRange(char c2, char c3) {
            this.b = c2;
            this.c = c3;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setUnsafeReplacement(@NullableDecl String str) {
            this.d = str;
            return this;
        }

        public Builder(a aVar) {
        }
    }
}
