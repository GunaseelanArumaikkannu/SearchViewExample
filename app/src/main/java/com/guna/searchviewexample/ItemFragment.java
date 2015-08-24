package com.guna.searchviewexample;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.TextView;

import com.guna.searchviewexample.dummy.DummyContent;


public class ItemFragment extends Fragment implements AbsListView.OnItemClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    /**
     * The fragment's ListView/GridView.
     */
    private AbsListView mListView;

    /**
     * The Adapter which will be used to populate the ListView/GridView with
     * Views.
     */
//    private MyListAdapter mAdapter;
    private BaseListAdapter mAdapter;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ItemFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mAdapter = new BaseListAdapter(getActivity(), DummyContent.ITEMS);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item, container, false);

        // Set the adapter
        mListView = (AbsListView) view.findViewById(android.R.id.list);
        mListView.setAdapter(mAdapter);

        DummyContent.ITEMS.clear();
        DummyContent.addItem(new DummyContent.DummyItem("One", "1"));
        DummyContent.addItem(new DummyContent.DummyItem("Two", "2"));
        DummyContent.addItem(new DummyContent.DummyItem("Three", "3"));
        DummyContent.addItem(new DummyContent.DummyItem("Four", "4"));
        DummyContent.addItem(new DummyContent.DummyItem("Five", "5"));
        DummyContent.addItem(new DummyContent.DummyItem("Six", "6"));
        DummyContent.addItem(new DummyContent.DummyItem("Seven", "7"));
        DummyContent.addItem(new DummyContent.DummyItem("Eight", "8"));
        DummyContent.addItem(new DummyContent.DummyItem("Nine", "9"));
        DummyContent.addItem(new DummyContent.DummyItem("Ten", "10"));

        // Set OnItemClickListener so we can be notified on item clicks
        mListView.setOnItemClickListener(this);

        return view;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        DummyContent.DummyItem p = (DummyContent.DummyItem) mAdapter.getItem(position);

    }

    /**
     * The default title for this Fragment has a TextView that is shown when
     * the list is empty. If you would like to change the text, call this method
     * to supply the text it should use.
     */
    public void setEmptyText(CharSequence emptyText) {
        View emptyView = mListView.getEmptyView();

        if (emptyView instanceof TextView) {
            ((TextView) emptyView).setText(emptyText);
        }
    }

    public void filter(String query) {
        Log.v("App", "Query in filter - " + query);
        mAdapter.getFilter().filter(query);
    }
}