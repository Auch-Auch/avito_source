package com.avito.android.messenger.conversation.mvi.deeplinks;

import android.content.Context;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.avito.android.util.IntentsKt;
import com.avito.android.util.Logs;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 \u00122\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0012B\u0007¢\u0006\u0004\b\u0010\u0010\u0011JI\u0010\u000e\u001a\u00020\r\"\b\b\u0000\u0010\u0004*\u00020\u0003\"\b\b\u0001\u0010\u0006*\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00028\u00002\u0006\u0010\t\u001a\u00028\u00012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0014¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/deeplinks/DefaultDeeplinkProcessorListenerImpl;", "Lcom/avito/android/messenger/conversation/mvi/deeplinks/AbstractDeeplinkProcessorListener;", "Lcom/avito/android/messenger/conversation/mvi/deeplinks/DefaultDeeplinkProcessor;", "Landroid/content/Context;", "C", "Landroidx/lifecycle/LifecycleOwner;", "F", "processor", "context", "lifecycleOwner", "Landroidx/lifecycle/LiveData;", "Lcom/avito/android/messenger/conversation/mvi/deeplinks/ActivityResult;", "activityResultStream", "", "doAttach", "(Lcom/avito/android/messenger/conversation/mvi/deeplinks/DefaultDeeplinkProcessor;Landroid/content/Context;Landroidx/lifecycle/LifecycleOwner;Landroidx/lifecycle/LiveData;)V", "<init>", "()V", "Companion", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class DefaultDeeplinkProcessorListenerImpl extends AbstractDeeplinkProcessorListener<DefaultDeeplinkProcessor> {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final String TAG = "DefaultDeeplinkProcessorListener";

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/deeplinks/DefaultDeeplinkProcessorListenerImpl$Companion;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    public DefaultDeeplinkProcessorListenerImpl() {
        super(DefaultDeeplinkProcessor.class);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.avito.android.messenger.conversation.mvi.deeplinks.DeeplinkProcessor, android.content.Context, androidx.lifecycle.LifecycleOwner, androidx.lifecycle.LiveData] */
    @Override // com.avito.android.messenger.conversation.mvi.deeplinks.AbstractDeeplinkProcessorListener
    public /* bridge */ /* synthetic */ void doAttach(DefaultDeeplinkProcessor defaultDeeplinkProcessor, Context context, LifecycleOwner lifecycleOwner, LiveData liveData) {
        doAttach(defaultDeeplinkProcessor, (DefaultDeeplinkProcessor) context, (Context) lifecycleOwner, (LiveData<ActivityResult>) liveData);
    }

    public <C extends Context, F extends LifecycleOwner> void doAttach(@NotNull DefaultDeeplinkProcessor defaultDeeplinkProcessor, @NotNull C c, @NotNull F f, @NotNull LiveData<ActivityResult> liveData) {
        Intrinsics.checkNotNullParameter(defaultDeeplinkProcessor, "processor");
        Intrinsics.checkNotNullParameter(c, "context");
        Intrinsics.checkNotNullParameter(f, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(liveData, "activityResultStream");
        defaultDeeplinkProcessor.getOpenScreenIntentStream().observe(f, new Observer<T>(c) { // from class: com.avito.android.messenger.conversation.mvi.deeplinks.DefaultDeeplinkProcessorListenerImpl$$special$$inlined$observeNotNull$1
            public final /* synthetic */ Context a;

            {
                this.a = r1;
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(T t) {
                if (t != null) {
                    try {
                        this.a.startActivity(IntentsKt.makeSafeForExternalApps(t));
                    } catch (Exception e) {
                        Logs.error(DefaultDeeplinkProcessorListenerImpl.TAG, "", e);
                    }
                }
            }
        });
    }
}
