package br.senac.es.conversor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    //Instanciando o altraEmCentimetros como int.
    int altraEmCentimetros = 0;


    //Sobreescrevendo o método onCreate
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Acessando o savedInstanceState
        super.onCreate(savedInstanceState);
        //Sei que o activity_main é a tela, provavelmente ele ta setando o que irei fazer abaixo na tela.
        setContentView(R.layout.activity_main);
        // Instanciando os TextView e SeekBar com os os ID que eu dei.
        final TextView textMetros = (TextView) findViewById(R.id.textMetros);
        final TextView textPes = (TextView) findViewById(R.id.textPes);
        final SeekBar skbMetros = (SeekBar) findViewById(R.id.skbMetros);
        // Falando o tamando máximo de seekbar.
        skbMetros.setMax(230);
        // onProgressChanged enquanto usado, onStartTrackingTouch quando começa a usar e onStopTrackingTouch quando para de usar.
        skbMetros.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            // o int progress é o nome que irei utilizar quando quiser fala que o seekbar está em progresso.
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // aqui estou falando que o altraEmCentimetros é = ao progress.
                altraEmCentimetros = progress;
                // instancio o texto como uma String e falo que o valor dele é o formataValorComDoisDigitos(progress / 100.0.
                String texto = formataValorComDoisDigitos(progress / 100.0);
                // instancio o texto mais ele mesmo recebendo um texto o "m" para enganar o sistema e mostrar o meu valor e o M de metros.
                texto += " m. ";
                // seto em txtMetros o meu texto para que ele mostre o resultado.
                textMetros.setText(texto);
                Double alturaempes = altraEmCentimetros / 30.48;
                String text1 = formataValorComDoisDigitos(alturaempes);
                text1 += " pé(s)";
                textPes.setText(text1);


            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // Depois que eu mexer no seekbar ele mostra a mensagem abaixo.
                textPes.setText("Toque em converter");

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
//        final Button button1 = (Button) findViewById(R.id.button1);
//        button1.setOnClickListener(new View.OnClickListener() {
//            // Nas duas linhas acima eu instanciei o Button com o ID que dei a ele e também falei que quando clicar ele vai seguir os comandos abaixo.
//            @Override
//            public void onClick(View view) {
//                // não sei o pq desses dois Viem acima
//                Double alturaEmPes = altraEmCentimetros / 30.48;
//                //Instancei em Double pois os valores são númeos quebrados, falei que a alturaEmPes é a altraEmCentimetros / 30.48
//                String texto = formataValorComDoisDigitos(alturaEmPes);
//                // Ao mesmo tempo que instancio o String texto eu dei o valor dele.
//                texto += " pé(s)";
//                // agora o valor do texto é ele mesmo mais o pé(s)
//                textPes.setText(texto);
//                //mostro o valor do texto no na tela, onde dei o Id textPes
//
//            }
//        });


    }

    private String formataValorComDoisDigitos(double valor) {
        return String.format(Locale.FRANCE, "%.2f", valor);
        //formata o formataValorComDoisDigitos para dois digitos, se nao o seekbar fica muito doido.
    }

}
