package com.avito.android.advert_core.feature_teasers.common.dialog;

import a2.g.r.g;
import androidx.annotation.DimenRes;
import androidx.annotation.StyleRes;
import com.avito.android.advert_core.feature_teasers.common.AdvertDetailsFeatureTeaserItem;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.text.AttributedText;
import com.avito.conveyor_item.Item;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000e\u0018\u00002\u00020\u0001Bi\u0012\u0006\u0010!\u001a\u00020\u001c\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\"\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\b\u0012\b\b\u0001\u0010\u0012\u001a\u00020\u0002\u0012\b\b\u0002\u0010*\u001a\u00020\"\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0003\u0010\u001b\u001a\u00020\u0002¢\u0006\u0004\b.\u0010/R\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\r\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0012\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0018\u001a\u0004\u0018\u00010\u00138\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0019\u0010\u001b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u000f\u001a\u0004\b\u001a\u0010\u0011R\u001c\u0010!\u001a\u00020\u001c8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001b\u0010'\u001a\u0004\u0018\u00010\"8\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u001c\u0010*\u001a\u00020\"8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b(\u0010$\u001a\u0004\b)\u0010&R\u001b\u0010-\u001a\u0004\u0018\u00010\u00138\u0006@\u0006¢\u0006\f\n\u0004\b+\u0010\u0015\u001a\u0004\b,\u0010\u0017¨\u00060"}, d2 = {"Lcom/avito/android/advert_core/feature_teasers/common/dialog/AdvertDetailsFeatureTeaserDialogTextItem;", "Lcom/avito/conveyor_item/Item;", "", "h", "Ljava/lang/Integer;", "getLeftPaddingRes", "()Ljava/lang/Integer;", "leftPaddingRes", "Lcom/avito/android/remote/model/text/AttributedText;", "c", "Lcom/avito/android/remote/model/text/AttributedText;", "getAttributedText", "()Lcom/avito/android/remote/model/text/AttributedText;", "attributedText", "d", "I", "getTextStyle", "()I", "textStyle", "Lcom/avito/android/advert_core/feature_teasers/common/AdvertDetailsFeatureTeaserItem$Icon;", "f", "Lcom/avito/android/advert_core/feature_teasers/common/AdvertDetailsFeatureTeaserItem$Icon;", "getRightIcon", "()Lcom/avito/android/advert_core/feature_teasers/common/AdvertDetailsFeatureTeaserItem$Icon;", "rightIcon", "i", "getDrawablePadding", "drawablePadding", "", AuthSource.SEND_ABUSE, "J", "getId", "()J", "id", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getText", "()Ljava/lang/String;", "text", "e", "getStringId", "stringId", g.a, "getLeftIcon", "leftIcon", "<init>", "(JLjava/lang/String;Lcom/avito/android/remote/model/text/AttributedText;ILjava/lang/String;Lcom/avito/android/advert_core/feature_teasers/common/AdvertDetailsFeatureTeaserItem$Icon;Lcom/avito/android/advert_core/feature_teasers/common/AdvertDetailsFeatureTeaserItem$Icon;Ljava/lang/Integer;I)V", "advert-core_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertDetailsFeatureTeaserDialogTextItem implements Item {
    public final long a;
    @Nullable
    public final String b;
    @Nullable
    public final AttributedText c;
    public final int d;
    @NotNull
    public final String e;
    @Nullable
    public final AdvertDetailsFeatureTeaserItem.Icon f;
    @Nullable
    public final AdvertDetailsFeatureTeaserItem.Icon g;
    @Nullable
    public final Integer h;
    public final int i;

    public AdvertDetailsFeatureTeaserDialogTextItem(long j, @Nullable String str, @Nullable AttributedText attributedText, @StyleRes int i2, @NotNull String str2, @Nullable AdvertDetailsFeatureTeaserItem.Icon icon, @Nullable AdvertDetailsFeatureTeaserItem.Icon icon2, @DimenRes @Nullable Integer num, @DimenRes int i3) {
        Intrinsics.checkNotNullParameter(str2, "stringId");
        this.a = j;
        this.b = str;
        this.c = attributedText;
        this.d = i2;
        this.e = str2;
        this.f = icon;
        this.g = icon2;
        this.h = num;
        this.i = i3;
    }

    @Nullable
    public final AttributedText getAttributedText() {
        return this.c;
    }

    public final int getDrawablePadding() {
        return this.i;
    }

    @Override // com.avito.conveyor_item.Item, com.avito.konveyor.blueprint.Item
    public long getId() {
        return this.a;
    }

    @Nullable
    public final AdvertDetailsFeatureTeaserItem.Icon getLeftIcon() {
        return this.g;
    }

    @Nullable
    public final Integer getLeftPaddingRes() {
        return this.h;
    }

    @Nullable
    public final AdvertDetailsFeatureTeaserItem.Icon getRightIcon() {
        return this.f;
    }

    @Override // com.avito.conveyor_item.Item
    @NotNull
    public String getStringId() {
        return this.e;
    }

    @Nullable
    public final String getText() {
        return this.b;
    }

    public final int getTextStyle() {
        return this.d;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AdvertDetailsFeatureTeaserDialogTextItem(long j, String str, AttributedText attributedText, int i2, String str2, AdvertDetailsFeatureTeaserItem.Icon icon, AdvertDetailsFeatureTeaserItem.Icon icon2, Integer num, int i3, int i4, j jVar) {
        this(j, (i4 & 2) != 0 ? null : str, (i4 & 4) != 0 ? null : attributedText, i2, (i4 & 16) != 0 ? String.valueOf(j) : str2, (i4 & 32) != 0 ? null : icon, (i4 & 64) != 0 ? null : icon2, (i4 & 128) != 0 ? null : num, (i4 & 256) != 0 ? 0 : i3);
    }
}
