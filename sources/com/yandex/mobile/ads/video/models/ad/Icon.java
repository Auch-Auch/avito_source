package com.yandex.mobile.ads.video.models.ad;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.yandex.mobile.ads.impl.tm;
import java.util.Arrays;
public class Icon implements Parcelable {
    public static final Parcelable.Creator<Icon> CREATOR = new Parcelable.Creator<Icon>() { // from class: com.yandex.mobile.ads.video.models.ad.Icon.1
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ Icon createFromParcel(Parcel parcel) {
            return new Icon(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ Icon[] newArray(int i) {
            return new Icon[i];
        }
    };
    private String mApiFramework;
    private Long mDuration;
    private Integer mHeight;
    private IconHorizontalPosition mHorizontalPosition;
    private Long mOffset;
    private String mProgram;
    private IconResourceType mResourceType;
    private String mResourceUrl;
    private IconVerticalPosition mVerticalPosition;
    private Integer mWidth;
    private Integer mX;
    private Integer mY;

    public enum IconHorizontalPosition {
        ICON_HORIZONTAL_POSITION_LEFT(ViewHierarchyConstants.DIMENSION_LEFT_KEY),
        ICON_HORIZONTAL_POSITION_RIGHT("right"),
        ICON_HORIZONTAL_POSITION_LEFT_OFFSET("leftOffset");
        
        public final String horizontalPosition;

        private IconHorizontalPosition(String str) {
            this.horizontalPosition = str;
        }

        /* access modifiers changed from: private */
        public static IconHorizontalPosition getPosition(String str) {
            if (ViewHierarchyConstants.DIMENSION_LEFT_KEY.equals(str)) {
                return ICON_HORIZONTAL_POSITION_LEFT;
            }
            if ("right".equals(str)) {
                return ICON_HORIZONTAL_POSITION_RIGHT;
            }
            return ICON_HORIZONTAL_POSITION_LEFT_OFFSET;
        }
    }

    public enum IconResourceType {
        STATIC_RESOURCE("StaticResource"),
        IFRAME_RESOURCE("IFrameResource"),
        HTML_RESOURCE("HTMLResource");
        
        public final String resourceType;

        private IconResourceType(String str) {
            this.resourceType = str;
        }

        public static boolean contains(String str) {
            for (IconResourceType iconResourceType : Arrays.asList(values())) {
                if (iconResourceType.resourceType.equals(str)) {
                    return true;
                }
            }
            return false;
        }

        /* access modifiers changed from: private */
        public static IconResourceType getConvertType(String str) {
            for (IconResourceType iconResourceType : Arrays.asList(values())) {
                if (iconResourceType.resourceType.equals(str)) {
                    return iconResourceType;
                }
            }
            return null;
        }
    }

    public enum IconVerticalPosition {
        ICON_VERTICAL_POSITION_TOP("top"),
        ICON_VERTICAL_POSITION_BOTTOM("bottom"),
        ICON_VERTICAL_POSITION_TOP_OFFSET("topOffset");
        
        public final String verticalPosition;

        private IconVerticalPosition(String str) {
            this.verticalPosition = str;
        }

        /* access modifiers changed from: private */
        public static IconVerticalPosition getPosition(String str) {
            if ("top".equals(str)) {
                return ICON_VERTICAL_POSITION_TOP;
            }
            if ("bottom".equals(str)) {
                return ICON_VERTICAL_POSITION_BOTTOM;
            }
            return ICON_VERTICAL_POSITION_TOP_OFFSET;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getApiFramework() {
        return this.mApiFramework;
    }

    public Long getDuration() {
        return this.mDuration;
    }

    public Integer getHeight() {
        return this.mHeight;
    }

    public IconHorizontalPosition getHorizontalPosition() {
        return this.mHorizontalPosition;
    }

    public Long getOffset() {
        return this.mOffset;
    }

    public String getProgram() {
        return this.mProgram;
    }

    public IconResourceType getResourceType() {
        return this.mResourceType;
    }

    public String getResourceUrl() {
        return this.mResourceUrl;
    }

    public IconVerticalPosition getVerticalPosition() {
        return this.mVerticalPosition;
    }

    public Integer getWidth() {
        return this.mWidth;
    }

    public Integer getXPosition() {
        return this.mX;
    }

    public Integer getYPosition() {
        return this.mY;
    }

    public void setApiFramework(String str) {
        this.mApiFramework = str;
    }

    public void setDuration(String str) {
        this.mDuration = tm.a(str);
    }

    public void setHeight(String str) {
        this.mHeight = tm.b(str);
    }

    public void setHorizontalPosition(String str) {
        IconHorizontalPosition position = IconHorizontalPosition.getPosition(str);
        this.mHorizontalPosition = position;
        if (position == IconHorizontalPosition.ICON_HORIZONTAL_POSITION_LEFT_OFFSET) {
            this.mX = tm.b(str);
        }
    }

    public void setOffset(String str) {
        this.mOffset = tm.a(str);
    }

    public void setProgram(String str) {
        this.mProgram = str;
    }

    public void setResourceType(String str) {
        this.mResourceType = IconResourceType.getConvertType(str);
    }

    public void setResourceUrl(String str) {
        this.mResourceUrl = str;
    }

    public void setVerticalPosition(String str) {
        IconVerticalPosition position = IconVerticalPosition.getPosition(str);
        this.mVerticalPosition = position;
        if (position == IconVerticalPosition.ICON_VERTICAL_POSITION_TOP_OFFSET) {
            this.mY = tm.b(str);
        }
    }

    public void setWidth(String str) {
        this.mWidth = tm.b(str);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mResourceUrl);
        IconResourceType iconResourceType = this.mResourceType;
        int i2 = -1;
        parcel.writeInt(iconResourceType == null ? -1 : iconResourceType.ordinal());
        parcel.writeString(this.mProgram);
        parcel.writeValue(this.mWidth);
        parcel.writeValue(this.mHeight);
        IconHorizontalPosition iconHorizontalPosition = this.mHorizontalPosition;
        parcel.writeInt(iconHorizontalPosition == null ? -1 : iconHorizontalPosition.ordinal());
        IconVerticalPosition iconVerticalPosition = this.mVerticalPosition;
        if (iconVerticalPosition != null) {
            i2 = iconVerticalPosition.ordinal();
        }
        parcel.writeInt(i2);
        parcel.writeString(this.mApiFramework);
        parcel.writeValue(this.mOffset);
        parcel.writeValue(this.mDuration);
        parcel.writeValue(this.mX);
        parcel.writeValue(this.mY);
    }

    public Icon() {
    }

    private Icon(Parcel parcel) {
        IconResourceType iconResourceType;
        IconHorizontalPosition iconHorizontalPosition;
        this.mResourceUrl = parcel.readString();
        int readInt = parcel.readInt();
        IconVerticalPosition iconVerticalPosition = null;
        if (readInt == -1) {
            iconResourceType = null;
        } else {
            iconResourceType = IconResourceType.values()[readInt];
        }
        this.mResourceType = iconResourceType;
        this.mProgram = parcel.readString();
        this.mWidth = (Integer) parcel.readValue(Integer.class.getClassLoader());
        this.mHeight = (Integer) parcel.readValue(Integer.class.getClassLoader());
        int readInt2 = parcel.readInt();
        if (readInt2 == -1) {
            iconHorizontalPosition = null;
        } else {
            iconHorizontalPosition = IconHorizontalPosition.values()[readInt2];
        }
        this.mHorizontalPosition = iconHorizontalPosition;
        int readInt3 = parcel.readInt();
        this.mVerticalPosition = readInt3 != -1 ? IconVerticalPosition.values()[readInt3] : iconVerticalPosition;
        this.mApiFramework = parcel.readString();
        this.mOffset = (Long) parcel.readValue(Long.class.getClassLoader());
        this.mDuration = (Long) parcel.readValue(Long.class.getClassLoader());
        this.mX = (Integer) parcel.readValue(Integer.class.getClassLoader());
        this.mY = (Integer) parcel.readValue(Integer.class.getClassLoader());
    }
}
