package com.avito.android.photo_gallery.adapter;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.net.Uri;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.event.NonFatalError;
import com.avito.android.analytics.screens.InternalConstsKt;
import com.avito.android.analytics.screens.Screen;
import com.avito.android.autoteka_details.core.analytics.event.AutotekaDetailsGetReportClickEvent;
import com.avito.android.autoteka_details.core.analytics.event.FromBlock;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.photo_gallery.GalleryFragment;
import com.avito.android.photo_gallery.GalleryFragmentKt;
import com.avito.android.photo_gallery.GalleryFragmentType;
import com.avito.android.photo_gallery.adapter.GalleryItem;
import com.avito.android.photo_gallery.common.ImageLoadListener;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.ForegroundImage;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.Video;
import com.avito.android.remote.model.autoteka.AutotekaTeaserGalleryModel;
import com.avito.android.util.ImplicitIntentFactory;
import com.vk.sdk.api.VKApiConst;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0001\u0012\u0006\u0010'\u001a\u00020$\u0012\u0006\u0010K\u001a\u00020H\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u0012\b\u0010G\u001a\u0004\u0018\u00010D\u0012\u0006\u0010;\u001a\u000208\u0012\u0006\u00103\u001a\u000200\u0012\u0006\u0010/\u001a\u00020,\u0012\b\b\u0002\u00107\u001a\u000204\u0012\u0006\u0010+\u001a\u00020(\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010?\u001a\u0004\u0018\u00010<\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\bL\u0010MJ?\u0010\f\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u001cH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\r\u0010 \u001a\u00020\u000b¢\u0006\u0004\b \u0010!R\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00170\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u0016\u00107\u001a\u0002048\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b5\u00106R\u0016\u0010;\u001a\u0002088\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b9\u0010:R\u0018\u0010?\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b=\u0010>R\u001c\u0010C\u001a\b\u0012\u0004\u0012\u00020A0@8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bB\u0010#R\u0018\u0010G\u001a\u0004\u0018\u00010D8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bE\u0010FR\u0016\u0010K\u001a\u00020H8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bI\u0010J¨\u0006N"}, d2 = {"Lcom/avito/android/photo_gallery/adapter/GalleryAdapter;", "Landroidx/fragment/app/FragmentStatePagerAdapter;", "Lcom/avito/android/remote/model/Video;", "video", "", "Lcom/avito/android/remote/model/Image;", "items", "Lcom/avito/android/remote/model/ForegroundImage;", "foregroundImage", "Lcom/avito/android/remote/model/autoteka/AutotekaTeaserGalleryModel;", "autotekaTeaser", "", "setItems", "(Lcom/avito/android/remote/model/Video;Ljava/util/List;Lcom/avito/android/remote/model/ForegroundImage;Lcom/avito/android/remote/model/autoteka/AutotekaTeaserGalleryModel;)V", "Landroid/view/ViewGroup;", "container", "", VKApiConst.POSITION, "Lcom/avito/android/photo_gallery/GalleryFragment;", "instantiateItem", "(Landroid/view/ViewGroup;I)Lcom/avito/android/photo_gallery/GalleryFragment;", "getItem", "(I)Lcom/avito/android/photo_gallery/GalleryFragment;", "Lcom/avito/android/photo_gallery/adapter/GalleryItem;", "getGalleryItem", "(I)Lcom/avito/android/photo_gallery/adapter/GalleryItem;", "getCount", "()I", "", "item", "getItemPosition", "(Ljava/lang/Object;)I", "destroy", "()V", "j", "Ljava/util/List;", "Landroid/content/Context;", "l", "Landroid/content/Context;", "context", "Lcom/avito/android/analytics/screens/Screen;", "s", "Lcom/avito/android/analytics/screens/Screen;", InternalConstsKt.SCREEN, "Lcom/avito/android/analytics/Analytics;", VKApiConst.Q, "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/util/ImplicitIntentFactory;", "p", "Lcom/avito/android/util/ImplicitIntentFactory;", "implicitIntentFactory", "", "r", "Z", "isFastOpen", "Lcom/avito/android/photo_gallery/common/ImageLoadListener;", "o", "Lcom/avito/android/photo_gallery/common/ImageLoadListener;", "imageLoadListener", "", "t", "Ljava/lang/Float;", "ratio", "", "Landroidx/fragment/app/Fragment;", "k", "fragments", "", "n", "Ljava/lang/String;", BookingInfoActivity.EXTRA_ITEM_ID, "Landroidx/fragment/app/FragmentManager;", AuthSource.OPEN_CHANNEL_LIST, "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "<init>", "(Landroid/content/Context;Landroidx/fragment/app/FragmentManager;Lcom/avito/android/remote/model/Video;Ljava/util/List;Ljava/lang/String;Lcom/avito/android/photo_gallery/common/ImageLoadListener;Lcom/avito/android/util/ImplicitIntentFactory;Lcom/avito/android/analytics/Analytics;ZLcom/avito/android/analytics/screens/Screen;Lcom/avito/android/remote/model/ForegroundImage;Ljava/lang/Float;Lcom/avito/android/remote/model/autoteka/AutotekaTeaserGalleryModel;)V", "photo-gallery_release"}, k = 1, mv = {1, 4, 2})
public final class GalleryAdapter extends FragmentStatePagerAdapter {
    public List<? extends GalleryItem> j;
    public final List<Fragment> k;
    public final Context l;
    public final FragmentManager m;
    public final String n;
    public final ImageLoadListener o;
    public final ImplicitIntentFactory p;
    public final Analytics q;
    public final boolean r;
    public final Screen s;
    public final Float t;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GalleryAdapter(Context context, FragmentManager fragmentManager, Video video, List list, String str, ImageLoadListener imageLoadListener, ImplicitIntentFactory implicitIntentFactory, Analytics analytics, boolean z, Screen screen, ForegroundImage foregroundImage, Float f, AutotekaTeaserGalleryModel autotekaTeaserGalleryModel, int i, j jVar) {
        this(context, fragmentManager, video, list, str, imageLoadListener, implicitIntentFactory, analytics, (i & 256) != 0 ? false : z, screen, (i & 1024) != 0 ? null : foregroundImage, (i & 2048) != 0 ? null : f, autotekaTeaserGalleryModel);
    }

    public static GalleryFragment a(GalleryAdapter galleryAdapter, Image image, GalleryFragmentType galleryFragmentType, ForegroundImage foregroundImage, GalleryItem.GalleryTeaserAutoteka galleryTeaserAutoteka, int i) {
        ForegroundImage foregroundImage2 = (i & 4) != 0 ? null : foregroundImage;
        GalleryItem.GalleryTeaserAutoteka galleryTeaserAutoteka2 = (i & 8) != 0 ? null : galleryTeaserAutoteka;
        boolean z = galleryAdapter.r;
        Screen screen = galleryAdapter.s;
        String str = galleryAdapter.n;
        if (str == null) {
            str = "";
        }
        GalleryFragment newGalleryFragmentInstance = GalleryFragmentKt.newGalleryFragmentInstance(image, true, galleryFragmentType, z, true, screen, str, foregroundImage2, galleryAdapter.t, galleryTeaserAutoteka2);
        galleryAdapter.k.add(newGalleryFragmentInstance);
        return newGalleryFragmentInstance;
    }

    public static /* synthetic */ void setItems$default(GalleryAdapter galleryAdapter, Video video, List list, ForegroundImage foregroundImage, AutotekaTeaserGalleryModel autotekaTeaserGalleryModel, int i, Object obj) {
        if ((i & 4) != 0) {
            foregroundImage = null;
        }
        if ((i & 8) != 0) {
            autotekaTeaserGalleryModel = null;
        }
        galleryAdapter.setItems(video, list, foregroundImage, autotekaTeaserGalleryModel);
    }

    public final void destroy() {
        if (!this.k.isEmpty()) {
            FragmentTransaction beginTransaction = this.m.beginTransaction();
            Intrinsics.checkNotNullExpressionValue(beginTransaction, "fragmentManager.beginTransaction()");
            for (Fragment fragment : this.k) {
                beginTransaction.remove(fragment);
            }
            beginTransaction.commitAllowingStateLoss();
        }
        this.k.clear();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.j.size();
    }

    @NotNull
    public final GalleryItem getGalleryItem(int i) {
        return (GalleryItem) this.j.get(i);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(@NotNull Object obj) {
        Intrinsics.checkNotNullParameter(obj, "item");
        if (!this.r) {
            return -2;
        }
        Fragment fragment = (Fragment) CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) this.k);
        GalleryItem galleryItem = (GalleryItem) CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) this.j);
        if (!Intrinsics.areEqual(obj, fragment) || !(fragment instanceof GalleryFragment)) {
            return -2;
        }
        if (galleryItem instanceof GalleryItem.GalleryImage) {
            GalleryFragment.updateImage$default((GalleryFragment) fragment, ((GalleryItem.GalleryImage) galleryItem).getImage(), null, 2, null);
        } else if (galleryItem instanceof GalleryItem.GalleryForegroundImage) {
            ((GalleryFragment) fragment).updateImage(null, ((GalleryItem.GalleryForegroundImage) galleryItem).getForegroundImage());
        }
        return super.getItemPosition(obj);
    }

    public final void setItems(@Nullable Video video, @Nullable List<Image> list, @Nullable ForegroundImage foregroundImage, @Nullable AutotekaTeaserGalleryModel autotekaTeaserGalleryModel) {
        List<GalleryItem> photoGalleryCollectItems = GalleryAdapterKt.photoGalleryCollectItems(video, list, foregroundImage, autotekaTeaserGalleryModel);
        boolean z = !Intrinsics.areEqual(this.j, photoGalleryCollectItems);
        this.j = photoGalleryCollectItems;
        if (z) {
            notifyDataSetChanged();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GalleryAdapter(@NotNull Context context, @NotNull FragmentManager fragmentManager, @Nullable Video video, @Nullable List<Image> list, @Nullable String str, @NotNull ImageLoadListener imageLoadListener, @NotNull ImplicitIntentFactory implicitIntentFactory, @NotNull Analytics analytics, boolean z, @NotNull Screen screen, @Nullable ForegroundImage foregroundImage, @Nullable Float f, @Nullable AutotekaTeaserGalleryModel autotekaTeaserGalleryModel) {
        super(fragmentManager, 1);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
        Intrinsics.checkNotNullParameter(imageLoadListener, "imageLoadListener");
        Intrinsics.checkNotNullParameter(implicitIntentFactory, "implicitIntentFactory");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(screen, InternalConstsKt.SCREEN);
        this.l = context;
        this.m = fragmentManager;
        this.n = str;
        this.o = imageLoadListener;
        this.p = implicitIntentFactory;
        this.q = analytics;
        this.r = z;
        this.s = screen;
        this.t = f;
        this.k = new ArrayList();
        this.j = GalleryAdapterKt.photoGalleryCollectItems(video, list, foregroundImage, autotekaTeaserGalleryModel);
    }

    @Override // androidx.fragment.app.FragmentStatePagerAdapter
    @NotNull
    public GalleryFragment getItem(int i) {
        GalleryFragment a;
        GalleryItem galleryItem = (GalleryItem) this.j.get(i);
        if (galleryItem instanceof GalleryItem.GalleryImage) {
            return a(this, ((GalleryItem.GalleryImage) galleryItem).getImage(), GalleryFragmentType.IMAGE, null, null, 12);
        }
        if (galleryItem instanceof GalleryItem.GalleryForegroundImage) {
            return a(this, null, GalleryFragmentType.IMAGE, ((GalleryItem.GalleryForegroundImage) galleryItem).getForegroundImage(), null, 8);
        }
        if (galleryItem instanceof GalleryItem.GalleryVideo) {
            Video video = ((GalleryItem.GalleryVideo) galleryItem).getVideo();
            a = a(this, video.getPreviewImage(), GalleryFragmentType.VIDEO, null, null, 12);
            a.setListener(new GalleryFragment.Listener(video) { // from class: com.avito.android.photo_gallery.adapter.GalleryAdapter$getVideoFragment$1
                public final /* synthetic */ Video b;

                {
                    this.b = r2;
                }

                @Override // com.avito.android.photo_gallery.GalleryFragment.Listener
                public void onImageClicked() {
                    try {
                        GalleryAdapter.access$getContext$p(GalleryAdapter.this).startActivity(GalleryAdapter.access$getImplicitIntentFactory$p(GalleryAdapter.this).uriIntent(this.b.getVideoUrl()));
                    } catch (ActivityNotFoundException e) {
                        GalleryAdapter.access$getAnalytics$p(GalleryAdapter.this).track(new NonFatalError("Error while try open video", e, null, 4, null));
                    }
                }

                @Override // com.avito.android.photo_gallery.GalleryFragment.Listener
                public void onImageLoadFailed() {
                    GalleryAdapter.access$getImageLoadListener$p(GalleryAdapter.this).onImageLoadFailed();
                }

                @Override // com.avito.android.photo_gallery.GalleryFragment.Listener
                public void onImageLoadSuccess() {
                    GalleryAdapter.access$getImageLoadListener$p(GalleryAdapter.this).onImageLoadSuccess();
                }
            });
        } else if (galleryItem instanceof GalleryItem.GalleryTeaserAutoteka) {
            GalleryItem.GalleryTeaserAutoteka galleryTeaserAutoteka = (GalleryItem.GalleryTeaserAutoteka) galleryItem;
            a = a(this, null, GalleryFragmentType.AUTOTEKA_TEASER, null, galleryTeaserAutoteka, 4);
            a.setListener(new GalleryFragment.Listener(this, galleryTeaserAutoteka) { // from class: com.avito.android.photo_gallery.adapter.GalleryAdapter$getTeaserAutotekaFragment$$inlined$apply$lambda$1
                public final /* synthetic */ GalleryAdapter b;
                public final /* synthetic */ GalleryItem.GalleryTeaserAutoteka c;

                {
                    this.b = r2;
                    this.c = r3;
                }

                @Override // com.avito.android.photo_gallery.GalleryFragment.Listener
                public void onImageClicked() {
                    Context context = GalleryFragment.this.getContext();
                    if (context != null) {
                        context.startActivity(ImplicitIntentFactory.DefaultImpls.uriIntentCustomChromeTabs$default(GalleryAdapter.access$getImplicitIntentFactory$p(this.b), this.c.getAutotekaTeaser().getReportLink().getUrl(), false, 2, null));
                    }
                    String access$getAdvertId$p = GalleryAdapter.access$getAdvertId$p(this.b);
                    if (access$getAdvertId$p != null) {
                        Analytics analytics = GalleryFragment.this.getAnalytics();
                        String uri = this.c.getAutotekaTeaser().getReportLink().getUrl().toString();
                        Intrinsics.checkNotNullExpressionValue(uri, "item.autotekaTeaser.reportLink.url.toString()");
                        analytics.track(new AutotekaDetailsGetReportClickEvent(access$getAdvertId$p, uri, FromBlock.OLD_TEASER));
                    }
                }

                @Override // com.avito.android.photo_gallery.GalleryFragment.Listener
                public void onImageLoadFailed() {
                }

                @Override // com.avito.android.photo_gallery.GalleryFragment.Listener
                public void onImageLoadSuccess() {
                }
            });
        } else {
            throw new NoWhenBranchMatchedException();
        }
        return a;
    }

    @Override // androidx.fragment.app.FragmentStatePagerAdapter, androidx.viewpager.widget.PagerAdapter
    @NotNull
    public GalleryFragment instantiateItem(@NotNull ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "container");
        Object instantiateItem = super.instantiateItem(viewGroup, i);
        Objects.requireNonNull(instantiateItem, "null cannot be cast to non-null type com.avito.android.photo_gallery.GalleryFragment");
        GalleryFragment galleryFragment = (GalleryFragment) instantiateItem;
        GalleryItem galleryItem = (GalleryItem) this.j.get(i);
        if ((galleryItem instanceof GalleryItem.GalleryImage) || (galleryItem instanceof GalleryItem.GalleryForegroundImage)) {
            galleryFragment.setListener(new GalleryFragment.Listener(this, viewGroup) { // from class: com.avito.android.photo_gallery.adapter.GalleryAdapter$instantiateItem$1
                public final /* synthetic */ GalleryAdapter a;
                public final /* synthetic */ ViewGroup b;

                {
                    this.a = r1;
                    this.b = r2;
                }

                @Override // com.avito.android.photo_gallery.GalleryFragment.Listener
                public void onImageClicked() {
                    this.b.performClick();
                }

                @Override // com.avito.android.photo_gallery.GalleryFragment.Listener
                public void onImageLoadFailed() {
                    GalleryAdapter.access$getImageLoadListener$p(this.a).onImageLoadFailed();
                }

                @Override // com.avito.android.photo_gallery.GalleryFragment.Listener
                public void onImageLoadSuccess() {
                    GalleryAdapter.access$getImageLoadListener$p(this.a).onImageLoadSuccess();
                }
            });
        } else if (galleryItem instanceof GalleryItem.GalleryVideo) {
            galleryFragment.setListener(new GalleryFragment.Listener(this, viewGroup, ((GalleryItem.GalleryVideo) galleryItem).getVideo().getVideoUrl()) { // from class: com.avito.android.photo_gallery.adapter.GalleryAdapter$instantiateItem$2
                public final /* synthetic */ GalleryAdapter a;
                public final /* synthetic */ ViewGroup b;
                public final /* synthetic */ Uri c;

                {
                    this.a = r1;
                    this.b = r2;
                    this.c = r3;
                }

                @Override // com.avito.android.photo_gallery.GalleryFragment.Listener
                public void onImageClicked() {
                    try {
                        this.b.performClick();
                        GalleryAdapter.access$getContext$p(this.a).startActivity(GalleryAdapter.access$getImplicitIntentFactory$p(this.a).uriIntent(this.c));
                    } catch (ActivityNotFoundException e) {
                        GalleryAdapter.access$getAnalytics$p(this.a).track(new NonFatalError("Error while try open video", e, null, 4, null));
                    }
                }

                @Override // com.avito.android.photo_gallery.GalleryFragment.Listener
                public void onImageLoadFailed() {
                    GalleryAdapter.access$getImageLoadListener$p(this.a).onImageLoadFailed();
                }

                @Override // com.avito.android.photo_gallery.GalleryFragment.Listener
                public void onImageLoadSuccess() {
                    GalleryAdapter.access$getImageLoadListener$p(this.a).onImageLoadSuccess();
                }
            });
        }
        return galleryFragment;
    }
}
