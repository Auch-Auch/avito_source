package androidx.work.impl.model;

import android.database.Cursor;
import androidx.collection.ArrayMap;
import androidx.lifecycle.LiveData;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.work.Data;
import androidx.work.impl.model.WorkSpec;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
public final class RawWorkInfoDao_Impl implements RawWorkInfoDao {
    public final RoomDatabase a;

    public class a implements Callable<List<WorkSpec.WorkInfoPojo>> {
        public final /* synthetic */ SupportSQLiteQuery a;

        public a(SupportSQLiteQuery supportSQLiteQuery) {
            this.a = supportSQLiteQuery;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.concurrent.Callable
        public List<WorkSpec.WorkInfoPojo> call() throws Exception {
            Cursor query = DBUtil.query(RawWorkInfoDao_Impl.this.a, this.a, true, null);
            try {
                int columnIndex = CursorUtil.getColumnIndex(query, "id");
                int columnIndex2 = CursorUtil.getColumnIndex(query, "state");
                int columnIndex3 = CursorUtil.getColumnIndex(query, "output");
                int columnIndex4 = CursorUtil.getColumnIndex(query, "run_attempt_count");
                ArrayMap<String, ArrayList<String>> arrayMap = new ArrayMap<>();
                ArrayMap<String, ArrayList<Data>> arrayMap2 = new ArrayMap<>();
                while (query.moveToNext()) {
                    if (!query.isNull(columnIndex)) {
                        String string = query.getString(columnIndex);
                        if (arrayMap.get(string) == null) {
                            arrayMap.put(string, new ArrayList<>());
                        }
                    }
                    if (!query.isNull(columnIndex)) {
                        String string2 = query.getString(columnIndex);
                        if (arrayMap2.get(string2) == null) {
                            arrayMap2.put(string2, new ArrayList<>());
                        }
                    }
                }
                query.moveToPosition(-1);
                RawWorkInfoDao_Impl.this.b(arrayMap);
                RawWorkInfoDao_Impl.this.a(arrayMap2);
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    ArrayList<String> arrayList2 = !query.isNull(columnIndex) ? arrayMap.get(query.getString(columnIndex)) : null;
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList<>();
                    }
                    ArrayList<Data> arrayList3 = !query.isNull(columnIndex) ? arrayMap2.get(query.getString(columnIndex)) : null;
                    if (arrayList3 == null) {
                        arrayList3 = new ArrayList<>();
                    }
                    WorkSpec.WorkInfoPojo workInfoPojo = new WorkSpec.WorkInfoPojo();
                    if (columnIndex != -1) {
                        workInfoPojo.id = query.getString(columnIndex);
                    }
                    if (columnIndex2 != -1) {
                        workInfoPojo.state = WorkTypeConverters.intToState(query.getInt(columnIndex2));
                    }
                    if (columnIndex3 != -1) {
                        workInfoPojo.output = Data.fromByteArray(query.getBlob(columnIndex3));
                    }
                    if (columnIndex4 != -1) {
                        workInfoPojo.runAttemptCount = query.getInt(columnIndex4);
                    }
                    workInfoPojo.tags = arrayList2;
                    workInfoPojo.progress = arrayList3;
                    arrayList.add(workInfoPojo);
                }
                return arrayList;
            } finally {
                query.close();
            }
        }
    }

    public RawWorkInfoDao_Impl(RoomDatabase roomDatabase) {
        this.a = roomDatabase;
    }

    public final void a(ArrayMap<String, ArrayList<Data>> arrayMap) {
        ArrayList<Data> arrayList;
        int i;
        Set<String> keySet = arrayMap.keySet();
        if (!keySet.isEmpty()) {
            if (arrayMap.size() > 999) {
                ArrayMap<String, ArrayList<Data>> arrayMap2 = new ArrayMap<>(999);
                int size = arrayMap.size();
                int i2 = 0;
                loop0:
                while (true) {
                    i = 0;
                    while (i2 < size) {
                        arrayMap2.put(arrayMap.keyAt(i2), arrayMap.valueAt(i2));
                        i2++;
                        i++;
                        if (i == 999) {
                            a(arrayMap2);
                            arrayMap2 = new ArrayMap<>(999);
                        }
                    }
                    break loop0;
                }
                if (i > 0) {
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
            int i3 = 1;
            for (String str : keySet) {
                if (str == null) {
                    acquire.bindNull(i3);
                } else {
                    acquire.bindString(i3, str);
                }
                i3++;
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
        int i;
        Set<String> keySet = arrayMap.keySet();
        if (!keySet.isEmpty()) {
            if (arrayMap.size() > 999) {
                ArrayMap<String, ArrayList<String>> arrayMap2 = new ArrayMap<>(999);
                int size = arrayMap.size();
                int i2 = 0;
                loop0:
                while (true) {
                    i = 0;
                    while (i2 < size) {
                        arrayMap2.put(arrayMap.keyAt(i2), arrayMap.valueAt(i2));
                        i2++;
                        i++;
                        if (i == 999) {
                            b(arrayMap2);
                            arrayMap2 = new ArrayMap<>(999);
                        }
                    }
                    break loop0;
                }
                if (i > 0) {
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
            int i3 = 1;
            for (String str : keySet) {
                if (str == null) {
                    acquire.bindNull(i3);
                } else {
                    acquire.bindString(i3, str);
                }
                i3++;
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

    @Override // androidx.work.impl.model.RawWorkInfoDao
    public List<WorkSpec.WorkInfoPojo> getWorkInfoPojos(SupportSQLiteQuery supportSQLiteQuery) {
        this.a.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.a, supportSQLiteQuery, true, null);
        try {
            int columnIndex = CursorUtil.getColumnIndex(query, "id");
            int columnIndex2 = CursorUtil.getColumnIndex(query, "state");
            int columnIndex3 = CursorUtil.getColumnIndex(query, "output");
            int columnIndex4 = CursorUtil.getColumnIndex(query, "run_attempt_count");
            ArrayMap<String, ArrayList<String>> arrayMap = new ArrayMap<>();
            ArrayMap<String, ArrayList<Data>> arrayMap2 = new ArrayMap<>();
            while (query.moveToNext()) {
                if (!query.isNull(columnIndex)) {
                    String string = query.getString(columnIndex);
                    if (arrayMap.get(string) == null) {
                        arrayMap.put(string, new ArrayList<>());
                    }
                }
                if (!query.isNull(columnIndex)) {
                    String string2 = query.getString(columnIndex);
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
                ArrayList<String> arrayList2 = !query.isNull(columnIndex) ? arrayMap.get(query.getString(columnIndex)) : null;
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList<>();
                }
                ArrayList<Data> arrayList3 = !query.isNull(columnIndex) ? arrayMap2.get(query.getString(columnIndex)) : null;
                if (arrayList3 == null) {
                    arrayList3 = new ArrayList<>();
                }
                WorkSpec.WorkInfoPojo workInfoPojo = new WorkSpec.WorkInfoPojo();
                if (columnIndex != -1) {
                    workInfoPojo.id = query.getString(columnIndex);
                }
                if (columnIndex2 != -1) {
                    workInfoPojo.state = WorkTypeConverters.intToState(query.getInt(columnIndex2));
                }
                if (columnIndex3 != -1) {
                    workInfoPojo.output = Data.fromByteArray(query.getBlob(columnIndex3));
                }
                if (columnIndex4 != -1) {
                    workInfoPojo.runAttemptCount = query.getInt(columnIndex4);
                }
                workInfoPojo.tags = arrayList2;
                workInfoPojo.progress = arrayList3;
                arrayList.add(workInfoPojo);
            }
            return arrayList;
        } finally {
            query.close();
        }
    }

    @Override // androidx.work.impl.model.RawWorkInfoDao
    public LiveData<List<WorkSpec.WorkInfoPojo>> getWorkInfoPojosLiveData(SupportSQLiteQuery supportSQLiteQuery) {
        return this.a.getInvalidationTracker().createLiveData(new String[]{"WorkTag", "WorkProgress"}, false, new a(supportSQLiteQuery));
    }
}
