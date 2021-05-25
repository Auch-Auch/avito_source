package com.avito.android.favorites;

import android.content.res.Resources;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui_components.R;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/avito/android/favorites/FavoriteAdvertItemConverterResourceProviderImpl;", "Lcom/avito/android/favorites/FavoriteAdvertItemConverterResourceProvider;", "", "getMetroPrefix", "()Ljava/lang/String;", "getDistrictSuffix", "Landroid/content/res/Resources;", AuthSource.SEND_ABUSE, "Landroid/content/res/Resources;", "resources", "<init>", "(Landroid/content/res/Resources;)V", "favorite-core_release"}, k = 1, mv = {1, 4, 2})
public final class FavoriteAdvertItemConverterResourceProviderImpl implements FavoriteAdvertItemConverterResourceProvider {
    public final Resources a;

    @Inject
    public FavoriteAdvertItemConverterResourceProviderImpl(@NotNull Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        this.a = resources;
    }

    @Override // com.avito.android.favorites.FavoriteAdvertItemConverterResourceProvider
    @NotNull
    public String getDistrictSuffix() {
        String string = this.a.getString(R.string.district_suffix);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(ui_R.string.district_suffix)");
        return string;
    }

    @Override // com.avito.android.favorites.FavoriteAdvertItemConverterResourceProvider
    @NotNull
    public String getMetroPrefix() {
        String string = this.a.getString(R.string.metro_prefix);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(ui_R.string.metro_prefix)");
        return string;
    }
}
