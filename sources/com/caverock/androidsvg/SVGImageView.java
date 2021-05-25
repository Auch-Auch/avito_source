package com.caverock.androidsvg;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.Picture;
import android.graphics.drawable.PictureDrawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
public class SVGImageView extends ImageView {
    public static Method c;
    public SVG a = null;
    public RenderOptions b = new RenderOptions();

    public class b extends AsyncTask<Integer, Integer, SVG> {
        public Context a;
        public int b;

        public b(Context context, int i) {
            this.a = context;
            this.b = i;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
        @Override // android.os.AsyncTask
        public SVG doInBackground(Integer[] numArr) {
            try {
                return SVG.getFromResource(this.a, this.b);
            } catch (SVGParseException e) {
                String.format("Error loading resource 0x%x: %s", Integer.valueOf(this.b), e.getMessage());
                return null;
            }
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.os.AsyncTask
        public void onPostExecute(SVG svg) {
            SVGImageView sVGImageView = SVGImageView.this;
            sVGImageView.a = svg;
            sVGImageView.a();
        }
    }

    public class c extends AsyncTask<InputStream, Integer, SVG> {
        public c(a aVar) {
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
        @Override // android.os.AsyncTask
        public SVG doInBackground(InputStream[] inputStreamArr) {
            InputStream[] inputStreamArr2 = inputStreamArr;
            try {
                SVG fromInputStream = SVG.getFromInputStream(inputStreamArr2[0]);
                try {
                    inputStreamArr2[0].close();
                    return fromInputStream;
                } catch (IOException unused) {
                    return fromInputStream;
                }
            } catch (SVGParseException e) {
                e.getMessage();
                try {
                    inputStreamArr2[0].close();
                } catch (IOException unused2) {
                }
                return null;
            } catch (Throwable th) {
                try {
                    inputStreamArr2[0].close();
                } catch (IOException unused3) {
                }
                throw th;
            }
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.os.AsyncTask
        public void onPostExecute(SVG svg) {
            SVGImageView sVGImageView = SVGImageView.this;
            sVGImageView.a = svg;
            sVGImageView.a();
        }
    }

    static {
        try {
            c = View.class.getMethod("setLayerType", Integer.TYPE, Paint.class);
        } catch (NoSuchMethodException unused) {
        }
    }

    public SVGImageView(Context context) {
        super(context);
    }

    private void setFromString(String str) {
        try {
            this.a = SVG.getFromString(str);
            a();
        } catch (SVGParseException unused) {
        }
    }

    public final void a() {
        SVG svg = this.a;
        if (svg != null) {
            Picture renderToPicture = svg.renderToPicture(this.b);
            if (c != null) {
                try {
                    c.invoke(this, Integer.valueOf(View.class.getField("LAYER_TYPE_SOFTWARE").getInt(new View(getContext()))), null);
                } catch (Exception unused) {
                }
            }
            setImageDrawable(new PictureDrawable(renderToPicture));
        }
    }

    public final void b(AttributeSet attributeSet, int i) {
        if (!isInEditMode()) {
            TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(attributeSet, R.styleable.SVGImageView, i, 0);
            try {
                String string = obtainStyledAttributes.getString(R.styleable.SVGImageView_css);
                if (string != null) {
                    this.b.css(string);
                }
                int i2 = R.styleable.SVGImageView_svg;
                int resourceId = obtainStyledAttributes.getResourceId(i2, -1);
                if (resourceId != -1) {
                    setImageResource(resourceId);
                    return;
                }
                String string2 = obtainStyledAttributes.getString(i2);
                if (string2 != null) {
                    if (d(Uri.parse(string2))) {
                        obtainStyledAttributes.recycle();
                        return;
                    } else if (c(string2)) {
                        obtainStyledAttributes.recycle();
                        return;
                    } else {
                        setFromString(string2);
                    }
                }
                obtainStyledAttributes.recycle();
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
    }

    public final boolean c(String str) {
        try {
            new c(null).execute(getContext().getAssets().open(str));
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    public final boolean d(Uri uri) {
        try {
            new c(null).execute(getContext().getContentResolver().openInputStream(uri));
            return true;
        } catch (FileNotFoundException unused) {
            return false;
        }
    }

    public void setCSS(String str) {
        this.b.css(str);
        a();
    }

    public void setImageAsset(String str) {
        c(str);
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        new b(getContext(), i).execute(new Integer[0]);
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        if (!d(uri)) {
            String str = "File not found: " + uri;
        }
    }

    public void setSVG(SVG svg) {
        if (svg != null) {
            this.a = svg;
            a();
            return;
        }
        throw new IllegalArgumentException("Null value passed to setSVG()");
    }

    public SVGImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        b(attributeSet, 0);
    }

    public void setSVG(SVG svg, String str) {
        if (svg != null) {
            this.a = svg;
            this.b.css(str);
            a();
            return;
        }
        throw new IllegalArgumentException("Null value passed to setSVG()");
    }

    public SVGImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        b(attributeSet, i);
    }
}
