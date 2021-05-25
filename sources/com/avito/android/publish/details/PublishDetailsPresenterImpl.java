package com.avito.android.publish.details;

import a2.a.a.e2.r.g0;
import a2.a.a.e2.r.h0;
import a2.a.a.e2.r.i0;
import a2.a.a.e2.r.j0;
import a2.a.a.e2.r.k0;
import a2.a.a.e2.r.l0;
import a2.a.a.e2.r.m0;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.MainThread;
import androidx.exifinterface.media.ExifInterface;
import com.avito.android.ab_tests.AbTestsConfigProvider;
import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import com.avito.android.blueprints.SelectedInfo;
import com.avito.android.blueprints.chips.ChipsSelectItemPresenter;
import com.avito.android.blueprints.chips_multiselect.ChipsMultiselectItemPresenter;
import com.avito.android.blueprints.input.MultiStateInputItemPresenter;
import com.avito.android.blueprints.publish.VehicleRegNumberInputItemPresenter;
import com.avito.android.blueprints.publish.tagged_input.MultiStateInputWithTagsItemPresenter;
import com.avito.android.blueprints.publish.tagged_input.SuggestRequest;
import com.avito.android.blueprints.radiogroup.RadioGroupSelectItemPresenter;
import com.avito.android.blueprints.select.MultiStateSelectItemPresenter;
import com.avito.android.blueprints.switcher.MultiStateSwitcherItemPresenter;
import com.avito.android.blueprints.video.VideoItemPresenter;
import com.avito.android.category_parameters.CategoryParametersElementConverter;
import com.avito.android.category_parameters.ParameterElement;
import com.avito.android.computer_vision.ComputerVisionInteractor;
import com.avito.android.deep_linking.links.AdvertPublicationLink;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.inline_filters.analytics.VerticalFilterCloseDialogEventKt;
import com.avito.android.item_legacy.details.ItemDetailsSelectResultHandler;
import com.avito.android.item_legacy.details.ParametersSource;
import com.avito.android.items.BasicInputItem;
import com.avito.android.items.CheckBoxItem;
import com.avito.android.items.ItemWithAdditionalButton;
import com.avito.android.items.ItemWithMotivation;
import com.avito.android.photo_picker.UploadingState;
import com.avito.android.photo_picker.legacy.UploadingProgressInteractor;
import com.avito.android.publish.PhotoUploadObserver;
import com.avito.android.publish.PublishState;
import com.avito.android.publish.PublishViewModel;
import com.avito.android.publish.analytics.PublishEventTracker;
import com.avito.android.publish.analytics.PublishInputsAnalyticTracker;
import com.avito.android.publish.details.PublishDetailsPresenter;
import com.avito.android.publish.details.PublishDetailsPresenterImpl;
import com.avito.android.publish.details.adapter.edit_category.EditCategoryItemPresenter;
import com.avito.android.publish.details.adapter.multiselect.RdsMultiselectItemPresenter;
import com.avito.android.publish.details.adapter.objects.MultiStateObjectsItemPresenter;
import com.avito.android.publish.details.analytics.PublishDetailsFlowTracker;
import com.avito.android.publish.details.tags.PublishTagsViewModel;
import com.avito.android.publish.slots.ConsumeValueChangeResult;
import com.avito.android.publish.slots.DeepLinkClicksStreamHolder;
import com.avito.android.publish.slots.ReactiveSlot;
import com.avito.android.publish.slots.SlotWrapper;
import com.avito.android.publish.slots.SlotsFactory;
import com.avito.android.publish.slots.contact_info.ContactInfoSlotWrapper;
import com.avito.android.publish.slots.contact_info.ContactsData;
import com.avito.android.publish.slots.cpa_tariff.item.CpaTariffSlotItem;
import com.avito.android.publish.slots.cpa_tariff.item.CpaTariffSlotItemPresenter;
import com.avito.android.publish.slots.link.item.LinkAlertParams;
import com.avito.android.publish.slots.link.item.LinkSlotItemPresenter;
import com.avito.android.publish.slots.market_price_v2.item.MarketPriceV2Presenter;
import com.avito.android.publish.slots.no_car.item.NoCarSlotItemPresenter;
import com.avito.android.publish.view.ItemDetailsParameterClickListener;
import com.avito.android.publish.view.ItemDetailsView;
import com.avito.android.publish_limits_info.item.LimitsInfoItemPresenter;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.ErrorResult;
import com.avito.android.remote.error.ErrorWithMessage;
import com.avito.android.remote.error.PhoneVerificationError;
import com.avito.android.remote.error.TypedError;
import com.avito.android.remote.model.ImageUpload;
import com.avito.android.remote.model.Navigation;
import com.avito.android.remote.model.ParamKeyValue;
import com.avito.android.remote.model.ParcelableEntity;
import com.avito.android.remote.model.PretendResult;
import com.avito.android.remote.model.category_parameters.AddressParameter;
import com.avito.android.remote.model.category_parameters.CategoryParameters;
import com.avito.android.remote.model.category_parameters.CategoryPublishStep;
import com.avito.android.remote.model.category_parameters.MultiselectParameter;
import com.avito.android.remote.model.category_parameters.ObjectsParameter;
import com.avito.android.remote.model.category_parameters.ParametersTree;
import com.avito.android.remote.model.category_parameters.PhoneParameter;
import com.avito.android.remote.model.category_parameters.PhotoParameter;
import com.avito.android.remote.model.category_parameters.SelectParameter;
import com.avito.android.remote.model.category_parameters.TextualTag;
import com.avito.android.remote.model.category_parameters.VideoParameter;
import com.avito.android.remote.model.category_parameters.base.BaseEditableParameter;
import com.avito.android.remote.model.category_parameters.base.CategoryParameter;
import com.avito.android.remote.model.category_parameters.base.EditableParameter;
import com.avito.android.remote.model.category_parameters.base.HasTags;
import com.avito.android.remote.model.category_parameters.base.ParameterSlot;
import com.avito.android.remote.model.category_parameters.slot.Slot;
import com.avito.android.remote.model.category_parameters.slot.SlotWithValue;
import com.avito.android.remote.model.category_parameters.slot.cpa_tariff.CpaButtonAction;
import com.avito.android.remote.model.category_parameters.slot.cpa_tariff.CpaTariffSlot;
import com.avito.android.remote.model.category_parameters.slot.cpa_tariff.CpaTariffSlotConfig;
import com.avito.android.remote.model.category_parameters.slot.residential_complex.ResidentialComplexSlot;
import com.avito.android.remote.model.category_parameters.slot.residential_complex.ResidentialComplexSlotConfig;
import com.avito.android.remote.model.category_parameters.slot.text_suggests.TextSuggestionsSlot;
import com.avito.android.remote.model.text.AttributedText;
import com.avito.android.select.SelectListener;
import com.avito.android.ui.widget.tagged_input.TagItem;
import com.avito.android.ui_components.R;
import com.avito.android.util.DeviceMetrics;
import com.avito.android.util.Formatter;
import com.avito.android.util.LoadingState;
import com.avito.android.util.Logs;
import com.avito.android.util.Maybies;
import com.avito.android.util.MultiStateLoading;
import com.avito.android.util.Observables;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.Singles;
import com.avito.android.util.Throwables;
import com.avito.android.validation.ParametersListPresenter;
import com.avito.android.validation.SubmissionListener;
import com.avito.conveyor_item.Item;
import com.avito.konveyor.blueprint.ItemPresenter;
import com.avito.konveyor.data_source.DataSource;
import com.facebook.appevents.integrity.IntegrityManager;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.rxkotlin.DisposableKt;
import io.reactivex.rxkotlin.SubscribersKt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt___SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.component.toolbar.OnboardingData;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t*\u0002\u0001\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u0002\u0012\b\u0010Õ\u0001\u001a\u00030Ò\u0001\u0012\b\u0010á\u0001\u001a\u00030Þ\u0001\u0012\b\u0010ï\u0001\u001a\u00030ì\u0001\u0012\b\u0010ó\u0001\u001a\u00030ð\u0001\u0012\b\u0010¹\u0001\u001a\u00030¶\u0001\u0012\u0007\u0010¿\u0001\u001a\u00020\u0004\u0012\b\u0010 \u0001\u001a\u00030\u0001\u0012\b\u0010®\u0001\u001a\u00030«\u0001\u0012\b\u0010²\u0001\u001a\u00030¯\u0001\u0012\b\u0010Ù\u0001\u001a\u00030Ö\u0001\u0012\b\u0010\u0001\u001a\u00030\u0001\u0012\b\u0010¤\u0001\u001a\u00030¡\u0001\u0012\u001d\u0010ª\u0001\u001a\u0018\u0012\u0013\u0012\u0011\u0012\u0002\b\u0003\u0012\u0002\b\u00030¦\u0001¢\u0006\u0003\b§\u00010¥\u0001\u0012\u0007\u0010\u0001\u001a\u00020*\u0012\u000e\u0010Ý\u0001\u001a\t\u0012\u0004\u0012\u0002080Ú\u0001\u0012\b\u0010\u0001\u001a\u00030\u0001\u0012\b\u0010å\u0001\u001a\u00030â\u0001\u0012\b\u0010Ã\u0001\u001a\u00030À\u0001\u0012\b\u0010\u0001\u001a\u00030\u0001\u0012\b\u0010é\u0001\u001a\u00030æ\u0001\u0012\b\u0010Ì\u0001\u001a\u00030Ê\u0001\u0012\b\u0010Ç\u0001\u001a\u00030Ä\u0001\u0012\u000b\b\u0002\u0010ö\u0001\u001a\u0004\u0018\u00010\u000e¢\u0006\u0006\b÷\u0001\u0010ø\u0001J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0015\u001a\u00020\u00072\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u001f\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001cH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u0011\u0010!\u001a\u0004\u0018\u00010 H\u0016¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020\u0007H\u0016¢\u0006\u0004\b#\u0010\u0012J\u000f\u0010$\u001a\u00020\u0007H\u0016¢\u0006\u0004\b$\u0010\u0012J\u000f\u0010%\u001a\u00020\u0007H\u0016¢\u0006\u0004\b%\u0010\u0012J\u000f\u0010&\u001a\u00020\u0007H\u0016¢\u0006\u0004\b&\u0010\u0012J\u0017\u0010(\u001a\u00020\u00072\u0006\u0010'\u001a\u00020\u001cH\u0016¢\u0006\u0004\b(\u0010)J\u0017\u0010,\u001a\u00020\u00072\u0006\u0010+\u001a\u00020*H\u0016¢\u0006\u0004\b,\u0010-J\u000f\u0010.\u001a\u00020\u0007H\u0016¢\u0006\u0004\b.\u0010\u0012J\u0011\u00100\u001a\u0004\u0018\u00010/H\u0016¢\u0006\u0004\b0\u00101J\u000f\u00103\u001a\u000202H\u0016¢\u0006\u0004\b3\u00104J\u0017\u00106\u001a\u00020\u00072\u0006\u00105\u001a\u00020/H\u0016¢\u0006\u0004\b6\u00107J#\u0010<\u001a\u00020\u00072\b\u00109\u001a\u0004\u0018\u0001082\b\u0010;\u001a\u0004\u0018\u00010:H\u0017¢\u0006\u0004\b<\u0010=J\u0019\u0010@\u001a\u00020\u00072\b\u0010?\u001a\u0004\u0018\u00010>H\u0016¢\u0006\u0004\b@\u0010AJ\u0017\u0010C\u001a\u00020\u00072\u0006\u0010B\u001a\u00020\u001cH\u0016¢\u0006\u0004\bC\u0010)J\u000f\u0010D\u001a\u00020\u001cH\u0016¢\u0006\u0004\bD\u0010EJ7\u0010L\u001a\u00020\u00072\b\u0010F\u001a\u0004\u0018\u0001082\u0006\u0010G\u001a\u00020\u001c2\u0006\u0010H\u001a\u00020\u001c2\f\u0010K\u001a\b\u0012\u0004\u0012\u00020J0IH\u0016¢\u0006\u0004\bL\u0010MJ\u0017\u0010O\u001a\u00020\u00072\u0006\u0010N\u001a\u000208H\u0016¢\u0006\u0004\bO\u0010PJ\u0017\u0010S\u001a\u00020\u00072\u0006\u0010R\u001a\u00020QH\u0016¢\u0006\u0004\bS\u0010TJ\u0018\u0010V\u001a\u00020\u00072\u0006\u0010U\u001a\u00020\u0003H\u0001¢\u0006\u0004\bV\u0010WJ\u0018\u0010Y\u001a\u00020\u00072\u0006\u0010X\u001a\u00020\u0002H\u0001¢\u0006\u0004\bY\u0010ZJ\u001a\u0010[\u001a\u00020\u00072\b\u0010?\u001a\u0004\u0018\u00010>H\u0001¢\u0006\u0004\b[\u0010AJ\u0018\u0010]\u001a\u00020\u00072\u0006\u0010\\\u001a\u000208H\u0001¢\u0006\u0004\b]\u0010PJ\u0018\u0010`\u001a\u00020\u00072\u0006\u0010_\u001a\u00020^H\u0001¢\u0006\u0004\b`\u0010aJ6\u0010f\u001a\u00020\u00072\u0006\u0010\\\u001a\u0002082\u0012\u0010d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002080c0b2\b\u0010e\u001a\u0004\u0018\u000108H\u0001¢\u0006\u0004\bf\u0010gJ\u001d\u0010k\u001a\u00020\u00072\f\u0010j\u001a\b\u0012\u0004\u0012\u00020i0hH\u0002¢\u0006\u0004\bk\u0010lJ\u001d\u0010o\u001a\u00020\u00072\f\u0010n\u001a\b\u0012\u0004\u0012\u00020m0hH\u0002¢\u0006\u0004\bo\u0010lJ\u0017\u0010p\u001a\u00020\u00072\u0006\u0010F\u001a\u000208H\u0002¢\u0006\u0004\bp\u0010PJ\u001d\u0010s\u001a\u00020\u00072\f\u0010r\u001a\b\u0012\u0004\u0012\u00020\u00070qH\u0002¢\u0006\u0004\bs\u0010tJ\u001d\u0010u\u001a\u00020\u00072\f\u0010r\u001a\b\u0012\u0004\u0012\u00020\u00070qH\u0002¢\u0006\u0004\bu\u0010tJ\u000f\u0010v\u001a\u00020\u001cH\u0002¢\u0006\u0004\bv\u0010EJC\u0010x\u001a\u00020\u00072\u0006\u0010w\u001a\u0002022\n\b\u0002\u0010F\u001a\u0004\u0018\u0001082\b\b\u0002\u0010G\u001a\u00020\u001c2\u0006\u0010H\u001a\u00020\u001c2\f\u0010K\u001a\b\u0012\u0004\u0012\u00020J0IH\u0002¢\u0006\u0004\bx\u0010yJ-\u0010{\u001a\b\u0012\u0004\u0012\u00020z0b2\u0006\u0010w\u001a\u0002022\u000e\u0010K\u001a\n\u0012\u0006\b\u0001\u0012\u00020J0IH\u0002¢\u0006\u0004\b{\u0010|J#\u0010}\u001a\u00020\u00072\u0012\u0010K\u001a\n\u0012\u0006\b\u0001\u0012\u00020J0I\"\u00020JH\u0002¢\u0006\u0004\b}\u0010~J \u0010\u0001\u001a\u00020\u00072\f\u0010\u001a\b\u0012\u0004\u0012\u00020z0bH\u0002¢\u0006\u0006\b\u0001\u0010\u0001J\u0016\u0010\u0001\u001a\u00020\u0007*\u00020\u001aH\u0002¢\u0006\u0006\b\u0001\u0010\u0001J\u0011\u0010\u0001\u001a\u00020\u0007H\u0002¢\u0006\u0005\b\u0001\u0010\u0012J\u0011\u0010\u0001\u001a\u00020\u0007H\u0002¢\u0006\u0005\b\u0001\u0010\u0012J\u0011\u0010\u0001\u001a\u00020\u0007H\u0002¢\u0006\u0005\b\u0001\u0010\u0012R\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u0019\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b}\u0010\u0001R\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\bk\u0010\u0001R\u0019\u0010\u0001\u001a\u00020*8\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u0019\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\bp\u0010\u0001R\u0019\u0010\u0001\u001a\u00020*8\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u0018\u0010\u000b\u001a\u00020\n8\u0002@\u0002X.¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001a\u0010 \u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001a\u0010¤\u0001\u001a\u00030¡\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b¢\u0001\u0010£\u0001R/\u0010ª\u0001\u001a\u0018\u0012\u0013\u0012\u0011\u0012\u0002\b\u0003\u0012\u0002\b\u00030¦\u0001¢\u0006\u0003\b§\u00010¥\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b¨\u0001\u0010©\u0001R\u001a\u0010®\u0001\u001a\u00030«\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b¬\u0001\u0010­\u0001R\u001a\u0010²\u0001\u001a\u00030¯\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b°\u0001\u0010±\u0001R\u0019\u0010µ\u0001\u001a\u00030³\u00018\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\bu\u0010´\u0001R\u001a\u0010¹\u0001\u001a\u00030¶\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b·\u0001\u0010¸\u0001R-\u0010¼\u0001\u001a\u0017\u0012\u0012\u0012\u0010\u0012\u000b\b\u0001\u0012\u0007\u0012\u0002\b\u00030»\u00010º\u00010¥\u00018\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\bs\u0010©\u0001R\u0019\u0010¿\u0001\u001a\u00020\u00048\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b½\u0001\u0010¾\u0001R\u001a\u0010Ã\u0001\u001a\u00030À\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bÁ\u0001\u0010Â\u0001R\u001a\u0010Ç\u0001\u001a\u00030Ä\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bÅ\u0001\u0010Æ\u0001R\u001a\u0010É\u0001\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\bo\u0010È\u0001R\u001a\u0010Ì\u0001\u001a\u00030Ê\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010Ë\u0001R\u001b\u0010Ï\u0001\u001a\u0005\u0018\u00010Í\u00018\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\bx\u0010Î\u0001R\u0019\u0010Ñ\u0001\u001a\u00020\u001c8\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0001\u0010Ð\u0001R\u001a\u0010Õ\u0001\u001a\u00030Ò\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bÓ\u0001\u0010Ô\u0001R\u001a\u0010Ù\u0001\u001a\u00030Ö\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b×\u0001\u0010Ø\u0001R \u0010Ý\u0001\u001a\t\u0012\u0004\u0012\u0002080Ú\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bÛ\u0001\u0010Ü\u0001R\u001a\u0010á\u0001\u001a\u00030Þ\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bß\u0001\u0010à\u0001R\u001a\u0010å\u0001\u001a\u00030â\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bã\u0001\u0010ä\u0001R\u001a\u0010é\u0001\u001a\u00030æ\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bç\u0001\u0010è\u0001R\u0019\u0010ê\u0001\u001a\u00020*8\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u0019\u0010ë\u0001\u001a\u00020\u001c8\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0001\u0010Ð\u0001R\u001a\u0010ï\u0001\u001a\u00030ì\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bí\u0001\u0010î\u0001R\u001a\u0010ó\u0001\u001a\u00030ð\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bñ\u0001\u0010ò\u0001R\u0019\u0010ô\u0001\u001a\u00030³\u00018\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\bv\u0010´\u0001R\u0017\u0010\u0006\u001a\u00020\u00058\u0002@\u0002X.¢\u0006\u0007\n\u0005\b{\u0010õ\u0001¨\u0006ù\u0001"}, d2 = {"Lcom/avito/android/publish/details/PublishDetailsPresenterImpl;", "Lcom/avito/android/publish/details/PublishDetailsPresenter;", "Lcom/avito/android/item_legacy/details/ItemDetailsSelectResultHandler$ResultListener;", "Lcom/avito/android/item_legacy/details/ParametersSource;", "Lcom/avito/android/item_legacy/details/ItemDetailsSelectResultHandler;", "Lcom/avito/android/publish/PublishViewModel;", "publishViewModel", "", "setPublishViewModel", "(Lcom/avito/android/publish/PublishViewModel;)V", "Lcom/avito/android/publish/details/tags/PublishTagsViewModel;", "tagsViewModel", "setTagsViewModel", "(Lcom/avito/android/publish/details/tags/PublishTagsViewModel;)V", "Landroid/os/Bundle;", "onSaveState", "()Landroid/os/Bundle;", "onRetryClick", "()V", "Lcom/avito/android/publish/details/PublishDetailsRouter;", "router", "attachPublishRouter", "(Lcom/avito/android/publish/details/PublishDetailsRouter;)V", "Lcom/avito/android/publish/details/PublishDetailsPresenter$Router;", "attachRouter", "(Lcom/avito/android/publish/details/PublishDetailsPresenter$Router;)V", "Lcom/avito/android/publish/view/ItemDetailsView;", "view", "", "isFirstTime", "attachView", "(Lcom/avito/android/publish/view/ItemDetailsView;Z)V", "Lcom/avito/android/remote/model/category_parameters/PhotoParameter;", "getPhotoParameter", "()Lcom/avito/android/remote/model/category_parameters/PhotoParameter;", "detachView", "detachRouter", "detachPublishRouter", "onDestroy", "isImmediatelyCancel", "onCancelClicked", "(Z)V", "", "resultCode", "onAuthResult", "(I)V", "onMainButtonClicked", "Lcom/avito/android/remote/model/category_parameters/CategoryParameters;", "getCategoryParameters", "()Lcom/avito/android/remote/model/category_parameters/CategoryParameters;", "Lcom/avito/android/remote/model/category_parameters/ParametersTree;", "getParametersTree", "()Lcom/avito/android/remote/model/category_parameters/ParametersTree;", "params", "onResultHandled", "(Lcom/avito/android/remote/model/category_parameters/CategoryParameters;)V", "", "updatesFormForParamId", "Lcom/avito/android/remote/model/category_parameters/base/ParameterSlot;", "param", "onParametersUpdated", "(Ljava/lang/String;Lcom/avito/android/remote/model/category_parameters/base/ParameterSlot;)V", "Lcom/avito/android/remote/model/category_parameters/AddressParameter$Value;", IntegrityManager.INTEGRITY_TYPE_ADDRESS, "onUpdateAddress", "(Lcom/avito/android/remote/model/category_parameters/AddressParameter$Value;)V", "keyboardVisible", "handleKeyboard", "enableComputerVisionIfNeeded", "()Z", "updatedParamId", "isPrevalidationRequired", "scrollToErrors", "", "Lcom/avito/android/publish/details/analytics/PublishDetailsFlowTracker$FlowContext;", "flowContext", "showParameters", "(Ljava/lang/String;ZZ[Lcom/avito/android/publish/details/analytics/PublishDetailsFlowTracker$FlowContext;)V", "id", "onItemButtonClicked", "(Ljava/lang/String;)V", "Lcom/avito/android/remote/model/category_parameters/SelectParameter$Value;", "value", "onResidentialComplexResult", "(Lcom/avito/android/remote/model/category_parameters/SelectParameter$Value;)V", "parametersSource", "attachParametersSource", "(Lcom/avito/android/item_legacy/details/ParametersSource;)V", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "attachResultListener", "(Lcom/avito/android/item_legacy/details/ItemDetailsSelectResultHandler$ResultListener;)V", "onAddressParameterChanged", "requestId", "onCancel", "Lcom/avito/android/remote/model/category_parameters/ObjectsParameter;", "updatedParameter", "onObjectsParameterChanged", "(Lcom/avito/android/remote/model/category_parameters/ObjectsParameter;)V", "", "Lcom/avito/android/remote/model/ParcelableEntity;", "selectedItems", "sectionTitle", "onSelected", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "Lio/reactivex/Observable;", "Lcom/avito/android/items/BasicInputItem;", "valueChangesObservable", a2.g.r.g.a, "(Lio/reactivex/Observable;)V", "Lcom/avito/android/items/ItemWithAdditionalButton;", "additionalButtonClickObservable", "f", "n", "Lkotlin/Function0;", "callback", AuthSource.OPEN_CHANNEL_LIST, "(Lkotlin/jvm/functions/Function0;)V", AuthSource.BOOKING_ORDER, AuthSource.SEND_ABUSE, ScreenPublicConstsKt.CONTENT_TYPE_PUBLISH_PARAMETERS_INIT, "k", "(Lcom/avito/android/remote/model/category_parameters/ParametersTree;Ljava/lang/String;ZZ[Lcom/avito/android/publish/details/analytics/PublishDetailsFlowTracker$FlowContext;)V", "Lcom/avito/conveyor_item/Item;", "d", "(Lcom/avito/android/remote/model/category_parameters/ParametersTree;[Lcom/avito/android/publish/details/analytics/PublishDetailsFlowTracker$FlowContext;)Ljava/util/List;", "c", "([Lcom/avito/android/publish/details/analytics/PublishDetailsFlowTracker$FlowContext;)V", "items", "i", "(Ljava/util/List;)V", "j", "(Lcom/avito/android/publish/view/ItemDetailsView;)V", "e", "l", "h", "Lcom/avito/android/publish/slots/SlotsFactory;", "D", "Lcom/avito/android/publish/slots/SlotsFactory;", "slotsFactory", "Lcom/avito/android/publish/view/ItemDetailsView;", "Lcom/avito/android/publish/analytics/PublishInputsAnalyticTracker;", "y", "Lcom/avito/android/publish/analytics/PublishInputsAnalyticTracker;", "inputsAnalyticTracker", "Lcom/avito/android/publish/details/PublishDetailsPresenter$Router;", "I", "retriesWithWarningCount", "com/avito/android/publish/details/PublishDetailsPresenterImpl$deepLinkClickListener$1", "Lcom/avito/android/publish/details/PublishDetailsPresenterImpl$deepLinkClickListener$1;", "deepLinkClickListener", "B", "stepIndex", "Lcom/avito/android/computer_vision/ComputerVisionInteractor;", "G", "Lcom/avito/android/computer_vision/ComputerVisionInteractor;", "cvInteractor", "Lcom/avito/android/publish/details/tags/PublishTagsViewModel;", "Lcom/avito/android/publish/details/PhotoInteractorWrapper;", "u", "Lcom/avito/android/publish/details/PhotoInteractorWrapper;", "insertPhotoInteractor", "Lcom/avito/android/publish/analytics/PublishEventTracker;", "z", "Lcom/avito/android/publish/analytics/PublishEventTracker;", "publishEventTracker", "", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lkotlin/jvm/JvmSuppressWildcards;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Ljava/util/Set;", "itemPresenterSet", "Lcom/avito/android/photo_picker/legacy/UploadingProgressInteractor;", VKApiConst.VERSION, "Lcom/avito/android/photo_picker/legacy/UploadingProgressInteractor;", "uploadingProgressInteractor", "Lcom/avito/android/validation/SubmissionListener;", "w", "Lcom/avito/android/validation/SubmissionListener;", "submissionListener", "Lio/reactivex/disposables/CompositeDisposable;", "Lio/reactivex/disposables/CompositeDisposable;", "slotsDisposables", "Lcom/avito/android/publish/view/ItemDetailsParameterClickListener;", "s", "Lcom/avito/android/publish/view/ItemDetailsParameterClickListener;", "paramsClickListener", "Lcom/avito/android/publish/slots/SlotWrapper;", "Lcom/avito/android/remote/model/category_parameters/slot/Slot;", "slots", "t", "Lcom/avito/android/item_legacy/details/ItemDetailsSelectResultHandler;", "resultHandler", "Lcom/avito/android/publish/PhotoUploadObserver;", "F", "Lcom/avito/android/publish/PhotoUploadObserver;", "photoObserver", "Lcom/avito/android/publish/details/analytics/PublishDetailsFlowTracker;", "J", "Lcom/avito/android/publish/details/analytics/PublishDetailsFlowTracker;", "flowTracker", "Lcom/avito/android/publish/details/PublishDetailsRouter;", "publishRouter", "Lcom/avito/android/publish/details/ItemPostProcessor;", "Lcom/avito/android/publish/details/ItemPostProcessor;", "itemPostProcessor", "Lio/reactivex/disposables/Disposable;", "Lio/reactivex/disposables/Disposable;", "adapterDataChangesDisposable", "Z", "photosWereAdded", "Lcom/avito/android/publish/details/PublishDetailsInteractor;", "o", "Lcom/avito/android/publish/details/PublishDetailsInteractor;", "interactor", "Lcom/avito/android/validation/ParametersListPresenter;", "x", "Lcom/avito/android/validation/ParametersListPresenter;", "paramsListPresenter", "Lcom/avito/android/util/Formatter;", "C", "Lcom/avito/android/util/Formatter;", "phoneFormatter", "Lcom/avito/android/util/SchedulersFactory;", "p", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Lcom/avito/android/util/DeviceMetrics;", ExifInterface.LONGITUDE_EAST, "Lcom/avito/android/util/DeviceMetrics;", "deviceMetrics", "Lcom/avito/android/ab_tests/AbTestsConfigProvider;", "H", "Lcom/avito/android/ab_tests/AbTestsConfigProvider;", "testsConfigProvider", "notificationItemIndex", "asyncScrollToNotification", "Lcom/avito/android/publish/details/PublishDetailsResourceProvider;", VKApiConst.Q, "Lcom/avito/android/publish/details/PublishDetailsResourceProvider;", "resourceProvider", "Lcom/avito/android/category_parameters/CategoryParametersElementConverter;", "r", "Lcom/avito/android/category_parameters/CategoryParametersElementConverter;", "elementConverter", "disposables", "Lcom/avito/android/publish/PublishViewModel;", "savedState", "<init>", "(Lcom/avito/android/publish/details/PublishDetailsInteractor;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/publish/details/PublishDetailsResourceProvider;Lcom/avito/android/category_parameters/CategoryParametersElementConverter;Lcom/avito/android/publish/view/ItemDetailsParameterClickListener;Lcom/avito/android/item_legacy/details/ItemDetailsSelectResultHandler;Lcom/avito/android/publish/details/PhotoInteractorWrapper;Lcom/avito/android/photo_picker/legacy/UploadingProgressInteractor;Lcom/avito/android/validation/SubmissionListener;Lcom/avito/android/validation/ParametersListPresenter;Lcom/avito/android/publish/analytics/PublishInputsAnalyticTracker;Lcom/avito/android/publish/analytics/PublishEventTracker;Ljava/util/Set;ILcom/avito/android/util/Formatter;Lcom/avito/android/publish/slots/SlotsFactory;Lcom/avito/android/util/DeviceMetrics;Lcom/avito/android/publish/PhotoUploadObserver;Lcom/avito/android/computer_vision/ComputerVisionInteractor;Lcom/avito/android/ab_tests/AbTestsConfigProvider;Lcom/avito/android/publish/details/ItemPostProcessor;Lcom/avito/android/publish/details/analytics/PublishDetailsFlowTracker;Landroid/os/Bundle;)V", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class PublishDetailsPresenterImpl implements PublishDetailsPresenter, ItemDetailsSelectResultHandler.ResultListener, ParametersSource, ItemDetailsSelectResultHandler {
    public final Set<ItemPresenter<?, ?>> A;
    public final int B;
    public final Formatter<String> C;
    public final SlotsFactory D;
    public final DeviceMetrics E;
    public final PhotoUploadObserver F;
    public final ComputerVisionInteractor G;
    public final AbTestsConfigProvider H;
    public final ItemPostProcessor I;
    public final PublishDetailsFlowTracker J;
    public final CompositeDisposable a;
    public final CompositeDisposable b;
    public ItemDetailsView c;
    public PublishViewModel d;
    public PublishTagsViewModel e;
    public PublishDetailsRouter f;
    public PublishDetailsPresenter.Router g;
    public int h;
    public boolean i;
    public int j;
    public Disposable k;
    public boolean l;
    public Set<? extends SlotWrapper<? extends Slot<?>>> m;
    public final PublishDetailsPresenterImpl$deepLinkClickListener$1 n;
    public final PublishDetailsInteractor o;
    public final SchedulersFactory p;
    public final PublishDetailsResourceProvider q;
    public final CategoryParametersElementConverter r;
    public final ItemDetailsParameterClickListener s;
    public final ItemDetailsSelectResultHandler t;
    public final PhotoInteractorWrapper u;
    public final UploadingProgressInteractor v;
    public final SubmissionListener w;
    public final ParametersListPresenter x;
    public final PublishInputsAnalyticTracker y;
    public final PublishEventTracker z;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            CpaButtonAction.values();
            int[] iArr = new int[3];
            $EnumSwitchMapping$0 = iArr;
            CpaButtonAction cpaButtonAction = CpaButtonAction.SHOW_CPA_TARIFF_FORM;
            iArr[2] = 1;
            CpaButtonAction cpaButtonAction2 = CpaButtonAction.START_NEW_PUBLISH;
            iArr[1] = 2;
            CpaButtonAction cpaButtonAction3 = CpaButtonAction.SWITCH_TO_DEVELOPMENT;
            iArr[0] = 3;
        }
    }

    /* compiled from: java-style lambda group */
    public static final class a<T> implements Consumer<String> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        public a(int i, Object obj) {
            this.a = i;
            this.b = obj;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public final void accept(String str) {
            int i = this.a;
            if (i == 0) {
                String str2 = str;
                Intrinsics.checkNotNullExpressionValue(str2, "url");
                PublishDetailsPresenterImpl.access$handleUrl((PublishDetailsPresenterImpl) this.b, str2);
            } else if (i == 1) {
                String str3 = str;
                Intrinsics.checkNotNullExpressionValue(str3, "url");
                PublishDetailsPresenterImpl.access$handleUrl((PublishDetailsPresenterImpl) this.b, str3);
            } else if (i == 2) {
                String str4 = str;
                Intrinsics.checkNotNullExpressionValue(str4, "link");
                PublishDetailsPresenterImpl.access$onInfoSlotClick((PublishDetailsPresenterImpl) this.b, str4);
            } else {
                throw null;
            }
        }
    }

    public static final class a0<T> implements Consumer<Throwable> {
        public final /* synthetic */ PublishDetailsPresenterImpl a;

        public a0(PublishDetailsPresenterImpl publishDetailsPresenterImpl) {
            this.a = publishDetailsPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            TypedError typedError;
            Throwable th2 = th;
            String message = th2.getMessage();
            if (message == null) {
                message = "";
            }
            if (Throwables.isNetworkProblem(th2)) {
                typedError = new ErrorWithMessage.NetworkError(message);
            } else if (Throwables.isAuthProblem(th2)) {
                typedError = new TypedError.UnauthorizedError();
            } else {
                Intrinsics.checkNotNullExpressionValue(th2, "it");
                typedError = new ErrorWithMessage.Unknown(message, th2);
            }
            PublishDetailsPresenterImpl.access$handleError(this.a, typedError);
        }
    }

    /* compiled from: java-style lambda group */
    public static final class b<T> implements Consumer<Throwable> {
        public static final b b = new b(0);
        public static final b c = new b(1);
        public static final b d = new b(2);
        public static final b e = new b(3);
        public static final b f = new b(4);
        public static final b g = new b(5);
        public static final b h = new b(6);
        public static final b i = new b(7);
        public static final b j = new b(8);
        public static final b k = new b(9);
        public static final b l = new b(10);
        public static final b m = new b(11);
        public static final b n = new b(12);
        public static final b o = new b(13);
        public static final b p = new b(14);
        public final /* synthetic */ int a;

        public b(int i2) {
            this.a = i2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public final void accept(Throwable th) {
            switch (this.a) {
                case 0:
                    Logs.error("Failed to observe radiogroup select", th);
                    return;
                case 1:
                    Logs.error("Failed on objects item click", th);
                    return;
                case 2:
                    Logs.error("Failed on noCarSlotClickObservable", th);
                    return;
                case 3:
                    Logs.error("Failed on edit category item click", th);
                    return;
                case 4:
                    Logs.error("Failed on link alert event", th);
                    return;
                case 5:
                    Logs.error("Failed on deepLink click event", th);
                    return;
                case 6:
                    Logs.error("Failed on link click event", th);
                    return;
                case 7:
                    Logs.error("Failed on deepLink click event", th);
                    return;
                case 8:
                    Logs.error("Failed on deepLink click event", th);
                    return;
                case 9:
                    Logs.error("Failed on link click event", th);
                    return;
                case 10:
                    Logs.error("Failed on select click", th);
                    return;
                case 11:
                    Logs.error("Failed cpa notification slot button click event", th);
                    return;
                case 12:
                    Logs.error("Failed on multiselect click", th);
                    return;
                case 13:
                    Logs.error("Failed to observe chips select", th);
                    return;
                case 14:
                    Logs.error("Failed to observe chips multiselect", th);
                    return;
                default:
                    throw null;
            }
        }
    }

    public static final class b0 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ PublishDetailsPresenterImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b0(PublishDetailsPresenterImpl publishDetailsPresenterImpl) {
            super(0);
            this.a = publishDetailsPresenterImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            PublishDetailsPresenterImpl.access$startServerValidation(this.a);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: java-style lambda group */
    public static final class c<T> implements Consumer<DeepLink> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        public c(int i, Object obj) {
            this.a = i;
            this.b = obj;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public final void accept(DeepLink deepLink) {
            int i = this.a;
            if (i == 0) {
                DeepLink deepLink2 = deepLink;
                PublishDetailsPresenter.Router router = ((PublishDetailsPresenterImpl) this.b).g;
                if (router != null) {
                    Intrinsics.checkNotNullExpressionValue(deepLink2, "deepLink");
                    router.openDeepLink(deepLink2);
                }
            } else if (i == 1) {
                DeepLink deepLink3 = deepLink;
                PublishDetailsPresenter.Router router2 = ((PublishDetailsPresenterImpl) this.b).g;
                if (router2 != null) {
                    Intrinsics.checkNotNullExpressionValue(deepLink3, "deepLink");
                    router2.openDeepLink(deepLink3);
                }
            } else if (i == 2) {
                DeepLink deepLink4 = deepLink;
                PublishDetailsPresenter.Router router3 = ((PublishDetailsPresenterImpl) this.b).g;
                if (router3 != null) {
                    Intrinsics.checkNotNullExpressionValue(deepLink4, "deepLink");
                    router3.openDeepLink(deepLink4);
                }
            } else {
                throw null;
            }
        }
    }

    public static final class c0 extends Lambda implements Function1<UploadingState, Unit> {
        public final /* synthetic */ PublishDetailsPresenterImpl a;
        public final /* synthetic */ Function0 b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c0(PublishDetailsPresenterImpl publishDetailsPresenterImpl, Function0 function0) {
            super(1);
            this.a = publishDetailsPresenterImpl;
            this.b = function0;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(UploadingState uploadingState) {
            UploadingState uploadingState2 = uploadingState;
            PublishDetailsPresenterImpl publishDetailsPresenterImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(uploadingState2, "it");
            PublishDetailsPresenterImpl.access$processUploadingEvent(publishDetailsPresenterImpl, uploadingState2, this.b);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: java-style lambda group */
    public static final class d<T> implements Consumer<SelectedInfo> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        public d(int i, Object obj) {
            this.a = i;
            this.b = obj;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public final void accept(SelectedInfo selectedInfo) {
            int i = this.a;
            if (i == 0) {
                SelectedInfo selectedInfo2 = selectedInfo;
                Intrinsics.checkNotNullExpressionValue(selectedInfo2, "it");
                PublishDetailsPresenterImpl.access$onValueSelected((PublishDetailsPresenterImpl) this.b, selectedInfo2);
            } else if (i == 1) {
                SelectedInfo selectedInfo3 = selectedInfo;
                Intrinsics.checkNotNullExpressionValue(selectedInfo3, "it");
                PublishDetailsPresenterImpl.access$onValueSelected((PublishDetailsPresenterImpl) this.b, selectedInfo3);
            } else if (i == 2) {
                SelectedInfo selectedInfo4 = selectedInfo;
                Intrinsics.checkNotNullExpressionValue(selectedInfo4, "it");
                PublishDetailsPresenterImpl.access$onValueSelected((PublishDetailsPresenterImpl) this.b, selectedInfo4);
            } else {
                throw null;
            }
        }
    }

    public static final class d0 extends Lambda implements Function1<Throwable, Unit> {
        public final /* synthetic */ PublishDetailsPresenterImpl a;
        public final /* synthetic */ PhotoParameter b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d0(PublishDetailsPresenterImpl publishDetailsPresenterImpl, PhotoParameter photoParameter) {
            super(1);
            this.a = publishDetailsPresenterImpl;
            this.b = photoParameter;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Throwable th) {
            Intrinsics.checkNotNullParameter(th, "it");
            PublishDetailsPresenterImpl.access$showPhotoUploadingError(this.a, this.b);
            return Unit.INSTANCE;
        }
    }

    public static final class e<T> implements Consumer<CpaTariffSlotItem> {
        public final /* synthetic */ PublishDetailsPresenterImpl a;

        public e(PublishDetailsPresenterImpl publishDetailsPresenterImpl) {
            this.a = publishDetailsPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(CpaTariffSlotItem cpaTariffSlotItem) {
            CpaTariffSlotItem cpaTariffSlotItem2 = cpaTariffSlotItem;
            PublishDetailsPresenterImpl.access$handleCpaNotificationAction(this.a, cpaTariffSlotItem2.getButtonAction(), cpaTariffSlotItem2.getAttributesAndValues());
        }
    }

    public static final class e0<T> implements Consumer<MultiStateLoading<? super CategoryParameters>> {
        public final /* synthetic */ PublishDetailsPresenterImpl a;
        public final /* synthetic */ String b;

        public e0(PublishDetailsPresenterImpl publishDetailsPresenterImpl, String str) {
            this.a = publishDetailsPresenterImpl;
            this.b = str;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(MultiStateLoading<? super CategoryParameters> multiStateLoading) {
            MultiStateLoading<? super CategoryParameters> multiStateLoading2 = multiStateLoading;
            if (Intrinsics.areEqual(multiStateLoading2, MultiStateLoading.Loading.INSTANCE)) {
                ItemDetailsView itemDetailsView = this.a.c;
                if (itemDetailsView != null) {
                    itemDetailsView.showValidationProgress();
                }
            } else if (multiStateLoading2 instanceof MultiStateLoading.Loaded) {
                PublishDetailsPresenterImpl.access$updateSelectParameterIfRequired(this.a, this.b);
                ItemDetailsView itemDetailsView2 = this.a.c;
                if (itemDetailsView2 != null) {
                    itemDetailsView2.hideValidationProgress();
                }
                PublishDetailsPresenterImpl.access$replaceCurrentStructure(this.a, (CategoryParameters) ((MultiStateLoading.Loaded) multiStateLoading2).getData(), this.b);
                ItemDetailsView itemDetailsView3 = this.a.c;
                if (itemDetailsView3 != null) {
                    this.a.j(itemDetailsView3);
                }
            } else if (multiStateLoading2 instanceof MultiStateLoading.Error) {
                PublishDetailsPresenterImpl.access$handleErrorResult(this.a, ((MultiStateLoading.Error) multiStateLoading2).getError());
            }
        }
    }

    public static final class f<T> implements Consumer<ParameterElement.Select> {
        public final /* synthetic */ PublishDetailsPresenterImpl a;

        public f(PublishDetailsPresenterImpl publishDetailsPresenterImpl) {
            this.a = publishDetailsPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(ParameterElement.Select select) {
            ParameterElement.Select select2 = select;
            ItemDetailsParameterClickListener itemDetailsParameterClickListener = this.a.s;
            Intrinsics.checkNotNullExpressionValue(select2, "item");
            itemDetailsParameterClickListener.onElementClicked(select2);
        }
    }

    public static final class f0<T> implements Consumer<Throwable> {
        public static final f0 a = new f0();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            Logs.error("Failed to updateForm onError", th);
        }
    }

    public static final class g<T> implements Consumer<ParameterElement.Multiselect> {
        public final /* synthetic */ PublishDetailsPresenterImpl a;

        public g(PublishDetailsPresenterImpl publishDetailsPresenterImpl) {
            this.a = publishDetailsPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(ParameterElement.Multiselect multiselect) {
            ParameterElement.Multiselect multiselect2 = multiselect;
            ItemDetailsParameterClickListener itemDetailsParameterClickListener = this.a.s;
            Intrinsics.checkNotNullExpressionValue(multiselect2, "item");
            itemDetailsParameterClickListener.onElementClicked(multiselect2);
        }
    }

    public static final class h<T> implements Consumer<Pair<? extends ParameterElement.Objects, ? extends Integer>> {
        public final /* synthetic */ PublishDetailsPresenterImpl a;

        public h(PublishDetailsPresenterImpl publishDetailsPresenterImpl) {
            this.a = publishDetailsPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Pair<? extends ParameterElement.Objects, ? extends Integer> pair) {
            Pair<? extends ParameterElement.Objects, ? extends Integer> pair2 = pair;
            ParameterElement.Objects objects = (ParameterElement.Objects) pair2.component1();
            int intValue = ((Number) pair2.component2()).intValue();
            if (intValue == -1) {
                this.a.s.onAddMoreObjectsClicked(objects);
            } else {
                this.a.s.onElementObjectClicked(objects, intValue);
            }
        }
    }

    public static final class i<T> implements Consumer<ParameterElement.EditCategoryButton> {
        public final /* synthetic */ PublishDetailsPresenterImpl a;

        public i(PublishDetailsPresenterImpl publishDetailsPresenterImpl) {
            this.a = publishDetailsPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(ParameterElement.EditCategoryButton editCategoryButton) {
            ParameterElement.EditCategoryButton editCategoryButton2 = editCategoryButton;
            ItemDetailsParameterClickListener itemDetailsParameterClickListener = this.a.s;
            Intrinsics.checkNotNullExpressionValue(editCategoryButton2, "item");
            itemDetailsParameterClickListener.onElementClicked(editCategoryButton2);
        }
    }

    public static final class j<T> implements Consumer<LinkAlertParams> {
        public final /* synthetic */ PublishDetailsPresenterImpl a;

        public j(PublishDetailsPresenterImpl publishDetailsPresenterImpl) {
            this.a = publishDetailsPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(LinkAlertParams linkAlertParams) {
            LinkAlertParams linkAlertParams2 = linkAlertParams;
            PublishDetailsPresenterImpl publishDetailsPresenterImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(linkAlertParams2, "alert");
            PublishDetailsPresenterImpl.access$onShowAlertClick(publishDetailsPresenterImpl, linkAlertParams2);
        }
    }

    public static final class k<T> implements Consumer<Unit> {
        public final /* synthetic */ PublishDetailsPresenterImpl a;

        public k(PublishDetailsPresenterImpl publishDetailsPresenterImpl) {
            this.a = publishDetailsPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Unit unit) {
            this.a.c(PublishDetailsFlowTracker.FlowContext.POST_PROCESSING);
        }
    }

    public static final class l<T> implements Consumer<OnboardingData> {
        public final /* synthetic */ ItemDetailsView a;

        public l(ItemDetailsView itemDetailsView) {
            this.a = itemDetailsView;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(OnboardingData onboardingData) {
            OnboardingData onboardingData2 = onboardingData;
            ItemDetailsView itemDetailsView = this.a;
            Intrinsics.checkNotNullExpressionValue(onboardingData2, "it");
            itemDetailsView.showActionOnboarding(onboardingData2);
        }
    }

    public static final class m<T, R> implements Function<Object[], LoadingState<? super Unit>> {
        public static final m a = new m();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public LoadingState<? super Unit> apply(Object[] objArr) {
            Object[] objArr2 = objArr;
            Intrinsics.checkNotNullParameter(objArr2, "args");
            for (Object obj : objArr2) {
                if (obj instanceof LoadingState.Error) {
                    return (LoadingState) obj;
                }
            }
            return new LoadingState.Loaded(Unit.INSTANCE);
        }
    }

    public static final class n<T> implements Consumer<LoadingState<? super Unit>> {
        public final /* synthetic */ PublishDetailsPresenterImpl a;
        public final /* synthetic */ Function0 b;

        public n(PublishDetailsPresenterImpl publishDetailsPresenterImpl, Function0 function0) {
            this.a = publishDetailsPresenterImpl;
            this.b = function0;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(LoadingState<? super Unit> loadingState) {
            ItemDetailsView itemDetailsView;
            LoadingState<? super Unit> loadingState2 = loadingState;
            if (loadingState2 instanceof LoadingState.Loaded) {
                this.b.invoke();
            } else if (loadingState2 instanceof LoadingState.Error) {
                LoadingState.Error error = (LoadingState.Error) loadingState2;
                TypedError error2 = error.getError();
                if (error2 instanceof PhoneVerificationError) {
                    ContactsData contactsData = PublishDetailsPresenterImpl.access$getPublishViewModel$p(this.a).getContactsData();
                    PublishDetailsPresenter.Router router = this.a.g;
                    if (router != null) {
                        router.showPhoneVerificationScreen(new ContactInfoSlotWrapper.PhoneVerificationData(PublishDetailsPresenterImpl.access$getPhoneNumber(this.a), contactsData != null ? contactsData.getManager() : null, contactsData != null ? contactsData.isCompany() : false));
                    }
                } else if (error2 instanceof TypedError.PretendError) {
                    PublishViewModel access$getPublishViewModel$p = PublishDetailsPresenterImpl.access$getPublishViewModel$p(this.a);
                    TypedError error3 = error.getError();
                    Objects.requireNonNull(error3, "null cannot be cast to non-null type com.avito.android.remote.error.TypedError.PretendError");
                    access$getPublishViewModel$p.handleServerValidationErrors(((TypedError.PretendError) error3).getPretendResult().getErrors());
                } else if (error2 instanceof TypedError.ErrorMap) {
                    PublishDetailsPresenterImpl publishDetailsPresenterImpl = this.a;
                    TypedError error4 = error.getError();
                    Objects.requireNonNull(error4, "null cannot be cast to non-null type com.avito.android.remote.error.TypedError.ErrorMap");
                    PublishDetailsPresenterImpl.access$handleErrorMap(publishDetailsPresenterImpl, ((TypedError.ErrorMap) error4).getMessages());
                } else if (error2 instanceof TypedError.UnauthorizedError) {
                    PublishDetailsPresenter.Router router2 = this.a.g;
                    if (router2 != null) {
                        router2.navigateToAuth();
                    }
                } else if ((error2 instanceof ErrorWithMessage) && (itemDetailsView = this.a.c) != null) {
                    TypedError error5 = error.getError();
                    Objects.requireNonNull(error5, "null cannot be cast to non-null type com.avito.android.remote.error.ErrorWithMessage");
                    itemDetailsView.showError(((ErrorWithMessage) error5).getMessage());
                }
            }
        }
    }

    public static final class o<T> implements Consumer<Throwable> {
        public static final o a = new o();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            Logs.error(th);
        }
    }

    public static final class p extends Lambda implements Function0<Unit> {
        public final /* synthetic */ PublishDetailsPresenterImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public p(PublishDetailsPresenterImpl publishDetailsPresenterImpl) {
            super(0);
            this.a = publishDetailsPresenterImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            ItemDetailsView itemDetailsView = this.a.c;
            if (itemDetailsView != null) {
                itemDetailsView.hideKeyboard();
            }
            return Unit.INSTANCE;
        }
    }

    public static final class q<T> implements Consumer<ItemWithAdditionalButton> {
        public final /* synthetic */ PublishDetailsPresenterImpl a;

        public q(PublishDetailsPresenterImpl publishDetailsPresenterImpl) {
            this.a = publishDetailsPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(ItemWithAdditionalButton itemWithAdditionalButton) {
            String str;
            ItemWithAdditionalButton itemWithAdditionalButton2 = itemWithAdditionalButton;
            if (itemWithAdditionalButton2 instanceof ParameterElement.Video) {
                this.a.z.trackVideoInfoClicked();
            }
            PublishEventTracker publishEventTracker = this.a.z;
            ItemWithAdditionalButton.AdditionalButton additionalButton = itemWithAdditionalButton2.getAdditionalButton();
            if (additionalButton == null || (str = additionalButton.getLink()) == null) {
                str = "";
            }
            publishEventTracker.trackInfoLinkClickEvent(str);
            ItemDetailsParameterClickListener itemDetailsParameterClickListener = this.a.s;
            Intrinsics.checkNotNullExpressionValue(itemWithAdditionalButton2, "it");
            itemDetailsParameterClickListener.onInputAdditionalButtonClick(itemWithAdditionalButton2);
        }
    }

    public static final class r<T> implements Consumer<Throwable> {
        public static final r a = new r();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            Logs.error("Failed on observeInputAdditionalButtonClickStream", th);
        }
    }

    public static final class t<T> implements Consumer<Throwable> {
        public static final t a = new t();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            Logs.error("Failed on observeInputValueChanges", th);
        }
    }

    public static final class u<V> implements Callable<List<? extends Item>> {
        public final /* synthetic */ PublishDetailsPresenterImpl a;
        public final /* synthetic */ ParametersTree b;

        public u(PublishDetailsPresenterImpl publishDetailsPresenterImpl, ParametersTree parametersTree) {
            this.a = publishDetailsPresenterImpl;
            this.b = parametersTree;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.concurrent.Callable
        public List<? extends Item> call() {
            return this.a.d(this.b, new PublishDetailsFlowTracker.FlowContext[]{PublishDetailsFlowTracker.FlowContext.SUBMIT});
        }
    }

    public static final class v<T, R> implements Function<List<? extends Item>, SingleSource<? extends Pair<? extends SubmissionListener.SubmissionState, ? extends List<? extends Item>>>> {
        public final /* synthetic */ PublishDetailsPresenterImpl a;

        public v(PublishDetailsPresenterImpl publishDetailsPresenterImpl) {
            this.a = publishDetailsPresenterImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public SingleSource<? extends Pair<? extends SubmissionListener.SubmissionState, ? extends List<? extends Item>>> apply(List<? extends Item> list) {
            List<? extends Item> list2 = list;
            Intrinsics.checkNotNullParameter(list2, "items");
            return this.a.w.onSubmissionRequested(list2).map(new a2.a.a.e2.r.a0(list2));
        }
    }

    public static final class w extends Lambda implements Function1<Pair<? extends SubmissionListener.SubmissionState, ? extends List<? extends Item>>, Unit> {
        public final /* synthetic */ PublishDetailsPresenterImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public w(PublishDetailsPresenterImpl publishDetailsPresenterImpl) {
            super(1);
            this.a = publishDetailsPresenterImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Pair<? extends SubmissionListener.SubmissionState, ? extends List<? extends Item>> pair) {
            Pair<? extends SubmissionListener.SubmissionState, ? extends List<? extends Item>> pair2 = pair;
            SubmissionListener.SubmissionState submissionState = (SubmissionListener.SubmissionState) pair2.component1();
            List list = (List) pair2.component2();
            if (submissionState instanceof SubmissionListener.SubmissionState.Available) {
                this.a.m(new n4(0, this));
            } else if (submissionState instanceof SubmissionListener.SubmissionState.Unavailable) {
                SubmissionListener.SubmissionState.Unavailable unavailable = (SubmissionListener.SubmissionState.Unavailable) submissionState;
                if (unavailable.getHasWarningsOnFlowFinish() && this.a.h == 0) {
                    this.a.z.trackPublishInputError(unavailable.getFailures(), PublishDetailsPresenterImpl.access$getPublishViewModel$p(this.a).getNavigation());
                    PublishDetailsPresenterImpl publishDetailsPresenterImpl = this.a;
                    Intrinsics.checkNotNullExpressionValue(list, "items");
                    PublishDetailsPresenterImpl.access$handleWarningOnFlowFinish(publishDetailsPresenterImpl, list);
                } else if (!unavailable.getHasErrors()) {
                    this.a.m(new n4(1, this));
                } else {
                    this.a.z.trackPublishInputError(unavailable.getFailures(), PublishDetailsPresenterImpl.access$getPublishViewModel$p(this.a).getNavigation());
                    PublishDetailsPresenterImpl publishDetailsPresenterImpl2 = this.a;
                    Intrinsics.checkNotNullExpressionValue(list, "items");
                    publishDetailsPresenterImpl2.i(list);
                    ItemDetailsView itemDetailsView = this.a.c;
                    if (itemDetailsView != null) {
                        itemDetailsView.showError(this.a.q.getFixErrors());
                    }
                }
            }
            return Unit.INSTANCE;
        }
    }

    public static final class x extends Lambda implements Function1<SlotWrapper<? extends Slot<?>>, Boolean> {
        public static final x a = new x();

        public x() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Boolean invoke(SlotWrapper<? extends Slot<?>> slotWrapper) {
            SlotWrapper<? extends Slot<?>> slotWrapper2 = slotWrapper;
            Intrinsics.checkNotNullParameter(slotWrapper2, "it");
            return Boolean.valueOf(slotWrapper2.getSlot() instanceof SlotWithValue);
        }
    }

    public static final class y<T, R> implements Function<Object[], LoadingState<? super Unit>> {
        public static final y a = new y();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public LoadingState<? super Unit> apply(Object[] objArr) {
            Object[] objArr2 = objArr;
            Intrinsics.checkNotNullParameter(objArr2, "args");
            for (Object obj : objArr2) {
                if (obj instanceof LoadingState.Error) {
                    return (LoadingState) obj;
                }
            }
            return new LoadingState.Loaded(Unit.INSTANCE);
        }
    }

    public static final class z<T> implements Consumer<LoadingState<? super Unit>> {
        public final /* synthetic */ PublishDetailsPresenterImpl a;
        public final /* synthetic */ ParametersTree b;
        public final /* synthetic */ String c;
        public final /* synthetic */ boolean d;
        public final /* synthetic */ boolean e;
        public final /* synthetic */ PublishDetailsFlowTracker.FlowContext[] f;

        public z(PublishDetailsPresenterImpl publishDetailsPresenterImpl, ParametersTree parametersTree, String str, boolean z, boolean z2, PublishDetailsFlowTracker.FlowContext[] flowContextArr) {
            this.a = publishDetailsPresenterImpl;
            this.b = parametersTree;
            this.c = str;
            this.d = z;
            this.e = z2;
            this.f = flowContextArr;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(LoadingState<? super Unit> loadingState) {
            LoadingState<? super Unit> loadingState2 = loadingState;
            if (loadingState2 instanceof LoadingState.Loaded) {
                this.a.k(this.b, this.c, this.d, this.e, this.f);
            } else if (loadingState2 instanceof LoadingState.Error) {
                PublishDetailsPresenterImpl.access$handleError(this.a, ((LoadingState.Error) loadingState2).getError());
            }
        }
    }

    public PublishDetailsPresenterImpl(@NotNull PublishDetailsInteractor publishDetailsInteractor, @NotNull SchedulersFactory schedulersFactory, @NotNull PublishDetailsResourceProvider publishDetailsResourceProvider, @NotNull CategoryParametersElementConverter categoryParametersElementConverter, @NotNull ItemDetailsParameterClickListener itemDetailsParameterClickListener, @NotNull ItemDetailsSelectResultHandler itemDetailsSelectResultHandler, @NotNull PhotoInteractorWrapper photoInteractorWrapper, @NotNull UploadingProgressInteractor uploadingProgressInteractor, @NotNull SubmissionListener submissionListener, @NotNull ParametersListPresenter parametersListPresenter, @NotNull PublishInputsAnalyticTracker publishInputsAnalyticTracker, @NotNull PublishEventTracker publishEventTracker, @NotNull Set<ItemPresenter<?, ?>> set, int i2, @NotNull Formatter<String> formatter, @NotNull SlotsFactory slotsFactory, @NotNull DeviceMetrics deviceMetrics, @NotNull PhotoUploadObserver photoUploadObserver, @NotNull ComputerVisionInteractor computerVisionInteractor, @NotNull AbTestsConfigProvider abTestsConfigProvider, @NotNull ItemPostProcessor itemPostProcessor, @NotNull PublishDetailsFlowTracker publishDetailsFlowTracker, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(publishDetailsInteractor, "interactor");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(publishDetailsResourceProvider, "resourceProvider");
        Intrinsics.checkNotNullParameter(categoryParametersElementConverter, "elementConverter");
        Intrinsics.checkNotNullParameter(itemDetailsParameterClickListener, "paramsClickListener");
        Intrinsics.checkNotNullParameter(itemDetailsSelectResultHandler, "resultHandler");
        Intrinsics.checkNotNullParameter(photoInteractorWrapper, "insertPhotoInteractor");
        Intrinsics.checkNotNullParameter(uploadingProgressInteractor, "uploadingProgressInteractor");
        Intrinsics.checkNotNullParameter(submissionListener, "submissionListener");
        Intrinsics.checkNotNullParameter(parametersListPresenter, "paramsListPresenter");
        Intrinsics.checkNotNullParameter(publishInputsAnalyticTracker, "inputsAnalyticTracker");
        Intrinsics.checkNotNullParameter(publishEventTracker, "publishEventTracker");
        Intrinsics.checkNotNullParameter(set, "itemPresenterSet");
        Intrinsics.checkNotNullParameter(formatter, "phoneFormatter");
        Intrinsics.checkNotNullParameter(slotsFactory, "slotsFactory");
        Intrinsics.checkNotNullParameter(deviceMetrics, "deviceMetrics");
        Intrinsics.checkNotNullParameter(photoUploadObserver, "photoObserver");
        Intrinsics.checkNotNullParameter(computerVisionInteractor, "cvInteractor");
        Intrinsics.checkNotNullParameter(abTestsConfigProvider, "testsConfigProvider");
        Intrinsics.checkNotNullParameter(itemPostProcessor, "itemPostProcessor");
        Intrinsics.checkNotNullParameter(publishDetailsFlowTracker, "flowTracker");
        this.o = publishDetailsInteractor;
        this.p = schedulersFactory;
        this.q = publishDetailsResourceProvider;
        this.r = categoryParametersElementConverter;
        this.s = itemDetailsParameterClickListener;
        this.t = itemDetailsSelectResultHandler;
        this.u = photoInteractorWrapper;
        this.v = uploadingProgressInteractor;
        this.w = submissionListener;
        this.x = parametersListPresenter;
        this.y = publishInputsAnalyticTracker;
        this.z = publishEventTracker;
        this.A = set;
        this.B = i2;
        this.C = formatter;
        this.D = slotsFactory;
        this.E = deviceMetrics;
        this.F = photoUploadObserver;
        this.G = computerVisionInteractor;
        this.H = abTestsConfigProvider;
        this.I = itemPostProcessor;
        this.J = publishDetailsFlowTracker;
        this.a = new CompositeDisposable();
        this.b = new CompositeDisposable();
        boolean z2 = false;
        this.h = bundle != null ? bundle.getInt("retries_with_warnings_count") : 0;
        this.i = bundle != null ? bundle.getBoolean("key_photos_were_added") : z2;
        this.j = -1;
        this.m = new LinkedHashSet();
        this.n = new PublishDetailsPresenterImpl$deepLinkClickListener$1(this);
        itemDetailsParameterClickListener.setParametersSource(this);
        itemDetailsSelectResultHandler.attachParametersSource(this);
        itemDetailsSelectResultHandler.attachResultListener(this);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001c, code lost:
        if (r0.isEditing() != false) goto L_0x001e;
     */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0027  */
    /* JADX WARNING: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void access$addPhotos(com.avito.android.publish.details.PublishDetailsPresenterImpl r13, com.avito.android.remote.model.category_parameters.PhotoParameter r14) {
        /*
            com.avito.android.publish.PublishViewModel r0 = r13.d
            java.lang.String r1 = "publishViewModel"
            if (r0 != 0) goto L_0x0009
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
        L_0x0009:
            boolean r0 = r0.isRemoteDraft()
            r2 = 0
            r3 = 1
            if (r0 != 0) goto L_0x001e
            com.avito.android.publish.PublishViewModel r0 = r13.d
            if (r0 != 0) goto L_0x0018
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
        L_0x0018:
            boolean r0 = r0.isEditing()
            if (r0 == 0) goto L_0x0024
        L_0x001e:
            boolean r0 = r13.i
            if (r0 != 0) goto L_0x0024
            r0 = 1
            goto L_0x0025
        L_0x0024:
            r0 = 0
        L_0x0025:
            if (r0 == 0) goto L_0x00a5
            com.avito.android.publish.details.PhotoInteractorWrapper r0 = r13.u
            r0.deleteAll()
            java.lang.Object r0 = r14.getValue()
            com.avito.android.remote.model.category_parameters.PhotoParameter$ImageUploadListWrapper r0 = (com.avito.android.remote.model.category_parameters.PhotoParameter.ImageUploadListWrapper) r0
            if (r0 == 0) goto L_0x007d
            java.util.List r0 = r0.getOnlyUploaded()
            if (r0 == 0) goto L_0x007d
            java.util.Iterator r0 = r0.iterator()
        L_0x003e:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x007d
            java.lang.Object r1 = r0.next()
            int r4 = r2 + 1
            if (r2 >= 0) goto L_0x004f
            kotlin.collections.CollectionsKt__CollectionsKt.throwIndexOverflow()
        L_0x004f:
            com.avito.android.remote.model.ImageUploadResult r1 = (com.avito.android.remote.model.ImageUploadResult) r1
            com.avito.android.remote.model.Image r5 = r1.getImage()
            com.avito.android.util.DeviceMetrics r6 = r13.E
            int r6 = r6.getDisplayWidth()
            com.avito.android.util.DeviceMetrics r7 = r13.E
            int r7 = r7.getDisplayHeight()
            r8 = 0
            r9 = 1092616192(0x41200000, float:10.0)
            r10 = 0
            r11 = 20
            r12 = 0
            com.avito.android.util.ImageFitting r5 = com.avito.android.util.Images.fit$default(r5, r6, r7, r8, r9, r10, r11, r12)
            android.net.Uri r5 = r5.height()
            if (r5 == 0) goto L_0x007b
            com.avito.android.publish.details.PhotoInteractorWrapper r6 = r13.u
            java.lang.String r1 = r1.getUploadId()
            r6.add(r5, r2, r1)
        L_0x007b:
            r2 = r4
            goto L_0x003e
        L_0x007d:
            r13.i = r3
            java.lang.Object r0 = r14.getValue()
            com.avito.android.remote.model.category_parameters.PhotoParameter$ImageUploadListWrapper r0 = (com.avito.android.remote.model.category_parameters.PhotoParameter.ImageUploadListWrapper) r0
            if (r0 == 0) goto L_0x00a5
            boolean r0 = r0.isEmpty()
            if (r0 != r3) goto L_0x00a5
            io.reactivex.disposables.CompositeDisposable r0 = r13.a
            com.avito.android.validation.SubmissionListener r13 = r13.w
            java.lang.String r14 = r14.getId()
            io.reactivex.Completable r13 = r13.validateParameter(r14)
            io.reactivex.disposables.Disposable r13 = r13.subscribe()
            java.lang.String r14 = "submissionListener\n     …             .subscribe()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r13, r14)
            io.reactivex.rxkotlin.DisposableKt.plusAssign(r0, r13)
        L_0x00a5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.publish.details.PublishDetailsPresenterImpl.access$addPhotos(com.avito.android.publish.details.PublishDetailsPresenterImpl, com.avito.android.remote.model.category_parameters.PhotoParameter):void");
    }

    public static final List access$filterChangedParams(PublishDetailsPresenterImpl publishDetailsPresenterImpl, List list) {
        PublishViewModel publishViewModel = publishDetailsPresenterImpl.d;
        if (publishViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("publishViewModel");
        }
        PublishState state = publishViewModel.getState();
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (!state.getChangedFieldIds().contains(((ParamKeyValue) obj).getId())) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public static final String access$getPhoneNumber(PublishDetailsPresenterImpl publishDetailsPresenterImpl) {
        String format;
        PhoneParameter phoneParameter;
        PublishViewModel publishViewModel = publishDetailsPresenterImpl.d;
        if (publishViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("publishViewModel");
        }
        CategoryParameters categoryParameters = publishViewModel.getCategoryParameters();
        String str = (categoryParameters == null || (phoneParameter = (PhoneParameter) categoryParameters.getFirstParameterOfType(PhoneParameter.class)) == null) ? null : (String) phoneParameter.getValue();
        return (str == null || (format = publishDetailsPresenterImpl.C.format(str)) == null) ? "" : format;
    }

    public static final /* synthetic */ PublishViewModel access$getPublishViewModel$p(PublishDetailsPresenterImpl publishDetailsPresenterImpl) {
        PublishViewModel publishViewModel = publishDetailsPresenterImpl.d;
        if (publishViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("publishViewModel");
        }
        return publishViewModel;
    }

    public static final /* synthetic */ PublishTagsViewModel access$getTagsViewModel$p(PublishDetailsPresenterImpl publishDetailsPresenterImpl) {
        PublishTagsViewModel publishTagsViewModel = publishDetailsPresenterImpl.e;
        if (publishTagsViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tagsViewModel");
        }
        return publishTagsViewModel;
    }

    public static final void access$goToNextStep(PublishDetailsPresenterImpl publishDetailsPresenterImpl) {
        if (publishDetailsPresenterImpl.G.needRecognize()) {
            a2.a.a.e2.r.f fVar = new a2.a.a.e2.r.f(publishDetailsPresenterImpl);
            CompositeDisposable compositeDisposable = publishDetailsPresenterImpl.a;
            Observable<List<ParamKeyValue>> doOnSubscribe = publishDetailsPresenterImpl.G.recognitionResults().observeOn(publishDetailsPresenterImpl.p.mainThread()).doOnSubscribe(new a2.a.a.e2.r.f0(publishDetailsPresenterImpl));
            Intrinsics.checkNotNullExpressionValue(doOnSubscribe, "cvInteractor.recognition… { view?.showProgress() }");
            DisposableKt.plusAssign(compositeDisposable, SubscribersKt.subscribeBy$default(doOnSubscribe, new h0(fVar), (Function0) null, new g0(publishDetailsPresenterImpl, fVar), 2, (Object) null));
            return;
        }
        PublishViewModel publishViewModel = publishDetailsPresenterImpl.d;
        if (publishViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("publishViewModel");
        }
        PublishViewModel.goToNextStep$default(publishViewModel, null, 1, null);
    }

    public static final void access$handleCpaNotificationAction(PublishDetailsPresenterImpl publishDetailsPresenterImpl, CpaButtonAction cpaButtonAction, Map map) {
        List<Pair> list;
        publishDetailsPresenterImpl.z.trackCpaSlotButtonClicked(cpaButtonAction);
        if (cpaButtonAction != null) {
            int ordinal = cpaButtonAction.ordinal();
            if (ordinal != 0) {
                if (ordinal == 1) {
                    PublishDetailsPresenter.Router router = publishDetailsPresenterImpl.g;
                    if (router != null) {
                        router.openDeepLink(new AdvertPublicationLink(null, 1, null));
                    }
                } else if (ordinal == 2) {
                    PublishViewModel publishViewModel = publishDetailsPresenterImpl.d;
                    if (publishViewModel == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("publishViewModel");
                    }
                    Integer categoryId = publishViewModel.getNavigation().getCategoryId();
                    if (categoryId != null) {
                        int intValue = categoryId.intValue();
                        PublishDetailsPresenter.Router router2 = publishDetailsPresenterImpl.g;
                        if (router2 != null) {
                            router2.showCpaTariffRequestScreen(intValue);
                        }
                    }
                }
            } else if (map != null && (list = t6.n.s.toList(map)) != null) {
                for (Pair pair : list) {
                    PublishViewModel publishViewModel2 = publishDetailsPresenterImpl.d;
                    if (publishViewModel2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("publishViewModel");
                    }
                    CategoryParameters categoryParameters = publishViewModel2.getCategoryParameters();
                    ParameterSlot findParameter = categoryParameters != null ? categoryParameters.findParameter((String) pair.getFirst()) : null;
                    if (findParameter instanceof SelectParameter.Flat) {
                        ((SelectParameter.Flat) findParameter).setValue(pair.getSecond());
                    }
                }
                publishDetailsPresenterImpl.n((String) ((Pair) list.get(0)).getFirst());
            }
        }
    }

    public static final void access$handleError(PublishDetailsPresenterImpl publishDetailsPresenterImpl, TypedError typedError) {
        PublishDetailsPresenter.Router router;
        ItemDetailsView itemDetailsView = publishDetailsPresenterImpl.c;
        if (itemDetailsView != null) {
            itemDetailsView.hideValidationProgress();
        }
        ItemDetailsView itemDetailsView2 = publishDetailsPresenterImpl.c;
        if (itemDetailsView2 != null) {
            itemDetailsView2.showContent();
        }
        if (typedError instanceof ErrorWithMessage.NetworkError) {
            ItemDetailsView itemDetailsView3 = publishDetailsPresenterImpl.c;
            if (itemDetailsView3 != null) {
                itemDetailsView3.showRetry();
            }
        } else if (typedError instanceof ErrorWithMessage) {
            ItemDetailsView itemDetailsView4 = publishDetailsPresenterImpl.c;
            if (itemDetailsView4 != null) {
                itemDetailsView4.showRetry();
            }
        } else if ((typedError instanceof TypedError.UnauthorizedError) && (router = publishDetailsPresenterImpl.g) != null) {
            router.navigateToAuth();
        }
    }

    public static final void access$handleErrorMap(PublishDetailsPresenterImpl publishDetailsPresenterImpl, Map map) {
        CompositeDisposable compositeDisposable = publishDetailsPresenterImpl.a;
        Observable just = Observable.just(map);
        Intrinsics.checkNotNullExpressionValue(just, "Observable.just(this)");
        Disposable subscribe = just.flatMapIterable(a2.a.a.e2.r.g.a).toList().toObservable().observeOn(publishDetailsPresenterImpl.p.mainThread()).doOnComplete(new a2.a.a.e2.r.h(publishDetailsPresenterImpl)).subscribe(new a2.a.a.e2.r.i(publishDetailsPresenterImpl), a2.a.a.e2.r.j.a);
        Intrinsics.checkNotNullExpressionValue(subscribe, "errorMap.toSingletonObse…          }\n            )");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    public static final void access$handleErrorResult(PublishDetailsPresenterImpl publishDetailsPresenterImpl, ErrorResult errorResult) {
        ItemDetailsView itemDetailsView = publishDetailsPresenterImpl.c;
        if (itemDetailsView != null) {
            itemDetailsView.hideValidationProgress();
        }
        if (errorResult instanceof ErrorResult.Unauthorized) {
            PublishDetailsPresenter.Router router = publishDetailsPresenterImpl.g;
            if (router != null) {
                router.navigateToAuth();
                return;
            }
            return;
        }
        ItemDetailsView itemDetailsView2 = publishDetailsPresenterImpl.c;
        if (itemDetailsView2 != null) {
            itemDetailsView2.showError(errorResult.getMessage());
        }
    }

    public static final void access$handleUrl(PublishDetailsPresenterImpl publishDetailsPresenterImpl, String str) {
        Objects.requireNonNull(publishDetailsPresenterImpl);
        Uri parse = Uri.parse(str);
        Intrinsics.checkNotNullExpressionValue(parse, ShareConstants.MEDIA_URI);
        if (Intrinsics.areEqual(parse.getHost(), publishDetailsPresenterImpl.q.getHelpCenterHost())) {
            PublishDetailsPresenter.Router router = publishDetailsPresenterImpl.g;
            if (router != null) {
                router.showHelpCenterScreen(str);
                return;
            }
            return;
        }
        PublishDetailsPresenter.Router router2 = publishDetailsPresenterImpl.g;
        if (router2 != null) {
            router2.openWebUrl(str);
        }
    }

    public static final void access$handleWarningOnFlowFinish(PublishDetailsPresenterImpl publishDetailsPresenterImpl, List list) {
        publishDetailsPresenterImpl.h++;
        publishDetailsPresenterImpl.i(list);
        ItemDetailsView itemDetailsView = publishDetailsPresenterImpl.c;
        if (itemDetailsView != null) {
            itemDetailsView.showError(publishDetailsPresenterImpl.q.getWarningsOnFlowFinishNotification());
        }
    }

    public static final void access$observeItemChangesBySlots(PublishDetailsPresenterImpl publishDetailsPresenterImpl, Item item) {
        PublishDetailsFlowTracker.FlowContext access$toFlowContext;
        Objects.requireNonNull(publishDetailsPresenterImpl);
        ArrayList arrayList = new ArrayList();
        Iterator<? extends SlotWrapper<? extends Slot<?>>> it = publishDetailsPresenterImpl.m.iterator();
        while (it.hasNext()) {
            ConsumeValueChangeResult consumeItemValueChange$default = SlotWrapper.DefaultImpls.consumeItemValueChange$default((SlotWrapper) it.next(), item, null, 2, null);
            if ((consumeItemValueChange$default instanceof ConsumeValueChangeResult.NeedViewUpdate) && (access$toFlowContext = PublishDetailsPresenterKt.access$toFlowContext(consumeItemValueChange$default)) != null) {
                arrayList.add(access$toFlowContext);
            }
        }
        if (!arrayList.isEmpty()) {
            Object[] array = arrayList.toArray(new PublishDetailsFlowTracker.FlowContext[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
            PublishDetailsFlowTracker.FlowContext[] flowContextArr = (PublishDetailsFlowTracker.FlowContext[]) array;
            publishDetailsPresenterImpl.c((PublishDetailsFlowTracker.FlowContext[]) Arrays.copyOf(flowContextArr, flowContextArr.length));
        }
        ParameterSlot findParameter = publishDetailsPresenterImpl.getParametersTree().findParameter(item.getStringId());
        if ((findParameter instanceof BaseEditableParameter) && Intrinsics.areEqual(((BaseEditableParameter) findParameter).getUpdatesForm(), Boolean.TRUE)) {
            publishDetailsPresenterImpl.n(findParameter.getId());
        }
    }

    public static final void access$observeSlotValueChangesBySlots(PublishDetailsPresenterImpl publishDetailsPresenterImpl, ParameterSlot parameterSlot) {
        PublishDetailsFlowTracker.FlowContext access$toFlowContext;
        Objects.requireNonNull(publishDetailsPresenterImpl);
        ArrayList arrayList = new ArrayList();
        Iterator<? extends SlotWrapper<? extends Slot<?>>> it = publishDetailsPresenterImpl.m.iterator();
        while (it.hasNext()) {
            ConsumeValueChangeResult consumeItemValueChange$default = SlotWrapper.DefaultImpls.consumeItemValueChange$default((SlotWrapper) it.next(), null, parameterSlot, 1, null);
            if ((consumeItemValueChange$default instanceof ConsumeValueChangeResult.NeedViewUpdate) && (access$toFlowContext = PublishDetailsPresenterKt.access$toFlowContext(consumeItemValueChange$default)) != null) {
                arrayList.add(access$toFlowContext);
            }
        }
        if (!arrayList.isEmpty()) {
            Object[] array = arrayList.toArray(new PublishDetailsFlowTracker.FlowContext[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
            PublishDetailsFlowTracker.FlowContext[] flowContextArr = (PublishDetailsFlowTracker.FlowContext[]) array;
            publishDetailsPresenterImpl.c((PublishDetailsFlowTracker.FlowContext[]) Arrays.copyOf(flowContextArr, flowContextArr.length));
        }
    }

    public static final void access$onInfoSlotClick(PublishDetailsPresenterImpl publishDetailsPresenterImpl, String str) {
        ItemDetailsView itemDetailsView = publishDetailsPresenterImpl.c;
        if (itemDetailsView != null) {
            ItemDetailsView.DefaultImpls.showDialog$default(itemDetailsView, null, publishDetailsPresenterImpl.q.getNoCarDialogText(), publishDetailsPresenterImpl.q.getWrite(), publishDetailsPresenterImpl.q.getCancel(), new a2.a.a.e2.r.z(publishDetailsPresenterImpl, str), 1, null);
        }
    }

    public static final void access$onShowAlertClick(PublishDetailsPresenterImpl publishDetailsPresenterImpl, LinkAlertParams linkAlertParams) {
        ItemDetailsView itemDetailsView = publishDetailsPresenterImpl.c;
        if (itemDetailsView != null) {
            itemDetailsView.showDialog(linkAlertParams.getTitle(), linkAlertParams.getMessage(), linkAlertParams.getConfirmText(), linkAlertParams.getCancelText(), linkAlertParams.getConfirmListener());
        }
    }

    public static final void access$onValidationFinished(PublishDetailsPresenterImpl publishDetailsPresenterImpl, PretendResult pretendResult) {
        ItemDetailsView itemDetailsView = publishDetailsPresenterImpl.c;
        if (itemDetailsView != null) {
            itemDetailsView.showContent();
        }
        ItemDetailsView itemDetailsView2 = publishDetailsPresenterImpl.c;
        if (itemDetailsView2 != null) {
            itemDetailsView2.hideValidationProgress();
        }
        publishDetailsPresenterImpl.getParametersTree().applyPretendResult(pretendResult.getErrors());
        if (!pretendResult.getSuccess()) {
            publishDetailsPresenterImpl.l();
        }
    }

    public static final void access$onValueSelected(PublishDetailsPresenterImpl publishDetailsPresenterImpl, SelectedInfo selectedInfo) {
        Set set;
        T t2;
        ParameterSlot findParameter = publishDetailsPresenterImpl.getParametersTree().findParameter(selectedInfo.getSelectId());
        if (findParameter instanceof SelectParameter.Flat) {
            Iterator<T> it = ((SelectParameter.Flat) findParameter).getValues().iterator();
            while (true) {
                if (!it.hasNext()) {
                    t2 = null;
                    break;
                }
                t2 = it.next();
                if (Intrinsics.areEqual(t2.getId(), selectedInfo.getItem().getStringId())) {
                    break;
                }
            }
            T t3 = t2;
            if (t3 != null) {
                SelectListener.DefaultImpls.onSelected$default(publishDetailsPresenterImpl, selectedInfo.getSelectId(), t6.n.d.listOf(t3), null, 4, null);
            }
        } else if (findParameter instanceof MultiselectParameter) {
            MultiselectParameter multiselectParameter = (MultiselectParameter) findParameter;
            List list = (List) multiselectParameter.getValue();
            if (list == null || (set = CollectionsKt___CollectionsKt.toMutableSet(list)) == null) {
                set = new LinkedHashSet();
            }
            if (selectedInfo.getItem().isSelected()) {
                set.add(selectedInfo.getItem().getStringId());
            } else {
                set.remove(selectedInfo.getItem().getStringId());
            }
            List<MultiselectParameter.Value> values = multiselectParameter.getValues();
            ArrayList arrayList = new ArrayList();
            for (T t4 : values) {
                if (set.contains(t4.getId())) {
                    arrayList.add(t4);
                }
            }
            SelectListener.DefaultImpls.onSelected$default(publishDetailsPresenterImpl, selectedInfo.getSelectId(), arrayList, null, 4, null);
        }
    }

    public static final void access$processUploadingEvent(PublishDetailsPresenterImpl publishDetailsPresenterImpl, UploadingState uploadingState, Function0 function0) {
        PhotoParameter.ImageUploadListWrapper imageUploadListWrapper;
        PhotoParameter photoParameter = (PhotoParameter) publishDetailsPresenterImpl.getParametersTree().getFirstParameterOfType(PhotoParameter.class);
        if (uploadingState instanceof UploadingState.Loaded) {
            if (photoParameter != null) {
                photoParameter.setValue(new PhotoParameter.ImageUploadListWrapper(null, 1, null));
            }
            if (!(photoParameter == null || (imageUploadListWrapper = (PhotoParameter.ImageUploadListWrapper) photoParameter.getValue()) == null)) {
                List<ImageUpload> data = ((UploadingState.Loaded) uploadingState).getData();
                Integer recommendedAmount = photoParameter.getRecommendedAmount();
                imageUploadListWrapper.addAll(CollectionsKt___CollectionsKt.take(data, recommendedAmount != null ? recommendedAmount.intValue() : photoParameter.getMaxCount()));
            }
            publishDetailsPresenterImpl.b(function0);
            return;
        }
        PublishViewModel publishViewModel = publishDetailsPresenterImpl.d;
        if (publishViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("publishViewModel");
        }
        if (!publishViewModel.isEditing()) {
            publishDetailsPresenterImpl.b(function0);
            return;
        }
        if (photoParameter != null) {
            photoParameter.setError(publishDetailsPresenterImpl.q.getImageUploadError());
        }
        publishDetailsPresenterImpl.l();
    }

    public static final void access$replaceCurrentStructure(PublishDetailsPresenterImpl publishDetailsPresenterImpl, CategoryParameters categoryParameters, String str) {
        PublishViewModel publishViewModel = publishDetailsPresenterImpl.d;
        if (publishViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("publishViewModel");
        }
        publishViewModel.setCategoryParametersAndInitSteps(categoryParameters);
        publishDetailsPresenterImpl.h();
        PublishDetailsPresenter.DefaultImpls.showParameters$default(publishDetailsPresenterImpl, str, false, false, new PublishDetailsFlowTracker.FlowContext[]{PublishDetailsFlowTracker.FlowContext.FORM_UPDATE}, 6, null);
    }

    public static final void access$showPhotoUploadingError(PublishDetailsPresenterImpl publishDetailsPresenterImpl, PhotoParameter photoParameter) {
        if (photoParameter != null) {
            photoParameter.setError(publishDetailsPresenterImpl.q.getImageUploadError());
        }
        publishDetailsPresenterImpl.l();
    }

    public static final void access$startServerValidation(PublishDetailsPresenterImpl publishDetailsPresenterImpl) {
        CategoryParameters categoryParameters = publishDetailsPresenterImpl.getCategoryParameters();
        if (categoryParameters != null) {
            CompositeDisposable compositeDisposable = publishDetailsPresenterImpl.a;
            PublishDetailsInteractor publishDetailsInteractor = publishDetailsPresenterImpl.o;
            PublishViewModel publishViewModel = publishDetailsPresenterImpl.d;
            if (publishViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("publishViewModel");
            }
            DisposableKt.plusAssign(compositeDisposable, SubscribersKt.subscribeBy$default(a2.b.a.a.a.T1(publishDetailsPresenterImpl.p, publishDetailsInteractor.validateData(publishViewModel.getNavigation(), categoryParameters), "interactor.validateData(…(schedulers.mainThread())"), new j0(publishDetailsPresenterImpl), (Function0) null, new i0(publishDetailsPresenterImpl), 2, (Object) null));
        }
    }

    public static final void access$updateSelectParameterIfRequired(PublishDetailsPresenterImpl publishDetailsPresenterImpl, String str) {
        CategoryParameters categoryParameters = publishDetailsPresenterImpl.getCategoryParameters();
        SelectParameter selectParameter = null;
        ParameterSlot findParameter = categoryParameters != null ? categoryParameters.findParameter(str) : null;
        if (findParameter instanceof SelectParameter) {
            selectParameter = findParameter;
        }
        SelectParameter selectParameter2 = selectParameter;
        if (selectParameter2 != null) {
            selectParameter2.applyChosenValue();
        }
    }

    public final boolean a() {
        PublishViewModel publishViewModel = this.d;
        if (publishViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("publishViewModel");
        }
        CategoryPublishStep step = publishViewModel.getStep(Integer.valueOf(this.B));
        if (!(step instanceof CategoryPublishStep.Params)) {
            return true;
        }
        CategoryPublishStep.Params.Config config = ((CategoryPublishStep.Params) step).getConfig();
        return !Intrinsics.areEqual(config != null ? config.isContinueButtonHidden() : null, Boolean.TRUE);
    }

    @Override // com.avito.android.item_legacy.details.ItemDetailsSelectResultHandler
    public void attachParametersSource(@NotNull ParametersSource parametersSource) {
        Intrinsics.checkNotNullParameter(parametersSource, "parametersSource");
        this.t.attachParametersSource(parametersSource);
    }

    @Override // com.avito.android.publish.details.PublishDetailsPresenter
    public void attachPublishRouter(@Nullable PublishDetailsRouter publishDetailsRouter) {
        this.f = publishDetailsRouter;
    }

    @Override // com.avito.android.item_legacy.details.ItemDetailsSelectResultHandler
    public void attachResultListener(@NotNull ItemDetailsSelectResultHandler.ResultListener resultListener) {
        Intrinsics.checkNotNullParameter(resultListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.t.attachResultListener(resultListener);
    }

    @Override // com.avito.android.publish.details.PublishDetailsPresenter
    public void attachRouter(@NotNull PublishDetailsPresenter.Router router) {
        Intrinsics.checkNotNullParameter(router, "router");
        this.g = router;
        this.s.attachRouter((ItemDetailsParameterClickListener.Router) router);
    }

    @Override // com.avito.android.publish.details.PublishDetailsPresenter
    public void attachView(@NotNull ItemDetailsView itemDetailsView, boolean z2) {
        List<TagItem> list;
        Object obj;
        Sequence asSequence;
        Sequence filterNot;
        Sequence map;
        boolean z3;
        Intrinsics.checkNotNullParameter(itemDetailsView, "view");
        this.c = itemDetailsView;
        CompositeDisposable compositeDisposable = this.a;
        Observable<DataSource<? extends Item>> adapterDataChangeStream = this.x.getAdapterDataChangeStream();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        DisposableKt.plusAssign(compositeDisposable, Observables.subscribeOnNext(a2.b.a.a.a.T1(this.p, adapterDataChangeStream.debounce(50, timeUnit, this.p.computation()), "paramsListPresenter.adap…(schedulers.mainThread())"), new a2.a.a.e2.r.t(this)));
        DisposableKt.plusAssign(this.a, Observables.subscribeOnNext(a2.b.a.a.a.T1(this.p, this.x.getAdapterDataChangeStream().debounce(300, timeUnit, this.p.computation()).map(a2.a.a.e2.r.u.a), "paramsListPresenter.adap…(schedulers.mainThread())"), new a2.a.a.e2.r.v(this)));
        CompositeDisposable compositeDisposable2 = this.a;
        Disposable subscribe = this.x.getAdapterDataChangeStream().subscribe(this.y.getStructureChangeConsumer());
        Intrinsics.checkNotNullExpressionValue(subscribe, "paramsListPresenter.adap….structureChangeConsumer)");
        DisposableKt.plusAssign(compositeDisposable2, subscribe);
        DisposableKt.plusAssign(this.a, Observables.subscribeOnNext(this.x.getAdapterDataChangeStream(), new a2.a.a.e2.r.w(this)));
        DisposableKt.plusAssign(this.a, SubscribersKt.subscribeBy$default(a2.b.a.a.a.T1(this.p, Maybies.toMaybe(getParametersTree().getFirstParameterOfType(PhotoParameter.class)).toObservable().doOnNext(new m0(new Function1<PhotoParameter, Unit>(this) { // from class: a2.a.a.e2.r.p
            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public Unit invoke(PhotoParameter photoParameter) {
                PhotoParameter photoParameter2 = photoParameter;
                Intrinsics.checkNotNullParameter(photoParameter2, "p1");
                PublishDetailsPresenterImpl.access$addPhotos((PublishDetailsPresenterImpl) this.receiver, photoParameter2);
                return Unit.INSTANCE;
            }
        })).flatMap(new a2.a.a.e2.r.q(this)), "getParametersTree().getF…(schedulers.mainThread())"), a2.a.a.e2.r.s.a, (Function0) null, new a2.a.a.e2.r.r(this), 2, (Object) null));
        if (z2 && getParametersTree().getFirstParameterOfType(VideoParameter.class) != null) {
            this.H.notReadyVideoOnPublish().expose();
        }
        for (T t2 : this.A) {
            if (t2 instanceof MultiStateSelectItemPresenter) {
                CompositeDisposable compositeDisposable3 = this.a;
                Disposable subscribe2 = t2.getClickEventObservable().observeOn(this.p.mainThread()).subscribe(new f(this), b.l);
                Intrinsics.checkNotNullExpressionValue(subscribe2, "it.clickEventObservable\n…                        )");
                DisposableKt.plusAssign(compositeDisposable3, subscribe2);
            } else if (t2 instanceof RdsMultiselectItemPresenter) {
                CompositeDisposable compositeDisposable4 = this.a;
                T t3 = t2;
                Disposable subscribe3 = t3.getClickEventObservable().observeOn(this.p.mainThread()).subscribe(new g(this), b.n);
                Intrinsics.checkNotNullExpressionValue(subscribe3, "it.clickEventObservable\n…                        )");
                DisposableKt.plusAssign(compositeDisposable4, subscribe3);
                Observable<ParameterElement.Multiselect> clearEventObservable = t3.getClearEventObservable();
                CompositeDisposable compositeDisposable5 = this.a;
                Disposable subscribe4 = clearEventObservable.observeOn(this.p.mainThread()).subscribe(new a2.a.a.e2.r.n(this), a2.a.a.e2.r.o.a);
                Intrinsics.checkNotNullExpressionValue(subscribe4, "clearEventObservable\n   …ent\", it) }\n            )");
                DisposableKt.plusAssign(compositeDisposable5, subscribe4);
            } else if (t2 instanceof ChipsSelectItemPresenter) {
                CompositeDisposable compositeDisposable6 = this.a;
                Disposable subscribe5 = t2.getItemSelectedObservable().observeOn(this.p.mainThread()).subscribe(new d(0, this), b.o);
                Intrinsics.checkNotNullExpressionValue(subscribe5, "it.itemSelectedObservabl…                        )");
                DisposableKt.plusAssign(compositeDisposable6, subscribe5);
            } else if (t2 instanceof ChipsMultiselectItemPresenter) {
                CompositeDisposable compositeDisposable7 = this.a;
                Disposable subscribe6 = t2.getItemSelectedObservable().observeOn(this.p.mainThread()).subscribe(new d(1, this), b.p);
                Intrinsics.checkNotNullExpressionValue(subscribe6, "it.itemSelectedObservabl…                        )");
                DisposableKt.plusAssign(compositeDisposable7, subscribe6);
            } else if (t2 instanceof RadioGroupSelectItemPresenter) {
                CompositeDisposable compositeDisposable8 = this.a;
                Disposable subscribe7 = t2.getItemSelectedObservable().observeOn(this.p.mainThread()).subscribe(new d(2, this), b.b);
                Intrinsics.checkNotNullExpressionValue(subscribe7, "it.itemSelectedObservabl…                        )");
                DisposableKt.plusAssign(compositeDisposable8, subscribe7);
            } else if (t2 instanceof VehicleRegNumberInputItemPresenter) {
                g(t2.getValueChangesObservable());
            } else if (t2 instanceof MultiStateInputItemPresenter) {
                T t4 = t2;
                f(t4.getRightIconClickObservable());
                g(t4.getValueChangesObservable());
            } else if (t2 instanceof MultiStateInputWithTagsItemPresenter) {
                T t5 = t2;
                g(t5.getValueChangesObservable());
                Observable<SuggestRequest> suggestsRequestObservable = t5.getSuggestsRequestObservable();
                CompositeDisposable compositeDisposable9 = this.a;
                Disposable subscribe8 = suggestsRequestObservable.subscribe(new a2.a.a.e2.r.m(this));
                Intrinsics.checkNotNullExpressionValue(subscribe8, "suggestsRequestObservabl…ion.categoryId)\n        }");
                DisposableKt.plusAssign(compositeDisposable9, subscribe8);
            } else if (t2 instanceof VideoItemPresenter) {
                T t7 = t2;
                g(t7.getValueChangesObservable());
                f(t7.getRightIconClickObservable());
            } else if (t2 instanceof MultiStateSwitcherItemPresenter) {
                T t8 = t2;
                Observable<CheckBoxItem> valueChangesObservable = t8.getValueChangesObservable();
                CompositeDisposable compositeDisposable10 = this.a;
                Disposable subscribe9 = valueChangesObservable.observeOn(this.p.mainThread()).subscribe(new m0(new Function1<Item, Unit>(this) { // from class: a2.a.a.e2.r.x
                    /* Return type fixed from 'java.lang.Object' to match base method */
                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                    @Override // kotlin.jvm.functions.Function1
                    public Unit invoke(Item item) {
                        Item item2 = item;
                        Intrinsics.checkNotNullParameter(item2, "p1");
                        PublishDetailsPresenterImpl.access$observeItemChangesBySlots((PublishDetailsPresenterImpl) this.receiver, item2);
                        return Unit.INSTANCE;
                    }
                }), a2.a.a.e2.r.y.a);
                Intrinsics.checkNotNullExpressionValue(subscribe9, "valueChangesObservable\n …anges\", it)\n            }");
                DisposableKt.plusAssign(compositeDisposable10, subscribe9);
                Observable<DeepLink> deepLinkClicksObservable = t8.getDeepLinkClicksObservable();
                CompositeDisposable compositeDisposable11 = this.a;
                Disposable subscribe10 = deepLinkClicksObservable.observeOn(this.p.mainThread()).subscribe(new a2.a.a.e2.r.k(this), a2.a.a.e2.r.l.a);
                Intrinsics.checkNotNullExpressionValue(subscribe10, "deepLinkClicksObservable…icks\", it)\n            })");
                DisposableKt.plusAssign(compositeDisposable11, subscribe10);
            } else if (t2 instanceof MultiStateObjectsItemPresenter) {
                CompositeDisposable compositeDisposable12 = this.a;
                Disposable subscribe11 = t2.getObjectItemClicks().debounce(500, TimeUnit.MILLISECONDS, this.p.computation()).observeOn(this.p.mainThread()).subscribe(new h(this), b.c);
                Intrinsics.checkNotNullExpressionValue(subscribe11, "it.objectItemClicks\n    …                        )");
                DisposableKt.plusAssign(compositeDisposable12, subscribe11);
            } else if (t2 instanceof NoCarSlotItemPresenter) {
                CompositeDisposable compositeDisposable13 = this.a;
                Disposable subscribe12 = t2.getNoCarSlotClickObservable().observeOn(this.p.mainThread()).subscribe(new a(2, this), b.d);
                Intrinsics.checkNotNullExpressionValue(subscribe12, "it.noCarSlotClickObserva…                        )");
                DisposableKt.plusAssign(compositeDisposable13, subscribe12);
            } else if (t2 instanceof EditCategoryItemPresenter) {
                CompositeDisposable compositeDisposable14 = this.a;
                Disposable subscribe13 = t2.getClickEvents().debounce(500, TimeUnit.MILLISECONDS, this.p.computation()).observeOn(this.p.mainThread()).subscribe(new i(this), b.e);
                Intrinsics.checkNotNullExpressionValue(subscribe13, "it.clickEvents\n         …                        )");
                DisposableKt.plusAssign(compositeDisposable14, subscribe13);
            } else if (t2 instanceof LinkSlotItemPresenter) {
                CompositeDisposable compositeDisposable15 = this.a;
                T t9 = t2;
                Disposable subscribe14 = t9.getAlertEvents().observeOn(this.p.mainThread()).subscribe(new j(this), b.f);
                Intrinsics.checkNotNullExpressionValue(subscribe14, "it.alertEvents\n         …                        )");
                DisposableKt.plusAssign(compositeDisposable15, subscribe14);
                CompositeDisposable compositeDisposable16 = this.a;
                Disposable subscribe15 = t9.getDeepLinkClickStream().observeOn(this.p.mainThread()).subscribe(new c(0, this), b.g);
                Intrinsics.checkNotNullExpressionValue(subscribe15, "it.deepLinkClickStream\n …pLink click event\", e) })");
                DisposableKt.plusAssign(compositeDisposable16, subscribe15);
                CompositeDisposable compositeDisposable17 = this.a;
                Disposable subscribe16 = t9.getUrlClickStream().observeOn(this.p.mainThread()).subscribe(new a(0, this), b.h);
                Intrinsics.checkNotNullExpressionValue(subscribe16, "it.urlClickStream\n      … link click event\", e) })");
                DisposableKt.plusAssign(compositeDisposable17, subscribe16);
            } else if (t2 instanceof LimitsInfoItemPresenter) {
                CompositeDisposable compositeDisposable18 = this.a;
                Disposable subscribe17 = t2.getDeeplinkClicks().observeOn(this.p.mainThread()).subscribe(new c(1, this), b.i);
                Intrinsics.checkNotNullExpressionValue(subscribe17, "it.deeplinkClicks\n      …                        )");
                DisposableKt.plusAssign(compositeDisposable18, subscribe17);
            } else if (t2 instanceof MarketPriceV2Presenter) {
                CompositeDisposable compositeDisposable19 = this.a;
                T t10 = t2;
                Disposable subscribe18 = t10.getDeepLinkClickStream().observeOn(this.p.mainThread()).subscribe(new c(2, this), b.j);
                Intrinsics.checkNotNullExpressionValue(subscribe18, "it.deepLinkClickStream\n …pLink click event\", e) })");
                DisposableKt.plusAssign(compositeDisposable19, subscribe18);
                CompositeDisposable compositeDisposable20 = this.a;
                Disposable subscribe19 = t10.getUrlClickStream().observeOn(this.p.mainThread()).subscribe(new a(1, this), b.k);
                Intrinsics.checkNotNullExpressionValue(subscribe19, "it.urlClickStream\n      … link click event\", e) })");
                DisposableKt.plusAssign(compositeDisposable20, subscribe19);
            } else if (t2 instanceof CpaTariffSlotItemPresenter) {
                CompositeDisposable compositeDisposable21 = this.a;
                Disposable subscribe20 = t2.getCpaTariffSlotClickObservable().observeOn(this.p.mainThread()).subscribe(new e(this), b.m);
                Intrinsics.checkNotNullExpressionValue(subscribe20, "it.cpaTariffSlotClickObs…utton click event\", e) })");
                DisposableKt.plusAssign(compositeDisposable21, subscribe20);
            }
        }
        CompositeDisposable compositeDisposable22 = this.a;
        Disposable subscribe21 = this.I.getDataChanged().observeOn(this.p.mainThread()).subscribe(new k(this));
        Intrinsics.checkNotNullExpressionValue(subscribe21, "itemPostProcessor\n      …ontext.POST_PROCESSING) }");
        DisposableKt.plusAssign(compositeDisposable22, subscribe21);
        CompositeDisposable compositeDisposable23 = this.a;
        PublishViewModel publishViewModel = this.d;
        if (publishViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("publishViewModel");
        }
        Disposable subscribe22 = publishViewModel.shouldShowDraftOnboardingForStep(this.B).subscribe(new l(itemDetailsView));
        Intrinsics.checkNotNullExpressionValue(subscribe22, "publishViewModel\n       …howActionOnboarding(it) }");
        DisposableKt.plusAssign(compositeDisposable23, subscribe22);
        Sequence filter = SequencesKt___SequencesKt.filter(CollectionsKt___CollectionsKt.asSequence(getParametersTree()), PublishDetailsPresenterImpl$setupTags$$inlined$filterIsInstance$1.INSTANCE);
        Objects.requireNonNull(filter, "null cannot be cast to non-null type kotlin.sequences.Sequence<R>");
        Iterator it = filter.iterator();
        while (true) {
            list = null;
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((HasTags) obj).getTags() != null) {
                z3 = true;
                continue;
            } else {
                z3 = false;
                continue;
            }
            if (z3) {
                break;
            }
        }
        HasTags hasTags = (HasTags) obj;
        if (hasTags != null) {
            EditableParameter editableParameter = (EditableParameter) (!(hasTags instanceof EditableParameter) ? null : hasTags);
            if (editableParameter != null) {
                String str = (String) editableParameter.getValue();
                if (str == null) {
                    str = "";
                }
                List<TextualTag> tags = hasTags.getTags();
                if (!(tags == null || (asSequence = CollectionsKt___CollectionsKt.asSequence(tags)) == null || (filterNot = SequencesKt___SequencesKt.filterNot(asSequence, new a2.a.a.e2.r.d0(str))) == null || (map = SequencesKt___SequencesKt.map(filterNot, a2.a.a.e2.r.e0.a)) == null)) {
                    list = SequencesKt___SequencesKt.toList(map);
                }
                PublishTagsViewModel publishTagsViewModel = this.e;
                if (publishTagsViewModel == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("tagsViewModel");
                }
                publishTagsViewModel.applyTagsList(editableParameter.getId(), list);
            }
        }
        PublishViewModel publishViewModel2 = this.d;
        if (publishViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("publishViewModel");
        }
        boolean isPrevalidationRequired = publishViewModel2.isPrevalidationRequired();
        PublishViewModel publishViewModel3 = this.d;
        if (publishViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("publishViewModel");
        }
        PublishDetailsPresenter.DefaultImpls.showParameters$default(this, null, isPrevalidationRequired, publishViewModel3.getScrollToNotificationOnValidationError(), new PublishDetailsFlowTracker.FlowContext[]{PublishDetailsFlowTracker.FlowContext.INIT}, 1, null);
        j(itemDetailsView);
    }

    public final void b(Function0<Unit> function0) {
        if (!this.m.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            Iterator<? extends SlotWrapper<? extends Slot<?>>> it = this.m.iterator();
            while (it.hasNext()) {
                arrayList.add(((SlotWrapper) it.next()).checkErrors());
            }
            CompositeDisposable compositeDisposable = this.a;
            Disposable subscribe = Observable.zip(arrayList, m.a).subscribeOn(this.p.io()).observeOn(this.p.mainThread()).subscribe(new n(this, function0), o.a);
            Intrinsics.checkNotNullExpressionValue(subscribe, "Observable.zip(errorObse…or(it)\n                })");
            DisposableKt.plusAssign(compositeDisposable, subscribe);
            return;
        }
        function0.invoke();
    }

    public final void c(PublishDetailsFlowTracker.FlowContext... flowContextArr) {
        ParametersTree parametersTree = getParametersTree();
        CpaTariffSlot cpaTariffSlot = (CpaTariffSlot) parametersTree.getFirstParameterOfType(CpaTariffSlot.class);
        if (cpaTariffSlot != null) {
            this.z.trackCpaSlotShowed(((CpaTariffSlotConfig) cpaTariffSlot.getWidget().getConfig()).getButton().getAction());
        }
        ParametersListPresenter parametersListPresenter = this.x;
        PublishViewModel publishViewModel = this.d;
        if (publishViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("publishViewModel");
        }
        parametersListPresenter.sendParametersToValidator(parametersTree, publishViewModel.getCategoryParameters());
        this.x.getItemListConsumer().accept(d(parametersTree, flowContextArr));
    }

    public final List<Item> d(ParametersTree parametersTree, PublishDetailsFlowTracker.FlowContext[] flowContextArr) {
        AttributedText motivation;
        this.J.startPrepare((PublishDetailsFlowTracker.FlowContext[]) Arrays.copyOf(flowContextArr, flowContextArr.length));
        List convert$default = CategoryParametersElementConverter.convert$default(this.r, parametersTree, null, this.m, 2, null);
        HashSet hashSet = new HashSet();
        ArrayList<Item> arrayList = new ArrayList();
        for (Object obj : convert$default) {
            if (hashSet.add(((Item) obj).getStringId())) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(t6.n.e.collectionSizeOrDefault(arrayList, 10));
        for (Item item : arrayList) {
            if ((item instanceof ItemWithMotivation) && (motivation = ((ItemWithMotivation) item).getMotivation()) != null) {
                motivation.setOnDeepLinkClickListener(this.n);
            }
            arrayList2.add(this.I.transform(item));
        }
        this.J.trackPrepare((PublishDetailsFlowTracker.FlowContext[]) Arrays.copyOf(flowContextArr, flowContextArr.length));
        this.J.startDraw((PublishDetailsFlowTracker.FlowContext[]) Arrays.copyOf(flowContextArr, flowContextArr.length));
        return arrayList2;
    }

    @Override // com.avito.android.publish.details.PublishDetailsPresenter
    public void detachPublishRouter() {
    }

    @Override // com.avito.android.publish.details.PublishDetailsPresenter
    public void detachRouter() {
        this.g = null;
        this.s.detachRouter();
    }

    @Override // com.avito.android.publish.details.PublishDetailsPresenter
    public void detachView() {
        this.a.clear();
        this.b.clear();
        this.G.reset();
        Disposable disposable = this.k;
        if (disposable != null) {
            disposable.dispose();
        }
        this.c = null;
    }

    public final void e() {
        CategoryParameters categoryParameters = getCategoryParameters();
        if (categoryParameters != null) {
            ItemDetailsView itemDetailsView = this.c;
            if (itemDetailsView != null) {
                itemDetailsView.showContent();
            }
            PublishViewModel publishViewModel = this.d;
            if (publishViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("publishViewModel");
            }
            publishViewModel.setCategoryParametersAndInitSteps(categoryParameters);
            PublishDetailsPresenter.DefaultImpls.showParameters$default(this, null, false, false, null, 15, null);
        }
    }

    @Override // com.avito.android.publish.details.PublishDetailsPresenter
    public boolean enableComputerVisionIfNeeded() {
        PublishViewModel publishViewModel = this.d;
        if (publishViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("publishViewModel");
        }
        PhotoParameter photoParameter = (PhotoParameter) publishViewModel.getParamsForStep(this.B).getFirstParameterOfType(PhotoParameter.class);
        if (photoParameter == null) {
            this.G.enable(false);
        } else if (photoParameter.getShouldUploadPhotoForCV()) {
            this.G.setSuggestMaxImages(photoParameter.getSuggestByPhotoMaxImages());
            this.G.enable(true);
            return true;
        } else {
            this.G.enable(false);
        }
        return false;
    }

    public final void f(Observable<ItemWithAdditionalButton> observable) {
        CompositeDisposable compositeDisposable = this.a;
        Disposable subscribe = observable.observeOn(this.p.mainThread()).subscribe(new q(this), r.a);
        Intrinsics.checkNotNullExpressionValue(subscribe, "additionalButtonClickObs…eam\", it) }\n            )");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    public final void g(Observable<BasicInputItem> observable) {
        CompositeDisposable compositeDisposable = this.a;
        Disposable subscribe = observable.observeOn(this.p.mainThread()).subscribe(new m0(new Function1<Item, Unit>(this) { // from class: com.avito.android.publish.details.PublishDetailsPresenterImpl.s
            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public Unit invoke(Item item) {
                Item item2 = item;
                Intrinsics.checkNotNullParameter(item2, "p1");
                PublishDetailsPresenterImpl.access$observeItemChangesBySlots((PublishDetailsPresenterImpl) this.receiver, item2);
                return Unit.INSTANCE;
            }
        }), t.a);
        Intrinsics.checkNotNullExpressionValue(subscribe, "valueChangesObservable\n …anges\", it)\n            }");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    @Override // com.avito.android.item_legacy.details.ParametersSource
    @Nullable
    public CategoryParameters getCategoryParameters() {
        PublishViewModel publishViewModel = this.d;
        if (publishViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("publishViewModel");
        }
        return publishViewModel.getCategoryParameters();
    }

    @Override // com.avito.android.item_legacy.details.ParametersSource
    @NotNull
    public ParametersTree getParametersTree() {
        PublishViewModel publishViewModel = this.d;
        if (publishViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("publishViewModel");
        }
        return publishViewModel.getParamsForStep(this.B);
    }

    @Override // com.avito.android.publish.PhotoUploadObserver.PhotoParameterProvider
    @Nullable
    public PhotoParameter getPhotoParameter() {
        return (PhotoParameter) getParametersTree().getFirstParameterOfType(PhotoParameter.class);
    }

    public final void h() {
        ParametersTree parametersTree = getParametersTree();
        ArrayList arrayList = new ArrayList();
        for (Object obj : parametersTree) {
            if (obj instanceof Slot) {
                arrayList.add(obj);
            }
        }
        List<SlotWrapper> list = CollectionsKt___CollectionsKt.toList(this.m);
        ArrayList arrayList2 = new ArrayList(t6.n.e.collectionSizeOrDefault(list, 10));
        for (SlotWrapper slotWrapper : list) {
            arrayList2.add(slotWrapper.getSlot());
        }
        if (!Intrinsics.areEqual(arrayList2, arrayList)) {
            Set<? extends SlotWrapper<? extends Slot<?>>> set = this.m;
            ArrayList arrayList3 = new ArrayList();
            for (T t2 : set) {
                if (t2 instanceof ReactiveSlot) {
                    arrayList3.add(t2);
                }
            }
            Iterator it = arrayList3.iterator();
            while (it.hasNext()) {
                ((ReactiveSlot) it.next()).clear();
            }
            this.m = this.D.createSlotSet(getParametersTree());
        }
        this.b.clear();
        Set<? extends SlotWrapper<? extends Slot<?>>> set2 = this.m;
        ArrayList arrayList4 = new ArrayList();
        for (T t3 : set2) {
            if (t3 instanceof DeepLinkClicksStreamHolder) {
                arrayList4.add(t3);
            }
        }
        Iterator it2 = arrayList4.iterator();
        while (it2.hasNext()) {
            CompositeDisposable compositeDisposable = this.b;
            Disposable subscribe = ((DeepLinkClicksStreamHolder) it2.next()).getDeepLinkClicks().subscribe(new k0(this), defpackage.y.b);
            Intrinsics.checkNotNullExpressionValue(subscribe, "it.deepLinkClicks.subscr…      }\n                )");
            DisposableKt.plusAssign(compositeDisposable, subscribe);
        }
        Set<? extends SlotWrapper<? extends Slot<?>>> set3 = this.m;
        ArrayList arrayList5 = new ArrayList();
        for (T t4 : set3) {
            if (t4 instanceof ReactiveSlot) {
                arrayList5.add(t4);
            }
        }
        Iterator it3 = arrayList5.iterator();
        while (it3.hasNext()) {
            CompositeDisposable compositeDisposable2 = this.b;
            Disposable subscribe2 = ((ReactiveSlot) it3.next()).getDataChangesObservable().subscribe(new l0(this), defpackage.y.c);
            Intrinsics.checkNotNullExpressionValue(subscribe2, "it.dataChangesObservable…      }\n                )");
            DisposableKt.plusAssign(compositeDisposable2, subscribe2);
        }
    }

    @Override // com.avito.android.publish.details.PublishDetailsPresenter
    public void handleKeyboard(boolean z2) {
        ItemDetailsView itemDetailsView;
        ItemDetailsView itemDetailsView2;
        ParametersTree parametersTree = getParametersTree();
        ArrayList arrayList = new ArrayList();
        for (Object obj : parametersTree) {
            if (!(((ParameterSlot) obj) instanceof TextSuggestionsSlot)) {
                arrayList.add(obj);
            }
        }
        if (arrayList.size() > 1) {
            if (z2) {
                ItemDetailsView itemDetailsView3 = this.c;
                if (itemDetailsView3 != null) {
                    itemDetailsView3.hideMainButton();
                }
                ItemDetailsView itemDetailsView4 = this.c;
                if (itemDetailsView4 != null) {
                    itemDetailsView4.startScrollListening(new p(this));
                    return;
                }
                return;
            }
            if (a() && (itemDetailsView2 = this.c) != null) {
                itemDetailsView2.showMainButtonDelayed();
            }
            ItemDetailsView itemDetailsView5 = this.c;
            if (itemDetailsView5 != null) {
                itemDetailsView5.stopScrollListening();
            }
        } else if (a() && (itemDetailsView = this.c) != null) {
            itemDetailsView.showMainButton();
        }
    }

    public final void i(List<? extends Item> list) {
        int i2 = this.j;
        if (i2 != -1) {
            ItemDetailsView itemDetailsView = this.c;
            if (itemDetailsView != null) {
                itemDetailsView.scrollToItem(i2, PublishDetailsPresenterKt.access$hasDeferredSizeChange((Item) list.get(i2)));
            }
            this.j = -1;
            return;
        }
        this.l = true;
    }

    public final void j(ItemDetailsView itemDetailsView) {
        String str;
        ItemDetailsView.RightTopButtonStyle rightTopButtonStyle;
        String continueTitle;
        int i2 = R.drawable.ic_back_24_black;
        int i3 = R.drawable.ic_close_24_black;
        PublishViewModel publishViewModel = this.d;
        if (publishViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("publishViewModel");
        }
        CategoryPublishStep step = publishViewModel.getStep(Integer.valueOf(this.B));
        String str2 = null;
        if (step instanceof CategoryPublishStep.Params) {
            CategoryPublishStep.Params params = (CategoryPublishStep.Params) step;
            CategoryPublishStep.Params.Config config = params.getConfig();
            if (!(config == null || (continueTitle = config.getContinueTitle()) == null)) {
                itemDetailsView.setMainButtonTitle(continueTitle);
            }
            CategoryPublishStep.Params.Config config2 = params.getConfig();
            if (Intrinsics.areEqual(config2 != null ? config2.isContinueButtonHidden() : null, Boolean.TRUE)) {
                itemDetailsView.hideMainButton();
            } else {
                itemDetailsView.showMainButton();
            }
            CategoryPublishStep.Params.Config config3 = params.getConfig();
            itemDetailsView.setAppbarExpandEnabled(!((config3 != null ? config3.getHeaderStyle() : null) == CategoryPublishStep.Params.HeaderStyle.COMPACT));
            CategoryPublishStep.Params.Config config4 = params.getConfig();
            Boolean isCloseButtonHidden = config4 != null ? config4.isCloseButtonHidden() : null;
            if (isCloseButtonHidden == null || !isCloseButtonHidden.booleanValue()) {
                rightTopButtonStyle = ItemDetailsView.RightTopButtonStyle.CLOSE;
            } else {
                rightTopButtonStyle = ItemDetailsView.RightTopButtonStyle.NONE;
            }
            ItemDetailsView.DefaultImpls.setAppBarActionButton$default(itemDetailsView, null, rightTopButtonStyle, 1, null);
            CategoryPublishStep.Params.Config config5 = params.getConfig();
            String backButtonStyle = config5 != null ? config5.getBackButtonStyle() : null;
            if (backButtonStyle != null) {
                int hashCode = backButtonStyle.hashCode();
                if (hashCode != 3015911) {
                    if (hashCode == 94756344 && backButtonStyle.equals("close")) {
                        itemDetailsView.setAppBarHomeIcon(i3);
                    }
                } else if (backButtonStyle.equals(VerticalFilterCloseDialogEventKt.ACTION_BACK)) {
                    itemDetailsView.setAppBarHomeIcon(i2);
                }
            }
            itemDetailsView.setAppBarHomeIcon(i2);
        } else {
            ItemDetailsView.DefaultImpls.setAppBarActionButton$default(itemDetailsView, null, ItemDetailsView.RightTopButtonStyle.CLOSE, 1, null);
            itemDetailsView.setAppBarHomeIcon(i2);
        }
        String title = step != null ? step.getTitle() : null;
        String str3 = "";
        if (title == null) {
            title = str3;
        }
        itemDetailsView.setAppBarTitle(title);
        if (step == null || (str = step.getShortTitle()) == null) {
            str = step != null ? step.getTitle() : null;
            if (str == null) {
                str = str3;
            }
        }
        itemDetailsView.setAppBarShortTitle(str);
        if (step != null) {
            str2 = step.getSubtitle();
        }
        if (str2 != null) {
            str3 = str2;
        }
        itemDetailsView.setAppBarSubtitle(str3);
    }

    public final void k(ParametersTree parametersTree, String str, boolean z2, boolean z3, PublishDetailsFlowTracker.FlowContext[] flowContextArr) {
        ItemDetailsView itemDetailsView = this.c;
        if (itemDetailsView != null) {
            itemDetailsView.showContent();
        }
        ParametersListPresenter parametersListPresenter = this.x;
        PublishViewModel publishViewModel = this.d;
        if (publishViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("publishViewModel");
        }
        parametersListPresenter.sendParametersToValidator(parametersTree, publishViewModel.getCategoryParameters());
        List<Item> d2 = d(parametersTree, flowContextArr);
        if (str != null) {
            Disposable disposable = this.k;
            if (disposable != null) {
                disposable.dispose();
            }
            CategoryParameter access$firstEmptyParameter = PublishDetailsPresenterKt.access$firstEmptyParameter(getParametersTree(), str);
            if (access$firstEmptyParameter != null) {
                int i2 = 0;
                Iterator it = ((ArrayList) d2).iterator();
                while (true) {
                    if (!it.hasNext()) {
                        i2 = -1;
                        break;
                    } else if (Intrinsics.areEqual(((Item) it.next()).getStringId(), access$firstEmptyParameter.getId())) {
                        break;
                    } else {
                        i2++;
                    }
                }
                if (i2 > -1) {
                    Disposable disposable2 = this.k;
                    if (disposable2 != null) {
                        disposable2.dispose();
                    }
                    Maybe<DataSource<? extends Item>> observeOn = this.x.getAdapterDataChangeStream().firstElement().observeOn(this.p.mainThread());
                    Intrinsics.checkNotNullExpressionValue(observeOn, "paramsListPresenter.adap…(schedulers.mainThread())");
                    this.k = SubscribersKt.subscribeBy$default(observeOn, a2.a.a.e2.r.c0.a, (Function0) null, new a2.a.a.e2.r.b0(this, i2), 2, (Object) null);
                }
            }
        } else if (z3) {
            i(d2);
        }
        this.x.getItemListConsumer().accept(d2);
        if (z2) {
            m(new b0(this));
        }
        ItemDetailsView itemDetailsView2 = this.c;
        if (itemDetailsView2 != null) {
            itemDetailsView2.enableMainButton();
        }
    }

    public final void l() {
        ItemDetailsView itemDetailsView = this.c;
        if (itemDetailsView != null) {
            itemDetailsView.showError(this.q.getFixErrors());
        }
        PublishDetailsPresenter.DefaultImpls.showParameters$default(this, null, false, true, null, 11, null);
    }

    public final void m(Function0<Unit> function0) {
        PhotoParameter photoParameter = (PhotoParameter) getParametersTree().getFirstParameterOfType(PhotoParameter.class);
        if (photoParameter != null) {
            CompositeDisposable compositeDisposable = this.a;
            Maybe<UploadingState> observeOn = this.v.getUploadProgressObservable().firstElement().observeOn(this.p.mainThread());
            Intrinsics.checkNotNullExpressionValue(observeOn, "uploadingProgressInterac…(schedulers.mainThread())");
            DisposableKt.plusAssign(compositeDisposable, SubscribersKt.subscribeBy$default(observeOn, new d0(this, photoParameter), (Function0) null, new c0(this, function0), 2, (Object) null));
            return;
        }
        b(function0);
    }

    public final void n(String str) {
        CompositeDisposable compositeDisposable = this.a;
        PublishDetailsInteractor publishDetailsInteractor = this.o;
        PublishViewModel publishViewModel = this.d;
        if (publishViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("publishViewModel");
        }
        Navigation navigation = publishViewModel.getNavigation();
        CategoryParameters categoryParameters = getCategoryParameters();
        Intrinsics.checkNotNull(categoryParameters);
        Disposable subscribe = publishDetailsInteractor.loadExtraStepsWithProgress(navigation, categoryParameters).subscribeOn(this.p.io()).observeOn(this.p.mainThread()).subscribe(new e0(this, str), f0.a);
        Intrinsics.checkNotNullExpressionValue(subscribe, "interactor.loadExtraStep…ror\", it) }\n            )");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    @Override // com.avito.android.item_legacy.details.ItemDetailsSelectResultHandler
    public void onAddressParameterChanged(@Nullable AddressParameter.Value value) {
        this.t.onAddressParameterChanged(value);
    }

    @Override // com.avito.android.publish.details.PublishDetailsPresenter
    public void onAuthResult(int i2) {
        PublishDetailsPresenter.Router router;
        if (i2 != -1 && (router = this.g) != null) {
            router.leaveScreen();
        }
    }

    @Override // com.avito.android.select.SelectListener
    public void onCancel(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "requestId");
        this.t.onCancel(str);
    }

    @Override // com.avito.android.publish.view.ItemDetailsView.Presenter
    public void onCancelClicked(boolean z2) {
        ItemDetailsView itemDetailsView = this.c;
        if (itemDetailsView != null) {
            itemDetailsView.hideKeyboard();
        }
        if (z2) {
            PublishDetailsPresenter.Router router = this.g;
            if (router != null) {
                router.leaveScreen();
                return;
            }
            return;
        }
        PublishViewModel publishViewModel = this.d;
        if (publishViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("publishViewModel");
        }
        publishViewModel.goToPreviousStep();
    }

    @Override // com.avito.android.publish.details.PublishDetailsPresenter
    public void onDestroy() {
        this.F.stopObserve();
        Set<? extends SlotWrapper<? extends Slot<?>>> set = this.m;
        ArrayList<ReactiveSlot> arrayList = new ArrayList();
        for (T t2 : set) {
            if (t2 instanceof ReactiveSlot) {
                arrayList.add(t2);
            }
        }
        for (ReactiveSlot reactiveSlot : arrayList) {
            reactiveSlot.clear();
        }
        this.I.clear();
    }

    @Override // com.avito.android.blueprints.ButtonItemPresenter.Listener
    public void onItemButtonClicked(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "id");
        onMainButtonClicked();
    }

    @Override // com.avito.android.publish.view.ItemDetailsView.Presenter
    public void onMainButtonClicked() {
        ItemDetailsView itemDetailsView = this.c;
        if (itemDetailsView != null) {
            itemDetailsView.hideKeyboard();
        }
        ParametersTree parametersTree = getParametersTree();
        ParametersListPresenter parametersListPresenter = this.x;
        PublishViewModel publishViewModel = this.d;
        if (publishViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("publishViewModel");
        }
        parametersListPresenter.sendParametersToValidator(parametersTree, publishViewModel.getCategoryParameters());
        CompositeDisposable compositeDisposable = this.a;
        Single observeOn = Single.fromCallable(new u(this, parametersTree)).flatMap(new v(this)).observeOn(this.p.mainThread());
        Intrinsics.checkNotNullExpressionValue(observeOn, "Single.fromCallable { cr…(schedulers.mainThread())");
        DisposableKt.plusAssign(compositeDisposable, Singles.subscribeOnNext(observeOn, new w(this)));
    }

    @Override // com.avito.android.item_legacy.details.ItemDetailsSelectResultHandler
    public void onObjectsParameterChanged(@NotNull ObjectsParameter objectsParameter) {
        Intrinsics.checkNotNullParameter(objectsParameter, "updatedParameter");
        this.t.onObjectsParameterChanged(objectsParameter);
    }

    @Override // com.avito.android.item_legacy.details.ItemDetailsSelectResultHandler.ResultListener
    @MainThread
    public void onParametersUpdated(@Nullable String str, @Nullable ParameterSlot parameterSlot) {
        if (str != null) {
            n(str);
            return;
        }
        if (parameterSlot instanceof SelectParameter) {
            for (SlotWrapper slotWrapper : SequencesKt___SequencesKt.filter(CollectionsKt___CollectionsKt.asSequence(this.m), x.a)) {
                SlotWrapper.DefaultImpls.consumeItemValueChange$default(slotWrapper, null, parameterSlot, 1, null);
            }
        }
        PublishDetailsPresenter.DefaultImpls.showParameters$default(this, null, false, false, null, 15, null);
    }

    @Override // com.avito.android.publish.details.PublishDetailsPresenter
    public void onResidentialComplexResult(@NotNull SelectParameter.Value value) {
        T t2;
        Intrinsics.checkNotNullParameter(value, "value");
        Iterator<T> it = this.m.iterator();
        while (true) {
            if (!it.hasNext()) {
                t2 = null;
                break;
            }
            t2 = it.next();
            if (t2.getSlot() instanceof ResidentialComplexSlot) {
                break;
            }
        }
        T t3 = t2;
        if (t3 != null) {
            T t4 = t3;
            t4.setValue(value);
            n(((ResidentialComplexSlotConfig) t4.getSlot().getWidget().getConfig()).getDevelopment().getId());
        }
    }

    @Override // com.avito.android.item_legacy.details.ItemDetailsSelectResultHandler.ResultListener
    public void onResultHandled(@NotNull CategoryParameters categoryParameters) {
        Intrinsics.checkNotNullParameter(categoryParameters, "params");
        PublishDetailsPresenter.DefaultImpls.showParameters$default(this, null, false, false, null, 15, null);
    }

    @Override // com.avito.android.publish.view.ItemDetailsView.Presenter
    public void onRetryClick() {
        e();
    }

    @Override // com.avito.android.publish.details.PublishDetailsPresenter
    @NotNull
    public Bundle onSaveState() {
        Bundle bundle = new Bundle();
        bundle.putInt("retries_with_warnings_count", this.h);
        bundle.putBoolean("key_photos_were_added", this.i);
        return bundle;
    }

    @Override // com.avito.android.select.SelectListener
    public void onSelected(@NotNull String str, @NotNull List<? extends ParcelableEntity<String>> list, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(str, "requestId");
        Intrinsics.checkNotNullParameter(list, "selectedItems");
        this.t.onSelected(str, list, str2);
    }

    @Override // com.avito.android.item_legacy.details.ItemDetailsSelectResultHandler.ResultListener
    public void onUpdateAddress(@Nullable AddressParameter.Value value) {
        if (value == null) {
            Logs.error$default("Address must not be null!", null, 2, null);
        } else {
            e();
        }
    }

    @Override // com.avito.android.publish.details.PublishDetailsPresenter
    public void setPublishViewModel(@NotNull PublishViewModel publishViewModel) {
        Intrinsics.checkNotNullParameter(publishViewModel, "publishViewModel");
        this.d = publishViewModel;
        this.D.setPublishViewModel(publishViewModel);
        h();
    }

    @Override // com.avito.android.publish.details.PublishDetailsPresenter
    public void setTagsViewModel(@NotNull PublishTagsViewModel publishTagsViewModel) {
        Intrinsics.checkNotNullParameter(publishTagsViewModel, "tagsViewModel");
        this.e = publishTagsViewModel;
    }

    @Override // com.avito.android.publish.details.PublishDetailsPresenter
    public void showParameters(@Nullable String str, boolean z2, boolean z3, @NotNull PublishDetailsFlowTracker.FlowContext[] flowContextArr) {
        Intrinsics.checkNotNullParameter(flowContextArr, "flowContext");
        ParametersTree parametersTree = getParametersTree();
        ItemDetailsView itemDetailsView = this.c;
        if (itemDetailsView != null) {
            itemDetailsView.disableMainButton();
        }
        if (!this.m.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            Iterator<? extends SlotWrapper<? extends Slot<?>>> it = this.m.iterator();
            while (it.hasNext()) {
                arrayList.add(((SlotWrapper) it.next()).prepare());
            }
            CompositeDisposable compositeDisposable = this.a;
            Disposable subscribe = Observable.zip(arrayList, y.a).observeOn(this.p.mainThread()).subscribe(new z(this, parametersTree, str, z2, z3, flowContextArr), new a0(this));
            Intrinsics.checkNotNullExpressionValue(subscribe, "Observable.zip(prepareOb…      }\n                )");
            DisposableKt.plusAssign(compositeDisposable, subscribe);
            return;
        }
        k(parametersTree, str, z2, z3, flowContextArr);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PublishDetailsPresenterImpl(PublishDetailsInteractor publishDetailsInteractor, SchedulersFactory schedulersFactory, PublishDetailsResourceProvider publishDetailsResourceProvider, CategoryParametersElementConverter categoryParametersElementConverter, ItemDetailsParameterClickListener itemDetailsParameterClickListener, ItemDetailsSelectResultHandler itemDetailsSelectResultHandler, PhotoInteractorWrapper photoInteractorWrapper, UploadingProgressInteractor uploadingProgressInteractor, SubmissionListener submissionListener, ParametersListPresenter parametersListPresenter, PublishInputsAnalyticTracker publishInputsAnalyticTracker, PublishEventTracker publishEventTracker, Set set, int i2, Formatter formatter, SlotsFactory slotsFactory, DeviceMetrics deviceMetrics, PhotoUploadObserver photoUploadObserver, ComputerVisionInteractor computerVisionInteractor, AbTestsConfigProvider abTestsConfigProvider, ItemPostProcessor itemPostProcessor, PublishDetailsFlowTracker publishDetailsFlowTracker, Bundle bundle, int i3, t6.r.a.j jVar) {
        this(publishDetailsInteractor, schedulersFactory, publishDetailsResourceProvider, categoryParametersElementConverter, itemDetailsParameterClickListener, itemDetailsSelectResultHandler, photoInteractorWrapper, uploadingProgressInteractor, submissionListener, parametersListPresenter, publishInputsAnalyticTracker, publishEventTracker, set, i2, formatter, slotsFactory, deviceMetrics, photoUploadObserver, computerVisionInteractor, abTestsConfigProvider, itemPostProcessor, publishDetailsFlowTracker, (i3 & 4194304) != 0 ? null : bundle);
    }
}
