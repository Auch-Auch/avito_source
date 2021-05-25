package com.avito.android.shop.detailed;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0002H&¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\f\u001a\u00020\u00048&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\bR\u0016\u0010\u000e\u001a\u00020\u00048&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\bR\u0016\u0010\u0010\u001a\u00020\u00048&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\b¨\u0006\u0011"}, d2 = {"Lcom/avito/android/shop/detailed/ShopAdvertsResourceProvider;", "", "", "count", "", "getAdvertsCount", "(I)Ljava/lang/String;", "getNoAdverts", "()Ljava/lang/String;", "getColumnsCount", "()I", "getSearchBarHint", "searchBarHint", "getCantDoCallString", "cantDoCallString", "getChangeQueryError", "changeQueryError", "shop_release"}, k = 1, mv = {1, 4, 2})
public interface ShopAdvertsResourceProvider {
    @NotNull
    String getAdvertsCount(int i);

    @NotNull
    String getCantDoCallString();

    @NotNull
    String getChangeQueryError();

    int getColumnsCount();

    @NotNull
    String getNoAdverts();

    @NotNull
    String getSearchBarHint();
}
