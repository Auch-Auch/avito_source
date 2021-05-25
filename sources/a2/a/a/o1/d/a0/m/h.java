package a2.a.a.o1.d.a0.m;

import com.avito.android.lib.design.bottom_sheet.BottomSheetMenuDialog;
import com.avito.android.messenger.R;
import com.avito.android.messenger.conversation.mvi.send.SendMessageViewImpl;
import com.avito.android.remote.model.messenger.attach_menu.AttachMenu;
import com.avito.android.remote.model.messenger.attach_menu.AttachMenuItem;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
public final class h extends Lambda implements Function1<BottomSheetMenuDialog, Unit> {
    public final /* synthetic */ SendMessageViewImpl a;
    public final /* synthetic */ AttachMenu b;
    public final /* synthetic */ Map c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public h(SendMessageViewImpl sendMessageViewImpl, AttachMenu attachMenu, Map map) {
        super(1);
        this.a = sendMessageViewImpl;
        this.b = attachMenu;
        this.c = map;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(BottomSheetMenuDialog bottomSheetMenuDialog) {
        AttachMenuItem.Location location;
        AttachMenuItem.File file;
        AttachMenuItem.Item item;
        AttachMenuItem.Image image;
        BottomSheetMenuDialog bottomSheetMenuDialog2 = bottomSheetMenuDialog;
        Intrinsics.checkNotNullParameter(bottomSheetMenuDialog2, "$receiver");
        bottomSheetMenuDialog2.setPeekHeight(SendMessageViewImpl.access$getBottomSheetPeekHeight$p(this.a));
        if (!SendMessageViewImpl.access$getFeatures$p(this.a).getMessengerDynamicAttachMenu().invoke().booleanValue()) {
            String string = SendMessageViewImpl.access$getResources$p(this.a).getString(R.string.messenger_send_bottom_sheet_menu_photo);
            Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st…_bottom_sheet_menu_photo)");
            BottomSheetMenuDialog.addMenuItem$default(bottomSheetMenuDialog2, string, Integer.valueOf(R.drawable.ic_messenger_photocamera), null, null, null, new e6(0, this), 28, null);
            String string2 = SendMessageViewImpl.access$getResources$p(this.a).getString(R.string.messenger_send_bottom_sheet_menu_item);
            Intrinsics.checkNotNullExpressionValue(string2, "resources.getString(R.st…d_bottom_sheet_menu_item)");
            BottomSheetMenuDialog.addMenuItem$default(bottomSheetMenuDialog2, string2, Integer.valueOf(R.drawable.ic_messenger_item), null, null, null, new e6(1, this), 28, null);
            String string3 = SendMessageViewImpl.access$getResources$p(this.a).getString(R.string.messenger_send_bottom_sheet_menu_location);
            Intrinsics.checkNotNullExpressionValue(string3, "resources.getString(R.st…ttom_sheet_menu_location)");
            BottomSheetMenuDialog.addMenuItem$default(bottomSheetMenuDialog2, string3, Integer.valueOf(R.drawable.ic_messenger_user_location), null, null, null, new e6(2, this), 28, null);
        } else {
            AttachMenu attachMenu = this.b;
            if (!(attachMenu == null || (image = attachMenu.getImage()) == null)) {
                BottomSheetMenuDialog.addMenuItem$default(bottomSheetMenuDialog2, image.getTitle(), Integer.valueOf(R.drawable.ic_messenger_photocamera), null, null, null, new w4(0, this, bottomSheetMenuDialog2), 28, null);
            }
            AttachMenu attachMenu2 = this.b;
            if (!(attachMenu2 == null || (item = attachMenu2.getItem()) == null)) {
                BottomSheetMenuDialog.addMenuItem$default(bottomSheetMenuDialog2, item.getTitle(), Integer.valueOf(R.drawable.ic_messenger_item), null, null, null, new w4(1, this, bottomSheetMenuDialog2), 28, null);
            }
            AttachMenu attachMenu3 = this.b;
            if (!(attachMenu3 == null || (file = attachMenu3.getFile()) == null)) {
                BottomSheetMenuDialog.addMenuItem$default(bottomSheetMenuDialog2, file.getTitle(), Integer.valueOf(R.drawable.ic_messenger_file_24), null, null, SendMessageViewImpl.access$getFileSharingOnboardingIsShown$p(this.a, this.c) ? Integer.valueOf(com.avito.android.ui_components.R.drawable.ic_new_feature_badge) : null, new w4(2, this, bottomSheetMenuDialog2), 12, null);
            }
            AttachMenu attachMenu4 = this.b;
            if (!(attachMenu4 == null || (location = attachMenu4.getLocation()) == null)) {
                BottomSheetMenuDialog.addMenuItem$default(bottomSheetMenuDialog2, location.getTitle(), Integer.valueOf(R.drawable.ic_messenger_user_location), null, null, null, new w4(3, this, bottomSheetMenuDialog2), 28, null);
            }
        }
        bottomSheetMenuDialog2.setOnDismissListener(new f(this));
        bottomSheetMenuDialog2.setOnCancelListener(new g(this));
        bottomSheetMenuDialog2.show();
        return Unit.INSTANCE;
    }
}
