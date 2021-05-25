package com.avito.android.bundles.ui.recycler.item.benefit;

import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.BenefitColoredIcon;
import com.avito.android.remote.model.BundleBadge;
import com.avito.conveyor_item.Item;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0010\u001a\u00020\b\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\r\u001a\u00020\b\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b\u001d\u0010\u001eR\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u0010\u001a\u00020\b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\fR\u001b\u0010\u0016\u001a\u0004\u0018\u00010\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001b\u0010\u001c\u001a\u0004\u0018\u00010\u00178\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001f"}, d2 = {"Lcom/avito/android/bundles/ui/recycler/item/benefit/BundleBenefitItem;", "Lcom/avito/conveyor_item/Item;", "Lcom/avito/android/remote/model/BenefitColoredIcon;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/remote/model/BenefitColoredIcon;", "getBenefitIcon", "()Lcom/avito/android/remote/model/BenefitColoredIcon;", "benefitIcon", "", "c", "Ljava/lang/String;", "getText", "()Ljava/lang/String;", "text", AuthSource.SEND_ABUSE, "getStringId", "stringId", "Lcom/avito/android/remote/model/BundleBadge;", "d", "Lcom/avito/android/remote/model/BundleBadge;", "getBadge", "()Lcom/avito/android/remote/model/BundleBadge;", "badge", "Lcom/avito/android/deep_linking/links/DeepLink;", "e", "Lcom/avito/android/deep_linking/links/DeepLink;", "getDeepLink", "()Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "<init>", "(Ljava/lang/String;Lcom/avito/android/remote/model/BenefitColoredIcon;Ljava/lang/String;Lcom/avito/android/remote/model/BundleBadge;Lcom/avito/android/deep_linking/links/DeepLink;)V", "vas-bundles_release"}, k = 1, mv = {1, 4, 2})
public final class BundleBenefitItem implements Item {
    @NotNull
    public final String a;
    @Nullable
    public final BenefitColoredIcon b;
    @NotNull
    public final String c;
    @Nullable
    public final BundleBadge d;
    @Nullable
    public final DeepLink e;

    public BundleBenefitItem(@NotNull String str, @Nullable BenefitColoredIcon benefitColoredIcon, @NotNull String str2, @Nullable BundleBadge bundleBadge, @Nullable DeepLink deepLink) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(str2, "text");
        this.a = str;
        this.b = benefitColoredIcon;
        this.c = str2;
        this.d = bundleBadge;
        this.e = deepLink;
    }

    @Nullable
    public final BundleBadge getBadge() {
        return this.d;
    }

    @Nullable
    public final BenefitColoredIcon getBenefitIcon() {
        return this.b;
    }

    @Nullable
    public final DeepLink getDeepLink() {
        return this.e;
    }

    @Override // com.avito.conveyor_item.Item, com.avito.konveyor.blueprint.Item
    public long getId() {
        return Item.DefaultImpls.getId(this);
    }

    @Override // com.avito.conveyor_item.Item
    @NotNull
    public String getStringId() {
        return this.a;
    }

    @NotNull
    public final String getText() {
        return this.c;
    }
}
