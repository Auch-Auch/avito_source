package com.yandex.metrica.impl.ob;

import android.content.ContentValues;
import android.util.SparseArray;
import com.facebook.gamingservices.cloudgaming.internal.SDKAnalyticsEvents;
import com.yandex.metrica.YandexMetrica;
import java.util.List;
import java.util.Locale;
public final class mi {
    public static final Boolean a = Boolean.FALSE;
    public static final int b = YandexMetrica.getLibraryApiLevel();
    public static final SparseArray<mj> c;
    public static final SparseArray<mj> d;
    private static final lt e;
    private static final lw f;
    private static final ls g;

    public interface a {
        public static final List<String> a = dl.a("incremental_id", "timestamp", "data");

        /* renamed from: com.yandex.metrica.impl.ob.mi$a$a  reason: collision with other inner class name */
        public interface AbstractC0338a {
            public static final String a;
            public static final String b;

            static {
                Locale locale = Locale.US;
                a = String.format(locale, "CREATE TABLE IF NOT EXISTS %s (incremental_id INTEGER NOT NULL,timestamp INTEGER, data TEXT)", "lbs_dat");
                b = String.format(locale, "DROP TABLE IF EXISTS %s", "lbs_dat");
            }
        }

        public interface b {
            public static final String a;
            public static final String b;

            static {
                Locale locale = Locale.US;
                a = String.format(locale, "CREATE TABLE IF NOT EXISTS %s (incremental_id INTEGER NOT NULL,timestamp INTEGER, data TEXT)", "l_dat");
                b = String.format(locale, "DROP TABLE IF EXISTS %s", "l_dat");
            }
        }
    }

    public static final class b {
        public static final List<String> a = dl.a("data_key", "value");
    }

    public interface c {
        public static final List<String> a = dl.a("key", "value", "type");
    }

    public static final class d implements c {
    }

    public static final class e {
        public static ContentValues a() {
            ContentValues contentValues = new ContentValues();
            contentValues.put("API_LEVEL", Integer.valueOf(YandexMetrica.getLibraryApiLevel()));
            return contentValues;
        }
    }

    public static final class f {
        public static final List<String> a = dl.a("id", "number", "global_number", "number_of_type", "name", "value", "type", "time", SDKAnalyticsEvents.PARAMETER_SESSION_ID, "wifi_network_info", "cell_info", "location_info", "error_environment", "user_info", "session_type", "app_environment", "app_environment_revision", "truncated", "connection_type", "cellular_connection_type", "custom_type", "wifi_access_point", "encrypting_mode", "profile_id", "first_occurrence_status", "battery_charge_type", "collection_mode");
        public static final String b;

        static {
            StringBuilder L = a2.b.a.a.a.L("CREATE TABLE IF NOT EXISTS reports (id INTEGER PRIMARY KEY,name TEXT,value TEXT,number INTEGER,global_number INTEGER,number_of_type INTEGER,type INTEGER,time INTEGER,session_id TEXT,wifi_network_info TEXT DEFAULT '',cell_info TEXT DEFAULT '',location_info TEXT DEFAULT '',error_environment TEXT,user_info TEXT,session_type INTEGER DEFAULT ");
            L.append(jy.FOREGROUND.a());
            L.append(",");
            L.append("app_environment");
            L.append(" TEXT DEFAULT '");
            a2.b.a.a.a.n1(L, "{}", "',", "app_environment_revision", " INTEGER DEFAULT ");
            L.append(0L);
            L.append(",");
            L.append("truncated");
            L.append(" INTEGER DEFAULT 0,");
            L.append("connection_type");
            L.append(" INTEGER DEFAULT ");
            L.append(2);
            a2.b.a.a.a.n1(L, ",", "cellular_connection_type", " TEXT,", "custom_type");
            a2.b.a.a.a.n1(L, " INTEGER DEFAULT 0, ", "wifi_access_point", " TEXT, ", "encrypting_mode");
            L.append(" INTEGER DEFAULT ");
            L.append(acl.NONE.a());
            L.append(", ");
            L.append("profile_id");
            L.append(" TEXT, ");
            L.append("first_occurrence_status");
            L.append(" INTEGER DEFAULT ");
            L.append(ap.UNKNOWN.d);
            L.append(", ");
            L.append("battery_charge_type");
            L.append(" INTEGER DEFAULT ");
            L.append(p.a.a());
            L.append(", ");
            L.append("collection_mode");
            L.append(" TEXT )");
            b = L.toString();
        }
    }

    public static final class g {
        public static final List<String> a = dl.a("id", "start_time", "network_info", "report_request_parameters", "server_time_offset", "type", "obtained_before_first_sync");
        public static final String b;
        public static final String c;
        public static final String d;

        static {
            StringBuilder L = a2.b.a.a.a.L("CREATE TABLE IF NOT EXISTS sessions (id INTEGER,start_time INTEGER,network_info TEXT,report_request_parameters TEXT,server_time_offset INTEGER,type INTEGER DEFAULT ");
            L.append(jy.FOREGROUND.a());
            L.append(",");
            L.append("obtained_before_first_sync");
            L.append(" INTEGER DEFAULT 0 )");
            b = L.toString();
            Locale locale = Locale.US;
            c = String.format(locale, "SELECT DISTINCT %s  FROM %s WHERE %s >=0 AND (SELECT count() FROM %5$s WHERE %5$s.%6$s = %2$s.%3$s AND %5$s.%7$s = %2$s.%4$s) > 0 ORDER BY %3$s LIMIT 1", "report_request_parameters", "sessions", "id", "type", "reports", SDKAnalyticsEvents.PARAMETER_SESSION_ID, "session_type");
            d = String.format(locale, "(select count(%s.%s) from %s where %s.%s = %s.%s) = 0 and cast(%s as integer) < ?", "reports", "id", "reports", "reports", SDKAnalyticsEvents.PARAMETER_SESSION_ID, "sessions", "id", "id");
        }
    }

    public static final class h implements c {
    }

    static {
        lt ltVar = new lt();
        e = ltVar;
        lw lwVar = new lw();
        f = lwVar;
        g = new ls(ltVar, lwVar);
        c = ltVar.a();
        d = ltVar.b();
    }

    public static ls a() {
        return g;
    }
}
