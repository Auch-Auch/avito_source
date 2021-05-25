package l6.c.c;

import android.content.pm.PackageManager;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.util.List;
public interface g {
    @Nullable
    List<byte[]> a(String str, PackageManager packageManager) throws PackageManager.NameNotFoundException;

    boolean b(String str, PackageManager packageManager, h hVar) throws IOException, PackageManager.NameNotFoundException;
}
