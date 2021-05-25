package com.avito.android.ab_tests;

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
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000ò\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0002H&¢\u0006\u0004\b\u0007\u0010\u0005J\u0015\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0002H&¢\u0006\u0004\b\t\u0010\u0005J\u0015\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH&¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH&¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u000eH&¢\u0006\u0004\b\u0013\u0010\u0011J\u0015\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\nH&¢\u0006\u0004\b\u0015\u0010\rJ\u0015\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000eH&¢\u0006\u0004\b\u0016\u0010\u0011J\u0015\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u000eH&¢\u0006\u0004\b\u0018\u0010\u0011J\u0015\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00030\u000eH&¢\u0006\u0004\b\u0019\u0010\u0011J\u0015\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0002H&¢\u0006\u0004\b\u001b\u0010\u0005J\u0015\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\nH&¢\u0006\u0004\b\u001d\u0010\rJ\u0015\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0\u000eH&¢\u0006\u0004\b\u001f\u0010\u0011J\u0015\u0010\"\u001a\b\u0012\u0004\u0012\u00020!0 H&¢\u0006\u0004\b\"\u0010#J\u0015\u0010%\u001a\b\u0012\u0004\u0012\u00020$0\u0002H&¢\u0006\u0004\b%\u0010\u0005J\u0015\u0010'\u001a\b\u0012\u0004\u0012\u00020&0 H&¢\u0006\u0004\b'\u0010#J\u0015\u0010)\u001a\b\u0012\u0004\u0012\u00020(0 H&¢\u0006\u0004\b)\u0010#J\u0015\u0010+\u001a\b\u0012\u0004\u0012\u00020*0 H&¢\u0006\u0004\b+\u0010#J\u0015\u0010-\u001a\b\u0012\u0004\u0012\u00020,0 H&¢\u0006\u0004\b-\u0010#J\u0015\u0010/\u001a\b\u0012\u0004\u0012\u00020.0\nH&¢\u0006\u0004\b/\u0010\rJ\u0015\u00101\u001a\b\u0012\u0004\u0012\u0002000\nH&¢\u0006\u0004\b1\u0010\rJ\u0015\u00103\u001a\b\u0012\u0004\u0012\u0002020\nH&¢\u0006\u0004\b3\u0010\rJ\u0015\u00105\u001a\b\u0012\u0004\u0012\u0002040\nH&¢\u0006\u0004\b5\u0010\rJ\u0015\u00107\u001a\b\u0012\u0004\u0012\u0002060 H&¢\u0006\u0004\b7\u0010#J\u0015\u00108\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000eH&¢\u0006\u0004\b8\u0010\u0011J\u0015\u0010:\u001a\b\u0012\u0004\u0012\u0002090\u0002H&¢\u0006\u0004\b:\u0010\u0005J\u0015\u0010<\u001a\b\u0012\u0004\u0012\u00020;0 H&¢\u0006\u0004\b<\u0010#J\u0015\u0010>\u001a\b\u0012\u0004\u0012\u00020=0\u000eH&¢\u0006\u0004\b>\u0010\u0011J\u0015\u0010?\u001a\b\u0012\u0004\u0012\u00020\u00030\u000eH&¢\u0006\u0004\b?\u0010\u0011J\u0015\u0010A\u001a\b\u0012\u0004\u0012\u00020@0 H&¢\u0006\u0004\bA\u0010#J\u0015\u0010C\u001a\b\u0012\u0004\u0012\u00020B0\nH&¢\u0006\u0004\bC\u0010\rJ\u0015\u0010D\u001a\b\u0012\u0004\u0012\u00020\u00030\u000eH&¢\u0006\u0004\bD\u0010\u0011J\u0015\u0010F\u001a\b\u0012\u0004\u0012\u00020E0 H&¢\u0006\u0004\bF\u0010#J\u0015\u0010H\u001a\b\u0012\u0004\u0012\u00020G0\nH&¢\u0006\u0004\bH\u0010\rJ\u0015\u0010J\u001a\b\u0012\u0004\u0012\u00020I0\nH&¢\u0006\u0004\bJ\u0010\rJ\u0015\u0010L\u001a\b\u0012\u0004\u0012\u00020K0\u000eH&¢\u0006\u0004\bL\u0010\u0011J\u0015\u0010N\u001a\b\u0012\u0004\u0012\u00020M0 H&¢\u0006\u0004\bN\u0010#J\u0015\u0010P\u001a\b\u0012\u0004\u0012\u00020O0 H&¢\u0006\u0004\bP\u0010#J\u0015\u0010Q\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH&¢\u0006\u0004\bQ\u0010\rJ\u0015\u0010R\u001a\b\u0012\u0004\u0012\u00020\u00030 H&¢\u0006\u0004\bR\u0010#J\u0015\u0010S\u001a\b\u0012\u0004\u0012\u00020\u00030\nH&¢\u0006\u0004\bS\u0010\r¨\u0006T"}, d2 = {"Lcom/avito/android/ab_tests/AbTestsConfigProvider;", "", "Lcom/avito/android/ab_tests/models/AbTestGroup;", "Lcom/avito/android/ab_tests/groups/SimpleTestGroup;", "messengerSearchIcon", "()Lcom/avito/android/ab_tests/models/AbTestGroup;", "Lcom/avito/android/ab_tests/groups/InAppUpdateTestGroup;", "inAppUpdate", "Lcom/avito/android/ab_tests/groups/AdvertDetailsIcebreakerStyleTestGroup;", "advertDetailsIcebreakerStyle", "Lcom/avito/android/ab_tests/models/ExposedAbTestGroup;", "Lcom/avito/android/ab_tests/groups/SimpleTestGroupWithNone;", "advertContactApplyWithoutChat", "()Lcom/avito/android/ab_tests/models/ExposedAbTestGroup;", "Lcom/avito/android/ab_tests/models/ManuallyExposedAbTestGroup;", "Lcom/avito/android/ab_tests/groups/AdvertDetailsNoCallFeedbackTestGroup;", "advertDetailsNoCallFeedbackTestGroup", "()Lcom/avito/android/ab_tests/models/ManuallyExposedAbTestGroup;", "Lcom/avito/android/ab_tests/groups/AdvertDetailsMarketplaceNoPurchaseFeedbackTestGroup;", "advertDetailsMarketplaceNoPurchaseFeedbackTestGroup", "Lcom/avito/android/ab_tests/groups/AdvertDetailsMarketplaceImprovingContentItemsTestGroup;", "advertDetailsMarketplaceImprovingContentItemsTestGroup", "advertDetailsMarketplaceDeliveryItemTestGroup", "Lcom/avito/android/ab_tests/groups/AdvertDetailsMarketplaceBadgeBarItemTestGroup;", "advertDetailsMarketplaceBadgeBarItemTestGroup", "buyerAsksSellerTtlItem", "Lcom/avito/android/ab_tests/groups/SimpleTestGroupWithControl2;", "justDialSellerPhone", "Lcom/avito/android/ab_tests/configs/PriceOnTopTestGroup;", "priceOnTop", "Lcom/avito/android/ab_tests/groups/AdvertDetailsPriceSubscriptionTestGroup;", "advertDetailsPriceSubscription", "Lcom/avito/android/ab_tests/models/SingleManuallyExposedAbTestGroup;", "Lcom/avito/android/ab_tests/groups/AutoBrandModelTypoCorrectionTestGroup;", "autoBrandModelTypoCorrection", "()Lcom/avito/android/ab_tests/models/SingleManuallyExposedAbTestGroup;", "Lcom/avito/android/ab_tests/configs/AntifraudStartupBannerTestGroup;", "antifraudStartupBanner", "Lcom/avito/android/ab_tests/configs/AntiFraudCheckListTestGroup;", "antiFraudCheckList", "Lcom/avito/android/ab_tests/configs/SellerInfoInRichSnippetTestGroup;", "sellerInfoInRichSnippet", "Lcom/avito/android/ab_tests/groups/ViewedItemsTabTestGroup;", "viewedItemsTab", "Lcom/avito/android/ab_tests/groups/ViewedItemsWidgetOnMainTestGroup;", "viewedItemsWidgetOnMain", "Lcom/avito/android/ab_tests/groups/SimpleTestGroupWithNoneControl2;", "advertSpeedUpTest", "Lcom/avito/android/ab_tests/groups/SerpSkeletonTestGroup;", "serpSkeletonTest", "Lcom/avito/android/ab_tests/groups/HomeSkeletonTestGroup;", "homeSkeletonTest", "Lcom/avito/android/ab_tests/configs/HomeNewRubricatorTestGroup;", "homeNewRubricator", "Lcom/avito/android/ab_tests/configs/TinkoffCreditCalculatorTestGroup;", "tinkoffCreditCalculatorTest", "realtyNewBackNavigation", "Lcom/avito/android/ab_tests/configs/SerpItemsPrefetchTestGroup;", "serpItemsPrefetch", "Lcom/avito/android/ab_tests/groups/AdCascadesInChannelsTestGroup;", "adCascadesInChannels", "Lcom/avito/android/ab_tests/groups/MessengerFolderTabsTestGroup;", "messengerFolderTabs", "notReadyVideoOnPublish", "Lcom/avito/android/ab_tests/configs/SravniWebTestGroup;", "sravniWeb", "Lcom/avito/android/ab_tests/configs/OrangeAdBadgeTestGroup;", "orangeAdBadge", "draftsOnStartPublishSheet", "Lcom/avito/android/ab_tests/groups/PublishReviewFromChatChannelGroup;", "publishReviewFromChatChannel", "Lcom/avito/android/ab_tests/groups/CallsNewDesignTestGroup;", "callsNewDesign", "Lcom/avito/android/ab_tests/groups/SendEmployersPhoneOnCallToSellerButtonClickInResumesTestGroup;", "sendEmployersPhoneOnCallButtonClick", "Lcom/avito/android/ab_tests/groups/AdvertAutotekaTeaserInGalleryTestGroup;", "advertAutotekaTeaserInGallery", "Lcom/avito/android/ab_tests/groups/CallsEarlyBeepsTestGroup;", "callsEarlyBeeps", "Lcom/avito/android/ab_tests/configs/UserAdvertsTabTestGroup;", "userAdvertsNavigationTab", "favoriteSimilarAdvertsTestGroup", "autoGenerationsFilterWithPhotos", "jobApplicationProgressBar", "ab-tests_release"}, k = 1, mv = {1, 4, 2})
public interface AbTestsConfigProvider {
    @NotNull
    SingleManuallyExposedAbTestGroup<AdCascadesInChannelsTestGroup> adCascadesInChannels();

    @NotNull
    ManuallyExposedAbTestGroup<AdvertAutotekaTeaserInGalleryTestGroup> advertAutotekaTeaserInGallery();

    @NotNull
    ExposedAbTestGroup<SimpleTestGroupWithNone> advertContactApplyWithoutChat();

    @NotNull
    AbTestGroup<AdvertDetailsIcebreakerStyleTestGroup> advertDetailsIcebreakerStyle();

    @NotNull
    ManuallyExposedAbTestGroup<AdvertDetailsMarketplaceBadgeBarItemTestGroup> advertDetailsMarketplaceBadgeBarItemTestGroup();

    @NotNull
    ManuallyExposedAbTestGroup<SimpleTestGroupWithNone> advertDetailsMarketplaceDeliveryItemTestGroup();

    @NotNull
    ExposedAbTestGroup<AdvertDetailsMarketplaceImprovingContentItemsTestGroup> advertDetailsMarketplaceImprovingContentItemsTestGroup();

    @NotNull
    ManuallyExposedAbTestGroup<AdvertDetailsMarketplaceNoPurchaseFeedbackTestGroup> advertDetailsMarketplaceNoPurchaseFeedbackTestGroup();

    @NotNull
    ManuallyExposedAbTestGroup<AdvertDetailsNoCallFeedbackTestGroup> advertDetailsNoCallFeedbackTestGroup();

    @NotNull
    ManuallyExposedAbTestGroup<AdvertDetailsPriceSubscriptionTestGroup> advertDetailsPriceSubscription();

    @NotNull
    ExposedAbTestGroup<SimpleTestGroupWithNoneControl2> advertSpeedUpTest();

    @NotNull
    SingleManuallyExposedAbTestGroup<AntiFraudCheckListTestGroup> antiFraudCheckList();

    @NotNull
    AbTestGroup<AntifraudStartupBannerTestGroup> antifraudStartupBanner();

    @NotNull
    SingleManuallyExposedAbTestGroup<AutoBrandModelTypoCorrectionTestGroup> autoBrandModelTypoCorrection();

    @NotNull
    SingleManuallyExposedAbTestGroup<SimpleTestGroup> autoGenerationsFilterWithPhotos();

    @NotNull
    ManuallyExposedAbTestGroup<SimpleTestGroup> buyerAsksSellerTtlItem();

    @NotNull
    SingleManuallyExposedAbTestGroup<CallsEarlyBeepsTestGroup> callsEarlyBeeps();

    @NotNull
    ExposedAbTestGroup<CallsNewDesignTestGroup> callsNewDesign();

    @NotNull
    ManuallyExposedAbTestGroup<SimpleTestGroup> draftsOnStartPublishSheet();

    @NotNull
    ExposedAbTestGroup<SimpleTestGroupWithNone> favoriteSimilarAdvertsTestGroup();

    @NotNull
    ExposedAbTestGroup<HomeNewRubricatorTestGroup> homeNewRubricator();

    @NotNull
    ExposedAbTestGroup<HomeSkeletonTestGroup> homeSkeletonTest();

    @NotNull
    AbTestGroup<InAppUpdateTestGroup> inAppUpdate();

    @NotNull
    ExposedAbTestGroup<SimpleTestGroup> jobApplicationProgressBar();

    @NotNull
    AbTestGroup<SimpleTestGroupWithControl2> justDialSellerPhone();

    @NotNull
    ManuallyExposedAbTestGroup<MessengerFolderTabsTestGroup> messengerFolderTabs();

    @NotNull
    AbTestGroup<SimpleTestGroup> messengerSearchIcon();

    @NotNull
    ManuallyExposedAbTestGroup<SimpleTestGroup> notReadyVideoOnPublish();

    @NotNull
    ExposedAbTestGroup<OrangeAdBadgeTestGroup> orangeAdBadge();

    @NotNull
    ExposedAbTestGroup<PriceOnTopTestGroup> priceOnTop();

    @NotNull
    SingleManuallyExposedAbTestGroup<PublishReviewFromChatChannelGroup> publishReviewFromChatChannel();

    @NotNull
    ManuallyExposedAbTestGroup<SimpleTestGroupWithNone> realtyNewBackNavigation();

    @NotNull
    SingleManuallyExposedAbTestGroup<SellerInfoInRichSnippetTestGroup> sellerInfoInRichSnippet();

    @NotNull
    ExposedAbTestGroup<SendEmployersPhoneOnCallToSellerButtonClickInResumesTestGroup> sendEmployersPhoneOnCallButtonClick();

    @NotNull
    AbTestGroup<SerpItemsPrefetchTestGroup> serpItemsPrefetch();

    @NotNull
    ExposedAbTestGroup<SerpSkeletonTestGroup> serpSkeletonTest();

    @NotNull
    SingleManuallyExposedAbTestGroup<SravniWebTestGroup> sravniWeb();

    @NotNull
    SingleManuallyExposedAbTestGroup<TinkoffCreditCalculatorTestGroup> tinkoffCreditCalculatorTest();

    @NotNull
    SingleManuallyExposedAbTestGroup<UserAdvertsTabTestGroup> userAdvertsNavigationTab();

    @NotNull
    SingleManuallyExposedAbTestGroup<ViewedItemsTabTestGroup> viewedItemsTab();

    @NotNull
    SingleManuallyExposedAbTestGroup<ViewedItemsWidgetOnMainTestGroup> viewedItemsWidgetOnMain();
}
