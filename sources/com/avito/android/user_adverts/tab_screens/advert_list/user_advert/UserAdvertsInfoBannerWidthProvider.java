package com.avito.android.user_adverts.tab_screens.advert_list.user_advert;

import android.content.res.Resources;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.serp.adapter.ShortcutBannerWidthProvider;
import com.avito.android.ui_components.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u0005\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u001c\u0010\t\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0004\u001a\u0004\b\u0007\u0010\b¨\u0006\u000e"}, d2 = {"Lcom/avito/android/user_adverts/tab_screens/advert_list/user_advert/UserAdvertsInfoBannerWidthProvider;", "Lcom/avito/android/serp/adapter/ShortcutBannerWidthProvider;", "", AuthSource.SEND_ABUSE, "I", "calculatedWidth", AuthSource.BOOKING_ORDER, "getWidthPx", "()I", "widthPx", "Landroid/content/res/Resources;", "resources", "<init>", "(Landroid/content/res/Resources;)V", "user-adverts_release"}, k = 1, mv = {1, 4, 2})
public final class UserAdvertsInfoBannerWidthProvider implements ShortcutBannerWidthProvider {
    public final int a;
    public final int b;

    public UserAdvertsInfoBannerWidthProvider(@NotNull Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        int dimensionPixelOffset = resources.getDisplayMetrics().widthPixels - (resources.getDimensionPixelOffset(R.dimen.user_adverts_list_item_horizontal_padding) * 2);
        this.a = dimensionPixelOffset;
        this.b = dimensionPixelOffset;
    }

    @Override // com.avito.android.serp.adapter.ShortcutBannerWidthProvider
    public int getWidthPx() {
        return this.b;
    }
}
