package com.avito.android.di.module;

import com.avito.android.ab_tests.AbTestsConfigProvider;
import com.avito.android.ab_tests.AdvertContactApplyWithoutChat;
import com.avito.android.ab_tests.AdvertDetailsNoCallFeedback;
import com.avito.android.ab_tests.AdvertSpeedUpTest;
import com.avito.android.ab_tests.AntiFraudCheckList;
import com.avito.android.ab_tests.AutoBrandModelTypoCorrection;
import com.avito.android.ab_tests.AutoGenerationsFilterWithPhotos;
import com.avito.android.ab_tests.DraftsOnStartPublishSheet;
import com.avito.android.ab_tests.JobApplicationProgressBar;
import com.avito.android.ab_tests.JustDialSellerPhoneTestGroup;
import com.avito.android.ab_tests.MessengerSearchIconTest;
import com.avito.android.ab_tests.OrangeAdBage;
import com.avito.android.ab_tests.PriceOnTop;
import com.avito.android.ab_tests.RealtyNewBackNavigation;
import com.avito.android.ab_tests.SellerInfoInRichSnippet;
import com.avito.android.ab_tests.SendEmployersPhoneOnCallToSellerButtonClickInResumes;
import com.avito.android.ab_tests.configs.AntiFraudCheckListTestGroup;
import com.avito.android.ab_tests.configs.AntifraudStartupBannerTestGroup;
import com.avito.android.ab_tests.configs.HomeNewRubricatorTestGroup;
import com.avito.android.ab_tests.configs.OrangeAdBadgeTestGroup;
import com.avito.android.ab_tests.configs.PriceOnTopTestGroup;
import com.avito.android.ab_tests.configs.SellerInfoInRichSnippetTestGroup;
import com.avito.android.ab_tests.configs.SerpItemsPrefetchTestGroup;
import com.avito.android.ab_tests.configs.SravniWebTestGroup;
import com.avito.android.ab_tests.configs.TinkoffCreditCalculatorTestGroup;
import com.avito.android.ab_tests.configs.UserAdvertsTabTestGroup;
import com.avito.android.ab_tests.groups.AdCascadesInChannelsTestGroup;
import com.avito.android.ab_tests.groups.AdvertAutotekaTeaserInGalleryTestGroup;
import com.avito.android.ab_tests.groups.AdvertDetailsIcebreakerStyleTestGroup;
import com.avito.android.ab_tests.groups.AdvertDetailsMarketplaceBadgeBarItemTestGroup;
import com.avito.android.ab_tests.groups.AdvertDetailsMarketplaceImprovingContentItemsTestGroup;
import com.avito.android.ab_tests.groups.AdvertDetailsMarketplaceNoPurchaseFeedbackTestGroup;
import com.avito.android.ab_tests.groups.AdvertDetailsNoCallFeedbackTestGroup;
import com.avito.android.ab_tests.groups.AdvertDetailsPriceSubscriptionTestGroup;
import com.avito.android.ab_tests.groups.AutoBrandModelTypoCorrectionTestGroup;
import com.avito.android.ab_tests.groups.CallsEarlyBeepsTestGroup;
import com.avito.android.ab_tests.groups.CallsNewDesignTestGroup;
import com.avito.android.ab_tests.groups.HomeSkeletonTestGroup;
import com.avito.android.ab_tests.groups.InAppUpdateTestGroup;
import com.avito.android.ab_tests.groups.MessengerFolderTabsTestGroup;
import com.avito.android.ab_tests.groups.PublishReviewFromChatChannelGroup;
import com.avito.android.ab_tests.groups.SendEmployersPhoneOnCallToSellerButtonClickInResumesTestGroup;
import com.avito.android.ab_tests.groups.SerpSkeletonTestGroup;
import com.avito.android.ab_tests.groups.SimpleTestGroup;
import com.avito.android.ab_tests.groups.SimpleTestGroupWithControl2;
import com.avito.android.ab_tests.groups.SimpleTestGroupWithNone;
import com.avito.android.ab_tests.groups.SimpleTestGroupWithNoneControl2;
import com.avito.android.ab_tests.groups.ViewedItemsTabTestGroup;
import com.avito.android.ab_tests.groups.ViewedItemsWidgetOnMainTestGroup;
import com.avito.android.ab_tests.models.AbTestGroup;
import com.avito.android.ab_tests.models.ExposedAbTestGroup;
import com.avito.android.ab_tests.models.ManuallyExposedAbTestGroup;
import com.avito.android.ab_tests.models.SingleManuallyExposedAbTestGroup;
import dagger.Module;
import dagger.Provides;
import dagger.Reusable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b`\u0010aJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u001d\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u001d\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u000f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0014\u0010\u0012J\u001d\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u000b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0016\u0010\u000eJ\u001d\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\f0\u000f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0017\u0010\u0012J\u001d\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u000f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0019\u0010\u0012J\u001d\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u000f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u001b\u0010\u0012J\u0017\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u001d\u0010\u001eJ\u001d\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\u001f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b!\u0010\"J\u0017\u0010$\u001a\u00020#2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b$\u0010%J\u001d\u0010'\u001a\b\u0012\u0004\u0012\u00020&0\u001f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b'\u0010\"J\u001d\u0010)\u001a\b\u0012\u0004\u0012\u00020(0\u000b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b)\u0010\u000eJ\u001d\u0010+\u001a\b\u0012\u0004\u0012\u00020*0\u001f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b+\u0010\"J\u001d\u0010,\u001a\b\u0012\u0004\u0012\u00020\f0\u000f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b,\u0010\u0012J\u001d\u0010.\u001a\b\u0012\u0004\u0012\u00020-0\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b.\u0010\u0007J\u0017\u00100\u001a\u00020/2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b0\u00101J\u0017\u00103\u001a\u0002022\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b3\u00104J\u0017\u00106\u001a\u0002052\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b6\u00107J\u0017\u00109\u001a\u0002082\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b9\u0010:J\u001d\u0010<\u001a\b\u0012\u0004\u0012\u00020;0\u001f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b<\u0010\"J\u001d\u0010>\u001a\b\u0012\u0004\u0012\u00020=0\u000f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b>\u0010\u0012J\u001d\u0010@\u001a\b\u0012\u0004\u0012\u00020?0\u001f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b@\u0010\"J\u001d\u0010B\u001a\b\u0012\u0004\u0012\u00020A0\u000b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\bB\u0010\u000eJ\u0017\u0010D\u001a\u00020C2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\bD\u0010EJ\u001d\u0010F\u001a\b\u0012\u0004\u0012\u00020\u001c0\u000f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\bF\u0010\u0012J\u001d\u0010H\u001a\b\u0012\u0004\u0012\u00020G0\u001f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\bH\u0010\"J\u001d\u0010J\u001a\b\u0012\u0004\u0012\u00020I0\u001f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\bJ\u0010\"J\u001d\u0010L\u001a\b\u0012\u0004\u0012\u00020K0\u001f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\bL\u0010\"J\u001d\u0010N\u001a\b\u0012\u0004\u0012\u00020M0\u001f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\bN\u0010\"J\u001d\u0010P\u001a\b\u0012\u0004\u0012\u00020O0\u000b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\bP\u0010\u000eJ\u001d\u0010R\u001a\b\u0012\u0004\u0012\u00020Q0\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\bR\u0010\u0007J\u001d\u0010T\u001a\b\u0012\u0004\u0012\u00020\u001c0\u000b2\u0006\u0010S\u001a\u00020\u0002H\u0007¢\u0006\u0004\bT\u0010\u000eJ\u001d\u0010V\u001a\b\u0012\u0004\u0012\u00020U0\u000f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\bV\u0010\u0012J\u001d\u0010X\u001a\b\u0012\u0004\u0012\u00020W0\u001f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\bX\u0010\"J\u001d\u0010Z\u001a\b\u0012\u0004\u0012\u00020Y0\u001f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\bZ\u0010\"J\u001d\u0010\\\u001a\u00020Y2\f\u0010[\u001a\b\u0012\u0004\u0012\u00020Y0\u001fH\u0007¢\u0006\u0004\b\\\u0010]J\u001d\u0010^\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b^\u0010\u000eJ\u001d\u0010_\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b_\u0010\"¨\u0006b"}, d2 = {"Lcom/avito/android/di/module/AbTestGroupModule;", "", "Lcom/avito/android/ab_tests/AbTestsConfigProvider;", "abTestsConfigProvider", "Lcom/avito/android/ab_tests/models/AbTestGroup;", "Lcom/avito/android/ab_tests/groups/SimpleTestGroupWithControl2;", "provideJustDialSellerPhoneTestGroup", "(Lcom/avito/android/ab_tests/AbTestsConfigProvider;)Lcom/avito/android/ab_tests/models/AbTestGroup;", "Lcom/avito/android/ab_tests/groups/AdvertDetailsIcebreakerStyleTestGroup;", "provideAdvertDetailsIcebreakerStyleTestGroup", "(Lcom/avito/android/ab_tests/AbTestsConfigProvider;)Lcom/avito/android/ab_tests/groups/AdvertDetailsIcebreakerStyleTestGroup;", "Lcom/avito/android/ab_tests/models/ExposedAbTestGroup;", "Lcom/avito/android/ab_tests/groups/SimpleTestGroupWithNone;", "provideAdvertContactApplyWithoutChatTestGroup", "(Lcom/avito/android/ab_tests/AbTestsConfigProvider;)Lcom/avito/android/ab_tests/models/ExposedAbTestGroup;", "Lcom/avito/android/ab_tests/models/ManuallyExposedAbTestGroup;", "Lcom/avito/android/ab_tests/groups/AdvertDetailsNoCallFeedbackTestGroup;", "provideAdvertDetailsNoCallFeedbackTestGroup", "(Lcom/avito/android/ab_tests/AbTestsConfigProvider;)Lcom/avito/android/ab_tests/models/ManuallyExposedAbTestGroup;", "Lcom/avito/android/ab_tests/groups/AdvertDetailsMarketplaceNoPurchaseFeedbackTestGroup;", "provideAdvertDetailsMarketplaceNoPurchaseFeedbackTestGroup", "Lcom/avito/android/ab_tests/groups/AdvertDetailsMarketplaceImprovingContentItemsTestGroup;", "provideAdvertDetailsMarketplaceImprovingContentItemsTestGroup", "provideAdvertDetailsMarketplaceDeliveryItemTestGroup", "Lcom/avito/android/ab_tests/groups/AdvertDetailsMarketplaceBadgeBarItemTestGroup;", "provideAdvertDetailsMarketplaceBadgeBarItemTestGroup", "Lcom/avito/android/ab_tests/groups/AdvertDetailsPriceSubscriptionTestGroup;", "provideAdvertDetailsPriceSubscriptionTestGroup", "Lcom/avito/android/ab_tests/groups/SimpleTestGroup;", "provideMessengerSearchIconTestGroup", "(Lcom/avito/android/ab_tests/AbTestsConfigProvider;)Lcom/avito/android/ab_tests/groups/SimpleTestGroup;", "Lcom/avito/android/ab_tests/models/SingleManuallyExposedAbTestGroup;", "Lcom/avito/android/ab_tests/groups/AutoBrandModelTypoCorrectionTestGroup;", "provideAutoBrandModelTypoCorrectionTestGroup", "(Lcom/avito/android/ab_tests/AbTestsConfigProvider;)Lcom/avito/android/ab_tests/models/SingleManuallyExposedAbTestGroup;", "Lcom/avito/android/ab_tests/configs/AntifraudStartupBannerTestGroup;", "provideAntifraudStartupBannerTestGroup", "(Lcom/avito/android/ab_tests/AbTestsConfigProvider;)Lcom/avito/android/ab_tests/configs/AntifraudStartupBannerTestGroup;", "Lcom/avito/android/ab_tests/configs/AntiFraudCheckListTestGroup;", "provideAntiFraudCheckListTestGroup", "Lcom/avito/android/ab_tests/configs/PriceOnTopTestGroup;", "provideOnTopTestGroup", "Lcom/avito/android/ab_tests/configs/SellerInfoInRichSnippetTestGroup;", "provideSellerInfoInRichSnippetTestGroup", "provideRealtyNewBackNavigationTestGroup", "Lcom/avito/android/ab_tests/groups/SimpleTestGroupWithNoneControl2;", "provideAdvertSpeedUpTest", "Lcom/avito/android/ab_tests/groups/SerpSkeletonTestGroup;", "provideSerpSkeletonTest", "(Lcom/avito/android/ab_tests/AbTestsConfigProvider;)Lcom/avito/android/ab_tests/groups/SerpSkeletonTestGroup;", "Lcom/avito/android/ab_tests/groups/HomeSkeletonTestGroup;", "provideHomeSkeletonTest", "(Lcom/avito/android/ab_tests/AbTestsConfigProvider;)Lcom/avito/android/ab_tests/groups/HomeSkeletonTestGroup;", "Lcom/avito/android/ab_tests/configs/HomeNewRubricatorTestGroup;", "provideHomeNewRubricator", "(Lcom/avito/android/ab_tests/AbTestsConfigProvider;)Lcom/avito/android/ab_tests/configs/HomeNewRubricatorTestGroup;", "Lcom/avito/android/ab_tests/configs/SerpItemsPrefetchTestGroup;", "provideSerpItemsPrefetchTestGroup", "(Lcom/avito/android/ab_tests/AbTestsConfigProvider;)Lcom/avito/android/ab_tests/configs/SerpItemsPrefetchTestGroup;", "Lcom/avito/android/ab_tests/groups/AdCascadesInChannelsTestGroup;", "adCascadesInChannels", "Lcom/avito/android/ab_tests/groups/MessengerFolderTabsTestGroup;", "messengerFolderTabs", "Lcom/avito/android/ab_tests/configs/SravniWebTestGroup;", "sravniWebTestGroup", "Lcom/avito/android/ab_tests/configs/OrangeAdBadgeTestGroup;", "orangeAdBadgeTestGroup", "Lcom/avito/android/ab_tests/groups/InAppUpdateTestGroup;", "provideInAppUpdateTestGroup", "(Lcom/avito/android/ab_tests/AbTestsConfigProvider;)Lcom/avito/android/ab_tests/groups/InAppUpdateTestGroup;", "provideDraftsOnStartPublishSheet", "Lcom/avito/android/ab_tests/groups/PublishReviewFromChatChannelGroup;", "publishReviewFromChatChannel", "Lcom/avito/android/ab_tests/configs/TinkoffCreditCalculatorTestGroup;", "provideTinkoffCreditCalculatorTestGroup", "Lcom/avito/android/ab_tests/groups/ViewedItemsTabTestGroup;", "provideViewedItemsTabTestGroub", "Lcom/avito/android/ab_tests/groups/ViewedItemsWidgetOnMainTestGroup;", "provideViewedItemsWidgetOnMain", "Lcom/avito/android/ab_tests/groups/CallsNewDesignTestGroup;", "callsNewDesignTestGroup", "Lcom/avito/android/ab_tests/groups/SendEmployersPhoneOnCallToSellerButtonClickInResumesTestGroup;", "provideSendEmployersPhoneOnCallButtonClickInVacanciesTestGroup", "abTestConfigProvider", "provideJobApplicationProgressBarTestGroup", "Lcom/avito/android/ab_tests/groups/AdvertAutotekaTeaserInGalleryTestGroup;", "advertAutotekaTeaserInGalleryTestGroup", "Lcom/avito/android/ab_tests/groups/CallsEarlyBeepsTestGroup;", "callsEarlyBeepsTestGroup", "Lcom/avito/android/ab_tests/configs/UserAdvertsTabTestGroup;", "userAdvertsTabManuallyExposedTestGroup", "abTestGroup", "userAdvertsTabTestGroup", "(Lcom/avito/android/ab_tests/models/SingleManuallyExposedAbTestGroup;)Lcom/avito/android/ab_tests/configs/UserAdvertsTabTestGroup;", "provideFavoriteSimilarAdvertsTestGroup", "autoGenerationsFilterWithPhotosTestGroup", "<init>", "()V", "ab-tests_release"}, k = 1, mv = {1, 4, 2})
@Module
public final class AbTestGroupModule {
    @Provides
    @Reusable
    @NotNull
    public final SingleManuallyExposedAbTestGroup<AdCascadesInChannelsTestGroup> adCascadesInChannels(@NotNull AbTestsConfigProvider abTestsConfigProvider) {
        Intrinsics.checkNotNullParameter(abTestsConfigProvider, "abTestsConfigProvider");
        return abTestsConfigProvider.adCascadesInChannels();
    }

    @Provides
    @Reusable
    @NotNull
    public final ManuallyExposedAbTestGroup<AdvertAutotekaTeaserInGalleryTestGroup> advertAutotekaTeaserInGalleryTestGroup(@NotNull AbTestsConfigProvider abTestsConfigProvider) {
        Intrinsics.checkNotNullParameter(abTestsConfigProvider, "abTestsConfigProvider");
        return abTestsConfigProvider.advertAutotekaTeaserInGallery();
    }

    @Provides
    @Reusable
    @AutoGenerationsFilterWithPhotos
    @NotNull
    public final SingleManuallyExposedAbTestGroup<SimpleTestGroup> autoGenerationsFilterWithPhotosTestGroup(@NotNull AbTestsConfigProvider abTestsConfigProvider) {
        Intrinsics.checkNotNullParameter(abTestsConfigProvider, "abTestsConfigProvider");
        return abTestsConfigProvider.autoGenerationsFilterWithPhotos();
    }

    @Provides
    @Reusable
    @NotNull
    public final SingleManuallyExposedAbTestGroup<CallsEarlyBeepsTestGroup> callsEarlyBeepsTestGroup(@NotNull AbTestsConfigProvider abTestsConfigProvider) {
        Intrinsics.checkNotNullParameter(abTestsConfigProvider, "abTestsConfigProvider");
        return abTestsConfigProvider.callsEarlyBeeps();
    }

    @Provides
    @Reusable
    @NotNull
    public final ExposedAbTestGroup<CallsNewDesignTestGroup> callsNewDesignTestGroup(@NotNull AbTestsConfigProvider abTestsConfigProvider) {
        Intrinsics.checkNotNullParameter(abTestsConfigProvider, "abTestsConfigProvider");
        return abTestsConfigProvider.callsNewDesign();
    }

    @Provides
    @Reusable
    @NotNull
    public final ManuallyExposedAbTestGroup<MessengerFolderTabsTestGroup> messengerFolderTabs(@NotNull AbTestsConfigProvider abTestsConfigProvider) {
        Intrinsics.checkNotNullParameter(abTestsConfigProvider, "abTestsConfigProvider");
        return abTestsConfigProvider.messengerFolderTabs();
    }

    @Provides
    @Reusable
    @NotNull
    @OrangeAdBage
    public final ExposedAbTestGroup<OrangeAdBadgeTestGroup> orangeAdBadgeTestGroup(@NotNull AbTestsConfigProvider abTestsConfigProvider) {
        Intrinsics.checkNotNullParameter(abTestsConfigProvider, "abTestsConfigProvider");
        return abTestsConfigProvider.orangeAdBadge();
    }

    @Provides
    @Reusable
    @NotNull
    @AdvertContactApplyWithoutChat
    public final ExposedAbTestGroup<SimpleTestGroupWithNone> provideAdvertContactApplyWithoutChatTestGroup(@NotNull AbTestsConfigProvider abTestsConfigProvider) {
        Intrinsics.checkNotNullParameter(abTestsConfigProvider, "abTestsConfigProvider");
        return abTestsConfigProvider.advertContactApplyWithoutChat();
    }

    @Provides
    @Reusable
    @NotNull
    public final AdvertDetailsIcebreakerStyleTestGroup provideAdvertDetailsIcebreakerStyleTestGroup(@NotNull AbTestsConfigProvider abTestsConfigProvider) {
        Intrinsics.checkNotNullParameter(abTestsConfigProvider, "abTestsConfigProvider");
        return abTestsConfigProvider.advertDetailsIcebreakerStyle().getTestGroup();
    }

    @Provides
    @Reusable
    @NotNull
    public final ManuallyExposedAbTestGroup<AdvertDetailsMarketplaceBadgeBarItemTestGroup> provideAdvertDetailsMarketplaceBadgeBarItemTestGroup(@NotNull AbTestsConfigProvider abTestsConfigProvider) {
        Intrinsics.checkNotNullParameter(abTestsConfigProvider, "abTestsConfigProvider");
        return abTestsConfigProvider.advertDetailsMarketplaceBadgeBarItemTestGroup();
    }

    @Provides
    @Reusable
    @NotNull
    public final ManuallyExposedAbTestGroup<SimpleTestGroupWithNone> provideAdvertDetailsMarketplaceDeliveryItemTestGroup(@NotNull AbTestsConfigProvider abTestsConfigProvider) {
        Intrinsics.checkNotNullParameter(abTestsConfigProvider, "abTestsConfigProvider");
        return abTestsConfigProvider.advertDetailsMarketplaceDeliveryItemTestGroup();
    }

    @Provides
    @Reusable
    @NotNull
    public final ExposedAbTestGroup<AdvertDetailsMarketplaceImprovingContentItemsTestGroup> provideAdvertDetailsMarketplaceImprovingContentItemsTestGroup(@NotNull AbTestsConfigProvider abTestsConfigProvider) {
        Intrinsics.checkNotNullParameter(abTestsConfigProvider, "abTestsConfigProvider");
        return abTestsConfigProvider.advertDetailsMarketplaceImprovingContentItemsTestGroup();
    }

    @Provides
    @Reusable
    @NotNull
    public final ManuallyExposedAbTestGroup<AdvertDetailsMarketplaceNoPurchaseFeedbackTestGroup> provideAdvertDetailsMarketplaceNoPurchaseFeedbackTestGroup(@NotNull AbTestsConfigProvider abTestsConfigProvider) {
        Intrinsics.checkNotNullParameter(abTestsConfigProvider, "abTestsConfigProvider");
        return abTestsConfigProvider.advertDetailsMarketplaceNoPurchaseFeedbackTestGroup();
    }

    @Provides
    @Reusable
    @AdvertDetailsNoCallFeedback
    @NotNull
    public final ManuallyExposedAbTestGroup<AdvertDetailsNoCallFeedbackTestGroup> provideAdvertDetailsNoCallFeedbackTestGroup(@NotNull AbTestsConfigProvider abTestsConfigProvider) {
        Intrinsics.checkNotNullParameter(abTestsConfigProvider, "abTestsConfigProvider");
        return abTestsConfigProvider.advertDetailsNoCallFeedbackTestGroup();
    }

    @Provides
    @Reusable
    @NotNull
    public final ManuallyExposedAbTestGroup<AdvertDetailsPriceSubscriptionTestGroup> provideAdvertDetailsPriceSubscriptionTestGroup(@NotNull AbTestsConfigProvider abTestsConfigProvider) {
        Intrinsics.checkNotNullParameter(abTestsConfigProvider, "abTestsConfigProvider");
        return abTestsConfigProvider.advertDetailsPriceSubscription();
    }

    @Provides
    @Reusable
    @NotNull
    @AdvertSpeedUpTest
    public final AbTestGroup<SimpleTestGroupWithNoneControl2> provideAdvertSpeedUpTest(@NotNull AbTestsConfigProvider abTestsConfigProvider) {
        Intrinsics.checkNotNullParameter(abTestsConfigProvider, "abTestsConfigProvider");
        return abTestsConfigProvider.advertSpeedUpTest();
    }

    @Provides
    @AntiFraudCheckList
    @Reusable
    @NotNull
    public final SingleManuallyExposedAbTestGroup<AntiFraudCheckListTestGroup> provideAntiFraudCheckListTestGroup(@NotNull AbTestsConfigProvider abTestsConfigProvider) {
        Intrinsics.checkNotNullParameter(abTestsConfigProvider, "abTestsConfigProvider");
        return abTestsConfigProvider.antiFraudCheckList();
    }

    @Provides
    @Reusable
    @NotNull
    public final AntifraudStartupBannerTestGroup provideAntifraudStartupBannerTestGroup(@NotNull AbTestsConfigProvider abTestsConfigProvider) {
        Intrinsics.checkNotNullParameter(abTestsConfigProvider, "abTestsConfigProvider");
        return abTestsConfigProvider.antifraudStartupBanner().getTestGroup();
    }

    @Provides
    @AutoBrandModelTypoCorrection
    @Reusable
    @NotNull
    public final SingleManuallyExposedAbTestGroup<AutoBrandModelTypoCorrectionTestGroup> provideAutoBrandModelTypoCorrectionTestGroup(@NotNull AbTestsConfigProvider abTestsConfigProvider) {
        Intrinsics.checkNotNullParameter(abTestsConfigProvider, "abTestsConfigProvider");
        return abTestsConfigProvider.autoBrandModelTypoCorrection();
    }

    @DraftsOnStartPublishSheet
    @Provides
    @Reusable
    @NotNull
    public final ManuallyExposedAbTestGroup<SimpleTestGroup> provideDraftsOnStartPublishSheet(@NotNull AbTestsConfigProvider abTestsConfigProvider) {
        Intrinsics.checkNotNullParameter(abTestsConfigProvider, "abTestsConfigProvider");
        return abTestsConfigProvider.draftsOnStartPublishSheet();
    }

    @Provides
    @Reusable
    @NotNull
    public final ExposedAbTestGroup<SimpleTestGroupWithNone> provideFavoriteSimilarAdvertsTestGroup(@NotNull AbTestsConfigProvider abTestsConfigProvider) {
        Intrinsics.checkNotNullParameter(abTestsConfigProvider, "abTestsConfigProvider");
        return abTestsConfigProvider.favoriteSimilarAdvertsTestGroup();
    }

    @Provides
    @Reusable
    @NotNull
    public final HomeNewRubricatorTestGroup provideHomeNewRubricator(@NotNull AbTestsConfigProvider abTestsConfigProvider) {
        Intrinsics.checkNotNullParameter(abTestsConfigProvider, "abTestsConfigProvider");
        return abTestsConfigProvider.homeNewRubricator().getTestGroup();
    }

    @Provides
    @Reusable
    @NotNull
    public final HomeSkeletonTestGroup provideHomeSkeletonTest(@NotNull AbTestsConfigProvider abTestsConfigProvider) {
        Intrinsics.checkNotNullParameter(abTestsConfigProvider, "abTestsConfigProvider");
        return abTestsConfigProvider.homeSkeletonTest().getTestGroup();
    }

    @Provides
    @Reusable
    @NotNull
    public final InAppUpdateTestGroup provideInAppUpdateTestGroup(@NotNull AbTestsConfigProvider abTestsConfigProvider) {
        Intrinsics.checkNotNullParameter(abTestsConfigProvider, "abTestsConfigProvider");
        return abTestsConfigProvider.inAppUpdate().getTestGroup();
    }

    @JobApplicationProgressBar
    @Provides
    @Reusable
    @NotNull
    public final ExposedAbTestGroup<SimpleTestGroup> provideJobApplicationProgressBarTestGroup(@NotNull AbTestsConfigProvider abTestsConfigProvider) {
        Intrinsics.checkNotNullParameter(abTestsConfigProvider, "abTestConfigProvider");
        return abTestsConfigProvider.jobApplicationProgressBar();
    }

    @Provides
    @Reusable
    @NotNull
    @JustDialSellerPhoneTestGroup
    public final AbTestGroup<SimpleTestGroupWithControl2> provideJustDialSellerPhoneTestGroup(@NotNull AbTestsConfigProvider abTestsConfigProvider) {
        Intrinsics.checkNotNullParameter(abTestsConfigProvider, "abTestsConfigProvider");
        return abTestsConfigProvider.justDialSellerPhone();
    }

    @Provides
    @Reusable
    @NotNull
    @MessengerSearchIconTest
    public final SimpleTestGroup provideMessengerSearchIconTestGroup(@NotNull AbTestsConfigProvider abTestsConfigProvider) {
        Intrinsics.checkNotNullParameter(abTestsConfigProvider, "abTestsConfigProvider");
        return abTestsConfigProvider.messengerSearchIcon().getTestGroup();
    }

    @Provides
    @Reusable
    @PriceOnTop
    @NotNull
    public final ExposedAbTestGroup<PriceOnTopTestGroup> provideOnTopTestGroup(@NotNull AbTestsConfigProvider abTestsConfigProvider) {
        Intrinsics.checkNotNullParameter(abTestsConfigProvider, "abTestsConfigProvider");
        return abTestsConfigProvider.priceOnTop();
    }

    @Provides
    @RealtyNewBackNavigation
    @Reusable
    @NotNull
    public final ManuallyExposedAbTestGroup<SimpleTestGroupWithNone> provideRealtyNewBackNavigationTestGroup(@NotNull AbTestsConfigProvider abTestsConfigProvider) {
        Intrinsics.checkNotNullParameter(abTestsConfigProvider, "abTestsConfigProvider");
        return abTestsConfigProvider.realtyNewBackNavigation();
    }

    @SellerInfoInRichSnippet
    @Provides
    @Reusable
    @NotNull
    public final SingleManuallyExposedAbTestGroup<SellerInfoInRichSnippetTestGroup> provideSellerInfoInRichSnippetTestGroup(@NotNull AbTestsConfigProvider abTestsConfigProvider) {
        Intrinsics.checkNotNullParameter(abTestsConfigProvider, "abTestsConfigProvider");
        return abTestsConfigProvider.sellerInfoInRichSnippet();
    }

    @Provides
    @SendEmployersPhoneOnCallToSellerButtonClickInResumes
    @Reusable
    @NotNull
    public final AbTestGroup<SendEmployersPhoneOnCallToSellerButtonClickInResumesTestGroup> provideSendEmployersPhoneOnCallButtonClickInVacanciesTestGroup(@NotNull AbTestsConfigProvider abTestsConfigProvider) {
        Intrinsics.checkNotNullParameter(abTestsConfigProvider, "abTestsConfigProvider");
        return abTestsConfigProvider.sendEmployersPhoneOnCallButtonClick();
    }

    @Provides
    @Reusable
    @NotNull
    public final SerpItemsPrefetchTestGroup provideSerpItemsPrefetchTestGroup(@NotNull AbTestsConfigProvider abTestsConfigProvider) {
        Intrinsics.checkNotNullParameter(abTestsConfigProvider, "abTestsConfigProvider");
        return abTestsConfigProvider.serpItemsPrefetch().getTestGroup();
    }

    @Provides
    @Reusable
    @NotNull
    public final SerpSkeletonTestGroup provideSerpSkeletonTest(@NotNull AbTestsConfigProvider abTestsConfigProvider) {
        Intrinsics.checkNotNullParameter(abTestsConfigProvider, "abTestsConfigProvider");
        return abTestsConfigProvider.serpSkeletonTest().getTestGroup();
    }

    @Provides
    @Reusable
    @NotNull
    public final SingleManuallyExposedAbTestGroup<TinkoffCreditCalculatorTestGroup> provideTinkoffCreditCalculatorTestGroup(@NotNull AbTestsConfigProvider abTestsConfigProvider) {
        Intrinsics.checkNotNullParameter(abTestsConfigProvider, "abTestsConfigProvider");
        return abTestsConfigProvider.tinkoffCreditCalculatorTest();
    }

    @Provides
    @Reusable
    @NotNull
    public final SingleManuallyExposedAbTestGroup<ViewedItemsTabTestGroup> provideViewedItemsTabTestGroub(@NotNull AbTestsConfigProvider abTestsConfigProvider) {
        Intrinsics.checkNotNullParameter(abTestsConfigProvider, "abTestsConfigProvider");
        return abTestsConfigProvider.viewedItemsTab();
    }

    @Provides
    @Reusable
    @NotNull
    public final SingleManuallyExposedAbTestGroup<ViewedItemsWidgetOnMainTestGroup> provideViewedItemsWidgetOnMain(@NotNull AbTestsConfigProvider abTestsConfigProvider) {
        Intrinsics.checkNotNullParameter(abTestsConfigProvider, "abTestsConfigProvider");
        return abTestsConfigProvider.viewedItemsWidgetOnMain();
    }

    @Provides
    @Reusable
    @NotNull
    public final SingleManuallyExposedAbTestGroup<PublishReviewFromChatChannelGroup> publishReviewFromChatChannel(@NotNull AbTestsConfigProvider abTestsConfigProvider) {
        Intrinsics.checkNotNullParameter(abTestsConfigProvider, "abTestsConfigProvider");
        return abTestsConfigProvider.publishReviewFromChatChannel();
    }

    @Provides
    @Reusable
    @NotNull
    public final SingleManuallyExposedAbTestGroup<SravniWebTestGroup> sravniWebTestGroup(@NotNull AbTestsConfigProvider abTestsConfigProvider) {
        Intrinsics.checkNotNullParameter(abTestsConfigProvider, "abTestsConfigProvider");
        return abTestsConfigProvider.sravniWeb();
    }

    @Provides
    @Reusable
    @NotNull
    public final SingleManuallyExposedAbTestGroup<UserAdvertsTabTestGroup> userAdvertsTabManuallyExposedTestGroup(@NotNull AbTestsConfigProvider abTestsConfigProvider) {
        Intrinsics.checkNotNullParameter(abTestsConfigProvider, "abTestsConfigProvider");
        return abTestsConfigProvider.userAdvertsNavigationTab();
    }

    @Provides
    @Reusable
    @NotNull
    public final UserAdvertsTabTestGroup userAdvertsTabTestGroup(@NotNull SingleManuallyExposedAbTestGroup<UserAdvertsTabTestGroup> singleManuallyExposedAbTestGroup) {
        Intrinsics.checkNotNullParameter(singleManuallyExposedAbTestGroup, "abTestGroup");
        return singleManuallyExposedAbTestGroup.getTestGroup();
    }
}
