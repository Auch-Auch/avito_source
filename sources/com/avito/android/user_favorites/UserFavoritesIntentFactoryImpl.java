package com.avito.android.user_favorites;

import android.content.Intent;
import com.avito.android.CoreActivityIntentFactory;
import com.avito.android.UserFavoritesIntentFactory;
import com.avito.android.remote.auth.AuthSource;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\f\u001a\u00020\t¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/avito/android/user_favorites/UserFavoritesIntentFactoryImpl;", "Lcom/avito/android/UserFavoritesIntentFactory;", "", "subscriptionId", "Landroid/content/Intent;", "savedSearchesIntent", "(Ljava/lang/String;)Landroid/content/Intent;", "favoritesIntent", "()Landroid/content/Intent;", "Lcom/avito/android/CoreActivityIntentFactory;", AuthSource.SEND_ABUSE, "Lcom/avito/android/CoreActivityIntentFactory;", "coreActivityIntentFactory", "<init>", "(Lcom/avito/android/CoreActivityIntentFactory;)V", "user-favorites_release"}, k = 1, mv = {1, 4, 2})
public final class UserFavoritesIntentFactoryImpl implements UserFavoritesIntentFactory {
    public final CoreActivityIntentFactory a;

    @Inject
    public UserFavoritesIntentFactoryImpl(@NotNull CoreActivityIntentFactory coreActivityIntentFactory) {
        Intrinsics.checkNotNullParameter(coreActivityIntentFactory, "coreActivityIntentFactory");
        this.a = coreActivityIntentFactory;
    }

    @Override // com.avito.android.UserFavoritesIntentFactory
    @NotNull
    public Intent favoritesIntent() {
        return this.a.mainScreenWithTab(UserFavoritesFragmentData.Companion.forAdvertTab());
    }

    @Override // com.avito.android.UserFavoritesIntentFactory
    @NotNull
    public Intent savedSearchesIntent(@Nullable String str) {
        return this.a.mainScreenWithTab(UserFavoritesFragmentData.Companion.forSavedSearchTab(str));
    }
}
