package com.avito.android.publish.details.di;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextWatcher;
import androidx.recyclerview.widget.ListUpdateCallback;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.Features;
import com.avito.android.ab_tests.AbTestsConfigProvider;
import com.avito.android.account.AccountStorageInteractor;
import com.avito.android.account.SessionChangeTracker;
import com.avito.android.account.SessionChangeTrackerImpl;
import com.avito.android.account.SessionChangeTrackerImpl_Factory;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.publish.PublishAnalyticsDataProvider;
import com.avito.android.analytics.screens.ScreenFlowTrackerProvider;
import com.avito.android.analytics.screens.ScreenTransferRecovery;
import com.avito.android.analytics.screens.ScreenTransferRecovery_Impl_Factory;
import com.avito.android.analytics.screens.TimerFactory;
import com.avito.android.analytics.screens.tracker.ScreenDiInjectTracker;
import com.avito.android.analytics.screens.tracker.ScreenInitTracker;
import com.avito.android.analytics.screens.tracker.ScreenTrackerFactory;
import com.avito.android.blueprints.ButtonItemBlueprint;
import com.avito.android.blueprints.ButtonItemPresenter;
import com.avito.android.blueprints.chips.ChipsSelectItemBlueprint;
import com.avito.android.blueprints.chips.ChipsSelectItemPresenter;
import com.avito.android.blueprints.chips_multiselect.ChipsMultiselectItemBlueprint;
import com.avito.android.blueprints.chips_multiselect.ChipsMultiselectItemBlueprint_Factory;
import com.avito.android.blueprints.chips_multiselect.ChipsMultiselectItemPresenter;
import com.avito.android.blueprints.input.MultiStateInputItemBlueprint;
import com.avito.android.blueprints.input.MultiStateInputItemPresenter;
import com.avito.android.blueprints.publish.VehicleRegNumberInputItemBlueprint;
import com.avito.android.blueprints.publish.VehicleRegNumberInputItemPresenter;
import com.avito.android.blueprints.publish.html_editor.HtmlEditorViewModel;
import com.avito.android.blueprints.publish.html_editor.HtmlEditorViewModelFactory;
import com.avito.android.blueprints.publish.tagged_input.MultiStateInputWithTagsItemBlueprint;
import com.avito.android.blueprints.publish.tagged_input.MultiStateInputWithTagsItemPresenter;
import com.avito.android.blueprints.radiogroup.RadioGroupSelectItemBlueprint;
import com.avito.android.blueprints.radiogroup.RadioGroupSelectItemPresenter;
import com.avito.android.blueprints.range.cre_range.CreRangeItemBlueprint;
import com.avito.android.blueprints.range.cre_range.CreRangePresenter;
import com.avito.android.blueprints.range.cre_range.CreRangePresenterImpl;
import com.avito.android.blueprints.range.cre_range.CreRangePresenterImpl_Factory;
import com.avito.android.blueprints.select.MultiStateSelectItemBlueprint;
import com.avito.android.blueprints.select.MultiStateSelectItemPresenter;
import com.avito.android.blueprints.switcher.MultiStateSwitcherItemBlueprint;
import com.avito.android.blueprints.switcher.MultiStateSwitcherItemPresenter;
import com.avito.android.blueprints.video.VideoItemBlueprint;
import com.avito.android.blueprints.video.VideoItemBlueprint_Factory;
import com.avito.android.blueprints.video.VideoItemPresenter;
import com.avito.android.blueprints.video.VideoItemPresenterImpl_Factory;
import com.avito.android.category_parameters.CategoryParametersElementConverter;
import com.avito.android.component.profile_snippet.AvatarRenderer;
import com.avito.android.computer_vision.ComputerVisionInteractor;
import com.avito.android.deep_linking.DeepLinkFactory;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.html_editor.EditorHistoryProvider;
import com.avito.android.html_formatter.HtmlCleaner;
import com.avito.android.html_formatter.HtmlNodeFactory;
import com.avito.android.html_formatter.HtmlRenderOptions;
import com.avito.android.html_formatter.HtmlRenderer;
import com.avito.android.item_legacy.details.ItemDetailsSelectResultHandler;
import com.avito.android.item_legacy.details.ItemDetailsSelectResultHandlerImpl_Factory;
import com.avito.android.item_legacy.details.SelectItemBaseFragment_MembersInjector;
import com.avito.android.item_legacy.details.SelectParameterClickListener;
import com.avito.android.item_legacy.details.SelectParameterClickListenerImpl;
import com.avito.android.item_legacy.details.SelectParameterClickListenerImpl_Factory;
import com.avito.android.photo_picker.legacy.PhotoInteractor;
import com.avito.android.photo_picker.legacy.UploadingProgressInteractor;
import com.avito.android.photo_picker.legacy.api.UploadConverter;
import com.avito.android.photo_picker.legacy.service.UploadingInteractor;
import com.avito.android.photo_view.ImageListInteractor;
import com.avito.android.photo_view.ImageListPresenter;
import com.avito.android.photo_view.PhotoViewResourceProvider;
import com.avito.android.photo_view.PhotoViewResourceProviderImpl;
import com.avito.android.photo_view.PhotoViewResourceProviderImpl_Factory;
import com.avito.android.photo_view.blueprints.MultiStatePhotoItemBlueprint;
import com.avito.android.photo_view.blueprints.MultiStatePhotoItemPresenter;
import com.avito.android.publish.ContactsDataSource;
import com.avito.android.publish.PhotoUploadObserver;
import com.avito.android.publish.PhotoUploadObserverImpl;
import com.avito.android.publish.PhotoUploadObserverImpl_Factory;
import com.avito.android.publish.ProfileSourceInteractor;
import com.avito.android.publish.PublishParametersInteractor;
import com.avito.android.publish.analytics.PublishEventTracker;
import com.avito.android.publish.analytics.PublishInputsAnalyticTracker;
import com.avito.android.publish.details.ItemPostProcessor;
import com.avito.android.publish.details.ItemPostProcessor_Factory;
import com.avito.android.publish.details.PhotoInteractorWrapper;
import com.avito.android.publish.details.PublishDetailsFragment;
import com.avito.android.publish.details.PublishDetailsFragment_MembersInjector;
import com.avito.android.publish.details.PublishDetailsInteractor;
import com.avito.android.publish.details.PublishDetailsPresenter;
import com.avito.android.publish.details.PublishDetailsResourceProvider;
import com.avito.android.publish.details.VideoInteractor;
import com.avito.android.publish.details.VideoInteractorImpl;
import com.avito.android.publish.details.VideoInteractorImpl_Factory;
import com.avito.android.publish.details.adapter.date_interval.DateIntervalItemBlueprint;
import com.avito.android.publish.details.adapter.date_interval.DateIntervalItemPresenter;
import com.avito.android.publish.details.adapter.date_interval.DateIntervalItemPresenterImpl_Factory;
import com.avito.android.publish.details.adapter.edit_category.EditCategoryItemBlueprint;
import com.avito.android.publish.details.adapter.edit_category.EditCategoryItemPresenter;
import com.avito.android.publish.details.adapter.edit_category.EditCategoryItemPresenterImpl_Factory;
import com.avito.android.publish.details.adapter.header.HeaderWithDividerItemBlueprint;
import com.avito.android.publish.details.adapter.header.HeaderWithDividerItemBlueprintImpl;
import com.avito.android.publish.details.adapter.header.HeaderWithDividerItemBlueprintImpl_Factory;
import com.avito.android.publish.details.adapter.header.HeaderWithDividerItemPresenter;
import com.avito.android.publish.details.adapter.header.HeaderWithDividerItemPresenterImpl_Factory;
import com.avito.android.publish.details.adapter.multiselect.MultiselectItemBlueprint;
import com.avito.android.publish.details.adapter.multiselect.RdsMultiselectItemPresenter;
import com.avito.android.publish.details.adapter.objects.MultiStateObjectsItemBlueprint;
import com.avito.android.publish.details.adapter.objects.MultiStateObjectsItemPresenter;
import com.avito.android.publish.details.analytics.FlowTrackerFactory;
import com.avito.android.publish.details.analytics.FlowTrackerFactoryImpl;
import com.avito.android.publish.details.analytics.FlowTrackerFactoryImpl_Factory;
import com.avito.android.publish.details.analytics.PublishDetailsFlowTracker;
import com.avito.android.publish.details.analytics.PublishDetailsFlowTrackerImpl;
import com.avito.android.publish.details.analytics.PublishDetailsFlowTrackerImpl_Factory;
import com.avito.android.publish.details.analytics.PublishDetailsTracker;
import com.avito.android.publish.details.analytics.PublishDetailsTrackerImpl;
import com.avito.android.publish.details.analytics.PublishDetailsTrackerImpl_Factory;
import com.avito.android.publish.details.di.PublishDetailsComponent;
import com.avito.android.publish.details.item_wrapper.ItemWrapperFactory;
import com.avito.android.publish.details.item_wrapper.ItemWrapperFactoryImpl;
import com.avito.android.publish.details.item_wrapper.ItemWrapperFactoryImpl_Factory;
import com.avito.android.publish.details.tags.PublishTagsInteractor;
import com.avito.android.publish.details.tags.PublishTagsInteractorImpl;
import com.avito.android.publish.details.tags.PublishTagsInteractorImpl_Factory;
import com.avito.android.publish.details.tags.PublishTagsViewModel;
import com.avito.android.publish.details.tags.PublishTagsViewModelFactory;
import com.avito.android.publish.di.PublishComponent;
import com.avito.android.publish.di.PublishInputAnalyticsModule;
import com.avito.android.publish.di.PublishInputAnalyticsModule_ProvidePublishInputsAnalyticTrackerFactory;
import com.avito.android.publish.di.PublishParametersModule;
import com.avito.android.publish.di.PublishParametersModule_ProvidePublishParametersInteractorFactory;
import com.avito.android.publish.di.PublishParametersModule_ProvideUploadConverterFactory;
import com.avito.android.publish.drafts.PublishDraftRepository;
import com.avito.android.publish.drafts.PublishDraftWiper;
import com.avito.android.publish.objects.di.ImageUploadModule;
import com.avito.android.publish.objects.di.ImageUploadModule_ProvideImageListInteractor$publish_releaseFactory;
import com.avito.android.publish.objects.di.ImageUploadModule_ProvideImageListPresenter$publish_releaseFactory;
import com.avito.android.publish.objects.di.ImageUploadModule_ProvidePhotoInteractor$publish_releaseFactory;
import com.avito.android.publish.objects.di.ImageUploadModule_ProvideUploadingInteractor$publish_releaseFactory;
import com.avito.android.publish.objects.di.ImageUploadModule_ProvideUploadingProgressInteractor$publish_releaseFactory;
import com.avito.android.publish.pretend.PretendInteractor;
import com.avito.android.publish.pretend.PretendInteractorImpl;
import com.avito.android.publish.pretend.PretendInteractorImpl_Factory;
import com.avito.android.publish.slots.SlotsFactory;
import com.avito.android.publish.slots.cpa_tariff.item.CpaTariffSlotBlueprint;
import com.avito.android.publish.slots.cpa_tariff.item.CpaTariffSlotItemPresenter;
import com.avito.android.publish.slots.infomation.item.DisclaimerBlueprint;
import com.avito.android.publish.slots.infomation.item.DisclaimerItemPresenter_Factory;
import com.avito.android.publish.slots.information_with_user_id.item.InformationWithUserIdBlueprint;
import com.avito.android.publish.slots.information_with_user_id.item.InformationWithUserIdBlueprint_Factory;
import com.avito.android.publish.slots.information_with_user_id.item.InformationWithUserIdItemPresenter_Factory;
import com.avito.android.publish.slots.limits_info.LimitsInfoSlotLayoutProvider_Factory;
import com.avito.android.publish.slots.link.item.LinkSlotBlueprint;
import com.avito.android.publish.slots.link.item.LinkSlotItemPresenter;
import com.avito.android.publish.slots.market_price.item.MarketPriceBlueprint;
import com.avito.android.publish.slots.market_price.item.MarketPriceBlueprint_Factory;
import com.avito.android.publish.slots.market_price.item.MarketPriceItemPresenter_Factory;
import com.avito.android.publish.slots.market_price_v2.item.MarketPriceV2Blueprint;
import com.avito.android.publish.slots.market_price_v2.item.MarketPriceV2Blueprint_Factory;
import com.avito.android.publish.slots.market_price_v2.item.MarketPriceV2Formatter;
import com.avito.android.publish.slots.market_price_v2.item.MarketPriceV2FormatterImpl_Factory;
import com.avito.android.publish.slots.market_price_v2.item.MarketPriceV2Presenter;
import com.avito.android.publish.slots.market_price_v2.item.MarketPriceV2PresenterImpl;
import com.avito.android.publish.slots.market_price_v2.item.MarketPriceV2PresenterImpl_Factory;
import com.avito.android.publish.slots.no_car.item.NoCarSlotBlueprint;
import com.avito.android.publish.slots.no_car.item.NoCarSlotItemPresenter;
import com.avito.android.publish.slots.profile_info.PublishContactsStringProvider;
import com.avito.android.publish.slots.profile_info.item.UserInfoItemBlueprint;
import com.avito.android.publish.slots.profile_info.item.UserInfoItemPresenter;
import com.avito.android.publish.view.BasicParameterClickListener;
import com.avito.android.publish.view.BasicParameterClickListenerImpl;
import com.avito.android.publish.view.BasicParameterClickListenerImpl_Factory;
import com.avito.android.publish.view.ItemDetailsBaseFragment_MembersInjector;
import com.avito.android.publish.view.ItemDetailsParameterClickListener;
import com.avito.android.publish.view.ItemDetailsParameterClickListenerImpl;
import com.avito.android.publish.view.ItemDetailsParameterClickListenerImpl_Factory;
import com.avito.android.publish.view.LocationParameterClickListener;
import com.avito.android.publish.view.LocationParameterClickListenerImpl_Factory;
import com.avito.android.publish_limits_info.analytics.PublishLimitsAnalyticsModule_ProvideAnalyticsFactory;
import com.avito.android.publish_limits_info.analytics.PublishLimitsEventTracker;
import com.avito.android.publish_limits_info.item.LimitsInfoItemBlueprint;
import com.avito.android.publish_limits_info.item.LimitsInfoItemBlueprint_Factory;
import com.avito.android.publish_limits_info.item.LimitsInfoItemPresenter;
import com.avito.android.publish_limits_info.item.LimitsInfoItemPresenterImpl;
import com.avito.android.publish_limits_info.item.LimitsInfoItemPresenterImpl_Factory;
import com.avito.android.recycler.data_aware.DataAwareAdapterPresenter;
import com.avito.android.recycler.data_aware.DiffCalculator;
import com.avito.android.remote.ProfileApi;
import com.avito.android.remote.PublishApi;
import com.avito.android.remote.PublishLimitsApi;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.remote.model.category_parameters.AttributesTreeConverter;
import com.avito.android.remote.model.category_parameters.CategoryParametersConverter;
import com.avito.android.server_time.TimeSource;
import com.avito.android.ui.widget.tagged_input.TagsViewModel;
import com.avito.android.ui.widget.tagged_input.analytics.TagSelectionTracker;
import com.avito.android.util.BuildInfo;
import com.avito.android.util.DeviceMetrics;
import com.avito.android.util.DialogRouter;
import com.avito.android.util.ImplicitIntentFactory;
import com.avito.android.util.ParametersListRdsContentsComparator;
import com.avito.android.util.PhoneNumberFormatterModule_ProvidePhoneNumberFormatterWithCountryCodeFactory;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.text.AttributedTextFormatter;
import com.avito.android.util.text.AttributedTextFormatterModule_ProvideAttributedTextFormatterFactory;
import com.avito.android.validate_advert.remote.ValidateAdvertApi;
import com.avito.android.validation.CategoryParameterStringValueConverter;
import com.avito.android.validation.ParametersListInteractor;
import com.avito.android.validation.ParametersListModule;
import com.avito.android.validation.ParametersListModule_ProvideAdapterPresenterFactory;
import com.avito.android.validation.ParametersListModule_ProvideCategoryParameterStringValueConverterFactory;
import com.avito.android.validation.ParametersListModule_ProvideChipsMultiselectItemPresenterFactory;
import com.avito.android.validation.ParametersListModule_ProvideChipsSelectItemBlueprintFactory;
import com.avito.android.validation.ParametersListModule_ProvideChipsSelectItemPresenterFactory;
import com.avito.android.validation.ParametersListModule_ProvideContentsComparatorFactory;
import com.avito.android.validation.ParametersListModule_ProvideDataAwareAdapterFactory;
import com.avito.android.validation.ParametersListModule_ProvideDiffCalculatorFactory;
import com.avito.android.validation.ParametersListModule_ProvideHtmlRenderOptionsFactory;
import com.avito.android.validation.ParametersListModule_ProvideInputItemBlueprintFactory;
import com.avito.android.validation.ParametersListModule_ProvideInputItemPresenterFactory;
import com.avito.android.validation.ParametersListModule_ProvideListUpdateListenerFactory;
import com.avito.android.validation.ParametersListModule_ProvideLocalPretendInteractorResourceProviderFactory;
import com.avito.android.validation.ParametersListModule_ProvideMultiStateInputWithTagsItemBlueprintFactory;
import com.avito.android.validation.ParametersListModule_ProvideMultiStateInputWithTagsItemPresenterFactory;
import com.avito.android.validation.ParametersListModule_ProvideMultiStateSwitcherItemBlueprintFactory;
import com.avito.android.validation.ParametersListModule_ProvideMultiStateSwitcherItemPresenterFactory;
import com.avito.android.validation.ParametersListModule_ProvideParametersListInteractorFactory;
import com.avito.android.validation.ParametersListModule_ProvideParametersListPresenterFactory;
import com.avito.android.validation.ParametersListModule_ProvideParametersValidatorFactory;
import com.avito.android.validation.ParametersListModule_ProvideRadioGroupSelectItemBlueprintFactory;
import com.avito.android.validation.ParametersListModule_ProvideRadioGroupSelectItemPresenterFactory;
import com.avito.android.validation.ParametersListModule_ProvideRecyclerAdapterFactory;
import com.avito.android.validation.ParametersListModule_ProvideTagSelectionTracker$item_temporary_releaseFactory;
import com.avito.android.validation.ParametersListModule_ProvideVehicleRegNumberInputItemBlueprintFactory;
import com.avito.android.validation.ParametersListModule_ProvideVehicleRegNumberInputItemPresenterFactory;
import com.avito.android.validation.ParametersListModule_ProvideVehicleRegNumberRegionTextWatcherFactory;
import com.avito.android.validation.ParametersListPresenter;
import com.avito.android.validation.ParametersValidator;
import com.avito.android.validation.ParametersValidatorResourceProvider;
import com.avito.android.validation.ValidationLogger;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import com.avito.konveyor.blueprint.ItemPresenter;
import dagger.internal.DelegateFactory;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import dagger.internal.SingleCheck;
import java.util.Locale;
import java.util.Set;
import javax.inject.Provider;
public final class DaggerPublishDetailsComponent implements PublishDetailsComponent {
    public Provider<SelectParameterClickListener> A;
    public Provider<ButtonItemBlueprint> A0;
    public Provider<PublishEventTracker> A1;
    public Provider<DeepLinkFactory> B;
    public Provider<PublishTagsInteractorImpl> B0;
    public Provider<PublishInputsAnalyticTracker> B1;
    public Provider<BasicParameterClickListenerImpl> C;
    public Provider<PublishTagsInteractor> C0;
    public Provider<UploadingProgressInteractor> C1;
    public Provider<BasicParameterClickListener> D;
    public Provider<PublishTagsViewModelFactory> D0;
    public Provider<ProfileSourceInteractor> D1;
    public Provider<ItemDetailsParameterClickListenerImpl> E;
    public Provider<PublishTagsViewModel> E0;
    public Provider<SchedulersFactory3> E1;
    public Provider<ItemDetailsParameterClickListener> F;
    public Provider<TagsViewModel> F0;
    public Provider<ProfileApi> F1;
    public Provider<TimeSource> G;
    public Provider<MultiStateInputWithTagsItemPresenter> G0;
    public Provider<PublishLimitsApi> G1;
    public Provider<Locale> H;
    public Provider<TagSelectionTracker> H0;
    public Provider<TypedErrorThrowableConverter> H1;
    public Provider<AbTestsConfigProvider> I;
    public Provider<MultiStateInputWithTagsItemBlueprint> I0;
    public Provider<AccountStorageInteractor> I1;
    public Provider<HtmlCleaner> J;
    public Provider<NoCarSlotItemPresenter> J0;
    public Provider<ScreenTrackerFactory> J1;
    public Provider<HtmlNodeFactory> K;
    public Provider<NoCarSlotBlueprint> K0;
    public Provider<TimerFactory> K1;
    public Provider<CategoryParametersElementConverter> L;
    public Provider<CpaTariffSlotItemPresenter> L0;
    public Provider<ScreenFlowTrackerProvider> L1;
    public Provider<ParametersValidatorResourceProvider> M;
    public Provider<CpaTariffSlotBlueprint> M0;
    public Provider<ScreenDiInjectTracker> M1;
    public Provider<HtmlRenderer> N;
    public Provider<UserInfoItemPresenter> N0;
    public Provider<ScreenInitTracker> N1;
    public Provider<ParametersValidator> O;
    public Provider<AvatarRenderer> O0;
    public Provider<ScreenTransferRecovery.Impl> O1;
    public Provider<ValidationLogger> P;
    public Provider<UserInfoItemBlueprint> P0;
    public Provider<ScreenTransferRecovery> P1;
    public Provider<Resources> Q;
    public Provider<PublishLimitsEventTracker> Q0;
    public Provider<PublishDetailsTrackerImpl> Q1;
    public Provider<CategoryParameterStringValueConverter> R;
    public Provider<LimitsInfoItemPresenterImpl> R0;
    public Provider<PublishDetailsTracker> R1;
    public Provider<ParametersListInteractor> S;
    public Provider<LimitsInfoItemPresenter> S0;
    public Provider<ContactsDataSource> S1;
    public Provider<DataAwareAdapterPresenter> T;
    public Provider<LimitsInfoItemBlueprint.LayoutProvider> T0;
    public Provider<PublishContactsStringProvider> T1;
    public Provider<AttributedTextFormatter> U;
    public Provider<LimitsInfoItemBlueprint> U0;
    public Provider<SessionChangeTrackerImpl> U1;
    public Provider<MultiStateSelectItemPresenter> V;
    public Provider<DisclaimerBlueprint> V0;
    public Provider<SessionChangeTracker> V1;
    public Provider<MultiStateSelectItemBlueprint> W;
    public Provider<MarketPriceBlueprint> W0;
    public Provider<SlotsFactory> W1;
    public Provider<ChipsSelectItemPresenter> X;
    public Provider<MarketPriceV2Formatter> X0;
    public Provider<DeviceMetrics> X1;
    public Provider<ChipsSelectItemBlueprint> Y;
    public Provider<MarketPriceV2PresenterImpl> Y0;
    public Provider<PhotoUploadObserverImpl> Y1;
    public Provider<RadioGroupSelectItemPresenter> Z;
    public Provider<MarketPriceV2Presenter> Z0;
    public Provider<PhotoUploadObserver> Z1;
    public final PublishComponent a;
    public Provider<RadioGroupSelectItemBlueprint> a0;
    public Provider<MarketPriceV2Blueprint> a1;

    /* renamed from: a2  reason: collision with root package name */
    public Provider<VideoInteractorImpl> f57a2;
    public Provider<ItemDetailsSelectResultHandler> b = DoubleCheck.provider(ItemDetailsSelectResultHandlerImpl_Factory.create());
    public Provider<MultiStateSwitcherItemPresenter> b0;
    public Provider<CreRangePresenterImpl> b1;
    public Provider<VideoInteractor> b2;
    public Provider<ValidateAdvertApi> c;
    public Provider<MultiStateSwitcherItemBlueprint> c0;
    public Provider<CreRangePresenter> c1;
    public Provider<ItemWrapperFactoryImpl> c2;
    public Provider<SchedulersFactory> d;
    public Provider<HtmlRenderOptions> d0;
    public Provider<CreRangeItemBlueprint> d1;
    public Provider<ItemWrapperFactory> d2;
    public Provider<CategoryParametersConverter> e;
    public Provider<EditorHistoryProvider> e0;
    public Provider<TextWatcher> e1;
    public Provider<ItemPostProcessor> e2;
    public Provider<PublishAnalyticsDataProvider> f;
    public Provider<HtmlEditorViewModelFactory> f0;
    public Provider<VehicleRegNumberInputItemPresenter> f1;
    public Provider<FlowTrackerFactoryImpl> f2;
    public Provider<Features> g;
    public Provider<HtmlEditorViewModel> g0;
    public Provider<VehicleRegNumberInputItemBlueprint> g1;
    public Provider<FlowTrackerFactory> g2;
    public Provider<PretendInteractorImpl> h;
    public Provider<MultiStateInputItemPresenter> h0;
    public Provider<VideoItemPresenter> h1;
    public Provider<PublishDetailsFlowTrackerImpl> h2;
    public Provider<PretendInteractor> i;
    public Provider<MultiStateInputItemBlueprint> i0;
    public Provider<VideoItemBlueprint> i1;
    public Provider<PublishDetailsFlowTracker> i2;
    public Provider<PublishApi> j;
    public Provider<ImageListInteractor> j0;
    public Provider<LinkSlotItemPresenter> j1;
    public Provider<RecyclerView.Adapter<?>> j2;
    public Provider<PublishDraftRepository> k;
    public Provider<UploadingInteractor> k0;
    public Provider<LinkSlotBlueprint> k1;
    public Provider<Context> l;
    public Provider<ImageListPresenter> l0;
    public Provider<HeaderWithDividerItemPresenter> l1;
    public Provider<Analytics> m;
    public Provider<PhotoViewResourceProviderImpl> m0;
    public Provider<HeaderWithDividerItemBlueprintImpl> m1;
    public Provider<UploadConverter> n;
    public Provider<PhotoViewResourceProvider> n0;
    public Provider<HeaderWithDividerItemBlueprint> n1;
    public Provider<AttributesTreeConverter> o;
    public Provider<MultiStatePhotoItemPresenter> o0;
    public Provider<InformationWithUserIdBlueprint> o1;
    public Provider<PublishDraftWiper> p;
    public Provider<MultiStatePhotoItemBlueprint> p0;
    public Provider<ChipsMultiselectItemPresenter> p1;
    public Provider<PublishParametersInteractor> q;
    public Provider<DateIntervalItemPresenter> q0;
    public Provider<ChipsMultiselectItemBlueprint> q1;
    public Provider<PublishDetailsInteractor> r;
    public Provider<DateIntervalItemBlueprint> r0;
    public Provider<ItemBinder> r1;
    public Provider<Application> s;
    public Provider<EditCategoryItemPresenter> s0;
    public Provider<SimpleRecyclerAdapter> s1;
    public Provider<BuildInfo> t;
    public Provider<EditCategoryItemBlueprint> t0;
    public Provider<ListUpdateCallback> t1;
    public Provider<ComputerVisionInteractor> u;
    public Provider<RdsMultiselectItemPresenter> u0;
    public Provider<AdapterPresenter> u1;
    public Provider<PhotoInteractor> v;
    public Provider<MultiselectItemBlueprint> v0;
    public Provider<ParametersListRdsContentsComparator> v1;
    public Provider<PhotoInteractorWrapper> w;
    public Provider<MultiStateObjectsItemPresenter> w0;
    public Provider<DiffCalculator> w1;
    public Provider<LocationParameterClickListener> x;
    public Provider<MultiStateObjectsItemBlueprint> x0;
    public Provider<Set<ItemPresenter<?, ?>>> x1;
    public Provider<Integer> y;
    public Provider<PublishDetailsPresenter> y0;
    public Provider<ParametersListPresenter> y1;
    public Provider<SelectParameterClickListenerImpl> z;
    public Provider<ButtonItemPresenter> z0;
    public Provider<PublishDetailsResourceProvider> z1;

    public static class a0 implements Provider<PublishLimitsApi> {
        public final PublishComponent a;

        public a0(PublishComponent publishComponent) {
            this.a = publishComponent;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public PublishLimitsApi get() {
            return (PublishLimitsApi) Preconditions.checkNotNullFromComponent(this.a.publishLimitsApi());
        }
    }

    public static final class b implements PublishDetailsComponent.Builder {
        public Resources a;
        public Integer b;
        public PublishComponent c;
        public PublishDetailsModule d;
        public ImageUploadModule e;
        public ParametersListModule f;
        public PublishDetailsAnalyticsModule g;

        public b(a aVar) {
        }

        @Override // com.avito.android.publish.details.di.PublishDetailsComponent.Builder
        public PublishDetailsComponent build() {
            Preconditions.checkBuilderRequirement(this.a, Resources.class);
            Preconditions.checkBuilderRequirement(this.b, Integer.class);
            Preconditions.checkBuilderRequirement(this.c, PublishComponent.class);
            Preconditions.checkBuilderRequirement(this.d, PublishDetailsModule.class);
            Preconditions.checkBuilderRequirement(this.e, ImageUploadModule.class);
            Preconditions.checkBuilderRequirement(this.f, ParametersListModule.class);
            Preconditions.checkBuilderRequirement(this.g, PublishDetailsAnalyticsModule.class);
            return new DaggerPublishDetailsComponent(this.d, this.f, new PublishParametersModule(), this.g, this.e, new PublishInputAnalyticsModule(), this.c, this.a, this.b, null);
        }

        @Override // com.avito.android.publish.details.di.PublishDetailsComponent.Builder
        public PublishDetailsComponent.Builder imageUploadModule(ImageUploadModule imageUploadModule) {
            this.e = (ImageUploadModule) Preconditions.checkNotNull(imageUploadModule);
            return this;
        }

        @Override // com.avito.android.publish.details.di.PublishDetailsComponent.Builder
        public PublishDetailsComponent.Builder parametersListModule(ParametersListModule parametersListModule) {
            this.f = (ParametersListModule) Preconditions.checkNotNull(parametersListModule);
            return this;
        }

        @Override // com.avito.android.publish.details.di.PublishDetailsComponent.Builder
        public PublishDetailsComponent.Builder publishComponent(PublishComponent publishComponent) {
            this.c = (PublishComponent) Preconditions.checkNotNull(publishComponent);
            return this;
        }

        @Override // com.avito.android.publish.details.di.PublishDetailsComponent.Builder
        public PublishDetailsComponent.Builder publishDetailsAnalyticsModule(PublishDetailsAnalyticsModule publishDetailsAnalyticsModule) {
            this.g = (PublishDetailsAnalyticsModule) Preconditions.checkNotNull(publishDetailsAnalyticsModule);
            return this;
        }

        @Override // com.avito.android.publish.details.di.PublishDetailsComponent.Builder
        public PublishDetailsComponent.Builder publishDetailsModule(PublishDetailsModule publishDetailsModule) {
            this.d = (PublishDetailsModule) Preconditions.checkNotNull(publishDetailsModule);
            return this;
        }

        @Override // com.avito.android.publish.details.di.PublishDetailsComponent.Builder
        public PublishDetailsComponent.Builder resources(Resources resources) {
            this.a = (Resources) Preconditions.checkNotNull(resources);
            return this;
        }

        @Override // com.avito.android.publish.details.di.PublishDetailsComponent.Builder
        public PublishDetailsComponent.Builder withMinValuesForSearch(int i) {
            this.b = (Integer) Preconditions.checkNotNull(Integer.valueOf(i));
            return this;
        }
    }

    public static class b0 implements Provider<SchedulersFactory3> {
        public final PublishComponent a;

        public b0(PublishComponent publishComponent) {
            this.a = publishComponent;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory3 get() {
            return (SchedulersFactory3) Preconditions.checkNotNullFromComponent(this.a.schedulers3());
        }
    }

    public static class c implements Provider<AbTestsConfigProvider> {
        public final PublishComponent a;

        public c(PublishComponent publishComponent) {
            this.a = publishComponent;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public AbTestsConfigProvider get() {
            return (AbTestsConfigProvider) Preconditions.checkNotNullFromComponent(this.a.abTestsConfigProvider());
        }
    }

    public static class c0 implements Provider<SchedulersFactory> {
        public final PublishComponent a;

        public c0(PublishComponent publishComponent) {
            this.a = publishComponent;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory get() {
            return (SchedulersFactory) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory());
        }
    }

    public static class d implements Provider<AccountStorageInteractor> {
        public final PublishComponent a;

        public d(PublishComponent publishComponent) {
            this.a = publishComponent;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public AccountStorageInteractor get() {
            return (AccountStorageInteractor) Preconditions.checkNotNullFromComponent(this.a.accountStorageInteractor());
        }
    }

    public static class d0 implements Provider<ScreenTrackerFactory> {
        public final PublishComponent a;

        public d0(PublishComponent publishComponent) {
            this.a = publishComponent;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ScreenTrackerFactory get() {
            return (ScreenTrackerFactory) Preconditions.checkNotNullFromComponent(this.a.screenTrackerFactory());
        }
    }

    public static class e implements Provider<Analytics> {
        public final PublishComponent a;

        public e(PublishComponent publishComponent) {
            this.a = publishComponent;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Analytics get() {
            return (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics());
        }
    }

    public static class e0 implements Provider<TimeSource> {
        public final PublishComponent a;

        public e0(PublishComponent publishComponent) {
            this.a = publishComponent;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public TimeSource get() {
            return (TimeSource) Preconditions.checkNotNullFromComponent(this.a.timeSource());
        }
    }

    public static class f implements Provider<Application> {
        public final PublishComponent a;

        public f(PublishComponent publishComponent) {
            this.a = publishComponent;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Application get() {
            return (Application) Preconditions.checkNotNullFromComponent(this.a.application());
        }
    }

    public static class f0 implements Provider<TimerFactory> {
        public final PublishComponent a;

        public f0(PublishComponent publishComponent) {
            this.a = publishComponent;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public TimerFactory get() {
            return (TimerFactory) Preconditions.checkNotNullFromComponent(this.a.timerFactory());
        }
    }

    public static class g implements Provider<AttributesTreeConverter> {
        public final PublishComponent a;

        public g(PublishComponent publishComponent) {
            this.a = publishComponent;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public AttributesTreeConverter get() {
            return (AttributesTreeConverter) Preconditions.checkNotNullFromComponent(this.a.attributesConverter());
        }
    }

    public static class g0 implements Provider<TypedErrorThrowableConverter> {
        public final PublishComponent a;

        public g0(PublishComponent publishComponent) {
            this.a = publishComponent;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public TypedErrorThrowableConverter get() {
            return (TypedErrorThrowableConverter) Preconditions.checkNotNullFromComponent(this.a.typedErrorThrowableConverter());
        }
    }

    public static class h implements Provider<BuildInfo> {
        public final PublishComponent a;

        public h(PublishComponent publishComponent) {
            this.a = publishComponent;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public BuildInfo get() {
            return (BuildInfo) Preconditions.checkNotNullFromComponent(this.a.buildInfo());
        }
    }

    public static class h0 implements Provider<ValidateAdvertApi> {
        public final PublishComponent a;

        public h0(PublishComponent publishComponent) {
            this.a = publishComponent;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ValidateAdvertApi get() {
            return (ValidateAdvertApi) Preconditions.checkNotNullFromComponent(this.a.validateAdvertApi());
        }
    }

    public static class i implements Provider<CategoryParametersConverter> {
        public final PublishComponent a;

        public i(PublishComponent publishComponent) {
            this.a = publishComponent;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public CategoryParametersConverter get() {
            return (CategoryParametersConverter) Preconditions.checkNotNullFromComponent(this.a.categoryParametersConverter());
        }
    }

    public static class j implements Provider<ComputerVisionInteractor> {
        public final PublishComponent a;

        public j(PublishComponent publishComponent) {
            this.a = publishComponent;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ComputerVisionInteractor get() {
            return (ComputerVisionInteractor) Preconditions.checkNotNullFromComponent(this.a.computerVisionInteractor());
        }
    }

    public static class k implements Provider<Context> {
        public final PublishComponent a;

        public k(PublishComponent publishComponent) {
            this.a = publishComponent;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Context get() {
            return (Context) Preconditions.checkNotNullFromComponent(this.a.context());
        }
    }

    public static class l implements Provider<DeepLinkFactory> {
        public final PublishComponent a;

        public l(PublishComponent publishComponent) {
            this.a = publishComponent;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public DeepLinkFactory get() {
            return (DeepLinkFactory) Preconditions.checkNotNullFromComponent(this.a.deepLinkFactory());
        }
    }

    public static class m implements Provider<DeviceMetrics> {
        public final PublishComponent a;

        public m(PublishComponent publishComponent) {
            this.a = publishComponent;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public DeviceMetrics get() {
            return (DeviceMetrics) Preconditions.checkNotNullFromComponent(this.a.deviceMetrics());
        }
    }

    public static class n implements Provider<EditorHistoryProvider> {
        public final PublishComponent a;

        public n(PublishComponent publishComponent) {
            this.a = publishComponent;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public EditorHistoryProvider get() {
            return (EditorHistoryProvider) Preconditions.checkNotNullFromComponent(this.a.editorHistoryProvider());
        }
    }

    public static class o implements Provider<Features> {
        public final PublishComponent a;

        public o(PublishComponent publishComponent) {
            this.a = publishComponent;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Features get() {
            return (Features) Preconditions.checkNotNullFromComponent(this.a.features());
        }
    }

    public static class p implements Provider<HtmlCleaner> {
        public final PublishComponent a;

        public p(PublishComponent publishComponent) {
            this.a = publishComponent;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public HtmlCleaner get() {
            return (HtmlCleaner) Preconditions.checkNotNullFromComponent(this.a.htmlCleaner());
        }
    }

    public static class q implements Provider<HtmlNodeFactory> {
        public final PublishComponent a;

        public q(PublishComponent publishComponent) {
            this.a = publishComponent;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public HtmlNodeFactory get() {
            return (HtmlNodeFactory) Preconditions.checkNotNullFromComponent(this.a.htmlNodeFactory());
        }
    }

    public static class r implements Provider<HtmlRenderer> {
        public final PublishComponent a;

        public r(PublishComponent publishComponent) {
            this.a = publishComponent;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public HtmlRenderer get() {
            return (HtmlRenderer) Preconditions.checkNotNullFromComponent(this.a.htmlRenderer());
        }
    }

    public static class s implements Provider<Locale> {
        public final PublishComponent a;

        public s(PublishComponent publishComponent) {
            this.a = publishComponent;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Locale get() {
            return (Locale) Preconditions.checkNotNullFromComponent(this.a.locale());
        }
    }

    public static class t implements Provider<ProfileApi> {
        public final PublishComponent a;

        public t(PublishComponent publishComponent) {
            this.a = publishComponent;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ProfileApi get() {
            return (ProfileApi) Preconditions.checkNotNullFromComponent(this.a.profileApi());
        }
    }

    public static class u implements Provider<ProfileSourceInteractor> {
        public final PublishComponent a;

        public u(PublishComponent publishComponent) {
            this.a = publishComponent;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ProfileSourceInteractor get() {
            return (ProfileSourceInteractor) Preconditions.checkNotNullFromComponent(this.a.profileSource());
        }
    }

    public static class v implements Provider<PublishAnalyticsDataProvider> {
        public final PublishComponent a;

        public v(PublishComponent publishComponent) {
            this.a = publishComponent;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public PublishAnalyticsDataProvider get() {
            return (PublishAnalyticsDataProvider) Preconditions.checkNotNullFromComponent(this.a.publishAnalyticsDataProvider());
        }
    }

    public static class w implements Provider<PublishApi> {
        public final PublishComponent a;

        public w(PublishComponent publishComponent) {
            this.a = publishComponent;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public PublishApi get() {
            return (PublishApi) Preconditions.checkNotNullFromComponent(this.a.publishApi());
        }
    }

    public static class x implements Provider<PublishDraftRepository> {
        public final PublishComponent a;

        public x(PublishComponent publishComponent) {
            this.a = publishComponent;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public PublishDraftRepository get() {
            return (PublishDraftRepository) Preconditions.checkNotNullFromComponent(this.a.publishDraftRepository());
        }
    }

    public static class y implements Provider<PublishDraftWiper> {
        public final PublishComponent a;

        public y(PublishComponent publishComponent) {
            this.a = publishComponent;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public PublishDraftWiper get() {
            return (PublishDraftWiper) Preconditions.checkNotNullFromComponent(this.a.publishDraftWiper());
        }
    }

    public static class z implements Provider<PublishEventTracker> {
        public final PublishComponent a;

        public z(PublishComponent publishComponent) {
            this.a = publishComponent;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public PublishEventTracker get() {
            return (PublishEventTracker) Preconditions.checkNotNullFromComponent(this.a.publishEventTracker());
        }
    }

    public DaggerPublishDetailsComponent(PublishDetailsModule publishDetailsModule, ParametersListModule parametersListModule, PublishParametersModule publishParametersModule, PublishDetailsAnalyticsModule publishDetailsAnalyticsModule, ImageUploadModule imageUploadModule, PublishInputAnalyticsModule publishInputAnalyticsModule, PublishComponent publishComponent, Resources resources, Integer num, a aVar) {
        this.a = publishComponent;
        h0 h0Var = new h0(publishComponent);
        this.c = h0Var;
        c0 c0Var = new c0(publishComponent);
        this.d = c0Var;
        i iVar = new i(publishComponent);
        this.e = iVar;
        v vVar = new v(publishComponent);
        this.f = vVar;
        o oVar = new o(publishComponent);
        this.g = oVar;
        PretendInteractorImpl_Factory create = PretendInteractorImpl_Factory.create(h0Var, c0Var, iVar, vVar, oVar);
        this.h = create;
        this.i = DoubleCheck.provider(create);
        this.j = new w(publishComponent);
        this.k = new x(publishComponent);
        k kVar = new k(publishComponent);
        this.l = kVar;
        e eVar = new e(publishComponent);
        this.m = eVar;
        Provider<UploadConverter> provider = SingleCheck.provider(PublishParametersModule_ProvideUploadConverterFactory.create(publishParametersModule, kVar, eVar));
        this.n = provider;
        g gVar = new g(publishComponent);
        this.o = gVar;
        y yVar = new y(publishComponent);
        this.p = yVar;
        Provider<PublishParametersInteractor> provider2 = SingleCheck.provider(PublishParametersModule_ProvidePublishParametersInteractorFactory.create(publishParametersModule, this.j, this.f, this.k, provider, this.e, gVar, yVar, this.g));
        this.q = provider2;
        this.r = DoubleCheck.provider(PublishDetailsModule_ProvideDetailsInteractorFactory.create(publishDetailsModule, this.i, provider2));
        f fVar = new f(publishComponent);
        this.s = fVar;
        h hVar = new h(publishComponent);
        this.t = hVar;
        j jVar = new j(publishComponent);
        this.u = jVar;
        Provider<PhotoInteractor> provider3 = DoubleCheck.provider(ImageUploadModule_ProvidePhotoInteractor$publish_releaseFactory.create(imageUploadModule, fVar, hVar, jVar));
        this.v = provider3;
        this.w = DoubleCheck.provider(PublishDetailsModule_ProvideInsertPhotoInteractorFactory.create(publishDetailsModule, provider3));
        this.x = DoubleCheck.provider(LocationParameterClickListenerImpl_Factory.create());
        Factory create2 = InstanceFactory.create(num);
        this.y = create2;
        SelectParameterClickListenerImpl_Factory create3 = SelectParameterClickListenerImpl_Factory.create(create2, this.g);
        this.z = create3;
        Provider<SelectParameterClickListener> provider4 = DoubleCheck.provider(create3);
        this.A = provider4;
        l lVar = new l(publishComponent);
        this.B = lVar;
        BasicParameterClickListenerImpl_Factory create4 = BasicParameterClickListenerImpl_Factory.create(this.x, provider4, lVar);
        this.C = create4;
        Provider<BasicParameterClickListener> provider5 = DoubleCheck.provider(create4);
        this.D = provider5;
        ItemDetailsParameterClickListenerImpl_Factory create5 = ItemDetailsParameterClickListenerImpl_Factory.create(provider5);
        this.E = create5;
        this.F = DoubleCheck.provider(create5);
        this.G = new e0(publishComponent);
        this.H = new s(publishComponent);
        this.I = new c(publishComponent);
        this.J = new p(publishComponent);
        this.K = new q(publishComponent);
        this.L = DoubleCheck.provider(PublishDetailsModule_ProvideCategoryParametersElementConverterFactory.create(publishDetailsModule, PhoneNumberFormatterModule_ProvidePhoneNumberFormatterWithCountryCodeFactory.create(), this.G, this.H, this.g, this.I, this.J, this.K));
        Provider<ParametersValidatorResourceProvider> provider6 = DoubleCheck.provider(ParametersListModule_ProvideLocalPretendInteractorResourceProviderFactory.create(parametersListModule));
        this.M = provider6;
        r rVar = new r(publishComponent);
        this.N = rVar;
        this.O = DoubleCheck.provider(ParametersListModule_ProvideParametersValidatorFactory.create(parametersListModule, provider6, this.g, rVar, this.J));
        this.P = DoubleCheck.provider(PublishDetailsModule_ProvideValidationLoggerFactory.create(publishDetailsModule, this.m, this.f));
        Factory create6 = InstanceFactory.create(resources);
        this.Q = create6;
        this.R = DoubleCheck.provider(ParametersListModule_ProvideCategoryParameterStringValueConverterFactory.create(parametersListModule, this.H, create6, PhoneNumberFormatterModule_ProvidePhoneNumberFormatterWithCountryCodeFactory.create()));
        this.S = DoubleCheck.provider(ParametersListModule_ProvideParametersListInteractorFactory.create(parametersListModule, this.O, this.d, this.P, PhoneNumberFormatterModule_ProvidePhoneNumberFormatterWithCountryCodeFactory.create(), this.R, this.t));
        this.T = new DelegateFactory();
        Provider<AttributedTextFormatter> provider7 = SingleCheck.provider(AttributedTextFormatterModule_ProvideAttributedTextFormatterFactory.create());
        this.U = provider7;
        Provider<MultiStateSelectItemPresenter> provider8 = DoubleCheck.provider(PublishDetailsModule_ProvideSelectItemPresenterFactory.create(publishDetailsModule, provider7));
        this.V = provider8;
        this.W = DoubleCheck.provider(PublishDetailsModule_ProvideSelectItemBlueprintFactory.create(publishDetailsModule, provider8));
        Provider<ChipsSelectItemPresenter> provider9 = DoubleCheck.provider(ParametersListModule_ProvideChipsSelectItemPresenterFactory.create(parametersListModule));
        this.X = provider9;
        this.Y = DoubleCheck.provider(ParametersListModule_ProvideChipsSelectItemBlueprintFactory.create(parametersListModule, provider9, this.U));
        Provider<RadioGroupSelectItemPresenter> provider10 = DoubleCheck.provider(ParametersListModule_ProvideRadioGroupSelectItemPresenterFactory.create(parametersListModule));
        this.Z = provider10;
        this.a0 = DoubleCheck.provider(ParametersListModule_ProvideRadioGroupSelectItemBlueprintFactory.create(parametersListModule, provider10));
        Provider<MultiStateSwitcherItemPresenter> provider11 = DoubleCheck.provider(ParametersListModule_ProvideMultiStateSwitcherItemPresenterFactory.create(parametersListModule, this.U));
        this.b0 = provider11;
        this.c0 = DoubleCheck.provider(ParametersListModule_ProvideMultiStateSwitcherItemBlueprintFactory.create(parametersListModule, provider11));
        Provider<HtmlRenderOptions> provider12 = DoubleCheck.provider(ParametersListModule_ProvideHtmlRenderOptionsFactory.create(parametersListModule, this.Q));
        this.d0 = provider12;
        n nVar = new n(publishComponent);
        this.e0 = nVar;
        Provider<HtmlEditorViewModelFactory> provider13 = DoubleCheck.provider(PublishDetailsModule_ProvideHtmlEditorViewModelFactoryFactory.create(publishDetailsModule, nVar, this.K, provider12));
        this.f0 = provider13;
        Provider<HtmlEditorViewModel> provider14 = DoubleCheck.provider(PublishDetailsModule_ProvideHtmlEditorViewModelFactory.create(publishDetailsModule, provider13));
        this.g0 = provider14;
        Provider<MultiStateInputItemPresenter> provider15 = DoubleCheck.provider(ParametersListModule_ProvideInputItemPresenterFactory.create(parametersListModule, this.U, this.d0, provider14));
        this.h0 = provider15;
        this.i0 = DoubleCheck.provider(ParametersListModule_ProvideInputItemBlueprintFactory.create(parametersListModule, provider15));
        this.j0 = DoubleCheck.provider(ImageUploadModule_ProvideImageListInteractor$publish_releaseFactory.create(imageUploadModule, this.d, this.v));
        Provider<UploadingInteractor> provider16 = DoubleCheck.provider(ImageUploadModule_ProvideUploadingInteractor$publish_releaseFactory.create(imageUploadModule, this.s));
        this.k0 = provider16;
        this.l0 = DoubleCheck.provider(ImageUploadModule_ProvideImageListPresenter$publish_releaseFactory.create(imageUploadModule, this.j0, provider16, this.d));
        PhotoViewResourceProviderImpl_Factory create7 = PhotoViewResourceProviderImpl_Factory.create(this.Q);
        this.m0 = create7;
        Provider<PhotoViewResourceProvider> provider17 = DoubleCheck.provider(create7);
        this.n0 = provider17;
        Provider<MultiStatePhotoItemPresenter> provider18 = DoubleCheck.provider(PublishDetailsModule_ProvideMultiStatePhotoItemPresenterFactory.create(publishDetailsModule, this.l0, this.U, provider17));
        this.o0 = provider18;
        this.p0 = DoubleCheck.provider(PublishDetailsModule_ProvidePhotoItemBlueprintFactory.create(publishDetailsModule, provider18));
        Provider<DateIntervalItemPresenter> provider19 = DoubleCheck.provider(DateIntervalItemPresenterImpl_Factory.create());
        this.q0 = provider19;
        this.r0 = DoubleCheck.provider(PublishDetailsModule_ProvideDateIntervalItemBlueprintFactory.create(publishDetailsModule, provider19));
        Provider<EditCategoryItemPresenter> provider20 = DoubleCheck.provider(EditCategoryItemPresenterImpl_Factory.create());
        this.s0 = provider20;
        this.t0 = DoubleCheck.provider(PublishDetailsModule_ProvideEditCategoryItemBlueprintFactory.create(publishDetailsModule, provider20));
        Provider<RdsMultiselectItemPresenter> provider21 = DoubleCheck.provider(PublishDetailsModule_ProvideMultiselectItemPresenterFactory.create(publishDetailsModule, this.U));
        this.u0 = provider21;
        this.v0 = DoubleCheck.provider(PublishDetailsModule_ProvideMultiselectItemBlueprintFactory.create(publishDetailsModule, provider21));
        Provider<MultiStateObjectsItemPresenter> provider22 = DoubleCheck.provider(PublishDetailsModule_ProvideObjectsItemPresenterFactory.create(publishDetailsModule));
        this.w0 = provider22;
        this.x0 = DoubleCheck.provider(PublishDetailsModule_ProvideObjectsItemBlueprintFactory.create(publishDetailsModule, provider22));
        DelegateFactory delegateFactory = new DelegateFactory();
        this.y0 = delegateFactory;
        Provider<ButtonItemPresenter> provider23 = DoubleCheck.provider(PublishDetailsModule_ProvideButtonItemPresenterFactory.create(publishDetailsModule, delegateFactory));
        this.z0 = provider23;
        this.A0 = DoubleCheck.provider(PublishDetailsModule_ProvideButtonBlueprintFactory.create(publishDetailsModule, provider23));
        PublishTagsInteractorImpl_Factory create8 = PublishTagsInteractorImpl_Factory.create(this.j, this.d, this.f);
        this.B0 = create8;
        Provider<PublishTagsInteractor> provider24 = DoubleCheck.provider(create8);
        this.C0 = provider24;
        Provider<PublishTagsViewModelFactory> provider25 = DoubleCheck.provider(PublishDetailsModule_ProvideTagsViewModelFactoryFactory.create(publishDetailsModule, provider24, this.d));
        this.D0 = provider25;
        Provider<PublishTagsViewModel> provider26 = DoubleCheck.provider(PublishDetailsModule_ProvidePublishTagsViewModelFactory.create(publishDetailsModule, provider25));
        this.E0 = provider26;
        Provider<TagsViewModel> provider27 = DoubleCheck.provider(PublishDetailsModule_ProvideTagsViewModelFactory.create(publishDetailsModule, provider26));
        this.F0 = provider27;
        this.G0 = DoubleCheck.provider(ParametersListModule_ProvideMultiStateInputWithTagsItemPresenterFactory.create(parametersListModule, provider27, this.U, this.d0, this.g0));
        Provider<TagSelectionTracker> provider28 = DoubleCheck.provider(ParametersListModule_ProvideTagSelectionTracker$item_temporary_releaseFactory.create(parametersListModule, this.m, this.f));
        this.H0 = provider28;
        this.I0 = DoubleCheck.provider(ParametersListModule_ProvideMultiStateInputWithTagsItemBlueprintFactory.create(parametersListModule, this.G0, provider28));
        Provider<NoCarSlotItemPresenter> provider29 = DoubleCheck.provider(PublishDetailsModule_ProvideNoCarSlotPresenterFactory.create(publishDetailsModule));
        this.J0 = provider29;
        this.K0 = DoubleCheck.provider(PublishDetailsModule_ProvideNoCarSlotBlueprintFactory.create(publishDetailsModule, provider29));
        Provider<CpaTariffSlotItemPresenter> provider30 = DoubleCheck.provider(PublishDetailsModule_ProvideCpaTariffSlotPresenterFactory.create(publishDetailsModule));
        this.L0 = provider30;
        this.M0 = DoubleCheck.provider(PublishDetailsModule_ProvideCpaTariffSlotBlueprintFactory.create(publishDetailsModule, provider30));
        this.N0 = DoubleCheck.provider(PublishDetailsModule_ProvideUserInfoPresenterFactory.create(publishDetailsModule));
        Provider<AvatarRenderer> provider31 = DoubleCheck.provider(PublishDetailsModule_ProvideAvatarRendererFactory.create(publishDetailsModule));
        this.O0 = provider31;
        this.P0 = DoubleCheck.provider(PublishDetailsModule_ProvideUserInfoBlueprintFactory.create(publishDetailsModule, this.N0, provider31));
        PublishLimitsAnalyticsModule_ProvideAnalyticsFactory create9 = PublishLimitsAnalyticsModule_ProvideAnalyticsFactory.create(this.m);
        this.Q0 = create9;
        LimitsInfoItemPresenterImpl_Factory create10 = LimitsInfoItemPresenterImpl_Factory.create(create9);
        this.R0 = create10;
        this.S0 = DoubleCheck.provider(create10);
        Provider<LimitsInfoItemBlueprint.LayoutProvider> provider32 = DoubleCheck.provider(LimitsInfoSlotLayoutProvider_Factory.create());
        this.T0 = provider32;
        this.U0 = LimitsInfoItemBlueprint_Factory.create(this.S0, this.U, provider32);
        this.V0 = DoubleCheck.provider(PublishDetailsModule_ProvideDisclaimerBlueprintFactory.create(publishDetailsModule, DisclaimerItemPresenter_Factory.create(), this.U));
        this.W0 = MarketPriceBlueprint_Factory.create(MarketPriceItemPresenter_Factory.create());
        Provider<MarketPriceV2Formatter> provider33 = DoubleCheck.provider(MarketPriceV2FormatterImpl_Factory.create());
        this.X0 = provider33;
        MarketPriceV2PresenterImpl_Factory create11 = MarketPriceV2PresenterImpl_Factory.create(provider33, this.U, this.f, this.m);
        this.Y0 = create11;
        Provider<MarketPriceV2Presenter> provider34 = DoubleCheck.provider(create11);
        this.Z0 = provider34;
        this.a1 = MarketPriceV2Blueprint_Factory.create(provider34);
        CreRangePresenterImpl_Factory create12 = CreRangePresenterImpl_Factory.create(this.U);
        this.b1 = create12;
        Provider<CreRangePresenter> provider35 = DoubleCheck.provider(PublishDetailsModule_ProvideCRERangeItemPresenterFactory.create(publishDetailsModule, create12));
        this.c1 = provider35;
        this.d1 = DoubleCheck.provider(PublishDetailsModule_ProvideCRERangeItemBlueprintFactory.create(publishDetailsModule, provider35));
        Provider<TextWatcher> provider36 = DoubleCheck.provider(ParametersListModule_ProvideVehicleRegNumberRegionTextWatcherFactory.create(parametersListModule));
        this.e1 = provider36;
        Provider<VehicleRegNumberInputItemPresenter> provider37 = DoubleCheck.provider(ParametersListModule_ProvideVehicleRegNumberInputItemPresenterFactory.create(parametersListModule, provider36, this.U));
        this.f1 = provider37;
        this.g1 = DoubleCheck.provider(ParametersListModule_ProvideVehicleRegNumberInputItemBlueprintFactory.create(parametersListModule, provider37));
        Provider<VideoItemPresenter> provider38 = DoubleCheck.provider(VideoItemPresenterImpl_Factory.create());
        this.h1 = provider38;
        this.i1 = VideoItemBlueprint_Factory.create(provider38);
        Provider<LinkSlotItemPresenter> provider39 = DoubleCheck.provider(PublishDetailsModule_ProvideLinkSlotPresenterFactory.create(publishDetailsModule, this.U));
        this.j1 = provider39;
        this.k1 = DoubleCheck.provider(PublishDetailsModule_ProvideLinkSlotBlueprintFactory.create(publishDetailsModule, provider39));
        Provider<HeaderWithDividerItemPresenter> provider40 = DoubleCheck.provider(HeaderWithDividerItemPresenterImpl_Factory.create());
        this.l1 = provider40;
        HeaderWithDividerItemBlueprintImpl_Factory create13 = HeaderWithDividerItemBlueprintImpl_Factory.create(provider40);
        this.m1 = create13;
        this.n1 = DoubleCheck.provider(create13);
        this.o1 = InformationWithUserIdBlueprint_Factory.create(InformationWithUserIdItemPresenter_Factory.create(), this.U);
        Provider<ChipsMultiselectItemPresenter> provider41 = DoubleCheck.provider(ParametersListModule_ProvideChipsMultiselectItemPresenterFactory.create(parametersListModule));
        this.p1 = provider41;
        ChipsMultiselectItemBlueprint_Factory create14 = ChipsMultiselectItemBlueprint_Factory.create(provider41, this.U);
        this.q1 = create14;
        Provider<ItemBinder> provider42 = DoubleCheck.provider(PublishDetailsModule_ProvideItemBinderFactory.create(publishDetailsModule, this.W, this.Y, this.a0, this.c0, this.i0, this.p0, this.r0, this.t0, this.v0, this.x0, this.A0, this.I0, this.K0, this.M0, this.P0, this.U0, this.V0, this.W0, this.a1, this.d1, this.g1, this.i1, this.k1, this.n1, this.o1, create14, this.g));
        this.r1 = provider42;
        Provider<SimpleRecyclerAdapter> provider43 = DoubleCheck.provider(ParametersListModule_ProvideRecyclerAdapterFactory.create(parametersListModule, this.T, provider42));
        this.s1 = provider43;
        this.t1 = DoubleCheck.provider(ParametersListModule_ProvideListUpdateListenerFactory.create(parametersListModule, provider43));
        this.u1 = DoubleCheck.provider(ParametersListModule_ProvideAdapterPresenterFactory.create(parametersListModule, this.r1));
        Provider<ParametersListRdsContentsComparator> provider44 = DoubleCheck.provider(ParametersListModule_ProvideContentsComparatorFactory.create(parametersListModule));
        this.v1 = provider44;
        Provider<DiffCalculator> provider45 = DoubleCheck.provider(ParametersListModule_ProvideDiffCalculatorFactory.create(parametersListModule, provider44));
        this.w1 = provider45;
        DelegateFactory.setDelegate(this.T, DoubleCheck.provider(ParametersListModule_ProvideDataAwareAdapterFactory.create(parametersListModule, this.t1, this.u1, provider45)));
        Provider<Set<ItemPresenter<?, ?>>> provider46 = DoubleCheck.provider(PublishDetailsModule_ProvideItemPresentersSetFactory.create(publishDetailsModule, this.V, this.X, this.p1, this.Z, this.u0, this.b0, this.h0, this.w0, this.G0, this.J0, this.s0, this.c1, this.f1, this.h1, this.j1, this.Z0, this.S0, this.L0));
        this.x1 = provider46;
        this.y1 = DoubleCheck.provider(ParametersListModule_ProvideParametersListPresenterFactory.create(parametersListModule, this.S, this.T, provider46, this.d, this.g));
        this.z1 = DoubleCheck.provider(PublishDetailsModule_ProvidePublishDetailsResourceProviderFactory.create(publishDetailsModule));
        z zVar = new z(publishComponent);
        this.A1 = zVar;
        this.B1 = DoubleCheck.provider(PublishInputAnalyticsModule_ProvidePublishInputsAnalyticTrackerFactory.create(publishInputAnalyticsModule, zVar, this.x1));
        this.C1 = DoubleCheck.provider(ImageUploadModule_ProvideUploadingProgressInteractor$publish_releaseFactory.create(imageUploadModule, this.v, this.d));
        this.D1 = new u(publishComponent);
        this.E1 = new b0(publishComponent);
        this.F1 = new t(publishComponent);
        this.G1 = new a0(publishComponent);
        this.H1 = new g0(publishComponent);
        this.I1 = new d(publishComponent);
        d0 d0Var = new d0(publishComponent);
        this.J1 = d0Var;
        f0 f0Var = new f0(publishComponent);
        this.K1 = f0Var;
        this.L1 = DoubleCheck.provider(PublishDetailsAnalyticsModule_ProvidesScreenFlowTrackerProviderFactory.create(publishDetailsAnalyticsModule, d0Var, f0Var));
        this.M1 = DoubleCheck.provider(PublishDetailsAnalyticsModule_ProvidesScreenDiInjectTracker$publish_releaseFactory.create(publishDetailsAnalyticsModule, this.J1, this.K1));
        this.N1 = DoubleCheck.provider(PublishDetailsAnalyticsModule_ProvidesScreenInitTrackerFactory.create(publishDetailsAnalyticsModule, this.J1, this.K1));
        ScreenTransferRecovery_Impl_Factory create15 = ScreenTransferRecovery_Impl_Factory.create(this.J1, this.K1);
        this.O1 = create15;
        Provider<ScreenTransferRecovery> provider47 = DoubleCheck.provider(create15);
        this.P1 = provider47;
        PublishDetailsTrackerImpl_Factory create16 = PublishDetailsTrackerImpl_Factory.create(this.L1, this.M1, this.N1, provider47);
        this.Q1 = create16;
        Provider<PublishDetailsTracker> provider48 = DoubleCheck.provider(create16);
        this.R1 = provider48;
        this.S1 = DoubleCheck.provider(PublishDetailsModule_ProvideContactsDataSourceFactory.create(publishDetailsModule, this.D1, this.d, provider48));
        this.T1 = DoubleCheck.provider(PublishDetailsModule_ProvideContactsStringsProviderFactory.create(publishDetailsModule, this.Q));
        SessionChangeTrackerImpl_Factory create17 = SessionChangeTrackerImpl_Factory.create(this.g, this.m);
        this.U1 = create17;
        this.V1 = SingleCheck.provider(create17);
        this.W1 = DoubleCheck.provider(PublishDetailsModule_ProvideSlotsFactoryFactory.create(publishDetailsModule, this.D1, this.E1, this.F1, this.j, this.G1, this.H1, this.I1, this.U, this.e, this.S1, this.T1, this.f, this.m, PhoneNumberFormatterModule_ProvidePhoneNumberFormatterWithCountryCodeFactory.create(), this.V1, this.g, this.R1, this.A1, this.Q0));
        this.X1 = new m(publishComponent);
        PhotoUploadObserverImpl_Factory create18 = PhotoUploadObserverImpl_Factory.create(this.C1, this.d);
        this.Y1 = create18;
        this.Z1 = DoubleCheck.provider(PublishDetailsModule_ProvidePhotoObserver$publish_releaseFactory.create(publishDetailsModule, create18));
        VideoInteractorImpl_Factory create19 = VideoInteractorImpl_Factory.create(this.j, this.d);
        this.f57a2 = create19;
        Provider<VideoInteractor> provider49 = DoubleCheck.provider(create19);
        this.b2 = provider49;
        ItemWrapperFactoryImpl_Factory create20 = ItemWrapperFactoryImpl_Factory.create(provider49, this.z1);
        this.c2 = create20;
        Provider<ItemWrapperFactory> provider50 = DoubleCheck.provider(create20);
        this.d2 = provider50;
        this.e2 = ItemPostProcessor_Factory.create(provider50);
        FlowTrackerFactoryImpl_Factory create21 = FlowTrackerFactoryImpl_Factory.create(this.R1);
        this.f2 = create21;
        Provider<FlowTrackerFactory> provider51 = DoubleCheck.provider(create21);
        this.g2 = provider51;
        PublishDetailsFlowTrackerImpl_Factory create22 = PublishDetailsFlowTrackerImpl_Factory.create(provider51);
        this.h2 = create22;
        this.i2 = DoubleCheck.provider(create22);
        Provider<PublishDetailsPresenter> provider52 = this.y0;
        Provider<PublishDetailsInteractor> provider53 = this.r;
        Provider<ItemDetailsSelectResultHandler> provider54 = this.b;
        Provider<PhotoInteractorWrapper> provider55 = this.w;
        Provider<ItemDetailsParameterClickListener> provider56 = this.F;
        Provider<CategoryParametersElementConverter> provider57 = this.L;
        Provider<SchedulersFactory> provider58 = this.d;
        Provider<ParametersListPresenter> provider59 = this.y1;
        DelegateFactory.setDelegate(provider52, DoubleCheck.provider(PublishDetailsModule_ProvideDetailsPresenterFactory.create(publishDetailsModule, provider53, provider54, provider55, provider56, provider57, provider58, provider59, provider59, this.z1, this.B1, this.C1, this.A1, this.x1, this.g, PhoneNumberFormatterModule_ProvidePhoneNumberFormatterWithCountryCodeFactory.create(), this.W1, this.X1, this.Z1, this.u, this.I, this.e2, this.i2)));
        this.j2 = DoubleCheck.provider(PublishDetailsModule_ProvideAdapterFactory.create(publishDetailsModule, this.s1));
    }

    public static PublishDetailsComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.publish.details.di.PublishDetailsComponent
    public void inject(PublishDetailsFragment publishDetailsFragment) {
        SelectItemBaseFragment_MembersInjector.injectResultHandler(publishDetailsFragment, this.b.get());
        ItemDetailsBaseFragment_MembersInjector.injectActivityIntentFactory(publishDetailsFragment, (ActivityIntentFactory) Preconditions.checkNotNullFromComponent(this.a.activityIntentFactory()));
        ItemDetailsBaseFragment_MembersInjector.injectImplicitIntentFactory(publishDetailsFragment, (ImplicitIntentFactory) Preconditions.checkNotNullFromComponent(this.a.implicitIntentFactory()));
        ItemDetailsBaseFragment_MembersInjector.injectFeatures(publishDetailsFragment, (Features) Preconditions.checkNotNullFromComponent(this.a.features()));
        PublishDetailsFragment_MembersInjector.injectPresenter(publishDetailsFragment, this.y0.get());
        PublishDetailsFragment_MembersInjector.injectAnalytics(publishDetailsFragment, (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics()));
        PublishDetailsFragment_MembersInjector.injectDeepLinkIntentFactory(publishDetailsFragment, (DeepLinkIntentFactory) Preconditions.checkNotNullFromComponent(this.a.deepLinkIntentFactory()));
        PublishDetailsFragment_MembersInjector.injectImageListPresenter(publishDetailsFragment, this.l0.get());
        PublishDetailsFragment_MembersInjector.injectUploadingInteractor(publishDetailsFragment, this.k0.get());
        PublishDetailsFragment_MembersInjector.injectParamsPresenter(publishDetailsFragment, this.y1.get());
        PublishDetailsFragment_MembersInjector.injectAdapter(publishDetailsFragment, this.j2.get());
        PublishDetailsFragment_MembersInjector.injectInputsAnalyticTracker(publishDetailsFragment, this.B1.get());
        PublishDetailsFragment_MembersInjector.injectTagsViewModel(publishDetailsFragment, this.E0.get());
        PublishDetailsFragment_MembersInjector.injectEventTracker(publishDetailsFragment, (PublishEventTracker) Preconditions.checkNotNullFromComponent(this.a.publishEventTracker()));
        PublishDetailsFragment_MembersInjector.injectContactsDataSource(publishDetailsFragment, this.S1.get());
        PublishDetailsFragment_MembersInjector.injectDialogRouter(publishDetailsFragment, (DialogRouter) Preconditions.checkNotNullFromComponent(this.a.dialogRouter()));
        PublishDetailsFragment_MembersInjector.injectTracker(publishDetailsFragment, this.R1.get());
        PublishDetailsFragment_MembersInjector.injectHtmlEditorViewModel(publishDetailsFragment, this.g0.get());
    }
}
