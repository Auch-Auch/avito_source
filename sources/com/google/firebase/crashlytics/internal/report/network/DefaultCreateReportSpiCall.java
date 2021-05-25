package com.google.firebase.crashlytics.internal.report.network;

import a2.b.a.a.a;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.common.AbstractSpiCall;
import com.google.firebase.crashlytics.internal.common.ResponseParser;
import com.google.firebase.crashlytics.internal.network.HttpMethod;
import com.google.firebase.crashlytics.internal.network.HttpRequest;
import com.google.firebase.crashlytics.internal.network.HttpRequestFactory;
import com.google.firebase.crashlytics.internal.network.HttpResponse;
import com.google.firebase.crashlytics.internal.report.model.CreateReportRequest;
import com.google.firebase.crashlytics.internal.report.model.Report;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import net.gotev.uploadservice.extensions.StringExtensionsKt;
public class DefaultCreateReportSpiCall extends AbstractSpiCall implements CreateReportSpiCall {
    public final String f;

    public DefaultCreateReportSpiCall(String str, String str2, HttpRequestFactory httpRequestFactory, String str3) {
        super(str, str2, httpRequestFactory, HttpMethod.POST);
        this.f = str3;
    }

    @Override // com.google.firebase.crashlytics.internal.report.network.CreateReportSpiCall
    public boolean invoke(CreateReportRequest createReportRequest, boolean z) {
        HttpRequest httpRequest;
        if (z) {
            HttpRequest header = getHttpRequest().header(AbstractSpiCall.HEADER_GOOGLE_APP_ID, createReportRequest.googleAppId).header(AbstractSpiCall.HEADER_CLIENT_TYPE, "android").header(AbstractSpiCall.HEADER_CLIENT_VERSION, this.f);
            for (Map.Entry<String, String> entry : createReportRequest.report.getCustomHeaders().entrySet()) {
                header = header.header(entry);
            }
            Report report = createReportRequest.report;
            HttpRequest part = header.part("report[identifier]", report.getIdentifier());
            if (report.getFiles().length == 1) {
                Logger logger = Logger.getLogger();
                StringBuilder L = a.L("Adding single file ");
                L.append(report.getFileName());
                L.append(" to report ");
                L.append(report.getIdentifier());
                logger.d(L.toString());
                httpRequest = part.part("report[file]", report.getFileName(), StringExtensionsKt.APPLICATION_OCTET_STREAM, report.getFile());
            } else {
                File[] files = report.getFiles();
                int i = 0;
                for (File file : files) {
                    Logger logger2 = Logger.getLogger();
                    StringBuilder L2 = a.L("Adding file ");
                    L2.append(file.getName());
                    L2.append(" to report ");
                    L2.append(report.getIdentifier());
                    logger2.d(L2.toString());
                    part = part.part("report[file" + i + "]", file.getName(), StringExtensionsKt.APPLICATION_OCTET_STREAM, file);
                    i++;
                }
                httpRequest = part;
            }
            Logger logger3 = Logger.getLogger();
            StringBuilder L3 = a.L("Sending report to: ");
            L3.append(getUrl());
            logger3.d(L3.toString());
            try {
                HttpResponse execute = httpRequest.execute();
                int code = execute.code();
                Logger.getLogger().d("Create report request ID: " + execute.header(AbstractSpiCall.HEADER_REQUEST_ID));
                Logger.getLogger().d("Result was: " + code);
                if (ResponseParser.parse(code) == 0) {
                    return true;
                }
                return false;
            } catch (IOException e) {
                Logger.getLogger().e("Create report HTTP request failed.", e);
                throw new RuntimeException(e);
            }
        } else {
            throw new RuntimeException("An invalid data collection token was used.");
        }
    }
}
