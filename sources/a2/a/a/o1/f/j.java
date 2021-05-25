package a2.a.a.o1.f;

import com.avito.android.messenger.search.ChannelsSearchViewImpl;
public final class j implements Runnable {
    public final /* synthetic */ ChannelsSearchViewImpl a;

    public j(ChannelsSearchViewImpl channelsSearchViewImpl) {
        this.a = channelsSearchViewImpl;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.a.a().getItemCount() > 0) {
            this.a.d.scrollToPosition(0);
        }
    }
}
