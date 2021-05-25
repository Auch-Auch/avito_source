package com.avito.android.messenger.conversation.mvi.deeplinks;

import androidx.lifecycle.ViewModel;
import com.avito.android.deep_linking.links.DeepLink;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u00032\u00020\u0004B\u0015\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\n¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00028\u0000H$¢\u0006\u0004\b\t\u0010\bR\u001c\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/deeplinks/AbstractDeeplinkProcessor;", "Lcom/avito/android/deep_linking/links/DeepLink;", "T", "Lcom/avito/android/messenger/conversation/mvi/deeplinks/DeeplinkProcessor;", "Landroidx/lifecycle/ViewModel;", "deeplink", "", "process", "(Lcom/avito/android/deep_linking/links/DeepLink;)Z", "doProcess", "Ljava/lang/Class;", "c", "Ljava/lang/Class;", "deeplinkClass", "<init>", "(Ljava/lang/Class;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public abstract class AbstractDeeplinkProcessor<T extends DeepLink> extends ViewModel implements DeeplinkProcessor {
    public final Class<T> c;

    public AbstractDeeplinkProcessor(@NotNull Class<T> cls) {
        Intrinsics.checkNotNullParameter(cls, "deeplinkClass");
        this.c = cls;
    }

    public abstract boolean doProcess(@NotNull T t);

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.avito.android.deep_linking.links.DeepLink */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.avito.android.messenger.conversation.mvi.deeplinks.DeeplinkProcessor
    public final boolean process(@NotNull DeepLink deepLink) {
        Intrinsics.checkNotNullParameter(deepLink, "deeplink");
        if (this.c.isInstance(deepLink)) {
            return doProcess(deepLink);
        }
        return false;
    }
}
