package com.avito.android.notification_center.landing.share;

import a2.g.r.g;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.AttrRes;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.MenuRes;
import androidx.annotation.StringRes;
import com.avito.android.analytics.Analytics;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.connection_quality.connectivity.ConnectivityProvider;
import com.avito.android.image_loader.AvitoPictureKt;
import com.avito.android.image_loader.Picture;
import com.avito.android.lastclick.LastClick;
import com.avito.android.lib.expected.badge_bar.BadgeViewListener;
import com.avito.android.notification_center.R;
import com.avito.android.progress_overlay.LoadingOverlay;
import com.avito.android.progress_overlay.ProgressOverlay;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.RadiusInfo;
import com.avito.android.remote.model.Size;
import com.avito.android.remote.model.Sort;
import com.avito.android.remote.model.badge.Badge;
import com.avito.android.remote.model.badge_bar.SerpBadge;
import com.avito.android.server_time.TimeSource;
import com.avito.android.util.ActionMenu;
import com.avito.android.util.DialogUtils;
import com.avito.android.util.ImageContainer;
import com.avito.android.util.Images;
import com.avito.android.util.SimpleDraweeViewsKt;
import com.avito.android.util.ToastsKt;
import com.avito.android.util.Views;
import com.avito.android.util.rx3.InteropKt;
import com.facebook.appevents.integrity.IntegrityManager;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.jakewharton.rxrelay2.PublishRelay;
import io.reactivex.Observable;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.component.appbar.AppBar;
import ru.avito.component.appbar.AppBarImpl;
import ru.avito.component.button.ButtonImpl;
import ru.avito.component.serp.SerpAdvertListCard;
import ru.avito.component.serp.SerpAdvertListCardImpl;
import ru.avito.component.text.TextImpl;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\b`\u0018\u00002\u00020\u0001:\u0001*J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\b\u001a\u00020\u0002H&¢\u0006\u0004\b\b\u0010\u0004J\u000f\u0010\n\u001a\u00020\u0002H&¢\u0006\u0004\b\n\u0010\u0004J\u0017\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0006H&¢\u0006\u0004\b\n\u0010\tJ\u000f\u0010\f\u001a\u00020\u0002H&¢\u0006\u0004\b\f\u0010\u0004J\u000f\u0010\r\u001a\u00020\u0002H&¢\u0006\u0004\b\r\u0010\u0004J\u0019\u0010\u0010\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH&¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0006H&¢\u0006\u0004\b\u0013\u0010\tJ\u0017\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0006H&¢\u0006\u0004\b\u0015\u0010\tJ\u0019\u0010\u0016\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH&¢\u0006\u0004\b\u0016\u0010\u0011J\u0017\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0017H&¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0006H&¢\u0006\u0004\b\u001b\u0010\tJ\u0017\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u0006H&¢\u0006\u0004\b\u001d\u0010\tJ\u0019\u0010\u001f\u001a\u00020\u00022\b\u0010\u001e\u001a\u0004\u0018\u00010\u0006H&¢\u0006\u0004\b\u001f\u0010\tJ\u0019\u0010!\u001a\u00020\u00022\b\u0010 \u001a\u0004\u0018\u00010\u0006H&¢\u0006\u0004\b!\u0010\tJ\u0017\u0010#\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020\u0006H&¢\u0006\u0004\b#\u0010\tJ\u0015\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00020$H&¢\u0006\u0004\b%\u0010&J\u0015\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00020$H&¢\u0006\u0004\b'\u0010&J\u0015\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00020$H&¢\u0006\u0004\b(\u0010&J\u0015\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00020$H&¢\u0006\u0004\b)\u0010&¨\u0006+"}, d2 = {"Lcom/avito/android/notification_center/landing/share/NotificationCenterLandingShareView;", "", "", "showProgress", "()V", "showContent", "", "error", "showError", "(Ljava/lang/String;)V", "showMessage", "message", "showProgressDialog", "hideProgressDialog", "Lcom/avito/android/remote/model/Image;", "image", "setImage", "(Lcom/avito/android/remote/model/Image;)V", "title", "setTitle", "description", "setDescription", "setAdvertImage", "", "isVisible", "setAdvertVisible", "(Z)V", "setAdvertTitle", "price", "setAdvertPrice", "priceWithoutDiscount", "setAdvertPriceWithoutDiscount", "location", "setAdvertLocation", "text", "setActionButtonText", "Lio/reactivex/Observable;", "getActionButtonClicks", "()Lio/reactivex/Observable;", "getBackButtonClicks", "getCancelDialogClicks", "getRetryButtonClicks", "Impl", "notification-center_release"}, k = 1, mv = {1, 4, 2})
public interface NotificationCenterLandingShareView {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000ê\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B;\u0012\b\u0010Å\u0001\u001a\u00030Ä\u0001\u0012\b\u0010Ç\u0001\u001a\u00030Æ\u0001\u0012\b\u0010É\u0001\u001a\u00030È\u0001\u0012\b\u0010Ê\u0001\u001a\u00030¢\u0001\u0012\b\u0010Ì\u0001\u001a\u00030Ë\u0001¢\u0006\u0006\bÍ\u0001\u0010Î\u0001J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\u0006J\u0017\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\n\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\n\u0010\u0006J\u000f\u0010\f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\f\u0010\u0006J\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\bH\u0016¢\u0006\u0004\b\f\u0010\u000bJ\u000f\u0010\u000e\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\u0006J\u000f\u0010\u000f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000f\u0010\u0006J\u0019\u0010\u0012\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0015\u0010\u000bJ\u0017\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0017\u0010\u000bJ\u0017\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0019\u0010\u001c\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b\u001c\u0010\u0013J\u0017\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001d\u0010\u000bJ\u0017\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001f\u0010\u000bJ\u0019\u0010!\u001a\u00020\u00042\b\u0010 \u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b!\u0010\u000bJ\u0019\u0010#\u001a\u00020\u00042\b\u0010\"\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b#\u0010\u000bJ\u0017\u0010%\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\bH\u0016¢\u0006\u0004\b%\u0010\u000bJ\u0015\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00040&H\u0016¢\u0006\u0004\b'\u0010(J\u0015\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00040&H\u0016¢\u0006\u0004\b)\u0010(J\u0015\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00040&H\u0016¢\u0006\u0004\b*\u0010(J\u0015\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00040&H\u0016¢\u0006\u0004\b+\u0010(J\u0010\u0010,\u001a\u00020\u0004H\u0001¢\u0006\u0004\b,\u0010\u0006J\u0010\u0010\u0019\u001a\u00020\u0018H\u0001¢\u0006\u0004\b\u0019\u0010-J\u0016\u00100\u001a\b\u0012\u0004\u0012\u00020/0.H\u0001¢\u0006\u0004\b0\u00101J\u0016\u00102\u001a\b\u0012\u0004\u0012\u00020\u00040.H\u0001¢\u0006\u0004\b2\u00101J.\u00106\u001a\u00020\u00042\u0006\u00103\u001a\u00020/2\b\b\u0001\u00104\u001a\u00020/2\n\b\u0001\u00105\u001a\u0004\u0018\u00010/H\u0001¢\u0006\u0004\b6\u00107J\u001a\u0010:\u001a\u00020\u00042\b\u00109\u001a\u0004\u0018\u000108H\u0001¢\u0006\u0004\b:\u0010;J\u001a\u0010=\u001a\u00020\u00042\b\b\u0001\u0010<\u001a\u00020/H\u0001¢\u0006\u0004\b=\u0010>J\u001a\u0010@\u001a\u00020\u00042\b\b\u0001\u0010?\u001a\u00020/H\u0001¢\u0006\u0004\b@\u0010>J\u001a\u0010B\u001a\u00020\u00042\b\b\u0001\u0010A\u001a\u00020/H\u0001¢\u0006\u0004\bB\u0010>J&\u0010E\u001a\u00020\u00042\b\b\u0001\u0010C\u001a\u00020/2\n\b\u0003\u0010D\u001a\u0004\u0018\u00010/H\u0001¢\u0006\u0004\bE\u0010FJ\u0018\u0010H\u001a\u00020\u00042\u0006\u0010G\u001a\u00020\u0018H\u0001¢\u0006\u0004\bH\u0010\u001bJ\u0018\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020IH\u0001¢\u0006\u0004\b\u0015\u0010JJ\u001a\u0010\u0015\u001a\u00020\u00042\b\b\u0001\u0010K\u001a\u00020/H\u0001¢\u0006\u0004\b\u0015\u0010>J\u0018\u0010L\u001a\u00020\u00042\u0006\u0010G\u001a\u00020\u0018H\u0001¢\u0006\u0004\bL\u0010\u001bJ\u001e\u0010P\u001a\u00020\u00042\f\u0010O\u001a\b\u0012\u0004\u0012\u00020N0MH\u0001¢\u0006\u0004\bP\u0010QJ\u0010\u0010R\u001a\u00020\u0004H\u0001¢\u0006\u0004\bR\u0010\u0006J*\u0010W\u001a\u00020\u00042\u000e\u0010T\u001a\n\u0012\u0004\u0012\u00020S\u0018\u00010M2\b\u0010V\u001a\u0004\u0018\u00010UH\u0001¢\u0006\u0004\bW\u0010XJ\u0018\u0010Z\u001a\u00020Y2\u0006\u00109\u001a\u000208H\u0001¢\u0006\u0004\bZ\u0010[J\u0010\u0010\\\u001a\u00020\u0004H\u0001¢\u0006\u0004\b\\\u0010\u0006J\u0018\u0010^\u001a\u00020\u00042\u0006\u0010]\u001a\u00020\u0018H\u0001¢\u0006\u0004\b^\u0010\u001bJ\u001a\u0010_\u001a\u00020\u00042\b\u0010$\u001a\u0004\u0018\u00010\bH\u0001¢\u0006\u0004\b_\u0010\u000bJ\u001a\u0010`\u001a\u00020\u00042\b\u0010$\u001a\u0004\u0018\u00010\bH\u0001¢\u0006\u0004\b`\u0010\u000bJ\u001a\u0010b\u001a\u00020\u00042\b\u0010a\u001a\u0004\u0018\u00010\bH\u0001¢\u0006\u0004\bb\u0010\u000bJ\u0018\u0010e\u001a\u00020\u00042\u0006\u0010d\u001a\u00020cH\u0001¢\u0006\u0004\be\u0010fJ\u001a\u0010h\u001a\u00020\u00042\b\u0010g\u001a\u0004\u0018\u00010\bH\u0001¢\u0006\u0004\bh\u0010\u000bJ \u0010k\u001a\u00020\u00042\u000e\u0010j\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010iH\u0001¢\u0006\u0004\bk\u0010lJ\u0018\u0010o\u001a\u00020\u00042\u0006\u0010n\u001a\u00020mH\u0001¢\u0006\u0004\bo\u0010pJ\u0018\u0010r\u001a\u00020\u00042\u0006\u0010q\u001a\u00020\u0018H\u0001¢\u0006\u0004\br\u0010\u001bJ\u001a\u0010t\u001a\u00020\u00042\b\u0010s\u001a\u0004\u0018\u00010\bH\u0001¢\u0006\u0004\bt\u0010\u000bJ\u0018\u0010v\u001a\u00020\u00042\u0006\u0010u\u001a\u00020\u0018H\u0001¢\u0006\u0004\bv\u0010\u001bJ\u0018\u0010x\u001a\u00020\u00042\u0006\u0010w\u001a\u00020\u0018H\u0001¢\u0006\u0004\bx\u0010\u001bJ\u0018\u0010y\u001a\u00020\u00042\u0006\u0010G\u001a\u00020\u0018H\u0001¢\u0006\u0004\by\u0010\u001bJ\u0010\u0010z\u001a\u00020\u0004H\u0001¢\u0006\u0004\bz\u0010\u0006J\u0018\u0010|\u001a\u00020\u00042\u0006\u0010{\u001a\u00020\u0018H\u0001¢\u0006\u0004\b|\u0010\u001bJ\u001a\u0010~\u001a\u00020\u00042\b\u0010}\u001a\u0004\u0018\u00010\bH\u0001¢\u0006\u0004\b~\u0010\u000bJ\u001a\u0010\u001a\u00020\u00042\b\u0010\"\u001a\u0004\u0018\u00010\bH\u0001¢\u0006\u0004\b\u0010\u000bJ)\u0010\u0001\u001a\u00020\u00042\b\u0010\"\u001a\u0004\u0018\u00010\b2\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0001¢\u0006\u0006\b\u0001\u0010\u0001J(\u0010\u0001\u001a\u00020\u00042\b\u0010g\u001a\u0004\u0018\u00010\b2\t\u0010\u0001\u001a\u0004\u0018\u00010\bH\u0001¢\u0006\u0006\b\u0001\u0010\u0001J\"\u0010\u0001\u001a\u00020\u00042\u000e\u0010j\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010iH\u0001¢\u0006\u0005\b\u0001\u0010lJ\"\u0010\u0001\u001a\u00020\u00042\u000e\u0010j\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010iH\u0001¢\u0006\u0005\b\u0001\u0010lJ(\u0010\u0001\u001a\u00020\u00042\u0006\u00109\u001a\u0002082\u000b\b\u0002\u0010\u0001\u001a\u0004\u0018\u00010\bH\u0001¢\u0006\u0006\b\u0001\u0010\u0001J&\u0010\u0001\u001a\u00020\u00042\b\u0010\u001e\u001a\u0004\u0018\u00010\b2\u0007\u0010\u0001\u001a\u00020\u0018H\u0001¢\u0006\u0006\b\u0001\u0010\u0001J\u001c\u0010\u0001\u001a\u00020\u00042\b\u0010 \u001a\u0004\u0018\u00010\bH\u0001¢\u0006\u0005\b\u0001\u0010\u000bJ'\u0010\u0001\u001a\u00020\u00042\b\u0010a\u001a\u0004\u0018\u00010\b2\b\u0010\u0001\u001a\u00030\u0001H\u0001¢\u0006\u0006\b\u0001\u0010\u0001J'\u0010\u0001\u001a\u00020\u00042\b\u0010\"\u001a\u0004\u0018\u00010\b2\b\u0010\u0001\u001a\u00030\u0001H\u0001¢\u0006\u0006\b\u0001\u0010\u0001J\u001d\u0010\u0001\u001a\u00020\u00042\t\u0010\u0001\u001a\u0004\u0018\u00010\bH\u0001¢\u0006\u0005\b\u0001\u0010\u000bJ\u001d\u0010\u0001\u001a\u00020\u00042\t\u0010\u0001\u001a\u0004\u0018\u00010\bH\u0001¢\u0006\u0005\b\u0001\u0010\u000bJ\u001a\u0010\u0001\u001a\u00020\u00042\u0006\u0010w\u001a\u00020\u0018H\u0001¢\u0006\u0005\b\u0001\u0010\u001bJ\u001c\u0010\u0001\u001a\u00020\u00042\b\u0010}\u001a\u0004\u0018\u00010\bH\u0001¢\u0006\u0005\b\u0001\u0010\u000bJ\u001b\u0010\u0001\u001a\u00020\u00042\u0007\u0010\u0001\u001a\u00020\u0018H\u0001¢\u0006\u0005\b\u0001\u0010\u001bJ\u001b\u0010\u0001\u001a\u00020\u00042\u0007\u0010\u0001\u001a\u00020\u0018H\u0001¢\u0006\u0005\b\u0001\u0010\u001bJ\u001b\u0010\u0001\u001a\u00020\u00042\u0007\u0010\u0001\u001a\u00020/H\u0001¢\u0006\u0005\b\u0001\u0010>R\u001a\u0010¡\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010 \u0001R$\u0010¦\u0001\u001a\r £\u0001*\u0005\u0018\u00010¢\u00010¢\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b¤\u0001\u0010¥\u0001RB\u0010ª\u0001\u001a+\u0012\r\u0012\u000b £\u0001*\u0004\u0018\u00010\u00040\u0004 £\u0001*\u0014\u0012\r\u0012\u000b £\u0001*\u0004\u0018\u00010\u00040\u0004\u0018\u00010§\u00010§\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b¨\u0001\u0010©\u0001R\u001a\u0010¬\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b«\u0001\u0010 \u0001R$\u0010°\u0001\u001a\r £\u0001*\u0005\u0018\u00010­\u00010­\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b®\u0001\u0010¯\u0001R\u001c\u0010´\u0001\u001a\u0005\u0018\u00010±\u00018\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b²\u0001\u0010³\u0001R\u001f\u0010·\u0001\u001a\b\u0012\u0004\u0012\u00020\u00040&8\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bµ\u0001\u0010¶\u0001RB\u0010¹\u0001\u001a+\u0012\r\u0012\u000b £\u0001*\u0004\u0018\u00010\u00040\u0004 £\u0001*\u0014\u0012\r\u0012\u000b £\u0001*\u0004\u0018\u00010\u00040\u0004\u0018\u00010§\u00010§\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b¸\u0001\u0010©\u0001R\u001f\u0010»\u0001\u001a\b\u0012\u0004\u0012\u00020\u00040&8\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bº\u0001\u0010¶\u0001R\u001a\u0010¿\u0001\u001a\u00030¼\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b½\u0001\u0010¾\u0001R\u001a\u0010Ã\u0001\u001a\u00030À\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\bÁ\u0001\u0010Â\u0001¨\u0006Ï\u0001"}, d2 = {"Lcom/avito/android/notification_center/landing/share/NotificationCenterLandingShareView$Impl;", "Lcom/avito/android/notification_center/landing/share/NotificationCenterLandingShareView;", "Lru/avito/component/appbar/AppBar;", "Lru/avito/component/serp/SerpAdvertListCard;", "", "showProgress", "()V", "showContent", "", "error", "showError", "(Ljava/lang/String;)V", "showMessage", "message", "showProgressDialog", "hideProgressDialog", "Lcom/avito/android/remote/model/Image;", "image", "setImage", "(Lcom/avito/android/remote/model/Image;)V", "title", "setTitle", "description", "setDescription", "", "isVisible", "setAdvertVisible", "(Z)V", "setAdvertImage", "setAdvertTitle", "price", "setAdvertPrice", "priceWithoutDiscount", "setAdvertPriceWithoutDiscount", "location", "setAdvertLocation", "text", "setActionButtonText", "Lio/reactivex/Observable;", "getActionButtonClicks", "()Lio/reactivex/Observable;", "getBackButtonClicks", "getCancelDialogClicks", "getRetryButtonClicks", "hideActionsMenu", "()Z", "Lio/reactivex/rxjava3/core/Observable;", "", "menuCallbacks", "()Lio/reactivex/rxjava3/core/Observable;", "navigationCallbacks", "itemPosition", "icon", "tintColorAttr", "setActionMenuItemIcon", "(IILjava/lang/Integer;)V", "Lcom/avito/android/image_loader/Picture;", "picture", "setIcon", "(Lcom/avito/android/image_loader/Picture;)V", "menuId", "setMenu", "(I)V", "menuTintColor", "setMenuTintColor", "menuTintColorAttr", "setMenuTintColorAttr", "drawableRes", "tintColorAttrId", "setNavigationIcon", "(ILjava/lang/Integer;)V", "visible", "setShadowVisible", "", "(Ljava/lang/CharSequence;)V", "stringRes", "setVisible", "", "Lcom/avito/android/util/ActionMenu;", "actions", "showActionsMenu", "(Ljava/util/List;)V", "showToolbar", "Lcom/avito/android/remote/model/badge_bar/SerpBadge;", "badges", "Lcom/avito/android/lib/expected/badge_bar/BadgeViewListener;", "badgeListener", "bindBadgeBar", "(Ljava/util/List;Lcom/avito/android/lib/expected/badge_bar/BadgeViewListener;)V", "Landroid/net/Uri;", "getPictureUri", "(Lcom/avito/android/image_loader/Picture;)Landroid/net/Uri;", "hideBadge", "active", "setActive", "setAdditionalActionText", "setAdditionalName", IntegrityManager.INTEGRITY_TYPE_ADDRESS, "setAddress", "Lcom/avito/android/remote/model/badge/Badge;", "badge", "setBadge", "(Lcom/avito/android/remote/model/badge/Badge;)V", "oldPrice", "setClassifiedDiscount", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setClickListener", "(Lkotlin/jvm/functions/Function0;)V", "", "time", "setDate", "(J)V", "isShowDelivery", "setDeliveryVisible", Sort.DISTANCE, "setDistance", "favorite", "setFavorite", "enabled", "setFavoriteButtonEnabled", "setFavoriteVisible", "setFavoritesButtonImageResource", "hasVideo", "setHasVideo", "value", "setInStock", "setLocation", "Lcom/avito/android/remote/model/RadiusInfo;", "radiusInfo", "setLocationPostponed", "(Ljava/lang/String;Lcom/avito/android/remote/model/RadiusInfo;)V", "discountPercentage", "setMarketplaceDiscount", "(Ljava/lang/String;Ljava/lang/String;)V", "setOnAdditionalActionClickListener", "setOnFavoriteButtonClickListener", BookingInfoActivity.EXTRA_ITEM_ID, "setPicture", "(Lcom/avito/android/image_loader/Picture;Ljava/lang/String;)V", "isHighlighted", "setPrice", "(Ljava/lang/String;Z)V", "setPriceWithoutDiscount", "setRadiusAddress", "setRadiusLocation", "shopName", "setShopName", "tag", "setShortTermRentTag", "setTitleRightMarginEnabled", "setTrustFactor", "enlarged", "setVideoIconEnlarged", "viewed", "setViewed", "widthPx", "setWidth", "Lru/avito/component/text/TextImpl;", "h", "Lru/avito/component/text/TextImpl;", "descriptionView", "Landroid/view/View;", "kotlin.jvm.PlatformType", "e", "Landroid/view/View;", "advertView", "Lcom/jakewharton/rxrelay2/PublishRelay;", AuthSource.SEND_ABUSE, "Lcom/jakewharton/rxrelay2/PublishRelay;", "actionRelay", g.a, "titleView", "Lcom/facebook/drawee/view/SimpleDraweeView;", "j", "Lcom/facebook/drawee/view/SimpleDraweeView;", "imageView", "Landroid/app/Dialog;", "k", "Landroid/app/Dialog;", "dialog", AuthSource.BOOKING_ORDER, "Lio/reactivex/Observable;", "backRelay", "c", "cancelRelay", "d", "retryRelay", "Lru/avito/component/button/ButtonImpl;", "i", "Lru/avito/component/button/ButtonImpl;", "buttonView", "Lcom/avito/android/progress_overlay/ProgressOverlay;", "f", "Lcom/avito/android/progress_overlay/ProgressOverlay;", "progressOverlay", "Lcom/avito/android/analytics/Analytics;", "analytics", "Ljava/util/Locale;", "locale", "Lcom/avito/android/server_time/TimeSource;", "timeSource", "view", "Lcom/avito/android/connection_quality/connectivity/ConnectivityProvider;", "connectivityProvider", "<init>", "(Lcom/avito/android/analytics/Analytics;Ljava/util/Locale;Lcom/avito/android/server_time/TimeSource;Landroid/view/View;Lcom/avito/android/connection_quality/connectivity/ConnectivityProvider;)V", "notification-center_release"}, k = 1, mv = {1, 4, 2})
    public static final class Impl implements NotificationCenterLandingShareView, AppBar, SerpAdvertListCard {
        public final PublishRelay<Unit> a = PublishRelay.create();
        public final Observable<Unit> b;
        public final PublishRelay<Unit> c = PublishRelay.create();
        public final Observable<Unit> d;
        public final View e;
        public final ProgressOverlay f;
        public final TextImpl g;
        public final TextImpl h;
        public final ButtonImpl i;
        public final SimpleDraweeView j;
        public Dialog k;
        public final /* synthetic */ AppBarImpl l;
        public final /* synthetic */ SerpAdvertListCardImpl m;

        public static final class a extends Lambda implements Function0<Unit> {
            public final /* synthetic */ Impl a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(Impl impl) {
                super(0);
                this.a = impl;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function0
            public Unit invoke() {
                PublishRelay publishRelay = this.a.a;
                Unit unit = Unit.INSTANCE;
                publishRelay.accept(unit);
                return unit;
            }
        }

        public static final class b implements DialogInterface.OnCancelListener {
            public final /* synthetic */ Impl a;

            public b(Impl impl) {
                this.a = impl;
            }

            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                LastClick.Updater.update();
                this.a.hideProgressDialog();
                this.a.c.accept(Unit.INSTANCE);
            }
        }

        public Impl(@NotNull Analytics analytics, @NotNull Locale locale, @NotNull TimeSource timeSource, @NotNull View view, @NotNull ConnectivityProvider connectivityProvider) {
            Intrinsics.checkNotNullParameter(analytics, "analytics");
            Intrinsics.checkNotNullParameter(locale, "locale");
            Intrinsics.checkNotNullParameter(timeSource, "timeSource");
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(connectivityProvider, "connectivityProvider");
            int i2 = R.id.content;
            View findViewById = view.findViewById(i2);
            Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.view.View");
            this.l = new AppBarImpl(view, findViewById, false, 4, null);
            this.m = new SerpAdvertListCardImpl(view, timeSource, locale, null, connectivityProvider, 8, null);
            this.e = view.findViewById(R.id.advert_list_root);
            View findViewById2 = view.findViewById(R.id.content_holder);
            Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.view.ViewGroup");
            ProgressOverlay progressOverlay = new ProgressOverlay((ViewGroup) findViewById2, i2, analytics, false, 0, 24, null);
            this.f = progressOverlay;
            View findViewById3 = view.findViewById(R.id.screen_title);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.screen_title)");
            this.g = new TextImpl(findViewById3);
            View findViewById4 = view.findViewById(R.id.description);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById(R.id.description)");
            this.h = new TextImpl(findViewById4);
            View findViewById5 = view.findViewById(R.id.button);
            Intrinsics.checkNotNullExpressionValue(findViewById5, "view.findViewById(R.id.button)");
            ButtonImpl buttonImpl = new ButtonImpl(findViewById5);
            this.i = buttonImpl;
            this.j = (SimpleDraweeView) view.findViewById(R.id.screen_image);
            AppBar.DefaultImpls.setNavigationIcon$default(this, com.avito.android.ui_components.R.drawable.ic_back_24_blue, null, 2, null);
            this.b = InteropKt.toV2(navigationCallbacks());
            this.d = progressOverlay.refreshes();
            buttonImpl.setClickListener(new a(this));
        }

        @Override // ru.avito.component.serp.SerpAdvertListCard
        public void bindBadgeBar(@Nullable List<SerpBadge> list, @Nullable BadgeViewListener badgeViewListener) {
            this.m.bindBadgeBar(list, badgeViewListener);
        }

        @Override // com.avito.android.notification_center.landing.share.NotificationCenterLandingShareView
        @NotNull
        public Observable<Unit> getActionButtonClicks() {
            PublishRelay<Unit> publishRelay = this.a;
            Intrinsics.checkNotNullExpressionValue(publishRelay, "actionRelay");
            return publishRelay;
        }

        @Override // com.avito.android.notification_center.landing.share.NotificationCenterLandingShareView
        @NotNull
        public Observable<Unit> getBackButtonClicks() {
            return this.b;
        }

        @Override // com.avito.android.notification_center.landing.share.NotificationCenterLandingShareView
        @NotNull
        public Observable<Unit> getCancelDialogClicks() {
            PublishRelay<Unit> publishRelay = this.c;
            Intrinsics.checkNotNullExpressionValue(publishRelay, "cancelRelay");
            return publishRelay;
        }

        @Override // ru.avito.component.serp.SerpAdvertListCard
        @NotNull
        public Uri getPictureUri(@NotNull Picture picture) {
            Intrinsics.checkNotNullParameter(picture, "picture");
            return this.m.getPictureUri(picture);
        }

        @Override // com.avito.android.notification_center.landing.share.NotificationCenterLandingShareView
        @NotNull
        public Observable<Unit> getRetryButtonClicks() {
            return this.d;
        }

        @Override // ru.avito.component.appbar.AppBar
        public void hideActionsMenu() {
            this.l.hideActionsMenu();
        }

        @Override // ru.avito.component.serp.SerpAdvertListCard
        public void hideBadge() {
            this.m.hideBadge();
        }

        @Override // com.avito.android.notification_center.landing.share.NotificationCenterLandingShareView
        public void hideProgressDialog() {
            Dialog dialog = this.k;
            if (dialog != null) {
                dialog.setOnCancelListener(null);
                dialog.dismiss();
            }
            this.k = null;
        }

        @Override // ru.avito.component.appbar.AppBar
        public boolean isVisible() {
            return this.l.isVisible();
        }

        @Override // ru.avito.component.appbar.AppBar
        @NotNull
        public io.reactivex.rxjava3.core.Observable<Integer> menuCallbacks() {
            return this.l.menuCallbacks();
        }

        @Override // ru.avito.component.appbar.AppBar
        @NotNull
        public io.reactivex.rxjava3.core.Observable<Unit> navigationCallbacks() {
            return this.l.navigationCallbacks();
        }

        @Override // com.avito.android.notification_center.landing.share.NotificationCenterLandingShareView
        public void setActionButtonText(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "text");
            this.i.setText(str);
        }

        @Override // ru.avito.component.appbar.AppBar
        public void setActionMenuItemIcon(int i2, @DrawableRes int i3, @AttrRes @Nullable Integer num) {
            this.l.setActionMenuItemIcon(i2, i3, num);
        }

        @Override // ru.avito.component.serp.SerpAdvertListCard
        public void setActive(boolean z) {
            this.m.setActive(z);
        }

        @Override // ru.avito.component.serp.SerpAdvertListCard
        public void setAdditionalActionText(@Nullable String str) {
            this.m.setAdditionalActionText(str);
        }

        @Override // ru.avito.component.serp.SerpAdvertListCard
        public void setAdditionalName(@Nullable String str) {
            this.m.setAdditionalName(str);
        }

        @Override // ru.avito.component.serp.SerpAdvertListCard
        public void setAddress(@Nullable String str) {
            this.m.setAddress(str);
        }

        @Override // com.avito.android.notification_center.landing.share.NotificationCenterLandingShareView
        public void setAdvertImage(@Nullable Image image) {
            SerpAdvertListCard.DefaultImpls.setPicture$default(this, AvitoPictureKt.pictureOf$default(image, false, 0.0f, 0.0f, null, 28, null), null, 2, null);
        }

        @Override // com.avito.android.notification_center.landing.share.NotificationCenterLandingShareView
        public void setAdvertLocation(@Nullable String str) {
            setAddress(str);
        }

        @Override // com.avito.android.notification_center.landing.share.NotificationCenterLandingShareView
        public void setAdvertPrice(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "price");
            setPrice(str, false);
        }

        @Override // com.avito.android.notification_center.landing.share.NotificationCenterLandingShareView
        public void setAdvertPriceWithoutDiscount(@Nullable String str) {
            setPriceWithoutDiscount(str);
        }

        @Override // com.avito.android.notification_center.landing.share.NotificationCenterLandingShareView
        public void setAdvertTitle(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "title");
            setTitle(str);
        }

        @Override // com.avito.android.notification_center.landing.share.NotificationCenterLandingShareView
        public void setAdvertVisible(boolean z) {
            if (z) {
                Views.show(this.e);
            } else {
                Views.hide(this.e);
            }
        }

        @Override // ru.avito.component.serp.SerpAdvertListCard
        public void setBadge(@NotNull Badge badge) {
            Intrinsics.checkNotNullParameter(badge, "badge");
            this.m.setBadge(badge);
        }

        @Override // ru.avito.component.serp.SerpAdvertListCard
        public void setClassifiedDiscount(@Nullable String str) {
            this.m.setClassifiedDiscount(str);
        }

        @Override // ru.avito.component.serp.SerpAdvertListCard
        public void setClickListener(@Nullable Function0<Unit> function0) {
            this.m.setClickListener(function0);
        }

        @Override // ru.avito.component.serp.SerpAdvertListCard
        public void setDate(long j2) {
            this.m.setDate(j2);
        }

        @Override // ru.avito.component.serp.SerpAdvertListCard
        public void setDeliveryVisible(boolean z) {
            this.m.setDeliveryVisible(z);
        }

        @Override // com.avito.android.notification_center.landing.share.NotificationCenterLandingShareView
        public void setDescription(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "description");
            this.h.setText(str);
        }

        @Override // ru.avito.component.serp.SerpAdvertListCard
        public void setDistance(@Nullable String str) {
            this.m.setDistance(str);
        }

        @Override // ru.avito.component.serp.SerpAdvertListCard
        public void setFavorite(boolean z) {
            this.m.setFavorite(z);
        }

        @Override // ru.avito.component.serp.SerpAdvertListCard
        public void setFavoriteButtonEnabled(boolean z) {
            this.m.setFavoriteButtonEnabled(z);
        }

        @Override // ru.avito.component.serp.SerpAdvertListCard
        public void setFavoriteVisible(boolean z) {
            this.m.setFavoriteVisible(z);
        }

        @Override // ru.avito.component.serp.SerpAdvertListCard
        public void setFavoritesButtonImageResource() {
            this.m.setFavoritesButtonImageResource();
        }

        @Override // ru.avito.component.serp.SerpAdvertListCard
        public void setHasVideo(boolean z) {
            this.m.setHasVideo(z);
        }

        @Override // ru.avito.component.appbar.AppBar
        public void setIcon(@Nullable Picture picture) {
            this.l.setIcon(picture);
        }

        @Override // com.avito.android.notification_center.landing.share.NotificationCenterLandingShareView
        public void setImage(@Nullable Image image) {
            if (image != null) {
                SimpleDraweeView simpleDraweeView = this.j;
                Intrinsics.checkNotNullExpressionValue(simpleDraweeView, "imageView");
                ImageContainer widthImageContainer = Images.fit$default(image, simpleDraweeView, 0.0f, 0.0f, 2, 6, null).getWidthImageContainer();
                if (widthImageContainer != null) {
                    Views.show(this.j);
                    Size size = widthImageContainer.getSize();
                    float width = ((float) size.getWidth()) / ((float) size.getHeight());
                    SimpleDraweeView simpleDraweeView2 = this.j;
                    Intrinsics.checkNotNullExpressionValue(simpleDraweeView2, "imageView");
                    SimpleDraweeViewsKt.getRequestBuilder(simpleDraweeView2).aspectRatio(width).uri(widthImageContainer.getUri()).load();
                    return;
                }
                Views.hide(this.j);
                return;
            }
            Views.hide(this.j);
        }

        @Override // ru.avito.component.serp.SerpAdvertListCard
        public void setInStock(@Nullable String str) {
            this.m.setInStock(str);
        }

        @Override // ru.avito.component.serp.SerpAdvertListCard
        public void setLocation(@Nullable String str) {
            this.m.setLocation(str);
        }

        @Override // ru.avito.component.serp.SerpAdvertListCard
        public void setLocationPostponed(@Nullable String str, @Nullable RadiusInfo radiusInfo) {
            this.m.setLocationPostponed(str, radiusInfo);
        }

        @Override // ru.avito.component.serp.SerpAdvertListCard
        public void setMarketplaceDiscount(@Nullable String str, @Nullable String str2) {
            this.m.setMarketplaceDiscount(str, str2);
        }

        @Override // ru.avito.component.appbar.AppBar
        public void setMenu(@MenuRes int i2) {
            this.l.setMenu(i2);
        }

        @Override // ru.avito.component.appbar.AppBar
        public void setMenuTintColor(@ColorRes int i2) {
            this.l.setMenuTintColor(i2);
        }

        @Override // ru.avito.component.appbar.AppBar
        public void setMenuTintColorAttr(@AttrRes int i2) {
            this.l.setMenuTintColorAttr(i2);
        }

        @Override // ru.avito.component.appbar.AppBar
        public void setNavigationIcon(@DrawableRes int i2, @AttrRes @Nullable Integer num) {
            this.l.setNavigationIcon(i2, num);
        }

        @Override // ru.avito.component.serp.SerpAdvertListCard
        public void setOnAdditionalActionClickListener(@Nullable Function0<Unit> function0) {
            this.m.setOnAdditionalActionClickListener(function0);
        }

        @Override // ru.avito.component.serp.SerpAdvertListCard
        public void setOnFavoriteButtonClickListener(@Nullable Function0<Unit> function0) {
            this.m.setOnFavoriteButtonClickListener(function0);
        }

        @Override // ru.avito.component.serp.SerpAdvertListCard
        public void setPicture(@NotNull Picture picture, @Nullable String str) {
            Intrinsics.checkNotNullParameter(picture, "picture");
            this.m.setPicture(picture, str);
        }

        @Override // ru.avito.component.serp.SerpAdvertListCard
        public void setPrice(@Nullable String str, boolean z) {
            this.m.setPrice(str, z);
        }

        @Override // ru.avito.component.serp.SerpAdvertListCard
        public void setPriceWithoutDiscount(@Nullable String str) {
            this.m.setPriceWithoutDiscount(str);
        }

        @Override // ru.avito.component.serp.SerpAdvertListCard
        public void setRadiusAddress(@Nullable String str, @NotNull RadiusInfo radiusInfo) {
            Intrinsics.checkNotNullParameter(radiusInfo, "radiusInfo");
            this.m.setRadiusAddress(str, radiusInfo);
        }

        @Override // ru.avito.component.serp.SerpAdvertListCard
        public void setRadiusLocation(@Nullable String str, @NotNull RadiusInfo radiusInfo) {
            Intrinsics.checkNotNullParameter(radiusInfo, "radiusInfo");
            this.m.setRadiusLocation(str, radiusInfo);
        }

        @Override // ru.avito.component.appbar.AppBar
        public void setShadowVisible(boolean z) {
            this.l.setShadowVisible(z);
        }

        @Override // ru.avito.component.serp.SerpAdvertListCard
        public void setShopName(@Nullable String str) {
            this.m.setShopName(str);
        }

        @Override // ru.avito.component.serp.SerpAdvertListCard
        public void setShortTermRentTag(@Nullable String str) {
            this.m.setShortTermRentTag(str);
        }

        @Override // ru.avito.component.appbar.AppBar
        public void setTitle(@StringRes int i2) {
            this.l.setTitle(i2);
        }

        @Override // ru.avito.component.appbar.AppBar
        public void setTitle(@NotNull CharSequence charSequence) {
            Intrinsics.checkNotNullParameter(charSequence, "title");
            this.l.setTitle(charSequence);
        }

        @Override // com.avito.android.notification_center.landing.share.NotificationCenterLandingShareView, ru.avito.component.serp.SerpAdvertListCard
        public void setTitle(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "title");
            this.g.setText(str);
        }

        @Override // ru.avito.component.serp.SerpAdvertListCard
        public void setTitleRightMarginEnabled(boolean z) {
            this.m.setTitleRightMarginEnabled(z);
        }

        @Override // ru.avito.component.serp.SerpAdvertListCard
        public void setTrustFactor(@Nullable String str) {
            this.m.setTrustFactor(str);
        }

        @Override // ru.avito.component.serp.SerpAdvertListCard
        public void setVideoIconEnlarged(boolean z) {
            this.m.setVideoIconEnlarged(z);
        }

        @Override // ru.avito.component.serp.SerpAdvertListCard
        public void setViewed(boolean z) {
            this.m.setViewed(z);
        }

        @Override // ru.avito.component.appbar.AppBar
        public void setVisible(boolean z) {
            this.l.setVisible(z);
        }

        @Override // ru.avito.component.serp.SerpAdvertListCard
        public void setWidth(int i2) {
            this.m.setWidth(i2);
        }

        @Override // ru.avito.component.appbar.AppBar
        public void showActionsMenu(@NotNull List<ActionMenu> list) {
            Intrinsics.checkNotNullParameter(list, "actions");
            this.l.showActionsMenu(list);
        }

        @Override // com.avito.android.notification_center.landing.share.NotificationCenterLandingShareView
        public void showContent() {
            this.f.showContent();
        }

        @Override // com.avito.android.notification_center.landing.share.NotificationCenterLandingShareView
        public void showError(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "error");
            this.f.showLoadingProblem(str);
        }

        @Override // com.avito.android.notification_center.landing.share.NotificationCenterLandingShareView
        public void showMessage() {
            SimpleDraweeView simpleDraweeView = this.j;
            Intrinsics.checkNotNullExpressionValue(simpleDraweeView, "imageView");
            String string = simpleDraweeView.getResources().getString(com.avito.android.ui_components.R.string.something_went_wrong);
            Intrinsics.checkNotNullExpressionValue(string, "imageView.resources.getS…ing.something_went_wrong)");
            SimpleDraweeView simpleDraweeView2 = this.j;
            Intrinsics.checkNotNullExpressionValue(simpleDraweeView2, "imageView");
            Context context = simpleDraweeView2.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "imageView.context");
            ToastsKt.showToast$default(context, string, 0, 2, (Object) null);
        }

        @Override // com.avito.android.notification_center.landing.share.NotificationCenterLandingShareView
        public void showProgress() {
            this.f.showLoading();
        }

        @Override // com.avito.android.notification_center.landing.share.NotificationCenterLandingShareView
        public void showProgressDialog() {
            if (this.k == null) {
                SimpleDraweeView simpleDraweeView = this.j;
                Intrinsics.checkNotNullExpressionValue(simpleDraweeView, "imageView");
                Dialog showSimpleWaitingDialog = DialogUtils.showSimpleWaitingDialog(simpleDraweeView.getContext());
                Intrinsics.checkNotNullExpressionValue(showSimpleWaitingDialog, "DialogUtils.showSimpleWa…Dialog(imageView.context)");
                showSimpleWaitingDialog.setOnCancelListener(new b(this));
                this.k = showSimpleWaitingDialog;
            }
        }

        @Override // ru.avito.component.appbar.AppBar
        public void showToolbar() {
            this.l.showToolbar();
        }

        @Override // com.avito.android.notification_center.landing.share.NotificationCenterLandingShareView
        public void showError() {
            LoadingOverlay.DefaultImpls.showLoadingProblem$default(this.f, null, 1, null);
        }

        @Override // com.avito.android.notification_center.landing.share.NotificationCenterLandingShareView
        public void showMessage(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "message");
            SimpleDraweeView simpleDraweeView = this.j;
            Intrinsics.checkNotNullExpressionValue(simpleDraweeView, "imageView");
            Context context = simpleDraweeView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "imageView.context");
            ToastsKt.showToast$default(context, str, 0, 2, (Object) null);
        }
    }

    @NotNull
    Observable<Unit> getActionButtonClicks();

    @NotNull
    Observable<Unit> getBackButtonClicks();

    @NotNull
    Observable<Unit> getCancelDialogClicks();

    @NotNull
    Observable<Unit> getRetryButtonClicks();

    void hideProgressDialog();

    void setActionButtonText(@NotNull String str);

    void setAdvertImage(@Nullable Image image);

    void setAdvertLocation(@Nullable String str);

    void setAdvertPrice(@NotNull String str);

    void setAdvertPriceWithoutDiscount(@Nullable String str);

    void setAdvertTitle(@NotNull String str);

    void setAdvertVisible(boolean z);

    void setDescription(@NotNull String str);

    void setImage(@Nullable Image image);

    @Override // ru.avito.component.serp.SerpAdvertListCard
    void setTitle(@NotNull String str);

    void showContent();

    void showError();

    void showError(@NotNull String str);

    void showMessage();

    void showMessage(@NotNull String str);

    void showProgress();

    void showProgressDialog();
}
