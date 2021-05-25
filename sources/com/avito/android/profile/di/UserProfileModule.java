package com.avito.android.profile.di;

import a2.b.a.a.a;
import a2.g.r.g;
import android.content.res.Resources;
import com.avito.android.Features;
import com.avito.android.ab_tests.configs.UserAdvertsTabTestGroup;
import com.avito.android.account.AccountInteractor;
import com.avito.android.account.AccountStorageInteractor;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.screen.UserProfileTracker;
import com.avito.android.analytics.screen.UserProfileTrackerImpl;
import com.avito.android.analytics.screens.ScreenFlowTrackerProvider;
import com.avito.android.analytics.screens.TimerFactory;
import com.avito.android.analytics.screens.UserProfileScreen;
import com.avito.android.analytics.screens.tracker.ScreenDiInjectTracker;
import com.avito.android.analytics.screens.tracker.ScreenInitTracker;
import com.avito.android.analytics.screens.tracker.ScreenTrackerFactory;
import com.avito.android.cart_fab.CartFabModule;
import com.avito.android.code_confirmation.CodeConfirmationInteractor;
import com.avito.android.code_confirmation.timer.RxTimer;
import com.avito.android.code_confirmation.timer.RxTimerImpl;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.OnDeepLinkClickListener;
import com.avito.android.di.PerActivity;
import com.avito.android.dialog.DialogPresenter;
import com.avito.android.error_helper.ErrorHelper;
import com.avito.android.notification_center.counter.NotificationCenterCounterInteractor;
import com.avito.android.profile.UserProfileInteractor;
import com.avito.android.profile.UserProfileInteractorImpl;
import com.avito.android.profile.UserProfileItemConverter;
import com.avito.android.profile.UserProfileItemConverterImpl;
import com.avito.android.profile.UserProfilePresenter;
import com.avito.android.profile.UserProfilePresenterImpl;
import com.avito.android.profile.cards.AdvertsCardBlueprint;
import com.avito.android.profile.cards.AdvertsCardItemPresenter;
import com.avito.android.profile.cards.AdvertsCardItemPresenterImpl;
import com.avito.android.profile.cards.CardItem;
import com.avito.android.profile.cards.ContactsCardBlueprint;
import com.avito.android.profile.cards.ContactsCardItemPresenter;
import com.avito.android.profile.cards.ContactsCardItemPresenterImpl;
import com.avito.android.profile.cards.DeliverySettingsCardBlueprint;
import com.avito.android.profile.cards.DeliverySettingsItemPresenter;
import com.avito.android.profile.cards.DeliverySettingsItemPresenterImpl;
import com.avito.android.profile.cards.ExtensionsCardBlueprint;
import com.avito.android.profile.cards.ExtensionsCardItemPresenter;
import com.avito.android.profile.cards.ExtensionsCardItemPresenterImpl;
import com.avito.android.profile.cards.HelpCenterCardBlueprint;
import com.avito.android.profile.cards.HelpCenterCardItemPresenter;
import com.avito.android.profile.cards.HelpCenterCardItemPresenterImpl;
import com.avito.android.profile.cards.IncomeSettingsCardBlueprint;
import com.avito.android.profile.cards.IncomeSettingsCardItemPresenter;
import com.avito.android.profile.cards.IncomeSettingsCardItemPresenterImpl;
import com.avito.android.profile.cards.InfoCardBlueprint;
import com.avito.android.profile.cards.InfoCardItemPresenter;
import com.avito.android.profile.cards.InfoCardItemPresenterImpl;
import com.avito.android.profile.cards.LfPackagesCardBlueprint;
import com.avito.android.profile.cards.LfPackagesCardItemPresenter;
import com.avito.android.profile.cards.LfPackagesCardItemPresenterImpl;
import com.avito.android.profile.cards.LogoutCardBlueprint;
import com.avito.android.profile.cards.LogoutCardItemPresenter;
import com.avito.android.profile.cards.LogoutCardItemPresenterImpl;
import com.avito.android.profile.cards.ReviewsCardBlueprint;
import com.avito.android.profile.cards.ReviewsCardItemPresenter;
import com.avito.android.profile.cards.ReviewsCardItemPresenterImpl;
import com.avito.android.profile.cards.ShopSettingsCardBlueprint;
import com.avito.android.profile.cards.ShopSettingsCardItemPresenter;
import com.avito.android.profile.cards.ShopSettingsCardItemPresenterImpl;
import com.avito.android.profile.cards.SocialCardBlueprint;
import com.avito.android.profile.cards.SocialCardItemPresenter;
import com.avito.android.profile.cards.SocialCardItemPresenterImpl;
import com.avito.android.profile.cards.SubscribersCardBlueprint;
import com.avito.android.profile.cards.SubscribersCardItemPresenter;
import com.avito.android.profile.cards.SubscribersCardItemPresenterImpl;
import com.avito.android.profile.cards.SubscriptionCardBlueprint;
import com.avito.android.profile.cards.SubscriptionCardItemPresenter;
import com.avito.android.profile.cards.SubscriptionCardItemPresenterImpl;
import com.avito.android.profile.cards.UserProfileResourceProvider;
import com.avito.android.profile.cards.UserProfileResourceProviderImpl;
import com.avito.android.profile.cards.action.di.ActionItemModule;
import com.avito.android.profile.cards.phones.PhonesActionResourceProvider;
import com.avito.android.profile.cards.phones.PhonesActionResourceProviderImpl;
import com.avito.android.profile.cards.phones.PhonesCardBlueprint;
import com.avito.android.profile.cards.phones.PhonesCardBlueprintOld;
import com.avito.android.profile.cards.phones.PhonesCardItemPresenter;
import com.avito.android.profile.cards.phones.PhonesCardItemPresenterImpl;
import com.avito.android.profile.cards.phones.PhonesCardItemPresenterOld;
import com.avito.android.profile.cards.phones.PhonesCardItemPresenterOldImpl;
import com.avito.android.profile.cards.phones.PhonesCardItemResourceProvider;
import com.avito.android.profile.cards.phones.PhonesCardItemResourceProviderImpl;
import com.avito.android.profile.cards.phones_empty.PhonesEmptyCardBlueprint;
import com.avito.android.profile.cards.phones_empty.PhonesEmptyCardItemPresenter;
import com.avito.android.profile.cards.phones_empty.PhonesEmptyCardItemPresenterImpl;
import com.avito.android.profile.cards.sessions.di.ProfileSessionsItemModule;
import com.avito.android.profile.cards.tfa.di.TfaSettingsItemModule;
import com.avito.android.profile.cards.verification.VerificationCardBlueprint;
import com.avito.android.profile.cards.verification.VerificationCardPresenter;
import com.avito.android.profile.cards.verification.VerificationCardPresenterImpl;
import com.avito.android.profile.cards.verification_platform.VerificationPlatformCardBlueprint;
import com.avito.android.profile.cards.verification_platform.VerificationPlatformCardPresenter;
import com.avito.android.profile.cards.verification_platform.VerificationPlatformCardPresenterImpl;
import com.avito.android.profile.cards.verified_profile.VerifiedProfileCardBlueprint;
import com.avito.android.profile.cards.verified_profile.VerifiedProfileCardPresenter;
import com.avito.android.profile.cards.verified_profile.VerifiedProfileCardPresenterImpl;
import com.avito.android.profile.cards.wallet.action.ActionWalletCardBlueprint;
import com.avito.android.profile.cards.wallet.action.ActionWalletCardItemPresenter;
import com.avito.android.profile.cards.wallet.action.ActionWalletCardItemPresenterImpl;
import com.avito.android.profile.cards.wallet.separate_action.SeparateWalletCardWithActionBlueprint;
import com.avito.android.profile.cards.wallet.separate_action.SeparateWalletCardWithActionItemPresenter;
import com.avito.android.profile.cards.wallet.separate_action.SeparateWalletCardWithActionItemPresenterImpl;
import com.avito.android.profile.header.DefaultProfileHeaderPresenter;
import com.avito.android.profile.header.ProfileHeaderPresenter;
import com.avito.android.profile.header.RootProfileHeaderPresenter;
import com.avito.android.remote.ProfileApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.social.FacebookSocialManager;
import com.avito.android.social.GoogleSocialManager;
import com.avito.android.social.Logoutable;
import com.avito.android.social.LogoutableImpl;
import com.avito.android.social.OdnoklassnikiSocialManager;
import com.avito.android.social.VkontakteSocialManager;
import com.avito.android.social.di.SocialModule;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.preferences.GeoContract;
import com.avito.android.util.text.AttributedTextFormatter;
import com.avito.android.util.text.AttributedTextFormatterImpl;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.blueprint.ItemBlueprint;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.jakewharton.rxrelay2.PublishRelay;
import com.vk.sdk.api.VKApiConst;
import dagger.Binds;
import dagger.Lazy;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoSet;
import io.reactivex.functions.Consumer;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Iterator;
import java.util.Set;
import javax.inject.Qualifier;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000ì\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001:\u0004Ó\u0002Ô\u0002B\u001f\u0012\b\u0010Ð\u0002\u001a\u00030Í\u0002\u0012\n\u0010­\u0002\u001a\u0005\u0018\u00010ª\u0002¢\u0006\u0006\bÑ\u0002\u0010Ò\u0002J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0007¢\u0006\u0004\b\u0004\u0010\u0005J£\u0001\u0010(\u001a\u00020'2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u001e2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020!0\u00022\u0006\u0010$\u001a\u00020#2\u0006\u0010&\u001a\u00020%H\u0007¢\u0006\u0004\b(\u0010)J\u0017\u0010,\u001a\u00020+2\u0006\u0010*\u001a\u00020'H\u0007¢\u0006\u0004\b,\u0010-J/\u00108\u001a\u00020\u00142\u0006\u0010/\u001a\u00020.2\u0006\u00101\u001a\u0002002\u0006\u00103\u001a\u0002022\u0006\u00105\u001a\u000204H\u0001¢\u0006\u0004\b6\u00107J'\u0010=\u001a\u00020\u00062\u0006\u0010:\u001a\u0002092\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010<\u001a\u00020;H\u0007¢\u0006\u0004\b=\u0010>J\u0017\u0010?\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u0018H\u0007¢\u0006\u0004\b?\u0010@J\u0017\u0010D\u001a\u00020\u001e2\u0006\u0010A\u001a\u00020\nH\u0001¢\u0006\u0004\bB\u0010CJ\u0017\u0010I\u001a\u00020\f2\u0006\u0010F\u001a\u00020EH\u0001¢\u0006\u0004\bG\u0010HJ\u000f\u0010L\u001a\u00020\u000eH\u0001¢\u0006\u0004\bJ\u0010KJ*\u0010S\u001a\u00020E2\u0019\u0010P\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u0002\b\u0003\u0012\u0002\b\u00030N¢\u0006\u0002\bO0MH\u0001¢\u0006\u0004\bQ\u0010RJ\u001f\u0010W\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030N2\u0006\u0010*\u001a\u00020TH\u0001¢\u0006\u0004\bU\u0010VJ\u001f\u0010[\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030N2\u0006\u0010*\u001a\u00020XH\u0001¢\u0006\u0004\bY\u0010ZJ'\u0010_\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030N2\u0006\u0010*\u001a\u00020\\2\u0006\u0010\u0019\u001a\u00020\u0018H\u0001¢\u0006\u0004\b]\u0010^J\u000f\u0010a\u001a\u00020`H\u0007¢\u0006\u0004\ba\u0010bJ\u001f\u0010f\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030N2\u0006\u0010*\u001a\u00020cH\u0001¢\u0006\u0004\bd\u0010eJ\u000f\u0010i\u001a\u00020cH\u0001¢\u0006\u0004\bg\u0010hJ'\u0010n\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030N2\u0006\u0010*\u001a\u00020j2\u0006\u0010k\u001a\u00020`H\u0001¢\u0006\u0004\bl\u0010mJ\u001d\u0010q\u001a\u00020j2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0001¢\u0006\u0004\bo\u0010pJ'\u0010u\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030N2\u0006\u0010*\u001a\u00020r2\u0006\u0010\u0019\u001a\u00020\u0018H\u0001¢\u0006\u0004\bs\u0010tJ\u001f\u0010y\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030N2\u0006\u0010*\u001a\u00020vH\u0001¢\u0006\u0004\bw\u0010xJ/\u0010\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030N2\u0006\u0010{\u001a\u00020z2\u0006\u0010*\u001a\u00020|2\u0006\u0010\u0019\u001a\u00020\u0018H\u0001¢\u0006\u0004\b}\u0010~J#\u0010\u0001\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030N2\u0007\u0010*\u001a\u00030\u0001H\u0001¢\u0006\u0006\b\u0001\u0010\u0001J\u0013\u0010\u0001\u001a\u00030\u0001H\u0001¢\u0006\u0006\b\u0001\u0010\u0001J#\u0010\u0001\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030N2\u0007\u0010*\u001a\u00030\u0001H\u0001¢\u0006\u0006\b\u0001\u0010\u0001J#\u0010\u0001\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030N2\u0007\u0010*\u001a\u00030\u0001H\u0001¢\u0006\u0006\b\u0001\u0010\u0001J,\u0010\u0001\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030N2\u0007\u0010*\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020`H\u0001¢\u0006\u0006\b\u0001\u0010\u0001J#\u0010\u0001\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030N2\u0007\u0010*\u001a\u00030\u0001H\u0001¢\u0006\u0006\b\u0001\u0010\u0001J#\u0010\u0001\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030N2\u0007\u0010*\u001a\u00030\u0001H\u0001¢\u0006\u0006\b\u0001\u0010\u0001J#\u0010\u0001\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030N2\u0007\u0010*\u001a\u00030\u0001H\u0001¢\u0006\u0006\b\u0001\u0010\u0001J#\u0010£\u0001\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030N2\u0007\u0010*\u001a\u00030 \u0001H\u0001¢\u0006\u0006\b¡\u0001\u0010¢\u0001J#\u0010§\u0001\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030N2\u0007\u0010*\u001a\u00030¤\u0001H\u0001¢\u0006\u0006\b¥\u0001\u0010¦\u0001J#\u0010«\u0001\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030N2\u0007\u0010*\u001a\u00030¨\u0001H\u0001¢\u0006\u0006\b©\u0001\u0010ª\u0001J#\u0010¯\u0001\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030N2\u0007\u0010*\u001a\u00030¬\u0001H\u0001¢\u0006\u0006\b­\u0001\u0010®\u0001J#\u0010³\u0001\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030N2\u0007\u0010*\u001a\u00030°\u0001H\u0001¢\u0006\u0006\b±\u0001\u0010²\u0001J\u001a\u0010¶\u0001\u001a\u00020T2\u0006\u0010\u0019\u001a\u00020\u0018H\u0001¢\u0006\u0006\b´\u0001\u0010µ\u0001J#\u0010»\u0001\u001a\u00030¬\u00012\u000e\u0010¸\u0001\u001a\t\u0012\u0004\u0012\u00020+0·\u0001H\u0001¢\u0006\u0006\b¹\u0001\u0010º\u0001J\u0012\u0010¾\u0001\u001a\u00020XH\u0001¢\u0006\u0006\b¼\u0001\u0010½\u0001J\u0012\u0010Á\u0001\u001a\u00020\\H\u0001¢\u0006\u0006\b¿\u0001\u0010À\u0001J\u0012\u0010Ä\u0001\u001a\u00020rH\u0001¢\u0006\u0006\bÂ\u0001\u0010Ã\u0001J\u0012\u0010Ç\u0001\u001a\u00020vH\u0001¢\u0006\u0006\bÅ\u0001\u0010Æ\u0001J\u0013\u0010Ë\u0001\u001a\u00030È\u0001H\u0001¢\u0006\u0006\bÉ\u0001\u0010Ê\u0001J#\u0010Î\u0001\u001a\u00020z2\u0007\u0010\u000f\u001a\u00030È\u00012\u0006\u0010\u0017\u001a\u00020\u0016H\u0001¢\u0006\u0006\bÌ\u0001\u0010Í\u0001J\u0013\u0010Ò\u0001\u001a\u00030Ï\u0001H\u0001¢\u0006\u0006\bÐ\u0001\u0010Ñ\u0001J\u001b\u0010Õ\u0001\u001a\u00020|2\u0007\u0010\u000f\u001a\u00030Ï\u0001H\u0001¢\u0006\u0006\bÓ\u0001\u0010Ô\u0001J\u0013\u0010Ø\u0001\u001a\u00030\u0001H\u0001¢\u0006\u0006\bÖ\u0001\u0010×\u0001J\u0013\u0010Û\u0001\u001a\u00030\u0001H\u0001¢\u0006\u0006\bÙ\u0001\u0010Ú\u0001J\u0013\u0010Þ\u0001\u001a\u00030\u0001H\u0001¢\u0006\u0006\bÜ\u0001\u0010Ý\u0001J\u0013\u0010á\u0001\u001a\u00030\u0001H\u0001¢\u0006\u0006\bß\u0001\u0010à\u0001J\u0013\u0010ä\u0001\u001a\u00030\u0001H\u0001¢\u0006\u0006\bâ\u0001\u0010ã\u0001J\u0013\u0010ç\u0001\u001a\u00030¤\u0001H\u0001¢\u0006\u0006\bå\u0001\u0010æ\u0001J\u0013\u0010ê\u0001\u001a\u00030\u0001H\u0001¢\u0006\u0006\bè\u0001\u0010é\u0001J\u0013\u0010í\u0001\u001a\u00030 \u0001H\u0001¢\u0006\u0006\bë\u0001\u0010ì\u0001J\u0013\u0010ð\u0001\u001a\u00030¨\u0001H\u0001¢\u0006\u0006\bî\u0001\u0010ï\u0001J\u0013\u0010ó\u0001\u001a\u00030°\u0001H\u0001¢\u0006\u0006\bñ\u0001\u0010ò\u0001J'\u0010ù\u0001\u001a\u00030ø\u00012\b\u0010õ\u0001\u001a\u00030ô\u00012\b\u0010÷\u0001\u001a\u00030ö\u0001H\u0007¢\u0006\u0006\bù\u0001\u0010ú\u0001J'\u0010þ\u0001\u001a\u00030û\u00012\b\u0010õ\u0001\u001a\u00030ô\u00012\b\u0010÷\u0001\u001a\u00030ö\u0001H\u0001¢\u0006\u0006\bü\u0001\u0010ý\u0001J'\u0010\u0002\u001a\u00030ÿ\u00012\b\u0010õ\u0001\u001a\u00030ô\u00012\b\u0010÷\u0001\u001a\u00030ö\u0001H\u0007¢\u0006\u0006\b\u0002\u0010\u0002J?\u0010\u0002\u001a\u00020%2\b\u0010\u0002\u001a\u00030\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u00162\b\u0010\u0002\u001a\u00030\u00022\u0007\u0010A\u001a\u00030\u0002H\u0007¢\u0006\u0006\b\u0002\u0010\u0002J\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020!0\u0002H\u0007¢\u0006\u0005\b\u0002\u0010\u0005RD\u0010\u0002\u001a-\u0012\u000f\u0012\r \u0002*\u0005\u0018\u00010\u00020\u0002 \u0002*\u0015\u0012\u000f\u0012\r \u0002*\u0005\u0018\u00010\u00020\u0002\u0018\u00010\u00020\u00028\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0002\u0010\u0002RD\u0010\u0002\u001a-\u0012\u000f\u0012\r \u0002*\u0005\u0018\u00010\u00020\u0002 \u0002*\u0015\u0012\u000f\u0012\r \u0002*\u0005\u0018\u00010\u00020\u0002\u0018\u00010\u00020\u00028\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0002\u0010\u0002RD\u0010\u0002\u001a-\u0012\u000f\u0012\r \u0002*\u0005\u0018\u00010\u00020\u0002 \u0002*\u0015\u0012\u000f\u0012\r \u0002*\u0005\u0018\u00010\u00020\u0002\u0018\u00010\u00020\u00028\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0002\u0010\u0002RD\u0010\u0002\u001a-\u0012\u000f\u0012\r \u0002*\u0005\u0018\u00010\u00020\u0002 \u0002*\u0015\u0012\u000f\u0012\r \u0002*\u0005\u0018\u00010\u00020\u0002\u0018\u00010\u00020\u00028\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0002\u0010\u0002RD\u0010\u0002\u001a-\u0012\u000f\u0012\r \u0002*\u0005\u0018\u00010\u00020\u0002 \u0002*\u0015\u0012\u000f\u0012\r \u0002*\u0005\u0018\u00010\u00020\u0002\u0018\u00010\u00020\u00028\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0002\u0010\u0002RD\u0010\u0002\u001a-\u0012\u000f\u0012\r \u0002*\u0005\u0018\u00010\u00020\u0002 \u0002*\u0015\u0012\u000f\u0012\r \u0002*\u0005\u0018\u00010\u00020\u0002\u0018\u00010\u00020\u00028\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0002\u0010\u0002RD\u0010 \u0002\u001a-\u0012\u000f\u0012\r \u0002*\u0005\u0018\u00010\u00020\u0002 \u0002*\u0015\u0012\u000f\u0012\r \u0002*\u0005\u0018\u00010\u00020\u0002\u0018\u00010\u00020\u00028\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0002\u0010\u0002RD\u0010£\u0002\u001a-\u0012\u000f\u0012\r \u0002*\u0005\u0018\u00010¡\u00020¡\u0002 \u0002*\u0015\u0012\u000f\u0012\r \u0002*\u0005\u0018\u00010¡\u00020¡\u0002\u0018\u00010\u00020\u00028\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b¢\u0002\u0010\u0002RD\u0010¦\u0002\u001a-\u0012\u000f\u0012\r \u0002*\u0005\u0018\u00010¤\u00020¤\u0002 \u0002*\u0015\u0012\u000f\u0012\r \u0002*\u0005\u0018\u00010¤\u00020¤\u0002\u0018\u00010\u00020\u00028\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b¥\u0002\u0010\u0002RD\u0010©\u0002\u001a-\u0012\u000f\u0012\r \u0002*\u0005\u0018\u00010§\u00020§\u0002 \u0002*\u0015\u0012\u000f\u0012\r \u0002*\u0005\u0018\u00010§\u00020§\u0002\u0018\u00010\u00020\u00028\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b¨\u0002\u0010\u0002R\u001c\u0010­\u0002\u001a\u0005\u0018\u00010ª\u00028\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b«\u0002\u0010¬\u0002RD\u0010°\u0002\u001a-\u0012\u000f\u0012\r \u0002*\u0005\u0018\u00010®\u00020®\u0002 \u0002*\u0015\u0012\u000f\u0012\r \u0002*\u0005\u0018\u00010®\u00020®\u0002\u0018\u00010\u00020\u00028\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b¯\u0002\u0010\u0002RD\u0010³\u0002\u001a-\u0012\u000f\u0012\r \u0002*\u0005\u0018\u00010±\u00020±\u0002 \u0002*\u0015\u0012\u000f\u0012\r \u0002*\u0005\u0018\u00010±\u00020±\u0002\u0018\u00010\u00020\u00028\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b²\u0002\u0010\u0002RD\u0010¶\u0002\u001a-\u0012\u000f\u0012\r \u0002*\u0005\u0018\u00010´\u00020´\u0002 \u0002*\u0015\u0012\u000f\u0012\r \u0002*\u0005\u0018\u00010´\u00020´\u0002\u0018\u00010\u00020\u00028\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bµ\u0002\u0010\u0002RD\u0010¸\u0002\u001a-\u0012\u000f\u0012\r \u0002*\u0005\u0018\u00010¤\u00020¤\u0002 \u0002*\u0015\u0012\u000f\u0012\r \u0002*\u0005\u0018\u00010¤\u00020¤\u0002\u0018\u00010\u00020\u00028\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b·\u0002\u0010\u0002RD\u0010»\u0002\u001a-\u0012\u000f\u0012\r \u0002*\u0005\u0018\u00010¹\u00020¹\u0002 \u0002*\u0015\u0012\u000f\u0012\r \u0002*\u0005\u0018\u00010¹\u00020¹\u0002\u0018\u00010\u00020\u00028\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bº\u0002\u0010\u0002RD\u0010¾\u0002\u001a-\u0012\u000f\u0012\r \u0002*\u0005\u0018\u00010¼\u00020¼\u0002 \u0002*\u0015\u0012\u000f\u0012\r \u0002*\u0005\u0018\u00010¼\u00020¼\u0002\u0018\u00010\u00020\u00028\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b½\u0002\u0010\u0002RD\u0010Á\u0002\u001a-\u0012\u000f\u0012\r \u0002*\u0005\u0018\u00010¿\u00020¿\u0002 \u0002*\u0015\u0012\u000f\u0012\r \u0002*\u0005\u0018\u00010¿\u00020¿\u0002\u0018\u00010\u00020\u00028\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bÀ\u0002\u0010\u0002RD\u0010Ã\u0002\u001a-\u0012\u000f\u0012\r \u0002*\u0005\u0018\u00010¡\u00020¡\u0002 \u0002*\u0015\u0012\u000f\u0012\r \u0002*\u0005\u0018\u00010¡\u00020¡\u0002\u0018\u00010\u00020\u00028\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bÂ\u0002\u0010\u0002RD\u0010Æ\u0002\u001a-\u0012\u000f\u0012\r \u0002*\u0005\u0018\u00010Ä\u00020Ä\u0002 \u0002*\u0015\u0012\u000f\u0012\r \u0002*\u0005\u0018\u00010Ä\u00020Ä\u0002\u0018\u00010\u00020\u00028\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bÅ\u0002\u0010\u0002RD\u0010É\u0002\u001a-\u0012\u000f\u0012\r \u0002*\u0005\u0018\u00010Ç\u00020Ç\u0002 \u0002*\u0015\u0012\u000f\u0012\r \u0002*\u0005\u0018\u00010Ç\u00020Ç\u0002\u0018\u00010\u00020\u00028\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bÈ\u0002\u0010\u0002RD\u0010Ì\u0002\u001a-\u0012\u000f\u0012\r \u0002*\u0005\u0018\u00010Ê\u00020Ê\u0002 \u0002*\u0015\u0012\u000f\u0012\r \u0002*\u0005\u0018\u00010Ê\u00020Ê\u0002\u0018\u00010\u00020\u00028\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bË\u0002\u0010\u0002R\u001a\u0010Ð\u0002\u001a\u00030Í\u00028\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bÎ\u0002\u0010Ï\u0002¨\u0006Õ\u0002"}, d2 = {"Lcom/avito/android/profile/di/UserProfileModule;", "", "Lcom/jakewharton/rxrelay2/PublishRelay;", "Lcom/avito/android/deep_linking/links/DeepLink;", "provideDeeplinkClickStream", "()Lcom/jakewharton/rxrelay2/PublishRelay;", "Lcom/avito/android/profile/UserProfileInteractor;", "interactor", "Lcom/avito/android/profile/UserProfileItemConverter;", "converter", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lcom/avito/android/profile/cards/UserProfileResourceProvider;", "resourceProvider", "Lcom/avito/android/account/AccountInteractor;", "accountInteractor", "Lcom/avito/android/account/AccountStorageInteractor;", "accountStorageInteractor", "Lcom/avito/android/social/Logoutable;", "logoutable", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/dialog/DialogPresenter;", "dialogPresenter", "Lcom/avito/android/error_helper/ErrorHelper;", "errorHelper", "Lcom/avito/android/code_confirmation/timer/RxTimer;", "rxTimer", "deeplinkClickStream", "Lcom/avito/android/profile/cards/CardItem$TfaSettingsCardItem;", "tfaSettingsClickStream", "Lcom/avito/android/analytics/screen/UserProfileTracker;", "tracker", "Lcom/avito/android/profile/header/ProfileHeaderPresenter;", "headerPresenter", "Lcom/avito/android/profile/UserProfilePresenter;", "providePresenter", "(Lcom/avito/android/profile/UserProfileInteractor;Lcom/avito/android/profile/UserProfileItemConverter;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/android/profile/cards/UserProfileResourceProvider;Lcom/avito/android/account/AccountInteractor;Lcom/avito/android/account/AccountStorageInteractor;Lcom/avito/android/social/Logoutable;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/Features;Lcom/avito/android/dialog/DialogPresenter;Lcom/avito/android/error_helper/ErrorHelper;Lcom/avito/android/code_confirmation/timer/RxTimer;Lcom/jakewharton/rxrelay2/PublishRelay;Lcom/jakewharton/rxrelay2/PublishRelay;Lcom/avito/android/analytics/screen/UserProfileTracker;Lcom/avito/android/profile/header/ProfileHeaderPresenter;)Lcom/avito/android/profile/UserProfilePresenter;", "presenter", "Lcom/avito/android/deep_linking/links/OnDeepLinkClickListener;", "provideDeepLinkClickListener", "(Lcom/avito/android/profile/UserProfilePresenter;)Lcom/avito/android/deep_linking/links/OnDeepLinkClickListener;", "Lcom/avito/android/social/GoogleSocialManager;", "googleSocialLogout", "Lcom/avito/android/social/FacebookSocialManager;", "facebookSocialManager", "Lcom/avito/android/social/OdnoklassnikiSocialManager;", "odnoklassnikiSocialManager", "Lcom/avito/android/social/VkontakteSocialManager;", "vkontakteSocialManager", "provideLogoutable$profile_release", "(Lcom/avito/android/social/GoogleSocialManager;Lcom/avito/android/social/FacebookSocialManager;Lcom/avito/android/social/OdnoklassnikiSocialManager;Lcom/avito/android/social/VkontakteSocialManager;)Lcom/avito/android/social/Logoutable;", "provideLogoutable", "Lcom/avito/android/remote/ProfileApi;", "api", "Lcom/avito/android/code_confirmation/CodeConfirmationInteractor;", "codeConfirmationInteractor", "provideInteractor", "(Lcom/avito/android/remote/ProfileApi;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/code_confirmation/CodeConfirmationInteractor;)Lcom/avito/android/profile/UserProfileInteractor;", "provideConverter", "(Lcom/avito/android/Features;)Lcom/avito/android/profile/UserProfileItemConverter;", "schedulersFactory", "provideRxTimer$profile_release", "(Lcom/avito/android/util/SchedulersFactory;)Lcom/avito/android/code_confirmation/timer/RxTimer;", "provideRxTimer", "Lcom/avito/konveyor/ItemBinder;", GeoContract.PROVIDER, "provideAdapterPresenter$profile_release", "(Lcom/avito/konveyor/ItemBinder;)Lcom/avito/konveyor/adapter/AdapterPresenter;", "provideAdapterPresenter", "provideUserProfileResourceProvider$profile_release", "()Lcom/avito/android/profile/cards/UserProfileResourceProvider;", "provideUserProfileResourceProvider", "", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lkotlin/jvm/JvmSuppressWildcards;", "blueprints", "provideItemBinder$profile_release", "(Ljava/util/Set;)Lcom/avito/konveyor/ItemBinder;", "provideItemBinder", "Lcom/avito/android/profile/cards/InfoCardItemPresenter;", "provideInfoCardBlueprint$profile_release", "(Lcom/avito/android/profile/cards/InfoCardItemPresenter;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "provideInfoCardBlueprint", "Lcom/avito/android/profile/cards/AdvertsCardItemPresenter;", "provideAdvertsCardBlueprint$profile_release", "(Lcom/avito/android/profile/cards/AdvertsCardItemPresenter;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "provideAdvertsCardBlueprint", "Lcom/avito/android/profile/cards/wallet/action/ActionWalletCardItemPresenter;", "provideActionWalletCardBlueprint$profile_release", "(Lcom/avito/android/profile/cards/wallet/action/ActionWalletCardItemPresenter;Lcom/avito/android/Features;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "provideActionWalletCardBlueprint", "Lcom/avito/android/util/text/AttributedTextFormatter;", "providesAttributedTextFormatter", "()Lcom/avito/android/util/text/AttributedTextFormatter;", "Lcom/avito/android/profile/cards/verified_profile/VerifiedProfileCardPresenter;", "provideVerifiedProfileCardBlueprint$profile_release", "(Lcom/avito/android/profile/cards/verified_profile/VerifiedProfileCardPresenter;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "provideVerifiedProfileCardBlueprint", "provideVerifiedProfileCardPresenter$profile_release", "()Lcom/avito/android/profile/cards/verified_profile/VerifiedProfileCardPresenter;", "provideVerifiedProfileCardPresenter", "Lcom/avito/android/profile/cards/verification/VerificationCardPresenter;", "attributedTextFormatter", "provideVerificationCardBlueprint$profile_release", "(Lcom/avito/android/profile/cards/verification/VerificationCardPresenter;Lcom/avito/android/util/text/AttributedTextFormatter;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "provideVerificationCardBlueprint", "provideVerificationCardPresenter$profile_release", "(Lcom/jakewharton/rxrelay2/PublishRelay;)Lcom/avito/android/profile/cards/verification/VerificationCardPresenter;", "provideVerificationCardPresenter", "Lcom/avito/android/profile/cards/wallet/separate_action/SeparateWalletCardWithActionItemPresenter;", "provideSeparateWalletCardWithActionBlueprint$profile_release", "(Lcom/avito/android/profile/cards/wallet/separate_action/SeparateWalletCardWithActionItemPresenter;Lcom/avito/android/Features;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "provideSeparateWalletCardWithActionBlueprint", "Lcom/avito/android/profile/cards/SocialCardItemPresenter;", "provideSocialCardBlueprint$profile_release", "(Lcom/avito/android/profile/cards/SocialCardItemPresenter;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "provideSocialCardBlueprint", "Lcom/avito/android/profile/cards/phones/PhonesCardItemPresenterOld;", "presenterOld", "Lcom/avito/android/profile/cards/phones/PhonesCardItemPresenter;", "providePhonesCardBlueprint$profile_release", "(Lcom/avito/android/profile/cards/phones/PhonesCardItemPresenterOld;Lcom/avito/android/profile/cards/phones/PhonesCardItemPresenter;Lcom/avito/android/Features;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "providePhonesCardBlueprint", "Lcom/avito/android/profile/cards/phones_empty/PhonesEmptyCardItemPresenter;", "providePhonesEmptyCardBlueprint$profile_release", "(Lcom/avito/android/profile/cards/phones_empty/PhonesEmptyCardItemPresenter;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "providePhonesEmptyCardBlueprint", "providePhonesEmptyCardItemPresenter$profile_release", "()Lcom/avito/android/profile/cards/phones_empty/PhonesEmptyCardItemPresenter;", "providePhonesEmptyCardItemPresenter", "Lcom/avito/android/profile/cards/ReviewsCardItemPresenter;", "provideReviewsCardBlueprint$profile_release", "(Lcom/avito/android/profile/cards/ReviewsCardItemPresenter;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "provideReviewsCardBlueprint", "Lcom/avito/android/profile/cards/ContactsCardItemPresenter;", "provideContactsCardBlueprint$profile_release", "(Lcom/avito/android/profile/cards/ContactsCardItemPresenter;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "provideContactsCardBlueprint", "Lcom/avito/android/profile/cards/SubscriptionCardItemPresenter;", "formatter", "provideSubscriptionCardBlueprint$profile_release", "(Lcom/avito/android/profile/cards/SubscriptionCardItemPresenter;Lcom/avito/android/util/text/AttributedTextFormatter;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "provideSubscriptionCardBlueprint", "Lcom/avito/android/profile/cards/LfPackagesCardItemPresenter;", "provideLfPackagesCardBlueprint$profile_release", "(Lcom/avito/android/profile/cards/LfPackagesCardItemPresenter;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "provideLfPackagesCardBlueprint", "Lcom/avito/android/profile/cards/ShopSettingsCardItemPresenter;", "provideShopSettingsCardBlueprint$profile_release", "(Lcom/avito/android/profile/cards/ShopSettingsCardItemPresenter;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "provideShopSettingsCardBlueprint", "Lcom/avito/android/profile/cards/DeliverySettingsItemPresenter;", "provideDeliverySettingsCardBlueprint$profile_release", "(Lcom/avito/android/profile/cards/DeliverySettingsItemPresenter;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "provideDeliverySettingsCardBlueprint", "Lcom/avito/android/profile/cards/IncomeSettingsCardItemPresenter;", "provideIncomeSettingsCardBlueprint$profile_release", "(Lcom/avito/android/profile/cards/IncomeSettingsCardItemPresenter;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "provideIncomeSettingsCardBlueprint", "Lcom/avito/android/profile/cards/HelpCenterCardItemPresenter;", "provideHelpCenterCardBlueprint$profile_release", "(Lcom/avito/android/profile/cards/HelpCenterCardItemPresenter;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "provideHelpCenterCardBlueprint", "Lcom/avito/android/profile/cards/LogoutCardItemPresenter;", "provideLogoutCardBlueprint$profile_release", "(Lcom/avito/android/profile/cards/LogoutCardItemPresenter;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "provideLogoutCardBlueprint", "Lcom/avito/android/profile/cards/ExtensionsCardItemPresenter;", "provideExtensionCardBlueprint$profile_release", "(Lcom/avito/android/profile/cards/ExtensionsCardItemPresenter;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "provideExtensionCardBlueprint", "Lcom/avito/android/profile/cards/SubscribersCardItemPresenter;", "provideSubscribersCardBlueprint$profile_release", "(Lcom/avito/android/profile/cards/SubscribersCardItemPresenter;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "provideSubscribersCardBlueprint", "provideInfoCardItemPresenter$profile_release", "(Lcom/avito/android/Features;)Lcom/avito/android/profile/cards/InfoCardItemPresenter;", "provideInfoCardItemPresenter", "Ldagger/Lazy;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "provideExtensionsCardItemPresenter$profile_release", "(Ldagger/Lazy;)Lcom/avito/android/profile/cards/ExtensionsCardItemPresenter;", "provideExtensionsCardItemPresenter", "provideAdvertsCardItemPresenter$profile_release", "()Lcom/avito/android/profile/cards/AdvertsCardItemPresenter;", "provideAdvertsCardItemPresenter", "provideActionWalletCardItemPresenter$profile_release", "()Lcom/avito/android/profile/cards/wallet/action/ActionWalletCardItemPresenter;", "provideActionWalletCardItemPresenter", "provideSeparateWalletCardWithActionItemPresenter$profile_release", "()Lcom/avito/android/profile/cards/wallet/separate_action/SeparateWalletCardWithActionItemPresenter;", "provideSeparateWalletCardWithActionItemPresenter", "provideSocialCardItemPresenter$profile_release", "()Lcom/avito/android/profile/cards/SocialCardItemPresenter;", "provideSocialCardItemPresenter", "Lcom/avito/android/profile/cards/phones/PhonesActionResourceProvider;", "providePhonesActionResourceProvider$profile_release", "()Lcom/avito/android/profile/cards/phones/PhonesActionResourceProvider;", "providePhonesActionResourceProvider", "providePhonesCardItemPresenterOld$profile_release", "(Lcom/avito/android/profile/cards/phones/PhonesActionResourceProvider;Lcom/avito/android/analytics/Analytics;)Lcom/avito/android/profile/cards/phones/PhonesCardItemPresenterOld;", "providePhonesCardItemPresenterOld", "Lcom/avito/android/profile/cards/phones/PhonesCardItemResourceProvider;", "providePhonesCardResourceProvider$profile_release", "()Lcom/avito/android/profile/cards/phones/PhonesCardItemResourceProvider;", "providePhonesCardResourceProvider", "providePhonesCardItemPresenter$profile_release", "(Lcom/avito/android/profile/cards/phones/PhonesCardItemResourceProvider;)Lcom/avito/android/profile/cards/phones/PhonesCardItemPresenter;", "providePhonesCardItemPresenter", "provideSubscriptionCardItemPresenter$profile_release", "()Lcom/avito/android/profile/cards/SubscriptionCardItemPresenter;", "provideSubscriptionCardItemPresenter", "provideLfPackagesCardItemPresenter$profile_release", "()Lcom/avito/android/profile/cards/LfPackagesCardItemPresenter;", "provideLfPackagesCardItemPresenter", "provideShopSettingsCardItemPresenter$profile_release", "()Lcom/avito/android/profile/cards/ShopSettingsCardItemPresenter;", "provideShopSettingsCardItemPresenter", "provideReviewsCardItemPresenter$profile_release", "()Lcom/avito/android/profile/cards/ReviewsCardItemPresenter;", "provideReviewsCardItemPresenter", "provideContactsCardItemPresenter$profile_release", "()Lcom/avito/android/profile/cards/ContactsCardItemPresenter;", "provideContactsCardItemPresenter", "provideHelpCenterCardItemPresenter$profile_release", "()Lcom/avito/android/profile/cards/HelpCenterCardItemPresenter;", "provideHelpCenterCardItemPresenter", "provideDeliverySettingsItemPresenter$profile_release", "()Lcom/avito/android/profile/cards/DeliverySettingsItemPresenter;", "provideDeliverySettingsItemPresenter", "provideIncomeSettingsItemPresenter$profile_release", "()Lcom/avito/android/profile/cards/IncomeSettingsCardItemPresenter;", "provideIncomeSettingsItemPresenter", "provideLogoutCardItemPresenter$profile_release", "()Lcom/avito/android/profile/cards/LogoutCardItemPresenter;", "provideLogoutCardItemPresenter", "providerSubscribersCardItemPresenter$profile_release", "()Lcom/avito/android/profile/cards/SubscribersCardItemPresenter;", "providerSubscribersCardItemPresenter", "Lcom/avito/android/analytics/screens/tracker/ScreenTrackerFactory;", "screenTrackerFactory", "Lcom/avito/android/analytics/screens/TimerFactory;", "factory", "Lcom/avito/android/analytics/screens/tracker/ScreenInitTracker;", "providesScreenInitTracker", "(Lcom/avito/android/analytics/screens/tracker/ScreenTrackerFactory;Lcom/avito/android/analytics/screens/TimerFactory;)Lcom/avito/android/analytics/screens/tracker/ScreenInitTracker;", "Lcom/avito/android/analytics/screens/tracker/ScreenDiInjectTracker;", "providesScreenDiInjectTracker$profile_release", "(Lcom/avito/android/analytics/screens/tracker/ScreenTrackerFactory;Lcom/avito/android/analytics/screens/TimerFactory;)Lcom/avito/android/analytics/screens/tracker/ScreenDiInjectTracker;", "providesScreenDiInjectTracker", "Lcom/avito/android/analytics/screens/ScreenFlowTrackerProvider;", "providesScreenFlowTrackerProvider", "(Lcom/avito/android/analytics/screens/tracker/ScreenTrackerFactory;Lcom/avito/android/analytics/screens/TimerFactory;)Lcom/avito/android/analytics/screens/ScreenFlowTrackerProvider;", "Lcom/avito/android/ab_tests/configs/UserAdvertsTabTestGroup;", "userAdvertsTabTestGroup", "Lcom/avito/android/notification_center/counter/NotificationCenterCounterInteractor;", "notificationCenterCounterInteractor", "Lcom/avito/android/util/SchedulersFactory3;", "provideProfileHeaderPresenter", "(Lcom/avito/android/ab_tests/configs/UserAdvertsTabTestGroup;Lcom/avito/android/profile/cards/UserProfileResourceProvider;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/notification_center/counter/NotificationCenterCounterInteractor;Lcom/avito/android/util/SchedulersFactory3;)Lcom/avito/android/profile/header/ProfileHeaderPresenter;", "providesTfaSettingsClickStream", "Lcom/avito/android/profile/cards/CardItem$DeliverySettingsCardItem;", "kotlin.jvm.PlatformType", "o", "Lcom/jakewharton/rxrelay2/PublishRelay;", "deliverySettingsCardItemStream", "Lcom/avito/android/profile/cards/CardItem$SubscriptionCardItem;", "d", "subscriptionsCardItemStream", "Lcom/avito/android/profile/cards/CardItem$HelpCenterCardItem;", "p", "helpCenterCardItemStream", "Lcom/avito/android/profile/cards/CardItem$SocialCardItem;", g.a, "socialCardItemStream", "Lcom/avito/android/profile/cards/CardItem$IncomeSettingsCardItem;", "t", "incomeSettingsCardItemStream", "Lcom/avito/android/profile/cards/phones/PhonesCardItemPresenterOld$Action;", "j", "phonesCardActionsStream", "Lcom/avito/android/profile/cards/CardItem$LfPackagesCardItem;", "e", "lfPackagesCardItemStream", "Lcom/avito/android/profile/cards/CardItem$PhonesCardItem;", "i", "phonesCardManageStream", "Lcom/avito/android/profile/cards/CardItem$InfoCardItem;", AuthSource.BOOKING_ORDER, "infoCardRatingClickStream", "Lcom/avito/android/profile/cards/CardItem$SeparateWalletCardItem;", "s", "separateWalletCardItemStream", "Lcom/avito/android/util/Kundle;", "w", "Lcom/avito/android/util/Kundle;", "presenterState", "Lcom/avito/android/profile/cards/CardItem$AdvertsCardItem;", "c", "advertsCardItemStream", "Lcom/avito/android/profile/cards/CardItem$ShopSettingsCardItem;", "f", "shopSettingsCardItemStream", "Lcom/avito/android/profile/cards/CardItem$ContactsCardItem;", AuthSource.OPEN_CHANNEL_LIST, "contactsCardItemStream", AuthSource.SEND_ABUSE, "infoCardItemStream", "Lcom/avito/android/profile/cards/CardItem$SubscribersCardItem;", "r", "subscribersCardItemStream", "Lcom/avito/android/profile/cards/CardItem$ReviewsCardItem;", "l", "reviewsCardItemStream", "Lcom/avito/android/profile/cards/CardItem$LogoutCardItem;", "n", "logoutCardItemStream", "h", "phonesCardItemStream", "Lcom/avito/android/profile/cards/CardItem$PhonesEmptyCardItem;", "k", "phonesCardAddPhoneStream", "", "u", "urlClicksStream", "Lcom/avito/android/profile/cards/CardItem$WalletCardItem;", VKApiConst.Q, "walletCardItemStream", "Landroid/content/res/Resources;", VKApiConst.VERSION, "Landroid/content/res/Resources;", "resources", "<init>", "(Landroid/content/res/Resources;Lcom/avito/android/util/Kundle;)V", "Dependencies", "Tracker", "profile_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {SocialModule.class, Dependencies.class, ActionItemModule.class, ProfileSessionsItemModule.class, TfaSettingsItemModule.class, CartFabModule.class})
public final class UserProfileModule {
    public final PublishRelay<CardItem.InfoCardItem> a = PublishRelay.create();
    public final PublishRelay<CardItem.InfoCardItem> b = PublishRelay.create();
    public final PublishRelay<CardItem.AdvertsCardItem> c = PublishRelay.create();
    public final PublishRelay<CardItem.SubscriptionCardItem> d = PublishRelay.create();
    public final PublishRelay<CardItem.LfPackagesCardItem> e = PublishRelay.create();
    public final PublishRelay<CardItem.ShopSettingsCardItem> f = PublishRelay.create();
    public final PublishRelay<CardItem.SocialCardItem> g = PublishRelay.create();
    public final PublishRelay<CardItem.PhonesCardItem> h = PublishRelay.create();
    public final PublishRelay<CardItem.PhonesCardItem> i = PublishRelay.create();
    public final PublishRelay<PhonesCardItemPresenterOld.Action> j = PublishRelay.create();
    public final PublishRelay<CardItem.PhonesEmptyCardItem> k = PublishRelay.create();
    public final PublishRelay<CardItem.ReviewsCardItem> l = PublishRelay.create();
    public final PublishRelay<CardItem.ContactsCardItem> m = PublishRelay.create();
    public final PublishRelay<CardItem.LogoutCardItem> n = PublishRelay.create();
    public final PublishRelay<CardItem.DeliverySettingsCardItem> o = PublishRelay.create();
    public final PublishRelay<CardItem.HelpCenterCardItem> p = PublishRelay.create();
    public final PublishRelay<CardItem.WalletCardItem> q = PublishRelay.create();
    public final PublishRelay<CardItem.SubscribersCardItem> r = PublishRelay.create();
    public final PublishRelay<CardItem.SeparateWalletCardItem> s = PublishRelay.create();
    public final PublishRelay<CardItem.IncomeSettingsCardItem> t = PublishRelay.create();
    public final PublishRelay<String> u = PublishRelay.create();
    public final Resources v;
    public final Kundle w;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J#\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\n2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H'¢\u0006\u0004\b\u000b\u0010\fJ#\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\n2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\r0\u0007H'¢\u0006\u0004\b\u000e\u0010\fJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u000fH'¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0015\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00142\u0006\u0010\t\u001a\u00020\u0013H'¢\u0006\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/avito/android/profile/di/UserProfileModule$Dependencies;", "", "Lcom/avito/android/analytics/screen/UserProfileTrackerImpl;", "tracker", "Lcom/avito/android/analytics/screen/UserProfileTracker;", "bindTracker", "(Lcom/avito/android/analytics/screen/UserProfileTrackerImpl;)Lcom/avito/android/analytics/screen/UserProfileTracker;", "Lcom/jakewharton/rxrelay2/PublishRelay;", "Lcom/avito/android/deep_linking/links/DeepLink;", "impl", "Lio/reactivex/functions/Consumer;", "bindsDeeplinkClickStream", "(Lcom/jakewharton/rxrelay2/PublishRelay;)Lio/reactivex/functions/Consumer;", "Lcom/avito/android/profile/cards/CardItem$TfaSettingsCardItem;", "bindsTfaSettingsClickStream", "Lcom/avito/android/profile/cards/verification_platform/VerificationPlatformCardPresenterImpl;", "Lcom/avito/android/profile/cards/verification_platform/VerificationPlatformCardPresenter;", "bindsVerificationPlatformCardPresenter", "(Lcom/avito/android/profile/cards/verification_platform/VerificationPlatformCardPresenterImpl;)Lcom/avito/android/profile/cards/verification_platform/VerificationPlatformCardPresenter;", "Lcom/avito/android/profile/cards/verification_platform/VerificationPlatformCardBlueprint;", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "bindsVerificationPlatformCardBlueprint", "(Lcom/avito/android/profile/cards/verification_platform/VerificationPlatformCardBlueprint;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "profile_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Dependencies {
        @PerActivity
        @Binds
        @NotNull
        UserProfileTracker bindTracker(@NotNull UserProfileTrackerImpl userProfileTrackerImpl);

        @Binds
        @NotNull
        @PerActivity
        Consumer<DeepLink> bindsDeeplinkClickStream(@NotNull PublishRelay<DeepLink> publishRelay);

        @Binds
        @NotNull
        @PerActivity
        Consumer<CardItem.TfaSettingsCardItem> bindsTfaSettingsClickStream(@NotNull PublishRelay<CardItem.TfaSettingsCardItem> publishRelay);

        @Binds
        @IntoSet
        @NotNull
        @PerActivity
        ItemBlueprint<?, ?> bindsVerificationPlatformCardBlueprint(@NotNull VerificationPlatformCardBlueprint verificationPlatformCardBlueprint);

        @PerActivity
        @Binds
        @NotNull
        VerificationPlatformCardPresenter bindsVerificationPlatformCardPresenter(@NotNull VerificationPlatformCardPresenterImpl verificationPlatformCardPresenterImpl);
    }

    @Qualifier
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/profile/di/UserProfileModule$Tracker;", "", "<init>", "()V", "profile_release"}, k = 1, mv = {1, 4, 2})
    @Retention(RetentionPolicy.RUNTIME)
    @kotlin.annotation.Retention
    public @interface Tracker {
    }

    public UserProfileModule(@NotNull Resources resources, @Nullable Kundle kundle) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        this.v = resources;
        this.w = kundle;
    }

    @Provides
    @IntoSet
    @NotNull
    @PerActivity
    public final ItemBlueprint<?, ?> provideActionWalletCardBlueprint$profile_release(@NotNull ActionWalletCardItemPresenter actionWalletCardItemPresenter, @NotNull Features features) {
        Intrinsics.checkNotNullParameter(actionWalletCardItemPresenter, "presenter");
        Intrinsics.checkNotNullParameter(features, "features");
        return new ActionWalletCardBlueprint(actionWalletCardItemPresenter, features);
    }

    @Provides
    @PerActivity
    @NotNull
    public final ActionWalletCardItemPresenter provideActionWalletCardItemPresenter$profile_release() {
        PublishRelay<CardItem.WalletCardItem> publishRelay = this.q;
        Intrinsics.checkNotNullExpressionValue(publishRelay, "walletCardItemStream");
        return new ActionWalletCardItemPresenterImpl(publishRelay);
    }

    @Provides
    @PerActivity
    @NotNull
    public final AdapterPresenter provideAdapterPresenter$profile_release(@NotNull ItemBinder itemBinder) {
        return a.D1(itemBinder, GeoContract.PROVIDER, itemBinder, itemBinder);
    }

    @Provides
    @IntoSet
    @NotNull
    @PerActivity
    public final ItemBlueprint<?, ?> provideAdvertsCardBlueprint$profile_release(@NotNull AdvertsCardItemPresenter advertsCardItemPresenter) {
        Intrinsics.checkNotNullParameter(advertsCardItemPresenter, "presenter");
        return new AdvertsCardBlueprint(advertsCardItemPresenter);
    }

    @Provides
    @PerActivity
    @NotNull
    public final AdvertsCardItemPresenter provideAdvertsCardItemPresenter$profile_release() {
        PublishRelay<CardItem.AdvertsCardItem> publishRelay = this.c;
        Intrinsics.checkNotNullExpressionValue(publishRelay, "advertsCardItemStream");
        return new AdvertsCardItemPresenterImpl(publishRelay);
    }

    @Provides
    @IntoSet
    @NotNull
    @PerActivity
    public final ItemBlueprint<?, ?> provideContactsCardBlueprint$profile_release(@NotNull ContactsCardItemPresenter contactsCardItemPresenter) {
        Intrinsics.checkNotNullParameter(contactsCardItemPresenter, "presenter");
        return new ContactsCardBlueprint(contactsCardItemPresenter);
    }

    @Provides
    @PerActivity
    @NotNull
    public final ContactsCardItemPresenter provideContactsCardItemPresenter$profile_release() {
        PublishRelay<CardItem.ContactsCardItem> publishRelay = this.m;
        Intrinsics.checkNotNullExpressionValue(publishRelay, "contactsCardItemStream");
        return new ContactsCardItemPresenterImpl(publishRelay);
    }

    @Provides
    @PerActivity
    @NotNull
    public final UserProfileItemConverter provideConverter(@NotNull Features features) {
        Intrinsics.checkNotNullParameter(features, "features");
        return new UserProfileItemConverterImpl(features);
    }

    @Provides
    @PerActivity
    @NotNull
    public final OnDeepLinkClickListener provideDeepLinkClickListener(@NotNull UserProfilePresenter userProfilePresenter) {
        Intrinsics.checkNotNullParameter(userProfilePresenter, "presenter");
        return userProfilePresenter;
    }

    @Provides
    @NotNull
    @PerActivity
    public final PublishRelay<DeepLink> provideDeeplinkClickStream() {
        PublishRelay<DeepLink> create = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create, "PublishRelay.create<DeepLink>()");
        return create;
    }

    @Provides
    @IntoSet
    @NotNull
    @PerActivity
    public final ItemBlueprint<?, ?> provideDeliverySettingsCardBlueprint$profile_release(@NotNull DeliverySettingsItemPresenter deliverySettingsItemPresenter) {
        Intrinsics.checkNotNullParameter(deliverySettingsItemPresenter, "presenter");
        return new DeliverySettingsCardBlueprint(deliverySettingsItemPresenter);
    }

    @Provides
    @PerActivity
    @NotNull
    public final DeliverySettingsItemPresenter provideDeliverySettingsItemPresenter$profile_release() {
        PublishRelay<CardItem.DeliverySettingsCardItem> publishRelay = this.o;
        Intrinsics.checkNotNullExpressionValue(publishRelay, "deliverySettingsCardItemStream");
        return new DeliverySettingsItemPresenterImpl(publishRelay);
    }

    @Provides
    @IntoSet
    @NotNull
    @PerActivity
    public final ItemBlueprint<?, ?> provideExtensionCardBlueprint$profile_release(@NotNull ExtensionsCardItemPresenter extensionsCardItemPresenter) {
        Intrinsics.checkNotNullParameter(extensionsCardItemPresenter, "presenter");
        return new ExtensionsCardBlueprint(extensionsCardItemPresenter);
    }

    @Provides
    @NotNull
    @PerActivity
    public final ExtensionsCardItemPresenter provideExtensionsCardItemPresenter$profile_release(@NotNull Lazy<OnDeepLinkClickListener> lazy) {
        Intrinsics.checkNotNullParameter(lazy, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        return new ExtensionsCardItemPresenterImpl(lazy);
    }

    @Provides
    @IntoSet
    @NotNull
    @PerActivity
    public final ItemBlueprint<?, ?> provideHelpCenterCardBlueprint$profile_release(@NotNull HelpCenterCardItemPresenter helpCenterCardItemPresenter) {
        Intrinsics.checkNotNullParameter(helpCenterCardItemPresenter, "presenter");
        return new HelpCenterCardBlueprint(helpCenterCardItemPresenter);
    }

    @Provides
    @PerActivity
    @NotNull
    public final HelpCenterCardItemPresenter provideHelpCenterCardItemPresenter$profile_release() {
        PublishRelay<CardItem.HelpCenterCardItem> publishRelay = this.p;
        Intrinsics.checkNotNullExpressionValue(publishRelay, "helpCenterCardItemStream");
        return new HelpCenterCardItemPresenterImpl(publishRelay);
    }

    @Provides
    @IntoSet
    @NotNull
    @PerActivity
    public final ItemBlueprint<?, ?> provideIncomeSettingsCardBlueprint$profile_release(@NotNull IncomeSettingsCardItemPresenter incomeSettingsCardItemPresenter) {
        Intrinsics.checkNotNullParameter(incomeSettingsCardItemPresenter, "presenter");
        return new IncomeSettingsCardBlueprint(incomeSettingsCardItemPresenter);
    }

    @Provides
    @PerActivity
    @NotNull
    public final IncomeSettingsCardItemPresenter provideIncomeSettingsItemPresenter$profile_release() {
        PublishRelay<CardItem.IncomeSettingsCardItem> publishRelay = this.t;
        Intrinsics.checkNotNullExpressionValue(publishRelay, "incomeSettingsCardItemStream");
        return new IncomeSettingsCardItemPresenterImpl(publishRelay);
    }

    @Provides
    @IntoSet
    @NotNull
    @PerActivity
    public final ItemBlueprint<?, ?> provideInfoCardBlueprint$profile_release(@NotNull InfoCardItemPresenter infoCardItemPresenter) {
        Intrinsics.checkNotNullParameter(infoCardItemPresenter, "presenter");
        return new InfoCardBlueprint(infoCardItemPresenter);
    }

    @Provides
    @PerActivity
    @NotNull
    public final InfoCardItemPresenter provideInfoCardItemPresenter$profile_release(@NotNull Features features) {
        Intrinsics.checkNotNullParameter(features, "features");
        PublishRelay<CardItem.InfoCardItem> publishRelay = this.a;
        Intrinsics.checkNotNullExpressionValue(publishRelay, "infoCardItemStream");
        PublishRelay<CardItem.InfoCardItem> publishRelay2 = this.b;
        Intrinsics.checkNotNullExpressionValue(publishRelay2, "infoCardRatingClickStream");
        return new InfoCardItemPresenterImpl(publishRelay, publishRelay2, features);
    }

    @Provides
    @PerActivity
    @NotNull
    public final UserProfileInteractor provideInteractor(@NotNull ProfileApi profileApi, @NotNull SchedulersFactory schedulersFactory, @NotNull CodeConfirmationInteractor codeConfirmationInteractor) {
        Intrinsics.checkNotNullParameter(profileApi, "api");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(codeConfirmationInteractor, "codeConfirmationInteractor");
        return new UserProfileInteractorImpl(profileApi, schedulersFactory, codeConfirmationInteractor);
    }

    @Provides
    @NotNull
    @PerActivity
    public final ItemBinder provideItemBinder$profile_release(@NotNull Set<ItemBlueprint<?, ?>> set) {
        Intrinsics.checkNotNullParameter(set, "blueprints");
        ItemBinder.Builder builder = new ItemBinder.Builder();
        Iterator<T> it = set.iterator();
        while (it.hasNext()) {
            builder.registerItem(it.next());
        }
        return builder.build();
    }

    @Provides
    @IntoSet
    @NotNull
    @PerActivity
    public final ItemBlueprint<?, ?> provideLfPackagesCardBlueprint$profile_release(@NotNull LfPackagesCardItemPresenter lfPackagesCardItemPresenter) {
        Intrinsics.checkNotNullParameter(lfPackagesCardItemPresenter, "presenter");
        return new LfPackagesCardBlueprint(lfPackagesCardItemPresenter);
    }

    @Provides
    @PerActivity
    @NotNull
    public final LfPackagesCardItemPresenter provideLfPackagesCardItemPresenter$profile_release() {
        PublishRelay<CardItem.LfPackagesCardItem> publishRelay = this.e;
        Intrinsics.checkNotNullExpressionValue(publishRelay, "lfPackagesCardItemStream");
        return new LfPackagesCardItemPresenterImpl(publishRelay);
    }

    @Provides
    @IntoSet
    @NotNull
    @PerActivity
    public final ItemBlueprint<?, ?> provideLogoutCardBlueprint$profile_release(@NotNull LogoutCardItemPresenter logoutCardItemPresenter) {
        Intrinsics.checkNotNullParameter(logoutCardItemPresenter, "presenter");
        return new LogoutCardBlueprint(logoutCardItemPresenter);
    }

    @Provides
    @PerActivity
    @NotNull
    public final LogoutCardItemPresenter provideLogoutCardItemPresenter$profile_release() {
        PublishRelay<CardItem.LogoutCardItem> publishRelay = this.n;
        Intrinsics.checkNotNullExpressionValue(publishRelay, "logoutCardItemStream");
        return new LogoutCardItemPresenterImpl(publishRelay);
    }

    @Provides
    @PerActivity
    @NotNull
    public final Logoutable provideLogoutable$profile_release(@NotNull GoogleSocialManager googleSocialManager, @NotNull FacebookSocialManager facebookSocialManager, @NotNull OdnoklassnikiSocialManager odnoklassnikiSocialManager, @NotNull VkontakteSocialManager vkontakteSocialManager) {
        Intrinsics.checkNotNullParameter(googleSocialManager, "googleSocialLogout");
        Intrinsics.checkNotNullParameter(facebookSocialManager, "facebookSocialManager");
        Intrinsics.checkNotNullParameter(odnoklassnikiSocialManager, "odnoklassnikiSocialManager");
        Intrinsics.checkNotNullParameter(vkontakteSocialManager, "vkontakteSocialManager");
        return new LogoutableImpl(facebookSocialManager, googleSocialManager, odnoklassnikiSocialManager, vkontakteSocialManager);
    }

    @Provides
    @PerActivity
    @NotNull
    public final PhonesActionResourceProvider providePhonesActionResourceProvider$profile_release() {
        return new PhonesActionResourceProviderImpl(this.v);
    }

    @Provides
    @IntoSet
    @NotNull
    @PerActivity
    public final ItemBlueprint<?, ?> providePhonesCardBlueprint$profile_release(@NotNull PhonesCardItemPresenterOld phonesCardItemPresenterOld, @NotNull PhonesCardItemPresenter phonesCardItemPresenter, @NotNull Features features) {
        Intrinsics.checkNotNullParameter(phonesCardItemPresenterOld, "presenterOld");
        Intrinsics.checkNotNullParameter(phonesCardItemPresenter, "presenter");
        Intrinsics.checkNotNullParameter(features, "features");
        if (features.getPhonesListRedesign().invoke().booleanValue()) {
            return new PhonesCardBlueprint(phonesCardItemPresenter);
        }
        return new PhonesCardBlueprintOld(phonesCardItemPresenterOld);
    }

    @Provides
    @PerActivity
    @NotNull
    public final PhonesCardItemPresenter providePhonesCardItemPresenter$profile_release(@NotNull PhonesCardItemResourceProvider phonesCardItemResourceProvider) {
        Intrinsics.checkNotNullParameter(phonesCardItemResourceProvider, "resourceProvider");
        PublishRelay<CardItem.PhonesCardItem> publishRelay = this.i;
        Intrinsics.checkNotNullExpressionValue(publishRelay, "phonesCardManageStream");
        return new PhonesCardItemPresenterImpl(publishRelay, phonesCardItemResourceProvider);
    }

    @Provides
    @PerActivity
    @NotNull
    public final PhonesCardItemPresenterOld providePhonesCardItemPresenterOld$profile_release(@NotNull PhonesActionResourceProvider phonesActionResourceProvider, @NotNull Analytics analytics) {
        Intrinsics.checkNotNullParameter(phonesActionResourceProvider, "resourceProvider");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        PublishRelay<CardItem.PhonesCardItem> publishRelay = this.h;
        Intrinsics.checkNotNullExpressionValue(publishRelay, "phonesCardItemStream");
        PublishRelay<PhonesCardItemPresenterOld.Action> publishRelay2 = this.j;
        Intrinsics.checkNotNullExpressionValue(publishRelay2, "phonesCardActionsStream");
        return new PhonesCardItemPresenterOldImpl(publishRelay, publishRelay2, phonesActionResourceProvider, analytics);
    }

    @Provides
    @PerActivity
    @NotNull
    public final PhonesCardItemResourceProvider providePhonesCardResourceProvider$profile_release() {
        return new PhonesCardItemResourceProviderImpl(this.v);
    }

    @Provides
    @IntoSet
    @NotNull
    @PerActivity
    public final ItemBlueprint<?, ?> providePhonesEmptyCardBlueprint$profile_release(@NotNull PhonesEmptyCardItemPresenter phonesEmptyCardItemPresenter) {
        Intrinsics.checkNotNullParameter(phonesEmptyCardItemPresenter, "presenter");
        return new PhonesEmptyCardBlueprint(phonesEmptyCardItemPresenter);
    }

    @Provides
    @PerActivity
    @NotNull
    public final PhonesEmptyCardItemPresenter providePhonesEmptyCardItemPresenter$profile_release() {
        PublishRelay<CardItem.PhonesEmptyCardItem> publishRelay = this.k;
        Intrinsics.checkNotNullExpressionValue(publishRelay, "phonesCardAddPhoneStream");
        return new PhonesEmptyCardItemPresenterImpl(publishRelay);
    }

    @Provides
    @NotNull
    @PerActivity
    public final UserProfilePresenter providePresenter(@NotNull UserProfileInteractor userProfileInteractor, @NotNull UserProfileItemConverter userProfileItemConverter, @NotNull SchedulersFactory schedulersFactory, @NotNull AdapterPresenter adapterPresenter, @NotNull UserProfileResourceProvider userProfileResourceProvider, @NotNull AccountInteractor accountInteractor, @NotNull AccountStorageInteractor accountStorageInteractor, @NotNull Logoutable logoutable, @NotNull Analytics analytics, @NotNull Features features, @NotNull DialogPresenter dialogPresenter, @NotNull ErrorHelper errorHelper, @NotNull RxTimer rxTimer, @NotNull PublishRelay<DeepLink> publishRelay, @NotNull PublishRelay<CardItem.TfaSettingsCardItem> publishRelay2, @NotNull UserProfileTracker userProfileTracker, @NotNull ProfileHeaderPresenter profileHeaderPresenter) {
        Intrinsics.checkNotNullParameter(userProfileInteractor, "interactor");
        Intrinsics.checkNotNullParameter(userProfileItemConverter, "converter");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(adapterPresenter, "adapterPresenter");
        Intrinsics.checkNotNullParameter(userProfileResourceProvider, "resourceProvider");
        Intrinsics.checkNotNullParameter(accountInteractor, "accountInteractor");
        Intrinsics.checkNotNullParameter(accountStorageInteractor, "accountStorageInteractor");
        Intrinsics.checkNotNullParameter(logoutable, "logoutable");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(features, "features");
        Intrinsics.checkNotNullParameter(dialogPresenter, "dialogPresenter");
        Intrinsics.checkNotNullParameter(errorHelper, "errorHelper");
        Intrinsics.checkNotNullParameter(rxTimer, "rxTimer");
        Intrinsics.checkNotNullParameter(publishRelay, "deeplinkClickStream");
        Intrinsics.checkNotNullParameter(publishRelay2, "tfaSettingsClickStream");
        Intrinsics.checkNotNullParameter(userProfileTracker, "tracker");
        Intrinsics.checkNotNullParameter(profileHeaderPresenter, "headerPresenter");
        PublishRelay<CardItem.InfoCardItem> publishRelay3 = this.a;
        Intrinsics.checkNotNullExpressionValue(publishRelay3, "infoCardItemStream");
        PublishRelay<CardItem.InfoCardItem> publishRelay4 = this.b;
        Intrinsics.checkNotNullExpressionValue(publishRelay4, "infoCardRatingClickStream");
        PublishRelay<CardItem.AdvertsCardItem> publishRelay5 = this.c;
        Intrinsics.checkNotNullExpressionValue(publishRelay5, "advertsCardItemStream");
        PublishRelay<CardItem.SubscriptionCardItem> publishRelay6 = this.d;
        Intrinsics.checkNotNullExpressionValue(publishRelay6, "subscriptionsCardItemStream");
        PublishRelay<CardItem.LfPackagesCardItem> publishRelay7 = this.e;
        Intrinsics.checkNotNullExpressionValue(publishRelay7, "lfPackagesCardItemStream");
        PublishRelay<CardItem.ShopSettingsCardItem> publishRelay8 = this.f;
        Intrinsics.checkNotNullExpressionValue(publishRelay8, "shopSettingsCardItemStream");
        PublishRelay<CardItem.SocialCardItem> publishRelay9 = this.g;
        Intrinsics.checkNotNullExpressionValue(publishRelay9, "socialCardItemStream");
        PublishRelay<CardItem.PhonesCardItem> publishRelay10 = this.h;
        Intrinsics.checkNotNullExpressionValue(publishRelay10, "phonesCardItemStream");
        PublishRelay<CardItem.PhonesCardItem> publishRelay11 = this.i;
        Intrinsics.checkNotNullExpressionValue(publishRelay11, "phonesCardManageStream");
        PublishRelay<CardItem.PhonesEmptyCardItem> publishRelay12 = this.k;
        Intrinsics.checkNotNullExpressionValue(publishRelay12, "phonesCardAddPhoneStream");
        PublishRelay<CardItem.ReviewsCardItem> publishRelay13 = this.l;
        Intrinsics.checkNotNullExpressionValue(publishRelay13, "reviewsCardItemStream");
        PublishRelay<CardItem.ContactsCardItem> publishRelay14 = this.m;
        Intrinsics.checkNotNullExpressionValue(publishRelay14, "contactsCardItemStream");
        PublishRelay<CardItem.DeliverySettingsCardItem> publishRelay15 = this.o;
        Intrinsics.checkNotNullExpressionValue(publishRelay15, "deliverySettingsCardItemStream");
        PublishRelay<PhonesCardItemPresenterOld.Action> publishRelay16 = this.j;
        Intrinsics.checkNotNullExpressionValue(publishRelay16, "phonesCardActionsStream");
        PublishRelay<CardItem.HelpCenterCardItem> publishRelay17 = this.p;
        Intrinsics.checkNotNullExpressionValue(publishRelay17, "helpCenterCardItemStream");
        PublishRelay<CardItem.LogoutCardItem> publishRelay18 = this.n;
        Intrinsics.checkNotNullExpressionValue(publishRelay18, "logoutCardItemStream");
        PublishRelay<CardItem.WalletCardItem> publishRelay19 = this.q;
        Intrinsics.checkNotNullExpressionValue(publishRelay19, "walletCardItemStream");
        PublishRelay<CardItem.SeparateWalletCardItem> publishRelay20 = this.s;
        Intrinsics.checkNotNullExpressionValue(publishRelay20, "separateWalletCardItemStream");
        PublishRelay<CardItem.SubscribersCardItem> publishRelay21 = this.r;
        Intrinsics.checkNotNullExpressionValue(publishRelay21, "subscribersCardItemStream");
        PublishRelay<CardItem.IncomeSettingsCardItem> publishRelay22 = this.t;
        Intrinsics.checkNotNullExpressionValue(publishRelay22, "incomeSettingsCardItemStream");
        PublishRelay<String> publishRelay23 = this.u;
        Intrinsics.checkNotNullExpressionValue(publishRelay23, "urlClicksStream");
        return new UserProfilePresenterImpl(userProfileInteractor, userProfileItemConverter, schedulersFactory, adapterPresenter, userProfileResourceProvider, accountInteractor, accountStorageInteractor, logoutable, publishRelay3, publishRelay4, publishRelay5, publishRelay6, publishRelay7, publishRelay8, publishRelay9, publishRelay10, publishRelay11, publishRelay12, publishRelay13, publishRelay14, publishRelay15, publishRelay16, publishRelay17, publishRelay18, publishRelay19, publishRelay20, publishRelay21, publishRelay22, publishRelay, publishRelay2, publishRelay23, analytics, features, dialogPresenter, errorHelper, rxTimer, this.w, userProfileTracker, profileHeaderPresenter);
    }

    @Provides
    @PerActivity
    @NotNull
    public final ProfileHeaderPresenter provideProfileHeaderPresenter(@NotNull UserAdvertsTabTestGroup userAdvertsTabTestGroup, @NotNull UserProfileResourceProvider userProfileResourceProvider, @NotNull Analytics analytics, @NotNull NotificationCenterCounterInteractor notificationCenterCounterInteractor, @NotNull SchedulersFactory3 schedulersFactory3) {
        Intrinsics.checkNotNullParameter(userAdvertsTabTestGroup, "userAdvertsTabTestGroup");
        Intrinsics.checkNotNullParameter(userProfileResourceProvider, "resourceProvider");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(notificationCenterCounterInteractor, "notificationCenterCounterInteractor");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulersFactory");
        if (userAdvertsTabTestGroup.isTest()) {
            return new RootProfileHeaderPresenter(userProfileResourceProvider, analytics, notificationCenterCounterInteractor, schedulersFactory3);
        }
        return new DefaultProfileHeaderPresenter(userProfileResourceProvider, analytics);
    }

    @Provides
    @IntoSet
    @NotNull
    @PerActivity
    public final ItemBlueprint<?, ?> provideReviewsCardBlueprint$profile_release(@NotNull ReviewsCardItemPresenter reviewsCardItemPresenter) {
        Intrinsics.checkNotNullParameter(reviewsCardItemPresenter, "presenter");
        return new ReviewsCardBlueprint(reviewsCardItemPresenter);
    }

    @Provides
    @PerActivity
    @NotNull
    public final ReviewsCardItemPresenter provideReviewsCardItemPresenter$profile_release() {
        PublishRelay<CardItem.ReviewsCardItem> publishRelay = this.l;
        Intrinsics.checkNotNullExpressionValue(publishRelay, "reviewsCardItemStream");
        return new ReviewsCardItemPresenterImpl(publishRelay);
    }

    @Provides
    @PerActivity
    @NotNull
    public final RxTimer provideRxTimer$profile_release(@NotNull SchedulersFactory schedulersFactory) {
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulersFactory");
        return new RxTimerImpl(schedulersFactory);
    }

    @Provides
    @IntoSet
    @NotNull
    @PerActivity
    public final ItemBlueprint<?, ?> provideSeparateWalletCardWithActionBlueprint$profile_release(@NotNull SeparateWalletCardWithActionItemPresenter separateWalletCardWithActionItemPresenter, @NotNull Features features) {
        Intrinsics.checkNotNullParameter(separateWalletCardWithActionItemPresenter, "presenter");
        Intrinsics.checkNotNullParameter(features, "features");
        return new SeparateWalletCardWithActionBlueprint(separateWalletCardWithActionItemPresenter, features);
    }

    @Provides
    @PerActivity
    @NotNull
    public final SeparateWalletCardWithActionItemPresenter provideSeparateWalletCardWithActionItemPresenter$profile_release() {
        PublishRelay<CardItem.SeparateWalletCardItem> publishRelay = this.s;
        Intrinsics.checkNotNullExpressionValue(publishRelay, "separateWalletCardItemStream");
        return new SeparateWalletCardWithActionItemPresenterImpl(publishRelay);
    }

    @Provides
    @IntoSet
    @NotNull
    @PerActivity
    public final ItemBlueprint<?, ?> provideShopSettingsCardBlueprint$profile_release(@NotNull ShopSettingsCardItemPresenter shopSettingsCardItemPresenter) {
        Intrinsics.checkNotNullParameter(shopSettingsCardItemPresenter, "presenter");
        return new ShopSettingsCardBlueprint(shopSettingsCardItemPresenter);
    }

    @Provides
    @PerActivity
    @NotNull
    public final ShopSettingsCardItemPresenter provideShopSettingsCardItemPresenter$profile_release() {
        PublishRelay<CardItem.ShopSettingsCardItem> publishRelay = this.f;
        Intrinsics.checkNotNullExpressionValue(publishRelay, "shopSettingsCardItemStream");
        return new ShopSettingsCardItemPresenterImpl(publishRelay);
    }

    @Provides
    @IntoSet
    @NotNull
    @PerActivity
    public final ItemBlueprint<?, ?> provideSocialCardBlueprint$profile_release(@NotNull SocialCardItemPresenter socialCardItemPresenter) {
        Intrinsics.checkNotNullParameter(socialCardItemPresenter, "presenter");
        return new SocialCardBlueprint(socialCardItemPresenter);
    }

    @Provides
    @PerActivity
    @NotNull
    public final SocialCardItemPresenter provideSocialCardItemPresenter$profile_release() {
        PublishRelay<CardItem.SocialCardItem> publishRelay = this.g;
        Intrinsics.checkNotNullExpressionValue(publishRelay, "socialCardItemStream");
        return new SocialCardItemPresenterImpl(publishRelay);
    }

    @Provides
    @IntoSet
    @NotNull
    @PerActivity
    public final ItemBlueprint<?, ?> provideSubscribersCardBlueprint$profile_release(@NotNull SubscribersCardItemPresenter subscribersCardItemPresenter) {
        Intrinsics.checkNotNullParameter(subscribersCardItemPresenter, "presenter");
        return new SubscribersCardBlueprint(subscribersCardItemPresenter);
    }

    @Provides
    @IntoSet
    @NotNull
    @PerActivity
    public final ItemBlueprint<?, ?> provideSubscriptionCardBlueprint$profile_release(@NotNull SubscriptionCardItemPresenter subscriptionCardItemPresenter, @NotNull AttributedTextFormatter attributedTextFormatter) {
        Intrinsics.checkNotNullParameter(subscriptionCardItemPresenter, "presenter");
        Intrinsics.checkNotNullParameter(attributedTextFormatter, "formatter");
        return new SubscriptionCardBlueprint(subscriptionCardItemPresenter, attributedTextFormatter);
    }

    @Provides
    @PerActivity
    @NotNull
    public final SubscriptionCardItemPresenter provideSubscriptionCardItemPresenter$profile_release() {
        PublishRelay<CardItem.SubscriptionCardItem> publishRelay = this.d;
        Intrinsics.checkNotNullExpressionValue(publishRelay, "subscriptionsCardItemStream");
        return new SubscriptionCardItemPresenterImpl(publishRelay);
    }

    @Provides
    @PerActivity
    @NotNull
    public final UserProfileResourceProvider provideUserProfileResourceProvider$profile_release() {
        return new UserProfileResourceProviderImpl(this.v);
    }

    @Provides
    @IntoSet
    @NotNull
    @PerActivity
    public final ItemBlueprint<?, ?> provideVerificationCardBlueprint$profile_release(@NotNull VerificationCardPresenter verificationCardPresenter, @NotNull AttributedTextFormatter attributedTextFormatter) {
        Intrinsics.checkNotNullParameter(verificationCardPresenter, "presenter");
        Intrinsics.checkNotNullParameter(attributedTextFormatter, "attributedTextFormatter");
        return new VerificationCardBlueprint(verificationCardPresenter, attributedTextFormatter);
    }

    @Provides
    @NotNull
    @PerActivity
    public final VerificationCardPresenter provideVerificationCardPresenter$profile_release(@NotNull PublishRelay<DeepLink> publishRelay) {
        Intrinsics.checkNotNullParameter(publishRelay, "deeplinkClickStream");
        PublishRelay<String> publishRelay2 = this.u;
        Intrinsics.checkNotNullExpressionValue(publishRelay2, "urlClicksStream");
        return new VerificationCardPresenterImpl(publishRelay, publishRelay2);
    }

    @Provides
    @IntoSet
    @NotNull
    @PerActivity
    public final ItemBlueprint<?, ?> provideVerifiedProfileCardBlueprint$profile_release(@NotNull VerifiedProfileCardPresenter verifiedProfileCardPresenter) {
        Intrinsics.checkNotNullParameter(verifiedProfileCardPresenter, "presenter");
        return new VerifiedProfileCardBlueprint(verifiedProfileCardPresenter);
    }

    @Provides
    @PerActivity
    @NotNull
    public final VerifiedProfileCardPresenter provideVerifiedProfileCardPresenter$profile_release() {
        return new VerifiedProfileCardPresenterImpl();
    }

    @Provides
    @PerActivity
    @NotNull
    public final SubscribersCardItemPresenter providerSubscribersCardItemPresenter$profile_release() {
        PublishRelay<CardItem.SubscribersCardItem> publishRelay = this.r;
        Intrinsics.checkNotNullExpressionValue(publishRelay, "subscribersCardItemStream");
        return new SubscribersCardItemPresenterImpl(publishRelay);
    }

    @Provides
    @PerActivity
    @NotNull
    public final AttributedTextFormatter providesAttributedTextFormatter() {
        return new AttributedTextFormatterImpl();
    }

    @Provides
    @PerActivity
    @NotNull
    public final ScreenDiInjectTracker providesScreenDiInjectTracker$profile_release(@NotNull ScreenTrackerFactory screenTrackerFactory, @NotNull TimerFactory timerFactory) {
        Intrinsics.checkNotNullParameter(screenTrackerFactory, "screenTrackerFactory");
        Intrinsics.checkNotNullParameter(timerFactory, "factory");
        return ScreenTrackerFactory.DefaultImpls.createDiInjectTracker$default(screenTrackerFactory, UserProfileScreen.INSTANCE, timerFactory, null, 4, null);
    }

    @Provides
    @PerActivity
    @NotNull
    public final ScreenFlowTrackerProvider providesScreenFlowTrackerProvider(@NotNull ScreenTrackerFactory screenTrackerFactory, @NotNull TimerFactory timerFactory) {
        Intrinsics.checkNotNullParameter(screenTrackerFactory, "screenTrackerFactory");
        Intrinsics.checkNotNullParameter(timerFactory, "factory");
        return screenTrackerFactory.createScreenFlowTrackerProvider(UserProfileScreen.INSTANCE, timerFactory);
    }

    @Provides
    @PerActivity
    @NotNull
    public final ScreenInitTracker providesScreenInitTracker(@NotNull ScreenTrackerFactory screenTrackerFactory, @NotNull TimerFactory timerFactory) {
        Intrinsics.checkNotNullParameter(screenTrackerFactory, "screenTrackerFactory");
        Intrinsics.checkNotNullParameter(timerFactory, "factory");
        return ScreenTrackerFactory.DefaultImpls.createInitTracker$default(screenTrackerFactory, UserProfileScreen.INSTANCE, timerFactory, null, 4, null);
    }

    @Provides
    @NotNull
    @PerActivity
    public final PublishRelay<CardItem.TfaSettingsCardItem> providesTfaSettingsClickStream() {
        PublishRelay<CardItem.TfaSettingsCardItem> create = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create, "PublishRelay.create<Card…em.TfaSettingsCardItem>()");
        return create;
    }
}
