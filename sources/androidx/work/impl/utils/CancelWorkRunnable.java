package androidx.work.impl.utils;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.annotation.WorkerThread;
import androidx.work.Operation;
import androidx.work.WorkInfo;
import androidx.work.impl.OperationImpl;
import androidx.work.impl.Scheduler;
import androidx.work.impl.Schedulers;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.model.DependencyDao;
import androidx.work.impl.model.WorkSpecDao;
import java.util.LinkedList;
import java.util.UUID;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public abstract class CancelWorkRunnable implements Runnable {
    public final OperationImpl a = new OperationImpl();

    public class a extends CancelWorkRunnable {
        public final /* synthetic */ WorkManagerImpl b;
        public final /* synthetic */ UUID c;

        public a(WorkManagerImpl workManagerImpl, UUID uuid) {
            this.b = workManagerImpl;
            this.c = uuid;
        }

        /* JADX INFO: finally extract failed */
        @Override // androidx.work.impl.utils.CancelWorkRunnable
        @WorkerThread
        public void c() {
            WorkDatabase workDatabase = this.b.getWorkDatabase();
            workDatabase.beginTransaction();
            try {
                a(this.b, this.c.toString());
                workDatabase.setTransactionSuccessful();
                workDatabase.endTransaction();
                b(this.b);
            } catch (Throwable th) {
                workDatabase.endTransaction();
                throw th;
            }
        }
    }

    public class b extends CancelWorkRunnable {
        public final /* synthetic */ WorkManagerImpl b;
        public final /* synthetic */ String c;

        public b(WorkManagerImpl workManagerImpl, String str) {
            this.b = workManagerImpl;
            this.c = str;
        }

        /* JADX INFO: finally extract failed */
        @Override // androidx.work.impl.utils.CancelWorkRunnable
        @WorkerThread
        public void c() {
            WorkDatabase workDatabase = this.b.getWorkDatabase();
            workDatabase.beginTransaction();
            try {
                for (String str : workDatabase.workSpecDao().getUnfinishedWorkWithTag(this.c)) {
                    a(this.b, str);
                }
                workDatabase.setTransactionSuccessful();
                workDatabase.endTransaction();
                b(this.b);
            } catch (Throwable th) {
                workDatabase.endTransaction();
                throw th;
            }
        }
    }

    public class c extends CancelWorkRunnable {
        public final /* synthetic */ WorkManagerImpl b;
        public final /* synthetic */ String c;
        public final /* synthetic */ boolean d;

        public c(WorkManagerImpl workManagerImpl, String str, boolean z) {
            this.b = workManagerImpl;
            this.c = str;
            this.d = z;
        }

        /* JADX INFO: finally extract failed */
        @Override // androidx.work.impl.utils.CancelWorkRunnable
        @WorkerThread
        public void c() {
            WorkDatabase workDatabase = this.b.getWorkDatabase();
            workDatabase.beginTransaction();
            try {
                for (String str : workDatabase.workSpecDao().getUnfinishedWorkWithName(this.c)) {
                    a(this.b, str);
                }
                workDatabase.setTransactionSuccessful();
                workDatabase.endTransaction();
                if (this.d) {
                    b(this.b);
                }
            } catch (Throwable th) {
                workDatabase.endTransaction();
                throw th;
            }
        }
    }

    public class d extends CancelWorkRunnable {
        public final /* synthetic */ WorkManagerImpl b;

        public d(WorkManagerImpl workManagerImpl) {
            this.b = workManagerImpl;
        }

        @Override // androidx.work.impl.utils.CancelWorkRunnable
        @WorkerThread
        public void c() {
            WorkDatabase workDatabase = this.b.getWorkDatabase();
            workDatabase.beginTransaction();
            try {
                for (String str : workDatabase.workSpecDao().getAllUnfinishedWork()) {
                    a(this.b, str);
                }
                new PreferenceUtils(this.b.getWorkDatabase()).setLastCancelAllTimeMillis(System.currentTimeMillis());
                workDatabase.setTransactionSuccessful();
            } finally {
                workDatabase.endTransaction();
            }
        }
    }

    public static CancelWorkRunnable forAll(@NonNull WorkManagerImpl workManagerImpl) {
        return new d(workManagerImpl);
    }

    public static CancelWorkRunnable forId(@NonNull UUID uuid, @NonNull WorkManagerImpl workManagerImpl) {
        return new a(workManagerImpl, uuid);
    }

    public static CancelWorkRunnable forName(@NonNull String str, @NonNull WorkManagerImpl workManagerImpl, boolean z) {
        return new c(workManagerImpl, str, z);
    }

    public static CancelWorkRunnable forTag(@NonNull String str, @NonNull WorkManagerImpl workManagerImpl) {
        return new b(workManagerImpl, str);
    }

    public void a(WorkManagerImpl workManagerImpl, String str) {
        WorkDatabase workDatabase = workManagerImpl.getWorkDatabase();
        WorkSpecDao workSpecDao = workDatabase.workSpecDao();
        DependencyDao dependencyDao = workDatabase.dependencyDao();
        LinkedList linkedList = new LinkedList();
        linkedList.add(str);
        while (!linkedList.isEmpty()) {
            String str2 = (String) linkedList.remove();
            WorkInfo.State state = workSpecDao.getState(str2);
            if (!(state == WorkInfo.State.SUCCEEDED || state == WorkInfo.State.FAILED)) {
                workSpecDao.setState(WorkInfo.State.CANCELLED, str2);
            }
            linkedList.addAll(dependencyDao.getDependentWorkIds(str2));
        }
        workManagerImpl.getProcessor().stopAndCancelWork(str);
        for (Scheduler scheduler : workManagerImpl.getSchedulers()) {
            scheduler.cancel(str);
        }
    }

    public void b(WorkManagerImpl workManagerImpl) {
        Schedulers.schedule(workManagerImpl.getConfiguration(), workManagerImpl.getWorkDatabase(), workManagerImpl.getSchedulers());
    }

    public abstract void c();

    public Operation getOperation() {
        return this.a;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            c();
            this.a.setState(Operation.SUCCESS);
        } catch (Throwable th) {
            this.a.setState(new Operation.State.FAILURE(th));
        }
    }
}
