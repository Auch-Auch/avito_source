package androidx.appcompat.widget;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.database.DataSetObservable;
import android.os.AsyncTask;
import android.text.TextUtils;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class ActivityChooserModel extends DataSetObservable {
    public static final String n = ActivityChooserModel.class.getSimpleName();
    public static final Object o = new Object();
    public static final Map<String, ActivityChooserModel> p = new HashMap();
    public final Object a = new Object();
    public final List<ActivityResolveInfo> b = new ArrayList();
    public final List<HistoricalRecord> c = new ArrayList();
    public final Context d;
    public final String e;
    public Intent f;
    public ActivitySorter g = new a();
    public int h = 50;
    public boolean i = true;
    public boolean j = false;
    public boolean k = true;
    public boolean l = false;
    public OnChooseActivityListener m;

    public interface ActivityChooserModelClient {
        void setActivityChooserModel(ActivityChooserModel activityChooserModel);
    }

    public static final class ActivityResolveInfo implements Comparable<ActivityResolveInfo> {
        public final ResolveInfo resolveInfo;
        public float weight;

        public ActivityResolveInfo(ResolveInfo resolveInfo2) {
            this.resolveInfo = resolveInfo2;
        }

        @Override // java.lang.Object
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && ActivityResolveInfo.class == obj.getClass() && Float.floatToIntBits(this.weight) == Float.floatToIntBits(((ActivityResolveInfo) obj).weight);
        }

        @Override // java.lang.Object
        public int hashCode() {
            return Float.floatToIntBits(this.weight) + 31;
        }

        @Override // java.lang.Object
        public String toString() {
            StringBuilder Q = a2.b.a.a.a.Q("[", "resolveInfo:");
            Q.append(this.resolveInfo.toString());
            Q.append("; weight:");
            Q.append(new BigDecimal((double) this.weight));
            Q.append("]");
            return Q.toString();
        }

        public int compareTo(ActivityResolveInfo activityResolveInfo) {
            return Float.floatToIntBits(activityResolveInfo.weight) - Float.floatToIntBits(this.weight);
        }
    }

    public interface ActivitySorter {
        void sort(Intent intent, List<ActivityResolveInfo> list, List<HistoricalRecord> list2);
    }

    public static final class HistoricalRecord {
        public final ComponentName activity;
        public final long time;
        public final float weight;

        public HistoricalRecord(String str, long j, float f) {
            this(ComponentName.unflattenFromString(str), j, f);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || HistoricalRecord.class != obj.getClass()) {
                return false;
            }
            HistoricalRecord historicalRecord = (HistoricalRecord) obj;
            ComponentName componentName = this.activity;
            if (componentName == null) {
                if (historicalRecord.activity != null) {
                    return false;
                }
            } else if (!componentName.equals(historicalRecord.activity)) {
                return false;
            }
            return this.time == historicalRecord.time && Float.floatToIntBits(this.weight) == Float.floatToIntBits(historicalRecord.weight);
        }

        public int hashCode() {
            ComponentName componentName = this.activity;
            int hashCode = componentName == null ? 0 : componentName.hashCode();
            long j = this.time;
            return Float.floatToIntBits(this.weight) + ((((hashCode + 31) * 31) + ((int) (j ^ (j >>> 32)))) * 31);
        }

        public String toString() {
            StringBuilder Q = a2.b.a.a.a.Q("[", "; activity:");
            Q.append(this.activity);
            Q.append("; time:");
            Q.append(this.time);
            Q.append("; weight:");
            Q.append(new BigDecimal((double) this.weight));
            Q.append("]");
            return Q.toString();
        }

        public HistoricalRecord(ComponentName componentName, long j, float f) {
            this.activity = componentName;
            this.time = j;
            this.weight = f;
        }
    }

    public interface OnChooseActivityListener {
        boolean onChooseActivity(ActivityChooserModel activityChooserModel, Intent intent);
    }

    public static final class a implements ActivitySorter {
        public final Map<ComponentName, ActivityResolveInfo> a = new HashMap();

        @Override // androidx.appcompat.widget.ActivityChooserModel.ActivitySorter
        public void sort(Intent intent, List<ActivityResolveInfo> list, List<HistoricalRecord> list2) {
            Map<ComponentName, ActivityResolveInfo> map = this.a;
            map.clear();
            int size = list.size();
            for (int i = 0; i < size; i++) {
                ActivityResolveInfo activityResolveInfo = list.get(i);
                activityResolveInfo.weight = 0.0f;
                ActivityInfo activityInfo = activityResolveInfo.resolveInfo.activityInfo;
                map.put(new ComponentName(activityInfo.packageName, activityInfo.name), activityResolveInfo);
            }
            float f = 1.0f;
            for (int size2 = list2.size() - 1; size2 >= 0; size2--) {
                HistoricalRecord historicalRecord = list2.get(size2);
                ActivityResolveInfo activityResolveInfo2 = map.get(historicalRecord.activity);
                if (activityResolveInfo2 != null) {
                    activityResolveInfo2.weight = (historicalRecord.weight * f) + activityResolveInfo2.weight;
                    f *= 0.95f;
                }
            }
            Collections.sort(list);
        }
    }

    public final class b extends AsyncTask<Object, Void, Void> {
        public b() {
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX WARNING: Code restructure failed: missing block: B:10:0x006b, code lost:
            if (r14 != null) goto L_0x0090;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0078, code lost:
            if (r14 == null) goto L_0x00a0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0083, code lost:
            if (r14 == null) goto L_0x00a0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x008e, code lost:
            if (r14 == null) goto L_0x00a0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
            r14.close();
         */
        @Override // android.os.AsyncTask
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Void doInBackground(java.lang.Object[] r14) {
            /*
                r13 = this;
                java.lang.String r0 = "historical-record"
                java.lang.String r1 = "historical-records"
                r2 = 0
                r3 = r14[r2]
                java.util.List r3 = (java.util.List) r3
                r4 = 1
                r14 = r14[r4]
                java.lang.String r14 = (java.lang.String) r14
                r5 = 0
                androidx.appcompat.widget.ActivityChooserModel r6 = androidx.appcompat.widget.ActivityChooserModel.this     // Catch:{ FileNotFoundException -> 0x009e }
                android.content.Context r6 = r6.d     // Catch:{ FileNotFoundException -> 0x009e }
                java.io.FileOutputStream r14 = r6.openFileOutput(r14, r2)     // Catch:{ FileNotFoundException -> 0x009e }
                org.xmlpull.v1.XmlSerializer r6 = android.util.Xml.newSerializer()
                r6.setOutput(r14, r5)     // Catch:{ IllegalArgumentException -> 0x0086, IllegalStateException -> 0x007b, IOException -> 0x0070 }
                java.lang.String r7 = "UTF-8"
                java.lang.Boolean r8 = java.lang.Boolean.TRUE     // Catch:{ IllegalArgumentException -> 0x0086, IllegalStateException -> 0x007b, IOException -> 0x0070 }
                r6.startDocument(r7, r8)     // Catch:{ IllegalArgumentException -> 0x0086, IllegalStateException -> 0x007b, IOException -> 0x0070 }
                r6.startTag(r5, r1)     // Catch:{ IllegalArgumentException -> 0x0086, IllegalStateException -> 0x007b, IOException -> 0x0070 }
                int r7 = r3.size()     // Catch:{ IllegalArgumentException -> 0x0086, IllegalStateException -> 0x007b, IOException -> 0x0070 }
                r8 = 0
            L_0x002d:
                if (r8 >= r7) goto L_0x0061
                java.lang.Object r9 = r3.remove(r2)     // Catch:{ IllegalArgumentException -> 0x0086, IllegalStateException -> 0x007b, IOException -> 0x0070 }
                androidx.appcompat.widget.ActivityChooserModel$HistoricalRecord r9 = (androidx.appcompat.widget.ActivityChooserModel.HistoricalRecord) r9     // Catch:{ IllegalArgumentException -> 0x0086, IllegalStateException -> 0x007b, IOException -> 0x0070 }
                r6.startTag(r5, r0)     // Catch:{ IllegalArgumentException -> 0x0086, IllegalStateException -> 0x007b, IOException -> 0x0070 }
                java.lang.String r10 = "activity"
                android.content.ComponentName r11 = r9.activity     // Catch:{ IllegalArgumentException -> 0x0086, IllegalStateException -> 0x007b, IOException -> 0x0070 }
                java.lang.String r11 = r11.flattenToString()     // Catch:{ IllegalArgumentException -> 0x0086, IllegalStateException -> 0x007b, IOException -> 0x0070 }
                r6.attribute(r5, r10, r11)     // Catch:{ IllegalArgumentException -> 0x0086, IllegalStateException -> 0x007b, IOException -> 0x0070 }
                java.lang.String r10 = "time"
                long r11 = r9.time     // Catch:{ IllegalArgumentException -> 0x0086, IllegalStateException -> 0x007b, IOException -> 0x0070 }
                java.lang.String r11 = java.lang.String.valueOf(r11)     // Catch:{ IllegalArgumentException -> 0x0086, IllegalStateException -> 0x007b, IOException -> 0x0070 }
                r6.attribute(r5, r10, r11)     // Catch:{ IllegalArgumentException -> 0x0086, IllegalStateException -> 0x007b, IOException -> 0x0070 }
                java.lang.String r10 = "weight"
                float r9 = r9.weight     // Catch:{ IllegalArgumentException -> 0x0086, IllegalStateException -> 0x007b, IOException -> 0x0070 }
                java.lang.String r9 = java.lang.String.valueOf(r9)     // Catch:{ IllegalArgumentException -> 0x0086, IllegalStateException -> 0x007b, IOException -> 0x0070 }
                r6.attribute(r5, r10, r9)     // Catch:{ IllegalArgumentException -> 0x0086, IllegalStateException -> 0x007b, IOException -> 0x0070 }
                r6.endTag(r5, r0)     // Catch:{ IllegalArgumentException -> 0x0086, IllegalStateException -> 0x007b, IOException -> 0x0070 }
                int r8 = r8 + 1
                goto L_0x002d
            L_0x0061:
                r6.endTag(r5, r1)     // Catch:{ IllegalArgumentException -> 0x0086, IllegalStateException -> 0x007b, IOException -> 0x0070 }
                r6.endDocument()     // Catch:{ IllegalArgumentException -> 0x0086, IllegalStateException -> 0x007b, IOException -> 0x0070 }
                androidx.appcompat.widget.ActivityChooserModel r0 = androidx.appcompat.widget.ActivityChooserModel.this
                r0.i = r4
                if (r14 == 0) goto L_0x00a0
                goto L_0x0090
            L_0x006e:
                r0 = move-exception
                goto L_0x0094
            L_0x0070:
                java.lang.String r0 = androidx.appcompat.widget.ActivityChooserModel.n     // Catch:{ all -> 0x006e }
                androidx.appcompat.widget.ActivityChooserModel r0 = androidx.appcompat.widget.ActivityChooserModel.this     // Catch:{ all -> 0x006e }
                java.lang.String r1 = r0.e     // Catch:{ all -> 0x006e }
                r0.i = r4
                if (r14 == 0) goto L_0x00a0
                goto L_0x0090
            L_0x007b:
                java.lang.String r0 = androidx.appcompat.widget.ActivityChooserModel.n
                androidx.appcompat.widget.ActivityChooserModel r0 = androidx.appcompat.widget.ActivityChooserModel.this
                java.lang.String r1 = r0.e
                r0.i = r4
                if (r14 == 0) goto L_0x00a0
                goto L_0x0090
            L_0x0086:
                java.lang.String r0 = androidx.appcompat.widget.ActivityChooserModel.n
                androidx.appcompat.widget.ActivityChooserModel r0 = androidx.appcompat.widget.ActivityChooserModel.this
                java.lang.String r1 = r0.e
                r0.i = r4
                if (r14 == 0) goto L_0x00a0
            L_0x0090:
                r14.close()     // Catch:{ IOException -> 0x00a0 }
                goto L_0x00a0
            L_0x0094:
                androidx.appcompat.widget.ActivityChooserModel r1 = androidx.appcompat.widget.ActivityChooserModel.this
                r1.i = r4
                if (r14 == 0) goto L_0x009d
                r14.close()     // Catch:{ IOException -> 0x009d }
            L_0x009d:
                throw r0
            L_0x009e:
                java.lang.String r14 = androidx.appcompat.widget.ActivityChooserModel.n
            L_0x00a0:
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ActivityChooserModel.b.doInBackground(java.lang.Object[]):java.lang.Object");
        }
    }

    public ActivityChooserModel(Context context, String str) {
        this.d = context.getApplicationContext();
        if (TextUtils.isEmpty(str) || str.endsWith(".xml")) {
            this.e = str;
        } else {
            this.e = a2.b.a.a.a.c3(str, ".xml");
        }
    }

    public static ActivityChooserModel d(Context context, String str) {
        ActivityChooserModel activityChooserModel;
        synchronized (o) {
            Map<String, ActivityChooserModel> map = p;
            activityChooserModel = map.get(str);
            if (activityChooserModel == null) {
                activityChooserModel = new ActivityChooserModel(context, str);
                map.put(str, activityChooserModel);
            }
        }
        return activityChooserModel;
    }

    public final boolean a(HistoricalRecord historicalRecord) {
        boolean add = this.c.add(historicalRecord);
        if (add) {
            this.k = true;
            h();
            if (this.j) {
                if (this.k) {
                    this.k = false;
                    if (!TextUtils.isEmpty(this.e)) {
                        new b().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new ArrayList(this.c), this.e);
                    }
                }
                i();
                notifyChanged();
            } else {
                throw new IllegalStateException("No preceding call to #readHistoricalData");
            }
        }
        return add;
    }

    public Intent b(int i2) {
        synchronized (this.a) {
            if (this.f == null) {
                return null;
            }
            c();
            ActivityInfo activityInfo = this.b.get(i2).resolveInfo.activityInfo;
            ComponentName componentName = new ComponentName(activityInfo.packageName, activityInfo.name);
            Intent intent = new Intent(this.f);
            intent.setComponent(componentName);
            if (this.m != null) {
                if (this.m.onChooseActivity(this, new Intent(intent))) {
                    return null;
                }
            }
            a(new HistoricalRecord(componentName, System.currentTimeMillis(), 1.0f));
            return intent;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00d4, code lost:
        if (r3 == null) goto L_0x00dd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00d8, code lost:
        if (r3 == null) goto L_0x00dd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00da, code lost:
        r3.close();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void c() {
        /*
        // Method dump skipped, instructions count: 235
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ActivityChooserModel.c():void");
    }

    public ResolveInfo e(int i2) {
        ResolveInfo resolveInfo;
        synchronized (this.a) {
            c();
            resolveInfo = this.b.get(i2).resolveInfo;
        }
        return resolveInfo;
    }

    public int f() {
        int size;
        synchronized (this.a) {
            c();
            size = this.b.size();
        }
        return size;
    }

    public ResolveInfo g() {
        synchronized (this.a) {
            c();
            if (this.b.isEmpty()) {
                return null;
            }
            return this.b.get(0).resolveInfo;
        }
    }

    public final void h() {
        int size = this.c.size() - this.h;
        if (size > 0) {
            this.k = true;
            for (int i2 = 0; i2 < size; i2++) {
                this.c.remove(0);
            }
        }
    }

    public final boolean i() {
        if (this.g == null || this.f == null || this.b.isEmpty() || this.c.isEmpty()) {
            return false;
        }
        this.g.sort(this.f, this.b, Collections.unmodifiableList(this.c));
        return true;
    }
}
