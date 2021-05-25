package com.avito.android.code_confirmation.di;

import com.avito.android.code_confirmation.CodeConfirmationInteractor;
import com.avito.android.code_confirmation.CodeConfirmationInteractorImpl;
import com.avito.android.code_confirmation.CodeConfirmationResourceProvider;
import com.avito.android.code_confirmation.CodeConfirmationResourceProviderImpl;
import com.avito.android.code_confirmation.LegacyCodeConfirmationInteractor;
import com.avito.android.code_confirmation.PhoneAntihackInteractor;
import com.avito.android.code_confirmation.PhoneAntihackInteractorImpl;
import com.avito.android.code_confirmation.Source;
import com.avito.android.code_confirmation.tfa.TfaInteractor;
import com.avito.android.code_confirmation.tfa.TfaInteractorImpl;
import com.avito.android.di.DialogRouterModule;
import com.avito.android.di.PerActivity;
import com.avito.android.remote.ProfileApi;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.preferences.GeoContract;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\u0017B\t\b\u0002¢\u0006\u0004\b\u0015\u0010\u0016JA\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\b\u0001\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0001¢\u0006\u0004\b\u000f\u0010\u0010J'\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0001¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0018"}, d2 = {"Lcom/avito/android/code_confirmation/di/CodeConfirmationModule;", "", "Lcom/avito/android/remote/ProfileApi;", "api", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Lcom/avito/android/code_confirmation/CodeConfirmationResourceProvider;", "resourceProvider", "Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", "errorConvert", "", "src", "", "retry", "Lcom/avito/android/code_confirmation/CodeConfirmationInteractor;", "provideCodeConfirmationInteractor$code_confirmation_release", "(Lcom/avito/android/remote/ProfileApi;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/code_confirmation/CodeConfirmationResourceProvider;Lcom/avito/android/remote/error/TypedErrorThrowableConverter;Ljava/lang/String;Z)Lcom/avito/android/code_confirmation/CodeConfirmationInteractor;", "provideCodeConfirmationInteractor", "provideLoginCodeConfirmationInteractor$code_confirmation_release", "(Lcom/avito/android/remote/ProfileApi;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/code_confirmation/CodeConfirmationResourceProvider;)Lcom/avito/android/code_confirmation/CodeConfirmationInteractor;", "provideLoginCodeConfirmationInteractor", "<init>", "()V", "Declarations", "code-confirmation_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {DialogRouterModule.class, Declarations.class})
public final class CodeConfirmationModule {
    @NotNull
    public static final CodeConfirmationModule INSTANCE = new CodeConfirmationModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH'¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/avito/android/code_confirmation/di/CodeConfirmationModule$Declarations;", "", "Lcom/avito/android/code_confirmation/CodeConfirmationResourceProviderImpl;", GeoContract.PROVIDER, "Lcom/avito/android/code_confirmation/CodeConfirmationResourceProvider;", "bindCodeConfirmationResourceProvider", "(Lcom/avito/android/code_confirmation/CodeConfirmationResourceProviderImpl;)Lcom/avito/android/code_confirmation/CodeConfirmationResourceProvider;", "Lcom/avito/android/code_confirmation/PhoneAntihackInteractorImpl;", "interactor", "Lcom/avito/android/code_confirmation/PhoneAntihackInteractor;", "bindPhoneAntihackInteractor", "(Lcom/avito/android/code_confirmation/PhoneAntihackInteractorImpl;)Lcom/avito/android/code_confirmation/PhoneAntihackInteractor;", "Lcom/avito/android/code_confirmation/tfa/TfaInteractorImpl;", "impl", "Lcom/avito/android/code_confirmation/tfa/TfaInteractor;", "bindTfaInteractor", "(Lcom/avito/android/code_confirmation/tfa/TfaInteractorImpl;)Lcom/avito/android/code_confirmation/tfa/TfaInteractor;", "code-confirmation_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @PerActivity
        @Binds
        @NotNull
        CodeConfirmationResourceProvider bindCodeConfirmationResourceProvider(@NotNull CodeConfirmationResourceProviderImpl codeConfirmationResourceProviderImpl);

        @PerActivity
        @Binds
        @NotNull
        PhoneAntihackInteractor bindPhoneAntihackInteractor(@NotNull PhoneAntihackInteractorImpl phoneAntihackInteractorImpl);

        @PerActivity
        @Binds
        @NotNull
        TfaInteractor bindTfaInteractor(@NotNull TfaInteractorImpl tfaInteractorImpl);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerActivity
    public static final CodeConfirmationInteractor provideCodeConfirmationInteractor$code_confirmation_release(@NotNull ProfileApi profileApi, @NotNull SchedulersFactory schedulersFactory, @NotNull CodeConfirmationResourceProvider codeConfirmationResourceProvider, @NotNull TypedErrorThrowableConverter typedErrorThrowableConverter, @CodeConfirmationSource @NotNull String str, boolean z) {
        Intrinsics.checkNotNullParameter(profileApi, "api");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(codeConfirmationResourceProvider, "resourceProvider");
        Intrinsics.checkNotNullParameter(typedErrorThrowableConverter, "errorConvert");
        Intrinsics.checkNotNullParameter(str, "src");
        if (Intrinsics.areEqual(str, Source.AUTHORIZATION)) {
            return new LegacyCodeConfirmationInteractor(profileApi, codeConfirmationResourceProvider, schedulersFactory);
        }
        return new CodeConfirmationInteractorImpl(profileApi, schedulersFactory, codeConfirmationResourceProvider, typedErrorThrowableConverter, z, str);
    }

    @Provides
    @JvmStatic
    @LoginCodeConfirmation
    @NotNull
    @PerActivity
    public static final CodeConfirmationInteractor provideLoginCodeConfirmationInteractor$code_confirmation_release(@NotNull ProfileApi profileApi, @NotNull SchedulersFactory schedulersFactory, @NotNull CodeConfirmationResourceProvider codeConfirmationResourceProvider) {
        Intrinsics.checkNotNullParameter(profileApi, "api");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(codeConfirmationResourceProvider, "resourceProvider");
        return new LegacyCodeConfirmationInteractor(profileApi, codeConfirmationResourceProvider, schedulersFactory);
    }
}
