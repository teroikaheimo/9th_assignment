package com.example.a9th_assingment.room;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import java.util.List;

public class ModelUser extends AndroidViewModel {
    private RepositoryUser mRepository;

    public ModelUser(@NonNull Application application) {
        super(application);
        this.mRepository = new RepositoryUser(application);
    }

    public void insert(EntityUser user) {
        mRepository.insert(user);
    }


    @SuppressLint("StaticFieldLeak")
    public void confirmLogin(final String username, final String password, final Intent intent, final Activity activity, final Toast fail) {
        new AsyncTask<Void, Void, List<EntityUser>>() {
            @Override
            protected List<EntityUser> doInBackground(Void... params) {
                //runs on background thread
                return mRepository.getUser(username, password);
                //return  mRepository.getAllUsers();
            }

            @Override
            protected void onPostExecute(List<EntityUser> items) {
                //runs on main thread
                if (items.isEmpty()) {
                    fail.show();
                } else {
                    activity.startActivity(intent);
                }
            }
        }.execute();
    }
}
