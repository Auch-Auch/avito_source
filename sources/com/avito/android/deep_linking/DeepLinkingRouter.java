package com.avito.android.deep_linking;

import com.avito.android.CalledFrom;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.DeepLinkContainer;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ%\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\u000b2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/avito/android/deep_linking/DeepLinkingRouter;", "", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "Lcom/avito/android/CalledFrom$AppLinking;", "calledFrom", "", "openDeepLink", "(Lcom/avito/android/deep_linking/links/DeepLink;Lcom/avito/android/CalledFrom$AppLinking;)Z", "Lcom/avito/android/deep_linking/links/DeepLinkContainer;", "deepLinkContainer", "", "openDeepLinkPackage", "(Lcom/avito/android/deep_linking/links/DeepLinkContainer;Lcom/avito/android/CalledFrom$AppLinking;)Ljava/util/List;", "deep-linking_release"}, k = 1, mv = {1, 4, 2})
public interface DeepLinkingRouter {
    boolean openDeepLink(@NotNull DeepLink deepLink, @NotNull CalledFrom.AppLinking appLinking);

    @NotNull
    List<Boolean> openDeepLinkPackage(@NotNull DeepLinkContainer deepLinkContainer, @NotNull CalledFrom.AppLinking appLinking);
}
