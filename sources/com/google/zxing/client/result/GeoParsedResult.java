package com.google.zxing.client.result;

import a2.b.a.a.a;
import com.vk.sdk.api.model.VKApiPhotoSize;
public final class GeoParsedResult extends ParsedResult {
    public final double b;
    public final double c;
    public final double d;
    public final String e;

    public GeoParsedResult(double d2, double d3, double d4, String str) {
        super(ParsedResultType.GEO);
        this.b = d2;
        this.c = d3;
        this.d = d4;
        this.e = str;
    }

    public double getAltitude() {
        return this.d;
    }

    @Override // com.google.zxing.client.result.ParsedResult
    public String getDisplayResult() {
        StringBuilder sb = new StringBuilder(20);
        sb.append(this.b);
        sb.append(", ");
        sb.append(this.c);
        if (this.d > 0.0d) {
            sb.append(", ");
            sb.append(this.d);
            sb.append(VKApiPhotoSize.M);
        }
        if (this.e != null) {
            sb.append(" (");
            sb.append(this.e);
            sb.append(')');
        }
        return sb.toString();
    }

    public String getGeoURI() {
        StringBuilder L = a.L("geo:");
        L.append(this.b);
        L.append(',');
        L.append(this.c);
        if (this.d > 0.0d) {
            L.append(',');
            L.append(this.d);
        }
        if (this.e != null) {
            L.append('?');
            L.append(this.e);
        }
        return L.toString();
    }

    public double getLatitude() {
        return this.b;
    }

    public double getLongitude() {
        return this.c;
    }

    public String getQuery() {
        return this.e;
    }
}
