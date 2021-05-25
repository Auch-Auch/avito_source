package androidx.room.util;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.room.ColumnInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class TableInfo {
    public static final int CREATED_FROM_DATABASE = 2;
    public static final int CREATED_FROM_ENTITY = 1;
    public static final int CREATED_FROM_UNKNOWN = 0;
    public final Map<String, Column> columns;
    public final Set<ForeignKey> foreignKeys;
    @Nullable
    public final Set<Index> indices;
    public final String name;

    public static class Column {
        public final int a;
        @ColumnInfo.SQLiteTypeAffinity
        public final int affinity;
        public final String defaultValue;
        public final String name;
        public final boolean notNull;
        public final int primaryKeyPosition;
        public final String type;

        @Deprecated
        public Column(String str, String str2, boolean z, int i) {
            this(str, str2, z, i, null, 0);
        }

        public boolean equals(Object obj) {
            String str;
            String str2;
            String str3;
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Column column = (Column) obj;
            if (this.primaryKeyPosition != column.primaryKeyPosition || !this.name.equals(column.name) || this.notNull != column.notNull) {
                return false;
            }
            if (this.a == 1 && column.a == 2 && (str3 = this.defaultValue) != null && !str3.equals(column.defaultValue)) {
                return false;
            }
            if (this.a == 2 && column.a == 1 && (str2 = column.defaultValue) != null && !str2.equals(this.defaultValue)) {
                return false;
            }
            int i = this.a;
            if ((i == 0 || i != column.a || ((str = this.defaultValue) == null ? column.defaultValue == null : str.equals(column.defaultValue))) && this.affinity == column.affinity) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (((((this.name.hashCode() * 31) + this.affinity) * 31) + (this.notNull ? 1231 : 1237)) * 31) + this.primaryKeyPosition;
        }

        public boolean isPrimaryKey() {
            return this.primaryKeyPosition > 0;
        }

        public String toString() {
            StringBuilder L = a2.b.a.a.a.L("Column{name='");
            a2.b.a.a.a.k1(L, this.name, '\'', ", type='");
            a2.b.a.a.a.k1(L, this.type, '\'', ", affinity='");
            L.append(this.affinity);
            L.append('\'');
            L.append(", notNull=");
            L.append(this.notNull);
            L.append(", primaryKeyPosition=");
            L.append(this.primaryKeyPosition);
            L.append(", defaultValue='");
            L.append(this.defaultValue);
            L.append('\'');
            L.append('}');
            return L.toString();
        }

        public Column(String str, String str2, boolean z, int i, String str3, int i2) {
            this.name = str;
            this.type = str2;
            this.notNull = z;
            this.primaryKeyPosition = i;
            int i3 = 5;
            if (str2 != null) {
                String upperCase = str2.toUpperCase(Locale.US);
                if (upperCase.contains("INT")) {
                    i3 = 3;
                } else if (upperCase.contains("CHAR") || upperCase.contains("CLOB") || upperCase.contains("TEXT")) {
                    i3 = 2;
                } else if (!upperCase.contains("BLOB")) {
                    i3 = (upperCase.contains("REAL") || upperCase.contains("FLOA") || upperCase.contains("DOUB")) ? 4 : 1;
                }
            }
            this.affinity = i3;
            this.defaultValue = str3;
            this.a = i2;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static class ForeignKey {
        @NonNull
        public final List<String> columnNames;
        @NonNull
        public final String onDelete;
        @NonNull
        public final String onUpdate;
        @NonNull
        public final List<String> referenceColumnNames;
        @NonNull
        public final String referenceTable;

        public ForeignKey(@NonNull String str, @NonNull String str2, @NonNull String str3, @NonNull List<String> list, @NonNull List<String> list2) {
            this.referenceTable = str;
            this.onDelete = str2;
            this.onUpdate = str3;
            this.columnNames = Collections.unmodifiableList(list);
            this.referenceColumnNames = Collections.unmodifiableList(list2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            ForeignKey foreignKey = (ForeignKey) obj;
            if (this.referenceTable.equals(foreignKey.referenceTable) && this.onDelete.equals(foreignKey.onDelete) && this.onUpdate.equals(foreignKey.onUpdate) && this.columnNames.equals(foreignKey.columnNames)) {
                return this.referenceColumnNames.equals(foreignKey.referenceColumnNames);
            }
            return false;
        }

        public int hashCode() {
            int B0 = a2.b.a.a.a.B0(this.onUpdate, a2.b.a.a.a.B0(this.onDelete, this.referenceTable.hashCode() * 31, 31), 31);
            return this.referenceColumnNames.hashCode() + ((this.columnNames.hashCode() + B0) * 31);
        }

        public String toString() {
            StringBuilder L = a2.b.a.a.a.L("ForeignKey{referenceTable='");
            a2.b.a.a.a.k1(L, this.referenceTable, '\'', ", onDelete='");
            a2.b.a.a.a.k1(L, this.onDelete, '\'', ", onUpdate='");
            a2.b.a.a.a.k1(L, this.onUpdate, '\'', ", columnNames=");
            L.append(this.columnNames);
            L.append(", referenceColumnNames=");
            L.append(this.referenceColumnNames);
            L.append('}');
            return L.toString();
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static class Index {
        public static final String DEFAULT_PREFIX = "index_";
        public final List<String> columns;
        public final String name;
        public final boolean unique;

        public Index(String str, boolean z, List<String> list) {
            this.name = str;
            this.unique = z;
            this.columns = list;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Index index = (Index) obj;
            if (this.unique != index.unique || !this.columns.equals(index.columns)) {
                return false;
            }
            if (this.name.startsWith(DEFAULT_PREFIX)) {
                return index.name.startsWith(DEFAULT_PREFIX);
            }
            return this.name.equals(index.name);
        }

        public int hashCode() {
            int i;
            if (this.name.startsWith(DEFAULT_PREFIX)) {
                i = -1184239155;
            } else {
                i = this.name.hashCode();
            }
            return this.columns.hashCode() + (((i * 31) + (this.unique ? 1 : 0)) * 31);
        }

        public String toString() {
            StringBuilder L = a2.b.a.a.a.L("Index{name='");
            a2.b.a.a.a.k1(L, this.name, '\'', ", unique=");
            L.append(this.unique);
            L.append(", columns=");
            L.append(this.columns);
            L.append('}');
            return L.toString();
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static class a implements Comparable<a> {
        public final int a;
        public final int b;
        public final String c;
        public final String d;

        public a(int i, int i2, String str, String str2) {
            this.a = i;
            this.b = i2;
            this.c = str;
            this.d = str2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // java.lang.Comparable
        public int compareTo(@NonNull a aVar) {
            a aVar2 = aVar;
            int i = this.a - aVar2.a;
            return i == 0 ? this.b - aVar2.b : i;
        }
    }

    public TableInfo(String str, Map<String, Column> map, Set<ForeignKey> set, Set<Index> set2) {
        Set<Index> set3;
        this.name = str;
        this.columns = Collections.unmodifiableMap(map);
        this.foreignKeys = Collections.unmodifiableSet(set);
        if (set2 == null) {
            set3 = null;
        } else {
            set3 = Collections.unmodifiableSet(set2);
        }
        this.indices = set3;
    }

    public static List<a> a(Cursor cursor) {
        int columnIndex = cursor.getColumnIndex("id");
        int columnIndex2 = cursor.getColumnIndex("seq");
        int columnIndex3 = cursor.getColumnIndex("from");
        int columnIndex4 = cursor.getColumnIndex("to");
        int count = cursor.getCount();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < count; i++) {
            cursor.moveToPosition(i);
            arrayList.add(new a(cursor.getInt(columnIndex), cursor.getInt(columnIndex2), cursor.getString(columnIndex3), cursor.getString(columnIndex4)));
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    @Nullable
    public static Index b(SupportSQLiteDatabase supportSQLiteDatabase, String str, boolean z) {
        Cursor query = supportSQLiteDatabase.query("PRAGMA index_xinfo(`" + str + "`)");
        try {
            int columnIndex = query.getColumnIndex("seqno");
            int columnIndex2 = query.getColumnIndex("cid");
            int columnIndex3 = query.getColumnIndex("name");
            if (!(columnIndex == -1 || columnIndex2 == -1)) {
                if (columnIndex3 != -1) {
                    TreeMap treeMap = new TreeMap();
                    while (query.moveToNext()) {
                        if (query.getInt(columnIndex2) >= 0) {
                            int i = query.getInt(columnIndex);
                            treeMap.put(Integer.valueOf(i), query.getString(columnIndex3));
                        }
                    }
                    ArrayList arrayList = new ArrayList(treeMap.size());
                    arrayList.addAll(treeMap.values());
                    Index index = new Index(str, z, arrayList);
                    query.close();
                    return index;
                }
            }
            return null;
        } finally {
            query.close();
        }
    }

    /* JADX INFO: finally extract failed */
    public static TableInfo read(SupportSQLiteDatabase supportSQLiteDatabase, String str) {
        List<a> list;
        int i;
        int i2;
        int i3;
        Cursor query = supportSQLiteDatabase.query("PRAGMA table_info(`" + str + "`)");
        HashMap hashMap = new HashMap();
        try {
            if (query.getColumnCount() > 0) {
                int columnIndex = query.getColumnIndex("name");
                int columnIndex2 = query.getColumnIndex("type");
                int columnIndex3 = query.getColumnIndex("notnull");
                int columnIndex4 = query.getColumnIndex("pk");
                int columnIndex5 = query.getColumnIndex("dflt_value");
                while (query.moveToNext()) {
                    String string = query.getString(columnIndex);
                    hashMap.put(string, new Column(string, query.getString(columnIndex2), query.getInt(columnIndex3) != 0, query.getInt(columnIndex4), query.getString(columnIndex5), 2));
                }
            }
            query.close();
            HashSet hashSet = new HashSet();
            Cursor query2 = supportSQLiteDatabase.query("PRAGMA foreign_key_list(`" + str + "`)");
            try {
                int columnIndex6 = query2.getColumnIndex("id");
                int columnIndex7 = query2.getColumnIndex("seq");
                int columnIndex8 = query2.getColumnIndex("table");
                int columnIndex9 = query2.getColumnIndex("on_delete");
                int columnIndex10 = query2.getColumnIndex("on_update");
                List<a> a3 = a(query2);
                int count = query2.getCount();
                int i4 = 0;
                while (i4 < count) {
                    query2.moveToPosition(i4);
                    if (query2.getInt(columnIndex7) != 0) {
                        i3 = columnIndex6;
                        i2 = columnIndex7;
                        list = a3;
                        i = count;
                    } else {
                        int i5 = query2.getInt(columnIndex6);
                        i3 = columnIndex6;
                        ArrayList arrayList = new ArrayList();
                        i2 = columnIndex7;
                        ArrayList arrayList2 = new ArrayList();
                        Iterator it = ((ArrayList) a3).iterator();
                        while (it.hasNext()) {
                            a aVar = (a) it.next();
                            if (aVar.a == i5) {
                                arrayList.add(aVar.c);
                                arrayList2.add(aVar.d);
                            }
                            count = count;
                            a3 = a3;
                        }
                        list = a3;
                        i = count;
                        hashSet.add(new ForeignKey(query2.getString(columnIndex8), query2.getString(columnIndex9), query2.getString(columnIndex10), arrayList, arrayList2));
                    }
                    i4++;
                    columnIndex6 = i3;
                    columnIndex7 = i2;
                    count = i;
                    a3 = list;
                }
                query2.close();
                Cursor query3 = supportSQLiteDatabase.query("PRAGMA index_list(`" + str + "`)");
                try {
                    int columnIndex11 = query3.getColumnIndex("name");
                    int columnIndex12 = query3.getColumnIndex("origin");
                    int columnIndex13 = query3.getColumnIndex("unique");
                    HashSet hashSet2 = null;
                    if (columnIndex11 != -1 && columnIndex12 != -1) {
                        if (columnIndex13 != -1) {
                            HashSet hashSet3 = new HashSet();
                            while (query3.moveToNext()) {
                                if ("c".equals(query3.getString(columnIndex12))) {
                                    Index b = b(supportSQLiteDatabase, query3.getString(columnIndex11), query3.getInt(columnIndex13) == 1);
                                    if (b != null) {
                                        hashSet3.add(b);
                                    }
                                }
                            }
                            query3.close();
                            hashSet2 = hashSet3;
                            return new TableInfo(str, hashMap, hashSet, hashSet2);
                        }
                    }
                    return new TableInfo(str, hashMap, hashSet, hashSet2);
                } finally {
                    query3.close();
                }
            } catch (Throwable th) {
                query2.close();
                throw th;
            }
        } catch (Throwable th2) {
            query.close();
            throw th2;
        }
    }

    public boolean equals(Object obj) {
        Set<Index> set;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        TableInfo tableInfo = (TableInfo) obj;
        String str = this.name;
        if (str == null ? tableInfo.name != null : !str.equals(tableInfo.name)) {
            return false;
        }
        Map<String, Column> map = this.columns;
        if (map == null ? tableInfo.columns != null : !map.equals(tableInfo.columns)) {
            return false;
        }
        Set<ForeignKey> set2 = this.foreignKeys;
        if (set2 == null ? tableInfo.foreignKeys != null : !set2.equals(tableInfo.foreignKeys)) {
            return false;
        }
        Set<Index> set3 = this.indices;
        if (set3 == null || (set = tableInfo.indices) == null) {
            return true;
        }
        return set3.equals(set);
    }

    public int hashCode() {
        String str = this.name;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        Map<String, Column> map = this.columns;
        int hashCode2 = (hashCode + (map != null ? map.hashCode() : 0)) * 31;
        Set<ForeignKey> set = this.foreignKeys;
        if (set != null) {
            i = set.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        StringBuilder L = a2.b.a.a.a.L("TableInfo{name='");
        a2.b.a.a.a.k1(L, this.name, '\'', ", columns=");
        L.append(this.columns);
        L.append(", foreignKeys=");
        L.append(this.foreignKeys);
        L.append(", indices=");
        L.append(this.indices);
        L.append('}');
        return L.toString();
    }

    public TableInfo(String str, Map<String, Column> map, Set<ForeignKey> set) {
        this(str, map, set, Collections.emptySet());
    }
}
