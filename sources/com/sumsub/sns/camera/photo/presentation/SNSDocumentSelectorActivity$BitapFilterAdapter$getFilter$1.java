package com.sumsub.sns.camera.photo.presentation;

import android.widget.Filter;
import com.sumsub.sns.camera.photo.presentation.SNSDocumentSelectorActivity;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J#\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0014¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"com/sumsub/sns/camera/photo/presentation/SNSDocumentSelectorActivity$BitapFilterAdapter$getFilter$1", "Landroid/widget/Filter;", "", "constraint", "Landroid/widget/Filter$FilterResults;", "performFiltering", "(Ljava/lang/CharSequence;)Landroid/widget/Filter$FilterResults;", "results", "", "publishResults", "(Ljava/lang/CharSequence;Landroid/widget/Filter$FilterResults;)V", "sns-camera-photo-document-picker_release"}, k = 1, mv = {1, 4, 2})
public final class SNSDocumentSelectorActivity$BitapFilterAdapter$getFilter$1 extends Filter {
    public final /* synthetic */ SNSDocumentSelectorActivity.BitapFilterAdapter a;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    public SNSDocumentSelectorActivity$BitapFilterAdapter$getFilter$1(SNSDocumentSelectorActivity.BitapFilterAdapter bitapFilterAdapter) {
        this.a = bitapFilterAdapter;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:11:0x003e */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.util.List, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.util.List<java.lang.String>] */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.util.ArrayList] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // android.widget.Filter
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.widget.Filter.FilterResults performFiltering(@org.jetbrains.annotations.Nullable java.lang.CharSequence r9) {
        /*
            r8 = this;
            android.widget.Filter$FilterResults r0 = new android.widget.Filter$FilterResults
            r0.<init>()
            if (r9 == 0) goto L_0x003a
            com.sumsub.sns.core.common.Bitap r1 = new com.sumsub.sns.core.common.Bitap
            java.lang.String r9 = r9.toString()
            r1.<init>(r9)
            com.sumsub.sns.camera.photo.presentation.SNSDocumentSelectorActivity$BitapFilterAdapter r9 = r8.a
            java.util.List<java.lang.String> r9 = r9.a
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.Iterator r9 = r9.iterator()
        L_0x001d:
            boolean r3 = r9.hasNext()
            if (r3 == 0) goto L_0x003e
            java.lang.Object r3 = r9.next()
            r4 = r3
            java.lang.String r4 = (java.lang.String) r4
            r5 = 1
            java.lang.String[] r6 = new java.lang.String[r5]
            r7 = 0
            r6[r7] = r4
            boolean r4 = r1.fuzzySearch(r5, r6)
            if (r4 == 0) goto L_0x001d
            r2.add(r3)
            goto L_0x001d
        L_0x003a:
            com.sumsub.sns.camera.photo.presentation.SNSDocumentSelectorActivity$BitapFilterAdapter r9 = r8.a
            java.util.List<java.lang.String> r2 = r9.a
        L_0x003e:
            com.sumsub.sns.core.SNSMobileSDK r9 = com.sumsub.sns.core.SNSMobileSDK.INSTANCE
            java.util.Locale r9 = r9.getLocale()
            java.text.Collator r9 = java.text.Collator.getInstance(r9)
            java.util.Collections.sort(r2, r9)
            r0.values = r2
            int r9 = r2.size()
            r0.count = r9
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.camera.photo.presentation.SNSDocumentSelectorActivity$BitapFilterAdapter$getFilter$1.performFiltering(java.lang.CharSequence):android.widget.Filter$FilterResults");
    }

    @Override // android.widget.Filter
    public void publishResults(@Nullable CharSequence charSequence, @Nullable Filter.FilterResults filterResults) {
        Object obj = null;
        Object obj2 = filterResults != null ? filterResults.values : null;
        if (obj2 instanceof List) {
            obj = obj2;
        }
        List list = (List) obj;
        if (list != null) {
            this.a.clear();
            this.a.addAll(list);
            this.a.notifyDataSetChanged();
        }
    }
}
