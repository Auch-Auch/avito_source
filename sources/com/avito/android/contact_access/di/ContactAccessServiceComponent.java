package com.avito.android.contact_access.di;

import android.content.res.Resources;
import android.os.Bundle;
import com.avito.android.contact_access.ContactAccessServiceArguments;
import com.avito.android.contact_access.ContactAccessServiceFragment;
import com.avito.android.di.PerFragment;
import dagger.BindsInstance;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/contact_access/di/ContactAccessServiceComponent;", "", "Lcom/avito/android/contact_access/ContactAccessServiceFragment;", "contactAccessServiceFragment", "", "inject", "(Lcom/avito/android/contact_access/ContactAccessServiceFragment;)V", "Builder", "contact-access_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {ContactAccessDependencies.class}, modules = {ContactAccessServiceModule.class})
@PerFragment
public interface ContactAccessServiceComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006H'¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\f\u001a\u00020\u00002\b\u0010\u000b\u001a\u0004\u0018\u00010\nH'¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000eH'¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H&¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/avito/android/contact_access/di/ContactAccessServiceComponent$Builder;", "", "Lcom/avito/android/contact_access/di/ContactAccessDependencies;", "dependencies", "dependentOn", "(Lcom/avito/android/contact_access/di/ContactAccessDependencies;)Lcom/avito/android/contact_access/di/ContactAccessServiceComponent$Builder;", "Lcom/avito/android/contact_access/ContactAccessServiceArguments;", "args", "withArgs", "(Lcom/avito/android/contact_access/ContactAccessServiceArguments;)Lcom/avito/android/contact_access/di/ContactAccessServiceComponent$Builder;", "Landroid/os/Bundle;", "state", "withState", "(Landroid/os/Bundle;)Lcom/avito/android/contact_access/di/ContactAccessServiceComponent$Builder;", "Landroid/content/res/Resources;", "resources", "withResources", "(Landroid/content/res/Resources;)Lcom/avito/android/contact_access/di/ContactAccessServiceComponent$Builder;", "Lcom/avito/android/contact_access/di/ContactAccessServiceComponent;", "build", "()Lcom/avito/android/contact_access/di/ContactAccessServiceComponent;", "contact-access_release"}, k = 1, mv = {1, 4, 2})
    @Component.Builder
    public interface Builder {
        @NotNull
        ContactAccessServiceComponent build();

        @NotNull
        Builder dependentOn(@NotNull ContactAccessDependencies contactAccessDependencies);

        @BindsInstance
        @NotNull
        Builder withArgs(@NotNull ContactAccessServiceArguments contactAccessServiceArguments);

        @BindsInstance
        @NotNull
        Builder withResources(@NotNull Resources resources);

        @BindsInstance
        @NotNull
        Builder withState(@Nullable Bundle bundle);
    }

    void inject(@NotNull ContactAccessServiceFragment contactAccessServiceFragment);
}
