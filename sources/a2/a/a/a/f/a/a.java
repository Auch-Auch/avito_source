package a2.a.a.a.f.a;

import android.view.View;
import com.avito.android.component.search.SuggestItemListener;
import com.avito.android.remote.model.search.suggest.SuggestAction;
import com.avito.android.remote.model.search.suggest.SuggestBubbleItem;
import java.util.List;
public final class a implements View.OnClickListener {
    public final /* synthetic */ b a;
    public final /* synthetic */ SuggestBubbleItem b;

    public a(b bVar, SuggestBubbleItem suggestBubbleItem) {
        this.a = bVar;
        this.b = suggestBubbleItem;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        SuggestItemListener suggestItemListener;
        List<SuggestAction> actions = this.b.getActions();
        if (actions != null && (suggestItemListener = this.a.b) != null) {
            suggestItemListener.onItemClicked(actions);
        }
    }
}
