package com.avito.android.user_advert.advert;

import a2.a.a.h3.a.a1;
import a2.a.a.h3.a.b1;
import a2.a.a.h3.a.d1;
import a2.a.a.h3.a.e1;
import a2.a.a.h3.a.y0;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.advert_core.advert.AdvertDetailsFlatViewImpl;
import com.avito.android.advert_core.advert.AdvertDetailsGroupViewImpl;
import com.avito.android.advert_core.feature_teasers.common.FeatureTeaserView;
import com.avito.android.advert_core.georeference.GeoReferenceViewWrapper;
import com.avito.android.advert_core.georeference.GeoReferenceViewWrapperImpl;
import com.avito.android.advert_core.safe_show.SafeShowDialogFactory;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.provider.clickstream.ParametrizedClickStreamEvent;
import com.avito.android.analytics.screens.MyAdvertDetailsScreen;
import com.avito.android.app_rater.events.AppRaterEventSourcePage;
import com.avito.android.app_rater.fragment.AppRaterDialogFragment;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.component.icons_view.IconsView;
import com.avito.android.db.FavoritesContract;
import com.avito.android.deep_linking.links.DetailsSheetLinkBody;
import com.avito.android.deep_linking.links.OnDeepLinkClickListener;
import com.avito.android.design.widget.ExpandablePanel;
import com.avito.android.image_loader.ImageRequest;
import com.avito.android.image_loader.Picture;
import com.avito.android.lib.design.alert_banner.AlertBanner;
import com.avito.android.lib.design.alert_banner.AlertBannerContent;
import com.avito.android.lib.design.banner.Banner;
import com.avito.android.lib.design.button.Button;
import com.avito.android.lib.design.dialog.Dialog;
import com.avito.android.lib.design.tooltip.TailPositions;
import com.avito.android.lib.design.tooltip.Tooltip;
import com.avito.android.lib.design.tooltip.TooltipContentKt;
import com.avito.android.lib.design.tooltip.TooltipPositions;
import com.avito.android.permissions.PermissionHelper;
import com.avito.android.photo_gallery.ui.PhotoGallery;
import com.avito.android.progress_overlay.LoadingOverlay;
import com.avito.android.progress_overlay.ProgressOverlay;
import com.avito.android.publish_limits_info.PublishLimitsInfoView;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Action;
import com.avito.android.remote.model.AdvertParameters;
import com.avito.android.remote.model.AdvertStatsContact;
import com.avito.android.remote.model.AnonymousNumber;
import com.avito.android.remote.model.ContractInfo;
import com.avito.android.remote.model.ForegroundImage;
import com.avito.android.remote.model.GeoReference;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.LimitsInfo;
import com.avito.android.remote.model.RejectReason;
import com.avito.android.remote.model.Video;
import com.avito.android.remote.model.adverts.MyAdvertDetails;
import com.avito.android.remote.model.badge.Badge;
import com.avito.android.remote.model.feature_teaser.SafeShow;
import com.avito.android.remote.model.text.AttributedText;
import com.avito.android.remote.model.user_adverts.UserOrderStatus;
import com.avito.android.ui_components.R;
import com.avito.android.user_advert.advert.MyAdvertDetailsViewPresenter;
import com.avito.android.user_advert.advert.feature_teasers.MyAdvertDetailsFeatureTeaserViewFactory;
import com.avito.android.user_advert.advert.verification.VerificationBlockItem;
import com.avito.android.user_advert.advert.verification.VerificationBlockView;
import com.avito.android.user_advert.advert.verification.VerificationBlockViewImpl;
import com.avito.android.user_advert.event.CallPermissionDialogEvent;
import com.avito.android.util.ActionMenu;
import com.avito.android.util.Contexts;
import com.avito.android.util.DialogRouter;
import com.avito.android.util.ImplicitIntentFactory;
import com.avito.android.util.SimpleDraweeView;
import com.avito.android.util.SimpleDraweeViewsKt;
import com.avito.android.util.TextViews;
import com.avito.android.util.ToastsKt;
import com.avito.android.util.Toolbars;
import com.avito.android.util.ViewUtils;
import com.avito.android.util.Views;
import com.avito.android.util.rx3.InteropKt;
import com.avito.android.util.text.AttributedTextFormatter;
import com.facebook.appevents.integrity.IntegrityManager;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.jakewharton.rxbinding3.view.RxView;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.functions.Cancellable;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.component.serp.BadgesKt;
import ru.avito.component.statistics.StatisticsView;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u00012\u00020\u0002Bm\u0012\b\u0010ì\u0002\u001a\u00030É\u0001\u0012\b\u0010\u0003\u001a\u00030ý\u0002\u0012\b\u0010â\u0001\u001a\u00030ß\u0001\u0012\b\u0010ø\u0001\u001a\u00030õ\u0001\u0012\b\u0010ü\u0002\u001a\u00030ù\u0002\u0012\b\u0010ì\u0001\u001a\u00030é\u0001\u0012\b\u0010\u0002\u001a\u00030\u0002\u0012\b\u0010ä\u0002\u001a\u00030á\u0002\u0012\b\u0010Á\u0002\u001a\u00030¾\u0002\u0012\b\u0010\u0002\u001a\u00030\u0002¢\u0006\u0006\b\u0003\u0010\u0003J\u000f\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0005J\u001d\u0010\n\u001a\u00020\u00032\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ3\u0010\u0016\u001a\u00020\u00032\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u00072\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0015\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\f0\u0018H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u0015\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0018H\u0016¢\u0006\u0004\b\u001b\u0010\u001aJ\u0017\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u001cH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u0015\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00030\u0018H\u0016¢\u0006\u0004\b \u0010\u001aJ\u000f\u0010!\u001a\u00020\u0003H\u0016¢\u0006\u0004\b!\u0010\u0005J%\u0010&\u001a\u00020\u00032\u0006\u0010#\u001a\u00020\"2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00030$H\u0016¢\u0006\u0004\b&\u0010'J\u000f\u0010(\u001a\u00020\u0003H\u0016¢\u0006\u0004\b(\u0010\u0005J\u0017\u0010*\u001a\u00020\u00032\u0006\u0010)\u001a\u00020\"H\u0016¢\u0006\u0004\b*\u0010+J\u0019\u0010-\u001a\u00020\u00032\b\u0010,\u001a\u0004\u0018\u00010\"H\u0016¢\u0006\u0004\b-\u0010+J\u0017\u00100\u001a\u00020\u00032\u0006\u0010/\u001a\u00020.H\u0016¢\u0006\u0004\b0\u00101J\u0019\u00103\u001a\u00020\u00032\b\u00102\u001a\u0004\u0018\u00010\"H\u0016¢\u0006\u0004\b3\u0010+J\u000f\u00104\u001a\u00020\u0003H\u0016¢\u0006\u0004\b4\u0010\u0005J\u001d\u00106\u001a\u00020\u00032\f\u00105\u001a\b\u0012\u0004\u0012\u00020\u00030$H\u0016¢\u0006\u0004\b6\u00107J\u000f\u00108\u001a\u00020\u0003H\u0016¢\u0006\u0004\b8\u0010\u0005J!\u0010=\u001a\u00020\u00032\u0006\u0010:\u001a\u0002092\b\u0010<\u001a\u0004\u0018\u00010;H\u0016¢\u0006\u0004\b=\u0010>J\u000f\u0010?\u001a\u00020\u0003H\u0016¢\u0006\u0004\b?\u0010\u0005J\u000f\u0010@\u001a\u00020\u0003H\u0016¢\u0006\u0004\b@\u0010\u0005J\u0019\u0010C\u001a\u00020\u00032\b\u0010B\u001a\u0004\u0018\u00010AH\u0016¢\u0006\u0004\bC\u0010DJ\u001f\u0010G\u001a\u00020\u00032\u000e\u0010F\u001a\n\u0012\u0004\u0012\u00020E\u0018\u00010\u0007H\u0016¢\u0006\u0004\bG\u0010\u000bJ\u001f\u0010J\u001a\u00020\u00032\u000e\u0010I\u001a\n\u0012\u0004\u0012\u00020H\u0018\u00010\u0007H\u0016¢\u0006\u0004\bJ\u0010\u000bJ\u000f\u0010K\u001a\u00020\u0003H\u0016¢\u0006\u0004\bK\u0010\u0005J\u000f\u0010L\u001a\u00020\u0003H\u0016¢\u0006\u0004\bL\u0010\u0005J\u000f\u0010M\u001a\u00020\u0003H\u0016¢\u0006\u0004\bM\u0010\u0005J\u0017\u0010N\u001a\u00020\u00032\u0006\u0010#\u001a\u00020\"H\u0016¢\u0006\u0004\bN\u0010+J\u000f\u0010O\u001a\u00020\u0003H\u0016¢\u0006\u0004\bO\u0010\u0005J\u0017\u0010P\u001a\u00020\u00032\u0006\u0010#\u001a\u00020\"H\u0016¢\u0006\u0004\bP\u0010+J\u0017\u0010Q\u001a\u00020\u00032\u0006\u0010#\u001a\u00020\"H\u0016¢\u0006\u0004\bQ\u0010+J\u0017\u0010R\u001a\u00020\u00032\u0006\u0010#\u001a\u00020\"H\u0016¢\u0006\u0004\bR\u0010+J\u0017\u0010S\u001a\u00020\u00032\u0006\u0010)\u001a\u00020\"H\u0016¢\u0006\u0004\bS\u0010+J\u0019\u0010U\u001a\u00020\u00032\b\u0010T\u001a\u0004\u0018\u00010\"H\u0016¢\u0006\u0004\bU\u0010+J\u0017\u0010W\u001a\u00020\u00032\u0006\u0010V\u001a\u00020\fH\u0016¢\u0006\u0004\bW\u0010\u000fJ\u0017\u0010Y\u001a\u00020\u00032\u0006\u0010X\u001a\u00020\"H\u0016¢\u0006\u0004\bY\u0010+J\u0015\u0010Z\u001a\b\u0012\u0004\u0012\u00020\u00030\u0018H\u0016¢\u0006\u0004\bZ\u0010\u001aJ\u0017\u0010\\\u001a\u00020\u00032\u0006\u0010T\u001a\u00020[H\u0016¢\u0006\u0004\b\\\u0010]J\u000f\u0010^\u001a\u00020\u0003H\u0016¢\u0006\u0004\b^\u0010\u0005J+\u0010c\u001a\u00020\u00032\u0006\u0010`\u001a\u00020_2\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020b\u0012\u0004\u0012\u00020\u00030aH\u0016¢\u0006\u0004\bc\u0010dJ\u000f\u0010e\u001a\u00020\u0003H\u0016¢\u0006\u0004\be\u0010\u0005J\u001f\u0010h\u001a\u00020\u00032\u0006\u0010f\u001a\u00020\"2\u0006\u0010g\u001a\u00020\"H\u0016¢\u0006\u0004\bh\u0010iJ\u000f\u0010j\u001a\u00020\u0003H\u0016¢\u0006\u0004\bj\u0010\u0005J\u0017\u0010l\u001a\u00020\u00032\u0006\u0010k\u001a\u00020\"H\u0016¢\u0006\u0004\bl\u0010+J\u001f\u0010o\u001a\u00020\u00032\u000e\u0010n\u001a\n\u0012\u0004\u0012\u00020m\u0018\u00010\u0007H\u0016¢\u0006\u0004\bo\u0010\u000bJ\u0015\u0010p\u001a\b\u0012\u0004\u0012\u00020\u00030\u0018H\u0016¢\u0006\u0004\bp\u0010\u001aJ\u0015\u0010q\u001a\b\u0012\u0004\u0012\u00020\u00030\u0018H\u0016¢\u0006\u0004\bq\u0010\u001aJ\u0017\u0010r\u001a\u00020\u00032\u0006\u0010)\u001a\u00020\"H\u0016¢\u0006\u0004\br\u0010+J\u000f\u0010s\u001a\u00020\u0003H\u0016¢\u0006\u0004\bs\u0010\u0005J\u0019\u0010u\u001a\u00020\u00032\b\u0010t\u001a\u0004\u0018\u00010\"H\u0016¢\u0006\u0004\bu\u0010+J\u001d\u0010v\u001a\u00020\u00032\f\u00105\u001a\b\u0012\u0004\u0012\u00020\u00030$H\u0016¢\u0006\u0004\bv\u00107J1\u0010|\u001a\u00020\u00032\u0006\u0010w\u001a\u00020\f2\u0006\u0010x\u001a\u00020\f2\u0006\u0010y\u001a\u00020\f2\b\u0010{\u001a\u0004\u0018\u00010zH\u0016¢\u0006\u0004\b|\u0010}J\u000f\u0010~\u001a\u00020\u0003H\u0016¢\u0006\u0004\b~\u0010\u0005J\u000f\u0010\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0010\u0005J@\u0010\u0001\u001a\u00020\u00032\u0006\u0010T\u001a\u00020\"2\u0015\u0010\u0001\u001a\u0010\u0012\u0004\u0012\u00020\"\u0012\u0005\u0012\u00030\u00010\u00012\r\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020\u00030$H\u0016¢\u0006\u0006\b\u0001\u0010\u0001J:\u0010\u0001\u001a\u00020\u00032\b\u0010\u0001\u001a\u00030\u00012\r\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020\u00030$2\r\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020\u00030$H\u0016¢\u0006\u0006\b\u0001\u0010\u0001J+\u0010\u0001\u001a\u00020\u00032\b\u0010\u0001\u001a\u00030\u00012\r\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020\u00030$H\u0016¢\u0006\u0006\b\u0001\u0010\u0001J\u001e\u0010\u0001\u001a\u00020\u00032\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0016¢\u0006\u0006\b\u0001\u0010\u0001J%\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020\u001c2\u0007\u0010\u0001\u001a\u00020\u001cH\u0016¢\u0006\u0006\b\u0001\u0010\u0001J$\u0010\u0001\u001a\u00020\u00032\u0007\u0010\u0001\u001a\u00020\"2\u0007\u0010\u0001\u001a\u00020\u001cH\u0016¢\u0006\u0006\b\u0001\u0010\u0001J\u001c\u0010\u0001\u001a\u00020\u00032\b\u0010\u0001\u001a\u00030\u0001H\u0016¢\u0006\u0006\b\u0001\u0010\u0001J\u001c\u0010¡\u0001\u001a\u00020\u00032\b\u0010 \u0001\u001a\u00030\u0001H\u0016¢\u0006\u0006\b¡\u0001\u0010¢\u0001J\u001a\u0010¤\u0001\u001a\u00020\u00032\u0007\u0010£\u0001\u001a\u00020\fH\u0016¢\u0006\u0005\b¤\u0001\u0010\u000fJ\u0011\u0010¥\u0001\u001a\u00020\u0003H\u0016¢\u0006\u0005\b¥\u0001\u0010\u0005J-\u0010©\u0001\u001a\u00020\u00032\t\u0010¦\u0001\u001a\u0004\u0018\u00010\"2\u000e\u0010¨\u0001\u001a\t\u0012\u0005\u0012\u00030§\u00010\u0007H\u0016¢\u0006\u0006\b©\u0001\u0010ª\u0001J\u001c\u0010¬\u0001\u001a\u00020\u00032\t\u0010«\u0001\u001a\u0004\u0018\u00010\"H\u0016¢\u0006\u0005\b¬\u0001\u0010+J\u001b\u0010®\u0001\u001a\u00020\u00032\u0007\u00105\u001a\u00030­\u0001H\u0016¢\u0006\u0006\b®\u0001\u0010¯\u0001J\u001e\u0010²\u0001\u001a\u00020\u00032\n\u0010±\u0001\u001a\u0005\u0018\u00010°\u0001H\u0016¢\u0006\u0006\b²\u0001\u0010³\u0001J\u001c\u0010¶\u0001\u001a\u00020\u00032\b\u0010µ\u0001\u001a\u00030´\u0001H\u0016¢\u0006\u0006\b¶\u0001\u0010·\u0001J\u0011\u0010¸\u0001\u001a\u00020\u0003H\u0016¢\u0006\u0005\b¸\u0001\u0010\u0005J%\u0010¼\u0001\u001a\u00020\u00032\b\u0010º\u0001\u001a\u00030¹\u00012\u0007\u0010»\u0001\u001a\u00020\u001cH\u0016¢\u0006\u0006\b¼\u0001\u0010½\u0001J\u0011\u0010¾\u0001\u001a\u00020\u0003H\u0016¢\u0006\u0005\b¾\u0001\u0010\u0005J\u001d\u0010À\u0001\u001a\u00020\u00032\t\u0010¿\u0001\u001a\u0004\u0018\u00010\"H\u0001¢\u0006\u0005\bÀ\u0001\u0010+J\u001d\u0010Á\u0001\u001a\u00020\u00032\t\u0010¿\u0001\u001a\u0004\u0018\u00010\"H\u0001¢\u0006\u0005\bÁ\u0001\u0010+J\u001d\u0010Â\u0001\u001a\u00020\u00032\t\u0010¿\u0001\u001a\u0004\u0018\u00010\"H\u0001¢\u0006\u0005\bÂ\u0001\u0010+J\u0018\u0010Ã\u0001\u001a\b\u0012\u0004\u0012\u00020\u00030\u0018H\u0001¢\u0006\u0005\bÃ\u0001\u0010\u001aJ\u0018\u0010Ä\u0001\u001a\b\u0012\u0004\u0012\u00020\u00030\u0018H\u0001¢\u0006\u0005\bÄ\u0001\u0010\u001aJ\u001b\u0010Æ\u0001\u001a\u00020\u00032\u0007\u0010Å\u0001\u001a\u00020\u001cH\u0001¢\u0006\u0005\bÆ\u0001\u0010\u001fJ\u001b\u0010Ç\u0001\u001a\u00020\u00032\u0007\u0010Å\u0001\u001a\u00020\u001cH\u0001¢\u0006\u0005\bÇ\u0001\u0010\u001fJ\u001b\u0010È\u0001\u001a\u00020\u00032\u0007\u0010Å\u0001\u001a\u00020\u001cH\u0001¢\u0006\u0005\bÈ\u0001\u0010\u001fR\u001a\u0010Ì\u0001\u001a\u00030É\u00018\u0002@\u0002X\u000e¢\u0006\b\n\u0006\bÊ\u0001\u0010Ë\u0001R\u001c\u0010Ð\u0001\u001a\u0005\u0018\u00010Í\u00018\u0002@\u0002X\u000e¢\u0006\b\n\u0006\bÎ\u0001\u0010Ï\u0001R\u001a\u0010Ô\u0001\u001a\u00030Ñ\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bÒ\u0001\u0010Ó\u0001R\u001a\u0010Ø\u0001\u001a\u00030Õ\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bÖ\u0001\u0010×\u0001R#\u0010Þ\u0001\u001a\u00030Ù\u00018B@\u0002X\u0002¢\u0006\u0010\n\u0006\bÚ\u0001\u0010Û\u0001\u001a\u0006\bÜ\u0001\u0010Ý\u0001R\u001a\u0010â\u0001\u001a\u00030ß\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bà\u0001\u0010á\u0001R\u001a\u0010æ\u0001\u001a\u00030ã\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bä\u0001\u0010å\u0001R\u001c\u0010è\u0001\u001a\u0005\u0018\u00010ã\u00018\u0002@\u0002X\u000e¢\u0006\b\n\u0006\bç\u0001\u0010å\u0001R\u001a\u0010ì\u0001\u001a\u00030é\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bê\u0001\u0010ë\u0001R\u001a\u0010ð\u0001\u001a\u00030í\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bî\u0001\u0010ï\u0001R\u001a\u0010ô\u0001\u001a\u00030ñ\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bò\u0001\u0010ó\u0001R\u001a\u0010ø\u0001\u001a\u00030õ\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bö\u0001\u0010÷\u0001R\u001c\u0010ú\u0001\u001a\u0005\u0018\u00010É\u00018\u0002@\u0002X\u000e¢\u0006\b\n\u0006\bù\u0001\u0010Ë\u0001R\u001a\u0010ü\u0001\u001a\u00030É\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bû\u0001\u0010Ë\u0001R\u001a\u0010\u0002\u001a\u00030ý\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bþ\u0001\u0010ÿ\u0001R\u001a\u0010\u0002\u001a\u00030í\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0002\u0010ï\u0001R\u001a\u0010\u0002\u001a\u00030\u00028\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0002\u0010\u0002R\u001a\u0010\u0002\u001a\u00030\u00028\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0002\u0010\u0002R\u001a\u0010\u0002\u001a\u00030\u00028\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0002\u0010\u0002R\u001c\u0010\u0002\u001a\u0005\u0018\u00010ã\u00018\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0002\u0010å\u0001R\u001a\u0010\u0002\u001a\u00030\u00028\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0002\u0010\u0002R\u001a\u0010\u0002\u001a\u00030\u00028\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0002\u0010\u0002R\u001c\u0010\u0002\u001a\u0005\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0002\u0010\u0002R\u001a\u0010 \u0002\u001a\u00030\u00028\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0002\u0010\u0002R\u001c\u0010¢\u0002\u001a\u0005\u0018\u00010É\u00018\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b¡\u0002\u0010Ë\u0001R\"\u0010¦\u0002\u001a\u00030É\u00018\u0016@\u0016X\u0004¢\u0006\u0010\n\u0006\b£\u0002\u0010Ë\u0001\u001a\u0006\b¤\u0002\u0010¥\u0002R\u001c\u0010ª\u0002\u001a\u0005\u0018\u00010§\u00028\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b¨\u0002\u0010©\u0002R\u001a\u0010®\u0002\u001a\u00030«\u00028\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b¬\u0002\u0010­\u0002R\u001a\u0010°\u0002\u001a\u00030É\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b¯\u0002\u0010Ë\u0001R\u001a\u0010²\u0002\u001a\u00030ã\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b±\u0002\u0010å\u0001R#\u0010¶\u0002\u001a\r ´\u0002*\u0005\u0018\u00010³\u00020³\u00028\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b\u0004\u0010µ\u0002R#\u0010¹\u0002\u001a\r ´\u0002*\u0005\u0018\u00010·\u00020·\u00028\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b\u0006\u0010¸\u0002R\u001a\u0010½\u0002\u001a\u00030º\u00028\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b»\u0002\u0010¼\u0002R\u001a\u0010Á\u0002\u001a\u00030¾\u00028\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b¿\u0002\u0010À\u0002R\u001c\u0010Ã\u0002\u001a\u0005\u0018\u00010ã\u00018\u0002@\u0002X\u000e¢\u0006\b\n\u0006\bÂ\u0002\u0010å\u0001R\u001a\u0010Å\u0002\u001a\u00030ã\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bÄ\u0002\u0010å\u0001R\u001a\u0010Ç\u0002\u001a\u00030í\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bÆ\u0002\u0010ï\u0001R\u001c\u0010É\u0002\u001a\u0005\u0018\u00010É\u00018\u0002@\u0002X\u000e¢\u0006\b\n\u0006\bÈ\u0002\u0010Ë\u0001R\"\u0010Ì\u0002\u001a\u00030É\u00018\u0016@\u0016X\u0004¢\u0006\u0010\n\u0006\bÊ\u0002\u0010Ë\u0001\u001a\u0006\bË\u0002\u0010¥\u0002R\"\u0010Ï\u0002\u001a\u00030É\u00018\u0016@\u0016X\u0004¢\u0006\u0010\n\u0006\bÍ\u0002\u0010Ë\u0001\u001a\u0006\bÎ\u0002\u0010¥\u0002R\u001a\u0010Ñ\u0002\u001a\u00030\u00028\u0002@\u0002X\u000e¢\u0006\b\n\u0006\bÐ\u0002\u0010\u0002R\u001a\u0010Õ\u0002\u001a\u00030Ò\u00028\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bÓ\u0002\u0010Ô\u0002R\u001a\u0010Ù\u0002\u001a\u00030Ö\u00028\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b×\u0002\u0010Ø\u0002R\u001a\u0010Û\u0002\u001a\u00030ã\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bÚ\u0002\u0010å\u0001R\u001c\u0010Ý\u0002\u001a\u0005\u0018\u00010ã\u00018\u0002@\u0002X\u000e¢\u0006\b\n\u0006\bÜ\u0002\u0010å\u0001R\u001c\u0010à\u0002\u001a\u0005\u0018\u00010­\u00018\u0002@\u0002X\u000e¢\u0006\b\n\u0006\bÞ\u0002\u0010ß\u0002R\u001a\u0010ä\u0002\u001a\u00030á\u00028\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bâ\u0002\u0010ã\u0002R\u001a\u0010æ\u0002\u001a\u00030ã\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bå\u0002\u0010å\u0001R\u001a\u0010è\u0002\u001a\u00030ã\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bç\u0002\u0010å\u0001R\u001a\u0010ê\u0002\u001a\u00030ã\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bé\u0002\u0010å\u0001R\u001a\u0010ì\u0002\u001a\u00030É\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bë\u0002\u0010Ë\u0001R\u001a\u0010î\u0002\u001a\u00030í\u00018\u0002@\u0002X\u000e¢\u0006\b\n\u0006\bí\u0002\u0010ï\u0001R\u001a\u0010ð\u0002\u001a\u00030í\u00018\u0002@\u0002X\u000e¢\u0006\b\n\u0006\bï\u0002\u0010ï\u0001R\u001a\u0010ò\u0002\u001a\u00030ñ\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bñ\u0002\u0010ó\u0001R\u001c\u0010ô\u0002\u001a\u0005\u0018\u00010É\u00018\u0002@\u0002X\u000e¢\u0006\b\n\u0006\bó\u0002\u0010Ë\u0001R\u001a\u0010ø\u0002\u001a\u00030õ\u00028\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bö\u0002\u0010÷\u0002R\u001a\u0010ü\u0002\u001a\u00030ù\u00028\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bú\u0002\u0010û\u0002R\u001a\u0010\u0003\u001a\u00030ý\u00028\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bþ\u0002\u0010ÿ\u0002R\u001a\u0010\u0003\u001a\u00030í\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0003\u0010ï\u0001R\u001a\u0010\u0003\u001a\u00030É\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0003\u0010Ë\u0001R\u001a\u0010\u0003\u001a\u00030\u00038\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0003\u0010\u0003R\u001c\u0010\u0003\u001a\u0005\u0018\u00010ã\u00018\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0003\u0010å\u0001R\u001a\u0010\u0003\u001a\u00030ã\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0003\u0010å\u0001¨\u0006\u0003"}, d2 = {"Lcom/avito/android/user_advert/advert/MyAdvertDetailsViewImpl;", "Lcom/avito/android/user_advert/advert/MyAdvertDetailsView;", "Lcom/avito/android/user_advert/advert/AdvertActionsView;", "", AuthSource.BOOKING_ORDER, "()V", AuthSource.SEND_ABUSE, "", "Lcom/avito/android/util/ActionMenu;", "actions", "setUpToolbar", "(Ljava/util/List;)V", "", VKApiConst.POSITION, "setGalleryCurrentItem", "(I)V", "Lcom/avito/android/remote/model/Image;", "images", "Lcom/avito/android/remote/model/Video;", "video", "Lcom/avito/android/remote/model/ForegroundImage;", "infoImage", "bindGallery", "(Ljava/util/List;Lcom/avito/android/remote/model/Video;Lcom/avito/android/remote/model/ForegroundImage;)V", "Lio/reactivex/rxjava3/core/Observable;", "menuClicks", "()Lio/reactivex/rxjava3/core/Observable;", "upButtonClicks", "", "visible", "setDividerVisibility", "(Z)V", "showDeleteItemDialog", "showAddressCopied", "", "message", "Lkotlin/Function0;", "dismissListener", "showErrorDialog", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "dismissDialogForced", "title", "showToolbarTitle", "(Ljava/lang/String;)V", "price", "showPrice", "Lcom/avito/android/remote/model/badge/Badge;", "badge", "setPriceBadge", "(Lcom/avito/android/remote/model/badge/Badge;)V", MessengerShareContentUtility.SUBTITLE, "setPriceBadgeSubtitle", "hidePriceBadge", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "showPriceBadgeInfoIconWithListener", "(Lkotlin/jvm/functions/Function0;)V", "hidePriceBadgeInfoIconAndRemoveListener", "Lcom/avito/android/deep_linking/links/DetailsSheetLinkBody;", SDKConstants.PARAM_A2U_BODY, "Lcom/avito/android/analytics/provider/clickstream/ParametrizedClickStreamEvent;", "clickEvent", "showInfoBanner", "(Lcom/avito/android/deep_linking/links/DetailsSheetLinkBody;Lcom/avito/android/analytics/provider/clickstream/ParametrizedClickStreamEvent;)V", "showDiscount", "hideDiscount", "Lcom/avito/android/remote/model/text/AttributedText;", "discountText", "bindDiscountAttributedText", "(Lcom/avito/android/remote/model/text/AttributedText;)V", "Lcom/avito/android/remote/model/AdvertParameters$Parameter;", "params", "bindAdvertParameters", "Lcom/avito/android/remote/model/AdvertParameters$Group;", "groups", "bindAdvertGroups", "showLoadingProblem", "startLoading", "showContent", "showError", "showAppRater", "showAdvertRestoredMessage", "showActionMessage", "showSnackBar", "bindDiscountTitle", "description", "bindDiscountDescription", "colorAttr", "setDescriptionColor", "amount", "bindDiscountAmount", "descriptionExpands", "", "showDescription", "(Ljava/lang/CharSequence;)V", "hideDescription", "Lcom/avito/android/remote/model/user_adverts/UserOrderStatus;", "orderStatus", "Lkotlin/Function1;", "Lcom/avito/android/deep_linking/links/DeepLink;", "showOrderStatus", "(Lcom/avito/android/remote/model/user_adverts/UserOrderStatus;Lkotlin/jvm/functions/Function1;)V", "hideOrderStatus", BookingInfoActivity.EXTRA_ITEM_ID, "time", "showAdvertNumber", "(Ljava/lang/String;Ljava/lang/String;)V", "hideAdvertNumber", IntegrityManager.INTEGRITY_TYPE_ADDRESS, "showAddress", "Lcom/avito/android/remote/model/GeoReference;", "geoReferences", "showGeoReference", "addressClicks", "addressLongClicks", "showTitle", "hideMyStats", "stats", "showStats", "setStatsClickListener", "total", "today", FavoritesContract.TABLE_NAME, "Lcom/avito/android/remote/model/AdvertStatsContact;", "contacts", "showMyStats", "(IIILcom/avito/android/remote/model/AdvertStatsContact;)V", "showNewStatsTooltip", "showStatsPadding", "", "Lcom/avito/android/image_loader/Picture;", "servicesIcons", "clickListener", "showAppliedServices", "(Ljava/lang/String;Ljava/util/Map;Lkotlin/jvm/functions/Function0;)V", "Lcom/avito/android/remote/model/adverts/MyAdvertDetails$VasBundlesBanner;", "banner", "closeClickListener", "showVasBundlesBanner", "(Lcom/avito/android/remote/model/adverts/MyAdvertDetails$VasBundlesBanner;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "Lcom/avito/android/remote/model/adverts/MyAdvertDetails$AlertBanner;", "item", "showAlertBanner", "(Lcom/avito/android/remote/model/adverts/MyAdvertDetails$AlertBanner;Lkotlin/jvm/functions/Function0;)V", "Lcom/avito/android/remote/model/feature_teaser/SafeShow;", "safeShow", "bindSafeShow", "(Lcom/avito/android/remote/model/feature_teaser/SafeShow;)V", "isFirstIndex", "isLastIndex", "Lcom/avito/android/advert_core/feature_teasers/common/FeatureTeaserView;", "createFeatureTeaser", "(ZZ)Lcom/avito/android/advert_core/feature_teasers/common/FeatureTeaserView;", "itemId", "wasForeverDenied", "showPermissionForCallDialogIfNeeded", "(Ljava/lang/String;Z)V", "Lcom/avito/android/remote/model/LimitsInfo;", "info", "showLimitsInfoDialog", "(Lcom/avito/android/remote/model/LimitsInfo;)V", "picture", "setDiscountImage", "(Lcom/avito/android/image_loader/Picture;)V", "drawableRes", "setDiscountImageDrawable", "hideRejectReasons", "reasonsTitle", "Lcom/avito/android/remote/model/RejectReason;", "rejectReasons", "renderRejectReasons", "(Ljava/lang/String;Ljava/util/List;)V", "moderationInfo", "bindModerationInfo", "Lcom/avito/android/deep_linking/links/OnDeepLinkClickListener;", "setRejectionDeeplinkClickListener", "(Lcom/avito/android/deep_linking/links/OnDeepLinkClickListener;)V", "Lcom/avito/android/remote/model/AnonymousNumber;", "anonymousNumber", "showAnonymousNumber", "(Lcom/avito/android/remote/model/AnonymousNumber;)V", "Lcom/avito/android/remote/model/ContractInfo;", "contract", "showContractButton", "(Lcom/avito/android/remote/model/ContractInfo;)V", "hideContractButton", "Lcom/avito/android/user_advert/advert/verification/VerificationBlockItem;", "verification", "isOffer", "showVerification", "(Lcom/avito/android/user_advert/advert/verification/VerificationBlockItem;Z)V", "hideVerification", "text", "bindActionsHintText", "bindPrimaryAction", "bindSecondaryAction", "primaryActionClicks", "secondaryActionClicks", "isVisible", "setActionsVisibility", "setPrimaryActionVisibility", "setSecondaryActionVisibility", "Landroid/view/View;", "D", "Landroid/view/View;", "geoReferenceStub", "Lcom/avito/android/util/SimpleDraweeView;", "i", "Lcom/avito/android/util/SimpleDraweeView;", "discountIcon", "Landroid/widget/ImageView;", VKApiConst.VERSION, "Landroid/widget/ImageView;", "priceBadgeIcon", "Lru/avito/component/statistics/StatisticsView;", "J", "Lru/avito/component/statistics/StatisticsView;", "statsMyView", "Lcom/avito/android/advert_core/georeference/GeoReferenceViewWrapper;", "U", "Lkotlin/Lazy;", "getGeoReferenceViewWrapper", "()Lcom/avito/android/advert_core/georeference/GeoReferenceViewWrapper;", "geoReferenceViewWrapper", "Lcom/avito/android/user_advert/advert/MyAdvertDetailsViewPresenter;", "d0", "Lcom/avito/android/user_advert/advert/MyAdvertDetailsViewPresenter;", "presenter", "Landroid/widget/TextView;", "H", "Landroid/widget/TextView;", "safeShowTeaser", "n", "discountAttributedTextView", "Lcom/avito/android/util/ImplicitIntentFactory;", "g0", "Lcom/avito/android/util/ImplicitIntentFactory;", "implicitIntentFactory", "Landroid/view/ViewGroup;", ExifInterface.LATITUDE_SOUTH, "Landroid/view/ViewGroup;", "verificationStatusViewContainer", "Landroid/widget/LinearLayout;", "O", "Landroid/widget/LinearLayout;", "rejectReasonsContainer", "Lcom/avito/android/util/DialogRouter;", "e0", "Lcom/avito/android/util/DialogRouter;", "dialogRouter", "h", "discountView", "f", "galleryStub", "Lcom/avito/android/design/widget/ExpandablePanel;", VKApiConst.Q, "Lcom/avito/android/design/widget/ExpandablePanel;", "descriptionPanel", "s", "priceBadge", "Lcom/avito/android/permissions/PermissionHelper;", "k0", "Lcom/avito/android/permissions/PermissionHelper;", "permissionHelper", "Lcom/avito/android/analytics/Analytics;", "h0", "Lcom/avito/android/analytics/Analytics;", "analytics", "Landroidx/viewpager/widget/ViewPager;", a2.g.r.g.a, "Landroidx/viewpager/widget/ViewPager;", "galleryPager", "k", "discountAmount", "Landroid/view/ViewStub;", "K", "Landroid/view/ViewStub;", "appliedServicesViewStub", "Lcom/avito/android/advert_core/safe_show/SafeShowDialogFactory;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lcom/avito/android/advert_core/safe_show/SafeShowDialogFactory;", "safeShowFactory", "Landroid/app/Dialog;", "X", "Landroid/app/Dialog;", "dialog", "Lcom/avito/android/lib/design/button/Button;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/avito/android/lib/design/button/Button;", "orderStatusView", "L", "appliedServicesView", "a0", "getCarMarketPriceDescriptionView", "()Landroid/view/View;", "carMarketPriceDescriptionView", "Lcom/avito/android/user_advert/advert/verification/VerificationBlockView;", "T", "Lcom/avito/android/user_advert/advert/verification/VerificationBlockView;", "verificationBlockView", "Lcom/avito/android/lib/design/alert_banner/AlertBanner;", "N", "Lcom/avito/android/lib/design/alert_banner/AlertBanner;", "alertBanner", "x", "advertNumberStub", "t", "priceBadgeTitle", "Landroid/content/res/Resources;", "kotlin.jvm.PlatformType", "Landroid/content/res/Resources;", "resources", "Landroid/content/Context;", "Landroid/content/Context;", "context", "Lcom/avito/android/lib/design/banner/Banner;", "M", "Lcom/avito/android/lib/design/banner/Banner;", "vasBundlesBanner", "Lcom/avito/android/ActivityIntentFactory;", "j0", "Lcom/avito/android/ActivityIntentFactory;", "activityIntentFactory", ExifInterface.LONGITUDE_EAST, "addressText", "w", "advertNumber", "R", "verificationOfferViewContainer", "y", "addressContainer", "Y", "getCarMarketPriceBadgeView", "carMarketPriceBadgeView", "Z", "getCarMarketPriceChartView", "carMarketPriceChartView", "B", "orderStatusLink", "Lcom/avito/android/progress_overlay/ProgressOverlay;", "d", "Lcom/avito/android/progress_overlay/ProgressOverlay;", "progressOverlay", "Landroidx/appcompat/widget/Toolbar;", "p", "Landroidx/appcompat/widget/Toolbar;", "toolbar", "F", "titleView", "l", "discountTitle", ExifInterface.LONGITUDE_WEST, "Lcom/avito/android/deep_linking/links/OnDeepLinkClickListener;", "rejectionDeeplinkListener", "Lcom/avito/android/user_advert/advert/feature_teasers/MyAdvertDetailsFeatureTeaserViewFactory;", "i0", "Lcom/avito/android/user_advert/advert/feature_teasers/MyAdvertDetailsFeatureTeaserViewFactory;", "featureTeaserViewFactory", "r", "priceView", "u", "priceBadgeSubtitle", "G", "statsView", "b0", "rootView", "z", "orderStatusContainer", "C", "geoReferenceContainer", "I", "featuresTeasersContainer", "j", "discountAmountContainer", "Lcom/avito/android/user_advert/advert/ContractButtonView;", "Q", "Lcom/avito/android/user_advert/advert/ContractButtonView;", "contractButtonView", "Lcom/avito/android/util/text/AttributedTextFormatter;", "f0", "Lcom/avito/android/util/text/AttributedTextFormatter;", "attributedTextFormatter", "Landroidx/fragment/app/FragmentManager;", "c0", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "c", "contentFrame", "o", "divider", "Lcom/avito/android/photo_gallery/ui/PhotoGallery;", "e", "Lcom/avito/android/photo_gallery/ui/PhotoGallery;", "gallery", AuthSource.OPEN_CHANNEL_LIST, "discountDescription", "P", "moderationInfoView", "<init>", "(Landroid/view/View;Landroidx/fragment/app/FragmentManager;Lcom/avito/android/user_advert/advert/MyAdvertDetailsViewPresenter;Lcom/avito/android/util/DialogRouter;Lcom/avito/android/util/text/AttributedTextFormatter;Lcom/avito/android/util/ImplicitIntentFactory;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/user_advert/advert/feature_teasers/MyAdvertDetailsFeatureTeaserViewFactory;Lcom/avito/android/ActivityIntentFactory;Lcom/avito/android/permissions/PermissionHelper;)V", "user-advert_release"}, k = 1, mv = {1, 4, 2})
public final class MyAdvertDetailsViewImpl implements MyAdvertDetailsView, AdvertActionsView {
    public Button A;
    public Button B;
    public ViewGroup C;
    public View D;
    public TextView E;
    public final TextView F;
    public final TextView G;
    public final TextView H;
    public final LinearLayout I;
    public final StatisticsView J;
    public ViewStub K;
    public View L;
    public Banner M;
    public final AlertBanner N;
    public final LinearLayout O;
    public final TextView P;
    public final ContractButtonView Q;
    public final ViewGroup R;
    public final ViewGroup S;
    public VerificationBlockView T;
    public final Lazy U = t6.c.lazy(new g(this));
    public SafeShowDialogFactory V = new SafeShowDialogFactory(this.b.getBoolean(R.bool.is_tablet));
    public OnDeepLinkClickListener W;
    public Dialog X;
    @NotNull
    public final View Y;
    @NotNull
    public final View Z;
    public final Context a;
    @NotNull
    public final View a0;
    public final Resources b;
    public final View b0;
    public final ViewGroup c;
    public final FragmentManager c0;
    public final ProgressOverlay d;
    public final MyAdvertDetailsViewPresenter d0;
    public final PhotoGallery e;
    public final DialogRouter e0;
    public final View f;
    public final AttributedTextFormatter f0;
    public final ViewPager g;
    public final ImplicitIntentFactory g0;
    public View h;
    public final Analytics h0;
    public SimpleDraweeView i;
    public final MyAdvertDetailsFeatureTeaserViewFactory i0;
    public View j;
    public final ActivityIntentFactory j0;
    public TextView k;
    public final PermissionHelper k0;
    public TextView l;
    public final /* synthetic */ AdvertActionsViewImpl l0;
    public TextView m;
    public TextView n;
    public final View o;
    public final Toolbar p;
    public final ExpandablePanel q;
    public final TextView r;
    public final ViewGroup s;
    public final TextView t;
    public final TextView u;
    public final ImageView v;
    public final TextView w;
    public final View x;
    public View y;
    public ViewGroup z;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            UserOrderStatus.Type.values();
            int[] iArr = new int[4];
            $EnumSwitchMapping$0 = iArr;
            UserOrderStatus.Type type = UserOrderStatus.Type.DONE;
            iArr[1] = 1;
            UserOrderStatus.Type type2 = UserOrderStatus.Type.WARNING;
            iArr[2] = 2;
            UserOrderStatus.Type type3 = UserOrderStatus.Type.ERROR;
            iArr[3] = 3;
            MyAdvertDetails.Style.values();
            int[] iArr2 = new int[3];
            $EnumSwitchMapping$1 = iArr2;
            MyAdvertDetails.Style style = MyAdvertDetails.Style.SUCCESS;
            iArr2[0] = 1;
            MyAdvertDetails.Style style2 = MyAdvertDetails.Style.NORMAL;
            iArr2[1] = 2;
            MyAdvertDetails.Style style3 = MyAdvertDetails.Style.WARNING;
            iArr2[2] = 3;
        }
    }

    /* compiled from: java-style lambda group */
    public static final class a implements View.OnClickListener {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;
        public final /* synthetic */ Object c;
        public final /* synthetic */ Object d;

        public a(int i, Object obj, Object obj2, Object obj3) {
            this.a = i;
            this.b = obj;
            this.c = obj2;
            this.d = obj3;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            int i = this.a;
            if (i == 0) {
                ((Function1) this.d).invoke(((UserOrderStatus.Link) this.b).getDeepLink());
            } else if (i == 1) {
                ((Function1) this.d).invoke(((UserOrderStatus.Link) this.b).getDeepLink());
            } else {
                throw null;
            }
        }
    }

    public static final class b extends Lambda implements Function0<Unit> {
        public final /* synthetic */ MyAdvertDetailsViewImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(MyAdvertDetailsViewImpl myAdvertDetailsViewImpl) {
            super(0);
            this.a = myAdvertDetailsViewImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.d0.onRefresh();
            return Unit.INSTANCE;
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ MyAdvertDetailsViewImpl a;

        public c(MyAdvertDetailsViewImpl myAdvertDetailsViewImpl) {
            this.a = myAdvertDetailsViewImpl;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (this.a.e.canShowFullscreen(this.a.e.getCurrentItem())) {
                this.a.d0.onGalleryFullScreenClicked(this.a.g.getCurrentItem());
                return;
            }
            Context context = this.a.a;
            Intrinsics.checkNotNullExpressionValue(context, "context");
            ToastsKt.showToast$default(context, com.avito.android.user_advert.R.string.network_unavailable_message, 0, 2, (Object) null);
        }
    }

    public static final class d implements Runnable {
        public final /* synthetic */ MyAdvertDetailsViewImpl a;
        public final /* synthetic */ List b;

        public d(MyAdvertDetailsViewImpl myAdvertDetailsViewImpl, List list) {
            this.a = myAdvertDetailsViewImpl;
            this.b = list;
        }

        @Override // java.lang.Runnable
        public final void run() {
            new AdvertDetailsGroupViewImpl(this.a.b0, null, false).bind(this.b);
        }
    }

    public static final class e implements Runnable {
        public final /* synthetic */ MyAdvertDetailsViewImpl a;
        public final /* synthetic */ List b;

        public e(MyAdvertDetailsViewImpl myAdvertDetailsViewImpl, List list) {
            this.a = myAdvertDetailsViewImpl;
            this.b = list;
        }

        @Override // java.lang.Runnable
        public final void run() {
            new AdvertDetailsFlatViewImpl(this.a.b0, null, null, false, false, 16, null).bind(this.b);
        }
    }

    public static final class f implements View.OnClickListener {
        public final /* synthetic */ MyAdvertDetailsViewImpl a;
        public final /* synthetic */ SafeShow b;

        public f(MyAdvertDetailsViewImpl myAdvertDetailsViewImpl, SafeShow safeShow) {
            this.a = myAdvertDetailsViewImpl;
            this.b = safeShow;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            SafeShowDialogFactory safeShowDialogFactory = this.a.V;
            Context context = this.a.a;
            Intrinsics.checkNotNullExpressionValue(context, "context");
            safeShowDialogFactory.show(context, this.b.getBottomSheetInfo().getTitle(), this.b.getBottomSheetInfo().getText());
        }
    }

    public static final class g extends Lambda implements Function0<GeoReferenceViewWrapperImpl> {
        public final /* synthetic */ MyAdvertDetailsViewImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(MyAdvertDetailsViewImpl myAdvertDetailsViewImpl) {
            super(0);
            this.a = myAdvertDetailsViewImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public GeoReferenceViewWrapperImpl invoke() {
            return new GeoReferenceViewWrapperImpl(this.a.C);
        }
    }

    public static final class h<T> implements ObservableOnSubscribe<Integer> {
        public final /* synthetic */ MyAdvertDetailsViewImpl a;

        public static final class a implements Cancellable {
            public final /* synthetic */ h a;

            public a(h hVar) {
                this.a = hVar;
            }

            @Override // io.reactivex.rxjava3.functions.Cancellable
            public final void cancel() {
                this.a.a.p.setOnMenuItemClickListener(null);
            }
        }

        public static final class b implements Toolbar.OnMenuItemClickListener {
            public final /* synthetic */ ObservableEmitter a;

            public b(ObservableEmitter observableEmitter) {
                this.a = observableEmitter;
            }

            /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: io.reactivex.rxjava3.core.ObservableEmitter */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // androidx.appcompat.widget.Toolbar.OnMenuItemClickListener
            public final boolean onMenuItemClick(MenuItem menuItem) {
                ObservableEmitter observableEmitter = this.a;
                Intrinsics.checkNotNullExpressionValue(menuItem, "menu");
                observableEmitter.onNext(Integer.valueOf(menuItem.getItemId()));
                return true;
            }
        }

        public h(MyAdvertDetailsViewImpl myAdvertDetailsViewImpl) {
            this.a = myAdvertDetailsViewImpl;
        }

        @Override // io.reactivex.rxjava3.core.ObservableOnSubscribe
        public final void subscribe(ObservableEmitter<Integer> observableEmitter) {
            observableEmitter.setCancellable(new a(this));
            this.a.p.setOnMenuItemClickListener(new b(observableEmitter));
        }
    }

    public static final class i implements View.OnClickListener {
        public final /* synthetic */ Function0 a;

        public i(Function0 function0) {
            this.a = function0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.invoke();
        }
    }

    public static final class j implements View.OnClickListener {
        public final /* synthetic */ Map a;
        public final /* synthetic */ Function0 b;

        public j(String str, Map map, Function0 function0) {
            this.a = map;
            this.b = function0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.b.invoke();
        }
    }

    public static final class k implements Runnable {
        public final /* synthetic */ MyAdvertDetailsViewImpl a;

        public k(MyAdvertDetailsViewImpl myAdvertDetailsViewImpl) {
            this.a = myAdvertDetailsViewImpl;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.d.showContent();
        }
    }

    public static final class l extends Lambda implements Function0<Unit> {
        public final /* synthetic */ MyAdvertDetailsViewImpl a;
        public final /* synthetic */ ContractInfo b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public l(MyAdvertDetailsViewImpl myAdvertDetailsViewImpl, ContractInfo contractInfo) {
            super(0);
            this.a = myAdvertDetailsViewImpl;
            this.b = contractInfo;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.d0.onContractButtonClicked(this.b.getUrl());
            return Unit.INSTANCE;
        }
    }

    public static final class m<T> implements ObservableOnSubscribe<Unit> {
        public final /* synthetic */ MyAdvertDetailsViewImpl a;

        public static final class a implements DialogInterface.OnDismissListener {
            public final /* synthetic */ ObservableEmitter a;

            public a(ObservableEmitter observableEmitter) {
                this.a = observableEmitter;
            }

            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                this.a.onComplete();
            }
        }

        public static final class b extends Lambda implements Function0<Unit> {
            public final /* synthetic */ m a;
            public final /* synthetic */ ObservableEmitter b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public b(m mVar, ObservableEmitter observableEmitter) {
                super(0);
                this.a = mVar;
                this.b = observableEmitter;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function0
            public Unit invoke() {
                Dialog dialog = this.a.a.X;
                if (dialog != null) {
                    dialog.dismiss();
                }
                this.b.onComplete();
                return Unit.INSTANCE;
            }
        }

        public static final class c extends Lambda implements Function0<Unit> {
            public final /* synthetic */ ObservableEmitter a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public c(ObservableEmitter observableEmitter) {
                super(0);
                this.a = observableEmitter;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: io.reactivex.rxjava3.core.ObservableEmitter */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function0
            public Unit invoke() {
                ObservableEmitter observableEmitter = this.a;
                Unit unit = Unit.INSTANCE;
                observableEmitter.onNext(unit);
                return unit;
            }
        }

        public static final class d implements Cancellable {
            public final /* synthetic */ Dialog a;

            public d(Dialog dialog) {
                this.a = dialog;
            }

            @Override // io.reactivex.rxjava3.functions.Cancellable
            public final void cancel() {
                this.a.dismiss();
            }
        }

        public m(MyAdvertDetailsViewImpl myAdvertDetailsViewImpl) {
            this.a = myAdvertDetailsViewImpl;
        }

        @Override // io.reactivex.rxjava3.core.ObservableOnSubscribe
        public final void subscribe(ObservableEmitter<Unit> observableEmitter) {
            String string = this.a.a.getString(com.avito.android.user_advert.R.string.advert_will_be_deleted);
            Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.string.advert_will_be_deleted)");
            MyAdvertDetailsViewImpl myAdvertDetailsViewImpl = this.a;
            DialogRouter dialogRouter = myAdvertDetailsViewImpl.e0;
            String string2 = this.a.a.getString(R.string.cancel);
            Intrinsics.checkNotNullExpressionValue(string2, "context.getString(ui_R.string.cancel)");
            b bVar = new b(this, observableEmitter);
            String string3 = this.a.a.getString(R.string.ok);
            Intrinsics.checkNotNullExpressionValue(string3, "context.getString(ui_R.string.ok)");
            myAdvertDetailsViewImpl.X = dialogRouter.showCancelableNotifyingDialog(null, false, string, string2, bVar, string3, new c(observableEmitter));
            Dialog dialog = this.a.X;
            if (dialog != null) {
                dialog.setOnDismissListener(new a(observableEmitter));
                observableEmitter.setCancellable(new d(dialog));
            }
        }
    }

    public static final class n extends Lambda implements Function2<Dialog.Config, DialogInterface, Unit> {
        public final /* synthetic */ PublishLimitsInfoView a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public n(PublishLimitsInfoView publishLimitsInfoView) {
            super(2);
            this.a = publishLimitsInfoView;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public Unit invoke(Dialog.Config config, DialogInterface dialogInterface) {
            Dialog.Config config2 = config;
            DialogInterface dialogInterface2 = dialogInterface;
            Intrinsics.checkNotNullParameter(config2, "$receiver");
            Intrinsics.checkNotNullParameter(dialogInterface2, "dialog");
            config2.setTitle(com.avito.android.user_advert.R.string.advert_limits_info_dialog_title);
            config2.setSubtitle(com.avito.android.user_advert.R.string.advert_limits_info_dialog_description);
            config2.setCustomView(this.a);
            config2.addSecondaryButton(com.avito.android.user_advert.R.string.advert_limits_info_dialog_btn_ok, new b1(dialogInterface2));
            return Unit.INSTANCE;
        }
    }

    public static final class o extends Lambda implements Function2<Dialog.Config, DialogInterface, Unit> {
        public final /* synthetic */ MyAdvertDetailsViewImpl a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ String c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public o(MyAdvertDetailsViewImpl myAdvertDetailsViewImpl, boolean z, String str) {
            super(2);
            this.a = myAdvertDetailsViewImpl;
            this.b = z;
            this.c = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public Unit invoke(Dialog.Config config, DialogInterface dialogInterface) {
            Dialog.Config config2 = config;
            DialogInterface dialogInterface2 = dialogInterface;
            Intrinsics.checkNotNullParameter(config2, "$receiver");
            Intrinsics.checkNotNullParameter(dialogInterface2, "dialog");
            config2.setImage(ContextCompat.getDrawable(this.a.a, com.avito.android.user_advert.R.drawable.ic_call_permission));
            config2.setTitle(com.avito.android.user_advert.R.string.advert_call_permission_dialog_title);
            config2.setSubtitle(com.avito.android.user_advert.R.string.advert_call_permission_dialog_body);
            config2.setButtonsOrientation(1);
            if (this.b) {
                config2.addPrimaryButton(com.avito.android.user_advert.R.string.advert_call_permission_dialog_btn_to_settings, new n5(0, this, dialogInterface2));
            } else {
                config2.addPrimaryButton(com.avito.android.user_advert.R.string.advert_call_permission_dialog_btn_grant, new n5(1, this, dialogInterface2));
            }
            config2.addSecondaryButton(com.avito.android.user_advert.R.string.advert_call_permission_dialog_btn_deny, new e1(dialogInterface2));
            return Unit.INSTANCE;
        }
    }

    public static final class p implements View.OnClickListener {
        public final /* synthetic */ Function0 a;

        public p(Function0 function0) {
            this.a = function0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.invoke();
        }
    }

    public static final class q implements View.OnClickListener {
        public final /* synthetic */ Function0 a;

        public q(Function0 function0) {
            this.a = function0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.invoke();
        }
    }

    public static final class r<T> implements ObservableOnSubscribe<Unit> {
        public final /* synthetic */ MyAdvertDetailsViewImpl a;

        public static final class a implements Cancellable {
            public final /* synthetic */ r a;

            public a(r rVar) {
                this.a = rVar;
            }

            @Override // io.reactivex.rxjava3.functions.Cancellable
            public final void cancel() {
                this.a.a.p.setNavigationOnClickListener(null);
            }
        }

        public static final class b implements View.OnClickListener {
            public final /* synthetic */ ObservableEmitter a;

            public b(ObservableEmitter observableEmitter) {
                this.a = observableEmitter;
            }

            /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: io.reactivex.rxjava3.core.ObservableEmitter */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.onNext(Unit.INSTANCE);
            }
        }

        public r(MyAdvertDetailsViewImpl myAdvertDetailsViewImpl) {
            this.a = myAdvertDetailsViewImpl;
        }

        @Override // io.reactivex.rxjava3.core.ObservableOnSubscribe
        public final void subscribe(ObservableEmitter<Unit> observableEmitter) {
            observableEmitter.setCancellable(new a(this));
            this.a.p.setNavigationOnClickListener(new b(observableEmitter));
        }
    }

    public MyAdvertDetailsViewImpl(@NotNull View view, @NotNull FragmentManager fragmentManager, @NotNull MyAdvertDetailsViewPresenter myAdvertDetailsViewPresenter, @NotNull DialogRouter dialogRouter, @NotNull AttributedTextFormatter attributedTextFormatter, @NotNull ImplicitIntentFactory implicitIntentFactory, @NotNull Analytics analytics, @NotNull MyAdvertDetailsFeatureTeaserViewFactory myAdvertDetailsFeatureTeaserViewFactory, @NotNull ActivityIntentFactory activityIntentFactory, @NotNull PermissionHelper permissionHelper) {
        Intrinsics.checkNotNullParameter(view, "rootView");
        Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
        Intrinsics.checkNotNullParameter(myAdvertDetailsViewPresenter, "presenter");
        Intrinsics.checkNotNullParameter(dialogRouter, "dialogRouter");
        Intrinsics.checkNotNullParameter(attributedTextFormatter, "attributedTextFormatter");
        Intrinsics.checkNotNullParameter(implicitIntentFactory, "implicitIntentFactory");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(myAdvertDetailsFeatureTeaserViewFactory, "featureTeaserViewFactory");
        Intrinsics.checkNotNullParameter(activityIntentFactory, "activityIntentFactory");
        Intrinsics.checkNotNullParameter(permissionHelper, "permissionHelper");
        View findViewById = view.findViewById(com.avito.android.user_advert.R.id.advert_actions);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.view.View");
        this.l0 = new AdvertActionsViewImpl(findViewById);
        this.b0 = view;
        this.c0 = fragmentManager;
        this.d0 = myAdvertDetailsViewPresenter;
        this.e0 = dialogRouter;
        this.f0 = attributedTextFormatter;
        this.g0 = implicitIntentFactory;
        this.h0 = analytics;
        this.i0 = myAdvertDetailsFeatureTeaserViewFactory;
        this.j0 = activityIntentFactory;
        this.k0 = permissionHelper;
        Context context = view.getContext();
        this.a = context;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        this.b = context.getResources();
        View findViewById2 = view.findViewById(com.avito.android.user_advert.R.id.advert_details_content_frame);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup = (ViewGroup) findViewById2;
        this.c = viewGroup;
        this.d = new ProgressOverlay(viewGroup, com.avito.android.user_advert.R.id.advert_details_content, analytics, false, 0, 24, null);
        View findViewById3 = view.findViewById(com.avito.android.photo_gallery.R.id.gallery_holder);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type com.avito.android.photo_gallery.ui.PhotoGallery");
        PhotoGallery photoGallery = (PhotoGallery) findViewById3;
        this.e = photoGallery;
        View findViewById4 = view.findViewById(com.avito.android.user_advert.R.id.photo_gallery_stub);
        Objects.requireNonNull(findViewById4, "null cannot be cast to non-null type android.view.View");
        this.f = findViewById4;
        this.g = photoGallery.getPager();
        this.n = (TextView) view.findViewById(com.avito.android.user_advert.R.id.discount_description_view);
        View findViewById5 = view.findViewById(com.avito.android.user_advert.R.id.divider_container);
        Objects.requireNonNull(findViewById5, "null cannot be cast to non-null type android.view.View");
        this.o = findViewById5;
        View findViewById6 = view.findViewById(com.avito.android.deprecated_design.R.id.toolbar);
        Objects.requireNonNull(findViewById6, "null cannot be cast to non-null type androidx.appcompat.widget.Toolbar");
        this.p = (Toolbar) findViewById6;
        View findViewById7 = view.findViewById(com.avito.android.advert_core.R.id.description_layout);
        Objects.requireNonNull(findViewById7, "null cannot be cast to non-null type com.avito.android.design.widget.ExpandablePanel");
        this.q = (ExpandablePanel) findViewById7;
        View findViewById8 = view.findViewById(com.avito.android.user_advert.R.id.advert_price);
        Objects.requireNonNull(findViewById8, "null cannot be cast to non-null type android.widget.TextView");
        this.r = (TextView) findViewById8;
        View findViewById9 = view.findViewById(com.avito.android.user_advert.R.id.price_badge);
        Objects.requireNonNull(findViewById9, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup2 = (ViewGroup) findViewById9;
        this.s = viewGroup2;
        View findViewById10 = viewGroup2.findViewById(com.avito.android.user_advert.R.id.price_badge_title);
        Objects.requireNonNull(findViewById10, "null cannot be cast to non-null type android.widget.TextView");
        this.t = (TextView) findViewById10;
        View findViewById11 = viewGroup2.findViewById(com.avito.android.user_advert.R.id.price_badge_subtitle);
        Objects.requireNonNull(findViewById11, "null cannot be cast to non-null type android.widget.TextView");
        this.u = (TextView) findViewById11;
        View findViewById12 = viewGroup2.findViewById(com.avito.android.user_advert.R.id.price_badge_icon);
        Objects.requireNonNull(findViewById12, "null cannot be cast to non-null type android.widget.ImageView");
        this.v = (ImageView) findViewById12;
        View findViewById13 = view.findViewById(com.avito.android.user_advert.R.id.advert_number);
        Objects.requireNonNull(findViewById13, "null cannot be cast to non-null type android.widget.TextView");
        this.w = (TextView) findViewById13;
        View findViewById14 = view.findViewById(com.avito.android.user_advert.R.id.advert_number_stub);
        Objects.requireNonNull(findViewById14, "null cannot be cast to non-null type android.view.View");
        this.x = findViewById14;
        this.y = view.findViewById(com.avito.android.advert_core.R.id.address_container);
        View findViewById15 = view.findViewById(com.avito.android.user_advert.R.id.order_status_container);
        Intrinsics.checkNotNullExpressionValue(findViewById15, "rootView.findViewById(R.id.order_status_container)");
        this.z = (ViewGroup) findViewById15;
        View findViewById16 = view.findViewById(com.avito.android.user_advert.R.id.order_status);
        Intrinsics.checkNotNullExpressionValue(findViewById16, "rootView.findViewById(R.id.order_status)");
        this.A = (Button) findViewById16;
        View findViewById17 = view.findViewById(com.avito.android.user_advert.R.id.order_status_link);
        Intrinsics.checkNotNullExpressionValue(findViewById17, "rootView.findViewById(R.id.order_status_link)");
        this.B = (Button) findViewById17;
        View findViewById18 = view.findViewById(com.avito.android.user_advert.R.id.geo_reference_container);
        Intrinsics.checkNotNullExpressionValue(findViewById18, "rootView.findViewById(R.….geo_reference_container)");
        this.C = (ViewGroup) findViewById18;
        View findViewById19 = view.findViewById(com.avito.android.user_advert.R.id.geo_reference_stub);
        Intrinsics.checkNotNullExpressionValue(findViewById19, "rootView.findViewById(R.id.geo_reference_stub)");
        this.D = findViewById19;
        this.E = (TextView) view.findViewById(com.avito.android.advert_core.R.id.advert_address);
        View findViewById20 = this.b0.findViewById(com.avito.android.user_advert.R.id.advert_title);
        Objects.requireNonNull(findViewById20, "null cannot be cast to non-null type android.widget.TextView");
        this.F = (TextView) findViewById20;
        View findViewById21 = this.b0.findViewById(com.avito.android.user_advert.R.id.advert_stats);
        Objects.requireNonNull(findViewById21, "null cannot be cast to non-null type android.widget.TextView");
        this.G = (TextView) findViewById21;
        View findViewById22 = this.b0.findViewById(com.avito.android.user_advert.R.id.safe_show_teaser);
        Objects.requireNonNull(findViewById22, "null cannot be cast to non-null type android.widget.TextView");
        this.H = (TextView) findViewById22;
        View findViewById23 = this.b0.findViewById(com.avito.android.user_advert.R.id.features_container);
        Objects.requireNonNull(findViewById23, "null cannot be cast to non-null type android.widget.LinearLayout");
        this.I = (LinearLayout) findViewById23;
        View findViewById24 = this.b0.findViewById(com.avito.android.user_advert.R.id.statistics);
        Intrinsics.checkNotNullExpressionValue(findViewById24, "rootView.findViewById(R.id.statistics)");
        this.J = (StatisticsView) findViewById24;
        View findViewById25 = this.b0.findViewById(com.avito.android.user_advert.R.id.applied_services_stub);
        Intrinsics.checkNotNullExpressionValue(findViewById25, "rootView.findViewById(R.id.applied_services_stub)");
        this.K = (ViewStub) findViewById25;
        View findViewById26 = this.b0.findViewById(com.avito.android.user_advert.R.id.vas_bundles_banner);
        Intrinsics.checkNotNullExpressionValue(findViewById26, "rootView.findViewById(R.id.vas_bundles_banner)");
        this.M = (Banner) findViewById26;
        View findViewById27 = this.b0.findViewById(com.avito.android.user_advert.R.id.alert_banner);
        Intrinsics.checkNotNullExpressionValue(findViewById27, "rootView.findViewById(R.id.alert_banner)");
        this.N = (AlertBanner) findViewById27;
        View findViewById28 = this.b0.findViewById(com.avito.android.user_advert.R.id.reject_reason_container);
        Objects.requireNonNull(findViewById28, "null cannot be cast to non-null type android.widget.LinearLayout");
        this.O = (LinearLayout) findViewById28;
        View findViewById29 = this.b0.findViewById(com.avito.android.user_advert.R.id.moderation_info);
        Intrinsics.checkNotNullExpressionValue(findViewById29, "rootView.findViewById(R.id.moderation_info)");
        this.P = (TextView) findViewById29;
        View findViewById30 = this.b0.findViewById(com.avito.android.advert_core.R.id.contract_container);
        Objects.requireNonNull(findViewById30, "null cannot be cast to non-null type android.view.View");
        this.Q = new ContractButtonViewImpl(findViewById30);
        View findViewById31 = this.b0.findViewById(com.avito.android.advert_core.R.id.verification_offer);
        Objects.requireNonNull(findViewById31, "null cannot be cast to non-null type android.view.ViewGroup");
        this.R = (ViewGroup) findViewById31;
        View findViewById32 = this.b0.findViewById(com.avito.android.advert_core.R.id.verification_status);
        Objects.requireNonNull(findViewById32, "null cannot be cast to non-null type android.view.ViewGroup");
        this.S = (ViewGroup) findViewById32;
        View findViewById33 = this.b0.findViewById(com.avito.android.user_advert.R.id.car_market_price_badge_container);
        Objects.requireNonNull(findViewById33, "null cannot be cast to non-null type android.view.View");
        this.Y = findViewById33;
        View findViewById34 = this.b0.findViewById(com.avito.android.user_advert.R.id.car_market_price_chart_container);
        Objects.requireNonNull(findViewById34, "null cannot be cast to non-null type android.view.View");
        this.Z = findViewById34;
        View findViewById35 = this.b0.findViewById(com.avito.android.user_advert.R.id.car_market_price_description_container);
        Objects.requireNonNull(findViewById35, "null cannot be cast to non-null type android.view.View");
        this.a0 = findViewById35;
        this.d.setOnRefreshListener(new b(this));
        this.g.setOnClickListener(new c(this));
    }

    public final void a() {
        b();
        if (this.k == null) {
            ViewStub viewStub = (ViewStub) this.b0.findViewById(com.avito.android.advert_core.R.id.discount_amount_stub);
            if (viewStub != null) {
                viewStub.inflate();
            }
            View findViewById = this.b0.findViewById(R.id.discount_icon);
            Objects.requireNonNull(findViewById, "null cannot be cast to non-null type com.avito.android.util.SimpleDraweeView");
            this.i = (SimpleDraweeView) findViewById;
            View findViewById2 = this.b0.findViewById(R.id.discount_amount_container);
            Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.view.View");
            this.j = findViewById2;
            View findViewById3 = this.b0.findViewById(R.id.discount_amount);
            Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type android.widget.TextView");
            this.k = (TextView) findViewById3;
        }
    }

    @Override // com.avito.android.user_advert.advert.MyAdvertDetailsView
    @NotNull
    public Observable<Unit> addressClicks() {
        io.reactivex.Observable<Unit> clicks;
        Observable<Unit> v3;
        View view = this.y;
        if (view != null && (clicks = RxView.clicks(view)) != null && (v3 = InteropKt.toV3(clicks)) != null) {
            return v3;
        }
        Observable<Unit> empty = Observable.empty();
        Intrinsics.checkNotNullExpressionValue(empty, "Observable.empty()");
        return empty;
    }

    @Override // com.avito.android.user_advert.advert.MyAdvertDetailsView
    @NotNull
    public Observable<Unit> addressLongClicks() {
        io.reactivex.Observable longClicks$default;
        Observable<Unit> v3;
        View view = this.y;
        if (view != null && (longClicks$default = RxView.longClicks$default(view, null, 1, null)) != null && (v3 = InteropKt.toV3(longClicks$default)) != null) {
            return v3;
        }
        Observable<Unit> empty = Observable.empty();
        Intrinsics.checkNotNullExpressionValue(empty, "Observable.empty()");
        return empty;
    }

    public final void b() {
        if (this.h == null) {
            ViewStub viewStub = (ViewStub) this.b0.findViewById(com.avito.android.user_advert.R.id.discount_view_stub);
            if (viewStub != null) {
                viewStub.inflate();
            }
            View findViewById = this.b0.findViewById(com.avito.android.advert_core.R.id.discount_root_view);
            Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.view.View");
            this.h = findViewById;
            View findViewById2 = this.b0.findViewById(com.avito.android.advert_core.R.id.discount_title);
            Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
            this.l = (TextView) findViewById2;
            View findViewById3 = this.b0.findViewById(com.avito.android.advert_core.R.id.discount_description);
            Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type android.widget.TextView");
            this.m = (TextView) findViewById3;
        }
    }

    @Override // com.avito.android.user_advert.advert.AdvertActionsView
    public void bindActionsHintText(@Nullable String str) {
        this.l0.bindActionsHintText(str);
    }

    @Override // com.avito.android.user_advert.advert.MyAdvertDetailsView
    public void bindAdvertGroups(@Nullable List<AdvertParameters.Group> list) {
        this.b0.post(new d(this, list));
    }

    @Override // com.avito.android.user_advert.advert.MyAdvertDetailsView
    public void bindAdvertParameters(@Nullable List<AdvertParameters.Parameter> list) {
        this.b0.post(new e(this, list));
    }

    @Override // com.avito.android.user_advert.advert.MyAdvertDetailsView
    public void bindDiscountAmount(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "amount");
        a();
        TextView textView = this.k;
        if (textView != null) {
            textView.setText(str);
        }
    }

    @Override // com.avito.android.user_advert.advert.MyAdvertDetailsView
    public void bindDiscountAttributedText(@Nullable AttributedText attributedText) {
        TextView textView = this.n;
        if (textView != null) {
            AttributedTextFormatter attributedTextFormatter = this.f0;
            Context context = this.a;
            Intrinsics.checkNotNullExpressionValue(context, "context");
            TextViews.bindText$default(textView, attributedTextFormatter.format(context, attributedText), false, 2, null);
        }
    }

    @Override // com.avito.android.user_advert.advert.MyAdvertDetailsView
    public void bindDiscountDescription(@Nullable String str) {
        b();
        TextView textView = this.m;
        if (textView != null) {
            TextViews.bindText$default(textView, str, false, 2, null);
        }
    }

    @Override // com.avito.android.user_advert.advert.MyAdvertDetailsView
    public void bindDiscountTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        b();
        TextView textView = this.l;
        if (textView != null) {
            textView.setText(str);
        }
    }

    @Override // com.avito.android.user_advert.advert.MyAdvertDetailsView
    public void bindGallery(@Nullable List<Image> list, @Nullable Video video, @Nullable ForegroundImage foregroundImage) {
        if ((list == null || list.isEmpty()) && video == null && foregroundImage == null) {
            Views.show(this.f);
            Views.hide(this.e);
            return;
        }
        Views.hide(this.f);
        Views.show(this.e);
        PhotoGallery.initGallery$default(this.e, this.c0, video, list, null, this.g0, this.h0, null, null, 0, 0, false, false, MyAdvertDetailsScreen.INSTANCE, foregroundImage, null, null, 20416, null);
    }

    @Override // com.avito.android.user_advert.advert.MyAdvertDetailsView
    public void bindModerationInfo(@Nullable String str) {
        TextViews.bindText$default(this.P, str, false, 2, null);
    }

    @Override // com.avito.android.user_advert.advert.AdvertActionsView
    public void bindPrimaryAction(@Nullable String str) {
        this.l0.bindPrimaryAction(str);
    }

    @Override // com.avito.android.user_advert.advert.MyAdvertDetailsView
    public void bindSafeShow(@Nullable SafeShow safeShow) {
        TextViews.bindText$default(this.H, safeShow != null ? safeShow.getTeaserTitle() : null, false, 2, null);
        if (safeShow != null) {
            this.H.setOnClickListener(new f(this, safeShow));
        }
    }

    @Override // com.avito.android.user_advert.advert.AdvertActionsView
    public void bindSecondaryAction(@Nullable String str) {
        this.l0.bindSecondaryAction(str);
    }

    @Override // com.avito.android.user_advert.advert.MyAdvertDetailsView
    @NotNull
    public FeatureTeaserView createFeatureTeaser(boolean z2, boolean z3) {
        Views.show(this.I);
        return this.i0.createFeatureTeaserView(this.I, z2, z3);
    }

    @Override // com.avito.android.user_advert.advert.MyAdvertDetailsView
    @NotNull
    public Observable<Unit> descriptionExpands() {
        Observable<Unit> create = Observable.create(new ObservableOnSubscribe<Unit>(this) { // from class: com.avito.android.user_advert.advert.MyAdvertDetailsViewImpl$descriptionExpands$1
            public final /* synthetic */ MyAdvertDetailsViewImpl a;

            {
                this.a = r1;
            }

            @Override // io.reactivex.rxjava3.core.ObservableOnSubscribe
            public final void subscribe(final ObservableEmitter<Unit> observableEmitter) {
                this.a.q.setOnExpandListener(new ExpandablePanel.DefaultOnExpandListener() { // from class: com.avito.android.user_advert.advert.MyAdvertDetailsViewImpl$descriptionExpands$1.1
                    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: io.reactivex.rxjava3.core.ObservableEmitter */
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // com.avito.android.design.widget.ExpandablePanel.DefaultOnExpandListener, com.avito.android.design.widget.ExpandablePanel.OnExpandListener
                    public void onExpand(@Nullable View view, @Nullable View view2) {
                        if (view != null) {
                            Views.hide(view);
                        }
                        observableEmitter.onNext(Unit.INSTANCE);
                    }
                });
            }
        });
        Intrinsics.checkNotNullExpressionValue(create, "Observable.create<Unit> …\n            })\n        }");
        return create;
    }

    @Override // com.avito.android.user_advert.advert.MyAdvertDetailsView
    public void dismissDialogForced() {
        android.app.Dialog dialog = this.X;
        if (dialog != null) {
            dialog.setOnDismissListener(null);
            dialog.dismiss();
        }
    }

    @Override // com.avito.android.user_advert.advert.MyAdvertDetailsView
    @NotNull
    public View getCarMarketPriceBadgeView() {
        return this.Y;
    }

    @Override // com.avito.android.user_advert.advert.MyAdvertDetailsView
    @NotNull
    public View getCarMarketPriceChartView() {
        return this.Z;
    }

    @Override // com.avito.android.user_advert.advert.MyAdvertDetailsView
    @NotNull
    public View getCarMarketPriceDescriptionView() {
        return this.a0;
    }

    @Override // com.avito.android.user_advert.advert.MyAdvertDetailsView
    public void hideAdvertNumber() {
        Views.hide(this.w);
        Views.show(this.x);
    }

    @Override // com.avito.android.user_advert.advert.MyAdvertDetailsView
    public void hideContractButton() {
        this.Q.setVisible(false);
    }

    @Override // com.avito.android.user_advert.advert.MyAdvertDetailsView
    public void hideDescription() {
        Views.hide(this.q);
    }

    @Override // com.avito.android.user_advert.advert.MyAdvertDetailsView
    public void hideDiscount() {
        View view = this.h;
        if (view != null) {
            Views.hide(view);
        }
    }

    @Override // com.avito.android.user_advert.advert.MyAdvertDetailsView
    public void hideMyStats() {
        Views.hide(this.J);
    }

    @Override // com.avito.android.user_advert.advert.MyAdvertDetailsView
    public void hideOrderStatus() {
        Views.hide(this.z);
    }

    @Override // com.avito.android.user_advert.advert.MyAdvertDetailsView
    public void hidePriceBadge() {
        Views.hide(this.s);
    }

    @Override // com.avito.android.user_advert.advert.MyAdvertDetailsView
    public void hidePriceBadgeInfoIconAndRemoveListener() {
        Views.hide(this.v);
        this.s.setOnClickListener(null);
    }

    @Override // com.avito.android.user_advert.advert.MyAdvertDetailsView
    public void hideRejectReasons() {
        Views.hide(this.O);
    }

    @Override // com.avito.android.user_advert.advert.MyAdvertDetailsView
    public void hideVerification() {
        VerificationBlockView verificationBlockView = this.T;
        if (verificationBlockView != null) {
            verificationBlockView.setVisible(false);
        }
    }

    @Override // com.avito.android.user_advert.advert.MyAdvertDetailsView
    @NotNull
    public Observable<Integer> menuClicks() {
        Observable<Integer> create = Observable.create(new h(this));
        Intrinsics.checkNotNullExpressionValue(create, "Observable.create<Int> {…e\n            }\n        }");
        return create;
    }

    @Override // com.avito.android.user_advert.advert.AdvertActionsView
    @NotNull
    public Observable<Unit> primaryActionClicks() {
        return this.l0.primaryActionClicks();
    }

    @Override // com.avito.android.user_advert.advert.MyAdvertDetailsView
    public void renderRejectReasons(@Nullable String str, @NotNull List<RejectReason> list) {
        Intrinsics.checkNotNullParameter(list, "rejectReasons");
        LinearLayout linearLayout = this.O;
        linearLayout.removeAllViews();
        int i2 = 0;
        for (T t2 : list) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            T t3 = t2;
            String str2 = i2 == 0 ? str : null;
            View inflate = LayoutInflater.from(this.a).inflate(com.avito.android.user_advert.R.layout.reject_reason_item, (ViewGroup) this.O, false);
            if (str2 != null) {
                View findViewById = inflate.findViewById(com.avito.android.user_advert.R.id.reasons_title);
                Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
                TextViews.bindText$default((TextView) findViewById, str2, false, 2, null);
            }
            View findViewById2 = inflate.findViewById(com.avito.android.user_advert.R.id.name);
            Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
            ((TextView) findViewById2).setText(t3.getName());
            View findViewById3 = inflate.findViewById(com.avito.android.user_advert.R.id.description);
            Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type android.widget.TextView");
            TextViews.bindText$default((TextView) findViewById3, t3.getDescription(), false, 2, null);
            View findViewById4 = inflate.findViewById(com.avito.android.user_advert.R.id.support_link);
            Objects.requireNonNull(findViewById4, "null cannot be cast to non-null type android.widget.TextView");
            TextView textView = (TextView) findViewById4;
            AttributedText support = t3.getSupport();
            if (support != null) {
                support.setOnDeepLinkClickListener(this.W);
                textView.setMovementMethod(LinkMovementMethod.getInstance());
                AttributedTextFormatter attributedTextFormatter = this.f0;
                Context context = inflate.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                TextViews.bindText$default(textView, attributedTextFormatter.format(context, support), false, 2, null);
            } else {
                TextViews.bindText$default(textView, null, false, 2, null);
            }
            Action action = t3.getAction();
            if (action != null) {
                View findViewById5 = inflate.findViewById(com.avito.android.user_advert.R.id.reject_action);
                Objects.requireNonNull(findViewById5, "null cannot be cast to non-null type com.avito.android.lib.design.button.Button");
                Button button = (Button) findViewById5;
                Views.show(button);
                button.setText(action.getTitle());
                button.setOnClickListener(new a1(action, inflate, this, str2, t3));
            }
            Intrinsics.checkNotNullExpressionValue(inflate, "view");
            linearLayout.addView(inflate);
            i2 = i3;
        }
        Views.show(linearLayout);
    }

    @Override // com.avito.android.user_advert.advert.AdvertActionsView
    @NotNull
    public Observable<Unit> secondaryActionClicks() {
        return this.l0.secondaryActionClicks();
    }

    @Override // com.avito.android.user_advert.advert.AdvertActionsView
    public void setActionsVisibility(boolean z2) {
        this.l0.setActionsVisibility(z2);
    }

    @Override // com.avito.android.user_advert.advert.MyAdvertDetailsView
    public void setDescriptionColor(int i2) {
        TextView textView = this.m;
        if (textView != null) {
            Context context = this.a;
            Intrinsics.checkNotNullExpressionValue(context, "context");
            textView.setTextColor(Contexts.getColorByAttr(context, i2));
        }
    }

    @Override // com.avito.android.user_advert.advert.MyAdvertDetailsView
    public void setDiscountImage(@NotNull Picture picture) {
        ImageRequest.Builder requestBuilder;
        ImageRequest.Builder picture2;
        Intrinsics.checkNotNullParameter(picture, "picture");
        a();
        SimpleDraweeView simpleDraweeView = this.i;
        if (simpleDraweeView != null && (requestBuilder = SimpleDraweeViewsKt.getRequestBuilder(simpleDraweeView)) != null && (picture2 = requestBuilder.picture(picture)) != null) {
            picture2.load();
        }
    }

    @Override // com.avito.android.user_advert.advert.MyAdvertDetailsView
    public void setDiscountImageDrawable(int i2) {
        SimpleDraweeView simpleDraweeView;
        ImageRequest.Builder requestBuilder;
        Drawable drawable = this.a.getDrawable(i2);
        if (drawable != null && (simpleDraweeView = this.i) != null && (requestBuilder = SimpleDraweeViewsKt.getRequestBuilder(simpleDraweeView)) != null) {
            Intrinsics.checkNotNullExpressionValue(drawable, "it");
            ImageRequest.Builder drawable2 = requestBuilder.drawable(drawable);
            if (drawable2 != null) {
                drawable2.load();
            }
        }
    }

    @Override // com.avito.android.user_advert.advert.MyAdvertDetailsView
    public void setDividerVisibility(boolean z2) {
        Views.setVisible(this.o, z2);
    }

    @Override // com.avito.android.user_advert.advert.MyAdvertDetailsView
    public void setGalleryCurrentItem(int i2) {
        this.g.setCurrentItem(i2, false);
    }

    @Override // com.avito.android.user_advert.advert.MyAdvertDetailsView
    public void setPriceBadge(@NotNull Badge badge) {
        Intrinsics.checkNotNullParameter(badge, "badge");
        Views.show(this.s);
        BadgesKt.setBadge(this.t, badge);
    }

    @Override // com.avito.android.user_advert.advert.MyAdvertDetailsView
    public void setPriceBadgeSubtitle(@Nullable String str) {
        TextViews.bindText$default(this.u, str, false, 2, null);
    }

    @Override // com.avito.android.user_advert.advert.AdvertActionsView
    public void setPrimaryActionVisibility(boolean z2) {
        this.l0.setPrimaryActionVisibility(z2);
    }

    @Override // com.avito.android.user_advert.advert.MyAdvertDetailsView
    public void setRejectionDeeplinkClickListener(@NotNull OnDeepLinkClickListener onDeepLinkClickListener) {
        Intrinsics.checkNotNullParameter(onDeepLinkClickListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.W = onDeepLinkClickListener;
    }

    @Override // com.avito.android.user_advert.advert.AdvertActionsView
    public void setSecondaryActionVisibility(boolean z2) {
        this.l0.setSecondaryActionVisibility(z2);
    }

    @Override // com.avito.android.user_advert.advert.MyAdvertDetailsView
    public void setStatsClickListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.J.setOnStatisticsClickListener(function0);
        Views.show(this.J);
    }

    @Override // com.avito.android.user_advert.advert.MyAdvertDetailsView
    public void setUpToolbar(@NotNull List<ActionMenu> list) {
        Intrinsics.checkNotNullParameter(list, "actions");
        this.p.getMenu().clear();
        int i2 = 0;
        for (T t2 : list) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            Toolbars.addActionMenu(this.p, i2, t2);
            i2 = i3;
        }
    }

    @Override // com.avito.android.user_advert.advert.MyAdvertDetailsView
    public void showActionMessage(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        Context context = this.a;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        ToastsKt.showToast$default(context, str, 0, 2, (Object) null);
    }

    @Override // com.avito.android.user_advert.advert.MyAdvertDetailsView
    public void showAddress(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, IntegrityManager.INTEGRITY_TYPE_ADDRESS);
        if (this.y == null) {
            View findViewById = this.b0.findViewById(com.avito.android.advert_core.R.id.part_address_stub);
            Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.view.ViewStub");
            ((ViewStub) findViewById).inflate();
            View findViewById2 = this.b0.findViewById(com.avito.android.advert_core.R.id.address_container);
            Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.view.View");
            this.y = findViewById2;
            View findViewById3 = this.b0.findViewById(com.avito.android.advert_core.R.id.advert_address);
            Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type android.widget.TextView");
            this.E = (TextView) findViewById3;
        }
        TextView textView = this.E;
        if (textView != null) {
            textView.setText(str);
        }
    }

    @Override // com.avito.android.user_advert.advert.MyAdvertDetailsView
    public void showAddressCopied() {
        Context context = this.a;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        Context context2 = this.a;
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        String string = context2.getResources().getString(com.avito.android.advert_core.R.string.address_is_copied);
        Intrinsics.checkNotNullExpressionValue(string, "context.resources.getStr…string.address_is_copied)");
        ToastsKt.showToast$default(context, string, 0, 2, (Object) null);
    }

    @Override // com.avito.android.user_advert.advert.MyAdvertDetailsView
    public void showAdvertNumber(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        Intrinsics.checkNotNullParameter(str2, "time");
        this.w.setText(this.b.getString(com.avito.android.advert_core.R.string.advert_number_template, str, str2));
        Views.show(this.w);
        Views.hide(this.x);
    }

    @Override // com.avito.android.user_advert.advert.MyAdvertDetailsView
    public void showAdvertRestoredMessage(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        Context context = this.a;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        ToastsKt.showToast$default(context, str, 0, 2, (Object) null);
    }

    @Override // com.avito.android.user_advert.advert.MyAdvertDetailsView
    public void showAlertBanner(@NotNull MyAdvertDetails.AlertBanner alertBanner, @NotNull Function0<Unit> function0) {
        int i2;
        Intrinsics.checkNotNullParameter(alertBanner, "item");
        Intrinsics.checkNotNullParameter(function0, "clickListener");
        Views.show(this.N);
        this.N.setOnClickListener(new i(function0));
        AlertBannerContent content = this.N.getContent();
        content.setTitle(alertBanner.getTitle());
        content.setBody(alertBanner.getBody());
        int ordinal = alertBanner.getStyle().ordinal();
        if (ordinal == 0) {
            i2 = com.avito.android.lib.design.R.attr.alertBannerSuccess;
        } else if (ordinal == 1) {
            i2 = com.avito.android.lib.design.R.attr.alertBannerDefault;
        } else if (ordinal == 2) {
            i2 = com.avito.android.lib.design.R.attr.alertBannerWarning;
        } else {
            throw new NoWhenBranchMatchedException();
        }
        AlertBanner.setContentByAttr$default(this.N, 0, i2, 1, null);
    }

    @Override // com.avito.android.user_advert.advert.MyAdvertDetailsView
    public void showAnonymousNumber(@Nullable AnonymousNumber anonymousNumber) {
        if (anonymousNumber != null) {
            String title = anonymousNumber.getTitle();
            boolean z2 = true;
            if (title == null || title.length() == 0) {
                String subtitle = anonymousNumber.getSubtitle();
                if (!(subtitle == null || subtitle.length() == 0)) {
                    z2 = false;
                }
                if (z2) {
                    return;
                }
            }
            ViewUtils viewUtils = ViewUtils.INSTANCE;
            ViewStub viewStub = (ViewStub) viewUtils.findById(this.b0, com.avito.android.user_advert.R.id.anonymous_number_stub);
            if (viewStub != null) {
                viewStub.inflate();
                View findById = viewUtils.findById(this.b0, com.avito.android.user_advert.R.id.anonymous_number);
                TextView textView = (TextView) findById.findViewById(com.avito.android.advert_core.R.id.anonymous_number_title);
                TextView textView2 = (TextView) findById.findViewById(com.avito.android.advert_core.R.id.anonymous_number_subtitle);
                Intrinsics.checkNotNullExpressionValue(textView, "title");
                TextViews.bindText$default(textView, anonymousNumber.getTitle(), false, 2, null);
                Intrinsics.checkNotNullExpressionValue(textView2, MessengerShareContentUtility.SUBTITLE);
                TextViews.bindText$default(textView2, anonymousNumber.getSubtitle(), false, 2, null);
            }
        }
    }

    @Override // com.avito.android.user_advert.advert.MyAdvertDetailsView
    public void showAppRater() {
        AppRaterDialogFragment.Companion.getInstance(AppRaterEventSourcePage.FREE_PUBLISH).show(this.c0, "app_rater_dialog");
    }

    @Override // com.avito.android.user_advert.advert.MyAdvertDetailsView
    public void showAppliedServices(@NotNull String str, @NotNull Map<String, ? extends Picture> map, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(str, "description");
        Intrinsics.checkNotNullParameter(map, "servicesIcons");
        Intrinsics.checkNotNullParameter(function0, "clickListener");
        if (this.L == null) {
            this.L = this.K.inflate();
        }
        View view = this.L;
        if (view != null) {
            View findViewById = view.findViewById(com.avito.android.user_advert.R.id.applied_services_description);
            Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
            View findViewById2 = view.findViewById(com.avito.android.user_advert.R.id.icons_view);
            Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type com.avito.android.component.icons_view.IconsView");
            ((TextView) findViewById).setText(str);
            ((IconsView) findViewById2).setIcons(map);
            view.setOnClickListener(new j(str, map, function0));
        }
    }

    @Override // com.avito.android.user_advert.advert.MyAdvertDetailsView
    public void showContent() {
        this.b0.post(new k(this));
    }

    @Override // com.avito.android.user_advert.advert.MyAdvertDetailsView
    public void showContractButton(@NotNull ContractInfo contractInfo) {
        Intrinsics.checkNotNullParameter(contractInfo, "contract");
        this.Q.setTitle(contractInfo.getTitle());
        this.Q.setOnClickListener(new l(this, contractInfo));
        this.Q.setVisible(true);
    }

    @Override // com.avito.android.user_advert.advert.MyAdvertDetailsView
    @NotNull
    public Observable<Unit> showDeleteItemDialog() {
        Observable<Unit> create = Observable.create(new m(this));
        Intrinsics.checkNotNullExpressionValue(create, "Observable.create<Unit> …}\n            }\n        }");
        return create;
    }

    @Override // com.avito.android.user_advert.advert.MyAdvertDetailsView
    public void showDescription(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "description");
        this.q.setTextAutoCollapse(charSequence);
        Views.show(this.q);
    }

    @Override // com.avito.android.user_advert.advert.MyAdvertDetailsView
    public void showDiscount() {
        View view = this.h;
        if (view != null) {
            Views.show(view);
        }
    }

    @Override // com.avito.android.user_advert.advert.MyAdvertDetailsView
    public void showError(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        Context context = this.a;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        ToastsKt.showToast$default(context, str, 0, 2, (Object) null);
    }

    @Override // com.avito.android.user_advert.advert.MyAdvertDetailsView
    public void showErrorDialog(@NotNull String str, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(str, "message");
        Intrinsics.checkNotNullParameter(function0, "dismissListener");
        DialogRouter dialogRouter = this.e0;
        String string = this.a.getString(com.avito.android.user_advert.R.string.error_title);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.string.error_title)");
        this.X = dialogRouter.showSimpleNotifyingDismissDialog(string, str, function0);
    }

    @Override // com.avito.android.user_advert.advert.MyAdvertDetailsView
    public void showGeoReference(@Nullable List<GeoReference> list) {
        this.C.removeAllViews();
        if (list == null || list.isEmpty()) {
            Views.setVisible(this.C, false);
            Views.show(this.D);
            return;
        }
        Views.hide(this.D);
        Views.setVisible(this.C, true);
        ((GeoReferenceViewWrapper) this.U.getValue()).bindGeoReferences(list);
    }

    @Override // com.avito.android.user_advert.advert.MyAdvertDetailsView
    public void showInfoBanner(@NotNull DetailsSheetLinkBody detailsSheetLinkBody, @Nullable ParametrizedClickStreamEvent parametrizedClickStreamEvent) {
        Intrinsics.checkNotNullParameter(detailsSheetLinkBody, SDKConstants.PARAM_A2U_BODY);
        this.b0.getContext().startActivity(this.j0.detailsSheetIntent(detailsSheetLinkBody, parametrizedClickStreamEvent));
    }

    @Override // com.avito.android.user_advert.advert.MyAdvertDetailsView
    public void showLimitsInfoDialog(@NotNull LimitsInfo limitsInfo) {
        Intrinsics.checkNotNullParameter(limitsInfo, "info");
        Context context = this.a;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        String str = null;
        PublishLimitsInfoView publishLimitsInfoView = new PublishLimitsInfoView(context, null, 2, null);
        publishLimitsInfoView.setDescription(limitsInfo.getDescription());
        LimitsInfo.Progress progress = limitsInfo.getProgress();
        if (progress != null) {
            publishLimitsInfoView.setProgress(progress.getValue(), progress.getStyle());
        }
        LimitsInfo.Progress progress2 = limitsInfo.getProgress();
        if (progress2 != null) {
            str = progress2.getProgressHint();
        }
        publishLimitsInfoView.setProgressHint(str);
        publishLimitsInfoView.setLocation(limitsInfo.getLocation());
        publishLimitsInfoView.setCategory(limitsInfo.getCategory());
        Dialog.Companion companion = com.avito.android.lib.design.dialog.Dialog.Companion;
        Context context2 = this.a;
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        Dialog.Companion.create$default(companion, context2, 0, 0, new n(publishLimitsInfoView), 6, null).show();
    }

    @Override // com.avito.android.user_advert.advert.MyAdvertDetailsView
    public void showLoadingProblem() {
        LoadingOverlay.DefaultImpls.showLoadingProblem$default(this.d, null, 1, null);
    }

    @Override // com.avito.android.user_advert.advert.MyAdvertDetailsView
    public void showMyStats(int i2, int i3, int i4, @Nullable AdvertStatsContact advertStatsContact) {
        this.J.setWatches(i2, i3);
        this.J.setLikes(i4);
        if (advertStatsContact != null) {
            this.J.setContacts(advertStatsContact.getTotal(), advertStatsContact.getToday());
        } else {
            this.J.hideContacts();
        }
        Views.show(this.J);
    }

    @Override // com.avito.android.user_advert.advert.MyAdvertDetailsView
    public void showNewStatsTooltip() {
        TextView watchesView = this.J.getWatchesView();
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = null;
        Context context = this.a;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        objectRef.element = (T) TooltipContentKt.content(Tooltip.setSize$default(new Tooltip(context, 0, 0, 6, null).setTooltipPosition(new TooltipPositions.Bottom(new TailPositions.End(null, 1, null))), -1, 0, 2, null), new d1(this, objectRef)).show(watchesView);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    @Override // com.avito.android.user_advert.advert.MyAdvertDetailsView
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void showOrderStatus(@org.jetbrains.annotations.NotNull com.avito.android.remote.model.user_adverts.UserOrderStatus r9, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super com.avito.android.deep_linking.links.DeepLink, kotlin.Unit> r10) {
        /*
            r8 = this;
            java.lang.String r0 = "orderStatus"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r0 = "listener"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            android.view.ViewGroup r0 = r8.z
            com.avito.android.util.Views.show(r0)
            com.avito.android.lib.design.button.Button r0 = r8.A
            android.content.Context r0 = r0.getContext()
            int r1 = com.avito.android.advert_core.R.drawable.ic_delivery_24_gray
            android.graphics.drawable.Drawable r3 = androidx.core.content.ContextCompat.getDrawable(r0, r1)
            if (r3 == 0) goto L_0x002e
            com.avito.android.lib.design.button.Button r0 = r8.A
            android.content.Context r0 = r0.getContext()
            int r1 = com.avito.android.lib.design.R.attr.black
            int r0 = com.avito.android.util.Contexts.getColorByAttr(r0, r1)
            android.graphics.PorterDuff$Mode r1 = android.graphics.PorterDuff.Mode.SRC_ATOP
            r3.setColorFilter(r0, r1)
        L_0x002e:
            com.avito.android.lib.design.button.Button r2 = r8.A
            r4 = 0
            r5 = 0
            r6 = 6
            r7 = 0
            com.avito.android.lib.design.button.Button.setImageDrawable$default(r2, r3, r4, r5, r6, r7)
            com.avito.android.lib.design.button.Button r0 = r8.A
            com.avito.android.remote.model.user_adverts.UserOrderStatus$Type r1 = r9.getType()
            r2 = 1
            if (r1 != 0) goto L_0x0041
            goto L_0x004d
        L_0x0041:
            int r1 = r1.ordinal()
            if (r1 == r2) goto L_0x0056
            r3 = 2
            if (r1 == r3) goto L_0x0053
            r3 = 3
            if (r1 == r3) goto L_0x0050
        L_0x004d:
            int r1 = com.avito.android.user_advert.R.drawable.order_status_background_processing
            goto L_0x0058
        L_0x0050:
            int r1 = com.avito.android.user_advert.R.drawable.order_status_background_error
            goto L_0x0058
        L_0x0053:
            int r1 = com.avito.android.user_advert.R.drawable.order_status_background_warning
            goto L_0x0058
        L_0x0056:
            int r1 = com.avito.android.user_advert.R.drawable.order_status_background_done
        L_0x0058:
            r0.setBackgroundResource(r1)
            com.avito.android.lib.design.button.Button r0 = r8.A
            java.lang.String r1 = r9.getDescription()
            r0.setText(r1)
            com.avito.android.remote.model.user_adverts.UserOrderStatus$Link r9 = r9.getLink()
            if (r9 == 0) goto L_0x0088
            com.avito.android.lib.design.button.Button r0 = r8.B
            java.lang.String r1 = r9.getTitle()
            r0.setText(r1)
            com.avito.android.lib.design.button.Button r0 = r8.B
            com.avito.android.user_advert.advert.MyAdvertDetailsViewImpl$a r1 = new com.avito.android.user_advert.advert.MyAdvertDetailsViewImpl$a
            r3 = 0
            r1.<init>(r3, r9, r8, r10)
            r0.setOnClickListener(r1)
            com.avito.android.lib.design.button.Button r0 = r8.A
            com.avito.android.user_advert.advert.MyAdvertDetailsViewImpl$a r1 = new com.avito.android.user_advert.advert.MyAdvertDetailsViewImpl$a
            r1.<init>(r2, r9, r8, r10)
            r0.setOnClickListener(r1)
        L_0x0088:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.user_advert.advert.MyAdvertDetailsViewImpl.showOrderStatus(com.avito.android.remote.model.user_adverts.UserOrderStatus, kotlin.jvm.functions.Function1):void");
    }

    @Override // com.avito.android.user_advert.advert.MyAdvertDetailsView
    public void showPermissionForCallDialogIfNeeded(@NotNull String str, boolean z2) {
        Intrinsics.checkNotNullParameter(str, "itemId");
        if (!this.k0.checkPermission("android.permission.RECORD_AUDIO")) {
            boolean z3 = !this.k0.shouldShowRequestPermissionRationale("android.permission.RECORD_AUDIO") && z2;
            Dialog.Companion companion = com.avito.android.lib.design.dialog.Dialog.Companion;
            Context context = this.a;
            Intrinsics.checkNotNullExpressionValue(context, "context");
            Dialog.Companion.create$default(companion, context, 0, 0, new o(this, z3, str), 6, null).show();
            this.h0.track(new CallPermissionDialogEvent(str));
        }
    }

    @Override // com.avito.android.user_advert.advert.MyAdvertDetailsView
    public void showPrice(@Nullable String str) {
        TextViews.bindText$default(this.r, str, false, 2, null);
    }

    @Override // com.avito.android.user_advert.advert.MyAdvertDetailsView
    public void showPriceBadgeInfoIconWithListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        Views.show(this.v);
        this.s.setOnClickListener(new p(function0));
    }

    @Override // com.avito.android.user_advert.advert.MyAdvertDetailsView
    public void showSnackBar(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        Views.showSnackBar$default(this.b0, str, 0, (String) null, 0, (Function0) null, (Function0) null, 0, 126, (Object) null);
    }

    @Override // com.avito.android.user_advert.advert.MyAdvertDetailsView
    public void showStats(@Nullable String str) {
        TextViews.bindText$default(this.G, str, false, 2, null);
    }

    @Override // com.avito.android.user_advert.advert.MyAdvertDetailsView
    public void showStatsPadding() {
        View findViewById = this.b0.findViewById(com.avito.android.user_advert.R.id.space_stats_redesign);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.view.View");
        Views.show(findViewById);
    }

    @Override // com.avito.android.user_advert.advert.MyAdvertDetailsView
    public void showTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        this.F.setText(str);
    }

    @Override // com.avito.android.user_advert.advert.MyAdvertDetailsView
    public void showToolbarTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        this.p.setTitle(str);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0098, code lost:
        if (r0 != null) goto L_0x009e;
     */
    @Override // com.avito.android.user_advert.advert.MyAdvertDetailsView
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void showVasBundlesBanner(@org.jetbrains.annotations.NotNull com.avito.android.remote.model.adverts.MyAdvertDetails.VasBundlesBanner r5, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function0<kotlin.Unit> r6, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function0<kotlin.Unit> r7) {
        /*
            r4 = this;
            java.lang.String r0 = "banner"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "clickListener"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "closeClickListener"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            com.avito.android.lib.design.banner.Banner r0 = r4.M
            com.avito.android.util.Views.show(r0)
            com.avito.android.lib.design.banner.Banner r0 = r4.M
            com.avito.android.lib.design.banner.BannerContent r0 = r0.getContent()
            java.lang.String r1 = r5.getTitle()
            r0.setBody(r1)
            com.avito.android.remote.model.UniversalColor r0 = r5.getBackgroundColor()
            com.avito.android.remote.model.UniversalColor r1 = r5.getBackgroundRippleColor()
            java.lang.String r2 = "context"
            if (r0 == 0) goto L_0x0046
            if (r1 == 0) goto L_0x0046
            android.content.Context r3 = r4.a
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r2)
            android.content.res.ColorStateList r0 = com.avito.android.util.color.ContextsKt.createColorStateList(r3, r0)
            android.content.Context r3 = r4.a
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r2)
            android.content.res.ColorStateList r1 = com.avito.android.util.color.ContextsKt.createColorStateList(r3, r1)
            com.avito.android.lib.design.banner.Banner r3 = r4.M
            r3.setBackground(r0, r1)
        L_0x0046:
            com.avito.android.lib.design.banner.Banner r0 = r4.M
            com.avito.android.user_advert.advert.MyAdvertDetailsViewImpl$q r1 = new com.avito.android.user_advert.advert.MyAdvertDetailsViewImpl$q
            r1.<init>(r6)
            r0.setOnClickListener(r1)
            com.avito.android.remote.model.UniversalImage r6 = r5.getImage()
            r0 = 0
            if (r6 == 0) goto L_0x0065
            android.content.Context r1 = r4.a
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            boolean r1 = com.avito.android.lib.util.DarkThemeManagerKt.isLightTheme(r1)
            com.avito.android.remote.model.Image r6 = com.avito.android.remote.model.UniversalImageKt.getImageDependsOnTheme(r6, r1)
            goto L_0x0066
        L_0x0065:
            r6 = r0
        L_0x0066:
            if (r6 == 0) goto L_0x006d
            com.avito.android.lib.design.banner.Banner r1 = r4.M
            com.avito.android.lib.design.banner.BannersKt.loadImage(r1, r6)
        L_0x006d:
            com.avito.android.lib.design.banner.Banner r6 = r4.M
            android.view.View r6 = r6.getContentView()
            if (r6 == 0) goto L_0x007e
            int r1 = com.avito.android.user_advert.R.id.timer
            android.view.View r6 = r6.findViewById(r1)
            com.avito.android.component.timer.CountDownTimerWidget r6 = (com.avito.android.component.timer.CountDownTimerWidget) r6
            goto L_0x007f
        L_0x007e:
            r6 = r0
        L_0x007f:
            java.lang.Long r5 = r5.getDueDate()
            if (r5 == 0) goto L_0x009b
            long r1 = r5.longValue()
            com.avito.android.util.Views.show(r6)
            if (r6 == 0) goto L_0x0091
            r6.hideHours()
        L_0x0091:
            if (r6 == 0) goto L_0x0098
            r6.setFinishDate(r1)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
        L_0x0098:
            if (r0 == 0) goto L_0x009b
            goto L_0x009e
        L_0x009b:
            com.avito.android.util.Views.hide(r6)
        L_0x009e:
            com.avito.android.lib.design.banner.Banner r5 = r4.M
            com.avito.android.user_advert.advert.MyAdvertDetailsViewImpl$showVasBundlesBanner$4 r6 = new com.avito.android.user_advert.advert.MyAdvertDetailsViewImpl$showVasBundlesBanner$4
            r6.<init>(r4, r7)
            r5.setCloseButtonListener(r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.user_advert.advert.MyAdvertDetailsViewImpl.showVasBundlesBanner(com.avito.android.remote.model.adverts.MyAdvertDetails$VasBundlesBanner, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0):void");
    }

    @Override // com.avito.android.user_advert.advert.MyAdvertDetailsView
    public void showVerification(@NotNull VerificationBlockItem verificationBlockItem, boolean z2) {
        ViewGroup viewGroup;
        Intrinsics.checkNotNullParameter(verificationBlockItem, "verification");
        VerificationBlockView verificationBlockView = this.T;
        if (verificationBlockView != null) {
            verificationBlockView.setVisible(false);
        }
        if (z2) {
            viewGroup = this.R;
        } else {
            viewGroup = this.S;
        }
        VerificationBlockViewImpl verificationBlockViewImpl = new VerificationBlockViewImpl(viewGroup);
        verificationBlockViewImpl.showTitle(verificationBlockItem.getTitleId());
        verificationBlockViewImpl.showDescription(verificationBlockItem.getDescriptionId());
        if (verificationBlockItem.getButtonTitleId() == null) {
            verificationBlockViewImpl.hideButton();
        } else {
            verificationBlockViewImpl.showButton(verificationBlockItem.getButtonTitleId().intValue(), new y0(this));
        }
        verificationBlockViewImpl.setAdditionalDescriptionVisible(verificationBlockItem.getHasAdditionalDescription());
        verificationBlockViewImpl.setBadgeVisible(verificationBlockItem.getHasBadge());
        if (verificationBlockItem.isSupportNeeded()) {
            verificationBlockViewImpl.showSupportButton(new Function0<Unit>(this.d0) { // from class: a2.a.a.h3.a.z0
                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.jvm.functions.Function0
                public Unit invoke() {
                    ((MyAdvertDetailsViewPresenter) this.receiver).onSupportButtonClicked();
                    return Unit.INSTANCE;
                }
            });
        } else {
            verificationBlockViewImpl.hideSupportButton();
        }
        verificationBlockViewImpl.setVisible(true);
        this.T = verificationBlockViewImpl;
    }

    @Override // com.avito.android.user_advert.advert.MyAdvertDetailsView
    public void startLoading() {
        this.d.showLoading();
    }

    @Override // com.avito.android.user_advert.advert.MyAdvertDetailsView
    @NotNull
    public Observable<Unit> upButtonClicks() {
        Observable<Unit> create = Observable.create(new r(this));
        Intrinsics.checkNotNullExpressionValue(create, "Observable.create<Unit> …)\n            }\n        }");
        return create;
    }
}
