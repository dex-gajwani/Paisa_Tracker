package com.example.paisatracker;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.StringTokenizer;

public class expense extends Fragment {

    EditText editText1 , editText2;
    Button button , button1;
    TextView textView;

    public expense() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        DatabaseReference mDatabase;
        mDatabase = FirebaseDatabase.getInstance().getReference();
        View view =  inflater.inflate(R.layout.fragment_expense, container, false);
        button = view.findViewById(R.id.send_button);
        editText1 = view.findViewById(R.id.expense_input);
        final int[] i = {1};
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TextUtils.isEmpty(editText1.getText())){
                    Toast.makeText(getActivity(), "ENTER AMOUNT", Toast.LENGTH_SHORT).show();
                }
                else{
                    int n = Integer.parseInt(editText1.getText().toString());
                    mDatabase.child("amount" + i[0]++).setValue(n + " EXPENSE");
                }
            }
        });
        textView = view.findViewById(R.id.text_view);
        button1 = view.findViewById(R.id.send_button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDatabase.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if(snapshot.exists()){
                            String data = snapshot.getValue().toString();
                            StringTokenizer st = new StringTokenizer(data);
                            int n = Integer.parseInt(st.nextToken());
                            data_storage.amount.add(n);
                            String s = st.nextToken();
                            data_storage.comment.add(s);
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });
        return view;
    }
}