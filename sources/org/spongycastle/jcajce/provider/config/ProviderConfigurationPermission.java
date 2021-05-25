package org.spongycastle.jcajce.provider.config;

import com.avito.android.remote.model.ProfileTab;
import java.security.BasicPermission;
import java.security.Permission;
import java.util.StringTokenizer;
import org.spongycastle.util.Strings;
public class ProviderConfigurationPermission extends BasicPermission {
    public final String a;
    public final int b;

    public ProviderConfigurationPermission(String str) {
        super(str);
        this.a = ProfileTab.ALL;
        this.b = 63;
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ProviderConfigurationPermission)) {
            return false;
        }
        ProviderConfigurationPermission providerConfigurationPermission = (ProviderConfigurationPermission) obj;
        if (this.b != providerConfigurationPermission.b || !getName().equals(providerConfigurationPermission.getName())) {
            return false;
        }
        return true;
    }

    @Override // java.security.BasicPermission, java.security.Permission
    public String getActions() {
        return this.a;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return getName().hashCode() + this.b;
    }

    @Override // java.security.BasicPermission, java.security.Permission
    public boolean implies(Permission permission) {
        if (!(permission instanceof ProviderConfigurationPermission) || !getName().equals(permission.getName())) {
            return false;
        }
        int i = this.b;
        int i2 = ((ProviderConfigurationPermission) permission).b;
        if ((i & i2) == i2) {
            return true;
        }
        return false;
    }

    public ProviderConfigurationPermission(String str, String str2) {
        super(str, str2);
        this.a = str2;
        StringTokenizer stringTokenizer = new StringTokenizer(Strings.toLowerCase(str2), " ,");
        int i = 0;
        while (stringTokenizer.hasMoreTokens()) {
            String nextToken = stringTokenizer.nextToken();
            if (nextToken.equals("threadlocalecimplicitlyca")) {
                i |= 1;
            } else if (nextToken.equals("ecimplicitlyca")) {
                i |= 2;
            } else if (nextToken.equals("threadlocaldhdefaultparams")) {
                i |= 4;
            } else if (nextToken.equals("dhdefaultparams")) {
                i |= 8;
            } else if (nextToken.equals("acceptableeccurves")) {
                i |= 16;
            } else if (nextToken.equals("additionalecparameters")) {
                i |= 32;
            } else if (nextToken.equals(ProfileTab.ALL)) {
                i |= 63;
            }
        }
        if (i != 0) {
            this.b = i;
            return;
        }
        throw new IllegalArgumentException("unknown permissions passed to mask");
    }
}
