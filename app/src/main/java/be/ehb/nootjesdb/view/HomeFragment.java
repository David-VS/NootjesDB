package be.ehb.nootjesdb.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import be.ehb.nootjesdb.R;
import be.ehb.nootjesdb.viewmodel.NutViewModel;

public class HomeFragment extends Fragment {

    private NutViewModel nutViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        // doet nog niets
        nutViewModel = new ViewModelProvider(getActivity()).get(NutViewModel.class);

        return rootView;
    }
}
