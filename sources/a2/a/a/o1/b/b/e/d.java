package a2.a.a.o1.b.b.e;

import com.avito.android.messenger.channels.mvi.presenter.FoldersPresenter;
import com.avito.android.messenger.channels.mvi.view.ChannelsFragment;
import com.avito.android.messenger.channels.mvi.view.FoldersView;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
public final class d<T> implements Consumer<FoldersPresenter.State> {
    public final /* synthetic */ ChannelsFragment a;

    public d(ChannelsFragment channelsFragment) {
        this.a = channelsFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(FoldersPresenter.State state) {
        FoldersPresenter.State state2 = state;
        ChannelsFragment.access$getTabsLayout$p(this.a).removeOnTabSelectedListener(ChannelsFragment.access$getFolderSelectionListener$p(this.a));
        FoldersView access$getFoldersView$p = ChannelsFragment.access$getFoldersView$p(this.a);
        Intrinsics.checkNotNullExpressionValue(state2, "state");
        access$getFoldersView$p.render(state2);
        ChannelsFragment.access$getViewPager$p(this.a).setCurrentItem(state2.getSelected());
        ChannelsFragment.access$getTabsLayout$p(this.a).addOnTabSelectedListener(ChannelsFragment.access$getFolderSelectionListener$p(this.a));
    }
}
