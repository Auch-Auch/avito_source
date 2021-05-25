package com.avito.android.messenger.conversation.mvi.deeplinks;

import android.content.Context;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B#\u0012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012\u0012\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00170\u0001¢\u0006\u0004\b\u001b\u0010\u001cJI\u0010\u000e\u001a\u00020\r\"\b\b\u0000\u0010\u0004*\u00020\u0003\"\b\b\u0001\u0010\u0006*\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00028\u00002\u0006\u0010\t\u001a\u00028\u00012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0014¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u001c\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00170\u00018\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001d"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/deeplinks/CompositeDeeplinkProcessorListener;", "Lcom/avito/android/messenger/conversation/mvi/deeplinks/AbstractDeeplinkProcessorListener;", "Lcom/avito/android/messenger/conversation/mvi/deeplinks/CompositeDeeplinkProcessor;", "Landroid/content/Context;", "C", "Landroidx/lifecycle/LifecycleOwner;", "F", "processor", "context", "lifecycleOwner", "Landroidx/lifecycle/LiveData;", "Lcom/avito/android/messenger/conversation/mvi/deeplinks/ActivityResult;", "activityResultStream", "", "doAttach", "(Lcom/avito/android/messenger/conversation/mvi/deeplinks/CompositeDeeplinkProcessor;Landroid/content/Context;Landroidx/lifecycle/LifecycleOwner;Landroidx/lifecycle/LiveData;)V", "detach", "()V", "", "Lcom/avito/android/messenger/conversation/mvi/deeplinks/DeeplinkProcessorListener;", "d", "Ljava/util/Collection;", "listeners", "Lcom/avito/android/messenger/conversation/mvi/deeplinks/DefaultDeeplinkProcessor;", "e", "Lcom/avito/android/messenger/conversation/mvi/deeplinks/AbstractDeeplinkProcessorListener;", "defaultListener", "<init>", "(Ljava/util/Collection;Lcom/avito/android/messenger/conversation/mvi/deeplinks/AbstractDeeplinkProcessorListener;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class CompositeDeeplinkProcessorListener extends AbstractDeeplinkProcessorListener<CompositeDeeplinkProcessor> {
    public final Collection<DeeplinkProcessorListener> d;
    public final AbstractDeeplinkProcessorListener<DefaultDeeplinkProcessor> e;

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.util.Collection<? extends com.avito.android.messenger.conversation.mvi.deeplinks.DeeplinkProcessorListener> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CompositeDeeplinkProcessorListener(@NotNull Collection<? extends DeeplinkProcessorListener> collection, @NotNull AbstractDeeplinkProcessorListener<DefaultDeeplinkProcessor> abstractDeeplinkProcessorListener) {
        super(CompositeDeeplinkProcessor.class);
        Intrinsics.checkNotNullParameter(collection, "listeners");
        Intrinsics.checkNotNullParameter(abstractDeeplinkProcessorListener, "defaultListener");
        this.d = collection;
        this.e = abstractDeeplinkProcessorListener;
    }

    @Override // com.avito.android.messenger.conversation.mvi.deeplinks.AbstractDeeplinkProcessorListener, com.avito.android.messenger.conversation.mvi.deeplinks.DeeplinkProcessorListener
    public void detach() {
        Iterator<T> it = this.d.iterator();
        while (it.hasNext()) {
            it.next().detach();
        }
        this.e.detach();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.avito.android.messenger.conversation.mvi.deeplinks.DeeplinkProcessor, android.content.Context, androidx.lifecycle.LifecycleOwner, androidx.lifecycle.LiveData] */
    @Override // com.avito.android.messenger.conversation.mvi.deeplinks.AbstractDeeplinkProcessorListener
    public /* bridge */ /* synthetic */ void doAttach(CompositeDeeplinkProcessor compositeDeeplinkProcessor, Context context, LifecycleOwner lifecycleOwner, LiveData liveData) {
        doAttach(compositeDeeplinkProcessor, (CompositeDeeplinkProcessor) context, (Context) lifecycleOwner, (LiveData<ActivityResult>) liveData);
    }

    public <C extends Context, F extends LifecycleOwner> void doAttach(@NotNull CompositeDeeplinkProcessor compositeDeeplinkProcessor, @NotNull C c, @NotNull F f, @NotNull LiveData<ActivityResult> liveData) {
        Intrinsics.checkNotNullParameter(compositeDeeplinkProcessor, "processor");
        Intrinsics.checkNotNullParameter(c, "context");
        Intrinsics.checkNotNullParameter(f, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(liveData, "activityResultStream");
        Iterator<T> it = compositeDeeplinkProcessor.getProcessors().iterator();
        while (it.hasNext()) {
            T next = it.next();
            Iterator<DeeplinkProcessorListener> it2 = this.d.iterator();
            while (it2.hasNext() && !it2.next().attach(next, c, f, liveData)) {
            }
        }
        this.e.attach(compositeDeeplinkProcessor.getDefaultProcessor(), c, f, liveData);
    }
}
