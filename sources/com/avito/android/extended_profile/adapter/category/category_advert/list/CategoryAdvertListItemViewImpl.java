package com.avito.android.extended_profile.adapter.category.category_advert.list;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.image_loader.Picture;
import com.avito.android.ui_components.R;
import com.avito.android.util.Logs;
import com.avito.android.util.TextViews;
import com.avito.android.util.Views;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.avito.konveyor.adapter.SimpleAdapterPresenter;
import com.facebook.appevents.integrity.IntegrityManager;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.material.internal.CheckableImageButton;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.jakewharton.rxbinding4.view.RxView;
import com.jakewharton.rxrelay3.PublishRelay;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Cancellable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Predicate;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.component.serp.GalleryBadgeDecoration;
import ru.avito.component.serp.HighlightDelegate;
import ru.avito.component.serp.PriceHighlightDelegate;
import ru.avito.component.serp.SerpAdvertTileCardKt;
import ru.avito.component.serp.cyclic_gallery.image_carousel.CarouselActions;
import ru.avito.component.serp.cyclic_gallery.image_carousel.GalleryRatio;
import ru.avito.component.serp.cyclic_gallery.image_carousel.ImageCarousel;
import ru.avito.component.serp.cyclic_gallery.image_carousel.ImageCarouselItemBlueprint;
import ru.avito.component.serp.cyclic_gallery.image_carousel.ImageCarouselItemPresenter;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¬\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B0\u0012\u0006\u0010d\u001a\u00020@\u0012\u0006\u0010U\u001a\u00020R\u0012\u0006\u0010;\u001a\u000208\u0012\r\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020}0|¢\u0006\u0006\b\u0001\u0010\u0001J%\u0010\u0007\u001a\u00020\u00052\u0014\u0010\u0006\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ!\u0010\u0010\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0013\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u0013\u0010\fJ\u0019\u0010\u0015\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u0015\u0010\fJ\u0019\u0010\u0017\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u0017\u0010\fJ\u0019\u0010\u0019\u001a\u00020\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u0019\u0010\fJ\u001d\u0010\u001d\u001a\u00020\u00052\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010\"\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\"\u0010#J\u0019\u0010%\u001a\u00020\u00052\b\u0010$\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b%\u0010\fJ\u0017\u0010'\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\u000eH\u0016¢\u0006\u0004\b'\u0010#J\u0017\u0010)\u001a\u00020\u00052\u0006\u0010(\u001a\u00020\u000eH\u0017¢\u0006\u0004\b)\u0010#J\u0019\u0010,\u001a\u00020\u00052\b\u0010+\u001a\u0004\u0018\u00010*H\u0016¢\u0006\u0004\b,\u0010-J\u001f\u00100\u001a\u00020\u00052\u000e\u0010/\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010.H\u0016¢\u0006\u0004\b0\u00101J\u000f\u00102\u001a\u00020\u0005H\u0016¢\u0006\u0004\b2\u0010 J\u0017\u00105\u001a\u0002042\u0006\u00103\u001a\u00020\u001bH\u0016¢\u0006\u0004\b5\u00106J\u000f\u00107\u001a\u00020\u0005H\u0016¢\u0006\u0004\b7\u0010 R\u0016\u0010;\u001a\u0002088\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010?\u001a\u00020<8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010C\u001a\u00020@8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bA\u0010BR\"\u0010I\u001a\b\u0012\u0004\u0012\u00020\u00050D8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bE\u0010F\u001a\u0004\bG\u0010HR\u0016\u0010M\u001a\u00020J8\u0002@\u0002X.¢\u0006\u0006\n\u0004\bK\u0010LR\u0016\u0010Q\u001a\u00020N8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bO\u0010PR\u0016\u0010U\u001a\u00020R8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bS\u0010TR\u001e\u0010X\u001a\n V*\u0004\u0018\u00010@0@8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bW\u0010BR\u0016\u0010\\\u001a\u00020Y8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bZ\u0010[R\u0018\u0010`\u001a\u0004\u0018\u00010]8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b^\u0010_R\u0016\u0010b\u001a\u00020Y8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\ba\u0010[R\u0016\u0010d\u001a\u00020@8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bc\u0010BR\u0016\u0010f\u001a\u00020Y8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\be\u0010[R\u0016\u0010j\u001a\u00020g8\u0002@\u0002X.¢\u0006\u0006\n\u0004\bh\u0010iR\u001e\u0010m\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010.8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bk\u0010lR\u0016\u0010o\u001a\u00020Y8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bn\u0010[R\u0016\u0010q\u001a\u00020Y8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bp\u0010[R\"\u0010t\u001a\b\u0012\u0004\u0012\u00020\u00040D8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\br\u0010F\u001a\u0004\bs\u0010HR\u0016\u0010v\u001a\u00020Y8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bu\u0010[R\u0018\u0010y\u001a\u0004\u0018\u00010*8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\bw\u0010xR\u0016\u0010{\u001a\u00020Y8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bz\u0010[R\u001d\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020}0|8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b~\u0010¨\u0006\u0001"}, d2 = {"Lcom/avito/android/extended_profile/adapter/category/category_advert/list/CategoryAdvertListItemViewImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/extended_profile/adapter/category/category_advert/list/CategoryAdvertListItemView;", "Lkotlin/Function1;", "", "", "callback", "itemClicks", "(Lkotlin/jvm/functions/Function1;)V", "", "title", "setTitle", "(Ljava/lang/CharSequence;)V", "price", "", "isHighlighted", "setPrice", "(Ljava/lang/CharSequence;Z)V", "value", "setDiscount", "priceWithoutDiscount", "setPriceWithoutDiscount", "location", "setLocation", IntegrityManager.INTEGRITY_TYPE_ADDRESS, "setAddress", "", "Lcom/avito/android/image_loader/Picture;", "pictures", "setPictures", "(Ljava/util/List;)V", "clearPictures", "()V", "visible", "setFavoriteVisible", "(Z)V", "description", "setDescription", "viewed", "setViewed", "favorite", "setFavorite", "Landroid/os/Parcelable;", "state", "restoreGalleryState", "(Landroid/os/Parcelable;)V", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setUnbindListener", "(Lkotlin/jvm/functions/Function0;)V", "onUnbind", "picture", "Landroid/net/Uri;", "getPictureUri", "(Lcom/avito/android/image_loader/Picture;)Landroid/net/Uri;", "clearSubscriptions", "Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "L", "Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "recycledViewPool", "Lru/avito/component/serp/HighlightDelegate;", "C", "Lru/avito/component/serp/HighlightDelegate;", "priceHighlighter", "Landroid/view/View;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Landroid/view/View;", "phoneLoader", "Lio/reactivex/rxjava3/core/Observable;", "H", "Lio/reactivex/rxjava3/core/Observable;", "getFavoriteClicks", "()Lio/reactivex/rxjava3/core/Observable;", "favoriteClicks", "Lru/avito/component/serp/cyclic_gallery/image_carousel/ImageCarousel;", "D", "Lru/avito/component/serp/cyclic_gallery/image_carousel/ImageCarousel;", "gallery", "Lcom/google/android/material/internal/CheckableImageButton;", "z", "Lcom/google/android/material/internal/CheckableImageButton;", "favoriteButton", "Lru/avito/component/serp/cyclic_gallery/image_carousel/GalleryRatio;", "K", "Lru/avito/component/serp/cyclic_gallery/image_carousel/GalleryRatio;", "galleryRatio", "kotlin.jvm.PlatformType", "B", "infoBadge", "Landroid/widget/TextView;", "t", "Landroid/widget/TextView;", "locationView", "Lio/reactivex/rxjava3/disposables/Disposable;", "G", "Lio/reactivex/rxjava3/disposables/Disposable;", "disposable", "s", "titleView", "J", "rootView", "w", FirebaseAnalytics.Param.DISCOUNT, "Lru/avito/component/serp/GalleryBadgeDecoration;", ExifInterface.LONGITUDE_EAST, "Lru/avito/component/serp/GalleryBadgeDecoration;", "infoBadgeDecoration", "F", "Lkotlin/jvm/functions/Function0;", "unbindListener", "y", "descriptionView", VKApiConst.VERSION, "priceWithoutDiscountView", "I", "getGalleryPictureChanges", "galleryPictureChanges", "x", "addressView", "getGalleryState", "()Landroid/os/Parcelable;", "galleryState", "u", "priceView", "Lcom/jakewharton/rxrelay3/PublishRelay;", "Lru/avito/component/serp/cyclic_gallery/image_carousel/CarouselActions;", "M", "Lcom/jakewharton/rxrelay3/PublishRelay;", "consumer", "<init>", "(Landroid/view/View;Lru/avito/component/serp/cyclic_gallery/image_carousel/GalleryRatio;Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;Lcom/jakewharton/rxrelay3/PublishRelay;)V", "extended-profile_release"}, k = 1, mv = {1, 4, 2})
public final class CategoryAdvertListItemViewImpl extends BaseViewHolder implements CategoryAdvertListItemView {
    public final View A;
    public final View B;
    public final HighlightDelegate C;
    public ImageCarousel D;
    public GalleryBadgeDecoration E;
    public Function0<Unit> F;
    public Disposable G;
    @NotNull
    public final Observable<Unit> H;
    @NotNull
    public final Observable<Integer> I;
    public final View J;
    public final GalleryRatio K;
    public final RecyclerView.RecycledViewPool L;
    public final PublishRelay<CarouselActions> M;
    public final TextView s;
    public final TextView t;
    public final TextView u;
    public final TextView v;
    public final TextView w;
    public final TextView x;
    public final TextView y;
    public final CheckableImageButton z;

    public static final class a<T> implements ObservableOnSubscribe<Integer> {
        public final /* synthetic */ CategoryAdvertListItemViewImpl a;

        /* renamed from: com.avito.android.extended_profile.adapter.category.category_advert.list.CategoryAdvertListItemViewImpl$a$a  reason: collision with other inner class name */
        public static final class C0138a extends Lambda implements Function1<Integer, Unit> {
            public final /* synthetic */ ObservableEmitter a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C0138a(ObservableEmitter observableEmitter) {
                super(1);
                this.a = observableEmitter;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: io.reactivex.rxjava3.core.ObservableEmitter */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function1
            public Unit invoke(Integer num) {
                this.a.onNext(Integer.valueOf(num.intValue()));
                return Unit.INSTANCE;
            }
        }

        public static final class b implements Cancellable {
            public final /* synthetic */ ImageCarousel a;

            public b(ImageCarousel imageCarousel) {
                this.a = imageCarousel;
            }

            @Override // io.reactivex.rxjava3.functions.Cancellable
            public final void cancel() {
                this.a.setPictureChangeListener(null);
            }
        }

        public a(CategoryAdvertListItemViewImpl categoryAdvertListItemViewImpl) {
            this.a = categoryAdvertListItemViewImpl;
        }

        @Override // io.reactivex.rxjava3.core.ObservableOnSubscribe
        public final void subscribe(ObservableEmitter<Integer> observableEmitter) {
            ImageCarousel access$getGallery$p = CategoryAdvertListItemViewImpl.access$getGallery$p(this.a);
            observableEmitter.setCancellable(new b(access$getGallery$p));
            access$getGallery$p.setPictureChangeListener(new C0138a(observableEmitter));
        }
    }

    public static final class b<T> implements Predicate<CarouselActions> {
        public static final b a = new b();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Predicate
        public boolean test(CarouselActions carouselActions) {
            return carouselActions instanceof CarouselActions.ImageClick;
        }
    }

    public static final class c<T, R> implements Function<CarouselActions.ImageClick, Integer> {
        public static final c a = new c();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public Integer apply(CarouselActions.ImageClick imageClick) {
            return Integer.valueOf(imageClick.getImagePosition());
        }
    }

    public static final class d<T, R> implements Function<Unit, Integer> {
        public static final d a = new d();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public Integer apply(Unit unit) {
            return -1;
        }
    }

    public static final class e<T> implements Consumer<Integer> {
        public final /* synthetic */ Function1 a;

        public e(Function1 function1) {
            this.a = function1;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Integer num) {
            Integer num2 = num;
            Function1 function1 = this.a;
            if (!(num2.intValue() >= 0)) {
                num2 = null;
            }
            function1.invoke(num2);
        }
    }

    public static final class f<T> implements Consumer<Throwable> {
        public static final f a = new f();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            Logs.error("CategoryAdvertListItemView", th);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CategoryAdvertListItemViewImpl(@NotNull View view, @NotNull GalleryRatio galleryRatio, @NotNull RecyclerView.RecycledViewPool recycledViewPool, @NotNull PublishRelay<CarouselActions> publishRelay) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "rootView");
        Intrinsics.checkNotNullParameter(galleryRatio, "galleryRatio");
        Intrinsics.checkNotNullParameter(recycledViewPool, "recycledViewPool");
        Intrinsics.checkNotNullParameter(publishRelay, "consumer");
        this.J = view;
        this.K = galleryRatio;
        this.L = recycledViewPool;
        this.M = publishRelay;
        View findViewById = view.findViewById(R.id.title);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
        this.s = (TextView) findViewById;
        View findViewById2 = view.findViewById(R.id.location);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
        this.t = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R.id.distance);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView = (TextView) findViewById3;
        View findViewById4 = view.findViewById(R.id.price);
        Objects.requireNonNull(findViewById4, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView2 = (TextView) findViewById4;
        this.u = textView2;
        View findViewById5 = view.findViewById(R.id.price_without_discount);
        Objects.requireNonNull(findViewById5, "null cannot be cast to non-null type android.widget.TextView");
        this.v = (TextView) findViewById5;
        View findViewById6 = view.findViewById(R.id.discount);
        Objects.requireNonNull(findViewById6, "null cannot be cast to non-null type android.widget.TextView");
        this.w = (TextView) findViewById6;
        View findViewById7 = view.findViewById(R.id.address);
        Objects.requireNonNull(findViewById7, "null cannot be cast to non-null type android.widget.TextView");
        this.x = (TextView) findViewById7;
        View findViewById8 = view.findViewById(R.id.additional_name);
        Objects.requireNonNull(findViewById8, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView3 = (TextView) findViewById8;
        this.y = textView3;
        View findViewById9 = view.findViewById(R.id.btn_favorite);
        Objects.requireNonNull(findViewById9, "null cannot be cast to non-null type com.google.android.material.internal.CheckableImageButton");
        CheckableImageButton checkableImageButton = (CheckableImageButton) findViewById9;
        this.z = checkableImageButton;
        View findViewById10 = view.findViewById(R.id.phone_loader);
        Objects.requireNonNull(findViewById10, "null cannot be cast to non-null type android.view.View");
        this.A = findViewById10;
        LayoutInflater from = LayoutInflater.from(view.getContext());
        int i = R.layout.rich_snippet_info_viewed_badge;
        Objects.requireNonNull(view, "null cannot be cast to non-null type android.view.ViewGroup");
        View inflate = from.inflate(i, (ViewGroup) view, false);
        this.B = inflate;
        this.C = new PriceHighlightDelegate(textView2, true, true);
        View findViewById11 = view.findViewById(R.id.gallery);
        Objects.requireNonNull(findViewById11, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        RecyclerView recyclerView = (RecyclerView) findViewById11;
        ImageCarouselItemBlueprint imageCarouselItemBlueprint = new ImageCarouselItemBlueprint(new ImageCarouselItemPresenter(publishRelay, galleryRatio.getImageWidthRatio()));
        ItemBinder.Builder builder = new ItemBinder.Builder();
        builder.registerItem(imageCarouselItemBlueprint);
        ItemBinder build = builder.build();
        SimpleAdapterPresenter simpleAdapterPresenter = new SimpleAdapterPresenter(build, build);
        Intrinsics.checkNotNullExpressionValue(inflate, "infoBadge");
        this.E = new GalleryBadgeDecoration(inflate, GalleryBadgeDecoration.DecorationGravity.TOP, 0, false);
        this.D = new ImageCarousel(recyclerView, simpleAdapterPresenter, build, recycledViewPool, false, null, null, 112, null);
        Resources resources = view.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "rootView.resources");
        int galleryHeightRatio = (int) (galleryRatio.getGalleryHeightRatio() * ((float) ((resources.getDisplayMetrics().widthPixels - recyclerView.getPaddingLeft()) - recyclerView.getPaddingRight())));
        ImageCarousel imageCarousel = this.D;
        if (imageCarousel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gallery");
        }
        imageCarousel.setHeight(galleryHeightRatio);
        textView3.setMaxLines(2);
        textView3.setEllipsize(TextUtils.TruncateAt.END);
        Views.hide(findViewById10);
        this.H = RxView.clicks(checkableImageButton);
        Observable<Integer> create = Observable.create(new a(this));
        Intrinsics.checkNotNullExpressionValue(create, "Observable.create { emit…}\n            }\n        }");
        this.I = create;
    }

    public static final /* synthetic */ ImageCarousel access$getGallery$p(CategoryAdvertListItemViewImpl categoryAdvertListItemViewImpl) {
        ImageCarousel imageCarousel = categoryAdvertListItemViewImpl.D;
        if (imageCarousel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gallery");
        }
        return imageCarousel;
    }

    @Override // com.avito.android.extended_profile.adapter.category.category_advert.list.CategoryAdvertListItemView
    public void clearPictures() {
        ImageCarousel imageCarousel = this.D;
        if (imageCarousel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gallery");
        }
        imageCarousel.setPictures(CollectionsKt__CollectionsKt.emptyList());
    }

    @Override // com.avito.android.extended_profile.adapter.category.category_advert.list.CategoryAdvertListItemView
    public void clearSubscriptions() {
        Disposable disposable = this.G;
        if (disposable != null) {
            disposable.dispose();
        }
        this.G = null;
    }

    @Override // com.avito.android.extended_profile.adapter.category.category_advert.list.CategoryAdvertListItemView
    @NotNull
    public Observable<Unit> getFavoriteClicks() {
        return this.H;
    }

    @Override // com.avito.android.extended_profile.adapter.category.category_advert.list.CategoryAdvertListItemView
    @NotNull
    public Observable<Integer> getGalleryPictureChanges() {
        return this.I;
    }

    @Override // com.avito.android.extended_profile.adapter.category.category_advert.list.CategoryAdvertListItemView
    @Nullable
    public Parcelable getGalleryState() {
        ImageCarousel imageCarousel = this.D;
        if (imageCarousel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gallery");
        }
        return imageCarousel.getState();
    }

    @Override // com.avito.android.extended_profile.adapter.category.category_advert.list.CategoryAdvertListItemView
    @NotNull
    public Uri getPictureUri(@NotNull Picture picture) {
        Intrinsics.checkNotNullParameter(picture, "picture");
        View findViewById = this.J.findViewById(R.id.gallery);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.view.View");
        return picture.getUri(findViewById);
    }

    @Override // com.avito.android.extended_profile.adapter.category.category_advert.list.CategoryAdvertListItemView
    public void itemClicks(@NotNull Function1<? super Integer, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "callback");
        Observable<CarouselActions> filter = this.M.filter(b.a);
        Intrinsics.checkNotNullExpressionValue(filter, "consumer.filter { it is …ouselActions.ImageClick }");
        Observable<U> cast = filter.cast(CarouselActions.ImageClick.class);
        Intrinsics.checkExpressionValueIsNotNull(cast, "cast(R::class.java)");
        this.G = cast.map(c.a).mergeWith(RxView.clicks(this.J).map(d.a)).subscribe(new e(function1), f.a);
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        Function0<Unit> function0 = this.F;
        if (function0 != null) {
            function0.invoke();
        }
    }

    @Override // com.avito.android.extended_profile.adapter.category.category_advert.list.CategoryAdvertListItemView
    public void restoreGalleryState(@Nullable Parcelable parcelable) {
        if (parcelable != null) {
            ImageCarousel imageCarousel = this.D;
            if (imageCarousel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("gallery");
            }
            imageCarousel.restoreState(parcelable);
            return;
        }
        ImageCarousel imageCarousel2 = this.D;
        if (imageCarousel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gallery");
        }
        imageCarousel2.resetState();
    }

    @Override // com.avito.android.extended_profile.adapter.category.category_advert.list.CategoryAdvertListItemView
    public void setAddress(@Nullable CharSequence charSequence) {
        TextViews.bindText$default(this.x, charSequence, false, 2, null);
    }

    @Override // com.avito.android.extended_profile.adapter.category.category_advert.list.CategoryAdvertListItemView
    public void setDescription(@Nullable CharSequence charSequence) {
        TextViews.bindText$default(this.y, charSequence, false, 2, null);
    }

    @Override // com.avito.android.extended_profile.adapter.category.category_advert.list.CategoryAdvertListItemView
    public void setDiscount(@Nullable CharSequence charSequence) {
        SerpAdvertTileCardKt.applyClassifiedDiscountToViews$default(this.w, this.u, charSequence != null ? charSequence.toString() : null, true, false, 16, null);
    }

    @Override // com.avito.android.extended_profile.adapter.category.category_advert.list.CategoryAdvertListItemView
    @SuppressLint({"RestrictedApi"})
    public void setFavorite(boolean z2) {
        this.z.setChecked(z2);
    }

    @Override // com.avito.android.extended_profile.adapter.category.category_advert.list.CategoryAdvertListItemView
    public void setFavoriteVisible(boolean z2) {
        Views.setVisible(this.z, z2);
    }

    @Override // com.avito.android.extended_profile.adapter.category.category_advert.list.CategoryAdvertListItemView
    public void setLocation(@Nullable CharSequence charSequence) {
        TextViews.bindText$default(this.t, charSequence, false, 2, null);
    }

    @Override // com.avito.android.extended_profile.adapter.category.category_advert.list.CategoryAdvertListItemView
    public void setPictures(@NotNull List<? extends Picture> list) {
        Intrinsics.checkNotNullParameter(list, "pictures");
        ImageCarousel imageCarousel = this.D;
        if (imageCarousel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gallery");
        }
        imageCarousel.setPictures(list);
    }

    @Override // com.avito.android.extended_profile.adapter.category.category_advert.list.CategoryAdvertListItemView
    public void setPrice(@Nullable CharSequence charSequence, boolean z2) {
        this.C.setText(charSequence != null ? charSequence.toString() : null, z2);
    }

    @Override // com.avito.android.extended_profile.adapter.category.category_advert.list.CategoryAdvertListItemView
    public void setPriceWithoutDiscount(@Nullable CharSequence charSequence) {
        TextViews.bindText$default(this.v, charSequence, false, 2, null);
    }

    @Override // com.avito.android.extended_profile.adapter.category.category_advert.list.CategoryAdvertListItemView
    public void setTitle(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "title");
        TextViews.bindText$default(this.s, charSequence, false, 2, null);
    }

    @Override // com.avito.android.extended_profile.adapter.category.category_advert.list.CategoryAdvertListItemView
    public void setUnbindListener(@Nullable Function0<Unit> function0) {
        this.F = function0;
    }

    @Override // com.avito.android.extended_profile.adapter.category.category_advert.list.CategoryAdvertListItemView
    public void setViewed(boolean z2) {
        ImageCarousel imageCarousel = this.D;
        if (imageCarousel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gallery");
        }
        GalleryBadgeDecoration galleryBadgeDecoration = this.E;
        if (galleryBadgeDecoration == null) {
            Intrinsics.throwUninitializedPropertyAccessException("infoBadgeDecoration");
        }
        imageCarousel.removeItemDecoration(galleryBadgeDecoration);
        if (z2) {
            ImageCarousel imageCarousel2 = this.D;
            if (imageCarousel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("gallery");
            }
            GalleryBadgeDecoration galleryBadgeDecoration2 = this.E;
            if (galleryBadgeDecoration2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("infoBadgeDecoration");
            }
            imageCarousel2.addItemDecoration(galleryBadgeDecoration2);
        }
    }
}
