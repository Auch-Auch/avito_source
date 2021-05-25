package a2.a.a.e2.r.n0;

import com.avito.android.publish.details.tags.PublishTagsViewModel;
import com.avito.android.remote.model.publish.BubbleSuggest;
import com.avito.android.ui.widget.tagged_input.TagItem;
import com.avito.android.ui.widget.tagged_input.TagItemKt;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import t6.n.e;
public final class a<T, R> implements Function<List<? extends BubbleSuggest>, Pair<? extends String, ? extends List<? extends TagItem>>> {
    public final /* synthetic */ PublishTagsViewModel.d a;

    public a(PublishTagsViewModel.d dVar) {
        this.a = dVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public Pair<? extends String, ? extends List<? extends TagItem>> apply(List<? extends BubbleSuggest> list) {
        List<? extends BubbleSuggest> list2 = list;
        Intrinsics.checkNotNullParameter(list2, "bubbles");
        String str = this.a.a;
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(TagItemKt.toTagItem((BubbleSuggest) it.next()));
        }
        return TuplesKt.to(str, arrayList);
    }
}
