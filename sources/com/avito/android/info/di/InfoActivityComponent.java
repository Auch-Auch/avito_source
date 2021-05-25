package com.avito.android.info.di;

import android.os.Bundle;
import com.avito.android.di.PerActivity;
import com.avito.android.info.di.InfoActivityModule;
import com.avito.android.info.ui.InfoActivity;
import dagger.BindsInstance;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.android.persistence.messenger.MessageMetaInfo;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/info/di/InfoActivityComponent;", "", "Lcom/avito/android/info/ui/InfoActivity;", "infoActivity", "", "inject", "(Lcom/avito/android/info/ui/InfoActivity;)V", "Builder", "info_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {InfoActivityDependencies.class}, modules = {InfoActivityModule.class})
@PerActivity
public interface InfoActivityComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\b\u001a\u00020\u00002\b\b\u0001\u0010\u0007\u001a\u00020\u0006H'¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\u000b\u001a\u00020\u00002\b\b\u0001\u0010\n\u001a\u00020\u0006H'¢\u0006\u0004\b\u000b\u0010\tJ\u001b\u0010\u000e\u001a\u00020\u00002\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\fH'¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H&¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/avito/android/info/di/InfoActivityComponent$Builder;", "", "Lcom/avito/android/info/di/InfoActivityDependencies;", "dependencies", "dependentOn", "(Lcom/avito/android/info/di/InfoActivityDependencies;)Lcom/avito/android/info/di/InfoActivityComponent$Builder;", "", "title", "withTitle", "(Ljava/lang/String;)Lcom/avito/android/info/di/InfoActivityComponent$Builder;", MessageMetaInfo.COLUMN_PATH, "withPath", "Landroid/os/Bundle;", "state", "withState", "(Landroid/os/Bundle;)Lcom/avito/android/info/di/InfoActivityComponent$Builder;", "Lcom/avito/android/info/di/InfoActivityComponent;", "build", "()Lcom/avito/android/info/di/InfoActivityComponent;", "info_release"}, k = 1, mv = {1, 4, 2})
    @Component.Builder
    public interface Builder {
        @NotNull
        InfoActivityComponent build();

        @NotNull
        Builder dependentOn(@NotNull InfoActivityDependencies infoActivityDependencies);

        @BindsInstance
        @NotNull
        Builder withPath(@InfoActivityModule.InfoPath @NotNull String str);

        @BindsInstance
        @NotNull
        Builder withState(@InfoActivityModule.InfoState @Nullable Bundle bundle);

        @BindsInstance
        @NotNull
        Builder withTitle(@InfoActivityModule.InfoTitle @NotNull String str);
    }

    void inject(@NotNull InfoActivity infoActivity);
}
