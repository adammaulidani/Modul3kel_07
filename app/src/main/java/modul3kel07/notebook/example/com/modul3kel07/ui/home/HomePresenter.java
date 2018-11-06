package modul3kel07.notebook.example.com.modul3kel07.ui.home;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

import modul3kel07.notebook.example.com.modul3kel07.data.model.DataCar;
import modul3kel07.notebook.example.com.modul3kel07.data.network.RetrofitClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomePresenter {
    private HomeView homeView;

    public HomePresenter (HomeView homeView){
        this.homeView = homeView;
    }

    public void getAllCar(){
        final String tag = "Home-getAllCar";
        RetrofitClient.getInstance()
                .getApi()
                .getAllCar()
                .enqueue(new Callback<JsonObject>() {
                    @Override
                    public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                        if (response.isSuccessful()){
                            JsonObject body = response.body();
                            JsonArray array = body.get("result").getAsJsonArray();
                            Type type = new TypeToken<List<DataCar>>(){}.getType();
                            List<DataCar> dataCars = new Gson().fromJson(array, type);
                            homeView.successShowCar(dataCars);
                            Log.d(tag, response.body().toString());
                        } else {
                            homeView.failedShowCar("Maaf terjadi kesalahan");
                            Log.d(tag, response.errorBody().toString());
                        }
                    }

                    @Override
                    public void onFailure(Call<JsonObject> call, Throwable t) {
                        homeView.failedShowCar("Maaf terjadi kesalahan");
                        Log.d(tag, t.getMessage().toString());
                    }
                });
    }
}

