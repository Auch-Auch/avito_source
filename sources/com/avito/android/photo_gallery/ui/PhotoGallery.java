package com.avito.android.photo_gallery.ui;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.screens.InternalConstsKt;
import com.avito.android.analytics.screens.Screen;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.photo_gallery.R;
import com.avito.android.photo_gallery.adapter.GalleryAdapter;
import com.avito.android.photo_gallery.adapter.GalleryItem;
import com.avito.android.photo_gallery.common.GalleryPageListener;
import com.avito.android.photo_gallery.common.ImageLoadListener;
import com.avito.android.photo_gallery.common.ToastsKt;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.ForegroundImage;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.Video;
import com.avito.android.remote.model.autoteka.AutotekaTeaserGalleryModel;
import com.avito.android.util.AnimationUtils;
import com.avito.android.util.Contexts;
import com.avito.android.util.ImplicitIntentFactory;
import com.avito.android.util.Views;
import com.vk.sdk.api.VKApiConst;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000º\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u0011\b\u0016\u0012\u0006\u0010i\u001a\u00020h¢\u0006\u0004\bj\u0010kB\u0019\b\u0016\u0012\u0006\u0010i\u001a\u00020h\u0012\u0006\u0010m\u001a\u00020l¢\u0006\u0004\bj\u0010nB!\b\u0016\u0012\u0006\u0010i\u001a\u00020h\u0012\u0006\u0010m\u001a\u00020l\u0012\u0006\u0010o\u001a\u00020\u0018¢\u0006\u0004\bj\u0010pJ\u000f\u0010\u0006\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0006\u0010\u0007J±\u0001\u0010'\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u00042\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\b\u0002\u0010\u0019\u001a\u00020\u00182\b\b\u0002\u0010\u001b\u001a\u00020\u001a2\b\b\u0002\u0010\u001d\u001a\u00020\u001c2\b\b\u0002\u0010\u001e\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020\u001f2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010!2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010#2\b\u0010&\u001a\u0004\u0018\u00010%¢\u0006\u0004\b'\u0010(J'\u0010,\u001a\u00020\u00052\u0006\u0010)\u001a\u00020\u00182\u0006\u0010*\u001a\u00020\u001c2\b\b\u0002\u0010+\u001a\u00020\u001c¢\u0006\u0004\b,\u0010-J\u0015\u00100\u001a\u00020\u001c2\u0006\u0010/\u001a\u00020.¢\u0006\u0004\b0\u00101J'\u00104\u001a\u00020\u00052\u0006\u0010)\u001a\u00020\u00182\u0006\u00102\u001a\u00020#2\u0006\u00103\u001a\u00020\u0018H\u0016¢\u0006\u0004\b4\u00105J\u0017\u00106\u001a\u00020\u00052\u0006\u0010)\u001a\u00020\u0018H\u0016¢\u0006\u0004\b6\u00107J\u0017\u00109\u001a\u00020\u00052\u0006\u00108\u001a\u00020\u0018H\u0016¢\u0006\u0004\b9\u00107J\u0017\u0010;\u001a\u00020\u00052\u0006\u0010:\u001a\u00020#H\u0016¢\u0006\u0004\b;\u0010<J\u000f\u0010=\u001a\u00020\u0005H\u0016¢\u0006\u0004\b=\u0010\u0007J\u000f\u0010>\u001a\u00020\u0005H\u0016¢\u0006\u0004\b>\u0010\u0007J\r\u0010?\u001a\u00020\u0005¢\u0006\u0004\b?\u0010\u0007J\u0015\u0010B\u001a\u00020\u00052\u0006\u0010A\u001a\u00020@¢\u0006\u0004\bB\u0010CJ\u000f\u0010D\u001a\u0004\u0018\u00010@¢\u0006\u0004\bD\u0010EJ)\u0010G\u001a\u00020\u00052\u0006\u0010F\u001a\u00020\u00182\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0019\u001a\u00020\u0018H\u0002¢\u0006\u0004\bG\u0010HR\"\u0010J\u001a\u00020I8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bJ\u0010K\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR\u0018\u0010S\u001a\u0004\u0018\u00010P8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bQ\u0010RR\u0016\u0010V\u001a\u00020T8\u0002@\u0002X.¢\u0006\u0006\n\u0004\bG\u0010UR\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bW\u0010XR\u0013\u0010[\u001a\u00020.8F@\u0006¢\u0006\u0006\u001a\u0004\bY\u0010ZR\u0018\u0010^\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\\\u0010]R\u0013\u0010a\u001a\u00020\u00188F@\u0006¢\u0006\u0006\u001a\u0004\b_\u0010`R\u0016\u0010e\u001a\u00020b8\u0002@\u0002X.¢\u0006\u0006\n\u0004\bc\u0010dR\u0016\u0010\u001b\u001a\u00020\u001a8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bf\u0010g¨\u0006q"}, d2 = {"Lcom/avito/android/photo_gallery/ui/PhotoGallery;", "Landroid/widget/FrameLayout;", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "Lcom/avito/android/photo_gallery/ui/ParallaxProgressListener;", "Lcom/avito/android/photo_gallery/common/ImageLoadListener;", "", "onFinishInflate", "()V", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "Lcom/avito/android/remote/model/Video;", "video", "", "Lcom/avito/android/remote/model/Image;", "images", "", BookingInfoActivity.EXTRA_ITEM_ID, "Lcom/avito/android/util/ImplicitIntentFactory;", "implicitIntentFactory", "Lcom/avito/android/analytics/Analytics;", "analytics", "imageLoadListener", "Lcom/avito/android/photo_gallery/common/GalleryPageListener;", "galleryPageListener", "", "currentPosition", "", "stateId", "", "isRedesign", "isFastOpen", "Lcom/avito/android/analytics/screens/Screen;", InternalConstsKt.SCREEN, "Lcom/avito/android/remote/model/ForegroundImage;", "foregroundImage", "", "ratio", "Lcom/avito/android/remote/model/autoteka/AutotekaTeaserGalleryModel;", "autotekaTeaser", "initGallery", "(Landroidx/fragment/app/FragmentManager;Lcom/avito/android/remote/model/Video;Ljava/util/List;Ljava/lang/String;Lcom/avito/android/util/ImplicitIntentFactory;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/photo_gallery/common/ImageLoadListener;Lcom/avito/android/photo_gallery/common/GalleryPageListener;IJZZLcom/avito/android/analytics/screens/Screen;Lcom/avito/android/remote/model/ForegroundImage;Ljava/lang/Float;Lcom/avito/android/remote/model/autoteka/AutotekaTeaserGalleryModel;)V", VKApiConst.POSITION, "delayed", "smoothScroll", "setCurrentItem", "(IZZ)V", "Lcom/avito/android/photo_gallery/adapter/GalleryItem;", "item", "canShowFullscreen", "(Lcom/avito/android/photo_gallery/adapter/GalleryItem;)Z", "positionOffset", "positionOffsetPixels", "onPageScrolled", "(IFI)V", "onPageSelected", "(I)V", "state", "onPageScrollStateChanged", "percentage", "onChangeParallax", "(F)V", "onImageLoadFailed", "onImageLoadSuccess", "destroy", "Lcom/avito/android/photo_gallery/ui/PageIndicatorType;", "type", "setPageIndicatorType", "(Lcom/avito/android/photo_gallery/ui/PageIndicatorType;)V", "pageIndicatorType", "()Lcom/avito/android/photo_gallery/ui/PageIndicatorType;", "imagesCount", AuthSource.SEND_ABUSE, "(ILcom/avito/android/remote/model/Video;I)V", "Landroidx/viewpager/widget/ViewPager;", "pager", "Landroidx/viewpager/widget/ViewPager;", "getPager", "()Landroidx/viewpager/widget/ViewPager;", "setPager", "(Landroidx/viewpager/widget/ViewPager;)V", "Landroid/widget/Toast;", "c", "Landroid/widget/Toast;", "mImageProblemToast", "Landroid/os/Handler;", "Landroid/os/Handler;", "galleryHandler", "e", "Lcom/avito/android/photo_gallery/common/GalleryPageListener;", "getCurrentItem", "()Lcom/avito/android/photo_gallery/adapter/GalleryItem;", "currentItem", "d", "Lcom/avito/android/photo_gallery/common/ImageLoadListener;", "imageLoadedListener", "getItemCount", "()I", "itemCount", "Lcom/avito/android/photo_gallery/ui/GalleryPageIndicatorView;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/photo_gallery/ui/GalleryPageIndicatorView;", "mPagerIndicator", "f", "J", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "photo-gallery_release"}, k = 1, mv = {1, 4, 2})
public final class PhotoGallery extends FrameLayout implements ViewPager.OnPageChangeListener, ParallaxProgressListener, ImageLoadListener {
    public Handler a;
    public GalleryPageIndicatorView b;
    public Toast c;
    public ImageLoadListener d;
    public GalleryPageListener e;
    public long f = -1;
    public ViewPager pager;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            PageIndicatorType.values();
            int[] iArr = new int[2];
            $EnumSwitchMapping$0 = iArr;
            iArr[0] = 1;
            iArr[1] = 2;
        }
    }

    public static final class a implements Runnable {
        public final /* synthetic */ GalleryAdapter a;
        public final /* synthetic */ Video b;
        public final /* synthetic */ List c;
        public final /* synthetic */ ForegroundImage d;

        public a(GalleryAdapter galleryAdapter, Video video, List list, ForegroundImage foregroundImage) {
            this.a = galleryAdapter;
            this.b = video;
            this.c = list;
            this.d = foregroundImage;
        }

        @Override // java.lang.Runnable
        public final void run() {
            GalleryAdapter.setItems$default(this.a, this.b, this.c, this.d, null, 8, null);
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ PhotoGallery a;
        public final /* synthetic */ int b;
        public final /* synthetic */ Video c;
        public final /* synthetic */ int d;

        public b(PhotoGallery photoGallery, int i, Video video, int i2) {
            this.a = photoGallery;
            this.b = i;
            this.c = video;
            this.d = i2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.a(this.b, this.c, this.d);
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ PhotoGallery a;
        public final /* synthetic */ int b;
        public final /* synthetic */ boolean c;

        public c(PhotoGallery photoGallery, int i, boolean z) {
            this.a = photoGallery;
            this.b = i;
            this.c = z;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.getPager().setCurrentItem(this.b, this.c);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PhotoGallery(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public static final /* synthetic */ GalleryPageIndicatorView access$getMPagerIndicator$p(PhotoGallery photoGallery) {
        GalleryPageIndicatorView galleryPageIndicatorView = photoGallery.b;
        if (galleryPageIndicatorView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPagerIndicator");
        }
        return galleryPageIndicatorView;
    }

    public static /* synthetic */ void initGallery$default(PhotoGallery photoGallery, FragmentManager fragmentManager, Video video, List list, String str, ImplicitIntentFactory implicitIntentFactory, Analytics analytics, ImageLoadListener imageLoadListener, GalleryPageListener galleryPageListener, int i, long j, boolean z, boolean z2, Screen screen, ForegroundImage foregroundImage, Float f2, AutotekaTeaserGalleryModel autotekaTeaserGalleryModel, int i2, Object obj) {
        photoGallery.initGallery(fragmentManager, video, list, str, implicitIntentFactory, analytics, (i2 & 64) != 0 ? photoGallery : imageLoadListener, (i2 & 128) != 0 ? null : galleryPageListener, (i2 & 256) != 0 ? -1 : i, (i2 & 512) != 0 ? -1 : j, (i2 & 1024) != 0 ? false : z, (i2 & 2048) != 0 ? false : z2, screen, (i2 & 8192) != 0 ? null : foregroundImage, (i2 & 16384) != 0 ? null : f2, autotekaTeaserGalleryModel);
    }

    public static /* synthetic */ void setCurrentItem$default(PhotoGallery photoGallery, int i, boolean z, boolean z2, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z2 = false;
        }
        photoGallery.setCurrentItem(i, z, z2);
    }

    public final void a(int i, Video video, int i2) {
        boolean z = true;
        if (i <= 1 && video == null) {
            z = false;
        }
        if (z) {
            if (i2 > -1) {
                onPageSelected(i2);
            } else {
                ViewPager viewPager = this.pager;
                if (viewPager == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("pager");
                }
                onPageSelected(viewPager.getCurrentItem());
            }
            GalleryPageIndicatorView galleryPageIndicatorView = this.b;
            if (galleryPageIndicatorView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPagerIndicator");
            }
            galleryPageIndicatorView.getView().setVisibility(0);
        } else {
            GalleryPageIndicatorView galleryPageIndicatorView2 = this.b;
            if (galleryPageIndicatorView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPagerIndicator");
            }
            galleryPageIndicatorView2.getView().setVisibility(8);
        }
        setVisibility(0);
    }

    public final boolean canShowFullscreen(@NotNull GalleryItem galleryItem) {
        Intrinsics.checkNotNullParameter(galleryItem, "item");
        if (!(galleryItem instanceof GalleryItem.GalleryImage) && !(galleryItem instanceof GalleryItem.GalleryForegroundImage)) {
            return true;
        }
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        return Contexts.isConnectionAvailable(context);
    }

    public final void destroy() {
        ViewPager viewPager = this.pager;
        if (viewPager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pager");
        }
        PagerAdapter adapter = viewPager.getAdapter();
        if (!(adapter instanceof GalleryAdapter)) {
            adapter = null;
        }
        GalleryAdapter galleryAdapter = (GalleryAdapter) adapter;
        if (galleryAdapter != null) {
            galleryAdapter.destroy();
        }
    }

    @NotNull
    public final GalleryItem getCurrentItem() {
        ViewPager viewPager = this.pager;
        if (viewPager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pager");
        }
        PagerAdapter adapter = viewPager.getAdapter();
        Objects.requireNonNull(adapter, "null cannot be cast to non-null type com.avito.android.photo_gallery.adapter.GalleryAdapter");
        GalleryAdapter galleryAdapter = (GalleryAdapter) adapter;
        ViewPager viewPager2 = this.pager;
        if (viewPager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pager");
        }
        return galleryAdapter.getGalleryItem(viewPager2.getCurrentItem());
    }

    public final int getItemCount() {
        ViewPager viewPager = this.pager;
        if (viewPager == null) {
            return 0;
        }
        if (viewPager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pager");
        }
        PagerAdapter adapter = viewPager.getAdapter();
        if (adapter != null) {
            return adapter.getCount();
        }
        return 0;
    }

    @NotNull
    public final ViewPager getPager() {
        ViewPager viewPager = this.pager;
        if (viewPager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pager");
        }
        return viewPager;
    }

    public final void initGallery(@NotNull FragmentManager fragmentManager, @Nullable Video video, @Nullable List<Image> list, @Nullable String str, @NotNull ImplicitIntentFactory implicitIntentFactory, @NotNull Analytics analytics, @NotNull ImageLoadListener imageLoadListener, @Nullable GalleryPageListener galleryPageListener, int i, long j, boolean z, boolean z2, @NotNull Screen screen, @Nullable ForegroundImage foregroundImage, @Nullable Float f2, @Nullable AutotekaTeaserGalleryModel autotekaTeaserGalleryModel) {
        ForegroundImage foregroundImage2;
        List<Image> list2;
        Video video2;
        PhotoGallery photoGallery;
        Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
        Intrinsics.checkNotNullParameter(implicitIntentFactory, "implicitIntentFactory");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(imageLoadListener, "imageLoadListener");
        Intrinsics.checkNotNullParameter(screen, InternalConstsKt.SCREEN);
        GalleryPageIndicatorView galleryPageIndicatorView = this.b;
        if (galleryPageIndicatorView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPagerIndicator");
        }
        galleryPageIndicatorView.setIsRedesign(z);
        this.f = j;
        this.e = galleryPageListener;
        this.d = imageLoadListener;
        if ((video == null || !video.hasPreviewImage()) && ((list == null || list.isEmpty()) && foregroundImage == null)) {
            imageLoadListener.onImageLoadFailed();
            setVisibility(8);
            return;
        }
        ViewPager viewPager = this.pager;
        if (viewPager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pager");
        }
        GalleryAdapter galleryAdapter = (GalleryAdapter) viewPager.getAdapter();
        if (galleryAdapter == null) {
            ViewPager viewPager2 = this.pager;
            if (viewPager2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pager");
            }
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            viewPager2.setAdapter(new GalleryAdapter(context, fragmentManager, video, list, str, imageLoadListener, implicitIntentFactory, analytics, z2, screen, foregroundImage, f2, autotekaTeaserGalleryModel));
            photoGallery = this;
            video2 = video;
            list2 = list;
            foregroundImage2 = foregroundImage;
        } else if (z2) {
            photoGallery = this;
            Handler handler = photoGallery.a;
            if (handler == null) {
                Intrinsics.throwUninitializedPropertyAccessException("galleryHandler");
            }
            video2 = video;
            list2 = list;
            foregroundImage2 = foregroundImage;
            handler.post(new a(galleryAdapter, video2, list2, foregroundImage2));
        } else {
            photoGallery = this;
            video2 = video;
            list2 = list;
            foregroundImage2 = foregroundImage;
            GalleryAdapter.setItems$default(galleryAdapter, video, list, foregroundImage, null, 8, null);
        }
        int i2 = 0;
        int size = list2 != null ? list.size() : 0;
        if (foregroundImage2 != null) {
            i2 = 1;
        }
        int i3 = size + i2;
        if (z2) {
            Handler handler2 = photoGallery.a;
            if (handler2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("galleryHandler");
            }
            handler2.post(new b(photoGallery, i3, video2, i));
            return;
        }
        photoGallery.a(i3, video2, i);
    }

    @Override // com.avito.android.photo_gallery.ui.ParallaxProgressListener
    public void onChangeParallax(float f2) {
        GalleryPageIndicatorView galleryPageIndicatorView = this.b;
        if (galleryPageIndicatorView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPagerIndicator");
        }
        if (galleryPageIndicatorView.getView().getVisibility() == 0) {
            float f3 = ((float) 1) - f2;
            AnimationUtils animationUtils = AnimationUtils.INSTANCE;
            GalleryPageIndicatorView galleryPageIndicatorView2 = this.b;
            if (galleryPageIndicatorView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPagerIndicator");
            }
            animationUtils.setAlpha(galleryPageIndicatorView2.getView(), (float) Math.pow((double) f3, 4.0d));
        }
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.a = new Handler();
        View findViewById = findViewById(R.id.photo_pager);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type androidx.viewpager.widget.ViewPager");
        ViewPager viewPager = (ViewPager) findViewById;
        this.pager = viewPager;
        if (viewPager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pager");
        }
        viewPager.setOffscreenPageLimit(1);
        ViewPager viewPager2 = this.pager;
        if (viewPager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pager");
        }
        viewPager2.addOnPageChangeListener(this);
        setPageIndicatorType(PageIndicatorType.TEXT);
    }

    @Override // com.avito.android.photo_gallery.common.ImageLoadListener
    public void onImageLoadFailed() {
        ImageLoadListener imageLoadListener;
        if (ToastsKt.isShowing(this.c)) {
            Toast toast = this.c;
            if (!(toast == null || toast == null)) {
                toast.cancel();
            }
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            this.c = com.avito.android.util.ToastsKt.showToast$default(context, R.string.photo_load_error, 0, 2, (Object) null);
        }
        if ((!Intrinsics.areEqual(this.d, this)) && (imageLoadListener = this.d) != null) {
            imageLoadListener.onImageLoadFailed();
        }
    }

    @Override // com.avito.android.photo_gallery.common.ImageLoadListener
    public void onImageLoadSuccess() {
        ImageLoadListener imageLoadListener;
        if ((!Intrinsics.areEqual(this.d, this)) && (imageLoadListener = this.d) != null) {
            imageLoadListener.onImageLoadSuccess();
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f2, int i2) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        ViewPager viewPager = this.pager;
        if (viewPager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pager");
        }
        PagerAdapter adapter = viewPager.getAdapter();
        Integer valueOf = adapter != null ? Integer.valueOf(adapter.getCount()) : null;
        if (valueOf == null || valueOf.intValue() <= 0) {
            GalleryPageIndicatorView galleryPageIndicatorView = this.b;
            if (galleryPageIndicatorView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPagerIndicator");
            }
            galleryPageIndicatorView.setPage(i, valueOf);
        } else {
            int intValue = i < valueOf.intValue() ? i : valueOf.intValue() - 1;
            GalleryPageIndicatorView galleryPageIndicatorView2 = this.b;
            if (galleryPageIndicatorView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPagerIndicator");
            }
            galleryPageIndicatorView2.setPage(intValue, valueOf);
        }
        GalleryPageListener galleryPageListener = this.e;
        if (galleryPageListener != null) {
            galleryPageListener.onPageSelected(i, this.f);
        }
    }

    @Nullable
    public final PageIndicatorType pageIndicatorType() {
        GalleryPageIndicatorView galleryPageIndicatorView = this.b;
        boolean z = galleryPageIndicatorView != null;
        if (z) {
            if (galleryPageIndicatorView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPagerIndicator");
            }
            if (galleryPageIndicatorView instanceof GalleryPageIndicatorText) {
                return PageIndicatorType.TEXT;
            }
        }
        if (z) {
            GalleryPageIndicatorView galleryPageIndicatorView2 = this.b;
            if (galleryPageIndicatorView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPagerIndicator");
            }
            if (galleryPageIndicatorView2 instanceof GalleryPageIndicatorDots) {
                return PageIndicatorType.DOTS;
            }
        }
        return null;
    }

    public final void setCurrentItem(int i, boolean z, boolean z2) {
        if (z) {
            Handler handler = this.a;
            if (handler == null) {
                Intrinsics.throwUninitializedPropertyAccessException("galleryHandler");
            }
            handler.post(new c(this, i, z2));
            return;
        }
        ViewPager viewPager = this.pager;
        if (viewPager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pager");
        }
        viewPager.setCurrentItem(i, false);
    }

    public final void setPageIndicatorType(@NotNull PageIndicatorType pageIndicatorType) {
        GalleryPageIndicatorView galleryPageIndicatorView;
        Intrinsics.checkNotNullParameter(pageIndicatorType, "type");
        if (pageIndicatorType() != pageIndicatorType) {
            GalleryPageIndicatorView galleryPageIndicatorView2 = this.b;
            if (galleryPageIndicatorView2 != null) {
                if (galleryPageIndicatorView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mPagerIndicator");
                }
                Views.removeFromParent(galleryPageIndicatorView2.getView());
            }
            int ordinal = pageIndicatorType.ordinal();
            if (ordinal == 0) {
                galleryPageIndicatorView = new GalleryPageIndicatorText(this);
            } else if (ordinal == 1) {
                ViewPager viewPager = this.pager;
                if (viewPager == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("pager");
                }
                galleryPageIndicatorView = new GalleryPageIndicatorDots(this, viewPager);
            } else {
                throw new NoWhenBranchMatchedException();
            }
            this.b = galleryPageIndicatorView;
        }
    }

    public final void setPager(@NotNull ViewPager viewPager) {
        Intrinsics.checkNotNullParameter(viewPager, "<set-?>");
        this.pager = viewPager;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PhotoGallery(@NotNull Context context, @NotNull AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, "attrs");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PhotoGallery(@NotNull Context context, @NotNull AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, "attrs");
    }
}
