package com.yandex.metrica.impl.ob;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import com.facebook.gamingservices.cloudgaming.internal.SDKAnalyticsEvents;
import com.yandex.metrica.impl.ob.al;
import com.yandex.metrica.impl.ob.mi;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
public class mk {

    public static class a extends mj {
        @Override // com.yandex.metrica.impl.ob.mj
        public void a(SQLiteDatabase sQLiteDatabase) throws SQLException {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS preferences (key TEXT PRIMARY KEY,value TEXT,type INTEGER)");
        }
    }

    public static class aa extends mj {
        @Override // com.yandex.metrica.impl.ob.mj
        public void a(@NonNull SQLiteDatabase sQLiteDatabase) throws SQLException, JSONException {
            sQLiteDatabase.delete("reports", "session_id = ?", new String[]{String.valueOf(-2L)});
            sQLiteDatabase.delete("sessions", "id = ?", new String[]{String.valueOf(-2L)});
        }
    }

    public static class ab extends mj {
        @Override // com.yandex.metrica.impl.ob.mj
        public void a(@NonNull SQLiteDatabase sQLiteDatabase) throws SQLException, JSONException {
            Locale locale = Locale.US;
            sQLiteDatabase.execSQL(String.format(locale, "ALTER TABLE %s ADD COLUMN %s INTEGER DEFAULT %d", "reports", "global_number", 0));
            sQLiteDatabase.execSQL(String.format(locale, "ALTER TABLE %s ADD COLUMN %s INTEGER DEFAULT %d", "reports", "number_of_type", 0));
        }
    }

    public static class ac extends mj {
        @Override // com.yandex.metrica.impl.ob.mj
        public void a(SQLiteDatabase sQLiteDatabase) throws SQLException, JSONException {
            Locale locale = Locale.US;
            sQLiteDatabase.execSQL(String.format(locale, "ALTER TABLE %s ADD COLUMN %s INTEGER DEFAULT %d", "reports", "battery_charge_type", Integer.valueOf(p.a.a())));
            sQLiteDatabase.execSQL(String.format(locale, "ALTER TABLE %s ADD COLUMN %s TEXT", "reports", "collection_mode"));
            sQLiteDatabase.execSQL(String.format(locale, "UPDATE %s SET %s = \"\" WHERE %s == %d AND %2$s != \"\" AND %2$s IS NOT NULL", "reports", "value", "type", Integer.valueOf(al.a.EVENT_TYPE_START.a())));
        }
    }

    public static class b extends mj {
        @Override // com.yandex.metrica.impl.ob.mj
        public void a(SQLiteDatabase sQLiteDatabase) throws SQLException {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS preferences");
        }
    }

    public static class c extends mj {
        @Override // com.yandex.metrica.impl.ob.mj
        public void a(SQLiteDatabase sQLiteDatabase) throws SQLException {
            sQLiteDatabase.execSQL(mi.f.b);
            sQLiteDatabase.execSQL(mi.g.b);
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS preferences (key TEXT PRIMARY KEY,value TEXT,type INTEGER)");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS binary_data (data_key TEXT PRIMARY KEY,value BLOB)");
        }
    }

    public static class d extends mj {
        @Override // com.yandex.metrica.impl.ob.mj
        public void a(SQLiteDatabase sQLiteDatabase) throws SQLException {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS reports");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS sessions");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS preferences");
        }
    }

    public static class e extends mj {
        @Override // com.yandex.metrica.impl.ob.mj
        public void a(SQLiteDatabase sQLiteDatabase) throws SQLException {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS preferences (key TEXT PRIMARY KEY,value TEXT,type INTEGER)");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS startup (key TEXT PRIMARY KEY,value TEXT,type INTEGER)");
            sQLiteDatabase.execSQL(mi.a.b.a);
            sQLiteDatabase.execSQL(mi.a.AbstractC0338a.a);
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS binary_data (data_key TEXT PRIMARY KEY,value BLOB)");
        }
    }

    public static class f extends mj {
        @Override // com.yandex.metrica.impl.ob.mj
        public void a(SQLiteDatabase sQLiteDatabase) throws SQLException {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS device_id_info");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS api_level_info");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS preferences");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS startup");
            sQLiteDatabase.execSQL(mi.a.b.b);
            sQLiteDatabase.execSQL(mi.a.AbstractC0338a.b);
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS permissions");
        }
    }

    public static class g extends mj {
        @Override // com.yandex.metrica.impl.ob.mj
        public void a(SQLiteDatabase sQLiteDatabase) throws SQLException {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS api_level_info (API_LEVEL INT )");
            sQLiteDatabase.insert("api_level_info", "API_LEVEL", mi.e.a());
        }
    }

    public static class h extends mj {
        @Override // com.yandex.metrica.impl.ob.mj
        public void a(SQLiteDatabase sQLiteDatabase) throws SQLException {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS api_level_info");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS device_id_info");
        }
    }

    public static class i extends mj {
        @Override // com.yandex.metrica.impl.ob.mj
        public void a(SQLiteDatabase sQLiteDatabase) throws SQLException {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS preferences (key TEXT PRIMARY KEY,value TEXT,type INTEGER)");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS startup (key TEXT PRIMARY KEY,value TEXT,type INTEGER)");
        }
    }

    public static class j extends mj {
        @Override // com.yandex.metrica.impl.ob.mj
        public void a(SQLiteDatabase sQLiteDatabase) throws SQLException {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS GeoLocationInfo");
        }
    }

    public static class k extends mj {
        @Override // com.yandex.metrica.impl.ob.mj
        public void a(SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS permissions (name TEXT PRIMARY KEY,granted INTEGER)");
        }
    }

    public static class l extends mj {
        @Override // com.yandex.metrica.impl.ob.mj
        public void a(SQLiteDatabase sQLiteDatabase) throws SQLException, JSONException {
            sQLiteDatabase.execSQL(mi.a.b.a);
        }
    }

    public static class m extends mj {
        @Override // com.yandex.metrica.impl.ob.mj
        public void a(SQLiteDatabase sQLiteDatabase) throws SQLException, JSONException {
            sQLiteDatabase.execSQL(mi.a.AbstractC0338a.a);
        }
    }

    public static class n extends mj {
        @Override // com.yandex.metrica.impl.ob.mj
        public void a(SQLiteDatabase sQLiteDatabase) throws SQLException, JSONException {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS binary_data (data_key TEXT PRIMARY KEY,value BLOB)");
        }
    }

    public static class o extends mj {
        /* JADX INFO: finally extract failed */
        @Override // com.yandex.metrica.impl.ob.mj
        public void a(SQLiteDatabase sQLiteDatabase) throws SQLException, JSONException {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS sessions_BACKUP (id INTEGER,start_time INTEGER,connection_type INTEGER,network_type TEXT,country_code INTEGER,operator_id INTEGER,lac INTEGER,report_request_parameters TEXT );");
            StringBuilder sb = new StringBuilder();
            String str = "id";
            sb.append(str);
            sb.append(",");
            sb.append("start_time");
            a2.b.a.a.a.n1(sb, ",", "connection_type", ",", "network_type");
            a2.b.a.a.a.n1(sb, ",", "country_code", ",", "operator_id");
            sb.append(",");
            sb.append("lac");
            sb.append(",");
            sb.append("report_request_parameters");
            sQLiteDatabase.execSQL("INSERT INTO sessions_BACKUP SELECT " + ((CharSequence) sb) + " FROM sessions;");
            sQLiteDatabase.execSQL("DROP TABLE sessions;");
            sQLiteDatabase.execSQL(mi.g.b);
            try {
                Cursor rawQuery = sQLiteDatabase.rawQuery("SELECT * FROM sessions_BACKUP", null);
                while (rawQuery.moveToNext()) {
                    ContentValues contentValues = new ContentValues();
                    DatabaseUtils.cursorRowToContentValues(rawQuery, contentValues);
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(str);
                    arrayList.add("start_time");
                    arrayList.add("report_request_parameters");
                    ContentValues contentValues2 = new ContentValues(contentValues);
                    for (Map.Entry<String, Object> entry : contentValues.valueSet()) {
                        if (!arrayList.contains(entry.getKey())) {
                            contentValues2.remove(entry.getKey());
                        }
                        str = str;
                    }
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        contentValues.remove((String) it.next());
                    }
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("conn_type", contentValues.getAsInteger("connection_type"));
                    jSONObject.putOpt("net_type", contentValues.get("network_type"));
                    jSONObject.putOpt("operator_id", contentValues.get("operator_id"));
                    jSONObject.putOpt("lac", contentValues.get("lac"));
                    jSONObject.putOpt("country_code", contentValues.get("country_code"));
                    contentValues2.put("network_info", jSONObject.toString());
                    sQLiteDatabase.insertOrThrow("sessions", null, contentValues2);
                    str = str;
                }
                dl.a(rawQuery);
                sQLiteDatabase.execSQL("DROP TABLE sessions_BACKUP;");
                sQLiteDatabase.execSQL("ALTER TABLE reports ADD COLUMN wifi_network_info TEXT DEFAULT ''");
                sQLiteDatabase.execSQL("ALTER TABLE reports ADD COLUMN cell_info TEXT DEFAULT ''");
                sQLiteDatabase.execSQL("ALTER TABLE reports ADD COLUMN location_info TEXT DEFAULT ''");
            } catch (Throwable th) {
                dl.a((Cursor) null);
                throw th;
            }
        }
    }

    public static class p extends mj {
        @Override // com.yandex.metrica.impl.ob.mj
        public void a(SQLiteDatabase sQLiteDatabase) throws SQLException {
            sQLiteDatabase.execSQL("ALTER TABLE reports ADD COLUMN environment TEXT ");
            sQLiteDatabase.execSQL("ALTER TABLE reports ADD COLUMN user_info TEXT ");
            StringBuilder sb = new StringBuilder();
            sb.append("ALTER TABLE ");
            sb.append("reports");
            a2.b.a.a.a.m1(sb, " ADD COLUMN ", "session_type", " INTEGER DEFAULT ");
            jy jyVar = jy.FOREGROUND;
            sb.append(jyVar.a());
            sQLiteDatabase.execSQL(sb.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append("UPDATE ");
            sb2.append("reports");
            a2.b.a.a.a.m1(sb2, " SET ", "session_type", " = ");
            jy jyVar2 = jy.BACKGROUND;
            sb2.append(jyVar2.a());
            sb2.append(" WHERE ");
            sb2.append(SDKAnalyticsEvents.PARAMETER_SESSION_ID);
            sb2.append(" = ");
            sb2.append(-2L);
            sQLiteDatabase.execSQL(sb2.toString());
            sQLiteDatabase.execSQL("ALTER TABLE sessions ADD COLUMN server_time_offset INTEGER ");
            StringBuilder sb3 = new StringBuilder();
            a2.b.a.a.a.n1(sb3, "ALTER TABLE ", "sessions", " ADD COLUMN ", "type");
            sb3.append(" INTEGER DEFAULT ");
            sb3.append(jyVar.a());
            sQLiteDatabase.execSQL(sb3.toString());
            StringBuilder sb4 = new StringBuilder();
            sb4.append("UPDATE ");
            a2.b.a.a.a.n1(sb4, "sessions", " SET ", "type", " = ");
            sb4.append(jyVar2.a());
            sb4.append(" WHERE ");
            sb4.append("id");
            sb4.append(" = ");
            sb4.append(-2L);
            sQLiteDatabase.execSQL(sb4.toString());
        }
    }

    public static class q extends mj {
        private static final String a;

        static {
            StringBuilder L = a2.b.a.a.a.L("CREATE TABLE IF NOT EXISTS reports (id INTEGER PRIMARY KEY,name TEXT,value TEXT,number INTEGER,type INTEGER,time INTEGER,session_id TEXT,wifi_network_info TEXT DEFAULT '',cell_info TEXT DEFAULT '',location_info TEXT DEFAULT '',error_environment TEXT,user_info TEXT,session_type INTEGER DEFAULT ");
            L.append(jy.FOREGROUND.a());
            L.append(",");
            L.append("app_environment");
            L.append(" TEXT DEFAULT '");
            a2.b.a.a.a.n1(L, "{}", "',", "app_environment_revision", " INTEGER DEFAULT ");
            a = a2.b.a.a.a.l(L, 0, " )");
        }

        @Override // com.yandex.metrica.impl.ob.mj
        public void a(SQLiteDatabase sQLiteDatabase) throws SQLException {
            Throwable th;
            sQLiteDatabase.execSQL("ALTER TABLE reports ADD COLUMN app_environment TEXT DEFAULT '{}'");
            sQLiteDatabase.execSQL("ALTER TABLE reports ADD COLUMN app_environment_revision INTEGER DEFAULT 0");
            sQLiteDatabase.execSQL("ALTER TABLE reports RENAME TO reports_backup");
            sQLiteDatabase.execSQL(a);
            Cursor cursor = null;
            try {
                Cursor rawQuery = sQLiteDatabase.rawQuery("SELECT * FROM reports_backup", null);
                while (rawQuery.moveToNext()) {
                    try {
                        ContentValues contentValues = new ContentValues();
                        DatabaseUtils.cursorRowToContentValues(rawQuery, contentValues);
                        String asString = contentValues.getAsString("environment");
                        contentValues.remove("environment");
                        contentValues.put("error_environment", asString);
                        sQLiteDatabase.insert("reports", null, contentValues);
                    } catch (Throwable th2) {
                        th = th2;
                        cursor = rawQuery;
                        dl.a(cursor);
                        throw th;
                    }
                }
                dl.a(rawQuery);
                sQLiteDatabase.execSQL("DROP TABLE reports_backup");
            } catch (Throwable th3) {
                th = th3;
                dl.a(cursor);
                throw th;
            }
        }
    }

    public static class r extends mj {
        @Override // com.yandex.metrica.impl.ob.mj
        public void a(SQLiteDatabase sQLiteDatabase) throws SQLException {
            sQLiteDatabase.execSQL("ALTER TABLE reports ADD COLUMN truncated INTEGER DEFAULT 0");
        }
    }

    public static class s extends mj {
        @Override // com.yandex.metrica.impl.ob.mj
        public void a(SQLiteDatabase sQLiteDatabase) throws SQLException, JSONException {
            sQLiteDatabase.execSQL("ALTER TABLE reports ADD COLUMN connection_type INTEGER DEFAULT 2");
            sQLiteDatabase.execSQL("ALTER TABLE reports ADD COLUMN cellular_connection_type TEXT ");
        }
    }

    public static class t extends mj {
        @Override // com.yandex.metrica.impl.ob.mj
        public void a(SQLiteDatabase sQLiteDatabase) throws SQLException {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS preferences (key TEXT PRIMARY KEY,value TEXT,type INTEGER)");
            sQLiteDatabase.execSQL("ALTER TABLE reports ADD COLUMN custom_type INTEGER DEFAULT 0");
        }
    }

    public static class u extends mj {
        @Override // com.yandex.metrica.impl.ob.mj
        public void a(SQLiteDatabase sQLiteDatabase) throws SQLException {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS preferences (key TEXT PRIMARY KEY,value TEXT,type INTEGER)");
            sQLiteDatabase.execSQL("ALTER TABLE reports ADD COLUMN wifi_access_point TEXT ");
        }
    }

    public static class v extends mj {
        @Override // com.yandex.metrica.impl.ob.mj
        public void a(SQLiteDatabase sQLiteDatabase) throws SQLException {
            sQLiteDatabase.execSQL("ALTER TABLE sessions ADD COLUMN wifi_network_info TEXT DEFAULT ''");
        }
    }

    public static class w extends mj {
        @Override // com.yandex.metrica.impl.ob.mj
        public void a(SQLiteDatabase sQLiteDatabase) throws SQLException, JSONException {
            sQLiteDatabase.execSQL(a2.b.a.a.a.f("ALTER TABLE ", "sessions", " ADD COLUMN ", "obtained_before_first_sync", " INTEGER DEFAULT 0"));
        }
    }

    public static class x extends mj {
        @Override // com.yandex.metrica.impl.ob.mj
        public void a(SQLiteDatabase sQLiteDatabase) throws SQLException, JSONException {
            Locale locale = Locale.US;
            sQLiteDatabase.execSQL(String.format(locale, "ALTER TABLE %s ADD COLUMN %s INTEGER DEFAULT %d", "reports", "encrypting_mode", Integer.valueOf(acl.NONE.a())));
            sQLiteDatabase.execSQL(String.format(locale, "UPDATE %s SET %s = %d where %s=%d", "reports", "encrypting_mode", Integer.valueOf(acl.EXTERNALLY_ENCRYPTED_EVENT_CRYPTER.a()), "type", Integer.valueOf(al.a.EVENT_TYPE_IDENTITY.a())));
            sQLiteDatabase.execSQL("ALTER TABLE reports ADD COLUMN profile_id TEXT ");
        }
    }

    public static class y extends mj {
        @Override // com.yandex.metrica.impl.ob.mj
        public void a(@NonNull SQLiteDatabase sQLiteDatabase) throws SQLException, JSONException {
            sQLiteDatabase.execSQL(String.format(Locale.US, "ALTER TABLE %s ADD COLUMN %s INTEGER DEFAULT %d", "reports", "first_occurrence_status", Integer.valueOf(ap.UNKNOWN.d)));
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS binary_data (data_key TEXT PRIMARY KEY,value BLOB)");
        }
    }

    public static class z extends mj {
        @Override // com.yandex.metrica.impl.ob.mj
        public void a(SQLiteDatabase sQLiteDatabase) throws SQLException {
            sQLiteDatabase.execSQL(a2.b.a.a.a.f("ALTER TABLE ", "sessions", " ADD COLUMN ", "report_request_parameters", " TEXT DEFAULT ''"));
        }
    }
}
