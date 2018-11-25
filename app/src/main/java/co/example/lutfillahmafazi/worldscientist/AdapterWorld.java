package co.example.lutfillahmafazi.worldscientist;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class AdapterWorld extends RecyclerView.Adapter<AdapterWorld.ViewHolder>{

    Context context;
    String[] namaPenemu,detailPenemu;
    int[] gambarPenemu;

    public AdapterWorld(Context context, String[] namaPenemu, String[] detailPenemu, int[] gambarPenemu) {
        this.context = context;
        this.namaPenemu = namaPenemu;
        this.detailPenemu = detailPenemu;
        this.gambarPenemu = gambarPenemu;
    }

    @NonNull
    @Override
    public AdapterWorld.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_detail,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterWorld.ViewHolder viewHolder,final int i) {
        viewHolder.txtPenemu.setText(namaPenemu[i]);
        Glide.with(context).load(gambarPenemu[i]).into(viewHolder.imgGambarPenemu);

        viewHolder.btnDetailPenemu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,DetailActivity.class);

                intent.putExtra("np",namaPenemu[i]);
                intent.putExtra("dp",detailPenemu[i]);
                intent.putExtra("gp",gambarPenemu[i]);

                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return gambarPenemu.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtPenemu;
        ImageView imgGambarPenemu;
        Button btnDetailPenemu;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtPenemu = itemView.findViewById(R.id.txtPenemu);
            imgGambarPenemu = itemView.findViewById(R.id.imgPenemu);
            btnDetailPenemu = itemView.findViewById(R.id.btnDetailPenemu);
        }
    }
}
