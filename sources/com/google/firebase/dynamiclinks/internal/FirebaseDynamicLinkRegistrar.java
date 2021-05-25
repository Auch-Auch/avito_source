package com.google.firebase.dynamiclinks.internal;

import a2.j.e.f.a.b;
import androidx.annotation.Keep;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.firebase.FirebaseApp;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.firebase.dynamiclinks.FirebaseDynamicLinks;
import java.util.Arrays;
import java.util.List;
@Keep
@KeepForSdk
public final class FirebaseDynamicLinkRegistrar implements ComponentRegistrar {
    @Override // com.google.firebase.components.ComponentRegistrar
    @Keep
    public final List<Component<?>> getComponents() {
        return Arrays.asList(Component.builder(FirebaseDynamicLinks.class).add(Dependency.required(FirebaseApp.class)).add(Dependency.optional(AnalyticsConnector.class)).factory(b.a).build());
    }
}
