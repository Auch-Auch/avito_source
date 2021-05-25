package a2.a.a.j0;

import android.content.Intent;
import android.net.Uri;
import com.avito.android.deep_linking.AppLinkActivity;
import com.google.android.gms.tasks.OnFailureListener;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
public final class b implements OnFailureListener {
    public final /* synthetic */ AppLinkActivity a;

    public b(AppLinkActivity appLinkActivity) {
        this.a = appLinkActivity;
    }

    @Override // com.google.android.gms.tasks.OnFailureListener
    public final void onFailure(@NotNull Exception exc) {
        Intrinsics.checkNotNullParameter(exc, "it");
        AppLinkActivity appLinkActivity = this.a;
        Intent intent = appLinkActivity.getIntent();
        Intrinsics.checkNotNullExpressionValue(intent, "intent");
        AppLinkActivity.access$initializePresenterParams(appLinkActivity, intent.getData(), (Uri) this.a.getIntent().getParcelableExtra("android.intent.extra.REFERRER"));
    }
}
