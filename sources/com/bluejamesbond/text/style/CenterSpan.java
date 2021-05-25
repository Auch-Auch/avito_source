package com.bluejamesbond.text.style;
public class CenterSpan extends TextAlignmentSpan {
    @Override // com.bluejamesbond.text.style.TextAlignmentSpan
    public TextAlignment getTextAlignment() {
        return TextAlignment.CENTER;
    }
}
