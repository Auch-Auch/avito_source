package a2.a.a.g3.c.b;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.avito.android.ui.widget.tagged_input.TagsListViewImpl;
public final class a<T> implements Observer<Boolean> {
    public final /* synthetic */ TagsListViewImpl a;
    public final /* synthetic */ LifecycleOwner b;

    public a(TagsListViewImpl tagsListViewImpl, String str, LifecycleOwner lifecycleOwner) {
        this.a = tagsListViewImpl;
        this.b = lifecycleOwner;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(Boolean bool) {
        Boolean bool2 = bool;
        TagsListViewImpl.access$setTagsVisible(this.a, bool2 != null ? bool2.booleanValue() : false);
    }
}
