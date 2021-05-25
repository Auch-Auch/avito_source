package com.avito.android.di.module;

import com.avito.android.async_phone.AsyncPhoneInteractor;
import com.avito.android.async_phone.AsyncPhoneInteractorImpl;
import com.avito.android.async_phone.AsyncPhonePresenter;
import com.avito.android.async_phone.AsyncPhonePresenterImpl;
import com.avito.android.async_phone.AsyncPhoneTracker;
import com.avito.android.async_phone.AsyncPhoneTrackerImpl;
import dagger.Binds;
import dagger.Module;
import dagger.Reusable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\fH'¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/di/module/AsyncPhoneModule;", "", "Lcom/avito/android/async_phone/AsyncPhonePresenterImpl;", "presenter", "Lcom/avito/android/async_phone/AsyncPhonePresenter;", "bindAsyncPhonePresenter", "(Lcom/avito/android/async_phone/AsyncPhonePresenterImpl;)Lcom/avito/android/async_phone/AsyncPhonePresenter;", "Lcom/avito/android/async_phone/AsyncPhoneInteractorImpl;", "interactor", "Lcom/avito/android/async_phone/AsyncPhoneInteractor;", "bindAsyncPhoneInteractor", "(Lcom/avito/android/async_phone/AsyncPhoneInteractorImpl;)Lcom/avito/android/async_phone/AsyncPhoneInteractor;", "Lcom/avito/android/async_phone/AsyncPhoneTrackerImpl;", "Lcom/avito/android/async_phone/AsyncPhoneTracker;", "bindAsyncPhoneTracker", "(Lcom/avito/android/async_phone/AsyncPhoneTrackerImpl;)Lcom/avito/android/async_phone/AsyncPhoneTracker;", "serp-core_release"}, k = 1, mv = {1, 4, 2})
@Module
public interface AsyncPhoneModule {
    @Reusable
    @Binds
    @NotNull
    AsyncPhoneInteractor bindAsyncPhoneInteractor(@NotNull AsyncPhoneInteractorImpl asyncPhoneInteractorImpl);

    @Reusable
    @Binds
    @NotNull
    AsyncPhonePresenter bindAsyncPhonePresenter(@NotNull AsyncPhonePresenterImpl asyncPhonePresenterImpl);

    @Reusable
    @Binds
    @NotNull
    AsyncPhoneTracker bindAsyncPhoneTracker(@NotNull AsyncPhoneTrackerImpl asyncPhoneTrackerImpl);
}
