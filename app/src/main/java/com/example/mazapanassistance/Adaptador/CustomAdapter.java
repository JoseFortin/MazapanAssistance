package com.example.mazapanassistance.Adaptador;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mazapanassistance.R;

import java.util.ArrayList;
import java.util.concurrent.CyclicBarrier;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    Context context;
    ArrayList Id_Cursos, Nombre_Curso;
    CustomAdapter customAdapter;

    public CustomAdapter(Context context, ArrayList Id_Cursos, ArrayList Nombre_Curso){
        this.context = context;
        this.Id_Cursos = Id_Cursos;
        this.Nombre_Curso=Nombre_Curso;
    }




    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.list_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.txtObjeto.setText(String.valueOf(Nombre_Curso.get(position)));
    }

    @Override
    public int getItemCount() {
        return Nombre_Curso.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView txtObjeto;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txtObjeto = itemView.findViewById(R.id.txtObjeto);
        }
    }
}
