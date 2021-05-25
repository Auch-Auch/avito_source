package com.avito.android.favorite_sellers;

import android.content.res.Resources;
import com.avito.android.remote.auth.AuthSource;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0004R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/avito/android/favorite_sellers/FavoriteSellersResourceProviderImpl;", "Lcom/avito/android/favorite_sellers/FavoriteSellersResourceProvider;", "", "notificationsEnabled", "()Ljava/lang/String;", "notificationsDisabled", "loadingErrorText", "Landroid/content/res/Resources;", AuthSource.SEND_ABUSE, "Landroid/content/res/Resources;", "resources", "<init>", "(Landroid/content/res/Resources;)V", "favorite-sellers_release"}, k = 1, mv = {1, 4, 2})
public final class FavoriteSellersResourceProviderImpl implements FavoriteSellersResourceProvider {
    public final Resources a;

    @Inject
    public FavoriteSellersResourceProviderImpl(@NotNull Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        this.a = resources;
    }

    @Override // com.avito.android.favorite_sellers.FavoriteSellersResourceProvider
    @NotNull
    public String loadingErrorText() {
        String string = this.a.getString(R.string.favorite_sellers_loading_error);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st…te_sellers_loading_error)");
        return string;
    }

    @Override // com.avito.android.favorite_sellers.FavoriteSellersResourceProvider
    @NotNull
    public String notificationsDisabled() {
        String string = this.a.getString(R.string.favorite_sellers_notifications_disabled);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st…s_notifications_disabled)");
        return string;
    }

    @Override // com.avito.android.favorite_sellers.FavoriteSellersResourceProvider
    @NotNull
    public String notificationsEnabled() {
        String string = this.a.getString(R.string.favorite_sellers_notifications_enabled);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st…rs_notifications_enabled)");
        return string;
    }
}
