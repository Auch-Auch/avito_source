package com.avito.android.profile_phones.confirm_phone;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.avito.android.code_confirmation.Source;
import com.avito.android.code_confirmation.phone_confirm.PhoneCodeInfo;
import com.avito.android.code_confirmation.phone_confirm.PhoneConfirmInteractor;
import com.avito.android.profile_phones.confirm_phone.ConfirmPhoneViewModel;
import com.avito.android.util.Logs;
import com.avito.android.util.TypedResultException;
import com.avito.android.util.architecture_components.SingleLiveEvent;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Predicate;
import io.reactivex.rxjava3.kotlin.DisposableKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B/\u0012\u0006\u0010 \u001a\u00020\u001d\u0012\u0006\u0010$\u001a\u00020!\u0012\u0006\u0010(\u001a\u00020%\u0012\u0006\u00103\u001a\u000202\u0012\u0006\u00104\u001a\u00020\u0015¢\u0006\u0004\b5\u00106J\u000f\u0010\u0004\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0005J\u001d\u0010\n\u001a\u00020\u00032\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\f\u0010\u0005J\u0015\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\rH\u0016¢\u0006\u0004\b\u0012\u0010\u0010J\u0015\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\rH\u0016¢\u0006\u0004\b\u0014\u0010\u0010J\u0019\u0010\u0017\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0017\u0010\u0018R\u001c\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00110\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\u001c\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00130)8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u001c\u0010.\u001a\b\u0012\u0004\u0012\u00020\u000e0)8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b-\u0010+R\u0016\u00101\u001a\u00020/8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0017\u00100¨\u00067"}, d2 = {"Lcom/avito/android/profile_phones/confirm_phone/ConfirmPhoneViewModelImpl;", "Landroidx/lifecycle/ViewModel;", "Lcom/avito/android/profile_phones/confirm_phone/ConfirmPhoneViewModel;", "", "onCleared", "()V", "onBackClicked", "Lio/reactivex/rxjava3/core/Observable;", "", "inputChanges", "subscribeToInputChanges", "(Lio/reactivex/rxjava3/core/Observable;)V", "onNewCodeClicked", "Landroidx/lifecycle/LiveData;", "Lcom/avito/android/profile_phones/confirm_phone/ConfirmPhoneViewModel$ScreenState;", "screenState", "()Landroidx/lifecycle/LiveData;", "Lcom/avito/android/profile_phones/confirm_phone/ConfirmPhoneViewModel$RoutingAction;", "navigation", "Lcom/avito/android/profile_phones/confirm_phone/ConfirmPhoneViewModel$CodeRequestState;", "codeRequestState", "", "retry", "c", "(Z)V", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "f", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "navigationData", "", a2.g.r.g.a, "Ljava/lang/String;", "phone", "Lcom/avito/android/code_confirmation/phone_confirm/PhoneConfirmInteractor;", "h", "Lcom/avito/android/code_confirmation/phone_confirm/PhoneConfirmInteractor;", "interactor", "", "i", "I", "codeLength", "Landroidx/lifecycle/MutableLiveData;", "e", "Landroidx/lifecycle/MutableLiveData;", "codeRequestStateData", "d", "screenStateData", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "disposables", "", "timeout", "requestCode", "<init>", "(Ljava/lang/String;Lcom/avito/android/code_confirmation/phone_confirm/PhoneConfirmInteractor;IJZ)V", "profile-phones_release"}, k = 1, mv = {1, 4, 2})
public final class ConfirmPhoneViewModelImpl extends ViewModel implements ConfirmPhoneViewModel {
    public CompositeDisposable c = new CompositeDisposable();
    public final MutableLiveData<ConfirmPhoneViewModel.ScreenState> d;
    public final MutableLiveData<ConfirmPhoneViewModel.CodeRequestState> e;
    public final SingleLiveEvent<ConfirmPhoneViewModel.RoutingAction> f;
    public final String g;
    public final PhoneConfirmInteractor h;
    public int i;

    public static final class a<T> implements Consumer<PhoneCodeInfo> {
        public final /* synthetic */ ConfirmPhoneViewModelImpl a;

        public a(ConfirmPhoneViewModelImpl confirmPhoneViewModelImpl) {
            this.a = confirmPhoneViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r0v3, resolved type: androidx.lifecycle.MutableLiveData */
        /* JADX DEBUG: Multi-variable search result rejected for r5v5, resolved type: androidx.lifecycle.MutableLiveData */
        /* JADX DEBUG: Multi-variable search result rejected for r0v8, resolved type: androidx.lifecycle.MutableLiveData */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(PhoneCodeInfo phoneCodeInfo) {
            PhoneCodeInfo phoneCodeInfo2 = phoneCodeInfo;
            if (phoneCodeInfo2 instanceof PhoneCodeInfo.Ok) {
                PhoneCodeInfo.Ok ok = (PhoneCodeInfo.Ok) phoneCodeInfo2;
                this.a.i = ok.getLength();
                ConfirmPhoneViewModelImpl.access$postReadyState(this.a);
                this.a.e.postValue(new ConfirmPhoneViewModel.CodeRequestState.CodeRequestDone(ok.getTimeout(), this.a.i));
            } else if (phoneCodeInfo2 instanceof PhoneCodeInfo.Error) {
                this.a.d.postValue(new ConfirmPhoneViewModel.ScreenState.InputError(((PhoneCodeInfo.Error) phoneCodeInfo2).getMessage()));
                this.a.e.postValue(new ConfirmPhoneViewModel.CodeRequestState.CodeRequestDone(0, this.a.i));
            }
        }
    }

    public static final class b<T> implements Consumer<Throwable> {
        public final /* synthetic */ ConfirmPhoneViewModelImpl a;

        public b(ConfirmPhoneViewModelImpl confirmPhoneViewModelImpl) {
            this.a = confirmPhoneViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: androidx.lifecycle.MutableLiveData */
        /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: androidx.lifecycle.MutableLiveData */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            Throwable th2 = th;
            this.a.e.postValue(new ConfirmPhoneViewModel.CodeRequestState.CodeRequestDone(0, this.a.i));
            if (th2 instanceof TypedResultException) {
                this.a.d.postValue(new ConfirmPhoneViewModel.ScreenState.InputError(((TypedResultException) th2).getMessage()));
            } else {
                Logs.error("Failed to request phone code", th2);
            }
        }
    }

    public static final class c<T, R> implements Function<CharSequence, String> {
        public static final c a = new c();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public String apply(CharSequence charSequence) {
            return charSequence.toString();
        }
    }

    public static final class d<T> implements Predicate<String> {
        public final /* synthetic */ ConfirmPhoneViewModelImpl a;

        public d(ConfirmPhoneViewModelImpl confirmPhoneViewModelImpl) {
            this.a = confirmPhoneViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Predicate
        public boolean test(String str) {
            return str.length() == this.a.i;
        }
    }

    public static final class e<T> implements Consumer<String> {
        public final /* synthetic */ ConfirmPhoneViewModelImpl a;

        public e(ConfirmPhoneViewModelImpl confirmPhoneViewModelImpl) {
            this.a = confirmPhoneViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r2v3, resolved type: androidx.lifecycle.MutableLiveData */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(String str) {
            this.a.d.postValue(ConfirmPhoneViewModel.ScreenState.Progress.INSTANCE);
        }
    }

    public static final class f<T> implements Consumer<String> {
        public final /* synthetic */ ConfirmPhoneViewModelImpl a;

        public f(ConfirmPhoneViewModelImpl confirmPhoneViewModelImpl) {
            this.a = confirmPhoneViewModelImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(String str) {
            String str2 = str;
            ConfirmPhoneViewModelImpl confirmPhoneViewModelImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(str2, "it");
            ConfirmPhoneViewModelImpl.access$sendCode(confirmPhoneViewModelImpl, str2);
        }
    }

    public static final class g<T> implements Consumer<Throwable> {
        public static final g a = new g();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            Logs.error("Failed to observe input changes", th);
        }
    }

    public ConfirmPhoneViewModelImpl(@NotNull String str, @NotNull PhoneConfirmInteractor phoneConfirmInteractor, int i2, long j, boolean z) {
        Intrinsics.checkNotNullParameter(str, "phone");
        Intrinsics.checkNotNullParameter(phoneConfirmInteractor, "interactor");
        this.g = str;
        this.h = phoneConfirmInteractor;
        this.i = i2;
        MutableLiveData<ConfirmPhoneViewModel.ScreenState> mutableLiveData = new MutableLiveData<>();
        this.d = mutableLiveData;
        MutableLiveData<ConfirmPhoneViewModel.CodeRequestState> mutableLiveData2 = new MutableLiveData<>();
        this.e = mutableLiveData2;
        this.f = new SingleLiveEvent<>();
        mutableLiveData.postValue(new ConfirmPhoneViewModel.ScreenState.Ready(str));
        if (z) {
            c(false);
        } else {
            mutableLiveData2.postValue(new ConfirmPhoneViewModel.CodeRequestState.CodeRequestDone(j, this.i));
        }
    }

    public static final void access$postReadyState(ConfirmPhoneViewModelImpl confirmPhoneViewModelImpl) {
        confirmPhoneViewModelImpl.d.postValue(new ConfirmPhoneViewModel.ScreenState.Ready(confirmPhoneViewModelImpl.g));
    }

    public static final void access$sendCode(ConfirmPhoneViewModelImpl confirmPhoneViewModelImpl, String str) {
        CompositeDisposable compositeDisposable = confirmPhoneViewModelImpl.c;
        Disposable subscribe = confirmPhoneViewModelImpl.h.sendCode(confirmPhoneViewModelImpl.g, str, Source.PHONE_ADD).subscribe(new a2.a.a.c2.b.e(confirmPhoneViewModelImpl), new a2.a.a.c2.b.f(confirmPhoneViewModelImpl));
        Intrinsics.checkNotNullExpressionValue(subscribe, "interactor.sendCode(phon…         }\n            })");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    public final void c(boolean z) {
        this.e.setValue(ConfirmPhoneViewModel.CodeRequestState.CodeRequestInProgress.INSTANCE);
        CompositeDisposable compositeDisposable = this.c;
        Disposable subscribe = this.h.requestCode(this.g, Source.PHONE_ADD, z).subscribe(new a(this), new b(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "interactor.requestCode(p…         }\n            })");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    @Override // com.avito.android.profile_phones.confirm_phone.ConfirmPhoneViewModel
    @NotNull
    public LiveData<ConfirmPhoneViewModel.CodeRequestState> codeRequestState() {
        return this.e;
    }

    @Override // com.avito.android.profile_phones.confirm_phone.ConfirmPhoneViewModel
    @NotNull
    public LiveData<ConfirmPhoneViewModel.RoutingAction> navigation() {
        return this.f;
    }

    @Override // com.avito.android.profile_phones.confirm_phone.ConfirmPhoneViewModel
    public void onBackClicked() {
        this.f.setValue(ConfirmPhoneViewModel.RoutingAction.GoBack.INSTANCE);
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        this.c.clear();
    }

    @Override // com.avito.android.profile_phones.confirm_phone.ConfirmPhoneViewModel
    public void onNewCodeClicked() {
        c(true);
    }

    @Override // com.avito.android.profile_phones.confirm_phone.ConfirmPhoneViewModel
    @NotNull
    public LiveData<ConfirmPhoneViewModel.ScreenState> screenState() {
        return this.d;
    }

    @Override // com.avito.android.profile_phones.confirm_phone.ConfirmPhoneViewModel
    public void subscribeToInputChanges(@NotNull Observable<CharSequence> observable) {
        Intrinsics.checkNotNullParameter(observable, "inputChanges");
        CompositeDisposable compositeDisposable = this.c;
        Disposable subscribe = observable.map(c.a).distinctUntilChanged().filter(new d(this)).doOnNext(new e(this)).subscribe(new f(this), g.a);
        Intrinsics.checkNotNullExpressionValue(subscribe, "inputChanges\n           …nges\", it)\n            })");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }
}
