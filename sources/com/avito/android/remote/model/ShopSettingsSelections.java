package com.avito.android.remote.model;

import com.avito.android.publish.residential_complex_search.di.ResidentialComplexModuleKt;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\r\u0010\u000eR\u001c\u0010\u0003\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/avito/android/remote/model/ShopSettingsSelections;", "", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "", "Lcom/avito/android/remote/model/ShopSettingsSelection;", ResidentialComplexModuleKt.VALUES, "Ljava/util/List;", "getValues", "()Ljava/util/List;", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "shop-settings_release"}, k = 1, mv = {1, 4, 2})
public final class ShopSettingsSelections {
    @SerializedName("title")
    @NotNull
    private final String title;
    @SerializedName(ResidentialComplexModuleKt.VALUES)
    @NotNull
    private final List<ShopSettingsSelection> values;

    public ShopSettingsSelections(@NotNull String str, @NotNull List<ShopSettingsSelection> list) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(list, ResidentialComplexModuleKt.VALUES);
        this.title = str;
        this.values = list;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    public final List<ShopSettingsSelection> getValues() {
        return this.values;
    }
}
