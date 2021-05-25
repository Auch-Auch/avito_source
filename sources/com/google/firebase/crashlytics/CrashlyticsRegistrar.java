package com.google.firebase.crashlytics;

import com.google.firebase.FirebaseApp;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.firebase.crashlytics.CrashlyticsRegistrar;
import com.google.firebase.crashlytics.internal.CrashlyticsNativeComponent;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.platforminfo.LibraryVersionComponent;
import java.util.Arrays;
import java.util.List;
public class CrashlyticsRegistrar implements ComponentRegistrar {
    @Override // com.google.firebase.components.ComponentRegistrar
    public List<Component<?>> getComponents() {
        return Arrays.asList(Component.builder(FirebaseCrashlytics.class).add(Dependency.required(FirebaseApp.class)).add(Dependency.required(FirebaseInstallationsApi.class)).add(Dependency.optional(AnalyticsConnector.class)).add(Dependency.optional(CrashlyticsNativeComponent.class)).factory(new ComponentFactory(this) { // from class: a2.j.e.d.b
            public final CrashlyticsRegistrar a;

            {
                this.a = r1;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r3v9, types: [com.google.firebase.crashlytics.internal.analytics.CrashlyticsOriginAnalyticsEventLogger] */
            /* JADX WARN: Type inference failed for: r8v7, types: [com.google.firebase.crashlytics.internal.analytics.AnalyticsEventReceiver, com.google.firebase.crashlytics.internal.analytics.BlockingAnalyticsEventLogger] */
            /* JADX WARNING: Unknown variable types count: 2 */
            @Override // com.google.firebase.components.ComponentFactory
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public java.lang.Object create(com.google.firebase.components.ComponentContainer r19) {
                /*
                // Method dump skipped, instructions count: 263
                */
                throw new UnsupportedOperationException("Method not decompiled: a2.j.e.d.b.create(com.google.firebase.components.ComponentContainer):java.lang.Object");
            }
        }).eagerInDefaultApp().build(), LibraryVersionComponent.create("fire-cls", BuildConfig.VERSION_NAME));
    }
}
