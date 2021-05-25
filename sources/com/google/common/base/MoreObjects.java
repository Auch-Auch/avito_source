package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Arrays;
import java.util.Objects;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
@GwtCompatible
public final class MoreObjects {

    public static final class ToStringHelper {
        public final String a;
        public final a b;
        public a c;
        public boolean d = false;

        public static final class a {
            @NullableDecl
            public String a;
            @NullableDecl
            public Object b;
            @NullableDecl
            public a c;

            public a(a aVar) {
            }
        }

        public ToStringHelper(String str, a aVar) {
            a aVar2 = new a(null);
            this.b = aVar2;
            this.c = aVar2;
            this.a = (String) Preconditions.checkNotNull(str);
        }

        public final ToStringHelper a(@NullableDecl Object obj) {
            a aVar = new a(null);
            this.c.c = aVar;
            this.c = aVar;
            aVar.b = obj;
            return this;
        }

        @CanIgnoreReturnValue
        public ToStringHelper add(String str, @NullableDecl Object obj) {
            b(str, obj);
            return this;
        }

        @CanIgnoreReturnValue
        public ToStringHelper addValue(@NullableDecl Object obj) {
            a(obj);
            return this;
        }

        public final ToStringHelper b(String str, @NullableDecl Object obj) {
            a aVar = new a(null);
            this.c.c = aVar;
            this.c = aVar;
            aVar.b = obj;
            aVar.a = (String) Preconditions.checkNotNull(str);
            return this;
        }

        @CanIgnoreReturnValue
        public ToStringHelper omitNullValues() {
            this.d = true;
            return this;
        }

        public String toString() {
            boolean z = this.d;
            StringBuilder sb = new StringBuilder(32);
            sb.append(this.a);
            sb.append('{');
            String str = "";
            for (a aVar = this.b.c; aVar != null; aVar = aVar.c) {
                Object obj = aVar.b;
                if (!z || obj != null) {
                    sb.append(str);
                    String str2 = aVar.a;
                    if (str2 != null) {
                        sb.append(str2);
                        sb.append('=');
                    }
                    if (obj == null || !obj.getClass().isArray()) {
                        sb.append(obj);
                    } else {
                        String deepToString = Arrays.deepToString(new Object[]{obj});
                        sb.append((CharSequence) deepToString, 1, deepToString.length() - 1);
                    }
                    str = ", ";
                }
            }
            sb.append('}');
            return sb.toString();
        }

        @CanIgnoreReturnValue
        public ToStringHelper add(String str, boolean z) {
            b(str, String.valueOf(z));
            return this;
        }

        @CanIgnoreReturnValue
        public ToStringHelper addValue(boolean z) {
            a(String.valueOf(z));
            return this;
        }

        @CanIgnoreReturnValue
        public ToStringHelper add(String str, char c2) {
            b(str, String.valueOf(c2));
            return this;
        }

        @CanIgnoreReturnValue
        public ToStringHelper addValue(char c2) {
            a(String.valueOf(c2));
            return this;
        }

        @CanIgnoreReturnValue
        public ToStringHelper add(String str, double d2) {
            b(str, String.valueOf(d2));
            return this;
        }

        @CanIgnoreReturnValue
        public ToStringHelper addValue(double d2) {
            a(String.valueOf(d2));
            return this;
        }

        @CanIgnoreReturnValue
        public ToStringHelper add(String str, float f) {
            b(str, String.valueOf(f));
            return this;
        }

        @CanIgnoreReturnValue
        public ToStringHelper addValue(float f) {
            a(String.valueOf(f));
            return this;
        }

        @CanIgnoreReturnValue
        public ToStringHelper add(String str, int i) {
            b(str, String.valueOf(i));
            return this;
        }

        @CanIgnoreReturnValue
        public ToStringHelper addValue(int i) {
            a(String.valueOf(i));
            return this;
        }

        @CanIgnoreReturnValue
        public ToStringHelper add(String str, long j) {
            b(str, String.valueOf(j));
            return this;
        }

        @CanIgnoreReturnValue
        public ToStringHelper addValue(long j) {
            a(String.valueOf(j));
            return this;
        }
    }

    public static <T> T firstNonNull(@NullableDecl T t, @NullableDecl T t2) {
        if (t != null) {
            return t;
        }
        Objects.requireNonNull(t2, "Both parameters are null");
        return t2;
    }

    public static ToStringHelper toStringHelper(Object obj) {
        return new ToStringHelper(obj.getClass().getSimpleName(), null);
    }

    public static ToStringHelper toStringHelper(Class<?> cls) {
        return new ToStringHelper(cls.getSimpleName(), null);
    }

    public static ToStringHelper toStringHelper(String str) {
        return new ToStringHelper(str, null);
    }
}
