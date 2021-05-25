package a2.a.a.b2.e1;

import com.avito.android.profile.edit.EditProfileInteractor;
import com.avito.android.profile.edit.refactoring.adapter.EditProfileItem;
import com.avito.android.profile.edit.refactoring.adapter.EditProfileItemsKt;
import com.avito.android.profile.edit.refactoring.adapter.item.SubLocationItem;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.TypeIntrinsics;
public final class m extends Lambda implements Function1<List<EditProfileItem>, Unit> {
    public final /* synthetic */ EditProfileInteractor.LocationItems a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public m(EditProfileInteractor.LocationItems locationItems) {
        super(1);
        this.a = locationItems;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(List<EditProfileItem> list) {
        List<EditProfileItem> list2 = list;
        Intrinsics.checkNotNullParameter(list2, "$receiver");
        EditProfileItem findItem = EditProfileItemsKt.findItem(list2, 2);
        EditProfileItemsKt.hideError(list2, EditProfileItemsKt.findItem(list2, 1));
        TypeIntrinsics.asMutableCollection(list2).remove(findItem);
        int replaceItem = EditProfileItemsKt.replaceItem(list2, this.a.getLocation());
        SubLocationItem subLocation = this.a.getSubLocation();
        if (subLocation != null) {
            list2.add(replaceItem + 1, subLocation);
        }
        return Unit.INSTANCE;
    }
}
