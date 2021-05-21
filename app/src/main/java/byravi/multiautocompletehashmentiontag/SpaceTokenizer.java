package byravi.multiautocompletehashmentiontag;

import android.graphics.Color;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.widget.MultiAutoCompleteTextView;

public class SpaceTokenizer implements MultiAutoCompleteTextView.Tokenizer {

    public int findTokenStart(CharSequence text, int cursor) {
        int i = cursor;

        while (i > 0 && text.charAt(i - 1) != ' ') {
            i--;
        }
        while (i < cursor && text.charAt(i) == ' ') {
            i++;
        }

        return i;
    }

    public int findTokenEnd(CharSequence text, int cursor) {
        int i = cursor;
        int len = text.length();

        while (i < len) {
            if (text.charAt(i) == ' ') {
                return i;
            } else {
                i++;
            }
        }

        return len;
    }


    public CharSequence terminateToken(CharSequence text) {

        int i = text.length();

        while (i > 0 && text.charAt(i - 1) == ' ') {
            i--;
        }

        if (i > 0 && text.charAt(i - 1) == ' ') {
            if(text.toString().contains("#")){
                SpannableString sp = new SpannableString(text + " ");
                sp.setSpan(new ForegroundColorSpan(Color.BLUE), 0, text.length() + 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                return sp;
            }
            return text;
        } else {
            // Returns colored text for selected token
            SpannableString sp = new SpannableString(text + "  ");
            sp.setSpan(new ForegroundColorSpan(Color.BLUE), 0, text.length() + 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            return sp;
        }
    }
}
