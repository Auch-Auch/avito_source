package com.avito.android.ab_tests;

import a2.g.r.g;
import androidx.annotation.VisibleForTesting;
import com.avito.android.Features;
import com.avito.android.ab_tests.configs.AdCascadesInChannelsTestConfig;
import com.avito.android.ab_tests.configs.AdvertAutotekaTeaserInGalleryTestConfig;
import com.avito.android.ab_tests.configs.AdvertContactApplyWithoutChatTestConfig;
import com.avito.android.ab_tests.configs.AdvertDetailsIcebreakerStyleTestConfig;
import com.avito.android.ab_tests.configs.AdvertDetailsMarketplaceBadgeBarItemTestConfig;
import com.avito.android.ab_tests.configs.AdvertDetailsMarketplaceDeliveryItemTestConfig;
import com.avito.android.ab_tests.configs.AdvertDetailsMarketplaceImprovingContentItemsTestConfig;
import com.avito.android.ab_tests.configs.AdvertDetailsMarketplaceNoPurchaseFeedbackTestConfig;
import com.avito.android.ab_tests.configs.AdvertDetailsNoCallFeedbackTestConfig;
import com.avito.android.ab_tests.configs.AdvertDetailsPriceSubscriptionTestConfig;
import com.avito.android.ab_tests.configs.AdvertSpeedUpTestConfig;
import com.avito.android.ab_tests.configs.AntiFraudCheckListTestConfig;
import com.avito.android.ab_tests.configs.AntiFraudCheckListTestGroup;
import com.avito.android.ab_tests.configs.AntifraudStartupBannerTestConfig;
import com.avito.android.ab_tests.configs.AntifraudStartupBannerTestGroup;
import com.avito.android.ab_tests.configs.AutoBrandModelTypoCorrectionTestConfig;
import com.avito.android.ab_tests.configs.AutoGenerationsFilterWithPhotosTestConfig;
import com.avito.android.ab_tests.configs.BuyerAsksSellerTtlItemTestConfig;
import com.avito.android.ab_tests.configs.CallsEarlyBeepsTestConfig;
import com.avito.android.ab_tests.configs.CallsNewDesignTestConfig;
import com.avito.android.ab_tests.configs.DraftsOnStartPublishSheetTestConfig;
import com.avito.android.ab_tests.configs.FavoriteSimilarAdvertsTestConfig;
import com.avito.android.ab_tests.configs.HomeNewRubricatorTestConfig;
import com.avito.android.ab_tests.configs.HomeNewRubricatorTestGroup;
import com.avito.android.ab_tests.configs.HomeSkeletonTestConfig;
import com.avito.android.ab_tests.configs.InAppUpdateTestConfig;
import com.avito.android.ab_tests.configs.JobApplicationProgressBarTestConfig;
import com.avito.android.ab_tests.configs.JustDialSellerPhoneTestConfig;
import com.avito.android.ab_tests.configs.MessengerFolderTabsTestConfig;
import com.avito.android.ab_tests.configs.MessengerSearchIconTestConfig;
import com.avito.android.ab_tests.configs.NotReadyVideoOnPublishTestConfig;
import com.avito.android.ab_tests.configs.OrangeAdBadgeConfig;
import com.avito.android.ab_tests.configs.OrangeAdBadgeTestGroup;
import com.avito.android.ab_tests.configs.PriceOnTopConfig;
import com.avito.android.ab_tests.configs.PriceOnTopTestGroup;
import com.avito.android.ab_tests.configs.PublishReviewFromChatChannelConfig;
import com.avito.android.ab_tests.configs.RealtyNewBackNavigationTestConfig;
import com.avito.android.ab_tests.configs.SellerInfoInRichSnippetConfig;
import com.avito.android.ab_tests.configs.SellerInfoInRichSnippetTestGroup;
import com.avito.android.ab_tests.configs.SendEmployersPhoneOnCallButtonClickInResumeTestConfig;
import com.avito.android.ab_tests.configs.SerpItemsPrefetchTestConfig;
import com.avito.android.ab_tests.configs.SerpItemsPrefetchTestGroup;
import com.avito.android.ab_tests.configs.SerpSkeletonTestConfig;
import com.avito.android.ab_tests.configs.SravniWebTestConfig;
import com.avito.android.ab_tests.configs.SravniWebTestGroup;
import com.avito.android.ab_tests.configs.TinkoffCreditCalculatorTestConfig;
import com.avito.android.ab_tests.configs.TinkoffCreditCalculatorTestGroup;
import com.avito.android.ab_tests.configs.UserAdvertsTabTestConfig;
import com.avito.android.ab_tests.configs.UserAdvertsTabTestGroup;
import com.avito.android.ab_tests.configs.ViewedItemsTabTestConfig;
import com.avito.android.ab_tests.configs.ViewedItemsWidgetOnMainTestConfig;
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
import com.avito.android.ab_tests.models.RemoteNamingGroup;
import com.avito.android.ab_tests.models.SingleManuallyExposedAbTestGroup;
import com.avito.android.ab_tests.models.TestGroupWithClientExposure;
import com.avito.android.analytics.Analytics;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Navigation;
import com.avito.android.remote.model.ab_tests.AbTest;
import com.avito.android.remote.model.ab_tests.AbTestsConfigResponse;
import com.avito.android.util.BuildInfo;
import com.avito.android.util.Logs;
import com.google.gson.Gson;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000È\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B7\u0012\u0006\u0010l\u001a\u00020i\u0012\u0006\u0010z\u001a\u00020w\u0012\u0006\u0010`\u001a\u00020]\u0012\u0006\u0010d\u001a\u00020a\u0012\u0006\u0010h\u001a\u00020e\u0012\u0006\u0010p\u001a\u00020m¢\u0006\u0004\b{\u0010|J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0017¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000bH\u0016¢\u0006\u0004\b\u0010\u0010\u000eJ\u0015\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u000bH\u0016¢\u0006\u0004\b\u0012\u0010\u000eJ\u0015\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u0015\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0017H\u0016¢\u0006\u0004\b\u001c\u0010\u001aJ\u0015\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0013H\u0016¢\u0006\u0004\b\u001e\u0010\u0016J\u0015\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00140\u0017H\u0016¢\u0006\u0004\b\u001f\u0010\u001aJ\u0015\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\u0017H\u0016¢\u0006\u0004\b!\u0010\u001aJ\u0015\u0010\"\u001a\b\u0012\u0004\u0012\u00020\f0\u0017H\u0016¢\u0006\u0004\b\"\u0010\u001aJ\u0015\u0010$\u001a\b\u0012\u0004\u0012\u00020#0\u000bH\u0016¢\u0006\u0004\b$\u0010\u000eJ\u0015\u0010&\u001a\b\u0012\u0004\u0012\u00020%0\u0013H\u0016¢\u0006\u0004\b&\u0010\u0016J\u0015\u0010(\u001a\b\u0012\u0004\u0012\u00020'0\u0017H\u0016¢\u0006\u0004\b(\u0010\u001aJ\u0015\u0010+\u001a\b\u0012\u0004\u0012\u00020*0)H\u0016¢\u0006\u0004\b+\u0010,J\u0015\u0010.\u001a\b\u0012\u0004\u0012\u00020-0\u000bH\u0016¢\u0006\u0004\b.\u0010\u000eJ\u0015\u00100\u001a\b\u0012\u0004\u0012\u00020/0)H\u0016¢\u0006\u0004\b0\u0010,J\u0015\u00102\u001a\b\u0012\u0004\u0012\u0002010)H\u0016¢\u0006\u0004\b2\u0010,J\u0015\u00104\u001a\b\u0012\u0004\u0012\u0002030\u0013H\u0016¢\u0006\u0004\b4\u0010\u0016J\u0015\u00106\u001a\b\u0012\u0004\u0012\u0002050\u0013H\u0016¢\u0006\u0004\b6\u0010\u0016J\u0015\u00108\u001a\b\u0012\u0004\u0012\u0002070\u0013H\u0016¢\u0006\u0004\b8\u0010\u0016J\u0015\u0010:\u001a\b\u0012\u0004\u0012\u0002090\u0013H\u0016¢\u0006\u0004\b:\u0010\u0016J\u0015\u0010<\u001a\b\u0012\u0004\u0012\u00020;0)H\u0016¢\u0006\u0004\b<\u0010,J\u0015\u0010>\u001a\b\u0012\u0004\u0012\u00020=0)H\u0016¢\u0006\u0004\b>\u0010,J\u0015\u0010@\u001a\b\u0012\u0004\u0012\u00020?0)H\u0016¢\u0006\u0004\b@\u0010,J\u0015\u0010A\u001a\b\u0012\u0004\u0012\u00020\u00140\u0017H\u0016¢\u0006\u0004\bA\u0010\u001aJ\u0015\u0010C\u001a\b\u0012\u0004\u0012\u00020B0\u000bH\u0016¢\u0006\u0004\bC\u0010\u000eJ\u0015\u0010E\u001a\b\u0012\u0004\u0012\u00020D0)H\u0016¢\u0006\u0004\bE\u0010,J\u0015\u0010G\u001a\b\u0012\u0004\u0012\u00020F0\u0017H\u0016¢\u0006\u0004\bG\u0010\u001aJ\u0015\u0010H\u001a\b\u0012\u0004\u0012\u00020\f0\u0017H\u0016¢\u0006\u0004\bH\u0010\u001aJ\u0015\u0010J\u001a\b\u0012\u0004\u0012\u00020I0)H\u0016¢\u0006\u0004\bJ\u0010,J\u0015\u0010L\u001a\b\u0012\u0004\u0012\u00020K0\u0013H\u0016¢\u0006\u0004\bL\u0010\u0016J\u0015\u0010M\u001a\b\u0012\u0004\u0012\u00020\f0\u0017H\u0016¢\u0006\u0004\bM\u0010\u001aJ\u0015\u0010O\u001a\b\u0012\u0004\u0012\u00020N0)H\u0016¢\u0006\u0004\bO\u0010,J\u0015\u0010Q\u001a\b\u0012\u0004\u0012\u00020P0\u0013H\u0016¢\u0006\u0004\bQ\u0010\u0016J\u0015\u0010S\u001a\b\u0012\u0004\u0012\u00020R0\u0013H\u0016¢\u0006\u0004\bS\u0010\u0016J\u0015\u0010U\u001a\b\u0012\u0004\u0012\u00020T0\u0017H\u0016¢\u0006\u0004\bU\u0010\u001aJ\u0015\u0010W\u001a\b\u0012\u0004\u0012\u00020V0)H\u0016¢\u0006\u0004\bW\u0010,J\u0015\u0010Y\u001a\b\u0012\u0004\u0012\u00020X0)H\u0016¢\u0006\u0004\bY\u0010,J\u0015\u0010Z\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0016¢\u0006\u0004\bZ\u0010\u0016J\u0015\u0010[\u001a\b\u0012\u0004\u0012\u00020\f0)H\u0016¢\u0006\u0004\b[\u0010,J\u0015\u0010\\\u001a\b\u0012\u0004\u0012\u00020\f0\u0013H\u0016¢\u0006\u0004\b\\\u0010\u0016R\u0016\u0010`\u001a\u00020]8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b^\u0010_R\u0016\u0010d\u001a\u00020a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bb\u0010cR\u0016\u0010h\u001a\u00020e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bf\u0010gR\u0016\u0010l\u001a\u00020i8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bj\u0010kR\u0016\u0010p\u001a\u00020m8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bn\u0010oR&\u0010v\u001a\u0012\u0012\u0004\u0012\u00020r\u0012\b\u0012\u0006\u0012\u0002\b\u00030s0q8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bt\u0010uR\u0016\u0010z\u001a\u00020w8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bx\u0010y¨\u0006}"}, d2 = {"Lcom/avito/android/ab_tests/AbTestsConfigStorage;", "Lcom/avito/android/ab_tests/AbTestsConfigSaver;", "Lcom/avito/android/ab_tests/AbTestsConfigProvider;", "Lcom/avito/android/ab_tests/AbTestsCache;", "Lcom/avito/android/remote/model/ab_tests/AbTestsConfigResponse;", Navigation.CONFIG, "", "store", "(Lcom/avito/android/remote/model/ab_tests/AbTestsConfigResponse;)V", "clear", "()V", "Lcom/avito/android/ab_tests/models/AbTestGroup;", "Lcom/avito/android/ab_tests/groups/SimpleTestGroup;", "messengerSearchIcon", "()Lcom/avito/android/ab_tests/models/AbTestGroup;", "Lcom/avito/android/ab_tests/groups/InAppUpdateTestGroup;", "inAppUpdate", "Lcom/avito/android/ab_tests/groups/AdvertDetailsIcebreakerStyleTestGroup;", "advertDetailsIcebreakerStyle", "Lcom/avito/android/ab_tests/models/ExposedAbTestGroup;", "Lcom/avito/android/ab_tests/groups/SimpleTestGroupWithNone;", "advertContactApplyWithoutChat", "()Lcom/avito/android/ab_tests/models/ExposedAbTestGroup;", "Lcom/avito/android/ab_tests/models/ManuallyExposedAbTestGroup;", "Lcom/avito/android/ab_tests/groups/AdvertDetailsNoCallFeedbackTestGroup;", "advertDetailsNoCallFeedbackTestGroup", "()Lcom/avito/android/ab_tests/models/ManuallyExposedAbTestGroup;", "Lcom/avito/android/ab_tests/groups/AdvertDetailsMarketplaceNoPurchaseFeedbackTestGroup;", "advertDetailsMarketplaceNoPurchaseFeedbackTestGroup", "Lcom/avito/android/ab_tests/groups/AdvertDetailsMarketplaceImprovingContentItemsTestGroup;", "advertDetailsMarketplaceImprovingContentItemsTestGroup", "advertDetailsMarketplaceDeliveryItemTestGroup", "Lcom/avito/android/ab_tests/groups/AdvertDetailsMarketplaceBadgeBarItemTestGroup;", "advertDetailsMarketplaceBadgeBarItemTestGroup", "buyerAsksSellerTtlItem", "Lcom/avito/android/ab_tests/groups/SimpleTestGroupWithControl2;", "justDialSellerPhone", "Lcom/avito/android/ab_tests/configs/PriceOnTopTestGroup;", "priceOnTop", "Lcom/avito/android/ab_tests/groups/AdvertDetailsPriceSubscriptionTestGroup;", "advertDetailsPriceSubscription", "Lcom/avito/android/ab_tests/models/SingleManuallyExposedAbTestGroup;", "Lcom/avito/android/ab_tests/groups/AutoBrandModelTypoCorrectionTestGroup;", "autoBrandModelTypoCorrection", "()Lcom/avito/android/ab_tests/models/SingleManuallyExposedAbTestGroup;", "Lcom/avito/android/ab_tests/configs/AntifraudStartupBannerTestGroup;", "antifraudStartupBanner", "Lcom/avito/android/ab_tests/configs/AntiFraudCheckListTestGroup;", "antiFraudCheckList", "Lcom/avito/android/ab_tests/configs/SellerInfoInRichSnippetTestGroup;", "sellerInfoInRichSnippet", "Lcom/avito/android/ab_tests/groups/SimpleTestGroupWithNoneControl2;", "advertSpeedUpTest", "Lcom/avito/android/ab_tests/groups/SerpSkeletonTestGroup;", "serpSkeletonTest", "Lcom/avito/android/ab_tests/groups/HomeSkeletonTestGroup;", "homeSkeletonTest", "Lcom/avito/android/ab_tests/configs/HomeNewRubricatorTestGroup;", "homeNewRubricator", "Lcom/avito/android/ab_tests/configs/TinkoffCreditCalculatorTestGroup;", "tinkoffCreditCalculatorTest", "Lcom/avito/android/ab_tests/groups/ViewedItemsTabTestGroup;", "viewedItemsTab", "Lcom/avito/android/ab_tests/groups/ViewedItemsWidgetOnMainTestGroup;", "viewedItemsWidgetOnMain", "realtyNewBackNavigation", "Lcom/avito/android/ab_tests/configs/SerpItemsPrefetchTestGroup;", "serpItemsPrefetch", "Lcom/avito/android/ab_tests/groups/AdCascadesInChannelsTestGroup;", "adCascadesInChannels", "Lcom/avito/android/ab_tests/groups/MessengerFolderTabsTestGroup;", "messengerFolderTabs", "notReadyVideoOnPublish", "Lcom/avito/android/ab_tests/configs/SravniWebTestGroup;", "sravniWeb", "Lcom/avito/android/ab_tests/configs/OrangeAdBadgeTestGroup;", "orangeAdBadge", "draftsOnStartPublishSheet", "Lcom/avito/android/ab_tests/groups/PublishReviewFromChatChannelGroup;", "publishReviewFromChatChannel", "Lcom/avito/android/ab_tests/groups/CallsNewDesignTestGroup;", "callsNewDesign", "Lcom/avito/android/ab_tests/groups/SendEmployersPhoneOnCallToSellerButtonClickInResumesTestGroup;", "sendEmployersPhoneOnCallButtonClick", "Lcom/avito/android/ab_tests/groups/AdvertAutotekaTeaserInGalleryTestGroup;", "advertAutotekaTeaserInGallery", "Lcom/avito/android/ab_tests/groups/CallsEarlyBeepsTestGroup;", "callsEarlyBeeps", "Lcom/avito/android/ab_tests/configs/UserAdvertsTabTestGroup;", "userAdvertsNavigationTab", "favoriteSimilarAdvertsTestGroup", "autoGenerationsFilterWithPhotos", "jobApplicationProgressBar", "Lcom/avito/android/Features;", "d", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/analytics/Analytics;", "e", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/util/BuildInfo;", "f", "Lcom/avito/android/util/BuildInfo;", "buildInfo", "Lcom/avito/android/ab_tests/AbTestPrefs;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/ab_tests/AbTestPrefs;", "abTestPrefs", "Lcom/google/gson/Gson;", g.a, "Lcom/google/gson/Gson;", "gson", "", "", "Lcom/avito/android/ab_tests/models/TestGroupWithClientExposure;", AuthSource.SEND_ABUSE, "Ljava/util/Map;", "cache", "Lcom/avito/android/ab_tests/UsedAbTestReporter;", "c", "Lcom/avito/android/ab_tests/UsedAbTestReporter;", "usedAbTestReporter", "<init>", "(Lcom/avito/android/ab_tests/AbTestPrefs;Lcom/avito/android/ab_tests/UsedAbTestReporter;Lcom/avito/android/Features;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/util/BuildInfo;Lcom/google/gson/Gson;)V", "ab-tests_release"}, k = 1, mv = {1, 4, 2})
public class AbTestsConfigStorage implements AbTestsConfigSaver, AbTestsConfigProvider, AbTestsCache {
    public final Map<String, TestGroupWithClientExposure<?>> a = new LinkedHashMap();
    public final AbTestPrefs b;
    public final UsedAbTestReporter c;
    public final Features d;
    public final Analytics e;
    public final BuildInfo f;
    public final Gson g;

    public AbTestsConfigStorage(@NotNull AbTestPrefs abTestPrefs, @NotNull UsedAbTestReporter usedAbTestReporter, @NotNull Features features, @NotNull Analytics analytics, @NotNull BuildInfo buildInfo, @NotNull Gson gson) {
        Intrinsics.checkNotNullParameter(abTestPrefs, "abTestPrefs");
        Intrinsics.checkNotNullParameter(usedAbTestReporter, "usedAbTestReporter");
        Intrinsics.checkNotNullParameter(features, "features");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(buildInfo, "buildInfo");
        Intrinsics.checkNotNullParameter(gson, "gson");
        this.b = abTestPrefs;
        this.c = usedAbTestReporter;
        this.d = features;
        this.e = analytics;
        this.f = buildInfo;
        this.g = gson;
    }

    public static final Object access$getAbTestConfig(AbTestsConfigStorage abTestsConfigStorage, AbTest abTest, Class cls) {
        Objects.requireNonNull(abTestsConfigStorage);
        if (abTest == null || cls == null) {
            return null;
        }
        try {
            return abTestsConfigStorage.g.fromJson(abTest.getTestConfig(), (Class<Object>) cls);
        } catch (Exception e2) {
            Logs.error("Failed parse ab test config", e2);
            return null;
        }
    }

    @Override // com.avito.android.ab_tests.AbTestsConfigProvider
    @NotNull
    public SingleManuallyExposedAbTestGroup<AdCascadesInChannelsTestGroup> adCascadesInChannels() {
        TestGroupWithClientExposure testGroupWithClientExposure;
        AdCascadesInChannelsTestConfig adCascadesInChannelsTestConfig = new AdCascadesInChannelsTestConfig();
        if (!adCascadesInChannelsTestConfig.getConsistentWithinSession() || (testGroupWithClientExposure = (TestGroupWithClientExposure) this.a.get(adCascadesInChannelsTestConfig.getRemoteKey())) == null || !(testGroupWithClientExposure.getTestGroup() instanceof AdCascadesInChannelsTestGroup)) {
            AbTest abTest = this.b.getAbTest(adCascadesInChannelsTestConfig.getRemoteKey());
            testGroupWithClientExposure = adCascadesInChannelsTestConfig.createAbTest(abTest, this.d, this.f, access$getAbTestConfig(this, abTest, adCascadesInChannelsTestConfig.getTestConfigClass()), adCascadesInChannelsTestConfig.getRemoteKey());
            if (adCascadesInChannelsTestConfig.getConsistentWithinSession()) {
                this.a.put(adCascadesInChannelsTestConfig.getRemoteKey(), testGroupWithClientExposure);
            }
            this.c.reportUsageTest(adCascadesInChannelsTestConfig.getRemoteKey(), (RemoteNamingGroup) testGroupWithClientExposure.getTestGroup());
        }
        return new SingleManuallyExposedAbTestGroup<>(testGroupWithClientExposure, this.e);
    }

    @Override // com.avito.android.ab_tests.AbTestsConfigProvider
    @NotNull
    public ManuallyExposedAbTestGroup<AdvertAutotekaTeaserInGalleryTestGroup> advertAutotekaTeaserInGallery() {
        TestGroupWithClientExposure testGroupWithClientExposure;
        AdvertAutotekaTeaserInGalleryTestConfig advertAutotekaTeaserInGalleryTestConfig = new AdvertAutotekaTeaserInGalleryTestConfig();
        if (!advertAutotekaTeaserInGalleryTestConfig.getConsistentWithinSession() || (testGroupWithClientExposure = (TestGroupWithClientExposure) this.a.get(advertAutotekaTeaserInGalleryTestConfig.getRemoteKey())) == null || !(testGroupWithClientExposure.getTestGroup() instanceof AdvertAutotekaTeaserInGalleryTestGroup)) {
            AbTest abTest = this.b.getAbTest(advertAutotekaTeaserInGalleryTestConfig.getRemoteKey());
            testGroupWithClientExposure = advertAutotekaTeaserInGalleryTestConfig.createAbTest(abTest, this.d, this.f, access$getAbTestConfig(this, abTest, advertAutotekaTeaserInGalleryTestConfig.getTestConfigClass()), advertAutotekaTeaserInGalleryTestConfig.getRemoteKey());
            if (advertAutotekaTeaserInGalleryTestConfig.getConsistentWithinSession()) {
                this.a.put(advertAutotekaTeaserInGalleryTestConfig.getRemoteKey(), testGroupWithClientExposure);
            }
            this.c.reportUsageTest(advertAutotekaTeaserInGalleryTestConfig.getRemoteKey(), (RemoteNamingGroup) testGroupWithClientExposure.getTestGroup());
        }
        return new ManuallyExposedAbTestGroup<>(testGroupWithClientExposure, this.e);
    }

    @Override // com.avito.android.ab_tests.AbTestsConfigProvider
    @NotNull
    public ExposedAbTestGroup<SimpleTestGroupWithNone> advertContactApplyWithoutChat() {
        TestGroupWithClientExposure testGroupWithClientExposure;
        AdvertContactApplyWithoutChatTestConfig advertContactApplyWithoutChatTestConfig = new AdvertContactApplyWithoutChatTestConfig();
        if (!advertContactApplyWithoutChatTestConfig.getConsistentWithinSession() || (testGroupWithClientExposure = (TestGroupWithClientExposure) this.a.get(advertContactApplyWithoutChatTestConfig.getRemoteKey())) == null || !(testGroupWithClientExposure.getTestGroup() instanceof SimpleTestGroupWithNone)) {
            AbTest abTest = this.b.getAbTest(advertContactApplyWithoutChatTestConfig.getRemoteKey());
            testGroupWithClientExposure = advertContactApplyWithoutChatTestConfig.createAbTest(abTest, this.d, this.f, access$getAbTestConfig(this, abTest, advertContactApplyWithoutChatTestConfig.getTestConfigClass()), advertContactApplyWithoutChatTestConfig.getRemoteKey());
            if (advertContactApplyWithoutChatTestConfig.getConsistentWithinSession()) {
                this.a.put(advertContactApplyWithoutChatTestConfig.getRemoteKey(), testGroupWithClientExposure);
            }
            this.c.reportUsageTest(advertContactApplyWithoutChatTestConfig.getRemoteKey(), (RemoteNamingGroup) testGroupWithClientExposure.getTestGroup());
        }
        return new ExposedAbTestGroup<>(testGroupWithClientExposure, this.e);
    }

    @Override // com.avito.android.ab_tests.AbTestsConfigProvider
    @NotNull
    public AbTestGroup<AdvertDetailsIcebreakerStyleTestGroup> advertDetailsIcebreakerStyle() {
        TestGroupWithClientExposure testGroupWithClientExposure;
        AdvertDetailsIcebreakerStyleTestConfig advertDetailsIcebreakerStyleTestConfig = new AdvertDetailsIcebreakerStyleTestConfig();
        if (!advertDetailsIcebreakerStyleTestConfig.getConsistentWithinSession() || (testGroupWithClientExposure = (TestGroupWithClientExposure) this.a.get(advertDetailsIcebreakerStyleTestConfig.getRemoteKey())) == null || !(testGroupWithClientExposure.getTestGroup() instanceof AdvertDetailsIcebreakerStyleTestGroup)) {
            AbTest abTest = this.b.getAbTest(advertDetailsIcebreakerStyleTestConfig.getRemoteKey());
            testGroupWithClientExposure = advertDetailsIcebreakerStyleTestConfig.createAbTest(abTest, this.d, this.f, access$getAbTestConfig(this, abTest, advertDetailsIcebreakerStyleTestConfig.getTestConfigClass()), advertDetailsIcebreakerStyleTestConfig.getRemoteKey());
            if (advertDetailsIcebreakerStyleTestConfig.getConsistentWithinSession()) {
                this.a.put(advertDetailsIcebreakerStyleTestConfig.getRemoteKey(), testGroupWithClientExposure);
            }
            this.c.reportUsageTest(advertDetailsIcebreakerStyleTestConfig.getRemoteKey(), (RemoteNamingGroup) testGroupWithClientExposure.getTestGroup());
        }
        return new ExposedAbTestGroup(testGroupWithClientExposure, this.e);
    }

    @Override // com.avito.android.ab_tests.AbTestsConfigProvider
    @NotNull
    public ManuallyExposedAbTestGroup<AdvertDetailsMarketplaceBadgeBarItemTestGroup> advertDetailsMarketplaceBadgeBarItemTestGroup() {
        TestGroupWithClientExposure testGroupWithClientExposure;
        AdvertDetailsMarketplaceBadgeBarItemTestConfig advertDetailsMarketplaceBadgeBarItemTestConfig = new AdvertDetailsMarketplaceBadgeBarItemTestConfig();
        if (!advertDetailsMarketplaceBadgeBarItemTestConfig.getConsistentWithinSession() || (testGroupWithClientExposure = (TestGroupWithClientExposure) this.a.get(advertDetailsMarketplaceBadgeBarItemTestConfig.getRemoteKey())) == null || !(testGroupWithClientExposure.getTestGroup() instanceof AdvertDetailsMarketplaceBadgeBarItemTestGroup)) {
            AbTest abTest = this.b.getAbTest(advertDetailsMarketplaceBadgeBarItemTestConfig.getRemoteKey());
            testGroupWithClientExposure = advertDetailsMarketplaceBadgeBarItemTestConfig.createAbTest(abTest, this.d, this.f, access$getAbTestConfig(this, abTest, advertDetailsMarketplaceBadgeBarItemTestConfig.getTestConfigClass()), advertDetailsMarketplaceBadgeBarItemTestConfig.getRemoteKey());
            if (advertDetailsMarketplaceBadgeBarItemTestConfig.getConsistentWithinSession()) {
                this.a.put(advertDetailsMarketplaceBadgeBarItemTestConfig.getRemoteKey(), testGroupWithClientExposure);
            }
            this.c.reportUsageTest(advertDetailsMarketplaceBadgeBarItemTestConfig.getRemoteKey(), (RemoteNamingGroup) testGroupWithClientExposure.getTestGroup());
        }
        return new ManuallyExposedAbTestGroup<>(testGroupWithClientExposure, this.e);
    }

    @Override // com.avito.android.ab_tests.AbTestsConfigProvider
    @NotNull
    public ManuallyExposedAbTestGroup<SimpleTestGroupWithNone> advertDetailsMarketplaceDeliveryItemTestGroup() {
        TestGroupWithClientExposure testGroupWithClientExposure;
        AdvertDetailsMarketplaceDeliveryItemTestConfig advertDetailsMarketplaceDeliveryItemTestConfig = new AdvertDetailsMarketplaceDeliveryItemTestConfig();
        if (!advertDetailsMarketplaceDeliveryItemTestConfig.getConsistentWithinSession() || (testGroupWithClientExposure = (TestGroupWithClientExposure) this.a.get(advertDetailsMarketplaceDeliveryItemTestConfig.getRemoteKey())) == null || !(testGroupWithClientExposure.getTestGroup() instanceof SimpleTestGroupWithNone)) {
            AbTest abTest = this.b.getAbTest(advertDetailsMarketplaceDeliveryItemTestConfig.getRemoteKey());
            testGroupWithClientExposure = advertDetailsMarketplaceDeliveryItemTestConfig.createAbTest(abTest, this.d, this.f, access$getAbTestConfig(this, abTest, advertDetailsMarketplaceDeliveryItemTestConfig.getTestConfigClass()), advertDetailsMarketplaceDeliveryItemTestConfig.getRemoteKey());
            if (advertDetailsMarketplaceDeliveryItemTestConfig.getConsistentWithinSession()) {
                this.a.put(advertDetailsMarketplaceDeliveryItemTestConfig.getRemoteKey(), testGroupWithClientExposure);
            }
            this.c.reportUsageTest(advertDetailsMarketplaceDeliveryItemTestConfig.getRemoteKey(), (RemoteNamingGroup) testGroupWithClientExposure.getTestGroup());
        }
        return new ManuallyExposedAbTestGroup<>(testGroupWithClientExposure, this.e);
    }

    @Override // com.avito.android.ab_tests.AbTestsConfigProvider
    @NotNull
    public ExposedAbTestGroup<AdvertDetailsMarketplaceImprovingContentItemsTestGroup> advertDetailsMarketplaceImprovingContentItemsTestGroup() {
        TestGroupWithClientExposure testGroupWithClientExposure;
        AdvertDetailsMarketplaceImprovingContentItemsTestConfig advertDetailsMarketplaceImprovingContentItemsTestConfig = new AdvertDetailsMarketplaceImprovingContentItemsTestConfig();
        if (!advertDetailsMarketplaceImprovingContentItemsTestConfig.getConsistentWithinSession() || (testGroupWithClientExposure = (TestGroupWithClientExposure) this.a.get(advertDetailsMarketplaceImprovingContentItemsTestConfig.getRemoteKey())) == null || !(testGroupWithClientExposure.getTestGroup() instanceof AdvertDetailsMarketplaceImprovingContentItemsTestGroup)) {
            AbTest abTest = this.b.getAbTest(advertDetailsMarketplaceImprovingContentItemsTestConfig.getRemoteKey());
            testGroupWithClientExposure = advertDetailsMarketplaceImprovingContentItemsTestConfig.createAbTest(abTest, this.d, this.f, access$getAbTestConfig(this, abTest, advertDetailsMarketplaceImprovingContentItemsTestConfig.getTestConfigClass()), advertDetailsMarketplaceImprovingContentItemsTestConfig.getRemoteKey());
            if (advertDetailsMarketplaceImprovingContentItemsTestConfig.getConsistentWithinSession()) {
                this.a.put(advertDetailsMarketplaceImprovingContentItemsTestConfig.getRemoteKey(), testGroupWithClientExposure);
            }
            this.c.reportUsageTest(advertDetailsMarketplaceImprovingContentItemsTestConfig.getRemoteKey(), (RemoteNamingGroup) testGroupWithClientExposure.getTestGroup());
        }
        return new ExposedAbTestGroup<>(testGroupWithClientExposure, this.e);
    }

    @Override // com.avito.android.ab_tests.AbTestsConfigProvider
    @NotNull
    public ManuallyExposedAbTestGroup<AdvertDetailsMarketplaceNoPurchaseFeedbackTestGroup> advertDetailsMarketplaceNoPurchaseFeedbackTestGroup() {
        TestGroupWithClientExposure testGroupWithClientExposure;
        AdvertDetailsMarketplaceNoPurchaseFeedbackTestConfig advertDetailsMarketplaceNoPurchaseFeedbackTestConfig = new AdvertDetailsMarketplaceNoPurchaseFeedbackTestConfig();
        if (!advertDetailsMarketplaceNoPurchaseFeedbackTestConfig.getConsistentWithinSession() || (testGroupWithClientExposure = (TestGroupWithClientExposure) this.a.get(advertDetailsMarketplaceNoPurchaseFeedbackTestConfig.getRemoteKey())) == null || !(testGroupWithClientExposure.getTestGroup() instanceof AdvertDetailsMarketplaceNoPurchaseFeedbackTestGroup)) {
            AbTest abTest = this.b.getAbTest(advertDetailsMarketplaceNoPurchaseFeedbackTestConfig.getRemoteKey());
            testGroupWithClientExposure = advertDetailsMarketplaceNoPurchaseFeedbackTestConfig.createAbTest(abTest, this.d, this.f, access$getAbTestConfig(this, abTest, advertDetailsMarketplaceNoPurchaseFeedbackTestConfig.getTestConfigClass()), advertDetailsMarketplaceNoPurchaseFeedbackTestConfig.getRemoteKey());
            if (advertDetailsMarketplaceNoPurchaseFeedbackTestConfig.getConsistentWithinSession()) {
                this.a.put(advertDetailsMarketplaceNoPurchaseFeedbackTestConfig.getRemoteKey(), testGroupWithClientExposure);
            }
            this.c.reportUsageTest(advertDetailsMarketplaceNoPurchaseFeedbackTestConfig.getRemoteKey(), (RemoteNamingGroup) testGroupWithClientExposure.getTestGroup());
        }
        return new ManuallyExposedAbTestGroup<>(testGroupWithClientExposure, this.e);
    }

    @Override // com.avito.android.ab_tests.AbTestsConfigProvider
    @NotNull
    public ManuallyExposedAbTestGroup<AdvertDetailsNoCallFeedbackTestGroup> advertDetailsNoCallFeedbackTestGroup() {
        TestGroupWithClientExposure testGroupWithClientExposure;
        AdvertDetailsNoCallFeedbackTestConfig advertDetailsNoCallFeedbackTestConfig = new AdvertDetailsNoCallFeedbackTestConfig();
        if (!advertDetailsNoCallFeedbackTestConfig.getConsistentWithinSession() || (testGroupWithClientExposure = (TestGroupWithClientExposure) this.a.get(advertDetailsNoCallFeedbackTestConfig.getRemoteKey())) == null || !(testGroupWithClientExposure.getTestGroup() instanceof AdvertDetailsNoCallFeedbackTestGroup)) {
            AbTest abTest = this.b.getAbTest(advertDetailsNoCallFeedbackTestConfig.getRemoteKey());
            testGroupWithClientExposure = advertDetailsNoCallFeedbackTestConfig.createAbTest(abTest, this.d, this.f, access$getAbTestConfig(this, abTest, advertDetailsNoCallFeedbackTestConfig.getTestConfigClass()), advertDetailsNoCallFeedbackTestConfig.getRemoteKey());
            if (advertDetailsNoCallFeedbackTestConfig.getConsistentWithinSession()) {
                this.a.put(advertDetailsNoCallFeedbackTestConfig.getRemoteKey(), testGroupWithClientExposure);
            }
            this.c.reportUsageTest(advertDetailsNoCallFeedbackTestConfig.getRemoteKey(), (RemoteNamingGroup) testGroupWithClientExposure.getTestGroup());
        }
        return new ManuallyExposedAbTestGroup<>(testGroupWithClientExposure, this.e);
    }

    @Override // com.avito.android.ab_tests.AbTestsConfigProvider
    @NotNull
    public ManuallyExposedAbTestGroup<AdvertDetailsPriceSubscriptionTestGroup> advertDetailsPriceSubscription() {
        TestGroupWithClientExposure testGroupWithClientExposure;
        AdvertDetailsPriceSubscriptionTestConfig advertDetailsPriceSubscriptionTestConfig = new AdvertDetailsPriceSubscriptionTestConfig();
        if (!advertDetailsPriceSubscriptionTestConfig.getConsistentWithinSession() || (testGroupWithClientExposure = (TestGroupWithClientExposure) this.a.get(advertDetailsPriceSubscriptionTestConfig.getRemoteKey())) == null || !(testGroupWithClientExposure.getTestGroup() instanceof AdvertDetailsPriceSubscriptionTestGroup)) {
            AbTest abTest = this.b.getAbTest(advertDetailsPriceSubscriptionTestConfig.getRemoteKey());
            testGroupWithClientExposure = advertDetailsPriceSubscriptionTestConfig.createAbTest(abTest, this.d, this.f, access$getAbTestConfig(this, abTest, advertDetailsPriceSubscriptionTestConfig.getTestConfigClass()), advertDetailsPriceSubscriptionTestConfig.getRemoteKey());
            if (advertDetailsPriceSubscriptionTestConfig.getConsistentWithinSession()) {
                this.a.put(advertDetailsPriceSubscriptionTestConfig.getRemoteKey(), testGroupWithClientExposure);
            }
            this.c.reportUsageTest(advertDetailsPriceSubscriptionTestConfig.getRemoteKey(), (RemoteNamingGroup) testGroupWithClientExposure.getTestGroup());
        }
        return new ManuallyExposedAbTestGroup<>(testGroupWithClientExposure, this.e);
    }

    @Override // com.avito.android.ab_tests.AbTestsConfigProvider
    @NotNull
    public ExposedAbTestGroup<SimpleTestGroupWithNoneControl2> advertSpeedUpTest() {
        TestGroupWithClientExposure testGroupWithClientExposure;
        AdvertSpeedUpTestConfig advertSpeedUpTestConfig = new AdvertSpeedUpTestConfig();
        if (!advertSpeedUpTestConfig.getConsistentWithinSession() || (testGroupWithClientExposure = (TestGroupWithClientExposure) this.a.get(advertSpeedUpTestConfig.getRemoteKey())) == null || !(testGroupWithClientExposure.getTestGroup() instanceof SimpleTestGroupWithNoneControl2)) {
            AbTest abTest = this.b.getAbTest(advertSpeedUpTestConfig.getRemoteKey());
            testGroupWithClientExposure = advertSpeedUpTestConfig.createAbTest(abTest, this.d, this.f, access$getAbTestConfig(this, abTest, advertSpeedUpTestConfig.getTestConfigClass()), advertSpeedUpTestConfig.getRemoteKey());
            if (advertSpeedUpTestConfig.getConsistentWithinSession()) {
                this.a.put(advertSpeedUpTestConfig.getRemoteKey(), testGroupWithClientExposure);
            }
            this.c.reportUsageTest(advertSpeedUpTestConfig.getRemoteKey(), (RemoteNamingGroup) testGroupWithClientExposure.getTestGroup());
        }
        return new ExposedAbTestGroup<>(testGroupWithClientExposure, this.e);
    }

    @Override // com.avito.android.ab_tests.AbTestsConfigProvider
    @NotNull
    public SingleManuallyExposedAbTestGroup<AntiFraudCheckListTestGroup> antiFraudCheckList() {
        TestGroupWithClientExposure testGroupWithClientExposure;
        AntiFraudCheckListTestConfig antiFraudCheckListTestConfig = new AntiFraudCheckListTestConfig();
        if (!antiFraudCheckListTestConfig.getConsistentWithinSession() || (testGroupWithClientExposure = (TestGroupWithClientExposure) this.a.get(antiFraudCheckListTestConfig.getRemoteKey())) == null || !(testGroupWithClientExposure.getTestGroup() instanceof AntiFraudCheckListTestGroup)) {
            AbTest abTest = this.b.getAbTest(antiFraudCheckListTestConfig.getRemoteKey());
            testGroupWithClientExposure = antiFraudCheckListTestConfig.createAbTest(abTest, this.d, this.f, access$getAbTestConfig(this, abTest, antiFraudCheckListTestConfig.getTestConfigClass()), antiFraudCheckListTestConfig.getRemoteKey());
            if (antiFraudCheckListTestConfig.getConsistentWithinSession()) {
                this.a.put(antiFraudCheckListTestConfig.getRemoteKey(), testGroupWithClientExposure);
            }
            this.c.reportUsageTest(antiFraudCheckListTestConfig.getRemoteKey(), (RemoteNamingGroup) testGroupWithClientExposure.getTestGroup());
        }
        return new SingleManuallyExposedAbTestGroup<>(testGroupWithClientExposure, this.e);
    }

    @Override // com.avito.android.ab_tests.AbTestsConfigProvider
    @NotNull
    public AbTestGroup<AntifraudStartupBannerTestGroup> antifraudStartupBanner() {
        TestGroupWithClientExposure testGroupWithClientExposure;
        AntifraudStartupBannerTestConfig antifraudStartupBannerTestConfig = new AntifraudStartupBannerTestConfig();
        if (!antifraudStartupBannerTestConfig.getConsistentWithinSession() || (testGroupWithClientExposure = (TestGroupWithClientExposure) this.a.get(antifraudStartupBannerTestConfig.getRemoteKey())) == null || !(testGroupWithClientExposure.getTestGroup() instanceof AntifraudStartupBannerTestGroup)) {
            AbTest abTest = this.b.getAbTest(antifraudStartupBannerTestConfig.getRemoteKey());
            testGroupWithClientExposure = antifraudStartupBannerTestConfig.createAbTest(abTest, this.d, this.f, access$getAbTestConfig(this, abTest, antifraudStartupBannerTestConfig.getTestConfigClass()), antifraudStartupBannerTestConfig.getRemoteKey());
            if (antifraudStartupBannerTestConfig.getConsistentWithinSession()) {
                this.a.put(antifraudStartupBannerTestConfig.getRemoteKey(), testGroupWithClientExposure);
            }
            this.c.reportUsageTest(antifraudStartupBannerTestConfig.getRemoteKey(), (RemoteNamingGroup) testGroupWithClientExposure.getTestGroup());
        }
        return new ExposedAbTestGroup(testGroupWithClientExposure, this.e);
    }

    @Override // com.avito.android.ab_tests.AbTestsConfigProvider
    @NotNull
    public SingleManuallyExposedAbTestGroup<AutoBrandModelTypoCorrectionTestGroup> autoBrandModelTypoCorrection() {
        TestGroupWithClientExposure testGroupWithClientExposure;
        AutoBrandModelTypoCorrectionTestConfig autoBrandModelTypoCorrectionTestConfig = new AutoBrandModelTypoCorrectionTestConfig();
        if (!autoBrandModelTypoCorrectionTestConfig.getConsistentWithinSession() || (testGroupWithClientExposure = (TestGroupWithClientExposure) this.a.get(autoBrandModelTypoCorrectionTestConfig.getRemoteKey())) == null || !(testGroupWithClientExposure.getTestGroup() instanceof AutoBrandModelTypoCorrectionTestGroup)) {
            AbTest abTest = this.b.getAbTest(autoBrandModelTypoCorrectionTestConfig.getRemoteKey());
            testGroupWithClientExposure = autoBrandModelTypoCorrectionTestConfig.createAbTest(abTest, this.d, this.f, access$getAbTestConfig(this, abTest, autoBrandModelTypoCorrectionTestConfig.getTestConfigClass()), autoBrandModelTypoCorrectionTestConfig.getRemoteKey());
            if (autoBrandModelTypoCorrectionTestConfig.getConsistentWithinSession()) {
                this.a.put(autoBrandModelTypoCorrectionTestConfig.getRemoteKey(), testGroupWithClientExposure);
            }
            this.c.reportUsageTest(autoBrandModelTypoCorrectionTestConfig.getRemoteKey(), (RemoteNamingGroup) testGroupWithClientExposure.getTestGroup());
        }
        return new SingleManuallyExposedAbTestGroup<>(testGroupWithClientExposure, this.e);
    }

    @Override // com.avito.android.ab_tests.AbTestsConfigProvider
    @NotNull
    public SingleManuallyExposedAbTestGroup<SimpleTestGroup> autoGenerationsFilterWithPhotos() {
        TestGroupWithClientExposure testGroupWithClientExposure;
        AutoGenerationsFilterWithPhotosTestConfig autoGenerationsFilterWithPhotosTestConfig = new AutoGenerationsFilterWithPhotosTestConfig();
        if (!autoGenerationsFilterWithPhotosTestConfig.getConsistentWithinSession() || (testGroupWithClientExposure = (TestGroupWithClientExposure) this.a.get(autoGenerationsFilterWithPhotosTestConfig.getRemoteKey())) == null || !(testGroupWithClientExposure.getTestGroup() instanceof SimpleTestGroup)) {
            AbTest abTest = this.b.getAbTest(autoGenerationsFilterWithPhotosTestConfig.getRemoteKey());
            testGroupWithClientExposure = autoGenerationsFilterWithPhotosTestConfig.createAbTest(abTest, this.d, this.f, access$getAbTestConfig(this, abTest, autoGenerationsFilterWithPhotosTestConfig.getTestConfigClass()), autoGenerationsFilterWithPhotosTestConfig.getRemoteKey());
            if (autoGenerationsFilterWithPhotosTestConfig.getConsistentWithinSession()) {
                this.a.put(autoGenerationsFilterWithPhotosTestConfig.getRemoteKey(), testGroupWithClientExposure);
            }
            this.c.reportUsageTest(autoGenerationsFilterWithPhotosTestConfig.getRemoteKey(), (RemoteNamingGroup) testGroupWithClientExposure.getTestGroup());
        }
        return new SingleManuallyExposedAbTestGroup<>(testGroupWithClientExposure, this.e);
    }

    @Override // com.avito.android.ab_tests.AbTestsConfigProvider
    @NotNull
    public ManuallyExposedAbTestGroup<SimpleTestGroup> buyerAsksSellerTtlItem() {
        TestGroupWithClientExposure testGroupWithClientExposure;
        BuyerAsksSellerTtlItemTestConfig buyerAsksSellerTtlItemTestConfig = new BuyerAsksSellerTtlItemTestConfig();
        if (!buyerAsksSellerTtlItemTestConfig.getConsistentWithinSession() || (testGroupWithClientExposure = (TestGroupWithClientExposure) this.a.get(buyerAsksSellerTtlItemTestConfig.getRemoteKey())) == null || !(testGroupWithClientExposure.getTestGroup() instanceof SimpleTestGroup)) {
            AbTest abTest = this.b.getAbTest(buyerAsksSellerTtlItemTestConfig.getRemoteKey());
            testGroupWithClientExposure = buyerAsksSellerTtlItemTestConfig.createAbTest(abTest, this.d, this.f, access$getAbTestConfig(this, abTest, buyerAsksSellerTtlItemTestConfig.getTestConfigClass()), buyerAsksSellerTtlItemTestConfig.getRemoteKey());
            if (buyerAsksSellerTtlItemTestConfig.getConsistentWithinSession()) {
                this.a.put(buyerAsksSellerTtlItemTestConfig.getRemoteKey(), testGroupWithClientExposure);
            }
            this.c.reportUsageTest(buyerAsksSellerTtlItemTestConfig.getRemoteKey(), (RemoteNamingGroup) testGroupWithClientExposure.getTestGroup());
        }
        return new ManuallyExposedAbTestGroup<>(testGroupWithClientExposure, this.e);
    }

    @Override // com.avito.android.ab_tests.AbTestsConfigProvider
    @NotNull
    public SingleManuallyExposedAbTestGroup<CallsEarlyBeepsTestGroup> callsEarlyBeeps() {
        TestGroupWithClientExposure testGroupWithClientExposure;
        CallsEarlyBeepsTestConfig callsEarlyBeepsTestConfig = new CallsEarlyBeepsTestConfig();
        if (!callsEarlyBeepsTestConfig.getConsistentWithinSession() || (testGroupWithClientExposure = (TestGroupWithClientExposure) this.a.get(callsEarlyBeepsTestConfig.getRemoteKey())) == null || !(testGroupWithClientExposure.getTestGroup() instanceof CallsEarlyBeepsTestGroup)) {
            AbTest abTest = this.b.getAbTest(callsEarlyBeepsTestConfig.getRemoteKey());
            testGroupWithClientExposure = callsEarlyBeepsTestConfig.createAbTest(abTest, this.d, this.f, access$getAbTestConfig(this, abTest, callsEarlyBeepsTestConfig.getTestConfigClass()), callsEarlyBeepsTestConfig.getRemoteKey());
            if (callsEarlyBeepsTestConfig.getConsistentWithinSession()) {
                this.a.put(callsEarlyBeepsTestConfig.getRemoteKey(), testGroupWithClientExposure);
            }
            this.c.reportUsageTest(callsEarlyBeepsTestConfig.getRemoteKey(), (RemoteNamingGroup) testGroupWithClientExposure.getTestGroup());
        }
        return new SingleManuallyExposedAbTestGroup<>(testGroupWithClientExposure, this.e);
    }

    @Override // com.avito.android.ab_tests.AbTestsConfigProvider
    @NotNull
    public ExposedAbTestGroup<CallsNewDesignTestGroup> callsNewDesign() {
        TestGroupWithClientExposure testGroupWithClientExposure;
        CallsNewDesignTestConfig callsNewDesignTestConfig = new CallsNewDesignTestConfig();
        if (!callsNewDesignTestConfig.getConsistentWithinSession() || (testGroupWithClientExposure = (TestGroupWithClientExposure) this.a.get(callsNewDesignTestConfig.getRemoteKey())) == null || !(testGroupWithClientExposure.getTestGroup() instanceof CallsNewDesignTestGroup)) {
            AbTest abTest = this.b.getAbTest(callsNewDesignTestConfig.getRemoteKey());
            testGroupWithClientExposure = callsNewDesignTestConfig.createAbTest(abTest, this.d, this.f, access$getAbTestConfig(this, abTest, callsNewDesignTestConfig.getTestConfigClass()), callsNewDesignTestConfig.getRemoteKey());
            if (callsNewDesignTestConfig.getConsistentWithinSession()) {
                this.a.put(callsNewDesignTestConfig.getRemoteKey(), testGroupWithClientExposure);
            }
            this.c.reportUsageTest(callsNewDesignTestConfig.getRemoteKey(), (RemoteNamingGroup) testGroupWithClientExposure.getTestGroup());
        }
        return new ExposedAbTestGroup<>(testGroupWithClientExposure, this.e);
    }

    @Override // com.avito.android.ab_tests.AbTestsCache
    @VisibleForTesting
    public void clear() {
        this.a.clear();
    }

    @Override // com.avito.android.ab_tests.AbTestsConfigProvider
    @NotNull
    public ManuallyExposedAbTestGroup<SimpleTestGroup> draftsOnStartPublishSheet() {
        TestGroupWithClientExposure testGroupWithClientExposure;
        DraftsOnStartPublishSheetTestConfig draftsOnStartPublishSheetTestConfig = new DraftsOnStartPublishSheetTestConfig();
        if (!draftsOnStartPublishSheetTestConfig.getConsistentWithinSession() || (testGroupWithClientExposure = (TestGroupWithClientExposure) this.a.get(draftsOnStartPublishSheetTestConfig.getRemoteKey())) == null || !(testGroupWithClientExposure.getTestGroup() instanceof SimpleTestGroup)) {
            AbTest abTest = this.b.getAbTest(draftsOnStartPublishSheetTestConfig.getRemoteKey());
            testGroupWithClientExposure = draftsOnStartPublishSheetTestConfig.createAbTest(abTest, this.d, this.f, access$getAbTestConfig(this, abTest, draftsOnStartPublishSheetTestConfig.getTestConfigClass()), draftsOnStartPublishSheetTestConfig.getRemoteKey());
            if (draftsOnStartPublishSheetTestConfig.getConsistentWithinSession()) {
                this.a.put(draftsOnStartPublishSheetTestConfig.getRemoteKey(), testGroupWithClientExposure);
            }
            this.c.reportUsageTest(draftsOnStartPublishSheetTestConfig.getRemoteKey(), (RemoteNamingGroup) testGroupWithClientExposure.getTestGroup());
        }
        return new ManuallyExposedAbTestGroup<>(testGroupWithClientExposure, this.e);
    }

    @Override // com.avito.android.ab_tests.AbTestsConfigProvider
    @NotNull
    public ExposedAbTestGroup<SimpleTestGroupWithNone> favoriteSimilarAdvertsTestGroup() {
        TestGroupWithClientExposure testGroupWithClientExposure;
        FavoriteSimilarAdvertsTestConfig favoriteSimilarAdvertsTestConfig = new FavoriteSimilarAdvertsTestConfig();
        if (!favoriteSimilarAdvertsTestConfig.getConsistentWithinSession() || (testGroupWithClientExposure = (TestGroupWithClientExposure) this.a.get(favoriteSimilarAdvertsTestConfig.getRemoteKey())) == null || !(testGroupWithClientExposure.getTestGroup() instanceof SimpleTestGroupWithNone)) {
            AbTest abTest = this.b.getAbTest(favoriteSimilarAdvertsTestConfig.getRemoteKey());
            testGroupWithClientExposure = favoriteSimilarAdvertsTestConfig.createAbTest(abTest, this.d, this.f, access$getAbTestConfig(this, abTest, favoriteSimilarAdvertsTestConfig.getTestConfigClass()), favoriteSimilarAdvertsTestConfig.getRemoteKey());
            if (favoriteSimilarAdvertsTestConfig.getConsistentWithinSession()) {
                this.a.put(favoriteSimilarAdvertsTestConfig.getRemoteKey(), testGroupWithClientExposure);
            }
            this.c.reportUsageTest(favoriteSimilarAdvertsTestConfig.getRemoteKey(), (RemoteNamingGroup) testGroupWithClientExposure.getTestGroup());
        }
        return new ExposedAbTestGroup<>(testGroupWithClientExposure, this.e);
    }

    @Override // com.avito.android.ab_tests.AbTestsConfigProvider
    @NotNull
    public ExposedAbTestGroup<HomeNewRubricatorTestGroup> homeNewRubricator() {
        TestGroupWithClientExposure testGroupWithClientExposure;
        HomeNewRubricatorTestConfig homeNewRubricatorTestConfig = new HomeNewRubricatorTestConfig();
        if (!homeNewRubricatorTestConfig.getConsistentWithinSession() || (testGroupWithClientExposure = (TestGroupWithClientExposure) this.a.get(homeNewRubricatorTestConfig.getRemoteKey())) == null || !(testGroupWithClientExposure.getTestGroup() instanceof HomeNewRubricatorTestGroup)) {
            AbTest abTest = this.b.getAbTest(homeNewRubricatorTestConfig.getRemoteKey());
            testGroupWithClientExposure = homeNewRubricatorTestConfig.createAbTest(abTest, this.d, this.f, access$getAbTestConfig(this, abTest, homeNewRubricatorTestConfig.getTestConfigClass()), homeNewRubricatorTestConfig.getRemoteKey());
            if (homeNewRubricatorTestConfig.getConsistentWithinSession()) {
                this.a.put(homeNewRubricatorTestConfig.getRemoteKey(), testGroupWithClientExposure);
            }
            this.c.reportUsageTest(homeNewRubricatorTestConfig.getRemoteKey(), (RemoteNamingGroup) testGroupWithClientExposure.getTestGroup());
        }
        return new ExposedAbTestGroup<>(testGroupWithClientExposure, this.e);
    }

    @Override // com.avito.android.ab_tests.AbTestsConfigProvider
    @NotNull
    public ExposedAbTestGroup<HomeSkeletonTestGroup> homeSkeletonTest() {
        TestGroupWithClientExposure testGroupWithClientExposure;
        HomeSkeletonTestConfig homeSkeletonTestConfig = new HomeSkeletonTestConfig();
        if (!homeSkeletonTestConfig.getConsistentWithinSession() || (testGroupWithClientExposure = (TestGroupWithClientExposure) this.a.get(homeSkeletonTestConfig.getRemoteKey())) == null || !(testGroupWithClientExposure.getTestGroup() instanceof HomeSkeletonTestGroup)) {
            AbTest abTest = this.b.getAbTest(homeSkeletonTestConfig.getRemoteKey());
            testGroupWithClientExposure = homeSkeletonTestConfig.createAbTest(abTest, this.d, this.f, access$getAbTestConfig(this, abTest, homeSkeletonTestConfig.getTestConfigClass()), homeSkeletonTestConfig.getRemoteKey());
            if (homeSkeletonTestConfig.getConsistentWithinSession()) {
                this.a.put(homeSkeletonTestConfig.getRemoteKey(), testGroupWithClientExposure);
            }
            this.c.reportUsageTest(homeSkeletonTestConfig.getRemoteKey(), (RemoteNamingGroup) testGroupWithClientExposure.getTestGroup());
        }
        return new ExposedAbTestGroup<>(testGroupWithClientExposure, this.e);
    }

    @Override // com.avito.android.ab_tests.AbTestsConfigProvider
    @NotNull
    public AbTestGroup<InAppUpdateTestGroup> inAppUpdate() {
        TestGroupWithClientExposure testGroupWithClientExposure;
        InAppUpdateTestConfig inAppUpdateTestConfig = new InAppUpdateTestConfig();
        if (!inAppUpdateTestConfig.getConsistentWithinSession() || (testGroupWithClientExposure = (TestGroupWithClientExposure) this.a.get(inAppUpdateTestConfig.getRemoteKey())) == null || !(testGroupWithClientExposure.getTestGroup() instanceof InAppUpdateTestGroup)) {
            AbTest abTest = this.b.getAbTest(inAppUpdateTestConfig.getRemoteKey());
            testGroupWithClientExposure = inAppUpdateTestConfig.createAbTest(abTest, this.d, this.f, access$getAbTestConfig(this, abTest, inAppUpdateTestConfig.getTestConfigClass()), inAppUpdateTestConfig.getRemoteKey());
            if (inAppUpdateTestConfig.getConsistentWithinSession()) {
                this.a.put(inAppUpdateTestConfig.getRemoteKey(), testGroupWithClientExposure);
            }
            this.c.reportUsageTest(inAppUpdateTestConfig.getRemoteKey(), (RemoteNamingGroup) testGroupWithClientExposure.getTestGroup());
        }
        return new ExposedAbTestGroup(testGroupWithClientExposure, this.e);
    }

    @Override // com.avito.android.ab_tests.AbTestsConfigProvider
    @NotNull
    public ExposedAbTestGroup<SimpleTestGroup> jobApplicationProgressBar() {
        TestGroupWithClientExposure testGroupWithClientExposure;
        JobApplicationProgressBarTestConfig jobApplicationProgressBarTestConfig = new JobApplicationProgressBarTestConfig();
        if (!jobApplicationProgressBarTestConfig.getConsistentWithinSession() || (testGroupWithClientExposure = (TestGroupWithClientExposure) this.a.get(jobApplicationProgressBarTestConfig.getRemoteKey())) == null || !(testGroupWithClientExposure.getTestGroup() instanceof SimpleTestGroup)) {
            AbTest abTest = this.b.getAbTest(jobApplicationProgressBarTestConfig.getRemoteKey());
            testGroupWithClientExposure = jobApplicationProgressBarTestConfig.createAbTest(abTest, this.d, this.f, access$getAbTestConfig(this, abTest, jobApplicationProgressBarTestConfig.getTestConfigClass()), jobApplicationProgressBarTestConfig.getRemoteKey());
            if (jobApplicationProgressBarTestConfig.getConsistentWithinSession()) {
                this.a.put(jobApplicationProgressBarTestConfig.getRemoteKey(), testGroupWithClientExposure);
            }
            this.c.reportUsageTest(jobApplicationProgressBarTestConfig.getRemoteKey(), (RemoteNamingGroup) testGroupWithClientExposure.getTestGroup());
        }
        return new ExposedAbTestGroup<>(testGroupWithClientExposure, this.e);
    }

    @Override // com.avito.android.ab_tests.AbTestsConfigProvider
    @NotNull
    public AbTestGroup<SimpleTestGroupWithControl2> justDialSellerPhone() {
        TestGroupWithClientExposure testGroupWithClientExposure;
        JustDialSellerPhoneTestConfig justDialSellerPhoneTestConfig = new JustDialSellerPhoneTestConfig();
        if (!justDialSellerPhoneTestConfig.getConsistentWithinSession() || (testGroupWithClientExposure = (TestGroupWithClientExposure) this.a.get(justDialSellerPhoneTestConfig.getRemoteKey())) == null || !(testGroupWithClientExposure.getTestGroup() instanceof SimpleTestGroupWithControl2)) {
            AbTest abTest = this.b.getAbTest(justDialSellerPhoneTestConfig.getRemoteKey());
            testGroupWithClientExposure = justDialSellerPhoneTestConfig.createAbTest(abTest, this.d, this.f, access$getAbTestConfig(this, abTest, justDialSellerPhoneTestConfig.getTestConfigClass()), justDialSellerPhoneTestConfig.getRemoteKey());
            if (justDialSellerPhoneTestConfig.getConsistentWithinSession()) {
                this.a.put(justDialSellerPhoneTestConfig.getRemoteKey(), testGroupWithClientExposure);
            }
            this.c.reportUsageTest(justDialSellerPhoneTestConfig.getRemoteKey(), (RemoteNamingGroup) testGroupWithClientExposure.getTestGroup());
        }
        return new ExposedAbTestGroup(testGroupWithClientExposure, this.e);
    }

    @Override // com.avito.android.ab_tests.AbTestsConfigProvider
    @NotNull
    public ManuallyExposedAbTestGroup<MessengerFolderTabsTestGroup> messengerFolderTabs() {
        TestGroupWithClientExposure testGroupWithClientExposure;
        MessengerFolderTabsTestConfig messengerFolderTabsTestConfig = new MessengerFolderTabsTestConfig();
        if (!messengerFolderTabsTestConfig.getConsistentWithinSession() || (testGroupWithClientExposure = (TestGroupWithClientExposure) this.a.get(messengerFolderTabsTestConfig.getRemoteKey())) == null || !(testGroupWithClientExposure.getTestGroup() instanceof MessengerFolderTabsTestGroup)) {
            AbTest abTest = this.b.getAbTest(messengerFolderTabsTestConfig.getRemoteKey());
            testGroupWithClientExposure = messengerFolderTabsTestConfig.createAbTest(abTest, this.d, this.f, access$getAbTestConfig(this, abTest, messengerFolderTabsTestConfig.getTestConfigClass()), messengerFolderTabsTestConfig.getRemoteKey());
            if (messengerFolderTabsTestConfig.getConsistentWithinSession()) {
                this.a.put(messengerFolderTabsTestConfig.getRemoteKey(), testGroupWithClientExposure);
            }
            this.c.reportUsageTest(messengerFolderTabsTestConfig.getRemoteKey(), (RemoteNamingGroup) testGroupWithClientExposure.getTestGroup());
        }
        return new ManuallyExposedAbTestGroup<>(testGroupWithClientExposure, this.e);
    }

    @Override // com.avito.android.ab_tests.AbTestsConfigProvider
    @NotNull
    public AbTestGroup<SimpleTestGroup> messengerSearchIcon() {
        TestGroupWithClientExposure testGroupWithClientExposure;
        MessengerSearchIconTestConfig messengerSearchIconTestConfig = new MessengerSearchIconTestConfig();
        if (!messengerSearchIconTestConfig.getConsistentWithinSession() || (testGroupWithClientExposure = (TestGroupWithClientExposure) this.a.get(messengerSearchIconTestConfig.getRemoteKey())) == null || !(testGroupWithClientExposure.getTestGroup() instanceof SimpleTestGroup)) {
            AbTest abTest = this.b.getAbTest(messengerSearchIconTestConfig.getRemoteKey());
            testGroupWithClientExposure = messengerSearchIconTestConfig.createAbTest(abTest, this.d, this.f, access$getAbTestConfig(this, abTest, messengerSearchIconTestConfig.getTestConfigClass()), messengerSearchIconTestConfig.getRemoteKey());
            if (messengerSearchIconTestConfig.getConsistentWithinSession()) {
                this.a.put(messengerSearchIconTestConfig.getRemoteKey(), testGroupWithClientExposure);
            }
            this.c.reportUsageTest(messengerSearchIconTestConfig.getRemoteKey(), (RemoteNamingGroup) testGroupWithClientExposure.getTestGroup());
        }
        return new ExposedAbTestGroup(testGroupWithClientExposure, this.e);
    }

    @Override // com.avito.android.ab_tests.AbTestsConfigProvider
    @NotNull
    public ManuallyExposedAbTestGroup<SimpleTestGroup> notReadyVideoOnPublish() {
        TestGroupWithClientExposure testGroupWithClientExposure;
        NotReadyVideoOnPublishTestConfig notReadyVideoOnPublishTestConfig = new NotReadyVideoOnPublishTestConfig();
        if (!notReadyVideoOnPublishTestConfig.getConsistentWithinSession() || (testGroupWithClientExposure = (TestGroupWithClientExposure) this.a.get(notReadyVideoOnPublishTestConfig.getRemoteKey())) == null || !(testGroupWithClientExposure.getTestGroup() instanceof SimpleTestGroup)) {
            AbTest abTest = this.b.getAbTest(notReadyVideoOnPublishTestConfig.getRemoteKey());
            testGroupWithClientExposure = notReadyVideoOnPublishTestConfig.createAbTest(abTest, this.d, this.f, access$getAbTestConfig(this, abTest, notReadyVideoOnPublishTestConfig.getTestConfigClass()), notReadyVideoOnPublishTestConfig.getRemoteKey());
            if (notReadyVideoOnPublishTestConfig.getConsistentWithinSession()) {
                this.a.put(notReadyVideoOnPublishTestConfig.getRemoteKey(), testGroupWithClientExposure);
            }
            this.c.reportUsageTest(notReadyVideoOnPublishTestConfig.getRemoteKey(), (RemoteNamingGroup) testGroupWithClientExposure.getTestGroup());
        }
        return new ManuallyExposedAbTestGroup<>(testGroupWithClientExposure, this.e);
    }

    @Override // com.avito.android.ab_tests.AbTestsConfigProvider
    @NotNull
    public ExposedAbTestGroup<OrangeAdBadgeTestGroup> orangeAdBadge() {
        TestGroupWithClientExposure testGroupWithClientExposure;
        OrangeAdBadgeConfig orangeAdBadgeConfig = new OrangeAdBadgeConfig();
        if (!orangeAdBadgeConfig.getConsistentWithinSession() || (testGroupWithClientExposure = (TestGroupWithClientExposure) this.a.get(orangeAdBadgeConfig.getRemoteKey())) == null || !(testGroupWithClientExposure.getTestGroup() instanceof OrangeAdBadgeTestGroup)) {
            AbTest abTest = this.b.getAbTest(orangeAdBadgeConfig.getRemoteKey());
            testGroupWithClientExposure = orangeAdBadgeConfig.createAbTest(abTest, this.d, this.f, access$getAbTestConfig(this, abTest, orangeAdBadgeConfig.getTestConfigClass()), orangeAdBadgeConfig.getRemoteKey());
            if (orangeAdBadgeConfig.getConsistentWithinSession()) {
                this.a.put(orangeAdBadgeConfig.getRemoteKey(), testGroupWithClientExposure);
            }
            this.c.reportUsageTest(orangeAdBadgeConfig.getRemoteKey(), (RemoteNamingGroup) testGroupWithClientExposure.getTestGroup());
        }
        return new ExposedAbTestGroup<>(testGroupWithClientExposure, this.e);
    }

    @Override // com.avito.android.ab_tests.AbTestsConfigProvider
    @NotNull
    public ExposedAbTestGroup<PriceOnTopTestGroup> priceOnTop() {
        TestGroupWithClientExposure testGroupWithClientExposure;
        PriceOnTopConfig priceOnTopConfig = new PriceOnTopConfig();
        if (!priceOnTopConfig.getConsistentWithinSession() || (testGroupWithClientExposure = (TestGroupWithClientExposure) this.a.get(priceOnTopConfig.getRemoteKey())) == null || !(testGroupWithClientExposure.getTestGroup() instanceof PriceOnTopTestGroup)) {
            AbTest abTest = this.b.getAbTest(priceOnTopConfig.getRemoteKey());
            testGroupWithClientExposure = priceOnTopConfig.createAbTest(abTest, this.d, this.f, access$getAbTestConfig(this, abTest, priceOnTopConfig.getTestConfigClass()), priceOnTopConfig.getRemoteKey());
            if (priceOnTopConfig.getConsistentWithinSession()) {
                this.a.put(priceOnTopConfig.getRemoteKey(), testGroupWithClientExposure);
            }
            this.c.reportUsageTest(priceOnTopConfig.getRemoteKey(), (RemoteNamingGroup) testGroupWithClientExposure.getTestGroup());
        }
        return new ExposedAbTestGroup<>(testGroupWithClientExposure, this.e);
    }

    @Override // com.avito.android.ab_tests.AbTestsConfigProvider
    @NotNull
    public SingleManuallyExposedAbTestGroup<PublishReviewFromChatChannelGroup> publishReviewFromChatChannel() {
        TestGroupWithClientExposure testGroupWithClientExposure;
        PublishReviewFromChatChannelConfig publishReviewFromChatChannelConfig = new PublishReviewFromChatChannelConfig();
        if (!publishReviewFromChatChannelConfig.getConsistentWithinSession() || (testGroupWithClientExposure = (TestGroupWithClientExposure) this.a.get(publishReviewFromChatChannelConfig.getRemoteKey())) == null || !(testGroupWithClientExposure.getTestGroup() instanceof PublishReviewFromChatChannelGroup)) {
            AbTest abTest = this.b.getAbTest(publishReviewFromChatChannelConfig.getRemoteKey());
            testGroupWithClientExposure = publishReviewFromChatChannelConfig.createAbTest(abTest, this.d, this.f, access$getAbTestConfig(this, abTest, publishReviewFromChatChannelConfig.getTestConfigClass()), publishReviewFromChatChannelConfig.getRemoteKey());
            if (publishReviewFromChatChannelConfig.getConsistentWithinSession()) {
                this.a.put(publishReviewFromChatChannelConfig.getRemoteKey(), testGroupWithClientExposure);
            }
            this.c.reportUsageTest(publishReviewFromChatChannelConfig.getRemoteKey(), (RemoteNamingGroup) testGroupWithClientExposure.getTestGroup());
        }
        return new SingleManuallyExposedAbTestGroup<>(testGroupWithClientExposure, this.e);
    }

    @Override // com.avito.android.ab_tests.AbTestsConfigProvider
    @NotNull
    public ManuallyExposedAbTestGroup<SimpleTestGroupWithNone> realtyNewBackNavigation() {
        TestGroupWithClientExposure testGroupWithClientExposure;
        RealtyNewBackNavigationTestConfig realtyNewBackNavigationTestConfig = new RealtyNewBackNavigationTestConfig();
        if (!realtyNewBackNavigationTestConfig.getConsistentWithinSession() || (testGroupWithClientExposure = (TestGroupWithClientExposure) this.a.get(realtyNewBackNavigationTestConfig.getRemoteKey())) == null || !(testGroupWithClientExposure.getTestGroup() instanceof SimpleTestGroupWithNone)) {
            AbTest abTest = this.b.getAbTest(realtyNewBackNavigationTestConfig.getRemoteKey());
            testGroupWithClientExposure = realtyNewBackNavigationTestConfig.createAbTest(abTest, this.d, this.f, access$getAbTestConfig(this, abTest, realtyNewBackNavigationTestConfig.getTestConfigClass()), realtyNewBackNavigationTestConfig.getRemoteKey());
            if (realtyNewBackNavigationTestConfig.getConsistentWithinSession()) {
                this.a.put(realtyNewBackNavigationTestConfig.getRemoteKey(), testGroupWithClientExposure);
            }
            this.c.reportUsageTest(realtyNewBackNavigationTestConfig.getRemoteKey(), (RemoteNamingGroup) testGroupWithClientExposure.getTestGroup());
        }
        return new ManuallyExposedAbTestGroup<>(testGroupWithClientExposure, this.e);
    }

    @Override // com.avito.android.ab_tests.AbTestsConfigProvider
    @NotNull
    public SingleManuallyExposedAbTestGroup<SellerInfoInRichSnippetTestGroup> sellerInfoInRichSnippet() {
        TestGroupWithClientExposure testGroupWithClientExposure;
        SellerInfoInRichSnippetConfig sellerInfoInRichSnippetConfig = new SellerInfoInRichSnippetConfig();
        if (!sellerInfoInRichSnippetConfig.getConsistentWithinSession() || (testGroupWithClientExposure = (TestGroupWithClientExposure) this.a.get(sellerInfoInRichSnippetConfig.getRemoteKey())) == null || !(testGroupWithClientExposure.getTestGroup() instanceof SellerInfoInRichSnippetTestGroup)) {
            AbTest abTest = this.b.getAbTest(sellerInfoInRichSnippetConfig.getRemoteKey());
            testGroupWithClientExposure = sellerInfoInRichSnippetConfig.createAbTest(abTest, this.d, this.f, access$getAbTestConfig(this, abTest, sellerInfoInRichSnippetConfig.getTestConfigClass()), sellerInfoInRichSnippetConfig.getRemoteKey());
            if (sellerInfoInRichSnippetConfig.getConsistentWithinSession()) {
                this.a.put(sellerInfoInRichSnippetConfig.getRemoteKey(), testGroupWithClientExposure);
            }
            this.c.reportUsageTest(sellerInfoInRichSnippetConfig.getRemoteKey(), (RemoteNamingGroup) testGroupWithClientExposure.getTestGroup());
        }
        return new SingleManuallyExposedAbTestGroup<>(testGroupWithClientExposure, this.e);
    }

    @Override // com.avito.android.ab_tests.AbTestsConfigProvider
    @NotNull
    public ExposedAbTestGroup<SendEmployersPhoneOnCallToSellerButtonClickInResumesTestGroup> sendEmployersPhoneOnCallButtonClick() {
        TestGroupWithClientExposure testGroupWithClientExposure;
        SendEmployersPhoneOnCallButtonClickInResumeTestConfig sendEmployersPhoneOnCallButtonClickInResumeTestConfig = new SendEmployersPhoneOnCallButtonClickInResumeTestConfig();
        if (!sendEmployersPhoneOnCallButtonClickInResumeTestConfig.getConsistentWithinSession() || (testGroupWithClientExposure = (TestGroupWithClientExposure) this.a.get(sendEmployersPhoneOnCallButtonClickInResumeTestConfig.getRemoteKey())) == null || !(testGroupWithClientExposure.getTestGroup() instanceof SendEmployersPhoneOnCallToSellerButtonClickInResumesTestGroup)) {
            AbTest abTest = this.b.getAbTest(sendEmployersPhoneOnCallButtonClickInResumeTestConfig.getRemoteKey());
            testGroupWithClientExposure = sendEmployersPhoneOnCallButtonClickInResumeTestConfig.createAbTest(abTest, this.d, this.f, access$getAbTestConfig(this, abTest, sendEmployersPhoneOnCallButtonClickInResumeTestConfig.getTestConfigClass()), sendEmployersPhoneOnCallButtonClickInResumeTestConfig.getRemoteKey());
            if (sendEmployersPhoneOnCallButtonClickInResumeTestConfig.getConsistentWithinSession()) {
                this.a.put(sendEmployersPhoneOnCallButtonClickInResumeTestConfig.getRemoteKey(), testGroupWithClientExposure);
            }
            this.c.reportUsageTest(sendEmployersPhoneOnCallButtonClickInResumeTestConfig.getRemoteKey(), (RemoteNamingGroup) testGroupWithClientExposure.getTestGroup());
        }
        return new ExposedAbTestGroup<>(testGroupWithClientExposure, this.e);
    }

    @Override // com.avito.android.ab_tests.AbTestsConfigProvider
    @NotNull
    public AbTestGroup<SerpItemsPrefetchTestGroup> serpItemsPrefetch() {
        TestGroupWithClientExposure testGroupWithClientExposure;
        SerpItemsPrefetchTestConfig serpItemsPrefetchTestConfig = new SerpItemsPrefetchTestConfig();
        if (!serpItemsPrefetchTestConfig.getConsistentWithinSession() || (testGroupWithClientExposure = (TestGroupWithClientExposure) this.a.get(serpItemsPrefetchTestConfig.getRemoteKey())) == null || !(testGroupWithClientExposure.getTestGroup() instanceof SerpItemsPrefetchTestGroup)) {
            AbTest abTest = this.b.getAbTest(serpItemsPrefetchTestConfig.getRemoteKey());
            testGroupWithClientExposure = serpItemsPrefetchTestConfig.createAbTest(abTest, this.d, this.f, access$getAbTestConfig(this, abTest, serpItemsPrefetchTestConfig.getTestConfigClass()), serpItemsPrefetchTestConfig.getRemoteKey());
            if (serpItemsPrefetchTestConfig.getConsistentWithinSession()) {
                this.a.put(serpItemsPrefetchTestConfig.getRemoteKey(), testGroupWithClientExposure);
            }
            this.c.reportUsageTest(serpItemsPrefetchTestConfig.getRemoteKey(), (RemoteNamingGroup) testGroupWithClientExposure.getTestGroup());
        }
        return new ExposedAbTestGroup(testGroupWithClientExposure, this.e);
    }

    @Override // com.avito.android.ab_tests.AbTestsConfigProvider
    @NotNull
    public ExposedAbTestGroup<SerpSkeletonTestGroup> serpSkeletonTest() {
        TestGroupWithClientExposure testGroupWithClientExposure;
        SerpSkeletonTestConfig serpSkeletonTestConfig = new SerpSkeletonTestConfig();
        if (!serpSkeletonTestConfig.getConsistentWithinSession() || (testGroupWithClientExposure = (TestGroupWithClientExposure) this.a.get(serpSkeletonTestConfig.getRemoteKey())) == null || !(testGroupWithClientExposure.getTestGroup() instanceof SerpSkeletonTestGroup)) {
            AbTest abTest = this.b.getAbTest(serpSkeletonTestConfig.getRemoteKey());
            testGroupWithClientExposure = serpSkeletonTestConfig.createAbTest(abTest, this.d, this.f, access$getAbTestConfig(this, abTest, serpSkeletonTestConfig.getTestConfigClass()), serpSkeletonTestConfig.getRemoteKey());
            if (serpSkeletonTestConfig.getConsistentWithinSession()) {
                this.a.put(serpSkeletonTestConfig.getRemoteKey(), testGroupWithClientExposure);
            }
            this.c.reportUsageTest(serpSkeletonTestConfig.getRemoteKey(), (RemoteNamingGroup) testGroupWithClientExposure.getTestGroup());
        }
        return new ExposedAbTestGroup<>(testGroupWithClientExposure, this.e);
    }

    @Override // com.avito.android.ab_tests.AbTestsConfigProvider
    @NotNull
    public SingleManuallyExposedAbTestGroup<SravniWebTestGroup> sravniWeb() {
        TestGroupWithClientExposure testGroupWithClientExposure;
        SravniWebTestConfig sravniWebTestConfig = new SravniWebTestConfig();
        if (!sravniWebTestConfig.getConsistentWithinSession() || (testGroupWithClientExposure = (TestGroupWithClientExposure) this.a.get(sravniWebTestConfig.getRemoteKey())) == null || !(testGroupWithClientExposure.getTestGroup() instanceof SravniWebTestGroup)) {
            AbTest abTest = this.b.getAbTest(sravniWebTestConfig.getRemoteKey());
            testGroupWithClientExposure = sravniWebTestConfig.createAbTest(abTest, this.d, this.f, access$getAbTestConfig(this, abTest, sravniWebTestConfig.getTestConfigClass()), sravniWebTestConfig.getRemoteKey());
            if (sravniWebTestConfig.getConsistentWithinSession()) {
                this.a.put(sravniWebTestConfig.getRemoteKey(), testGroupWithClientExposure);
            }
            this.c.reportUsageTest(sravniWebTestConfig.getRemoteKey(), (RemoteNamingGroup) testGroupWithClientExposure.getTestGroup());
        }
        return new SingleManuallyExposedAbTestGroup<>(testGroupWithClientExposure, this.e);
    }

    @Override // com.avito.android.ab_tests.AbTestsConfigSaver
    public void store(@NotNull AbTestsConfigResponse abTestsConfigResponse) {
        Intrinsics.checkNotNullParameter(abTestsConfigResponse, Navigation.CONFIG);
        this.b.store(abTestsConfigResponse);
    }

    @Override // com.avito.android.ab_tests.AbTestsConfigProvider
    @NotNull
    public SingleManuallyExposedAbTestGroup<TinkoffCreditCalculatorTestGroup> tinkoffCreditCalculatorTest() {
        TestGroupWithClientExposure testGroupWithClientExposure;
        TinkoffCreditCalculatorTestConfig tinkoffCreditCalculatorTestConfig = new TinkoffCreditCalculatorTestConfig();
        if (!tinkoffCreditCalculatorTestConfig.getConsistentWithinSession() || (testGroupWithClientExposure = (TestGroupWithClientExposure) this.a.get(tinkoffCreditCalculatorTestConfig.getRemoteKey())) == null || !(testGroupWithClientExposure.getTestGroup() instanceof TinkoffCreditCalculatorTestGroup)) {
            AbTest abTest = this.b.getAbTest(tinkoffCreditCalculatorTestConfig.getRemoteKey());
            testGroupWithClientExposure = tinkoffCreditCalculatorTestConfig.createAbTest(abTest, this.d, this.f, access$getAbTestConfig(this, abTest, tinkoffCreditCalculatorTestConfig.getTestConfigClass()), tinkoffCreditCalculatorTestConfig.getRemoteKey());
            if (tinkoffCreditCalculatorTestConfig.getConsistentWithinSession()) {
                this.a.put(tinkoffCreditCalculatorTestConfig.getRemoteKey(), testGroupWithClientExposure);
            }
            this.c.reportUsageTest(tinkoffCreditCalculatorTestConfig.getRemoteKey(), (RemoteNamingGroup) testGroupWithClientExposure.getTestGroup());
        }
        return new SingleManuallyExposedAbTestGroup<>(testGroupWithClientExposure, this.e);
    }

    @Override // com.avito.android.ab_tests.AbTestsConfigProvider
    @NotNull
    public SingleManuallyExposedAbTestGroup<UserAdvertsTabTestGroup> userAdvertsNavigationTab() {
        TestGroupWithClientExposure testGroupWithClientExposure;
        UserAdvertsTabTestConfig userAdvertsTabTestConfig = new UserAdvertsTabTestConfig();
        if (!userAdvertsTabTestConfig.getConsistentWithinSession() || (testGroupWithClientExposure = (TestGroupWithClientExposure) this.a.get(userAdvertsTabTestConfig.getRemoteKey())) == null || !(testGroupWithClientExposure.getTestGroup() instanceof UserAdvertsTabTestGroup)) {
            AbTest abTest = this.b.getAbTest(userAdvertsTabTestConfig.getRemoteKey());
            testGroupWithClientExposure = userAdvertsTabTestConfig.createAbTest(abTest, this.d, this.f, access$getAbTestConfig(this, abTest, userAdvertsTabTestConfig.getTestConfigClass()), userAdvertsTabTestConfig.getRemoteKey());
            if (userAdvertsTabTestConfig.getConsistentWithinSession()) {
                this.a.put(userAdvertsTabTestConfig.getRemoteKey(), testGroupWithClientExposure);
            }
            this.c.reportUsageTest(userAdvertsTabTestConfig.getRemoteKey(), (RemoteNamingGroup) testGroupWithClientExposure.getTestGroup());
        }
        return new SingleManuallyExposedAbTestGroup<>(testGroupWithClientExposure, this.e);
    }

    @Override // com.avito.android.ab_tests.AbTestsConfigProvider
    @NotNull
    public SingleManuallyExposedAbTestGroup<ViewedItemsTabTestGroup> viewedItemsTab() {
        TestGroupWithClientExposure testGroupWithClientExposure;
        ViewedItemsTabTestConfig viewedItemsTabTestConfig = new ViewedItemsTabTestConfig();
        if (!viewedItemsTabTestConfig.getConsistentWithinSession() || (testGroupWithClientExposure = (TestGroupWithClientExposure) this.a.get(viewedItemsTabTestConfig.getRemoteKey())) == null || !(testGroupWithClientExposure.getTestGroup() instanceof ViewedItemsTabTestGroup)) {
            AbTest abTest = this.b.getAbTest(viewedItemsTabTestConfig.getRemoteKey());
            testGroupWithClientExposure = viewedItemsTabTestConfig.createAbTest(abTest, this.d, this.f, access$getAbTestConfig(this, abTest, viewedItemsTabTestConfig.getTestConfigClass()), viewedItemsTabTestConfig.getRemoteKey());
            if (viewedItemsTabTestConfig.getConsistentWithinSession()) {
                this.a.put(viewedItemsTabTestConfig.getRemoteKey(), testGroupWithClientExposure);
            }
            this.c.reportUsageTest(viewedItemsTabTestConfig.getRemoteKey(), (RemoteNamingGroup) testGroupWithClientExposure.getTestGroup());
        }
        return new SingleManuallyExposedAbTestGroup<>(testGroupWithClientExposure, this.e);
    }

    @Override // com.avito.android.ab_tests.AbTestsConfigProvider
    @NotNull
    public SingleManuallyExposedAbTestGroup<ViewedItemsWidgetOnMainTestGroup> viewedItemsWidgetOnMain() {
        TestGroupWithClientExposure testGroupWithClientExposure;
        ViewedItemsWidgetOnMainTestConfig viewedItemsWidgetOnMainTestConfig = new ViewedItemsWidgetOnMainTestConfig();
        if (!viewedItemsWidgetOnMainTestConfig.getConsistentWithinSession() || (testGroupWithClientExposure = (TestGroupWithClientExposure) this.a.get(viewedItemsWidgetOnMainTestConfig.getRemoteKey())) == null || !(testGroupWithClientExposure.getTestGroup() instanceof ViewedItemsWidgetOnMainTestGroup)) {
            AbTest abTest = this.b.getAbTest(viewedItemsWidgetOnMainTestConfig.getRemoteKey());
            testGroupWithClientExposure = viewedItemsWidgetOnMainTestConfig.createAbTest(abTest, this.d, this.f, access$getAbTestConfig(this, abTest, viewedItemsWidgetOnMainTestConfig.getTestConfigClass()), viewedItemsWidgetOnMainTestConfig.getRemoteKey());
            if (viewedItemsWidgetOnMainTestConfig.getConsistentWithinSession()) {
                this.a.put(viewedItemsWidgetOnMainTestConfig.getRemoteKey(), testGroupWithClientExposure);
            }
            this.c.reportUsageTest(viewedItemsWidgetOnMainTestConfig.getRemoteKey(), (RemoteNamingGroup) testGroupWithClientExposure.getTestGroup());
        }
        return new SingleManuallyExposedAbTestGroup<>(testGroupWithClientExposure, this.e);
    }
}
