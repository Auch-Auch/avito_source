package com.avito.android.advert_core.contactbar;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.annotation.MainThread;
import androidx.annotation.StringRes;
import androidx.exifinterface.media.ExifInterface;
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
import com.avito.android.advert_core.R;
import com.avito.android.advert_core.advert.AdvertCoreRouter;
import com.avito.android.advert_core.advert.AdvertCoreView;
import com.avito.android.advert_core.advert.AdvertFeedbackView;
import com.avito.android.advert_core.analytics.AdvertDetailsAnalyticsInteractor;
import com.avito.android.advert_core.analytics.contactbar.BuyerDevelopmentContact;
import com.avito.android.advert_core.analytics.contactbar.BuyerNewDevelopmentDayEvent;
import com.avito.android.advert_core.analytics.contactbar.ContactSellerCategoryEvent;
import com.avito.android.advert_core.analytics.contactbar.ContactSellerEvent;
import com.avito.android.advert_core.analytics.contactbar.ContactSellerNewAutoEvent;
import com.avito.android.advert_core.analytics.contactbar.ContactSellerVerticalEvent;
import com.avito.android.advert_core.analytics.contactbar.NewBuyerEvent;
import com.avito.android.advert_core.analytics.contactbar.NewBuyerRealtyEvent;
import com.avito.android.advert_core.analytics.contactbar.PhonePageSourceKt;
import com.avito.android.advert_core.analytics.contactbar.SecondarySellEvent;
import com.avito.android.advert_core.analytics.contactbar.ShowPhoneDialogEvent;
import com.avito.android.advert_core.analytics.contactbar.WriteToSellerEvent;
import com.avito.android.advert_core.call_methods.CallMethods;
import com.avito.android.advert_core.contactbar.AdvertContactsPresenterImpl;
import com.avito.android.advert_core.contactbar.anti_fraud.AntiFraudCheckListClickButtonEvent;
import com.avito.android.advert_core.contactbar.anti_fraud.AntiFraudCheckListCloseEvent;
import com.avito.android.advert_core.contactbar.anti_fraud.AntiFraudCheckListShowEvent;
import com.avito.android.advert_core.contactbar.anti_fraud.AntiFraudPreferences;
import com.avito.android.advert_core.contactbar.feedback.FeedbackDialog;
import com.avito.android.advert_core.contactbar.feedback.FeedbackInteractor;
import com.avito.android.advert_core.contactbar.feedback.analytics.FeedbackCloseEvent;
import com.avito.android.advert_core.contactbar.feedback.analytics.FeedbackShowEvent;
import com.avito.android.advert_core.feedback.FeedbackPreferences;
import com.avito.android.advert_core.job.AdvertJobInteractor;
import com.avito.android.advert_core.marketplace.MarketplacePresenter;
import com.avito.android.advert_core.marketplace.MarketplacePresenterKt;
import com.avito.android.advert_core.messenger.AdvertMessengerInteractor;
import com.avito.android.advert_core.sellerprofile.ShowSellersProfileSource;
import com.avito.android.advert_core.task.FirstTimeRunTaskKt;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.event.CallToSellerConfirmedEvent;
import com.avito.android.analytics.event.CallToSellerEvent;
import com.avito.android.analytics.event.CallToSellerTrackedEvent;
import com.avito.android.calls_shared.AppCallMethod;
import com.avito.android.calls_shared.AppCallScenario;
import com.avito.android.calls_shared.AppCallsUsageTracker;
import com.avito.android.calls_shared.CallerInfo;
import com.avito.android.calls_shared.ItemInfo;
import com.avito.android.calls_shared.analytics.events.CallMethodSelectedEvent;
import com.avito.android.calls_shared.analytics.events.InAppCallContacted;
import com.avito.android.calls_shared.analytics.events.ShowCallMethodsEvent;
import com.avito.android.component.contact_bar.ContactBar;
import com.avito.android.deep_linking.links.ApplyPackageToAdvertContactsLink;
import com.avito.android.deep_linking.links.AuthenticateLink;
import com.avito.android.deep_linking.links.CreateChannelLink;
import com.avito.android.deep_linking.links.CvPackagesLink;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.DeliveryStartOrderingDeepLink;
import com.avito.android.deep_linking.links.DeliverySummaryDeepLink;
import com.avito.android.deep_linking.links.ExpressCvLink;
import com.avito.android.deep_linking.links.NoMatchLink;
import com.avito.android.deep_linking.links.PhoneLink;
import com.avito.android.deep_linking.links.PhoneRequestLink;
import com.avito.android.in_app_calls.data.CallActivityRequest;
import com.avito.android.job.progress_bar.ProgressBarResponse;
import com.avito.android.lib.design.snackbar.SnackbarPosition;
import com.avito.android.permissions.PermissionChecker;
import com.avito.android.photo_gallery.LegacyPhotoGalleryActivityKt;
import com.avito.android.profile.ProfileInfoStorage;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.AdvertAction;
import com.avito.android.remote.model.AdvertActions;
import com.avito.android.remote.model.AdvertPrice;
import com.avito.android.remote.model.AdvertisementVerticalAlias;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.remote.model.advert_details.ContactBarData;
import com.avito.android.remote.model.advert_details.SellerOnlineStatus;
import com.avito.android.util.Bundles;
import com.avito.android.util.Formatter;
import com.avito.android.util.Logs;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.preferences.Preferences;
import com.avito.android.util.rx3.DelayedProgress;
import com.avito.android.util.rx3.DelayedProgressKt;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.jakewharton.rxrelay3.PublishRelay;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.kotlin.DisposableKt;
import io.reactivex.rxjava3.kotlin.SubscribersKt;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.messenger.api.AvitoMessengerApiKt;
import ru.avito.messenger.api.entity.Channel;
import ru.sravni.android.bankproduct.utils.date.DateUtilKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Î\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001Bß\u0002\b\u0007\u0012\n\u0010\u0002\u001a\u0005\u0018\u00010\u0002\u0012\b\u0010\u0001\u001a\u00030\u0001\u0012\b\u0010\u0002\u001a\u00030\u0002\u0012\b\u0010»\u0001\u001a\u00030¸\u0001\u0012\b\u0010¿\u0001\u001a\u00030¼\u0001\u0012\b\u0010â\u0001\u001a\u00030ß\u0001\u0012\b\u0010Ù\u0001\u001a\u00030Ö\u0001\u0012\b\u0010 \u0001\u001a\u00030\u0001\u0012\b\u0010Õ\u0001\u001a\u00030Ò\u0001\u0012\u000f\u0010\u0002\u001a\n\u0012\u0005\u0012\u00030\u00020\u0002\u0012\b\u0010 \u0002\u001a\u00030\u0002\u0012\b\u0010´\u0001\u001a\u00030±\u0001\u0012\b\u0010÷\u0001\u001a\u00030ô\u0001\u0012\b\u0010\u0001\u001a\u00030\u0001\u0012\b\u0010ç\u0001\u001a\u00030ä\u0001\u0012\b\u0010ò\u0001\u001a\u00030ï\u0001\u0012\u0011\b\u0001\u0010¬\u0001\u001a\n\u0012\u0005\u0012\u00030©\u00010¨\u0001\u0012\u0011\b\u0001\u0010É\u0001\u001a\n\u0012\u0005\u0012\u00030Æ\u00010Å\u0001\u0012\n\u0010Þ\u0001\u001a\u0005\u0018\u00010Û\u0001\u0012\b\u0010û\u0001\u001a\u00030ø\u0001\u0012\b\u0010ë\u0001\u001a\u00030è\u0001\u0012\u0010\b\u0001\u0010\u0002\u001a\t\u0012\u0005\u0012\u00030\u00020x\u0012\u000e\u0010ÿ\u0001\u001a\t\u0012\u0005\u0012\u00030ü\u00010x\u0012\u0011\b\u0001\u0010\u0001\u001a\n\u0012\u0005\u0012\u00030\u00010\u0001\u0012\u0011\b\u0001\u0010°\u0001\u001a\n\u0012\u0005\u0012\u00030®\u00010¨\u0001\u0012\u0011\b\u0001\u0010\u0002\u001a\n\u0012\u0005\u0012\u00030\u00020\u0001\u0012\b\u0010\u0002\u001a\u00030\u0002¢\u0006\u0006\b¦\u0002\u0010§\u0002J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006J\u0019\u0010\t\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\r\u0010\fJ\u0017\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0019\u0010\u0016\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0019\u0010\u001a\u001a\u00020\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0015\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00040\u001cH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ'\u0010$\u001a\u00020\u00042\f\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\u001f2\b\u0010#\u001a\u0004\u0018\u00010\"H\u0017¢\u0006\u0004\b$\u0010%J'\u0010&\u001a\u00020\u00042\f\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\u001f2\b\u0010#\u001a\u0004\u0018\u00010\"H\u0017¢\u0006\u0004\b&\u0010%J1\u0010'\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\f\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\u001f2\b\u0010#\u001a\u0004\u0018\u00010\"H\u0016¢\u0006\u0004\b'\u0010(J\u001f\u0010*\u001a\b\u0012\u0004\u0012\u00020 0\u001f2\b\u0010!\u001a\u0004\u0018\u00010)H\u0016¢\u0006\u0004\b*\u0010+J\u0017\u0010.\u001a\u00020\u00042\u0006\u0010-\u001a\u00020,H\u0016¢\u0006\u0004\b.\u0010/J\u0017\u00101\u001a\u00020\u00042\u0006\u00100\u001a\u00020\u0018H\u0016¢\u0006\u0004\b1\u0010\u001bJ\u001f\u00104\u001a\u00020\u00042\u0006\u00103\u001a\u0002022\u0006\u00100\u001a\u00020\u0018H\u0016¢\u0006\u0004\b4\u00105J\u000f\u00106\u001a\u00020\u0004H\u0016¢\u0006\u0004\b6\u0010\fJ\u000f\u00107\u001a\u00020\u0004H\u0016¢\u0006\u0004\b7\u0010\fJ\u0017\u0010:\u001a\u00020\u00042\u0006\u00109\u001a\u000208H\u0016¢\u0006\u0004\b:\u0010;J\u000f\u0010<\u001a\u00020\u0004H\u0016¢\u0006\u0004\b<\u0010\fJ\u000f\u0010=\u001a\u00020\u0004H\u0016¢\u0006\u0004\b=\u0010\fJ\u0019\u0010?\u001a\u00020\u00042\b\u0010>\u001a\u0004\u0018\u000102H\u0016¢\u0006\u0004\b?\u0010@J\u000f\u0010A\u001a\u00020\u0004H\u0016¢\u0006\u0004\bA\u0010\fJ\u000f\u0010B\u001a\u00020\u0004H\u0016¢\u0006\u0004\bB\u0010\fJ\u0019\u0010D\u001a\u00020\u00042\b\u00100\u001a\u0004\u0018\u00010CH\u0016¢\u0006\u0004\bD\u0010EJ!\u0010G\u001a\u00020\u00042\u0006\u0010F\u001a\u00020\u00182\b\u00100\u001a\u0004\u0018\u00010CH\u0016¢\u0006\u0004\bG\u0010HJ\u000f\u0010I\u001a\u00020\u0004H\u0016¢\u0006\u0004\bI\u0010\fJ\u000f\u0010J\u001a\u00020\u0004H\u0016¢\u0006\u0004\bJ\u0010\fJ\u000f\u0010K\u001a\u00020\u0004H\u0016¢\u0006\u0004\bK\u0010\fJ\u0019\u0010N\u001a\u00020\u00042\b\u0010M\u001a\u0004\u0018\u00010LH\u0016¢\u0006\u0004\bN\u0010OJ\u0017\u0010R\u001a\u00020\u00042\u0006\u0010Q\u001a\u00020PH\u0016¢\u0006\u0004\bR\u0010SJ\u0017\u0010V\u001a\u00020\u00042\u0006\u0010U\u001a\u00020TH\u0016¢\u0006\u0004\bV\u0010WJ\u0017\u0010X\u001a\u00020\u00042\u0006\u0010U\u001a\u00020TH\u0016¢\u0006\u0004\bX\u0010WJ\u0019\u0010Z\u001a\u00020\u00042\b\u0010Y\u001a\u0004\u0018\u00010\u0018H\u0016¢\u0006\u0004\bZ\u0010\u001bJ\u0017\u0010]\u001a\u00020\u00042\u0006\u0010\\\u001a\u00020[H\u0002¢\u0006\u0004\b]\u0010^J/\u0010_\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010#\u001a\u0004\u0018\u00010\"2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\u001fH\u0002¢\u0006\u0004\b_\u0010`J\u000f\u0010a\u001a\u00020\u0004H\u0002¢\u0006\u0004\ba\u0010\fJ+\u0010d\u001a\u00020\u00042\u0006\u0010Q\u001a\u00020P2\b\b\u0002\u0010b\u001a\u00020,2\b\b\u0002\u0010c\u001a\u00020,H\u0002¢\u0006\u0004\bd\u0010eJ\u0017\u0010f\u001a\u00020\u00042\u0006\u00103\u001a\u00020PH\u0002¢\u0006\u0004\bf\u0010SJ!\u0010j\u001a\u00020\u00042\u0006\u0010h\u001a\u00020g2\b\b\u0002\u0010i\u001a\u00020,H\u0002¢\u0006\u0004\bj\u0010kJ\u0017\u0010l\u001a\u00020\u00042\u0006\u00103\u001a\u000202H\u0002¢\u0006\u0004\bl\u0010@J\u000f\u0010m\u001a\u00020\u0004H\u0002¢\u0006\u0004\bm\u0010\fJ\u000f\u0010n\u001a\u00020\u0004H\u0002¢\u0006\u0004\bn\u0010\fJ\u000f\u0010o\u001a\u00020\u0004H\u0002¢\u0006\u0004\bo\u0010\fJ\u001f\u0010r\u001a\u00020,2\u0006\u0010p\u001a\u00020\u00182\u0006\u0010q\u001a\u00020\u0018H\u0002¢\u0006\u0004\br\u0010sJ\u000f\u0010t\u001a\u00020\u0004H\u0002¢\u0006\u0004\bt\u0010\fJ\u000f\u0010u\u001a\u00020\u0004H\u0002¢\u0006\u0004\bu\u0010\fJ\u000f\u0010v\u001a\u00020\u0004H\u0002¢\u0006\u0004\bv\u0010\fJ\u000f\u0010w\u001a\u00020\u0004H\u0002¢\u0006\u0004\bw\u0010\fJT\u0010\u0001\u001a\u00020\u00042\f\u0010y\u001a\b\u0012\u0002\b\u0003\u0018\u00010x2\b\b\u0001\u0010{\u001a\u00020z2\n\b\u0001\u0010|\u001a\u0004\u0018\u00010z2\b\b\u0001\u0010}\u001a\u00020z2\b\b\u0001\u0010~\u001a\u00020z2\b\u0010\u001a\u0004\u0018\u00010CH\u0002¢\u0006\u0006\b\u0001\u0010\u0001J%\u0010\u0001\u001a\u00020\u00042\b\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020\u0018H\u0002¢\u0006\u0006\b\u0001\u0010\u0001J\u0011\u0010\u0001\u001a\u00020\u0004H\u0002¢\u0006\u0005\b\u0001\u0010\fJ\u0013\u0010\u0001\u001a\u00030\u0001H\u0002¢\u0006\u0006\b\u0001\u0010\u0001R!\u0010\u0001\u001a\n\u0012\u0005\u0012\u00030\u00010\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001b\u0010\u0001\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u0018\u0010\u0001\u001a\u00020,8\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b]\u0010\u0001R\u001a\u0010 \u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001a\u0010¢\u0001\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\bm\u0010¡\u0001R\u001b\u0010¤\u0001\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0001\u0010£\u0001R\u0019\u0010Z\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\bt\u0010¡\u0001R\u001c\u0010§\u0001\u001a\u0005\u0018\u00010¥\u00018\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0001\u0010¦\u0001R!\u0010¬\u0001\u001a\n\u0012\u0005\u0012\u00030©\u00010¨\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bª\u0001\u0010«\u0001R\u0018\u0010­\u0001\u001a\u00020,8\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\bn\u0010\u0001R!\u0010°\u0001\u001a\n\u0012\u0005\u0012\u00030®\u00010¨\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b¯\u0001\u0010«\u0001R\u001a\u0010´\u0001\u001a\u00030±\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b²\u0001\u0010³\u0001R\u0018\u0010µ\u0001\u001a\u00020,8\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\br\u0010\u0001R\u001a\u0010·\u0001\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\bj\u0010¶\u0001R\u001a\u0010»\u0001\u001a\u00030¸\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b¹\u0001\u0010º\u0001R\u001a\u0010¿\u0001\u001a\u00030¼\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b½\u0001\u0010¾\u0001R-\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\u001f8\u0016@\u0016X\u000e¢\u0006\u0017\n\u0005\bw\u0010À\u0001\u001a\u0006\bÁ\u0001\u0010Â\u0001\"\u0006\bÃ\u0001\u0010Ä\u0001R!\u0010É\u0001\u001a\n\u0012\u0005\u0012\u00030Æ\u00010Å\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bÇ\u0001\u0010È\u0001R\u001b\u0010Ì\u0001\u001a\u0005\u0018\u00010Ê\u00018\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\bv\u0010Ë\u0001R\u001a\u0010Î\u0001\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\bd\u0010Í\u0001R\u001b\u0010Ñ\u0001\u001a\u0004\u0018\u00010[8\u0002@\u0002X\u000e¢\u0006\b\n\u0006\bÏ\u0001\u0010Ð\u0001R\u001a\u0010Õ\u0001\u001a\u00030Ò\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bÓ\u0001\u0010Ô\u0001R\u001a\u0010Ù\u0001\u001a\u00030Ö\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b×\u0001\u0010Ø\u0001R\u0019\u0010Ú\u0001\u001a\u0002088\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001c\u0010Þ\u0001\u001a\u0005\u0018\u00010Û\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bÜ\u0001\u0010Ý\u0001R\u001a\u0010â\u0001\u001a\u00030ß\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bà\u0001\u0010á\u0001R\u001a\u0010ã\u0001\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\bl\u0010£\u0001R\u001a\u0010ç\u0001\u001a\u00030ä\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bå\u0001\u0010æ\u0001R\u001a\u0010ë\u0001\u001a\u00030è\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bé\u0001\u0010ê\u0001R\u001f\u0010\u001d\u001a\t\u0012\u0004\u0012\u00020\u00040ì\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bí\u0001\u0010î\u0001R\u001a\u0010ò\u0001\u001a\u00030ï\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bð\u0001\u0010ñ\u0001R\u0018\u0010ó\u0001\u001a\u00020,8\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\ba\u0010\u0001R\u001a\u0010÷\u0001\u001a\u00030ô\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bõ\u0001\u0010ö\u0001R\u001a\u0010û\u0001\u001a\u00030ø\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bù\u0001\u0010ú\u0001R \u0010ÿ\u0001\u001a\t\u0012\u0005\u0012\u00030ü\u00010x8\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bý\u0001\u0010þ\u0001R!\u0010\u0002\u001a\n\u0012\u0005\u0012\u00030\u00020\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0002\u0010\u0001R\u0019\u00103\u001a\u0004\u0018\u00010g8\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\bf\u0010\u0002R!\u0010\u0002\u001a\n\u0012\u0005\u0012\u00030\u00020\u00028\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0002\u0010\u0002R\u001a\u0010\u0002\u001a\u00030\u00028\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0002\u0010\u0002R \u0010\u0002\u001a\t\u0012\u0005\u0012\u00030\u00020x8\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0002\u0010þ\u0001R\u0018\u0010\u0002\u001a\u0002088\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\bo\u0010\u0001R\u001a\u0010\u0002\u001a\u00030\u00028\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0002R\u0018\u0010\u0002\u001a\u00020,8\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\bu\u0010\u0001R\u001c\u0010\u0002\u001a\u0005\u0018\u00010\u00028\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0002\u0010\u0002R\u001a\u0010\u0002\u001a\u00030\u00028\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0002\u0010\u0002R\u001a\u0010 \u0002\u001a\u00030\u00028\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0002\u0010\u0002R!\u0010¥\u0002\u001a\u00030¡\u00028\u0016@\u0016X\u0004¢\u0006\u000f\n\u0005\b_\u0010¢\u0002\u001a\u0006\b£\u0002\u0010¤\u0002¨\u0006¨\u0002"}, d2 = {"Lcom/avito/android/advert_core/contactbar/AdvertContactsPresenterImpl;", "Lcom/avito/android/advert_core/contactbar/AdvertContactsPresenter;", "Lcom/avito/android/advert_core/contactbar/AdvertContactsView;", "view", "", "attachStickyView", "(Lcom/avito/android/advert_core/contactbar/AdvertContactsView;)V", "attachEmbeddedView", "Lcom/avito/android/advert_core/advert/AdvertCoreView;", "attachCoreView", "(Lcom/avito/android/advert_core/advert/AdvertCoreView;)V", "onResume", "()V", "detachView", "Lcom/avito/android/advert_core/advert/AdvertCoreRouter;", "routerAdvert", "setRouter", "(Lcom/avito/android/advert_core/advert/AdvertCoreRouter;)V", "Landroid/os/Bundle;", "saveState", "()Landroid/os/Bundle;", "state", "restoreState", "(Landroid/os/Bundle;)V", "", "context", "setContext", "(Ljava/lang/String;)V", "Lio/reactivex/rxjava3/core/Observable;", "profileClicks", "()Lio/reactivex/rxjava3/core/Observable;", "", "Lcom/avito/android/component/contact_bar/ContactBar$Action;", "actions", "Lcom/avito/android/remote/model/advert_details/ContactBarData;", "data", "bindStickyData", "(Ljava/util/List;Lcom/avito/android/remote/model/advert_details/ContactBarData;)V", "bindEmbeddedData", "bindSafeShowData", "(Lcom/avito/android/advert_core/contactbar/AdvertContactsView;Ljava/util/List;Lcom/avito/android/remote/model/advert_details/ContactBarData;)V", "Lcom/avito/android/remote/model/AdvertActions;", "contactBarActions", "(Lcom/avito/android/remote/model/AdvertActions;)Ljava/util/List;", "", "online", "updateOnlineStatus", "(Z)V", "source", "onPhoneCallShown", "Lcom/avito/android/deep_linking/links/PhoneLink;", "phoneLink", "onPhoneCallConfirmed", "(Lcom/avito/android/deep_linking/links/PhoneLink;Ljava/lang/String;)V", "onPhoneCallDismissed", "onPhoneCallCanceled", "", "duration", "onPhoneCallFinished", "(J)V", "notifySellerAboutCallIfNeeded", "showPhoneCallConfirmationIfNeeded", "phoneLinkFromExpressCvActivity", "showPhoneCallConfirmationAfterOnActivityResult", "(Lcom/avito/android/deep_linking/links/PhoneLink;)V", "showAntiFraudCheckList", "showFeedbackIfNeeded", "Lcom/avito/android/advert_core/contactbar/feedback/FeedbackDialog$Source;", "onFeedbackClose", "(Lcom/avito/android/advert_core/contactbar/feedback/FeedbackDialog$Source;)V", "feedback", "onFeedbackSend", "(Ljava/lang/String;Lcom/avito/android/advert_core/contactbar/feedback/FeedbackDialog$Source;)V", "onAcceptAntiFraudRule", "onShowMoreAntiFraudRule", "onCloseAntiFraudRule", "Landroid/os/Parcelable;", "authResultData", "onAuthSuccess", "(Landroid/os/Parcelable;)V", "Lcom/avito/android/deep_linking/links/DeepLink;", "link", "onMarketplaceWriteClick", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "Lcom/avito/android/advert_core/call_methods/CallMethods;", "callMethods", "onInAppCallSelected", "(Lcom/avito/android/advert_core/call_methods/CallMethods;)V", "onPhoneCallSelected", "locationId", "userSelectedLocationId", "Lcom/avito/android/job/progress_bar/ProgressBarResponse;", "result", "t", "(Lcom/avito/android/job/progress_bar/ProgressBarResponse;)V", AuthSource.SEND_ABUSE, "(Lcom/avito/android/advert_core/contactbar/AdvertContactsView;Lcom/avito/android/remote/model/advert_details/ContactBarData;Ljava/util/List;)V", "i", "phoneLoaded", "phoneNumberShown", "f", "(Lcom/avito/android/deep_linking/links/DeepLink;ZZ)V", "h", "Lcom/avito/android/deep_linking/links/PhoneLink$Call;", "callPhoneLink", "forceDial", "c", "(Lcom/avito/android/deep_linking/links/PhoneLink$Call;Z)V", "d", "l", "n", "p", "logcat", "domain", "r", "(Ljava/lang/String;Ljava/lang/String;)Z", AuthSource.OPEN_CHANNEL_LIST, "o", "j", AuthSource.BOOKING_ORDER, "Lcom/avito/android/ab_tests/models/ManuallyExposedAbTestGroup;", "testGroup", "", "dialogTitle", MessengerShareContentUtility.SUBTITLE, "userTextHint", "buttonText", "feedbackSource", "s", "(Lcom/avito/android/ab_tests/models/ManuallyExposedAbTestGroup;ILjava/lang/Integer;IILcom/avito/android/advert_core/contactbar/feedback/FeedbackDialog$Source;)V", "Lcom/avito/android/calls_shared/AppCallMethod;", "choice", "callUuid", "k", "(Lcom/avito/android/calls_shared/AppCallMethod;Ljava/lang/String;)V", VKApiConst.Q, "Lcom/avito/android/calls_shared/AppCallScenario;", "e", "()Lcom/avito/android/calls_shared/AppCallScenario;", "Lcom/avito/android/ab_tests/models/ExposedAbTestGroup;", "Lcom/avito/android/ab_tests/groups/SimpleTestGroupWithNone;", "T", "Lcom/avito/android/ab_tests/models/ExposedAbTestGroup;", "advertContactApplyWithoutChat", "Lcom/avito/android/advert_core/contactbar/AdvertActionIconFactory;", "x", "Lcom/avito/android/advert_core/contactbar/AdvertActionIconFactory;", "advertActionIconFactory", a2.g.r.g.a, "Lcom/avito/android/advert_core/advert/AdvertCoreRouter;", "router", "Lcom/avito/android/util/SchedulersFactory3;", "J", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Z", "hasToRequestProgressBar", "Lcom/avito/android/account/AccountStateProvider;", "D", "Lcom/avito/android/account/AccountStateProvider;", "accountStateProvider", "Ljava/lang/String;", "searchContext", "Lcom/avito/android/advert_core/contactbar/AdvertContactsView;", "stickyContactView", "Lcom/avito/android/advert_core/contactbar/feedback/FeedbackDialog$State;", "Lcom/avito/android/advert_core/contactbar/feedback/FeedbackDialog$State;", "feedbackDialogState", "Lcom/avito/android/ab_tests/models/AbTestGroup;", "Lcom/avito/android/ab_tests/groups/SimpleTestGroupWithControl2;", "M", "Lcom/avito/android/ab_tests/models/AbTestGroup;", "justDialSellerPhoneTestGroup", "dialerOpen", "Lcom/avito/android/ab_tests/groups/SendEmployersPhoneOnCallToSellerButtonClickInResumesTestGroup;", "U", "sendEmployersPhoneTestGroup", "Lcom/avito/android/advert_core/feedback/FeedbackPreferences;", "H", "Lcom/avito/android/advert_core/feedback/FeedbackPreferences;", "feedbackPreferences", "feedbackDialogShouldShown", "Lcom/avito/android/remote/model/advert_details/ContactBarData;", LegacyPhotoGalleryActivityKt.LEGACY_PHOTO_GALLERY_KEY_CONTACT_DATA, "Lcom/avito/android/advert_core/messenger/AdvertMessengerInteractor;", "z", "Lcom/avito/android/advert_core/messenger/AdvertMessengerInteractor;", "advertMessengerInteractor", "Lcom/avito/android/advert_core/contactbar/AdvertContactsInteractor;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/avito/android/advert_core/contactbar/AdvertContactsInteractor;", "advertContactsInteractor", "Ljava/util/List;", "getActions", "()Ljava/util/List;", "setActions", "(Ljava/util/List;)V", "Lcom/avito/android/ab_tests/models/SingleManuallyExposedAbTestGroup;", "Lcom/avito/android/ab_tests/configs/AntiFraudCheckListTestGroup;", "N", "Lcom/avito/android/ab_tests/models/SingleManuallyExposedAbTestGroup;", "antiFraudCheckListTestGroup", "Lio/reactivex/rxjava3/disposables/Disposable;", "Lio/reactivex/rxjava3/disposables/Disposable;", "phoneRequestSubscription", "Lcom/avito/android/advert_core/advert/AdvertCoreView;", "coreView", "u", "Lcom/avito/android/job/progress_bar/ProgressBarResponse;", "progressBarResult", "Lcom/avito/android/advert_core/contactbar/AdvertContactsResourceProvider;", ExifInterface.LONGITUDE_EAST, "Lcom/avito/android/advert_core/contactbar/AdvertContactsResourceProvider;", "resourceProvider", "Lcom/avito/android/advert_core/contactbar/feedback/FeedbackInteractor;", "C", "Lcom/avito/android/advert_core/contactbar/feedback/FeedbackInteractor;", "feedbackInteractor", "startTimeOfPurchaseButtonClick", "Lcom/avito/android/util/preferences/Preferences;", "O", "Lcom/avito/android/util/preferences/Preferences;", "preferences", "Lcom/avito/android/advert_core/analytics/AdvertDetailsAnalyticsInteractor;", "B", "Lcom/avito/android/advert_core/analytics/AdvertDetailsAnalyticsInteractor;", "analyticsInteractor", "embeddedContactView", "Lcom/avito/android/Features;", "K", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/calls_shared/AppCallsUsageTracker;", "Q", "Lcom/avito/android/calls_shared/AppCallsUsageTracker;", "appCallUsageTracker", "Lcom/jakewharton/rxrelay3/PublishRelay;", VKApiConst.VERSION, "Lcom/jakewharton/rxrelay3/PublishRelay;", "Lcom/avito/android/advert_core/contactbar/SourceScreen;", "L", "Lcom/avito/android/advert_core/contactbar/SourceScreen;", "fromScreen", "shouldNotifySellerAboutCall", "Lcom/avito/android/analytics/Analytics;", "I", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/permissions/PermissionChecker;", "P", "Lcom/avito/android/permissions/PermissionChecker;", "permissionChecker", "Lcom/avito/android/ab_tests/groups/AdvertDetailsMarketplaceNoPurchaseFeedbackTestGroup;", ExifInterface.LATITUDE_SOUTH, "Lcom/avito/android/ab_tests/models/ManuallyExposedAbTestGroup;", "marketplaceNoPurchaseFeedbackTestGroup", "Lcom/avito/android/ab_tests/groups/SimpleTestGroup;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "jobApplicationProgressBarTestGroup", "Lcom/avito/android/deep_linking/links/PhoneLink$Call;", "Lcom/avito/android/util/Formatter;", "Lcom/avito/android/remote/model/AdvertPrice;", "F", "Lcom/avito/android/util/Formatter;", "priceFormatter", "Lcom/avito/android/advert_core/job/AdvertJobInteractor;", ExifInterface.LONGITUDE_WEST, "Lcom/avito/android/advert_core/job/AdvertJobInteractor;", "advertJobInteractor", "Lcom/avito/android/ab_tests/groups/AdvertDetailsNoCallFeedbackTestGroup;", "R", "noCallFeedbackTestGroup", "startTimeToOpenDialerOrChat", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "subscriptions", "isOpenDialerOrChat", "Lcom/avito/android/advert_core/marketplace/MarketplacePresenter;", "w", "Lcom/avito/android/advert_core/marketplace/MarketplacePresenter;", "marketplacePresenter", "Lcom/avito/android/profile/ProfileInfoStorage;", "y", "Lcom/avito/android/profile/ProfileInfoStorage;", "profileInfoStorage", "Lcom/avito/android/advert_core/contactbar/anti_fraud/AntiFraudPreferences;", "G", "Lcom/avito/android/advert_core/contactbar/anti_fraud/AntiFraudPreferences;", "antiFraudPreferences", "Lcom/avito/android/advert_core/sellerprofile/ShowSellersProfileSource;", "Lcom/avito/android/advert_core/sellerprofile/ShowSellersProfileSource;", "getProfileSourceName", "()Lcom/avito/android/advert_core/sellerprofile/ShowSellersProfileSource;", "profileSourceName", "<init>", "(Lcom/avito/android/advert_core/marketplace/MarketplacePresenter;Lcom/avito/android/advert_core/contactbar/AdvertActionIconFactory;Lcom/avito/android/profile/ProfileInfoStorage;Lcom/avito/android/advert_core/messenger/AdvertMessengerInteractor;Lcom/avito/android/advert_core/contactbar/AdvertContactsInteractor;Lcom/avito/android/advert_core/analytics/AdvertDetailsAnalyticsInteractor;Lcom/avito/android/advert_core/contactbar/feedback/FeedbackInteractor;Lcom/avito/android/account/AccountStateProvider;Lcom/avito/android/advert_core/contactbar/AdvertContactsResourceProvider;Lcom/avito/android/util/Formatter;Lcom/avito/android/advert_core/contactbar/anti_fraud/AntiFraudPreferences;Lcom/avito/android/advert_core/feedback/FeedbackPreferences;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/Features;Lcom/avito/android/advert_core/contactbar/SourceScreen;Lcom/avito/android/ab_tests/models/AbTestGroup;Lcom/avito/android/ab_tests/models/SingleManuallyExposedAbTestGroup;Lcom/avito/android/util/preferences/Preferences;Lcom/avito/android/permissions/PermissionChecker;Lcom/avito/android/calls_shared/AppCallsUsageTracker;Lcom/avito/android/ab_tests/models/ManuallyExposedAbTestGroup;Lcom/avito/android/ab_tests/models/ManuallyExposedAbTestGroup;Lcom/avito/android/ab_tests/models/ExposedAbTestGroup;Lcom/avito/android/ab_tests/models/AbTestGroup;Lcom/avito/android/ab_tests/models/ExposedAbTestGroup;Lcom/avito/android/advert_core/job/AdvertJobInteractor;)V", "advert-core_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertContactsPresenterImpl implements AdvertContactsPresenter {
    public final AdvertContactsInteractor A;
    public final AdvertDetailsAnalyticsInteractor B;
    public final FeedbackInteractor C;
    public final AccountStateProvider D;
    public final AdvertContactsResourceProvider E;
    public final Formatter<AdvertPrice> F;
    public final AntiFraudPreferences G;
    public final FeedbackPreferences H;
    public final Analytics I;
    public final SchedulersFactory3 J;
    public final Features K;
    public final SourceScreen L;
    public final AbTestGroup<SimpleTestGroupWithControl2> M;
    public final SingleManuallyExposedAbTestGroup<AntiFraudCheckListTestGroup> N;
    public final Preferences O;
    public final PermissionChecker P;
    public final AppCallsUsageTracker Q;
    public final ManuallyExposedAbTestGroup<AdvertDetailsNoCallFeedbackTestGroup> R;
    public final ManuallyExposedAbTestGroup<AdvertDetailsMarketplaceNoPurchaseFeedbackTestGroup> S;
    public final ExposedAbTestGroup<SimpleTestGroupWithNone> T;
    public final AbTestGroup<SendEmployersPhoneOnCallToSellerButtonClickInResumesTestGroup> U;
    public final ExposedAbTestGroup<SimpleTestGroup> V;
    public final AdvertJobInteractor W;
    @NotNull
    public final ShowSellersProfileSource a = ShowSellersProfileSource.CONTACT_BAR;
    @NotNull
    public List<ContactBar.Action> b = CollectionsKt__CollectionsKt.emptyList();
    public ContactBarData c;
    public AdvertContactsView d;
    public AdvertContactsView e;
    public AdvertCoreView f;
    public AdvertCoreRouter g;
    public PhoneLink.Call h;
    public boolean i;
    public Disposable j;
    public final CompositeDisposable k = new CompositeDisposable();
    public String l;
    public String m;
    public boolean n;
    public boolean o;
    public long p;
    public long q;
    public boolean r;
    public FeedbackDialog.State s;
    public boolean t;
    public ProgressBarResponse u;
    public final PublishRelay<Unit> v;
    public final MarketplacePresenter w;
    public final AdvertActionIconFactory x;
    public final ProfileInfoStorage y;
    public final AdvertMessengerInteractor z;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            ContactBar.ActionType.values();
            int[] iArr = new int[7];
            $EnumSwitchMapping$0 = iArr;
            iArr[0] = 1;
            iArr[1] = 2;
            iArr[4] = 3;
            iArr[5] = 4;
            SourceScreen.values();
            int[] iArr2 = new int[4];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[0] = 1;
            iArr2[2] = 2;
            iArr2[3] = 3;
            iArr2[1] = 4;
        }
    }

    /* compiled from: java-style lambda group */
    public static final class a<T> implements Consumer<Throwable> {
        public static final a b = new a(0);
        public static final a c = new a(1);
        public final /* synthetic */ int a;

        public a(int i) {
            this.a = i;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public final void accept(Throwable th) {
            int i = this.a;
            if (i == 0) {
                Logs.debug("AdvertDetailsContactsPresenter", "Failed to send respond", th);
            } else if (i == 1) {
                Logs.debug("AdvertDetailsContactsPresenter", "Failed to create chat to send employers phone", th);
            } else {
                throw null;
            }
        }
    }

    public static final class b extends Lambda implements Function1<ContactBar.Action, Unit> {
        public final /* synthetic */ AdvertContactsPresenterImpl a;
        public final /* synthetic */ ContactBarData b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(AdvertContactsPresenterImpl advertContactsPresenterImpl, ContactBarData contactBarData) {
            super(1);
            this.a = advertContactsPresenterImpl;
            this.b = contactBarData;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(ContactBar.Action action) {
            ContactBar.Action action2 = action;
            Intrinsics.checkNotNullParameter(action2, "it");
            this.a.c = this.b;
            AdvertContactsPresenterImpl.access$onContactActionClick(this.a, action2);
            return Unit.INSTANCE;
        }
    }

    public static final class c<T> implements Consumer<Channel> {
        public final /* synthetic */ AdvertContactsPresenterImpl a;

        public c(AdvertContactsPresenterImpl advertContactsPresenterImpl) {
            this.a = advertContactsPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Channel channel) {
            this.a.i();
        }
    }

    public static final class d<T> implements Consumer<Channel> {
        public static final d a = new d();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Channel channel) {
        }
    }

    public static final class e<T> implements Consumer<Boolean> {
        public final /* synthetic */ AdvertContactsPresenterImpl a;

        public e(AdvertContactsPresenterImpl advertContactsPresenterImpl) {
            this.a = advertContactsPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Boolean bool) {
            AdvertCoreView advertCoreView;
            Boolean bool2 = bool;
            Intrinsics.checkNotNullExpressionValue(bool2, "notified");
            if (bool2.booleanValue() && (advertCoreView = this.a.f) != null) {
                advertCoreView.showSellerNotifiedAboutCall();
            }
        }
    }

    public static final class f<T> implements Consumer<Throwable> {
        public static final f a = new f();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            Logs.debug("AdvertDetailsContactsPresenter", "Failed to send message about call", th);
        }
    }

    public static final class h implements Action {
        public final /* synthetic */ AdvertContactsPresenterImpl a;

        public h(AdvertContactsPresenterImpl advertContactsPresenterImpl) {
            this.a = advertContactsPresenterImpl;
        }

        @Override // io.reactivex.rxjava3.functions.Action
        public final void run() {
            AdvertCoreView advertCoreView = this.a.f;
            if (advertCoreView != null) {
                advertCoreView.dismissProgress();
            }
        }
    }

    public static final class i<T> implements Consumer<DelayedProgress<? extends CallMethods>> {
        public final /* synthetic */ AdvertContactsPresenterImpl a;

        public i(AdvertContactsPresenterImpl advertContactsPresenterImpl) {
            this.a = advertContactsPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(DelayedProgress<? extends CallMethods> delayedProgress) {
            DelayedProgress<? extends CallMethods> delayedProgress2 = delayedProgress;
            Logs.verbose$default("AdvertDetailsContactsPresenter", "Call methods loading state: " + delayedProgress2, null, 4, null);
            if (delayedProgress2 instanceof DelayedProgress.Loaded) {
                CallMethods callMethods = (CallMethods) ((DelayedProgress.Loaded) delayedProgress2).getData();
                this.a.q();
                if (callMethods.getInApp() != null) {
                    AdvertContactsPresenterImpl.access$sendCallMethodsShownEvent(this.a, callMethods.getInApp().getCallUuid());
                    this.a.l();
                    AdvertCoreView advertCoreView = this.a.f;
                    if (advertCoreView != null) {
                        advertCoreView.showCallMethods(callMethods);
                    }
                } else if (callMethods.getPhone() != null) {
                    AdvertContactsPresenterImpl.g(this.a, callMethods.getPhone().getDeepLink(), true, false, 4);
                }
                AdvertCoreView advertCoreView2 = this.a.f;
                if (advertCoreView2 != null) {
                    advertCoreView2.dismissProgress();
                }
            } else if (Intrinsics.areEqual(delayedProgress2, DelayedProgress.Loading.INSTANCE)) {
                AdvertCoreView advertCoreView3 = this.a.f;
                if (advertCoreView3 != null) {
                    advertCoreView3.showProgress();
                }
            } else if (delayedProgress2 instanceof DelayedProgress.Error) {
                AdvertCoreView advertCoreView4 = this.a.f;
                if (advertCoreView4 != null) {
                    advertCoreView4.dismissProgress();
                }
                AdvertCoreView advertCoreView5 = this.a.f;
                if (advertCoreView5 != null) {
                    advertCoreView5.showError(((DelayedProgress.Error) delayedProgress2).getError());
                }
            }
        }
    }

    public static final class j<T> implements Consumer<Throwable> {
        public final /* synthetic */ AdvertContactsPresenterImpl a;

        public j(AdvertContactsPresenterImpl advertContactsPresenterImpl) {
            this.a = advertContactsPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            Throwable th2 = th;
            AdvertCoreView advertCoreView = this.a.f;
            if (advertCoreView != null) {
                Intrinsics.checkNotNullExpressionValue(th2, "error");
                advertCoreView.showError(th2);
            }
        }
    }

    public static final class k<T> implements Consumer<TypedResult<ProgressBarResponse>> {
        public final /* synthetic */ AdvertContactsPresenterImpl a;

        public k(AdvertContactsPresenterImpl advertContactsPresenterImpl) {
            this.a = advertContactsPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(TypedResult<ProgressBarResponse> typedResult) {
            ProgressBarResponse progressBarResponse;
            TypedResult<ProgressBarResponse> typedResult2 = typedResult;
            if ((typedResult2 instanceof TypedResult.OfResult) && (progressBarResponse = (ProgressBarResponse) ((TypedResult.OfResult) typedResult2).getResult()) != null) {
                if (this.a.h != null || this.a.f == null) {
                    this.a.u = progressBarResponse;
                } else {
                    this.a.t(progressBarResponse);
                }
            }
        }
    }

    public static final class l<T> implements Consumer<Throwable> {
        public static final l a = new l();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            Logs.error("AdvertDetailsContactsPresenter", th);
        }
    }

    public static final class m extends Lambda implements Function0<Unit> {
        public final /* synthetic */ DeepLink a;
        public final /* synthetic */ AdvertContactsPresenterImpl b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public m(DeepLink deepLink, AdvertContactsPresenterImpl advertContactsPresenterImpl) {
            super(0);
            this.a = deepLink;
            this.b = advertContactsPresenterImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            AdvertContactsPresenterImpl.g(this.b, this.a, false, false, 6);
            return Unit.INSTANCE;
        }
    }

    @Inject
    public AdvertContactsPresenterImpl(@Nullable MarketplacePresenter marketplacePresenter, @NotNull AdvertActionIconFactory advertActionIconFactory, @NotNull ProfileInfoStorage profileInfoStorage, @NotNull AdvertMessengerInteractor advertMessengerInteractor, @NotNull AdvertContactsInteractor advertContactsInteractor, @NotNull AdvertDetailsAnalyticsInteractor advertDetailsAnalyticsInteractor, @NotNull FeedbackInteractor feedbackInteractor, @NotNull AccountStateProvider accountStateProvider, @NotNull AdvertContactsResourceProvider advertContactsResourceProvider, @NotNull Formatter<AdvertPrice> formatter, @NotNull AntiFraudPreferences antiFraudPreferences, @NotNull FeedbackPreferences feedbackPreferences, @NotNull Analytics analytics, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull Features features, @NotNull SourceScreen sourceScreen, @JustDialSellerPhoneTestGroup @NotNull AbTestGroup<SimpleTestGroupWithControl2> abTestGroup, @AntiFraudCheckList @NotNull SingleManuallyExposedAbTestGroup<AntiFraudCheckListTestGroup> singleManuallyExposedAbTestGroup, @Nullable Preferences preferences, @NotNull PermissionChecker permissionChecker, @NotNull AppCallsUsageTracker appCallsUsageTracker, @AdvertDetailsNoCallFeedback @NotNull ManuallyExposedAbTestGroup<AdvertDetailsNoCallFeedbackTestGroup> manuallyExposedAbTestGroup, @NotNull ManuallyExposedAbTestGroup<AdvertDetailsMarketplaceNoPurchaseFeedbackTestGroup> manuallyExposedAbTestGroup2, @AdvertContactApplyWithoutChat @NotNull ExposedAbTestGroup<SimpleTestGroupWithNone> exposedAbTestGroup, @SendEmployersPhoneOnCallToSellerButtonClickInResumes @NotNull AbTestGroup<SendEmployersPhoneOnCallToSellerButtonClickInResumesTestGroup> abTestGroup2, @JobApplicationProgressBar @NotNull ExposedAbTestGroup<SimpleTestGroup> exposedAbTestGroup2, @NotNull AdvertJobInteractor advertJobInteractor) {
        Intrinsics.checkNotNullParameter(advertActionIconFactory, "advertActionIconFactory");
        Intrinsics.checkNotNullParameter(profileInfoStorage, "profileInfoStorage");
        Intrinsics.checkNotNullParameter(advertMessengerInteractor, "advertMessengerInteractor");
        Intrinsics.checkNotNullParameter(advertContactsInteractor, "advertContactsInteractor");
        Intrinsics.checkNotNullParameter(advertDetailsAnalyticsInteractor, "analyticsInteractor");
        Intrinsics.checkNotNullParameter(feedbackInteractor, "feedbackInteractor");
        Intrinsics.checkNotNullParameter(accountStateProvider, "accountStateProvider");
        Intrinsics.checkNotNullParameter(advertContactsResourceProvider, "resourceProvider");
        Intrinsics.checkNotNullParameter(formatter, "priceFormatter");
        Intrinsics.checkNotNullParameter(antiFraudPreferences, "antiFraudPreferences");
        Intrinsics.checkNotNullParameter(feedbackPreferences, "feedbackPreferences");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(features, "features");
        Intrinsics.checkNotNullParameter(sourceScreen, "fromScreen");
        Intrinsics.checkNotNullParameter(abTestGroup, "justDialSellerPhoneTestGroup");
        Intrinsics.checkNotNullParameter(singleManuallyExposedAbTestGroup, "antiFraudCheckListTestGroup");
        Intrinsics.checkNotNullParameter(permissionChecker, "permissionChecker");
        Intrinsics.checkNotNullParameter(appCallsUsageTracker, "appCallUsageTracker");
        Intrinsics.checkNotNullParameter(manuallyExposedAbTestGroup, "noCallFeedbackTestGroup");
        Intrinsics.checkNotNullParameter(manuallyExposedAbTestGroup2, "marketplaceNoPurchaseFeedbackTestGroup");
        Intrinsics.checkNotNullParameter(exposedAbTestGroup, "advertContactApplyWithoutChat");
        Intrinsics.checkNotNullParameter(abTestGroup2, "sendEmployersPhoneTestGroup");
        Intrinsics.checkNotNullParameter(exposedAbTestGroup2, "jobApplicationProgressBarTestGroup");
        Intrinsics.checkNotNullParameter(advertJobInteractor, "advertJobInteractor");
        this.w = marketplacePresenter;
        this.x = advertActionIconFactory;
        this.y = profileInfoStorage;
        this.z = advertMessengerInteractor;
        this.A = advertContactsInteractor;
        this.B = advertDetailsAnalyticsInteractor;
        this.C = feedbackInteractor;
        this.D = accountStateProvider;
        this.E = advertContactsResourceProvider;
        this.F = formatter;
        this.G = antiFraudPreferences;
        this.H = feedbackPreferences;
        this.I = analytics;
        this.J = schedulersFactory3;
        this.K = features;
        this.L = sourceScreen;
        this.M = abTestGroup;
        this.N = singleManuallyExposedAbTestGroup;
        this.O = preferences;
        this.P = permissionChecker;
        this.Q = appCallsUsageTracker;
        this.R = manuallyExposedAbTestGroup;
        this.S = manuallyExposedAbTestGroup2;
        this.T = exposedAbTestGroup;
        this.U = abTestGroup2;
        this.V = exposedAbTestGroup2;
        this.W = advertJobInteractor;
        PublishRelay<Unit> create = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create, "PublishRelay.create()");
        this.v = create;
    }

    public static final void access$handleChatCreationError(AdvertContactsPresenterImpl advertContactsPresenterImpl, Throwable th) {
        AdvertCoreView advertCoreView = advertContactsPresenterImpl.f;
        if (advertCoreView != null) {
            AdvertCoreView.DefaultImpls.displayMessage$default(advertCoreView, advertContactsPresenterImpl.E.failedJobApplication(), null, null, null, 14, null);
        }
        Logs.error("AdvertDetailsContactsPresenter", th);
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00e6  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0117  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void access$onContactActionClick(com.avito.android.advert_core.contactbar.AdvertContactsPresenterImpl r6, com.avito.android.component.contact_bar.ContactBar.Action r7) {
        /*
        // Method dump skipped, instructions count: 302
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.advert_core.contactbar.AdvertContactsPresenterImpl.access$onContactActionClick(com.avito.android.advert_core.contactbar.AdvertContactsPresenterImpl, com.avito.android.component.contact_bar.ContactBar$Action):void");
    }

    public static final void access$sendCallMethodsShownEvent(AdvertContactsPresenterImpl advertContactsPresenterImpl, String str) {
        ContactBarData contactBarData = advertContactsPresenterImpl.c;
        advertContactsPresenterImpl.I.track(new ShowCallMethodsEvent(advertContactsPresenterImpl.e(), contactBarData != null ? contactBarData.getAdvertId() : null, str));
    }

    public static /* synthetic */ void g(AdvertContactsPresenterImpl advertContactsPresenterImpl, DeepLink deepLink, boolean z2, boolean z3, int i2) {
        if ((i2 & 2) != 0) {
            z2 = false;
        }
        if ((i2 & 4) != 0) {
            z3 = false;
        }
        advertContactsPresenterImpl.f(deepLink, z2, z3);
    }

    public final void a(AdvertContactsView advertContactsView, ContactBarData contactBarData, List<ContactBar.Action> list) {
        advertContactsView.showContactBar(contactBarData, list, new b(this, contactBarData));
    }

    @Override // com.avito.android.advert_core.contactbar.AdvertContactsPresenter
    public void attachCoreView(@Nullable AdvertCoreView advertCoreView) {
        this.f = advertCoreView;
    }

    @Override // com.avito.android.advert_core.contactbar.AdvertContactsPresenter
    public void attachEmbeddedView(@Nullable AdvertContactsView advertContactsView) {
        this.d = advertContactsView;
    }

    @Override // com.avito.android.advert_core.contactbar.AdvertContactsPresenter
    public void attachStickyView(@Nullable AdvertContactsView advertContactsView) {
        this.e = advertContactsView;
        if (advertContactsView != null) {
            CompositeDisposable compositeDisposable = this.k;
            Disposable subscribe = advertContactsView.profileClicks().subscribe(this.v);
            Intrinsics.checkNotNullExpressionValue(subscribe, "view.profileClicks().subscribe(profileClicks)");
            DisposableKt.plusAssign(compositeDisposable, subscribe);
            MarketplacePresenter marketplacePresenter = this.w;
            if (marketplacePresenter != null) {
                marketplacePresenter.attachView(advertContactsView);
            }
        }
    }

    public final void b() {
        String advertId;
        ContactBarData contactBarData = this.c;
        if (!(contactBarData == null || (advertId = contactBarData.getAdvertId()) == null)) {
            this.I.track(new CallToSellerConfirmedEvent(advertId, this.l));
        }
        this.h = null;
    }

    @Override // com.avito.android.advert_core.contactbar.AdvertContactsPresenter
    @MainThread
    public void bindEmbeddedData(@NotNull List<ContactBar.Action> list, @Nullable ContactBarData contactBarData) {
        Intrinsics.checkNotNullParameter(list, "actions");
        setActions(list);
        this.c = contactBarData;
        AdvertContactsView advertContactsView = this.d;
        if (advertContactsView != null) {
            a(advertContactsView, contactBarData, list);
        }
    }

    @Override // com.avito.android.advert_core.contactbar.AdvertContactsPresenter
    public void bindSafeShowData(@Nullable AdvertContactsView advertContactsView, @NotNull List<ContactBar.Action> list, @Nullable ContactBarData contactBarData) {
        Intrinsics.checkNotNullParameter(list, "actions");
        setActions(list);
        this.c = contactBarData;
        if (advertContactsView != null) {
            a(advertContactsView, contactBarData, list);
        }
    }

    @Override // com.avito.android.advert_core.contactbar.AdvertContactsPresenter
    @MainThread
    public void bindStickyData(@NotNull List<ContactBar.Action> list, @Nullable ContactBarData contactBarData) {
        Intrinsics.checkNotNullParameter(list, "actions");
        setActions(list);
        this.c = contactBarData;
        AdvertContactsView advertContactsView = this.e;
        if (advertContactsView != null) {
            a(advertContactsView, contactBarData, list);
        }
    }

    public final void c(PhoneLink.Call call, boolean z2) {
        ContactBarData contactBarData;
        String advertId;
        ContactBarData contactBarData2;
        String advertId2;
        l();
        this.h = call;
        if (z2 || this.M.getTestGroup().isTest()) {
            d(call);
        } else {
            AdvertCoreView advertCoreView = this.f;
            if (advertCoreView != null) {
                advertCoreView.showPhoneCallConfirmation(call, PhonePageSourceKt.PHONE_SOURCE_BUTTON);
            }
        }
        ContactBarData contactBarData3 = this.c;
        String str = null;
        if (!(!Intrinsics.areEqual(contactBarData3 != null ? contactBarData3.getCategoryId() : null, "111") || (contactBarData2 = this.c) == null || (advertId2 = contactBarData2.getAdvertId()) == null)) {
            CompositeDisposable compositeDisposable = this.k;
            Disposable subscribe = this.z.createChat(advertId2, AvitoMessengerApiKt.CHAT_CREATE_SOURCE_ITEM_CALL_BUTTON).observeOn(this.J.mainThread()).subscribe(new c(this), a.b);
            Intrinsics.checkNotNullExpressionValue(subscribe, "advertMessengerInteracto…  }\n                    )");
            DisposableKt.plusAssign(compositeDisposable, subscribe);
        }
        ContactBarData contactBarData4 = this.c;
        if (contactBarData4 != null) {
            str = contactBarData4.getCategoryId();
        }
        if (Intrinsics.areEqual(str, "112") && this.U.getTestGroup().isTest() && (contactBarData = this.c) != null && (advertId = contactBarData.getAdvertId()) != null) {
            CompositeDisposable compositeDisposable2 = this.k;
            Disposable subscribe2 = this.z.createChat(advertId, AvitoMessengerApiKt.CHAT_CREATE_SOURCE_ITEM_CALL_BUTTON).observeOn(this.J.mainThread()).subscribe(d.a, a.c);
            Intrinsics.checkNotNullExpressionValue(subscribe2, "advertMessengerInteracto…  }\n                    )");
            DisposableKt.plusAssign(compositeDisposable2, subscribe2);
        }
    }

    @Override // com.avito.android.advert_core.contactbar.AdvertContactsPresenter
    @NotNull
    public List<ContactBar.Action> contactBarActions(@Nullable AdvertActions advertActions) {
        ContactBar.ActionType actionType;
        ArrayList arrayList = null;
        if (advertActions != null) {
            List<AdvertAction> actions = advertActions.getActions();
            ArrayList arrayList2 = new ArrayList(t6.n.e.collectionSizeOrDefault(actions, 10));
            for (T t2 : actions) {
                Pair<Integer, Integer> actionIconRes = this.x.getActionIconRes(t2);
                int intValue = actionIconRes.component1().intValue();
                int intValue2 = actionIconRes.component2().intValue();
                String title = t2.getTitle();
                Integer valueOf = Integer.valueOf(intValue);
                DeepLink deepLink = t2.getDeepLink();
                if (deepLink == null) {
                    deepLink = new NoMatchLink();
                }
                boolean z2 = t2 instanceof AdvertAction.Messenger;
                boolean z3 = z2 && (t2.getDeepLink() instanceof AuthenticateLink) && this.K.getUnauthenticatedUserAnalytics().invoke().booleanValue();
                boolean z4 = t2 instanceof AdvertAction.Phone;
                if (z4) {
                    actionType = ContactBar.ActionType.PHONE;
                } else if (z2) {
                    actionType = ContactBar.ActionType.MESSENGER;
                } else if (t2 instanceof AdvertAction.Access) {
                    actionType = ContactBar.ActionType.ACCESS;
                } else if (t2 instanceof AdvertAction.Buy) {
                    actionType = ContactBar.ActionType.BUY;
                } else if (t2 instanceof AdvertAction.Cart) {
                    actionType = ContactBar.ActionType.CART;
                } else {
                    throw new NoWhenBranchMatchedException();
                }
                Boolean disabled = t2.getDisabled();
                boolean booleanValue = disabled != null ? disabled.booleanValue() : false;
                if (!(t2 instanceof AdvertAction.Cart)) {
                    t2 = null;
                }
                T t3 = t2;
                arrayList2.add(new ContactBar.Action(title, valueOf, intValue2, deepLink, z3, actionType, booleanValue, z4, t3 != null ? t3.getLogEvent() : null));
            }
            arrayList = arrayList2;
        }
        return arrayList != null ? arrayList : CollectionsKt__CollectionsKt.emptyList();
    }

    public final void d(PhoneLink phoneLink) {
        AdvertCoreRouter advertCoreRouter = this.g;
        boolean z2 = false;
        if (advertCoreRouter != null) {
            z2 = advertCoreRouter.dialPhone(phoneLink, PhonePageSourceKt.PHONE_SOURCE_BUTTON, false);
        }
        if (z2) {
            b();
            this.n = true;
            this.o = true;
            this.p = System.currentTimeMillis();
            return;
        }
        AdvertCoreView advertCoreView = this.f;
        if (advertCoreView != null) {
            advertCoreView.showPhoneCallConfirmation(phoneLink, "error");
        }
    }

    @Override // com.avito.android.advert_core.contactbar.AdvertContactsPresenter
    public void detachView() {
        Disposable disposable = this.j;
        if (disposable != null) {
            disposable.dispose();
        }
        this.j = null;
        this.k.clear();
        this.e = null;
        this.d = null;
        this.f = null;
        MarketplacePresenter marketplacePresenter = this.w;
        if (marketplacePresenter != null) {
            marketplacePresenter.detachViews();
        }
    }

    public final AppCallScenario e() {
        int ordinal = this.L.ordinal();
        if (ordinal != 0) {
            if (ordinal == 1) {
                return AppCallScenario.ITEM_GALLERY;
            }
            if (!(ordinal == 2 || ordinal == 3)) {
                throw new NoWhenBranchMatchedException();
            }
        }
        return AppCallScenario.ITEM_DETAILS;
    }

    public final void f(DeepLink deepLink, boolean z2, boolean z3) {
        DeliveryStartOrderingDeepLink deliveryStartOrderingDeepLink;
        String advertId;
        if (!(deepLink instanceof NoMatchLink)) {
            String str = null;
            boolean z4 = false;
            if (deepLink instanceof AuthenticateLink) {
                AdvertCoreView advertCoreView = this.f;
                if (advertCoreView != null) {
                    advertCoreView.dismissProgress();
                }
                AuthenticateLink authenticateLink = (AuthenticateLink) deepLink;
                String src = authenticateLink.getSrc();
                if (src == null || src.length() == 0) {
                    z4 = true;
                }
                String src2 = z4 ? AuthSource.TEST_7 : authenticateLink.getSrc();
                AdvertCoreRouter advertCoreRouter = this.g;
                if (advertCoreRouter != null) {
                    AdvertCoreRouter.DefaultImpls.onAuthRequired$default(advertCoreRouter, src2, null, 2, null);
                }
            } else if (deepLink instanceof ApplyPackageToAdvertContactsLink) {
                AdvertCoreView advertCoreView2 = this.f;
                if (advertCoreView2 != null) {
                    advertCoreView2.showContactAccessPackage(((ApplyPackageToAdvertContactsLink) deepLink).getItemId());
                }
            } else if (deepLink instanceof CvPackagesLink) {
                AdvertCoreRouter advertCoreRouter2 = this.g;
                if (advertCoreRouter2 != null) {
                    advertCoreRouter2.buyAdvertContacts((CvPackagesLink) deepLink);
                }
            } else if (deepLink instanceof CreateChannelLink) {
                CreateChannelLink createChannelLink = (CreateChannelLink) deepLink;
                ContactBarData contactBarData = this.c;
                if (!(contactBarData == null || (advertId = contactBarData.getAdvertId()) == null)) {
                    this.I.track(new WriteToSellerEvent(this.y.getProfileInfo().getEmail(), advertId));
                }
                n();
                p();
                m();
                o();
                j();
                ContactBarData contactBarData2 = this.c;
                if (contactBarData2 != null) {
                    str = contactBarData2.getCategoryId();
                }
                if (!Intrinsics.areEqual(str, "111") || !this.T.getTestGroup().isTest()) {
                    AdvertCoreRouter advertCoreRouter3 = this.g;
                    if (advertCoreRouter3 != null) {
                        advertCoreRouter3.followDeepLink(createChannelLink);
                    }
                    this.t = true;
                    this.n = false;
                    this.o = true;
                    this.p = System.currentTimeMillis();
                } else if (!this.D.isAuthorized()) {
                    AdvertCoreRouter advertCoreRouter4 = this.g;
                    if (advertCoreRouter4 != null) {
                        advertCoreRouter4.onAuthRequired(AuthSource.PHONE_REQUEST, createChannelLink);
                    }
                } else {
                    CompositeDisposable compositeDisposable = this.k;
                    Disposable subscribe = this.z.createChat(createChannelLink.getItemId(), createChannelLink.getSource()).observeOn(this.J.mainThread()).doOnSubscribe(new a2.a.a.g.e.a(this)).doOnTerminate(new a2.a.a.g.e.b(this)).subscribe(new a2.a.a.g.e.c(this), new a2.a.a.g.e.h(new Function1<Throwable, Unit>(this) { // from class: a2.a.a.g.e.d
                        /* Return type fixed from 'java.lang.Object' to match base method */
                        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                        @Override // kotlin.jvm.functions.Function1
                        public Unit invoke(Throwable th) {
                            Throwable th2 = th;
                            Intrinsics.checkNotNullParameter(th2, "p1");
                            AdvertContactsPresenterImpl.access$handleChatCreationError((AdvertContactsPresenterImpl) this.receiver, th2);
                            return Unit.INSTANCE;
                        }
                    }));
                    Intrinsics.checkNotNullExpressionValue(subscribe, "advertMessengerInteracto…eationError\n            )");
                    DisposableKt.plusAssign(compositeDisposable, subscribe);
                }
            } else if (deepLink instanceof PhoneRequestLink) {
                if (z2) {
                    Logs.warning$default("AdvertDetailsContactsPresenter", "PhoneRequestLink was ignored to avoid repeated calls", null, 4, null);
                } else if (this.K.getMessengerInAppCalls().invoke().booleanValue()) {
                    h(deepLink);
                } else {
                    String itemId = ((PhoneRequestLink) deepLink).getItemId();
                    Disposable disposable = this.j;
                    if (!(disposable != null && !disposable.isDisposed())) {
                        this.j = this.A.getPhoneAction(itemId).observeOn(this.J.mainThread()).doOnSubscribe(new a2.a.a.g.e.e(this)).doAfterTerminate(new r3(0, this)).doOnDispose(new r3(1, this)).subscribe(new a2.a.a.g.e.f(this), new a2.a.a.g.e.g(this));
                    }
                }
            } else if (deepLink instanceof PhoneLink.Call) {
                if (z2) {
                    c((PhoneLink.Call) deepLink, z3);
                } else if (this.K.getMessengerInAppCalls().invoke().booleanValue()) {
                    h(deepLink);
                } else {
                    q();
                    c((PhoneLink.Call) deepLink, z3);
                }
            } else if (deepLink instanceof ExpressCvLink) {
                ExpressCvLink expressCvLink = (ExpressCvLink) deepLink;
                p();
                AdvertCoreRouter advertCoreRouter5 = this.g;
                if (advertCoreRouter5 != null) {
                    advertCoreRouter5.followDeepLink(expressCvLink);
                }
            } else if (deepLink instanceof DeliveryStartOrderingDeepLink) {
                this.q = System.currentTimeMillis();
                String str2 = this.m;
                if (str2 != null) {
                    deliveryStartOrderingDeepLink = ((DeliveryStartOrderingDeepLink) deepLink).copyWithNewLocationId(str2);
                } else {
                    deliveryStartOrderingDeepLink = (DeliveryStartOrderingDeepLink) deepLink;
                }
                AdvertCoreRouter advertCoreRouter6 = this.g;
                if (advertCoreRouter6 != null) {
                    advertCoreRouter6.followDeepLink(deliveryStartOrderingDeepLink);
                }
            } else if (deepLink instanceof DeliverySummaryDeepLink) {
                this.q = System.currentTimeMillis();
                AdvertCoreRouter advertCoreRouter7 = this.g;
                if (advertCoreRouter7 != null) {
                    advertCoreRouter7.followDeepLink(deepLink);
                }
            } else {
                AdvertCoreRouter advertCoreRouter8 = this.g;
                if (advertCoreRouter8 != null) {
                    advertCoreRouter8.followDeepLink(deepLink);
                }
            }
        }
    }

    @Override // com.avito.android.advert_core.contactbar.AdvertContactsPresenter
    @NotNull
    public List<ContactBar.Action> getActions() {
        return this.b;
    }

    @Override // com.avito.android.advert_core.sellerprofile.SellerProfileClickSource
    @NotNull
    public ShowSellersProfileSource getProfileSourceName() {
        return this.a;
    }

    public final void h(DeepLink deepLink) {
        ContactBarData contactBarData = this.c;
        if (contactBarData != null) {
            String categoryId = contactBarData.getCategoryId();
            boolean z2 = false;
            if (categoryId != null) {
                Disposable disposable = this.j;
                if (disposable != null && !disposable.isDisposed()) {
                    z2 = true;
                }
                if (!z2) {
                    AdvertContactsInteractor advertContactsInteractor = this.A;
                    String advertId = contactBarData.getAdvertId();
                    if (!(deepLink instanceof PhoneLink.Call)) {
                        deepLink = null;
                    }
                    Observable concatWith = DelayedProgressKt.toDelayedProgress$default(advertContactsInteractor.getCallMethods(advertId, categoryId, e(), (PhoneLink.Call) deepLink), this.J.computation(), 0, 0, 6, (Object) null).concatWith(Completable.timer(300, TimeUnit.MILLISECONDS, this.J.computation()));
                    Intrinsics.checkNotNullExpressionValue(concatWith, "concatWith(Completable.t…(delay, unit, scheduler))");
                    this.j = concatWith.observeOn(this.J.mainThread()).doFinally(new h(this)).subscribe(new i(this), new j(this));
                    return;
                }
                return;
            }
            g(this, deepLink, true, false, 4);
        }
    }

    public final void i() {
        ContactBarData contactBarData = this.c;
        if (Intrinsics.areEqual(contactBarData != null ? contactBarData.getCategoryId() : null, "111") && this.L == SourceScreen.ADVERT_DETAILS && this.V.getTestGroup().isTest()) {
            this.W.requestProgressData(contactBarData.getAdvertId(), contactBarData.getAdvertTitle(), contactBarData.getLocationId()).observeOn(this.J.mainThread()).subscribe(new k(this), l.a);
        }
    }

    public final void j() {
        ContactBarData contactBarData;
        if (this.K.getSendBuyerDevelopmentEventsToAdjust().invoke().booleanValue() && (contactBarData = this.c) != null && Intrinsics.areEqual(contactBarData.getCategoryId(), "24")) {
            if (CollectionsKt___CollectionsKt.contains(AdvertContactsPresenterKt.access$getDevelopmentMicrocategoriesList$p(), contactBarData.getMicroCategoryId())) {
                this.I.track(new BuyerDevelopmentContact(contactBarData.getAdvertId(), contactBarData.getCustomerValue(), contactBarData.getViewItemAndBuyerEventsParams()));
                String format = new SimpleDateFormat(DateUtilKt.serverFormat, Locale.getDefault()).format(new Date());
                Preferences preferences = this.O;
                String string = preferences != null ? preferences.getString(AdvertContactsPresenterKt.KEY_BUYER_EVENT_LAST_DAY) : null;
                if (string == null || (!Intrinsics.areEqual(string, format))) {
                    Preferences preferences2 = this.O;
                    if (preferences2 != null) {
                        preferences2.putString(AdvertContactsPresenterKt.KEY_BUYER_EVENT_LAST_DAY, format);
                    }
                    this.I.track(new BuyerNewDevelopmentDayEvent(contactBarData.getAdvertId(), contactBarData.getCustomerValue(), contactBarData.getViewItemAndBuyerEventsParams()));
                }
            }
            if (CollectionsKt___CollectionsKt.contains(AdvertContactsPresenterKt.access$getSecondarySellMicrocategoriesList$p(), contactBarData.getMicroCategoryId())) {
                this.I.track(new SecondarySellEvent(contactBarData.getAdvertId(), contactBarData.getCustomerValue(), contactBarData.getViewItemAndBuyerEventsParams()));
            }
        }
    }

    public final void k(AppCallMethod appCallMethod, String str) {
        ContactBarData contactBarData = this.c;
        this.I.track(new CallMethodSelectedEvent(e(), appCallMethod, contactBarData != null ? contactBarData.getAdvertId() : null, str));
    }

    public final void l() {
        String advertId;
        String str;
        SourceScreen sourceScreen;
        ContactBarData contactBarData = this.c;
        if (contactBarData != null && (advertId = contactBarData.getAdvertId()) != null) {
            ContactBarData contactBarData2 = this.c;
            String source = contactBarData2 != null ? contactBarData2.getSource() : null;
            String str2 = "o";
            if (source != null) {
                int hashCode = source.hashCode();
                if (hashCode != 100) {
                    if (hashCode == 111 && source.equals(str2)) {
                        sourceScreen = SourceScreen.SAFE_SHOW_DIALOG;
                        str = str2;
                        this.I.track(new CallToSellerEvent(advertId, this.y.getProfileInfo().getEmail(), this.l, str, Integer.valueOf(sourceScreen.getValue())));
                    }
                } else if (source.equals("d")) {
                    sourceScreen = SourceScreen.DISCOUNTS_DIALOG;
                    str = "d";
                    this.I.track(new CallToSellerEvent(advertId, this.y.getProfileInfo().getEmail(), this.l, str, Integer.valueOf(sourceScreen.getValue())));
                }
            }
            sourceScreen = SourceScreen.ADVERT_DETAILS;
            str2 = "r";
            str = str2;
            this.I.track(new CallToSellerEvent(advertId, this.y.getProfileInfo().getEmail(), this.l, str, Integer.valueOf(sourceScreen.getValue())));
        }
    }

    public final void m() {
        String adjustCategoryId;
        ContactBarData contactBarData;
        String advertId;
        ContactBarData contactBarData2 = this.c;
        if (contactBarData2 != null && (adjustCategoryId = contactBarData2.getAdjustCategoryId()) != null && (contactBarData = this.c) != null && (advertId = contactBarData.getAdvertId()) != null) {
            ContactBarData contactBarData3 = this.c;
            Map<String, String> map = null;
            Double customerValue = contactBarData3 != null ? contactBarData3.getCustomerValue() : null;
            ContactBarData contactBarData4 = this.c;
            if (contactBarData4 != null) {
                map = contactBarData4.getViewItemAndBuyerEventsParams();
            }
            this.I.track(new ContactSellerCategoryEvent(adjustCategoryId, advertId, customerValue, map));
        }
    }

    public final void n() {
        String advertId;
        Map<String, String> viewItemAndBuyerEventsParams;
        String str;
        String advertId2;
        String email = this.y.getProfileInfo().getEmail();
        ContactBarData contactBarData = this.c;
        if (contactBarData != null && (advertId = contactBarData.getAdvertId()) != null) {
            ContactBarData contactBarData2 = this.c;
            Map<String, String> map = null;
            Double customerValue = contactBarData2 != null ? contactBarData2.getCustomerValue() : null;
            ContactBarData contactBarData3 = this.c;
            this.I.track(new ContactSellerEvent(email, advertId, customerValue, contactBarData3 != null ? contactBarData3.getViewItemAndBuyerEventsParams() : null));
            ContactBarData contactBarData4 = this.c;
            if (contactBarData4 != null && (viewItemAndBuyerEventsParams = contactBarData4.getViewItemAndBuyerEventsParams()) != null && (str = viewItemAndBuyerEventsParams.get("logcat")) != null && r(str, "global")) {
                String email2 = this.y.getProfileInfo().getEmail();
                ContactBarData contactBarData5 = this.c;
                if (contactBarData5 != null && (advertId2 = contactBarData5.getAdvertId()) != null) {
                    ContactBarData contactBarData6 = this.c;
                    Double customerValue2 = contactBarData6 != null ? contactBarData6.getCustomerValue() : null;
                    ContactBarData contactBarData7 = this.c;
                    if (contactBarData7 != null) {
                        map = contactBarData7.getViewItemAndBuyerEventsParams();
                    }
                    this.I.track(new NewBuyerEvent(email2, advertId2, customerValue2, map));
                }
            }
        }
    }

    @Override // com.avito.android.advert_core.contactbar.AdvertContactsPresenter
    public void notifySellerAboutCallIfNeeded() {
        String advertId;
        ContactBarData contactBarData = this.c;
        if (contactBarData != null && (advertId = contactBarData.getAdvertId()) != null && this.i) {
            this.i = false;
            CompositeDisposable compositeDisposable = this.k;
            Disposable subscribe = this.z.notifySellerAboutCall(advertId).observeOn(this.J.mainThread()).subscribe(new e(this), f.a);
            Intrinsics.checkNotNullExpressionValue(subscribe, "advertMessengerInteracto…rror) }\n                )");
            DisposableKt.plusAssign(compositeDisposable, subscribe);
        }
    }

    public final void o() {
        ContactBarData contactBarData = this.c;
        if (contactBarData != null && contactBarData.getVehicleType().isNewAuto()) {
            this.I.track(new ContactSellerNewAutoEvent(contactBarData.getAdvertId(), contactBarData.getCustomerValue(), contactBarData.getViewItemAndBuyerEventsParams()));
        }
    }

    @Override // com.avito.android.advert_core.contactbar.AdvertContactsPresenter
    public void onAcceptAntiFraudRule() {
        this.G.setAntiFraudCheckListShowCount(5);
        this.I.track(AntiFraudCheckListClickButtonEvent.Companion.accept());
    }

    @Override // com.avito.android.advert_core.contactbar.AdvertContactsPresenter
    public void onAuthSuccess(@Nullable Parcelable parcelable) {
        if (!(parcelable instanceof DeepLink)) {
            parcelable = null;
        }
        DeepLink deepLink = (DeepLink) parcelable;
        if (deepLink != null) {
            g(this, deepLink, false, false, 6);
        }
    }

    @Override // com.avito.android.advert_core.contactbar.AdvertContactsPresenter
    public void onCloseAntiFraudRule() {
        this.I.track(new AntiFraudCheckListCloseEvent());
    }

    @Override // com.avito.android.advert_core.contactbar.feedback.FeedbackDialog.Listener
    public void onFeedbackClose(@Nullable FeedbackDialog.Source source) {
        Analytics analytics = this.I;
        ContactBarData contactBarData = this.c;
        String categoryId = contactBarData != null ? contactBarData.getCategoryId() : null;
        ContactBarData contactBarData2 = this.c;
        String microCategoryId = contactBarData2 != null ? contactBarData2.getMicroCategoryId() : null;
        ContactBarData contactBarData3 = this.c;
        analytics.track(new FeedbackCloseEvent(categoryId, microCategoryId, contactBarData3 != null ? contactBarData3.getAdvertId() : null, source));
        this.r = false;
        AdvertCoreView advertCoreView = this.f;
        if (advertCoreView != null) {
            AdvertFeedbackView.DefaultImpls.clearFeedbackState$default(advertCoreView, false, 1, null);
        }
    }

    @Override // com.avito.android.advert_core.contactbar.feedback.FeedbackDialog.Listener
    public void onFeedbackSend(@NotNull String str, @Nullable FeedbackDialog.Source source) {
        Intrinsics.checkNotNullParameter(str, "feedback");
        CompositeDisposable compositeDisposable = this.k;
        FeedbackInteractor feedbackInteractor = this.C;
        ContactBarData contactBarData = this.c;
        String advertId = contactBarData != null ? contactBarData.getAdvertId() : null;
        ContactBarData contactBarData2 = this.c;
        String userHashId = contactBarData2 != null ? contactBarData2.getUserHashId() : null;
        ContactBarData contactBarData3 = this.c;
        DisposableKt.plusAssign(compositeDisposable, SubscribersKt.subscribeBy$default(feedbackInteractor.sendFeedback(str, advertId, userHashId, contactBarData3 != null ? contactBarData3.getCategoryId() : null, source), new Function1<Throwable, Unit>(Logs.INSTANCE) { // from class: com.avito.android.advert_core.contactbar.AdvertContactsPresenterImpl.g
            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public Unit invoke(Throwable th) {
                Logs logs = (Logs) this.receiver;
                Logs.error(th);
                return Unit.INSTANCE;
            }
        }, (Function0) null, (Function1) null, 6, (Object) null));
        this.r = false;
        AdvertCoreView advertCoreView = this.f;
        if (advertCoreView != null) {
            advertCoreView.clearFeedbackState(true);
        }
    }

    @Override // com.avito.android.advert_core.call_methods.AdvertCallMethodsDialogFragment.Callback
    public void onInAppCallSelected(@NotNull CallMethods callMethods) {
        CallMethods.InApp inApp;
        Intrinsics.checkNotNullParameter(callMethods, "callMethods");
        ContactBarData contactBarData = this.c;
        if (contactBarData != null && (inApp = callMethods.getInApp()) != null) {
            this.Q.trackUsed();
            k(AppCallMethod.InAppCall.INSTANCE, inApp.getCallUuid());
            this.I.track(new InAppCallContacted(contactBarData.getAdvertId(), inApp.getCallUuid(), e(), this.P.checkPermission("android.permission.RECORD_AUDIO"), this.D.getCurrentUserId(), contactBarData.getUserHashId()));
            CallActivityRequest.Dial.NewCall newCall = new CallActivityRequest.Dial.NewCall(inApp.getCallUuid(), new CallerInfo(inApp.getCallTo(), contactBarData.getName(), contactBarData.getAvatar()), new ItemInfo(contactBarData.getAdvertId(), contactBarData.getAdvertTitle(), this.F.format(contactBarData.getAdvertPrice()), contactBarData.getAdvertImage()), e(), inApp.getCallAs());
            AdvertCoreRouter advertCoreRouter = this.g;
            if (advertCoreRouter != null) {
                advertCoreRouter.makeInAppCall(newCall);
            }
        }
    }

    @Override // com.avito.android.advert_core.contactbar.AdvertContactsPresenter
    public void onMarketplaceWriteClick(@NotNull DeepLink deepLink) {
        Intrinsics.checkNotNullParameter(deepLink, "link");
        ContactBarData contactBarData = this.c;
        if (contactBarData != null) {
            this.B.sendClickWrite(contactBarData, deepLink instanceof NoMatchLink, SourceScreen.ADVERT_DETAILS, this.l);
        }
        AdvertCoreRouter advertCoreRouter = this.g;
        if (advertCoreRouter != null) {
            advertCoreRouter.followDeepLink(deepLink);
        }
    }

    @Override // com.avito.android.advert_core.contactbar.AdvertContactsPresenter
    public void onPhoneCallCanceled() {
        this.n = true;
        this.o = true;
        this.p = System.currentTimeMillis();
        showFeedbackIfNeeded();
        this.n = false;
        ProgressBarResponse progressBarResponse = this.u;
        if (progressBarResponse != null) {
            t(progressBarResponse);
        }
    }

    @Override // com.avito.android.advert_core.contactbar.AdvertContactsPresenter
    public void onPhoneCallConfirmed(@NotNull PhoneLink phoneLink, @NotNull String str) {
        Intrinsics.checkNotNullParameter(phoneLink, "phoneLink");
        Intrinsics.checkNotNullParameter(str, "source");
        AdvertCoreRouter advertCoreRouter = this.g;
        boolean dialPhone = advertCoreRouter != null ? advertCoreRouter.dialPhone(phoneLink, str, true) : false;
        b();
        if (dialPhone) {
            this.n = true;
            this.o = true;
            this.p = System.currentTimeMillis();
        }
    }

    @Override // com.avito.android.advert_core.contactbar.AdvertContactsPresenter
    public void onPhoneCallDismissed() {
        this.h = null;
    }

    @Override // com.avito.android.advert_core.contactbar.AdvertContactsPresenter
    public void onPhoneCallFinished(long j2) {
        String advertId;
        T t2;
        boolean z2;
        ContactBarData contactBarData = this.c;
        if (contactBarData != null && (advertId = contactBarData.getAdvertId()) != null) {
            boolean z3 = false;
            boolean z4 = j2 > 0;
            if (z4) {
                this.I.track(new CallToSellerTrackedEvent(z4, 0, advertId, null, 8, null));
                return;
            }
            this.I.track(new CallToSellerTrackedEvent(z4, 0, advertId, null, 8, null));
            Iterator<T> it = getActions().iterator();
            while (true) {
                if (!it.hasNext()) {
                    t2 = null;
                    break;
                }
                t2 = it.next();
                if (t2.getType() == ContactBar.ActionType.MESSENGER) {
                    z2 = true;
                    continue;
                } else {
                    z2 = false;
                    continue;
                }
                if (z2) {
                    break;
                }
            }
            if (t2 != null) {
                z3 = true;
            }
            if (z3) {
                this.i = true;
                if (this.e != null || this.d != null) {
                    notifySellerAboutCallIfNeeded();
                }
            }
        }
    }

    @Override // com.avito.android.advert_core.call_methods.AdvertCallMethodsDialogFragment.Callback
    public void onPhoneCallSelected(@NotNull CallMethods callMethods) {
        DeepLink deepLink;
        Intrinsics.checkNotNullParameter(callMethods, "callMethods");
        CallMethods.Phone phone = callMethods.getPhone();
        if (phone != null && (deepLink = phone.getDeepLink()) != null) {
            CallMethods.InApp inApp = callMethods.getInApp();
            if (inApp != null) {
                k(AppCallMethod.PhoneCall.INSTANCE, inApp.getCallUuid());
            }
            f(deepLink, true, deepLink instanceof PhoneLink);
        }
    }

    @Override // com.avito.android.advert_core.contactbar.AdvertContactsPresenter
    public void onPhoneCallShown(@NotNull String str) {
        String advertId;
        Intrinsics.checkNotNullParameter(str, "source");
        ContactBarData contactBarData = this.c;
        if (contactBarData != null && (advertId = contactBarData.getAdvertId()) != null) {
            this.I.track(new ShowPhoneDialogEvent(advertId, str));
        }
    }

    @Override // com.avito.android.advert_core.contactbar.AdvertContactsPresenter
    public void onResume() {
        showFeedbackIfNeeded();
        if (this.t) {
            i();
            this.t = false;
        }
        ProgressBarResponse progressBarResponse = this.u;
        if (progressBarResponse != null) {
            t(progressBarResponse);
        }
    }

    @Override // com.avito.android.advert_core.contactbar.AdvertContactsPresenter
    public void onShowMoreAntiFraudRule() {
        AdvertCoreRouter advertCoreRouter = this.g;
        if (advertCoreRouter != null) {
            Uri parse = Uri.parse("https://support.avito.ru/articles/1390");
            Intrinsics.checkNotNullExpressionValue(parse, "Uri.parse(ANTI_FRAUD_CHECK_LIST_URL)");
            advertCoreRouter.followUri(parse);
        }
        this.G.setAntiFraudCheckListShowCount(5);
        this.I.track(AntiFraudCheckListClickButtonEvent.Companion.showMore());
    }

    public final void p() {
        AdvertisementVerticalAlias verticalAlias;
        ContactBarData contactBarData;
        String advertId;
        Map<String, String> viewItemAndBuyerEventsParams;
        String str;
        ContactBarData contactBarData2;
        String advertId2;
        ContactBarData contactBarData3 = this.c;
        if (contactBarData3 != null && (verticalAlias = contactBarData3.getVerticalAlias()) != null && (contactBarData = this.c) != null && (advertId = contactBarData.getAdvertId()) != null) {
            ContactBarData contactBarData4 = this.c;
            Map<String, String> map = null;
            Double customerValue = contactBarData4 != null ? contactBarData4.getCustomerValue() : null;
            ContactBarData contactBarData5 = this.c;
            this.I.track(new ContactSellerVerticalEvent(verticalAlias, advertId, customerValue, contactBarData5 != null ? contactBarData5.getViewItemAndBuyerEventsParams() : null));
            ContactBarData contactBarData6 = this.c;
            if (contactBarData6 != null && (viewItemAndBuyerEventsParams = contactBarData6.getViewItemAndBuyerEventsParams()) != null && (str = viewItemAndBuyerEventsParams.get("logcat")) != null) {
                ContactBarData contactBarData7 = this.c;
                if ((contactBarData7 != null ? contactBarData7.getVerticalAlias() : null) == AdvertisementVerticalAlias.REALTY && r(str, "re") && (contactBarData2 = this.c) != null && (advertId2 = contactBarData2.getAdvertId()) != null) {
                    ContactBarData contactBarData8 = this.c;
                    Double customerValue2 = contactBarData8 != null ? contactBarData8.getCustomerValue() : null;
                    ContactBarData contactBarData9 = this.c;
                    if (contactBarData9 != null) {
                        map = contactBarData9.getViewItemAndBuyerEventsParams();
                    }
                    this.I.track(new NewBuyerRealtyEvent(advertId2, customerValue2, map));
                }
            }
        }
    }

    @Override // com.avito.android.advert_core.sellerprofile.SellerProfileClickSource
    @NotNull
    public Observable<Unit> profileClicks() {
        return this.v;
    }

    public final void q() {
        n();
        p();
        m();
        o();
        j();
    }

    public final boolean r(String str, String str2) {
        long currentTimeMillis = System.currentTimeMillis();
        Preferences preferences = this.O;
        if (preferences != null) {
            if (TimeUnit.DAYS.convert(currentTimeMillis - preferences.getLong(FirstTimeRunTaskKt.FIRST_TIME_RUN, 0), TimeUnit.MILLISECONDS) > ((long) 364)) {
                return false;
            }
            Preferences preferences2 = this.O;
            if (!preferences2.getBoolean(str2 + '_' + str)) {
                Preferences preferences3 = this.O;
                preferences3.putBoolean(str2 + '_' + str, true);
                return true;
            }
        }
        return false;
    }

    @Override // com.avito.android.advert_core.contactbar.AdvertContactsPresenter
    public void restoreState(@Nullable Bundle bundle) {
        List<ContactBar.Action> list;
        Bundle bundle2 = null;
        this.h = bundle != null ? (PhoneLink.Call) bundle.getParcelable("phoneLink") : null;
        boolean z2 = false;
        this.i = bundle != null ? bundle.getBoolean("shoudNotifySeller") : false;
        this.n = bundle != null ? bundle.getBoolean("dialerOpen") : false;
        this.o = bundle != null ? bundle.getBoolean("isOpenDialerOrChat") : false;
        long j2 = 0;
        this.p = bundle != null ? bundle.getLong("startTimeToOpenDialer") : 0;
        if (bundle != null) {
            j2 = bundle.getLong("startTimeOfPurchaseButtonClick");
        }
        this.q = j2;
        if (bundle != null) {
            z2 = bundle.getBoolean("feedbackDialogShouldBeShown");
        }
        this.r = z2;
        this.s = bundle != null ? (FeedbackDialog.State) bundle.getParcelable("feedbackDialogState") : null;
        if (bundle == null || (list = Bundles.getParcelableList(bundle, "actions")) == null) {
            list = CollectionsKt__CollectionsKt.emptyList();
        }
        setActions(list);
        MarketplacePresenter marketplacePresenter = this.w;
        if (marketplacePresenter != null) {
            if (bundle != null) {
                bundle2 = bundle.getBundle(MarketplacePresenterKt.KEY_MARKETPLACE_STATE);
            }
            marketplacePresenter.restoreState(bundle2);
        }
    }

    public final void s(ManuallyExposedAbTestGroup<?> manuallyExposedAbTestGroup, @StringRes int i2, @StringRes Integer num, @StringRes int i3, @StringRes int i4, FeedbackDialog.Source source) {
        if (!this.H.wasFeedbackShown()) {
            if (manuallyExposedAbTestGroup != null) {
                manuallyExposedAbTestGroup.expose();
            }
            this.H.setFeedbackWasShown();
            AdvertCoreView advertCoreView = this.f;
            if (advertCoreView != null) {
                advertCoreView.showFeedback(new FeedbackDialog.State(i2, num, "", i3, i4, null), this);
            }
            this.r = true;
            Analytics analytics = this.I;
            String currentUserId = this.D.getCurrentUserId();
            ContactBarData contactBarData = this.c;
            String categoryId = contactBarData != null ? contactBarData.getCategoryId() : null;
            ContactBarData contactBarData2 = this.c;
            String microCategoryId = contactBarData2 != null ? contactBarData2.getMicroCategoryId() : null;
            ContactBarData contactBarData3 = this.c;
            analytics.track(new FeedbackShowEvent(currentUserId, categoryId, microCategoryId, contactBarData3 != null ? contactBarData3.getAdvertId() : null, null));
        }
    }

    @Override // com.avito.android.advert_core.contactbar.AdvertContactsPresenter
    @NotNull
    public Bundle saveState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("phoneLink", this.h);
        bundle.putBoolean("shoudNotifySeller", this.i);
        bundle.putBoolean("dialerOpen", this.n);
        bundle.putBoolean("isOpenDialerOrChat", this.o);
        bundle.putLong("startTimeToOpenDialer", this.p);
        bundle.putLong("startTimeOfPurchaseButtonClick", this.q);
        bundle.putBoolean("feedbackDialogShouldBeShown", this.r);
        AdvertCoreView advertCoreView = this.f;
        Bundle bundle2 = null;
        bundle.putParcelable("feedbackDialogState", advertCoreView != null ? advertCoreView.getFeedbackState() : null);
        Bundles.putParcelableList(bundle, "actions", getActions());
        MarketplacePresenter marketplacePresenter = this.w;
        if (marketplacePresenter != null) {
            bundle2 = marketplacePresenter.saveState();
        }
        bundle.putParcelable(MarketplacePresenterKt.KEY_MARKETPLACE_STATE, bundle2);
        return bundle;
    }

    @Override // com.avito.android.advert_core.contactbar.AdvertContactsPresenter
    public void setActions(@NotNull List<ContactBar.Action> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.b = list;
    }

    @Override // com.avito.android.advert_core.contactbar.AdvertContactsPresenter
    public void setContext(@Nullable String str) {
        this.l = str;
    }

    @Override // com.avito.android.advert_core.contactbar.AdvertContactsPresenter
    public void setRouter(@NotNull AdvertCoreRouter advertCoreRouter) {
        Intrinsics.checkNotNullParameter(advertCoreRouter, "routerAdvert");
        this.g = advertCoreRouter;
    }

    @Override // com.avito.android.advert_core.contactbar.AdvertContactsPresenter
    public void showAntiFraudCheckList() {
        int antiFraudCheckListShowCount;
        ContactBarData contactBarData = this.c;
        String categoryId = contactBarData != null ? contactBarData.getCategoryId() : null;
        if (!this.n) {
            return;
        }
        if ((categoryId == null || !AdvertContactsPresenterKt.access$getJobCategories$p().contains(categoryId)) && this.K.getAntiFraudCheckList().invoke().booleanValue()) {
            this.N.exposeIfNeeded();
            if (this.N.getTestGroup().showCheckList() && (antiFraudCheckListShowCount = this.G.getAntiFraudCheckListShowCount()) < 5) {
                AdvertCoreView advertCoreView = this.f;
                if (advertCoreView != null) {
                    advertCoreView.showAntiFraudCheckList();
                }
                this.G.setAntiFraudCheckListShowCount(antiFraudCheckListShowCount + 1);
                this.I.track(new AntiFraudCheckListShowEvent());
            }
        }
    }

    @Override // com.avito.android.advert_core.contactbar.AdvertContactsPresenter
    public void showFeedbackIfNeeded() {
        ContactBarData contactBarData;
        int i2;
        FeedbackDialog.State state;
        if (!this.r || (state = this.s) == null) {
            if (!this.o || !this.K.getNoCallFeedback().invoke().booleanValue() || !this.R.getTestGroup().isTest()) {
                if (this.K.getMarketplaceNoPurchaseFeedback().invoke().booleanValue() && this.S.getTestGroup().isTest() && (contactBarData = this.c) != null && contactBarData.isMarketPlace() && System.currentTimeMillis() - this.q < 15000) {
                    s(this.S, R.string.marketplace_no_purchase_feedback_title, Integer.valueOf(R.string.feedback_title_secondary), R.string.feedback_input_hint, R.string.feedback_send, null);
                }
            } else if (System.currentTimeMillis() - this.p < 10000) {
                if (this.n) {
                    i2 = R.string.no_call_feedback_title_call;
                } else {
                    i2 = R.string.no_call_feedback_title_send;
                }
                s(this.R, i2, Integer.valueOf(R.string.feedback_title_secondary), R.string.feedback_input_hint, R.string.feedback_send, null);
            }
            this.n = false;
            this.o = false;
            this.p = 0;
            this.q = 0;
            return;
        }
        AdvertCoreView advertCoreView = this.f;
        if (advertCoreView != null) {
            Intrinsics.checkNotNull(state);
            advertCoreView.showFeedback(state, this);
        }
    }

    @Override // com.avito.android.advert_core.contactbar.AdvertContactsPresenter
    public void showPhoneCallConfirmationAfterOnActivityResult(@Nullable PhoneLink phoneLink) {
        if (phoneLink instanceof PhoneLink.Call) {
            q();
            c((PhoneLink.Call) phoneLink, false);
        }
    }

    @Override // com.avito.android.advert_core.contactbar.AdvertContactsPresenter
    public void showPhoneCallConfirmationIfNeeded() {
        PhoneLink.Call call = this.h;
        if (call == null) {
            return;
        }
        if (this.M.getTestGroup().isTest()) {
            d(call);
            return;
        }
        AdvertCoreView advertCoreView = this.f;
        if (advertCoreView != null) {
            advertCoreView.showPhoneCallConfirmation(call, PhonePageSourceKt.PHONE_SOURCE_BUTTON);
        }
    }

    public final void t(ProgressBarResponse progressBarResponse) {
        DeepLink deeplink;
        com.avito.android.job.common.Action action = progressBarResponse.getAction();
        String title = action != null ? action.getTitle() : null;
        com.avito.android.job.common.Action action2 = progressBarResponse.getAction();
        m mVar = (action2 == null || (deeplink = action2.getDeeplink()) == null) ? null : new m(deeplink, this);
        AdvertCoreView advertCoreView = this.f;
        if (advertCoreView != null) {
            advertCoreView.displayMessage(progressBarResponse.getMessage(), title, mVar, SnackbarPosition.OVERLAY_VIEW_BOTTOM);
        }
        this.u = null;
    }

    @Override // com.avito.android.advert_core.contactbar.AdvertContactsPresenter
    public void updateOnlineStatus(boolean z2) {
        SellerOnlineStatus sellerOnlineStatus;
        ContactBarData contactBarData = this.c;
        if (contactBarData != null) {
            SellerOnlineStatus copy$default = SellerOnlineStatus.copy$default(contactBarData.getOnlineStatus(), z2, null, 2, null);
            this.c = ContactBarData.copy$default(contactBarData, null, copy$default, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, false, null, null, null, false, 33554429, null);
            AdvertContactsView advertContactsView = this.d;
            if (advertContactsView != null) {
                sellerOnlineStatus = copy$default;
                advertContactsView.updateOnlineStatus(contactBarData.getName(), sellerOnlineStatus);
            } else {
                sellerOnlineStatus = copy$default;
            }
            AdvertContactsView advertContactsView2 = this.e;
            if (advertContactsView2 != null) {
                advertContactsView2.updateOnlineStatus(contactBarData.getName(), sellerOnlineStatus);
            }
        }
    }

    @Override // com.avito.android.advert_core.contactbar.AdvertContactsPresenter
    public void userSelectedLocationId(@Nullable String str) {
        this.m = str;
    }
}
