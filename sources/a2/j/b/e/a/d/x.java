package a2.j.b.e.a.d;

import com.google.android.play.core.internal.ap;
import java.io.File;
import java.util.Set;
import ru.avito.android.persistence.messenger.MessageMetaInfo;
public final class x implements ap {
    @Override // com.google.android.play.core.internal.ap
    public final void a(ClassLoader classLoader, Set<File> set) {
        p.b(classLoader, set, new s());
    }

    @Override // com.google.android.play.core.internal.ap
    public final boolean a(ClassLoader classLoader, File file, File file2, boolean z) {
        return k.b(classLoader, file, file2, z, new m(), MessageMetaInfo.COLUMN_PATH, new w());
    }
}
