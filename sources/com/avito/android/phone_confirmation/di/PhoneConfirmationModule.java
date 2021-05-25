package com.avito.android.phone_confirmation.di;

import com.avito.android.di.PerActivity;
import com.avito.android.phone_confirmation.ConsultationFormPhoneConfirmationInteractorImpl;
import com.avito.android.phone_confirmation.PhoneConfirmationInteractor;
import com.avito.android.phone_confirmation.PhoneConfirmationInteractorImpl;
import com.avito.android.phone_confirmation.PhoneConfirmationRouter;
import com.avito.android.phone_confirmation.PhoneConfirmationRouterImpl;
import com.avito.android.phone_confirmation.state.PhoneConfirmationScreenState;
import com.avito.android.phone_confirmation.state.PhoneConfirmationTimeStorage;
import com.avito.android.phone_confirmation.state.PhoneConfirmationTimeStorageImpl;
import com.avito.android.remote.ProfileApi;
import com.avito.android.server_time.TimeSource;
import com.avito.android.util.Formatter;
import com.avito.android.util.PhoneNumberFormatterModule;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b\u0012\u0010\u0013JG\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u000e\b\u0001\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0007¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/avito/android/phone_confirmation/di/PhoneConfirmationModule;", "", "", "confirmPhoneOnConsultationForm", "Lcom/avito/android/remote/ProfileApi;", "api", "Lcom/avito/android/server_time/TimeSource;", "timeSource", "Lcom/avito/android/phone_confirmation/state/PhoneConfirmationTimeStorage;", "timeStorage", "Lcom/avito/android/phone_confirmation/state/PhoneConfirmationScreenState;", "initialState", "Lcom/avito/android/util/Formatter;", "", "formatter", "Lcom/avito/android/phone_confirmation/PhoneConfirmationInteractor;", "providePhoneConfirmationInteractor", "(ZLcom/avito/android/remote/ProfileApi;Lcom/avito/android/server_time/TimeSource;Lcom/avito/android/phone_confirmation/state/PhoneConfirmationTimeStorage;Lcom/avito/android/phone_confirmation/state/PhoneConfirmationScreenState;Lcom/avito/android/util/Formatter;)Lcom/avito/android/phone_confirmation/PhoneConfirmationInteractor;", "<init>", "()V", "Declarations", "phone-confirmation_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {PhoneNumberFormatterModule.class, Declarations.class})
public final class PhoneConfirmationModule {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0007H'¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/avito/android/phone_confirmation/di/PhoneConfirmationModule$Declarations;", "", "Lcom/avito/android/phone_confirmation/state/PhoneConfirmationTimeStorageImpl;", "interactor", "Lcom/avito/android/phone_confirmation/state/PhoneConfirmationTimeStorage;", "bindPhoneConfirmationTimeStorage", "(Lcom/avito/android/phone_confirmation/state/PhoneConfirmationTimeStorageImpl;)Lcom/avito/android/phone_confirmation/state/PhoneConfirmationTimeStorage;", "Lcom/avito/android/phone_confirmation/PhoneConfirmationRouterImpl;", "Lcom/avito/android/phone_confirmation/PhoneConfirmationRouter;", "bindPhoneConfirmationRouter", "(Lcom/avito/android/phone_confirmation/PhoneConfirmationRouterImpl;)Lcom/avito/android/phone_confirmation/PhoneConfirmationRouter;", "phone-confirmation_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @PerActivity
        @Binds
        @NotNull
        PhoneConfirmationRouter bindPhoneConfirmationRouter(@NotNull PhoneConfirmationRouterImpl phoneConfirmationRouterImpl);

        @PerActivity
        @Binds
        @NotNull
        PhoneConfirmationTimeStorage bindPhoneConfirmationTimeStorage(@NotNull PhoneConfirmationTimeStorageImpl phoneConfirmationTimeStorageImpl);
    }

    @Provides
    @NotNull
    @PerActivity
    public final PhoneConfirmationInteractor providePhoneConfirmationInteractor(boolean z, @NotNull ProfileApi profileApi, @NotNull TimeSource timeSource, @NotNull PhoneConfirmationTimeStorage phoneConfirmationTimeStorage, @NotNull PhoneConfirmationScreenState phoneConfirmationScreenState, @PhoneNumberFormatterModule.PhoneNumberFormatterWithCountryCode @NotNull Formatter<String> formatter) {
        Intrinsics.checkNotNullParameter(profileApi, "api");
        Intrinsics.checkNotNullParameter(timeSource, "timeSource");
        Intrinsics.checkNotNullParameter(phoneConfirmationTimeStorage, "timeStorage");
        Intrinsics.checkNotNullParameter(phoneConfirmationScreenState, "initialState");
        Intrinsics.checkNotNullParameter(formatter, "formatter");
        if (z) {
            return new ConsultationFormPhoneConfirmationInteractorImpl(profileApi, timeSource, phoneConfirmationTimeStorage, phoneConfirmationScreenState, formatter);
        }
        return new PhoneConfirmationInteractorImpl(profileApi, timeSource, phoneConfirmationTimeStorage, phoneConfirmationScreenState, formatter);
    }
}
