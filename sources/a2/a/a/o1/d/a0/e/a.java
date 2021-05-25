package a2.a.a.o1.d.a0.e;

import androidx.work.Data;
import androidx.work.ListenableWorker;
import com.avito.android.messenger.conversation.mvi.file_download.FileDownloadWorker;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import com.avito.android.util.Logs;
import io.reactivex.rxjava3.functions.Function;
import kotlin.jvm.internal.Intrinsics;
import t6.v.e;
public final class a<T, R> implements Function<Throwable, ListenableWorker.Result> {
    public final /* synthetic */ FileDownloadWorker.b a;

    public a(FileDownloadWorker.b bVar) {
        this.a = bVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public ListenableWorker.Result apply(Throwable th) {
        Throwable th2 = th;
        StringBuilder L = a2.b.a.a.a.L("Download failed for message(userId = ");
        L.append(this.a.b);
        L.append(", channelId=");
        L.append(this.a.c);
        L.append(", localMessageId = ");
        L.append(this.a.d);
        L.append(')');
        Logs.error(FileDownloadWorker.TAG, L.toString(), th2);
        String th3 = th2.toString();
        String substring = th3.substring(0, e.coerceAtMost(th3.length() - 1, 2048));
        Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        Data build = new Data.Builder().putString(ChannelContext.Item.USER_ID, this.a.b).putString("channelId", this.a.c).putString("localMessageId", this.a.d).putLong("enqTimestamp", this.a.e).putString("error", substring).build();
        Intrinsics.checkNotNullExpressionValue(build, "Data.Builder()\n         …                 .build()");
        return ListenableWorker.Result.failure(build);
    }
}
