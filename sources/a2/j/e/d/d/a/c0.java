package a2.j.e.d.d.a;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.common.DataTransportState;
import com.google.firebase.crashlytics.internal.report.model.Report;
import com.google.firebase.crashlytics.internal.settings.model.AppSettingsData;
import java.util.List;
import java.util.concurrent.Executor;
public class c0 implements SuccessContinuation<AppSettingsData, Void> {
    public final /* synthetic */ List a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ Executor c;
    public final /* synthetic */ d0 d;

    public c0(d0 d0Var, List list, boolean z, Executor executor) {
        this.d = d0Var;
        this.a = list;
        this.b = z;
        this.c = executor;
    }

    /* Return type fixed from 'com.google.android.gms.tasks.Task' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.google.android.gms.tasks.SuccessContinuation
    @NonNull
    public Task<Void> then(@Nullable AppSettingsData appSettingsData) throws Exception {
        AppSettingsData appSettingsData2 = appSettingsData;
        if (appSettingsData2 == null) {
            Logger.getLogger().w("Received null app settings, cannot send reports during app startup.");
            return Tasks.forResult(null);
        }
        for (Report report : this.a) {
            if (report.getType() == Report.Type.JAVA) {
                u.c(appSettingsData2.organizationId, report.getFile());
            }
        }
        u.a(u.this);
        u.this.k.createReportUploader(appSettingsData2).uploadReportsAsync(this.a, this.b, this.d.b.b);
        u.this.t.b(this.c, DataTransportState.a(appSettingsData2));
        u.this.x.trySetResult(null);
        return Tasks.forResult(null);
    }
}
