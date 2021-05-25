package com.avito.android.notification_center.list.item;

import com.avito.android.notification_center.list.item.NotificationCenterListItem;
import com.jakewharton.rxrelay2.PublishRelay;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class ErrorSnippetItemPresenterImpl_Factory implements Factory<ErrorSnippetItemPresenterImpl> {
    public final Provider<PublishRelay<NotificationCenterListItem.ErrorSnippet>> a;

    public ErrorSnippetItemPresenterImpl_Factory(Provider<PublishRelay<NotificationCenterListItem.ErrorSnippet>> provider) {
        this.a = provider;
    }

    public static ErrorSnippetItemPresenterImpl_Factory create(Provider<PublishRelay<NotificationCenterListItem.ErrorSnippet>> provider) {
        return new ErrorSnippetItemPresenterImpl_Factory(provider);
    }

    public static ErrorSnippetItemPresenterImpl newInstance(PublishRelay<NotificationCenterListItem.ErrorSnippet> publishRelay) {
        return new ErrorSnippetItemPresenterImpl(publishRelay);
    }

    @Override // javax.inject.Provider
    public ErrorSnippetItemPresenterImpl get() {
        return newInstance(this.a.get());
    }
}
