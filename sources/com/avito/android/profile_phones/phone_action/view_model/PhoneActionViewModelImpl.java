package com.avito.android.profile_phones.phone_action.view_model;

import a2.g.r.g;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.avito.android.profile_phones.phone_action.interactor.PhoneActionInteractor;
import com.avito.android.profile_phones.phone_action.resource_providers.PhoneActionResourceProvider;
import com.avito.android.profile_phones.phone_action.view_model.PhoneActionViewModel;
import com.avito.android.profile_phones.phones_list.list_item.PhoneActionCode;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.ParcelableEntity;
import com.avito.android.util.Logs;
import com.avito.android.util.architecture_components.SingleLiveEvent;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.kotlin.DisposableKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002BC\u0012\u0006\u0010B\u001a\u00020\r\u0012\u0006\u0010;\u001a\u000208\u0012\u0012\u0010$\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00150\u0014\u0012\u0006\u0010(\u001a\u00020%\u0012\u0006\u0010?\u001a\u00020<\u0012\u0006\u0010D\u001a\u00020C¢\u0006\u0004\bE\u0010FJ\u0015\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0003H\u0016¢\u0006\u0004\b\b\u0010\u0006J\u0015\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u0003H\u0016¢\u0006\u0004\b\n\u0010\u0006J\u0015\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0003H\u0016¢\u0006\u0004\b\f\u0010\u0006J\u0015\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u0003H\u0016¢\u0006\u0004\b\u000e\u0010\u0006J\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0013\u0010\u0011J#\u0010\u0017\u001a\u00020\u000f2\u0012\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00150\u0014H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u000fH\u0014¢\u0006\u0004\b\u0019\u0010\u0011J#\u0010\u001c\u001a\u00020\u000f2\b\u0010\u001a\u001a\u0004\u0018\u00010\r2\b\u0010\u001b\u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u001e\u0010\u0011R\u001c\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00070\u001f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010 R\"\u0010$\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00150\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u001e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u00158\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010-R\u001c\u00101\u001a\b\u0012\u0004\u0012\u00020\u00040.8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u001c\u00103\u001a\b\u0012\u0004\u0012\u00020\r0.8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b2\u00100R\u001c\u00105\u001a\b\u0012\u0004\u0012\u00020\t0\u001f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b4\u0010 R\u001c\u00107\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b6\u0010 R\u0016\u0010;\u001a\u0002088\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010?\u001a\u00020<8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010B\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b@\u0010A¨\u0006G"}, d2 = {"Lcom/avito/android/profile_phones/phone_action/view_model/PhoneActionViewModelImpl;", "Landroidx/lifecycle/ViewModel;", "Lcom/avito/android/profile_phones/phone_action/view_model/PhoneActionViewModel;", "Landroidx/lifecycle/LiveData;", "Lcom/avito/android/profile_phones/phone_action/view_model/PhoneActionViewModel$Navigation;", "navigation", "()Landroidx/lifecycle/LiveData;", "Lcom/avito/android/profile_phones/phone_action/view_model/PhoneActionViewModel$ScreenState;", "screenState", "Lcom/avito/android/profile_phones/phone_action/view_model/PhoneActionViewModel$PhoneInputState;", "phoneInputState", "Lcom/avito/android/profile_phones/phone_action/view_model/PhoneActionViewModel$PhonesList;", "phonesListState", "", "errors", "", "onSubmitButtonClick", "()V", "onCloseButtonClick", "onInputClick", "", "Lcom/avito/android/remote/model/ParcelableEntity;", "phones", "onSelected", "(Ljava/util/List;)V", "onCleared", "selectedPhone", "error", "d", "(Ljava/lang/String;Ljava/lang/String;)V", "c", "Landroidx/lifecycle/MutableLiveData;", "Landroidx/lifecycle/MutableLiveData;", "screenStateData", "l", "Ljava/util/List;", "phonesForReplacement", "Lcom/avito/android/profile_phones/phone_action/resource_providers/PhoneActionResourceProvider;", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/android/profile_phones/phone_action/resource_providers/PhoneActionResourceProvider;", "resourceProvider", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "i", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "disposables", "Lcom/avito/android/remote/model/ParcelableEntity;", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "e", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "navigationData", "f", "errorsData", g.a, "phoneInputStateData", "h", "phoneListStateData", "", "k", "I", "advertsCount", "Lcom/avito/android/profile_phones/phone_action/interactor/PhoneActionInteractor;", "n", "Lcom/avito/android/profile_phones/phone_action/interactor/PhoneActionInteractor;", "interactor", "j", "Ljava/lang/String;", "phone", "Lcom/avito/android/profile_phones/phones_list/list_item/PhoneActionCode;", "phoneAction", "<init>", "(Ljava/lang/String;ILjava/util/List;Lcom/avito/android/profile_phones/phone_action/resource_providers/PhoneActionResourceProvider;Lcom/avito/android/profile_phones/phone_action/interactor/PhoneActionInteractor;Lcom/avito/android/profile_phones/phones_list/list_item/PhoneActionCode;)V", "profile-phones_release"}, k = 1, mv = {1, 4, 2})
public final class PhoneActionViewModelImpl extends ViewModel implements PhoneActionViewModel {
    public ParcelableEntity<String> c;
    public final MutableLiveData<PhoneActionViewModel.ScreenState> d = new MutableLiveData<>();
    public final SingleLiveEvent<PhoneActionViewModel.Navigation> e = new SingleLiveEvent<>();
    public final SingleLiveEvent<String> f = new SingleLiveEvent<>();
    public final MutableLiveData<PhoneActionViewModel.PhoneInputState> g;
    public final MutableLiveData<PhoneActionViewModel.PhonesList> h;
    public final CompositeDisposable i;
    public final String j;
    public final int k;
    public final List<ParcelableEntity<String>> l;
    public final PhoneActionResourceProvider m;
    public final PhoneActionInteractor n;

    public static final class a<T> implements Consumer<Disposable> {
        public final /* synthetic */ PhoneActionViewModelImpl a;

        public a(PhoneActionViewModelImpl phoneActionViewModelImpl) {
            this.a = phoneActionViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r2v3, resolved type: androidx.lifecycle.MutableLiveData */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Disposable disposable) {
            this.a.d.postValue(PhoneActionViewModel.ScreenState.Loading.INSTANCE);
        }
    }

    public static final class b<T> implements Consumer<Unit> {
        public final /* synthetic */ PhoneActionViewModelImpl a;
        public final /* synthetic */ String b;

        public b(PhoneActionViewModelImpl phoneActionViewModelImpl, String str) {
            this.a = phoneActionViewModelImpl;
            this.b = str;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r4v3, resolved type: com.avito.android.util.architecture_components.SingleLiveEvent */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Unit unit) {
            this.a.e.postValue(new PhoneActionViewModel.Navigation.FinishWithSuccess(this.a.m.actionSuccessMessage(this.b)));
        }
    }

    public static final class c<T> implements Consumer<Throwable> {
        public final /* synthetic */ PhoneActionViewModelImpl a;

        public c(PhoneActionViewModelImpl phoneActionViewModelImpl) {
            this.a = phoneActionViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: com.avito.android.util.architecture_components.SingleLiveEvent */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            this.a.c();
            this.a.f.postValue(this.a.m.getActionErrorMessage());
            Logs.error("Failed to remove phone", th);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.util.List<? extends com.avito.android.remote.model.ParcelableEntity<java.lang.String>> */
    /* JADX WARN: Multi-variable type inference failed */
    public PhoneActionViewModelImpl(@NotNull String str, int i2, @NotNull List<? extends ParcelableEntity<String>> list, @NotNull PhoneActionResourceProvider phoneActionResourceProvider, @NotNull PhoneActionInteractor phoneActionInteractor, @NotNull PhoneActionCode phoneActionCode) {
        Intrinsics.checkNotNullParameter(str, "phone");
        Intrinsics.checkNotNullParameter(list, "phonesForReplacement");
        Intrinsics.checkNotNullParameter(phoneActionResourceProvider, "resourceProvider");
        Intrinsics.checkNotNullParameter(phoneActionInteractor, "interactor");
        Intrinsics.checkNotNullParameter(phoneActionCode, "phoneAction");
        this.j = str;
        this.k = i2;
        this.l = list;
        this.m = phoneActionResourceProvider;
        this.n = phoneActionInteractor;
        MutableLiveData<PhoneActionViewModel.PhoneInputState> mutableLiveData = new MutableLiveData<>();
        this.g = mutableLiveData;
        this.h = new MutableLiveData<>();
        this.i = new CompositeDisposable();
        c();
        if (phoneActionCode == PhoneActionCode.SET_FOR_ALL || i2 == 0) {
            mutableLiveData.postValue(PhoneActionViewModel.PhoneInputState.NoInput.INSTANCE);
        } else {
            d(null, null);
        }
    }

    public final void c() {
        this.d.postValue(new PhoneActionViewModel.ScreenState.Initial(this.m.getHeader(), this.m.getDescription(), this.m.getSubmitButtonText()));
    }

    public final void d(String str, String str2) {
        this.g.postValue(new PhoneActionViewModel.PhoneInputState.Input(this.m.getInputPlaceholder(), this.m.getInputMotivation(), str, str2));
    }

    @Override // com.avito.android.profile_phones.phone_action.view_model.PhoneActionViewModel
    @NotNull
    public LiveData<String> errors() {
        return this.f;
    }

    @Override // com.avito.android.profile_phones.phone_action.view_model.PhoneActionViewModel
    @NotNull
    public LiveData<PhoneActionViewModel.Navigation> navigation() {
        return this.e;
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        this.i.clear();
    }

    @Override // com.avito.android.profile_phones.phone_action.view_model.PhoneActionViewModel
    public void onCloseButtonClick() {
        this.e.postValue(PhoneActionViewModel.Navigation.FinishWithCancel.INSTANCE);
    }

    @Override // com.avito.android.profile_phones.phone_action.view_model.PhoneActionViewModel
    public void onInputClick() {
        this.h.postValue(new PhoneActionViewModel.PhonesList(this.m.getSelectSheetTitle(), this.l, this.c));
    }

    @Override // com.avito.android.profile_phones.phone_action.view_model.PhoneActionViewModel
    public void onSelected(@NotNull List<? extends ParcelableEntity<String>> list) {
        Intrinsics.checkNotNullParameter(list, "phones");
        if (!list.isEmpty()) {
            ParcelableEntity<String> parcelableEntity = (ParcelableEntity) list.get(0);
            this.c = parcelableEntity;
            Intrinsics.checkNotNull(parcelableEntity);
            d(parcelableEntity.getName(), null);
        }
    }

    @Override // com.avito.android.profile_phones.phone_action.view_model.PhoneActionViewModel
    public void onSubmitButtonClick() {
        ParcelableEntity<String> parcelableEntity = this.c;
        String name = parcelableEntity != null ? parcelableEntity.getName() : null;
        if (name != null || this.k <= 0) {
            CompositeDisposable compositeDisposable = this.i;
            Disposable subscribe = this.n.performAction(this.j, name).doOnSubscribe(new a(this)).subscribe(new b(this, name), new c(this));
            Intrinsics.checkNotNullExpressionValue(subscribe, "interactor.performAction…t)\n                    })");
            DisposableKt.plusAssign(compositeDisposable, subscribe);
            return;
        }
        d(null, this.m.getInputEmptyErrorMessage());
    }

    @Override // com.avito.android.profile_phones.phone_action.view_model.PhoneActionViewModel
    @NotNull
    public LiveData<PhoneActionViewModel.PhoneInputState> phoneInputState() {
        return this.g;
    }

    @Override // com.avito.android.profile_phones.phone_action.view_model.PhoneActionViewModel
    @NotNull
    public LiveData<PhoneActionViewModel.PhonesList> phonesListState() {
        return this.h;
    }

    @Override // com.avito.android.profile_phones.phone_action.view_model.PhoneActionViewModel
    @NotNull
    public LiveData<PhoneActionViewModel.ScreenState> screenState() {
        return this.d;
    }
}
