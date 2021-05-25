package com.avito.android.section.item;

import com.avito.android.image_loader.AvitoPictureKt;
import com.avito.android.image_loader.Picture;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.ImageKt;
import com.avito.android.remote.model.badge_bar.SerpBadge;
import com.avito.android.remote.model.badge_bar.SerpBadgeBar;
import com.avito.android.serp.adapter.AdvertItem;
import com.avito.android.serp.adapter.AdvertItemListener;
import com.avito.android.serp.adapter.SerpViewType;
import com.avito.android.util.ListUtils;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import dagger.Lazy;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import ru.avito.component.serp.SerpAdvertListCard;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016\u0012\u0006\u0010\u0015\u001a\u00020\u0012¢\u0006\u0004\b\u001a\u0010\u001bJ'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ!\u0010\u0010\u001a\u00020\u000f2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00170\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0018¨\u0006\u001c"}, d2 = {"Lcom/avito/android/section/item/SectionAdvertItemPresenterImpl;", "Lcom/avito/android/section/item/SectionAdvertItemPresenter;", "Lcom/avito/android/section/item/SectionAdvertItemView;", "view", "Lcom/avito/android/serp/adapter/AdvertItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/section/item/SectionAdvertItemView;Lcom/avito/android/serp/adapter/AdvertItem;I)V", "Lcom/avito/android/remote/model/Image;", "image", "Lcom/avito/android/serp/adapter/SerpViewType;", "viewType", "Lcom/avito/android/image_loader/Picture;", AuthSource.SEND_ABUSE, "(Lcom/avito/android/remote/model/Image;Lcom/avito/android/serp/adapter/SerpViewType;)Lcom/avito/android/image_loader/Picture;", "Lcom/avito/android/section/item/SectionItemWidthProvider;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/section/item/SectionItemWidthProvider;", "widthProvider", "Ldagger/Lazy;", "Lcom/avito/android/serp/adapter/AdvertItemListener;", "Ldagger/Lazy;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "<init>", "(Ldagger/Lazy;Lcom/avito/android/section/item/SectionItemWidthProvider;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class SectionAdvertItemPresenterImpl implements SectionAdvertItemPresenter {
    public final Lazy<AdvertItemListener> a;
    public final SectionItemWidthProvider b;

    /* compiled from: kotlin-style lambda group */
    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ int a;
        public final /* synthetic */ int b;
        public final /* synthetic */ Object c;
        public final /* synthetic */ Object d;
        public final /* synthetic */ Object e;
        public final /* synthetic */ Object f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(int i, int i2, Object obj, Object obj2, Object obj3, Object obj4) {
            super(0);
            this.a = i;
            this.b = i2;
            this.c = obj;
            this.d = obj2;
            this.e = obj3;
            this.f = obj4;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            int i = this.a;
            if (i == 0) {
                ((AdvertItemListener) ((SectionAdvertItemPresenterImpl) this.d).a.get()).onFavoriteButtonClicked((AdvertItem) this.e);
                return Unit.INSTANCE;
            } else if (i == 1) {
                AdvertItem advertItem = (AdvertItem) this.e;
                ((AdvertItemListener) ((SectionAdvertItemPresenterImpl) this.d).a.get()).onAdvertClicked(advertItem, this.b, SectionAdvertItemPresenterImpl.access$createImage((SectionAdvertItemPresenterImpl) this.d, (SectionAdvertItemView) this.f, advertItem));
                return Unit.INSTANCE;
            } else {
                throw null;
            }
        }
    }

    public SectionAdvertItemPresenterImpl(@NotNull Lazy<AdvertItemListener> lazy, @NotNull SectionItemWidthProvider sectionItemWidthProvider) {
        Intrinsics.checkNotNullParameter(lazy, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        Intrinsics.checkNotNullParameter(sectionItemWidthProvider, "widthProvider");
        this.a = lazy;
        this.b = sectionItemWidthProvider;
    }

    public static final Image access$createImage(SectionAdvertItemPresenterImpl sectionAdvertItemPresenterImpl, SectionAdvertItemView sectionAdvertItemView, AdvertItem advertItem) {
        Objects.requireNonNull(sectionAdvertItemPresenterImpl);
        return ImageKt.toSingleImage(sectionAdvertItemView.getPictureUri(sectionAdvertItemPresenterImpl.a(advertItem.getImage(), advertItem.getViewType())));
    }

    public final Picture a(Image image, SerpViewType serpViewType) {
        return AvitoPictureKt.pictureOf$default(image, serpViewType == SerpViewType.BIG, 0.0f, 0.0f, null, 28, null);
    }

    public void bindView(@NotNull SectionAdvertItemView sectionAdvertItemView, @NotNull AdvertItem advertItem, int i) {
        Intrinsics.checkNotNullParameter(sectionAdvertItemView, "view");
        Intrinsics.checkNotNullParameter(advertItem, "item");
        sectionAdvertItemView.setTitle(advertItem.getTitle());
        sectionAdvertItemView.setPrice(advertItem.getPrice(), advertItem.isHighlighted());
        sectionAdvertItemView.setPriceWithoutDiscount(advertItem.getPriceWithoutDiscount());
        sectionAdvertItemView.setDeliveryVisible(advertItem.getHasDelivery());
        List<SerpBadge> list = null;
        SerpAdvertListCard.DefaultImpls.setPicture$default(sectionAdvertItemView, a(advertItem.getImage(), advertItem.getViewType()), null, 2, null);
        sectionAdvertItemView.setAddress(advertItem.getAddress());
        sectionAdvertItemView.setShopName(advertItem.getShopName());
        sectionAdvertItemView.setFavoriteVisible(true);
        sectionAdvertItemView.setFavorite(advertItem.isFavorite());
        sectionAdvertItemView.setViewed(advertItem.isViewed());
        SerpBadgeBar badgeBar = advertItem.getBadgeBar();
        sectionAdvertItemView.bindBadgeBar(badgeBar != null ? badgeBar.getBadges() : null, null);
        if (advertItem.getBadge() != null) {
            SerpBadgeBar badgeBar2 = advertItem.getBadgeBar();
            if (badgeBar2 != null) {
                list = badgeBar2.getBadges();
            }
            if (!ListUtils.isNotNullAndNotEmpty(list)) {
                sectionAdvertItemView.setBadge(advertItem.getBadge());
                sectionAdvertItemView.setLocationPostponed(advertItem.getLocation(), advertItem.getRadiusInfo());
                sectionAdvertItemView.setOnFavoriteButtonClickListener(new a(0, i, sectionAdvertItemView, this, advertItem, sectionAdvertItemView));
                sectionAdvertItemView.setClickListener(new a(1, i, sectionAdvertItemView, this, advertItem, sectionAdvertItemView));
                sectionAdvertItemView.setWidth(this.b.getWidthBySpanCount(advertItem.getSpanCount()));
            }
        }
        sectionAdvertItemView.hideBadge();
        sectionAdvertItemView.setLocationPostponed(advertItem.getLocation(), advertItem.getRadiusInfo());
        sectionAdvertItemView.setOnFavoriteButtonClickListener(new a(0, i, sectionAdvertItemView, this, advertItem, sectionAdvertItemView));
        sectionAdvertItemView.setClickListener(new a(1, i, sectionAdvertItemView, this, advertItem, sectionAdvertItemView));
        sectionAdvertItemView.setWidth(this.b.getWidthBySpanCount(advertItem.getSpanCount()));
    }
}
