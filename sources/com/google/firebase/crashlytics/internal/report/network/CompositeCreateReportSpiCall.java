package com.google.firebase.crashlytics.internal.report.network;

import com.google.firebase.crashlytics.internal.report.model.CreateReportRequest;
public class CompositeCreateReportSpiCall implements CreateReportSpiCall {
    public final DefaultCreateReportSpiCall a;
    public final NativeCreateReportSpiCall b;

    public CompositeCreateReportSpiCall(DefaultCreateReportSpiCall defaultCreateReportSpiCall, NativeCreateReportSpiCall nativeCreateReportSpiCall) {
        this.a = defaultCreateReportSpiCall;
        this.b = nativeCreateReportSpiCall;
    }

    @Override // com.google.firebase.crashlytics.internal.report.network.CreateReportSpiCall
    public boolean invoke(CreateReportRequest createReportRequest, boolean z) {
        int ordinal = createReportRequest.report.getType().ordinal();
        if (ordinal == 0) {
            this.a.invoke(createReportRequest, z);
            return true;
        } else if (ordinal != 1) {
            return false;
        } else {
            this.b.invoke(createReportRequest, z);
            return true;
        }
    }
}
