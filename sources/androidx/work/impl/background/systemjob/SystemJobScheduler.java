package androidx.work.impl.background.systemjob;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.Build;
import android.os.PersistableBundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.work.Logger;
import androidx.work.WorkInfo;
import androidx.work.impl.Scheduler;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.model.SystemIdInfo;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.IdGenerator;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import l6.d0.a.d.b.a;
@RequiresApi(23)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class SystemJobScheduler implements Scheduler {
    public static final String e = Logger.tagWithPrefix("SystemJobScheduler");
    public final Context a;
    public final JobScheduler b;
    public final WorkManagerImpl c;
    public final a d;

    public SystemJobScheduler(@NonNull Context context, @NonNull WorkManagerImpl workManagerImpl) {
        this(context, workManagerImpl, (JobScheduler) context.getSystemService("jobscheduler"), new a(context));
    }

    public static void a(@NonNull JobScheduler jobScheduler, int i) {
        try {
            jobScheduler.cancel(i);
        } catch (Throwable th) {
            Logger.get().error(e, String.format(Locale.getDefault(), "Exception while trying to cancel job (%d)", Integer.valueOf(i)), th);
        }
    }

    @Nullable
    public static List<Integer> b(@NonNull Context context, @NonNull JobScheduler jobScheduler, @NonNull String str) {
        List<JobInfo> c2 = c(context, jobScheduler);
        if (c2 == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(2);
        for (JobInfo jobInfo : c2) {
            if (str.equals(d(jobInfo))) {
                arrayList.add(Integer.valueOf(jobInfo.getId()));
            }
        }
        return arrayList;
    }

    @Nullable
    public static List<JobInfo> c(@NonNull Context context, @NonNull JobScheduler jobScheduler) {
        List<JobInfo> list;
        try {
            list = jobScheduler.getAllPendingJobs();
        } catch (Throwable th) {
            Logger.get().error(e, "getAllPendingJobs() is not reliable on this device.", th);
            list = null;
        }
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        ComponentName componentName = new ComponentName(context, SystemJobService.class);
        for (JobInfo jobInfo : list) {
            if (componentName.equals(jobInfo.getService())) {
                arrayList.add(jobInfo);
            }
        }
        return arrayList;
    }

    public static void cancelAll(@NonNull Context context) {
        List<JobInfo> c2;
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        if (!(jobScheduler == null || (c2 = c(context, jobScheduler)) == null || c2.isEmpty())) {
            for (JobInfo jobInfo : c2) {
                a(jobScheduler, jobInfo.getId());
            }
        }
    }

    public static void cancelInvalidJobs(@NonNull Context context) {
        List<JobInfo> c2;
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        if (!(jobScheduler == null || (c2 = c(context, jobScheduler)) == null || c2.isEmpty())) {
            for (JobInfo jobInfo : c2) {
                if (d(jobInfo) == null) {
                    a(jobScheduler, jobInfo.getId());
                }
            }
        }
    }

    @Nullable
    public static String d(@NonNull JobInfo jobInfo) {
        PersistableBundle extras = jobInfo.getExtras();
        if (extras == null) {
            return null;
        }
        try {
            if (extras.containsKey("EXTRA_WORK_SPEC_ID")) {
                return extras.getString("EXTRA_WORK_SPEC_ID");
            }
            return null;
        } catch (NullPointerException unused) {
            return null;
        }
    }

    @Override // androidx.work.impl.Scheduler
    public void cancel(@NonNull String str) {
        List<Integer> b2 = b(this.a, this.b, str);
        if (!(b2 == null || b2.isEmpty())) {
            for (Integer num : b2) {
                a(this.b, num.intValue());
            }
            this.c.getWorkDatabase().systemIdInfoDao().removeSystemIdInfo(str);
        }
    }

    @Override // androidx.work.impl.Scheduler
    public boolean hasLimitedSchedulingSlots() {
        return true;
    }

    /* JADX INFO: finally extract failed */
    @Override // androidx.work.impl.Scheduler
    public void schedule(@NonNull WorkSpec... workSpecArr) {
        int i;
        List<Integer> b2;
        int i2;
        WorkDatabase workDatabase = this.c.getWorkDatabase();
        IdGenerator idGenerator = new IdGenerator(workDatabase);
        for (WorkSpec workSpec : workSpecArr) {
            workDatabase.beginTransaction();
            try {
                WorkSpec workSpec2 = workDatabase.workSpecDao().getWorkSpec(workSpec.id);
                if (workSpec2 == null) {
                    Logger.get().warning(e, "Skipping scheduling " + workSpec.id + " because it's no longer in the DB", new Throwable[0]);
                    workDatabase.setTransactionSuccessful();
                } else if (workSpec2.state != WorkInfo.State.ENQUEUED) {
                    Logger.get().warning(e, "Skipping scheduling " + workSpec.id + " because it is no longer enqueued", new Throwable[0]);
                    workDatabase.setTransactionSuccessful();
                } else {
                    SystemIdInfo systemIdInfo = workDatabase.systemIdInfoDao().getSystemIdInfo(workSpec.id);
                    if (systemIdInfo != null) {
                        i = systemIdInfo.systemId;
                    } else {
                        i = idGenerator.nextJobSchedulerIdWithRange(this.c.getConfiguration().getMinJobSchedulerId(), this.c.getConfiguration().getMaxJobSchedulerId());
                    }
                    if (systemIdInfo == null) {
                        this.c.getWorkDatabase().systemIdInfoDao().insertSystemIdInfo(new SystemIdInfo(workSpec.id, i));
                    }
                    scheduleInternal(workSpec, i);
                    if (Build.VERSION.SDK_INT == 23 && (b2 = b(this.a, this.b, workSpec.id)) != null) {
                        int indexOf = b2.indexOf(Integer.valueOf(i));
                        if (indexOf >= 0) {
                            b2.remove(indexOf);
                        }
                        if (!b2.isEmpty()) {
                            i2 = b2.get(0).intValue();
                        } else {
                            i2 = idGenerator.nextJobSchedulerIdWithRange(this.c.getConfiguration().getMinJobSchedulerId(), this.c.getConfiguration().getMaxJobSchedulerId());
                        }
                        scheduleInternal(workSpec, i2);
                    }
                    workDatabase.setTransactionSuccessful();
                }
                workDatabase.endTransaction();
            } catch (Throwable th) {
                workDatabase.endTransaction();
                throw th;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0029, code lost:
        if (android.os.Build.VERSION.SDK_INT < 26) goto L_0x0032;
     */
    @androidx.annotation.VisibleForTesting
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void scheduleInternal(androidx.work.impl.model.WorkSpec r17, int r18) {
        /*
        // Method dump skipped, instructions count: 428
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.background.systemjob.SystemJobScheduler.scheduleInternal(androidx.work.impl.model.WorkSpec, int):void");
    }

    @VisibleForTesting
    public SystemJobScheduler(Context context, WorkManagerImpl workManagerImpl, JobScheduler jobScheduler, a aVar) {
        this.a = context;
        this.c = workManagerImpl;
        this.b = jobScheduler;
        this.d = aVar;
    }
}
