package sn.esmt.jobapp;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import sn.esmt.jobapp.httpconfig.Api;
import sn.esmt.jobapp.httpconfig.CVResponse;
import sn.esmt.jobapp.tools.MyAdapterCV;

public class VisualisationActivity extends AppCompatActivity {

    private ListView list;
    private ArrayList<CVResponse> cvs = new ArrayList<CVResponse>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = (ListView) findViewById(R.id.listcv);
        chargerListe();
    }

    public void chargerListe(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.1.8:8081") //URL de base de l'API
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        //Crée une instance de l'interface Api,
        //qui définit les méthodes pour les appels HTTP.
        Api api = retrofit.create(Api.class);

        //creation d'un objet Call pour l'appel à la méthode login() de l'interface Api.
        Call<ArrayList<CVResponse>> call = api.all();

        call.enqueue(new Callback<ArrayList<CVResponse>>() {
            @Override
            public void onResponse(Call<ArrayList<CVResponse>> call, Response<ArrayList<CVResponse>> response) {
                if (response.isSuccessful()) {
                    Log.d("Response :", response.body().get(0).getEmail());
                    response.body().stream().forEach(cvResponse -> cvs.add(cvResponse));
                    MyAdapterCV adpt = new MyAdapterCV(VisualisationActivity.this,cvs);

                    Log.d("Debuggade : ", cvs.get(0).getNom());
                    list.setAdapter(adpt);
                } else {
                    Log.d("error message exception", response.toString());

                }
            }

            @Override
            public void onFailure(Call<ArrayList<CVResponse>> call, Throwable t) {
                Log.d("Error : ", t.getMessage());
                //D/Error :: CLEARTEXT communication to 192.168.90.167 not permitted by network security policy
            }

        });

    }
}