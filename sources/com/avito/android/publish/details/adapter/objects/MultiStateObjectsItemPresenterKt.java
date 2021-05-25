package com.avito.android.publish.details.adapter.objects;

import a2.b.a.a.a;
import com.avito.android.category_parameters.ParameterElement;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\b\n\u0002\b\u0003\"\u0016\u0010\u0001\u001a\u00020\u00008\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0001\u0010\u0002¨\u0006\u0003"}, d2 = {"", "ADD_MORE_INDEX", "I", "publish_release"}, k = 2, mv = {1, 4, 2})
public final class MultiStateObjectsItemPresenterKt {
    public static final int ADD_MORE_INDEX = -1;

    public static final String access$composeTextForSelect(ParameterElement.Objects.Item item) {
        String str;
        String c3;
        StringBuilder sb = new StringBuilder();
        sb.append(item.getTitle());
        String firstSubtitle = item.getFirstSubtitle();
        String str2 = "";
        if (firstSubtitle == null || (str = a.c3(", ", firstSubtitle)) == null) {
            str = str2;
        }
        sb.append(str);
        String secondSubtitle = item.getSecondSubtitle();
        if (!(secondSubtitle == null || (c3 = a.c3(", ", secondSubtitle)) == null)) {
            str2 = c3;
        }
        sb.append(str2);
        return sb.toString();
    }
}
