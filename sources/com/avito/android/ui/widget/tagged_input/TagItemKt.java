package com.avito.android.ui.widget.tagged_input;

import com.avito.android.remote.model.category_parameters.TextualTag;
import com.avito.android.remote.model.publish.BubbleSuggest;
import com.avito.android.remote.model.search.suggest.SuggestAction;
import com.avito.android.remote.model.search.suggest.SuggestAnalyticsEvent;
import com.avito.android.ui.widget.tagged_input.TagItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0004¢\u0006\u0004\b\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/avito/android/remote/model/category_parameters/TextualTag;", "Lcom/avito/android/ui/widget/tagged_input/TagItem;", "toTagItem", "(Lcom/avito/android/remote/model/category_parameters/TextualTag;)Lcom/avito/android/ui/widget/tagged_input/TagItem;", "Lcom/avito/android/remote/model/publish/BubbleSuggest;", "(Lcom/avito/android/remote/model/publish/BubbleSuggest;)Lcom/avito/android/ui/widget/tagged_input/TagItem;", "item-temporary_release"}, k = 2, mv = {1, 4, 2})
public final class TagItemKt {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            BubbleSuggest.SuggestType.values();
            int[] iArr = new int[2];
            $EnumSwitchMapping$0 = iArr;
            BubbleSuggest.SuggestType suggestType = BubbleSuggest.SuggestType.NORMAL;
            iArr[0] = 1;
            BubbleSuggest.SuggestType suggestType2 = BubbleSuggest.SuggestType.TYPO;
            iArr[1] = 2;
        }
    }

    @NotNull
    public static final TagItem toTagItem(@NotNull TextualTag textualTag) {
        Intrinsics.checkNotNullParameter(textualTag, "$this$toTagItem");
        String value = textualTag.getValue();
        StringBuilder sb = new StringBuilder();
        String prefix = textualTag.getPrefix();
        String str = "";
        if (prefix == null) {
            prefix = str;
        }
        sb.append(prefix);
        sb.append(textualTag.getValue());
        String postfix = textualTag.getPostfix();
        if (postfix != null) {
            str = postfix;
        }
        sb.append(str);
        return new TagItem(value, new TagItem.Value(sb.toString(), false), null, null, 12, null);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v2, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final TagItem toTagItem(@NotNull BubbleSuggest bubbleSuggest) {
        TagItem.Type type;
        boolean z;
        Intrinsics.checkNotNullParameter(bubbleSuggest, "$this$toTagItem");
        String title = bubbleSuggest.getTitle();
        SuggestAnalyticsEvent suggestAnalyticsEvent = null;
        TagItem.Value value = new TagItem.Value(bubbleSuggest.getReplacementText(), false, 2, null);
        int ordinal = bubbleSuggest.getType().ordinal();
        if (ordinal == 0) {
            type = TagItem.Type.REGULAR;
        } else if (ordinal == 1) {
            type = TagItem.Type.ALTERNATIVE;
        } else {
            throw new NoWhenBranchMatchedException();
        }
        List<SuggestAction> actions = bubbleSuggest.getActions();
        if (actions != null) {
            ArrayList arrayList = new ArrayList();
            for (T t : actions) {
                if (t instanceof SuggestAnalyticsEvent) {
                    arrayList.add(t);
                }
            }
            Iterator it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                if (((SuggestAnalyticsEvent) next).getId() == 4448) {
                    z = true;
                    continue;
                } else {
                    z = false;
                    continue;
                }
                if (z) {
                    suggestAnalyticsEvent = next;
                    break;
                }
            }
            suggestAnalyticsEvent = suggestAnalyticsEvent;
        }
        return new TagItem(title, value, type, suggestAnalyticsEvent);
    }
}
