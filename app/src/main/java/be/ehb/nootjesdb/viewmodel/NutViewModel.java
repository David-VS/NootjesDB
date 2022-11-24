package be.ehb.nootjesdb.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import be.ehb.nootjesdb.model.Nut;
import be.ehb.nootjesdb.model.NutDB;

public class NutViewModel extends AndroidViewModel {

    private NutDB mNutDB;
    private LiveData<List<Nut>> nuts;

    public NutViewModel(@NonNull Application applicationContext) {
        super(applicationContext);
        mNutDB = NutDB.getInstance(applicationContext);
        nuts = mNutDB.getNutDAO().getAllNuts();
    }

    public LiveData<List<Nut>> getNuts() {
        return nuts;
    }

    public void insertNut(Nut nut){
        NutDB.DB_EXECUTOR_SERVICE.execute(new Runnable() {
            @Override
            public void run() {
                mNutDB.getNutDAO().insertNut(nut);
            }
        });
    }


}
