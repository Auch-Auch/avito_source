package com.avito.android.remote.model;

import android.os.Parcel;
import com.avito.android.remote.model.SearchProperties;
import com.avito.android.util.ParcelsKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Landroid/os/Parcel;", "Lcom/avito/android/remote/model/SearchProperties$BooleanRule;", "invoke", "(Landroid/os/Parcel;)Lcom/avito/android/remote/model/SearchProperties$BooleanRule;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
public final class SearchProperties$BooleanRule$Companion$CREATOR$1 extends Lambda implements Function1<Parcel, SearchProperties.BooleanRule> {
    public static final SearchProperties$BooleanRule$Companion$CREATOR$1 INSTANCE = new SearchProperties$BooleanRule$Companion$CREATOR$1();

    public SearchProperties$BooleanRule$Companion$CREATOR$1() {
        super(1);
    }

    @NotNull
    public final SearchProperties.BooleanRule invoke(@NotNull Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "$receiver");
        List createParcelableList = ParcelsKt.createParcelableList(parcel, SearchProperties.BooleanRule.Value.class);
        if (createParcelableList == null) {
            createParcelableList = CollectionsKt__CollectionsKt.emptyList();
        }
        return new SearchProperties.BooleanRule(createParcelableList);
    }
}
