package com.avito.android.remote.model.subscriber;

import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.model.Image;
import com.facebook.share.internal.ShareConstants;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u0017\u0010\u0018R\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005R\u001c\u0010\u0007\u001a\u00020\u00068\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u001e\u0010\u000b\u001a\u0004\u0018\u00010\u00068\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000b\u0010\b\u001a\u0004\b\f\u0010\nR\u001e\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lcom/avito/android/remote/model/subscriber/SubscriberItem;", "Lcom/avito/android/remote/model/subscriber/UserSubscribersResultItem;", "", "isShop", "Ljava/lang/Boolean;", "()Ljava/lang/Boolean;", "", "name", "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "description", "getDescription", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "Lcom/avito/android/deep_linking/links/DeepLink;", "getDeepLink", "()Lcom/avito/android/deep_linking/links/DeepLink;", "Lcom/avito/android/remote/model/Image;", "avatar", "Lcom/avito/android/remote/model/Image;", "getAvatar", "()Lcom/avito/android/remote/model/Image;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/Image;Ljava/lang/Boolean;Lcom/avito/android/deep_linking/links/DeepLink;)V", "favorite-sellers_release"}, k = 1, mv = {1, 4, 2})
public final class SubscriberItem extends UserSubscribersResultItem {
    @SerializedName("avatar")
    @Nullable
    private final Image avatar;
    @SerializedName(ShareConstants.MEDIA_URI)
    @Nullable
    private final DeepLink deepLink;
    @SerializedName("description")
    @Nullable
    private final String description;
    @SerializedName("isShop")
    @Nullable
    private final Boolean isShop;
    @SerializedName("name")
    @NotNull
    private final String name;

    public SubscriberItem(@NotNull String str, @Nullable String str2, @Nullable Image image, @Nullable Boolean bool, @Nullable DeepLink deepLink2) {
        Intrinsics.checkNotNullParameter(str, "name");
        this.name = str;
        this.description = str2;
        this.avatar = image;
        this.isShop = bool;
        this.deepLink = deepLink2;
    }

    @Nullable
    public final Image getAvatar() {
        return this.avatar;
    }

    @Nullable
    public final DeepLink getDeepLink() {
        return this.deepLink;
    }

    @Nullable
    public final String getDescription() {
        return this.description;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @Nullable
    public final Boolean isShop() {
        return this.isShop;
    }
}
