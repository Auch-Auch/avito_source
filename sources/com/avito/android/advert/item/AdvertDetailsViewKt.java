package com.avito.android.advert.item;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.avito.android.advert_details.R;
import com.avito.android.lib.design.bottom_sheet.BottomSheetDialog;
import com.avito.android.util.TextViews;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u000f\u001a\u001d\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0004\u0010\u0005\"\u0016\u0010\u0007\u001a\u00020\u00068\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0007\u0010\b\"\u0016\u0010\n\u001a\u00020\t8\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\n\u0010\u000b\"\u0016\u0010\f\u001a\u00020\u00068\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\f\u0010\b\"\u0016\u0010\r\u001a\u00020\u00068\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\r\u0010\b\"\u0016\u0010\u000e\u001a\u00020\u00068\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u000e\u0010\b\"\u0016\u0010\u0010\u001a\u00020\u000f8\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011\"\u0016\u0010\u0012\u001a\u00020\u000f8\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0012\u0010\u0011\"\u0016\u0010\u0013\u001a\u00020\u00068\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0013\u0010\b\"\u0016\u0010\u0014\u001a\u00020\u00068\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0014\u0010\b\"\u0016\u0010\u0015\u001a\u00020\u00068\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0015\u0010\b\"\u0016\u0010\u0016\u001a\u00020\u00068\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0016\u0010\b\"\u0016\u0010\u0017\u001a\u00020\u00068\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0017\u0010\b\"\u0016\u0010\u0018\u001a\u00020\u00068\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0018\u0010\b\"\u0016\u0010\u0019\u001a\u00020\u00068\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0019\u0010\b\"\u0016\u0010\u001a\u001a\u00020\u00068\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u001a\u0010\b\"\u0016\u0010\u001b\u001a\u00020\u00068\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u001b\u0010\b\"\u0016\u0010\u001c\u001a\u00020\u00068\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u001c\u0010\b\"\u0016\u0010\u001d\u001a\u00020\u00068\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u001d\u0010\b¨\u0006\u001e"}, d2 = {"Lcom/avito/android/lib/design/bottom_sheet/BottomSheetDialog;", "", "title", "", "setMarketplaceCustomHeader", "(Lcom/avito/android/lib/design/bottom_sheet/BottomSheetDialog;Ljava/lang/String;)V", "", "REQ_BADGE_DETAILS", "I", "", "NO_CALL_FEEDBACK_SNACKBAR_DELAY_MS", "J", "REQ_AUTH_ADD_NOTE", "REQ_ADVERT_CONTACTS_SERVICES_BUY", "REQ_EXPRESS_CV", "", "FAST_SMOOTH_SCROLL_SPEED_PER_PX", "F", "DEFAULT_SMOOTH_SCROLL_SPEED_PER_PX", "REQ_CREATE_CHANNEL", "REQ_RATING_PUBLISH", "REQ_SUBSCRIBE_ITEM_SELLER", "REQ_AUTH_DOMOTEKA_FLAT_NUMBER_REQUEST", "REQ_DELIVERY", "REQ_NATIVE_SHARING", "REQ_PHOTO_GALLERY", "REQ_SUBSCRIBE_RECOMMENDED_SELLER", "REQ_LOCATION", "REQ_ADD_NOTE", "REQ_AUTHENTICATE", "advert-details_release"}, k = 2, mv = {1, 4, 2})
public final class AdvertDetailsViewKt {
    public static final float DEFAULT_SMOOTH_SCROLL_SPEED_PER_PX = 80.0f;
    public static final float FAST_SMOOTH_SCROLL_SPEED_PER_PX = 25.0f;
    public static final long NO_CALL_FEEDBACK_SNACKBAR_DELAY_MS = 500;
    public static final int REQ_ADD_NOTE = 8;
    public static final int REQ_ADVERT_CONTACTS_SERVICES_BUY = 2;
    public static final int REQ_AUTHENTICATE = 1;
    public static final int REQ_AUTH_ADD_NOTE = 7;
    public static final int REQ_AUTH_DOMOTEKA_FLAT_NUMBER_REQUEST = 13;
    public static final int REQ_BADGE_DETAILS = 14;
    public static final int REQ_CREATE_CHANNEL = 11;
    public static final int REQ_DELIVERY = 5;
    public static final int REQ_EXPRESS_CV = 9;
    public static final int REQ_LOCATION = 3;
    public static final int REQ_NATIVE_SHARING = 10;
    public static final int REQ_PHOTO_GALLERY = 4;
    public static final int REQ_RATING_PUBLISH = 12;
    public static final int REQ_SUBSCRIBE_ITEM_SELLER = 15;
    public static final int REQ_SUBSCRIBE_RECOMMENDED_SELLER = 16;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ BottomSheetDialog a;

        public a(BottomSheetDialog bottomSheetDialog) {
            this.a = bottomSheetDialog;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.close();
        }
    }

    public static final void setMarketplaceCustomHeader(@NotNull BottomSheetDialog bottomSheetDialog, @Nullable String str) {
        Intrinsics.checkNotNullParameter(bottomSheetDialog, "$this$setMarketplaceCustomHeader");
        BottomSheetDialog.setHeaderParams$default(bottomSheetDialog, null, null, false, true, 7, null);
        View inflate = LayoutInflater.from(bottomSheetDialog.getContext()).inflate(R.layout.marketplace_bottomsheet_custom_header, (ViewGroup) null);
        View findViewById = inflate.findViewById(R.id.marketplace_custom_header_close);
        Intrinsics.checkNotNullExpressionValue(findViewById, "customHeaderView.findVie…lace_custom_header_close)");
        findViewById.setOnClickListener(new a(bottomSheetDialog));
        View findViewById2 = inflate.findViewById(R.id.marketplace_custom_header_title);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "customHeaderView.findVie…lace_custom_header_title)");
        TextViews.bindText$default((TextView) findViewById2, str, false, 2, null);
        Intrinsics.checkNotNullExpressionValue(inflate, "customHeaderView");
        bottomSheetDialog.setCustomHeader(inflate);
        bottomSheetDialog.forceShowHeaderThumb();
    }

    public static /* synthetic */ void setMarketplaceCustomHeader$default(BottomSheetDialog bottomSheetDialog, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        setMarketplaceCustomHeader(bottomSheetDialog, str);
    }
}
