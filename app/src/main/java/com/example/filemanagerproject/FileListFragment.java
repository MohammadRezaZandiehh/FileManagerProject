package com.example.filemanagerproject;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.filemanagerproject.adapter.FileAdapter;

import java.io.File;
import java.util.Arrays;

public class FileListFragment extends Fragment {

    private String path;
    private FileAdapter fileAdapter;
    private RecyclerView recyclerView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        path = getArguments().getString("path");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_files, container, false);
        recyclerView = view.findViewById(R.id.rv_files);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));

        File currentFolder = new File(path);
        File[] files = currentFolder.listFiles();

        FileAdapter fileAdapter = new FileAdapter(Arrays.asList(files));
        recyclerView.setAdapter(fileAdapter);

        return view;
    }
}
