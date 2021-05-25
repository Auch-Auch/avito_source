package com.avito.android.user_adverts.tab_screens.converters;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.LinkedInfoBanner;
import com.avito.android.remote.model.LinkedInfoBannerIcon;
import com.avito.android.remote.model.UniversalColor;
import com.avito.android.remote.model.text.AttributedText;
import com.avito.android.user_adverts.tab_screens.advert_list.linked_info_banner.LinkedInfoBannerItem;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/avito/android/user_adverts/tab_screens/converters/LinkedInfoBannerConverterImpl;", "Lcom/avito/android/user_adverts/tab_screens/converters/LinkedInfoBannerConverter;", "Lcom/avito/android/remote/model/LinkedInfoBanner;", "shortcut", "Lcom/avito/android/user_adverts/tab_screens/advert_list/linked_info_banner/LinkedInfoBannerItem;", "convert", "(Lcom/avito/android/remote/model/LinkedInfoBanner;)Lcom/avito/android/user_adverts/tab_screens/advert_list/linked_info_banner/LinkedInfoBannerItem;", "", AuthSource.SEND_ABUSE, "I", "columnsCount", "<init>", "(I)V", "user-adverts_release"}, k = 1, mv = {1, 4, 2})
public final class LinkedInfoBannerConverterImpl implements LinkedInfoBannerConverter {
    public final int a;

    public LinkedInfoBannerConverterImpl(int i) {
        this.a = i;
    }

    @Override // com.avito.android.user_adverts.tab_screens.converters.LinkedInfoBannerConverter
    @NotNull
    public LinkedInfoBannerItem convert(@NotNull LinkedInfoBanner linkedInfoBanner) {
        Intrinsics.checkNotNullParameter(linkedInfoBanner, "shortcut");
        String id = linkedInfoBanner.getId();
        if (id == null) {
            id = a.I2("UUID.randomUUID().toString()");
        }
        String title = linkedInfoBanner.getTitle();
        String message = linkedInfoBanner.getMessage();
        AttributedText detailsLink = linkedInfoBanner.getDetailsLink();
        UniversalColor background = linkedInfoBanner.getBackground();
        LinkedInfoBannerIcon icon = linkedInfoBanner.getIcon();
        int i = this.a;
        Boolean closeBtnVisible = linkedInfoBanner.getCloseBtnVisible();
        return new LinkedInfoBannerItem(id, title, message, detailsLink, background, icon, closeBtnVisible != null ? closeBtnVisible.booleanValue() : false, i, linkedInfoBanner.getButton());
    }
}
