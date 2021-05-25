package com.avito.android.messenger.conversation.mvi.platform_actions.sample;

import com.avito.android.messenger.conversation.mvi.platform_actions.ChannelData;
import com.avito.android.messenger.conversation.mvi.platform_actions.PlatformActionsStateProducer;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.messenger.context_actions.PlatformActions;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Provider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.x;
import t6.n.y;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u001a\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u0001j\f\u0012\b\u0012\u00060\u0002j\u0002`\u0003`\u0004B\u001b\b\u0007\u0012\u0010\u0010\u0017\u001a\f\u0012\b\u0012\u00060\u0013j\u0002`\u00140\u0012¢\u0006\u0004\b\u0018\u0010\u0019J!\u0010\n\u001a\f\u0012\b\u0012\u00060\bj\u0002`\t0\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\n\u0010\u000bJc\u0010\u0010\u001a*\u0012\b\u0012\u00060\bj\u0002`\t\u0012\u001c\u0012\u001a\u0012\b\u0012\u00060\u0002j\u0002`\u00030\rj\f\u0012\b\u0012\u00060\u0002j\u0002`\u0003`\u000e0\f2\u0006\u0010\u0006\u001a\u00020\u00052\"\u0010\u000f\u001a\u001e\u0012\b\u0012\u00060\bj\u0002`\t\u0012\u0010\u0012\u000e\u0012\u0002\b\u00030\rj\u0006\u0012\u0002\b\u0003`\u000e0\fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R \u0010\u0017\u001a\f\u0012\b\u0012\u00060\u0013j\u0002`\u00140\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u001a"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/platform_actions/sample/SamplePlatformActionsStateProducerFactory;", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/PlatformActionsStateProducer$Factory;", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/sample/SamplePlatformActionsState;", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/sample/SamplePAState;", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/PASProducerFactory;", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/ChannelData;", "channelData", "", "", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/PASKey;", "getCompatibleKeys", "(Lcom/avito/android/messenger/conversation/mvi/platform_actions/ChannelData;)Ljava/util/Set;", "", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/PlatformActionsStateProducer;", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/PASProducer;", "cachedProducers", "createCompatibleProducers", "(Lcom/avito/android/messenger/conversation/mvi/platform_actions/ChannelData;Ljava/util/Map;)Ljava/util/Map;", "Ljavax/inject/Provider;", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/sample/SamplePlatformActionsStateProducer;", "Lcom/avito/android/messenger/conversation/mvi/platform_actions/sample/SamplePASProducer;", AuthSource.SEND_ABUSE, "Ljavax/inject/Provider;", "presenterProvider", "<init>", "(Ljavax/inject/Provider;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class SamplePlatformActionsStateProducerFactory implements PlatformActionsStateProducer.Factory<SamplePlatformActionsState> {
    public final Provider<SamplePlatformActionsStateProducer> a;

    @Inject
    public SamplePlatformActionsStateProducerFactory(@NotNull Provider<SamplePlatformActionsStateProducer> provider) {
        Intrinsics.checkNotNullParameter(provider, "presenterProvider");
        this.a = provider;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001b, code lost:
        if (r3 != null) goto L_0x0026;
     */
    @Override // com.avito.android.messenger.conversation.mvi.platform_actions.PlatformActionsStateProducer.Factory
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.Map<java.lang.Object, com.avito.android.messenger.conversation.mvi.platform_actions.PlatformActionsStateProducer<com.avito.android.messenger.conversation.mvi.platform_actions.sample.SamplePlatformActionsState>> createCompatibleProducers(@org.jetbrains.annotations.NotNull com.avito.android.messenger.conversation.mvi.platform_actions.ChannelData r2, @org.jetbrains.annotations.NotNull java.util.Map<java.lang.Object, ? extends com.avito.android.messenger.conversation.mvi.platform_actions.PlatformActionsStateProducer<?>> r3) {
        /*
            r1 = this;
            java.lang.String r0 = "channelData"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r2 = "cachedProducers"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r2)
            java.lang.String r2 = "SamplePlatformActionsState"
            java.lang.Object r3 = r3.get(r2)
            com.avito.android.messenger.conversation.mvi.platform_actions.PlatformActionsStateProducer r3 = (com.avito.android.messenger.conversation.mvi.platform_actions.PlatformActionsStateProducer) r3
            if (r3 == 0) goto L_0x001e
            boolean r0 = r3 instanceof com.avito.android.messenger.conversation.mvi.platform_actions.sample.SamplePlatformActionsStateProducer
            if (r0 != 0) goto L_0x0019
            r3 = 0
        L_0x0019:
            com.avito.android.messenger.conversation.mvi.platform_actions.sample.SamplePlatformActionsStateProducer r3 = (com.avito.android.messenger.conversation.mvi.platform_actions.sample.SamplePlatformActionsStateProducer) r3
            if (r3 == 0) goto L_0x001e
            goto L_0x0026
        L_0x001e:
            javax.inject.Provider<com.avito.android.messenger.conversation.mvi.platform_actions.sample.SamplePlatformActionsStateProducer> r3 = r1.a
            java.lang.Object r3 = r3.get()
            com.avito.android.messenger.conversation.mvi.platform_actions.sample.SamplePlatformActionsStateProducer r3 = (com.avito.android.messenger.conversation.mvi.platform_actions.sample.SamplePlatformActionsStateProducer) r3
        L_0x0026:
            kotlin.Pair r2 = kotlin.TuplesKt.to(r2, r3)
            java.util.Map r2 = t6.n.q.mapOf(r2)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.messenger.conversation.mvi.platform_actions.sample.SamplePlatformActionsStateProducerFactory.createCompatibleProducers(com.avito.android.messenger.conversation.mvi.platform_actions.ChannelData, java.util.Map):java.util.Map");
    }

    @Override // com.avito.android.messenger.conversation.mvi.platform_actions.PlatformActionsStateProducer.Factory
    @NotNull
    public Set<Object> getCompatibleKeys(@NotNull ChannelData channelData) {
        Intrinsics.checkNotNullParameter(channelData, "channelData");
        return !(channelData.actions instanceof PlatformActions.None) ? x.setOf(SamplePlatformActionsState.KEY) : y.emptySet();
    }
}
