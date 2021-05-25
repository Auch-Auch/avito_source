package com.avito.android.di.module;

import com.avito.android.ActivityIntentFactory;
import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.android.calls_shared.CallUuidProvider;
import com.avito.android.deep_linking.DeepLinkContainerIntentFactory;
import com.avito.android.deep_linking.DeepLinkContainerIntentFactoryImpl;
import com.avito.android.deep_linking.DeepLinkFactory;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.deep_linking.DeepLinkIntentFactoryImpl;
import com.avito.android.deep_linking.links.UTMLinkConverter;
import com.avito.android.deep_linking.links.UTMLinkConverterImpl;
import com.avito.android.navigation.NavigationTabProvider;
import com.avito.android.util.BuildInfo;
import com.avito.android.util.ImplicitIntentFactory;
import dagger.Module;
import dagger.Provides;
import dagger.Reusable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001e\u0010\u001fJ'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\nJ?\u0010\u0016\u001a\u00020\u00152\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0007¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u0015H\u0007¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u000fH\u0007¢\u0006\u0004\b\u001c\u0010\u001d¨\u0006 "}, d2 = {"Lcom/avito/android/di/module/DeepLinkModule;", "", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/util/BuildInfo;", "buildInfo", "Lcom/avito/android/deep_linking/DeepLinkFactory;", "provideDeepLinkFactory", "(Lcom/avito/android/Features;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/util/BuildInfo;)Lcom/avito/android/deep_linking/DeepLinkFactory;", "Lcom/avito/android/ActivityIntentFactory;", "activityIntentFactory", "Lcom/avito/android/util/ImplicitIntentFactory;", "implicitIntentFactory", "Lcom/avito/android/deep_linking/links/UTMLinkConverter;", "utmLinkConverter", "Lcom/avito/android/navigation/NavigationTabProvider;", "tabProvider", "Lcom/avito/android/calls_shared/CallUuidProvider;", "callUuidProvider", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "provideDeepLinkIntentFactory", "(Lcom/avito/android/ActivityIntentFactory;Lcom/avito/android/util/ImplicitIntentFactory;Lcom/avito/android/Features;Lcom/avito/android/deep_linking/links/UTMLinkConverter;Lcom/avito/android/navigation/NavigationTabProvider;Lcom/avito/android/calls_shared/CallUuidProvider;)Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "deepLinkIntentFactory", "Lcom/avito/android/deep_linking/DeepLinkContainerIntentFactory;", "provideDeepLinkContainerIntentFactory", "(Lcom/avito/android/deep_linking/DeepLinkIntentFactory;)Lcom/avito/android/deep_linking/DeepLinkContainerIntentFactory;", "provideUmlLinkConverter", "()Lcom/avito/android/deep_linking/links/UTMLinkConverter;", "<init>", "()V", "core_release"}, k = 1, mv = {1, 4, 2})
@Module
public final class DeepLinkModule {
    @Provides
    @Reusable
    @NotNull
    public final DeepLinkContainerIntentFactory provideDeepLinkContainerIntentFactory(@NotNull DeepLinkIntentFactory deepLinkIntentFactory) {
        Intrinsics.checkNotNullParameter(deepLinkIntentFactory, "deepLinkIntentFactory");
        return new DeepLinkContainerIntentFactoryImpl(deepLinkIntentFactory);
    }

    @Provides
    @Reusable
    @NotNull
    public final DeepLinkFactory provideDeepLinkFactory(@NotNull Features features, @NotNull Analytics analytics, @NotNull BuildInfo buildInfo) {
        Intrinsics.checkNotNullParameter(features, "features");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(buildInfo, "buildInfo");
        return new DeepLinkFactory(features, analytics, buildInfo);
    }

    @Provides
    @Reusable
    @NotNull
    public final DeepLinkIntentFactory provideDeepLinkIntentFactory(@NotNull ActivityIntentFactory activityIntentFactory, @NotNull ImplicitIntentFactory implicitIntentFactory, @NotNull Features features, @NotNull UTMLinkConverter uTMLinkConverter, @NotNull NavigationTabProvider navigationTabProvider, @NotNull CallUuidProvider callUuidProvider) {
        Intrinsics.checkNotNullParameter(activityIntentFactory, "activityIntentFactory");
        Intrinsics.checkNotNullParameter(implicitIntentFactory, "implicitIntentFactory");
        Intrinsics.checkNotNullParameter(features, "features");
        Intrinsics.checkNotNullParameter(uTMLinkConverter, "utmLinkConverter");
        Intrinsics.checkNotNullParameter(navigationTabProvider, "tabProvider");
        Intrinsics.checkNotNullParameter(callUuidProvider, "callUuidProvider");
        return new DeepLinkIntentFactoryImpl(activityIntentFactory, implicitIntentFactory, features, navigationTabProvider, uTMLinkConverter, callUuidProvider);
    }

    @Provides
    @NotNull
    public final UTMLinkConverter provideUmlLinkConverter() {
        return new UTMLinkConverterImpl();
    }
}
