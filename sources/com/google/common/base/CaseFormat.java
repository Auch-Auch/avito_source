package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.spongycastle.pqc.math.linearalgebra.Matrix;
@GwtCompatible
public enum CaseFormat {
    LOWER_HYPHEN(CharMatcher.is('-'), "-") {
        @Override // com.google.common.base.CaseFormat
        public String b(CaseFormat caseFormat, String str) {
            if (caseFormat == CaseFormat.LOWER_UNDERSCORE) {
                return str.replace('-', '_');
            }
            if (caseFormat == CaseFormat.UPPER_UNDERSCORE) {
                return Ascii.toUpperCase(str.replace('-', '_'));
            }
            return CaseFormat.super.b(caseFormat, str);
        }

        @Override // com.google.common.base.CaseFormat
        public String d(String str) {
            return Ascii.toLowerCase(str);
        }
    },
    LOWER_UNDERSCORE(CharMatcher.is('_'), "_") {
        @Override // com.google.common.base.CaseFormat
        public String b(CaseFormat caseFormat, String str) {
            if (caseFormat == CaseFormat.LOWER_HYPHEN) {
                return str.replace('_', '-');
            }
            if (caseFormat == CaseFormat.UPPER_UNDERSCORE) {
                return Ascii.toUpperCase(str);
            }
            return CaseFormat.super.b(caseFormat, str);
        }

        @Override // com.google.common.base.CaseFormat
        public String d(String str) {
            return Ascii.toLowerCase(str);
        }
    },
    LOWER_CAMEL(CharMatcher.inRange('A', Matrix.MATRIX_TYPE_ZERO), "") {
        @Override // com.google.common.base.CaseFormat
        public String c(String str) {
            return Ascii.toLowerCase(str);
        }

        @Override // com.google.common.base.CaseFormat
        public String d(String str) {
            return CaseFormat.a(str);
        }
    },
    UPPER_CAMEL(CharMatcher.inRange('A', Matrix.MATRIX_TYPE_ZERO), "") {
        @Override // com.google.common.base.CaseFormat
        public String d(String str) {
            return CaseFormat.a(str);
        }
    },
    UPPER_UNDERSCORE(CharMatcher.is('_'), "_") {
        @Override // com.google.common.base.CaseFormat
        public String b(CaseFormat caseFormat, String str) {
            if (caseFormat == CaseFormat.LOWER_HYPHEN) {
                return Ascii.toLowerCase(str.replace('_', '-'));
            }
            if (caseFormat == CaseFormat.LOWER_UNDERSCORE) {
                return Ascii.toLowerCase(str);
            }
            return CaseFormat.super.b(caseFormat, str);
        }

        @Override // com.google.common.base.CaseFormat
        public String d(String str) {
            return Ascii.toUpperCase(str);
        }
    };
    
    public final CharMatcher a;
    public final String b;

    public static final class f extends Converter<String, String> implements Serializable {
        private static final long serialVersionUID = 0;
        public final CaseFormat c;
        public final CaseFormat d;

        public f(CaseFormat caseFormat, CaseFormat caseFormat2) {
            this.c = (CaseFormat) Preconditions.checkNotNull(caseFormat);
            this.d = (CaseFormat) Preconditions.checkNotNull(caseFormat2);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.google.common.base.Converter
        public String doBackward(String str) {
            return this.d.to(this.c, str);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.google.common.base.Converter
        public String doForward(String str) {
            return this.c.to(this.d, str);
        }

        @Override // com.google.common.base.Converter, com.google.common.base.Function, java.lang.Object
        public boolean equals(@NullableDecl Object obj) {
            if (!(obj instanceof f)) {
                return false;
            }
            f fVar = (f) obj;
            if (!this.c.equals(fVar.c) || !this.d.equals(fVar.d)) {
                return false;
            }
            return true;
        }

        @Override // java.lang.Object
        public int hashCode() {
            return this.c.hashCode() ^ this.d.hashCode();
        }

        @Override // java.lang.Object
        public String toString() {
            return this.c + ".converterTo(" + this.d + ")";
        }
    }

    /* access modifiers changed from: public */
    CaseFormat(CharMatcher charMatcher, String str, a aVar) {
        this.a = charMatcher;
        this.b = str;
    }

    public static String a(String str) {
        if (str.isEmpty()) {
            return str;
        }
        return Ascii.toUpperCase(str.charAt(0)) + Ascii.toLowerCase(str.substring(1));
    }

    public String b(CaseFormat caseFormat, String str) {
        StringBuilder sb = null;
        int i = 0;
        int i2 = -1;
        while (true) {
            i2 = this.a.indexIn(str, i2 + 1);
            if (i2 == -1) {
                break;
            }
            if (i == 0) {
                sb = new StringBuilder((this.b.length() * 4) + str.length());
                sb.append(caseFormat.c(str.substring(i, i2)));
            } else {
                sb.append(caseFormat.d(str.substring(i, i2)));
            }
            sb.append(caseFormat.b);
            i = this.b.length() + i2;
        }
        if (i == 0) {
            return caseFormat.c(str);
        }
        sb.append(caseFormat.d(str.substring(i)));
        return sb.toString();
    }

    public String c(String str) {
        return d(str);
    }

    public Converter<String, String> converterTo(CaseFormat caseFormat) {
        return new f(this, caseFormat);
    }

    public abstract String d(String str);

    public final String to(CaseFormat caseFormat, String str) {
        Preconditions.checkNotNull(caseFormat);
        Preconditions.checkNotNull(str);
        return caseFormat == this ? str : b(caseFormat, str);
    }
}
