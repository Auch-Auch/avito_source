package a2.a.a.o1.d.a0.e;

import android.net.Uri;
import arrow.core.Option;
import com.avito.android.messenger.conversation.mvi.data.MessageRepo;
import com.avito.android.util.rx3.InteropKt;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.functions.Function;
import java.io.File;
public final class c<T, R> implements Function<Option<? extends Uri>, SingleSource<? extends Option<? extends Uri>>> {
    public final /* synthetic */ e a;
    public final /* synthetic */ File b;

    public c(e eVar, File file) {
        this.a = eVar;
        this.b = file;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX DEBUG: Multi-variable search result rejected for r0v6, resolved type: io.reactivex.rxjava3.core.Completable */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.rxjava3.functions.Function
    public SingleSource<? extends Option<? extends Uri>> apply(Option<? extends Uri> option) {
        this.b.delete();
        MessageRepo messageRepo = this.a.a.a.c;
        f fVar = this.a.a;
        return InteropKt.toV3(messageRepo.setFileDownloadInternalPath(fVar.b, fVar.c, fVar.d, null)).toSingleDefault(option);
    }
}
