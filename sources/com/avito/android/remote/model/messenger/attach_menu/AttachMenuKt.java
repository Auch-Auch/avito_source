package com.avito.android.remote.model.messenger.attach_menu;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\"\u001a\u0010\u0002\u001a\u00020\u0001*\u0004\u0018\u00010\u00008Æ\u0002@\u0006¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/remote/model/messenger/attach_menu/AttachMenu;", "", "isNullOrEmpty", "(Lcom/avito/android/remote/model/messenger/attach_menu/AttachMenu;)Z", "models_release"}, k = 2, mv = {1, 4, 2})
public final class AttachMenuKt {
    public static final boolean isNullOrEmpty(@Nullable AttachMenu attachMenu) {
        return attachMenu == null || (attachMenu.getFile() == null && attachMenu.getImage() == null && attachMenu.getItem() == null && attachMenu.getLocation() == null);
    }
}
