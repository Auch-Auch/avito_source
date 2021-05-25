package com.avito.android.photo_gallery.adapter;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.net.Uri;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.event.ExceptionEvent;
import com.avito.android.analytics.screens.GalleryScreen;
import com.avito.android.autoteka_details.core.analytics.event.FromBlock;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.photo_gallery.GalleryFragment;
import com.avito.android.photo_gallery.GalleryFragmentKt;
import com.avito.android.photo_gallery.GalleryFragmentType;
import com.avito.android.photo_gallery.adapter.GalleryItem;
import com.avito.android.photo_gallery.autoteka_teaser.AutotekaListener;
import com.avito.android.photo_gallery.common.ImageLoadListener;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.ForegroundImage;
import com.avito.android.remote.model.Image;
import com.avito.android.util.ImplicitIntentFactory;
import com.vk.sdk.api.VKApiConst;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0001\b\u0007\u0012\u0006\u0010\u001f\u001a\u00020\u001c\u0012\u0006\u00107\u001a\u000206\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0018\u0012\u0006\u0010-\u001a\u00020*\u0012\u0006\u0010'\u001a\u00020$\u0012\u0006\u00105\u001a\u000202\u0012\u000e\b\u0002\u0010#\u001a\b\u0012\u0004\u0012\u00020\u000e0 \u0012\u000e\b\u0002\u0010/\u001a\b\u0012\u0004\u0012\u00020\u000e0 \u0012\u0010\b\u0002\u00101\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010 \u0012\u0016\b\u0002\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0013¢\u0006\u0004\b8\u00109J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nJ\u001b\u0010\u000f\u001a\u00020\u000e2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0011\u0010\u0012R$\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u001c\u0010#\u001a\b\u0012\u0004\u0012\u00020\u000e0 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u001c\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u001c\u0010/\u001a\b\u0012\u0004\u0012\u00020\u000e0 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b.\u0010\"R\u001e\u00101\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b0\u0010\"R\u0016\u00105\u001a\u0002028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b3\u00104¨\u0006:"}, d2 = {"Lcom/avito/android/photo_gallery/adapter/FullscreenGalleryAdapter;", "Landroidx/fragment/app/FragmentStatePagerAdapter;", "Landroid/view/ViewGroup;", "container", "", VKApiConst.POSITION, "Landroidx/fragment/app/Fragment;", "instantiateItem", "(Landroid/view/ViewGroup;I)Landroidx/fragment/app/Fragment;", "getItem", "(I)Landroidx/fragment/app/Fragment;", "", "Lcom/avito/android/photo_gallery/adapter/GalleryItem;", "items", "", "updateList", "(Ljava/util/List;)V", "getCount", "()I", "Lkotlin/Function1;", "Lcom/avito/android/autoteka_details/core/analytics/event/FromBlock;", "s", "Lkotlin/jvm/functions/Function1;", "teaserButtonClickListener", "", "l", "Ljava/lang/String;", BookingInfoActivity.EXTRA_ITEM_ID, "Landroid/content/Context;", "j", "Landroid/content/Context;", "context", "Lkotlin/Function0;", "p", "Lkotlin/jvm/functions/Function0;", "imageClickListener", "Lcom/avito/android/util/ImplicitIntentFactory;", "n", "Lcom/avito/android/util/ImplicitIntentFactory;", "implicitIntentFactory", "k", "Ljava/util/List;", "Lcom/avito/android/photo_gallery/common/ImageLoadListener;", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/android/photo_gallery/common/ImageLoadListener;", "imageLoadListener", VKApiConst.Q, "videoClickListener", "r", "teaserEmptyClickListener", "Lcom/avito/android/analytics/Analytics;", "o", "Lcom/avito/android/analytics/Analytics;", "analytics", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "<init>", "(Landroid/content/Context;Landroidx/fragment/app/FragmentManager;Ljava/util/List;Ljava/lang/String;Lcom/avito/android/photo_gallery/common/ImageLoadListener;Lcom/avito/android/util/ImplicitIntentFactory;Lcom/avito/android/analytics/Analytics;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", "photo-gallery_release"}, k = 1, mv = {1, 4, 2})
public final class FullscreenGalleryAdapter extends FragmentStatePagerAdapter {
    public final Context j;
    public List<? extends GalleryItem> k;
    public final String l;
    public final ImageLoadListener m;
    public final ImplicitIntentFactory n;
    public final Analytics o;
    public final Function0<Unit> p;
    public final Function0<Unit> q;
    public final Function0<Unit> r;
    public final Function1<FromBlock, Unit> s;

    /* compiled from: kotlin-style lambda group */
    public static final class a extends Lambda implements Function0<Unit> {
        public static final a b = new a(0);
        public static final a c = new a(1);
        public final /* synthetic */ int a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(int i) {
            super(0);
            this.a = i;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            int i = this.a;
            if (i == 0) {
                return Unit.INSTANCE;
            }
            if (i == 1) {
                return Unit.INSTANCE;
            }
            throw null;
        }
    }

    @JvmOverloads
    public FullscreenGalleryAdapter(@NotNull Context context, @NotNull FragmentManager fragmentManager, @NotNull List<? extends GalleryItem> list, @NotNull ImageLoadListener imageLoadListener, @NotNull ImplicitIntentFactory implicitIntentFactory, @NotNull Analytics analytics) {
        this(context, fragmentManager, list, null, imageLoadListener, implicitIntentFactory, analytics, null, null, null, null, 1928, null);
    }

    @JvmOverloads
    public FullscreenGalleryAdapter(@NotNull Context context, @NotNull FragmentManager fragmentManager, @NotNull List<? extends GalleryItem> list, @Nullable String str, @NotNull ImageLoadListener imageLoadListener, @NotNull ImplicitIntentFactory implicitIntentFactory, @NotNull Analytics analytics) {
        this(context, fragmentManager, list, str, imageLoadListener, implicitIntentFactory, analytics, null, null, null, null, 1920, null);
    }

    @JvmOverloads
    public FullscreenGalleryAdapter(@NotNull Context context, @NotNull FragmentManager fragmentManager, @NotNull List<? extends GalleryItem> list, @Nullable String str, @NotNull ImageLoadListener imageLoadListener, @NotNull ImplicitIntentFactory implicitIntentFactory, @NotNull Analytics analytics, @NotNull Function0<Unit> function0) {
        this(context, fragmentManager, list, str, imageLoadListener, implicitIntentFactory, analytics, function0, null, null, null, 1792, null);
    }

    @JvmOverloads
    public FullscreenGalleryAdapter(@NotNull Context context, @NotNull FragmentManager fragmentManager, @NotNull List<? extends GalleryItem> list, @Nullable String str, @NotNull ImageLoadListener imageLoadListener, @NotNull ImplicitIntentFactory implicitIntentFactory, @NotNull Analytics analytics, @NotNull Function0<Unit> function0, @NotNull Function0<Unit> function02) {
        this(context, fragmentManager, list, str, imageLoadListener, implicitIntentFactory, analytics, function0, function02, null, null, 1536, null);
    }

    @JvmOverloads
    public FullscreenGalleryAdapter(@NotNull Context context, @NotNull FragmentManager fragmentManager, @NotNull List<? extends GalleryItem> list, @Nullable String str, @NotNull ImageLoadListener imageLoadListener, @NotNull ImplicitIntentFactory implicitIntentFactory, @NotNull Analytics analytics, @NotNull Function0<Unit> function0, @NotNull Function0<Unit> function02, @Nullable Function0<Unit> function03) {
        this(context, fragmentManager, list, str, imageLoadListener, implicitIntentFactory, analytics, function0, function02, function03, null, 1024, null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FullscreenGalleryAdapter(Context context, FragmentManager fragmentManager, List list, String str, ImageLoadListener imageLoadListener, ImplicitIntentFactory implicitIntentFactory, Analytics analytics, Function0 function0, Function0 function02, Function0 function03, Function1 function1, int i, j jVar) {
        this(context, fragmentManager, list, (i & 8) != 0 ? null : str, imageLoadListener, implicitIntentFactory, analytics, (i & 128) != 0 ? a.b : function0, (i & 256) != 0 ? a.c : function02, (i & 512) != 0 ? null : function03, (i & 1024) != 0 ? null : function1);
    }

    public static GalleryFragment a(FullscreenGalleryAdapter fullscreenGalleryAdapter, Image image, GalleryFragmentType galleryFragmentType, ForegroundImage foregroundImage, GalleryItem.GalleryTeaserAutoteka galleryTeaserAutoteka, int i) {
        ForegroundImage foregroundImage2 = (i & 4) != 0 ? null : foregroundImage;
        GalleryItem.GalleryTeaserAutoteka galleryTeaserAutoteka2 = (i & 8) != 0 ? null : galleryTeaserAutoteka;
        GalleryScreen galleryScreen = GalleryScreen.INSTANCE;
        String str = fullscreenGalleryAdapter.l;
        if (str == null) {
            str = "";
        }
        return GalleryFragmentKt.newGalleryFragmentInstance$default(image, false, galleryFragmentType, false, true, galleryScreen, str, foregroundImage2, null, galleryTeaserAutoteka2, 264, null);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.k.size();
    }

    @Override // androidx.fragment.app.FragmentStatePagerAdapter
    @NotNull
    public Fragment getItem(int i) {
        GalleryItem galleryItem = (GalleryItem) this.k.get(i);
        if (galleryItem instanceof GalleryItem.GalleryImage) {
            return a(this, ((GalleryItem.GalleryImage) galleryItem).getImage(), GalleryFragmentType.IMAGE, null, null, 12);
        }
        if (galleryItem instanceof GalleryItem.GalleryVideo) {
            return a(this, ((GalleryItem.GalleryVideo) galleryItem).getVideo().getPreviewImage(), GalleryFragmentType.VIDEO, null, null, 12);
        }
        if (galleryItem instanceof GalleryItem.GalleryTeaserAutoteka) {
            return a(this, null, GalleryFragmentType.AUTOTEKA_TEASER, null, (GalleryItem.GalleryTeaserAutoteka) galleryItem, 4);
        } else if (galleryItem instanceof GalleryItem.GalleryForegroundImage) {
            return a(this, null, GalleryFragmentType.IMAGE, ((GalleryItem.GalleryForegroundImage) galleryItem).getForegroundImage(), null, 8);
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    public final void updateList(@NotNull List<? extends GalleryItem> list) {
        Intrinsics.checkNotNullParameter(list, "items");
        this.k = list;
        notifyDataSetChanged();
    }

    @Override // androidx.fragment.app.FragmentStatePagerAdapter, androidx.viewpager.widget.PagerAdapter
    @NotNull
    public Fragment instantiateItem(@NotNull ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "container");
        Object instantiateItem = super.instantiateItem(viewGroup, i);
        Objects.requireNonNull(instantiateItem, "null cannot be cast to non-null type androidx.fragment.app.Fragment");
        Fragment fragment = (Fragment) instantiateItem;
        if (fragment instanceof GalleryFragment) {
            GalleryItem galleryItem = (GalleryItem) this.k.get(i);
            if (galleryItem instanceof GalleryItem.GalleryImage) {
                ((GalleryFragment) fragment).setListener(new GalleryFragment.Listener(this) { // from class: com.avito.android.photo_gallery.adapter.FullscreenGalleryAdapter$instantiateItem$1
                    public final /* synthetic */ FullscreenGalleryAdapter a;

                    /* JADX WARN: Incorrect args count in method signature: ()V */
                    {
                        this.a = r1;
                    }

                    @Override // com.avito.android.photo_gallery.GalleryFragment.Listener
                    public void onImageClicked() {
                        this.a.p.invoke();
                    }

                    @Override // com.avito.android.photo_gallery.GalleryFragment.Listener
                    public void onImageLoadFailed() {
                        this.a.m.onImageLoadFailed();
                    }

                    @Override // com.avito.android.photo_gallery.GalleryFragment.Listener
                    public void onImageLoadSuccess() {
                        this.a.m.onImageLoadSuccess();
                    }
                });
            } else if (galleryItem instanceof GalleryItem.GalleryVideo) {
                ((GalleryFragment) fragment).setListener(new GalleryFragment.Listener(this, ((GalleryItem.GalleryVideo) galleryItem).getVideo().getVideoUrl()) { // from class: com.avito.android.photo_gallery.adapter.FullscreenGalleryAdapter$instantiateItem$2
                    public final /* synthetic */ FullscreenGalleryAdapter a;
                    public final /* synthetic */ Uri b;

                    {
                        this.a = r1;
                        this.b = r2;
                    }

                    @Override // com.avito.android.photo_gallery.GalleryFragment.Listener
                    public void onImageClicked() {
                        try {
                            this.a.q.invoke();
                            this.a.j.startActivity(this.a.n.uriIntent(this.b));
                        } catch (ActivityNotFoundException e) {
                            this.a.o.track(new ExceptionEvent(e, null, 2, null));
                        }
                    }

                    @Override // com.avito.android.photo_gallery.GalleryFragment.Listener
                    public void onImageLoadFailed() {
                        this.a.m.onImageLoadFailed();
                    }

                    @Override // com.avito.android.photo_gallery.GalleryFragment.Listener
                    public void onImageLoadSuccess() {
                        this.a.m.onImageLoadSuccess();
                    }
                });
            } else if (galleryItem instanceof GalleryItem.GalleryTeaserAutoteka) {
                ((GalleryFragment) fragment).setAutotekaListener(new AutotekaListener(this) { // from class: com.avito.android.photo_gallery.adapter.FullscreenGalleryAdapter$instantiateItem$3
                    public final /* synthetic */ FullscreenGalleryAdapter a;

                    /* JADX WARN: Incorrect args count in method signature: ()V */
                    {
                        this.a = r1;
                    }

                    @Override // com.avito.android.photo_gallery.autoteka_teaser.AutotekaListener
                    public void onButtonClick(@NotNull FromBlock fromBlock) {
                        Intrinsics.checkNotNullParameter(fromBlock, BookingInfoActivity.EXTRA_FROM_BLOCK);
                        Function1 function1 = this.a.s;
                        if (function1 != null) {
                            Unit unit = (Unit) function1.invoke(fromBlock);
                        }
                    }

                    @Override // com.avito.android.photo_gallery.autoteka_teaser.AutotekaListener
                    public void onEmptyClick() {
                        Function0 function0 = this.a.r;
                        if (function0 != null) {
                            Unit unit = (Unit) function0.invoke();
                        }
                    }
                });
            }
        }
        return fragment;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r12v0, resolved type: kotlin.jvm.functions.Function1<? super com.avito.android.autoteka_details.core.analytics.event.FromBlock, kotlin.Unit> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public FullscreenGalleryAdapter(@NotNull Context context, @NotNull FragmentManager fragmentManager, @NotNull List<? extends GalleryItem> list, @Nullable String str, @NotNull ImageLoadListener imageLoadListener, @NotNull ImplicitIntentFactory implicitIntentFactory, @NotNull Analytics analytics, @NotNull Function0<Unit> function0, @NotNull Function0<Unit> function02, @Nullable Function0<Unit> function03, @Nullable Function1<? super FromBlock, Unit> function1) {
        super(fragmentManager);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
        Intrinsics.checkNotNullParameter(list, "items");
        Intrinsics.checkNotNullParameter(imageLoadListener, "imageLoadListener");
        Intrinsics.checkNotNullParameter(implicitIntentFactory, "implicitIntentFactory");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(function0, "imageClickListener");
        Intrinsics.checkNotNullParameter(function02, "videoClickListener");
        this.j = context;
        this.k = list;
        this.l = str;
        this.m = imageLoadListener;
        this.n = implicitIntentFactory;
        this.o = analytics;
        this.p = function0;
        this.q = function02;
        this.r = function03;
        this.s = function1;
    }
}
