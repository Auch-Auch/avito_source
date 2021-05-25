package com.avito.android.photo_gallery.di;

import android.app.Application;
import android.content.res.Resources;
import com.avito.android.Features;
import com.avito.android.ab_tests.AdvertContactApplyWithoutChat;
import com.avito.android.ab_tests.AdvertDetailsNoCallFeedback;
import com.avito.android.ab_tests.AntiFraudCheckList;
import com.avito.android.ab_tests.JobApplicationProgressBar;
import com.avito.android.ab_tests.JustDialSellerPhoneTestGroup;
import com.avito.android.ab_tests.SendEmployersPhoneOnCallToSellerButtonClickInResumes;
import com.avito.android.ab_tests.configs.AntiFraudCheckListTestGroup;
import com.avito.android.ab_tests.groups.AdvertDetailsMarketplaceNoPurchaseFeedbackTestGroup;
import com.avito.android.ab_tests.groups.AdvertDetailsNoCallFeedbackTestGroup;
import com.avito.android.ab_tests.groups.SendEmployersPhoneOnCallToSellerButtonClickInResumesTestGroup;
import com.avito.android.ab_tests.groups.SimpleTestGroup;
import com.avito.android.ab_tests.groups.SimpleTestGroupWithControl2;
import com.avito.android.ab_tests.groups.SimpleTestGroupWithNone;
import com.avito.android.ab_tests.models.AbTestGroup;
import com.avito.android.ab_tests.models.ExposedAbTestGroup;
import com.avito.android.ab_tests.models.ManuallyExposedAbTestGroup;
import com.avito.android.ab_tests.models.SingleManuallyExposedAbTestGroup;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.advert_core.analytics.AdvertDetailsAnalyticsInteractor;
import com.avito.android.advert_core.analytics.AdvertDetailsAnalyticsInteractorImpl;
import com.avito.android.advert_core.analytics.broker.CreditBrokerAnalyticsInteractorNoOp;
import com.avito.android.advert_core.contactbar.AdvertActionIconFactory;
import com.avito.android.advert_core.contactbar.AdvertActionIconFactoryImpl;
import com.avito.android.advert_core.contactbar.AdvertContactsInteractor;
import com.avito.android.advert_core.contactbar.AdvertContactsInteractorImpl;
import com.avito.android.advert_core.contactbar.AdvertContactsPresenter;
import com.avito.android.advert_core.contactbar.AdvertContactsPresenterImpl;
import com.avito.android.advert_core.contactbar.AdvertContactsResourceProvider;
import com.avito.android.advert_core.contactbar.AdvertContactsResourceProviderImpl;
import com.avito.android.advert_core.contactbar.SourceScreen;
import com.avito.android.advert_core.contactbar.anti_fraud.AntiFraudPreferences;
import com.avito.android.advert_core.contactbar.anti_fraud.AntiFraudPreferencesImpl;
import com.avito.android.advert_core.contactbar.feedback.FeedbackInteractor;
import com.avito.android.advert_core.contactbar.feedback.FeedbackInteractorImpl;
import com.avito.android.advert_core.feedback.FeedbackPreferences;
import com.avito.android.advert_core.feedback.FeedbackPreferencesImpl;
import com.avito.android.advert_core.job.AdvertJobInteractor;
import com.avito.android.advert_core.job.AdvertJobInteractorImpl;
import com.avito.android.advert_core.messenger.AdvertMessengerInteractor;
import com.avito.android.advert_core.messenger.AdvertMessengerInteractorImpl;
import com.avito.android.advert_details.remote.AdvertDetailsApi;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.provider.TreeStateIdGenerator;
import com.avito.android.analytics.provider.clickstream.TreeClickStreamParent;
import com.avito.android.calls_shared.AppCallsUsageTracker;
import com.avito.android.di.CommercialBannersInteractorModule;
import com.avito.android.di.DialogRouterModule;
import com.avito.android.di.PerActivity;
import com.avito.android.permissions.PermissionChecker;
import com.avito.android.profile.ProfileInfoStorage;
import com.avito.android.remote.model.AdvertPrice;
import com.avito.android.serp.CommercialBannersAnalyticsInteractor;
import com.avito.android.util.AdvertPriceFormatter;
import com.avito.android.util.ErrorFormatterImpl;
import com.avito.android.util.Formatter;
import com.avito.android.util.PhoneNumberFormatterModule;
import com.avito.android.util.SchedulersFactory3;
import com.google.android.exoplayer2.util.MimeTypes;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.messenger.api.AvitoMessengerApi;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000ö\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001]B\t\b\u0002¢\u0006\u0004\b[\u0010\\J\u0002\u00108\u001a\u0002072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001b2\u000e\b\u0001\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d2\u000e\b\u0001\u0010\"\u001a\b\u0012\u0004\u0012\u00020!0 2\u000e\b\u0001\u0010%\u001a\b\u0012\u0004\u0012\u00020$0#2\u000e\b\u0001\u0010(\u001a\b\u0012\u0004\u0012\u00020'0&2\u000e\b\u0001\u0010*\u001a\b\u0012\u0004\u0012\u00020)0\u001d2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020+0#2\u000e\b\u0001\u0010.\u001a\b\u0012\u0004\u0012\u00020-0&2\u0006\u00100\u001a\u00020/2\u0006\u00102\u001a\u0002012\u0006\u00104\u001a\u0002032\u0006\u00106\u001a\u000205H\u0007¢\u0006\u0004\b8\u00109J\u0017\u0010<\u001a\u00020\u00102\u0006\u0010;\u001a\u00020:H\u0007¢\u0006\u0004\b<\u0010=JA\u0010F\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010?\u001a\u00020>2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010A\u001a\u00020@2\b\u0010C\u001a\u0004\u0018\u00010B2\u0006\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0004\bD\u0010EJ'\u0010K\u001a\u00020\f2\u0006\u0010H\u001a\u00020G2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u001bH\u0001¢\u0006\u0004\bI\u0010JJ\u001f\u0010P\u001a\u00020\u000e2\u0006\u0010M\u001a\u00020L2\u0006\u0010\u001c\u001a\u00020\u001bH\u0001¢\u0006\u0004\bN\u0010OJ\u001d\u0010V\u001a\b\u0012\u0004\u0012\u00020S0\u00142\u0006\u0010R\u001a\u00020QH\u0001¢\u0006\u0004\bT\u0010UJ%\u0010Y\u001a\b\u0012\u0004\u0012\u00020W0\u00142\u000e\b\u0001\u0010X\u001a\b\u0012\u0004\u0012\u00020W0\u0014H\u0007¢\u0006\u0004\bY\u0010Z¨\u0006^"}, d2 = {"Lcom/avito/android/photo_gallery/di/LegacyPhotoGalleryModule;", "", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/profile/ProfileInfoStorage;", "profileInfoStorage", "Lcom/avito/android/advert_core/analytics/AdvertDetailsAnalyticsInteractor;", "analyticsInteractor", "Lcom/avito/android/advert_core/contactbar/AdvertContactsInteractor;", "advertContactsInteractor", "Lcom/avito/android/advert_core/messenger/AdvertMessengerInteractor;", "advertMessengerInteractor", "Lcom/avito/android/advert_core/contactbar/feedback/FeedbackInteractor;", "feedbackInteractor", "Lcom/avito/android/advert_core/contactbar/AdvertActionIconFactory;", "advertActionIconFactory", "Lcom/avito/android/account/AccountStateProvider;", "accountStateProvider", "Lcom/avito/android/util/Formatter;", "Lcom/avito/android/remote/model/AdvertPrice;", "priceFormatter", "Lcom/avito/android/advert_core/contactbar/anti_fraud/AntiFraudPreferences;", "antiFraudPreferences", "Lcom/avito/android/advert_core/feedback/FeedbackPreferences;", "feedbackPreferences", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/avito/android/ab_tests/models/AbTestGroup;", "Lcom/avito/android/ab_tests/groups/SimpleTestGroupWithControl2;", "justDialSellerPhoneTestGroup", "Lcom/avito/android/ab_tests/models/SingleManuallyExposedAbTestGroup;", "Lcom/avito/android/ab_tests/configs/AntiFraudCheckListTestGroup;", "antiFraudCheckListTest", "Lcom/avito/android/ab_tests/models/ManuallyExposedAbTestGroup;", "Lcom/avito/android/ab_tests/groups/AdvertDetailsNoCallFeedbackTestGroup;", "advertDetailsNoCallFeedbackTestGroup", "Lcom/avito/android/ab_tests/models/ExposedAbTestGroup;", "Lcom/avito/android/ab_tests/groups/SimpleTestGroupWithNone;", "advertContactApplyWithoutChatTestGroup", "Lcom/avito/android/ab_tests/groups/SendEmployersPhoneOnCallToSellerButtonClickInResumesTestGroup;", "sendEmployersPhoneOnCallButtonClickInVacanciesTestGroup", "Lcom/avito/android/ab_tests/groups/AdvertDetailsMarketplaceNoPurchaseFeedbackTestGroup;", "marketplaceNoPurchaseFeedbackTestGroup", "Lcom/avito/android/ab_tests/groups/SimpleTestGroup;", "jobApplicationProgressBarTestGroup", "Lcom/avito/android/calls_shared/AppCallsUsageTracker;", "appCallUsageTracker", "Lcom/avito/android/advert_core/contactbar/AdvertContactsResourceProvider;", "resourceProvider", "Lcom/avito/android/permissions/PermissionChecker;", "permissionChecker", "Lcom/avito/android/advert_core/job/AdvertJobInteractor;", "advertJobInteractor", "Lcom/avito/android/advert_core/contactbar/AdvertContactsPresenter;", "provideAdvertContactsPresenter", "(Lcom/avito/android/Features;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/profile/ProfileInfoStorage;Lcom/avito/android/advert_core/analytics/AdvertDetailsAnalyticsInteractor;Lcom/avito/android/advert_core/contactbar/AdvertContactsInteractor;Lcom/avito/android/advert_core/messenger/AdvertMessengerInteractor;Lcom/avito/android/advert_core/contactbar/feedback/FeedbackInteractor;Lcom/avito/android/advert_core/contactbar/AdvertActionIconFactory;Lcom/avito/android/account/AccountStateProvider;Lcom/avito/android/util/Formatter;Lcom/avito/android/advert_core/contactbar/anti_fraud/AntiFraudPreferences;Lcom/avito/android/advert_core/feedback/FeedbackPreferences;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/ab_tests/models/AbTestGroup;Lcom/avito/android/ab_tests/models/SingleManuallyExposedAbTestGroup;Lcom/avito/android/ab_tests/models/ManuallyExposedAbTestGroup;Lcom/avito/android/ab_tests/models/ExposedAbTestGroup;Lcom/avito/android/ab_tests/models/AbTestGroup;Lcom/avito/android/ab_tests/models/ManuallyExposedAbTestGroup;Lcom/avito/android/ab_tests/models/ExposedAbTestGroup;Lcom/avito/android/calls_shared/AppCallsUsageTracker;Lcom/avito/android/advert_core/contactbar/AdvertContactsResourceProvider;Lcom/avito/android/permissions/PermissionChecker;Lcom/avito/android/advert_core/job/AdvertJobInteractor;)Lcom/avito/android/advert_core/contactbar/AdvertContactsPresenter;", "Landroid/app/Application;", MimeTypes.BASE_TYPE_APPLICATION, "provideAdvertActionIconFactory", "(Landroid/app/Application;)Lcom/avito/android/advert_core/contactbar/AdvertActionIconFactory;", "Lcom/avito/android/serp/CommercialBannersAnalyticsInteractor;", "commercialsAnalyticsInteractor", "Lcom/avito/android/analytics/provider/TreeStateIdGenerator;", "treeStateIdGenerator", "Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;", "treeParent", "provideAdvertDetailsAnalyticsInteractor$photo_gallery_release", "(Lcom/avito/android/analytics/Analytics;Lcom/avito/android/serp/CommercialBannersAnalyticsInteractor;Lcom/avito/android/account/AccountStateProvider;Lcom/avito/android/analytics/provider/TreeStateIdGenerator;Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;Lcom/avito/android/Features;)Lcom/avito/android/advert_core/analytics/AdvertDetailsAnalyticsInteractor;", "provideAdvertDetailsAnalyticsInteractor", "Lru/avito/messenger/api/AvitoMessengerApi;", "messengerApi", "provideAdvertMessengerInteractor$photo_gallery_release", "(Lru/avito/messenger/api/AvitoMessengerApi;Lcom/avito/android/account/AccountStateProvider;Lcom/avito/android/util/SchedulersFactory3;)Lcom/avito/android/advert_core/messenger/AdvertMessengerInteractor;", "provideAdvertMessengerInteractor", "Lcom/avito/android/advert_details/remote/AdvertDetailsApi;", "api", "provideNoCallFeedbackInteractor$photo_gallery_release", "(Lcom/avito/android/advert_details/remote/AdvertDetailsApi;Lcom/avito/android/util/SchedulersFactory3;)Lcom/avito/android/advert_core/contactbar/feedback/FeedbackInteractor;", "provideNoCallFeedbackInteractor", "Landroid/content/res/Resources;", "resources", "", "provideThrowableFormatter$photo_gallery_release", "(Landroid/content/res/Resources;)Lcom/avito/android/util/Formatter;", "provideThrowableFormatter", "", "formatter", "providePhoneNumberFormatterProvider", "(Lcom/avito/android/util/Formatter;)Lcom/avito/android/util/Formatter;", "<init>", "()V", "Declarations", "photo-gallery_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {DialogRouterModule.class, PhoneNumberFormatterModule.class, LegacyPhotoTrackerModule.class, CommercialBannersInteractorModule.class, Declarations.class})
public final class LegacyPhotoGalleryModule {
    @NotNull
    public static final LegacyPhotoGalleryModule INSTANCE = new LegacyPhotoGalleryModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0003\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\fH'¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u0010H'¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0014H'¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001a\u001a\u00020\u0019H'¢\u0006\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Lcom/avito/android/photo_gallery/di/LegacyPhotoGalleryModule$Declarations;", "", "Lcom/avito/android/advert_core/contactbar/AdvertContactsInteractorImpl;", "impl", "Lcom/avito/android/advert_core/contactbar/AdvertContactsInteractor;", "bindAdvertContactsInteractor", "(Lcom/avito/android/advert_core/contactbar/AdvertContactsInteractorImpl;)Lcom/avito/android/advert_core/contactbar/AdvertContactsInteractor;", "Lcom/avito/android/util/AdvertPriceFormatter;", "Lcom/avito/android/util/Formatter;", "Lcom/avito/android/remote/model/AdvertPrice;", "bindPriceFormatter", "(Lcom/avito/android/util/AdvertPriceFormatter;)Lcom/avito/android/util/Formatter;", "Lcom/avito/android/advert_core/contactbar/anti_fraud/AntiFraudPreferencesImpl;", "Lcom/avito/android/advert_core/contactbar/anti_fraud/AntiFraudPreferences;", "bindAntiFraudPreferences", "(Lcom/avito/android/advert_core/contactbar/anti_fraud/AntiFraudPreferencesImpl;)Lcom/avito/android/advert_core/contactbar/anti_fraud/AntiFraudPreferences;", "Lcom/avito/android/advert_core/feedback/FeedbackPreferencesImpl;", "Lcom/avito/android/advert_core/feedback/FeedbackPreferences;", "bindFeedbackPreferences", "(Lcom/avito/android/advert_core/feedback/FeedbackPreferencesImpl;)Lcom/avito/android/advert_core/feedback/FeedbackPreferences;", "Lcom/avito/android/advert_core/contactbar/AdvertContactsResourceProviderImpl;", "contactsResourceProvider", "Lcom/avito/android/advert_core/contactbar/AdvertContactsResourceProvider;", "bindContactsResourceProvider", "(Lcom/avito/android/advert_core/contactbar/AdvertContactsResourceProviderImpl;)Lcom/avito/android/advert_core/contactbar/AdvertContactsResourceProvider;", "Lcom/avito/android/advert_core/job/AdvertJobInteractorImpl;", "interactor", "Lcom/avito/android/advert_core/job/AdvertJobInteractor;", "bindAdvertJobInteractor", "(Lcom/avito/android/advert_core/job/AdvertJobInteractorImpl;)Lcom/avito/android/advert_core/job/AdvertJobInteractor;", "photo-gallery_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @PerActivity
        @Binds
        @NotNull
        AdvertContactsInteractor bindAdvertContactsInteractor(@NotNull AdvertContactsInteractorImpl advertContactsInteractorImpl);

        @PerActivity
        @Binds
        @NotNull
        AdvertJobInteractor bindAdvertJobInteractor(@NotNull AdvertJobInteractorImpl advertJobInteractorImpl);

        @PerActivity
        @Binds
        @NotNull
        AntiFraudPreferences bindAntiFraudPreferences(@NotNull AntiFraudPreferencesImpl antiFraudPreferencesImpl);

        @PerActivity
        @Binds
        @NotNull
        AdvertContactsResourceProvider bindContactsResourceProvider(@NotNull AdvertContactsResourceProviderImpl advertContactsResourceProviderImpl);

        @PerActivity
        @Binds
        @NotNull
        FeedbackPreferences bindFeedbackPreferences(@NotNull FeedbackPreferencesImpl feedbackPreferencesImpl);

        @Binds
        @NotNull
        Formatter<AdvertPrice> bindPriceFormatter(@NotNull AdvertPriceFormatter advertPriceFormatter);
    }

    @Provides
    @PerActivity
    @NotNull
    public final AdvertActionIconFactory provideAdvertActionIconFactory(@NotNull Application application) {
        Intrinsics.checkNotNullParameter(application, MimeTypes.BASE_TYPE_APPLICATION);
        return new AdvertActionIconFactoryImpl(application, true);
    }

    @Provides
    @NotNull
    @PerActivity
    public final AdvertContactsPresenter provideAdvertContactsPresenter(@NotNull Features features, @NotNull Analytics analytics, @NotNull ProfileInfoStorage profileInfoStorage, @NotNull AdvertDetailsAnalyticsInteractor advertDetailsAnalyticsInteractor, @NotNull AdvertContactsInteractor advertContactsInteractor, @NotNull AdvertMessengerInteractor advertMessengerInteractor, @NotNull FeedbackInteractor feedbackInteractor, @NotNull AdvertActionIconFactory advertActionIconFactory, @NotNull AccountStateProvider accountStateProvider, @NotNull Formatter<AdvertPrice> formatter, @NotNull AntiFraudPreferences antiFraudPreferences, @NotNull FeedbackPreferences feedbackPreferences, @NotNull SchedulersFactory3 schedulersFactory3, @JustDialSellerPhoneTestGroup @NotNull AbTestGroup<SimpleTestGroupWithControl2> abTestGroup, @AntiFraudCheckList @NotNull SingleManuallyExposedAbTestGroup<AntiFraudCheckListTestGroup> singleManuallyExposedAbTestGroup, @AdvertDetailsNoCallFeedback @NotNull ManuallyExposedAbTestGroup<AdvertDetailsNoCallFeedbackTestGroup> manuallyExposedAbTestGroup, @AdvertContactApplyWithoutChat @NotNull ExposedAbTestGroup<SimpleTestGroupWithNone> exposedAbTestGroup, @SendEmployersPhoneOnCallToSellerButtonClickInResumes @NotNull AbTestGroup<SendEmployersPhoneOnCallToSellerButtonClickInResumesTestGroup> abTestGroup2, @NotNull ManuallyExposedAbTestGroup<AdvertDetailsMarketplaceNoPurchaseFeedbackTestGroup> manuallyExposedAbTestGroup2, @JobApplicationProgressBar @NotNull ExposedAbTestGroup<SimpleTestGroup> exposedAbTestGroup2, @NotNull AppCallsUsageTracker appCallsUsageTracker, @NotNull AdvertContactsResourceProvider advertContactsResourceProvider, @NotNull PermissionChecker permissionChecker, @NotNull AdvertJobInteractor advertJobInteractor) {
        Intrinsics.checkNotNullParameter(features, "features");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(profileInfoStorage, "profileInfoStorage");
        Intrinsics.checkNotNullParameter(advertDetailsAnalyticsInteractor, "analyticsInteractor");
        Intrinsics.checkNotNullParameter(advertContactsInteractor, "advertContactsInteractor");
        Intrinsics.checkNotNullParameter(advertMessengerInteractor, "advertMessengerInteractor");
        Intrinsics.checkNotNullParameter(feedbackInteractor, "feedbackInteractor");
        Intrinsics.checkNotNullParameter(advertActionIconFactory, "advertActionIconFactory");
        Intrinsics.checkNotNullParameter(accountStateProvider, "accountStateProvider");
        Intrinsics.checkNotNullParameter(formatter, "priceFormatter");
        Intrinsics.checkNotNullParameter(antiFraudPreferences, "antiFraudPreferences");
        Intrinsics.checkNotNullParameter(feedbackPreferences, "feedbackPreferences");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(abTestGroup, "justDialSellerPhoneTestGroup");
        Intrinsics.checkNotNullParameter(singleManuallyExposedAbTestGroup, "antiFraudCheckListTest");
        Intrinsics.checkNotNullParameter(manuallyExposedAbTestGroup, "advertDetailsNoCallFeedbackTestGroup");
        Intrinsics.checkNotNullParameter(exposedAbTestGroup, "advertContactApplyWithoutChatTestGroup");
        Intrinsics.checkNotNullParameter(abTestGroup2, "sendEmployersPhoneOnCallButtonClickInVacanciesTestGroup");
        Intrinsics.checkNotNullParameter(manuallyExposedAbTestGroup2, "marketplaceNoPurchaseFeedbackTestGroup");
        Intrinsics.checkNotNullParameter(exposedAbTestGroup2, "jobApplicationProgressBarTestGroup");
        Intrinsics.checkNotNullParameter(appCallsUsageTracker, "appCallUsageTracker");
        Intrinsics.checkNotNullParameter(advertContactsResourceProvider, "resourceProvider");
        Intrinsics.checkNotNullParameter(permissionChecker, "permissionChecker");
        Intrinsics.checkNotNullParameter(advertJobInteractor, "advertJobInteractor");
        return new AdvertContactsPresenterImpl(null, advertActionIconFactory, profileInfoStorage, advertMessengerInteractor, advertContactsInteractor, advertDetailsAnalyticsInteractor, feedbackInteractor, accountStateProvider, advertContactsResourceProvider, formatter, antiFraudPreferences, feedbackPreferences, analytics, schedulersFactory3, features, SourceScreen.PHOTO_GALLERY, abTestGroup, singleManuallyExposedAbTestGroup, null, permissionChecker, appCallsUsageTracker, manuallyExposedAbTestGroup, manuallyExposedAbTestGroup2, exposedAbTestGroup, abTestGroup2, exposedAbTestGroup2, advertJobInteractor);
    }

    @Provides
    @PerActivity
    @NotNull
    public final AdvertDetailsAnalyticsInteractor provideAdvertDetailsAnalyticsInteractor$photo_gallery_release(@NotNull Analytics analytics, @NotNull CommercialBannersAnalyticsInteractor commercialBannersAnalyticsInteractor, @NotNull AccountStateProvider accountStateProvider, @NotNull TreeStateIdGenerator treeStateIdGenerator, @Nullable TreeClickStreamParent treeClickStreamParent, @NotNull Features features) {
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(commercialBannersAnalyticsInteractor, "commercialsAnalyticsInteractor");
        Intrinsics.checkNotNullParameter(accountStateProvider, "accountStateProvider");
        Intrinsics.checkNotNullParameter(treeStateIdGenerator, "treeStateIdGenerator");
        Intrinsics.checkNotNullParameter(features, "features");
        return new AdvertDetailsAnalyticsInteractorImpl(analytics, commercialBannersAnalyticsInteractor, new CreditBrokerAnalyticsInteractorNoOp(), accountStateProvider, treeStateIdGenerator, treeClickStreamParent, features);
    }

    @Provides
    @PerActivity
    @NotNull
    public final AdvertMessengerInteractor provideAdvertMessengerInteractor$photo_gallery_release(@NotNull AvitoMessengerApi avitoMessengerApi, @NotNull AccountStateProvider accountStateProvider, @NotNull SchedulersFactory3 schedulersFactory3) {
        Intrinsics.checkNotNullParameter(avitoMessengerApi, "messengerApi");
        Intrinsics.checkNotNullParameter(accountStateProvider, "accountStateProvider");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        return new AdvertMessengerInteractorImpl(avitoMessengerApi, accountStateProvider, schedulersFactory3);
    }

    @Provides
    @PerActivity
    @NotNull
    public final FeedbackInteractor provideNoCallFeedbackInteractor$photo_gallery_release(@NotNull AdvertDetailsApi advertDetailsApi, @NotNull SchedulersFactory3 schedulersFactory3) {
        Intrinsics.checkNotNullParameter(advertDetailsApi, "api");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        return new FeedbackInteractorImpl(advertDetailsApi, schedulersFactory3);
    }

    @Provides
    @NotNull
    @PerActivity
    public final Formatter<String> providePhoneNumberFormatterProvider(@PhoneNumberFormatterModule.PhoneNumberFormatterWithCountryCode @NotNull Formatter<String> formatter) {
        Intrinsics.checkNotNullParameter(formatter, "formatter");
        return formatter;
    }

    @Provides
    @NotNull
    @PerActivity
    public final Formatter<Throwable> provideThrowableFormatter$photo_gallery_release(@NotNull Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        return new ErrorFormatterImpl(resources);
    }
}
