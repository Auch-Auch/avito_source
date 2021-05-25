package com.avito.android.async_phone_core;

import com.avito.android.advert_core.analytics.contactbar.PhonePageSourceKt;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.DialogDeepLink;
import com.avito.android.remote.model.DialogInfo;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/remote/model/DialogInfo;", "Lcom/avito/android/deep_linking/links/DeepLink;", "toDialogDeepLink", "(Lcom/avito/android/remote/model/DialogInfo;)Lcom/avito/android/deep_linking/links/DeepLink;", "async-phone-core_release"}, k = 2, mv = {1, 4, 2})
public final class UtilsKt {
    @NotNull
    public static final DeepLink toDialogDeepLink(@NotNull DialogInfo dialogInfo) {
        DialogDeepLink.ControlsDirection controlsDirection;
        T t;
        T t2;
        DialogDeepLink.DialogButtonStyle dialogButtonStyle;
        String text;
        String text2;
        Intrinsics.checkNotNullParameter(dialogInfo, "$this$toDialogDeepLink");
        String controlsDirection2 = dialogInfo.getControlsDirection();
        if (controlsDirection2.hashCode() == -1984141450 && controlsDirection2.equals("vertical")) {
            controlsDirection = DialogDeepLink.ControlsDirection.VERTICAL;
        } else {
            controlsDirection = DialogDeepLink.ControlsDirection.HORIZONTAL;
        }
        Iterator<T> it = dialogInfo.getContent().iterator();
        while (true) {
            t = null;
            if (!it.hasNext()) {
                t2 = null;
                break;
            }
            t2 = it.next();
            if (Intrinsics.areEqual(t2.getStyle(), "heading")) {
                break;
            }
        }
        T t3 = t2;
        Iterator<T> it2 = dialogInfo.getContent().iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            T next = it2.next();
            if (Intrinsics.areEqual(next.getStyle(), SDKConstants.PARAM_A2U_BODY)) {
                t = next;
                break;
            }
        }
        T t4 = t;
        boolean isCancellable = dialogInfo.isCancellable();
        boolean shouldShowCloseControl = dialogInfo.getShouldShowCloseControl();
        String str = "";
        String str2 = (t3 == null || (text2 = t3.getText()) == null) ? str : text2;
        if (!(t4 == null || (text = t4.getText()) == null)) {
            str = text;
        }
        List<DialogInfo.Control> controls = dialogInfo.getControls();
        ArrayList<DialogInfo.Control> arrayList = new ArrayList();
        for (T t5 : controls) {
            if (Intrinsics.areEqual(t5.getType(), PhonePageSourceKt.PHONE_SOURCE_BUTTON)) {
                arrayList.add(t5);
            }
        }
        ArrayList arrayList2 = new ArrayList(e.collectionSizeOrDefault(arrayList, 10));
        for (DialogInfo.Control control : arrayList) {
            String style = control.getStyle();
            int hashCode = style.hashCode();
            if (hashCode != -1339091421) {
                if (hashCode == -314765822 && style.equals("primary")) {
                    dialogButtonStyle = DialogDeepLink.DialogButtonStyle.PRIMARY;
                    arrayList2.add(new DialogDeepLink.DialogButton(control.getAction(), control.getTitle(), dialogButtonStyle));
                }
            } else if (style.equals("danger")) {
                dialogButtonStyle = DialogDeepLink.DialogButtonStyle.DANGER;
                arrayList2.add(new DialogDeepLink.DialogButton(control.getAction(), control.getTitle(), dialogButtonStyle));
            }
            dialogButtonStyle = DialogDeepLink.DialogButtonStyle.SECONDARY;
            arrayList2.add(new DialogDeepLink.DialogButton(control.getAction(), control.getTitle(), dialogButtonStyle));
        }
        return new DialogDeepLink(controlsDirection, isCancellable, shouldShowCloseControl, str, arrayList2, str2);
    }
}
