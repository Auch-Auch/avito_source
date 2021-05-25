package l6.w;

import androidx.annotation.VisibleForTesting;
import androidx.lifecycle.LiveData;
import androidx.room.RoomDatabase;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;
public class a {
    @VisibleForTesting
    public final Set<LiveData> a = Collections.newSetFromMap(new IdentityHashMap());
    public final RoomDatabase b;

    public a(RoomDatabase roomDatabase) {
        this.b = roomDatabase;
    }
}
