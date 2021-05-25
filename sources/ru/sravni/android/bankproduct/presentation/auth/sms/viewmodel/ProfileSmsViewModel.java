package ru.sravni.android.bankproduct.presentation.auth.sms.viewmodel;

import a2.g.r.g;
import a7.c.a.a.o.a.b.b.c;
import a7.c.a.a.o.a.b.b.d;
import a7.c.a.a.o.a.b.b.e;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.avito.android.remote.auth.AuthSource;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.Locale;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.HttpException;
import ru.sravni.android.bankproduct.R;
import ru.sravni.android.bankproduct.analytic.v2.BaseAnalyticKt;
import ru.sravni.android.bankproduct.analytic.v2.IBaseAnalytic;
import ru.sravni.android.bankproduct.analytic.v2.login.ILoginAnalytic;
import ru.sravni.android.bankproduct.domain.analytic.IErrorLogger;
import ru.sravni.android.bankproduct.domain.analytic.entity.MessagePriority;
import ru.sravni.android.bankproduct.domain.auth.IAuthInteractor;
import ru.sravni.android.bankproduct.domain.auth.entity.RegisterInfo;
import ru.sravni.android.bankproduct.domain.dictionary.IProductNameDictionary;
import ru.sravni.android.bankproduct.domain.sravnierror.IThrowableWrapper;
import ru.sravni.android.bankproduct.domain.sravnierror.entity.SravniError;
import ru.sravni.android.bankproduct.presentation.auth.phone.viewmodel.StateEnum;
import ru.sravni.android.bankproduct.utils.keyboard.IKeyboardHider;
import ru.sravni.android.bankproduct.utils.navigation.INavigator;
import ru.sravni.android.bankproduct.utils.navigation.IPreviousModuleInfo;
import ru.sravni.android.bankproduct.utils.resource.IResourceProvider;
import ru.sravni.android.bankproduct.utils.sms.ISmsChannel;
import ru.sravni.android.bankproduct.utils.sms.SmsInfo;
import ru.sravni.android.bankproduct.utils.snackbar.IBottomSnackbarShower;
import ru.sravni.android.bankproduct.utils.snackbar.SnackbarData;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002Bg\u0012\u0006\u0010@\u001a\u00020=\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u0012\u0006\u00104\u001a\u000201\u0012\u0006\u0010<\u001a\u000209\u0012\u0006\u0010,\u001a\u00020)\u0012\u0006\u0010_\u001a\u00020^\u0012\u0006\u0010G\u001a\u00020\n\u0012\u0006\u0010K\u001a\u00020H\u0012\u0006\u0010!\u001a\u00020\u001e\u0012\u0006\u00108\u001a\u000205\u0012\u0006\u0010%\u001a\u00020\"\u0012\u0006\u0010S\u001a\u00020P¢\u0006\u0004\b`\u0010aJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\f\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0012\u0010\tJ\u000f\u0010\u0013\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0013\u0010\tR\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\"\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00030\u00188\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\"\u0010(\u001a\b\u0012\u0004\u0012\u00020\n0\u00188\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b&\u0010\u001a\u001a\u0004\b'\u0010\u001cR\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\"\u00100\u001a\b\u0012\u0004\u0012\u00020-0\u00188\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b.\u0010\u001a\u001a\u0004\b/\u0010\u001cR\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u00108\u001a\u0002058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010<\u001a\u0002098\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010@\u001a\u00020=8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b>\u0010?R\u0018\u0010D\u001a\u0004\u0018\u00010A8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bB\u0010CR\u0016\u0010G\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bE\u0010FR\u0016\u0010K\u001a\u00020H8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bI\u0010JR\u0018\u0010L\u001a\u0004\u0018\u00010A8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010CR\"\u0010O\u001a\b\u0012\u0004\u0012\u00020\n0\u00188\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bM\u0010\u001a\u001a\u0004\bN\u0010\u001cR\u0016\u0010S\u001a\u00020P8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bQ\u0010RR\"\u0010V\u001a\b\u0012\u0004\u0012\u00020\n0\u00188\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bT\u0010\u001a\u001a\u0004\bU\u0010\u001cR\"\u0010Z\u001a\b\u0012\u0004\u0012\u00020W0\u00188\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bX\u0010\u001a\u001a\u0004\bY\u0010\u001cR\"\u0010]\u001a\b\u0012\u0004\u0012\u00020\n0\u00188\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b[\u0010\u001a\u001a\u0004\b\\\u0010\u001c¨\u0006b"}, d2 = {"Lru/sravni/android/bankproduct/presentation/auth/sms/viewmodel/ProfileSmsViewModel;", "Landroidx/lifecycle/ViewModel;", "Lru/sravni/android/bankproduct/presentation/auth/sms/viewmodel/IProfileSmsViewModel;", "", "textId", "", "c", "(I)V", "clearSmsField", "()V", "", "time", "setTime", "(Ljava/lang/String;)V", "smsCode", "maxLength", "smsCodeChange", "(Ljava/lang/String;I)V", "repeatSendPhone", "onCleared", "Lru/sravni/android/bankproduct/domain/auth/IAuthInteractor;", AuthSource.OPEN_CHANNEL_LIST, "Lru/sravni/android/bankproduct/domain/auth/IAuthInteractor;", "authInteractor", "Landroidx/lifecycle/MutableLiveData;", "j", "Landroidx/lifecycle/MutableLiveData;", "getTimerState", "()Landroidx/lifecycle/MutableLiveData;", "timerState", "Lru/sravni/android/bankproduct/utils/navigation/IPreviousModuleInfo;", "s", "Lru/sravni/android/bankproduct/utils/navigation/IPreviousModuleInfo;", "previousModuleInfo", "Lru/sravni/android/bankproduct/utils/snackbar/IBottomSnackbarShower;", "u", "Lru/sravni/android/bankproduct/utils/snackbar/IBottomSnackbarShower;", "snackbarShower", "k", "getSmsCodeText", "smsCodeText", "Lru/sravni/android/bankproduct/domain/sravnierror/IThrowableWrapper;", "p", "Lru/sravni/android/bankproduct/domain/sravnierror/IThrowableWrapper;", "errorWrapper", "Lru/sravni/android/bankproduct/presentation/auth/phone/viewmodel/StateEnum;", "f", "getEditSmsStatus", "editSmsStatus", "Lru/sravni/android/bankproduct/utils/keyboard/IKeyboardHider;", "n", "Lru/sravni/android/bankproduct/utils/keyboard/IKeyboardHider;", "keyboardHider", "Lru/sravni/android/bankproduct/domain/dictionary/IProductNameDictionary;", "t", "Lru/sravni/android/bankproduct/domain/dictionary/IProductNameDictionary;", "productDictionary", "Lru/sravni/android/bankproduct/domain/analytic/IErrorLogger;", "o", "Lru/sravni/android/bankproduct/domain/analytic/IErrorLogger;", "errorLogger", "Lru/sravni/android/bankproduct/utils/navigation/INavigator;", "l", "Lru/sravni/android/bankproduct/utils/navigation/INavigator;", "navigator", "Lio/reactivex/disposables/Disposable;", "d", "Lio/reactivex/disposables/Disposable;", "smsReceiveSubscription", VKApiConst.Q, "Ljava/lang/String;", "smsPrefixText", "Lru/sravni/android/bankproduct/analytic/v2/login/ILoginAnalytic;", "r", "Lru/sravni/android/bankproduct/analytic/v2/login/ILoginAnalytic;", "loginAnalytic", "subscription", "h", "getTimerValue", "timerValue", "Lru/sravni/android/bankproduct/utils/resource/IResourceProvider;", VKApiConst.VERSION, "Lru/sravni/android/bankproduct/utils/resource/IResourceProvider;", "resourceProvider", "e", "getPhoneNumber", "phoneNumber", "", g.a, "getRepeatSmsCode", "repeatSmsCode", "i", "getSmsInsertedText", "smsInsertedText", "Lru/sravni/android/bankproduct/utils/sms/ISmsChannel;", "smsTextReceiver", "<init>", "(Lru/sravni/android/bankproduct/utils/navigation/INavigator;Lru/sravni/android/bankproduct/domain/auth/IAuthInteractor;Lru/sravni/android/bankproduct/utils/keyboard/IKeyboardHider;Lru/sravni/android/bankproduct/domain/analytic/IErrorLogger;Lru/sravni/android/bankproduct/domain/sravnierror/IThrowableWrapper;Lru/sravni/android/bankproduct/utils/sms/ISmsChannel;Ljava/lang/String;Lru/sravni/android/bankproduct/analytic/v2/login/ILoginAnalytic;Lru/sravni/android/bankproduct/utils/navigation/IPreviousModuleInfo;Lru/sravni/android/bankproduct/domain/dictionary/IProductNameDictionary;Lru/sravni/android/bankproduct/utils/snackbar/IBottomSnackbarShower;Lru/sravni/android/bankproduct/utils/resource/IResourceProvider;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class ProfileSmsViewModel extends ViewModel implements IProfileSmsViewModel {
    public Disposable c;
    public Disposable d;
    @NotNull
    public final MutableLiveData<String> e;
    @NotNull
    public final MutableLiveData<StateEnum> f;
    @NotNull
    public final MutableLiveData<Boolean> g = new MutableLiveData<>();
    @NotNull
    public final MutableLiveData<String> h = new MutableLiveData<>();
    @NotNull
    public final MutableLiveData<String> i = new MutableLiveData<>();
    @NotNull
    public final MutableLiveData<Integer> j;
    @NotNull
    public final MutableLiveData<String> k;
    public final INavigator l;
    public final IAuthInteractor m;
    public final IKeyboardHider n;
    public final IErrorLogger o;
    public final IThrowableWrapper p;
    public final String q;
    public final ILoginAnalytic r;
    public final IPreviousModuleInfo s;
    public final IProductNameDictionary t;
    public final IBottomSnackbarShower u;
    public final IResourceProvider v;

    public static final class a<T> implements Consumer<RegisterInfo> {
        public static final a a = new a();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(RegisterInfo registerInfo) {
        }
    }

    public static final class b<T> implements Consumer<Throwable> {
        public final /* synthetic */ ProfileSmsViewModel a;

        public b(ProfileSmsViewModel profileSmsViewModel) {
            this.a = profileSmsViewModel;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            this.a.o.logError(MessagePriority.ERROR, this.a.p.wrap(th));
            IBaseAnalytic.DefaultImpls.sendFailEvent$default(this.a.r, BaseAnalyticKt.ANALYTIC_FAIL_SERVER, this.a.s.getPreviousModuleName(), null, 4, null);
        }
    }

    public ProfileSmsViewModel(@NotNull INavigator iNavigator, @NotNull IAuthInteractor iAuthInteractor, @NotNull IKeyboardHider iKeyboardHider, @NotNull IErrorLogger iErrorLogger, @NotNull IThrowableWrapper iThrowableWrapper, @NotNull ISmsChannel iSmsChannel, @NotNull String str, @NotNull ILoginAnalytic iLoginAnalytic, @NotNull IPreviousModuleInfo iPreviousModuleInfo, @NotNull IProductNameDictionary iProductNameDictionary, @NotNull IBottomSnackbarShower iBottomSnackbarShower, @NotNull IResourceProvider iResourceProvider) {
        Intrinsics.checkParameterIsNotNull(iNavigator, "navigator");
        Intrinsics.checkParameterIsNotNull(iAuthInteractor, "authInteractor");
        Intrinsics.checkParameterIsNotNull(iKeyboardHider, "keyboardHider");
        Intrinsics.checkParameterIsNotNull(iErrorLogger, "errorLogger");
        Intrinsics.checkParameterIsNotNull(iThrowableWrapper, "errorWrapper");
        Intrinsics.checkParameterIsNotNull(iSmsChannel, "smsTextReceiver");
        Intrinsics.checkParameterIsNotNull(str, "smsPrefixText");
        Intrinsics.checkParameterIsNotNull(iLoginAnalytic, "loginAnalytic");
        Intrinsics.checkParameterIsNotNull(iPreviousModuleInfo, "previousModuleInfo");
        Intrinsics.checkParameterIsNotNull(iProductNameDictionary, "productDictionary");
        Intrinsics.checkParameterIsNotNull(iBottomSnackbarShower, "snackbarShower");
        Intrinsics.checkParameterIsNotNull(iResourceProvider, "resourceProvider");
        this.l = iNavigator;
        this.m = iAuthInteractor;
        this.n = iKeyboardHider;
        this.o = iErrorLogger;
        this.p = iThrowableWrapper;
        this.q = str;
        this.r = iLoginAnalytic;
        this.s = iPreviousModuleInfo;
        this.t = iProductNameDictionary;
        this.u = iBottomSnackbarShower;
        this.v = iResourceProvider;
        MutableLiveData<String> mutableLiveData = new MutableLiveData<>();
        mutableLiveData.setValue(iAuthInteractor.getPhoneNumber());
        this.e = mutableLiveData;
        MutableLiveData<StateEnum> mutableLiveData2 = new MutableLiveData<>();
        mutableLiveData2.setValue(StateEnum.STATE_NEUTRAL);
        this.f = mutableLiveData2;
        MutableLiveData<Integer> mutableLiveData3 = new MutableLiveData<>();
        mutableLiveData3.setValue(Integer.valueOf(R.id.start_timer));
        this.j = mutableLiveData3;
        this.k = new MutableLiveData<>();
        this.d = iSmsChannel.getSmsChannel().filter(new c(this)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new d(this), new e(this, iErrorLogger, iThrowableWrapper));
    }

    public static final boolean access$checkSms(ProfileSmsViewModel profileSmsViewModel, SmsInfo smsInfo) {
        Objects.requireNonNull(profileSmsViewModel);
        String originAddress = smsInfo.getOriginAddress();
        if (originAddress != null) {
            Locale locale = Locale.getDefault();
            Intrinsics.checkExpressionValueIsNotNull(locale, "Locale.getDefault()");
            String lowerCase = originAddress.toLowerCase(locale);
            Intrinsics.checkExpressionValueIsNotNull(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
            if (lowerCase != null && StringsKt__StringsKt.contains$default((CharSequence) lowerCase, (CharSequence) "sravni.ru", false, 2, (Object) null) && StringsKt__StringsKt.contains$default((CharSequence) smsInfo.getSmsText(), (CharSequence) profileSmsViewModel.q, false, 2, (Object) null)) {
                return true;
            }
        }
        return false;
    }

    public static final void access$mapThrowableToErrorAction(ProfileSmsViewModel profileSmsViewModel, Throwable th) {
        Objects.requireNonNull(profileSmsViewModel);
        if (th instanceof SravniError) {
            th = ((SravniError) th).getError();
        }
        boolean z = th instanceof HttpException;
        if (z && ((HttpException) th).code() == 400) {
            profileSmsViewModel.getEditSmsStatus().setValue(StateEnum.STATE_ERROR);
        } else if (z) {
            profileSmsViewModel.c(R.string.avito_sms_screen_response_error);
        } else {
            profileSmsViewModel.c(R.string.avito_sms_screen_unknown_error);
        }
    }

    public final void c(int i2) {
        getEditSmsStatus().setValue(StateEnum.STATE_REPEAT);
        this.u.showBottomSnackbar(new SnackbarData(0, this.v.getString(i2)));
    }

    @Override // ru.sravni.android.bankproduct.presentation.auth.sms.viewmodel.IProfileSmsViewModel
    public void clearSmsField() {
        getSmsCodeText().setValue("");
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        Disposable disposable = this.c;
        if (disposable != null) {
            disposable.dispose();
        }
        Disposable disposable2 = this.d;
        if (disposable2 != null) {
            disposable2.dispose();
        }
        getTimerState().setValue(Integer.valueOf(R.id.stop_timer));
        super.onCleared();
    }

    @Override // ru.sravni.android.bankproduct.presentation.auth.sms.viewmodel.IProfileSmsViewModel
    public void repeatSendPhone() {
        getTimerState().setValue(Integer.valueOf(R.id.start_timer));
        getRepeatSmsCode().setValue(Boolean.FALSE);
        getEditSmsStatus().setValue(StateEnum.STATE_NEUTRAL);
        Disposable disposable = this.c;
        if (disposable != null) {
            disposable.dispose();
        }
        this.c = this.m.sendPhone().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(a.a, new b(this));
    }

    @Override // ru.sravni.android.bankproduct.presentation.auth.sms.viewmodel.IProfileSmsViewModel
    public void setTime(@Nullable String str) {
        Unit unit;
        if (str != null) {
            getTimerValue().setValue(str);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            getRepeatSmsCode().setValue(Boolean.TRUE);
            Unit unit2 = Unit.INSTANCE;
        }
    }

    @Override // ru.sravni.android.bankproduct.presentation.auth.sms.viewmodel.IProfileSmsViewModel
    public void smsCodeChange(@NotNull String str, int i2) {
        Intrinsics.checkParameterIsNotNull(str, "smsCode");
        if (str.length() == i2) {
            getEditSmsStatus().setValue(StateEnum.STATE_WAITING);
            Disposable disposable = this.c;
            if (disposable != null) {
                disposable.dispose();
            }
            this.c = this.m.sendSmsCode(str).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new a7.c.a.a.o.a.b.b.a(this), new a7.c.a.a.o.a.b.b.b(this));
        }
    }

    @Override // ru.sravni.android.bankproduct.presentation.auth.sms.viewmodel.IProfileSmsViewModel
    @NotNull
    public MutableLiveData<StateEnum> getEditSmsStatus() {
        return this.f;
    }

    @Override // ru.sravni.android.bankproduct.presentation.auth.sms.viewmodel.IProfileSmsViewModel
    @NotNull
    public MutableLiveData<String> getPhoneNumber() {
        return this.e;
    }

    @Override // ru.sravni.android.bankproduct.presentation.auth.sms.viewmodel.IProfileSmsViewModel
    @NotNull
    public MutableLiveData<Boolean> getRepeatSmsCode() {
        return this.g;
    }

    @Override // ru.sravni.android.bankproduct.presentation.auth.sms.viewmodel.IProfileSmsViewModel
    @NotNull
    public MutableLiveData<String> getSmsCodeText() {
        return this.k;
    }

    @Override // ru.sravni.android.bankproduct.presentation.auth.sms.viewmodel.IProfileSmsViewModel
    @NotNull
    public MutableLiveData<String> getSmsInsertedText() {
        return this.i;
    }

    @Override // ru.sravni.android.bankproduct.presentation.auth.sms.viewmodel.IProfileSmsViewModel
    @NotNull
    public MutableLiveData<Integer> getTimerState() {
        return this.j;
    }

    @Override // ru.sravni.android.bankproduct.presentation.auth.sms.viewmodel.IProfileSmsViewModel
    @NotNull
    public MutableLiveData<String> getTimerValue() {
        return this.h;
    }
}
