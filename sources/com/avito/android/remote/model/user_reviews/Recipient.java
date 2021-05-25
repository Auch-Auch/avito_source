package com.avito.android.remote.model.user_reviews;

import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.model.Image;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0003\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u00020\u00078\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\b\u0010\nR\u001c\u0010\f\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0011\u001a\u00020\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2 = {"Lcom/avito/android/remote/model/user_reviews/Recipient;", "", "Lcom/avito/android/deep_linking/links/DeepLink;", "link", "Lcom/avito/android/deep_linking/links/DeepLink;", "getLink", "()Lcom/avito/android/deep_linking/links/DeepLink;", "", "isShop", "Z", "()Z", "Lcom/avito/android/remote/model/Image;", "avatar", "Lcom/avito/android/remote/model/Image;", "getAvatar", "()Lcom/avito/android/remote/model/Image;", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;ZLcom/avito/android/remote/model/Image;Lcom/avito/android/deep_linking/links/DeepLink;)V", "rating_release"}, k = 1, mv = {1, 4, 2})
public final class Recipient {
    @SerializedName("avatar")
    @NotNull
    private final Image avatar;
    @SerializedName("isShop")
    private final boolean isShop;
    @SerializedName("link")
    @NotNull
    private final DeepLink link;
    @SerializedName("title")
    @NotNull
    private final String title;

    public Recipient(@NotNull String str, boolean z, @NotNull Image image, @NotNull DeepLink deepLink) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(image, "avatar");
        Intrinsics.checkNotNullParameter(deepLink, "link");
        this.title = str;
        this.isShop = z;
        this.avatar = image;
        this.link = deepLink;
    }

    @NotNull
    public final Image getAvatar() {
        return this.avatar;
    }

    @NotNull
    public final DeepLink getLink() {
        return this.link;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    public final boolean isShop() {
        return this.isShop;
    }
}
