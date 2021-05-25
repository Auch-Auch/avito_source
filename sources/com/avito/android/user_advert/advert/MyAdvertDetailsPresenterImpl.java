package com.avito.android.user_advert.advert;

import a2.a.a.h3.a.c0;
import a2.a.a.h3.a.d0;
import a2.a.a.h3.a.e0;
import a2.a.a.h3.a.i0;
import a2.a.a.h3.a.j0;
import a2.a.a.h3.a.k0;
import a2.a.a.h3.a.l0;
import a2.a.a.h3.a.m0;
import a2.a.a.h3.a.n0;
import a2.a.a.h3.a.o0;
import a2.a.a.h3.a.p0;
import a2.a.a.h3.a.q0;
import a2.a.a.h3.a.r0;
import a2.a.a.h3.a.x;
import a2.a.a.h3.a.x0;
import a2.a.a.h3.a.y;
import android.content.ClipboardManager;
import android.net.Uri;
import androidx.exifinterface.media.ExifInterface;
import com.avito.android.Features;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.advert_core.car_market_price.badge.AdvertDetailsImvBadgeItemConverter;
import com.avito.android.advert_core.car_market_price.badge.AdvertDetailsImvBadgePresenter;
import com.avito.android.advert_core.car_market_price.price_chart.CarMarketPriceChartPresenter;
import com.avito.android.advert_core.car_market_price.price_description.CarMarketPriceDescriptionPresenter;
import com.avito.android.advert_core.di.module.AdvertDeliveryBlockDataObservable;
import com.avito.android.advert_core.di.module.AdvertSellerShortTermRentObservable;
import com.avito.android.advert_core.safedeal.di.MyAdvertSafeDealServicesObservable;
import com.avito.android.advert_core.social.SocialPresenter;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.bivrost.BivrostTutorialSessionStorage;
import com.avito.android.app_rater.AppRaterInteractor;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.calls_shared.MicAccessScenario;
import com.avito.android.calls_shared.analytics.events.MicPermissionPopupResultEvent;
import com.avito.android.date_time_formatter.DateTimeFormatter;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.DetailsSheetLinkBody;
import com.avito.android.deep_linking.links.DraftDeletionLink;
import com.avito.android.deep_linking.links.DraftPublicationLink;
import com.avito.android.deep_linking.links.FeesLink;
import com.avito.android.deep_linking.links.LegacyPaidServicesLink;
import com.avito.android.deep_linking.links.MyAdvertLink;
import com.avito.android.deep_linking.links.PaidServicesLink;
import com.avito.android.di.module.DateTimeFormatterModule;
import com.avito.android.lib.design.input.CustomMaskFormatterKt;
import com.avito.android.lib.design.input.FormatterType;
import com.avito.android.permissions.PermissionState;
import com.avito.android.permissions.PermissionStateProvider;
import com.avito.android.permissions.PermissionStorage;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.ErrorWithMessage;
import com.avito.android.remote.error.TypedError;
import com.avito.android.remote.model.Action;
import com.avito.android.remote.model.AdvertDeliveryC2C;
import com.avito.android.remote.model.AdvertSellerShortTermRent;
import com.avito.android.remote.model.AdvertSharing;
import com.avito.android.remote.model.AnonymousNumber;
import com.avito.android.remote.model.CloseReason;
import com.avito.android.remote.model.LimitsInfo;
import com.avito.android.remote.model.MyAdvertSafeDeal;
import com.avito.android.remote.model.SimpleMessageResult;
import com.avito.android.remote.model.SuccessResult;
import com.avito.android.remote.model.Verification;
import com.avito.android.remote.model.VerificationStep;
import com.avito.android.remote.model.adverts.MyAdvertDetails;
import com.avito.android.remote.model.adverts.RestoreAdvertResult;
import com.avito.android.remote.model.profile.ItemActivateResponse;
import com.avito.android.server_time.TimeSource;
import com.avito.android.user_advert.AdvertActionTransferData;
import com.avito.android.user_advert.advert.MyAdvertDetailsPresenter;
import com.avito.android.user_advert.advert.MyAdvertRouter;
import com.avito.android.user_advert.advert.feature_teasers.MyAdvertDetailsFeatureTeaserPresenter;
import com.avito.android.user_advert.advert.switcher_block.AdvertLoadListener;
import com.avito.android.user_advert.advert.verification.VerificationItemConverter;
import com.avito.android.user_advert.contact.MyAdvertContactsPresenter;
import com.avito.android.user_advert.di.ErrorMessage;
import com.avito.android.user_advert.di.IsNewAdvert;
import com.avito.android.user_advert.di.RestoreAdvert;
import com.avito.android.user_advert.di.ShouldFinishAfterActivation;
import com.avito.android.user_advert.di.ShouldOpenActivateDialog;
import com.avito.android.user_advert.di.ShouldOpenUserAdverts;
import com.avito.android.user_advert.di.StatusMessage;
import com.avito.android.user_advert.event.AdvertReactivationStartEvent;
import com.avito.android.user_advert.event.PhotoWizardStartClickEvent;
import com.avito.android.user_advert.event.VasButtonClickEvent;
import com.avito.android.user_advert.limits_info.LimitsInfoInteractor;
import com.avito.android.user_advert.tracker.MyAdvertDetailsTracker;
import com.avito.android.user_adverts_common.charity.CharityInteractor;
import com.avito.android.user_adverts_common.safety.SafetyInfoProvider;
import com.avito.android.util.ClipDataFactory;
import com.avito.android.util.ErrorFormatter;
import com.avito.android.util.Kundle;
import com.avito.android.util.LoadingState;
import com.avito.android.util.Logs;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.Throwables;
import com.avito.android.util.rx3.Disposables;
import com.avito.android.util.rx3.InteropKt;
import com.jakewharton.rxrelay3.PublishRelay;
import com.jakewharton.rxrelay3.Relay;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.core.BackpressureStrategy;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.kotlin.SubscribersKt;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000ê\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001Bæ\u0003\b\u0007\u0012\u0007\u0010\u0002\u001a\u00020\u001a\u0012\t\b\u0001\u0010\u0001\u001a\u00020\u000b\u0012\b\b\u0001\u0010\u001f\u001a\u00020\u000b\u0012\t\b\u0001\u0010£\u0002\u001a\u00020\u000b\u0012\t\b\u0001\u0010ë\u0001\u001a\u00020\u000b\u0012\t\b\u0001\u0010Â\u0001\u001a\u00020\u000b\u0012\n\b\u0001\u0010%\u001a\u0004\u0018\u00010\u001c\u0012\b\u0010\u0001\u001a\u00030\u0001\u0012\b\u0010Ö\u0001\u001a\u00030Ó\u0001\u0012\b\u0010ï\u0001\u001a\u00030ì\u0001\u0012\b\u0010\u0002\u001a\u00030þ\u0001\u0012\b\u0010\u0001\u001a\u00030\u0001\u0012\b\u0010ù\u0001\u001a\u00030ö\u0001\u0012\u0006\u0010\u001a\u00020|\u0012\b\u0010\u0002\u001a\u00030\u0002\u0012\b\u0010¢\u0001\u001a\u00030\u0001\u0012\b\u0010á\u0001\u001a\u00030Þ\u0001\u0012\b\u0010é\u0001\u001a\u00030æ\u0001\u0012\b\u0010Ú\u0001\u001a\u00030×\u0001\u0012\b\u0010\u0001\u001a\u00030\u0001\u0012\n\b\u0001\u0010\u0002\u001a\u00030\u0002\u0012\b\u0010Æ\u0001\u001a\u00030Ä\u0001\u0012\u0011\b\u0001\u0010À\u0001\u001a\n\u0012\u0005\u0012\u00030½\u00010¼\u0001\u0012\u0011\b\u0001\u0010Í\u0001\u001a\n\u0012\u0005\u0012\u00030Ë\u00010¼\u0001\u0012\u0011\b\u0001\u0010§\u0001\u001a\n\u0012\u0005\u0012\u00030¤\u00010£\u0001\u0012\b\u0010\u0002\u001a\u00030\u0002\u0012\b\u0010«\u0001\u001a\u00030¨\u0001\u0012\b\u0010\u0002\u001a\u00030\u0002\u0012\b\u0010§\u0002\u001a\u00030¤\u0002\u0012\b\u0010å\u0001\u001a\u00030â\u0001\u0012\b\u0010\u0002\u001a\u00030\u0002\u0012\b\u0010¡\u0002\u001a\u00030\u0002\u0012\b\u0010Ê\u0001\u001a\u00030Ç\u0001\u0012\b\u0010ó\u0001\u001a\u00030ð\u0001\u0012\b\u0010»\u0001\u001a\u00030¸\u0001\u0012\b\u0010\u0001\u001a\u00030\u0001\u0012\b\u0010·\u0001\u001a\u00030´\u0001\u0012\b\u0010\u0001\u001a\u00030\u0001\u0012\b\u0010Ð\u0001\u001a\u00030Î\u0001\u0012\b\u0010«\u0002\u001a\u00030¨\u0002\u0012\b\u0010¯\u0001\u001a\u00030¬\u0001\u0012\b\u0010ý\u0001\u001a\u00030ú\u0001\u0012\n\b\u0001\u0010\u001d\u001a\u0004\u0018\u00010\u001c\u0012\t\u0010¬\u0002\u001a\u0004\u0018\u00010\u0011¢\u0006\u0006\b­\u0002\u0010®\u0002J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0016\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J1\u0010 \u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001a2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b \u0010!J\u0017\u0010#\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u0002H\u0016¢\u0006\u0004\b#\u0010\u0006J!\u0010&\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u000b2\b\u0010%\u001a\u0004\u0018\u00010\u001cH\u0016¢\u0006\u0004\b&\u0010'J\u000f\u0010(\u001a\u00020\u0004H\u0016¢\u0006\u0004\b(\u0010\u0010J\u000f\u0010)\u001a\u00020\u0004H\u0016¢\u0006\u0004\b)\u0010\u0010J\u0017\u0010,\u001a\u00020\u00042\u0006\u0010+\u001a\u00020*H\u0016¢\u0006\u0004\b,\u0010-J\u000f\u0010.\u001a\u00020\u0004H\u0016¢\u0006\u0004\b.\u0010\u0010J\u0017\u00101\u001a\u00020\u00042\u0006\u00100\u001a\u00020/H\u0016¢\u0006\u0004\b1\u00102J\u0017\u00105\u001a\u00020\u00042\u0006\u00104\u001a\u000203H\u0016¢\u0006\u0004\b5\u00106J\u0017\u00107\u001a\u00020\u00042\u0006\u00104\u001a\u000203H\u0016¢\u0006\u0004\b7\u00106J\u0017\u00108\u001a\u00020\u00042\u0006\u00100\u001a\u00020/H\u0016¢\u0006\u0004\b8\u00102J\u0017\u0010;\u001a\u00020\u00042\u0006\u0010:\u001a\u000209H\u0016¢\u0006\u0004\b;\u0010<J!\u0010@\u001a\u00020\u00042\u0006\u0010>\u001a\u00020=2\b\u0010?\u001a\u0004\u0018\u00010\u001cH\u0016¢\u0006\u0004\b@\u0010AJ<\u0010J\u001a\u00020\u00042#\u0010H\u001a\u001f\u0012\u0013\u0012\u00110C¢\u0006\f\bD\u0012\b\bE\u0012\u0004\b\b(F\u0012\u0006\u0012\u0004\u0018\u00010G0B2\u0006\u0010I\u001a\u00020\u000bH\u0016¢\u0006\u0004\bJ\u0010KJ\u0017\u0010L\u001a\u00020\u00042\u0006\u0010:\u001a\u00020\u0002H\u0016¢\u0006\u0004\bL\u0010\u0006J\u001f\u0010N\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010M\u001a\u00020\u000bH\u0016¢\u0006\u0004\bN\u0010OJ\u0019\u0010P\u001a\u00020\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016¢\u0006\u0004\bP\u0010QJ\u000f\u0010R\u001a\u00020\u0004H\u0016¢\u0006\u0004\bR\u0010\u0010J\u0017\u0010U\u001a\u00020\u00042\u0006\u0010T\u001a\u00020SH\u0016¢\u0006\u0004\bU\u0010VJ\u000f\u0010W\u001a\u00020\u0004H\u0016¢\u0006\u0004\bW\u0010\u0010J\u000f\u0010X\u001a\u00020\u0004H\u0016¢\u0006\u0004\bX\u0010\u0010J\u0019\u0010Z\u001a\u00020\u00042\b\u0010Y\u001a\u0004\u0018\u00010\u001cH\u0016¢\u0006\u0004\bZ\u0010QJ\u000f\u0010[\u001a\u00020\u0004H\u0016¢\u0006\u0004\b[\u0010\u0010J\u000f\u0010\\\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\\\u0010\u0010J)\u0010^\u001a\u00020\u00042\u0006\u0010]\u001a\u00020C2\u0006\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b^\u0010_J#\u0010a\u001a\u00020\u00042\u0012\u0010`\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00040BH\u0002¢\u0006\u0004\ba\u0010bJ'\u0010e\u001a\b\u0012\u0004\u0012\u00020\u00040d2\u0006\u00100\u001a\u00020/2\b\b\u0002\u0010c\u001a\u00020\u000bH\u0002¢\u0006\u0004\be\u0010fJ\u001d\u0010h\u001a\b\u0012\u0004\u0012\u00020\u00040d2\u0006\u0010g\u001a\u00020\u001cH\u0002¢\u0006\u0004\bh\u0010iJ\u0019\u0010k\u001a\u00020\u00042\b\u0010j\u001a\u0004\u0018\u00010\u001cH\u0002¢\u0006\u0004\bk\u0010QJ9\u0010p\u001a\b\u0012\u0004\u0012\u00020\u00040o2\u0006\u0010g\u001a\u00020\u001c2\u0006\u0010l\u001a\u00020\u001c2\u0012\u0010n\u001a\u000e\u0012\u0004\u0012\u00020m\u0012\u0004\u0012\u00020\u00040BH\u0002¢\u0006\u0004\bp\u0010qJ\u001d\u0010r\u001a\b\u0012\u0004\u0012\u00020\u00040d2\u0006\u0010g\u001a\u00020\u001cH\u0002¢\u0006\u0004\br\u0010iJ\u0017\u0010u\u001a\u00020\u00042\u0006\u0010t\u001a\u00020sH\u0002¢\u0006\u0004\bu\u0010vJ\u0019\u0010y\u001a\u00020\u000b2\b\u0010x\u001a\u0004\u0018\u00010wH\u0002¢\u0006\u0004\by\u0010zR\u0018\u0010+\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\br\u0010{R\u0016\u0010\u001a\u00020|8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b}\u0010~R\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R \u0010\u0001\u001a\t\u0012\u0004\u0012\u0002030\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u0019\u0010\u0001\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u0018\u0010\u0001\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\by\u0010\u0001R\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001a\u0010\u0001\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\bu\u0010\u0001R\u001a\u0010¢\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b \u0001\u0010¡\u0001R!\u0010§\u0001\u001a\n\u0012\u0005\u0012\u00030¤\u00010£\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b¥\u0001\u0010¦\u0001R\u001a\u0010«\u0001\u001a\u00030¨\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b©\u0001\u0010ª\u0001R\u001a\u0010¯\u0001\u001a\u00030¬\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b­\u0001\u0010®\u0001R\u001c\u0010³\u0001\u001a\u0005\u0018\u00010°\u00018\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b±\u0001\u0010²\u0001R\u001a\u0010·\u0001\u001a\u00030´\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bµ\u0001\u0010¶\u0001R\u001a\u0010»\u0001\u001a\u00030¸\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b¹\u0001\u0010º\u0001R!\u0010À\u0001\u001a\n\u0012\u0005\u0012\u00030½\u00010¼\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b¾\u0001\u0010¿\u0001R\u0019\u0010Â\u0001\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bÁ\u0001\u0010\u0001R\u0018\u0010Ã\u0001\u001a\u00020\u000b8\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\bp\u0010\u0001R\u001a\u0010Æ\u0001\u001a\u00030Ä\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010Å\u0001R\u001a\u0010Ê\u0001\u001a\u00030Ç\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bÈ\u0001\u0010É\u0001R!\u0010Í\u0001\u001a\n\u0012\u0005\u0012\u00030Ë\u00010¼\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bÌ\u0001\u0010¿\u0001R\u001a\u0010Ð\u0001\u001a\u00030Î\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010Ï\u0001R\u001a\u0010]\u001a\u0004\u0018\u00010C8\u0002@\u0002X\u000e¢\u0006\b\n\u0006\bÑ\u0001\u0010Ò\u0001R\u001a\u0010Ö\u0001\u001a\u00030Ó\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bÔ\u0001\u0010Õ\u0001R\u001a\u0010Ú\u0001\u001a\u00030×\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bØ\u0001\u0010Ù\u0001R\u0019\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\bh\u0010\u0001R\u0019\u0010Ü\u0001\u001a\u00020\u000b8\u0002@\u0002X\u000e¢\u0006\b\n\u0006\bÛ\u0001\u0010\u0001R\u0018\u0010\u001f\u001a\u00020\u000b8\u0002@\u0002X\u000e¢\u0006\b\n\u0006\bÝ\u0001\u0010\u0001R\u001a\u0010á\u0001\u001a\u00030Þ\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bß\u0001\u0010à\u0001R\u001a\u0010å\u0001\u001a\u00030â\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bã\u0001\u0010ä\u0001R\u001a\u0010é\u0001\u001a\u00030æ\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bç\u0001\u0010è\u0001R\u0019\u0010ë\u0001\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bê\u0001\u0010\u0001R\u001a\u0010ï\u0001\u001a\u00030ì\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bí\u0001\u0010î\u0001R\u001a\u0010ó\u0001\u001a\u00030ð\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bñ\u0001\u0010ò\u0001R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b^\u0010ô\u0001R\u001a\u0010%\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u000e¢\u0006\b\n\u0006\bõ\u0001\u0010\u0001R\u001a\u0010ù\u0001\u001a\u00030ö\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b÷\u0001\u0010ø\u0001R\u001a\u0010ý\u0001\u001a\u00030ú\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bû\u0001\u0010ü\u0001R\u001a\u0010\u0002\u001a\u00030þ\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bÿ\u0001\u0010\u0002R\u0018\u0010\u0002\u001a\u00020\u000b8\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\bk\u0010\u0001R\u001a\u0010\u0002\u001a\u00030\u00028\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0002\u0010\u0002R\u0019\u0010\u0002\u001a\u00020\u001a8\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0002\u0010\u0002R\u001a\u0010\u0002\u001a\u00030\u00028\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0002\u0010\u0002R\u001a\u0010\u0002\u001a\u00030\u00028\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0002\u0010\u0002R\u0019\u0010\u0002\u001a\u00030\u00028\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\be\u0010\u0002R\u001a\u0010\u0002\u001a\u00030\u00028\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0002\u0010\u0002R\u001a\u0010\u0002\u001a\u00030\u00028\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0002\u0010\u0002R\u0018\u0010\u0002\u001a\u00020\u000b8\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\ba\u0010\u0001R\u001a\u0010¡\u0002\u001a\u00030\u00028\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0002\u0010 \u0002R\u0019\u0010£\u0002\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b¢\u0002\u0010\u0001R\u001a\u0010§\u0002\u001a\u00030¤\u00028\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b¥\u0002\u0010¦\u0002R\u001a\u0010«\u0002\u001a\u00030¨\u00028\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b©\u0002\u0010ª\u0002¨\u0006¯\u0002"}, d2 = {"Lcom/avito/android/user_advert/advert/MyAdvertDetailsPresenterImpl;", "Lcom/avito/android/user_advert/advert/MyAdvertDetailsPresenter;", "", "currentPosition", "", "onGalleryFullScreenClicked", "(I)V", "Lcom/avito/android/user_advert/advert/MyAdvertDetailsView;", "view", "attachView", "(Lcom/avito/android/user_advert/advert/MyAdvertDetailsView;)V", "", "shouldShowAppRater", "init", "(Z)V", "onLoginFailed", "()V", "Lcom/avito/android/util/Kundle;", "onSavedState", "()Lcom/avito/android/util/Kundle;", "Lcom/avito/android/user_advert/advert/MyAdvertDetailsPresenter$ProcessedAction;", "processedAction", "onInitialize", "(ZLcom/avito/android/user_advert/advert/MyAdvertDetailsPresenter$ProcessedAction;)V", "onReinitialize", "(Lcom/avito/android/user_advert/advert/MyAdvertDetailsPresenter$ProcessedAction;)V", "Lcom/avito/android/user_advert/advert/DetailsId;", "id", "", "statusMessage", "showActivation", "isNewAdvert", "onNewIntent", "(Lcom/avito/android/user_advert/advert/DetailsId;Ljava/lang/String;ZZ)V", VKApiConst.POSITION, "onGalleryResult", "needToUpdate", "errorMessage", "onActivateResult", "(ZLjava/lang/String;)V", "onRefresh", "detachView", "Lcom/avito/android/user_advert/advert/MyAdvertRouter;", "router", "attachRouter", "(Lcom/avito/android/user_advert/advert/MyAdvertRouter;)V", "detachRouter", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "onDeepLinkClick", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "Lcom/avito/android/user_advert/advert/switcher_block/AdvertLoadListener;", "advertLoadListener", "addAdvertLoadListener", "(Lcom/avito/android/user_advert/advert/switcher_block/AdvertLoadListener;)V", "removeAdvertLoadListener", "invokeAction", "Lcom/avito/android/permissions/PermissionState;", "result", "onCallPermissionResult", "(Lcom/avito/android/permissions/PermissionState;)V", "Lcom/avito/android/remote/model/CloseReason;", "reason", "newPrice", "onCloseReasonChosen", "(Lcom/avito/android/remote/model/CloseReason;Ljava/lang/String;)V", "Lkotlin/Function1;", "Lcom/avito/android/user_advert/advert/MyAdvertDetailsItem;", "Lkotlin/ParameterName;", "name", "advert", "Lcom/avito/android/remote/model/adverts/MyAdvertDetails$Switcher;", "getSwitcher", "isEnabled", "updateSwitcherValue", "(Lkotlin/jvm/functions/Function1;Z)V", "setParentResult", "showAppRater", "showAdditionalDialogs", "(Lcom/avito/android/user_advert/advert/MyAdvertDetailsPresenter$ProcessedAction;Z)V", "onAdvertStatusChanged", "(Ljava/lang/String;)V", "onActivationError", "Landroid/net/Uri;", "url", "onContractButtonClicked", "(Landroid/net/Uri;)V", "onVerificationButtonClicked", "onSupportButtonClicked", "postAction", "onEditResult", "onFeesResult", "onBackPressed", "item", AuthSource.BOOKING_ORDER, "(Lcom/avito/android/user_advert/advert/MyAdvertDetailsItem;Lcom/avito/android/user_advert/advert/MyAdvertDetailsPresenter$ProcessedAction;Z)V", "block", "l", "(Lkotlin/jvm/functions/Function1;)V", "isAutomatic", "Lio/reactivex/rxjava3/core/Flowable;", "e", "(Lcom/avito/android/deep_linking/links/DeepLink;Z)Lio/reactivex/rxjava3/core/Flowable;", BookingInfoActivity.EXTRA_ITEM_ID, "i", "(Ljava/lang/String;)Lio/reactivex/rxjava3/core/Flowable;", "message", "j", "reasonId", "Lcom/avito/android/remote/model/SuccessResult;", "resultHandler", "Lio/reactivex/rxjava3/core/Single;", "k", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)Lio/reactivex/rxjava3/core/Single;", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/error/TypedError;", "error", "d", "(Lcom/avito/android/remote/error/TypedError;)V", "Lcom/avito/android/remote/model/Action;", "advertAction", a2.g.r.g.a, "(Lcom/avito/android/remote/model/Action;)Z", "Lcom/avito/android/user_advert/advert/MyAdvertRouter;", "Lcom/avito/android/user_advert/contact/MyAdvertContactsPresenter;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/avito/android/user_advert/contact/MyAdvertContactsPresenter;", "contactsPresenter", "Lcom/avito/android/user_advert/advert/MyAdvertDetailsInteractor;", "y", "Lcom/avito/android/user_advert/advert/MyAdvertDetailsInteractor;", "interactor", "", AuthSource.OPEN_CHANNEL_LIST, "Ljava/util/Set;", "advertLoadListeners", "o", "Z", "shouldOpenActivateDialog", "Lcom/avito/android/util/SchedulersFactory3;", "u", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/avito/android/user_advert/advert/MyAdvertDetailsResourceProvider;", "G", "Lcom/avito/android/user_advert/advert/MyAdvertDetailsResourceProvider;", "resourceProvider", "I", "parentResult", "Lcom/avito/android/user_adverts_common/safety/SafetyInfoProvider;", ExifInterface.LONGITUDE_WEST, "Lcom/avito/android/user_adverts_common/safety/SafetyInfoProvider;", "safetyInfoProvider", "Lcom/avito/android/analytics/bivrost/BivrostTutorialSessionStorage;", "Y", "Lcom/avito/android/analytics/bivrost/BivrostTutorialSessionStorage;", "bivrostTutorialStorage", "Ljava/lang/String;", "resultMessage", "Lcom/avito/android/analytics/Analytics;", "C", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/jakewharton/rxrelay3/Relay;", "Lcom/avito/android/remote/model/MyAdvertSafeDeal;", "L", "Lcom/jakewharton/rxrelay3/Relay;", "safeDealServicesConsumer", "Lcom/avito/android/server_time/TimeSource;", "N", "Lcom/avito/android/server_time/TimeSource;", "timeSource", "Lcom/avito/android/advert_core/car_market_price/price_chart/CarMarketPriceChartPresenter;", "b0", "Lcom/avito/android/advert_core/car_market_price/price_chart/CarMarketPriceChartPresenter;", "carMarketPriceChartPresenter", "Lio/reactivex/rxjava3/disposables/Disposable;", "f", "Lio/reactivex/rxjava3/disposables/Disposable;", "loadingDisposable", "Lcom/avito/android/account/AccountStateProvider;", "X", "Lcom/avito/android/account/AccountStateProvider;", "accountStateProvider", "Lcom/avito/android/user_advert/advert/MyAdvertStorage;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lcom/avito/android/user_advert/advert/MyAdvertStorage;", "myAdvertStorage", "Lcom/jakewharton/rxrelay3/PublishRelay;", "Lcom/avito/android/remote/model/AdvertDeliveryC2C;", "J", "Lcom/jakewharton/rxrelay3/PublishRelay;", "advertDeliveryConsumer", "s", "shouldFinishAfterActivation", "secondaryContentLoadOk", "Lcom/avito/android/util/ErrorFormatter;", "Lcom/avito/android/util/ErrorFormatter;", "errorFormatter", "Lcom/avito/android/permissions/PermissionStorage;", "T", "Lcom/avito/android/permissions/PermissionStorage;", "permissionStorage", "Lcom/avito/android/remote/model/AdvertSellerShortTermRent;", "K", "termRentConsumer", "Lcom/avito/android/advert_core/car_market_price/badge/AdvertDetailsImvBadgePresenter;", "Lcom/avito/android/advert_core/car_market_price/badge/AdvertDetailsImvBadgePresenter;", "imvBadgePresenter", "c", "Lcom/avito/android/user_advert/advert/MyAdvertDetailsItem;", "Lcom/avito/android/user_advert/advert/MyAdvertDetailsActionMenuConverter;", VKApiConst.VERSION, "Lcom/avito/android/user_advert/advert/MyAdvertDetailsActionMenuConverter;", "actionMenuConverter", "Lcom/avito/android/Features;", "F", "Lcom/avito/android/Features;", "features", "h", "advertActivateDialogWasShown", "p", "Landroid/content/ClipboardManager;", "D", "Landroid/content/ClipboardManager;", "clipboardManager", "Lcom/avito/android/user_advert/advert/verification/VerificationItemConverter;", "Q", "Lcom/avito/android/user_advert/advert/verification/VerificationItemConverter;", "verificationItemConverter", "Lcom/avito/android/util/ClipDataFactory;", ExifInterface.LONGITUDE_EAST, "Lcom/avito/android/util/ClipDataFactory;", "clipboardFactory", "r", "shouldOpenUserAdverts", "Lcom/avito/android/user_advert/advert/AdvertAddressFormatter;", "w", "Lcom/avito/android/user_advert/advert/AdvertAddressFormatter;", "addressProvider", "Lcom/avito/android/permissions/PermissionStateProvider;", "U", "Lcom/avito/android/permissions/PermissionStateProvider;", "permissionStateProvider", "Lcom/avito/android/user_advert/advert/MyAdvertDetailsView;", "t", "Lcom/avito/android/user_advert/advert/MyDraftAdvertDetailsInteractor;", "z", "Lcom/avito/android/user_advert/advert/MyDraftAdvertDetailsInteractor;", "draftInteractor", "Lcom/avito/android/advert_core/car_market_price/price_description/CarMarketPriceDescriptionPresenter;", "c0", "Lcom/avito/android/advert_core/car_market_price/price_description/CarMarketPriceDescriptionPresenter;", "carMarketPriceDescriptionPresenter", "Lcom/avito/android/user_advert/advert/MyAdvertDetailsConverter;", "x", "Lcom/avito/android/user_advert/advert/MyAdvertDetailsConverter;", "itemConverter", "statusShown", "Lcom/avito/android/app_rater/AppRaterInteractor;", "M", "Lcom/avito/android/app_rater/AppRaterInteractor;", "appRaterInteractor", "n", "Lcom/avito/android/user_advert/advert/DetailsId;", "detailsId", "Lcom/avito/android/user_adverts_common/charity/CharityInteractor;", "R", "Lcom/avito/android/user_adverts_common/charity/CharityInteractor;", "charityInteractor", "Lcom/avito/android/advert_core/social/SocialPresenter;", "B", "Lcom/avito/android/advert_core/social/SocialPresenter;", "socialPresenter", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "subscriptions", "Lcom/avito/android/date_time_formatter/DateTimeFormatter;", "H", "Lcom/avito/android/date_time_formatter/DateTimeFormatter;", "dateFormatter", "Lcom/avito/android/user_advert/tracker/MyAdvertDetailsTracker;", "O", "Lcom/avito/android/user_advert/tracker/MyAdvertDetailsTracker;", "tracker", "mainContentLoadOk", "Lcom/avito/android/user_advert/limits_info/LimitsInfoInteractor;", ExifInterface.LATITUDE_SOUTH, "Lcom/avito/android/user_advert/limits_info/LimitsInfoInteractor;", "limitsInfoInteractor", VKApiConst.Q, "restoreAdvert", "Lcom/avito/android/user_advert/advert/feature_teasers/MyAdvertDetailsFeatureTeaserPresenter;", "P", "Lcom/avito/android/user_advert/advert/feature_teasers/MyAdvertDetailsFeatureTeaserPresenter;", "featureTeasersPresenter", "Lcom/avito/android/advert_core/car_market_price/badge/AdvertDetailsImvBadgeItemConverter;", "a0", "Lcom/avito/android/advert_core/car_market_price/badge/AdvertDetailsImvBadgeItemConverter;", "imvBadgeItemConverter", "state", "<init>", "(Lcom/avito/android/user_advert/advert/DetailsId;ZZZZZLjava/lang/String;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/user_advert/advert/MyAdvertDetailsActionMenuConverter;Lcom/avito/android/user_advert/advert/AdvertAddressFormatter;Lcom/avito/android/user_advert/advert/MyAdvertDetailsConverter;Lcom/avito/android/user_advert/advert/MyAdvertDetailsInteractor;Lcom/avito/android/user_advert/advert/MyDraftAdvertDetailsInteractor;Lcom/avito/android/user_advert/contact/MyAdvertContactsPresenter;Lcom/avito/android/advert_core/social/SocialPresenter;Lcom/avito/android/analytics/Analytics;Landroid/content/ClipboardManager;Lcom/avito/android/util/ClipDataFactory;Lcom/avito/android/Features;Lcom/avito/android/user_advert/advert/MyAdvertDetailsResourceProvider;Lcom/avito/android/date_time_formatter/DateTimeFormatter;Lcom/avito/android/util/ErrorFormatter;Lcom/jakewharton/rxrelay3/PublishRelay;Lcom/jakewharton/rxrelay3/PublishRelay;Lcom/jakewharton/rxrelay3/Relay;Lcom/avito/android/app_rater/AppRaterInteractor;Lcom/avito/android/server_time/TimeSource;Lcom/avito/android/user_advert/tracker/MyAdvertDetailsTracker;Lcom/avito/android/user_advert/advert/feature_teasers/MyAdvertDetailsFeatureTeaserPresenter;Lcom/avito/android/user_advert/advert/verification/VerificationItemConverter;Lcom/avito/android/user_adverts_common/charity/CharityInteractor;Lcom/avito/android/user_advert/limits_info/LimitsInfoInteractor;Lcom/avito/android/permissions/PermissionStorage;Lcom/avito/android/permissions/PermissionStateProvider;Lcom/avito/android/user_advert/advert/MyAdvertStorage;Lcom/avito/android/user_adverts_common/safety/SafetyInfoProvider;Lcom/avito/android/account/AccountStateProvider;Lcom/avito/android/analytics/bivrost/BivrostTutorialSessionStorage;Lcom/avito/android/advert_core/car_market_price/badge/AdvertDetailsImvBadgePresenter;Lcom/avito/android/advert_core/car_market_price/badge/AdvertDetailsImvBadgeItemConverter;Lcom/avito/android/advert_core/car_market_price/price_chart/CarMarketPriceChartPresenter;Lcom/avito/android/advert_core/car_market_price/price_description/CarMarketPriceDescriptionPresenter;Ljava/lang/String;Lcom/avito/android/util/Kundle;)V", "user-advert_release"}, k = 1, mv = {1, 4, 2})
public final class MyAdvertDetailsPresenterImpl implements MyAdvertDetailsPresenter {
    public final MyAdvertContactsPresenter A;
    public final SocialPresenter B;
    public final Analytics C;
    public final ClipboardManager D;
    public final ClipDataFactory E;
    public final Features F;
    public final MyAdvertDetailsResourceProvider G;
    public final DateTimeFormatter H;
    public final ErrorFormatter I;
    public final PublishRelay<AdvertDeliveryC2C> J;
    public final PublishRelay<AdvertSellerShortTermRent> K;
    public final Relay<MyAdvertSafeDeal> L;
    public final AppRaterInteractor M;
    public final TimeSource N;
    public final MyAdvertDetailsTracker O;
    public final MyAdvertDetailsFeatureTeaserPresenter P;
    public final VerificationItemConverter Q;
    public final CharityInteractor R;
    public final LimitsInfoInteractor S;
    public final PermissionStorage T;
    public final PermissionStateProvider U;
    public final MyAdvertStorage V;
    public final SafetyInfoProvider W;
    public final AccountStateProvider X;
    public final BivrostTutorialSessionStorage Y;
    public final AdvertDetailsImvBadgePresenter Z;
    public MyAdvertRouter a;
    public final AdvertDetailsImvBadgeItemConverter a0;
    public MyAdvertDetailsView b;
    public final CarMarketPriceChartPresenter b0;
    public MyAdvertDetailsItem c;
    public final CarMarketPriceDescriptionPresenter c0;
    public String d;
    public final CompositeDisposable e;
    public Disposable f;
    public int g;
    public boolean h;
    public String i;
    public boolean j;
    public boolean k;
    public boolean l;
    public final Set<AdvertLoadListener> m;
    public DetailsId n;
    public final boolean o;
    public boolean p;
    public final boolean q;
    public final boolean r;
    public final boolean s;
    public String t;
    public final SchedulersFactory3 u;
    public final MyAdvertDetailsActionMenuConverter v;
    public final AdvertAddressFormatter w;
    public final MyAdvertDetailsConverter x;
    public final MyAdvertDetailsInteractor y;
    public final MyDraftAdvertDetailsInteractor z;

    /* compiled from: java-style lambda group */
    public static final class a<T> implements Consumer<Throwable> {
        public static final a b = new a(0);
        public static final a c = new a(1);
        public final /* synthetic */ int a;

        public a(int i) {
            this.a = i;
        }

        @Override // io.reactivex.rxjava3.functions.Consumer
        public final void accept(Throwable th) {
            int i = this.a;
            if (i == 0) {
                Logs.error("Failed to stop advert", th);
            } else if (i == 1) {
                Logs.error("Failed to set advert price", th);
            } else {
                throw null;
            }
        }
    }

    /* compiled from: java-style lambda group */
    public static final class b<V> implements Callable<Unit> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;
        public final /* synthetic */ Object c;

        public b(int i, Object obj, Object obj2) {
            this.a = i;
            this.b = obj;
            this.c = obj2;
        }

        @Override // java.util.concurrent.Callable
        public final Unit call() {
            int i = this.a;
            if (i == 0) {
                MyAdvertDetailsPresenterImpl.access$trackEditActivationEvent((MyAdvertDetailsPresenterImpl) this.b, (MyAdvertLink.Edit) ((DeepLink) this.c));
                MyAdvertRouter myAdvertRouter = ((MyAdvertDetailsPresenterImpl) this.b).a;
                if (myAdvertRouter == null) {
                    return null;
                }
                MyAdvertRouter.DefaultImpls.openEdit$default(myAdvertRouter, ((MyAdvertLink.Edit) ((DeepLink) this.c)).getItemId(), ((MyAdvertLink.Edit) ((DeepLink) this.c)).getPostAction(), null, 4, null);
                return Unit.INSTANCE;
            } else if (i == 1) {
                MyAdvertRouter myAdvertRouter2 = ((MyAdvertDetailsPresenterImpl) this.b).a;
                if (myAdvertRouter2 == null) {
                    return null;
                }
                myAdvertRouter2.openDraftEdit(((DraftPublicationLink) ((DeepLink) this.c)).getDraftId());
                return Unit.INSTANCE;
            } else if (i == 2) {
                MyAdvertRouter myAdvertRouter3 = ((MyAdvertDetailsPresenterImpl) this.b).a;
                if (myAdvertRouter3 == null) {
                    return null;
                }
                myAdvertRouter3.openDeepLink((DeepLink) this.c);
                return Unit.INSTANCE;
            } else {
                throw null;
            }
        }
    }

    /* compiled from: java-style lambda group */
    public static final class c<T> implements Consumer<Unit> {
        public static final c b = new c(0);
        public static final c c = new c(1);
        public final /* synthetic */ int a;

        public c(int i) {
            this.a = i;
        }

        @Override // io.reactivex.rxjava3.functions.Consumer
        public final void accept(Unit unit) {
            int i = this.a;
            if (i == 0) {
                return;
            }
            if (i != 1) {
                throw null;
            }
        }
    }

    /* compiled from: kotlin-style lambda group */
    public static final class d extends Lambda implements Function0<Single<Boolean>> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;
        public final /* synthetic */ Object c;
        public final /* synthetic */ Object d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(int i, Object obj, Object obj2, Object obj3) {
            super(0);
            this.a = i;
            this.b = obj;
            this.c = obj2;
            this.d = obj3;
        }

        @Override // kotlin.jvm.functions.Function0
        public final Single<Boolean> invoke() {
            int i = this.a;
            if (i == 0) {
                return MyAdvertDetailsPresenterImpl.access$showSecurityDialog((MyAdvertDetailsPresenterImpl) this.b, ((MyAdvertDetailsItem) this.c).getCategoryId(), ((MyAdvertDetailsItem) this.c).getStatus(), (MyAdvertDetailsPresenter.ProcessedAction) this.d);
            }
            if (i == 1) {
                return MyAdvertDetailsPresenterImpl.access$showCharityDialog((MyAdvertDetailsPresenterImpl) this.b, ((MyAdvertDetailsItem) this.c).getId(), ((MyAdvertDetailsItem) this.c).getStatus(), (MyAdvertDetailsPresenter.ProcessedAction) this.d);
            }
            throw null;
        }
    }

    public static final class e<T> implements Consumer<LoadingState<? super ItemActivateResponse>> {
        public final /* synthetic */ MyAdvertDetailsPresenterImpl a;
        public final /* synthetic */ String b;

        public e(MyAdvertDetailsPresenterImpl myAdvertDetailsPresenterImpl, String str) {
            this.a = myAdvertDetailsPresenterImpl;
            this.b = str;
        }

        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(LoadingState<? super ItemActivateResponse> loadingState) {
            MyAdvertRouter myAdvertRouter;
            LoadingState<? super ItemActivateResponse> loadingState2 = loadingState;
            if (loadingState2 instanceof LoadingState.Loaded) {
                LoadingState.Loaded loaded = (LoadingState.Loaded) loadingState2;
                if (((ItemActivateResponse) loaded.getData()).getSuccess()) {
                    MyAdvertDetailsPresenterImpl.access$activate(this.a, new SuccessResult(((ItemActivateResponse) loaded.getData()).getMessage()));
                    return;
                }
                DeepLink deepLink = ((ItemActivateResponse) loaded.getData()).getDeepLink();
                if (deepLink != null && (myAdvertRouter = this.a.a) != null) {
                    myAdvertRouter.openDeepLink(deepLink);
                }
            } else if (loadingState2 instanceof LoadingState.Error) {
                MyAdvertDetailsPresenterImpl.access$handleError(this.a, (LoadingState.Error) loadingState2, this.b);
            }
        }
    }

    public static final class f<T, R> implements Function<LoadingState<? super ItemActivateResponse>, Unit> {
        public static final f a = new f();

        @Override // io.reactivex.rxjava3.functions.Function
        public Unit apply(LoadingState<? super ItemActivateResponse> loadingState) {
            return Unit.INSTANCE;
        }
    }

    public static final class g<T> implements Consumer<Unit> {
        public static final g a = new g();

        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Unit unit) {
        }
    }

    public static final class h<T> implements Consumer<Throwable> {
        public static final h a = new h();

        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            Logs.error("Failed to handle invokeAction", th);
        }
    }

    public static final class i extends Lambda implements Function1<SuccessResult, Unit> {
        public final /* synthetic */ MyAdvertDetailsPresenterImpl a;
        public final /* synthetic */ String b;
        public final /* synthetic */ CloseReason c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public i(MyAdvertDetailsPresenterImpl myAdvertDetailsPresenterImpl, String str, CloseReason closeReason) {
            super(1);
            this.a = myAdvertDetailsPresenterImpl;
            this.b = str;
            this.c = closeReason;
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(SuccessResult successResult) {
            MyAdvertDetails.Price price;
            SuccessResult successResult2 = successResult;
            Intrinsics.checkNotNullParameter(successResult2, "stopAdvertResult");
            this.a.d = successResult2.getMessage();
            MyAdvertDetailsPresenterImpl myAdvertDetailsPresenterImpl = this.a;
            String str = this.b;
            Boolean showAppRater = this.c.getShowAppRater();
            MyAdvertDetailsPresenterImpl myAdvertDetailsPresenterImpl2 = this.a;
            MyAdvertDetailsItem myAdvertDetailsItem = myAdvertDetailsPresenterImpl2.c;
            String value = (myAdvertDetailsItem == null || (price = myAdvertDetailsItem.getPrice()) == null) ? null : price.getValue();
            if (value == null) {
                value = "";
            }
            MyAdvertDetailsPresenterImpl.access$onAdvertDeactivated(myAdvertDetailsPresenterImpl, str, null, showAppRater, MyAdvertDetailsPresenterImpl.access$formatPriceIncrement(myAdvertDetailsPresenterImpl2, value, this.c.getShouldUpdateIncome()));
            return Unit.INSTANCE;
        }
    }

    public static final class j<T, R> implements Function<LoadingState<? super SimpleMessageResult>, SingleSource<? extends Unit>> {
        public final /* synthetic */ MyAdvertDetailsPresenterImpl a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ CloseReason d;
        public final /* synthetic */ String e;

        public j(MyAdvertDetailsPresenterImpl myAdvertDetailsPresenterImpl, String str, String str2, CloseReason closeReason, String str3) {
            this.a = myAdvertDetailsPresenterImpl;
            this.b = str;
            this.c = str2;
            this.d = closeReason;
            this.e = str3;
        }

        @Override // io.reactivex.rxjava3.functions.Function
        public SingleSource<? extends Unit> apply(LoadingState<? super SimpleMessageResult> loadingState) {
            String str;
            MyAdvertDetails.Price price;
            boolean z = loadingState instanceof LoadingState.Loaded;
            if (z) {
                str = this.b;
            } else {
                MyAdvertDetailsItem myAdvertDetailsItem = this.a.c;
                str = (myAdvertDetailsItem == null || (price = myAdvertDetailsItem.getPrice()) == null) ? null : price.getValue();
                if (str == null) {
                    str = "";
                }
            }
            return this.a.k(this.c, this.d.getId(), new d0(this, z, str));
        }
    }

    public static final class k<T> implements Consumer<Unit> {
        public static final k a = new k();

        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Unit unit) {
        }
    }

    public static final class l<T> implements Consumer<Throwable> {
        public static final l a = new l();

        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            Logs.error("Failed to handle invokeAction", th);
        }
    }

    public static final class m<T> implements Consumer<MyAdvertDetails> {
        public final /* synthetic */ MyAdvertDetailsPresenterImpl a;
        public final /* synthetic */ MyAdvertDetailsPresenter.ProcessedAction b;
        public final /* synthetic */ boolean c;

        public m(MyAdvertDetailsPresenterImpl myAdvertDetailsPresenterImpl, MyAdvertDetailsPresenter.ProcessedAction processedAction, boolean z) {
            this.a = myAdvertDetailsPresenterImpl;
            this.b = processedAction;
            this.c = z;
        }

        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(MyAdvertDetails myAdvertDetails) {
            MyAdvertDetails myAdvertDetails2 = myAdvertDetails;
            this.a.O.trackAdvertLoaded();
            this.a.O.startAdvertPreparing();
            MyAdvertDetailsConverter myAdvertDetailsConverter = this.a.x;
            Intrinsics.checkNotNullExpressionValue(myAdvertDetails2, "it");
            MyAdvertDetailsItem convert = myAdvertDetailsConverter.convert(myAdvertDetails2);
            for (T t : this.a.m) {
                t.onAdvertLoaded(convert);
            }
            this.a.c = convert;
            this.a.b(convert, this.b, this.c);
            this.a.O.trackAdvertPreparing();
            this.a.O.startAdvertDraw();
            MyAdvertDetailsPresenterImpl.access$showMainContent(this.a);
            this.a.O.trackAdvertDraw();
        }
    }

    public static final class n<T> implements Consumer<Throwable> {
        public final /* synthetic */ MyAdvertDetailsPresenterImpl a;

        public n(MyAdvertDetailsPresenterImpl myAdvertDetailsPresenterImpl) {
            this.a = myAdvertDetailsPresenterImpl;
        }

        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            Throwable th2 = th;
            this.a.O.trackAdvertLoadError();
            this.a.O.startAdvertDraw();
            e0 e0Var = new e0(this, th2);
            if (Throwables.isAuthProblem(th2)) {
                MyAdvertDetailsPresenterImpl.access$showLoadingProblem(this.a);
                MyAdvertRouter myAdvertRouter = this.a.a;
                if (myAdvertRouter != null) {
                    myAdvertRouter.openAuth();
                }
            } else if (Throwables.isNotFoundError(th2)) {
                DetailsId detailsId = this.a.n;
                if (detailsId instanceof AdvertId) {
                    MyAdvertRouter myAdvertRouter2 = this.a.a;
                    if (myAdvertRouter2 != null) {
                        myAdvertRouter2.showInactiveItem(((AdvertId) detailsId).getAdvertId());
                    }
                } else if (detailsId instanceof DraftId) {
                    e0Var.invoke();
                }
            } else {
                e0Var.invoke();
            }
            this.a.O.trackAdvertErrorDraw();
        }
    }

    public static final class o<T> implements Consumer<LoadingState<? super RestoreAdvertResult>> {
        public final /* synthetic */ MyAdvertDetailsPresenterImpl a;

        public o(MyAdvertDetailsPresenterImpl myAdvertDetailsPresenterImpl) {
            this.a = myAdvertDetailsPresenterImpl;
        }

        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(LoadingState<? super RestoreAdvertResult> loadingState) {
            LoadingState<? super RestoreAdvertResult> loadingState2 = loadingState;
            if (loadingState2 instanceof LoadingState.Loaded) {
                RestoreAdvertResult restoreAdvertResult = (RestoreAdvertResult) ((LoadingState.Loaded) loadingState2).getData();
                if (restoreAdvertResult instanceof RestoreAdvertResult.Ok) {
                    this.a.O.trackRestoreAdvertLoading();
                    this.a.O.startRestoreAdvertDraw();
                    this.a.g = 10;
                    this.a.j(((RestoreAdvertResult.Ok) restoreAdvertResult).getMessage());
                    MyAdvertDetailsPresenterImpl.c(this.a, null, false, null, null, 15);
                    MyAdvertRouter myAdvertRouter = this.a.a;
                    if (myAdvertRouter != null) {
                        myAdvertRouter.reopenScreen();
                    }
                    this.a.O.trackRestoreAdvertDraw();
                } else if (restoreAdvertResult instanceof RestoreAdvertResult.Forbidden) {
                    this.a.O.trackRestoreAdvertLoadingError();
                    this.a.O.startRestoreAdvertDraw();
                    MyAdvertDetailsView myAdvertDetailsView = this.a.b;
                    if (myAdvertDetailsView != null) {
                        myAdvertDetailsView.showError(((RestoreAdvertResult.Forbidden) restoreAdvertResult).getMessage());
                    }
                    this.a.O.trackRestoreAdvertDrawError();
                }
            } else if (loadingState2 instanceof LoadingState.Error) {
                this.a.O.trackRestoreAdvertLoadingError();
                this.a.O.startRestoreAdvertDraw();
                this.a.d(((LoadingState.Error) loadingState2).getError());
                this.a.O.trackRestoreAdvertDrawError();
            }
        }
    }

    public static final class p<T, R> implements Function<LoadingState<? super RestoreAdvertResult>, Unit> {
        public static final p a = new p();

        @Override // io.reactivex.rxjava3.functions.Function
        public Unit apply(LoadingState<? super RestoreAdvertResult> loadingState) {
            return Unit.INSTANCE;
        }
    }

    public static final class q extends Lambda implements Function2<Single<Boolean>, Function0<? extends Single<Boolean>>, Single<Boolean>> {
        public static final q a = new q();

        public static final class a<T, R> implements Function<Boolean, SingleSource<? extends Boolean>> {
            public final /* synthetic */ Function0 a;

            public a(Function0 function0) {
                this.a = function0;
            }

            @Override // io.reactivex.rxjava3.functions.Function
            public SingleSource<? extends Boolean> apply(Boolean bool) {
                Boolean bool2 = bool;
                Intrinsics.checkNotNullExpressionValue(bool2, "wasShown");
                return bool2.booleanValue() ? Single.just(Boolean.TRUE) : (Single) this.a.invoke();
            }
        }

        public q() {
            super(2);
        }

        /* renamed from: a */
        public final Single<Boolean> invoke(@NotNull Single<Boolean> single, @NotNull Function0<? extends Single<Boolean>> function0) {
            Intrinsics.checkNotNullParameter(single, "$this$or");
            Intrinsics.checkNotNullParameter(function0, "other");
            return single.flatMap(new a(function0));
        }
    }

    public static final class r extends Lambda implements Function0<Single<Boolean>> {
        public final /* synthetic */ MyAdvertDetailsPresenterImpl a;
        public final /* synthetic */ MyAdvertDetailsItem b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public r(MyAdvertDetailsPresenterImpl myAdvertDetailsPresenterImpl, MyAdvertDetailsItem myAdvertDetailsItem) {
            super(0);
            this.a = myAdvertDetailsPresenterImpl;
            this.b = myAdvertDetailsItem;
        }

        @Override // kotlin.jvm.functions.Function0
        public Single<Boolean> invoke() {
            return MyAdvertDetailsPresenterImpl.access$showCallPermissionIfNeeded(this.a, this.b.getId(), this.b.getAnonymousNumber());
        }
    }

    public static final class s extends Lambda implements Function0<Single<Boolean>> {
        public final /* synthetic */ MyAdvertDetailsPresenterImpl a;
        public final /* synthetic */ boolean b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public s(MyAdvertDetailsPresenterImpl myAdvertDetailsPresenterImpl, boolean z) {
            super(0);
            this.a = myAdvertDetailsPresenterImpl;
            this.b = z;
        }

        @Override // kotlin.jvm.functions.Function0
        public Single<Boolean> invoke() {
            return MyAdvertDetailsPresenterImpl.access$showAppRater(this.a, this.b);
        }
    }

    public static final class t<T> implements Consumer<Boolean> {
        public static final t a = new t();

        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Boolean bool) {
        }
    }

    public static final class u<T> implements Consumer<Throwable> {
        public static final u a = new u();

        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            Logs.error("Failed to show dialog", th);
        }
    }

    public static final class v<T> implements Consumer<LoadingState<? super SuccessResult>> {
        public final /* synthetic */ MyAdvertDetailsPresenterImpl a;
        public final /* synthetic */ Function1 b;

        public v(MyAdvertDetailsPresenterImpl myAdvertDetailsPresenterImpl, Function1 function1) {
            this.a = myAdvertDetailsPresenterImpl;
            this.b = function1;
        }

        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(LoadingState<? super SuccessResult> loadingState) {
            LoadingState<? super SuccessResult> loadingState2 = loadingState;
            if (loadingState2 instanceof LoadingState.Loaded) {
                this.a.O.trackDeactivateAdvertLoading();
                this.a.O.startDeactivateAdvertDraw();
                this.b.invoke(((LoadingState.Loaded) loadingState2).getData());
                this.a.O.trackDeactivateAdvertDraw();
            } else if (loadingState2 instanceof LoadingState.Error) {
                this.a.O.trackDeactivateAdvertLoadingError();
                this.a.O.startDeactivateAdvertDraw();
                this.a.d(((LoadingState.Error) loadingState2).getError());
                this.a.O.trackDeactivateAdvertDrawError();
            }
        }
    }

    public static final class w<T, R> implements Function<LoadingState<? super SuccessResult>, Unit> {
        public static final w a = new w();

        @Override // io.reactivex.rxjava3.functions.Function
        public Unit apply(LoadingState<? super SuccessResult> loadingState) {
            return Unit.INSTANCE;
        }
    }

    @Inject
    public MyAdvertDetailsPresenterImpl(@NotNull DetailsId detailsId, @ShouldOpenActivateDialog boolean z2, @IsNewAdvert boolean z3, @RestoreAdvert boolean z4, @ShouldOpenUserAdverts boolean z5, @ShouldFinishAfterActivation boolean z7, @ErrorMessage @Nullable String str, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull MyAdvertDetailsActionMenuConverter myAdvertDetailsActionMenuConverter, @NotNull AdvertAddressFormatter advertAddressFormatter, @NotNull MyAdvertDetailsConverter myAdvertDetailsConverter, @NotNull MyAdvertDetailsInteractor myAdvertDetailsInteractor, @NotNull MyDraftAdvertDetailsInteractor myDraftAdvertDetailsInteractor, @NotNull MyAdvertContactsPresenter myAdvertContactsPresenter, @NotNull SocialPresenter socialPresenter, @NotNull Analytics analytics, @NotNull ClipboardManager clipboardManager, @NotNull ClipDataFactory clipDataFactory, @NotNull Features features, @NotNull MyAdvertDetailsResourceProvider myAdvertDetailsResourceProvider, @DateTimeFormatterModule.LowerCase @NotNull DateTimeFormatter dateTimeFormatter, @NotNull ErrorFormatter errorFormatter, @AdvertDeliveryBlockDataObservable @NotNull PublishRelay<AdvertDeliveryC2C> publishRelay, @AdvertSellerShortTermRentObservable @NotNull PublishRelay<AdvertSellerShortTermRent> publishRelay2, @MyAdvertSafeDealServicesObservable @NotNull Relay<MyAdvertSafeDeal> relay, @NotNull AppRaterInteractor appRaterInteractor, @NotNull TimeSource timeSource, @NotNull MyAdvertDetailsTracker myAdvertDetailsTracker, @NotNull MyAdvertDetailsFeatureTeaserPresenter myAdvertDetailsFeatureTeaserPresenter, @NotNull VerificationItemConverter verificationItemConverter, @NotNull CharityInteractor charityInteractor, @NotNull LimitsInfoInteractor limitsInfoInteractor, @NotNull PermissionStorage permissionStorage, @NotNull PermissionStateProvider permissionStateProvider, @NotNull MyAdvertStorage myAdvertStorage, @NotNull SafetyInfoProvider safetyInfoProvider, @NotNull AccountStateProvider accountStateProvider, @NotNull BivrostTutorialSessionStorage bivrostTutorialSessionStorage, @NotNull AdvertDetailsImvBadgePresenter advertDetailsImvBadgePresenter, @NotNull AdvertDetailsImvBadgeItemConverter advertDetailsImvBadgeItemConverter, @NotNull CarMarketPriceChartPresenter carMarketPriceChartPresenter, @NotNull CarMarketPriceDescriptionPresenter carMarketPriceDescriptionPresenter, @StatusMessage @Nullable String str2, @Nullable Kundle kundle) {
        String str3;
        Boolean bool;
        Integer num;
        Intrinsics.checkNotNullParameter(detailsId, "detailsId");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(myAdvertDetailsActionMenuConverter, "actionMenuConverter");
        Intrinsics.checkNotNullParameter(advertAddressFormatter, "addressProvider");
        Intrinsics.checkNotNullParameter(myAdvertDetailsConverter, "itemConverter");
        Intrinsics.checkNotNullParameter(myAdvertDetailsInteractor, "interactor");
        Intrinsics.checkNotNullParameter(myDraftAdvertDetailsInteractor, "draftInteractor");
        Intrinsics.checkNotNullParameter(myAdvertContactsPresenter, "contactsPresenter");
        Intrinsics.checkNotNullParameter(socialPresenter, "socialPresenter");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(clipboardManager, "clipboardManager");
        Intrinsics.checkNotNullParameter(clipDataFactory, "clipboardFactory");
        Intrinsics.checkNotNullParameter(features, "features");
        Intrinsics.checkNotNullParameter(myAdvertDetailsResourceProvider, "resourceProvider");
        Intrinsics.checkNotNullParameter(dateTimeFormatter, "dateFormatter");
        Intrinsics.checkNotNullParameter(errorFormatter, "errorFormatter");
        Intrinsics.checkNotNullParameter(publishRelay, "advertDeliveryConsumer");
        Intrinsics.checkNotNullParameter(publishRelay2, "termRentConsumer");
        Intrinsics.checkNotNullParameter(relay, "safeDealServicesConsumer");
        Intrinsics.checkNotNullParameter(appRaterInteractor, "appRaterInteractor");
        Intrinsics.checkNotNullParameter(timeSource, "timeSource");
        Intrinsics.checkNotNullParameter(myAdvertDetailsTracker, "tracker");
        Intrinsics.checkNotNullParameter(myAdvertDetailsFeatureTeaserPresenter, "featureTeasersPresenter");
        Intrinsics.checkNotNullParameter(verificationItemConverter, "verificationItemConverter");
        Intrinsics.checkNotNullParameter(charityInteractor, "charityInteractor");
        Intrinsics.checkNotNullParameter(limitsInfoInteractor, "limitsInfoInteractor");
        Intrinsics.checkNotNullParameter(permissionStorage, "permissionStorage");
        Intrinsics.checkNotNullParameter(permissionStateProvider, "permissionStateProvider");
        Intrinsics.checkNotNullParameter(myAdvertStorage, "myAdvertStorage");
        Intrinsics.checkNotNullParameter(safetyInfoProvider, "safetyInfoProvider");
        Intrinsics.checkNotNullParameter(accountStateProvider, "accountStateProvider");
        Intrinsics.checkNotNullParameter(bivrostTutorialSessionStorage, "bivrostTutorialStorage");
        Intrinsics.checkNotNullParameter(advertDetailsImvBadgePresenter, "imvBadgePresenter");
        Intrinsics.checkNotNullParameter(advertDetailsImvBadgeItemConverter, "imvBadgeItemConverter");
        Intrinsics.checkNotNullParameter(carMarketPriceChartPresenter, "carMarketPriceChartPresenter");
        Intrinsics.checkNotNullParameter(carMarketPriceDescriptionPresenter, "carMarketPriceDescriptionPresenter");
        this.n = detailsId;
        this.o = z2;
        this.p = z3;
        this.q = z4;
        this.r = z5;
        this.s = z7;
        this.t = str;
        this.u = schedulersFactory3;
        this.v = myAdvertDetailsActionMenuConverter;
        this.w = advertAddressFormatter;
        this.x = myAdvertDetailsConverter;
        this.y = myAdvertDetailsInteractor;
        this.z = myDraftAdvertDetailsInteractor;
        this.A = myAdvertContactsPresenter;
        this.B = socialPresenter;
        this.C = analytics;
        this.D = clipboardManager;
        this.E = clipDataFactory;
        this.F = features;
        this.G = myAdvertDetailsResourceProvider;
        this.H = dateTimeFormatter;
        this.I = errorFormatter;
        this.J = publishRelay;
        this.K = publishRelay2;
        this.L = relay;
        this.M = appRaterInteractor;
        this.N = timeSource;
        this.O = myAdvertDetailsTracker;
        this.P = myAdvertDetailsFeatureTeaserPresenter;
        this.Q = verificationItemConverter;
        this.R = charityInteractor;
        this.S = limitsInfoInteractor;
        this.T = permissionStorage;
        this.U = permissionStateProvider;
        this.V = myAdvertStorage;
        this.W = safetyInfoProvider;
        this.X = accountStateProvider;
        this.Y = bivrostTutorialSessionStorage;
        this.Z = advertDetailsImvBadgePresenter;
        this.a0 = advertDetailsImvBadgeItemConverter;
        this.b0 = carMarketPriceChartPresenter;
        this.c0 = carMarketPriceDescriptionPresenter;
        String str4 = null;
        this.c = kundle != null ? (MyAdvertDetailsItem) kundle.getParcelable("item") : null;
        this.d = kundle != null ? kundle.getString("result_message") : null;
        this.e = new CompositeDisposable();
        boolean z8 = false;
        this.g = (kundle == null || (num = kundle.getInt("parent_activity_result")) == null) ? 0 : num.intValue();
        this.h = (kundle == null || (bool = kundle.getBoolean("activate_shown")) == null) ? false : bool.booleanValue();
        this.i = (kundle == null || (str3 = kundle.getString("key_message")) == null) ? str2 : str3;
        this.j = kundle != null ? kundle.getBoolean("key_status_shown", false) : z8;
        this.k = true;
        this.l = true;
        this.m = new LinkedHashSet();
        if (this.t == null) {
            this.t = kundle != null ? kundle.getString("error_message") : str4;
        }
    }

    public static final void access$activate(MyAdvertDetailsPresenterImpl myAdvertDetailsPresenterImpl, SuccessResult successResult) {
        MyAdvertDetailsView myAdvertDetailsView;
        myAdvertDetailsPresenterImpl.O.trackActivateAdvertLoading();
        myAdvertDetailsPresenterImpl.O.startActivateAdvertDraw();
        MyAdvertDetailsItem myAdvertDetailsItem = myAdvertDetailsPresenterImpl.c;
        if (myAdvertDetailsItem != null) {
            myAdvertDetailsItem.setStatus("active");
        }
        if (!myAdvertDetailsPresenterImpl.s) {
            String message = successResult.getMessage();
            if (!(message == null || (myAdvertDetailsView = myAdvertDetailsPresenterImpl.b) == null)) {
                myAdvertDetailsView.showSnackBar(message);
            }
            myAdvertDetailsPresenterImpl.onReinitialize(MyAdvertDetailsPresenter.ProcessedAction.Activation.INSTANCE);
        } else {
            myAdvertDetailsPresenterImpl.g = 7;
            myAdvertDetailsPresenterImpl.d = successResult.getMessage();
            if (myAdvertDetailsPresenterImpl.r) {
                AdvertActionTransferData.Type type = AdvertActionTransferData.Type.ACTIVATE;
                MyAdvertRouter myAdvertRouter = myAdvertDetailsPresenterImpl.a;
                if (myAdvertRouter != null) {
                    String str = myAdvertDetailsPresenterImpl.d;
                    MyAdvertDetailsItem myAdvertDetailsItem2 = myAdvertDetailsPresenterImpl.c;
                    myAdvertRouter.openUserAdvertsScreen(new AdvertActionTransferData(null, str, myAdvertDetailsItem2 != null ? myAdvertDetailsItem2.getCategoryId() : null, type, 1, null));
                }
                c(myAdvertDetailsPresenterImpl, null, false, null, null, 15);
            } else {
                c(myAdvertDetailsPresenterImpl, null, false, null, AdvertActionTransferData.Type.ACTIVATE, 7);
            }
        }
        myAdvertDetailsPresenterImpl.O.trackActivateAdvertDraw();
    }

    public static final String access$formatPriceIncrement(MyAdvertDetailsPresenterImpl myAdvertDetailsPresenterImpl, String str, Boolean bool) {
        Character ch;
        Objects.requireNonNull(myAdvertDetailsPresenterImpl);
        if (!Intrinsics.areEqual(bool, Boolean.TRUE)) {
            return null;
        }
        int i2 = 0;
        while (true) {
            if (i2 >= str.length()) {
                ch = null;
                break;
            }
            char charAt = str.charAt(i2);
            if (Character.isDigit(charAt)) {
                ch = Character.valueOf(charAt);
                break;
            }
            i2++;
        }
        if (ch == null || !(!Intrinsics.areEqual(str, "0"))) {
            return null;
        }
        StringBuilder Q2 = a2.b.a.a.a.Q("+ ", CustomMaskFormatterKt.formatString$default(FormatterType.Companion.getDECIMAL(), str, "", 0, Integer.MAX_VALUE, false, null, 32, null).getFormattedText());
        Q2.append(myAdvertDetailsPresenterImpl.G.getPricePostfix());
        return Q2.toString();
    }

    public static final int access$getSelectedActionPosition(MyAdvertDetailsPresenterImpl myAdvertDetailsPresenterImpl, int i2, boolean z2) {
        Objects.requireNonNull(myAdvertDetailsPresenterImpl);
        return z2 ? i2 - 1 : i2;
    }

    public static final void access$handleActionFromActivationInfo(MyAdvertDetailsPresenterImpl myAdvertDetailsPresenterImpl, DeepLink deepLink) {
        Disposables.plusAssign(myAdvertDetailsPresenterImpl.e, SubscribersKt.subscribeBy$default(myAdvertDetailsPresenterImpl.e(deepLink, false), new y(deepLink), (Function0) null, (Function1) null, 6, (Object) null));
    }

    public static final void access$handleVasAction(MyAdvertDetailsPresenterImpl myAdvertDetailsPresenterImpl, DeepLink deepLink, String str) {
        MyAdvertRouter myAdvertRouter;
        Objects.requireNonNull(myAdvertDetailsPresenterImpl);
        if (deepLink instanceof FeesLink) {
            MyAdvertRouter myAdvertRouter2 = myAdvertDetailsPresenterImpl.a;
            if (myAdvertRouter2 != null) {
                myAdvertRouter2.openFees(str);
            }
        } else if (deepLink instanceof LegacyPaidServicesLink) {
            MyAdvertRouter myAdvertRouter3 = myAdvertDetailsPresenterImpl.a;
            if (myAdvertRouter3 != null) {
                myAdvertRouter3.openDeepLink(deepLink);
            }
            myAdvertDetailsPresenterImpl.C.track(new VasButtonClickEvent(str));
        } else if (deepLink instanceof PaidServicesLink) {
            MyAdvertRouter myAdvertRouter4 = myAdvertDetailsPresenterImpl.a;
            if (myAdvertRouter4 != null) {
                myAdvertRouter4.openDeepLink(deepLink);
            }
        } else if ((deepLink instanceof MyAdvertLink.Edit) && (myAdvertRouter = myAdvertDetailsPresenterImpl.a) != null) {
            MyAdvertRouter.DefaultImpls.openEdit$default(myAdvertRouter, str, ((MyAdvertLink.Edit) deepLink).getPostAction(), null, 4, null);
        }
    }

    public static final void access$hideProgressForSecondaryContent(MyAdvertDetailsPresenterImpl myAdvertDetailsPresenterImpl) {
        MyAdvertDetailsView myAdvertDetailsView;
        myAdvertDetailsPresenterImpl.k = true;
        if (myAdvertDetailsPresenterImpl.l && (myAdvertDetailsView = myAdvertDetailsPresenterImpl.b) != null) {
            myAdvertDetailsView.showContent();
        }
    }

    public static final void access$notifyVasBundleBannerClosed(MyAdvertDetailsPresenterImpl myAdvertDetailsPresenterImpl, String str) {
        CompositeDisposable compositeDisposable = myAdvertDetailsPresenterImpl.e;
        Disposable subscribe = myAdvertDetailsPresenterImpl.y.notifyVasBundlesBannerClosed(str).observeOn(myAdvertDetailsPresenterImpl.u.mainThread()).doOnError(new x0(new Function1<Throwable, Unit>(Logs.INSTANCE) { // from class: a2.a.a.h3.a.z
            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public Unit invoke(Throwable th) {
                Logs logs = (Logs) this.receiver;
                Logs.error(th);
                return Unit.INSTANCE;
            }
        })).subscribe();
        Intrinsics.checkNotNullExpressionValue(subscribe, "interactor.notifyVasBund…\n            .subscribe()");
        Disposables.plusAssign(compositeDisposable, subscribe);
    }

    public static final void access$onAdvertDeactivated(MyAdvertDetailsPresenterImpl myAdvertDetailsPresenterImpl, String str, String str2, Boolean bool, String str3) {
        myAdvertDetailsPresenterImpl.g = 6;
        boolean booleanValue = bool != null ? bool.booleanValue() : false;
        myAdvertDetailsPresenterImpl.j(str2);
        c(myAdvertDetailsPresenterImpl, str, booleanValue, str3, null, 8);
    }

    public static final void access$share(MyAdvertDetailsPresenterImpl myAdvertDetailsPresenterImpl, MyAdvertDetailsItem myAdvertDetailsItem) {
        MyAdvertRouter myAdvertRouter;
        Objects.requireNonNull(myAdvertDetailsPresenterImpl);
        AdvertSharing sharing = myAdvertDetailsItem.getSharing();
        if (sharing != null && (myAdvertRouter = myAdvertDetailsPresenterImpl.a) != null) {
            String str = sharing.getNative();
            if (str == null) {
                str = sharing.getUrl();
            }
            myAdvertRouter.openSharing(str, myAdvertDetailsItem.getTitle());
        }
    }

    public static final Single access$showAppRater(MyAdvertDetailsPresenterImpl myAdvertDetailsPresenterImpl, boolean z2) {
        Objects.requireNonNull(myAdvertDetailsPresenterImpl);
        if (z2) {
            Single doOnSuccess = InteropKt.toV3(myAdvertDetailsPresenterImpl.M.shouldShowAppRaterOnSoa(myAdvertDetailsPresenterImpl.N.now())).subscribeOn(myAdvertDetailsPresenterImpl.u.io()).observeOn(myAdvertDetailsPresenterImpl.u.mainThread()).doOnSuccess(new j0(myAdvertDetailsPresenterImpl));
            Intrinsics.checkNotNullExpressionValue(doOnSuccess, "appRaterInteractor.shoul…      }\n                }");
            return doOnSuccess;
        }
        Single just = Single.just(Boolean.FALSE);
        Intrinsics.checkNotNullExpressionValue(just, "Single.just(false)");
        return just;
    }

    public static final Single access$showCallPermissionIfNeeded(MyAdvertDetailsPresenterImpl myAdvertDetailsPresenterImpl, String str, AnonymousNumber anonymousNumber) {
        Objects.requireNonNull(myAdvertDetailsPresenterImpl);
        Single fromCallable = Single.fromCallable(new k0(myAdvertDetailsPresenterImpl, anonymousNumber, str));
        Intrinsics.checkNotNullExpressionValue(fromCallable, "Single.fromCallable {\n  …able dialogWasShown\n    }");
        return fromCallable;
    }

    public static final Single access$showCharityDialog(MyAdvertDetailsPresenterImpl myAdvertDetailsPresenterImpl, String str, String str2, MyAdvertDetailsPresenter.ProcessedAction processedAction) {
        Objects.requireNonNull(myAdvertDetailsPresenterImpl);
        boolean z2 = false;
        boolean z3 = (processedAction instanceof MyAdvertDetailsPresenter.ProcessedAction.Edit) && Intrinsics.areEqual(((MyAdvertDetailsPresenter.ProcessedAction.Edit) processedAction).getPostAction(), "activate");
        if (myAdvertDetailsPresenterImpl.F.getCharityDialogs().invoke().booleanValue() && myAdvertDetailsPresenterImpl.p) {
            z2 = true;
        }
        if (!z2 || z3 || (!Intrinsics.areEqual(str2, "active"))) {
            Single just = Single.just(Boolean.FALSE);
            Intrinsics.checkNotNullExpressionValue(just, "Single.just(false)");
            return just;
        }
        Maybe<CharityInteractor.Dialog> doOnSuccess = myAdvertDetailsPresenterImpl.R.requestDialog(str, CharityInteractor.Source.PUBLISH).observeOn(myAdvertDetailsPresenterImpl.u.mainThread()).doOnSuccess(new l0(myAdvertDetailsPresenterImpl));
        Intrinsics.checkNotNullExpressionValue(doOnSuccess, "charityInteractor.reques…it.body, it.clickEvent) }");
        Single<R> map = doOnSuccess.isEmpty().map(m0.a);
        Intrinsics.checkNotNullExpressionValue(map, "charityInteractor.reques…         .map { not(it) }");
        return map;
    }

    public static final void access$showLoadingProblem(MyAdvertDetailsPresenterImpl myAdvertDetailsPresenterImpl) {
        myAdvertDetailsPresenterImpl.l = false;
        MyAdvertDetailsView myAdvertDetailsView = myAdvertDetailsPresenterImpl.b;
        if (myAdvertDetailsView != null) {
            myAdvertDetailsView.showLoadingProblem();
        }
    }

    public static final void access$showMainContent(MyAdvertDetailsPresenterImpl myAdvertDetailsPresenterImpl) {
        MyAdvertDetailsView myAdvertDetailsView;
        myAdvertDetailsPresenterImpl.l = true;
        if (myAdvertDetailsPresenterImpl.k && (myAdvertDetailsView = myAdvertDetailsPresenterImpl.b) != null) {
            myAdvertDetailsView.showContent();
        }
    }

    public static final Single access$showSecurityDialog(MyAdvertDetailsPresenterImpl myAdvertDetailsPresenterImpl, String str, String str2, MyAdvertDetailsPresenter.ProcessedAction processedAction) {
        Objects.requireNonNull(myAdvertDetailsPresenterImpl);
        boolean z2 = processedAction instanceof MyAdvertDetailsPresenter.ProcessedAction.Edit;
        boolean z3 = false;
        boolean z4 = z2 && Intrinsics.areEqual(((MyAdvertDetailsPresenter.ProcessedAction.Edit) processedAction).getPostAction(), "activate");
        boolean z5 = z2 && (Intrinsics.areEqual(((MyAdvertDetailsPresenter.ProcessedAction.Edit) processedAction).getPostAction(), "activate") ^ true);
        boolean z7 = processedAction instanceof MyAdvertDetailsPresenter.ProcessedAction.Activation;
        boolean z8 = myAdvertDetailsPresenterImpl.F.getAntiFraudSheetAfterPublish().invoke().booleanValue() && myAdvertDetailsPresenterImpl.p;
        if (myAdvertDetailsPresenterImpl.F.getAntiFraudSheetAfterActivation().invoke().booleanValue() && (z7 || z4)) {
            z3 = true;
        }
        if ((!z8 && !z3) || (!Intrinsics.areEqual(str2, "active")) || z5) {
            Single just = Single.just(Boolean.FALSE);
            Intrinsics.checkNotNullExpressionValue(just, "Single.just(false)");
            return just;
        } else if (str != null) {
            String currentUserId = myAdvertDetailsPresenterImpl.X.getCurrentUserId();
            if (currentUserId == null) {
                currentUserId = "";
            }
            Maybe<DetailsSheetLinkBody> doOnSuccess = myAdvertDetailsPresenterImpl.W.loadSafetyInfo(str, currentUserId).delay(600, TimeUnit.MILLISECONDS, myAdvertDetailsPresenterImpl.u.computation()).observeOn(myAdvertDetailsPresenterImpl.u.mainThread()).doOnSuccess(new q0(myAdvertDetailsPresenterImpl, currentUserId));
            Intrinsics.checkNotNullExpressionValue(doOnSuccess, "safetyInfoProvider\n     …nt(userId))\n            }");
            Single<R> map = doOnSuccess.isEmpty().map(r0.a);
            Intrinsics.checkNotNullExpressionValue(map, "safetyInfoProvider\n     …         .map { not(it) }");
            return map;
        } else {
            Single just2 = Single.just(Boolean.FALSE);
            Intrinsics.checkNotNullExpressionValue(just2, "Single.just(false)");
            return just2;
        }
    }

    public static final void access$trackEditActivationEvent(MyAdvertDetailsPresenterImpl myAdvertDetailsPresenterImpl, MyAdvertLink.Edit edit) {
        Objects.requireNonNull(myAdvertDetailsPresenterImpl);
        if (Intrinsics.areEqual(edit.getPostAction(), "activate")) {
            myAdvertDetailsPresenterImpl.C.track(new AdvertReactivationStartEvent(edit.getItemId()));
        }
    }

    public static void c(MyAdvertDetailsPresenterImpl myAdvertDetailsPresenterImpl, String str, boolean z2, String str2, AdvertActionTransferData.Type type, int i2) {
        String str3 = null;
        if ((i2 & 1) != 0) {
            str = null;
        }
        if ((i2 & 2) != 0) {
            z2 = false;
        }
        if ((i2 & 4) != 0) {
            str2 = null;
        }
        if ((i2 & 8) != 0) {
            type = AdvertActionTransferData.Type.UNKNOWN;
        }
        MyAdvertRouter myAdvertRouter = myAdvertDetailsPresenterImpl.a;
        if (myAdvertRouter != null) {
            int i3 = myAdvertDetailsPresenterImpl.g;
            String str4 = myAdvertDetailsPresenterImpl.d;
            MyAdvertDetailsItem myAdvertDetailsItem = myAdvertDetailsPresenterImpl.c;
            if (myAdvertDetailsItem != null) {
                str3 = myAdvertDetailsItem.getCategoryId();
            }
            myAdvertRouter.finish(i3, z2, str2, new AdvertActionTransferData(str, str4, str3, type));
        }
    }

    public static /* synthetic */ Flowable f(MyAdvertDetailsPresenterImpl myAdvertDetailsPresenterImpl, DeepLink deepLink, boolean z2, int i2) {
        if ((i2 & 2) != 0) {
            z2 = false;
        }
        return myAdvertDetailsPresenterImpl.e(deepLink, z2);
    }

    public static void h(MyAdvertDetailsPresenterImpl myAdvertDetailsPresenterImpl, String str, String str2, boolean z2, String str3, int i2) {
        int i3 = i2 & 1;
        int i4 = i2 & 8;
        myAdvertDetailsPresenterImpl.j(str2);
        c(myAdvertDetailsPresenterImpl, null, z2, null, null, 8);
    }

    public final Flowable<Unit> a(String str) {
        this.C.track(new AdvertReactivationStartEvent(str));
        this.O.startActivateAdvertLoading();
        Flowable<R> flowable = this.y.activateAdvert(str).observeOn(this.u.mainThread()).doOnNext(new e(this, str)).map(f.a).toFlowable(BackpressureStrategy.DROP);
        Intrinsics.checkNotNullExpressionValue(flowable, "interactor.activateAdver…ackpressureStrategy.DROP)");
        return flowable;
    }

    @Override // com.avito.android.user_advert.advert.switcher_block.UserAdvertSource
    public void addAdvertLoadListener(@NotNull AdvertLoadListener advertLoadListener) {
        Intrinsics.checkNotNullParameter(advertLoadListener, "advertLoadListener");
        this.m.add(advertLoadListener);
    }

    @Override // com.avito.android.user_advert.advert.MyAdvertDetailsPresenter
    public void attachRouter(@NotNull MyAdvertRouter myAdvertRouter) {
        Intrinsics.checkNotNullParameter(myAdvertRouter, "router");
        this.a = myAdvertRouter;
    }

    @Override // com.avito.android.user_advert.advert.MyAdvertDetailsPresenter
    public void attachView(@NotNull MyAdvertDetailsView myAdvertDetailsView) {
        Intrinsics.checkNotNullParameter(myAdvertDetailsView, "view");
        this.b = myAdvertDetailsView;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:137:0x02fa, code lost:
        if (r0 != null) goto L_0x0304;
     */
    /* JADX WARNING: Removed duplicated region for block: B:302:0x05ca  */
    /* JADX WARNING: Removed duplicated region for block: B:303:0x05cf  */
    /* JADX WARNING: Removed duplicated region for block: B:305:0x05d2  */
    /* JADX WARNING: Removed duplicated region for block: B:314:0x05ea  */
    /* JADX WARNING: Removed duplicated region for block: B:315:0x05ef  */
    /* JADX WARNING: Removed duplicated region for block: B:317:0x05f2  */
    /* JADX WARNING: Removed duplicated region for block: B:318:0x05f4  */
    /* JADX WARNING: Removed duplicated region for block: B:320:0x05f7 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:326:0x0602  */
    /* JADX WARNING: Removed duplicated region for block: B:329:0x0609  */
    /* JADX WARNING: Removed duplicated region for block: B:332:0x0622  */
    /* JADX WARNING: Removed duplicated region for block: B:335:0x062e  */
    /* JADX WARNING: Removed duplicated region for block: B:340:0x063f  */
    /* JADX WARNING: Removed duplicated region for block: B:343:0x0648  */
    /* JADX WARNING: Removed duplicated region for block: B:346:0x065b  */
    /* JADX WARNING: Removed duplicated region for block: B:354:0x0689  */
    /* JADX WARNING: Removed duplicated region for block: B:361:0x069f  */
    /* JADX WARNING: Removed duplicated region for block: B:364:0x06aa  */
    /* JADX WARNING: Removed duplicated region for block: B:366:0x06b0  */
    /* JADX WARNING: Removed duplicated region for block: B:372:0x06c2  */
    /* JADX WARNING: Removed duplicated region for block: B:375:0x06ca  */
    /* JADX WARNING: Removed duplicated region for block: B:384:0x06e4  */
    /* JADX WARNING: Removed duplicated region for block: B:390:0x076b  */
    /* JADX WARNING: Removed duplicated region for block: B:393:0x0779  */
    /* JADX WARNING: Removed duplicated region for block: B:396:0x0781  */
    /* JADX WARNING: Removed duplicated region for block: B:401:0x0791  */
    /* JADX WARNING: Removed duplicated region for block: B:404:0x0799  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b(com.avito.android.user_advert.advert.MyAdvertDetailsItem r30, com.avito.android.user_advert.advert.MyAdvertDetailsPresenter.ProcessedAction r31, boolean r32) {
        /*
        // Method dump skipped, instructions count: 1949
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.user_advert.advert.MyAdvertDetailsPresenterImpl.b(com.avito.android.user_advert.advert.MyAdvertDetailsItem, com.avito.android.user_advert.advert.MyAdvertDetailsPresenter$ProcessedAction, boolean):void");
    }

    public final void d(TypedError typedError) {
        MyAdvertDetailsView myAdvertDetailsView;
        if (typedError instanceof ErrorWithMessage.NetworkError) {
            this.l = false;
            MyAdvertDetailsView myAdvertDetailsView2 = this.b;
            if (myAdvertDetailsView2 != null) {
                myAdvertDetailsView2.showLoadingProblem();
            }
        } else if (typedError instanceof TypedError.UnauthorizedError) {
            MyAdvertRouter myAdvertRouter = this.a;
            if (myAdvertRouter != null) {
                myAdvertRouter.openAuth();
            }
        } else if ((typedError instanceof ErrorWithMessage) && (myAdvertDetailsView = this.b) != null) {
            myAdvertDetailsView.showError(((ErrorWithMessage) typedError).getMessage());
        }
    }

    @Override // com.avito.android.user_advert.advert.MyAdvertDetailsPresenter
    public void detachRouter() {
        this.a = null;
    }

    @Override // com.avito.android.user_advert.advert.MyAdvertDetailsPresenter
    public void detachView() {
        MyAdvertDetailsView myAdvertDetailsView = this.b;
        if (myAdvertDetailsView != null) {
            myAdvertDetailsView.hidePriceBadgeInfoIconAndRemoveListener();
        }
        this.b = null;
        this.e.clear();
        Disposable disposable = this.f;
        if (disposable != null) {
            disposable.dispose();
        }
    }

    public final Flowable<Unit> e(DeepLink deepLink, boolean z2) {
        if (deepLink instanceof MyAdvertLink.Edit) {
            Flowable<Unit> fromCallable = Flowable.fromCallable(new b(0, this, deepLink));
            Intrinsics.checkNotNullExpressionValue(fromCallable, "Flowable.fromCallable {\n…          )\n            }");
            return fromCallable;
        } else if (deepLink instanceof MyAdvertLink.Delete) {
            String itemId = ((MyAdvertLink.Delete) deepLink).getItemId();
            MyAdvertDetailsView myAdvertDetailsView = this.b;
            if (myAdvertDetailsView != null) {
                this.O.startDeleteAdvertLoading();
                Flowable<R> flowable = myAdvertDetailsView.showDeleteItemDialog().flatMap(new a2.a.a.h3.a.v(this, itemId)).toFlowable(BackpressureStrategy.DROP);
                Intrinsics.checkNotNullExpressionValue(flowable, "view\n            .showDe…ackpressureStrategy.DROP)");
                return flowable;
            }
            Flowable<Unit> empty = Flowable.empty();
            Intrinsics.checkNotNullExpressionValue(empty, "Flowable.empty()");
            return empty;
        } else if (deepLink instanceof MyAdvertLink.Activate) {
            return a(((MyAdvertLink.Activate) deepLink).getItemId());
        } else {
            if (deepLink instanceof MyAdvertLink.Deactivate) {
                if (z2) {
                    MyAdvertDetailsView myAdvertDetailsView2 = this.b;
                    if (myAdvertDetailsView2 != null) {
                        myAdvertDetailsView2.startLoading();
                    }
                    this.k = false;
                }
                String itemId2 = ((MyAdvertLink.Deactivate) deepLink).getItemId();
                this.O.startDeactivateAdvertLoading();
                Flowable<R> flatMap = this.y.getCloseReasons(itemId2).observeOn(this.u.mainThread()).toFlowable(BackpressureStrategy.DROP).flatMap(new a2.a.a.h3.a.s(this, itemId2));
                Intrinsics.checkNotNullExpressionValue(flatMap, "interactor.getCloseReaso…          }\n            }");
                return flatMap;
            } else if (deepLink instanceof MyAdvertLink.Restore) {
                return i(((MyAdvertLink.Restore) deepLink).getItemId());
            } else {
                if (deepLink instanceof DraftPublicationLink) {
                    Flowable<Unit> fromCallable2 = Flowable.fromCallable(new b(1, this, deepLink));
                    Intrinsics.checkNotNullExpressionValue(fromCallable2, "Flowable.fromCallable {\n…nk.draftId)\n            }");
                    return fromCallable2;
                } else if (deepLink instanceof DraftDeletionLink) {
                    Flowable<R> flowable2 = this.z.deleteDraft(((DraftDeletionLink) deepLink).getDraftId()).observeOn(this.u.mainThread()).doOnSuccess(new a2.a.a.h3.a.w(this)).map(x.a).toFlowable();
                    Intrinsics.checkNotNullExpressionValue(flowable2, "deleteDraft(deepLink.draftId)");
                    return flowable2;
                } else {
                    Flowable<Unit> fromCallable3 = Flowable.fromCallable(new b(2, this, deepLink));
                    Intrinsics.checkNotNullExpressionValue(fromCallable3, "Flowable.fromCallable { ….openDeepLink(deepLink) }");
                    return fromCallable3;
                }
            }
        }
    }

    public final boolean g(Action action) {
        if (action == null) {
            return false;
        }
        DeepLink deepLink = action.getDeepLink();
        if ((deepLink instanceof FeesLink) || (deepLink instanceof MyAdvertLink.Activate) || (deepLink instanceof MyAdvertLink.Edit) || (deepLink instanceof LegacyPaidServicesLink) || (deepLink instanceof PaidServicesLink)) {
            return true;
        }
        return false;
    }

    public final Flowable<Unit> i(String str) {
        this.O.startRestoreAdvertLoading();
        Flowable<R> flowable = this.y.restoreAdvert(str).observeOn(this.u.mainThread()).doOnNext(new o(this)).map(p.a).toFlowable(BackpressureStrategy.DROP);
        Intrinsics.checkNotNullExpressionValue(flowable, "interactor.restoreAdvert…ackpressureStrategy.DROP)");
        return flowable;
    }

    @Override // com.avito.android.user_advert.advert.MyAdvertDetailsPresenter
    public void init(boolean z2) {
        MyAdvertDetailsView myAdvertDetailsView;
        MyAdvertDetailsView myAdvertDetailsView2;
        i0 i0Var = new i0(this);
        MyAdvertDetailsView myAdvertDetailsView3 = this.b;
        if (myAdvertDetailsView3 != null) {
            myAdvertDetailsView3.setRejectionDeeplinkClickListener(i0Var);
        }
        String str = this.t;
        if (!(str == null || (myAdvertDetailsView2 = this.b) == null)) {
            myAdvertDetailsView2.showErrorDialog(str, new n0(this));
        }
        MyAdvertDetailsItem myAdvertDetailsItem = this.c;
        if (myAdvertDetailsItem != null) {
            Iterator<T> it = this.m.iterator();
            while (it.hasNext()) {
                it.next().onAdvertLoaded(myAdvertDetailsItem);
            }
            b(myAdvertDetailsItem, MyAdvertDetailsPresenter.ProcessedAction.Default.INSTANCE, false);
            this.l = true;
            if (this.k && (myAdvertDetailsView = this.b) != null) {
                myAdvertDetailsView.showContent();
                return;
            }
            return;
        }
        MyAdvertDetailsPresenter.DefaultImpls.onInitialize$default(this, z2, null, 2, null);
    }

    @Override // com.avito.android.user_advert.advert.MyAdvertDetailsPresenter
    public void invokeAction(@NotNull DeepLink deepLink) {
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        CompositeDisposable compositeDisposable = this.e;
        Disposable subscribe = e(deepLink, true).subscribe(g.a, h.a);
        Intrinsics.checkNotNullExpressionValue(subscribe, "handleItemAction(deepLin…dle invokeAction\", it) })");
        Disposables.plusAssign(compositeDisposable, subscribe);
    }

    public final void j(String str) {
        MyAdvertDetailsView myAdvertDetailsView;
        if (!(str == null || str.length() == 0) && (myAdvertDetailsView = this.b) != null) {
            Intrinsics.checkNotNull(str);
            myAdvertDetailsView.showActionMessage(str);
        }
    }

    public final Single<Unit> k(String str, String str2, Function1<? super SuccessResult, Unit> function1) {
        Single<R> map = this.y.stopAdvert(str2, str).observeOn(this.u.mainThread()).doOnSuccess(new v(this, function1)).map(w.a);
        Intrinsics.checkNotNullExpressionValue(map, "interactor\n            .…            .map { Unit }");
        return map;
    }

    public final void l(Function1<? super String, Unit> function1) {
        DetailsId detailsId = this.n;
        if (detailsId instanceof AdvertId) {
            function1.invoke(((AdvertId) detailsId).getAdvertId());
        }
    }

    @Override // com.avito.android.user_advert.advert.MyAdvertDetailsPresenter
    public void onActivateResult(boolean z2, @Nullable String str) {
        if (z2) {
            MyAdvertDetailsPresenter.DefaultImpls.onReinitialize$default(this, null, 1, null);
        }
        this.t = str;
    }

    @Override // com.avito.android.user_advert.advert.MyAdvertDetailsPresenter
    public void onActivationError() {
        MyAdvertDetailsView myAdvertDetailsView;
        String str = this.t;
        if (str != null && (myAdvertDetailsView = this.b) != null) {
            myAdvertDetailsView.showErrorDialog(str, new n0(this));
        }
    }

    @Override // com.avito.android.user_advert.advert.MyAdvertDetailsPresenter
    public void onAdvertStatusChanged(@Nullable String str) {
        MyAdvertDetailsView myAdvertDetailsView;
        if (str != null && (myAdvertDetailsView = this.b) != null) {
            myAdvertDetailsView.showSnackBar(str);
        }
    }

    @Override // com.avito.android.user_advert.advert.MyAdvertDetailsPresenter
    public void onBackPressed() {
        c(this, null, false, null, null, 15);
    }

    @Override // com.avito.android.user_advert.advert.MyAdvertDetailsPresenter
    public void onCallPermissionResult(@NotNull PermissionState permissionState) {
        Intrinsics.checkNotNullParameter(permissionState, "result");
        MyAdvertDetailsItem myAdvertDetailsItem = this.c;
        if (myAdvertDetailsItem != null) {
            this.C.track(new MicPermissionPopupResultEvent(permissionState.isGranted(), MicAccessScenario.ITEM_PUBLISHING, myAdvertDetailsItem.getId(), null, 8, null));
        }
        this.U.updatePermissionState("android.permission.RECORD_AUDIO", permissionState);
    }

    @Override // com.avito.android.user_advert.advert.MyAdvertDetailsPresenter
    public void onCloseReasonChosen(@NotNull CloseReason closeReason, @Nullable String str) {
        String id;
        Disposable disposable;
        Intrinsics.checkNotNullParameter(closeReason, "reason");
        MyAdvertDetailsItem myAdvertDetailsItem = this.c;
        if (myAdvertDetailsItem != null && (id = myAdvertDetailsItem.getId()) != null) {
            Boolean shouldUpdateIncome = closeReason.getShouldUpdateIncome();
            Boolean showAppRater = closeReason.getShowAppRater();
            Boolean bool = Boolean.TRUE;
            String str2 = Intrinsics.areEqual(shouldUpdateIncome, bool) || Intrinsics.areEqual(showAppRater, bool) ? id : null;
            CompositeDisposable compositeDisposable = this.e;
            if (str == null) {
                disposable = k(id, closeReason.getId(), new i(this, str2, closeReason)).subscribe(c.b, a.b);
            } else {
                disposable = this.y.setAdvertPrice(id, str).flatMap(new j(this, str, id, closeReason, str2)).observeOn(this.u.mainThread()).subscribe(c.c, a.c);
            }
            Intrinsics.checkNotNullExpressionValue(disposable, "if (newPrice == null) {\n… price\", it) })\n        }");
            Disposables.plusAssign(compositeDisposable, disposable);
        }
    }

    @Override // com.avito.android.user_advert.advert.MyAdvertDetailsViewPresenter
    public void onContractButtonClicked(@NotNull Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "url");
        MyAdvertRouter myAdvertRouter = this.a;
        if (myAdvertRouter != null) {
            myAdvertRouter.openUrl(uri);
        }
    }

    @Override // com.avito.android.deep_linking.links.OnDeepLinkClickListener
    public void onDeepLinkClick(@NotNull DeepLink deepLink) {
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        CompositeDisposable compositeDisposable = this.e;
        Disposable subscribe = e(deepLink, false).subscribe(k.a, l.a);
        Intrinsics.checkNotNullExpressionValue(subscribe, "handleItemAction(deepLin…dle invokeAction\", it) })");
        Disposables.plusAssign(compositeDisposable, subscribe);
    }

    @Override // com.avito.android.user_advert.advert.MyAdvertDetailsPresenter
    public void onEditResult(@Nullable String str) {
        this.g = 9;
        MyAdvertDetailsPresenter.DefaultImpls.onInitialize$default(this, false, new MyAdvertDetailsPresenter.ProcessedAction.Edit(str), 1, null);
    }

    @Override // com.avito.android.user_advert.advert.MyAdvertDetailsPresenter
    public void onFeesResult() {
        this.g = 9;
        MyAdvertDetailsPresenter.DefaultImpls.onInitialize$default(this, false, MyAdvertDetailsPresenter.ProcessedAction.Activation.INSTANCE, 1, null);
    }

    @Override // com.avito.android.user_advert.advert.MyAdvertDetailsViewPresenter
    public void onGalleryFullScreenClicked(int i2) {
        MyAdvertRouter myAdvertRouter;
        MyAdvertDetailsItem myAdvertDetailsItem = this.c;
        if (myAdvertDetailsItem != null && (myAdvertRouter = this.a) != null) {
            myAdvertRouter.showGalleryFullscreen(myAdvertDetailsItem.getVideo(), myAdvertDetailsItem.getImages(), myAdvertDetailsItem.getInfoImage(), i2);
        }
    }

    @Override // com.avito.android.user_advert.advert.MyAdvertDetailsPresenter
    public void onGalleryResult(int i2) {
        MyAdvertDetailsView myAdvertDetailsView = this.b;
        if (myAdvertDetailsView != null) {
            myAdvertDetailsView.setGalleryCurrentItem(i2);
        }
    }

    @Override // com.avito.android.user_advert.advert.MyAdvertDetailsPresenter
    public void onInitialize(boolean z2, @NotNull MyAdvertDetailsPresenter.ProcessedAction processedAction) {
        Observable<MyAdvertDetails> observable;
        Intrinsics.checkNotNullParameter(processedAction, "processedAction");
        this.O.startAdvertServerLoading();
        MyAdvertDetailsView myAdvertDetailsView = this.b;
        if (myAdvertDetailsView != null) {
            myAdvertDetailsView.showToolbarTitle("");
        }
        this.l = false;
        MyAdvertDetailsView myAdvertDetailsView2 = this.b;
        if (myAdvertDetailsView2 != null) {
            myAdvertDetailsView2.startLoading();
        }
        Disposable disposable = this.f;
        if (disposable != null) {
            disposable.dispose();
        }
        DetailsId detailsId = this.n;
        if (detailsId instanceof AdvertId) {
            observable = this.y.loadAdvert(((AdvertId) detailsId).getAdvertId()).toObservable();
        } else if (detailsId instanceof DraftId) {
            observable = this.z.loadDraftAdvert(((DraftId) detailsId).getDraftId());
        } else {
            throw new NoWhenBranchMatchedException();
        }
        this.f = observable.observeOn(this.u.mainThread()).subscribe(new m(this, processedAction, z2), new n(this));
    }

    @Override // com.avito.android.user_advert.advert.MyAdvertDetailsPresenter
    public void onLoginFailed() {
        c(this, null, false, null, null, 15);
    }

    @Override // com.avito.android.user_advert.advert.MyAdvertDetailsPresenter
    public void onNewIntent(@NotNull DetailsId detailsId, @Nullable String str, boolean z2, boolean z3) {
        Intrinsics.checkNotNullParameter(detailsId, "id");
        this.n = detailsId;
        this.i = str;
        this.p = z3;
        this.j = false;
        this.h = false;
        MyAdvertDetailsPresenter.DefaultImpls.onReinitialize$default(this, null, 1, null);
        if (z2) {
            l(new c0(this));
            this.h = true;
        }
    }

    @Override // com.avito.android.user_advert.advert.MyAdvertDetailsViewPresenter
    public void onRefresh() {
        MyAdvertDetailsPresenter.DefaultImpls.onInitialize$default(this, false, null, 3, null);
    }

    @Override // com.avito.android.user_advert.advert.MyAdvertDetailsPresenter
    public void onReinitialize(@NotNull MyAdvertDetailsPresenter.ProcessedAction processedAction) {
        Intrinsics.checkNotNullParameter(processedAction, "processedAction");
        this.g = 9;
        MyAdvertDetailsPresenter.DefaultImpls.onInitialize$default(this, false, processedAction, 1, null);
    }

    @Override // com.avito.android.user_advert.advert.MyAdvertDetailsPresenter
    @NotNull
    public Kundle onSavedState() {
        Kundle kundle = new Kundle();
        kundle.putInt("parent_activity_result", Integer.valueOf(this.g));
        kundle.putParcelable("item", this.c);
        kundle.putString("error_message", this.t);
        kundle.putBoolean("activate_shown", Boolean.valueOf(this.h));
        kundle.putString("result_message", this.d);
        kundle.putString("key_message", this.i);
        kundle.putBoolean("key_status_shown", Boolean.valueOf(this.j));
        return kundle;
    }

    @Override // com.avito.android.user_advert.advert.MyAdvertDetailsViewPresenter
    public void onSupportButtonClicked() {
        MyAdvertRouter myAdvertRouter = this.a;
        if (myAdvertRouter != null) {
            myAdvertRouter.showHelpCenterScreen("https://support.avito.ru/request/341");
        }
    }

    @Override // com.avito.android.user_advert.advert.MyAdvertDetailsViewPresenter
    public void onVerificationButtonClicked() {
        Verification verification;
        List<VerificationStep> steps;
        MyAdvertDetailsItem myAdvertDetailsItem = this.c;
        if (myAdvertDetailsItem != null && (verification = myAdvertDetailsItem.getVerification()) != null && (steps = verification.getSteps()) != null) {
            MyAdvertDetailsItem myAdvertDetailsItem2 = this.c;
            Intrinsics.checkNotNull(myAdvertDetailsItem2);
            String id = myAdvertDetailsItem2.getId();
            this.C.track(new PhotoWizardStartClickEvent(id));
            MyAdvertRouter myAdvertRouter = this.a;
            if (myAdvertRouter != null) {
                myAdvertRouter.openVerificationWizard(id, steps);
            }
        }
    }

    @Override // com.avito.android.user_advert.advert.switcher_block.UserAdvertSource
    public void removeAdvertLoadListener(@NotNull AdvertLoadListener advertLoadListener) {
        Intrinsics.checkNotNullParameter(advertLoadListener, "advertLoadListener");
        this.m.remove(advertLoadListener);
    }

    @Override // com.avito.android.user_advert.advert.MyAdvertDetailsPresenter
    public void setParentResult(int i2) {
        this.g = i2;
    }

    @Override // com.avito.android.user_advert.advert.MyAdvertDetailsViewPresenter
    public void showAdditionalDialogs(@NotNull MyAdvertDetailsPresenter.ProcessedAction processedAction, boolean z2) {
        Single<R> single;
        Intrinsics.checkNotNullParameter(processedAction, "processedAction");
        MyAdvertDetailsItem myAdvertDetailsItem = this.c;
        if (myAdvertDetailsItem != null) {
            q qVar = q.a;
            CompositeDisposable compositeDisposable = this.e;
            String id = myAdvertDetailsItem.getId();
            String status = myAdvertDetailsItem.getStatus();
            boolean z3 = this.F.getLimitsInfoOnPublish().invoke().booleanValue() && this.p;
            boolean z4 = (processedAction instanceof MyAdvertDetailsPresenter.ProcessedAction.Edit) && (Intrinsics.areEqual(((MyAdvertDetailsPresenter.ProcessedAction.Edit) processedAction).getPostAction(), "activate") ^ true);
            if (!z3 || (!Intrinsics.areEqual(status, "active")) || z4) {
                single = Single.just(Boolean.FALSE);
                Intrinsics.checkNotNullExpressionValue(single, "Single.just(false)");
            } else {
                Maybe<LimitsInfo> doOnSuccess = this.S.loadLimitsInfo(id).observeOn(this.u.mainThread()).doOnSuccess(new o0(this));
                Intrinsics.checkNotNullExpressionValue(doOnSuccess, "limitsInfoInteractor.loa…howLimitsInfoDialog(it) }");
                single = doOnSuccess.isEmpty().map(p0.a);
                Intrinsics.checkNotNullExpressionValue(single, "limitsInfoInteractor.loa…         .map { not(it) }");
            }
            Single<Boolean> a3 = qVar.invoke(single, new d(0, this, myAdvertDetailsItem, processedAction));
            Intrinsics.checkNotNullExpressionValue(a3, "showPublishLimitsDialog(…tatus, processedAction) }");
            Single<Boolean> a4 = qVar.invoke(a3, new r(this, myAdvertDetailsItem));
            Intrinsics.checkNotNullExpressionValue(a4, "showPublishLimitsDialog(…ntItem.anonymousNumber) }");
            Single<Boolean> a5 = qVar.invoke(a4, new s(this, z2));
            Intrinsics.checkNotNullExpressionValue(a5, "showPublishLimitsDialog(…wAppRater(showAppRater) }");
            Disposable subscribe = qVar.invoke(a5, new d(1, this, myAdvertDetailsItem, processedAction)).subscribe(t.a, u.a);
            Intrinsics.checkNotNullExpressionValue(subscribe, "showPublishLimitsDialog(…d to show dialog\", it) })");
            Disposables.plusAssign(compositeDisposable, subscribe);
        }
    }

    @Override // com.avito.android.user_advert.advert.switcher_block.UserAdvertSource
    public void updateSwitcherValue(@NotNull Function1<? super MyAdvertDetailsItem, ? extends MyAdvertDetails.Switcher> function1, boolean z2) {
        MyAdvertDetails.Switcher switcher;
        Intrinsics.checkNotNullParameter(function1, "getSwitcher");
        MyAdvertDetailsItem myAdvertDetailsItem = this.c;
        if (myAdvertDetailsItem != null && (switcher = (MyAdvertDetails.Switcher) function1.invoke(myAdvertDetailsItem)) != null) {
            switcher.setValue(Boolean.valueOf(z2));
        }
    }

    public static final void access$handleError(MyAdvertDetailsPresenterImpl myAdvertDetailsPresenterImpl, LoadingState.Error error, String str) {
        myAdvertDetailsPresenterImpl.O.trackActivateAdvertLoadingError();
        myAdvertDetailsPresenterImpl.O.startActivateAdvertDraw();
        if (error.getError() instanceof PaymentRequiredError) {
            MyAdvertRouter myAdvertRouter = myAdvertDetailsPresenterImpl.a;
            if (myAdvertRouter != null) {
                myAdvertRouter.openFees(str);
            }
        } else {
            myAdvertDetailsPresenterImpl.d(error.getError());
        }
        myAdvertDetailsPresenterImpl.O.trackActivateAdvertDrawError();
    }
}
