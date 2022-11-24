package be.ehb.nootjesdb.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import be.ehb.nootjesdb.R;
import be.ehb.nootjesdb.model.Nut;
import be.ehb.nootjesdb.view.adapter.NutAdapter;
import be.ehb.nootjesdb.viewmodel.NutViewModel;

public class HomeFragment extends Fragment {

    private NutViewModel nutViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        RecyclerView nutRecyclerView = rootView.findViewById(R.id.home_rv);
        EditText nameEditText = rootView.findViewById(R.id.home_et_name);
        Button saveButton = rootView.findViewById(R.id.home_btn_save);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false);
        nutRecyclerView.setLayoutManager(layoutManager);

        NutAdapter adapter = new NutAdapter();
        nutRecyclerView.setAdapter(adapter);

        // doet nog niets
        nutViewModel = new ViewModelProvider(getActivity()).get(NutViewModel.class);
        nutViewModel.getNuts().observe(getViewLifecycleOwner(), new Observer<List<Nut>>() {
            @Override
            public void onChanged(List<Nut> nuts) {
                adapter.addNuts(nuts);
            }
        });

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String input = nameEditText.getText().toString();
                Nut newNut = new Nut();
                newNut.setName(input);
                nutViewModel.insertNut(newNut);
            }
        });

        return rootView;
    }
}
