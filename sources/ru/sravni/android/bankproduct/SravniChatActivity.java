package ru.sravni.android.bankproduct;

import a2.b.a.a.a;
import a2.g.r.g;
import a7.c.a.a.e;
import a7.c.a.a.f;
import a7.c.a.a.h;
import a7.c.a.a.i;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.internal.view.SupportMenu;
import com.androidadvance.topsnackbar.R;
import com.androidadvance.topsnackbar.TSnackbar;
import com.google.android.material.snackbar.Snackbar;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.kodein.di.Kodein;
import org.kodein.di.KodeinAware;
import org.kodein.di.KodeinAwareKt;
import org.kodein.di.KodeinContext;
import org.kodein.di.KodeinProperty;
import org.kodein.di.KodeinTrigger;
import org.kodein.di.TypeReference;
import org.kodein.di.TypesKt;
import ru.sravni.android.bankproduct.domain.analytic.IErrorLogger;
import ru.sravni.android.bankproduct.domain.sravnierror.IThrowableWrapper;
import ru.sravni.android.bankproduct.domain.token.ITokenInteractor;
import ru.sravni.android.bankproduct.network.di.SravniNetworkConfiguration;
import ru.sravni.android.bankproduct.presentation.auth.tokenfail.view.TokenRefreshDialog;
import ru.sravni.android.bankproduct.presentation.auth.tokenfail.viewmodel.ITokenRefreshDialogSignal;
import ru.sravni.android.bankproduct.presentation.dialogerror.view.ErrorDialogFragment;
import ru.sravni.android.bankproduct.presentation.main.IMainNavigationController;
import ru.sravni.android.bankproduct.presentation.main.viewmodel.IErrorViewModel;
import ru.sravni.android.bankproduct.utils.NetworkChangeReceiver;
import ru.sravni.android.bankproduct.utils.UtilFunctionsKt;
import ru.sravni.android.bankproduct.utils.keyboard.IKeyboardSignalSender;
import ru.sravni.android.bankproduct.utils.lifecycles.IMainActivityLifecycleListener;
import ru.sravni.android.bankproduct.utils.snackbar.IBottomSnackbarShower;
import ru.sravni.android.bankproduct.utils.snackbar.ISnackBarViewModel;
import ru.sravni.android.bankproduct.utils.snackbar.ITopSnackbarShower;
import ru.sravni.android.bankproduct.utils.snackbar.SnackbarData;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¬\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 D2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001DB\u0007¢\u0006\u0004\bC\u0010\u0018J\u0019\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0014¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\u0019\u0010\u0018J\u000f\u0010\u001a\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\u001a\u0010\u0018J\u000f\u0010\u001b\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\u001b\u0010\u0018J\u000f\u0010\u001c\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\u001c\u0010\u0018J\u000f\u0010\u001d\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\u001d\u0010\u0018J\u000f\u0010\u001e\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\u001e\u0010\u0018J\u0019\u0010\u001f\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0014¢\u0006\u0004\b\u001f\u0010\tR\u0018\u0010#\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010+\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b)\u0010*R\"\u0010-\u001a\u00020,8\u0016@\u0016X.¢\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u0018\u00106\u001a\u0004\u0018\u0001038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b4\u00105R\u0016\u0010:\u001a\u0002078\u0002@\u0002X.¢\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010>\u001a\u00020;8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b<\u0010=R\u0018\u0010B\u001a\u0004\u0018\u00010?8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b@\u0010A¨\u0006S²\u0006\u000e\u0010F\u001a\u00020E8\n@\nX\u0002²\u0006\u000e\u0010H\u001a\u00020G8\n@\nX\u0002²\u0006\u000e\u0010J\u001a\u00020I8\n@\nX\u0002²\u0006\u000e\u0010L\u001a\u00020K8\n@\nX\u0002²\u0006\u000e\u0010N\u001a\u00020M8\n@\nX\u0002²\u0006\u000e\u0010P\u001a\u00020O8\n@\nX\u0002²\u0006\u000e\u0010R\u001a\u00020Q8\n@\nX\u0002"}, d2 = {"Lru/sravni/android/bankproduct/SravniChatActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lru/sravni/android/bankproduct/utils/snackbar/ITopSnackbarShower;", "Lru/sravni/android/bankproduct/utils/snackbar/IBottomSnackbarShower;", "Lorg/kodein/di/KodeinAware;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "(Landroid/os/Bundle;)V", "", "onSupportNavigateUp", "()Z", "Lru/sravni/android/bankproduct/utils/snackbar/SnackbarData;", "snackbarData", "showBottomSnackbar", "(Lru/sravni/android/bankproduct/utils/snackbar/SnackbarData;)V", "", "duration", "", "text", "showTopSnackbar", "(ILjava/lang/String;)V", "removeTopSnackbar", "()V", "onDestroy", "onStart", "onResume", "onPause", "onStop", "onRestart", "onRestoreInstanceState", "Lru/sravni/android/bankproduct/presentation/auth/tokenfail/view/TokenRefreshDialog;", "i", "Lru/sravni/android/bankproduct/presentation/auth/tokenfail/view/TokenRefreshDialog;", "tokenRefreshDialog", "Landroid/content/BroadcastReceiver;", "d", "Landroid/content/BroadcastReceiver;", "networkReceiver", "Lcom/androidadvance/topsnackbar/TSnackbar;", "e", "Lcom/androidadvance/topsnackbar/TSnackbar;", "topSnackBar", "Lorg/kodein/di/Kodein;", "kodein", "Lorg/kodein/di/Kodein;", "getKodein", "()Lorg/kodein/di/Kodein;", "setKodein", "(Lorg/kodein/di/Kodein;)V", "Lru/sravni/android/bankproduct/presentation/dialogerror/view/ErrorDialogFragment;", "c", "Lru/sravni/android/bankproduct/presentation/dialogerror/view/ErrorDialogFragment;", "dialog", "Lru/sravni/android/bankproduct/utils/lifecycles/IMainActivityLifecycleListener;", g.a, "Lru/sravni/android/bankproduct/utils/lifecycles/IMainActivityLifecycleListener;", "mainActivityListener", "Lru/sravni/android/bankproduct/presentation/main/IMainNavigationController;", "h", "Lru/sravni/android/bankproduct/presentation/main/IMainNavigationController;", "mainNavigationController", "Lcom/google/android/material/snackbar/Snackbar;", "f", "Lcom/google/android/material/snackbar/Snackbar;", "bottomSnackBar", "<init>", "Companion", "Lru/sravni/android/bankproduct/presentation/main/viewmodel/IErrorViewModel;", "errorViewModel", "Lru/sravni/android/bankproduct/domain/sravnierror/IThrowableWrapper;", "errorWrapper", "Lru/sravni/android/bankproduct/domain/analytic/IErrorLogger;", "errorLogger", "Lru/sravni/android/bankproduct/utils/keyboard/IKeyboardSignalSender;", "signalSender", "Lru/sravni/android/bankproduct/utils/snackbar/ISnackBarViewModel;", "snackbarViewModel", "Lru/sravni/android/bankproduct/presentation/auth/tokenfail/viewmodel/ITokenRefreshDialogSignal;", "tokenRefreshDialogShower", "Lru/sravni/android/bankproduct/domain/token/ITokenInteractor;", "tokenInteractor", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class SravniChatActivity extends AppCompatActivity implements ITopSnackbarShower, IBottomSnackbarShower, KodeinAware {
    public static final Companion Companion = new Companion(null);
    public static final /* synthetic */ KProperty[] k = {Reflection.property0(new PropertyReference0Impl(Reflection.getOrCreateKotlinClass(SravniChatActivity.class), "errorViewModel", "<v#0>")), Reflection.property0(new PropertyReference0Impl(Reflection.getOrCreateKotlinClass(SravniChatActivity.class), "errorWrapper", "<v#1>")), Reflection.property0(new PropertyReference0Impl(Reflection.getOrCreateKotlinClass(SravniChatActivity.class), "errorLogger", "<v#2>")), Reflection.property0(new PropertyReference0Impl(Reflection.getOrCreateKotlinClass(SravniChatActivity.class), "signalSender", "<v#3>")), Reflection.property0(new PropertyReference0Impl(Reflection.getOrCreateKotlinClass(SravniChatActivity.class), "snackbarViewModel", "<v#4>")), Reflection.property0(new PropertyReference0Impl(Reflection.getOrCreateKotlinClass(SravniChatActivity.class), "tokenRefreshDialogShower", "<v#5>")), Reflection.property0(new PropertyReference0Impl(Reflection.getOrCreateKotlinClass(SravniChatActivity.class), "tokenInteractor", "<v#6>"))};
    public ErrorDialogFragment c;
    public BroadcastReceiver d;
    public TSnackbar e;
    public Snackbar f;
    public IMainActivityLifecycleListener g;
    public IMainNavigationController h;
    public TokenRefreshDialog i;
    public HashMap j;
    @NotNull
    public Kodein kodein;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0011\u0010\u0012J/\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\r\u001a\u00020\b8\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u000f\u001a\u00020\b8\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u000f\u0010\u000eR\u0016\u0010\u0010\u001a\u00020\b8\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0010\u0010\u000e¨\u0006\u0013"}, d2 = {"Lru/sravni/android/bankproduct/SravniChatActivity$Companion;", "", "Landroid/content/Context;", "context", "Lru/sravni/android/bankproduct/network/di/SravniNetworkConfiguration;", "sravniNetworkConfiguration", "", "useDebugLog", "", "defaultUserPhoneForAuth", "Landroid/content/Intent;", "getIntentToStartActivity", "(Landroid/content/Context;Lru/sravni/android/bankproduct/network/di/SravniNetworkConfiguration;ZLjava/lang/String;)Landroid/content/Intent;", "defaultUserPhoneForAuthArg", "Ljava/lang/String;", "networkConfigurationArg", "useDebugLogArg", "<init>", "()V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        public Companion() {
        }

        @NotNull
        public final Intent getIntentToStartActivity(@NotNull Context context, @Nullable SravniNetworkConfiguration sravniNetworkConfiguration, boolean z, @NotNull String str) {
            Intrinsics.checkParameterIsNotNull(context, "context");
            Intrinsics.checkParameterIsNotNull(str, "defaultUserPhoneForAuth");
            Intent intent = new Intent(context, SravniChatActivity.class);
            Bundle bundle = new Bundle();
            if (sravniNetworkConfiguration != null) {
                bundle.putString("sravniNetworkConfiguration", UtilFunctionsKt.toSravniJson(sravniNetworkConfiguration));
            }
            bundle.putBoolean("useDebugLog", z);
            bundle.putString("defaultUserPhoneForAuth", str);
            intent.putExtras(bundle);
            return intent;
        }

        public Companion(j jVar) {
        }
    }

    public static final void access$hideKeyboard(SravniChatActivity sravniChatActivity) {
        Object systemService = sravniChatActivity.getSystemService("input_method");
        if (systemService != null) {
            Window window = sravniChatActivity.getWindow();
            Intrinsics.checkExpressionValueIsNotNull(window, "window");
            View findViewById = window.getDecorView().findViewById(16908290);
            Intrinsics.checkExpressionValueIsNotNull(findViewById, "view");
            ((InputMethodManager) systemService).hideSoftInputFromWindow(findViewById.getWindowToken(), 0);
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
    }

    public static final void access$showKeyboard(SravniChatActivity sravniChatActivity) {
        Object systemService = sravniChatActivity.getSystemService("input_method");
        if (systemService != null) {
            ((InputMethodManager) systemService).toggleSoftInput(2, 0);
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
    }

    public static final void access$showTokenRefreshDialog(SravniChatActivity sravniChatActivity) {
        if (sravniChatActivity.i == null) {
            TokenRefreshDialog newInstance = TokenRefreshDialog.Companion.newInstance();
            sravniChatActivity.i = newInstance;
            if (newInstance == null) {
                Intrinsics.throwNpe();
            }
            newInstance.setCancelable(false);
        }
        TokenRefreshDialog tokenRefreshDialog = sravniChatActivity.i;
        if (tokenRefreshDialog == null) {
            Intrinsics.throwNpe();
        }
        if (!tokenRefreshDialog.isAdded()) {
            TokenRefreshDialog tokenRefreshDialog2 = sravniChatActivity.i;
            if (tokenRefreshDialog2 == null) {
                Intrinsics.throwNpe();
            }
            tokenRefreshDialog2.show(sravniChatActivity.getSupportFragmentManager(), "TokenRefreshDialog");
        }
    }

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this.j;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public View _$_findCachedViewById(int i2) {
        if (this.j == null) {
            this.j = new HashMap();
        }
        View view = (View) this.j.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.j.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    @Override // org.kodein.di.KodeinAware
    @NotNull
    public Kodein getKodein() {
        Kodein kodein2 = this.kodein;
        if (kodein2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("kodein");
        }
        return kodein2;
    }

    @Override // org.kodein.di.KodeinAware
    @NotNull
    public KodeinContext<?> getKodeinContext() {
        return KodeinAware.DefaultImpls.getKodeinContext(this);
    }

    @Override // org.kodein.di.KodeinAware
    @Nullable
    public KodeinTrigger getKodeinTrigger() {
        return KodeinAware.DefaultImpls.getKodeinTrigger(this);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        String string;
        Intent intent = getIntent();
        Intrinsics.checkExpressionValueIsNotNull(intent, "intent");
        Bundle extras = intent.getExtras();
        boolean z = extras != null ? extras.getBoolean("useDebugLog") : false;
        Intent intent2 = getIntent();
        Intrinsics.checkExpressionValueIsNotNull(intent2, "intent");
        Bundle extras2 = intent2.getExtras();
        SravniNetworkConfiguration sravniNetworkConfiguration = (extras2 == null || (string = extras2.getString("sravniNetworkConfiguration")) == null) ? null : (SravniNetworkConfiguration) a.i2(string, SravniNetworkConfiguration.class);
        setTheme(R.style.SravniAppTheme);
        super.onCreate(bundle);
        setKodein(Kodein.Companion.invoke$default(Kodein.Companion, false, new e(this, z, sravniNetworkConfiguration), 1, null));
        setContentView(R.layout.activity_sravni_chat_sravni);
        this.g = (IMainActivityLifecycleListener) KodeinAwareKt.getDirect(this).getDkodein().Instance(TypesKt.TT(new TypeReference<IMainActivityLifecycleListener>() { // from class: ru.sravni.android.bankproduct.SravniChatActivity$onCreate$$inlined$instance$1
        }), null);
        IMainNavigationController iMainNavigationController = (IMainNavigationController) KodeinAwareKt.getDirect(this).getDkodein().Instance(TypesKt.TT(new TypeReference<IMainNavigationController>() { // from class: ru.sravni.android.bankproduct.SravniChatActivity$onCreate$$inlined$instance$2
        }), null);
        this.h = iMainNavigationController;
        if (iMainNavigationController == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mainNavigationController");
        }
        iMainNavigationController.init();
        KodeinProperty Instance = KodeinAwareKt.Instance(this, TypesKt.TT(new TypeReference<IErrorViewModel>() { // from class: ru.sravni.android.bankproduct.SravniChatActivity$onCreate$$inlined$instance$3
        }), null);
        KProperty<? extends Object>[] kPropertyArr = k;
        Lazy provideDelegate = Instance.provideDelegate(null, kPropertyArr[0]);
        Lazy provideDelegate2 = KodeinAwareKt.Instance(this, TypesKt.TT(new TypeReference<String>() { // from class: ru.sravni.android.bankproduct.SravniChatActivity$onCreate$$inlined$instance$4
        }), TypesKt.TT(new TypeReference<IThrowableWrapper>() { // from class: ru.sravni.android.bankproduct.SravniChatActivity$onCreate$$inlined$instance$5
        }), null, new Function0<String>("util") { // from class: ru.sravni.android.bankproduct.SravniChatActivity$onCreate$$inlined$instance$6
            public final /* synthetic */ Object a;

            {
                this.a = r1;
            }

            /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, java.lang.String] */
            /* JADX WARNING: Unknown variable types count: 1 */
            @Override // kotlin.jvm.functions.Function0
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.String invoke() {
                /*
                    r1 = this;
                    java.lang.Object r0 = r1.a
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: ru.sravni.android.bankproduct.SravniChatActivity$onCreate$$inlined$instance$6.invoke():java.lang.Object");
            }
        }).provideDelegate(null, kPropertyArr[1]);
        Lazy provideDelegate3 = KodeinAwareKt.Instance(this, TypesKt.TT(new TypeReference<IErrorLogger>() { // from class: ru.sravni.android.bankproduct.SravniChatActivity$onCreate$$inlined$instance$7
        }), null).provideDelegate(null, kPropertyArr[2]);
        Lazy provideDelegate4 = KodeinAwareKt.Instance(this, TypesKt.TT(new TypeReference<IKeyboardSignalSender>() { // from class: ru.sravni.android.bankproduct.SravniChatActivity$onCreate$$inlined$instance$8
        }), null).provideDelegate(null, kPropertyArr[3]);
        Lazy provideDelegate5 = KodeinAwareKt.Instance(this, TypesKt.TT(new TypeReference<ISnackBarViewModel>() { // from class: ru.sravni.android.bankproduct.SravniChatActivity$onCreate$$inlined$instance$9
        }), null).provideDelegate(null, kPropertyArr[4]);
        this.d = new NetworkChangeReceiver(this);
        ((IKeyboardSignalSender) provideDelegate4.getValue()).getKeyboardState().observe(this, new a7.c.a.a.a(this, (IErrorLogger) provideDelegate3.getValue(), (IThrowableWrapper) provideDelegate2.getValue()));
        ((IErrorViewModel) provideDelegate.getValue()).getShowDialogError().observe(this, new f(this));
        ((IErrorViewModel) provideDelegate.getValue()).getShowSnackBarError().observe(this, new a7.c.a.a.g(this));
        ((ISnackBarViewModel) provideDelegate5.getValue()).getSnackBarMessageLiveData().observe(this, new h(this));
        ((ITokenRefreshDialogSignal) KodeinAwareKt.Instance(this, TypesKt.TT(new TypeReference<ITokenRefreshDialogSignal>() { // from class: ru.sravni.android.bankproduct.SravniChatActivity$tokenRefreshDialogShowHandle$$inlined$instance$1
        }), null).provideDelegate(null, kPropertyArr[5]).getValue()).getShowRefreshTokenDialogSignal().observe(this, new i(this));
        IMainActivityLifecycleListener iMainActivityLifecycleListener = this.g;
        if (iMainActivityLifecycleListener == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mainActivityListener");
        }
        iMainActivityLifecycleListener.onCreate(this);
        if (Build.VERSION.SDK_INT < 23) {
            Window window = getWindow();
            Intrinsics.checkExpressionValueIsNotNull(window, "window");
            window.setStatusBarColor(ContextCompat.getColor(this, R.color.overlay_28));
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        IMainActivityLifecycleListener iMainActivityLifecycleListener = this.g;
        if (iMainActivityLifecycleListener == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mainActivityListener");
        }
        iMainActivityLifecycleListener.onDestroy(this);
        super.onDestroy();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        IMainActivityLifecycleListener iMainActivityLifecycleListener = this.g;
        if (iMainActivityLifecycleListener == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mainActivityListener");
        }
        iMainActivityLifecycleListener.onPause(this);
        super.onPause();
    }

    @Override // android.app.Activity
    public void onRestart() {
        IMainActivityLifecycleListener iMainActivityLifecycleListener = this.g;
        if (iMainActivityLifecycleListener == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mainActivityListener");
        }
        iMainActivityLifecycleListener.onRestart(this);
        super.onRestart();
    }

    @Override // android.app.Activity
    public void onRestoreInstanceState(@Nullable Bundle bundle) {
        ((ITokenInteractor) KodeinAwareKt.Instance(this, TypesKt.TT(new TypeReference<ITokenInteractor>() { // from class: ru.sravni.android.bankproduct.SravniChatActivity$onRestoreInstanceState$$inlined$instance$1
        }), null).provideDelegate(null, k[6]).getValue()).restoreTokenData();
        super.onRestoreInstanceState(bundle);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        IMainActivityLifecycleListener iMainActivityLifecycleListener = this.g;
        if (iMainActivityLifecycleListener == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mainActivityListener");
        }
        iMainActivityLifecycleListener.onResume(this);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        IMainActivityLifecycleListener iMainActivityLifecycleListener = this.g;
        if (iMainActivityLifecycleListener == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mainActivityListener");
        }
        iMainActivityLifecycleListener.onStart(this);
        BroadcastReceiver broadcastReceiver = this.d;
        if (broadcastReceiver == null) {
            Intrinsics.throwUninitializedPropertyAccessException("networkReceiver");
        }
        registerReceiver(broadcastReceiver, new IntentFilter(NetworkChangeReceiver.CONNECTIVITY_ACTION));
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        IMainActivityLifecycleListener iMainActivityLifecycleListener = this.g;
        if (iMainActivityLifecycleListener == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mainActivityListener");
        }
        iMainActivityLifecycleListener.onStop(this);
        BroadcastReceiver broadcastReceiver = this.d;
        if (broadcastReceiver == null) {
            Intrinsics.throwUninitializedPropertyAccessException("networkReceiver");
        }
        unregisterReceiver(broadcastReceiver);
        super.onStop();
    }

    @Override // androidx.appcompat.app.AppCompatActivity
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override // ru.sravni.android.bankproduct.utils.snackbar.ITopSnackbarShower
    public void removeTopSnackbar() {
        TSnackbar tSnackbar = this.e;
        if (tSnackbar != null) {
            tSnackbar.dismiss();
        }
    }

    public void setKodein(@NotNull Kodein kodein2) {
        Intrinsics.checkParameterIsNotNull(kodein2, "<set-?>");
        this.kodein = kodein2;
    }

    @Override // ru.sravni.android.bankproduct.utils.snackbar.IBottomSnackbarShower
    public void showBottomSnackbar(@NotNull SnackbarData snackbarData) {
        Intrinsics.checkParameterIsNotNull(snackbarData, "snackbarData");
        Snackbar snackbar = this.f;
        if (snackbar == null || (snackbar != null && !snackbar.isShown())) {
            int duration = snackbarData.getDuration();
            Snackbar make = Snackbar.make(findViewById(16908290), snackbarData.getMessage(), duration);
            Intrinsics.checkExpressionValueIsNotNull(make, "Snackbar.make(findViewBy…content), text, duration)");
            this.f = make;
            if (make != null) {
                make.show();
            }
        }
    }

    @Override // ru.sravni.android.bankproduct.utils.snackbar.ITopSnackbarShower
    public void showTopSnackbar(int i2, @NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "text");
        TSnackbar tSnackbar = this.e;
        if (tSnackbar == null || (tSnackbar != null && !tSnackbar.isShown())) {
            TSnackbar make = TSnackbar.make(findViewById(16908290), str, i2);
            Intrinsics.checkExpressionValueIsNotNull(make, "TSnackbar.make(findViewB…content), text, duration)");
            View view = make.getView();
            Intrinsics.checkExpressionValueIsNotNull(view, "snackBar.view");
            view.setBackgroundColor(SupportMenu.CATEGORY_MASK);
            View findViewById = view.findViewById(R.id.snackbar_text);
            if (findViewById != null) {
                TextView textView = (TextView) findViewById;
                textView.setTextColor(-1);
                textView.setGravity(17);
                this.e = make;
                if (make != null) {
                    make.show();
                    return;
                }
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type android.widget.TextView");
        }
    }
}
