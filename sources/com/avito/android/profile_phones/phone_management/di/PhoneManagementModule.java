package com.avito.android.profile_phones.phone_management.di;

import android.content.res.Resources;
import com.avito.android.di.DialogRouterModule;
import com.avito.android.di.PerActivity;
import com.avito.android.profile_phones.phone_management.MessengerPhoneManagementResourceProvider;
import com.avito.android.profile_phones.phone_management.PhoneManagementInteractor;
import com.avito.android.profile_phones.phone_management.PhoneManagementInteractorImpl;
import com.avito.android.profile_phones.phone_management.PhoneManagementPresenter;
import com.avito.android.profile_phones.phone_management.PhoneManagementPresenterImpl;
import com.avito.android.profile_phones.phone_management.PhoneManagementResourceProvider;
import com.avito.android.profile_phones.phone_management.PhoneManagementResourceProviderImpl;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\fB\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ!\u0010\t\u001a\u00020\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0001¢\u0006\u0004\b\u0007\u0010\b¨\u0006\r"}, d2 = {"Lcom/avito/android/profile_phones/phone_management/di/PhoneManagementModule;", "", "", "fromProfile", "Landroid/content/res/Resources;", "resources", "Lcom/avito/android/profile_phones/phone_management/PhoneManagementResourceProvider;", "providePhoneManagementResourceProvider$profile_phones_release", "(ZLandroid/content/res/Resources;)Lcom/avito/android/profile_phones/phone_management/PhoneManagementResourceProvider;", "providePhoneManagementResourceProvider", "<init>", "()V", "Declarations", "profile-phones_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {DialogRouterModule.class, Declarations.class})
public final class PhoneManagementModule {
    @NotNull
    public static final PhoneManagementModule INSTANCE = new PhoneManagementModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/profile_phones/phone_management/di/PhoneManagementModule$Declarations;", "", "Lcom/avito/android/profile_phones/phone_management/PhoneManagementInteractorImpl;", "interactor", "Lcom/avito/android/profile_phones/phone_management/PhoneManagementInteractor;", "bindPhoneManagementInteractor", "(Lcom/avito/android/profile_phones/phone_management/PhoneManagementInteractorImpl;)Lcom/avito/android/profile_phones/phone_management/PhoneManagementInteractor;", "Lcom/avito/android/profile_phones/phone_management/PhoneManagementPresenterImpl;", "presenter", "Lcom/avito/android/profile_phones/phone_management/PhoneManagementPresenter;", "bindPhoneManagementPresenter", "(Lcom/avito/android/profile_phones/phone_management/PhoneManagementPresenterImpl;)Lcom/avito/android/profile_phones/phone_management/PhoneManagementPresenter;", "profile-phones_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @PerActivity
        @Binds
        @NotNull
        PhoneManagementInteractor bindPhoneManagementInteractor(@NotNull PhoneManagementInteractorImpl phoneManagementInteractorImpl);

        @PerActivity
        @Binds
        @NotNull
        PhoneManagementPresenter bindPhoneManagementPresenter(@NotNull PhoneManagementPresenterImpl phoneManagementPresenterImpl);
    }

    @Provides
    @PerActivity
    @NotNull
    public final PhoneManagementResourceProvider providePhoneManagementResourceProvider$profile_phones_release(@FromProfile boolean z, @NotNull Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        if (z) {
            return new PhoneManagementResourceProviderImpl(resources);
        }
        return new MessengerPhoneManagementResourceProvider(resources);
    }
}
