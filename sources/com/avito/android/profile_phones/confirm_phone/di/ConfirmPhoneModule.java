package com.avito.android.profile_phones.confirm_phone.di;

import android.content.res.Resources;
import com.avito.android.code_confirmation.phone_confirm.PhoneConfirmInteractor;
import com.avito.android.code_confirmation.phone_confirm.PhoneConfirmInteractorImpl;
import com.avito.android.code_confirmation.phone_confirm.PhoneConfirmResourceProvider;
import com.avito.android.di.PerFragment;
import com.avito.android.profile_phones.confirm_phone.ConfirmPhoneViewModelFactory;
import com.avito.android.remote.auth.AuthSource;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001:\u0001\"B/\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010\u001f\u001a\u00020\u001c\u0012\u0006\u0010\u001b\u001a\u00020\u0018\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\u0006\u0010\u0017\u001a\u00020\u0014¢\u0006\u0004\b \u0010!J\u000f\u0010\u0005\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0001¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e¨\u0006#"}, d2 = {"Lcom/avito/android/profile_phones/confirm_phone/di/ConfirmPhoneModule;", "", "Lcom/avito/android/code_confirmation/phone_confirm/PhoneConfirmResourceProvider;", "provideUserProfileResourceProvider$profile_phones_release", "()Lcom/avito/android/code_confirmation/phone_confirm/PhoneConfirmResourceProvider;", "provideUserProfileResourceProvider", "Lcom/avito/android/code_confirmation/phone_confirm/PhoneConfirmInteractor;", "interactor", "Lcom/avito/android/profile_phones/confirm_phone/ConfirmPhoneViewModelFactory;", "provideViewModelFactory$profile_phones_release", "(Lcom/avito/android/code_confirmation/phone_confirm/PhoneConfirmInteractor;)Lcom/avito/android/profile_phones/confirm_phone/ConfirmPhoneViewModelFactory;", "provideViewModelFactory", "Landroid/content/res/Resources;", AuthSource.SEND_ABUSE, "Landroid/content/res/Resources;", "resources", "", "d", "J", "timeout", "", "e", "Z", "codeRequestNeeded", "", "c", "I", "codeLength", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "phone", "<init>", "(Landroid/content/res/Resources;Ljava/lang/String;IJZ)V", "Dependencies", "profile-phones_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {Dependencies.class})
public final class ConfirmPhoneModule {
    public final Resources a;
    public final String b;
    public final int c;
    public final long d;
    public final boolean e;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/avito/android/profile_phones/confirm_phone/di/ConfirmPhoneModule$Dependencies;", "", "Lcom/avito/android/code_confirmation/phone_confirm/PhoneConfirmInteractorImpl;", "interactor", "Lcom/avito/android/code_confirmation/phone_confirm/PhoneConfirmInteractor;", "bindInteractor", "(Lcom/avito/android/code_confirmation/phone_confirm/PhoneConfirmInteractorImpl;)Lcom/avito/android/code_confirmation/phone_confirm/PhoneConfirmInteractor;", "profile-phones_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Dependencies {
        @PerFragment
        @Binds
        @NotNull
        PhoneConfirmInteractor bindInteractor(@NotNull PhoneConfirmInteractorImpl phoneConfirmInteractorImpl);
    }

    public ConfirmPhoneModule(@NotNull Resources resources, @NotNull String str, int i, long j, boolean z) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        Intrinsics.checkNotNullParameter(str, "phone");
        this.a = resources;
        this.b = str;
        this.c = i;
        this.d = j;
        this.e = z;
    }

    @Provides
    @PerFragment
    @NotNull
    public final PhoneConfirmResourceProvider provideUserProfileResourceProvider$profile_phones_release() {
        return new PhoneConfirmResourceProvider(this.a);
    }

    @Provides
    @PerFragment
    @NotNull
    public final ConfirmPhoneViewModelFactory provideViewModelFactory$profile_phones_release(@NotNull PhoneConfirmInteractor phoneConfirmInteractor) {
        Intrinsics.checkNotNullParameter(phoneConfirmInteractor, "interactor");
        return new ConfirmPhoneViewModelFactory(this.b, this.c, phoneConfirmInteractor, this.d, this.e);
    }
}
