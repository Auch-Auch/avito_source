package a2.a.a.b2.e1;

import com.avito.android.profile.edit.refactoring.adapter.EditProfileItem;
import com.avito.android.profile.edit.refactoring.adapter.EditProfileItemsKt;
import com.avito.android.profile.edit.refactoring.adapter.item.AvatarItem;
import io.reactivex.functions.Function;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
public final class c<T, R> implements Function<List<? extends EditProfileItem>, List<? extends EditProfileItem>> {
    public final /* synthetic */ AvatarItem a;

    public c(AvatarItem avatarItem) {
        this.a = avatarItem;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public List<? extends EditProfileItem> apply(List<? extends EditProfileItem> list) {
        List<? extends EditProfileItem> list2 = list;
        Intrinsics.checkNotNullParameter(list2, "items");
        if (this.a == null) {
            return list2;
        }
        List<? extends EditProfileItem> mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) list2);
        EditProfileItemsKt.replaceItem(mutableList, this.a);
        return mutableList != null ? mutableList : list2;
    }
}
