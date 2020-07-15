package in.newdevpoint.android.viewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import in.newdevpoint.android.serviceRepository.WordRepository;
import in.newdevpoint.android.activities.RecyclerActivity;
import in.newdevpoint.android.model.Result;

import java.util.List;

/**
 * A ViewModel used for the {@link RecyclerActivity}.
 */
public class RecyclerActivityViewModel extends AndroidViewModel {


    private MutableLiveData<List<Result>> mElapsedTime;

    public RecyclerActivityViewModel(Application application) {
        super(application);
        WordRepository mRepository = new WordRepository(application);
        mElapsedTime = mRepository.getListMutableLiveData();
    }

    public LiveData<List<Result>> getElapsedTime() {
        return mElapsedTime;
    }
}
