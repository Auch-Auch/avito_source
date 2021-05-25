package com.avito.android.profile_phones.add_phone;

import a2.a.a.c2.a.j;
import a2.a.a.c2.a.k;
import a2.a.a.c2.a.l;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.avito.android.profile_phones.add_phone.AddPhoneViewModel;
import com.avito.android.util.architecture_components.SingleLiveEvent;
import io.reactivex.rxjava3.disposables.Disposable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u001c\u001a\u00020\u0019¢\u0006\u0004\b!\u0010\"J\u000f\u0010\u0004\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0005J\u0017\u0010\t\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000bH\u0016¢\u0006\u0004\b\u0010\u0010\u000eR\u001c\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\f0\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010 \u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f¨\u0006#"}, d2 = {"Lcom/avito/android/profile_phones/add_phone/AddPhoneViewModelImpl;", "Landroidx/lifecycle/ViewModel;", "Lcom/avito/android/profile_phones/add_phone/AddPhoneViewModel;", "", "onCleared", "()V", "onCloseClicked", "", "phone", "onContinueClicked", "(Ljava/lang/String;)V", "Landroidx/lifecycle/LiveData;", "Lcom/avito/android/profile_phones/add_phone/AddPhoneViewModel$ScreenState;", "screenState", "()Landroidx/lifecycle/LiveData;", "Lcom/avito/android/profile_phones/add_phone/AddPhoneViewModel$RoutingAction;", "navigation", "Landroidx/lifecycle/MutableLiveData;", "d", "Landroidx/lifecycle/MutableLiveData;", "screenStateData", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "e", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "navigationData", "Lcom/avito/android/profile_phones/add_phone/AddPhoneInteractor;", "f", "Lcom/avito/android/profile_phones/add_phone/AddPhoneInteractor;", "interactor", "Lio/reactivex/rxjava3/disposables/Disposable;", "c", "Lio/reactivex/rxjava3/disposables/Disposable;", "disposable", "<init>", "(Lcom/avito/android/profile_phones/add_phone/AddPhoneInteractor;)V", "profile-phones_release"}, k = 1, mv = {1, 4, 2})
public final class AddPhoneViewModelImpl extends ViewModel implements AddPhoneViewModel {
    public Disposable c;
    public final MutableLiveData<AddPhoneViewModel.ScreenState> d = new MutableLiveData<>();
    public final SingleLiveEvent<AddPhoneViewModel.RoutingAction> e = new SingleLiveEvent<>();
    public final AddPhoneInteractor f;

    public AddPhoneViewModelImpl(@NotNull AddPhoneInteractor addPhoneInteractor) {
        Intrinsics.checkNotNullParameter(addPhoneInteractor, "interactor");
        this.f = addPhoneInteractor;
    }

    @Override // com.avito.android.profile_phones.add_phone.AddPhoneViewModel
    @NotNull
    public LiveData<AddPhoneViewModel.RoutingAction> navigation() {
        return this.e;
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        Disposable disposable = this.c;
        if (disposable != null) {
            disposable.dispose();
        }
    }

    @Override // com.avito.android.profile_phones.add_phone.AddPhoneViewModel
    public void onCloseClicked() {
        this.e.setValue(AddPhoneViewModel.RoutingAction.GoBack.INSTANCE);
    }

    @Override // com.avito.android.profile_phones.add_phone.AddPhoneViewModel
    public void onContinueClicked(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "phone");
        Disposable disposable = this.c;
        if (disposable != null) {
            disposable.dispose();
        }
        this.d.setValue(AddPhoneViewModel.ScreenState.Loading.INSTANCE);
        this.c = this.f.validatePhone(str).flatMap(new j(this, str)).subscribe(new k(this, str), new l(this));
    }

    @Override // com.avito.android.profile_phones.add_phone.AddPhoneViewModel
    @NotNull
    public LiveData<AddPhoneViewModel.ScreenState> screenState() {
        return this.d;
    }
}
