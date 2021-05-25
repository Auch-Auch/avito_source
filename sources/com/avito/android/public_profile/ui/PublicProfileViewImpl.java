package com.avito.android.public_profile.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.DimenRes;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;
import com.avito.android.analytics.Analytics;
import com.avito.android.component.profile_toolbar.ProfileToolbar;
import com.avito.android.component.profile_toolbar.ProfileToolbarImpl;
import com.avito.android.component.user_hat.UserHat;
import com.avito.android.component.user_hat.UserHatImpl;
import com.avito.android.design.widget.tab.TabPagerAdapter;
import com.avito.android.image_loader.AvitoPictureKt;
import com.avito.android.lib.design.alert_banner.AlertBanner;
import com.avito.android.lib.design.dialog.Dialog;
import com.avito.android.lib.design.snackbar.SnackbarExtensionsKt;
import com.avito.android.lib.design.snackbar.SnackbarPosition;
import com.avito.android.lib.design.snackbar.SnackbarType;
import com.avito.android.progress_overlay.ProgressOverlay;
import com.avito.android.public_profile.remote.model.ProfileCounter;
import com.avito.android.public_profile_stuff.R;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.ErrorResult;
import com.avito.android.remote.model.Action;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.UserDialog;
import com.avito.android.remote.model.advert_details.UserIconType;
import com.avito.android.ui.adapter.tab.TabAdapter;
import com.avito.android.util.MenuItemsKt;
import com.avito.android.util.TabLayoutsKt;
import com.avito.android.util.TextViews;
import com.avito.android.util.Toolbars;
import com.avito.android.util.Views;
import com.avito.android.util.rx3.InteropKt;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;
import com.jakewharton.rxbinding3.view.RxMenuItem;
import com.jakewharton.rxrelay3.PublishRelay;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Observable;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003BF\u0012\u0007\u0010°\u0001\u001a\u00020!\u0012\u0006\u0010x\u001a\u00020u\u0012\u0010\u0010®\u0001\u001a\u000b\u0012\u0002\b\u0003\u0012\u0002\b\u00030«\u0001\u0012\u0006\u0010|\u001a\u00020y\u0012\u0006\u0010\u001a\u00020\u0003\u0012\b\u0010²\u0001\u001a\u00030±\u0001¢\u0006\u0006\b³\u0001\u0010´\u0001J!\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0010\u0010\fJ\u0017\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0014\u0010\fJ%\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00152\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\b0\u0017H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001b\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001b\u0010\u0013J\u0017\u0010\u001c\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001c\u0010\u0013J1\u0010#\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\u001d2\b\u0010\u001f\u001a\u0004\u0018\u00010\u00042\u000e\u0010\"\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010 H\u0016¢\u0006\u0004\b#\u0010$J\u000f\u0010%\u001a\u00020\bH\u0016¢\u0006\u0004\b%\u0010\fJ\u0017\u0010'\u001a\u00020\b2\u0006\u0010&\u001a\u00020\u0004H\u0016¢\u0006\u0004\b'\u0010\u0013J+\u0010-\u001a\u00020\b2\b\u0010)\u001a\u0004\u0018\u00010(2\b\u0010*\u001a\u0004\u0018\u00010\u00042\u0006\u0010,\u001a\u00020+H\u0016¢\u0006\u0004\b-\u0010.J\u0019\u00100\u001a\u00020\b2\b\u0010/\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b0\u0010\u0013J\u0019\u00102\u001a\u00020\b2\b\u00101\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b2\u0010\u0013J!\u00107\u001a\u00020\b2\u0006\u00104\u001a\u0002032\b\u00106\u001a\u0004\u0018\u000105H\u0016¢\u0006\u0004\b7\u00108J\u000f\u00109\u001a\u00020\bH\u0016¢\u0006\u0004\b9\u0010\fJ\u0017\u0010;\u001a\u00020\b2\u0006\u0010:\u001a\u00020\u0006H\u0016¢\u0006\u0004\b;\u0010<J\u001d\u0010=\u001a\u00020\b2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\b0\u0017H\u0016¢\u0006\u0004\b=\u0010>J\u001d\u0010?\u001a\u00020\b2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\b0\u0017H\u0016¢\u0006\u0004\b?\u0010>J\u0015\u0010A\u001a\b\u0012\u0004\u0012\u00020\b0@H\u0016¢\u0006\u0004\bA\u0010BJ\u000f\u0010C\u001a\u00020\bH\u0016¢\u0006\u0004\bC\u0010\fJ\u000f\u0010D\u001a\u00020\bH\u0016¢\u0006\u0004\bD\u0010\fJY\u0010M\u001a\u00020\b2\u0006\u0010*\u001a\u00020\u00042\u0006\u0010E\u001a\u00020\u00062\b\u0010F\u001a\u0004\u0018\u00010\u00042\u0006\u0010G\u001a\u00020\u00062\u000e\u0010H\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00172\u0006\u0010I\u001a\u00020\u00062\u0006\u0010K\u001a\u00020J2\u0006\u00104\u001a\u00020LH\u0016¢\u0006\u0004\bM\u0010NJ\u000f\u0010O\u001a\u00020\bH\u0016¢\u0006\u0004\bO\u0010\fJ\u000f\u0010P\u001a\u00020\bH\u0016¢\u0006\u0004\bP\u0010\fJ\u001a\u0010S\u001a\u00020\b2\b\u0010R\u001a\u0004\u0018\u00010QH\u0001¢\u0006\u0004\bS\u0010TJ\u001a\u0010U\u001a\u00020\b2\b\u0010R\u001a\u0004\u0018\u00010QH\u0001¢\u0006\u0004\bU\u0010TJ\u0010\u0010V\u001a\u00020+H\u0001¢\u0006\u0004\bV\u0010WJ\u0010\u0010X\u001a\u00020+H\u0001¢\u0006\u0004\bX\u0010WJ\u0016\u0010Y\u001a\b\u0012\u0004\u0012\u00020\b0@H\u0001¢\u0006\u0004\bY\u0010BJ\u0010\u0010Z\u001a\u00020\bH\u0001¢\u0006\u0004\bZ\u0010\fJ\u0010\u0010[\u001a\u00020+H\u0001¢\u0006\u0004\b[\u0010WJ\u0016\u0010\\\u001a\b\u0012\u0004\u0012\u00020\b0@H\u0001¢\u0006\u0004\b\\\u0010BJ\u0010\u0010]\u001a\u00020\bH\u0001¢\u0006\u0004\b]\u0010\fJ\u0018\u0010_\u001a\u00020\b2\u0006\u0010^\u001a\u00020+H\u0001¢\u0006\u0004\b_\u0010`J\u0018\u0010b\u001a\u00020\b2\u0006\u0010a\u001a\u00020+H\u0001¢\u0006\u0004\bb\u0010`J\u0018\u0010c\u001a\u00020\b2\u0006\u0010a\u001a\u00020+H\u0001¢\u0006\u0004\bc\u0010`J \u0010f\u001a\u00020\b2\u0006\u0010d\u001a\u00020+2\u0006\u0010e\u001a\u00020+H\u0001¢\u0006\u0004\bf\u0010gJ\u0018\u0010h\u001a\u00020\b2\u0006\u0010a\u001a\u00020+H\u0001¢\u0006\u0004\bh\u0010`J\u0016\u0010j\u001a\b\u0012\u0004\u0012\u00020\b0iH\u0001¢\u0006\u0004\bj\u0010kJ\u0018\u0010l\u001a\u00020\b2\u0006\u0010*\u001a\u00020\u0004H\u0001¢\u0006\u0004\bl\u0010\u0013J\u0016\u0010m\u001a\b\u0012\u0004\u0012\u00020\b0@H\u0001¢\u0006\u0004\bm\u0010BR\u0016\u0010p\u001a\u00020!8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bn\u0010oR\u0016\u0010t\u001a\u00020q8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\br\u0010sR\u0016\u0010x\u001a\u00020u8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bv\u0010wR\u0016\u0010|\u001a\u00020y8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bz\u0010{R\u0016\u0010\u001a\u00020\u00038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b}\u0010~R\u001c\u0010\u0001\u001a\u0005\u0018\u00010\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u0019\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b\t\u0010\u0001R\u0017\u0010\u0001\u001a\u00020!8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010oR\u0018\u0010\u0001\u001a\u00020!8\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b\u0001\u0010oR\u001e\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020\b0@8\u0016@\u0016X\u0005¢\u0006\u0007\u001a\u0005\b\u0001\u0010BR\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R#\u0010\u0001\u001a\r \u0001*\u0005\u0018\u00010\u00010\u00018\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b\u000e\u0010\u0001R\u001b\u0010\u001e\u001a\u0005\u0018\u00010 \u00018\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b¡\u0001\u0010¢\u0001R\u001a\u0010¦\u0001\u001a\u00030£\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b¤\u0001\u0010¥\u0001R\u001a\u0010ª\u0001\u001a\u00030§\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b¨\u0001\u0010©\u0001R\"\u0010®\u0001\u001a\u000b\u0012\u0002\b\u0003\u0012\u0002\b\u00030«\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b¬\u0001\u0010­\u0001R\u0018\u0010°\u0001\u001a\u00020!8\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b¯\u0001\u0010o¨\u0006µ\u0001"}, d2 = {"Lcom/avito/android/public_profile/ui/PublicProfileViewImpl;", "Lcom/avito/android/public_profile/ui/PublicProfileView;", "Lcom/avito/android/public_profile/ui/SubscriptionsCounterView;", "Lcom/avito/android/public_profile/ui/SubscribeButtonsView;", "", "message", "", "maxWidthRes", "", "c", "(Ljava/lang/String;I)V", AuthSource.BOOKING_ORDER, "()V", "Landroid/view/MenuItem;", AuthSource.SEND_ABUSE, "()Landroid/view/MenuItem;", "showProgress", "error", "showError", "(Ljava/lang/String;)V", "showContent", "Lcom/avito/android/remote/error/ErrorResult$ErrorDialog;", "errorDialog", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "showErrorDialog", "(Lcom/avito/android/remote/error/ErrorResult$ErrorDialog;Lkotlin/jvm/functions/Function0;)V", "showUserBanned", "showUserRemoved", "Lcom/avito/android/remote/model/UserDialog;", "dialog", "actionTitle", "Lcom/jakewharton/rxrelay3/PublishRelay;", "Landroid/view/View;", "action", "showBlockedAdvertsAlertBanner", "(Lcom/avito/android/remote/model/UserDialog;Ljava/lang/String;Lcom/jakewharton/rxrelay3/PublishRelay;)V", "hideBlockedAdvertsAlertBanner", "name", "showName", "", "score", "text", "", "clickable", "showRating", "(Ljava/lang/Float;Ljava/lang/String;Z)V", MessengerShareContentUtility.SUBTITLE, "showSubtitle", "value", "showConnections", "Lcom/avito/android/remote/model/advert_details/UserIconType;", "type", "Lcom/avito/android/remote/model/Image;", "avatar", "showAvatar", "(Lcom/avito/android/remote/model/advert_details/UserIconType;Lcom/avito/android/remote/model/Image;)V", "onTabsChanged", "activeTab", "setActiveTab", "(I)V", "setRatingClickListener", "(Lkotlin/jvm/functions/Function0;)V", "setAvatarClickListener", "Lio/reactivex/rxjava3/core/Observable;", "shareButtonClicks", "()Lio/reactivex/rxjava3/core/Observable;", "showShareButton", "hideShareButton", "textResId", "actionText", "actionTextResId", "onActionClick", "duration", "Lcom/avito/android/lib/design/snackbar/SnackbarPosition;", VKApiConst.POSITION, "Lcom/avito/android/lib/design/snackbar/SnackbarType;", "showSnackbar", "(Ljava/lang/String;ILjava/lang/String;ILkotlin/jvm/functions/Function0;ILcom/avito/android/lib/design/snackbar/SnackbarPosition;Lcom/avito/android/lib/design/snackbar/SnackbarType;)V", "showAdverts", "hideAdverts", "Lcom/avito/android/public_profile/remote/model/ProfileCounter;", "counter", "bindSubscribersCounter", "(Lcom/avito/android/public_profile/remote/model/ProfileCounter;)V", "bindSubscriptionsCounter", "canShowSnackbar", "()Z", "closeSubscriptionSettings", "dismissEvents", "hideSubscribeButton", "isMenuShowing", "notificationClicks", "openSubscriptionSettings", "isActivated", "setNotificationActivated", "(Z)V", "isLoading", "setNotificationLoading", "setSubscribeLoading", "isSubscribed", "isEnabled", "setSubscribed", "(ZZ)V", "setUnsubscribeLoading", "Lio/reactivex/rxjava3/core/Maybe;", "showEnableNotificationDialog", "()Lio/reactivex/rxjava3/core/Maybe;", "showSubscribeButton", "unsubscribeClicks", "k", "Landroid/view/View;", "stubContainer", "Lcom/avito/android/component/user_hat/UserHat;", a2.g.r.g.a, "Lcom/avito/android/component/user_hat/UserHat;", "userHat", "Lcom/avito/android/public_profile/ui/PublicProfilePresenter;", "p", "Lcom/avito/android/public_profile/ui/PublicProfilePresenter;", "presenter", "Lcom/avito/android/design/widget/tab/TabPagerAdapter;", "r", "Lcom/avito/android/design/widget/tab/TabPagerAdapter;", "pagerAdapter", "s", "Lcom/avito/android/public_profile/ui/SubscribeButtonsView;", "subscribeButtonsView", "Lcom/google/android/material/appbar/AppBarLayout;", "d", "Lcom/google/android/material/appbar/AppBarLayout;", "appBar", "Lcom/google/android/material/tabs/TabLayout;", "h", "Lcom/google/android/material/tabs/TabLayout;", "tabLayout", "Lcom/avito/android/progress_overlay/ProgressOverlay;", "Lcom/avito/android/progress_overlay/ProgressOverlay;", "progressOverlay", "contentView", "j", "ratingContainer", "getSubscribeButtonClicks", "subscribeButtonClicks", "Landroidx/viewpager/widget/ViewPager;", "i", "Landroidx/viewpager/widget/ViewPager;", "viewPager", "Lcom/avito/android/lib/design/alert_banner/AlertBanner;", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/android/lib/design/alert_banner/AlertBanner;", "alertBanner", "Lcom/avito/android/component/profile_toolbar/ProfileToolbar;", "e", "Lcom/avito/android/component/profile_toolbar/ProfileToolbar;", "profileToolbar", "Landroid/content/res/Resources;", "kotlin.jvm.PlatformType", "Landroid/content/res/Resources;", "resources", "Lcom/avito/android/lib/design/dialog/Dialog;", "n", "Lcom/avito/android/lib/design/dialog/Dialog;", "Landroidx/appcompat/widget/Toolbar;", "f", "Landroidx/appcompat/widget/Toolbar;", "toolbar", "Landroid/widget/TextView;", "l", "Landroid/widget/TextView;", "stubText", "Lcom/avito/android/ui/adapter/tab/TabAdapter;", VKApiConst.Q, "Lcom/avito/android/ui/adapter/tab/TabAdapter;", "tabsAdapter", "o", "view", "Lcom/avito/android/analytics/Analytics;", "analytics", "<init>", "(Landroid/view/View;Lcom/avito/android/public_profile/ui/PublicProfilePresenter;Lcom/avito/android/ui/adapter/tab/TabAdapter;Lcom/avito/android/design/widget/tab/TabPagerAdapter;Lcom/avito/android/public_profile/ui/SubscribeButtonsView;Lcom/avito/android/analytics/Analytics;)V", "public-profile_release"}, k = 1, mv = {1, 4, 2})
public final class PublicProfileViewImpl implements PublicProfileView, SubscriptionsCounterView, SubscribeButtonsView {
    public final Resources a;
    public final View b;
    public ProgressOverlay c;
    public final AppBarLayout d;
    public final ProfileToolbar e;
    public final Toolbar f;
    public final UserHat g;
    public final TabLayout h;
    public final ViewPager i;
    public final View j;
    public final View k;
    public final TextView l;
    public final AlertBanner m;
    public Dialog n;
    public final View o;
    public final PublicProfilePresenter p;
    public final TabAdapter<?, ?> q;
    public final TabPagerAdapter r;
    public final SubscribeButtonsView s;
    public final /* synthetic */ SubscriptionsCounterViewImpl t;

    public static final class a implements AppBarLayout.OnOffsetChangedListener {
        public final /* synthetic */ PublicProfileViewImpl a;
        public final /* synthetic */ View b;

        public a(PublicProfileViewImpl publicProfileViewImpl, View view) {
            this.a = publicProfileViewImpl;
            this.b = view;
        }

        @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
        public final void onOffsetChanged(AppBarLayout appBarLayout, int i) {
            ProfileToolbar.DefaultImpls.setContentVisible$default(this.a.e, ((float) Math.abs(i)) >= this.b.getY() + ((float) this.b.getHeight()), false, 2, null);
        }
    }

    public static final class b extends Lambda implements Function0<Unit> {
        public final /* synthetic */ PublicProfileViewImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(PublicProfileViewImpl publicProfileViewImpl) {
            super(0);
            this.a = publicProfileViewImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.p.onRetryClicked();
            return Unit.INSTANCE;
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ PublicProfileViewImpl a;

        public c(PublicProfileViewImpl publicProfileViewImpl) {
            this.a = publicProfileViewImpl;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.p.onBackClicked();
        }
    }

    public static final class d extends Lambda implements Function0<Unit> {
        public final /* synthetic */ Function0 a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(Function0 function0) {
            super(0);
            this.a = function0;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.invoke();
            return Unit.INSTANCE;
        }
    }

    public static final class e implements View.OnClickListener {
        public final /* synthetic */ Function0 a;

        public e(Function0 function0) {
            this.a = function0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.invoke();
        }
    }

    public static final class f implements View.OnClickListener {
        public final /* synthetic */ PublishRelay a;

        public f(PublicProfileViewImpl publicProfileViewImpl, String str, PublishRelay publishRelay) {
            this.a = publishRelay;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.accept(view);
        }
    }

    public static final class g extends Lambda implements Function2<Dialog.Config, DialogInterface, Unit> {
        public final /* synthetic */ ErrorResult.ErrorDialog a;
        public final /* synthetic */ Function0 b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(ErrorResult.ErrorDialog errorDialog, Function0 function0) {
            super(2);
            this.a = errorDialog;
            this.b = function0;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public Unit invoke(Dialog.Config config, DialogInterface dialogInterface) {
            Action action;
            Dialog.Config config2 = config;
            DialogInterface dialogInterface2 = dialogInterface;
            Intrinsics.checkNotNullParameter(config2, "$receiver");
            Intrinsics.checkNotNullParameter(dialogInterface2, "it");
            config2.setTitle(this.a.getUserDialog().getTitle());
            config2.setSubtitle(this.a.getUserDialog().getMessage());
            config2.setCloseButtonVisible(this.a.getUserDialog().getCancelable());
            List<Action> actions = this.a.getUserDialog().getActions();
            if (!(actions == null || (action = actions.get(0)) == null)) {
                config2.addPrimaryButton(action.getTitle(), new a2.a.a.d2.c.d(this, config2, dialogInterface2));
            }
            return Unit.INSTANCE;
        }
    }

    public PublicProfileViewImpl(@NotNull View view, @NotNull PublicProfilePresenter publicProfilePresenter, @NotNull TabAdapter<?, ?> tabAdapter, @NotNull TabPagerAdapter tabPagerAdapter, @NotNull SubscribeButtonsView subscribeButtonsView, @NotNull Analytics analytics) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(publicProfilePresenter, "presenter");
        Intrinsics.checkNotNullParameter(tabAdapter, "tabsAdapter");
        Intrinsics.checkNotNullParameter(tabPagerAdapter, "pagerAdapter");
        Intrinsics.checkNotNullParameter(subscribeButtonsView, "subscribeButtonsView");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        View findViewById = view.findViewById(R.id.subscribe_info);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.view.View");
        this.t = new SubscriptionsCounterViewImpl(findViewById);
        this.o = view;
        this.p = publicProfilePresenter;
        this.q = tabAdapter;
        this.r = tabPagerAdapter;
        this.s = subscribeButtonsView;
        this.a = view.getResources();
        int i2 = R.id.overlay_container;
        View findViewById2 = view.findViewById(i2);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.view.View");
        this.b = findViewById2;
        View findViewById3 = view.findViewById(i2);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type android.view.ViewGroup");
        this.c = new ProgressOverlay((ViewGroup) findViewById3, R.id.coordinator_layout, analytics, false, 0, 24, null);
        AppBarLayout appBarLayout = (AppBarLayout) view.findViewById(R.id.profile_appbar);
        this.d = appBarLayout;
        View findViewById4 = view.findViewById(R.id.toolbar);
        Objects.requireNonNull(findViewById4, "null cannot be cast to non-null type android.view.View");
        ProfileToolbarImpl profileToolbarImpl = new ProfileToolbarImpl(findViewById4);
        this.e = profileToolbarImpl;
        Toolbar toolbar = profileToolbarImpl.getToolbar();
        this.f = toolbar;
        View findViewById5 = view.findViewById(R.id.adverts_tabs);
        Objects.requireNonNull(findViewById5, "null cannot be cast to non-null type com.google.android.material.tabs.TabLayout");
        TabLayout tabLayout = (TabLayout) findViewById5;
        this.h = tabLayout;
        View findViewById6 = view.findViewById(R.id.adverts_viewpager);
        Objects.requireNonNull(findViewById6, "null cannot be cast to non-null type androidx.viewpager.widget.ViewPager");
        ViewPager viewPager = (ViewPager) findViewById6;
        this.i = viewPager;
        View findViewById7 = view.findViewById(R.id.rating_container);
        Objects.requireNonNull(findViewById7, "null cannot be cast to non-null type android.view.View");
        this.j = findViewById7;
        View findViewById8 = view.findViewById(R.id.stub_container);
        Objects.requireNonNull(findViewById8, "null cannot be cast to non-null type android.view.View");
        this.k = findViewById8;
        View findViewById9 = view.findViewById(R.id.stub_text);
        Objects.requireNonNull(findViewById9, "null cannot be cast to non-null type android.widget.TextView");
        this.l = (TextView) findViewById9;
        View findViewById10 = view.findViewById(R.id.adverts_closed_alert_banner);
        Objects.requireNonNull(findViewById10, "null cannot be cast to non-null type com.avito.android.lib.design.alert_banner.AlertBanner");
        this.m = (AlertBanner) findViewById10;
        View findViewById11 = view.findViewById(R.id.user_hat);
        Objects.requireNonNull(findViewById11, "null cannot be cast to non-null type android.view.View");
        this.g = new UserHatImpl(findViewById11);
        View findViewById12 = findViewById11.findViewById(R.id.name);
        Objects.requireNonNull(findViewById12, "null cannot be cast to non-null type android.view.View");
        profileToolbarImpl.setContentVisible(false, false);
        if (appBarLayout != null) {
            appBarLayout.addOnOffsetChangedListener((AppBarLayout.OnOffsetChangedListener) new a(this, findViewById12));
        }
        this.c.setOnRefreshListener(new b(this));
        toolbar.inflateMenu(R.menu.public_profile_menu);
        Toolbars.tintMenuByAttr(toolbar, com.avito.android.lib.design.R.attr.blue);
        toolbar.setNavigationOnClickListener(new c(this));
        toolbar.setNavigationIcon(com.avito.android.ui_components.R.drawable.ic_back_24);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener(this) { // from class: com.avito.android.public_profile.ui.PublicProfileViewImpl.4
            public final /* synthetic */ PublicProfileViewImpl a;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.a = r1;
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i3) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i3, float f2, int i4) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i3) {
                this.a.p.onActiveTabChanged(i3);
            }
        });
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener((TabLayout.OnTabSelectedListener) new TabLayout.ViewPagerOnTabSelectedListener(viewPager));
        TabLayoutsKt.setAdapter(tabLayout, tabAdapter);
        viewPager.setAdapter(tabPagerAdapter);
    }

    public final MenuItem a() {
        MenuItem findItem = this.f.getMenu().findItem(R.id.menu_share);
        if (findItem != null) {
            return findItem;
        }
        throw new IllegalArgumentException("Toolbar was not inflated".toString());
    }

    public final void b() {
        Views.hide(this.k);
        Views.show(this.b);
    }

    @Override // com.avito.android.public_profile.ui.SubscriptionsCounterView
    public void bindSubscribersCounter(@Nullable ProfileCounter profileCounter) {
        this.t.bindSubscribersCounter(profileCounter);
    }

    @Override // com.avito.android.public_profile.ui.SubscriptionsCounterView
    public void bindSubscriptionsCounter(@Nullable ProfileCounter profileCounter) {
        this.t.bindSubscriptionsCounter(profileCounter);
    }

    public final void c(String str, @DimenRes int i2) {
        this.l.setMaxWidth(this.a.getDimensionPixelSize(i2));
        this.c.showContent();
        Views.show(this.k);
        Views.hide(this.b);
        TextViews.bindText$default(this.l, str, false, 2, null);
    }

    @Override // com.avito.android.lib.design.snackbar.util.OptionalSnackbarElementView
    public boolean canShowSnackbar() {
        return this.s.canShowSnackbar();
    }

    @Override // com.avito.android.subscriptions_settings.SubscriptionSettingsView
    public boolean closeSubscriptionSettings() {
        return this.s.closeSubscriptionSettings();
    }

    @Override // com.avito.android.subscriptions_settings.SubscriptionSettingsView
    @NotNull
    public Observable<Unit> dismissEvents() {
        return this.s.dismissEvents();
    }

    @Override // com.avito.android.public_profile.ui.SubscribeButtonsView
    @NotNull
    public Observable<Unit> getSubscribeButtonClicks() {
        return this.s.getSubscribeButtonClicks();
    }

    @Override // com.avito.android.public_profile.ui.PublicProfileView
    public void hideAdverts() {
        this.i.setVisibility(8);
        this.h.setVisibility(8);
    }

    @Override // com.avito.android.public_profile.ui.PublicProfileView
    public void hideBlockedAdvertsAlertBanner() {
        this.m.setVisibility(8);
    }

    @Override // com.avito.android.public_profile.ui.PublicProfileView
    public void hideShareButton() {
        MenuItemsKt.hide(a());
    }

    @Override // com.avito.android.public_profile.ui.SubscribeButtonsView
    public void hideSubscribeButton() {
        this.s.hideSubscribeButton();
    }

    @Override // com.avito.android.subscriptions_settings.SubscriptionSettingsView
    public boolean isMenuShowing() {
        return this.s.isMenuShowing();
    }

    @Override // com.avito.android.subscriptions_settings.SubscriptionSettingsView
    @NotNull
    public Observable<Unit> notificationClicks() {
        return this.s.notificationClicks();
    }

    @Override // com.avito.android.public_profile.ui.PublicProfileView
    public void onTabsChanged() {
        this.r.notifyDataSetChanged();
        this.q.notifyDataSetChanged();
    }

    @Override // com.avito.android.subscriptions_settings.SubscriptionSettingsView
    public void openSubscriptionSettings() {
        this.s.openSubscriptionSettings();
    }

    @Override // com.avito.android.public_profile.ui.PublicProfileView
    public void setActiveTab(int i2) {
        this.i.setCurrentItem(i2, false);
    }

    @Override // com.avito.android.public_profile.ui.PublicProfileView
    public void setAvatarClickListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.g.setAvatarClickListener(new d(function0));
    }

    @Override // com.avito.android.subscriptions_settings.SubscriptionSettingsView
    public void setNotificationActivated(boolean z) {
        this.s.setNotificationActivated(z);
    }

    @Override // com.avito.android.subscriptions_settings.SubscriptionSettingsView
    public void setNotificationLoading(boolean z) {
        this.s.setNotificationLoading(z);
    }

    @Override // com.avito.android.public_profile.ui.PublicProfileView
    public void setRatingClickListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.j.setOnClickListener(new e(function0));
    }

    @Override // com.avito.android.public_profile.ui.SubscribeButtonsView
    public void setSubscribeLoading(boolean z) {
        this.s.setSubscribeLoading(z);
    }

    @Override // com.avito.android.subscriptions_settings.SubscriptionSettingsView
    public void setSubscribed(boolean z, boolean z2) {
        this.s.setSubscribed(z, z2);
    }

    @Override // com.avito.android.subscriptions_settings.SubscriptionSettingsView
    public void setUnsubscribeLoading(boolean z) {
        this.s.setUnsubscribeLoading(z);
    }

    @Override // com.avito.android.public_profile.ui.PublicProfileView
    @NotNull
    public Observable<Unit> shareButtonClicks() {
        return InteropKt.toV3(RxMenuItem.clicks$default(a(), null, 1, null));
    }

    @Override // com.avito.android.public_profile.ui.PublicProfileView
    public void showAdverts() {
        this.i.setVisibility(0);
        this.h.setVisibility(0);
    }

    @Override // com.avito.android.public_profile.ui.PublicProfileView
    public void showAvatar(@NotNull UserIconType userIconType, @Nullable Image image) {
        Intrinsics.checkNotNullParameter(userIconType, "type");
        this.g.setAvatar(image != null ? AvitoPictureKt.pictureOf$default(image, true, 0.0f, 0.0f, null, 28, null) : null);
        this.g.setUserIconType(userIconType);
    }

    @Override // com.avito.android.public_profile.ui.PublicProfileView
    public void showBlockedAdvertsAlertBanner(@NotNull UserDialog userDialog, @Nullable String str, @Nullable PublishRelay<View> publishRelay) {
        Intrinsics.checkNotNullParameter(userDialog, "dialog");
        if (publishRelay != null) {
            AlertBanner alertBanner = this.m;
            alertBanner.getContent().setButton(str, new f(this, str, publishRelay));
            alertBanner.getContent().setButtonVisible(true);
        } else {
            this.m.getContent().setButtonVisible(false);
        }
        this.m.getContent().setTitle(userDialog.getTitle());
        this.m.getContent().setBody(userDialog.getMessage());
        this.m.setVisibility(0);
    }

    @Override // com.avito.android.public_profile.ui.PublicProfileView
    public void showConnections(@Nullable String str) {
        this.g.setDescription(str);
    }

    @Override // com.avito.android.public_profile.ui.PublicProfileView, com.avito.android.public_profile.ui.SubscriptionsContainerView
    public void showContent() {
        b();
        this.c.showContent();
    }

    @Override // com.avito.android.subscriptions_settings.SubscriptionSettingsView
    @NotNull
    public Maybe<Unit> showEnableNotificationDialog() {
        return this.s.showEnableNotificationDialog();
    }

    @Override // com.avito.android.public_profile.ui.PublicProfileView
    public void showError(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "error");
        b();
        this.c.showLoadingProblem(str);
    }

    @Override // com.avito.android.subscriptions_settings.SubscriptionSettingsView
    public void showErrorDialog(@NotNull ErrorResult.ErrorDialog errorDialog, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(errorDialog, "errorDialog");
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        Dialog dialog = this.n;
        if (dialog != null) {
            dialog.dismiss();
        }
        Dialog.Companion companion = Dialog.Companion;
        Context context = this.o.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        Dialog create$default = Dialog.Companion.create$default(companion, context, 0, 0, new g(errorDialog, function0), 6, null);
        this.n = create$default;
        if (create$default != null) {
            create$default.show();
        }
    }

    @Override // com.avito.android.public_profile.ui.PublicProfileView
    public void showName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        this.g.setName(str);
        this.e.setName(str);
    }

    @Override // com.avito.android.public_profile.ui.PublicProfileView
    public void showProgress() {
        b();
        this.c.showLoading();
    }

    @Override // com.avito.android.public_profile.ui.PublicProfileView
    public void showRating(@Nullable Float f2, @Nullable String str, boolean z) {
        boolean z2 = true;
        if (z) {
            UserHat.DefaultImpls.setRating$default(this.g, f2, true, str, 0, 8, null);
        } else {
            this.g.setRating(f2, true, str, com.avito.android.lib.design.R.attr.black);
        }
        View view = this.j;
        if (f2 == null && str == null) {
            z2 = false;
        }
        Views.setVisible(view, z2);
    }

    @Override // com.avito.android.public_profile.ui.PublicProfileView
    public void showShareButton() {
        MenuItemsKt.show(a());
    }

    @Override // com.avito.android.lib.design.snackbar.util.SnackbarElementView
    public void showSnackbar(@NotNull String str, int i2, @Nullable String str2, int i3, @Nullable Function0<Unit> function0, int i4, @NotNull SnackbarPosition snackbarPosition, @NotNull SnackbarType snackbarType) {
        Intrinsics.checkNotNullParameter(str, "text");
        Intrinsics.checkNotNullParameter(snackbarPosition, VKApiConst.POSITION);
        Intrinsics.checkNotNullParameter(snackbarType, "type");
        SnackbarExtensionsKt.showSnackbar(this.o, str, i2, str2, i3, function0, i4, snackbarPosition, snackbarType);
    }

    @Override // com.avito.android.public_profile.ui.SubscribeButtonsView
    public void showSubscribeButton(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        this.s.showSubscribeButton(str);
    }

    @Override // com.avito.android.public_profile.ui.PublicProfileView
    public void showSubtitle(@Nullable String str) {
        this.g.setSubtitle(str);
    }

    @Override // com.avito.android.public_profile.ui.PublicProfileView
    public void showUserBanned(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        c(str, R.dimen.user_banned_message_width);
    }

    @Override // com.avito.android.public_profile.ui.PublicProfileView
    public void showUserRemoved(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        c(str, R.dimen.user_removed_message_width);
    }

    @Override // com.avito.android.subscriptions_settings.SubscriptionSettingsView
    @NotNull
    public Observable<Unit> unsubscribeClicks() {
        return this.s.unsubscribeClicks();
    }
}
