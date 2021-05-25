package com.avito.android.serp.adapter;

import com.avito.android.deep_linking.DeepLinkFactory;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Background;
import com.avito.android.remote.model.BannerImages;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.ShortcutBanner;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\u0006\u0010\f\u001a\u00020\t¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/avito/android/serp/adapter/ShortcutBannerConverterImpl;", "Lcom/avito/android/serp/adapter/ShortcutBannerConverter;", "Lcom/avito/android/remote/model/ShortcutBanner;", "shortcut", "", "stringId", "Lcom/avito/android/serp/adapter/ShortcutBannerItem;", "convert", "(Lcom/avito/android/remote/model/ShortcutBanner;Ljava/lang/String;)Lcom/avito/android/serp/adapter/ShortcutBannerItem;", "", AuthSource.BOOKING_ORDER, "I", "columnsCount", "Lcom/avito/android/deep_linking/DeepLinkFactory;", AuthSource.SEND_ABUSE, "Lcom/avito/android/deep_linking/DeepLinkFactory;", "deepLinkFactory", "<init>", "(Lcom/avito/android/deep_linking/DeepLinkFactory;I)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class ShortcutBannerConverterImpl implements ShortcutBannerConverter {
    public final DeepLinkFactory a;
    public final int b;

    public ShortcutBannerConverterImpl(@NotNull DeepLinkFactory deepLinkFactory, int i) {
        Intrinsics.checkNotNullParameter(deepLinkFactory, "deepLinkFactory");
        this.a = deepLinkFactory;
        this.b = i;
    }

    @Override // com.avito.android.serp.adapter.ShortcutBannerConverter
    @NotNull
    public ShortcutBannerItem convert(@NotNull ShortcutBanner shortcutBanner, @NotNull String str) {
        Intrinsics.checkNotNullParameter(shortcutBanner, "shortcut");
        Intrinsics.checkNotNullParameter(str, "stringId");
        long uniqueId = SerpElementUtilsKt.getUniqueId(shortcutBanner.getUniqueId(), str);
        String title = shortcutBanner.getTitle();
        DeepLink createFromUri = this.a.createFromUri(shortcutBanner.getUri());
        BannerImages images = shortcutBanner.getImages();
        Image left = images != null ? images.getLeft() : null;
        BannerImages images2 = shortcutBanner.getImages();
        Image right = images2 != null ? images2.getRight() : null;
        Background background = shortcutBanner.getBackground();
        Image image = background != null ? background.getImage() : null;
        Background background2 = shortcutBanner.getBackground();
        return new ShortcutBannerItem(uniqueId, str, title, createFromUri, left, right, image, background2 != null ? background2.getColor() : null, this.b);
    }
}
