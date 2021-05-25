package com.avito.android.profile_phones.add_phone.di;

import android.content.res.Resources;
import androidx.lifecycle.ViewModelProvider;
import com.avito.android.code_confirmation.phone_confirm.PhoneConfirmResourceProvider;
import com.avito.android.di.PerFragment;
import com.avito.android.profile_phones.add_phone.AddPhoneInteractor;
import com.avito.android.profile_phones.add_phone.AddPhoneInteractorImpl;
import com.avito.android.profile_phones.add_phone.AddPhoneViewModelFactory;
import com.avito.android.remote.auth.AuthSource;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001:\u0001\fB\u000f\u0012\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\u0005\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0003\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\r"}, d2 = {"Lcom/avito/android/profile_phones/add_phone/di/AddPhoneModule;", "", "Lcom/avito/android/code_confirmation/phone_confirm/PhoneConfirmResourceProvider;", "provideUserProfileResourceProvider$profile_phones_release", "()Lcom/avito/android/code_confirmation/phone_confirm/PhoneConfirmResourceProvider;", "provideUserProfileResourceProvider", "Landroid/content/res/Resources;", AuthSource.SEND_ABUSE, "Landroid/content/res/Resources;", "resources", "<init>", "(Landroid/content/res/Resources;)V", "Dependencies", "profile-phones_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {Dependencies.class})
public final class AddPhoneModule {
    public final Resources a;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/profile_phones/add_phone/di/AddPhoneModule$Dependencies;", "", "Lcom/avito/android/profile_phones/add_phone/AddPhoneViewModelFactory;", "viewModelFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "provideViewModelFactory", "(Lcom/avito/android/profile_phones/add_phone/AddPhoneViewModelFactory;)Landroidx/lifecycle/ViewModelProvider$Factory;", "Lcom/avito/android/profile_phones/add_phone/AddPhoneInteractorImpl;", "interactor", "Lcom/avito/android/profile_phones/add_phone/AddPhoneInteractor;", "bindAddPhoneInteractor", "(Lcom/avito/android/profile_phones/add_phone/AddPhoneInteractorImpl;)Lcom/avito/android/profile_phones/add_phone/AddPhoneInteractor;", "profile-phones_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Dependencies {
        @PerFragment
        @Binds
        @NotNull
        AddPhoneInteractor bindAddPhoneInteractor(@NotNull AddPhoneInteractorImpl addPhoneInteractorImpl);

        @PerFragment
        @Binds
        @NotNull
        ViewModelProvider.Factory provideViewModelFactory(@NotNull AddPhoneViewModelFactory addPhoneViewModelFactory);
    }

    public AddPhoneModule(@NotNull Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        this.a = resources;
    }

    @Provides
    @PerFragment
    @NotNull
    public final PhoneConfirmResourceProvider provideUserProfileResourceProvider$profile_phones_release() {
        return new PhoneConfirmResourceProvider(this.a);
    }
}
