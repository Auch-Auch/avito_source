package com.avito.android;

import android.app.Application;
import android.content.Intent;
import com.avito.android.PublicProfileIntentFactory;
import com.avito.android.analytics.provider.clickstream.TreeClickStreamParent;
import com.avito.android.analytics.screens.PublicProfileScreen;
import com.avito.android.analytics.screens.tracker.ScreenTransfer;
import com.avito.android.bottom_navigation.NavigationTab;
import com.avito.android.extended_profile.ExtendedProfileActivityKt;
import com.avito.android.extended_profile.ExtendedProfileArguments;
import com.avito.android.extended_profile.ExtendedProfileFragmentData;
import com.avito.android.navigation.NavigationTabProvider;
import com.avito.android.public_profile.PublicProfileActivityKt;
import com.avito.android.public_profile.PublicProfileArguments;
import com.avito.android.public_profile.PublicProfileFragmentData;
import com.avito.android.public_profile.remote.model.DefaultPublicUserProfile;
import com.avito.android.public_profile.remote.model.ExtendedPublicUserProfile;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.screen_opener.ProfileScreenResolverActivityKt;
import com.avito.android.screen_opener.ProfileScreenResolverArguments;
import com.avito.android.screen_opener.ProfileScreenResolverFragmentData;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B)\b\u0007\u0012\u0006\u0010\"\u001a\u00020\u001f\u0012\u0006\u0010\u001e\u001a\u00020\u001b\u0012\u0006\u0010\u001a\u001a\u00020\u0017\u0012\u0006\u0010\u0016\u001a\u00020\u0013¢\u0006\u0004\b#\u0010$J?\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\f\u0010\rJ=\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u000e2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J+\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010!¨\u0006%"}, d2 = {"Lcom/avito/android/PublicProfileIntentFactoryImpl;", "Lcom/avito/android/PublicProfileIntentFactory;", "", "userKey", "Lcom/avito/android/public_profile/remote/model/DefaultPublicUserProfile;", "profile", "contextId", "Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;", "treeParent", "Lcom/avito/android/analytics/screens/tracker/ScreenTransfer;", "screenTransfer", "Landroid/content/Intent;", "createPublicProfileIntent", "(Ljava/lang/String;Lcom/avito/android/public_profile/remote/model/DefaultPublicUserProfile;Ljava/lang/String;Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;Lcom/avito/android/analytics/screens/tracker/ScreenTransfer;)Landroid/content/Intent;", "Lcom/avito/android/public_profile/remote/model/ExtendedPublicUserProfile;", "createExtendedProfileIntent", "(Ljava/lang/String;Lcom/avito/android/public_profile/remote/model/ExtendedPublicUserProfile;Ljava/lang/String;Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;Lcom/avito/android/analytics/screens/tracker/ScreenTransfer;)Landroid/content/Intent;", "createProfileScreenResolverIntent", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;)Landroid/content/Intent;", "Lcom/avito/android/Features;", "d", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/navigation/NavigationTabProvider;", "c", "Lcom/avito/android/navigation/NavigationTabProvider;", "tabProvider", "Lcom/avito/android/CoreActivityIntentFactory;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/CoreActivityIntentFactory;", "coreActivityIntentFactory", "Landroid/app/Application;", AuthSource.SEND_ABUSE, "Landroid/app/Application;", "context", "<init>", "(Landroid/app/Application;Lcom/avito/android/CoreActivityIntentFactory;Lcom/avito/android/navigation/NavigationTabProvider;Lcom/avito/android/Features;)V", "public-profile_release"}, k = 1, mv = {1, 4, 2})
public final class PublicProfileIntentFactoryImpl implements PublicProfileIntentFactory {
    public final Application a;
    public final CoreActivityIntentFactory b;
    public final NavigationTabProvider c;
    public final Features d;

    @Inject
    public PublicProfileIntentFactoryImpl(@NotNull Application application, @NotNull CoreActivityIntentFactory coreActivityIntentFactory, @NotNull NavigationTabProvider navigationTabProvider, @NotNull Features features) {
        Intrinsics.checkNotNullParameter(application, "context");
        Intrinsics.checkNotNullParameter(coreActivityIntentFactory, "coreActivityIntentFactory");
        Intrinsics.checkNotNullParameter(navigationTabProvider, "tabProvider");
        Intrinsics.checkNotNullParameter(features, "features");
        this.a = application;
        this.b = coreActivityIntentFactory;
        this.c = navigationTabProvider;
        this.d = features;
    }

    @Override // com.avito.android.PublicProfileIntentFactory
    @NotNull
    public Intent createExtendedProfileIntent(@NotNull String str, @NotNull ExtendedPublicUserProfile extendedPublicUserProfile, @Nullable String str2, @Nullable TreeClickStreamParent treeClickStreamParent, @Nullable ScreenTransfer screenTransfer) {
        Intrinsics.checkNotNullParameter(str, "userKey");
        Intrinsics.checkNotNullParameter(extendedPublicUserProfile, "profile");
        NavigationTab currentTab = this.c.currentTab();
        ExtendedProfileArguments extendedProfileArguments = new ExtendedProfileArguments(str, extendedPublicUserProfile, str2, treeClickStreamParent, screenTransfer);
        if (currentTab == null) {
            return ExtendedProfileActivityKt.createExtendedProfileActivityIntent(this.a, extendedProfileArguments);
        }
        return this.b.mainScreenWithTab(new ExtendedProfileFragmentData(extendedProfileArguments, currentTab));
    }

    @Override // com.avito.android.PublicProfileIntentFactory
    @NotNull
    public Intent createProfileScreenResolverIntent(@NotNull String str, @Nullable String str2, @Nullable TreeClickStreamParent treeClickStreamParent) {
        Intrinsics.checkNotNullParameter(str, "userKey");
        NavigationTab currentTab = this.c.currentTab();
        if (!this.d.getExtendedProfile().invoke().booleanValue()) {
            return PublicProfileIntentFactory.DefaultImpls.createPublicProfileIntent$default(this, str, null, str2, treeClickStreamParent, null, 16, null);
        }
        if (currentTab == null) {
            return ProfileScreenResolverActivityKt.createProfileScreenResolverActivityIntent(this.a, str, str2, treeClickStreamParent);
        }
        return this.b.mainScreenWithTab(new ProfileScreenResolverFragmentData(new ProfileScreenResolverArguments(str, str2, treeClickStreamParent), currentTab));
    }

    @Override // com.avito.android.PublicProfileIntentFactory
    @NotNull
    public Intent createPublicProfileIntent(@NotNull String str, @Nullable DefaultPublicUserProfile defaultPublicUserProfile, @Nullable String str2, @Nullable TreeClickStreamParent treeClickStreamParent, @Nullable ScreenTransfer screenTransfer) {
        Intrinsics.checkNotNullParameter(str, "userKey");
        PublicProfileArguments publicProfileArguments = new PublicProfileArguments(defaultPublicUserProfile, str, PublicProfileScreen.INSTANCE, false, str2, treeClickStreamParent, screenTransfer);
        NavigationTab currentTab = this.c.currentTab();
        if (!this.d.getPublicProfileWithoutActivity().invoke().booleanValue() || currentTab == null) {
            return PublicProfileActivityKt.createPublicProfileActivityIntent(this.a, publicProfileArguments);
        }
        return this.b.mainScreenWithTab(new PublicProfileFragmentData(publicProfileArguments, currentTab));
    }
}
