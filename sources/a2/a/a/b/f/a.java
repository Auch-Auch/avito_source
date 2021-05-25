package a2.a.a.b.f;

import com.avito.android.authorization.login_suggests.Suggest;
import com.avito.android.remote.model.AuthSuggestsResult;
import io.reactivex.functions.Function;
import java.util.LinkedHashMap;
import java.util.List;
public final class a<T, R> implements Function<AuthSuggestsResult, List<? extends Suggest>> {
    public final /* synthetic */ LinkedHashMap a;

    public a(LinkedHashMap linkedHashMap) {
        this.a = linkedHashMap;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x008a  */
    @Override // io.reactivex.functions.Function
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<? extends com.avito.android.authorization.login_suggests.Suggest> apply(com.avito.android.remote.model.AuthSuggestsResult r10) {
        /*
            r9 = this;
            com.avito.android.remote.model.AuthSuggestsResult r10 = (com.avito.android.remote.model.AuthSuggestsResult) r10
            java.lang.String r0 = "suggestResult"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.util.LinkedHashMap r0 = r9.a
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.Set r0 = r0.entrySet()
            java.util.Iterator r0 = r0.iterator()
        L_0x0016:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x00d0
            java.lang.Object r2 = r0.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            java.util.List r3 = r10.getSuggests()
            java.util.Iterator r3 = r3.iterator()
        L_0x002a:
            boolean r4 = r3.hasNext()
            r5 = 0
            if (r4 == 0) goto L_0x0049
            java.lang.Object r4 = r3.next()
            r6 = r4
            com.avito.android.remote.model.AuthSuggestItem r6 = (com.avito.android.remote.model.AuthSuggestItem) r6
            java.lang.String r6 = r6.getHashUserId()
            java.lang.Object r7 = r2.getKey()
            java.lang.String r7 = (java.lang.String) r7
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual(r6, r7)
            if (r6 == 0) goto L_0x002a
            goto L_0x004a
        L_0x0049:
            r4 = r5
        L_0x004a:
            com.avito.android.remote.model.AuthSuggestItem r4 = (com.avito.android.remote.model.AuthSuggestItem) r4
            if (r4 == 0) goto L_0x00c9
            java.lang.Object r3 = r2.getValue()
            com.avito.android.account.LoginSuggest r3 = (com.avito.android.account.LoginSuggest) r3
            java.lang.String r3 = r3.getLogin()
            r6 = 0
            r7 = 1
            if (r3 == 0) goto L_0x0069
            int r3 = r3.length()
            if (r3 <= 0) goto L_0x0064
            r3 = 1
            goto L_0x0065
        L_0x0064:
            r3 = 0
        L_0x0065:
            if (r3 == 0) goto L_0x0069
            r3 = 1
            goto L_0x006a
        L_0x0069:
            r3 = 0
        L_0x006a:
            java.lang.String r8 = ""
            if (r3 == 0) goto L_0x008a
            com.avito.android.authorization.login_suggests.Suggest$Login r3 = new com.avito.android.authorization.login_suggests.Suggest$Login
            java.lang.String r5 = r4.getName()
            com.avito.android.remote.model.Image r4 = r4.getAvatar()
            java.lang.Object r2 = r2.getValue()
            com.avito.android.account.LoginSuggest r2 = (com.avito.android.account.LoginSuggest) r2
            java.lang.String r2 = r2.getLogin()
            if (r2 == 0) goto L_0x0085
            r8 = r2
        L_0x0085:
            r3.<init>(r5, r4, r8)
        L_0x0088:
            r5 = r3
            goto L_0x00c9
        L_0x008a:
            java.lang.Object r3 = r2.getValue()
            com.avito.android.account.LoginSuggest r3 = (com.avito.android.account.LoginSuggest) r3
            java.lang.String r3 = r3.getSocial()
            if (r3 == 0) goto L_0x00a2
            int r3 = r3.length()
            if (r3 <= 0) goto L_0x009e
            r3 = 1
            goto L_0x009f
        L_0x009e:
            r3 = 0
        L_0x009f:
            if (r3 == 0) goto L_0x00a2
            r6 = 1
        L_0x00a2:
            if (r6 == 0) goto L_0x00c9
            com.avito.android.authorization.login_suggests.Suggest$Social r3 = new com.avito.android.authorization.login_suggests.Suggest$Social
            java.lang.String r5 = r4.getName()
            com.avito.android.remote.model.Image r4 = r4.getAvatar()
            java.lang.Object r6 = r2.getValue()
            com.avito.android.account.LoginSuggest r6 = (com.avito.android.account.LoginSuggest) r6
            java.lang.String r6 = r6.getSocial()
            if (r6 == 0) goto L_0x00bb
            r8 = r6
        L_0x00bb:
            java.lang.Object r2 = r2.getValue()
            com.avito.android.account.LoginSuggest r2 = (com.avito.android.account.LoginSuggest) r2
            java.lang.String r2 = r2.getSocialId()
            r3.<init>(r5, r4, r8, r2)
            goto L_0x0088
        L_0x00c9:
            if (r5 == 0) goto L_0x0016
            r1.add(r5)
            goto L_0x0016
        L_0x00d0:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: a2.a.a.b.f.a.apply(java.lang.Object):java.lang.Object");
    }
}
