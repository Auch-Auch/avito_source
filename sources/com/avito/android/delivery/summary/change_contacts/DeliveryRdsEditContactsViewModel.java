package com.avito.android.delivery.summary.change_contacts;

import androidx.lifecycle.LiveData;
import com.avito.android.category_parameters.ParameterElement;
import com.avito.android.delivery.summary.ChangeAction;
import com.avito.android.remote.model.delivery.DeliverySummaryRds;
import com.avito.konveyor.adapter.AdapterPresenter;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\nR(\u0010\u0011\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f0\u000b8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00120\u000b8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0010R\u001c\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00040\u00158&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00190\u00158&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0017¨\u0006\u001c"}, d2 = {"Lcom/avito/android/delivery/summary/change_contacts/DeliveryRdsEditContactsViewModel;", "", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "", "setAdapterPresenter", "(Lcom/avito/konveyor/adapter/AdapterPresenter;)V", "Lcom/avito/android/remote/model/delivery/DeliverySummaryRds$ContactsGroup;", "contactsGroup", "loadFields", "(Lcom/avito/android/remote/model/delivery/DeliverySummaryRds$ContactsGroup;)V", "Landroidx/lifecycle/LiveData;", "Lkotlin/Pair;", "", "", "getSnackBarErrorChanges", "()Landroidx/lifecycle/LiveData;", "snackBarErrorChanges", "Lcom/avito/android/delivery/summary/ChangeAction$EditContacts;", "getSaveChanges", "saveChanges", "Lio/reactivex/rxjava3/functions/Consumer;", "getSubmitButtonClickConsumer", "()Lio/reactivex/rxjava3/functions/Consumer;", "submitButtonClickConsumer", "Lcom/avito/android/category_parameters/ParameterElement$Input;", "getChangeConsumer", "changeConsumer", "delivery_release"}, k = 1, mv = {1, 4, 2})
public interface DeliveryRdsEditContactsViewModel {
    @NotNull
    Consumer<ParameterElement.Input> getChangeConsumer();

    @NotNull
    LiveData<ChangeAction.EditContacts> getSaveChanges();

    @NotNull
    LiveData<Pair<String, Boolean>> getSnackBarErrorChanges();

    @NotNull
    Consumer<Unit> getSubmitButtonClickConsumer();

    void loadFields(@NotNull DeliverySummaryRds.ContactsGroup contactsGroup);

    void setAdapterPresenter(@NotNull AdapterPresenter adapterPresenter);
}
