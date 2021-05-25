package ru.sravni.android.bankproduct.presentation.main;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.browser.trusted.TrustedWebActivityIntentBuilder;
import androidx.lifecycle.Observer;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.NavOptions;
import com.avito.android.remote.auth.AuthSource;
import com.google.androidbrowserhelper.trusted.TwaLauncher;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.sravni.android.bankproduct.SravniChatActivity;
import ru.sravni.android.bankproduct.domain.analytic.IErrorLogger;
import ru.sravni.android.bankproduct.domain.analytic.entity.MessagePriority;
import ru.sravni.android.bankproduct.domain.sravnierror.IThrowableWrapper;
import ru.sravni.android.bankproduct.presentation.main.viewmodel.INavigationViewModel;
import ru.sravni.android.bankproduct.utils.keyboard.IKeyboardHider;
import ru.sravni.android.bankproduct.utils.navigation.DataForNavigation;
import ru.sravni.android.bankproduct.utils.navigation.DataForPopBack;
import ru.sravni.android.bankproduct.utils.navigation.INavigatorKt;
import ru.sravni.android.bankproduct.utils.navigation.entity.DataForOpenWeb;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u001c\u001a\u00020\u0019\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u0012\u0006\u0010\u0018\u001a\u00020\u0015\u0012\u0006\u0010\u0010\u001a\u00020\r¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b¨\u0006\u001f"}, d2 = {"Lru/sravni/android/bankproduct/presentation/main/MainNavigationController;", "Lru/sravni/android/bankproduct/presentation/main/IMainNavigationController;", "", "init", "()V", "Lru/sravni/android/bankproduct/utils/keyboard/IKeyboardHider;", "c", "Lru/sravni/android/bankproduct/utils/keyboard/IKeyboardHider;", "keyboardHider", "Lru/sravni/android/bankproduct/presentation/main/viewmodel/INavigationViewModel;", AuthSource.BOOKING_ORDER, "Lru/sravni/android/bankproduct/presentation/main/viewmodel/INavigationViewModel;", "navigationViewModel", "Landroidx/navigation/NavController;", "f", "Landroidx/navigation/NavController;", "navController", "Lru/sravni/android/bankproduct/domain/analytic/IErrorLogger;", "d", "Lru/sravni/android/bankproduct/domain/analytic/IErrorLogger;", "errorLogger", "Lru/sravni/android/bankproduct/domain/sravnierror/IThrowableWrapper;", "e", "Lru/sravni/android/bankproduct/domain/sravnierror/IThrowableWrapper;", "errorWrapper", "Landroidx/appcompat/app/AppCompatActivity;", AuthSource.SEND_ABUSE, "Landroidx/appcompat/app/AppCompatActivity;", "activity", "<init>", "(Landroidx/appcompat/app/AppCompatActivity;Lru/sravni/android/bankproduct/presentation/main/viewmodel/INavigationViewModel;Lru/sravni/android/bankproduct/utils/keyboard/IKeyboardHider;Lru/sravni/android/bankproduct/domain/analytic/IErrorLogger;Lru/sravni/android/bankproduct/domain/sravnierror/IThrowableWrapper;Landroidx/navigation/NavController;)V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class MainNavigationController implements IMainNavigationController {
    public final AppCompatActivity a;
    public final INavigationViewModel b;
    public final IKeyboardHider c;
    public final IErrorLogger d;
    public final IThrowableWrapper e;
    public final NavController f;

    public static final class a<T> implements Observer<DataForNavigation> {
        public final /* synthetic */ MainNavigationController a;

        public a(MainNavigationController mainNavigationController) {
            this.a = mainNavigationController;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // androidx.lifecycle.Observer
        public void onChanged(DataForNavigation dataForNavigation) {
            DataForNavigation dataForNavigation2 = dataForNavigation;
            MainNavigationController mainNavigationController = this.a;
            Intrinsics.checkExpressionValueIsNotNull(dataForNavigation2, "it");
            MainNavigationController.access$route(mainNavigationController, dataForNavigation2);
        }
    }

    public static final class b<T> implements Observer<DataForPopBack> {
        public final /* synthetic */ MainNavigationController a;

        public b(MainNavigationController mainNavigationController) {
            this.a = mainNavigationController;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // androidx.lifecycle.Observer
        public void onChanged(DataForPopBack dataForPopBack) {
            DataForPopBack dataForPopBack2 = dataForPopBack;
            MainNavigationController mainNavigationController = this.a;
            Intrinsics.checkExpressionValueIsNotNull(dataForPopBack2, "it");
            MainNavigationController.access$popBack(mainNavigationController, dataForPopBack2);
        }
    }

    public static final class c<T> implements Observer<Integer> {
        public final /* synthetic */ MainNavigationController a;

        public c(MainNavigationController mainNavigationController) {
            this.a = mainNavigationController;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // androidx.lifecycle.Observer
        public void onChanged(Integer num) {
            MainNavigationController.access$restartActivity(this.a);
        }
    }

    public static final class d<T> implements Observer<DataForOpenWeb> {
        public final /* synthetic */ MainNavigationController a;

        public d(MainNavigationController mainNavigationController) {
            this.a = mainNavigationController;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // androidx.lifecycle.Observer
        public void onChanged(DataForOpenWeb dataForOpenWeb) {
            DataForOpenWeb dataForOpenWeb2 = dataForOpenWeb;
            MainNavigationController mainNavigationController = this.a;
            Intrinsics.checkExpressionValueIsNotNull(dataForOpenWeb2, "it");
            MainNavigationController.access$openWeb(mainNavigationController, dataForOpenWeb2);
        }
    }

    public static final class e<T> implements Observer<Unit> {
        public final /* synthetic */ MainNavigationController a;

        public e(MainNavigationController mainNavigationController) {
            this.a = mainNavigationController;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // androidx.lifecycle.Observer
        public void onChanged(Unit unit) {
            this.a.f.popBackStack();
        }
    }

    public static final class f implements NavController.OnDestinationChangedListener {
        public final /* synthetic */ MainNavigationController a;

        public f(MainNavigationController mainNavigationController) {
            this.a = mainNavigationController;
        }

        @Override // androidx.navigation.NavController.OnDestinationChangedListener
        public final void onDestinationChanged(@NotNull NavController navController, @NotNull NavDestination navDestination, @Nullable Bundle bundle) {
            Intrinsics.checkParameterIsNotNull(navController, "controller");
            Intrinsics.checkParameterIsNotNull(navDestination, "destination");
            this.a.c.hideKeyboard();
        }
    }

    public MainNavigationController(@NotNull AppCompatActivity appCompatActivity, @NotNull INavigationViewModel iNavigationViewModel, @NotNull IKeyboardHider iKeyboardHider, @NotNull IErrorLogger iErrorLogger, @NotNull IThrowableWrapper iThrowableWrapper, @NotNull NavController navController) {
        Intrinsics.checkParameterIsNotNull(appCompatActivity, "activity");
        Intrinsics.checkParameterIsNotNull(iNavigationViewModel, "navigationViewModel");
        Intrinsics.checkParameterIsNotNull(iKeyboardHider, "keyboardHider");
        Intrinsics.checkParameterIsNotNull(iErrorLogger, "errorLogger");
        Intrinsics.checkParameterIsNotNull(iThrowableWrapper, "errorWrapper");
        Intrinsics.checkParameterIsNotNull(navController, "navController");
        this.a = appCompatActivity;
        this.b = iNavigationViewModel;
        this.c = iKeyboardHider;
        this.d = iErrorLogger;
        this.e = iThrowableWrapper;
        this.f = navController;
    }

    public static final void access$openWeb(MainNavigationController mainNavigationController, DataForOpenWeb dataForOpenWeb) {
        Objects.requireNonNull(mainNavigationController);
        TrustedWebActivityIntentBuilder colorScheme = new TrustedWebActivityIntentBuilder(dataForOpenWeb.getUri()).setColorScheme(1);
        Intrinsics.checkExpressionValueIsNotNull(colorScheme, "TrustedWebActivityIntent…ntent.COLOR_SCHEME_LIGHT)");
        try {
            new TwaLauncher(mainNavigationController.a).launch(colorScheme, null, dataForOpenWeb.getCompletionCallback());
        } catch (Throwable th) {
            mainNavigationController.d.logError(MessagePriority.ERROR, mainNavigationController.e.wrap(th));
        }
    }

    public static final void access$popBack(MainNavigationController mainNavigationController, DataForPopBack dataForPopBack) {
        mainNavigationController.f.popBackStack(dataForPopBack.getScreenId(), dataForPopBack.getInclusive());
    }

    public static final void access$restartActivity(MainNavigationController mainNavigationController) {
        Objects.requireNonNull(mainNavigationController);
        Intent intent = new Intent(mainNavigationController.a, SravniChatActivity.class);
        Intent intent2 = mainNavigationController.a.getIntent();
        Intrinsics.checkExpressionValueIsNotNull(intent2, "activity.intent");
        Bundle extras = intent2.getExtras();
        if (extras == null) {
            extras = new Bundle();
        }
        intent.putExtras(extras);
        mainNavigationController.a.finish();
        mainNavigationController.a.startActivity(intent);
    }

    public static final void access$route(MainNavigationController mainNavigationController, DataForNavigation dataForNavigation) {
        Objects.requireNonNull(mainNavigationController);
        String argumentJson = dataForNavigation.getArgumentJson();
        NavOptions navOptions = null;
        Bundle y1 = argumentJson != null ? a2.b.a.a.a.y1(INavigatorKt.NAV_PARAMETER_NAME, argumentJson) : null;
        NavDestination currentDestination = mainNavigationController.f.getCurrentDestination();
        if ((currentDestination != null ? currentDestination.getAction(dataForNavigation.getScreenID()) : null) != null) {
            try {
                NavController navController = mainNavigationController.f;
                int screenID = dataForNavigation.getScreenID();
                NavOptions.Builder navOptions2 = dataForNavigation.getNavOptions();
                if (navOptions2 != null) {
                    navOptions = navOptions2.build();
                }
                navController.navigate(screenID, y1, navOptions);
            } catch (Throwable th) {
                mainNavigationController.d.logError(MessagePriority.ERROR, mainNavigationController.e.wrap(th));
            }
        } else {
            mainNavigationController.d.logError(MessagePriority.WARN, mainNavigationController.e.wrap(new EmptyNavActionError()));
        }
    }

    @Override // ru.sravni.android.bankproduct.presentation.main.IMainNavigationController
    public void init() {
        this.b.getMainNavigationData().observe(this.a, new a(this));
        this.b.getPopBackStackData().observe(this.a, new b(this));
        this.b.getExitFromProfile().observe(this.a, new c(this));
        this.b.getOpenWebData().observe(this.a, new d(this));
        this.b.getBackSignal().observe(this.a, new e(this));
        this.f.addOnDestinationChangedListener(new f(this));
    }
}
