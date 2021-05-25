package com.avito.android.extended_profile;

import android.content.res.Resources;
import com.avito.android.favorite.FavoriteAdvertsResourceProvider;
import com.avito.android.favorite.FavoriteAdvertsResourceProviderImpl;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0004\u001a\u00020\u0003H\u0001¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\n"}, d2 = {"Lcom/avito/android/extended_profile/ExtendedProfileResourceProviderImpl;", "Lcom/avito/android/extended_profile/ExtendedProfileResourceProvider;", "Lcom/avito/android/favorite/FavoriteAdvertsResourceProvider;", "", "getFavoritesFullError", "()Ljava/lang/String;", "Landroid/content/res/Resources;", "resources", "<init>", "(Landroid/content/res/Resources;)V", "extended-profile_release"}, k = 1, mv = {1, 4, 2})
public final class ExtendedProfileResourceProviderImpl implements ExtendedProfileResourceProvider, FavoriteAdvertsResourceProvider {
    public final /* synthetic */ FavoriteAdvertsResourceProviderImpl a;

    @Inject
    public ExtendedProfileResourceProviderImpl(@NotNull Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        this.a = new FavoriteAdvertsResourceProviderImpl(resources);
    }

    @Override // com.avito.android.favorite.FavoriteAdvertsResourceProvider
    @NotNull
    public String getFavoritesFullError() {
        return this.a.getFavoritesFullError();
    }
}
