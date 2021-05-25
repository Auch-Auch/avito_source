package a2.a.a.g3.c.b;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.avito.android.ui.widget.tagged_input.TagItem;
import com.avito.android.ui.widget.tagged_input.TagsListViewImpl;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
public final class b<T> implements Observer<List<? extends TagItem>> {
    public final /* synthetic */ TagsListViewImpl a;
    public final /* synthetic */ LifecycleOwner b;

    public b(TagsListViewImpl tagsListViewImpl, String str, LifecycleOwner lifecycleOwner) {
        this.a = tagsListViewImpl;
        this.b = lifecycleOwner;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(List<? extends TagItem> list) {
        List<? extends TagItem> list2 = list;
        TagsListViewImpl tagsListViewImpl = this.a;
        if (list2 == null) {
            list2 = CollectionsKt__CollectionsKt.emptyList();
        }
        TagsListViewImpl.access$updateItems(tagsListViewImpl, list2);
    }
}
