package a2.j.e.d.d.a;

import a2.j.e.d.d.a.u;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.report.model.Report;
import java.io.File;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
public class d0 implements Callable<Task<Void>> {
    public final /* synthetic */ Boolean a;
    public final /* synthetic */ u.e b;

    public d0(u.e eVar, Boolean bool) {
        this.b = eVar;
        this.a = bool;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.concurrent.Callable
    public Task<Void> call() throws Exception {
        List<Report> findReports = u.this.n.findReports();
        if (!this.a.booleanValue()) {
            Logger.getLogger().d("Reports are being deleted.");
            for (File file : u.this.p(j.a)) {
                file.delete();
            }
            u.this.n.deleteReports(findReports);
            u.this.t.b.deleteAllReports();
            u.this.x.trySetResult(null);
            return Tasks.forResult(null);
        }
        Logger.getLogger().d("Reports are being sent.");
        boolean booleanValue = this.a.booleanValue();
        u.this.c.grantDataCollectionPermission(booleanValue);
        u.e eVar = this.b;
        ExecutorService executorService = u.this.f.a;
        return eVar.a.onSuccessTask(executorService, new c0(this, findReports, booleanValue, executorService));
    }
}
