package com.avito.android.deep_linking;

import android.content.Intent;
import com.avito.android.deep_linking.links.DeepLink;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "", "Lcom/avito/android/deep_linking/links/DeepLink;", "link", "Landroid/content/Intent;", "getIntent", "(Lcom/avito/android/deep_linking/links/DeepLink;)Landroid/content/Intent;", "core_release"}, k = 1, mv = {1, 4, 2})
public interface DeepLinkIntentFactory {
    @Nullable
    Intent getIntent(@NotNull DeepLink deepLink);
}
