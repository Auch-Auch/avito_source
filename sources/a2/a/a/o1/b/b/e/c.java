package a2.a.a.o1.b.b.e;

import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import com.avito.android.messenger.channels.mvi.view.ChannelListItem;
public final class c implements View.OnClickListener {
    public final /* synthetic */ ChannelListItem a;
    public final /* synthetic */ LifecycleOwner b;

    public c(ChannelListItem channelListItem, LifecycleOwner lifecycleOwner) {
        this.a = channelListItem;
        this.b = lifecycleOwner;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.a.getHideSwipeViewsStream().postValue(0);
        this.a.getDeleteClickListener().onClick(view);
    }
}
