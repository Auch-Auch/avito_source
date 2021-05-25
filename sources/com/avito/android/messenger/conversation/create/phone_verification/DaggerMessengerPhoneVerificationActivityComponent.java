package com.avito.android.messenger.conversation.create.phone_verification;

import com.avito.android.ActivityIntentFactory;
import com.avito.android.analytics.Analytics;
import com.avito.android.di.CoreComponentDependencies;
import com.avito.android.messenger.conversation.create.phone_verification.MessengerPhoneVerificationActivityComponent;
import dagger.internal.Preconditions;
public final class DaggerMessengerPhoneVerificationActivityComponent implements MessengerPhoneVerificationActivityComponent {
    public final CoreComponentDependencies a;

    public static final class b implements MessengerPhoneVerificationActivityComponent.Builder {
        public CoreComponentDependencies a;

        public b(a aVar) {
        }

        @Override // com.avito.android.messenger.conversation.create.phone_verification.MessengerPhoneVerificationActivityComponent.Builder
        public MessengerPhoneVerificationActivityComponent build() {
            Preconditions.checkBuilderRequirement(this.a, CoreComponentDependencies.class);
            return new DaggerMessengerPhoneVerificationActivityComponent(this.a, null);
        }

        @Override // com.avito.android.messenger.conversation.create.phone_verification.MessengerPhoneVerificationActivityComponent.Builder
        public MessengerPhoneVerificationActivityComponent.Builder coreComponentDependencies(CoreComponentDependencies coreComponentDependencies) {
            this.a = (CoreComponentDependencies) Preconditions.checkNotNull(coreComponentDependencies);
            return this;
        }
    }

    public DaggerMessengerPhoneVerificationActivityComponent(CoreComponentDependencies coreComponentDependencies, a aVar) {
        this.a = coreComponentDependencies;
    }

    public static MessengerPhoneVerificationActivityComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.messenger.conversation.create.phone_verification.MessengerPhoneVerificationActivityComponent
    public void inject(MessengerPhoneVerificationActivity messengerPhoneVerificationActivity) {
        MessengerPhoneVerificationActivity_MembersInjector.injectActivityIntentFactory(messengerPhoneVerificationActivity, (ActivityIntentFactory) Preconditions.checkNotNullFromComponent(this.a.activityIntentFactory()));
        MessengerPhoneVerificationActivity_MembersInjector.injectAnalytics(messengerPhoneVerificationActivity, (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics()));
    }
}
