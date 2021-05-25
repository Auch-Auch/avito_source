package a2.j.e.d.d.a;

import a2.j.e.d.d.a.u;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.common.DataTransportState;
import com.google.firebase.crashlytics.internal.report.ReportUploader;
import com.google.firebase.crashlytics.internal.report.model.SessionReport;
import com.google.firebase.crashlytics.internal.settings.model.AppSettingsData;
import java.io.File;
import java.util.concurrent.Executor;
public class z implements SuccessContinuation<AppSettingsData, Void> {
    public final /* synthetic */ Executor a;
    public final /* synthetic */ a0 b;

    public z(a0 a0Var, Executor executor) {
        this.b = a0Var;
        this.a = executor;
    }

    /* Return type fixed from 'com.google.android.gms.tasks.Task' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.google.android.gms.tasks.SuccessContinuation
    @NonNull
    public Task<Void> then(@Nullable AppSettingsData appSettingsData) throws Exception {
        AppSettingsData appSettingsData2 = appSettingsData;
        if (appSettingsData2 == null) {
            Logger.getLogger().w("Received null app settings, cannot send reports at crash time.");
            return Tasks.forResult(null);
        }
        u uVar = this.b.e;
        Context context = uVar.b;
        ReportUploader createReportUploader = uVar.k.createReportUploader(appSettingsData2);
        File[] o = uVar.o();
        for (File file : o) {
            u.c(appSettingsData2.organizationId, file);
            SessionReport sessionReport = new SessionReport(file, u.E);
            f fVar = uVar.f;
            fVar.b(new g(fVar, new u.m(context, sessionReport, createReportUploader, true)));
        }
        return Tasks.whenAll(u.a(this.b.e), this.b.e.t.b(this.a, DataTransportState.a(appSettingsData2)));
    }
}
