package com.avito.android.user_adverts.tab_screens.converters;

import a2.g.r.g;
import com.avito.android.Features;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Disclaimer;
import com.avito.android.remote.model.LinkedInfoBanner;
import com.avito.android.remote.model.SerpElement;
import com.avito.android.remote.model.ShortcutBanner;
import com.avito.android.remote.model.UserAdvert;
import com.avito.android.remote.model.user_adverts.DiscountBanner;
import com.avito.android.remote.model.user_adverts.PerformanceVasBanner;
import com.avito.android.serp.adapter.SerpItem;
import com.avito.android.serp.adapter.ShortcutBannerConverter;
import com.avito.android.user_adverts.tab_screens.advert_list.loading.LoadingElement;
import com.avito.android.user_adverts.tab_screens.advert_list.loading.LoadingItem;
import com.avito.android.user_adverts.tab_screens.advert_list.shortcut_title.ShortcutTitleItem;
import com.facebook.share.internal.MessengerShareContentUtility;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001BA\b\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\u0006\u0010\u001f\u001a\u00020\u001c\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010#\u001a\u00020 \u0012\u0006\u0010\u001b\u001a\u00020\u0018\u0012\u0006\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b$\u0010%J#\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"¨\u0006&"}, d2 = {"Lcom/avito/android/user_adverts/tab_screens/converters/UserElementItemConverterImpl;", "Lcom/avito/android/user_adverts/tab_screens/converters/UserElementItemConverter;", "", "Lcom/avito/android/remote/model/SerpElement;", MessengerShareContentUtility.ELEMENTS, "Lcom/avito/android/serp/adapter/SerpItem;", "convert", "(Ljava/util/List;)Ljava/util/List;", "Lcom/avito/android/Features;", g.a, "Lcom/avito/android/Features;", "features", "Lcom/avito/android/user_adverts/tab_screens/converters/DiscountBannerConverter;", "d", "Lcom/avito/android/user_adverts/tab_screens/converters/DiscountBannerConverter;", "discountBannerConverter", "Lcom/avito/android/user_adverts/tab_screens/converters/UserAdvertConverter;", AuthSource.SEND_ABUSE, "Lcom/avito/android/user_adverts/tab_screens/converters/UserAdvertConverter;", "userAdvertConverter", "Lcom/avito/android/user_adverts/tab_screens/converters/LinkedInfoBannerConverter;", "c", "Lcom/avito/android/user_adverts/tab_screens/converters/LinkedInfoBannerConverter;", "linkedInfoBannerConverter", "Lcom/avito/android/user_adverts/tab_screens/converters/PerformanceVasBannerConverter;", "f", "Lcom/avito/android/user_adverts/tab_screens/converters/PerformanceVasBannerConverter;", "performanceVasBannerConverter", "Lcom/avito/android/serp/adapter/ShortcutBannerConverter;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/serp/adapter/ShortcutBannerConverter;", "shortcutBannerConverter", "Lcom/avito/android/user_adverts/tab_screens/converters/DisclaimerConverter;", "e", "Lcom/avito/android/user_adverts/tab_screens/converters/DisclaimerConverter;", "disclaimerConverter", "<init>", "(Lcom/avito/android/user_adverts/tab_screens/converters/UserAdvertConverter;Lcom/avito/android/serp/adapter/ShortcutBannerConverter;Lcom/avito/android/user_adverts/tab_screens/converters/LinkedInfoBannerConverter;Lcom/avito/android/user_adverts/tab_screens/converters/DiscountBannerConverter;Lcom/avito/android/user_adverts/tab_screens/converters/DisclaimerConverter;Lcom/avito/android/user_adverts/tab_screens/converters/PerformanceVasBannerConverter;Lcom/avito/android/Features;)V", "user-adverts_release"}, k = 1, mv = {1, 4, 2})
public final class UserElementItemConverterImpl implements UserElementItemConverter {
    public final UserAdvertConverter a;
    public final ShortcutBannerConverter b;
    public final LinkedInfoBannerConverter c;
    public final DiscountBannerConverter d;
    public final DisclaimerConverter e;
    public final PerformanceVasBannerConverter f;
    public final Features g;

    @Inject
    public UserElementItemConverterImpl(@NotNull UserAdvertConverter userAdvertConverter, @NotNull ShortcutBannerConverter shortcutBannerConverter, @NotNull LinkedInfoBannerConverter linkedInfoBannerConverter, @NotNull DiscountBannerConverter discountBannerConverter, @NotNull DisclaimerConverter disclaimerConverter, @NotNull PerformanceVasBannerConverter performanceVasBannerConverter, @NotNull Features features) {
        Intrinsics.checkNotNullParameter(userAdvertConverter, "userAdvertConverter");
        Intrinsics.checkNotNullParameter(shortcutBannerConverter, "shortcutBannerConverter");
        Intrinsics.checkNotNullParameter(linkedInfoBannerConverter, "linkedInfoBannerConverter");
        Intrinsics.checkNotNullParameter(discountBannerConverter, "discountBannerConverter");
        Intrinsics.checkNotNullParameter(disclaimerConverter, "disclaimerConverter");
        Intrinsics.checkNotNullParameter(performanceVasBannerConverter, "performanceVasBannerConverter");
        Intrinsics.checkNotNullParameter(features, "features");
        this.a = userAdvertConverter;
        this.b = shortcutBannerConverter;
        this.c = linkedInfoBannerConverter;
        this.d = discountBannerConverter;
        this.e = disclaimerConverter;
        this.f = performanceVasBannerConverter;
        this.g = features;
    }

    @Override // com.avito.android.user_adverts.tab_screens.converters.UserElementItemConverter
    @NotNull
    public List<SerpItem> convert(@NotNull List<? extends SerpElement> list) {
        Intrinsics.checkNotNullParameter(list, MessengerShareContentUtility.ELEMENTS);
        ArrayList arrayList = new ArrayList();
        String str = null;
        for (T t : list) {
            if (t instanceof UserAdvert) {
                T t2 = t;
                boolean z = true;
                if (!Intrinsics.areEqual(str, t2.getShortcut())) {
                    str = t2.getShortcut();
                    String shortcutTitle = t2.getShortcutTitle();
                    if (shortcutTitle != null) {
                        if (shortcutTitle.length() <= 0) {
                            z = false;
                        }
                        if (z) {
                            arrayList.add(new ShortcutTitleItem(shortcutTitle));
                        }
                    }
                }
                arrayList.add(this.a.convert(t2));
            } else if (t instanceof Disclaimer) {
                arrayList.add(this.e.convert(t));
            } else if (t instanceof ShortcutBanner) {
                arrayList.add(ShortcutBannerConverter.DefaultImpls.convert$default(this.b, t, null, 2, null));
            } else if (t instanceof LinkedInfoBanner) {
                T t3 = t;
                if (!CollectionsKt___CollectionsKt.contains(UserElementItemConverterKt.access$getStrBanners$p(), t3.getId())) {
                    arrayList.add(this.c.convert(t3));
                } else if (this.g.getStrBannersOnUserAdverts().invoke().booleanValue()) {
                    arrayList.add(this.c.convert(t3));
                }
            } else if (t instanceof DiscountBanner) {
                arrayList.add(this.d.convert(t));
            } else if (t instanceof PerformanceVasBanner) {
                arrayList.add(this.f.convert(t));
            } else if (t instanceof LoadingElement) {
                arrayList.add(new LoadingItem());
            }
        }
        return arrayList;
    }
}
