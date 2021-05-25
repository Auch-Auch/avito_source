package com.avito.android.advert.di;

import android.app.Activity;
import android.app.Application;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.GridLayoutManager;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.FavoriteSellersRepository;
import com.avito.android.Features;
import com.avito.android.IdProvider;
import com.avito.android.IdProviderImpl_Factory;
import com.avito.android.ab_tests.configs.AntiFraudCheckListTestGroup;
import com.avito.android.ab_tests.configs.OrangeAdBadgeTestGroup;
import com.avito.android.ab_tests.configs.PriceOnTopTestGroup;
import com.avito.android.ab_tests.configs.SerpItemsPrefetchTestGroup;
import com.avito.android.ab_tests.configs.SravniWebTestGroup;
import com.avito.android.ab_tests.configs.TinkoffCreditCalculatorTestGroup;
import com.avito.android.ab_tests.groups.AdvertAutotekaTeaserInGalleryTestGroup;
import com.avito.android.ab_tests.groups.AdvertDetailsIcebreakerStyleTestGroup;
import com.avito.android.ab_tests.groups.AdvertDetailsMarketplaceBadgeBarItemTestGroup;
import com.avito.android.ab_tests.groups.AdvertDetailsMarketplaceImprovingContentItemsTestGroup;
import com.avito.android.ab_tests.groups.AdvertDetailsMarketplaceNoPurchaseFeedbackTestGroup;
import com.avito.android.ab_tests.groups.AdvertDetailsNoCallFeedbackTestGroup;
import com.avito.android.ab_tests.groups.AdvertDetailsPriceSubscriptionTestGroup;
import com.avito.android.ab_tests.groups.SendEmployersPhoneOnCallToSellerButtonClickInResumesTestGroup;
import com.avito.android.ab_tests.groups.SimpleTestGroup;
import com.avito.android.ab_tests.groups.SimpleTestGroupWithControl2;
import com.avito.android.ab_tests.groups.SimpleTestGroupWithNone;
import com.avito.android.ab_tests.groups.SimpleTestGroupWithNoneControl2;
import com.avito.android.ab_tests.models.AbTestGroup;
import com.avito.android.ab_tests.models.ExposedAbTestGroup;
import com.avito.android.ab_tests.models.ManuallyExposedAbTestGroup;
import com.avito.android.ab_tests.models.SingleManuallyExposedAbTestGroup;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.advert.AdvertDetailsInteractor;
import com.avito.android.advert.AdvertDetailsInteractorImpl;
import com.avito.android.advert.AdvertDetailsInteractorImpl_Factory;
import com.avito.android.advert.AdvertDetailsResourcesProvider;
import com.avito.android.advert.AdvertDetailsResourcesProviderImpl;
import com.avito.android.advert.AdvertDetailsResourcesProviderImpl_Factory;
import com.avito.android.advert.AdvertDetailsToolbarPresenter;
import com.avito.android.advert.AdvertDetailsToolbarPresenterImpl;
import com.avito.android.advert.AdvertDetailsToolbarPresenterImpl_Factory;
import com.avito.android.advert.di.AdvertFragmentComponent;
import com.avito.android.advert.favorites.AdvertDetailsFavoriteInteractor;
import com.avito.android.advert.favorites.AdvertDetailsFavoriteInteractorImpl;
import com.avito.android.advert.favorites.AdvertDetailsFavoriteInteractorImpl_Factory;
import com.avito.android.advert.item.AdvertDetailsFastOpenParams;
import com.avito.android.advert.item.AdvertDetailsFragment;
import com.avito.android.advert.item.AdvertDetailsFragmentDelegate;
import com.avito.android.advert.item.AdvertDetailsFragment_MembersInjector;
import com.avito.android.advert.item.AdvertDetailsItemsPresenter;
import com.avito.android.advert.item.AdvertDetailsItemsPresenterImpl;
import com.avito.android.advert.item.AdvertDetailsItemsPresenterImpl_Factory;
import com.avito.android.advert.item.AdvertDetailsPresenter;
import com.avito.android.advert.item.AdvertDetailsPresenterImpl;
import com.avito.android.advert.item.AdvertDetailsPresenterImpl_Factory;
import com.avito.android.advert.item.abuse.AdvertDetailsAbuseBlueprint;
import com.avito.android.advert.item.abuse.AdvertDetailsAbuseBlueprint_Factory;
import com.avito.android.advert.item.abuse.AdvertDetailsAbusePresenter;
import com.avito.android.advert.item.abuse.AdvertDetailsAbusePresenterImpl;
import com.avito.android.advert.item.abuse.AdvertDetailsAbusePresenterImpl_Factory;
import com.avito.android.advert.item.additionalSeller.AdditionalSellerBlueprint;
import com.avito.android.advert.item.additionalSeller.AdditionalSellerBlueprint_Factory;
import com.avito.android.advert.item.additionalSeller.AdditionalSellerPresenter;
import com.avito.android.advert.item.additionalSeller.AdditionalSellerPresenterImpl_Factory;
import com.avito.android.advert.item.address.AdvertDetailsAddressBlueprint;
import com.avito.android.advert.item.address.AdvertDetailsAddressBlueprint_Factory;
import com.avito.android.advert.item.address.AdvertDetailsAddressPresenter;
import com.avito.android.advert.item.address.AdvertDetailsAddressPresenterImpl_Factory;
import com.avito.android.advert.item.advert_badge_bar.AdvertBadgeBarBlueprint;
import com.avito.android.advert.item.advert_badge_bar.AdvertBadgeBarBlueprint_Factory;
import com.avito.android.advert.item.advertnumber.AdvertDetailsAdvertNumberBlueprint;
import com.avito.android.advert.item.advertnumber.AdvertDetailsAdvertNumberBlueprint_Factory;
import com.avito.android.advert.item.advertnumber.AdvertDetailsAdvertNumberPresenter;
import com.avito.android.advert.item.advertnumber.AdvertDetailsAdvertNumberPresenterImpl_Factory;
import com.avito.android.advert.item.anonymousnumber.AdvertDetailsAnonymousNumberBlueprint;
import com.avito.android.advert.item.anonymousnumber.AdvertDetailsAnonymousNumberBlueprint_Factory;
import com.avito.android.advert.item.anonymousnumber.AdvertDetailsAnonymousNumberPresenter;
import com.avito.android.advert.item.anonymousnumber.AdvertDetailsAnonymousNumberPresenterImpl_Factory;
import com.avito.android.advert.item.auto_catalog.AdvertDetailsAutoCatalogBlueprint;
import com.avito.android.advert.item.auto_catalog.AdvertDetailsAutoCatalogBlueprint_Factory;
import com.avito.android.advert.item.auto_catalog.AdvertDetailsAutoCatalogPresenter;
import com.avito.android.advert.item.auto_catalog.AdvertDetailsAutoCatalogPresenterImpl;
import com.avito.android.advert.item.auto_catalog.AdvertDetailsAutoCatalogPresenterImpl_Factory;
import com.avito.android.advert.item.autodeal.AdvertDetailsAutodealBlueprint;
import com.avito.android.advert.item.autodeal.AdvertDetailsAutodealBlueprint_Factory;
import com.avito.android.advert.item.autodeal.AdvertDetailsAutodealPresenter;
import com.avito.android.advert.item.autodeal.AdvertDetailsAutodealPresenterImpl;
import com.avito.android.advert.item.autodeal.AdvertDetailsAutodealPresenterImpl_Factory;
import com.avito.android.advert.item.autoteka.AdvertDetailsAutotekaBlueprint;
import com.avito.android.advert.item.autoteka.AdvertDetailsAutotekaBlueprint_Factory;
import com.avito.android.advert.item.autoteka.AdvertDetailsAutotekaPresenter;
import com.avito.android.advert.item.autoteka.AdvertDetailsAutotekaPresenterImpl;
import com.avito.android.advert.item.autoteka.AdvertDetailsAutotekaPresenterImpl_Factory;
import com.avito.android.advert.item.autoteka.teaser.AdvertDetailsAutotekaTeaserBlueprint;
import com.avito.android.advert.item.autoteka.teaser.AdvertDetailsAutotekaTeaserBlueprint_Factory;
import com.avito.android.advert.item.autoteka.teaser.AdvertDetailsAutotekaTeaserPresenter;
import com.avito.android.advert.item.autoteka.teaser.AdvertDetailsAutotekaTeaserPresenterImpl;
import com.avito.android.advert.item.autoteka.teaser.AdvertDetailsAutotekaTeaserPresenterImpl_Factory;
import com.avito.android.advert.item.booking.AdvertBookingBlueprint;
import com.avito.android.advert.item.booking.AdvertBookingBlueprint_Factory;
import com.avito.android.advert.item.booking.AdvertBookingPresenter;
import com.avito.android.advert.item.booking.AdvertBookingPresenterImpl_Factory;
import com.avito.android.advert.item.car_market_price.badge.AdvertDetailsImvBadgeBlueprint;
import com.avito.android.advert.item.car_market_price.badge.AdvertDetailsImvBadgeBlueprint_Factory;
import com.avito.android.advert.item.car_market_price.price_chart.CarMarketPriceChartBlueprint;
import com.avito.android.advert.item.car_market_price.price_chart.CarMarketPriceChartBlueprint_Factory;
import com.avito.android.advert.item.car_market_price.price_description.CarMarketPriceDescriptionBlueprint;
import com.avito.android.advert.item.car_market_price.price_description.CarMarketPriceDescriptionBlueprint_Factory;
import com.avito.android.advert.item.carousel_photogallery.CarouselPhotoGalleryBlueprint;
import com.avito.android.advert.item.carousel_photogallery.CarouselPhotoGalleryBlueprint_Factory;
import com.avito.android.advert.item.carousel_photogallery.CarouselPhotoGalleryPresenter;
import com.avito.android.advert.item.carousel_photogallery.CarouselPhotoGalleryPresenterImpl;
import com.avito.android.advert.item.carousel_photogallery.CarouselPhotoGalleryPresenterImpl_Factory;
import com.avito.android.advert.item.commercials.AdvertCommercialsConverter;
import com.avito.android.advert.item.commercials.AdvertCommercialsConverterImpl;
import com.avito.android.advert.item.commercials.AdvertCommercialsConverterImpl_Factory;
import com.avito.android.advert.item.consultation.AdvertDetailsConsultationBlueprint;
import com.avito.android.advert.item.consultation.AdvertDetailsConsultationBlueprint_Factory;
import com.avito.android.advert.item.consultation.AdvertDetailsConsultationPresenter;
import com.avito.android.advert.item.consultation.AdvertDetailsConsultationPresenterImpl_Factory;
import com.avito.android.advert.item.contactbar.AdvertDetailsContactBarBlueprint;
import com.avito.android.advert.item.contactbar.AdvertDetailsContactBarBlueprint_Factory;
import com.avito.android.advert.item.contactbar.AdvertDetailsContactBarPresenter;
import com.avito.android.advert.item.contactbar.AdvertDetailsContactBarPresenterImpl;
import com.avito.android.advert.item.contactbar.AdvertDetailsContactBarPresenterImpl_Factory;
import com.avito.android.advert.item.cre_geo_report.AdvertDetailsGeoReportTeaserBlueprint;
import com.avito.android.advert.item.cre_geo_report.AdvertDetailsGeoReportTeaserBlueprint_Factory;
import com.avito.android.advert.item.cre_geo_report.AdvertDetailsGeoReportTeaserPresenter;
import com.avito.android.advert.item.cre_geo_report.AdvertDetailsGeoReportTeaserPresenterImp;
import com.avito.android.advert.item.cre_geo_report.AdvertDetailsGeoReportTeaserPresenterImp_Factory;
import com.avito.android.advert.item.delivery.AdvertDeliveryPresenter;
import com.avito.android.advert.item.delivery.AdvertDeliveryPresenterImpl;
import com.avito.android.advert.item.delivery.AdvertDeliveryPresenterImpl_Factory;
import com.avito.android.advert.item.delivery.AdvertDeliveryStorage;
import com.avito.android.advert.item.delivery.AdvertDetailsDeliveryActionsBlueprint;
import com.avito.android.advert.item.delivery.AdvertDetailsDeliveryActionsBlueprint_Factory;
import com.avito.android.advert.item.delivery.AdvertDetailsDeliveryActionsPresenter;
import com.avito.android.advert.item.delivery.AdvertDetailsDeliveryActionsPresenterImpl;
import com.avito.android.advert.item.delivery.AdvertDetailsDeliveryActionsPresenterImpl_Factory;
import com.avito.android.advert.item.delivery.AdvertDetailsDeliveryInfoBlueprint;
import com.avito.android.advert.item.delivery.AdvertDetailsDeliveryInfoBlueprint_Factory;
import com.avito.android.advert.item.delivery.AdvertDetailsDeliveryInfoPresenter;
import com.avito.android.advert.item.delivery.AdvertDetailsDeliveryInfoPresenterImpl;
import com.avito.android.advert.item.delivery.AdvertDetailsDeliveryInfoPresenterImpl_Factory;
import com.avito.android.advert.item.description.AdvertDetailsDescriptionBlueprint;
import com.avito.android.advert.item.description.AdvertDetailsDescriptionBlueprint_Factory;
import com.avito.android.advert.item.description.AdvertDetailsDescriptionPresenter;
import com.avito.android.advert.item.description.AdvertDetailsDescriptionPresenterImpl_Factory;
import com.avito.android.advert.item.description.di.AdvertDetailsHtmlDescriptionModule_ProvideHtmlRenderOptionsFactory;
import com.avito.android.advert.item.dfpcreditinfo.AdvertDetailsCreditInfoBlueprint;
import com.avito.android.advert.item.dfpcreditinfo.AdvertDetailsCreditInfoBlueprint_Factory;
import com.avito.android.advert.item.dfpcreditinfo.AdvertDetailsCreditInfoPresenter;
import com.avito.android.advert.item.dfpcreditinfo.AdvertDetailsCreditInfoPresenterImpl;
import com.avito.android.advert.item.dfpcreditinfo.AdvertDetailsCreditInfoPresenterImpl_Factory;
import com.avito.android.advert.item.dfpcreditinfo.AdvertDetailsCreditStorage;
import com.avito.android.advert.item.dfpcreditinfo.AdvertDetailsCreditStorageImpl;
import com.avito.android.advert.item.dfpcreditinfo.AdvertDetailsCreditStorageImpl_Factory;
import com.avito.android.advert.item.dfpcreditinfo.CreditBannerFilter;
import com.avito.android.advert.item.dfpcreditinfo.CreditBannerFilter_Factory;
import com.avito.android.advert.item.dfpcreditinfo.CreditInfoResourcesProvider;
import com.avito.android.advert.item.dfpcreditinfo.CreditInfoResourcesProviderImpl;
import com.avito.android.advert.item.dfpcreditinfo.CreditInfoResourcesProviderImpl_Factory;
import com.avito.android.advert.item.dfpcreditinfo.DfpCreditBannerLoader;
import com.avito.android.advert.item.dfpcreditinfo.DfpCreditBannerLoaderImpl;
import com.avito.android.advert.item.dfpcreditinfo.DfpCreditBannerLoaderImpl_Factory;
import com.avito.android.advert.item.dfpcreditinfo.DfpCreditViewModelFactory;
import com.avito.android.advert.item.dfpcreditinfo.DfpCreditViewModelFactoryImpl;
import com.avito.android.advert.item.dfpcreditinfo.DfpCreditViewModelFactoryImpl_Factory;
import com.avito.android.advert.item.dfpcreditinfo.broker_link.CreditBrokerLinkBlueprint;
import com.avito.android.advert.item.dfpcreditinfo.broker_link.CreditBrokerLinkBlueprint_Factory;
import com.avito.android.advert.item.dfpcreditinfo.broker_link.CreditBrokerLinkPresenter;
import com.avito.android.advert.item.dfpcreditinfo.broker_link.CreditBrokerLinkPresenterImpl;
import com.avito.android.advert.item.dfpcreditinfo.broker_link.CreditBrokerLinkPresenterImpl_Factory;
import com.avito.android.advert.item.disclaimer.AdvertDetailsDisclaimerBlueprint;
import com.avito.android.advert.item.disclaimer.AdvertDetailsDisclaimerBlueprint_Factory;
import com.avito.android.advert.item.disclaimer.AdvertDetailsDisclaimerPresenter;
import com.avito.android.advert.item.disclaimer.AdvertDetailsDisclaimerPresenterImpl_Factory;
import com.avito.android.advert.item.divider.AdvertDetailsDividerBlueprint;
import com.avito.android.advert.item.divider.AdvertDetailsDividerBlueprint_Factory;
import com.avito.android.advert.item.divider.AdvertDetailsDividerPresenter;
import com.avito.android.advert.item.divider.AdvertDetailsDividerPresenterImpl_Factory;
import com.avito.android.advert.item.domoteka.DomotekaTeaserInteractor;
import com.avito.android.advert.item.domoteka.DomotekaTeaserInteractorImpl;
import com.avito.android.advert.item.domoteka.DomotekaTeaserInteractorImpl_Factory;
import com.avito.android.advert.item.domoteka.conveyor.AdvertDetailsDomotekaTeaserBlueprint;
import com.avito.android.advert.item.domoteka.conveyor.AdvertDetailsDomotekaTeaserBlueprint_Factory;
import com.avito.android.advert.item.domoteka.conveyor.AdvertDetailsDomotekaTeaserPresenter;
import com.avito.android.advert.item.domoteka.conveyor.AdvertDetailsDomotekaTeaserPresenterImpl;
import com.avito.android.advert.item.domoteka.conveyor.AdvertDetailsDomotekaTeaserPresenterImpl_Factory;
import com.avito.android.advert.item.features_teaser.AdvertDetailsFeatureTeaserResourceProvider;
import com.avito.android.advert.item.features_teaser.AdvertDetailsFeatureTeaserResourceProvider_Factory;
import com.avito.android.advert.item.features_teaser.di.PromoCardModule_GetBlueprintFactory;
import com.avito.android.advert.item.features_teaser.di.PromoCardModule_GetPresenter$advert_details_releaseFactory;
import com.avito.android.advert.item.features_teaser.items.AdvertDetailsFeatureTeaserBlueprint;
import com.avito.android.advert.item.features_teaser.items.AdvertDetailsFeatureTeaserBlueprint_Factory;
import com.avito.android.advert.item.features_teaser.items.AdvertDetailsFeatureTeaserPresenter;
import com.avito.android.advert.item.features_teaser.items.AdvertDetailsFeatureTeaserPresenter_Factory;
import com.avito.android.advert.item.flats.AdvertDetailsFlatsBlueprint;
import com.avito.android.advert.item.flats.AdvertDetailsFlatsBlueprint_Factory;
import com.avito.android.advert.item.flats.AdvertDetailsFlatsPresenter;
import com.avito.android.advert.item.flats.AdvertDetailsFlatsPresenterImpl_Factory;
import com.avito.android.advert.item.georeference.AdvertDetailsGeoReferenceBlueprint;
import com.avito.android.advert.item.georeference.AdvertDetailsGeoReferenceBlueprint_Factory;
import com.avito.android.advert.item.georeference.AdvertDetailsGeoReferencePresenter;
import com.avito.android.advert.item.georeference.AdvertDetailsGeoReferencePresenterImpl_Factory;
import com.avito.android.advert.item.groups.AdvertDetailsGroupsBlueprint;
import com.avito.android.advert.item.groups.AdvertDetailsGroupsBlueprint_Factory;
import com.avito.android.advert.item.groups.AdvertDetailsGroupsPresenter;
import com.avito.android.advert.item.groups.AdvertDetailsGroupsPresenterImpl_Factory;
import com.avito.android.advert.item.guide.AdvertDetailsGuideBlueprint;
import com.avito.android.advert.item.guide.AdvertDetailsGuideBlueprint_Factory;
import com.avito.android.advert.item.guide.AdvertDetailsGuidePresenter;
import com.avito.android.advert.item.guide.AdvertDetailsGuidePresenterImpl;
import com.avito.android.advert.item.guide.AdvertDetailsGuidePresenterImpl_Factory;
import com.avito.android.advert.item.guide.di.AdvertDetailsGuideModule_ProvideItemBinderFactory;
import com.avito.android.advert.item.guide.di.AdvertDetailsGuideModule_ProvideSectionsAdapterFactory;
import com.avito.android.advert.item.guide.di.AdvertDetailsGuideModule_ProvideSectionsAdapterPresenterFactory;
import com.avito.android.advert.item.guide.section.GuideSectionItemBlueprint;
import com.avito.android.advert.item.guide.section.GuideSectionItemBlueprint_Factory;
import com.avito.android.advert.item.guide.section.GuideSectionItemPresenter;
import com.avito.android.advert.item.guide.section.GuideSectionItemPresenterImpl;
import com.avito.android.advert.item.guide.section.GuideSectionItemPresenterImpl_Factory;
import com.avito.android.advert.item.header.AdvertDetailsHeaderBlueprint;
import com.avito.android.advert.item.header.AdvertDetailsHeaderBlueprint_Factory;
import com.avito.android.advert.item.header.AdvertDetailsHeaderPresenter;
import com.avito.android.advert.item.header.AdvertDetailsHeaderPresenterImpl_Factory;
import com.avito.android.advert.item.icebreakers.AdvertDetailsIceBreakersBlueprint;
import com.avito.android.advert.item.icebreakers.AdvertDetailsIceBreakersBlueprint_Factory;
import com.avito.android.advert.item.icebreakers.AdvertDetailsIceBreakersPresenter;
import com.avito.android.advert.item.icebreakers.AdvertDetailsIceBreakersPresenterImpl;
import com.avito.android.advert.item.icebreakers.AdvertDetailsIceBreakersPresenterImpl_Factory;
import com.avito.android.advert.item.maketplace_badge_bar.MarketplaceBadgeBarBlueprint;
import com.avito.android.advert.item.maketplace_badge_bar.MarketplaceBadgeBarBlueprint_Factory;
import com.avito.android.advert.item.maketplace_badge_bar.MarketplaceBadgeBarPresenter;
import com.avito.android.advert.item.maketplace_badge_bar.MarketplaceBadgeBarPresenterImpl_Factory;
import com.avito.android.advert.item.marketplace_brief_specs.MarketplaceBriefSpecsBlueprint;
import com.avito.android.advert.item.marketplace_brief_specs.MarketplaceBriefSpecsBlueprint_Factory;
import com.avito.android.advert.item.marketplace_brief_specs.MarketplaceBriefSpecsPresenter;
import com.avito.android.advert.item.marketplace_brief_specs.MarketplaceBriefSpecsPresenterImpl;
import com.avito.android.advert.item.marketplace_brief_specs.MarketplaceBriefSpecsPresenterImpl_Factory;
import com.avito.android.advert.item.marketplace_contactbar.MarketplaceContactBarBlueprint;
import com.avito.android.advert.item.marketplace_contactbar.MarketplaceContactBarBlueprint_Factory;
import com.avito.android.advert.item.marketplace_contactbar.MarketplaceContactBarPresenter;
import com.avito.android.advert.item.marketplace_contactbar.MarketplaceContactBarPresenterImpl;
import com.avito.android.advert.item.marketplace_contactbar.MarketplaceContactBarPresenterImpl_Factory;
import com.avito.android.advert.item.marketplace_delivery.MarketplaceDeliveryBlueprint;
import com.avito.android.advert.item.marketplace_delivery.MarketplaceDeliveryBlueprint_Factory;
import com.avito.android.advert.item.marketplace_delivery.MarketplaceDeliveryPresenter;
import com.avito.android.advert.item.marketplace_delivery.MarketplaceDeliveryPresenterImpl;
import com.avito.android.advert.item.marketplace_delivery.MarketplaceDeliveryPresenterImpl_Factory;
import com.avito.android.advert.item.marketplace_delivery.MarketplaceDeliveryStorage;
import com.avito.android.advert.item.marketplace_delivery.MarketplaceDeliveryStorageImpl;
import com.avito.android.advert.item.marketplace_delivery.MarketplaceDeliveryStorageImpl_Factory;
import com.avito.android.advert.item.marketplace_faq.MarketplaceFaqBlueprint;
import com.avito.android.advert.item.marketplace_faq.MarketplaceFaqBlueprint_Factory;
import com.avito.android.advert.item.marketplace_faq.MarketplaceFaqPresenter;
import com.avito.android.advert.item.marketplace_faq.MarketplaceFaqPresenterImpl;
import com.avito.android.advert.item.marketplace_faq.MarketplaceFaqPresenterImpl_Factory;
import com.avito.android.advert.item.marketplace_info.MarketplaceInfoBlueprint;
import com.avito.android.advert.item.marketplace_info.MarketplaceInfoBlueprint_Factory;
import com.avito.android.advert.item.marketplace_info.MarketplaceInfoPresenter;
import com.avito.android.advert.item.marketplace_info.MarketplaceInfoPresenterImpl;
import com.avito.android.advert.item.marketplace_info.MarketplaceInfoPresenterImpl_Factory;
import com.avito.android.advert.item.marketplace_quantity.MarketplaceQuantityBlueprint;
import com.avito.android.advert.item.marketplace_quantity.MarketplaceQuantityBlueprint_Factory;
import com.avito.android.advert.item.marketplace_quantity.MarketplaceQuantityPresenter;
import com.avito.android.advert.item.marketplace_quantity.MarketplaceQuantityPresenterImpl_Factory;
import com.avito.android.advert.item.marketplace_specs.MarketplaceSpecsBlueprint;
import com.avito.android.advert.item.marketplace_specs.MarketplaceSpecsBlueprint_Factory;
import com.avito.android.advert.item.marketplace_specs.MarketplaceSpecsPresenter;
import com.avito.android.advert.item.marketplace_specs.MarketplaceSpecsPresenterImpl;
import com.avito.android.advert.item.marketplace_specs.MarketplaceSpecsPresenterImpl_Factory;
import com.avito.android.advert.item.note.AdvertDetailsNoteBlueprint;
import com.avito.android.advert.item.note.AdvertDetailsNoteBlueprint_Factory;
import com.avito.android.advert.item.note.AdvertDetailsNotePresenter;
import com.avito.android.advert.item.note.AdvertDetailsNotePresenterImpl;
import com.avito.android.advert.item.note.AdvertDetailsNotePresenterImpl_Factory;
import com.avito.android.advert.item.photogallery.AdvertDetailsGalleryBlueprint;
import com.avito.android.advert.item.photogallery.AdvertDetailsGalleryBlueprint_Factory;
import com.avito.android.advert.item.photogallery.AdvertDetailsGalleryPresenter;
import com.avito.android.advert.item.photogallery.AdvertDetailsGalleryPresenterImpl;
import com.avito.android.advert.item.photogallery.AdvertDetailsGalleryPresenterImpl_Factory;
import com.avito.android.advert.item.price.AdvertDetailsPriceBlueprint;
import com.avito.android.advert.item.price.AdvertDetailsPriceBlueprint_Factory;
import com.avito.android.advert.item.price.AdvertDetailsPricePresenter;
import com.avito.android.advert.item.price.AdvertDetailsPricePresenterImpl_Factory;
import com.avito.android.advert.item.price_discount.PriceWithDiscountBlueprint;
import com.avito.android.advert.item.price_discount.PriceWithDiscountBlueprint_Factory;
import com.avito.android.advert.item.price_discount.PriceWithDiscountPresenter;
import com.avito.android.advert.item.price_discount.PriceWithDiscountPresenterImpl;
import com.avito.android.advert.item.price_discount.PriceWithDiscountPresenterImpl_Factory;
import com.avito.android.advert.item.price_marketplace.AdvertDetailsPriceMarketplaceBlueprint;
import com.avito.android.advert.item.price_marketplace.AdvertDetailsPriceMarketplaceBlueprint_Factory;
import com.avito.android.advert.item.price_marketplace.AdvertDetailsPriceMarketplacePresenter;
import com.avito.android.advert.item.price_marketplace.AdvertDetailsPriceMarketplacePresenterImpl_Factory;
import com.avito.android.advert.item.price_subscription.AdvertDetailsPriceSubscriptionBlueprint;
import com.avito.android.advert.item.price_subscription.AdvertDetailsPriceSubscriptionBlueprint_Factory;
import com.avito.android.advert.item.price_subscription.AdvertDetailsPriceSubscriptionPresenter;
import com.avito.android.advert.item.price_subscription.AdvertDetailsPriceSubscriptionPresenterImpl_Factory;
import com.avito.android.advert.item.questionnaire.QuestionnairePresenter;
import com.avito.android.advert.item.questionnaire.QuestionnairePresenterImpl;
import com.avito.android.advert.item.questionnaire.QuestionnairePresenterImpl_Factory;
import com.avito.android.advert.item.questionnaire.QuestionnaireStorage;
import com.avito.android.advert.item.questionnaire.QuestionnaireStorageImpl;
import com.avito.android.advert.item.questionnaire.QuestionnaireStorageImpl_Factory;
import com.avito.android.advert.item.rating_publish.AdvertDetailsRatingPublishBlueprint;
import com.avito.android.advert.item.rating_publish.AdvertDetailsRatingPublishBlueprint_Factory;
import com.avito.android.advert.item.rating_publish.AdvertDetailsRatingPublishPresenter;
import com.avito.android.advert.item.rating_publish.AdvertDetailsRatingPublishPresenterImpl_Factory;
import com.avito.android.advert.item.safe_show.SafeShowAdvertDetailsDialogFactory;
import com.avito.android.advert.item.safe_show.SafeShowAdvertDetailsDialogFactory_Factory;
import com.avito.android.advert.item.safe_show.SafeShowItemBlueprint;
import com.avito.android.advert.item.safe_show.SafeShowItemBlueprint_Factory;
import com.avito.android.advert.item.safe_show.SafeShowItemPresenter;
import com.avito.android.advert.item.safe_show.SafeShowItemPresenterImpl;
import com.avito.android.advert.item.safe_show.SafeShowItemPresenterImpl_Factory;
import com.avito.android.advert.item.safedeal.AdvertSafeDealPresenter;
import com.avito.android.advert.item.safedeal.AdvertSafeDealPresenterImpl;
import com.avito.android.advert.item.safedeal.AdvertSafeDealPresenterImpl_Factory;
import com.avito.android.advert.item.safedeal.button.AdvertDetailsSafeDealButtonBlueprint;
import com.avito.android.advert.item.safedeal.button.AdvertDetailsSafeDealButtonBlueprint_Factory;
import com.avito.android.advert.item.safedeal.button.AdvertDetailsSafeDealButtonPresenter;
import com.avito.android.advert.item.safedeal.button.AdvertDetailsSafeDealButtonPresenterImpl;
import com.avito.android.advert.item.safedeal.button.AdvertDetailsSafeDealButtonPresenterImpl_Factory;
import com.avito.android.advert.item.safedeal.button.legacy.AdvertDetailsSafeDealLegacyButtonBlueprint;
import com.avito.android.advert.item.safedeal.button.legacy.AdvertDetailsSafeDealLegacyButtonBlueprint_Factory;
import com.avito.android.advert.item.safedeal.button.legacy.AdvertDetailsSafeDealLegacyButtonPresenter;
import com.avito.android.advert.item.safedeal.button.legacy.AdvertDetailsSafeDealLegacyButtonPresenterImpl;
import com.avito.android.advert.item.safedeal.button.legacy.AdvertDetailsSafeDealLegacyButtonPresenterImpl_Factory;
import com.avito.android.advert.item.safedeal.info.AdvertDetailsSafeDealInfoBlueprint;
import com.avito.android.advert.item.safedeal.info.AdvertDetailsSafeDealInfoBlueprint_Factory;
import com.avito.android.advert.item.safedeal.info.AdvertDetailsSafeDealInfoPresenter;
import com.avito.android.advert.item.safedeal.info.AdvertDetailsSafeDealInfoPresenterImpl;
import com.avito.android.advert.item.safedeal.info.AdvertDetailsSafeDealInfoPresenterImpl_Factory;
import com.avito.android.advert.item.safedeal.label.AdvertDetailsSafeDealLabelBlueprint;
import com.avito.android.advert.item.safedeal.label.AdvertDetailsSafeDealLabelBlueprint_Factory;
import com.avito.android.advert.item.safedeal.label.AdvertDetailsSafeDealLabelPresenter;
import com.avito.android.advert.item.safedeal.label.AdvertDetailsSafeDealLabelPresenterImpl;
import com.avito.android.advert.item.safedeal.label.AdvertDetailsSafeDealLabelPresenterImpl_Factory;
import com.avito.android.advert.item.safedeal.services.AdvertDetailsSafeDealServicesBlueprint;
import com.avito.android.advert.item.safedeal.services.AdvertDetailsSafeDealServicesBlueprint_Factory;
import com.avito.android.advert.item.safedeal.services.AdvertDetailsSafeDealServicesPresenter;
import com.avito.android.advert.item.safedeal.services.AdvertDetailsSafeDealServicesPresenterImpl;
import com.avito.android.advert.item.safedeal.services.AdvertDetailsSafeDealServicesPresenterImpl_Factory;
import com.avito.android.advert.item.safedeal.trust_factors.AdvertDetailsSafeDealTrustFactorsBlueprint;
import com.avito.android.advert.item.safedeal.trust_factors.AdvertDetailsSafeDealTrustFactorsBlueprint_Factory;
import com.avito.android.advert.item.safedeal.trust_factors.AdvertDetailsSafeDealTrustFactorsPresenter;
import com.avito.android.advert.item.safedeal.trust_factors.AdvertDetailsSafeDealTrustFactorsPresenterImpl;
import com.avito.android.advert.item.safedeal.trust_factors.AdvertDetailsSafeDealTrustFactorsPresenterImpl_Factory;
import com.avito.android.advert.item.sellerprofile.AdvertDetailsSellerProfileBlueprint;
import com.avito.android.advert.item.sellerprofile.AdvertDetailsSellerProfileBlueprint_Factory;
import com.avito.android.advert.item.sellerprofile.AdvertDetailsSellerProfilePresenter;
import com.avito.android.advert.item.sellerprofile.AdvertDetailsSellerProfilePresenterImpl;
import com.avito.android.advert.item.sellerprofile.AdvertDetailsSellerProfilePresenterImpl_Factory;
import com.avito.android.advert.item.sellerprofile.AdvertSellerPresenter;
import com.avito.android.advert.item.sellerprofile.AdvertSellerProfilePresenter;
import com.avito.android.advert.item.sellerprofile.AdvertSellerProfilePresenterImpl;
import com.avito.android.advert.item.sellerprofile.AdvertSellerProfilePresenterImpl_Factory;
import com.avito.android.advert.item.sellerprofile.AdvertSellerStatusInteractor;
import com.avito.android.advert.item.sellerprofile.AdvertSellerStatusInteractorImpl;
import com.avito.android.advert.item.sellerprofile.AdvertSellerStatusInteractorImpl_Factory;
import com.avito.android.advert.item.sellerprofile.SellerStatusProvider;
import com.avito.android.advert.item.sellerprofile.SellerStatusProviderImpl;
import com.avito.android.advert.item.sellerprofile.SellerStatusProviderImpl_Factory;
import com.avito.android.advert.item.sellersubscription.AdvertDetailsSellerSubscriptionBlueprint;
import com.avito.android.advert.item.sellersubscription.AdvertDetailsSellerSubscriptionBlueprint_Factory;
import com.avito.android.advert.item.sellersubscription.AdvertDetailsSellerSubscriptionPresenter;
import com.avito.android.advert.item.sellersubscription.AdvertDetailsSellerSubscriptionPresenterImpl;
import com.avito.android.advert.item.sellersubscription.AdvertDetailsSellerSubscriptionPresenterImpl_Factory;
import com.avito.android.advert.item.sellersubscription.SellerSubscriptionInteractor;
import com.avito.android.advert.item.sellersubscription.SellerSubscriptionInteractorImpl;
import com.avito.android.advert.item.sellersubscription.SellerSubscriptionInteractorImpl_Factory;
import com.avito.android.advert.item.sellersubscription.SellerSubscriptionPresenter;
import com.avito.android.advert.item.sellersubscription.SellerSubscriptionPresenterImpl;
import com.avito.android.advert.item.sellersubscription.SellerSubscriptionPresenterImpl_Factory;
import com.avito.android.advert.item.sellersubscription.SellerSubscriptionResourceProvider;
import com.avito.android.advert.item.sellersubscription.SellerSubscriptionResourceProviderImpl;
import com.avito.android.advert.item.sellersubscription.SellerSubscriptionResourceProviderImpl_Factory;
import com.avito.android.advert.item.sellersubscription.action.SellerSubscriptionAction;
import com.avito.android.advert.item.sellersubscription.di.AdvertDetailsSellerSubscriptionModule_ProvideRelayFactory;
import com.avito.android.advert.item.shorttermrent.AdvertDetailsShortTermRentBlueprint;
import com.avito.android.advert.item.shorttermrent.AdvertDetailsShortTermRentBlueprint_Factory;
import com.avito.android.advert.item.shorttermrent.AdvertDetailsShortTermRentPresenter;
import com.avito.android.advert.item.shorttermrent.AdvertDetailsShortTermRentPresenterImpl;
import com.avito.android.advert.item.shorttermrent.AdvertDetailsShortTermRentPresenterImpl_Factory;
import com.avito.android.advert.item.show_description_button.AdvertDetailsShowDescriptionBlueprint;
import com.avito.android.advert.item.show_description_button.AdvertDetailsShowDescriptionBlueprint_Factory;
import com.avito.android.advert.item.show_description_button.AdvertDetailsShowDescriptionPresenter;
import com.avito.android.advert.item.show_description_button.AdvertDetailsShowDescriptionPresenterImpl;
import com.avito.android.advert.item.show_description_button.AdvertDetailsShowDescriptionPresenterImpl_Factory;
import com.avito.android.advert.item.show_on_map.AdvertDetailsShowOnMapBlueprint;
import com.avito.android.advert.item.show_on_map.AdvertDetailsShowOnMapBlueprint_Factory;
import com.avito.android.advert.item.show_on_map.AdvertDetailsShowOnMapPresenter;
import com.avito.android.advert.item.show_on_map.AdvertDetailsShowOnMapPresenterImpl_Factory;
import com.avito.android.advert.item.similars.AdvertComplementaryPresenter;
import com.avito.android.advert.item.similars.AdvertComplementaryPresenterImpl;
import com.avito.android.advert.item.similars.AdvertComplementaryPresenterImpl_Factory;
import com.avito.android.advert.item.similars.AdvertSimilarPresenterResourceProvider;
import com.avito.android.advert.item.similars.AdvertSimilarPresenterResourceProviderImpl;
import com.avito.android.advert.item.similars.AdvertSimilarPresenterResourceProviderImpl_Factory;
import com.avito.android.advert.item.similars.SimilarsLoaderItemBlueprint;
import com.avito.android.advert.item.similars.SimilarsLoaderItemBlueprint_Factory;
import com.avito.android.advert.item.similars.SimilarsLoaderItemPresenter;
import com.avito.android.advert.item.similars.SimilarsLoaderItemPresenterImpl_Factory;
import com.avito.android.advert.item.similars_button.AdvertDetailsSimilarsButtonBlueprint;
import com.avito.android.advert.item.similars_button.AdvertDetailsSimilarsButtonBlueprint_Factory;
import com.avito.android.advert.item.similars_button.AdvertDetailsSimilarsButtonPresenter;
import com.avito.android.advert.item.similars_button.AdvertDetailsSimilarsButtonPresenterImpl;
import com.avito.android.advert.item.similars_button.AdvertDetailsSimilarsButtonPresenterImpl_Factory;
import com.avito.android.advert.item.skeleton.AdvertDetailsSkeletonBlueprint;
import com.avito.android.advert.item.skeleton.AdvertDetailsSkeletonBlueprint_Factory;
import com.avito.android.advert.item.skeleton.AdvertDetailsSkeletonPresenter;
import com.avito.android.advert.item.skeleton.AdvertDetailsSkeletonPresenterImpl_Factory;
import com.avito.android.advert.item.skeleton.AdvertDetailsTitleSkeletonBlueprint;
import com.avito.android.advert.item.skeleton.AdvertDetailsTitleSkeletonBlueprint_Factory;
import com.avito.android.advert.item.spare_parts.SparePartsCompatibilitiesBlueprint;
import com.avito.android.advert.item.spare_parts.SparePartsCompatibilitiesBlueprint_Factory;
import com.avito.android.advert.item.spare_parts.SparePartsInteractor;
import com.avito.android.advert.item.spare_parts.SparePartsInteractorImpl;
import com.avito.android.advert.item.spare_parts.SparePartsInteractorImpl_Factory;
import com.avito.android.advert.item.spare_parts.SparePartsPresenter;
import com.avito.android.advert.item.spare_parts.SparePartsReplacementsBlueprint;
import com.avito.android.advert.item.spare_parts.SparePartsReplacementsBlueprint_Factory;
import com.avito.android.advert.item.spare_parts.di.SparePartsModule_ProvideCompatibilitiesPresenterFactory;
import com.avito.android.advert.item.spare_parts.di.SparePartsModule_ProvideReplacementsPresenterFactory;
import com.avito.android.advert.item.status_badge.AdvertDetailsClosingReasonBlueprint;
import com.avito.android.advert.item.status_badge.AdvertDetailsClosingReasonBlueprint_Factory;
import com.avito.android.advert.item.status_badge.AdvertDetailsClosingReasonPresenter;
import com.avito.android.advert.item.status_badge.AdvertDetailsClosingReasonPresenterImpl_Factory;
import com.avito.android.advert.item.title.AdvertDetailsTitleBlueprint;
import com.avito.android.advert.item.title.AdvertDetailsTitleBlueprint_Factory;
import com.avito.android.advert.item.title.AdvertDetailsTitlePresenter;
import com.avito.android.advert.item.title.AdvertDetailsTitlePresenterImpl_Factory;
import com.avito.android.advert.item.verification.AdvertVerificationBlueprint;
import com.avito.android.advert.item.verification.AdvertVerificationBlueprint_Factory;
import com.avito.android.advert.item.verification.AdvertVerificationPresenter;
import com.avito.android.advert.item.verification.AdvertVerificationPresenterImpl;
import com.avito.android.advert.item.verification.AdvertVerificationPresenterImpl_Factory;
import com.avito.android.advert.tracker.AdvertDetailsTracker;
import com.avito.android.advert.tracker.AdvertDetailsTrackerImpl;
import com.avito.android.advert.tracker.AdvertDetailsTrackerImpl_Factory;
import com.avito.android.advert.viewed.ViewedAdvertsEventInteractor;
import com.avito.android.advert.viewed.ViewedAdvertsInteractor;
import com.avito.android.advert.viewed.ViewedAdvertsInteractorFactoryImpl_Factory;
import com.avito.android.advert.viewed.ViewedAdvertsPresenter;
import com.avito.android.advert.viewed.ViewedAdvertsPresenterImpl;
import com.avito.android.advert.viewed.ViewedAdvertsPresenterImpl_Factory;
import com.avito.android.advert_core.advert.CartInteractor;
import com.avito.android.advert_core.advert.CartInteractorImpl;
import com.avito.android.advert_core.advert.CartInteractorImpl_Factory;
import com.avito.android.advert_core.advert_badge_bar.AdvertBadgeBarPresenter;
import com.avito.android.advert_core.advert_badge_bar.AdvertBadgeBarPresenterImpl;
import com.avito.android.advert_core.advert_badge_bar.AdvertBadgeBarPresenterImpl_Factory;
import com.avito.android.advert_core.aler_banner.AlertBannerBlueprint;
import com.avito.android.advert_core.aler_banner.AlertBannerBlueprint_Factory;
import com.avito.android.advert_core.aler_banner.AlertBannerPresenter;
import com.avito.android.advert_core.aler_banner.AlertBannerPresenterImpl_Factory;
import com.avito.android.advert_core.analytics.AdvertDetailsAnalyticsInteractor;
import com.avito.android.advert_core.analytics.AdvertDetailsAnalyticsInteractorImpl;
import com.avito.android.advert_core.analytics.AdvertDetailsAnalyticsInteractorImpl_Factory;
import com.avito.android.advert_core.analytics.broker.CreditBrokerAnalyticsInteractor;
import com.avito.android.advert_core.analytics.broker.CreditBrokerAnalyticsInteractorImpl;
import com.avito.android.advert_core.analytics.broker.CreditBrokerAnalyticsInteractorImpl_Factory;
import com.avito.android.advert_core.analytics.broker.CreditBrokerSessionProvider;
import com.avito.android.advert_core.analytics.broker.SravniAnalyticsEventLogger;
import com.avito.android.advert_core.analytics.broker.SravniEventTracker;
import com.avito.android.advert_core.analytics.broker.SravniEventTrackerImpl;
import com.avito.android.advert_core.analytics.broker.SravniEventTrackerImpl_Factory;
import com.avito.android.advert_core.analytics.sharing.AdvertSharingEventTracker;
import com.avito.android.advert_core.analytics.sharing.AdvertSharingEventTrackerImpl;
import com.avito.android.advert_core.analytics.sharing.AdvertSharingEventTrackerImpl_Factory;
import com.avito.android.advert_core.car_market_price.badge.AdvertDetailsImvBadgeItemConverter;
import com.avito.android.advert_core.car_market_price.badge.AdvertDetailsImvBadgeItemConverterImpl_Factory;
import com.avito.android.advert_core.car_market_price.badge.AdvertDetailsImvBadgePresenter;
import com.avito.android.advert_core.car_market_price.badge.AdvertDetailsImvBadgePresenterImpl;
import com.avito.android.advert_core.car_market_price.badge.AdvertDetailsImvBadgePresenterImpl_Factory;
import com.avito.android.advert_core.car_market_price.price_chart.CarMarketPriceChartPresenter;
import com.avito.android.advert_core.car_market_price.price_chart.CarMarketPriceChartPresenterImpl;
import com.avito.android.advert_core.car_market_price.price_chart.CarMarketPriceChartPresenterImpl_Factory;
import com.avito.android.advert_core.car_market_price.price_chart.CarMarketPriceChartResourceProvider;
import com.avito.android.advert_core.car_market_price.price_chart.CarMarketPriceChartResourceProviderImpl;
import com.avito.android.advert_core.car_market_price.price_chart.CarMarketPriceChartResourceProviderImpl_Factory;
import com.avito.android.advert_core.car_market_price.price_description.CarMarketPriceDescriptionPresenter;
import com.avito.android.advert_core.car_market_price.price_description.CarMarketPriceDescriptionPresenterImpl;
import com.avito.android.advert_core.car_market_price.price_description.CarMarketPriceDescriptionPresenterImpl_Factory;
import com.avito.android.advert_core.car_market_price.price_description.CarMarketPriceDescriptionResourceProvider;
import com.avito.android.advert_core.car_market_price.price_description.CarMarketPriceDescriptionResourceProviderImpl_Factory;
import com.avito.android.advert_core.car_market_price.price_description.CarMarketPriceSwitchConverter;
import com.avito.android.advert_core.car_market_price.price_description.CarMarketPriceSwitchConverterImpl;
import com.avito.android.advert_core.car_market_price.price_description.CarMarketPriceSwitchConverterImpl_Factory;
import com.avito.android.advert_core.contactbar.AdvertActionIconFactory;
import com.avito.android.advert_core.contactbar.AdvertContactsInteractor;
import com.avito.android.advert_core.contactbar.AdvertContactsInteractorImpl;
import com.avito.android.advert_core.contactbar.AdvertContactsInteractorImpl_Factory;
import com.avito.android.advert_core.contactbar.AdvertContactsPresenter;
import com.avito.android.advert_core.contactbar.AdvertContactsPresenterImpl;
import com.avito.android.advert_core.contactbar.AdvertContactsPresenterImpl_Factory;
import com.avito.android.advert_core.contactbar.AdvertContactsResourceProvider;
import com.avito.android.advert_core.contactbar.AdvertContactsResourceProviderImpl;
import com.avito.android.advert_core.contactbar.AdvertContactsResourceProviderImpl_Factory;
import com.avito.android.advert_core.contactbar.SourceScreen;
import com.avito.android.advert_core.contactbar.anti_fraud.AntiFraudPreferences;
import com.avito.android.advert_core.contactbar.anti_fraud.AntiFraudPreferencesImpl;
import com.avito.android.advert_core.contactbar.anti_fraud.AntiFraudPreferencesImpl_Factory;
import com.avito.android.advert_core.contactbar.feedback.FeedbackInteractor;
import com.avito.android.advert_core.contactbar.feedback.FeedbackInteractorImpl;
import com.avito.android.advert_core.contactbar.feedback.FeedbackInteractorImpl_Factory;
import com.avito.android.advert_core.delivery.AdvertDeliveryBlockRepository;
import com.avito.android.advert_core.delivery.AdvertDeliveryBlockRepositoryImpl;
import com.avito.android.advert_core.delivery.AdvertDeliveryBlockRepositoryImpl_Factory;
import com.avito.android.advert_core.delivery.AdvertDeliveryBlockViewModel;
import com.avito.android.advert_core.delivery.AdvertDeliveryBlockViewModelFactory;
import com.avito.android.advert_core.delivery.AdvertDeliveryBlockViewModelFactory_Factory;
import com.avito.android.advert_core.di.module.AdvertDeliveryBlockModule_ProvideAdvertDeliveryBlockDataObservableFactory;
import com.avito.android.advert_core.di.module.AdvertDeliveryBlockModule_ProvideAdvertDeliveryBlockViewModelFactory;
import com.avito.android.advert_core.discount.AdvertDiscountDetailsDialog;
import com.avito.android.advert_core.discount.AdvertDiscountDetailsDialogImpl;
import com.avito.android.advert_core.discount.AdvertDiscountDetailsDialogImpl_Factory;
import com.avito.android.advert_core.discount.AdvertDiscountDetailsDialogPresenter;
import com.avito.android.advert_core.discount.AdvertDiscountDetailsDialogPresenterImpl;
import com.avito.android.advert_core.discount.AdvertDiscountDetailsDialogPresenterImpl_Factory;
import com.avito.android.advert_core.discount.AdvertDiscountItemConverter;
import com.avito.android.advert_core.discount.AdvertDiscountItemConverterImpl_Factory;
import com.avito.android.advert_core.discount.di.AdvertDiscountDetailsModule_ProvideAdapterFactory;
import com.avito.android.advert_core.discount.di.AdvertDiscountDetailsModule_ProvideAdapterPresenterFactory;
import com.avito.android.advert_core.discount.di.AdvertDiscountDetailsModule_ProvideItemBinderFactory;
import com.avito.android.advert_core.discount.item.contact.ContactItemBlueprint;
import com.avito.android.advert_core.discount.item.contact.ContactItemBlueprint_Factory;
import com.avito.android.advert_core.discount.item.contact.ContactItemPresenter;
import com.avito.android.advert_core.discount.item.contact.ContactItemPresenter_Factory;
import com.avito.android.advert_core.discount.item.discount.DiscountItemBlueprint;
import com.avito.android.advert_core.discount.item.discount.DiscountItemBlueprint_Factory;
import com.avito.android.advert_core.discount.item.discount.DiscountItemPresenter_Factory;
import com.avito.android.advert_core.discount.item.divider.DividerItemBlueprint;
import com.avito.android.advert_core.discount.item.divider.DividerItemBlueprint_Factory;
import com.avito.android.advert_core.discount.item.divider.DividerItemPresenter_Factory;
import com.avito.android.advert_core.discount.item.information.InformationItemBlueprint;
import com.avito.android.advert_core.discount.item.information.InformationItemBlueprint_Factory;
import com.avito.android.advert_core.discount.item.information.InformationItemPresenter_Factory;
import com.avito.android.advert_core.discount.item.title.TitleItemBlueprint;
import com.avito.android.advert_core.discount.item.title.TitleItemBlueprint_Factory;
import com.avito.android.advert_core.discount.item.title.TitleItemPresenter_Factory;
import com.avito.android.advert_core.feature_teasers.common.CommonAdvertDetailsFeatureTeaserItemsAdapter_Factory;
import com.avito.android.advert_core.feature_teasers.common.di.CommonFeatureTeaserModule_ProvideAdapterFactory;
import com.avito.android.advert_core.feature_teasers.common.di.CommonFeatureTeaserModule_ProvideItemBinder$advert_core_releaseFactory;
import com.avito.android.advert_core.feature_teasers.common.dialog.AdvertDetailsFeatureTeaserDialogItemsAdapter;
import com.avito.android.advert_core.feature_teasers.common.dialog.AdvertDetailsFeatureTeaserDialogItemsAdapter_Factory;
import com.avito.android.advert_core.feature_teasers.common.dialog.AdvertDetailsFeatureTeaserDialogTextItemBlueprint;
import com.avito.android.advert_core.feature_teasers.common.dialog.AdvertDetailsFeatureTeaserDialogTextItemBlueprint_Factory;
import com.avito.android.advert_core.feature_teasers.common.dialog.AdvertDetailsFeatureTeaserDialogTextItemPresenter;
import com.avito.android.advert_core.feature_teasers.common.dialog.AdvertDetailsFeatureTeaserDialogTextItemPresenter_Factory;
import com.avito.android.advert_core.feature_teasers.common.dialog.CommonFeatureTeaserDialogFactory;
import com.avito.android.advert_core.feature_teasers.common.dialog.CommonFeatureTeaserDialogFactory_Factory;
import com.avito.android.advert_core.feature_teasers.common.dialog.FeatureTeaserDialogFactory;
import com.avito.android.advert_core.feedback.FeedbackPreferences;
import com.avito.android.advert_core.feedback.FeedbackPreferencesImpl;
import com.avito.android.advert_core.feedback.FeedbackPreferencesImpl_Factory;
import com.avito.android.advert_core.gap.AdvertDetailsGapBlueprint;
import com.avito.android.advert_core.gap.AdvertDetailsGapBlueprint_Factory;
import com.avito.android.advert_core.gap.AdvertDetailsGapPresenter;
import com.avito.android.advert_core.gap.AdvertDetailsGapPresenterImpl_Factory;
import com.avito.android.advert_core.job.AdvertJobInteractor;
import com.avito.android.advert_core.job.AdvertJobInteractorImpl;
import com.avito.android.advert_core.job.AdvertJobInteractorImpl_Factory;
import com.avito.android.advert_core.marketplace.MarketplacePresenter;
import com.avito.android.advert_core.marketplace.MarketplacePresenterImpl;
import com.avito.android.advert_core.marketplace.MarketplacePresenterImpl_Factory;
import com.avito.android.advert_core.marketplace.MarketplaceResourceProvider;
import com.avito.android.advert_core.marketplace.MarketplaceResourceProviderImpl;
import com.avito.android.advert_core.marketplace.MarketplaceResourceProviderImpl_Factory;
import com.avito.android.advert_core.messenger.AdvertMessengerInteractor;
import com.avito.android.advert_core.messenger.AdvertMessengerInteractorImpl;
import com.avito.android.advert_core.messenger.AdvertMessengerInteractorImpl_Factory;
import com.avito.android.advert_core.safedeal.MyAdvertSafeDealResourceProvider;
import com.avito.android.advert_core.safedeal.MyAdvertSafeDealResourceProvider_Factory;
import com.avito.android.advert_core.safedeal.MyAdvertSafeDealServicesInteractor;
import com.avito.android.advert_core.safedeal.MyAdvertSafeDealServicesInteractorImpl;
import com.avito.android.advert_core.safedeal.MyAdvertSafeDealServicesInteractorImpl_Factory;
import com.avito.android.advert_core.safedeal.MyAdvertSafeDealServicesViewModel;
import com.avito.android.advert_core.safedeal.MyAdvertSafedealServicesViewModelFactory;
import com.avito.android.advert_core.safedeal.MyAdvertSafedealServicesViewModelFactory_Factory;
import com.avito.android.advert_core.safedeal.di.MyAdvertSafeDealServicesModule_ProvideMyAdvertSafeDealServicesObservable$advert_core_releaseFactory;
import com.avito.android.advert_core.safedeal.di.MyAdvertSafeDealServicesModule_ProvideMyAdvertSafeDealServicesViewModel$advert_core_releaseFactory;
import com.avito.android.advert_core.teaser.TeaserObserver;
import com.avito.android.advert_details.remote.AdvertDetailsApi;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.FavoriteAdvertsAnalyticsInteractorImpl;
import com.avito.android.analytics.FavoriteAdvertsAnalyticsInteractorImpl_Factory;
import com.avito.android.analytics.NetworkTypeProvider;
import com.avito.android.analytics.event.favorite.SubscriptionSource;
import com.avito.android.analytics.provider.TreeStateIdGenerator;
import com.avito.android.analytics.provider.clickstream.TreeClickStreamParent;
import com.avito.android.analytics.screens.Screen;
import com.avito.android.analytics.screens.TimerFactory;
import com.avito.android.analytics.screens.TrackerInfoProvider;
import com.avito.android.analytics.screens.fps.FpsMetricsSupplier;
import com.avito.android.analytics.screens.fps.FpsMetricsTracker;
import com.avito.android.analytics.screens.fps.FpsStateSupplier;
import com.avito.android.analytics.screens.tracker.ScreenTrackerFactory;
import com.avito.android.autoteka.remote.AutotekaApi;
import com.avito.android.autoteka_details.core.AutotekaDetailsInteractor;
import com.avito.android.autoteka_details.core.AutotekaDetailsInteractorImpl;
import com.avito.android.autoteka_details.core.AutotekaDetailsInteractorImpl_Factory;
import com.avito.android.autoteka_details.core.AutotekaTeaserInteractor;
import com.avito.android.autoteka_details.core.AutotekaTeaserInteractorImpl;
import com.avito.android.autoteka_details.core.AutotekaTeaserInteractorImpl_Factory;
import com.avito.android.brandspace_entry_point.BrandspaceEntryPointAnalyticsInteractor;
import com.avito.android.brandspace_entry_point.di.BrandspaceEntryPointInteractorModule;
import com.avito.android.brandspace_entry_point.di.BrandspaceEntryPointInteractorModule_ProvideBrandspaceEntryPointAnalyticsInteractorFactory;
import com.avito.android.calls.remote.CallsApi;
import com.avito.android.calls_shared.AppCallsUsageTracker;
import com.avito.android.calls_shared.CallUuidProvider;
import com.avito.android.cart_fab.CartFabModule_ProvideCartFabViewModelFactory;
import com.avito.android.cart_fab.CartFabPreferences;
import com.avito.android.cart_fab.CartFabPreferencesImpl;
import com.avito.android.cart_fab.CartFabPreferencesImpl_Factory;
import com.avito.android.cart_fab.CartFabQuantityVisibilityHandler_Factory;
import com.avito.android.cart_fab.CartFabRepository;
import com.avito.android.cart_fab.CartFabRepositoryImpl;
import com.avito.android.cart_fab.CartFabRepositoryImpl_Factory;
import com.avito.android.cart_fab.CartFabViewModel;
import com.avito.android.cart_fab.CartFabViewModelFactory;
import com.avito.android.cart_fab.CartFabViewModelFactory_Factory;
import com.avito.android.cart_fab.CartQuantityChangesHandler;
import com.avito.android.connection_quality.connectivity.ConnectivityProvider;
import com.avito.android.date_time_formatter.DateTimeFormatter;
import com.avito.android.date_time_formatter.DateTimeFormatterResourceProviderImpl;
import com.avito.android.date_time_formatter.DateTimeFormatterResourceProviderImpl_Factory;
import com.avito.android.db.favorites.FavoritesSyncDao;
import com.avito.android.db.viewed.ViewedAdvertsDao;
import com.avito.android.deep_linking.ClickStreamLinkHandler;
import com.avito.android.deep_linking.DeepLinkFactory;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.deep_linking.SimpleClickStreamLinkHandler;
import com.avito.android.deep_linking.SimpleClickStreamLinkHandler_Factory;
import com.avito.android.design.widget.dfp_debug.DfpDebugPresenter;
import com.avito.android.design.widget.dfp_debug.DfpDebugPresenterImpl_Factory;
import com.avito.android.di.DialogRouterModule_ProvideDialogRouterFactory;
import com.avito.android.di.ViewedAdvertsModule_ProvideViewedAdvertsInteractorFactory;
import com.avito.android.di.ViewedAdvertsModule_ProvideViewedAdvertsPresenterFactory;
import com.avito.android.di.ViewedAdvertsModule_ProvideViewedStatusResolverFactory;
import com.avito.android.di.module.AdvertItemModule_ProvideRdsAdvertGridItemBlueprintFactory;
import com.avito.android.di.module.AdvertItemPresenterModule_ProvideRdsAdvertItemPresenterFactory;
import com.avito.android.di.module.AdvertItemPresenterModule_ProvideRdsRecommendationAdvertItemPresenterFactory;
import com.avito.android.di.module.DateTimeFormatterModule_ProvideUpperCaseDateTimeFormatterFactory;
import com.avito.android.di.module.FavoriteAdvertsPresenterModule_ProvideFavoriteAdvertsPresenter$favorite_core_releaseFactory;
import com.avito.android.di.module.FavoriteAdvertsPresenterModule_ProvideFavoriteAdvertsResourceProvider$favorite_core_releaseFactory;
import com.avito.android.di.module.ScreenAnalyticsDependencies;
import com.avito.android.di.module.SerpItemConverterModule_ProvideAdvertConverterFactory;
import com.avito.android.di.module.SerpItemConverterModule_ProvideBigAdvertSpanCountProviderFactory;
import com.avito.android.di.module.SerpItemConverterModule_ProvideFavoriteStatusResolverFactory;
import com.avito.android.di.module.SerpItemConverterModule_ProvideItemAdvertSpanCountProviderFactory;
import com.avito.android.domteka.DomotekaApi;
import com.avito.android.favorite.FavoriteAdvertsEventInteractor;
import com.avito.android.favorite.FavoriteAdvertsInteractorImpl;
import com.avito.android.favorite.FavoriteAdvertsInteractorImpl_Factory;
import com.avito.android.favorite.FavoriteAdvertsPresenter;
import com.avito.android.favorite.FavoriteAdvertsPresenterImpl;
import com.avito.android.favorite.FavoriteAdvertsPresenterImpl_Factory;
import com.avito.android.favorite.FavoriteAdvertsResourceProvider;
import com.avito.android.favorite.FavoriteAdvertsUploadInteractor;
import com.avito.android.favorite_sellers.SellerCarouselItemConverter;
import com.avito.android.favorite_sellers.SellerCarouselItemConverterImpl_Factory;
import com.avito.android.favorite_sellers.action.FavoriteSellersItemAction;
import com.avito.android.favorite_sellers.adapter.recommendation.RecommendationItemPresenter;
import com.avito.android.favorite_sellers.adapter.recommendation.RecommendationItemPresenterImpl;
import com.avito.android.favorite_sellers.adapter.recommendation.RecommendationItemPresenterImpl_Factory;
import com.avito.android.favorite_sellers.adapter.recommendation.adapter.seller_carousel.SellerCarouselItemBlueprint;
import com.avito.android.favorite_sellers.adapter.recommendation.adapter.seller_carousel.SellerCarouselItemBlueprint_Factory;
import com.avito.android.favorite_sellers.adapter.recommendation.adapter.seller_carousel.SellerCarouselItemPresenterImpl;
import com.avito.android.favorite_sellers.adapter.recommendation.adapter.seller_carousel.SellerCarouselItemPresenterImpl_Factory;
import com.avito.android.favorite_sellers.adapter.recommendation.advert_details.AdvertDetailsRecommendationItemBlueprint;
import com.avito.android.favorite_sellers.adapter.recommendation.advert_details.AdvertDetailsRecommendationItemBlueprint_Factory;
import com.avito.android.favorite_sellers.adapter.recommendation.advert_details.di.AdvertDetailsRecommendationItemModule_ProvideAdapterPresenterFactory;
import com.avito.android.favorite_sellers.adapter.recommendation.advert_details.di.AdvertDetailsRecommendationItemModule_ProvideItemBinderFactory;
import com.avito.android.favorites.FavoriteAdvertsSyncEventProvider;
import com.avito.android.html_formatter.HtmlCleaner;
import com.avito.android.html_formatter.HtmlRenderOptions;
import com.avito.android.html_formatter.HtmlRenderer;
import com.avito.android.item_visibility_tracker.ItemVisibilityTracker;
import com.avito.android.item_visibility_tracker.filters.BannerViewFilter;
import com.avito.android.item_visibility_tracker.filters.BannerViewFilter_Factory;
import com.avito.android.job.JobApi;
import com.avito.android.lib.design.snackbar.util.CompositeSnackbarModule_ProvideCompositeSnackbarPresenterFactory;
import com.avito.android.lib.design.snackbar.util.CompositeSnackbarPresenter;
import com.avito.android.module.serp.adapter.ad.adfox.AdfoxImageItemPresenter;
import com.avito.android.module.serp.adapter.ad.adfox.AdfoxImageItemPresenterImpl;
import com.avito.android.module.serp.adapter.ad.adfox.AdfoxImageItemPresenterImpl_Factory;
import com.avito.android.module.serp.adapter.ad.adfox.RdsAdfoxBigBlueprint;
import com.avito.android.module.serp.adapter.ad.adfox.RdsAdfoxBigBlueprint_Factory;
import com.avito.android.module.serp.adapter.ad.dfp.DfpAppInstallPresenter;
import com.avito.android.module.serp.adapter.ad.dfp.DfpAppInstallPresenterImpl;
import com.avito.android.module.serp.adapter.ad.dfp.DfpAppInstallPresenterImpl_Factory;
import com.avito.android.module.serp.adapter.ad.dfp.DfpContentPresenter;
import com.avito.android.module.serp.adapter.ad.dfp.DfpContentPresenterImpl;
import com.avito.android.module.serp.adapter.ad.dfp.DfpContentPresenterImpl_Factory;
import com.avito.android.module.serp.adapter.ad.dfp.DfpUnifiedPresenter;
import com.avito.android.module.serp.adapter.ad.dfp.DfpUnifiedPresenterImpl;
import com.avito.android.module.serp.adapter.ad.dfp.DfpUnifiedPresenterImpl_Factory;
import com.avito.android.module.serp.adapter.ad.dfp.RdsDfpAppInstallBlueprint;
import com.avito.android.module.serp.adapter.ad.dfp.RdsDfpAppInstallBlueprint_Factory;
import com.avito.android.module.serp.adapter.ad.dfp.RdsDfpContentBlueprint;
import com.avito.android.module.serp.adapter.ad.dfp.RdsDfpContentBlueprint_Factory;
import com.avito.android.module.serp.adapter.ad.dfp.RdsDfpUnifiedBlueprint;
import com.avito.android.module.serp.adapter.ad.dfp.RdsDfpUnifiedBlueprint_Factory;
import com.avito.android.module.serp.adapter.ad.mytarget.MyTargetAppInstallPresenter;
import com.avito.android.module.serp.adapter.ad.mytarget.MyTargetAppInstallPresenterImpl;
import com.avito.android.module.serp.adapter.ad.mytarget.MyTargetAppInstallPresenterImpl_Factory;
import com.avito.android.module.serp.adapter.ad.mytarget.MyTargetContentPresenter;
import com.avito.android.module.serp.adapter.ad.mytarget.MyTargetContentPresenterImpl;
import com.avito.android.module.serp.adapter.ad.mytarget.MyTargetContentPresenterImpl_Factory;
import com.avito.android.module.serp.adapter.ad.mytarget.RdsMyTargetAppInstallBlueprint;
import com.avito.android.module.serp.adapter.ad.mytarget.RdsMyTargetAppInstallBlueprint_Factory;
import com.avito.android.module.serp.adapter.ad.mytarget.RdsMyTargetContentBlueprint;
import com.avito.android.module.serp.adapter.ad.mytarget.RdsMyTargetContentBlueprint_Factory;
import com.avito.android.module.serp.adapter.ad.yandex.app_install.RdsYandexAppInstallBigBlueprint;
import com.avito.android.module.serp.adapter.ad.yandex.app_install.RdsYandexAppInstallBigBlueprint_Factory;
import com.avito.android.module.serp.adapter.ad.yandex.app_install.YandexAppInstallItemPresenter;
import com.avito.android.module.serp.adapter.ad.yandex.app_install.YandexAppInstallItemPresenterImpl;
import com.avito.android.module.serp.adapter.ad.yandex.app_install.YandexAppInstallItemPresenterImpl_Factory;
import com.avito.android.module.serp.adapter.ad.yandex.content.RdsYandexContentBigBlueprint;
import com.avito.android.module.serp.adapter.ad.yandex.content.RdsYandexContentBigBlueprint_Factory;
import com.avito.android.module.serp.adapter.ad.yandex.content.YandexContentItemPresenter;
import com.avito.android.module.serp.adapter.ad.yandex.content.YandexContentItemPresenterImpl;
import com.avito.android.module.serp.adapter.ad.yandex.content.YandexContentItemPresenterImpl_Factory;
import com.avito.android.notification_manager_provider.NotificationManagerProvider;
import com.avito.android.permissions.PermissionChecker;
import com.avito.android.profile.ProfileInfoStorage;
import com.avito.android.rec.ScreenSource;
import com.avito.android.recycler.base.DestroyableViewHolderBuilder;
import com.avito.android.recycler.base.SafeRecyclerAdapter;
import com.avito.android.remote.AsyncPhoneApi;
import com.avito.android.remote.DeliveryApi;
import com.avito.android.remote.FavoriteSellersApi;
import com.avito.android.remote.ProfileApi;
import com.avito.android.remote.cart.CartApi;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.remote.model.AdvertDeliveryC2C;
import com.avito.android.remote.model.AdvertPrice;
import com.avito.android.remote.model.AutotekaDetailsResponse;
import com.avito.android.remote.model.MyAdvertSafeDeal;
import com.avito.android.safedeal.remote.SafeDealApi;
import com.avito.android.section.SectionInsideItemsConverter;
import com.avito.android.section.SectionInsideItemsConverterImpl;
import com.avito.android.section.SectionInsideItemsConverterImpl_Factory;
import com.avito.android.section.SectionItemConverter;
import com.avito.android.section.SectionItemConverterImpl;
import com.avito.android.section.SectionItemConverterImpl_Factory;
import com.avito.android.section.SectionItemPresenter;
import com.avito.android.section.SectionItemPresenterImpl;
import com.avito.android.section.SectionItemPresenterImpl_Factory;
import com.avito.android.section.SectionResourceProvider;
import com.avito.android.section.SectionResourceProviderImpl;
import com.avito.android.section.SectionResourceProviderImpl_Factory;
import com.avito.android.section.action.SectionActionPresenter;
import com.avito.android.section.action.SectionActionPresenterImpl_Factory;
import com.avito.android.section.complementary.ComplementaryResourceProviderImpl;
import com.avito.android.section.complementary.ComplementaryResourceProviderImpl_Factory;
import com.avito.android.section.complementary.ComplementarySectionBlueprint;
import com.avito.android.section.complementary.ComplementarySectionBlueprint_Factory;
import com.avito.android.section.complementary.ComplementaryTitleWithActionBlueprint;
import com.avito.android.section.complementary.ComplementaryTitleWithActionBlueprint_Factory;
import com.avito.android.section.di.SectionAdvertItemsModule_ProvideComplementarySectionItemBinder$serp_core_releaseFactory;
import com.avito.android.section.di.SectionAdvertItemsModule_ProvideComplementarySectionItemWidthProvider$serp_core_releaseFactory;
import com.avito.android.section.di.SectionAdvertItemsModule_ProvideComplementaryTypeAdapterPresenter$serp_core_releaseFactory;
import com.avito.android.section.di.SectionAdvertItemsModule_ProvideSectionItemWidthProvider$serp_core_releaseFactory;
import com.avito.android.section.expand_sections_button.ComplementaryExpandSectionsButtonBlueprint;
import com.avito.android.section.expand_sections_button.ComplementaryExpandSectionsButtonBlueprint_Factory;
import com.avito.android.section.expand_sections_button.ExpandSectionsButtonPresenter;
import com.avito.android.section.expand_sections_button.ExpandSectionsButtonPresenterImpl;
import com.avito.android.section.expand_sections_button.ExpandSectionsButtonPresenterImpl_Factory;
import com.avito.android.section.item.ComplementaryAdvertItemBlueprint;
import com.avito.android.section.item.ComplementaryAdvertItemBlueprintImpl;
import com.avito.android.section.item.ComplementaryAdvertItemBlueprintImpl_Factory;
import com.avito.android.section.item.ComplementaryAdvertItemDoubleBlueprint;
import com.avito.android.section.item.ComplementaryAdvertItemDoubleBlueprintImpl;
import com.avito.android.section.item.ComplementaryAdvertItemDoubleBlueprintImpl_Factory;
import com.avito.android.section.item.SectionItemWidthProvider;
import com.avito.android.section.title.SectionTitleItemPresenter;
import com.avito.android.section.title.SectionTitleItemPresenterImpl_Factory;
import com.avito.android.section.title_with_action.SectionTitleWithActionPresenter;
import com.avito.android.section.title_with_action.SectionTitleWithActionPresenterImpl;
import com.avito.android.section.title_with_action.SectionTitleWithActionPresenterImpl_Factory;
import com.avito.android.serp.BannerInfoFactory;
import com.avito.android.serp.BannerInfoFactoryImpl_Factory;
import com.avito.android.serp.CommercialBannerTimeProviderImpl_Factory;
import com.avito.android.serp.CommercialBannersAnalyticsInteractorImpl;
import com.avito.android.serp.CommercialBannersAnalyticsInteractorImpl_Factory;
import com.avito.android.serp.CommercialBannersInteractor;
import com.avito.android.serp.CommercialBannersInteractorImpl;
import com.avito.android.serp.CommercialBannersInteractorImpl_Factory;
import com.avito.android.serp.ad.AdResourceProvider;
import com.avito.android.serp.ad.DfpBannerLoader;
import com.avito.android.serp.ad.DfpBannerLoaderImpl;
import com.avito.android.serp.ad.DfpBannerLoaderImpl_Factory;
import com.avito.android.serp.ad.MyTargetBannerLoader;
import com.avito.android.serp.ad.MyTargetBannerLoaderImpl;
import com.avito.android.serp.ad.MyTargetBannerLoaderImpl_Factory;
import com.avito.android.serp.ad.MyTargetImageBgProvider;
import com.avito.android.serp.ad.RdsAdResourceProviderImpl_Factory;
import com.avito.android.serp.ad.YandexBannerLoader;
import com.avito.android.serp.ad.YandexBannerLoaderImpl;
import com.avito.android.serp.ad.YandexBannerLoaderImpl_Factory;
import com.avito.android.serp.adapter.AdvertSpanCountProvider;
import com.avito.android.serp.adapter.FavoriteStatusResolver;
import com.avito.android.serp.adapter.RdsAdvertGridItemBlueprint;
import com.avito.android.serp.adapter.RdsAdvertItemPresenter;
import com.avito.android.serp.adapter.SerpAdvertConverter;
import com.avito.android.serp.adapter.SerpCommercialBannerConverter;
import com.avito.android.serp.adapter.SerpItemAbViewConfig;
import com.avito.android.serp.adapter.SerpItemAbViewConfig_Factory;
import com.avito.android.serp.adapter.SerpSpanProvider;
import com.avito.android.serp.adapter.SpannedGridPositionProvider;
import com.avito.android.serp.adapter.ViewedStatusResolver;
import com.avito.android.serp.adapter.adstub.EmptyAdStubItemPresenter;
import com.avito.android.serp.adapter.adstub.EmptyAdStubItemPresenterImpl_Factory;
import com.avito.android.serp.adapter.adstub.NotLoadAdStubPresenter_Factory;
import com.avito.android.serp.adapter.adstub.RdsEmptyAdStubItemBlueprint;
import com.avito.android.serp.adapter.adstub.RdsEmptyAdStubItemBlueprint_Factory;
import com.avito.android.serp.adapter.adstub.RdsNotLoadAdStubBlueprint;
import com.avito.android.serp.adapter.adstub.RdsNotLoadAdStubBlueprint_Factory;
import com.avito.android.serp.adapter.promo_card.PromoCardItemPresenter;
import com.avito.android.serp.analytics.BannerPageSource;
import com.avito.android.server_time.TimeSource;
import com.avito.android.spare_parts.SparePartsFormatter;
import com.avito.android.spare_parts.SparePartsFormatterImpl;
import com.avito.android.spare_parts.SparePartsFormatterImpl_Factory;
import com.avito.android.spare_parts.SparePartsResourceProvider;
import com.avito.android.spare_parts.SparePartsResourceProviderImpl;
import com.avito.android.spare_parts.SparePartsResourceProviderImpl_Factory;
import com.avito.android.spare_parts.remote.SparePartsApi;
import com.avito.android.util.AdvertOldPriceFormatter;
import com.avito.android.util.AdvertOldPriceFormatter_Factory;
import com.avito.android.util.AdvertPriceFormatter;
import com.avito.android.util.AdvertPriceFormatter_Factory;
import com.avito.android.util.BuildInfo;
import com.avito.android.util.ClipDataFactoryImpl_Factory;
import com.avito.android.util.DeviceMetrics;
import com.avito.android.util.DialogRouter;
import com.avito.android.util.ErrorFormatter;
import com.avito.android.util.ErrorFormatterImpl;
import com.avito.android.util.ErrorFormatterImpl_Factory;
import com.avito.android.util.Formatter;
import com.avito.android.util.ImplicitIntentFactory;
import com.avito.android.util.Kundle;
import com.avito.android.util.PhoneNumberFormatterModule_ProvidePhoneNumberFormatterWithCountryCodeFactory;
import com.avito.android.util.RandomKeyProvider;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.SearchContextWrapper;
import com.avito.android.util.UUIDRandomKeyProvider_Factory;
import com.avito.android.util.di.ClipboardModule_ProvideClipboardManager$android_releaseFactory;
import com.avito.android.util.preferences.Preferences;
import com.avito.android.util.text.AttributedTextFormatter;
import com.avito.android.util.text.AttributedTextFormatterModule_ProvideAttributedTextFormatterFactory;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.SimpleAdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import com.avito.konveyor.blueprint.ItemBlueprint;
import com.google.common.base.Optional;
import com.jakewharton.rxrelay3.PublishRelay;
import com.jakewharton.rxrelay3.Relay;
import dagger.internal.DelegateFactory;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import dagger.internal.SetFactory;
import dagger.internal.SingleCheck;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Consumer;
import java.util.Locale;
import java.util.Set;
import javax.inject.Provider;
import ru.avito.messenger.api.AvitoMessengerApi;
import ru.sravni.android.bankproduct.network.di.SravniNetworkConfiguration;
public final class DaggerAdvertFragmentComponent implements AdvertFragmentComponent {
    public Provider<AdvertDetailsAnalyticsInteractor> A;
    public Provider<AntiFraudPreferencesImpl> A0;
    public Provider<AdvertSpanCountProvider> A1;
    public Provider<AutotekaApi> A2;
    public Provider<SectionResourceProviderImpl> A3;
    public Provider<AdvertDetailsGalleryBlueprint> A4;
    public Provider<AdvertDetailsSellerSubscriptionBlueprint> A5;
    public Provider<AdvertBadgeBarPresenterImpl> A6;
    public Provider<AdvertDetailsSafeDealLabelPresenterImpl> A7;
    public Provider<AdvertDetailsFeatureTeaserResourceProvider> A8;
    public Provider<CarMarketPriceSwitchConverterImpl> A9;
    public Provider<TreeClickStreamParent> B;
    public Provider<AntiFraudPreferences> B0;
    public Provider<SerpAdvertConverter> B1;
    public Provider<SchedulersFactory> B2;
    public Provider<SectionResourceProvider> B3;
    public Provider<AdvertDetailsPricePresenter> B4;
    public Provider<AdditionalSellerBlueprint> B5;
    public Provider<AdvertBadgeBarPresenter> B6;
    public Provider<AdvertDetailsSafeDealLabelPresenter> B7;
    public Provider<AdvertDetailsFeatureTeaserPresenter> B8;
    public Provider<CarMarketPriceSwitchConverter> B9;
    public Provider<BannerInfoFactory> C;
    public Provider<FeedbackPreferencesImpl> C0;
    public Provider<SectionInsideItemsConverterImpl> C1;
    public Provider<TypedErrorThrowableConverter> C2;
    public Provider<SectionItemWidthProvider> C3;
    public Provider<AdvertDetailsPriceBlueprint> C4;
    public Provider<AdvertDetailsAnonymousNumberPresenter> C5;
    public Provider<AdvertBadgeBarBlueprint> C6;
    public Provider<AdvertDetailsSafeDealLabelBlueprint> C7;
    public Provider<AdvertDetailsFeatureTeaserDialogTextItemPresenter> C8;
    public Provider<CarMarketPriceDescriptionPresenterImpl> C9;
    public Provider<CommercialBannersInteractorImpl> D;
    public Provider<FeedbackPreferences> D0;
    public Provider<SectionInsideItemsConverter> D1;
    public Provider<Kundle> D2;
    public Provider<ComplementaryAdvertItemDoubleBlueprintImpl> D3;
    public Provider<TitleItemBlueprint> D4;
    public Provider<AdvertDetailsAnonymousNumberBlueprint> D5;
    public Provider<ItemBlueprint<?, ?>> D6;
    public Provider<ItemBlueprint<?, ?>> D7;
    public Provider<AdvertDetailsFeatureTeaserDialogTextItemBlueprint> D8;
    public Provider<CarMarketPriceDescriptionPresenter> D9;
    public Provider<CommercialBannersInteractor> E;
    public Provider<SourceScreen> E0;
    public Provider<SellerCarouselItemConverter> E1;
    public Provider<AutotekaDetailsResponse> E2;
    public Provider<ComplementaryAdvertItemDoubleBlueprint> E3;
    public Provider<DiscountItemBlueprint> E4;
    public Provider<AdvertDetailsAdvertNumberPresenter> E5;
    public Provider<CreditInfoResourcesProviderImpl> E6;
    public Provider<AdvertDetailsSafeDealTrustFactorsPresenterImpl> E7;
    public Provider<Set<ItemBlueprint<?, ?>>> E8;
    public Provider<CarMarketPriceDescriptionBlueprint> E9;
    public Provider<Resources> F;
    public Provider<AbTestGroup<SimpleTestGroupWithControl2>> F0;
    public Provider<FavoriteStatusResolver> F1;
    public Provider<AutotekaDetailsInteractorImpl> F2;
    public Provider<ItemBinder> F3;
    public Provider<DividerItemBlueprint> F4;
    public Provider<AdvertDetailsAdvertNumberBlueprint> F5;
    public Provider<CreditInfoResourcesProvider> F6;
    public Provider<AdvertDetailsSafeDealTrustFactorsPresenter> F7;
    public Provider<ItemBinder> F8;
    public Provider<CarMarketPriceChartResourceProviderImpl> F9;
    public Provider<Boolean> G;
    public Provider<SingleManuallyExposedAbTestGroup<AntiFraudCheckListTestGroup>> G0;
    public Provider<ViewedStatusResolver> G1;
    public Provider<AutotekaDetailsInteractor> G2;
    public Provider<AdapterPresenter> G3;
    public Provider<InformationItemBlueprint> G4;
    public Provider<AdvertDetailsAbusePresenterImpl> G5;
    public Provider<SravniNetworkConfiguration> G6;
    public Provider<AdvertDetailsSafeDealTrustFactorsBlueprint> G7;
    public Provider<SimpleAdapterPresenter> G8;
    public Provider<CarMarketPriceChartResourceProvider> G9;
    public Provider<ScreenSource> H;
    public Provider<PermissionChecker> H0;
    public Provider<SectionItemConverterImpl> H1;
    public Provider<AdvertDetailsAutotekaPresenterImpl> H2;
    public Provider<FavoriteAdvertsPresenterImpl> H3;
    public Provider<ContactItemPresenter> H4;
    public Provider<AdvertDetailsAbusePresenter> H5;
    public Provider<SravniAnalyticsEventLogger> H6;
    public Provider<ItemBlueprint<?, ?>> H7;
    public Provider<AdvertDetailsFeatureTeaserDialogItemsAdapter> H8;
    public Provider<CarMarketPriceChartPresenterImpl> H9;
    public Provider<HtmlRenderer> I;
    public Provider<ManuallyExposedAbTestGroup<AdvertDetailsNoCallFeedbackTestGroup>> I0;
    public Provider<SectionItemConverter> I1;
    public Provider<AdvertDetailsAutotekaPresenter> I2;
    public Provider<ViewedAdvertsPresenterImpl> I3;
    public Provider<ContactItemBlueprint> I4;
    public Provider<AdvertDetailsAbuseBlueprint> I5;
    public Provider<SravniEventTrackerImpl> I6;
    public Provider<SafeDealApi> I7;
    public Provider<CommonFeatureTeaserDialogFactory> I8;
    public Provider<CarMarketPriceChartPresenter> I9;
    public Provider<HtmlCleaner> J;
    public Provider<ManuallyExposedAbTestGroup<AdvertDetailsMarketplaceNoPurchaseFeedbackTestGroup>> J0;
    public Provider<AdResourceProvider> J1;
    public Provider<Kundle> J2;
    public Provider<ComplementarySectionBlueprint> J3;
    public Provider<ItemBinder> J4;
    public Provider<AdvertDetailsDeliveryActionsPresenterImpl> J5;
    public Provider<SravniEventTracker> J6;
    public Provider<MyAdvertSafeDealServicesInteractorImpl> J7;
    public Provider<FeatureTeaserDialogFactory> J8;
    public Provider<CarMarketPriceChartBlueprint> J9;
    public Provider<HtmlRenderOptions> K;
    public Provider<ExposedAbTestGroup<SimpleTestGroupWithNone>> K0;
    public Provider<RandomKeyProvider> K1;
    public Provider<AutotekaTeaserInteractorImpl> K2;
    public Provider<SectionActionPresenter> K3;
    public Provider<AdapterPresenter> K4;
    public Provider<AdvertDetailsDeliveryActionsPresenter> K5;
    public Provider<AdvertDetailsCreditInfoPresenterImpl> K6;
    public Provider<MyAdvertSafeDealServicesInteractor> K7;
    public Provider<AdvertDetailsFeatureTeaserBlueprint> K8;
    public Provider<AdvertDetailsHeaderPresenter> K9;
    public Provider<AdvertDetailsInteractorImpl> L;
    public Provider<AbTestGroup<SendEmployersPhoneOnCallToSellerButtonClickInResumesTestGroup>> L0;
    public Provider<SerpCommercialBannerConverter> L1;
    public Provider<AutotekaTeaserInteractor> L2;
    public Provider<SectionTitleWithActionPresenterImpl> L3;
    public Provider<SimpleRecyclerAdapter> L4;
    public Provider<AdvertDetailsDeliveryActionsBlueprint> L5;
    public Provider<AdvertDetailsCreditInfoPresenter> L6;
    public Provider<MyAdvertSafeDealResourceProvider> L7;
    public Provider<MarketplaceSpecsPresenterImpl> L8;
    public Provider<AdvertDetailsHeaderBlueprint> L9;
    public Provider<AdvertDetailsInteractor> M;
    public Provider<ExposedAbTestGroup<SimpleTestGroup>> M0;
    public Provider<AdvertCommercialsConverterImpl> M1;
    public Provider<TeaserObserver> M2;
    public Provider<SectionTitleWithActionPresenter> M3;
    public Provider<AdvertDiscountItemConverter> M4;
    public Provider<DeliveryApi> M5;
    public Provider<AdvertDetailsCreditInfoBlueprint> M6;
    public Provider<Relay<MyAdvertSafeDeal>> M7;
    public Provider<MarketplaceSpecsPresenter> M8;
    public Provider<ItemBinder> M9;
    public Provider<AdvertContactsPresenter> N;
    public Provider<JobApi> N0;
    public Provider<AdvertCommercialsConverter> N1;
    public Provider<ManuallyExposedAbTestGroup<AdvertAutotekaTeaserInGalleryTestGroup>> N2;
    public Provider<ComplementaryTitleWithActionBlueprint> N3;
    public Provider<AdvertDiscountDetailsDialogPresenterImpl> N4;
    public Provider<PublishRelay<AdvertDeliveryC2C>> N5;
    public Provider<ItemBlueprint<?, ?>> N6;
    public Provider<MyAdvertSafedealServicesViewModelFactory> N7;
    public Provider<MarketplaceSpecsBlueprint> N8;
    public Provider<AdapterPresenter> N9;
    public Provider<CartApi> O;
    public Provider<AdvertJobInteractorImpl> O0;
    public Provider<ScreenTrackerFactory> O1;
    public Provider<AdvertDetailsAutotekaTeaserPresenterImpl> O2;
    public Provider<ExpandSectionsButtonPresenterImpl> O3;
    public Provider<AdvertDiscountDetailsDialogPresenter> O4;
    public Provider<AdvertDeliveryBlockRepositoryImpl> O5;
    public Provider<CreditBrokerLinkPresenterImpl> O6;
    public Provider<MyAdvertSafeDealServicesViewModel> O7;
    public Provider<MarketplaceBriefSpecsPresenterImpl> O8;
    public Provider<DestroyableViewHolderBuilder> O9;
    public Provider<CartInteractorImpl> P;
    public Provider<AdvertJobInteractor> P0;
    public Provider<TimerFactory> P1;
    public Provider<AdvertDetailsAutotekaTeaserPresenter> P2;
    public Provider<ExpandSectionsButtonPresenter> P3;
    public Provider<AdvertDiscountDetailsDialogImpl> P4;
    public Provider<AdvertDeliveryBlockRepository> P5;
    public Provider<CreditBrokerLinkPresenter> P6;
    public Provider<AdvertDetailsSafeDealServicesPresenterImpl> P7;
    public Provider<MarketplaceBriefSpecsPresenter> P8;
    public Provider<SafeRecyclerAdapter> P9;
    public Provider<CartInteractor> Q;
    public Provider<AdvertContactsPresenterImpl> Q0;
    public Provider<TrackerInfoProvider> Q1;
    public Provider<AdvertDetailsNotePresenterImpl> Q2;
    public Provider<ComplementaryExpandSectionsButtonBlueprint> Q3;
    public Provider<AdvertDiscountDetailsDialog> Q4;
    public Provider<AdvertDeliveryBlockViewModelFactory> Q5;
    public Provider<CreditBrokerLinkBlueprint> Q6;
    public Provider<AdvertDetailsSafeDealServicesPresenter> Q7;
    public Provider<MarketplaceBriefSpecsBlueprint> Q8;
    public Provider<SpannedGridPositionProvider> Q9;
    public Provider<MarketplaceResourceProviderImpl> R;
    public Provider<SimpleClickStreamLinkHandler> R0;
    public Provider<AdvertDetailsTrackerImpl> R1;
    public Provider<AdvertDetailsNotePresenter> R2;
    public Provider<RdsNotLoadAdStubBlueprint> R3;
    public Provider<PriceWithDiscountPresenterImpl> R4;
    public Provider<ViewModelProvider.Factory> R5;
    public Provider<ItemBlueprint<?, ?>> R6;
    public Provider<AdvertDetailsSafeDealServicesBlueprint> R7;
    public Provider<MarketplaceInfoPresenterImpl> R8;
    public Provider<SerpSpanProvider> R9;
    public Provider<MarketplaceResourceProvider> S;
    public Provider<ClickStreamLinkHandler> S0;
    public Provider<AdvertDetailsTracker> S1;
    public Provider<DeepLinkFactory> S2;
    public Provider<EmptyAdStubItemPresenter> S3;
    public Provider<PriceWithDiscountPresenter> S4;
    public Provider<LifecycleOwner> S5;
    public Provider<DomotekaApi> S6;
    public Provider<ItemBlueprint<?, ?>> S7;
    public Provider<MarketplaceInfoPresenter> S8;
    public Provider<GridLayoutManager.SpanSizeLookup> S9;
    public Provider<ViewModelStoreOwner> T;
    public Provider<AdvertSafeDealPresenterImpl> T0;
    public Provider<AdvertComplementaryPresenterImpl> T1;
    public Provider<AdvertDetailsShortTermRentPresenterImpl> T2;
    public Provider<RdsEmptyAdStubItemBlueprint> T3;
    public Provider<PriceWithDiscountBlueprint> T4;
    public Provider<AdvertDeliveryBlockViewModel> T5;
    public Provider<Kundle> T6;
    public Provider<AdvertVerificationPresenterImpl> T7;
    public Provider<MarketplaceInfoBlueprint> T8;
    public Provider<ViewedAdvertsPresenter> T9;
    public Provider<CartFabRepositoryImpl> U;
    public Provider<AdvertSafeDealPresenter> U0;
    public Provider<AdvertComplementaryPresenter> U1;
    public Provider<AdvertDetailsShortTermRentPresenter> U2;
    public Provider<ExposedAbTestGroup<OrangeAdBadgeTestGroup>> U3;
    public Provider<AdvertDetailsPriceMarketplacePresenter> U4;
    public Provider<AdvertDetailsDeliveryInfoPresenterImpl> U5;
    public Provider<DomotekaTeaserInteractorImpl> U6;
    public Provider<AdvertVerificationPresenter> U7;
    public Provider<MarketplaceDeliveryPresenterImpl> U8;
    public Provider<CreditBrokerSessionProvider> U9;
    public Provider<CartFabRepository> V;
    public Provider<TimeSource> V0;
    public Provider<Integer> V1;
    public Provider<PublishRelay<FavoriteSellersItemAction>> V2;
    public Provider<YandexContentItemPresenterImpl> V3;
    public Provider<AdvertDetailsPriceMarketplaceBlueprint> V4;
    public Provider<AdvertDetailsDeliveryInfoPresenter> V5;
    public Provider<DomotekaTeaserInteractor> V6;
    public Provider<AdvertVerificationBlueprint> V7;
    public Provider<MarketplaceDeliveryPresenter> V8;
    public Provider<SingleManuallyExposedAbTestGroup<TinkoffCreditCalculatorTestGroup>> V9;
    public Provider<Preferences> W;
    public Provider<DateTimeFormatterResourceProviderImpl> W0;
    public Provider<Formatter<AdvertPrice>> W1;
    public Provider<Observable<FavoriteSellersItemAction>> W2;
    public Provider<YandexContentItemPresenter> W3;
    public Provider<AdvertDetailsPriceSubscriptionPresenter> W4;
    public Provider<AdvertDetailsDeliveryInfoBlueprint> W5;
    public Provider<AdvertDetailsDomotekaTeaserPresenterImpl> W6;
    public Provider<ItemBlueprint<?, ?>> W7;
    public Provider<ManuallyExposedAbTestGroup<SimpleTestGroupWithNone>> W8;
    public Provider<DfpCreditBannerLoaderImpl> W9;
    public Provider<CartFabPreferencesImpl> X;
    public Provider<DateTimeFormatter> X0;
    public Provider<AdvertOldPriceFormatter> X1;
    public Provider<AbTestGroup<SimpleTestGroupWithNoneControl2>> X2;
    public Provider<RdsYandexContentBigBlueprint> X3;
    public Provider<AdvertDetailsPriceSubscriptionBlueprint> X4;
    public Provider<AdvertDetailsConsultationPresenter> X5;
    public Provider<AdvertDetailsDomotekaTeaserPresenter> X6;
    public Provider<CarouselPhotoGalleryPresenterImpl> X7;
    public Provider<MarketplaceDeliveryBlueprint> X8;
    public Provider<DfpCreditBannerLoader> X9;
    public Provider<CartFabPreferences> Y;
    public Provider<AdvertDetailsResourcesProviderImpl> Y0;
    public Provider<Formatter<AdvertPrice>> Y1;
    public Provider<Bundle> Y2;
    public Provider<YandexAppInstallItemPresenterImpl> Y3;
    public Provider<SimilarsLoaderItemPresenter> Y4;
    public Provider<AdvertDetailsConsultationBlueprint> Y5;
    public Provider<AdvertDetailsDomotekaTeaserBlueprint> Y6;
    public Provider<CarouselPhotoGalleryPresenter> Y7;
    public Provider<MarketplaceFaqPresenterImpl> Y8;
    public Provider<ProfileApi> Y9;
    public Provider<String> Z;
    public Provider<AdvertDetailsResourcesProvider> Z0;
    public Provider<AttributedTextFormatter> Z1;
    public Provider<QuestionnaireStorageImpl> Z2;
    public Provider<YandexAppInstallItemPresenter> Z3;
    public Provider<SimilarsLoaderItemBlueprint> Z4;
    public Provider<AdvertDetailsShortTermRentBlueprint> Z5;
    public Provider<ItemBlueprint<?, ?>> Z6;
    public Provider<CarouselPhotoGalleryBlueprint> Z7;
    public Provider<MarketplaceFaqPresenter> Z8;
    public Provider<AdvertDetailsCreditStorageImpl> Z9;
    public final AdvertFragmentDependencies a;
    public Provider<SearchContextWrapper> a0;
    public Provider<AdvertSellerProfilePresenterImpl> a1;

    /* renamed from: a2  reason: collision with root package name */
    public Provider<IdProvider> f16a2;
    public Provider<QuestionnaireStorage> a3;
    public Provider<RdsYandexAppInstallBigBlueprint> a4;
    public Provider<RdsAdvertItemPresenter> a5;
    public Provider<AdvertDetailsContactBarPresenterImpl> a6;

    /* renamed from: a7  reason: collision with root package name */
    public Provider<GuideSectionItemPresenterImpl> f17a7;
    public Provider<ItemBlueprint<?, ?>> a8;
    public Provider<MarketplaceFaqBlueprint> a9;
    public Provider<AdvertDetailsCreditStorage> aa;
    public final ScreenAnalyticsDependencies b;
    public Provider<Optional<SearchContextWrapper>> b0;
    public Provider<AdvertSellerProfilePresenter> b1;
    public Provider<FavoriteSellersApi> b2;
    public Provider<QuestionnairePresenterImpl> b3;
    public Provider<AdfoxImageItemPresenterImpl> b4;
    public Provider<RdsAdvertGridItemBlueprint> b5;
    public Provider<AdvertDetailsContactBarPresenter> b6;

    /* renamed from: b7  reason: collision with root package name */
    public Provider<GuideSectionItemPresenter> f18b7;
    public Provider<AdvertDetailsGeoReportTeaserPresenterImp> b8;
    public Provider<MarketplaceBadgeBarPresenter> b9;
    public Provider<SingleManuallyExposedAbTestGroup<SravniWebTestGroup>> ba;
    public final Screen c;
    public Provider<CartFabViewModelFactory> c0;
    public Provider<AdvertSellerPresenter> c1;
    public Provider<FavoriteSellersRepository> c2;
    public Provider<QuestionnairePresenter> c3;
    public Provider<AdfoxImageItemPresenter> c4;
    public Provider<AdvertDetailsDisclaimerPresenter> c5;
    public Provider<AdvertDetailsContactBarBlueprint> c6;
    public Provider<GuideSectionItemBlueprint> c7;
    public Provider<AdvertDetailsGeoReportTeaserPresenter> c8;
    public Provider<MarketplaceBadgeBarBlueprint> c9;
    public Provider<DfpCreditViewModelFactoryImpl> ca;
    public Provider<String> d;
    public Provider<CartFabViewModel> d0;
    public Provider<AdvertSharingEventTrackerImpl> d1;
    public Provider<SellerSubscriptionInteractorImpl> d2;
    public Provider<MarketplaceDeliveryStorageImpl> d3;
    public Provider<RdsAdfoxBigBlueprint> d4;
    public Provider<AdvertDetailsDisclaimerBlueprint> d5;
    public Provider<AdvertDetailsGapPresenter> d6;
    public Provider<ItemBinder> d7;
    public Provider<AdvertDetailsGeoReportTeaserBlueprint> d8;
    public Provider<MarketplaceQuantityPresenter> d9;
    public Provider<DfpCreditViewModelFactory> da;
    public Provider<AdvertDetailsApi> e;
    public Provider<MarketplacePresenterImpl> e0;
    public Provider<AdvertSharingEventTracker> e1;
    public Provider<SellerSubscriptionInteractor> e2;
    public Provider<MarketplaceDeliveryStorage> e3;
    public Provider<DfpDebugPresenter> e4;
    public Provider<AdvertDetailsDescriptionPresenter> e5;
    public Provider<AdvertDetailsGapBlueprint> e6;
    public Provider<AdapterPresenter> e7;
    public Provider<ItemBlueprint<?, ?>> e8;
    public Provider<MarketplaceQuantityBlueprint> e9;
    public Provider<BannerViewFilter> ea;
    public Provider<Context> f;
    public Provider<MarketplacePresenter> f0;
    public Provider<FavoritesSyncDao> f1;
    public Provider<SellerSubscriptionResourceProviderImpl> f2;
    public Provider<AdvertDetailsPresenterImpl> f3;
    public Provider<DfpUnifiedPresenterImpl> f4;
    public Provider<AdvertDetailsDescriptionBlueprint> f5;
    public Provider<AdvertDetailsDividerPresenter> f6;
    public Provider<AdvertDetailsGuidePresenterImpl> f7;
    public Provider<Set<ItemBlueprint<?, ?>>> f8;
    public Provider<MarketplaceContactBarPresenterImpl> f9;
    public Provider<BrandspaceEntryPointAnalyticsInteractor> fa;
    public Provider<Analytics> g;
    public Provider<Application> g0;
    public Provider<FavoriteAdvertsUploadInteractor> g1;
    public Provider<SellerSubscriptionResourceProvider> g2;
    public Provider<AdvertDetailsPresenter> g3;
    public Provider<DfpUnifiedPresenter> g4;
    public Provider<AdvertDetailsAddressPresenter> g5;
    public Provider<AdvertDetailsDividerBlueprint> g6;
    public Provider<AdvertDetailsGuidePresenter> g7;
    public Provider<ErrorFormatter> g8;
    public Provider<MarketplaceContactBarPresenter> g9;
    public Provider<CreditBannerFilter> ga;
    public Provider<BuildInfo> h;
    public Provider<AdvertActionIconFactory> h0;
    public Provider<FavoriteAdvertsEventInteractor> h1;
    public Provider<PublishRelay<SellerSubscriptionAction>> h2;
    public Provider<AdditionalSellerPresenter> h3;
    public Provider<RdsDfpUnifiedBlueprint> h4;
    public Provider<AdvertDetailsAddressBlueprint> h5;
    public Provider<AdvertDetailsGeoReferencePresenter> h6;
    public Provider<SimpleRecyclerAdapter> h7;
    public Provider<SubscriptionSource> h8;
    public Provider<MarketplaceContactBarBlueprint> h9;
    public Provider<Bundle> ha;
    public Provider<Features> i;
    public Provider<ProfileInfoStorage> i0;
    public Provider<FavoriteAdvertsAnalyticsInteractorImpl> i1;
    public Provider<CompositeSnackbarPresenter> i2;
    public Provider<AdvertDeliveryStorage> i3;
    public Provider<DfpContentPresenterImpl> i4;
    public Provider<AdvertDetailsGroupsPresenter> i5;
    public Provider<AdvertDetailsGeoReferenceBlueprint> i6;
    public Provider<AdvertDetailsGuideBlueprint> i7;
    public Provider<Kundle> i8;
    public Provider<AlertBannerPresenter> i9;
    public Provider<ItemVisibilityTracker> ia;
    public Provider<DfpBannerLoaderImpl> j;
    public Provider<AvitoMessengerApi> j0;
    public Provider<FavoriteAdvertsInteractorImpl> j1;
    public Provider<SellerSubscriptionPresenterImpl> j2;
    public Provider<AdvertDeliveryPresenterImpl> j3;
    public Provider<DfpContentPresenter> j4;
    public Provider<AdvertDetailsGroupsBlueprint> j5;
    public Provider<AdvertDetailsSkeletonPresenter> j6;
    public Provider<ItemBlueprint<?, ?>> j7;
    public Provider<RecommendationItemPresenterImpl> j8;
    public Provider<AlertBannerBlueprint> j9;
    public Provider<Activity> ja;
    public Provider<DfpBannerLoader> k;
    public Provider<AdvertMessengerInteractorImpl> k0;
    public Provider<FavoriteAdvertsSyncEventProvider> k1;
    public Provider<SellerSubscriptionPresenter> k2;
    public Provider<AdvertDeliveryPresenter> k3;
    public Provider<RdsDfpContentBlueprint> k4;
    public Provider<AdvertDetailsFlatsPresenter> k5;
    public Provider<AdvertDetailsSkeletonBlueprint> k6;
    public Provider<AdvertDetailsImvBadgePresenterImpl> k7;
    public Provider<RecommendationItemPresenter> k8;
    public Provider<SparePartsApi> k9;
    public Provider<DialogRouter> ka;
    public Provider<SchedulersFactory3> l;
    public Provider<AdvertMessengerInteractor> l0;
    public Provider<AdvertDetailsFavoriteInteractorImpl> l1;
    public Provider<AdvertDetailsFastOpenParams> l2;
    public Provider<SectionTitleItemPresenter> l3;
    public Provider<DfpAppInstallPresenterImpl> l4;
    public Provider<AdvertDetailsFlatsBlueprint> l5;

    /* renamed from: l6  reason: collision with root package name */
    public Provider<AdvertDetailsTitleSkeletonBlueprint> f19l6;
    public Provider<AdvertDetailsImvBadgePresenter> l7;
    public Provider<Consumer<FavoriteSellersItemAction>> l8;
    public Provider<SparePartsInteractorImpl> l9;
    public Provider<CartQuantityChangesHandler> la;
    public Provider<YandexBannerLoaderImpl> m;
    public Provider<AsyncPhoneApi> m0;
    public Provider<AdvertDetailsFavoriteInteractor> m1;
    public Provider<Boolean> m2;
    public Provider<Bundle> m3;
    public Provider<DfpAppInstallPresenter> m4;
    public Provider<AdvertDetailsAutotekaBlueprint> m5;

    /* renamed from: m6  reason: collision with root package name */
    public Provider<AdvertDetailsSimilarsButtonPresenterImpl> f20m6;
    public Provider<AdvertDetailsImvBadgeBlueprint> m7;
    public Provider<SellerCarouselItemPresenterImpl> m8;
    public Provider<SparePartsInteractor> m9;
    public Provider<YandexBannerLoader> n;
    public Provider<CallsApi> n0;
    public Provider<ViewedAdvertsDao> n1;
    public Provider<AdvertDetailsImvBadgeItemConverter> n2;
    public Provider<SectionItemPresenterImpl> n3;
    public Provider<RdsDfpAppInstallBlueprint> n4;
    public Provider<AdvertDetailsAutotekaTeaserBlueprint> n5;

    /* renamed from: n6  reason: collision with root package name */
    public Provider<AdvertDetailsSimilarsButtonPresenter> f21n6;
    public Provider<ItemBlueprint<?, ?>> n7;
    public Provider<SellerCarouselItemBlueprint> n8;
    public Provider<SparePartsResourceProviderImpl> n9;
    public Provider<MyTargetImageBgProvider> o;
    public Provider<NetworkTypeProvider> o0;
    public Provider<ViewedAdvertsEventInteractor> o1;
    public Provider<ManuallyExposedAbTestGroup<AdvertDetailsMarketplaceBadgeBarItemTestGroup>> o2;
    public Provider<SectionItemPresenter> o3;
    public Provider<MyTargetContentPresenterImpl> o4;
    public Provider<AdvertDetailsAutodealPresenterImpl> o5;

    /* renamed from: o6  reason: collision with root package name */
    public Provider<AdvertDetailsSimilarsButtonBlueprint> f22o6;
    public Provider<AdvertDetailsSafeDealLegacyButtonPresenterImpl> o7;
    public Provider<Set<ItemBlueprint<?, ?>>> o8;
    public Provider<SparePartsResourceProvider> o9;
    public Provider<MyTargetBannerLoaderImpl> p;
    public Provider<CallUuidProvider> p0;
    public Provider<ViewedAdvertsInteractor> p1;
    public Provider<ExposedAbTestGroup<AdvertDetailsMarketplaceImprovingContentItemsTestGroup>> p2;
    public Provider<RdsAdvertItemPresenter> p3;
    public Provider<MyTargetContentPresenter> p4;
    public Provider<AdvertDetailsAutodealPresenter> p5;

    /* renamed from: p6  reason: collision with root package name */
    public Provider<AdvertDetailsClosingReasonPresenter> f23p6;
    public Provider<AdvertDetailsSafeDealLegacyButtonPresenter> p7;
    public Provider<ItemBinder> p8;
    public Provider<SparePartsFormatterImpl> p9;
    public Provider<MyTargetBannerLoader> q;
    public Provider<AppCallsUsageTracker> q0;
    public Provider<ErrorFormatterImpl> q1;
    public Provider<AdvertDetailsItemsPresenterImpl> q2;
    public Provider<DeviceMetrics> q3;
    public Provider<RdsMyTargetContentBlueprint> q4;
    public Provider<AdvertDetailsAutodealBlueprint> q5;

    /* renamed from: q6  reason: collision with root package name */
    public Provider<AdvertDetailsClosingReasonBlueprint> f24q6;
    public Provider<AdvertDetailsSafeDealLegacyButtonBlueprint> q7;
    public Provider<AdapterPresenter> q8;
    public Provider<SparePartsFormatter> q9;
    public Provider<BannerPageSource> r;
    public Provider<AdvertContactsInteractorImpl> r0;
    public Provider<Formatter<Throwable>> r1;
    public Provider<AdvertDetailsItemsPresenter> r2;
    public Provider<ComplementaryResourceProviderImpl> r3;
    public Provider<MyTargetAppInstallPresenterImpl> r4;
    public Provider<AdvertDetailsNoteBlueprint> r5;

    /* renamed from: r6  reason: collision with root package name */
    public Provider<AdvertDetailsShowDescriptionPresenterImpl> f25r6;
    public Provider<ItemBlueprint<?, ?>> r7;
    public Provider<AdvertDetailsRecommendationItemBlueprint> r8;
    public Provider<Kundle> r9;
    public Provider<CommercialBannersAnalyticsInteractorImpl> s = new DelegateFactory();
    public Provider<AdvertContactsInteractor> s0;
    public Provider<NotificationManagerProvider> s1;
    public Provider<Long> s2;
    public Provider<SectionResourceProvider> s3;
    public Provider<MyTargetAppInstallPresenter> s4;
    public Provider<AdvertDetailsAutoCatalogPresenterImpl> s5;

    /* renamed from: s6  reason: collision with root package name */
    public Provider<AdvertDetailsShowDescriptionPresenter> f26s6;
    public Provider<AdvertDetailsSafeDealButtonPresenterImpl> s7;
    public Provider<SafeShowItemPresenterImpl> s8;
    public Provider<SparePartsPresenter> s9;
    public Provider<Kundle> t;
    public Provider<FeedbackInteractorImpl> t0;
    public Provider<ManuallyExposedAbTestGroup<AdvertDetailsPriceSubscriptionTestGroup>> t1;
    public Provider<ClipboardManager> t2;
    public Provider<SectionItemWidthProvider> t3;
    public Provider<RdsMyTargetAppInstallBlueprint> t4;
    public Provider<AdvertDetailsAutoCatalogPresenter> t5;

    /* renamed from: t6  reason: collision with root package name */
    public Provider<AdvertDetailsShowDescriptionBlueprint> f27t6;
    public Provider<AdvertDetailsSafeDealButtonPresenter> t7;
    public Provider<SafeShowItemPresenter> t8;
    public Provider<SparePartsReplacementsBlueprint> t9;
    public Provider<CreditBrokerAnalyticsInteractorImpl> u;
    public Provider<FeedbackInteractor> u0;
    public Provider<Kundle> u1;
    public Provider<AdvertSellerStatusInteractorImpl> u2;
    public Provider<ExposedAbTestGroup<PriceOnTopTestGroup>> u3;
    public Provider<AdvertDetailsTitlePresenter> u4;
    public Provider<AdvertDetailsAutoCatalogBlueprint> u5;

    /* renamed from: u6  reason: collision with root package name */
    public Provider<AdvertDetailsShowOnMapPresenter> f28u6;
    public Provider<AdvertDetailsSafeDealButtonBlueprint> u7;
    public Provider<SafeShowAdvertDetailsDialogFactory> u8;
    public Provider<Kundle> u9;
    public Provider<CreditBrokerAnalyticsInteractor> v;
    public Provider<AdvertContactsResourceProviderImpl> v0;
    public Provider<AdvertDetailsToolbarPresenterImpl> v1;
    public Provider<AdvertSellerStatusInteractor> v2;
    public Provider<SerpItemsPrefetchTestGroup> v3;
    public Provider<AdvertDetailsTitleBlueprint> v4;
    public Provider<AdvertDetailsSellerProfilePresenterImpl> v5;

    /* renamed from: v6  reason: collision with root package name */
    public Provider<AdvertDetailsShowOnMapBlueprint> f29v6;
    public Provider<ItemBlueprint<?, ?>> v7;
    public Provider<SafeShowItemBlueprint> v8;
    public Provider<SparePartsPresenter> v9;
    public Provider<AccountStateProvider> w;
    public Provider<AdvertContactsResourceProvider> w0;
    public Provider<AdvertDetailsToolbarPresenter> w1;
    public Provider<SellerStatusProviderImpl> w2;
    public Provider<SerpItemAbViewConfig> w3;
    public Provider<AdvertDetailsFragmentDelegate> w4;
    public Provider<AdvertDetailsSellerProfilePresenter> w5;

    /* renamed from: w6  reason: collision with root package name */
    public Provider<AdvertDetailsRatingPublishPresenter> f30w6;
    public Provider<AdvertDetailsSafeDealInfoPresenterImpl> w7;
    public Provider<AdvertDetailsIceBreakersPresenterImpl> w8;
    public Provider<SparePartsCompatibilitiesBlueprint> w9;
    public Provider<TreeStateIdGenerator> x;
    public Provider<Locale> x0;
    public Provider<AdvertSimilarPresenterResourceProviderImpl> x1;
    public Provider<SellerStatusProvider> x2;
    public Provider<ConnectivityProvider> x3;
    public Provider<AdvertDetailsGalleryPresenterImpl> x4;
    public Provider<AdvertDetailsSellerProfileBlueprint> x5;

    /* renamed from: x6  reason: collision with root package name */
    public Provider<AdvertDetailsRatingPublishBlueprint> f31x6;
    public Provider<AdvertDetailsSafeDealInfoPresenter> x7;
    public Provider<AdvertDetailsIceBreakersPresenter> x8;
    public Provider<AdvertBookingPresenter> x9;
    public Provider<TreeClickStreamParent> y;
    public Provider<AdvertPriceFormatter> y0;
    public Provider<AdvertSimilarPresenterResourceProvider> y1;
    public Provider<FavoriteAdvertsResourceProvider> y2;
    public Provider<ComplementaryAdvertItemBlueprintImpl> y3;
    public Provider<AdvertDetailsGalleryPresenter> y4;
    public Provider<AdvertDetailsSellerSubscriptionPresenterImpl> y5;

    /* renamed from: y6  reason: collision with root package name */
    public Provider<PromoCardItemPresenter> f32y6;
    public Provider<AdvertDetailsSafeDealInfoBlueprint> y7;
    public Provider<AdvertDetailsIcebreakerStyleTestGroup> y8;
    public Provider<AdvertBookingBlueprint> y9;
    public Provider<AdvertDetailsAnalyticsInteractorImpl> z;
    public Provider<Formatter<AdvertPrice>> z0;
    public Provider<AdvertSpanCountProvider> z1;
    public Provider<FavoriteAdvertsPresenter> z2;
    public Provider<ComplementaryAdvertItemBlueprint> z3;
    public Provider<ImplicitIntentFactory> z4;
    public Provider<AdvertDetailsSellerSubscriptionPresenter> z5;

    /* renamed from: z6  reason: collision with root package name */
    public Provider<ItemBlueprint<?, ?>> f33z6;
    public Provider<ItemBlueprint<?, ?>> z7;
    public Provider<AdvertDetailsIceBreakersBlueprint> z8;
    public Provider<CarMarketPriceDescriptionResourceProvider> z9;

    public static class a0 implements Provider<CartApi> {
        public final AdvertFragmentDependencies a;

        public a0(AdvertFragmentDependencies advertFragmentDependencies) {
            this.a = advertFragmentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public CartApi get() {
            return (CartApi) Preconditions.checkNotNullFromComponent(this.a.cartApi());
        }
    }

    public static class a1 implements Provider<Preferences> {
        public final AdvertFragmentDependencies a;

        public a1(AdvertFragmentDependencies advertFragmentDependencies) {
            this.a = advertFragmentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Preferences get() {
            return (Preferences) Preconditions.checkNotNullFromComponent(this.a.preferences());
        }
    }

    public static final class b implements AdvertFragmentComponent.Builder {
        public SubscriptionSource A;
        public BannerPageSource B;
        public Bundle C;
        public Kundle D;
        public Kundle E;
        public AdvertFragmentDependencies a;
        public ScreenAnalyticsDependencies b;
        public Screen c;
        public String d;
        public String e;
        public AdvertDetailsFastOpenParams f;
        public ScreenSource g;
        public Boolean h;
        public Long i;
        public Integer j;
        public Resources k;
        public Activity l;
        public AdvertDetailsFragmentDelegate m;
        public Bundle n;
        public Kundle o;
        public AutotekaDetailsResponse p;
        public Kundle q;
        public Kundle r;
        public Kundle s;
        public Bundle t;
        public TreeClickStreamParent u;
        public LifecycleOwner v;
        public ViewModelStoreOwner w;
        public PublishRelay<FavoriteSellersItemAction> x;
        public Kundle y;
        public Kundle z;

        public b(a aVar) {
        }

        @Override // com.avito.android.advert.di.AdvertFragmentComponent.Builder
        public AdvertFragmentComponent.Builder advertDependencies(AdvertFragmentDependencies advertFragmentDependencies) {
            this.a = (AdvertFragmentDependencies) Preconditions.checkNotNull(advertFragmentDependencies);
            return this;
        }

        @Override // com.avito.android.advert.di.AdvertFragmentComponent.Builder
        public AdvertFragmentComponent build() {
            Preconditions.checkBuilderRequirement(this.a, AdvertFragmentDependencies.class);
            Preconditions.checkBuilderRequirement(this.b, ScreenAnalyticsDependencies.class);
            Preconditions.checkBuilderRequirement(this.c, Screen.class);
            Preconditions.checkBuilderRequirement(this.d, String.class);
            Preconditions.checkBuilderRequirement(this.g, ScreenSource.class);
            Preconditions.checkBuilderRequirement(this.h, Boolean.class);
            Preconditions.checkBuilderRequirement(this.i, Long.class);
            Preconditions.checkBuilderRequirement(this.j, Integer.class);
            Preconditions.checkBuilderRequirement(this.k, Resources.class);
            Preconditions.checkBuilderRequirement(this.l, Activity.class);
            Preconditions.checkBuilderRequirement(this.m, AdvertDetailsFragmentDelegate.class);
            Preconditions.checkBuilderRequirement(this.v, LifecycleOwner.class);
            Preconditions.checkBuilderRequirement(this.w, ViewModelStoreOwner.class);
            Preconditions.checkBuilderRequirement(this.x, PublishRelay.class);
            Preconditions.checkBuilderRequirement(this.A, SubscriptionSource.class);
            Preconditions.checkBuilderRequirement(this.B, BannerPageSource.class);
            return new DaggerAdvertFragmentComponent(new BrandspaceEntryPointInteractorModule(), this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o, this.p, this.q, this.r, this.s, this.t, this.u, this.v, this.w, this.x, this.y, this.z, this.A, this.B, this.C, this.D, this.E, null);
        }

        @Override // com.avito.android.advert.di.AdvertFragmentComponent.Builder
        public AdvertFragmentComponent.Builder screen(Screen screen) {
            this.c = (Screen) Preconditions.checkNotNull(screen);
            return this;
        }

        @Override // com.avito.android.advert.di.AdvertFragmentComponent.Builder
        public AdvertFragmentComponent.Builder screenAnalyticsDependencies(ScreenAnalyticsDependencies screenAnalyticsDependencies) {
            this.b = (ScreenAnalyticsDependencies) Preconditions.checkNotNull(screenAnalyticsDependencies);
            return this;
        }

        @Override // com.avito.android.advert.di.AdvertFragmentComponent.Builder
        public AdvertFragmentComponent.Builder witReplacementsPresenterState(Kundle kundle) {
            this.D = kundle;
            return this;
        }

        @Override // com.avito.android.advert.di.AdvertFragmentComponent.Builder
        public AdvertFragmentComponent.Builder withActivity(Activity activity) {
            this.l = (Activity) Preconditions.checkNotNull(activity);
            return this;
        }

        @Override // com.avito.android.advert.di.AdvertFragmentComponent.Builder
        public AdvertFragmentComponent.Builder withAdvertId(String str) {
            this.d = (String) Preconditions.checkNotNull(str);
            return this;
        }

        @Override // com.avito.android.advert.di.AdvertFragmentComponent.Builder
        public AdvertFragmentComponent.Builder withAnalyticsRecommendationSource(SubscriptionSource subscriptionSource) {
            this.A = (SubscriptionSource) Preconditions.checkNotNull(subscriptionSource);
            return this;
        }

        @Override // com.avito.android.advert.di.AdvertFragmentComponent.Builder
        public AdvertFragmentComponent.Builder withAutotekaDetailsResponse(AutotekaDetailsResponse autotekaDetailsResponse) {
            this.p = null;
            return this;
        }

        @Override // com.avito.android.advert.di.AdvertFragmentComponent.Builder
        public AdvertFragmentComponent.Builder withAutotekaInteractorState(Kundle kundle) {
            this.o = kundle;
            return this;
        }

        @Override // com.avito.android.advert.di.AdvertFragmentComponent.Builder
        public AdvertFragmentComponent.Builder withAutotekaTeaserInteractorState(Kundle kundle) {
            this.q = kundle;
            return this;
        }

        @Override // com.avito.android.advert.di.AdvertFragmentComponent.Builder
        public AdvertFragmentComponent.Builder withBannerPageSource(BannerPageSource bannerPageSource) {
            this.B = (BannerPageSource) Preconditions.checkNotNull(bannerPageSource);
            return this;
        }

        @Override // com.avito.android.advert.di.AdvertFragmentComponent.Builder
        public AdvertFragmentComponent.Builder withBrokerAnalyticsState(Kundle kundle) {
            this.z = kundle;
            return this;
        }

        @Override // com.avito.android.advert.di.AdvertFragmentComponent.Builder
        public AdvertFragmentComponent.Builder withClickTime(long j2) {
            this.i = (Long) Preconditions.checkNotNull(Long.valueOf(j2));
            return this;
        }

        @Override // com.avito.android.advert.di.AdvertFragmentComponent.Builder
        public AdvertFragmentComponent.Builder withCompatibilitiesPresenterState(Kundle kundle) {
            this.E = kundle;
            return this;
        }

        @Override // com.avito.android.advert.di.AdvertFragmentComponent.Builder
        public AdvertFragmentComponent.Builder withDomotekaTeaserInteractorState(Kundle kundle) {
            this.r = kundle;
            return this;
        }

        @Override // com.avito.android.advert.di.AdvertFragmentComponent.Builder
        public AdvertFragmentComponent.Builder withFastOpenParams(AdvertDetailsFastOpenParams advertDetailsFastOpenParams) {
            this.f = advertDetailsFastOpenParams;
            return this;
        }

        @Override // com.avito.android.advert.di.AdvertFragmentComponent.Builder
        public AdvertFragmentComponent.Builder withFragmentDelegate(AdvertDetailsFragmentDelegate advertDetailsFragmentDelegate) {
            this.m = (AdvertDetailsFragmentDelegate) Preconditions.checkNotNull(advertDetailsFragmentDelegate);
            return this;
        }

        @Override // com.avito.android.advert.di.AdvertFragmentComponent.Builder
        public AdvertFragmentComponent.Builder withItemVisibilityTrackerState(Bundle bundle) {
            this.t = bundle;
            return this;
        }

        @Override // com.avito.android.advert.di.AdvertFragmentComponent.Builder
        public AdvertFragmentComponent.Builder withLifecycleOwner(LifecycleOwner lifecycleOwner) {
            this.v = (LifecycleOwner) Preconditions.checkNotNull(lifecycleOwner);
            return this;
        }

        @Override // com.avito.android.advert.di.AdvertFragmentComponent.Builder
        public AdvertFragmentComponent.Builder withMarketplaceFlag(boolean z2) {
            this.h = (Boolean) Preconditions.checkNotNull(Boolean.valueOf(z2));
            return this;
        }

        @Override // com.avito.android.advert.di.AdvertFragmentComponent.Builder
        public AdvertFragmentComponent.Builder withQuestionnaireState(Bundle bundle) {
            this.C = bundle;
            return this;
        }

        @Override // com.avito.android.advert.di.AdvertFragmentComponent.Builder
        public AdvertFragmentComponent.Builder withRecommendationPresenterState(Kundle kundle) {
            this.y = kundle;
            return this;
        }

        @Override // com.avito.android.advert.di.AdvertFragmentComponent.Builder
        public AdvertFragmentComponent.Builder withRelay(PublishRelay publishRelay) {
            this.x = (PublishRelay) Preconditions.checkNotNull(publishRelay);
            return this;
        }

        @Override // com.avito.android.advert.di.AdvertFragmentComponent.Builder
        public AdvertFragmentComponent.Builder withResources(Resources resources) {
            this.k = (Resources) Preconditions.checkNotNull(resources);
            return this;
        }

        @Override // com.avito.android.advert.di.AdvertFragmentComponent.Builder
        public AdvertFragmentComponent.Builder withScreenSource(ScreenSource screenSource) {
            this.g = (ScreenSource) Preconditions.checkNotNull(screenSource);
            return this;
        }

        @Override // com.avito.android.advert.di.AdvertFragmentComponent.Builder
        public AdvertFragmentComponent.Builder withSearchContext(String str) {
            this.e = str;
            return this;
        }

        @Override // com.avito.android.advert.di.AdvertFragmentComponent.Builder
        public AdvertFragmentComponent.Builder withSectionSavedState(Bundle bundle) {
            this.n = bundle;
            return this;
        }

        @Override // com.avito.android.advert.di.AdvertFragmentComponent.Builder
        public AdvertFragmentComponent.Builder withStartingGalleryPosition(int i2) {
            this.j = (Integer) Preconditions.checkNotNull(Integer.valueOf(i2));
            return this;
        }

        @Override // com.avito.android.advert.di.AdvertFragmentComponent.Builder
        public AdvertFragmentComponent.Builder withToolbarPresenterState(Kundle kundle) {
            this.s = kundle;
            return this;
        }

        @Override // com.avito.android.advert.di.AdvertFragmentComponent.Builder
        public AdvertFragmentComponent.Builder withTreeParent(TreeClickStreamParent treeClickStreamParent) {
            this.u = treeClickStreamParent;
            return this;
        }

        @Override // com.avito.android.advert.di.AdvertFragmentComponent.Builder
        public AdvertFragmentComponent.Builder withViewModelStoreOwner(ViewModelStoreOwner viewModelStoreOwner) {
            this.w = (ViewModelStoreOwner) Preconditions.checkNotNull(viewModelStoreOwner);
            return this;
        }
    }

    public static class b0 implements Provider<ConnectivityProvider> {
        public final AdvertFragmentDependencies a;

        public b0(AdvertFragmentDependencies advertFragmentDependencies) {
            this.a = advertFragmentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ConnectivityProvider get() {
            return (ConnectivityProvider) Preconditions.checkNotNullFromComponent(this.a.connectivityProvider());
        }
    }

    public static class b1 implements Provider<SerpItemsPrefetchTestGroup> {
        public final AdvertFragmentDependencies a;

        public b1(AdvertFragmentDependencies advertFragmentDependencies) {
            this.a = advertFragmentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SerpItemsPrefetchTestGroup get() {
            return (SerpItemsPrefetchTestGroup) Preconditions.checkNotNullFromComponent(this.a.prefetchTestGroup());
        }
    }

    public static final class c<T> implements Provider<Optional<T>> {
        public final Provider<T> a;

        public c(Provider<T> provider) {
            this.a = (Provider) Preconditions.checkNotNull(provider);
        }

        @Override // javax.inject.Provider
        public Object get() {
            return Optional.of(this.a.get());
        }
    }

    public static class c0 implements Provider<Context> {
        public final AdvertFragmentDependencies a;

        public c0(AdvertFragmentDependencies advertFragmentDependencies) {
            this.a = advertFragmentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Context get() {
            return (Context) Preconditions.checkNotNullFromComponent(this.a.context());
        }
    }

    public static class c1 implements Provider<ExposedAbTestGroup<PriceOnTopTestGroup>> {
        public final AdvertFragmentDependencies a;

        public c1(AdvertFragmentDependencies advertFragmentDependencies) {
            this.a = advertFragmentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ExposedAbTestGroup<PriceOnTopTestGroup> get() {
            return (ExposedAbTestGroup) Preconditions.checkNotNullFromComponent(this.a.priceOnTop());
        }
    }

    public static class d implements Provider<AccountStateProvider> {
        public final AdvertFragmentDependencies a;

        public d(AdvertFragmentDependencies advertFragmentDependencies) {
            this.a = advertFragmentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public AccountStateProvider get() {
            return (AccountStateProvider) Preconditions.checkNotNullFromComponent(this.a.accountStateProvider());
        }
    }

    public static class d0 implements Provider<DeepLinkFactory> {
        public final AdvertFragmentDependencies a;

        public d0(AdvertFragmentDependencies advertFragmentDependencies) {
            this.a = advertFragmentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public DeepLinkFactory get() {
            return (DeepLinkFactory) Preconditions.checkNotNullFromComponent(this.a.deepLinkFactory());
        }
    }

    public static class d1 implements Provider<ProfileApi> {
        public final AdvertFragmentDependencies a;

        public d1(AdvertFragmentDependencies advertFragmentDependencies) {
            this.a = advertFragmentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ProfileApi get() {
            return (ProfileApi) Preconditions.checkNotNullFromComponent(this.a.profileApi());
        }
    }

    public static class e implements Provider<ManuallyExposedAbTestGroup<AdvertAutotekaTeaserInGalleryTestGroup>> {
        public final AdvertFragmentDependencies a;

        public e(AdvertFragmentDependencies advertFragmentDependencies) {
            this.a = advertFragmentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ManuallyExposedAbTestGroup<AdvertAutotekaTeaserInGalleryTestGroup> get() {
            return (ManuallyExposedAbTestGroup) Preconditions.checkNotNullFromComponent(this.a.advertAutotekaTeaserInGalleryTestGroup());
        }
    }

    public static class e0 implements Provider<DeliveryApi> {
        public final AdvertFragmentDependencies a;

        public e0(AdvertFragmentDependencies advertFragmentDependencies) {
            this.a = advertFragmentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public DeliveryApi get() {
            return (DeliveryApi) Preconditions.checkNotNullFromComponent(this.a.deliveryApi());
        }
    }

    public static class e1 implements Provider<ProfileInfoStorage> {
        public final AdvertFragmentDependencies a;

        public e1(AdvertFragmentDependencies advertFragmentDependencies) {
            this.a = advertFragmentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ProfileInfoStorage get() {
            return (ProfileInfoStorage) Preconditions.checkNotNullFromComponent(this.a.profileInfoStorage());
        }
    }

    public static class f implements Provider<ExposedAbTestGroup<SimpleTestGroupWithNone>> {
        public final AdvertFragmentDependencies a;

        public f(AdvertFragmentDependencies advertFragmentDependencies) {
            this.a = advertFragmentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ExposedAbTestGroup<SimpleTestGroupWithNone> get() {
            return (ExposedAbTestGroup) Preconditions.checkNotNullFromComponent(this.a.advertContactApplyWithoutChatTestGroup());
        }
    }

    public static class f0 implements Provider<DeviceMetrics> {
        public final AdvertFragmentDependencies a;

        public f0(AdvertFragmentDependencies advertFragmentDependencies) {
            this.a = advertFragmentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public DeviceMetrics get() {
            return (DeviceMetrics) Preconditions.checkNotNullFromComponent(this.a.deviceMetrics());
        }
    }

    public static class f1 implements Provider<RandomKeyProvider> {
        public final AdvertFragmentDependencies a;

        public f1(AdvertFragmentDependencies advertFragmentDependencies) {
            this.a = advertFragmentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public RandomKeyProvider get() {
            return (RandomKeyProvider) Preconditions.checkNotNullFromComponent(this.a.randomKeyProvider());
        }
    }

    public static class g implements Provider<AdvertDeliveryStorage> {
        public final AdvertFragmentDependencies a;

        public g(AdvertFragmentDependencies advertFragmentDependencies) {
            this.a = advertFragmentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public AdvertDeliveryStorage get() {
            return (AdvertDeliveryStorage) Preconditions.checkNotNullFromComponent(this.a.advertDeliveryStorage());
        }
    }

    public static class g0 implements Provider<DomotekaApi> {
        public final AdvertFragmentDependencies a;

        public g0(AdvertFragmentDependencies advertFragmentDependencies) {
            this.a = advertFragmentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public DomotekaApi get() {
            return (DomotekaApi) Preconditions.checkNotNullFromComponent(this.a.domotekaApi());
        }
    }

    public static class g1 implements Provider<SafeDealApi> {
        public final AdvertFragmentDependencies a;

        public g1(AdvertFragmentDependencies advertFragmentDependencies) {
            this.a = advertFragmentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SafeDealApi get() {
            return (SafeDealApi) Preconditions.checkNotNullFromComponent(this.a.safeDealApi());
        }
    }

    public static class h implements Provider<AdvertDetailsApi> {
        public final AdvertFragmentDependencies a;

        public h(AdvertFragmentDependencies advertFragmentDependencies) {
            this.a = advertFragmentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public AdvertDetailsApi get() {
            return (AdvertDetailsApi) Preconditions.checkNotNullFromComponent(this.a.advertDetailsApi());
        }
    }

    public static class h0 implements Provider<FavoriteAdvertsEventInteractor> {
        public final AdvertFragmentDependencies a;

        public h0(AdvertFragmentDependencies advertFragmentDependencies) {
            this.a = advertFragmentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public FavoriteAdvertsEventInteractor get() {
            return (FavoriteAdvertsEventInteractor) Preconditions.checkNotNullFromComponent(this.a.favoriteAdvertsEventInteractor());
        }
    }

    public static class h1 implements Provider<SchedulersFactory3> {
        public final AdvertFragmentDependencies a;

        public h1(AdvertFragmentDependencies advertFragmentDependencies) {
            this.a = advertFragmentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory3 get() {
            return (SchedulersFactory3) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory3());
        }
    }

    public static class i implements Provider<AdvertDetailsIcebreakerStyleTestGroup> {
        public final AdvertFragmentDependencies a;

        public i(AdvertFragmentDependencies advertFragmentDependencies) {
            this.a = advertFragmentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public AdvertDetailsIcebreakerStyleTestGroup get() {
            return (AdvertDetailsIcebreakerStyleTestGroup) Preconditions.checkNotNullFromComponent(this.a.advertDetailsIcebreakerStyleTestGroup());
        }
    }

    public static class i0 implements Provider<FavoriteAdvertsSyncEventProvider> {
        public final AdvertFragmentDependencies a;

        public i0(AdvertFragmentDependencies advertFragmentDependencies) {
            this.a = advertFragmentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public FavoriteAdvertsSyncEventProvider get() {
            return (FavoriteAdvertsSyncEventProvider) Preconditions.checkNotNullFromComponent(this.a.favoriteAdvertsSyncEventProvider());
        }
    }

    public static class i1 implements Provider<SchedulersFactory> {
        public final AdvertFragmentDependencies a;

        public i1(AdvertFragmentDependencies advertFragmentDependencies) {
            this.a = advertFragmentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory get() {
            return (SchedulersFactory) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory());
        }
    }

    public static class j implements Provider<ManuallyExposedAbTestGroup<AdvertDetailsMarketplaceBadgeBarItemTestGroup>> {
        public final AdvertFragmentDependencies a;

        public j(AdvertFragmentDependencies advertFragmentDependencies) {
            this.a = advertFragmentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ManuallyExposedAbTestGroup<AdvertDetailsMarketplaceBadgeBarItemTestGroup> get() {
            return (ManuallyExposedAbTestGroup) Preconditions.checkNotNullFromComponent(this.a.advertDetailsMarketplaceBadgeBarItemTestGroup());
        }
    }

    public static class j0 implements Provider<FavoriteAdvertsUploadInteractor> {
        public final AdvertFragmentDependencies a;

        public j0(AdvertFragmentDependencies advertFragmentDependencies) {
            this.a = advertFragmentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public FavoriteAdvertsUploadInteractor get() {
            return (FavoriteAdvertsUploadInteractor) Preconditions.checkNotNullFromComponent(this.a.favoriteAdvertsUploadInteractor());
        }
    }

    public static class j1 implements Provider<AbTestGroup<SendEmployersPhoneOnCallToSellerButtonClickInResumesTestGroup>> {
        public final AdvertFragmentDependencies a;

        public j1(AdvertFragmentDependencies advertFragmentDependencies) {
            this.a = advertFragmentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public AbTestGroup<SendEmployersPhoneOnCallToSellerButtonClickInResumesTestGroup> get() {
            return (AbTestGroup) Preconditions.checkNotNullFromComponent(this.a.sendEmployersPhoneOnCallToSellerButtonClickInResumes());
        }
    }

    public static class k implements Provider<ManuallyExposedAbTestGroup<SimpleTestGroupWithNone>> {
        public final AdvertFragmentDependencies a;

        public k(AdvertFragmentDependencies advertFragmentDependencies) {
            this.a = advertFragmentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ManuallyExposedAbTestGroup<SimpleTestGroupWithNone> get() {
            return (ManuallyExposedAbTestGroup) Preconditions.checkNotNullFromComponent(this.a.advertDetailsMarketplaceDeliveryItemTestGroup());
        }
    }

    public static class k0 implements Provider<FavoriteSellersApi> {
        public final AdvertFragmentDependencies a;

        public k0(AdvertFragmentDependencies advertFragmentDependencies) {
            this.a = advertFragmentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public FavoriteSellersApi get() {
            return (FavoriteSellersApi) Preconditions.checkNotNullFromComponent(this.a.favoriteSellersApi());
        }
    }

    public static class k1 implements Provider<SparePartsApi> {
        public final AdvertFragmentDependencies a;

        public k1(AdvertFragmentDependencies advertFragmentDependencies) {
            this.a = advertFragmentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SparePartsApi get() {
            return (SparePartsApi) Preconditions.checkNotNullFromComponent(this.a.sparePartsApi());
        }
    }

    public static class l implements Provider<ExposedAbTestGroup<AdvertDetailsMarketplaceImprovingContentItemsTestGroup>> {
        public final AdvertFragmentDependencies a;

        public l(AdvertFragmentDependencies advertFragmentDependencies) {
            this.a = advertFragmentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ExposedAbTestGroup<AdvertDetailsMarketplaceImprovingContentItemsTestGroup> get() {
            return (ExposedAbTestGroup) Preconditions.checkNotNullFromComponent(this.a.advertDetailsMarketplaceImprovingContentItemsTestGroup());
        }
    }

    public static class l0 implements Provider<FavoriteSellersRepository> {
        public final AdvertFragmentDependencies a;

        public l0(AdvertFragmentDependencies advertFragmentDependencies) {
            this.a = advertFragmentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public FavoriteSellersRepository get() {
            return (FavoriteSellersRepository) Preconditions.checkNotNullFromComponent(this.a.favoriteSellersRepository());
        }
    }

    public static class l1 implements Provider<SravniNetworkConfiguration> {
        public final AdvertFragmentDependencies a;

        public l1(AdvertFragmentDependencies advertFragmentDependencies) {
            this.a = advertFragmentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SravniNetworkConfiguration get() {
            return (SravniNetworkConfiguration) Preconditions.checkNotNullFromComponent(this.a.sravniConfiguration());
        }
    }

    public static class m implements Provider<ManuallyExposedAbTestGroup<AdvertDetailsMarketplaceNoPurchaseFeedbackTestGroup>> {
        public final AdvertFragmentDependencies a;

        public m(AdvertFragmentDependencies advertFragmentDependencies) {
            this.a = advertFragmentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ManuallyExposedAbTestGroup<AdvertDetailsMarketplaceNoPurchaseFeedbackTestGroup> get() {
            return (ManuallyExposedAbTestGroup) Preconditions.checkNotNullFromComponent(this.a.advertDetailsMarketplaceNoPurchaseFeedbackTestGroup());
        }
    }

    public static class m0 implements Provider<FavoritesSyncDao> {
        public final AdvertFragmentDependencies a;

        public m0(AdvertFragmentDependencies advertFragmentDependencies) {
            this.a = advertFragmentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public FavoritesSyncDao get() {
            return (FavoritesSyncDao) Preconditions.checkNotNullFromComponent(this.a.favoritesSyncDao());
        }
    }

    public static class m1 implements Provider<SravniAnalyticsEventLogger> {
        public final AdvertFragmentDependencies a;

        public m1(AdvertFragmentDependencies advertFragmentDependencies) {
            this.a = advertFragmentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SravniAnalyticsEventLogger get() {
            return (SravniAnalyticsEventLogger) Preconditions.checkNotNullFromComponent(this.a.sravniEventLogger());
        }
    }

    public static class n implements Provider<ManuallyExposedAbTestGroup<AdvertDetailsNoCallFeedbackTestGroup>> {
        public final AdvertFragmentDependencies a;

        public n(AdvertFragmentDependencies advertFragmentDependencies) {
            this.a = advertFragmentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ManuallyExposedAbTestGroup<AdvertDetailsNoCallFeedbackTestGroup> get() {
            return (ManuallyExposedAbTestGroup) Preconditions.checkNotNullFromComponent(this.a.advertDetailsNoCallFeedbackTestGroup());
        }
    }

    public static class n0 implements Provider<Features> {
        public final AdvertFragmentDependencies a;

        public n0(AdvertFragmentDependencies advertFragmentDependencies) {
            this.a = advertFragmentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Features get() {
            return (Features) Preconditions.checkNotNullFromComponent(this.a.features());
        }
    }

    public static class n1 implements Provider<SingleManuallyExposedAbTestGroup<SravniWebTestGroup>> {
        public final AdvertFragmentDependencies a;

        public n1(AdvertFragmentDependencies advertFragmentDependencies) {
            this.a = advertFragmentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SingleManuallyExposedAbTestGroup<SravniWebTestGroup> get() {
            return (SingleManuallyExposedAbTestGroup) Preconditions.checkNotNullFromComponent(this.a.sravniWebTestGroup());
        }
    }

    public static class o implements Provider<ManuallyExposedAbTestGroup<AdvertDetailsPriceSubscriptionTestGroup>> {
        public final AdvertFragmentDependencies a;

        public o(AdvertFragmentDependencies advertFragmentDependencies) {
            this.a = advertFragmentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ManuallyExposedAbTestGroup<AdvertDetailsPriceSubscriptionTestGroup> get() {
            return (ManuallyExposedAbTestGroup) Preconditions.checkNotNullFromComponent(this.a.advertDetailsPriceSubscription());
        }
    }

    public static class o0 implements Provider<HtmlCleaner> {
        public final AdvertFragmentDependencies a;

        public o0(AdvertFragmentDependencies advertFragmentDependencies) {
            this.a = advertFragmentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public HtmlCleaner get() {
            return (HtmlCleaner) Preconditions.checkNotNullFromComponent(this.a.htmlCleaner());
        }
    }

    public static class o1 implements Provider<TeaserObserver> {
        public final AdvertFragmentDependencies a;

        public o1(AdvertFragmentDependencies advertFragmentDependencies) {
            this.a = advertFragmentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public TeaserObserver get() {
            return (TeaserObserver) Preconditions.checkNotNullFromComponent(this.a.teaserObserver());
        }
    }

    public static class p implements Provider<AbTestGroup<SimpleTestGroupWithNoneControl2>> {
        public final AdvertFragmentDependencies a;

        public p(AdvertFragmentDependencies advertFragmentDependencies) {
            this.a = advertFragmentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public AbTestGroup<SimpleTestGroupWithNoneControl2> get() {
            return (AbTestGroup) Preconditions.checkNotNullFromComponent(this.a.advertSpeedUpTest());
        }
    }

    public static class p0 implements Provider<HtmlRenderer> {
        public final AdvertFragmentDependencies a;

        public p0(AdvertFragmentDependencies advertFragmentDependencies) {
            this.a = advertFragmentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public HtmlRenderer get() {
            return (HtmlRenderer) Preconditions.checkNotNullFromComponent(this.a.htmlRenderer());
        }
    }

    public static class p1 implements Provider<TimeSource> {
        public final AdvertFragmentDependencies a;

        public p1(AdvertFragmentDependencies advertFragmentDependencies) {
            this.a = advertFragmentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public TimeSource get() {
            return (TimeSource) Preconditions.checkNotNullFromComponent(this.a.timeSource());
        }
    }

    public static class q implements Provider<Analytics> {
        public final AdvertFragmentDependencies a;

        public q(AdvertFragmentDependencies advertFragmentDependencies) {
            this.a = advertFragmentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Analytics get() {
            return (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics());
        }
    }

    public static class q0 implements Provider<ImplicitIntentFactory> {
        public final AdvertFragmentDependencies a;

        public q0(AdvertFragmentDependencies advertFragmentDependencies) {
            this.a = advertFragmentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ImplicitIntentFactory get() {
            return (ImplicitIntentFactory) Preconditions.checkNotNullFromComponent(this.a.implicitIntentFactory());
        }
    }

    public static class q1 implements Provider<SingleManuallyExposedAbTestGroup<TinkoffCreditCalculatorTestGroup>> {
        public final AdvertFragmentDependencies a;

        public q1(AdvertFragmentDependencies advertFragmentDependencies) {
            this.a = advertFragmentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SingleManuallyExposedAbTestGroup<TinkoffCreditCalculatorTestGroup> get() {
            return (SingleManuallyExposedAbTestGroup) Preconditions.checkNotNullFromComponent(this.a.tinkoffCreditCalculatorTestGroup());
        }
    }

    public static class r implements Provider<SingleManuallyExposedAbTestGroup<AntiFraudCheckListTestGroup>> {
        public final AdvertFragmentDependencies a;

        public r(AdvertFragmentDependencies advertFragmentDependencies) {
            this.a = advertFragmentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SingleManuallyExposedAbTestGroup<AntiFraudCheckListTestGroup> get() {
            return (SingleManuallyExposedAbTestGroup) Preconditions.checkNotNullFromComponent(this.a.antiFraudCheckListTest());
        }
    }

    public static class r0 implements Provider<JobApi> {
        public final AdvertFragmentDependencies a;

        public r0(AdvertFragmentDependencies advertFragmentDependencies) {
            this.a = advertFragmentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public JobApi get() {
            return (JobApi) Preconditions.checkNotNullFromComponent(this.a.jobApi());
        }
    }

    public static class r1 implements Provider<TrackerInfoProvider> {
        public final AdvertFragmentDependencies a;

        public r1(AdvertFragmentDependencies advertFragmentDependencies) {
            this.a = advertFragmentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public TrackerInfoProvider get() {
            return (TrackerInfoProvider) Preconditions.checkNotNullFromComponent(this.a.trackerInfoProvider());
        }
    }

    public static class s implements Provider<AppCallsUsageTracker> {
        public final AdvertFragmentDependencies a;

        public s(AdvertFragmentDependencies advertFragmentDependencies) {
            this.a = advertFragmentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public AppCallsUsageTracker get() {
            return (AppCallsUsageTracker) Preconditions.checkNotNullFromComponent(this.a.appCallUsageTracker());
        }
    }

    public static class s0 implements Provider<ExposedAbTestGroup<SimpleTestGroup>> {
        public final AdvertFragmentDependencies a;

        public s0(AdvertFragmentDependencies advertFragmentDependencies) {
            this.a = advertFragmentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ExposedAbTestGroup<SimpleTestGroup> get() {
            return (ExposedAbTestGroup) Preconditions.checkNotNullFromComponent(this.a.jobApplicationProgressBarTestGroup());
        }
    }

    public static class s1 implements Provider<TreeStateIdGenerator> {
        public final AdvertFragmentDependencies a;

        public s1(AdvertFragmentDependencies advertFragmentDependencies) {
            this.a = advertFragmentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public TreeStateIdGenerator get() {
            return (TreeStateIdGenerator) Preconditions.checkNotNullFromComponent(this.a.treeStateIdGenerator());
        }
    }

    public static class t implements Provider<Application> {
        public final AdvertFragmentDependencies a;

        public t(AdvertFragmentDependencies advertFragmentDependencies) {
            this.a = advertFragmentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Application get() {
            return (Application) Preconditions.checkNotNullFromComponent(this.a.application());
        }
    }

    public static class t0 implements Provider<AbTestGroup<SimpleTestGroupWithControl2>> {
        public final AdvertFragmentDependencies a;

        public t0(AdvertFragmentDependencies advertFragmentDependencies) {
            this.a = advertFragmentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public AbTestGroup<SimpleTestGroupWithControl2> get() {
            return (AbTestGroup) Preconditions.checkNotNullFromComponent(this.a.justDialSellerPhoneTestGroup());
        }
    }

    public static class t1 implements Provider<TypedErrorThrowableConverter> {
        public final AdvertFragmentDependencies a;

        public t1(AdvertFragmentDependencies advertFragmentDependencies) {
            this.a = advertFragmentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public TypedErrorThrowableConverter get() {
            return (TypedErrorThrowableConverter) Preconditions.checkNotNullFromComponent(this.a.typedErrorThrowableConverter());
        }
    }

    public static class u implements Provider<AsyncPhoneApi> {
        public final AdvertFragmentDependencies a;

        public u(AdvertFragmentDependencies advertFragmentDependencies) {
            this.a = advertFragmentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public AsyncPhoneApi get() {
            return (AsyncPhoneApi) Preconditions.checkNotNullFromComponent(this.a.asyncPhoneApi());
        }
    }

    public static class u0 implements Provider<Locale> {
        public final AdvertFragmentDependencies a;

        public u0(AdvertFragmentDependencies advertFragmentDependencies) {
            this.a = advertFragmentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Locale get() {
            return (Locale) Preconditions.checkNotNullFromComponent(this.a.locale());
        }
    }

    public static class u1 implements Provider<ViewedAdvertsDao> {
        public final AdvertFragmentDependencies a;

        public u1(AdvertFragmentDependencies advertFragmentDependencies) {
            this.a = advertFragmentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ViewedAdvertsDao get() {
            return (ViewedAdvertsDao) Preconditions.checkNotNullFromComponent(this.a.viewedAdvertsDao());
        }
    }

    public static class v implements Provider<AutotekaApi> {
        public final AdvertFragmentDependencies a;

        public v(AdvertFragmentDependencies advertFragmentDependencies) {
            this.a = advertFragmentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public AutotekaApi get() {
            return (AutotekaApi) Preconditions.checkNotNullFromComponent(this.a.autotekaApi());
        }
    }

    public static class v0 implements Provider<MyTargetImageBgProvider> {
        public final AdvertFragmentDependencies a;

        public v0(AdvertFragmentDependencies advertFragmentDependencies) {
            this.a = advertFragmentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public MyTargetImageBgProvider get() {
            return (MyTargetImageBgProvider) Preconditions.checkNotNullFromComponent(this.a.myTargetImageBgProvider());
        }
    }

    public static class v1 implements Provider<ViewedAdvertsEventInteractor> {
        public final AdvertFragmentDependencies a;

        public v1(AdvertFragmentDependencies advertFragmentDependencies) {
            this.a = advertFragmentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ViewedAdvertsEventInteractor get() {
            return (ViewedAdvertsEventInteractor) Preconditions.checkNotNullFromComponent(this.a.viewedAdvertsEventInteractor());
        }
    }

    public static class w implements Provider<AvitoMessengerApi> {
        public final AdvertFragmentDependencies a;

        public w(AdvertFragmentDependencies advertFragmentDependencies) {
            this.a = advertFragmentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public AvitoMessengerApi get() {
            return (AvitoMessengerApi) Preconditions.checkNotNullFromComponent(this.a.avitoMessengerApi());
        }
    }

    public static class w0 implements Provider<NetworkTypeProvider> {
        public final AdvertFragmentDependencies a;

        public w0(AdvertFragmentDependencies advertFragmentDependencies) {
            this.a = advertFragmentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public NetworkTypeProvider get() {
            return (NetworkTypeProvider) Preconditions.checkNotNullFromComponent(this.a.networkTypeProvider());
        }
    }

    public static class w1 implements Provider<ScreenTrackerFactory> {
        public final ScreenAnalyticsDependencies a;

        public w1(ScreenAnalyticsDependencies screenAnalyticsDependencies) {
            this.a = screenAnalyticsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ScreenTrackerFactory get() {
            return (ScreenTrackerFactory) Preconditions.checkNotNullFromComponent(this.a.screenTrackerFactory());
        }
    }

    public static class x implements Provider<BuildInfo> {
        public final AdvertFragmentDependencies a;

        public x(AdvertFragmentDependencies advertFragmentDependencies) {
            this.a = advertFragmentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public BuildInfo get() {
            return (BuildInfo) Preconditions.checkNotNullFromComponent(this.a.buildInfo());
        }
    }

    public static class x0 implements Provider<NotificationManagerProvider> {
        public final AdvertFragmentDependencies a;

        public x0(AdvertFragmentDependencies advertFragmentDependencies) {
            this.a = advertFragmentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public NotificationManagerProvider get() {
            return (NotificationManagerProvider) Preconditions.checkNotNullFromComponent(this.a.notificationManagerProvider());
        }
    }

    public static class x1 implements Provider<TimerFactory> {
        public final ScreenAnalyticsDependencies a;

        public x1(ScreenAnalyticsDependencies screenAnalyticsDependencies) {
            this.a = screenAnalyticsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public TimerFactory get() {
            return (TimerFactory) Preconditions.checkNotNullFromComponent(this.a.timerFactory());
        }
    }

    public static class y implements Provider<CallUuidProvider> {
        public final AdvertFragmentDependencies a;

        public y(AdvertFragmentDependencies advertFragmentDependencies) {
            this.a = advertFragmentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public CallUuidProvider get() {
            return (CallUuidProvider) Preconditions.checkNotNullFromComponent(this.a.callUuidProvider());
        }
    }

    public static class y0 implements Provider<ExposedAbTestGroup<OrangeAdBadgeTestGroup>> {
        public final AdvertFragmentDependencies a;

        public y0(AdvertFragmentDependencies advertFragmentDependencies) {
            this.a = advertFragmentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ExposedAbTestGroup<OrangeAdBadgeTestGroup> get() {
            return (ExposedAbTestGroup) Preconditions.checkNotNullFromComponent(this.a.orangeAdBadgeTestGroup());
        }
    }

    public static class z implements Provider<CallsApi> {
        public final AdvertFragmentDependencies a;

        public z(AdvertFragmentDependencies advertFragmentDependencies) {
            this.a = advertFragmentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public CallsApi get() {
            return (CallsApi) Preconditions.checkNotNullFromComponent(this.a.callsApi());
        }
    }

    public static class z0 implements Provider<PermissionChecker> {
        public final AdvertFragmentDependencies a;

        public z0(AdvertFragmentDependencies advertFragmentDependencies) {
            this.a = advertFragmentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public PermissionChecker get() {
            return (PermissionChecker) Preconditions.checkNotNullFromComponent(this.a.permissionChecker());
        }
    }

    public DaggerAdvertFragmentComponent(BrandspaceEntryPointInteractorModule brandspaceEntryPointInteractorModule, AdvertFragmentDependencies advertFragmentDependencies, ScreenAnalyticsDependencies screenAnalyticsDependencies, Screen screen, String str, String str2, AdvertDetailsFastOpenParams advertDetailsFastOpenParams, ScreenSource screenSource, Boolean bool, Long l10, Integer num, Resources resources, Activity activity, AdvertDetailsFragmentDelegate advertDetailsFragmentDelegate, Bundle bundle, Kundle kundle, AutotekaDetailsResponse autotekaDetailsResponse, Kundle kundle2, Kundle kundle3, Kundle kundle4, Bundle bundle2, TreeClickStreamParent treeClickStreamParent, LifecycleOwner lifecycleOwner, ViewModelStoreOwner viewModelStoreOwner, PublishRelay publishRelay, Kundle kundle5, Kundle kundle6, SubscriptionSource subscriptionSource, BannerPageSource bannerPageSource, Bundle bundle3, Kundle kundle7, Kundle kundle8, a aVar) {
        this.a = advertFragmentDependencies;
        this.b = screenAnalyticsDependencies;
        this.c = screen;
        this.d = InstanceFactory.create(str);
        this.e = new h(advertFragmentDependencies);
        c0 c0Var = new c0(advertFragmentDependencies);
        this.f = c0Var;
        q qVar = new q(advertFragmentDependencies);
        this.g = qVar;
        x xVar = new x(advertFragmentDependencies);
        this.h = xVar;
        n0 n0Var = new n0(advertFragmentDependencies);
        this.i = n0Var;
        DfpBannerLoaderImpl_Factory create = DfpBannerLoaderImpl_Factory.create(c0Var, qVar, xVar, n0Var);
        this.j = create;
        this.k = DoubleCheck.provider(create);
        h1 h1Var = new h1(advertFragmentDependencies);
        this.l = h1Var;
        YandexBannerLoaderImpl_Factory create2 = YandexBannerLoaderImpl_Factory.create(this.f, h1Var, this.g);
        this.m = create2;
        this.n = DoubleCheck.provider(create2);
        v0 v0Var = new v0(advertFragmentDependencies);
        this.o = v0Var;
        MyTargetBannerLoaderImpl_Factory create3 = MyTargetBannerLoaderImpl_Factory.create(this.f, this.g, v0Var);
        this.p = create3;
        this.q = DoubleCheck.provider(create3);
        this.r = InstanceFactory.create(bannerPageSource);
        this.t = InstanceFactory.createNullable(kundle6);
        CreditBrokerAnalyticsInteractorImpl_Factory create4 = CreditBrokerAnalyticsInteractorImpl_Factory.create(this.d, this.g, UUIDRandomKeyProvider_Factory.create(), this.t);
        this.u = create4;
        this.v = DoubleCheck.provider(create4);
        this.w = new d(advertFragmentDependencies);
        this.x = new s1(advertFragmentDependencies);
        Factory createNullable = InstanceFactory.createNullable(treeClickStreamParent);
        this.y = createNullable;
        AdvertDetailsAnalyticsInteractorImpl_Factory create5 = AdvertDetailsAnalyticsInteractorImpl_Factory.create(this.g, this.s, this.v, this.w, this.x, createNullable, this.i);
        this.z = create5;
        Provider<AdvertDetailsAnalyticsInteractor> provider = DoubleCheck.provider(create5);
        this.A = provider;
        Provider<TreeClickStreamParent> provider2 = DoubleCheck.provider(AdvertFragmentModule_ProvideTreeParent$advert_details_releaseFactory.create(provider));
        this.B = provider2;
        DelegateFactory.setDelegate(this.s, CommercialBannersAnalyticsInteractorImpl_Factory.create(this.r, this.g, provider2, this.x, CommercialBannerTimeProviderImpl_Factory.create()));
        this.C = DoubleCheck.provider(BannerInfoFactoryImpl_Factory.create());
        CommercialBannersInteractorImpl_Factory create6 = CommercialBannersInteractorImpl_Factory.create(this.k, this.n, this.q, this.s, CommercialBannerTimeProviderImpl_Factory.create(), this.l, this.C);
        this.D = create6;
        this.E = DoubleCheck.provider(create6);
        Factory create7 = InstanceFactory.create(resources);
        this.F = create7;
        this.G = DoubleCheck.provider(AdvertFragmentModule_ProvideIsTablet$advert_details_releaseFactory.create(create7));
        this.H = InstanceFactory.create(screenSource);
        this.I = new p0(advertFragmentDependencies);
        this.J = new o0(advertFragmentDependencies);
        Provider<HtmlRenderOptions> provider3 = DoubleCheck.provider(AdvertDetailsHtmlDescriptionModule_ProvideHtmlRenderOptionsFactory.create(this.F));
        this.K = provider3;
        AdvertDetailsInteractorImpl_Factory create8 = AdvertDetailsInteractorImpl_Factory.create(this.d, this.e, this.E, this.l, this.G, this.H, this.i, this.I, this.J, provider3);
        this.L = create8;
        this.M = DoubleCheck.provider(create8);
        this.N = new DelegateFactory();
        a0 a0Var = new a0(advertFragmentDependencies);
        this.O = a0Var;
        CartInteractorImpl_Factory create9 = CartInteractorImpl_Factory.create(a0Var, this.l);
        this.P = create9;
        this.Q = DoubleCheck.provider(create9);
        MarketplaceResourceProviderImpl_Factory create10 = MarketplaceResourceProviderImpl_Factory.create(this.F);
        this.R = create10;
        this.S = DoubleCheck.provider(create10);
        this.T = InstanceFactory.create(viewModelStoreOwner);
        CartFabRepositoryImpl_Factory create11 = CartFabRepositoryImpl_Factory.create(this.O, this.l);
        this.U = create11;
        this.V = SingleCheck.provider(create11);
        a1 a1Var = new a1(advertFragmentDependencies);
        this.W = a1Var;
        CartFabPreferencesImpl_Factory create12 = CartFabPreferencesImpl_Factory.create(a1Var);
        this.X = create12;
        this.Y = SingleCheck.provider(create12);
        Factory createNullable2 = InstanceFactory.createNullable(str2);
        this.Z = createNullable2;
        AdvertFragmentModule_ProvideSearchContextWrapper$advert_details_releaseFactory create13 = AdvertFragmentModule_ProvideSearchContextWrapper$advert_details_releaseFactory.create(createNullable2);
        this.a0 = create13;
        c cVar = new c(create13);
        this.b0 = cVar;
        CartFabViewModelFactory_Factory create14 = CartFabViewModelFactory_Factory.create(this.i, this.V, this.Y, this.w, this.l, this.g, cVar);
        this.c0 = create14;
        Provider<CartFabViewModel> provider4 = SingleCheck.provider(CartFabModule_ProvideCartFabViewModelFactory.create(this.T, create14));
        this.d0 = provider4;
        MarketplacePresenterImpl_Factory create15 = MarketplacePresenterImpl_Factory.create(this.N, this.Q, this.l, this.S, provider4, this.A);
        this.e0 = create15;
        this.f0 = DoubleCheck.provider(create15);
        t tVar = new t(advertFragmentDependencies);
        this.g0 = tVar;
        this.h0 = DoubleCheck.provider(AdvertFragmentModule_ProvideAdvertActionIconFactory$advert_details_releaseFactory.create(tVar));
        this.i0 = new e1(advertFragmentDependencies);
        w wVar = new w(advertFragmentDependencies);
        this.j0 = wVar;
        AdvertMessengerInteractorImpl_Factory create16 = AdvertMessengerInteractorImpl_Factory.create(wVar, this.w, this.l);
        this.k0 = create16;
        this.l0 = DoubleCheck.provider(create16);
        u uVar = new u(advertFragmentDependencies);
        this.m0 = uVar;
        z zVar = new z(advertFragmentDependencies);
        this.n0 = zVar;
        w0 w0Var = new w0(advertFragmentDependencies);
        this.o0 = w0Var;
        this.p0 = new y(advertFragmentDependencies);
        this.q0 = new s(advertFragmentDependencies);
        AdvertContactsInteractorImpl_Factory create17 = AdvertContactsInteractorImpl_Factory.create(uVar, zVar, w0Var, this.w, PhoneNumberFormatterModule_ProvidePhoneNumberFormatterWithCountryCodeFactory.create(), this.p0, this.q0, this.i, this.l);
        this.r0 = create17;
        this.s0 = DoubleCheck.provider(create17);
        FeedbackInteractorImpl_Factory create18 = FeedbackInteractorImpl_Factory.create(this.e, this.l);
        this.t0 = create18;
        this.u0 = DoubleCheck.provider(create18);
        AdvertContactsResourceProviderImpl_Factory create19 = AdvertContactsResourceProviderImpl_Factory.create(this.F);
        this.v0 = create19;
        this.w0 = DoubleCheck.provider(create19);
        u0 u0Var = new u0(advertFragmentDependencies);
        this.x0 = u0Var;
        AdvertPriceFormatter_Factory create20 = AdvertPriceFormatter_Factory.create(u0Var);
        this.y0 = create20;
        this.z0 = DoubleCheck.provider(create20);
        AntiFraudPreferencesImpl_Factory create21 = AntiFraudPreferencesImpl_Factory.create(this.W);
        this.A0 = create21;
        this.B0 = DoubleCheck.provider(create21);
        FeedbackPreferencesImpl_Factory create22 = FeedbackPreferencesImpl_Factory.create(this.W);
        this.C0 = create22;
        this.D0 = DoubleCheck.provider(create22);
        this.E0 = DoubleCheck.provider(AdvertFragmentModule_ProvideSourceScreen$advert_details_releaseFactory.create());
        this.F0 = new t0(advertFragmentDependencies);
        this.G0 = new r(advertFragmentDependencies);
        this.H0 = new z0(advertFragmentDependencies);
        this.I0 = new n(advertFragmentDependencies);
        this.J0 = new m(advertFragmentDependencies);
        this.K0 = new f(advertFragmentDependencies);
        this.L0 = new j1(advertFragmentDependencies);
        this.M0 = new s0(advertFragmentDependencies);
        r0 r0Var = new r0(advertFragmentDependencies);
        this.N0 = r0Var;
        AdvertJobInteractorImpl_Factory create23 = AdvertJobInteractorImpl_Factory.create(r0Var);
        this.O0 = create23;
        Provider<AdvertJobInteractor> provider5 = DoubleCheck.provider(create23);
        this.P0 = provider5;
        AdvertContactsPresenterImpl_Factory create24 = AdvertContactsPresenterImpl_Factory.create(this.f0, this.h0, this.i0, this.l0, this.s0, this.A, this.u0, this.w, this.w0, this.z0, this.B0, this.D0, this.g, this.l, this.i, this.E0, this.F0, this.G0, this.W, this.H0, this.q0, this.I0, this.J0, this.K0, this.L0, this.M0, provider5);
        this.Q0 = create24;
        DelegateFactory.setDelegate(this.N, DoubleCheck.provider(create24));
        SimpleClickStreamLinkHandler_Factory create25 = SimpleClickStreamLinkHandler_Factory.create(this.g);
        this.R0 = create25;
        Provider<ClickStreamLinkHandler> provider6 = DoubleCheck.provider(create25);
        this.S0 = provider6;
        AdvertSafeDealPresenterImpl_Factory create26 = AdvertSafeDealPresenterImpl_Factory.create(this.d, this.Z, this.w, this.A, this.u0, this.g, this.i, provider6, this.D0, this.J0);
        this.T0 = create26;
        this.U0 = DoubleCheck.provider(create26);
        this.V0 = new p1(advertFragmentDependencies);
        DateTimeFormatterResourceProviderImpl_Factory create27 = DateTimeFormatterResourceProviderImpl_Factory.create(this.F);
        this.W0 = create27;
        DateTimeFormatterModule_ProvideUpperCaseDateTimeFormatterFactory create28 = DateTimeFormatterModule_ProvideUpperCaseDateTimeFormatterFactory.create(this.V0, create27, this.x0);
        this.X0 = create28;
        AdvertDetailsResourcesProviderImpl_Factory create29 = AdvertDetailsResourcesProviderImpl_Factory.create(create28, this.F);
        this.Y0 = create29;
        Provider<AdvertDetailsResourcesProvider> provider7 = DoubleCheck.provider(create29);
        this.Z0 = provider7;
        AdvertSellerProfilePresenterImpl_Factory create30 = AdvertSellerProfilePresenterImpl_Factory.create(provider7, this.i);
        this.a1 = create30;
        Provider<AdvertSellerProfilePresenter> provider8 = DoubleCheck.provider(create30);
        this.b1 = provider8;
        this.c1 = DoubleCheck.provider(AdvertFragmentModule_ProvideAdvertSellerPresenter$advert_details_releaseFactory.create(provider8, this.N, this.A));
        AdvertSharingEventTrackerImpl_Factory create31 = AdvertSharingEventTrackerImpl_Factory.create(this.g, this.w, this.l, this.i);
        this.d1 = create31;
        this.e1 = SingleCheck.provider(create31);
        this.f1 = new m0(advertFragmentDependencies);
        this.g1 = new j0(advertFragmentDependencies);
        this.h1 = new h0(advertFragmentDependencies);
        FavoriteAdvertsAnalyticsInteractorImpl_Factory create32 = FavoriteAdvertsAnalyticsInteractorImpl_Factory.create(this.g, this.w);
        this.i1 = create32;
        FavoriteAdvertsInteractorImpl_Factory create33 = FavoriteAdvertsInteractorImpl_Factory.create(this.f1, this.g1, this.h1, create32, this.l);
        this.j1 = create33;
        i0 i0Var = new i0(advertFragmentDependencies);
        this.k1 = i0Var;
        AdvertDetailsFavoriteInteractorImpl_Factory create34 = AdvertDetailsFavoriteInteractorImpl_Factory.create(create33, i0Var, this.l);
        this.l1 = create34;
        this.m1 = DoubleCheck.provider(create34);
        this.n1 = new u1(advertFragmentDependencies);
        this.o1 = new v1(advertFragmentDependencies);
        this.p1 = SingleCheck.provider(ViewedAdvertsModule_ProvideViewedAdvertsInteractorFactory.create(ViewedAdvertsInteractorFactoryImpl_Factory.create(), this.n1, this.l, this.o1, this.i));
        ErrorFormatterImpl_Factory create35 = ErrorFormatterImpl_Factory.create(this.F);
        this.q1 = create35;
        this.r1 = DoubleCheck.provider(create35);
        this.s1 = new x0(advertFragmentDependencies);
        this.t1 = new o(advertFragmentDependencies);
        Factory createNullable3 = InstanceFactory.createNullable(kundle4);
        this.u1 = createNullable3;
        AdvertDetailsToolbarPresenterImpl_Factory create36 = AdvertDetailsToolbarPresenterImpl_Factory.create(this.e1, this.m1, this.p1, this.r1, this.l, this.Z0, this.A, this.W, this.s1, this.w, this.t1, this.i, createNullable3);
        this.v1 = create36;
        this.w1 = DoubleCheck.provider(create36);
        AdvertSimilarPresenterResourceProviderImpl_Factory create37 = AdvertSimilarPresenterResourceProviderImpl_Factory.create(this.F);
        this.x1 = create37;
        this.y1 = DoubleCheck.provider(create37);
        this.z1 = SingleCheck.provider(SerpItemConverterModule_ProvideItemAdvertSpanCountProviderFactory.create(this.F));
        Provider<AdvertSpanCountProvider> provider9 = SingleCheck.provider(SerpItemConverterModule_ProvideBigAdvertSpanCountProviderFactory.create(this.F));
        this.A1 = provider9;
        Provider<SerpAdvertConverter> provider10 = SingleCheck.provider(SerpItemConverterModule_ProvideAdvertConverterFactory.create(this.z1, provider9, this.F, this.i));
        this.B1 = provider10;
        SectionInsideItemsConverterImpl_Factory create38 = SectionInsideItemsConverterImpl_Factory.create(provider10);
        this.C1 = create38;
        this.D1 = SingleCheck.provider(create38);
        this.E1 = SingleCheck.provider(SellerCarouselItemConverterImpl_Factory.create());
        this.F1 = SingleCheck.provider(SerpItemConverterModule_ProvideFavoriteStatusResolverFactory.create(this.j1));
        Provider<ViewedStatusResolver> provider11 = SingleCheck.provider(ViewedAdvertsModule_ProvideViewedStatusResolverFactory.create(this.p1));
        this.G1 = provider11;
        SectionItemConverterImpl_Factory create39 = SectionItemConverterImpl_Factory.create(this.D1, this.E1, this.F1, provider11, this.l, this.i);
        this.H1 = create39;
        this.I1 = SingleCheck.provider(create39);
        Provider<AdResourceProvider> provider12 = DoubleCheck.provider(RdsAdResourceProviderImpl_Factory.create());
        this.J1 = provider12;
        f1 f1Var = new f1(advertFragmentDependencies);
        this.K1 = f1Var;
        Provider<SerpCommercialBannerConverter> provider13 = DoubleCheck.provider(AdvertFragmentModule_ProvideCommercialConverterFactory.create(this.F, provider12, f1Var));
        this.L1 = provider13;
        AdvertCommercialsConverterImpl_Factory create40 = AdvertCommercialsConverterImpl_Factory.create(provider13);
        this.M1 = create40;
        this.N1 = DoubleCheck.provider(create40);
        w1 w1Var = new w1(screenAnalyticsDependencies);
        this.O1 = w1Var;
        x1 x1Var = new x1(screenAnalyticsDependencies);
        this.P1 = x1Var;
        r1 r1Var = new r1(advertFragmentDependencies);
        this.Q1 = r1Var;
        AdvertDetailsTrackerImpl_Factory create41 = AdvertDetailsTrackerImpl_Factory.create(w1Var, x1Var, r1Var, this.g);
        this.R1 = create41;
        Provider<AdvertDetailsTracker> provider14 = DoubleCheck.provider(create41);
        this.S1 = provider14;
        AdvertComplementaryPresenterImpl_Factory create42 = AdvertComplementaryPresenterImpl_Factory.create(this.y1, this.I1, this.N1, provider14, this.i);
        this.T1 = create42;
        this.U1 = DoubleCheck.provider(create42);
        this.V1 = InstanceFactory.create(num);
        this.W1 = DoubleCheck.provider(this.y0);
        AdvertOldPriceFormatter_Factory create43 = AdvertOldPriceFormatter_Factory.create(this.x0);
        this.X1 = create43;
        this.Y1 = DoubleCheck.provider(create43);
        this.Z1 = SingleCheck.provider(AttributedTextFormatterModule_ProvideAttributedTextFormatterFactory.create());
        this.f16a2 = DoubleCheck.provider(IdProviderImpl_Factory.create());
        k0 k0Var = new k0(advertFragmentDependencies);
        this.b2 = k0Var;
        l0 l0Var = new l0(advertFragmentDependencies);
        this.c2 = l0Var;
        SellerSubscriptionInteractorImpl_Factory create44 = SellerSubscriptionInteractorImpl_Factory.create(k0Var, this.s1, this.l, l0Var, this.i);
        this.d2 = create44;
        this.e2 = DoubleCheck.provider(create44);
        SellerSubscriptionResourceProviderImpl_Factory create45 = SellerSubscriptionResourceProviderImpl_Factory.create(this.F);
        this.f2 = create45;
        this.g2 = DoubleCheck.provider(create45);
        this.h2 = DoubleCheck.provider(AdvertDetailsSellerSubscriptionModule_ProvideRelayFactory.create());
        Provider<CompositeSnackbarPresenter> provider15 = SingleCheck.provider(CompositeSnackbarModule_ProvideCompositeSnackbarPresenterFactory.create());
        this.i2 = provider15;
        SellerSubscriptionPresenterImpl_Factory create46 = SellerSubscriptionPresenterImpl_Factory.create(this.e2, this.l, this.s1, this.g2, this.r1, this.h2, provider15, this.g);
        this.j2 = create46;
        this.k2 = DoubleCheck.provider(create46);
        this.l2 = InstanceFactory.createNullable(advertDetailsFastOpenParams);
        this.m2 = InstanceFactory.create(bool);
        this.n2 = DoubleCheck.provider(AdvertDetailsImvBadgeItemConverterImpl_Factory.create());
        this.o2 = new j(advertFragmentDependencies);
        this.p2 = new l(advertFragmentDependencies);
        AdvertDetailsItemsPresenterImpl_Factory create47 = AdvertDetailsItemsPresenterImpl_Factory.create(this.Z, this.d, this.V1, this.N, this.U1, this.y1, this.W1, this.Y1, this.Z1, this.Z0, this.f16a2, this.A, this.i, this.k2, this.s1, this.w, this.l2, this.t1, CommonAdvertDetailsFeatureTeaserItemsAdapter_Factory.create(), this.m2, this.n2, this.o2, this.p2);
        this.q2 = create47;
        this.r2 = DoubleCheck.provider(create47);
        this.s2 = InstanceFactory.create(l10);
        this.t2 = ClipboardModule_ProvideClipboardManager$android_releaseFactory.create(this.g0);
        AdvertSellerStatusInteractorImpl_Factory create48 = AdvertSellerStatusInteractorImpl_Factory.create(this.e, this.l);
        this.u2 = create48;
        Provider<AdvertSellerStatusInteractor> provider16 = DoubleCheck.provider(create48);
        this.v2 = provider16;
        SellerStatusProviderImpl_Factory create49 = SellerStatusProviderImpl_Factory.create(provider16, this.F);
        this.w2 = create49;
        this.x2 = DoubleCheck.provider(create49);
        Provider<FavoriteAdvertsResourceProvider> provider17 = SingleCheck.provider(FavoriteAdvertsPresenterModule_ProvideFavoriteAdvertsResourceProvider$favorite_core_releaseFactory.create(this.F));
        this.y2 = provider17;
        this.z2 = SingleCheck.provider(FavoriteAdvertsPresenterModule_ProvideFavoriteAdvertsPresenter$favorite_core_releaseFactory.create(this.j1, this.l, provider17));
        this.A2 = new v(advertFragmentDependencies);
        this.B2 = new i1(advertFragmentDependencies);
        this.C2 = new t1(advertFragmentDependencies);
        this.D2 = InstanceFactory.createNullable(kundle);
        Factory createNullable4 = InstanceFactory.createNullable(autotekaDetailsResponse);
        this.E2 = createNullable4;
        AutotekaDetailsInteractorImpl_Factory create50 = AutotekaDetailsInteractorImpl_Factory.create(this.d, this.A2, this.B2, this.C2, this.D2, createNullable4);
        this.F2 = create50;
        Provider<AutotekaDetailsInteractor> provider18 = DoubleCheck.provider(create50);
        this.G2 = provider18;
        AdvertDetailsAutotekaPresenterImpl_Factory create51 = AdvertDetailsAutotekaPresenterImpl_Factory.create(this.d, provider18, this.l, this.g, this.A, this.i);
        this.H2 = create51;
        this.I2 = DoubleCheck.provider(create51);
        Factory createNullable5 = InstanceFactory.createNullable(kundle2);
        this.J2 = createNullable5;
        AutotekaTeaserInteractorImpl_Factory create52 = AutotekaTeaserInteractorImpl_Factory.create(this.A2, this.B2, this.C2, createNullable5);
        this.K2 = create52;
        Provider<AutotekaTeaserInteractor> provider19 = DoubleCheck.provider(create52);
        this.L2 = provider19;
        o1 o1Var = new o1(advertFragmentDependencies);
        this.M2 = o1Var;
        e eVar = new e(advertFragmentDependencies);
        this.N2 = eVar;
        AdvertDetailsAutotekaTeaserPresenterImpl_Factory create53 = AdvertDetailsAutotekaTeaserPresenterImpl_Factory.create(this.d, provider19, this.l, this.g, this.A, this.i, o1Var, eVar);
        this.O2 = create53;
        this.P2 = DoubleCheck.provider(create53);
        AdvertDetailsNotePresenterImpl_Factory create54 = AdvertDetailsNotePresenterImpl_Factory.create(this.l, this.A);
        this.Q2 = create54;
        this.R2 = DoubleCheck.provider(create54);
        d0 d0Var = new d0(advertFragmentDependencies);
        this.S2 = d0Var;
        AdvertDetailsShortTermRentPresenterImpl_Factory create55 = AdvertDetailsShortTermRentPresenterImpl_Factory.create(this.d, this.g, this.A, d0Var, this.i);
        this.T2 = create55;
        this.U2 = DoubleCheck.provider(create55);
        Factory create56 = InstanceFactory.create(publishRelay);
        this.V2 = create56;
        this.W2 = DoubleCheck.provider(create56);
        this.X2 = new p(advertFragmentDependencies);
        this.Y2 = InstanceFactory.createNullable(bundle3);
        QuestionnaireStorageImpl_Factory create57 = QuestionnaireStorageImpl_Factory.create(this.W);
        this.Z2 = create57;
        Provider<QuestionnaireStorage> provider20 = DoubleCheck.provider(create57);
        this.a3 = provider20;
        QuestionnairePresenterImpl_Factory create58 = QuestionnairePresenterImpl_Factory.create(this.Y2, provider20);
        this.b3 = create58;
        this.c3 = DoubleCheck.provider(create58);
        MarketplaceDeliveryStorageImpl_Factory create59 = MarketplaceDeliveryStorageImpl_Factory.create(this.W);
        this.d3 = create59;
        this.e3 = DoubleCheck.provider(create59);
        AdvertDetailsPresenterImpl_Factory create60 = AdvertDetailsPresenterImpl_Factory.create(this.M, this.N, this.U0, this.c1, this.f0, this.w1, this.U1, this.r2, this.w, this.d, this.Z, this.l2, this.s2, this.i0, this.t2, ClipDataFactoryImpl_Factory.create(), this.l, this.x2, this.z2, this.I2, this.P2, this.R2, this.U2, this.m1, this.A, this.S1, this.g, this.W, this.s1, this.W2, this.c2, this.X2, this.c3, this.e3, this.i2, this.i, this.N2);
        this.f3 = create60;
        this.g3 = DoubleCheck.provider(create60);
        this.h3 = DoubleCheck.provider(AdditionalSellerPresenterImpl_Factory.create());
        g gVar = new g(advertFragmentDependencies);
        this.i3 = gVar;
        AdvertDeliveryPresenterImpl_Factory create61 = AdvertDeliveryPresenterImpl_Factory.create(this.d, this.S2, gVar, this.w, this.A, this.g, this.i);
        this.j3 = create61;
        this.k3 = DoubleCheck.provider(create61);
        this.l3 = SingleCheck.provider(SectionTitleItemPresenterImpl_Factory.create());
        Factory createNullable6 = InstanceFactory.createNullable(bundle);
        this.m3 = createNullable6;
        SectionItemPresenterImpl_Factory create62 = SectionItemPresenterImpl_Factory.create(this.l3, this.g, createNullable6);
        this.n3 = create62;
        this.o3 = SingleCheck.provider(create62);
        this.p3 = SingleCheck.provider(AdvertItemPresenterModule_ProvideRdsRecommendationAdvertItemPresenterFactory.create(this.g3, this.g, this.i));
        this.q3 = new f0(advertFragmentDependencies);
        ComplementaryResourceProviderImpl_Factory create63 = ComplementaryResourceProviderImpl_Factory.create(this.F);
        this.r3 = create63;
        Provider<SectionResourceProvider> provider21 = SingleCheck.provider(create63);
        this.s3 = provider21;
        this.t3 = SingleCheck.provider(SectionAdvertItemsModule_ProvideComplementarySectionItemWidthProvider$serp_core_releaseFactory.create(this.q3, provider21));
        c1 c1Var = new c1(advertFragmentDependencies);
        this.u3 = c1Var;
        b1 b1Var = new b1(advertFragmentDependencies);
        this.v3 = b1Var;
        SerpItemAbViewConfig_Factory create64 = SerpItemAbViewConfig_Factory.create(c1Var, b1Var);
        this.w3 = create64;
        b0 b0Var = new b0(advertFragmentDependencies);
        this.x3 = b0Var;
        ComplementaryAdvertItemBlueprintImpl_Factory create65 = ComplementaryAdvertItemBlueprintImpl_Factory.create(this.p3, this.V0, this.x0, this.t3, create64, b0Var);
        this.y3 = create65;
        this.z3 = SingleCheck.provider(create65);
        SectionResourceProviderImpl_Factory create66 = SectionResourceProviderImpl_Factory.create(this.F);
        this.A3 = create66;
        Provider<SectionResourceProvider> provider22 = SingleCheck.provider(create66);
        this.B3 = provider22;
        Provider<SectionItemWidthProvider> provider23 = SingleCheck.provider(SectionAdvertItemsModule_ProvideSectionItemWidthProvider$serp_core_releaseFactory.create(this.q3, provider22));
        this.C3 = provider23;
        ComplementaryAdvertItemDoubleBlueprintImpl_Factory create67 = ComplementaryAdvertItemDoubleBlueprintImpl_Factory.create(this.p3, this.V0, this.x0, provider23, this.w3, this.x3);
        this.D3 = create67;
        Provider<ComplementaryAdvertItemDoubleBlueprint> provider24 = SingleCheck.provider(create67);
        this.E3 = provider24;
        Provider<ItemBinder> provider25 = SingleCheck.provider(SectionAdvertItemsModule_ProvideComplementarySectionItemBinder$serp_core_releaseFactory.create(this.z3, provider24));
        this.F3 = provider25;
        this.G3 = SectionAdvertItemsModule_ProvideComplementaryTypeAdapterPresenter$serp_core_releaseFactory.create(provider25);
        this.H3 = FavoriteAdvertsPresenterImpl_Factory.create(this.j1, this.y2, this.l);
        ViewedAdvertsPresenterImpl_Factory create68 = ViewedAdvertsPresenterImpl_Factory.create(this.o1, this.l);
        this.I3 = create68;
        this.J3 = ComplementarySectionBlueprint_Factory.create(this.o3, this.G3, this.H3, create68, this.F3);
        Provider<SectionActionPresenter> provider26 = SingleCheck.provider(SectionActionPresenterImpl_Factory.create());
        this.K3 = provider26;
        SectionTitleWithActionPresenterImpl_Factory create69 = SectionTitleWithActionPresenterImpl_Factory.create(this.l3, provider26);
        this.L3 = create69;
        Provider<SectionTitleWithActionPresenter> provider27 = SingleCheck.provider(create69);
        this.M3 = provider27;
        this.N3 = ComplementaryTitleWithActionBlueprint_Factory.create(provider27);
        ExpandSectionsButtonPresenterImpl_Factory create70 = ExpandSectionsButtonPresenterImpl_Factory.create(this.l3, this.K3, this.r2);
        this.O3 = create70;
        Provider<ExpandSectionsButtonPresenter> provider28 = SingleCheck.provider(create70);
        this.P3 = provider28;
        this.Q3 = ComplementaryExpandSectionsButtonBlueprint_Factory.create(provider28);
        this.R3 = RdsNotLoadAdStubBlueprint_Factory.create(NotLoadAdStubPresenter_Factory.create());
        Provider<EmptyAdStubItemPresenter> provider29 = DoubleCheck.provider(EmptyAdStubItemPresenterImpl_Factory.create());
        this.S3 = provider29;
        this.T3 = RdsEmptyAdStubItemBlueprint_Factory.create(provider29);
        y0 y0Var = new y0(advertFragmentDependencies);
        this.U3 = y0Var;
        YandexContentItemPresenterImpl_Factory create71 = YandexContentItemPresenterImpl_Factory.create(this.g3, this.g, y0Var);
        this.V3 = create71;
        Provider<YandexContentItemPresenter> provider30 = DoubleCheck.provider(create71);
        this.W3 = provider30;
        this.X3 = RdsYandexContentBigBlueprint_Factory.create(provider30);
        YandexAppInstallItemPresenterImpl_Factory create72 = YandexAppInstallItemPresenterImpl_Factory.create(this.g3, this.g);
        this.Y3 = create72;
        Provider<YandexAppInstallItemPresenter> provider31 = DoubleCheck.provider(create72);
        this.Z3 = provider31;
        this.a4 = RdsYandexAppInstallBigBlueprint_Factory.create(provider31);
        AdfoxImageItemPresenterImpl_Factory create73 = AdfoxImageItemPresenterImpl_Factory.create(this.g3, this.g, this.U3);
        this.b4 = create73;
        Provider<AdfoxImageItemPresenter> provider32 = DoubleCheck.provider(create73);
        this.c4 = provider32;
        this.d4 = RdsAdfoxBigBlueprint_Factory.create(provider32);
        Provider<DfpDebugPresenter> provider33 = DoubleCheck.provider(DfpDebugPresenterImpl_Factory.create());
        this.e4 = provider33;
        DfpUnifiedPresenterImpl_Factory create74 = DfpUnifiedPresenterImpl_Factory.create(this.g3, provider33, this.l);
        this.f4 = create74;
        Provider<DfpUnifiedPresenter> provider34 = DoubleCheck.provider(create74);
        this.g4 = provider34;
        this.h4 = RdsDfpUnifiedBlueprint_Factory.create(provider34);
        DfpContentPresenterImpl_Factory create75 = DfpContentPresenterImpl_Factory.create(this.g3, this.e4);
        this.i4 = create75;
        Provider<DfpContentPresenter> provider35 = DoubleCheck.provider(create75);
        this.j4 = provider35;
        this.k4 = RdsDfpContentBlueprint_Factory.create(provider35);
        DfpAppInstallPresenterImpl_Factory create76 = DfpAppInstallPresenterImpl_Factory.create(this.g3, this.e4);
        this.l4 = create76;
        Provider<DfpAppInstallPresenter> provider36 = DoubleCheck.provider(create76);
        this.m4 = provider36;
        this.n4 = RdsDfpAppInstallBlueprint_Factory.create(provider36);
        MyTargetContentPresenterImpl_Factory create77 = MyTargetContentPresenterImpl_Factory.create(this.g3, this.o, this.i);
        this.o4 = create77;
        Provider<MyTargetContentPresenter> provider37 = DoubleCheck.provider(create77);
        this.p4 = provider37;
        this.q4 = RdsMyTargetContentBlueprint_Factory.create(provider37);
        MyTargetAppInstallPresenterImpl_Factory create78 = MyTargetAppInstallPresenterImpl_Factory.create(this.g3, this.o, this.i);
        this.r4 = create78;
        Provider<MyTargetAppInstallPresenter> provider38 = DoubleCheck.provider(create78);
        this.s4 = provider38;
        this.t4 = RdsMyTargetAppInstallBlueprint_Factory.create(provider38);
        Provider<AdvertDetailsTitlePresenter> provider39 = DoubleCheck.provider(AdvertDetailsTitlePresenterImpl_Factory.create());
        this.u4 = provider39;
        this.v4 = AdvertDetailsTitleBlueprint_Factory.create(provider39);
        Factory create79 = InstanceFactory.create(advertDetailsFragmentDelegate);
        this.w4 = create79;
        AdvertDetailsGalleryPresenterImpl_Factory create80 = AdvertDetailsGalleryPresenterImpl_Factory.create(this.g3, this.r2, create79);
        this.x4 = create80;
        Provider<AdvertDetailsGalleryPresenter> provider40 = DoubleCheck.provider(create80);
        this.y4 = provider40;
        q0 q0Var = new q0(advertFragmentDependencies);
        this.z4 = q0Var;
        this.A4 = AdvertDetailsGalleryBlueprint_Factory.create(provider40, q0Var, this.g, this.i);
        Provider<AdvertDetailsPricePresenter> provider41 = DoubleCheck.provider(AdvertDetailsPricePresenterImpl_Factory.create());
        this.B4 = provider41;
        this.C4 = AdvertDetailsPriceBlueprint_Factory.create(provider41);
        this.D4 = TitleItemBlueprint_Factory.create(TitleItemPresenter_Factory.create());
        this.E4 = DiscountItemBlueprint_Factory.create(DiscountItemPresenter_Factory.create());
        this.F4 = DividerItemBlueprint_Factory.create(DividerItemPresenter_Factory.create());
        this.G4 = InformationItemBlueprint_Factory.create(InformationItemPresenter_Factory.create());
        ContactItemPresenter_Factory create81 = ContactItemPresenter_Factory.create(this.N);
        this.H4 = create81;
        ContactItemBlueprint_Factory create82 = ContactItemBlueprint_Factory.create(create81, this.i);
        this.I4 = create82;
        Provider<ItemBinder> provider42 = DoubleCheck.provider(AdvertDiscountDetailsModule_ProvideItemBinderFactory.create(this.D4, this.E4, this.F4, this.G4, create82));
        this.J4 = provider42;
        Provider<AdapterPresenter> provider43 = DoubleCheck.provider(AdvertDiscountDetailsModule_ProvideAdapterPresenterFactory.create(provider42));
        this.K4 = provider43;
        this.L4 = DoubleCheck.provider(AdvertDiscountDetailsModule_ProvideAdapterFactory.create(provider43, this.J4));
        Provider<AdvertDiscountItemConverter> provider44 = DoubleCheck.provider(AdvertDiscountItemConverterImpl_Factory.create());
        this.M4 = provider44;
        AdvertDiscountDetailsDialogPresenterImpl_Factory create83 = AdvertDiscountDetailsDialogPresenterImpl_Factory.create(this.K4, provider44);
        this.N4 = create83;
        Provider<AdvertDiscountDetailsDialogPresenter> provider45 = DoubleCheck.provider(create83);
        this.O4 = provider45;
        AdvertDiscountDetailsDialogImpl_Factory create84 = AdvertDiscountDetailsDialogImpl_Factory.create(this.L4, provider45);
        this.P4 = create84;
        Provider<AdvertDiscountDetailsDialog> provider46 = DoubleCheck.provider(create84);
        this.Q4 = provider46;
        PriceWithDiscountPresenterImpl_Factory create85 = PriceWithDiscountPresenterImpl_Factory.create(this.d, provider46, this.g);
        this.R4 = create85;
        Provider<PriceWithDiscountPresenter> provider47 = DoubleCheck.provider(create85);
        this.S4 = provider47;
        this.T4 = PriceWithDiscountBlueprint_Factory.create(provider47);
        Provider<AdvertDetailsPriceMarketplacePresenter> provider48 = DoubleCheck.provider(AdvertDetailsPriceMarketplacePresenterImpl_Factory.create());
        this.U4 = provider48;
        this.V4 = AdvertDetailsPriceMarketplaceBlueprint_Factory.create(provider48);
        Provider<AdvertDetailsPriceSubscriptionPresenter> provider49 = DoubleCheck.provider(AdvertDetailsPriceSubscriptionPresenterImpl_Factory.create());
        this.W4 = provider49;
        this.X4 = AdvertDetailsPriceSubscriptionBlueprint_Factory.create(provider49);
        Provider<SimilarsLoaderItemPresenter> provider50 = DoubleCheck.provider(SimilarsLoaderItemPresenterImpl_Factory.create());
        this.Y4 = provider50;
        this.Z4 = SimilarsLoaderItemBlueprint_Factory.create(provider50);
        Provider<RdsAdvertItemPresenter> provider51 = SingleCheck.provider(AdvertItemPresenterModule_ProvideRdsAdvertItemPresenterFactory.create(this.g3, this.g, this.i));
        this.a5 = provider51;
        this.b5 = SingleCheck.provider(AdvertItemModule_ProvideRdsAdvertGridItemBlueprintFactory.create(provider51, this.V0, this.x0, this.w3, this.x3));
        Provider<AdvertDetailsDisclaimerPresenter> provider52 = DoubleCheck.provider(AdvertDetailsDisclaimerPresenterImpl_Factory.create());
        this.c5 = provider52;
        this.d5 = AdvertDetailsDisclaimerBlueprint_Factory.create(provider52);
        Provider<AdvertDetailsDescriptionPresenter> provider53 = DoubleCheck.provider(AdvertDetailsDescriptionPresenterImpl_Factory.create());
        this.e5 = provider53;
        this.f5 = AdvertDetailsDescriptionBlueprint_Factory.create(provider53);
        Provider<AdvertDetailsAddressPresenter> provider54 = DoubleCheck.provider(AdvertDetailsAddressPresenterImpl_Factory.create());
        this.g5 = provider54;
        this.h5 = AdvertDetailsAddressBlueprint_Factory.create(provider54);
        Provider<AdvertDetailsGroupsPresenter> provider55 = DoubleCheck.provider(AdvertDetailsGroupsPresenterImpl_Factory.create());
        this.i5 = provider55;
        this.j5 = AdvertDetailsGroupsBlueprint_Factory.create(provider55, this.g3);
        Provider<AdvertDetailsFlatsPresenter> provider56 = DoubleCheck.provider(AdvertDetailsFlatsPresenterImpl_Factory.create());
        this.k5 = provider56;
        this.l5 = AdvertDetailsFlatsBlueprint_Factory.create(provider56, this.g3);
        this.m5 = AdvertDetailsAutotekaBlueprint_Factory.create(this.I2);
        this.n5 = AdvertDetailsAutotekaTeaserBlueprint_Factory.create(this.P2);
        AdvertDetailsAutodealPresenterImpl_Factory create86 = AdvertDetailsAutodealPresenterImpl_Factory.create(this.g3);
        this.o5 = create86;
        Provider<AdvertDetailsAutodealPresenter> provider57 = DoubleCheck.provider(create86);
        this.p5 = provider57;
        this.q5 = AdvertDetailsAutodealBlueprint_Factory.create(provider57);
        this.r5 = AdvertDetailsNoteBlueprint_Factory.create(this.R2);
        AdvertDetailsAutoCatalogPresenterImpl_Factory create87 = AdvertDetailsAutoCatalogPresenterImpl_Factory.create(this.A, this.Z0);
        this.s5 = create87;
        Provider<AdvertDetailsAutoCatalogPresenter> provider58 = DoubleCheck.provider(create87);
        this.t5 = provider58;
        this.u5 = AdvertDetailsAutoCatalogBlueprint_Factory.create(provider58);
        AdvertDetailsSellerProfilePresenterImpl_Factory create88 = AdvertDetailsSellerProfilePresenterImpl_Factory.create(this.c1);
        this.v5 = create88;
        Provider<AdvertDetailsSellerProfilePresenter> provider59 = DoubleCheck.provider(create88);
        this.w5 = provider59;
        this.x5 = AdvertDetailsSellerProfileBlueprint_Factory.create(provider59);
        AdvertDetailsSellerSubscriptionPresenterImpl_Factory create89 = AdvertDetailsSellerSubscriptionPresenterImpl_Factory.create(this.h2);
        this.y5 = create89;
        Provider<AdvertDetailsSellerSubscriptionPresenter> provider60 = DoubleCheck.provider(create89);
        this.z5 = provider60;
        this.A5 = AdvertDetailsSellerSubscriptionBlueprint_Factory.create(provider60, this.g2);
        this.B5 = AdditionalSellerBlueprint_Factory.create(this.h3, this.g3);
        Provider<AdvertDetailsAnonymousNumberPresenter> provider61 = DoubleCheck.provider(AdvertDetailsAnonymousNumberPresenterImpl_Factory.create());
        this.C5 = provider61;
        this.D5 = AdvertDetailsAnonymousNumberBlueprint_Factory.create(provider61);
        Provider<AdvertDetailsAdvertNumberPresenter> provider62 = DoubleCheck.provider(AdvertDetailsAdvertNumberPresenterImpl_Factory.create());
        this.E5 = provider62;
        this.F5 = AdvertDetailsAdvertNumberBlueprint_Factory.create(provider62);
        AdvertDetailsAbusePresenterImpl_Factory create90 = AdvertDetailsAbusePresenterImpl_Factory.create(this.g3);
        this.G5 = create90;
        Provider<AdvertDetailsAbusePresenter> provider63 = DoubleCheck.provider(create90);
        this.H5 = provider63;
        this.I5 = AdvertDetailsAbuseBlueprint_Factory.create(provider63);
        AdvertDetailsDeliveryActionsPresenterImpl_Factory create91 = AdvertDetailsDeliveryActionsPresenterImpl_Factory.create(this.k3);
        this.J5 = create91;
        Provider<AdvertDetailsDeliveryActionsPresenter> provider64 = DoubleCheck.provider(create91);
        this.K5 = provider64;
        this.L5 = AdvertDetailsDeliveryActionsBlueprint_Factory.create(provider64);
        this.M5 = new e0(advertFragmentDependencies);
        Provider<PublishRelay<AdvertDeliveryC2C>> provider65 = SingleCheck.provider(AdvertDeliveryBlockModule_ProvideAdvertDeliveryBlockDataObservableFactory.create());
        this.N5 = provider65;
        AdvertDeliveryBlockRepositoryImpl_Factory create92 = AdvertDeliveryBlockRepositoryImpl_Factory.create(this.d, this.M5, this.l, this.C2, provider65);
        this.O5 = create92;
        Provider<AdvertDeliveryBlockRepository> provider66 = SingleCheck.provider(create92);
        this.P5 = provider66;
        AdvertDeliveryBlockViewModelFactory_Factory create93 = AdvertDeliveryBlockViewModelFactory_Factory.create(provider66, this.l, this.Z1);
        this.Q5 = create93;
        this.R5 = SingleCheck.provider(create93);
        Factory create94 = InstanceFactory.create(lifecycleOwner);
        this.S5 = create94;
        Provider<AdvertDeliveryBlockViewModel> provider67 = SingleCheck.provider(AdvertDeliveryBlockModule_ProvideAdvertDeliveryBlockViewModelFactory.create(this.R5, create94));
        this.T5 = provider67;
        AdvertDetailsDeliveryInfoPresenterImpl_Factory create95 = AdvertDetailsDeliveryInfoPresenterImpl_Factory.create(provider67, this.N5);
        this.U5 = create95;
        Provider<AdvertDetailsDeliveryInfoPresenter> provider68 = DoubleCheck.provider(create95);
        this.V5 = provider68;
        this.W5 = AdvertDetailsDeliveryInfoBlueprint_Factory.create(provider68);
        Provider<AdvertDetailsConsultationPresenter> provider69 = DoubleCheck.provider(AdvertDetailsConsultationPresenterImpl_Factory.create());
        this.X5 = provider69;
        this.Y5 = AdvertDetailsConsultationBlueprint_Factory.create(provider69);
        this.Z5 = AdvertDetailsShortTermRentBlueprint_Factory.create(this.U2);
        AdvertDetailsContactBarPresenterImpl_Factory create96 = AdvertDetailsContactBarPresenterImpl_Factory.create(this.N);
        this.a6 = create96;
        Provider<AdvertDetailsContactBarPresenter> provider70 = DoubleCheck.provider(create96);
        this.b6 = provider70;
        this.c6 = AdvertDetailsContactBarBlueprint_Factory.create(provider70, this.i);
        Provider<AdvertDetailsGapPresenter> provider71 = DoubleCheck.provider(AdvertDetailsGapPresenterImpl_Factory.create());
        this.d6 = provider71;
        this.e6 = AdvertDetailsGapBlueprint_Factory.create(provider71);
        Provider<AdvertDetailsDividerPresenter> provider72 = DoubleCheck.provider(AdvertDetailsDividerPresenterImpl_Factory.create());
        this.f6 = provider72;
        this.g6 = AdvertDetailsDividerBlueprint_Factory.create(provider72);
        Provider<AdvertDetailsGeoReferencePresenter> provider73 = DoubleCheck.provider(AdvertDetailsGeoReferencePresenterImpl_Factory.create());
        this.h6 = provider73;
        this.i6 = AdvertDetailsGeoReferenceBlueprint_Factory.create(provider73);
        Provider<AdvertDetailsSkeletonPresenter> provider74 = DoubleCheck.provider(AdvertDetailsSkeletonPresenterImpl_Factory.create());
        this.j6 = provider74;
        this.k6 = AdvertDetailsSkeletonBlueprint_Factory.create(provider74);
        this.f19l6 = AdvertDetailsTitleSkeletonBlueprint_Factory.create(this.j6);
        AdvertDetailsSimilarsButtonPresenterImpl_Factory create97 = AdvertDetailsSimilarsButtonPresenterImpl_Factory.create(this.g3);
        this.f20m6 = create97;
        Provider<AdvertDetailsSimilarsButtonPresenter> provider75 = DoubleCheck.provider(create97);
        this.f21n6 = provider75;
        this.f22o6 = AdvertDetailsSimilarsButtonBlueprint_Factory.create(provider75);
        Provider<AdvertDetailsClosingReasonPresenter> provider76 = DoubleCheck.provider(AdvertDetailsClosingReasonPresenterImpl_Factory.create());
        this.f23p6 = provider76;
        this.f24q6 = AdvertDetailsClosingReasonBlueprint_Factory.create(provider76);
        AdvertDetailsShowDescriptionPresenterImpl_Factory create98 = AdvertDetailsShowDescriptionPresenterImpl_Factory.create(this.g3);
        this.f25r6 = create98;
        Provider<AdvertDetailsShowDescriptionPresenter> provider77 = DoubleCheck.provider(create98);
        this.f26s6 = provider77;
        this.f27t6 = AdvertDetailsShowDescriptionBlueprint_Factory.create(provider77);
        Provider<AdvertDetailsShowOnMapPresenter> provider78 = DoubleCheck.provider(AdvertDetailsShowOnMapPresenterImpl_Factory.create());
        this.f28u6 = provider78;
        this.f29v6 = AdvertDetailsShowOnMapBlueprint_Factory.create(provider78);
        Provider<AdvertDetailsRatingPublishPresenter> provider79 = DoubleCheck.provider(AdvertDetailsRatingPublishPresenterImpl_Factory.create());
        this.f30w6 = provider79;
        this.f31x6 = AdvertDetailsRatingPublishBlueprint_Factory.create(provider79);
        Provider<PromoCardItemPresenter> provider80 = DoubleCheck.provider(PromoCardModule_GetPresenter$advert_details_releaseFactory.create(this.g));
        this.f32y6 = provider80;
        this.f33z6 = DoubleCheck.provider(PromoCardModule_GetBlueprintFactory.create(provider80));
        AdvertBadgeBarPresenterImpl_Factory create99 = AdvertBadgeBarPresenterImpl_Factory.create(this.A);
        this.A6 = create99;
        Provider<AdvertBadgeBarPresenter> provider81 = DoubleCheck.provider(create99);
        this.B6 = provider81;
        AdvertBadgeBarBlueprint_Factory create100 = AdvertBadgeBarBlueprint_Factory.create(provider81);
        this.C6 = create100;
        this.D6 = DoubleCheck.provider(create100);
        CreditInfoResourcesProviderImpl_Factory create101 = CreditInfoResourcesProviderImpl_Factory.create(this.F);
        this.E6 = create101;
        this.F6 = DoubleCheck.provider(create101);
        this.G6 = new l1(advertFragmentDependencies);
        m1 m1Var = new m1(advertFragmentDependencies);
        this.H6 = m1Var;
        SravniEventTrackerImpl_Factory create102 = SravniEventTrackerImpl_Factory.create(m1Var, this.v);
        this.I6 = create102;
        Provider<SravniEventTracker> provider82 = DoubleCheck.provider(create102);
        this.J6 = provider82;
        this.K6 = AdvertDetailsCreditInfoPresenterImpl_Factory.create(this.F6, this.G6, provider82);
        a(advertFragmentDependencies, kundle3, kundle5, subscriptionSource);
        b(brandspaceEntryPointInteractorModule, advertFragmentDependencies, activity, bundle2, kundle7, kundle8);
    }

    public static AdvertFragmentComponent.Builder builder() {
        return new b(null);
    }

    /* JADX WARN: Failed to parse method signature: (Lcom/avito/android/brandspace_entry_point/di/BrandspaceEntryPointInteractorModule;Lcom/avito/android/advert/di/AdvertFragmentDependencies;Lcom/avito/android/di/module/ScreenAnalyticsDependencies;Lcom/avito/android/analytics/screens/Screen;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/advert/item/AdvertDetailsFastOpenParams;Lcom/avito/android/rec/ScreenSource;Ljava/lang/Boolean;Ljava/lang/Long;Ljava/lang/Integer;Landroid/content/res/Resources;Landroid/app/Activity;Lcom/avito/android/advert/item/AdvertDetailsFragmentDelegate;Landroid/os/Bundle;Lcom/avito/android/util/Kundle;Lcom/avito/android/remote/model/AutotekaDetailsResponse;Lcom/avito/android/util/Kundle;Lcom/avito/android/util/Kundle;Lcom/avito/android/util/Kundle;Landroid/os/Bundle;Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;Landroidx/lifecycle/LifecycleOwner;Landroidx/lifecycle/ViewModelStoreOwner;Lcom/jakewharton/rxrelay3/PublishRelay<Lcom/avito/android/favorite_sellers/action/FavoriteSellersItemAction;>;Lcom/avito/android/util/Kundle;Lcom/avito/android/util/Kundle;Lcom/avito/android/analytics/event/favorite/SubscriptionSource;Lcom/avito/android/serp/analytics/BannerPageSource;Landroid/os/Bundle;Lcom/avito/android/util/Kundle;Lcom/avito/android/util/Kundle;)V */
    public final void a(AdvertFragmentDependencies advertFragmentDependencies, Kundle kundle, Kundle kundle2, SubscriptionSource subscriptionSource) {
        Provider<AdvertDetailsCreditInfoPresenter> provider = DoubleCheck.provider(this.K6);
        this.L6 = provider;
        AdvertDetailsCreditInfoBlueprint_Factory create = AdvertDetailsCreditInfoBlueprint_Factory.create(provider, this.F6);
        this.M6 = create;
        this.N6 = DoubleCheck.provider(create);
        CreditBrokerLinkPresenterImpl_Factory create2 = CreditBrokerLinkPresenterImpl_Factory.create(this.g3);
        this.O6 = create2;
        Provider<CreditBrokerLinkPresenter> provider2 = DoubleCheck.provider(create2);
        this.P6 = provider2;
        CreditBrokerLinkBlueprint_Factory create3 = CreditBrokerLinkBlueprint_Factory.create(provider2);
        this.Q6 = create3;
        this.R6 = DoubleCheck.provider(create3);
        this.S6 = new g0(advertFragmentDependencies);
        Factory createNullable = InstanceFactory.createNullable(kundle);
        this.T6 = createNullable;
        DomotekaTeaserInteractorImpl_Factory create4 = DomotekaTeaserInteractorImpl_Factory.create(this.S6, this.l, this.i, createNullable);
        this.U6 = create4;
        Provider<DomotekaTeaserInteractor> provider3 = DoubleCheck.provider(create4);
        this.V6 = provider3;
        AdvertDetailsDomotekaTeaserPresenterImpl_Factory create5 = AdvertDetailsDomotekaTeaserPresenterImpl_Factory.create(provider3, this.A, this.w, this.l);
        this.W6 = create5;
        Provider<AdvertDetailsDomotekaTeaserPresenter> provider4 = DoubleCheck.provider(create5);
        this.X6 = provider4;
        AdvertDetailsDomotekaTeaserBlueprint_Factory create6 = AdvertDetailsDomotekaTeaserBlueprint_Factory.create(provider4);
        this.Y6 = create6;
        this.Z6 = DoubleCheck.provider(create6);
        GuideSectionItemPresenterImpl_Factory create7 = GuideSectionItemPresenterImpl_Factory.create(this.A);
        this.f17a7 = create7;
        Provider<GuideSectionItemPresenter> provider5 = DoubleCheck.provider(create7);
        this.f18b7 = provider5;
        GuideSectionItemBlueprint_Factory create8 = GuideSectionItemBlueprint_Factory.create(provider5);
        this.c7 = create8;
        Provider<ItemBinder> provider6 = DoubleCheck.provider(AdvertDetailsGuideModule_ProvideItemBinderFactory.create(create8));
        this.d7 = provider6;
        Provider<AdapterPresenter> provider7 = DoubleCheck.provider(AdvertDetailsGuideModule_ProvideSectionsAdapterPresenterFactory.create(provider6));
        this.e7 = provider7;
        AdvertDetailsGuidePresenterImpl_Factory create9 = AdvertDetailsGuidePresenterImpl_Factory.create(provider7, this.f18b7, this.A);
        this.f7 = create9;
        this.g7 = DoubleCheck.provider(create9);
        Provider<SimpleRecyclerAdapter> provider8 = DoubleCheck.provider(AdvertDetailsGuideModule_ProvideSectionsAdapterFactory.create(this.e7, this.d7));
        this.h7 = provider8;
        AdvertDetailsGuideBlueprint_Factory create10 = AdvertDetailsGuideBlueprint_Factory.create(this.g7, provider8);
        this.i7 = create10;
        this.j7 = DoubleCheck.provider(create10);
        AdvertDetailsImvBadgePresenterImpl_Factory create11 = AdvertDetailsImvBadgePresenterImpl_Factory.create(this.d, this.g);
        this.k7 = create11;
        Provider<AdvertDetailsImvBadgePresenter> provider9 = DoubleCheck.provider(create11);
        this.l7 = provider9;
        AdvertDetailsImvBadgeBlueprint_Factory create12 = AdvertDetailsImvBadgeBlueprint_Factory.create(provider9);
        this.m7 = create12;
        this.n7 = DoubleCheck.provider(create12);
        AdvertDetailsSafeDealLegacyButtonPresenterImpl_Factory create13 = AdvertDetailsSafeDealLegacyButtonPresenterImpl_Factory.create(this.U0);
        this.o7 = create13;
        Provider<AdvertDetailsSafeDealLegacyButtonPresenter> provider10 = DoubleCheck.provider(create13);
        this.p7 = provider10;
        AdvertDetailsSafeDealLegacyButtonBlueprint_Factory create14 = AdvertDetailsSafeDealLegacyButtonBlueprint_Factory.create(provider10);
        this.q7 = create14;
        this.r7 = DoubleCheck.provider(create14);
        AdvertDetailsSafeDealButtonPresenterImpl_Factory create15 = AdvertDetailsSafeDealButtonPresenterImpl_Factory.create(this.U0);
        this.s7 = create15;
        Provider<AdvertDetailsSafeDealButtonPresenter> provider11 = DoubleCheck.provider(create15);
        this.t7 = provider11;
        AdvertDetailsSafeDealButtonBlueprint_Factory create16 = AdvertDetailsSafeDealButtonBlueprint_Factory.create(provider11);
        this.u7 = create16;
        this.v7 = DoubleCheck.provider(create16);
        AdvertDetailsSafeDealInfoPresenterImpl_Factory create17 = AdvertDetailsSafeDealInfoPresenterImpl_Factory.create(this.U0);
        this.w7 = create17;
        Provider<AdvertDetailsSafeDealInfoPresenter> provider12 = DoubleCheck.provider(create17);
        this.x7 = provider12;
        AdvertDetailsSafeDealInfoBlueprint_Factory create18 = AdvertDetailsSafeDealInfoBlueprint_Factory.create(provider12);
        this.y7 = create18;
        this.z7 = DoubleCheck.provider(create18);
        AdvertDetailsSafeDealLabelPresenterImpl_Factory create19 = AdvertDetailsSafeDealLabelPresenterImpl_Factory.create(this.f, this.U0, this.Z1);
        this.A7 = create19;
        Provider<AdvertDetailsSafeDealLabelPresenter> provider13 = DoubleCheck.provider(create19);
        this.B7 = provider13;
        AdvertDetailsSafeDealLabelBlueprint_Factory create20 = AdvertDetailsSafeDealLabelBlueprint_Factory.create(provider13);
        this.C7 = create20;
        this.D7 = DoubleCheck.provider(create20);
        AdvertDetailsSafeDealTrustFactorsPresenterImpl_Factory create21 = AdvertDetailsSafeDealTrustFactorsPresenterImpl_Factory.create(this.U0);
        this.E7 = create21;
        Provider<AdvertDetailsSafeDealTrustFactorsPresenter> provider14 = DoubleCheck.provider(create21);
        this.F7 = provider14;
        AdvertDetailsSafeDealTrustFactorsBlueprint_Factory create22 = AdvertDetailsSafeDealTrustFactorsBlueprint_Factory.create(provider14, this.Z1);
        this.G7 = create22;
        this.H7 = DoubleCheck.provider(create22);
        g1 g1Var = new g1(advertFragmentDependencies);
        this.I7 = g1Var;
        MyAdvertSafeDealServicesInteractorImpl_Factory create23 = MyAdvertSafeDealServicesInteractorImpl_Factory.create(this.d, g1Var, this.C2, this.l);
        this.J7 = create23;
        this.K7 = SingleCheck.provider(create23);
        this.L7 = MyAdvertSafeDealResourceProvider_Factory.create(this.F);
        Provider<Relay<MyAdvertSafeDeal>> provider15 = SingleCheck.provider(MyAdvertSafeDealServicesModule_ProvideMyAdvertSafeDealServicesObservable$advert_core_releaseFactory.create());
        this.M7 = provider15;
        MyAdvertSafedealServicesViewModelFactory_Factory create24 = MyAdvertSafedealServicesViewModelFactory_Factory.create(this.K7, this.l, this.L7, provider15);
        this.N7 = create24;
        Provider<MyAdvertSafeDealServicesViewModel> provider16 = SingleCheck.provider(MyAdvertSafeDealServicesModule_ProvideMyAdvertSafeDealServicesViewModel$advert_core_releaseFactory.create(this.S5, create24));
        this.O7 = provider16;
        AdvertDetailsSafeDealServicesPresenterImpl_Factory create25 = AdvertDetailsSafeDealServicesPresenterImpl_Factory.create(provider16, this.U0, this.M7);
        this.P7 = create25;
        Provider<AdvertDetailsSafeDealServicesPresenter> provider17 = DoubleCheck.provider(create25);
        this.Q7 = provider17;
        AdvertDetailsSafeDealServicesBlueprint_Factory create26 = AdvertDetailsSafeDealServicesBlueprint_Factory.create(provider17, this.S2);
        this.R7 = create26;
        this.S7 = DoubleCheck.provider(create26);
        AdvertVerificationPresenterImpl_Factory create27 = AdvertVerificationPresenterImpl_Factory.create(this.g3, this.i);
        this.T7 = create27;
        Provider<AdvertVerificationPresenter> provider18 = DoubleCheck.provider(create27);
        this.U7 = provider18;
        AdvertVerificationBlueprint_Factory create28 = AdvertVerificationBlueprint_Factory.create(provider18);
        this.V7 = create28;
        this.W7 = DoubleCheck.provider(create28);
        CarouselPhotoGalleryPresenterImpl_Factory create29 = CarouselPhotoGalleryPresenterImpl_Factory.create(this.g3, this.r2);
        this.X7 = create29;
        Provider<CarouselPhotoGalleryPresenter> provider19 = DoubleCheck.provider(create29);
        this.Y7 = provider19;
        CarouselPhotoGalleryBlueprint_Factory create30 = CarouselPhotoGalleryBlueprint_Factory.create(provider19, this.z4, this.g);
        this.Z7 = create30;
        this.a8 = DoubleCheck.provider(create30);
        AdvertDetailsGeoReportTeaserPresenterImp_Factory create31 = AdvertDetailsGeoReportTeaserPresenterImp_Factory.create(this.A);
        this.b8 = create31;
        Provider<AdvertDetailsGeoReportTeaserPresenter> provider20 = DoubleCheck.provider(create31);
        this.c8 = provider20;
        AdvertDetailsGeoReportTeaserBlueprint_Factory create32 = AdvertDetailsGeoReportTeaserBlueprint_Factory.create(provider20);
        this.d8 = create32;
        this.e8 = DoubleCheck.provider(create32);
        this.f8 = SetFactory.builder(16, 0).addProvider(this.f33z6).addProvider(this.D6).addProvider(this.N6).addProvider(this.R6).addProvider(this.Z6).addProvider(this.j7).addProvider(this.n7).addProvider(this.r7).addProvider(this.v7).addProvider(this.z7).addProvider(this.D7).addProvider(this.H7).addProvider(this.S7).addProvider(this.W7).addProvider(this.a8).addProvider(this.e8).build();
        this.g8 = SingleCheck.provider(this.q1);
        this.h8 = InstanceFactory.create(subscriptionSource);
        Factory createNullable2 = InstanceFactory.createNullable(kundle2);
        this.i8 = createNullable2;
        RecommendationItemPresenterImpl_Factory create33 = RecommendationItemPresenterImpl_Factory.create(this.e2, this.c2, this.W2, this.s1, this.l, this.g8, this.g, this.h8, this.i2, createNullable2);
        this.j8 = create33;
        this.k8 = DoubleCheck.provider(create33);
        Provider<Consumer<FavoriteSellersItemAction>> provider21 = DoubleCheck.provider(this.V2);
        this.l8 = provider21;
        SellerCarouselItemPresenterImpl_Factory create34 = SellerCarouselItemPresenterImpl_Factory.create(provider21);
        this.m8 = create34;
        this.n8 = SellerCarouselItemBlueprint_Factory.create(create34);
        SetFactory build = SetFactory.builder(1, 0).addProvider(this.n8).build();
        this.o8 = build;
        Provider<ItemBinder> provider22 = DoubleCheck.provider(AdvertDetailsRecommendationItemModule_ProvideItemBinderFactory.create(build));
        this.p8 = provider22;
        AdvertDetailsRecommendationItemModule_ProvideAdapterPresenterFactory create35 = AdvertDetailsRecommendationItemModule_ProvideAdapterPresenterFactory.create(provider22);
        this.q8 = create35;
        this.r8 = AdvertDetailsRecommendationItemBlueprint_Factory.create(this.k8, create35, this.p8);
        SafeShowItemPresenterImpl_Factory create36 = SafeShowItemPresenterImpl_Factory.create(this.A);
        this.s8 = create36;
        this.t8 = DoubleCheck.provider(create36);
        SafeShowAdvertDetailsDialogFactory_Factory create37 = SafeShowAdvertDetailsDialogFactory_Factory.create(this.G, this.N, this.i);
        this.u8 = create37;
        this.v8 = SafeShowItemBlueprint_Factory.create(this.t8, create37);
        AdvertDetailsIceBreakersPresenterImpl_Factory create38 = AdvertDetailsIceBreakersPresenterImpl_Factory.create(this.A);
        this.w8 = create38;
        Provider<AdvertDetailsIceBreakersPresenter> provider23 = DoubleCheck.provider(create38);
        this.x8 = provider23;
        i iVar = new i(advertFragmentDependencies);
        this.y8 = iVar;
        this.z8 = AdvertDetailsIceBreakersBlueprint_Factory.create(provider23, iVar);
        AdvertDetailsFeatureTeaserResourceProvider_Factory create39 = AdvertDetailsFeatureTeaserResourceProvider_Factory.create(this.F, this.G);
        this.A8 = create39;
        this.B8 = AdvertDetailsFeatureTeaserPresenter_Factory.create(this.d, this.A, create39);
        Provider<AdvertDetailsFeatureTeaserDialogTextItemPresenter> provider24 = SingleCheck.provider(AdvertDetailsFeatureTeaserDialogTextItemPresenter_Factory.create());
        this.C8 = provider24;
        this.D8 = AdvertDetailsFeatureTeaserDialogTextItemBlueprint_Factory.create(provider24, this.Z1);
        SetFactory build2 = SetFactory.builder(2, 0).addProvider(this.D8).addProvider(this.e6).build();
        this.E8 = build2;
        Provider<ItemBinder> provider25 = SingleCheck.provider(CommonFeatureTeaserModule_ProvideItemBinder$advert_core_releaseFactory.create(build2));
        this.F8 = provider25;
        this.G8 = CommonFeatureTeaserModule_ProvideAdapterFactory.create(provider25);
    }

    /* JADX WARN: Failed to parse method signature: (Lcom/avito/android/brandspace_entry_point/di/BrandspaceEntryPointInteractorModule;Lcom/avito/android/advert/di/AdvertFragmentDependencies;Lcom/avito/android/di/module/ScreenAnalyticsDependencies;Lcom/avito/android/analytics/screens/Screen;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/advert/item/AdvertDetailsFastOpenParams;Lcom/avito/android/rec/ScreenSource;Ljava/lang/Boolean;Ljava/lang/Long;Ljava/lang/Integer;Landroid/content/res/Resources;Landroid/app/Activity;Lcom/avito/android/advert/item/AdvertDetailsFragmentDelegate;Landroid/os/Bundle;Lcom/avito/android/util/Kundle;Lcom/avito/android/remote/model/AutotekaDetailsResponse;Lcom/avito/android/util/Kundle;Lcom/avito/android/util/Kundle;Lcom/avito/android/util/Kundle;Landroid/os/Bundle;Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;Landroidx/lifecycle/LifecycleOwner;Landroidx/lifecycle/ViewModelStoreOwner;Lcom/jakewharton/rxrelay3/PublishRelay<Lcom/avito/android/favorite_sellers/action/FavoriteSellersItemAction;>;Lcom/avito/android/util/Kundle;Lcom/avito/android/util/Kundle;Lcom/avito/android/analytics/event/favorite/SubscriptionSource;Lcom/avito/android/serp/analytics/BannerPageSource;Landroid/os/Bundle;Lcom/avito/android/util/Kundle;Lcom/avito/android/util/Kundle;)V */
    public final void b(BrandspaceEntryPointInteractorModule brandspaceEntryPointInteractorModule, AdvertFragmentDependencies advertFragmentDependencies, Activity activity, Bundle bundle, Kundle kundle, Kundle kundle2) {
        AdvertDetailsFeatureTeaserDialogItemsAdapter_Factory create = AdvertDetailsFeatureTeaserDialogItemsAdapter_Factory.create(this.A8, IdProviderImpl_Factory.create());
        this.H8 = create;
        CommonFeatureTeaserDialogFactory_Factory create2 = CommonFeatureTeaserDialogFactory_Factory.create(this.F8, this.G8, this.A8, create);
        this.I8 = create2;
        Provider<FeatureTeaserDialogFactory> provider = SingleCheck.provider(create2);
        this.J8 = provider;
        this.K8 = AdvertDetailsFeatureTeaserBlueprint_Factory.create(this.B8, provider, this.A8);
        MarketplaceSpecsPresenterImpl_Factory create3 = MarketplaceSpecsPresenterImpl_Factory.create(this.g3);
        this.L8 = create3;
        Provider<MarketplaceSpecsPresenter> provider2 = DoubleCheck.provider(create3);
        this.M8 = provider2;
        this.N8 = MarketplaceSpecsBlueprint_Factory.create(provider2);
        MarketplaceBriefSpecsPresenterImpl_Factory create4 = MarketplaceBriefSpecsPresenterImpl_Factory.create(this.d, this.A);
        this.O8 = create4;
        Provider<MarketplaceBriefSpecsPresenter> provider3 = DoubleCheck.provider(create4);
        this.P8 = provider3;
        this.Q8 = MarketplaceBriefSpecsBlueprint_Factory.create(provider3, this.Z1);
        MarketplaceInfoPresenterImpl_Factory create5 = MarketplaceInfoPresenterImpl_Factory.create(this.g3);
        this.R8 = create5;
        Provider<MarketplaceInfoPresenter> provider4 = DoubleCheck.provider(create5);
        this.S8 = provider4;
        this.T8 = MarketplaceInfoBlueprint_Factory.create(provider4);
        MarketplaceDeliveryPresenterImpl_Factory create6 = MarketplaceDeliveryPresenterImpl_Factory.create(this.g3, this.e3);
        this.U8 = create6;
        Provider<MarketplaceDeliveryPresenter> provider5 = DoubleCheck.provider(create6);
        this.V8 = provider5;
        k kVar = new k(advertFragmentDependencies);
        this.W8 = kVar;
        this.X8 = MarketplaceDeliveryBlueprint_Factory.create(provider5, this.i, kVar);
        MarketplaceFaqPresenterImpl_Factory create7 = MarketplaceFaqPresenterImpl_Factory.create(this.g3);
        this.Y8 = create7;
        Provider<MarketplaceFaqPresenter> provider6 = DoubleCheck.provider(create7);
        this.Z8 = provider6;
        this.a9 = MarketplaceFaqBlueprint_Factory.create(provider6, this.p2);
        Provider<MarketplaceBadgeBarPresenter> provider7 = DoubleCheck.provider(MarketplaceBadgeBarPresenterImpl_Factory.create());
        this.b9 = provider7;
        this.c9 = MarketplaceBadgeBarBlueprint_Factory.create(provider7);
        Provider<MarketplaceQuantityPresenter> provider8 = DoubleCheck.provider(MarketplaceQuantityPresenterImpl_Factory.create());
        this.d9 = provider8;
        this.e9 = MarketplaceQuantityBlueprint_Factory.create(provider8);
        MarketplaceContactBarPresenterImpl_Factory create8 = MarketplaceContactBarPresenterImpl_Factory.create(this.g3);
        this.f9 = create8;
        Provider<MarketplaceContactBarPresenter> provider9 = DoubleCheck.provider(create8);
        this.g9 = provider9;
        this.h9 = MarketplaceContactBarBlueprint_Factory.create(provider9);
        Provider<AlertBannerPresenter> provider10 = DoubleCheck.provider(AlertBannerPresenterImpl_Factory.create());
        this.i9 = provider10;
        this.j9 = AlertBannerBlueprint_Factory.create(provider10);
        k1 k1Var = new k1(advertFragmentDependencies);
        this.k9 = k1Var;
        SparePartsInteractorImpl_Factory create9 = SparePartsInteractorImpl_Factory.create(k1Var, this.C2);
        this.l9 = create9;
        this.m9 = DoubleCheck.provider(create9);
        SparePartsResourceProviderImpl_Factory create10 = SparePartsResourceProviderImpl_Factory.create(this.F);
        this.n9 = create10;
        Provider<SparePartsResourceProvider> provider11 = DoubleCheck.provider(create10);
        this.o9 = provider11;
        SparePartsFormatterImpl_Factory create11 = SparePartsFormatterImpl_Factory.create(this.Z1, provider11);
        this.p9 = create11;
        this.q9 = DoubleCheck.provider(create11);
        Factory createNullable = InstanceFactory.createNullable(kundle);
        this.r9 = createNullable;
        Provider<SparePartsPresenter> provider12 = DoubleCheck.provider(SparePartsModule_ProvideReplacementsPresenterFactory.create(this.m9, this.q9, this.l, createNullable));
        this.s9 = provider12;
        this.t9 = SparePartsReplacementsBlueprint_Factory.create(provider12);
        Factory createNullable2 = InstanceFactory.createNullable(kundle2);
        this.u9 = createNullable2;
        Provider<SparePartsPresenter> provider13 = DoubleCheck.provider(SparePartsModule_ProvideCompatibilitiesPresenterFactory.create(this.m9, this.q9, this.l, createNullable2));
        this.v9 = provider13;
        this.w9 = SparePartsCompatibilitiesBlueprint_Factory.create(provider13);
        Provider<AdvertBookingPresenter> provider14 = DoubleCheck.provider(AdvertBookingPresenterImpl_Factory.create());
        this.x9 = provider14;
        this.y9 = AdvertBookingBlueprint_Factory.create(provider14, this.Z1);
        Provider<CarMarketPriceDescriptionResourceProvider> provider15 = DoubleCheck.provider(CarMarketPriceDescriptionResourceProviderImpl_Factory.create());
        this.z9 = provider15;
        CarMarketPriceSwitchConverterImpl_Factory create12 = CarMarketPriceSwitchConverterImpl_Factory.create(provider15);
        this.A9 = create12;
        Provider<CarMarketPriceSwitchConverter> provider16 = DoubleCheck.provider(create12);
        this.B9 = provider16;
        CarMarketPriceDescriptionPresenterImpl_Factory create13 = CarMarketPriceDescriptionPresenterImpl_Factory.create(provider16);
        this.C9 = create13;
        Provider<CarMarketPriceDescriptionPresenter> provider17 = DoubleCheck.provider(create13);
        this.D9 = provider17;
        this.E9 = CarMarketPriceDescriptionBlueprint_Factory.create(provider17);
        CarMarketPriceChartResourceProviderImpl_Factory create14 = CarMarketPriceChartResourceProviderImpl_Factory.create(this.F);
        this.F9 = create14;
        Provider<CarMarketPriceChartResourceProvider> provider18 = DoubleCheck.provider(create14);
        this.G9 = provider18;
        CarMarketPriceChartPresenterImpl_Factory create15 = CarMarketPriceChartPresenterImpl_Factory.create(provider18, this.Z1, this.q3);
        this.H9 = create15;
        Provider<CarMarketPriceChartPresenter> provider19 = DoubleCheck.provider(create15);
        this.I9 = provider19;
        this.J9 = CarMarketPriceChartBlueprint_Factory.create(provider19);
        Provider<AdvertDetailsHeaderPresenter> provider20 = DoubleCheck.provider(AdvertDetailsHeaderPresenterImpl_Factory.create());
        this.K9 = provider20;
        this.L9 = AdvertDetailsHeaderBlueprint_Factory.create(provider20);
        Provider<ItemBinder> provider21 = DoubleCheck.provider(AdvertFragmentModule_ProvideItemBinder$advert_details_releaseFactory.create(this.J3, this.N3, this.Q3, this.R3, this.T3, this.X3, this.a4, this.d4, this.h4, this.k4, this.n4, this.q4, this.t4, this.v4, this.A4, this.C4, this.T4, this.V4, this.X4, this.Z4, this.b5, this.d5, this.f5, this.h5, this.j5, this.l5, this.m5, this.n5, this.q5, this.r5, this.u5, this.x5, this.A5, this.B5, this.D5, this.F5, this.I5, this.L5, this.W5, this.Y5, this.Z5, this.c6, this.e6, this.g6, this.i6, this.k6, this.f19l6, this.f22o6, this.f24q6, this.f27t6, this.f29v6, this.f31x6, this.f8, this.r8, this.v8, this.z8, this.K8, this.N8, this.Q8, this.T8, this.X8, this.a9, this.c9, this.e9, this.h9, this.j9, this.t9, this.w9, this.y9, this.E9, this.J9, this.L9));
        this.M9 = provider21;
        this.N9 = DoubleCheck.provider(AdvertFragmentModule_ProvideAdapterPresenter$advert_details_releaseFactory.create(provider21));
        Provider<DestroyableViewHolderBuilder> provider22 = DoubleCheck.provider(AdvertFragmentModule_ProvideDestroyableViewHolderBuilder$advert_details_releaseFactory.create(this.M9));
        this.O9 = provider22;
        this.P9 = DoubleCheck.provider(AdvertFragmentModule_ProvideSafeRecyclerAdapter$advert_details_releaseFactory.create(this.N9, provider22, this.h, this.g));
        Provider<SpannedGridPositionProvider> provider23 = DoubleCheck.provider(AdvertFragmentModule_ProvideGridPositionProvider$advert_details_releaseFactory.create(this.F));
        this.Q9 = provider23;
        Provider<SerpSpanProvider> provider24 = DoubleCheck.provider(AdvertFragmentModule_ProvideSpanProvider$advert_details_releaseFactory.create(provider23, this.F));
        this.R9 = provider24;
        this.S9 = DoubleCheck.provider(AdvertFragmentModule_ProvideSpanLookup$advert_details_releaseFactory.create(provider24));
        this.T9 = SingleCheck.provider(ViewedAdvertsModule_ProvideViewedAdvertsPresenterFactory.create(this.o1, this.l));
        Provider<CreditBrokerSessionProvider> provider25 = DoubleCheck.provider(this.u);
        this.U9 = provider25;
        q1 q1Var = new q1(advertFragmentDependencies);
        this.V9 = q1Var;
        DfpCreditBannerLoaderImpl_Factory create16 = DfpCreditBannerLoaderImpl_Factory.create(this.f, this.l, this.e, this.A, this.F6, provider25, this.h, q1Var, this.i);
        this.W9 = create16;
        this.X9 = DoubleCheck.provider(create16);
        this.Y9 = new d1(advertFragmentDependencies);
        AdvertDetailsCreditStorageImpl_Factory create17 = AdvertDetailsCreditStorageImpl_Factory.create(this.W);
        this.Z9 = create17;
        Provider<AdvertDetailsCreditStorage> provider26 = DoubleCheck.provider(create17);
        this.aa = provider26;
        n1 n1Var = new n1(advertFragmentDependencies);
        this.ba = n1Var;
        DfpCreditViewModelFactoryImpl_Factory create18 = DfpCreditViewModelFactoryImpl_Factory.create(this.g0, this.l, this.X9, this.A, this.Y9, this.w, provider26, n1Var);
        this.ca = create18;
        this.da = DoubleCheck.provider(create18);
        this.ea = BannerViewFilter_Factory.create(this.s);
        Provider<BrandspaceEntryPointAnalyticsInteractor> provider27 = DoubleCheck.provider(BrandspaceEntryPointInteractorModule_ProvideBrandspaceEntryPointAnalyticsInteractorFactory.create(brandspaceEntryPointInteractorModule, this.g, this.i));
        this.fa = provider27;
        this.ga = CreditBannerFilter_Factory.create(this.v, provider27);
        Factory createNullable3 = InstanceFactory.createNullable(bundle);
        this.ha = createNullable3;
        this.ia = DoubleCheck.provider(AdvertFragmentModule_ProvideItemVisibilityTracker$advert_details_releaseFactory.create(this.ea, this.ga, createNullable3));
        Factory create19 = InstanceFactory.create(activity);
        this.ja = create19;
        this.ka = SingleCheck.provider(DialogRouterModule_ProvideDialogRouterFactory.create(create19));
        this.la = SingleCheck.provider(CartFabQuantityVisibilityHandler_Factory.create());
    }

    @Override // com.avito.android.advert.di.AdvertFragmentComponent
    public void inject(AdvertDetailsFragment advertDetailsFragment) {
        AdvertDetailsFragment_MembersInjector.injectAnalytics(advertDetailsFragment, (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics()));
        AdvertDetailsFragment_MembersInjector.injectAccountStatus(advertDetailsFragment, (AccountStateProvider) Preconditions.checkNotNullFromComponent(this.a.accountStateProvider()));
        AdvertDetailsFragment_MembersInjector.injectPresenter(advertDetailsFragment, this.g3.get());
        AdvertDetailsFragment_MembersInjector.injectImplicitIntentFactory(advertDetailsFragment, (ImplicitIntentFactory) Preconditions.checkNotNullFromComponent(this.a.implicitIntentFactory()));
        AdvertDetailsFragment_MembersInjector.injectDeepLinkIntentFactory(advertDetailsFragment, (DeepLinkIntentFactory) Preconditions.checkNotNullFromComponent(this.a.deepLinkIntentFactory()));
        AdvertDetailsFragment_MembersInjector.injectActivityIntentFactory(advertDetailsFragment, (ActivityIntentFactory) Preconditions.checkNotNullFromComponent(this.a.activityIntentFactory()));
        AdvertDetailsFragment_MembersInjector.injectDeviceMetrics(advertDetailsFragment, (DeviceMetrics) Preconditions.checkNotNullFromComponent(this.a.deviceMetrics()));
        AdvertDetailsFragment_MembersInjector.injectPhoneNumberFormatter(advertDetailsFragment, PhoneNumberFormatterModule_ProvidePhoneNumberFormatterWithCountryCodeFactory.providePhoneNumberFormatterWithCountryCode());
        AdvertDetailsFragment_MembersInjector.injectSellerPresenter(advertDetailsFragment, this.c1.get());
        AdvertDetailsFragment_MembersInjector.injectAdditionalSellerPresenter(advertDetailsFragment, this.h3.get());
        AdvertDetailsFragment_MembersInjector.injectContactsPresenter(advertDetailsFragment, this.N.get());
        AdvertDetailsFragment_MembersInjector.injectAdvertDetailsToolbarPresenter(advertDetailsFragment, this.w1.get());
        AdvertDetailsFragment_MembersInjector.injectFeatures(advertDetailsFragment, (Features) Preconditions.checkNotNullFromComponent(this.a.features()));
        AdvertDetailsFragment_MembersInjector.injectDeliveryPresenter(advertDetailsFragment, this.k3.get());
        AdvertDetailsFragment_MembersInjector.injectSafedealPresenter(advertDetailsFragment, this.U0.get());
        AdvertDetailsFragment_MembersInjector.injectSectionsAdapterPresenter(advertDetailsFragment, this.N9.get());
        AdvertDetailsFragment_MembersInjector.injectSimilarAdvertResources(advertDetailsFragment, this.y1.get());
        AdvertDetailsFragment_MembersInjector.injectAutotekaPresenter(advertDetailsFragment, this.I2.get());
        AdvertDetailsFragment_MembersInjector.injectAutotekaTeaserPresenter(advertDetailsFragment, this.P2.get());
        AdvertDetailsFragment_MembersInjector.injectAutotekaDetailsInteractor(advertDetailsFragment, this.G2.get());
        AdvertDetailsFragment_MembersInjector.injectAutotekaTeaserInteractor(advertDetailsFragment, this.L2.get());
        AdvertDetailsFragment_MembersInjector.injectNotePresenter(advertDetailsFragment, this.R2.get());
        AdvertDetailsFragment_MembersInjector.injectDestroyableComplementaryViewHolderBuilder(advertDetailsFragment, this.O9.get());
        AdvertDetailsFragment_MembersInjector.injectAdvertComplementaryPresenter(advertDetailsFragment, this.U1.get());
        AdvertDetailsFragment_MembersInjector.injectItemsSafeRecyclerAdapter(advertDetailsFragment, this.P9.get());
        AdvertDetailsFragment_MembersInjector.injectGridPositionProvider(advertDetailsFragment, this.Q9.get());
        AdvertDetailsFragment_MembersInjector.injectSpanSizeLookup(advertDetailsFragment, this.S9.get());
        AdvertDetailsFragment_MembersInjector.injectSpanProvider(advertDetailsFragment, this.R9.get());
        AdvertDetailsFragment_MembersInjector.injectFavoriteAdvertsPresenter(advertDetailsFragment, this.z2.get());
        AdvertDetailsFragment_MembersInjector.injectViewedAdvertsPresenter(advertDetailsFragment, this.T9.get());
        AdvertDetailsFragment_MembersInjector.injectSectionActionPresenter(advertDetailsFragment, this.K3.get());
        AdvertDetailsFragment_MembersInjector.injectSectionItemPresenter(advertDetailsFragment, this.o3.get());
        AdvertDetailsFragment_MembersInjector.injectCreditViewModelFactory(advertDetailsFragment, this.da.get());
        AdvertDetailsFragment_MembersInjector.injectTracker(advertDetailsFragment, this.S1.get());
        AdvertDetailsFragment_MembersInjector.injectDescriptionPresenter(advertDetailsFragment, this.e5.get());
        AdvertDetailsFragment_MembersInjector.injectAddressPresenter(advertDetailsFragment, this.g5.get());
        AdvertDetailsFragment_MembersInjector.injectAdvertDetailsShowOnMapPresenter(advertDetailsFragment, this.f28u6.get());
        AdvertDetailsFragment_MembersInjector.injectAdvertDetailsPriceSubscriptionPresenter(advertDetailsFragment, this.W4.get());
        AdvertDetailsFragment_MembersInjector.injectAdvertDetailsConsultationPresenter(advertDetailsFragment, this.X5.get());
        AdvertDetailsFragment_MembersInjector.injectGeoReferencePresenter(advertDetailsFragment, this.h6.get());
        AdvertDetailsFragment_MembersInjector.injectShortTermRentPresenter(advertDetailsFragment, this.U2.get());
        AdvertDetailsFragment_MembersInjector.injectAdvertDetailsItemsPresenter(advertDetailsFragment, this.r2.get());
        AdvertDetailsFragment_MembersInjector.injectSellerSubscriptionPresenter(advertDetailsFragment, this.k2.get());
        AdvertDetailsFragment_MembersInjector.injectAdvertDetailsAutoCatalogPresenter(advertDetailsFragment, this.t5.get());
        AdvertDetailsFragment_MembersInjector.injectAdvertDetailsCreditInfoPresenter(advertDetailsFragment, this.L6.get());
        AdvertDetailsFragment_MembersInjector.injectAdvertDetailsDeliveryInfoPresenter(advertDetailsFragment, this.V5.get());
        AdvertDetailsFragment_MembersInjector.injectAdvertDetailsRatingPublishPresenter(advertDetailsFragment, this.f30w6.get());
        AdvertDetailsFragment_MembersInjector.injectDomotekaTeaserInteractor(advertDetailsFragment, this.V6.get());
        AdvertDetailsFragment_MembersInjector.injectDomotekaTeaserPresenter(advertDetailsFragment, this.X6.get());
        AdvertDetailsFragment_MembersInjector.injectMarketplaceDeliveryPresenter(advertDetailsFragment, this.V8.get());
        AdvertDetailsFragment_MembersInjector.injectRecommendationPresenter(advertDetailsFragment, this.k8.get());
        AdvertDetailsFragment_MembersInjector.injectAdvertDetailsGuidePresenter(advertDetailsFragment, this.g7.get());
        AdvertDetailsFragment_MembersInjector.injectIceBreakersPresenter(advertDetailsFragment, this.x8.get());
        AdvertDetailsFragment_MembersInjector.injectSafeDealServicesPresenter(advertDetailsFragment, this.Q7.get());
        AdvertDetailsFragment_MembersInjector.injectBookingPresenter(advertDetailsFragment, this.x9.get());
        AdvertDetailsFragment_MembersInjector.injectBadgeBarPresenter(advertDetailsFragment, this.B6.get());
        AdvertDetailsFragment_MembersInjector.injectImvBadgePresenter(advertDetailsFragment, this.l7.get());
        AdvertDetailsFragment_MembersInjector.injectImvChartPresenter(advertDetailsFragment, this.I9.get());
        AdvertDetailsFragment_MembersInjector.injectQuestionnairePresenter(advertDetailsFragment, this.c3.get());
        AdvertDetailsFragment_MembersInjector.injectAnalyticsInteractor(advertDetailsFragment, this.A.get());
        AdvertDetailsFragment_MembersInjector.injectCreditBrokerAnalyticsInteractor(advertDetailsFragment, this.v.get());
        AdvertDetailsFragment_MembersInjector.injectReplacementsPresenter(advertDetailsFragment, this.s9.get());
        AdvertDetailsFragment_MembersInjector.injectCompatibilitiesPresenter(advertDetailsFragment, this.v9.get());
        AdvertDetailsFragment_MembersInjector.injectSupplier(advertDetailsFragment, new FpsStateSupplier(new FpsMetricsSupplier.Impl((io.reactivex.Observable) Preconditions.checkNotNullFromComponent(this.b.frameStream()), (FpsMetricsTracker) Preconditions.checkNotNullFromComponent(this.b.fpsMetricsTracker()), this.c, this.b.fpsTrackingThreshold(), (Features) Preconditions.checkNotNullFromComponent(this.a.features())), (BuildInfo) Preconditions.checkNotNullFromComponent(this.a.buildInfo())));
        AdvertDetailsFragment_MembersInjector.injectItemVisibilityTracker(advertDetailsFragment, this.ia.get());
        AdvertDetailsFragment_MembersInjector.injectDialogRouter(advertDetailsFragment, this.ka.get());
        AdvertDetailsFragment_MembersInjector.injectSnackbarPresenter(advertDetailsFragment, this.i2.get());
        AdvertDetailsFragment_MembersInjector.injectPromoCardPresenter(advertDetailsFragment, this.f32y6.get());
        AdvertDetailsFragment_MembersInjector.injectCreGeoReportPresenter(advertDetailsFragment, this.c8.get());
        AdvertDetailsFragment_MembersInjector.injectCartFabViewModel(advertDetailsFragment, this.d0.get());
        AdvertDetailsFragment_MembersInjector.injectCartFabQuantityHandler(advertDetailsFragment, this.la.get());
        AdvertDetailsFragment_MembersInjector.injectSetMarketplacePresenter(advertDetailsFragment, this.f0.get());
    }
}
