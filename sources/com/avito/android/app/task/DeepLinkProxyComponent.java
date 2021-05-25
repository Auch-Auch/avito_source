package com.avito.android.app.task;

import com.avito.android.deep_linking.links.DeepLink;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0011\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/avito/android/app/task/DeepLinkProxyComponent;", "", "Lcom/avito/android/deep_linking/links/DeepLink;", "targetDeepLink", "()Lcom/avito/android/deep_linking/links/DeepLink;", "notification-deeplink_release"}, k = 1, mv = {1, 4, 2})
public interface DeepLinkProxyComponent {
    @Nullable
    DeepLink targetDeepLink();
}
