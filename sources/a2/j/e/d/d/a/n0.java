package a2.j.e.d.d.a;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import java.io.InputStream;
public interface n0 {
    @NonNull
    String a();

    @Nullable
    CrashlyticsReport.FilesPayload.File b();

    @Nullable
    InputStream getStream();
}
