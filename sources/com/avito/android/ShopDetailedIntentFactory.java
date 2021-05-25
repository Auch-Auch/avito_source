package com.avito.android;

import android.content.Intent;
import com.avito.android.remote.model.SearchParams;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J3\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/avito/android/ShopDetailedIntentFactory;", "", "", "shopId", "pageFrom", "shopContext", "Lcom/avito/android/remote/model/SearchParams;", "searchParams", "Landroid/content/Intent;", "shopDetailedIntent", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/SearchParams;)Landroid/content/Intent;", "core_release"}, k = 1, mv = {1, 4, 2})
public interface ShopDetailedIntentFactory {
    @NotNull
    Intent shopDetailedIntent(@NotNull String str, @Nullable String str2, @Nullable String str3, @NotNull SearchParams searchParams);
}
