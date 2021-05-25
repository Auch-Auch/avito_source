package com.avito.android.shop.detailed;

import android.content.res.Resources;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui_components.R;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u000f¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u000e\u001a\u00020\u00048\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\bR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0015\u001a\u00020\u00048\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0013\u0010\f\u001a\u0004\b\u0014\u0010\bR\u001c\u0010\u0018\u001a\u00020\u00048\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0016\u0010\f\u001a\u0004\b\u0017\u0010\b¨\u0006\u001b"}, d2 = {"Lcom/avito/android/shop/detailed/ShopAdvertsResourceProviderImpl;", "Lcom/avito/android/shop/detailed/ShopAdvertsResourceProvider;", "", "count", "", "getAdvertsCount", "(I)Ljava/lang/String;", "getNoAdverts", "()Ljava/lang/String;", "getColumnsCount", "()I", "c", "Ljava/lang/String;", "getSearchBarHint", "searchBarHint", "Landroid/content/res/Resources;", "d", "Landroid/content/res/Resources;", "resources", AuthSource.SEND_ABUSE, "getCantDoCallString", "cantDoCallString", AuthSource.BOOKING_ORDER, "getChangeQueryError", "changeQueryError", "<init>", "(Landroid/content/res/Resources;)V", "shop_release"}, k = 1, mv = {1, 4, 2})
public final class ShopAdvertsResourceProviderImpl implements ShopAdvertsResourceProvider {
    @NotNull
    public final String a;
    @NotNull
    public final String b;
    @NotNull
    public final String c;
    public final Resources d;

    @Inject
    public ShopAdvertsResourceProviderImpl(@NotNull Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        this.d = resources;
        String string = resources.getString(R.string.cant_do_call);
        String str = "";
        this.a = string == null ? str : string;
        String string2 = resources.getString(com.avito.android.shop.R.string.change_query);
        this.b = string2 == null ? str : string2;
        String string3 = resources.getString(com.avito.android.shop.R.string.shops_search_bar_hint);
        this.c = string3 != null ? string3 : str;
    }

    @Override // com.avito.android.shop.detailed.ShopAdvertsResourceProvider
    @NotNull
    public String getAdvertsCount(int i) {
        String quantityString = this.d.getQuantityString(com.avito.android.shop.R.plurals.adverts, i, Integer.valueOf(i));
        Intrinsics.checkNotNullExpressionValue(quantityString, "resources.getQuantityStr…ls.adverts, count, count)");
        return quantityString;
    }

    @Override // com.avito.android.shop.detailed.ShopAdvertsResourceProvider
    @NotNull
    public String getCantDoCallString() {
        return this.a;
    }

    @Override // com.avito.android.shop.detailed.ShopAdvertsResourceProvider
    @NotNull
    public String getChangeQueryError() {
        return this.b;
    }

    @Override // com.avito.android.shop.detailed.ShopAdvertsResourceProvider
    public int getColumnsCount() {
        return this.d.getInteger(R.integer.serp_columns);
    }

    @Override // com.avito.android.shop.detailed.ShopAdvertsResourceProvider
    @NotNull
    public String getNoAdverts() {
        String string = this.d.getString(com.avito.android.shop.R.string.no_adverts);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.string.no_adverts)");
        return string;
    }

    @Override // com.avito.android.shop.detailed.ShopAdvertsResourceProvider
    @NotNull
    public String getSearchBarHint() {
        return this.c;
    }
}
