package com.avito.android.payment.top_up.form;

import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import com.avito.android.payment.DecoratedItems;
import com.avito.android.payment.top_up.form.ScreenState;
import com.avito.android.payment.top_up.form.items.bubble.BubbleItem;
import com.avito.android.payment.top_up.form.items.input.TopUpInputItem;
import com.avito.android.payment.top_up.form.items.shortcut_section.ShortcutSectionItem;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.category_parameters.IntParameter;
import com.avito.android.remote.model.category_parameters.ParametersTree;
import com.avito.android.remote.model.category_parameters.base.ParameterSlot;
import com.avito.android.remote.model.payment.top_up.TopUpForm;
import com.avito.android.remote.model.payment.top_up.TopUpHint;
import com.avito.android.ui.VerticalListItemDecoration;
import com.avito.konveyor.blueprint.Item;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.avito.component.button.ButtonItem;
import ru.avito.component.info_label.InfoLabelItem;
import ru.avito.component.info_label.InfoLevel;
import t6.n.d;
import t6.n.e;
import t6.y.m;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\f¢\u0006\u0004\b\u0010\u0010\u0011J/\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/avito/android/payment/top_up/form/TopUpFormItemConverterImpl;", "Lcom/avito/android/payment/top_up/form/TopUpFormItemConverter;", "Lcom/avito/android/remote/model/payment/top_up/TopUpForm;", "form", "Lcom/avito/android/remote/model/category_parameters/ParametersTree;", ScreenPublicConstsKt.CONTENT_TYPE_PUBLISH_PARAMETERS_INIT, "", "forceInputUpdate", "forceKeyboard", "Lcom/avito/android/payment/top_up/form/ScreenState$Content;", "convert", "(Lcom/avito/android/remote/model/payment/top_up/TopUpForm;Lcom/avito/android/remote/model/category_parameters/ParametersTree;ZZ)Lcom/avito/android/payment/top_up/form/ScreenState$Content;", "Lcom/avito/android/payment/top_up/form/TopUpFormResourceProvider;", AuthSource.SEND_ABUSE, "Lcom/avito/android/payment/top_up/form/TopUpFormResourceProvider;", "resourceProvider", "<init>", "(Lcom/avito/android/payment/top_up/form/TopUpFormResourceProvider;)V", "payment_release"}, k = 1, mv = {1, 4, 2})
public final class TopUpFormItemConverterImpl implements TopUpFormItemConverter {
    public final TopUpFormResourceProvider a;

    public TopUpFormItemConverterImpl(@NotNull TopUpFormResourceProvider topUpFormResourceProvider) {
        Intrinsics.checkNotNullParameter(topUpFormResourceProvider, "resourceProvider");
        this.a = topUpFormResourceProvider;
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x00c7: APUT  
      (r14v5 com.avito.konveyor.blueprint.Item[])
      (0 ??[int, short, byte, char])
      (wrap: com.avito.android.payment.top_up.form.items.shortcut_section.ShortcutSectionItem : 0x00c4: CONSTRUCTOR  (r4v7 com.avito.android.payment.top_up.form.items.shortcut_section.ShortcutSectionItem) = ("shortcuts_section"), (r8v0 java.util.ArrayList) call: com.avito.android.payment.top_up.form.items.shortcut_section.ShortcutSectionItem.<init>(java.lang.String, java.util.List):void type: CONSTRUCTOR)
     */
    @Override // com.avito.android.payment.top_up.form.TopUpFormItemConverter
    @NotNull
    public ScreenState.Content convert(@NotNull TopUpForm topUpForm, @NotNull ParametersTree parametersTree, boolean z, boolean z2) {
        String str;
        Intrinsics.checkNotNullParameter(topUpForm, "form");
        Intrinsics.checkNotNullParameter(parametersTree, ScreenPublicConstsKt.CONTENT_TYPE_PUBLISH_PARAMETERS_INIT);
        String title = topUpForm.getTitle();
        ArrayList arrayList = new ArrayList();
        ParameterSlot firstParameterOfType = parametersTree.getFirstParameterOfType(IntParameter.class);
        Intrinsics.checkNotNull(firstParameterOfType);
        IntParameter intParameter = (IntParameter) firstParameterOfType;
        String id = intParameter.getId();
        Long l = (Long) intParameter.getValue();
        if (l == null || (str = String.valueOf(l.longValue())) == null) {
            str = "";
        }
        arrayList.add(new TopUpInputItem(id, str, z));
        String error = intParameter.getError();
        if (!(error == null || m.isBlank(error))) {
            String str2 = intParameter.getId() + " info_label";
            String error2 = intParameter.getError();
            Intrinsics.checkNotNull(error2);
            arrayList.add(new InfoLabelItem(str2, error2, InfoLevel.ERROR));
        }
        Item[] itemArr = new Item[2];
        ParameterSlot firstParameterOfType2 = parametersTree.getFirstParameterOfType(IntParameter.class);
        Intrinsics.checkNotNull(firstParameterOfType2);
        String id2 = ((IntParameter) firstParameterOfType2).getId();
        List<TopUpHint> hints = topUpForm.getHints();
        ArrayList arrayList2 = new ArrayList(e.collectionSizeOrDefault(hints, 10));
        Iterator<T> it = hints.iterator();
        while (it.hasNext()) {
            arrayList2.add(new BubbleItem(id2, String.valueOf(it.next().getValue())));
        }
        itemArr[0] = new ShortcutSectionItem("shortcuts_section", arrayList2);
        ParameterSlot firstParameterOfType3 = parametersTree.getFirstParameterOfType(IntParameter.class);
        Intrinsics.checkNotNull(firstParameterOfType3);
        itemArr[1] = new ButtonItem("submit_button", !((IntParameter) firstParameterOfType3).hasError(), topUpForm.getSubmitText());
        List plus = CollectionsKt___CollectionsKt.plus((Collection) arrayList, (Iterable) CollectionsKt__CollectionsKt.listOf((Object[]) itemArr));
        VerticalListItemDecoration.Builder builder = new VerticalListItemDecoration.Builder(null, 1, null);
        builder.setDividerForItemAt(0, this.a.getInputItemDivider());
        return new ScreenState.Content(title, new DecoratedItems(plus, d.listOf(builder.build())), z2);
    }
}
