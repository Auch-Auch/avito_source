package com.avito.android.location.di.module;

import android.app.Activity;
import com.avito.android.location.find.util.DetectLocationHelper;
import com.avito.android.ui.ActivityInteractor;
import com.avito.android.util.WeakHandler;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class FindLocationModule_ProvideDetectLocationHelper$user_location_releaseFactory implements Factory<DetectLocationHelper> {
    public final Provider<Activity> a;
    public final Provider<ActivityInteractor> b;
    public final Provider<WeakHandler> c;

    public FindLocationModule_ProvideDetectLocationHelper$user_location_releaseFactory(Provider<Activity> provider, Provider<ActivityInteractor> provider2, Provider<WeakHandler> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static FindLocationModule_ProvideDetectLocationHelper$user_location_releaseFactory create(Provider<Activity> provider, Provider<ActivityInteractor> provider2, Provider<WeakHandler> provider3) {
        return new FindLocationModule_ProvideDetectLocationHelper$user_location_releaseFactory(provider, provider2, provider3);
    }

    public static DetectLocationHelper provideDetectLocationHelper$user_location_release(Activity activity, ActivityInteractor activityInteractor, WeakHandler weakHandler) {
        return (DetectLocationHelper) Preconditions.checkNotNullFromProvides(FindLocationModule.provideDetectLocationHelper$user_location_release(activity, activityInteractor, weakHandler));
    }

    @Override // javax.inject.Provider
    public DetectLocationHelper get() {
        return provideDetectLocationHelper$user_location_release(this.a.get(), this.b.get(), this.c.get());
    }
}
