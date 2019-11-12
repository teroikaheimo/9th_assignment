package com.example.a9th_assingment.room;

import android.annotation.SuppressLint;
import android.app.Application;
import android.os.AsyncTask;
import android.widget.Toast;

import androidx.annotation.NonNull;

import java.util.List;

public class ModelUser {
    private RepositoryUser mRepository;

    public ModelUser(@NonNull Application application) {
        this.mRepository = new RepositoryUser(application);
    }

    void insert(EntityUser user) {
        mRepository.insert(user);
    }


    @SuppressLint("StaticFieldLeak")
    void confirmLogin(final Toast failedToast, final String username, final String password) {
        new AsyncTask<Void, Void, List<EntityUser>>() {
            @Override
            protected List<EntityUser> doInBackground(Void... params) {
                //runs on background thread
                return mRepository.getUser(username, password);
            }

            @Override
            protected void onPostExecute(List<EntityUser> items) {
                //runs on main thread
                if (items.isEmpty()) {
                    failedToast.show();
                }
            }
        }.execute();
    }
}
