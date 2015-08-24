package com.guna.searchviewexample;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import com.guna.searchviewexample.dummy.DummyContent;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gunaseelan on 13-08-2015. new Base list adapter
 */
public class BaseListAdapter extends BaseAdapter implements Filterable {

    private List<DummyContent.DummyItem> originalItems;
    private List<DummyContent.DummyItem> filteredItems;
    private LayoutInflater inflater;
    private ItemFilter mFilter = new ItemFilter();

    public BaseListAdapter(Context context, List<DummyContent.DummyItem> items){
        this.originalItems = items;
        this.filteredItems = items;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return filteredItems.size();
    }

    @Override
    public Object getItem(int position) {
        return filteredItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.items, null);
            holder = new ViewHolder();
            holder.tt2 = (TextView) convertView.findViewById(R.id.title);
            holder.tt3 = (TextView) convertView.findViewById(R.id.desc);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        // If weren't re-ordering this you could rely on what you set last time
        holder.tt2.setText(filteredItems.get(position).title);
        holder.tt3.setText(filteredItems.get(position).description);

        return convertView;
    }

    @Override
    public Filter getFilter() {
        return mFilter;
    }

    static class ViewHolder{
        TextView tt2;
        TextView tt3;
    }

    private class ItemFilter extends Filter {

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults results = new FilterResults();
            Log.v("App", "constraint - " + constraint.toString());
            if (constraint.length() == 0) {
                results.values = originalItems;
                results.count = originalItems.size();
            } else {
                List<DummyContent.DummyItem> tempItems = new ArrayList<>();
                for (DummyContent.DummyItem item : originalItems) {
                    if (item.title.contains(constraint) || item.description.contains(constraint)) {
                        tempItems.add(item);
                    }
                }
                results.values = tempItems;
                results.count = tempItems.size();
            }
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            Log.v("App", results.count + " in publishResults");
            /*if (results.count == 0)
                notifyDataSetInvalidated();
            else {*/
            filteredItems = (List<DummyContent.DummyItem>) results.values;
            notifyDataSetChanged();
//            }
        }
    }
}