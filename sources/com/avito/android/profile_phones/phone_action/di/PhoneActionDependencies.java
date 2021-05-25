package com.avito.android.profile_phones.phone_action.di;

import com.avito.android.ActivityIntentFactory;
import com.avito.android.analytics.Analytics;
import com.avito.android.di.ComponentDependencies;
import com.avito.android.remote.ProfileApi;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.util.SchedulersFactory3;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/avito/android/profile_phones/phone_action/di/PhoneActionDependencies;", "Lcom/avito/android/di/ComponentDependencies;", "Lcom/avito/android/remote/ProfileApi;", "profileApi", "()Lcom/avito/android/remote/ProfileApi;", "Lcom/avito/android/util/SchedulersFactory3;", "schedulersFactory3", "()Lcom/avito/android/util/SchedulersFactory3;", "Lcom/avito/android/analytics/Analytics;", "analytics", "()Lcom/avito/android/analytics/Analytics;", "Lcom/avito/android/ActivityIntentFactory;", "intentFactory", "()Lcom/avito/android/ActivityIntentFactory;", "Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", "throwableConverter", "()Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", "profile-phones_release"}, k = 1, mv = {1, 4, 2})
public interface PhoneActionDependencies extends ComponentDependencies {
    @NotNull
    Analytics analytics();

    @NotNull
    ActivityIntentFactory intentFactory();

    @Override // com.avito.android.profile.tfa.settings.di.TfaSettingsDependencies
    @NotNull
    ProfileApi profileApi();

    @Override // com.avito.android.profile_phones.phones_list.actions.di.PhoneActionsDependencies
    @NotNull
    SchedulersFactory3 schedulersFactory3();

    @NotNull
    TypedErrorThrowableConverter throwableConverter();
}
