package com.avito.android.photo_gallery;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.core.view.ViewCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.PagerAdapter;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.AuthIntentFactoryKt;
import com.avito.android.Features;
import com.avito.android.advert_core.analytics.gallery.GalleryVideoEvent;
import com.avito.android.advert_core.contactbar.AdvertContactsPresenter;
import com.avito.android.advert_core.contactbar.AdvertContactsView;
import com.avito.android.advert_core.contactbar.AdvertContactsViewImpl;
import com.avito.android.advert_core.teaser.TeaserObserver;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.provider.clickstream.TreeClickStreamParent;
import com.avito.android.analytics.screens.Timer;
import com.avito.android.autoteka_details.core.analytics.event.FromBlock;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.photo_gallery.adapter.FullscreenGalleryAdapter;
import com.avito.android.photo_gallery.adapter.GalleryAdapterKt;
import com.avito.android.photo_gallery.adapter.GalleryItem;
import com.avito.android.photo_gallery.analytics.GalleryCloseFullscreenEvent;
import com.avito.android.photo_gallery.analytics.GallerySwipeFullscreenEvent;
import com.avito.android.photo_gallery.common.ImageLoadListener;
import com.avito.android.photo_gallery.common.LegacyPhotoGalleryActivityDelegate;
import com.avito.android.photo_gallery.common.ToastsKt;
import com.avito.android.photo_gallery.di.DaggerLegacyPhotoGalleryActivityComponent;
import com.avito.android.photo_gallery.di.LegacyPhotoGalleryActivityComponent;
import com.avito.android.photo_gallery.di.PhotoGalleryDependencies;
import com.avito.android.photo_gallery.tracker.PhotoGalleryTracker;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.AdvertActions;
import com.avito.android.remote.model.AutotekaTeaserItemResponseKt;
import com.avito.android.remote.model.ForegroundImage;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.Video;
import com.avito.android.remote.model.advert_details.ContactBarData;
import com.avito.android.remote.model.autoteka.AutotekaTeaserGalleryModel;
import com.avito.android.serp.analytics.BannerPageSource;
import com.avito.android.ui.SafeViewPager;
import com.avito.android.ui.activity.BaseActivity;
import com.avito.android.util.Constants;
import com.avito.android.util.DialogRouter;
import com.avito.android.util.Formatter;
import com.avito.android.util.ImplicitIntentFactory;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n*\u0002ª\u0001\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0002Â\u0001B\b¢\u0006\u0005\bÁ\u0001\u0010\u000fJ\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\n\u001a\u00020\t2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\r\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\r\u0010\u000bJ\u000f\u0010\u000e\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ)\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00102\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0017\u0010\u000fJ\u000f\u0010\u0018\u001a\u00020\u0010H\u0014¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\tH\u0016¢\u0006\u0004\b\u001a\u0010\u000fJ\u000f\u0010\u001b\u001a\u00020\tH\u0016¢\u0006\u0004\b\u001b\u0010\u000fJ\u000f\u0010\u001c\u001a\u00020\tH\u0014¢\u0006\u0004\b\u001c\u0010\u000fJ\u0017\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u001f\u0010!\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\u0010H\u0016¢\u0006\u0004\b!\u0010\"J!\u0010'\u001a\u00020\t2\b\u0010$\u001a\u0004\u0018\u00010#2\u0006\u0010&\u001a\u00020%H\u0002¢\u0006\u0004\b'\u0010(J\u0017\u0010*\u001a\u00020\t2\u0006\u0010)\u001a\u00020\u0006H\u0002¢\u0006\u0004\b*\u0010+R\u0018\u0010/\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00103\u001a\u0002008\u0002@\u0002X.¢\u0006\u0006\n\u0004\b1\u00102R\u0018\u00107\u001a\u0004\u0018\u0001048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b5\u00106R\u001c\u0010<\u001a\b\u0012\u0004\u0012\u000209088\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b:\u0010;R\u0018\u0010@\u001a\u0004\u0018\u00010=8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b>\u0010?R\u0018\u0010D\u001a\u0004\u0018\u00010A8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bB\u0010CR\u0018\u0010H\u001a\u0004\u0018\u00010E8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bF\u0010GR\u0018\u0010L\u001a\u0004\u0018\u00010I8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bJ\u0010KR\"\u0010N\u001a\u00020M8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bN\u0010O\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR\"\u0010U\u001a\u00020T8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bU\u0010V\u001a\u0004\bW\u0010X\"\u0004\bY\u0010ZR\"\u0010\\\u001a\u00020[8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b\\\u0010]\u001a\u0004\b^\u0010_\"\u0004\b`\u0010aR\u0016\u0010d\u001a\u00020\u00068\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bb\u0010cR(\u0010g\u001a\b\u0012\u0004\u0012\u00020f0e8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bg\u0010h\u001a\u0004\bi\u0010j\"\u0004\bk\u0010lR\u0018\u0010p\u001a\u0004\u0018\u00010m8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bn\u0010oR\u0016\u0010)\u001a\u00020\u00068\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bq\u0010cR(\u0010r\u001a\b\u0012\u0004\u0012\u0002040e8\u0006@\u0006X.¢\u0006\u0012\n\u0004\br\u0010h\u001a\u0004\bs\u0010j\"\u0004\bt\u0010lR\"\u0010v\u001a\u00020u8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bv\u0010w\u001a\u0004\bx\u0010y\"\u0004\bz\u0010{R\u0018\u0010&\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b|\u0010}R\u001a\u0010\u0001\u001a\u0004\u0018\u00010~8\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b\u0010\u0001R\u0018\u0010\u0001\u001a\u00020\u00068\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b\u0001\u0010cR*\u0010\u0001\u001a\u00030\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R*\u0010\u0001\u001a\u00030\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R\u001c\u0010\u0001\u001a\u0005\u0018\u00010\u00018\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001b\u0010\u0001\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001b\u0010\u0014\u001a\u0005\u0018\u00010\u00018\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0001\u0010\u0001R*\u0010\u0001\u001a\u00030\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010 \u0001\"\u0006\b¡\u0001\u0010¢\u0001R*\u0010¤\u0001\u001a\u00030£\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\b¤\u0001\u0010¥\u0001\u001a\u0006\b¦\u0001\u0010§\u0001\"\u0006\b¨\u0001\u0010©\u0001R\u001a\u0010­\u0001\u001a\u00030ª\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b«\u0001\u0010¬\u0001R*\u0010¯\u0001\u001a\u00030®\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\b¯\u0001\u0010°\u0001\u001a\u0006\b±\u0001\u0010²\u0001\"\u0006\b³\u0001\u0010´\u0001R\u001c\u0010¸\u0001\u001a\u0005\u0018\u00010µ\u00018\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b¶\u0001\u0010·\u0001R\u001c\u0010¼\u0001\u001a\u0005\u0018\u00010¹\u00018\u0002@\u0002X\u000e¢\u0006\b\n\u0006\bº\u0001\u0010»\u0001R\u001a\u0010¾\u0001\u001a\u0004\u0018\u0001048\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b½\u0001\u00106R\u001a\u0010À\u0001\u001a\u0004\u0018\u0001048\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b¿\u0001\u00106¨\u0006Ã\u0001"}, d2 = {"Lcom/avito/android/photo_gallery/LegacyPhotoGalleryActivity;", "Lcom/avito/android/ui/activity/BaseActivity;", "Lcom/avito/android/photo_gallery/common/ImageLoadListener;", "Lcom/avito/android/photo_gallery/common/LegacyPhotoGalleryActivityDelegate;", "Landroid/os/Bundle;", "savedInstanceState", "", "setUpActivityComponent", "(Landroid/os/Bundle;)Z", "", "onCreate", "(Landroid/os/Bundle;)V", "outState", "onSaveInstanceState", "onBackPressed", "()V", "", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "onResume", "getContentLayoutId", "()I", "onImageLoadFailed", "onImageLoadSuccess", "onDestroy", "intent", "runActivity", "(Landroid/content/Intent;)V", "requestId", "runActivityForResult", "(Landroid/content/Intent;I)V", "Lcom/avito/android/advert_core/contactbar/AdvertContactsView;", "contactsView", "Lcom/avito/android/photo_gallery/LegacyPhotoGalleryRouter;", "router", AuthSource.SEND_ABUSE, "(Lcom/avito/android/advert_core/contactbar/AdvertContactsView;Lcom/avito/android/photo_gallery/LegacyPhotoGalleryRouter;)V", "visibilityContactBar", AuthSource.BOOKING_ORDER, "(Z)V", "Lcom/avito/android/remote/model/AdvertActions;", "t", "Lcom/avito/android/remote/model/AdvertActions;", "actions", "Lcom/avito/android/ui/SafeViewPager;", "k", "Lcom/avito/android/ui/SafeViewPager;", "mViewPager", "", "n", "Ljava/lang/String;", "searchContext", "", "Lcom/avito/android/photo_gallery/adapter/GalleryItem;", "x", "Ljava/util/List;", "galleryItems", "Lcom/avito/android/photo_gallery/LegacyPhotoGalleryView;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/avito/android/photo_gallery/LegacyPhotoGalleryView;", "coreView", "Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;", VKApiConst.Q, "Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;", "treeParent", "Lcom/avito/android/remote/model/advert_details/ContactBarData;", "u", "Lcom/avito/android/remote/model/advert_details/ContactBarData;", LegacyPhotoGalleryActivityKt.LEGACY_PHOTO_GALLERY_KEY_CONTACT_DATA, "Landroid/view/ViewGroup;", VKApiConst.VERSION, "Landroid/view/ViewGroup;", "contactBarContainer", "Lcom/avito/android/photo_gallery/tracker/PhotoGalleryTracker;", "tracker", "Lcom/avito/android/photo_gallery/tracker/PhotoGalleryTracker;", "getTracker", "()Lcom/avito/android/photo_gallery/tracker/PhotoGalleryTracker;", "setTracker", "(Lcom/avito/android/photo_gallery/tracker/PhotoGalleryTracker;)V", "Lcom/avito/android/advert_core/contactbar/AdvertContactsPresenter;", "advertContactsPresenter", "Lcom/avito/android/advert_core/contactbar/AdvertContactsPresenter;", "getAdvertContactsPresenter", "()Lcom/avito/android/advert_core/contactbar/AdvertContactsPresenter;", "setAdvertContactsPresenter", "(Lcom/avito/android/advert_core/contactbar/AdvertContactsPresenter;)V", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/Features;", "getFeatures", "()Lcom/avito/android/Features;", "setFeatures", "(Lcom/avito/android/Features;)V", "C", "Z", "withTeaser", "Lcom/avito/android/util/Formatter;", "", "errorFormatter", "Lcom/avito/android/util/Formatter;", "getErrorFormatter", "()Lcom/avito/android/util/Formatter;", "setErrorFormatter", "(Lcom/avito/android/util/Formatter;)V", "Lcom/avito/android/photo_gallery/adapter/FullscreenGalleryAdapter;", "r", "Lcom/avito/android/photo_gallery/adapter/FullscreenGalleryAdapter;", "fullscreenGalleryAdapter", "y", "phoneNumberFormatter", "getPhoneNumberFormatter", "setPhoneNumberFormatter", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "deepLinkIntentFactory", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "getDeepLinkIntentFactory", "()Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "setDeepLinkIntentFactory", "(Lcom/avito/android/deep_linking/DeepLinkIntentFactory;)V", "z", "Lcom/avito/android/photo_gallery/LegacyPhotoGalleryRouter;", "Lio/reactivex/disposables/Disposable;", "D", "Lio/reactivex/disposables/Disposable;", "teaserDisposable", "B", "isTeaserVisible", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/analytics/Analytics;", "getAnalytics", "()Lcom/avito/android/analytics/Analytics;", "setAnalytics", "(Lcom/avito/android/analytics/Analytics;)V", "Lcom/avito/android/util/ImplicitIntentFactory;", "implicitIntentFactory", "Lcom/avito/android/util/ImplicitIntentFactory;", "getImplicitIntentFactory", "()Lcom/avito/android/util/ImplicitIntentFactory;", "setImplicitIntentFactory", "(Lcom/avito/android/util/ImplicitIntentFactory;)V", "Landroid/widget/Toast;", AuthSource.OPEN_CHANNEL_LIST, "Landroid/widget/Toast;", "mImageProblemToast", "w", "Lcom/avito/android/advert_core/contactbar/AdvertContactsView;", "contactBarView", "Lcom/avito/android/photo_gallery/PhotoGalleryData;", ExifInterface.LONGITUDE_EAST, "Lcom/avito/android/photo_gallery/PhotoGalleryData;", "Lcom/avito/android/util/DialogRouter;", "dialogRouter", "Lcom/avito/android/util/DialogRouter;", "getDialogRouter", "()Lcom/avito/android/util/DialogRouter;", "setDialogRouter", "(Lcom/avito/android/util/DialogRouter;)V", "Lcom/avito/android/advert_core/teaser/TeaserObserver;", "teaserObserver", "Lcom/avito/android/advert_core/teaser/TeaserObserver;", "getTeaserObserver", "()Lcom/avito/android/advert_core/teaser/TeaserObserver;", "setTeaserObserver", "(Lcom/avito/android/advert_core/teaser/TeaserObserver;)V", "com/avito/android/photo_gallery/LegacyPhotoGalleryActivity$mSimpleOnPageChangeListener$1", "F", "Lcom/avito/android/photo_gallery/LegacyPhotoGalleryActivity$mSimpleOnPageChangeListener$1;", "mSimpleOnPageChangeListener", "Lcom/avito/android/ActivityIntentFactory;", "activityIntentFactory", "Lcom/avito/android/ActivityIntentFactory;", "getActivityIntentFactory", "()Lcom/avito/android/ActivityIntentFactory;", "setActivityIntentFactory", "(Lcom/avito/android/ActivityIntentFactory;)V", "", "s", "Ljava/lang/Long;", "returnStateId", "Landroid/view/View;", "l", "Landroid/view/View;", "topBackButton", "o", BookingInfoActivity.EXTRA_ITEM_ID, "p", "categoryId", "<init>", "Factory", "photo-gallery_release"}, k = 1, mv = {1, 4, 2})
public final class LegacyPhotoGalleryActivity extends BaseActivity implements ImageLoadListener, LegacyPhotoGalleryActivityDelegate {
    public LegacyPhotoGalleryView A;
    public boolean B;
    public boolean C;
    public Disposable D;
    public PhotoGalleryData E;
    public final LegacyPhotoGalleryActivity$mSimpleOnPageChangeListener$1 F = new LegacyPhotoGalleryActivity$mSimpleOnPageChangeListener$1(this);
    @Inject
    public ActivityIntentFactory activityIntentFactory;
    @Inject
    public AdvertContactsPresenter advertContactsPresenter;
    @Inject
    public Analytics analytics;
    @Inject
    public DeepLinkIntentFactory deepLinkIntentFactory;
    @Inject
    public DialogRouter dialogRouter;
    @Inject
    public Formatter<Throwable> errorFormatter;
    @Inject
    public Features features;
    @Inject
    public ImplicitIntentFactory implicitIntentFactory;
    public SafeViewPager k;
    public View l;
    public Toast m;
    public String n;
    public String o;
    public String p;
    @Inject
    public Formatter<String> phoneNumberFormatter;
    public TreeClickStreamParent q;
    public FullscreenGalleryAdapter r;
    public Long s;
    public AdvertActions t;
    @Inject
    public TeaserObserver teaserObserver;
    @Inject
    public PhotoGalleryTracker tracker;
    public ContactBarData u;
    public ViewGroup v;
    public AdvertContactsView w;
    public List<? extends GalleryItem> x = CollectionsKt__CollectionsKt.emptyList();
    public boolean y = true;
    public LegacyPhotoGalleryRouter z;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001e\u0010\u001fJ\u0001\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019¢\u0006\u0004\b\u001c\u0010\u001d¨\u0006 "}, d2 = {"Lcom/avito/android/photo_gallery/LegacyPhotoGalleryActivity$Factory;", "", "Landroid/content/Context;", "context", "Lcom/avito/android/remote/model/Video;", "video", "", "Lcom/avito/android/remote/model/Image;", "images", "", VKApiConst.POSITION, "", BookingInfoActivity.EXTRA_ITEM_ID, "categoryId", "Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;", "treeParent", "Lcom/avito/android/remote/model/AdvertActions;", "actions", "Lcom/avito/android/remote/model/advert_details/ContactBarData;", "data", "", "stateId", "searchContext", "Lcom/avito/android/remote/model/ForegroundImage;", "foregroundImage", "Lcom/avito/android/remote/model/autoteka/AutotekaTeaserGalleryModel;", "autotekaTeaser", "Landroid/content/Intent;", "createIntent", "(Landroid/content/Context;Lcom/avito/android/remote/model/Video;Ljava/util/List;ILjava/lang/String;Ljava/lang/String;Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;Lcom/avito/android/remote/model/AdvertActions;Lcom/avito/android/remote/model/advert_details/ContactBarData;Ljava/lang/Long;Ljava/lang/String;Lcom/avito/android/remote/model/ForegroundImage;Lcom/avito/android/remote/model/autoteka/AutotekaTeaserGalleryModel;)Landroid/content/Intent;", "<init>", "()V", "photo-gallery_release"}, k = 1, mv = {1, 4, 2})
    public static final class Factory {
        public static /* synthetic */ Intent createIntent$default(Factory factory, Context context, Video video, List list, int i, String str, String str2, TreeClickStreamParent treeClickStreamParent, AdvertActions advertActions, ContactBarData contactBarData, Long l, String str3, ForegroundImage foregroundImage, AutotekaTeaserGalleryModel autotekaTeaserGalleryModel, int i2, Object obj) {
            return factory.createIntent(context, video, list, i, str, str2, treeClickStreamParent, advertActions, contactBarData, (i2 & 512) != 0 ? null : l, (i2 & 1024) != 0 ? null : str3, (i2 & 2048) != 0 ? null : foregroundImage, autotekaTeaserGalleryModel);
        }

        @NotNull
        public final Intent createIntent(@NotNull Context context, @Nullable Video video, @NotNull List<Image> list, int i, @Nullable String str, @Nullable String str2, @Nullable TreeClickStreamParent treeClickStreamParent, @Nullable AdvertActions advertActions, @Nullable ContactBarData contactBarData, @Nullable Long l, @Nullable String str3, @Nullable ForegroundImage foregroundImage, @Nullable AutotekaTeaserGalleryModel autotekaTeaserGalleryModel) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(list, "images");
            Intent intent = new Intent(context, LegacyPhotoGalleryActivity.class);
            PhotoGalleryData photoGalleryData = new PhotoGalleryData(list, i, video, str, str2, treeClickStreamParent, advertActions, contactBarData, l, str3, foregroundImage);
            if (autotekaTeaserGalleryModel != null && autotekaTeaserGalleryModel.getHasAnotherPhotoInReport()) {
                intent.putExtra("teaser", autotekaTeaserGalleryModel);
            }
            intent.putExtra(LegacyPhotoGalleryActivityKt.LEGACY_PHOTO_GALLERY_STATE, photoGalleryData);
            return intent;
        }
    }

    public static final class e implements Runnable {
        public final /* synthetic */ View a;
        public final /* synthetic */ boolean b;

        public e(View view, boolean z) {
            this.a = view;
            this.b = z;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.setVisibility(this.b ? 8 : 0);
        }
    }

    public static final class f implements Runnable {
        public final /* synthetic */ View a;

        public f(View view) {
            this.a = view;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.setVisibility(0);
        }
    }

    public static final void access$onImageClick(LegacyPhotoGalleryActivity legacyPhotoGalleryActivity) {
        AdvertContactsView advertContactsView = legacyPhotoGalleryActivity.w;
        if (advertContactsView != null) {
            AdvertContactsView.DefaultImpls.animateShowHide$default(advertContactsView, legacyPhotoGalleryActivity.y, false, 2, null);
        }
        legacyPhotoGalleryActivity.b(legacyPhotoGalleryActivity.y);
        legacyPhotoGalleryActivity.y = !legacyPhotoGalleryActivity.y;
    }

    public static final void access$onTeaserButtonClick(LegacyPhotoGalleryActivity legacyPhotoGalleryActivity, FromBlock fromBlock) {
        LegacyPhotoGalleryRouter legacyPhotoGalleryRouter;
        AutotekaTeaserGalleryModel autotekaTeaserGalleryModel = (AutotekaTeaserGalleryModel) legacyPhotoGalleryActivity.getIntent().getParcelableExtra("teaser");
        if (autotekaTeaserGalleryModel != null && (legacyPhotoGalleryRouter = legacyPhotoGalleryActivity.z) != null) {
            legacyPhotoGalleryRouter.openAutotekaTeaser(AutotekaTeaserItemResponseKt.appendAutotekaUtmQueryParams(autotekaTeaserGalleryModel.getReportLink().getUrl()), fromBlock);
        }
    }

    public static final void access$onTeaserEmptyClick(LegacyPhotoGalleryActivity legacyPhotoGalleryActivity) {
        legacyPhotoGalleryActivity.b(legacyPhotoGalleryActivity.y);
        legacyPhotoGalleryActivity.y = !legacyPhotoGalleryActivity.y;
    }

    public static final void access$onVideoClick(LegacyPhotoGalleryActivity legacyPhotoGalleryActivity) {
        String str = legacyPhotoGalleryActivity.o;
        if (str != null) {
            Analytics analytics2 = legacyPhotoGalleryActivity.analytics;
            if (analytics2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("analytics");
            }
            analytics2.track(new GalleryVideoEvent(legacyPhotoGalleryActivity.q, str, true));
        }
    }

    public static final void access$resetZoomForZoomableFragments(LegacyPhotoGalleryActivity legacyPhotoGalleryActivity) {
        FragmentManager supportFragmentManager = legacyPhotoGalleryActivity.getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        for (Fragment fragment : supportFragmentManager.getFragments()) {
            if (fragment instanceof ZoomableFragment) {
                ((ZoomableFragment) fragment).resetZoom();
            }
        }
    }

    public static final void access$sendSwipeAnalytics(LegacyPhotoGalleryActivity legacyPhotoGalleryActivity) {
        String str;
        String str2;
        Features features2 = legacyPhotoGalleryActivity.features;
        if (features2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("features");
        }
        if (features2.getAdvertDetailsClientAnalytics().invoke().booleanValue() && (str = legacyPhotoGalleryActivity.o) != null && (str2 = legacyPhotoGalleryActivity.p) != null && legacyPhotoGalleryActivity.q != null) {
            Analytics analytics2 = legacyPhotoGalleryActivity.analytics;
            if (analytics2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("analytics");
            }
            analytics2.track(new GallerySwipeFullscreenEvent(legacyPhotoGalleryActivity.q, str, str2));
        }
    }

    public static final void access$showTeaserAction(LegacyPhotoGalleryActivity legacyPhotoGalleryActivity, boolean z2) {
        if (legacyPhotoGalleryActivity.B != z2) {
            if (z2) {
                AdvertContactsView advertContactsView = legacyPhotoGalleryActivity.w;
                if (advertContactsView != null) {
                    AdvertContactsView.DefaultImpls.animateShowHide$default(advertContactsView, true, false, 2, null);
                }
            } else if (legacyPhotoGalleryActivity.y) {
                AdvertContactsView advertContactsView2 = legacyPhotoGalleryActivity.w;
                if (advertContactsView2 != null) {
                    AdvertContactsView.DefaultImpls.animateShowHide$default(advertContactsView2, false, false, 2, null);
                }
            } else {
                AdvertContactsView advertContactsView3 = legacyPhotoGalleryActivity.w;
                if (advertContactsView3 != null) {
                    AdvertContactsView.DefaultImpls.animateShowHide$default(advertContactsView3, true, false, 2, null);
                }
            }
        }
        legacyPhotoGalleryActivity.B = z2;
    }

    public final void a(AdvertContactsView advertContactsView, LegacyPhotoGalleryRouter legacyPhotoGalleryRouter) {
        AdvertContactsPresenter advertContactsPresenter2 = this.advertContactsPresenter;
        if (advertContactsPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("advertContactsPresenter");
        }
        advertContactsPresenter2.attachStickyView(advertContactsView);
        AdvertContactsPresenter advertContactsPresenter3 = this.advertContactsPresenter;
        if (advertContactsPresenter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("advertContactsPresenter");
        }
        advertContactsPresenter3.attachCoreView(this.A);
        AdvertContactsPresenter advertContactsPresenter4 = this.advertContactsPresenter;
        if (advertContactsPresenter4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("advertContactsPresenter");
        }
        advertContactsPresenter4.setRouter(legacyPhotoGalleryRouter);
        AdvertContactsPresenter advertContactsPresenter5 = this.advertContactsPresenter;
        if (advertContactsPresenter5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("advertContactsPresenter");
        }
        advertContactsPresenter5.setContext(this.n);
        AdvertContactsPresenter advertContactsPresenter6 = this.advertContactsPresenter;
        if (advertContactsPresenter6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("advertContactsPresenter");
        }
        AdvertContactsPresenter advertContactsPresenter7 = this.advertContactsPresenter;
        if (advertContactsPresenter7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("advertContactsPresenter");
        }
        advertContactsPresenter6.bindStickyData(advertContactsPresenter7.contactBarActions(this.t), this.u);
    }

    public final void b(boolean z2) {
        View view = this.l;
        if (view != null) {
            view.setClickable(!z2);
            ViewCompat.animate(view).alpha(z2 ? 0.0f : 1.0f).setDuration(200).withStartAction(new f(view)).withEndAction(new e(view, z2)).start();
        }
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
    public final AdvertContactsPresenter getAdvertContactsPresenter() {
        AdvertContactsPresenter advertContactsPresenter2 = this.advertContactsPresenter;
        if (advertContactsPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("advertContactsPresenter");
        }
        return advertContactsPresenter2;
    }

    @NotNull
    public final Analytics getAnalytics() {
        Analytics analytics2 = this.analytics;
        if (analytics2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analytics");
        }
        return analytics2;
    }

    @Override // com.avito.android.ui.activity.BaseActivity
    public int getContentLayoutId() {
        return R.layout.ac_legacy_photogallery_contactbar;
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
    public final DialogRouter getDialogRouter() {
        DialogRouter dialogRouter2 = this.dialogRouter;
        if (dialogRouter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dialogRouter");
        }
        return dialogRouter2;
    }

    @NotNull
    public final Formatter<Throwable> getErrorFormatter() {
        Formatter<Throwable> formatter = this.errorFormatter;
        if (formatter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("errorFormatter");
        }
        return formatter;
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
    public final Formatter<String> getPhoneNumberFormatter() {
        Formatter<String> formatter = this.phoneNumberFormatter;
        if (formatter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("phoneNumberFormatter");
        }
        return formatter;
    }

    @NotNull
    public final TeaserObserver getTeaserObserver() {
        TeaserObserver teaserObserver2 = this.teaserObserver;
        if (teaserObserver2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("teaserObserver");
        }
        return teaserObserver2;
    }

    @NotNull
    public final PhotoGalleryTracker getTracker() {
        PhotoGalleryTracker photoGalleryTracker = this.tracker;
        if (photoGalleryTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tracker");
        }
        return photoGalleryTracker;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i != 1) {
            if (i == 11) {
                if (i2 == -1) {
                    SafeViewPager safeViewPager = this.k;
                    if (safeViewPager == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mViewPager");
                    }
                    PagerAdapter adapter = safeViewPager.getAdapter();
                    if (adapter != null) {
                        adapter.notifyDataSetChanged();
                    }
                } else if (i2 == 0) {
                    SafeViewPager safeViewPager2 = this.k;
                    if (safeViewPager2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mViewPager");
                    }
                    if (safeViewPager2.getCurrentItem() > 0) {
                        SafeViewPager safeViewPager3 = this.k;
                        if (safeViewPager3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mViewPager");
                        }
                        SafeViewPager safeViewPager4 = this.k;
                        if (safeViewPager4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mViewPager");
                        }
                        safeViewPager3.setCurrentItem(safeViewPager4.getCurrentItem() - 1);
                        return;
                    }
                    finish();
                } else {
                    finish();
                }
            }
        } else if (i2 == -1) {
            AdvertContactsPresenter advertContactsPresenter2 = this.advertContactsPresenter;
            if (advertContactsPresenter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("advertContactsPresenter");
            }
            advertContactsPresenter2.onAuthSuccess(AuthIntentFactoryKt.getSuccessAuthResultData(intent));
        }
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        String str;
        String str2;
        Features features2 = this.features;
        if (features2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("features");
        }
        if (!(!features2.getAdvertDetailsClientAnalytics().invoke().booleanValue() || (str = this.o) == null || (str2 = this.p) == null)) {
            Analytics analytics2 = this.analytics;
            if (analytics2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("analytics");
            }
            analytics2.track(new GalleryCloseFullscreenEvent(this.q, str, str2));
        }
        setResult(-1, getIntent());
        supportFinishAfterTransition();
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        AdvertContactsView advertContactsView;
        super.onCreate(bundle);
        PhotoGalleryTracker photoGalleryTracker = this.tracker;
        if (photoGalleryTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tracker");
        }
        photoGalleryTracker.startInit();
        getWindow().setFlags(1024, 1024);
        if (bundle != null) {
            AdvertContactsPresenter advertContactsPresenter2 = this.advertContactsPresenter;
            if (advertContactsPresenter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("advertContactsPresenter");
            }
            advertContactsPresenter2.restoreState(bundle.getBundle("contactsState"));
            this.y = bundle.getBoolean("visibilityContactBar", true);
            this.B = bundle.getBoolean("visibilityTeaser", false);
            this.s = Long.valueOf(bundle.getLong("returnStateId"));
        }
        Long l2 = this.s;
        if (l2 != null) {
            long longValue = l2.longValue();
            if (longValue > -1) {
                getIntent().putExtra(Constants.PHOTO_GALLERY_STATE_ID, longValue);
            }
        }
        View findViewById = findViewById(R.id.view_pager);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.view_pager)");
        SafeViewPager safeViewPager = (SafeViewPager) findViewById;
        this.k = safeViewPager;
        if (safeViewPager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewPager");
        }
        safeViewPager.setOffscreenPageLimit(1);
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        List<? extends GalleryItem> list = this.x;
        a aVar = new Function0<Unit>(this) { // from class: com.avito.android.photo_gallery.LegacyPhotoGalleryActivity.a
            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function0
            public Unit invoke() {
                LegacyPhotoGalleryActivity.access$onImageClick((LegacyPhotoGalleryActivity) this.receiver);
                return Unit.INSTANCE;
            }
        };
        b bVar = new Function0<Unit>(this) { // from class: com.avito.android.photo_gallery.LegacyPhotoGalleryActivity.b
            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function0
            public Unit invoke() {
                LegacyPhotoGalleryActivity.access$onVideoClick((LegacyPhotoGalleryActivity) this.receiver);
                return Unit.INSTANCE;
            }
        };
        c cVar = new Function1<FromBlock, Unit>(this) { // from class: com.avito.android.photo_gallery.LegacyPhotoGalleryActivity.c
            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public Unit invoke(FromBlock fromBlock) {
                FromBlock fromBlock2 = fromBlock;
                Intrinsics.checkNotNullParameter(fromBlock2, "p1");
                LegacyPhotoGalleryActivity.access$onTeaserButtonClick((LegacyPhotoGalleryActivity) this.receiver, fromBlock2);
                return Unit.INSTANCE;
            }
        };
        d dVar = new Function0<Unit>(this) { // from class: com.avito.android.photo_gallery.LegacyPhotoGalleryActivity.d
            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function0
            public Unit invoke() {
                LegacyPhotoGalleryActivity.access$onTeaserEmptyClick((LegacyPhotoGalleryActivity) this.receiver);
                return Unit.INSTANCE;
            }
        };
        ImplicitIntentFactory implicitIntentFactory2 = this.implicitIntentFactory;
        if (implicitIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("implicitIntentFactory");
        }
        Analytics analytics2 = this.analytics;
        if (analytics2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analytics");
        }
        this.r = new FullscreenGalleryAdapter(this, supportFragmentManager, list, this.o, this, implicitIntentFactory2, analytics2, aVar, bVar, dVar, cVar);
        SafeViewPager safeViewPager2 = this.k;
        if (safeViewPager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewPager");
        }
        safeViewPager2.setAdapter(this.r);
        PhotoGalleryData photoGalleryData = this.E;
        int position = photoGalleryData != null ? photoGalleryData.getPosition() : 0;
        SafeViewPager safeViewPager3 = this.k;
        if (safeViewPager3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewPager");
        }
        safeViewPager3.setCurrentItem(position);
        getIntent().putExtra(Constants.IMAGE_POSITION, position);
        SafeViewPager safeViewPager4 = this.k;
        if (safeViewPager4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewPager");
        }
        safeViewPager4.addOnPageChangeListener(this.F);
        if (this.C && position == CollectionsKt__CollectionsKt.getLastIndex(this.x)) {
            this.B = true;
        }
        String str = this.o;
        if (str != null) {
            FragmentManager supportFragmentManager2 = getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager2, "supportFragmentManager");
            DeepLinkIntentFactory deepLinkIntentFactory2 = this.deepLinkIntentFactory;
            if (deepLinkIntentFactory2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("deepLinkIntentFactory");
            }
            ActivityIntentFactory activityIntentFactory2 = this.activityIntentFactory;
            if (activityIntentFactory2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("activityIntentFactory");
            }
            ImplicitIntentFactory implicitIntentFactory3 = this.implicitIntentFactory;
            if (implicitIntentFactory3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("implicitIntentFactory");
            }
            Analytics analytics3 = this.analytics;
            if (analytics3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("analytics");
            }
            LegacyPhotoGalleryRouter legacyPhotoGalleryRouter = new LegacyPhotoGalleryRouter(this, supportFragmentManager2, str, this, deepLinkIntentFactory2, activityIntentFactory2, implicitIntentFactory3, analytics3);
            FragmentManager supportFragmentManager3 = getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager3, "supportFragmentManager");
            DialogRouter dialogRouter2 = this.dialogRouter;
            if (dialogRouter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dialogRouter");
            }
            Formatter<String> formatter = this.phoneNumberFormatter;
            if (formatter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("phoneNumberFormatter");
            }
            Formatter<Throwable> formatter2 = this.errorFormatter;
            if (formatter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("errorFormatter");
            }
            AdvertContactsPresenter advertContactsPresenter3 = this.advertContactsPresenter;
            if (advertContactsPresenter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("advertContactsPresenter");
            }
            this.A = new LegacyPhotoGalleryView(this, supportFragmentManager3, dialogRouter2, formatter, formatter2, advertContactsPresenter3, legacyPhotoGalleryRouter);
            this.z = legacyPhotoGalleryRouter;
        }
        View findViewById2 = findViewById(R.id.top_back);
        this.l = findViewById2;
        if (findViewById2 != null) {
            findViewById2.setOnClickListener(new a2.a.a.w1.a(this));
        }
        if (!this.y) {
            View view = this.l;
            if (view != null) {
                view.setAlpha(0.0f);
            }
            View view2 = this.l;
            if (view2 != null) {
                view2.setClickable(false);
            }
            View view3 = this.l;
            if (view3 != null) {
                view3.setVisibility(8);
            }
        }
        if (!(this.t == null || this.u == null)) {
            ViewGroup viewGroup = (ViewGroup) findViewById(R.id.contact_bar_buttons_container);
            this.v = viewGroup;
            AdvertContactsView advertContactsView2 = this.w;
            LegacyPhotoGalleryRouter legacyPhotoGalleryRouter2 = this.z;
            if (advertContactsView2 != null && legacyPhotoGalleryRouter2 != null) {
                a(advertContactsView2, legacyPhotoGalleryRouter2);
            } else if (!(viewGroup == null || legacyPhotoGalleryRouter2 == null)) {
                Features features2 = this.features;
                if (features2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("features");
                }
                AdvertContactsViewImpl advertContactsViewImpl = new AdvertContactsViewImpl(viewGroup, true, false, null, features2, null, null, 108, null);
                this.w = advertContactsViewImpl;
                a(advertContactsViewImpl, legacyPhotoGalleryRouter2);
                AdvertContactsPresenter advertContactsPresenter4 = this.advertContactsPresenter;
                if (advertContactsPresenter4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("advertContactsPresenter");
                }
                advertContactsPresenter4.showPhoneCallConfirmationIfNeeded();
            }
            if ((!this.y) && (advertContactsView = this.w) != null) {
                advertContactsView.hide(true);
            }
        }
        TeaserObserver teaserObserver2 = this.teaserObserver;
        if (teaserObserver2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("teaserObserver");
        }
        this.D = teaserObserver2.observeTeaser().subscribe(new a2.a.a.w1.b(this), a2.a.a.w1.c.a);
        PhotoGalleryTracker photoGalleryTracker2 = this.tracker;
        if (photoGalleryTracker2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tracker");
        }
        photoGalleryTracker2.trackInit();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        AdvertContactsPresenter advertContactsPresenter2 = this.advertContactsPresenter;
        if (advertContactsPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("advertContactsPresenter");
        }
        advertContactsPresenter2.detachView();
        Disposable disposable = this.D;
        if (disposable != null) {
            disposable.dispose();
            this.D = null;
        }
    }

    @Override // com.avito.android.photo_gallery.common.ImageLoadListener
    public void onImageLoadFailed() {
        if (!ToastsKt.isShowing(this.m)) {
            Toast toast = this.m;
            if (!(toast == null || toast == null)) {
                toast.cancel();
            }
            this.m = com.avito.android.util.ToastsKt.showToast$default(this, R.string.photo_load_error, 0, 2, (Object) null);
        }
    }

    @Override // com.avito.android.photo_gallery.common.ImageLoadListener
    public void onImageLoadSuccess() {
    }

    @Override // com.avito.android.ui.activity.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        AdvertContactsPresenter advertContactsPresenter2 = this.advertContactsPresenter;
        if (advertContactsPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("advertContactsPresenter");
        }
        advertContactsPresenter2.showAntiFraudCheckList();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        super.onSaveInstanceState(bundle);
        AdvertContactsPresenter advertContactsPresenter2 = this.advertContactsPresenter;
        if (advertContactsPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("advertContactsPresenter");
        }
        bundle.putBundle("contactsState", advertContactsPresenter2.saveState());
        bundle.putBoolean("visibilityContactBar", this.y);
        bundle.putBoolean("visibilityTeaser", this.B);
        Long l2 = this.s;
        if (l2 != null) {
            bundle.putLong("returnStateId", l2.longValue());
        }
    }

    @Override // com.avito.android.photo_gallery.common.LegacyPhotoGalleryActivityDelegate
    public void runActivity(@NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        startActivity(intent);
    }

    @Override // com.avito.android.photo_gallery.common.LegacyPhotoGalleryActivityDelegate
    public void runActivityForResult(@NotNull Intent intent, int i) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        startActivityForResult(intent, i);
    }

    public final void setActivityIntentFactory(@NotNull ActivityIntentFactory activityIntentFactory2) {
        Intrinsics.checkNotNullParameter(activityIntentFactory2, "<set-?>");
        this.activityIntentFactory = activityIntentFactory2;
    }

    public final void setAdvertContactsPresenter(@NotNull AdvertContactsPresenter advertContactsPresenter2) {
        Intrinsics.checkNotNullParameter(advertContactsPresenter2, "<set-?>");
        this.advertContactsPresenter = advertContactsPresenter2;
    }

    public final void setAnalytics(@NotNull Analytics analytics2) {
        Intrinsics.checkNotNullParameter(analytics2, "<set-?>");
        this.analytics = analytics2;
    }

    public final void setDeepLinkIntentFactory(@NotNull DeepLinkIntentFactory deepLinkIntentFactory2) {
        Intrinsics.checkNotNullParameter(deepLinkIntentFactory2, "<set-?>");
        this.deepLinkIntentFactory = deepLinkIntentFactory2;
    }

    public final void setDialogRouter(@NotNull DialogRouter dialogRouter2) {
        Intrinsics.checkNotNullParameter(dialogRouter2, "<set-?>");
        this.dialogRouter = dialogRouter2;
    }

    public final void setErrorFormatter(@NotNull Formatter<Throwable> formatter) {
        Intrinsics.checkNotNullParameter(formatter, "<set-?>");
        this.errorFormatter = formatter;
    }

    public final void setFeatures(@NotNull Features features2) {
        Intrinsics.checkNotNullParameter(features2, "<set-?>");
        this.features = features2;
    }

    public final void setImplicitIntentFactory(@NotNull ImplicitIntentFactory implicitIntentFactory2) {
        Intrinsics.checkNotNullParameter(implicitIntentFactory2, "<set-?>");
        this.implicitIntentFactory = implicitIntentFactory2;
    }

    public final void setPhoneNumberFormatter(@NotNull Formatter<String> formatter) {
        Intrinsics.checkNotNullParameter(formatter, "<set-?>");
        this.phoneNumberFormatter = formatter;
    }

    public final void setTeaserObserver(@NotNull TeaserObserver teaserObserver2) {
        Intrinsics.checkNotNullParameter(teaserObserver2, "<set-?>");
        this.teaserObserver = teaserObserver2;
    }

    public final void setTracker(@NotNull PhotoGalleryTracker photoGalleryTracker) {
        Intrinsics.checkNotNullParameter(photoGalleryTracker, "<set-?>");
        this.tracker = photoGalleryTracker;
    }

    @Override // com.avito.android.ui.activity.BaseActivity
    public boolean setUpActivityComponent(@Nullable Bundle bundle) {
        Timer B1 = a2.b.a.a.a.B1();
        Intent intent = getIntent();
        PhotoGalleryData photoGalleryData = (PhotoGalleryData) intent.getParcelableExtra(LegacyPhotoGalleryActivityKt.LEGACY_PHOTO_GALLERY_STATE);
        this.E = photoGalleryData;
        ForegroundImage foregroundImage = null;
        this.s = photoGalleryData != null ? photoGalleryData.getStateId() : null;
        PhotoGalleryData photoGalleryData2 = this.E;
        this.t = photoGalleryData2 != null ? photoGalleryData2.getActions() : null;
        PhotoGalleryData photoGalleryData3 = this.E;
        this.u = photoGalleryData3 != null ? photoGalleryData3.getData() : null;
        PhotoGalleryData photoGalleryData4 = this.E;
        this.o = photoGalleryData4 != null ? photoGalleryData4.getAdvertId() : null;
        PhotoGalleryData photoGalleryData5 = this.E;
        this.n = photoGalleryData5 != null ? photoGalleryData5.getSearchContext() : null;
        PhotoGalleryData photoGalleryData6 = this.E;
        this.p = photoGalleryData6 != null ? photoGalleryData6.getCategoryId() : null;
        PhotoGalleryData photoGalleryData7 = this.E;
        this.q = photoGalleryData7 != null ? photoGalleryData7.getTreeParent() : null;
        LegacyPhotoGalleryActivityComponent.Builder with = DaggerLegacyPhotoGalleryActivityComponent.builder().with(this);
        Resources resources = getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "resources");
        with.with(resources).with(this.q).withBannerPageSource(BannerPageSource.ADVERT).photoGalleryDependencies((PhotoGalleryDependencies) ComponentDependenciesKt.getDependencies(PhotoGalleryDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder((Activity) this))).build().inject(this);
        PhotoGalleryData photoGalleryData8 = this.E;
        Video video = photoGalleryData8 != null ? photoGalleryData8.getVideo() : null;
        PhotoGalleryData photoGalleryData9 = this.E;
        List<Image> images = photoGalleryData9 != null ? photoGalleryData9.getImages() : null;
        AutotekaTeaserGalleryModel autotekaTeaserGalleryModel = (AutotekaTeaserGalleryModel) intent.getParcelableExtra("teaser");
        PhotoGalleryData photoGalleryData10 = this.E;
        if (photoGalleryData10 != null) {
            foregroundImage = photoGalleryData10.getForegroundImage();
        }
        List<GalleryItem> photoGalleryCollectItems = GalleryAdapterKt.photoGalleryCollectItems(video, images, foregroundImage, autotekaTeaserGalleryModel);
        this.x = photoGalleryCollectItems;
        ArrayList arrayList = new ArrayList();
        for (T t2 : photoGalleryCollectItems) {
            if (t2 instanceof GalleryItem.GalleryTeaserAutoteka) {
                arrayList.add(t2);
            }
        }
        this.C = !arrayList.isEmpty();
        PhotoGalleryTracker photoGalleryTracker = this.tracker;
        if (photoGalleryTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tracker");
        }
        photoGalleryTracker.trackDiInject(B1.elapsed());
        return true;
    }
}
