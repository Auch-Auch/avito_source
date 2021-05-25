package a2.j.e.d.d.a;

import androidx.annotation.NonNull;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import com.google.firebase.crashlytics.internal.common.CrashlyticsCore;
import com.google.firebase.crashlytics.internal.common.DataTransportState;
import com.google.firebase.crashlytics.internal.report.ReportUploader;
import com.google.firebase.crashlytics.internal.report.network.CompositeCreateReportSpiCall;
import com.google.firebase.crashlytics.internal.report.network.DefaultCreateReportSpiCall;
import com.google.firebase.crashlytics.internal.report.network.NativeCreateReportSpiCall;
import com.google.firebase.crashlytics.internal.settings.model.AppSettingsData;
public class e0 implements ReportUploader.Provider {
    public final /* synthetic */ u a;

    public e0(u uVar) {
        this.a = uVar;
    }

    @Override // com.google.firebase.crashlytics.internal.report.ReportUploader.Provider
    public ReportUploader createReportUploader(@NonNull AppSettingsData appSettingsData) {
        String str = appSettingsData.reportsUrl;
        String str2 = appSettingsData.ndkReportsUrl;
        String str3 = appSettingsData.organizationId;
        u uVar = this.a;
        String stringsFileValue = CommonUtils.getStringsFileValue(uVar.b, "com.crashlytics.ApiEndpoint");
        CompositeCreateReportSpiCall compositeCreateReportSpiCall = new CompositeCreateReportSpiCall(new DefaultCreateReportSpiCall(stringsFileValue, str, uVar.g, CrashlyticsCore.getVersion()), new NativeCreateReportSpiCall(stringsFileValue, str2, uVar.g, CrashlyticsCore.getVersion()));
        String str4 = this.a.j.a;
        DataTransportState a3 = DataTransportState.a(appSettingsData);
        u uVar2 = this.a;
        return new ReportUploader(str3, str4, a3, uVar2.n, compositeCreateReportSpiCall, uVar2.o);
    }
}
