package cl.desafiolatam.desafio1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Log_Main";
    private List<Integer> imagenes;
    private TextView tvTitle;
    private ImageButton replay;

    @BindView(R.id.textView) TextView textView;
    @BindView(R.id.imageViewLeft) ImageView imgLeft;
    @BindView(R.id.imageViewCenter) ImageView imgCenter;
    @BindView(R.id.imageViewRight) ImageView imgRight;
    @BindView(R.id.imageViewResult) ImageView imgResults;

    @OnClick({R.id.imageViewLeft, R.id.imageViewCenter, R.id.imageViewRight}) void submit() {
        // TODO call server...
        //Log.d(TAG, "Pasó por el onClick");
        entregarObsequio();
    }

    @OnClick(R.id.btnRePlay) void reiniciar() {
        imgResults.setVisibility(View.INVISIBLE);
        imgLeft.setVisibility(View.VISIBLE);
        imgCenter.setVisibility(View.VISIBLE);
        imgRight.setVisibility(View.VISIBLE);
        tvTitle.setText("Elige una de estas 3 cajas sorpresa y recibe un obsequio");

    }

    private void entregarObsequio() {
        Collections.shuffle(imagenes);
        imgResults.setImageResource(imagenes.get(0));
        imgResults.setVisibility(View.VISIBLE);
        imgLeft.setVisibility(View.INVISIBLE);
        imgCenter.setVisibility(View.INVISIBLE);
        imgRight.setVisibility(View.INVISIBLE);

        tvTitle.setText("Felicitaciones, has ganado un premio");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        iniciarVista();
        cargarImagenes();

    }

    private void iniciarVista() {
        tvTitle = findViewById(R.id.tvObsequio);
        replay = findViewById(R.id.btnRePlay);
    }

    private void cargarImagenes() {
        imagenes = new ArrayList<>();
        imagenes.add(R.drawable.ic_gift_beach);
        imagenes.add(R.drawable.ic_gift_music);
        imagenes.add(R.drawable.ic_gift_pizza);
        imagenes.add(R.drawable.ic_beber);
        imagenes.add(R.drawable.ic_malteada);
        imagenes.add(R.drawable.ic_pina_colada);
    }


}
