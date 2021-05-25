package a2.a.a.a.f.a;

import android.content.Context;
import android.view.ViewGroup;
import com.avito.android.component.search.SuggestItemListener;
import com.avito.android.component.search.list.SuggestBubbleView;
import com.avito.android.lib.util.ReuseChildrenHelper;
import com.avito.android.remote.model.Color;
import com.avito.android.remote.model.search.suggest.SuggestBubbleItem;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
public final class b extends ReuseChildrenHelper<SuggestBubbleItem, SuggestBubbleView> {
    public final Context a;
    public SuggestItemListener b;
    public boolean c;
    public final ViewGroup d;

    public b(@NotNull ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "container");
        this.d = viewGroup;
        Context context = viewGroup.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "container.context");
        this.a = context;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.view.View, java.lang.Object, int] */
    @Override // com.avito.android.lib.util.ReuseChildrenHelper
    public void bindData(SuggestBubbleView suggestBubbleView, SuggestBubbleItem suggestBubbleItem, int i) {
        SuggestBubbleView suggestBubbleView2 = suggestBubbleView;
        SuggestBubbleItem suggestBubbleItem2 = suggestBubbleItem;
        Intrinsics.checkNotNullParameter(suggestBubbleView2, "view");
        Intrinsics.checkNotNullParameter(suggestBubbleItem2, "data");
        SuggestBubbleItem.ColorConfiguration colorConfiguration = suggestBubbleItem2.getColorConfiguration();
        suggestBubbleView2.setHeight(this.c);
        suggestBubbleView2.setTitle(suggestBubbleItem2.getTitle());
        suggestBubbleView2.setDescription(suggestBubbleItem2.getDescription());
        if (colorConfiguration != null) {
            Color background = colorConfiguration.getBackground();
            Integer valueOf = background != null ? Integer.valueOf(background.getValue()) : null;
            Color highlightedBackground = colorConfiguration.getHighlightedBackground();
            Integer valueOf2 = highlightedBackground != null ? Integer.valueOf(highlightedBackground.getValue()) : null;
            Color border = colorConfiguration.getBorder();
            Integer valueOf3 = border != null ? Integer.valueOf(border.getValue()) : null;
            Color text = colorConfiguration.getText();
            Integer valueOf4 = text != null ? Integer.valueOf(text.getValue()) : null;
            Color description = colorConfiguration.getDescription();
            suggestBubbleView2.setColors(valueOf, valueOf2, valueOf3, valueOf4, description != null ? Integer.valueOf(description.getValue()) : null);
        } else {
            suggestBubbleView2.resetColors();
        }
        suggestBubbleView2.setOnClickListener(new a(this, suggestBubbleItem2));
    }

    /* Return type fixed from 'android.view.View' to match base method */
    @Override // com.avito.android.lib.util.ReuseChildrenHelper
    public SuggestBubbleView createChild() {
        return new SuggestBubbleView(this.a);
    }
}
