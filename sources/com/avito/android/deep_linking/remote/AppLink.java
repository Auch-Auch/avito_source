package com.avito.android.deep_linking.remote;

import com.avito.android.deep_linking.links.DeepLink;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0007\u0010\bR\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/deep_linking/remote/AppLink;", "", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "Lcom/avito/android/deep_linking/links/DeepLink;", "getDeepLink", "()Lcom/avito/android/deep_linking/links/DeepLink;", "<init>", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "deep-linking_release"}, k = 1, mv = {1, 4, 2})
public final class AppLink {
    @SerializedName("deepLink")
    @Nullable
    private final DeepLink deepLink;

    public AppLink(@Nullable DeepLink deepLink2) {
        this.deepLink = deepLink2;
    }

    @Nullable
    public final DeepLink getDeepLink() {
        return this.deepLink;
    }
}
