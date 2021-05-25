package com.avito.android.messenger.conversation.mvi.deeplinks;

import android.content.Context;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import com.avito.android.messenger.conversation.mvi.deeplinks.DeeplinkProcessor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u00032\u00020\u0004B\u0015\u0012\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0018¢\u0006\u0004\b\u001c\u0010\u001dJG\u0010\u0010\u001a\u00020\u000f\"\b\b\u0001\u0010\u0006*\u00020\u0005\"\b\b\u0002\u0010\b*\u00020\u00072\u0006\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00028\u00012\u0006\u0010\u000b\u001a\u00028\u00022\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\u0004\b\u0010\u0010\u0011JI\u0010\u0013\u001a\u00020\u0012\"\b\b\u0001\u0010\u0006*\u00020\u0005\"\b\b\u0002\u0010\b*\u00020\u00072\u0006\u0010\t\u001a\u00028\u00002\u0006\u0010\n\u001a\u00028\u00012\u0006\u0010\u000b\u001a\u00028\u00022\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fH$¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0012H\u0014¢\u0006\u0004\b\u0017\u0010\u0016R\u001c\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001e"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/deeplinks/AbstractDeeplinkProcessorListener;", "Lcom/avito/android/messenger/conversation/mvi/deeplinks/DeeplinkProcessor;", "P", "Lcom/avito/android/messenger/conversation/mvi/deeplinks/DeeplinkProcessorListener;", "Landroidx/lifecycle/ViewModel;", "Landroid/content/Context;", "C", "Landroidx/lifecycle/LifecycleOwner;", "F", "processor", "context", "lifecycleOwner", "Landroidx/lifecycle/LiveData;", "Lcom/avito/android/messenger/conversation/mvi/deeplinks/ActivityResult;", "activityResultStream", "", "attach", "(Lcom/avito/android/messenger/conversation/mvi/deeplinks/DeeplinkProcessor;Landroid/content/Context;Landroidx/lifecycle/LifecycleOwner;Landroidx/lifecycle/LiveData;)Z", "", "doAttach", "(Lcom/avito/android/messenger/conversation/mvi/deeplinks/DeeplinkProcessor;Landroid/content/Context;Landroidx/lifecycle/LifecycleOwner;Landroidx/lifecycle/LiveData;)V", "detach", "()V", "onCleared", "Ljava/lang/Class;", "c", "Ljava/lang/Class;", "processorClass", "<init>", "(Ljava/lang/Class;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public abstract class AbstractDeeplinkProcessorListener<P extends DeeplinkProcessor> extends ViewModel implements DeeplinkProcessorListener {
    public final Class<P> c;

    public AbstractDeeplinkProcessorListener(@NotNull Class<P> cls) {
        Intrinsics.checkNotNullParameter(cls, "processorClass");
        this.c = cls;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.avito.android.messenger.conversation.mvi.deeplinks.DeeplinkProcessor */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.avito.android.messenger.conversation.mvi.deeplinks.DeeplinkProcessorListener
    public final <C extends Context, F extends LifecycleOwner> boolean attach(@NotNull DeeplinkProcessor deeplinkProcessor, @NotNull C c2, @NotNull F f, @NotNull LiveData<ActivityResult> liveData) {
        Intrinsics.checkNotNullParameter(deeplinkProcessor, "processor");
        Intrinsics.checkNotNullParameter(c2, "context");
        Intrinsics.checkNotNullParameter(f, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(liveData, "activityResultStream");
        if (!this.c.isInstance(deeplinkProcessor)) {
            return false;
        }
        doAttach(deeplinkProcessor, c2, f, liveData);
        return true;
    }

    @Override // com.avito.android.messenger.conversation.mvi.deeplinks.DeeplinkProcessorListener
    public void detach() {
    }

    public abstract <C extends Context, F extends LifecycleOwner> void doAttach(@NotNull P p, @NotNull C c2, @NotNull F f, @NotNull LiveData<ActivityResult> liveData);

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        detach();
        super.onCleared();
    }
}
