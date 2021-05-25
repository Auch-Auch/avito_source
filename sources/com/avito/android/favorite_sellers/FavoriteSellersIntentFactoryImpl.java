package com.avito.android.favorite_sellers;

import android.content.Context;
import android.content.Intent;
import com.avito.android.FavoriteSellersIntentFactory;
import com.avito.android.remote.auth.AuthSource;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/avito/android/favorite_sellers/FavoriteSellersIntentFactoryImpl;", "Lcom/avito/android/FavoriteSellersIntentFactory;", "", "userKey", "Landroid/content/Intent;", "subscriptionsIntent", "(Ljava/lang/String;)Landroid/content/Intent;", "subscribersIntent", "Landroid/content/Context;", AuthSource.SEND_ABUSE, "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "favorite-sellers_release"}, k = 1, mv = {1, 4, 2})
public final class FavoriteSellersIntentFactoryImpl implements FavoriteSellersIntentFactory {
    public final Context a;

    @Inject
    public FavoriteSellersIntentFactoryImpl(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.a = context;
    }

    @Override // com.avito.android.FavoriteSellersIntentFactory
    @NotNull
    public Intent subscribersIntent(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "userKey");
        return FavoriteSellersActivityKt.createSubscribeListIntent(this.a, str);
    }

    @Override // com.avito.android.FavoriteSellersIntentFactory
    @NotNull
    public Intent subscriptionsIntent(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "userKey");
        return FavoriteSellersActivityKt.createSubscriptionListIntent(this.a, str);
    }
}
