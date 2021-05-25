package androidx.room.util;

import a2.b.a.a.a;
import android.database.Cursor;
import androidx.annotation.RestrictTo;
import androidx.sqlite.db.SupportSQLiteDatabase;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class ViewInfo {
    public final String name;
    public final String sql;

    public ViewInfo(String str, String str2) {
        this.name = str;
        this.sql = str2;
    }

    public static ViewInfo read(SupportSQLiteDatabase supportSQLiteDatabase, String str) {
        Cursor query = supportSQLiteDatabase.query("SELECT name, sql FROM sqlite_master WHERE type = 'view' AND name = '" + str + "'");
        try {
            if (query.moveToFirst()) {
                return new ViewInfo(query.getString(0), query.getString(1));
            }
            ViewInfo viewInfo = new ViewInfo(str, null);
            query.close();
            return viewInfo;
        } finally {
            query.close();
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ViewInfo viewInfo = (ViewInfo) obj;
        String str = this.name;
        if (str == null ? viewInfo.name == null : str.equals(viewInfo.name)) {
            String str2 = this.sql;
            if (str2 != null) {
                if (str2.equals(viewInfo.sql)) {
                    return true;
                }
            } else if (viewInfo.sql == null) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        String str = this.name;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.sql;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder L = a.L("ViewInfo{name='");
        a.k1(L, this.name, '\'', ", sql='");
        L.append(this.sql);
        L.append('\'');
        L.append('}');
        return L.toString();
    }
}
