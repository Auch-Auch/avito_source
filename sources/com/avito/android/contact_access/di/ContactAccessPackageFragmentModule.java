package com.avito.android.contact_access.di;

import com.avito.android.contact_access.ContactAccessPackageInteractor;
import com.avito.android.contact_access.ContactAccessPackageInteractorImpl;
import com.avito.android.contact_access.ContactAccessPackagePresenter;
import com.avito.android.contact_access.ContactAccessPackagePresenterImpl;
import com.avito.android.di.PerFragment;
import com.avito.android.util.ErrorFormatterImpl;
import com.avito.android.util.Formatter;
import dagger.Binds;
import dagger.Module;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH'¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH'¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/avito/android/contact_access/di/ContactAccessPackageFragmentModule;", "", "Lcom/avito/android/util/ErrorFormatterImpl;", "formatter", "Lcom/avito/android/util/Formatter;", "", "bindErrorFormatter", "(Lcom/avito/android/util/ErrorFormatterImpl;)Lcom/avito/android/util/Formatter;", "Lcom/avito/android/contact_access/ContactAccessPackageInteractorImpl;", "interactor", "Lcom/avito/android/contact_access/ContactAccessPackageInteractor;", "bindContactAccessPackageInteractor", "(Lcom/avito/android/contact_access/ContactAccessPackageInteractorImpl;)Lcom/avito/android/contact_access/ContactAccessPackageInteractor;", "Lcom/avito/android/contact_access/ContactAccessPackagePresenterImpl;", "presenter", "Lcom/avito/android/contact_access/ContactAccessPackagePresenter;", "bindContactAccessPackagePresenter", "(Lcom/avito/android/contact_access/ContactAccessPackagePresenterImpl;)Lcom/avito/android/contact_access/ContactAccessPackagePresenter;", "contact-access_release"}, k = 1, mv = {1, 4, 2})
@Module
public interface ContactAccessPackageFragmentModule {
    @PerFragment
    @Binds
    @NotNull
    ContactAccessPackageInteractor bindContactAccessPackageInteractor(@NotNull ContactAccessPackageInteractorImpl contactAccessPackageInteractorImpl);

    @PerFragment
    @Binds
    @NotNull
    ContactAccessPackagePresenter bindContactAccessPackagePresenter(@NotNull ContactAccessPackagePresenterImpl contactAccessPackagePresenterImpl);

    @Binds
    @NotNull
    @PerFragment
    Formatter<Throwable> bindErrorFormatter(@NotNull ErrorFormatterImpl errorFormatterImpl);
}
