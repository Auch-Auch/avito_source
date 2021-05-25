package a2.a.a.o1.b.b.c;

import com.avito.android.messenger.channels.mvi.presenter.FoldersPresenter;
import com.avito.android.messenger.channels.mvi.presenter.FoldersPresenterImpl;
import com.avito.android.messenger.folders.Folder;
import com.avito.android.messenger.folders.FoldersUnreadCounters;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.List;
import kotlin.Pair;
import t6.n.e;
public final class a<T> implements Consumer<FoldersUnreadCounters> {
    public final /* synthetic */ FoldersPresenterImpl a;

    public a(FoldersPresenterImpl foldersPresenterImpl) {
        this.a = foldersPresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(FoldersUnreadCounters foldersUnreadCounters) {
        String str;
        List<Pair<Folder, Integer>> counters = foldersUnreadCounters.getCounters();
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(counters, 10));
        for (T t : counters) {
            int intValue = ((Number) t.getSecond()).intValue();
            if (intValue == 0) {
                str = "";
            } else {
                str = String.valueOf(intValue);
            }
            arrayList.add(new FoldersPresenter.FolderTab(((Folder) t.getFirst()).getDisplayName(), ((Folder) t.getFirst()).getId(), str));
        }
        this.a.getReducerQueue().plusAssign(new FoldersPresenterImpl.UpdateTabsMutator(this.a, arrayList));
    }
}
