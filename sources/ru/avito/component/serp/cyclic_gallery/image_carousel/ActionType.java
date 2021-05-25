package ru.avito.component.serp.cyclic_gallery.image_carousel;

import androidx.annotation.DrawableRes;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui_components.R;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\r\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u001d\b\u0002\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0002\u0012\b\b\u0001\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\fR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\n\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006j\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lru/avito/component/serp/cyclic_gallery/image_carousel/ActionType;", "", "", AuthSource.SEND_ABUSE, "I", "getIcon", "()I", "icon", AuthSource.BOOKING_ORDER, "getBackground", "background", "<init>", "(Ljava/lang/String;III)V", "CALL", "WRITE", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public enum ActionType {
    CALL(R.drawable.call_white, R.drawable.gallery_call_action_item_circle),
    WRITE(R.drawable.message_white, R.drawable.gallery_write_action_item_circle);
    
    public final int a;
    public final int b;

    /* access modifiers changed from: public */
    ActionType(@DrawableRes int i, @DrawableRes int i2) {
        this.a = i;
        this.b = i2;
    }

    public final int getBackground() {
        return this.b;
    }

    public final int getIcon() {
        return this.a;
    }
}
