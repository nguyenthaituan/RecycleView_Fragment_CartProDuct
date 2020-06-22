package vn.edu.ntu.fragmentapp.btfargment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import vn.edu.ntu.fragmentapp.R;
import vn.edu.ntu.fragmentapp.controller.IController;
import vn.edu.ntu.fragmentapp.model.Product;

public class BuyProductFragment extends Fragment {

    EditText edtTEN, edtGIA, edtMOTA;
    Button btnADD;
    NavController navController;

    public BuyProductFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_buy_product,container,false);
        addViews(view);
        addActions();
        navController = NavHostFragment.findNavController(BuyProductFragment.this);
        ((MainActivity)getActivity()).navcontroller = navController;
        return view;
    }

    private void addViews(View view){
        edtTEN = view.findViewById(R.id.edtNAME);
        edtGIA = view.findViewById(R.id.edtPRICE);
        edtMOTA = view.findViewById(R.id.edtDESC);
        btnADD = view.findViewById(R.id.btnADD);
    }

    private void addActions(){

        btnADD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = edtTEN.getText().toString();
                int gia = Integer.parseInt(edtGIA.getText().toString());
                String mota = edtMOTA.getText().toString();
                Product p = new Product();

                p.setName(name);
                p.setPrice(gia);
                p.setDesc(mota);

                edtTEN.setText("");
                edtGIA.setText("");
                edtMOTA.setText("");

                Toast.makeText( BuyProductFragment.this.getActivity(),"Đã update",Toast.LENGTH_SHORT).show();

            }
        });

    }


}

