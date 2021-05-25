package com.avito.android.publish.details.di;

import android.content.res.Resources;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.Features;
import com.avito.android.ab_tests.AbTestsConfigProvider;
import com.avito.android.account.AccountStorageInteractor;
import com.avito.android.account.SessionChangeTracker;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.PublishValidationLogger;
import com.avito.android.analytics.publish.PublishAnalyticsDataProvider;
import com.avito.android.blueprints.ButtonItemBlueprint;
import com.avito.android.blueprints.ButtonItemPresenter;
import com.avito.android.blueprints.ButtonItemPresenterImpl;
import com.avito.android.blueprints.chips.ChipsSelectItemBlueprint;
import com.avito.android.blueprints.chips.ChipsSelectItemPresenter;
import com.avito.android.blueprints.chips_multiselect.ChipsMultiselectItemBlueprint;
import com.avito.android.blueprints.chips_multiselect.ChipsMultiselectItemPresenter;
import com.avito.android.blueprints.input.MultiStateInputItemBlueprint;
import com.avito.android.blueprints.input.MultiStateInputItemPresenter;
import com.avito.android.blueprints.publish.VehicleRegNumberInputItemBlueprint;
import com.avito.android.blueprints.publish.VehicleRegNumberInputItemPresenter;
import com.avito.android.blueprints.publish.html_editor.HtmlEditorViewModel;
import com.avito.android.blueprints.publish.html_editor.HtmlEditorViewModelFactory;
import com.avito.android.blueprints.publish.html_editor.HtmlEditorViewModelImpl;
import com.avito.android.blueprints.publish.tagged_input.MultiStateInputWithTagsItemBlueprint;
import com.avito.android.blueprints.publish.tagged_input.MultiStateInputWithTagsItemPresenter;
import com.avito.android.blueprints.radiogroup.RadioGroupSelectItemBlueprint;
import com.avito.android.blueprints.radiogroup.RadioGroupSelectItemPresenter;
import com.avito.android.blueprints.range.cre_range.CreRangeItemBlueprint;
import com.avito.android.blueprints.range.cre_range.CreRangePresenter;
import com.avito.android.blueprints.range.cre_range.CreRangePresenterImpl;
import com.avito.android.blueprints.select.MultiStateSelectItemBlueprint;
import com.avito.android.blueprints.select.MultiStateSelectItemPresenter;
import com.avito.android.blueprints.select.MultiStateSelectItemPresenterImpl;
import com.avito.android.blueprints.switcher.MultiStateSwitcherItemBlueprint;
import com.avito.android.blueprints.switcher.MultiStateSwitcherItemPresenter;
import com.avito.android.blueprints.video.VideoItemBlueprint;
import com.avito.android.blueprints.video.VideoItemPresenter;
import com.avito.android.blueprints.video.VideoItemPresenterImpl;
import com.avito.android.category_parameters.CategoryParametersElementConverter;
import com.avito.android.component.profile_snippet.AdvertSellerAvatarRenderer;
import com.avito.android.component.profile_snippet.AvatarRenderer;
import com.avito.android.computer_vision.ComputerVisionInteractor;
import com.avito.android.di.PerFragment;
import com.avito.android.di.module.SessionUpdateTrackerModule;
import com.avito.android.html_editor.EditorHistoryProvider;
import com.avito.android.html_formatter.HtmlCleaner;
import com.avito.android.html_formatter.HtmlNodeFactory;
import com.avito.android.html_formatter.HtmlRenderOptions;
import com.avito.android.item_legacy.details.ItemDetailsSelectResultHandler;
import com.avito.android.photo_picker.legacy.PhotoInteractor;
import com.avito.android.photo_picker.legacy.UploadingProgressInteractor;
import com.avito.android.photo_view.ImageListPresenter;
import com.avito.android.photo_view.PhotoViewResourceProvider;
import com.avito.android.photo_view.PhotoViewResourceProviderImpl;
import com.avito.android.photo_view.blueprints.MultiStatePhotoItemBlueprint;
import com.avito.android.photo_view.blueprints.MultiStatePhotoItemPresenter;
import com.avito.android.photo_view.blueprints.MultiStatePhotoItemPresenterImpl;
import com.avito.android.publish.ContactsDataSource;
import com.avito.android.publish.ContactsDataSourceImpl;
import com.avito.android.publish.PhotoUploadObserver;
import com.avito.android.publish.PhotoUploadObserverImpl;
import com.avito.android.publish.ProfileSourceInteractor;
import com.avito.android.publish.PublishParametersInteractor;
import com.avito.android.publish.analytics.PublishEventTracker;
import com.avito.android.publish.analytics.PublishInputsAnalyticTracker;
import com.avito.android.publish.details.InsertPhotoInteractorImpl;
import com.avito.android.publish.details.ItemPostProcessor;
import com.avito.android.publish.details.ItemWrapper;
import com.avito.android.publish.details.PhotoInteractorWrapper;
import com.avito.android.publish.details.PublishDetailsInteractor;
import com.avito.android.publish.details.PublishDetailsInteractorImpl;
import com.avito.android.publish.details.PublishDetailsPresenter;
import com.avito.android.publish.details.PublishDetailsPresenterImpl;
import com.avito.android.publish.details.PublishDetailsResourceProvider;
import com.avito.android.publish.details.VideoInteractor;
import com.avito.android.publish.details.VideoInteractorImpl;
import com.avito.android.publish.details.adapter.date_interval.DateIntervalItemBlueprint;
import com.avito.android.publish.details.adapter.date_interval.DateIntervalItemPresenter;
import com.avito.android.publish.details.adapter.date_interval.DateIntervalItemPresenterImpl;
import com.avito.android.publish.details.adapter.edit_category.EditCategoryItemBlueprint;
import com.avito.android.publish.details.adapter.edit_category.EditCategoryItemPresenter;
import com.avito.android.publish.details.adapter.edit_category.EditCategoryItemPresenterImpl;
import com.avito.android.publish.details.adapter.header.HeaderWithDividerItemBlueprint;
import com.avito.android.publish.details.adapter.header.HeaderWithDividerItemBlueprintImpl;
import com.avito.android.publish.details.adapter.header.HeaderWithDividerItemPresenter;
import com.avito.android.publish.details.adapter.header.HeaderWithDividerItemPresenterImpl;
import com.avito.android.publish.details.adapter.multiselect.MultiselectItemBlueprint;
import com.avito.android.publish.details.adapter.multiselect.RdsMultiselectItemPresenter;
import com.avito.android.publish.details.adapter.multiselect.RdsMultiselectItemPresenterImpl;
import com.avito.android.publish.details.adapter.objects.MultiStateObjectsItemBlueprint;
import com.avito.android.publish.details.adapter.objects.MultiStateObjectsItemPresenter;
import com.avito.android.publish.details.adapter.objects.MultiStateObjectsItemPresenterImpl;
import com.avito.android.publish.details.analytics.PublishDetailsFlowTracker;
import com.avito.android.publish.details.analytics.PublishDetailsTracker;
import com.avito.android.publish.details.item_wrapper.ItemWrapperFactory;
import com.avito.android.publish.details.item_wrapper.ItemWrapperFactoryImpl;
import com.avito.android.publish.details.tags.PublishTagsInteractor;
import com.avito.android.publish.details.tags.PublishTagsInteractorImpl;
import com.avito.android.publish.details.tags.PublishTagsViewModel;
import com.avito.android.publish.details.tags.PublishTagsViewModelFactory;
import com.avito.android.publish.di.PublishParametersModule;
import com.avito.android.publish.premoderation.di.AdvertProactiveModerationModule;
import com.avito.android.publish.pretend.PretendInteractor;
import com.avito.android.publish.pretend.PretendInteractorImpl;
import com.avito.android.publish.slots.SlotsFactory;
import com.avito.android.publish.slots.SlotsFactoryImpl;
import com.avito.android.publish.slots.cpa_tariff.item.CpaTariffSlotBlueprint;
import com.avito.android.publish.slots.cpa_tariff.item.CpaTariffSlotItemPresenter;
import com.avito.android.publish.slots.cpa_tariff.item.CpaTariffSlotItemPresenterImpl;
import com.avito.android.publish.slots.infomation.item.DisclaimerBlueprint;
import com.avito.android.publish.slots.infomation.item.DisclaimerItemPresenter;
import com.avito.android.publish.slots.information_with_user_id.item.InformationWithUserIdBlueprint;
import com.avito.android.publish.slots.limits_info.LimitsInfoSlotLayoutProvider;
import com.avito.android.publish.slots.link.item.LinkSlotBlueprint;
import com.avito.android.publish.slots.link.item.LinkSlotItemPresenter;
import com.avito.android.publish.slots.link.item.LinkSlotItemPresenterImpl;
import com.avito.android.publish.slots.market_price.item.MarketPriceBlueprint;
import com.avito.android.publish.slots.market_price_v2.item.MarketPriceV2Blueprint;
import com.avito.android.publish.slots.market_price_v2.item.MarketPriceV2Formatter;
import com.avito.android.publish.slots.market_price_v2.item.MarketPriceV2FormatterImpl;
import com.avito.android.publish.slots.market_price_v2.item.MarketPriceV2Presenter;
import com.avito.android.publish.slots.market_price_v2.item.MarketPriceV2PresenterImpl;
import com.avito.android.publish.slots.no_car.item.NoCarSlotBlueprint;
import com.avito.android.publish.slots.no_car.item.NoCarSlotItemPresenter;
import com.avito.android.publish.slots.no_car.item.NoCarSlotItemPresenterImpl;
import com.avito.android.publish.slots.profile_info.PublishContactsStringProvider;
import com.avito.android.publish.slots.profile_info.PublishContactsStringProviderImpl;
import com.avito.android.publish.slots.profile_info.item.UserInfoItemBlueprint;
import com.avito.android.publish.slots.profile_info.item.UserInfoItemPresenter;
import com.avito.android.publish.slots.profile_info.item.UserInfoItemPresenterImpl;
import com.avito.android.publish.view.ItemDetailsParameterClickListener;
import com.avito.android.publish_limits_info.analytics.PublishLimitsAnalyticsModule;
import com.avito.android.publish_limits_info.analytics.PublishLimitsEventTracker;
import com.avito.android.publish_limits_info.item.LimitsInfoItemBlueprint;
import com.avito.android.publish_limits_info.item.LimitsInfoItemPresenter;
import com.avito.android.publish_limits_info.item.LimitsInfoItemPresenterImpl;
import com.avito.android.remote.ProfileApi;
import com.avito.android.remote.PublishApi;
import com.avito.android.remote.PublishLimitsApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.remote.model.category_parameters.CategoryParametersConverter;
import com.avito.android.server_time.TimeSource;
import com.avito.android.ui.widget.tagged_input.TagsViewModel;
import com.avito.android.util.DeviceMetrics;
import com.avito.android.util.Formatter;
import com.avito.android.util.PhoneNumberFormatterModule;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.preferences.GeoContract;
import com.avito.android.util.text.AttributedTextFormatter;
import com.avito.android.util.text.AttributedTextFormatterModule;
import com.avito.android.validation.ParametersListModule;
import com.avito.android.validation.ParametersListPresenter;
import com.avito.android.validation.ValidationLogger;
import com.avito.conveyor_item.Item;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import com.avito.konveyor.blueprint.ItemPresenter;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import dagger.Binds;
import dagger.Lazy;
import dagger.Module;
import dagger.Provides;
import java.util.Locale;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.y;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¤\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001:\u0002Ë\u0002BF\u0012\n\u0010¿\u0002\u001a\u0005\u0018\u00010¼\u0002\u0012\b\u0010\u0002\u001a\u00030\u0002\u0012\b\u0010»\u0002\u001a\u00030¸\u0002\u0012\u0007\u0010È\u0002\u001a\u00020&\u0012\b\u0010Ã\u0002\u001a\u00030À\u0002\u0012\b\u0010·\u0002\u001a\u00030´\u0002¢\u0006\u0006\bÉ\u0002\u0010Ê\u0002J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJÚ\u0001\u00107\u001a\u0002062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001d2\u0019\u0010\"\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u0002\b\u0003\u0012\u0002\b\u00030 ¢\u0006\u0002\b!0\u001f2\u0006\u0010$\u001a\u00020#2\u000e\b\u0001\u0010'\u001a\b\u0012\u0004\u0012\u00020&0%2\u0006\u0010)\u001a\u00020(2\u0006\u0010+\u001a\u00020*2\u0006\u0010-\u001a\u00020,2\u0006\u0010/\u001a\u00020.2\u0006\u00101\u001a\u0002002\u0006\u00103\u001a\u0002022\u0006\u00105\u001a\u000204H\u0007¢\u0006\u0004\b7\u00108J¯\u0001\u0010Y\u001a\u00020(2\u0006\u0010:\u001a\u0002092\u0006\u0010<\u001a\u00020;2\u0006\u0010>\u001a\u00020=2\u0006\u0010@\u001a\u00020?2\u0006\u0010B\u001a\u00020A2\u0006\u0010D\u001a\u00020C2\u0006\u0010F\u001a\u00020E2\u0006\u0010H\u001a\u00020G2\u0006\u0010J\u001a\u00020I2\u0006\u0010L\u001a\u00020K2\u0006\u0010N\u001a\u00020M2\u0006\u0010P\u001a\u00020O2\u0006\u0010R\u001a\u00020Q2\u000e\b\u0001\u0010'\u001a\b\u0012\u0004\u0012\u00020&0%2\u0006\u0010T\u001a\u00020S2\u0006\u0010$\u001a\u00020#2\u0006\u0010V\u001a\u00020U2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010X\u001a\u00020WH\u0007¢\u0006\u0004\bY\u0010ZJO\u0010d\u001a\u00020\u00102\u000e\b\u0001\u0010'\u001a\b\u0012\u0004\u0012\u00020&0%2\u0006\u0010\\\u001a\u00020[2\u0006\u0010^\u001a\u00020]2\u0006\u0010$\u001a\u00020#2\u0006\u0010_\u001a\u0002002\u0006\u0010a\u001a\u00020`2\u0006\u0010c\u001a\u00020bH\u0007¢\u0006\u0004\bd\u0010eJ\u0002\u0010\u0001\u001a\u00030\u00012\u0006\u0010g\u001a\u00020f2\u0006\u0010i\u001a\u00020h2\u0006\u0010k\u001a\u00020j2\u0006\u0010m\u001a\u00020l2\u0006\u0010o\u001a\u00020n2\u0006\u0010q\u001a\u00020p2\u0006\u0010s\u001a\u00020r2\u0006\u0010u\u001a\u00020t2\u0006\u0010w\u001a\u00020v2\u0006\u0010y\u001a\u00020x2\u0006\u0010{\u001a\u00020z2\u0006\u0010}\u001a\u00020|2\u0006\u0010\u001a\u00020~2\b\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u00012\u0006\u0010$\u001a\u00020#H\u0007¢\u0006\u0006\b\u0001\u0010\u0001J\u001d\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u0001H\u0007¢\u0006\u0006\b\u0001\u0010 \u0001J\u001d\u0010¢\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030¡\u0001H\u0007¢\u0006\u0006\b¢\u0001\u0010£\u0001J\u001c\u0010¥\u0001\u001a\u00020r2\b\u0010\u0001\u001a\u00030¤\u0001H\u0007¢\u0006\u0006\b¥\u0001\u0010¦\u0001J\u001c\u0010¨\u0001\u001a\u00020t2\b\u0010\u0001\u001a\u00030§\u0001H\u0007¢\u0006\u0006\b¨\u0001\u0010©\u0001J\u001c\u0010«\u0001\u001a\u00020v2\b\u0010\u0001\u001a\u00030ª\u0001H\u0007¢\u0006\u0006\b«\u0001\u0010¬\u0001J\u001c\u0010®\u0001\u001a\u00020x2\b\u0010\u0001\u001a\u00030­\u0001H\u0007¢\u0006\u0006\b®\u0001\u0010¯\u0001J\u0013\u0010°\u0001\u001a\u00030­\u0001H\u0007¢\u0006\u0006\b°\u0001\u0010±\u0001J\u001c\u0010³\u0001\u001a\u00020p2\b\u0010\u0001\u001a\u00030²\u0001H\u0007¢\u0006\u0006\b³\u0001\u0010´\u0001J/\u0010¹\u0001\u001a\u00030²\u00012\b\u0010¶\u0001\u001a\u00030µ\u00012\u0006\u0010H\u001a\u00020G2\b\u0010¸\u0001\u001a\u00030·\u0001H\u0007¢\u0006\u0006\b¹\u0001\u0010º\u0001J\u001c\u0010¼\u0001\u001a\u00020f2\b\u0010\u0001\u001a\u00030»\u0001H\u0007¢\u0006\u0006\b¼\u0001\u0010½\u0001J\u001b\u0010¾\u0001\u001a\u00030»\u00012\u0006\u0010H\u001a\u00020GH\u0007¢\u0006\u0006\b¾\u0001\u0010¿\u0001J\u001b\u0010À\u0001\u001a\u00030ª\u00012\u0006\u0010H\u001a\u00020GH\u0007¢\u0006\u0006\bÀ\u0001\u0010Á\u0001J'\u0010Å\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030Â\u00012\b\u0010Ä\u0001\u001a\u00030Ã\u0001H\u0007¢\u0006\u0006\bÅ\u0001\u0010Æ\u0001J\u0013\u0010Ç\u0001\u001a\u00030Ã\u0001H\u0007¢\u0006\u0006\bÇ\u0001\u0010È\u0001J\u0013\u0010É\u0001\u001a\u00030Â\u0001H\u0007¢\u0006\u0006\bÉ\u0001\u0010Ê\u0001J\u0012\u0010Ë\u0001\u001a\u00020\u0017H\u0007¢\u0006\u0006\bË\u0001\u0010Ì\u0001J!\u0010Ð\u0001\u001a\u0007\u0012\u0002\b\u00030Ï\u00012\b\u0010Î\u0001\u001a\u00030Í\u0001H\u0007¢\u0006\u0006\bÐ\u0001\u0010Ñ\u0001J\u001c\u0010Ô\u0001\u001a\u00020z2\b\u0010Ó\u0001\u001a\u00030Ò\u0001H\u0007¢\u0006\u0006\bÔ\u0001\u0010Õ\u0001J#\u0010Ø\u0001\u001a\u00030Ò\u00012\u000e\u0010×\u0001\u001a\t\u0012\u0004\u0012\u0002060Ö\u0001H\u0007¢\u0006\u0006\bØ\u0001\u0010Ù\u0001J%\u0010Û\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030Ú\u00012\u0006\u0010H\u001a\u00020GH\u0007¢\u0006\u0006\bÛ\u0001\u0010Ü\u0001J\u001c\u0010Þ\u0001\u001a\u00020~2\b\u0010\u0001\u001a\u00030Ý\u0001H\u0007¢\u0006\u0006\bÞ\u0001\u0010ß\u0001J\u0013\u0010à\u0001\u001a\u00030Ý\u0001H\u0007¢\u0006\u0006\bà\u0001\u0010á\u0001J\u001d\u0010ã\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030â\u0001H\u0007¢\u0006\u0006\bã\u0001\u0010ä\u0001J\u0013\u0010å\u0001\u001a\u00030â\u0001H\u0007¢\u0006\u0006\bå\u0001\u0010æ\u0001J\u001d\u0010è\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030ç\u0001H\u0007¢\u0006\u0006\bè\u0001\u0010é\u0001J\u001b\u0010ê\u0001\u001a\u00030ç\u00012\u0006\u0010H\u001a\u00020GH\u0007¢\u0006\u0006\bê\u0001\u0010ë\u0001J$\u0010î\u0001\u001a\u00030í\u00012\u0006\u0010R\u001a\u00020Q2\u0007\u0010ì\u0001\u001a\u00020OH\u0007¢\u0006\u0006\bî\u0001\u0010ï\u0001JÙ\u0001\u0010\u0002\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u0002\b\u0003\u0012\u0002\b\u00030 ¢\u0006\u0002\b!0\u001f2\b\u0010ð\u0001\u001a\u00030»\u00012\b\u0010ò\u0001\u001a\u00030ñ\u00012\b\u0010ô\u0001\u001a\u00030ó\u00012\b\u0010ö\u0001\u001a\u00030õ\u00012\b\u0010÷\u0001\u001a\u00030ª\u00012\b\u0010ù\u0001\u001a\u00030ø\u00012\b\u0010û\u0001\u001a\u00030ú\u00012\b\u0010ü\u0001\u001a\u00030­\u00012\b\u0010þ\u0001\u001a\u00030ý\u00012\b\u0010ÿ\u0001\u001a\u00030Ý\u00012\b\u0010\u0002\u001a\u00030§\u00012\b\u0010\u0002\u001a\u00030\u00012\b\u0010\u0002\u001a\u00030\u00022\b\u0010\u0002\u001a\u00030\u00022\b\u0010\u0002\u001a\u00030ç\u00012\b\u0010\u0002\u001a\u00030\u00022\b\u0010\u0002\u001a\u00030\u00022\b\u0010\u0002\u001a\u00030â\u0001H\u0007¢\u0006\u0006\b\u0002\u0010\u0002J\u001c\u0010\u0002\u001a\u00020\f2\b\u0010\u0002\u001a\u00030\u0002H\u0007¢\u0006\u0006\b\u0002\u0010\u0002J\u001c\u0010\u0002\u001a\u00020,2\b\u0010\u0002\u001a\u00030\u0002H\u0001¢\u0006\u0006\b\u0002\u0010\u0002J\u001c\u0010\u0002\u001a\u00020M2\b\u0010\u0002\u001a\u00030\u0002H\u0007¢\u0006\u0006\b\u0002\u0010\u0002J*\u0010\u0002\u001a\u00020K2\u0006\u0010:\u001a\u0002092\u0006\u0010<\u001a\u00020\u00122\u0006\u0010V\u001a\u00020UH\u0007¢\u0006\u0006\b\u0002\u0010\u0002J\u001d\u0010 \u0002\u001a\u00030\u00022\b\u0010\u0002\u001a\u00030\u0002H\u0007¢\u0006\u0006\b \u0002\u0010¡\u0002J/\u0010§\u0002\u001a\u00030¦\u00022\b\u0010£\u0002\u001a\u00030¢\u00022\u0006\u0010c\u001a\u00020b2\b\u0010¥\u0002\u001a\u00030¤\u0002H\u0007¢\u0006\u0006\b§\u0002\u0010¨\u0002J\u001d\u0010ª\u0002\u001a\u00030©\u00022\b\u0010\u0002\u001a\u00030¦\u0002H\u0007¢\u0006\u0006\bª\u0002\u0010«\u0002J\u001d\u0010®\u0002\u001a\u00030­\u00022\b\u0010¬\u0002\u001a\u00030\u0002H\u0007¢\u0006\u0006\b®\u0002\u0010¯\u0002J%\u0010²\u0002\u001a\u00030\u00022\b\u0010±\u0002\u001a\u00030°\u00022\u0006\u0010<\u001a\u00020\u0012H\u0007¢\u0006\u0006\b²\u0002\u0010³\u0002R\u001a\u0010·\u0002\u001a\u00030´\u00028\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bµ\u0002\u0010¶\u0002R\u001a\u0010»\u0002\u001a\u00030¸\u00028\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b¹\u0002\u0010º\u0002R\u001c\u0010¿\u0002\u001a\u0005\u0018\u00010¼\u00028\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b½\u0002\u0010¾\u0002R\u001a\u0010Ã\u0002\u001a\u00030À\u00028\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bÁ\u0002\u0010Â\u0002R\u001a\u0010\u0002\u001a\u00030\u00028\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bÄ\u0002\u0010Å\u0002R\u0019\u0010È\u0002\u001a\u00020&8\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bÆ\u0002\u0010Ç\u0002¨\u0006Ì\u0002"}, d2 = {"Lcom/avito/android/publish/details/di/PublishDetailsModule;", "", "Lcom/avito/android/publish/pretend/PretendInteractor;", "pretendInteractor", "Lcom/avito/android/publish/PublishParametersInteractor;", "publishParametersInteractor", "Lcom/avito/android/publish/details/PublishDetailsInteractor;", "provideDetailsInteractor", "(Lcom/avito/android/publish/pretend/PretendInteractor;Lcom/avito/android/publish/PublishParametersInteractor;)Lcom/avito/android/publish/details/PublishDetailsInteractor;", "interactor", "Lcom/avito/android/item_legacy/details/ItemDetailsSelectResultHandler;", "resultHandler", "Lcom/avito/android/publish/details/PhotoInteractorWrapper;", "insertPhotoInteractor", "Lcom/avito/android/publish/view/ItemDetailsParameterClickListener;", "parameterClickListener", "Lcom/avito/android/category_parameters/CategoryParametersElementConverter;", "categoryParametersElementConverter", "Lcom/avito/android/util/SchedulersFactory;", "schedulersFactory", "Lcom/avito/android/validation/ParametersListPresenter;", "submissionListener", "parametersListPresenter", "Lcom/avito/android/publish/details/PublishDetailsResourceProvider;", "resourceProvider", "Lcom/avito/android/publish/analytics/PublishInputsAnalyticTracker;", "inputsAnalyticTracker", "Lcom/avito/android/photo_picker/legacy/UploadingProgressInteractor;", "uploadingProgressInteractor", "Lcom/avito/android/publish/analytics/PublishEventTracker;", "publishEventTracker", "", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lkotlin/jvm/JvmSuppressWildcards;", "itemPresentersSet", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/util/Formatter;", "", "phoneFormatter", "Lcom/avito/android/publish/slots/SlotsFactory;", "slotsFactory", "Lcom/avito/android/util/DeviceMetrics;", "deviceMetrics", "Lcom/avito/android/publish/PhotoUploadObserver;", "photoObserver", "Lcom/avito/android/computer_vision/ComputerVisionInteractor;", "cvInteractor", "Lcom/avito/android/ab_tests/AbTestsConfigProvider;", "abTestsConfigProvider", "Lcom/avito/android/publish/details/ItemPostProcessor;", "itemPostProcessor", "Lcom/avito/android/publish/details/analytics/PublishDetailsFlowTracker;", "flowTracker", "Lcom/avito/android/publish/details/PublishDetailsPresenter;", "provideDetailsPresenter", "(Lcom/avito/android/publish/details/PublishDetailsInteractor;Lcom/avito/android/item_legacy/details/ItemDetailsSelectResultHandler;Lcom/avito/android/publish/details/PhotoInteractorWrapper;Lcom/avito/android/publish/view/ItemDetailsParameterClickListener;Lcom/avito/android/category_parameters/CategoryParametersElementConverter;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/validation/ParametersListPresenter;Lcom/avito/android/validation/ParametersListPresenter;Lcom/avito/android/publish/details/PublishDetailsResourceProvider;Lcom/avito/android/publish/analytics/PublishInputsAnalyticTracker;Lcom/avito/android/photo_picker/legacy/UploadingProgressInteractor;Lcom/avito/android/publish/analytics/PublishEventTracker;Ljava/util/Set;Lcom/avito/android/Features;Lcom/avito/android/util/Formatter;Lcom/avito/android/publish/slots/SlotsFactory;Lcom/avito/android/util/DeviceMetrics;Lcom/avito/android/publish/PhotoUploadObserver;Lcom/avito/android/computer_vision/ComputerVisionInteractor;Lcom/avito/android/ab_tests/AbTestsConfigProvider;Lcom/avito/android/publish/details/ItemPostProcessor;Lcom/avito/android/publish/details/analytics/PublishDetailsFlowTracker;)Lcom/avito/android/publish/details/PublishDetailsPresenter;", "Lcom/avito/android/publish/ProfileSourceInteractor;", "profileSource", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/avito/android/remote/ProfileApi;", "profileApi", "Lcom/avito/android/remote/PublishApi;", "publishApi", "Lcom/avito/android/remote/PublishLimitsApi;", "limitsApi", "Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", "throwableConverter", "Lcom/avito/android/account/AccountStorageInteractor;", "accountStorageInteractor", "Lcom/avito/android/util/text/AttributedTextFormatter;", "attributedTextFormatter", "Lcom/avito/android/remote/model/category_parameters/CategoryParametersConverter;", "converter", "Lcom/avito/android/publish/ContactsDataSource;", "contactDataSource", "Lcom/avito/android/publish/slots/profile_info/PublishContactsStringProvider;", "contactsStringProvider", "Lcom/avito/android/analytics/publish/PublishAnalyticsDataProvider;", "analyticsData", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/account/SessionChangeTracker;", "sessionChangeTracker", "Lcom/avito/android/publish/details/analytics/PublishDetailsTracker;", "performanceTracker", "Lcom/avito/android/publish_limits_info/analytics/PublishLimitsEventTracker;", "publishLimitsEventTracker", "provideSlotsFactory", "(Lcom/avito/android/publish/ProfileSourceInteractor;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/remote/ProfileApi;Lcom/avito/android/remote/PublishApi;Lcom/avito/android/remote/PublishLimitsApi;Lcom/avito/android/remote/error/TypedErrorThrowableConverter;Lcom/avito/android/account/AccountStorageInteractor;Lcom/avito/android/util/text/AttributedTextFormatter;Lcom/avito/android/remote/model/category_parameters/CategoryParametersConverter;Lcom/avito/android/publish/ContactsDataSource;Lcom/avito/android/publish/slots/profile_info/PublishContactsStringProvider;Lcom/avito/android/analytics/publish/PublishAnalyticsDataProvider;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/util/Formatter;Lcom/avito/android/account/SessionChangeTracker;Lcom/avito/android/Features;Lcom/avito/android/publish/details/analytics/PublishDetailsTracker;Lcom/avito/android/publish/analytics/PublishEventTracker;Lcom/avito/android/publish_limits_info/analytics/PublishLimitsEventTracker;)Lcom/avito/android/publish/slots/SlotsFactory;", "Lcom/avito/android/server_time/TimeSource;", "timeSource", "Ljava/util/Locale;", "locale", "testsConfigProvider", "Lcom/avito/android/html_formatter/HtmlCleaner;", "htmlCleaner", "Lcom/avito/android/html_formatter/HtmlNodeFactory;", "htmlNodeFactory", "provideCategoryParametersElementConverter", "(Lcom/avito/android/util/Formatter;Lcom/avito/android/server_time/TimeSource;Ljava/util/Locale;Lcom/avito/android/Features;Lcom/avito/android/ab_tests/AbTestsConfigProvider;Lcom/avito/android/html_formatter/HtmlCleaner;Lcom/avito/android/html_formatter/HtmlNodeFactory;)Lcom/avito/android/category_parameters/CategoryParametersElementConverter;", "Lcom/avito/android/blueprints/select/MultiStateSelectItemBlueprint;", "multiStateSelectItemBlueprint", "Lcom/avito/android/blueprints/chips/ChipsSelectItemBlueprint;", "chipsSelectItemBlueprint", "Lcom/avito/android/blueprints/radiogroup/RadioGroupSelectItemBlueprint;", "radioGroupSelectItemBlueprint", "Lcom/avito/android/blueprints/switcher/MultiStateSwitcherItemBlueprint;", "multiStateSwitcherItemBlueprint", "Lcom/avito/android/blueprints/input/MultiStateInputItemBlueprint;", "multiStateInputItemBlueprint", "Lcom/avito/android/photo_view/blueprints/MultiStatePhotoItemBlueprint;", "multiStatePhotoItemBlueprint", "Lcom/avito/android/publish/details/adapter/date_interval/DateIntervalItemBlueprint;", "dateIntervalItemBlueprint", "Lcom/avito/android/publish/details/adapter/edit_category/EditCategoryItemBlueprint;", "editCategoryItemBlueprint", "Lcom/avito/android/publish/details/adapter/multiselect/MultiselectItemBlueprint;", "multiselectItemBlueprint", "Lcom/avito/android/publish/details/adapter/objects/MultiStateObjectsItemBlueprint;", "multiStateObjectsItemBlueprint", "Lcom/avito/android/blueprints/ButtonItemBlueprint;", "buttonItemBlueprint", "Lcom/avito/android/blueprints/publish/tagged_input/MultiStateInputWithTagsItemBlueprint;", "taggedItemBlueprint", "Lcom/avito/android/publish/slots/no_car/item/NoCarSlotBlueprint;", "noCarSlotBlueprint", "Lcom/avito/android/publish/slots/cpa_tariff/item/CpaTariffSlotBlueprint;", "cpaTariffSlotBlueprint", "Lcom/avito/android/publish/slots/profile_info/item/UserInfoItemBlueprint;", "userInfoItemBlueprint", "Lcom/avito/android/publish_limits_info/item/LimitsInfoItemBlueprint;", "limitsInfoItemBlueprint", "Lcom/avito/android/publish/slots/infomation/item/DisclaimerBlueprint;", "disclaimerBlueprint", "Lcom/avito/android/publish/slots/market_price/item/MarketPriceBlueprint;", "marketPriceBlueprint", "Lcom/avito/android/publish/slots/market_price_v2/item/MarketPriceV2Blueprint;", "marketPriceV2Blueprint", "Lcom/avito/android/blueprints/range/cre_range/CreRangeItemBlueprint;", "creRangeBlueprint", "Lcom/avito/android/blueprints/publish/VehicleRegNumberInputItemBlueprint;", "vehicleRegNumberInputItemBlueprint", "Lcom/avito/android/blueprints/video/VideoItemBlueprint;", "videoItemBlueprint", "Lcom/avito/android/publish/slots/link/item/LinkSlotBlueprint;", "linkSlotBlueprint", "Lcom/avito/android/publish/details/adapter/header/HeaderWithDividerItemBlueprint;", "headerWithDividerBlueprint", "Lcom/avito/android/publish/slots/information_with_user_id/item/InformationWithUserIdBlueprint;", "informationWithUserIdSlotBlueprint", "Lcom/avito/android/blueprints/chips_multiselect/ChipsMultiselectItemBlueprint;", "chipsMultiselectItemBlueprint", "Lcom/avito/konveyor/ItemBinder;", "provideItemBinder", "(Lcom/avito/android/blueprints/select/MultiStateSelectItemBlueprint;Lcom/avito/android/blueprints/chips/ChipsSelectItemBlueprint;Lcom/avito/android/blueprints/radiogroup/RadioGroupSelectItemBlueprint;Lcom/avito/android/blueprints/switcher/MultiStateSwitcherItemBlueprint;Lcom/avito/android/blueprints/input/MultiStateInputItemBlueprint;Lcom/avito/android/photo_view/blueprints/MultiStatePhotoItemBlueprint;Lcom/avito/android/publish/details/adapter/date_interval/DateIntervalItemBlueprint;Lcom/avito/android/publish/details/adapter/edit_category/EditCategoryItemBlueprint;Lcom/avito/android/publish/details/adapter/multiselect/MultiselectItemBlueprint;Lcom/avito/android/publish/details/adapter/objects/MultiStateObjectsItemBlueprint;Lcom/avito/android/blueprints/ButtonItemBlueprint;Lcom/avito/android/blueprints/publish/tagged_input/MultiStateInputWithTagsItemBlueprint;Lcom/avito/android/publish/slots/no_car/item/NoCarSlotBlueprint;Lcom/avito/android/publish/slots/cpa_tariff/item/CpaTariffSlotBlueprint;Lcom/avito/android/publish/slots/profile_info/item/UserInfoItemBlueprint;Lcom/avito/android/publish_limits_info/item/LimitsInfoItemBlueprint;Lcom/avito/android/publish/slots/infomation/item/DisclaimerBlueprint;Lcom/avito/android/publish/slots/market_price/item/MarketPriceBlueprint;Lcom/avito/android/publish/slots/market_price_v2/item/MarketPriceV2Blueprint;Lcom/avito/android/blueprints/range/cre_range/CreRangeItemBlueprint;Lcom/avito/android/blueprints/publish/VehicleRegNumberInputItemBlueprint;Lcom/avito/android/blueprints/video/VideoItemBlueprint;Lcom/avito/android/publish/slots/link/item/LinkSlotBlueprint;Lcom/avito/android/publish/details/adapter/header/HeaderWithDividerItemBlueprint;Lcom/avito/android/publish/slots/information_with_user_id/item/InformationWithUserIdBlueprint;Lcom/avito/android/blueprints/chips_multiselect/ChipsMultiselectItemBlueprint;Lcom/avito/android/Features;)Lcom/avito/konveyor/ItemBinder;", "Lcom/avito/android/blueprints/range/cre_range/CreRangePresenter;", "presenter", "provideCRERangeItemBlueprint", "(Lcom/avito/android/blueprints/range/cre_range/CreRangePresenter;)Lcom/avito/android/blueprints/range/cre_range/CreRangeItemBlueprint;", "Lcom/avito/android/blueprints/range/cre_range/CreRangePresenterImpl;", "provideCRERangeItemPresenter", "(Lcom/avito/android/blueprints/range/cre_range/CreRangePresenterImpl;)Lcom/avito/android/blueprints/range/cre_range/CreRangePresenter;", "Lcom/avito/android/publish/details/adapter/date_interval/DateIntervalItemPresenter;", "provideDateIntervalItemBlueprint", "(Lcom/avito/android/publish/details/adapter/date_interval/DateIntervalItemPresenter;)Lcom/avito/android/publish/details/adapter/date_interval/DateIntervalItemBlueprint;", "Lcom/avito/android/publish/details/adapter/edit_category/EditCategoryItemPresenter;", "provideEditCategoryItemBlueprint", "(Lcom/avito/android/publish/details/adapter/edit_category/EditCategoryItemPresenter;)Lcom/avito/android/publish/details/adapter/edit_category/EditCategoryItemBlueprint;", "Lcom/avito/android/publish/details/adapter/multiselect/RdsMultiselectItemPresenter;", "provideMultiselectItemBlueprint", "(Lcom/avito/android/publish/details/adapter/multiselect/RdsMultiselectItemPresenter;)Lcom/avito/android/publish/details/adapter/multiselect/MultiselectItemBlueprint;", "Lcom/avito/android/publish/details/adapter/objects/MultiStateObjectsItemPresenter;", "provideObjectsItemBlueprint", "(Lcom/avito/android/publish/details/adapter/objects/MultiStateObjectsItemPresenter;)Lcom/avito/android/publish/details/adapter/objects/MultiStateObjectsItemBlueprint;", "provideObjectsItemPresenter", "()Lcom/avito/android/publish/details/adapter/objects/MultiStateObjectsItemPresenter;", "Lcom/avito/android/photo_view/blueprints/MultiStatePhotoItemPresenter;", "providePhotoItemBlueprint", "(Lcom/avito/android/photo_view/blueprints/MultiStatePhotoItemPresenter;)Lcom/avito/android/photo_view/blueprints/MultiStatePhotoItemBlueprint;", "Lcom/avito/android/photo_view/ImageListPresenter;", "imageListPresenter", "Lcom/avito/android/photo_view/PhotoViewResourceProvider;", "resourcesProvider", "provideMultiStatePhotoItemPresenter", "(Lcom/avito/android/photo_view/ImageListPresenter;Lcom/avito/android/util/text/AttributedTextFormatter;Lcom/avito/android/photo_view/PhotoViewResourceProvider;)Lcom/avito/android/photo_view/blueprints/MultiStatePhotoItemPresenter;", "Lcom/avito/android/blueprints/select/MultiStateSelectItemPresenter;", "provideSelectItemBlueprint", "(Lcom/avito/android/blueprints/select/MultiStateSelectItemPresenter;)Lcom/avito/android/blueprints/select/MultiStateSelectItemBlueprint;", "provideSelectItemPresenter", "(Lcom/avito/android/util/text/AttributedTextFormatter;)Lcom/avito/android/blueprints/select/MultiStateSelectItemPresenter;", "provideMultiselectItemPresenter", "(Lcom/avito/android/util/text/AttributedTextFormatter;)Lcom/avito/android/publish/details/adapter/multiselect/RdsMultiselectItemPresenter;", "Lcom/avito/android/publish/slots/profile_info/item/UserInfoItemPresenter;", "Lcom/avito/android/component/profile_snippet/AvatarRenderer;", "avatarRenderer", "provideUserInfoBlueprint", "(Lcom/avito/android/publish/slots/profile_info/item/UserInfoItemPresenter;Lcom/avito/android/component/profile_snippet/AvatarRenderer;)Lcom/avito/android/publish/slots/profile_info/item/UserInfoItemBlueprint;", "provideAvatarRenderer", "()Lcom/avito/android/component/profile_snippet/AvatarRenderer;", "provideUserInfoPresenter", "()Lcom/avito/android/publish/slots/profile_info/item/UserInfoItemPresenter;", "providePublishDetailsResourceProvider", "()Lcom/avito/android/publish/details/PublishDetailsResourceProvider;", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "provideAdapter", "(Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;)Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/avito/android/blueprints/ButtonItemPresenter;", "buttonItemPresenter", "provideButtonBlueprint", "(Lcom/avito/android/blueprints/ButtonItemPresenter;)Lcom/avito/android/blueprints/ButtonItemBlueprint;", "Ldagger/Lazy;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "provideButtonItemPresenter", "(Ldagger/Lazy;)Lcom/avito/android/blueprints/ButtonItemPresenter;", "Lcom/avito/android/publish/slots/infomation/item/DisclaimerItemPresenter;", "provideDisclaimerBlueprint", "(Lcom/avito/android/publish/slots/infomation/item/DisclaimerItemPresenter;Lcom/avito/android/util/text/AttributedTextFormatter;)Lcom/avito/android/publish/slots/infomation/item/DisclaimerBlueprint;", "Lcom/avito/android/publish/slots/no_car/item/NoCarSlotItemPresenter;", "provideNoCarSlotBlueprint", "(Lcom/avito/android/publish/slots/no_car/item/NoCarSlotItemPresenter;)Lcom/avito/android/publish/slots/no_car/item/NoCarSlotBlueprint;", "provideNoCarSlotPresenter", "()Lcom/avito/android/publish/slots/no_car/item/NoCarSlotItemPresenter;", "Lcom/avito/android/publish/slots/cpa_tariff/item/CpaTariffSlotItemPresenter;", "provideCpaTariffSlotBlueprint", "(Lcom/avito/android/publish/slots/cpa_tariff/item/CpaTariffSlotItemPresenter;)Lcom/avito/android/publish/slots/cpa_tariff/item/CpaTariffSlotBlueprint;", "provideCpaTariffSlotPresenter", "()Lcom/avito/android/publish/slots/cpa_tariff/item/CpaTariffSlotItemPresenter;", "Lcom/avito/android/publish/slots/link/item/LinkSlotItemPresenter;", "provideLinkSlotBlueprint", "(Lcom/avito/android/publish/slots/link/item/LinkSlotItemPresenter;)Lcom/avito/android/publish/slots/link/item/LinkSlotBlueprint;", "provideLinkSlotPresenter", "(Lcom/avito/android/util/text/AttributedTextFormatter;)Lcom/avito/android/publish/slots/link/item/LinkSlotItemPresenter;", "analyticsDataProvider", "Lcom/avito/android/validation/ValidationLogger;", "provideValidationLogger", "(Lcom/avito/android/analytics/Analytics;Lcom/avito/android/analytics/publish/PublishAnalyticsDataProvider;)Lcom/avito/android/validation/ValidationLogger;", "multiStateSelectPresenter", "Lcom/avito/android/blueprints/chips/ChipsSelectItemPresenter;", "chipsSelectItemPresenter", "Lcom/avito/android/blueprints/chips_multiselect/ChipsMultiselectItemPresenter;", "chipsMultiselectItemPresenter", "Lcom/avito/android/blueprints/radiogroup/RadioGroupSelectItemPresenter;", "radioGroupSelectItemPresenter", "multiSelectItemPresenter", "Lcom/avito/android/blueprints/switcher/MultiStateSwitcherItemPresenter;", "multiStateSwitcherItemPresenter", "Lcom/avito/android/blueprints/input/MultiStateInputItemPresenter;", "multiStateInputItemPresenter", "multiStateObjectsItemPresenter", "Lcom/avito/android/blueprints/publish/tagged_input/MultiStateInputWithTagsItemPresenter;", "taggedInputItemPresenter", "infoNoCarItemPresenter", "editCategoryItemPresenter", "creRangePresenter", "Lcom/avito/android/blueprints/publish/VehicleRegNumberInputItemPresenter;", "vehicleRegNumberPresenter", "Lcom/avito/android/blueprints/video/VideoItemPresenter;", "videoItemPresenter", "linkSlotItemPresenter", "Lcom/avito/android/publish/slots/market_price_v2/item/MarketPriceV2Presenter;", "marketPriceV2ItemPresenter", "Lcom/avito/android/publish_limits_info/item/LimitsInfoItemPresenter;", "limitsInfoItemPresenter", "cpaTariffSlotItemPresenter", "provideItemPresentersSet", "(Lcom/avito/android/blueprints/select/MultiStateSelectItemPresenter;Lcom/avito/android/blueprints/chips/ChipsSelectItemPresenter;Lcom/avito/android/blueprints/chips_multiselect/ChipsMultiselectItemPresenter;Lcom/avito/android/blueprints/radiogroup/RadioGroupSelectItemPresenter;Lcom/avito/android/publish/details/adapter/multiselect/RdsMultiselectItemPresenter;Lcom/avito/android/blueprints/switcher/MultiStateSwitcherItemPresenter;Lcom/avito/android/blueprints/input/MultiStateInputItemPresenter;Lcom/avito/android/publish/details/adapter/objects/MultiStateObjectsItemPresenter;Lcom/avito/android/blueprints/publish/tagged_input/MultiStateInputWithTagsItemPresenter;Lcom/avito/android/publish/slots/no_car/item/NoCarSlotItemPresenter;Lcom/avito/android/publish/details/adapter/edit_category/EditCategoryItemPresenter;Lcom/avito/android/blueprints/range/cre_range/CreRangePresenter;Lcom/avito/android/blueprints/publish/VehicleRegNumberInputItemPresenter;Lcom/avito/android/blueprints/video/VideoItemPresenter;Lcom/avito/android/publish/slots/link/item/LinkSlotItemPresenter;Lcom/avito/android/publish/slots/market_price_v2/item/MarketPriceV2Presenter;Lcom/avito/android/publish_limits_info/item/LimitsInfoItemPresenter;Lcom/avito/android/publish/slots/cpa_tariff/item/CpaTariffSlotItemPresenter;)Ljava/util/Set;", "Lcom/avito/android/photo_picker/legacy/PhotoInteractor;", "photoInteractor", "provideInsertPhotoInteractor", "(Lcom/avito/android/photo_picker/legacy/PhotoInteractor;)Lcom/avito/android/publish/details/PhotoInteractorWrapper;", "Lcom/avito/android/publish/PhotoUploadObserverImpl;", "observer", "providePhotoObserver$publish_release", "(Lcom/avito/android/publish/PhotoUploadObserverImpl;)Lcom/avito/android/publish/PhotoUploadObserver;", "providePhotoObserver", "Landroid/content/res/Resources;", "resources", "provideContactsStringsProvider", "(Landroid/content/res/Resources;)Lcom/avito/android/publish/slots/profile_info/PublishContactsStringProvider;", "provideContactsDataSource", "(Lcom/avito/android/publish/ProfileSourceInteractor;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/publish/details/analytics/PublishDetailsTracker;)Lcom/avito/android/publish/ContactsDataSource;", "Lcom/avito/android/publish/details/tags/PublishTagsViewModelFactory;", "factory", "Lcom/avito/android/publish/details/tags/PublishTagsViewModel;", "providePublishTagsViewModel", "(Lcom/avito/android/publish/details/tags/PublishTagsViewModelFactory;)Lcom/avito/android/publish/details/tags/PublishTagsViewModel;", "Lcom/avito/android/html_editor/EditorHistoryProvider;", "historyProvider", "Lcom/avito/android/html_formatter/HtmlRenderOptions;", "htmlRenderOptions", "Lcom/avito/android/blueprints/publish/html_editor/HtmlEditorViewModelFactory;", "provideHtmlEditorViewModelFactory", "(Lcom/avito/android/html_editor/EditorHistoryProvider;Lcom/avito/android/html_formatter/HtmlNodeFactory;Lcom/avito/android/html_formatter/HtmlRenderOptions;)Lcom/avito/android/blueprints/publish/html_editor/HtmlEditorViewModelFactory;", "Lcom/avito/android/blueprints/publish/html_editor/HtmlEditorViewModel;", "provideHtmlEditorViewModel", "(Lcom/avito/android/blueprints/publish/html_editor/HtmlEditorViewModelFactory;)Lcom/avito/android/blueprints/publish/html_editor/HtmlEditorViewModel;", "tagsViewModel", "Lcom/avito/android/ui/widget/tagged_input/TagsViewModel;", "provideTagsViewModel", "(Lcom/avito/android/publish/details/tags/PublishTagsViewModel;)Lcom/avito/android/ui/widget/tagged_input/TagsViewModel;", "Lcom/avito/android/publish/details/tags/PublishTagsInteractor;", "tagsInteractor", "provideTagsViewModelFactory", "(Lcom/avito/android/publish/details/tags/PublishTagsInteractor;Lcom/avito/android/util/SchedulersFactory;)Lcom/avito/android/publish/details/tags/PublishTagsViewModelFactory;", "Landroidx/fragment/app/Fragment;", "f", "Landroidx/fragment/app/Fragment;", "lifeCycleOwner", "", "c", "I", "stepIndex", "Landroid/os/Bundle;", AuthSource.SEND_ABUSE, "Landroid/os/Bundle;", "savedState", "", "e", "Z", "isEditing", AuthSource.BOOKING_ORDER, "Landroid/content/res/Resources;", "d", "Ljava/lang/String;", "draftId", "<init>", "(Landroid/os/Bundle;Landroid/content/res/Resources;ILjava/lang/String;ZLandroidx/fragment/app/Fragment;)V", "Declarations", "publish_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {Declarations.class, PhoneNumberFormatterModule.class, ParametersListModule.class, AttributedTextFormatterModule.class, AdvertProactiveModerationModule.class, PublishParametersModule.class, SessionUpdateTrackerModule.class, PublishDetailsAnalyticsModule.class, PublishLimitsAnalyticsModule.class})
public final class PublishDetailsModule {
    public final Bundle a;
    public final Resources b;
    public final int c;
    public final String d;
    public final boolean e;
    public final Fragment f;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000Î\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0007H'¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH'¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u0010H'¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\u00152\u0006\u0010\f\u001a\u00020\u0014H'¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001a\u001a\u00020\u00192\u0006\u0010\f\u001a\u00020\u0018H'¢\u0006\u0004\b\u001a\u0010\u001bJ\u001d\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e2\u0006\u0010\u001d\u001a\u00020\u001cH'¢\u0006\u0004\b \u0010!J\u0017\u0010$\u001a\u00020#2\u0006\u0010\u0003\u001a\u00020\"H'¢\u0006\u0004\b$\u0010%J\u0017\u0010)\u001a\u00020(2\u0006\u0010'\u001a\u00020&H'¢\u0006\u0004\b)\u0010*J\u0017\u0010-\u001a\u00020,2\u0006\u0010\f\u001a\u00020+H'¢\u0006\u0004\b-\u0010.J\u0017\u00102\u001a\u0002012\u0006\u00100\u001a\u00020/H'¢\u0006\u0004\b2\u00103J\u0017\u00107\u001a\u0002062\u0006\u00105\u001a\u000204H'¢\u0006\u0004\b7\u00108J\u0017\u0010;\u001a\u00020:2\u0006\u00105\u001a\u000209H'¢\u0006\u0004\b;\u0010<J\u0017\u0010?\u001a\u00020>2\u0006\u0010\f\u001a\u00020=H'¢\u0006\u0004\b?\u0010@J\u0017\u0010D\u001a\u00020C2\u0006\u0010B\u001a\u00020AH'¢\u0006\u0004\bD\u0010E¨\u0006F"}, d2 = {"Lcom/avito/android/publish/details/di/PublishDetailsModule$Declarations;", "", "Lcom/avito/android/publish/pretend/PretendInteractorImpl;", "interactor", "Lcom/avito/android/publish/pretend/PretendInteractor;", "bindsPretendInteractor", "(Lcom/avito/android/publish/pretend/PretendInteractorImpl;)Lcom/avito/android/publish/pretend/PretendInteractor;", "Lcom/avito/android/publish/details/tags/PublishTagsInteractorImpl;", "Lcom/avito/android/publish/details/tags/PublishTagsInteractor;", "bindsTagsInteractor", "(Lcom/avito/android/publish/details/tags/PublishTagsInteractorImpl;)Lcom/avito/android/publish/details/tags/PublishTagsInteractor;", "Lcom/avito/android/publish/details/adapter/date_interval/DateIntervalItemPresenterImpl;", "presenter", "Lcom/avito/android/publish/details/adapter/date_interval/DateIntervalItemPresenter;", "bindsDateIntervalItemPresenter", "(Lcom/avito/android/publish/details/adapter/date_interval/DateIntervalItemPresenterImpl;)Lcom/avito/android/publish/details/adapter/date_interval/DateIntervalItemPresenter;", "Lcom/avito/android/publish_limits_info/item/LimitsInfoItemPresenterImpl;", "Lcom/avito/android/publish_limits_info/item/LimitsInfoItemPresenter;", "bindsLimitsInfoItemPresenter", "(Lcom/avito/android/publish_limits_info/item/LimitsInfoItemPresenterImpl;)Lcom/avito/android/publish_limits_info/item/LimitsInfoItemPresenter;", "Lcom/avito/android/blueprints/video/VideoItemPresenterImpl;", "Lcom/avito/android/blueprints/video/VideoItemPresenter;", "bindsVideoItemPresenter", "(Lcom/avito/android/blueprints/video/VideoItemPresenterImpl;)Lcom/avito/android/blueprints/video/VideoItemPresenter;", "Lcom/avito/android/publish/details/adapter/edit_category/EditCategoryItemPresenterImpl;", "Lcom/avito/android/publish/details/adapter/edit_category/EditCategoryItemPresenter;", "bindsEditCategoryItemPresenter", "(Lcom/avito/android/publish/details/adapter/edit_category/EditCategoryItemPresenterImpl;)Lcom/avito/android/publish/details/adapter/edit_category/EditCategoryItemPresenter;", "Lcom/avito/android/publish/details/ItemPostProcessor;", "processor", "Lcom/avito/android/publish/details/ItemWrapper;", "Lcom/avito/conveyor_item/Item;", "bindItemWrapper", "(Lcom/avito/android/publish/details/ItemPostProcessor;)Lcom/avito/android/publish/details/ItemWrapper;", "Lcom/avito/android/publish/details/VideoInteractorImpl;", "Lcom/avito/android/publish/details/VideoInteractor;", "bindVideoInteractor", "(Lcom/avito/android/publish/details/VideoInteractorImpl;)Lcom/avito/android/publish/details/VideoInteractor;", "Lcom/avito/android/publish/details/item_wrapper/ItemWrapperFactoryImpl;", "factory", "Lcom/avito/android/publish/details/item_wrapper/ItemWrapperFactory;", "bindItemWrapperFactory", "(Lcom/avito/android/publish/details/item_wrapper/ItemWrapperFactoryImpl;)Lcom/avito/android/publish/details/item_wrapper/ItemWrapperFactory;", "Lcom/avito/android/publish/details/adapter/header/HeaderWithDividerItemPresenterImpl;", "Lcom/avito/android/publish/details/adapter/header/HeaderWithDividerItemPresenter;", "bindHeaderWithDividerPresenter", "(Lcom/avito/android/publish/details/adapter/header/HeaderWithDividerItemPresenterImpl;)Lcom/avito/android/publish/details/adapter/header/HeaderWithDividerItemPresenter;", "Lcom/avito/android/publish/details/adapter/header/HeaderWithDividerItemBlueprintImpl;", "blueprint", "Lcom/avito/android/publish/details/adapter/header/HeaderWithDividerItemBlueprint;", "bindHeaderWithDividerBlueprint", "(Lcom/avito/android/publish/details/adapter/header/HeaderWithDividerItemBlueprintImpl;)Lcom/avito/android/publish/details/adapter/header/HeaderWithDividerItemBlueprint;", "Lcom/avito/android/photo_view/PhotoViewResourceProviderImpl;", GeoContract.PROVIDER, "Lcom/avito/android/photo_view/PhotoViewResourceProvider;", "bindPhotoViewResourcesProvider", "(Lcom/avito/android/photo_view/PhotoViewResourceProviderImpl;)Lcom/avito/android/photo_view/PhotoViewResourceProvider;", "Lcom/avito/android/publish/slots/limits_info/LimitsInfoSlotLayoutProvider;", "Lcom/avito/android/publish_limits_info/item/LimitsInfoItemBlueprint$LayoutProvider;", "bindLimitsItemLayoutProvider", "(Lcom/avito/android/publish/slots/limits_info/LimitsInfoSlotLayoutProvider;)Lcom/avito/android/publish_limits_info/item/LimitsInfoItemBlueprint$LayoutProvider;", "Lcom/avito/android/publish/slots/market_price_v2/item/MarketPriceV2PresenterImpl;", "Lcom/avito/android/publish/slots/market_price_v2/item/MarketPriceV2Presenter;", "bindMarketPriceV2Presenter", "(Lcom/avito/android/publish/slots/market_price_v2/item/MarketPriceV2PresenterImpl;)Lcom/avito/android/publish/slots/market_price_v2/item/MarketPriceV2Presenter;", "Lcom/avito/android/publish/slots/market_price_v2/item/MarketPriceV2FormatterImpl;", "formatter", "Lcom/avito/android/publish/slots/market_price_v2/item/MarketPriceV2Formatter;", "bindMarketPriceV2Formatter", "(Lcom/avito/android/publish/slots/market_price_v2/item/MarketPriceV2FormatterImpl;)Lcom/avito/android/publish/slots/market_price_v2/item/MarketPriceV2Formatter;", "publish_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @PerFragment
        @Binds
        @NotNull
        HeaderWithDividerItemBlueprint bindHeaderWithDividerBlueprint(@NotNull HeaderWithDividerItemBlueprintImpl headerWithDividerItemBlueprintImpl);

        @PerFragment
        @Binds
        @NotNull
        HeaderWithDividerItemPresenter bindHeaderWithDividerPresenter(@NotNull HeaderWithDividerItemPresenterImpl headerWithDividerItemPresenterImpl);

        @Binds
        @NotNull
        @PerFragment
        ItemWrapper<Item> bindItemWrapper(@NotNull ItemPostProcessor itemPostProcessor);

        @PerFragment
        @Binds
        @NotNull
        ItemWrapperFactory bindItemWrapperFactory(@NotNull ItemWrapperFactoryImpl itemWrapperFactoryImpl);

        @PerFragment
        @Binds
        @NotNull
        LimitsInfoItemBlueprint.LayoutProvider bindLimitsItemLayoutProvider(@NotNull LimitsInfoSlotLayoutProvider limitsInfoSlotLayoutProvider);

        @PerFragment
        @Binds
        @NotNull
        MarketPriceV2Formatter bindMarketPriceV2Formatter(@NotNull MarketPriceV2FormatterImpl marketPriceV2FormatterImpl);

        @PerFragment
        @Binds
        @NotNull
        MarketPriceV2Presenter bindMarketPriceV2Presenter(@NotNull MarketPriceV2PresenterImpl marketPriceV2PresenterImpl);

        @PerFragment
        @Binds
        @NotNull
        PhotoViewResourceProvider bindPhotoViewResourcesProvider(@NotNull PhotoViewResourceProviderImpl photoViewResourceProviderImpl);

        @PerFragment
        @Binds
        @NotNull
        VideoInteractor bindVideoInteractor(@NotNull VideoInteractorImpl videoInteractorImpl);

        @PerFragment
        @Binds
        @NotNull
        DateIntervalItemPresenter bindsDateIntervalItemPresenter(@NotNull DateIntervalItemPresenterImpl dateIntervalItemPresenterImpl);

        @PerFragment
        @Binds
        @NotNull
        EditCategoryItemPresenter bindsEditCategoryItemPresenter(@NotNull EditCategoryItemPresenterImpl editCategoryItemPresenterImpl);

        @PerFragment
        @Binds
        @NotNull
        LimitsInfoItemPresenter bindsLimitsInfoItemPresenter(@NotNull LimitsInfoItemPresenterImpl limitsInfoItemPresenterImpl);

        @PerFragment
        @Binds
        @NotNull
        PretendInteractor bindsPretendInteractor(@NotNull PretendInteractorImpl pretendInteractorImpl);

        @PerFragment
        @Binds
        @NotNull
        PublishTagsInteractor bindsTagsInteractor(@NotNull PublishTagsInteractorImpl publishTagsInteractorImpl);

        @PerFragment
        @Binds
        @NotNull
        VideoItemPresenter bindsVideoItemPresenter(@NotNull VideoItemPresenterImpl videoItemPresenterImpl);
    }

    public PublishDetailsModule(@Nullable Bundle bundle, @NotNull Resources resources, int i, @NotNull String str, boolean z, @NotNull Fragment fragment) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        Intrinsics.checkNotNullParameter(str, "draftId");
        Intrinsics.checkNotNullParameter(fragment, "lifeCycleOwner");
        this.a = bundle;
        this.b = resources;
        this.c = i;
        this.d = str;
        this.e = z;
        this.f = fragment;
    }

    @Provides
    @NotNull
    @PerFragment
    public final RecyclerView.Adapter<?> provideAdapter(@NotNull SimpleRecyclerAdapter simpleRecyclerAdapter) {
        Intrinsics.checkNotNullParameter(simpleRecyclerAdapter, "adapter");
        simpleRecyclerAdapter.setHasStableIds(true);
        return simpleRecyclerAdapter;
    }

    @Provides
    @PerFragment
    @NotNull
    public final AvatarRenderer provideAvatarRenderer() {
        return new AdvertSellerAvatarRenderer();
    }

    @Provides
    @PerFragment
    @NotNull
    public final ButtonItemBlueprint provideButtonBlueprint(@NotNull ButtonItemPresenter buttonItemPresenter) {
        Intrinsics.checkNotNullParameter(buttonItemPresenter, "buttonItemPresenter");
        return new ButtonItemBlueprint(buttonItemPresenter);
    }

    @Provides
    @NotNull
    @PerFragment
    public final ButtonItemPresenter provideButtonItemPresenter(@NotNull Lazy<PublishDetailsPresenter> lazy) {
        Intrinsics.checkNotNullParameter(lazy, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        return new ButtonItemPresenterImpl(lazy);
    }

    @Provides
    @PerFragment
    @NotNull
    public final CreRangeItemBlueprint provideCRERangeItemBlueprint(@NotNull CreRangePresenter creRangePresenter) {
        Intrinsics.checkNotNullParameter(creRangePresenter, "presenter");
        return new CreRangeItemBlueprint(creRangePresenter);
    }

    @Provides
    @PerFragment
    @NotNull
    public final CreRangePresenter provideCRERangeItemPresenter(@NotNull CreRangePresenterImpl creRangePresenterImpl) {
        Intrinsics.checkNotNullParameter(creRangePresenterImpl, "presenter");
        return creRangePresenterImpl;
    }

    @Provides
    @NotNull
    @PerFragment
    public final CategoryParametersElementConverter provideCategoryParametersElementConverter(@PhoneNumberFormatterModule.PhoneNumberFormatterWithCountryCode @NotNull Formatter<String> formatter, @NotNull TimeSource timeSource, @NotNull Locale locale, @NotNull Features features, @NotNull AbTestsConfigProvider abTestsConfigProvider, @NotNull HtmlCleaner htmlCleaner, @NotNull HtmlNodeFactory htmlNodeFactory) {
        Intrinsics.checkNotNullParameter(formatter, "phoneFormatter");
        Intrinsics.checkNotNullParameter(timeSource, "timeSource");
        Intrinsics.checkNotNullParameter(locale, "locale");
        Intrinsics.checkNotNullParameter(features, "features");
        Intrinsics.checkNotNullParameter(abTestsConfigProvider, "testsConfigProvider");
        Intrinsics.checkNotNullParameter(htmlCleaner, "htmlCleaner");
        Intrinsics.checkNotNullParameter(htmlNodeFactory, "htmlNodeFactory");
        return new CategoryParametersElementConverter(formatter, this.b, timeSource, this.e, false, locale, false, true, features.getRangeParameter().invoke().booleanValue(), abTestsConfigProvider.notReadyVideoOnPublish().getTestGroup().isTest(), htmlNodeFactory, htmlCleaner, features, 80, null);
    }

    @Provides
    @PerFragment
    @NotNull
    public final ContactsDataSource provideContactsDataSource(@NotNull ProfileSourceInteractor profileSourceInteractor, @NotNull SchedulersFactory schedulersFactory, @NotNull PublishDetailsTracker publishDetailsTracker) {
        Intrinsics.checkNotNullParameter(profileSourceInteractor, "profileSource");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(publishDetailsTracker, "performanceTracker");
        return new ContactsDataSourceImpl(profileSourceInteractor, schedulersFactory, publishDetailsTracker);
    }

    @Provides
    @PerFragment
    @NotNull
    public final PublishContactsStringProvider provideContactsStringsProvider(@NotNull Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        return new PublishContactsStringProviderImpl(resources);
    }

    @Provides
    @PerFragment
    @NotNull
    public final CpaTariffSlotBlueprint provideCpaTariffSlotBlueprint(@NotNull CpaTariffSlotItemPresenter cpaTariffSlotItemPresenter) {
        Intrinsics.checkNotNullParameter(cpaTariffSlotItemPresenter, "presenter");
        return new CpaTariffSlotBlueprint(cpaTariffSlotItemPresenter);
    }

    @Provides
    @PerFragment
    @NotNull
    public final CpaTariffSlotItemPresenter provideCpaTariffSlotPresenter() {
        return new CpaTariffSlotItemPresenterImpl();
    }

    @Provides
    @PerFragment
    @NotNull
    public final DateIntervalItemBlueprint provideDateIntervalItemBlueprint(@NotNull DateIntervalItemPresenter dateIntervalItemPresenter) {
        Intrinsics.checkNotNullParameter(dateIntervalItemPresenter, "presenter");
        return new DateIntervalItemBlueprint(dateIntervalItemPresenter);
    }

    @Provides
    @PerFragment
    @NotNull
    public final PublishDetailsInteractor provideDetailsInteractor(@NotNull PretendInteractor pretendInteractor, @NotNull PublishParametersInteractor publishParametersInteractor) {
        Intrinsics.checkNotNullParameter(pretendInteractor, "pretendInteractor");
        Intrinsics.checkNotNullParameter(publishParametersInteractor, "publishParametersInteractor");
        return new PublishDetailsInteractorImpl(pretendInteractor, publishParametersInteractor);
    }

    @Provides
    @NotNull
    @PerFragment
    public final PublishDetailsPresenter provideDetailsPresenter(@NotNull PublishDetailsInteractor publishDetailsInteractor, @NotNull ItemDetailsSelectResultHandler itemDetailsSelectResultHandler, @NotNull PhotoInteractorWrapper photoInteractorWrapper, @NotNull ItemDetailsParameterClickListener itemDetailsParameterClickListener, @NotNull CategoryParametersElementConverter categoryParametersElementConverter, @NotNull SchedulersFactory schedulersFactory, @NotNull ParametersListPresenter parametersListPresenter, @NotNull ParametersListPresenter parametersListPresenter2, @NotNull PublishDetailsResourceProvider publishDetailsResourceProvider, @NotNull PublishInputsAnalyticTracker publishInputsAnalyticTracker, @NotNull UploadingProgressInteractor uploadingProgressInteractor, @NotNull PublishEventTracker publishEventTracker, @NotNull Set<ItemPresenter<?, ?>> set, @NotNull Features features, @PhoneNumberFormatterModule.PhoneNumberFormatterWithCountryCode @NotNull Formatter<String> formatter, @NotNull SlotsFactory slotsFactory, @NotNull DeviceMetrics deviceMetrics, @NotNull PhotoUploadObserver photoUploadObserver, @NotNull ComputerVisionInteractor computerVisionInteractor, @NotNull AbTestsConfigProvider abTestsConfigProvider, @NotNull ItemPostProcessor itemPostProcessor, @NotNull PublishDetailsFlowTracker publishDetailsFlowTracker) {
        Intrinsics.checkNotNullParameter(publishDetailsInteractor, "interactor");
        Intrinsics.checkNotNullParameter(itemDetailsSelectResultHandler, "resultHandler");
        Intrinsics.checkNotNullParameter(photoInteractorWrapper, "insertPhotoInteractor");
        Intrinsics.checkNotNullParameter(itemDetailsParameterClickListener, "parameterClickListener");
        Intrinsics.checkNotNullParameter(categoryParametersElementConverter, "categoryParametersElementConverter");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulersFactory");
        Intrinsics.checkNotNullParameter(parametersListPresenter, "submissionListener");
        Intrinsics.checkNotNullParameter(parametersListPresenter2, "parametersListPresenter");
        Intrinsics.checkNotNullParameter(publishDetailsResourceProvider, "resourceProvider");
        Intrinsics.checkNotNullParameter(publishInputsAnalyticTracker, "inputsAnalyticTracker");
        Intrinsics.checkNotNullParameter(uploadingProgressInteractor, "uploadingProgressInteractor");
        Intrinsics.checkNotNullParameter(publishEventTracker, "publishEventTracker");
        Intrinsics.checkNotNullParameter(set, "itemPresentersSet");
        Intrinsics.checkNotNullParameter(features, "features");
        Intrinsics.checkNotNullParameter(formatter, "phoneFormatter");
        Intrinsics.checkNotNullParameter(slotsFactory, "slotsFactory");
        Intrinsics.checkNotNullParameter(deviceMetrics, "deviceMetrics");
        Intrinsics.checkNotNullParameter(photoUploadObserver, "photoObserver");
        Intrinsics.checkNotNullParameter(computerVisionInteractor, "cvInteractor");
        Intrinsics.checkNotNullParameter(abTestsConfigProvider, "abTestsConfigProvider");
        Intrinsics.checkNotNullParameter(itemPostProcessor, "itemPostProcessor");
        Intrinsics.checkNotNullParameter(publishDetailsFlowTracker, "flowTracker");
        return new PublishDetailsPresenterImpl(publishDetailsInteractor, schedulersFactory, publishDetailsResourceProvider, categoryParametersElementConverter, itemDetailsParameterClickListener, itemDetailsSelectResultHandler, photoInteractorWrapper, uploadingProgressInteractor, parametersListPresenter, parametersListPresenter2, publishInputsAnalyticTracker, publishEventTracker, set, this.c, formatter, slotsFactory, deviceMetrics, photoUploadObserver, computerVisionInteractor, abTestsConfigProvider, itemPostProcessor, publishDetailsFlowTracker, this.a);
    }

    @Provides
    @PerFragment
    @NotNull
    public final DisclaimerBlueprint provideDisclaimerBlueprint(@NotNull DisclaimerItemPresenter disclaimerItemPresenter, @NotNull AttributedTextFormatter attributedTextFormatter) {
        Intrinsics.checkNotNullParameter(disclaimerItemPresenter, "presenter");
        Intrinsics.checkNotNullParameter(attributedTextFormatter, "attributedTextFormatter");
        return new DisclaimerBlueprint(disclaimerItemPresenter, attributedTextFormatter);
    }

    @Provides
    @PerFragment
    @NotNull
    public final EditCategoryItemBlueprint provideEditCategoryItemBlueprint(@NotNull EditCategoryItemPresenter editCategoryItemPresenter) {
        Intrinsics.checkNotNullParameter(editCategoryItemPresenter, "presenter");
        return new EditCategoryItemBlueprint(editCategoryItemPresenter);
    }

    @Provides
    @PerFragment
    @NotNull
    public final HtmlEditorViewModel provideHtmlEditorViewModel(@NotNull HtmlEditorViewModelFactory htmlEditorViewModelFactory) {
        Intrinsics.checkNotNullParameter(htmlEditorViewModelFactory, "factory");
        ViewModel viewModel = new ViewModelProvider(this.f, htmlEditorViewModelFactory).get(HtmlEditorViewModelImpl.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(lifeCy…iewModelImpl::class.java)");
        return (HtmlEditorViewModel) viewModel;
    }

    @Provides
    @PerFragment
    @NotNull
    public final HtmlEditorViewModelFactory provideHtmlEditorViewModelFactory(@NotNull EditorHistoryProvider editorHistoryProvider, @NotNull HtmlNodeFactory htmlNodeFactory, @NotNull HtmlRenderOptions htmlRenderOptions) {
        Intrinsics.checkNotNullParameter(editorHistoryProvider, "historyProvider");
        Intrinsics.checkNotNullParameter(htmlNodeFactory, "htmlNodeFactory");
        Intrinsics.checkNotNullParameter(htmlRenderOptions, "htmlRenderOptions");
        return new HtmlEditorViewModelFactory(editorHistoryProvider, htmlNodeFactory, htmlRenderOptions, this.f);
    }

    @Provides
    @PerFragment
    @NotNull
    public final PhotoInteractorWrapper provideInsertPhotoInteractor(@NotNull PhotoInteractor photoInteractor) {
        Intrinsics.checkNotNullParameter(photoInteractor, "photoInteractor");
        return new InsertPhotoInteractorImpl(this.d, photoInteractor);
    }

    @Provides
    @PerFragment
    @NotNull
    public final ItemBinder provideItemBinder(@NotNull MultiStateSelectItemBlueprint multiStateSelectItemBlueprint, @NotNull ChipsSelectItemBlueprint chipsSelectItemBlueprint, @NotNull RadioGroupSelectItemBlueprint radioGroupSelectItemBlueprint, @NotNull MultiStateSwitcherItemBlueprint multiStateSwitcherItemBlueprint, @NotNull MultiStateInputItemBlueprint multiStateInputItemBlueprint, @NotNull MultiStatePhotoItemBlueprint multiStatePhotoItemBlueprint, @NotNull DateIntervalItemBlueprint dateIntervalItemBlueprint, @NotNull EditCategoryItemBlueprint editCategoryItemBlueprint, @NotNull MultiselectItemBlueprint multiselectItemBlueprint, @NotNull MultiStateObjectsItemBlueprint multiStateObjectsItemBlueprint, @NotNull ButtonItemBlueprint buttonItemBlueprint, @NotNull MultiStateInputWithTagsItemBlueprint multiStateInputWithTagsItemBlueprint, @NotNull NoCarSlotBlueprint noCarSlotBlueprint, @NotNull CpaTariffSlotBlueprint cpaTariffSlotBlueprint, @NotNull UserInfoItemBlueprint userInfoItemBlueprint, @NotNull LimitsInfoItemBlueprint limitsInfoItemBlueprint, @NotNull DisclaimerBlueprint disclaimerBlueprint, @NotNull MarketPriceBlueprint marketPriceBlueprint, @NotNull MarketPriceV2Blueprint marketPriceV2Blueprint, @NotNull CreRangeItemBlueprint creRangeItemBlueprint, @NotNull VehicleRegNumberInputItemBlueprint vehicleRegNumberInputItemBlueprint, @NotNull VideoItemBlueprint videoItemBlueprint, @NotNull LinkSlotBlueprint linkSlotBlueprint, @NotNull HeaderWithDividerItemBlueprint headerWithDividerItemBlueprint, @NotNull InformationWithUserIdBlueprint informationWithUserIdBlueprint, @NotNull ChipsMultiselectItemBlueprint chipsMultiselectItemBlueprint, @NotNull Features features) {
        Intrinsics.checkNotNullParameter(multiStateSelectItemBlueprint, "multiStateSelectItemBlueprint");
        Intrinsics.checkNotNullParameter(chipsSelectItemBlueprint, "chipsSelectItemBlueprint");
        Intrinsics.checkNotNullParameter(radioGroupSelectItemBlueprint, "radioGroupSelectItemBlueprint");
        Intrinsics.checkNotNullParameter(multiStateSwitcherItemBlueprint, "multiStateSwitcherItemBlueprint");
        Intrinsics.checkNotNullParameter(multiStateInputItemBlueprint, "multiStateInputItemBlueprint");
        Intrinsics.checkNotNullParameter(multiStatePhotoItemBlueprint, "multiStatePhotoItemBlueprint");
        Intrinsics.checkNotNullParameter(dateIntervalItemBlueprint, "dateIntervalItemBlueprint");
        Intrinsics.checkNotNullParameter(editCategoryItemBlueprint, "editCategoryItemBlueprint");
        Intrinsics.checkNotNullParameter(multiselectItemBlueprint, "multiselectItemBlueprint");
        Intrinsics.checkNotNullParameter(multiStateObjectsItemBlueprint, "multiStateObjectsItemBlueprint");
        Intrinsics.checkNotNullParameter(buttonItemBlueprint, "buttonItemBlueprint");
        Intrinsics.checkNotNullParameter(multiStateInputWithTagsItemBlueprint, "taggedItemBlueprint");
        Intrinsics.checkNotNullParameter(noCarSlotBlueprint, "noCarSlotBlueprint");
        Intrinsics.checkNotNullParameter(cpaTariffSlotBlueprint, "cpaTariffSlotBlueprint");
        Intrinsics.checkNotNullParameter(userInfoItemBlueprint, "userInfoItemBlueprint");
        Intrinsics.checkNotNullParameter(limitsInfoItemBlueprint, "limitsInfoItemBlueprint");
        Intrinsics.checkNotNullParameter(disclaimerBlueprint, "disclaimerBlueprint");
        Intrinsics.checkNotNullParameter(marketPriceBlueprint, "marketPriceBlueprint");
        Intrinsics.checkNotNullParameter(marketPriceV2Blueprint, "marketPriceV2Blueprint");
        Intrinsics.checkNotNullParameter(creRangeItemBlueprint, "creRangeBlueprint");
        Intrinsics.checkNotNullParameter(vehicleRegNumberInputItemBlueprint, "vehicleRegNumberInputItemBlueprint");
        Intrinsics.checkNotNullParameter(videoItemBlueprint, "videoItemBlueprint");
        Intrinsics.checkNotNullParameter(linkSlotBlueprint, "linkSlotBlueprint");
        Intrinsics.checkNotNullParameter(headerWithDividerItemBlueprint, "headerWithDividerBlueprint");
        Intrinsics.checkNotNullParameter(informationWithUserIdBlueprint, "informationWithUserIdSlotBlueprint");
        Intrinsics.checkNotNullParameter(chipsMultiselectItemBlueprint, "chipsMultiselectItemBlueprint");
        Intrinsics.checkNotNullParameter(features, "features");
        return new ItemBinder.Builder().registerItem(chipsSelectItemBlueprint).registerItem(radioGroupSelectItemBlueprint).registerItem(multiStateSelectItemBlueprint).registerItem(multiStateSwitcherItemBlueprint).registerItem(multiStateInputItemBlueprint).registerItem(multiStatePhotoItemBlueprint).registerItem(dateIntervalItemBlueprint).registerItem(editCategoryItemBlueprint).registerItem(multiselectItemBlueprint).registerItem(multiStateObjectsItemBlueprint).registerItem(buttonItemBlueprint).registerItem(multiStateInputWithTagsItemBlueprint).registerItem(noCarSlotBlueprint).registerItem(cpaTariffSlotBlueprint).registerItem(userInfoItemBlueprint).registerItem(limitsInfoItemBlueprint).registerItem(disclaimerBlueprint).registerItem(marketPriceBlueprint).registerItem(marketPriceV2Blueprint).registerItem(creRangeItemBlueprint).registerItem(vehicleRegNumberInputItemBlueprint).registerItem(videoItemBlueprint).registerItem(linkSlotBlueprint).registerItem(headerWithDividerItemBlueprint).registerItem(informationWithUserIdBlueprint).registerItem(chipsMultiselectItemBlueprint).build();
    }

    @Provides
    @NotNull
    @PerFragment
    public final Set<ItemPresenter<?, ?>> provideItemPresentersSet(@NotNull MultiStateSelectItemPresenter multiStateSelectItemPresenter, @NotNull ChipsSelectItemPresenter chipsSelectItemPresenter, @NotNull ChipsMultiselectItemPresenter chipsMultiselectItemPresenter, @NotNull RadioGroupSelectItemPresenter radioGroupSelectItemPresenter, @NotNull RdsMultiselectItemPresenter rdsMultiselectItemPresenter, @NotNull MultiStateSwitcherItemPresenter multiStateSwitcherItemPresenter, @NotNull MultiStateInputItemPresenter multiStateInputItemPresenter, @NotNull MultiStateObjectsItemPresenter multiStateObjectsItemPresenter, @NotNull MultiStateInputWithTagsItemPresenter multiStateInputWithTagsItemPresenter, @NotNull NoCarSlotItemPresenter noCarSlotItemPresenter, @NotNull EditCategoryItemPresenter editCategoryItemPresenter, @NotNull CreRangePresenter creRangePresenter, @NotNull VehicleRegNumberInputItemPresenter vehicleRegNumberInputItemPresenter, @NotNull VideoItemPresenter videoItemPresenter, @NotNull LinkSlotItemPresenter linkSlotItemPresenter, @NotNull MarketPriceV2Presenter marketPriceV2Presenter, @NotNull LimitsInfoItemPresenter limitsInfoItemPresenter, @NotNull CpaTariffSlotItemPresenter cpaTariffSlotItemPresenter) {
        Intrinsics.checkNotNullParameter(multiStateSelectItemPresenter, "multiStateSelectPresenter");
        Intrinsics.checkNotNullParameter(chipsSelectItemPresenter, "chipsSelectItemPresenter");
        Intrinsics.checkNotNullParameter(chipsMultiselectItemPresenter, "chipsMultiselectItemPresenter");
        Intrinsics.checkNotNullParameter(radioGroupSelectItemPresenter, "radioGroupSelectItemPresenter");
        Intrinsics.checkNotNullParameter(rdsMultiselectItemPresenter, "multiSelectItemPresenter");
        Intrinsics.checkNotNullParameter(multiStateSwitcherItemPresenter, "multiStateSwitcherItemPresenter");
        Intrinsics.checkNotNullParameter(multiStateInputItemPresenter, "multiStateInputItemPresenter");
        Intrinsics.checkNotNullParameter(multiStateObjectsItemPresenter, "multiStateObjectsItemPresenter");
        Intrinsics.checkNotNullParameter(multiStateInputWithTagsItemPresenter, "taggedInputItemPresenter");
        Intrinsics.checkNotNullParameter(noCarSlotItemPresenter, "infoNoCarItemPresenter");
        Intrinsics.checkNotNullParameter(editCategoryItemPresenter, "editCategoryItemPresenter");
        Intrinsics.checkNotNullParameter(creRangePresenter, "creRangePresenter");
        Intrinsics.checkNotNullParameter(vehicleRegNumberInputItemPresenter, "vehicleRegNumberPresenter");
        Intrinsics.checkNotNullParameter(videoItemPresenter, "videoItemPresenter");
        Intrinsics.checkNotNullParameter(linkSlotItemPresenter, "linkSlotItemPresenter");
        Intrinsics.checkNotNullParameter(marketPriceV2Presenter, "marketPriceV2ItemPresenter");
        Intrinsics.checkNotNullParameter(limitsInfoItemPresenter, "limitsInfoItemPresenter");
        Intrinsics.checkNotNullParameter(cpaTariffSlotItemPresenter, "cpaTariffSlotItemPresenter");
        return y.setOf((Object[]) new ItemPresenter[]{multiStateSelectItemPresenter, chipsSelectItemPresenter, radioGroupSelectItemPresenter, rdsMultiselectItemPresenter, multiStateSwitcherItemPresenter, multiStateInputItemPresenter, multiStateObjectsItemPresenter, multiStateInputWithTagsItemPresenter, noCarSlotItemPresenter, editCategoryItemPresenter, creRangePresenter, vehicleRegNumberInputItemPresenter, videoItemPresenter, linkSlotItemPresenter, chipsMultiselectItemPresenter, marketPriceV2Presenter, limitsInfoItemPresenter, cpaTariffSlotItemPresenter});
    }

    @Provides
    @PerFragment
    @NotNull
    public final LinkSlotBlueprint provideLinkSlotBlueprint(@NotNull LinkSlotItemPresenter linkSlotItemPresenter) {
        Intrinsics.checkNotNullParameter(linkSlotItemPresenter, "presenter");
        return new LinkSlotBlueprint(linkSlotItemPresenter);
    }

    @Provides
    @PerFragment
    @NotNull
    public final LinkSlotItemPresenter provideLinkSlotPresenter(@NotNull AttributedTextFormatter attributedTextFormatter) {
        Intrinsics.checkNotNullParameter(attributedTextFormatter, "attributedTextFormatter");
        return new LinkSlotItemPresenterImpl(attributedTextFormatter);
    }

    @Provides
    @PerFragment
    @NotNull
    public final MultiStatePhotoItemPresenter provideMultiStatePhotoItemPresenter(@NotNull ImageListPresenter imageListPresenter, @NotNull AttributedTextFormatter attributedTextFormatter, @NotNull PhotoViewResourceProvider photoViewResourceProvider) {
        Intrinsics.checkNotNullParameter(imageListPresenter, "imageListPresenter");
        Intrinsics.checkNotNullParameter(attributedTextFormatter, "attributedTextFormatter");
        Intrinsics.checkNotNullParameter(photoViewResourceProvider, "resourcesProvider");
        return new MultiStatePhotoItemPresenterImpl(imageListPresenter, attributedTextFormatter, photoViewResourceProvider);
    }

    @Provides
    @PerFragment
    @NotNull
    public final MultiselectItemBlueprint provideMultiselectItemBlueprint(@NotNull RdsMultiselectItemPresenter rdsMultiselectItemPresenter) {
        Intrinsics.checkNotNullParameter(rdsMultiselectItemPresenter, "presenter");
        return new MultiselectItemBlueprint(rdsMultiselectItemPresenter);
    }

    @Provides
    @PerFragment
    @NotNull
    public final RdsMultiselectItemPresenter provideMultiselectItemPresenter(@NotNull AttributedTextFormatter attributedTextFormatter) {
        Intrinsics.checkNotNullParameter(attributedTextFormatter, "attributedTextFormatter");
        return new RdsMultiselectItemPresenterImpl(attributedTextFormatter);
    }

    @Provides
    @PerFragment
    @NotNull
    public final NoCarSlotBlueprint provideNoCarSlotBlueprint(@NotNull NoCarSlotItemPresenter noCarSlotItemPresenter) {
        Intrinsics.checkNotNullParameter(noCarSlotItemPresenter, "presenter");
        return new NoCarSlotBlueprint(noCarSlotItemPresenter);
    }

    @Provides
    @PerFragment
    @NotNull
    public final NoCarSlotItemPresenter provideNoCarSlotPresenter() {
        return new NoCarSlotItemPresenterImpl();
    }

    @Provides
    @PerFragment
    @NotNull
    public final MultiStateObjectsItemBlueprint provideObjectsItemBlueprint(@NotNull MultiStateObjectsItemPresenter multiStateObjectsItemPresenter) {
        Intrinsics.checkNotNullParameter(multiStateObjectsItemPresenter, "presenter");
        return new MultiStateObjectsItemBlueprint(multiStateObjectsItemPresenter);
    }

    @Provides
    @PerFragment
    @NotNull
    public final MultiStateObjectsItemPresenter provideObjectsItemPresenter() {
        return new MultiStateObjectsItemPresenterImpl();
    }

    @Provides
    @PerFragment
    @NotNull
    public final MultiStatePhotoItemBlueprint providePhotoItemBlueprint(@NotNull MultiStatePhotoItemPresenter multiStatePhotoItemPresenter) {
        Intrinsics.checkNotNullParameter(multiStatePhotoItemPresenter, "presenter");
        return new MultiStatePhotoItemBlueprint(multiStatePhotoItemPresenter);
    }

    @Provides
    @PerFragment
    @NotNull
    public final PhotoUploadObserver providePhotoObserver$publish_release(@NotNull PhotoUploadObserverImpl photoUploadObserverImpl) {
        Intrinsics.checkNotNullParameter(photoUploadObserverImpl, "observer");
        return photoUploadObserverImpl;
    }

    @Provides
    @PerFragment
    @NotNull
    public final PublishDetailsResourceProvider providePublishDetailsResourceProvider() {
        return new PublishDetailsResourceProvider(this.b);
    }

    @Provides
    @PerFragment
    @NotNull
    public final PublishTagsViewModel providePublishTagsViewModel(@NotNull PublishTagsViewModelFactory publishTagsViewModelFactory) {
        Intrinsics.checkNotNullParameter(publishTagsViewModelFactory, "factory");
        ViewModel viewModel = ViewModelProviders.of(this.f, publishTagsViewModelFactory).get(PublishTagsViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProviders.of(th…ctory).get(T::class.java)");
        return (PublishTagsViewModel) viewModel;
    }

    @Provides
    @PerFragment
    @NotNull
    public final MultiStateSelectItemBlueprint provideSelectItemBlueprint(@NotNull MultiStateSelectItemPresenter multiStateSelectItemPresenter) {
        Intrinsics.checkNotNullParameter(multiStateSelectItemPresenter, "presenter");
        return new MultiStateSelectItemBlueprint(multiStateSelectItemPresenter);
    }

    @Provides
    @PerFragment
    @NotNull
    public final MultiStateSelectItemPresenter provideSelectItemPresenter(@NotNull AttributedTextFormatter attributedTextFormatter) {
        Intrinsics.checkNotNullParameter(attributedTextFormatter, "attributedTextFormatter");
        return new MultiStateSelectItemPresenterImpl(attributedTextFormatter);
    }

    @Provides
    @NotNull
    @PerFragment
    public final SlotsFactory provideSlotsFactory(@NotNull ProfileSourceInteractor profileSourceInteractor, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull ProfileApi profileApi, @NotNull PublishApi publishApi, @NotNull PublishLimitsApi publishLimitsApi, @NotNull TypedErrorThrowableConverter typedErrorThrowableConverter, @NotNull AccountStorageInteractor accountStorageInteractor, @NotNull AttributedTextFormatter attributedTextFormatter, @NotNull CategoryParametersConverter categoryParametersConverter, @NotNull ContactsDataSource contactsDataSource, @NotNull PublishContactsStringProvider publishContactsStringProvider, @NotNull PublishAnalyticsDataProvider publishAnalyticsDataProvider, @NotNull Analytics analytics, @PhoneNumberFormatterModule.PhoneNumberFormatterWithCountryCode @NotNull Formatter<String> formatter, @NotNull SessionChangeTracker sessionChangeTracker, @NotNull Features features, @NotNull PublishDetailsTracker publishDetailsTracker, @NotNull PublishEventTracker publishEventTracker, @NotNull PublishLimitsEventTracker publishLimitsEventTracker) {
        Intrinsics.checkNotNullParameter(profileSourceInteractor, "profileSource");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(profileApi, "profileApi");
        Intrinsics.checkNotNullParameter(publishApi, "publishApi");
        Intrinsics.checkNotNullParameter(publishLimitsApi, "limitsApi");
        Intrinsics.checkNotNullParameter(typedErrorThrowableConverter, "throwableConverter");
        Intrinsics.checkNotNullParameter(accountStorageInteractor, "accountStorageInteractor");
        Intrinsics.checkNotNullParameter(attributedTextFormatter, "attributedTextFormatter");
        Intrinsics.checkNotNullParameter(categoryParametersConverter, "converter");
        Intrinsics.checkNotNullParameter(contactsDataSource, "contactDataSource");
        Intrinsics.checkNotNullParameter(publishContactsStringProvider, "contactsStringProvider");
        Intrinsics.checkNotNullParameter(publishAnalyticsDataProvider, "analyticsData");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(formatter, "phoneFormatter");
        Intrinsics.checkNotNullParameter(sessionChangeTracker, "sessionChangeTracker");
        Intrinsics.checkNotNullParameter(features, "features");
        Intrinsics.checkNotNullParameter(publishDetailsTracker, "performanceTracker");
        Intrinsics.checkNotNullParameter(publishEventTracker, "publishEventTracker");
        Intrinsics.checkNotNullParameter(publishLimitsEventTracker, "publishLimitsEventTracker");
        return new SlotsFactoryImpl(profileSourceInteractor, schedulersFactory3, profileApi, publishApi, publishLimitsApi, typedErrorThrowableConverter, accountStorageInteractor, attributedTextFormatter, categoryParametersConverter, contactsDataSource, publishContactsStringProvider, publishAnalyticsDataProvider, analytics, formatter, sessionChangeTracker, publishDetailsTracker, publishEventTracker, publishLimitsEventTracker, features);
    }

    @Provides
    @PerFragment
    @NotNull
    public final TagsViewModel provideTagsViewModel(@NotNull PublishTagsViewModel publishTagsViewModel) {
        Intrinsics.checkNotNullParameter(publishTagsViewModel, "tagsViewModel");
        return publishTagsViewModel;
    }

    @Provides
    @PerFragment
    @NotNull
    public final PublishTagsViewModelFactory provideTagsViewModelFactory(@NotNull PublishTagsInteractor publishTagsInteractor, @NotNull SchedulersFactory schedulersFactory) {
        Intrinsics.checkNotNullParameter(publishTagsInteractor, "tagsInteractor");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        return new PublishTagsViewModelFactory(publishTagsInteractor, schedulersFactory);
    }

    @Provides
    @PerFragment
    @NotNull
    public final UserInfoItemBlueprint provideUserInfoBlueprint(@NotNull UserInfoItemPresenter userInfoItemPresenter, @NotNull AvatarRenderer avatarRenderer) {
        Intrinsics.checkNotNullParameter(userInfoItemPresenter, "presenter");
        Intrinsics.checkNotNullParameter(avatarRenderer, "avatarRenderer");
        return new UserInfoItemBlueprint(userInfoItemPresenter, avatarRenderer);
    }

    @Provides
    @PerFragment
    @NotNull
    public final UserInfoItemPresenter provideUserInfoPresenter() {
        return new UserInfoItemPresenterImpl();
    }

    @Provides
    @PerFragment
    @NotNull
    public final ValidationLogger provideValidationLogger(@NotNull Analytics analytics, @NotNull PublishAnalyticsDataProvider publishAnalyticsDataProvider) {
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(publishAnalyticsDataProvider, "analyticsDataProvider");
        return new PublishValidationLogger(analytics, publishAnalyticsDataProvider);
    }
}
