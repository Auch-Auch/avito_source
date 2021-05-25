package ru.sravni.android.bankproduct.presentation.auth.phone.viewmodel;

import a2.g.r.g;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.avito.android.remote.auth.AuthSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.R;
import ru.sravni.android.bankproduct.analytic.v2.BaseAnalyticKt;
import ru.sravni.android.bankproduct.analytic.v2.IBaseAnalytic;
import ru.sravni.android.bankproduct.analytic.v2.login.ILoginAnalytic;
import ru.sravni.android.bankproduct.domain.analytic.IErrorLogger;
import ru.sravni.android.bankproduct.domain.analytic.entity.MessagePriority;
import ru.sravni.android.bankproduct.domain.auth.IAuthInteractor;
import ru.sravni.android.bankproduct.domain.auth.entity.RegisterInfo;
import ru.sravni.android.bankproduct.domain.sravnierror.IErrorHandler;
import ru.sravni.android.bankproduct.domain.sravnierror.IThrowableWrapper;
import ru.sravni.android.bankproduct.domain.sravnierror.entity.SravniError;
import ru.sravni.android.bankproduct.utils.UtilFunctionsKt;
import ru.sravni.android.bankproduct.utils.navigation.INavigator;
import ru.sravni.android.bankproduct.utils.navigation.IPreviousModuleInfo;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B?\u0012\u0006\u0010'\u001a\u00020$\u0012\u0006\u0010+\u001a\u00020(\u0012\u0006\u0010#\u001a\u00020 \u0012\u0006\u0010\u001b\u001a\u00020\u0018\u0012\u0006\u0010\u001f\u001a\u00020\u001c\u0012\u0006\u0010/\u001a\u00020,\u0012\u0006\u00102\u001a\u00020\u0006¢\u0006\u0004\b@\u0010AJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J'\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\r\u0010\u0005J\u000f\u0010\u000e\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u000e\u0010\u0005J\u000f\u0010\u000f\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u000f\u0010\u0005J\u000f\u0010\u0010\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0010\u0010\u0005R\"\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00102\u001a\u00020\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b0\u00101R\u0018\u00106\u001a\u0004\u0018\u0001038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b4\u00105R\"\u00109\u001a\b\u0012\u0004\u0012\u00020\u00060\u00118\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b7\u0010\u0014\u001a\u0004\b8\u0010\u0016R\u001c\u0010?\u001a\u00020:8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>¨\u0006B"}, d2 = {"Lru/sravni/android/bankproduct/presentation/auth/phone/viewmodel/ProfilePhoneViewModel;", "Landroidx/lifecycle/ViewModel;", "Lru/sravni/android/bankproduct/presentation/auth/phone/viewmodel/IProfilePhoneViewModel;", "", "initPhone", "()V", "", "extractedPhone", "formattedPhone", "", "maskFilled", "phoneChange", "(Ljava/lang/String;Ljava/lang/String;Z)V", "sendPhone", "fragmentStartAction", "clearPhoneField", "onCleared", "Landroidx/lifecycle/MutableLiveData;", "Lru/sravni/android/bankproduct/presentation/auth/phone/viewmodel/StateEnum;", "d", "Landroidx/lifecycle/MutableLiveData;", "getPhoneState", "()Landroidx/lifecycle/MutableLiveData;", "phoneState", "Lru/sravni/android/bankproduct/domain/sravnierror/IThrowableWrapper;", "j", "Lru/sravni/android/bankproduct/domain/sravnierror/IThrowableWrapper;", "errorWrapper", "Lru/sravni/android/bankproduct/utils/navigation/IPreviousModuleInfo;", "k", "Lru/sravni/android/bankproduct/utils/navigation/IPreviousModuleInfo;", "previousModuleInfo", "Lru/sravni/android/bankproduct/domain/analytic/IErrorLogger;", "i", "Lru/sravni/android/bankproduct/domain/analytic/IErrorLogger;", "errorLogger", "Lru/sravni/android/bankproduct/utils/navigation/INavigator;", g.a, "Lru/sravni/android/bankproduct/utils/navigation/INavigator;", "navigator", "Lru/sravni/android/bankproduct/domain/auth/IAuthInteractor;", "h", "Lru/sravni/android/bankproduct/domain/auth/IAuthInteractor;", "authInteractor", "Lru/sravni/android/bankproduct/analytic/v2/login/ILoginAnalytic;", "l", "Lru/sravni/android/bankproduct/analytic/v2/login/ILoginAnalytic;", "loginAnalytic", AuthSource.OPEN_CHANNEL_LIST, "Ljava/lang/String;", "avitoDefaultPhone", "Lio/reactivex/disposables/Disposable;", "c", "Lio/reactivex/disposables/Disposable;", "subscription", "e", "getPhoneText", "phoneText", "Lru/sravni/android/bankproduct/domain/sravnierror/IErrorHandler;", "f", "Lru/sravni/android/bankproduct/domain/sravnierror/IErrorHandler;", "getMaskTextErrorHandler", "()Lru/sravni/android/bankproduct/domain/sravnierror/IErrorHandler;", "maskTextErrorHandler", "<init>", "(Lru/sravni/android/bankproduct/utils/navigation/INavigator;Lru/sravni/android/bankproduct/domain/auth/IAuthInteractor;Lru/sravni/android/bankproduct/domain/analytic/IErrorLogger;Lru/sravni/android/bankproduct/domain/sravnierror/IThrowableWrapper;Lru/sravni/android/bankproduct/utils/navigation/IPreviousModuleInfo;Lru/sravni/android/bankproduct/analytic/v2/login/ILoginAnalytic;Ljava/lang/String;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class ProfilePhoneViewModel extends ViewModel implements IProfilePhoneViewModel {
    public Disposable c;
    @NotNull
    public final MutableLiveData<StateEnum> d;
    @NotNull
    public final MutableLiveData<String> e = new MutableLiveData<>();
    @NotNull
    public final IErrorHandler f = UtilFunctionsKt.errorHandlerAction(new a(this));
    public final INavigator g;
    public final IAuthInteractor h;
    public final IErrorLogger i;
    public final IThrowableWrapper j;
    public final IPreviousModuleInfo k;
    public final ILoginAnalytic l;
    public final String m;

    public static final class a extends Lambda implements Function1<SravniError, Unit> {
        public final /* synthetic */ ProfilePhoneViewModel a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(ProfilePhoneViewModel profilePhoneViewModel) {
            super(1);
            this.a = profilePhoneViewModel;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(SravniError sravniError) {
            SravniError sravniError2 = sravniError;
            Intrinsics.checkParameterIsNotNull(sravniError2, "error");
            this.a.i.logError(MessagePriority.WARN, sravniError2);
            return Unit.INSTANCE;
        }
    }

    public static final class b<T> implements Consumer<RegisterInfo> {
        public final /* synthetic */ ProfilePhoneViewModel a;

        public b(ProfilePhoneViewModel profilePhoneViewModel) {
            this.a = profilePhoneViewModel;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(RegisterInfo registerInfo) {
            this.a.getPhoneState().setValue(StateEnum.STATE_SUCCESS);
            INavigator.DefaultImpls.route$default(this.a.g, R.id.action_avitoPhoneFragment_to_avitoSmsFragment, null, null, 6, null);
        }
    }

    public static final class c<T> implements Consumer<Throwable> {
        public final /* synthetic */ ProfilePhoneViewModel a;

        public c(ProfilePhoneViewModel profilePhoneViewModel) {
            this.a = profilePhoneViewModel;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            this.a.getPhoneState().setValue(StateEnum.STATE_ERROR);
            this.a.i.logError(MessagePriority.ERROR, this.a.j.wrap(th));
            IBaseAnalytic.DefaultImpls.sendFailEvent$default(this.a.l, BaseAnalyticKt.ANALYTIC_FAIL_SERVER, this.a.k.getPreviousModuleName(), null, 4, null);
        }
    }

    public ProfilePhoneViewModel(@NotNull INavigator iNavigator, @NotNull IAuthInteractor iAuthInteractor, @NotNull IErrorLogger iErrorLogger, @NotNull IThrowableWrapper iThrowableWrapper, @NotNull IPreviousModuleInfo iPreviousModuleInfo, @NotNull ILoginAnalytic iLoginAnalytic, @NotNull String str) {
        Intrinsics.checkParameterIsNotNull(iNavigator, "navigator");
        Intrinsics.checkParameterIsNotNull(iAuthInteractor, "authInteractor");
        Intrinsics.checkParameterIsNotNull(iErrorLogger, "errorLogger");
        Intrinsics.checkParameterIsNotNull(iThrowableWrapper, "errorWrapper");
        Intrinsics.checkParameterIsNotNull(iPreviousModuleInfo, "previousModuleInfo");
        Intrinsics.checkParameterIsNotNull(iLoginAnalytic, "loginAnalytic");
        Intrinsics.checkParameterIsNotNull(str, "avitoDefaultPhone");
        this.g = iNavigator;
        this.h = iAuthInteractor;
        this.i = iErrorLogger;
        this.j = iThrowableWrapper;
        this.k = iPreviousModuleInfo;
        this.l = iLoginAnalytic;
        this.m = str;
        MutableLiveData<StateEnum> mutableLiveData = new MutableLiveData<>();
        mutableLiveData.setValue(StateEnum.STATE_NEUTRAL);
        this.d = mutableLiveData;
    }

    @Override // ru.sravni.android.bankproduct.presentation.auth.phone.viewmodel.IProfilePhoneViewModel
    public void clearPhoneField() {
        getPhoneText().setValue("");
    }

    @Override // ru.sravni.android.bankproduct.presentation.auth.phone.viewmodel.IProfilePhoneViewModel
    public void fragmentStartAction() {
        IBaseAnalytic.DefaultImpls.sendOpenEvent$default(this.l, this.k.getPreviousModuleName(), null, null, 6, null);
    }

    @Override // ru.sravni.android.bankproduct.utils.masktext.IMaskTextErrorHandler
    @NotNull
    public IErrorHandler getMaskTextErrorHandler() {
        return this.f;
    }

    @Override // ru.sravni.android.bankproduct.presentation.auth.phone.viewmodel.IProfilePhoneViewModel
    public void initPhone() {
        getPhoneText().setValue(this.m);
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        Disposable disposable = this.c;
        if (disposable != null) {
            disposable.dispose();
        }
        super.onCleared();
    }

    @Override // ru.sravni.android.bankproduct.presentation.auth.phone.viewmodel.IProfilePhoneViewModel
    public void phoneChange(@NotNull String str, @NotNull String str2, boolean z) {
        Intrinsics.checkParameterIsNotNull(str, "extractedPhone");
        Intrinsics.checkParameterIsNotNull(str2, "formattedPhone");
        if (z) {
            this.h.setPhoneNumber(str, str2);
            getPhoneState().setValue(StateEnum.STATE_COMPLETE);
            return;
        }
        getPhoneState().setValue(StateEnum.STATE_NEUTRAL);
    }

    @Override // ru.sravni.android.bankproduct.presentation.auth.phone.viewmodel.IProfilePhoneViewModel
    public void sendPhone() {
        getPhoneState().setValue(StateEnum.STATE_WAITING);
        getPhoneText().setValue(this.h.getPhoneNumber());
        Disposable disposable = this.c;
        if (disposable != null) {
            disposable.dispose();
        }
        this.c = this.h.sendPhone().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(this), new c(this));
    }

    @Override // ru.sravni.android.bankproduct.presentation.auth.phone.viewmodel.IProfilePhoneViewModel
    @NotNull
    public MutableLiveData<StateEnum> getPhoneState() {
        return this.d;
    }

    @Override // ru.sravni.android.bankproduct.presentation.auth.phone.viewmodel.IProfilePhoneViewModel
    @NotNull
    public MutableLiveData<String> getPhoneText() {
        return this.e;
    }
}
