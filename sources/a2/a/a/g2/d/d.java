package a2.a.a.g2.d;

import com.avito.android.rating.details.adapter.RatingDetailsItem;
import com.avito.android.rating.user_contacts.UserContactsPresenterImpl;
import com.avito.android.rating.user_contacts.adapter.contact.ContactItem;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
public final class d extends Lambda implements Function0<Unit> {
    public final /* synthetic */ UserContactsPresenterImpl a;
    public final /* synthetic */ ContactItem b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(UserContactsPresenterImpl userContactsPresenterImpl, ContactItem contactItem) {
        super(0);
        this.a = userContactsPresenterImpl;
        this.b = contactItem;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        List list;
        UserContactsPresenterImpl userContactsPresenterImpl = this.a;
        List list2 = userContactsPresenterImpl.b;
        if (list2 != null) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : list2) {
                if (!Intrinsics.areEqual(((RatingDetailsItem) obj).getStringId(), this.b.getStringId())) {
                    arrayList.add(obj);
                }
            }
            List list3 = this.a.e(arrayList);
            if (list3 != null) {
                list = UserContactsPresenterImpl.access$filterAloneInfoItems(this.a, list3);
                userContactsPresenterImpl.b = list;
                return Unit.INSTANCE;
            }
        }
        list = null;
        userContactsPresenterImpl.b = list;
        return Unit.INSTANCE;
    }
}
