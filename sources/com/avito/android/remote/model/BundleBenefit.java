package com.avito.android.remote.model;

import com.avito.android.deep_linking.links.DeepLink;
import com.facebook.share.internal.ShareConstants;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0003\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001e\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001e\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/avito/android/remote/model/BundleBenefit;", "", "", "text", "Ljava/lang/String;", "getText", "()Ljava/lang/String;", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "Lcom/avito/android/deep_linking/links/DeepLink;", "getDeepLink", "()Lcom/avito/android/deep_linking/links/DeepLink;", "Lcom/avito/android/remote/model/BenefitColoredIcon;", "icon", "Lcom/avito/android/remote/model/BenefitColoredIcon;", "getIcon", "()Lcom/avito/android/remote/model/BenefitColoredIcon;", "Lcom/avito/android/remote/model/BundleBadge;", "badge", "Lcom/avito/android/remote/model/BundleBadge;", "getBadge", "()Lcom/avito/android/remote/model/BundleBadge;", "<init>", "(Ljava/lang/String;Lcom/avito/android/remote/model/BenefitColoredIcon;Lcom/avito/android/remote/model/BundleBadge;Lcom/avito/android/deep_linking/links/DeepLink;)V", "vas-bundles_release"}, k = 1, mv = {1, 4, 2})
public final class BundleBenefit {
    @SerializedName("badge")
    @Nullable
    private final BundleBadge badge;
    @SerializedName(ShareConstants.MEDIA_URI)
    @Nullable
    private final DeepLink deepLink;
    @SerializedName("icon")
    @Nullable
    private final BenefitColoredIcon icon;
    @SerializedName("text")
    @NotNull
    private final String text;

    public BundleBenefit(@NotNull String str, @Nullable BenefitColoredIcon benefitColoredIcon, @Nullable BundleBadge bundleBadge, @Nullable DeepLink deepLink2) {
        Intrinsics.checkNotNullParameter(str, "text");
        this.text = str;
        this.icon = benefitColoredIcon;
        this.badge = bundleBadge;
        this.deepLink = deepLink2;
    }

    @Nullable
    public final BundleBadge getBadge() {
        return this.badge;
    }

    @Nullable
    public final DeepLink getDeepLink() {
        return this.deepLink;
    }

    @Nullable
    public final BenefitColoredIcon getIcon() {
        return this.icon;
    }

    @NotNull
    public final String getText() {
        return this.text;
    }
}
