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
public final class a extends Lambda implements Function0<Unit> {
    public final /* synthetic */ UserContactsPresenterImpl a;
    public final /* synthetic */ String b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(UserContactsPresenterImpl userContactsPresenterImpl, String str) {
        super(0);
        this.a = userContactsPresenterImpl;
        this.b = str;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        UserContactsPresenterImpl userContactsPresenterImpl = this.a;
        List list = userContactsPresenterImpl.b;
        List list2 = null;
        if (list != null) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : list) {
                RatingDetailsItem ratingDetailsItem = (RatingDetailsItem) obj;
                if (!(ratingDetailsItem instanceof ContactItem)) {
                    ratingDetailsItem = null;
                }
                ContactItem contactItem = (ContactItem) ratingDetailsItem;
                boolean z = true;
                if (contactItem != null) {
                    z = true ^ Intrinsics.areEqual(contactItem.getUserKey(), this.b);
                }
                if (z) {
                    arrayList.add(obj);
                }
            }
            list2 = UserContactsPresenterImpl.access$filterAloneInfoItems(this.a, arrayList);
        }
        userContactsPresenterImpl.b = list2;
        return Unit.INSTANCE;
    }
}
