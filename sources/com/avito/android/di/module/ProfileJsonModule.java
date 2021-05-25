package com.avito.android.di.module;

import com.avito.android.Features;
import com.avito.android.analytics.screens.PublicConstantsKt;
import com.avito.android.remote.model.AuthResult;
import com.avito.android.remote.model.ConsultationPhoneConfirmationResult;
import com.avito.android.remote.model.ConsultationPhoneConfirmationStatus;
import com.avito.android.remote.model.LoginResult;
import com.avito.android.remote.model.PhoneValidationResult;
import com.avito.android.remote.model.RequestPhoneAntihackCodeResult;
import com.avito.android.remote.model.SendPhoneAntihackCodeResult;
import com.avito.android.remote.model.SocialAuthResult;
import com.avito.android.remote.model.recover_by_phone.ConfirmPasswordRecoveryByPhoneResult;
import com.avito.android.remote.model.recover_by_phone.RecoverByPhoneResult;
import com.avito.android.remote.model.recover_by_phone.ResetPasswordResult;
import com.avito.android.remote.model.registration.ConfirmCodeResult;
import com.avito.android.remote.model.registration.ListProfilesResult;
import com.avito.android.remote.model.registration.RequestCodeResult;
import com.avito.android.remote.model.user_profile.items.UserProfileItem;
import com.avito.android.remote.model.user_profile.items.VerificationPlatformStatus;
import com.avito.android.remote.parse.adapter.AuthResultTypeAdapter;
import com.avito.android.remote.parse.adapter.LoginResultOkTypeAdapter;
import com.avito.android.remote.parse.adapter.SocialAuthResultOkTypeAdapter;
import com.avito.android.remote.parse.adapter.UserProfileItemTypeAdapter;
import com.avito.android.remote.parse.adapter.VerificationStatusTypeAdapter;
import com.avito.android.util.CustomTypeAdapterEntry;
import com.avito.android.util.GsonSetsKt;
import com.avito.android.util.TypeAdapterEntry;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.ElementsIntoSet;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.r;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0004H\u0007¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/avito/android/di/module/ProfileJsonModule;", "", "Lcom/avito/android/Features;", "features", "", "Lcom/avito/android/util/TypeAdapterEntry;", "provideTypeAdapters", "(Lcom/avito/android/Features;)Ljava/util/Set;", "Lcom/avito/android/util/CustomTypeAdapterEntry;", "provideCustomTypeAdapters", "()Ljava/util/Set;", "<init>", "()V", "profile_release"}, k = 1, mv = {1, 4, 2})
@Module
public final class ProfileJsonModule {
    @NotNull
    public static final ProfileJsonModule INSTANCE = new ProfileJsonModule();

    @Provides
    @JvmStatic
    @ElementsIntoSet
    @NotNull
    public static final Set<CustomTypeAdapterEntry> provideCustomTypeAdapters() {
        return GsonSetsKt.registerCustomType(GsonSetsKt.registerCustomType(GsonSetsKt.registerCustomType(GsonSetsKt.registerCustomType(GsonSetsKt.registerCustomType(GsonSetsKt.registerCustomType(GsonSetsKt.registerCustomType(GsonSetsKt.registerCustomType(GsonSetsKt.registerCustomType(GsonSetsKt.registerCustomType(GsonSetsKt.registerCustomType(GsonSetsKt.registerCustomType(GsonSetsKt.registerCustomType(new LinkedHashSet(), LoginResult.class, r.mapOf(TuplesKt.to("ok", LoginResult.Ok.class), TuplesKt.to(PublicConstantsKt.FAILURE, LoginResult.FailedWithMessage.class), TuplesKt.to("forbidden", LoginResult.FailedWithMessage.class), TuplesKt.to("incorrect-data", LoginResult.FailedWithMessages.class), TuplesKt.to("blocked-account", LoginResult.FailedWithDialog.class), TuplesKt.to("deleted-account", LoginResult.FailedWithDialog.class), TuplesKt.to("wrong-credentials", LoginResult.FailedWithDialog.class), TuplesKt.to("error-dialog", LoginResult.FailedWithDialog.class), TuplesKt.to("need-phone-verification", LoginResult.NeedPhoneVerification.class), TuplesKt.to("antihack-check", LoginResult.AntihackCheck.class), TuplesKt.to("antihack-check-phones", LoginResult.AntihackCheckPhone.class), TuplesKt.to("tfa-check", LoginResult.TfaCheck.class))), RecoverByPhoneResult.class, r.mapOf(TuplesKt.to("ok", RecoverByPhoneResult.Ok.class), TuplesKt.to(PublicConstantsKt.FAILURE, RecoverByPhoneResult.Failure.class), TuplesKt.to("unsafe", RecoverByPhoneResult.Unsafe.class), TuplesKt.to("incorrect-data", RecoverByPhoneResult.IncorrectData.class), TuplesKt.to("confirmed", RecoverByPhoneResult.Confirmed.class))), ConfirmPasswordRecoveryByPhoneResult.class, r.mapOf(TuplesKt.to("ok", ConfirmPasswordRecoveryByPhoneResult.Ok.class), TuplesKt.to("incorrect-data", ConfirmPasswordRecoveryByPhoneResult.IncorrectData.class), TuplesKt.to(PublicConstantsKt.FAILURE, ConfirmPasswordRecoveryByPhoneResult.Failure.class))), ResetPasswordResult.class, r.mapOf(TuplesKt.to("ok", ResetPasswordResult.Ok.class), TuplesKt.to("incorrect-data", ResetPasswordResult.IncorrectData.class), TuplesKt.to(PublicConstantsKt.FAILURE, ResetPasswordResult.Failure.class))), RequestCodeResult.class, r.mapOf(TuplesKt.to("ok", RequestCodeResult.Ok.class), TuplesKt.to("incorrect-data", RequestCodeResult.IncorrectData.class), TuplesKt.to(PublicConstantsKt.FAILURE, RequestCodeResult.Failure.class), TuplesKt.to("confirmed", RequestCodeResult.Confirmed.class), TuplesKt.to("verifyByCall", RequestCodeResult.VerifyByCall.class))), ListProfilesResult.class, r.mapOf(TuplesKt.to("ok", ListProfilesResult.Ok.class), TuplesKt.to(PublicConstantsKt.FAILURE, ListProfilesResult.Failure.class))), ConfirmCodeResult.class, r.mapOf(TuplesKt.to("ok", ConfirmCodeResult.Ok.class), TuplesKt.to("incorrect-data", ConfirmCodeResult.IncorrectData.class), TuplesKt.to(PublicConstantsKt.FAILURE, ConfirmCodeResult.Failure.class))), RequestPhoneAntihackCodeResult.class, r.mapOf(TuplesKt.to("ok", RequestPhoneAntihackCodeResult.Ok.class), TuplesKt.to(PublicConstantsKt.FAILURE, RequestPhoneAntihackCodeResult.Failure.class))), SendPhoneAntihackCodeResult.class, r.mapOf(TuplesKt.to("ok", SendPhoneAntihackCodeResult.Ok.class), TuplesKt.to(PublicConstantsKt.FAILURE, SendPhoneAntihackCodeResult.Failure.class), TuplesKt.to("incorrect-data", SendPhoneAntihackCodeResult.IncorrectData.class), TuplesKt.to("error-dialog", SendPhoneAntihackCodeResult.FailedWithDialog.class))), ConsultationPhoneConfirmationStatus.class, r.mapOf(TuplesKt.to("ok", ConsultationPhoneConfirmationStatus.Ok.class), TuplesKt.to(PublicConstantsKt.FAILURE, ConsultationPhoneConfirmationStatus.Failure.class))), ConsultationPhoneConfirmationResult.class, r.mapOf(TuplesKt.to("ok", ConsultationPhoneConfirmationResult.Ok.class), TuplesKt.to(PublicConstantsKt.FAILURE, ConsultationPhoneConfirmationResult.Failure.class))), SocialAuthResult.class, r.mapOf(TuplesKt.to("ok", SocialAuthResult.Ok.class), TuplesKt.to("social-wrong-user", SocialAuthResult.WrongSocialUser.class), TuplesKt.to("account-suggest", SocialAuthResult.AccountSuggest.class))), PhoneValidationResult.class, r.mapOf(TuplesKt.to("ok", PhoneValidationResult.Ok.class), TuplesKt.to("incorrect-data", PhoneValidationResult.IncorrectData.class)));
    }

    @Provides
    @JvmStatic
    @ElementsIntoSet
    @NotNull
    public static final Set<TypeAdapterEntry> provideTypeAdapters(@NotNull Features features) {
        Intrinsics.checkNotNullParameter(features, "features");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.add(new TypeAdapterEntry(AuthResult.class, new AuthResultTypeAdapter()));
        linkedHashSet.add(new TypeAdapterEntry(LoginResult.Ok.class, new LoginResultOkTypeAdapter()));
        linkedHashSet.add(new TypeAdapterEntry(UserProfileItem.class, new UserProfileItemTypeAdapter(features)));
        linkedHashSet.add(new TypeAdapterEntry(VerificationPlatformStatus.class, new VerificationStatusTypeAdapter()));
        linkedHashSet.add(new TypeAdapterEntry(SocialAuthResult.Ok.class, new SocialAuthResultOkTypeAdapter()));
        return linkedHashSet;
    }
}
