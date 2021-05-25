package com.avito.android.advert_core.dialog;

import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.DialogDeepLink;
import com.avito.android.remote.model.DeepLinksDialogInfo;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import org.jetbrains.annotations.NotNull;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0003\"\u0016\u0010\u0001\u001a\u00020\u00008\u0000@\u0000XT¢\u0006\u0006\n\u0004\b\u0001\u0010\u0002¨\u0006\u0003"}, d2 = {"", "DEEPLINK_ARG", "Ljava/lang/String;", "advert-core_release"}, k = 2, mv = {1, 4, 2})
public final class DialogDeepLinkActivityKt {
    @NotNull
    public static final String DEEPLINK_ARG = "DEEPLINK";

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            DialogDeepLink.ControlsDirection.values();
            int[] iArr = new int[2];
            $EnumSwitchMapping$0 = iArr;
            iArr[0] = 1;
            iArr[1] = 2;
            DialogDeepLink.DialogButtonStyle.values();
            int[] iArr2 = new int[3];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[0] = 1;
            iArr2[1] = 2;
            iArr2[2] = 3;
        }
    }

    public static final DeepLinksDialogInfo access$toInfo(DialogDeepLink dialogDeepLink) {
        DeepLinksDialogInfo.ControlsDirection controlsDirection;
        DeepLinksDialogInfo.ActionType actionType;
        String title = dialogDeepLink.getTitle();
        String text = dialogDeepLink.getText();
        List<DialogDeepLink.DialogButton> buttons = dialogDeepLink.getButtons();
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(buttons, 10));
        for (T t : buttons) {
            String text2 = t.getText();
            DeepLink action = t.getAction();
            int ordinal = t.getStyle().ordinal();
            if (ordinal == 0) {
                actionType = DeepLinksDialogInfo.ActionType.POSITIVE;
            } else if (ordinal == 1) {
                actionType = DeepLinksDialogInfo.ActionType.NEUTRAL;
            } else if (ordinal == 2) {
                actionType = DeepLinksDialogInfo.ActionType.NEGATIVE;
            } else {
                throw new NoWhenBranchMatchedException();
            }
            arrayList.add(new DeepLinksDialogInfo.Action(text2, action, actionType));
        }
        Boolean valueOf = Boolean.valueOf(dialogDeepLink.isCancellable());
        Boolean valueOf2 = Boolean.valueOf(dialogDeepLink.getShouldShowCloseControl());
        int ordinal2 = dialogDeepLink.getControlsDirection().ordinal();
        if (ordinal2 == 0) {
            controlsDirection = DeepLinksDialogInfo.ControlsDirection.HORIZONTAL;
        } else if (ordinal2 == 1) {
            controlsDirection = DeepLinksDialogInfo.ControlsDirection.VERTICAL;
        } else {
            throw new NoWhenBranchMatchedException();
        }
        return new DeepLinksDialogInfo(title, text, arrayList, controlsDirection, valueOf, valueOf2);
    }
}
