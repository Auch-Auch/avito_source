package com.avito.android.publish;

import com.avito.android.publish.slots.contact_info.ContactsData;
import com.avito.android.util.LoadingState;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J1\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00070\u00062\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\b\u0010\tR\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u00038&@&X¦\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u000f"}, d2 = {"Lcom/avito/android/publish/ContactsDataSource;", "", "Lkotlin/Function1;", "Lcom/avito/android/publish/slots/contact_info/ContactsData;", "", "contactsDataChange", "Lio/reactivex/Observable;", "Lcom/avito/android/util/LoadingState;", "prepareContactsData", "(Lkotlin/jvm/functions/Function1;)Lio/reactivex/Observable;", "getContactsData", "()Lcom/avito/android/publish/slots/contact_info/ContactsData;", "setContactsData", "(Lcom/avito/android/publish/slots/contact_info/ContactsData;)V", "contactsData", "publish_release"}, k = 1, mv = {1, 4, 2})
public interface ContactsDataSource {
    @Nullable
    ContactsData getContactsData();

    @NotNull
    Observable<LoadingState<Unit>> prepareContactsData(@Nullable Function1<? super ContactsData, Unit> function1);

    void setContactsData(@Nullable ContactsData contactsData);
}
