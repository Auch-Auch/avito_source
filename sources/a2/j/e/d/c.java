package a2.j.e.d;

import com.google.firebase.crashlytics.internal.Onboarding;
import com.google.firebase.crashlytics.internal.common.CrashlyticsCore;
import com.google.firebase.crashlytics.internal.settings.SettingsController;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
public class c implements Callable<Void> {
    public final /* synthetic */ Onboarding a;
    public final /* synthetic */ ExecutorService b;
    public final /* synthetic */ SettingsController c;
    public final /* synthetic */ boolean d;
    public final /* synthetic */ CrashlyticsCore e;

    public c(Onboarding onboarding, ExecutorService executorService, SettingsController settingsController, boolean z, CrashlyticsCore crashlyticsCore) {
        this.a = onboarding;
        this.b = executorService;
        this.c = settingsController;
        this.d = z;
        this.e = crashlyticsCore;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.concurrent.Callable
    public Void call() throws Exception {
        this.a.doOnboarding(this.b, this.c);
        if (!this.d) {
            return null;
        }
        this.e.doBackgroundInitializationAsync(this.c);
        return null;
    }
}
