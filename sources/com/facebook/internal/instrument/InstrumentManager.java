package com.facebook.internal.instrument;

import androidx.annotation.RestrictTo;
import com.facebook.FacebookSdk;
import com.facebook.internal.FeatureManager;
import com.facebook.internal.instrument.crashreport.CrashHandler;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.facebook.internal.instrument.errorreport.ErrorReportHandler;
import com.facebook.internal.instrument.threadcheck.ThreadCheckHandler;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class InstrumentManager {

    public static class a implements FeatureManager.Callback {
        @Override // com.facebook.internal.FeatureManager.Callback
        public void onCompleted(boolean z) {
            if (z) {
                CrashHandler.enable();
                if (FeatureManager.isEnabled(FeatureManager.Feature.CrashShield)) {
                    ExceptionAnalyzer.enable();
                    CrashShieldHandler.enable();
                }
                if (FeatureManager.isEnabled(FeatureManager.Feature.ThreadCheck)) {
                    ThreadCheckHandler.enable();
                }
            }
        }
    }

    public static class b implements FeatureManager.Callback {
        @Override // com.facebook.internal.FeatureManager.Callback
        public void onCompleted(boolean z) {
            if (z) {
                ErrorReportHandler.enable();
            }
        }
    }

    public static void start() {
        if (FacebookSdk.getAutoLogAppEventsEnabled()) {
            FeatureManager.checkFeature(FeatureManager.Feature.CrashReport, new a());
            FeatureManager.checkFeature(FeatureManager.Feature.ErrorReport, new b());
        }
    }
}
