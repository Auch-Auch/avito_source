package androidx.sqlite.db;

import a2.b.a.a.a;
import java.util.regex.Pattern;
public final class SupportSQLiteQueryBuilder {
    public static final Pattern j = Pattern.compile("\\s*\\d+\\s*(,\\s*\\d+\\s*)?");
    public boolean a = false;
    public final String b;
    public String[] c = null;
    public String d;
    public Object[] e;
    public String f = null;
    public String g = null;
    public String h = null;
    public String i = null;

    public SupportSQLiteQueryBuilder(String str) {
        this.b = str;
    }

    public static void a(StringBuilder sb, String str, String str2) {
        if (!b(str2)) {
            sb.append(str);
            sb.append(str2);
        }
    }

    public static boolean b(String str) {
        return str == null || str.length() == 0;
    }

    public static SupportSQLiteQueryBuilder builder(String str) {
        return new SupportSQLiteQueryBuilder(str);
    }

    public SupportSQLiteQueryBuilder columns(String[] strArr) {
        this.c = strArr;
        return this;
    }

    public SupportSQLiteQuery create() {
        if (!b(this.f) || b(this.g)) {
            StringBuilder sb = new StringBuilder(120);
            sb.append("SELECT ");
            if (this.a) {
                sb.append("DISTINCT ");
            }
            String[] strArr = this.c;
            if (strArr == null || strArr.length == 0) {
                sb.append(" * ");
            } else {
                int length = strArr.length;
                for (int i2 = 0; i2 < length; i2++) {
                    String str = strArr[i2];
                    if (i2 > 0) {
                        sb.append(", ");
                    }
                    sb.append(str);
                }
                sb.append(' ');
            }
            sb.append(" FROM ");
            sb.append(this.b);
            a(sb, " WHERE ", this.d);
            a(sb, " GROUP BY ", this.f);
            a(sb, " HAVING ", this.g);
            a(sb, " ORDER BY ", this.h);
            a(sb, " LIMIT ", this.i);
            return new SimpleSQLiteQuery(sb.toString(), this.e);
        }
        throw new IllegalArgumentException("HAVING clauses are only permitted when using a groupBy clause");
    }

    public SupportSQLiteQueryBuilder distinct() {
        this.a = true;
        return this;
    }

    public SupportSQLiteQueryBuilder groupBy(String str) {
        this.f = str;
        return this;
    }

    public SupportSQLiteQueryBuilder having(String str) {
        this.g = str;
        return this;
    }

    public SupportSQLiteQueryBuilder limit(String str) {
        if (b(str) || j.matcher(str).matches()) {
            this.i = str;
            return this;
        }
        throw new IllegalArgumentException(a.c3("invalid LIMIT clauses:", str));
    }

    public SupportSQLiteQueryBuilder orderBy(String str) {
        this.h = str;
        return this;
    }

    public SupportSQLiteQueryBuilder selection(String str, Object[] objArr) {
        this.d = str;
        this.e = objArr;
        return this;
    }
}
