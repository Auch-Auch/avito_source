package a2.d.a.e;

import androidx.annotation.NonNull;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.manager.RequestManagerTreeNode;
import java.util.Collections;
import java.util.Set;
public final class d implements RequestManagerTreeNode {
    @Override // com.bumptech.glide.manager.RequestManagerTreeNode
    @NonNull
    public Set<RequestManager> getDescendants() {
        return Collections.emptySet();
    }
}
