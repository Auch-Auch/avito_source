package a2.a.a.e2.d0.d;

import com.avito.android.publish.ContactsDataSource;
import com.avito.android.publish.slots.anonymous_number.AnonymousNumberSlotWrapper;
import com.avito.android.publish.slots.contact_info.ContactsData;
import com.avito.android.remote.model.PublishAnonymousNumber;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.util.LoadingState;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.functions.Function;
import kotlin.Unit;
public final class c<T, R> implements Function<LoadingState<? super Unit>, ObservableSource<? extends TypedResult<PublishAnonymousNumber>>> {
    public final /* synthetic */ AnonymousNumberSlotWrapper a;
    public final /* synthetic */ ContactsDataSource b;

    public c(AnonymousNumberSlotWrapper anonymousNumberSlotWrapper, ContactsDataSource contactsDataSource) {
        this.a = anonymousNumberSlotWrapper;
        this.b = contactsDataSource;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public ObservableSource<? extends TypedResult<PublishAnonymousNumber>> apply(LoadingState<? super Unit> loadingState) {
        if (!(loadingState instanceof LoadingState.Loaded)) {
            return Observable.empty();
        }
        AnonymousNumberSlotWrapper anonymousNumberSlotWrapper = this.a;
        ContactsData contactsData = this.b.getContactsData();
        return anonymousNumberSlotWrapper.b(contactsData != null ? contactsData.getPhone() : null);
    }
}
