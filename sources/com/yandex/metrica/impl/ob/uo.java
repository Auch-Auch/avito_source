package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import com.yandex.metrica.impl.ob.uy;
public class uo extends ud<String> {
    private final adn<String> a;

    public uo(@NonNull String str, @NonNull String str2, @NonNull adn<String> adn, @NonNull adw<String> adw, @NonNull ua uaVar) {
        super(0, str, str2, adw, uaVar);
        this.a = adn;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.yandex.metrica.impl.ob.adn<java.lang.String> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.yandex.metrica.impl.ob.ud
    public void a(@NonNull uy.a.C0346a aVar) {
        String str = (String) this.a.a(b());
        aVar.e.b = str == null ? new byte[0] : str.getBytes();
    }
}
