package com.avito.android.user_advert.advert;

import a2.b.a.a.a;
import androidx.annotation.DrawableRes;
import com.avito.android.deep_linking.links.DraftDeletionLink;
import com.avito.android.deep_linking.links.DraftPublicationLink;
import com.avito.android.deep_linking.links.MyAdvertLink;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Action;
import com.avito.android.ui_components.R;
import com.avito.android.util.ActionMenu;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000e¢\u0006\u0004\b\u0011\u0010\u0012J+\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00042\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\n\u001a\u00020\u0005H\u0003¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u0010\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/avito/android/user_advert/advert/MyAdvertDetailsActionMenuConverterImpl;", "Lcom/avito/android/user_advert/advert/MyAdvertDetailsActionMenuConverter;", "", "includeSharing", "", "Lcom/avito/android/remote/model/Action;", "actions", "Lcom/avito/android/util/ActionMenu;", "convert", "(ZLjava/util/List;)Ljava/util/List;", "action", "", AuthSource.SEND_ABUSE, "(Lcom/avito/android/remote/model/Action;)Ljava/lang/Integer;", "", "Ljava/lang/String;", "sharingTitle", "<init>", "(Ljava/lang/String;)V", "user-advert_release"}, k = 1, mv = {1, 4, 2})
public final class MyAdvertDetailsActionMenuConverterImpl implements MyAdvertDetailsActionMenuConverter {
    public final String a;

    public MyAdvertDetailsActionMenuConverterImpl(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "sharingTitle");
        this.a = str;
    }

    @DrawableRes
    public final Integer a(Action action) {
        String type = action.getType();
        if (type == null) {
            type = action.getDeepLink().getPath();
        }
        switch (type.hashCode()) {
            case -511858412:
                if (type.equals(DraftPublicationLink.PATH)) {
                    return Integer.valueOf(R.drawable.ic_edit_24);
                }
                break;
            case -257242543:
                if (type.equals(MyAdvertLink.Edit.PATH)) {
                    return Integer.valueOf(R.drawable.ic_edit_24);
                }
                break;
            case 1734486816:
                if (type.equals(DraftDeletionLink.PATH)) {
                    return Integer.valueOf(R.drawable.ic_delete_24);
                }
                break;
            case 1870392370:
                if (type.equals(MyAdvertLink.Delete.PATH)) {
                    return Integer.valueOf(R.drawable.ic_delete_24);
                }
                break;
        }
        return null;
    }

    @Override // com.avito.android.user_advert.advert.MyAdvertDetailsActionMenuConverter
    @NotNull
    public List<ActionMenu> convert(boolean z, @NotNull List<Action> list) {
        ArrayList i0 = a.i0(list, "actions");
        if (z) {
            i0.add(new ActionMenu(this.a, 1, Integer.valueOf(R.drawable.ic_share_24_blue), null, null, 24, null));
        }
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(list, 10));
        for (T t : list) {
            arrayList.add(new ActionMenu(t.getTitle(), a(t) == null ? 0 : 1, a(t), Integer.valueOf(com.avito.android.lib.design.R.attr.blue), null, 16, null));
        }
        i0.addAll(arrayList);
        return i0;
    }
}
