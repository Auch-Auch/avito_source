package com.avito.android.app.task;

import android.app.Application;
import com.avito.android.app.task.ApplicationBlockingStartupTask;
import com.avito.android.app.task.ApplicationStartupTask;
import com.avito.android.util.BuildInfo;
import com.avito.konveyor.konveyorConfiguration;
import com.avito.konveyor.validation.ValidationPolicy;
import com.google.android.exoplayer2.util.MimeTypes;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\b\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/avito/android/app/task/ConveyorConfigurationTask;", "Lcom/avito/android/app/task/ApplicationBlockingStartupTask;", "Landroid/app/Application;", MimeTypes.BASE_TYPE_APPLICATION, "Lcom/avito/android/app/task/ApplicationStartupTask$ExecutionResult;", "execute", "(Landroid/app/Application;)Lcom/avito/android/app/task/ApplicationStartupTask$ExecutionResult;", "Lcom/avito/android/util/BuildInfo;", "buildInfo", "Lcom/avito/android/util/BuildInfo;", "<init>", "(Lcom/avito/android/util/BuildInfo;)V", "application_release"}, k = 1, mv = {1, 4, 2})
public class ConveyorConfigurationTask implements ApplicationBlockingStartupTask {
    public final BuildInfo buildInfo;

    @Inject
    public ConveyorConfigurationTask(@NotNull BuildInfo buildInfo2) {
        Intrinsics.checkNotNullParameter(buildInfo2, "buildInfo");
        this.buildInfo = buildInfo2;
    }

    @Override // com.avito.android.app.task.ApplicationBlockingStartupTask
    @NotNull
    public ApplicationStartupTask.ExecutionResult execute(@NotNull Application application) {
        Intrinsics.checkNotNullParameter(application, MimeTypes.BASE_TYPE_APPLICATION);
        konveyorConfiguration.INSTANCE.setConfigurationPolicy(new ValidationPolicy(this) { // from class: com.avito.android.app.task.ConveyorConfigurationTask$execute$1
            public boolean a;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.a = ConveyorConfigurationTask.access$getBuildInfo$p(r1).isDebug();
            }

            @Override // com.avito.konveyor.validation.ValidationPolicy
            public boolean getValidateEagerly() {
                return this.a;
            }

            @Override // com.avito.konveyor.validation.ValidationPolicy
            public void setValidateEagerly(boolean z) {
                this.a = z;
            }
        });
        return ApplicationStartupTask.ExecutionResult.Success.INSTANCE;
    }

    @Override // com.avito.android.app.task.ApplicationBlockingStartupTask
    @NotNull
    public ApplicationBlockingStartupTask.Priority getPriority() {
        return ApplicationBlockingStartupTask.DefaultImpls.getPriority(this);
    }
}
