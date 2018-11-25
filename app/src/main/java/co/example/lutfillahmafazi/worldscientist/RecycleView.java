package co.example.lutfillahmafazi.worldscientist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecycleView extends AppCompatActivity {

    @BindView(R.id.myRecycle)
    RecyclerView myRecycle;

    String[] namaPenemu,detailPenemu,namaPenemuTeknologi,detailPenemuTeknologi;
    int[] gambarPenemu,gambarPenemuTeknologiTeknologi;

    AdapterWorld adapterWorld;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_view);
        ButterKnife.bind(this);

        namaPenemu = getResources().getStringArray(R.array.penemu_dunia);
        detailPenemu = getResources().getStringArray(R.array.detail_penemu_dunia);
        namaPenemuTeknologi = getResources().getStringArray(R.array.penemu_teknologi);
        detailPenemuTeknologi = getResources().getStringArray(R.array.detail_penemu_teknologi);

        gambarPenemu = new int[]{R.drawable.leonardo_davinci,R.drawable.nikola_tesla,R.drawable.thomas_edison,R.drawable.alexander_graham_bell,R.drawable.james_watt,
                R.drawable.wright_brother,R.drawable.benjamin_franklin,R.drawable.archimedes,R.drawable.galileo,R.drawable.tim_berners_lee};
        gambarPenemuTeknologiTeknologi = new int[]{R.drawable.ray_kurzweil,R.drawable.adam_osborne,R.drawable.al_jazari,R.drawable.denis_hayes,
                R.drawable.robert_watson,R.drawable.antonio_meucci};

        String penemu = getIntent().getStringExtra("penemu");
        Log.i("penemu",penemu);

        if (penemu.equals("dunia")){
            adapterWorld = new AdapterWorld(RecycleView.this,namaPenemu,detailPenemu,gambarPenemu);
        }else {
            adapterWorld = new AdapterWorld(RecycleView.this,namaPenemuTeknologi,detailPenemuTeknologi,gambarPenemuTeknologiTeknologi);
        }

        myRecycle.setHasFixedSize(true);
        myRecycle.setLayoutManager(new LinearLayoutManager(this));
        myRecycle.setAdapter(adapterWorld);
    }
}
