package com.avito.android.serp.adapter.rich_snippets;

import com.avito.android.Features;
import com.avito.android.remote.auth.AuthSource;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/avito/android/serp/adapter/rich_snippets/AdvertSellerConverterImpl;", "Lcom/avito/android/serp/adapter/rich_snippets/AdvertSellerConverter;", "Lcom/avito/android/remote/model/AdvertSellerInfo;", "advertSellerInfo", "Lru/avito/component/serp/cyclic_gallery/image_carousel/seller_info/CarouselSellerItem;", "convert", "(Lcom/avito/android/remote/model/AdvertSellerInfo;)Lru/avito/component/serp/cyclic_gallery/image_carousel/seller_info/CarouselSellerItem;", "Lcom/avito/android/Features;", AuthSource.SEND_ABUSE, "Lcom/avito/android/Features;", "features", "<init>", "(Lcom/avito/android/Features;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertSellerConverterImpl implements AdvertSellerConverter {
    public final Features a;

    @Inject
    public AdvertSellerConverterImpl(@NotNull Features features) {
        Intrinsics.checkNotNullParameter(features, "features");
        this.a = features;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0069  */
    @Override // com.avito.android.serp.adapter.rich_snippets.AdvertSellerConverter
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ru.avito.component.serp.cyclic_gallery.image_carousel.seller_info.CarouselSellerItem convert(@org.jetbrains.annotations.NotNull com.avito.android.remote.model.AdvertSellerInfo r14) {
        /*
            r13 = this;
            java.lang.String r0 = "advertSellerInfo"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            com.avito.android.Features r0 = r13.a
            com.avito.android.toggle.Feature r0 = r0.getSellerInfoInRichSnippet()
            java.lang.Object r0 = r0.invoke()
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            r1 = 0
            if (r0 != 0) goto L_0x0019
            return r1
        L_0x0019:
            ru.avito.component.serp.cyclic_gallery.image_carousel.seller_info.CarouselSellerItem r0 = new ru.avito.component.serp.cyclic_gallery.image_carousel.seller_info.CarouselSellerItem
            java.lang.String r2 = "UUID.randomUUID().toString()"
            java.lang.String r3 = a2.b.a.a.a.I2(r2)
            java.lang.String r4 = r14.getName()
            java.lang.String r9 = r14.getSellerTypeName()
            com.avito.android.deep_linking.links.DeepLink r12 = r14.getLink()
            java.lang.Boolean r2 = r14.isShop()
            if (r2 == 0) goto L_0x0039
            boolean r2 = r2.booleanValue()
            r11 = r2
            goto L_0x003b
        L_0x0039:
            r2 = 0
            r11 = 0
        L_0x003b:
            com.avito.android.remote.model.Image r10 = r14.getImage()
            com.avito.android.remote.model.SellerRating r2 = r14.getRating()
            if (r2 == 0) goto L_0x004c
            java.lang.Float r2 = r2.getScoreFloat()
            if (r2 == 0) goto L_0x004c
            goto L_0x005a
        L_0x004c:
            com.avito.android.remote.model.SellerRating r2 = r14.getRating()
            if (r2 == 0) goto L_0x005c
            float r2 = r2.getScore()
            java.lang.Float r2 = java.lang.Float.valueOf(r2)
        L_0x005a:
            r5 = r2
            goto L_0x005d
        L_0x005c:
            r5 = r1
        L_0x005d:
            com.avito.android.remote.model.SellerRating r2 = r14.getRating()
            if (r2 == 0) goto L_0x0069
            java.lang.String r2 = r2.getText()
            r6 = r2
            goto L_0x006a
        L_0x0069:
            r6 = r1
        L_0x006a:
            com.avito.android.remote.model.SellerVerification r2 = r14.getVerification()
            if (r2 == 0) goto L_0x007c
            com.avito.android.remote.model.SellerVerification$VerificationItem r2 = r2.getExternal()
            if (r2 == 0) goto L_0x007c
            java.lang.String r2 = r2.getTitle()
            r7 = r2
            goto L_0x007d
        L_0x007c:
            r7 = r1
        L_0x007d:
            com.avito.android.remote.model.SellerVerification r14 = r14.getVerification()
            if (r14 == 0) goto L_0x008d
            com.avito.android.remote.model.SellerVerification$VerificationItem r14 = r14.getInternal()
            if (r14 == 0) goto L_0x008d
            java.lang.String r1 = r14.getTitle()
        L_0x008d:
            r8 = r1
            r2 = r0
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.serp.adapter.rich_snippets.AdvertSellerConverterImpl.convert(com.avito.android.remote.model.AdvertSellerInfo):ru.avito.component.serp.cyclic_gallery.image_carousel.seller_info.CarouselSellerItem");
    }
}
