package com.avito.android.screen_opener.di;

import android.content.res.Resources;
import com.avito.android.analytics.screens.tracker.UnknownScreenTracker;
import com.avito.android.di.PerFragment;
import com.avito.android.error_helper.di.ErrorHelperModule;
import com.avito.android.screen_opener.ProfileScreenResolverInteractor;
import com.avito.android.screen_opener.ProfileScreenResolverInteractorImpl;
import com.avito.android.screen_opener.ProfileScreenResolverPresenter;
import com.avito.android.screen_opener.ProfileScreenResolverPresenterImpl;
import com.avito.android.util.ErrorFormatterImpl;
import com.avito.android.util.Formatter;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.inject.Qualifier;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\t\bÇ\u0002\u0018\u00002\u00020\u0001:\u0003\u000b\f\rB\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\u000e"}, d2 = {"Lcom/avito/android/screen_opener/di/ProfileScreenResolverFragmentModule;", "", "Landroid/content/res/Resources;", "resources", "Lcom/avito/android/util/Formatter;", "", "providesErrorFormatter$public_profile_release", "(Landroid/content/res/Resources;)Lcom/avito/android/util/Formatter;", "providesErrorFormatter", "<init>", "()V", "ContextId", "Declarations", "UserKey", "public-profile_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {Declarations.class, ErrorHelperModule.class})
public final class ProfileScreenResolverFragmentModule {
    @NotNull
    public static final ProfileScreenResolverFragmentModule INSTANCE = new ProfileScreenResolverFragmentModule();

    @Qualifier
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/screen_opener/di/ProfileScreenResolverFragmentModule$ContextId;", "", "<init>", "()V", "public-profile_release"}, k = 1, mv = {1, 4, 2})
    @Retention(RetentionPolicy.RUNTIME)
    @kotlin.annotation.Retention
    public @interface ContextId {
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0007H'¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH'¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/screen_opener/di/ProfileScreenResolverFragmentModule$Declarations;", "", "Lcom/avito/android/screen_opener/ProfileScreenResolverPresenterImpl;", "interactor", "Lcom/avito/android/screen_opener/ProfileScreenResolverPresenter;", "bindPresenter", "(Lcom/avito/android/screen_opener/ProfileScreenResolverPresenterImpl;)Lcom/avito/android/screen_opener/ProfileScreenResolverPresenter;", "Lcom/avito/android/screen_opener/ProfileScreenResolverInteractorImpl;", "Lcom/avito/android/screen_opener/ProfileScreenResolverInteractor;", "bindInteractor", "(Lcom/avito/android/screen_opener/ProfileScreenResolverInteractorImpl;)Lcom/avito/android/screen_opener/ProfileScreenResolverInteractor;", "Lcom/avito/android/analytics/screens/tracker/UnknownScreenTracker$Impl;", "resolver", "Lcom/avito/android/analytics/screens/tracker/UnknownScreenTracker;", "bindScreenTracker", "(Lcom/avito/android/analytics/screens/tracker/UnknownScreenTracker$Impl;)Lcom/avito/android/analytics/screens/tracker/UnknownScreenTracker;", "public-profile_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @PerFragment
        @Binds
        @NotNull
        ProfileScreenResolverInteractor bindInteractor(@NotNull ProfileScreenResolverInteractorImpl profileScreenResolverInteractorImpl);

        @PerFragment
        @Binds
        @NotNull
        ProfileScreenResolverPresenter bindPresenter(@NotNull ProfileScreenResolverPresenterImpl profileScreenResolverPresenterImpl);

        @PerFragment
        @Binds
        @NotNull
        UnknownScreenTracker bindScreenTracker(@NotNull UnknownScreenTracker.Impl impl);
    }

    @Qualifier
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/screen_opener/di/ProfileScreenResolverFragmentModule$UserKey;", "", "<init>", "()V", "public-profile_release"}, k = 1, mv = {1, 4, 2})
    @Retention(RetentionPolicy.RUNTIME)
    @kotlin.annotation.Retention
    public @interface UserKey {
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final Formatter<Throwable> providesErrorFormatter$public_profile_release(@NotNull Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        return new ErrorFormatterImpl(resources);
    }
}
