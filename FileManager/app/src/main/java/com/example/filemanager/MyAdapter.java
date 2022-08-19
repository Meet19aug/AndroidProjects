package com.example.filemanager;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.File;
import java.nio.file.Files;

// helps to set item inside the recycler view
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{
    Context context;
    File[] filesAndFolders;
    public MyAdapter(Context context, File[] filesAndFolders){
        this.context = context;
        this.filesAndFolders = filesAndFolders;
    }
    // Here We need to create layout for recycler so res->layout->rightClick->new->LayoutResourceFile
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_item, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        File selectedFile = filesAndFolders[position];
        holder.textView.setText(selectedFile.getName());
        if(selectedFile.isDirectory()){
            holder.imageView.setImageResource(R.drawable.ic_baseline_folder_24);
        }else{
            holder.imageView.setImageResource(R.drawable.ic_baseline_insert_drive_file_24);
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(selectedFile.isDirectory()){
                    Intent intent = new Intent(context, FileListActivity.class);
                    String path = selectedFile.getAbsolutePath();
                    intent.putExtra("path",path);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);
                }else{
                    //open the file if image
                    try {
                        Intent intent = new Intent();
                        intent.setAction(Intent.ACTION_VIEW);
                        String type = "image/*";
                        intent.setDataAndType(Uri.parse(selectedFile.getAbsolutePath()), type);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        context.startActivity(intent);
                    }catch(Exception e){
                        Toast.makeText(context.getApplicationContext(),"Cannot Open File",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                PopupMenu popupMenu = new PopupMenu(context,view);
                popupMenu.getMenu().add("DELETE");
                popupMenu.getMenu().add("MOVE");
                popupMenu.getMenu().add("RENAME");
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        if(menuItem.getTitle().equals("DELETE")){
                            boolean isDeleted = selectedFile.delete();
                            if(isDeleted){
                                Toast.makeText(context.getApplicationContext(), "Item Deleted",Toast.LENGTH_SHORT).show();
                                view.setVisibility(View.GONE);
                            }
                        }
                        if(menuItem.getTitle().equals("MOVE")){
                            Toast.makeText(context.getApplicationContext(), "Item Moved",Toast.LENGTH_SHORT).show();
                        }
                        if(menuItem.getTitle().equals("RENAME")){
                            Toast.makeText(context.getApplicationContext(), "Item Rename",Toast.LENGTH_SHORT).show();
                        }
                        return true;
                    }
                });
                popupMenu.show();
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return filesAndFolders.length;
    }

    public  class ViewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        ImageView imageView;
        public ViewHolder(View itemView) {
            super(itemView);
            textView =  itemView.findViewById(R.id.file_name_text_view);
            imageView = itemView.findViewById(R.id.icon_view);
        }
    }

}