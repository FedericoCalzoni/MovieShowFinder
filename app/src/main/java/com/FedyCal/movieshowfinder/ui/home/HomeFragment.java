package com.FedyCal.movieshowfinder.ui.home;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.FedyCal.APIMetods.ListsApiResponse;
import com.FedyCal.APIMetods.RequestManagerHome;
import com.FedyCal.Adapters.HomeRecyclerAdapter;
import com.FedyCal.ItemInformationActivity;
import com.FedyCal.Listeners.OnHomeListener1;
import com.FedyCal.Listeners.OnHomeListener2;
import com.FedyCal.Listeners.OnMovieClickListener;
import com.FedyCal.movieshowfinder.R;

public class HomeFragment extends Fragment implements OnMovieClickListener {

    private RecyclerView recycler_view1_home;
    private RecyclerView recycler_view2_home;
    HomeRecyclerAdapter adapter1;
    HomeRecyclerAdapter adapter2;
    RequestManagerHome manager1;
    RequestManagerHome manager2;
    ProgressDialog dialog;

    private final OnHomeListener1 listener1 = new OnHomeListener1() {
        @Override
        public void onResponse(ListsApiResponse response) {
                dialog.dismiss();
                if (response == null) {
                    Log.d("DEBUG", "response == null");
                    Toast.makeText(getContext(), "error: response==null", Toast.LENGTH_LONG).show();
                    return;
                }
                Log.d("DEBUG", "response fetched correctly", null);
                showResult1(response);
        }

        @Override
        public void onError(String message) {
            dialog.dismiss();
            Toast.makeText(getContext(), "Error: OnSearchListener", Toast.LENGTH_LONG).show();
        }
    };

    private final OnHomeListener2 listener2 = new OnHomeListener2() {
        @Override
        public void onResponse(ListsApiResponse response) {
            dialog.dismiss();
            if (response == null) {
                Log.d("DEBUG", "response == null");
                Toast.makeText(getContext(), "error: response==null", Toast.LENGTH_LONG).show();
                return;
            }
            Log.d("DEBUG", "response fetched correctly", null);
            showResult2(response);
        }

        @Override
        public void onError(String message) {
            dialog.dismiss();
            Toast.makeText(getContext(), "Error: OnSearchListener", Toast.LENGTH_LONG).show();
        }
    };





    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);



        recycler_view1_home = view.findViewById(R.id.recycler_view1_home);
        recycler_view1_home.setAdapter(adapter1);
        recycler_view2_home = view.findViewById(R.id.recycler_view2_home);
        recycler_view2_home.setAdapter(adapter2);
        manager1 = new RequestManagerHome(this);
        manager2 = new RequestManagerHome(this);
        dialog = new ProgressDialog(getActivity());
        dialog.setTitle("Loading");
        dialog.setCancelable(false); // disable dismiss by tapping outside of the dialog
        dialog.show();

        manager1.getResultApi(listener1);
        manager1.getResultApi(listener2);


        return view;

    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("DEBUG", "onResume of LoginFragment");

        manager1.getResultApi(listener1);
        manager2.getResultApi(listener2);
    }

@Override
    public void onDestroyView() {
        super.onDestroyView();
        //binding = null;
    }

    public void onMovieClicked(String id, String title, String name, String poster_path, String type) {
        startActivity(new Intent(getActivity(), ItemInformationActivity.class)
                .putExtra("id", id)
                .putExtra("title", title)
                .putExtra("name", name)
                .putExtra("poster_path", poster_path)
                .putExtra("type", type));
    }
    private void showResult1(@NonNull ListsApiResponse response) {
        adapter1 = new HomeRecyclerAdapter(getContext(), response.getResults(), this);
        recycler_view1_home.setAdapter(adapter1);
        recycler_view1_home.setHasFixedSize(true);
    }
    private void showResult2(@NonNull ListsApiResponse response) {
        adapter2 = new HomeRecyclerAdapter(getContext(), response.getResults(), this);
        recycler_view2_home.setAdapter(adapter2);
        recycler_view2_home.setHasFixedSize(true);
    }
}