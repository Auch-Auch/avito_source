package a2.a.a.j.a;

import android.app.Application;
import com.avito.android.app.task.ApplicationBlockingStartupTask;
import com.avito.android.app.task.ApplicationStartupTask;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
public final class b extends Lambda implements Function0<ApplicationStartupTask.ExecutionResult> {
    public final /* synthetic */ ApplicationBlockingStartupTask a;
    public final /* synthetic */ Application b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(ApplicationBlockingStartupTask applicationBlockingStartupTask, Application application) {
        super(0);
        this.a = applicationBlockingStartupTask;
        this.b = application;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public ApplicationStartupTask.ExecutionResult invoke() {
        return this.a.execute(this.b);
    }
}
