package com.avito.android.express_cv;

import com.avito.android.epress_cv.remote.model.ExistedCv;
import com.avito.android.epress_cv.remote.model.ExpressCvInfo;
import com.avito.android.express_cv.tabs.CvTabItem;
import com.avito.android.remote.model.category_parameters.CategoryParameters;
import com.avito.android.remote.model.text.AttributedText;
import com.avito.conveyor_item.Item;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.messenger.internal.jsonrpc.CommonKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001JA\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u0004H&¢\u0006\u0004\b\f\u0010\rJ!\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH&¢\u0006\u0004\b\u0010\u0010\u0011J\u001d\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\n2\u0006\u0010\u0013\u001a\u00020\u0012H&¢\u0006\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/avito/android/express_cv/ExpressCvDataConverter;", "", "Lcom/avito/android/remote/model/category_parameters/CategoryParameters;", "categoryParams", "", "description", "Lcom/avito/android/remote/model/text/AttributedText;", "disclaimer", "actionText", "disableText", "", "Lcom/avito/conveyor_item/Item;", "convertPublishItems", "(Lcom/avito/android/remote/model/category_parameters/CategoryParameters;Ljava/lang/String;Lcom/avito/android/remote/model/text/AttributedText;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;", "Lcom/avito/android/epress_cv/remote/model/ExistedCv;", "existedCv", "convertExistedItems", "(Lcom/avito/android/epress_cv/remote/model/ExistedCv;)Ljava/util/List;", "Lcom/avito/android/epress_cv/remote/model/ExpressCvInfo;", CommonKt.EXTRA_RESPONSE, "Lcom/avito/android/express_cv/tabs/CvTabItem;", "convertTabs", "(Lcom/avito/android/epress_cv/remote/model/ExpressCvInfo;)Ljava/util/List;", "express-cv_release"}, k = 1, mv = {1, 4, 2})
public interface ExpressCvDataConverter {
    @Nullable
    List<Item> convertExistedItems(@Nullable ExistedCv existedCv);

    @NotNull
    List<Item> convertPublishItems(@NotNull CategoryParameters categoryParameters, @Nullable String str, @NotNull AttributedText attributedText, @NotNull String str2, @Nullable String str3);

    @NotNull
    List<CvTabItem> convertTabs(@NotNull ExpressCvInfo expressCvInfo);
}
