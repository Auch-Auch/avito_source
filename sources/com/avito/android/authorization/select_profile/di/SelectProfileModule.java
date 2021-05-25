package com.avito.android.authorization.select_profile.di;

import com.avito.android.authorization.select_profile.SelectProfileInteractor;
import com.avito.android.authorization.select_profile.SelectProfileInteractorImpl;
import com.avito.android.authorization.select_profile.SelectProfilePresenter;
import com.avito.android.authorization.select_profile.SelectProfilePresenterImpl;
import com.avito.android.authorization.select_profile.SelectProfileResourceProvider;
import com.avito.android.authorization.select_profile.SelectProfileResourceProviderImpl;
import com.avito.android.authorization.select_profile.adapter.SelectProfileField;
import com.avito.android.di.PerActivity;
import com.avito.android.error_helper.di.ErrorHelperModule;
import com.avito.android.konveyor_adapter_module.AdapterModule;
import com.avito.android.util.preferences.GeoContract;
import com.jakewharton.rxrelay3.PublishRelay;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\tB\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0001¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\n"}, d2 = {"Lcom/avito/android/authorization/select_profile/di/SelectProfileModule;", "", "Lcom/jakewharton/rxrelay3/PublishRelay;", "Lcom/avito/android/authorization/select_profile/adapter/SelectProfileField;", "provideFieldClicksStream$authorization_release", "()Lcom/jakewharton/rxrelay3/PublishRelay;", "provideFieldClicksStream", "<init>", "()V", "Declarations", "authorization_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {AdapterModule.class, ErrorHelperModule.class, Declarations.class})
public final class SelectProfileModule {
    @NotNull
    public static final SelectProfileModule INSTANCE = new SelectProfileModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH'¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/avito/android/authorization/select_profile/di/SelectProfileModule$Declarations;", "", "Lcom/avito/android/authorization/select_profile/SelectProfileInteractorImpl;", "interactor", "Lcom/avito/android/authorization/select_profile/SelectProfileInteractor;", "bindSelectProfileInteractor", "(Lcom/avito/android/authorization/select_profile/SelectProfileInteractorImpl;)Lcom/avito/android/authorization/select_profile/SelectProfileInteractor;", "Lcom/avito/android/authorization/select_profile/SelectProfilePresenterImpl;", "presenter", "Lcom/avito/android/authorization/select_profile/SelectProfilePresenter;", "bindSelectProfilePresenter", "(Lcom/avito/android/authorization/select_profile/SelectProfilePresenterImpl;)Lcom/avito/android/authorization/select_profile/SelectProfilePresenter;", "Lcom/avito/android/authorization/select_profile/SelectProfileResourceProviderImpl;", GeoContract.PROVIDER, "Lcom/avito/android/authorization/select_profile/SelectProfileResourceProvider;", "bindSelectProfileResourceProvider", "(Lcom/avito/android/authorization/select_profile/SelectProfileResourceProviderImpl;)Lcom/avito/android/authorization/select_profile/SelectProfileResourceProvider;", "authorization_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @PerActivity
        @Binds
        @NotNull
        SelectProfileInteractor bindSelectProfileInteractor(@NotNull SelectProfileInteractorImpl selectProfileInteractorImpl);

        @PerActivity
        @Binds
        @NotNull
        SelectProfilePresenter bindSelectProfilePresenter(@NotNull SelectProfilePresenterImpl selectProfilePresenterImpl);

        @PerActivity
        @Binds
        @NotNull
        SelectProfileResourceProvider bindSelectProfileResourceProvider(@NotNull SelectProfileResourceProviderImpl selectProfileResourceProviderImpl);
    }

    @Provides
    @NotNull
    @PerActivity
    public final PublishRelay<SelectProfileField> provideFieldClicksStream$authorization_release() {
        PublishRelay<SelectProfileField> create = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create, "PublishRelay.create<SelectProfileField>()");
        return create;
    }
}
