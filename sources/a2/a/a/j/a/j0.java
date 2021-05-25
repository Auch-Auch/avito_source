package a2.a.a.j.a;

import com.avito.android.app.task.PublishDraftsSyncTask;
import com.avito.android.publish.drafts.PublishDraftRepository;
import io.reactivex.SingleSource;
import java.util.concurrent.Callable;
public final class j0<V> implements Callable<SingleSource<? extends PublishDraftRepository.DraftSyncResult>> {
    public final /* synthetic */ PublishDraftsSyncTask.b a;

    public j0(PublishDraftsSyncTask.b bVar) {
        this.a = bVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.concurrent.Callable
    public SingleSource<? extends PublishDraftRepository.DraftSyncResult> call() {
        return this.a.a.draftRepository.syncDraftIfNeeded();
    }
}
