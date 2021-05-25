package com.avito.android.shared_providers;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\bf\u0018\u00002\u00020\u0001R\u0016\u0010\u0005\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0007\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0004R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0004¨\u0006\n"}, d2 = {"Lcom/avito/android/shared_providers/SupportEmailResourceProvider;", "", "", "getSupportEmailAddress", "()Ljava/lang/String;", "supportEmailAddress", "getSupportEmailText", "supportEmailText", "getUserEmail", "userEmail", "resource-providers_release"}, k = 1, mv = {1, 4, 2})
public interface SupportEmailResourceProvider {
    @NotNull
    String getSupportEmailAddress();

    @NotNull
    String getSupportEmailText();

    @Nullable
    String getUserEmail();
}
