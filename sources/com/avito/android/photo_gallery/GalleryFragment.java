package com.avito.android.photo_gallery;

import a2.g.r.g;
import android.content.Context;
import android.graphics.PointF;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.avito.android.Features;
import com.avito.android.ab_tests.groups.AdvertAutotekaTeaserInGalleryTestGroup;
import com.avito.android.ab_tests.models.ManuallyExposedAbTestGroup;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.screens.InternalConstsKt;
import com.avito.android.analytics.screens.Screen;
import com.avito.android.analytics.screens.Timer;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.connection_quality.connectivity.ConnectivityProvider;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.image_loader.AvitoPictureKt;
import com.avito.android.image_loader.ForegroundConverter;
import com.avito.android.image_loader.ForegroundConverterImpl;
import com.avito.android.image_loader.ImageRequest;
import com.avito.android.image_loader.ImageRequestListener;
import com.avito.android.photo_gallery.autoteka_teaser.AutotekaListener;
import com.avito.android.photo_gallery.autoteka_teaser.AutotekaTeaserView;
import com.avito.android.photo_gallery.di.DaggerGalleryComponent;
import com.avito.android.photo_gallery.di.GalleryDependencies;
import com.avito.android.photo_gallery.tracker.GalleryTracker;
import com.avito.android.photo_gallery.zoom.AnimatedZoomableController;
import com.avito.android.photo_gallery.zoom.ZoomableController;
import com.avito.android.photo_gallery.zoom.ZoomableDraweeView;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.ForegroundImage;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.autoteka.AutotekaTeaserGalleryModel;
import com.avito.android.ui.fragments.BaseFragment;
import com.avito.android.ui.view.FixedRatioImageView;
import com.avito.android.ui_components.R;
import com.avito.android.util.SimpleDraweeViewsKt;
import com.avito.android.util.text.AttributedTextFormatterImpl;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import java.io.Serializable;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Ð\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0002\u0001B\b¢\u0006\u0005\b\u0001\u0010\u0007J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0014¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\r\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ-\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001a\u0010\u0007J\u000f\u0010\u001b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001b\u0010\u0007J\u0017\u0010\u001d\u001a\u00020\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u001c¢\u0006\u0004\b\u001d\u0010\u001eJ\u0019\u0010 \u001a\u00020\u00052\b\u0010\u001f\u001a\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0004\b \u0010!J#\u0010&\u001a\u00020\u00052\b\u0010#\u001a\u0004\u0018\u00010\"2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010$¢\u0006\u0004\b&\u0010'J\u000f\u0010(\u001a\u00020\u0005H\u0016¢\u0006\u0004\b(\u0010\u0007J\u001f\u0010,\u001a\u00020\u00052\u0006\u0010*\u001a\u00020)2\u0006\u0010+\u001a\u00020)H\u0016¢\u0006\u0004\b,\u0010-J\u000f\u0010.\u001a\u00020\u0005H\u0016¢\u0006\u0004\b.\u0010\u0007J\u0015\u00100\u001a\u00020\u00052\u0006\u0010/\u001a\u00020\n¢\u0006\u0004\b0\u00101R\u0018\u00105\u001a\u0004\u0018\u0001028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b3\u00104R\"\u00107\u001a\u0002068\u0006@\u0006X.¢\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u0018\u0010?\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b=\u0010>R\"\u0010A\u001a\u00020@8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bA\u0010B\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\u001e\u0010K\u001a\n H*\u0004\u0018\u00010G0G8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bI\u0010JR\u0016\u0010O\u001a\u00020L8\u0002@\u0002X.¢\u0006\u0006\n\u0004\bM\u0010NR\u0018\u0010%\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bP\u0010QR\u0016\u0010T\u001a\u00020\n8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bR\u0010SR$\u0010[\u001a\u00020U2\u0006\u0010V\u001a\u00020U8\u0006@BX\u000e¢\u0006\f\n\u0004\bW\u0010X\u001a\u0004\bY\u0010ZR\u0018\u0010#\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\\\u0010]R(\u0010`\u001a\b\u0012\u0004\u0012\u00020_0^8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b`\u0010a\u001a\u0004\bb\u0010c\"\u0004\bd\u0010eR\u0018\u0010i\u001a\u0004\u0018\u00010f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bg\u0010hR\u0016\u0010k\u001a\u00020\n8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bj\u0010SR\u0016\u0010o\u001a\u00020l8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bm\u0010nR\"\u0010q\u001a\u00020p8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bq\u0010r\u001a\u0004\bs\u0010t\"\u0004\bu\u0010vR\u0018\u0010z\u001a\u0004\u0018\u00010w8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bx\u0010yR\u0018\u0010}\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b{\u0010|R'\u0010\u001a\u00020~8\u0006@\u0006X.¢\u0006\u0017\n\u0005\b\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R\u0018\u0010\u0001\u001a\u00020\n8\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b\u0001\u0010SR\u001b\u0010\u0001\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001c\u0010\u0001\u001a\u0005\u0018\u00010\u00018\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0001\u0010\u0001¨\u0006\u0001"}, d2 = {"Lcom/avito/android/photo_gallery/GalleryFragment;", "Lcom/avito/android/ui/fragments/BaseFragment;", "Landroid/view/View$OnClickListener;", "Lcom/avito/android/photo_gallery/ZoomableFragment;", "Lcom/avito/android/image_loader/ImageRequestListener;", "", AuthSource.SEND_ABUSE, "()V", "Landroid/os/Bundle;", "savedInstanceState", "", "setUpFragmentComponent", "(Landroid/os/Bundle;)Z", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "Lcom/avito/android/photo_gallery/autoteka_teaser/AutotekaListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setAutotekaListener", "(Lcom/avito/android/photo_gallery/autoteka_teaser/AutotekaListener;)V", "resetZoom", "onDestroyView", "Lcom/avito/android/photo_gallery/GalleryFragment$Listener;", "setListener", "(Lcom/avito/android/photo_gallery/GalleryFragment$Listener;)V", VKApiConst.VERSION, "onClick", "(Landroid/view/View;)V", "Lcom/avito/android/remote/model/Image;", "image", "Lcom/avito/android/remote/model/ForegroundImage;", "foregroundImage", "updateImage", "(Lcom/avito/android/remote/model/Image;Lcom/avito/android/remote/model/ForegroundImage;)V", "onStarted", "", ViewHierarchyConstants.DIMENSION_WIDTH_KEY, ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, "onLoaded", "(II)V", "onFailed", "isShow", "showOpenTeaserButton", "(Z)V", "Lcom/avito/android/photo_gallery/autoteka_teaser/AutotekaTeaserView;", "p", "Lcom/avito/android/photo_gallery/autoteka_teaser/AutotekaTeaserView;", "autotekaView", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/Features;", "getFeatures", "()Lcom/avito/android/Features;", "setFeatures", "(Lcom/avito/android/Features;)V", "r", "Lcom/avito/android/photo_gallery/autoteka_teaser/AutotekaListener;", "autotekaListener", "Lcom/avito/android/connection_quality/connectivity/ConnectivityProvider;", "connectivityProvider", "Lcom/avito/android/connection_quality/connectivity/ConnectivityProvider;", "getConnectivityProvider", "()Lcom/avito/android/connection_quality/connectivity/ConnectivityProvider;", "setConnectivityProvider", "(Lcom/avito/android/connection_quality/connectivity/ConnectivityProvider;)V", "Lcom/avito/android/photo_gallery/zoom/AnimatedZoomableController;", "kotlin.jvm.PlatformType", "d", "Lcom/avito/android/photo_gallery/zoom/AnimatedZoomableController;", "controller", "", "n", "Ljava/lang/String;", BookingInfoActivity.EXTRA_ITEM_ID, "k", "Lcom/avito/android/remote/model/ForegroundImage;", g.a, "Z", "isFastOpen", "Lcom/avito/android/photo_gallery/GalleryFragmentType;", "<set-?>", "h", "Lcom/avito/android/photo_gallery/GalleryFragmentType;", "getGalleryFragmentType", "()Lcom/avito/android/photo_gallery/GalleryFragmentType;", "galleryFragmentType", "j", "Lcom/avito/android/remote/model/Image;", "Lcom/avito/android/ab_tests/models/ManuallyExposedAbTestGroup;", "Lcom/avito/android/ab_tests/groups/AdvertAutotekaTeaserInGalleryTestGroup;", "autotekaTeaserInGalleryTestGroup", "Lcom/avito/android/ab_tests/models/ManuallyExposedAbTestGroup;", "getAutotekaTeaserInGalleryTestGroup", "()Lcom/avito/android/ab_tests/models/ManuallyExposedAbTestGroup;", "setAutotekaTeaserInGalleryTestGroup", "(Lcom/avito/android/ab_tests/models/ManuallyExposedAbTestGroup;)V", "Lcom/facebook/drawee/view/SimpleDraweeView;", "c", "Lcom/facebook/drawee/view/SimpleDraweeView;", "mImageView", AuthSource.OPEN_CHANNEL_LIST, "imageSuccessLoaded", "Lcom/avito/android/image_loader/ForegroundConverterImpl;", "o", "Lcom/avito/android/image_loader/ForegroundConverterImpl;", "foregroundImageConverter", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/analytics/Analytics;", "getAnalytics", "()Lcom/avito/android/analytics/Analytics;", "setAnalytics", "(Lcom/avito/android/analytics/Analytics;)V", "Lcom/avito/android/remote/model/autoteka/AutotekaTeaserGalleryModel;", VKApiConst.Q, "Lcom/avito/android/remote/model/autoteka/AutotekaTeaserGalleryModel;", "teaser", "i", "Lcom/avito/android/photo_gallery/GalleryFragment$Listener;", "mListener", "Lcom/avito/android/photo_gallery/tracker/GalleryTracker;", "tracker", "Lcom/avito/android/photo_gallery/tracker/GalleryTracker;", "getTracker", "()Lcom/avito/android/photo_gallery/tracker/GalleryTracker;", "setTracker", "(Lcom/avito/android/photo_gallery/tracker/GalleryTracker;)V", "f", "mCropImage", "e", "Landroid/view/View;", "mProgressView", "", "l", "Ljava/lang/Float;", "ratio", "<init>", "Listener", "photo-gallery_release"}, k = 1, mv = {1, 4, 2})
public final class GalleryFragment extends BaseFragment implements View.OnClickListener, ZoomableFragment, ImageRequestListener {
    @Inject
    public Analytics analytics;
    @Inject
    public ManuallyExposedAbTestGroup<AdvertAutotekaTeaserInGalleryTestGroup> autotekaTeaserInGalleryTestGroup;
    public SimpleDraweeView c;
    @Inject
    public ConnectivityProvider connectivityProvider;
    public AnimatedZoomableController d = AnimatedZoomableController.newInstance();
    public View e;
    public boolean f;
    @Inject
    public Features features;
    public boolean g;
    @NotNull
    public GalleryFragmentType h = GalleryFragmentType.IMAGE;
    public Listener i;
    public Image j;
    public ForegroundImage k;
    public Float l;
    public boolean m;
    public String n;
    public final ForegroundConverterImpl o = new ForegroundConverterImpl(new AttributedTextFormatterImpl());
    public AutotekaTeaserView p;
    public AutotekaTeaserGalleryModel q;
    public AutotekaListener r;
    @Inject
    public GalleryTracker tracker;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/avito/android/photo_gallery/GalleryFragment$Listener;", "", "", "onImageClicked", "()V", "onImageLoadFailed", "onImageLoadSuccess", "photo-gallery_release"}, k = 1, mv = {1, 4, 2})
    public interface Listener {
        void onImageClicked();

        void onImageLoadFailed();

        void onImageLoadSuccess();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            AdvertAutotekaTeaserInGalleryTestGroup.values();
            int[] iArr = new int[4];
            $EnumSwitchMapping$0 = iArr;
            iArr[2] = 1;
            iArr[3] = 2;
        }
    }

    public static final class a extends Lambda implements Function0<Boolean> {
        public final /* synthetic */ GalleryFragment a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(GalleryFragment galleryFragment) {
            super(0);
            this.a = galleryFragment;
        }

        @Override // kotlin.jvm.functions.Function0
        public Boolean invoke() {
            return Boolean.valueOf(this.a.getConnectivityProvider().isConnectionAvailable());
        }
    }

    public static /* synthetic */ void updateImage$default(GalleryFragment galleryFragment, Image image, ForegroundImage foregroundImage, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            foregroundImage = null;
        }
        galleryFragment.updateImage(image, foregroundImage);
    }

    public final void a() {
        Image image;
        SimpleDraweeView simpleDraweeView = this.c;
        if (simpleDraweeView != null) {
            GalleryTracker galleryTracker = this.tracker;
            if (galleryTracker == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tracker");
            }
            galleryTracker.startLoading();
            ImageRequest.Builder requestBuilder = SimpleDraweeViewsKt.getRequestBuilder(simpleDraweeView);
            ForegroundImage foregroundImage = this.k;
            if (foregroundImage == null || (image = foregroundImage.getImage()) == null) {
                image = this.j;
            }
            ImageRequest.Builder noFadeAnimation = requestBuilder.picture(AvitoPictureKt.pictureOf$default(image, false, 0.0f, 0.0f, null, 28, null)).listener(this).retainImage(this.g).noFadeAnimation(this.g);
            ForegroundConverterImpl foregroundConverterImpl = this.o;
            Context requireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
            ImageRequest.Builder sourcePlace = noFadeAnimation.foreground(ForegroundConverter.DefaultImpls.convert$default(foregroundConverterImpl, requireContext, AvitoPictureKt.pictureOf$default(false, 0.0f, 0.0f, this.k, 6, null), null, 4, null)).sourcePlace(getActivity() instanceof LegacyPhotoGalleryActivity ? ImageRequest.SourcePlace.FULLSCREEN_GALLERY : ImageRequest.SourcePlace.ADVERT_DETAILS_GALLERY);
            String str = this.n;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException(BookingInfoActivity.EXTRA_ITEM_ID);
            }
            sourcePlace.advertId(str).isConnectionAvailable(new a(this)).load();
        }
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
    public final ManuallyExposedAbTestGroup<AdvertAutotekaTeaserInGalleryTestGroup> getAutotekaTeaserInGalleryTestGroup() {
        ManuallyExposedAbTestGroup<AdvertAutotekaTeaserInGalleryTestGroup> manuallyExposedAbTestGroup = this.autotekaTeaserInGalleryTestGroup;
        if (manuallyExposedAbTestGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("autotekaTeaserInGalleryTestGroup");
        }
        return manuallyExposedAbTestGroup;
    }

    @NotNull
    public final ConnectivityProvider getConnectivityProvider() {
        ConnectivityProvider connectivityProvider2 = this.connectivityProvider;
        if (connectivityProvider2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("connectivityProvider");
        }
        return connectivityProvider2;
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
    public final GalleryFragmentType getGalleryFragmentType() {
        return this.h;
    }

    @NotNull
    public final GalleryTracker getTracker() {
        GalleryTracker galleryTracker = this.tracker;
        if (galleryTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tracker");
        }
        return galleryTracker;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View view) {
        Listener listener;
        if (view != null && view.getId() == R.id.image && (listener = this.i) != null && listener != null) {
            listener.onImageClicked();
        }
    }

    @Override // com.avito.android.ui.fragments.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        GalleryTracker galleryTracker = this.tracker;
        if (galleryTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tracker");
        }
        galleryTracker.startInit();
        Bundle arguments = getArguments();
        if (arguments != null) {
            Intrinsics.checkNotNullExpressionValue(arguments, "arguments ?: return");
            this.j = (Image) arguments.getParcelable("image");
            this.f = arguments.getBoolean("crop");
            Serializable serializable = arguments.getSerializable("type");
            Objects.requireNonNull(serializable, "null cannot be cast to non-null type com.avito.android.photo_gallery.GalleryFragmentType");
            this.h = (GalleryFragmentType) serializable;
            this.g = arguments.getBoolean("fastOpen");
            String string = arguments.getString(BookingInfoActivity.EXTRA_ITEM_ID);
            if (string == null) {
                string = "";
            }
            this.n = string;
            this.k = (ForegroundImage) arguments.getParcelable("foreground_info");
            this.l = arguments.containsKey("ratio") ? Float.valueOf(arguments.getFloat("ratio")) : null;
            if (this.h == GalleryFragmentType.AUTOTEKA_TEASER) {
                this.q = (AutotekaTeaserGalleryModel) arguments.getParcelable("teaser");
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        int i2;
        View view;
        Float f2;
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        GalleryFragmentType galleryFragmentType = this.h;
        GalleryFragmentType galleryFragmentType2 = GalleryFragmentType.AUTOTEKA_TEASER;
        if (galleryFragmentType == galleryFragmentType2) {
            ManuallyExposedAbTestGroup<AdvertAutotekaTeaserInGalleryTestGroup> manuallyExposedAbTestGroup = this.autotekaTeaserInGalleryTestGroup;
            if (manuallyExposedAbTestGroup == null) {
                Intrinsics.throwUninitializedPropertyAccessException("autotekaTeaserInGalleryTestGroup");
            }
            int ordinal = manuallyExposedAbTestGroup.getTestGroup().ordinal();
            if (ordinal == 2) {
                i2 = R.layout.gallery_item_autoteka_teaser_b;
            } else if (ordinal == 3) {
                i2 = R.layout.gallery_item_autoteka_teaser_a;
            } else {
                throw new IllegalStateException("Group should be TEASER_WITHOUT_OVERVIEW or TEASER_WITH_OVERVIEW");
            }
        } else if (this.f) {
            i2 = R.layout.gallery_item;
        } else if (galleryFragmentType == GalleryFragmentType.VIDEO) {
            i2 = R.layout.gallery_item_video;
        } else {
            i2 = R.layout.gallery_item_zoomable;
        }
        View inflate = layoutInflater.inflate(i2, viewGroup, false);
        if (this.h != galleryFragmentType2 || !(inflate instanceof AutotekaTeaserView)) {
            Objects.requireNonNull(inflate, "null cannot be cast to non-null type android.widget.FrameLayout");
            FrameLayout frameLayout = (FrameLayout) inflate;
            frameLayout.setForegroundGravity(17);
            SimpleDraweeView simpleDraweeView = (SimpleDraweeView) frameLayout.findViewById(R.id.image);
            if (simpleDraweeView != null) {
                simpleDraweeView.setOnClickListener(this);
            }
            this.c = simpleDraweeView;
            if (simpleDraweeView instanceof ZoomableDraweeView) {
                ZoomableDraweeView zoomableDraweeView = (ZoomableDraweeView) simpleDraweeView;
                zoomableDraweeView.setZoomableController(this.d);
                ZoomableController zoomableController = zoomableDraweeView.getZoomableController();
                Objects.requireNonNull(zoomableController, "null cannot be cast to non-null type com.avito.android.photo_gallery.zoom.AnimatedZoomableController");
                zoomableDraweeView.setTapListener(new GestureDetector.SimpleOnGestureListener((AnimatedZoomableController) zoomableController, zoomableDraweeView) { // from class: com.avito.android.photo_gallery.GalleryFragment$setTapListener$1
                    public final PointF a = new PointF();
                    public final PointF b = new PointF();
                    public final /* synthetic */ AnimatedZoomableController d;
                    public final /* synthetic */ ZoomableDraweeView e;

                    {
                        this.d = r2;
                        this.e = r3;
                    }

                    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
                    public boolean onDoubleTapEvent(@NotNull MotionEvent motionEvent) {
                        Intrinsics.checkNotNullParameter(motionEvent, "e");
                        PointF pointF = new PointF(motionEvent.getX(), motionEvent.getY());
                        PointF mapViewToImage = this.d.mapViewToImage(pointF);
                        int action = motionEvent.getAction();
                        if (action == 0) {
                            this.a.set(pointF);
                            this.b.set(mapViewToImage);
                        } else if (action == 1) {
                            if (this.d.getScaleFactor() < 1.5f) {
                                this.d.zoomToPoint(2.0f, mapViewToImage, pointF, 11, 300, null);
                            } else {
                                this.d.zoomToPoint(1.0f, mapViewToImage, pointF, 11, 300, null);
                            }
                        }
                        return true;
                    }

                    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
                    public boolean onSingleTapConfirmed(@Nullable MotionEvent motionEvent) {
                        if (!GalleryFragment.access$getImageSuccessLoaded$p(GalleryFragment.this)) {
                            return true;
                        }
                        GalleryFragment.this.onClick(this.e);
                        return true;
                    }
                });
                zoomableDraweeView.setZoomListener(null);
            } else if ((simpleDraweeView instanceof FixedRatioImageView) && (f2 = this.l) != null) {
                ((FixedRatioImageView) simpleDraweeView).setRatio(f2.floatValue());
            }
            this.e = frameLayout.findViewById(R.id.image_progress);
            a();
            if (this.h == GalleryFragmentType.VIDEO) {
                frameLayout.setForeground(requireContext().getDrawable(R.drawable.gallery_video_overlay));
            }
            if (this.g && (view = this.e) != null) {
                view.setVisibility(8);
            }
        } else {
            AutotekaTeaserView autotekaTeaserView = (AutotekaTeaserView) inflate;
            this.p = autotekaTeaserView;
            if (autotekaTeaserView != null) {
                autotekaTeaserView.setData(this.q);
                autotekaTeaserView.setListener(this.r);
            }
        }
        GalleryTracker galleryTracker = this.tracker;
        if (galleryTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tracker");
        }
        galleryTracker.trackInit();
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        SimpleDraweeView simpleDraweeView = this.c;
        if (simpleDraweeView != null) {
            simpleDraweeView.setOnClickListener(null);
        }
        this.c = null;
        this.d = null;
        this.e = null;
        super.onDestroyView();
    }

    @Override // com.avito.android.image_loader.ImageRequestListener
    public void onFailed() {
        View view;
        if (!(!(!this.g) || (view = this.e) == null || view == null)) {
            view.setVisibility(8);
        }
        Listener listener = this.i;
        if (listener != null && listener != null) {
            listener.onImageLoadFailed();
        }
    }

    @Override // com.avito.android.image_loader.ImageRequestListener
    public void onLoaded(int i2, int i3) {
        View view;
        GalleryTracker galleryTracker = this.tracker;
        if (galleryTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tracker");
        }
        galleryTracker.trackLoading();
        GalleryTracker galleryTracker2 = this.tracker;
        if (galleryTracker2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tracker");
        }
        galleryTracker2.startDraw();
        this.m = true;
        SimpleDraweeView simpleDraweeView = this.c;
        if (!(simpleDraweeView == null || simpleDraweeView == null)) {
            simpleDraweeView.setVisibility(0);
        }
        if (!(!(true ^ this.g) || (view = this.e) == null || view == null)) {
            view.setVisibility(8);
        }
        Listener listener = this.i;
        if (!(listener == null || listener == null)) {
            listener.onImageLoadSuccess();
        }
        GalleryTracker galleryTracker3 = this.tracker;
        if (galleryTracker3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tracker");
        }
        galleryTracker3.trackDraw();
    }

    @Override // com.avito.android.image_loader.ImageRequestListener
    public void onStarted() {
        View view;
        this.m = false;
        if (this.g && (view = this.e) != null) {
            view.setVisibility(8);
        }
    }

    @Override // com.avito.android.photo_gallery.ZoomableFragment
    public void resetZoom() {
        if (!this.f && this.h != GalleryFragmentType.VIDEO && (this.c instanceof ZoomableDraweeView)) {
            this.d.reset();
        }
    }

    public final void setAnalytics(@NotNull Analytics analytics2) {
        Intrinsics.checkNotNullParameter(analytics2, "<set-?>");
        this.analytics = analytics2;
    }

    public final void setAutotekaListener(@NotNull AutotekaListener autotekaListener) {
        Intrinsics.checkNotNullParameter(autotekaListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.r = autotekaListener;
        AutotekaTeaserView autotekaTeaserView = this.p;
        if (autotekaTeaserView != null) {
            autotekaTeaserView.setListener(autotekaListener);
        }
    }

    public final void setAutotekaTeaserInGalleryTestGroup(@NotNull ManuallyExposedAbTestGroup<AdvertAutotekaTeaserInGalleryTestGroup> manuallyExposedAbTestGroup) {
        Intrinsics.checkNotNullParameter(manuallyExposedAbTestGroup, "<set-?>");
        this.autotekaTeaserInGalleryTestGroup = manuallyExposedAbTestGroup;
    }

    public final void setConnectivityProvider(@NotNull ConnectivityProvider connectivityProvider2) {
        Intrinsics.checkNotNullParameter(connectivityProvider2, "<set-?>");
        this.connectivityProvider = connectivityProvider2;
    }

    public final void setFeatures(@NotNull Features features2) {
        Intrinsics.checkNotNullParameter(features2, "<set-?>");
        this.features = features2;
    }

    public final void setListener(@Nullable Listener listener) {
        this.i = listener;
    }

    public final void setTracker(@NotNull GalleryTracker galleryTracker) {
        Intrinsics.checkNotNullParameter(galleryTracker, "<set-?>");
        this.tracker = galleryTracker;
    }

    @Override // com.avito.android.ui.fragments.BaseFragment
    public boolean setUpFragmentComponent(@Nullable Bundle bundle) {
        Screen screen;
        Timer B1 = a2.b.a.a.a.B1();
        Bundle arguments = getArguments();
        if (arguments == null || (screen = (Screen) arguments.getParcelable(InternalConstsKt.SCREEN)) == null) {
            throw new IllegalArgumentException();
        }
        Intrinsics.checkNotNullExpressionValue(screen, "arguments?.getParcelable…llegalArgumentException()");
        Bundle arguments2 = getArguments();
        if (arguments2 != null) {
            DaggerGalleryComponent.factory().create((GalleryDependencies) ComponentDependenciesKt.getDependencies(GalleryDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder(this)), screen, arguments2.getBoolean("sub_component", false)).inject(this);
            GalleryTracker galleryTracker = this.tracker;
            if (galleryTracker == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tracker");
            }
            galleryTracker.trackDiInject(B1.elapsed());
            return true;
        }
        throw new IllegalArgumentException();
    }

    public final void showOpenTeaserButton(boolean z) {
        AutotekaTeaserView autotekaTeaserView = this.p;
        if (autotekaTeaserView != null) {
            autotekaTeaserView.showOpenTeaserButton(z);
        }
    }

    public final void updateImage(@Nullable Image image, @Nullable ForegroundImage foregroundImage) {
        this.j = image;
        this.k = foregroundImage;
        if (isVisible()) {
            a();
        }
    }
}
