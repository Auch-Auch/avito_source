package a2.a.a.o1.b.b.e;

import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import com.avito.android.messenger.channels.mvi.view.ChannelListItem;
public final class b implements View.OnLongClickListener {
    public final /* synthetic */ ChannelListItem.ViewHolder a;
    public final /* synthetic */ ChannelListItem b;
    public final /* synthetic */ LifecycleOwner c;

    public b(ChannelListItem.ViewHolder viewHolder, ChannelListItem channelListItem, LifecycleOwner lifecycleOwner) {
        this.a = viewHolder;
        this.b = channelListItem;
        this.c = lifecycleOwner;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        this.b.getHideSwipeViewsStream().postValue(Integer.valueOf(this.a.getSwipeLayout().hashCode()));
        if (this.a.getSwipeLayout().getOffset() != 0) {
            return false;
        }
        this.a.animateOpenSwipeView();
        return this.b.getLongClickListener().onLongClick(view);
    }
}
