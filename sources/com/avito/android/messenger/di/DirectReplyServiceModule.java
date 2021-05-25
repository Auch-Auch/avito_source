package com.avito.android.messenger.di;

import com.avito.android.di.PerService;
import com.avito.android.messenger.service.direct_reply.DirectReplyServiceDelegate;
import com.avito.android.messenger.service.direct_reply.DirectReplyServiceDelegateImpl;
import com.avito.android.messenger.service.direct_reply.DirectReplyServiceInteractor;
import com.avito.android.messenger.service.direct_reply.DirectReplyServiceInteractorImpl;
import dagger.Binds;
import dagger.Module;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/messenger/di/DirectReplyServiceModule;", "", "Lcom/avito/android/messenger/service/direct_reply/DirectReplyServiceInteractorImpl;", "interactor", "Lcom/avito/android/messenger/service/direct_reply/DirectReplyServiceInteractor;", "bindDirectReplyServiceInteractor", "(Lcom/avito/android/messenger/service/direct_reply/DirectReplyServiceInteractorImpl;)Lcom/avito/android/messenger/service/direct_reply/DirectReplyServiceInteractor;", "Lcom/avito/android/messenger/service/direct_reply/DirectReplyServiceDelegateImpl;", "delegate", "Lcom/avito/android/messenger/service/direct_reply/DirectReplyServiceDelegate;", "bindDirectReplyServiceDelegate", "(Lcom/avito/android/messenger/service/direct_reply/DirectReplyServiceDelegateImpl;)Lcom/avito/android/messenger/service/direct_reply/DirectReplyServiceDelegate;", "messenger_release"}, k = 1, mv = {1, 4, 2})
@Module
public interface DirectReplyServiceModule {
    @PerService
    @Binds
    @NotNull
    DirectReplyServiceDelegate bindDirectReplyServiceDelegate(@NotNull DirectReplyServiceDelegateImpl directReplyServiceDelegateImpl);

    @PerService
    @Binds
    @NotNull
    DirectReplyServiceInteractor bindDirectReplyServiceInteractor(@NotNull DirectReplyServiceInteractorImpl directReplyServiceInteractorImpl);
}
