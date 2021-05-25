package a2.j.b.e.a.d;

import com.google.android.play.core.internal.at;
import com.google.android.play.core.internal.bl;
import java.io.File;
public final class j implements at {
    @Override // com.google.android.play.core.internal.at
    public final boolean a(Object obj, File file, File file2) {
        return new File((String) bl.a(obj.getClass(), "optimizedPathFor", String.class, File.class, file, File.class, file2)).exists();
    }
}
