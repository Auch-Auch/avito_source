package com.avito.android.advert.item.carousel_photogallery;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.avito.android.advert_core.R;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.event.ExceptionEvent;
import com.avito.android.image_loader.AvitoPictureKt;
import com.avito.android.image_loader.Picture;
import com.avito.android.photo_gallery.common.GalleryActionListener;
import com.avito.android.photo_gallery.common.GalleryPageListener;
import com.avito.android.remote.model.ForegroundImage;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.Video;
import com.avito.android.util.Contexts;
import com.avito.android.util.ImplicitIntentFactory;
import com.avito.android.util.IntentsKt;
import com.avito.android.util.Logs;
import com.avito.android.util.ToastsKt;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.avito.konveyor.adapter.SimpleAdapterPresenter;
import com.jakewharton.rxrelay3.PublishRelay;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Predicate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.component.serp.cyclic_gallery.image_carousel.CarouselActions;
import ru.avito.component.serp.cyclic_gallery.image_carousel.ImageCarousel;
import ru.avito.component.serp.cyclic_gallery.image_carousel.ImageCarouselItemBlueprint;
import ru.avito.component.serp.cyclic_gallery.image_carousel.ImageCarouselItemPresenter;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B5\u0012\u0006\u00104\u001a\u000203\u0012\u0006\u00102\u001a\u00020/\u0012\u0006\u0010\u001c\u001a\u00020\u0019\u0012\b\b\u0002\u00106\u001a\u000205\u0012\n\b\u0002\u00107\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b8\u00109JW\u0010\u0013\u001a\u00020\u00122\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0018R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010 \u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u001e\u0010%\u001a\n \"*\u0004\u0018\u00010!0!8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u001c\u0010*\u001a\b\u0012\u0004\u0012\u00020'0&8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00102\u001a\u00020/8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b0\u00101¨\u0006:"}, d2 = {"Lcom/avito/android/advert/item/carousel_photogallery/CarouselPhotoGalleryViewImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/advert/item/carousel_photogallery/CarouselPhotoGalleryView;", "", "Lcom/avito/android/remote/model/Image;", "images", "Lcom/avito/android/remote/model/Video;", "video", "", "stateId", "Lcom/avito/android/photo_gallery/common/GalleryPageListener;", "galleryPageListener", "Lcom/avito/android/photo_gallery/common/GalleryActionListener;", "galleryActionListener", "", "currentPosition", "Lcom/avito/android/remote/model/ForegroundImage;", "infoImage", "", "bindGallery", "(Ljava/util/List;Lcom/avito/android/remote/model/Video;JLcom/avito/android/photo_gallery/common/GalleryPageListener;Lcom/avito/android/photo_gallery/common/GalleryActionListener;ILcom/avito/android/remote/model/ForegroundImage;)V", VKApiConst.POSITION, "setCurrentPosition", "(I)V", "()I", "Lcom/avito/android/analytics/Analytics;", "x", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lio/reactivex/rxjava3/disposables/Disposable;", VKApiConst.VERSION, "Lio/reactivex/rxjava3/disposables/Disposable;", "clickDisposable", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "s", "Landroid/content/Context;", "context", "Lcom/jakewharton/rxrelay3/PublishRelay;", "Lru/avito/component/serp/cyclic_gallery/image_carousel/CarouselActions;", "u", "Lcom/jakewharton/rxrelay3/PublishRelay;", "consumer", "Lru/avito/component/serp/cyclic_gallery/image_carousel/ImageCarousel;", "t", "Lru/avito/component/serp/cyclic_gallery/image_carousel/ImageCarousel;", "photoGallery", "Lcom/avito/android/util/ImplicitIntentFactory;", "w", "Lcom/avito/android/util/ImplicitIntentFactory;", "implicitIntentFactory", "Landroid/view/View;", "view", "", "isBigGallery", "videoPosition", "<init>", "(Landroid/view/View;Lcom/avito/android/util/ImplicitIntentFactory;Lcom/avito/android/analytics/Analytics;ZLjava/lang/Integer;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class CarouselPhotoGalleryViewImpl extends BaseViewHolder implements CarouselPhotoGalleryView {
    public final Context s;
    public final ImageCarousel t;
    public final PublishRelay<CarouselActions> u;
    public Disposable v;
    public final ImplicitIntentFactory w;
    public final Analytics x;

    public static final class a extends Lambda implements Function1<Integer, Unit> {
        public final /* synthetic */ GalleryPageListener a;
        public final /* synthetic */ long b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(GalleryPageListener galleryPageListener, long j) {
            super(1);
            this.a = galleryPageListener;
            this.b = j;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Integer num) {
            int intValue = num.intValue();
            GalleryPageListener galleryPageListener = this.a;
            if (galleryPageListener != null) {
                galleryPageListener.onPageSelected(intValue, this.b);
            }
            return Unit.INSTANCE;
        }
    }

    public static final class b<T> implements Predicate<CarouselActions> {
        public static final b a = new b();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Predicate
        public boolean test(CarouselActions carouselActions) {
            CarouselActions carouselActions2 = carouselActions;
            return (carouselActions2 instanceof CarouselActions.VideoClick) || (carouselActions2 instanceof CarouselActions.ImageClick);
        }
    }

    public static final class c<T> implements Consumer<CarouselActions> {
        public final /* synthetic */ CarouselPhotoGalleryViewImpl a;
        public final /* synthetic */ GalleryActionListener b;

        public c(CarouselPhotoGalleryViewImpl carouselPhotoGalleryViewImpl, GalleryActionListener galleryActionListener) {
            this.a = carouselPhotoGalleryViewImpl;
            this.b = galleryActionListener;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(CarouselActions carouselActions) {
            CarouselActions carouselActions2 = carouselActions;
            if (carouselActions2 instanceof CarouselActions.VideoClick) {
                CarouselActions.VideoClick videoClick = (CarouselActions.VideoClick) carouselActions2;
                this.b.onVideoGalleryClick(videoClick.getVideoPosition());
                Intent uriIntent = this.a.w.uriIntent(videoClick.getVideoLink());
                Context context = this.a.s;
                Intrinsics.checkNotNullExpressionValue(context, "context");
                try {
                    context.startActivity(IntentsKt.makeSafeForExternalApps(uriIntent));
                } catch (Exception e) {
                    this.a.x.track(new ExceptionEvent(e, null, 2, null));
                }
            } else {
                if (carouselActions2 instanceof CarouselActions.ImageClick) {
                    Context context2 = this.a.s;
                    Intrinsics.checkNotNullExpressionValue(context2, "context");
                    if (Contexts.isConnectionAvailable(context2)) {
                        this.b.onPhotoGalleryClick(((CarouselActions.ImageClick) carouselActions2).getImagePosition());
                        return;
                    }
                }
                Context context3 = this.a.s;
                Intrinsics.checkNotNullExpressionValue(context3, "context");
                ToastsKt.showToast$default(context3, R.string.network_unavailable_message, 0, 2, (Object) null);
            }
        }
    }

    public static final class d<T> implements Consumer<Throwable> {
        public static final d a = new d();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            Logs.error("CarouselPhotoGalleryViewImpl", "Click consumer error", th);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CarouselPhotoGalleryViewImpl(View view, ImplicitIntentFactory implicitIntentFactory, Analytics analytics, boolean z, Integer num, int i, j jVar) {
        this(view, implicitIntentFactory, analytics, (i & 8) != 0 ? false : z, (i & 16) != 0 ? null : num);
    }

    @Override // com.avito.android.advert.item.carousel_photogallery.CarouselPhotoGalleryView
    public void bindGallery(@Nullable List<Image> list, @Nullable Video video, long j, @Nullable GalleryPageListener galleryPageListener, @Nullable GalleryActionListener galleryActionListener, int i, @Nullable ForegroundImage foregroundImage) {
        List<? extends Picture> list2;
        List<Video> list3;
        ImageCarousel imageCarousel = this.t;
        if (list == null) {
            list2 = CollectionsKt__CollectionsKt.emptyList();
        } else {
            ArrayList arrayList = new ArrayList();
            if (foregroundImage != null) {
                arrayList.add(AvitoPictureKt.pictureOf$default(false, 0.0f, 0.0f, foregroundImage, 6, null));
            }
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(AvitoPictureKt.pictureOf$default(it.next(), false, 0.0f, 0.0f, null, 28, null));
            }
            list2 = CollectionsKt___CollectionsKt.toList(arrayList);
        }
        imageCarousel.setPictures(list2);
        ImageCarousel imageCarousel2 = this.t;
        if (video == null || (list3 = t6.n.d.listOf(video)) == null) {
            list3 = CollectionsKt__CollectionsKt.emptyList();
        }
        imageCarousel2.setVideos(list3);
        this.t.setPictureChangeListener(new a(galleryPageListener, j));
        Disposable disposable = this.v;
        if (disposable != null) {
            disposable.dispose();
        }
        this.v = null;
        if (galleryActionListener != null) {
            this.v = this.u.filter(b.a).subscribe(new c(this, galleryActionListener), d.a);
        }
        if (i >= 0) {
            setCurrentPosition(i);
        } else {
            setCurrentPosition(0);
        }
    }

    @Override // com.avito.android.advert.item.carousel_photogallery.CarouselPhotoGalleryView
    public int currentPosition() {
        return this.t.getCurrentPosition();
    }

    @Override // com.avito.android.advert.item.carousel_photogallery.CarouselPhotoGalleryView
    public void setCurrentPosition(int i) {
        this.t.setCurrentPicture(i, false);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CarouselPhotoGalleryViewImpl(@NotNull View view, @NotNull ImplicitIntentFactory implicitIntentFactory, @NotNull Analytics analytics, boolean z, @Nullable Integer num) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(implicitIntentFactory, "implicitIntentFactory");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        this.w = implicitIntentFactory;
        this.x = analytics;
        this.s = view.getContext();
        PublishRelay<CarouselActions> create = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create, "PublishRelay.create()");
        this.u = create;
        View findViewById = view.findViewById(com.avito.android.advert_details.R.id.photo_carousel);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.view.View");
        ItemBinder build = new ItemBinder.Builder().registerItem(new ImageCarouselItemBlueprint(new ImageCarouselItemPresenter(create, 1.3333334f))).build();
        this.t = new ImageCarousel(findViewById, new SimpleAdapterPresenter(build, build), build, null, z, null, num, 32, null);
    }
}
