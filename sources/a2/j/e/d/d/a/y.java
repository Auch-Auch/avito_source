package a2.j.e.d.d.a;

import a2.j.e.d.d.a.i0;
import androidx.annotation.NonNull;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.common.Utils;
import com.google.firebase.crashlytics.internal.settings.SettingsDataProvider;
import java.util.Date;
public class y implements i0.a {
    public final /* synthetic */ u a;

    public y(u uVar) {
        this.a = uVar;
    }

    public void a(@NonNull SettingsDataProvider settingsDataProvider, @NonNull Thread thread, @NonNull Throwable th) {
        u uVar = this.a;
        synchronized (uVar) {
            Logger logger = Logger.getLogger();
            logger.d("Crashlytics is handling uncaught exception \"" + th + "\" from thread " + thread.getName());
            try {
                Utils.awaitEvenIfOnMainThread(uVar.f.c(new a0(uVar, new Date(), th, thread, settingsDataProvider)));
            } catch (Exception unused) {
            }
        }
    }
}
