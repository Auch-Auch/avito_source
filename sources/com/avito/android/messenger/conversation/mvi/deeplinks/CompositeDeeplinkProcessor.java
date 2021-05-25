package com.avito.android.messenger.conversation.mvi.deeplinks;

import com.avito.android.deep_linking.links.DeepLink;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00162\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0016B\u001d\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0006\u0010\f\u001a\u00020\u0007¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0006R\u0019\u0010\f\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0017"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/deeplinks/CompositeDeeplinkProcessor;", "Lcom/avito/android/messenger/conversation/mvi/deeplinks/AbstractDeeplinkProcessor;", "Lcom/avito/android/deep_linking/links/DeepLink;", "deeplink", "", "doProcess", "(Lcom/avito/android/deep_linking/links/DeepLink;)Z", "Lcom/avito/android/messenger/conversation/mvi/deeplinks/DefaultDeeplinkProcessor;", "e", "Lcom/avito/android/messenger/conversation/mvi/deeplinks/DefaultDeeplinkProcessor;", "getDefaultProcessor", "()Lcom/avito/android/messenger/conversation/mvi/deeplinks/DefaultDeeplinkProcessor;", "defaultProcessor", "", "Lcom/avito/android/messenger/conversation/mvi/deeplinks/DeeplinkProcessor;", "d", "Ljava/util/Collection;", "getProcessors", "()Ljava/util/Collection;", "processors", "<init>", "(Ljava/util/Collection;Lcom/avito/android/messenger/conversation/mvi/deeplinks/DefaultDeeplinkProcessor;)V", "Companion", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class CompositeDeeplinkProcessor extends AbstractDeeplinkProcessor<DeepLink> {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final String TAG = "CompositeDeeplinkProcessor";
    @NotNull
    public final Collection<DeeplinkProcessor> d;
    @NotNull
    public final DefaultDeeplinkProcessor e;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0000@\u0000XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/deeplinks/CompositeDeeplinkProcessor$Companion;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.util.Collection<? extends com.avito.android.messenger.conversation.mvi.deeplinks.DeeplinkProcessor> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CompositeDeeplinkProcessor(@NotNull Collection<? extends DeeplinkProcessor> collection, @NotNull DefaultDeeplinkProcessor defaultDeeplinkProcessor) {
        super(DeepLink.class);
        Intrinsics.checkNotNullParameter(collection, "processors");
        Intrinsics.checkNotNullParameter(defaultDeeplinkProcessor, "defaultProcessor");
        this.d = collection;
        this.e = defaultDeeplinkProcessor;
    }

    @Override // com.avito.android.messenger.conversation.mvi.deeplinks.AbstractDeeplinkProcessor
    public boolean doProcess(@NotNull DeepLink deepLink) {
        Intrinsics.checkNotNullParameter(deepLink, "deeplink");
        for (DeeplinkProcessor deeplinkProcessor : this.d) {
            if (deeplinkProcessor.process(deepLink)) {
                return true;
            }
        }
        return this.e.process(deepLink);
    }

    @NotNull
    public final DefaultDeeplinkProcessor getDefaultProcessor() {
        return this.e;
    }

    @NotNull
    public final Collection<DeeplinkProcessor> getProcessors() {
        return this.d;
    }
}
