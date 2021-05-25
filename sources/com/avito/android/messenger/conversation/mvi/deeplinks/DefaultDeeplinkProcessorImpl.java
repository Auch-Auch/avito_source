package com.avito.android.messenger.conversation.mvi.deeplinks;

import android.content.Intent;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.util.architecture_components.SingleLiveEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u000e¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0006R\"\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/deeplinks/DefaultDeeplinkProcessorImpl;", "Lcom/avito/android/messenger/conversation/mvi/deeplinks/DefaultDeeplinkProcessor;", "Lcom/avito/android/deep_linking/links/DeepLink;", "deeplink", "", "doProcess", "(Lcom/avito/android/deep_linking/links/DeepLink;)Z", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "Landroid/content/Intent;", "d", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "getOpenScreenIntentStream", "()Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "openScreenIntentStream", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "e", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "deepLinkIntentFactory", "<init>", "(Lcom/avito/android/deep_linking/DeepLinkIntentFactory;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class DefaultDeeplinkProcessorImpl extends DefaultDeeplinkProcessor {
    @NotNull
    public final SingleLiveEvent<Intent> d = new SingleLiveEvent<>();
    public final DeepLinkIntentFactory e;

    public DefaultDeeplinkProcessorImpl(@NotNull DeepLinkIntentFactory deepLinkIntentFactory) {
        Intrinsics.checkNotNullParameter(deepLinkIntentFactory, "deepLinkIntentFactory");
        this.e = deepLinkIntentFactory;
    }

    @Override // com.avito.android.messenger.conversation.mvi.deeplinks.AbstractDeeplinkProcessor
    public boolean doProcess(@NotNull DeepLink deepLink) {
        Intrinsics.checkNotNullParameter(deepLink, "deeplink");
        Intent intent = this.e.getIntent(deepLink);
        if (intent == null) {
            return false;
        }
        getOpenScreenIntentStream().postValue(intent);
        return true;
    }

    @Override // com.avito.android.messenger.conversation.mvi.deeplinks.DefaultDeeplinkProcessor
    @NotNull
    public SingleLiveEvent<Intent> getOpenScreenIntentStream() {
        return this.d;
    }
}
