package com.avito.android.user_advert.advert;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.AuthIntentFactory;
import com.avito.android.Features;
import com.avito.android.FeesIntentFactory;
import com.avito.android.ItemMapIntentFactory;
import com.avito.android.PhotoGalleryIntentFactory;
import com.avito.android.PublishIntentFactory;
import com.avito.android.UserAdvertsIntentFactory;
import com.avito.android.advert_core.R;
import com.avito.android.advert_core.advert_badge_bar.AdvertBadgeBarPresenter;
import com.avito.android.advert_core.analytics.delivery.DeliveryEventTracker;
import com.avito.android.advert_core.analytics.sharing.AdvertSharingEventTracker;
import com.avito.android.advert_core.car_market_price.badge.AdvertDetailsImvBadgePresenter;
import com.avito.android.advert_core.car_market_price.price_chart.CarMarketPriceChartPresenter;
import com.avito.android.advert_core.delivery.AdvertDeliveryBlockView;
import com.avito.android.advert_core.delivery.AdvertDeliveryBlockViewModel;
import com.avito.android.advert_core.safedeal.MyAdvertSafeDealServicesView;
import com.avito.android.advert_core.safedeal.MyAdvertSafeDealServicesViewModel;
import com.avito.android.advert_core.short_term_rent.AdvertStrBlockView;
import com.avito.android.advert_core.short_term_rent.AdvertStrBlockViewImpl;
import com.avito.android.advert_core.short_term_rent.AdvertStrBlockViewModel;
import com.avito.android.advert_core.social.SocialPresenter;
import com.avito.android.advert_core.social.SocialShareListener;
import com.avito.android.advert_core.social.SocialViewImpl;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.screens.Timer;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.deep_linking.DeepLinkFactory;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.deep_linking.links.ChannelDetailsLink;
import com.avito.android.deep_linking.links.ChannelsLink;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.FeeMethodsLink;
import com.avito.android.deep_linking.links.ItemStatsLink;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.lastclick.LastClick;
import com.avito.android.lib.design.snackbar.SnackbarExtensionsKt;
import com.avito.android.lib.design.snackbar.SnackbarPosition;
import com.avito.android.lib.design.snackbar.SnackbarType;
import com.avito.android.location.analytics.FindLocationPage;
import com.avito.android.permissions.ActivityPermissionHelper;
import com.avito.android.permissions.PermissionHelper;
import com.avito.android.permissions.PermissionState;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.CloseReason;
import com.avito.android.remote.model.Coordinates;
import com.avito.android.remote.model.ForegroundImage;
import com.avito.android.remote.model.GeoReference;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.VerificationStep;
import com.avito.android.remote.model.Video;
import com.avito.android.social.SharingManager;
import com.avito.android.social.SignInSocialManager;
import com.avito.android.social.SocialTypeToStringMapper;
import com.avito.android.ui.activity.BaseActivity;
import com.avito.android.user_advert.AdvertActionTransferData;
import com.avito.android.user_advert.UserAdvertConstantsKt;
import com.avito.android.user_advert.advert.MyAdvertDetailsViewPresenter;
import com.avito.android.user_advert.advert.autobooking_block.AutoBookingBlockViewModel;
import com.avito.android.user_advert.advert.autobooking_block.AutoBookingSwitcherBlockView;
import com.avito.android.user_advert.advert.autopublish_block.AutoPublishBlockViewModel;
import com.avito.android.user_advert.advert.autopublish_block.AutoPublishSwitcherBlockView;
import com.avito.android.user_advert.advert.feature_teasers.MyAdvertDetailsFeatureTeaserViewFactory;
import com.avito.android.user_advert.contact.MyAdvertContactsPresenter;
import com.avito.android.user_advert.contact.MyAdvertContactsView;
import com.avito.android.user_advert.contact.MyAdvertContactsViewImpl;
import com.avito.android.user_advert.di.DaggerMyAdvertDetailsComponent;
import com.avito.android.user_advert.di.DaggerMyDraftDetailsComponent;
import com.avito.android.user_advert.di.DetailsComponentBuilder;
import com.avito.android.user_advert.di.MyAdvertDetailsComponent;
import com.avito.android.user_advert.di.MyAdvertDetailsDependencies;
import com.avito.android.user_advert.di.MyDraftDetailsComponent;
import com.avito.android.user_advert.event.StatButtonClickEvent;
import com.avito.android.user_advert.soa_with_price.SoaWithPriceArguments;
import com.avito.android.user_advert.soa_with_price.SoaWithPriceResultHandler;
import com.avito.android.user_advert.soa_with_price.SoaWithPriceSheetDialogFragmentKt;
import com.avito.android.user_advert.tracker.MyAdvertDetailsTracker;
import com.avito.android.user_adverts_common.safety.UserAdvertConstants;
import com.avito.android.util.Bundles;
import com.avito.android.util.Constants;
import com.avito.android.util.Contexts;
import com.avito.android.util.DialogRouter;
import com.avito.android.util.ImplicitIntentFactory;
import com.avito.android.util.IntentsKt;
import com.avito.android.util.Logs;
import com.avito.android.util.Views;
import com.avito.android.util.text.AttributedTextFormatter;
import com.facebook.appevents.integrity.IntegrityManager;
import com.facebook.share.internal.ShareConstants;
import com.google.android.material.snackbar.Snackbar;
import com.vk.sdk.api.VKApiConst;
import java.net.URL;
import java.util.List;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¤\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 º\u00022\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u00072\u00020\b2\u00020\t:\u0002º\u0002B\b¢\u0006\u0005\b¹\u0002\u0010\u0019J\u0013\u0010\f\u001a\u00020\u000b*\u00020\nH\u0002¢\u0006\u0004\b\f\u0010\rJ#\u0010\u0012\u001a\u00020\u00102\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000eH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0016\u001a\u00020\u00102\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0010H\u0014¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0010H\u0014¢\u0006\u0004\b\u001a\u0010\u0019J\u0017\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u0010H\u0014¢\u0006\u0004\b\u001f\u0010\u0019J!\u0010#\u001a\u00020\u00102\u0006\u0010!\u001a\u00020 2\b\u0010\"\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b#\u0010$J\u0019\u0010&\u001a\u00020%2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0014¢\u0006\u0004\b&\u0010'J7\u0010/\u001a\u00020\u00102\u0006\u0010(\u001a\u00020\u000f2\u0006\u0010*\u001a\u00020)2\u0006\u0010+\u001a\u00020\u000f2\u000e\u0010.\u001a\n\u0012\u0004\u0012\u00020-\u0018\u00010,H\u0016¢\u0006\u0004\b/\u00100J\u0017\u00102\u001a\u00020\u00102\u0006\u00101\u001a\u00020\nH\u0014¢\u0006\u0004\b2\u00103J\u0017\u00105\u001a\u00020\u00102\u0006\u00104\u001a\u00020\u0014H\u0014¢\u0006\u0004\b5\u0010\u0017J\u000f\u00106\u001a\u00020%H\u0014¢\u0006\u0004\b6\u00107J3\u0010>\u001a\u00020\u00102\u0006\u00109\u001a\u0002082\u0006\u0010:\u001a\u00020%2\b\u0010;\u001a\u0004\u0018\u00010\u000f2\b\u0010=\u001a\u0004\u0018\u00010<H\u0016¢\u0006\u0004\b>\u0010?J\u0017\u0010A\u001a\u00020\u00102\u0006\u0010@\u001a\u00020\u000fH\u0016¢\u0006\u0004\bA\u0010BJ)\u0010F\u001a\u00020\u00102\u0006\u0010C\u001a\u0002082\u0006\u0010D\u001a\u0002082\b\u0010E\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\bF\u0010GJ-\u0010L\u001a\u00020\u00102\u0006\u0010C\u001a\u0002082\f\u0010I\u001a\b\u0012\u0004\u0012\u00020\u000f0H2\u0006\u0010K\u001a\u00020JH\u0016¢\u0006\u0004\bL\u0010MJ\u000f\u0010N\u001a\u000208H\u0014¢\u0006\u0004\bN\u0010OJ9\u0010W\u001a\u00020\u00102\b\u0010Q\u001a\u0004\u0018\u00010P2\f\u0010S\u001a\b\u0012\u0004\u0012\u00020R0,2\b\u0010U\u001a\u0004\u0018\u00010T2\u0006\u0010V\u001a\u000208H\u0016¢\u0006\u0004\bW\u0010XJ\u0017\u0010[\u001a\u00020\u00102\u0006\u0010Z\u001a\u00020YH\u0016¢\u0006\u0004\b[\u0010\\J5\u0010a\u001a\u00020\u00102\u0006\u0010Z\u001a\u00020]2\u0006\u0010^\u001a\u00020\u000f2\u0014\u0010`\u001a\u0010\u0012\u0004\u0012\u00020_\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000eH\u0016¢\u0006\u0004\ba\u0010bJ\u0017\u0010c\u001a\u00020%2\u0006\u0010Z\u001a\u00020]H\u0016¢\u0006\u0004\bc\u0010dJ\u0017\u0010g\u001a\u00020\u00102\u0006\u0010f\u001a\u00020eH\u0016¢\u0006\u0004\bg\u0010hJ\u0017\u0010j\u001a\u00020\u00102\u0006\u0010i\u001a\u00020\u000fH\u0016¢\u0006\u0004\bj\u0010BJ\u000f\u0010k\u001a\u00020\u0010H\u0016¢\u0006\u0004\bk\u0010\u0019J%\u0010m\u001a\u00020\u00102\u0006\u0010i\u001a\u00020\u000f2\f\u0010l\u001a\b\u0012\u0004\u0012\u00020 0,H\u0016¢\u0006\u0004\bm\u0010nJ%\u0010q\u001a\u00020\u00102\u0006\u0010i\u001a\u00020\u000f2\f\u0010p\u001a\b\u0012\u0004\u0012\u00020o0,H\u0016¢\u0006\u0004\bq\u0010nJ\u0017\u0010r\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u000fH\u0016¢\u0006\u0004\br\u0010BJ\u0017\u0010s\u001a\u00020\u00102\u0006\u0010:\u001a\u00020%H\u0016¢\u0006\u0004\bs\u0010tJ+\u0010w\u001a\u00020\u00102\u0006\u0010@\u001a\u00020\u000f2\b\u0010u\u001a\u0004\u0018\u00010\u000f2\b\u0010v\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\bw\u0010xJ\u0017\u0010z\u001a\u00020\u00102\u0006\u0010y\u001a\u00020\u000fH\u0016¢\u0006\u0004\bz\u0010BJ\u000f\u0010{\u001a\u00020\u0010H\u0016¢\u0006\u0004\b{\u0010\u0019J\u001f\u0010|\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u000f2\u0006\u0010+\u001a\u00020\u000fH\u0016¢\u0006\u0004\b|\u0010}J\u0019\u0010~\u001a\u00020\u00102\b\u0010=\u001a\u0004\u0018\u00010<H\u0016¢\u0006\u0004\b~\u0010J\u0011\u0010\u0001\u001a\u00020\u0010H\u0016¢\u0006\u0005\b\u0001\u0010\u0019J\u001a\u0010\u0001\u001a\u00020\u00102\u0007\u0010\u0001\u001a\u00020\u001bH\u0016¢\u0006\u0005\b\u0001\u0010\u001eJY\u0010\u0001\u001a\u00020\u00102\u0007\u0010\u0001\u001a\u00020\u000f2\u0007\u0010\u0001\u001a\u0002082\u0007\u0010\u0001\u001a\u0002082\t\u0010\u0001\u001a\u0004\u0018\u00010\u000f2\u0016\u0010u\u001a\u0012\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0001j\u0005\u0018\u0001`\u00012\u0007\u0010\u0001\u001a\u00020%H\u0016¢\u0006\u0006\b\u0001\u0010\u0001J!\u0010\u0001\u001a\u00020\u00102\u0006\u0010Z\u001a\u00020]2\u0007\u0010\u0001\u001a\u00020%¢\u0006\u0006\b\u0001\u0010\u0001J\u0019\u0010\u0001\u001a\u00020\u00102\u0006\u0010f\u001a\u00020eH\u0016¢\u0006\u0005\b\u0001\u0010hJ\u0019\u0010\u0001\u001a\u00020\u00102\u0006\u0010f\u001a\u00020eH\u0016¢\u0006\u0005\b\u0001\u0010hR*\u0010\u0001\u001a\u00030\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X.¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u0019\u0010\u0001\u001a\u00020\u000b8\u0002@\u0002X.¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001b\u0010¡\u0001\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0001\u0010 \u0001R*\u0010£\u0001\u001a\u00030¢\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\b£\u0001\u0010¤\u0001\u001a\u0006\b¥\u0001\u0010¦\u0001\"\u0006\b§\u0001\u0010¨\u0001R*\u0010ª\u0001\u001a\u00030©\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\bª\u0001\u0010«\u0001\u001a\u0006\b¬\u0001\u0010­\u0001\"\u0006\b®\u0001\u0010¯\u0001R*\u0010±\u0001\u001a\u00030°\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\b±\u0001\u0010²\u0001\u001a\u0006\b³\u0001\u0010´\u0001\"\u0006\bµ\u0001\u0010¶\u0001R\u001a\u0010º\u0001\u001a\u00030·\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b¸\u0001\u0010¹\u0001R*\u0010¼\u0001\u001a\u00030»\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\b¼\u0001\u0010½\u0001\u001a\u0006\b¾\u0001\u0010¿\u0001\"\u0006\bÀ\u0001\u0010Á\u0001R*\u0010Ã\u0001\u001a\u00030Â\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\bÃ\u0001\u0010Ä\u0001\u001a\u0006\bÅ\u0001\u0010Æ\u0001\"\u0006\bÇ\u0001\u0010È\u0001R*\u0010Ê\u0001\u001a\u00030É\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\bÊ\u0001\u0010Ë\u0001\u001a\u0006\bÌ\u0001\u0010Í\u0001\"\u0006\bÎ\u0001\u0010Ï\u0001R\u001c\u0010Ó\u0001\u001a\u0005\u0018\u00010Ð\u00018\u0002@\u0002X\u000e¢\u0006\b\n\u0006\bÑ\u0001\u0010Ò\u0001R*\u0010Õ\u0001\u001a\u00030Ô\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\bÕ\u0001\u0010Ö\u0001\u001a\u0006\b×\u0001\u0010Ø\u0001\"\u0006\bÙ\u0001\u0010Ú\u0001R*\u0010Ü\u0001\u001a\u00030Û\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\bÜ\u0001\u0010Ý\u0001\u001a\u0006\bÞ\u0001\u0010ß\u0001\"\u0006\bà\u0001\u0010á\u0001R\u0019\u0010ä\u0001\u001a\u00020%8\u0002@\u0002X\u000e¢\u0006\b\n\u0006\bâ\u0001\u0010ã\u0001R\u0019\u0010æ\u0001\u001a\u00020%8\u0002@\u0002X\u000e¢\u0006\b\n\u0006\bå\u0001\u0010ã\u0001R*\u0010è\u0001\u001a\u00030ç\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\bè\u0001\u0010é\u0001\u001a\u0006\bê\u0001\u0010ë\u0001\"\u0006\bì\u0001\u0010í\u0001R*\u0010ï\u0001\u001a\u00030î\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\bï\u0001\u0010ð\u0001\u001a\u0006\bñ\u0001\u0010ò\u0001\"\u0006\bó\u0001\u0010ô\u0001R*\u0010ö\u0001\u001a\u00030õ\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\bö\u0001\u0010÷\u0001\u001a\u0006\bø\u0001\u0010ù\u0001\"\u0006\bú\u0001\u0010û\u0001R*\u0010ý\u0001\u001a\u00030ü\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\bý\u0001\u0010þ\u0001\u001a\u0006\bÿ\u0001\u0010\u0002\"\u0006\b\u0002\u0010\u0002R\u001a\u0010\u0002\u001a\u00030\u00028\u0002@\u0002X.¢\u0006\b\n\u0006\b\u0002\u0010\u0002R*\u0010\u0002\u001a\u00030\u00028\u0006@\u0006X.¢\u0006\u0018\n\u0006\b\u0002\u0010\u0002\u001a\u0006\b\u0002\u0010\u0002\"\u0006\b\u0002\u0010\u0002R*\u0010\u0002\u001a\u00030\u00028\u0006@\u0006X.¢\u0006\u0018\n\u0006\b\u0002\u0010\u0002\u001a\u0006\b\u0002\u0010\u0002\"\u0006\b\u0002\u0010\u0002R\u001a\u0010\u0002\u001a\u00030\u00028\u0002@\u0002X.¢\u0006\b\n\u0006\b\u0002\u0010\u0002R\u001a\u0010\u0002\u001a\u00030\u00028\u0002@\u0002X.¢\u0006\b\n\u0006\b\u0002\u0010\u0002R*\u0010\u0002\u001a\u00030\u00028\u0006@\u0006X.¢\u0006\u0018\n\u0006\b\u0002\u0010\u0002\u001a\u0006\b \u0002\u0010¡\u0002\"\u0006\b¢\u0002\u0010£\u0002R*\u0010¥\u0002\u001a\u00030¤\u00028\u0006@\u0006X.¢\u0006\u0018\n\u0006\b¥\u0002\u0010¦\u0002\u001a\u0006\b§\u0002\u0010¨\u0002\"\u0006\b©\u0002\u0010ª\u0002R*\u0010¬\u0002\u001a\u00030«\u00028\u0006@\u0006X.¢\u0006\u0018\n\u0006\b¬\u0002\u0010­\u0002\u001a\u0006\b®\u0002\u0010¯\u0002\"\u0006\b°\u0002\u0010±\u0002R*\u0010³\u0002\u001a\u00030²\u00028\u0006@\u0006X.¢\u0006\u0018\n\u0006\b³\u0002\u0010´\u0002\u001a\u0006\bµ\u0002\u0010¶\u0002\"\u0006\b·\u0002\u0010¸\u0002¨\u0006»\u0002"}, d2 = {"Lcom/avito/android/user_advert/advert/MyAdvertDetailsActivity;", "Lcom/avito/android/ui/activity/BaseActivity;", "Lcom/avito/android/advert_core/social/SocialPresenter$Router;", "Lcom/avito/android/user_advert/advert/MyAdvertRouter;", "Lcom/avito/android/advert_core/delivery/AdvertDeliveryBlockView$Listener;", "Lcom/avito/android/advert_core/short_term_rent/AdvertStrBlockView$Listener;", "Lcom/avito/android/advert_core/short_term_rent/AdvertStrBlockViewModel$DeepLinkRouter;", "Lcom/avito/android/user_advert/soa_with_price/SoaWithPriceResultHandler;", "Lcom/avito/android/advert_core/advert_badge_bar/AdvertBadgeBarPresenter$Router;", "Lcom/avito/android/advert_core/car_market_price/price_chart/CarMarketPriceChartPresenter$Router;", "Landroid/content/Intent;", "Lcom/avito/android/user_advert/advert/DetailsId;", AuthSource.SEND_ABUSE, "(Landroid/content/Intent;)Lcom/avito/android/user_advert/advert/DetailsId;", "Lkotlin/Function1;", "", "", "block", AuthSource.BOOKING_ORDER, "(Lkotlin/jvm/functions/Function1;)V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "onStart", "()V", "onStop", "Landroid/net/Uri;", "url", "openUrl", "(Landroid/net/Uri;)V", "onDestroy", "Lcom/avito/android/remote/model/CloseReason;", "reason", "newPrice", "handleSoaWithPriceResult", "(Lcom/avito/android/remote/model/CloseReason;Ljava/lang/String;)V", "", "setUpActivityComponent", "(Landroid/os/Bundle;)Z", IntegrityManager.INTEGRITY_TYPE_ADDRESS, "Lcom/avito/android/remote/model/Coordinates;", "coordinates", "title", "", "Lcom/avito/android/remote/model/GeoReference;", "geoReferences", "showAddressOnMap", "(Ljava/lang/String;Lcom/avito/android/remote/model/Coordinates;Ljava/lang/String;Ljava/util/List;)V", "intent", "onNewIntent", "(Landroid/content/Intent;)V", "outState", "onSaveInstanceState", "setUpCustomToolbar", "()Z", "", "codeResult", "shouldShowAppRater", "soaUpdateMessage", "Lcom/avito/android/user_advert/AdvertActionTransferData;", "advertAction", "finish", "(IZLjava/lang/String;Lcom/avito/android/user_advert/AdvertActionTransferData;)V", "itemId", "showInactiveItem", "(Ljava/lang/String;)V", "requestCode", "resultCode", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "", "permissions", "", "grantResults", "onRequestPermissionsResult", "(I[Ljava/lang/String;[I)V", "getContentLayoutId", "()I", "Lcom/avito/android/remote/model/Video;", "video", "Lcom/avito/android/remote/model/Image;", "images", "Lcom/avito/android/remote/model/ForegroundImage;", "infoImage", "currentItem", "showGalleryFullscreen", "(Lcom/avito/android/remote/model/Video;Ljava/util/List;Lcom/avito/android/remote/model/ForegroundImage;I)V", "Lcom/avito/android/social/SignInSocialManager;", "socialManager", "login", "(Lcom/avito/android/social/SignInSocialManager;)V", "Lcom/avito/android/social/SharingManager;", "link", "Lcom/avito/android/social/SharingManager$ShareError;", "shareListener", "share", "(Lcom/avito/android/social/SharingManager;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "shouldRestoreShare", "(Lcom/avito/android/social/SharingManager;)Z", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "openDeepLink", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", BookingInfoActivity.EXTRA_ITEM_ID, "openFees", "onBackPressed", "reasons", "openSoaWithPriceBottomSheet", "(Ljava/lang/String;Ljava/util/List;)V", "Lcom/avito/android/remote/model/VerificationStep;", "steps", "openVerificationWizard", "showHelpCenterScreen", "launchNestedIntent", "(Z)V", "action", "focusId", "openEdit", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "draftId", "openDraftEdit", "openAuth", "openSharing", "(Ljava/lang/String;Ljava/lang/String;)V", "openUserAdvertsScreen", "(Lcom/avito/android/user_advert/AdvertActionTransferData;)V", "reopenScreen", ShareConstants.MEDIA_URI, "followUri", "text", "length", "maxLine", "actionTitle", "Lkotlin/Function0;", "Lcom/avito/android/util/ActionHandler;", "error", "showSnackBar", "(Ljava/lang/String;IILjava/lang/String;Lkotlin/jvm/functions/Function0;Z)V", "isAuthorized", "onShare", "(Lcom/avito/android/social/SharingManager;Z)V", "showSellerCalendar", "followDeepLink", "Lcom/avito/android/social/SocialTypeToStringMapper;", "socialTypeToStringMapper", "Lcom/avito/android/social/SocialTypeToStringMapper;", "getSocialTypeToStringMapper", "()Lcom/avito/android/social/SocialTypeToStringMapper;", "setSocialTypeToStringMapper", "(Lcom/avito/android/social/SocialTypeToStringMapper;)V", "Lcom/avito/android/user_advert/advert/MyAdvertDetailsView;", "k", "Lcom/avito/android/user_advert/advert/MyAdvertDetailsView;", "myAdvertDetailsView", "p", "Lcom/avito/android/user_advert/advert/DetailsId;", "detailsId", "r", "Ljava/lang/String;", "errorMessage", "Lcom/avito/android/user_advert/advert/MyAdvertDetailsPresenter;", "presenter", "Lcom/avito/android/user_advert/advert/MyAdvertDetailsPresenter;", "getPresenter", "()Lcom/avito/android/user_advert/advert/MyAdvertDetailsPresenter;", "setPresenter", "(Lcom/avito/android/user_advert/advert/MyAdvertDetailsPresenter;)V", "Lcom/avito/android/user_advert/contact/MyAdvertContactsPresenter;", "contactsPresenter", "Lcom/avito/android/user_advert/contact/MyAdvertContactsPresenter;", "getContactsPresenter", "()Lcom/avito/android/user_advert/contact/MyAdvertContactsPresenter;", "setContactsPresenter", "(Lcom/avito/android/user_advert/contact/MyAdvertContactsPresenter;)V", "Lcom/avito/android/advert_core/car_market_price/badge/AdvertDetailsImvBadgePresenter;", "imvBadgePresenter", "Lcom/avito/android/advert_core/car_market_price/badge/AdvertDetailsImvBadgePresenter;", "getImvBadgePresenter", "()Lcom/avito/android/advert_core/car_market_price/badge/AdvertDetailsImvBadgePresenter;", "setImvBadgePresenter", "(Lcom/avito/android/advert_core/car_market_price/badge/AdvertDetailsImvBadgePresenter;)V", "Landroid/os/Handler;", "t", "Landroid/os/Handler;", "handler", "Lcom/avito/android/util/ImplicitIntentFactory;", "implicitIntentFactory", "Lcom/avito/android/util/ImplicitIntentFactory;", "getImplicitIntentFactory", "()Lcom/avito/android/util/ImplicitIntentFactory;", "setImplicitIntentFactory", "(Lcom/avito/android/util/ImplicitIntentFactory;)V", "Lcom/avito/android/advert_core/analytics/sharing/AdvertSharingEventTracker;", "eventTracker", "Lcom/avito/android/advert_core/analytics/sharing/AdvertSharingEventTracker;", "getEventTracker", "()Lcom/avito/android/advert_core/analytics/sharing/AdvertSharingEventTracker;", "setEventTracker", "(Lcom/avito/android/advert_core/analytics/sharing/AdvertSharingEventTracker;)V", "Lcom/avito/android/util/DialogRouter;", "dialogRouter", "Lcom/avito/android/util/DialogRouter;", "getDialogRouter", "()Lcom/avito/android/util/DialogRouter;", "setDialogRouter", "(Lcom/avito/android/util/DialogRouter;)V", "Landroid/view/ViewGroup;", "s", "Landroid/view/ViewGroup;", "container", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "deepLinkIntentFactory", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "getDeepLinkIntentFactory", "()Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "setDeepLinkIntentFactory", "(Lcom/avito/android/deep_linking/DeepLinkIntentFactory;)V", "Lcom/avito/android/deep_linking/DeepLinkFactory;", "deepLinkFactory", "Lcom/avito/android/deep_linking/DeepLinkFactory;", "getDeepLinkFactory", "()Lcom/avito/android/deep_linking/DeepLinkFactory;", "setDeepLinkFactory", "(Lcom/avito/android/deep_linking/DeepLinkFactory;)V", "o", "Z", "statusUpdated", VKApiConst.Q, "restoreAdvert", "Lcom/avito/android/advert_core/analytics/delivery/DeliveryEventTracker;", "deliveryEventTracker", "Lcom/avito/android/advert_core/analytics/delivery/DeliveryEventTracker;", "getDeliveryEventTracker", "()Lcom/avito/android/advert_core/analytics/delivery/DeliveryEventTracker;", "setDeliveryEventTracker", "(Lcom/avito/android/advert_core/analytics/delivery/DeliveryEventTracker;)V", "Lcom/avito/android/user_advert/tracker/MyAdvertDetailsTracker;", "tracker", "Lcom/avito/android/user_advert/tracker/MyAdvertDetailsTracker;", "getTracker", "()Lcom/avito/android/user_advert/tracker/MyAdvertDetailsTracker;", "setTracker", "(Lcom/avito/android/user_advert/tracker/MyAdvertDetailsTracker;)V", "Lcom/avito/android/user_advert/advert/feature_teasers/MyAdvertDetailsFeatureTeaserViewFactory;", "featureTeasersViewFactory", "Lcom/avito/android/user_advert/advert/feature_teasers/MyAdvertDetailsFeatureTeaserViewFactory;", "getFeatureTeasersViewFactory", "()Lcom/avito/android/user_advert/advert/feature_teasers/MyAdvertDetailsFeatureTeaserViewFactory;", "setFeatureTeasersViewFactory", "(Lcom/avito/android/user_advert/advert/feature_teasers/MyAdvertDetailsFeatureTeaserViewFactory;)V", "Lcom/avito/android/util/text/AttributedTextFormatter;", "attributedTextFormatter", "Lcom/avito/android/util/text/AttributedTextFormatter;", "getAttributedTextFormatter", "()Lcom/avito/android/util/text/AttributedTextFormatter;", "setAttributedTextFormatter", "(Lcom/avito/android/util/text/AttributedTextFormatter;)V", "Lcom/avito/android/permissions/PermissionHelper;", "l", "Lcom/avito/android/permissions/PermissionHelper;", "permissionHelper", "Lcom/avito/android/advert_core/car_market_price/price_chart/CarMarketPriceChartPresenter;", "imvChartPresenter", "Lcom/avito/android/advert_core/car_market_price/price_chart/CarMarketPriceChartPresenter;", "getImvChartPresenter", "()Lcom/avito/android/advert_core/car_market_price/price_chart/CarMarketPriceChartPresenter;", "setImvChartPresenter", "(Lcom/avito/android/advert_core/car_market_price/price_chart/CarMarketPriceChartPresenter;)V", "Lcom/avito/android/advert_core/social/SocialPresenter;", "socialPresenter", "Lcom/avito/android/advert_core/social/SocialPresenter;", "getSocialPresenter", "()Lcom/avito/android/advert_core/social/SocialPresenter;", "setSocialPresenter", "(Lcom/avito/android/advert_core/social/SocialPresenter;)V", "Lcom/avito/android/user_advert/contact/MyAdvertContactsView;", "n", "Lcom/avito/android/user_advert/contact/MyAdvertContactsView;", "contactsView", "", AuthSource.OPEN_CHANNEL_LIST, "Ljava/lang/Object;", "component", "Lcom/avito/android/user_advert/advert/MyAdvertDetailsInteractor;", "interactor", "Lcom/avito/android/user_advert/advert/MyAdvertDetailsInteractor;", "getInteractor", "()Lcom/avito/android/user_advert/advert/MyAdvertDetailsInteractor;", "setInteractor", "(Lcom/avito/android/user_advert/advert/MyAdvertDetailsInteractor;)V", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/analytics/Analytics;", "getAnalytics", "()Lcom/avito/android/analytics/Analytics;", "setAnalytics", "(Lcom/avito/android/analytics/Analytics;)V", "Lcom/avito/android/ActivityIntentFactory;", "activityIntentFactory", "Lcom/avito/android/ActivityIntentFactory;", "getActivityIntentFactory", "()Lcom/avito/android/ActivityIntentFactory;", "setActivityIntentFactory", "(Lcom/avito/android/ActivityIntentFactory;)V", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/Features;", "getFeatures", "()Lcom/avito/android/Features;", "setFeatures", "(Lcom/avito/android/Features;)V", "<init>", "Companion", "user-advert_release"}, k = 1, mv = {1, 4, 2})
public final class MyAdvertDetailsActivity extends BaseActivity implements SocialPresenter.Router, MyAdvertRouter, AdvertDeliveryBlockView.Listener, AdvertStrBlockView.Listener, AdvertStrBlockViewModel.DeepLinkRouter, SoaWithPriceResultHandler, AdvertBadgeBarPresenter.Router, CarMarketPriceChartPresenter.Router {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final String EDIT_ADVERT_ID = "edited_advert_id";
    @Inject
    public ActivityIntentFactory activityIntentFactory;
    @Inject
    public Analytics analytics;
    @Inject
    public AttributedTextFormatter attributedTextFormatter;
    @Inject
    public MyAdvertContactsPresenter contactsPresenter;
    @Inject
    public DeepLinkFactory deepLinkFactory;
    @Inject
    public DeepLinkIntentFactory deepLinkIntentFactory;
    @Inject
    public DeliveryEventTracker deliveryEventTracker;
    @Inject
    public DialogRouter dialogRouter;
    @Inject
    public AdvertSharingEventTracker eventTracker;
    @Inject
    public MyAdvertDetailsFeatureTeaserViewFactory featureTeasersViewFactory;
    @Inject
    public Features features;
    @Inject
    public ImplicitIntentFactory implicitIntentFactory;
    @Inject
    public AdvertDetailsImvBadgePresenter imvBadgePresenter;
    @Inject
    public CarMarketPriceChartPresenter imvChartPresenter;
    @Inject
    public MyAdvertDetailsInteractor interactor;
    public MyAdvertDetailsView k;
    public PermissionHelper l;
    public Object m;
    public MyAdvertContactsView n;
    public boolean o;
    public DetailsId p;
    @Inject
    public MyAdvertDetailsPresenter presenter;
    public boolean q;
    public String r;
    public ViewGroup s;
    @Inject
    public SocialPresenter socialPresenter;
    @Inject
    public SocialTypeToStringMapper socialTypeToStringMapper;
    public final Handler t = new Handler();
    @Inject
    public MyAdvertDetailsTracker tracker;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/avito/android/user_advert/advert/MyAdvertDetailsActivity$Companion;", "", "", "EDIT_ADVERT_ID", "Ljava/lang/String;", "<init>", "()V", "user-advert_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    public static final class a implements Runnable {
        public final /* synthetic */ MyAdvertDetailsActivity a;
        public final /* synthetic */ Intent b;

        public a(MyAdvertDetailsActivity myAdvertDetailsActivity, Intent intent) {
            this.a = myAdvertDetailsActivity;
            this.b = intent;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.sendBroadcast(this.b);
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ MyAdvertDetailsActivity a;
        public final /* synthetic */ Intent b;

        public b(MyAdvertDetailsActivity myAdvertDetailsActivity, Intent intent) {
            this.a = myAdvertDetailsActivity;
            this.b = intent;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.startActivityForResult(this.b, 130);
            Intent intent = this.a.getIntent();
            Intrinsics.checkNotNullExpressionValue(intent, "intent");
            IntentsKt.setNestedIntent(intent, null);
        }
    }

    public static final class c extends Lambda implements Function1<String, Unit> {
        public final /* synthetic */ MyAdvertDetailsActivity a;
        public final /* synthetic */ Ref.ObjectRef b;
        public final /* synthetic */ Ref.BooleanRef c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(MyAdvertDetailsActivity myAdvertDetailsActivity, Ref.ObjectRef objectRef, Ref.BooleanRef booleanRef) {
            super(1);
            this.a = myAdvertDetailsActivity;
            this.b = objectRef;
            this.c = booleanRef;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(String str) {
            String str2 = str;
            Intrinsics.checkNotNullParameter(str2, "it");
            if (this.b.element != null) {
                this.a.getEventTracker().trackSocialItemSharing(str2, this.a.getSocialTypeToStringMapper().mapToString(this.b.element), this.c.element, null);
            }
            return Unit.INSTANCE;
        }
    }

    public static final class d extends Lambda implements Function1<String, Unit> {
        public final /* synthetic */ MyAdvertDetailsActivity a;
        public final /* synthetic */ View b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(MyAdvertDetailsActivity myAdvertDetailsActivity, View view) {
            super(1);
            this.a = myAdvertDetailsActivity;
            this.b = view;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(String str) {
            Intrinsics.checkNotNullParameter(str, "it");
            Object access$getComponent$p = MyAdvertDetailsActivity.access$getComponent$p(this.a);
            if (!(access$getComponent$p instanceof MyAdvertDetailsComponent)) {
                access$getComponent$p = null;
            }
            MyAdvertDetailsComponent myAdvertDetailsComponent = (MyAdvertDetailsComponent) access$getComponent$p;
            if (myAdvertDetailsComponent != null) {
                if (this.a.getFeatures().getSellerAdvertCourierAndSafeDealSwitchers().invoke().booleanValue()) {
                    MyAdvertDetailsActivity.access$initSafeDealServicesBlock(this.a, this.b, myAdvertDetailsComponent.getSafeDealServicesViewModel());
                } else {
                    MyAdvertDetailsActivity.access$initDeliveryBlock(this.a, this.b, myAdvertDetailsComponent.getDeliveryBlockViewModel());
                }
                MyAdvertDetailsActivity.access$initShortTermRentBlock(this.a, this.b, myAdvertDetailsComponent.getStrBlockViewModel());
                MyAdvertDetailsActivity.access$initAutoPublishBlock(this.a, this.b, myAdvertDetailsComponent.getAutoPublishBlockViewModel());
                MyAdvertDetailsActivity.access$initAutoBookingBlock(this.a, this.b, myAdvertDetailsComponent.getAutoBookingBlockViewModel());
            }
            return Unit.INSTANCE;
        }
    }

    public static final class e extends Lambda implements Function1<String, Unit> {
        public final /* synthetic */ MyAdvertDetailsActivity a;
        public final /* synthetic */ SharingManager b;
        public final /* synthetic */ boolean c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(MyAdvertDetailsActivity myAdvertDetailsActivity, SharingManager sharingManager, boolean z) {
            super(1);
            this.a = myAdvertDetailsActivity;
            this.b = sharingManager;
            this.c = z;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(String str) {
            String str2 = str;
            Intrinsics.checkNotNullParameter(str2, "it");
            this.a.getEventTracker().trackSocialItemSharing(str2, this.a.getSocialTypeToStringMapper().mapToString(this.b.getType()), this.c, null);
            return Unit.INSTANCE;
        }
    }

    public static final class f extends Lambda implements Function1<String, Unit> {
        public final /* synthetic */ MyAdvertDetailsActivity a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(MyAdvertDetailsActivity myAdvertDetailsActivity) {
            super(1);
            this.a = myAdvertDetailsActivity;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(String str) {
            String str2 = str;
            Intrinsics.checkNotNullParameter(str2, "it");
            this.a.getAnalytics().track(new StatButtonClickEvent(str2));
            return Unit.INSTANCE;
        }
    }

    public static final class g extends Lambda implements Function1<String, Unit> {
        public final /* synthetic */ MyAdvertDetailsActivity a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(MyAdvertDetailsActivity myAdvertDetailsActivity) {
            super(1);
            this.a = myAdvertDetailsActivity;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(String str) {
            String str2 = str;
            Intrinsics.checkNotNullParameter(str2, "it");
            this.a.getEventTracker().trackItemSharing(str2, null);
            return Unit.INSTANCE;
        }
    }

    public static final class h extends Lambda implements Function1<T, K> {
        public final /* synthetic */ MyAdvertDetailsActivity a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ boolean d;
        public final /* synthetic */ boolean e;
        public final /* synthetic */ String f;
        public final /* synthetic */ Bundle g;
        public final /* synthetic */ Ref.ObjectRef h;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public h(MyAdvertDetailsActivity myAdvertDetailsActivity, boolean z, boolean z2, boolean z3, boolean z4, String str, Bundle bundle, Ref.ObjectRef objectRef) {
            super(1);
            this.a = myAdvertDetailsActivity;
            this.b = z;
            this.c = z2;
            this.d = z3;
            this.e = z4;
            this.f = str;
            this.g = bundle;
            this.h = objectRef;
        }

        @NotNull
        /* renamed from: a */
        public final <K, T extends DetailsComponentBuilder<K>> K invoke(@NotNull T t) {
            Intrinsics.checkNotNullParameter(t, "builder");
            DetailsComponentBuilder withLifecycleOwner = t.dependentOn((MyAdvertDetailsDependencies) ComponentDependenciesKt.getDependencies(MyAdvertDetailsDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder((Activity) this.a))).withActivity(this.a).withFragmentActivity(this.a).withLifecycleOwner(this.a);
            Resources resources = this.a.getResources();
            Intrinsics.checkNotNullExpressionValue(resources, "resources");
            return (K) withLifecycleOwner.withResources(resources).withDetailsId(MyAdvertDetailsActivity.access$getDetailsId$p(this.a)).withIsNewAdvert(this.b).withShouldOpenActivateDialog(this.c).withShouldOpenUserAdverts(this.d).withShouldFinishAfterActivation(this.e).withRestoreAdvert(this.a.q).withErrorMessage(this.a.r).withStatusMessage(this.f).withInteractorState(this.g).withPresenterState(this.h.element).mo95build();
        }
    }

    public static final class i extends Lambda implements Function1<String, Unit> {
        public final /* synthetic */ MyAdvertDetailsActivity a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public i(MyAdvertDetailsActivity myAdvertDetailsActivity) {
            super(1);
            this.a = myAdvertDetailsActivity;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(String str) {
            String str2 = str;
            Intrinsics.checkNotNullParameter(str2, "it");
            this.a.getDeliveryEventTracker().trackDeliveryTurnOffToastEvent(str2);
            return Unit.INSTANCE;
        }
    }

    public static final /* synthetic */ Object access$getComponent$p(MyAdvertDetailsActivity myAdvertDetailsActivity) {
        Object obj = myAdvertDetailsActivity.m;
        if (obj == null) {
            Intrinsics.throwUninitializedPropertyAccessException("component");
        }
        return obj;
    }

    public static final /* synthetic */ DetailsId access$getDetailsId$p(MyAdvertDetailsActivity myAdvertDetailsActivity) {
        DetailsId detailsId = myAdvertDetailsActivity.p;
        if (detailsId == null) {
            Intrinsics.throwUninitializedPropertyAccessException("detailsId");
        }
        return detailsId;
    }

    public static final /* synthetic */ MyAdvertDetailsView access$getMyAdvertDetailsView$p(MyAdvertDetailsActivity myAdvertDetailsActivity) {
        MyAdvertDetailsView myAdvertDetailsView = myAdvertDetailsActivity.k;
        if (myAdvertDetailsView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("myAdvertDetailsView");
        }
        return myAdvertDetailsView;
    }

    public static final void access$initAutoBookingBlock(MyAdvertDetailsActivity myAdvertDetailsActivity, View view, AutoBookingBlockViewModel autoBookingBlockViewModel) {
        AttributedTextFormatter attributedTextFormatter2 = myAdvertDetailsActivity.attributedTextFormatter;
        if (attributedTextFormatter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("attributedTextFormatter");
        }
        new AutoBookingSwitcherBlockView(view, autoBookingBlockViewModel, myAdvertDetailsActivity, attributedTextFormatter2);
    }

    public static final void access$initAutoPublishBlock(MyAdvertDetailsActivity myAdvertDetailsActivity, View view, AutoPublishBlockViewModel autoPublishBlockViewModel) {
        AttributedTextFormatter attributedTextFormatter2 = myAdvertDetailsActivity.attributedTextFormatter;
        if (attributedTextFormatter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("attributedTextFormatter");
        }
        new AutoPublishSwitcherBlockView(view, autoPublishBlockViewModel, myAdvertDetailsActivity, attributedTextFormatter2);
    }

    public static final void access$initDeliveryBlock(MyAdvertDetailsActivity myAdvertDetailsActivity, View view, AdvertDeliveryBlockViewModel advertDeliveryBlockViewModel) {
        Objects.requireNonNull(myAdvertDetailsActivity);
        View findViewById = view.findViewById(R.id.advert_delivery_block_root);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(co…vert_delivery_block_root)");
        new AdvertDeliveryBlockView(findViewById, advertDeliveryBlockViewModel, myAdvertDetailsActivity, myAdvertDetailsActivity, false);
    }

    public static final void access$initSafeDealServicesBlock(MyAdvertDetailsActivity myAdvertDetailsActivity, View view, MyAdvertSafeDealServicesViewModel myAdvertSafeDealServicesViewModel) {
        Objects.requireNonNull(myAdvertDetailsActivity);
        MyAdvertDetailsActivity$initSafeDealServicesBlock$router$1 myAdvertDetailsActivity$initSafeDealServicesBlock$router$1 = new MyAdvertSafeDealServicesView.Router() { // from class: com.avito.android.user_advert.advert.MyAdvertDetailsActivity$initSafeDealServicesBlock$router$1
            @Override // com.avito.android.advert_core.safedeal.MyAdvertSafeDealServicesView.Router
            public void followServicesDeepLink(@NotNull DeepLink deepLink) {
                Intrinsics.checkNotNullParameter(deepLink, "deepLink");
                Intent intent = MyAdvertDetailsActivity.this.getDeepLinkIntentFactory().getIntent(deepLink);
                if (intent == null) {
                    SnackbarExtensionsKt.showSnackbar$default(MyAdvertDetailsActivity.this.getContainerView(), (String) null, com.avito.android.ui_components.R.string.no_match_deep_link_try_to_update_the_app, (String) null, 0, (Function0) null, 0, (SnackbarPosition) null, (SnackbarType) null, 253, (Object) null);
                } else {
                    MyAdvertDetailsActivity.this.startActivity(intent);
                }
            }
        };
        View findViewById = view.findViewById(com.avito.android.user_advert.R.id.safedeal_services);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup = (ViewGroup) findViewById;
        DeepLinkFactory deepLinkFactory2 = myAdvertDetailsActivity.deepLinkFactory;
        if (deepLinkFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deepLinkFactory");
        }
        new MyAdvertSafeDealServicesView(viewGroup, myAdvertSafeDealServicesViewModel, deepLinkFactory2, myAdvertDetailsActivity$initSafeDealServicesBlock$router$1, myAdvertDetailsActivity);
    }

    public static final void access$initShortTermRentBlock(MyAdvertDetailsActivity myAdvertDetailsActivity, View view, AdvertStrBlockViewModel advertStrBlockViewModel) {
        Objects.requireNonNull(myAdvertDetailsActivity);
        advertStrBlockViewModel.getShowCalendarChanges().observe(myAdvertDetailsActivity, new l3(0, myAdvertDetailsActivity));
        advertStrBlockViewModel.getOpenDeepLinkChanges().observe(myAdvertDetailsActivity, new l3(1, myAdvertDetailsActivity));
        View findViewById = view.findViewById(R.id.advert_str_block_root);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(co…id.advert_str_block_root)");
        Features features2 = myAdvertDetailsActivity.features;
        if (features2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("features");
        }
        new AdvertStrBlockViewImpl(findViewById, advertStrBlockViewModel, myAdvertDetailsActivity, myAdvertDetailsActivity, advertStrBlockViewModel, features2);
    }

    public final DetailsId a(Intent intent) {
        DetailsId detailsId;
        String stringExtra = intent.getStringExtra("itemId");
        if (stringExtra != null) {
            detailsId = new AdvertId(stringExtra);
        } else {
            String stringExtra2 = intent.getStringExtra("key_draft_id");
            detailsId = stringExtra2 != null ? new DraftId(stringExtra2) : null;
        }
        if (detailsId != null) {
            return detailsId;
        }
        throw new IllegalArgumentException("no itemId or draftId as require param".toString());
    }

    public final void b(Function1<? super String, Unit> function1) {
        DetailsId detailsId = this.p;
        if (detailsId == null) {
            Intrinsics.throwUninitializedPropertyAccessException("detailsId");
        }
        if (detailsId instanceof AdvertId) {
            function1.invoke(((AdvertId) detailsId).getAdvertId());
        }
    }

    @Override // com.avito.android.user_advert.advert.MyAdvertRouter
    public void finish(int i2, boolean z, @Nullable String str, @Nullable AdvertActionTransferData advertActionTransferData) {
        Logs.debug$default("MyAdvertDetailsActivity", a2.b.a.a.a.M2("setActivityResult: resultCode=", i2), null, 4, null);
        Intent upIntent = getUpIntent();
        if (upIntent == null) {
            Intent intent = new Intent();
            intent.putExtra(UserAdvertConstants.KEY_ADVERT_ACTION, advertActionTransferData);
            intent.putExtra(UserAdvertConstants.KEY_SOA_UPDATE_MESSAGE, str);
            intent.putExtra(UserAdvertConstants.KEY_SHOULD_SHOW_APPRATER, z);
            setResult(i2, intent);
        } else {
            startActivity(upIntent);
            Intent intent2 = new Intent();
            intent2.putExtra(UserAdvertConstants.KEY_ADVERT_ACTION, advertActionTransferData);
            intent2.putExtra(UserAdvertConstants.KEY_SOA_UPDATE_MESSAGE, str);
            intent2.putExtra(UserAdvertConstants.KEY_SHOULD_SHOW_APPRATER, z);
            intent2.setAction(UserAdvertConstantsKt.USER_ADVERT_STATUS_CHANGE_INTENT);
            this.t.postDelayed(new a(this, intent2), 500);
        }
        finish();
    }

    @Override // com.avito.android.advert_core.advert_badge_bar.AdvertBadgeBarPresenter.Router, com.avito.android.advert.item.cre_geo_report.AdvertDetailsGeoReportTeaserPresenter.Router, com.avito.android.advert_core.car_market_price.price_chart.CarMarketPriceChartPresenter.Router
    public void followDeepLink(@NotNull DeepLink deepLink) {
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        openDeepLink(deepLink);
    }

    @Override // com.avito.android.advert_core.delivery.AdvertDeliveryBlockView.Listener
    public void followUri(@NotNull Uri uri) {
        Intrinsics.checkNotNullParameter(uri, ShareConstants.MEDIA_URI);
        ImplicitIntentFactory implicitIntentFactory2 = this.implicitIntentFactory;
        if (implicitIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("implicitIntentFactory");
        }
        startActivity(implicitIntentFactory2.uriIntent(uri));
    }

    @NotNull
    public final ActivityIntentFactory getActivityIntentFactory() {
        ActivityIntentFactory activityIntentFactory2 = this.activityIntentFactory;
        if (activityIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activityIntentFactory");
        }
        return activityIntentFactory2;
    }

    @NotNull
    public final Analytics getAnalytics() {
        Analytics analytics2 = this.analytics;
        if (analytics2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analytics");
        }
        return analytics2;
    }

    @NotNull
    public final AttributedTextFormatter getAttributedTextFormatter() {
        AttributedTextFormatter attributedTextFormatter2 = this.attributedTextFormatter;
        if (attributedTextFormatter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("attributedTextFormatter");
        }
        return attributedTextFormatter2;
    }

    @NotNull
    public final MyAdvertContactsPresenter getContactsPresenter() {
        MyAdvertContactsPresenter myAdvertContactsPresenter = this.contactsPresenter;
        if (myAdvertContactsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contactsPresenter");
        }
        return myAdvertContactsPresenter;
    }

    @Override // com.avito.android.ui.activity.BaseActivity
    public int getContentLayoutId() {
        return com.avito.android.user_advert.R.layout.my_adverts_details;
    }

    @NotNull
    public final DeepLinkFactory getDeepLinkFactory() {
        DeepLinkFactory deepLinkFactory2 = this.deepLinkFactory;
        if (deepLinkFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deepLinkFactory");
        }
        return deepLinkFactory2;
    }

    @NotNull
    public final DeepLinkIntentFactory getDeepLinkIntentFactory() {
        DeepLinkIntentFactory deepLinkIntentFactory2 = this.deepLinkIntentFactory;
        if (deepLinkIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deepLinkIntentFactory");
        }
        return deepLinkIntentFactory2;
    }

    @NotNull
    public final DeliveryEventTracker getDeliveryEventTracker() {
        DeliveryEventTracker deliveryEventTracker2 = this.deliveryEventTracker;
        if (deliveryEventTracker2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deliveryEventTracker");
        }
        return deliveryEventTracker2;
    }

    @NotNull
    public final DialogRouter getDialogRouter() {
        DialogRouter dialogRouter2 = this.dialogRouter;
        if (dialogRouter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dialogRouter");
        }
        return dialogRouter2;
    }

    @NotNull
    public final AdvertSharingEventTracker getEventTracker() {
        AdvertSharingEventTracker advertSharingEventTracker = this.eventTracker;
        if (advertSharingEventTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("eventTracker");
        }
        return advertSharingEventTracker;
    }

    @NotNull
    public final MyAdvertDetailsFeatureTeaserViewFactory getFeatureTeasersViewFactory() {
        MyAdvertDetailsFeatureTeaserViewFactory myAdvertDetailsFeatureTeaserViewFactory = this.featureTeasersViewFactory;
        if (myAdvertDetailsFeatureTeaserViewFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("featureTeasersViewFactory");
        }
        return myAdvertDetailsFeatureTeaserViewFactory;
    }

    @NotNull
    public final Features getFeatures() {
        Features features2 = this.features;
        if (features2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("features");
        }
        return features2;
    }

    @NotNull
    public final ImplicitIntentFactory getImplicitIntentFactory() {
        ImplicitIntentFactory implicitIntentFactory2 = this.implicitIntentFactory;
        if (implicitIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("implicitIntentFactory");
        }
        return implicitIntentFactory2;
    }

    @NotNull
    public final AdvertDetailsImvBadgePresenter getImvBadgePresenter() {
        AdvertDetailsImvBadgePresenter advertDetailsImvBadgePresenter = this.imvBadgePresenter;
        if (advertDetailsImvBadgePresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imvBadgePresenter");
        }
        return advertDetailsImvBadgePresenter;
    }

    @NotNull
    public final CarMarketPriceChartPresenter getImvChartPresenter() {
        CarMarketPriceChartPresenter carMarketPriceChartPresenter = this.imvChartPresenter;
        if (carMarketPriceChartPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imvChartPresenter");
        }
        return carMarketPriceChartPresenter;
    }

    @NotNull
    public final MyAdvertDetailsInteractor getInteractor() {
        MyAdvertDetailsInteractor myAdvertDetailsInteractor = this.interactor;
        if (myAdvertDetailsInteractor == null) {
            Intrinsics.throwUninitializedPropertyAccessException("interactor");
        }
        return myAdvertDetailsInteractor;
    }

    @NotNull
    public final MyAdvertDetailsPresenter getPresenter() {
        MyAdvertDetailsPresenter myAdvertDetailsPresenter = this.presenter;
        if (myAdvertDetailsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        return myAdvertDetailsPresenter;
    }

    @NotNull
    public final SocialPresenter getSocialPresenter() {
        SocialPresenter socialPresenter2 = this.socialPresenter;
        if (socialPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("socialPresenter");
        }
        return socialPresenter2;
    }

    @NotNull
    public final SocialTypeToStringMapper getSocialTypeToStringMapper() {
        SocialTypeToStringMapper socialTypeToStringMapper2 = this.socialTypeToStringMapper;
        if (socialTypeToStringMapper2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("socialTypeToStringMapper");
        }
        return socialTypeToStringMapper2;
    }

    @NotNull
    public final MyAdvertDetailsTracker getTracker() {
        MyAdvertDetailsTracker myAdvertDetailsTracker = this.tracker;
        if (myAdvertDetailsTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tracker");
        }
        return myAdvertDetailsTracker;
    }

    @Override // com.avito.android.user_advert.soa_with_price.SoaWithPriceResultHandler
    public void handleSoaWithPriceResult(@NotNull CloseReason closeReason, @Nullable String str) {
        Intrinsics.checkNotNullParameter(closeReason, "reason");
        MyAdvertDetailsPresenter myAdvertDetailsPresenter = this.presenter;
        if (myAdvertDetailsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        myAdvertDetailsPresenter.onCloseReasonChosen(closeReason, str);
    }

    @Override // com.avito.android.user_advert.advert.MyAdvertRouter
    public void launchNestedIntent(boolean z) {
        Intent intent = getIntent();
        Intrinsics.checkNotNullExpressionValue(intent, "intent");
        Intent nestedIntent = IntentsKt.getNestedIntent(intent);
        if (nestedIntent != null) {
            new Handler(Looper.getMainLooper()).postDelayed(new b(this, nestedIntent), 700);
            return;
        }
        MyAdvertDetailsPresenter myAdvertDetailsPresenter = this.presenter;
        if (myAdvertDetailsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        MyAdvertDetailsViewPresenter.DefaultImpls.showAdditionalDialogs$default(myAdvertDetailsPresenter, null, z, 1, null);
    }

    @Override // com.avito.android.advert_core.social.SocialPresenter.Router
    public void login(@NotNull SignInSocialManager signInSocialManager) {
        Intrinsics.checkNotNullParameter(signInSocialManager, "socialManager");
        ActivityIntentFactory activityIntentFactory2 = this.activityIntentFactory;
        if (activityIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activityIntentFactory");
        }
        SocialTypeToStringMapper socialTypeToStringMapper2 = this.socialTypeToStringMapper;
        if (socialTypeToStringMapper2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("socialTypeToStringMapper");
        }
        startActivityForResult(activityIntentFactory2.createSocialLoginIntent(socialTypeToStringMapper2.mapToString(signInSocialManager.getType())), 5);
    }

    /* JADX WARNING: Removed duplicated region for block: B:117:0x017c  */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x0186  */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onActivityResult(int r8, int r9, @org.jetbrains.annotations.Nullable android.content.Intent r10) {
        /*
        // Method dump skipped, instructions count: 422
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.user_advert.advert.MyAdvertDetailsActivity.onActivityResult(int, int, android.content.Intent):void");
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        LastClick.Updater.update();
        MyAdvertDetailsPresenter myAdvertDetailsPresenter = this.presenter;
        if (myAdvertDetailsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        myAdvertDetailsPresenter.onBackPressed();
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        AutoBookingBlockViewModel autoBookingBlockViewModel;
        AutoPublishBlockViewModel autoPublishBlockViewModel;
        Intent intent = getIntent();
        Intrinsics.checkNotNullExpressionValue(intent, "intent");
        this.p = a(intent);
        setUpIntent((Intent) getIntent().getParcelableExtra(Constants.UP_INTENT));
        this.q = getIntent().getBooleanExtra("key_restore_advert", false);
        if (bundle == null) {
            this.r = getIntent().getStringExtra("error_message");
        } else {
            this.o = bundle.getBoolean("advert_status_updated", false);
        }
        super.onCreate(bundle);
        MyAdvertDetailsTracker myAdvertDetailsTracker = this.tracker;
        if (myAdvertDetailsTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tracker");
        }
        myAdvertDetailsTracker.startInit();
        this.s = (ViewGroup) findViewById(com.avito.android.user_advert.R.id.my_adverts_details_screen_root);
        View findViewById = findViewById(com.avito.android.user_advert.R.id.advert_details_content);
        Intrinsics.checkNotNullExpressionValue(findViewById, "socialStub");
        SocialViewImpl socialViewImpl = new SocialViewImpl(findViewById, false);
        SocialPresenter socialPresenter2 = this.socialPresenter;
        if (socialPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("socialPresenter");
        }
        socialPresenter2.attachView(socialViewImpl);
        ViewStub viewStub = (ViewStub) findViewById(com.avito.android.user_advert.R.id.contacts_stub);
        Intrinsics.checkNotNullExpressionValue(viewStub, "contactsStub");
        this.n = new MyAdvertContactsViewImpl(viewStub);
        MyAdvertContactsPresenter myAdvertContactsPresenter = this.contactsPresenter;
        if (myAdvertContactsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contactsPresenter");
        }
        MyAdvertContactsView myAdvertContactsView = this.n;
        if (myAdvertContactsView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contactsView");
        }
        myAdvertContactsPresenter.attachView(myAdvertContactsView);
        SocialPresenter socialPresenter3 = this.socialPresenter;
        if (socialPresenter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("socialPresenter");
        }
        socialPresenter3.setInstantShareListener(new SocialShareListener(this) { // from class: com.avito.android.user_advert.advert.MyAdvertDetailsActivity$onCreate$1
            public final /* synthetic */ MyAdvertDetailsActivity a;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.a = r1;
            }

            @Override // com.avito.android.advert_core.social.SocialShareListener
            public void onSocialShare(@NotNull SharingManager sharingManager, boolean z) {
                Intrinsics.checkNotNullParameter(sharingManager, "socialManager");
                this.a.onShare(sharingManager, z);
            }
        });
        this.l = new ActivityPermissionHelper(this);
        View containerView = getContainerView();
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        MyAdvertDetailsPresenter myAdvertDetailsPresenter = this.presenter;
        if (myAdvertDetailsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        DialogRouter dialogRouter2 = this.dialogRouter;
        if (dialogRouter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dialogRouter");
        }
        AttributedTextFormatter attributedTextFormatter2 = this.attributedTextFormatter;
        if (attributedTextFormatter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("attributedTextFormatter");
        }
        ImplicitIntentFactory implicitIntentFactory2 = this.implicitIntentFactory;
        if (implicitIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("implicitIntentFactory");
        }
        Analytics analytics2 = this.analytics;
        if (analytics2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analytics");
        }
        MyAdvertDetailsFeatureTeaserViewFactory myAdvertDetailsFeatureTeaserViewFactory = this.featureTeasersViewFactory;
        if (myAdvertDetailsFeatureTeaserViewFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("featureTeasersViewFactory");
        }
        ActivityIntentFactory activityIntentFactory2 = this.activityIntentFactory;
        if (activityIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activityIntentFactory");
        }
        PermissionHelper permissionHelper = this.l;
        if (permissionHelper == null) {
            Intrinsics.throwUninitializedPropertyAccessException("permissionHelper");
        }
        this.k = new MyAdvertDetailsViewImpl(containerView, supportFragmentManager, myAdvertDetailsPresenter, dialogRouter2, attributedTextFormatter2, implicitIntentFactory2, analytics2, myAdvertDetailsFeatureTeaserViewFactory, activityIntentFactory2, permissionHelper);
        MyAdvertDetailsPresenter myAdvertDetailsPresenter2 = this.presenter;
        if (myAdvertDetailsPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        MyAdvertDetailsView myAdvertDetailsView = this.k;
        if (myAdvertDetailsView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("myAdvertDetailsView");
        }
        myAdvertDetailsPresenter2.attachView(myAdvertDetailsView);
        Object obj = this.m;
        if (obj == null) {
            Intrinsics.throwUninitializedPropertyAccessException("component");
        }
        MyAdvertDetailsComponent myAdvertDetailsComponent = null;
        if (!(obj instanceof MyAdvertDetailsComponent)) {
            obj = null;
        }
        MyAdvertDetailsComponent myAdvertDetailsComponent2 = (MyAdvertDetailsComponent) obj;
        if (!(myAdvertDetailsComponent2 == null || (autoPublishBlockViewModel = myAdvertDetailsComponent2.getAutoPublishBlockViewModel()) == null)) {
            MyAdvertDetailsPresenter myAdvertDetailsPresenter3 = this.presenter;
            if (myAdvertDetailsPresenter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("presenter");
            }
            autoPublishBlockViewModel.setUserAdvertSource(myAdvertDetailsPresenter3);
        }
        Object obj2 = this.m;
        if (obj2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("component");
        }
        if (obj2 instanceof MyAdvertDetailsComponent) {
            myAdvertDetailsComponent = obj2;
        }
        MyAdvertDetailsComponent myAdvertDetailsComponent3 = myAdvertDetailsComponent;
        if (!(myAdvertDetailsComponent3 == null || (autoBookingBlockViewModel = myAdvertDetailsComponent3.getAutoBookingBlockViewModel()) == null)) {
            MyAdvertDetailsPresenter myAdvertDetailsPresenter4 = this.presenter;
            if (myAdvertDetailsPresenter4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("presenter");
            }
            autoBookingBlockViewModel.setUserAdvertSource(myAdvertDetailsPresenter4);
        }
        MyAdvertDetailsPresenter myAdvertDetailsPresenter5 = this.presenter;
        if (myAdvertDetailsPresenter5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        myAdvertDetailsPresenter5.init(getIntent().getBooleanExtra(Constants.SHOW_APP_RATER, false));
        b(new d(this, containerView));
        MyAdvertDetailsTracker myAdvertDetailsTracker2 = this.tracker;
        if (myAdvertDetailsTracker2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tracker");
        }
        myAdvertDetailsTracker2.trackInit();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        AutoBookingBlockViewModel autoBookingBlockViewModel;
        AutoPublishBlockViewModel autoPublishBlockViewModel;
        Object obj = this.m;
        if (obj == null) {
            Intrinsics.throwUninitializedPropertyAccessException("component");
        }
        if (!(obj instanceof MyAdvertDetailsComponent)) {
            obj = null;
        }
        MyAdvertDetailsComponent myAdvertDetailsComponent = (MyAdvertDetailsComponent) obj;
        if (!(myAdvertDetailsComponent == null || (autoPublishBlockViewModel = myAdvertDetailsComponent.getAutoPublishBlockViewModel()) == null)) {
            autoPublishBlockViewModel.setUserAdvertSource(null);
        }
        Object obj2 = this.m;
        if (obj2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("component");
        }
        if (!(obj2 instanceof MyAdvertDetailsComponent)) {
            obj2 = null;
        }
        MyAdvertDetailsComponent myAdvertDetailsComponent2 = (MyAdvertDetailsComponent) obj2;
        if (!(myAdvertDetailsComponent2 == null || (autoBookingBlockViewModel = myAdvertDetailsComponent2.getAutoBookingBlockViewModel()) == null)) {
            autoBookingBlockViewModel.setUserAdvertSource(null);
        }
        SocialPresenter socialPresenter2 = this.socialPresenter;
        if (socialPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("socialPresenter");
        }
        socialPresenter2.detachView();
        SocialPresenter socialPresenter3 = this.socialPresenter;
        if (socialPresenter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("socialPresenter");
        }
        socialPresenter3.setInstantShareListener(null);
        MyAdvertContactsPresenter myAdvertContactsPresenter = this.contactsPresenter;
        if (myAdvertContactsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contactsPresenter");
        }
        myAdvertContactsPresenter.detachView();
        MyAdvertDetailsPresenter myAdvertDetailsPresenter = this.presenter;
        if (myAdvertDetailsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        myAdvertDetailsPresenter.detachView();
        super.onDestroy();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(@NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        super.onNewIntent(intent);
        setIntent(intent);
        this.p = a(intent);
        boolean booleanExtra = intent.getBooleanExtra("key_open_activate_dialog", false);
        boolean booleanExtra2 = intent.getBooleanExtra("key_is_new_advert", false);
        MyAdvertDetailsPresenter myAdvertDetailsPresenter = this.presenter;
        if (myAdvertDetailsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        DetailsId detailsId = this.p;
        if (detailsId == null) {
            Intrinsics.throwUninitializedPropertyAccessException("detailsId");
        }
        myAdvertDetailsPresenter.onNewIntent(detailsId, getIntent().getStringExtra("status_message"), booleanExtra, booleanExtra2);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i2, @NotNull String[] strArr, @NotNull int[] iArr) {
        PermissionState permissionState;
        Intrinsics.checkNotNullParameter(strArr, "permissions");
        Intrinsics.checkNotNullParameter(iArr, "grantResults");
        if (i2 == 10000) {
            PermissionHelper permissionHelper = this.l;
            if (permissionHelper == null) {
                Intrinsics.throwUninitializedPropertyAccessException("permissionHelper");
            }
            if (permissionHelper.checkPermission(strArr, iArr, "android.permission.RECORD_AUDIO")) {
                permissionState = PermissionState.GRANTED;
            } else {
                PermissionHelper permissionHelper2 = this.l;
                if (permissionHelper2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("permissionHelper");
                }
                if (permissionHelper2.shouldShowRequestPermissionRationale("android.permission.RECORD_AUDIO")) {
                    permissionState = PermissionState.DENIED;
                } else {
                    permissionState = PermissionState.FOREVER_DENIED;
                }
            }
            MyAdvertDetailsPresenter myAdvertDetailsPresenter = this.presenter;
            if (myAdvertDetailsPresenter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("presenter");
            }
            myAdvertDetailsPresenter.onCallPermissionResult(permissionState);
            return;
        }
        super.onRequestPermissionsResult(i2, strArr, iArr);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        super.onSaveInstanceState(bundle);
        MyAdvertDetailsPresenter myAdvertDetailsPresenter = this.presenter;
        if (myAdvertDetailsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        Bundles.putKundle(bundle, "presenter_state", myAdvertDetailsPresenter.onSavedState());
        bundle.putBoolean("advert_status_updated", this.o);
        MyAdvertDetailsInteractor myAdvertDetailsInteractor = this.interactor;
        if (myAdvertDetailsInteractor == null) {
            Intrinsics.throwUninitializedPropertyAccessException("interactor");
        }
        bundle.putBundle("key_interactor_state", myAdvertDetailsInteractor.saveState());
        bundle.putBundle("key_screen_tracker_state", Bundle.EMPTY);
    }

    public final void onShare(@NotNull SharingManager sharingManager, boolean z) {
        Intrinsics.checkNotNullParameter(sharingManager, "socialManager");
        b(new e(this, sharingManager, z));
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        AutoBookingBlockViewModel autoBookingBlockViewModel;
        AutoPublishBlockViewModel autoPublishBlockViewModel;
        super.onStart();
        Object obj = this.m;
        if (obj == null) {
            Intrinsics.throwUninitializedPropertyAccessException("component");
        }
        MyAdvertDetailsComponent myAdvertDetailsComponent = null;
        if (!(obj instanceof MyAdvertDetailsComponent)) {
            obj = null;
        }
        MyAdvertDetailsComponent myAdvertDetailsComponent2 = (MyAdvertDetailsComponent) obj;
        if (!(myAdvertDetailsComponent2 == null || (autoPublishBlockViewModel = myAdvertDetailsComponent2.getAutoPublishBlockViewModel()) == null)) {
            MyAdvertDetailsPresenter myAdvertDetailsPresenter = this.presenter;
            if (myAdvertDetailsPresenter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("presenter");
            }
            autoPublishBlockViewModel.attachDeepLinkListener(myAdvertDetailsPresenter);
        }
        Object obj2 = this.m;
        if (obj2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("component");
        }
        if (obj2 instanceof MyAdvertDetailsComponent) {
            myAdvertDetailsComponent = obj2;
        }
        MyAdvertDetailsComponent myAdvertDetailsComponent3 = myAdvertDetailsComponent;
        if (!(myAdvertDetailsComponent3 == null || (autoBookingBlockViewModel = myAdvertDetailsComponent3.getAutoBookingBlockViewModel()) == null)) {
            MyAdvertDetailsPresenter myAdvertDetailsPresenter2 = this.presenter;
            if (myAdvertDetailsPresenter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("presenter");
            }
            autoBookingBlockViewModel.attachDeepLinkListener(myAdvertDetailsPresenter2);
        }
        MyAdvertDetailsPresenter myAdvertDetailsPresenter3 = this.presenter;
        if (myAdvertDetailsPresenter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        myAdvertDetailsPresenter3.attachRouter(this);
        SocialPresenter socialPresenter2 = this.socialPresenter;
        if (socialPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("socialPresenter");
        }
        socialPresenter2.attachRouter(this);
        AdvertDetailsImvBadgePresenter advertDetailsImvBadgePresenter = this.imvBadgePresenter;
        if (advertDetailsImvBadgePresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imvBadgePresenter");
        }
        advertDetailsImvBadgePresenter.attachRouter(this);
        CarMarketPriceChartPresenter carMarketPriceChartPresenter = this.imvChartPresenter;
        if (carMarketPriceChartPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imvChartPresenter");
        }
        carMarketPriceChartPresenter.attachRouter(this);
        DeepLink deepLink = (DeepLink) getIntent().getParcelableExtra("key_invoke_action");
        getIntent().removeExtra("key_invoke_action");
        if (deepLink != null) {
            MyAdvertDetailsPresenter myAdvertDetailsPresenter4 = this.presenter;
            if (myAdvertDetailsPresenter4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("presenter");
            }
            myAdvertDetailsPresenter4.invokeAction(deepLink);
        }
        String stringExtra = getIntent().getStringExtra("key_instant_message");
        getIntent().removeExtra("key_instant_message");
        if (stringExtra != null) {
            MyAdvertDetailsView myAdvertDetailsView = this.k;
            if (myAdvertDetailsView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("myAdvertDetailsView");
            }
            myAdvertDetailsView.showSnackBar(stringExtra);
        }
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        AutoBookingBlockViewModel autoBookingBlockViewModel;
        AutoPublishBlockViewModel autoPublishBlockViewModel;
        Object obj = this.m;
        if (obj == null) {
            Intrinsics.throwUninitializedPropertyAccessException("component");
        }
        MyAdvertDetailsComponent myAdvertDetailsComponent = null;
        if (!(obj instanceof MyAdvertDetailsComponent)) {
            obj = null;
        }
        MyAdvertDetailsComponent myAdvertDetailsComponent2 = (MyAdvertDetailsComponent) obj;
        if (!(myAdvertDetailsComponent2 == null || (autoPublishBlockViewModel = myAdvertDetailsComponent2.getAutoPublishBlockViewModel()) == null)) {
            autoPublishBlockViewModel.detachDeepLinkListener();
        }
        Object obj2 = this.m;
        if (obj2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("component");
        }
        if (obj2 instanceof MyAdvertDetailsComponent) {
            myAdvertDetailsComponent = obj2;
        }
        MyAdvertDetailsComponent myAdvertDetailsComponent3 = myAdvertDetailsComponent;
        if (!(myAdvertDetailsComponent3 == null || (autoBookingBlockViewModel = myAdvertDetailsComponent3.getAutoBookingBlockViewModel()) == null)) {
            autoBookingBlockViewModel.detachDeepLinkListener();
        }
        MyAdvertDetailsPresenter myAdvertDetailsPresenter = this.presenter;
        if (myAdvertDetailsPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
        }
        myAdvertDetailsPresenter.detachRouter();
        SocialPresenter socialPresenter2 = this.socialPresenter;
        if (socialPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("socialPresenter");
        }
        socialPresenter2.detachRouter();
        AdvertDetailsImvBadgePresenter advertDetailsImvBadgePresenter = this.imvBadgePresenter;
        if (advertDetailsImvBadgePresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imvBadgePresenter");
        }
        advertDetailsImvBadgePresenter.detachRouter();
        CarMarketPriceChartPresenter carMarketPriceChartPresenter = this.imvChartPresenter;
        if (carMarketPriceChartPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imvChartPresenter");
        }
        carMarketPriceChartPresenter.detachRouter();
        super.onStop();
    }

    @Override // com.avito.android.user_advert.advert.MyAdvertRouter
    public void openAuth() {
        ActivityIntentFactory activityIntentFactory2 = this.activityIntentFactory;
        if (activityIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activityIntentFactory");
        }
        startActivityForResult(AuthIntentFactory.DefaultImpls.authIntent$default(activityIntentFactory2, null, AuthSource.OPEN_USER_ADVERT, null, 4, null), 4);
    }

    @Override // com.avito.android.user_advert.advert.MyAdvertRouter, com.avito.android.advert_core.short_term_rent.AdvertStrBlockViewModel.DeepLinkRouter
    public void openDeepLink(@NotNull DeepLink deepLink) {
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        DeepLinkIntentFactory deepLinkIntentFactory2 = this.deepLinkIntentFactory;
        if (deepLinkIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deepLinkIntentFactory");
        }
        Intent intent = deepLinkIntentFactory2.getIntent(deepLink);
        if (((deepLink instanceof ChannelDetailsLink) || (deepLink instanceof ChannelsLink)) && intent != null) {
            intent.removeExtra(Constants.UP_INTENT);
        }
        if (intent != null) {
            if (deepLink instanceof FeeMethodsLink) {
                startActivityForResult(intent, 14);
            } else {
                startActivity(intent);
            }
        }
        if (deepLink instanceof ItemStatsLink) {
            b(new f(this));
        }
    }

    @Override // com.avito.android.user_advert.advert.MyAdvertRouter
    public void openDraftEdit(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "draftId");
        ActivityIntentFactory activityIntentFactory2 = this.activityIntentFactory;
        if (activityIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activityIntentFactory");
        }
        startActivityForResult(PublishIntentFactory.DefaultImpls.publishAdvertFromDraftIntent$default(activityIntentFactory2, str, false, 2, null), 2);
    }

    @Override // com.avito.android.user_advert.advert.MyAdvertRouter
    public void openEdit(@NotNull String str, @Nullable String str2, @Nullable String str3) {
        Intrinsics.checkNotNullParameter(str, "itemId");
        ActivityIntentFactory activityIntentFactory2 = this.activityIntentFactory;
        if (activityIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activityIntentFactory");
        }
        startActivityForResult(activityIntentFactory2.editingAdvertIntent(str, str2, str3), 2);
    }

    @Override // com.avito.android.user_advert.advert.MyAdvertRouter
    public void openFees(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        ActivityIntentFactory activityIntentFactory2 = this.activityIntentFactory;
        if (activityIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activityIntentFactory");
        }
        startActivityForResult(FeesIntentFactory.DefaultImpls.feesIntent$default(activityIntentFactory2, str, false, false, 6, null), 1);
    }

    @Override // com.avito.android.user_advert.advert.MyAdvertRouter
    public void openSharing(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "url");
        Intrinsics.checkNotNullParameter(str2, "title");
        ImplicitIntentFactory implicitIntentFactory2 = this.implicitIntentFactory;
        if (implicitIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("implicitIntentFactory");
        }
        Intent createChooser = Intent.createChooser(implicitIntentFactory2.shareItemIntent(str, str2), getString(com.avito.android.user_advert.R.string.menu_share));
        Intrinsics.checkNotNullExpressionValue(createChooser, "Intent.createChooser(sha…ing(R.string.menu_share))");
        Contexts.startActivitySafely(this, createChooser);
        b(new g(this));
    }

    @Override // com.avito.android.user_advert.advert.MyAdvertRouter
    public void openSoaWithPriceBottomSheet(@NotNull String str, @NotNull List<CloseReason> list) {
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        Intrinsics.checkNotNullParameter(list, "reasons");
        Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag("SoaWithPriceDialog");
        if (findFragmentByTag == null || !findFragmentByTag.isAdded()) {
            SoaWithPriceSheetDialogFragmentKt.createSoaWithPriceSheetDialogFragment(new SoaWithPriceArguments(list, str)).show(getSupportFragmentManager(), "SoaWithPriceDialog");
        }
    }

    @Override // com.avito.android.user_advert.advert.MyAdvertRouter
    public void openUrl(@NotNull Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "url");
        ImplicitIntentFactory implicitIntentFactory2 = this.implicitIntentFactory;
        if (implicitIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("implicitIntentFactory");
        }
        try {
            startActivity(IntentsKt.makeSafeForExternalApps(ImplicitIntentFactory.DefaultImpls.uriIntentCustomChromeTabs$default(implicitIntentFactory2, uri, false, 2, null)));
        } catch (Exception unused) {
            MyAdvertDetailsView access$getMyAdvertDetailsView$p = access$getMyAdvertDetailsView$p(this);
            String string = getString(com.avito.android.ui_components.R.string.no_application_installed_to_perform_this_action);
            Intrinsics.checkNotNullExpressionValue(string, "getString(ui_R.string.no…d_to_perform_this_action)");
            access$getMyAdvertDetailsView$p.showSnackBar(string);
        }
    }

    @Override // com.avito.android.user_advert.advert.MyAdvertRouter
    public void openUserAdvertsScreen(@Nullable AdvertActionTransferData advertActionTransferData) {
        ActivityIntentFactory activityIntentFactory2 = this.activityIntentFactory;
        if (activityIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activityIntentFactory");
        }
        startActivity(UserAdvertsIntentFactory.DefaultImpls.createUserAdvertsIntent$default(activityIntentFactory2, null, advertActionTransferData, false, 4, null));
    }

    @Override // com.avito.android.user_advert.advert.MyAdvertRouter
    public void openVerificationWizard(@NotNull String str, @NotNull List<VerificationStep> list) {
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        Intrinsics.checkNotNullParameter(list, "steps");
        ActivityIntentFactory activityIntentFactory2 = this.activityIntentFactory;
        if (activityIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activityIntentFactory");
        }
        startActivityForResult(activityIntentFactory2.photoWizardIntent(str, list), 12);
    }

    @Override // com.avito.android.user_advert.advert.MyAdvertRouter
    public void reopenScreen() {
        Intent intent = getIntent();
        intent.removeExtra("key_restore_advert");
        intent.removeExtra("key_open_activate_dialog");
        startActivity(intent);
    }

    public final void setActivityIntentFactory(@NotNull ActivityIntentFactory activityIntentFactory2) {
        Intrinsics.checkNotNullParameter(activityIntentFactory2, "<set-?>");
        this.activityIntentFactory = activityIntentFactory2;
    }

    public final void setAnalytics(@NotNull Analytics analytics2) {
        Intrinsics.checkNotNullParameter(analytics2, "<set-?>");
        this.analytics = analytics2;
    }

    public final void setAttributedTextFormatter(@NotNull AttributedTextFormatter attributedTextFormatter2) {
        Intrinsics.checkNotNullParameter(attributedTextFormatter2, "<set-?>");
        this.attributedTextFormatter = attributedTextFormatter2;
    }

    public final void setContactsPresenter(@NotNull MyAdvertContactsPresenter myAdvertContactsPresenter) {
        Intrinsics.checkNotNullParameter(myAdvertContactsPresenter, "<set-?>");
        this.contactsPresenter = myAdvertContactsPresenter;
    }

    public final void setDeepLinkFactory(@NotNull DeepLinkFactory deepLinkFactory2) {
        Intrinsics.checkNotNullParameter(deepLinkFactory2, "<set-?>");
        this.deepLinkFactory = deepLinkFactory2;
    }

    public final void setDeepLinkIntentFactory(@NotNull DeepLinkIntentFactory deepLinkIntentFactory2) {
        Intrinsics.checkNotNullParameter(deepLinkIntentFactory2, "<set-?>");
        this.deepLinkIntentFactory = deepLinkIntentFactory2;
    }

    public final void setDeliveryEventTracker(@NotNull DeliveryEventTracker deliveryEventTracker2) {
        Intrinsics.checkNotNullParameter(deliveryEventTracker2, "<set-?>");
        this.deliveryEventTracker = deliveryEventTracker2;
    }

    public final void setDialogRouter(@NotNull DialogRouter dialogRouter2) {
        Intrinsics.checkNotNullParameter(dialogRouter2, "<set-?>");
        this.dialogRouter = dialogRouter2;
    }

    public final void setEventTracker(@NotNull AdvertSharingEventTracker advertSharingEventTracker) {
        Intrinsics.checkNotNullParameter(advertSharingEventTracker, "<set-?>");
        this.eventTracker = advertSharingEventTracker;
    }

    public final void setFeatureTeasersViewFactory(@NotNull MyAdvertDetailsFeatureTeaserViewFactory myAdvertDetailsFeatureTeaserViewFactory) {
        Intrinsics.checkNotNullParameter(myAdvertDetailsFeatureTeaserViewFactory, "<set-?>");
        this.featureTeasersViewFactory = myAdvertDetailsFeatureTeaserViewFactory;
    }

    public final void setFeatures(@NotNull Features features2) {
        Intrinsics.checkNotNullParameter(features2, "<set-?>");
        this.features = features2;
    }

    public final void setImplicitIntentFactory(@NotNull ImplicitIntentFactory implicitIntentFactory2) {
        Intrinsics.checkNotNullParameter(implicitIntentFactory2, "<set-?>");
        this.implicitIntentFactory = implicitIntentFactory2;
    }

    public final void setImvBadgePresenter(@NotNull AdvertDetailsImvBadgePresenter advertDetailsImvBadgePresenter) {
        Intrinsics.checkNotNullParameter(advertDetailsImvBadgePresenter, "<set-?>");
        this.imvBadgePresenter = advertDetailsImvBadgePresenter;
    }

    public final void setImvChartPresenter(@NotNull CarMarketPriceChartPresenter carMarketPriceChartPresenter) {
        Intrinsics.checkNotNullParameter(carMarketPriceChartPresenter, "<set-?>");
        this.imvChartPresenter = carMarketPriceChartPresenter;
    }

    public final void setInteractor(@NotNull MyAdvertDetailsInteractor myAdvertDetailsInteractor) {
        Intrinsics.checkNotNullParameter(myAdvertDetailsInteractor, "<set-?>");
        this.interactor = myAdvertDetailsInteractor;
    }

    public final void setPresenter(@NotNull MyAdvertDetailsPresenter myAdvertDetailsPresenter) {
        Intrinsics.checkNotNullParameter(myAdvertDetailsPresenter, "<set-?>");
        this.presenter = myAdvertDetailsPresenter;
    }

    public final void setSocialPresenter(@NotNull SocialPresenter socialPresenter2) {
        Intrinsics.checkNotNullParameter(socialPresenter2, "<set-?>");
        this.socialPresenter = socialPresenter2;
    }

    public final void setSocialTypeToStringMapper(@NotNull SocialTypeToStringMapper socialTypeToStringMapper2) {
        Intrinsics.checkNotNullParameter(socialTypeToStringMapper2, "<set-?>");
        this.socialTypeToStringMapper = socialTypeToStringMapper2;
    }

    public final void setTracker(@NotNull MyAdvertDetailsTracker myAdvertDetailsTracker) {
        Intrinsics.checkNotNullParameter(myAdvertDetailsTracker, "<set-?>");
        this.tracker = myAdvertDetailsTracker;
    }

    @Override // com.avito.android.ui.activity.BaseActivity
    public boolean setUpActivityComponent(@Nullable Bundle bundle) {
        Object obj;
        Timer B1 = a2.b.a.a.a.B1();
        Intent intent = getIntent();
        String stringExtra = intent.getStringExtra("status_message");
        Bundle bundle2 = bundle != null ? bundle.getBundle("key_interactor_state") : null;
        boolean booleanExtra = intent.getBooleanExtra("key_should_finish_after_activation", true);
        boolean z = getCallingActivity() == null;
        boolean booleanExtra2 = intent.getBooleanExtra("key_open_activate_dialog", false);
        boolean booleanExtra3 = intent.getBooleanExtra("key_is_new_advert", false);
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = null;
        if (bundle != null) {
            objectRef.element = (T) Bundles.getKundle(bundle, "presenter_state");
        }
        h hVar = new h(this, booleanExtra3, booleanExtra2, z, booleanExtra, stringExtra, bundle2, objectRef);
        DetailsId detailsId = this.p;
        if (detailsId == null) {
            Intrinsics.throwUninitializedPropertyAccessException("detailsId");
        }
        if (detailsId instanceof AdvertId) {
            obj = hVar.invoke(DaggerMyAdvertDetailsComponent.builder());
            ((MyAdvertDetailsComponent) obj).inject(this);
        } else if (detailsId instanceof DraftId) {
            obj = hVar.invoke(DaggerMyDraftDetailsComponent.builder());
            ((MyDraftDetailsComponent) obj).inject(this);
        } else {
            throw new NoWhenBranchMatchedException();
        }
        this.m = obj;
        MyAdvertDetailsTracker myAdvertDetailsTracker = this.tracker;
        if (myAdvertDetailsTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tracker");
        }
        myAdvertDetailsTracker.trackDiInject(B1.elapsed());
        return true;
    }

    @Override // com.avito.android.ui.activity.BaseActivity
    public boolean setUpCustomToolbar() {
        return true;
    }

    @Override // com.avito.android.advert_core.social.SocialPresenter.Router
    public void share(@NotNull SharingManager sharingManager, @NotNull String str, @Nullable Function1<? super SharingManager.ShareError, Unit> function1) {
        Intrinsics.checkNotNullParameter(sharingManager, "socialManager");
        Intrinsics.checkNotNullParameter(str, "link");
        sharingManager.share(this, str, function1);
    }

    @Override // com.avito.android.advert_core.social.SocialPresenter.Router
    public boolean shouldRestoreShare(@NotNull SharingManager sharingManager) {
        Intrinsics.checkNotNullParameter(sharingManager, "socialManager");
        return sharingManager.shouldRestoreShare(this);
    }

    @Override // com.avito.android.user_advert.advert.MyAdvertRouter
    public void showAddressOnMap(@NotNull String str, @NotNull Coordinates coordinates, @NotNull String str2, @Nullable List<GeoReference> list) {
        Intrinsics.checkNotNullParameter(str, IntegrityManager.INTEGRITY_TYPE_ADDRESS);
        Intrinsics.checkNotNullParameter(coordinates, "coordinates");
        Intrinsics.checkNotNullParameter(str2, "title");
        ActivityIntentFactory activityIntentFactory2 = this.activityIntentFactory;
        if (activityIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activityIntentFactory");
        }
        startActivity(ItemMapIntentFactory.DefaultImpls.itemMapIntent$default(activityIntentFactory2, coordinates, true, null, true, str, str2, list, null, null, true, false, null, false, FindLocationPage.SELLER_ITEM_MAP.getValue(), 7168, null));
    }

    @Override // com.avito.android.user_advert.advert.MyAdvertRouter
    public void showGalleryFullscreen(@Nullable Video video, @NotNull List<Image> list, @Nullable ForegroundImage foregroundImage, int i2) {
        Intrinsics.checkNotNullParameter(list, "images");
        ActivityIntentFactory activityIntentFactory2 = this.activityIntentFactory;
        if (activityIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activityIntentFactory");
        }
        Intent flags = PhotoGalleryIntentFactory.DefaultImpls.legacyPhotoGalleryIntent$default(activityIntentFactory2, video, list, i2, null, null, null, null, null, null, null, foregroundImage, null, 2560, null).setFlags(603979776);
        Intrinsics.checkNotNullExpressionValue(flags, "activityIntentFactory.le…FLAG_ACTIVITY_SINGLE_TOP)");
        startActivityForResult(flags, 3);
    }

    @Override // com.avito.android.user_advert.advert.MyAdvertRouter
    public void showHelpCenterScreen(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "url");
        String path = new URL(str).getPath();
        Intrinsics.checkNotNullExpressionValue(path, "URL(url).path");
        Objects.requireNonNull(path, "null cannot be cast to non-null type java.lang.String");
        String substring = path.substring(1);
        Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.String).substring(startIndex)");
        ActivityIntentFactory activityIntentFactory2 = this.activityIntentFactory;
        if (activityIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activityIntentFactory");
        }
        startActivity(activityIntentFactory2.helpCenterIntent(substring));
    }

    @Override // com.avito.android.user_advert.advert.MyAdvertRouter
    public void showInactiveItem(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "itemId");
        ActivityIntentFactory activityIntentFactory2 = this.activityIntentFactory;
        if (activityIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activityIntentFactory");
        }
        startActivity(activityIntentFactory2.inactiveItemIntent(str));
    }

    @Override // com.avito.android.user_advert.advert.MyAdvertRouter, com.avito.android.advert_core.short_term_rent.AdvertStrBlockViewModel.DeepLinkRouter
    public void showSellerCalendar(@NotNull DeepLink deepLink) {
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        DeepLinkIntentFactory deepLinkIntentFactory2 = this.deepLinkIntentFactory;
        if (deepLinkIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deepLinkIntentFactory");
        }
        startActivityForResult(deepLinkIntentFactory2.getIntent(deepLink), 11);
    }

    @Override // com.avito.android.advert_core.SnackBarListener
    public void showSnackBar(@NotNull String str, int i2, int i3, @Nullable String str2, @Nullable Function0<Unit> function0, boolean z) {
        Snackbar showSnackBar$default;
        Intrinsics.checkNotNullParameter(str, "text");
        ViewGroup viewGroup = this.s;
        if (!(viewGroup == null || (showSnackBar$default = Views.showSnackBar$default(viewGroup, str, i2, str2, i3, function0, (Function0) null, 0, 96, (Object) null)) == null)) {
            showSnackBar$default.show();
        }
        if (!z) {
            b(new i(this));
        }
    }
}
