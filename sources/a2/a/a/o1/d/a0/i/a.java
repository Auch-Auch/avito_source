package a2.a.a.o1.d.a0.i;

import com.avito.android.remote.model.messenger.message.LocalMessage;
import java.util.List;
import kotlin.Pair;
import org.jetbrains.annotations.NotNull;
import ru.avito.android.persistence.messenger.MessageMetaInfo;
public interface a {
    @NotNull
    List<Pair<LocalMessage, MessageMetaInfo>> getRawItems();
}
