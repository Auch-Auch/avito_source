package com.avito.android.hints.repository;

import com.avito.android.hints.items.HintItem;
import com.avito.android.hints.remote.model.Hint;
import com.avito.android.hints.remote.model.HintsResult;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.text.AttributedTextFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/avito/android/hints/repository/HintsConverterImpl;", "Lcom/avito/android/hints/repository/HintsConverter;", "Lcom/avito/android/hints/remote/model/HintsResult;", "hintsResult", "", "Lcom/avito/android/hints/items/HintItem;", "convert", "(Lcom/avito/android/hints/remote/model/HintsResult;)Ljava/util/List;", "Lcom/avito/android/util/text/AttributedTextFormatter;", AuthSource.SEND_ABUSE, "Lcom/avito/android/util/text/AttributedTextFormatter;", "formatter", "<init>", "(Lcom/avito/android/util/text/AttributedTextFormatter;)V", "hints_release"}, k = 1, mv = {1, 4, 2})
public final class HintsConverterImpl implements HintsConverter {
    public final AttributedTextFormatter a;

    @Inject
    public HintsConverterImpl(@NotNull AttributedTextFormatter attributedTextFormatter) {
        Intrinsics.checkNotNullParameter(attributedTextFormatter, "formatter");
        this.a = attributedTextFormatter;
    }

    @Override // com.avito.android.hints.repository.HintsConverter
    @NotNull
    public List<HintItem> convert(@NotNull HintsResult hintsResult) {
        Intrinsics.checkNotNullParameter(hintsResult, "hintsResult");
        List<Hint> hints = hintsResult.getHints();
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(hints, 10));
        int i = 0;
        for (T t : hints) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            T t2 = t;
            String valueOf = String.valueOf(i);
            String title = t2.getTitle();
            CharSequence format = this.a.format(t2.getDescription());
            if (format == null) {
                format = "";
            }
            arrayList.add(new HintItem(valueOf, title, format, t2.getImage()));
            i = i2;
        }
        return arrayList;
    }
}
