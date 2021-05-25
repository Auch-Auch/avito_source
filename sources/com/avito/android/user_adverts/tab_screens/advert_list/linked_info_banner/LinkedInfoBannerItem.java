package com.avito.android.user_adverts.tab_screens.advert_list.linked_info_banner;

import a2.g.r.g;
import com.avito.android.advert_core.analytics.contactbar.PhonePageSourceKt;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.LinkedInfoBannerButton;
import com.avito.android.remote.model.LinkedInfoBannerIcon;
import com.avito.android.remote.model.UniversalColor;
import com.avito.android.remote.model.text.AttributedText;
import com.avito.android.serp.adapter.SerpItem;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B[\u0012\u0006\u0010\u0016\u001a\u00020\b\u0012\b\u00101\u001a\u0004\u0018\u00010\b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\b\u0012\b\u0010(\u001a\u0004\u0018\u00010#\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0017\u0012\b\u0010\"\u001a\u0004\u0018\u00010\u001d\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010.\u001a\u00020)\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b2\u00103R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\r\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u0013\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0016\u001a\u00020\b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0015\u0010\fR\u001b\u0010\u001c\u001a\u0004\u0018\u00010\u00178\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001b\u0010\"\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u001b\u0010(\u001a\u0004\u0018\u00010#8\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u001c\u0010.\u001a\u00020)8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R\u001b\u00101\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b/\u0010\n\u001a\u0004\b0\u0010\f¨\u00064"}, d2 = {"Lcom/avito/android/user_adverts/tab_screens/advert_list/linked_info_banner/LinkedInfoBannerItem;", "Lcom/avito/android/serp/adapter/SerpItem;", "", g.a, "Z", "getCloseBtnVisible", "()Z", "closeBtnVisible", "", "c", "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "message", "Lcom/avito/android/remote/model/LinkedInfoBannerButton;", "i", "Lcom/avito/android/remote/model/LinkedInfoBannerButton;", "getButton", "()Lcom/avito/android/remote/model/LinkedInfoBannerButton;", PhonePageSourceKt.PHONE_SOURCE_BUTTON, AuthSource.SEND_ABUSE, "getStringId", "stringId", "Lcom/avito/android/remote/model/UniversalColor;", "e", "Lcom/avito/android/remote/model/UniversalColor;", "getBackground", "()Lcom/avito/android/remote/model/UniversalColor;", "background", "Lcom/avito/android/remote/model/LinkedInfoBannerIcon;", "f", "Lcom/avito/android/remote/model/LinkedInfoBannerIcon;", "getIcon", "()Lcom/avito/android/remote/model/LinkedInfoBannerIcon;", "icon", "Lcom/avito/android/remote/model/text/AttributedText;", "d", "Lcom/avito/android/remote/model/text/AttributedText;", "getDetailsLink", "()Lcom/avito/android/remote/model/text/AttributedText;", "detailsLink", "", "h", "I", "getSpanCount", "()I", "spanCount", AuthSource.BOOKING_ORDER, "getTitle", "title", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/text/AttributedText;Lcom/avito/android/remote/model/UniversalColor;Lcom/avito/android/remote/model/LinkedInfoBannerIcon;ZILcom/avito/android/remote/model/LinkedInfoBannerButton;)V", "user-adverts_release"}, k = 1, mv = {1, 4, 2})
public final class LinkedInfoBannerItem implements SerpItem {
    @NotNull
    public final String a;
    @Nullable
    public final String b;
    @Nullable
    public final String c;
    @Nullable
    public final AttributedText d;
    @Nullable
    public final UniversalColor e;
    @Nullable
    public final LinkedInfoBannerIcon f;
    public final boolean g;
    public final int h;
    @Nullable
    public final LinkedInfoBannerButton i;

    public LinkedInfoBannerItem(@NotNull String str, @Nullable String str2, @Nullable String str3, @Nullable AttributedText attributedText, @Nullable UniversalColor universalColor, @Nullable LinkedInfoBannerIcon linkedInfoBannerIcon, boolean z, int i2, @Nullable LinkedInfoBannerButton linkedInfoBannerButton) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = attributedText;
        this.e = universalColor;
        this.f = linkedInfoBannerIcon;
        this.g = z;
        this.h = i2;
        this.i = linkedInfoBannerButton;
    }

    @Nullable
    public final UniversalColor getBackground() {
        return this.e;
    }

    @Nullable
    public final LinkedInfoBannerButton getButton() {
        return this.i;
    }

    public final boolean getCloseBtnVisible() {
        return this.g;
    }

    @Nullable
    public final AttributedText getDetailsLink() {
        return this.d;
    }

    @Nullable
    public final LinkedInfoBannerIcon getIcon() {
        return this.f;
    }

    @Override // com.avito.conveyor_item.Item, com.avito.konveyor.blueprint.Item
    public long getId() {
        return SerpItem.DefaultImpls.getId(this);
    }

    @Nullable
    public final String getMessage() {
        return this.c;
    }

    @Override // com.avito.android.serp.adapter.SpannedItem
    public int getSpanCount() {
        return this.h;
    }

    @Override // com.avito.conveyor_item.Item
    @NotNull
    public String getStringId() {
        return this.a;
    }

    @Nullable
    public final String getTitle() {
        return this.b;
    }
}
