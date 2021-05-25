package com.avito.android.extended_profile.adapter.category.category_header;

import com.avito.android.extended_profile.adapter.action.ExtendedProfileItemAction;
import com.avito.android.extended_profile.data.CategoryData;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/extended_profile/adapter/category/category_header/CategoryHeaderAction;", "Lcom/avito/android/extended_profile/adapter/action/ExtendedProfileItemAction;", "Lcom/avito/android/extended_profile/data/CategoryData;", AuthSource.SEND_ABUSE, "Lcom/avito/android/extended_profile/data/CategoryData;", "getCategory", "()Lcom/avito/android/extended_profile/data/CategoryData;", "category", "<init>", "(Lcom/avito/android/extended_profile/data/CategoryData;)V", "extended-profile_release"}, k = 1, mv = {1, 4, 2})
public final class CategoryHeaderAction implements ExtendedProfileItemAction {
    @NotNull
    public final CategoryData a;

    public CategoryHeaderAction(@NotNull CategoryData categoryData) {
        Intrinsics.checkNotNullParameter(categoryData, "category");
        this.a = categoryData;
    }

    @NotNull
    public final CategoryData getCategory() {
        return this.a;
    }
}
