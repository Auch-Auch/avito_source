package a2.a.a.j.a;

import android.app.Application;
import com.avito.android.app.task.ApplicationBackgroundStartupTask;
import com.avito.android.app.task.ApplicationStartupTask;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
public final class a extends Lambda implements Function0<ApplicationStartupTask.ExecutionResult> {
    public final /* synthetic */ ApplicationBackgroundStartupTask a;
    public final /* synthetic */ Application b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(ApplicationBackgroundStartupTask applicationBackgroundStartupTask, Application application) {
        super(0);
        this.a = applicationBackgroundStartupTask;
        this.b = application;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public ApplicationStartupTask.ExecutionResult invoke() {
        this.a.execute(this.b);
        return ApplicationStartupTask.ExecutionResult.Success.INSTANCE;
    }
}
