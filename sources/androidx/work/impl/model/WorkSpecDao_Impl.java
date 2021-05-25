package androidx.work.impl.model;

import android.database.Cursor;
import androidx.collection.ArrayMap;
import androidx.lifecycle.LiveData;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.WorkInfo;
import androidx.work.impl.model.WorkSpec;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
public final class WorkSpecDao_Impl implements WorkSpecDao {
    public final RoomDatabase a;
    public final EntityInsertionAdapter<WorkSpec> b;
    public final SharedSQLiteStatement c;
    public final SharedSQLiteStatement d;
    public final SharedSQLiteStatement e;
    public final SharedSQLiteStatement f;
    public final SharedSQLiteStatement g;
    public final SharedSQLiteStatement h;
    public final SharedSQLiteStatement i;
    public final SharedSQLiteStatement j;

    public class a implements Callable<List<WorkSpec.WorkInfoPojo>> {
        public final /* synthetic */ RoomSQLiteQuery a;

        public a(RoomSQLiteQuery roomSQLiteQuery) {
            this.a = roomSQLiteQuery;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX INFO: finally extract failed */
        @Override // java.util.concurrent.Callable
        public List<WorkSpec.WorkInfoPojo> call() throws Exception {
            WorkSpecDao_Impl.this.a.beginTransaction();
            try {
                Cursor query = DBUtil.query(WorkSpecDao_Impl.this.a, this.a, true, null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "id");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "state");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "output");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "run_attempt_count");
                    ArrayMap<String, ArrayList<String>> arrayMap = new ArrayMap<>();
                    ArrayMap<String, ArrayList<Data>> arrayMap2 = new ArrayMap<>();
                    while (query.moveToNext()) {
                        if (!query.isNull(columnIndexOrThrow)) {
                            String string = query.getString(columnIndexOrThrow);
                            if (arrayMap.get(string) == null) {
                                arrayMap.put(string, new ArrayList<>());
                            }
                        }
                        if (!query.isNull(columnIndexOrThrow)) {
                            String string2 = query.getString(columnIndexOrThrow);
                            if (arrayMap2.get(string2) == null) {
                                arrayMap2.put(string2, new ArrayList<>());
                            }
                        }
                    }
                    query.moveToPosition(-1);
                    WorkSpecDao_Impl.this.b(arrayMap);
                    WorkSpecDao_Impl.this.a(arrayMap2);
                    ArrayList arrayList = new ArrayList(query.getCount());
                    while (query.moveToNext()) {
                        ArrayList<String> arrayList2 = !query.isNull(columnIndexOrThrow) ? arrayMap.get(query.getString(columnIndexOrThrow)) : null;
                        if (arrayList2 == null) {
                            arrayList2 = new ArrayList<>();
                        }
                        ArrayList<Data> arrayList3 = !query.isNull(columnIndexOrThrow) ? arrayMap2.get(query.getString(columnIndexOrThrow)) : null;
                        if (arrayList3 == null) {
                            arrayList3 = new ArrayList<>();
                        }
                        WorkSpec.WorkInfoPojo workInfoPojo = new WorkSpec.WorkInfoPojo();
                        workInfoPojo.id = query.getString(columnIndexOrThrow);
                        workInfoPojo.state = WorkTypeConverters.intToState(query.getInt(columnIndexOrThrow2));
                        workInfoPojo.output = Data.fromByteArray(query.getBlob(columnIndexOrThrow3));
                        workInfoPojo.runAttemptCount = query.getInt(columnIndexOrThrow4);
                        workInfoPojo.tags = arrayList2;
                        workInfoPojo.progress = arrayList3;
                        arrayList.add(workInfoPojo);
                    }
                    WorkSpecDao_Impl.this.a.setTransactionSuccessful();
                    query.close();
                    return arrayList;
                } catch (Throwable th) {
                    query.close();
                    throw th;
                }
            } finally {
                WorkSpecDao_Impl.this.a.endTransaction();
            }
        }

        @Override // java.lang.Object
        public void finalize() {
            this.a.release();
        }
    }

    public class b implements Callable<List<WorkSpec.WorkInfoPojo>> {
        public final /* synthetic */ RoomSQLiteQuery a;

        public b(RoomSQLiteQuery roomSQLiteQuery) {
            this.a = roomSQLiteQuery;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX INFO: finally extract failed */
        @Override // java.util.concurrent.Callable
        public List<WorkSpec.WorkInfoPojo> call() throws Exception {
            WorkSpecDao_Impl.this.a.beginTransaction();
            try {
                Cursor query = DBUtil.query(WorkSpecDao_Impl.this.a, this.a, true, null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "id");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "state");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "output");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "run_attempt_count");
                    ArrayMap<String, ArrayList<String>> arrayMap = new ArrayMap<>();
                    ArrayMap<String, ArrayList<Data>> arrayMap2 = new ArrayMap<>();
                    while (query.moveToNext()) {
                        if (!query.isNull(columnIndexOrThrow)) {
                            String string = query.getString(columnIndexOrThrow);
                            if (arrayMap.get(string) == null) {
                                arrayMap.put(string, new ArrayList<>());
                            }
                        }
                        if (!query.isNull(columnIndexOrThrow)) {
                            String string2 = query.getString(columnIndexOrThrow);
                            if (arrayMap2.get(string2) == null) {
                                arrayMap2.put(string2, new ArrayList<>());
                            }
                        }
                    }
                    query.moveToPosition(-1);
                    WorkSpecDao_Impl.this.b(arrayMap);
                    WorkSpecDao_Impl.this.a(arrayMap2);
                    ArrayList arrayList = new ArrayList(query.getCount());
                    while (query.moveToNext()) {
                        ArrayList<String> arrayList2 = !query.isNull(columnIndexOrThrow) ? arrayMap.get(query.getString(columnIndexOrThrow)) : null;
                        if (arrayList2 == null) {
                            arrayList2 = new ArrayList<>();
                        }
                        ArrayList<Data> arrayList3 = !query.isNull(columnIndexOrThrow) ? arrayMap2.get(query.getString(columnIndexOrThrow)) : null;
                        if (arrayList3 == null) {
                            arrayList3 = new ArrayList<>();
                        }
                        WorkSpec.WorkInfoPojo workInfoPojo = new WorkSpec.WorkInfoPojo();
                        workInfoPojo.id = query.getString(columnIndexOrThrow);
                        workInfoPojo.state = WorkTypeConverters.intToState(query.getInt(columnIndexOrThrow2));
                        workInfoPojo.output = Data.fromByteArray(query.getBlob(columnIndexOrThrow3));
                        workInfoPojo.runAttemptCount = query.getInt(columnIndexOrThrow4);
                        workInfoPojo.tags = arrayList2;
                        workInfoPojo.progress = arrayList3;
                        arrayList.add(workInfoPojo);
                    }
                    WorkSpecDao_Impl.this.a.setTransactionSuccessful();
                    query.close();
                    return arrayList;
                } catch (Throwable th) {
                    query.close();
                    throw th;
                }
            } finally {
                WorkSpecDao_Impl.this.a.endTransaction();
            }
        }

        @Override // java.lang.Object
        public void finalize() {
            this.a.release();
        }
    }

    public class c implements Callable<List<WorkSpec.WorkInfoPojo>> {
        public final /* synthetic */ RoomSQLiteQuery a;

        public c(RoomSQLiteQuery roomSQLiteQuery) {
            this.a = roomSQLiteQuery;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX INFO: finally extract failed */
        @Override // java.util.concurrent.Callable
        public List<WorkSpec.WorkInfoPojo> call() throws Exception {
            WorkSpecDao_Impl.this.a.beginTransaction();
            try {
                Cursor query = DBUtil.query(WorkSpecDao_Impl.this.a, this.a, true, null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "id");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "state");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "output");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "run_attempt_count");
                    ArrayMap<String, ArrayList<String>> arrayMap = new ArrayMap<>();
                    ArrayMap<String, ArrayList<Data>> arrayMap2 = new ArrayMap<>();
                    while (query.moveToNext()) {
                        if (!query.isNull(columnIndexOrThrow)) {
                            String string = query.getString(columnIndexOrThrow);
                            if (arrayMap.get(string) == null) {
                                arrayMap.put(string, new ArrayList<>());
                            }
                        }
                        if (!query.isNull(columnIndexOrThrow)) {
                            String string2 = query.getString(columnIndexOrThrow);
                            if (arrayMap2.get(string2) == null) {
                                arrayMap2.put(string2, new ArrayList<>());
                            }
                        }
                    }
                    query.moveToPosition(-1);
                    WorkSpecDao_Impl.this.b(arrayMap);
                    WorkSpecDao_Impl.this.a(arrayMap2);
                    ArrayList arrayList = new ArrayList(query.getCount());
                    while (query.moveToNext()) {
                        ArrayList<String> arrayList2 = !query.isNull(columnIndexOrThrow) ? arrayMap.get(query.getString(columnIndexOrThrow)) : null;
                        if (arrayList2 == null) {
                            arrayList2 = new ArrayList<>();
                        }
                        ArrayList<Data> arrayList3 = !query.isNull(columnIndexOrThrow) ? arrayMap2.get(query.getString(columnIndexOrThrow)) : null;
                        if (arrayList3 == null) {
                            arrayList3 = new ArrayList<>();
                        }
                        WorkSpec.WorkInfoPojo workInfoPojo = new WorkSpec.WorkInfoPojo();
                        workInfoPojo.id = query.getString(columnIndexOrThrow);
                        workInfoPojo.state = WorkTypeConverters.intToState(query.getInt(columnIndexOrThrow2));
                        workInfoPojo.output = Data.fromByteArray(query.getBlob(columnIndexOrThrow3));
                        workInfoPojo.runAttemptCount = query.getInt(columnIndexOrThrow4);
                        workInfoPojo.tags = arrayList2;
                        workInfoPojo.progress = arrayList3;
                        arrayList.add(workInfoPojo);
                    }
                    WorkSpecDao_Impl.this.a.setTransactionSuccessful();
                    query.close();
                    return arrayList;
                } catch (Throwable th) {
                    query.close();
                    throw th;
                }
            } finally {
                WorkSpecDao_Impl.this.a.endTransaction();
            }
        }

        @Override // java.lang.Object
        public void finalize() {
            this.a.release();
        }
    }

    public class d extends EntityInsertionAdapter<WorkSpec> {
        public d(WorkSpecDao_Impl workSpecDao_Impl, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [androidx.sqlite.db.SupportSQLiteStatement, java.lang.Object] */
        @Override // androidx.room.EntityInsertionAdapter
        public void bind(SupportSQLiteStatement supportSQLiteStatement, WorkSpec workSpec) {
            WorkSpec workSpec2 = workSpec;
            String str = workSpec2.id;
            if (str == null) {
                supportSQLiteStatement.bindNull(1);
            } else {
                supportSQLiteStatement.bindString(1, str);
            }
            supportSQLiteStatement.bindLong(2, (long) WorkTypeConverters.stateToInt(workSpec2.state));
            String str2 = workSpec2.workerClassName;
            if (str2 == null) {
                supportSQLiteStatement.bindNull(3);
            } else {
                supportSQLiteStatement.bindString(3, str2);
            }
            String str3 = workSpec2.inputMergerClassName;
            if (str3 == null) {
                supportSQLiteStatement.bindNull(4);
            } else {
                supportSQLiteStatement.bindString(4, str3);
            }
            byte[] byteArrayInternal = Data.toByteArrayInternal(workSpec2.input);
            if (byteArrayInternal == null) {
                supportSQLiteStatement.bindNull(5);
            } else {
                supportSQLiteStatement.bindBlob(5, byteArrayInternal);
            }
            byte[] byteArrayInternal2 = Data.toByteArrayInternal(workSpec2.output);
            if (byteArrayInternal2 == null) {
                supportSQLiteStatement.bindNull(6);
            } else {
                supportSQLiteStatement.bindBlob(6, byteArrayInternal2);
            }
            supportSQLiteStatement.bindLong(7, workSpec2.initialDelay);
            supportSQLiteStatement.bindLong(8, workSpec2.intervalDuration);
            supportSQLiteStatement.bindLong(9, workSpec2.flexDuration);
            supportSQLiteStatement.bindLong(10, (long) workSpec2.runAttemptCount);
            supportSQLiteStatement.bindLong(11, (long) WorkTypeConverters.backoffPolicyToInt(workSpec2.backoffPolicy));
            supportSQLiteStatement.bindLong(12, workSpec2.backoffDelayDuration);
            supportSQLiteStatement.bindLong(13, workSpec2.periodStartTime);
            supportSQLiteStatement.bindLong(14, workSpec2.minimumRetentionDuration);
            supportSQLiteStatement.bindLong(15, workSpec2.scheduleRequestedAt);
            supportSQLiteStatement.bindLong(16, workSpec2.runInForeground ? 1 : 0);
            Constraints constraints = workSpec2.constraints;
            if (constraints != null) {
                supportSQLiteStatement.bindLong(17, (long) WorkTypeConverters.networkTypeToInt(constraints.getRequiredNetworkType()));
                supportSQLiteStatement.bindLong(18, constraints.requiresCharging() ? 1 : 0);
                supportSQLiteStatement.bindLong(19, constraints.requiresDeviceIdle() ? 1 : 0);
                supportSQLiteStatement.bindLong(20, constraints.requiresBatteryNotLow() ? 1 : 0);
                supportSQLiteStatement.bindLong(21, constraints.requiresStorageNotLow() ? 1 : 0);
                supportSQLiteStatement.bindLong(22, constraints.getTriggerContentUpdateDelay());
                supportSQLiteStatement.bindLong(23, constraints.getTriggerMaxContentDelay());
                byte[] contentUriTriggersToByteArray = WorkTypeConverters.contentUriTriggersToByteArray(constraints.getContentUriTriggers());
                if (contentUriTriggersToByteArray == null) {
                    supportSQLiteStatement.bindNull(24);
                } else {
                    supportSQLiteStatement.bindBlob(24, contentUriTriggersToByteArray);
                }
            } else {
                supportSQLiteStatement.bindNull(17);
                supportSQLiteStatement.bindNull(18);
                supportSQLiteStatement.bindNull(19);
                supportSQLiteStatement.bindNull(20);
                supportSQLiteStatement.bindNull(21);
                supportSQLiteStatement.bindNull(22);
                supportSQLiteStatement.bindNull(23);
                supportSQLiteStatement.bindNull(24);
            }
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "INSERT OR IGNORE INTO `WorkSpec` (`id`,`state`,`worker_class_name`,`input_merger_class_name`,`input`,`output`,`initial_delay`,`interval_duration`,`flex_duration`,`run_attempt_count`,`backoff_policy`,`backoff_delay_duration`,`period_start_time`,`minimum_retention_duration`,`schedule_requested_at`,`run_in_foreground`,`required_network_type`,`requires_charging`,`requires_device_idle`,`requires_battery_not_low`,`requires_storage_not_low`,`trigger_content_update_delay`,`trigger_max_content_delay`,`content_uri_triggers`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }
    }

    public class e extends SharedSQLiteStatement {
        public e(WorkSpecDao_Impl workSpecDao_Impl, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "DELETE FROM workspec WHERE id=?";
        }
    }

    public class f extends SharedSQLiteStatement {
        public f(WorkSpecDao_Impl workSpecDao_Impl, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "UPDATE workspec SET output=? WHERE id=?";
        }
    }

    public class g extends SharedSQLiteStatement {
        public g(WorkSpecDao_Impl workSpecDao_Impl, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "UPDATE workspec SET period_start_time=? WHERE id=?";
        }
    }

    public class h extends SharedSQLiteStatement {
        public h(WorkSpecDao_Impl workSpecDao_Impl, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "UPDATE workspec SET run_attempt_count=run_attempt_count+1 WHERE id=?";
        }
    }

    public class i extends SharedSQLiteStatement {
        public i(WorkSpecDao_Impl workSpecDao_Impl, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "UPDATE workspec SET run_attempt_count=0 WHERE id=?";
        }
    }

    public class j extends SharedSQLiteStatement {
        public j(WorkSpecDao_Impl workSpecDao_Impl, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "UPDATE workspec SET schedule_requested_at=? WHERE id=?";
        }
    }

    public class k extends SharedSQLiteStatement {
        public k(WorkSpecDao_Impl workSpecDao_Impl, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "UPDATE workspec SET schedule_requested_at=-1 WHERE state NOT IN (2, 3, 5)";
        }
    }

    public class l extends SharedSQLiteStatement {
        public l(WorkSpecDao_Impl workSpecDao_Impl, RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "DELETE FROM workspec WHERE state IN (2, 3, 5) AND (SELECT COUNT(*)=0 FROM dependency WHERE     prerequisite_id=id AND     work_spec_id NOT IN         (SELECT id FROM workspec WHERE state IN (2, 3, 5)))";
        }
    }

    public WorkSpecDao_Impl(RoomDatabase roomDatabase) {
        this.a = roomDatabase;
        this.b = new d(this, roomDatabase);
        this.c = new e(this, roomDatabase);
        this.d = new f(this, roomDatabase);
        this.e = new g(this, roomDatabase);
        this.f = new h(this, roomDatabase);
        this.g = new i(this, roomDatabase);
        this.h = new j(this, roomDatabase);
        this.i = new k(this, roomDatabase);
        this.j = new l(this, roomDatabase);
    }

    public final void a(ArrayMap<String, ArrayList<Data>> arrayMap) {
        ArrayList<Data> arrayList;
        int i2;
        Set<String> keySet = arrayMap.keySet();
        if (!keySet.isEmpty()) {
            if (arrayMap.size() > 999) {
                ArrayMap<String, ArrayList<Data>> arrayMap2 = new ArrayMap<>(999);
                int size = arrayMap.size();
                int i3 = 0;
                loop0:
                while (true) {
                    i2 = 0;
                    while (i3 < size) {
                        arrayMap2.put(arrayMap.keyAt(i3), arrayMap.valueAt(i3));
                        i3++;
                        i2++;
                        if (i2 == 999) {
                            a(arrayMap2);
                            arrayMap2 = new ArrayMap<>(999);
                        }
                    }
                    break loop0;
                }
                if (i2 > 0) {
                    a(arrayMap2);
                    return;
                }
                return;
            }
            StringBuilder newStringBuilder = StringUtil.newStringBuilder();
            newStringBuilder.append("SELECT `progress`,`work_spec_id` FROM `WorkProgress` WHERE `work_spec_id` IN (");
            int size2 = keySet.size();
            StringUtil.appendPlaceholders(newStringBuilder, size2);
            newStringBuilder.append(")");
            RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire(newStringBuilder.toString(), size2 + 0);
            int i4 = 1;
            for (String str : keySet) {
                if (str == null) {
                    acquire.bindNull(i4);
                } else {
                    acquire.bindString(i4, str);
                }
                i4++;
            }
            Cursor query = DBUtil.query(this.a, acquire, false, null);
            try {
                int columnIndex = CursorUtil.getColumnIndex(query, "work_spec_id");
                if (columnIndex != -1) {
                    while (query.moveToNext()) {
                        if (!query.isNull(columnIndex) && (arrayList = arrayMap.get(query.getString(columnIndex))) != null) {
                            arrayList.add(Data.fromByteArray(query.getBlob(0)));
                        }
                    }
                    query.close();
                }
            } finally {
                query.close();
            }
        }
    }

    public final void b(ArrayMap<String, ArrayList<String>> arrayMap) {
        ArrayList<String> arrayList;
        int i2;
        Set<String> keySet = arrayMap.keySet();
        if (!keySet.isEmpty()) {
            if (arrayMap.size() > 999) {
                ArrayMap<String, ArrayList<String>> arrayMap2 = new ArrayMap<>(999);
                int size = arrayMap.size();
                int i3 = 0;
                loop0:
                while (true) {
                    i2 = 0;
                    while (i3 < size) {
                        arrayMap2.put(arrayMap.keyAt(i3), arrayMap.valueAt(i3));
                        i3++;
                        i2++;
                        if (i2 == 999) {
                            b(arrayMap2);
                            arrayMap2 = new ArrayMap<>(999);
                        }
                    }
                    break loop0;
                }
                if (i2 > 0) {
                    b(arrayMap2);
                    return;
                }
                return;
            }
            StringBuilder newStringBuilder = StringUtil.newStringBuilder();
            newStringBuilder.append("SELECT `tag`,`work_spec_id` FROM `WorkTag` WHERE `work_spec_id` IN (");
            int size2 = keySet.size();
            StringUtil.appendPlaceholders(newStringBuilder, size2);
            newStringBuilder.append(")");
            RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire(newStringBuilder.toString(), size2 + 0);
            int i4 = 1;
            for (String str : keySet) {
                if (str == null) {
                    acquire.bindNull(i4);
                } else {
                    acquire.bindString(i4, str);
                }
                i4++;
            }
            Cursor query = DBUtil.query(this.a, acquire, false, null);
            try {
                int columnIndex = CursorUtil.getColumnIndex(query, "work_spec_id");
                if (columnIndex != -1) {
                    while (query.moveToNext()) {
                        if (!query.isNull(columnIndex) && (arrayList = arrayMap.get(query.getString(columnIndex))) != null) {
                            arrayList.add(query.getString(0));
                        }
                    }
                    query.close();
                }
            } finally {
                query.close();
            }
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public void delete(String str) {
        this.a.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.c.acquire();
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        this.a.beginTransaction();
        try {
            acquire.executeUpdateDelete();
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
            this.c.release(acquire);
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public List<WorkSpec> getAllEligibleWorkSpecsForScheduling() {
        RoomSQLiteQuery roomSQLiteQuery;
        Throwable th;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground` FROM workspec WHERE state=0 ORDER BY period_start_time", 0);
        this.a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.a, acquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "required_network_type");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "requires_charging");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "requires_device_idle");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "requires_battery_not_low");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "requires_storage_not_low");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "trigger_content_update_delay");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "trigger_max_content_delay");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "content_uri_triggers");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "id");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "state");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "worker_class_name");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "input_merger_class_name");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "input");
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "output");
            roomSQLiteQuery = acquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "initial_delay");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "interval_duration");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "flex_duration");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "run_attempt_count");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "backoff_policy");
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "backoff_delay_duration");
                int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(query, "period_start_time");
                int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(query, "minimum_retention_duration");
                int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(query, "schedule_requested_at");
                int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(query, "run_in_foreground");
                int i2 = columnIndexOrThrow14;
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    String string = query.getString(columnIndexOrThrow9);
                    String string2 = query.getString(columnIndexOrThrow11);
                    Constraints constraints = new Constraints();
                    constraints.setRequiredNetworkType(WorkTypeConverters.intToNetworkType(query.getInt(columnIndexOrThrow)));
                    constraints.setRequiresCharging(query.getInt(columnIndexOrThrow2) != 0);
                    constraints.setRequiresDeviceIdle(query.getInt(columnIndexOrThrow3) != 0);
                    constraints.setRequiresBatteryNotLow(query.getInt(columnIndexOrThrow4) != 0);
                    constraints.setRequiresStorageNotLow(query.getInt(columnIndexOrThrow5) != 0);
                    constraints.setTriggerContentUpdateDelay(query.getLong(columnIndexOrThrow6));
                    constraints.setTriggerMaxContentDelay(query.getLong(columnIndexOrThrow7));
                    constraints.setContentUriTriggers(WorkTypeConverters.byteArrayToContentUriTriggers(query.getBlob(columnIndexOrThrow8)));
                    WorkSpec workSpec = new WorkSpec(string, string2);
                    workSpec.state = WorkTypeConverters.intToState(query.getInt(columnIndexOrThrow10));
                    workSpec.inputMergerClassName = query.getString(columnIndexOrThrow12);
                    workSpec.input = Data.fromByteArray(query.getBlob(columnIndexOrThrow13));
                    workSpec.output = Data.fromByteArray(query.getBlob(i2));
                    i2 = i2;
                    workSpec.initialDelay = query.getLong(columnIndexOrThrow15);
                    workSpec.intervalDuration = query.getLong(columnIndexOrThrow16);
                    workSpec.flexDuration = query.getLong(columnIndexOrThrow17);
                    workSpec.runAttemptCount = query.getInt(columnIndexOrThrow18);
                    workSpec.backoffPolicy = WorkTypeConverters.intToBackoffPolicy(query.getInt(columnIndexOrThrow19));
                    columnIndexOrThrow17 = columnIndexOrThrow17;
                    workSpec.backoffDelayDuration = query.getLong(columnIndexOrThrow20);
                    workSpec.periodStartTime = query.getLong(columnIndexOrThrow21);
                    columnIndexOrThrow21 = columnIndexOrThrow21;
                    workSpec.minimumRetentionDuration = query.getLong(columnIndexOrThrow22);
                    workSpec.scheduleRequestedAt = query.getLong(columnIndexOrThrow23);
                    workSpec.runInForeground = query.getInt(columnIndexOrThrow24) != 0;
                    workSpec.constraints = constraints;
                    arrayList.add(workSpec);
                    columnIndexOrThrow23 = columnIndexOrThrow23;
                    columnIndexOrThrow24 = columnIndexOrThrow24;
                    columnIndexOrThrow2 = columnIndexOrThrow2;
                    columnIndexOrThrow13 = columnIndexOrThrow13;
                    columnIndexOrThrow15 = columnIndexOrThrow15;
                    columnIndexOrThrow16 = columnIndexOrThrow16;
                    columnIndexOrThrow18 = columnIndexOrThrow18;
                    columnIndexOrThrow9 = columnIndexOrThrow9;
                    columnIndexOrThrow11 = columnIndexOrThrow11;
                    columnIndexOrThrow = columnIndexOrThrow;
                    columnIndexOrThrow22 = columnIndexOrThrow22;
                    columnIndexOrThrow3 = columnIndexOrThrow3;
                    columnIndexOrThrow20 = columnIndexOrThrow20;
                    columnIndexOrThrow4 = columnIndexOrThrow4;
                    columnIndexOrThrow19 = columnIndexOrThrow19;
                }
                query.close();
                roomSQLiteQuery.release();
                return arrayList;
            } catch (Throwable th2) {
                th = th2;
                query.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            roomSQLiteQuery = acquire;
            query.close();
            roomSQLiteQuery.release();
            throw th;
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public List<String> getAllUnfinishedWork() {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT id FROM workspec WHERE state NOT IN (2, 3, 5)", 0);
        this.a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.a, acquire, false, null);
        try {
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                arrayList.add(query.getString(0));
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public List<String> getAllWorkSpecIds() {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT id FROM workspec", 0);
        this.a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.a, acquire, false, null);
        try {
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                arrayList.add(query.getString(0));
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public List<WorkSpec> getEligibleWorkForScheduling(int i2) {
        RoomSQLiteQuery roomSQLiteQuery;
        Throwable th;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground` FROM workspec WHERE state=0 AND schedule_requested_at=-1 ORDER BY period_start_time LIMIT (SELECT MAX(?-COUNT(*), 0) FROM workspec WHERE schedule_requested_at<>-1 AND state NOT IN (2, 3, 5))", 1);
        acquire.bindLong(1, (long) i2);
        this.a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.a, acquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "required_network_type");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "requires_charging");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "requires_device_idle");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "requires_battery_not_low");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "requires_storage_not_low");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "trigger_content_update_delay");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "trigger_max_content_delay");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "content_uri_triggers");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "id");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "state");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "worker_class_name");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "input_merger_class_name");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "input");
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "output");
            roomSQLiteQuery = acquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "initial_delay");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "interval_duration");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "flex_duration");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "run_attempt_count");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "backoff_policy");
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "backoff_delay_duration");
                int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(query, "period_start_time");
                int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(query, "minimum_retention_duration");
                int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(query, "schedule_requested_at");
                int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(query, "run_in_foreground");
                int i3 = columnIndexOrThrow14;
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    String string = query.getString(columnIndexOrThrow9);
                    String string2 = query.getString(columnIndexOrThrow11);
                    Constraints constraints = new Constraints();
                    constraints.setRequiredNetworkType(WorkTypeConverters.intToNetworkType(query.getInt(columnIndexOrThrow)));
                    constraints.setRequiresCharging(query.getInt(columnIndexOrThrow2) != 0);
                    constraints.setRequiresDeviceIdle(query.getInt(columnIndexOrThrow3) != 0);
                    constraints.setRequiresBatteryNotLow(query.getInt(columnIndexOrThrow4) != 0);
                    constraints.setRequiresStorageNotLow(query.getInt(columnIndexOrThrow5) != 0);
                    constraints.setTriggerContentUpdateDelay(query.getLong(columnIndexOrThrow6));
                    constraints.setTriggerMaxContentDelay(query.getLong(columnIndexOrThrow7));
                    constraints.setContentUriTriggers(WorkTypeConverters.byteArrayToContentUriTriggers(query.getBlob(columnIndexOrThrow8)));
                    WorkSpec workSpec = new WorkSpec(string, string2);
                    workSpec.state = WorkTypeConverters.intToState(query.getInt(columnIndexOrThrow10));
                    workSpec.inputMergerClassName = query.getString(columnIndexOrThrow12);
                    workSpec.input = Data.fromByteArray(query.getBlob(columnIndexOrThrow13));
                    workSpec.output = Data.fromByteArray(query.getBlob(i3));
                    i3 = i3;
                    workSpec.initialDelay = query.getLong(columnIndexOrThrow15);
                    workSpec.intervalDuration = query.getLong(columnIndexOrThrow16);
                    workSpec.flexDuration = query.getLong(columnIndexOrThrow17);
                    workSpec.runAttemptCount = query.getInt(columnIndexOrThrow18);
                    workSpec.backoffPolicy = WorkTypeConverters.intToBackoffPolicy(query.getInt(columnIndexOrThrow19));
                    columnIndexOrThrow17 = columnIndexOrThrow17;
                    workSpec.backoffDelayDuration = query.getLong(columnIndexOrThrow20);
                    workSpec.periodStartTime = query.getLong(columnIndexOrThrow21);
                    columnIndexOrThrow21 = columnIndexOrThrow21;
                    workSpec.minimumRetentionDuration = query.getLong(columnIndexOrThrow22);
                    workSpec.scheduleRequestedAt = query.getLong(columnIndexOrThrow23);
                    workSpec.runInForeground = query.getInt(columnIndexOrThrow24) != 0;
                    workSpec.constraints = constraints;
                    arrayList.add(workSpec);
                    columnIndexOrThrow23 = columnIndexOrThrow23;
                    columnIndexOrThrow24 = columnIndexOrThrow24;
                    columnIndexOrThrow2 = columnIndexOrThrow2;
                    columnIndexOrThrow12 = columnIndexOrThrow12;
                    columnIndexOrThrow15 = columnIndexOrThrow15;
                    columnIndexOrThrow16 = columnIndexOrThrow16;
                    columnIndexOrThrow18 = columnIndexOrThrow18;
                    columnIndexOrThrow9 = columnIndexOrThrow9;
                    columnIndexOrThrow11 = columnIndexOrThrow11;
                    columnIndexOrThrow = columnIndexOrThrow;
                    columnIndexOrThrow22 = columnIndexOrThrow22;
                    columnIndexOrThrow3 = columnIndexOrThrow3;
                    columnIndexOrThrow20 = columnIndexOrThrow20;
                    columnIndexOrThrow4 = columnIndexOrThrow4;
                    columnIndexOrThrow19 = columnIndexOrThrow19;
                }
                query.close();
                roomSQLiteQuery.release();
                return arrayList;
            } catch (Throwable th2) {
                th = th2;
                query.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            roomSQLiteQuery = acquire;
            query.close();
            roomSQLiteQuery.release();
            throw th;
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public List<Data> getInputsFromPrerequisites(String str) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT output FROM workspec WHERE id IN (SELECT prerequisite_id FROM dependency WHERE work_spec_id=?)", 1);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        this.a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.a, acquire, false, null);
        try {
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                arrayList.add(Data.fromByteArray(query.getBlob(0)));
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public List<WorkSpec> getRecentlyCompletedWork(long j2) {
        RoomSQLiteQuery roomSQLiteQuery;
        Throwable th;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground` FROM workspec WHERE period_start_time >= ? AND state IN (2, 3, 5) ORDER BY period_start_time DESC", 1);
        acquire.bindLong(1, j2);
        this.a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.a, acquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "required_network_type");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "requires_charging");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "requires_device_idle");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "requires_battery_not_low");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "requires_storage_not_low");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "trigger_content_update_delay");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "trigger_max_content_delay");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "content_uri_triggers");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "id");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "state");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "worker_class_name");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "input_merger_class_name");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "input");
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "output");
            roomSQLiteQuery = acquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "initial_delay");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "interval_duration");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "flex_duration");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "run_attempt_count");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "backoff_policy");
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "backoff_delay_duration");
                int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(query, "period_start_time");
                int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(query, "minimum_retention_duration");
                int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(query, "schedule_requested_at");
                int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(query, "run_in_foreground");
                int i2 = columnIndexOrThrow14;
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    String string = query.getString(columnIndexOrThrow9);
                    String string2 = query.getString(columnIndexOrThrow11);
                    Constraints constraints = new Constraints();
                    constraints.setRequiredNetworkType(WorkTypeConverters.intToNetworkType(query.getInt(columnIndexOrThrow)));
                    constraints.setRequiresCharging(query.getInt(columnIndexOrThrow2) != 0);
                    constraints.setRequiresDeviceIdle(query.getInt(columnIndexOrThrow3) != 0);
                    constraints.setRequiresBatteryNotLow(query.getInt(columnIndexOrThrow4) != 0);
                    constraints.setRequiresStorageNotLow(query.getInt(columnIndexOrThrow5) != 0);
                    constraints.setTriggerContentUpdateDelay(query.getLong(columnIndexOrThrow6));
                    constraints.setTriggerMaxContentDelay(query.getLong(columnIndexOrThrow7));
                    constraints.setContentUriTriggers(WorkTypeConverters.byteArrayToContentUriTriggers(query.getBlob(columnIndexOrThrow8)));
                    WorkSpec workSpec = new WorkSpec(string, string2);
                    workSpec.state = WorkTypeConverters.intToState(query.getInt(columnIndexOrThrow10));
                    workSpec.inputMergerClassName = query.getString(columnIndexOrThrow12);
                    workSpec.input = Data.fromByteArray(query.getBlob(columnIndexOrThrow13));
                    workSpec.output = Data.fromByteArray(query.getBlob(i2));
                    i2 = i2;
                    workSpec.initialDelay = query.getLong(columnIndexOrThrow15);
                    workSpec.intervalDuration = query.getLong(columnIndexOrThrow16);
                    workSpec.flexDuration = query.getLong(columnIndexOrThrow17);
                    workSpec.runAttemptCount = query.getInt(columnIndexOrThrow18);
                    workSpec.backoffPolicy = WorkTypeConverters.intToBackoffPolicy(query.getInt(columnIndexOrThrow19));
                    columnIndexOrThrow17 = columnIndexOrThrow17;
                    workSpec.backoffDelayDuration = query.getLong(columnIndexOrThrow20);
                    workSpec.periodStartTime = query.getLong(columnIndexOrThrow21);
                    columnIndexOrThrow21 = columnIndexOrThrow21;
                    workSpec.minimumRetentionDuration = query.getLong(columnIndexOrThrow22);
                    workSpec.scheduleRequestedAt = query.getLong(columnIndexOrThrow23);
                    workSpec.runInForeground = query.getInt(columnIndexOrThrow24) != 0;
                    workSpec.constraints = constraints;
                    arrayList.add(workSpec);
                    columnIndexOrThrow2 = columnIndexOrThrow2;
                    columnIndexOrThrow23 = columnIndexOrThrow23;
                    columnIndexOrThrow24 = columnIndexOrThrow24;
                    columnIndexOrThrow12 = columnIndexOrThrow12;
                    columnIndexOrThrow15 = columnIndexOrThrow15;
                    columnIndexOrThrow16 = columnIndexOrThrow16;
                    columnIndexOrThrow18 = columnIndexOrThrow18;
                    columnIndexOrThrow9 = columnIndexOrThrow9;
                    columnIndexOrThrow11 = columnIndexOrThrow11;
                    columnIndexOrThrow = columnIndexOrThrow;
                    columnIndexOrThrow22 = columnIndexOrThrow22;
                    columnIndexOrThrow3 = columnIndexOrThrow3;
                    columnIndexOrThrow20 = columnIndexOrThrow20;
                    columnIndexOrThrow4 = columnIndexOrThrow4;
                    columnIndexOrThrow19 = columnIndexOrThrow19;
                }
                query.close();
                roomSQLiteQuery.release();
                return arrayList;
            } catch (Throwable th2) {
                th = th2;
                query.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            roomSQLiteQuery = acquire;
            query.close();
            roomSQLiteQuery.release();
            throw th;
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public List<WorkSpec> getRunningWork() {
        RoomSQLiteQuery roomSQLiteQuery;
        Throwable th;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground` FROM workspec WHERE state=1", 0);
        this.a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.a, acquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "required_network_type");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "requires_charging");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "requires_device_idle");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "requires_battery_not_low");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "requires_storage_not_low");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "trigger_content_update_delay");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "trigger_max_content_delay");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "content_uri_triggers");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "id");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "state");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "worker_class_name");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "input_merger_class_name");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "input");
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "output");
            roomSQLiteQuery = acquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "initial_delay");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "interval_duration");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "flex_duration");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "run_attempt_count");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "backoff_policy");
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "backoff_delay_duration");
                int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(query, "period_start_time");
                int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(query, "minimum_retention_duration");
                int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(query, "schedule_requested_at");
                int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(query, "run_in_foreground");
                int i2 = columnIndexOrThrow14;
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    String string = query.getString(columnIndexOrThrow9);
                    String string2 = query.getString(columnIndexOrThrow11);
                    Constraints constraints = new Constraints();
                    constraints.setRequiredNetworkType(WorkTypeConverters.intToNetworkType(query.getInt(columnIndexOrThrow)));
                    constraints.setRequiresCharging(query.getInt(columnIndexOrThrow2) != 0);
                    constraints.setRequiresDeviceIdle(query.getInt(columnIndexOrThrow3) != 0);
                    constraints.setRequiresBatteryNotLow(query.getInt(columnIndexOrThrow4) != 0);
                    constraints.setRequiresStorageNotLow(query.getInt(columnIndexOrThrow5) != 0);
                    constraints.setTriggerContentUpdateDelay(query.getLong(columnIndexOrThrow6));
                    constraints.setTriggerMaxContentDelay(query.getLong(columnIndexOrThrow7));
                    constraints.setContentUriTriggers(WorkTypeConverters.byteArrayToContentUriTriggers(query.getBlob(columnIndexOrThrow8)));
                    WorkSpec workSpec = new WorkSpec(string, string2);
                    workSpec.state = WorkTypeConverters.intToState(query.getInt(columnIndexOrThrow10));
                    workSpec.inputMergerClassName = query.getString(columnIndexOrThrow12);
                    workSpec.input = Data.fromByteArray(query.getBlob(columnIndexOrThrow13));
                    workSpec.output = Data.fromByteArray(query.getBlob(i2));
                    i2 = i2;
                    workSpec.initialDelay = query.getLong(columnIndexOrThrow15);
                    workSpec.intervalDuration = query.getLong(columnIndexOrThrow16);
                    workSpec.flexDuration = query.getLong(columnIndexOrThrow17);
                    workSpec.runAttemptCount = query.getInt(columnIndexOrThrow18);
                    workSpec.backoffPolicy = WorkTypeConverters.intToBackoffPolicy(query.getInt(columnIndexOrThrow19));
                    columnIndexOrThrow17 = columnIndexOrThrow17;
                    workSpec.backoffDelayDuration = query.getLong(columnIndexOrThrow20);
                    workSpec.periodStartTime = query.getLong(columnIndexOrThrow21);
                    columnIndexOrThrow21 = columnIndexOrThrow21;
                    workSpec.minimumRetentionDuration = query.getLong(columnIndexOrThrow22);
                    workSpec.scheduleRequestedAt = query.getLong(columnIndexOrThrow23);
                    workSpec.runInForeground = query.getInt(columnIndexOrThrow24) != 0;
                    workSpec.constraints = constraints;
                    arrayList.add(workSpec);
                    columnIndexOrThrow23 = columnIndexOrThrow23;
                    columnIndexOrThrow24 = columnIndexOrThrow24;
                    columnIndexOrThrow2 = columnIndexOrThrow2;
                    columnIndexOrThrow13 = columnIndexOrThrow13;
                    columnIndexOrThrow15 = columnIndexOrThrow15;
                    columnIndexOrThrow16 = columnIndexOrThrow16;
                    columnIndexOrThrow18 = columnIndexOrThrow18;
                    columnIndexOrThrow9 = columnIndexOrThrow9;
                    columnIndexOrThrow11 = columnIndexOrThrow11;
                    columnIndexOrThrow = columnIndexOrThrow;
                    columnIndexOrThrow22 = columnIndexOrThrow22;
                    columnIndexOrThrow3 = columnIndexOrThrow3;
                    columnIndexOrThrow20 = columnIndexOrThrow20;
                    columnIndexOrThrow4 = columnIndexOrThrow4;
                    columnIndexOrThrow19 = columnIndexOrThrow19;
                }
                query.close();
                roomSQLiteQuery.release();
                return arrayList;
            } catch (Throwable th2) {
                th = th2;
                query.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            roomSQLiteQuery = acquire;
            query.close();
            roomSQLiteQuery.release();
            throw th;
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public List<WorkSpec> getScheduledWork() {
        RoomSQLiteQuery roomSQLiteQuery;
        Throwable th;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground` FROM workspec WHERE state=0 AND schedule_requested_at<>-1", 0);
        this.a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.a, acquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "required_network_type");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "requires_charging");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "requires_device_idle");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "requires_battery_not_low");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "requires_storage_not_low");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "trigger_content_update_delay");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "trigger_max_content_delay");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "content_uri_triggers");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "id");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "state");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "worker_class_name");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "input_merger_class_name");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "input");
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "output");
            roomSQLiteQuery = acquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "initial_delay");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "interval_duration");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "flex_duration");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "run_attempt_count");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "backoff_policy");
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "backoff_delay_duration");
                int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(query, "period_start_time");
                int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(query, "minimum_retention_duration");
                int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(query, "schedule_requested_at");
                int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(query, "run_in_foreground");
                int i2 = columnIndexOrThrow14;
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    String string = query.getString(columnIndexOrThrow9);
                    String string2 = query.getString(columnIndexOrThrow11);
                    Constraints constraints = new Constraints();
                    constraints.setRequiredNetworkType(WorkTypeConverters.intToNetworkType(query.getInt(columnIndexOrThrow)));
                    constraints.setRequiresCharging(query.getInt(columnIndexOrThrow2) != 0);
                    constraints.setRequiresDeviceIdle(query.getInt(columnIndexOrThrow3) != 0);
                    constraints.setRequiresBatteryNotLow(query.getInt(columnIndexOrThrow4) != 0);
                    constraints.setRequiresStorageNotLow(query.getInt(columnIndexOrThrow5) != 0);
                    constraints.setTriggerContentUpdateDelay(query.getLong(columnIndexOrThrow6));
                    constraints.setTriggerMaxContentDelay(query.getLong(columnIndexOrThrow7));
                    constraints.setContentUriTriggers(WorkTypeConverters.byteArrayToContentUriTriggers(query.getBlob(columnIndexOrThrow8)));
                    WorkSpec workSpec = new WorkSpec(string, string2);
                    workSpec.state = WorkTypeConverters.intToState(query.getInt(columnIndexOrThrow10));
                    workSpec.inputMergerClassName = query.getString(columnIndexOrThrow12);
                    workSpec.input = Data.fromByteArray(query.getBlob(columnIndexOrThrow13));
                    workSpec.output = Data.fromByteArray(query.getBlob(i2));
                    i2 = i2;
                    workSpec.initialDelay = query.getLong(columnIndexOrThrow15);
                    workSpec.intervalDuration = query.getLong(columnIndexOrThrow16);
                    workSpec.flexDuration = query.getLong(columnIndexOrThrow17);
                    workSpec.runAttemptCount = query.getInt(columnIndexOrThrow18);
                    workSpec.backoffPolicy = WorkTypeConverters.intToBackoffPolicy(query.getInt(columnIndexOrThrow19));
                    columnIndexOrThrow17 = columnIndexOrThrow17;
                    workSpec.backoffDelayDuration = query.getLong(columnIndexOrThrow20);
                    workSpec.periodStartTime = query.getLong(columnIndexOrThrow21);
                    columnIndexOrThrow21 = columnIndexOrThrow21;
                    workSpec.minimumRetentionDuration = query.getLong(columnIndexOrThrow22);
                    workSpec.scheduleRequestedAt = query.getLong(columnIndexOrThrow23);
                    workSpec.runInForeground = query.getInt(columnIndexOrThrow24) != 0;
                    workSpec.constraints = constraints;
                    arrayList.add(workSpec);
                    columnIndexOrThrow23 = columnIndexOrThrow23;
                    columnIndexOrThrow24 = columnIndexOrThrow24;
                    columnIndexOrThrow2 = columnIndexOrThrow2;
                    columnIndexOrThrow13 = columnIndexOrThrow13;
                    columnIndexOrThrow15 = columnIndexOrThrow15;
                    columnIndexOrThrow16 = columnIndexOrThrow16;
                    columnIndexOrThrow18 = columnIndexOrThrow18;
                    columnIndexOrThrow9 = columnIndexOrThrow9;
                    columnIndexOrThrow11 = columnIndexOrThrow11;
                    columnIndexOrThrow = columnIndexOrThrow;
                    columnIndexOrThrow22 = columnIndexOrThrow22;
                    columnIndexOrThrow3 = columnIndexOrThrow3;
                    columnIndexOrThrow20 = columnIndexOrThrow20;
                    columnIndexOrThrow4 = columnIndexOrThrow4;
                    columnIndexOrThrow19 = columnIndexOrThrow19;
                }
                query.close();
                roomSQLiteQuery.release();
                return arrayList;
            } catch (Throwable th2) {
                th = th2;
                query.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            roomSQLiteQuery = acquire;
            query.close();
            roomSQLiteQuery.release();
            throw th;
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public WorkInfo.State getState(String str) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT state FROM workspec WHERE id=?", 1);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        this.a.assertNotSuspendingTransaction();
        WorkInfo.State state = null;
        Cursor query = DBUtil.query(this.a, acquire, false, null);
        try {
            if (query.moveToFirst()) {
                state = WorkTypeConverters.intToState(query.getInt(0));
            }
            return state;
        } finally {
            query.close();
            acquire.release();
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public List<String> getUnfinishedWorkWithName(String str) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT id FROM workspec WHERE state NOT IN (2, 3, 5) AND id IN (SELECT work_spec_id FROM workname WHERE name=?)", 1);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        this.a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.a, acquire, false, null);
        try {
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                arrayList.add(query.getString(0));
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public List<String> getUnfinishedWorkWithTag(String str) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT id FROM workspec WHERE state NOT IN (2, 3, 5) AND id IN (SELECT work_spec_id FROM worktag WHERE tag=?)", 1);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        this.a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.a, acquire, false, null);
        try {
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                arrayList.add(query.getString(0));
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public WorkSpec getWorkSpec(String str) {
        RoomSQLiteQuery roomSQLiteQuery;
        Throwable th;
        WorkSpec workSpec;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground` FROM workspec WHERE id=?", 1);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        this.a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.a, acquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "required_network_type");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "requires_charging");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "requires_device_idle");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "requires_battery_not_low");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "requires_storage_not_low");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "trigger_content_update_delay");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "trigger_max_content_delay");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "content_uri_triggers");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "id");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "state");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "worker_class_name");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "input_merger_class_name");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "input");
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "output");
            roomSQLiteQuery = acquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "initial_delay");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "interval_duration");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "flex_duration");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "run_attempt_count");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "backoff_policy");
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "backoff_delay_duration");
                int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(query, "period_start_time");
                int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(query, "minimum_retention_duration");
                int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(query, "schedule_requested_at");
                int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(query, "run_in_foreground");
                if (query.moveToFirst()) {
                    String string = query.getString(columnIndexOrThrow9);
                    String string2 = query.getString(columnIndexOrThrow11);
                    Constraints constraints = new Constraints();
                    constraints.setRequiredNetworkType(WorkTypeConverters.intToNetworkType(query.getInt(columnIndexOrThrow)));
                    constraints.setRequiresCharging(query.getInt(columnIndexOrThrow2) != 0);
                    constraints.setRequiresDeviceIdle(query.getInt(columnIndexOrThrow3) != 0);
                    constraints.setRequiresBatteryNotLow(query.getInt(columnIndexOrThrow4) != 0);
                    constraints.setRequiresStorageNotLow(query.getInt(columnIndexOrThrow5) != 0);
                    constraints.setTriggerContentUpdateDelay(query.getLong(columnIndexOrThrow6));
                    constraints.setTriggerMaxContentDelay(query.getLong(columnIndexOrThrow7));
                    constraints.setContentUriTriggers(WorkTypeConverters.byteArrayToContentUriTriggers(query.getBlob(columnIndexOrThrow8)));
                    WorkSpec workSpec2 = new WorkSpec(string, string2);
                    workSpec2.state = WorkTypeConverters.intToState(query.getInt(columnIndexOrThrow10));
                    workSpec2.inputMergerClassName = query.getString(columnIndexOrThrow12);
                    workSpec2.input = Data.fromByteArray(query.getBlob(columnIndexOrThrow13));
                    workSpec2.output = Data.fromByteArray(query.getBlob(columnIndexOrThrow14));
                    workSpec2.initialDelay = query.getLong(columnIndexOrThrow15);
                    workSpec2.intervalDuration = query.getLong(columnIndexOrThrow16);
                    workSpec2.flexDuration = query.getLong(columnIndexOrThrow17);
                    workSpec2.runAttemptCount = query.getInt(columnIndexOrThrow18);
                    workSpec2.backoffPolicy = WorkTypeConverters.intToBackoffPolicy(query.getInt(columnIndexOrThrow19));
                    workSpec2.backoffDelayDuration = query.getLong(columnIndexOrThrow20);
                    workSpec2.periodStartTime = query.getLong(columnIndexOrThrow21);
                    workSpec2.minimumRetentionDuration = query.getLong(columnIndexOrThrow22);
                    workSpec2.scheduleRequestedAt = query.getLong(columnIndexOrThrow23);
                    workSpec2.runInForeground = query.getInt(columnIndexOrThrow24) != 0;
                    workSpec2.constraints = constraints;
                    workSpec = workSpec2;
                } else {
                    workSpec = null;
                }
                query.close();
                roomSQLiteQuery.release();
                return workSpec;
            } catch (Throwable th2) {
                th = th2;
                query.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            roomSQLiteQuery = acquire;
            query.close();
            roomSQLiteQuery.release();
            throw th;
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public List<WorkSpec.IdAndState> getWorkSpecIdAndStatesForName(String str) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT id, state FROM workspec WHERE id IN (SELECT work_spec_id FROM workname WHERE name=?)", 1);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        this.a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.a, acquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "state");
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                WorkSpec.IdAndState idAndState = new WorkSpec.IdAndState();
                idAndState.id = query.getString(columnIndexOrThrow);
                idAndState.state = WorkTypeConverters.intToState(query.getInt(columnIndexOrThrow2));
                arrayList.add(idAndState);
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public WorkSpec[] getWorkSpecs(List<String> list) {
        RoomSQLiteQuery roomSQLiteQuery;
        Throwable th;
        StringBuilder newStringBuilder = StringUtil.newStringBuilder();
        newStringBuilder.append("SELECT ");
        newStringBuilder.append("*");
        newStringBuilder.append(" FROM workspec WHERE id IN (");
        int size = list.size();
        StringUtil.appendPlaceholders(newStringBuilder, size);
        newStringBuilder.append(")");
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire(newStringBuilder.toString(), size + 0);
        int i2 = 1;
        for (String str : list) {
            if (str == null) {
                acquire.bindNull(i2);
            } else {
                acquire.bindString(i2, str);
            }
            i2++;
        }
        this.a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.a, acquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "required_network_type");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "requires_charging");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "requires_device_idle");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "requires_battery_not_low");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "requires_storage_not_low");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "trigger_content_update_delay");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "trigger_max_content_delay");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "content_uri_triggers");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "id");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "state");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "worker_class_name");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "input_merger_class_name");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "input");
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "output");
            roomSQLiteQuery = acquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "initial_delay");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "interval_duration");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "flex_duration");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "run_attempt_count");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "backoff_policy");
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "backoff_delay_duration");
                int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(query, "period_start_time");
                int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(query, "minimum_retention_duration");
                int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(query, "schedule_requested_at");
                int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(query, "run_in_foreground");
                WorkSpec[] workSpecArr = new WorkSpec[query.getCount()];
                int i3 = 0;
                while (query.moveToNext()) {
                    String string = query.getString(columnIndexOrThrow9);
                    String string2 = query.getString(columnIndexOrThrow11);
                    Constraints constraints = new Constraints();
                    constraints.setRequiredNetworkType(WorkTypeConverters.intToNetworkType(query.getInt(columnIndexOrThrow)));
                    constraints.setRequiresCharging(query.getInt(columnIndexOrThrow2) != 0);
                    constraints.setRequiresDeviceIdle(query.getInt(columnIndexOrThrow3) != 0);
                    constraints.setRequiresBatteryNotLow(query.getInt(columnIndexOrThrow4) != 0);
                    constraints.setRequiresStorageNotLow(query.getInt(columnIndexOrThrow5) != 0);
                    constraints.setTriggerContentUpdateDelay(query.getLong(columnIndexOrThrow6));
                    constraints.setTriggerMaxContentDelay(query.getLong(columnIndexOrThrow7));
                    constraints.setContentUriTriggers(WorkTypeConverters.byteArrayToContentUriTriggers(query.getBlob(columnIndexOrThrow8)));
                    WorkSpec workSpec = new WorkSpec(string, string2);
                    workSpec.state = WorkTypeConverters.intToState(query.getInt(columnIndexOrThrow10));
                    workSpec.inputMergerClassName = query.getString(columnIndexOrThrow12);
                    workSpec.input = Data.fromByteArray(query.getBlob(columnIndexOrThrow13));
                    workSpec.output = Data.fromByteArray(query.getBlob(columnIndexOrThrow14));
                    workSpec.initialDelay = query.getLong(columnIndexOrThrow15);
                    columnIndexOrThrow15 = columnIndexOrThrow15;
                    workSpec.intervalDuration = query.getLong(columnIndexOrThrow16);
                    workSpec.flexDuration = query.getLong(columnIndexOrThrow17);
                    workSpec.runAttemptCount = query.getInt(columnIndexOrThrow18);
                    workSpec.backoffPolicy = WorkTypeConverters.intToBackoffPolicy(query.getInt(columnIndexOrThrow19));
                    columnIndexOrThrow17 = columnIndexOrThrow17;
                    workSpec.backoffDelayDuration = query.getLong(columnIndexOrThrow20);
                    workSpec.periodStartTime = query.getLong(columnIndexOrThrow21);
                    columnIndexOrThrow21 = columnIndexOrThrow21;
                    workSpec.minimumRetentionDuration = query.getLong(columnIndexOrThrow22);
                    columnIndexOrThrow22 = columnIndexOrThrow22;
                    workSpec.scheduleRequestedAt = query.getLong(columnIndexOrThrow23);
                    workSpec.runInForeground = query.getInt(columnIndexOrThrow24) != 0;
                    workSpec.constraints = constraints;
                    workSpecArr[i3] = workSpec;
                    i3++;
                    columnIndexOrThrow23 = columnIndexOrThrow23;
                    columnIndexOrThrow24 = columnIndexOrThrow24;
                    columnIndexOrThrow14 = columnIndexOrThrow14;
                    columnIndexOrThrow2 = columnIndexOrThrow2;
                    workSpecArr = workSpecArr;
                    columnIndexOrThrow9 = columnIndexOrThrow9;
                    columnIndexOrThrow11 = columnIndexOrThrow11;
                    columnIndexOrThrow3 = columnIndexOrThrow3;
                    columnIndexOrThrow = columnIndexOrThrow;
                    columnIndexOrThrow20 = columnIndexOrThrow20;
                    columnIndexOrThrow12 = columnIndexOrThrow12;
                    columnIndexOrThrow16 = columnIndexOrThrow16;
                    columnIndexOrThrow18 = columnIndexOrThrow18;
                    columnIndexOrThrow19 = columnIndexOrThrow19;
                }
                query.close();
                roomSQLiteQuery.release();
                return workSpecArr;
            } catch (Throwable th2) {
                th = th2;
                query.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            roomSQLiteQuery = acquire;
            query.close();
            roomSQLiteQuery.release();
            throw th;
        }
    }

    /* JADX INFO: finally extract failed */
    @Override // androidx.work.impl.model.WorkSpecDao
    public WorkSpec.WorkInfoPojo getWorkStatusPojoForId(String str) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT id, state, output, run_attempt_count FROM workspec WHERE id=?", 1);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            WorkSpec.WorkInfoPojo workInfoPojo = null;
            ArrayList<Data> arrayList = null;
            Cursor query = DBUtil.query(this.a, acquire, true, null);
            try {
                int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "id");
                int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "state");
                int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "output");
                int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "run_attempt_count");
                ArrayMap<String, ArrayList<String>> arrayMap = new ArrayMap<>();
                ArrayMap<String, ArrayList<Data>> arrayMap2 = new ArrayMap<>();
                while (query.moveToNext()) {
                    if (!query.isNull(columnIndexOrThrow)) {
                        String string = query.getString(columnIndexOrThrow);
                        if (arrayMap.get(string) == null) {
                            arrayMap.put(string, new ArrayList<>());
                        }
                    }
                    if (!query.isNull(columnIndexOrThrow)) {
                        String string2 = query.getString(columnIndexOrThrow);
                        if (arrayMap2.get(string2) == null) {
                            arrayMap2.put(string2, new ArrayList<>());
                        }
                    }
                }
                query.moveToPosition(-1);
                b(arrayMap);
                a(arrayMap2);
                if (query.moveToFirst()) {
                    ArrayList<String> arrayList2 = !query.isNull(columnIndexOrThrow) ? arrayMap.get(query.getString(columnIndexOrThrow)) : null;
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList<>();
                    }
                    if (!query.isNull(columnIndexOrThrow)) {
                        arrayList = arrayMap2.get(query.getString(columnIndexOrThrow));
                    }
                    if (arrayList == null) {
                        arrayList = new ArrayList<>();
                    }
                    WorkSpec.WorkInfoPojo workInfoPojo2 = new WorkSpec.WorkInfoPojo();
                    workInfoPojo2.id = query.getString(columnIndexOrThrow);
                    workInfoPojo2.state = WorkTypeConverters.intToState(query.getInt(columnIndexOrThrow2));
                    workInfoPojo2.output = Data.fromByteArray(query.getBlob(columnIndexOrThrow3));
                    workInfoPojo2.runAttemptCount = query.getInt(columnIndexOrThrow4);
                    workInfoPojo2.tags = arrayList2;
                    workInfoPojo2.progress = arrayList;
                    workInfoPojo = workInfoPojo2;
                }
                this.a.setTransactionSuccessful();
                query.close();
                acquire.release();
                return workInfoPojo;
            } catch (Throwable th) {
                query.close();
                acquire.release();
                throw th;
            }
        } finally {
            this.a.endTransaction();
        }
    }

    /* JADX INFO: finally extract failed */
    @Override // androidx.work.impl.model.WorkSpecDao
    public List<WorkSpec.WorkInfoPojo> getWorkStatusPojoForIds(List<String> list) {
        StringBuilder newStringBuilder = StringUtil.newStringBuilder();
        newStringBuilder.append("SELECT id, state, output, run_attempt_count FROM workspec WHERE id IN (");
        int size = list.size();
        StringUtil.appendPlaceholders(newStringBuilder, size);
        newStringBuilder.append(")");
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire(newStringBuilder.toString(), size + 0);
        int i2 = 1;
        for (String str : list) {
            if (str == null) {
                acquire.bindNull(i2);
            } else {
                acquire.bindString(i2, str);
            }
            i2++;
        }
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            Cursor query = DBUtil.query(this.a, acquire, true, null);
            try {
                int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "id");
                int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "state");
                int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "output");
                int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "run_attempt_count");
                ArrayMap<String, ArrayList<String>> arrayMap = new ArrayMap<>();
                ArrayMap<String, ArrayList<Data>> arrayMap2 = new ArrayMap<>();
                while (query.moveToNext()) {
                    if (!query.isNull(columnIndexOrThrow)) {
                        String string = query.getString(columnIndexOrThrow);
                        if (arrayMap.get(string) == null) {
                            arrayMap.put(string, new ArrayList<>());
                        }
                    }
                    if (!query.isNull(columnIndexOrThrow)) {
                        String string2 = query.getString(columnIndexOrThrow);
                        if (arrayMap2.get(string2) == null) {
                            arrayMap2.put(string2, new ArrayList<>());
                        }
                    }
                }
                query.moveToPosition(-1);
                b(arrayMap);
                a(arrayMap2);
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    ArrayList<String> arrayList2 = !query.isNull(columnIndexOrThrow) ? arrayMap.get(query.getString(columnIndexOrThrow)) : null;
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList<>();
                    }
                    ArrayList<Data> arrayList3 = !query.isNull(columnIndexOrThrow) ? arrayMap2.get(query.getString(columnIndexOrThrow)) : null;
                    if (arrayList3 == null) {
                        arrayList3 = new ArrayList<>();
                    }
                    WorkSpec.WorkInfoPojo workInfoPojo = new WorkSpec.WorkInfoPojo();
                    workInfoPojo.id = query.getString(columnIndexOrThrow);
                    workInfoPojo.state = WorkTypeConverters.intToState(query.getInt(columnIndexOrThrow2));
                    workInfoPojo.output = Data.fromByteArray(query.getBlob(columnIndexOrThrow3));
                    workInfoPojo.runAttemptCount = query.getInt(columnIndexOrThrow4);
                    workInfoPojo.tags = arrayList2;
                    workInfoPojo.progress = arrayList3;
                    arrayList.add(workInfoPojo);
                }
                this.a.setTransactionSuccessful();
                query.close();
                acquire.release();
                return arrayList;
            } catch (Throwable th) {
                query.close();
                acquire.release();
                throw th;
            }
        } finally {
            this.a.endTransaction();
        }
    }

    /* JADX INFO: finally extract failed */
    @Override // androidx.work.impl.model.WorkSpecDao
    public List<WorkSpec.WorkInfoPojo> getWorkStatusPojoForName(String str) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT id, state, output, run_attempt_count FROM workspec WHERE id IN (SELECT work_spec_id FROM workname WHERE name=?)", 1);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            Cursor query = DBUtil.query(this.a, acquire, true, null);
            try {
                int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "id");
                int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "state");
                int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "output");
                int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "run_attempt_count");
                ArrayMap<String, ArrayList<String>> arrayMap = new ArrayMap<>();
                ArrayMap<String, ArrayList<Data>> arrayMap2 = new ArrayMap<>();
                while (query.moveToNext()) {
                    if (!query.isNull(columnIndexOrThrow)) {
                        String string = query.getString(columnIndexOrThrow);
                        if (arrayMap.get(string) == null) {
                            arrayMap.put(string, new ArrayList<>());
                        }
                    }
                    if (!query.isNull(columnIndexOrThrow)) {
                        String string2 = query.getString(columnIndexOrThrow);
                        if (arrayMap2.get(string2) == null) {
                            arrayMap2.put(string2, new ArrayList<>());
                        }
                    }
                }
                query.moveToPosition(-1);
                b(arrayMap);
                a(arrayMap2);
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    ArrayList<String> arrayList2 = !query.isNull(columnIndexOrThrow) ? arrayMap.get(query.getString(columnIndexOrThrow)) : null;
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList<>();
                    }
                    ArrayList<Data> arrayList3 = !query.isNull(columnIndexOrThrow) ? arrayMap2.get(query.getString(columnIndexOrThrow)) : null;
                    if (arrayList3 == null) {
                        arrayList3 = new ArrayList<>();
                    }
                    WorkSpec.WorkInfoPojo workInfoPojo = new WorkSpec.WorkInfoPojo();
                    workInfoPojo.id = query.getString(columnIndexOrThrow);
                    workInfoPojo.state = WorkTypeConverters.intToState(query.getInt(columnIndexOrThrow2));
                    workInfoPojo.output = Data.fromByteArray(query.getBlob(columnIndexOrThrow3));
                    workInfoPojo.runAttemptCount = query.getInt(columnIndexOrThrow4);
                    workInfoPojo.tags = arrayList2;
                    workInfoPojo.progress = arrayList3;
                    arrayList.add(workInfoPojo);
                }
                this.a.setTransactionSuccessful();
                query.close();
                acquire.release();
                return arrayList;
            } catch (Throwable th) {
                query.close();
                acquire.release();
                throw th;
            }
        } finally {
            this.a.endTransaction();
        }
    }

    /* JADX INFO: finally extract failed */
    @Override // androidx.work.impl.model.WorkSpecDao
    public List<WorkSpec.WorkInfoPojo> getWorkStatusPojoForTag(String str) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT id, state, output, run_attempt_count FROM workspec WHERE id IN (SELECT work_spec_id FROM worktag WHERE tag=?)", 1);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            Cursor query = DBUtil.query(this.a, acquire, true, null);
            try {
                int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "id");
                int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "state");
                int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "output");
                int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "run_attempt_count");
                ArrayMap<String, ArrayList<String>> arrayMap = new ArrayMap<>();
                ArrayMap<String, ArrayList<Data>> arrayMap2 = new ArrayMap<>();
                while (query.moveToNext()) {
                    if (!query.isNull(columnIndexOrThrow)) {
                        String string = query.getString(columnIndexOrThrow);
                        if (arrayMap.get(string) == null) {
                            arrayMap.put(string, new ArrayList<>());
                        }
                    }
                    if (!query.isNull(columnIndexOrThrow)) {
                        String string2 = query.getString(columnIndexOrThrow);
                        if (arrayMap2.get(string2) == null) {
                            arrayMap2.put(string2, new ArrayList<>());
                        }
                    }
                }
                query.moveToPosition(-1);
                b(arrayMap);
                a(arrayMap2);
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    ArrayList<String> arrayList2 = !query.isNull(columnIndexOrThrow) ? arrayMap.get(query.getString(columnIndexOrThrow)) : null;
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList<>();
                    }
                    ArrayList<Data> arrayList3 = !query.isNull(columnIndexOrThrow) ? arrayMap2.get(query.getString(columnIndexOrThrow)) : null;
                    if (arrayList3 == null) {
                        arrayList3 = new ArrayList<>();
                    }
                    WorkSpec.WorkInfoPojo workInfoPojo = new WorkSpec.WorkInfoPojo();
                    workInfoPojo.id = query.getString(columnIndexOrThrow);
                    workInfoPojo.state = WorkTypeConverters.intToState(query.getInt(columnIndexOrThrow2));
                    workInfoPojo.output = Data.fromByteArray(query.getBlob(columnIndexOrThrow3));
                    workInfoPojo.runAttemptCount = query.getInt(columnIndexOrThrow4);
                    workInfoPojo.tags = arrayList2;
                    workInfoPojo.progress = arrayList3;
                    arrayList.add(workInfoPojo);
                }
                this.a.setTransactionSuccessful();
                query.close();
                acquire.release();
                return arrayList;
            } catch (Throwable th) {
                query.close();
                acquire.release();
                throw th;
            }
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public LiveData<List<WorkSpec.WorkInfoPojo>> getWorkStatusPojoLiveDataForIds(List<String> list) {
        StringBuilder newStringBuilder = StringUtil.newStringBuilder();
        newStringBuilder.append("SELECT id, state, output, run_attempt_count FROM workspec WHERE id IN (");
        int size = list.size();
        StringUtil.appendPlaceholders(newStringBuilder, size);
        newStringBuilder.append(")");
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire(newStringBuilder.toString(), size + 0);
        int i2 = 1;
        for (String str : list) {
            if (str == null) {
                acquire.bindNull(i2);
            } else {
                acquire.bindString(i2, str);
            }
            i2++;
        }
        return this.a.getInvalidationTracker().createLiveData(new String[]{"WorkTag", "WorkProgress", "workspec"}, true, new a(acquire));
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public LiveData<List<WorkSpec.WorkInfoPojo>> getWorkStatusPojoLiveDataForName(String str) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT id, state, output, run_attempt_count FROM workspec WHERE id IN (SELECT work_spec_id FROM workname WHERE name=?)", 1);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        return this.a.getInvalidationTracker().createLiveData(new String[]{"WorkTag", "WorkProgress", "workspec", "workname"}, true, new c(acquire));
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public LiveData<List<WorkSpec.WorkInfoPojo>> getWorkStatusPojoLiveDataForTag(String str) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT id, state, output, run_attempt_count FROM workspec WHERE id IN (SELECT work_spec_id FROM worktag WHERE tag=?)", 1);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        return this.a.getInvalidationTracker().createLiveData(new String[]{"WorkTag", "WorkProgress", "workspec", "worktag"}, true, new b(acquire));
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public int incrementWorkSpecRunAttemptCount(String str) {
        this.a.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.f.acquire();
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        this.a.beginTransaction();
        try {
            int executeUpdateDelete = acquire.executeUpdateDelete();
            this.a.setTransactionSuccessful();
            return executeUpdateDelete;
        } finally {
            this.a.endTransaction();
            this.f.release(acquire);
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public void insertWorkSpec(WorkSpec workSpec) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        try {
            this.b.insert((EntityInsertionAdapter<WorkSpec>) workSpec);
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public int markWorkSpecScheduled(String str, long j2) {
        this.a.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.h.acquire();
        acquire.bindLong(1, j2);
        if (str == null) {
            acquire.bindNull(2);
        } else {
            acquire.bindString(2, str);
        }
        this.a.beginTransaction();
        try {
            int executeUpdateDelete = acquire.executeUpdateDelete();
            this.a.setTransactionSuccessful();
            return executeUpdateDelete;
        } finally {
            this.a.endTransaction();
            this.h.release(acquire);
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public void pruneFinishedWorkWithZeroDependentsIgnoringKeepForAtLeast() {
        this.a.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.j.acquire();
        this.a.beginTransaction();
        try {
            acquire.executeUpdateDelete();
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
            this.j.release(acquire);
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public int resetScheduledState() {
        this.a.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.i.acquire();
        this.a.beginTransaction();
        try {
            int executeUpdateDelete = acquire.executeUpdateDelete();
            this.a.setTransactionSuccessful();
            return executeUpdateDelete;
        } finally {
            this.a.endTransaction();
            this.i.release(acquire);
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public int resetWorkSpecRunAttemptCount(String str) {
        this.a.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.g.acquire();
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        this.a.beginTransaction();
        try {
            int executeUpdateDelete = acquire.executeUpdateDelete();
            this.a.setTransactionSuccessful();
            return executeUpdateDelete;
        } finally {
            this.a.endTransaction();
            this.g.release(acquire);
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public void setOutput(String str, Data data) {
        this.a.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.d.acquire();
        byte[] byteArrayInternal = Data.toByteArrayInternal(data);
        if (byteArrayInternal == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindBlob(1, byteArrayInternal);
        }
        if (str == null) {
            acquire.bindNull(2);
        } else {
            acquire.bindString(2, str);
        }
        this.a.beginTransaction();
        try {
            acquire.executeUpdateDelete();
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
            this.d.release(acquire);
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public void setPeriodStartTime(String str, long j2) {
        this.a.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.e.acquire();
        acquire.bindLong(1, j2);
        if (str == null) {
            acquire.bindNull(2);
        } else {
            acquire.bindString(2, str);
        }
        this.a.beginTransaction();
        try {
            acquire.executeUpdateDelete();
            this.a.setTransactionSuccessful();
        } finally {
            this.a.endTransaction();
            this.e.release(acquire);
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public int setState(WorkInfo.State state, String... strArr) {
        this.a.assertNotSuspendingTransaction();
        StringBuilder newStringBuilder = StringUtil.newStringBuilder();
        newStringBuilder.append("UPDATE workspec SET state=");
        newStringBuilder.append("?");
        newStringBuilder.append(" WHERE id IN (");
        StringUtil.appendPlaceholders(newStringBuilder, strArr.length);
        newStringBuilder.append(")");
        SupportSQLiteStatement compileStatement = this.a.compileStatement(newStringBuilder.toString());
        compileStatement.bindLong(1, (long) WorkTypeConverters.stateToInt(state));
        int i2 = 2;
        for (String str : strArr) {
            if (str == null) {
                compileStatement.bindNull(i2);
            } else {
                compileStatement.bindString(i2, str);
            }
            i2++;
        }
        this.a.beginTransaction();
        try {
            int executeUpdateDelete = compileStatement.executeUpdateDelete();
            this.a.setTransactionSuccessful();
            return executeUpdateDelete;
        } finally {
            this.a.endTransaction();
        }
    }
}
