package com.facebook.common.internal;

import com.facebook.infer.annotation.Nullsafe;
import java.util.Arrays;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;
@Nullsafe(Nullsafe.Mode.STRICT)
public final class Objects {

    public static final class ToStringHelper {
        public final String a;
        public final a b;
        public a c;
        public boolean d = false;

        public static final class a {
            @Nullable
            public String a;
            @Nullable
            public Object b;
            @Nullable
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

        public final ToStringHelper a(@Nullable Object obj) {
            a aVar = new a(null);
            this.c.c = aVar;
            this.c = aVar;
            aVar.b = obj;
            return this;
        }

        public ToStringHelper add(String str, @Nullable Object obj) {
            b(str, obj);
            return this;
        }

        public ToStringHelper addValue(@Nullable Object obj) {
            a(obj);
            return this;
        }

        public final ToStringHelper b(String str, @Nullable Object obj) {
            a aVar = new a(null);
            this.c.c = aVar;
            this.c = aVar;
            aVar.b = obj;
            aVar.a = (String) Preconditions.checkNotNull(str);
            return this;
        }

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

        public ToStringHelper add(String str, boolean z) {
            b(str, String.valueOf(z));
            return this;
        }

        public ToStringHelper addValue(boolean z) {
            a(String.valueOf(z));
            return this;
        }

        public ToStringHelper add(String str, char c2) {
            b(str, String.valueOf(c2));
            return this;
        }

        public ToStringHelper addValue(char c2) {
            a(String.valueOf(c2));
            return this;
        }

        public ToStringHelper add(String str, double d2) {
            b(str, String.valueOf(d2));
            return this;
        }

        public ToStringHelper addValue(double d2) {
            a(String.valueOf(d2));
            return this;
        }

        public ToStringHelper add(String str, float f) {
            b(str, String.valueOf(f));
            return this;
        }

        public ToStringHelper addValue(float f) {
            a(String.valueOf(f));
            return this;
        }

        public ToStringHelper add(String str, int i) {
            b(str, String.valueOf(i));
            return this;
        }

        public ToStringHelper addValue(int i) {
            a(String.valueOf(i));
            return this;
        }

        public ToStringHelper add(String str, long j) {
            b(str, String.valueOf(j));
            return this;
        }

        public ToStringHelper addValue(long j) {
            a(String.valueOf(j));
            return this;
        }
    }

    @CheckReturnValue
    public static boolean equal(@Nullable Object obj, @Nullable Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static <T> T firstNonNull(@Nullable T t, @Nullable T t2) {
        return t != null ? t : (T) Preconditions.checkNotNull(t2);
    }

    public static int hashCode(@Nullable Object... objArr) {
        return Arrays.hashCode(objArr);
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
