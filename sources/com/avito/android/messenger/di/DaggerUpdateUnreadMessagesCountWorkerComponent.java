package com.avito.android.messenger.di;

import com.avito.android.account.AccountStateProvider;
import com.avito.android.messenger.UnreadMessagesCounterConsumer;
import com.avito.android.messenger.di.UpdateUnreadMessagesCountWorkerComponent;
import com.avito.android.messenger.service.UpdateUnreadMessagesCountService;
import com.avito.android.messenger.service.UpdateUnreadMessagesCountService_MembersInjector;
import com.avito.android.messenger.service.UpdateUnreadMessagesCountWorker;
import com.avito.android.messenger.service.UpdateUnreadMessagesCountWorker_MembersInjector;
import com.avito.android.preferences.MessengerStorage;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Preconditions;
import ru.avito.messenger.MessengerClient;
public final class DaggerUpdateUnreadMessagesCountWorkerComponent implements UpdateUnreadMessagesCountWorkerComponent {
    public final UpdateUnreadMessagesCountDependencies a;

    public static final class b implements UpdateUnreadMessagesCountWorkerComponent.Builder {
        public UpdateUnreadMessagesCountDependencies a;

        public b(a aVar) {
        }

        @Override // com.avito.android.messenger.di.UpdateUnreadMessagesCountWorkerComponent.Builder
        public UpdateUnreadMessagesCountWorkerComponent build() {
            Preconditions.checkBuilderRequirement(this.a, UpdateUnreadMessagesCountDependencies.class);
            return new DaggerUpdateUnreadMessagesCountWorkerComponent(this.a, null);
        }

        @Override // com.avito.android.messenger.di.UpdateUnreadMessagesCountWorkerComponent.Builder
        public UpdateUnreadMessagesCountWorkerComponent.Builder updateUnreadMessagesCountWorkerDependencies(UpdateUnreadMessagesCountDependencies updateUnreadMessagesCountDependencies) {
            this.a = (UpdateUnreadMessagesCountDependencies) Preconditions.checkNotNull(updateUnreadMessagesCountDependencies);
            return this;
        }
    }

    public DaggerUpdateUnreadMessagesCountWorkerComponent(UpdateUnreadMessagesCountDependencies updateUnreadMessagesCountDependencies, a aVar) {
        this.a = updateUnreadMessagesCountDependencies;
    }

    public static UpdateUnreadMessagesCountWorkerComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.messenger.di.UpdateUnreadMessagesCountWorkerComponent
    public void inject(UpdateUnreadMessagesCountWorker updateUnreadMessagesCountWorker) {
        UpdateUnreadMessagesCountWorker_MembersInjector.injectClient(updateUnreadMessagesCountWorker, (MessengerClient) Preconditions.checkNotNullFromComponent(this.a.messengerClient()));
        UpdateUnreadMessagesCountWorker_MembersInjector.injectUnreadMessagesCounterConsumer(updateUnreadMessagesCountWorker, (UnreadMessagesCounterConsumer) Preconditions.checkNotNullFromComponent(this.a.unreadMessagesCounterConsumer()));
        UpdateUnreadMessagesCountWorker_MembersInjector.injectAccountStateProvider(updateUnreadMessagesCountWorker, (AccountStateProvider) Preconditions.checkNotNullFromComponent(this.a.accountStateProvider()));
        UpdateUnreadMessagesCountWorker_MembersInjector.injectMessengerStorage(updateUnreadMessagesCountWorker, (MessengerStorage) Preconditions.checkNotNullFromComponent(this.a.messengerStorage()));
        UpdateUnreadMessagesCountWorker_MembersInjector.injectSchedulers(updateUnreadMessagesCountWorker, (SchedulersFactory) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory()));
    }

    @Override // com.avito.android.messenger.di.UpdateUnreadMessagesCountWorkerComponent
    public void inject(UpdateUnreadMessagesCountService updateUnreadMessagesCountService) {
        UpdateUnreadMessagesCountService_MembersInjector.injectClient(updateUnreadMessagesCountService, (MessengerClient) Preconditions.checkNotNullFromComponent(this.a.messengerClient()));
        UpdateUnreadMessagesCountService_MembersInjector.injectUnreadMessagesCounterConsumer(updateUnreadMessagesCountService, (UnreadMessagesCounterConsumer) Preconditions.checkNotNullFromComponent(this.a.unreadMessagesCounterConsumer()));
        UpdateUnreadMessagesCountService_MembersInjector.injectAccountStateProvider(updateUnreadMessagesCountService, (AccountStateProvider) Preconditions.checkNotNullFromComponent(this.a.accountStateProvider()));
        UpdateUnreadMessagesCountService_MembersInjector.injectMessengerStorage(updateUnreadMessagesCountService, (MessengerStorage) Preconditions.checkNotNullFromComponent(this.a.messengerStorage()));
        UpdateUnreadMessagesCountService_MembersInjector.injectSchedulers(updateUnreadMessagesCountService, (SchedulersFactory) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory()));
    }
}
