package com.avito.android;

import android.content.Intent;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.DeepLinkContainer;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/avito/android/DeepLinkingIntentFactory;", "", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "Landroid/content/Intent;", "appShortcutsDeepLinkIntent", "(Lcom/avito/android/deep_linking/links/DeepLink;)Landroid/content/Intent;", "Lcom/avito/android/deep_linking/links/DeepLinkContainer;", "container", "containerDeeplinkIntent", "(Lcom/avito/android/deep_linking/links/DeepLinkContainer;)Landroid/content/Intent;", "core_release"}, k = 1, mv = {1, 4, 2})
public interface DeepLinkingIntentFactory {
    @NotNull
    Intent appShortcutsDeepLinkIntent(@NotNull DeepLink deepLink);

    @NotNull
    Intent containerDeeplinkIntent(@NotNull DeepLinkContainer deepLinkContainer);
}
