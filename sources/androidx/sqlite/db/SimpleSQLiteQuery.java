package androidx.sqlite.db;

import androidx.annotation.Nullable;
public final class SimpleSQLiteQuery implements SupportSQLiteQuery {
    public final String a;
    @Nullable
    public final Object[] b;

    public SimpleSQLiteQuery(String str, @Nullable Object[] objArr) {
        this.a = str;
        this.b = objArr;
    }

    public static void bind(SupportSQLiteProgram supportSQLiteProgram, Object[] objArr) {
        if (objArr != null) {
            int length = objArr.length;
            int i = 0;
            while (i < length) {
                Object obj = objArr[i];
                i++;
                if (obj == null) {
                    supportSQLiteProgram.bindNull(i);
                } else if (obj instanceof byte[]) {
                    supportSQLiteProgram.bindBlob(i, (byte[]) obj);
                } else if (obj instanceof Float) {
                    supportSQLiteProgram.bindDouble(i, (double) ((Float) obj).floatValue());
                } else if (obj instanceof Double) {
                    supportSQLiteProgram.bindDouble(i, ((Double) obj).doubleValue());
                } else if (obj instanceof Long) {
                    supportSQLiteProgram.bindLong(i, ((Long) obj).longValue());
                } else if (obj instanceof Integer) {
                    supportSQLiteProgram.bindLong(i, (long) ((Integer) obj).intValue());
                } else if (obj instanceof Short) {
                    supportSQLiteProgram.bindLong(i, (long) ((Short) obj).shortValue());
                } else if (obj instanceof Byte) {
                    supportSQLiteProgram.bindLong(i, (long) ((Byte) obj).byteValue());
                } else if (obj instanceof String) {
                    supportSQLiteProgram.bindString(i, (String) obj);
                } else if (obj instanceof Boolean) {
                    supportSQLiteProgram.bindLong(i, ((Boolean) obj).booleanValue() ? 1 : 0);
                } else {
                    throw new IllegalArgumentException("Cannot bind " + obj + " at index " + i + " Supported types: null, byte[], float, double, long, int, short, byte, string");
                }
            }
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteQuery
    public void bindTo(SupportSQLiteProgram supportSQLiteProgram) {
        bind(supportSQLiteProgram, this.b);
    }

    @Override // androidx.sqlite.db.SupportSQLiteQuery
    public int getArgCount() {
        Object[] objArr = this.b;
        if (objArr == null) {
            return 0;
        }
        return objArr.length;
    }

    @Override // androidx.sqlite.db.SupportSQLiteQuery
    public String getSql() {
        return this.a;
    }

    public SimpleSQLiteQuery(String str) {
        this(str, null);
    }
}
