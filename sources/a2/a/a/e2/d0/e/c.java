package a2.a.a.e2.d0.e;

import com.avito.android.publish.ContactsDataSource;
import com.avito.android.publish.ProfileSourceInteractor;
import com.avito.android.publish.slots.contact_info.ContactInfoSlotWrapper;
import com.avito.android.remote.model.Profile;
import io.reactivex.rxjava3.functions.Function;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
public final class c<T, R> implements Function<Profile, Unit> {
    public final /* synthetic */ d a;

    public c(d dVar) {
        this.a = dVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public Unit apply(Profile profile) {
        Profile profile2 = profile;
        ProfileSourceInteractor profileSourceInteractor = this.a.a.d;
        Intrinsics.checkNotNullExpressionValue(profile2, "profile");
        profileSourceInteractor.notifyProfileChanged(profile2);
        ContactsDataSource contactsDataSource = this.a.a.e;
        ContactInfoSlotWrapper contactInfoSlotWrapper = this.a.a;
        contactsDataSource.setContactsData(ContactInfoSlotWrapper.access$buildContactsData(contactInfoSlotWrapper, profile2, contactInfoSlotWrapper.getSlot().getValue()));
        return Unit.INSTANCE;
    }
}
