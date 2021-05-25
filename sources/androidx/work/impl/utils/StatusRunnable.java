package androidx.work.impl.utils;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.annotation.WorkerThread;
import androidx.work.WorkInfo;
import androidx.work.WorkQuery;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.futures.SettableFuture;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;
import java.util.UUID;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public abstract class StatusRunnable<T> implements Runnable {
    public final SettableFuture<T> a = SettableFuture.create();

    public class a extends StatusRunnable<List<WorkInfo>> {
        public final /* synthetic */ WorkManagerImpl b;
        public final /* synthetic */ List c;

        public a(WorkManagerImpl workManagerImpl, List list) {
            this.b = workManagerImpl;
            this.c = list;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // androidx.work.impl.utils.StatusRunnable
        public List<WorkInfo> a() {
            return WorkSpec.WORK_INFO_MAPPER.apply(this.b.getWorkDatabase().workSpecDao().getWorkStatusPojoForIds(this.c));
        }
    }

    public class b extends StatusRunnable<WorkInfo> {
        public final /* synthetic */ WorkManagerImpl b;
        public final /* synthetic */ UUID c;

        public b(WorkManagerImpl workManagerImpl, UUID uuid) {
            this.b = workManagerImpl;
            this.c = uuid;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // androidx.work.impl.utils.StatusRunnable
        public WorkInfo a() {
            WorkSpec.WorkInfoPojo workStatusPojoForId = this.b.getWorkDatabase().workSpecDao().getWorkStatusPojoForId(this.c.toString());
            if (workStatusPojoForId != null) {
                return workStatusPojoForId.toWorkInfo();
            }
            return null;
        }
    }

    public class c extends StatusRunnable<List<WorkInfo>> {
        public final /* synthetic */ WorkManagerImpl b;
        public final /* synthetic */ String c;

        public c(WorkManagerImpl workManagerImpl, String str) {
            this.b = workManagerImpl;
            this.c = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // androidx.work.impl.utils.StatusRunnable
        public List<WorkInfo> a() {
            return WorkSpec.WORK_INFO_MAPPER.apply(this.b.getWorkDatabase().workSpecDao().getWorkStatusPojoForTag(this.c));
        }
    }

    public class d extends StatusRunnable<List<WorkInfo>> {
        public final /* synthetic */ WorkManagerImpl b;
        public final /* synthetic */ String c;

        public d(WorkManagerImpl workManagerImpl, String str) {
            this.b = workManagerImpl;
            this.c = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // androidx.work.impl.utils.StatusRunnable
        public List<WorkInfo> a() {
            return WorkSpec.WORK_INFO_MAPPER.apply(this.b.getWorkDatabase().workSpecDao().getWorkStatusPojoForName(this.c));
        }
    }

    public class e extends StatusRunnable<List<WorkInfo>> {
        public final /* synthetic */ WorkManagerImpl b;
        public final /* synthetic */ WorkQuery c;

        public e(WorkManagerImpl workManagerImpl, WorkQuery workQuery) {
            this.b = workManagerImpl;
            this.c = workQuery;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // androidx.work.impl.utils.StatusRunnable
        public List<WorkInfo> a() {
            return WorkSpec.WORK_INFO_MAPPER.apply(this.b.getWorkDatabase().rawWorkInfoDao().getWorkInfoPojos(RawQueries.workQueryToRawQuery(this.c)));
        }
    }

    @NonNull
    public static StatusRunnable<List<WorkInfo>> forStringIds(@NonNull WorkManagerImpl workManagerImpl, @NonNull List<String> list) {
        return new a(workManagerImpl, list);
    }

    @NonNull
    public static StatusRunnable<List<WorkInfo>> forTag(@NonNull WorkManagerImpl workManagerImpl, @NonNull String str) {
        return new c(workManagerImpl, str);
    }

    @NonNull
    public static StatusRunnable<WorkInfo> forUUID(@NonNull WorkManagerImpl workManagerImpl, @NonNull UUID uuid) {
        return new b(workManagerImpl, uuid);
    }

    @NonNull
    public static StatusRunnable<List<WorkInfo>> forUniqueWork(@NonNull WorkManagerImpl workManagerImpl, @NonNull String str) {
        return new d(workManagerImpl, str);
    }

    @NonNull
    public static StatusRunnable<List<WorkInfo>> forWorkQuerySpec(@NonNull WorkManagerImpl workManagerImpl, @NonNull WorkQuery workQuery) {
        return new e(workManagerImpl, workQuery);
    }

    @WorkerThread
    public abstract T a();

    @NonNull
    public ListenableFuture<T> getFuture() {
        return this.a;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.a.set(a());
        } catch (Throwable th) {
            this.a.setException(th);
        }
    }
}
