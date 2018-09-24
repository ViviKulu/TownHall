package com.example.vivianbabiryekulumba.townhall.fragments;


import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.vivianbabiryekulumba.townhall.PetitionActivity;
import com.example.vivianbabiryekulumba.townhall.R;
import com.example.vivianbabiryekulumba.townhall.database.PetitionListPresenter;

/**
 * A simple {@link Fragment} subclass.
 */
public class PetitionAddDialogFragment extends DialogFragment{

    PetitionListPresenter petitionListPresenter;

    public static PetitionAddDialogFragment newInstance() {
        PetitionAddDialogFragment petitionAddDialogFragment = new PetitionAddDialogFragment();
        return petitionAddDialogFragment;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View v = inflater.inflate(R.layout.petition_dialog, null);
        final TextInputEditText editTextTitle = v.findViewById(R.id.petition_title_edit_text);
        final TextInputEditText editTextContent = v.findViewById(R.id.petition_content_edit_text);

        builder.setTitle("Add Petition Title").setMessage("Add Petition Content").setView(v)
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setPositiveButton("Add", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        addPetitionDetail(editTextTitle.getText().toString(), editTextContent.getText().toString());
                    }
                });
        return builder.show();
    }

    public void addPetitionDetail(String petition_title, String petition_content) {
        ((PetitionActivity) getActivity()).petitionListPresenter.addPetition(petition_title, petition_content);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.petition_dialog, container, false);
    }

}
