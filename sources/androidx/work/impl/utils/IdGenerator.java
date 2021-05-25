package androidx.work.impl.utils;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkDatabaseMigrations;
import androidx.work.impl.model.Preference;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class IdGenerator {
    public static final int INITIAL_ID = 0;
    public static final String NEXT_ALARM_MANAGER_ID_KEY = "next_alarm_manager_id";
    public static final String NEXT_JOB_SCHEDULER_ID_KEY = "next_job_scheduler_id";
    public static final String PREFERENCE_FILE_KEY = "androidx.work.util.id";
    public final WorkDatabase a;

    public IdGenerator(@NonNull WorkDatabase workDatabase) {
        this.a = workDatabase;
    }

    public static void migrateLegacyIdGenerator(@NonNull Context context, @NonNull SupportSQLiteDatabase supportSQLiteDatabase) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREFERENCE_FILE_KEY, 0);
        if (sharedPreferences.contains(NEXT_JOB_SCHEDULER_ID_KEY) || sharedPreferences.contains(NEXT_JOB_SCHEDULER_ID_KEY)) {
            int i = sharedPreferences.getInt(NEXT_JOB_SCHEDULER_ID_KEY, 0);
            int i2 = sharedPreferences.getInt(NEXT_ALARM_MANAGER_ID_KEY, 0);
            supportSQLiteDatabase.beginTransaction();
            try {
                supportSQLiteDatabase.execSQL(WorkDatabaseMigrations.INSERT_PREFERENCE, new Object[]{NEXT_JOB_SCHEDULER_ID_KEY, Integer.valueOf(i)});
                supportSQLiteDatabase.execSQL(WorkDatabaseMigrations.INSERT_PREFERENCE, new Object[]{NEXT_ALARM_MANAGER_ID_KEY, Integer.valueOf(i2)});
                sharedPreferences.edit().clear().apply();
                supportSQLiteDatabase.setTransactionSuccessful();
            } finally {
                supportSQLiteDatabase.endTransaction();
            }
        }
    }

    public final int a(String str) {
        this.a.beginTransaction();
        try {
            Long longValue = this.a.preferenceDao().getLongValue(str);
            int i = 0;
            int intValue = longValue != null ? longValue.intValue() : 0;
            if (intValue != Integer.MAX_VALUE) {
                i = intValue + 1;
            }
            this.a.preferenceDao().insertPreference(new Preference(str, (long) i));
            this.a.setTransactionSuccessful();
            return intValue;
        } finally {
            this.a.endTransaction();
        }
    }

    public int nextAlarmManagerId() {
        int a3;
        synchronized (IdGenerator.class) {
            a3 = a(NEXT_ALARM_MANAGER_ID_KEY);
        }
        return a3;
    }

    public int nextJobSchedulerIdWithRange(int i, int i2) {
        synchronized (IdGenerator.class) {
            int a3 = a(NEXT_JOB_SCHEDULER_ID_KEY);
            if (a3 >= i) {
                if (a3 <= i2) {
                    i = a3;
                }
            }
            this.a.preferenceDao().insertPreference(new Preference(NEXT_JOB_SCHEDULER_ID_KEY, (long) (i + 1)));
        }
        return i;
    }
}
