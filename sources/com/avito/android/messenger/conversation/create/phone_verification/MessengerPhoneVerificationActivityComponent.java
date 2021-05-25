package com.avito.android.messenger.conversation.create.phone_verification;

import com.avito.android.di.CoreComponentDependencies;
import com.avito.android.di.PerActivity;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/messenger/conversation/create/phone_verification/MessengerPhoneVerificationActivityComponent;", "", "Lcom/avito/android/messenger/conversation/create/phone_verification/MessengerPhoneVerificationActivity;", "activity", "", "inject", "(Lcom/avito/android/messenger/conversation/create/phone_verification/MessengerPhoneVerificationActivity;)V", "Builder", "messenger_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {CoreComponentDependencies.class})
@PerActivity
public interface MessengerPhoneVerificationActivityComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/avito/android/messenger/conversation/create/phone_verification/MessengerPhoneVerificationActivityComponent$Builder;", "", "Lcom/avito/android/di/CoreComponentDependencies;", "dependencies", "coreComponentDependencies", "(Lcom/avito/android/di/CoreComponentDependencies;)Lcom/avito/android/messenger/conversation/create/phone_verification/MessengerPhoneVerificationActivityComponent$Builder;", "Lcom/avito/android/messenger/conversation/create/phone_verification/MessengerPhoneVerificationActivityComponent;", "build", "()Lcom/avito/android/messenger/conversation/create/phone_verification/MessengerPhoneVerificationActivityComponent;", "messenger_release"}, k = 1, mv = {1, 4, 2})
    @Component.Builder
    public interface Builder {
        @NotNull
        MessengerPhoneVerificationActivityComponent build();

        @NotNull
        Builder coreComponentDependencies(@NotNull CoreComponentDependencies coreComponentDependencies);
    }

    void inject(@NotNull MessengerPhoneVerificationActivity messengerPhoneVerificationActivity);
}
