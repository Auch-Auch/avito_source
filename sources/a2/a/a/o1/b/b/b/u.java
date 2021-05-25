package a2.a.a.o1.b.b.b;

import com.avito.android.messenger.channels.mvi.interactor.FoldersInteractorImpl;
import com.avito.android.messenger.folders.Folder;
import com.avito.android.messenger.folders.Folders;
import com.avito.android.messenger.folders.FoldersUnreadCounters;
import com.jakewharton.rxrelay2.PublishRelay;
import io.reactivex.functions.Consumer;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
public final class u<T> implements Consumer<Map<String, ? extends Integer>> {
    public final /* synthetic */ FoldersInteractorImpl a;

    public u(FoldersInteractorImpl foldersInteractorImpl) {
        this.a = foldersInteractorImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.avito.android.messenger.folders.FoldersUnreadCounters$Companion */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.functions.Consumer
    public void accept(Map<String, ? extends Integer> map) {
        Map<String, ? extends Integer> map2 = map;
        PublishRelay<FoldersUnreadCounters> foldersCounterStream = this.a.getFoldersCounterStream();
        FoldersUnreadCounters.Companion companion = FoldersUnreadCounters.Companion;
        List<Folder> all = Folders.INSTANCE.getAll();
        Intrinsics.checkNotNullExpressionValue(map2, "foldersWithCounters");
        foldersCounterStream.accept(companion.from(all, map2));
    }
}
