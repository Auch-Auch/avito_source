package com.avito.android.contact_access.di;

import com.avito.android.contact_access.ContactAccessServiceInteractor;
import com.avito.android.contact_access.ContactAccessServiceInteractorImpl;
import com.avito.android.contact_access.ContactAccessServicePresenter;
import com.avito.android.contact_access.ContactAccessServicePresenterImpl;
import com.avito.android.contact_access.IncompleteSocialInteractorImpl;
import com.avito.android.di.PerFragment;
import com.avito.android.social.incomplete.IncompleteSocialInteractor;
import com.avito.android.util.ErrorFormatterImpl;
import com.avito.android.util.Formatter;
import dagger.Binds;
import dagger.Module;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH'¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\rH'¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0011H'¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/avito/android/contact_access/di/ContactAccessServiceModule;", "", "Lcom/avito/android/util/ErrorFormatterImpl;", "formatter", "Lcom/avito/android/util/Formatter;", "", "bindErrorFormatter", "(Lcom/avito/android/util/ErrorFormatterImpl;)Lcom/avito/android/util/Formatter;", "Lcom/avito/android/contact_access/IncompleteSocialInteractorImpl;", "interactor", "Lcom/avito/android/social/incomplete/IncompleteSocialInteractor;", "bindIncompleteSocialInteractor", "(Lcom/avito/android/contact_access/IncompleteSocialInteractorImpl;)Lcom/avito/android/social/incomplete/IncompleteSocialInteractor;", "Lcom/avito/android/contact_access/ContactAccessServiceInteractorImpl;", "Lcom/avito/android/contact_access/ContactAccessServiceInteractor;", "bindContactAccessServiceInteractor", "(Lcom/avito/android/contact_access/ContactAccessServiceInteractorImpl;)Lcom/avito/android/contact_access/ContactAccessServiceInteractor;", "Lcom/avito/android/contact_access/ContactAccessServicePresenterImpl;", "presenter", "Lcom/avito/android/contact_access/ContactAccessServicePresenter;", "bindContactAccessServicePresenter", "(Lcom/avito/android/contact_access/ContactAccessServicePresenterImpl;)Lcom/avito/android/contact_access/ContactAccessServicePresenter;", "contact-access_release"}, k = 1, mv = {1, 4, 2})
@Module
public interface ContactAccessServiceModule {
    @PerFragment
    @Binds
    @NotNull
    ContactAccessServiceInteractor bindContactAccessServiceInteractor(@NotNull ContactAccessServiceInteractorImpl contactAccessServiceInteractorImpl);

    @PerFragment
    @Binds
    @NotNull
    ContactAccessServicePresenter bindContactAccessServicePresenter(@NotNull ContactAccessServicePresenterImpl contactAccessServicePresenterImpl);

    @Binds
    @NotNull
    @PerFragment
    Formatter<Throwable> bindErrorFormatter(@NotNull ErrorFormatterImpl errorFormatterImpl);

    @PerFragment
    @Binds
    @NotNull
    IncompleteSocialInteractor bindIncompleteSocialInteractor(@NotNull IncompleteSocialInteractorImpl incompleteSocialInteractorImpl);
}
