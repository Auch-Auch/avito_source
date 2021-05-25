package a2.a.a.o1.b.b.e;

import android.view.MenuItem;
import androidx.appcompat.widget.Toolbar;
import com.avito.android.messenger.channels.mvi.view.ChannelsFragment;
import kotlin.jvm.internal.Intrinsics;
public final class e implements Toolbar.OnMenuItemClickListener {
    public final /* synthetic */ ChannelsFragment a;

    public e(ChannelsFragment channelsFragment) {
        this.a = channelsFragment;
    }

    @Override // androidx.appcompat.widget.Toolbar.OnMenuItemClickListener
    public final boolean onMenuItemClick(MenuItem menuItem) {
        ChannelsFragment channelsFragment = this.a;
        Intrinsics.checkNotNullExpressionValue(menuItem, "it");
        return ChannelsFragment.access$onMenuClick(channelsFragment, menuItem);
    }
}
