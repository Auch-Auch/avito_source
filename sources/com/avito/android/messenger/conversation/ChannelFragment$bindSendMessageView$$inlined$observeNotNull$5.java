package com.avito.android.messenger.conversation;

import android.content.Context;
import androidx.lifecycle.Observer;
import com.avito.android.util.ToastsKt;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00002\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00018\u00008\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"T", "kotlin.jvm.PlatformType", "it", "", "onChanged", "(Ljava/lang/Object;)V", "com/avito/android/util/architecture_components/LiveDatasKt$observeNotNull$$inlined$observe$1", "<anonymous>"}, k = 3, mv = {1, 4, 2})
public final class ChannelFragment$bindSendMessageView$$inlined$observeNotNull$5<T> implements Observer<T> {
    public final /* synthetic */ ChannelFragment a;

    public ChannelFragment$bindSendMessageView$$inlined$observeNotNull$5(ChannelFragment channelFragment) {
        this.a = channelFragment;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(T t) {
        if (t != null) {
            T t2 = t;
            Context context = this.a.getContext();
            if (context != null) {
                ToastsKt.showToast$default(context, t2, 0, 2, (Object) null);
            }
        }
    }
}
