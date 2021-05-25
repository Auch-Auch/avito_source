package com.avito.android.util;

import android.content.res.Resources;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.category_parameters.ParametersTree;
import com.avito.android.util.TemplateFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014J)\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0015"}, d2 = {"Lcom/avito/android/util/ObjectsSummaryFormatter;", "", "", "", "templates", "Lcom/avito/android/remote/model/category_parameters/ParametersTree;", "params", "formatValues", "(Ljava/util/List;Lcom/avito/android/remote/model/category_parameters/ParametersTree;)Ljava/util/List;", "Lcom/avito/android/util/DateTimeParameterFormatter;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/DateTimeParameterFormatter;", "dateFormatter", "Lcom/avito/android/util/TemplateFormatter;", AuthSource.SEND_ABUSE, "Lcom/avito/android/util/TemplateFormatter;", "templateFormatter", "Landroid/content/res/Resources;", "resources", "<init>", "(Landroid/content/res/Resources;)V", "item-temporary_release"}, k = 1, mv = {1, 4, 2})
public final class ObjectsSummaryFormatter {
    public final TemplateFormatter a = new TemplateFormatter();
    public final DateTimeParameterFormatter b;

    public ObjectsSummaryFormatter(@NotNull Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        this.b = new DateTimeParameterFormatter(resources);
    }

    @NotNull
    public final List<String> formatValues(@NotNull List<String> list, @NotNull ParametersTree parametersTree) {
        Intrinsics.checkNotNullParameter(list, "templates");
        Intrinsics.checkNotNullParameter(parametersTree, "params");
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(this.a.format(it.next(), new TemplateFormatter.Visitor(this, parametersTree) { // from class: com.avito.android.util.ObjectsSummaryFormatter$formatValues$$inlined$map$lambda$1
                public final /* synthetic */ ObjectsSummaryFormatter a;
                public final /* synthetic */ ParametersTree b;

                {
                    this.a = r1;
                    this.b = r2;
                }

                /* JADX WARNING: Code restructure failed: missing block: B:12:0x003a, code lost:
                    if (r1 != null) goto L_0x0025;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:18:0x004f, code lost:
                    if (r1 != null) goto L_0x0025;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:24:0x0064, code lost:
                    if (r1 != null) goto L_0x0025;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:35:0x008b, code lost:
                    if (r1 != null) goto L_0x0025;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:5:0x0023, code lost:
                    if (r1 != null) goto L_0x0025;
                 */
                @Override // com.avito.android.util.TemplateFormatter.Visitor
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public void visit(@org.jetbrains.annotations.NotNull android.text.Editable r4, @org.jetbrains.annotations.NotNull java.lang.String r5, int r6, int r7) {
                    /*
                        r3 = this;
                        java.lang.String r0 = "editable"
                        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
                        java.lang.String r0 = "template"
                        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
                        com.avito.android.remote.model.category_parameters.ParametersTree r0 = r3.b
                        com.avito.android.remote.model.category_parameters.base.ParameterSlot r5 = r0.findParameter(r5)
                        boolean r0 = r5 instanceof com.avito.android.remote.model.category_parameters.SelectParameter
                        r1 = 0
                        java.lang.String r2 = ""
                        if (r0 == 0) goto L_0x0028
                        com.avito.android.remote.model.category_parameters.SelectParameter r5 = (com.avito.android.remote.model.category_parameters.SelectParameter) r5
                        com.avito.android.remote.model.category_parameters.SelectParameter$Value r5 = r5.getSelectedValue()
                        if (r5 == 0) goto L_0x0023
                        java.lang.String r1 = r5.getTitle()
                    L_0x0023:
                        if (r1 == 0) goto L_0x008e
                    L_0x0025:
                        r2 = r1
                        goto L_0x008e
                    L_0x0028:
                        boolean r0 = r5 instanceof com.avito.android.remote.model.category_parameters.AddressParameter
                        if (r0 == 0) goto L_0x003d
                        com.avito.android.remote.model.category_parameters.AddressParameter r5 = (com.avito.android.remote.model.category_parameters.AddressParameter) r5
                        java.lang.Object r5 = r5.getValue()
                        com.avito.android.remote.model.category_parameters.AddressParameter$Value r5 = (com.avito.android.remote.model.category_parameters.AddressParameter.Value) r5
                        if (r5 == 0) goto L_0x003a
                        java.lang.String r1 = r5.getText()
                    L_0x003a:
                        if (r1 == 0) goto L_0x008e
                        goto L_0x0025
                    L_0x003d:
                        boolean r0 = r5 instanceof com.avito.android.remote.model.category_parameters.SubLocationParameter
                        if (r0 == 0) goto L_0x0052
                        com.avito.android.remote.model.category_parameters.SubLocationParameter r5 = (com.avito.android.remote.model.category_parameters.SubLocationParameter) r5
                        java.lang.Object r5 = r5.getValue()
                        com.avito.android.remote.model.Sublocation r5 = (com.avito.android.remote.model.Sublocation) r5
                        if (r5 == 0) goto L_0x004f
                        java.lang.String r1 = r5.getName()
                    L_0x004f:
                        if (r1 == 0) goto L_0x008e
                        goto L_0x0025
                    L_0x0052:
                        boolean r0 = r5 instanceof com.avito.android.remote.model.category_parameters.LocationParameter
                        if (r0 == 0) goto L_0x0067
                        com.avito.android.remote.model.category_parameters.LocationParameter r5 = (com.avito.android.remote.model.category_parameters.LocationParameter) r5
                        java.lang.Object r5 = r5.getValue()
                        com.avito.android.remote.model.Location r5 = (com.avito.android.remote.model.Location) r5
                        if (r5 == 0) goto L_0x0064
                        java.lang.String r1 = r5.getName()
                    L_0x0064:
                        if (r1 == 0) goto L_0x008e
                        goto L_0x0025
                    L_0x0067:
                        boolean r0 = r5 instanceof com.avito.android.remote.model.category_parameters.DateTimeParameter
                        if (r0 == 0) goto L_0x007b
                        com.avito.android.util.ObjectsSummaryFormatter r0 = r3.a
                        com.avito.android.util.DateTimeParameterFormatter r0 = com.avito.android.util.ObjectsSummaryFormatter.access$getDateFormatter$p(r0)
                        com.avito.android.remote.model.category_parameters.DateTimeParameter r5 = (com.avito.android.remote.model.category_parameters.DateTimeParameter) r5
                        java.lang.String r5 = r0.format(r5)
                        if (r5 == 0) goto L_0x008e
                        r2 = r5
                        goto L_0x008e
                    L_0x007b:
                        boolean r0 = r5 instanceof com.avito.android.remote.model.category_parameters.base.EditableParameter
                        if (r0 == 0) goto L_0x008e
                        com.avito.android.remote.model.category_parameters.base.EditableParameter r5 = (com.avito.android.remote.model.category_parameters.base.EditableParameter) r5
                        java.lang.Object r5 = r5.getValue()
                        if (r5 == 0) goto L_0x008b
                        java.lang.String r1 = r5.toString()
                    L_0x008b:
                        if (r1 == 0) goto L_0x008e
                        goto L_0x0025
                    L_0x008e:
                        r4.replace(r6, r7, r2)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.avito.android.util.ObjectsSummaryFormatter$formatValues$$inlined$map$lambda$1.visit(android.text.Editable, java.lang.String, int, int):void");
                }
            }).toString());
        }
        return arrayList;
    }
}
