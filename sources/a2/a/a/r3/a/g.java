package a2.a.a.r3.a;

import android.content.Context;
import com.avito.android.lib.design.bottom_sheet.BottomSheetMenuDialog;
import com.avito.android.util.Contexts;
import com.avito.android.verification.verification_status.VerificationStatusScreenData;
import com.avito.android.verification.verification_status.VerificationStatusViewImpl;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
public final class g extends Lambda implements Function1<BottomSheetMenuDialog, Unit> {
    public final /* synthetic */ VerificationStatusViewImpl a;
    public final /* synthetic */ List b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public g(VerificationStatusViewImpl verificationStatusViewImpl, List list) {
        super(1);
        this.a = verificationStatusViewImpl;
        this.b = list;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(BottomSheetMenuDialog bottomSheetMenuDialog) {
        Integer num;
        BottomSheetMenuDialog bottomSheetMenuDialog2 = bottomSheetMenuDialog;
        Intrinsics.checkNotNullParameter(bottomSheetMenuDialog2, "$receiver");
        for (VerificationStatusScreenData.Action action : this.b) {
            String title = action.getTitle();
            Integer iconAttrId = action.getIconAttrId();
            if (iconAttrId != null) {
                int intValue = iconAttrId.intValue();
                Context context = bottomSheetMenuDialog2.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                num = Integer.valueOf(Contexts.getResourceIdByAttr(context, intValue));
            } else {
                num = null;
            }
            Context context2 = bottomSheetMenuDialog2.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "context");
            BottomSheetMenuDialog.addMenuItem$default(bottomSheetMenuDialog2, title, num, Integer.valueOf(Contexts.getColorByAttr(context2, action.getIconTintColorAttrId())), null, null, new f(action, this, bottomSheetMenuDialog2), 24, null);
        }
        bottomSheetMenuDialog2.setFitContentPeekHeight(true);
        return Unit.INSTANCE;
    }
}
