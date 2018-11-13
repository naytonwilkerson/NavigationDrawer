package com.example.naytonwilkerson.navigationdrawer;


import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import com.example.naytonwilkerson.navigationdrawer.model.Aluno;
import com.example.naytonwilkerson.navigationdrawer.services.InterfaceDeServico;
import com.example.naytonwilkerson.navigationdrawer.services.RetrofitService;

import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ActivityPadrao extends Activity {

    ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.padrao);
        lista = (ListView) findViewById(R.id.listview_listadealunos);
        imprimeLista();
    }

    private void imprimeLista() {

        InterfaceDeServico services = RetrofitService.getServico();
        Call<List<Aluno>> call = services.webserviceNotasDeAlunos();

        call.enqueue(new Callback<List<Aluno>>() {
            @Override
            public void onResponse(Call<List<Aluno>> call, Response<List<Aluno>> response) {
                List<Aluno> listaAlunosNotas = response.body();
                lista.setAdapter(new ListaAdapter(ActivityPadrao.this, listaAlunosNotas));
            }

            @Override
            public void onFailure(Call<List<Aluno>> call, Throwable t) {
                Log.i("debug", t.getMessage());
            }
        });
    }
}
