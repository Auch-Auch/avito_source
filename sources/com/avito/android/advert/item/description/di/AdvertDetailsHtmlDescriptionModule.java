package com.avito.android.advert.item.description.di;

import android.content.res.Resources;
import com.avito.android.advert_details.R;
import com.avito.android.di.PerFragment;
import com.avito.android.html_formatter.HtmlRenderOptions;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/advert/item/description/di/AdvertDetailsHtmlDescriptionModule;", "", "Landroid/content/res/Resources;", "resources", "Lcom/avito/android/html_formatter/HtmlRenderOptions;", "provideHtmlRenderOptions", "(Landroid/content/res/Resources;)Lcom/avito/android/html_formatter/HtmlRenderOptions;", "<init>", "()V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
@Module
public final class AdvertDetailsHtmlDescriptionModule {
    @NotNull
    public static final AdvertDetailsHtmlDescriptionModule INSTANCE = new AdvertDetailsHtmlDescriptionModule();

    @Provides
    @PerFragment
    @NotNull
    public final HtmlRenderOptions provideHtmlRenderOptions(@NotNull Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        return new HtmlRenderOptions((int) resources.getDimension(R.dimen.advert_description_list_bullet_left_margin), (int) resources.getDimension(R.dimen.advert_description_list_bullet_right_margin), (int) resources.getDimension(R.dimen.advert_description_list_bullet_symbol_width), "—", false, 16, null);
    }
}
