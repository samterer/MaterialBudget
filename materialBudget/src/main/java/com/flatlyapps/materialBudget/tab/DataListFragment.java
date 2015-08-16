package com.flatlyapps.materialBudget.tab;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.flatlyapps.materialBudget.R;
import com.flatlyapps.materialBudget.list.DataListAdapter;


public class DataListFragment extends Fragment {

	private static final String ARG_POSITION = "position";

	public static DataListFragment newInstance() {
		return new DataListFragment();
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.tab_fragment,container,false);
		RecyclerView listRecyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view);

		RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
		listRecyclerView.setLayoutManager(layoutManager);
		listRecyclerView.setHasFixedSize(true);
		listRecyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL));

		DataListAdapter listAdapter = new DataListAdapter(getActivity());
		listRecyclerView.setAdapter(listAdapter);
		return rootView;
	}

	public static String getTitle() {
		return "Transactions";
	}
}