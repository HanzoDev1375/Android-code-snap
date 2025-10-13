package ir.ninjacoder.code.widget;

import android.content.Context;
import android.text.Editable;
import android.text.Spannable;
import android.text.TextWatcher;
import android.text.style.BackgroundColorSpan;
import android.text.style.StyleSpan;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.EditText;
import android.text.Layout;
import android.graphics.Rect;
import ir.ninjacoder.code.widget.ad.SuggestionAdapter;
import java.util.HashSet;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import android.widget.MultiAutoCompleteTextView;
import androidx.appcompat.widget.AppCompatMultiAutoCompleteTextView;

import ir.ninjacoder.code.colorhelper.ColorHelper;
import java.util.ArrayList;
import ir.ninjacoder.code.widget.ad.KeywordTokenizer;
import android.content.res.Resources;

public class CodeEditText extends AppCompatMultiAutoCompleteTextView {

  private ColorHelper color = new ColorHelper();
  private BackgroundColorSpan currentSpan1, currentSpan2;
  private int lastCursorPos = -1;
  private StyleSpan boldSpan1, boldSpan2;
  private MultiAutoCompleteTextView.Tokenizer mAutoCompleteTokenizer;
  private ArrayList<String> suggestionsList;
  private ArrayList<String> suggestionsList1;

  private boolean showInlays = true;

  public CodeEditText(Context context) {
    super(context);
    init();
  }

  public CodeEditText(Context context, AttributeSet attrs) {
    super(context, attrs);
    init();
  }

  public CodeEditText(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    init();
  }

  private void init() {
    setHorizontallyScrolling(true);
    if (mAutoCompleteTokenizer == null) mAutoCompleteTokenizer = new KeywordTokenizer();
    setTokenizer(mAutoCompleteTokenizer);
    setDropDownWidth(Resources.getSystem().getDisplayMetrics().widthPixels / 2);
    setCursorVisible(true);
    addTextChangedListener(
        new TextWatcher() {
          @Override
          public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

          @Override
          public void onTextChanged(CharSequence s, int start, int before, int count) {}

          @Override
          public void afterTextChanged(Editable s) {
            int cursorPos = getSelectionStart();
            if (cursorPos != lastCursorPos) {
              highlightByCursor(cursorPos);
              lastCursorPos = cursorPos;
            }
            // اضافه کردها

          }
        });
  }

  @Override
  public boolean onTouchEvent(MotionEvent event) {
    boolean handled = super.onTouchEvent(event);
    if (event.getAction() == MotionEvent.ACTION_UP) {
      int offset = getOffsetForPosition(event.getX(), event.getY());
      highlightByCursor(offset);
    }
    return handled;
  }

  private void highlightByCursor(int cursorPos) {
    Editable text = getText();
    if (text == null || text.length() == 0) return;

    removeOldHighlights(text);

    int length = text.length();
    char before = (cursorPos > 0) ? text.charAt(cursorPos - 1) : 0;
    char at = (cursorPos < length) ? text.charAt(cursorPos) : 0;
    if (isBracket(before)) {
      highlightBracketPair(cursorPos - 1);
    } else if (isBracket(at)) {
      highlightBracketPair(cursorPos);
    }
  }

  private void highlightBracketPair(int pos) {
    Editable text = getText();
    if (text == null || pos < 0 || pos >= text.length()) return;

    removeOldHighlights(text);
    char c = text.charAt(pos);

    if (isOpenBracket(c)) {
      int match = findMatchingForward(text.toString(), pos, c);
      if (match != -1) applyHighlight(text, pos, match);
    } else if (isCloseBracket(c)) {
      int match = findMatchingBackward(text.toString(), pos, c);
      if (match != -1) applyHighlight(text, pos, match);
    }
  }

  private void applyHighlight(Editable text, int pos1, int pos2) {

    currentSpan1 = new BackgroundColorSpan(color.getBracketcolor());
    currentSpan2 = new BackgroundColorSpan(color.getBracketcolor());
    boldSpan1 = new StyleSpan(Typeface.BOLD);
    boldSpan2 = new StyleSpan(Typeface.BOLD);

    text.setSpan(currentSpan1, pos1, pos1 + 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    text.setSpan(currentSpan2, pos2, pos2 + 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

    text.setSpan(boldSpan1, pos1, pos1 + 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    text.setSpan(boldSpan2, pos2, pos2 + 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
  }

  private void removeOldHighlights(Editable text) {
    if (currentSpan1 != null) text.removeSpan(currentSpan1);
    if (currentSpan2 != null) text.removeSpan(currentSpan2);
    if (boldSpan1 != null) text.removeSpan(boldSpan1);
    if (boldSpan2 != null) text.removeSpan(boldSpan2);

    currentSpan1 = null;
    currentSpan2 = null;
    boldSpan1 = null;
    boldSpan2 = null;
  }

  private boolean isBracket(char c) {
    return isOpenBracket(c) || isCloseBracket(c);
  }

  private boolean isOpenBracket(char c) {
    return c == '(' || c == '{' || c == '[';
  }

  private boolean isCloseBracket(char c) {
    return c == ')' || c == '}' || c == ']';
  }

  private boolean isMatching(char open, char close) {
    return (open == '(' && close == ')')
        || (open == '{' && close == '}')
        || (open == '[' && close == ']');
  }

  private int findMatchingForward(String text, int start, char open) {
    char close = getMatchingClose(open);
    int depth = 0;

    for (int i = start + 1; i < text.length(); i++) {
      char c = text.charAt(i);
      if (c == open) depth++;
      else if (c == close) {
        if (depth == 0) return i;
        depth--;
      }
    }
    return -1;
  }

  private int findMatchingBackward(String text, int start, char close) {
    char open = getMatchingOpen(close);
    int depth = 0;

    for (int i = start - 1; i >= 0; i--) {
      char c = text.charAt(i);
      if (c == close) depth++;
      else if (c == open) {
        if (depth == 0) return i;
        depth--;
      }
    }
    return -1;
  }

  private char getMatchingClose(char open) {
    switch (open) {
      case '(':
        return ')';
      case '{':
        return '}';
      case '[':
        return ']';
    }
    return 0;
  }

  private char getMatchingOpen(char close) {
    switch (close) {
      case ')':
        return '(';
      case '}':
        return '{';
      case ']':
        return '[';
    }
    return 0;
  }

  @Override
  public void showDropDown() {
    final Layout layout = getLayout();
    final int position = getSelectionStart();
    final int line = layout.getLineForOffset(position);
    final int lineBottom = layout.getLineBottom(line);

    int numberOfMatchedItems = getAdapter().getCount();

    int maxNumberOfSuggestions = 8;
    int autoCompleteItemHeightInDp = (int) (50 * Resources.getSystem().getDisplayMetrics().density);

    if (numberOfMatchedItems > maxNumberOfSuggestions) {
      numberOfMatchedItems = maxNumberOfSuggestions;
    }

    int dropDownHeight = getDropDownHeight();

    int modifiedDropDownHeight =
        android.widget.LinearLayout.LayoutParams
            .WRAP_CONTENT /*numberOfMatchedItems * autoCompleteItemHeightInDp*/;

    if (dropDownHeight != modifiedDropDownHeight) {
      dropDownHeight = modifiedDropDownHeight;
    }

    final Rect displayFrame = new Rect();
    getGlobalVisibleRect(displayFrame);

    int displayFrameHeight = displayFrame.height();

    int verticalOffset = lineBottom + dropDownHeight;
    if (verticalOffset > displayFrameHeight) {
      verticalOffset = displayFrameHeight - autoCompleteItemHeightInDp;
    }

    setDropDownHeight(dropDownHeight);
    setDropDownVerticalOffset(verticalOffset - displayFrameHeight - dropDownHeight);
    setDropDownHorizontalOffset((int) layout.getPrimaryHorizontal(position));

    super.showDropDown();
  }

  public void setUpListSuggestions(ArrayList<String> listStr) {
    suggestionsList = new ArrayList<>();
    String myWord = currentWord(this);
    for (String word : listStr) {
      if (word.contains(myWord)) {
        suggestionsList.add(word);
      }
    }
    SuggestionAdapter adapter = new SuggestionAdapter(getContext(), suggestionsList);
    setAdapter(adapter);
  }

  public void setList(ArrayList<String> listStr) {
    this.suggestionsList1 = listStr;
    addTextChangedListener(
        new TextWatcher() {
          @Override
          public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

          @Override
          public void onTextChanged(CharSequence s, int start, int before, int count) {
            setUpListSuggestions(suggestionsList1);
          }

          @Override
          public void afterTextChanged(Editable s) {}
        });
  }

  public void setListFromContent() {
    addTextChangedListener(
        new TextWatcher() {
          @Override
          public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

          @Override
          public void onTextChanged(CharSequence s, int start, int before, int count) {
            suggestionsList1 = new ArrayList<>();
            Matcher m = Pattern.compile("\\w+").matcher(getText().toString());
            while (m.find()) {
              suggestionsList1.add(m.group());
            }
            setUpListSuggestions(cleanlist(suggestionsList1));
          }

          @Override
          public void afterTextChanged(Editable s) {}
        });
  }

  private ArrayList<String> cleanlist(ArrayList<String> listStr) {
    ArrayList<String> myList = new ArrayList<>();
    if (listStr != null && listStr.size() > 0) {
      listStr.remove(suggestionsList1.size() - 1);
    }
    HashSet<String> list = new HashSet<>(listStr);
    for (String one : list) {
      myList.add(one);
    }
    return myList;
  }

  public String currentWord(EditText editText) {
    Spannable textSpan = editText.getText();
    final int selection = editText.getSelectionStart();
    final Pattern pattern = Pattern.compile("\\w+");
    final Matcher matcher = pattern.matcher(textSpan);
    int start = 0;
    int end = 0;

    String currentWord = "";
    while (matcher.find()) {
      start = matcher.start();
      end = matcher.end();
      if (start <= selection && selection <= end) {
        currentWord = textSpan.subSequence(start, end).toString();
        break;
      }
    }

    return currentWord;
  }
}
