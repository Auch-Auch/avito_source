package com.avito.android.advert.cpo_program.di;

import com.avito.android.ServiceIntentFactory;
import com.avito.android.di.CoreComponentDependencies;
import com.avito.android.search.subscriptions.sync.SearchSubscriptionSyncRunner;
import com.avito.android.user_advert.UserAdvertsInfoUpdateRunner;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/avito/android/advert/cpo_program/di/AutotekaCpoProgramDependencies;", "Lcom/avito/android/di/CoreComponentDependencies;", "Lcom/avito/android/ServiceIntentFactory;", "serviceIntentFactory", "()Lcom/avito/android/ServiceIntentFactory;", "Lcom/avito/android/search/subscriptions/sync/SearchSubscriptionSyncRunner;", "searchSubscriptionSyncRunner", "()Lcom/avito/android/search/subscriptions/sync/SearchSubscriptionSyncRunner;", "Lcom/avito/android/user_advert/UserAdvertsInfoUpdateRunner;", "userAdvertsInfoUpdateRunner", "()Lcom/avito/android/user_advert/UserAdvertsInfoUpdateRunner;", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public interface AutotekaCpoProgramDependencies extends CoreComponentDependencies {
    @Override // com.avito.android.feedback_adverts.di.FeedbackAdvertsDependencies
    @NotNull
    SearchSubscriptionSyncRunner searchSubscriptionSyncRunner();

    @Override // com.avito.android.advert.closed.di.ClosedAdvertDependencies, com.avito.android.feedback_adverts.di.FeedbackAdvertsDependencies
    @NotNull
    ServiceIntentFactory serviceIntentFactory();

    @Override // com.avito.android.advert.closed.di.ClosedAdvertDependencies, com.avito.android.feedback_adverts.di.FeedbackAdvertsDependencies
    @NotNull
    UserAdvertsInfoUpdateRunner userAdvertsInfoUpdateRunner();
}
