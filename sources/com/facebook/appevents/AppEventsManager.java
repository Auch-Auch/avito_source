package com.facebook.appevents;

import androidx.annotation.RestrictTo;
import com.facebook.appevents.aam.MetadataIndexer;
import com.facebook.appevents.eventdeactivation.EventDeactivationManager;
import com.facebook.appevents.ml.ModelManager;
import com.facebook.appevents.restrictivedatafilter.RestrictiveDataManager;
import com.facebook.internal.FeatureManager;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.instrument.crashshield.AutoHandleExceptions;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
@AutoHandleExceptions
public class AppEventsManager {

    public static class a implements FetchedAppSettingsManager.FetchedAppSettingsCallback {

        /* renamed from: com.facebook.appevents.AppEventsManager$a$a  reason: collision with other inner class name */
        public class C0178a implements FeatureManager.Callback {
            public C0178a(a aVar) {
            }

            @Override // com.facebook.internal.FeatureManager.Callback
            public void onCompleted(boolean z) {
                if (z) {
                    MetadataIndexer.enable();
                }
            }
        }

        public class b implements FeatureManager.Callback {
            public b(a aVar) {
            }

            @Override // com.facebook.internal.FeatureManager.Callback
            public void onCompleted(boolean z) {
                if (z) {
                    RestrictiveDataManager.enable();
                }
            }
        }

        public class c implements FeatureManager.Callback {
            public c(a aVar) {
            }

            @Override // com.facebook.internal.FeatureManager.Callback
            public void onCompleted(boolean z) {
                if (z) {
                    ModelManager.enable();
                }
            }
        }

        public class d implements FeatureManager.Callback {
            public d(a aVar) {
            }

            @Override // com.facebook.internal.FeatureManager.Callback
            public void onCompleted(boolean z) {
                if (z) {
                    EventDeactivationManager.enable();
                }
            }
        }

        @Override // com.facebook.internal.FetchedAppSettingsManager.FetchedAppSettingsCallback
        public void onError() {
        }

        @Override // com.facebook.internal.FetchedAppSettingsManager.FetchedAppSettingsCallback
        public void onSuccess(FetchedAppSettings fetchedAppSettings) {
            FeatureManager.checkFeature(FeatureManager.Feature.AAM, new C0178a(this));
            FeatureManager.checkFeature(FeatureManager.Feature.RestrictiveDataFiltering, new b(this));
            FeatureManager.checkFeature(FeatureManager.Feature.PrivacyProtection, new c(this));
            FeatureManager.checkFeature(FeatureManager.Feature.EventDeactivation, new d(this));
        }
    }

    public static void start() {
        FetchedAppSettingsManager.getAppSettingsAsync(new a());
    }
}
