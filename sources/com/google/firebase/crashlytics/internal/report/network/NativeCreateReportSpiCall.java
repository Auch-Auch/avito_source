package com.google.firebase.crashlytics.internal.report.network;

import a2.b.a.a.a;
import com.avito.android.util.preferences.SessionContract;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.common.AbstractSpiCall;
import com.google.firebase.crashlytics.internal.common.CrashlyticsCore;
import com.google.firebase.crashlytics.internal.common.ResponseParser;
import com.google.firebase.crashlytics.internal.network.HttpMethod;
import com.google.firebase.crashlytics.internal.network.HttpRequest;
import com.google.firebase.crashlytics.internal.network.HttpRequestFactory;
import com.google.firebase.crashlytics.internal.report.model.CreateReportRequest;
import com.google.firebase.crashlytics.internal.report.model.Report;
import java.io.File;
import java.io.IOException;
import net.gotev.uploadservice.extensions.StringExtensionsKt;
public class NativeCreateReportSpiCall extends AbstractSpiCall implements CreateReportSpiCall {
    public final String f;

    public NativeCreateReportSpiCall(String str, String str2, HttpRequestFactory httpRequestFactory, String str3) {
        super(str, str2, httpRequestFactory, HttpMethod.POST);
        this.f = str3;
    }

    @Override // com.google.firebase.crashlytics.internal.report.network.CreateReportSpiCall
    public boolean invoke(CreateReportRequest createReportRequest, boolean z) {
        if (z) {
            HttpRequest httpRequest = getHttpRequest();
            String str = createReportRequest.googleAppId;
            StringBuilder L = a.L(AbstractSpiCall.CRASHLYTICS_USER_AGENT);
            L.append(CrashlyticsCore.getVersion());
            httpRequest.header("User-Agent", L.toString()).header(AbstractSpiCall.HEADER_CLIENT_TYPE, "android").header(AbstractSpiCall.HEADER_CLIENT_VERSION, this.f).header(AbstractSpiCall.HEADER_GOOGLE_APP_ID, str);
            String str2 = createReportRequest.organizationId;
            Report report = createReportRequest.report;
            if (str2 != null) {
                httpRequest.part(a2.j.e.d.d.h.d.a.ORGANIZATION_ID_PARAM, str2);
            }
            httpRequest.part("report_id", report.getIdentifier());
            File[] files = report.getFiles();
            for (File file : files) {
                if (file.getName().equals("minidump")) {
                    httpRequest.part("minidump_file", file.getName(), StringExtensionsKt.APPLICATION_OCTET_STREAM, file);
                } else if (file.getName().equals("metadata")) {
                    httpRequest.part("crash_meta_file", file.getName(), StringExtensionsKt.APPLICATION_OCTET_STREAM, file);
                } else if (file.getName().equals("binaryImages")) {
                    httpRequest.part("binary_images_file", file.getName(), StringExtensionsKt.APPLICATION_OCTET_STREAM, file);
                } else if (file.getName().equals(SessionContract.SESSION)) {
                    httpRequest.part("session_meta_file", file.getName(), StringExtensionsKt.APPLICATION_OCTET_STREAM, file);
                } else if (file.getName().equals("app")) {
                    httpRequest.part("app_meta_file", file.getName(), StringExtensionsKt.APPLICATION_OCTET_STREAM, file);
                } else if (file.getName().equals("device")) {
                    httpRequest.part("device_meta_file", file.getName(), StringExtensionsKt.APPLICATION_OCTET_STREAM, file);
                } else if (file.getName().equals("os")) {
                    httpRequest.part("os_meta_file", file.getName(), StringExtensionsKt.APPLICATION_OCTET_STREAM, file);
                } else if (file.getName().equals("user")) {
                    httpRequest.part("user_meta_file", file.getName(), StringExtensionsKt.APPLICATION_OCTET_STREAM, file);
                } else if (file.getName().equals("logs")) {
                    httpRequest.part("logs_file", file.getName(), StringExtensionsKt.APPLICATION_OCTET_STREAM, file);
                } else if (file.getName().equals("keys")) {
                    httpRequest.part("keys_file", file.getName(), StringExtensionsKt.APPLICATION_OCTET_STREAM, file);
                }
            }
            Logger logger = Logger.getLogger();
            StringBuilder L2 = a.L("Sending report to: ");
            L2.append(getUrl());
            logger.d(L2.toString());
            try {
                int code = httpRequest.execute().code();
                Logger.getLogger().d("Result was: " + code);
                if (ResponseParser.parse(code) == 0) {
                    return true;
                }
                return false;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            throw new RuntimeException("An invalid data collection token was used.");
        }
    }
}
