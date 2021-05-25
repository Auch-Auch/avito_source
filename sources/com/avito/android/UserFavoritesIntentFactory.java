package com.avito.android;

import android.content.Intent;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u001b\u0010\u0007\u001a\u00020\u00022\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/avito/android/UserFavoritesIntentFactory;", "", "Landroid/content/Intent;", "favoritesIntent", "()Landroid/content/Intent;", "", "subscriptionId", "savedSearchesIntent", "(Ljava/lang/String;)Landroid/content/Intent;", "core_release"}, k = 1, mv = {1, 4, 2})
public interface UserFavoritesIntentFactory {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ Intent savedSearchesIntent$default(UserFavoritesIntentFactory userFavoritesIntentFactory, String str, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    str = null;
                }
                return userFavoritesIntentFactory.savedSearchesIntent(str);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: savedSearchesIntent");
        }
    }

    @NotNull
    Intent favoritesIntent();

    @NotNull
    Intent savedSearchesIntent(@Nullable String str);
}
