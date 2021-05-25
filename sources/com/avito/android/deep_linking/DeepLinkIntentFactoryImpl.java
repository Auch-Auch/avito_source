package com.avito.android.deep_linking;

import android.content.Intent;
import android.os.SystemClock;
import com.avito.android.AbuseIntentFactory;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.AdvertDetailsIntentFactory;
import com.avito.android.AuthIntentFactory;
import com.avito.android.BrandspaceIntentFactory;
import com.avito.android.DetailsSheetIntentFactory;
import com.avito.android.Features;
import com.avito.android.ItemMapIntentFactory;
import com.avito.android.MessengerIntentFactory;
import com.avito.android.NotificationCenterIntentFactory;
import com.avito.android.PhoneConfirmationIntentFactory;
import com.avito.android.PhoneManagementIntentFactory;
import com.avito.android.PhoneRequestDeepLinkAnalyticsData;
import com.avito.android.PublicProfileIntentFactory;
import com.avito.android.PublishIntentFactory;
import com.avito.android.RatingIntentFactory;
import com.avito.android.SearchMapIntentFactory;
import com.avito.android.SerpIntentFactory;
import com.avito.android.SummaryState;
import com.avito.android.UserAdvertIntentFactory;
import com.avito.android.UserAdvertsIntentFactory;
import com.avito.android.VerificationIntentFactory;
import com.avito.android.calls_shared.AppCallScenario;
import com.avito.android.calls_shared.CallUuidProvider;
import com.avito.android.deep_linking.links.AbuseReportLink;
import com.avito.android.deep_linking.links.AdvertDetailsLink;
import com.avito.android.deep_linking.links.AdvertListLink;
import com.avito.android.deep_linking.links.AdvertPublicationLink;
import com.avito.android.deep_linking.links.AppliedServicesLink;
import com.avito.android.deep_linking.links.AuthenticateLink;
import com.avito.android.deep_linking.links.AutoCatalogLink;
import com.avito.android.deep_linking.links.AutoDealDetailsLink;
import com.avito.android.deep_linking.links.AutotekaBuyReportLink;
import com.avito.android.deep_linking.links.AutotekaDetailsLink;
import com.avito.android.deep_linking.links.BadgeBarShowLink;
import com.avito.android.deep_linking.links.BlockUserWithReasonLink;
import com.avito.android.deep_linking.links.BlockedIpScreenLink;
import com.avito.android.deep_linking.links.BrandspaceLink;
import com.avito.android.deep_linking.links.BuyAdvertContactsLink;
import com.avito.android.deep_linking.links.CallFeedbackLink;
import com.avito.android.deep_linking.links.CarBookingInfoLink;
import com.avito.android.deep_linking.links.CarBookingOrderLink;
import com.avito.android.deep_linking.links.CartLink;
import com.avito.android.deep_linking.links.ChannelDetailsLink;
import com.avito.android.deep_linking.links.ChannelMapLink;
import com.avito.android.deep_linking.links.ChannelsLink;
import com.avito.android.deep_linking.links.ClickStreamLink;
import com.avito.android.deep_linking.links.ConsultationFormLink;
import com.avito.android.deep_linking.links.CreateChannelLink;
import com.avito.android.deep_linking.links.CreateChannelWithAvitoLink;
import com.avito.android.deep_linking.links.CvPackagesLink;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.DeepLinkContainer;
import com.avito.android.deep_linking.links.DeliveryCourierLocationSelectLink;
import com.avito.android.deep_linking.links.DeliveryCourierOrderCreateDeeplink;
import com.avito.android.deep_linking.links.DeliveryCourierOrderUpdateLink;
import com.avito.android.deep_linking.links.DeliveryCourierTimeIntervalSelectLink;
import com.avito.android.deep_linking.links.DeliveryOrderCancelLink;
import com.avito.android.deep_linking.links.DeliveryOrderPayLink;
import com.avito.android.deep_linking.links.DeliveryProfileSettingsLink;
import com.avito.android.deep_linking.links.DeliveryStartOrderingDeepLink;
import com.avito.android.deep_linking.links.DeliverySummaryDeepLink;
import com.avito.android.deep_linking.links.DetailsSheetLink;
import com.avito.android.deep_linking.links.DevelopmentsCatalogDeveloperLink;
import com.avito.android.deep_linking.links.DevelopmentsCatalogLink;
import com.avito.android.deep_linking.links.DialogDeepLink;
import com.avito.android.deep_linking.links.DiscountLink;
import com.avito.android.deep_linking.links.DraftPublicationLink;
import com.avito.android.deep_linking.links.EditProfileLink;
import com.avito.android.deep_linking.links.ExpressCvLink;
import com.avito.android.deep_linking.links.ExternalAppLink;
import com.avito.android.deep_linking.links.FavoritesLink;
import com.avito.android.deep_linking.links.HelpCenterArticleShowLink;
import com.avito.android.deep_linking.links.HelpCenterRequestLink;
import com.avito.android.deep_linking.links.HelpCenterShowLink;
import com.avito.android.deep_linking.links.HelpCenterUrlShowLink;
import com.avito.android.deep_linking.links.HintsLink;
import com.avito.android.deep_linking.links.HotelsLandingLink;
import com.avito.android.deep_linking.links.ImvWebViewBottomSheepLink;
import com.avito.android.deep_linking.links.InAppCallBackLink;
import com.avito.android.deep_linking.links.IncomeSettingsLink;
import com.avito.android.deep_linking.links.InfoPageLink;
import com.avito.android.deep_linking.links.ItemReportLink;
import com.avito.android.deep_linking.links.ItemStatsLink;
import com.avito.android.deep_linking.links.ItemsSearchLink;
import com.avito.android.deep_linking.links.JobAssistantPickLocationLink;
import com.avito.android.deep_linking.links.JobInterviewInvitationFormLink;
import com.avito.android.deep_linking.links.JobSeekerCreateSurveyLink;
import com.avito.android.deep_linking.links.LandlinePhoneVerificationLink;
import com.avito.android.deep_linking.links.LegacyPaidServicesLink;
import com.avito.android.deep_linking.links.LegacyPaymentSessionLink;
import com.avito.android.deep_linking.links.LfPackagesLink;
import com.avito.android.deep_linking.links.LoginLink;
import com.avito.android.deep_linking.links.MainScreenLink;
import com.avito.android.deep_linking.links.MobilePhoneVerificationLink;
import com.avito.android.deep_linking.links.MyAdvertDetailsLink;
import com.avito.android.deep_linking.links.MyAdvertLink;
import com.avito.android.deep_linking.links.MyDraftAdvertDetailsLink;
import com.avito.android.deep_linking.links.NoMatchLink;
import com.avito.android.deep_linking.links.NotificationCenterFeedbackLandingLink;
import com.avito.android.deep_linking.links.NotificationCenterLandingShareLink;
import com.avito.android.deep_linking.links.NotificationCenterLink;
import com.avito.android.deep_linking.links.NotificationCenterMainLandingLink;
import com.avito.android.deep_linking.links.NotificationCenterRecommendsLandingLink;
import com.avito.android.deep_linking.links.NotificationCenterUnifiedLandingLink;
import com.avito.android.deep_linking.links.OrderLink;
import com.avito.android.deep_linking.links.OrdersLink;
import com.avito.android.deep_linking.links.PaidServicesLink;
import com.avito.android.deep_linking.links.PassportVerificationLink;
import com.avito.android.deep_linking.links.PasswordChangeLink;
import com.avito.android.deep_linking.links.PasswordSettingLink;
import com.avito.android.deep_linking.links.PaymentGenericFormLink;
import com.avito.android.deep_linking.links.PaymentGenericLink;
import com.avito.android.deep_linking.links.PaymentSessionLink;
import com.avito.android.deep_linking.links.PaymentStatusFormLink;
import com.avito.android.deep_linking.links.PaymentStatusLink;
import com.avito.android.deep_linking.links.PhoneAddLink;
import com.avito.android.deep_linking.links.PhoneLink;
import com.avito.android.deep_linking.links.PhoneManagementLink;
import com.avito.android.deep_linking.links.PhoneRequestLink;
import com.avito.android.deep_linking.links.PhoneVerificationStatusLink;
import com.avito.android.deep_linking.links.PhoneVerifyLink;
import com.avito.android.deep_linking.links.ProfileLink;
import com.avito.android.deep_linking.links.ProfileNotificationsLink;
import com.avito.android.deep_linking.links.PromoLink;
import com.avito.android.deep_linking.links.PublicProfileLink;
import com.avito.android.deep_linking.links.PublicRatingDetailsLink;
import com.avito.android.deep_linking.links.PublishLimitsHistoryLink;
import com.avito.android.deep_linking.links.RatingPublishLink;
import com.avito.android.deep_linking.links.RealtyRequestFormLink;
import com.avito.android.deep_linking.links.RegisterLink;
import com.avito.android.deep_linking.links.ResetPasswordLink;
import com.avito.android.deep_linking.links.RestorePasswordLink;
import com.avito.android.deep_linking.links.SBOLPaymentLink;
import com.avito.android.deep_linking.links.SafeDealOrderTypesDeepLink;
import com.avito.android.deep_linking.links.SearchSubscriptionLink;
import com.avito.android.deep_linking.links.SellerSubscribersLink;
import com.avito.android.deep_linking.links.SellerSubscriptionsLink;
import com.avito.android.deep_linking.links.SendEmailLink;
import com.avito.android.deep_linking.links.ServiceSubscriptionLink;
import com.avito.android.deep_linking.links.SessionsListLink;
import com.avito.android.deep_linking.links.SessionsSocialLogoutLink;
import com.avito.android.deep_linking.links.SettingsNotificationsLink;
import com.avito.android.deep_linking.links.ShareLink;
import com.avito.android.deep_linking.links.ShopInfoLink;
import com.avito.android.deep_linking.links.ShopLink;
import com.avito.android.deep_linking.links.ShopRatingDetailsLink;
import com.avito.android.deep_linking.links.ShopSettingsLink;
import com.avito.android.deep_linking.links.ShopsLink;
import com.avito.android.deep_linking.links.ShowPinMapLink;
import com.avito.android.deep_linking.links.SocialsListLink;
import com.avito.android.deep_linking.links.StartPublishFromUserAdvertsLink;
import com.avito.android.deep_linking.links.StrManageCalendarLink;
import com.avito.android.deep_linking.links.StrStartBookingDeepLink;
import com.avito.android.deep_linking.links.SupportChatFormLink;
import com.avito.android.deep_linking.links.ThemeSettingsLink;
import com.avito.android.deep_linking.links.ToastMessageLink;
import com.avito.android.deep_linking.links.TopUpFormLink;
import com.avito.android.deep_linking.links.UTMLink;
import com.avito.android.deep_linking.links.UTMLinkConverter;
import com.avito.android.deep_linking.links.UserAdvertsLink;
import com.avito.android.deep_linking.links.UserContactsLink;
import com.avito.android.deep_linking.links.UserRatingDetailsLink;
import com.avito.android.deep_linking.links.UserReviewsLink;
import com.avito.android.deep_linking.links.UserStatsLink;
import com.avito.android.deep_linking.links.UserSubscribersLink;
import com.avito.android.deep_linking.links.VerificationRemoveLink;
import com.avito.android.deep_linking.links.VerificationStatusLink;
import com.avito.android.deep_linking.links.VerificationsListLink;
import com.avito.android.in_app_calls.data.CallActivityRequest;
import com.avito.android.navigation.NavigationTabProvider;
import com.avito.android.ratings.RatingPublishConfig;
import com.avito.android.registration.ConstantsKt;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Navigation;
import com.avito.android.remote.model.RawJson;
import com.avito.android.remote.model.category_parameters.CharParameter;
import com.avito.android.remote.model.category_parameters.SimpleParametersTree;
import com.avito.android.remote.model.messenger.geo.GeoMarker;
import com.avito.android.remote.model.messenger.geo.MarkersRequest;
import com.avito.android.remote.model.text.AttributedText;
import com.avito.android.util.Constants;
import com.avito.android.util.ImplicitIntentFactory;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.d;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u001a\u001a\u00020\u0017\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u0013\u0012\u0006\u0010\u001e\u001a\u00020\u001b\u0012\u0006\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u001f\u0010 J\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d¨\u0006!"}, d2 = {"Lcom/avito/android/deep_linking/DeepLinkIntentFactoryImpl;", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "Lcom/avito/android/deep_linking/links/DeepLink;", "link", "Landroid/content/Intent;", "getIntent", "(Lcom/avito/android/deep_linking/links/DeepLink;)Landroid/content/Intent;", "Lcom/avito/android/util/ImplicitIntentFactory;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/ImplicitIntentFactory;", "implicitIntentFactory", "Lcom/avito/android/calls_shared/CallUuidProvider;", "f", "Lcom/avito/android/calls_shared/CallUuidProvider;", "callUuidProvider", "Lcom/avito/android/Features;", "c", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/navigation/NavigationTabProvider;", "d", "Lcom/avito/android/navigation/NavigationTabProvider;", "tabProvider", "Lcom/avito/android/ActivityIntentFactory;", AuthSource.SEND_ABUSE, "Lcom/avito/android/ActivityIntentFactory;", "activityIntentFactory", "Lcom/avito/android/deep_linking/links/UTMLinkConverter;", "e", "Lcom/avito/android/deep_linking/links/UTMLinkConverter;", "utmLinkConverter", "<init>", "(Lcom/avito/android/ActivityIntentFactory;Lcom/avito/android/util/ImplicitIntentFactory;Lcom/avito/android/Features;Lcom/avito/android/navigation/NavigationTabProvider;Lcom/avito/android/deep_linking/links/UTMLinkConverter;Lcom/avito/android/calls_shared/CallUuidProvider;)V", "core_release"}, k = 1, mv = {1, 4, 2})
public class DeepLinkIntentFactoryImpl implements DeepLinkIntentFactory {
    public final ActivityIntentFactory a;
    public final ImplicitIntentFactory b;
    public final Features c;
    public final NavigationTabProvider d;
    public final UTMLinkConverter e;
    public final CallUuidProvider f;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            PhoneManagementLink.ActionType.values();
            int[] iArr = new int[4];
            $EnumSwitchMapping$0 = iArr;
            iArr[0] = 1;
            iArr[1] = 2;
            iArr[2] = 3;
            iArr[3] = 4;
        }
    }

    public DeepLinkIntentFactoryImpl(@NotNull ActivityIntentFactory activityIntentFactory, @NotNull ImplicitIntentFactory implicitIntentFactory, @NotNull Features features, @NotNull NavigationTabProvider navigationTabProvider, @NotNull UTMLinkConverter uTMLinkConverter, @NotNull CallUuidProvider callUuidProvider) {
        Intrinsics.checkNotNullParameter(activityIntentFactory, "activityIntentFactory");
        Intrinsics.checkNotNullParameter(implicitIntentFactory, "implicitIntentFactory");
        Intrinsics.checkNotNullParameter(features, "features");
        Intrinsics.checkNotNullParameter(navigationTabProvider, "tabProvider");
        Intrinsics.checkNotNullParameter(uTMLinkConverter, "utmLinkConverter");
        Intrinsics.checkNotNullParameter(callUuidProvider, "callUuidProvider");
        this.a = activityIntentFactory;
        this.b = implicitIntentFactory;
        this.c = features;
        this.d = navigationTabProvider;
        this.e = uTMLinkConverter;
        this.f = callUuidProvider;
    }

    @Override // com.avito.android.deep_linking.DeepLinkIntentFactory
    @Nullable
    public Intent getIntent(@NotNull DeepLink deepLink) {
        SimpleParametersTree simpleParametersTree;
        Intent intent;
        Intrinsics.checkNotNullParameter(deepLink, "link");
        PhoneRequestDeepLinkAnalyticsData.Advert advert = null;
        if (deepLink instanceof NoMatchLink) {
            return null;
        }
        if (deepLink instanceof CallFeedbackLink) {
            return this.a.callFeedbackIntent(((CallFeedbackLink) deepLink).getId());
        }
        if (deepLink instanceof MainScreenLink) {
            return this.a.homeIntent();
        }
        if (deepLink instanceof ItemsSearchLink) {
            ItemsSearchLink itemsSearchLink = (ItemsSearchLink) deepLink;
            if (itemsSearchLink.getExpanded() != null) {
                intent = this.a.expandedItemsListIntent(itemsSearchLink.getSearchParams(), itemsSearchLink.getSearchArea(), itemsSearchLink.getContext(), itemsSearchLink.getExpanded(), itemsSearchLink.getSellerId());
            } else if (itemsSearchLink.getShowMap() || itemsSearchLink.getShowSimpleMap()) {
                intent = SearchMapIntentFactory.DefaultImpls.searchByMapIntent$default(this.a, itemsSearchLink.getSearchParams(), itemsSearchLink.getContext(), itemsSearchLink.getSearchArea(), itemsSearchLink.getMapArea(), itemsSearchLink.getMapSerpState(), itemsSearchLink.getMapZoomLevel(), itemsSearchLink.getShowSimpleMap(), null, 128, null);
            } else {
                intent = SerpIntentFactory.DefaultImpls.itemsListIntent$default(this.a, itemsSearchLink.getSearchParams(), itemsSearchLink.getContext(), null, itemsSearchLink.getFromPage(), false, false, 52, null);
            }
            return intent.putExtra(Constants.UP_INTENT, this.a.homeIntent());
        } else if (deepLink instanceof AdvertListLink) {
            return this.a.advertItemListIntent((AdvertListLink) deepLink);
        } else {
            if (deepLink instanceof AdvertDetailsLink) {
                AdvertDetailsLink advertDetailsLink = (AdvertDetailsLink) deepLink;
                return AdvertDetailsIntentFactory.DefaultImpls.advertDetailsIntent$default(this.a, advertDetailsLink.getItemId(), advertDetailsLink.getContext(), null, null, null, null, false, null, SystemClock.elapsedRealtime(), null, this.d.currentTab(), null, 2812, null).putExtra(Constants.UP_INTENT, this.a.homeIntent());
            } else if (deepLink instanceof BadgeBarShowLink) {
                BadgeBarShowLink badgeBarShowLink = (BadgeBarShowLink) deepLink;
                return this.a.badgeDetailsIntent(badgeBarShowLink.getObjectId(), badgeBarShowLink.getObjectEntity(), badgeBarShowLink.getBadgeId());
            } else if (deepLink instanceof DevelopmentsCatalogLink) {
                DevelopmentsCatalogLink developmentsCatalogLink = (DevelopmentsCatalogLink) deepLink;
                return this.a.developmentsCatalog(developmentsCatalogLink.getItemId(), developmentsCatalogLink.getItemTitle(), developmentsCatalogLink.getSearchContext(), this.d.currentTab(), developmentsCatalogLink.getFromPage()).putExtra(Constants.UP_INTENT, this.a.homeIntent());
            } else if (deepLink instanceof DevelopmentsCatalogDeveloperLink) {
                return NotificationCenterIntentFactory.DefaultImpls.promoIntent$default(this.a, ((DevelopmentsCatalogDeveloperLink) deepLink).getUrl(), true, false, 4, null);
            } else {
                if (deepLink instanceof ConsultationFormLink) {
                    ConsultationFormLink consultationFormLink = (ConsultationFormLink) deepLink;
                    return AdvertDetailsIntentFactory.DefaultImpls.consultationForm$default(this.a, consultationFormLink.getAdvertId(), null, consultationFormLink.getForm(), 2, null).putExtra(Constants.UP_INTENT, this.a.homeIntent());
                } else if (deepLink instanceof HotelsLandingLink) {
                    return this.a.hotelsLandingIntent(((HotelsLandingLink) deepLink).getMarker());
                } else {
                    if (deepLink instanceof AutoCatalogLink) {
                        AutoCatalogLink autoCatalogLink = (AutoCatalogLink) deepLink;
                        return this.a.autoCatalog(autoCatalogLink.getGenerationId(), autoCatalogLink.getBodyTypeId(), autoCatalogLink.getModificationId(), autoCatalogLink.getFrom(), autoCatalogLink.getSearchContext(), autoCatalogLink.getLocationId(), autoCatalogLink.getAdvertId(), autoCatalogLink.getAdvertMcid(), this.d.currentTab()).putExtra(Constants.UP_INTENT, this.a.homeIntent());
                    } else if (deepLink instanceof MyAdvertDetailsLink) {
                        MyAdvertDetailsLink myAdvertDetailsLink = (MyAdvertDetailsLink) deepLink;
                        return UserAdvertIntentFactory.DefaultImpls.myAdvertDetailsIntent$default(this.a, myAdvertDetailsLink.getItemId(), null, myAdvertDetailsLink.getInvokeAction(), false, 10, null).setFlags(603979776).putExtra(Constants.UP_INTENT, UserAdvertsIntentFactory.DefaultImpls.createUserAdvertsIntent$default(this.a, null, null, false, 7, null).addFlags(603979776));
                    } else if (deepLink instanceof MyDraftAdvertDetailsLink) {
                        return this.a.myDraftAdvertDetailsIntent(((MyDraftAdvertDetailsLink) deepLink).getDraftId()).putExtra(Constants.UP_INTENT, UserAdvertsIntentFactory.DefaultImpls.createUserAdvertsIntent$default(this.a, null, null, false, 7, null).addFlags(603979776));
                    } else {
                        if (deepLink instanceof MyAdvertLink.Restore) {
                            return this.a.myAdvertDetailsRestoreIntent(((MyAdvertLink.Restore) deepLink).getItemId()).putExtra(Constants.UP_INTENT, this.a.homeIntent());
                        }
                        if (deepLink instanceof MyAdvertLink.Edit) {
                            MyAdvertLink.Edit edit = (MyAdvertLink.Edit) deepLink;
                            return this.a.editingAdvertIntent(edit.getItemId(), edit.getPostAction(), edit.getFocusId()).putExtra(Constants.UP_INTENT, this.a.homeIntent());
                        } else if (deepLink instanceof MyAdvertLink.Activate) {
                            return this.a.myAdvertDetailsActivateIntent(((MyAdvertLink.Activate) deepLink).getItemId()).putExtra(Constants.UP_INTENT, this.a.homeIntent());
                        } else {
                            if (deepLink instanceof ChannelsLink) {
                                return this.a.channelsIntent(((ChannelsLink) deepLink).getAdvertId()).putExtra(Constants.UP_INTENT, this.a.homeIntent());
                            }
                            if (deepLink instanceof InAppCallBackLink) {
                                return this.a.inAppCallIntent(new CallActivityRequest.Dial.ByPreviousCall(this.f.nextCallUuid(), null, ((InAppCallBackLink) deepLink).getCallUuid(), AppCallScenario.CALL_BACK_FROM_DEEPLINK, 2, null));
                            } else if (deepLink instanceof ExternalAppLink) {
                                ExternalAppLink externalAppLink = (ExternalAppLink) deepLink;
                                return this.b.externalUriIntent(externalAppLink.getAppUri(), externalAppLink.getFallbackUri());
                            } else if (deepLink instanceof PhoneVerifyLink) {
                                PhoneVerifyLink phoneVerifyLink = (PhoneVerifyLink) deepLink;
                                return PhoneConfirmationIntentFactory.DefaultImpls.phoneVerificationIntent$default(this.a, phoneVerifyLink.getPhoneNumber(), null, phoneVerifyLink.isCompany(), false, 8, null);
                            } else if (deepLink instanceof MobilePhoneVerificationLink) {
                                return this.a.confirmPhoneCodeRequestIntent(((MobilePhoneVerificationLink) deepLink).getPhone());
                            } else {
                                String str = "";
                                boolean z = false;
                                if (deepLink instanceof LandlinePhoneVerificationLink) {
                                    ActivityIntentFactory activityIntentFactory = this.a;
                                    LandlinePhoneVerificationLink landlinePhoneVerificationLink = (LandlinePhoneVerificationLink) deepLink;
                                    Integer callId = landlinePhoneVerificationLink.getContext().getCallId();
                                    int intValue = callId != null ? callId.intValue() : 0;
                                    String title = landlinePhoneVerificationLink.getContext().getTitle();
                                    String subtitle = landlinePhoneVerificationLink.getContext().getSubtitle();
                                    AttributedText description = landlinePhoneVerificationLink.getContext().getDescription();
                                    String phone = landlinePhoneVerificationLink.getPhone();
                                    return activityIntentFactory.landlinePhoneVerificationIntent(intValue, title, subtitle, description, phone != null ? phone : str, false);
                                } else if (deepLink instanceof PhoneVerificationStatusLink) {
                                    ActivityIntentFactory activityIntentFactory2 = this.a;
                                    PhoneVerificationStatusLink phoneVerificationStatusLink = (PhoneVerificationStatusLink) deepLink;
                                    Integer callId2 = phoneVerificationStatusLink.getContext().getCallId();
                                    return activityIntentFactory2.landlinePhoneVerificationIntent(callId2 != null ? callId2.intValue() : 0, phoneVerificationStatusLink.getContext().getTitle(), phoneVerificationStatusLink.getContext().getSubtitle(), phoneVerificationStatusLink.getContext().getDescription(), "", true);
                                } else if (deepLink instanceof PhoneManagementLink) {
                                    PhoneManagementLink phoneManagementLink = (PhoneManagementLink) deepLink;
                                    int ordinal = phoneManagementLink.getActionType().ordinal();
                                    if (ordinal == 0) {
                                        return this.a.replacePhoneIntent(phoneManagementLink.getPhone(), phoneManagementLink.getAdvertCount(), phoneManagementLink.getReplacingPhones());
                                    }
                                    if (ordinal == 1 || ordinal == 2) {
                                        return this.a.removePhoneIntent(phoneManagementLink.getPhone(), phoneManagementLink.getAdvertCount(), phoneManagementLink.getReplacingPhones());
                                    }
                                    if (ordinal == 3) {
                                        return this.a.setPhoneForAllIntent(phoneManagementLink.getPhone());
                                    }
                                    throw new NoWhenBranchMatchedException();
                                } else if (deepLink instanceof PhoneAddLink) {
                                    PhoneAddLink phoneAddLink = (PhoneAddLink) deepLink;
                                    return PhoneManagementIntentFactory.DefaultImpls.phoneManagementIntent$default(this.a, phoneAddLink.getNumber(), false, 0, false, phoneAddLink.getSource(), 14, null);
                                } else if (deepLink instanceof ExpressCvLink) {
                                    return this.a.expressCvIntent(((ExpressCvLink) deepLink).getContext());
                                } else {
                                    if (deepLink instanceof ShopsLink) {
                                        return this.a.shopsListIntent(((ShopsLink) deepLink).getSearchParams()).putExtra(Constants.UP_INTENT, this.a.homeIntent());
                                    }
                                    if (deepLink instanceof ShopInfoLink) {
                                        return this.a.shopInfoIntent(((ShopInfoLink) deepLink).getShopId());
                                    }
                                    if (deepLink instanceof ShowPinMapLink) {
                                        ShowPinMapLink showPinMapLink = (ShowPinMapLink) deepLink;
                                        return ItemMapIntentFactory.DefaultImpls.itemMapIntent$default(this.a, showPinMapLink.getPin(), false, null, false, showPinMapLink.getAddress(), showPinMapLink.getTitle(), null, null, null, false, showPinMapLink.getCreateRoute(), null, false, null, 15310, null);
                                    } else if (deepLink instanceof ShopLink) {
                                        ShopLink shopLink = (ShopLink) deepLink;
                                        return this.a.shopDetailedIntent(shopLink.getShopId(), shopLink.getPageFrom(), shopLink.getContext(), shopLink.getSearchParams()).addFlags(4194304);
                                    } else if (deepLink instanceof RegisterLink) {
                                        ActivityIntentFactory activityIntentFactory3 = this.a;
                                        return activityIntentFactory3.registrationActivityIntent(activityIntentFactory3.profilePreviewIntent()).putExtra(ConstantsKt.KEY_PREFILLED_EMAIL, ((RegisterLink) deepLink).getEmail());
                                    } else if (deepLink instanceof LoginLink) {
                                        ActivityIntentFactory activityIntentFactory4 = this.a;
                                        return AuthIntentFactory.DefaultImpls.loginIntent$default(activityIntentFactory4, activityIntentFactory4.profilePreviewIntent(), null, null, false, null, false, 62, null);
                                    } else if (deepLink instanceof ResetPasswordLink) {
                                        ResetPasswordLink resetPasswordLink = (ResetPasswordLink) deepLink;
                                        return this.a.resetPasswordIntent(resetPasswordLink.getLogin(), resetPasswordLink.getSkipLoginEntry(), resetPasswordLink.getSrc());
                                    } else if (deepLink instanceof ItemStatsLink) {
                                        return this.a.advertStatsIntent(((ItemStatsLink) deepLink).getItemId());
                                    } else {
                                        if (deepLink instanceof CreateChannelLink) {
                                            CreateChannelLink createChannelLink = (CreateChannelLink) deepLink;
                                            return this.a.createChannelByItemIdIntent(createChannelLink.getItemId(), createChannelLink.getMessageDraft(), createChannelLink.getSource());
                                        } else if (deepLink instanceof CreateChannelWithAvitoLink) {
                                            return this.a.createChannelWithAvito(((CreateChannelWithAvitoLink) deepLink).getSource());
                                        } else {
                                            if (deepLink instanceof BlockUserWithReasonLink) {
                                                BlockUserWithReasonLink blockUserWithReasonLink = (BlockUserWithReasonLink) deepLink;
                                                return this.a.blacklistReasonsIntent(blockUserWithReasonLink.getUserId(), blockUserWithReasonLink.getChannelId(), blockUserWithReasonLink.getItemId());
                                            } else if (deepLink instanceof ChannelDetailsLink) {
                                                Intent addFlags = MessengerIntentFactory.DefaultImpls.channelsIntent$default(this.a, null, 1, null).addFlags(603979776);
                                                Intrinsics.checkNotNullExpressionValue(addFlags, "activityIntentFactory\n  …FLAG_ACTIVITY_SINGLE_TOP)");
                                                return MessengerIntentFactory.DefaultImpls.channelIntent$default(this.a, ((ChannelDetailsLink) deepLink).getChannelId(), null, null, null, false, 30, null).putExtra(Constants.UP_INTENT, addFlags);
                                            } else if (deepLink instanceof ChannelMapLink) {
                                                ActivityIntentFactory activityIntentFactory5 = this.a;
                                                ChannelMapLink channelMapLink = (ChannelMapLink) deepLink;
                                                String title2 = channelMapLink.getTitle();
                                                return MessengerIntentFactory.DefaultImpls.messengerPlatformMapIntent$default(activityIntentFactory5, title2 != null ? title2 : str, new GeoMarker[0], new MarkersRequest(channelMapLink.getMethod(), new RawJson(channelMapLink.getParamsJson())), false, 8, null);
                                            } else if (deepLink instanceof SendEmailLink) {
                                                SendEmailLink sendEmailLink = (SendEmailLink) deepLink;
                                                return this.b.emailIntent(sendEmailLink.getToEmail(), sendEmailLink.getSubject(), sendEmailLink.getInfo());
                                            } else if (deepLink instanceof AdvertPublicationLink) {
                                                AdvertPublicationLink advertPublicationLink = (AdvertPublicationLink) deepLink;
                                                if (advertPublicationLink.getNavigation() == null) {
                                                    return this.a.newAdvert();
                                                }
                                                ActivityIntentFactory activityIntentFactory6 = this.a;
                                                Navigation navigation = advertPublicationLink.getNavigation();
                                                Intrinsics.checkNotNull(navigation);
                                                return activityIntentFactory6.publishAdvertIntent(navigation);
                                            } else if (deepLink instanceof DraftPublicationLink) {
                                                return PublishIntentFactory.DefaultImpls.publishAdvertFromDraftIntent$default(this.a, ((DraftPublicationLink) deepLink).getDraftId(), false, 2, null);
                                            } else {
                                                if (deepLink instanceof PublishLimitsHistoryLink) {
                                                    PublishLimitsHistoryLink publishLimitsHistoryLink = (PublishLimitsHistoryLink) deepLink;
                                                    PublishLimitsHistoryLink.Request request = publishLimitsHistoryLink.getRequest();
                                                    if (request instanceof PublishLimitsHistoryLink.Request.AdvertId) {
                                                        ActivityIntentFactory activityIntentFactory7 = this.a;
                                                        PublishLimitsHistoryLink.Request request2 = publishLimitsHistoryLink.getRequest();
                                                        Objects.requireNonNull(request2, "null cannot be cast to non-null type com.avito.android.deep_linking.links.PublishLimitsHistoryLink.Request.AdvertId");
                                                        return activityIntentFactory7.createLimitsHistoryIntent(((PublishLimitsHistoryLink.Request.AdvertId) request2).getAdvertId());
                                                    } else if (request instanceof PublishLimitsHistoryLink.Request.DraftId) {
                                                        ActivityIntentFactory activityIntentFactory8 = this.a;
                                                        PublishLimitsHistoryLink.Request request3 = publishLimitsHistoryLink.getRequest();
                                                        Objects.requireNonNull(request3, "null cannot be cast to non-null type com.avito.android.deep_linking.links.PublishLimitsHistoryLink.Request.DraftId");
                                                        return activityIntentFactory8.createLimitsHistoryForDraftIntent(((PublishLimitsHistoryLink.Request.DraftId) request3).getDraftId());
                                                    } else {
                                                        throw new NoWhenBranchMatchedException();
                                                    }
                                                } else if (deepLink instanceof ItemReportLink) {
                                                    return this.a.itemReportIntent(((ItemReportLink) deepLink).getItemId());
                                                } else {
                                                    if (deepLink instanceof InfoPageLink) {
                                                        InfoPageLink infoPageLink = (InfoPageLink) deepLink;
                                                        return this.a.infoIntent(infoPageLink.getPage(), infoPageLink.getTitle());
                                                    } else if (deepLink instanceof UserAdvertsLink) {
                                                        return UserAdvertsIntentFactory.DefaultImpls.createUserAdvertsIntent$default(this.a, ((UserAdvertsLink) deepLink).getShortcut(), null, false, 6, null).addFlags(603979776);
                                                    } else {
                                                        if (deepLink instanceof StartPublishFromUserAdvertsLink) {
                                                            return UserAdvertsIntentFactory.DefaultImpls.createUserAdvertsIntent$default(this.a, null, null, true, 3, null).addFlags(603979776);
                                                        }
                                                        if (deepLink instanceof AuthenticateLink) {
                                                            ActivityIntentFactory activityIntentFactory9 = this.a;
                                                            AuthenticateLink authenticateLink = (AuthenticateLink) deepLink;
                                                            String src = authenticateLink.getSrc();
                                                            if (src == null || src.length() == 0) {
                                                                z = true;
                                                            }
                                                            return AuthIntentFactory.DefaultImpls.authIntent$default(activityIntentFactory9, null, z ? AuthSource.TEST_7 : authenticateLink.getSrc(), null, 5, null);
                                                        } else if (deepLink instanceof BuyAdvertContactsLink) {
                                                            BuyAdvertContactsLink buyAdvertContactsLink = (BuyAdvertContactsLink) deepLink;
                                                            return this.a.contactAccessService(buyAdvertContactsLink.getItemId(), buyAdvertContactsLink.getServiceId(), buyAdvertContactsLink.getExternalId());
                                                        } else if (deepLink instanceof CvPackagesLink) {
                                                            return this.a.getJobCvPackagesIntent(((CvPackagesLink) deepLink).getItemId());
                                                        } else {
                                                            if (deepLink instanceof PromoLink) {
                                                                PromoLink promoLink = (PromoLink) deepLink;
                                                                return NotificationCenterIntentFactory.DefaultImpls.promoIntent$default(this.a, promoLink.getExtendedUrl(), false, promoLink.getWithAuthorization(), 2, null);
                                                            } else if (deepLink instanceof ImvWebViewBottomSheepLink) {
                                                                return this.a.openImvWebViewBottomSheet(((ImvWebViewBottomSheepLink) deepLink).getUrl());
                                                            } else {
                                                                if (deepLink instanceof PhoneLink.Call) {
                                                                    return this.b.dialIntent(((PhoneLink.Call) deepLink).getPhone());
                                                                }
                                                                if (deepLink instanceof ProfileLink) {
                                                                    return this.a.profilePreviewIntent();
                                                                }
                                                                if (deepLink instanceof UserRatingDetailsLink) {
                                                                    return this.a.userProfileRatingDetails();
                                                                }
                                                                if (deepLink instanceof PublicRatingDetailsLink) {
                                                                    return this.a.publicProfileRatingDetails(((PublicRatingDetailsLink) deepLink).getUserKey());
                                                                }
                                                                if (deepLink instanceof ShopRatingDetailsLink) {
                                                                    return this.a.shopRatingDetails(((ShopRatingDetailsLink) deepLink).getShopId());
                                                                }
                                                                if (deepLink instanceof RatingPublishLink) {
                                                                    RatingPublishLink ratingPublishLink = (RatingPublishLink) deepLink;
                                                                    return RatingIntentFactory.DefaultImpls.ratingPublish$default(this.a, new RatingPublishConfig(ratingPublishLink.getUserKey(), ratingPublishLink.getContext(), ratingPublishLink.getDealProof(), ratingPublishLink.getBuyerInfo(), ratingPublishLink.isAuto(), ratingPublishLink.getItemId(), ratingPublishLink.getScore()), false, 2, null);
                                                                } else if (deepLink instanceof UserReviewsLink) {
                                                                    return this.a.userReviews(((UserReviewsLink) deepLink).getContext());
                                                                } else {
                                                                    if (deepLink instanceof UserContactsLink) {
                                                                        return this.a.userContacts(((UserContactsLink) deepLink).getContext());
                                                                    }
                                                                    if (deepLink instanceof SellerSubscribersLink) {
                                                                        return this.a.subscribersIntent(((SellerSubscribersLink) deepLink).getUserKey());
                                                                    }
                                                                    if (deepLink instanceof SellerSubscriptionsLink) {
                                                                        return this.a.subscriptionsIntent(((SellerSubscriptionsLink) deepLink).getUserKey());
                                                                    }
                                                                    if (deepLink instanceof ShareLink) {
                                                                        ShareLink shareLink = (ShareLink) deepLink;
                                                                        return Intent.createChooser(this.b.shareItemIntent(shareLink.getText(), shareLink.getSubject()), shareLink.getTitle());
                                                                    } else if (deepLink instanceof EditProfileLink) {
                                                                        return this.a.createEditProfileIntent();
                                                                    } else {
                                                                        if (deepLink instanceof PublicProfileLink) {
                                                                            PublicProfileLink publicProfileLink = (PublicProfileLink) deepLink;
                                                                            return PublicProfileIntentFactory.DefaultImpls.createProfileScreenResolverIntent$default(this.a, publicProfileLink.getUserKey(), publicProfileLink.getContext(), null, 4, null);
                                                                        } else if (deepLink instanceof FavoritesLink) {
                                                                            return this.a.favoritesIntent();
                                                                        } else {
                                                                            if (deepLink instanceof SearchSubscriptionLink) {
                                                                                return this.a.savedSearchesIntent(((SearchSubscriptionLink) deepLink).getSubscriptionId());
                                                                            }
                                                                            if (deepLink instanceof ServiceSubscriptionLink) {
                                                                                return this.a.serviceSubscriptionActivityIntent();
                                                                            }
                                                                            if (deepLink instanceof LfPackagesLink) {
                                                                                return this.a.lfPackagesActivityIntent();
                                                                            }
                                                                            if (deepLink instanceof ShopSettingsLink) {
                                                                                return this.a.shopSettingsActivityIntent();
                                                                            }
                                                                            if (deepLink instanceof ThemeSettingsLink) {
                                                                                return this.a.themeSettingsIntent();
                                                                            }
                                                                            if (deepLink instanceof LegacyPaymentSessionLink) {
                                                                                LegacyPaymentSessionLink legacyPaymentSessionLink = (LegacyPaymentSessionLink) deepLink;
                                                                                return this.a.servicePaymentIntent(legacyPaymentSessionLink.getItemId(), d.listOf(legacyPaymentSessionLink.getServiceId()), legacyPaymentSessionLink.getContext());
                                                                            } else if (deepLink instanceof PaymentSessionLink) {
                                                                                PaymentSessionLink paymentSessionLink = (PaymentSessionLink) deepLink;
                                                                                return this.a.servicePaymentIntent(paymentSessionLink.getOrderItems(), paymentSessionLink.getContext());
                                                                            } else if (deepLink instanceof PaymentGenericLink) {
                                                                                ActivityIntentFactory activityIntentFactory10 = this.a;
                                                                                PaymentGenericLink paymentGenericLink = (PaymentGenericLink) deepLink;
                                                                                String paymentSessionId = paymentGenericLink.getPaymentSessionId();
                                                                                String methodSignature = paymentGenericLink.getMethodSignature();
                                                                                if (paymentGenericLink.getPaymentToken().length() > 0) {
                                                                                    z = true;
                                                                                }
                                                                                if (z) {
                                                                                    simpleParametersTree = new SimpleParametersTree(d.listOf(new CharParameter("paymentToken", "", true, true, null, null, null, paymentGenericLink.getPaymentToken(), null, null, null, null, null, null, null, 28672, null)), null, 2, null);
                                                                                } else {
                                                                                    simpleParametersTree = new SimpleParametersTree(CollectionsKt__CollectionsKt.emptyList(), null, 2, null);
                                                                                }
                                                                                return activityIntentFactory10.paymentGenericIntent(paymentSessionId, methodSignature, simpleParametersTree);
                                                                            } else if (deepLink instanceof PaymentGenericFormLink) {
                                                                                PaymentGenericFormLink paymentGenericFormLink = (PaymentGenericFormLink) deepLink;
                                                                                return this.a.paymentGenericFormIntent(paymentGenericFormLink.getPaymentSessionId(), paymentGenericFormLink.getMethodSignature());
                                                                            } else if (deepLink instanceof PaymentStatusFormLink) {
                                                                                return this.a.paymentStatusFormIntent(((PaymentStatusFormLink) deepLink).getOrderId());
                                                                            } else {
                                                                                if (deepLink instanceof PaymentStatusLink) {
                                                                                    return this.a.paymentStatusIntent(((PaymentStatusLink) deepLink).getOrderId());
                                                                                }
                                                                                if (deepLink instanceof SBOLPaymentLink) {
                                                                                    return this.a.sbolPaymentIntent(((SBOLPaymentLink) deepLink).getOrderId());
                                                                                }
                                                                                if (deepLink instanceof TopUpFormLink) {
                                                                                    return this.a.topUpFormIntent();
                                                                                }
                                                                                if (deepLink instanceof NotificationCenterLink) {
                                                                                    return this.a.notificationCenterIntent();
                                                                                }
                                                                                if (deepLink instanceof NotificationCenterUnifiedLandingLink) {
                                                                                    return this.a.notificationCenterLandingUnifiedIntent(((NotificationCenterUnifiedLandingLink) deepLink).getId());
                                                                                }
                                                                                if (deepLink instanceof NotificationCenterMainLandingLink) {
                                                                                    return this.a.notificationCenterLandingMainIntent(((NotificationCenterMainLandingLink) deepLink).getId());
                                                                                }
                                                                                if (deepLink instanceof NotificationCenterRecommendsLandingLink) {
                                                                                    return this.a.notificationCenterLandingRecommendsIntent(((NotificationCenterRecommendsLandingLink) deepLink).getId());
                                                                                }
                                                                                if (deepLink instanceof ProfileNotificationsLink) {
                                                                                    return this.a.notificationsSettingsIntent();
                                                                                }
                                                                                if (deepLink instanceof BlockedIpScreenLink) {
                                                                                    return this.a.blockedIpScreenIntent();
                                                                                }
                                                                                if (deepLink instanceof AbuseReportLink) {
                                                                                    return AbuseIntentFactory.DefaultImpls.abuseCategoryIntent$default(this.a, ((AbuseReportLink) deepLink).getItemId(), null, null, 6, null);
                                                                                }
                                                                                if (deepLink instanceof NotificationCenterFeedbackLandingLink) {
                                                                                    return this.a.notificationCenterLandingFeedbackIntent(((NotificationCenterFeedbackLandingLink) deepLink).getId());
                                                                                }
                                                                                if (deepLink instanceof NotificationCenterLandingShareLink) {
                                                                                    return this.a.notificationCenterLandingShareIntent(((NotificationCenterLandingShareLink) deepLink).getId());
                                                                                }
                                                                                if (deepLink instanceof HelpCenterShowLink) {
                                                                                    return this.a.helpCenterIntent(null);
                                                                                }
                                                                                if (deepLink instanceof HelpCenterUrlShowLink) {
                                                                                    return this.a.helpCenterIntent(((HelpCenterUrlShowLink) deepLink).getUrl());
                                                                                }
                                                                                if (deepLink instanceof HelpCenterRequestLink) {
                                                                                    HelpCenterRequestLink helpCenterRequestLink = (HelpCenterRequestLink) deepLink;
                                                                                    return this.a.helpCenterRequestIntent(helpCenterRequestLink.getTheme(), helpCenterRequestLink.getAdvertisementId(), helpCenterRequestLink.getContext());
                                                                                } else if (deepLink instanceof HelpCenterArticleShowLink) {
                                                                                    HelpCenterArticleShowLink helpCenterArticleShowLink = (HelpCenterArticleShowLink) deepLink;
                                                                                    return this.a.helpCenterArticleShowIntent(helpCenterArticleShowLink.getArticleId(), helpCenterArticleShowLink.getTheme(), helpCenterArticleShowLink.getAdvertisementId(), helpCenterArticleShowLink.getContext());
                                                                                } else if (deepLink instanceof SupportChatFormLink) {
                                                                                    if (this.c.getMessengerSupportChatForm().invoke().booleanValue()) {
                                                                                        return this.a.supportChatFormIntent(((SupportChatFormLink) deepLink).getProblemId());
                                                                                    }
                                                                                    return null;
                                                                                } else if (deepLink instanceof DeliveryStartOrderingDeepLink) {
                                                                                    DeliveryStartOrderingDeepLink deliveryStartOrderingDeepLink = (DeliveryStartOrderingDeepLink) deepLink;
                                                                                    return this.a.deliveryRdsStartOrderingIntent(deliveryStartOrderingDeepLink.getItemId(), deliveryStartOrderingDeepLink.getSource(), deliveryStartOrderingDeepLink.getSearchContext(), deliveryStartOrderingDeepLink.isMarketplace(), deliveryStartOrderingDeepLink.isCart(), deliveryStartOrderingDeepLink.getFirstCartItemId(), deliveryStartOrderingDeepLink.getCartItems(), deliveryStartOrderingDeepLink.getContactEvent());
                                                                                } else if (deepLink instanceof DeliverySummaryDeepLink) {
                                                                                    DeliverySummaryDeepLink deliverySummaryDeepLink = (DeliverySummaryDeepLink) deepLink;
                                                                                    return this.a.deliveryRdsSummaryIntent(deliverySummaryDeepLink.getSearchContext(), new SummaryState(null, deliverySummaryDeepLink.getFiasGuid(), deliverySummaryDeepLink.getServiceId(), deliverySummaryDeepLink.getItemId(), null, true, 17, null), deliverySummaryDeepLink.isCart(), deliverySummaryDeepLink.isMarketplace(), deliverySummaryDeepLink.getSource());
                                                                                } else if (deepLink instanceof DeliveryOrderPayLink) {
                                                                                    return this.a.deliveryRdsPayOrderIntent(((DeliveryOrderPayLink) deepLink).getOrderId());
                                                                                } else {
                                                                                    if (deepLink instanceof RestorePasswordLink) {
                                                                                        ActivityIntentFactory activityIntentFactory11 = this.a;
                                                                                        RestorePasswordLink restorePasswordLink = (RestorePasswordLink) deepLink;
                                                                                        String hash = restorePasswordLink.getHash();
                                                                                        String email = restorePasswordLink.getEmail();
                                                                                        if (email != null) {
                                                                                            str = email;
                                                                                        }
                                                                                        return activityIntentFactory11.changePasswordIntent(str, hash, restorePasswordLink.getSource());
                                                                                    } else if (deepLink instanceof AutotekaDetailsLink) {
                                                                                        return this.a.autotekaDetailsIntent(((AutotekaDetailsLink) deepLink).getAdvertId(), null, this.e.convertToQueryParameters((UTMLink) deepLink));
                                                                                    } else {
                                                                                        if (deepLink instanceof HintsLink) {
                                                                                            return this.a.hintsIntent(((HintsLink) deepLink).getHintType());
                                                                                        }
                                                                                        if (deepLink instanceof PaidServicesLink) {
                                                                                            return this.a.paidServicesIntent(deepLink).addFlags(603979776);
                                                                                        }
                                                                                        if (deepLink instanceof LegacyPaidServicesLink) {
                                                                                            LegacyPaidServicesLink legacyPaidServicesLink = (LegacyPaidServicesLink) deepLink;
                                                                                            Intent flags = UserAdvertIntentFactory.DefaultImpls.myAdvertDetailsIntent$default(this.a, legacyPaidServicesLink.getItemId(), null, null, legacyPaidServicesLink.isPostCreation(), 6, null).putExtra(Constants.UP_INTENT, UserAdvertsIntentFactory.DefaultImpls.createUserAdvertsIntent$default(this.a, null, null, false, 7, null)).setFlags(603979776);
                                                                                            Intrinsics.checkNotNullExpressionValue(flags, "activityIntentFactory.my…FLAG_ACTIVITY_SINGLE_TOP)");
                                                                                            return this.a.basketIntent(legacyPaidServicesLink.getItemId(), flags, legacyPaidServicesLink.getShowFees(), legacyPaidServicesLink.getContext(), legacyPaidServicesLink.getVasType(), legacyPaidServicesLink.getFrom());
                                                                                        } else if (deepLink instanceof AppliedServicesLink) {
                                                                                            return this.a.appliedServicesIntent(((AppliedServicesLink) deepLink).getAdvertId());
                                                                                        } else {
                                                                                            if (deepLink instanceof DiscountLink) {
                                                                                                return this.a.vasDiscountIntent(((DiscountLink) deepLink).getContext());
                                                                                            }
                                                                                            if (deepLink instanceof AutotekaBuyReportLink) {
                                                                                                return this.b.autotekaBuyReportCustomChromeTabsIntent(((AutotekaBuyReportLink) deepLink).getAdvertId(), this.e.convertToQueryParameters((UTMLink) deepLink));
                                                                                            }
                                                                                            if (deepLink instanceof SettingsNotificationsLink) {
                                                                                                return this.b.notificationsSettingsIntent();
                                                                                            }
                                                                                            if (deepLink instanceof DeliveryProfileSettingsLink) {
                                                                                                if (this.c.getProfileDeliverySettingsRedesign().invoke().booleanValue()) {
                                                                                                    return this.a.profileRdsDeliverySettingsIntent();
                                                                                                }
                                                                                                return this.a.deliveryProfileSettingsIntent();
                                                                                            } else if (deepLink instanceof IncomeSettingsLink) {
                                                                                                return this.a.incomeSettingsIntent();
                                                                                            } else {
                                                                                                if (deepLink instanceof AutoDealDetailsLink) {
                                                                                                    return this.a.autoDealDetails(((AutoDealDetailsLink) deepLink).getUrl());
                                                                                                }
                                                                                                if (deepLink instanceof StrStartBookingDeepLink) {
                                                                                                    StrStartBookingDeepLink strStartBookingDeepLink = (StrStartBookingDeepLink) deepLink;
                                                                                                    return this.a.shortTermRentStartBookingIntent(strStartBookingDeepLink.getItemId(), strStartBookingDeepLink.getSource(), strStartBookingDeepLink.getCheckInDate(), strStartBookingDeepLink.getCheckOutDate(), strStartBookingDeepLink.getShowCalendar(), strStartBookingDeepLink.getWorkflow());
                                                                                                } else if (deepLink instanceof DeliveryOrderCancelLink) {
                                                                                                    return this.a.deliveryRdsOrderCancellationIntent(((DeliveryOrderCancelLink) deepLink).getOrderId());
                                                                                                } else {
                                                                                                    if (deepLink instanceof StrManageCalendarLink) {
                                                                                                        return this.a.manageCalendarIntent(((StrManageCalendarLink) deepLink).getItemId());
                                                                                                    }
                                                                                                    if (deepLink instanceof DetailsSheetLink) {
                                                                                                        return DetailsSheetIntentFactory.DefaultImpls.detailsSheetIntent$default(this.a, ((DetailsSheetLink) deepLink).getBody(), null, 2, null);
                                                                                                    }
                                                                                                    if (deepLink instanceof PasswordChangeLink) {
                                                                                                        PasswordChangeLink passwordChangeLink = (PasswordChangeLink) deepLink;
                                                                                                        Intent createPasswordChangeIntent = this.a.createPasswordChangeIntent(passwordChangeLink);
                                                                                                        String source = passwordChangeLink.getSource();
                                                                                                        if (source == null) {
                                                                                                            return createPasswordChangeIntent;
                                                                                                        }
                                                                                                        createPasswordChangeIntent.putExtra(Constants.UP_INTENT, this.a.sessionsListIntent(source));
                                                                                                        return createPasswordChangeIntent;
                                                                                                    } else if (deepLink instanceof PasswordSettingLink) {
                                                                                                        return this.a.createPasswordSettingIntent();
                                                                                                    } else {
                                                                                                        if (deepLink instanceof SocialsListLink) {
                                                                                                            return this.a.socialManagementIntent().putExtra(Constants.UP_INTENT, this.a.profilePreviewIntent());
                                                                                                        } else if (deepLink instanceof UserSubscribersLink) {
                                                                                                            return this.a.userSubscribersActivityIntent();
                                                                                                        } else {
                                                                                                            if (deepLink instanceof JobAssistantPickLocationLink) {
                                                                                                                return PublishIntentFactory.DefaultImpls.locationPickerIntent$default(this.a, null, null, null, null, PublishIntentFactory.LocationPickerChooseButtonLocation.FOOTER, null, new PublishIntentFactory.JobAssistantParams(((JobAssistantPickLocationLink) deepLink).getChannelId()), null, 175, null);
                                                                                                            } else if (deepLink instanceof JobSeekerCreateSurveyLink) {
                                                                                                                return this.a.getJobSeekerSurveyIntent(((JobSeekerCreateSurveyLink) deepLink).getJobApplyId());
                                                                                                            } else {
                                                                                                                if (deepLink instanceof JobInterviewInvitationFormLink) {
                                                                                                                    return this.a.getInterviewInvitationIntent(((JobInterviewInvitationFormLink) deepLink).getJobApplyId());
                                                                                                                }
                                                                                                                if (deepLink instanceof SafeDealOrderTypesDeepLink) {
                                                                                                                    SafeDealOrderTypesDeepLink safeDealOrderTypesDeepLink = (SafeDealOrderTypesDeepLink) deepLink;
                                                                                                                    return this.a.deliveryTypeIntent(safeDealOrderTypesDeepLink.getItemId(), safeDealOrderTypesDeepLink.isMarketplace(), safeDealOrderTypesDeepLink.getSearchContext(), safeDealOrderTypesDeepLink.getStyle(), safeDealOrderTypesDeepLink.getContactEvent());
                                                                                                                } else if (deepLink instanceof DeliveryCourierOrderUpdateLink) {
                                                                                                                    DeliveryCourierOrderUpdateLink deliveryCourierOrderUpdateLink = (DeliveryCourierOrderUpdateLink) deepLink;
                                                                                                                    return this.a.deliveryCourierOrderUpdate(deliveryCourierOrderUpdateLink.getOrderId(), deliveryCourierOrderUpdateLink.getSource());
                                                                                                                } else if (deepLink instanceof DeliveryCourierLocationSelectLink) {
                                                                                                                    return PublishIntentFactory.DefaultImpls.locationPickerIntent$default(this.a, null, null, null, null, PublishIntentFactory.LocationPickerChooseButtonLocation.FOOTER, null, null, null, 239, null);
                                                                                                                } else {
                                                                                                                    if (deepLink instanceof DeliveryCourierTimeIntervalSelectLink) {
                                                                                                                        DeliveryCourierTimeIntervalSelectLink deliveryCourierTimeIntervalSelectLink = (DeliveryCourierTimeIntervalSelectLink) deepLink;
                                                                                                                        return this.a.deliveryCourierDateRangeSelect(deliveryCourierTimeIntervalSelectLink.getOrderId(), deliveryCourierTimeIntervalSelectLink.getSource());
                                                                                                                    } else if (deepLink instanceof DeliveryCourierOrderCreateDeeplink) {
                                                                                                                        DeliveryCourierOrderCreateDeeplink deliveryCourierOrderCreateDeeplink = (DeliveryCourierOrderCreateDeeplink) deepLink;
                                                                                                                        return this.a.deliveryCourierSummary(deliveryCourierOrderCreateDeeplink.getItemId(), deliveryCourierOrderCreateDeeplink.getSource(), deliveryCourierOrderCreateDeeplink.getSearchContext());
                                                                                                                    } else if (deepLink instanceof SessionsListLink) {
                                                                                                                        return this.a.sessionsListIntent(((SessionsListLink) deepLink).getSource());
                                                                                                                    } else {
                                                                                                                        if (deepLink instanceof SessionsSocialLogoutLink) {
                                                                                                                            SessionsSocialLogoutLink sessionsSocialLogoutLink = (SessionsSocialLogoutLink) deepLink;
                                                                                                                            return this.a.sessionsSocialLogoutIntent(sessionsSocialLogoutLink.getSource(), sessionsSocialLogoutLink.getUserId(), sessionsSocialLogoutLink.getLoginType(), sessionsSocialLogoutLink.getSessionIdHash(), sessionsSocialLogoutLink.getDeviceId()).putExtra(Constants.UP_INTENT, this.a.sessionsListIntent(sessionsSocialLogoutLink.getSource()));
                                                                                                                        } else if (deepLink instanceof DialogDeepLink) {
                                                                                                                            return this.a.createDialogIntent((DialogDeepLink) deepLink);
                                                                                                                        } else {
                                                                                                                            if (deepLink instanceof PhoneRequestLink) {
                                                                                                                                PhoneRequestLink phoneRequestLink = (PhoneRequestLink) deepLink;
                                                                                                                                String itemId = phoneRequestLink.getItemId();
                                                                                                                                int i = 0;
                                                                                                                                while (true) {
                                                                                                                                    if (i >= itemId.length()) {
                                                                                                                                        z = true;
                                                                                                                                        break;
                                                                                                                                    } else if (!Character.isDigit(itemId.charAt(i))) {
                                                                                                                                        break;
                                                                                                                                    } else {
                                                                                                                                        i++;
                                                                                                                                    }
                                                                                                                                }
                                                                                                                                if (z) {
                                                                                                                                    advert = new PhoneRequestDeepLinkAnalyticsData.Advert(phoneRequestLink.getItemId());
                                                                                                                                }
                                                                                                                                return this.a.createPhoneRequestIntent(phoneRequestLink, advert);
                                                                                                                            } else if (deepLink instanceof CarBookingOrderLink) {
                                                                                                                                return this.a.createBookingOrderIntent(((CarBookingOrderLink) deepLink).getItemId());
                                                                                                                            } else {
                                                                                                                                if (deepLink instanceof CarBookingInfoLink) {
                                                                                                                                    CarBookingInfoLink carBookingInfoLink = (CarBookingInfoLink) deepLink;
                                                                                                                                    return this.a.bookingInfoIntent(carBookingInfoLink.getItemId(), carBookingInfoLink.getFromBlock());
                                                                                                                                } else if (deepLink instanceof ToastMessageLink) {
                                                                                                                                    return this.a.toastMessageIntent(((ToastMessageLink) deepLink).getMessage());
                                                                                                                                } else {
                                                                                                                                    if (deepLink instanceof OrdersLink) {
                                                                                                                                        OrdersLink ordersLink = (OrdersLink) deepLink;
                                                                                                                                        return this.a.ordersIntent(ordersLink.getTab(), ordersLink.getOrdersToPrefetch());
                                                                                                                                    } else if (deepLink instanceof OrderLink) {
                                                                                                                                        return this.a.orderIntent(((OrderLink) deepLink).getOrderId());
                                                                                                                                    } else {
                                                                                                                                        if (deepLink instanceof BrandspaceLink) {
                                                                                                                                            BrandspaceLink brandspaceLink = (BrandspaceLink) deepLink;
                                                                                                                                            return BrandspaceIntentFactory.DefaultImpls.brandspaceIntent$default(this.a, brandspaceLink.getId(), null, brandspaceLink.getSource(), null, 10, null);
                                                                                                                                        } else if (deepLink instanceof PassportVerificationLink) {
                                                                                                                                            PassportVerificationLink passportVerificationLink = (PassportVerificationLink) deepLink;
                                                                                                                                            return this.a.passportVerificationIntent(passportVerificationLink.getContent().getBaseUrl(), passportVerificationLink.getContent().getFlowName());
                                                                                                                                        } else if (deepLink instanceof CartLink) {
                                                                                                                                            return this.a.cartSummaryIntent();
                                                                                                                                        } else {
                                                                                                                                            if (deepLink instanceof RealtyRequestFormLink) {
                                                                                                                                                return AdvertDetailsIntentFactory.DefaultImpls.consultationForm$default(this.a, null, null, ((RealtyRequestFormLink) deepLink).getForm(), 2, null);
                                                                                                                                            }
                                                                                                                                            if (deepLink instanceof UserStatsLink) {
                                                                                                                                                return this.a.userStatsIntent();
                                                                                                                                            }
                                                                                                                                            if (deepLink instanceof DeepLinkContainer) {
                                                                                                                                                return this.a.containerDeeplinkIntent((DeepLinkContainer) deepLink);
                                                                                                                                            }
                                                                                                                                            if (deepLink instanceof ClickStreamLink) {
                                                                                                                                                return this.a.clickStreamIntentIntent((ClickStreamLink) deepLink);
                                                                                                                                            }
                                                                                                                                            if (deepLink instanceof VerificationsListLink) {
                                                                                                                                                return this.a.verificationsList();
                                                                                                                                            }
                                                                                                                                            if (deepLink instanceof VerificationStatusLink) {
                                                                                                                                                return this.a.verificationStatus(((VerificationStatusLink) deepLink).getType());
                                                                                                                                            }
                                                                                                                                            if (deepLink instanceof VerificationRemoveLink) {
                                                                                                                                                return this.a.verificationAction(VerificationIntentFactory.VerificationAction.REMOVE, ((VerificationRemoveLink) deepLink).getType());
                                                                                                                                            }
                                                                                                                                            return null;
                                                                                                                                        }
                                                                                                                                    }
                                                                                                                                }
                                                                                                                            }
                                                                                                                        }
                                                                                                                    }
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
