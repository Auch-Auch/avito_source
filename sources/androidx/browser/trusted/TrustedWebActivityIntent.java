package androidx.browser.trusted;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import java.util.List;
public final class TrustedWebActivityIntent {
    @NonNull
    public final Intent a;
    @NonNull
    public final List<Uri> b;

    public TrustedWebActivityIntent(@NonNull Intent intent, @NonNull List<Uri> list) {
        this.a = intent;
        this.b = list;
    }

    @NonNull
    public Intent getIntent() {
        return this.a;
    }

    public void launchTrustedWebActivity(@NonNull Context context) {
        for (Uri uri : this.b) {
            context.grantUriPermission(this.a.getPackage(), uri, 1);
        }
        ContextCompat.startActivity(context, this.a, null);
    }
}
