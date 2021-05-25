package com.avito.android.favorite_sellers;

import a2.b.a.a.a;
import com.avito.android.favorite_sellers.SellerCarouselItem;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.recommended_sellers.AdvertImageWithOverlay;
import com.avito.android.remote.model.recommended_sellers.RecommendedSeller;
import com.avito.android.remote.model.recommended_sellers.RecommendedSellerElement;
import com.facebook.share.internal.MessengerShareContentUtility;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\n\u0010\u000bJ+\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/avito/android/favorite_sellers/SellerCarouselItemConverterImpl;", "Lcom/avito/android/favorite_sellers/SellerCarouselItemConverter;", "", "Lcom/avito/android/remote/model/recommended_sellers/RecommendedSellerElement;", MessengerShareContentUtility.ELEMENTS, "", "recommendationId", "Lcom/avito/android/favorite_sellers/RecommendationCarouselItem;", "convert", "(Ljava/util/List;Ljava/lang/String;)Ljava/util/List;", "<init>", "()V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class SellerCarouselItemConverterImpl implements SellerCarouselItemConverter {
    @Override // com.avito.android.favorite_sellers.SellerCarouselItemConverter
    @NotNull
    public List<RecommendationCarouselItem> convert(@NotNull List<? extends RecommendedSellerElement> list, @NotNull String str) {
        Iterator<T> it;
        ArrayList arrayList;
        ArrayList arrayList2;
        Iterator<T> it2;
        String str2;
        Intrinsics.checkNotNullParameter(list, MessengerShareContentUtility.ELEMENTS);
        Intrinsics.checkNotNullParameter(str, "recommendationId");
        ArrayList arrayList3 = new ArrayList();
        int i = 10;
        ArrayList arrayList4 = new ArrayList(e.collectionSizeOrDefault(list, 10));
        Iterator<T> it3 = list.iterator();
        while (it3.hasNext()) {
            T next = it3.next();
            if (next instanceof RecommendedSeller) {
                StringBuilder L = a.L("seller_carousel_item:");
                T t = next;
                L.append(t.getUserKey());
                String sb = L.toString();
                String userKey = t.getUserKey();
                String name = t.getName();
                String description = t.getDescription();
                Image avatar = t.getAvatar();
                Boolean isShop = t.isShop();
                boolean booleanValue = isShop != null ? isShop.booleanValue() : false;
                List<AdvertImageWithOverlay> images = t.getImages();
                if (images != null) {
                    ArrayList arrayList5 = new ArrayList(e.collectionSizeOrDefault(images, i));
                    for (T t2 : images) {
                        Image image = t2.getImage();
                        AdvertImageWithOverlay.Overlay overlay = t2.getOverlay();
                        String str3 = null;
                        if (overlay != null) {
                            it2 = it3;
                            str2 = overlay.getTitle();
                        } else {
                            it2 = it3;
                            str2 = null;
                        }
                        AdvertImageWithOverlay.Overlay overlay2 = t2.getOverlay();
                        if (overlay2 != null) {
                            str3 = overlay2.getSubtitle();
                        }
                        arrayList5.add(new SellerCarouselItem.Advert(image, str2, str3));
                        it3 = it2;
                    }
                    it = it3;
                    arrayList2 = arrayList5;
                } else {
                    it = it3;
                    arrayList2 = CollectionsKt__CollectionsKt.emptyList();
                }
                arrayList = arrayList4;
                arrayList3.add(new SellerCarouselItem(sb, str, userKey, name, description, avatar, booleanValue, arrayList2, t.getDeepLink(), t.isSubscribed(), false, t.isNotificationsActivated(), 1024, null));
            } else {
                it = it3;
                arrayList = arrayList4;
            }
            arrayList.add(Unit.INSTANCE);
            it3 = it;
            arrayList4 = arrayList;
            i = 10;
        }
        return arrayList3;
    }
}
