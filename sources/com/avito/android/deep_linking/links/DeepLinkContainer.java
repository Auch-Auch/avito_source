package com.avito.android.deep_linking.links;

import android.net.Uri;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\u0002\u0012\u0006\u0010\r\u001a\u00020\b¢\u0006\u0004\b\u000e\u0010\u000fR\u001f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/deep_linking/links/DeepLinkContainer;", "Lcom/avito/android/deep_linking/links/DeepLink;", "", "c", "Ljava/util/List;", "getDeepLinks", "()Ljava/util/List;", "deepLinks", "Landroid/net/Uri;", "d", "Landroid/net/Uri;", "getOriginalUri", "()Landroid/net/Uri;", "originalUri", "<init>", "(Ljava/util/List;Landroid/net/Uri;)V", "models_release"}, k = 1, mv = {1, 4, 2})
public abstract class DeepLinkContainer extends DeepLink {
    @NotNull
    public final List<DeepLink> c;
    @NotNull
    public final Uri d;

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.util.List<? extends com.avito.android.deep_linking.links.DeepLink> */
    /* JADX WARN: Multi-variable type inference failed */
    public DeepLinkContainer(@NotNull List<? extends DeepLink> list, @NotNull Uri uri) {
        Intrinsics.checkNotNullParameter(list, "deepLinks");
        Intrinsics.checkNotNullParameter(uri, "originalUri");
        this.c = list;
        this.d = uri;
    }

    @NotNull
    public final List<DeepLink> getDeepLinks() {
        return this.c;
    }

    @NotNull
    public final Uri getOriginalUri() {
        return this.d;
    }
}
