package com.avito.android.express_cv;

import com.avito.android.Features;
import com.avito.android.category_parameters.CategoryParametersElementConverter;
import com.avito.android.category_parameters.ParameterElement;
import com.avito.android.component.disclaimer.DisclaimerItem;
import com.avito.android.epress_cv.remote.model.ExistedCv;
import com.avito.android.epress_cv.remote.model.ExpressCvInfo;
import com.avito.android.express_cv.existed_cv.item.ExistedCvItem;
import com.avito.android.express_cv.existed_cv.item.FlatButtonItem;
import com.avito.android.express_cv.existed_cv.item.TextItem;
import com.avito.android.express_cv.tabs.CvTabItem;
import com.avito.android.express_cv.tabs.ExistedCvTabItem;
import com.avito.android.express_cv.tabs.NewCvTabItem;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.category_parameters.CategoryParameters;
import com.avito.android.remote.model.text.AttributedText;
import com.avito.conveyor_item.Item;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.messenger.internal.jsonrpc.CommonKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u001a\u001a\u00020\u0017\u0012\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001d\u0010\u001eJA\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\f\u0010\rJ!\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u001d\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\n2\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001f"}, d2 = {"Lcom/avito/android/express_cv/ExpressCvDataConverterImpl;", "Lcom/avito/android/express_cv/ExpressCvDataConverter;", "Lcom/avito/android/remote/model/category_parameters/CategoryParameters;", "categoryParams", "", "description", "Lcom/avito/android/remote/model/text/AttributedText;", "disclaimer", "actionText", "disableText", "", "Lcom/avito/conveyor_item/Item;", "convertPublishItems", "(Lcom/avito/android/remote/model/category_parameters/CategoryParameters;Ljava/lang/String;Lcom/avito/android/remote/model/text/AttributedText;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;", "Lcom/avito/android/epress_cv/remote/model/ExistedCv;", "existedCv", "convertExistedItems", "(Lcom/avito/android/epress_cv/remote/model/ExistedCv;)Ljava/util/List;", "Lcom/avito/android/epress_cv/remote/model/ExpressCvInfo;", CommonKt.EXTRA_RESPONSE, "Lcom/avito/android/express_cv/tabs/CvTabItem;", "convertTabs", "(Lcom/avito/android/epress_cv/remote/model/ExpressCvInfo;)Ljava/util/List;", "Lcom/avito/android/category_parameters/CategoryParametersElementConverter;", AuthSource.SEND_ABUSE, "Lcom/avito/android/category_parameters/CategoryParametersElementConverter;", "elementConverter", "Lcom/avito/android/Features;", "features", "<init>", "(Lcom/avito/android/category_parameters/CategoryParametersElementConverter;Lcom/avito/android/Features;)V", "express-cv_release"}, k = 1, mv = {1, 4, 2})
public final class ExpressCvDataConverterImpl implements ExpressCvDataConverter {
    public final CategoryParametersElementConverter a;

    public ExpressCvDataConverterImpl(@NotNull CategoryParametersElementConverter categoryParametersElementConverter, @NotNull Features features) {
        Intrinsics.checkNotNullParameter(categoryParametersElementConverter, "elementConverter");
        Intrinsics.checkNotNullParameter(features, "features");
        this.a = categoryParametersElementConverter;
    }

    @Override // com.avito.android.express_cv.ExpressCvDataConverter
    @Nullable
    public List<Item> convertExistedItems(@Nullable ExistedCv existedCv) {
        ArrayList arrayList = new ArrayList();
        if (existedCv != null) {
            arrayList.add(new TextItem(ExpressCvDataConverterKt.CV_DESCRIPTION, existedCv.getDescription()));
            int i = 0;
            for (T t : existedCv.getList()) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                T t2 = t;
                arrayList.add(new ExistedCvItem(t2.getId(), t2.getTitle(), t2.getDescription(), i == 0));
                i = i2;
            }
            arrayList.add(new ParameterElement.Button(ExpressCvDataConverterKt.ACTIVATE_CV_BUTTON, existedCv.getActionText(), null, null, null, 28, null));
            String disableText = existedCv.getDisableText();
            if (disableText != null) {
                arrayList.add(new FlatButtonItem(ExpressCvDataConverterKt.DISABLE_CV_CREATION_BUTTON, disableText));
            }
            arrayList.add(new DisclaimerItem(ExpressCvDataConverterKt.ACTIVATE_DISCLAIMER, existedCv.getDisclaimer()));
        }
        return arrayList;
    }

    @Override // com.avito.android.express_cv.ExpressCvDataConverter
    @NotNull
    public List<Item> convertPublishItems(@NotNull CategoryParameters categoryParameters, @Nullable String str, @NotNull AttributedText attributedText, @NotNull String str2, @Nullable String str3) {
        Intrinsics.checkNotNullParameter(categoryParameters, "categoryParams");
        Intrinsics.checkNotNullParameter(attributedText, "disclaimer");
        Intrinsics.checkNotNullParameter(str2, "actionText");
        ArrayList arrayList = new ArrayList();
        arrayList.add(new TextItem(ExpressCvDataConverterKt.CV_DESCRIPTION, str));
        List convert$default = CategoryParametersElementConverter.convert$default(this.a, categoryParameters, null, null, 6, null);
        HashSet hashSet = new HashSet();
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : convert$default) {
            if (hashSet.add(((Item) obj).getStringId())) {
                arrayList2.add(obj);
            }
        }
        List mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList2);
        mutableList.add(new ParameterElement.Button(ExpressCvDataConverterKt.PUBLISH_CV_BUTTON, str2, null, null, null, 28, null));
        if (str3 != null) {
            mutableList.add(new FlatButtonItem(ExpressCvDataConverterKt.DISABLE_CV_CREATION_BUTTON, str3));
        }
        mutableList.add(new DisclaimerItem(ExpressCvDataConverterKt.ACTIVATE_DISCLAIMER, attributedText));
        arrayList.addAll(mutableList);
        return arrayList;
    }

    @Override // com.avito.android.express_cv.ExpressCvDataConverter
    @NotNull
    public List<CvTabItem> convertTabs(@NotNull ExpressCvInfo expressCvInfo) {
        Intrinsics.checkNotNullParameter(expressCvInfo, CommonKt.EXTRA_RESPONSE);
        List<CvTabItem> mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new NewCvTabItem(expressCvInfo.getPublishCv().getTitle()));
        ExistedCv existedCv = expressCvInfo.getExistedCv();
        if (existedCv != null) {
            mutableListOf.add(new ExistedCvTabItem(existedCv.getTitle()));
        }
        return mutableListOf;
    }
}
