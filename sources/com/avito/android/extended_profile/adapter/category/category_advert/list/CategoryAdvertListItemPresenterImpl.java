package com.avito.android.extended_profile.adapter.category.category_advert.list;

import com.avito.android.extended_profile.adapter.action.ExtendedProfileItemAction;
import com.avito.android.extended_profile.adapter.category.category_advert.CategoryAdvertItem;
import com.avito.android.extended_profile.adapter.category.category_advert.CategoryAdvertItemAction;
import com.avito.android.image_loader.AvitoPictureKt;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.ForegroundImage;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.ImageKt;
import com.avito.android.serp.adapter.AdvertItem;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.kotlin.DisposableKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\u0010\u0010\u0011J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/avito/android/extended_profile/adapter/category/category_advert/list/CategoryAdvertListItemPresenterImpl;", "Lcom/avito/android/extended_profile/adapter/category/category_advert/list/CategoryAdvertListItemPresenter;", "Lcom/avito/android/extended_profile/adapter/category/category_advert/list/CategoryAdvertListItemView;", "view", "Lcom/avito/android/extended_profile/adapter/category/category_advert/CategoryAdvertItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/extended_profile/adapter/category/category_advert/list/CategoryAdvertListItemView;Lcom/avito/android/extended_profile/adapter/category/category_advert/CategoryAdvertItem;I)V", "Lio/reactivex/rxjava3/functions/Consumer;", "Lcom/avito/android/extended_profile/adapter/action/ExtendedProfileItemAction;", AuthSource.SEND_ABUSE, "Lio/reactivex/rxjava3/functions/Consumer;", "clicksConsumer", "<init>", "(Lio/reactivex/rxjava3/functions/Consumer;)V", "extended-profile_release"}, k = 1, mv = {1, 4, 2})
public final class CategoryAdvertListItemPresenterImpl implements CategoryAdvertListItemPresenter {
    public final Consumer<ExtendedProfileItemAction> a;

    public static final class a<T> implements Consumer<Unit> {
        public final /* synthetic */ CategoryAdvertListItemView a;
        public final /* synthetic */ CategoryAdvertListItemPresenterImpl b;
        public final /* synthetic */ CategoryAdvertItem c;
        public final /* synthetic */ CategoryAdvertListItemView d;

        public a(CategoryAdvertListItemView categoryAdvertListItemView, CategoryAdvertListItemPresenterImpl categoryAdvertListItemPresenterImpl, CategoryAdvertItem categoryAdvertItem, CategoryAdvertListItemView categoryAdvertListItemView2) {
            this.a = categoryAdvertListItemView;
            this.b = categoryAdvertListItemPresenterImpl;
            this.c = categoryAdvertItem;
            this.d = categoryAdvertListItemView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r3v3, resolved type: io.reactivex.rxjava3.functions.Consumer */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Unit unit) {
            this.b.a.accept(new CategoryAdvertItemAction.FavoriteClickAction(this.c));
        }
    }

    public static final class b extends Lambda implements Function1<Integer, Unit> {
        public final /* synthetic */ List a;
        public final /* synthetic */ CategoryAdvertListItemView b;
        public final /* synthetic */ CategoryAdvertListItemPresenterImpl c;
        public final /* synthetic */ CategoryAdvertItem d;
        public final /* synthetic */ CategoryAdvertListItemView e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(List list, CategoryAdvertListItemView categoryAdvertListItemView, CategoryAdvertListItemPresenterImpl categoryAdvertListItemPresenterImpl, CategoryAdvertItem categoryAdvertItem, CategoryAdvertListItemView categoryAdvertListItemView2) {
            super(1);
            this.a = list;
            this.b = categoryAdvertListItemView;
            this.c = categoryAdvertListItemPresenterImpl;
            this.d = categoryAdvertItem;
            this.e = categoryAdvertListItemView2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Integer num) {
            Integer num2 = num;
            this.c.a.accept(new CategoryAdvertItemAction.AdvertItemClickAction(this.d.getAdvert(), CategoryAdvertListItemPresenterImpl.access$createImage(this.c, this.e, this.a, num2), num2));
            return Unit.INSTANCE;
        }
    }

    public static final class c<T> implements Consumer<Integer> {
        public final /* synthetic */ CategoryAdvertListItemView a;
        public final /* synthetic */ CategoryAdvertItem b;
        public final /* synthetic */ CategoryAdvertListItemView c;

        public c(CategoryAdvertListItemView categoryAdvertListItemView, CategoryAdvertListItemPresenterImpl categoryAdvertListItemPresenterImpl, CategoryAdvertItem categoryAdvertItem, CategoryAdvertListItemView categoryAdvertListItemView2) {
            this.a = categoryAdvertListItemView;
            this.b = categoryAdvertItem;
            this.c = categoryAdvertListItemView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Integer num) {
            this.b.setAdvertGalleryState(this.a.getGalleryState());
        }
    }

    public static final class d extends Lambda implements Function0<Unit> {
        public final /* synthetic */ CompositeDisposable a;
        public final /* synthetic */ CategoryAdvertListItemView b;
        public final /* synthetic */ CategoryAdvertListItemView c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(CompositeDisposable compositeDisposable, CategoryAdvertListItemView categoryAdvertListItemView, CategoryAdvertListItemPresenterImpl categoryAdvertListItemPresenterImpl, CategoryAdvertItem categoryAdvertItem, CategoryAdvertListItemView categoryAdvertListItemView2) {
            super(0);
            this.a = compositeDisposable;
            this.b = categoryAdvertListItemView;
            this.c = categoryAdvertListItemView2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.b.setUnbindListener(null);
            this.a.clear();
            this.b.clearSubscriptions();
            this.b.clearPictures();
            return Unit.INSTANCE;
        }
    }

    @Inject
    public CategoryAdvertListItemPresenterImpl(@NotNull Consumer<ExtendedProfileItemAction> consumer) {
        Intrinsics.checkNotNullParameter(consumer, "clicksConsumer");
        this.a = consumer;
    }

    public static final Image access$createImage(CategoryAdvertListItemPresenterImpl categoryAdvertListItemPresenterImpl, CategoryAdvertListItemView categoryAdvertListItemView, List list, Integer num) {
        Objects.requireNonNull(categoryAdvertListItemPresenterImpl);
        boolean z = false;
        int intValue = num != null ? num.intValue() : 0;
        if (list == null || list.isEmpty()) {
            z = true;
        }
        if (z) {
            return null;
        }
        return ImageKt.toSingleImage(categoryAdvertListItemView.getPictureUri(AvitoPictureKt.pictureOf$default((Image) list.get(intValue), true, 0.0f, 0.0f, null, 28, null)));
    }

    public void bindView(@NotNull CategoryAdvertListItemView categoryAdvertListItemView, @NotNull CategoryAdvertItem categoryAdvertItem, int i) {
        Image image;
        Intrinsics.checkNotNullParameter(categoryAdvertListItemView, "view");
        Intrinsics.checkNotNullParameter(categoryAdvertItem, "item");
        AdvertItem advert = categoryAdvertItem.getAdvert();
        categoryAdvertListItemView.setTitle(categoryAdvertItem.getAdvert().getTitle());
        categoryAdvertListItemView.setDescription(categoryAdvertItem.getAdvert().getDescription());
        categoryAdvertListItemView.setPrice(advert.getPrice(), advert.isHighlighted());
        categoryAdvertListItemView.setDiscount(advert.getPreviousPrice());
        categoryAdvertListItemView.setPriceWithoutDiscount(advert.getPriceWithoutDiscount());
        List<Image> imageList = advert.getImageList();
        if (imageList == null && (image = advert.getImage()) != null) {
            imageList = t6.n.d.listOf(image);
        }
        boolean z = true;
        if ((imageList == null || !(!imageList.isEmpty())) && advert.getInfoImage() == null) {
            categoryAdvertListItemView.clearPictures();
        } else {
            ForegroundImage infoImage = advert.getInfoImage();
            ArrayList arrayList = new ArrayList();
            if (infoImage != null) {
                arrayList.add(AvitoPictureKt.pictureOf$default(false, 0.0f, 0.0f, infoImage, 6, null));
            }
            if (imageList != null) {
                Iterator<T> it = imageList.iterator();
                while (it.hasNext()) {
                    arrayList.add(AvitoPictureKt.pictureOf$default(it.next(), false, 0.0f, 0.0f, null, 28, null));
                }
            }
            categoryAdvertListItemView.setPictures(CollectionsKt___CollectionsKt.toList(arrayList));
            categoryAdvertListItemView.restoreGalleryState(categoryAdvertItem.getAdvertGalleryState());
        }
        categoryAdvertListItemView.setAddress(advert.getAddress());
        categoryAdvertListItemView.setLocation(advert.getLocation());
        categoryAdvertListItemView.setFavorite(advert.isFavorite());
        if (!advert.isActive() && !advert.isFavorite()) {
            z = false;
        }
        categoryAdvertListItemView.setFavoriteVisible(z);
        categoryAdvertListItemView.setViewed(advert.isViewed());
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        Disposable subscribe = categoryAdvertListItemView.getFavoriteClicks().subscribe(new a(categoryAdvertListItemView, this, categoryAdvertItem, categoryAdvertListItemView));
        Intrinsics.checkNotNullExpressionValue(subscribe, "favoriteClicks.subscribe…(item))\n                }");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
        ArrayList arrayList2 = new ArrayList();
        ForegroundImage infoImage2 = advert.getInfoImage();
        if (infoImage2 != null) {
            arrayList2.add(infoImage2.getImage());
        }
        if (imageList != null) {
            arrayList2.addAll(imageList);
        }
        categoryAdvertListItemView.clearSubscriptions();
        categoryAdvertListItemView.itemClicks(new b(arrayList2, categoryAdvertListItemView, this, categoryAdvertItem, categoryAdvertListItemView));
        Disposable subscribe2 = categoryAdvertListItemView.getGalleryPictureChanges().subscribe(new c(categoryAdvertListItemView, this, categoryAdvertItem, categoryAdvertListItemView));
        Intrinsics.checkNotNullExpressionValue(subscribe2, "galleryPictureChanges.su…ryState\n                }");
        DisposableKt.plusAssign(compositeDisposable, subscribe2);
        categoryAdvertListItemView.setUnbindListener(new d(compositeDisposable, categoryAdvertListItemView, this, categoryAdvertItem, categoryAdvertListItemView));
    }
}
