package a2.a.a.b2.e1;

import com.avito.android.profile.edit.refactoring.adapter.EditProfileItem;
import com.avito.android.profile.edit.refactoring.adapter.EditProfileItemsKt;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
public final class i extends Lambda implements Function1<List<EditProfileItem>, Unit> {
    public final /* synthetic */ EditProfileItem a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public i(EditProfileItem editProfileItem) {
        super(1);
        this.a = editProfileItem;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(List<EditProfileItem> list) {
        List<EditProfileItem> list2 = list;
        Intrinsics.checkNotNullParameter(list2, "$receiver");
        EditProfileItemsKt.removeErrorForItem(list2, this.a);
        return Unit.INSTANCE;
    }
}
