package a2.a.a.j0;

import android.content.Intent;
import android.net.Uri;
import com.avito.android.deep_linking.AppLinkActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.dynamiclinks.PendingDynamicLinkData;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
public final class a<TResult> implements OnCompleteListener<PendingDynamicLinkData> {
    public final /* synthetic */ AppLinkActivity a;

    public a(AppLinkActivity appLinkActivity) {
        this.a = appLinkActivity;
    }

    @Override // com.google.android.gms.tasks.OnCompleteListener
    public final void onComplete(@NotNull Task<PendingDynamicLinkData> task) {
        Uri uri;
        Intrinsics.checkNotNullParameter(task, "it");
        if (!task.isSuccessful() || task.getResult() == null) {
            Intent intent = this.a.getIntent();
            Intrinsics.checkNotNullExpressionValue(intent, "intent");
            uri = intent.getData();
        } else {
            PendingDynamicLinkData result = task.getResult();
            uri = result != null ? result.getLink() : null;
        }
        AppLinkActivity.access$initializePresenterParams(this.a, uri, (Uri) this.a.getIntent().getParcelableExtra("android.intent.extra.REFERRER"));
    }
}
