package ir.ninjacoder.code.widget.ad;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import ir.ninjacoder.code.R;
import java.util.ArrayList;

public class SuggestionAdapter extends ArrayAdapter {

  ArrayList<String> listString;

  public SuggestionAdapter(Context context, ArrayList<String> list) {
    super(context, R.layout.suggestions_adapter_row_view, list);
    listString = list;
  }

  @Override
  public int getCount() {
    return listString.size();
  }

  @Override
  public Object getItem(int i) {
    return listString.get(i);
  }

  @Override
  public long getItemId(int i) {
    return i;
  }

  @Override
  public View getView(int i, View view, ViewGroup viewGroup) {
    LayoutInflater layoutInflater =
        (LayoutInflater) viewGroup.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    View customView = layoutInflater.inflate(R.layout.suggestions_adapter_row_view, null, true);
    TextView nameView = customView.findViewById(R.id.tv);
    nameView.setText(listString.get(i));
    return customView;
  } 
}
