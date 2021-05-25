package com.avito.android.extended_profile.adapter.category.category_advert.grid;

import com.avito.android.extended_profile.adapter.action.ExtendedProfileItemAction;
import com.avito.android.extended_profile.adapter.category.category_advert.CategoryAdvertItem;
import com.avito.android.extended_profile.adapter.category.category_advert.CategoryAdvertItemAction;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.ImageKt;
import com.avito.android.serp.adapter.AdvertItem;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.kotlin.DisposableKt;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012¢\u0006\u0004\b\u0016\u0010\u0017J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0014¨\u0006\u0018"}, d2 = {"Lcom/avito/android/extended_profile/adapter/category/category_advert/grid/CategoryAdvertGridItemPresenterImpl;", "Lcom/avito/android/extended_profile/adapter/category/category_advert/grid/CategoryAdvertGridItemPresenter;", "Lcom/avito/android/extended_profile/adapter/category/category_advert/grid/CategoryAdvertGridItemView;", "view", "Lcom/avito/android/extended_profile/adapter/category/category_advert/CategoryAdvertItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/extended_profile/adapter/category/category_advert/grid/CategoryAdvertGridItemView;Lcom/avito/android/extended_profile/adapter/category/category_advert/CategoryAdvertItem;I)V", "Lcom/avito/android/serp/adapter/AdvertItem;", "advertItem", "Lcom/avito/android/serp/adapter/SerpViewType;", "viewType", "Lcom/avito/android/image_loader/Picture;", AuthSource.SEND_ABUSE, "(Lcom/avito/android/serp/adapter/AdvertItem;Lcom/avito/android/serp/adapter/SerpViewType;)Lcom/avito/android/image_loader/Picture;", "Lio/reactivex/rxjava3/functions/Consumer;", "Lcom/avito/android/extended_profile/adapter/action/ExtendedProfileItemAction;", "Lio/reactivex/rxjava3/functions/Consumer;", "clicksConsumer", "<init>", "(Lio/reactivex/rxjava3/functions/Consumer;)V", "extended-profile_release"}, k = 1, mv = {1, 4, 2})
public final class CategoryAdvertGridItemPresenterImpl implements CategoryAdvertGridItemPresenter {
    public final Consumer<ExtendedProfileItemAction> a;

    public static final class a<T> implements Consumer<Unit> {
        public final /* synthetic */ CategoryAdvertGridItemView a;
        public final /* synthetic */ CategoryAdvertGridItemPresenterImpl b;
        public final /* synthetic */ CategoryAdvertItem c;
        public final /* synthetic */ CategoryAdvertGridItemView d;

        public a(CategoryAdvertGridItemView categoryAdvertGridItemView, CategoryAdvertGridItemPresenterImpl categoryAdvertGridItemPresenterImpl, CategoryAdvertItem categoryAdvertItem, CategoryAdvertGridItemView categoryAdvertGridItemView2) {
            this.a = categoryAdvertGridItemView;
            this.b = categoryAdvertGridItemPresenterImpl;
            this.c = categoryAdvertItem;
            this.d = categoryAdvertGridItemView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r3v3, resolved type: io.reactivex.rxjava3.functions.Consumer */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Unit unit) {
            this.b.a.accept(new CategoryAdvertItemAction.FavoriteClickAction(this.c));
        }
    }

    public static final class b<T> implements Consumer<Unit> {
        public final /* synthetic */ AdvertItem a;
        public final /* synthetic */ CategoryAdvertGridItemView b;
        public final /* synthetic */ CategoryAdvertGridItemPresenterImpl c;
        public final /* synthetic */ CategoryAdvertItem d;
        public final /* synthetic */ CategoryAdvertGridItemView e;

        public b(AdvertItem advertItem, CategoryAdvertGridItemView categoryAdvertGridItemView, CategoryAdvertGridItemPresenterImpl categoryAdvertGridItemPresenterImpl, CategoryAdvertItem categoryAdvertItem, CategoryAdvertGridItemView categoryAdvertGridItemView2) {
            this.a = advertItem;
            this.b = categoryAdvertGridItemView;
            this.c = categoryAdvertGridItemPresenterImpl;
            this.d = categoryAdvertItem;
            this.e = categoryAdvertGridItemView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r6v3, resolved type: io.reactivex.rxjava3.functions.Consumer */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Unit unit) {
            this.c.a.accept(new CategoryAdvertItemAction.AdvertItemClickAction(this.d.getAdvert(), CategoryAdvertGridItemPresenterImpl.access$createImage(this.c, this.e, this.a), 0));
        }
    }

    public static final class c extends Lambda implements Function0<Unit> {
        public final /* synthetic */ CompositeDisposable a;
        public final /* synthetic */ CategoryAdvertGridItemView b;
        public final /* synthetic */ CategoryAdvertGridItemView c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(CompositeDisposable compositeDisposable, CategoryAdvertGridItemView categoryAdvertGridItemView, CategoryAdvertGridItemPresenterImpl categoryAdvertGridItemPresenterImpl, CategoryAdvertItem categoryAdvertItem, CategoryAdvertGridItemView categoryAdvertGridItemView2) {
            super(0);
            this.a = compositeDisposable;
            this.b = categoryAdvertGridItemView;
            this.c = categoryAdvertGridItemView2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.b.setUnbindListener(null);
            this.a.clear();
            return Unit.INSTANCE;
        }
    }

    @Inject
    public CategoryAdvertGridItemPresenterImpl(@NotNull Consumer<ExtendedProfileItemAction> consumer) {
        Intrinsics.checkNotNullParameter(consumer, "clicksConsumer");
        this.a = consumer;
    }

    public static final Image access$createImage(CategoryAdvertGridItemPresenterImpl categoryAdvertGridItemPresenterImpl, CategoryAdvertGridItemView categoryAdvertGridItemView, AdvertItem advertItem) {
        Objects.requireNonNull(categoryAdvertGridItemPresenterImpl);
        return ImageKt.toSingleImage(categoryAdvertGridItemView.getPictureUri(categoryAdvertGridItemPresenterImpl.a(advertItem, advertItem.getViewType())));
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x003e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.avito.android.image_loader.Picture a(com.avito.android.serp.adapter.AdvertItem r11, com.avito.android.serp.adapter.SerpViewType r12) {
        /*
            r10 = this;
            com.avito.android.remote.model.ForegroundImage r3 = r11.getInfoImage()
            r0 = 1
            r1 = 0
            if (r3 == 0) goto L_0x0018
            r11 = 0
            r2 = 0
            com.avito.android.serp.adapter.SerpViewType r4 = com.avito.android.serp.adapter.SerpViewType.BIG
            if (r12 != r4) goto L_0x000f
            goto L_0x0010
        L_0x000f:
            r0 = 0
        L_0x0010:
            r4 = 6
            r5 = 0
            r1 = r11
            com.avito.android.image_loader.Picture r11 = com.avito.android.image_loader.AvitoPictureKt.pictureOf$default(r0, r1, r2, r3, r4, r5)
            return r11
        L_0x0018:
            com.avito.android.remote.model.Image r2 = r11.getImage()
            r3 = 0
            if (r2 == 0) goto L_0x0020
            goto L_0x0037
        L_0x0020:
            java.util.List r2 = r11.getImageList()
            boolean r2 = com.avito.android.util.ListUtils.isNotNullAndNotEmpty(r2)
            if (r2 == 0) goto L_0x0038
            java.util.List r11 = r11.getImageList()
            if (r11 == 0) goto L_0x0038
            java.lang.Object r11 = r11.get(r1)
            r2 = r11
            com.avito.android.remote.model.Image r2 = (com.avito.android.remote.model.Image) r2
        L_0x0037:
            r3 = r2
        L_0x0038:
            com.avito.android.serp.adapter.SerpViewType r11 = com.avito.android.serp.adapter.SerpViewType.BIG
            if (r12 != r11) goto L_0x003e
            r4 = 1
            goto L_0x003f
        L_0x003e:
            r4 = 0
        L_0x003f:
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 28
            r9 = 0
            com.avito.android.image_loader.Picture r11 = com.avito.android.image_loader.AvitoPictureKt.pictureOf$default(r3, r4, r5, r6, r7, r8, r9)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.extended_profile.adapter.category.category_advert.grid.CategoryAdvertGridItemPresenterImpl.a(com.avito.android.serp.adapter.AdvertItem, com.avito.android.serp.adapter.SerpViewType):com.avito.android.image_loader.Picture");
    }

    public void bindView(@NotNull CategoryAdvertGridItemView categoryAdvertGridItemView, @NotNull CategoryAdvertItem categoryAdvertItem, int i) {
        Intrinsics.checkNotNullParameter(categoryAdvertGridItemView, "view");
        Intrinsics.checkNotNullParameter(categoryAdvertItem, "item");
        AdvertItem advert = categoryAdvertItem.getAdvert();
        categoryAdvertGridItemView.setTitle(categoryAdvertItem.getAdvert().getTitle());
        categoryAdvertGridItemView.setDescription(categoryAdvertItem.getAdvert().getDescription());
        categoryAdvertGridItemView.setPrice(advert.getPrice(), advert.isHighlighted());
        categoryAdvertGridItemView.setDiscount(advert.getPreviousPrice());
        categoryAdvertGridItemView.setPriceWithoutDiscount(advert.getPriceWithoutDiscount());
        categoryAdvertGridItemView.setPicture(a(advert, advert.getViewType()), advert.getStringId());
        categoryAdvertGridItemView.setAddress(advert.getAddress());
        categoryAdvertGridItemView.setLocation(advert.getLocation());
        categoryAdvertGridItemView.setFavorite(advert.isFavorite());
        categoryAdvertGridItemView.setFavoriteVisible(advert.isActive() || advert.isFavorite());
        categoryAdvertGridItemView.setViewed(categoryAdvertItem.getAdvert().isViewed());
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        Disposable subscribe = categoryAdvertGridItemView.getFavoriteClicks().subscribe(new a(categoryAdvertGridItemView, this, categoryAdvertItem, categoryAdvertGridItemView));
        Intrinsics.checkNotNullExpressionValue(subscribe, "favoriteClicks.subscribe…(item))\n                }");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
        Disposable subscribe2 = categoryAdvertGridItemView.getItemClicks().subscribe(new b(advert, categoryAdvertGridItemView, this, categoryAdvertItem, categoryAdvertGridItemView));
        Intrinsics.checkNotNullExpressionValue(subscribe2, "itemClicks.subscribe {\n …      )\n                }");
        DisposableKt.plusAssign(compositeDisposable, subscribe2);
        categoryAdvertGridItemView.setUnbindListener(new c(compositeDisposable, categoryAdvertGridItemView, this, categoryAdvertItem, categoryAdvertGridItemView));
    }
}
