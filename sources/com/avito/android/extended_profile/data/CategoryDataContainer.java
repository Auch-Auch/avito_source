package com.avito.android.extended_profile.data;

import com.avito.android.remote.auth.AuthSource;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\t\u0010\nR\u001f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/avito/android/extended_profile/data/CategoryDataContainer;", "Lcom/avito/android/extended_profile/data/ExtendedProfileDataItem;", "", "Lcom/avito/android/extended_profile/data/CategoryData;", AuthSource.SEND_ABUSE, "Ljava/util/List;", "getCategories", "()Ljava/util/List;", "categories", "<init>", "(Ljava/util/List;)V", "extended-profile_release"}, k = 1, mv = {1, 4, 2})
public final class CategoryDataContainer implements ExtendedProfileDataItem {
    @NotNull
    public final List<CategoryData> a;

    public CategoryDataContainer() {
        this(null, 1, null);
    }

    public CategoryDataContainer(@NotNull List<CategoryData> list) {
        Intrinsics.checkNotNullParameter(list, "categories");
        this.a = list;
    }

    @NotNull
    public final List<CategoryData> getCategories() {
        return this.a;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CategoryDataContainer(List list, int i, j jVar) {
        this((i & 1) != 0 ? new ArrayList() : list);
    }
}
